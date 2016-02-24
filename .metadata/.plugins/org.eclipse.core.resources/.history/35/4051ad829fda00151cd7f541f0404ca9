package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ContainersDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> Category;
	public ArrayList<String> id;
	
	public ArrayList<String> newCategory;
	public ArrayList<String> newId;

	/**
	 * ContainersDatabase
	 * @param type
	 * @param Category
	 * @param id
	 */
	public ContainersDatabase(ArrayList<Integer> type, ArrayList<String> Category, 
			ArrayList<String>id){
		this.type = type;
		this.Category = Category;
		this.id = id;
	}

	/**
	 * ContainersDatabase
	 */
	public ContainersDatabase(){
		type  = new ArrayList<Integer>();
		Category  = new ArrayList<String>();
		id  = new ArrayList<String>();
		newCategory = new ArrayList<String>();
		newId  = new ArrayList<String>();
	}

	/**
	 * setContainersData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setContainersData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			Category.add(testData[i][1]);
			id.add(testData[i][2]);
		}
	}
	
	/**
	 * getRandomIndexByType
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newCategory.clear();
		newId.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newCategory.add(this.Category.get(i));
				newId.add(this.id.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newCategory.size());
		return index;
	}
	
	/**
	 * Get Container Id by index
	 * @param index
	 * @return id.get(index)
	 */
	public String getContainerIdByIndex(int index){
		return id.get(index);
	}
	
	
	/**
	 * Get Category container by index
	 * @param index
	 * @return Category.get(index)
	 */
	public String getCategoryByIndex(int index){
		return Category.get(index);
	}
	
	/**
	 * Get id container by index
	 * @param index
	 * @return id.get(index)
	 */
	public String getidByIndex(int index){
		return id.get(index);
	}
	
	
}
