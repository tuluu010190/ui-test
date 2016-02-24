package org.exoplatform.selenium.platform.objectdatabase.wiki;

import java.util.ArrayList;
import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class WikiMessageDatabase {
	public ArrayList<String> wikiMessage;

	public WikiMessageDatabase(ArrayList<String> wikiMessage){
		this.wikiMessage = wikiMessage;
	}

	public WikiMessageDatabase() {
		wikiMessage  = new ArrayList<String>();
	}

	public void setWikiMessageData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			wikiMessage.add(testData[i][0]);
		}
	}
	/**
	 * Get a message from file by index
	 * @param index
	 * @return wikiMessage 
	 */
	public String getWikiMessage(int index){
		return wikiMessage.get(index);
	}

	
}
