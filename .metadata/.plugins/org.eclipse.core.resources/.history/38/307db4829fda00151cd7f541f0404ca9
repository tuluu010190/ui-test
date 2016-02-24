package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class GateinPortalMemberShipsPermissionDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> memberships;
	
	public GateinPortalMemberShipsPermissionDatabase(ArrayList<Integer> type, ArrayList<String> memberships){
		this.type = type;
		this.memberships = memberships ;
	}

	public GateinPortalMemberShipsPermissionDatabase(){
		type  = new ArrayList<Integer>();
		memberships = new ArrayList<String>();
	}

	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			memberships.add(testData[i][1]);
		}
	}
	
	/**
	 * Get content by index
	 * @param index
	 * @return memberships.get(index)
	 */
	public String getContentByIndex(int index){
		return memberships.get(index);
	}
	
}
