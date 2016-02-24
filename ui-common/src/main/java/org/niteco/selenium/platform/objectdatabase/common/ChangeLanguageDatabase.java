package org.niteco.selenium.platform.objectdatabase.common;

import java.util.ArrayList;
import java.util.Random;

import static org.niteco.selenium.TestLogger.info;

import org.niteco.selenium.platform.objectdatabase.common.DatabaseResource;

public class ChangeLanguageDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> language;
	public ArrayList<String> applyBtn;
	public ArrayList<String> cancelBtn;
	public ArrayList<String> titlePopup;

	public ChangeLanguageDatabase(ArrayList<Integer> type, ArrayList<String> language,ArrayList<String> applyBtn,
			ArrayList<String> cancelBtn,ArrayList<String> titlePopup){
		this.type = type;
		this.language = language;
		this.applyBtn = applyBtn;
		this.cancelBtn = cancelBtn;
		this.titlePopup = titlePopup;
	}
    /**
     * Define array String
     */
	public ChangeLanguageDatabase() {
		type  = new ArrayList<Integer>();
		language  = new ArrayList<String>();
		applyBtn  = new ArrayList<String>();
		cancelBtn  = new ArrayList<String>();
		titlePopup  = new ArrayList<String>();
	}
    /**
     * Set data for change language 
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setChangeLanguageData(String userDataFile, String userSheet,Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		info("size test data:"+(testData.length));
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			language.add(testData[i][1]);
			applyBtn.add(testData[i][2]);
			cancelBtn.add(testData[i][3]);
			titlePopup.add(testData[i][4]);	
			info("testData[i][j]-language:"+testData[i][1]);
			info("testData[i][j]-type:"+testData[i][0]);
		}
	}
	
	/**
	 * Get text content by index
	 * @param index
	 * @return
	 */
	public String getContentByIndex(ArrayList<String> nameArray,int index){
		return nameArray.get(index);
	}
	
	
	/**
	 * Select the content by type with random index
	 * @param type
	 * @return
	 */
	public Integer getRandomIndexByType(int type) {
		ArrayList<String> arrayContent = new ArrayList<String>();
		Random randomGenerator = new Random();
		info("this.type.size : " + this.type.size());
			for (int i = 0; i < this.type.size(); i++) {
				if (this.type.get(i)==type) {
					arrayContent.add(this.language.get(i));
					info("i is :" + i);
					info("this.type.get(i):"+this.type.get(i));
					info("language.get[i]:"+this.language.get(i));
				}
			}
			info("arrayContent.size():"+arrayContent.size());
			Integer index = randomGenerator.nextInt(arrayContent.size());
			info("index is: " + index);
		return index;
	}
}
