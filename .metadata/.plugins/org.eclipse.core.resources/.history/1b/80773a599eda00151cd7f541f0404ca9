package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Manage_Color extends CAL_TestConfig_2{

	/**
	*<li> Case ID:116494.</li>
	*<li> Test Case Name: Change shared calendar color.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ChangeSharedCalendarColor() {
		info("Test 1: Change shared calendar color");
		/*Step Number: 1
		*Step Name: Step 1: Create calendar
		*Step Description: 
			- Add a personal calendar
		*Input Data: 
			
		*Expected Outcome: 
			Personal calendar is added and listed under personal calendar list*/
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
		
		info("Add a Task");
		String titleTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(titleTask, contentTask, calendar);
		tasMg.saveQuickAddTask();
   		
		/*Step number: 2
		*Step Name: Step 2: Share a calendar
		*Step Description: 
			- Select Share action by clicking on "Setting" icon beside the added calendar, then click Share.
			- Choose an user or group.
			- Click Save.
		*Input Data: 
			
		*Expected Outcome: 
			- Calendar is shared.
			- The shared user can view this calendar in the list of shared calendars.*/

   	    String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
        hp.goToCalendarPage();
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		/*Step number: 3
		*Step Name: Step 3: Change calendar color
		*Step Description: 
			- Right click on added calendar and select a color from color list
		*Input Data: 
			
		*Expected Outcome: 
			- The calendar is changed by selected color, all events and tasks are shown in calendar is changed. 
			- The shared user cannot change color of the shared calendar.*/ 
		String[] color={"powder_blue"};
		cMang.executeActionCalendar(calendar, menuOfCalendarOption.COLOR,color);
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM_COLOR.replace("$calendar",calendar).replace("$color",color[0]));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_COLOR.replace("$name",titleEvent).replace("$color",color[0]));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_COLOR.replace("$name",titleTask).replace("$color",color[0]));
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116495.</li>
	*<li> Test Case Name: Change personal calendar color.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_ChangePersonalCalendarColor() {
		info("Test 2: Change personal calendar color");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar
		*Input Data: 
			- Click Calendar actions icon and select Add calendar
		*Expected Outcome: 
			Added calendar is displayed in each selected group's calendar list in left pane*/
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
		
		info("Add a Task");
		String titleTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(titleTask, contentTask, calendar);
		tasMg.saveQuickAddTask();
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change calendar color
		*Input Data: 
			- Right click on added calendar and select a color from color list
		*Expected Outcome: 
			The calendar is changed by selected color, all events and tasks are shown in calendar is changed.*/ 
   		String[] color={"powder_blue"};
		cMang.executeActionCalendar(calendar, menuOfCalendarOption.COLOR,color);
   	    hp.goToCalendarPage();
   	    cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM_COLOR.replace("$calendar",calendar).replace("$color",color[0]));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_COLOR.replace("$name",titleEvent).replace("$color",color[0]));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_COLOR.replace("$name",titleTask).replace("$color",color[0]));
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116496.</li>
	*<li> Test Case Name: Change group calendar color.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_ChangeGroupCalendarColor() {
		info("Test 3: Change group calendar color");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar
		*Input Data: 
			Add a group calendar
		*Expected Outcome: 
			Group calendar is added*/
		
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
   		
   	    info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendar);
		evMg.saveQuickAddEvent();
		
		info("Add a Task");
		String titleTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(titleTask, contentTask, calendar);
		tasMg.saveQuickAddTask();

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Change calendar color
		*Input Data: 
			- Right click on added calendar and select a color from colors list
		*Expected Outcome: 
			The calendar is changed by selected color, all events and tasks are shown in calendar is changed color.*/ 

		String[] color={"powder_blue"};
		cMang.executeActionCalendar(calendar, menuOfCalendarOption.COLOR,color);
   	    hp.goToCalendarPage();
   	    cHome.goToView(selectViewOption.LIST);
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM_COLOR.replace("$calendar",calendar).replace("$color",color[0]));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_COLOR.replace("$name",titleEvent).replace("$color",color[0]));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_COLOR.replace("$name",titleTask).replace("$color",color[0]));
		cMang.deleteCalendar(calendar, true);
 	}}