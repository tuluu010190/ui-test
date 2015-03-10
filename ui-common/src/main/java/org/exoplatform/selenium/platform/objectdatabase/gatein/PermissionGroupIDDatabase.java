package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class PermissionGroupIDDatabase {
	public ArrayList<String> path;
	

	/**
	 * PermissionGroupIDDatabase
	 * @param path
	 */
	public PermissionGroupIDDatabase(ArrayList<String> path){
		this.path = path;
	}

	/**
	 * PermissionGroupIDDatabase
	 */
	public PermissionGroupIDDatabase(){
		path  = new ArrayList<String>();
	}

	/**
	 * setPermissionGroupIDGateinData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setPermissionGroupIDGateinData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			path.add(testData[i][0]);
		}
	}
	
	/**
	 * Get Permission Group in Gatein by index
	 * @param index
	 * @return path.get(index)
	 */
	public String getPermissionGroupIDGateinByIndex(int index){
		return path.get(index);
	}
	
	/**
	 * get Permission Group in Gatein by random
	 * @return path
	 */
	public String getPermissionGroupIDGateinRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.path.size());
		String path = this.path.get(index);
		return path;
	}	
}
