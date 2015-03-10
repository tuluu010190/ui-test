package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ApplicationLayoutDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> category;
	public ArrayList<String> title;
	public ArrayList<String> id;
	
	public ArrayList<String> newTitle;
	public ArrayList<String> newCategory;
	public ArrayList<String> newId;

	public ApplicationLayoutDatabase(ArrayList<Integer> type,ArrayList<String> category,  ArrayList<String> title, 
			ArrayList<String>id){
		this.type = type;
		this.category = category;
		this.title = title;
		this.id = id;
	}

	public ApplicationLayoutDatabase(){
		type  = new ArrayList<Integer>();
		category  = new ArrayList<String>();
		title  = new ArrayList<String>();
		id  = new ArrayList<String>();
		newCategory = new ArrayList<String>();
		newTitle = new ArrayList<String>();
		newId  = new ArrayList<String>();
	}

	public void setApplicationLayoutData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			category.add(testData[i][1]);
			title.add(testData[i][2]);
		    id.add(testData[i][3]);
		}
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newCategory.clear();
		newTitle.clear();
		newId.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTitle.add(this.title.get(i));
				newCategory.add(this.category.get(i));
				newId.add(this.id.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newTitle.size());
		return index;
	}
	
	
}
