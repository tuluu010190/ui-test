package org.niteco.selenium.platform.objectdatabase.rs;

import java.util.ArrayList;

import org.niteco.selenium.platform.objectdatabase.common.DatabaseResource;

public class skillInformation {

	public ArrayList<Integer> type;
	public ArrayList<String> skill;
	public ArrayList<String> level;
	
	
	public skillInformation(ArrayList<Integer> type, ArrayList<String> skill, ArrayList<String> level){
		this.type = type;
		this.skill = skill;
		this.level = level;
	}
	
	/**
	 * UserDatabase
	 */
	public skillInformation(){
		type  = new ArrayList<Integer>();
		skill  = new ArrayList<String>();
		level  = new ArrayList<String>();
	}
	
	 /**
     * Set data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		System.out.println("file is:" + userDataFile);
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			//type.add(Integer.valueOf(testData[i][0]));
			skill.add(testData[i][1]);
			level.add(testData[i][2]);
		}
	}
	
	/**
	 * Get Skill by index
	 * @param index
	 * @return
	 */
	public String getSkillByIndex(int index){
		return skill.get(index);
	}
	
	/**
	 * Get Level by index
	 * @param index
	 * @return
	 */
	public String getLevelByIndex(int index){
		return level.get(index);
	}
}
