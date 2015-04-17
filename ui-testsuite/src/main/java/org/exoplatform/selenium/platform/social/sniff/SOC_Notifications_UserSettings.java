package org.exoplatform.selenium.platform.social.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.social.MyNotificationsSetting.myNotiType;
import org.testng.annotations.*;


	public class SOC_Notifications_UserSettings extends SOC_TestConfig{
		
	// configure mail send every 2' in exo.properties: 
    // exo.notification.NotificationDailyJob.expression=*/2 * * * *
	/**
	*<li> Case ID:121950.</li>
	*<li> Test Case Name: Notification Settings.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_NotificationSettings() {
		info("Test 1: Notification Settings");
		/*Step Number: 1
		*Step Name: Step 1: Access notification settings
		*Step Description: 
			- Login
			- Click full name of user and select [Notifications] on the menu
		*Input Data: 
			
		*Expected Outcome: 
			Notification setting page is shown with 2 main parts1. 
			Toggle buttons for Email and Intranet Notifications, by default set to YES
			2. A table contains all notification settings for the user.The columns are :
			- Notify me when: contains title of the notifications and categories
			- How to get notifications : the notification information and an edit button*/
		info("goto My notification");
		navTool.goToMyNotifications();
		
		waitForAndGetElement(myNotifPage.ELEMENT_SWITCH_ONOFF_MAIL_ON,5000,1,2);
		waitForAndGetElement(myNotifPage.ELEMENT_SWITCH_ONOFF_WEB_ON,5000,1,2);
		waitForAndGetElement(myNotifPage.ELEMENT_COLUMN_NOTIFYME);
		waitForAndGetElement(myNotifPage.ELEMENT_COLUMN_HOWTO);
		
		/*Step number: 2
		*Step Name: Step 2 : check edit
		*Step Description: 
			- Click edit button of a notification type
		*Input Data: 
			
		*Expected Outcome: 
			The edition options are : 
			- a checkbox to indicate that the user wants to receive the email notification instantly named "Send me an email right away"
			- a combo boxwith one of the following values :+ Never : to not include this notification in any digest + Daily : to include notifications of this type in the daily digestemail + Weekly : to include the notifications of this type in the weekly digest email
			- a checkbox to indicate if the user wants to receive Intranet Notifications named "See on My Intranet"A button [Save] is displayed to save the selection*/ 
		click(myNotifPage.ELEMENT_EDIT_NEWUSER_ICON);
		Utils.pause(1000);
		waitForAndGetElement(myNotifPage.ELEMENT_EDIT_NEWUSER_LIST_DAILY);
		waitForAndGetElement(myNotifPage.ELEMENT_EDIT_NEWUSER_LIST_WEEKLY);
		waitForAndGetElement(myNotifPage.ELEMENT_EDIT_NEWUSER_LIST_NEVER);
		waitForAndGetElement(myNotifPage.ELEMENT_EDIT_NEWUSER_MAIL_CHECKBOX);
		waitForAndGetElement(myNotifPage.ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX);
		waitForAndGetElement(myNotifPage.ELEMENT_EDIT_NEWUSER_SAVE_BTN);
 	}

	/**
	*<li> Case ID:121947.</li>
	*<li> Test Case Name: Update an Email notification option.</li>
	*<li> Pre-Condition: PLF server has mail configured </li>
	*<li> Post-Condition: </li>
	*/
	
	@Test
	public  void test04_UpdateAnEmailNotificationOption() {
		info("Test 04: Update an Email notification option");
		
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = username1;
		String email1 = username1 + mailSuffixData.getMailSuffixRandom();
		
		String username2 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password2 = username2;
		String email2 = username2 + mailSuffixData.getMailSuffixRandom();
		
		info("Go to My Profile");
		navTool.goToMyProfile();
		click(myProfile.ELEMENT_EDIT_MY_PROFILE_LINK);
		
		info("Change email address");
		Utils.pause(2000);
		myProfile.updateBasicInformation("", "", EMAIL_ADDRESS1);
		myProfile.saveCancelUpdateInfo(true);
		
		/*Step Number: 1
		*Step Name: Step 1: Email is sent when option is ticked
		*Step Description: 
			- Login with user A
			- Click username on the right of top navigation
			- Click Notifications
			- In column [How to get notifications], select 1 row (eg: Someone joins the social intranet) 
			- Click the edit button
			- Tick the check box "Send me an email right away"
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			The settings is saved*/
		info("setting send email when having new user");
		navTool.goToMyNotifications();
		myNotifPage.turnOnOffNotiEmail(true);
		myNotifPage.enableNotification(myNotiType.NewUser_email,"Daily");
		
		/*Step number: 2
		*Step Name: Step 2 : Check settings
		*Step Description: 
			- Login as an admin and create new user successfully
			- Check mailbox of User A
		*Input Data: 
			
		*Expected Outcome: 
			An email notification is sent*/
		info("add new user");
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);
		
		info("Check email notification");
		//Utils.pause(150000);
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		notiEmail.checkNewUserNotiEmail(username1,true);
		
		/*Step number: 3
		*Step Name: Step 2: Email is not sent when option is not ticked
		*Step Description: 
			- Login with User A
			- Go to Notification Setting screen again
			- Un
			-tick option in step 1
			- With an admin account create another new user
		*Input Data: 
			
		*Expected Outcome: 
			No notification email is sent.*/ 
		info("setting not send mail");
		switchToParentWindow();
		navTool.goToMyNotifications();
		myNotifPage.disableNotification(myNotiType.NewUser_email);
		
		info("add new user");
		navTool.goToAddUser();
		addUserPage.addUser(username2, password2, email2, username2, username2);
		
		info("Check email notification");
		//goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		notiEmail.checkNewUserNotiEmail(username2,false);
		
		info("restore data");
		switchToParentWindow();
		info("restore data");
		navTool.goToMyNotifications();
		myNotifPage.resetNotificationSetting();
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username1);
		userAndGroup.deleteUser(username2);
 	}

	/**
	*<li> Case ID:121949.</li>
	*<li> Test Case Name: Switch OFF Email Notifications.</li>
	*<li> Pre-Condition: - User A has activated Email Notifications on all type.</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_SwitchOFFEmailNotifications() {
		info("Test 05: Switch OFF Email Notifications");
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = username1;
		String email1 = username1 + mailSuffixData.getMailSuffixRandom();
		
		/*Step Number: 1
		*Step Name: Step 1: Access notification settings
		*Step Description: 
			- Login with user A
			- Click full name of user and select [Notifications] on the menu
		*Input Data: 
			
		*Expected Outcome: 
			- Notification Settings page is appeared*/
		info("goto My notification page");
		navTool.goToMyNotifications();
		
		/*Step number: 2
		*Step Name: Step 2: Switch OFF Email Notifications
		*Step Description: 
			- Switch on NO the toggle "Get Email Notifications"
		*Input Data: 
			
		*Expected Outcome: 
			- The email notification settings is disabled is hidden. 
			- The user settings related to Email are disabled in the table*/
		info("turn off send email");
		myNotifPage.turnOnOffNotiEmail(false);
		waitForAndGetElement(myNotifPage.ELEMENT_MAIL_VIEWMODE_FALSE,2000,1,2);
		
		/*Step number: 3
		*Step Name: Step 3 : Check Email Notification disabled
		*Step Description: 
			- Generate an email notification activated previously by the user
		*Input Data: 
			
		*Expected Outcome: 
			- No email notifications are sent*/ 
		info("add new user");
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);
		
		info("Check email notification");
		notiEmail.checkNewUserNotiEmail(username1,false,true);
		
		info("restore data");
		switchToParentWindow();
		info("restore data");
		navTool.goToMyNotifications();
		myNotifPage.resetNotificationSetting();
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username1);
 	}

	
	/**
	*<li> Case ID:122973.</li>
	*<li> Test Case Name: Switch OFF Intranet Notifications.</li>
	*<li> Pre-Condition: - User A has activated Intranet Notifications on all type.</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_SwitchOFFIntranetNotifications() {
		info("Test 03: Switch OFF Intranet Notifications");
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = username1;
		String email1 = username1 + mailSuffixData.getMailSuffixRandom();
		
		/*Step Number: 1
		*Step Name: Step 1: Access notification settings
		*Step Description: 
			- Login with user A
			- Click full name of user and select [Notifications] on the menu
		*Input Data: 
			
		*Expected Outcome: 
			- Notification Settings page is appeared*/
		info("goto My notification page");
		navTool.goToMyNotifications();
		
		/*Step number: 2
		*Step Name: Step 2: Switch OFF Intranet Notifications
		*Step Description: 
			- Switch on NO the toggle "Get Intranet Notifications"
		*Input Data: 
			
		*Expected Outcome: 
			- The intranet notifications settings are disabled.
			- The user settings related to Intranet are disabled in the table*/
		/*myNotifPage.turnOnOffNotiIntranet(true);
		myNotifPage.enableNotification(myNotiType.NewUser_intranet);*/
		
		info("turn off intranet notifications");
		myNotifPage.turnOnOffNotiIntranet(false);
		waitForAndGetElement(myNotifPage.ELEMENT_WEB_VIEWMODE_FALSE);
		
		/*Step number: 3
		*Step Name: Step 3 : Check Intranet Notification disabled
		*Step Description: 
			- Generate an intranet notification activated previously by the user
		*Input Data: 
			
		*Expected Outcome: 
			- No intranet notifications are sent or displayed in the Intranet*/ 
		info("add new user");
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);
		Utils.pause(2000);
		
		info("Check intranet notification");
		waitForElementNotPresent(navTool.ELEMENT_TOOLBAR_NOTIFICATION_LIST);
		waitForElementNotPresent(navTool.ELEMENT_NOTIFICATION_LIST_USER.replace("${user}", username1));
		
		info("restore data");
		navTool.goToMyNotifications();
		myNotifPage.resetNotificationSetting();
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username1);
 	}

	/**
	*<li> Case ID:122974.</li>
	*<li> Test Case Name: Update an Intranet notification option.</li>
	*<li> Pre-Condition: PLF server has mail configured</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_UpdateAnIntranetNotificationOption() {
		info("Test 02: Update an Intranet notification option");
		String mention = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String mention2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		*Step Name: Step 1: Email is sent when option is ticked
		*Step Description: 
			- Login with user A
			- Click username on the right of top navigation
			- Click Notifications
			- In column [How to get notifications], select 1 row (eg: Someone mentions you) 
			- Click the edit button
			- Tick the check box "See on My Intranet"
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			The settings is saved*/
		info("goto My notification page");
		navTool.goToMyNotifications();
		myNotifPage.enableNotification(myNotiType.Mention_intranet);
		
		/*Step number: 2
		*Step Name: Step 2 : Check settings
		*Step Description: 
			- Login with User B and mention User A
			- Login with User A and check notification list in the top navigation
		*Input Data: 
			
		*Expected Outcome: 
			An intranet notification is displayed in the list*/
		info("login by another user");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		
		info("add mention");
		hpAct.addActivity(DATA_USER1,mention);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_MENTION_USER.replace("${content}", mention).replace("${user}",DATA_USER1));
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		info("Check intranet notification");
		navTool.goToNotificationList();
		String text=waitForAndGetElement(navTool.ELEMENT_NOTIFICATION_LIST_USER.replace("${user}",DATA_NAME_USER2)).getText();
		assert text.contains(DATA_NAME_USER2+" has mentioned you.");
		click(navTool.ELEMENT_NOTIFICATION_REMOVE_ICON);
		
		/*Step number: 3
		*Step Name: Step 2: Email is not sent when option is not ticked
		*Step Description: 
			- Login with User A
			- Go to Notification Setting screen again
			- Un
			-tick option in step 1
			- With User B, mention again User A new user
		*Input Data: 
			
		*Expected Outcome: 
			No intranet notification is displayed in the notifications list.*/ 
		info("goto My notification page");
		navTool.goToMyNotifications();
		myNotifPage.disableNotification(myNotiType.Mention_intranet);
		
		info("login by another user");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		
		info("add mention");
		hpAct.addActivity(DATA_USER1,mention2);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_MENTION_USER.replace("${content}", mention2).replace("${user}",DATA_USER1));
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		info("Check intranet notification");
		navTool.goToNotificationList();
		waitForElementNotPresent(navTool.ELEMENT_NOTIFICATION_LIST_USER.replace("${user}", DATA_NAME_USER2));
		info("restore data");
		navTool.goToMyNotifications();
		myNotifPage.resetNotificationSetting();
		
 	}
    
}