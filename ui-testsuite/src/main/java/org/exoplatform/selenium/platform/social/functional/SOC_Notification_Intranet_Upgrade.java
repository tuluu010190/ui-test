package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;


	public class SOC_Notification_Intranet_Upgrade{

	/**
	*<li> Case ID:125156.</li>
	*<li> Test Case Name: Existing PLF 4.1 users and new users will get the default values for Intranet Notification.</li>
	*<li> Pre-Condition: - User A is an existing user of PLF 4.1
	- Upgrade from PLF 4.1 to PLF 4.2</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED
	*/
	@Test(groups="pending")
	public  void test01_UsersAndNewUsersWillGetTheDefaultValuesForIntranetNotification() {
		info("Test 1: Existing PLF 4.1 users and new users will get the default values for Intranet Notification");
		/*Step Number: 1
		*Step Name: Step 1: Login with existing user from PLF4.1
		*Step Description: 
			- Login with User A
		*Input Data: 
			
		*Expected Outcome: 
			- Login successfully*/

		/*Step number: 2
		*Step Name: Step 2: Check notification settings page
		*Step Description: 
			- Go to User Menu and click [My Notifications]
		*Input Data: 
			
		*Expected Outcome: 
			- Notification settings page is displayed*/

		/*Step number: 3
		*Step Name: Step 3: Check default settings
		*Step Description: 
			- Check the Intranet Notification settings
		*Input Data: 
			
		*Expected Outcome: 
			- The default Intranet Notifications settings are applied for the user* New User : No Notifications* Connection Request : Intranet Notification* Space Invitation : Intranet Notification* Space Join Request: Intranet Notification* Mention : Intranet Notification* Comment : Intranet Notification* Like : No notifications* Post on my Steam :Intranet Notification* Post on my Space :Intranet Notification*/ 

 	}

	/**
	*<li> Case ID:125157.</li>
	*<li> Test Case Name: Initial user settings are kept after upgrading to 4.2.</li>
	*<li> Pre-Condition: - In platform 4.1. the user has his own settings. For instance : * New User : No Intranet Notification. Email notifications, Daily digest* Connection Request : Intranet Notification, Email notifications, Daily digest* Space Invitation : Intranet Notification, Email notifications, No digest* Space Join Request: Intranet Notification, Email notifications, No digest* Mention : Intranet Notification, Weekly digest* Comment : Intranet Notification, Email Notification Weekly digest* Like : Intranet notifications, Email Notification Weekly digest* Post on my Steam :No Intranet Notification, Email Notification Weekly digest* Post on my Space :No Intranet Notification, Email Notification Weekly digest</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED
	*/
	@Test(groups="pending")
	public  void test02_InitialUserSettingsAreKeptAfterUpgrading() {
		info("Test 2: Initial user settings are kept after upgrading to 4.2");
		/*Step Number: 1
		*Step Name: Step 1 : Upgrade to 4.2
		*Step Description: 
			Upgrade the binary from 4.1 to 4.2
		*Input Data: 
			
		*Expected Outcome: 
			The upgrade is performed*/

		/*Step number: 2
		*Step Name: Step 2 : Check notifications settings
		*Step Description: 
			- Login with the existing user
			- Go to User Menu > [My Notification]
			- Check the user settings
		*Input Data: 
			
		*Expected Outcome: 
			The user settings are the same than in 4.1* New User : No Intranet Notification. Email notifications, Daily digest* Connection Request : Intranet Notification, Email notifications, Daily digest* Space Invitation : Intranet Notification, Email notifications, No digest* Space Join Request: Intranet Notification, Email notifications, No digest* Mention : Intranet Notification, Weekly digest* Comment : Intranet Notification, Email Notification Weekly digest* Like : Intranet notifications, Email Notification Weekly digest* Post on my Steam :No Intranet Notification, Email Notification Weekly digest* Post on my Space :No Intranet Notification, Email Notification Weekly digest*/ 

 	}

	/**
	*<li> Case ID:125158.</li>
	*<li> Test Case Name: Initial administration configuration is kept after upgrading to 4.2.</li>
	*<li> Pre-Condition: - In platform 4.1. the notification administration is for instance : * New User : No Intranet Notification, No Email notification* Connection Request : Intranet Notification, Email notifications* Space Invitation :Intranet Notification, Email notifications* Space Join Request:Intranet Notification, Email notifications* Mention :Intranet Notification, Email notifications* Comment :Intranet Notification, Email notifications* Like :Intranet Notification, Email notifications* Post on my Steam : Intranet Notification, No Email notification* Post on my Space :No Intranet Notification, Email notification</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED
	*/
	@Test(groups="pending")
	public  void test03_InitialAdministrationConfigurationIsKeptAfterUpgrading() {
		info("Test 3: Initial administration configuration is kept after upgrading to 4.2");
		/*Step Number: 1
		*Step Name: Step 1 : Upgrade to 4.2
		*Step Description: 
			Upgrade the binary from 4.1 to 4.2
		*Input Data: 
			
		*Expected Outcome: 
			The upgrade is performed*/

		/*Step number: 2
		*Step Name: Step 2 : Check notifications settings
		*Step Description: 
			- Login with an admin
			- Go to Administration > Portal > Notifications
			- Check the administration
		*Input Data: 
			
		*Expected Outcome: 
			The administration config is the same than in 4.1 : * New User : No Intranet Notification, No Email notification* Connection Request : Intranet Notification, Email notifications* Space Invitation :Intranet Notification, Email notifications* Space Join Request:Intranet Notification, Email notifications* Mention :Intranet Notification, Email notifications* Comment :Intranet Notification, Email notifications* Like :Intranet Notification, Email notifications* Post on my Steam : Intranet Notification, No Email notification* Post on my Space :No Intranet Notification, Email notification*/

		/*Step number: 3
		*Step Name: Step 3 : Check user settings page
		*Step Description: 
			- Go to user menu > [My Notification]
			- Check the notification settings
		*Input Data: 
			
		*Expected Outcome: 
			- The row New user is not displayed
			- Post in My stream : can't select Email notification settings
			- Post in my Space : can't select intranet notification settings*/ 

 	}}