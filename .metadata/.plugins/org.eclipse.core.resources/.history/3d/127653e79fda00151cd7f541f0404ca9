package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class AppAddGateinDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> app;
	public ArrayList<String> displayName;
	public ArrayList<String> description;
	
	public ArrayList<String> newApp;
	public ArrayList<String> newDisplayName;
	public ArrayList<String> newDescription;

	public AppAddGateinDatabase(ArrayList<Integer> type,ArrayList<String> app, ArrayList<String> displayName, 
			ArrayList<String>description){
		this.type = type;
		this.app= app;
		this.displayName = displayName;
		this.description = description;
	}
    
	public AppAddGateinDatabase(){
		type  = new ArrayList<Integer>();
		app = new ArrayList<String>();
		displayName  = new ArrayList<String>();
		description  = new ArrayList<String>();
		newDisplayName = new ArrayList<String>();
		newDescription = new ArrayList<String>();
		newApp= new ArrayList<String>();
	}
    /**
     * setup dataDriven
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setAppAddGateinData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			app.add(testData[i][1]);
			displayName.add(testData[i][2]);
			description.add(testData[i][3]);
		}
	}
	
	/**
	 * Get all applications in the list
	 */
	public void getAllApplications(){
		newDisplayName.clear();
		newDescription.clear();
		newApp.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			newApp.add(this.app.get(i));
			newDisplayName.add(this.displayName.get(i));
			newDescription.add(this.description.get(i));
		}
	}
	/**
	 * Get data via random index with type
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newDisplayName.clear();
		newDescription.clear();
		newApp.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newApp.add(this.app.get(i));
				newDisplayName.add(this.displayName.get(i));
				newDescription.add(this.description.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newDisplayName.size());
		return index;
	}
	
	
}
