package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.WikiPermission.permissionType;
import org.testng.annotations.*;


	public class Wiki_Permission_Page_Permission_Delete extends WIKI_TestConfig{

	/**
	*<li> Case ID:139346.</li>
	*<li> Test Case Name: Delete permissions for a user.</li>
	*<li> Pre-Condition: - wiki page PageA is already created
	- User A has permissions on PageA: View Pages or Edit Pages or both in Page Permissions
	- User A does not belong to any groups who have permission to View Pages, Edit Pages, in Wiki Settings</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DeletePermissionsForAUser() {
		info("Test 1: Delete permissions for a user");
		/*Step Number: 1
		*Step Name: Step 1: Open Page Permissions of PageA
		*Step Description: 
			- Open the wiki page PageA
			- Select More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			- Page Permissions form displays*/
		info("Create 2 new users");
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
		
		info("Set permission for the page");
		info("User A has permissions on PageA: View Pages, Edit Pages in Page Permissions");
		wHome.goToPermissions();
		wPermission.addPermisisonByType(arrayUsers.get(0));
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();

		/*Step number: 2
		*Step Name: Step 2: Delete permission for User A
		*Step Description: 
			- Check the User A permissions
			- Click Delete icon corresponding to User A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			User A is removed from Page Permissions*/
		info("Delete permission for User A");
		wHome.goToPermissions();
		wPermission.deletePermission("any");
		wPermission.deletePermission(arrayUsers.get(0));
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if User A have permission
		*Step Description: 
			- Login as User A
			- Go to the space 
			-
			-> Wiki
		*Input Data: 
			
		*Expected Outcome: 
			User A will not see the wiki page PageA anymore*/ 
		info("User A will not see the wiki page PageA anymore");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);
 	}

	/**
	*<li> Case ID:139348.</li>
	*<li> Test Case Name: Delete permissions by removing all for a user.</li>
	*<li> Pre-Condition: - wiki page PageA is already created
	- User A already has permissions: View Pages, Edit Pages in Page Permissions
	- User A does not belong to any groups who have View Pages, Edit Pages in Page Permissions</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DeletePermissionsByRemovingAllForAUser() {
		info("Test 2: Delete permissions by removing all for a user");
		/*Step Number: 1
		*Step Name: Step 1: Open Page Permissions form
		*Step Description: 
			- Open wiki page PageA
			- Go to More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			- Page Permissions form displays*/
		info("Create 2 new users");
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
		
		info("Set permission for the page");
		info("User A has permissions on PageA: View Pages, Edit Pages in Page Permissions");
		wHome.goToPermissions();
		wPermission.deletePermission("any");
		wPermission.addPermisisonByType(arrayUsers.get(0));
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();

		/*Step number: 2
		*Step Name: Step 2: Remove all permissions for User A
		*Step Description: 
			- Check User A permissions
			- Untick View Pages and Edit Pages checkboxes corresponding to User A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- View Pages and Edit Pages are deselected
			- User A is removed from Page Permissions form*/
		info("Remove all permissions for User A");
		wHome.goToPermissions();
		wPermission.unSelectPermission(arrayUsers.get(0),permissionType.Edit_Pages);
		wPermission.unSelectPermission(arrayUsers.get(0),permissionType.View_Pages);
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if User A has permission
		*Step Description: 
			- Log in as User A
			- Go to space 
			-
			-> Wiki
		*Input Data: 
			
		*Expected Outcome: 
			User A will not see PageA in the left panel. If User A use the direct link of PageA, "Page Not Found" is shown*/ 
		info("User A will not see the wiki page PageA anymore");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);
 	}

	/**
	*<li> Case ID:139352.</li>
	*<li> Test Case Name: Delete permissions for a group.</li>
	*<li> Pre-Condition: - wiki page PageA is already created
	- Group A has permissions on PageA: View Pages or Edit Pages or both in Page Permissions
	- Member of Group A does not belong to any groups who have permission: View Pages, Edit Pages, in Page Permissions</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_DeletePermissionsForAGroup() {
		info("Test 3: Delete permissions for a group");
		/*Step Number: 1
		*Step Name: Step 1: Open Page Permissions form
		*Step Description: 
			- Go to space 
			-
			-> Wiki
			- Open the wiki page PageA
			- Select More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			- Page Permissions form displays*/
		info("Create 1 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
		info("Add users to the group");
		String group = permisGroups.getDataColOneByArrayTypeRandom(8);
		String membership = permisMem.getDataContentByArrayTypeRandom(1);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.selectGroup(group);
		Utils.pause(2000);
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
		
		info("Set permission for the page");
		String groupOtherName = permisGroups.getDataColTwoByArrayTypeRandom(8);
		wHome.goToPermissions();
		wPermission.deletePermission("any");
		wPermission.addPermisisonByType(groupOtherName);
		wPermission.selectPermission(groupOtherName, permissionType.Edit_Pages);
		wPermission.savePermisison();


		/*Step number: 2
		*Step Name: Step 2: Delete permission for Group A
		*Step Description: 
			- Check the Group A permissions
			- Click Delete icon corresponding to Group A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Permission of Group A is deleted*/
		info("Delete permission for User A");
		wHome.goToPermissions();
		wPermission.deletePermission(groupOtherName);
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if Group A have deleted permission
		*Step Description: 
			- Login as user member of Group A
			- Go to the space 
			-
			-> Wiki
		*Input Data: 
			
		*Expected Outcome: 
			The user will not see PageA in the left panel anymore*/
		info("User A will not see the wiki page PageA anymore");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);

 	}

	/**
	*<li> Case ID:139355.</li>
	*<li> Test Case Name: Delete permissions by removing all for a group.</li>
	*<li> Pre-Condition: - wiki page PageA is already created
	- Group A already has permissions: View Pages, Edit Pages in Page Permissions
	- Member of Group A does not belong to any groups who have View Pages, Edit Pages in Page Permissions
	- Member of Group A does not have permissions: View Pages, Edit Pages in Page Permissions</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_DeletePermissionsByRemovingAllForAGroup() {
		info("Test 4: Delete permissions by removing all for a group");
		/*Step Number: 1
		*Step Name: Step 1: Open Page Permissions form
		*Step Description: 
			- Open wiki page PageA
			- Go to More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			- Page Permissions form displays*/
		info("Create 1 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
		info("Add users to the group");
		String group = permisGroups.getDataColOneByArrayTypeRandom(8);
		String membership = permisMem.getDataContentByArrayTypeRandom(1);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.selectGroup(group);
		Utils.pause(2000);
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
		String urlPage=this.driver.getCurrentUrl();
		
		info("Set permission for the page");
		String groupOtherName = permisGroups.getDataColTwoByArrayTypeRandom(8);
		wHome.goToPermissions();
		wPermission.deletePermission("any");
		wPermission.addPermisisonByType(groupOtherName);
		wPermission.selectPermission(groupOtherName, permissionType.Edit_Pages);
		wPermission.savePermisison();


		/*Step number: 2
		*Step Name: Step 2: Remove all permissions for Group A
		*Step Description: 
			- Check Group A permissions
			- Untick View Pages and Edit Pages checkboxes corresponding to Group A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- View Pages and Edit Pages are deselected
			- Group A is removed from Page Permissions form*/
		info("Remove all permissions for User A");
		wHome.goToPermissions();
		wPermission.unSelectPermission(groupOtherName,permissionType.Edit_Pages);
		wPermission.unSelectPermission(groupOtherName,permissionType.View_Pages);
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if Group A has permission
		*Step Description: 
			- Log in as user member of Group A
			- Go to space 
			-
			-> Wiki
		*Input Data: 
			
		*Expected Outcome: 
			The user will not see PageA in the left panel. 
			If the user uses the direct link of PageA, "Page Not Found" is shown*/ 
		info("User A will not see the wiki page PageA anymore");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page);
		
		this.driver.get(urlPage);
		wValidate.verifyPageNotFound();

 	}}