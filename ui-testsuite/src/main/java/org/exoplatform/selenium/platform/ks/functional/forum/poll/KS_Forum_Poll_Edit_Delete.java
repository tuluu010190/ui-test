package org.exoplatform.selenium.platform.ks.functional.forum.poll;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.PageManagement.*;
import static org.exoplatform.selenium.platform.ks.PollManagement.*;
import org.exoplatform.selenium.platform.ks.KsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author thaopth
 * Date: 21 Dec 2012
 */

public class KS_Forum_Poll_Edit_Delete extends KsBase {
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
 * KS/Forum/Poll/Edit and Delete
 */
	@Test
	public void test01_EditAndDeletePoll () {	
		String DATA_PAGE_NAME = "PollPortlettest";
		String DATA_POLL_QUESTION = "Polltest";
		String DATA_POLL_QUESTION_EDITED = "PollEdited";
		String DATA_POLL_OPTION = "option1/option2/option3/option4";

		addPageWithPollPortlet(DATA_PAGE_NAME);

		addPollAndSelectPoll(DATA_POLL_QUESTION,DATA_POLL_OPTION , true, "","1", false, false);


		waitForElementPresent(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", DATA_POLL_QUESTION)));

		captureScreen("Case01_PollWith2Options");
		
		editPollQuestion(DATA_POLL_QUESTION, DATA_POLL_QUESTION_EDITED);
		
		//Clear data
		deletePoll(DATA_POLL_QUESTION_EDITED);
		deletePageAtManagePageAndPortalNavigation(DATA_PAGE_NAME, true, "intranet", false, "");
	}
}
