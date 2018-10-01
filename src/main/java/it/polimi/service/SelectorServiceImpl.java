package it.polimi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.polimi.mapper.viewcomponent.selector.Descriptor;
import it.polimi.repository.ViewComponentRepositoryXML;

@Component
public class SelectorServiceImpl implements ViewComponentService {

	@Autowired
	ViewComponentRepositoryXML viewComponentRepositoryXML;
	
	@Override
	public List<Descriptor> loadViewComponentsFromFile(String folderPath) {
		return viewComponentRepositoryXML.loadSelectorViewComponentsFromFile(folderPath);
	}

}
