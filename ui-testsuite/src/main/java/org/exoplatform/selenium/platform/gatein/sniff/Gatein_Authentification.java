package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


	/**
	* @author eXo
	*
	*/
	public class Gatein_Authentification extends GateIn_TestConfig{

	/**
	*<li> Case ID:123066.</li>
	*<li> Test Case Name: Sign In /Sign Out.</li>
	*/
	@Test
	public  void test01_SignInSignOut() {
		info("Test 1: Sign In /Sign Out");
		/*Step Number: 1
		*Step Name: Step 1: Sign In portal
		*Step Description: 
			- Click Sign In link
			- Input user and password
			- Click Sign In button
		*Input Data: 
			
		*Expected Outcome: 
			- Sign In successfully*/
		waitForAndGetElement(hp.ELEMENT_PLF_HOMEPAGE_DISPLAY);
		/*Step number: 2
		*Step Name: Sign Out portal
		*Step Description: 
			- Click Sign out button
		*Input Data: 
			
		*Expected Outcome: 
			- Sign Out successfully*/ 
		magAc.signOut();
		waitForElementNotPresent(hp.ELEMENT_PLF_HOMEPAGE_DISPLAY);
 	}

	/**
	*<li> Case ID:123067.</li>
	*<li> Test Case Name: Register new account in public mode.</li>
	*Pending : To register need to verify a captcha, impossible to check it with selenium
	*/
	@Test(groups="pending")
	public  void test02_RegisterNewAccountInPublicMode() {
		info("Test 2: Register new account in public mode");
		/*Step Number: 1
		*Step Name: Step 1: Register new account
		*Step Description: 
			- Click Register
			- Input all data require fields with valid value
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- New account is created successfully with valid input values*/

		/*Step number: 2
		*Step Name: Step 2: Check after add new user
		*Step Description: 
			- Login with new user
		*Input Data: 
			
		*Expected Outcome: 
			- Login successfully and new user display with username or display name*/ 

 	}

	/**
	*<li> Case ID:123068.</li>
	*<li> Test Case Name: Remember my login.</li>
	*/
	@Test
	public  void test03_RememberMyLogin() {
		info("Test 3: Remember my login");
		/*Step Number: 1
		*Step Name: Step 1: Remember my login
		*Step Description: 
			- Click Sign In link
			- Input user and password
			- Check Remember my login
			- Click Sign In button
		*Input Data: 
			
		*Expected Outcome: 
			When user opens the GateIn again, User automatically go to private mode and do not have to sign in*/ 
		magAc.signIn(DATA_USER1, DATA_PASS);
		waitForAndGetElement(hp.ELEMENT_PLF_HOMEPAGE_DISPLAY);
		driver.get(baseUrl);
		waitForAndGetElement(hp.ELEMENT_PLF_HOMEPAGE_DISPLAY);
 	}

	/**
	*<li> Case ID:123069.</li>
	*<li> Test Case Name: Create new account in private mode.</li>
	*/
	@Test
	public  void test04_CreateNewAccountInPrivateMode() {
		info("Test 4: Create new account in private mode");
		/*Step Number: 1
		*Step Name: Step 1: Create new account
		*Step Description: 
			- Go to Administration/users/Add users
			- Input all data require fields 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- New account is created successfully with valid input values*/

		/*Step number: 2
		*Step Name: Step 2: Check after add new user
		*Step Description: 
			- Login with new user
		*Input Data: 
			
		*Expected Outcome: 
			- Login successfully and new user display with username or display name*/ 
		String pass="gtngtn22";
		String nom ="newuser1";
		navToolBar.goToAddUser();
		addUserPage.addUser(nom, pass, "newuser@exo.fr", "minh", "binh");
		
		magAc.signOut();
		magAc.signIn(nom, pass);
		waitForAndGetElement(hp.ELEMENT_PLF_HOMEPAGE_DISPLAY);
 	}
}