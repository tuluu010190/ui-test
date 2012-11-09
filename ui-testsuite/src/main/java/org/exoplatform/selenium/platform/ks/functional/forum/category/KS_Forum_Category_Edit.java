package org.exoplatform.selenium.platform.ks.functional.forum.category;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ecms.EcmsBase.checkAlertWarning;
import static org.exoplatform.selenium.platform.ks.ForumManagement.addForum;
import static org.exoplatform.selenium.platform.ks.ForumManagement.goToAddForum;

import java.util.Set;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.exoplatform.selenium.platform.ks.ForumManageCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author lientm
 * @date 6/12/2012
 */
public class KS_Forum_Category_Edit extends ForumManageCategory {

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
	
	/**
	 * function delete category with login with user John -> use for only this class
	 * @param category
	 */
	public static void deleteCategoryWithJohn(String category){
		By element_category = By.linkText(category);
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		deleteCategory(category);
	}
	
	/*case06: Edit Category with blank Restricted audience
	 * edit a category set Restricted audience blank
	 * check any user can access this category
	 */
	@Test
	public void test06_EditCategory_RemoveRestrictedAudience(){
		String category = "KS_Forum_Category_Edit_cat_06";
		By element_category = By.linkText(category);
		
		//add new category has restricted audience
		goToAddCategory();
		String[] audience = {"mary"};
		addCategoryInForum(category, "1", 1, audience, "", 0);
		signOut();
		
		//check user james can not access this category
		signIn("james", "gtn");
		goToForums();
		waitForElementNotPresent(element_category);
		signOut();
		
		//edit category, set Restricted audience blank
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		String[] userGroup = {""};
		editCategory(null, null, 1, userGroup, null, 0);
		waitForElementNotPresent(ELEMENT_ALERT);
		waitForElementNotPresent(ELEMENT_POPUP_ADD_CATEGORY);
		info("Edit category successfully");
		signOut();
		
		//check user james can access this category
		signIn("james", "gtn");
		goToForums();
		click(element_category);
		info("any user can access this category");
		signOut();
		
		//delete data
		deleteCategoryWithJohn(category);
	}
	
	/*Case07: Edit Category in case invalid user entry for Restricted audience field
	 * create new category
	 * edit category, set invalid (unavailable) user(s)/membership(s)/group(s) into  'Restricted audience' field
	 * check message
	 */
	@Test
	public void test07_EditCategory_InvalidRestrictedAudience(){
		String category = "KS_Forum_Category_Edit_cat_07";
		String audience_invalid = "ana, /development, autho:/developers";
		
		//add new category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		//set invalid (unavailable) user(s)/membership(s)/group(s) into  'Restricted audience' field
		String[] audi = {audience_invalid};
		editCategory(null, null, 1, audi, null, 0);
		checkAlertWarning("The field \"Restricted Audience\" is invalid: " + audience_invalid);     
		info("Can not edit category when restricted audience field invalid");
		cancel();
		
		//delete data
		deleteCategory(category);
	}
	
	/*case08: Edit Category in case valid data entry for Restricted audience field
	 * create new category
	 * edit category with valid data entry for Restricted audience field
	 * check user in Restricted audience can access this category
	 */
	@Test
	public void test08_EditCategory_ValidRestrictedAudience(){
		String category = "KS_Forum_Category_Edit_cat_08";
		By element_category = By.linkText(category);
		String[] audience_invalid = {"james,*:/platform/administrators,/platform/administrators"};
		
		//add new category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		//edit category with valid data entry for Restricted audience field
		editCategory(null, null, 1, audience_invalid, null, 0);
		waitForElementNotPresent(ELEMENT_ALERT);
		waitForElementNotPresent(ELEMENT_POPUP_ADD_CATEGORY);
		info("Edit category successfully");
		signOut();
		
		//check user james can access this category
		signIn("james", "gtn");
		goToForums();
		click(element_category);
		info("user james can access this category");
		signOut();
		
		//check user demo can access this category
		signIn("demo", "gtn");
		goToForums();
		waitForElementNotPresent(element_category);
		info("User demo can not access this category");
		signOut();
		
		//delete data
		deleteCategoryWithJohn(category);
	}
	
