package org.exoplatform.selenium.platform.ks.functional.forum.administration;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.addCategoryInForum;
import static org.exoplatform.selenium.TestLogger.*;
import static org.exoplatform.selenium.platform.ks.ForumManagement.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.startTopic;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thuntn
 * @date: 07/12/2012
 */
public class KS_Forum_Administration_Notification extends ForumBase {
	public String mailItem = "//span/b[contains(text(),'{$title}')]";
	public String ELEMENT_CATEGORY_LINK = "//a[@title='{$category}']";
	public String ELEMENT_GMAIL_CHECKBOX = "//td/div/div/div/span/b[contains(text(),'{$title}')]/ancestor::tr//td[@id=':oy']/div/div";
	public String ELEMENT_GMAIL_DELETE= "//div[@class='iH']/div/div[2]/div[3]/div[1]/div";
	public By GMAIL_USERNAME = By.id("Email");
	public By GMAIL_PASS = By.id("Passwd");
	public By GMAIL_SIGN_IN = By.id("signIn");

	//Change Content of notification
	@Test
	public void test01_ChangeContentOfNotification() {
		String category = "Notification category 01";
		String[] audience = {};
		String forum = "Notification forum 01";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "Notification topic 01";	
		String[] user_topic = {};
		String notification = "Changed by John";

		String handle1 = driver.getWindowHandle();
		String titleMail = "["+category+ "][" + forum + "] " + topic;

		info("Change Content of notification");

		changeNotifications(false,null,notification);

		addCategoryInForum(category, "1", 0, audience, "", 0);
		addForum(category, add, 0, userGroup, true, "exoservice@gmail.com", "exoservice@gmail.com", false, 0);
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
		checkGmail("exoservice", "exoadmin", titleMail);
		waitForTextPresent(notification);

		click(ELEMENT_GMAIL_DELETE);

		backToPreviousBrowser(handle1);
		restoreData(category);
	}

	//Set notification with adding a prefix to notification subject
	@Test
	public void test02_SetNotificationWithAddingPrefix() {
		String category = "Notification category 02";
		String[] audience = {};
		String forum = "Notification forum 02";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "Notification topic 02";	
		String[] user_topic = {};

		String prefix = "test02";
		String handle1 = driver.getWindowHandle();
		String titleMail = prefix + "["+category+ "][" + forum + "] " + topic;

		info("Set notification with adding a prefix to notification subject");

		changeNotifications(true,prefix,"");

		addCategoryInForum(category, "1", 0, audience, "", 0);
		addForum(category, add, 0, userGroup, true, "exoservice@gmail.com", "exoservice@gmail.com", false, 0);
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
		checkGmail("exoservice", "exoadmin", titleMail);

		click(ELEMENT_GMAIL_DELETE);

		backToPreviousBrowser(handle1);
		restoreData(category);

	}
	//Set notification without adding a prefix to notification subject
	@Test
	public void test03_SetNotificationWithAddingPrefix() {
		String category = "Notification category 03";
		String[] audience = {};
		String forum = "Notification forum 03";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "Notification topic 03";	
		String[] user_topic = {};

		String prefix = "test03";
		String handle1 = driver.getWindowHandle();
		String titleMail = "["+category+ "][" + forum + "] " + topic;

		info("Set notification without adding a prefix to notification subject");

		changeNotifications(false,prefix,"");

		addCategoryInForum(category, "1", 0, audience, "", 0);
		addForum(category, add, 0, userGroup, true, "exoservice@gmail.com", "exoservice@gmail.com", false, 0);
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);
		checkGmail("exoservice", "exoadmin", titleMail);
		waitForTextNotPresent(prefix + titleMail);

		click(ELEMENT_GMAIL_DELETE);

