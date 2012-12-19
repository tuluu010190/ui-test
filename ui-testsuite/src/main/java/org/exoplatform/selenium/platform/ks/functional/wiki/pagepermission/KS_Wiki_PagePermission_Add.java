package org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ks.Wiki;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @date 17/12/2012
 * @author lientm
 *
 */
public class KS_Wiki_PagePermission_Add extends Wiki {
	
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
	
	/**
	 * function check a user can view and edit wiki page -> using only for this class
	 * @param element_page
	 * @param content: old content of page
	 * @param new_content: New content of page
	 */
	public static void checkUserCanViewEditPage(By element_page, String content, String new_content){
		goToWiki();
		click(element_page);
		waitForTextPresent(content);
		editWikiPage(null, new_content, 0, false);
		waitForTextPresent(new_content);
		info("User can view and edit page");
	}
	
	/**
	 * function: check permission default when just add user for wiki page then add Edit page permission
	 * @param user: user/group
	 */
	public static void checkPerDefaultAndAddEditPer(String user){
		By EditPage = By.xpath(ELEMENT_EDIT_PAGE_CHECK.replace("{$user}", user));
		By ViewPage = By.xpath(ELEMENT_VIEW_PAGE_CHECK.replace("{$user}", user));
		
		info("Check user permission default has view permission but does not have edit page permission");
		goToPagePermission();
		assert !waitForAndGetElement(EditPage).isSelected();
		assert waitForAndGetElement(ViewPage).isSelected();
		close();
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Add edit page permission for " + user);
		editPagePermission(user, true, true);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
	}
	
	public static void deleteWikiPageWithUserAdmin(By element_page){
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		goToWiki();
		click(element_page);
		deleteWikiPage();
	}
	
