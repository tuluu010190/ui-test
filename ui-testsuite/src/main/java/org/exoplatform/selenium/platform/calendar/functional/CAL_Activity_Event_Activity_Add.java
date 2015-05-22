package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Activity_Event_Activity_Add extends CAL_TestConfig {

	/**
	*<li> Case ID:116225.</li>
	*<li> Test Case Name: Not show activity for personal calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_NotShowActivityForPersonalCalendar() {
		info("Test 1: Not show activity for personal calendar");
		/*Step Number: 1
		*Step Name: Not show activity for an event of a personal calendar
		*Step Description: 
			- Connect to intranet
			-Open calendar application
			- In a personal calendar, add an event
		*Input Data: 
			
		*Expected Outcome: 
			No activity has been posted for that event*/ 
		String newEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		String tabWeek=cTabData.getTabNameByIndex(1);
		cMang.goToTab(tabWeek);
		cMang.executeActionCalendar(DATA_NAME_USER1,menuOfCalendarOption.ADDEVENT);
		evMg.inputBasicQuickEvent(newEvent,newEvent);
		evMg.saveQuickAddEvent();
		
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		info("Delete Data");
		hp.goToCalendarPage();
		cMang.deleteTaskEvent(newEvent);
 	}

	/**
	*<li> Case ID:116226.</li>
	*<li> Test Case Name: Not show activity for a group calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_NotShowActivityForAGroupCalendar() {
		info("Test 2: Not show activity for a group calendar");
		/*Step Number: 1
		*Step Name: Not show activity for an event of a group calendar
		*Step Description: 
			- Connect to intranet
			- Open calendar application
			- In a group calendar, add an event
		*Input Data: 
			
		*Expected Outcome: 
			No activity has been posted for that event*/ 
		String newEvent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupCal = cGroupData.getGroupNameByIndex(0);
		hp.goToCalendarPage();
		String tabWeek=cTabData.getTabNameByIndex(1);
		cMang.goToTab(tabWeek);
		cMang.executeActionCalendar(groupCal,menuOfCalendarOption.ADDEVENT);
		evMg.inputBasicQuickEvent(newEvent,newEvent);
		evMg.saveQuickAddEvent();
		
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		info("Delete Data");
		hp.goToCalendarPage();
		cMang.deleteTaskEvent(newEvent);
 	}

	/**
	*<li> Case ID:116255.</li>
	*<li> Test Case Name: Generate activity from Space Calendar.</li>
	*<li> Pre-Condition: Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_GenerateActivityFromSpaceCalendar() {
		info("Test 3: Generate activity from Space Calendar");
		/*Step Number: 1
		*Step Name: Create an event
		*Step Description: 
			- Connect to Intranet
			- Add an event in Calendar of a space
		*Input Data: 
			
		*Expected Outcome: 
			The event is created in a space's calendar*/

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
		
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		/*Step number: 2
		*Step Name: Check activity
		*Step Description: 
			- Go to Intranet Homepage or Space's activity
		*Input Data: 
			
		*Expected Outcome: 
			- An activity is displayed with the created event*/ 
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newEvent);
 	}

	/**
	*<li> Case ID:116256.</li>
	*<li> Test Case Name: Recreate activity after deletion.</li>
	*<li> Pre-Condition: - Create a space with calendar app
	- Add an event in a space calendar</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_RecreateActivityAfterDeletion() {
		info("Test 4: Recreate activity after deletion");
		/*Step Number: 1
		*Step Name: Connect to intranet
		*Step Description: 
			- Connect to intranet
		*Input Data: 
			
		*Expected Outcome: 
			Home page intranet is opened*/
		String newEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent,newEvent,space);
		evMg.saveQuickAddEvent();
        
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		
		/*Step number: 2
		*Step Name: Delete the activity
		*Step Description: 
			- Delete the activity by clicking on (x) in upper right corner of the activity
		*Input Data: 
			
		*Expected Outcome: 
			- the activity is removed from the activity stream*/
        hp.goToHomePage();
        hpAct.deleteActivity(newEvent);
        
		/*Step number: 3
		*Step Name: Edit an event
		*Step Description: 
			- Open calendar application
			- Double click on that Event 
			- Set a new [Description] field to "XXX" and [Location] field to "YYY"
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A new activity is created with:
			+ The same summary as previous+ 1 comment containing: 
			Description has been updated to XXXLocation has been updated to YYY*/ 
        String newEditEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToSpecificSpace(space);
        spaMg.goToAgendaTab();
        cMang.openEditEventTaskPopup(newEvent);
        evMg.inputBasicDetailEvent(null, newEditEvent);
        evMg.saveAddEventDetails();
        info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent),2000,1);
	    waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TOTAL_COMMENT_NUMBER.replace("${name}",newEvent).replace("${number}","1"));
	    waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT.replace("$name",newEvent).replace("$comment",newEditEvent));
	        
        hp.goToHomePage();
        waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent),2000,1);
        waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TOTAL_COMMENT_NUMBER.replace("${name}",newEvent).replace("${number}","1"));
        waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT.replace("$name",newEvent).replace("$comment",newEditEvent));
        
        info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newEvent);
 	}

	/**
	*<li> Case ID:116274.</li>
	*<li> Test Case Name: Not show activity for shared calendar.</li>
	*<li> Pre-Condition: - Create a space with calendar app.</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_NotShowActivityForSharedCalendar() {
		info("Test 5: Not show activity for shared calendar");
		/*Step Number: 1
		*Step Name: Connect to intranet
		*Step Description: 
			Connect to intranet by user1
		*Input Data: 
			
		*Expected Outcome: 
			Homepage Intranet is opened*/
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
		
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent));
		/*Step number: 2
		*Step Name: Share a calendar
		*Step Description: 
			- Open calendar application
			- Click on [Setting] icon of a personal calendar, select [Share]
			- Input valid users (ex: user2) into a field
			- Click [Add]
			- Check "Edit permission" field
			- Click [Save]
			- Connect to intranet by user2
		*Input Data: 
		
		*Expected Outcome: 
			- This calendar is share with user2
			- This calendar become a shared calendar of user2*/
		 String[] userGroup={DATA_USER2};
		 boolean[] canEdit={true};
         hp.goToCalendarPage();
 		 cMang.shareCalendar(DATA_NAME_USER1, userGroup,canEdit);
 		 
 		 magAc.signOut();
 		 magAc.signIn(DATA_USER2, DATA_PASS);
 		
 		 hp.goToCalendarPage();
 		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",DATA_NAME_USER1));
 		 
 		 hp.goToHomePage();
 		 waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		/*Step number: 3
		*Step Name: Not show activity for an event of a shared calendar
		*Step Description: 
			- Open calendar application
			- In a shared calendar, add an event
			- Go to Intranet home page, space's activity stream
		*Input Data: 
			
		*Expected Outcome: 
			No activity has been posted for that event*/ 
 		 magAc.signOut();
 		 magAc.signIn(DATA_USER1, DATA_PASS);
 		 
 	    String newEvent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		String tabWeek=cTabData.getTabNameByIndex(1);
		cMang.goToTab(tabWeek);
		cMang.executeActionCalendar(DATA_NAME_USER1,menuOfCalendarOption.ADDEVENT);
		evMg.inputBasicQuickEvent(newEvent1,newEvent1);
		evMg.saveQuickAddEvent();
		
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1));
		
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));
		
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
 		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));

 		info("Delete Data");
		String tabList=cTabData.getTabNameByIndex(3);
		hp.goToCalendarPage();
		cMang.deleteAllTaskEvent(tabList);
 	}

	/**
	*<li> Case ID:116275.</li>
	*<li> Test Case Name: Show activity after moving event from personal Cal to space Cal.</li>
	*<li> Pre-Condition: Create an event on a personal calendar
	*Create a Space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_ShowActivityAfterMovingEventFromPersonalCalToSpaceCal() {
		info("Test 6: Show activity after moving event from personal Cal to space Cal");
		/*Step Number: 1
		*Step Name: Show activity for moving an event from personal calendar to space calendar
		*Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Right click on Event, select [Edit], 
			- Change value of "Calendar" field from a personal calendar to a space calendar, 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			A new activity of event is added to the activity stream of both intranet and space*/ 
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		String newEvent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		String tabWeek=cTabData.getTabNameByIndex(1);
		cMang.goToTab(tabWeek);
		cMang.executeActionCalendar(DATA_NAME_USER1,menuOfCalendarOption.ADDEVENT);
		evMg.inputBasicQuickEvent(newEvent1,newEvent1);
		evMg.saveQuickAddEvent();
		
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1));
		
		cMang.openEditPopupEventByRightClick(newEvent1);
		evMg.inputBasicDetailEvent(null,null,space);
		evMg.saveAddEventDetails();
		
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));
		
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));
		
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newEvent1);
 	}

	/**
	*<li> Case ID:116276.</li>
	*<li> Test Case Name: Show activity after moving event from shared Cal to space Cal.</li>
	*<li> Pre-Condition: Create an event on a shared calendar
	*Create a Space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_ShowActivityAfterMovingEventFromSharedCalToSpaceCal() {
		info("Test 7: Show activity after moving event from shared Cal to space Cal");
		/*Step Number: 1
		*Step Name: Show activity for moving an event from shared calendar to space calendar
		*Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Double click an event of a shared calendar
			- Change [Calendar] fieldto a space calendar.
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A new event activity is created in the activity stream of intranet and space*/ 
		info("Create a new space");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		info("Create a new calendar");
		String[] userGroup={DATA_USER2};
		boolean[] canEdit={true};
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        String tabWeek=cTabData.getTabNameByIndex(1);
		cMang.goToTab(tabWeek);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
		
        info("Share the calendar");
		cMang.shareCalendar(calendar, userGroup,canEdit);
		
		
		info("Create an event in shared calendar");
		String newEvent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		cMang.executeActionCalendar(calendar,menuOfCalendarOption.ADDEVENT);
		evMg.inputBasicQuickEvent(newEvent1,newEvent1);
		evMg.saveQuickAddEvent();
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1));
		
		info("Change to space calendar");
		cMang.openEditEventTaskPopup(newEvent1);
		evMg.inputBasicDetailEvent(null,null,space);
		evMg.saveAddEventDetails();
		 
		info("Verify that A new event activity is created in the activity stream of intranet and space");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));
		
		hp.goToSpecificSpace(space);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newEvent1);
 	}}