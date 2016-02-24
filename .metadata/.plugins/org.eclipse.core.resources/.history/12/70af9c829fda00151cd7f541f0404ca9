package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class GateinPortalDefaultDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> portal;
	public ArrayList<String> newPortal;
	

	public GateinPortalDefaultDatabase(ArrayList<Integer> type,
			ArrayList<String> portal){
		this.type = type;
		this.portal = portal;
	}

	public GateinPortalDefaultDatabase(){
		type  = new ArrayList<Integer>();
		portal = new ArrayList<String>();
	    newPortal=new ArrayList<String>();
	}

	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			portal.add(testData[i][1]);
		}
	}
	
	/**
	 * Get content by index
	 * @param index
	 * @return portal.get(index)
	 */
	public String getContentByIndex(int index){
		return portal.get(index);
	}
	
	
}
