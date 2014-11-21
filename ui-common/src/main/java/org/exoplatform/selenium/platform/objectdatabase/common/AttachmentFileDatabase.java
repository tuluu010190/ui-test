package org.exoplatform.selenium.platform.objectdatabase.common;

import java.util.ArrayList;
import java.util.Random;

public class AttachmentFileDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> attachName;

	/**
	 * AttachmentFileDatabase
	 * @param type
	 * @param attachName
	 */
	public AttachmentFileDatabase(ArrayList<Integer> type, ArrayList<String> attachName){
		this.type = type;
		this.attachName = attachName;
	}

	/**
	 * AttachmentFileDatabase
	 */
	public AttachmentFileDatabase(){
		type  = new ArrayList<Integer>();
		attachName  = new ArrayList<String>();
	}

	/**
	 * setAttachFileData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setAttachFileData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			attachName.add(testData[i][1]);
		}
	}

	/**
	 * Get file name by index
	 * @param index
	 * @return
	 */
	public String getAttachFileByIndex(int index){
		return attachName.get(index);
	}
	
	/**
	 * get file name random
	 * @return
	 */
	public String getAttachFileRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.attachName.size());
		String attachFile = this.attachName.get(index);
		return attachFile;
	}

	/**
	 * getArrayAttachFileByType
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArrayAttachFileByType(int type){
		ArrayList<String> arrayAttachFile = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				arrayAttachFile.add(this.attachName.get(i));
			}
		}
		return arrayAttachFile;
	}

	/**
	 * getArrayAttachFileByArrayType
	 * @param type
	 * @return
	 */
	public ArrayList<String> getArrayAttachFileByArrayType(int...type){
		ArrayList<String> arrayAttachFile = new ArrayList<String>();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayAttachFile.add(this.attachName.get(i));
				}
			}
		}
		return arrayAttachFile;
	}

	/**
	 * getAttachFileByArrayTypeRandom
	 * @param type
	 * @return
	 */
	public String getAttachFileByArrayTypeRandom(int...type){
		ArrayList<String> arrayAttachFile = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayAttachFile.add(this.attachName.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(arrayAttachFile.size());
		String attachFile = arrayAttachFile.get(index);
		return attachFile;
	}
}
