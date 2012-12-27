package org.exoplatform.selenium.platform.ks.functional.forum.forum;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ks.PostManagement.quickReply;
import static org.exoplatform.selenium.platform.ks.TopicManagement.goToStartTopic;
import static org.exoplatform.selenium.platform.ks.TopicManagement.startTopic;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ecms.EcmsBase.checkAlertWarning;

import org.exoplatform.selenium.platform.ks.ForumManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @date 19/12/2012
 * @author lientm
 *
 */
public class KS_Forum_Forum_Add extends ForumManagement {	
	public static String NOTIFY_MAIL_ADD_POST = "Hi, you receive this email because you registered for the Forum and Topic Watching notification./" +
			"We would like to inform you that there is a new post in the forum ${forum} with the following content:/" +
			"_______________/" +
			"${post_content}";
	public static String NOTIFY_MAIL_ADD_TOPIC = "Hi, you receive this email because you registered for the Forum and Topic Watching notification./" +
			"We would like to inform you that there is a new topic in the forum ${forum} with the following content:/" +
			"_______________/" +
			"${topic_content}";
	public static String MESSAGE_INVALID_MAIL = "Please enter a valid email address.";
	
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
		driver.manage().deleteAllCookies();
		driver.quit();
	}
		
	/*case11: Add new Forum When select [Auto fill email moderators] option
	 * add category
	 * add forum, choose auto fill email moderator then select user/group/membership for moderator
	 */
	@Test
	public void test11_AddNewForum_SelectAutoFillEmailModerator_SelectUser(){
		String category = "KS_Forum_Add_cat_11_1";
		String forum = "KS_Forum_Forum_Add_forum_11_1";
		String[] userGroup = {"demo"};
		String email = "jack.miller@acme.exoplatform.com";
		
		//add category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		info("add forum and choose fill email moderator and select user");
		goToAddForum();
		info("Create new forum");
		select(ELEMENT_SELECT_CATERORY, category);
		String[] addForum = {forum, "1", "", "", ""};
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(2, userGroup, true, "", "", false);
		
		info("check email of user is displayed in Email addresses to notify " +
				"when there is a new post and Email addresses to notify when there is a new topic");
		assert getText(ELEMENT_NOTIFY_ADD_POST).contains(email);
		assert getText(ELEMENT_NOTIFY_ADD_TOPIC).contains(email);
		save();	
		waitForElementNotPresent(ELEMENT_POPUP_ADD_FORUM);
		info("Create forum successfully");
		
		//delete data
	    jumpTo("    "+ category);
	    deleteCategory(category);
	}
	
	@Test
	public void test11_AddNewForum_SelectAutoFillEmailModerator_SelectGroup(){
		String category = "KS_Forum_Add_cat_11_2";
		String forum = "KS_Forum_Forum_Add_forum_11_2";
		String[] userGroup = {"Development"};
		String email = "john.smith@acme.exoplatform.com, jack.miller@acme.exoplatform.com";
		
		//add category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		info("add forum and choose fill email moderator and select group");
		goToAddForum();
		info("Create new forum");
		select(ELEMENT_SELECT_CATERORY, category);
		String[] addForum = {forum, "1", "", "", ""};
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(3, userGroup, true, "", "", false);
		
		info("check email of users of group is displayed in Email addresses to notify " +
				"when there is a new post and Email addresses to notify when there is a new topic");
		assert getText(ELEMENT_NOTIFY_ADD_POST).contains(email);
		assert getText(ELEMENT_NOTIFY_ADD_TOPIC).contains(email);
		save();	
		waitForElementNotPresent(ELEMENT_POPUP_ADD_FORUM);
		info("Create forum successfully");
		
		//delete data
	    jumpTo("    "+ category);
	    deleteCategory(category);
	}
	
	@Test
	public void test11_AddNewForum_SelectAutoFillEmailModerator_SelectRole(){
		String category = "KS_Forum_Add_cat_11_3";
		String forum = "KS_Forum_Forum_Add_forum_11_3";
		String[] userGroup = {"Platform/Content Management", "redactor"};
		String email = "james.davis@acme.exoplatform.com";
		
		//add category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		info("add forum and choose fill email moderator and select role");
		goToAddForum();
		info("Create new forum");
		select(ELEMENT_SELECT_CATERORY, category);
		String[] addForum = {forum, "1", "", "", ""};
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(4, userGroup, true, "", "", false);
		
		info("check email of users of group is displayed in Email addresses to notify " +
				"when there is a new post and Email addresses to notify when there is a new topic");
		assert getText(ELEMENT_NOTIFY_ADD_POST).contains(email);
		assert getText(ELEMENT_NOTIFY_ADD_TOPIC).contains(email);
		save();	
		waitForElementNotPresent(ELEMENT_POPUP_ADD_FORUM);
		info("Create forum successfully");
		
		//delete data
	    jumpTo("    "+ category);
	    deleteCategory(category);
	}
	
	/*case12: Add new Forum when don't select [Auto fill email moderators] option
	 * add category
	 * add forum, do not select auto fill email moderator option then choose user/group/membership
	 */
	@Test
	public void test12_AddNewForum_NotSelectAutoFillEmailModerators(){
		String category = "KS_Forum_Add_cat_12";
		String forum = "KS_Forum_Forum_Add_forum_12";
		String[] userGroup = {"Platform/Content Management", "redactor"};
		String[] user = {"mary"};
		String[] group = {"Development"};
		
		//add category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		info("add forum and do not choose fill email moderator and select user/group/membership");
		goToAddForum();
		info("Create new forum");
		select(ELEMENT_SELECT_CATERORY, category);
		String[] addForum = {forum, "1", "", "", ""};
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(4, userGroup, false, "", "", false);
		setPermissionWithOption("Moderator", 2, user);
		setPermissionWithOption("Moderator", 3, group);
		
		info("check email of users of group, membership is not displayed in Email addresses to notify " +
				"when there is a new post and Email addresses to notify when there is a new topic");
		assert getText(ELEMENT_NOTIFY_ADD_POST).isEmpty();
		assert getText(ELEMENT_NOTIFY_ADD_TOPIC).isEmpty();
		save();	
		waitForElementNotPresent(ELEMENT_POPUP_ADD_FORUM);
		info("Create forum successfully");
		
		//delete data
	    jumpTo("    "+ category);
	    deleteCategory(category);
	}
	
	/*case13: Add new Forum with send notify mail for new Post option
	 * add new category
	 * add new forum, uncheck auto fill email moderator, put email address to "Email addresses to notify when there is a new post"
	 * add new topic in forum
	 * make a post in topic, check email that is sent to email address
	 */
	@Test(groups = {"pending"})
	public void test13_CheckNotify_AddNewPost(){
		String category = "KS_Forum_Add_cat_13";
		String forum = "KS_Forum_Forum_Add_forum_13";
		String topic ="KS_Forum_Forum_Add_topic_13";
		By element_topic = By.linkText(topic);
		String post_content = "KS_Forum_Forum_Add_post_content_13"; 
		By mail = By.xpath("//*[text()='[" + category + "][" + forum + "] " + topic + "']");
		
		//add category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		info("Add new forum, uncheck Auto fill Email, put Email address to sen notify when there is new post");
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {"mary"};
		addForum(category, add, 2, userGroup, false, EMAIL_ADDRESS1, null, false, 0);
		
		//add new topic and make a new post
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
		click(element_topic);
		quickReply(post_content);
		waitForTextPresent(post_content);
		
	    //Get windownHandle of current browser
	    String handlesBefore = driver.getWindowHandle();
	    
	    //check and delete mail
	    info("wait mail");
	    pause(120000);
	    info("Cheking Notification is sent to email address");
	    goToMail();
	    click(mail);
	    checkContentMail(NOTIFY_MAIL_ADD_POST.replace("${forum}", forum).replace("${post_content}", post_content));
		info("delete email");
		click(ELEMENT_DELETE);
	    waitForElementNotPresent(mail);
	    
		//delete data
		driver.switchTo().window(handlesBefore);
	    jumpTo("    "+ category);
	    waitForTextPresent(category);
	    deleteCategory(category);
	}
	
	/*case14: Add new Forum with send notify mail for new Topic option
	 * add new category
	 * add new forum, uncheck auto fill email moderator, put email address to "Email addresses to notify when there is a new topic"
	 * make a topic in forum, check email that is sent to email address
	 */
	@Test
	public void test14_CheckNotify_AddNewTopic(){
		String category = "KS_Forum_Add_cat_14";
		String forum = "KS_Forum_Forum_Add_forum_14";
		String topic ="KS_Forum_Forum_Add_topic_14";
		String topic_content = "KS_Forum_Forum_Add_topic_content_14"; 
		By mail = By.xpath("//*[text()='[" + category + "][" + forum + "] " + topic + "']");
		
		//add category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		info("Add new forum, uncheck Auto fill Email, put Email address to sen notify when there is new topic");
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {"mary"};
		addForum(category, add, 2, userGroup, false, null, EMAIL_ADDRESS1, false, 0);
		
		//add new topic
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic, topic_content, "", "", "", "", "", "", 0, user_topic);
		
	    //Get windownHandle of current browser
	    String handlesBefore = driver.getWindowHandle();
	    
	    //check and delete mail
	    info("wait mail");
	    pause(120000);
	    info("Cheking Notification is sent to email address");
	    goToMail();
	    click(mail);
	    checkContentMail(NOTIFY_MAIL_ADD_TOPIC.replace("${forum}", forum).replace("${topic_content}", topic_content));
		info("delete email");
		click(ELEMENT_DELETE);
	    waitForElementNotPresent(mail);
	    
		//delete data
		driver.switchTo().window(handlesBefore);
	    jumpTo("    " + category);
	    waitForTextPresent(category);
	    deleteCategory(category);
	}
	
	/*case15: Add new Forum with send notify mail  in case invalid email address entry
	 * add category
	 * add forum, uncheck auto fill email moderator, put email address invalid
	 * check message
	 */
	@Test
	public void test15_AddNewForum_InvalidEmailAddress(){
		String category = "KS_Forum_Add_cat_15";
		String forum = "KS_Forum_Forum_Add_forum_15";
		String mail_invalid = "test@test";
		
		//add category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		info("Add new forum, uncheck Auto fill Email, put Email address invalid");
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] user = {"","",""};
		addForum(category, add, 0, userGroup, false, mail_invalid, null, false, 0, user);
		checkAlertWarning(MESSAGE_INVALID_MAIL);
		cancel();
		addForum(category, add, 0, userGroup, false, null, mail_invalid, false, 0, user);
		checkAlertWarning(MESSAGE_INVALID_MAIL);
		cancel();
		
		//delete data
		deleteCategory(category);
	}
}
