package org.niteco.selenium.platform.rs;

import static org.niteco.selenium.TestLogger.info;

import org.niteco.selenium.Utils;
import org.niteco.selenium.platform.ManageLogInOut;
import org.niteco.selenium.platform.PlatformBase;
import org.niteco.selenium.platform.objectdatabase.common.DatabaseResource;
import org.niteco.selenium.platform.objectdatabase.rs.CandidateInformation;
import org.niteco.selenium.platform.objectdatabase.rs.addCandidateForm;
import org.niteco.selenium.platform.objectdatabase.rs.skillInformation;
import org.niteco.selenium.platform.rs.CandidateProfile;
import org.niteco.selenium.platform.rs.CandidatesHomePage;
import org.niteco.selenium.platform.rs.ExamPage;
import org.niteco.selenium.platform.rs.RSHomepage;
import org.niteco.selenium.platform.rs.RSLocators;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


public class RSFlow extends PlatformBase{

	ManageLogInOut magAc;
	RSHomepage rcHome;
	CandidatesHomePage canHome;
	CandidateProfile canProf;
	ExamPage exPage;
	RSLocators rcLoc;
	CandidateInformation candidateInfoData;
	addCandidateForm addCanFormData;
	skillInformation skillInfoData;
	
	
	@BeforeClass
	public void setUpBeforeTest() throws Exception{
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		driver.get(baseUrl);
		magAc = new ManageLogInOut(driver);
		rcHome = new RSHomepage(driver);
		canHome = new CandidatesHomePage(driver);
		canProf = new CandidateProfile(driver);
		exPage = new ExamPage(driver);
		rcLoc = new RSLocators();
		candidateInfoData = new CandidateInformation();
		candidateInfoData.setData(candidateDataFilePath,defaultSheet,true);
		addCanFormData = new addCandidateForm();
		addCanFormData.setData(addCanFormDataFilePath,defaultSheet,true);
		skillInfoData = new skillInformation();
		skillInfoData.setData(skillInfoDataFilePath,defaultSheet,true);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
	}
	
