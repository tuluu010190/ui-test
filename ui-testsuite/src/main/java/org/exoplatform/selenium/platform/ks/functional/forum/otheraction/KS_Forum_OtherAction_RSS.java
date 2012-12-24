package org.exoplatform.selenium.platform.ks.functional.forum.otheraction;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ks.KsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @date 21/12/2012
 * @author lientm
 *
 */
public class KS_Forum_OtherAction_RSS extends KsBase {
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
	
	public static void checkRSSFile(String item, String item_des, String fileName, String topic, String topic_content, String post_content1, String post_content2){
		By element_topic = By.xpath(ELEMENT_RSS_FEED_CONTENT_TOPIC.replace("${topic}", topic));
		By element_lastupdate = By.xpath(ELEMENT_RSS_DEED_CONTENT_TOPIC_LASTUPDATE.replace("${topic}", topic));
		By element_topic_content = By.xpath(ELEMENT_RSS_FEED_CONTENT_TOPIC_CONTENT.replace("${topic}", topic).replace("${topic_content}", topic_content));
		By element_post_content1 = By.xpath(ELEMENT_RSS_FEED_CONTENT_POST_CONTENT.replace("${post_content}", post_content1));
		By element_post_content2 = By.xpath(ELEMENT_RSS_FEED_CONTENT_POST_CONTENT.replace("${post_content}", post_content2));
		
		goToRSS(item);
		switchToNewWindow();
		captureScreen(fileName);	
		assert getText(ELEMENT_RSS_TITLE).equalsIgnoreCase(item);
		assert getText(ELEMENT_RSS_SUBTITLE).equalsIgnoreCase(item_des);
		waitForElementPresent(element_topic);
		assert !getText(element_lastupdate).isEmpty();
		waitForElementPresent(element_topic_content);
		waitForElementPresent(element_post_content1);
		waitForElementPresent(element_post_content2);
	}
	
	public static void checkRSSNotContainTopic(String item, String fileName, String topic, String topic_content, String post_content1, String post_content2){
		By element_topic = By.xpath(ELEMENT_RSS_FEED_CONTENT_TOPIC.replace("${topic}", topic));
		By element_topic_content = By.xpath(ELEMENT_RSS_FEED_CONTENT_TOPIC_CONTENT.replace("${topic}", topic).replace("${topic_content}", topic_content));
		By element_post_content1 = By.xpath(ELEMENT_RSS_FEED_CONTENT_POST_CONTENT.replace("${post_content}", post_content1));
		By element_post_content2 = By.xpath(ELEMENT_RSS_FEED_CONTENT_POST_CONTENT.replace("${post_content}", post_content2));		
		
		goToRSS(item);
		switchToNewWindow();
		captureScreen(fileName);	
		assert getText(ELEMENT_RSS_TITLE).equalsIgnoreCase(item);
		assert getText(ELEMENT_RSS_SUBTITLE).equalsIgnoreCase(item);
		waitForElementNotPresent(element_topic);
		waitForElementNotPresent(element_topic_content);
		waitForElementNotPresent(element_post_content1);
		waitForElementNotPresent(element_post_content2);
		driver.close();
	}
	
