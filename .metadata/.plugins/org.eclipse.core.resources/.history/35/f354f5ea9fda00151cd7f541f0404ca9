package org.exoplatform.selenium.platform.objectdatabase.common;

import java.util.ArrayList;
import java.util.Random;


public class PermissionDatabase {
	public ArrayList<String> des;

	/**
	 * PermissionDatabase
	 * @param des
	 */
	public PermissionDatabase(ArrayList<String> des){
		this.des = des;
	}

	/**
	 * PermissionDatabase
	 */
	public PermissionDatabase(){
		des  = new ArrayList<String>();
	}

	/**
	 * setContentData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setDesData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			des.add(testData[i][0]);
		}
	}
	
	/**
	 * Get Des by index
	 * @param index
	 * @return des.get(index)
	 */
	public String getDesByIndex(int index){
		return des.get(index);
	}
	
	/**
	 * get Des random
	 * @return des
	 */
	public String getDesRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.des.size());
		String des = this.des.get(index);
		return des;
	}
}
