package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.calendar.EventManagement.recurringType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatEndType;
import org.exoplatform.selenium.platform.calendar.EventManagement.repeatType;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Activity_Event_Activity_Display extends CAL_TestConfig{

	/**
	*<li> Case ID:116243.</li>
	*<li> Test Case Name: Display  calendar activity.</li>
	*<li> Pre-Condition: - Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DisplayCalendarActivity() {
		info("Test 1: Display  calendar activity");
		/*Step Number: 1
		*Step Name: Add an event
		*Step Description: 
			- Go to intranet, open a Space
			- Go to calendar application of that space
			- Add an event
		*Input Data: 
			
		*Expected Outcome: 
			Event is created*/
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,des);
		evMg.saveQuickAddEvent();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		/*Step number: 2
		*Step Name: Check calendar activity on space's activity
		*Step Description: 
			- Goto the space's activity stream
		*Input Data: 
			
		*Expected Outcome: 
			- An event activity has been published.
			- the summary is displayed as a link 
			- the description is displayed
			- Start date is displayed with format : Day of the week, Month, day of the month, year
			THEN start time
			- Location is displayed
			- The start date is shown*/
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE_SPACE_AS_LINK.replace("${space}",space.toLowerCase()).replace("${event}",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DESCRIPTION.replace("$name",newEvent).replace("$description", des));
		String dateText=getCurrentDate("EEEE, MMM dd, yyyy");
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DATE.replace("$name",newEvent).replace("$date",dateText));
		waitForAndGetElement(hpAct. ELEMENT_ACTIVITY_TASK_EVENT_LOCATION.replace("$name",newEvent));
		
		/*Step number: 3
		*Step Name: Check calendar activity on intranet's activity stream
		*Step Description: 
			- Goto the intranet's activity stream
		*Input Data: 
			
		*Expected Outcome: 
			- An event activity has been published.
			- the summary is displayed as a link 
			- the description is displayed
			- Start date is displayed with format : Day of the week, Month, day of the month, yearTHEN start time
			- Location is displayed
			- The start date is shown*/ 
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE_SPACE_AS_LINK.replace("${space}",space.toLowerCase()).replace("${event}",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DESCRIPTION.replace("$name",newEvent).replace("$description", des));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DATE.replace("$name",newEvent).replace("$date",dateText));
		waitForAndGetElement(hpAct. ELEMENT_ACTIVITY_TASK_EVENT_LOCATION.replace("$name",newEvent));
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
	}

	/**
	*<li> Case ID:116248.</li>
	*<li> Test Case Name: Display (all day) near the date for all-day events.</li>
	*<li> Pre-Condition: - Create a space with calendar app
	- Create an event in space calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DisplayNearTheDateForAlldayEvents() {
		info("Test 2: Display (all day) near the date for all-day events");
		/*Step Number: 1
		*Step Name: Change an event to an all day event
		*Step Description: 
			- Connect to intranet
			- Open calendar application
			- Double click a space calendar's event
			- Check [All day] checkbox
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Activity in the space stream is updated
			-"(all day)" is displayed near the date*/ 
		
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String dateText=getCurrentDate("MMM dd yyyy");
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(newEvent, des, "","",true);
		evMg.saveQuickAddEvent();
		info("Add task successfully");
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY.replace("$date",dateText).replace("$name",newEvent));
		
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}

	/**
	*<li> Case ID:116249.</li>
	*<li> Test Case Name: Display a Date for an added event.</li>
	*<li> Pre-Condition: Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATE: BECAUSE CANNOT CHANGE LANGUE OF MACHINE 
	*/
	@Test(groups="pending")
	public  void test03_DisplayADateForAnAddedEvent() {
		info("Test 3: Display a Date for an added event");
		/*Step Number: 1
		*Step Name: Create an event in a space calendar
		*Step Description: 
			- Connect to Intranet
			- Open a calendar application
			- Create an eventin a space calendar
		*Input Data: 
			
		*Expected Outcome: 
			- Event is created
			- An activity of event is displayed in the stream*/
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,des);
		evMg.saveQuickAddEvent();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		/*Step number: 2
		*Step Name: Change language to French
		*Step Description: 
			- Click on username on the right of top navigation,Click [Change language] 
			- Click [French]
			- Click [Save]
			- Go to intranet home page
		*Input Data: 
			
		*Expected Outcome: 
			- Language is changed to French
			- The date is displayed with the following format:"Day of the week""Month of the year"",""Year" 
			For example: Lundi 22 Février 2013*/

		/*Step number: 3
		*Step Name: Change start date of the event
		*Step Description: 
			- Double click that event 
			- Change start date field 
			- Click [Enregistrer]
		*Input Data: 
			
		*Expected Outcome: 
			- In the comment related to start date update, the date has the following format :"Day of the week""Month of the year"",""Year" For example: Lundi 22 Février 2013*/

		/*Step number: 4
		*Step Name: Change the language to English
		*Step Description: 
			- Click onusername on the right of top navigation,Click [Changer de langue] 
			- Click [English]
			- Click [Appliquer]
		*Input Data: 
			
		*Expected Outcome: 
			- The date is displayed in the activity content with the following format:"Day of the week""Month of the year"",""Year" For example: Monday, February 22, 2013*/ 
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}

	/**
	*<li> Case ID:116250.</li>
	*<li> Test Case Name: Display a Time for an added event.</li>
	*<li> Pre-Condition: Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATE: BECAUSE CANNOT CHANGE LANGUE OF MACHINE 
	*/
	@Test(groups="pending")
	public  void test04_DisplayATimeForAnAddedEvent() {
		info("Test 4: Display a Time for an added event");
		/*Step Number: 1
		*Step Name: Create an event in a space calendar
		*Step Description: 
			- Connect to Intranet
			- Open a calendar application
			- Create an eventin a space's calendar
		*Input Data: 
			
		*Expected Outcome: 
			- An event is created
			- An activity of event is displayed in the stream*/

		/*Step number: 2
		*Step Name: Change language to French
		*Step Description: 
			- Click onusername on the right of top navigation,Click [Changer de langue] 
			- Click [French]
			- Click [Save]
			- Go to intranet home page
		*Input Data: 
			
		*Expected Outcome: 
			- Language is changed to French
			- The time of activity is displayed in this format: HH:MM*/

		/*Step number: 3
		*Step Name: Change start time of the event
		*Step Description: 
			- Double click on that event, 
			- Change Start time field 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The activity is displaying a comment for start time update
			- The time of activity displayed format is HH:MM*/

		/*Step number: 4
		*Step Name: Change the language to English
		*Step Description: 
			- Click onusername on the right of top navigation,Click [Changer de langue] 
			- Click [English]
			- Click [Appliquer]
		*Input Data: 
			
		*Expected Outcome: 
			- The time of activity is displayed in this format: HH:MM PM for both activity content and activity comments*/ 
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}

	/**
	*<li> Case ID:116251.</li>
	*<li> Test Case Name: Display activity after create a repeated event.</li>
	*<li> Pre-Condition: Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_DisplayActivityAfterCreateARepeatedEvent() {
		info("Test 5: Display activity after create a repeated event");
		/*Step Number: 1
		*Step Name: Open Add/Edit event form
		*Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Click [Event] button in action bar
		*Input Data: 
			
		*Expected Outcome: 
			Form "Add/Event" is opened*/

		/*Step number: 2
		*Step Name: Show activity after creating a repeated event
		*Step Description: 
			- Input into fields
			- Click [More Details]
			- Click on [Repeat], input into fields
			- Select a space's calendar for [Calendar] field
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A new activity is created in the activity stream 
			- A content of event is displayed in the activity*/ 

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
		
		info("Verify results");
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}

	/**
	*<li> Case ID:116252.</li>
	*<li> Test Case Name: Display activity after edit one instance of a repeated event.</li>
	*<li> Pre-Condition: Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_DisplayActivityAfterEditOneInstanceOfARepeatedEvent() {
		info("Test 6: Display activity after edit one instance of a repeated event");
		/*Step Number: 1
		*Step Name: Add a repeated event
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
			- Some instances of an event are shown on a space's calendar,
			- A activity is shown activity stream of intranet, space*/
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
		
		info("A activity is shown activity stream of intranet, space");
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		/*Step number: 2
		*Step Name: Edit an instance of a repeated event
		*Step Description: 
			- Double click an instance of a repeated event , 
			- Input into fields, 
			- Click [Save] 
			- Click [Only this instance]
		*Input Data: 
			
		*Expected Outcome: 
			- A new activity is created in the activity stream of intranet, space
			- A content of event is displayed in the activity*/ 
		String newEvent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cMang.openEditEventTaskPopup(newEvent,"1");
		evMg.inputBasicDetailEvent(newEvent2,newEvent2);
		evMg.saveAddEventDetails();
		evMg.editRecurringEvent(recurringType.ONLY_EVENT);
		info("Verify that an activity for the exception event is created");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent2));
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
	}

	/**
	*<li> Case ID:116253.</li>
	*<li> Test Case Name: Display an event image.</li>
	*<li> Pre-Condition: Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_DisplayAnEventImage() {
		info("Test 7: Display an event image");
		/*Step Number: 1
		*Step Name: Show an event image
		*Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Create an eventin a space
		*Input Data: 
			
		*Expected Outcome: 
			An activity is published.The start date is displayed in a small image, as an illustration*/ 
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String month = getCurrentMonthDayYear("MMM");
		String day = getCurrentMonthDayYear("dd");
		info("day:"+day);
		info("month:"+month);
		
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,des);
		evMg.saveQuickAddEvent();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_MONTH.replace("${name}", newEvent).replace("${month}",month));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_DAY.replace("${name}", newEvent).replace("${day}",day));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_MONTH.replace("${name}", newEvent).replace("${month}",month));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_START_DATE_DAY.replace("${name}", newEvent).replace("${day}",day));
		
		
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}

	/**
	*<li> Case ID:116254.</li>
	*<li> Test Case Name: Don't display Location and Description if they are empty.</li>
	*<li> Pre-Condition: - Create a space with calendar application
	- Create an event in space calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_DontDisplayLocationAndDescriptionIfTheyAreEmpty() {
		info("Test 8: Don't display Location and Description if they are empty");
		/*Step Number: 1
		*Step Name: Connect to intranet
		*Step Description: 
			- Connect to intranet
			- Open calendar application
		*Input Data: 
			
		*Expected Outcome: 
			Calendar application is openned*/
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,des);
		evMg.saveQuickAddEvent();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		/*Step number: 2
		*Step Name: Not show description
		*Step Description: 
			- Double click an event of space calendar, 
			- Set [Description] field to blank, 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The activity in the stream is updated. Description is not displayed*/

		Utils.pause(2000);
		cMang.openEditEventTaskPopup(newEvent);
		evMg.inputBasicDetailEvent(null,"");
		evMg.saveAddEventDetails();
		
		info("Edit successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		
		/*Step number: 3
		*Step Name: Not show location
		*Step Description: 
			- Double click the event of space calendar, 
			- Set [Location] field to blank, 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The activity in the stream is updated, Neither location and Description are displayed*/
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DESCRIPTION.replace("$name",newEvent).replace("$description",des));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_LOCATION.replace("$name",newEvent));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DESCRIPTION.replace("$name",newEvent).replace("$description",des));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_LOCATION.replace("$name",newEvent));
		
		/*Step number: 4
		*Step Name: Not show location, show description
		*Step Description: 
			- Double click the event of space calendar
			- Set a value XXX for [Description] field, 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			the activity in the stream is updated. The Location is not displayed, the Description is XXX*/ 
		Utils.pause(2000);
		String des1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent);
		evMg.inputBasicDetailEvent(null,des1);
		evMg.saveAddEventDetails();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DESCRIPTION.replace("$name",newEvent).replace("$description",des1));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_LOCATION.replace("$name",newEvent));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_DESCRIPTION.replace("$name",newEvent).replace("$description",des1));
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_LOCATION.replace("$name",newEvent));
		
		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}}