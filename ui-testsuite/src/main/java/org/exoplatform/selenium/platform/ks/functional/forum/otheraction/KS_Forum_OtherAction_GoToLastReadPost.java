package org.exoplatform.selenium.platform.ks.functional.forum.otheraction;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import org.exoplatform.selenium.platform.ks.PostManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author HangNTT
 * @date: 21/12/2012
 */
public class KS_Forum_OtherAction_GoToLastReadPost extends PostManagement{
	
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		goToForums();
	}

	/*Case01: Check Go to last read post when Forum has topics that is read
	 * Check Last read post is shown
	 */
	@Test
	public void test01_CheckGoToLastReadPostWhenForumHasTopicsThatIsRead(){
		String category = "KS_Forum_cat_01";
		String forum = "KS_forum_01";
		String topic ="KS_Forum_topic_01"; 
		By VERIFY_LAST_READ_POST = By.xpath("//p[text()='"+topic+"']");
		By element_last_post = By.xpath(ELEMENT_GO_TO_THE_LASTS_READ_POST_FORUM.replace("${forum}", forum));

		makeTopicFromCategory(category, forum, topic);
		
		waitForTextPresent(topic);

		jumpTo("    " + category);
		
		click(element_last_post);

		waitForElementPresent(VERIFY_LAST_READ_POST);
		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	
	/*Case02: Check Go to last read post when Forum only contains unread post
	 * Check Last read post don't shown
	 */
	@Test
	public void test02_CheckGoToLastReadPostWhenForumOnlyContainsUnreadPost(){
		String category = "KS_Forum_cat_02";
		String forum = "KS_forum_02";
		String topic ="KS_Forum_topic_02"; 
		
		By element_last_post = By.xpath(ELEMENT_GO_TO_THE_LASTS_READ_POST_FORUM.replace("${forum}", forum));

		goToAddCategory();
		String[] audience = {};
		String[] user_cat = {};
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);

		//add new forum
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);

		//add new topic
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic);

		jumpTo("    "+ category);
		
		waitForElementNotPresent(element_last_post);
		
		//delete data
		deleteCategory(category);
	}
	
	/*Case03: Check Go to last read post when there is no topic in forum
	 * Check Last read post is shown
	 * Delete all post
	 */
	@Test
	public void test03_CheckGoToLastReadPostWhenThereIsNoTopicInForum(){
		String category = "KS_Forum_cat_03";
		String forum = "KS_forum_03";
		String topic ="KS_Forum_topic_03"; 

		By VERIFY_LAST_READ_POST = By.xpath("//p[text()='"+topic+"']");
		By element_last_post = By.xpath(ELEMENT_GO_TO_THE_LASTS_READ_POST_FORUM.replace("${forum}", forum));

		makeTopicFromCategory(category, forum, topic);

		jumpTo("    "+ category);

		click(element_last_post);

		waitForElementPresent(VERIFY_LAST_READ_POST);
		
		jumpTo("        " + forum);
		
		deleteAllTopic();
		
		jumpTo("    "+ category);
		
		waitForElementNotPresent(element_last_post);
		
		//delete data
		
		deleteCategory(category);
	}
	
	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
