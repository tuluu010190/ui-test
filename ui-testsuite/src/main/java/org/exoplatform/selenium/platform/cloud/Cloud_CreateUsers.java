package org.exoplatform.selenium.platform.cloud;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.Test;

public class Cloud_CreateUsers extends Cloud_Config {
	@Test
	public  void Create_Users() {
		String username1 = DATA_USER1; //john
		String password1 = DATA_PASS;
		String email1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();
		String first1 = DATA_NAME_USER1.trim().substring(0,DATA_NAME_USER1.trim().indexOf(" "));
		String last1 = DATA_NAME_USER1.trim().substring(DATA_NAME_USER1.trim().indexOf(" ")+1);

		String username2 = DATA_USER2; //mary
		String password2 = DATA_PASS;
		String email2 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();
		String first2 = DATA_NAME_USER2.trim().substring(0,DATA_NAME_USER2.trim().indexOf(" "));
		String last2 = DATA_NAME_USER2.trim().substring(DATA_NAME_USER2.trim().indexOf(" ")+1);

		String username3 = DATA_USER3; //james
		String password3 = DATA_PASS;
		String email3 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();
		String first3 = DATA_NAME_USER3.trim().substring(0,DATA_NAME_USER3.trim().indexOf(" "));
		String last3 = DATA_NAME_USER3.trim().substring(DATA_NAME_USER3.trim().indexOf(" ")+1);

		String username4 = DATA_USER4; //demo
		String password4 = DATA_PASS;
		String email4 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();
		String first4 = DATA_NAME_USER4.trim().substring(0,DATA_NAME_USER4.trim().indexOf(" "));
		String last4 = DATA_NAME_USER4.trim().substring(DATA_NAME_USER4.trim().indexOf(" ")+1);

		String username5 = userData1.userName.get(5); //jack
		String password5 = DATA_PASS;
		String email5 = txData.getContentByArrayTypeRandom(1) + getRandomNumber() + mailSuffixData.getMailSuffixRandom();
		String first5 = userData1.fullName.get(5).trim().substring(0,userData1.fullName.get(5).trim().indexOf(" "));
		String last5 = userData1.fullName.get(5).trim().substring(userData1.fullName.get(5).trim().indexOf(" ")+1);

		String groupPath;
		String memberships1;
		String memberships2;
		String memberships3;
		String memberships4;
		String memberships5;
		String memberships6;

		/*Precondition:
		 	- User A is connected with User B, User C, User D and User E
			- User A has posted an activity
			- User B has liked User A activity
			- User C has liked User A activity
			- User D has liked User A activity
			- User E has liked User A activity
			- The notification "Someone likes one of my activities" is activated in the user settings*/
		info("Add 5 users");
		navTool.goToAddUser();
		addUserPage.addUser(username1, password1, email1, first1, last1);
		addUserPage.addUser(username2, password2, email2, first2, last2);
		addUserPage.addUser(username3, password3, email3, first3, last3);
		addUserPage.addUser(username4, password4, email4, first4, last4);
		addUserPage.addUser(username5, password5, email5, first5, last5);

		//Group Management
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.chooseGroupTab();

		//Admin
		groupPath = portGroupPermisData.getContentByIndex(0);
		memberships1 = portMemPermisData.getContentByIndex(0); //*
		memberships2 = portMemPermisData.getContentByIndex(3); //manager
		userAndGroup.selectGroup(groupPath);
		userAndGroup.addUsersToGroup(DATA_USER1, memberships1, false, false);
		userAndGroup.addUsersToGroup(DATA_USER1, memberships2, false, false);
		click(userAndGroup.ELEMENT_UP_LEVEL);

		//platform/users
		groupPath = portGroupPermisData.getContentByIndex(2); //Platform/Users
		memberships1 = portMemPermisData.getContentByIndex(0); //*
		userAndGroup.selectGroup(groupPath);
		userAndGroup.addUsersToGroup(DATA_USER1, memberships1, false, false);
		click(userAndGroup.ELEMENT_UP_LEVEL);

		//Publisher
		groupPath = portGroupPermisData.getContentByIndex(3); //Platform/Content Management
		memberships1 = portMemPermisData.getContentByIndex(0); //*
		memberships2 = portMemPermisData.getContentByIndex(3); //manager
		memberships3 = portMemPermisData.getContentByIndex(2); //editor
		memberships4 = portMemPermisData.getContentByIndex(1); //author
		memberships5 = portMemPermisData.getContentByIndex(6); //redactor
		userAndGroup.selectGroup(groupPath);
		userAndGroup.addUsersToGroup(DATA_USER1, memberships1, false, false);
		userAndGroup.addUsersToGroup(DATA_USER2, memberships2, false, false);
		userAndGroup.addUsersToGroup(DATA_USER2, memberships3, false, false);
		userAndGroup.addUsersToGroup(DATA_USER3, memberships4, false, false);
		userAndGroup.addUsersToGroup(DATA_USER3, memberships5, false, false);
		click(userAndGroup.ELEMENT_UP_LEVEL);

		//Organization/Management/Executive Board
		groupPath = portGroupPermisData.getContentByIndex(4); //Organization/Management/Executive Board
		userAndGroup.selectGroup(groupPath);
		userAndGroup.addUsersToGroup(DATA_USER1, memberships1, false, false);
		click(userAndGroup.ELEMENT_UP_LEVEL);
		click(userAndGroup.ELEMENT_UP_LEVEL);

		//Developer
		groupPath = portGroupPermisData.getContentByIndex(5); //Development
		memberships6 = portMemPermisData.getContentByIndex(4); //member
		userAndGroup.selectGroup(groupPath);
		userAndGroup.addUsersToGroup(DATA_USER4, memberships6, false, false);
		userAndGroup.addUsersToGroup(username5, memberships6, false, false);
		userAndGroup.addUsersToGroup(DATA_USER1, memberships6, false, false);
	}
}
