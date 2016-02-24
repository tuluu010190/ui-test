package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ProfileContactPhoneDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> phone;
	public ArrayList<String> number;

	/**
	 * ProfileContactPhoneDatabase
	 * @param type
	 * @param phone
	 * @param number
	 */
	public ProfileContactPhoneDatabase(ArrayList<Integer> type, ArrayList<String> phone, ArrayList<String> number){
		this.type = type;
		this.phone = phone;
		this.number = number;
	}

	/**
	 * ProfileContactPhoneDatabase
	 */
	public ProfileContactPhoneDatabase() {
		type  = new ArrayList<Integer>();
		phone  = new ArrayList<String>();
		number  = new ArrayList<String>();
	}

	/**
	 * setContactPhoneData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setContactPhoneData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			phone.add(testData[i][1]);
			number.add(testData[i][2]);
		}
	}
	
	/**
	 * getContactPhoneData
	 * @param index
	 * @return
	 */
	public String getContactPhoneData(int index){
		return phone.get(index);
	}

	/**
	 * getArrayPhoneByType
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArrayPhoneByType(int type){
		ArrayList<String> arrayPhone = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				arrayPhone.add(this.phone.get(i));
			}
		}
		return arrayPhone;
	}

	/**
	 * getPhoneByArrayTypeRandom
	 * @param type
	 * @return
	 */
	public String getPhoneByArrayTypeRandom(int type){
		ArrayList<String> arrayPhone = new ArrayList<String>();
		Random randomGenerator = new Random();
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type)
					arrayPhone.add(this.phone.get(i));
			}
		int index = randomGenerator.nextInt(arrayPhone.size());
		String rePhone = arrayPhone.get(index);
		return rePhone;
	}
}
