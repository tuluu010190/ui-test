package org.exoplatform.selenium.platform.social.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePageActivity;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.ManageAccount.userType;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.UserGroupManagement;
import org.exoplatform.selenium.platform.social.Activity;
import org.exoplatform.selenium.platform.social.ManageMember;
import org.exoplatform.selenium.platform.social.Notification;
import org.exoplatform.selenium.platform.social.PeopleConnection;
import org.exoplatform.selenium.platform.social.PeopleProfile;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thuntn
 * @date 04/06/2014
 *
 */
public class Social_EmailNotifications_NotificationType extends Notification {
	//Platform
	ManageAccount magAcc;
	NavigationToolbar navToolBar;
	UserGroupManagement userGroup;
	PeopleConnection peo;
	PeopleProfile pepPro;
	Activity act;
	HomePageActivity hpact;
	SpaceManagement sp;
	ManageMember mgMem;

	String user = "John Smith";
	String user1="Mary Williams";
	String user2="Jack Miller";
	String user3="James Davis";

	@BeforeMethod
	public void beforeMethods() {
		initSeleniumTest();
		driver.get(baseUrl);
		magAcc = new ManageAccount(driver,this.plfVersion);
		navToolBar = new NavigationToolbar(driver,this.plfVersion);
		magAcc.signIn(DATA_USER1, DATA_PASS);
		userGroup = new UserGroupManagement(driver);
		peo = new PeopleConnection(driver);
		act = new Activity(driver,this.plfVersion);
		hpact = new HomePageActivity(driver,this.plfVersion);
		sp = new SpaceManagement(driver, plfVersion);
		mgMem = new ManageMember(driver, plfVersion);
		pepPro = new PeopleProfile(driver);
	}

