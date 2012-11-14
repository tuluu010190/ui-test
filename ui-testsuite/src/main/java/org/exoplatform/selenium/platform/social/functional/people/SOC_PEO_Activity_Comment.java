package org.exoplatform.selenium.platform.social.functional.people;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;

import org.exoplatform.selenium.platform.social.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author vuna2
 * Date: 15/11/2012
 * Test cases: Social/people/comment
 */
public class SOC_PEO_Activity_Comment extends Activity{
	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods(){
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}

	/**
	 * Case ID 001
	 * Comment on your activity
	 */
	@Test
	public void test01_CommentOnYourActivity(){
		info("-- Step 1: Add new activities --");
		
		String activityText = "Test case 01: comment on your activity";

		String contentOfComment = "Write your comments on test case 01 here...";

		goToActivityStream();

		addActivity(true, activityText, false, "https://www.google.com");

		info("-- Step 2 & 3: Show a comment form and Add a comment--");

		addComment(activityText, contentOfComment);

		captureScreen("SOC_PEO_Comment_case01_step1");
				
		acceptInvitePeopleTest();

		waitForTextPresent(contentOfComment);

		captureScreen("SOC_PEO_Comment_case01_step2");

		info("-- Restore original data --");

		info("-- Re-login as John--");

		signOut();

		signIn("john", "gtn");

		goToActivityStream();

		waitForTextPresent(contentOfComment);

		deleteActivity(activityText);

		removeConnection("Mary Williams");

		info("-- Finished test case --");
	}

	/**
	 * Case ID 002
	 * Comment on your friends activity
	 */
	@Test
	public void test02_CommentOnYourFriendsActivity(){
		info("-- Step 1: Add new activities --");

		String activityText = "Test case 02: comment on your friends activity";

		String contentOfComment = "Write your comments on test case 02 here...";

		goToActivityStream();

		addActivity(true, activityText, false, "https://www.google.com");

		info("-- Step 2 & 3: Go to people page and Invite an user/friends--");

		info("-- Step 4: Accept the friend --");

		acceptInvitePeopleTest();

		click(By.linkText("John Smith"));

		waitForTextPresent("Basic information");
		
		click(By.linkText("Activity Stream"));
		
		info("-- Step 5: Add a comment --");

		addComment(activityText, contentOfComment);

		captureScreen("SOC_PEO_Comment_case02");

		info("-- Restore original data --");

		info("-- Re-login as John--");

		signOut();

		signIn("john", "gtn");

		goToActivityStream();

		waitForTextPresent(contentOfComment);

		deleteActivity(activityText);

		removeConnection("Mary Williams");

		info("-- Finished test case --");
	}
	
	/**
	 * Case ID 003
	 * Show/Hide all comments
	 */
	@Test
	public void test03_ShowHideAllComments(){
		info("-- Step 1: Add new activities --");
		
		String activityText = "Test case 03: show/hide all comments";
		
		String showAllComments = "Show all " + "${number}" + " comments.";
		
		String hideAllComments = "Hide all " + "${number}" + " comments.";
		
		String[] contentOfCommentList = {"contentOfComment01", "contentOfComment02", "contentOfComment03"};
		
		goToActivityStream();

		addActivity(true, activityText, false, "https://www.google.com");
		
		info("-- Step 2: Add a comment --");
		
		addSomeComments(activityText, contentOfCommentList);		
		
		info("-- Step 3: Move other page --");
		
		goToMyProfile();
		
		info("-- Return to activity page --");
		
		goToActivityStream();
		
		// A link “show all 'number' comments” is displayed	
		waitForTextPresent(showAllComments.replace("${number}", "3"));
		
		info("-- Step 4: Show all comments --");
		
		//Click on “show all 'number' comments” link		
		showHideComments(activityText, true, false, showAllComments.replace("${number}", "3"));
		
		info("-- Step 5: Hide all comments --");
		
		showHideComments(activityText, false, true, hideAllComments.replace("${number}", "3"));
		
		info("-- Restore original data --");
	
		deleteActivity(activityText);

		info("-- Finished test case --");
	}
	
	/**
	 * Case ID 004
	 * Delete a comment
	 */
	@Test
	public void test04_DeleteComment(){
		info("-- Step 1: Add new activities --");
		
		String activityText = "Test case 04: Delete a comment";
		
		String[] contentOfCommentList = {"deleteComment01", "deleteComment02", "deleteComment03"};
		
		String showAllComments = "Show all " + "${number}" + " comments.";
		
		goToActivityStream();

		addActivity(true, activityText, false, "https://www.google.com");
		
		info("-- Step 2: Add a comment --");
		
		addSomeComments(activityText, contentOfCommentList);
		
		info("-- Veryfy that Mary can view the John's activity on her activity list--");
		
		acceptInvitePeopleTest();
		
		click(By.linkText("John Smith"));

		waitForTextPresent("Basic information");
		
		click(By.linkText("Activity Stream"));

		waitForTextPresent("deleteComment03");
		
		info("-- Step 3: Delete comment --");
		
		info("-- Re-login as John--");

		signOut();

		signIn("john", "gtn");

		goToActivityStream();
		
		info("-- Show all comments --");
		
		showHideComments(activityText, true, false, showAllComments.replace("${number}", "3"));
		
		deleteComment(contentOfCommentList[0]);
				
		info("-- Restore original data --");
		
		deleteActivity(activityText);
		
		removeConnection("Mary Williams");

		info("-- Finished test case --");
	}
	
	/*--- Auxiliary functions for these case ---*/
	public void acceptInvitePeopleTest(){
		
		connectPeople("Mary Williams");
		
		info("-- Login as Mary --");

		signOut();

		signIn("mary", "gtn");

		acceptInvitation("John Smith");

		goToActivityStream();

		waitForTextPresent("John Smith");
	}
	
}
