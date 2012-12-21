package org.exoplatform.selenium.platform.ks.functional.forum.forum;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.NavigationToolbar.goToEditPageEditor;
import static org.exoplatform.selenium.platform.ks.functional.forum.forum.KS_Forum_Forum_PortletSetting_EnableDisablePanel.deleteCategoryWithJohn;

import org.exoplatform.selenium.platform.ks.ForumManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KS_Forum_Forum_PortletSetting_ShowHire_Forum extends ForumManagement {
	
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
	
	/*case01: Hire/Show Forum of category which showing in Forum portlet settings
	 * create new category, forum
	 * hire forum
	 * check user can not see forum
	 * show forum
	 * check user can see forum
	 */
	@Test
	public void test01_02_HireShowForum_ShowingCategory(){
		String category = "KS_Forum_Show_Forum_cat_01_02";
		String forum = "KS_Forum_Show_Forum_forum_01_02";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		
		info("Create new category, forum");
		//add new category
		goToAddCategory();
		String[] audience = {};
		String[] user_cat = {};
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);

		//add new forum
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		
		info("set hire forum " + forum);
		settingForumPortletSelectDisplay(forum, false, false);
		signOut();
		
		info("Check user demo can see category, not see forum");
		signIn("demo", "gtn");
		goToForums();
		waitForElementPresent(element_category);
		waitForElementNotPresent(element_forum);
		signOut();
		
		info("Set show forum " + forum);
		signIn("john", "gtn");
		goToForums();
		settingForumPortletSelectDisplay(forum, false, true);
		signOut();
		
		info("Check user demo can see category, forum");
		signIn("demo", "gtn");
		goToForums();
		waitForElementPresent(element_category);
		waitForElementPresent(element_forum);
		signOut();
		
		info("Delete data");
		deleteCategoryWithJohn(category, element_category);
	}
	
	/*Case03: Show the hidden forum of category which hiding in Forum portlet settings
	 * add category, forum
	 * hire category
	 * check user can not see category
	 * show forum
	 * check category is showed, too
	 * hire forum
	 * check user can not see forum
	 */
	@Test
	public void test03_ShowHiddenForum_HiddingCategory(){
		String category = "KS_Forum_Show_Forum_cat_03";
		String forum = "KS_Forum_Show_Forum_forum_03";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By category_checkbox = By.xpath("//*[text()='" + category + "']/../../../*[@class='ParentCheckBox']/input");
		
		info("Create new category, forum");
		//add new category
		goToAddCategory();
		String[] audience = {};
		String[] user_cat = {};
		addCategoryInForum(category, "1", 0, audience, "", 0, user_cat);

		//add new forum
		goToAddForum();
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		
		info("set hire category " + category);
		settingForumPortletSelectDisplay(category, true, false);
		signOut();
		
		info("Check user demo can not see category, forum");
		signIn("demo", "gtn");
		goToForums();
		waitForElementNotPresent(element_category);
		waitForElementNotPresent(element_forum);
		signOut();
		
		info("Set show forum " + forum);
		signIn("john", "gtn");
		goToForums();
		goToEditPageEditor();
		goToEditForumPortlet();
		selectDisplayCategoryAndForum(forum, false, true);
		info("Category is checked, too");
		assert waitForAndGetElement(category_checkbox).isSelected();
		
		info("Uncheck forum");
		selectDisplayCategoryAndForum(forum, false, false);
		saveForumPortletSetting();
		signOut();
		
		info("Check user demo can see category, not see forum");
		signIn("demo", "gtn");
		goToForums();
		waitForElementPresent(element_category);
		waitForElementNotPresent(element_forum);
		signOut();
		
		info("Delete data");
		deleteCategoryWithJohn(category, element_category);
	}
}
