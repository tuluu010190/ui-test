package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Event_Popover extends CAL_TestConfig_3{

	/**
	*<li> Case ID:116465.</li>
	*<li> Test Case Name: View event by popover.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ViewEventByPopover() {
		info("Test 1: View event by popover");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create a event
		*Input Data: 
			- Click on Add Event button
			- Input event info
			- Click Save
		*Expected Outcome: 
			Event is added successfully*/
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
		

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View event by rollover
		*Input Data: 
			- Mouse focus on the created event at step 1
		*Expected Outcome: 
			A small pop up display correct information of the added event*/ 
		info("Mouse over on the event");
		String nameDate=getCurrentDate("EEE").substring(0,2).toUpperCase();
		int currHour=Integer.parseInt(getCurrentDate("HH"));
		int currMin =Integer.parseInt(getCurrentDate("mm"));
		
		
		mouseOver(cMang.ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name",titleEvent),true);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_POPOVER_POPUP_INFOR.replace("$info",titleEvent));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_POPOVER_POPUP_INFOR.replace("$info",newContent));
		if(currMin<30 && currMin>0){
			String timeStart=nameDate+", "+getCurrentDate("MMMM dd, ")+String.valueOf(currHour)+":30";
			String timeEnd=String.valueOf(currHour+1)+":30";
			waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_POPOVER_POPUP_INFOR.
					replace("$info",timeStart+" - "+timeEnd));
		}else{
			String timeStart1=nameDate+", "+getCurrentDate("MMMM dd, ")+String.valueOf(currHour)+":00";
			String timeEnd1=String.valueOf(currHour+1)+":00";
			waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_POPOVER_POPUP_INFOR.
					replace("$info",timeStart1+" - "+timeEnd1));
		}
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116466.</li>
	*<li> Test Case Name: Edit event by double click.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*
	*/
	@Test
	public  void test02_EditEventByDoubleClick() {
		info("Test 2: Edit event by double click");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create a event
		*Input Data: 
			- Click on Add Event button
			- Input event info
			- Click Save
		*Expected Outcome: 
			Event is added successfully*/
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
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(titleEvent,newContent,calendar);
		evMg.saveAddEventDetails();
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View event by rollover
		*Input Data: 
			- Mouse focus on the created event at step 1
		*Expected Outcome: 
			A small pop up display correct information of the added event*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Edit event by double click
		*Input Data: 
			- Double click on the event
			- Modify and Save
		*Expected Outcome: 
			- Edit calendar form displayed with correct data
			- Event can be edited normally*/ 
		info("Edit the event");
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.doubleClickOnElement(cMang.ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name",titleEvent));
		evMg.inputBasicDetailEvent(titleEvent1,newContent1);
		evMg.saveAddEventDetails();
		cMang.deleteCalendar(calendar);

 	}}