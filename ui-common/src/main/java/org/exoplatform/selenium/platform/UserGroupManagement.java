package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.Assert;

public class UserGroupManagement extends PlatformBase {
	public static final String ELEMENT_MESSAGE_DUPLICATE_USER = "User \"${username}\" has already the same membership ";
	public static final String ELEMENT_MESSAGE_DUPLICATE_GROUP = "in the group \"${groupName}\", please select another one.";
	public static final String ELEMENT_USER_INGROUP_DELETE_ICON = "//div[@id='UIGridUser']//div[text()='${username}']/../..//img[@class='DeleteUserIcon']";

	public static void chooseUserTab(){
		info("-- Choose User tab--");
		click(ELEMENT_USER_MANAGEMENT);
		waitForTextPresent("User Name");
	}

	public static void chooseGroupTab() {
		info("-- Choose Group Management tab--");
		click(ELEMENT_TAB_GROUP_MANAGEMENT);
		waitForTextPresent("Group Info");
	}

	public static void addGroup(String groupName, String groupLabel, String groupDesc, boolean verify){
		info("--Add a new group--");
		pause(500);
		click(ELEMENT_GROUP_ADD_NEW_ICON);
		type(ELEMENT_INPUT_GROUP_NAME, groupName, true);
		type(ELEMENT_INPUT_LABEL, groupLabel, true);
		type(ELEMENT_TEXTAREA_DESCRIPTION, groupDesc, true);
		save();
		if (verify) {
			waitForAndGetElement("//a[@title='" + (groupLabel.length() > 0 ? groupLabel : groupName) + "']");
		}
	}

	public static void addUsersToGroup(String userNames, String memberShip, boolean select, boolean verify) {

		info("--Adding users to group--");
		String[] users = userNames.split(",");
		if (select) {
			click(ELEMENT_GROUP_SEARCH_USER_ICON);
			waitForTextPresent("Select User");
			for (String user : users) {
				check("//input[@name='" + user + "']");
			}
			click(ELEMENT_GROUP_SEARCH_POPUP_ADD_ICON);
			pause(500);
			Assert.assertEquals(getValue(ELEMENT_INPUT_USERNAME), userNames);
		} else {
			type(ELEMENT_INPUT_USERNAME, userNames, true);
		}
		select(ELEMENT_SELECT_MEMBERSHIP, memberShip);
		save();
		if (verify) {
			for (String user : users) {
				String addedUser = ELEMENT_GROUP_USER_IN_TABLE.replace("${username}", user);
				if (isTextPresent("Total pages")) {
					usePaginator(addedUser, "User " + user + "not found in group");
				} else {
					waitForAndGetElement(addedUser);
				}
			}
		}
	}

	//Add a duplicate user into group with the same role
	public static void addDuplicateUserToGroup(String groupName, String userName, String memberShip){
		info("-- Add a duplicate user into group with the same role --");
		String MESSAGE_DUPLICATE_USER = ELEMENT_MESSAGE_DUPLICATE_USER.replace("${username}", userName);
		String MESSAGE_DUPLICATE_USER_WITH_SAME_ROLE = MESSAGE_DUPLICATE_USER + ELEMENT_MESSAGE_DUPLICATE_GROUP.replace("${groupName}", groupName);
		selectGroup(groupName);
		type(ELEMENT_INPUT_USERNAME, userName, true);
		select(ELEMENT_SELECT_MEMBERSHIP, memberShip);
		save();
		waitForMessage(MESSAGE_DUPLICATE_USER_WITH_SAME_ROLE);
		click(ELEMENT_OK_BUTTON);	
	}	

	public static void deleteUser(String username) {
		String userDeleteIcon = ELEMENT_USER_DELETE_ICON.replace("${username}", username);

		info("--Deleting user " + username + "--");
		if (isTextPresent("Total pages")) {
			usePaginator(userDeleteIcon, "User " + username + "not found in group");
		}
		pause(500);
		click(userDeleteIcon);
		waitForConfirmation("Are you sure to delete user " + username + "?");
		type(ELEMENT_INPUT_SEARCH_USER_NAME, username, true);
		select(ELEMENT_SELECT_SEARCH_OPTION, "User Name");
		click(ELEMENT_SEARCH_ICON_USERS_MANAGEMENT);
		waitForMessage("No result found.");
		closeMessageDialog();
		waitForTextNotPresent(username);
	}

	//Delete a user in current group
	public static void deleteUserInGroup(String groupName, String groupLabel, String username){
		String userDeleteIcon = ELEMENT_USER_INGROUP_DELETE_ICON.replace("${username}", username);
		String MESSAGE_DELETE_CONFIRMATION = "Are you sure to delete user " + username + " from group " + groupName + "?";

		if (groupLabel != ""){
			selectGroup(groupLabel);
		}
		else {
			selectGroup(groupName);
		}

		info("--Deleting user " + username + "--");
		if (isTextPresent("Total pages")) {
			usePaginator(userDeleteIcon, "User " + username + "not found in group");
		}
		pause(500);
		click(userDeleteIcon);
		waitForConfirmation(MESSAGE_DELETE_CONFIRMATION);
		waitForTextNotPresent(username);	
	}

	public static void searchUser(String user, String searchOption){
		info("--Search user " + user + "--");
		if (isTextPresent("Search")){
			type(ELEMENT_INPUT_SEARCH_USER_NAME, user, true);
			select(ELEMENT_SELECT_SEARCH_OPTION, searchOption);
		}	

		click(ELEMENT_SEARCH_ICON_USERS_MANAGEMENT);
		waitForTextPresent(user);
	}

