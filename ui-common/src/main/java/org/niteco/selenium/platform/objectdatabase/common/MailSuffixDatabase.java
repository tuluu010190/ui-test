package org.niteco.selenium.platform.objectdatabase.common;

import java.util.ArrayList;
import java.util.Random;


public class MailSuffixDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> mailSuffix;

	/**
	 * mailSuffixDatabase
	 * @param type
	 * @param content
	 */
	public MailSuffixDatabase(ArrayList<Integer> type, ArrayList<String> mailSuffix){
		this.type = type;
		this.mailSuffix = mailSuffix;
	}

	/**
	 * mailSuffixDatabase
	 */
	public MailSuffixDatabase(){
		type  = new ArrayList<Integer>();
		mailSuffix  = new ArrayList<String>();
	}

	/**
	 * setContentData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setMailSuffixData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			mailSuffix.add(testData[i][1]);
		}
	}
	
	/**
	 * Get Mail Suffix by index
	 * @param index
	 * @return mailSuffix.get(index)
	 */
	public String getMailSuffixByIndex(int index){
		return mailSuffix.get(index);
	}
	
	/**
	 * get Mail Suffix random
	 * @return mailSuffix
	 */
	public String getMailSuffixRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.mailSuffix.size());
		String mailSuffix = this.mailSuffix.get(index);
		return mailSuffix;
	}
}
