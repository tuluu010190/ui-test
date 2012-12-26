package org.exoplatform.selenium.platform.ks.functional.forum_usersettings;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ks.ForumBase.goToRSS;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.*;
import static org.exoplatform.selenium.platform.ks.ForumManagement.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import org.exoplatform.selenium.platform.ks.KsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thaopth
 * Date: 26 Dec 2012
 */

public class KS_Forum_UserSettings_MyWatches extends KsBase {
	public static String admin = "john";
	public static String pass = "gtn";
	public static String ELEMENT_EMAIL_SUBSCRIPTION = "//label/a[contains(text(),'${item}')]/following::label[text()='${email}']";
	public static String ELEMENT_OBJECT_SUBSCRIPTION = "//label/a[contains(text(),'${item}')]";
	public static String email = "john.smith@acme.exoplatform.com";
	public static String ELEMENT_RSS_CHECKBOX = "label/a[contains(text(),'${item}')]/following::div/input[@class='checkbox']";
	public static By ELEMENT_RSS_TITLE = By.id("feedTitleText");
	public static By ELEMENT_RSS_SUBTITLE = By.id("feedSubtitleText");
	public static String ELEMENT_RSS_FEED_CONTENT_TOPIC = "//*[@id='feedContent']//*[text()='${topic}']";
	public static String ELEMENT_RSS_DEED_CONTENT_TOPIC_LASTUPDATE = "//*[@id='feedContent']//*[text()='${topic}']/..//*[@class='lastUpdated']";
	public static String ELEMENT_RSS_FEED_CONTENT_TOPIC_CONTENT = "//*[@id='feedContent']//*[text()='${topic}']/../..//*[text()='${topic_content}']";
	public static String ELEMENT_RSS_FEED_CONTENT_POST_CONTENT = "//*[@class='feedEntryContent' and text()='${post_content}']";
	public static By ELEMENT_FEED_ENTRY = By.xpath("//*[@class='entry']");

	@BeforeMethod
	public void beforeTest(){
		getDriverAutoOpenWindow();
		//initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToForums();

	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/*
	 * KS/Forum/User Settings/My watches
	 * Case 01: Check my subscription
	 * Add category/forum/topic
	 * Watch category/forum/topic
	 * Check My subscription tab
	 */
	@Test
	public void test01_CheckMySubscription () {

		String category1 = "Case01_UserSettings01";
		String category2 = "Case01_UserSettings02";
		String forum1 = "Forum01";
		String topic ="Topic01";
		String[] add = {forum1, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};
		String[] user_topic = {};
		String class_watch_topic = "AddWatchingIcon StatusIcon";
		String class_watch_category = "AddWatchingIcon";

		//add category

		addCategoryInForum(category1, "1", 0, audience, "", 0);

		info("Add new forum");

		addForum(category1, add, 0, userGroup, true, "", "", false, 0);

		//add new topic and make a new post

		goToStartTopic();

		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);

		click(By.linkText(topic));

		watchItem(class_watch_topic);

		jumpTo(ELEMENT_HOME_FORUM);

		addCategoryInForum(category2, "2", 0, audience, "", 0);

		watchItem(class_watch_category);

		goToMySubscriptions();

		waitForElementPresent(ELEMENT_EMAIL_SUBSCRIPTION.replace("${item}", topic).replace("${email}", email));

		waitForElementPresent(ELEMENT_EMAIL_SUBSCRIPTION.replace("${item}", category2).replace("${email}", email));

		click(ELEMENT_CLOSE_WINDOW);

		//Clear data

		jumpTo("    "+ category1);

		click(By.linkText(topic));

		unwatchItem(class_watch_topic);

		jumpTo("    "+ category2);

		unwatchItem(class_watch_category);

		deleteCategory(category2);

		gotoCategory(category1);

		deleteCategory(category1);
	}
	/*
	 * Remove watches from user settings
	 */
	@Test
	public void test02_RemoveWatchesFromUserSettings () {
		String category = "Case02_UserSettings";
		String[] audience = {};
		String class_watch_category = "AddWatchingIcon";

		//add category

		addCategoryInForum(category, "1", 0, audience, "", 0);

		watchItem(class_watch_category);

		goToMySubscriptions();

		waitForElementPresent(ELEMENT_EMAIL_SUBSCRIPTION.replace("${item}", category).replace("${email}", email));

		//Delete watch

		deleteWatches(category);

		click(ELEMENT_CLOSE_WINDOW);

		//Clear data

		deleteCategory(category);
	}
	/*
	 * Check  RSS feed
	 * Create category/Forum/Topic
	 * Get RSS of category/forum/topic
	 * Go to my subscription
	 * Click directly on object RSS --> go to object (category/forum/topic)
	 */
	@Test
	public void test03_CheckRSSFeed () {
		String category = "Case03_UserSettings";
		String forum = "forum03";

		info("---add category and forum---");

		quickAddCategory(category, category, "");

		quickAddForum(forum);

		jumpTo("    " + category);

		//get RSS of forum

		goToRSS(forum);

		jumpTo(ELEMENT_HOME_FORUM);

		//Get RSS of category

		goToRSS(category);

		//Check RSS on My subscription

		goToMySubscriptions();

		waitForElementPresent(ELEMENT_OBJECT_SUBSCRIPTION.replace("${item}", category));

		waitForElementPresent(ELEMENT_OBJECT_SUBSCRIPTION.replace("${item}", forum));

		//Go to forum by click on RSS object

		click(ELEMENT_OBJECT_SUBSCRIPTION.replace("${item}", forum));

		waitForElementPresent(By.xpath("//span[text()='"+forum+"']"));

		//Clear data

		goToMySubscriptions();

		deleteWatches(forum);

		deleteWatches(category);

		click(ELEMENT_CLOSE_WINDOW);

		jumpTo("    "+ category);

		deleteCategory(category);
	}

