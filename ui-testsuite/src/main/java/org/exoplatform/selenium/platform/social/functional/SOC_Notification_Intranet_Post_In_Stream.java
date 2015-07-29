package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.social.MyNotificationsSetting.myNotiType;
import org.testng.annotations.*;


	public class SOC_Notification_Intranet_Post_In_Stream extends SOC_TestConfig2{

	/**
	*<li> Case ID:125138.</li>
	*<li> Test Case Name: Check Post on my Stream notification.</li>
	*<li> Pre-Condition: - User A has posted an activity on User B activity stream
	- The notification "Someone posts a message on my activity stream" is activated in the user settings</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckPostOnMyStreamNotification() {
		info("Test 1: Check Post on my Stream notification");
		/*Step Number: 1
		*Step Name: Step 1 : Check notification list
		*Step Description: 
			- Login with User B
			- Click the notifications icon in the top navigation
			- Check the notifications list
		*Input Data: 
			
		*Expected Outcome: 
			- A Post on my Stream notifications is displayed in the list*/
		info("Create 2 users test");
		createNewUser(2);
		
		info("User A login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.Post_intranet);
		
		
		info("User A sent a connection request to User B");
		Utils.pause(3000);
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		
		info("User B login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		
		info("User A and User B are connected");
		Utils.pause(3000);
		hp.goToConnections();
		connMag.acceptAConnection(arrayUser.get(0));
		
		info("User B add an activity on User A's stream");
		String activity = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		hp.goToFriendProfilePage(arrayUser.get(0));
		userProPage.goToActivity();
		Utils.pause(3000);
		hpAct.addActivity(activity,null);
		hpAct.checkActivity(activity);
		
		
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		
		

		/*Step number: 2
		*Step Name: Step 2 : Check notification message
		*Step Description: 
			- Check the notification message
		*Input Data: 
			
		*Expected Outcome: 
			The notification message is :$AVATAR$USER has posted on your activity stream$ACTIVITY$DATEWhere : 
			- $AVATAR is the thumbnail of User A
			- $USER is User A
			- $ACTIVITY is the activity title / message
			- $DATE is the date of the notification*/ 
		info(" Go to Intranet Notification");
		navTool.goToIntranetNotification();
		String status=notiIntranetData.getContentByArrayTypeRandom(8);
		intraNot.checkStatus(status, arrayUser.get(1));
		intraNot.checkAvatarInStatus(arrayUser.get(1), true);
		intraNot.checkActivityTitleInStatus(activity, true);

 	}

	/**
	*<li> Case ID:125139.</li>
	*<li> Test Case Name: Click Post on my Stream notification.</li>
	*<li> Pre-Condition: - User A has posted an activity on User B activity stream
	- The notification "Someone posts a message on my activity stream" is activated in the user settings</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_ClickPostOnMyStreamNotification() {
		info("Test 2: Click Post on my Stream notification");
		/*Step Number: 1
		*Step Name: Step 1 : Check notification list
		*Step Description: 
			- Login with User B
			- Click the notifications icon in the top navigation
			- Check the notifications list
		*Input Data: 
			
		*Expected Outcome: 
			- A Post on my Stream notifications is displayed in the list*/
		info("Create 2 users test");
		createNewUser(2);
		
		info("User A login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.Post_intranet);
		
		
		info("User A sent a connection request to User B");
		Utils.pause(3000);
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		
		info("User B login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		
		info("User A and User B are connected");
		Utils.pause(3000);
		hp.goToConnections();
		connMag.acceptAConnection(arrayUser.get(0));
		
		info("User B add an activity on User A's stream");
		String activity = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		hp.goToFriendProfilePage(arrayUser.get(0));
		userProPage.goToActivity();
		Utils.pause(3000);
		hpAct.addActivity(activity,null);
		hpAct.checkActivity(activity);
		
		

		/*Step number: 2
		*Step Name: Step 2 : View the notification
		*Step Description: 
			- Click the notification area
		*Input Data: 
			
		*Expected Outcome: 
			The activity is displayedin the activity viewer with all comments expanded*/ 
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		
		info(" Go to Intranet Notification");
		navTool.goToIntranetNotification();
		String status=notiIntranetData.getContentByArrayTypeRandom(8);
		intraNot.checkStatus(status, arrayUser.get(1));
		intraNot.goToDetailPostInMyActivity(arrayUser.get(1),true);
		notiAct.checkTitleActivityExpand(activity);

 	}

	/**
	*<li> Case ID:125140.</li>
	*<li> Test Case Name: Check View All after receiving a Post on my Stream notification.</li>
	*<li> Pre-Condition: - User A has posted an activity on User B activity stream
	- The notification "Someone posts a message on my activity stream" is activated in the user settings</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckViewAllAfterReceivingAPostOnMyStreamNotification() {
		info("Test 3: Check View All after receiving a Post on my Stream notification");
		/*Step Number: 1
		*Step Name: Step 1 : Check notification list
		*Step Description: 
			- Login with User B
			- Click the notifications icon in the top navigation
			- Check the notifications list
		*Input Data: 
			
		*Expected Outcome: 
			- A Post on my Stream notifications is displayed in the list*/
		info("Create 2 users test");
		createNewUser(2);
		
		info("User A login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.Post_intranet);
		
		
		info("User A sent a connection request to User B");
		Utils.pause(3000);
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		
		info("User B login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		
		info("User A and User B are connected");
		Utils.pause(3000);
		hp.goToConnections();
		connMag.acceptAConnection(arrayUser.get(0));
		
		info("User B add an activity on User A's stream");
		String activity = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		hp.goToFriendProfilePage(arrayUser.get(0));
		userProPage.goToActivity();
		Utils.pause(3000);
		hpAct.addActivity(activity,null);
		hpAct.checkActivity(activity);

		/*Step number: 2
		*Step Name: Step 2 : Check in View all page
		*Step Description: 
			- Go to View All
		*Input Data: 
			
		*Expected Outcome: 
			- Post of my Stream notification is displayed / available in the page*/ 
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		
		info(" Go to Intranet Notification");
		navTool.goToIntranetNotification();
		String status=notiIntranetData.getContentByArrayTypeRandom(8);
		intraNot.goToAllNotification();
		intraNot.checkStatus(status, arrayUser.get(1));

 	}}