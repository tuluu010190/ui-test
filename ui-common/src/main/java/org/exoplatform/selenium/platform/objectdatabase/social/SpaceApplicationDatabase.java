package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class SpaceApplicationDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> category;
	public ArrayList<String> application;
	
	public ArrayList<String> newCategory;
	public ArrayList<String> newApplication;
	

	public SpaceApplicationDatabase(ArrayList<Integer> type, ArrayList<String> category,
			ArrayList<String> application){
		this.type = type;
		this.category = category;
		this.application = application;
		
	}

	public SpaceApplicationDatabase() {
		type  = new ArrayList<Integer>();
		category  = new ArrayList<String>();
		application  = new ArrayList<String>();
		newCategory = new ArrayList<String>();
		newApplication = new ArrayList<String>();
	}

	public void setAppData(String userDataFile, String userSheet,Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			category.add(testData[i][1]);
			application.add(testData[i][2]);
		}
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newCategory.clear();
		newApplication.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newCategory.add(this.category.get(i));
				newApplication.add(this.application.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newApplication.size());
		return index;
	}
}
