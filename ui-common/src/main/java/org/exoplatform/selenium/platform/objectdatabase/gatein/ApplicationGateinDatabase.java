package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ApplicationGateinDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> title;
	public ArrayList<String> name;
	
	public ArrayList<String> newTitle;
	public ArrayList<String> newName;

	public ApplicationGateinDatabase(ArrayList<Integer> type, ArrayList<String> title, 
			ArrayList<String>name){
		this.type = type;
		this.title = title;
		this.name = name;
	}

	public ApplicationGateinDatabase(){
		type  = new ArrayList<Integer>();
		title  = new ArrayList<String>();
		name  = new ArrayList<String>();
		newTitle = new ArrayList<String>();
		newName  = new ArrayList<String>();
	}

	public void setApplicationGateinData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			title.add(testData[i][1]);
			name.add(testData[i][2]);
		}
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newTitle.clear();
		newName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTitle.add(this.title.get(i));
				newName.add(this.name.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newTitle.size());
		return index;
	}
	
	
}
