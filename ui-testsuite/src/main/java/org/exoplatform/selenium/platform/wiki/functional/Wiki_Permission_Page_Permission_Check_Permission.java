package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.WikiPermission.permissionType;
import org.testng.annotations.*;


	public class Wiki_Permission_Page_Permission_Check_Permission extends WIKI_TestConfig{

	/**
	*<li> Case ID:139350.</li>
	*<li> Test Case Name: Verify view permission for a user.</li>
	*<li> Pre-Condition: - wiki page PageA already is created
	- User A has permissions on PageA: View Pages, Edit Pages in Page Permissions
	- User A does not belong to any group who has Edit Pages in Page Permissions</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_VerifyViewPermissionForAUser() {
		info("Test 1: Verify view permission for a user");
		/*Step Number: 1
		*Step Name: Step 1: Open Page Permissions form
		*Step Description: 
			- Open the wiki page PageA
			- Go to More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page Permissions form displays*/
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
		*Step Name: Step 2: Delete Edit Pages permission for User A
		*Step Description: 
			- Check the User A permission
			- In the permission table, untick the Edit Pages checkbox of the User A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Edit Pages checkbox is deselected*/
		info("Delete Edit Pages permission for User A");
		wHome.goToPermissions();
		wPermission.unSelectPermission(arrayUsers.get(0),permissionType.Edit_Pages);
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if the User A has Edit Pages permission
		*Step Description: 
			- Login as User A
			- Go to space 
			-
			-> Wiki
			- Select PageA
		*Input Data: 
			
		*Expected Outcome: 
			- The user A can view the wiki page PageA 
			but cannot see Edit Page, Add Page; Move Page and Delete Page from More menu*/ 
		info("Check if the User A has Edit Pages permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		waitForElementNotPresent(wHome.ELEMENT_EDIT_PAGE_LINK);
		waitForElementNotPresent(wHome.ELEMENT_ADD_PAGE_LINK);
		click(wHome.ELEMENT_MORE_LINK);
		waitForElementNotPresent(wHome.ELEMENT_MOVE_PAGE);
		waitForElementNotPresent(wHome.ELEMENT_DELETE_LINK);
 	}

	/**
	*<li> Case ID:139351.</li>
	*<li> Test Case Name: Verify view permission for a group.</li>
	*<li> Pre-Condition: - wiki page PageA already is created
	- Group A already has permissions on the wiki page PageA: View Pages, Edit Pages in Page Permissions
	- Member of Group A does not belong to any groups who have Edit Pages permission in Page Permissions
	- Member of Group A does not have Edit Pages permission in Page Permissions</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_VerifyViewPermissionForAGroup() {
		info("Test 2: Verify view permission for a group");
		/*Step Number: 1
		*Step Name: Step 1: Open the wiki page
		*Step Description: 
			- Open the wiki page PageA
			- Go to More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page Permissions form displays*/
		info("Create 2 new users");
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
		wPermission.addPermisisonByType(groupOtherName);
		wPermission.selectPermission(groupOtherName, permissionType.Edit_Pages);
		wPermission.savePermisison();

		/*Step number: 2
		*Step Name: Step 2: Delete Edit Pages permission for Group A
		*Step Description: 
			- Check the Group A permission
			- In the permission table, untick the Edit Pages checkbox of the Group A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Edit Pages checkbox is deselected*/
		info("Delete Edit Pages permission for User A");
		wHome.goToPermissions();
		wPermission.unSelectPermission(groupOtherName,permissionType.Edit_Pages);
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if the Group A has Edit Pages permission
		*Step Description: 
			- Login as user member of Group A
			- Go to space 
			-
			-> Wiki
			- Select the wiki page
		*Input Data: 
			
		*Expected Outcome: 
			- The user can view PageA but cannot see Edit Page, Add Page; Move Page and Delete Page from More menu*/ 
		info("Check if the User A has Edit Pages permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		waitForElementNotPresent(wHome.ELEMENT_EDIT_PAGE_LINK);
		waitForElementNotPresent(wHome.ELEMENT_ADD_PAGE_LINK);
		click(wHome.ELEMENT_MORE_LINK);
		waitForElementNotPresent(wHome.ELEMENT_MOVE_PAGE);
		waitForElementNotPresent(wHome.ELEMENT_DELETE_LINK);

 	}

	/**
	*<li> Case ID:139353.</li>
	*<li> Test Case Name: Verify Edit permission for a user.</li>
	*<li> Pre-Condition: - wiki page PageA is already created
	- User A already has permissions: View Pages, Edit Pages in Page Permissions
	- User A does not belong to any groups who have permissions: View Pages, Edit Pages in Page Permissions</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_VerifyEditPermissionForAUser() {
		info("Test 3: Verify Edit permission for a user");
		/*Step Number: 1
		*Step Name: Step 1: Open Page Permissions form
		*Step Description: 
			- Open wiki page PageA
			- Select More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page Permissions form appears*/
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
		wPermission.savePermisison();

		/*Step number: 2
		*Step Name: Step 2: Delete View permission for User A
		*Step Description: 
			- Check the User A permission
			- In the permission table, check the Edit Pages checkbox of the User A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- The permission View Pages and Edit Pages are selected*/
		info("Delete Edit Pages permission for User A");
		wHome.goToPermissions();
		wPermission.selectPermission(arrayUsers.get(0),permissionType.Edit_Pages);
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if UserA can view the page
		*Step Description: 
			- Log in as User A
			- Go to space 
			-
			-> Wiki
		*Input Data: 
			
		*Expected Outcome: 
			- The user can view PageA and can see Edit Page, Add Page; Move Page and Delete Page from More menu*/ 
		info("Check if the User A has Edit Pages permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		waitForAndGetElement(wHome.ELEMENT_EDIT_PAGE_LINK);
		waitForAndGetElement(wHome.ELEMENT_ADD_PAGE_LINK);
		click(wHome.ELEMENT_MORE_LINK);
		waitForAndGetElement(wHome.ELEMENT_MOVE_PAGE);
		waitForAndGetElement(wHome.ELEMENT_DELETE_LINK);

 	}

	/**
	*<li> Case ID:139354.</li>
	*<li> Test Case Name: Verify Edit permission for a group.</li>
	*<li> Pre-Condition: - wiki page PageA is already created
	- Group A already has permissions: View Pages, Edit Pages in Page Permissions
	- Member of Group A does not belong to any groups who have permissions: View Pages, Edit Pages in Page Permissions
	- Member of Group A does not have permission: View Pages, Edit Pages in Page Permissions</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_VerifyEditPermissionForAGroup() {
		info("Test 4: Verify Edit permission for a group");
		/*Step Number: 1
		*Step Name: Step 1: Open Page Permissions form
		*Step Description: 
			- Open the wiki page PageA
			- Select More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page Permissions form appears*/
		info("Create 2 new users");
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
		wPermission.addPermisisonByType(groupOtherName);
		wPermission.savePermisison();

		/*Step number: 2
		*Step Name: Step 2: Delete View permission for Group A
		*Step Description: 
			- Check the Group A permission
			- In the permission table, check the Edit Pages checkbox of the Group A
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- The permission View Pages and Edit Pages are selected*/
		info("Delete Edit Pages permission for group");
		wHome.goToPermissions();
		wPermission.selectPermission(groupOtherName,permissionType.Edit_Pages);
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Check if Group A can view the page
		*Step Description: 
			- Log in as user member of Group A
			- Go to Wiki of the space.
		*Input Data: 
			
		*Expected Outcome: 
			- The user can view PageA and can see Edit Page, Add Page; Move Page and Delete Page from More menu*/ 
		info("Check if the User A has Edit Pages permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		waitForAndGetElement(wHome.ELEMENT_EDIT_PAGE_LINK);
		waitForAndGetElement(wHome.ELEMENT_ADD_PAGE_LINK);
		click(wHome.ELEMENT_MORE_LINK);
		waitForAndGetElement(wHome.ELEMENT_MOVE_PAGE);
		waitForAndGetElement(wHome.ELEMENT_DELETE_LINK);

 	}}