	@AfterMethod
	public void afterMethods() {
		info("Logout portal");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 * Case ID:109851.
	 * Test Case Name: Connect request notification mail.
	 * Pre-Condition: 
	 * Post-Condition: 
	- Login as user1
	- Go to Connections page and send request to user2
	- $PORTAL_NAME = Social intranet for ex
	- $FIRSTNAME = user2
	- Notification mail is sent to user2
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 */
	@Test
	public  void test01_ConnectRequestNotificationMail() {
		info("Test 01 Connect request notification mail");
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_NEW_USER.replace("${user}", user1)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_NEW_USER.replace("${user}", user2)));
		//Update email
		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);

		//Send connection request to John
		magAcc.userSignIn(userType.PUBLISHER);

		navToolBar.goToConnectionPage();
		peo.connectPeople(user);
		
		//Send connection request to John
		magAcc.userSignIn(userType.DEVELOPER);
		navToolBar.goToConnectionPage();
		peo.connectPeople(user);

		magAcc.userSignIn(userType.ADMIN);
		/*
		- Check notification mail format
		 *Expected Outcome: 
		- The notification mail format is: New connection requestHi user2,[Avatar of user1] user1 has sent you a connection request. Accept the connection request and start collaborating with user1?Accept | Refuse		*/
		
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}",MSG_CONNECTION_REQUEST_SUBJECT));
		checkEmailNotification(MSG_CONTENT_EMAIL_CONNECTION_REQUEST.replace("${user}", user1), "John","Accept","Refuse");

		/*Click [Accept]
		 *Input Data: 
		 *Expected Outcome: Approve the connection and will take the user to the activity stream of the new connection		*/

		click(By.linkText("Accept"));

		switchToNewWindow();
		waitForAndGetElement(ELEMENT_USER_ACTIVIY_ACTIVE.replace("${user}", "mary"));

		/*Click [Refuse]
		 *Input Data: 
		 *Expected Outcome: Deny the connection request and will take the user to the connection requests list. A Feedback message will display : You refused $USER connection request.		*/ 

		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail2);
		click(By.linkText("Refuse"));

		switchToNewWindow();
		waitForAndGetElement(ELEMENT_MESSAGE_REFUSE_CONNECTION_REQUEST.replace("${user}", user2));
		waitForAndGetElement(peo.ELEMENT_REQUESTS_RECEIVED_TAB);

		//Restore data
		click(peo.ELEMENT_EVERYONE_TAB);
		peo.removeConnection(user1);

		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		waitForElementNotPresent(eEmail2);
	}

	/**
	 * Case ID:109852.
	 * Test Case Name: Check Like notification mail content.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 * Bug: SOC-4319
	 */
	@Test(groups="error")
	public  void test02_CheckLikeNotificationMailContent() {
		info("Test 2 Check Like notification mail content");
		String activity = "Activity1 109852";
		String activity2 = "Activity2 109852";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_LIKE_ACTIVITY.replace("${user}", user1).replace("${activity}", activity)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}",  MSG_TITLE_EMAIL_LIKE_ACTIVITY.replace("${user}", user1).replace("${activity}", activity2)));
		String comment1 = "comment 01";
		String comment2 = "comment 02";
		String comment3 = "comment 03";
		
		//Update email
		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);

		navToolBar.goToConnectionPage();
		peo.connectPeople(user1);

		//Enable notification for "like activity" 
		navToolBar.goToNotificationSettings();
		enableSendNotificationRight(MSG_ACTIVITY_LIKE_MY_ACTIVITY, true);

		/*- Login as UserA
		- Add new activity
		 *Expected Outcome: 
		- New activity is added		*/
		navToolBar.goToHomePage();
		act.addActivity(true, activity, false, "");
		act.addActivity(true, activity2, false, "");
		act.addComment(activity2, comment1);
		act.addComment(activity2, comment2);
		act.addComment(activity2, comment3);


		/*	- Login as UserB
		- Like UserA's activity at step 1
		 *Input Data: 
		 *Expected Outcome: 
		- Like activity successfully
		- Notification mail is sent to UserA	*/	
		magAcc.userSignIn(userType.PUBLISHER);
		
		//Accept connection request
		navToolBar.goToConnectionPage();
		peo.acceptInvitation(user);
		
		//Like activities
		navToolBar.goToHomePage();
		hpact.likeOrUnlikeActivity(activity);
		hpact.likeOrUnlikeActivity(activity2);
		magAcc.userSignIn(userType.ADMIN);

		/*
		- Check notification mail content
		 *Input Data: 
		 *Expected Outcome: 
		- Notification mail content is: New like on your activity streamHi UserA,UserB likes your activity:[Activity]Reply | View the full discussion		*/
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_LIKE_ACTIVITY_SUBJECT));
		checkEmailNotification(MSG_CONTENT_EMAIL_LIKE_ACTIVITY.replace("${user}", user1).replace("${activity}", activity), "John", "Reply","View the full discussion");
		/*
		- Click [Reply]
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and displays the activity stream on the position of the activity with the comment box opened, ready for reply		*/
		click(By.linkText("Reply"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", activity));
		waitForAndGetElement(hpact.ELEMENT_COMMENTBOX.replace("${title}", activity));

		/*
		- Click [View the full discussion]
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and displays the activity stream on the position of the activity with all comments expanded.		*/ 
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail2);
		click(By.linkText("View the full discussion"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment1));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment2));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment3));

		//restore data
		navToolBar.goToHomePage();
		hpact.deleteActivity(activity2, true);
		hpact.deleteActivity(activity, true);

		navToolBar.goToConnectionPage();
		peo.removeConnection(user1);

		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);
	}

	/**
	 * Case ID:109850.
	 * Test Case Name: Comment notification mail.
	 * Pre-Condition: 
	- UserB comment on activity of UserA or comment on activity where UserA has already commented
	- Comment notification mail is sent
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 */
	@Test
	public  void test03_CommentNotificationMail() {
		info("Test 3: Comment notification mail");
		String activity = "Activity1 109850";
		String activity2 = "Activity2 109850";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_COMMENT.replace("${user}", user1)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_COMMENT.replace("${user}", user2)));
		String comment1 = "comment 01";
		String comment2 = "comment 02";
		String comment3 = "comment 03";
		String comment4 = "comment 04";
		String comment5 = "comment 05";
		String comment6 = "comment 06";
		
		//Update email
		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);

		//Send connection request
		navToolBar.goToConnectionPage();
		peo.connectPeople(user1);
		peo.connectPeople(user2);

		//Add activity and create comment
		navToolBar.goToHomePage();
		act.addActivity(true, activity, false, "");
		act.addActivity(true, activity2, false, "");
		act.addComment(activity2, comment3);
		act.addComment(activity2, comment4);
		act.addComment(activity, comment5);
		act.addComment(activity, comment6);

		//Mary add comment on activity of john
		magAcc.userSignIn(userType.PUBLISHER);
		navToolBar.goToConnectionPage();
		peo.acceptInvitation(user);
		navToolBar.goToHomePage();
		act.addComment(activity, comment1);

		//Demo add comment on activity of john
		magAcc.userSignIn(userType.DEVELOPER);
		navToolBar.goToConnectionPage();
		peo.acceptInvitation(user);
		navToolBar.goToHomePage();
		act.addComment(activity2, comment2);
		magAcc.userSignIn(userType.ADMIN);

		/*
		- Check Comment notification mail content
		 *Expected Outcome: 
		- Comment notification mail content is: New comment on your activityHi UserA,UserB has posted a comment on your activity. See the comment below:[Activity content][Comment content]Reply | View the full discussion		*/

		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_COMMENT_ACTIVITY_SUBJECT));
		checkEmailNotification(MSG_CONTENT_EMAIL_COMMENT_ACTIVITY.replace("${user}", user1).replace("${activity}", activity).replace("${comment}", comment1), "John", "Reply","View the full discussion");

		/*
		- Click [Reply]
		 *Input Data: 
		 *Expected Outcome: Redirect to the portal and display the activity in the activity viewer with all comments expanded and the comment box opened, ready for reply. The comment that this notification is about is highlighted.		*/

		click(By.linkText("Reply"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", activity));
		waitForAndGetElement(hpact.ELEMENT_COMMENTBOX.replace("${title}", activity));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", comment6));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", comment5));
		WebElement eComment = waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", comment1) + "/../../..");
		assert eComment.getCssValue("background-color").equals("rgba(240, 240, 240, 1)");

		/*
		- Click [View the full discussion]
		 *Input Data: 
		 *Expected Outcome: Redirect to the portal and display the activity in the activity viewer with all comments expanded. The comment that this notification is about is highlighted.		*/ 
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);

		click(eEmail2);
		click(By.linkText("View the full discussion"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment3));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment4));
		WebElement eComment2 = waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment2)+ "/../../..");
		assert eComment2.getCssValue("background-color").equals("rgba(240, 240, 240, 1)");

		//Restore data
		navToolBar.goToHomePage();
		hpact.deleteActivity(activity2, true);
		hpact.deleteActivity(activity, true);

		navToolBar.goToConnectionPage();
		peo.removeConnection(user1);
		peo.removeConnection(user2);

		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);

	}

	/**
	 * Case ID:109856.
	 * Test Case Name: Post notification maill content.
	 * Pre-Condition: UserA is connected with UserB
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 */
	@Test
	public  void test04_PostNotificationMaillContent() {
		info("Test 04 Post notification maill content");

		String activity = "Activity1 109852";
		String activity2 = "Activity2 109852";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_POST_MY_ACTIVITY.replace("${user}", user1).replace("${activity}", activity)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_POST_MY_ACTIVITY.replace("${user}", user1).replace("${activity}", activity2)));
		String comment1 = "comment 01";
		String comment2 = "comment 02";
		String comment3 = "comment 03";
		
		//Update email
		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);

		navToolBar.goToConnectionPage();
		peo.connectPeople(user1);

		/*
		- Login as UserA
		- Go to activity stream of UserB
		- Post an activity on activity stream of userB
		 *Expected Outcome: 
		- New activity is posted		*/

		magAcc.userSignIn(userType.PUBLISHER);
		navToolBar.goToConnectionPage();
		peo.acceptInvitation(user);
		click(peo.ELEMENT_MY_CONNECTIONS_TAB);
		click(peo.ELEMENT_PEOPLE_SEARCH.replace("${peopleName}", user));
		click(ELEMENT_ACTIVITY_STREAM_TAB);

		act.addActivity(true, activity, false, "");
		act.addActivity(true, activity2, false, "");
		act.addComment(activity2, comment1);
		act.addComment(activity2, comment2);
		act.addComment(activity2, comment3);

		magAcc.userSignIn(userType.ADMIN);
		/*
		- Check notification mail content
		 *Input Data: 
		 *Expected Outcome: 
		- Notification mail content is:New post on your activity streamHi UserB,[Full name of UserA] hasposted on your activity stream. See the post below:[Activity]Reply | View the full discussion		*/
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_POST_MY_ACTIVITY_SUBJECT));
		checkEmailNotification(MSG_CONTENT_EMAIL_POST_MY_ACTIVITY.replace("${user}", user1).replace("${activity}", activity), "John", "Reply","View the full discussion");

		/*Click Reply link
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and displays the activity stream on the position of the activity with the comment box opened, ready for reply		*/
		click(By.linkText("Reply"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", activity));
		waitForAndGetElement(hpact.ELEMENT_COMMENTBOX.replace("${title}", activity));

		/*Click [View the full discussion]
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and displays the activity stream on the position of the activity with all comments expanded.		*/ 

		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail2);
		click(By.linkText("View the full discussion"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment1));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment2));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment3));

		magAcc.userSignIn(userType.PUBLISHER);
		//restore data
		hpact.deleteActivity(activity2, true);
		hpact.deleteActivity(activity, true);

		navToolBar.goToConnectionPage();
		peo.removeConnection(user);

		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);
	}

	/**
	 * Case ID:109855.
	 * Test Case Name: "Post on my spaces" notification mail.
	 * Pre-Condition: 
	- A space is created: Space1 for ex
	- UserA is member or manager of Space1
	- UserB is member of Space1
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 */
	@Test
	public  void test05_PostOnMySpacesNotificationMail() {
		info("Test 05 Post on my spaces notification mail");
		String space = "Space109855";
		String activity = "Activity1 109855";
		String activity2 = "Activity2 109855";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_POST_SPACE_ACTIVITY.replace("${user}", user1).replace("${space}", space).replace("${activity}", activity)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_POST_SPACE_ACTIVITY.replace("${user}", user1).replace("${space}", space).replace("${activity}", activity2)));
		String comment1 = "comment 01";
		String comment2 = "comment 02";
		String comment3 = "comment 03";

		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);

		goToAllSpaces();
		sp.addNewSpace(space, "");
		sp.goToSpaceMenu("Space Settings");
		click(By.linkText("Members"));
		mgMem.inviteSingleUser("mary", user1);

		/*- Login as UserB
		- Post an activity on Space1's stream
		 *Expected Outcome: 
		- New activity is added		*/
		magAcc.userSignIn(userType.PUBLISHER);
		navToolBar.goToConnectionPage();
		peo.acceptInvitation(user);
		mgMem.acceptInvitation(space);

		act.addActivity(true, activity, false, "");
		act.addActivity(true, activity2, false, "");
		act.addComment(activity2, comment1);
		act.addComment(activity2, comment2);
		act.addComment(activity2, comment3);

		magAcc.userSignIn(userType.ADMIN);

		/*
		- Check notification mail content
		 *Input Data: 
		 *Expected Outcome: 
		- Notification mail content is:New post in $SPACEHi UserA,[Full name of UserB] has posted an activity in the Space1 space. See the post below: [Activity]Reply | View the full discussion		*/
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_POST_SPACE_ACTIVITY_SUBJECT.replace("${space}", space)));
		checkEmailNotification(MSG_CONTENT_EMAIL_POST_SPACE_ACTIVITY.replace("${user}", user1).replace("${activity}", activity).
				replace("${space}", space), "John", "Reply","View the full discussion");

		/*Click [Reply]
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and displays the activity stream on the position of the activity with the comment box opened, ready for reply		*/

		click(By.linkText("Reply"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", activity));
		waitForAndGetElement(hpact.ELEMENT_COMMENTBOX.replace("${title}", activity));

		/*Click [View The Full Discussion]
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and displays the activity stream on the position of the activity with all comments expanded.		*/ 
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail2);
		click(By.linkText("View the full discussion"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment1));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment2));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity2).replace("${comment}", comment3));

		//Restore data
		goToAllSpaces();
		sp.deleteSpace(space);

		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);
	}

	/**
	 * Case ID:109858.
	 * Test Case Name: Space join request notification mail.
	 * Pre-Condition: $FIRSTNAME = John for ex (first name of user1) $USER = Mary Williams for ex (full name of user2)
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 */
	@Test
	public  void test06_SpaceJoinRequestNotificationMail() {
		info("Test 06 Space join request notification mail");
		String space = "Space109858";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_JOIN_SPACE.replace("${user}", user1).replace("${space}", space)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_JOIN_SPACE.replace("${user}", user2).replace("${space}", space)));
		By eEmail3 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_JOIN_SPACE.replace("${user}", user3).replace("${space}", space)));

		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);

		/*- Login as user 1
		- Create a space "Space1"
		 *Expected Outcome: 
		- Space is created successfully		*/
		goToAllSpaces();
		sp.addNewSpace(space, "");

		/*- Login as user2
		- Click [Join a space]
		- Send request to join Space1
		 *Input Data: 
		 *Expected Outcome: 
		- Request to join is sent
		- Notification email is sent to user1	*/	
		magAcc.userSignIn(userType.AUTHOR);
		goToAllSpaces();
		mgMem.requestToJoin(space);
		
		magAcc.userSignIn(userType.ADMIN);
		accessSpace(space);
		sp.goToSpaceMenu("Space Settings");
		click(mgMem.ELEMENT_MEMBER_TAB);
		mgMem.declineInvitation(user3);
		
		//James is already a member of space
		mgMem.inviteSingleUser("james", user3);
		magAcc.userSignIn(userType.AUTHOR);
		mgMem.acceptInvitation(space);

		magAcc.userSignIn(userType.PUBLISHER);
		goToAllSpaces();
		mgMem.requestToJoin(space);

		magAcc.userSignIn(userType.DEVELOPER);
		goToAllSpaces();
		mgMem.requestToJoin(space);
		magAcc.userSignIn(userType.ADMIN);

		/*- Check notification mail content
		 *Input Data: 
		 *Expected Outcome: 
		- Notification mail content is: New request to join a spaceHi John,[Avatar of user who send request]Mary Williams has requested access to the Space1 space where you are a manager. Would you like to authorize Mary Williams to join ?Validate | Refuse*/		
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_REQUEST_JOIN_SPACE_SUBJECT));
		checkEmailNotification(MSG_CONTENT_EMAIL_JOIN_SPACE.replace("${user}", user1).
				replace("${space}", space), "John", "Validate","Refuse");

		/*Click Validate
		 *Input Data: 
		 *Expected Outcome: Accept the registration request and it will also take the user to the portal and open the space on its setting screen on "Members" tab. A feedback message is displayed: You have approved $USER 's request to join the space.. If the user is already a member, the feedback message is displayed : $USER is already a member of $SPACE.*/		
		click(By.linkText("Validate"));
		switchToNewWindow();
		waitForAndGetElement(ELEMENT_MESSAGE_APPROVE_SPACE_REQUEST.replace("${user}", user1));
		waitForAndGetElement(mgMem.ELEMENT_MEMBER_USER_ITEM.replace("${userName}", user1));

		/*Click Refuse
		 *Input Data: 
		 *Expected Outcome: Refuse the registration request and it will also take the user to the portal and open the space on its setting screen on "Members" tab. A feedback message is displayed: You have refused $USER to join the space..*/		 
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail2);
		click(By.linkText("Refuse"));
		switchToNewWindow();
		waitForAndGetElement(ELEMENT_MESSAGE_REFUSE_SPACE_REQUEST.replace("${user}", user2));
		waitForAndGetElement(mgMem.ELEMENT_MEMBERS_TABLE);
		
		//Check when user is already a member of space
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail3);
		click(By.linkText("Validate"));
		switchToNewWindow();
		waitForAndGetElement(ELEMENT_MESSAGE_ALREADY_MEMBER_SPACE.replace("${user}", user3).replace("${space}", space));
		waitForAndGetElement(mgMem.ELEMENT_MEMBER_USER_ITEM.replace("${userName}", user3));

		//restore data
		goToAllSpaces();
		sp.deleteSpace(space);
		
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);
	}

	/**
	 * Case ID:109857.
	 * Test Case Name: Space Invitation notification mail.
	 * Pre-Condition: $FIRSTNAME = Fqa for example (first name of user2)
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 * 
	 * Case ID:109849.
	* Test Case Name: Format of notification email.
	 */
	@Test
	public  void test07_SpaceInvitationNotificationMailAndCheckFormat() {
		info("Case 109857 + 109849 Space Invitation notification mail");
		String space = "Space1109857";
		String space1 = "Space2109857";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_INVITATION_SPACE.replace("${space}", space)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_INVITATION_SPACE.replace("${space}", space1)));

		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);

		/*- Login as user1
		- Create a space "Space1"
		- Go to Space Settings 
		-
		-> Member and invite user2 to join
		 *Expected Outcome: 
		- Invitation is sent to user 2
		- Notification mail is sent to user2	*/	

		magAcc.userSignIn(userType.AUTHOR);
		goToAllSpaces();
		sp.addNewSpace(space, "");
		sp.goToSpaceMenu("Space Settings");
		click(mgMem.ELEMENT_MEMBER_TAB);
		mgMem.inviteSingleUser("john", user);

		goToAllSpaces();
		sp.addNewSpace(space1, "");
		sp.goToSpaceMenu("Space Settings");
		click(mgMem.ELEMENT_MEMBER_TAB);
		mgMem.inviteSingleUser("john", user);

		magAcc.userSignIn(userType.ADMIN);

		/*
		- Check notification mail format
		 *Input Data: 
		 *Expected Outcome: 
		- The notification mail format is: New space invitationHi Fqa,[Avatar of space] You've received an invitation to join the Space1 space. Interested to join the space and access its documents and applications ?Accept | Refuse		*/
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		
		info("Check recipient field (case ID 109849)");
		click(ELEMENT_GMAIL_SHOW_DETAIL);
		waitForAndGetElement(ELEMENT_GMAIL_TO_FIELD.replace("${to}", "John Smith <"+ EMAIL_ADDRESS1+ ">"));
		
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_REQUEST_INVITATION_SPACE_SUBJECT));
		checkEmailNotification(MSG_CONTENT_EMAIL_INVITATION_SPACE.replace("${space}", space), "John", "Accept","Refuse");
		
		info("Check link of space on email (caseID 109845)");
		click(By.linkText(space));
		switchToNewWindow();
		waitForAndGetElement(sp.ELEMENT_SPACE_BREAD.replace("${space}", space));
		waitForAndGetElement(sp.ELEMENT_SPACE_CURRENT_MENU_ITEM.replace("${menuItem}", "Activity Stream"));
		
		driver.switchTo().window(handleGmail);
		
		info("Check link 'click here' (caseID 109849)");
		click(By.linkText("click here"));
		switchToNewWindow();
		waitForAndGetElement(ELEMENT_NOTIFICATION_SETTINGS_TITLE);
		
		driver.switchTo().window(handleGmail);
		/*
		- Click Accept
		 *Input Data: 
		 *Expected Outcome: Approve the invitation. The user become a member of the space and is taken to the space home		*/
		click(By.linkText("Accept"));
		switchToNewWindow();
		waitForAndGetElement(sp.ELEMENT_SPACE_BREAD.replace("${space}", space));
		waitForAndGetElement(sp.ELEMENT_SPACE_CURRENT_MENU_ITEM.replace("${menuItem}", "Activity Stream"));

		/*Click Refuse
		 *Input Data: 
		 *Expected Outcome: Deny the invitation and will take the user to the spaces list.A Feedback message will display: You refused to join $SPACE.		*/ 
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail2);
		click(By.linkText("Refuse"));
		switchToNewWindow();
		waitForAndGetElement(ELEMENT_MESSAGE_REFUSE_INVITATION_SPACE.replace("${space}", space1));
		waitForAndGetElement(ELEMENT_ACTION_USER_ON_SPACE.replace("${spaceName}", space1).replace("${action}", "Request to Join"));

		//Restore data
		magAcc.userSignIn(userType.AUTHOR);
		goToAllSpaces();
		sp.deleteSpace(space);
		sp.deleteSpace(space1);
		
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);
	}

	/**
	 * Case ID:109853.
	 * Test Case Name: Mention notification mail.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by thuntn at 2014/06/04 17:17:09
	 */
	@Test
	public  void test08_MentionNotificationMail() {
		info("Test 08 Mention notification mail");
		String activity = "Activity1 109853";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_MENTION.replace("${user}", user3)));
		By eEmail2 = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", MSG_TITLE_EMAIL_MENTION.replace("${user}", user1)));
		String comment1 = "comment 01";
		String comment2 = "comment 02";
		String comment3 = "comment 03";
		String comment4 = "comment 04";
		String comment5 = "comment 05";

		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);
		
		/*- Login as userA
		- Mention userB in activity or comment in any activity stream ("Test mention" for example)
		 *Expected Outcome: 
		- Mention user successfully		*/
		magAcc.userSignIn(userType.AUTHOR);
		act.mentionActivity(true, "", user);

		act.addComment(user, comment1);
		act.addComment(user, comment2);
		act.addComment(user, comment3);

		magAcc.userSignIn(userType.PUBLISHER);
		act.addActivity(true, activity, false, "");
		act.mentionActivity(false, activity, user);
		act.addComment(activity, comment4);
		act.addComment(activity, comment5);
		magAcc.userSignIn(userType.ADMIN);
		/*
		- Check Mention notification mail content
		 *Input Data: 
		 *Expected Outcome: 
		- Notification mail subject is: New mention of youHi UserB,[Avatar of UserA] UserA has mentioned you in the following post:Test mentionReply | View the full discussion		*/
		
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handleGmail = driver.getWindowHandle();
		click(eEmail);
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_MENTION_SUBJECT));
		checkEmailNotification(MSG_CONTENT_EMAIL_MENTION.replace("${user}", user3).replace("${activity}", user), "John", "Reply","View the full discussion");

		/*Click [Reply]
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and display the activity in the activity viewer with the comment box opened, ready for reply. If the mention is made in a comment, all comments are expanded and this comment is highlighted.*/		
		click(By.linkText("Reply"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", user));
		waitForAndGetElement(hpact.ELEMENT_COMMENTBOX.replace("${title}", user));

		/*Click [View the full discussion]
		 *Input Data: 
		 *Expected Outcome: Take the user to the portal and display the activity in the activity viewer with all comments expanded. If the mention is made in a comment, this comment is highlighted.*/		 
		driver.switchTo().window(handleGmail);

		click(By.linkText("View the full discussion"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", user).replace("${comment}", comment1));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", user).replace("${comment}", comment2));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", user).replace("${comment}", comment3));
		
		//Check when mention on comment, click Reply on email
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		click(eEmail2);
		click(By.linkText("Reply"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", comment4));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", comment5));
		WebElement eComment = waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", user) + "/../../../..");
		
		//Check if comment containing mention is highlighted
		assert eComment.getCssValue("background-color").equals("rgba(240, 240, 240, 1)");

		//Check when mention on comment, click View the full discussion on email
		driver.switchTo().window(handleGmail);

		click(By.linkText("View the full discussion"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", comment4));
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", comment5));
		WebElement eComment2 = waitForAndGetElement(hpact.ELEMENT_ACTIVITY_COMMENT_CONTENT.replace("${title}", activity).replace("${comment}", user) + "/../../../..");
		
		//Check if comment containing mention is highlighted
		assert eComment2.getCssValue("background-color").equals("rgba(240, 240, 240, 1)");
		
		//Restore data
		magAcc.userSignIn(userType.PUBLISHER);
		hpact.deleteActivity(activity);
		
		magAcc.userSignIn(userType.AUTHOR);
		hpact.deleteActivity(user);
		
		driver.switchTo().window(handleGmail);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);
	}
	
	/**
	* Case ID:109854.
	* Test Case Name: New user notification mail.
	* Pre-Condition: 
	- Add new user or new user sign up
	- $FIRSTNAME = John
	- $USER = Fqa Test for example
	- $PORTAL_NAME = Social intranet for ex
	- New user notification mail is sent
	* Post-Condition: 
	* Done with OSs and browsers : 
	* Generated by thuntn at 2014/06/04 17:17:09
	* 
	* Case ID:109845.
	* Test Case Name: Check link in notification email.
	*/
	@Test
	public  void test09_NewUserNotificationMail() {
		info("Test 09 New user notification mail");
		String username = getRandomString();
		String password = "gtngtn";
		String fullName = username + " "+username;
		String email = username + "@gmail.com";
		By eEmail = By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", fullName+" has joined eXo"));
		
		navToolBar.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);
		
		navToolBar.goToNotificationSettings();
		enableSendNotificationRight(MSG_ACTIVITY_JOIN_INTRANET, true);
		
		navToolBar.goToNewStaff();
		magAcc.addNewUserAccount(username, password, password, username, username, null, email, "", null,true);

		/*Check new user notification mail format
		*Expected Outcome: 
		- Subject of the notification mail is: New user on Social IntranetHi John,[Avatar of new user] Fqa Test has joined eXo. Interested to connect and start collaborate with Fqa TestConnect now		*/
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String handle = driver.getWindowHandle();
		click(eEmail);
		
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_SUBJECT.replace("${subject}", MSG_NEW_USER_SUBJECT)+"/a[text()='eXo']");
		checkEmailNotification(MSG_CONTENT_EMAIL_NEW_USER.replace("${user}", fullName), "John", "Connect now");
		
		//Check case 109845
		info("Check portal link: exo (case ID 109845)");
		click(By.linkText("eXo"));
		switchToNewWindow();
		waitForAndGetElement(hpact.ELEMENT_ACTIVITY_TEXTBOX);
		assert driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "/intranet") : "Wrong page!";
		
		info("Check user link: username (case ID 109845)");
		driver.switchTo().window(handle);
		click(By.linkText(fullName));
		switchToNewWindow();
		waitForAndGetElement(ELEMENT_PROFILE_PAGE.replace("${user}", fullName));
		
		driver.switchTo().window(handle);
		/*Click [Connect now]
		*Input Data: 
		*Expected Outcome: Send a connection request to the user that has just joined the social intranet. It will also take the user to the portal and open this new connection's profile.		*/ 
		click(By.linkText("Connect now"));
		switchToNewWindow();
		waitForAndGetElement(ELEMENT_PROFILE_PAGE.replace("${user}", fullName));
		waitForAndGetElement(peo.ELEMENT_REVOKE_BUTTON);
		
		//Restore data
		navToolBar.goToUsersAndGroupsManagement();
		userGroup.deleteUser(username);
		
		driver.switchTo().window(handle);
		click(ELEMENT_DELETE_MAIL_2);
		Utils.pause(1000);
 	}
}
