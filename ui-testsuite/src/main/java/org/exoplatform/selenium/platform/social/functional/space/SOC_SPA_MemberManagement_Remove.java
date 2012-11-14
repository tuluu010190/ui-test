package org.exoplatform.selenium.platform.social.functional.space;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import static org.exoplatform.selenium.platform.UserGroupManagement.*;
import static org.exoplatform.selenium.platform.social.ManageMember.*;

import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.social.ManageMember.userType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author vuna2
 * Date: 21/11/2012
 * Test cases: Social/Space/Member community/Remove 
 *
 */
public class SOC_SPA_MemberManagement_Remove extends SpaceManagement{
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
	 * Remove a normal member from the space
	 */
	@Test
	public void test01_RemoveANormalMemberFromTheSpace(){

		String spaceName = "RemoveNormalMemberCase1";

		String spaceDescription = "Case 01: create a new space";

		info("-- Step 1: Create a new Space --");

		goToMySpacePage();

		addNewSpace(spaceName, spaceDescription);

		info("-- Step 2: Invite an user --");

		managerInviteUserToJoinSpace(userType.ADMIN, spaceName, userType.PUBLISHER);
		
		info("-- Step 3: Accept the invitation --");

		userAcceptInvitationToJoinSpace(true, userType.PUBLISHER, spaceName);

		info("-- Step 4: Remove a member from the space --");

		managerRemoveMemberFromSpace(userType.ADMIN, spaceName, "Mary");

		info("-- Verify that User Mary can't access this space but she might send a request to join back --");

		userRequestToJoinSpace(userType.PUBLISHER, spaceName);

		signOut();

		signIn(DATA_USER, DATA_PASS);

		restoreData(spaceName, timeToDeleteSpace);
	}

	/**
	 * Case ID 002
	 * Remove a normal member from the space (by request to join)
	 */
	@Test
	public void test02_RemoveANormalMemberFromTheSpaceByRequest(){

		String spaceName = "RemoveNormalMemberCase02";

		String spaceDescription = "Case 02: create a new space";

		info("-- Step 1: Create a new Space --");

		goToMySpacePage();

		addNewSpace(spaceName, spaceDescription);

		info("-- Step 2: Request to join the space created by step 1 --");

		userRequestToJoinSpace(userType.DEVELOPER, spaceName);

		info("-- Step 3: Accept request to join --");

		//signOut();

		//signIn("john", "gtn");

		managerAcceptRequestFromUser(true, userType.ADMIN, userType.DEVELOPER, spaceName);

		signOut();

		signIn("demo", "gtn");

		goToMySpacePage();

		waitForTextPresent(spaceName);

		managerRemoveMemberFromSpace(userType.ADMIN ,spaceName, "Jack");

		info("-- Verify that User Jack can't access this space but he might send a request to join back --");

		userRequestToJoinSpace(userType.DEVELOPER, spaceName);

		signOut();

		signIn(DATA_USER, DATA_PASS);

		restoreData(spaceName, timeToDeleteSpace);
	}

	/**
	 * Case ID 003
	 * Remove user Root from the Space
	 */
	@Test
	public void test03_RemoveUserRootFromTheSpace(){

		String spaceName = "RemoveRootFromSpace03";

		String spaceDescription = "Case 03: create a new space";

		info("-- Step 1: Create a new Space --");

		goToMySpacePage();

		addNewSpace(spaceName, spaceDescription);

		info("-- Step 2: Invite an user:  Add Root into space group --");

		managerInviteUserToJoinSpace(userType.ADMIN, spaceName, userType.ROOT);

		signOut();

		signIn("root", "gtn");

		goToMySpacePage();

		waitForTextPresent(spaceName);

		info("-- Step 3: Remove a member from the space --");

		managerRemoveMemberFromSpace(userType.ADMIN, spaceName, "Root");

		info("-- Verify that the user Root always get all the rights as a manager of space --");

		signOut();

		signIn("root", "gtn");

		goToMySpacePage();

		editSpace(spaceName, "Edit RemoveRootFromSpace03", "New Description", false, "");
		
		goToMySpacePage();

		deleteSpace("Edit RemoveRootFromSpace03", timeToDeleteSpace);
	}

	/**
	 * Case ID 004
	 * Delete user from Space group
	 */
	@Test
	public void test04_DeleteUserFromSpaceGroup(){
		
		String spaceName = "deleteuserspacegroup4";

		String spaceDescription = "Case 04: create a new space";
		
		info("-- Step 1: Create a new Space --");

		goToMySpacePage();

		addNewSpace(spaceName, spaceDescription);

		info("-- Step 2: Invite an user:  Add Jack into space group --");

		managerInviteUserToJoinSpace(userType.ADMIN, spaceName, userType.AUTHOR);

		userAcceptInvitationToJoinSpace(true, userType.AUTHOR, spaceName);

		info("-- Step 3 & 4: Step 4: Delete a member from space group --");
		
		signOut();

		signIn("john", "gtn");
		
		goToUsersAndGroupsManagement();
		
		chooseGroupTab();
		
		deleteUserInGroup("Spaces/"+spaceName, "", "james");
		
		info("-- Verify that User James can't access this space but he might send a request to join back --");

		userRequestToJoinSpace(userType.AUTHOR, spaceName);

		signOut();

		signIn(DATA_USER, DATA_PASS);

		//Reset data
		restoreData(spaceName, timeToDeleteSpace);
	}
}
