package org.exoplatform.selenium.platform.objectdatabase.social;

import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;

public class ProfileContactIMDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> im;
	public ArrayList<String> name;

	/**
	 * ProfileContactIMDatabase
	 * @param type
	 * @param im
	 * @param name
	 */
	public ProfileContactIMDatabase(ArrayList<Integer> type, ArrayList<String> im, ArrayList<String> name){
		this.type = type;
		this.im = im;
		this.name = name;
	}

	/**
	 * ProfileContactIMDatabase
	 */
	public ProfileContactIMDatabase() {
		type  = new ArrayList<Integer>();
		im  = new ArrayList<String>();
		name  = new ArrayList<String>();
	}

	/**
	 * setProfileIMData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setProfileIMData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			im.add(testData[i][1]);
			name.add(testData[i][2]);
		}
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getProfileIM(int index){
		return im.get(index);
	}
	
	/**
	 * getArrayIMByType
	 * @param type
	 * @return arrayIm
	 */
	public ArrayList<String> getArrayIMByType(int type){
		ArrayList<String> arrayIm = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				arrayIm.add(this.im.get(i));
			}
		}
		return arrayIm;
	}
	
	/**
	 * getImByArrayTypeRandom
	 * @param type
	 * @return reIm
	 */
	public String getImByArrayTypeRandom(int type){
		ArrayList<String> arrayIm = new ArrayList<String>();
		Random randomGenerator = new Random();
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type)
					arrayIm.add(this.im.get(i));
			}
		int index = randomGenerator.nextInt(arrayIm.size());
		String reIm = arrayIm.get(index);
		return reIm;
	}
}
