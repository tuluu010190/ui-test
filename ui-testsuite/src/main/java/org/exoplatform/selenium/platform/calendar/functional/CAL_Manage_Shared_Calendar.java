package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Manage_Shared_Calendar extends CAL_TestConfig_2{
		String password;
		public void createNewUser(){
			info("Add new a user");
			int index = userInfoData.getRandomIndexByType(3);
			username = userInfoData.newUserName.get(index)+getRandomNumber();
			firstname = userInfoData.newFirstName.get(index);
			String lastname = userInfoData.newLastName.get(index);
			password = userInfoData.newPassword.get(index);
			String email = EMAIL_ADDRESS1;
			
			navTool.goToAddUser();
			addUserPage.addUser(username, password, email,firstname,lastname);
		}
	/**
	*<li> Case ID:116292.</li>
	*<li> Test Case Name: Delete a shared calendar by owner.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DeleteASharedCalendarByOwner() {
		info("Test 1: Delete a shared calendar by owner");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create and Share calendar
		*Input Data: 
			- Create new personal calendar [ Details ]
			- Share added calendar for some users[ Details ]
		*Expected Outcome: 
			- Added permission is listed
			- The shared user can see this calendar in shared calendars list*/

		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		 
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View calendar by shared user
		*Input Data: 
			- Login by the shared user
			- View his shared calendar list
		*Expected Outcome: 
			He can view shared calendar above with read/ edit permission*/
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			Step 3: Delete shared calendar by owner
		*Input Data: 
			- Log in by owner of this calendar
			- Delete this calendar
		*Expected Outcome: 
			Shared calendar is deleted*/
 		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			Step 4: Check with shared user
		*Input Data: 
			- Log in by shared calendar again
			- View his shared calendar list
		*Expected Outcome: 
			He cannot see calendar above in his share calendar list*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 	}

	/**
	*<li> Case ID:116316.</li>
	*<li> Test Case Name: Check all users are able to share their personal calendars.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckAllUsersAreAbleToShareTheirPersonalCalendars() {
		info("Test 2: Check all users are able to share their personal calendars");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			- Log in as admin or normal user
			- Click Add Calendar
			- Fill name SHARED_CALENDAR_01
			- Save
			- Click on wheel icon of above personal calendar
			- Click Share
			- Choose User/ group
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Personal calendar is created & sharedBoth admin & normal user can share his personal calendar*/ 
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 		
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
	*<li> Case ID:116317.</li>
	*<li> Test Case Name: Check displaying of shared calendar in shared user's calendar list.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckDisplayingOfSharedCalendarInSharedUsersCalendarList() {
		info("Test 3: Check displaying of shared calendar in shared user's calendar list");
		/*Step Number: 1
		*Step Name: - Create and share a calendar
		*Step Description: 
			- Log in as john
			- Click Add Calendar
			- Fill name: SHARED_CALENDAR_02
			- Save
			- Click on wheel icon of above personal calendar
			- Click Share
			- Choose mary
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Personal calendar is created & shared*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 		
		/*Step number: 2
		*Step Name: - Shared user check
		*Step Description: 
			- Log in as mary
			- See in shared calendar list
		*Input Data: 
			
		*Expected Outcome: 
			mary see SHARED_CALENDAR_02 in shared calendar list*/ 

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
	*<li> Case ID:116318.</li>
	*<li> Test Case Name: Check displaying of shared calendar in  owner's calendar list.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CheckDisplayingOfSharedCalendarInOwnersCalendarList() {
		info("Test 4: Check displaying of shared calendar in  owner's calendar list");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			- Log in as john
			- Click Add Calendar
			- Fill name: SHARED_CALENDAR_03
			- Save
			- Click on wheel icon of above personal calendar
			- Click Share
			- Choose an user
			- Save
			- See john's calendar list
		*Input Data: 
			
		*Expected Outcome: 
			SHARED_CALENDAR_03 is displayed in personal calendar list*/ 
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 		
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116319.</li>
	*<li> Test Case Name: Check Owner of the calendar is able to provide "edit permissions" to some users or groups.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_CheckOwnerOfTheCalendarIsAbleToProvideEditPermissionsToSomeUsersOrGroups() {
		info("Test 5: Check Owner of the calendar is able to provide edit permissions to some users or groups");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			- Log in as john
			- Click Add Calendar
			- Fill name: SHARED_CALENDAR_05
			- Save
			- Click on wheel icon of above personal calendar
			- Click Share
			- Choose an james
			- Tick Edit permission
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Calendar is shared, shared user has edit permission*/ 
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER3};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 		
 		magAc.signOut();
		magAc.signIn(DATA_USER3, DATA_PASS);
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 		
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116320.</li>
	*<li> Test Case Name: Check shared calendar with user having edit permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_CheckSharedCalendarWithUserHavingEditPermission() {
		info("Test 6: Check shared calendar with user having edit permission");
		/*Step Number: 1
		*Step Name: Create a personal calendar
		*Step Description: 
			- Log in as john
			- Click Add Calendar
			- Fill name as SHARED_CALENDAR_06
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Calendar is Created*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		/*Step number: 2
		*Step Name: Share calendar
		*Step Description: 
			- Click on wheel icon of SHARED_CALENDAR_06
			- Click Share
			- Choose mary
			- Tick Edit permission
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Calendar is shared, shared user has edit permission*/
        String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		hp.goToCalendarPage();
 		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
 		
		/*Step number: 3
		*Step Name: Check shared user can create event/ task
		*Step Description: 
			- Log in as mary
			- Choose shared calendar SHARED_CALENDAR_06
			- Create an event/ task
		*Input Data: 
			
		*Expected Outcome: 
			Event/ task is created on shared calendar*/
 		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,newEvent,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		/*Step number: 4
		*Step Name: Check shared user can edit event/ task
		*Step Description: 
			- Right click event/ task above, click Edit
			- Change some values
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Event/ task is edited*/

	    String newEvent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
	    cMang.openEditPopupEventByRightClick(newEvent);
	    evMg.inputBasicDetailEvent(newEvent1,newEvent1);
		evMg.saveAddEventDetails();
		
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1));
		
		/*Step number: 5
		*Step Name: Check shared user can delete event/ task
		*Step Description: 
			- Right click event/ task above, click Delete
		*Input Data: 
			
		*Expected Outcome: 
			Event/ task is deleted*/
        cMang.deleteTaskEvent(newEvent1);
        
		/*Step number: 6
		*Step Name: Check shared user can export event
		*Step Description: 
			- As shared user, create a new event
			- Right click on it then choose Export
			- Fill name
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Event is exported successfully*/
        String attachment=getRandomNumber()+".ics";
        cMang.exportTaskEvent(newEvent1, attachment);
        
        
		/*Step number: 7
		*Step Name: Check shared user can import event
		*Step Description: 
			- Delete event above
			- Click on wheel icon of Shared calendar, click Import
			- Choose exported event file above
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Event is deletedEvent is imported successfully and displayed on shared calendar*/ 
        cMang.deleteTaskEvent(newEvent1);
        info("Check the task is not present");
		cHome.verifyIsNotPresentEventTask(newEvent1, selectViewOption.LIST, selectDayOption.ONEDAY);
		
		cMang.importTaskEvent(calendar,"TestData/TestOutput/" + attachment);

		info("Check the task is present ");
		cHome.verifyIsPresentEventTask(newEvent1, selectViewOption.LIST, selectDayOption.ONEDAY);

		cMang.deleteTaskEvent(newEvent1);
 	}

	/**
	*<li> Case ID:116321.</li>
	*<li> Test Case Name: Check owner's right on shared calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_CheckOwnersRightOnSharedCalendar() {
		info("Test 7: Check owner's right on shared calendar");
		/*Step Number: 1
		*Step Name: Create & share a calendar
		*Step Description: 
			- Log in as john<br />
			- Click Add Calendar<br />
			- Fill name: SHARED_CALENDAR_07<br />
			- Save<br />
			- Click on wheel icon of above personal calendar<br />
			- Click Share<br />
			- Choose mary<br />
			- No Tick Edit permission<br />
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Calendar is shared, shared user has edit permission*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
  		boolean[] canEdit={true};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendar, userGroup,canEdit);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
        
		/*Step number: 2
		*Step Name: Check owner's right on shared calendar
		*Step Description: 
			Still log in as owner
		*Input Data: 
			
		*Expected Outcome: 
			Only owner of the shared calendar can : 
			+Edit the calendar 
			+Share with more users 
			+Change "edit permissions" with users that can access to the calendar*/
   		String calendar1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
   		cMang.editCalendar(calendar,calendar1 ,calendar1 ,null,null);
   		cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar1));
   		
		/*Step number: 3
		*Step Name: Check shared user's right on shared calendar
		*Step Description: 
			Log in as maryClick on wheel icon of SHARED_CALENDAR_07
		*Input Data: 
			
		*Expected Outcome: 
			- There is no option: Edit, Share to share and edit shared calendar*/ 
   		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar1);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar1, true);
 	}

	/**
	*<li> Case ID:116322.</li>
	*<li> Test Case Name: Check action menu of shared user having edit permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CheckActionMenuOfSharedUserHavingEditPermission() {
		info("Test 8: Check action menu of shared user having edit permission");
		/*Step Number: 1
		*Step Name: Create & share a calendar
		*Step Description: 
			- Log inas john
			- Click Add Calendar
			- Fill name: SHARED_CALENDAR_09
			- Save
			- Click on wheel icon of above personal calendar
			- Click Share
			- Choose mary
			- Tick Edit permission
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Calendar is shared, shared user has edit permission*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
  		boolean[] canEdit={true};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendar, userGroup,canEdit);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: Check action menu of shared user having edit permission
		*Step Description: 
			- Log in as mary
		*Input Data: 
			
		*Expected Outcome: 
			Clickin on the action menu display: 
			- Add event 
			- Add task 
			- Import 
			- Export 
			- Refresh 
			- ReMove*/ 
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
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
		
 	}

	/**
	*<li> Case ID:116323.</li>
	*<li> Test Case Name: Check action menu of shared user having read only permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_CheckActionMenuOfSharedUserHavingReadOnlyPermission() {
		info("Test 9: Check action menu of shared user having read only permission");
		/*Step Number: 1
		*Step Name: Create & share a calendar
		*Step Description: 
			- Log in as john
			- Click Add Calendar
			- Fill name: SHARED_CALENDAR_10
			- Save
			- Click on wheel icon of above personal calendar
			- Click Share
			- Choose mary
			- Not tick Edit permission
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Calendar is shared, shared user has read only permission*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
  		boolean[] canEdit={false};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendar, userGroup,canEdit);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: Check action menu of shared user having read only permission
		*Step Description: 
			- Log in as mary
			- Click on the action menu
		*Input Data: 
			
		*Expected Outcome: 
			Action menu is displayed:
			- Remove 
			- Refresh*/ 
   		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REFRESH_MENU,2000,2);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REMOVE_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116325.</li>
	*<li> Test Case Name: Remove a shared calendar by the shared user without edit right.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_RemoveASharedCalendarByTheSharedUserWithoutEditRight() {
		info("Test 10 Remove a shared calendar by the shared user without edit right");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create & share calendar
		*Input Data: 
			- Create a personal calendar [ Details ]
			- Right click on the added calendar and Share for some users without edit permission[ Details ]
		*Expected Outcome: 
			- In the owner view, the shared calendar is displayed with shared hand icon
			- In the shared user view, the shared calendar is displayed Shared Calendarlist with the set permission*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
  		boolean[] canEdit={false};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendar, userGroup,canEdit);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Remove shared calendar by shared user
		*Input Data: 
			- Login by shared user without edit right
			- Right click on shared calendar and select Remove
		*Expected Outcome: 
			- This calendar and its events/tasks disappear from shared calendar list of the shared user who deleted it.
			- In the owner view, the shared calendar is displayed with normal status.*/ 
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
	*<li> Case ID:116326.</li>
	*<li> Test Case Name: Remove a shared calendar by the shared user with edit right.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_RemoveASharedCalendarByTheSharedUserWithEditRight() {
		info("Test 11 Remove a shared calendar by the shared user with edit right");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create & share calendar
		*Input Data: 
			- Create a personal calendar [ Details ]
			- Right click on the added calendar and Share for some users with edit permission[ Details ]
		*Expected Outcome: 
			- In the owner view, the shared calendar is displayed with shared hand icon
			- In the shared user view, the shared calendar is displayed Shared Calendarlist with the set permission*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
  		boolean[] canEdit={true};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendar, userGroup,canEdit);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Remove shared calendar by shared user
		*Input Data: 
			- Login by shared user with edit right.
			- Right click on shared calendar and select Remove
		*Expected Outcome: 
			- This calendar and its events/tasks displayed from shared calendar list of the shared user who deleted it.
			- In the owner view, shared calendar is displayed with normal status.*/ 
   		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_REMOVE_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116453.</li>
	*<li> Test Case Name: Edit a shared calendar by shared user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_EditASharedCalendarBySharedUser() {
		info("Test 12 Edit a shared calendar by shared user");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Share personal calendar
		*Input Data: 
			- Click Calendar actions icon and select Add calendar 
			- Right click on added calendar and select Share
			- Choose existed user and share
		*Expected Outcome: 
			- Calendar is added and displayed in Personal calendars list of owner; 
			  it is also displayed in shared list of shared user
			- Shared permission is added into shared list with "Can edit" is No or Yes
			- Icon for this calendar is turned to be shared when view by owner*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
  		boolean[] canEdit={false};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendar, userGroup,canEdit,0);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Edit shared calendar
		*Input Data: 
			- Login by shared user
			- Right click on Action icon on shared calendar
			- ClickEdit option
		*Expected Outcome: 
			- There is no Edit option for Shared user
			- The shared user cannot change the color of the shared calendar.*/ 
   		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_EDIT_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116459.</li>
	*<li> Test Case Name: Share a Personal Calendar for Group(s)/Person without Editing permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_ShareAPersonalCalendarForGroupPersonWithoutEditingPermission() {
		info("Test 13 Share a Personal Calendar for Group(s)/Person without Editing permission");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add View permission for Group(s)/Person
		*Input Data: 
			- Login as Root successfully
			- Go to Calendar
			- Right click on Personal Calendar
			- Click on Share
			- Click & choose acc/group without ticking in checkbox of Editing permission
		*Expected Outcome: 
			- Permission is added successfully without any error message on screen*/ 
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupCalendar = "/platform/web-contributors";
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(groupCalendar,true);
        cMang.saveAddCalendar();
        
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116460.</li>
	*<li> Test Case Name: Share a Personal Calendar for Group/Person with Editing permission.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_ShareAPersonalCalendarForGroupPersonWithEditingPermission() {
		info("Test 14 Share a Personal Calendar for Group/Person with Editing permission");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Edit permission for Group(s)/Person
		*Input Data: 
			- Login as Root successfully
			- Go to Calendar
			- Right click on Personal Calendar
			- Click on Share
			- Click & choose acc/group and ticking in checkbox of Editing permission
		*Expected Outcome: 
			- Permission is added successfully without any error message on screen*/ 
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupCalendar = "/platform/web-contributors";
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(groupCalendar,true);
        cMang.saveAddCalendar();
        
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116480.</li>
	*<li> Test Case Name: Share an imported calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_ShareAnImportedCalendar() {
		info("Test 15 Share an imported calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Import calendar
		*Input Data: 
			- Click Calendar actions icon and select Import 
			- Import a calendar[ Details ]
		*Expected Outcome: 
			The imported calendar is displayed in the selected calendar group's in the left pane*/

		String attachment=getRandomNumber()+".ics";
		String calendarName= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Create data test");
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		cMang.inputDataInDetailTabCalendarForm(calendarName, calendarName,null);
		cMang.saveAddCalendar();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", calendarName));
		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendarName);
		evMg.saveQuickAddEvent();
		
		info("Export calendar");
		cMang.exportCalendar(calendarName,attachment);
		cMang.deleteCalendar(calendarName,true);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", calendarName));

		info("Import calendar");
		cMang.importCalendar("TestData/TestOutput/" + attachment,calendarName,null,null);

		info("Check inported calendar ");
		driver.navigate().refresh();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", calendarName));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Share calendar
		*Input Data: 
			- Right click on added calendar and select Share
			- Select user to share and set permission
			- Click Save
		*Expected Outcome: 
			- Share calendar form is displayed.
			- Shared users are updated in sharedlist.
			- In the shared user view, the shared calendar is displayed Shared Calendarlist with the set permission*/ 
		String[] userGroup={DATA_USER2};
  		boolean[] canEdit={true};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendarName, userGroup,canEdit,0);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendarName));
   		cMang.deleteCalendar(calendarName, true);
 	}

	/**
	*<li> Case ID:116481.</li>
	*<li> Test Case Name: Share a shared calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_ShareASharedCalendar() {
		info("Test 16 Share a shared calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Createand share calendar
		*Input Data: 
			- Click Calendar actions icon and select Add calendar 
			- Add new calendar and share it to some users [ Details ]
		*Expected Outcome: 
			The shared calendar is displayed Shared Calendarlist with the set permission*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String[] userGroup={DATA_USER2};
  		boolean[] canEdit={true};
        hp.goToCalendarPage();
  		cMang.shareCalendar(calendar, userGroup,canEdit,0);
  		
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Share a shared calendar
		*Input Data: 
			- Login by the shared user 
			- Right click on the shared user and try to share it.
		*Expected Outcome: 
			- The shared user can not share the shared calendar.
			- The Share option is not available in right click menu.*/ 
   		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.openMenuOfCalendar(calendar);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_MENU,2000,2);
		
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);

 	}

	/**
	*<li> Case ID:116482.</li>
	*<li> Test Case Name: Share a group calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_ShareAGroupCalendar() {
		info("Test 17 Share a group calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar
		*Input Data: 
			- Create a group calendar [ Details ]
		*Expected Outcome: 
			The added calendar is displayed in the selected calendar group on the left pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupCalendar = "/platform/web-contributors";
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(groupCalendar,true);
        cMang.saveAddCalendar();
        
  		hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Share calendar
		*Input Data: 
			- Right click on added calendar and select Share
		*Expected Outcome: 
			- The Share option is not available in right click menu.
			- The group calendar can not be shared.*/ 
   		cMang.openMenuOfCalendar(calendar);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_MENU,2000,2);
   		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116483.</li>
	*<li> Test Case Name: Share calendar with invalid user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_ShareCalendarWithInvalidUser() {
		info("Test 18 Share calendar with invalid user");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar
		*Input Data: 
			- Click Calendar actions icon and select Add calendar 
			- Input valid value and click Save
		*Expected Outcome: 
			The added calendar is displayed in the selected calendar group on the left pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Share calendar with invalid user
		*Input Data: 
			- Right click on the added calendar at step 1 and select Share
			- Input invalid User
			- Click Save
		*Expected Outcome: 
			- Share calendar form is displayed.
			- Show message to inform about the invalid user name for sharing calendar.*/ 
        String[] userGroup={"abc"};
        hp.goToCalendarPage();
    	cMang.executeActionCalendar(calendar, menuOfCalendarOption.SHARE);
    	info("type invalid user");
		type(cMang.ELEMENT_CALENDAR_SHARE_INPUT,userGroup[0],true);
		click(cMang.ELEMENT_CALENDAR_SHARE_ADD_BUTTON);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_WARINING_POPUP);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
  		
 	}

	/**
	*<li> Case ID:116484.</li>
	*<li> Test Case Name: Share calendar without specifying any user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_ShareCalendarWithoutSpecifyingAnyUser() {
		info("Test 19 Share calendar without specifying any user");
		/*Step Number: 1
		*Step Name: Step 1: Add calendar
		*Step Description: 
			- Click Calendar actions icon and select Add calendar
			- Input valid value and click Save
		*Input Data: 
			
		*Expected Outcome: 
			The added calendar is displayed in the selected calendar group on the left pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: Step 2: Share calendar
		*Step Description: 
			- Click on the added calendar at step 1 and select Share
			- Leave User name field blank
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Do not show message to inform about the invalid user name
			- The share calendar form is closed and the calendar is not shared with anyone*/ 
         hp.goToCalendarPage();
 	     cMang.executeActionCalendar(calendar, menuOfCalendarOption.SHARE);
 	     click(cMang.ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
		 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
		 hp.goToCalendarPage();
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		 cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116485.</li>
	*<li> Test Case Name: Change Edit permission on a shared calendar from Yes to No.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test20_ChangeEditPermissionOnASharedCalendarFromYesToNo() {
		info("Test 20 Change Edit permission on a shared calendar from Yes to No");
		/*Step Number: 1
		*Step Name: Step 1: Create calendar
		*Step Description: 
			- Click Calendar actions icon and select Add calendar 
			- Input valid value and click Save
		*Input Data: 
			
		*Expected Outcome: 
			Added calendar is displayed in each selected group's calendar list in left pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: Step 2: Share calendar with edit right
		*Step Description: 
			- Right click on added calendar and select Share
			- Input/selectvalid User name
			- Check â€œEdit permissionâ€ check box
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Share calendar form is displayed.
			- This permission is added and displayed in permission list above with â€œCan editâ€ is â€œYesâ€
			- The shared user can add new event/task, export, change color of the shared calendar...*/
      	 String[] userGroup={DATA_USER2};
		 boolean[] canEdit={true};
         hp.goToCalendarPage();
		 cMang.shareCalendar(calendar, userGroup,canEdit,0);
		
		 hp.goToCalendarPage();
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		
		/*Step number: 3
		*Step Name: Step 3: Open Edit Share calendar form.
		*Step Description: 
			- Login by the owner of the shared calendar and right click on the calendaradded at step 2and select Share
			- Click Edit icon of the shared user which has edit permission
		*Input Data: 
			
		*Expected Outcome: 
			- Share calendar form is displayed with the shared user with edit permission.
			- The information of this permission is displayed in form below
			- Edit permission check box is checked*/
		
		/*Step number: 4
		*Step Name: Step 4: Change permission
		*Step Description: 
			- Uncheck Edit permission check box
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Change is saved.
			- The shared user has view permission only, 
			cannot add new event/task, export, change color of shared calendar*/ 
		 String[] userGroupEdit={""};
		 boolean[] canEditEdit={false};
		 cMang.shareCalendar(calendar,userGroupEdit,canEditEdit,0);
		 magAc.signOut();
		 magAc.signIn(DATA_USER2, DATA_PASS);
		 hp.goToCalendarPage();
		 cMang.openMenuOfCalendar(calendar);
		 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_MENU,2000,2);
		 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_ADD_EVENT_MENU,2000,2);
		 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_ADD_TASK_MENU,2000,2);
		 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_EXPORT_MENU,2000,2);
		 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_IMPORT_MENU,2000,2);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_REMOVE_FORM,2000,2);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_REFRESH_MENU,2000,2);
		 
		 magAc.signOut();
		 magAc.signIn(DATA_USER1, DATA_PASS);
		 hp.goToCalendarPage();
		 cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116486.</li>
	*<li> Test Case Name: Change Edit permission on a shared calendar from No to Yes.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test21_ChangeEditPermissionOnASharedCalendarFromNoToYes() {
		info("Test 21 Change Edit permission on a shared calendar from No to Yes");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar
		*Input Data: 
			- Click Calendar actions icon and select Add calendar 
			- Input valid value and click Save
		*Expected Outcome: 
			Added calendar is displayed in each selected group's calendar list in left pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Share calendar with edit right
		*Input Data: 
			- Right click on added calendar and select Share
			- Input/selectvalid User name
			- Uncheck Edit permission check box
			- Click Save
		*Expected Outcome: 
			- Share calendar form is displayed.
			- This permission is added and displayed in permission list above with Edit permission is No*/
		 String[] userGroup={DATA_USER2};
		 boolean[] canEdit={false};
		 hp.goToCalendarPage();
		 cMang.shareCalendar(calendar, userGroup,canEdit,0);
		
		 hp.goToCalendarPage();
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		 
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Open Edit Share calendar form.
		*Input Data: 
			- Login by the owner of the shared calendar and right click on the calendaradded at step 2and select Share
			- Click Edit icon of the shared user which has no edit permission
		*Expected Outcome: 
			- Share calendar form is displayed with the shared user without edit permission.
			- The information of this permission is displayed in form below
			- Edit permission check box is unchecked*/

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Change permission
		*Input Data: 
			- Check Edit permission check box
			- Click Save
		*Expected Outcome: 
			- Change is saved, Edit permission is changed into Yes
			- The shared userhas edit permission, can add new event/task, export...*/ 
		 String[] userGroupEdit={""};
		 boolean[] canEditEdit={true};
		 cMang.shareCalendar(calendar,userGroupEdit,canEditEdit,0);
		 magAc.signOut();
		 magAc.signIn(DATA_USER2, DATA_PASS);
		 hp.goToCalendarPage();
		 cMang.openMenuOfCalendar(calendar);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_EVENT_MENU,2000,2);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_TASK_MENU,2000,2);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_EXPORT_MENU,2000,2);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_IMPORT_MENU,2000,2);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_REMOVE_FORM,2000,2);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_REFRESH_MENU,2000,2);
		 
		 magAc.signOut();
		 magAc.signIn(DATA_USER1, DATA_PASS);
		 hp.goToCalendarPage();
		 cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116487.</li>
	*<li> Test Case Name: Remove shared permission on a shared calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test22_RemoveSharedPermissionOnASharedCalendar() {
		info("Test 22 Remove shared permission on a shared calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create and Share calendar
		*Input Data: 
			- Create new personal calendar [ Details ]
			- Share added calendar for some users[ Details ]
		*Expected Outcome: 
			- Added permission is listed
			- The shared user can see this calendar in shared calendars list*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		String[] userGroup={DATA_USER2};
		boolean[] canEdit={false};
		hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit,0);
		
		hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Show edit share permission form
		*Input Data: 
			- Login by the owner ofthe shared calendar.
			- In share calendar form: click Delete icon of permission of one user in list
			- Click OK to confirm
		*Expected Outcome: 
			- This user is removed from permission list of this calendar
			- This calendar is no more displayed in shared calendars list when view by this user*/ 
		  cMang.removeUserGrooupFromShareCalendar(calendar, userGroup);
		  magAc.signOut();
		  magAc.signIn(DATA_USER2, DATA_PASS);
		  hp.goToCalendarPage();
		  waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		  
		  magAc.signOut();
		  magAc.signIn(DATA_USER1, DATA_PASS);
		  hp.goToCalendarPage();
		  cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116488.</li>
	*<li> Test Case Name: Remove shared status for a shared calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test23_RemoveSharedStatusForASharedCalendar() {
		info("Test 23 Remove shared status for a shared calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Share calendar
		*Input Data: 
			- Create new personal calendar 
			- Share added calendar for some users
		*Expected Outcome: 
			- This calendar is created & shared*/

		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		String[] userGroup={DATA_USER2};
		boolean[] canEdit={false};
		hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit,0);
		
		hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			Step 2: Log in shared user
		*Input Data: 
			- Log in as shared user
			- View his shared calendar list
		*Expected Outcome: 
			- The shared user can see this calendar in shared calendars list*/
		  magAc.signOut();
		  magAc.signIn(DATA_USER2, DATA_PASS);
		  hp.goToCalendarPage();
		  waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		  
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Remove shared status
		*Input Data: 
			- Login by the owner ofthe shared calendar.
			- Delete all permissions in list
		*Expected Outcome: 
			- This calendar is removed from shared list of all shared users*/
		  magAc.signOut();
		  magAc.signIn(DATA_USER1, DATA_PASS);
		  hp.goToCalendarPage();
		  cMang.removeUserGrooupFromShareCalendar(calendar, userGroup);
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			Step 4: Log in shared user again
		*Input Data: 
			- Log in as shared user again
			- View his shared calendar list
		*Expected Outcome: 
			Above calendar no longer exists in his shared calendar list.*/ 
		  magAc.signOut();
		  magAc.signIn(DATA_USER2, DATA_PASS);
		  hp.goToCalendarPage();
		  waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		  
		  magAc.signOut();
		  magAc.signIn(DATA_USER1, DATA_PASS);
		  hp.goToCalendarPage();
		  cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116489.</li>
	*<li> Test Case Name: Check a shared calendar in case delete account of its shared users..</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test24_CheckASharedCalendarInCaseDeleteAccountOfItsSharedUsers() {
		info("Test 24 Check a shared calendar in case delete account of its shared users.");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create & share calendar
		*Input Data: 
			- Create a personal calendar, add some events/tasks[ Details ]
			- Share the added calendar.[ Details ]
		*Expected Outcome: 
			- Permission for this user is added in shared list
			- In the owner view, the shared calendar is displayed with shared hand icon
			- In the shared user view, the shared calendar is displayed Shared Calendarlist with the set permission*/
		createNewUser();
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		String[] userGroup={username};
		boolean[] canEdit={true};
		hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit,0);
		
		hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Delete shared user account
		*Input Data: 
			- Use the portal administrator account to delete the shared user
			- Back to calendar application by owner of shared calendar at step 1
		*Expected Outcome: 
			- The deleted user inthe share list of the shared calendaris removed.*/ 
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.deleteUser(username);
		hp.goToCalendarPage();
		cMang.executeActionCalendar(calendar, menuOfCalendarOption.SHARE);
		waitForElementNotPresent(cMang.ELEMENT_DELETE_SHARE_USER.replace("{$user}",username));
 	    click(cMang.ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116479.</li>
	*<li> Test Case Name: Share a personal calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test25_ShareAPersonalCalendar() {
		info("Test 25 Share a personal calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar
		*Input Data: 
			- Click Calendar actions icon and select Add calendar 
			- Input valid value and click Save
		*Expected Outcome: 
			The added calendar is displayed in the selected calendar group on the left pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Share calendar
		*Input Data: 
			- Right click on the added calendar and select Share
			- Select/input validuser to share and set permission
			- Click Save
		*Expected Outcome: 
			- Share calendar form is displayed.
			- Shared users are updated in sharedlist.
			- In the shared user view, the shared calendar is displayed Shared list with the set permission*/ 
   		String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
		hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit,0);
		
		hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		
	    magAc.signOut();
	    magAc.signIn(DATA_USER2, DATA_PASS);
	    hp.goToCalendarPage();
	    waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
	  
	    magAc.signOut();
	    magAc.signIn(DATA_USER1, DATA_PASS);
	    hp.goToCalendarPage();
	    cMang.deleteCalendar(calendar, true);
 	}}