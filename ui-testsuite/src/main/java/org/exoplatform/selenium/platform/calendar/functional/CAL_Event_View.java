package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.contextMenuEditEvenOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Event_View extends CAL_TestConfig_3{

	/**
	*<li> Case ID:116463.</li>
	*<li> Test Case Name: View a specific event in List view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ViewASpecificEventInListView() {
		info("Test 1: View a specific event in List view");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Add category [ Details ]
			- Add calendar and events[ Details ]
			- Select List View
		*Expected Outcome: 
			All events/tasks of selecting calendar are displayed in list*/
		info("Create a new category");
		String nameCategory = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.LIST);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCATEGORY);
        cMang.addEventCategory(nameCategory);
        
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
		evMg.inputBasicDetailEvent(titleEvent,newContent,calendar,nameCategory);
		evMg.saveAddEventDetails();
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View an event from right click menu
		*Input Data: 
			Right click on an event and select View
		*Expected Outcome: 
			Event content is displayed in Detail pane below the list*/
		info("View an event from right click menu");
		cHome.goToView(selectViewOption.WEEK);
		rightClickOnElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		cMang.selectOptionByRightclickOnEvent(contextMenuEditEvenOption.VIEW);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_PREVIEW_POPUP);
		click(cMang.ELEMENT_EVENT_TASK_PREVIEW_POPOP_CLOSE_BTN);
		waitForElementNotPresent(cMang.ELEMENT_EVENT_TASK_PREVIEW_POPUP);

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: View event by selecting from list
		*Input Data: 
			Click on one event form list
		*Expected Outcome: 
			Event content is displayed in Detail pane below the list*/ 
		info("View event by selecting from list");
		cMang.viewDetailsEventTaskInList(titleEvent);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116464.</li>
	*<li> Test Case Name: View a specific event in pop up.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_ViewASpecificEventInPopUp() {
		info("Test 2: View a specific event in pop up");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Add category [ Details ]
			- Add calendar and events[ Details ]
			- Select Day/Week/Month View
		*Expected Outcome: 
			All events/tasks of selecting calendar are displayed in working pane*/
		info("Create a new category");
		String nameCategory = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCATEGORY);
        cMang.addEventCategory(nameCategory);
        
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
		evMg.inputBasicDetailEvent(titleEvent,newContent,calendar,nameCategory);
		evMg.saveAddEventDetails();
		
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.DAY,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.MONTH,selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.WEEK,selectDayOption.ONEDAY);

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: View content of an event
		*Input Data: 
			Right click on an event and select View
		*Expected Outcome: 
			Content of selected event is displayed in a pop
			-up*/
		info("View an event from right click menu");
		cHome.goToView(selectViewOption.WEEK);
		rightClickOnElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent));
		cMang.selectOptionByRightclickOnEvent(contextMenuEditEvenOption.VIEW);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_PREVIEW_POPUP);
		click(cMang.ELEMENT_EVENT_TASK_PREVIEW_POPOP_CLOSE_BTN);
		waitForElementNotPresent(cMang.ELEMENT_EVENT_TASK_PREVIEW_POPUP);
		cMang.deleteCalendar(calendar);

 	}}