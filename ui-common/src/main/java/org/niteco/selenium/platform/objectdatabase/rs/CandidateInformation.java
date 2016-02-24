package org.niteco.selenium.platform.objectdatabase.rs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import org.exoplatform.selenium.platform.objectdatabase.common.DatabaseResource;



public class CandidateInformation {

	public ArrayList<Integer> type;
	public ArrayList<String> fullName;
	public ArrayList<String> firstName;
	public ArrayList<String> lastName;
	public ArrayList<String> email;
	public ArrayList<String> phone;
	public ArrayList<String> dateOfBirth;
	public ArrayList<String> gender;
	public ArrayList<String> nationality;
	public ArrayList<String> region;
	public ArrayList<String> locality;
	public ArrayList<String> postalCode;
	public ArrayList<String> currentSalary;
	public ArrayList<String> expectedSalary;
	public ArrayList<String> planedStartDate;
	public ArrayList<String> workingLocation;
	public ArrayList<String> address;
	public ArrayList<String> filePath;
	public ArrayList<String> fileName;
	public ArrayList<String> source;
	public ArrayList<String> job;
	public ArrayList<String> skill1;
	public ArrayList<String> levelSkill1;
	public ArrayList<String> lastUsedSkill1;
	public ArrayList<String> skill2;
	public ArrayList<String> levelSkill2;
	public ArrayList<String> lastUsedSkill2;
	public ArrayList<String> skill3;
	public ArrayList<String> levelSkill3;
	public ArrayList<String> lastUsedSkill3;
	public ArrayList<String> examGroup;
	public ArrayList<String> examDuration;
	public ArrayList<String> updateGender;
	public ArrayList<String> updateNationality;
	
	
	public CandidateInformation(ArrayList<Integer> type, ArrayList<String> fullName, ArrayList<String> firstName, ArrayList<String> lastName, ArrayList<String> email, ArrayList<String> phone,
			ArrayList<String> dateOfBirth, ArrayList<String> gender,ArrayList<String> nationality, ArrayList<String> region, ArrayList<String> locality, ArrayList<String> postalCode,
			ArrayList<String> currentSalary, ArrayList<String> expectedSalary, ArrayList<String> planedStartDate, ArrayList<String> workingLocation, ArrayList<String> address,
			ArrayList<String> filePath, ArrayList<String> fileName, ArrayList<String> source, ArrayList<String> job, ArrayList<String> skill1, ArrayList<String> levelSkill1,ArrayList<String> lastUsedSkill1,
			ArrayList<String> skill2, ArrayList<String> levelSkill2, ArrayList<String> lastUsedSkill2, ArrayList<String> skill3, ArrayList<String> levelSkill3, ArrayList<String> lastUsedSkill3,
			ArrayList<String> examGroup, ArrayList<String> examDuration, ArrayList<String> updateGender, ArrayList<String> updateNationality){
		this.type = type;
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.region = region;
		this.locality = locality;
		this.postalCode = postalCode;
		this.currentSalary = currentSalary;
		this.expectedSalary = expectedSalary;
		this.planedStartDate = planedStartDate;
		this.workingLocation = workingLocation;
		this.address = address;
		this.filePath = filePath;
		this.fileName = fileName;
		this.source = source;
		this.job = job;
		
		this.skill1 = skill1;
		this.levelSkill1 = levelSkill1;
		this.lastUsedSkill1 = lastUsedSkill1;
		
		this.skill2 = skill2;
		this.levelSkill2 = levelSkill2;
		this.lastUsedSkill2 = lastUsedSkill2;
		
		this.skill3 = skill3;
		this.levelSkill3 = levelSkill3;
		this.lastUsedSkill3 = lastUsedSkill3;
		
		this.examGroup = examGroup;
		this.examDuration = examDuration;
		
		this.examDuration = updateGender;
		this.examDuration = updateNationality;
		
	}
	
	/**
	 * UserDatabase
	 */
	public CandidateInformation(){
		type  = new ArrayList<Integer>();
		fullName  = new ArrayList<String>();
		firstName  = new ArrayList<String>();
		lastName  = new ArrayList<String>();
		email  = new ArrayList<String>();
		phone  = new ArrayList<String>();
		dateOfBirth  = new ArrayList<String>();
		gender  = new ArrayList<String>();
		nationality  = new ArrayList<String>();
		region  = new ArrayList<String>();
		locality  = new ArrayList<String>();
		postalCode  = new ArrayList<String>();
		currentSalary  = new ArrayList<String>();
		expectedSalary  = new ArrayList<String>();
		planedStartDate  = new ArrayList<String>();
		workingLocation  = new ArrayList<String>();
		address = new ArrayList<String>();
		filePath = new ArrayList<String>();
		fileName = new ArrayList<String>();
		source = new ArrayList<String>();
		job = new ArrayList<String>();
		skill1 = new ArrayList<String>();
		levelSkill1 = new ArrayList<String>();
		lastUsedSkill1 = new ArrayList<String>();
		skill2 = new ArrayList<String>();
		levelSkill2 = new ArrayList<String>();
		lastUsedSkill2 = new ArrayList<String>();
		skill3 = new ArrayList<String>();
		levelSkill3 = new ArrayList<String>();
		lastUsedSkill3 = new ArrayList<String>();
		examGroup = new ArrayList<String>();
		examDuration = new ArrayList<String>();
		updateGender = new ArrayList<String>();
		updateNationality = new ArrayList<String>();
	}
	
