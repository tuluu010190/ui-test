package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.WikiPermission.permissionType;
import org.testng.annotations.*;


	public class Wiki_Permission_Wiki_Permission_Delete extends WIKI_TestConfig_2{

	/**
	*<li> Case ID:139347.</li>
	*<li> Test Case Name: Delete permissions for a user.</li>
	*<li> Pre-Condition: - User A already has permissions: View Pages or Edit Pages or Admin Pages or Admin Wiki, or some of them, or all these permissions
	- Some wiki pages are already created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DeletePermissionsForAUser() {
		info("Test 1: Delete permissions for a user");
		/*Step Number: 1
		*Step Name: Step 1: Open form to add permission for space
		*Step Description: 
			- Go to Browse 
			-
			-> Wiki Settings
			- Choose Permission tab
		*Input Data: 
			
		*Expected Outcome: 
			Space Permissions form appears*/
		info("Create 1 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info(" Open form to add permission for space");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		wSetting.goToPermissionTab();
		
		info("Select user to add permission");
		wPermission.addPermisisonByType(arrayUsers.get(0));
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);
		arrayGroupsPath.add(arrayUsers.get(0));

		/*Step number: 2
		*Step Name: Step 2: Delete permission
		*Step Description: 
			- Check permissions of User A
			- Click Delete icon corresponding to User A
		*Input Data: 
			
		*Expected Outcome: 
			User A with his permissions are removed from Permissions table*/
		info("Delete permission for User A");
		wPermission.deletePermission("any");
		wPermission.deletePermission(arrayUsers.get(0));
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);

		/*Step number: 3
		*Step Name: Step 3: Check if the deleted user has any permission
		*Step Description: 
			- Login as User A
			- Go to the space 
			-
			-> Wiki
		*Input Data: 
			
		*Expected Outcome: 
			User A cannot view any wiki page: Page Not Found*/ 
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);

 	}

	/**
	*<li> Case ID:139349.</li>
	*<li> Test Case Name: Delete permissions for a group.</li>
	*<li> Pre-Condition: - Group A already has permissions: View Pages or Edit Pages or Admin Pages or Admin Wiki, or some of them, or all these permissions
	- Some wiki pages are already created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DeletePermissionsForAGroup() {
		info("Test 2: Delete permissions for a group");
		/*Step Number: 1
		*Step Name: Step 1: Open form to add permission for space
		*Step Description: 
			- Go to Browse 
			-
			-> Wiki Settings
			- Choose Permission tab
		*Input Data: 
			
		*Expected Outcome: 
			Space Permissions form appears*/
		info("Create 1 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
		info("Create a new group");
		String groupName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupLabel = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupDesc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.addGroup(groupName, groupLabel, groupDesc, true);
		arrayGroups.add(groupLabel);
		
		info("Add users to the group");
		String membership = permisMem.getDataContentByArrayTypeRandom(1);
		Utils.pause(2000);
		userAndGroup.selectGroup(groupLabel);
		userAndGroup.addUsersToGroup(arrayUsers.get(0),membership,false,true);
		
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info(" Open form to add permission for space");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		wSetting.goToPermissionTab();
		
		info("Select group to add permission");
		String groupUsers ="*:/"+groupName;
		wPermission.addPermisisonByType(groupUsers);
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);
		arrayGroupsPath.add(groupUsers);

		/*Step number: 2
		*Step Name: Step 2: Delete permission
		*Step Description: 
			- Check permissions of Group A
			- Click Delete icon corresponding to Group A
		*Input Data: 
			
		*Expected Outcome: 
			Group A with their permissions are removed from Permissions table*/
		
		info("Delete permission for User A");
		wPermission.deletePermission("any");
		wPermission.deletePermission(groupUsers);
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);

		/*Step number: 3
		*Step Name: Step 3: Check if the deleted user has any permission
		*Step Description: 
			- Login as user member of Group A
			- Go to the space 
			-
			-> Wiki
		*Input Data: 
			
		*Expected Outcome: 
			The user cannot view any wiki page: Page Not Found*/ 
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);

 	}

	/**
	*<li> Case ID:139603.</li>
	*<li> Test Case Name: Delete permission for a group by unchecking all permission.</li>
	*<li> Pre-Condition: - The Group A has already the permission : View Pages in the Wiki Settings
	- Some wiki pages are already created in this space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_DeletePermissionForAGroupByUncheckingAllPermission() {
		info("Test 3: Delete permission for a group by unchecking all permission");
		/*Step Number: 1
		*Step Name: Step 1: Open form to add permission for space
		*Step Description: 
			- Go to Browse 
			-
			-> Wiki Settings
			- Choose Permission tab
		*Input Data: 
			
		*Expected Outcome: 
			Space Wiki Permissions form appears*/
		info("Create 1 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
		info("Create a new group");
		String groupName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupLabel = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupDesc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.addGroup(groupName, groupLabel, groupDesc, true);
		arrayGroups.add(groupLabel);
		
		info("Add users to the group");
		String membership = permisMem.getDataContentByArrayTypeRandom(1);
		Utils.pause(2000);
		userAndGroup.selectGroup(groupLabel);
		userAndGroup.addUsersToGroup(arrayUsers.get(0),membership,false,true);
		
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info(" Open form to add permission for space");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		wSetting.goToPermissionTab();
		
		info("Select group to add permission");
		String groupUsers ="*:/"+groupName;
		wPermission.addPermisisonByType(groupUsers);
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);
		arrayGroupsPath.add(groupUsers);

		/*Step number: 2
		*Step Name: Step 2: Delete permission for a Group
		*Step Description: 
			- Check the Group A permission
			- In the permission table, uncheck all permission checkbox of the Group A
			- Click Save 
			-
			-> OK
		*Input Data: 
			
		*Expected Outcome: 
			- The permission View Pages is unselected(if the group had only the View permission, the group is is auto
			-removed from the Wiki Permissions table)*/
		info("Delete permission for User A");
		wPermission.deletePermission("any");
		wPermission.unSelectPermission(groupUsers, permissionType.View_Pages);
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);

		/*Step number: 3
		*Step Name: Step 3: Check if the deselected group can view the page
		*Step Description: 
			- Log in with a user member of the Group A
			- Go to Wiki of the space.
		*Input Data: 
			
		*Expected Outcome: 
			- The user cannot view the wiki page: Page Not Found*/ 
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);

 	}

	/**
	*<li> Case ID:139604.</li>
	*<li> Test Case Name: Delete permission for a user by unchecking all permission checkbox.</li>
	*<li> Pre-Condition: - The User A has already the permission : View Pages in the Wiki Settings
	- Some wiki pages are already created in this space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_DeletePermissionForAUserByUncheckingAllPermissionCheckbox() {
		info("Test 4: Delete permission for a user by unchecking all permission checkbox");
		/*Step Number: 1
		*Step Name: Step 1: Open form to add permission for space
		*Step Description: 
			- Go to Browse 
			-
			-> Wiki Settings
			- Choose Permission tab
		*Input Data: 
			
		*Expected Outcome: 
			Space Wiki Permissions form appears*/
		info("Create 1 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info(" Open form to add permission for space");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		wSetting.goToPermissionTab();
		
		info("Select user to add permission");
		wPermission.addPermisisonByType(arrayUsers.get(0));
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);
		arrayGroupsPath.add(arrayUsers.get(0));


		/*Step number: 2
		*Step Name: Step 2: Delete permission for a User
		*Step Description: 
			- Check the User A permission
			- In the permission table, uncheck all permission checkbox of the User A
			- Click Save 
			-
			-> OK
		*Input Data: 
			
		*Expected Outcome: 
			- The permission View Pages is unselected(if the user had only the View permission, he is is auto
			-removed from the Wiki Permissions table)*/
		info("Delete permission for User A");
		wPermission.deletePermission("any");
		wPermission.unSelectPermission(arrayUsers.get(0), permissionType.View_Pages);
		wPermission.savePermisison();
		wHome.confirmWaringMessage(true);

		/*Step number: 3
		*Step Name: Step 3: Check if the deselected user can view the page
		*Step Description: 
			- Log in as User A
			- Go to Wiki of the space.
		*Input Data: 
			
		*Expected Outcome: 
			- The user cannot view the wiki page: Page Not Found*/ 
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);
 	}}