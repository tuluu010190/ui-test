package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatEndType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatType;
import org.testng.annotations.*;


	public class CAL_Event_Repeat extends CAL_TestConfig_3{

	/**
	*<li> Case ID:116227.</li>
	*<li> Test Case Name: Check event with Monthly Repeat option (by day of week).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckEventWithMonthlyRepeatOption() {
		info("Test 1: Check event with Monthly Repeat option (by day of week)");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create a event
		*Input Data: 
			- Click on Add Event button on the 2nd Tuesday of the month
			- Input event info
			- Tick the checkbox Repeat
		*Expected Outcome: 
			The repeat popup is displayed*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Input repeat option
		*Input Data: 
			- Select Monthly Repeat option
			- Repeat every months
			- Select option "By day of week" and 
			- Click Save
		*Expected Outcome: 
			- The popup is closed
			- Next to Repeat field, the information displays : "Monthly on the second Tuesday"*/
        info("Add an event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(titleEvent, newContent, calendar);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Monthly,"1",null,repeatEndType.After,"2");
		evMg.selectRepeatByOption(false);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			Step 3: Create a event
		*Input Data: 
			- Click save
		*Expected Outcome: 
			Event is added successfully*/
		
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getCurrentDate("MMM dd yyyy"), 
				selectViewOption.MONTH,selectDayOption.ALLDAY);

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			Step 4: Check monthly repeat
		*Input Data: 
			- View the added event by day/ week/ month/year view
		*Expected Outcome: 
			The added event is repeated every month on the second Tuesday, with correct information and display*/ 
		info("Go to next month");
		cHome.nextDate(1);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getDayOfNextMonth("MMM dd yyyy",7,4), 
				selectViewOption.MONTH,selectDayOption.ALLDAY);
        cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116467.</li>
	*<li> Test Case Name: Check event with Daily Repeat option.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckEventWithDailyRepeatOption() {
		info("Test 2: Check event with Daily Repeat option");
		/*Step Number: 1
		*Step Name: Step 1: Create a event
		*Step Description: 
			- Click on Add Event button
			- Click [More Details_button]
			- Input info for the event
			- Tick "Repeat" option
		*Input Data: 
			
		*Expected Outcome: 
			The "Quick Add Event" form is shown.The "Add/Edit Event" form is shown.The "Recurring Event" form is shown.*/

		/*Step number: 2
		*Step Name: Step 2: Select Daily option for Repeat
		*Step Description: 
			- Select Daily from Repeat option.
			- Select the times of repeat every day and when end this repeat.
			- Click Save.
			- Enter info for the event in Details tab.
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			The added event is repeated daily with correct information is shown.*/ 
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
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116468.</li>
	*<li> Test Case Name: Check event with Weekly Repeat option.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckEventWithWeeklyRepeatOption() {
		info("Test 3: Check event with Weekly Repeat option");
		/*Step Number: 1
		*Step Name: Step 1: Create a event
		*Step Description: 
			- Click on Add Event button
			- Input event info
			- Select Weekly Repeat option
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Event is added successfully*/

		/*Step number: 2
		*Step Name: Step 2: Check Weekly repeat
		*Step Description: 
			- View the added event by day/ week/ month/year view
		*Input Data: 
			
		*Expected Outcome: 
			The added event is repeated weekly with correct information*/ 
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
		evMg.inputBasicDetailEvent(titleEvent, newContent, calendar);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Weekly,"1",null,repeatEndType.After,"2");
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getCurrentDate("MMM dd yyyy"), 
				selectViewOption.WEEK, selectDayOption.DETAILTIME);
		info("Go to next week");
		cHome.nextDate(1);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getDayOfNextWeek("MMM dd yyyy"), 
				selectViewOption.WEEK,selectDayOption.DETAILTIME);
        cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116469.</li>
	*<li> Test Case Name: Check event with Monthly Repeat option (by day of month).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CheckEventWithMonthlyRepeatOption() {
		info("Test 4: Check event with Monthly Repeat option (by day of month)");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create a event
		*Input Data: 
			- Click on Add Event button on the 2nd of the month
			- Input event info
			- Tick the checkbox Repeat
		*Expected Outcome: 
			The repeat popup is displayed*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Input repeat option
		*Input Data: 
			- Select Monthly Repeat option
			- Repeat every 2 months
			- Select option "By day of month" and 
			- Click Save
		*Expected Outcome: 
			- The popup is closed
			- Next to Repeat field, the information displays : "Every 2 months on the 2"*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			Step 3: Create a event
		*Input Data: 
			- Click save
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
		evMg.inputBasicDetailEvent(titleEvent, newContent, calendar);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Monthly,"2",null,repeatEndType.After,"2");
		evMg.selectRepeatByOption(true);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getCurrentDate("MMM dd yyyy"), 
				selectViewOption.MONTH,selectDayOption.ALLDAY);

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			Step 4: Check monthly repeat
		*Input Data: 
			- View the added event by day/ week/ month/year view
		*Expected Outcome: 
			The added event is repeated every 2 month on the 2, with correct information and display*/
		info("Go to next month");
		cHome.nextDate(2);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getDayOfNextMonth("MMM dd yyyy",getDayOfWeek(0),8), 
				selectViewOption.MONTH,selectDayOption.ALLDAY);
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116470.</li>
	*<li> Test Case Name: Check event with Yearly Repeat option.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_CheckEventWithYearlyRepeatOption() {
		info("Test 5: Check event with Yearly Repeat option");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create a event
		*Input Data: 
			- Click on Add Event button
			- Input event info
			- Select Yearly Repeat option
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
		evMg.inputBasicDetailEvent(titleEvent, newContent, calendar);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Yearly,"1",null,repeatEndType.After,"2");
		evMg.selectRepeatByOption(true);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getCurrentDate("MMM dd yyyy"), 
				selectViewOption.MONTH,selectDayOption.ALLDAY);

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Check yearly repeat
		*Input Data: 
			- View the added event by day/ week/ month/year view
		*Expected Outcome: 
			The added event is repeated yearly with correct information*/ 
		info("Go to next month");
		cHome.nextDate(12);
		cHome.verifyIsPresentEventTaskWithDateTime(titleEvent,getDayOfNextYear("MMM dd yyyy",0), 
				selectViewOption.MONTH,selectDayOption.ALLDAY);
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116471.</li>
	*<li> Test Case Name: Edit event by click on rollover pop up.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_EditEventByClickOnRolloverPopUp() {
		info("Test 6: Edit event by click on rollover pop up");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			Step 1: Add event
		*Input Data: 
			- Click on Add Event button
			- Input event info
			- Select Daily Repeat option
			- Click Save
		*Expected Outcome: 
			Event is added successfully*/
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
		*Step Name: -
		*Step Description: 
			Step 2: Check daily repeat
		*Input Data: 
			- View the added event by day/ week/ month/year view
		*Expected Outcome: 
			The added event is repeated daily with correct information*/ 
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.DAY,selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.LIST,selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.MONTH,selectDayOption.ALLDAY);
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.WORKWEEK,selectDayOption.DETAILTIME);
		cMang.deleteCalendar(calendar);

 	}}