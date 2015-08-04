package org.exoplatform.selenium.platform.social.functional;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.social.MyNotificationsSetting.myNotiType;
import org.testng.annotations.Test;

public class SOC_Notification_Intranet_Connection_Request extends SOC_TestConfig2 {

		
	@Test 
	public void Test01_CheckConnectionRequestNotification(){
		info("Test 01: Check Connection Request notification");
		/*QmetryID:  135080         Check Connection Request notification
		- The notification "Someone sends me a connection request" is activated in User Settings
		- User A sent a connection request to User B
		Step 1
		- Login with User B
		- Click the notifications icon
		- Check the notification list
		*/
		info("Create users test");
		createNewUser(2);
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.ConnectionRequest_intranet);
		Utils.pause(3000);
		info("User A sent a connection request to User B");
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		Utils.pause(3000);
		
		
		/*
		 * Step 2
		- Check the notification message
		--> Expected result:  
			The notification message is :  
				- $AVATAR 
				- $USER wants to connect with you
				- $DATE 
				- 2 actions : [Accept] | [Refuse]
	
				Where : 
				- $AVATAR is thumbnail of User A
				- $USER is User A
				- $DATE is the date of the notification
		 */
		info("Log in with User B");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		String status=notiIntranetData.getMessageByArrayTypeRandom(2);
		Utils.pause(3000);
		navTool.goToIntranetNotification();
		intraNot.checkAvatarInStatus(arrayUser,true);
		intraNot.checkUsers(arrayUser,true);
		intraNot.checkStatus(status, arrayUser.get(0));
		intraNot.checkBtnConnectRequest(arrayUser.get(0));
		
		
		/*
		 * 	Step 3:
		- Click the notification area
		--> Expected: User B is redirected to the profile of User A
		 */
		intraNot.goToDetailRequestConnectionUser(arrayUser.get(0),true);
		info("Verify that User B is redirected to the profile of User A");
		waitForAndGetElement(userProPage.ELEMENT_PROFILE_TITLE.replace("${fullName}",arrayUser.get(0)));
		
	}
	
	@Test 
	public void Test02_AcceptAConnectionRequestFromTheNotification(){
		info("Test 02: Accept a Connection Request from the notification");
		/*	QmetryID: 125081
		 * Accept a Connection Request from the notification
			- The notification "Someone sends me a connection request" is activated in User Settings
			- User A sent a connection request to User B
			- Login with User B
			- Click notifications icon
			- Check the list
			Step 2:
			Click on Accept
			--> Expected: - The connection is approved, the 2 users are connected
			*/
		info("Create users test");
		createNewUser(2);
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.ConnectionRequest_intranet);
		Utils.pause(3000);
		info("User A sent a connection request to User B");
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		Utils.pause(3000);
		
		
		/*
		 * Step 3: 
			- Check the notification message
			--> Expected: After clicking Accept, the notification message is updated to :
				$AVATAR
				You are connected with $USER
				$DATE
	
				Where : 
				- $AVATAR is thumbnail of User A
				- $USER is User A
				- $DATE is the date of the notification
		 */
		info("Log in with User B");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		String status=notiIntranetData.getMessageByArrayTypeRandom(5);
		navTool.goToIntranetNotification();
		intraNot.acceptRqConnection(arrayUser.get(0));
		intraNot.checkStatus(status, arrayUser.get(0));
		
		info("Verify that User A and User B are friend");
		hp.goToConnections();
		connMag.verifyConnection(arrayUser.get(0),true);
		
		/*
		 * Step 4: 
			- Click the notification area
			--> Expected:- User B is redirected to the profile of User A
		 */
		navTool.goToIntranetNotification();
		intraNot.goToDetailAcceptRequestConnectionUser(arrayUser.get(0),true);
		//intraNot.goToDetailNotificationOnPopup();
		info("Verify that User B is redirected to the profile of User A");
		waitForAndGetElement(userProPage.ELEMENT_PROFILE_TITLE.replace("${fullName}",arrayUser.get(0)));
	}
	
	
	@Test 
	public void Test03_RefuseAConnectionRequestFromTheNotification(){
		info("Test 03: Refuse a Connection Request from the notification");
		/*
		 * QmetryID: 125082
		 * Refuse a Connection Request from the notification
		- The notification "Someone sends me a connection request" is activated in User Settings
		- User A sent a connection request to User B
		- Login with User B
		- Click notifications icon
		- Check the list
		- Click [Refuse]
				--> Expected: - The connection is not approved, the 2 users are not connected
				- The notification message is automatically hidden from the list
				
		- Go to View All page
				--> Expected: - The notification is not available / displayed in the View All page*/
		
		info("Create users test");
		createNewUser(2);
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.ConnectionRequest_intranet);
		Utils.pause(3000);
		info("User A sent a connection request to User B");
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		Utils.pause(3000);
		
		info("Log in with User B");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		String status=notiIntranetData.getMessageByArrayTypeRandom(5);
		navTool.goToIntranetNotification();
		intraNot.refuseRqConnection(arrayUser.get(0));
		intraNot.checkStatus(status, arrayUser.get(0));
		
		info("Verify that User A and User B are not friend");
		hp.goToConnections();
		connMag.verifyConnection(arrayUser.get(0), false);
		
		info("The notification is not available / displayed in the View All page");
		navTool.goToIntranetNotification();
		intraNot.goToAllNotification();
		intraNot.checkStatus(status, arrayUser.get(0));
	}
	
	
	@Test 
	public void Test04_CheckViewAllAfterAcceptingAConnectionRequest(){
		info("Test 04: Check View All after accepting a Connection Request");
		/*QmetryID: 125083
		Check View All after accepting a Connection Request
		Precondition: 
		- The notification "Someone sends me a connection request" is activated in User Settings
		- User A sent a connection request to User B
		Step 1: 
		- Login with User B
		- Click notifications icon
		- Check the list
		- Click [Accept]
		--> Expected: - The connection is approved, the 2 users are connected
					- The notification message is updated accordingly
		*/			
		info("Create users test");
		createNewUser(2);
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.ConnectionRequest_intranet);
		Utils.pause(3000);
		info("User A sent a connection request to User B");
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		Utils.pause(3000);
		
		info("Log in with User B");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		String status=notiIntranetData.getMessageByArrayTypeRandom(5);
		navTool.goToIntranetNotification();
		intraNot.acceptRqConnection(arrayUser.get(0));
		intraNot.checkStatus(status, arrayUser.get(0));
		
	    /*
	     * Step 2:
	     - Go to View All
	     --> Expected: - The notifications is displayed in the message
				- The message is displayed at the same position as the connection request 
	     */
		info("The notification is not available / displayed in the View All page");
		intraNot.goToAllNotification();
		intraNot.checkStatus(status, arrayUser.get(0));
	}
	
	@Test 
	public void Test05_CheckViewAllAfterrefusingAConnectionRequest(){
		info("Test 05: Check View All after refusing a Connection Request");
		/*QmetryID: 125084
		 * Check View All after refusing a Connection Request
		 * 
		 * - The notification "Someone sends me a connection request" is activated in User Settings
			- User A sent a connection request to User B
		 * - Login with User B
			- Click notifications icon
			- Check the list
			- Click [Refuse]
			- Go to View All
			--> Expected: - The notifications message is not displayed in the page
		 */
		
		info("Create users test");
		createNewUser(2);
		info("Log in with User A");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		info("goto My notification");
		navTool.goToMyNotifications();
		myNoti.enableNotification(myNotiType.ConnectionRequest_intranet);
		Utils.pause(3000);
		info("User A sent a connection request to User B");
		hp.goToConnections();
		connMag.connectToAUser(arrayUser.get(1));
		Utils.pause(3000);
		
		info("Log in with User B");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		String status=notiIntranetData.getMessageByArrayTypeRandom(5);
		navTool.goToIntranetNotification();
		intraNot.refuseRqConnection(arrayUser.get(0));
		
		info("The notification is not available / displayed in the View All page");
		intraNot.checkStatus(status, arrayUser.get(0));
	}
	
	
}
