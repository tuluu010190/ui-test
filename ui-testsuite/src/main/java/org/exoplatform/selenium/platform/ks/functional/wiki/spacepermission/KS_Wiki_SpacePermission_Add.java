package org.exoplatform.selenium.platform.ks.functional.wiki.spacepermission;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.exoplatform.selenium.platform.ks.Wiki;
import org.exoplatform.selenium.platform.social.ManageMember.userType;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.TestLogger.info;

/*
 *-- 
 *-- Update by VuNA2 
 *-- Make a group of common code for these test cases
 *-- Fix error: UnhandledAlertException: Modal dialog present   
 *--
 */
/**
 *
 * @author HangNTT
 * @date: 17/12/2012
 */
public class KS_Wiki_SpacePermission_Add extends Wiki {

	String DATA_USER_ADMIN = "john";

	String DATA_PASS = "gtn";

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		signIn(DATA_USER_ADMIN, DATA_PASS);
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/* case01: Add permission for user by putting user's name
	 * add page
	 * Check permission for user have add/edit page by putting user's name
	 * check user can view/edit page
	 */
	@Test
	public void test01_AddPermissionForUserByPuttingUserName() {

		String PAGE_NAME1 = "Add permission for user by putting user name";

		String[] user2= {"james"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV1(PAGE_NAME1, 0, user2, "james");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "james");
	}

	/* case02: Add permission for user by selecting user's name
	 * add page
	 * Check permission for user have add/edit page by selecting directly
	 * check user can view/edit page
	 */
	@Test
	public void test02_AddPermissionForUserBySelectingDirectly() {

		String PAGE_NAME1 = "Add permission for user by selecting directly";

		String[] user2= {"james"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV1(PAGE_NAME1, 1, user2, "james");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "james");
	}

