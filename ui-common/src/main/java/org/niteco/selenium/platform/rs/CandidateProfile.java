package org.niteco.selenium.platform.rs;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CandidateProfile extends RSLocators{
	
	/**
	 * constructor
	 * @param dr
	 */
	public CandidateProfile(WebDriver dr){
		this.driver=dr;
	}
	
	/**
	 * Verify candidate profile
	 * @param fullName
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 */
	public void verifyBasicCandidateProfile(String fullName, String firstName, String lastName, String phone, String email, String job, String fileName){
		if(fullName != null && fullName != "") {
			info("Varify full Name");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_FULL_NAME.replace("${fullName}", fullName)), DEFAULT_TIMEOUT, 1);
		}
		if(firstName != null && firstName != "") {
			info("Verify first name");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_FIRST_NAME.replace("${firstName}", firstName)), DEFAULT_TIMEOUT, 1);
		}
		if(lastName != null && lastName != "") {
			info("Veryfi Last Name");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_LAST_NAME.replace("${lastName}", lastName)), DEFAULT_TIMEOUT, 1);
		}
		if(phone != null && phone != "") {
			info("Verify Phone");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_PHONE.replace("${phone}", phone)), DEFAULT_TIMEOUT, 1);
		}
		if(email != null && email != "") {
			info("Verify email");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_EMAIL.replace("${email}", email)), DEFAULT_TIMEOUT, 1);
		}
		if(job != null && job != "") {
			info("Verify job");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_JOB.replace("${job}", job)), DEFAULT_TIMEOUT, 1);
		}
		if(fileName != null && fileName != "") {
			info("Verify attach file name");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_ATTACH_FILE.replace("${fileName}", fileName)), DEFAULT_TIMEOUT, 1);
		}
	}
	
	/**
	 * Verify update candidate profile from Exam
	 * @param fullName
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 */
	public void verifyUpdateCandidateProfileFromExam(String dateOfBirth, String gender, String nationality, String country, String region, String locality, String address,
													String postalCode, String currentSalary, String expecedSalary, String workingLocation, String plannedStartDate){
		if(dateOfBirth != null && dateOfBirth != "") {
			info("Verify date of birth");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_DOB.replace("${dateOfBirth}", dateOfBirth)), DEFAULT_TIMEOUT, 1);
		}
		if(gender != null && gender != "") {
			info("Verify gender");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_GENDER.replace("${gender}", gender)), DEFAULT_TIMEOUT, 1);
		}
		if(nationality != null && nationality != "") {
			info("Verify nationality");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_NATIONALITY.replace("${nationality}", nationality)), DEFAULT_TIMEOUT, 1);
		}
		if(country != null && country != "") {
			info("Verify country");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_COUNTRY.replace("${country}", country)), DEFAULT_TIMEOUT, 1);
		}
		if(region != null && region != "") {
			info("Verify region");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_REGION.replace("${region}", region)), DEFAULT_TIMEOUT, 1);
		}
		if(locality != null && locality != "") {
			info("Verify locality");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_LOCALITY.replace("${locality}", locality)), DEFAULT_TIMEOUT, 1);
		}
		if(address != null && address != "") {
			info("Verify address");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_ADDRESS.replace("${address}", address)), DEFAULT_TIMEOUT, 1);
		}
		if(postalCode != null && postalCode != "") {
			info("Verify postalCode");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_POSTAL_CODE.replace("${postalCode}", postalCode)), DEFAULT_TIMEOUT, 1);
		}
		if(currentSalary != null && currentSalary != "") {
			info("Verify current Salary");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_CURRENT_SALARY.replace("${currentSalary}", currentSalary)), DEFAULT_TIMEOUT, 1);
		}
		if(expecedSalary != null && expecedSalary != "") {
			info("Verify expeced Salary");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_EXPECTED_SALARY.replace("${expecedSalary}", expecedSalary)), DEFAULT_TIMEOUT, 1);
		}
		if(workingLocation != null && workingLocation != "") {
			info("Verify working Location");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_WORKING_LOCATION.replace("${workingLocation}", workingLocation)), DEFAULT_TIMEOUT, 1);
		}
		if(plannedStartDate != null && plannedStartDate != "") {
			info("Verify planned Start Date");
			waitForAndGetElement(By.xpath(ELEMENT_RS_CANDIDATE_PROFILE_PLANNED_START_DATE.replace("${plannedStartDate}", plannedStartDate)), DEFAULT_TIMEOUT, 1);
		}
	}
	
	
	/**
	 * Go to add information for candidate
	 */
	public void goToAddInformationForCandiDate(){
		info("go to add information for candidate");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_ADD_INFORMATION_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_PROFILE_ADD_INFORMATION_BTN);
		Utils.pause(3000);
	}
	
	/**
	 * Go to add exam for candidate
	 */
	public void goToAddExam(){
		info("Go to add exam");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_NAV_BAR_EXAMS, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_PROFILE_NAV_BAR_EXAMS);
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_TITLE, DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Go to change status for candidate
	 */
	public void goToChangeStatus(){
		info("Go to change status");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_NAV_BAR_STATUS, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_PROFILE_NAV_BAR_STATUS);
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_STATUS_TITLE, DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Go to add exam for candidate
	 * @param choose
	 * @param group
	 * @param durations
	 */
	public void createExam(boolean choose, String group, String durations){
		info("create exam for candidate");
		info("Choose exam group");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_GROUP, DEFAULT_TIMEOUT, 1);
		if (choose == true) {
			click(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_GROUP);
			type(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_GROUP, group, true);
			waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_SELECT.replace("${group}", group), DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_SELECT.replace("${group}", group));
		}
		else {
			click(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_GROUP);
			type(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_GROUP, group, true);
			pressEnterKey();
		}
		Utils.pause(2000);
		info("enter duration");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_DURATION, DEFAULT_TIMEOUT, 1);
		type(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_DURATION, durations, true);
		Utils.pause(2000);
		info("Click create button");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_CREATE_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_CREATE_BTN);
	}
	
	/**
	 * Verify exam badge number
	 * @param numberExams
	 */
	public void verifyExamsBadgeNumber(String numberExams){
		info("verify number of exam in badge");
		Utils.pause(3000);
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_AS_NAV_BAR_EXAMS_BADGE.replace("${number}", numberExams), DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Go to exam tab in as
	 */
	public void goToExamsTabInAS(){
		info("Go to exam tab in as");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_AS_NAV_BAR_EXAMS, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_PROFILE_AS_NAV_BAR_EXAMS);
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_LOCATION, DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Go to specific exam in as
	 */
	public void goToSpecificExamInAS(){
		info("Go to specific exam in as");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_LOCATION, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_LOCATION);
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_TEST_LINK, DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Go to specific exam result in as
	 */
	public void goToSpecificExamResultInAS(){
		info("Go to specific exam result in as");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_RESULT, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_RESULT);
		Utils.pause(2000);
	}
	
}
