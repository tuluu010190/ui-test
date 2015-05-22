package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.testng.annotations.*;


	public class CAL_Activity_General extends CAL_TestConfig{

	/**
	*<li> Case ID:116222.</li>
	*<li> Test Case Name: Activity is shown on activity stream of both intranet and space.</li>
	*<li> Pre-Condition: - Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ActivityIsShownOnActivityStreamOfBothIntranetAndSpace() {
		info("Test 1: Activity is shown on activity stream of both intranet and space");
		/*Step Number: 1
		*Step Name: Create an activity of calendar
		*Step Description: 
			- Connect to intranet
			- Open calendar of a space
			- Create an event/ task
		*Input Data: 
			
		*Expected Outcome: 
			- An activity is created on activity stream on intranet and space*/
		
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
		
		info("Verify that A new event activity is created in the activity stream of intranet and space");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		/*Step number: 2
		*Step Name: Update an event
		*Step Description: 
			- Edit that event/task
			- Update some fields
			- Click [Save]
			- Go to intranet home page, space's activity
		*Input Data: 
			
		*Expected Outcome: 
			- Activity is updated on activity stream on intranet and space, comments are added*/ 
		String newEvent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Change to space calendar");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.openEditEventTaskPopup(newEvent);
		evMg.inputBasicDetailEvent(newEvent1,null);
		evMg.saveAddEventDetails();
		
		info("Add successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newEvent1));
		
		info("Verify that A new event activity is created in the activity stream of intranet and space");
		String comment = cCommentData.getContentByIndex(6);
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent1).replace("$comment", comment)
				.replace("${editText}", newEvent1));
		
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent1));
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_COMMENT
				.replace("$name", newEvent1).replace("$comment", comment)
				.replace("${editText}",newEvent1));
		
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
	    cMang.deleteTaskEvent(newEvent1);
 	}

	/**
	*<li> Case ID:116244.</li>
	*<li> Test Case Name: Only members of a space can see calendar activity.</li>
	*<li> Pre-Condition: - Create a space with calendar app</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_OnlyMembersOfASpaceCanSeeCalendarActivity() {
		info("Test 2: Only members of a space can see calendar activity");
		/*Step Number: 1
		*Step Name: Create a calendar activity
		*Step Description: 
			- Connect to intranet 
			- Open calendar of space 
			- Create an event/task
		*Input Data: 
			
		*Expected Outcome: 
			- One calendar activity is shown on activity stream of intranet, space*/
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
		
		info("Verify that A new event activity is created in the activity stream of intranet and space");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		/*Step number: 2
		*Step Name: Other Users who are not member of space cannot see that activity
		*Step Description: 
			- Login as another user who is not a member of the space
		*Input Data: 
			
		*Expected Outcome: 
			- Cannot see that activity*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER2,DATA_PASS);
		 
		info("Verify that A new event activity is created in the activity stream of intranet");
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newEvent));
		
		magAc.signOut();
		magAc.signIn(DATA_USER1,DATA_PASS);
		
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
	    cMang.deleteTaskEvent(newEvent);
 	}}