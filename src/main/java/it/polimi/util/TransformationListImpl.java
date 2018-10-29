package it.polimi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.polimi.domain.abstractmodel.Entry;
import it.polimi.domain.enumeration.Ordering;
import it.polimi.domain.key.PartitionKey;
import it.polimi.domain.key.PrimaryKey;
import it.polimi.domain.key.SortKey;
import it.polimi.mapper.datamodel.DataModel;
import it.polimi.mapper.viewcomponent.list.Descriptor;
import it.polimi.mapper.viewcomponent.list.Descriptor.SortAttributes.Attribute;

@Component
public class TransformationListImpl implements TransformationViewComponent {

	public final static String RELATIONSHIP_CONDITION = "rcond";
	public final static String KEY_CONDITION = "kcond";

	/*
	 * Get name of collection. Given by the name of the view component
	 * @param viewComponent
	 * @return name of the collection
	 * @see it.polimi.util.TransformationViewComponent#getCollectionName(it.polimi.mapper.viewcomponent.list.Descriptor)
	 */
	@Override
	public String getCollectionName(Object viewComponent) {
		Descriptor componentList = (Descriptor) viewComponent;
		return componentList.getName();

	}


	
	/*
	 * Get block key. Look for Key condition or Relationship condition as block key
	 * @param viewComponent
	 * @return PrimaryKey
	 * @see it.polimi.util.TransformationViewComponent#getBlockKey(it.polimi.mapper.viewcomponent.list.Descriptor)
	 */
	@Override
	public PrimaryKey getBlockKey(Object viewComponent) {
		Descriptor componentList = (Descriptor) viewComponent;
		
		List<PartitionKey> partitionKeys = new ArrayList<PartitionKey>();
		List<SortKey> sortKeys = new ArrayList<SortKey>();
		Descriptor.Query.Input queryInput = null;

		for (Object obj : componentList.getQuery().getInputOrOutputOrHQL()) {

			// reflection on Descriptor.Query.Input
			if (obj.getClass().equals(Descriptor.Query.Input.class)) {

				queryInput = (Descriptor.Query.Input) obj;
				System.out.println("Adding Keys (input param) " + queryInput.getParam());

				// get Relationship conditions and Key conditions as partition key
				if (queryInput.getParam().contains(RELATIONSHIP_CONDITION)
						|| (queryInput.getParam().contains(KEY_CONDITION)))
					partitionKeys.add(new PartitionKey(queryInput.getParam()));
				else
					// get Attribute condition as sort key
					sortKeys.add(new SortKey(queryInput.getParam(), queryInput.getAttribute(),
							setOrderingSortkey(queryInput.getAttribute(), componentList)));
			}
		}

		return new PrimaryKey(partitionKeys, sortKeys.stream().distinct().collect(Collectors.toList()), // avoid
																										// duplicates
				componentList.getQuery().getEntity());
	}

	/*
	 * @param nameSortKey
	 * @param viewComponent
	 * @return proper ordering of the sort keys (if user has specified an ordering in 'sort attribute' webratio) else default value ASC
	 */
	public Ordering setOrderingSortkey(String nameSortKey, Object viewComponent) {
		Descriptor componentList = (Descriptor) viewComponent;

		Ordering ordering = null;

		for (Attribute attribute : componentList.getSortAttributes().getAttribute()) {

			// check if sortkey have been specified an ordering
			if (nameSortKey.equals(attribute.getId())) {
				if (attribute.getOrder().equals(Ordering.DESCENDING.value()))
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
	
	/* (non-Javadoc)
	 * @see it.polimi.util.TransformationViewComponent#getEntries(it.polimi.mapper.viewcomponent.list.Descriptor)
	 */
	@Override
	public List<Entry> getEntries(Object viewComponent) {
		Descriptor componentList = (Descriptor) viewComponent;

		List<Entry> entries = new ArrayList<Entry>();
		Descriptor.Query.Output queryOutput = null;

		for (Object obj : componentList.getQuery().getInputOrOutputOrHQL()) {

			// reflection on Descriptor.Query.Output
			if (obj.getClass().equals(Descriptor.Query.Output.class)) {

				queryOutput = (Descriptor.Query.Output) obj;
				System.out.println("Adding Attribute (output param) " + queryOutput.getId());
				entries.add(new Entry(queryOutput.getId()));
			}
		
		}
		return entries;
	}



	@Override
	public List<Entry> findEntriesToAggregate(Object viewComponent, DataModel dataModel) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Entry> updateEntriesOfCollection(List<Entry> aggregateEntries, List<Entry> collectionEntries) {
		// TODO Auto-generated method stub
		return null;
	}
}