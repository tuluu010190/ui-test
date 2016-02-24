package org.exoplatform.selenium.platform.objectdatabase.calendar;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class CalendarRemoteDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> name;
	public ArrayList<String> subcrisbe;
	public ArrayList<String> newName;
	public ArrayList<String> newSubcrisbe;
	
	public CalendarRemoteDatabase(ArrayList<Integer> type, ArrayList<String>name){
		this.type = type;
		this.name = name;
	}

	public CalendarRemoteDatabase(){
		type  = new ArrayList<Integer>();
		name  = new ArrayList<String>();
		subcrisbe =new ArrayList<String>();
		newName =new ArrayList<String>();
		newSubcrisbe =new ArrayList<String>();
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
			name.add(testData[i][1]);
			subcrisbe.add(testData[i][2]);
		}
	}
	/**
	 * Get name by index
	 * @param index
	 * @return
	 */
	public String getnameByIndex(int index){
		return name.get(index);
	}
	
	/**
	 * Get subcrisbe by index
	 * @param index
	 * @return
	 */
	public String getSubcrisbeByIndex(int index){
		return subcrisbe.get(index);
	}
	
	/**
	 * Get subcrisbe by random
	 * @return this.subcrisbe.get(index)
	 */
	public String getSubcrisbeByRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.name.size());
		return this.subcrisbe.get(index);
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newSubcrisbe.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newSubcrisbe.add(this.subcrisbe.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newSubcrisbe.size());
		return index;
	}
	
	/**
	 * getArraySubcrisbeByType
	 * @param type
	 * @return subcrisbe
	 */
	public ArrayList<String> getArraySubcrisbeByType(int type){
		newSubcrisbe.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newSubcrisbe.add(this.subcrisbe.get(i));
			}
		}
		return newSubcrisbe;
	}
	
}
