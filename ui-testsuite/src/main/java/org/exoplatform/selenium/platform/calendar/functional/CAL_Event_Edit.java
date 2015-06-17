package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage;
import org.exoplatform.selenium.platform.calendar.CalendarManagement;
import org.exoplatform.selenium.platform.calendar.EventManagement;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Event_Edit extends CAL_TestConfig_2{

		String password;
		public void createUser() {
			int index = userInfoData.getRandomIndexByType(3);
			username = userInfoData.newUserName.get(index) + getRandomNumber();
			firstname = userInfoData.newFirstName.get(index);
			String lastname = userInfoData.newLastName.get(index);
			password = userInfoData.newPassword.get(index);
			String email = EMAIL_ADDRESS1;

			navTool.goToAddUser();
			addUserPage.addUser(username, password, email, firstname, lastname);
		}
	/**
	*<li> Case ID:116392.</li>
	*<li> Test Case Name: Edit event which is import from webmail.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_EditEventWhichIsImportFromWebmail() {
		info("Test 1: Edit event which is import from webmail");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Send invitation of one User (Root) to other user (Demo)
		*Input Data: 
			- From Root: Create a event with an invitation to Demo [ Details ]
		*Expected Outcome: 
			The event is created and invitation mail is sent to address mail of Demo*/

		createUser();
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(titleEvent,content,calendar);
		evMg.goToParticipantsTab();
		evMg.goToInvitationParticipantForm();
		evMg.selectUserParticipants(username, content,0);
		evMg.saveInvitationParticipantForm();
		evMg.selectSendInvitation(selectInvitationOption.ALWAYS);
		evMg.saveAddEventDetails();
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add event from web mail to portlet calendar
		*Input Data: 
			- Go to webmail porlet of Demo to Add above event to calendar of demo
		*Expected Outcome: 
			- The event is added into calendar of Demo*/
		 goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		 Utils.pause(20000);
		 cMang.checkEmailNotificationCalendar(titleEvent,"icalendar.ics","Yes",DATA_USER1,true,true);
		 switchToParentWindow();

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Edit event
		*Input Data: 
			Perform to edit above event from demo
		*Expected Outcome: 
			The event is edited successfully*/ 
		hp.goToCalendarPage();
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputBasicDetailEvent(titleEvent1,titleEvent1);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1));
 		
 		 info("Delete Event");
 		 hp.goToCalendarPage();
 		 cMang.deleteCalendar(calendar);
		 navTool.goToUsersAndGroupsManagement();
		 userAndGroup.deleteUser(username);
 	}

	/**
	*<li> Case ID:116424.</li>
	*<li> Test Case Name: Edit event of shared calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_EditEventOfSharedCalendar() {
		info("Test 2: Edit event of shared calendar");
		/*Step Number: 1
		*Step Name: - Step 1: Add and share event
		*Step Description: 
			- Add new event[ Details ]<br />
			- Share calendar contains added event for an user without edit right<br />
			- Share calendar above for another user with edit right<br />[ Details ]
		*Input Data: 
			
		*Expected Outcome: 
			- event is added*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendar);
		evMg.saveQuickAddEvent();
		
		String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		String[] userGroup1={DATA_USER4};
		boolean[] canEdit1={false};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup1,canEdit1);

		/*Step number: 2
		*Step Name: - Step 2: Edit event by shared user without edit right
		*Step Description: 
			- Login by shared user who does not have edit right
			- Right click on event of shared calendar
		*Input Data: 
			
		*Expected Outcome: 
			"edit" action is not allowed. Only "view" action is allowed*/
		
		magAc.signOut();
		magAc.signIn(DATA_USER4, DATA_PASS);
		hp.goToCalendarPage();
		rightClickOnElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_CONTEXT_MENU_VIEW,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CONTEXT_MENU_DELETE,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CONTEXT_MENU_EDIT,2000,2);

		/*Step number: 3
		*Step Name: - Step 3: Edit event by shared user with edit right
		*Step Description: 
			- Login by shared user who has edit right
			- Right click on event of shared calendar and select Edit or drag and drop event in working pane
		*Input Data: 
			
		*Expected Outcome: 
			- Edit event form appears with current information of event in form (if select Edit) or event is changed date/time as drag and drop
			- Edit event successfully by shared user with edit right*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		info("Edit the Event");
		hp.goToCalendarPage();
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputBasicDetailEvent(titleEvent1,null);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1));
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116425.</li>
	*<li> Test Case Name: Edit event of group calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_EditEventOfGroupCalendar() {
		info("Test 3: Edit event of group calendar");
		/*Step Number: 1
		*Step Name: Step 1: Add event
		*Step Description: 
			- Add new group calendar
			- Assign calendar for an user with edit right
			- Add new event on this group calendar
		*Input Data: 
			
		*Expected Outcome: 
			- Event is added successfully
			- Group calendar and its event(s) are displayed for all member of its group(s)*/

		info("Create a new calendar");
		String userGroup="/platform/web-contributors";
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
        
        info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendar);
		evMg.saveQuickAddEvent();

		/*Step number: 2
		*Step Name: Step 2: Edit event by member of group without edit right
		*Step Description: 
			- Login by a member of group calendar who does not have edit right on that calendar
			- Right click on group calendar's event
		*Input Data: 
			
		*Expected Outcome: 
			Only "View" action is displayed.*/
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		rightClickOnElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_CONTEXT_MENU_VIEW,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CONTEXT_MENU_DELETE,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CONTEXT_MENU_EDIT,2000,2);
		
		/*Step number: 3
		*Step Name: Step 3: Edit event by member of group with edit right
		*Step Description: 
			- Login by member who is assign edit right on above group calendar
			- Right click on event of shared calendar and select Edit or drag and drop event in working pane
		*Input Data: 
			
		*Expected Outcome: 
			- Edit event form appears with current information of event in form (if select Edit) or event is changed date/time as drag and drop
			- Edit event successfully by shared user with edit right*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		info("Edit the Event");
		hp.goToCalendarPage();
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputBasicDetailEvent(titleEvent1,null);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1));
		
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116426.</li>
	*<li> Test Case Name: Edit Event in Search form.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*THIS CASE HAS A BUG: https://jira.exoplatform.org/browse/CAL-1139
	*/
	@Test
	public  void test04_EditEventInSearchForm() {
		info("Test 4: Edit Event in Search form");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar(s), event(s)
		*Input Data: 
			- Create new calendar(s), event(s) [ Details ]
		*Expected Outcome: 
			Calendar, event(s) are created successfully*/

		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendar);
		evMg.saveQuickAddEvent();
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Search specific event(s)
		*Input Data: 
			- Do search to find event [ Details ]
		*Expected Outcome: 
			Return result in Search form*/

		cMang.searchQuickEventTask(titleEvent);
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Open Edit form
		*Input Data: 
			- Right click on specific event or click on editevent link in event detail of the event or double click on event
		*Expected Outcome: 
			Add/Edit event form is shown properly*/
		
		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Edit event
		*Input Data: 
			- Change information for the event
			- Click Save
		*Expected Outcome: 
			- The add/edit event form is closed
			- The event is updated
			- The Search form is still kept*/ 
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		waitForElementNotPresent(evMg.ELEMENT_BUTTON_EVENT_SAVE_DETAILS);
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		button.ok();
		
		cMang.deleteTaskEvent(titleEvent2);
		cMang.closeSearch();
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116427.</li>
	*<li> Test Case Name: Change date of event in Day view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_ChangeDateOfEventInDayView() {
		info("Test 5: Change date of event in Day view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create event
		*Input Data: 
			- Add category[ Details ]
			- Add new calendar (personal, imported, shared, group calendar) and events that happens in one day
			- Select Day View to display calendar
		*Expected Outcome: 
			All events of selected day are displayed in working pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendar);
		evMg.saveQuickAddEvent();
		
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View events of a specific day
		*Input Data: 
			- Select Day View to display calendar
			- Select the day contains added event
		*Expected Outcome: 
			Event is displayed in working pane*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Change event date
		*Input Data: 
			- Right click on an event (user has edit right) and select Edit
			- Change From and To date of event to another day and
			- ClickSave
		*Expected Outcome: 
			- Edited event disappears from current day
			- This event appears again in working pane after click Next/Previous day 'till the new selected date of event*/
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cHome.goToView(selectViewOption.LIST);
		cMang.openEditEventTaskPopup(titleEvent);
		int currentDay = Integer.parseInt(getCurrentDate("dd")); 
		int firstDay= Integer.parseInt( getFirstDayOfWeek("dd"));
		int lastDay= Integer.parseInt( getLastDayOfWeek("dd"));
		if(currentDay==firstDay)
		    evMg.inputDataEventInDetailForm(titleEvent2,null,getLastDayOfWeek("MM/dd/yyyy"),getLastDayOfWeek("MM/dd/yyyy"),false);
		if(currentDay==lastDay)
			evMg.inputDataEventInDetailForm(titleEvent2,null,getFirstDayOfWeek("MM/dd/yyyy"),getFirstDayOfWeek("MM/dd/yyyy"),false);
		else
			evMg.inputDataEventInDetailForm(titleEvent2,null,getDate(1,"MM/dd/yyyy"),getDate(1,"MM/dd/yyyy"),false);
		
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.DAY);
		waitForElementNotPresent(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		cHome.goToView(selectViewOption.LIST);
		cHome.nextDate(1);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116428.</li>
	*<li> Test Case Name: Change time of event in one day by drag and drop in Day view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_ChangeTimeOfEventInOneDayByDragAndDropInDayView() {
		info("Test 6: Change time of event in one day by drag and drop in Day view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create event
		*Input Data: 
			- Add category[ Details ]
			- Add new calendar (personal, imported, shared, group calendar)
			- Add event that happens in one day (not all day)
			- Select Day View to display calendar
		*Expected Outcome: 
			Added event is displayed as part of day in working pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendar);
		evMg.saveQuickAddEvent();
		
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change duration of event by drag and drop
		*Input Data: 
			Drag and drop the event to new place in working pane of day
		*Expected Outcome: 
			From and To time of event are changed as drag and drop*/
		int targetTime=Integer.parseInt(getCurrentDate("hh"))+1;
		String newTargetTime=String.valueOf(targetTime)+":00";
		dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
		cHome.ELEMENT_EVENT_TASK_DAY_ONE_DAY.replace("$date",newTargetTime));
		
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DAY_TIME.replace("$name",titleEvent).replace("$time",newTargetTime));
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116429.</li>
	*<li> Test Case Name: Change end time of event by drag and drop in Day View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_ChangeEndTimeOfEventByDragAndDropInDayView() {
		info("Test 7: Change end time of event by drag and drop in Day View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View events/tasks of a calendar in Day View
		*Input Data: 
			- Choose to view in Day View type
			- Add event that happens in current day
		*Expected Outcome: 
			Added event is displayed in working pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, getCurrentDate("MM/dd/yyyy HH")+":00",null,false,calendar);
		evMg.saveQuickAddEvent();
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Extent end time
		*Input Data: 
			Drag end time of event up/down in working pane to new time in day
		*Expected Outcome: 
			Event's end time is updated successfully*/
		info("Drag end time of event up/down in working pane to new time in day");
		int targetTime=Integer.parseInt(getCurrentDate("HH"))+2;
		String newTargetTime=String.valueOf(targetTime)+":00";
		info("currentTime:"+getCurrentDate("HH"));
		info("newTargertTime:"+newTargetTime);
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent))));
		mouseOver(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),true);
		
        dragObject(cHome.ELEMENT_EVENT_TASK_RESIZE_CONTAINER.replace("$name",titleEvent),cHome.ELEMENT_EVENT_TASK_DAY_ONE_DAY.replace("$date",newTargetTime));
		
        String dateTime=getCurrentDate("HH")+":00"+" - "+String.valueOf(targetTime)+":30";
		info("dateTime:"+dateTime);
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DAY_TIME.replace("$name",titleEvent).replace("$time",dateTime));

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 
		info("Check displaying in WorkWeek views after editing");
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in List views after editing");
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Week views after editing");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Month views after editing");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116430.</li>
	*<li> Test Case Name: Change time of all day event in Day view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_ChangeTimeOfAllDayEventInDayView() {
		info("Test 8: Change time of all day event in Day view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add all day event
		*Input Data: 
			- Choose to view in Day View type
			- Add event that happens in all selected day
		*Expected Outcome: 
			Added event is displayed as all day event at the top of working pane*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,true,calendar);
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY.replace("$name",titleEvent));
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change time of event
		*Input Data: 
			In edit event form: keep the date of event, change From and To time
		*Expected Outcome: 
			Event is updated and moved to corresponding time in day in working pane*/

		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		int targetTime=Integer.parseInt(getCurrentDate("HH"))+2;
		String newTargetTime=String.valueOf(targetTime)+":00";
		cHome.goToView(selectViewOption.LIST);
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputDataEventInDetailForm(titleEvent2,null,getCurrentDate("MM/dd/yyyy HH")+":00",getCurrentDate("MM/dd/yyyy ")+newTargetTime,false);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.DAY);
		String dateTime=getCurrentDate("HH")+":00"+" - "+newTargetTime;
		info("dateTime:"+dateTime);
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DAY_TIME.replace("$name",titleEvent2).replace("$time",dateTime));
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 
		info("Check displaying in WorkWeek views after editing");
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
		info("Check displaying in List views after editing");
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
		info("Check displaying in Week views after editing");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
		info("Check displaying in Month views after editing");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116431.</li>
	*<li> Test Case Name: Change date of one day event in Week view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_ChangeDateOfOneDayEventInWeekView() {
		info("Test 9: Change date of one day event in Week view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Select to view calendar in Week view
			- Add new event that happens inside one day on selecting week
		*Expected Outcome: 
			Added event is displayed as a part of one day in current week*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Edit event
		*Input Data: 
			In edit event form: select another date for both From and To date
		*Expected Outcome: 
			The edited event is updated and moved to new selected date*/
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent);
		int currentDay = Integer.parseInt(getCurrentDate("dd")); 
		int firstDay= Integer.parseInt( getFirstDayOfWeek("dd"));
		int lastDay= Integer.parseInt( getLastDayOfWeek("dd"));
		if(currentDay==firstDay)
		    evMg.inputDataEventInDetailForm(titleEvent2,null,getLastDayOfWeek("MM/dd/yyyy"),getLastDayOfWeek("MM/dd/yyyy"),false);
		if(currentDay==lastDay)
			evMg.inputDataEventInDetailForm(titleEvent2,null,getFirstDayOfWeek("MM/dd/yyyy"),getFirstDayOfWeek("MM/dd/yyyy"),false);
		else
			evMg.inputDataEventInDetailForm(titleEvent2,null,getDate(1,"MM/dd/yyyy"),getDate(1,"MM/dd/yyyy"),false);
		
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.WEEK);
		if(currentDay==firstDay)
			waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$date",getLastDayOfWeek("MMM dd yyyy")));
		if(currentDay==lastDay)
			waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$date",getFirstDayOfWeek("MMM dd yyyy")));
		else
			waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$date",getDate(1,"MMM dd yyyy")));
		
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 
		info("Check displaying in WorkWeek views after editing");
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in List views after editing");
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Week views after editing");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Month views after editing");
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116432.</li>
	*<li> Test Case Name: Change happen time of event in one day by drag and drop.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_ChangeHappenTimeOfEventInOneDayByDragAndDrop() {
		info("Test 10 Change happen time of event in one day by drag and drop");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Select to view calendar in Week view
			- Add new event that happens inside one day on selecting week
		*Expected Outcome: 
			Added event is displayed as a part of one day in current week*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change time of event
		*Input Data: 
			Drag the event and drop it in new place on the same day or another day in working pane
		*Expected Outcome: 
			The edited event is updated and moved to new selected time*/
		int currentDay = Integer.parseInt(getCurrentDate("dd")); 
		int firstDay= Integer.parseInt( getFirstDayOfWeek("dd"));
		int lastDay= Integer.parseInt( getLastDayOfWeek("dd"));
		if(currentDay==firstDay){
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ONE_DAY.replace("$date",getLastDayOfWeek("MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$date",getLastDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent));
		}else 
		if(currentDay==lastDay){
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ONE_DAY.replace("$date",getFirstDayOfWeek("MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$date",getFirstDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent));
		}
		else {
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ONE_DAY.replace("$date",getDate(1,"MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$date",getDate(1,"MMM dd yyyy")).replace("$name",titleEvent));
		}
			
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 
		
		info("Check displaying in WorkWeek views after editing");
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in List views after editing");
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Week views after editing");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Month views after editing");
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116433.</li>
	*<li> Test Case Name: Change end time of event by drag and drop in Week View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_ChangeEndTimeOfEventByDragAndDropInWeekView() {
		info("Test 11 Change end time of event by drag and drop in Week View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View events/tasks of a calendar in Week View
		*Input Data: 
			- Choose to view in Week View type
			- Add event that happens in one day
		*Expected Outcome: 
			Added event is displayed in Week View as a part of one day in current week*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getCurrentDate("MM/dd/yyyy HH")+":00",null,false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change end time
		*Input Data: 
			Drag end time of event in working pane to new time in day
		*Expected Outcome: 
			Event's end time is updated successfully*/ 
		info("Drag end time of event up/down in working pane to new time in day");
		int targetTime=Integer.parseInt(getCurrentDate("HH"))+2;
		String newTargetTime=String.valueOf(targetTime)+":00";
		info("currentTime:"+getCurrentDate("HH"));
		info("newTargertTime:"+newTargetTime);
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent))));
		mouseOver(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),true);
		
        dragObject(cHome.ELEMENT_EVENT_TASK_RESIZE_CONTAINER.replace("$name",titleEvent),cHome.ELEMENT_EVENT_TASK_DAY_ONE_DAY.replace("$date",newTargetTime));
		
        String dateTime=getCurrentDate("HH")+":00"+" - "+String.valueOf(targetTime)+":30";
		info("dateTime:"+dateTime);
		waitForAndGetElement(cHome. ELEMENT_EVENT_TASK_DETAIL_TIME_WEEK_ONE_DAY.replace("$name",titleEvent).replace("$time",dateTime));

		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116434.</li>
	*<li> Test Case Name: Change From and To time of event that happens in full 1 day or several days in Week View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_ChangeFromAndToTimeOfEventThatHappensInFull1DayOrSeveralDaysInWeekView() {
		info("Test 12 Change From and To time of event that happens in full 1 day or several days in Week View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add new event
		*Input Data: 
			- Choose to view calendar in Week view
			- Add event that happens in full 1 day or over several day
		*Expected Outcome: 
			Added event is displayed at the top of working pane of selecting week*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,true,calendar);
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Extent start time/date
		*Input Data: 
			Drag and drop the left border of added event to the left
		*Expected Outcome: 
			Event is extended in earlier time or date, a tool tip is shown to report changed time while resizing*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Extent end time/date
		*Input Data: 
			Drag and drop the right border of added event to the right
		*Expected Outcome: 
			Event is extended in later time or date, a tool tip is shown to report changed time while resizing*/
		int currentDay = Integer.parseInt(getCurrentDate("dd")); 
		int firstDay= Integer.parseInt( getFirstDayOfWeek("dd"));
		int lastDay= Integer.parseInt( getLastDayOfWeek("dd"));
		if(currentDay==firstDay){
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ALL_DAY.replace("$date",getLastDayOfWeek("MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY.replace("$date",getLastDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent));
		}else 
		if(currentDay==lastDay){
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ALL_DAY.replace("$date",getFirstDayOfWeek("MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY.replace("$date",getFirstDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent));
		}
		else {
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ALL_DAY.replace("$date",getDate(1,"MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY.replace("$name",titleEvent).replace("$date",getDate(1,"MMM dd yyyy")));
		}
		

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 
		info("Check displaying in WorkWeek views after editing");
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in List views after editing");
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Week views after editing");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Month views after editing");
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116435.</li>
	*<li> Test Case Name: Change end time of event by drag and drop in Work Week View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_ChangeEndTimeOfEventByDragAndDropInWorkWeekView() {
		info("Test 13 Change end time of event by drag and drop in Work Week View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View events/tasks of a calendar in Week View
		*Input Data: 
			- Choose to view in Work Week View type
			- Add event that happens in one day
		*Expected Outcome: 
			Added event is displayed in Week View as a part of one day in current week*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getCurrentDate("MM/dd/yyyy HH")+":00",null,false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change end time
		*Input Data: 
			Drag end time of event in working pane to new time in day
		*Expected Outcome: 
			Event's end time is updated successfully*/ 
		info("Drag end time of event up/down in working pane to new time in day");
		int targetTime=Integer.parseInt(getCurrentDate("HH"))+2;
		String newTargetTime=String.valueOf(targetTime)+":00";
		info("currentTime:"+getCurrentDate("HH"));
		info("newTargertTime:"+newTargetTime);
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent))));
		mouseOver(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),true);
		
        dragObject(cHome.ELEMENT_EVENT_TASK_RESIZE_CONTAINER.replace("$name",titleEvent),cHome.ELEMENT_EVENT_TASK_DAY_ONE_DAY.replace("$date",newTargetTime));
		
        String dateTime=getCurrentDate("HH")+":00"+" - "+String.valueOf(targetTime)+":30";
		info("dateTime:"+dateTime);
		waitForAndGetElement(cHome. ELEMENT_EVENT_TASK_DETAIL_TIME_WEEK_ONE_DAY.replace("$name",titleEvent).replace("$time",dateTime));

		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116436.</li>
	*<li> Test Case Name: Change From and To time of event that happens in full 1 day or several days in Work Week View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED: BECAUSE CANNOT CHANGE TIME IF THE EVENT IS FULL DAY. TEST CASE IS INCORRECT.
	*/
	@Test(groups="pending")
	public  void test14_ChangeFromAndToTimeOfEventThatHappensInFull1DayOrSeveralDaysInWorkWeekView() {
		info("Test 14 Change From and To time of event that happens in full 1 day or several days in Work Week View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add new event
		*Input Data: 
			- Choose to view calendar in Work Week view
			- Add event that happens in full 1 day or over several day
		*Expected Outcome: 
			Added event is displayed at the top of working pane of selecting week*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Extent start time/date
		*Input Data: 
			Drag and drop the left border of added event to the left
		*Expected Outcome: 
			Event is extended in earlier time or date, a tool tip is shown to report changed time while resizing*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Extent end time/date
		*Input Data: 
			Drag and drop the right border of added event to the right
		*Expected Outcome: 
			Event is extended in later time or date, a tool tip is shown to report changed time while resizing*/

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 

 	}

	/**
	*<li> Case ID:116437.</li>
	*<li> Test Case Name: Change time  of 1 day event by drag and drop in Month View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_ChangeTimeOf1DayEventByDragAndDropInMonthView() {
		info("Test 15 Change time  of 1 day event by drag and drop in Month View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View events/tasks of a calendar in Week View
		*Input Data: 
			- Choose to view in Month View type
			- Add event that happens inside 1 day or all day
		*Expected Outcome: 
			Added event is displayed*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change time of event
		*Input Data: 
			Drag and drop added event to new day
		*Expected Outcome: 
			Event is updated and displayed in new day*/
		dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
				cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getLastDayOfWeek("MMM dd yyyy")));
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getLastDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent));
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and moved to new selected date*/ 
		info("Check displaying in WorkWeek views after editing");
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in List views after editing");
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Week views after editing");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Month views after editing");
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116438.</li>
	*<li> Test Case Name: Change time of event that happens in several days by drag and drop in Month View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_ChangeTimeOfEventThatHappensInSeveralDaysByDragAndDropInMonthView() {
		info("Test 16 Change time of event that happens in several days by drag and drop in Month View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View events/tasks of a calendar in Week View
		*Input Data: 
			- Choose to view in Month View type
			- Add event that happens over several days
		*Expected Outcome: 
			Added event is displayed*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		int currentDay = Integer.parseInt(getCurrentDate("dd")); 
		int firstDay= Integer.parseInt( getFirstDayOfWeek("dd"));
		int lastDay= Integer.parseInt( getLastDayOfWeek("dd"));
		
		evMg.goToAddEventFromActionBar();
		if(currentDay==firstDay)
			evMg.inputDataEventInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),getLastDayOfWeek("MM/dd/yyyy"),false,calendar);
		else if(currentDay==lastDay)
			evMg.inputDataEventInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),getLastDayOfWeek("MM/dd/yyyy"),false,calendar);
		else
			evMg.inputDataEventInQuickForm(titleEvent, content,getDate(1,"MM/dd/yyyy"),getDate(2,"MM/dd/yyyy"),false,calendar);
		
		evMg.saveQuickAddEvent();
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change time of event
		*Input Data: 
			Drag and drop added event to new day
		*Expected Outcome: 
			Event is updated both start and end time, the number of days that event happens is not changed*/
		
		if(currentDay==firstDay){
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getDate(1,"MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(1,"MMM dd yyyy")).replace("$name",titleEvent));
		}else 
		if(currentDay==lastDay){
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getDate(-1,"MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(-1,"MMM dd yyyy")).replace("$name",titleEvent));
		}
		else {
			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getDate(1,"MMM dd yyyy")));
			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(1,"MMM dd yyyy")).replace("$name",titleEvent));
		}
		

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and moved to new selected date*/ 
		info("Check displaying in WorkWeek views after editing");
		cHome.goToView(selectViewOption.DAY);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in List views after editing");
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Week views after editing");
		cHome.goToView(selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Check displaying in Month views after editing");
		cHome.goToView(selectViewOption.WORKWEEK);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
		info("Delete calendar and all events");
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116439.</li>
	*<li> Test Case Name: Drag and drop events of same day to another day.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_DragAndDropEventsOfSameDayToAnotherDay() {
		info("Test 17 Drag and drop events of same day to another day");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View events/tasks of a calendar in Week View
		*Input Data: 
			- Choose to view in Month View type
			- Add events that start in the same day
		*Expected Outcome: 
			Added events are displayed*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getCurrentDate("MM/dd/yyyy HH"),null,false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an Event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent1, content1,getCurrentDate("MM/dd/yyyy HH"),null,false,calendar);
		evMg.saveQuickAddEvent();
		
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1));

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change time of event
		*Input Data: 
			- Select added events by checking their check boxes
			- Drag and drop selected events to new day
		*Expected Outcome: 
			Selected events are moved to new day (start time)*/
         String[] names = {titleEvent,titleEvent1};
         cHome.checkBoxEventTaskInMonthView(names);
         int currentDay = Integer.parseInt(getCurrentDate("dd")); 
 		 int firstDay= Integer.parseInt( getFirstDayOfWeek("dd"));
 		 int lastDay= Integer.parseInt( getLastDayOfWeek("dd"));
         if(currentDay==firstDay){
 			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
 					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getDate(1,"MMM dd yyyy")));
 			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(1,"MMM dd yyyy")).replace("$name",titleEvent));
 			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(1,"MMM dd yyyy")).replace("$name",titleEvent1));
 		}else 
 		if(currentDay==lastDay){
 			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
 					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getDate(-1,"MMM dd yyyy")));
 			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(-1,"MMM dd yyyy")).replace("$name",titleEvent));
 			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(-1,"MMM dd yyyy")).replace("$name",titleEvent1));
 		}
 		else {
 			dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
 					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getDate(1,"MMM dd yyyy")));
 			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(1,"MMM dd yyyy")).replace("$name",titleEvent));
 			waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getDate(1,"MMM dd yyyy")).replace("$name",titleEvent1));
 		}
 		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and moved to new selected date*/ 
         info("Check displaying in WorkWeek views after editing");
 		cHome.goToView(selectViewOption.DAY);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
 		info("Check displaying in List views after editing");
 		cHome.goToView(selectViewOption.LIST);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
 		info("Check displaying in Week views after editing");
 		cHome.goToView(selectViewOption.WEEK);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
 		info("Check displaying in Month views after editing");
 		cHome.goToView(selectViewOption.WORKWEEK);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
 		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
 		info("Delete calendar and all events");
 		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116440.</li>
	*<li> Test Case Name: Drag and drop event of different day to another day.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_DragAndDropEventOfDifferentDayToAnotherDay() {
		info("Test 18 Drag and drop event of different day to another day");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View events/tasks of a calendar in Week View
		*Input Data: 
			- Choose to view in Month View type
			- Add events that start in different days
		*Expected Outcome: 
			Added events are displayed*/
		
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		int currentDay = Integer.parseInt(getCurrentDate("dd")); 
		int firstDay= Integer.parseInt( getFirstDayOfWeek("dd"));
		int lastDay= Integer.parseInt( getLastDayOfWeek("dd"));
		
		evMg.goToAddEventFromActionBar();
		if(currentDay==firstDay)
			evMg.inputDataEventInQuickForm(titleEvent, content,getDate(1,"MM/dd/yyyy"),null,false,calendar);
		else if(currentDay==lastDay)
			evMg.inputDataEventInQuickForm(titleEvent, content,getDate(-1,"MM/dd/yyyy"),null,false,calendar);
		else
			evMg.inputDataEventInQuickForm(titleEvent, content,getDate(1,"MM/dd/yyyy"),null,false,calendar);
		
		evMg.saveQuickAddEvent();
		
		info("Add an Event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		if(currentDay==firstDay)
			evMg.inputDataEventInQuickForm(titleEvent1, content1,getDate(2,"MM/dd/yyyy"),null,false,calendar);
		else if(currentDay==lastDay)
			evMg.inputDataEventInQuickForm(titleEvent1, content1,getDate(-2,"MM/dd/yyyy"),null,false,calendar);
		else
			evMg.inputDataEventInQuickForm(titleEvent1, content1,getDate(2,"MM/dd/yyyy"),null,false,calendar);
		
		evMg.saveQuickAddEvent();
		
		
		info("Added event is displayed in working panel");
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1));

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change time of event
		*Input Data: 
			- Select added events by checking their check boxes
			- Drag and drop selected events to new day
		*Expected Outcome: 
			Selected events are moved to the same new day (start time)*/
	     String[] names = {titleEvent,titleEvent1};
         cHome.checkBoxEventTaskInMonthView(names);
 		 dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),
 					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getLastDayOfWeek("MMM dd yyyy")));
 		 
 		 waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getLastDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent));
 		 waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getLastDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent1));
	
	   /*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and moved to new selected date*/ 
         info("Check displaying in WorkWeek views after editing");
  		cHome.goToView(selectViewOption.DAY);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
  		info("Check displaying in List views after editing");
  		cHome.goToView(selectViewOption.LIST);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
  		info("Check displaying in Week views after editing");
  		cHome.goToView(selectViewOption.WEEK);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
  		info("Check displaying in Month views after editing");
  		cHome.goToView(selectViewOption.WORKWEEK);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1),2000,2);
  		info("Delete calendar and all events");
  		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116441.</li>
	*<li> Test Case Name: Edit event with valid data.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_EditEventWithValidData() {
		info("Test 19 Edit event with valid data");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Add category [ Details ]
			- calendar [ Details ]
			- event [ Details ]
		*Expected Outcome: 
			All events/tasks of selecting calendar are displayed in list*/
		info("Create a new category");
		String categoryName=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cMang.addEventCategory(categoryName);
		
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,false,calendar);
		evMg.saveQuickAddEvent();

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Show form to edit event
		*Input Data: 
			- Select view type
			- Right click on event that you have edit right from list/working pane and select Edit
		*Expected Outcome: 
			- Edit event form appears with current information of event in form
			- all events/tasks in list are kept in alphabetical order if they was sorted before*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Edit event
		*Input Data: 
			Do some valid changes and clickSave
		*Expected Outcome: 
			Event is changed and updated in list/working pane*/ 
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cHome.goToView(selectViewOption.LIST);
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputDataEventInDetailForm(titleEvent2,titleEvent2,null,null,false,null,categoryName);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
        cMang.deleteCalendar(calendar);
        cMang.deleteEventCategory(categoryName);
 	}

	/**
	*<li> Case ID:116442.</li>
	*<li> Test Case Name: Edit event while viewing in List view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test20_EditEventWhileViewingInListView() {
		info("Test 20 Edit event while viewing in List view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show calendar in List View
		*Input Data: 
			- Add category [ Details ]
			- Add calendar and events[ Details ]
			- Select List View
		*Expected Outcome: 
			All events/tasks of selecting calendar are displayed in list*/
		info("Create a new category");
		String categoryName=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cMang.addEventCategory(categoryName);
		
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,false,calendar);
		evMg.saveQuickAddEvent();
		
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Show detail of a specific event
		*Input Data: 
			Click on an personal event in list
		*Expected Outcome: 
			Event's content is displayed in Detail pane below the list*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Edit event
		*Input Data: 
			Do some valid changes and save
		*Expected Outcome: 
			Event is changed and updated in list and details pane*/
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cHome.goToView(selectViewOption.LIST);
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputDataEventInDetailForm(titleEvent2,titleEvent2,null,null,false,null,categoryName);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed as changes*/ 
		
		 info("Check displaying in WorkWeek views after editing");
  		cHome.goToView(selectViewOption.DAY);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Check displaying in List views after editing");
  		cHome.goToView(selectViewOption.MONTH);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Check displaying in Week views after editing");
  		cHome.goToView(selectViewOption.WEEK);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Check displaying in Month views after editing");
  		cHome.goToView(selectViewOption.WORKWEEK);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Delete calendar and all events");
  		cMang.deleteCalendar(calendar);
  		cMang.deleteEventCategory(categoryName);
 	}

	/**
	*<li> Case ID:116443.</li>
	*<li> Test Case Name: Edit event which was imported from machine.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test21_EditEventWhichWasImportedFromMachine() {
		info("Test 21 Edit event which was imported from machine");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Export calendar from other application
		*Input Data: 
			Perform to export a calendar from other application (sunbird )
		*Expected Outcome: 
			The calendar is exported successfully*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Import above calendar toexo calendar
		*Input Data: 
			Perform to import calendar
		*Expected Outcome: 
			The calendar is imported successfully*/
		String attachment=fData.getAttachFileByArrayTypeRandom(71);
		String calendarName= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Import calendar");
		hp.goToCalendarPage();
		cMang.importCalendar("TestData/" + attachment,calendarName,null,null);

		info("Check inported calendar ");
		driver.navigate().refresh();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", calendarName));
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Perform to edit event whichis stored imported calendar
		*Input Data: 
			- Right click the event and choose Edit option
			- Perform to change information
			- Click Save
		*Expected Outcome: 
			The event is changed properly*/ 
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String titleEvent ="calendar export";
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputDataEventInDetailForm(titleEvent2,titleEvent2,null,null,false,calendarName);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.MONTH);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		cMang.deleteCalendar(calendarName);

 	}

	/**
	*<li> Case ID:116444.</li>
	*<li> Test Case Name: Edit  date of event in List View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test22_EditDateOfEventInListView() {
		info("Test 22 Edit  date of event in List View");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create event
		*Input Data: 
			- Add category [ Details ]
			- Add calendar and events[ Details ] events that happens in one day
		*Expected Outcome: 
			All events of selected day are displayed in working pane*/
		info("Create a new category");
		String categoryName=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cMang.addEventCategory(categoryName);
		
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,false,calendar);
		evMg.saveQuickAddEvent();
		
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View events in list
		*Input Data: 
			- Select List View
			- Select the day that added event occurs
		*Expected Outcome: 
			Event is displayed in list*/
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Edit event
		*Input Data: 
			Change From and To date of event
		*Expected Outcome: 
			- Event disappears from list of selecting day
			- Edited event will be displayed in list after click Next/Previous icon 'till the new selected date of event*/
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputDataEventInDetailForm(titleEvent2,titleEvent2,getFirstDayOfWeek("MM/dd/yyyy"),getLastDayOfWeek("MM/dd/yyyy"),false,null,categoryName);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check displaying in other views after editing
		*Input Data: 
			Select other views
		*Expected Outcome: 
			The edited event is updated and displayed with new changes*/ 
		info("Check displaying in WorkWeek views after editing");
  		cHome.goToView(selectViewOption.DAY);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Check displaying in List views after editing");
  		cHome.goToView(selectViewOption.MONTH);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Check displaying in Week views after editing");
  		cHome.goToView(selectViewOption.WEEK);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Check displaying in Month views after editing");
  		cHome.goToView(selectViewOption.WORKWEEK);
  		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2),2000,2);
  		info("Delete calendar and all events");
  		cMang.deleteCalendar(calendar);
  		cMang.deleteEventCategory(categoryName);
 	}

	/**
	*<li> Case ID:116445.</li>
	*<li> Test Case Name: Edit event in shared calendar in case it is no longer exists or moved to other calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*FOUND A BUG ABOUT THIS: https://jira.exoplatform.org/browse/CAL-1140
	*/
	@Test
	public  void test23_EditEventInSharedCalendarInCaseItIsNoLongerExistsOrMovedToOtherCalendar() {
		info("Test 23 Edit event in shared calendar in case it is no longer exists or moved to other calendar");
		/*Step Number: 1
		*Step Name: - Step 1: Create Calendar(s), event(s), share the calendar
		*Step Description: 
			- Create calendar ,event 
			- If login by root, perform to shared the calendar to other user (demo)
		*Input Data: 
			
		*Expected Outcome: 
			- The calendar and event are created
			- The calendar is shared*/
		String titleWindowParent=driver.getWindowHandle();
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
   		info("Create a new calendar");
		String calendar2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar2, calendar2,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar2));
   		
   		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, null,null,false,calendar);
		evMg.saveQuickAddEvent();
		
		String[] userGroup={DATA_USER4};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		/*Step number: 2
		*Step Name: - Step 2: view shared event by demo on other browser
		*Step Description: 
			- Login by demo on other browser
			- View the event
		*Input Data: 
			
		*Expected Outcome: 
			The event is shown properly all view types*/
		startNewDriver();
		String titleWindowChild=newDriver.getWindowHandle();
		HomePagePlatform hp2 = new HomePagePlatform(newDriver);
		CalendarManagement cMang2= new CalendarManagement(newDriver);
		CalendarHomePage cHome2 = new CalendarHomePage(newDriver);
		ManageLogInOut magAcc2 = new ManageLogInOut(newDriver);
		EventManagement evMg2 = new EventManagement(newDriver);
		magAcc2.signIn(DATA_USER4,DATA_PASS);
		
		hp2.goToCalendarPage();
		info("The event is shown properly all view types");
  		cHome2.goToView(selectViewOption.DAY);
  		waitForAndGetElement(cMang2.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
  		info("Check displaying in Month views after editing");
  		cHome2.goToView(selectViewOption.MONTH);
  		waitForAndGetElement(cMang2.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
  		info("Check displaying in views after editing");
  		cHome2.goToView(selectViewOption.WORKWEEK);
  		waitForAndGetElement(cMang2.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);
  		info("Check displaying in views after editing");
  		cHome2.goToView(selectViewOption.LIST);
  		waitForAndGetElement(cMang2.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),2000,2);

		/*Step number: 3
		*Step Name: - Step 3: Change calendar of event by owner
		*Step Description: 
			- Come back root, and edit the shared event to change calendar of the shared event 
			by other calendar or delete it.
		*Input Data: 
			
		*Expected Outcome: 
			The event is edited successfully*/
		
  		switchBetweenBrowsers(titleWindowParent);
		hp.goToCalendarPage();
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent);
		evMg.inputDataEventInDetailForm(titleEvent2,titleEvent2,null,null,false,calendar2);
		evMg.saveAddEventDetails();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		
		/*Step number: 4
		*Step Name: - Step 4: Try to do some actions on shared event
		*Step Description: 
			- Come back demo, don't refresh browser
			- Try to performsome actions on shared event
		*Input Data: 
			
		*Expected Outcome: 
			- Show alert message report that : the event no long exist or has been moved to other calendar .
			- The shared event will disappear*/ 
		switchBetweenBrowsers(titleWindowChild);
    	String titleEvent3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang2.openEditEventTaskPopup(titleEvent);
		evMg2.inputDataEventInDetailForm(titleEvent3,titleEvent3,null,null,false);
		evMg2.saveAddEventDetails();
		
		info("Verify that  Show alert message report that : the event no long exist or has been moved to other calendar");
		cMang2.waitForAndGetElement(cMang2.ELEMENT_CALENDAR_WARINING_POPUP);
		info("The shared event will disappear");
		cMang2.waitForElementNotPresent(cMang2.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent2));
		newDriver.close();
		
		switchBetweenBrowsers(titleWindowParent);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar);
		cMang.deleteCalendar(calendar2);
		
 	}}