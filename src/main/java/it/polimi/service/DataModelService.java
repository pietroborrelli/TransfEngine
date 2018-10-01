package it.polimi.service;

import it.polimi.mapper.datamodel.DataModel;

public interface DataModelService {

	public DataModel loadDataModelFromFile(String path);
}
