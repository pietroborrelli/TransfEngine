package it.polimi.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import it.polimi.mapper.viewcomponent.list.Descriptor;

@Repository
public class ViewComponentRepositoryXML {
	
		/*
		 * Get all list view components from the folder
		 */
	public List<Descriptor> loadListViewComponentsFromFile(String folderPath) {
		Descriptor listViewComponent = null;
		List<Descriptor> listViewComponents = new ArrayList<Descriptor>();

		try {

			System.out.println("Percorso " + folderPath + "...");
			File folder = new File(folderPath);
			
			if (!folder.exists() || !folder.isDirectory() || folder==null)
				return null;
			
			File[] files = folder.listFiles();
			for (File file : files){
				
				System.out.println("Accedo al file " + folderPath + file.getName());
				Unmarshaller unmarshaller = JAXBContext.newInstance(Descriptor.class).createUnmarshaller();
				listViewComponent = (Descriptor) unmarshaller.unmarshal(file);
				System.out.println("ViewComponent "+ listViewComponent.getName() +" caricato!");
				listViewComponents.add(listViewComponent);
	        }

		} catch (JAXBException e) {
			System.err.println("La procedura si è interrotta in fase di unmarshalling : ");
			e.printStackTrace();
			return null;
		}
		
		return listViewComponents;

	}

	public List<it.polimi.mapper.viewcomponent.multipleform.Descriptor> loadMultipleFormViewComponentsFromFile(String folderPath) {
		it.polimi.mapper.viewcomponent.multipleform.Descriptor multipleFormViewComponent = null;
		List<it.polimi.mapper.viewcomponent.multipleform.Descriptor> multipleFormViewComponents = new ArrayList<it.polimi.mapper.viewcomponent.multipleform.Descriptor>();

		try {

			System.out.println("Percorso " + folderPath + "...");
			File folder = new File(folderPath);
			
			if (!folder.exists() || !folder.isDirectory() || folder==null)
				return null;

			File[] files = folder.listFiles();
			for (File file : files){
				
				System.out.println("Accedo al file " + folderPath + file.getName());
				Unmarshaller unmarshaller =  JAXBContext.newInstance(it.polimi.mapper.viewcomponent.multipleform.Descriptor.class).createUnmarshaller();
				multipleFormViewComponent = (it.polimi.mapper.viewcomponent.multipleform.Descriptor) unmarshaller.unmarshal(file);
				System.out.println("ViewComponent "+ multipleFormViewComponent.getName() +" caricato!");
				multipleFormViewComponents.add(multipleFormViewComponent);
	        }

		} catch (JAXBException e) {
			System.err.println("La procedura si è interrotta in fase di unmarshalling : ");
			e.printStackTrace();
			return null;
		}
		
		return multipleFormViewComponents;
	}

	public List<it.polimi.mapper.viewcomponent.selector.Descriptor> loadSelectorViewComponentsFromFile(
			String folderPath) {
		it.polimi.mapper.viewcomponent.selector.Descriptor selectorViewComponent = null;
		List<it.polimi.mapper.viewcomponent.selector.Descriptor> selectorViewComponents = new ArrayList<it.polimi.mapper.viewcomponent.selector.Descriptor>();

		try {

			System.out.println("Percorso " + folderPath + "...");
			File folder = new File(folderPath);
			
			if (!folder.exists() || !folder.isDirectory() || folder==null)
				return null;
			
			File[] files = folder.listFiles();
			for (File file : files){
				
				System.out.println("Accedo al file " + folderPath + file.getName());
				Unmarshaller unmarshaller =  JAXBContext.newInstance(it.polimi.mapper.viewcomponent.selector.Descriptor.class).createUnmarshaller();
				selectorViewComponent = (it.polimi.mapper.viewcomponent.selector.Descriptor) unmarshaller.unmarshal(file);
				System.out.println("ViewComponent "+ selectorViewComponent.getName() +" caricato!");
				selectorViewComponents.add(selectorViewComponent);
	        }

		} catch (JAXBException e) {
			System.err.println("La procedura si è interrotta in fase di unmarshalling : ");
			e.printStackTrace();
			return null;
		}
		
		return selectorViewComponents;
	}
}
