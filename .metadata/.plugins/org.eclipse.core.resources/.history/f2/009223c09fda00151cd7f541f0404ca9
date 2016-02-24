package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class SpaceGroupsDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> group; 
	public ArrayList<String> subGroup;
	
	public ArrayList<String> newGroup;
	public ArrayList<String> newSubGroup;

	public SpaceGroupsDatabase(ArrayList<Integer> type, ArrayList<String> group, 
			ArrayList<String>subGroup){
		this.type = type;
		this.group = group;
		this.subGroup = subGroup;
	}
    
	public SpaceGroupsDatabase(){
		type  = new ArrayList<Integer>();
		group  = new ArrayList<String>();
		subGroup  = new ArrayList<String>();
		
		newGroup = new ArrayList<String>();
		newSubGroup  = new ArrayList<String>();
	}
    /**
     * Set  data
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
			group.add(testData[i][1]);
			subGroup.add(testData[i][2]);
		}
	}
	
	/**
	 * Get data via random index with type
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newGroup.clear();
		newSubGroup.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newGroup.add(this.group.get(i));
				newSubGroup.add(this.subGroup.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newGroup.size());
		return index;
	}
	
	public String getGroup(int index){
		return group.get(index);
	}
	
	/**
	 * Get new subGroup by type
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArraySubGroupByType(int type){
		newSubGroup.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newSubGroup.add(this.subGroup.get(i));
			}
		}
		return newSubGroup;
	}
	
	/**
	 * Get new subGroup by type
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArrayGroupByType(int type){
		newGroup.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newGroup.add(this.group.get(i));
			}
		}
		return newGroup;
	}
	
	
	
}