	/*case01: Get RSS of a specific Category
	 * create category1, forum1, topic1, post1, post2
	 * create category2, forum2, topic2, post3
	 * get RSS of category1
	 * check on RSS, display category1, topic1, post1, post2
	 */
	@Test
	public void test01_GetRss_SpecificCategory(){
		String category = "KS_Forum_OtherAction_RSS_cat_01";
		String forum = "KS_Forum_OtherAction_RSS_forum_01";
		String topic = "KS_Forum_OtherAction_RSS_topic_01";
		String category2 = "KS_Forum_OtherAction_RSS_cat_01_02";
		String forum2 = "KS_Forum_OtherAction_RSS_forum_01_02";
		String topic2 = "KS_Forum_OtherAction_RSS_topic_01_02";
		String topic_content = "KS_Forum_OtherAction_RSS_topic_content_01";
		String post_content1 = "KS_Forum_OtherAction_RSS_post_01_1"; 
		String post_content2 = "KS_Forum_OtherAction_RSS_post_01_2";
		String post_content3 = "KS_Forum_OtherAction_RSS_post_01_3";
		String fileName = "KS_Forum_OtherAction_RSS_Category_01";
		By element_category2 = By.xpath("//*[text()='" + category2 + "']");
		By element_topic2 = By.xpath("//*[text()='" + topic2 + "']");
		By element_post3 = By.xpath("//*[text()='" + post_content3 + "']");
		
		//create new category, forum, topic, 2 post
		makeTopicFromCategory(category, forum, topic, topic_content);
		quickReply(post_content1, true);
		quickReply(post_content2, true);
		
		//create new category 2
		jumpTo("Forum Home");
		makeTopicFromCategory(category2, forum2, topic2);
		quickReply(post_content3, true);
		
		jumpTo("Forum Home");
	    String handlesBefore = driver.getWindowHandle();
	    
	    info("Check RSS content of categpory");
	    checkRSSFile(category, category, fileName, topic, topic_content, post_content1, post_content2);
	    info("Check post_conten3, topic2 of category 2 is not display");
	    waitForElementNotPresent(element_category2);
	    waitForElementNotPresent(element_topic2);
	    waitForElementNotPresent(element_post3);
		driver.close();
		
		driver.switchTo().window(handlesBefore);
		click(By.linkText(category));
		deleteCategory(category);
		click(By.linkText(category2));
		deleteCategory(category2);
	}
	
	/* case02: Get RSS of a specific forum
	 * create category, forum1, topic1, post1, post2
	 * in category, create forum2, topic2, post3
	 * get RSS of forum1
	 * check on RSS, display topic1, post1, post2
	 */
	@Test
	public void test02_GetRss_SpecificForum(){
		String category = "KS_Forum_OtherAction_RSS_cat_02";
		String forum = "KS_Forum_OtherAction_RSS_forum_02";
		String topic = "KS_Forum_OtherAction_RSS_topic_02";
		String forum2 = "KS_Forum_OtherAction_RSS_forum_02_02";
		String topic2 = "KS_Forum_OtherAction_RSS_topic_02_02";
		String topic_content = "KS_Forum_OtherAction_RSS_topic_content_02";
		String post_content1 = "KS_Forum_OtherAction_RSS_post_02_1"; 
		String post_content2 = "KS_Forum_OtherAction_RSS_post_02_2";
		String post_content3 = "KS_Forum_OtherAction_RSS_post_02_3";
		By element_topic2 = By.xpath("//*[text()='" + topic2 + "']");
		By element_post3 = By.xpath("//*[text()='" + post_content3 + "']");		
		String fileName = "KS_Forum_OtherAction_RSS_Forum_02";

		//create new category, forum, topic, 2 post
		makeTopicFromCategory(category, forum, topic, topic_content);
		quickReply(post_content1, true);
		quickReply(post_content2, true);
		
		//create new forum 2 , topic2, post3 in category
		jumpTo("    " + category);
		goToAddForum();
		String[] add = {forum2, "1", "", "",""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic2, topic2, "", "", "", "", "", "", 0, user_topic);
		click(By.linkText(topic2));
		quickReply(post_content3, true);
		
		jumpTo("Forum Home");
	    String handlesBefore = driver.getWindowHandle();
	    
	    info("Check RSS content of forum");
	    checkRSSFile(forum, forum, fileName, topic, topic_content, post_content1, post_content2);
	    waitForElementNotPresent(element_topic2);
	    waitForElementNotPresent(element_post3);
		driver.close();
	    
		driver.switchTo().window(handlesBefore);
		click(By.linkText(category));
		deleteCategory(category);
	}
	
