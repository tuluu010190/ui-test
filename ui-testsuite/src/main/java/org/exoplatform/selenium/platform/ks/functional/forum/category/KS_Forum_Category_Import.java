package org.exoplatform.selenium.platform.ks.functional.forum.category;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.ForumManagement.addForum;
import static org.exoplatform.selenium.platform.ks.ForumManagement.goToAddForum;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ks.ForumManageCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author lientm
 * @date 07/12/2012
 */
public class KS_Forum_Category_Import extends ForumManageCategory {

	@BeforeMethod
	public void beforeTest(){
		getDriverAutoSave();
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
	
	public static void rollbackData(String category, String bbCodeTag, String banIp){
		//delete category
		info("Delete category");
		jumpTo("    "+ category);
		deleteCategory(category);
		
		//roll back banIp, BBCode, user profile
		info("Delete bbCode, BanIp, user profile");
		goToBBCodeManagement();
		deleteBBcode(bbCodeTag, false);
		close();		
		deleteBanIp(banIp);		
		settingProfileUser(null, "", false);
	}
	
	public static void doSomeMainAction(String category, String forum1, String topic1, String post1 ){
		//add new forum
		goToAddForum();
		String[] add = {forum1, "1", "", "", ""};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);
		
		//add new topic
		String[] user_topic = {};
		startTopic(topic1, topic1, "", "", "", "", "", "", 0, user_topic);
		click(By.linkText(topic1));
		
		//add post
		quickReply(post1);
		waitForTextPresent(post1);
	}
	
	/*case01: Import category in case file import contains category exported with mode is "Export all"
	 * create new category, forum, topic, post, BanIp, BBCode, Tag, user profile
	 * export category in Export all mode
	 * delete category and rollback banIp, BBCode, user profile
	 * import category
	 * check import
	 * pending -> refer feedback KS-4700
	 */
	@Test(groups = {"pending"})
	public void test01_ImportCategoryInFileImportInExportAllMode(){
		String category = "KS_Forum_Category_Import_cat_01";
		String forum = "KS_Forum_Category_Import_forum_01";
		String topic ="KS_Forum_Category_Import_topic_01";
		String post_content = "KS_Forum_Category_Import_post_01";
		String tagName = "KSImporttag01";
		String bbCodeTag = "IMPORT_BBTAG_01";
		String replace = "<tag>{replace}</tag>";
		String description = "TAG_01";
		String example = "<tag>{replace}</tag>";
		String banIp = "192.168.1.27";
		String fileName = "KS_Forum_Category_Import_01";
		String sign = "John Smith";		
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		String forum1 = "KS_Forum_Category_Import_forum_01_1";
		String topic1 ="KS_Forum_Category_Import_topic_01_1";
		String post1 = "KS_Forum_Category_Import_post_01_1";
		
		//create new category, forum, topic, post
		makeTopicFromCategory(category, forum, topic);
		quickReply(post_content);
		waitForTextPresent(post_content);
		
		//add tag
		addTagForTopic(tagName);
		
		//add BBCode
		goToBBCodeManagement();
		addBBCode(bbCodeTag, replace, description, example, false);
		close();
		
		//add BanIP
		setBanIp(banIp);
		
		//set user profile
		settingProfileUser(null, sign, true);
		
		//export category in "Export all mode"
		exportCategory(fileName, true, category);
		
		//delete data
		rollbackData(category, bbCodeTag, banIp);
		
		//import file
		importCategory("TestData/TestOutput/" + fileName + ".zip");
		
		//check import category, forum, topic, post, tag successfully
		waitForElementPresent(element_category);
		click(element_category);
		waitForElementPresent(element_forum);
		click(element_forum);
		waitForElementPresent(element_topic);
		click(element_topic);
		waitForTextPresent(post_content);
		waitForTextPresent(tagName);
		
		//check import BBCode, BanIP, userProfile successfully
		goToBBCodeManagement();
		waitForTextPresent(bbCodeTag);
		close();
		goToBanIp();
		waitForTextPresent(banIp);
		close();
		goToSetting();
		assert getText(ELEMENT_SIGNATURE).contains(sign):"Import user profile error";
		info("Import category successfully");
		
		//do some main action on the imported categories
		jumpTo("    "+ category);
		doSomeMainAction(category, forum1, topic1, post1);
		
		//delete data
		rollbackData(category, bbCodeTag, banIp);
	}
	
	/*case02: Import category in case file import contains category exported with mode is "Only category"
	 * create new category, forum, topic, post
	 * export this category in Only category mode
	 * delete category
	 * import category
	 * check import
	 * pending -> refer feedback KS-4700
	 */
	@Test(groups = {"pending"})
	public void test02_ImportCategoryInFileImportInExportOnlyCategoryMode(){
		String category = "KS_Forum_Category_Import_cat_02";
		String forum = "KS_Forum_Category_Import_forum_02";
		String topic ="KS_Forum_Category_Import_topic_02";
		String post_content = "KS_Forum_Category_Import_post_02";
		String fileName = "KS_Forum_Category_Import_02";
		By element_category = By.linkText(category);
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		String forum1 = "KS_Forum_Category_Import_forum_02_1";
		String topic1 ="KS_Forum_Category_Import_topic_02_1";
		String post1 = "KS_Forum_Category_Import_post_02_1";
		
		//create new category, forum, topic, post
		makeTopicFromCategory(category, forum, topic);
		quickReply(post_content);
		waitForTextPresent(post_content);
		
		//export category in "Only category mode"
		exportCategory(fileName, false, category);
		
		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
		
		//import category
		importCategory("TestData/TestOutput/" + fileName + ".zip");
		
		//check import category, forum, topic, post successfully
		waitForElementPresent(element_category);
		click(element_category);
		waitForElementPresent(element_forum);
		click(element_forum);
		waitForElementPresent(element_topic);
		click(element_topic);
		waitForTextPresent(post_content);
		
		//do some main actions
		doSomeMainAction(category, forum1, topic1, post1);
		
		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
}
