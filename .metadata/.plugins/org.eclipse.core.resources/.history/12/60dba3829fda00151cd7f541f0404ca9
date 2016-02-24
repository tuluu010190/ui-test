package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class PagesManagementListDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> title; 
	public ArrayList<String> siteName;
	public ArrayList<String> model;
	
	public ArrayList<String> newTitle;
	public ArrayList<String> newSiteName;
	public ArrayList<String> newModel;

	public PagesManagementListDatabase(ArrayList<Integer> type, ArrayList<String> title, 
			ArrayList<String>siteName,ArrayList<String>model){
		this.type = type;
		this.title = title;
		this.siteName = siteName;
		this.model = model;
	}
    
	public PagesManagementListDatabase(){
		type  = new ArrayList<Integer>();
		title  = new ArrayList<String>();
		siteName  = new ArrayList<String>();
		model =  new ArrayList<String>();
		
		newTitle = new ArrayList<String>();
		newSiteName  = new ArrayList<String>();
		newModel = new ArrayList<String>();
	}
    /**
     * Seta pages list data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setPagesListData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			title.add(testData[i][1]);
			siteName.add(testData[i][2]);
			model.add(testData[i][3]);
		}
	}
	
	/**
	 * Get data via random index with type
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newTitle.clear();
		newSiteName.clear();
		newModel.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTitle.add(this.title.get(i));
				newSiteName.add(this.siteName.get(i));
				newModel.add(this.model.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newTitle.size());
		return index;
	}
	
	
	
	
}
