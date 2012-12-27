package org.exoplatform.selenium.platform.ks.functional.forum.topic;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.addCategoryInForum;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.deleteCategory;
import static org.exoplatform.selenium.platform.ks.ForumManagement.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;
import static org.exoplatform.selenium.TestLogger.*;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * @date: 27/12/2012
 * @author thuntn
 *
 */
public class KS_Forum_Topic_WatchUnwatch extends ForumBase{
	public String ELEMENT_CATEGORY_LINK = "//a[@title='{$category}']";
	// Check send notify when add post in topic or forum or category that is being watched
	@Test
	public void test04_CheckSendNotificationWhenAddPost() {
		String category = "Watch/unwatch category 04";
		String forum = "Watch/unwatch forum 04";
		String topic1 = "Watch/unwatch topic 04";	
		String post = "Watch/unwatch post 04";
		String title = "[" + forum + "]["+ category + "] " + topic1  ;
		String handle1 = driver.getWindowHandle();

		info("Check send notify when add post in topic or forum or category that is being watched");

		//Add category, forum, topic
		makeTopicFromCategory(category, forum, topic1);
		waitForElementPresent(ELEMENT_POST_REPLY_BUTTON);
		//Watch topic
		watchItem(ELEMENT_CLASS_WATCH_TOPIC);
		settingMailForUser(EMAIL_ADDRESS1);
		quickReply(post);
		//Verify to send mail
		checkGmail(EMAIL_ADDRESS1, EMAIL_PASS);

		checkAndDeleteMail(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",title)), post);
		driver.switchTo().window(handle1);

		click(ELEMENT_CATEGORY_LINK.replace("{$category}", category));
		deleteCategory(category);
	}
	//pending due to failure of product
	@Test(groups={"pending"})
	public void test05_CheckSendNotificationWhenAddPrivatePost() {
		String category = "Watch/unwatch category 05";
		String forum = "Watch/unwatch forum 05";
		String topic1 = "Watch/unwatch topic 05";	
		String post = "Watch/unwatch post 05";
		String title = "[" + forum + "]["+ category + "] " + topic1  ;
		String handle1 = driver.getWindowHandle();
		info("Check send notify when add private post in topic or forum or category that is being watched");

		//Add category, forum, topic
		makeTopicFromCategory(category, forum, topic1);
		waitForElementPresent(ELEMENT_POST_REPLY_BUTTON);
		//Watch topic
		watchItem(ELEMENT_CLASS_WATCH_TOPIC);
		settingMailForUser();

		//signin as james, watch this category
		goToTopic("james", topic1);
		watchItem(ELEMENT_CLASS_WATCH_TOPIC);
		settingMailForUser("exoservice@gmail.com");

		//sign in as john, add private post 
		goToTopic("john", null);

		privatePost(topic1,post, post, null, null);

		//Verify to send mail
		checkGmail(EMAIL_ADDRESS1, EMAIL_PASS);
		checkAndDeleteMail(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",title)), post);
		driver.manage().deleteAllCookies();

		//verify that james cannot receive notification email
		checkGmail(EMAIL_ADDRESS2, "exoadmin");
		waitForElementNotPresent(ELEMENT_GMAIL_TITLE.replace("{$title}",title));

		driver.switchTo().window(handle1);
		click(ELEMENT_CATEGORY_LINK.replace("{$category}", category));
		deleteCategory(category);
	}

	//Check send notify after adding new post and it's required for approval
	@Test
	public void test06_CheckSendNotificationWhenAddApprovedPost() {
		String category = "Watch/unwatch category 06";
		String forum = "Watch/unwatch forum 06";
		String topic1 = "Watch/unwatch topic 06";	
		String post = "Watch/unwatch post 06";
		String title = "[" + forum + "]["+ category + "]" + topic1  ;
		String handle1 = driver.getWindowHandle();
		String[] audience = {};
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] user_topic = {};
		info("Check send notify after adding new post and it's required for approval");

		addCategoryInForum(category, "1", 0, audience, "", 0);
		addForum(category, add, 0, userGroup, true, "", "", false, 0);

		//Start topic
		click(ELEMENT_START_TOPIC_BUTTON);
		startTopic(topic1, topic1, "", "", "", "", "", "", 0, user_topic,true);
		click(By.linkText(topic1));

		//signin as james, watch this category
		goToTopic("james", topic1);
		watchItem(ELEMENT_CLASS_WATCH_TOPIC);
		settingMailForUser(EMAIL_ADDRESS2);

		quickReply(post);
		waitForMessage(MSG_POST_APPROVE);
		closeMessageDialog();
		waitForTextNotPresent(post);


		//sign in as john, add private post 
		goToTopic("john", topic1);
		waitForTextPresent(post);

		//Verify to send mail
		checkGmail(EMAIL_ADDRESS2, EMAIL_PASS);
		pause(1000);
		waitForElementNotPresent(ELEMENT_GMAIL_TITLE.replace("{$title}",title));

		//Approve posts
		driver.switchTo().window(handle1);
		approvePost(post);

		//Check mail and delete
		switchToNewWindow();
		checkAndDeleteMail(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",title)), post);

		//verify that james cannot receive notification email
		driver.switchTo().window(handle1);
		click(ELEMENT_CATEGORY_LINK.replace("{$category}", category));
		deleteCategory(category);
	}
	//Check send notify after adding new post and it's pending for being censored
	@Test
	public void test07_CheckSendNotificationWhenAddCemsoredPost() {
		String category = "Watch/unwatch category 07";
		String forum = "Watch/unwatch forum 07";
		String topic1 = "Watch/unwatch topic 07";	
		String post = "Watch/unwatch post Censor07";
		String title = "[" + forum + "]["+ category + "] " + topic1  ;
		String titleCensor = "[" + forum + "]["+ category + "]" + topic1  ;
		String handle1 = driver.getWindowHandle();
		String[] audience = {};
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] user_topic = {};

		info("Check send notify after adding new post and it's pending for being censored");
		//Define keywords for censoring
		setCensorKeywords("Censor07");

		//Add a category, topic
		addCategoryInForum(category, "1", 0, audience, "", 0);
		addForum(category, add, 0, userGroup, true, EMAIL_ADDRESS1, "", false, 0);

		//Start topic
		click(ELEMENT_START_TOPIC_BUTTON);
		startTopic(topic1, topic1, "", "", "", "", "", "", 0, user_topic);
		click(By.linkText(topic1));
		//Watch a topic, setup mail
		waitForElementPresent(ELEMENT_POST_REPLY_BUTTON);
		watchItem(ELEMENT_CLASS_WATCH_TOPIC);
		settingMailForUser(EMAIL_ADDRESS2);

		//sign in as james, watch this category
		goToTopic("james", topic1);

		//Quick reply
		quickReply(post);
		waitForMessage(MSG_POST_CENSOR);
		closeMessageDialog();
		waitForTextNotPresent(post);

		//sign in as john, add private post 
		goToTopic("john",topic1);
		waitForTextPresent(post);

		//Verify to send mail
		checkGmail(EMAIL_ADDRESS1, EMAIL_PASS);
		pause(1000);

		checkAndDeleteMail(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",title)), post);
		driver.manage().deleteAllCookies();

		//verify if email that is used to watch cannot receive notification email
		checkGmail(EMAIL_ADDRESS2, EMAIL_PASS);
		String handle2 = driver.getWindowHandle();
		waitForElementNotPresent(ELEMENT_GMAIL_TITLE.replace("{$title}",title));

		//Approve censored posts
		driver.switchTo().window(handle1);
		censorPost(post);

		//verify if email that is used to watch can receive notification email after approve censored posts 
		driver.switchTo().window(handle2);
		checkAndDeleteMail(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",titleCensor)), post);

		driver.switchTo().window(handle1);
		click(ELEMENT_CATEGORY_LINK.replace("{$category}", category));
		deleteCategory(category);
	}

	//Check send notify in case the user no longer have view permission on the category or forum or topic he added watch
	@Test
	public void test08_CheckSendNotificationWithNoViewPermission() {
		String category = "Watch/unwatch category 08";
		String forum = "Watch/unwatch forum 08";
		String topic1 = "Watch/unwatch topic 08";	
		String post = "Watch/unwatch post 8";
		String post2 = "Watch post 08 not view";
		String title = "[" + forum + "]["+ category + "]" + topic1  ;
		String handle1 = driver.getWindowHandle();
		String[] audience = {};
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] user_topic = {};

		info("Check send notify in case the user no longer have view permission on the category or forum or topic he added watch");
		//Add a category, forum
		addCategoryInForum(category, "1", 0, audience, "", 0);
		addForum(category, add, 0, userGroup, true, "", "", false, 0);

		//Start topic
		click(ELEMENT_START_TOPIC_BUTTON);
		startTopic(topic1, topic1, "", "", "", "", "", "", 0, user_topic,true);

		//login as james, go to topic1
		goToTopic("james", topic1);

		//Watch topic, setup mail
		watchItem(ELEMENT_CLASS_WATCH_TOPIC);
		settingMailForUser(EMAIL_ADDRESS2);

		//Quick reply
		quickReply(post);
		waitForMessage(MSG_POST_APPROVE);
		closeMessageDialog();
		waitForTextNotPresent(post);

		//Login as john, and approve post
		goToTopic("john", topic1);
		waitForTextPresent(post);
		approvePost(post);

		//Verify to send mail
		checkGmail(EMAIL_ADDRESS2, EMAIL_PASS);
		String handle2 = driver.getWindowHandle();
		pause(1000);
		checkAndDeleteMail(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",title)), post);

		//sign in as john, add private post 
		driver.switchTo().window(handle1);
		String[] restrict={"mary"};
		editTopic(topic1, topic1, "","", "", "", "", "", "", 1, restrict);
		quickReply(post2);

		//verify if email that is used to watch cannot receive notification email

		driver.switchTo().window(handle2);
		pause(150000);
		waitForElementNotPresent(ELEMENT_GMAIL_TITLE.replace("{$title}",title));

		//Delete data
		driver.switchTo().window(handle1);
		click(ELEMENT_CATEGORY_LINK.replace("{$category}", category));
		deleteCategory(category);
	}
	//Check send notify when move post in topic or forum or category that is being watched
	@Test
	public void test09_CheckSendNotificationWhenMovePost() {
		String category = "Watch category 09";
		String forum = "Watch forum 09";
		String topic1 = "Watch topic 0901";
		String topic2 = "Watch topic 0902";
		String post = "Watch post Move09";
		String title = "[" + category + "]["+ forum + "] " + topic2  ;
		String handle1 = driver.getWindowHandle();
		String[] user_topic = {};
		String path= category + "/" + forum + "/" + topic2;
		String contentMail = "Your post: \"Re: "+ topic1+ "\" has been moved to topic \""+ topic2 +"\"";

		info("Check send notify when move post in topic or forum or category that is being watched");

		//Create a category, forum, 2 topic
		makeTopicFromCategory(category, forum, topic1);
		jumpTo("        " + forum);
		click(ELEMENT_START_TOPIC_BUTTON);
		startTopic(topic2, topic2, "", "", "", "", "", "", 0, user_topic);

		//Quick post
		click(By.linkText(topic1));	
		waitForElementPresent(ELEMENT_POST_REPLY_BUTTON);
		quickReply(post);

		//Watch topic, setup mail
		watchItem(ELEMENT_CLASS_WATCH_TOPIC);
		settingMailForUser(EMAIL_ADDRESS2);

		//move post to topic 2
		movePost(post,path);

		//Verify to send mail
		checkGmail(EMAIL_ADDRESS2, EMAIL_PASS);
		pause(1000);
		checkAndDeleteMail(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",title)), contentMail);

		driver.switchTo().window(handle1);
		click(ELEMENT_CATEGORY_LINK.replace("{$category}", category));
		deleteCategory(category);
	}

	public static void goToTopic(String user, String topic){
		signOut();

		signIn(user,"gtn");
		goToForums();
		if(topic !=null )
		click(By.linkText(topic));
		waitForElementPresent(ELEMENT_POST_REPLY_BUTTON);
	}

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
}