	/* case03: Add permission for user by Searching UserName
	 * add page
	 * Check permission for user have add/edit page by searching user name
	 * check user can view/edit page
	 */
	@Test
	public void test03_AddPermissionForUserBySearchingUserByUserName() {

		String PAGE_NAME1 = "add permission by search user";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV2(PAGE_NAME1, "james", "james", 1);

		info("Check user after set permisison");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "james");
	}

	/* case04: Add permission for user by Searching First Name
	 * add page
	 * Check permission for user have add/edit page by searching first name
	 * check user can view/edit page
	 */
	@Test
	public void test04_AddPermissionForUserBySearchingUserByFirstName() {

		String PAGE_NAME1 = "add permission by search first name";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV2(PAGE_NAME1, "James", "james", 2);

		info("Check after edit user");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "james");
	}

	/* case05: Add permission for user by Searching Last Name
	 * add page
	 * Check permission for user have add/edit page by searching last name
	 * check user can view/edit page
	 */
	@Test
	public void test05_AddPermissionForUserBySearchingUserByLastName() {

		String PAGE_NAME1 = "add permission by search last name";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV2(PAGE_NAME1, "Davis", "james", 3);

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "james");
	}

	/* case06: Add permission for user by Searching Email Name
	 * add page
	 * Check permission for user have add/edit page by searching email name
	 * check user can view/edit page
	 */
	@Test
	public void test06_AddPermissionForUserBySearchingUserByEmailName() {

		String PAGE_NAME1 = "add permission by search email name";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV2(PAGE_NAME1, "james.davis@acme.exoplatform.com", "james", 4);

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "james");
	}

	/* case07: Add permission for muilti user at the same time
	 * add page
	 * Check permission for multi-user have add/edit page 
	 * check user can view/edit page
	 */
	@Test
	public void test07_AddPermissionForMultiUser() {

		String PAGE_NAME1 = "add permission for multi user";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV2(PAGE_NAME1, "james/demo", "james");

		editSpacePermission("demo", true, true, true, true);

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		click(ELEMENT_PAGE1);

		deleteSpacePermission("demo");

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "james");
	}

	/* case08: Add permission for user by putting group name
	 * add page
	 * Check permission for user have add/edit page by putting group name
	 * check user can view/edit page
	 */
	@Test
	public void test08_AddPermissionForGroupByPuttingGroupName() {

		String PAGE_NAME1 = "Add permission for group by putting group name";

		String[] user3={"*:/platform/users"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV1(PAGE_NAME1, 0, user3, "*:/platform/users");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		goToWiki(userType.ADMIN);

		info("reset data");

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "*:/platform/users");
	}

	/* case09: Add permission for user by selecting directly
	 * add page
	 * Check permission for user have add/edit page by selecting directly
	 * check user can view/edit page
	 */
	@Test
	public void test09_AddPermissionForGroupBySelectingDirectly() {

		String PAGE_NAME1 = "Add permission for group by selecting directly";

		String[] user3={"Platform/Users","*"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV1(PAGE_NAME1, 2, user3, "*:/platform/users");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "*:/platform/users");
	}

	/* case10: Add permission for user by putting group membership name
	 * add page
	 * Check permission for user have add/edit page by putting group membership name
	 * check user can view/edit page
	 */
	@Test
	public void test10_AddPermissionForGroupByPuttingGroupMemebershipName() {

		String PAGE_NAME1 = "Add permission for group by putting group membership name";

		String[] user4={"*:/platform/web-contributors"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV1(PAGE_NAME1, 0, user4, "*:/platform/web-contributors");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "*:/platform/web-contributors");
	}

	/* case11: Add permission for group by selecting
	 * add page
	 * Check permission for user have add/edit page 
	 * check user can view/edit page
	 */
	@Test
	public void test11_AddPermissionForGroupBySelecting() {

		String PAGE_NAME1 = "Add permission for group by selecting group membership name";

		String[] user4={"Platform/Users","member"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		prepareDataWikiSpacePermissionV1(PAGE_NAME1, 3, user4, "member:/platform/users");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementPresent(ELEMENT_EDIT_PAGE_LINK);

		info("reset data");

		goToWiki(userType.ADMIN);

		resetDataWikiSpacePermission(ELEMENT_PAGE1, "member:/platform/users");		
	}

	/////
	// Make a group of common code for this class
	/////
	/**
	 *<li>Add a blank wiki page</li>
	 *<li>Delete a space permission for Group: Any</li>
	 *<li>Add a space permission</li>
	 *<li><Edit a space permission</li> 
	 */
	public void prepareDataWikiSpacePermissionV1(String pageName, int option, String[] userGroupToAddPermission, String userGroupToEditPermission){
		goToWiki();
		addBlankWikiPage(pageName, pageName, 0);
		deleteSpacePermission("any");
		addSpacePermission(option, userGroupToAddPermission);
		editSpacePermission(userGroupToEditPermission, true, true, true, true);
	}

	/**
	 *<li>Add a blank wiki page</li>
	 *<li>Go to Space Permission</li>
	 *<li>Delete Space Permission Group: Any</li>
	 *<li>Select an User Permission</li> 
	 *<li>Edit Space Permission </li>
	 */
	public void prepareDataWikiSpacePermissionV2(String pageName, String selectUserPermission, String username, int...type){
		goToWiki();
		addBlankWikiPage(pageName, pageName, 0);
		goToSpacePermission();
		deleteSpacePermission("any");
		click(ELEMENT_SELECT_USER);
		selectUserPermission(selectUserPermission, type);
		click(ELEMENT_ADD_BUTTON);
		save();
		waitForMessage(MSG_PERMISSION_SAVE);
		click(ELEMENT_OK_BUTTON);
		editSpacePermission(username, true, true, true, true);
	}

	/**
	 * Reset data after testing
	 */
	public void resetDataWikiSpacePermission(By pageName, String userGroupToDeletePermission){
		String[] user = {"any"};
		click(pageName);
		deleteWikiPage();
		deleteSpacePermission(userGroupToDeletePermission);
		addSpacePermission(0, user);
		editSpacePermission("any", true, true, false, false);
	}
}