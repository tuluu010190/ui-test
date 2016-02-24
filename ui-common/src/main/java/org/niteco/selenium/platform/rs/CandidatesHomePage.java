package org.niteco.selenium.platform.rs;

import static org.niteco.selenium.TestLogger.info;

import org.niteco.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class CandidatesHomePage extends RSLocators{
	
	/**
	 * constructor
	 * @param dr
	 */
	public CandidatesHomePage(WebDriver dr){
		this.driver=dr;
	}
	
	/**
	 * Go to Add Candidates
	 */
	public void goToAddCandidates(){
		info("Click create candidate button");
		waitForAndGetElement(ELEMENT_RS_ADD_CANDIDATES_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_ADD_CANDIDATES_BTN);
		waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_TITLE, DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Search a Candidates
	 * @param fullName
	 */
	public void searchACandidate(String fullName){
		info("Search a candidate");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_HOMEPAGE_SEARCH_BOX, DEFAULT_TIMEOUT, 1);
		type(ELEMENT_RS_CANDIDATE_HOMEPAGE_SEARCH_BOX, fullName, true);
		waitForAndGetElement(ELEMENT_RS_CANDIDATE_HOMEPAGE_SEARCH_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE_HOMEPAGE_SEARCH_BTN);
		waitForAndGetElement(ELEMENT_RS_CANDIDATE.replace("${fullName}", fullName), DEFAULT_TIMEOUT, 1);
	}
	
	/**
	 * Go to Add Candidates
	 * @param fullName: fullName of Candidate
	 * @param firstName: firstName of Candidate
	 * @param lastName: lastName of Candidate
	 * @param email: email of Candidate
	 * @param phone: phone of Candidate
	 * @param source: source where candidate applied to ompany
	 * @param job: job that candidate applied to company
	 * @param file: link to CV of candidate
	 * @param searchSource: true is searching/ false is typing
	 * @param searchJob: true is searching/ false is typing
	 */
	public void addCandidate(String fullName, String firstName, String lastName, String email, String phone, boolean searchSource,
							 String source, boolean searchJob, String job, String file){
		info("Create a candidate");
		info("Enter full name");
		if(fullName != null && fullName != ""){
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_FULL_NAME, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_FULL_NAME, fullName, true);
		}
		info("Enter first name");
		if(firstName != null && firstName != ""){
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_FIRST_NAME, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_FIRST_NAME, firstName, true);
		}
		info("Enter last name");
		if(lastName != null && lastName != ""){
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_LAST_NAME, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_LAST_NAME, lastName, true);
		}
		info("Enter email");
		if(email != null && email != ""){
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_EMAIL, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_EMAIL, email, true);
		}
		info("Enter phone");
		if(phone != null && phone != ""){
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_PHONE, DEFAULT_TIMEOUT, 1);
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_PHONE, phone, true);
		}
		info("Choose refer source");
		waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE);
		waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE_SEARCH, DEFAULT_TIMEOUT, 1);
		if(searchSource == true){
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE_SEARCH, source, true);
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE_SELECT.replace("${source}", source), DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE_SELECT.replace("${source}", source));
		}
		else {
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE_SEARCH, source, true);
			pressEnterKey();
		}
		
		info("Choose automation test job");
		waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB);
		waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB_SEARCH, DEFAULT_TIMEOUT, 1);
		if(searchJob == true) {
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB_SEARCH, job, true);
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB_SEARCH_SELECT.replace("${job}", job), DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB_SEARCH_SELECT.replace("${job}", job));
		}
		else{
			type(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB_SEARCH, job, true);
			pressEnterKey();
		}
		info("Attach CV");
		if(file != null && file != "") {
			info("Click on browse button");
			waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_BROWSE_BTN, DEFAULT_TIMEOUT, 1);
			click(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_BROWSE_BTN);
			info("upload file");
			uploadFileUsingRobot(file);
		}
		
	/**
	* Click create button
	*/	
	}
	public void Create(){
		info("Click create button");
		waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_CREATE_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_CREATE_BTN);
	}
	
	/**
	* Click cancel button
	*/	
	public void Cancel(){
		info("Click cancel button");
		waitForAndGetElement(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_CANCEL_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_CANCEL_BTN);
	}
	
	/**
	* Verify user created Successfully or not
	* @param sucess: true is verifying user created successfully/ false is verifying user created unsuccessfully
	* @param fullName: fullName of Candidate
	*/
	public void verifyAccountCreated(boolean sucess, String fullName) {
		info("Verify Account Created SuccessFully or not");
		Utils.pause(2000);
		if(sucess = true)
			waitForAndGetElement(ELEMENT_RS_CANDIDATE_PROFILE_TITLE.replace("${name}", fullName), DEFAULT_TIMEOUT, 1);
		else
			waitForElementNotPresent(ELEMENT_RS_CANDIDATE_PROFILE_TITLE.replace("${name}", fullName));
	} 
	
	/**
	* Go to a specific Candidate
	* @param fullName
	*/
	public void goToSpecificCandidate (String fullName){
		info("Go to specific Candidate");
		waitForAndGetElement(ELEMENT_RS_CANDIDATE.replace("${fullName}", fullName), DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATE.replace("${fullName}", fullName));
	}
	
}
