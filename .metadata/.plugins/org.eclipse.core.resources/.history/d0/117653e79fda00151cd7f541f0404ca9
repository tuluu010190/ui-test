package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class GateinPortalGroupsPermissionDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> groupPath;
	

	public GateinPortalGroupsPermissionDatabase(ArrayList<Integer> type, ArrayList<String> groupPath){
		this.type = type;
		this.groupPath = groupPath;
	}

	public GateinPortalGroupsPermissionDatabase(){
		type  = new ArrayList<Integer>();
		groupPath  = new ArrayList<String>();
	}

	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			groupPath.add(testData[i][1]);
		}
	}
	
	/**
	 * Get content by index
	 * @param index
	 * @return groupPath.get(index)
	 */
	public String getContentByIndex(int index){
		return groupPath.get(index);
	}
	
}
