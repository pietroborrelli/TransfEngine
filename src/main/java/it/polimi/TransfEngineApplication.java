package it.polimi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import it.polimi.domain.abstractmodel.Collection;
import it.polimi.mapper.datamodel.DataModel;
import it.polimi.mapper.viewcomponent.list.Descriptor;
import it.polimi.parser.Parser;
import it.polimi.service.DataModelService;
import it.polimi.service.ListServiceImpl;
import it.polimi.service.MultipleFormServiceImpl;
import it.polimi.util.AbstractModelForListImpl;
import it.polimi.util.AbstractModelForMultipleFormImpl;
import it.polimi.util.output.Output;

@Configuration
@SpringBootApplication
public class TransfEngineApplication implements CommandLineRunner {

	@Autowired
	private DataModelService dataModelService;

	@Autowired
	private ListServiceImpl viewComponentListService;
	@Autowired
	private MultipleFormServiceImpl viewComponentMultipleFormService;


	@Autowired
	private AbstractModelForListImpl abstractModelForList;
	@Autowired
	private AbstractModelForMultipleFormImpl abstractForModelMultipleForm;

	@Autowired
	private Parser cassandraParser;
	
	@Autowired
	private Output output;

	@Value("${input.path.datamodel}")
	private String inputPathDataModel;
	
	@Value("${input.path.viewcomponent.list}")
	private String inputPathList;
	
	@Value("${input.path.viewcomponent.multipleform}")
	private String inputPathMultipleForm;
	
	@Value("${output.path.abstract.model}")
	private String outputPathAbstractModel;

	public static void main(final String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TransfEngineApplication.class);
		ctx.close();
	}

	@Override
	public void run(String... args) throws Exception {

		// prepare and clean directory
		FileUtils.cleanDirectory(new File("src/main/resources/output/abstract_model/"));

		// get data model and list components
		DataModel dataModel = dataModelService.loadDataModelFromFile(inputPathDataModel);

		createLogicalModelFromListAndMultipleDetailViewComponent(dataModel);
		createLogicalModelFromMultipleFormViewComponent(dataModel);

	}

	private void createLogicalModelFromMultipleFormViewComponent(DataModel dataModel) {
		Collection collection;
		// get multiple form component
		ArrayList<it.polimi.mapper.viewcomponent.multipleform.Descriptor> viewComponentMultipleForm = (ArrayList<it.polimi.mapper.viewcomponent.multipleform.Descriptor>) viewComponentMultipleFormService
				.loadViewComponentsFromFile(inputPathMultipleForm);
		
		// set data model for model transformation
		abstractForModelMultipleForm.setDataModel(dataModel);
		
		// set view component for model transformation and iteration over view components
		for (it.polimi.mapper.viewcomponent.multipleform.Descriptor viewComponent : viewComponentMultipleForm) {
			abstractForModelMultipleForm.setViewComponentMultipleForm(viewComponent);

			collection = abstractForModelMultipleForm.createCollection();
			collection = abstractForModelMultipleForm.createBlock();
			collection = abstractForModelMultipleForm.createEntries();
			
			//reading access paths
			collection = abstractForModelMultipleForm.evaluateReadingAccessPaths();

			try {
				//print noAM
				output.print(collection);
				//print Physical Implementation
				output.printScript(collection,cassandraParser.buildPhysicalModel(collection));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	//list component and multiple detail view component use same class Descriptor
	private void createLogicalModelFromListAndMultipleDetailViewComponent(DataModel dataModel) {
		Collection collection;
		ArrayList<Descriptor> viewComponentList = (ArrayList<Descriptor>) viewComponentListService
				.loadViewComponentsFromFile(inputPathList);

		// set data model for model transformation
		abstractModelForList.setDataModel(dataModel);

		// set view component for model transformation and iteration over view
		// components
		for (Descriptor viewComponent : viewComponentList) {
			abstractModelForList.setViewComponentList(viewComponent);

			collection = abstractModelForList.createCollection();
			collection = abstractModelForList.createBlock();
			collection = abstractModelForList.createEntries();

			try {
				//print noAM
				output.print(collection);
				//print Physical Implementation
				output.printScript(collection,cassandraParser.buildPhysicalModel(collection));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
