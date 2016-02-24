package org.niteco.selenium.platform.rs;

import static org.niteco.selenium.TestLogger.info;

import org.niteco.selenium.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;

public class ExamPage extends RSLocators{
	
	Action action;
	
	/**
	 * constructor
	 * @param dr
	 */
	public ExamPage(WebDriver dr){
		this.driver=dr;
	}
	
	/**
	 * Enter personal information in exam
	 * @param fullName
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param gender
	 * @param nationality
	 */
	public void enterPersonalInformationInExam(String fullName, String firstName, String lastName, String dateOfBirth, String gender, String nationality){
		info("Enter personal information in exam");
		if (fullName != null && fullName != ""){
			Utils.pause(1000);
			info("Enter full name");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_FULL_NAME, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_FULL_NAME, fullName, true);
		}
		if (firstName != null && firstName != ""){
			Utils.pause(1000);
			info("Enter first name");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_FIRST_NAME, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_FIRST_NAME, firstName, true);
		}
		if (lastName != null && lastName != ""){
			Utils.pause(1000);
			info("Enter last name");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LAST_NAME, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LAST_NAME, lastName, true);
		}
		if (dateOfBirth != null && dateOfBirth != ""){
			Utils.pause(1000);
			info("Enter date of birth");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_DOB, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_DOB, dateOfBirth, true);
			pressEnterKey();
		}
		if (gender != null && gender != ""){
			Utils.pause(1000);
			info("Choose gender");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_GENDER, DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_GENDER, 2);
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_GENDER_SELECT.replace("${gender}", gender), DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_GENDER_SELECT.replace("${gender}", gender), 2);
		}
		if (nationality != null && nationality != ""){
			Utils.pause(1000);
			info("Type Nationality");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_NATIONALITY, DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_NATIONALITY, 2);
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_NATIONALITY_SEARCH, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_NATIONALITY_SEARCH, nationality, true);
			pressEnterKey();
		}
	}
	
	/**
	 * Enter contact information in exam
	 * @param phone
	 * @param email
	 * @param phone
	 * @param country
	 * @param region
	 * @param locality
	 * @param address
	 * @param posalCode
	 * @param url
	 */
	public void enterContactInformationInExam(String phone, String email, String country, String region, String locality, String address, String postalCode, String url){
		info("Enter contact information in exam");
		if (phone != null && phone != ""){
			Utils.pause(1000);
			info("Enter phone ");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_PHONE, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_PHONE, phone, true);
		}
		if (email != null && email != ""){
			Utils.pause(1000);
			info("Enter email ");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_EMAIL, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_EMAIL, email, true);
		}
		if (country != null && country != ""){
			Utils.pause(1000);
			info("Enter country");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_COUNTRY, DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_COUNTRY, 2);
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_COUNTRY_SEARCH, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_COUNTRY_SEARCH, country, true);
			pressEnterKey();
		}
		if (region != null && region != ""){
			Utils.pause(1000);
			info("Enter region");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_REGION, DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_REGION, 2);
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_REGION_SEARCH, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_REGION_SEARCH, region, true);
			pressEnterKey();
		}
		if (locality != null && locality != ""){
			Utils.pause(1000);
			info("Enter locality");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LOCALITY, DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LOCALITY, 2);
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LOCALITY_SEARCH, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LOCALITY_SEARCH, locality, true);
			pressEnterKey();
		}
		if (address != null && address != ""){
			Utils.pause(1000);
			info("Enter address");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_ADDRESS, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_ADDRESS, address, true);
		}
		if (postalCode != null && postalCode != ""){
			Utils.pause(1000);
			info("Enter posalCode");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_POSTAL_CODE, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_POSTAL_CODE, postalCode, true);
		}	
		if (url != null && url != ""){
			Utils.pause(1000);
			info("Enter url");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_URL, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_URL, url, true);
		}	
	}
	
	/**
	 * Enter recruitment information in exam
	 * @param currentSalary
	 * @param expecedSalary
	 * @param plannedStartDate
	 * @param workingLocation
	 */
	public void enterRecruitmenttInformationInExam(String currentSalary, String expecedSalary, String plannedStartDate, String workingLocation){
		info("Enter recruitment information in exam");
		if (currentSalary != null && currentSalary != ""){
			Utils.pause(1000);
			info("Enter current salary ");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_CURRENT_SALARY, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_CURRENT_SALARY, currentSalary, true);
		}
		if (expecedSalary != null && expecedSalary != ""){
			Utils.pause(1000);
			info("Enter expeced salary ");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_EXPECTED_SALARY, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_EXPECTED_SALARY, expecedSalary, true);
		}
		if (plannedStartDate != null && plannedStartDate != ""){
			Utils.pause(1000);
			info("Enter planned start date");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_PLANNED_START_DATE, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_PLANNED_START_DATE, plannedStartDate, true);
			pressEnterKey();
			Utils.pause(1000);
		}
		if (workingLocation != null && workingLocation != ""){
			Utils.pause(1000);
			info("Enter working location");
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_WORKING_LOCATION, DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_WORKING_LOCATION, 2);
			waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_WORKING_LOCATION_SEARCH, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_WORKING_LOCATION_SEARCH, workingLocation, true);
			pressEnterKey();
			Utils.pause(1000);
		}
	}
	
	/**
	 * Enter skills information in exam
	 * @param skill
	 * @param level
	 * @param lastUsed
	 * @param
	 */
	public void enterSkillsInformationInExam(String[] skill, String[] level, String []lastUsed){
		info("Enter skills information in exam");
		for(int i = 0; i < skill.length; i ++){
			if(i == 0) {
				if (skill[i] != null && skill[i] != "") {
					Utils.pause(1000);
					info("type skills");
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_DEFAULT.replace("${skill}", "C#.NET"), DEFAULT_TIMEOUT, 1);
					click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_DEFAULT.replace("${skill}", "C#.NET"));
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH, DEFAULT_TIMEOUT, 1);
					type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH, skill[i], true);
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH_SELECT.replace("${skill}", skill[0]), DEFAULT_TIMEOUT, 1);
					click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH_SELECT.replace("${skill}", skill[0]));
					Utils.pause(1000);
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_ADD_BTN, DEFAULT_TIMEOUT, 1);
					click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_ADD_BTN);
					info("Choose level");
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LEVEL.replace("${skill}", skill[i]).replace("${level}", level[i]), DEFAULT_TIMEOUT, 1);
					click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LEVEL.replace("${skill}", skill[i]).replace("${level}", level[i]));
					info("Choose last Used");
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LAST_USED.replace("${skill}", skill[i]), DEFAULT_TIMEOUT, 1);
					type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LAST_USED.replace("${skill}", skill[i]), lastUsed[i], true);
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SELECT.replace("${skill}", skill[i]), DEFAULT_TIMEOUT, 1);
				}
			}
			else if (i >=1) {
				if(skill[i] != null && skill[i] != "") {
					Utils.pause(1000);
					info("type skills");
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_DEFAULT.replace("${skill}", skill[i - 1]), DEFAULT_TIMEOUT, 1);
					click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_DEFAULT.replace("${skill}", skill[i - 1]));
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH, DEFAULT_TIMEOUT, 1);
					type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH, skill[i], true);
					pressEnterKey();
					Utils.pause(1000);
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_ADD_BTN, DEFAULT_TIMEOUT, 1);
					click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_ADD_BTN);
					info("Choose level");
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LEVEL.replace("${skill}", skill[i]).replace("${level}", level[i]), DEFAULT_TIMEOUT, 1);
					click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LEVEL.replace("${skill}", skill[i]).replace("${level}", level[i]));
					info("Choose last Used");
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LAST_USED.replace("${skill}", skill[i]), DEFAULT_TIMEOUT, 1);
					type(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LAST_USED.replace("${skill}", skill[i]), lastUsed[i], true);
					waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SELECT.replace("${skill}", skill[i]), DEFAULT_TIMEOUT, 1);
				}
			}
		}
	}
	
	/**
	 * Continue to exam
	 */
	public void continueToExam(){
		Utils.pause(1000);
		info("go to continue the exam");
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_CONTINUE_EXAM_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_CONTINUE_EXAM_BTN);
		waitForElementNotPresent(ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_CONTINUE_EXAM_BTN);
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_TITLE, DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Start exam
	 */
	public void startExam(){
		Utils.pause(1000);
		info("Start the exam");
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_START_EXAM_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_EXAM_PAGE_DO_EXAM_START_EXAM_BTN);
		waitForElementNotPresent(ELEMENT_RS_EXAM_PAGE_DO_EXAM_START_EXAM_BTN);
		Utils.pause(3000);
	}
	
	/**
	 * Skip exam
	 */
	public void skipExam(){
		Utils.pause(1000);
		info("Start the exam");
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_SKIP_EXAM_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_EXAM_PAGE_DO_EXAM_SKIP_EXAM_BTN);
		waitForElementNotPresent(ELEMENT_RS_EXAM_PAGE_DO_EXAM_SKIP_EXAM_BTN);
		Utils.pause(3000);
	}
	
	/**
	 * End exam
	 */
	public void endExam(){
		Utils.pause(1000);
		info("Start the exam");
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN);
		//alert.acceptAlert();
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN_OK_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN_OK_BTN);
		waitForElementNotPresent(ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN);
		Utils.pause(1000);
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_THANKS, DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * go To next Question
	 */
	public void nextQuestion(){
		Utils.pause(1000);
		info("go To next Question");
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_NEXT_QST_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_EXAM_PAGE_DO_EXAM_NEXT_QST_BTN);
		Utils.pause(1000);
	}
	
	/**
	 * go back prev Question
	 */
	public void prevQuestion(){
		Utils.pause(1000);
		info("go back prev Question");
		waitForAndGetElement(ELEMENT_RS_EXAM_PAGE_DO_EXAM_PREV_QST_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_EXAM_PAGE_DO_EXAM_PREV_QST_BTN);
		Utils.pause(1000);
	}
}