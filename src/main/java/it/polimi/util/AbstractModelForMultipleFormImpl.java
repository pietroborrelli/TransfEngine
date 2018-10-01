package it.polimi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import it.polimi.domain.abstractmodel.Collection;
import it.polimi.mapper.datamodel.DataModel;
import it.polimi.mapper.datamodel.DataModel.Entity;
import it.polimi.mapper.viewcomponent.multipleform.Descriptor;
import it.polimi.service.SelectorServiceImpl;

@Component
public class AbstractModelForMultipleFormImpl implements AbstractModel{

		@Value("${input.path.viewcomponent.selector}")
		private String inputPathSelector;
		
		@Autowired
		private TransformationMultipleFormImpl transformationMultipleFormImpl;

		@Autowired
		private DataModelTransformation dataModelTransformation;

		@Autowired
		private SelectorServiceImpl viewComponentSelectorService;
		
		private Collection collection;
		private DataModel dataModel;
		private Descriptor viewComponentMultipleForm;


		public AbstractModelForMultipleFormImpl() {
		}

		/*
		 * collection dependent by view component
		 * @return Collection with name set from view component name
		 * @see it.polimi.util.AbstractModel#createCollection()
		 */
		@Override
		public Collection createCollection() {
			this.collection = new Collection();
			collection.setName(transformationMultipleFormImpl.getCollectionName(viewComponentMultipleForm));
			return collection;
		}

		/*
		 * block dependent by view component (input fields)
		 * @return a new Collection with block set. Name of the block retrieved from data model
		 * @see it.polimi.util.AbstractModel#createBlock()
		 */
		@Override
		public Collection createBlock() {
			
			//get selector. Information bring here, needed to build block
			//@TODO: now can handle only one selector at a time
			it.polimi.mapper.viewcomponent.selector.Descriptor viewComponentSelector = (it.polimi.mapper.viewcomponent.selector.Descriptor) viewComponentSelectorService.loadViewComponentsFromFile(inputPathSelector).get(0);
			
			
			// get info on key from view component
			collection.getBlock().setKey(transformationMultipleFormImpl.getBlockKey(viewComponentSelector));
			// then navigate data model to set key names and sort ordering
			String entityId = collection.getBlock().getKey().getIdEntity();
			Entity entity = dataModelTransformation.retrieveEntityById(entityId, dataModel);
			
			collection.getBlock().getKey().getPartitionKeys().stream()
					.forEach(pk -> pk.setName(dataModelTransformation.retrievePartitionKeyName(pk, dataModel)));
			
			collection.getBlock().getKey().getSortKeys().stream()
					.forEach(sk -> sk.setOrdering(transformationMultipleFormImpl.setOrderingSortkey(sk.getReferenceAttributeEntity(), entity ,viewComponentSelector.getQuery().getHQL())));
			collection.getBlock().getKey().getSortKeys().stream()
					.forEach(sk -> sk.setName(dataModelTransformation.retrieveSortKeyName(sk, entityId, dataModel)));
			return collection;
		}

		/*
		 * entries dependent by view component (output fields)
		 * @return a new Collection with entries set. Name of the entries retrieved from data model
		 */
		/* (non-Javadoc)
		 * @see it.polimi.util.AbstractModel#createEntries()
		 */
		@Override
		public Collection createEntries() {
			// get output field from view component
			collection.getBlock().setEntries(transformationMultipleFormImpl.getEntries(viewComponentMultipleForm));
			// then navigate data model to set name and type of entries
			collection.getBlock().getEntries().stream().forEach(e -> e.setName(
					dataModelTransformation.retrieveEntryName(e, collection.getBlock().getKey().getIdEntity(), dataModel)));
			collection.getBlock().getEntries().stream().forEach(e -> e.setType(
					dataModelTransformation.retrieveEntryType(e, collection.getBlock().getKey().getIdEntity(), dataModel)));

			return collection;
		}

		@Override
		public Collection getCollection() {
			
			return this.collection;
		}

		@Override
		public DataModel getDataModel() {
			
			return this.dataModel;
		}

		@Override
		public void setDataModel(DataModel dataModel) {
			this.dataModel=dataModel;
			
		}

		public Descriptor getViewComponentMultipleForm() {
			return viewComponentMultipleForm;
		}

		public void setViewComponentMultipleForm(Descriptor viewComponentMultipleForm) {
			this.viewComponentMultipleForm = viewComponentMultipleForm;
		}


}
