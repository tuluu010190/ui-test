package org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission.KS_Wiki_PagePermission_Add.deleteWikiPageWithUserAdmin;
import static org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission.KS_Wiki_PagePermission_Delete.*;
import static org.exoplatform.selenium.platform.ks.functional.wiki.pagepermission.KS_Wiki_PagePermission_Edit.*;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.ManageMember.*;

import org.exoplatform.selenium.platform.ks.Wiki;
import org.exoplatform.selenium.platform.social.SocialBase;
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
public class KS_Wiki_PagePermission_Other extends Wiki{
	
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
	
	public static void checkNotHaveEditPermission(String spaceName, String user, By element_page, String content){
		info("Check user can view page but does not have edit page");
		signIn(user, DATA_PASS_ADMIN);
		goToWikiFromSpace(spaceName);
		click(element_page);
		waitForTextPresent(content);
		waitForElementNotPresent(ELEMENT_EDIT_PAGE_LINK);
		signOut();
	}
	
	public static void userJoinSpaceAndCheckPagePermission(String user, String spaceName, By element_space, By element_page, String content){
		signIn(user, DATA_PASS_ADMIN);
		joinOpenSpace(spaceName);
		click(element_space);
		click(ELEMENT_WIKI_TAB);
		
		info("User can view page but can not edit page");
		click(element_page);
		waitForTextPresent(content);
		waitForElementNotPresent(ELEMENT_EDIT_PAGE_LINK);
		signOut();
	}
	
