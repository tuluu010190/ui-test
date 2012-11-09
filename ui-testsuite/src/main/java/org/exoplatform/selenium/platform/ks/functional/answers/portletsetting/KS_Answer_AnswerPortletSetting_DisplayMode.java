package org.exoplatform.selenium.platform.ks.functional.answers.portletsetting;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import org.exoplatform.selenium.platform.ks.Answer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static org.exoplatform.selenium.TestLogger.info;

public class KS_Answer_AnswerPortletSetting_DisplayMode extends Answer{

	public static final String USER = "john";
	public static final String PASS = "gtn";
	public static final By ELEMENT_TO_POST_QUESTION_IN_ROOT_CATEGORY=By.id("isPostQuestionInRootCategory");
	public static final By ELEMENT_DISPLAY_MODE=By.xpath("//div[text()='Display Mode']");

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}	

	/*-- Case ID 15
	 *-- Author: HaKT
	 *-- Date: 26 Nov 2012
	 *-- Enable Users to post question in root path
	 *-- Go to Group →  Administration → Page Manager → Edit Answers → Edit Mode → Display Mode
	 *-- Tick on Users post in root check box, Save, Click OK button, Close, Finish
	 *-- Login by normal user, eg james
	 *-- Go to Answer porlet 
	 *-- Submit Question button is available in Main action bar and allow user submit new question
	 * --*/
	@Test
	public void test15_EnableUsersToPostQuestionInRoot(){
		info("Enable Users To Post Question In Root");

		signIn(USER, PASS);
		goToAnswer();
		editAnswerAtPageManagement();

		configAnswerPorlet(ELEMENT_DISPLAY_MODE, ELEMENT_TO_POST_QUESTION_IN_ROOT_CATEGORY, false);

		saveAnswerPageAfterEditing();
		signOut();

		driver.get(baseUrl);
		signIn("james", "gtn");
		goToAnswer();

		waitForElementPresent(ELEMENT_SUBMIT_QUESTION_BUTTON);
		signOut();
	}

	/*-- Case ID 016
	 *-- Author: HaKT
	 *-- Date: 26 Nov 2012
	 *-- Disable Users to post question in root path
	 *-- Go to Group →  Administration → Page Manager → Edit Answers → Edit Mode → Display Mode
	 *-- Un-tick on Users post in root check box, Save, Click OK button, Close, Finish
	 *-- Login by normal user, eg james
	 *-- Go to Answer porlet 
	 *-- Submit Question button is not available in Main action bar to submit new question
	 * --*/
	@Test
	public void test16_DisableUsersToPostQuestionInRoot(){
		info("Disable Users To Post Question In Root");

		signIn(USER, PASS);
		goToAnswer();
		editAnswerAtPageManagement();

		configAnswerPorlet(ELEMENT_DISPLAY_MODE, ELEMENT_TO_POST_QUESTION_IN_ROOT_CATEGORY, true);

		saveAnswerPageAfterEditing();
		signOut();

		driver.get(baseUrl);
		signIn("james", "gtn");
		goToAnswer();
		waitForElementNotPresent(ELEMENT_SUBMIT_QUESTION_BUTTON);
		signOut();

		// Restore original status
		driver.get(baseUrl);
		signIn(USER, PASS);
		editAnswerAtPageManagement();

		configAnswerPorlet(ELEMENT_DISPLAY_MODE, ELEMENT_TO_POST_QUESTION_IN_ROOT_CATEGORY, false);

		saveAnswerPageAfterEditing();
	}
}