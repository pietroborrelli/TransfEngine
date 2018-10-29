package it.polimi.util.output;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import it.polimi.domain.abstractmodel.Collection;
import it.polimi.domain.abstractmodel.Entry;

@Component
public class Output {

	public final static String OUTPUT_FILE_PATH="src/main/resources/output/abstract_model/";
	public final static String OUTPUT_SCRIPT_PATH="src/main/resources/output/physical_model/";
	
	public void print(Collection collection) throws IOException {
		
		System.out.println("Output on: " + OUTPUT_FILE_PATH + collection.getId() +"-"+ collection.getName()+".txt");
		
	    FileWriter fileWriter = new FileWriter(OUTPUT_FILE_PATH + collection.getId() + "-"+ collection.getName()+".txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    //collection
	    printWriter.println(collection.toString());
	    //block
	    printWriter.println("\n\tBlock " +
	    	collection.getBlock().getKey().getPartitionKeys().toString() + " ; " + collection.getBlock().getKey().getSortKeys().toString());
	    //entries
	    StringBuilder entries = new StringBuilder();
	    printWriter.println("\n\t\tEntries");
	    for (Entry entry : collection.getBlock().getEntries()) {
	    	printWriter.println("\t\t\t" + entry.toString()); 
	    }

	    
	    printWriter.close();
	}
	
public void printScript(Collection collection, String script) throws IOException {
		
		System.out.println("Output on: " + OUTPUT_SCRIPT_PATH + collection.getId() +"-"+ collection.getName()+".txt");
		
	    FileWriter fileWriter = new FileWriter(OUTPUT_SCRIPT_PATH + collection.getId() + "-"+ collection.getName()+".txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    //script
	    printWriter.println(script);
	    
	    printWriter.close();
	}

}
