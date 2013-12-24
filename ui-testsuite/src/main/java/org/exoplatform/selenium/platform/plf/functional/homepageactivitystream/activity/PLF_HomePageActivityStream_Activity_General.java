package org.exoplatform.selenium.platform.plf.functional.homepageactivitystream.activity;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePageActivity;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.ManageAccount.userType;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ActionBar;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ContextMenu;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ContextMenu.actionType;
import org.exoplatform.selenium.platform.social.Activity;
import org.exoplatform.selenium.platform.social.ManageMember;
import org.exoplatform.selenium.platform.social.PeopleConnection;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author chinhdtt
 *
 */
public class PLF_HomePageActivityStream_Activity_General extends Activity{
	ManageAccount acc; 
	HomePageActivity home; 
	NavigationToolbar nav; 
	ActionBar actBar;
	EcmsBase ecms; 
	ManageMember mMember; 
	PeopleConnection pConn; 
	ContextMenu conMenu; 
	String user = "John Smith"; 
	String user1 = "Jack Miller";
	SpaceManagement mSpace; 

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		acc = new ManageAccount(driver, this.plfVersion);
		home = new HomePageActivity(driver, this.plfVersion); 
		acc.signIn(DATA_USER1, DATA_PASS);
		nav = new NavigationToolbar(driver, this.plfVersion);
		mMember = new ManageMember(driver,this.plfVersion);
		pConn = new PeopleConnection(driver, this.plfVersion);
		actBar = new ActionBar(driver, this.plfVersion);
		ecms = new EcmsBase(driver, this.plfVersion);
		conMenu = new ContextMenu(driver, this.plfVersion);
		mSpace = new SpaceManagement(driver, this.plfVersion);
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();		
		driver.quit();
	}
	/**
	 * Case ID:78606.
	 * Test Case Name: Display Content of an activity.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test01_DisplayContentOfAnActivity() {
		info("Test 1: Display Content of an activity");
		/*
		- Connect to Intranet
		- Share an activity 
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream:
		- The activity is made out of different parts:+ The author+ The author's avatar+ The space (if activity is created in a space)+ The type (optional)+The activity message+ The featured content (optional)+The Action bar (Comment and Like links + custom actions)+ The like section (optional)+ The comment section (optional)		*/ 
		String text = "Activity 78606";
		String spaceName = "Space 78606";
		//Create space 
		mMember.goToMySpacePage();
		mMember.addNewSpace(spaceName,"");
		addActivity(true, text, false,"");
		nav.goToHomePage();
		selectFileter("All Activities");
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY_AUTHOR_NAME.replace("${index}","1").replace("${author}",user)));
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY_AUTHOR_AVATAR.replace("${index}","1").replace("${author}",user)));
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)));
		waitForAndGetElement(ELEMENT_NAME_SPACE_ACTIVITY);
		waitForAndGetElement(By.xpath(home.ELEMENT_ICON_COMMENT.replace("${title}",text)));
		waitForAndGetElement(By.xpath(home.ELEMENT_LIKE_ICON.replace("${activityText}", text)));	
		//delete data
		home.deleteActivity(text);
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Case ID:78607.
	 * Test Case Name: Delete an activity from activity stream by owner.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test02_DeleteAnActivityFromActivityStreamByOwner() {
		info("Test 2: Delete an activity from activity stream by owner");
		/*
		- Connect to Intranet
		- Share an activity 
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream		*/
		String text = "Activity 78607";
		addActivity(true, text, false,"");

		/*
		- Move the mouse over the activity
		 *Input Data: 
		 *Expected Outcome: A (X) icon is displayed in the top right panel of the activity		*/
		mouseOver(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)), true);
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY_DELETE.replace("${activityText}", text)), DEFAULT_TIMEOUT,1,2);
		/*
		- Click on the (X) icon then click YES on the Confirmation Popup
		 *Input Data: 
		 *Expected Outcome: The activity is removed from the activity stream		*/ 
		home.deleteActivity(text);	
		waitForElementNotPresent(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)));
	}

	/**
	 * Case ID:78608.
	 * Test Case Name: Delete a space activity from activity stream by space's administrator.
	 * Pre-Condition: 
	- A space is created
	- User A is space administrator
	- User B is a normal space member
	- User B has posted an activity in the space
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test03_DeleteASpaceActivityFromActivityStreamBySpacesAdministrator() {
		info("Test 3: Delete a space activity from activity stream by space's administrator");
		String text = "Activity 78608";
		String spaceName = "Space 78608";
		// Pre-Condition
		mMember.goToMySpacePage();
		mMember.addNewSpace(spaceName,"");
		goToMembers(spaceName);
		mMember.inviteSingleUser(userType.DEVELOPER);
		acc.signOut();
		acc.userSignIn(userType.DEVELOPER);
		mMember.acceptInvitation(spaceName);
		addActivity(true, text, false,"");

		/*
		- As User A, go to homepage
		- Move the mouse over the activity created by User B
		 *Input Data: 
		 *Expected Outcome: A (X) icon is displayed in the top right panel of the activity		*/
		acc.userSignIn(userType.ADMIN);
		nav.goToHomePage();
		mouseOver(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)), true);
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY_DELETE.replace("${activityText}", text)), DEFAULT_TIMEOUT,1,2);
		/*
		- Click on the (X) icon then click OK on the "Confirmation Popup"
		 *Input Data: 
		 *Expected Outcome: The activity is removed from the activity stream		*/ 
		home.deleteActivity(text);
		waitForElementNotPresent(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)));
		//delete data
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Case ID:78609.
	 * Test Case Name: Not display (X) icon of space activity for member.
	 * Pre-Condition: User A is the administrator of space XUser B is a member in the space X
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test04_NotDisplayXIconOfSpaceActivityForMember() {
		info("Test 4: Not display (X) icon of space activity for member");
		String text = "Activity 78609";
		String spaceName = "Space 78609";
		/*
		- Connect to Intranet with User A
		- Open the Space X
		- Share an activity
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream		*/
		mMember.goToMySpacePage();
		mMember.addNewSpace(spaceName, "");
		goToActivityStream();
		addActivity(true, text, false, "");
		goToMembers(spaceName);
		mMember.inviteSingleUser(userType.DEVELOPER);
		acc.signOut();

		/*
		- Connect with a User B
		- Move the mouse over the activity
		 *Input Data: 
		 *Expected Outcome: A (X) icon isn't displayed in the top right panel of the activity		*/ 
		acc.userSignIn(userType.DEVELOPER);
		mMember.acceptInvitation(spaceName);
		nav.goToHomePage();
		mouseOver(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)), true);
		waitForElementNotPresent(By.xpath(home.ELEMENT_ACTIVITY_DELETE.replace("${activityText}", text)), DEFAULT_TIMEOUT,1,2);
		//delete data
		acc.userSignIn(userType.ADMIN);
		home.deleteActivity(text);
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Case ID:78610.
	 * Test Case Name: Not display (X) icon in activity for other user.
	 * Pre-Condition: User A and User B must be connected
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test05_NotDisplayXIconInActivityForOtherUser() {
		info("Test 5: Not display (X) icon in activity for other user");
		String text = "Activity 78610"; 
		//Connect user A & B
		nav.goToConnectionPage();
		pConn.connectPeople(user1);
		acc.userSignIn(userType.DEVELOPER);
		pConn.acceptInvitation(user);
		acc.signOut();

		/*
		- Connect to Intranet with User A
		- Share an activity
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream		*/
		acc.userSignIn(userType.ADMIN);
		addActivity(true, text, false, "");
		acc.signOut();

		/*
		- Connect with a User B
		- Move the mouse over the activity
		 *Input Data: 
		 *Expected Outcome: A (X) icon isn't displayed in the top right panel of the activity		*/ 
		acc.userSignIn(userType.DEVELOPER);
		nav.goToHomePage();
		mouseOver(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)), true);
		waitForElementNotPresent(By.xpath(home.ELEMENT_ACTIVITY_DELETE.replace("${activityText}", text)), DEFAULT_TIMEOUT,1,2);
		acc.signOut();
		//delete data
		acc.userSignIn(userType.ADMIN);
		home.deleteActivity(text);
		nav.goToConnectionPage();
		pConn.removeConnection(user1);
	}

	/**
	 * Case ID:78611.
	 * Test Case Name: Display type icon of activity in the timeline.
	 * Pre-Condition: Activity has a type: attachment, event, forum...
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test06_DisplayTypeIconOfActivityInTheTimeline() {
		info("Test 6: Display type icon of activity in the timeline");
		String driverName = "Personal Drives";
		String folderPath = "Personal Documents";
		String uploadFileName = "ECMS_DMS_SE_Upload_pdffile.pdf";
		String folder = "Folder78611";
		String contentType = ".pdf";
		/*
		- Connect to Intranet with User A
		- Share an activity
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream
		- The icon type of the activity is displayed in the timeline		*/ 

		selectFile(driverName,true,folderPath,"",uploadFileName,folder);
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY.replace("${activityText}", uploadFileName)));
		//Activity type 
		waitForAndGetElement(home.ELEMENT_CONTENT_TYPE_PLF41.replace("${activityText}", uploadFileName).replace("${type}", contentType));
		//delete data
		home.deleteActivity(uploadFileName);
		nav.goToSiteExplorer();
		actBar.chooseDrive(ecms.ELEMENT_PERSONAL_DRIVE);
		actBar.actionsOnElement(folder, actionType.DELETE, true, true);			
	}

	/**
	 * Case ID:78612.
	 * Test Case Name: Display the date time information of activity.
	 * Pre-Condition: 
	  - An activity is shared
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test07_DisplayTheDateTimeInformationOfActivity() {
		info("Test 7: Display the date time information of activity");
		String text = "Activity 78612";
		String datetime = "less than a minute ago";
		/*
		- Connect to Intranet 
		- Check date time information of activity
		 *Input Data: 
		 *Expected Outcome: 
		- The date time information is displayed like:* (X) (minutes, hours, days) ago		*/ 
		addActivity(true, text, false, "");
		waitForAndGetElement(ELEMENT_COMMENT_DATETIME.replace("${activityText}", text).replace("${DATETIME}", datetime));
		Utils.pause(2000);
		// delete data
		home.deleteActivity(text);
	}

	/**
	 * Case ID:78613.
	 * Test Case Name: Display name of space in space's activity.
	 * Pre-Condition: A space is created
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test08_DisplayNameOfSpaceInSpacesActivity() {
		info("Test 8: Display name of space in space's activity");
		String text = "Activity 78613";
		String spaceName = "Space 78613";
		/*
		- Connect to Intranet
		- Open a Space
		- Share an activity
		- Go to Intranet Homepage
		 *Input Data: 
		 *Expected Outcome: 
		- The space's activity is displayed in the activity stream
		- The name of the space is displayed with an icon		*/ 
		mMember.goToMySpacePage();
		mMember.addNewSpace(spaceName, "");
		addActivity(true, text, false, "");
		nav.goToHomePage();
		selectFileter("My Spaces");
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY.replace("${activityText}", text)));
		waitForAndGetElement(ELEMENT_NAME_SPACE_ACTIVITY);
		waitForAndGetElement(ELEMENT_ICON_SPACE_ACTIVITY);

		//delete data
		home.deleteActivity(text);
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName, 300000);
	}

	/**
	 * Case ID:78614.
	 * Test Case Name: Open space from the space's activity.
	 * Pre-Condition: A space is created
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test09_OpenSpaceFromTheSpacesActivity() {
		info("Test 9: Open space from the space's activity");
		String spaceName = "Space 78614";
		String text = "Activity 78614";
		/*
		- Connect to Intranet
		- Open a Space
		- Share an activity
		 *Input Data: 
		 *Expected Outcome: 
		- The space's activity is displayed in the activity stream
		- The name of the space is displayed with an icon		*/

		/*
		- Go to home page
		- Click on the name of the space on activity
		 *Input Data: 
		 *Expected Outcome: 
		- The Space is opened		*/ 
		mMember.goToMySpacePage();
		mMember.addNewSpace(spaceName, "");
		addActivity(true, text, false,"");
		nav.goToHomePage();
		selectFileter("My Spaces");
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY.replace("${activityText}", text)));
		waitForAndGetElement(ELEMENT_NAME_SPACE_ACTIVITY);
		waitForAndGetElement(ELEMENT_ICON_SPACE_ACTIVITY);
		click(ELEMENT_NAME_SPACE_ACTIVITY);
		waitForAndGetElement(mSpace.ELEMENT_SPACE_MENU_ITEM.replace("${menuItem}", "More"),DEFAULT_TIMEOUT,0);

		//delete data 
		home.deleteActivity(text);
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Case ID:78615.
	 * Test Case Name: Display comment and like icons in activity.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test10_DisplayCommentAndLikeIconsInActivity() {
		info("Test 10 Display comment and like icons in activity");
		String text = "Activity 78615";
		/*
		- Connect to Intranet with User A
		- Share an activity
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream
		- At the right of the action bar, 2 elements are display:+ comment icon with number of comments+ like icon with number of likes		*/ 
		addActivity(true, text, false, "");
		nav.goToHomePage();
		waitForAndGetElement(home.ELEMENT_ICON_COMMENT.replace("${title}", text));
		waitForAndGetElement(home.ELEMENT_LIKE_ICON.replace("${activityText}", text), DEFAULT_TIMEOUT, 0);

		//delete data
		home.deleteActivity(text);
	}

	/**
	 * Case ID:78616.
	 * Test Case Name: Show action bar of an activity.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test11_ShowActionBarOfAnActivity() {
		info("Test 11 Show action bar of an activity");
		String text = "Activity 78616";
		String comment = "Comment 78616";
		/*
		- Connect to Intranet with User A
		- Share an activity
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream
		- At the right of the action bar 2 elements are displayed:+ Comment icon with number of comments+ Like icon with number of likes		*/ 
		addActivity(true, text, false, "");
		addComment(text, comment);
		waitForAndGetElement(home.ELEMENT_ICON_COMMENT.replace("${title}", text));
		//number comment
		waitForAndGetElement(home.ELEMENT_ICON_COMMENT.replace("${title}", text)).getText().trim();
		waitForAndGetElement(home.ELEMENT_LIKE_ICON.replace("${activityText}", text));
		//number like
		waitForAndGetElement(home.ELEMENT_LIKE_ICON.replace("${activityText}", text)).getText().trim();
		//delete data
		home.deleteActivity(text);
	}

	/**
	 * Case ID:78619.
	 * Test Case Name: Display specific actions of an activity in the left action part.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test12_DisplaySpecificActionsOfAnActivityInTheLeftActionPart() {
		info("Test 12 Display specific actions of an activity in the left action part");
		String file = "ECMS_DMS_SE_Upload_docfile.doc"; 
		By eleFile = By.linkText(file);
		/*
		- Connect to Intranet
		- Share an activity (File activity for example)
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream
		- Specific action of activity are displayed in the left part of action bar (Actions: View, Download, Edit)		*/ 
		nav.goToSiteExplorer();
		ecms.uploadFile("TestData/"+file);
		nav.goToHomePage();
		selectFileter("All Activities");
		info("Actions: View, Download, Edit");
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY.replace("${activityText}", file)));
		if(plfVersion.equalsIgnoreCase("4.0")){
			waitForAndGetElement(By.xpath(home.ELEMENT_CONTENT_VIEW_LINK.replace("@{fileName}", file)));
			waitForAndGetElement(By.xpath(home.ELEMENT_DOWNLOAD_ICON.replace("${activityText}", file)));
			waitForAndGetElement(By.xpath(home.ELEMENT_CONTENT_EDIT_LINK.replace("@{fileName}", file))); 
		}
		if(plfVersion.equalsIgnoreCase("4.1")){
			waitForAndGetElement(By.xpath(home.ELEMENT_CONTENT_VIEW_LINK_PLF41.replace("${activityText}", file)));
			waitForAndGetElement(By.xpath(home.ELEMENT_DOWNLOAD_ICON.replace("${activityText}", file)));
			waitForAndGetElement(By.xpath(home.ELEMENT_CONTENT_EDIT_LINK_PLF41.replace("${activityText}", file)));
		}
		//delete data
		nav.goToSiteExplorer();
		conMenu.deleteData(eleFile);
	}

	/**
	 * Case ID:78620.
	 * Test Case Name: Display user profile's popup from activity.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2013/12/20 11:27:03
	 */
	@Test
	public  void test13_DisplayUserProfilesPopupFromActivity() {
		info("Test 13 Display user profile's popup from activity");
		String text = "Activity 78620";
		/*
		- Connect to Intranet
		- Share an activity
		 *Input Data: 
		 *Expected Outcome: 
		- The activity is displayed in the activity stream
		- Author's name or avatar is displayed		*/
		addActivity(true, text, false,"");
		waitForAndGetElement(By.xpath(home.ELEMENT_ACTIVITY.replace("${activityText}", text)));
		WebElement elementAuthor = waitForAndGetElement(home.ELEMENT_ACTIVITY_AUTHOR_NAME.replace("${index}","1").replace("${author}", user));
		Assert.assertEquals(elementAuthor.isDisplayed(), true);

		/*
		- Move the mouse over the avatar or name
		 *Input Data: 
		 *Expected Outcome: The user profile's popup is displayed with: 
		- Avatar
		- Name
		- Title (or position in the company) if defined
		- Last activity message (if exist)		*/ 
		mouseOver(home.ELEMENT_ACTIVITY_AUTHOR_NAME.replace("${index}","1").replace("${author}", user), true);
		waitForAndGetElement(ELEMENT_USER_PROFILE_POPUP.replace("${userName}", user));
		//		Utils.pause(1000);
		//		waitForAndGetElement(ELEMENT_USER_PROFILE_AVATAR.replace("${userName}", user));

		//delete data
		nav.goToHomePage();
		home.deleteActivity(text);
	}
}
