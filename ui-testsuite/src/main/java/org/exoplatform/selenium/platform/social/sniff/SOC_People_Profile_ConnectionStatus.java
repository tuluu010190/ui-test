package org.exoplatform.selenium.platform.social.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class SOC_People_Profile_ConnectionStatus extends SOC_TestConfig{

	/**
	 *<li> Case ID:122961.</li>
	 *<li> Test Case Name: Check Connection Status between two users.</li>
	 *<li> Pre-Condition: test1 and test2 have not connected yet</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_CheckConnectionStatusBetweenTwoUsers() {
		info("Test 1: Check Connection Status between two users");
		/*Create data test*/
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String email1 = username1 + mailSuffixData.getMailSuffixRandom();
		String username2 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String email2 = username2 + mailSuffixData.getMailSuffixRandom();
		info("Add new user");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToAddUser();

		info("Add user " + username1);
		addUserPage.addUser(username1, username1, email1, username1, username1);
		addUserPage.addUser(username2, username2, email2, username2, username2);

		/*Step Number: 1
		 *Step Name: Step 1 : Go to profile page and check connection buttons
		 *Step Description: 
			- Login with test1
			- Go to test2 profile
			- Check the connection button displayed in the page
		 *Input Data: 

		 *Expected Outcome: 
			- The portlet shows a button "Connect"*/
		info("goto user2's profile");
		magAc.signIn(username1, username1);
		info("goto profile of user 2");
		hp.goToConnections();
		click(connMag.ELEMENT_ALL_CONNECTIONS_TAB);
		connMag.searchPeople(username2,null,null,null);
		click(connMag.ELEMENT_CONNECTION_USER_NAME.replace("${user}", username2));

		/*Step number: 2
		 *Step Name: Step 2: Send request to connect
		 *Step Description: 
			- click on button Connect
		 *Input Data: 

		 *Expected Outcome: 
			- The portlet shows a button Cancel Request*/
		click(myProfile.ELEMENT_UIMINICONNECTIONS_PORLET_CONNECT_STATUS);
		waitForAndGetElement(myProfile.ELEMENT_UIMINICONNECTIONS_PORLET_CANCEL_STATUS);

		/*Step number: 3
		 *Step Name: Step 3 : Check connection buttons
		 *Step Description: 
			- Login with test2
			- Go to test1 profile
			- Check the connection buttons displayed in the page
		 *Input Data: 

		 *Expected Outcome: 
			- The portlet shows two buttons : * Accept Request * Deny*/
		info("login as user 2");
		magAc.signIn(username2, username2);

		info("goto user1's profile");
		hp.goToConnections();
		click(connMag.ELEMENT_ALL_CONNECTIONS_TAB);
		connMag.searchPeople(username1,null,null,null);
		click(connMag.ELEMENT_CONNECTION_USER_NAME.replace("${user}", username1));
		waitForAndGetElement(myProfile.ELEMENT_UIMINICONNECTIONS_PORLET_ACCEPT_STATUS);
		waitForAndGetElement(myProfile.ELEMENT_UIMINICONNECTIONS_PORTLET_DENY_STATUS);

		/*Step number: 4
		 *Step Name: Step 4: Accept request
		 *Step Description: 
			- click on Accept Request
		 *Input Data: 

		 *Expected Outcome: 
			- The portlet shows a button Connected.
			- The button is labeled Connected with a tick icon.*/
		info("connect to user 1");
		click(myProfile.ELEMENT_UIMINICONNECTIONS_PORLET_ACCEPT_STATUS);
		waitForAndGetElement(myProfile.ELEMENT_UIMINICONNECTIONS_PORLET_CONNECTED_STATUS);

		/*Step number: 5
		 *Step Name: Step 5 : Mouseover on Connected
		 *Step Description: 
			- Mouseover the button Connected
		 *Input Data: 

		 *Expected Outcome: 
			- On mouse over, the button becomes Disconnect : * The icon to a disconnect icon* The label to Disconnect*/
		mouseOver(myProfile.ELEMENT_UIMINICONNECTIONS_PORLET_CONNECTED_STATUS,true);
		waitForAndGetElement(myProfile.ELEMENT_UIMINICONNECTIONS_PORLET_DISCONNECTED_STATUS);

		info("Clear Data");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username1);
		userAndGroup.deleteUser(username2);
	}
}