	public static void setPagePermission(String[] userGroup, int option){
		info("Add user has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		deletePermission("*:/spaces");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		deletePermission("manager:/spaces");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(option, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
	}
	
	/*case01: Check when user/group does not permission to view page
	 */
	@Test
	public void test01_CheckUserNotHaveViewPagePermission_UserPermission(){
		String title = "KS_Wiki_PagePermission_Other_Page_01_1";
		String content = "KS_Wiki_PagePermission_Other_Content_01_1";
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
		
		//check user james does not have view permission
		checkPermissionAfterDelete("james", element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	@Test
	public void test01_CheckUserNotHaveViewPagePermission_GroupPermission(){
		String title = "KS_Wiki_PagePermission_Other_Page_01_2";
		String content = "KS_Wiki_PagePermission_Other_Content_01_2";
		By element_page = By.linkText(title);
		String[] userGroup = {"Organization/Management/Human Resources"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(2, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		signOut();
		
		//check user demo does not have view permission because it does not belong to group
		checkPermissionAfterDelete("demo", element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	@Test
	public void test01_CheckUserNotHaveViewPagePermission_MembershipPermission(){
		String title = "KS_Wiki_PagePermission_Other_Page_01_3";
		String content = "KS_Wiki_PagePermission_Other_Content_01_3";
		By element_page = By.linkText(title);
		String[] userGroup = {"Platform/Content Management", "redactor"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add user has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(3, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		signOut();
		
		//check user mary does not have view permission because it has membership =  publisher/editor
		checkPermissionAfterDelete("mary", element_page);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/*case02: Check when user/group does not permission to edit page
	 */
	@Test
	public void test02_CheckUserNotHaveEditPage_UserPermission(){
		String title = "KS_Wiki_PagePermission_Other_Page_02_1";
		String content = "KS_Wiki_PagePermission_Other_Content_02_1";
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
		
		//check user demo have view page but does not have edit page
		checkOnlyViewPagePermission(user, element_page, content);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	@Test
	public void test02_CheckUserNotHaveEditPage_GroupPermission(){
		String title = "KS_Wiki_PagePermission_Other_Page_02_2";
		String content = "KS_Wiki_PagePermission_Other_Content_02_2";
		By element_page = By.linkText(title);
		String[] userGroup = {"Organization/Management/Human Resources"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add group has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(2, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		signOut();
		
		//check user james belong to group which have view page but does not have edit page
		checkOnlyViewPagePermission("james", element_page, content);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	@Test
	public void test02_CheckUserNotHaveEditPage_MembershipPermission(){
		String title = "KS_Wiki_PagePermission_Other_Page_02_3";
		String content = "KS_Wiki_PagePermission_Other_Content_02_3";
		By element_page = By.linkText(title);
		String[] userGroup = {"Platform/Content Management", "redactor"};
		
		info("Add a wiki page");
		addBlankWikiPage(title, content, 0);
		
		info("Add membership has permission default");
		deletePermission("any");
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		addPagePermission(3, userGroup);
		waitForElementNotPresent(ELEMENT_PAGE_PERMISSION_POPUP);
		signOut();
		
		//check user james (belong to membership) which have view page but does not have edit page
		checkOnlyViewPagePermission("james", element_page, content);
		
		//delete page
		deleteWikiPageWithUserAdmin(element_page);
	}
	
	/*case03: Check when user/group does not permission to edit page (add space)
	 * add new space
	 * add page
	 * add view page permission for user/group/membership
	 */
	@Test
	public void test03_CheckUserNotHaveEditPagePermission_AddSpace(){
		String spaceName = "KS PagePermission space 03 1";
		String spaceDescription = "KS_Wiki_PagePermission_Other_space_description_03_1";
		By element_space = By.linkText(spaceName);
		String title = "KS_Wiki_PagePermission_Other_Page_03_1";
		String content = "KS_Wiki_PagePermission_Other_Content_03_1";
		By element_page = By.linkText(title);
		String user = "demo";
		String[] userGroup = {user};
		
		//add new space visible and open
		SocialBase.goToMySpacePage();
		addNewSpace(spaceName, spaceDescription, "Visible", "Open", "", "");
		
		info("Add a wiki page");
		goToWikiFromSpace(spaceName);
		addBlankWikiPage(title, content, 0);
		setPagePermission(userGroup, 1);
		signOut();
		
		info("user joins space -> check page permission");
		userJoinSpaceAndCheckPagePermission(user, spaceName, element_space, element_page, content);
		
		//delete space
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		restoreData(spaceName, 100000);
	}
	
	@Test
	public void test03_CheckGroupNotHaveEditPagePermission_AddSpace(){
		String spaceName = "KS PagePermission space 03 2";
		String spaceDescription = "KS_Wiki_PagePermission_Other_space_description_03_2";
		By element_space = By.linkText(spaceName);
		String title = "KS_Wiki_PagePermission_Other_Page_03_2";
		String content = "KS_Wiki_PagePermission_Other_Content_03_2";
		By element_page = By.linkText(title);
		String[] userGroup = {"Organization/Management/Human Resources"};
		
		//add new space visible and open
		SocialBase.goToMySpacePage();
		addNewSpace(spaceName, spaceDescription, "Visible", "Open", "", "");
		
		info("Add a wiki page");
		goToWikiFromSpace(spaceName);
		addBlankWikiPage(title, content, 0);
		setPagePermission(userGroup, 2);
		signOut();
		
		info("user james belongs to group that joins space -> check page permission");
		userJoinSpaceAndCheckPagePermission("james", spaceName, element_space, element_page, content);
		
		//delete space
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		restoreData(spaceName, 100000);
	}
	
	@Test
	public void test03_CheckMembershipNotHaveEditPagePermission_AddSpace(){
		String spaceName = "KS PagePermission space 03 3";
		String spaceDescription = "KS_Wiki_PagePermission_Other_space_description_03_3";
		By element_space = By.linkText(spaceName);
		String title = "KS_Wiki_PagePermission_Other_Page_03_3";
		String content = "KS_Wiki_PagePermission_Other_Content_03_3";
		By element_page = By.linkText(title);
		String[] userGroup = {"Platform/Content Management", "redactor"};
		
		//add new space visible and open
		SocialBase.goToMySpacePage();
		addNewSpace(spaceName, spaceDescription, "Visible", "Open", "", "");
		
		info("Add a wiki page");
		goToWikiFromSpace(spaceName);
		addBlankWikiPage(title, content, 0);
		setPagePermission(userGroup, 3);
		signOut();
		
		info("user james belongs to membership that joins space -> check page permission");
		userJoinSpaceAndCheckPagePermission("james", spaceName, element_space, element_page, content);
		
		//delete space
		signIn(DATA_USER_ADMIN, DATA_PASS_ADMIN);
		restoreData(spaceName, 100000);
	}
}