	/*case09: Edit Category with blank Moderator
	 * create new category has moderator, create forum
	 * edit category, set moderator blank
	 * check edit successfully
	 */
	@Test
	public void test09_EditCategory_NoModerator(){
		String category = "KS_Forum_Category_Edit_cat_09";
		String forum = "KS_Forum_Category_Edit_forum_09";
		By element_forum = By.linkText(forum);
		
		//add new category
		goToAddCategory();
		String[] audience = {};
		String[] user_cat = {"mary"};
		addCategoryInForum(category, "1", 0, audience, "", 1, user_cat);
		
		//add new forum
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		waitForTextNotPresent("No Moderator");
		
		//edit category, set moderator blank
		jumpTo("    "+ category);
		goToEditCategory();
		click(ELEMENT_PERMISSION_TAB);
		String[] moderator = {""};
		ForumBase.setPermissionWithOption(ELEMENT_MODERATORS, 1, moderator);
		save();
		waitForElementNotPresent(ELEMENT_ALERT);
		waitForElementNotPresent(ELEMENT_POPUP_ADD_CATEGORY);
		click(element_forum);
		waitForTextPresent("No Moderator");
		info("Edit category with blank moderator successfully");
		
		//delete category
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	
	/*case10: Edit Category in case invalid user entry for Moderator field
	 * create new category
	 * edit category with invalid user entry for moderator field
	 * check message
	 */
	@Test
	public void test10_EditCategory_InvalidModerator(){
		String category = "KS_Forum_Category_Edit_cat_10";
		String moderator_invalid = "ana, /development, autho:/developers";
		
		//add new category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		//edit category with invalid user entry for moderator field
		goToEditCategory();
		click(ELEMENT_PERMISSION_TAB);
		String[] moderator = {moderator_invalid};
		ForumBase.setPermissionWithOption(ELEMENT_MODERATORS, 1, moderator);
		save();
		checkAlertWarning("The field \"Moderators\" is invalid: " + moderator_invalid);
		info("Can not edit category with invalid user entry for moderator field");
		cancel();
		
		//delete data
		deleteCategory(category);		
	}
	
	/*case 11: Edit Category in case valid user entry for Moderator field
	 * create new category, forum
	 * edit category with valid moderator field
	 * check forum has moderator
	 */
	@Test
	public void test11_EditCategory_ValidModerator(){
		String category = "KS_Forum_Category_Edit_cat_11";
		String forum = "KS_Forum_Category_Edit_forum_11";
		By element_forum = By.linkText(forum);
		String[] moderator = {"mary,*:/platform/administrators,/platform/administrators"};//include 3 user: root, john, mary
		
		//add new category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		//add new forum
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		
		//edit category
		jumpTo("    "+ category);
		goToEditCategory();
		click(ELEMENT_PERMISSION_TAB);
		ForumBase.setPermissionWithOption(ELEMENT_MODERATORS, 1, moderator);
		save();
		waitForElementNotPresent(ELEMENT_POPUP_ADD_CATEGORY);
		waitForElementNotPresent(ELEMENT_ALERT);
		
		//check user moderator in forum
		click(element_forum);
		waitForTextPresent("Root Root");
		waitForTextPresent("John Smith");
		waitForTextPresent("Mary Williams");
		
		//delete category
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	
	/*case12: Edit category which deleted by another user
	 * create new category, forum with user John
	 * delete this category with user root
	 * check user John can note edit this category
	 */
	@Test
	public void test12_EditCategoryWhichDeletedByAnotherUser(){
		String category = "KS_Forum_Category_Edit_cat_12";
		By element_category = By.linkText(category);
		String forum = "KS_Forum_Category_Edit_forum_12";
		
		//add new category
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		
		//add new forum
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		jumpTo("    "+ category);
		
		//Get cookies of current browser then delete all cookies
	    Set<Cookie> cookies = driver.manage().getCookies();
	    driver.manage().deleteAllCookies();
	    String handlesBefore = driver.getWindowHandle();
	    
	    //open new window and log in with root
	    ((JavascriptExecutor) driver).executeScript("window.open()");
	    for(String winHandle : driver.getWindowHandles()){
	    	driver.switchTo().window(winHandle);
	    }
	    driver.navigate().to(baseUrl);
	    signIn("root", "gtn");
	    goToForums();
	    click(element_category);
		waitForElementPresent(ELEMENT_MANAGE_CATEGORY);
		click(ELEMENT_MANAGE_CATEGORY);
		click(ELEMENT_DELETE_CATEGORY);
		acceptAlert();
		info("Delete category successfully");
	    
	    //back to old window to edit category
	    driver.manage().deleteAllCookies();
	    for(Cookie cookie : cookies){
	        driver.manage().addCookie(cookie);
	      }
	    driver.switchTo().window(handlesBefore); 
	    goToEditCategory();
	    save();
	    checkAlertWarning("This category no longer exists.");
	    info("Can not edit a category which deleted by another user");
	}
}
