package org.exoplatform.selenium.platform.objectdatabase.wiki;
import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ReadTwoColDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> Content;

	/**
	 * ImageLinkDatabase
	 * @param type
	 * @param Content
	 */
	public ReadTwoColDatabase(ArrayList<Integer> type, 
			ArrayList<String> Content){
		this.type = type;
		this.Content = Content;
	}

	/**
	 * Create array
	 */
	public ReadTwoColDatabase(){
		type  = new ArrayList<Integer>();
		Content  = new ArrayList<String>();
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
			Content.add(testData[i][1]);
		}
	}

	
	
	/**
	 * Get link by random
	 * @return linkFile
	 */
	public String getDataContentRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.Content.size());
		String linkFile = this.Content.get(index);
		return linkFile;
	}

	/**
	 * Get Content by type
	 * @param type
	 * @return array
	 */
	public ArrayList<String> getDataContentByType(int type){
		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				array.add(this.Content.get(i));
			}
		}
		return array;
	}

	/**
	 * Get link by array type
	 * @param type
	 * @return
	 */
	public ArrayList<String> getDataContentByArrayType(int...type){
		ArrayList<String> array = new ArrayList<String>();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.Content.get(i));
				}
			}
		}
		return array;
	}

	public String getDataContentByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.Content.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(array.size());
		String Content = array.get(index);
		info("Content is: "+Content);
		return Content;
	}
	
}
