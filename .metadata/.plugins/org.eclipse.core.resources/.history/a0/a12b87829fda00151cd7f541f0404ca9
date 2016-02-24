package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

/**
 * @date Apr 8, 2015
 * @author anhpp
 */

public class ActivityMessageDatabase {
    
	public ArrayList<String> activityMessage;

	public ActivityMessageDatabase(ArrayList<String> activityMessage){
		this.activityMessage = activityMessage;
	}

	public ActivityMessageDatabase() {
		activityMessage  = new ArrayList<String>();
	}

	public void setActivityMessageData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			activityMessage.add(testData[i][0]);
		}
	}
	/**
	 * Get a message from file by index
	 * @param index
	 * @return wikiMessage 
	 */
	public String getActivityMessage(int index){
		return activityMessage.get(index);
	}
}



