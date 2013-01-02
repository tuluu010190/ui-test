package org.exoplatform.selenium.platform.ks.functional.forum.topic;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ecms.EcmsBase.checkAlertWarning;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ks.TopicManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @date 02/01/2013
 * @author lientm
 *
 */
public class KS_Forum_Topic_Tag extends TopicManagement {
	
	@BeforeMethod
	public void beforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToForums();
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	//Case01: Add new tag in case valid data entry
	@Test
	public void test01_AddTag_ValidData(){
		String category = "KS_Forum_Topic_Tag_cat_01";
		String forum = "KS_Forum_Topic_Tag_forum_01";
		String topic = "KS_Forum_Topic_Tag_topic_01";
		String tagName = "AddTag01";
		
		//create new category, forum, topics
		makeTopicFromCategory(category, forum, topic);
		
		info("Add tag for topic");
		addTagForTopic(tagName);
		
		//untag topic
		unTagDirectly(tagName);
		
		//delete data
		jumpTo("    " + category);
		deleteCategory(category);
	}
	
	//Case02: Add new tag in case pressing Enter key to submit
	@Test
	public void test02_AddTag_PressEnterKey(){
		String category = "KS_Forum_Topic_Tag_cat_02";
		String forum = "KS_Forum_Topic_Tag_forum_02";
		String topic = "KS_Forum_Topic_Tag_topic_02";
		String tagName = "AddTag02";
		By element_tag = By.linkText(tagName);
		
		//create new category, forum, topic, post
		makeTopicFromCategory(category, forum, topic);
		
		info("Add tag for topic by press enter key");
		goToAddTagForTopic();
		type(ELEMENT_ADD_TAG, tagName, true);
		((JavascriptExecutor) driver).executeScript("javascript:eXo.webui.UIForm.submitForm('p_3218bf63-9f4e-4842-a4e6-a72f04a3a771#UITopicDetail','AddTagTopic',true)");
		waitForElementPresent(element_tag);
		info("Add tag by press Enter key for topic successfully");
		
		//untag topic
		unTagDirectly(tagName);
		
		//delete category
		jumpTo("    " + category);
		deleteCategory(category);
	}
	
	//case03: Add blank name Tag for topic
	@Test
	public void test03_AddTag_BlankName(){
		String category = "KS_Forum_Topic_Tag_cat_03";
		String forum = "KS_Forum_Topic_Tag_forum_03";
		String topic = "KS_Forum_Topic_Tag_topic_03";
		
		//create new category, forum, topic, post
		makeTopicFromCategory(category, forum, topic);
		
		info("Add tag for topic with blank name");
		goToAddTagForTopic();
		click(ELEMENT_ADD_TAG_BUTTON);
		checkAlertWarning(MESSAGE_ADD_TAG_BLANK_NAME);
		
		//delete category
		jumpTo("    " + category);
		deleteCategory(category);
	}
	
	//Case04: Untag From topic in Manage tag
	@Test
	public void test04_Untag_FromManageTag(){
		String category = "KS_Forum_Topic_Tag_cat_04";
		String forum = "KS_Forum_Topic_Tag_forum_04";
		String topic = "KS_Forum_Topic_Tag_topic_04";
		String tagName = "AddTag04";
		By element_topic = By.linkText(topic);
		
		//create new category, forum, topics
		makeTopicFromCategory(category, forum, topic);
		
		info("Add tag for topic");
		addTagForTopic(tagName);
		
		//untag topic
		unTagForTopics(tagName, topic);
		
		//check tag that is not exited in topic
		click(element_topic);
		waitForTextNotPresent(tagName);
		
		//delete data
		jumpTo("    " + category);
		deleteCategory(category);
	}
	
	//Case05: Untag directly from topic
	@Test
	public void test05_Untag_FromTopic(){
		String category = "KS_Forum_Topic_Tag_cat_05";
		String forum = "KS_Forum_Topic_Tag_forum_05";
		String topic = "KS_Forum_Topic_Tag_topic_05";
		String tagName = "AddTag05";
		
		//create new category, forum, topic, post
		makeTopicFromCategory(category, forum, topic);
		
		//add tag for topic
		addTagForTopic(tagName);
		
		unTagDirectly(tagName);
		
		//delete data
		jumpTo("    " + category);
		deleteCategory(category);
	}
	
	//Case06: Add multi-tag for topic at the same time
	@Test
	public void test06_AddMultiTag(){
		String category = "KS_Forum_Topic_Tag_cat_06";
		String forum = "KS_Forum_Topic_Tag_forum_06";
		String topic1 = "KS_Forum_Topic_Tag_topic_06_1";
		String topic2 = "KS_Forum_Topic_Tag_topic_06_2";
		String tagName = "AddTag0601 AddTag0602 AddTag0603";
		By element_topic2 = By.linkText(topic2);
		By element_topic1 = By.linkText(topic1);
		
		//create new category, forum, topics
		makeTopicFromCategory(category, forum, topic1);
		
		info("Add multi-tag for topic");
		addTagForTopic(tagName);
		
		//create topic2
		jumpTo("        " + forum);
		quickStartTopic(topic2, topic2);
		
		info("Check total occurences of tags");
		click(element_topic2);
		checkOccurenceOfTag("1", tagName, "A A A");
		
		//untag topic
		jumpTo("        " + forum);
		click(element_topic1);
		unTagDirectly(tagName);
		
		//delete data
		jumpTo("    " + category);
		deleteCategory(category);
	} 
	
