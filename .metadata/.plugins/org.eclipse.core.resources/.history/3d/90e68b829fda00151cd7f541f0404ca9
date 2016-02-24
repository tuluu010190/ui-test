package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class SpaceWarningMessageDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> content; 
	
	public ArrayList<String> newContent;

	public SpaceWarningMessageDatabase(ArrayList<Integer> type, ArrayList<String> content){
		this.type = type;
		this.content = content;
	}
    
	public SpaceWarningMessageDatabase(){
		type  = new ArrayList<Integer>();
		content  = new ArrayList<String>();
		
		newContent = new ArrayList<String>();
	}
    /**
     * Set  data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			content.add(testData[i][1]);
		}
	}
	
	
	public String getGroup(int index){
		return content.get(index);
	}
	
	
	/**
	 * Get new content by type
	 * @param type
	 * @return newContent
	 */
	public ArrayList<String> getArrayContentByType(int type){
		newContent.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newContent.add(this.content.get(i));
			}
		}
		return newContent;
	}
	
	
	
}
