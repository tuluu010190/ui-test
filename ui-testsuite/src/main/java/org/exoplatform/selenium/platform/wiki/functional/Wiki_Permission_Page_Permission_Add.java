package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.WikiPermission.permissionType;
import org.exoplatform.selenium.platform.wiki.WikiPermission.userGroupTypes;
import org.testng.annotations.*;


	public class Wiki_Permission_Page_Permission_Add extends WIKI_TestConfig{

	/**
	*<li> Case ID:139324.</li>
	*<li> Test Case Name: Add permission for group by putting group's name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddPermissionForGroupByPuttingGroupsName() {
		info("Test 1: Add permission for group by putting group's name");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			-> Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More 
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all Users or Groups have permission to view/edit page*/
		info("Open form to page permission");
		wHome.goToPermissions();

		/*Step number: 3
		*Step Name: Step 3: Select user to add permission
		*Step Description: 
			- Put group's name in field
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected group is listed in permission's list with View Pages permission selected by default*/
		info("Select group to add permission");
		String groupUsers = permisGroups.getDataColTwoByArrayTypeRandom(8);
		wPermission.addPermisisonByType(groupUsers);

		/*Step number: 4
		*Step Name: Step 4: Select permission for group
		*Step Description: 
			- Select permission for group to view/edit by ticking the checkboxes
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Mermbers of the selected group has view/edit permission*/
		wPermission.selectPermission(groupUsers, permissionType.Edit_Pages);
		wPermission.savePermisison();
		
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(DATA_USER2,DATA_PASS);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139326.</li>
	*<li> Test Case Name: Add permission for group by selecting directly.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_AddPermissionForGroupBySelectingDirectly() {
		info("Test 2: Add permission for group by selecting directly");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			-> Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More 
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all User or Group have permission to view/edit page*/
		info("Open form to page permission");
		wHome.goToPermissions();

		/*Step number: 3
		*Step Name: Step 3: Select user to add permission
		*Step Description: 
			- Click on Add Group icon
			- Select 1 group
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected group is listed in permission's list with View Pages permission selected by default*/
		info("Select group to add permission");
		String groupUsers = permisGroups.getDataColOneByArrayTypeRandom(8);
		wPermission.addPermissionBySelect(groupUsers, "",userGroupTypes.Groups);

		/*Step number: 4
		*Step Name: Step 4: Select permission for group
		*Step Description: 
			- Select permission for user to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Members of the group has permission to view/edit this page*/
		String groupUsersOtherName = permisGroups.getDataColTwoByArrayTypeRandom(8);
		wPermission.selectPermission(groupUsersOtherName, permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(DATA_USER2,DATA_PASS);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();


 	}

	/**
	*<li> Case ID:139328.</li>
	*<li> Test Case Name: Add permission for group's membership  by selecting directly.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_AddPermissionForGroupsMembershipBySelectingDirectly() {
		info("Test 3: Add permission for group's membership  by selecting directly");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			->Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More 
			-> Page Permission
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all User or Group have permission to view/edit page*/
		

		/*Step number: 3
		*Step Name: Step 3: Select user to add permission
		*Step Description: 
			- Click on Select Membership icon
			- Select 1 group
			- Select membership of this group
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected group is listed in permission's list withView Pages permission selected by default*/
		
		info("Open form to page permission");
		wHome.goToPermissions();
		info("Select group to add permission");
		String groupUsers = permisGroups.getDataColOneByArrayTypeRandom(8);
		String membership = permisMem.getDataContentByArrayTypeRandom(1);
		wPermission.addPermissionBySelect(groupUsers,membership,userGroupTypes.Membership);

		/*Step number: 4
		*Step Name: Step 4: Select permission for group
		*Step Description: 
			- Select permission for user to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Members of the group has permission to view/edit this page*/
		String groupUsersOtherName = permisGroups.getDataColTwoByArrayTypeRandom(8);
		wPermission.selectPermission(groupUsersOtherName, permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(DATA_USER2,DATA_PASS);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139331.</li>
	*<li> Test Case Name: Add permission for multi-user at the same time.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_AddPermissionForMultiuserAtTheSameTime() {
		info("Test 4: Add permission for multi-user at the same time");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			->Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More 
			-> Page Permission
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all User or Group have permission to view/edit page*/
		info("Open form to page permission");
		wHome.goToPermissions();

		/*Step number: 3
		*Step Name: Step 3: Select user to add permission
		*Step Description: 
			- Click on Add User icon
			- Tick on some check
			-box corresponding with users want to add
			- Click on Add button
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected users are listed in permission's list with View Pages permission selected by default*/
		info(" Select user to add permission");
		wPermission.addPermissionBySelect(arrayUsers.get(0),"",userGroupTypes.Users_UserName);

		/*Step number: 4
		*Step Name: Step 4: Select permission for user
		*Step Description: 
			- Select permission for users to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- The selected users have permission to view/edit this page*/ 
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139333.</li>
	*<li> Test Case Name: Add permission for user by putting user's name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_AddPermissionForUserByPuttingUsersName() {
		info("Test 5: Add permission for user by putting user's name");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page / Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More/ Page Permission
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all User or Group have permission to view/edit page*/
		info("Open form to page permission");
		wHome.goToPermissions();

		/*Step number: 3
		*Step Name: Step 3: Select user to add permission
		*Step Description: 
			- Put user's name in field
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected user is listed in permission's list with View Pages permission selected by default*/

		info("Select user to add permission");
		wPermission.addPermisisonByType(arrayUsers.get(0));
		
		/*Step number: 4
		*Step Name: Step 4: Select permission for user
		*Step Description: 
			- Select permission for user to edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- User has permission to view/edit this page*/ 
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();


 	}

	/**
	*<li> Case ID:139335.</li>
	*<li> Test Case Name: Add permission for user by searching user by email.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_AddPermissionForUserBySearchingUserByEmail() {
		info("Test 6: Add permission for user by searching user by email");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page and Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More and Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all User or Group have permission to view/edit page*/
	

		/*Step number: 3
		*Step Name: Step 3: Searching user
		*Step Description: 
			- Click on Add User icon 
			- Choose Email
			- Put email in Search field
			- Click on Search icon
		*Input Data: 
			
		*Expected Outcome: 
			All users corresponding with the emails are listed*/
		

		/*Step number: 4
		*Step Name: Step 4: Select user to add permission
		*Step Description: 
			- Tick on check
			-box corresponding with user want to add
			- Click on Add button
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			- Selected user is listed in permission's list with View Pages permission selected by default*/
		info("Open form to page permission");
		wHome.goToPermissions();
		
		info("Select user to add permission");
		String email = arrayUsers.get(0)+"@gmail.com";
		wPermission.addPermissionBySelect(email,"",userGroupTypes.Users_Email);
		
		/*Step number: 5
		*Step Name: Step 5: Select permission for user
		*Step Description: 
			- Select permission for user to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			User has permission to view/edit this page*/ 
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139337.</li>
	*<li> Test Case Name: Add permission for user by searching user by first name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_AddPermissionForUserBySearchingUserByFirstName() {
		info("Test 7: Add permission for user by searching user by first name");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			-
			-> ’Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More 
			-
			-> Page Permission
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all User or Group have permission to view/edit page*/

		/*Step number: 3
		*Step Name: Step 3: Searching user
		*Step Description: 
			- Click on Add User icon 
			- Choose First Name
			- Put keyword in Search field
			- Click on Search icon
		*Input Data: 
			
		*Expected Outcome: 
			All users corresponding with the keyword are listed*/
		

		/*Step number: 4
		*Step Name: Step 4: Select user to add permission
		*Step Description: 
			- Tick on check
			-box corresponding with user want to add
			- Click on Add button
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			- Selected user is listed in permission's list with View Pages permission selected by default*/
		info("Open form to page permission");
		wHome.goToPermissions();
		info("Select user to add permission");
		wPermission.addPermissionBySelect(arrayUsers.get(0),"",userGroupTypes.Users_FirstName);
		
		/*Step number: 5
		*Step Name: Step 5: Select permission for user
		*Step Description: 
			- Select permission for user to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			User has permission to view/edit this page*/ 
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139339.</li>
	*<li> Test Case Name: Add permission for user by searching user by last name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_AddPermissionForUserBySearchingUserByLastName() {
		info("Test 8: Add permission for user by searching user by last name");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			-
			-> ’Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More â†’ Page Permission
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all Users or Groups have permission to view/edit page*/

		/*Step number: 3
		*Step Name: Step 3: Searching user
		*Step Description: 
			- Click on Add User icon 
			- Choose Last Name
			- Put keyword in Search field
			- Click on Search icon
		*Input Data: 
			
		*Expected Outcome: 
			All users corresponding with the keyword are listed*/

		/*Step number: 4
		*Step Name: Step 4: Select user to add permission
		*Step Description: 
			- Tick on check
			-box corresponding with user want to add
			- Click on Add button
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected user is listed in permission's list with View Pages permission selected by default*/

		info("Open form to page permission");
		wHome.goToPermissions();
		info("Select user to add permission");
		wPermission.addPermissionBySelect(arrayUsers.get(0),"",userGroupTypes.Users_LastName);
		/*Step number: 5
		*Step Name: Step 5: Select permission for user
		*Step Description: 
			- Select permission for user to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Selected user has permission to view/edit the page*/ 
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139341.</li>
	*<li> Test Case Name: Add permission for user by searching user by user name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_AddPermissionForUserBySearchingUserByUserName() {
		info("Test 9: Add permission for user by searching user by user name");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page â†’Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More â†’ Page Permission
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all Users or Groups have permission to view/edit page*/

		/*Step number: 3
		*Step Name: Step 3: Searching user
		*Step Description: 
			- Click on Add User icon 
			- Choose User Name
			- Put keyword in Search field
			- Click on Search icon
		*Input Data: 
			
		*Expected Outcome: 
			All users corresponding with the keyword are listed*/

		/*Step number: 4
		*Step Name: Step 4: Select user to add permission
		*Step Description: 
			- Tick on check
			-box corresponding with user want to add
			- Click on Add button
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected user is listed in permission's list with View Pages permission selected by default*/
		info("Open form to page permission");
		wHome.goToPermissions();
		info("Select user to add permission");
		wPermission.addPermissionBySelect(arrayUsers.get(0),"",userGroupTypes.Users_UserName);
		
		/*Step number: 5
		*Step Name: Step 5: Select permission for user
		*Step Description: 
			- Select permission for user to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			User has permission to view/edit this page*/ 
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139343.</li>
	*<li> Test Case Name: Add permission for user by selecting directly.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_AddPermissionForUserBySelectingDirectly() {
		info("Test 10 Add permission for user by selecting directly");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			-
			-> ’Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all Users or Groups have permission to view/edit page*/

		/*Step number: 3
		*Step Name: Step 3: Select user to add permission
		*Step Description: 
			- Click on Add User icon
			- Tick on check
			-box corresponding with user want to add
			- Click on Add button
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected user is listed in permission's list with View Pages permission selected by default*/
		info("Open form to page permission");
		wHome.goToPermissions();
		info("Select user to add permission");
		wPermission.addPermissionBySelect(arrayUsers.get(0),"",userGroupTypes.Users_UserName);
		
		/*Step number: 4
		*Step Name: Step 4: Select permission for user
		*Step Description: 
			- Select permission for user to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			User has permission to view/edit this page*/ 
		wPermission.selectPermission(arrayUsers.get(0), permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}

	/**
	*<li> Case ID:139345.</li>
	*<li> Test Case Name: Add permission for users by putting group's membership.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_AddPermissionForUsersByPuttingGroupsMembership() {
		info("Test 11 Add permission for users by putting group's membership");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Go to Add Page 
			-
			-> Blank Page (or From Template)
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful*/
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

		/*Step number: 2
		*Step Name: Step 2: Open form to page permission
		*Step Description: 
			- Select page above
			- Select More 
			-
			-> Page Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Page permission form appears. It list all Users or Groups have permission to view/edit page*/

		/*Step number: 3
		*Step Name: Step 3: Select user to add permission
		*Step Description: 
			- Put group's membership in field
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Selected groups is listed in permission's list with View Pages permission selected by default*/
		info("Open form to page permission");
		wHome.goToPermissions();
		info("Select group to add permission");
		String groupUsers = permisGroups.getDataColTwoByArrayTypeRandom(8);
		wPermission.addPermisisonByType(groupUsers);
		
		/*Step number: 4
		*Step Name: Step 4: Select permission for group's membership
		*Step Description: 
			- Select permission for group to view/edit
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Group has permission to view/edit this page*/ 
		wPermission.selectPermission(groupUsers, permissionType.Edit_Pages);
		wPermission.savePermisison();
		info("Mermbers of the selected group has view/edit permission");
		magAc.signOut();
		magAc.signIn(DATA_USER2,DATA_PASS);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToEditPage();

 	}}