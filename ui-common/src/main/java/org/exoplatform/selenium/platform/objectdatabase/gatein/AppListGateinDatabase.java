package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class AppListGateinDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> category; 
	public ArrayList<String> name;// this is Display Name column
	public ArrayList<String> appName;
	public ArrayList<String> des;
	
	public ArrayList<String> newCategory;
	public ArrayList<String> newName;
	public ArrayList<String> newAppName;
	public ArrayList<String> newDes;

	public AppListGateinDatabase(ArrayList<Integer> type, ArrayList<String> category, 
			ArrayList<String>name,ArrayList<String>appName,ArrayList<String>des){
		this.type = type;
		this.category = category;
		this.name = name;
		this.appName = appName;
		this.des = des;
	}
    
	public AppListGateinDatabase(){
		type  = new ArrayList<Integer>();
		category  = new ArrayList<String>();
		name  = new ArrayList<String>();
		appName =  new ArrayList<String>();
		des =  new ArrayList<String>();
		newCategory = new ArrayList<String>();
		newName  = new ArrayList<String>();
		newAppName = new ArrayList<String>();
		newDes= new ArrayList<String>();
	}
    /**
     * setup dataDriven
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setApplicationGateinData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			category.add(testData[i][1]);
			name.add(testData[i][2]);
			appName.add(testData[i][3]);
			des.add(testData[i][4]);
		}
	}
	
	/**
	 * Get all applications in the list
	 */
	public void getAllApplications(){
		newCategory.clear();
		newName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			newCategory.add(this.category.get(i));
			newName.add(this.name.get(i));
		}
	}
	/**
	 * Get data via random index with type
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newCategory.clear();
		newName.clear();
		newAppName.clear();
		newDes.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newCategory.add(this.category.get(i));
				newName.add(this.name.get(i));
				newAppName.add(this.appName.get(i));
				newDes.add(this.des.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newCategory.size());
		return index;
	}
	
	
	
	
}
