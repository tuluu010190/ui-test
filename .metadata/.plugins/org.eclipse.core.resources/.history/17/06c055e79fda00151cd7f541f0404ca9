package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class GadgetsGateinDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> Category;
	public ArrayList<String> name;
	
	public ArrayList<String> newCategory;
	public ArrayList<String> newName;

	public GadgetsGateinDatabase(ArrayList<Integer> type, ArrayList<String> Category, 
			ArrayList<String>name){
		this.type = type;
		this.Category = Category;
		this.name = name;
	}

	public GadgetsGateinDatabase(){
		type  = new ArrayList<Integer>();
		Category  = new ArrayList<String>();
		name  = new ArrayList<String>();
		newCategory = new ArrayList<String>();
		newName  = new ArrayList<String>();
	}

	public void setGadgetsGateinData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			Category.add(testData[i][1]);
			name.add(testData[i][2]);
		}
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newCategory.clear();
		newName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newCategory.add(this.Category.get(i));
				newName.add(this.name.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newCategory.size());
		return index;
	}
	
	
}
