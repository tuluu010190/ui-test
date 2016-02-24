package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class GateinNodesDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> nodes;

	
	public GateinNodesDatabase(ArrayList<Integer> type, ArrayList<String> nodes){
		this.type = type;
		this.nodes = nodes;
	}

	public GateinNodesDatabase(){
		type  = new ArrayList<Integer>();
		nodes = new ArrayList<String>();
	}

	public void setNodesData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			nodes.add(testData[i][1]);
		}
	}
	
	/**
	 * Get content by index
	 * @param index
	 * @return portal.get(index)
	 */
	public String getNodesByIndex(int index){
		return nodes.get(index);
	}
	
	
}