	@Test
	/* case03: Get RSS of a specific topic
	 * create category, forum, topic, post1, post2
	 * in forum, create topic2, post3
	 * get RSS of forum1
	 * check on RSS, display topic, post1, post2, not display topic2, post3
	 */
	public void test03_GetRss_specificTopic(){
		String category = "KS_Forum_OtherAction_RSS_cat_03";
		String forum = "KS_Forum_OtherAction_RSS_forum_03";
		String topic = "KS_Forum_OtherAction_RSS_topic_03";
		String topic2 = "KS_Forum_OtherAction_RSS_topic_03_02";
		String topic_content = "KS_Forum_OtherAction_RSS_topic_content_03";
		String post_content1 = "KS_Forum_OtherAction_RSS_post_03_1"; 
		String post_content2 = "KS_Forum_OtherAction_RSS_post_03_2";
		String post_content3 = "KS_Forum_OtherAction_RSS_post_03_3";
		By element_topic2 = By.xpath("//*[text()='" + topic2 + "']");
		By element_post3 = By.xpath("//*[text()='" + post_content3 + "']");		
		String fileName = "KS_Forum_OtherAction_RSS_topic_03";

		//create new category, forum, topic, 2 post
		makeTopicFromCategory(category, forum, topic, topic_content);
		quickReply(post_content1, true);
		quickReply(post_content2, true);
		
		//create new topic2, post3 in category
		jumpTo("        " + forum);
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic2, topic2, "", "", "", "", "", "", 0, user_topic);
		click(By.linkText(topic2));
		quickReply(post_content3, true);
		
		jumpTo("        " + forum);
	    String handlesBefore = driver.getWindowHandle();
	    
	    info("Check RSS content of forum");
	    checkRSSFile(topic, topic_content, fileName, topic, topic_content, post_content1, post_content2);
	    waitForElementNotPresent(element_topic2);
	    waitForElementNotPresent(element_post3);
		driver.close();
	    
