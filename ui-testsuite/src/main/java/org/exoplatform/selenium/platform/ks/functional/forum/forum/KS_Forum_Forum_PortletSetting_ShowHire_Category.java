package org.exoplatform.selenium.platform.ks.functional.forum.forum;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.platform.ks.functional.forum.forum.KS_Forum_Forum_PortletSetting_EnableDisablePanel.deleteCategoryWithJohn;

import org.exoplatform.selenium.platform.ks.ForumManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KS_Forum_Forum_PortletSetting_ShowHire_Category extends ForumManagement {

	@BeforeMethod
	public void beforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");	
		goToForums();
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
	/*case01+02: Hire/Show caterogy in Forum portlet settings
	 * create category, forum, topic
	 * hire category
	 * check user can not see category, forum, topic
	 * show category
	 * check user can see category, forum, topic
	 */
	@Test
	public void test01_02_HireShowCategory(){
		String category = "KS_Forum_Show_Category_cat_01_02";
		String forum = "KS_Forum_Show_Category_forum_01_02";
		String topic = "KS_Forum_Show_Category_topic_01_02";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		
		info("Create new category, forum, topic");
		makeTopicFromCategory(category, forum, topic);
		
		info("set hire category " + category);
		settingForumPortletSelectDisplay(category, true, false);
		signOut();
		
		info("Check user demo can not see category, forum and topic");
		signIn("demo", "gtn");
		goToForums();
		waitForElementNotPresent(element_category);
		waitForElementNotPresent(element_forum);
		waitForElementNotPresent(element_topic);
		signOut();
		
		info("Set show category " + category);
		signIn("john", "gtn");
		goToForums();
		settingForumPortletSelectDisplay(category, true, true);
		signOut();
		
		info("Check user demo can see category, forum and topic");
		signIn("demo", "gtn");
		goToForums();
		waitForElementPresent(element_category);
		waitForElementPresent(element_forum);
		waitForElementPresent(element_topic);
		signOut();
		
		info("Delete data");
		deleteCategoryWithJohn(category, element_category);
	}	
}
