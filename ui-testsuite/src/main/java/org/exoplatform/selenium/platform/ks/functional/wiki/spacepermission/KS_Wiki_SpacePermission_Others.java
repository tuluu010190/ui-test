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

/**
 *
 * @author HangNTT
 * @date: 18/12/2012
 */
public class KS_Wiki_SpacePermission_Others extends Wiki {

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}
	
	/* case01: Check when user/group does not admin page permission
	 * add page
	 * add permission for space
	 * Check permission for user/group does not admin page 
	 */
	@Test
	public void test01_CheckWhenUserOrGroupDoesNotAdminPagePermission() {

		String PAGE_NAME1 = "Check When user does not admin page permission";

		String[] user2= {"james"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		goToWiki();

		addSpacePermission(0, user2);

		editSpacePermission("james", true, true, false, false);

		click(ELEMENT_WIKI_HOME);

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		click (ELEMENT_MORE_LINK);

		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_LINK);

		goToWiki(userType.ADMIN);

		click(ELEMENT_PAGE1);

		deleteWikiPage();

		deleteSpacePermission("james");
	}
	
	/* case02: Check when user/group does not admin space permission
	 * add page
	 * add permission for space without admin space permission 
	 * Check permission for user/group does not admin space page 
	 */
	@Test
	public void test02_CheckWhenUserOrGroupDoesNotSpacePagePermission() {

		String PAGE_NAME1 = "Check When user does not space page permission";

		String[] user2= {"james"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		goToWiki();

		addSpacePermission(0, user2);

		editSpacePermission("james", true, true, true, false);

		click(ELEMENT_WIKI_HOME);

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		goToWiki(userType.AUTHOR);

		waitForElementNotPresent(ELEMENT_BROWSE_LINK);

		goToWiki(userType.ADMIN);

		click(ELEMENT_PAGE1);

		deleteWikiPage();

		deleteSpacePermission("james");
	}

	/* case03: Check when user/group does not permission to edit page
	 * add page
	 * add permission for space
	 * Check permission for user/group does not permission to edit page
	 */
	@Test
	public void test03_CheckWhenUserOrGroupDoesNotPermissionToEditPage() {

		String PAGE_NAME1 = "Check When user does not space permission to edit page";

		String[] user2= {"james"};

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		boolean[] pageOrSpace = {true, false};

		boolean[] type = {true,false};

		goToWiki();

		addSpacePermission(0, user2);

		editSpacePermission("any", true, false, false, false);

		click(ELEMENT_WIKI_HOME);

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		verifyPermissions(pageOrSpace, type, "james");

		goToWiki(userType.AUTHOR);

		click(ELEMENT_PAGE1);

		waitForElementNotPresent(ELEMENT_MINOR_EDIT_BUTTON);

		info("Reset data");

		goToWiki(userType.ADMIN);

		click(ELEMENT_PAGE1);

		deleteWikiPage();

		editSpacePermission("any", true, true, false, false);

		deleteSpacePermission("james");
	}
	
	/* case04: Check when user/group does not permission to view page
	 * add page
	 * add permission for space
	 * Check permission for user/group does not permission to view page
	 */
	@Test
	public void test04_CheckWhenUserOrGroupDoesNotPermissionToViewPage() {

		String VERIFY_MESSAGE = "Page Not Found";

		String[] user2= {"any"};

		goToWiki();

		editSpacePermission("any", false, false, false, false);

		goToWiki(userType.DEVELOPER);

		waitForTextPresent(VERIFY_MESSAGE);

		info("Reset data");

		goToWiki(userType.ADMIN);

		addSpacePermission(0, user2);

		editSpacePermission("any", true, true, false, false);
	}
	
	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}