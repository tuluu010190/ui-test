package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class RemoteGadgetDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> title;
	public ArrayList<String> links;
	
	public ArrayList<String> newTitle;
	public ArrayList<String> newLinks;

	public RemoteGadgetDatabase(ArrayList<Integer> type, ArrayList<String> title, 
			ArrayList<String> links){
		this.type = type;
		this.title = title;
		this.links = links;
	}

	public RemoteGadgetDatabase(){
		type  = new ArrayList<Integer>();
		title  = new ArrayList<String>();
		links  = new ArrayList<String>();
		newTitle = new ArrayList<String>();
		newLinks  = new ArrayList<String>();
	}

	public void setRemoteGadgetData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			title.add(testData[i][1]);
			links.add(testData[i][2]);
		}
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newTitle.clear();
		newLinks.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTitle.add(this.title.get(i));
				newLinks.add(this.links.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newTitle.size());
		return index;
	}
}
