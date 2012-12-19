package org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission.KS_Wiki_PagePermission_Add.*;

import org.exoplatform.selenium.platform.ks.Wiki;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @date 18/12/2012
 * @author lientm
 *
 */
public class KS_Wiki_PagePermission_Delete extends Wiki{

	@BeforeMethod
	public void beforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);	
		goToWiki();
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	public static void deletePermissionWithUserAdmin(String user, By element_page){
		info("Delete page permission of user/group " + user);
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToWiki();
		click(element_page);
		deletePermission(user);
		signOut();
	}
	
	public static void checkPermissionAfterDelete(String user, By element_page){
		info("Check user/group " + user + " does not have view/edit page permission");
		signIn(user, DATA_PASS_ADMIN);
		goToWiki();
		waitForElementNotPresent(element_page);
		info("User/group can not view page");
		signOut();
	}
	
	/*case01: Delete permission
	 * Add page
	 * set view/edit page permission for user/group/membership
	 * delete permission
	 * check user can not view/edit page
	 */
	@Test
	public void test01_DeletePermission_User(){
		String title = "KS_Wiki_PagePermission_Delete_Page_01_1";
		String content = "KS_Wiki_PagePermission_Delete_Page_Content_01_1";
		String new_content = "KS_Wiki_PagePermission_Delete_Page_Content_new_01_1";
		By element_page = By.linkText(title);
		String user = "demo";
		String[] userGroup = {user};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(1, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Add edit page permission for " + user);
		checkPerDefaultAndAddEditPer(user);
		signOut();
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		deletePermissionWithUserAdmin(user, element_page);
		checkPermissionAfterDelete(user, element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	@Test
	public void test01_DeletePermission_Group(){
		String title = "KS_Wiki_PagePermission_Delete_Page_01_2";
		String content = "KS_Wiki_PagePermission_Delete_Page_Content_01_2";
		String new_content = "KS_Wiki_PagePermission_Delete_Page_Content_new_01_2";
		By element_page = By.linkText(title);
		String group = "*:/organization/management/human-resources";
		String[] userGroup = {"Organization/Management/Human Resources"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(2, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Add edit page permission for " + group);
		checkPerDefaultAndAddEditPer(group);
		signOut();
		
		info("Check user James belong to group can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		deletePermissionWithUserAdmin(group, element_page);
		checkPermissionAfterDelete("james", element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	@Test
	public void test01_DeletePermission_Membership(){
		String title = "KS_Wiki_PagePermission_Delete_Page_01_3";
		String content = "KS_Wiki_PagePermission_Delete_Page_Content_01_3";
		String new_content = "KS_Wiki_PagePermission_Delete_Page_Content_new_01_3";
		By element_page = By.linkText(title);
		String group = "redactor:/platform/web-contributors";
		String[] userGroup = {"Platform/Content Management", "redactor"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add membership has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(3, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Add edit page permission for " + group);
		checkPerDefaultAndAddEditPer(group);
		signOut();
		
		info("Check user James belong to group and has membership can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		deletePermissionWithUserAdmin(group, element_page);
		checkPermissionAfterDelete("james", element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
}
