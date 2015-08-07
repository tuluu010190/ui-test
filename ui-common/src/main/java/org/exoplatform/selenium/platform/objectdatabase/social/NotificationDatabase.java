package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class NotificationDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> mode;
	public ArrayList<String> content;
	public ArrayList<String> newContent;
	
	public NotificationDatabase(ArrayList<Integer> type, ArrayList<String> mode,
			ArrayList<String> content){
		this.type = type;
		this.mode = mode;
		this.content = content;
		
	}

	public NotificationDatabase() {
		type  = new ArrayList<Integer>();
		mode  = new ArrayList<String>();
		content  = new ArrayList<String>();
		newContent  = new ArrayList<String>();
	}

	public void setData(String userDataFile, String userSheet,Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		info("testData.length-1:"+testData.length);
		for(int i = 0; i<testData.length-1; i++)
		{	
			if (!testData[i][1].isEmpty()) {
				info("i:" + i + " " + testData[i][1]);
				type.add(Integer.valueOf(testData[i][0]));
				mode.add(testData[i][1]);
				content.add(testData[i][2]);
			}
		}
	}
	/**
	 * Get the conent by type
	 * @param type
	 * @return
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newContent.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newContent.add(this.content.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newContent.size());
		return index;
	}
	/**
	 * Get a message from file by index
	 * @param index
	 * @return message 
	 */
	public String getNotiContent(int index){
		return content.get(index);
	}
	
	/**
	 * Get message from file by random type
	 * @param type
	 * @return
	 */
	public String getContentByArrayTypeRandom(int...type){
		ArrayList<String> arrayMessage = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayMessage.add(this.content.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(arrayMessage.size());
		String message = arrayMessage.get(index);
		info("Message is: "+message);
		return message;
	}
	
	/**
	 * Get mode from file by random type
	 * @param type
	 * @return mode
	 */
	public String getModeByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.mode.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(array.size());
		String mode = array.get(index);
		info("Mode is: "+mode);
		return mode;
	}
}
