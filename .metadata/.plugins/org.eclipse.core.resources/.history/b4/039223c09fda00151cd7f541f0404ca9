package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class SpaceNavigationDefaultNodesDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> nodes;
	

	public SpaceNavigationDefaultNodesDatabase(ArrayList<Integer> type, ArrayList<String> nodes){
		this.type = type;
		this.nodes = nodes;
	}

	public SpaceNavigationDefaultNodesDatabase(){
		type  = new ArrayList<Integer>();
		nodes  = new ArrayList<String>();
	}

	/**
	 * setSpaceNavigationDefaultNodes
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 */
	public void setSpaceNavigationDefaultNodes(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			nodes.add(testData[i][1]);
		}
	}

	
	/**
	 * Get nodes by index
	 * @param index
	 * @return nodes.get(index);
	 */
	public String getNodesByIndex(int index){
		return nodes.get(index);
	}
}
