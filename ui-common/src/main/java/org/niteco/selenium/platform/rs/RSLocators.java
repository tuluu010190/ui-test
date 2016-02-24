package org.niteco.selenium.platform.rs;

import org.niteco.selenium.platform.PlatformBase;
import org.openqa.selenium.By;

public class RSLocators extends PlatformBase{
	
	// Candidate -Homepage
	public final By ELEMENT_RS_CANDIDATES_BTN = By.xpath(".//*[@id='navbar']//*[@class='fa fa-users']");
	public final By ELEMENT_RS_CANDIDATES_TITLE = By.xpath("//*[text()='Candidates']");
	public final By ELEMENT_RS_ADD_CANDIDATES_BTN = By.xpath("//*[@class='fa fa-plus fa-fw']");
	public final String ELEMENT_RS_CANDIDATE = "//*[@class='candidate-info']//a[contains(text(),'${fullName}')]";
	public final By ELEMENT_RS_CANDIDATE_HOMEPAGE_SEARCH_BOX = By.id("Term");
	public final By ELEMENT_RS_CANDIDATE_HOMEPAGE_SEARCH_BTN = By.xpath(".//*[@id='btnSearch']/span");
	
	
	// Add candidate form
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_TITLE = By.xpath("//*[text()='Create new candidate']");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_FULL_NAME = By.id("Profile_FullName");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_FIRST_NAME = By.id("Profile_FirstName");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_LAST_NAME = By.id("Profile_LastName");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_EMAIL = By.id("Profile_Email");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_PHONE = By.id("Profile_Phone");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE = By.id("select2-Source-container");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE_SEARCH = By.xpath("//input[@class='select2-search__field']");
	public final String ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_SOURCE_SELECT = "//input[@class='select2-search__field']/../..//li[contains(text(),'${source}')]";
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB = By.xpath("//*[@title='Select Job']");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB_SEARCH = By.xpath("//input[@class='select2-search__field']");
	public final String ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_JOB_SEARCH_SELECT = "//input[@class='select2-search__field']/../..//li[contains(text(),'${job}')]";
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_CREATE_BTN = By.xpath("//button[@class='btn btn-default btn-primary' and text()='Create']");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_CANCEL_BTN = By.xpath("//button[@class='btn btn-default btn-primary']/..//a[text()='Cancel']");
	public final By ELEMENT_RS_ADD_CREATE_NEW_CANDIDATE_BROWSE_BTN = By.id("attachment");
	
	// candidate profile - basic information
	public final String ELEMENT_RS_CANDIDATE_PROFILE_TITLE = "//*[@class='candidate-title' and contains(text(),'${name}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_FULL_NAME = "//table[@class='table table-condense table-bordered candidate-props__view']//th[text()='Full Name']/..//td[text()='${fullName}']"; 
	public final String ELEMENT_RS_CANDIDATE_PROFILE_FIRST_NAME = "//table[@class='table table-condense table-bordered candidate-props__view']//th[text()='First Name']/..//td[text()='${firstName}']"; 
	public final String ELEMENT_RS_CANDIDATE_PROFILE_LAST_NAME = "//table[@class='table table-condense table-bordered candidate-props__view']//th[text()='Last Name']/..//td[text()='${lastName}']";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_PHONE = "//table[@class='table table-condense table-bordered candidate-props__view']//th[text()='Phone']/..//td[text()='${phone}']";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_EMAIL = "//table[@class='table table-condense table-bordered candidate-props__view']//th[text()='Email']/..//a[text()='${email}']";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_JOB = "//*[@class='display-inline' and text()='Jobs']/..//a[contains(text(),'${job}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_ATTACH_FILE = "//*[@class='display-inline' and text()='Files']/../..//*[contains(text(),'${fileName}')]";
	public final By ELEMENT_RS_CANDIDATE_PROFILE_ADD_INFORMATION_BTN = By.xpath(".//*[@id='events']//*[@class='fa fa-4x fa-plus-circle']");