		backToPreviousBrowser(handle1);
		restoreData(category);
	}
	//Set notification when new post notification field is blank
	@Test
	public void test04_SetNewPostNotificationBlank() {

		info("Set notification when new post notification field is blank");

		goToNotifications();
		inputDataToFrameInFrame( ELEMENT_NOTIFY_FRAME_UP, ELEMENT_NOTIFY_FRAME,"",true);
		switchToParentWindow();
		save();
		waitForMessage(MSG_NOTIFY_BLANK);
		closeMessageDialog();
		close();
	}
	//Set notification when Content moved notification field is blank
	@Test
	public void test05_SetMovedNotificationBlank() {

		info("Set notification when Content moved notification field is blank");

		goToNotifications();
		click(ELEMENT_NOTIFY_MOVE_TAB);
		inputDataToFrameInFrame( ELEMENT_NOTIFY_MOVE_FRAME_UP, ELEMENT_NOTIFY_FRAME,"",true);
		switchToParentWindow();
		save();
		waitForMessage(MSG_NOTIFY_BLANK);
		closeMessageDialog();
		close();
	}

	//Check get default content for new post notification field
	@Test
	public void test06_CheckToGetDefaultContentNewPost() {
		String defaultNotify = "Hi,\n"+ "you receive this email because you registered for the Forum and Topic Watching notification.\n" +
				"We would like to inform you that there is a new $ADD_TYPE in the $OBJECT_WATCH_TYPE $OBJECT_NAME with the following content:\n"+
				"_______________\n"+
				"$POST_CONTENT\n"+
				"_______________\n"+
				"At $TIME on $DATE, posted by $POSTER .\n"+
				"Go directly to the post: Click here.\n"+
				"Or go to reply to the post: Click here.\n";
		String changeNotify = "Changed By John";
		info("Check get default content for new post notification field");

		goToNotifications();

		inputDataToFrameInFrame( ELEMENT_NOTIFY_FRAME_UP, ELEMENT_NOTIFY_FRAME,changeNotify,true);
		switchToParentWindow();
		click(ELEMENT_NOTIFY_RESET);
		save();
		goToNotifications();
		verifyDefaultContent(ELEMENT_NOTIFY_FRAME_UP, defaultNotify);

		switchToParentWindow();
		close();	

	}

	//Check get default content for content moved notification field
	@Test
	public void test07_CheckToGetDefaultContentMoved() {
		String defaultNotify = "Your $OBJECT_TYPE: \"$OBJECT_NAME\" has been moved to $OBJECT_PARENT_TYPE \"$OBJECT_PARENT_NAME\"\n" + 
								"Go";
		String changeNotify = "Changed By John";
		
		info("Check get default content for content moved notification field");

		goToNotifications();
		click(ELEMENT_NOTIFY_MOVE_TAB);
		inputDataToFrameInFrame( ELEMENT_NOTIFY_MOVE_FRAME_UP, ELEMENT_NOTIFY_FRAME,changeNotify,true);
		switchToParentWindow();
		click(ELEMENT_NOTIFY_MOVE_RESET);
		save();
		goToNotifications();
		click(ELEMENT_NOTIFY_MOVE_TAB);
		verifyDefaultContent(ELEMENT_NOTIFY_MOVE_FRAME_UP, defaultNotify);

		switchToParentWindow();
		close();	

	}
	//use for this class
	public void verifyDefaultContent(By frame, String content){
		String[] contents= content.split("\n");
		
		driver.switchTo().frame(waitForAndGetElement(frame));
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_NOTIFY_FRAME));
		WebElement inputsummary = driver.switchTo().activeElement();

		String[] texts = inputsummary.getText().split(System.getProperty("line.separator"));

		for(int i=0; i< texts.length; i++){
			info(texts[i] + i);
			assert texts[i].equals(contents[i]): "Fail! Cannot load default content!";
		}
	}

	//use for only this class
	public void restoreData(String category){
		click(ELEMENT_CATEGORY_LINK.replace("{$category}", category));
		deleteCategory(category);

		resetNotification();
	}
	/** Check mail in gmail
	 * @author thuntn
	 * @param user
	 * @param pass
	 * @param titleMail: title of mail that need to be checked
	 */
	public void  checkGmail(String user, String pass, String titleMail){
		((JavascriptExecutor) driver).executeScript("window.open()");
		switchToNewWindow();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		type(GMAIL_USERNAME,user,true);
		type(GMAIL_PASS,pass,true);

		click(GMAIL_SIGN_IN);
		waitForTextPresent(titleMail,120000);
		click(mailItem.replace("{$title}",titleMail));

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
