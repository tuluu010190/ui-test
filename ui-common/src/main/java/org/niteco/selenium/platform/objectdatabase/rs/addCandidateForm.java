package org.niteco.selenium.platform.objectdatabase.rs;

import java.util.ArrayList;

import org.niteco.selenium.platform.objectdatabase.common.DatabaseResource;

public class addCandidateForm {

	public ArrayList<Integer> type;
	public ArrayList<String> source;
	public ArrayList<String> job;
	
	
	public addCandidateForm(ArrayList<Integer> type, ArrayList<String> source, ArrayList<String> job){
		this.type = type;
		this.source = source;
		this.job = job;
	}
	
	/**
	 * UserDatabase
	 */
	public addCandidateForm(){
		type  = new ArrayList<Integer>();
		source  = new ArrayList<String>();
		job  = new ArrayList<String>();
	}
	
	 /**
     * Set data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		System.out.println("file is:" + userDataFile);
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			//type.add(Integer.valueOf(testData[i][0]));
			source.add(testData[i][1]);
			job.add(testData[i][2]);
		}
	}
	
	/**
	 * Get source by index
	 * @param index
	 * @return
	 */
	public String getSourceByIndex(int index){
		return source.get(index);
	}
	
	/**
	 * Get Job by index
	 * @param index
	 * @return
	 */
	public String getJobByIndex(int index){
		return job.get(index);
	}
}
