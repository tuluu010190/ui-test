package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.EventManagement.recurringType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatEndType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatType;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Activity_Event_Activity_Recurring extends CAL_TestConfig{

	/**
	*<li> Case ID:115907.</li>
	*<li> Test Case Name: A comment to event activity should be added after adding a repeat event.</li>
	*<li> Pre-Condition: * Event should be in group calendars for spaces* 
	*An event is displayed in Calendar* 
	*An activity event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ACommentToEventActivityShouldBeAddedAfterAddingARepeatEvent() {
		info("Test 1: A comment to event activity should be added after adding a repeat event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			- An event is displayed*/
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String firstDay=getFirstDayOfWeek("MM/dd/yyyy");
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,des);
		evMg.inputFromToQuickEvent(firstDay, firstDay,false);
		evMg.saveQuickAddEvent();
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit the event
			-Click "More details"
			- Check "Repeat" option
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is added</p>*/
        String numberRepeat="5";
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent,selectViewOption.LIST);
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeat);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();

		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream, a comment is added to the main activity event: 
			"Event will be repeated $REPETITION"where $REPETITION : strong format of the recurring settings 
			(e.g : every week on Wednesday)</p>*/ 
		String comment = cCommentData.getContentByIndex(0);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${number}", numberRepeat));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${number}", numberRepeat));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}

	/**
	*<li> Case ID:115908.</li>
	*<li> Test Case Name: A comment to event activity should be added after editing repeat option.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- A recurring event is displayed in Calendar
	- An activity event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_ACommentToEventActivityShouldBeAddedAfterEditingRepeatOption() {
		info("Test 2: A comment to event activity should be added after editing repeat option");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is displayed</p>*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String firstDay=getFirstDayOfWeek("MM/dd/yyyy");
		String numberRepeat="2";
		String numberRepeatEdit="5";
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
				
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Edit an event from the series</p><p>
			- Edit Repeat option</p><p>
			- Click Save</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is edited</p>*/

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent,selectViewOption.WEEK,"Mon");
		evMg.openRecurringForm();
		evMg.inputRecurringInfoEvent(repeatType.Daily,"1",null,repeatEndType.After,numberRepeatEdit);
		evMg.saveRecurringForm();
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);

		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream, a comment is added to the main activity event: "Event will be repeated $REPETITION"<br>where $REPETITION : strong format of the recurring settings (e.g : every week on Wednesday)</p>*/ 
		String comment = cCommentData.getContentByIndex(0);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${number}", numberRepeatEdit));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${number}", numberRepeatEdit));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}

	/**
	*<li> Case ID:115909.</li>
	*<li> Test Case Name: An activity should displayed after editing only an event.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- A recurring event is displayed in Calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_AnActivityShouldDisplayedAfterEditingOnlyAnEvent() {
		info("Test 3: An activity should displayed after editing only an event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is displayed</p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Edit an event from the series</p><p>
			- From the popup "Edit recurring event", choose "Only this event"</p><p>
			- Click Save</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- only current event is edited</p>*/
		info("Edit an recurring event");
		String newEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(newEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent2,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent2,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent2,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent2,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A new activity is created for the recurring event</p>*/ 
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent2));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent2));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
		cMang.deleteTaskEvent(newEvent2);
 	}

	/**
	*<li> Case ID:115910.</li>
	*<li> Test Case Name: An activity should displayed after drag and drop an event.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- A recurring event is displayed in Calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_AnActivityShouldDisplayedAfterDragAndDropAnEvent() {
		info("Test 4: An activity should displayed after drag and drop an event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is displayed</p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Drag and drop an event from the series</p><p>
			- Click Save</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- Starts and End time are edited</p>*/
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cHome.goToView(selectViewOption.WEEK);
		dragAndDropToObject(By.xpath(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$name",newEvent).replace("$date","Wed")),By.xpath(cHome.ELEMENT_ANY_TARGET_DATE.replace("${targetDate}","Tue")));

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A new activity is created for the recurring event</p>*/
		String firstDayFormat=getFirstDayOfWeek("MMM/dd/yyyy");
		String[] date= firstDayFormat.split("/");
		String month=date[0];
		String day = Integer.toString(Integer.parseInt(date[1]+1));
		info("day:"+day);
		info("month:"+month);
		
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_MONTH.replace("${name}", newEvent).replace("${month}",month));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_DAY.replace("${name}", newEvent).replace("${day}",day));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_MONTH.replace("${name}", newEvent).replace("${month}",month));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_DAY.replace("${name}", newEvent).replace("${day}",day));
		

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}

	/**
	*<li> Case ID:115911.</li>
	*<li> Test Case Name: An activity should displayed after adding a recurring event.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_AnActivityShouldDisplayedAfterAddingARecurringEvent() {
		info("Test 5: An activity should displayed after adding a recurring event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open "Calendar" application</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The calendar application is displayed</p>*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Add an event</p><p>
			- Check the icon repeat</p><p>
			- Click Save</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is created</p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A new activity is created for the recurring event</p>*/ 
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}

	/**
	*<li> Case ID:115912.</li>
	*<li> Test Case Name: A comment to event activity should be added after editing All events.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- An event is displayed in Calendar
	- An activity event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_ACommentToEventActivityShouldBeAddedAfterEditingAllEvents() {
		info("Test 6: A comment to event activity should be added after editing All events");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			- An event is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit the event
			-Click "More details"
			- Check "Repeat" option
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is added</p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Edit event from the series</p><p>
			- Click Save</p><p>
			- Choose the option "All events", from the pop up " Edit recurring event"</p><p>
			- Click Save</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- All events are updated with changes</p>*/
		info("Edit an recurring event");
		String newEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(newEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ALL_EVENT);
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream, a comment is added to the main activity event<br>
			- The edit recurring activity is not edited</p>*/ 
		String comment = cCommentData.getContentByIndex(6);
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent2).replace("$comment", comment)
				.replace("${editText}",newEvent2));
		
		hp.goToHomePage();
		Utils.pause(2000);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent2).replace("$comment", comment)
				.replace("${editText}", newEvent2));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent2, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}

	/**
	*<li> Case ID:115913.</li>
	*<li> Test Case Name: Event activities should be updated after editing Following events.</li>
	*<li> Pre-Condition: an event is displayed in Calendar
	*An activity event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_EventActivitiesShouldBeUpdatedAfterEditingFollowingEvents() {
		info("Test 7: Event activities should be updated after editing Following events");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open "Calendar" application
		*Input Data: 
			
		*Expected Outcome: 
			- An event is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit the event
			-Click "More details"
			- Check "Repeat" option
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- A recurring event is added</p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Edit event from the series ( not the first event)</p><p>
			- Click Save</p><p>
			- Choose the option "Following events", from the pop up " Edit recurring event"</p><p>
			- Click Save</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- Two separately series are displayed</p><p><br></p>*/

		info("Edit an recurring event");
		String newEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(newEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.FOLLOW_EVENT);
		
		info("A repeat event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent2,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent2,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent2,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream:
			a new event activity is created for the starting event of the new series
			A comment is added to the main activity of the previous series :
			Event will stop repeating on $LAST_EVENT_DATE 
			Where $LAST_EVENT_DATE : the date of the last event in the series*/ 
		String comment = cCommentData.getContentByIndex(7);
		String dateText="Tuesday";
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent2).replace("$comment", comment)
				.replace("${date}",dateText));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}",dateText));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent2).replace("$comment", comment)
				.replace("${date}",dateText));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}", dateText));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
		evMg.deleteRecurringEvent(newEvent2, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Wed");
 	}

	/**
	*<li> Case ID:115914.</li>
	*<li> Test Case Name: Activities should be updated after delete of an edited recurring event.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- An edited recurring event is displayed, edited by drag & drop or by only this event option
	- An activity of edited recurring event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_ActivitiesShouldBeUpdatedAfterDeleteOfAnEditedRecurringEvent() {
		info("Test 8: Activities should be updated after delete of an edited recurring event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open "Calendar" application</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The calendar application is displayed
			- An edited recurring event is displayed*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		info("Edit an recurring event");
		String newEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent,selectViewOption.WEEK,"Wed");
		evMg.inputBasicDetailEvent(newEvent2,null);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Right click on the edited recurring event</p><p>
			- Click Delete</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The edited recurring event is deleted</p>*/
		info("Delete edited recurring event");
		cMang.deleteTaskEvent(newEvent2);
		info("Verify that edited recurring event is deleted and remainning event is avaiable");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent, "Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent, "Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent2,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream:
			Activity of the edited recurring event is
			A comment is added to the main activity (of series):
			Event cancelled for $CANCEL_DATE where $CANCEL_DATE : the date of the event removed*/ 
		String comment = cCommentData.getContentByIndex(8);
		String dateText="Wednesday";
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}",dateText));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}", dateText));
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}

	/**
	*<li> Case ID:115915.</li>
	*<li> Test Case Name: A comment to event activity should be added after delete only one recurring event.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- A recurring event is displayed in the Calendar
	- An activity recurring event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_ACommentToEventActivityShouldBeAddedAfterDeleteOnlyOneRecurringEvent() {
		info("Test 9: A comment to event activity should be added after delete only one recurring event");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open "Calendar" application</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The calendar application is displayed</p><p>
			- An edited recurring event is displayed&nbsp;</p><p><br></p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Right click on an event from the series</p><p>
			- Click Delete</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The Delete pop up is displayed</p>*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Choose "Only this event"</p><p>
			- Click on Delete</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The current event is deleted from the series</p>*/

		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK, selectDayOption.ONEDAY,recurringType.ONLY_EVENT,"Wed");
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream:
			A comment is added to the main activity (of series):
			Event cancelled for $CANCEL_DATE where $CANCEL_DATE : the date of the event removed*/ 
		String comment = cCommentData.getContentByIndex(8);
		String dateText="Wednesday";
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}",dateText));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}", dateText));
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}

	/**
	*<li> Case ID:115916.</li>
	*<li> Test Case Name: Activity of recurring event should be deleted after delete all events.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- A recurring event is displayed in the Calendar
	- An activity recurring event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_ActivityOfRecurringEventShouldBeDeletedAfterDeleteAllEvents() {
		info("Test 10 Activity of recurring event should be deleted after delete all events");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open "Calendar" application</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The calendar application is displayed</p><p>
			- An edited recurring event is displayed&nbsp;</p><p><br></p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Right click on an event from the series</p><p>
			- Click Delete</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The Delete pop up is displayed</p>*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			<p>
			- Choose "All events" option</p><p>
			- Click on Delete</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- All events of the series are deleted</p>*/
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK, selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Wed");
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream, recurring event activity is deleted</p>*/ 
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent));
		
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name", newEvent));
 	}

	/**
	*<li> Case ID:115917.</li>
	*<li> Test Case Name: Activities should be updated after delete of Folllowing events.</li>
	*<li> Pre-Condition: - Event should be in group calendars for spaces
	- An edited recurring event is displayed
	- An activity of edited recurring event is displayed in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_ActivitiesShouldBeUpdatedAfterDeleteOfFolllowingEvents() {
		info("Test 11 Activities should be updated after delete of Folllowing events");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			<p>
			- Connect to Intranet<br>
			- Open "Calendar" application</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- The calendar application is displayed</p><p>
			- An edited recurring event is displayed&nbsp;</p><p><br></p>*/
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
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			<p>
			- Right click on an event</p><p>
			- Click Delete</p><p>
			- Choose "Following Events"</p><p>
			- Click Save</p>
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- Following events are deleted</p>*/
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK, selectDayOption.ONEDAY,recurringType.FOLLOW_EVENT,"Wed");
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Mon", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsPresentEventTaskWithDateTime(newEvent,"Tue", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Wed", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Thu", selectViewOption.WEEK, selectDayOption.ONEDAY);
		cHome.verifyIsNotPresentEventTaskWithDateTime(newEvent,"Fri", selectViewOption.WEEK, selectDayOption.ONEDAY);
		
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			<p>
			- In the activity stream:
			activities for future edited recurring events of the series is deleted
			A comment is added to the main activity (of series):
			Event will stop repeating on $LAST_EVENT_DATE where $LAST_EVENT_DATE : 
			the date of the last event in the series*/ 
		String comment = cCommentData.getContentByIndex(7);
		String dateText="Tuesday";
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}",dateText));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent).replace("$comment", comment)
				.replace("${date}", dateText));
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.deleteRecurringEvent(newEvent, selectViewOption.WEEK,selectDayOption.ONEDAY,recurringType.ALL_EVENT,"Mon");
 	}}