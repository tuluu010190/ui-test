package org.exoplatform.selenium.platform.social.functional.people;

import org.exoplatform.selenium.platform.social.SocialBase;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.TestLogger.*;
import static org.exoplatform.selenium.platform.social.PeopleProfile.*;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;
import static org.exoplatform.selenium.platform.social.Activity.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import static org.exoplatform.selenium.platform.UserGroupManagement.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author thaopth
 * Date: 15/11/2012
 */

public class SOC_PEO_View_Profile extends SocialBase {

	public static String userInfo = "//td/label[@for='${nameField}']/following::td[@class='FieldComponent' and contains(text(),'${userData}')]";

	@BeforeMethod
	public void setUpBeforeTest() {
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/*
	 * Case ID 001: Show my profile
	 * Login and view my profile form
	 * Case ID 002: View your profile
	 * View profile: Position, basic information, contact, experience...

	 */

	@Test
	public void test01_ShowMyProfile () {

		signIn("john", "gtn");

		info("---Go to my profile page---");

		goToMyProfile();

		//waitForElementPresent(ELEMENT_TOOLBAR_ACTIVITY_ICON);

		info("---Click on Activity stream link---");

		click(ELEMENT_TOOLBAR_ACTIVITY_ICON);

		info("---Verify Activity stream screen---");

		waitForElementPresent(ELEMENT_ALL_UPDATES_TAB);

		waitForElementPresent(ELEMENT_MY_SPACES_TAB);

		waitForElementPresent(ELEMENT_MY_STATUS_TAB);

		info("---Go to My profile---");

		//waitForElementPresent(ELEMENT_TOOLBAR_PROFILE_ICON);

		click(ELEMENT_TOOLBAR_PROFILE_ICON);

		/* Case ID 002: View your profile */

		info("---Verify My profile screen---");

		waitForElementPresent(ELEMENT_CHANGE_PICTURE);

		waitForElementPresent(ELEMENT_EDIT_INFORMATION_BUTTON);

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "username").replace("${userData}", "john") ));	

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "firstName").replace("${userData}", "John") ));

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "lastName").replace("${userData}", "Smith") ));

		waitForElementPresent(ELEMENT_EDIT_CONTACT_BUTTON);

		waitForElementPresent(ELEMENT_EDIT_EXPERIENCE_BUTTON);

		info("---Go to My connections page---");

		//waitForElementPresent(ELEMENT_TOOLBAR_NETWORKS_ICON);

		click(ELEMENT_TOOLBAR_NETWORKS_ICON);

		info("---Verify My connections page---");

		waitForElementPresent(ELEMENT_EVERYONE_TAB);

		waitForElementPresent(ELEMENT_MY_CONNECTIONS_TAB);

		waitForElementPresent(ELEMENT_REQUESTS_RECEIVED_TAB);

		waitForElementPresent(ELEMENT_REQUEST_SENT_TAB);
	}
	/*
	 * Case ID 003: View information of another user
	 * View profile of user who is not friend
	 * Verify: cannot post activity on activity stream
	 * Verify: Cannot edit profile of this user
	 * Verify: Only see friend of this user
	 */
	@Test
	public void test02_ViewInformationOfAnotherUser () {

		By DATA_USERNAME_LINK = By.linkText("James Davis");

		signIn("john", "gtn");

		goToFindConnections();

		info("---Verify user is not friend of current user---");

		waitForElementPresent(By.xpath("//div/a[text()='James Davis']/following::ul/li/a[@title='Connect']"));

		info("---Access profile page of user---");

		click(DATA_USERNAME_LINK);

		//waitForElementPresent(ELEMENT_TOOLBAR_ACTIVITY_ICON);

		click(ELEMENT_TOOLBAR_ACTIVITY_ICON);

		info("---Verify no text box to share activity with this user---");

		waitForElementNotPresent(ELEMENT_ATIVITY_TEXTBOX);

		info("---Go to profile of user---");

		click(ELEMENT_PROFILE_LINK);

		info("---Verify user profile screen---");

		waitForElementPresent(By.linkText("Invite to connect"));

		waitForElementNotPresent(ELEMENT_CHANGE_PICTURE);

		waitForElementNotPresent(ELEMENT_EDIT_INFORMATION_BUTTON);

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "username").replace("${userData}", "james") ));	

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "firstName").replace("${userData}", "James") ));

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "lastName").replace("${userData}", "Davis") ));

		waitForElementNotPresent(ELEMENT_EDIT_CONTACT_BUTTON);

		waitForElementNotPresent(ELEMENT_EDIT_EXPERIENCE_BUTTON);

		info("---Go to connections page---");

		click(ELEMENT_CONNECTIONS_LINK);

		waitForElementNotPresent(ELEMENT_EVERYONE_TAB);

		waitForElementNotPresent(ELEMENT_MY_CONNECTIONS_TAB);

		waitForElementNotPresent(ELEMENT_REQUESTS_RECEIVED_TAB);

		waitForElementNotPresent(ELEMENT_REQUEST_SENT_TAB);

	}
	/*
	 * Case ID 004: View profile of user in your contact
	 * Send invitation from an user
	 * Invited user accept the invitation
	 * View profile of user who is friend
	 */
	@Test
	public void test03_ViewTheProfileOfUserInYourContact () {

		String DATA_USERNAME1 = "people1";
		String DATA_PASSWORD = "123456";
		String DATA_FIRSTNAME1 = "people";
		String DATA_LASTNAME1 = "test";
		String DATA_EMAIL1 = "people@exoplatform.com";
		String DATA_USERNAME2 = "people2";
		String DATA_FIRSTNAME2 = "user";
		String DATA_LASTNAME2 = "aaa";
		String DATA_EMAIL2 = "user@exoplatform.com";
		String DATA_LANGUAGE = "English";
		String DATA_USER_FULLNAME1 = "people test";
		String DATA_USER_FULLNAME2 = "user aaa";

		signIn("john", "gtn");

		goToNewStaff();

		info("---Add new user 1---");

		addNewUserAccount(DATA_USERNAME1, DATA_PASSWORD, DATA_PASSWORD, DATA_FIRSTNAME1, DATA_LASTNAME1, DATA_EMAIL1, DATA_FIRSTNAME1, DATA_LANGUAGE, true);

		info("---Add new user 2---");

		addNewUserAccount(DATA_USERNAME2, DATA_PASSWORD, DATA_PASSWORD, DATA_FIRSTNAME2, DATA_LASTNAME2, DATA_EMAIL2, DATA_FIRSTNAME2, DATA_LANGUAGE, true);

		signOut();

		info("---Login as user 1---");

		signIn(DATA_USERNAME1, DATA_PASSWORD);

		info("---Go to find connections---");

		//goToFindConnections();

		info("---Connect to user 2---");

		connectPeople(DATA_USER_FULLNAME2);

		signOut();

		info("---Login as user 2---");

		signIn(DATA_USERNAME2, DATA_PASSWORD);

		info("---Accept the invitation---");

		acceptInvitation(DATA_USER_FULLNAME1);

		info("---Access friend's profile---");

		click(By.linkText(DATA_USER_FULLNAME1));

		info("---Go to activity stream---");

		//waitForElementPresent(ELEMENT_TOOLBAR_ACTIVITY_ICON);

		click(ELEMENT_TOOLBAR_ACTIVITY_ICON);

		info("---Verify there is text box to share activity with this user---");

		waitForElementPresent(ELEMENT_ATIVITY_TEXTBOX);

		info("---Go to profile of user---");

		click(ELEMENT_PROFILE_LINK);

		info("---Verify user profile screen---");

		waitForElementNotPresent(ELEMENT_CHANGE_PICTURE);

		waitForElementNotPresent(ELEMENT_EDIT_INFORMATION_BUTTON);

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "username").replace("${userData}", DATA_USERNAME1) ));	

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "firstName").replace("${userData}", DATA_FIRSTNAME1) ));

		waitForElementPresent(By.xpath(userInfo.replace("${nameField}", "lastName").replace("${userData}", DATA_LASTNAME1) ));

		waitForElementNotPresent(ELEMENT_EDIT_CONTACT_BUTTON);

		waitForElementNotPresent(ELEMENT_EDIT_EXPERIENCE_BUTTON);

		info("---Go to connections page---");

		click(ELEMENT_CONNECTIONS_LINK);

		info("---Verify friend of user---");

		waitForElementPresent(By.linkText(DATA_USER_FULLNAME2));

		waitForElementNotPresent(ELEMENT_EVERYONE_TAB);

		waitForElementNotPresent(ELEMENT_MY_CONNECTIONS_TAB);

		waitForElementNotPresent(ELEMENT_REQUESTS_RECEIVED_TAB);

		waitForElementNotPresent(ELEMENT_REQUEST_SENT_TAB);

		//Delete data

		signOut();

		signIn("john", "gtn");

		goToUsersAndGroupsManagement();
		
		deleteUser(DATA_USERNAME1);

		type(ELEMENT_INPUT_SEARCH_USER_NAME, "", true);

		select(ELEMENT_SELECT_SEARCH_OPTION, "User Name");

		click(ELEMENT_SEARCH_ICON_USERS_MANAGEMENT);

		waitForElementPresent(By.xpath("//div[@title='"+DATA_USERNAME2+"']"));

		deleteUser(DATA_USERNAME2);
	}

}
