package org.exoplatform.selenium.platform.objectdatabase.common;

import java.util.ArrayList;
import java.util.Random;


public class MembershipDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> membership;

	/**
	 * MembershipDatabase
	 * @param type
	 * @param membership
	 */
	public MembershipDatabase(ArrayList<Integer> type, ArrayList<String> membership){
		this.type = type;
		this.membership = membership;
	}

	/**
	 * MembershipDatabase
	 */
	public MembershipDatabase(){
		type = new ArrayList<Integer>();
		membership  = new ArrayList<String>();
	}

	/**
	 * setMembershipData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setMembershipData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			membership.add(testData[i][1]);
		}
	}
	
	/**
	 * Get membership by index
	 * @param index
	 * @return membership.get(index);
	 */
	public String getMembershipByIndex(int index){
		return membership.get(index);
	}
	
	/**
	 * get membership random
	 * @return membership
	 */
	public String getMembershipRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.membership.size());
		String membership = this.membership.get(index);
		return membership;
	}
}
