package org.niteco.selenium.platform.objectdatabase.common;

import java.util.ArrayList;
import java.util.Random;


public class UserInfoDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> userName;
	public ArrayList<String> firstName;
	public ArrayList<String> lastName;
	public ArrayList<String> password;
	public ArrayList<String> email;
	public ArrayList<String> displayName;
	
	public ArrayList<String> newUserName;
	public ArrayList<String> newFirstName;
	public ArrayList<String> newLastName;
	public ArrayList<String> newPassword;
	public ArrayList<String> newEmail;
	public ArrayList<String> newDisplayName;

	/**
	 * userInfoDatabase
	 * @param type
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 * @param displayName
	 */
	public UserInfoDatabase(ArrayList<Integer> type, ArrayList<String> userName, ArrayList<String> firstName, ArrayList<String> lastName, ArrayList<String> password, ArrayList<String> email, ArrayList<String> displayName){
		this.type = type;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.displayName = displayName;
	}

	/**
	 * userInfoDatabase
	 */
	public UserInfoDatabase(){
		type  = new ArrayList<Integer>();
		userName  = new ArrayList<String>();
		firstName = new ArrayList<String>();
		lastName = new ArrayList<String>();
		password = new ArrayList<String>();
		email = new ArrayList<String>();
		displayName = new ArrayList<String>();
		
		newUserName=new ArrayList<String>();
		newFirstName=new ArrayList<String>();
		newLastName=new ArrayList<String>();
		newPassword=new ArrayList<String>();
		newEmail=new ArrayList<String>();
		newDisplayName=new ArrayList<String>();
	}

	/**
	 * setContentData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setUserInfoData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length-1; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			userName.add(testData[i][1]);
			firstName.add(testData[i][2]);
			lastName.add(testData[i][3]);
			password.add(testData[i][4]);
			email.add(testData[i][5]);
			displayName.add(testData[i][6]);
		}
	}
	
	/**
	 * Get user name by index
	 * @param index
	 * @return userName.get(index)
	 */
	public String getUserNameByIndex(int index){
		return userName.get(index);
	}
	
	/**
	 * get user name random
	 * @return userName
	 */
	public String getUserNameRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.userName.size());
		String userName = this.userName.get(index);
		return userName;
	}
	
	/**
	 * Get First name by index
	 * @param index
	 * @return firstName.get(index)
	 */
	public String getFirstNameByIndex(int index){
		return firstName.get(index);
	}
	
	/**
	 * get First name random
	 * @return firstName
	 */
	public String getFirstNameRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.firstName.size());
		String firstName = this.firstName.get(index);
		return firstName;
	}
	
	/**
	 * Get Last name by index
	 * @param index
	 * @return lastName.get(index)
	 */
	public String getLastNameByIndex(int index){
		return lastName.get(index);
	}
	
	/**
	 * get Last name random
	 * @return lastName
	 */
	public String getLastNameRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.lastName.size());
		String lastName = this.lastName.get(index);
		return lastName;
	}
	
	/**
	 * Get pass word by index
	 * @param index
	 * @return password.get(index)
	 */
	public String getPassWordByIndex(int index){
		return password.get(index);
	}
	
	/**
	 * get Pass Word random
	 * @return password
	 */
	public String getPassWordRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.password.size());
		String password = this.password.get(index);
		return password;
	}
	
	/**
	 * Get email by index
	 * @param index
	 * @return email.get(index)
	 */
	public String getEmailByIndex(int index){
		return email.get(index);
	}
	
	/**
	 * get email random
	 * @return email
	 */
	public String getEmailRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.email.size());
		String email = this.email.get(index);
		return email;
	}
	
	/**
	 * Get display name by index
	 * @param index
	 * @return displayName.get(index)
	 */
	public String getDisplayNameByIndex(int index){
		return displayName.get(index);
	}
	
	/**
	 * get display name random
	 * @return displayName
	 */
	public String getDisplayNameRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.displayName.size());
		String displayName = this.displayName.get(index);
		return displayName;
	}

	/**
	 * Get data by type
	 * @param type
	 * @return index
	 */
	public Integer getRandomIndexByType(int type){
		Random randomGenerator = new Random();
		newUserName.clear();
		newFirstName.clear();
		newLastName.clear();
		newPassword.clear();
		newEmail.clear();
		newDisplayName.clear();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newUserName.add(this.userName.get(i));
				newFirstName.add(this.firstName.get(i));
				newLastName.add(this.lastName.get(i));
				newPassword.add(this.password.get(i));
				newEmail.add(this.email.get(i));
				newDisplayName.add(this.displayName.get(i));
			}
		}
		Integer index = randomGenerator.nextInt(newUserName.size());
		return index;
	}
}
