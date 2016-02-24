package org.exoplatform.selenium.platform.objectdatabase.calendar;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class CalendarTabsDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> tabName;
	public ArrayList<String> newTabName;
	
	public CalendarTabsDatabase(ArrayList<Integer> type, ArrayList<String>tabName){
		this.type = type;
		this.tabName = tabName;
	}

	public CalendarTabsDatabase(){
		type  = new ArrayList<Integer>();
		tabName  = new ArrayList<String>();
		newTabName =new ArrayList<String>();
	}
    /**
     * Set data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			tabName.add(testData[i][1]);
		}
	}
	/**
	 * Get tab name by index
	 * @param index
	 * @return
	 */
	public String getTabNameByIndex(int index){
		return tabName.get(index);
	}
	
	/**
	 * Get tab name by random
	 * @return this.tabName.get(index)
	 */
	public String getTabNameByRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.tabName.size());
		return this.tabName.get(index);
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newTabName .clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTabName .add(this.tabName.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newTabName.size());
		return index;
	}
	
	/**
	 * getArrayTabNameByType
	 * @param type
	 * @return newTabName
	 */
	public ArrayList<String> getArrayTabNameByType(int type){
		newTabName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTabName.add(this.tabName.get(i));
			}
		}
		return newTabName;
	}
	
}
