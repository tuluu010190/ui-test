package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Event_End_Date_Suggestion extends CAL_TestConfig_3{

	/**
	*<li> Case ID:115842.</li>
	*<li> Test Case Name: End date of all-day Event should be updated after editing Start date.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_EndDateOfAlldayEventShouldBeUpdatedAfterEditingStartDate() {
		info("Test 1: End date of all-day Event should be updated after editing Start date");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
			- Add all
			-day event
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- All
			-day event is created*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),null,true,calendar);
		evMg.saveQuickAddEvent();
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.WEEK,selectDayOption.ALLDAY);
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit event above
			- Un-check all day check box
			- Input a start date in the input box 
			- Remove the focus on the text field
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End date is updated
			- The value is start date + default duration: 1 day*/ 
		info("Edit the event");
	    cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
	    evMg.inputDataEventInDetailForm(null,null,getLastDayOfWeek("MM/dd/yyyy"),null,false);
	    evMg.saveAddEventDetails();
	    
	    info("Edit the event");
	    cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_EVENT_TO_DATE_VALUE.
				replace("$value",getLastDayOfWeek("MM/dd/yyyy")));
		evMg.cancelAddEditDetailEvent();
        cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115844.</li>
	*<li> Test Case Name: Default Start date should be displayed at Today for Event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DefaultStartDateShouldBeDisplayedAtTodayForEvent() {
		info("Test 2: Default Start date should be displayed at Today for Event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- The Default Start date "From" is set to Today (System date)*/ 
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_DATE_VALUE.
        		replace("$value",getCurrentDate("MM/dd/yyyy")));
		evMg.cancelQuickAddEditEvent();
 	}

	/**
	*<li> Case ID:115845.</li>
	*<li> Test Case Name: Default Start time should be displayed at current time for Event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_DefaultStartTimeShouldBeDisplayedAtCurrentTimeForEvent() {
		info("Test 3: Default Start time should be displayed at current time for Event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- The Default Start time "From" is displayed 
			H:00, H:30 or H+1:00 where H is the current hour.
			 It selects the value corresponding to the next hour.*/ 
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
 	}

	/**
	*<li> Case ID:115850.</li>
	*<li> Test Case Name: End times value in the list of options should be on half hour for Event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_EndTimesValueInTheListOfOptionsShouldBeOnHalfHourForEvent() {
		info("Test 4: End times value in the list of options should be on half hour for Event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed*/
		

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on the End Time textfield
		*Input Data: 
			
		*Expected Outcome: 
			- the list of options is displayed, times values proposed are half hour*/ 
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
        waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_LIST_HOUR_TO_DATE_VALUE);
		evMg.cancelQuickAddEditEvent();
 	}

	/**
	*<li> Case ID:115851.</li>
	*<li> Test Case Name: Start times value in the list of options should be on half hour for Event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_StartTimesValueInTheListOfOptionsShouldBeOnHalfHourForEvent() {
		info("Test 5: Start times value in the list of options should be on half hour for Event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on the Start Time textfield
		*Input Data: 
			
		*Expected Outcome: 
			- the list of options is displayed, times values proposed are half hour*/ 
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
        waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_LIST_HOUR_FROM_DATE_VALUE);
		evMg.cancelQuickAddEditEvent();
 	}

	/**
	*<li> Case ID:115853.</li>
	*<li> Test Case Name: Default Start time should be displayed at current time for event from left panel.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_DefaultStartTimeShouldBeDisplayedAtCurrentTimeForEventFromLeftPanel() {
		info("Test 6: Default Start time should be displayed at current time for event from left panel");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- From the left panel "Calendar", click on "Settings" button of a calendar
			- Choose the option "AddEvent"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- The Default Start time "From" is displayed H:00, H:30 or H+1:00 where H is the current hour. 
			It selects the value corresponding to the next half hour.*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a event");
		hp.goToCalendarPage();		
		cMang.executeActionCalendar(calendar, menuOfCalendarOption.ADDEVENT);
		int currTimeHour= Integer.parseInt(getCurrentDate("HH"));
		int currTimeMin= Integer.parseInt(getCurrentDate("mm"));
		int timeFromHour=0;
		evMg.inputDataEventInQuickForm(null,null,null,null,false);
		if(currTimeMin<30 && currTimeHour>0){
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(currTimeHour)+":30"),2000,2);
		}else{
			 timeFromHour=currTimeHour+1;
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(timeFromHour)+":00"),2000,2);
		}
		evMg.cancelQuickAddEditEvent();
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115854.</li>
	*<li> Test Case Name: Default Start date should be displayed at Today for Event from left panel.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_DefaultStartDateShouldBeDisplayedAtTodayForEventFromLeftPanel() {
		info("Test 7: Default Start date should be displayed at Today for Event from left panel");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- From the left panel "Calendar", click on "Settings" button of a calendar
			- Choose the option "Add Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- The Default Start date "From" is set to Today (System date)*/ 
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_DATE_VALUE.replace("$value",getCurrentDate("MM/dd/yyyy")));
		evMg.cancelQuickAddEditEvent();
 	}

	/**
	*<li> Case ID:115856.</li>
	*<li> Test Case Name: End date of Event should be updated after edit Start date from Select box.</li>
	*<li> Pre-Condition: Edit the duration by edit the End date</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_EndDateOfEventShouldBeUpdatedAfterEditStartDateFromSelectBox() {
		info("Test 8: End date of Event should be updated after edit Start date from Select box");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- Start Date and End date are displayed
			- Duration is X days*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Select a start date with the select box
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End date is updated 
			- The value is start date + default duration (X)*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a event");
		int currDay=Integer.parseInt(getCurrentDate("dd"));
		int lastDay = Integer.parseInt(getLastDayOfWeek("dd"));
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		if(currDay==lastDay){
			evMg.inputDataEventInQuickForm(titleEvent,content,getDate(-1,"MM/dd/yyyy"),
					getDate(-2,"MM/dd/yyyy"),false,calendar);
		}else{
			evMg.inputDataEventInQuickForm(titleEvent,content,getDate(1,"MM/dd/yyyy"),
					getDate(2,"MM/dd/yyyy"),false,calendar);
		}
		evMg.saveQuickAddEvent();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK);
		evMg.inputDataEventInDetailForm(titleEvent,content,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
		evMg.saveAddEventDetails();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_EVENT_TO_DATE_VALUE.
				replace("$value",getDateFromFirstDayOfWeek(1,"MM/dd/yyyy")));
        evMg.cancelAddEditDetailEvent();
        
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115857.</li>
	*<li> Test Case Name: End date of Event should be updated after edit Start date from input box.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_EndDateOfEventShouldBeUpdatedAfterEditStartDateFromInputBox() {
		info("Test 9: End date of Event should be updated after edit Start date from input box");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- Start Date and End date are displayed
			- Duration is X days*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Input a start date in the input box
			- Remove the focus on the textfield
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End date is updated 
			- The value is start date + default duration (X)*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a event");
		int currDay=Integer.parseInt(getCurrentDate("dd"));
		int lastDay = Integer.parseInt(getLastDayOfWeek("dd"));
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		if(currDay==lastDay){
			evMg.inputDataEventInQuickForm(titleEvent,content,getDate(-1,"MM/dd/yyyy"),
					getDate(-2,"MM/dd/yyyy"),false,calendar);
		}else{
			evMg.inputDataEventInQuickForm(titleEvent,content,getDate(1,"MM/dd/yyyy"),
					getDate(2,"MM/dd/yyyy"),false,calendar);
		}
		evMg.saveQuickAddEvent();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK);
		evMg.inputDataEventInDetailForm(titleEvent,content,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
		evMg.saveAddEventDetails();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_EVENT_TO_DATE_VALUE.
				replace("$value",getDateFromFirstDayOfWeek(1,"MM/dd/yyyy")));
        evMg.cancelAddEditDetailEvent();
        
        cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115858.</li>
	*<li> Test Case Name: User should be able to edit the End date.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_UserShouldBeAbleToEditTheEndDate() {
		info("Test 10 User should be able to edit the End date");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- Start Date and End date are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit the End Date
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End date is updated*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a event");
		int currDay=Integer.parseInt(getCurrentDate("dd"));
		int lastDay = Integer.parseInt(getLastDayOfWeek("dd"));
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		if(currDay==lastDay){
			evMg.inputDataEventInQuickForm(titleEvent,content,getDate(-1,"MM/dd/yyyy"),
					getDate(-2,"MM/dd/yyyy"),false,calendar);
		}else{
			evMg.inputDataEventInQuickForm(titleEvent,content,getDate(1,"MM/dd/yyyy"),
					getDate(2,"MM/dd/yyyy"),false,calendar);
		}
		evMg.saveQuickAddEvent();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK);
		evMg.inputDataEventInDetailForm(titleEvent,content,null,getLastDayOfWeek("MM/dd/yyyy"),false,calendar);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_EVENT_TO_DATE_VALUE.
				replace("$value",getLastDayOfWeek("MM/dd/yyyy")));
        evMg.cancelAddEditDetailEvent();
        
        cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115861.</li>
	*<li> Test Case Name: Default Duration of an Event by right click should be 30min.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_DefaultDurationOfAnEventByRightClickShouldBe30min() {
		info("Test 11 Default Duration of an Event by right click should be 30min");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Focus the mouse on a selected Day and Time
			- Right click andchoose "Add New Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			-Start time is where the click occurs 
			- Duration is 30 min*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		int sourceTimeHour=Integer.parseInt(getCurrentDate("HH"));
		int sourceTimeMin=Integer.parseInt(getCurrentDate("mm"));
        hp.goToCalendarPage();
        cMang.executeActionCalendar(calendar,menuOfCalendarOption.ADDEVENT);
        if(sourceTimeMin>30 && sourceTimeMin<0)
        	waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
        		replace("$value",String.valueOf(sourceTimeHour)+":30"),2000,2);
        else
        	waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
            		replace("$value",String.valueOf(sourceTimeHour+1)+":00"),2000,2);
        evMg.cancelQuickAddEditEvent();
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115862.</li>
	*<li> Test Case Name: Start/End time of an added Event on Day view by drag and drop should be displayed.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_StartEndTimeOfAnAddedEventOnDayViewByDragAndDropShouldBeDisplayed() {
		info("Test 12 Start/End time of an added Event on Day view by drag and drop should be displayed");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Choose the view "Day"
			- Drag and drop to add an event
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			-Start time and End time are displayed as selected*/ 
        
        int sourceTimeHour=Integer.parseInt(getCurrentDate("HH"));
        int targetTimeHour=sourceTimeHour+2;
        hp.goToCalendarPage();
        cMang.openQuickAddEventTaskInDayView(String.valueOf(sourceTimeHour),String.valueOf(targetTimeHour));
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
        		replace("$value",String.valueOf(sourceTimeHour)+":00"),2000,2);
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_TO_TIME_VALUE.
        		replace("$value",String.valueOf(targetTimeHour)+":00"),2000,2);
        evMg.cancelQuickAddEditEvent();
        
 	}

	/**
	*<li> Case ID:115863.</li>
	*<li> Test Case Name: Start/End time should not be suggested for an all day event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_StartEndTimeShouldNotBeSuggestedForAnAllDayEvent() {
		info("Test 13 Start/End time should not be suggested for an all day event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Add Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			-Start time and End time are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Check "All day" option
		*Input Data: 
			
		*Expected Outcome: 
			- Start/End Time field are removed*/ 
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,null,null,true);
		waitForElementNotPresent(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME);	
		waitForElementNotPresent(cMang.ELEMENT_QUICK_INPUT_EVENT_TO_TIME);	
		evMg.cancelQuickAddEditEvent();

 	}

	/**
	*<li> Case ID:115864.</li>
	*<li> Test Case Name: Start/End time of Event should displayed after uncheck all day box.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_StartEndTimeOfEventShouldDisplayedAfterUncheckAllDayBox() {
		info("Test 14 Start/End time of Event should displayed after uncheck all day box");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Add Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			-Start time and End time are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Check "All day" option
		*Input Data: 
			
		*Expected Outcome: 
			- Start/End Time field are removed*/
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,null,null,true);
		waitForElementNotPresent(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME);	
		waitForElementNotPresent(cMang.ELEMENT_QUICK_INPUT_EVENT_TO_TIME);	
		

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Unckeck "All day" option
		*Input Data: 
			
		*Expected Outcome: 
			- The date remains
			- The time range should be current time and time shift is 1 hour*/ 
		int currTimeHour= Integer.parseInt(getCurrentDate("HH"));
		int currTimeMin= Integer.parseInt(getCurrentDate("mm"));
		int timeFromHour=0;
		int timeToHour=0;
		evMg.inputDataEventInQuickForm(null,null,null,null,false);
		if(currTimeMin<30 && currTimeHour>0){
		    timeToHour=currTimeHour+1;
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(currTimeHour)+":30"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_TO_DATE_VALUE.
					replace("$value",String.valueOf(timeToHour)+":30"),2000,2);
		}else{
			 timeFromHour=currTimeHour+1;
		     timeToHour=currTimeHour+2;
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$value",String.valueOf(timeFromHour)+":00"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_TO_DATE_VALUE.
					replace("$value",String.valueOf(timeToHour)+":00"),2000,2);
		}
		evMg.cancelQuickAddEditEvent();
 	}

	/**
	*<li> Case ID:115867.</li>
	*<li> Test Case Name: Start/End time of Event should not change after edit the duration.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_StartEndTimeOfEventShouldNotChangeAfterEditTheDuration() {
		info("Test 15 Start/End time of Event should not change after edit the duration");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Add Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			-Start time and End time are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit Start Date or/and End Date to edit duration
		*Input Data: 
			
		*Expected Outcome: 
			- The duration of the Event is edited
			- The time suggestions (Start/end) are made with the current duration*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),
				getFirstDayOfWeek("MM/dd/yyyy"),true,calendar);
		evMg.saveQuickAddEvent();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		evMg.inputDataEventInDetailForm(null,null,getLastDayOfWeek("MM/dd/yyyy"), 
				getLastDayOfWeek("MM/dd/yyyy"),false);
		evMg.saveAddEventDetails();
		
		info("Edit the event");
		int currentHour=Integer.parseInt(getCurrentDate("HH"));
		int currentMin=Integer.parseInt(getCurrentDate("mm"));
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		if(currentMin<30 && currentMin>0){
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$time",String.valueOf(currentHour)+":30"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_EVENT_TO_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+1)+":30"),2000,2);
		}else{
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_EVENT_FROM_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+1)+":00"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_EVENT_TO_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+2)+":00"),2000,2);
		}
		evMg.cancelAddEditDetailEvent();
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115868.</li>
	*<li> Test Case Name: End time of Event should be updated after edit Start time.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_EndTimeOfEventShouldBeUpdatedAfterEditStartTime() {
		info("Test 16 End time of Event should be updated after edit Start time");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- Start Time and End Time are displayed
			- Duration is X hours*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Input a start datetime in the input box
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End time is updated 
			- The value is start time + default duration (X)*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),
				getFirstDayOfWeek("MM/dd/yyyy"),true,calendar);
		evMg.saveQuickAddEvent();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		evMg.inputDataEventInDetailForm(null,null,getLastDayOfWeek("MM/dd/yyyy ")+getCurrentDate("HH")+":00",null,false);
		evMg.saveAddEventDetails();
		
		info("Edit the event");
		int currentHour=Integer.parseInt(getCurrentDate("HH"));
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_EVENT_TO_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+1)+":00"),2000,2);
		evMg.cancelAddEditDetailEvent();
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115870.</li>
	*<li> Test Case Name: User should be able to edit the End date from edit event.</li>
	*<li> Pre-Condition: An event is added</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_UserShouldBeAbleToEditTheEndDateFromEditEvent() {
		info("Test 17 User should be able to edit the End date from edit event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Double click on an event
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed
			- Start Date and End date are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit the End Date
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End date is updated*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),
				getFirstDayOfWeek("MM/dd/yyyy"),false,calendar);
		evMg.saveQuickAddEvent();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		evMg.inputDataEventInDetailForm(null,null,null,getLastDayOfWeek("MM/dd/yyyy"),false);
		evMg.saveAddEventDetails();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_EVENT_TO_DATE_VALUE.
				replace("$value",getLastDayOfWeek("MM/dd/yyyy")));
		evMg.cancelAddEditDetailEvent();
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115871.</li>
	*<li> Test Case Name: Default Duration of an Event should be 1 hour.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_DefaultDurationOfAnEventShouldBe1Hour() {
		info("Test 18 Default Duration of an Event should be 1 hour");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the boutton "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			-The default duration for Event is 1 hour*/ 
		info("Add a event");
		int nextTimeHour=Integer.parseInt(getCurrentDate("HH"))+1;
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_EVENT_FROM_TIME_VALUE.
				replace("$time",getCurrentDate("HH")+":00"),2000,2);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_EVENT_TO_TIME_VALUE.
				replace("$time",String.valueOf(nextTimeHour)+":00"),2000,2);
		evMg.cancelQuickAddEditEvent();
 	}

	/**
	*<li> Case ID:115875.</li>
	*<li> Test Case Name: End date of Event should be suggested only when start date is updated.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_EndDateOfEventShouldBeSuggestedOnlyWhenStartDateIsUpdated() {
		info("Test 19 End date of Event should be suggested only when start date is updated");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Event"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			- Start Date and End date are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit the Start Date
		*Input Data: 
			
		*Expected Outcome: 
			- TheEnd date is suggested*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a event");
		hp.goToCalendarPage();		
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),
				getFirstDayOfWeek("MM/dd/yyyy"),true,calendar);
		evMg.saveQuickAddEvent();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		evMg.inputDataEventInDetailForm(null,null,getLastDayOfWeek("MM/dd/yyyy"),null,false);
		evMg.saveAddEventDetails();
		
		info("Edit the event");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_EVENT_TO_DATE_VALUE.
				replace("$value",getLastDayOfWeek("MM/dd/yyyy")));
		evMg.cancelAddEditDetailEvent();
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115876.</li>
	*<li> Test Case Name: Start/End time of an added Event on Week view by drag and drop should be displayed.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test20_StartEndTimeOfAnAddedEventOnWeekViewByDragAndDropShouldBeDisplayed() {
		info("Test 20 Start/End time of an added Event on Week view by drag and drop should be displayed");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Choose the view "Week"
			- Drag and drop to add an event
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Event" is displayed
			-Start time and End time are displayed as selected*/ 
	    int sourceTimeHour=Integer.parseInt(getCurrentDate("HH"));
        int targetTimeHour=sourceTimeHour+2;
        hp.goToCalendarPage();
        cMang.openQuickAddEventTaskInWeekView(getCurrentDate("MMM dd yyyy HH"),
        		getCurrentDate("MMM dd yyyy ")+String.valueOf(targetTimeHour));
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_DATE_VALUE.
				replace("$value",getCurrentDate("MM/dd/yyyy")));
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_TO_DATE_VALUE.
				replace("$value",getCurrentDate("MM/dd/yyyy")));
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE.
        		replace("$value",String.valueOf(sourceTimeHour)+":00"),2000,2);
        waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_EVENT_TO_TIME_VALUE.
        		replace("$value",String.valueOf(targetTimeHour)+":00"),2000,2);
        evMg.cancelQuickAddEditEvent();
 	}}