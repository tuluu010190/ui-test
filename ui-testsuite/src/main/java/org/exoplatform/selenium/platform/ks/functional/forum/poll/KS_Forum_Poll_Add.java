package org.exoplatform.selenium.platform.ks.functional.forum.poll;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ManageApplications.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import static org.exoplatform.selenium.platform.ks.PollManagement.*;
import static org.exoplatform.selenium.platform.PageManagement.*;
import org.exoplatform.selenium.platform.ks.KsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thaopth
 * Date: 19 Dec 2012
 */
public class KS_Forum_Poll_Add extends KsBase {
	public String admin = "john";
	public String pass = "gtn";

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(admin, pass);
	}

	@AfterMethod
	public void afterMethods(){
		info("-- Finished: test case --");
		//signOut();
		driver.quit();
		actions = null;
	}
	/*
	 * KS/Forum/Poll/Add
	 * Case 01: Add poll in case only have 2 options
	 */
	@Test
	public void test01_addPollIncaseOnlyHave2Options () {
		String DATA_PAGE_NAME = "PollPortlet";
		String DATA_POLL_QUESTION = "Poll01";
		String DATA_POLL_OPTION = "option1/option2";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , true, "","1", false, false);

		waitForElementPresent(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", DATA_POLL_QUESTION)));

		captureScreen("Case01_PollWith2Options");

		//Clear data
		deletePoll(DATA_POLL_QUESTION);
		
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");
	}
	/*
	 * KS/Forum/Poll/Add
	 * Case 02: Add Poll with more 2 options
	 */
	@Test
	public void test02_addPollWithMore2Options () {
		String DATA_PAGE_NAME = "PollPortlet2";
		String DATA_POLL_QUESTION = "Poll02";
		String DATA_POLL_OPTION = "option1/option2/option3";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , true,"", "1", false, false);

		captureScreen("Case01_PollWith2Options");

		//Clear data
		deletePoll(DATA_POLL_QUESTION);
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");
	}
	/*
	 * KS/Forum/Poll/Add
	 * Case 03: Add poll when only have one option
	 */
	@Test
	public void test03_AddPollWhenOnlyHaveOneOption () {
		String DATA_PAGE_NAME = "PollPortlet3";
		String DATA_POLL_QUESTION = "Poll03";
		String DATA_POLL_OPTION = "option1";
		By ELEMENT_OPTION1 = By.id("Option0");
		String WARNING_MESSAGE = "Please fill all options.";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		goToEditPageEditor();

		mouseOver(ELEMENT_APPS_REG_PORTLET, true);

		click(ELEMENT_EDIT_PORTLET);

		waitForElementPresent(ELEMENT_ADD_POLL_BUTTON);

		click(ELEMENT_ADD_POLL_BUTTON);

		waitForElementPresent(ELEMENT_ADD_POLL_FORM);

		type(ELEMENT_POLL_QUESTION, DATA_POLL_QUESTION, false);

		type(ELEMENT_OPTION1,DATA_POLL_OPTION,false);

		click(ELEMENT_SUBMIT_POLL_BUTTON);

		waitForTextPresent(WARNING_MESSAGE);

		click(ELEMENT_OK_BUTTON);

		click(ELEMENT_CLOSE_BUTTON);

		click(ELEMENT_FINISH_ICON);

		waitForElementNotPresent(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", DATA_POLL_QUESTION)));

		//Clear data
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");
	}
	/*
	 * Case 04: Add poll with single choice and no change vote	
	 */
	@Test
	public void test04_AddPollWithSingleChoiceAndNoChange () {
		String DATA_PAGE_NAME = "PollPortlet4";
		String DATA_POLL_QUESTION = "Poll04";
		String DATA_POLL_OPTION = "option1/option2/option3";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , true,"", "2", false, false);

		captureScreen("Case04_TestPollWithSingleChoiceAndNoChange");

		votePollSingleChoice(false, "option1");

		captureScreen("VotePollCase04");

		//Clear data
		deletePoll(DATA_POLL_QUESTION);
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");

	}
	/*
	 * Add poll with single choice and allow change vote
	 */
	@Test
	public void test05_AddPollWithSingleChoiceAndAllowChangeVote () {
		String DATA_PAGE_NAME = "PollPortlet5";
		String DATA_POLL_QUESTION = "Poll05";
		String DATA_POLL_OPTION = "option1/option2/option3";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , true,"", "2", true, false);

		captureScreen("Case05_Poll");

		votePollSingleChoice(true, "option2");

		captureScreen("VotePollCase05");

		//Clear data
		deletePoll(DATA_POLL_QUESTION);
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");
	}
	/*
	 * Case 06: add poll with multiple choice and don't allow change vote
	 */
	@Test
	public void test06_AddPollWithMultipleChoiceAndDoNotAllowChangeVote () {
		String DATA_PAGE_NAME = "PollPortlet6";
		String DATA_POLL_QUESTION = "Poll06";
		String DATA_POLL_OPTION = "option1/option2/option3/option4";
		int index [] = {1,2,3};

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , true,"", "2", false, true);

		captureScreen("Case06_Poll");

		votePollMultiChoice(false, index);

		captureScreen("VotePollCase06");

		//Clear data
		deletePoll(DATA_POLL_QUESTION);
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");
	}
	/*
	 * Case 07: Add poll in case public data
	 */
	@Test
	public void test07_AddPollInCasePublicData () {
		String DATA_PAGE_NAME = "PollPortlet7";
		String DATA_POLL_QUESTION = "Poll07";
		String DATA_POLL_OPTION = "option1/option2/option3/option4";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , true,"", "2", false, false);

		captureScreen("Case07_Poll");

		signOut();

		signIn("mary", "gtn");

		goToPollPortlet(DATA_PAGE_NAME);

		waitForElementPresent(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", DATA_POLL_QUESTION)));

		votePollSingleChoice(false, "option3");

		captureScreen("VotePoll07");

		signOut();

		signIn(admin, pass);

		goToPollPortlet(DATA_PAGE_NAME);

		//Clear data
		deletePoll(DATA_POLL_QUESTION);
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");

	}
	/*
	 * Case 08: Add poll in case limit view right 
	 */
	@Test
	public void test08_AddPollInCaseLimitViewRight () {
		String DATA_PAGE_NAME = "PollPortlet8";
		String DATA_POLL_QUESTION = "Poll08";
		String DATA_POLL_OPTION = "option1/option2/option3/option4";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , false,"Platform/Content Management", "2", false, false);

		captureScreen("Case08_Poll");

		signOut();

		signIn("demo", "gtn");

		goToPollPortlet(DATA_PAGE_NAME);

		waitForTextPresent(WARNING_MESSAGE_NO_PERMISSION);

		signOut();

		signIn(admin, pass);

		goToPollPortlet(DATA_PAGE_NAME);

		//Clear data
		deletePoll(DATA_POLL_QUESTION);
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");
	}
}

