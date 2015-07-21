package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.social.NotificationsAdminSeting.notificationType;
import org.testng.annotations.*;


	public class SOC_Notification_intranet_Administration extends SOC_TestConfig1{

	/**
	*<li> Case ID:125059.</li>
	*<li> Test Case Name: Check second section: Email Notifications Sender.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckSecondSectionEmailNotificationsSender() {
		info("Test 1: Check second section: Email Notifications Sender");
		/*Step Number: 1
		*Step Name: Step 1: Access notification Administration
		*Step Description: 
			- Login as admin 
			- Move mouse over:Administration > Portal > Notifications
		*Input Data: 
			
		*Expected Outcome: 
			- Notification Administration page is displayed*/
		info("Go to Notification Administration");
		navTool.goToAdminNotifications();
		info("Notifications Administration page is displayed");
        waitForAndGetElement(notiAdmin.ELEMENT_TITLE_EMAIL_NOTIFICATIONS);

		/*Step number: 2
		*Step Name: Step 2: Check the 2nd section
		*Step Description: 
			- Check the 2nd section at the bottom of the page: Email Notifications Sender
		*Input Data: 
			
		*Expected Outcome: 
			- Notification sender is used to define the From field of notification email: Name and Address*/
        info("Verify that Notification sender is used to define the From field of notification email: Name and Address");
        waitForAndGetElement(notiAdmin.ELEMENT_ADMIN_NOTIFICATION_SENDER_NAME);
        waitForAndGetElement(notiAdmin.ELEMENT_ADMIN_NOTIFICATION_SENDER_ADDRESS);
 	}

	/**
	*<li> Case ID:125060.</li>
	*<li> Test Case Name: Check the first section: Notification types.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckTheFirstSectionNotificationTypes() {
		info("Test 2: Check the first section: Notification types");
		/*Step Number: 1
		*Step Name: Step 1: Access notification Administration
		*Step Description: 
			- Login as admin 
			- Move mouse over:Administration > Portal > Notifications
		*Input Data: 
			
		*Expected Outcome: 
			- Notification Administration page is displayed*/
		info("Go to Notification Administration");
		navTool.goToAdminNotifications();
		info("Notifications Administration page is displayed");
        waitForAndGetElement(notiAdmin.ELEMENT_TITLE_EMAIL_NOTIFICATIONS);

		/*Step number: 2
		*Step Name: Step 2: Check the first section
		*Step Description: 
			- Check the first section in page
		*Input Data: 
			
		*Expected Outcome: 
			- The second section is: 
			Notification Types allows to enable/disable globally all the notification types.*/
        info("Verify that Notification Types allows to enable/disable globally all the notification types. ");
        waitForAndGetElement(notiAdmin.ELEMENT_ENABLE_NOTIFICATION_GRID);

 	}

	/**
	*<li> Case ID:125062.</li>
	*<li> Test Case Name: Access notification Administration.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_AccessNotificationAdministration() {
		info("Test 3: Access notification Administration");
		/*Step Number: 1
		*Step Name: Step 1: Access notification Administration
		*Step Description: 
			- Login as admin (belongs to the group: *:/platform/administrators)
			- Move mouse over:Administration > Portal > Notifications
		*Input Data: 
			
		*Expected Outcome: 
			- Notification Administration page is displayed*/ 
		info("Go to Notification Administration");
		navTool.goToAdminNotifications();
		info("Notifications Administration page is displayed");
        waitForAndGetElement(notiAdmin.ELEMENT_TITLE_EMAIL_NOTIFICATIONS);

 	}

	/**
	*<li> Case ID:125063.</li>
	*<li> Test Case Name: Check deactivate notification from Administration.</li>
	*<li> Pre-Condition: - The user is admin
	- New User notifications is selected in the User Settings</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CheckDeactivateNotificationFromAdministration() {
		info("Test 4: Check deactivate notification from Administration");
		resetNotifitcaiton=true;
		/*Step Number: 1
		*Step Name: Step 1 : Deactivate notification type
		*Step Description: 
			- Login with an admin account
			- Go to Administration > Portal > Notifications
			- Go to New User row
			- Click edit and untick Intranet Notification
			- Click save
		*Input Data: 
			
		*Expected Outcome: 
			- New user Intranet notifications is disabled*/
		info("Go to Notification Administration");
		navTool.goToAdminNotifications();
		info("Notifications Administration page is displayed");
        waitForAndGetElement(notiAdmin.ELEMENT_TITLE_EMAIL_NOTIFICATIONS);
        
        notiAdmin.disableNotification(notificationType.NewUser_intranet);

		/*Step number: 2
		*Step Name: Step 2 : Go to User settings
		*Step Description: 
			- Go to User menu and [My Notifications]
			- Check the notification row : New User
		*Input Data: 
			
		*Expected Outcome: 
			- The label "See on My intranet" is not displayed in the row*/
        navTool.goToMyNotifications();
        info("The label See on My intranet is not displayed in the row");
        waitForElementNotPresent(myNoti.ELEMENT_NEWUSER_ICON_INTRANET_NOTIFICATION);
        
        

		/*Step number: 3
		*Step Name: Step 3 : Edit and check
		*Step Description: 
			- Click edit
		*Input Data: 
			
		*Expected Outcome: 
			- The label "See on My intranet" is not available in the edit section*/ 
        click(myNoti.ELEMENT_EDIT_NEWUSER_ICON);
        waitForElementNotPresent(myNoti.ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX);

 	}}