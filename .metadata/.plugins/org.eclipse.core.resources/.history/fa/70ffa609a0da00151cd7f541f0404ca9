package org.exoplatform.selenium.platform.objectdatabase.calendar;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class CalendarGroupDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> groupName;
	public ArrayList<String> newGroupName;
	
	public CalendarGroupDatabase(ArrayList<Integer> type, ArrayList<String>groupName){
		this.type = type;
		this.groupName = groupName;
	}

	public CalendarGroupDatabase(){
		type  = new ArrayList<Integer>();
		groupName  = new ArrayList<String>();
		newGroupName =new ArrayList<String>();
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
			groupName.add(testData[i][1]);
		}
	}
	/**
	 * Get group name by index
	 * @param index
	 * @return
	 */
	public String getGroupNameByIndex(int index){
		return groupName.get(index);
	}
	
	/**
	 * Get group name by random
	 * @return this.groupName.get(index)
	 */
	public String getGroupNameByRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.groupName.size());
		return this.groupName.get(index);
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newGroupName .clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newGroupName .add(this.groupName.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newGroupName.size());
		return index;
	}
	
	/**
	 * getArrayIGroupNameByType
	 * @param type
	 * @return newGroupName
	 */
	public ArrayList<String> getArrayGroupNameByType(int type){
		newGroupName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newGroupName.add(this.groupName.get(i));
			}
		}
		return newGroupName;
	}
	
}
