package org.exoplatform.selenium.platform.ks.functional.forum.category;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;

import org.exoplatform.selenium.platform.ks.ForumManageCategory;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author lientm
 * @date 07/12/2012
 */
public class KS_Forum_Category_Export extends ForumManageCategory {
	
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
	
	/*case03: Export categories in case Export mode is "Only categories"
	 * create new category, forum, topic
	 * export category in Only Categories mode
	 * check export successfully
	 */
	@Test
	public void test03_ExportCategoryInOnlyCategoriesMode(){
		String category = "KS_Forum_Category_Export_cat_03";
		String forum = "KS_Forum_Category_Export_forum_03";
		String topic ="KS_Forum_Category_Export_topic_03";
		String post_content = "KS_Forum_Category_Export_post_03"; 
		String fileName = "KS_Forum_Category_Export_cat_03";
		
		//create new category, forum, topic, post
		makeTopicFromCategory(category, forum, topic);
		quickReply(post_content);
		waitForTextPresent(post_content);
		
		//export category
		exportCategory(fileName, false, category);
		
		//check export successfully
		assert checkFileExisted(category + ".zip"): "Not found export file";
		info("Export file successfully");
		
		//delete category
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	
	/*case04: Export categories in case Export mode is "Export all"
	 * create new category, forum, topic
	 * export category in "Export all" mode
	 * check export successfully
	 */
	@Test
	public void test04_ExportCategoryInExportAllMode(){
		String category = "KS_Forum_Category_Export_cat_04";
		String forum = "KS_Forum_Category_Export_forum_04";
		String topic ="KS_Forum_Category_Export_topic_04";
		String post_content = "KS_Forum_Category_Export_post_04"; 
		String fileName = "KS_Forum_Category_Export_cat_04";
		
		//create new category, forum, topic, post
		makeTopicFromCategory(category, forum, topic);
		quickReply(post_content);
		waitForTextPresent(post_content);
		
		//export category
		exportCategory(fileName, true, category);
		
		//check export successfully
		assert checkFileExisted(category + ".zip"): "Not found export file";
		info("Export file successfully");
		
		//delete category
		jumpTo("    "+ category);
		deleteCategory(category);
	}
}
