package it.polimi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polimi.mapper.datamodel.DataModel;
import it.polimi.repository.DataModelRepositoryXML;

@Service
public class DataModelServiceImpl implements DataModelService {

	@Autowired
	private DataModelRepositoryXML dataModelRepositoryXML;
	
	@Override
	public DataModel loadDataModelFromFile(String path) {
		
		return dataModelRepositoryXML.loadDataModel(path);
	}

}
