package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class NotificationCategoryDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> category;
	
	public NotificationCategoryDatabase(ArrayList<Integer> type, ArrayList<String> category){
		this.type = type;
		this.category = category;
		
	}

	public NotificationCategoryDatabase() {
		type  = new ArrayList<Integer>();
		category  = new ArrayList<String>();
	}

	public void setData(String userDataFile, String userSheet,Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			if (!testData[i][1].isEmpty()) {
				info("category:" + i + " " + testData[i][1]);
				type.add(Integer.valueOf(testData[i][0]));
				category.add(testData[i][1]);
			}
		}
	}
	
	/**
	 * Get category from file by random type
	 * @param type
	 * @return category
	 */
	public String getCategoryByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.category.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(array.size());
		String category= array.get(index);
		info("Category is: "+category);
		return category;
	}
}
