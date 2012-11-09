package org.exoplatform.selenium.platform.ks.functional.forum.category;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.ForumManagement.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ecms.EcmsBase.checkAlertWarning;

import org.exoplatform.selenium.platform.ks.ForumManageCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author lientm
 * @date 4/12/2012
 * note: to run this class, first, you have to config configuration.properties file in gatein folder, that is address to sent mail
 * eg: exoservice@gmail.com/exoadmin
 */

public class KS_Forum_Category_Watch_Apply extends ForumManageCategory {
	public static String ELEMENT_MAIL = "//b[text()='[${category}][${forum}] ${topic}']";
	public static String MESSAGE_PENDING_MODERATOR = "Your topic is pending for moderation. It will be displayed after approval.";
	public static String MESSAGE_PENDING_CENSOR = "This post may contain offensive content. It will be displayed after moderation.";
	public static String REGISTER_MAIL_CONTENT = "you receive this email because you registered for the Forum and Topic Watching notification";
	public static String REGISTER_MAIL_CONTENT_PENDING = "You receive this email because you registered for eXo Forum and Topic Watching notification";
	public static String MOVE_MAIL_CONTENT = "Your topic: \"${topic}\" has been moved to forum \"${forum_des}\"";
	
	@BeforeMethod
	public void BeforeTest(){
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
		
	/**
	 * function: create and forum -> use for only this class
	 * @param category: title of category
	 * @param forum: title of forum
	 */
	public static void createCategoryAndForum(String category, String forum){
		//add new category
		goToAddCategory();
		String[] audience = {};
		String[] user_cat = {};
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);

		//add new forum
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] user_forum = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0, user_forum);
	} 
	
	//function create new topic by normal user -> use for only this class
	public static void createTopicWithNormalUser(String topic){
		click(ELEMENT_START_TOPIC_BUTTON);
		waitForElementPresent(ELEMENT_POPUP_START_TOPIC);
		String[] user_topic = {};
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
	}
	
	/*Case01: Check send notify when add new topic into a forum that is being watched
	 * Create category, forum
	 * watch forum
	 * Add topic into forum/category that is being watched
	 * check mail
	 */
	@Test
	public void test01_SendNotification_AddTopic_WatchForum(){
		String category = "KS_Watch_Apply_cat_01";
		String forum = "KS_Watch_Apply_forum_01";
		String topic ="KS_Watch_Apply_topic_01";
		By mail = By.xpath("//b[text()='[" + category + "][" + forum + "] " + topic + "']");
		
		//add category and forum
		createCategoryAndForum(category, forum);
		
		//watch forum
		watchItem("StatusIcon AddWatchingIcon");
		
		//setting mail
		settingMailForUser();
		
		//add new topic to forum
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
		
	    //Get windownHandle of current browser
	    String handlesBefore = driver.getWindowHandle();
	    
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check and delete mail
	    goToMail();
	    checkAndDeleteMail(mail, REGISTER_MAIL_CONTENT);
	    waitForTextNotPresent(topic);
	    
	    //Switch back to previous browser to delete category
		driver.switchTo().window(handlesBefore);
	    jumpTo("    "+ category);
	    deleteCategory(category);
	}
	
	/*case02: Check send notify after adding new topic into forum/category which is watching  and it's required for approval
	 * create category, forum with checked Moderate Topics option
	 * watch category by normal user
	 * add topic into forum
	 * check topic in pending status
	 * approve topic -> check mail
	 */
	@Test
	public void test02_SendNotification_RequiedApproval_WatchCategory(){
		String category = "KS_Watch_App_cat_02_1";
		String forum = "KS_Watch_App_forum_02_1";
		String topic ="KS_Watch_App_topic_02_1";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		By mail = By.xpath("//b[text()='[" + category + "][" + forum + "]" + topic + "']");
		By topic_pending = By.xpath("//a[text()='" + topic + "']/../*//span[text()='Pending']");
		
		//create category
		goToForums();
		goToAddCategory();
		String[] audience = {};
		String[] user_cat = {};
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);
		
		//create forum with checked Moderate Topics option
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] user_forum = {};
		addForum(category, add, 0, userGroup, true, "", "", true, 0, user_forum);
		signOut();
		
		//watch category and forum by user James
		signIn("james", "gtn");
		goToForums();
		click(element_category);
		watchItem("AddWatchingIcon");
		
		info("Setting mail address for James");
		settingMailForUser();
		
		info("Make a topic with user James");
		click(element_forum);
		createTopicWithNormalUser(topic);
		pause(500);
		checkAlertWarning(MESSAGE_PENDING_MODERATOR);
		waitForTextNotPresent(topic);
		signOut();
		
		info("Go to forum with user administrator/moderator");
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		click(element_forum);
		waitForElementPresent(topic_pending);
		info("Topic is pending");
		
	    //Get windownHandle of current browser
	    String handles_forum = driver.getWindowHandle();
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check user James is not received notify mail
	    goToMail();
	    waitForElementNotPresent(mail);
	    String handles_mail = driver.getWindowHandle();
	    info("Mail is not sent");
	    
	    //approve topic
		driver.switchTo().window(handles_forum);
		click(element_topic);
		pause(500);
		approveTopic();
		
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check mail then delete
		driver.switchTo().window(handles_mail);
		clearCache();
	    checkAndDeleteMail(mail, REGISTER_MAIL_CONTENT_PENDING);
	    waitForTextNotPresent(topic);
	    
	    //delete category
		driver.switchTo().window(handles_forum);
	    jumpTo("    "+ category);
	    deleteCategory(category);
	}
	
	@Test
	public void test02_SendNotification_RequiedApproval_WatchForum(){
		String category = "KS_Watch_App_cat_02_2";
		String forum = "KS_Watch_App_forum_02_2";
		String topic ="KS_Watch_App_topic_02_2";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		By mail = By.xpath("//b[text()='[" + category + "][" + forum + "]" + topic + "']");
		By topic_pending = By.xpath("//a[text()='" + topic + "']/../*//span[text()='Pending']");
		
		//create category
		goToForums();
		goToAddCategory();
		String[] audience = {};
		String[] user_cat = {};
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);
		
		//create forum with checked Moderate Topics option
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] user_forum = {};
		addForum(category, add, 0, userGroup, true, "", "", true, 0, user_forum);
		signOut();
		
		//watch category and forum by user James
		signIn("james", "gtn");
		goToForums();
		click(element_category);
		click(element_forum);
		watchItem("StatusIcon AddWatchingIcon");
		
		info("Setting mail address for James");
		settingMailForUser();
		
		info("Make a topic with user James");
		createTopicWithNormalUser(topic);
		pause(500);
		checkAlertWarning(MESSAGE_PENDING_MODERATOR);
		waitForTextNotPresent(topic);
		signOut();
		
		info("Go to forum with user administrator/moderator");
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		click(element_forum);
		waitForElementPresent(topic_pending);
		info("Topic is pending");
		
	    //Get windownHandle of current browser
	    String handles_forum = driver.getWindowHandle();
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check user James is not received notify mail
	    goToMail();
	    waitForElementNotPresent(mail);
	    String handles_mail = driver.getWindowHandle();
	    info("Mail is not sent");
	    
	    //approve topic
		driver.switchTo().window(handles_forum);
		click(element_topic);
		pause(500);
		approveTopic();
		
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check mail then delete
		driver.switchTo().window(handles_mail);
		clearCache();
	    checkAndDeleteMail(mail, REGISTER_MAIL_CONTENT_PENDING);
	    waitForTextNotPresent(topic);
	    
	    //delete category
		driver.switchTo().window(handles_forum);
	    jumpTo("    "+ category);
	    deleteCategory(category);
	}
	
	/*case03: Check send notify after adding new topic and it's in pending for censor
	 * create new category and forum
	 * define a censor word
	 * login with normal user: watch category and make a topic contains censor word
	 * check topic in pending status
	 * censor this topic -> check mail register sent to normal user
	 */
	@Test
	public void test03_SendNotification_RequidCensored_WatchCategoy(){
		String category = "KS_Watch_App_cat_03_01";
		String forum = "KS_Watch_App_forum_03_01";
		String topic ="KS_Watch_App_topic_03_01";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By mail = By.xpath("//b[text()='[" + category + "][" + forum + "]" + topic + "']");
		By topic_pending = By.xpath("//a[text()='" + topic + "']/../*//span[text()='Censored']");
		
		//add category and forum
		createCategoryAndForum(category, forum);
		setCensorKeywords(topic);
		signOut();
		
		//watch category and forum by user James
		signIn("james", "gtn");
		goToForums();
		click(element_category);
		watchItem("AddWatchingIcon");
		
		info("Setting mail address for James");
		settingMailForUser();
		
		info("Make a topic with user James");
		click(element_forum);
		createTopicWithNormalUser(topic);
		checkAlertWarning(MESSAGE_PENDING_CENSOR);
		waitForTextNotPresent(topic);
		signOut();
		
		info("Go to forum with user administrator/moderator");
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		click(element_forum);
		waitForElementPresent(topic_pending);
		info("Topic is pending");
		
	    //Get windownHandle of current browser
	    String handles_forum = driver.getWindowHandle();
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check user James is not received notify mail
	    goToMail();
	    waitForElementNotPresent(mail);
	    String handles_mail = driver.getWindowHandle();
	    info("Mail is not sent");
	    
	    //censored topic
		driver.switchTo().window(handles_forum);
		censorTopic(topic);
		
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check mail then delete
		driver.switchTo().window(handles_mail);
		clearCache();
	    checkAndDeleteMail(mail, REGISTER_MAIL_CONTENT_PENDING);
	    waitForTextNotPresent(topic);
	    
	    //delete category
		driver.switchTo().window(handles_forum);
	    jumpTo("    "+ category);
	    deleteCategory(category);
	    setCensorKeywords("");
	}	 
	
	@Test
	public void test03_SendNotification_RequidCensored_WatchForum(){
		String category = "KS_Watch_App_cat_03_02";
		String forum = "KS_Watch_App_forum_03_02";
		String topic ="KS_Watch_App_topic_03_02";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By mail = By.xpath("//b[text()='[" + category + "][" + forum + "]" + topic + "']");
		By topic_pending = By.xpath("//a[text()='" + topic + "']/../*//span[text()='Censored']");
		
		//add category and forum
		createCategoryAndForum(category, forum);
		setCensorKeywords(topic);
		signOut();
		
		//watch category and forum by user James
		signIn("james", "gtn");
		goToForums();
		click(element_category);
		click(element_forum);
		watchItem("StatusIcon AddWatchingIcon");
		
		info("Setting mail address for James");
		settingMailForUser();
		
		info("Make a topic with user James");
		createTopicWithNormalUser(topic);
		checkAlertWarning(MESSAGE_PENDING_CENSOR);
		waitForTextNotPresent(topic);
		signOut();
		
		info("Go to forum with user administrator/moderator");
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		click(element_forum);
		waitForElementPresent(topic_pending);
		info("Topic is pending");
		
	    //Get windownHandle of current browser
	    String handles_forum = driver.getWindowHandle();
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check user James is not received notify mail
	    goToMail();
	    waitForElementNotPresent(mail);
	    String handles_mail = driver.getWindowHandle();
	    info("Mail is not sent");
	    
	    //censored topic
		driver.switchTo().window(handles_forum);
		censorTopic(topic);
		
	    info("Wait to send mail");
	    pause(120000);
	    
	    //check mail then delete
		driver.switchTo().window(handles_mail);
		clearCache();
	    checkAndDeleteMail(mail, REGISTER_MAIL_CONTENT_PENDING);
	    waitForTextNotPresent(topic);
	    
	    //delete category
		driver.switchTo().window(handles_forum);
	    jumpTo("    "+ category);
	    deleteCategory(category);
	    setCensorKeywords("");
	}	 
	
	/*case09: Check send notify after move topic in forum/category that is being watched
	 * create category, forum, topic
	 * watch category/forum
	 * move topic to other forum
	 * check mail
	 */
	@Test
	public void test09_SendNotification_MoveTopic_WatchCategory(){
		String category = "KS_Watch_App_cat_091";
		String forum = "KS_Watch_App_forum_091";
		String topic ="KS_Watch_App_topic_091";
		By element_category = By.linkText(category);
		By element_topic = By.linkText(topic);
		String category1 = "KS_Watch_App_cat_091_02";
		String forum1 = "KS_Watch_App_forum_091_02";
		By mail = By.xpath("//b[text()='[" + category1 + "][" + forum1 + "] " + topic + "']");
		String mail_content = MOVE_MAIL_CONTENT.replace("${topic}", topic).replace("${forum_des}", forum1);
		
		//create category, forum, topic
		createCategoryAndForum(category, forum);
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
		
		//watch category and forum
		jumpTo("    " + category);
		watchItem("AddWatchingIcon");
		
		info("Setting mail address for John");
		settingMailForUser();
		
		//create category1, forum1
		jumpTo("Forum Home");
		createCategoryAndForum(category1, forum1);
		
		//move topic form forum to forum1
		jumpTo("        " + forum);
		click(element_topic);
		pause(500);
		moveTopic(topic, category1 + "/" + forum1);
		
	    String handles_forum = driver.getWindowHandle();
	    info("Wait to send mail");
	    pause(120000);
	    
	    goToMail();
	    checkAndDeleteMail(mail, mail_content);	    
	    waitForTextNotPresent(topic);
	    
	    //delete category
		driver.switchTo().window(handles_forum);
	    jumpTo("    "+ category1);
	    deleteCategory(category1);
	    click(element_category);
	    deleteCategory(category);
	}
	
	@Test
	public void test09_SendNotification_MoveTopic_WatchForum(){
		String category = "KS_Watch_App_cat_092";
		String forum = "KS_Watch_App_forum_092";
		String topic ="KS_Watch_App_topic_092";
		By element_category = By.linkText(category);
		By element_topic = By.linkText(topic);
		String category1 = "KS_Watch_App_cat_092_02";
		String forum1 = "KS_Watch_App_forum_092_02";
		By mail = By.xpath("//b[text()='[" + category1 + "][" + forum1 + "] " + topic + "']");
		String mail_content = MOVE_MAIL_CONTENT.replace("${topic}", topic).replace("${forum_des}", forum1);
		
		//create category, forum, topic
		createCategoryAndForum(category, forum);
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
		
		//watch category and forum
		jumpTo("        " + forum);
		watchItem("StatusIcon AddWatchingIcon");
		
		info("Setting mail address for John");
		settingMailForUser();
		
		//create category1, forum1
		jumpTo("Forum Home");
		createCategoryAndForum(category1, forum1);
		
		//move topic form forum to forum1
		jumpTo("        " + forum);
		click(element_topic);
		pause(500);
		moveTopic(topic, category1 + "/" + forum1);
		
	    String handles_forum = driver.getWindowHandle();
	    info("Wait to send mail");
	    pause(120000);
	    
	    goToMail();
	    checkAndDeleteMail(mail, mail_content);
	    waitForTextNotPresent(topic);
	    
	    //delete category
		driver.switchTo().window(handles_forum);
	    jumpTo("    "+ category1);
	    deleteCategory(category1);
	    click(element_category);
	    deleteCategory(category);
	}
}
