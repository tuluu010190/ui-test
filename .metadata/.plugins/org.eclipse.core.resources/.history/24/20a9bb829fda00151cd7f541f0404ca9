package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class DefaultGroupDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> groups;
	

	public DefaultGroupDatabase(ArrayList<Integer> type, ArrayList<String> groups){
		this.type = type;
		this.groups = groups;
	}

	public DefaultGroupDatabase(){
		type  = new ArrayList<Integer>();
		groups = new ArrayList<String>();
	}

	public void setDefaulGroupData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			groups.add(testData[i][1]);
		}
	}
	
	/**
	 * Get content by index
	 * @param index
	 * @return portal.get(index)
	 */
	public String getDefaultGroupsByIndex(int index){
		return groups.get(index);
	}
	
	
}
