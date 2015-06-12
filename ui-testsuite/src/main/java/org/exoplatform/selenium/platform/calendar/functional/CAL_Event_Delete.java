package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.exoplatform.selenium.platform.calendar.EventManagement.recurringType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatEndType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatType;
import org.testng.annotations.*;


	public class CAL_Event_Delete extends CAL_TestConfig_2{

	/**
	*<li> Case ID:116393.</li>
	*<li> Test Case Name: Delete event in different views.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DeleteEventInDifferentViews() {
		info("Test 1: Delete event in different views");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show calendar
		*Input Data: 
			- Add new calendar, events[ Details ] 
			- Select View type to show calendar
		*Expected Outcome: 
			All events of selected day are displayed selected view*/
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
			Step 2: Delete event
		*Input Data: 
			- Right click on an event and select Delete
			- Click OK in confirm message
		*Expected Outcome: 
			The corresponding event is deleted and removed from calendar*/ 
		
		 info("Delete Data");
		 hp.goToCalendarPage();
		 cHome.goToView(selectViewOption.LIST);
		 cMang.deleteTaskEvent(titleEvent);

 	}

	/**
	*<li> Case ID:116394.</li>
	*<li> Test Case Name: Delete event in List View while viewing its details.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DeleteEventInListViewWhileViewingItsDetails() {
		info("Test 2: Delete event in List View while viewing its details");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View details of an event in List View
		*Input Data: 
			- Add new calendar, events[ Details ]
			- Select List View to show calendar
			- Select added event from list
		*Expected Outcome: 
			Selected event's details are displayed in Detail pane below the list*/
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content);
		evMg.saveQuickAddEvent();
		
		info("Add an Event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent1, content1);
		evMg.saveQuickAddEvent();
		
		cHome.goToView(selectViewOption.LIST);
		click(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_DETAIL_LIST_VIEW.replace("$name",titleEvent));
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Delete event
		*Input Data: 
			- Right click on selected event and select Delete or click the link Delete Event in detail pane
			- Click OK to confirm deleting
		*Expected Outcome: 
			Selected event is deleted from list, its detail also disappears from Detail pane*/ 
		cMang.deleteTaskEvent(titleEvent);
 	}

	/**
	*<li> Case ID:116395.</li>
	*<li> Test Case Name: Delete event while it is being viewed in search result.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_DeleteEventWhileItIsBeingViewedInSearchResult() {
		info("Test 3: Delete event while it is being viewed in search result");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show event in search result
		*Input Data: 
			- Add event [ Details ]
			- Search by keyword that matches added event
		*Expected Outcome: 
			Added event is displayed in search result*/
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content);
		evMg.saveQuickAddEvent();
		
		cMang.searchQuickEventTask(titleEvent);
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Delete event
		*Input Data: 
			Delete event from list in search result
		*Expected Outcome: 
			- Event is removed from search result
			- It is also removed from calendar
			- The search form is kept*/ 
		cMang.deleteTaskEvent(titleEvent);
		cMang.closeSearch();
 	}

	/**
	*<li> Case ID:116396.</li>
	*<li> Test Case Name: Delete event of shared calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_DeleteEventOfSharedCalendar() {
		info("Test 4: Delete event of shared calendar");
		/*Step Number: 1
		*Step Name: - Step 1: Add and share event
		*Step Description: 
			- Add new event [ Details ]
			- Share calendar contains added event for an user without edit right
			- Share calendar above for another user with edit right
		*Input Data: 
			
		*Expected Outcome: 
			event is added*/
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
		boolean[] canEdit1={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup1,canEdit1);
		
		/*Step number: 2
		*Step Name: - Step 2: Delete event without edit right
		*Step Description: 
			- Login by shared user who does not have edit right 
			- Right click on event of shared calendar
		*Input Data: 
			
		*Expected Outcome: 
			"Delete" action is not allowed. Only "view" action is allowed*/
		magAc.signOut();
		magAc.signIn(DATA_USER4, DATA_PASS);
		hp.goToCalendarPage();
		rightClickOnElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_CONTEXT_MENU_VIEW,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CONTEXT_MENU_DELETE,2000,2);
		
		
		/*Step number: 3
		*Step Name: - Step 3: Delete event with edit right
		*Step Description: 
			- Login by shared user who has edit right 
			- Right click on event of shared calendar and select Delete
		*Input Data: 
			
		*Expected Outcome: 
			Event is deleted*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteTaskEvent(titleEvent);
 	}

	/**
	*<li> Case ID:116397.</li>
	*<li> Test Case Name: Delete event of group calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_DeleteEventOfGroupCalendar() {
		info("Test 5: Delete event of group calendar");
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
		String[] user={DATA_USER2};
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.selectUserEditPermissionInGroup(user,1);
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
			Only View action is displayed*/
		
		magAc.signOut();
		magAc.signIn(DATA_USER3,DATA_PASS);
		hp.goToCalendarPage();
		rightClickOnElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_CONTEXT_MENU_VIEW,2000,2);
		waitForElementNotPresent(cMang.ELEMENT_CONTEXT_MENU_DELETE);

		/*Step number: 3
		*Step Name: Step 3: Edit event by member of group with edit right
		*Step Description: 
			- Login by member who is assign edit right on above group calendar
			- Right click on event of shared calendar and select Delete
		*Input Data: 
			
		*Expected Outcome: 
			Event is removed from group calendar*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToCalendarPage();
		cMang.deleteTaskEvent(titleEvent);

 	}

	/**
	*<li> Case ID:116398.</li>
	*<li> Test Case Name: Delete several events at a time in List View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_DeleteSeveralEventsAtATimeInListView() {
		info("Test 6: Delete several events at a time in List View");
		/*Step Number: 1
		*Step Name: Step 1: Add event
		*Step Description: 
			- Add new events
			- Select List View
		*Input Data: 
			
		*Expected Outcome: 
			Events are displayed in List View*/

		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content);
		evMg.saveQuickAddEvent();
		
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		
		/*Step number: 2
		*Step Name: Step 2: Delete events
		*Step Description: 
			- Check the check boxes of events in list
			- Click Delete checked in action bar
			- Click OK to confirm
		*Input Data: 
			
		*Expected Outcome: 
			Checked event are removed from list/search result*/ 
		hp.goToCalendarPage();
		cMang.deleteTaskEventByCheckbox(titleEvent);

 	}

	/**
	*<li> Case ID:116399.</li>
	*<li> Test Case Name: Delete Event in Search result.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_DeleteEventInSearchResult() {
		info("Test 7: Delete Event in Search result");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Add new events [ Details ]
			- Select List View or search with searching keyword matches added events
		*Expected Outcome: 
			Events are displayed in list or in search result*/
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content);
		evMg.saveQuickAddEvent();
		
		cMang.searchQuickEventTask(titleEvent);
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Delete event
		*Input Data: 
			- Right
			- click on event and chooseDelete option Or Click Delete Event link in Event detail
			- Click OK at confirm message
		*Expected Outcome: 
			- The Event is deleted and not shownat search form
			- The search form is still kept*/ 
		cMang.deleteTaskEvent(titleEvent);
		cMang.closeSearch();
 	}

	/**
	*<li> Case ID:116400.</li>
	*<li> Test Case Name: Delete several events at a time in Month view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_DeleteSeveralEventsAtATimeInMonthView() {
		info("Test 8: Delete several events at a time in Month view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add events
		*Input Data: 
			- Add new events [ Details ]
			- Select Month View
		*Expected Outcome: 
			Events are displayed in working pane of Month View*/
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content);
		evMg.saveQuickAddEvent();
		
		info("Add an Event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent1, content1);
		evMg.saveQuickAddEvent();
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Delete events
		*Input Data: 
			- Check the check boxes of events (in 1 day or different days)
			- Click Delete checked in action bar
			- Click OK to confirm
		*Expected Outcome: 
			All checked event are removed*/ 
		//evMg.deleteRecurringEvent(titleEvent, selectViewOption.MONTH,selectDayOption.ONEDAY,recurringType.ALL_EVENT,getDate(0,"MMM dd yyyy"));
		cMang.deleteTaskEvent(titleEvent);
 	}

	/**
	*<li> Case ID:116401.</li>
	*<li> Test Case Name: Delete event while it is been in reminder cycles.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_DeleteEventWhileItIsBeenInReminderCycles() {
		info("Test 9: Delete event while it is been in reminder cycles");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Add event with repeat reminder[ Details ]
		*Expected Outcome: 
			Event is added successfully*/
		info("Create a recurring event");
		String newEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String firstDay=getFirstDayOfWeek("MM/dd/yyyy");
		String numberRepeat="5";
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(newEvent,newEvent);
		evMg.inputFromToDetailEvent(firstDay, firstDay,false);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Delete event
		*Input Data: 
			Perform to delete the event
		*Expected Outcome: 
			After deleting event, reminders of the event are not allowed to show*/ 
		info("Delete Data");
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
		
		cHome.goToView(selectViewOption.LIST);
		waitForElementNotPresent(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
 	}

	/**
	*<li> Case ID:116518.</li>
	*<li> Test Case Name: Delete all event in a page when there are more than 1 page to display event in List View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_DeleteAllEventInAPageWhenThereAreMoreThan1PageToDisplayEventInListView() {
		info("Test 10 Delete all event in a page when there are more than 1 page to display event in List View");
		/*Step Number: 1
		*Step Name: Step 1: Add event
		*Step Description: 
			- Add new events in the same day (more than 10)
			- Select List View
		*Input Data: 
			
		*Expected Outcome: 
			Events are displayed in list view and divided in pages*/
		ArrayList<String> nameEvent = new ArrayList<String>();
		for(int i=0;i<10;i++){
			info("Add an Event");
			String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			hp.goToCalendarPage();
			evMg.goToAddEventFromActionBar();
			evMg.inputBasicQuickEvent(titleEvent, content);
			evMg.saveQuickAddEvent();
			nameEvent.add(titleEvent);
		}
		
		/*Step number: 2
		*Step Name: Step 2: Select all events in a page
		*Step Description: 
			Check the Check all check box in the title bar
		*Input Data: 
			
		*Expected Outcome: 
			All check boxes of events in current page are checked*/

		/*Step number: 3
		*Step Name: Step 3: Delete selected events
		*Step Description: 
			- Click Delete checked in action bar
			- Click OK to confirm deleting
		*Input Data: 
			
		*Expected Outcome: 
			- All checked events in list are deleted
			- The total number of page to display is reduced*/ 
		cHome.goToView(selectViewOption.LIST);
		cMang.deleteAllTaskEvent();
		waitForElementNotPresent(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",nameEvent.get(0)));
 	}}