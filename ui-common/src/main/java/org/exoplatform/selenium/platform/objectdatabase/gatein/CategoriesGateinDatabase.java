package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class CategoriesGateinDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> categories;
	public ArrayList<String> newCategories;

	public CategoriesGateinDatabase(ArrayList<Integer> type,ArrayList<String> categories){
		this.type = type;
		this.categories= categories;
	}
    
	public CategoriesGateinDatabase(){
		type  = new ArrayList<Integer>();
		categories = new ArrayList<String>();
		newCategories= new ArrayList<String>();
	}
    /**
     * setup dataDriven
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setGateinData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			categories.add(testData[i][1]);
		}
	}

	/**
	 * Get data via random index with type
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newCategories.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newCategories.add(this.categories.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newCategories.size());
		return index;
	}
	
	/**
	 * get categories random
	 * @return category
	 */
	public String getCategoryRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.categories.size());
		String category = this.categories.get(index);
		return category;
	}
	
}
