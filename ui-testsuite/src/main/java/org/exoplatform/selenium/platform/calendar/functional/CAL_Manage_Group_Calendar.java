package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Manage_Group_Calendar extends CAL_TestConfig_2{

	/**
	*<li> Case ID:116279.</li>
	*<li> Test Case Name: Check selecting a group in Show in Groups tabs.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckSelectingAGroupInShowInGroupsTabs() {
		info("Test 1: Check selecting a group in Show in Groups tabs");
		/*Step Number: 1
		*Step Name: Step 1. Add a Group calendar
		*Step Description: 
			+ Log in to Calendar
			- Click Add Calendar in Calendar menu+ Fill name as ADD_CALENDAR_GROUP_04+ Select Show in Groups tabs+ Click Group icon+ Select a Group eg Web
			-contributor+ Click Add button
		*Input Data: 
			
		*Expected Outcome: 
			- Group web
			-contributor is displayed in the list*/
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String[] user={DATA_USER2};
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectUserEditPermissionInGroup(user,1);
        cMang.saveAddCalendar();
        
		/*Step number: 2
		*Step Name: Step 2. Save
		*Step Description: 
			Click Save button
		*Input Data: 
			
		*Expected Outcome: 
			New Group calendar with name ADD_CALENDAR_GROUP_04 is created with the selected group*/ 
        hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar ));
 		
 		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116281.</li>
	*<li> Test Case Name: Check displaying Show in Groups tab once the group is added..</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckDisplayingShowInGroupsTabOnceTheGroupIsAdded() {
		info("Test 2: Check displaying Show in Groups tab once the group is added.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Click Group button
			- Choose a group
		*Input Data: 
			
		*Expected Outcome: 
			The table is displayed: 
			- Group name
			- A text field to display users and memberships with edit permissions
			- Two buttons "Provide edit permission to users" 
			and "Provide edit permission to memberships" 
			and one button "Delete permission" to remove the sharing with the group*/ 
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_SELECT_USER_BTN);
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_SELECT_ROLE_BTN);
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_REMOVE_BTN.replace("$group","Web contributors"));
 	}

	/**
	*<li> Case ID:116282.</li>
	*<li> Test Case Name: Check displaying in Show in Groups tab after selecting a group including created user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckDisplayingInShowInGroupsTabAfterSelectingAGroupIncludingCreatedUser() {
		info("Test 3: Check displaying in Show in Groups tab after selecting a group including created user");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar as root
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Click Group button
			- Choose a group eg platform/ administrator
		*Input Data: 
			
		*Expected Outcome: 
			Root is automatically added in the text field of column 2.*/ 
		info("Create a new calendar");
		String userGroup="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_USER_PERMISSION.replace("$user",DATA_USER1));
 	}

	/**
	*<li> Case ID:116283.</li>
	*<li> Test Case Name: Check selecting users and memberships.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CheckSelectingUsersAndMemberships() {
		info("Test 4: Check selecting users and memberships");
		/*Step Number: 1
		*Step Name: Create a group calendar
		*Step Description: 
			- Log in to Calendar as root
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Click Group button
			-Click icon users or memberships
			- Select user/ membership
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Calendar is created*/
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String[] user={DATA_USER2};
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectUserEditPermissionInGroup(user,1);
        cMang.saveAddCalendar();
        
		/*Step number: 2
		*Step Name: Login as user having edit permission
		*Step Description: 
			- Login as Selected users/ membership.
		*Input Data: 
			
		*Expected Outcome: 
			- He/ she can edit this calendar.*/ 
        
        magAc.signOut();
        magAc.signIn(DATA_USER2, DATA_PASS);
        hp.goToCalendarPage();
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar ));
        cMang.openMenuOfCalendar(calendar);
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_SHARE_MENU,2000,2);
        
        magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116285.</li>
	*<li> Test Case Name: Check delete group with delete icon in action column.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_CheckDeleteGroupWithDeleteIconInActionColumn() {
		info("Test 5: Check delete group with delete icon in action column");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Click Group button
			- Choose a group/ user/ membership
			- Save
			- Edit this Calendar, Open Show in Group tabs
			- Click delete icon of group
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- New group calendar is created
			- Group is deleted
			- This calendar won't belong to any group anymore*/ 
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        click(cMang.ELEMENT_CALENDAR_GROUP_REMOVE_BTN.replace("$group","Web contributors"));
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar ));
        
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116286.</li>
	*<li> Test Case Name: Check editing values of the textfield manually.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_CheckEditingValuesOfTheTextfieldManually() {
		info("Test 6: Check editing values of the textfield manually");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Click Group button
			- Type a valid group/ user/ membership in the text field
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- New group calendar is created for typed group*/ 
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String[] user={DATA_USER2};
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectUserEditPermissionInGroup(user,1);
        cMang.saveAddCalendar();
        
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116287.</li>
	*<li> Test Case Name: Check delete groups when creating a calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_CheckDeleteGroupsWhenCreatingACalendar() {
		info("Test 7: Check delete groups when creating a calendar");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Click Group button to select some groups
			- Click [Delete_icon] corresponding to each group to delete. Repeat this step to delete all groups.
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- All groups are deleted.
			- New calendar is created as a personal calendar.*/ 
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String userGroup1="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectGroupInGroupTabCalendarForm(userGroup1,true);
        cMang.removeGroupInGroupTabCalendarForm("Web contributors");
        cMang.removeGroupInGroupTabCalendarForm("Administrators");
        cMang.saveAddCalendar();
        
        hp.goToCalendarPage();
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar ));
        
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116288.</li>
	*<li> Test Case Name: Check delete groups when editing a calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CheckDeleteGroupsWhenEditingACalendar() {
		info("Test 8: Check delete groups when editing a calendar");
		/*Step Number: 1
		*Step Name: Add new group calendar
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Fill name as ADD_CALENDAR_GROUP_13
			- Select Show in Groups tabs
			- Click Group button
			- Select a group
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- A group calendar is created*/

		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String userGroup1="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectGroupInGroupTabCalendarForm(userGroup1,true);
        cMang.saveAddCalendar();
        
		/*Step number: 2
		*Step Name: Edit calendar and delete all groups
		*Step Description: 
			- Edit calendar 
			+Add some more groups 
			+ Click delete icon to delete each group, 
			just keep 1 group 
			+ Click delete icon of the last group 
			+ Save
		*Input Data: 
			
		*Expected Outcome: 
			- Delete icon of the unique group is disabled with tooltip "only one permission, cannot delete"
			- The calendar is still group calendar*/ 
        cMang.editCalendar(calendar,null,null,null,null);
        cMang.removeGroupInGroupTabCalendarForm("Administrators");
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TOOLTIP_ONLY_PERMISSION.replace("$group","Web contributors"));
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_REMOVE_DISABLE_BTN.replace("$group","Web contributors"));
        cMang.saveAddCalendar();
        
        cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116290.</li>
	*<li> Test Case Name: Check Group Calendar after creating a new space then Edit its name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_CheckGroupCalendarAfterCreatingANewSpaceThenEditItsName() {
		info("Test 9: Check Group Calendar after creating a new space then Edit its name");
		/*Step Number: 1
		*Step Name: Create new space
		*Step Description: 
			- Log in to Calendar as admin
			- Create new space with name GROUPS_05
		*Input Data: 
			
		*Expected Outcome: 
			New space with name GROUPS_05 is created successfully*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("create new space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		/*Step number: 2
		*Step Name: Check Group calendar of space
		*Step Description: 
			- Go to intranet/ Calendar 
			- View list of Group Calendar
		*Input Data: 
			
		*Expected Outcome: 
			A group Calendar is created & displayed under Group calendar box with the same space's name ie: GROUPS_05*/

		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",space));
		
		/*Step number: 3
		*Step Name: Check user can edit this Group calendar name
		*Step Description: 
			- Click on wheel incon of group calendar then choose Edit
			- Type new name with name GROUPS_05_Edited
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Group calendar name is updated with new name GROUPS_05_Edited*/ 
 		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
 		cMang.editCalendar(space,space1,null,null,null);
 		cMang.saveAddCalendar();
 		
 		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",space1));
         
        cMang.deleteCalendar(space1, true);
 	}

	/**
	*<li> Case ID:116293.</li>
	*<li> Test Case Name: Check all users are able to create a group calendar..</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_CheckAllUsersAreAbleToCreateAGroupCalendar() {
		info("Test 10 Check all users are able to create a group calendar.");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			- Log in as admin or normal user
			- Click Add Calendar
			- Fill name: GROUP_CALENDAR_01
			- Select Show in Group tabs
			- Choose a group
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Group calendar is created as user selectsBoth admin & normal user can create his own group calendar*/
		magAc.signOut();
		magAc.signIn(DATA_USER4, DATA_PASS);
		info("Create a new calendar");
		String userGroup="/platform/users";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
        
        hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
         
        cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116294.</li>
	*<li> Test Case Name: Check group calendar is displayed in group calendar list of group's  users.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_CheckGroupCalendarIsDisplayedInGroupCalendarListOfGroupsUsers() {
		info("Test 11 Check group calendar is displayed in group calendar list of group's  users");
		/*Step Number: 1
		*Step Name: - Create group calendar
		*Step Description: 
			- Log in as root
			- Create a group calendar with name GROUP_CALENDAR_03 for group web
			-contributor (include: root, john, mary, james)
		*Input Data: 
			
		*Expected Outcome: 
			A Group calendar with name GROUP_CALENDAR_03 is listed under Group calendar.*/
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
        
        hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		
 		/*Step number: 2
		*Step Name: Check group member can see group calendar
		*Step Description: 
			- Log in as james/ mary
			- Go to Calendar
			- See group calendar's list
		*Input Data: 
			
		*Expected Outcome: 
			GROUP_CALENDAR_03 is displayed in group calendar list of james/ mary*/ 
 		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
	 	magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116295.</li>
	*<li> Test Case Name: Check space members have edit permission on group calendar of space.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_CheckSpaceMembersHaveEditPermissionOnGroupCalendarOfSpace() {
		info("Test 12 Check space members have edit permission on group calendar of space");
		/*Step Number: 1
		*Step Name: Step 1. Create new calendar
		*Step Description: 
			- Log in as admin 
			- Create a space, eg GROUP_CALENDAR_02
		*Input Data: 
			
		*Expected Outcome: 
			A Group calendar with name "GROUP_CALENDAR_02" is listed under Group calendar.*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("create new space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		hp.goToCalendarPage();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",space));
		
		/*Step number: 2
		*Step Name: Step 2. Invite member
		*Step Description: 
			- Invite mary 
			- mary accepts
		*Input Data: 
			
		*Expected Outcome: 
			Mary becomes member of space*/
       
	 	hp.goToSpecificSpace(space);
	 	spaHome.goToSpaceSettingTab();
		setSpaceMg.goToMemberTab();
		setSpaceMg.inviteUser(DATA_USER2,true,DATA_NAME_USER2);
		
		magAc.signOut();
	    magAc.signIn(DATA_USER2, DATA_PASS);
	    hp.goToAllSpace();
	    spaMg.goToInvitationsReceivedTab();
	    spaMg.acceptAInvitation(space);
	 	
		/*Step number: 3
		*Step Name: Step 3. Check member can see group calendar
		*Step Description: 
			- Log in as mary
			- Go to Calendar
			- See group calendar list
		*Input Data: 
			
		*Expected Outcome: 
			- GROUP_CALENDAR_02 is displayed in group calendar of mary*/

		hp.goToCalendarPage();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",space));
	 	
		/*Step number: 4
		*Step Name: Step 4. Check mary has edit permission
		*Step Description: 
			Click Wheel icon of group calendar GROUP_CALENDAR_02
		*Input Data: 
			
		*Expected Outcome: 
			Action menu of calendar GROUP_CALENDAR_02 appears with 
			- Add Event,
			- Add task,
			- Edit,
			- Remove,
			- Import,
			- Export,
			- Refresh,
			- Color gridmary can do all actions above*/ 
	 	cMang.openMenuOfCalendar(space);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_TASK_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_EVENT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_IMPORT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_EXPORT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REFRESH_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REMOVE_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(space, true);

 	}

	/**
	*<li> Case ID:116296.</li>
	*<li> Test Case Name: Check owner of group calendar can assign permission to group's member.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_CheckOwnerOfGroupCalendarCanAssignPermissionToGroupsMember() {
		info("Test 13 Check owner of group calendar can assign permission to group's member");
		/*Step Number: 1
		*Step Name: - Create new group calendar
		*Step Description: 
			- Log in as root
			- Create a group calendar
			+Fill name: GROUP_CALENDAR_04
			+ Select Show in Groups tab, 
			choose group web-contributor
			+ Click Add
			+ Click icon Provide Edit permission to user or Provide Edit permission to membership
			+ Choose user/ membership+ Save
		*Input Data: 
			
		*Expected Outcome: 
			A Group calendar is createdwith user/ membership with edit permission as assigned*/ 
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String[] user={DATA_USER2};
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectUserEditPermissionInGroup(user,1);
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_USER_PERMISSION.replace("$user",DATA_USER1+", "+DATA_USER2));
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
        
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116297.</li>
	*<li> Test Case Name: Check user with "edit permissions".</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_CheckUserWithEditPermissions() {
		info("Test 14 Check user with edit permissions");
		/*Step Number: 1
		*Step Name: - Create new group calendar
		*Step Description: 
			- Log in as root
			- Create a group calendar+Fill name: GROUP_CALENDAR_05
			+ Select Show in Groups tab, choose group administrator
			+ Click Add+ Click icon Provide Edit permission to user or Provide Edit permission to membershipeg: mary+ Save
		*Input Data: 
			
		*Expected Outcome: 
			A Group calendar is createdwith mary has edit permission*/
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String[] user={DATA_USER2};
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectUserEditPermissionInGroup(user,1);
        cMang.saveAddCalendar();
        Utils.pause(2000);
        hp.goToCalendarPage();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		/*Step number: 2
		*Step Name: Check user with edit permission
		*Step Description: 
			- Log in as mary<br />
			- Go to Calendar<br />
			- Click wheel icon of calendar above
		*Input Data: 
			
		*Expected Outcome: 
			she has full right: 
			-Change "edit permissions"
			- Create/Edit/Delete an event/task
			- Delete the calendar
			- Import/Export events
			- Edit the calendar
			- Change color of calendar*/ 
        magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_TASK_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_EVENT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_IMPORT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_EXPORT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REFRESH_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REMOVE_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116298.</li>
	*<li> Test Case Name: Check a group calendar can not be shared.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_CheckAGroupCalendarCanNotBeShared() {
		info("Test 15 Check a group calendar can not be shared");
		/*Step Number: 1
		*Step Name: - Create new group calendar
		*Step Description: 
			- Log in as root
			- Create a group calendar+Fill name: GROUP_CALENDAR_06
			+ Select Show in Groups tab, choose group administrator
			+ Click Add+ Save
		*Input Data: 
			
		*Expected Outcome: 
			A Group calendar is created*/
		info("Create a new calendar");
		String userGroup="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
		/*Step number: 2
		*Step Name: Check cannot share group calendar
		*Step Description: 
			- Click wheel icon of calendar above
		*Input Data: 
			
		*Expected Outcome: 
			There is no option Share. User cannot share a group calendar*/ 
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_MENU,2000,2);
		
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116299.</li>
	*<li> Test Case Name: Check  action menu of the user having edit permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_CheckActionMenuOfTheUserHavingEditPermission() {
		info("Test 16 Check  action menu of the user having edit permission");
		/*Step Number: 1
		*Step Name: - Create new group calendar
		*Step Description: 
			- Log in as root
			- Create a group calendar+Fill name: GROUP_CALENDAR_07
			+ Select Show in Groups tab, choose group administrator
			+ Assign edit permission for an user, eg john+ Click Add+ Save
		*Input Data: 
			
		*Expected Outcome: 
			A Group calendar is created*/
		info("Create a new calendar");
		String userGroup="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
		/*Step number: 2
		*Step Name: Checkaction menu of user having edit permission
		*Step Description: 
			- Log in as john
			- Click wheel icon of calendar above
		*Input Data: 
			
		*Expected Outcome: 
			Action menu is displayed as 
			-Add event
			-Add task
			-Edit
			-Remove
			-Import
			-Export
			-Refresh
			-Color selection grid*/ 
	 	hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_TASK_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_EVENT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_IMPORT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_EXPORT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REFRESH_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REMOVE_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
		
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116300.</li>
	*<li> Test Case Name: Check  action menu of the user having read permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_CheckActionMenuOfTheUserHavingReadPermission() {
		info("Test 17 Check  action menu of the user having read permission");
		/*Step Number: 1
		*Step Name: - Create new group calendar
		*Step Description: 
			- Log in as root
			- Create a group calendar+Fill name:GROUP_CALENDAR_08
			+ Select Show in Groups tab, choose group administrator
			+ Not Assign edit permission for an user+ Save
		*Input Data: 
			
		*Expected Outcome: 
			A Group calendar is created with 1 user having read permission above*/
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
		/*Step number: 2
		*Step Name: Check action menu of user having edit permission
		*Step Description: 
			- Log in as user having read permission
			- Click wheel icon of calendar above
		*Input Data: 
			
		*Expected Outcome: 
			Action menu is displayed as 
			-Refresh*/
	 	
	 	magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		Utils.pause(2000);
		cMang.openMenuOfCalendar(calendar);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_ADD_TASK_MENU,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_ADD_EVENT_MENU,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_IMPORT_MENU,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_EXPORT_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REFRESH_MENU,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_REMOVE_MENU,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);


 	}

	/**
	*<li> Case ID:116301.</li>
	*<li> Test Case Name: Check a personal calendar cannot be transformed as a group calendar..</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_CheckAPersonalCalendarCannotBeTransformedAsAGroupCalendar() {
		info("Test 18 Check a personal calendar cannot be transformed as a group calendar.");
		/*Step Number: 1
		*Step Name: - Create new personal calendar
		*Step Description: 
			- Log in as root
			- Click Add Calendar
			- Fill name GROUP_CALENDAR_09 in Detail tab
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Personal calendar is created*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
		/*Step number: 2
		*Step Name: CheckA personal calendar cannot be transformed as a group calendar
		*Step Description: 
			- Click wheel icon of calendar above, Click Edit
		*Input Data: 
			
		*Expected Outcome: 
			Show in Group tab is not shown to change personal calendar to group calendar*/ 
	 	cMang.openMenuOfCalendar(calendar);
	 	cMang.executeActionCalendar(calendar, menuOfCalendarOption.EDIT);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_GROUP_TAB,2000,2);
		cMang.saveAddCalendar();
		
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116302.</li>
	*<li> Test Case Name: Check Group Calendar name after creating a new space.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_CheckGroupCalendarNameAfterCreatingANewSpace() {
		info("Test 19 Check Group Calendar name after creating a new space");
		/*Step Number: 1
		*Step Name: Create new space
		*Step Description: 
			- Log in to Calendar as admin
			- Create new space with name GroupCalendar10
		*Input Data: 
			
		*Expected Outcome: 
			New space GroupCalendar10 is created successfully*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("create new space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		
		
		/*Step number: 2
		*Step Name: Check Group calendar of space
		*Step Description: 
			- Go to intranet/ Calendar 
			- View list of Group Calendar
		*Input Data: 
			
		*Expected Outcome: 
			A group Calendar is created & displayed under Group calendar list with name GroupCalendar10*/ 
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",space));
 		
 		hp.goToCalendarPage();
		cMang.deleteCalendar(space, true);
 	}

	/**
	*<li> Case ID:116327.</li>
	*<li> Test Case Name: Remove group calendar by user who does not have edit right.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test20_RemoveGroupCalendarByUserWhoDoesNotHaveEditRight() {
		info("Test 20 Remove group calendar by user who does not have edit right");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add new group calendar
		*Input Data: 
			- Create new group calendar
			- Do notshare edit permission for users in the shared group [ Details ]
		*Expected Outcome: 
			The added calendar is displayed in that group's calendars list*/
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Remove group calendar
		*Input Data: 
			- Login by a user who does not have edit right onon the added group calendar
			- Click Action on that calendar
		*Expected Outcome: 
			No see Remove option*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_REMOVE_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116328.</li>
	*<li> Test Case Name: Remove group calendar by user who has edit right.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test21_RemoveGroupCalendarByUserWhoHasEditRight() {
		info("Test 21 Remove group calendar by user who has edit right");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add new group calendar
		*Input Data: 
			- Create new group calendar
			- Share edit permission for users in the shared group [ Details ]
		*Expected Outcome: 
			The added calendar is displayed in that group's calendars list*/
		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String[] user={DATA_USER2};
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectUserEditPermissionInGroup(user,1);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Remove group calendar with edit right
		*Input Data: 
			- Login by member of group above who has edit right on the added group calendar
			- Click Action on that calendar and select Remove
		*Expected Outcome: 
			After confirm deleting, that calendar is removed from the group it is belong to.*/ 
	 	magAc.signOut();
	 	magAc.signIn(DATA_USER2, DATA_PASS);
	 	hp.goToCalendarPage();
	 	cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116452.</li>
	*<li> Test Case Name: Edit group calendar by adding more membership with edit permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	* if groups > 2, the notification is fade out
	*/
	@Test
	public  void test22_EditGroupCalendarByAddingMoreMembershipWithEditPermission() {
		info("Test 22 Edit group calendar by adding more membership with edit permission");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show edit group calendar form
		*Input Data: 
			- Create new group calendar[ Details ]
			- Right click on the calendar and select Edit
		*Expected Outcome: 
			- Edit group calendar form is shown, with Calendar details tab and Calendar group tab
			- Current informations of that calendar are displayed in form*/
		info("Create a new calendar");
		String userGroup="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Edit calendar
		*Input Data: 
			- Select new membership type of a checked group for edit permission
			- Click Save
		*Expected Outcome: 
			- Edit group calendar form is shown, with Calendar details tab and Calendar group tab
			- New selected membership is added in corresponding field, separated with existing value by comma.
			- User with new selected membership can do any actions on that calendar*/
	 	String userGroup1="/platform/web-contributors";
	 	String[] user={DATA_USER2};
	 	hp.goToCalendarPage();
	 	cMang.editCalendar(calendar, null,null,null,userGroup1);
	 	cMang.selectUserEditPermissionInGroup(user,1);
	 	cMang.removeGroupInGroupTabCalendarForm("Administrators");
	 	cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			Step 3: Edit calendar with wrong username
		*Input Data: 
			- In the "Groups" tab, enter a username that doesn't exist in the column "User able to edit calendar"
			- Click Save
		*Expected Outcome: 
			- A notification informs the user that he cannot set a username that does not exist in this field*/ 
	 	String[] user1={"abc"};
	 	hp.goToCalendarPage();
	 	cMang.editCalendar(calendar, null,null,null,null);
	 	click(cMang.ELEMENT_CALENDAR_GROUP_TAB);
	 	cMang.selectUserEditPermissionInGroup(user1,0);
	 	cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_WARINING_POPUP);
	 	click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
	 	cMang.cancelAddCalendar();
	 	
		hp.goToCalendarPage();
	 	cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116461.</li>
	*<li> Test Case Name: Enable public access to Group Calendar URL.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test23_EnablePublicAccessToGroupCalendarURL() {
		info("Test 23 Enable public access to Group Calendar URL");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create group calendar
		*Input Data: 
			- Login as Root successfully
			- Go to Calendar
			- Create a group calendar
			- Save
		*Expected Outcome: 
			Group calendar is added*/
		info("Create a new calendar");
		String userGroup="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			Step 2: Enable public access to Group Calendar URL
		*Input Data: 
			- Click on wheel icon of calendar then Edit
			- Click on Enable Public Access link
		*Expected Outcome: 
			- Enable Public Access link (blue
			-highlighted) can be clicked
			- After the click, message shown on screen is This calendar is public access.*/ 
		cMang.enabledPublicAccess(calendar);
		String urlPublic=cMang.getPublicAccessLink(calendar);
   		cMang.saveAddCalendar();
   		
   		hp.goToCalendarPage();
	 	cMang.deleteCalendar(calendar, true);
	 	
   		if(!urlPublic.isEmpty()) assert true;
   		else assert false;
 	}

	/**
	*<li> Case ID:116462.</li>
	*<li> Test Case Name: View shared Group Calendar by public link.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test24_ViewSharedGroupCalendarByPublicLink() {
		info("Test 24 View shared Group Calendar by public link");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 2: View shared Group Calendar by public link of CS
		*Input Data: 
			- Log out
			- Go to CS by public link
			- Click on Calendar to see shared calendar
		*Expected Outcome: 
			- Person/acc in shared Groups can see Calendar*/ 
		info("Create a new calendar");
		String userGroup="/platform/administrators";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
	 	waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	 	
	 	 info("Edit the calendar");
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		cMang.enabledPublicAccess(calendar);
   		String urlPublic=cMang.getPublicAccessLink(calendar);
   		cMang.saveAddCalendar();
   		String removeCharacter;
   		String nameCalendar;
   		if(!urlPublic.isEmpty()){
   			removeCharacter=urlPublic.replace("(","").replace(")","");
   	   		nameCalendar=removeCharacter.split("john/")[1].split("/")[0];
   	     	magAc.signOut();
   	       //Run the download link
   			this.driver.get(removeCharacter);
   			//downloadFileUsingRobotViaURL();
   		    checkFileExisted("TestOutput/" + nameCalendar);
   		    magAc.signIn(DATA_USER1, DATA_PASS);
   		}
	   		
	   		
   		hp.goToCalendarPage();
   		cMang.deleteCalendar(calendar, true);

 	}}