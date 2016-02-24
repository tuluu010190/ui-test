package org.exoplatform.selenium.platform.objectdatabase.plf;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;


public class GettingStartedDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> tasks;
	public ArrayList<String> newTasks;

	/**
	 * TextBoxDatabase
	 * @param type
	 * @param content
	 */
	public GettingStartedDatabase(ArrayList<Integer> type, ArrayList<String> tasks){
		this.type = type;
		this.tasks = tasks;
	}

	/**
	 * TextBoxDatabase
	 */
	public GettingStartedDatabase(){
		type  = new ArrayList<Integer>();
		tasks  = new ArrayList<String>();
		newTasks=  new ArrayList<String>();
	}

	/**
	 * setGettingStartedData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setGettingStartedData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			tasks.add(testData[i][1]);
		}
	}
	
	/**
	 * Get file name by index
	 * @param index
	 * @return
	 */
	public String getTaskByIndex(int index){
		return tasks.get(index);
	}
	
	/**
	 * get file name random
	 * @return
	 */
	public String getTaskRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.tasks.size());
		String task = this.tasks.get(index);
		return task;
	}

	/**
	 * getArrayContentByType
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArrayTaskByType(int type){
		newTasks.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTasks.add(this.tasks.get(i));
			}
		}
		return newTasks;
	}
   /**
    * GetRandomIndexByType
    * @param type
    * @return
    */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newTasks.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTasks.add(this.tasks.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newTasks.size());
		return index;
	}

	/**
	 * getContentByArrayTypeRandom
	 * @param type
	 * @return
	 */
	public String getTaskByArrayTypeRandom(int...type){
		ArrayList<String> arrayContent = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayContent.add(this.tasks.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(arrayContent.size());
		String Content = arrayContent.get(index);
		return Content;
	}
}
