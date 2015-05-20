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
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		String newEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		String tabWeek=cTabData.getTabNameByIndex(1);
		cMang.goToTab(tabWeek);
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(newEvent,newEvent,space);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,"5");
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","1"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","2"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","3"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","4"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","5"));
		waitForElementNotPresent(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","6"));
		
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
		cMang.openEditEventTaskPopup(newEvent,"1");
		evMg.inputBasicDetailEvent(newEvent2,newEvent2);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
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
		
		String dateText =getDate(1,"MMM dd yyyy");
        hp.goToCalendarPage();
        evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT, dateText);
        info("Verify that The event is deleted from the activity stream.There is no impact for activity created for exception event.");
	    hp.goToHomePage();
	    waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
 
	    info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
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
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		String newEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		String tabWeek=cTabData.getTabNameByIndex(1);
		cMang.goToTab(tabWeek);
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		evMg.inputBasicDetailEvent(newEvent,newEvent,space);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,"5");
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		
		info("A repeat event is created successfully");
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","1"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","2"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","3"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","4"));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","5"));
		waitForElementNotPresent(cMang.ELEMENT_EVENT_TASK_NUMBER_RECURRING.replace("${name}",newEvent).replace("${number}","6"));
		
		/*Step number: 2
		*Step Name: Delete all instances
		*Step Description: 
			- Delete all instance of a repeated event
		*Input Data: 
			
		*Expected Outcome: 
			- The activity related to the event is deleted*/ 
		String dateText =getCurrentDate("MMM dd yyyy");
        hp.goToCalendarPage();
        evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT, dateText);
	    info("Verify that The activity related to the event is deleted");
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
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
		spaMg.goToActivityStreamTab();
		hpAct.deleteActivity(newEvent);
		
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
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

		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}}