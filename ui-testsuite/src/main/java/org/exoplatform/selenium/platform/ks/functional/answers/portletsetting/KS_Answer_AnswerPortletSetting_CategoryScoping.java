package org.exoplatform.selenium.platform.ks.functional.answers.portletsetting;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import org.exoplatform.selenium.platform.ks.Answer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class KS_Answer_AnswerPortletSetting_CategoryScoping extends Answer{
	public static final By ELEMENT_CATEGORY_SCOPING=By.xpath("//div[text()='Category Scoping']");
	public static final String MSG_SAVE_ANSWER_PORTLET_SETTING="The settings have been saved.";
	//public static final By ELEMENT_CATEGORY_TO_CHECK=By.xpath("//div[@id='FAQCate1'][1]/div/input");
	public static String ELEMENT_CATEGORY_TO_CHECK = "//label[text()='${cat_name}']/../*//input[@type = 'checkbox']";

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

	/*--
	*-- Case ID 23
	*-- Author: HaKT
	*-- Date: 26 Nov 2012
	*-- Show Category in answer portlet setting
	*-- Go to Group → Administration → Page Manager → Edit Answers → Edit Mode → Category scoping
	*-- Tick on a specific category, Save, Click OK button, Close, Finish
	*-- Go to Answer porlet
	*-- Category ticked in step 2 are displayed.
	*-- All questions belong to shown category is also shown.
	* --*/
	@Test
	public void test23_ShowCategoryInAnswersPorletSettings(){
		info("Show Category in answer portlet setting");

		String DATA_CAT_NAME="Category_Case_23";
		String USER_1="";
		String USER_2="";
		String[] AUDIENCE_MODERATOR={USER_1, USER_2};
		By CATEGORY_LINK=By.xpath("//span[text()='"+DATA_CAT_NAME+"']");
		By element = By.xpath(ELEMENT_CATEGORY_TO_CHECK.replace("${cat_name}", DATA_CAT_NAME));

		signIn("john", "gtn");
		goToAnswer();
		addNewCategoryInAnswer(DATA_CAT_NAME, "1", 0, AUDIENCE_MODERATOR, "", 0, AUDIENCE_MODERATOR, false, false, false);

		editAnswerAtPageManagement();

		// Config to show category
		configAnswerPorlet(ELEMENT_CATEGORY_SCOPING, element, false);

		saveAnswerPageAfterEditing();

		goToAnswer();
		waitForElementPresent(CATEGORY_LINK);
		click(CATEGORY_LINK);
		// Delete category
		deleteOpeningCategoryInAnswer(DATA_CAT_NAME);
	}


	/*-- Case ID 22
	*-- Author: HaKT
	*-- Date: 26 Nov 2012
	*-- Hide Category in answer portlet setting
	*-- Go to Group → Administration → Page Manager → Edit Answers → Edit Mode → Category scoping
	*-- Un-Tick on a specific category, Save, Click OK button, Close, Finish
	*-- Go to Answer porlet
	*-- Category ticked in step 2 is not displayed.
	*-- All questions belong to shown category is also not shown.
	**/
	@Test
	public void test22_HideCategoryInAnswersPorletSettings(){
		info("Hide Category in answer portlet setting");
		
		String DATA_CAT_NAME="Category_Case_22";
		String USER_1="";
		String USER_2="";
		String[] AUDIENCE_MODERATOR={USER_1, USER_2};
		By CATEGORY_LINK=By.xpath("//span[text()='"+DATA_CAT_NAME+"']");
		By element = By.xpath(ELEMENT_CATEGORY_TO_CHECK.replace("${cat_name}", DATA_CAT_NAME));

		signIn("john", "gtn");
		goToAnswer();
		addNewCategoryInAnswer(DATA_CAT_NAME, "", 0, AUDIENCE_MODERATOR, "", 0, AUDIENCE_MODERATOR, false, false, false);

		editAnswerAtPageManagement();
		
		configAnswerPorlet(ELEMENT_CATEGORY_SCOPING, element, true);

		saveAnswerPageAfterEditing();

		goToAnswer();
		waitForElementNotPresent(By.xpath("//span[text()='"+DATA_CAT_NAME+"']"));

		editAnswerAtPageManagement();
		
		configAnswerPorlet(ELEMENT_CATEGORY_SCOPING, element, false);

		saveAnswerPageAfterEditing();

		goToAnswer();
		click(CATEGORY_LINK);
		//		Delete category
		deleteOpeningCategoryInAnswer(DATA_CAT_NAME);
	}
}