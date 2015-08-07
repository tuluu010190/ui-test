package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.*;


public class SOC_Notification_Intranet_Mention extends SOC_TestConfig2{

	/**
	 *<li> Case ID:125102.</li>
	 *<li> Test Case Name: Check Mention notifications (in activity message).</li>
	 *<li> Case ID:125105.</li>
	 *<li> Test Case Name: Click the Mention notifications (in activity message).</li>
	 *<li> Pre-Condition: User A has mentioned User B directly in the activity message</li>
	 *<li> Post-Condition: </li>
	 * @throws AWTException 
	 */
	@Test
	public  void test01_04_CheckMentionNotificationInActivityMessage() throws AWTException{
		info("Test 1: Check Mention notifications (in activity message)");
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String email1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();

		/*Create data test*/
		info("Add new user");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);
		hp.goToHomePage();
		String activity1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hpAct.mentionUserActivity(username1, activity1);
		
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Login with User B
			- Click the notification icons in the top navigation
			- Check the notification list
		 *Input Data: 

		 *Expected Outcome: 
			- The Mention notification is displayed in the list*/
		magAc.signIn(username1, password1);
		navTool.goToIntranetNotification();
		
		/*Step number: 2
		 *Step Name: 
		 *Step Description: 
			- Check the notification message
		 *Input Data: 

		 *Expected Outcome: 
			The notification message is : $AVATAR$USER has mentioned you $ACTIVITY$DATEWhere :
			- $AVATAR is the thumbnail of User A
			- $USER is User A
			- $ACTIVITY is the activity title/message
			- $DATE is the date of the notification*/ 
		 ArrayList<String> users = new ArrayList<String>();
		 users.add(DATA_USER1);
		 String status = notiIntranetData.getContentByArrayTypeRandom(7);
		 intraNot.checkAvatarInStatus(users,true);
		 intraNot.checkStatus(status,DATA_USER1);
		 intraNot.checkActivityTitleInStatus(activity1, true);
		
		info("Test 4: Click the Mention notifications (in activity message)");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Login with User B
			- Click the notification icons in the top navigation
			- Check the notification list
		 *Input Data: 

		 *Expected Outcome: 
			- The Mention notification is displayed in the list*/

		/*Step number: 2
		 *Step Name: 
		 *Step Description: 
			- Click the notification
		 *Input Data: 

		 *Expected Outcome: 
			- The user is redirected to the activity viewer with all comment expanded.*/ 
		 intraNot.checkAvatarInStatus(users,true);
		 intraNot.checkStatus(status,DATA_USER1);
		 intraNot.checkActivityTitleInStatus(activity1, true);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_MENTION_USER.replace("${content}", activity1).replace("${user}",username1));
	}

	/**
	 *<li> Case ID:125103.</li>
	 *<li> Test Case Name: Check Mention notifications (in comment).</li>
	 *<li> Case ID:125104.</li>
	 *<li> Test Case Name: Click the Mention notifications (in comment).</li>
	 *<li> Pre-Condition: - An wiki activity is generated (create a new page)
	- User A has mentioned User B directly in a comment</li>
	 *<li> Post-Condition: </li>
	 * @throws AWTException 
	 */
	@Test
	public  void test02_05_CheckMentionNotificationsInComment() throws AWTException {
		info("Test 1: Check Mention notifications (in activity message)");
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String email1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();

		/*Create data test*/
		info("Add new user");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);
		hp.goToHomePage();
		String activity1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hpAct.addActivity(activity1, "");
		String comment=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hpAct.addCommentWithMentionUser(activity1,username1, comment);
	
		info("Test 2: Check Mention notifications (in comment)");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Login with User B
			- Click the notification icons in the top navigation
			- Check the notification list
		 *Input Data: 

		 *Expected Outcome: 
			- The Mention notification is displayed in the list*/
		magAc.signIn(username1, password1);
		navTool.goToIntranetNotification();
		
		/*Step number: 2
		 *Step Name: 
		 *Step Description: 
			- Check the notification message
		 *Input Data: 

		 *Expected Outcome: 
			The notification message is : $AVATAR$USER has mentioned you $ACTIVITY$DATEWhere :
			- $AVATAR is the thumbnail of User A
			- $USER is User A
			- $ACTIVITY is the name of the wiki page
			- $DATE is the date of the notification*/ 
		 ArrayList<String> users = new ArrayList<String>();
		 users.add(DATA_USER1);
		 String status = notiIntranetData.getContentByArrayTypeRandom(7);
		 intraNot.checkAvatarInStatus(users,true);
		 intraNot.checkStatus(status,DATA_USER1);
		 intraNot.checkActivityTitleInStatus(activity1, true);
		//intraNot.checkUnreadMentionNotification(DATA_NAME_USER1, activity1, intraNot.ELEMET_JUST_NOW_STRING);
		
		info("Test 5: Click the Mention notifications (in comment)");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Login with User B
			- Click the notification icons in the top navigation
			- Check the notification list
		 *Input Data: 

		 *Expected Outcome: 
			- The Mention notification is displayed in the list*/

		/*Step number: 2
		 *Step Name: 
		 *Step Description: 
			- Click the notification
		 *Input Data: 

		 *Expected Outcome: 
			- The user is redirected to the activity viewer with all comment expanded. 
			- The comment where the mention has been done is highlighted*/ 
		 intraNot.goToDetailMentionNotification(DATA_NAME_USER1, true);
		 notiAct.checkCommentExpand(comment,true);

	}

	/**
	 *<li> Case ID:125106.</li>
	 *<li> Test Case Name: Check View All after receiving a Mention notification.</li>
	 *<li> Pre-Condition: User A has mentioned User B</li>
	 *<li> Post-Condition: </li>
	 * @throws AWTException 
	 */
	@Test
	public  void test03_CheckViewAllAfterReceivingAMentionNotification() throws AWTException {
		info("Test 3: Check View All after receiving a Mention notification");
		String username1 = txData.getContentByArrayTypeRandom(4) + getRandomString();
		String password1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String email1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();

		/*Create data test*/
		info("Add new user");
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, username1, username1);
		hp.goToHomePage();
		String activity1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hpAct.mentionUserActivity(username1, activity1);

		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Login with User B
			- Click the notification icons in the top navigation
			- Check the notification list
		 *Input Data: 

		 *Expected Outcome: 
			- The Mention notification is displayed in the list*/
		magAc.signIn(username1, password1);
		navTool.goToIntranetNotification();
		String status = notiIntranetData.getContentByArrayTypeRandom(7);
		intraNot.checkStatus(status,DATA_NAME_USER1);
		
		/*Step number: 2
		 *Step Name: 
		 *Step Description: 
			- Go to View All page
		 *Input Data: 

		 *Expected Outcome: 
			- The Mention notification is displayed / available in the page*/ 
		intraNot.goToAllNotification();
		intraNot.checkStatus(status,DATA_NAME_USER1);
	}
}
