package org.exoplatform.selenium.platform.ks.functional.forum.forum;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ks.ForumManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KS_Forum_Forum_PortletSetting_EnableDisablePanel extends ForumManagement {

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
	
	public static void deleteCategoryWithJohn(String category, By element_category){
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		deleteCategory(category);
	}
	/*case01 + case 02: Disable/Enable Forum Jump panel in Forum porlet setting
	 * uncheck "Show Forum Jump" in forum portlet setting
	 * check user demo can not see Jump to
	 * check "Show Fofum Jump" in forum portlet setting
	 * check user demo can see Jump to
	 */
	@Test
	public void test01_02_DisableEnableForumJumpPanel(){
		String category = "KS_Forum_PortletSetting_cat_01_02";
		String forum = "KS_Forum_PortletSetting_forum_01_02";
		String topic ="KS_Forum_PortletSetting_topic_01_02";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		
		//Uncheck show forum jump in forum portlet setting
		settingForumPortletPanel(false);
		
		//create new category/forum/topic
		makeTopicFromCategory(category, forum, topic);
		signOut();
		
		info("Check with user demo that can not see Jump");
		signIn("demo", "gtn");
		goToForums();
		click(element_category);
		waitForElementNotPresent(ELEMENT_JUMP_TO);
		click(element_forum);
		waitForElementNotPresent(ELEMENT_JUMP_TO);
		click(element_topic);
		waitForElementNotPresent(ELEMENT_JUMP_TO);
		signOut();
		
		//rollback forum portlet setting
		signIn("john", "gtn");
		goToForums();
		settingForumPortletPanel(true);
		signOut();
		
		info("check user demo can see Jump to");
		signIn("demo", "gtn");
		goToForums();
		click(element_category);
		waitForElementPresent(ELEMENT_JUMP_TO);
		click(element_forum);
		waitForElementPresent(ELEMENT_JUMP_TO);
		click(element_topic);
		waitForElementPresent(ELEMENT_JUMP_TO);
		signOut();
		
		//delete data
		deleteCategoryWithJohn(category, element_category);
	}

	/*case03 + 04: Disable Moderator panel in Forum porlet setting
	 * disable Moderator in Forum portlet setting
	 * check user can not see moderator panel
	 * enable Moderator 
	 * check user can see moderator panel
	 */
	@Test
	public void test03_04_DisableEnableModeratorPanel(){
		String category = "KS_Forum_PortletSetting_cat_03_04";
		String forum = "KS_Forum_PortletSetting_forum_03_04";
		String topic ="KS_Forum_PortletSetting_topic_03_04";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		
		//Uncheck show moderator panel in forum portlet setting
		settingForumPortletPanel(true, false);
		
		//create new category/forum/topic
		makeTopicFromCategory(category, forum, topic);
		signOut();
		
		info("Check with user demo that can not moderator panel");
		signIn("demo", "gtn");
		goToForums();
		click(element_forum);
		waitForElementNotPresent(ELEMENT_MODERATOR_PANEL);
		signOut();
		
		//rollback forum portlet setting
		signIn("john", "gtn");
		goToForums();
		settingForumPortletPanel(true, true);
		signOut();
		
		info("check user demo can see moderator panel");
		signIn("demo", "gtn");
		goToForums();
		click(element_forum);
		waitForElementPresent(ELEMENT_MODERATOR_PANEL);
		signOut();
		
		//delete data
		deleteCategoryWithJohn(category, element_category);
	}
	
	/*case05+06: Disable/Enable Poll panel in Forum porlet setting
	 * disable show poll
	 * create category, forum, topic, poll
	 * check user can not see poll panel
	 * enable show poll
	 * check user can see poll panel
	 */
	@Test
	public void test05_06_DisableEnablePollPanel(){
		String category = "KS_Forum_PortletSetting_cat_05_06";
		String forum = "KS_Forum_PortletSetting_forum_05_06";
		String topic ="KS_Forum_PortletSetting_topic_05_06";
		By element_category = By.linkText(category);
		By element_topic = By.linkText(topic);
		String pollQuestion = "KS_Forum_PortletSetting_poll_question_05_06";
		String poll0 = "Option1";
		String poll1 = "Option2";
		
		//Uncheck show poll in forum portlet setting
		settingForumPortletPanel(true, true, false);
		
		//create new category/forum/topic/poll
		makeTopicFromCategory(category, forum, topic);
		goToAddPoll();
		addPoll(pollQuestion, poll0, poll1, null, false);
		signOut();
		
		info("Check with user demo that can not see poll");
		signIn("demo", "gtn");
		goToForums();
		click(element_topic);
		waitForElementNotPresent(ELEMENT_POLL);
		signOut();
		
		//rollback forum portlet setting
		signIn("john", "gtn");
		goToForums();
		settingForumPortletPanel(true, true, true);
		signOut();
		
		info("check user demo can see poll");
		signIn("demo", "gtn");
		goToForums();
		click(element_topic);
		waitForElementPresent(ELEMENT_POLL);
		signOut();
		
		//delete data
		deleteCategoryWithJohn(category, element_category);
	}
	
	/*case07+08: Disable/Enable Quick Reply panel in Forum porlet setting
	 * disable Quick Reply panel 
	 * add category, forum, topic
	 * check user can not see Quick Reply panel
	 * enable Quick Reply panel
	 * check user can see Quick Reply panel 
	 */
	@Test
	public void test07_08_DisableEnableQuickReplyPanel(){
		String category = "KS_Forum_PortletSetting_cat_07_08";
		String forum = "KS_Forum_PortletSetting_forum_07_08";
		String topic = "KS_Forum_PortletSetting_topic_07_08";
		By element_category = By.linkText(category);
		By element_topic = By.linkText(topic);
		
		//Uncheck show Quick Reply in forum portlet setting
		settingForumPortletPanel(true, true, true, false);
		
		//create new category/forum/topic
		makeTopicFromCategory(category, forum, topic);
		signOut();
		
		info("Check with user demo that can not see Quick Reply");
		signIn("demo", "gtn");
		goToForums();
		click(element_topic);
		waitForElementNotPresent(ELEMENT_POST_QUICK_BUTTON);
		signOut();
		
		//rollback forum portlet setting
		signIn("john", "gtn");
		goToForums();
		settingForumPortletPanel(true, true, true, true);
		signOut();
		
		info("check user demo can see poll");
		signIn("demo", "gtn");
		goToForums();
		click(element_topic);
		waitForElementPresent(ELEMENT_POST_QUICK_BUTTON);
		signOut();
		
		//delete data
		deleteCategoryWithJohn(category, element_category);
	}
	
	/*case09+10: Disable/Enable Icons Legend panel in Forum porlet setting
	 * disable Legend Icon panel 
	 * check user can not see Legend Icon panel
	 * enable Legend Icon panel
	 * check user can see Legend Icon panel 
	 */
	@Test
	public static void test09_10_DisableEnableIconLegentPanel(){
		
		//Uncheck show Legen Icon in forum portlet setting
		settingForumPortletPanel(true, true, true, true, false);
		signOut();
		
		info("Check with user demo that can not see Legen Icon");
		signIn("demo", "gtn");
		goToForums();
		waitForElementNotPresent(ELEMENT_LEGEN_PANEL);
		signOut();
		
		//rollback forum portlet setting
		signIn("john", "gtn");
		goToForums();
		settingForumPortletPanel(true, true, true, true, true);
		signOut();
		
		info("check user demo can see poll");
		signIn("demo", "gtn");
		goToForums();
		waitForElementPresent(ELEMENT_LEGEN_PANEL);
	}
	
	/*case11+12: Disable/Enable Rules panel in Forum porlet setting
	 * disable rule panel 
	 * add category, forum, topic
	 * check user can not see Rule panel
	 * enable Rule panel
	 * check user can see Rule panel 
	 */
	@Test
	public void test11_12_DisableEnableRulePanel(){
		String category = "KS_Forum_PortletSetting_cat_11_12";
		String forum = "KS_Forum_PortletSetting_forum_11_12";
		String topic = "KS_Forum_PortletSetting_topic_11_12";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		
		//Uncheck show Rule panel in forum portlet setting
		settingForumPortletPanel(true, true, true, true, true, false);
		
		//create new category/forum/topic
		makeTopicFromCategory(category, forum, topic);
		signOut();
		
		info("Check with user demo that can not see Rule panel");
		signIn("demo", "gtn");
		goToForums();
		click(element_forum);
		waitForElementNotPresent(ELEMENT_RULE_PANEL);
		click(element_topic);
		waitForElementNotPresent(ELEMENT_RULE_PANEL);
		signOut();
		
		//rollback forum portlet setting
		signIn("john", "gtn");
		goToForums();
		settingForumPortletPanel(true, true, true, true, true, true);
		signOut();
		
		info("check user demo can see rule panel");
		signIn("demo", "gtn");
		goToForums();
		click(element_forum);
		waitForElementPresent(ELEMENT_RULE_PANEL);
		click(element_topic);
		waitForElementPresent(ELEMENT_RULE_PANEL);
		signOut();
		
		//delete data
		deleteCategoryWithJohn(category, element_category);
	}
	
	/*Case13+14: Disable/Enable Statistic panel in Forum porlet setting
	 * disable Statistic panel 
	 * check user can not see Statistic panel
	 * enable Statistic panel
	 * check user can see Statistic panel 
	 */
	@Test
	public void test13_14_DisableEnableStatisticPanel(){
		//Uncheck show Statistic panel in forum portlet setting
		settingForumPortletPanel(true, true, true, true, true, true, false);
		signOut();
		
		info("Check with user demo that can not see Statistic panel");
		signIn("demo", "gtn");
		goToForums();
		waitForElementNotPresent(ELEMENT_STATISTIC_PANEL);
		signOut();
		
		//rollback forum portlet setting
		signIn("john", "gtn");
		goToForums();
		settingForumPortletPanel(true, true, true, true, true, true, true);
		signOut();
		
		info("check user demo can see Statistic panel");
		signIn("demo", "gtn");
		goToForums();
		waitForElementPresent(ELEMENT_STATISTIC_PANEL);
	}
}
