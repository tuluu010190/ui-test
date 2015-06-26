package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.contextMenuEditEvenOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.exoplatform.selenium.platform.calendar.EventManagement.recurringType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatEndType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatType;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Event_Recurring extends CAL_TestConfig_3{
		
	/**
	*<li> Case ID:115877.</li>
	*<li> Test Case Name: Delete many events from month view.</li>
	*<li> Pre-Condition: A recurring event is displayed in the Month View</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DeleteManyEventsFromMonthView() {
		info("Test 1: Delete many events from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view "Month"</p>
		*Input Data: 
			
		*Expected Outcome: 
			The Recurring events is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Select 2 or more recurring event instances of the same series<br>
			- In the left top corner of Month view, click on icon "Trash"<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop
			-up is shown:<br><br>+ Title: Delete events.<br>+ Message:&nbsp; Are you sure you want to delete these events? <br>+ Action buttons: Delete and Cancel.</p>*/
		cHome.goToView(selectViewOption.MONTH);
		cHome.checkBoxEventTaskInMonthView(titleEvent,getFirstDayOfWeek("MMM dd yyyy"));
        cHome.checkBoxEventTaskInMonthView(titleEvent,getLastDayOfWeek("MMM dd yyyy"));
        
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Selected events are deleted from the series</p>*/ 
        cMang.deleteTaskEvent();
        hp.goToCalendarPage();
        info("A repeat event is created successfully");
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,getFirstDayOfWeek("MMM dd yyyy"), 
				selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,getLastDayOfWeek("MMM dd yyyy"), 
				selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cMang.deleteCalendar(calendar);
	}

	/**
	*<li> Case ID:115878.</li>
	*<li> Test Case Name: Delete many events of different series from month view.</li>
	*<li> Pre-Condition: 2 series recurring event is displayed in the Month View</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DeleteManyEventsOfDifferentSeriesFromMonthView() {
		info("Test 2: Delete many events of different series from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view "Month"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>The Recurring events series are displayed</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Select 2 or more recurring event instances of different series<br>
			- Right click, choose "Delete" or select the [Delete_icon] on the top left panel of Calendar View panel.<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop
			-up is shown:</p><p><br>+ Title: Delete events.<br>+ Message:&nbsp; Are you sure you want to delete these events? <br>+ Action buttons: Delete and Cancel.</p>*/
		cHome.goToView(selectViewOption.MONTH);
		cHome.checkBoxEventTaskInMonthView(titleEvent,getFirstDayOfWeek("MMM dd yyyy"));
        cHome.checkBoxEventTaskInMonthView(titleEvent,getLastDayOfWeek("MMM dd yyyy"));
        
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Selected events are deleted from different series</p>*/ 
        cMang.deleteEventTaskInMonthView(titleEvent, getLastDayOfWeek("MMM dd yyyy"));
        hp.goToCalendarPage();
		info("A repeat event is created successfully");
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,getFirstDayOfWeek("MMM dd yyyy"), 
				selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,getLastDayOfWeek("MMM dd yyyy"), 
				selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115879.</li>
	*<li> Test Case Name: Delete edited recurring events and normal event from month view.</li>
	*<li> Pre-Condition: a recurring event is displayed in the Calendar, a normal event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_DeleteEditedRecurringEventsAndNormalEventFromMonthView() {
		info("Test 3: Delete edited recurring events and normal event from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring events series is displayed&nbsp;</p><p>
			- A normal event is displayed</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("Add an Event");
		String normalEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String normalContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(normalEvent,normalContent,calendar);
		evMg.saveQuickAddEvent();
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Edit recurring events</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- Recurring events are edited</p>*/
		info("Edit an recurring event");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Select edited recurring events and the normal event</p><p>
			- In the top left pane, click on "Trash" icon</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop
			-up is shown:</p><p>+ Title: Delete events.</p><p>+ Message:&nbsp;<em> Are you sure you want to delete these events?</em><span>&nbsp;</span></p><p><span>+ Action buttons: Delete and Cancel.<br></span></p>*/
		cHome.goToView(selectViewOption.MONTH);
		cHome.checkBoxEventTaskInMonthView(titleEvent2, "1",5);
		String[] otherEvents={normalEvent};
		cHome.checkBoxEventTaskInMonthView(otherEvents);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete.<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Selected edited recurring events and normal events are deleted.</p>*/ 
         cMang.deleteTaskEvent();
         info("A repeat event is deleted successfully");
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(normalEvent,getCurrentDate("MMM dd yyyy"), selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115880.</li>
	*<li> Test Case Name: Delete edited recurring events of different series from month view.</li>
	*<li> Pre-Condition: 2 or many recurring event series are displayed in the Calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_DeleteEditedRecurringEventsOfDifferentSeriesFromMonthView() {
		info("Test 4: Delete edited recurring events of different series from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>2 recurring events series are displayed: Serie A and Serie B&nbsp;</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		info("Create recurring event 2");
        String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent1,contentEvent1,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent1,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent1,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent1,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent1,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent1,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Edit recurring events from the serie A</p><p>
			- Edit recurring events from the serie B</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- Recurring events are edited for the both series</p>*/
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 hp.goToCalendarPage();
		 cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
	
		info("Edit an recurring event 2");
		String titleEvent3= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent1,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent3,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Select edited recurring events fo serie A & B</p><p>
			- In the left nail, click on "Trash" icon<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop
			-up is shown:<br><br>+ Title: Delete events.<br>+ Message:&nbsp; Are you sure you want to delete these events? <br>+ Action buttons: Delete and Cancel.</p>*/
		cHome.goToView(selectViewOption.MONTH);
		cHome.checkBoxEventTaskInMonthView(titleEvent2, "1",5);
		cHome.checkBoxEventTaskInMonthView(titleEvent3, "1",5);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Selected edited recurring events are deleted&nbsp;</p>*/ 
		 cMang.deleteTaskEvent();
		 hp.goToCalendarPage();
         info("A repeat event is deleted successfully");
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115881.</li>
	*<li> Test Case Name: Delete origin event of a series and other event from month view.</li>
	*<li> Pre-Condition: recurring events series is displayedan event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_DeleteOriginEventOfASeriesAndOtherEventFromMonthView() {
		info("Test 5: Delete origin event of a series and other event from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- recurring event series is displayed</p><p>
			- an event is displayed</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("Add an Event");
		String normalEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String normalContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(normalEvent,normalContent,calendar);
		evMg.saveQuickAddEvent();
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Select the origin event of the series and other event</p><p>
			- Right click, choose "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop
			-up is shown:<br><br>+ Title: Delete events.<br>+ Message:&nbsp; Are you sure you want to delete these events? <br>+ Action buttons: Delete and Cancel.</p>*/
		cHome.goToView(selectViewOption.MONTH);
		cHome.checkBoxEventTaskInMonthView(titleEvent, getCurrentDate("MMM dd yyyy"));
		String[] otherEvents={normalEvent};
		cHome.checkBoxEventTaskInMonthView(otherEvents);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Origin event and other events are deleted</p>*/ 
		 cMang.deleteTaskEvent();
		 hp.goToCalendarPage();
         info("A repeat event is deleted successfully");
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,getCurrentDate("MMM dd yyyy"), selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(normalEvent,getCurrentDate("MMM dd yyyy"), selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115882.</li>
	*<li> Test Case Name: Delete event of a series from month view.</li>
	*<li> Pre-Condition: recurring events series is displayed</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_DeleteEventOfASeriesFromMonthView() {
		info("Test 6: Delete event of a series from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>recurring event series is displayed</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Select an event of the series</p><p>
			- Right click, choose "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p><span>
			- A title: "Delete Recurring Event"</span><br><span>
			- A message: Would you like to delete only this event, all events in the series, or this and all following events in the series?</span><br><span>
			- The option 'Only this event" is selected by default</span><br><span>
			-A button "Delete"</span>&nbsp;</p>*/

		cHome.goToView(selectViewOption.MONTH);
		cHome.checkBoxEventTaskInMonthView(titleEvent, getCurrentDate("MMM dd yyyy"));
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Origin event is deleted</p>*/ 
		 cMang.deleteTaskEvent(recurringType.ONLY_EVENT);
		 hp.goToCalendarPage();
		 info("A repeat event is deleted successfully");
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,getCurrentDate("MMM dd yyyy"), selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115883.</li>
	*<li> Test Case Name: Delete multiple tasks from month view.</li>
	*<li> Pre-Condition: a Task is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_DeleteMultipleTasksFromMonthView() {
		info("Test 7: Delete multiple tasks from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>A task is displayed</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a task");
		String titleTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(titleTask,contentTask,calendar);
		tasMg.saveQuickAddTask();
		info("A task is displayed");
		cHome.verifyIsPresentEventTask(titleTask, selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Select the tasks</p><p>
			- Right click, choose "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop up is displayed:</p><ul><li>message :&nbsp;<div class="control
			-group"><div class="controls
			-full"><div id="confirm" class="confirm media"><div class="media
			-body">Are you sure you want to delete these tasks?</div></div></div></div></li><li>title :&nbsp;<em>Delete Tasks</em>&nbsp;</li><li>actions : <tt>Delete </tt>and&nbsp;<tt>Cancel</tt>&nbsp;</li></ul>*/

		cHome.goToView(selectViewOption.MONTH);
		String[] names ={titleTask};
		cHome.checkBoxEventTaskInMonthView(names);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Tasks are deleted</p>*/ 
		 cMang.deleteTaskEvent();
		 hp.goToCalendarPage();
		 info("A repeat event is deleted successfully");
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleTask,getCurrentDate("MMM dd yyyy"), selectViewOption.MONTH, selectDayOption.DETAILTIME);
         cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115884.</li>
	*<li> Test Case Name: Delete task and event from month view.</li>
	*<li> Pre-Condition: task and event are created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_DeleteTaskAndEventFromMonthView() {
		info("Test 8: Delete task and event from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>A task is displayed</p><p>An event is displayed</p>*/
		
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a task");
		String titleTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(titleTask,contentTask,calendar);
		tasMg.saveQuickAddTask();
		info("A task is displayed");
		cHome.verifyIsPresentEventTask(titleTask, selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,contentEvent,calendar);
		evMg.saveQuickAddEvent();
		info("An Event is displayed");
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Select the Task and the Event</p><p>
			- Right click, choose "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop up is displayed:</p><ul><li>Title: <em>Delete Tasks and Events</em> <br></li></ul><ul><li>Message :&nbsp;<em>Are you sure you want to delete these tasks and events?</em>&nbsp;</li><li>Action buttons: <tt>Delete</tt> and&nbsp;<tt>Cancel</tt>&nbsp;</li></ul>*/
		cHome.goToView(selectViewOption.MONTH);
		String[] names ={titleTask,titleEvent};
		cHome.checkBoxEventTaskInMonthView(names);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Task and event are deleted</p>*/ 
		 cMang.deleteTaskEvent();
		 hp.goToCalendarPage();
		 info("Task and Event are deleted");
		 cHome.verifyIsNotPresentEventTask(titleEvent, selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTask(titleTask, selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115885.</li>
	*<li> Test Case Name: Dismiss the Delete Multiple Confirmation Popup.</li>
	*<li> Pre-Condition: event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_DismissTheDeleteMultipleConfirmationPopup() {
		info("Test 9: Dismiss the Delete Multiple Confirmation Popup");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>An event is displayed</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent,contentEvent,calendar);
		evMg.saveQuickAddEvent();
		info("An Event is displayed");
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Select the event</p><p>
			- Right click, choose "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop up is displayed</p><ul><li>message :&nbsp;<em>Are you sure you want to delete these events?</em>&nbsp;</li><li>title :&nbsp;<em>Delete Events</em>&nbsp;</li><li>actions : <tt>Yes and No</tt><br></li></ul>*/
		cHome.goToView(selectViewOption.MONTH);
		String[] names ={titleEvent};
		cHome.checkBoxEventTaskInMonthView(names);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Click No<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- Pop up is dismissed</p><p>
			- The event still selected</p>*/ 
		info("Click on Delete button");
		click(cMang.ELEMENT_EVENT_TASK_DELETE_BUTTON);
		if (waitForAndGetElement(cMang.ELEMENT_CONFIRM_POPUP_DELETE, 2000, 0) != null)
			click(cMang.ELEMENT_CONFIRM_POPUP_NO);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_CHECKBOX_CHECKED.replace("$name",titleEvent),2000,2);
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115886.</li>
	*<li> Test Case Name: Delete edited recurring events of different series and normal event from month view.</li>
	*<li> Pre-Condition: a recurring event series A and Series B are displayed in the Calendara normal event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_DeleteEditedRecurringEventsOfDifferentSeriesAndNormalEventFromMonthView() {
		info("Test 10 Delete edited recurring events of different series and normal event from month view");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open Calendar application</p><p>
			- Choose the view&nbsp;"Month"&nbsp;</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring events series A and B are displayed</p><p>
			- A normal event is displayed</p>*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("Create recurring event");
        String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent1,contentEvent1,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("Add an Event");
		String normalEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String normalContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(normalEvent,normalContent,calendar);
		evMg.saveQuickAddEvent();
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Edit recurring events from series A</p><p>
			- Edit recurring events from series B</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- Recurring events of two series are edited</p>*/
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		hp.goToCalendarPage();
		info("Edit an recurring event 2");
		String titleEvent3= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent1,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent3,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Select edited recurring events of series A, 
			  edited recurring event of series B and the normal event</p><p>
			- Right click, choose option "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p><span>
			- A pop
			-up is shown:<br><br>+ Title: Delete events.<br>+ Message:&nbsp; Are you sure you want to delete these events? <br>+ Action buttons: Delete and Cancel.</span></p>*/

		cHome.goToView(selectViewOption.MONTH);
		cHome.checkBoxEventTaskInMonthView(titleEvent2, "1",5);
		cHome.checkBoxEventTaskInMonthView(titleEvent3, "1",5);
		String[] otherEvents={normalEvent};
		cHome.checkBoxEventTaskInMonthView(otherEvents);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			<p>
			- Click Delete<br></p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>Selected edited recurring events are deleted</p>*/ 
		
		 cMang.deleteTaskEvent();
		 hp.goToCalendarPage();
         info("A repeat event is deleted successfully");
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 
 		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent3,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		 cHome.verifyIsNotPresentEventTaskWithDateTime(normalEvent,getCurrentDate("MMM dd yyyy"), selectViewOption.MONTH, selectDayOption.DETAILTIME);
 		 cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115887.</li>
	*<li> Test Case Name: Display default settings of Repeat pop up.</li>
	*<li> Pre-Condition: $SELECTED_DAY is the day of the week of the currently selected day or the first day of the period selected if the event spans several days.</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_DisplayDefaultSettingsOfRepeatPopUp() {
		info("Test 11 Display default settings of Repeat pop up");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
			- Click on the button Event 
			- Click on "More details"
		*Input Data: 
			
		*Expected Outcome: 
			- Add/Edit event pop up is displayed
			- The icon "Repeat" is displayed*/

		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_EVENT_POPUP_FORM);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Check the icon "Repeat"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Recurring Event" is displayed
			- By default:* Repeat=Weekly, * Repeat every=1, * Repeat on=$SELECTED_DAY, * End repeat=Never*/ 
		check(cMang.ELEMENT_IS_REPEAT_CHECKBOX, 2);
		waitForAndGetElement(cMang.ELEMENT_RECURRING_FORM,2000,1);
		waitForAndGetElement(cMang.ELEMENT_SELECT_BOX_VALUE_SELECTED.replace("$name","1"));
		waitForAndGetElement(cMang.ELEMENT_SELECT_BOX_VALUE_SELECTED.replace("$name","weekly"));
		String shortDayName=getCurrentDate("EEE").substring(0,2).toUpperCase();
		info("shortDayName:"+shortDayName);
		waitForAndGetElement(cMang.ELEMENT_REPEAT_ON.replace("$day",shortDayName),2000,2);
		waitForAndGetElement(cMang.ELEMENT_NEVER_END_RECURRING_CHECKED,2000,2);
		evMg.cancelRecurringForm();
		evMg.cancelAddEditDetailEvent();
		
 	}

	/**
	*<li> Case ID:115888.</li>
	*<li> Test Case Name: An extra icon is displayed for a Repeat Event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_AnExtraIconIsDisplayedForARepeatEvent() {
		info("Test 12 An extra icon is displayed for a Repeat Event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Create a Recurring event
		*Input Data: 
			
		*Expected Outcome: 
			- Series of events is displayed with an extra icon, see attachment [extraIcon.png]*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("Series of events is displayed with an extra icon");
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON.replace("$name",titleEvent).replace("$number","1"));
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON.replace("$name",titleEvent).replace("$number","2"));
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON.replace("$name",titleEvent).replace("$number","3"));
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON.replace("$name",titleEvent).replace("$number","4"));
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON.replace("$name",titleEvent).replace("$number","5"));
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Move the mouse over the event
		*Input Data: 
			
		*Expected Outcome: 
			- The popover of the event shows the same icon 
			with the label "Recurring event", pls see attachment [Recurring_icon_On_Popover.png]*/ 
         mouseOver(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON.replace("$name",titleEvent).replace("$number","1"),true);
         Utils.pause(2000);
         waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_POPOVER_CONTENT);
         cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115889.</li>
	*<li> Test Case Name: Display Pop up Edit recurring event after changes in recurring event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_DisplayPopUpEditRecurringEventAfterChangesInRecurringEvent() {
		info("Test 13 Display Pop up Edit recurring event after changes in recurring event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Create a Recurring event
		*Input Data: 
			
		*Expected Outcome: 
			- Series of events is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed.
			- The pop up "Edit Recurring Event" is displayed*/ 
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115890.</li>
	*<li> Test Case Name: Display Pop up Edit recurring event after changing duration in recurring event.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_DisplayPopUpEditRecurringEventAfterChangingDurationInRecurringEvent() {
		info("Test 14 Display Pop up Edit recurring event after changing duration in recurring event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Create a Recurring event
		*Input Data: 
			
		*Expected Outcome: 
			- Series of events is displayed*/
		
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy HH")+":00",null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Drag and drop to resize
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Edit Recurring event" is displayed*/ 
		cHome.goToView(selectViewOption.WEEK);
		info("Drag end time of event up/down in working pane to new time in day");
		int targetTime=Integer.parseInt(getCurrentDate("HH"))+2;
		String newTargetTime=String.valueOf(targetTime)+":00";
		info("currentTime:"+getCurrentDate("HH"));
		info("newTargertTime:"+newTargetTime);
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent))));
		mouseOver(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",titleEvent),true);
		
        dragObject(cHome.ELEMENT_EVENT_TASK_RESIZE_CONTAINER.replace("$name",titleEvent),cHome.ELEMENT_EVENT_TASK_DAY_ONE_DAY.replace("$date",newTargetTime));
		
        evMg.editRecurringEvent(recurringType.ONLY_EVENT);
        hp.goToCalendarPage();
        String dateTime=getCurrentDate("HH")+":00"+" - "+String.valueOf(targetTime)+":30";
		info("dateTime:"+dateTime);
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_WEEK_TIME.replace("$name",titleEvent).replace("$time",dateTime));
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115891.</li>
	*<li> Test Case Name: Display Pop up confirmation after editing a recurring event.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_DisplayPopUpConfirmationAfterEditingARecurringEvent() {
		info("Test 15 Display Pop up confirmation after editing a recurring event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit event is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"*/ 
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115892.</li>
	*<li> Test Case Name: Confirmation pop up should be closed after saving changes.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_ConfirmationPopUpShouldBeClosedAfterSavingChanges() {
		info("Test 16 Confirmation pop up should be closed after saving changes");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Edit Recurring event" is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Select an item
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up is closed
			- Changes are performed*/ 
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115893.</li>
	*<li> Test Case Name: Confirmation pop up should be closed after cancel of changes.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_ConfirmationPopUpShouldBeClosedAfterCancelOfChanges() {
		info("Test 17 Confirmation pop up should be closed after cancel of changes");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Edit Recurring event" is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"*/

		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.cancelEditRecurringForm();
		evMg.cancelAddEditDetailEvent();
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Select an item
			- Click "Cancel", or click (x) icon on the top right of popup
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up is closed
			- Changes are not performed*/ 
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115894.</li>
	*<li> Test Case Name: "Only this event" should be the default selected option.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_OnlyThisEventShouldBeTheDefaultSelectedOption() {
		info("Test 18 Only this event should be the default selected option");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Edit Recurring event" is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"
			- The option "Only this Event" is selcted by Default*/ 
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		
		info("A repeat event is created successfully");
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115895.</li>
	*<li> Test Case Name: Event after edition by "Only this event" option.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_EventAfterEditionByOnlyThisEventOption() {
		info("Test 19 Event after edition by Only this event option");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events ( Title, Time..)
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"
			- The option "Only this Event" is selcted by Default*/

		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Choose the Defeult option "Only this Event"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- Changes are performed only for the selected event*/
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 hp.goToCalendarPage();
		 cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Check the Event layout
		*Input Data: 
			
		*Expected Outcome: 
			- The Event is marked as edited by an edit icon*/
 
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON_ONLY_EVENT.replace("$name",titleEvent2));
		
		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Move the mouse over the icon
		*Input Data: 
			
		*Expected Outcome: 
			A tooltip is displayed "edited recurring event"*/
		 mouseOver(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON_ONLY_EVENT.replace("$name",titleEvent2),true);
         Utils.pause(2000);
         waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_POPOVER_CONTENT_EDIT);
         
		/*Step number: 7
		*Step Name: 
		*Step Description: 
			- Edit the current event
		*Input Data: 
			
		*Expected Outcome: 
			- Popup to edit event is shown
			- The "Repeat" field is not checked"*/ 
        info("Edit an event");
        hp.goToCalendarPage();
 		cMang.openEditEventTaskPopup(titleEvent2,selectViewOption.WEEK);
 		waitForElementNotPresent(cMang.ELEMENT_IS_REPEAT_CHECKBOX_CHECKED);
 		evMg.cancelAddEditDetailEvent();
 		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115896.</li>
	*<li> Test Case Name: Repeat changes should be ignored if "Only this event" option is selected.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test20_RepeatChangesShouldBeIgnoredIfOnlyThisEventOptionIsSelected() {
		info("Test 20 Repeat changes should be ignored if Only this event option is selected");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);


		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed*/
		

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit Repeat details of recurring events
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"
			- The option "Only this Event" is selcted by Default*/

		
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Choose the Defeult option "Only this Event"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- Changes are performed only for the selected event
			- Event is marked as edited by an edit icon*/
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 hp.goToCalendarPage();
		 cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON_ONLY_EVENT.replace("$name",titleEvent2));
		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Edit other event from the series
		*Input Data: 
			
		*Expected Outcome: 
			- Popup to edit event is shown
			- Repeat details are not changed*/ 
		  info("Edit an event");
		  hp.goToCalendarPage();
	 	  cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Mon");
	 	  Utils.pause(2000);
	 	  waitForAndGetElement(cMang.ELEMENT_IS_REPEAT_CHECKBOX_CHECKED,2000,1);
	 	  evMg.cancelAddEditDetailEvent();
	 	  cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115897.</li>
	*<li> Test Case Name: Series should be cancelled after uncheck of Repeat icon.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test21_SeriesShouldBeCancelledAfterUncheckOfRepeatIcon() {
		info("Test 21 Series should be cancelled after uncheck of Repeat icon");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.MONTH, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.MONTH, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed
			- The icon "Repeat" is checked*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Uncheck the icon "Repeat"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"
			- The option "Only this Event" is selcted by Default*/
		info("Edit an recurring event 1");
		String titleEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 hp.goToCalendarPage();
		 cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2,null);
		uncheck(cMang.ELEMENT_IS_REPEAT_CHECKBOX, 2);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Choose the Defeult option "Only this Event"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- Series is cancelled
			- Only the edited instance (event) remains*/ 
		 hp.goToCalendarPage();
		info("Verify that Only the edited instance (event) remains");
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent, "Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent, "Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115898.</li>
	*<li> Test Case Name: Edited recurring event should remains after uncheck of Repeat icon.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test22_EditedRecurringEventShouldRemainsAfterUncheckOfRepeatIcon() {
		info("Test 22 Edited recurring event should remains after uncheck of Repeat icon");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
		String numberRepeatEdit="2";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed
			- The icon "Repeat" is checked*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit the repeat option
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"
			- The option "Only this Event" is selcted by Default*/
		String titleEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Mon");
		evMg.inputBasicDetailEvent(titleEvent1, contentEvent1);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeatEdit);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);

		

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Choose the Defeult option "Only this Event"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- Changes are restricted to the edited recurring event*/
		info("A repeat event is created successfully");
		 hp.goToCalendarPage();
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent1,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent1,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent1,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent1,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent1,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Edit other event from the series
			- Uncheck the icon"Repeat" 
			- Click "Save"
			- Choose "Only this event" option
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- The series is cancelled
			- The edited recurring event remains
			- The edited instance remains*/ 
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Tue");
		evMg.inputBasicDetailEvent(titleEvent2, contentEvent2);
		uncheck(cMang.ELEMENT_IS_REPEAT_CHECKBOX, 2);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		 hp.goToCalendarPage();
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent1,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115899.</li>
	*<li> Test Case Name: Event after edition by "Following events" option.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test23_EventAfterEditionByFollowingEventsOption() {
		info("Test 23 Event after edition by Following events option");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series (not the first event)
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events ( Title, Time..)
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Choose the option "Following events"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- The selected event and following events of the series will be changed. Any changes to the future events are lost.
			- Changes are not applied for the previous events*/ 
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2, contentEvent2);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.FOLLOW_EVENT);
		 hp.goToCalendarPage();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115900.</li>
	*<li> Test Case Name: Edit previous events after edition by "Following events" option.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test24_EditPreviousEventsAfterEditionByFollowingEventsOption() {
		info("Test 24 Edit previous events after edition by Following events option");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series (not the first event)
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Edit Recurring event" is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events ( Title, Time..)
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Choose the option "Following events"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- Changes are performedfor selected and following events of the current instance
			- Changes are not applied for the previous events*/
		
		String titleEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(titleEvent2, contentEvent2);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.FOLLOW_EVENT);
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
	
		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Edit a first event from the previous series
			- Edit details in recurring event
			- Save
			- Choose "Following events" option
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Changes are applied only on previous events
			- Two separately series are displayed*/ 
		
		String titleEvent3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Mon");
		evMg.inputBasicDetailEvent(titleEvent3, contentEvent3);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.FOLLOW_EVENT);
		
		info("A repeat event is created successfully");
		 hp.goToCalendarPage();
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent3,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent3,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent2,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);


 	}

	/**
	*<li> Case ID:115901.</li>
	*<li> Test Case Name: Event after edition by "All events" option.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test25_EventAfterEditionByAllEventsOption() {
		info("Test 25 Event after edition by All events option");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit an even from the series
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Add/Edit Event" is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Edit details of recurring events ( Title, Time..)
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- A confirmation pop up is displayed to ask user: "Would you like to change only this event, all events in the series, or this and all following events in the series?"
			- The option "Only this Event" is selcted by Default*/
		

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Choose the option "All events"
			- Click "Save"
		*Input Data: 
			
		*Expected Outcome: 
			- Changes are performed for all events
			- Event is marked as edited by an icon*/
		String titleEvent3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Mon");
		evMg.inputBasicDetailEvent(titleEvent3, contentEvent3);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent3,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent3,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent3,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent3,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent3,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115902.</li>
	*<li> Test Case Name: Event after a drag and drop.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test26_EventAfterADragAndDrop() {
		info("Test 26 Event after a drag and drop");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		//cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		//cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.goToView(selectViewOption.WEEK);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Drag and drop an event from the series, Select only this event. Save
		*Input Data: 
			
		*Expected Outcome: 
			- Start and End dates and times of event are updated
			- Event is marked as 'edited' by an icon with tooltip.*/
		cHome.goToView(selectViewOption.MONTH);
		dragAndDropToObject(cMang.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$date",getFirstDayOfWeek("MMM dd yyyy")).replace("$name",titleEvent),
					cHome.ELEMENT_EVENT_TASK_MONTH_DATE.replace("$date",getLastDayOfWeek("MMM dd yyyy")));
		waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON_ONLY_EVENT.replace("$name",titleEvent));
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Move the mouse over the icon
		*Input Data: 
			
		*Expected Outcome: 
			A tooltip is displayed "edited recurring event"*/
		 mouseOver(cMang.ELEMENT_TASK_EVENT_RECURRING_ICON_ONLY_EVENT.replace("$name",titleEvent),true);
         Utils.pause(2000);
         waitForAndGetElement(cMang.ELEMENT_TASK_EVENT_RECURRING_POPOVER_CONTENT_EDIT);

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Edit the current event
		*Input Data: 
			
		*Expected Outcome: 
			The "Repeat" field is not checked"*/ 
         info("Edit an event");
         hp.goToCalendarPage();
         cHome.goToView(selectViewOption.WEEK);
  		cMang.openEditEventTaskPopup(titleEvent,selectViewOption.WEEK,"Mon");
  		waitForElementNotPresent(cMang.ELEMENT_IS_REPEAT_CHECKBOX_CHECKED);
  		evMg.cancelAddEditDetailEvent();
  		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115903.</li>
	*<li> Test Case Name: Delete only a current recurring event.</li>
	*<li> Pre-Condition: A recurring events is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test27_DeleteOnlyACurrentRecurringEvent() {
		info("Test 27 Delete only a current recurring event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			- A recurring events is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Right click on event from the series
			- Choose the option "Delete"
		*Input Data: 
			
		*Expected Outcome: 
			- A pop upis displayed with:
			* A title: "Delete Recurring Event"
			* * A message: Would you like to delete only this event, all events in the series, or this and all following events in the series?* The option 'Only this event" is selected by default* A button "Delete"*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Choose the default option "Only this event"
			- Click "Delete"
		*Input Data: 
			
		*Expected Outcome: 
			- Only current event is deleted from the series*/ 
		evMg.deleteRecurringEvent(titleEvent, selectViewOption.WEEK,selectDayOption.DETAILTIME,recurringType.ONLY_EVENT,"Mon");
		 hp.goToCalendarPage();
		 cHome.goToView(selectViewOption.WEEK);
		info("Verify the events");
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115904.</li>
	*<li> Test Case Name: Delete following events.</li>
	*<li> Pre-Condition: A recyrring events is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test28_DeleteFollowingEvents() {
		info("Test 28 Delete following events");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			- A recurring events is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Right click on event from the series
			- Choose the option "Delete"
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop up is displayed with:<br>* A title: "Delete Recurring Event"<br>* A message: Would you like to delete only this event, all events in the series, or this and all following events in the series?<br>* The option 'Only this event" is selected by default<br>* A button "Delete"</p>*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Choose the default option "Following events"<br>
			- Click "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- All following events are deleted from the series</p><p>
			- Previous events still displayed</p>*/ 
		
		evMg.deleteRecurringEvent(titleEvent, selectViewOption.WEEK,selectDayOption.DETAILTIME,recurringType.FOLLOW_EVENT,"Wed");
		info("Verify the events");
		 hp.goToCalendarPage();
		/*cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);*/
		cHome.goToView(selectViewOption.WEEK);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115905.</li>
	*<li> Test Case Name: Delete all events.</li>
	*<li> Pre-Condition: A recyrring events is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test29_DeleteAllEvents() {
		info("Test 29 Delete all events");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			- A recurring events is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Right click on event from the series
			- Choose the option "Delete"
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A pop up is displayed with:<br>+ Title: "Delete Recurring Event"<br>+ Message: Would you like to delete only this event, all events in the series, or this and all following events in the series?<br>+ The option 'Only this event" is selected by default<br>+ A button "Delete"</p>*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Choose the default option "All events"<br>
			- Click "Delete"</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- All events are deletes</p><p>
			- Series no longer exists</p>*/ 
		evMg.deleteRecurringEvent(titleEvent, selectViewOption.WEEK,selectDayOption.DETAILTIME,recurringType.ALL_EVENT,"Wed");
		info("A repeat event is deleted successfully");
		 hp.goToCalendarPage();
		/*cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);*/
		cHome.goToView(selectViewOption.WEEK);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115906.</li>
	*<li> Test Case Name: Delete recurring event should be closed after cancel.</li>
	*<li> Pre-Condition: A recurring event is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test30_DeleteRecurringEventShouldBeClosedAfterCancel() {
		info("Test 30 Delete recurring event should be closed after cancel");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Choose Calendar application
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar is displayed
			- A recurring event is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Create recurring event");
        String numberRepeat="5";
        String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String contentEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        evMg.goToAddEventFromActionBar();
        evMg.moreDetailsEvent();
        evMg.inputDataEventInDetailForm(titleEvent,contentEvent,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
        evMg.openRecurringForm();
        evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Right click on event from the series
			- Click Delete
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Delete Recurring event" is displayed
			- The button "Cancel is displayed"*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Click on Cancel
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "delete Recurring event" is Close
			- The event is not deleted*/ 
		cHome.goToView(selectViewOption.MONTH);
		cMang.rightClickEventTaskInMonth(titleEvent, getCurrentDate("MMM dd yyyy"));
		cMang.selectOptionByRightclickOnEvent(contextMenuEditEvenOption.DELETE);
		evMg.cancelDeletingRecurringForm();
		
		info("Verify the events");
		 hp.goToCalendarPage();
		/*cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);*/
		cHome.goToView(selectViewOption.WEEK);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		cMang.deleteCalendar(calendar);
		

 	}}