package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.administration.ChangeLanguages;
import org.testng.annotations.*;


/**
 * @date 8 April 2015
 * @author tult
 *
 */

public class Gatein_Global_Settings extends GateIn_TestConfig{
	/**
	 *<li> Case ID:123030.</li>
	 *<li> Test Case Name: Change Password.</li>
	 */
	@Test
	public void test01_ChangePassword(){
		String username = txData.getContentByIndex(14) + getRandomString();
		String password = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String email = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();	
		String newpass = txData.getContentByArrayTypeRandom(1) + getRandomNumber();

		info("Add new user");
		navToolBar.goToAddUser();
		addUserPage.addUser(username, password, email, username, username);

		/*Step Number: 1
		 *Step Name: Step 1: Change Password		
		 *Step Description: 
			- Click on the name of user
			- Click on Settings 
			- Select Change Password tab
			- Change new password and click Save
		 *Input Data: 
		 *Expected Outcome: 
			- Priority is changed successfully */
		info("Change password of user");
		magAc.signIn(username, password);
		navToolBar.goToMySettings();
		addUserPage.changePassWord(password, newpass, newpass);
		Utils.pause(2000);

		info("Login with new pass");
		magAc.signIn(username, newpass);

		info("Clear Data");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navToolBar.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username);
	}

	/**
	 *<li> Case ID:123029.</li>
	 *<li> Test Case Name: Change User Profile.</li>
	 */
	@Test
	public void test02_ChangeUserProfile(){	
		String username = txData.getContentByIndex(14) + getRandomString();
		String password = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String email = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();	

		String newFirstName = txData.getContentByIndex(14) + getRandomString();
		String newLastName = txData.getContentByIndex(14) + getRandomString();
		String newEmail = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();

		info("Add new User");
		navToolBar.goToAddUser();
		addUserPage.addUser(username, password, email, username, username);

		/*Step Number: 1
		 *Step Name: Step 1: Change User Profile	
		 *Step Description: 
			- Click on the name of user
			- Select My Profile tab
			- Select [Edit My Profile] Button
			- Change user profile for user ( First Name, Last Name, Email) and click Save
		 *Input Data: 
		 *Expected Outcome: 
			- The User profile is updated with the change value*/
		info("Change User Profile");
		info("Verify before change User Profile");
		magAc.signIn(username, password);
		waitForAndGetElement(myProf.ELEMENT_NAME_OF_USER_TOP_RIGHT.replace("${firstName}", username).replace("${lastName}", username));
		info("Change User Profile");
		navToolBar.goToMyProfile();
		myProf.goToEditProfile();
		myProf.updateBasicInformation(newFirstName, newLastName, newEmail);
		info("Verify after change User Profile");
		magAc.signIn(username, password);
		waitForAndGetElement(myProf.ELEMENT_NAME_OF_USER_TOP_RIGHT.replace("${firstName}", newFirstName).replace("${lastName}", newLastName));

		info("Clear Data");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navToolBar.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username);
	}

	/**
	 *<li> Case ID:123145.</li>
	 *<li> Test Case Name: Change language for another user.</li>
	 */
	@Test
	public void test03_ChangeLanguageForAnotherUser(){
		String username = txData.getContentByIndex(14) + getRandomString();
		String password = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String email = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();	
		String language = langData.getLanguageByIndex(0);

		info("Add new user");
		navToolBar.goToAddUser();
		addUserPage.addUser(username, password, email, username, username);

		/*Step Number: 1
		 *Step Name: Step 1: Change language for another user	
		 *Step Description: 
			- Go to Administration/users/Group and Roles
			- In User management form: select a user in list and click Edit User infor
			- Choose User Profile sub-tab, then change the display language for this user from the Language field. ( ex: change to French language)
			- Click Save
		 *Input Data: 
		 *Expected Outcome: 
			- Show message alert: "The user profile has been updated." */
		info("Change language of user mary to French");
		navToolBar.goToUsersAndGroupsManagement();
		userAndGroup.goToEditUserInfo(username);
		userAndGroup.editUserInfo_UserProfileTab("", "", "", "", "Female", "", "", "", language);

		/*Step Number: 2
		 *Step Name: Step 2: Check after change language for user	
		 *Step Description: 
			- Go to Administration/users/Group and Roles
			- In User management form: select a user in list and click Edit User infor
			- Choose User Profile sub-tab, then change the display language for this user from the Language field. ( ex: change to French language)
			- Click Save
		 *Input Data: 
		 *Expected Outcome: 
			- Show message alert: "The user profile has been updated." */
		info("Check language display for user");
		magAc.signIn(username, password);
		waitForAndGetElement(hp.ELEMENT_HOME_LINK_PLF_IN_FRENCH);


		info("Clear Data");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navToolBar.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username);
	}

	/**
	 *<li> Case ID:123146.</li>
	 *<li> Test Case Name: Change language with demo account.</li>
	 */
	@Test
	public void test04_ChangeLanguageWithDemoAccount(){
		String language1 = langData.getLanguageByIndex(0);
		String language2 = langData.getLanguageByIndex(2);

		/*Step Number: 1
		 *Step Name: Step 1: Change language with demo account (john/demo/mary/james)	
		 *Step Description: 
			- Sign In portal by Admin/Manager/User/Demo account
		 *Input Data: 
		 *Expected Outcome: 
			- Portal in private mode is displayed
			- It is displayed in language of the language of Cookie on website that was supported by portal or by current using portal ( admin/manager/User/Demo don't set language )*/
		info("Check language default when do not set language for user is English");
		waitForAndGetElement(hp.ELEMENT_HOME_LINK_PLF);
		magAc.signOut();
		driver.manage().deleteAllCookies();
		driver.close();

		/*Step Number: 2
		 *Step Name: Step 2: Check displaying language when language of browser don't support by portal with user account demo	
		 *Step Description: 
			- Sign In portal by Admin/Manager/User/Demo account
		 *Input Data: 
		 *Expected Outcome: 
			- Portal in private mode is displayed
			- It is displayed in language of current Cookie on your site ( admin/manager/User/Demo don't set language )*/
		info("Check displaying language when language of browser don't support by portal with user account demo");
		getDriverSetLanguage(Language.lo);
		driver.close();
		initSeleniumTest();
		driver.get(baseUrl);
		magAc = new ManageLogInOut(driver);
		navToolBar = new NavigationToolbar(driver);
		changeLang = new ChangeLanguages(driver);
		magAc.signIn(DATA_USER4, DATA_PASS);
		waitForAndGetElement(hp.ELEMENT_HOME_LINK_PLF);

		/*Step Number: 3
		 *Step Name: Step 3: Check when change language	
		 *Step Description: 
			- Change language to French
		 *Input Data: 
		 *Expected Outcome: 
			- Portal is displayed in new selected language
			- At next time when edited user sign in, the displaying language will be in the new selected*/
		info("Check when change language to French");
		navToolBar.goToChangeLanguage();
		changeLang.changeLanguage(language1, "Apply");
		waitForAndGetElement(hp.ELEMENT_HOME_LINK_PLF_IN_FRENCH);
		info ("At next time when edited user sign in, the displaying language will be in the new selected");
		magAc.signIn(DATA_USER4, DATA_PASS);
		waitForAndGetElement(hp.ELEMENT_HOME_LINK_PLF_IN_FRENCH);

		info("Change language of Demo account to English");
		navToolBar.goToChangeLanguage();
		changeLang.changeLanguage(language2, "Appliquer");
		waitForAndGetElement(hp.ELEMENT_HOME_LINK_PLF);
	}
}
