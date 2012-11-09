package org.exoplatform.selenium.platform.ks.functional.forum.category;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
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
public class KS_Forum_Category_Delete extends ForumManageCategory {
	
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
	
	/*case01: Delete Category
	 * create new category
	 * check user normal can not delete this category
	 * check legal user can delete this category (user admin)
	 */
	@Test
	public void test01_DeleteCategory(){
		String category = "KS_Forum_Category_Delete_cat_06";
		By element_category = By.linkText(category);
		
		//add new category has restricted audience
		goToAddCategory();
		String[] audience = {};
		addCategoryInForum(category, "1", 0, audience, "", 0);
		signOut();
		
		//check user normal can not delete this category
		signIn("demo", "gtn");
		goToForums();
		click(element_category);
		waitForElementNotPresent(ELEMENT_MANAGE_CATEGORY);
		info("Normal user can not delete category");
		signOut();
		
		//check legal user can delete this category (user admin)
		signIn("john", "gtn");
		goToForums();
		click(element_category);
		deleteCategory(category);
	}
}
