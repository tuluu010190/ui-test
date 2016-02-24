package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class CreateNewGateinDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> name;
	public ArrayList<String> xmlCode;
	
	public ArrayList<String> newName;
	public ArrayList<String> newXMLCode;
	public Integer lastIndex;

	public CreateNewGateinDatabase(ArrayList<Integer> type,ArrayList<String>name, 
			ArrayList<String>xmlCode){
		this.type = type;
		this.name= name;
		this.xmlCode= xmlCode;
		this.lastIndex=0;
	}
    
	public CreateNewGateinDatabase(){
		type  = new ArrayList<Integer>();
		name = new ArrayList<String>();
		xmlCode  = new ArrayList<String>();
		newName = new ArrayList<String>();
		newXMLCode  = new ArrayList<String>();
	}
    /**
     * setup dataDriven
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setGateinData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			name.add(testData[i][1]);
			xmlCode.add(testData[i][2]);
		}
	}
	
	/**
	 * Get data via random index with type
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newName.clear();
		newXMLCode.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newName.add(this.name.get(i));
				newXMLCode.add(this.xmlCode.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newName.size());
		lastIndex = newName.size();
		return index;
	}
	
	
}