		driver.switchTo().window(handlesBefore);
		jumpTo("    " + category);
		deleteCategory(category);
	}
	
	/*case04: Get RSS of a specific category which without any post 
	 * create category
	 * create cagegory2, forum2, topic2, post3
	 * get RSS of category
	 * check on RSS, it does not display any post
	 */
	@Test
	public void test04_GetRss_SpecificCategory_WithoutPost(){
		String category = "KS_Forum_OtherAction_RSS_cat_04";
		String category2 = "KS_Forum_OtherAction_RSS_cat_04_02";
		String forum2 = "KS_Forum_OtherAction_RSS_forum_04_02";
		String topic2 = "KS_Forum_OtherAction_RSS_topic_04_02";
		String post_content3 = "KS_Forum_OtherAction_RSS_post_04_3";
		String fileName = "KS_Forum_OtherAction_RSS_Category_04";
		
		//create new category, forum, topic, 2 post
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, category, 0);
		
		//create new category 2
		jumpTo("Forum Home");
		makeTopicFromCategory(category2, forum2, topic2);
		quickReply(post_content3, true);
		
		jumpTo("Forum Home");
	    String handlesBefore = driver.getWindowHandle();
	    
	    info("Check RSS content of categpory");
		goToRSS(category);
		switchToNewWindow();
		captureScreen(fileName);	
		assert getText(ELEMENT_RSS_TITLE).equalsIgnoreCase(category);
		assert getText(ELEMENT_RSS_SUBTITLE).equalsIgnoreCase(category);
		waitForElementNotPresent(ELEMENT_FEED_ENTRY);
		driver.close();
		
		driver.switchTo().window(handlesBefore);
		click(By.linkText(category));
		deleteCategory(category);
		click(By.linkText(category2));
		deleteCategory(category2);
	}
	
	/*case05: Get RSS of a specific forum which without any post
	 * create category, forum
	 * in category, add new forum2, topic2, post3
	 * get RSS of forum
	 * check in RSS, it does not display any post
	 */
	@Test
	public void test05_GetRss_SpecificForum_WithoutPost(){
		String category = "KS_Forum_OtherAction_RSS_cat_05";
		String forum = "KS_Forum_OtherAction_RSS_forum_05";
		String forum2 = "KS_Forum_OtherAction_RSS_forum_05_02";
		String topic2 = "KS_Forum_OtherAction_RSS_topic_05_02";
		String post_content3 = "KS_Forum_OtherAction_RSS_post_05_3";	
		String fileName = "KS_Forum_OtherAction_RSS_Forum_05";

		//create new category, forum2, topic2, post3
		makeTopicFromCategory(category, forum2, topic2);
		quickReply(post_content3, true);
		
		//create new forum
		jumpTo("    " + category);
		goToAddForum();
		String[] add = {forum, "1", "", "", forum};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		
		jumpTo("Forum Home");
	    String handlesBefore = driver.getWindowHandle();
	    
	    info("Check RSS content of forum");
		goToRSS(forum);
		switchToNewWindow();
		captureScreen(fileName);	
		assert getText(ELEMENT_RSS_TITLE).equalsIgnoreCase(forum);
		assert getText(ELEMENT_RSS_SUBTITLE).equalsIgnoreCase(forum);
		waitForElementNotPresent(ELEMENT_FEED_ENTRY);
		driver.close();
	    
		driver.switchTo().window(handlesBefore);
		click(By.linkText(category));
		deleteCategory(category);
	}
	
	/*case06+07+08: N/A => not use for PLF
	 */
	
	/*case09: Get RSS of a topic which contains Private post
	 * create new category, forum, topic, post
	 * make a private post
	 * get RSS of topic, it do not contains private post
	 */
	@Test
	public void test09_GetRss_Topic_ContainPrivatePost(){
		String category = "KS_Forum_OtherAction_RSS_cat_09";
		String forum = "KS_Forum_OtherAction_RSS_forum_09";
		String topic = "KS_Forum_OtherAction_RSS_topic_09";
		String post_content1 = "KS_Forum_OtherAction_RSS_post_09_1"; 
		String post_content2 = "KS_Forum_OtherAction_RSS_post_09_2";
		String fileName = "KS_Forum_OtherAction_RSS_PrivatePost_09";
		String topic_content = "KS_Forum_OtherAction_RSS_topic_content_09";
		String private_post = "KS_Forum_OtherAction_RSS_private_post_09";
		By element_private = By.xpath("//*[text()='" + private_post + "']");
		
		//create new category, forum, topic, post1, post2
		makeTopicFromCategory(category, forum, topic, topic_content);
		quickReply(post_content1, true);
		quickReply(post_content2, true);
		
		info("Add new private post to this topic");
		privatePost(topic, null, private_post, null, null);
		
		jumpTo("Forum Home");
	    String handlesBefore = driver.getWindowHandle();
	    
	    info("Check RSS of topic that does not display private post");
	    checkRSSFile(topic, topic_content, fileName, topic, topic_content, post_content1, post_content2);
	    waitForElementNotPresent(element_private);
		driver.close();
		
		driver.switchTo().window(handlesBefore);
		click(By.linkText(category));
		deleteCategory(category);	
	}
	
	/*Case10: Get RSS of a Censored post
	 * create new category, forum, topic, post
	 * add new censored keyword
	 * add new post contains censor keyword with user normal
	 * get RSS of topic with user admin, can not see censored post
	 */
	@Test
	public void test10_GetRSS_CensoredPost(){
		String category = "KS_Forum_OtherAction_RSS_cat_10";
		String forum = "KS_Forum_OtherAction_RSS_forum_10";
		String topic = "KS_Forum_OtherAction_RSS_topic_10";
		String post_content1 = "KS_Forum_OtherAction_RSS_post_10_1"; 
		String post_content2 = "KS_Forum_OtherAction_RSS_post_10_2";
		String fileName = "KS_Forum_OtherAction_RSS_CensoredPost_10";
		String topic_content = "KS_Forum_OtherAction_RSS_topic_content_10";
		String censored_post = "KS_Forum_OtherAction_RSS_censored_post_10";
		String censoredKey = "censored_post";
		By element_censored = By.xpath("//*[text()='" + censored_post + "']");
		By element_topic = By.linkText(topic);
		
		//create new category, forum, topic, post1, post2
		makeTopicFromCategory(category, forum, topic, topic_content);
		quickReply(post_content1, true);
		quickReply(post_content2, true);
		
		//create new censor Key
		setCensorKeywords(censoredKey);
		signOut();
		
		info("Make new post contains censor keyword with user normal");
		signIn("james", "gtn");
		goToForums();
		click(element_topic);
		quickReply(censored_post);
		waitForTextNotPresent(censored_post);
		signOut();
		
		info("Get RSS of topic");
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToForums();
	    String handlesBefore = driver.getWindowHandle();
	    checkRSSFile(topic, topic_content, fileName, topic, topic_content, post_content1, post_content2);
	    waitForElementNotPresent(element_censored);
		driver.close();
		
		driver.switchTo().window(handlesBefore);
		click(By.linkText(category));
		deleteCategory(category);
	    setCensorKeywords("");
	}
	
	/*Case11: Get RSS of a category after move forum
	 * create new category1, forum1, topic1, post1, post2
	 * create new category2
	 * move forum1 to category 2
	 * get RSS of category1, that does not contains postes of forum2
	 * get RSS of category2, that contain posts of forum2
	 */
	@Test
	public void test11_GetRssCategory_MoveForum(){
		String category1 = "KS_Forum_OtherAction_RSS_cat_11_1";
		String forum = "KS_Forum_OtherAction_RSS_forum_11";
		String topic = "KS_Forum_OtherAction_RSS_topic_11";
		String post_content1 = "KS_Forum_OtherAction_RSS_post_11_1"; 
		String post_content2 = "KS_Forum_OtherAction_RSS_post_11_2";
		String fileName1 = "KS_Forum_OtherAction_RSS_MoveForum_SourceCategory_11";
		String topic_content = "KS_Forum_OtherAction_RSS_topic_content_11";
		String category2 = "KS_Forum_OtherAction_RSS_cat_11_2";
		String fileName2 = "KS_Forum_OtherAction_RSS_MoveForum_DestinationCategory_11";
		
		//create new category1, forum1, topic1, post1, post2
		makeTopicFromCategory(category1, forum, topic, topic_content);
		quickReply(post_content1, true);
		quickReply(post_content2, true);
		
		//create new category2
		jumpTo("Forum Home");
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category2, "1", 0, audience, category2, 0);
		
		//move forum1 to category2
		jumpTo("        " + forum);
		moveForum(forum, category2);
		jumpTo("Forum Home");
	    String handlesBefore = driver.getWindowHandle();
	    
	    //get RSS of category1
	    checkRSSNotContainTopic(category1, fileName1, topic, topic_content, post_content1, post_content2);
		
		//get RSS of category2
		driver.switchTo().window(handlesBefore);
		checkRSSFile(category2, category2, fileName2, topic, topic_content, post_content1, post_content2);
		driver.close();
		
		driver.switchTo().window(handlesBefore);
		click(By.linkText(category1));
		deleteCategory(category1);
		click(By.linkText(category2));
		deleteCategory(category2);
	}
	
	/*case12: Get RSS of a Forum after move topic
	 * create category1, forum1, topic, post1, post2
	 * create forum2 in category1
	 * move topic forum forum1 to forum2
	 * check RSS of forum1 and forum2
	 */
	@Test
	public void test12_GetRssForum_MoveTopic(){
		String category = "KS_Forum_OtherAction_RSS_cat_12";
		String forum1 = "KS_Forum_OtherAction_RSS_forum_12_1";
		String topic = "KS_Forum_OtherAction_RSS_topic_12";
		String post_content1 = "KS_Forum_OtherAction_RSS_post_12_1"; 
		String post_content2 = "KS_Forum_OtherAction_RSS_post_12_2";
		String fileName1 = "KS_Forum_OtherAction_RSS_MoveTopic_SourceForum_12";
		String topic_content = "KS_Forum_OtherAction_RSS_topic_content_12";
		String forum2 = "KS_Forum_OtherAction_RSS_Forum_12_2";
		String fileName2 = "KS_Forum_OtherAction_RSS_MoveTopic_DestinationForum_12";		
		
		//create new category1, forum1, topic1, post1, post2
		makeTopicFromCategory(category, forum1, topic, topic_content);
		quickReply(post_content1, true);
		quickReply(post_content2, true);
		
		//create new category2
		jumpTo("    " + category);
		goToAddForum();
		String[] add = {forum2, "1", "", "", forum2};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		
		//move topic1 to forum2
		jumpTo("Forum Home");
		click(By.linkText(topic));
		moveTopic(topic, forum2);
		jumpTo("    " + category);
	    String handlesBefore = driver.getWindowHandle();
	    
	    //get RSS of foeum1
	    checkRSSNotContainTopic(forum1, fileName1, topic, topic_content, post_content1, post_content2);
		
		//get RSS of forum2
		driver.switchTo().window(handlesBefore);
		jumpTo("    " + category);
		checkRSSFile(forum2, forum2, fileName2, topic, topic_content, post_content1, post_content2);
		driver.close();
		
		driver.switchTo().window(handlesBefore);
		deleteCategory(category);
	}
}
