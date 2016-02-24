package org.exoplatform.selenium.platform.objectdatabase.wiki;
import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ReadThreeColDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> ColumnOne;
	public ArrayList<String> ColumnTwo;

	/**
	 * ImageLinkDatabase
	 * @param type
	 * @param Content
	 */
	public ReadThreeColDatabase(ArrayList<Integer> type, 
			ArrayList<String> ColumnOne,ArrayList<String> ColumnTwo){
		this.type = type;
		this.ColumnOne = ColumnOne;
		this.ColumnTwo = ColumnTwo;
	}

	/**
	 * Create array
	 */
	public ReadThreeColDatabase(){
		type  = new ArrayList<Integer>();
		ColumnOne  = new ArrayList<String>();
		ColumnTwo = new ArrayList<String>();
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
			ColumnOne.add(testData[i][1]);
			ColumnTwo.add(testData[i][2]);
		}
	}

	
	
	/**
	 * Get link by random
	 * @return linkFile
	 */
	public String getDataColOneRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.ColumnOne.size());
		String linkFile = this.ColumnOne.get(index);
		return linkFile;
	}

	/**
	 * Get Content by type
	 * @param type
	 * @return array
	 */
	public ArrayList<String> getDataColOneByType(int type){
		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				array.add(this.ColumnOne.get(i));
			}
		}
		return array;
	}

	/**
	 * Get link by array type
	 * @param type
	 * @return
	 */
	public ArrayList<String> getDataColOneByArrayType(int...type){
		ArrayList<String> array = new ArrayList<String>();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.ColumnOne.get(i));
				}
			}
		}
		return array;
	}

	public String getDataColOneByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.ColumnOne.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(array.size());
		String Content = array.get(index);
		info("Content is: "+Content);
		return Content;
	}
	
	public String getDataColTwoByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.ColumnTwo.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(array.size());
		String Content = array.get(index);
		info("Content is: "+Content);
		return Content;
	}
}