	public static void editUser(String username) {
		String userEditIcon = ELEMENT_USER_EDIT_ICON.replace("${username}", username);

		info("--Editing user " + username + "--");
		click(userEditIcon);
		pause(1000);
	}

	public static void selectGroup(String groupName) {
		info("--Select category (" + groupName + ")--");
		String groupID = "//a[@title='"+ groupName +"']"; 
		waitForAndGetElement("//a[@title='"+ groupName +"']");
		click(groupID);
	}

	public static void editGroup(String groupName, boolean verify){
		info("-- Edit group: " + groupName + "--");
		click(ELEMENT_GROUP_EDIT_ICON);
		pause(1000);
	}

	public static void deleteGroup(String groupName, boolean verify) {
		info("-- Delete group: " + groupName + "--");
		click(ELEMENT_GROUP_REMOVE_ICON);

		waitForConfirmation("Are you sure to delete this group?");
		if (verify) {
			waitForElementNotPresent("//a[@title='"+ groupName +"']");
		}
		pause(1000);
	}

	public static void chooseMembershipTab() {
		info("-- Choose Membership Management tab--");
		pause(500);
		click(ELEMENT_TAB_MEMBERSHIP_MANAGEMENT);
		waitForTextPresent("Add/Edit Membership");
	}

	public static void addMembership(String membershipName, String membershipDesc, boolean verify){
		boolean verifyMembership;
		info("--Creating new membership--");
		click(ELEMENT_TAB_MEMBERSHIP_MANAGEMENT);

		type(ELEMENT_INPUT_NAME, membershipName, true);
		type(ELEMENT_TEXTAREA_DESCRIPTION, membershipDesc, true);
		save();
		verifyMembership = isTextPresent(membershipName);
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else if (verify){
			click(ELEMENT_NEXT_PAGE_ICON);	
			waitForTextPresent(membershipName);
		}

	}

	public static void editMembership(String membershipName, String newDesc){
		info("-- Edit membership: " + membershipName + "--");

		boolean verifyMembership;
		verifyMembership = isTextPresent(membershipName);
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else {
			click(ELEMENT_NEXT_PAGE_ICON);
		}

		String editIcon = ELEMENT_MEMBERSHIP_EDIT_ICON.replace("${membership}", membershipName);
		String membershipInput = "//input[@value='" + membershipName + "']";
		click(editIcon);
		pause(1000);
		waitForAndGetElement(membershipInput);
		type(ELEMENT_TEXTAREA_DESCRIPTION, newDesc, true);
		save();
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else {
			click(ELEMENT_NEXT_PAGE_ICON);
		}
		waitForTextPresent(newDesc);
	}

	public static void deleteMembership(String membershipName, boolean verify){

		boolean verifyMembership;
		verifyMembership = isTextPresent(membershipName);
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else {
			click(ELEMENT_NEXT_PAGE_ICON);
		}
		String deleteIcon = ELEMENT_MEMBERSHIP_DELETE_ICON.replace("${membership}", membershipName);
		info("--Deleting membership--");
		click(deleteIcon);
		waitForConfirmation("Are you sure to delete this membership?");
		if (!verifyMembership){
			waitForTextNotPresent(membershipName);
		}
		else if (verify) {
			click(ELEMENT_NEXT_PAGE_ICON);
			waitForTextNotPresent(membershipName);
		}
	}

	// Add new user account 
	public static void addNewUserAccount(String username, String password, String confirmPassword, String firstName, 
			String lastName, String email, String userNameGiven, String language, boolean verify) {

		info("--Create new user using \"New Staff\" portlet--");
		type(ELEMENT_INPUT_USERNAME, username, true);
		type(ELEMENT_INPUT_PASSWORD, password, true);
		type(ELEMENT_INPUT_CONFIRM_PASSWORD, confirmPassword, true);
		type(ELEMENT_INPUT_FIRSTNAME, firstName, true);
		type(ELEMENT_INPUT_LASTNAME, lastName, true);
		type(ELEMENT_INPUT_EMAIL, email, true);
		click(ELEMENT_USER_PROFILE_TAB);
		waitForTextPresent("Given Name:");
		type(ELEMENT_INPUT_USER_NAME_GIVEN, userNameGiven, true);
		select(ELEMENT_SELECT_USER_LANGUAGE, language);
		click(ELEMENT_ACCOUNT_SETTING_TAB);
		save();

		if (verify) {
			waitForMessage("You have registered a new account.");
			closeMessageDialog();
		}
	}

	//Edit user in My Account
	public static void editUserInMyAccount(String firstName, String lastName, String email, String currentPassword, String newPassword, 
			String confirmNewPassword){
		info("-- Edit user in My Account --");

		type(ELEMENT_INPUT_FIRSTNAME, firstName, true);
		type(ELEMENT_INPUT_LASTNAME, lastName, true);
		type(ELEMENT_INPUT_EMAIL, email, true);
		click(ELEMENT_CHANGE_PASSWORD_TAB);
		waitForTextPresent("Current Password:");

		type(ELEMENT_INPUT_CURRENTPASSWORD, currentPassword, true);
		type(ELEMENT_INPUT_NEW_PASSWORD_MYACCOUNT, newPassword, true);
		type(ELEMENT_INPUT_NEW_CONFIRM_PASSWORD_MYACCOUNT, confirmNewPassword, true);
		click(ELEMENT_ACCOUNT_PROFILE_TAB);

		save();		
		waitForMessage("The account information has been updated.")		;
		closeMessageDialog();
		close();
	}

}
