package it.polimi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polimi.mapper.viewcomponent.list.Descriptor;
import it.polimi.repository.ViewComponentRepositoryXML;

@Service
public class ListServiceImpl implements ViewComponentService{

	@Autowired
	ViewComponentRepositoryXML viewComponentRepositoryXML;
	
	@Override
	public List<Descriptor> loadViewComponentsFromFile(String folderPath) {
		return viewComponentRepositoryXML.loadListViewComponentsFromFile(folderPath);
	}

}
