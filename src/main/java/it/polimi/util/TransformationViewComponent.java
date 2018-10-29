package it.polimi.util;

import java.util.List;

import it.polimi.domain.abstractmodel.Entry;
import it.polimi.domain.enumeration.Ordering;
import it.polimi.domain.key.PrimaryKey;
import it.polimi.mapper.datamodel.DataModel;
import it.polimi.mapper.viewcomponent.list.Descriptor;
import it.polimi.mapper.viewcomponent.list.Descriptor.SortAttributes.Attribute;

public interface TransformationViewComponent {

	/*
	 * Get name of collection. Given by the name of the view component
	 * @param viewComponent
	 * @return name of the collection
	 */
	String getCollectionName(Object viewComponent);

	/*
	 * Get block key. Look for Key condition or Relationship condition as block key
	 * @param viewComponent
	 * @return PrimaryKey
	 */
	PrimaryKey getBlockKey(Object  viewComponent);

	/**
	 * @param viewComponent
	 * @return list of entries
	 */
	List<Entry> getEntries(Object viewComponent);
	
	/*
	 * @param nameSortKey
	 * @param viewComponent
	 * @return proper ordering of the sort keys (if user has specified an ordering in 'sort attribute' webratio) else default value ASC
	 */
	Ordering setOrderingSortkey(String nameSortKey, Object viewComponent);

	/*
	 * @param viewComponent selector
	 * @return entries read together that may be aggregate (need check on write paths)
	 */
	List<Entry> findEntriesToAggregate(Object viewComponent, DataModel dataModel);
	/*
	 * @param two lists of entries
	 * @return the updated list with entries aggregated and not aggregated
	 */
	List<Entry> updateEntriesOfCollection(List<Entry> aggregateEntries, List<Entry> collectionEntries);


	

}