	/*
	 * Remove RSS feed  from user setting
	 * Create category/forum/topic
	 * Get RSS of Category/Forum/Topic
	 * Go to My subscription and remove RSS
	 */
	@Test
	public void test04_RemoveRSSFeedFromUserSettings () {
		String category = "Case04_UserSettings";
		String forum = "forum04";

		//Add category and forum

		quickAddCategory(category, category, "");

		quickAddForum(forum);

		jumpTo("    " + category);

		//Get RSS of forum

		goToRSS(forum);

		jumpTo(ELEMENT_HOME_FORUM);

		//Get RSS of category

		goToRSS(category);

		//Go to my subscription and delete RSS

		goToMySubscriptions();

		waitForElementPresent(ELEMENT_OBJECT_SUBSCRIPTION.replace("${item}", category));

		waitForElementPresent(ELEMENT_OBJECT_SUBSCRIPTION.replace("${item}", forum));

		deleteWatches(forum);

		deleteWatches(category);

		click(ELEMENT_CLOSE_WINDOW);

		//Clear data

		gotoCategory(category);

		deleteCategory(category);
	}
	/*
	 * Get feed URL from RSS list
	 * Create category/forum/topic
	 * Get RSS of category/forum/topic
	 * Go to My subscription
	 * Tick on check box of RSS object and click Save
	 * Copy URL link in "Your personal feed URL" field
	 * Paste URL into new window and check RSS content
	 */
	@Test
	public void test05_GetFeedURLFromRSSList () {
		String category = "Case05_UserSettings";
		String forum = "forum05_usersettings";
		String topic_title = "case05_topic";
		String topic_mess = "Test case 05: Get feed URL from RSS list";
		String RssUrl = "http://localhost:8080/rest/ks/forum/rss/user/john";

		//Add category and forum

		quickAddCategory(category, category, "");

		quickAddForum(forum);

		quickStartTopic(topic_title, topic_mess);

		jumpTo("    " + category);

		jumpTo(ELEMENT_HOME_FORUM);

		//Get RSS of category 
		//String handlesBefore = driver.getWindowHandle();

		goToRSS(category);

		checkRSSContent(topic_title, topic_mess);
//
//		driver.close();
//
//		driver.switchTo().window(handlesBefore);

		//Go to my subscription and save RSS URL

		goToMySubscriptions();

		waitForElementPresent(ELEMENT_OBJECT_SUBSCRIPTION.replace("${item}", category));

		click(ELEMENT_RSS_CHECKBOX.replace("${item}", category));

		save();

		waitForElementNotPresent(ELEMENT_RSS_CHECKBOX.replace("${item}", category));

		String handlesBefore = driver.getWindowHandle();
		


		deleteWatches(forum);

		deleteWatches(category);

		click(ELEMENT_CLOSE_WINDOW);

		//Clear data

		gotoCategory(category);

		deleteCategory(category);
	}
	public static void checkRSSContent (String topic, String topic_content ) {
		By element_topic = By.xpath(ELEMENT_RSS_FEED_CONTENT_TOPIC.replace("${topic}", topic));
		By element_topic_content = By.xpath(ELEMENT_RSS_FEED_CONTENT_TOPIC_CONTENT.replace("${topic}", topic).replace("${topic_content}", topic_content));

		switchToNewWindow();
		waitForElementPresent(element_topic);
		waitForElementPresent(element_topic_content);
	}
}
