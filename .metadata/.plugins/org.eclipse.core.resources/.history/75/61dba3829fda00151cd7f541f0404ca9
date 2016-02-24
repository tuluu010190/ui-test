package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class GroupNameDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> groupName;
	
	public GroupNameDatabase(ArrayList<Integer> type, ArrayList<String>groupName){
		this.type = type;
		this.groupName = groupName;
	}

	public GroupNameDatabase(){
		type  = new ArrayList<Integer>();
		groupName  = new ArrayList<String>();
	}
    /**
     * Set Group Name data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setGroupNameData(String userDataFile, String userSheet, Object... opParams) throws Exception{
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
	
	
}
