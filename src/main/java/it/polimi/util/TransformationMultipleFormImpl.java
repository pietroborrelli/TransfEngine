package it.polimi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.polimi.domain.abstractmodel.Entry;
import it.polimi.domain.enumeration.Ordering;
import it.polimi.domain.key.PartitionKey;
import it.polimi.domain.key.PrimaryKey;
import it.polimi.domain.key.SortKey;
import it.polimi.mapper.datamodel.DataModel;
import it.polimi.mapper.datamodel.DataModel.Entity;
import it.polimi.mapper.datamodel.DataModel.Entity.Attribute;
import it.polimi.mapper.viewcomponent.multipleform.Descriptor;
import it.polimi.mapper.viewcomponent.selector.Descriptor.Query.HQL;

@Component
public class TransformationMultipleFormImpl implements TransformationViewComponent{
	
	public final static String RELATIONSHIP_CONDITION = "rcond";
	public final static String KEY_CONDITION = "kcond";
	
	@Autowired
	DataModelTransformation dataModelTransformation;
	
	@Override
	public String getCollectionName(Object viewComponent) {
		Descriptor componentList = (Descriptor) viewComponent;
		return componentList.getName();
	}

	@Override
	public PrimaryKey getBlockKey(Object viewComponent) {
			it.polimi.mapper.viewcomponent.selector.Descriptor componentSelector = (it.polimi.mapper.viewcomponent.selector.Descriptor) viewComponent;
			
			List<PartitionKey> partitionKeys = new ArrayList<PartitionKey>();
			List<SortKey> sortKeys = new ArrayList<SortKey>();
			it.polimi.mapper.viewcomponent.selector.Descriptor.Query.Input queryInput = null;

			for (Object obj : componentSelector.getQuery().getInput()) {

				// reflection on Descriptor.Query.Input
				if (obj.getClass().equals(it.polimi.mapper.viewcomponent.selector.Descriptor.Query.Input.class)) {

					queryInput = (it.polimi.mapper.viewcomponent.selector.Descriptor.Query.Input) obj;
					System.out.println("Adding Keys (input param) " + queryInput.getParam());

					// get Relationship conditions and Key conditions as partition key
					if (queryInput.getParam().contains(RELATIONSHIP_CONDITION)
							|| (queryInput.getParam().contains(KEY_CONDITION)))
						partitionKeys.add(new PartitionKey(queryInput.getParam()));
					else
						// get Attribute condition as sort key
						sortKeys.add(new SortKey(queryInput.getParam(), queryInput.getAttribute(), null ));
				}
			}

			return new PrimaryKey(partitionKeys, sortKeys.stream().distinct().collect(Collectors.toList()), // avoid
																											// duplicates
					componentSelector.getQuery().getEntity());
		}
	
	

	@Override
	public List<Entry> getEntries(Object viewComponent) {
		Descriptor componentMultipleForm = (Descriptor) viewComponent;

		List<Entry> entries = new ArrayList<Entry>();

		for (Descriptor.FormFields.Field fieldOutput : componentMultipleForm.getFormFields().getField()) {

			if (fieldOutput.getAttributeId()!=null) {
				System.out.println("Adding Attribute (output param) " + fieldOutput.getAttributeId());
				entries.add(new Entry(fieldOutput.getAttributeId()));
			}
		
		}
		return entries;
	}

	@Override
	public Ordering setOrderingSortkey(String idSortKey, Object hql){
		 return null;
	}

	public Ordering setOrderingSortkey(String referenceAttributeEntity, Entity entity, HQL hql) {
		it.polimi.mapper.viewcomponent.selector.Descriptor.Query.HQL hqlQuery = (it.polimi.mapper.viewcomponent.selector.Descriptor.Query.HQL) hql;

		Ordering ordering = null;
		System.out.println("Looking for ordering, field " + entity.getName() + "." + referenceAttributeEntity);
				
		for (Attribute attribute : entity.getAttribute()) {

			// check if sortkey have been specified an ordering in hql query of selector
			if (referenceAttributeEntity.equals(attribute.getId())) {
				//get position of desc / asc word inside the query
				int startPosition = hqlQuery.getContent().toString().indexOf(attribute.getName()) + 1 + attribute.getName().length();
				if (hqlQuery.getContent().toString().charAt(startPosition) == 'd')
					ordering = Ordering.DESCENDING;
				else
					ordering = Ordering.ASCENDING;
				// exit if ordering found
				break;
			} else {
				// default ordering ASC
				ordering = Ordering.ASCENDING;
			}

		}
		return ordering;
	}
	
	/*
	 * Get output fields of the selector that are passed to the form (not entity based) to be rendered.   
	 * and return them
	 */
	@Override
	public List<Entry> findEntriesToAggregate(Object viewComponent, DataModel dataModel) {
		String name = "";
		String id ="";
		it.polimi.mapper.viewcomponent.selector.Descriptor componentSelector = (it.polimi.mapper.viewcomponent.selector.Descriptor) viewComponent;
		it.polimi.mapper.viewcomponent.selector.Descriptor.Query.Output queryOutput = null;
		List<Entry> entries = new ArrayList<>();
		System.out.println("Searching entries to aggregate for reading access path by Selector "  + componentSelector.getName());
		
		for (Object obj : componentSelector.getQuery().getOutput()) {

			// reflection on Descriptor.Query.Output
			if (obj.getClass().equals(it.polimi.mapper.viewcomponent.selector.Descriptor.Query.Output.class)) {

				queryOutput = (it.polimi.mapper.viewcomponent.selector.Descriptor.Query.Output) obj;
				System.out.println("Found an entry that can be aggregated: " + queryOutput.getName());
				
				name = queryOutput.getName();
				id = queryOutput.getId();
				//if there is default value oid for primary key can raise ononimie problems, so updated always the pk
				if (queryOutput.getName().equals("oid")) {
					Entity entity = dataModelTransformation.retrieveEntityById(componentSelector.getQuery().getEntity(), dataModel);
					name = entity.getName().toLowerCase()+"_oid";
				}
				
				entries.add(new Entry(id,name));
			}
		}

		return entries;
	}
	
	/*
	 * Get output fields of the selector that are passes to the form (not entity based) to be rendered.   
	 * @input two lists, 
	 * @return collectionEntries without single entries that have been aggregated
	 */
	@Override
	public List<Entry> updateEntriesOfCollection(List<Entry> aggregateEntries, List<Entry> collectionEntries) {
		boolean found = false;
		Entry aggregatedEntry = new Entry();
		aggregatedEntry.setId("");
		aggregatedEntry.setName("");
		
		for (Entry e : collectionEntries) {
			for (Entry e2 : aggregateEntries) {
				
				if (e.equals(e2)) {
					collectionEntries.remove(e);
				}
			}
		}
		//concatenate id and names
		for (Entry e : aggregateEntries) {
			aggregatedEntry.concatenateId(e.getId());
			aggregatedEntry.concatenateName(e.getName());
		}
		//remove last 2 characters
		aggregatedEntry.setName(aggregatedEntry.getName().substring(0, aggregatedEntry.getName().length() - 2));
		aggregatedEntry.setId(aggregatedEntry.getId().substring(0, aggregatedEntry.getId().length() - 2));
		
		//default type for aggregates is string/text
		aggregatedEntry.setType("string");
		collectionEntries.add(aggregatedEntry);
		
		return collectionEntries;
	}
	
}
