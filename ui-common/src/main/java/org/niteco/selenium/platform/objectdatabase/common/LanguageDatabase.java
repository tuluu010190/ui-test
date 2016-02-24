package org.niteco.selenium.platform.objectdatabase.common;

import java.util.ArrayList;
import java.util.Random;

public class LanguageDatabase {
	public ArrayList<String> lang;

	/**
	 * LanguageDatabase
	 * @param lang
	 */
	public LanguageDatabase(ArrayList<String> lang){
		this.lang = lang;
	}

	/**
	 * LanguageDatabase
	 */
	public LanguageDatabase(){
		lang  = new ArrayList<String>();
	}

	/**
	 * setLanguageData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setLanguageData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{
			lang.add(testData[i][0]);
		}
	}
	
	/**
	 * Get Language by index
	 * @param index
	 * @return lang.get(index)
	 */
	public String getLanguageByIndex(int index){
		return lang.get(index);
	}
	
	/**
	 * get Language random
	 * @return language
	 */
	public String getLanguageRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.lang.size());
		String language = this.lang.get(index);
		return language;
	}
}
