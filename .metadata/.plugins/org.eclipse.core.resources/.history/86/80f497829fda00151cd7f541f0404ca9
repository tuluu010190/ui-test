package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class SpaceGUIDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> itemName;
	public ArrayList<String> appName;
	
	public ArrayList<String> newItemName;
	public ArrayList<String> newAppName;

	public SpaceGUIDatabase(ArrayList<Integer> type, ArrayList<String> itemName,
			ArrayList<String> appName){
		this.type = type;
		this.itemName = itemName;
		this.appName = appName;
	}

	public SpaceGUIDatabase() {
		type  = new ArrayList<Integer>();
	    itemName=new ArrayList<String>();
		appName=new ArrayList<String>();
		newItemName = new ArrayList<String>();
		newAppName = new ArrayList<String>();
	}

	public void setData(String userDataFile, String userSheet,Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			itemName.add(testData[i][2]);
			appName.add(testData[i][3]);
		}
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newItemName.clear();
		newAppName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newItemName.add(this.itemName.get(i));
				newAppName.add(this.appName.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newAppName.size());
		return index;
	}
	
	/**
	 * getArrayItemNameByType
	 * @param type
	 * @return newItemName
	 */
	public ArrayList<String> getArrayItemNameByType(int type){
		newItemName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newItemName.add(this.itemName.get(i));
			}
		}
		return newItemName;
	}
	
	/**
	 * getArrayAppNameByType
	 * @param type
	 * @return newAppName
	 */
	public ArrayList<String> getArrayAppNameByType(int type){
		newAppName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newAppName.add(this.appName.get(i));
			}
		}
		return newAppName;
	}
}