	/* *//**
     * Set data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     *//*
	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		System.out.println("file is:" + userDataFile);
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			//type.add(Integer.valueOf(testData[i][0]));
			fullName.add(testData[i][1]);
			firstName.add(testData[i][2]);
			lastName.add(testData[i][3]);
			email.add(testData[i][4]);
			phone.add(testData[i][5]);
			dateOfBirth.add(testData[i][6]);
			gender.add(testData[i][7]);
			nationality.add(testData[i][8]);
			region.add(testData[i][9]);
			locality.add(testData[i][10]);
			address.add(testData[i][11]);
			postalCode.add(testData[i][12]);
			currentSalary.add(testData[i][13]);
			expectedSalary.add(testData[i][14]);
			planedStartDate.add(testData[i][15]);
			workingLocation.add(testData[i][16]);
			filePath.add(testData[i][17]);
			fileName.add(testData[i][18]);
			source.add(testData[i][19]);
			job.add(testData[i][20]);
			
			skill1.add(testData[i][21]);
			levelSkill1.add(testData[i][22]);
			lastUsedSkill1.add(testData[i][23]);
			
			skill2.add(testData[i][24]);
			levelSkill2.add(testData[i][25]);
			lastUsedSkill2.add(testData[i][26]);
			
			skill3.add(testData[i][27]);
			levelSkill3.add(testData[i][28]);
			lastUsedSkill3.add(testData[i][29]);
			
			examGroup.add(testData[i][30]);
			examDuration.add(testData[i][31]);
		}
	}*/
	