	/* case 01: Add permission for user by putting user's name
	 * add page
	 * set permission for user have view/edit permission by putting user's name
	 * check user can view/edit page
	 */
	@Test
	public void test01_AddPermissionForUser_PutUserName(){
		String title = "KS_Wiki_PagePermission_Add_Page_01";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_01";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_01";
		By element_page = By.linkText(title);
		String user = "demo";
		String[] userGroup = {user};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default by putting user's name");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(0, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		checkPerDefaultAndAddEditPer(user);
		signOut();
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/*case02: Add permission for user by selecting directly
	 * add page
	 * set permission for user have view/edit permission by select user
	 * check user can view/edit page
	 */
	@Test
	public void test02_AddPermissionForUser_SelectUser(){
		String title = "KS_Wiki_PagePermission_Add_Page_02";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_02";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_02";
		By element_page = By.linkText(title);
		String user = "demo";
		String[] userGroup = {user};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default by selecting directly");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(1, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		checkPerDefaultAndAddEditPer(user);
		signOut();
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/*case03: Add permission for user by searching user by user name
	 * add page
	 * set permission for user have view/edit permission by search user name
	 * check user can view/edit page
	 */
	@Test
	public void test03_AddPermissionForUser_SearchUserName(){
		String title = "KS_Wiki_PagePermission_Add_Page_03";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_03";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_03";
		By element_page = By.linkText(title);
		String user = "demo";
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default by searching user by user name");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		goToPagePermission();
		click(ELEMENT_SELECT_USER);
		selectUserPermission(user, 1);
		click(ELEMENT_ADD_BUTTON);
		save();
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Set edit page permission for user");
		checkPerDefaultAndAddEditPer(user);
		signOut();
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/* case04: Add permission for user by searching user by first name
	 * add page
	 * set permission for user have view/edit permission by search first name
	 * check user can view/edit page
	 */
	@Test
	public void test04_AddPermissionForUser_SearchFirstName(){
		String title = "KS_Wiki_PagePermission_Add_Page_04";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_04";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_04";
		By element_page = By.linkText(title);
		String user = "demo";
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default by searching user by first name");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		goToPagePermission();
		click(ELEMENT_SELECT_USER);
		selectUserPermission("Jack", 2);
		click(ELEMENT_ADD_BUTTON);
		save();
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Set edit page permission for user");
		checkPerDefaultAndAddEditPer(user);
		signOut();
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/* case05: Add permission for user by searching user by last name
	 * add page
	 * set permission for user have view/edit permission by search last name
	 * check user can view/edit page
	 */
	@Test
	public void test05_AddPermissionForUser_SearchLastName(){
		String title = "KS_Wiki_PagePermission_Add_Page_05";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_05";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_05";
		By element_page = By.linkText(title);
		String user = "demo";
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default by searching user by last name");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		goToPagePermission();
		click(ELEMENT_SELECT_USER);
		selectUserPermission("Miller", 3);
		click(ELEMENT_ADD_BUTTON);
		save();
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Set edit page permission for user");
		checkPerDefaultAndAddEditPer(user);
		signOut();
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/* case06: Add permission for user by searching user by email
	 * add page
	 * set permission for user have view/edit permission by search email
	 * check user can view/edit page
	 */
	@Test
	public void test06_AddPermissionForUser_SearchEmail(){
		String title = "KS_Wiki_PagePermission_Add_Page_06";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_06";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_06";
		By element_page = By.linkText(title);
		String user = "demo";
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default by searching user by email");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		goToPagePermission();
		click(ELEMENT_SELECT_USER);
		selectUserPermission("jack.miller@acme.exoplatform.com", 4);
		click(ELEMENT_ADD_BUTTON);
		save();
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Set edit page permission for user");
		checkPerDefaultAndAddEditPer(user);
		signOut();
		
		info("Check user can view/edit wiki page");
		signIn(user, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/* case07: Add permission for multi-user at the same time
	 * add page
	 * set permission for multi-user have view/edit permission by search email
	 * check user can view/edit page
	 */
	@Test
	public void test07_AddPermissionForMultiUser(){
		String title = "KS_Wiki_PagePermission_Add_Page_07";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_07";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_07";
		By element_page = By.linkText(title);
		String user1 = "demo";
		String user2 = "james";
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add multi-user have permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		goToPagePermission();
		click(ELEMENT_SELECT_USER);		
		selectUserPermission("demo/james");
		click(ELEMENT_ADD_BUTTON);
		save();
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		
		info("Set edit page permission for users");
		checkPerDefaultAndAddEditPer(user1);
		checkPerDefaultAndAddEditPer(user2);
		signOut();
		
		info("Check user demo can view/edit wiki page");
		signIn(user1, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		info("Check user james can view/edit wiki page");
		signIn(user2, DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, new_content, content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);	
	}
	
	/* case08: Add permission for group by putting group's name
	 * add page
	 * set permission for group have view/edit permission by putting group's name
	 * check user belong to group can view/edit page  
	 */
	@Test
	public void test08_AddPermissionForGroup_PutGroupName(){
		String title = "KS_Wiki_PagePermission_Add_Page_08";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_08";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_08";
		By element_page = By.linkText(title);
		String group = "*:/organization/management/human-resources";
		String[] userGroup = {group};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group has permission default by putting group's name");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(0, userGroup);		
		
		info("Set edit page permission for group");
		checkPerDefaultAndAddEditPer(group);
		signOut();
		
		info("Check user James belong to group can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/* case09: Add permission for group by selecting directly
	 * add page
	 * set permission for group have view/edit permission by selecting directly
	 * check user belong to group can view/edit page 
	 */
	@Test
	public void test09_AddPermissionForGroup_SelectGroup(){
		String title = "KS_Wiki_PagePermission_Add_Page_09";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_09";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_09";
		By element_page = By.linkText(title);
		String group = "*:/organization/management/human-resources";
		String[] userGroup = {"Organization/Management/Human Resources"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group has permission default by selecting directly");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(2, userGroup);
		
		info("Set edit page permission for group");
		checkPerDefaultAndAddEditPer(group);
		signOut();
		
		info("Check user James belong to group can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/*case10: Add permission for user by putting group's membership
	 * add page
	 * set permission for group's membership have view/edit permission by putting group's membership
	 * check user belong to group can view/edit page 
	 */
	@Test
	public void test10_AddPermissionForUser_PutGroupMembership(){
		String title = "KS_Wiki_PagePermission_Add_Page_10";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_10";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_10";
		By element_page = By.linkText(title);
		String group = "redactor:/platform/web-contributors";
		String[] userGroup = {group};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group has permission default by putting group's membership");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(0, userGroup);		
		
		info("Set edit page permission for group's membership");
		checkPerDefaultAndAddEditPer(group);
		signOut();
		
		info("Check user James belong to group and has membership can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		info("Check user Mary belong to group but does not have membership that can view/edit wikipage");
		signIn("mary", DATA_PASS_ADMIN);
		goToWiki();
		waitForElementNotPresent(element_page);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/* case11: Add permission for group's membership  by selecting directly
	 * add page
	 * set permission for group's membership have view/edit permission by selecting directly
	 * check user belong to group can view/edit page 
	 */
	@Test
	public void test11_AddPermissionForGroup_SelectGroupMembership(){
		String title = "KS_Wiki_PagePermission_Add_Page_11";
		String content = "KS_Wiki_PagePermission_Add_Page_Content_11";
		String new_content = "KS_Wiki_PagePermission_Add_Page_Content_new_11";
		By element_page = By.linkText(title);
		String group = "redactor:/platform/web-contributors";
		String[] userGroup = {"Platform/Content Management", "redactor"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group's membership has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(3, userGroup);		
		
		info("Set edit page permission for group's membership");
		checkPerDefaultAndAddEditPer(group);
		signOut();
		
		info("Check user James belong to group and has membership can view/edit wiki page");
		signIn("james", DATA_PASS_ADMIN);
		checkUserCanViewEditPage(element_page, content, new_content);
		signOut();
		
		info("Check user Mary belong to group but does not have membership that can view/edit wikipage");
		signIn("mary", DATA_PASS_ADMIN);
		goToWiki();
		waitForElementNotPresent(element_page);
		signOut();
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
}
