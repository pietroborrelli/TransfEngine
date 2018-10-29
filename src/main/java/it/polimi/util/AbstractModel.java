package it.polimi.util;

import it.polimi.domain.abstractmodel.Collection;
import it.polimi.mapper.datamodel.DataModel;

public interface AbstractModel {

	/*
	 * collection dependent by view component
	 * @return Collection with name set from view component name
	 */
	Collection createCollection();

	/*
	 * block dependent by view component (input fields)
	 * @return a new Collection with block set. Name of the block retrieved from data model
	 */
	Collection createBlock();

	/*
	 * entries dependent by view component (output fields)
	 * @return a new Collection with entries set. Name of the entries retrieved from data model
	 */
	Collection createEntries();

	/*
	 * reading access paths given by the structure of view components and selectors
	 */
	Collection evaluateReadingAccessPaths();
	
	
	Collection getCollection();

	DataModel getDataModel();

	void setDataModel(DataModel dataModel);

}