	 /**
     * Set data
     * @param userDataFile
     * @param userSheet
     * @param opParams
     * @throws Exception
     */
	public void setData(String userDataFile, String userSheet, Object... opParams){
		System.out.println("file is:" + userDataFile);
		String[][] testData;
		try {
			testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
			for(int i = 0; i<testData.length; i++)
			{	
				//type.add(Integer.valueOf(testData[i][0]));
				fullName.add(testData[i][1]);
				firstName.add(testData[i][2]);
				lastName.add(testData[i][3]);
				email.add(testData[i][4]);
				phone.add(testData[i][5]);
				dateOfBirth.add(testData[i][6]);
				gender.add(testData[i][7]);
				nationality.add(testData[i][8]);
				region.add(testData[i][9]);
				locality.add(testData[i][10]);
				address.add(testData[i][11]);
				postalCode.add(testData[i][12]);
				currentSalary.add(testData[i][13]);
				expectedSalary.add(testData[i][14]);
				planedStartDate.add(testData[i][15]);
				workingLocation.add(testData[i][16]);
				filePath.add(testData[i][17]);
				fileName.add(testData[i][18]);
				source.add(testData[i][19]);
				job.add(testData[i][20]);
				
				skill1.add(testData[i][21]);
				levelSkill1.add(testData[i][22]);
				lastUsedSkill1.add(testData[i][23]);
				
				skill2.add(testData[i][24]);
				levelSkill2.add(testData[i][25]);
				lastUsedSkill2.add(testData[i][26]);
				
				skill3.add(testData[i][27]);
				levelSkill3.add(testData[i][28]);
				lastUsedSkill3.add(testData[i][29]);
				
				examGroup.add(testData[i][30]);
				examDuration.add(testData[i][31]);
				updateGender.add(testData[i][32]);
				updateNationality.add(testData[i][33]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get full name by index
	 * @param index
	 * @return
	 */
	public String getFullNameByIndex(int index){
		return fullName.get(index);
	}
	
	/**
	 * Get Full name by random
	 * @return className;
	 */
	public String getFullNameByRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.fullName.size());
		return this.fullName.get(index);
	}
	
	/**
	 * Get first name by index
	 * @param index
	 * @return
	 */
	public String getFirstNameByIndex(int index){
		return firstName.get(index);
	}
	
	/**
	 * Get last name by index
	 * @param index
	 * @return
	 */
	public String getLastNameByIndex(int index){
		return lastName.get(index);
	}
	
	/**
	 * Get email by index
	 * @param index
	 * @return
	 */
	public String getEmailByIndex(int index){
		return email.get(index);
	}
	
	/**
	 * Get phone by index
	 * @param index
	 * @return
	 */
	public String getPhoneByIndex(int index){
		return phone.get(index);
	}
	
	/**
	 * Get date of birth by index
	 * @param index
	 * @return
	 */
	public String getDateOfBirthByIndex(int index){
		return dateOfBirth.get(index);
	}
	
	/**
	 * Get gender by index
	 * @param index
	 * @return
	 */
	public String getGenderByIndex(int index){
		return gender.get(index);
	}
	
	/**
	 * Get address by index
	 * @param index
	 * @return
	 */
	public String getAdressByIndex(int index){
		return address.get(index);
	}
	
	/**
	 * Get Nationality by index
	 * @param index
	 * @return
	 */
	public String getNationalityByIndex(int index){
		return nationality.get(index);
	}
	
	/**
	 * Get Region by index
	 * @param index
	 * @return
	 */
	public String getRegionByIndex(int index){
		return region.get(index);
	}
	
	/**
	 * Get Locality by index
	 * @param index
	 * @return
	 */
	public String getLocalityByIndex(int index){
		return locality.get(index);
	}
	
	/**
	 * Get Current Salary by index
	 * @param index
	 * @return
	 */
	public String getCurrentSalaryCodeByIndex(int index){
		return currentSalary.get(index);
	}
	
	/**
	 * Get Expected Salary by index
	 * @param index
	 * @return
	 */
	public String getExpectedSalaryByIndex(int index){
		return expectedSalary.get(index);
	}
	
	/**
	 * Get Planed Start Date by index
	 * @param index
	 * @return
	 */
	public String getPlanedStartDateByIndex(int index){
		return planedStartDate.get(index);
	}
	
	/**
	 * Get Working Location by index
	 * @param index
	 * @return
	 */
	public String getWorkingLocationByIndex(int index){
		return workingLocation.get(index);
	}
	
	/**
	 * Get Postal Code by index
	 * @param index
	 * @return
	 */
	public String getPostalCodeByIndex(int index){
		return postalCode.get(index);
	}
	
	/**
	 * Get File Path by index
	 * @param index
	 * @return
	 */
	public String getFilePathByIndex(int index){
		return filePath.get(index);
	}
	
	/**
	 * Get File Name by index
	 * @param index
	 * @return
	 */
	public String getFileNameByIndex(int index){
		return fileName.get(index);
	}
	
	/**
	 * Get Source by index
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
	
	/**
	 * Get skill 1 by index
	 * @param index
	 * @return
	 */
	public String getSkill1ByIndex(int index){
		return skill1.get(index);
	}
	
	/**
	 * Get Level skill 1 by index
	 * @param index
	 * @return
	 */
	public String getLevelSkill1ByIndex(int index){
		return levelSkill1.get(index);
	}
	
	/**
	 * Get last Used Skill 1 by index
	 * @param index
	 * @return
	 */
	public String getLastUsedSkill1ByIndex(int index){
		return lastUsedSkill1.get(index);
	}
	
	/**
	 * Get skill 2 by index
	 * @param index
	 * @return
	 */
	public String getSkill2ByIndex(int index){
		return skill2.get(index);
	}
	
	/**
	 * Get Level skill 2 by index
	 * @param index
	 * @return
	 */
	public String getLevelSkill2ByIndex(int index){
		return levelSkill2.get(index);
	}
	
	/**
	 * Get last Used Skill 2 by index
	 * @param index
	 * @return
	 */
	public String getLastUsedSkill2ByIndex(int index){
		return lastUsedSkill2.get(index);
	}
	
	/**
	 * Get skill 3 by index
	 * @param index
	 * @return
	 */
	public String getSkill3ByIndex(int index){
		return skill3.get(index);
	}
	
	/**
	 * Get Level skill 3 by index
	 * @param index
	 * @return
	 */
	public String getLevelSkill3ByIndex(int index){
		return levelSkill3.get(index);
	}
	
	/**
	 * Get last Used Skill 3 by index
	 * @param index
	 * @return
	 */
	public String getLastUsedSkill3ByIndex(int index){
		return lastUsedSkill3.get(index);
	}
	
	/**
	 * Get exam group by index
	 * @param index
	 * @return
	 */
	public String getExamGroupByIndex(int index){
		return examGroup.get(index);
	}
	
	/**
	 * Get Exam Duration by index
	 * @param index
	 * @return
	 */
	public String getExamDurationByIndex(int index){
		return examDuration.get(index);
	}
	
	/**
	 * Get update gender by index
	 * @param index
	 * @return
	 */
	public String getupdateGenderByIndex(int index){
		return updateGender.get(index);
	}
	
	/**
	 * Get Exam Duration by index
	 * @param index
	 * @return
	 */
	public String getupdateNationalityByIndex(int index){
		return updateNationality.get(index);
	}
	
}
