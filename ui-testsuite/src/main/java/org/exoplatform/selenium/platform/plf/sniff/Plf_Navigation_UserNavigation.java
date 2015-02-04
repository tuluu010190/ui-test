package org.exoplatform.selenium.platform.plf.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.testng.annotations.*;


	/**
	* @author eXo
	*
	*/
	public class Plf_Navigation_UserNavigation extends Plf_TestConfig{

	/**
	*<li> Case ID:120903.</li>
	*<li> Test Case Name: User navigate another user's personal pages.</li>
	*/
	@Test
	public  void test01_UserNavigateAnotherUsersPersonalPages() {
		info("Test 1: User navigate another user's personal pages");
		/*Step Number: 1
		*Step Name: Show a list of applications of another user
		*Step Description: 
			- Connect to Intranet
			- Openpersonal page of another user, by click on the link of his profile's namefrom activity stream, or connection
		*Input Data: 
			
		*Expected Outcome: 
			- The personal page of user is displayed
			- The Horizontal toolbar is displayed
			- The list of applications of space are displayed in the following order:* Profile* Activity Stream* Connections* Wiki
			- Click on each applications, the application will show up in the main page*/ 
		click(By.xpath(hp.ELEMENT_SUGGESTIONS_USER.replace("{$user}","FQA VN")));
		waitForAndGetElement(By.xpath(userProfile.ELEMENT_NAME_OF_USER_TOP_LEFT.replace("{$name}","FQA VN")));
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_FIRST_APP_PROFILE);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_SECOND_APP_ACTIVITIES);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_THIRD_APP_CONNECTIONS);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_FORTH_APP_WIKI);
	}

	/**
	*<li> Case ID:120904.</li>
	*<li> Test Case Name: User navigates in his own personal pages.</li>
	*/
	@Test
	public  void test02_UserNavigatesInHisOwnPersonalPages() {
		info("Test 2: User navigates in his own personal pages");
		/*Step Number: 1
		*Step Name: Show personal applications
		*Step Description: 
			- Login as an user
			- Connect to Intranet
			- Mouse over on User name on top navigation, the select "My Profile" link
		*Input Data: 
			
		*Expected Outcome: 
			- The Horizontal toolbar is displayed
			- The list of applications of space are displayed in the following order:* My Profile* My Activity Stream* My Connections* My Wiki* My Dashboard
			- Click on each applications, the application will show up in the main page*/ 
		click(navToolBar.ELEMENT_TOPBAR_AVATAR);
		click(navToolBar.ELEMENT_MY_PROFILE_LINK);
		waitForAndGetElement(By.xpath(userProfile.ELEMENT_NAME_OF_USER_TOP_LEFT.replace("{$name}","John Smith")));
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_FIRST_APP_PROFILE);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_SECOND_APP_ACTIVITIES);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_THIRD_APP_CONNECTIONS);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_FORTH_APP_WIKI);
		waitForAndGetElement(userProfile.ELEMENT_HORIZONTAL_TOOLBAR_FIFTH_APP_DASHBOARD);
 	}
}