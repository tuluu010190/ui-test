package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_View extends CAL_TestConfig_3{

	/**
	*<li> Case ID:116291.</li>
	*<li> Test Case Name: Check the displaying of left panel in company context.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckTheDisplayingOfLeftPanelInCompanyContext() {
		info("Test 1: Check the displaying of left panel in company context");
		/*Step Number: 1
		*Step Name: Check left panel
		*Step Description: 
			- Log in to Calendar
			- View left panel
		*Input Data: 
			
		*Expected Outcome: 
			- Left panel includes 
			+ mini calendar
			+ list of personal calendars, group calendars and shared calendars*/
        hp.goToCalendarPage();
        waitForAndGetElement(cHome.ELEMENT_CALENDAR_MINI);
        waitForAndGetElement(cHome.ELEMENT_PERSONAL_CALENDAR_LIST);
        waitForAndGetElement(cHome.ELEMENT_GROUP_CALENDAR_LIST);
		
		/*Step number: 2
		*Step Name: Check show/ hide left panel
		*Step Description: 
			In main screen
			- Click on arrow icon between left panel and main screen to collapse
			- Click on this arrow again
		*Input Data: 
			
		*Expected Outcome: 
			- Left panel is hidden
			- Left panel is shown*/ 
        info("Hide the left panel");
        cHome.showHideLefPanel();
        info("Show the left panel");
        cHome.showHideLefPanel();

 	}

	/**
	*<li> Case ID:116519.</li>
	*<li> Test Case Name: Check view or hide event or task by category, calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckViewOrHideEventOrTaskByCategoryCalendar() {
		info("Test 2: Check view or hide event or task by category, calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add tasks/events
		*Input Data: 
			- Add group [ Details ]
			- Add new calendars [ Details ]
			- Add tasks/events [ Details ]
		*Expected Outcome: 
			Group, calendars, tasks/events are added successfully*/
		info("Create a new group");
		String groupName=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupLabel=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        navTool.goToUsersAndGroupsManagement();
        userAndGroup.chooseGroupTab();
        userAndGroup.addGroup(groupName, groupLabel,groupLabel,false);
        
        info("Create a new calendar");
		String userGroup="/"+groupName;
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
        cMang.saveAddCalendar();
        
        info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.LIST,selectDayOption.ONEDAY);
		
		info("Create a new calendar");
		String calendar2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar2, calendar2,null);
        cMang.saveAddCalendar();
        
        
		info("Add an event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent1,newContent1,calendar2);
		evMg.saveQuickAddEvent();
        
		cHome.verifyIsPresentEventTask(titleEvent1, selectViewOption.LIST,selectDayOption.ONEDAY);
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Check filtering calendar to show/hide events/tasks by calendar
		*Input Data: 
			- Uncheck some calendars in group
		*Expected Outcome: 
			- Unchecked calendar's event/tasks that is in/not in selected category are hidden*/
		cMang.showHideEventTask(calendar);
		waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1));
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 5: Filter to show/hide events/tasks by category
		*Input Data: 
			- Select another category
		*Expected Outcome: 
			- Events/tasks of new selected category and in selecting calendar are shown, others are hidden*/ 
		cMang.showHideEventTask(calendar);
		cMang.showHideEventTask(calendar2);
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent1));
		cMang.deleteCalendar(calendar2);
		cMang.deleteCalendar(calendar);
		cMang.deleteCalendar(groupName);
 	}

	/**
	*<li> Case ID:116520.</li>
	*<li> Test Case Name: Check showing mini calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckShowingMiniCalendar() {
		info("Test 3: Check showing mini calendar");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			Step 1: Check displaying of mini calendar
		*Input Data: 
			See mini calendar on top left panel
		*Expected Outcome: 
			Mini calendar is shown on top left panel without UI error*/
		 hp.goToCalendarPage();
	     waitForAndGetElement(cHome.ELEMENT_CALENDAR_MINI);
	     
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Check showing previous/next month mini calendar
		*Input Data: 
			Click Next/Previous month icon in the top pane of mini calendar
		*Expected Outcome: 
			- Next/Previous month is shown in mini calendar
			- Working pane has no change*/
	     cHome.goToView(selectViewOption.MONTH);
	     cHome.nextMonth(1);
	     waitForAndGetElement(cHome.ELEMENT_MONTH_VIEW_HEADER_BAR.replace("$monthYear",getCurrentDate("MMMM, yyyy")));
	     waitForAndGetElement(cHome.ELEMENT_CALENDAR_MINI_HEADER_BAR.replace("$month",getDayOfNextMonth("MMMM",0,4)));
	
	     /*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check showing calendar of a specific day from mini calendar
		*Input Data: 
			Click a day in mini calendar
		*Expected Outcome: 
			- Selecting day in mini calendar is marked by yellow
			- The calendar of selected day is displayed in working pane in Day View*/
	     cHome.previousMonth(1);
	     cHome.goToView(selectViewOption.DAY);
	     click(cHome.ELEMENT_CALENDAR_MINI_DAY.replace("$day",getFirstDayOfWeek("d")));
	     waitForAndGetElement(cHome.ELEMENT_DAY_VIEW_HEADER_BAR.
	    		 replace("$month",getFirstDayOfWeek("MM")).replace("$day",getFirstDayOfWeek("d"))
	    		 .replace("$year",getFirstDayOfWeek("yyyy")));
	     

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check showing calendar of a specific month from mini calendar
		*Input Data: 
			- Select to view one month in mini calendar
			- Click on the link month name in mini calendar
		*Expected Outcome: 
			The calendar of selected month is displayed in working pane in month View*/
	     cHome.goToView(selectViewOption.MONTH);
	     cHome.nextMonth(1);
	     click(cHome.ELEMENT_CALENDAR_MINI_DAY.replace("$day",getDayOfNextMonth("d",0,4)));
	     waitForAndGetElement(cHome.ELEMENT_MONTH_VIEW_HEADER_BAR.replace("$monthYear",getDayOfNextMonth("MMMM",0,4)));
	     
		/*Step number: 5
		*Step Name: 
		*Step Description: 
			Step 5: Check Week start day in mini
			-calendar
		*Input Data: 
			- Click [Settings]
			- Change Week start date: Wednesday
			- Click Save
		*Expected Outcome: 
			Week start date is consistent between mini
			-calendar and Week/Work Week/Mont Views : start from Wednesday*/ 
	     cMang.openSettingCalendar();
	     cMang.changeSettingCalendar(null,null,null,null,"Wednesday",null,null);
	     cMang.saveSetting();
	     waitForAndGetElement(cHome.ELEMENT_CALENDAR_MINI_ORDER_DAY.replace("$number","1").replace("$shortDay","WE"));
	     cHome.goToView(selectViewOption.MONTH);
	     waitForAndGetElement(cHome.ELEMENT_MONTH_VIEW_ORDER_DAY.replace("$number","1").replace("$day","WED"));
	     cHome.goToView(selectViewOption.WEEK);
	     waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","1").replace("$day","Wed"));
	     cHome.goToView(selectViewOption.WORKWEEK);
	     waitForAndGetElement(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","1").replace("$day","Wed"));
 	}

	/**
	*<li> Case ID:116521.</li>
	*<li> Test Case Name: Check Day View of calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CheckDayViewOfCalendar() {
		info("Test 4: Check Day View of calendar");
		/*Step Number: 1
		*Step Name: Step 1: Display in Day View
		*Step Description: 
			- Create calendar, 
			- Create some events/tasks
			-Click Day button on tool bar
		*Input Data: 
			
		*Expected Outcome: 
			- All tasks/events of selected day are displayed
			- Tasks/events happening inside 1 day are displayed in working pane at corresponding From & To time
			- Tasks/events happening in full 1 day or in several days are displayed at the top of working pane*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent1, newContent1,null,null,true,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an event");
		int currDay=Integer.parseInt(getCurrentDate("dd"));
		int firstDay=Integer.parseInt(getFirstDayOfWeek("dd"));
		int lastDay=Integer.parseInt(getLastDayOfWeek("dd"));
		
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent2, newContent2,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an event");
		String titleEvent3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent3= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent3, newContent3,getLastDayOfWeek("MM/dd/yyyy"),null,false,calendar);
		evMg.saveQuickAddEvent();
		
		cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.DAY ,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent1,selectViewOption.DAY ,selectDayOption.ALLDAY);
		
		/*Step number: 2
		*Step Name: Step 2: Check showing calendar in next/previous day
		*Step Description: 
			Click Next/Previous day icon in title pane
		*Input Data: 
			
		*Expected Outcome: 
			- Jump to view calendar in Next or Previous day of selecting day
			- All corresponding tasks/events are shown*/
		int currDayNum=getDayOfWeek(-2);
		cHome.nextDate(4-currDayNum);
		cHome.verifyIsPresentEventTask(titleEvent3,selectViewOption.DAY ,selectDayOption.ONEDAY);
		if(currDay==lastDay){
			cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.DAY ,selectDayOption.ONEDAY);
			cHome.verifyIsPresentEventTask(titleEvent1,selectViewOption.DAY ,selectDayOption.ALLDAY);
		}else{
			cHome.verifyIsNotPresentEventTask(titleEvent,selectViewOption.DAY ,selectDayOption.ONEDAY);
			cHome.verifyIsNotPresentEventTask(titleEvent1,selectViewOption.DAY ,selectDayOption.ALLDAY);
		}
		
		cHome.previousDate(4);
		cHome.verifyIsPresentEventTask(titleEvent2,selectViewOption.DAY ,selectDayOption.ONEDAY);
		if(currDay==firstDay){
			cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.DAY ,selectDayOption.ONEDAY);
			cHome.verifyIsPresentEventTask(titleEvent1,selectViewOption.DAY ,selectDayOption.ALLDAY);
		}else{
			cHome.verifyIsNotPresentEventTask(titleEvent,selectViewOption.DAY ,selectDayOption.ONEDAY);
			cHome.verifyIsNotPresentEventTask(titleEvent1,selectViewOption.DAY ,selectDayOption.ALLDAY);
		}
		
		/*Step number: 3
		*Step Name: Step 3: Jump to view calendar in month of selecting day
		*Step Description: 
			Click on month in title pane
		*Input Data: 
			
		*Expected Outcome: 
			All events/tasks in this month are displayed in Month View*/ 
		cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.MONTH,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent1,selectViewOption.MONTH,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent2,selectViewOption.MONTH,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent3,selectViewOption.MONTH,selectDayOption.ONEDAY);
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116522.</li>
	*<li> Test Case Name: View calendar in current date of system.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_ViewCalendarInCurrentDateOfSystem() {
		info("Test 5: View calendar in current date of system");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View calendar in current date
		*Input Data: 
			Click Today in action bar
		*Expected Outcome: 
			- All events/tasks in current date are displayed as Day view
			- Other actions on this view are the same with Day View*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
		click(cHome.ELEMENT_TODAY_ACTION_BAR);
		Utils.pause(2000);
		cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.DAY,selectDayOption.ONEDAY);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116523.</li>
	*<li> Test Case Name: View calendar in current date of system  in case search form is been  showing.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_ViewCalendarInCurrentDateOfSystemInCaseSearchFormIsBeenShowing() {
		info("Test 6: View calendar in current date of system  in case search form is been  showing");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Perform to search event
		*Input Data: 
			Perform to search event
		*Expected Outcome: 
			Return search result*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
		cMang.searchQuickEventTask(titleEvent);
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View calendar in current date
		*Input Data: 
			Click Today in action bar
		*Expected Outcome: 
			- All events/tasks in current date are displayed as Day view
			- Other actions on this view are the same with Day View
			- Type view whichis shown on tool bar , is corresponding to working panel*/ 
		click(cHome.ELEMENT_TODAY_ACTION_BAR);
		Utils.pause(2000);
		cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.DAY,selectDayOption.ONEDAY);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116524.</li>
	*<li> Test Case Name: Check default Week View of calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_CheckDefaultWeekViewOfCalendar() {
		info("Test 7: Check default Week View of calendar");
		/*Step Number: 1
		*Step Name: Step 1: Display in Week View
		*Step Description: 
			- Create calendar, events/tasks
			- Select Week View type: Click Week button on tool bar
		*Input Data: 
			
		*Expected Outcome: 
			- Week view is displayed from Monday to Sunday
			- All tasks/events in selected week are displayed
			- Tasks/events happen inside 1 day is displayed in working pane at corresponding From & To time
			- Tasks/events happens in full 1 day or in several days are displayed at the top of working pane*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent1, newContent1,null,null,true,calendar);
		evMg.saveQuickAddEvent();
		
		cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.WEEK,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent1,selectViewOption.WEEK,selectDayOption.ALLDAY);
		
		/*Step number: 2
		*Step Name: Step 2: Check showing calendar in next/previous week
		*Step Description: 
			Click Next/Previous week icon in title pane
		*Input Data: 
			
		*Expected Outcome: 
			- Jump to view calendar in Next or Previous day of selecting week
			- All corresponding tasks/events are shown*/
		
		cHome.nextDate(1);
		cHome.verifyIsNotPresentEventTask(titleEvent,selectViewOption.WEEK,selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTask(titleEvent1,selectViewOption.WEEK,selectDayOption.ALLDAY);
		
		cHome.previousDate(2);
		cHome.verifyIsNotPresentEventTask(titleEvent,selectViewOption.WEEK,selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTask(titleEvent1,selectViewOption.WEEK,selectDayOption.ALLDAY);
		
		/*Step number: 3
		*Step Name: Step 3: Jump to view calendar in month of selecting week
		*Step Description: 
			Click on month in title pane
		*Input Data: 
			
		*Expected Outcome: 
			All events/tasks in this month are displayed in Month View*/ 
		cHome.verifyIsPresentEventTask(titleEvent,selectViewOption.MONTH,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent1,selectViewOption.MONTH,selectDayOption.ALLDAY);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116525.</li>
	*<li> Test Case Name: Check Week view after setting starting day of week.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CheckWeekViewAfterSettingStartingDayOfWeek() {
		info("Test 8: Check Week view after setting starting day of week");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Setting calendar
		*Input Data: 
			- Click Settings in Action bar
			- Select one day for Week Start on
			- Save
		*Expected Outcome: 
			Calendar setting is changed*/
		
	    cMang.openSettingCalendar();
        cMang.changeSettingCalendar(null,null,null,null,"Wednesday",null,null);
        cMang.saveSetting();

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View calendar in Week view after being changed
		*Input Data: 
			- Add calendar, events/tasks
			- Select Week View
		*Expected Outcome: 
			- Calendar is displayed in week from new selected day for start week to the last day
			- Other actions are the same as before being changed*/
    	info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
        cHome.goToView(selectViewOption.WEEK);
        waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","1").replace("$day","Wed"));
        waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","2").replace("$day","Thu"));
        waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","3").replace("$day","Fri"));
        waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","4").replace("$day","Sat"));
        waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","5").replace("$day","Sun"));
        waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","6").replace("$day","Mon"));
        waitForAndGetElement(cHome.ELEMENT_WEEK_VIEW_ORDER_DAY.replace("$number","7").replace("$day","Tue"));
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116526.</li>
	*<li> Test Case Name: Check Work week view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_CheckWorkWeekView() {
		info("Test 9: Check Work week view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View calendar in work week view
		*Input Data: 
			- Add calendar, events/tasks [ Details ]
			- Select Work Week View : Click Work Week button on tool bar
		*Expected Outcome: 
			- Display calendar in 5 working days from Monday to Friday. Saturday & Sunday are hidden
			- Other actions on this view are the same in week view*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
        cHome.goToView(selectViewOption.WORKWEEK);
        waitForAndGetElement(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","1").replace("$day","Mon"));
        waitForAndGetElement(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","2").replace("$day","Tue"));
        waitForAndGetElement(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","3").replace("$day","Wed"));
        waitForAndGetElement(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","4").replace("$day","Thu"));
        waitForAndGetElement(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","5").replace("$day","Fri"));
        waitForElementNotPresent(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","6").replace("$day","Sat"));
        waitForElementNotPresent(cHome.ELEMENT_WORK_WEEK_VIEW_ORDER_DAY.replace("$number","7").replace("$day","Sun"));
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116527.</li>
	*<li> Test Case Name: Check Month view of calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_CheckMonthViewOfCalendar() {
		info("Test 10 Check Month view of calendar");
		/*Step Number: 1
		*Step Name: Step 1: Display calendar in Month View
		*Step Description: 
			- Add calendar, events/tasks[ Details ]
			- Select Month View : Click Month button on tool bar
		*Input Data: 
			
		*Expected Outcome: 
			- Calendar is displayed in selected month
			- All events/tasks in month are shown*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        String titleEvent=txData.getContentByArrayTypeRandom(6)+"1";
        String titleEvent1=txData.getContentByArrayTypeRandom(6)+"2";
        String titleEvent2=txData.getContentByArrayTypeRandom(6)+"3";
        String titleEvent3=txData.getContentByArrayTypeRandom(6)+"4";
        String titleEvent4=txData.getContentByArrayTypeRandom(6)+"5";
        
		info("Add an event");
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,titleEvent,calendar);
		evMg.saveQuickAddEvent();
		
        cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.MONTH,selectDayOption.ONEDAY);
        
        info("Add an event");
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent1,titleEvent1,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an event");
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent2,titleEvent2,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an event");
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent3,titleEvent3,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add an event");
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent4,titleEvent4,calendar);
		evMg.saveQuickAddEvent();
		
        
		/*Step number: 2
		*Step Name: Step 2: Check showing calendar in next/previous month
		*Step Description: 
			Click Next/Previous month icon in title pane
		*Input Data: 
			
		*Expected Outcome: 
			Show events/tasks of next/previous month of selecting month*/
        cHome.nextDate(1);
		cHome.verifyIsNotPresentEventTask(titleEvent,selectViewOption.MONTH,selectDayOption.ONEDAY);
		
		cHome.previousDate(2);
		cHome.verifyIsNotPresentEventTask(titleEvent,selectViewOption.MONTH,selectDayOption.ONEDAY);

		/*Step number: 3
		*Step Name: Step 3: Check month view when there are more than 4 tasks/event a day
		*Step Description: 
			- Add more than 4 tasks/events in the same day
			- Select Month view
			- Click on a link to show hidden events/tasks list
		*Input Data: 
			
		*Expected Outcome: 
			- Only 3 tasks/events are shown, others are hidden 
			- There's a link to let user knows how many tasks/events are hidden
			- Show hidden events/tasks*/ 
		click(cHome.ELEMENT_TODAY_ACTION_BAR);
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.
				replace("$date",getCurrentDate("MMM dd yyyy")).replace("$name",titleEvent4));
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.
				replace("$date",getCurrentDate("MMM dd yyyy")).replace("$name",titleEvent3));
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.
				replace("$date",getCurrentDate("MMM dd yyyy")).replace("$name",titleEvent2));
		waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.
				replace("$date",getCurrentDate("MMM dd yyyy")).replace("$name",titleEvent1));
		waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.
				replace("$date",getCurrentDate("MMM dd yyyy")).replace("$name",titleEvent));
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW_MORE_ICON.replace("$date",getCurrentDate("MMM dd yyyy")));
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116528.</li>
	*<li> Test Case Name: Check List view of calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_CheckListViewOfCalendar() {
		info("Test 11 Check List view of calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: View calendar in List
		*Input Data: 
			- Add calendar, events/tasks[ Details ]
			- Select List View : Click List button on tool bar
		*Expected Outcome: 
			- Calendar is displayed in list in a specific day
			- By default Show all is selected: both events and tasks are shown*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,newContent,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add a task");
		String titleTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(titleTask,newTask);
		tasMg.saveQuickAddTask();
		
        cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.LIST,selectDayOption.ONEDAY);
        cHome.verifyIsPresentEventTask(titleTask, selectViewOption.LIST,selectDayOption.ONEDAY);

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View events in list only
		*Input Data: 
			- Click on Show all 
			- Select Show events only from menu
		*Expected Outcome: 
			Tasks in list are hidden, events are shown only*/
        click(cHome.ELEMENT_CALENDAR_LIST_VIEW_SHOW_ALL_ARROW);
        click(cHome.ELEMENT_CALENDAR_LIST_VIEW_SHOW_ALL_ITEM_EVENT_ONLY);
        waitForAndGetElement(cHome. ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
        waitForElementNotPresent(cHome. ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleTask));

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: View tasks in list only
		*Input Data: 
			- Click on Show events only
			- Select Show tasks only from menu
		*Expected Outcome: 
			Events in list are hidden, Tasks are shown only*/ 
        click(cHome.ELEMENT_CALENDAR_LIST_VIEW_SHOW_ALL_ARROW);
        click(cHome.ELEMENT_CALENDAR_LIST_VIEW_SHOW_ALL_ITEM_TASK_ONLY);
        waitForAndGetElement(cHome. ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleTask));
        waitForElementNotPresent(cHome. ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116529.</li>
	*<li> Test Case Name: Check view in client when change server date time.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATE: CANNOT CHANGE DATE TIME ON SERVER MACHINE
	*/
	@Test(groups="pending")
	public  void test12_CheckViewInClientWhenChangeServerDateTime() {
		info("Test 12 Check view in client when change server date time");
		/*Step Number: 1
		*Step Name: Step 1: Add event
		*Step Description: 
			- Click on [Event] from action bar
			- Check default date time of To date, From date
		*Input Data: 
			
		*Expected Outcome: 
			- Add event from quick add events form with default date time
			- To date, From date is current date of client*/

		/*Step number: 2
		*Step Name: Step 2: Change server date time
		*Step Description: 
			- Open TerminalChange time on server in terminal by a command: sudo date 
			-
			-set "{date time}"
		*Input Data: 
			
		*Expected Outcome: 
			Date time of server is changed successfully*/

		/*Step number: 3
		*Step Name: Step 3: View date time in calendar porlet
		*Step Description: 
			- Click on [Day] view
			- Click on [Today] to check date time
			- Click on button [Event]
		*Input Data: 
			
		*Expected Outcome: 
			- Date time of client is not updated following server, today is still current date of client
			- From date, To date still show current date of client, not follow date time of server*/ 

 	}

	/**
	*<li> Case ID:116530.</li>
	*<li> Test Case Name: Check view when change client date time.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_CheckViewWhenChangeClientDateTime() {
		info("Test 13 Check view when change client date time");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Click on Event from tool bar
			- Show default date time
		*Expected Outcome: 
			- Add event from quick add events form with default date time
			- Added event is shown in current date of calendar*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, newContent, getCurrentDate("MM/dd/yyyy")+" 12:00",
				getCurrentDate("MM/dd/yyyy")+" 14:00",false,calendar);
		evMg.saveQuickAddEvent();
		
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_TIME_WEEK.replace("$date",getCurrentDate("EEE MMM dd yyyy")).
				replace("$name",titleEvent).replace("$time","12:00 - 14:00"));
		
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		int currTimeHour= Integer.parseInt(getCurrentDate("HH"));
		int currTimeMin= Integer.parseInt(getCurrentDate("mm"));
		int timeFromHour=0;
		evMg.inputDataEventInQuickForm(null,null,null,null,false);
		if(currTimeMin<30 && currTimeHour>0){
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(currTimeHour)+":30"),2000,2);
		}else{
			 timeFromHour=currTimeHour+1;
			 info("timeFromHour"+timeFromHour);
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(timeFromHour)+":00"),2000,2);
		}
		evMg.cancelQuickAddEditEvent();

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change client date time
		*Input Data: 
			- Click on Settings to change timezone
			- Select new timezone
		*Expected Outcome: 
			Client calendar views current date time. After updating, current date time is changed*/
		hp.goToCalendarPage();		
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar(null,"(GMT +01:00) Europe/Paris",null,null,null,null,null);
		cMang.saveSetting();
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: View date time in calendar portlet
		*Input Data: 
			- Click on Calendar portlet
		*Expected Outcome: 
			The date time of the calendar portlet is displayed following changed client*/ 
		String local="Europe/Paris";
		int currTimeHour1= Integer.parseInt(getCurrentDate("HH",local));
		int currTimeMin1= Integer.parseInt(getCurrentDate("mm",local));
		int timeFromHour1=0;
		
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_TIME_WEEK.replace("$date",getCurrentDate("EEE MMM dd yyyy",local)).
				replace("$name",titleEvent).replace("$time","07:00 - 09:00"));
		
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		
		evMg.inputDataEventInQuickForm(null,null,null,null,false);
		if(currTimeMin1<30 && currTimeHour1>0){
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(currTimeHour1)+":30"),2000,2);
		}else{
			 timeFromHour1=currTimeHour1+1;
			 info("timeFromHour"+timeFromHour1);
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(timeFromHour1)+":00"),2000,2);
		}
		evMg.cancelQuickAddEditEvent();
		cMang.deleteCalendar(calendar);

 	}}