	//case07: Add suggested tag for topic by administrator
	@Test
	public void test07_AddTag_ChooseSuggestedTag_UserAdmin(){
		String category = "KS_Forum_Topic_Tag_cat_07";
		String forum = "KS_Forum_Topic_Tag_forum_07";
		String topic1 = "KS_Forum_Topic_Tag_topic_07_1";
		String topic2 = "KS_Forum_Topic_Tag_topic_07_2";
		String topic3 = "KS_Forum_Topic_Tag_topic_07_3";
		String tagName = "AddTag07";
		By element_topic2 = By.linkText(topic2);
		By element_topic1 = By.linkText(topic1);
		
		//create new category, forum, topics
		makeTopicFromCategory(category, forum, topic1);
		
		info("Add tag for topic");
		addTagForTopic(tagName);
		
		info("Check total occurences and suggestion of tag and add tag for topic2");
		jumpTo("        " + forum);
		goToTopicToCheckOccurence(topic2, tagName, "1", "A");
		addTagByClickSuggestion(tagName, "1");
		
		info("Check total occurences and suggestion of tag");
		jumpTo("        " + forum);
		goToTopicToCheckOccurence(topic3, tagName, "2", "A");
		
		//untag topic1
		jumpTo("        " + forum);
		click(element_topic1);
		unTagDirectly(tagName);
		
		//untag topic2
		jumpTo("        " + forum);
		click(element_topic2);
		unTagDirectly(tagName);
		
		//delete data
		jumpTo("    " + category);
		deleteCategory(category);
	}
	
	//Case08: Add suggested tag for topic by normal user
	@Test
	public void test08_AddTag_ChooseSuggestedTag_NormalUser(){
		String category = "KS_Forum_Topic_Tag_cat_08";
		String forum = "KS_Forum_Topic_Tag_forum_08";
		String topic1 = "KS_Forum_Topic_Tag_topic_08_1";
		String topic2 = "KS_Forum_Topic_Tag_topic_08_2";
		String topic3 = "KS_Forum_Topic_Tag_topic_08_3";
		String tagName = "AddTag08";
		By element_forum = By.linkText(forum);
		
		//create new category, forum, topics
		makeTopicFromCategory(category, forum, topic1);
		
		info("Add tag for topic");
		addTagForTopic(tagName);
		signOut();
		
		//login with normal user
		signIn("demo", "gtn");
		goToForums();
		
		info("Check total occurences and suggestion of tag and add tag for topic2");
		click(element_forum);
		goToTopicToCheckOccurence(topic2, tagName, "1", "A");
		addTagByClickSuggestion(tagName, "1");
		
		info("Check total occurences and suggestion of tag");
		goToForumHome();
		click(element_forum);
		goToTopicToCheckOccurence(topic3, tagName, "2", "A");
		
		//untag and delete data
		deleteTagAndCategory(forum, topic2, topic1, category, tagName);
	}
	
	//Case09: Add suggested tag which made by other users for topic
	@Test
	public void test09_AddTag_ChooseSuggestedTag_OtherUsers(){
		String category = "KS_Forum_Topic_Tag_cat_09";
		String forum = "KS_Forum_Topic_Tag_forum_09";
		String topic1 = "KS_Forum_Topic_Tag_topic_09_1";
		String topic2 = "KS_Forum_Topic_Tag_topic_09_2";
		String tagName = "AddTag09";
		By element_topic1 = By.linkText(topic1);
		By element_forum = By.linkText(forum);
		
		//create new category, forum, topics
		makeTopicFromCategory(category, forum, topic1);
		
		info("Add tag for topic");
		addTagForTopic(tagName);
		signOut();
		
		//login with normal user
		signIn("mary", "gtn");
		goToForums();
		click(element_topic1);
		
		//check suggestion tag
		goToAddTagForTopic();
		WebElement sug = getSuggestionElement(tagName, "1");
		if ( sug == null ) assert false;
		addTagByClickSuggestion(tagName, "1");
		
		info("Check total occurences and suggestion of tag");
		goToForumHome();
		click(element_forum);
		goToTopicToCheckOccurence(topic2, tagName, "2");
		
		//untag and delete data
		deleteTagAndCategory(forum, topic1, topic1, category, tagName);
	}
	
	public static void goToTopicToCheckOccurence(String topic, String tagName, String number, String... prefix){
		By element_topic = By.linkText(topic);
		
		quickStartTopicByClickStartButton(topic, topic);
		click(element_topic);
		checkOccurenceOfTag(number, tagName, prefix);
	}
	
	public static void addTagByClickSuggestion(String tagName, String number){
		getSuggestionElement(tagName, number).click();
		click(ELEMENT_ADD_TAG_BUTTON);
		waitForTextPresent(tagName);
	}
	
	public static void deleteTagAndCategory(String forum, String topic1, String topic2, String category, String tagName){
		By element_topic2 = By.linkText(topic2);
		By element_topic1 = By.linkText(topic1);
		By element_forum = By.linkText(forum);
		
		//untag topic1
		goToForumHome();
		click(element_forum);
		click(element_topic1);
		unTagDirectly(tagName);
		signOut();
		
		//untag topic2
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToForums();
		click(element_forum);
		click(element_topic2);
		unTagDirectly(tagName);
			
		//delete data
		jumpTo("    " + category);
		deleteCategory(category);
	}
}
