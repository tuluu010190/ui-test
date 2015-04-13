package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

/**
 * @date Apr 8, 2015
 * @author anhpp
 */

public class ConnectStatusDatabase {
    
	public ArrayList<String> conStatus;

	public ConnectStatusDatabase(ArrayList<String> conStatus){
		this.conStatus = conStatus;
	}

	public ConnectStatusDatabase() {
		conStatus  = new ArrayList<String>();
	}

	public void setConStatusData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			conStatus.add(testData[i][0]);
		}
	}
	
	public String getConStatus(int index){
		return conStatus.get(index);
	}

	public String getConStatusRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.conStatus.size());
		return this.conStatus.get(index);
	}
}



