package org.exoplatform.selenium.platform.social.functional.space;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.social.ManageMember.*;

import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.social.ManageMember.userType;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author vuna2
 * Date: 21/11/2012
 * Test cases: Social/Space/Create a new space 
 *
 */
public class SOC_SPA_SpaceManagement_CreateSpace extends SpaceManagement{
	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";

	public int timeToDeleteSpace = 120000;

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
	 * Access Space page
	 */
	@Test
	public void test01_AccessSpacePage(){
		info("-- Step 1: Sign in Social system --");

		info("-- Step 2: Go to Space page --");

		goToMySpacePage();

		info("-- Show content of Space Page --");

		waitForTextPresent("Find Space:");

		waitForTextPresent("Add New Space");

		waitForTextPresent("All Spaces");

		waitForTextPresent("Invitations Received");

		waitForTextPresent("Requests Pending");

		captureScreen("SOC_SPA_Create_Space_case01");	
	}

	/**
	 * Case ID 017
	 * Create a new Space by default
	 */
	@Test
	public void test17_CreateANewSpaceByDefault(){

		String spaceName = "SpaceCase17";

		String spaceDescription = "test17: create a new space";

		info("-- Step 1: Go to space page --");	

		goToMySpacePage();

		info("-- Step 2 & 3: Show form create new space and Create space--");

		addNewSpace(spaceName, spaceDescription);

		goToMySpacePage();

		//User who is manager can access, edit, leave and edit.
		editSpace(spaceName, "EditSpaceCase17", "edit_Description_Of_Space", false, "");

		restoreData("EditSpaceCase17", timeToDeleteSpace);
	}

	/**
	 * Case ID 018
	 * Create new space with visible and open mode
	 */
	@Test
	public void test18_CreateNewSpaceWithVisibleAndOpenMode(){

		String spaceName = "SpaceCase18";

		String spaceDescription = "test18: create a new space";

		//String groupToInviteUsers = "Organization/Employees";

		info("-- Step 1: Go to space page --");

		goToMySpacePage();

		info("-- Step 2/3/4/5/6 : Create a new space with the visibility: Visible and Registration: Open mode --");

		//addNewSpace(spaceName, spaceDescription, "Visible", "Open", groupToInviteUsers, "Select this group to invite users");
		addNewSpace(spaceName, spaceDescription, "Visible", "Open", "", "");

		signOut();

		signIn("mary", "gtn");

		info("-- User: Mary will automatically become a member of that space after sending a request to join --");

		//acceptInvitation(spaceName);	
		joinOpenSpace(spaceName);

		click(By.linkText(spaceName));

		waitForTextPresent("Mary Williams joined the space.");

		signOut();

		signIn("john", "gtn");

		restoreData(spaceName, timeToDeleteSpace);
	}

	/**
	 * Case ID 019
	 * Create new space with visible and Validation mode
	 */
	@Test
	public void test19_CreateNewSpaceWithVisibleAndValidationMode(){
		String spaceName = "SpaceCase19";

		String spaceDescription = "test19: create a new space";

		String groupToInviteUsers = "Organization/Management/Executive Board";

		info("-- Step 1: Go to space page --");

		goToMySpacePage();

		info("-- Step 2/3/4/5/6 : Create a new space with the visibility: Visible and Registration: Validation mode --");

		addNewSpace(spaceName, spaceDescription, "Visible", "Validation", groupToInviteUsers, "Select this group to invite users");

		info("-- User: Jack sent a request to join this space --");

		userRequestToJoinSpace(userType.DEVELOPER, spaceName);

		info("-- Manager of space: John accept the request from User --");

		//signOut();
		
		//signIn(DATA_USER, DATA_PASS);
		
		managerAcceptRequestFromUser(true, userType.ADMIN, userType.DEVELOPER, spaceName);

		restoreData(spaceName, timeToDeleteSpace);
	}

	/**
	 * Case ID 020
	 * Create new space with visible and close mode
	 */
	@Test
	public void test20_CreateNewSpaceWithVisibleAndCloseMode(){
		String spaceName = "SpaceCase20";

		String spaceDescription = "test20: create a new space";

		String groupToInviteUsers = "Organization/Management/Executive Board";

		info("-- Step 1: Go to space page --");

		goToMySpacePage();

		info("-- Step 2/3/4/5/6 : Create a new space with the visibility: Visible and Registration: Close mode --");

		addNewSpace(spaceName, spaceDescription, "Visible", "Close", groupToInviteUsers, "Select this group to invite users");

		info("-- Verify that Other user can not send a request to join this space --");

		signOut();

		signIn("demo", "gtn");

		goToAllSpaces();

		waitForTextPresent(spaceName);

		waitForTextNotPresent("Request to Join");

		info ("-- Only manager of space can send the invitation to user --");

		//signOut();

		//signIn("john", "gtn");
		
		managerInviteUserToJoinSpace(userType.ADMIN, spaceName, userType.DEVELOPER);

		userAcceptInvitationToJoinSpace(true, userType.DEVELOPER, spaceName);
		
		signOut();

		signIn("john", "gtn");

		restoreData(spaceName, timeToDeleteSpace);
	}

	/**
	 * Case ID 021
	 * Create new space with hidden and open mode
	 */
	@Test
	public void test21_CreateNewSpaceWithHiddenAndOpenMode(){
		String spaceName = "SpaceCase21";

		String spaceDescription = "test21: create a new space";

		//String groupToInviteUsers = "Organization/Employees";

		info("-- Step 1: Go to space page --");

		goToMySpacePage();

		info("-- Step 2/3/4/5/6 : Create a new space with the visibility: Hidden and Registration: Open mode --");

		addNewSpace(spaceName, spaceDescription, "Hidden", "Open", "", "");

		info("-- With the hidden mode: other user can not see the space to send request joining --");

		signOut();

		signIn("demo", "gtn");

		goToAllSpaces();

		waitForTextNotPresent(spaceName);

		//waitForTextNotPresent("Request to Join");

		info ("-- Only manager of space can send the invitation to user --");

		//signOut();

		//signIn("john", "gtn");
		
		managerInviteUserToJoinSpace(userType.ADMIN, spaceName, userType.DEVELOPER);

		userAcceptInvitationToJoinSpace(true, userType.DEVELOPER, spaceName);

		signOut();

		signIn("john", "gtn");

		restoreData(spaceName, timeToDeleteSpace);
	}

	/**
	 * Case ID 022
	 * Create new space with hidden and Validation mode --> refer to Case ID 021
	 */

	/**
	 * Case ID 023
	 * Create new space with hidden and Close mode --> refer to Case ID 021
	 */
}
