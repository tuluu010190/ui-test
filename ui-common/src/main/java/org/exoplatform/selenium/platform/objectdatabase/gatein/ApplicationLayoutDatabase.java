package org.exoplatform.selenium.platform.objectdatabase.gatein;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ApplicationLayoutDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> category;
	public ArrayList<String> title;
	public ArrayList<String> id;
	public ArrayList<String> portletName;
	
	public ArrayList<String> newTitle;
	public ArrayList<String> newCategory;
	public ArrayList<String> newId;

	
	/**
	 * ApplicationLayoutDatabase
	 * @param type
	 * @param category
	 * @param title
	 * @param id
	 * @param portletName
	 */
	public ApplicationLayoutDatabase(ArrayList<Integer> type,ArrayList<String> category,  ArrayList<String> title, 
			ArrayList<String>id, ArrayList<String>portletName){
		this.type = type;
		this.category = category;
		this.title = title;
		this.id = id;
		this.portletName = portletName;
	}

	/**
	 * ApplicationLayoutDatabase
	 */
	public ApplicationLayoutDatabase(){
		type  = new ArrayList<Integer>();
		category  = new ArrayList<String>();
		title  = new ArrayList<String>();
		id  = new ArrayList<String>();
		portletName = new ArrayList<String>();
		newCategory = new ArrayList<String>();
		newTitle = new ArrayList<String>();
		newId  = new ArrayList<String>();
	}

	/**
	 * setApplicationLayoutData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setApplicationLayoutData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			category.add(testData[i][1]);
			title.add(testData[i][2]);
		    id.add(testData[i][3]);
		    portletName.add(testData[i][4]);
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
		newTitle.clear();
		newId.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newTitle.add(this.title.get(i));
				newCategory.add(this.category.get(i));
				newId.add(this.id.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newTitle.size());
		return index;
	}
	
	/** 
	 * Get get Portlet Id by index
	 * @param index
	 * @return id.get(index)
	 */
	public String getPortletIdByIndex(int index){
		return id.get(index);
	}
	
	/**
	 * Get getPortlet name by index
	 * @param index
	 * @return portletName.get(index)
	 */
	public String getPortletNameByIndex(int index){
		return portletName.get(index);
	}
	
	
	/**
	 * Get get Portlet Category by index
	 * @param index
	 * @return category.get(index)
	 */
	public String getPorletCategoryByIndex(int index){
		return category.get(index);
	}
	
	/**
	 * Get Category Application by index
	 * @param index
	 * @return category.get(index)
	 */
	public String getCategoryApplicationByIndex(int index){
		return category.get(index);
	}
	
	/**
	 * Get Title Application by index
	 * @param index
	 * @return title.get(index)
	 */
	public String getTitleApplicationByIndex(int index){
		return title.get(index);
	}
	
	/**
	 * Get Id Application by index
	 * @param index
	 * @return id.get(index)
	 */
	public String getIdApplicationByIndex(int index){
		return id.get(index);
	}
	
}
