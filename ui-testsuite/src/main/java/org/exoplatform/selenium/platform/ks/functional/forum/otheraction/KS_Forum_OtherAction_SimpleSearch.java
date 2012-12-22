package org.exoplatform.selenium.platform.ks.functional.forum.otheraction;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ks.functional.forum.otheraction.KS_Forum_OtherAction_AdvanceSearch.add2CategoriesAnd2Forums;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author HangNTT
 * @date: 21/12/2012
 * modify: 27/12/2012 (@author lientm)
 */
public class KS_Forum_OtherAction_SimpleSearch extends ForumBase{
	
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		goToForums();
	}
	
	/*Case01: Do Simple Search with Category  when Scoped in case keyword matched with properties of showing category
	 * All showing categories has property matching with search keyword is listed in search result form
	 */
	@Test
	public void test01_SearchCategory_KeywordMatched_ShowingCategory(){
		String category1 = "KS_Forum_cat_01_showing_category";
		String category2 = "KS_Forum_cat_02_showing_category";

		By element_category1 = By.linkText(category1);
		By element_category2 = By.linkText(category2);
		
		//add 2 categories
		add2Categories(category1, category2);

		//Select category to show in edit mode
		settingForumPortletSelectDisplay(category1, true, false);
		
		//Check user can not see category1
		waitForElementNotPresent(element_category1);
		waitForElementPresent(element_category2);
		
		//check user can search category2
		assert simpleSearch(category2);		
		waitForTextPresent(category2);
		
		//reset data	
		goToForumHome();
		deleteSomeCategory(category2);	
		settingForumPortletSelectDisplay(category1, true, false);
		deleteSomeCategory(category1);
	}
	
	/*Case02: Do Simple Search with Category  when Scoped in case keyword matched with properties of hiding category
	 * In Search result form: show note “No match” and haven't any category in list
	 */
	@Test
	public void test02_SearchCategory_KeywordMatched_HidingCategory(){
		String category1 = "KS_Forum_simplesearch_cat_01_hiding_category";
		String category2 = "KS_Forum_simplesearch_cat_02_hiding_category";

		By element_category1 = By.linkText(category1);
		By element_category2 = By.linkText(category2);
		
		//add 2 categories
		add2Categories(category1, category2);

		//Select category to show in edit mode
		settingForumPortletSelectDisplay(category1, true, false);
		
		//Check user can not see category1
		waitForElementNotPresent(element_category1);
		waitForElementPresent(element_category2);
		assert !simpleSearch(category1);
		
		//reset data	
		goToForumHome();
		deleteSomeCategory(category2);	
		settingForumPortletSelectDisplay(category1, true, false);
		deleteSomeCategory(category1);
	}
	
	/*Case03: Do Simple Search with Forum  when Scoped in case keyword matched with properties of showing Forum
	 * All showing forum has property matching with search keyword is listed in search result form
	 */
	@Test
	public void test03_SearchForum_KeywordMatched_ShowingForum(){
		String category1 = "KS_Forum_cat_01_search_showing_forum";
		String category2 = "KS_Forum_cat_02_search_showing_form";
		
		String forum1 = "KS_forum_01";
		String forum2 = "KS_forum_02";
		
		By element_forum1 = By.linkText(forum1);
		By element_forum2 = By.linkText(forum2);
		
		//add 2 categories and 2 forums
		add2CategoriesAnd2Forums(category1, forum1, category2, forum2);

		//Select forum to show in edit mode
		settingForumPortletSelectDisplay(forum1, false, false);
		
		//Check user can see forum2
		waitForElementNotPresent(element_forum1);
		waitForElementPresent(element_forum2);
		assert simpleSearch(forum2);
		
		waitForTextPresent(forum2);
		
		//Back to home		
		goToForumHome();
		deleteSomeCategory(category1, category2);
	}
	
	/*Case04: Do Simple Search with Forum  when Scoped in case keyword matched with properties of hidding Forum
	 * All showing forum has property matching with search keyword is listed in search result form
	 */
	@Test
	public void test04_SearchForum_KeywordMatched_HiddingForum(){
		String category1 = "KS_Forum_cat_01_search_hiding_forum";
		String category2 = "KS_Forum_cat_02_search_hiding_forum";
		String forum1 = "KS_forum_01";
		String forum2 = "KS_forum_02";
		By element_forum1 = By.linkText(forum1);
		By element_forum2 = By.linkText(forum2);
		
		//add 2 categories and 2 forums
		add2CategoriesAnd2Forums(category1, forum1, category2, forum2);

		//Select forum to show in edit mode

		settingForumPortletSelectDisplay(forum1, false, false);
		
		//Check user can not see forum1
		waitForElementNotPresent(element_forum1);
		waitForElementPresent(element_forum2);
		assert !simpleSearch(forum1);	
		
		//Back to home		
		goToForumHome();
		deleteSomeCategory(category1, category2);
	}
	
	public static void add2Categories(String category1, String category2){
		String[] audience = {};
		String[] user_cat = {};

		info("Add 2 new categories");
		addCategoryInForum(category1, "1", 0, audience, "", 0, user_cat);
		goToForumHome();
		addCategoryInForum(category2, "1", 0, audience, "", 0, user_cat);
	}
	
	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
