package org.exoplatform.selenium.platform.social.functional;

import org.testng.annotations.Test;

public class SOC_Notifications_IntranetNotifications_Upgrade extends SOC_TestConfig{

	/*Qmetry: 125156 Existing PLF 4.1 users and new users will get the default values for Intranet Notification
	* Preconditions:- User A is an existing user of PLF 4.1
					- Upgrade from PLF 4.1 to PLF 4.2
		Step 1: Login with existing user from PLF4.1
		Step 2: Check notification settings page
		Step 3: Check default settings
		--> - The default Intranet Notifications settings are applied for the user
			* New User : No Notifications
			* Connection Request : Intranet Notification
			* Space Invitation : Intranet Notification
			* Space Join Request: Intranet Notification
			* Mention : Intranet Notification
			* Comment : Intranet Notification
			* Like : No notifications
			* Post on my Steam :  Intranet Notification
			* Post on my Space :  Intranet Notification
			* 
	*Pending because the Intranet Notification is available from 4.2, not from 4.1
	*/
	@Test  (groups = "pending")
	public void Test01_ExistingPLF41UsersAndNewUsersWillGetDefaultValuesForIntranetNotification(){

	}
	
	/*QMetryID: 125157 Initial user settings are kept after upgrading to 4.2
	 *Preconditions: - In platform 4.1. the user has his own settings. For instance : 
						* New User : No Intranet Notification. Email notifications, Daily digest
						* Connection Request : Intranet Notification, Email notifications, Daily digest
						* Space Invitation : Intranet Notification, Email notifications, No digest
						* Space Join Request: Intranet Notification, Email notifications, No digest
						* Mention : Intranet Notification, Weekly digest
						* Comment : Intranet Notification, Email Notification Weekly digest
						* Like : Intranet notifications, Email Notification Weekly digest
						* Post on my Steam :  No Intranet Notification, Email Notification Weekly digest
						* Post on my Space :  No Intranet Notification, Email Notification Weekly digest 
	  
	  Step 1 : Upgrade to 4.2
	  Step 2 : Check notifications settings
	  	- Login with the existing user
		- Go to User Menu > [My Notification]
		- Check the user settings
	  --> The user settings are the same than in 4.1 in preconditions.
	  
	  *Pending because the Intranet Notification is available from 4.2, not from 4.1
	 */
	@Test  (groups = "pending")
	public void Test02_InitialUserSettingsAreKeptAfterUpgradingTo42(){
		
	}
	/*QMetryID: 125158 Initial administration configuration is kept after upgrading to 4.2
	 * Preconditions: 
	 * - In platform 4.1. the notification administration is for instance : 
		
		* New User : No Intranet Notification, No Email notification
		* Connection Request : Intranet Notification, Email notifications
		* Space Invitation :  Intranet Notification, Email notifications
		* Space Join Request:  Intranet Notification, Email notifications
		* Mention :  Intranet Notification, Email notifications
		* Comment :  Intranet Notification, Email notifications
		* Like :  	Intranet Notification, Email notifications
		* Post on my Steam : Intranet Notification, No Email notification
		* Post on my Space :  No Intranet Notification, Email notification
	 	Step 1 : Upgrade to 4.2
	 	Step 2 : Check notifications settings
	 		- Login with an admin
			- Go to Administration > Portal > Notifications
			- Check the administration
		--> The administration config is the same than in 4.1 in preconditions
	
	 *Pending because the Intranet Notification is available from 4.2, not from 4.1
	 * */
	@Test (groups = "pending")
	public void Test03_InitialAdministrationConfigurationIsKeptAfterUpgradingTo42(){
		
	}
	
	
}