	// candidate profile - update information from Exam
	public final String ELEMENT_RS_CANDIDATE_PROFILE_DOB = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'D.O.B')]/..//*[contains(text(),'${dateOfBirth}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_GENDER = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Gender')]/..//*[contains(text(),'${gender}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_NATIONALITY = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Nationality')]/..//*[contains(text(),'${nationality}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_COUNTRY = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Country')]/..//*[contains(text(),'${country}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_REGION = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Region')]/..//*[contains(text(),'${region}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_LOCALITY = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Locality')]/..//*[contains(text(),'${locality}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_ADDRESS = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Address')]/..//*[contains(text(),'${address}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_POSTAL_CODE = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Postal code')]/..//*[contains(text(),'${postalCode}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_CURRENT_SALARY = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Current salary')]/..//*[contains(text(),'${currentSalary}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_EXPECTED_SALARY = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Expected salary')]/..//*[contains(text(),'${expecedSalary}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_WORKING_LOCATION = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Working location')]/..//*[contains(text(),'${workingLocation}')]";
	public final String ELEMENT_RS_CANDIDATE_PROFILE_PLANNED_START_DATE = "//*[@class='table table-condense table-bordered candidate-props__view']//*[contains(text(),'Planned start date')]/..//*[contains(text(),'${plannedStartDate}')]";
	
	
	// candidate profile - add information - navigation bar
	public final By ELEMENT_RS_CANDIDATE_PROFILE_NAV_BAR_EXAMS = By.xpath(".//*[@id='navTabs']//*[contains(@class,'fa fa-fw fa-balance-scale')]");
	public final By ELEMENT_RS_CANDIDATE_PROFILE_NAV_BAR_STATUS = By.xpath(".//*[@id='navTabs']//*[contains(@class,'fa fa-fw fa-info-circle')]");
	
	
	// candidate profile - add information - exam
	public final By ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_TITLE = By.xpath(".//*[@id='assignExamGroup']//legend[contains(text(), 'Create exam session')]");
	public final By ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_GROUP = By.xpath(".//*[@id='assignExamGroup']//*[contains(@class,'select2-selection__rendered')]//*[@class='select2-search__field' and @role='textbox']");
	public final String ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_SELECT = "//*[@class='select2-container select2-container--default select2-container--open']//*[contains(text(),'${group}')]";
	public final By ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_DURATION = By.id("Duration");
	public final By ELEMENT_RS_CANDIDATE_PROFILE_EXAMS_CREATE_BTN = By.xpath(".//*[@id='assignExamGroup']//button[text()='Create']");
	
	// candidate profile - add information - status
	public final By ELEMENT_RS_CANDIDATE_PROFILE_STATUS_TITLE = By.xpath(".//*[@id='updateStatus']//legend[text()='Change status']");

	// candidate profile - add information - activity stream
	public final String ELEMENT_RS_CANDIDATE_PROFILE_AS_NAV_BAR_EXAMS_BADGE = ".//*[@id='events']//*[contains(text(),'Exams')]/..//*[@class='badge' and text()='${number}']";
	public final By ELEMENT_RS_CANDIDATE_PROFILE_AS_NAV_BAR_EXAMS = By.xpath(".//*[@id='events']//*[contains(text(),'Exams')]");
	public final By ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_LOCATION = By.xpath(".//*[@id='events']//*[contains(text(),'Exam session')]/../..//*[@class='events__node-header']");
	public final By ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_RESULT = By.xpath(".//*[@id='events']//*[contains(text(),'Exam result')]/../..//*[@class='events__node-header']");
	public final String ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_TEST_LINK = ".//*[@id='events']//*[@class='events__node-header']/../..//*[@class='test-link']";

	//exam - information - personal
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_FULL_NAME = By.id("FullName");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_FIRST_NAME = By.id("FirstName");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LAST_NAME = By.id("LastName");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_DOB = By.id("DateOfBirth");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_GENDER = By.xpath("//*[@id='select2-GenderCode-container']/..//b[@role='presentation']");
	public final String ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_GENDER_SELECT = "//*[contains(@id, 'select2-GenderCode-result') and text()='${gender}']";
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_NATIONALITY = By.xpath("//*[@id='select2-Nationality-container']/..//b[@role='presentation']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_NATIONALITY_SEARCH = By.xpath("//input[@class='select2-search__field']");
	
	//exam - information - CONTACT
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_PHONE = By.id("Phone");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_EMAIL = By.id("Email");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_IM = By.xpath("//*[@class='form-inline']//*[@class='selection']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_ADD_IM_BTN = By.xpath("//button[@class='btn btn-default' and contains(text(),'Add IM account')]");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_COUNTRY = By.xpath("//*[@id='select2-CountryCode-container']/..//b[@role='presentation']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_COUNTRY_SEARCH = By.xpath("//input[@class='select2-search__field']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_REGION = By.xpath("//*[@id='select2-Region-container']/..//b[@role='presentation']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_REGION_SEARCH = By.xpath("//input[@class='select2-search__field']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LOCALITY = By.xpath("//*[@id='select2-Locality-container']/..//b[@role='presentation']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_LOCALITY_SEARCH = By.xpath("//input[@class='select2-search__field']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_ADDRESS = By.id("Address");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_POSTAL_CODE = By.id("PostalCode");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_URL = By.id("Urls_0_");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_ADD_URL_BUTTON = By.xpath("//*[@class='btn btn-default' and text()='Add Url']"); 
	
	//exam - information - RECUITEMENT
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_CURRENT_SALARY = By.id("CurrentSalary");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_EXPECTED_SALARY = By.id("SalaryExpectation");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_PLANNED_START_DATE = By.id("PlannedStartDate");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_WORKING_LOCATION = By.xpath("//*[@id='select2-WorkingLocationId-container']/..//b[@role='presentation']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_WORKING_LOCATION_SEARCH = By.xpath("//input[@class='select2-search__field']");
	
	//exam - information - SKILLS
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS = By.id("select2-pa82-container");
	public final String ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_DEFAULT = "//*[@class='select2-selection__rendered' and @title='${skill}']";
	public final String ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SELECT = "//*[@class='skill-row__name' and text()='${skill}']";
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH = By.xpath("//*[@class='select2-search__field']");
	public final String ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_SEARCH_SELECT = ".//*[contains(@class,'select2-results__option') and text()='${skill}']";
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_ADD_BTN = By.xpath("//*[@class='btn btn-sm btn-default' and text()='Add']");
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_ADD_REMOVE = By.xpath("//*[@class='btn btn-sm btn-default' and text()='Remove']");
	public final String ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LAST_USED = "//*[@class='skill-row__name' and @value='${skill}']/../..//*[contains(@name,'LastUsedYear')]";
	public final String ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_SKILLS_LEVEL = "//*[@class='skill-row__name' and @value='${skill}']/../..//*[@class='rating' and @value='${level}']/..//span[@class='rating']";
	
	public final By ELEMENT_RS_EXAM_PAGE_CANDIDATE_INFO_CONTINUE_EXAM_BTN = By.xpath("//*[@class='btn btn-default btn-primary btn-lg btn-block' and contains(text(), 'Continue to exam')]"); 
	
	//exam - do the exam
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_TITLE = By.xpath("//*[contains(@class,'title-name') and text()='Exam List Test']");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_START_EXAM_BTN = By.xpath("//*[@class='btn btn-primary btn-block ng-binding' and text()='Start Exam']");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_SKIP_EXAM_BTN = By.xpath("//*[@class='btn btn-default btn-block ng-binding' and text()='Skip Exam']");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_NEXT_QST_BTN = By.xpath("//button[@class='btn btn-default ng-binding' and contains(text(), 'Next')]/i");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_PREV_QST_BTN = By.xpath("//*[@class='glyphicon glyphicon-chevron-left']");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN = By.xpath("//button[@class='btn btn-primary pull-right ng-binding' and contains(text(),'End Exam')]/span");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN_OK_BTN = By.xpath(".//*[@id='endExamModal']//*[@class='btn btn-default btnNiteco-default ng-binding' and text()='OK']");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_END_EXAM_BTN_CANCEL_BTN = By.xpath(".//*[@id='endExamModal']//*[@class='btn btn-default ng-binding' and text()='Cancel']");
	//do the exam
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_QUESTION12 = By.xpath("//*[@class='ng-pristine ng-untouched ng-valid' and @value='1']");
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_QUESTION3 = By.xpath("//*[@class='ng-binding' and text()='ABC']/..//input[@class='ng-pristine ng-untouched ng-valid']");
	
	//exam - message
	public final By ELEMENT_RS_EXAM_PAGE_DO_EXAM_THANKS = By.xpath("//*[text()='Thank you!']");
	
	

}