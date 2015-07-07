package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ConnectionsManagement.selectTabOption;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class SOC_People_Activity_View extends SOC_TestConfig{

	/**
	 *<li> Case ID:122639.</li>
	 *<li> Test Case Name: View activity of user who is not friend.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_ViewActivityOfUserWhoIsNotFriend() {
		info("Test 1: View activity of user who is not friend");
		/*Create data test*/
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = username1;
		String email1 = username1 + mailSuffixData.getMailSuffixRandom();
		String textDes = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String link = lnkData.getLinkByArrayTypeRandom(1);

		info("Add new user");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);

		/*Step Number: 1
		 *Step Name: Step 1: View user activities
		 *Step Description: 
			- Sign in system
			- Access Activities page on User Toolbar portlet in the upper right corner of the screen
			- Select Activity in the left pane
		 *Input Data: 

		 *Expected Outcome: 
			Show content of activities gadget:
			- Text area: allow user compose and new activities, share link
			- Attach link: allow user can share a link
			- All Updates: show all activities of user. They are displayed in order from the newest to the oldest
			- Network Updates: show all activities of users friends. They are displayed in order from the newest to the oldestBy default, if there is no one activity on list, show message to user knows: user does not have any updates yetWith each activity, other users can comment, like/unlike.
			- Space Updates : show all activities of space you joined.
			- My Status : show all your activities*/
		navTool.goToMyActivities();
		hpAct.addActivity(textDes, link);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TITLE.replace("${text}",textDes).replace("${file}",link));

		/*Step number: 2
		 *Step Name: Step 2: View other user activity
		 *Step Description: 
			- AccessPeople page
			- Select an user who isn't users friend and click on name 
			- Select activity
		 *Input Data: 

		 *Expected Outcome: 
			Show all activities of user. Logged in User can't see the text box to add activities*/ 
		magAc.signIn(username1, password1);
		hp.goToConnections();
		connMag.goToConnectionTab(selectTabOption.ALL);
		connMag.goToUser(DATA_NAME_USER1);
		uBase.goToActivityTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TITLE.replace("${text}",textDes).replace("${file}",link));
		waitForElementNotPresent(hpAct.ELEMENT_COMPOSER_INPUT_FILED,5000);
	}

	/**
	 *<li> Case ID:122638.</li>
	 *<li> Test Case Name: View activity of user who is not friend but has common connection.</li>
	 *<li> Pre-Condition: User A and User B are connected
	 *User B and User C are connected
	 *User A and User C are NOT connected</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test02_ViewActivityOfUserWhoIsNotFriendButHasCommonConnection() {
		info("Test 2: View activity of user who is not friend but has common connection");
		/*Create data test*/
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = username1;
		String email1 = username1 + mailSuffixData.getMailSuffixRandom();
		
		String username2 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password2 = username2;
		String email2 = username2 + mailSuffixData.getMailSuffixRandom();

		info("Add new user");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);
		addUserPage.addUser(username2, password2, email2, username2, username2);
		info("Click on Connections on the left panel");
		hp.goToConnections();
		info("Access people list, invite an user");
		connMag.connectToAUser(username1);
		hp.goToConnections();
		info("Access people list, invite an user");
		connMag.connectToAUser(username2);
		info("Invited user accept invitation");
		magAc.signIn(username1, password1);
		hp.goToConnections();	
		connMag.acceptAConnection(DATA_USER1);
		info("Verify after accept");
		connMag.verifyConnection(DATA_USER1, true);
		info("Invited user accept invitation");
		magAc.signIn(username2, password2);
		hp.goToConnections();	
		connMag.acceptAConnection(DATA_USER1);
		info("Verify after accept");
		connMag.verifyConnection(DATA_USER1, true);

		/*Step Number: 1
		 *Step Name: Step 1: Post an activity
		 *Step Description: 
			- Login with user A
			- Go to Activities Stream of user B
			- Post an activity with content "Hello user B from user A"
		 *Input Data: 

		 *Expected Outcome: 
			The activity of user A "Hello user B from user A" is posted on activity stream of user B*/
		magAc.signIn(username1, password1);
		hp.goToConnections();
		connMag.goToConnectionTab(selectTabOption.ALL);
		connMag.goToUser(DATA_NAME_USER1);
		uBase.goToActivityTab();
		String activity1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hpAct.addActivity(activity1, "");
		
		/*Step number: 2
		 *Step Name: Step 2: View activity stream of user B
		 *Step Description: 
			- Login with user B
			- Check on activity stream of user B
		 *Input Data: 

		 *Expected Outcome: 
			The activity of user A "Hello user B from user A" is shown in Activities Stream of user B.*/
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToMyActivities();
		waitForAndGetElement(By.xpath(hpAct.ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", activity1)));
		
		/*Step number: 3
		 *Step Name: Step 3: View activity stream of user C
		 *Step Description: 
			- Login with user C
			- Check on activity stream of user C
		 *Input Data: 

		 *Expected Outcome: 
			The activity of user A "Hello user B from user A" is shown in Activities Stream of user C.*/ 
		magAc.signIn(username2, password2);
		hp.goToConnections();
		connMag.goToConnectionTab(selectTabOption.ALL);
		connMag.goToUser(DATA_NAME_USER1);
		uBase.goToActivityTab();
		waitForAndGetElement(By.xpath(hpAct.ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", activity1)));
	}
}