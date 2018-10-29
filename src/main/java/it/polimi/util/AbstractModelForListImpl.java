package it.polimi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.polimi.domain.abstractmodel.Collection;
import it.polimi.domain.abstractmodel.Entry;
import it.polimi.domain.key.PartitionKey;
import it.polimi.domain.key.SortKey;
import it.polimi.mapper.datamodel.DataModel;
import it.polimi.mapper.viewcomponent.list.Descriptor;

@Component
public class AbstractModelForListImpl implements AbstractModel {

	@Autowired
	private TransformationListImpl transformationList;

	@Autowired
	private DataModelTransformation dataModelTransformation;

	private Collection collection;
	private DataModel dataModel;
	private Descriptor viewComponentList;

	public AbstractModelForListImpl() {
	}

	/*
	 * collection dependent by view component
	 * @return Collection with name set from view component name

	 * @see it.polimi.util.AbstractModel#createCollection()
	 */
	@Override
	public Collection createCollection() {
		this.collection = new Collection();
		collection.setName(transformationList.getCollectionName(viewComponentList));
		return collection;
	}

	/*
	 * block dependent by view component (input fields)
	 * @return a new Collection with block set. Name of the block retrieved from data model
	 * @see it.polimi.util.AbstractModel#createBlock()
	 */
	@Override
	public Collection createBlock() {
		// get info on key from view component
		collection.getBlock().setKey(transformationList.getBlockKey(viewComponentList));
		// then navigate data model to set key names and types
		String entity = collection.getBlock().getKey().getIdEntity();
		
		collection.getBlock().getKey().getPartitionKeys().stream()
				.forEach(pk -> pk.setName(dataModelTransformation.retrievePartitionKeyName(pk, dataModel)));
		collection.getBlock().getKey().getPartitionKeys().stream()
			.forEach(pk -> pk.setType(dataModelTransformation.retrievePartitionKeyType(pk, dataModel)));
		
		collection.getBlock().getKey().getSortKeys().stream()
				.forEach(sk -> sk.setName(dataModelTransformation.retrieveSortKeyName(sk, entity, dataModel)));
		collection.getBlock().getKey().getSortKeys().stream()
				.forEach(sk -> sk.setType(dataModelTransformation.retrieveSortKeyType(sk, entity, dataModel)));
		return collection;
	}

	/*
	 * entries dependent by view component (output fields)
	 * @return a new Collection with entries set. Name of the entries retrieved from data model
	 * @see it.polimi.util.AbstractModel#createEntries()
	 */
	@Override
	public Collection createEntries() {
		// get output field from view component
		collection.getBlock().setEntries(transformationList.getEntries(viewComponentList));
		// then navigate data model to set name and type of entries
		collection.getBlock().getEntries().stream().forEach(e -> e.setName(
				dataModelTransformation.retrieveEntryName(e, collection.getBlock().getKey().getIdEntity(), dataModel)));
		collection.getBlock().getEntries().stream().forEach(e -> e.setType(
				dataModelTransformation.retrieveEntryType(e, collection.getBlock().getKey().getIdEntity(), dataModel)));
		
		//add also entry by partition key
		for (PartitionKey pk : collection.getBlock().getKey().getPartitionKeys())
			collection.getBlock().addEntry(new Entry (pk.getId().substring(pk.getId().lastIndexOf(".") + 1),pk.getName(),pk.getType()));
		
		//add also entry by sort key
		for (SortKey sk : collection.getBlock().getKey().getSortKeys())
			collection.getBlock().addEntry(new Entry (sk.getId().substring(sk.getId().lastIndexOf(".") + 1),sk.getName(),sk.getType()));
				
		return collection;
	}

	
	@Override
	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	@Override
	public DataModel getDataModel() {
		return dataModel;
	}

	@Override
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public Descriptor getViewComponentList() {
		return viewComponentList;
	}

	public void setViewComponentList(Descriptor viewComponentList) {
		this.viewComponentList = viewComponentList;
	}

	public TransformationListImpl getTransformationList() {
		return transformationList;
	}

	public void setTransformationList(TransformationListImpl transformationList) {
		this.transformationList = transformationList;
	}

	@Override
	public Collection evaluateReadingAccessPaths() {
		// TODO Auto-generated method stub
		return null;
	}




}
