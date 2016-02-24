package org.exoplatform.selenium.platform.objectdatabase.calendar;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class CalendarCommentsDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> content;
	public ArrayList<String> newcontent;
	
	public CalendarCommentsDatabase(ArrayList<Integer> type, ArrayList<String>content){
		this.type = type;
		this.content = content;
	}

	public CalendarCommentsDatabase(){
		type  = new ArrayList<Integer>();
		content  = new ArrayList<String>();
		newcontent =new ArrayList<String>();
	}
    /**
     * Set data
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
	/**
	 * Get content by index
	 * @param index
	 * @return
	 */
	public String getContentByIndex(int index){
		return content.get(index);
	}
	
	/**
	 * Get group name by random
	 * @return this.content.get(index)
	 */
	public String getContentByRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.content.size());
		return this.content.get(index);
	}
	
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newcontent .clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newcontent .add(this.content.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newcontent.size());
		return index;
	}
	
	/**
	 * getArrayIcontentByType
	 * @param type
	 * @return newcontent
	 */
	public ArrayList<String> getArraycontentByType(int type){
		newcontent.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newcontent.add(this.content.get(i));
			}
		}
		return newcontent;
	}
	
}