	@AfterClass
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	/**
	 * Case ID:116816.
	 * Test Case Name: Approve/ Disapprove answer.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * @throws Exception 
	 */
	@Test
	public  void test01_flowiMisRSEx() throws Exception {
		/*String[][] testData2 = DatabaseResource.getDataFromSource(candidateDataFilePath,defaultSheet,true);
		
		for(int i = 0; i < testData2.length; i ++){*/
		int i = 2;
		String fullName = candidateInfoData.getFullNameByIndex(i); //tutest13
		String firstName = candidateInfoData.getFirstNameByIndex(i); //tu13
		String lastName = candidateInfoData.getLastNameByIndex(i); //luu13
		String email = candidateInfoData.getEmailByIndex(i); //tu13@gmail.com
		String phone = candidateInfoData.getPhoneByIndex(i); //123456789
		String dateOfBirth = candidateInfoData.getDateOfBirthByIndex(i); //01/01/1990
		info("DOB: " + dateOfBirth);
		String gender = candidateInfoData.getGenderByIndex(i); //Male
		String nationality = candidateInfoData.getNationalityByIndex(i); //Vietnam
		String region = candidateInfoData.getRegionByIndex(i); //Ha Noi
		String locality = candidateInfoData.getLocalityByIndex(i); //Hoan Kiem
		String address = candidateInfoData.getAdressByIndex(i); //48 Tho Nhuom
		String postalCode = candidateInfoData.getPostalCodeByIndex(i); //12345
		String currentSalary = candidateInfoData.getCurrentSalaryCodeByIndex(i); //200
		String expecedSalary = candidateInfoData.getExpectedSalaryByIndex(i); //400
		String plannedStartDate = candidateInfoData.getPlanedStartDateByIndex(i); //02/29/2016
		info("Planned start date: " + plannedStartDate);
		String workingLocation = candidateInfoData.getWorkingLocationByIndex(i); //Hanoi
		String filePath = candidateInfoData.getFilePathByIndex(i); //TestData\CV_Tu3.docx
		String fileName = candidateInfoData.getFileNameByIndex(i); //CV_Tu3.docx
		String source = candidateInfoData.getSourceByIndex(i);  //Refer
		String job = candidateInfoData.getJobByIndex(i); //Test automation developer
		String updateGender = candidateInfoData.getupdateGenderByIndex(i);
		String updateNationality = candidateInfoData.getupdateNationalityByIndex(i);
		
		String[] skill = {candidateInfoData.getSkill1ByIndex(i), candidateInfoData.getSkill2ByIndex(i), candidateInfoData.getSkill3ByIndex(i)}; //C, Pascal, Java
		String[] level = {candidateInfoData.getLevelSkill1ByIndex(i), candidateInfoData.getLevelSkill2ByIndex(i), candidateInfoData.getLevelSkill2ByIndex(i)}; //1, 2, 3
		String[] lastUsed = {candidateInfoData.getLastUsedSkill1ByIndex(i), candidateInfoData.getLastUsedSkill2ByIndex(i), candidateInfoData.getLastUsedSkill3ByIndex(i)};
		
		String examsGroup = candidateInfoData.getExamGroupByIndex(i); //HoangHa_Group
		String examsDuration = candidateInfoData.getExamDurationByIndex(i); //1
		
		info("Go to candidate tab");
		rcHome.goToCandidateTab();
		
		info("Create a new candidate");
		canHome.goToAddCandidates();
		canHome.addCandidate(fullName, firstName, lastName, email, phone, true, source, true, job, filePath);
		canHome.Create();
		canProf.verifyBasicCandidateProfile(fullName, firstName, lastName, phone, email, job, fileName);
		
		info("Go to a specific candidate by search candidate");
		rcHome.goToCandidateTab();
		canHome.searchACandidate(fullName);
		canHome.goToSpecificCandidate(fullName);
		
		info("Add information for candidate");
		canProf.goToAddInformationForCandiDate();
		
		info("Add exam");
		canProf.goToAddExam();
		canProf.createExam(true, examsGroup, examsDuration);
		canProf.verifyExamsBadgeNumber("1");
		canProf.goToExamsTabInAS();
		
		info("Go to copy test link name and paste in another browser");
		canProf.goToSpecificExamInAS();
		WebElement testLink = waitForAndGetElement(canProf.ELEMENT_RS_CANDIDATE_PROFILE_AS_EXAMS_TEST_LINK, DEFAULT_TIMEOUT, 1);
		String link = testLink.getText();
		
		Utils.pause(2000);
		
		info("Open new window");
		driver.manage().deleteAllCookies();
		driver.get(link);
		
		info("Enter candidate information in exam");
		exPage.enterPersonalInformationInExam(fullName, firstName, lastName, dateOfBirth, gender, nationality);
		exPage.enterContactInformationInExam(phone, email, nationality, region, locality, address, postalCode, "");
		exPage.enterRecruitmenttInformationInExam(currentSalary, expecedSalary, plannedStartDate, workingLocation);
		exPage.enterSkillsInformationInExam(skill, level, lastUsed);
		
		info("Go to continue exam");
		exPage.continueToExam();
		
		info("Start exam");
		exPage.startExam();
		info("Answer quetion 1");
		click(waitForAndGetElement(rcLoc.ELEMENT_RS_EXAM_PAGE_DO_EXAM_QUESTION12, DEFAULT_TIMEOUT, 1));
		exPage.nextQuestion();
		info("Answer quetion 2");
		click(waitForAndGetElement(rcLoc.ELEMENT_RS_EXAM_PAGE_DO_EXAM_QUESTION12, DEFAULT_TIMEOUT, 1));
		exPage.nextQuestion();
		info("Answer quetion 3");
		click(waitForAndGetElement(rcLoc.ELEMENT_RS_EXAM_PAGE_DO_EXAM_QUESTION3, DEFAULT_TIMEOUT, 1));
		exPage.endExam();
		
		info("Check data was updated for candidate");
		driver.get(baseUrl);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		info("Go to candidate tab");
		rcHome.goToCandidateTab();
		
		info("Go to a specific candidate by search candidate");
		canHome.searchACandidate(fullName);
		canHome.goToSpecificCandidate(fullName);
		
		info("Verify basic profile information");
		canProf.verifyBasicCandidateProfile(fullName, firstName, lastName, phone, email, job, fileName);
		
		info("Verify update profile information from ex");
		canProf.verifyUpdateCandidateProfileFromExam("", updateGender, updateNationality, updateNationality, region, locality, address, postalCode, currentSalary, expecedSalary, workingLocation, "");
		
		canProf.verifyExamsBadgeNumber("2");
		canProf.goToExamsTabInAS();
		canProf.goToSpecificExamResultInAS();
		
		
		//}
	}
}