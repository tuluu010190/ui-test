package org.exoplatform.selenium.platform.calendar.functional;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.EventManagement.recurringType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatEndType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatType;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Activity_Event_Activity_Delete extends CAL_TestConfig{

	/**
	*<li> Case ID:116245.</li>
	*<li> Test Case Name: Delete event's activity after delete all instances of a repeated event with exception events created.</li>
	*<li> Pre-Condition: - Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DeleteEventsActivityAfterDeleteAllInstancesOfARepeatedEventWithExceptionEventsCreated() {
		info("Test 1: Delete event's activity after delete all instances of a repeated event with exception events created");
		/*Step Number: 1
		*Step Name: Create a repeat event
		*Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Click [Event] button in action bar
			- Input into fields
			- Click [More Details]
			- Click on [Repeat], input into fields
			- Select a space's calendar for [Calendar] field
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			A repeat event is created*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String firstDay=getFirstDayOfWeek("MM/dd/yyyy");
		String numberRepeat="5";
		info("create new space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		info("Create a recurring event");
		String newEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(newEvent,newEvent);
		evMg.inputFromToDetailEvent(firstDay, firstDay,false);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: Create an exception event
		*Step Description: 
			- Double click on an instance of a repeated event of space calendar
			- Input value into fields
			- Click [Save], then select [Only this instance]
		*Input Data: 
			
		*Expected Outcome: 
			- That instance become an exception event
			- An activity for this exception event is created*/
		String newEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.openEditEventTaskPopup(newEvent,selectViewOption.WEEK,"Mon");
		evMg.inputBasicDetailEvent(newEvent2,newEvent2);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		info("Verify that an activity for the exception event is created");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent2));
		
		/*Step number: 3
		*Step Name: Delete all instance
		*Step Description: 
			- Right click another instance of a repeated event (different from Exception event above), Select [Delete]
			- Click [All events in the series]
		*Input Data: 
			
		*Expected Outcome: 
			- The activity is deleted from the activity stream
			There is no impact for activity created for exception event.*/ 
		
        hp.goToSpecificSpace(space);
        spaMg.goToAgendaTab();
        evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.DETAILTIME,recurringType.ALL_EVENT,"Tue");
        cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        
        info("Verify that The event is deleted from the activity stream."
        		+ "There is no impact for activity created for exception event.");
        
        hp.goToSpecificSpace(space);
        spaMg.goToActivityStreamTab();
        waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
      
	    hp.goToHomePage();
	    waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
 
	    info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newEvent2);
	}

	/**
	*<li> Case ID:116246.</li>
	*<li> Test Case Name: Delete event's activity after delete all instances of a repeated event without exception events created.</li>
	*<li> Pre-Condition: - Create an event, with repeat for space calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DeleteEventsActivityAfterDeleteAllInstancesOfARepeatedEventWithoutExceptionEventsCreated() {
		info("Test 2: Delete event's activity after delete all instances of a repeated event without exception events created");
		/*Step Number: 1
		*Step Name: Create a repeat event
		*Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Click [Event] button in action bar
			- Input into fields
			- Click [More Details]
			- Click on [Repeat], input into fields
			- Select a space's calendar for [Calendar] field
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Arepeat event is created*/

		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String firstDay=getFirstDayOfWeek("MM/dd/yyyy");
		String numberRepeat="5";
		info("create new space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		info("Create a recurring event");
		String newEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(newEvent,newEvent);
		evMg.inputFromToDetailEvent(firstDay, firstDay,false);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
		
		/*Step number: 2
		*Step Name: Delete all instances
		*Step Description: 
			- Delete all instance of a repeated event
		*Input Data: 
			
		*Expected Outcome: 
			- The activity related to the event is deleted*/ 
	    hp.goToSpecificSpace(space);
        spaMg.goToAgendaTab();
        evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.DETAILTIME,recurringType.ALL_EVENT,"Mon");
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.DETAILTIME);
        
        info("The activity related to the event is deleted");
        
        hp.goToSpecificSpace(space);
        spaMg.goToActivityStreamTab();
        waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
      
	    hp.goToHomePage();
	    waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
	 
	}

	/**
	*<li> Case ID:116277.</li>
	*<li> Test Case Name: Delete a Calendar activity from activity stream by its owner.</li>
	*<li> Pre-Condition: - Create a space with calendar app
	- Create an event in a space calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_DeleteACalendarActivityFromActivityStreamByItsOwner() {
		info("Test 3: Delete a Calendar activity from activity stream by its owner");
		/*Step Number: 1
		*Step Name: Connect to Intranet
		*Step Description: 
			- Connect to Intranet
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar activity is displayed in the activity stream*/
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,newEvent);
		evMg.saveQuickAddEvent();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		/*Step number: 2
		*Step Name: Show X icon on activity
		*Step Description: 
			- Move the mouse over the Calendar activity
		*Input Data: 
			
		*Expected Outcome: 
			A (X) icon is displayed in the top right panel of the activity*/

		/*Step number: 3
		*Step Name: Delete activity
		*Step Description: 
			- Click on the (X) icon
			- Click [OK]
		*Input Data: 
			
		*Expected Outcome: 
			The Calendar activity is removed from the activity stream*/ 
		hp.goToHomePage();
		hpAct.deleteActivity(newEvent);
		
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
	    info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newEvent);
 	}

	/**
	*<li> Case ID:116278.</li>
	*<li> Test Case Name: Delete an event.</li>
	*<li> Pre-Condition: - Create a space with calendar application
	- Create an event in space calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_DeleteAnEvent() {
		info("Test 4: Delete an event");
		/*Step Number: 1
		*Step Name: Delete an event
		*Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Delete event of space calendar
		*Input Data: 
			
		*Expected Outcome: 
			- The event's activity is removed from the activity stream*/ 
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,newEvent);
		evMg.saveQuickAddEvent();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		cMang.deleteTaskEvent(newEvent);
		spaMg.goToActivityStreamTab();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
 	}}