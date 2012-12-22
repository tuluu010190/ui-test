package org.exoplatform.selenium.platform.ks.functional.forum.otheraction;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.Test;

/**
 * 
 * @author HangNTT
 * @date: 21/12/2012
 * modify: 27/12/2012 (@author lientm)
 */
public class KS_Forum_OtherAction_AdvanceSearch extends ForumBase {
	
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		goToForums();
	}
	
	@Test
	public void test08_AdvanceSearch_Category_TypeModerator(){

		String category = "KS_Forum_Show_Category_cat_01_008";
		String forum = "KS_Forum_Show_Category_forum_01_008";
		String topic = "KS_Forum_Show_Category_topic_01_008";
		String[] audience = {};
		
		info("Create new category, forum, topic");
		
		makeTopicFromCategory(category, forum, topic);

		jumpTo("    " + category);
		waitForTextPresent(forum);
		
		editCategory(category, "1", 0, audience, "", 1, "john");
		
		assert advancedSearch(true, "","","","","","john" );
		
		waitForTextPresent(category);
		
		deleteSomeCategory(category);
	}
	
	//Category Advance Search by moderator when select moderator from list
	@Test
	public void test09_AdvancedSearch_Category_SelectModeratorFormList(){

		String category1 = "KS_Forum_Show_Category_cat_01_009";
		String forum1 = "KS_Forum_Show_Category_forum_01_009";
		String topic1 = "KS_Forum_Show_Category_topic_01_009";		
		String category2 = "KS_Forum_Show_Category_cat_02_009";
		String forum2 = "KS_Forum_Show_Category_forum_02_009";
		String topic2 = "KS_Forum_Show_Category_topic_02_009";
		String[] audience = {};
		
		info("Create new category, forum, topic");
		
		makeTopicFromCategory(category1, forum1, topic1);
		
		goToForumHome();
		
		makeTopicFromCategory(category2, forum2, topic2);
		
		jumpTo("    " + category1);
		waitForTextPresent(forum1);
		
		editCategory(category1, "1", 0, audience, "", 1, "john");
		
		assert advancedSearch(true, "","","","","","","john" );
		
		waitForTextPresent(category1);
		
		deleteSomeCategory(category1, category2);
	}
	
	//Category Advance Search by moderator when select moderator in Forum
	@Test
	public void test26_AdvancedSearch_Forum_SelectModeratorInForum(){
		String category1 = "KS_Forum_Show_Category_cat_01_010";
		String forum1 = "KS_Forum_Show_Category_forum_01_010";
		String topic1 = "KS_Forum_Show_Category_topic_01_010";			
		String category2 = "KS_Forum_Show_Category_cat_02_010";
		String forum2 = "KS_Forum_Show_Category_forum_02_010";
		String topic2 = "KS_Forum_Show_Category_topic_02_010";

		String[] audience = {};
		
		info("Create new category, forum, topic");	
		makeTopicFromCategory(category1, forum1, topic1);	
		goToForumHome();
	
		makeTopicFromCategory(category2, forum2, topic2);	
		jumpTo("    " + category1);
		waitForTextPresent(forum1);
		
		editCategory(category1, "1", 0, audience, "", 1, "john");
		
		assert advancedSearch(true, "","Forum","","","","","john" );
		waitForTextPresent(forum1);
		
		goToForumHome();
		deleteSomeCategory(category1, category2);
	}

	//Do Advanced Search with content of attachment in post
	@Test
	public void test64_AdvancedSearch_ContetnOfAttachmentInPost(){

		String category = "KS_Forum_Show_Category_cat_01_064";
		String forum = "KS_Forum_Show_Category_forum_01_064";
		String topic = "KS_Forum_Show_Category_topic_01_064";
		String post = "KS_Forum_Show_Category_post_01_064";
		String message = "KS_Forum_Show_Category_message_01_064";
		String ATTACHMENT_PATH="TestData/test.txt";

		info("Create new category, forum, topic");
		makeTopicFromCategory(category, forum, topic);

		postReply(post, message,null,null, ATTACHMENT_PATH);

		assert advancedSearch(true,message,"Post","","","","" );
		waitForTextPresent(post);

		goToForumHome();
		deleteSomeCategory(category);
	}
	
	//Category advanced search  when Scoped in case keyword matched with properties of showing category
	@Test
	public void test59_AdvancedSearch_MatchedShowingCategory(){

		String category = "KS_Forum_Show_Category_cat_01_059";
		String category1 = "KS_Forum_Show_Category_cat_02_059";
		String category2 = "KS_Forum_Show_Category_cat_03_059";
		By element_category = By.linkText(category);
		By element_category1 = By.linkText(category1);
		By element_category2 = By.linkText(category2);
		
		//Create 3 new categories
		add3CategoriesAndCheck(category, category1, category2);

		settingForumPortletSelectDisplay(category, true, false);

		// Check after hiding category
		waitForElementNotPresent(element_category);
		waitForElementPresent(element_category1);
		waitForElementPresent(element_category2);

		assert advancedSearch(true,category1,"Category","","","","" );
		waitForElementPresent(element_category1);

		//reset data
		settingForumPortletSelectDisplay(category, true, true);
		deleteSomeCategory(category, category1, category2);
	}

	//Category advanced search  when Scoped in case keyword matched with properties of hiding category
	@Test
	public void test60_AdvancedSearch_MatchedHidingCategory(){

		String category = "KS_Forum_Show_Category_cat_01_060";
		String category1 = "KS_Forum_Show_Category_cat_02_060";
		String category2 = "KS_Forum_Show_Category_cat_03_060";

		By element_category = By.linkText(category);
		By element_category1 = By.linkText(category1);
		By element_category2 = By.linkText(category2);

		//Create 3 new categories
		add3CategoriesAndCheck(category, category1, category2);

		settingForumPortletSelectDisplay(category, true, false);

		// Check after hiding category
		waitForElementNotPresent(element_category);
		waitForElementPresent(element_category1);
		waitForElementPresent(element_category2);

		assert !advancedSearch(true,category,"Category","","","","" );

		//reset data
		settingForumPortletSelectDisplay(category, true, true);
		deleteSomeCategory(category, category1, category2);
	}

	//Forum advanced search  when Scoped in case keyword matched with properties of showing forum
	@Test
	public void test61_AdvancedSearch_MatchedShowingForum(){

		String category = "KS_Forum_Show_Category_cat_01_061";
		String category1 = "KS_Forum_Show_Category_cat_02_061";
		String forum1 = "KS_Forum_Show_Category_forum_01_061";
		String forum2 = "KS_Forum_Show_Category_forum_02_061";
		By element_forum1 = By.linkText(forum1);
		By element_forum2 = By.linkText(forum2);
		
		//add 2 categories and 2 forums
		add2CategoriesAnd2Forums(category, forum1, category1, forum2);

		//hide forum1
		settingForumPortletSelectDisplay(forum1, false, false);

		//Check user can not see forum1
		waitForElementNotPresent(element_forum1);
		waitForElementPresent(element_forum2);

		//check user can search forum2
		assert advancedSearch(true,forum2,"Forum","","","","" );
		waitForElementPresent(element_forum2);

		//reset data
		goToForumHome();
		deleteSomeCategory(category, category1);
	}

	//Forum advanced search  when Scoped in case keyword matched with properties of hiding forum
	@Test
	public void test62_AdvancedSearch_MatchedHigingForum(){

		String category = "KS_Forum_Show_Category_cat_01_062";
		String category1 = "KS_Forum_Show_Category_cat_02_062";
		String forum1 = "KS_Forum_Show_Category_forum_01_062";
		String forum2 = "KS_Forum_Show_Category_forum_02_062";
		By element_forum1 = By.linkText(forum1);
		By element_forum2 = By.linkText(forum2);

		//add 2 categories and 2 forums
		add2CategoriesAnd2Forums(category, forum1, category1, forum2);

		settingForumPortletSelectDisplay(forum1, false, false);

		//Check user can not see forum1
		waitForElementNotPresent(element_forum1);
		waitForElementPresent(element_forum2);
		
		//check user can not search forum1
		assert !advancedSearch(true,forum1,"Forum","","","","" );

		//reset data		
		goToForumHome();
		deleteSomeCategory(category, category1);
	} 

	public static void add3CategoriesAndCheck(String category, String category1, String category2){
		By element_category = By.linkText(category);
		By element_category1 = By.linkText(category1);
		By element_category2 = By.linkText(category2);
		String[] audience = {};
		String[] user_cat = {};
		
		info("Create 3 new categories");
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);
		goToForumHome();
		addCategoryInForum(category1, "1", 0, audience, "", 0, user_cat);
		goToForumHome();
		addCategoryInForum(category2, "1", 0, audience, "", 0, user_cat);

		// Check before hiding category
		goToForumHome();
		waitForElementPresent(element_category);
		waitForElementPresent(element_category1);
		waitForElementPresent(element_category2);
	}
	
	public static void add2CategoriesAnd2Forums(String category, String forum1, String category1, String forum2){
		String[] audience = {};
		String[] user_cat = {};
		String[] add1 = {forum1, "1", "", "", ""};
		String[] add2 = {forum2, "1", "", "", ""};
		String[] userGroup = {};

		//add new category and forum1
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);
		addForum(category, add1, 0, userGroup, true, "", "", false, 0);

		//add new category1 and forum2
		goToForumHome();
		addCategoryInForum(category1, "1", 0, audience, "", 0, user_cat);
		addForum(category1, add2, 0, userGroup, true, "", "", false, 0);
	}
	
	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}