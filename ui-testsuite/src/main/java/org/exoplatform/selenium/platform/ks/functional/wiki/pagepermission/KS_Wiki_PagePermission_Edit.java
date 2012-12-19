package org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission.KS_Wiki_PagePermission_Add.*;
import static org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission.KS_Wiki_PagePermission_Delete.*;

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
public class KS_Wiki_PagePermission_Edit extends Wiki {
	public static String ELEMENT_PERMISSION = "//*[@id='UIPermissionGrid']//*[contains(text(),'${user}')]";
	
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
	
	public static void checkOnlyViewPagePermission(String user, By element_page, String content){
		info("Check user can view page but does not have edit page");
		signIn(user, DATA_PASS_ADMIN);
		goToWiki();
		click(element_page);
		waitForTextPresent(content);
		waitForElementNotPresent(ELEMENT_EDIT_PAGE_LINK);
		signOut();
	}
	
	public static void addEditPagePermission(String user, By element_page){
		info("Add edit page permission for " + user);
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToWiki();
		click(element_page);
		editPagePermission(user, true, true);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		signOut();	
	}
	
	public static void removePagePermission(By element_page, String user){
		info("remove view/edit page permission");
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToWiki();
		click(element_page);
		editPagePermission(user, false, false);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		signOut();
	}
	
	public static void checkPermissionNotListed(String user){
		By element_permission = By.xpath(ELEMENT_PERMISSION.replace("${user}", user));
		
		info("Check user/group permission is not listed in page permission list");
		goToPagePermission();
		waitForElementNotPresent(element_permission);
		close();
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
	}
	
	/*case01: Edit permission when change value
	 * add page
	 * add user/group/memebership permission for page
	 * check user can view page but can not edit page (default)
	 * add edit page permission
	 * check user can edit page
	 * remove view/edit pege permission 
	 * check user can not see page
	 */
	@Test
	public void test01_EditPermissionWhenChangeValue_User(){
		String title = "KS_Wiki_PagePermission_Edit_Page_01_1";
		String content = "KS_Wiki_PagePermission_Edit_Page_Content_01_1";
		String new_content = "KS_Wiki_PagePermission_Edit_Page_Content_new_01_1";
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
		signOut();
		
		checkOnlyViewPagePermission(user, element_page, content);
		
		addEditPagePermission(user, element_page);
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut(); 
		
		removePagePermission(element_page, user);
		
		checkPermissionAfterDelete(user, element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	@Test
	public void test01_EditPermissionWhenChangeValue_Group(){
		String title = "KS_Wiki_PagePermission_Edit_Page_01_2";
		String content = "KS_Wiki_PagePermission_Edit_Page_Content_01_2";
		String new_content = "KS_Wiki_PagePermission_Edit_Page_Content_new_01_2";
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
		signOut();
		
		info("Check user James belong to group can view wiki page");
		checkOnlyViewPagePermission("james", element_page, content);
		
		addEditPagePermission(group, element_page);
		
		info("Check user can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut(); 
		
		removePagePermission(element_page, group);
		
		checkPermissionAfterDelete("james", element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	@Test
	public void test01_EditPermissionWhenChangeValue_Membership(){
		String title = "KS_Wiki_PagePermission_Edit_Page_01_3";
		String content = "KS_Wiki_PagePermission_Edit_Page_Content_01_3";
		String new_content = "KS_Wiki_PagePermission_Edit_Page_Content_new_01_3";
		By element_page = By.linkText(title);
		String group = "redactor:/platform/web-contributors";
		String[] userGroup = {"Platform/Content Management", "redactor"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(3, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		signOut();
		
		info("Check user James belong to group and has membership can view wiki page");
		checkOnlyViewPagePermission("james", element_page, content);
		
		addEditPagePermission(group, element_page);
		
		info("Check user can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut(); 
		
		removePagePermission(element_page, group);
		
		checkPermissionAfterDelete("james", element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/* case02: Edit permission when values are blank
	 * add page
	 * add page permission for user/group/membership
	 * remove view/edit page
	 * check user/group/membership permission is not listed in page permission list
	 */
	@Test
	public void test02_EditPermissionWhenValueBlank_User(){
		String title = "KS_Wiki_PagePermission_Edit_Page_02_1";
		String content = "KS_Wiki_PagePermission_Edit_Page_Content_02_1";
		String user = "demo";
		String[] userGroup = {user};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default");
		addPagePermission(1, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		editPagePermission(user, false, false);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		checkPermissionNotListed(user);
		
		//delete page
		deleteWikiPage();
	}
	
	@Test
	public void test02_EditPermissionWhenValueBlank_Group(){
		String title = "KS_Wiki_PagePermission_Edit_Page_02_2";
		String content = "KS_Wiki_PagePermission_Edit_Page_Content_02_2";
		String group = "*:/organization/management/human-resources";
		String[] userGroup = {"Organization/Management/Human Resources"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group has permission default");
		addPagePermission(2, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		editPagePermission(group, false, false);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		checkPermissionNotListed(group);
		
		//delete page
		deleteWikiPage();
	}
	
	@Test
	public void test02_EditPermissionWhenValueBlank_Membership(){
		String title = "KS_Wiki_PagePermission_Edit_Page_02_3";
		String content = "KS_Wiki_PagePermission_Edit_Page_Content_02_3";
		String group = "redactor:/platform/web-contributors";
		String[] userGroup = {"Platform/Content Management", "redactor"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add membership has permission default");
		addPagePermission(3, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		editPagePermission(group, false, false);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		checkPermissionNotListed(group);
		
		//delete page
		deleteWikiPage();
	}
}
