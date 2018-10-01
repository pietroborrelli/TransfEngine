package it.polimi.service;

import java.util.List;

import it.polimi.mapper.viewcomponent.list.Descriptor;

public interface ViewComponentService {
	public List<?> loadViewComponentsFromFile(String folderPath);

}
