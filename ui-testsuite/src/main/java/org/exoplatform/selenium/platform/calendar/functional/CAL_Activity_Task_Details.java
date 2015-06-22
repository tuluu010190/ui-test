package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class CAL_Activity_Task_Details extends CAL_TestConfig{

	/**
	 *<li> Case ID:116224.</li>
	 *<li> Test Case Name: Delete a Task activity from space activity stream by not owner.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_DeleteATaskActivityFromSpaceActivityStreamByNotOwner() {
		info("Test 1: Delete a Task activity from space activity stream by not owner");
		/*Step Number: 1
		 *Step Name: Step 1: Add task in space calendar
		 *Step Description: 
			- Connect to Intranet
			- Go to a space
			- Add a Task activity
		 *Input Data: 

		 *Expected Outcome: 
			Add task successfully*/
		String newTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(newTask,newTask);
		tasMg.saveQuickAddTask();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask));

		/*Step number: 2
		 *Step Name: Step 2: Check activity after add task
		 *Step Description: 
			Back to Homepage or activity of space
		 *Input Data: 

		 *Expected Outcome: 
			- The Task activity is displayed in the activity stream*/
		info("Verify that A new event activity is created in the activity stream of intranet and space");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		/*Step number: 3
		 *Step Name: Step 3: Invite user into space
		 *Step Description: 
			- Go to [Space Setting]
			- Invite user into space
		 *Input Data: 

		 *Expected Outcome: 
			Invite user successfully*/
		spaHome.goToSpaceSettingTab();
		setSpaceMg.inviteUser(DATA_USER2, true,DATA_NAME_USER2);

		/*Step number: 4
		 *Step Name: Step 4: User become member of space
		 *Step Description: 
			- Login by user who added at step 3
			- Click [Join a space]
			- Select a space which added and click [Accept]
		 *Input Data: 

		 *Expected Outcome: 
			User is member of space*/

		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToAllSpace();
		spaMg.acceptAInvitation(space);

		/*Step number: 5
		 *Step Name: Step 5: Check show delete icon
		 *Step Description: 
			- Move the mouse over the Task activity
		 *Input Data: 

		 *Expected Outcome: 
			Don' show (X) icon in the top right panel of the activity.*/ 
		spaMg.goToActivityStreamTab();
		mouseOver(hpAct.ELEMENT_ACTIVITY_BOX.replace("${name}",newTask), true);
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_BOX_DELETE_BUTTON.replace("${name}",newTask));

		magAc.signOut();
		magAc.signIn(DATA_USER1,DATA_PASS);
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newTask);
	}

	/**
	 *<li> Case ID:116223.</li>
	 *<li> Test Case Name: Delete a Task activity from space activity stream by owner.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test02_DeleteATaskActivityFromSpaceActivityStreamByOwner() {
		info("Test 2: Delete a Task activity from space activity stream by owner");
		/*Step Number: 1
		 *Step Name: Step 1: Add task in space calendar
		 *Step Description: 
			- Connect to Intranet
			- Go to a space
			- Add a Task activity
		 *Input Data: 

		 *Expected Outcome: 
			Add task successfully*/
		String newTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(newTask,newTask);
		tasMg.saveQuickAddTask();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask));

		/*Step number: 2
		 *Step Name: Step 2: Check activity after add task
		 *Step Description: 
			Back to or activity of space
		 *Input Data: 

		 *Expected Outcome: 
			- The Task activity is displayed in the activity stream*/
		info("Verify that A new event activity is created in the activity stream of intranet and space");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		/*Step number: 3
		 *Step Name: Step 3: Check show delete icon
		 *Step Description: 
			- Move the mouse over the Task activity
		 *Input Data: 

		 *Expected Outcome: 
			A (X) icon is displayed in the top right panel of the activity*/
		mouseOver(hpAct.ELEMENT_ACTIVITY_BOX.replace("${name}",newTask), true);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_BOX_DELETE_BUTTON.replace("${name}",newTask),2000,2);

		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_BOX_DELETE_BUTTON.replace("${name}",newTask),2000,2);

		/*Step number: 4
		 *Step Name: Step 4: Delete task's activity
		 *Step Description: 
			- Click on the (X) icon
		 *Input Data: 

		 *Expected Outcome: 
			The Task activity is removed from the activity stream*/
		hp.goToHomePage();
		hpAct.deleteActivity(newTask);

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newTask);

	}

	/**
	 *<li> Case ID:116270.</li>
	 *<li> Test Case Name: Add Task's activity after move task from personal Cal to group Cal.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test03_AddTasksActivityAfterMoveTaskFromPersonalCalToGroupCal() {
		info("Test 3: Add Task's activity after move task from personal Cal to group Cal");
		/*Step Number: 1
		 *Step Name: Step 1: Change personal calendar to group calendar
		 *Step Description: 
			- Connect to Intranet
			- Open a personal calendar
			- Edit task of personal calendar
			- Change task from personal calendar to group calendar( choose calendar of space)
		 *Input Data: 

		 *Expected Outcome: 
			Change task sucessfully*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
		cMang.saveAddCalendar();

		String newTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newTask1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cMang.executeActionCalendar(calendar,menuOfCalendarOption.ADDTASK);
		tasMg.inputBasicQuickTask(newTask,newTask);
		tasMg.saveQuickAddTask();

		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask));

		Utils.pause(2000);
		cMang.openEditEventTaskPopup(newTask,selectViewOption.LIST);
		tasMg.inputBasicDetailTask(newTask1,newTask1,space);
		tasMg.saveAddTaskDetails();

		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask1))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask1));

		/*Step number: 2
		 *Step Name: Step 2: Check activity after move task
		 *Step Description: 
			- Back to the space or Homepage activity stream
		 *Input Data: 

		 *Expected Outcome: 
			A new activity of task is added to the activity stream of both intranet and space*/ 
		info("Verify that A new event activity is created in the activity stream of intranet and space");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask1));

		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask1));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newTask1);
	}

	/**
	 *<li> Case ID:116271.</li>
	 *<li> Test Case Name: Remove task's activity after deleting task.</li>
	 *<li> Pre-Condition: task's activity is shared in the activity stream</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_RemoveTasksActivityAfterDeletingTask() {
		info("Test 4: Remove task's activity after deleting task");
		/*Step Number: 1
		 *Step Name: Step 1: Delete task from calendar
		 *Step Description: 
			- Connect to Intranet
			- Open a space Group Calendar
			- Delete a task
		 *Input Data: 

		 *Expected Outcome: 
			Task is removed successfully*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		String newTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
		cHome.goToView(selectViewOption.WEEK);
		cMang.executeActionCalendar(DATA_NAME_USER1,menuOfCalendarOption.ADDTASK);
		tasMg.inputBasicQuickTask(newTask,newTask,space);
		tasMg.saveQuickAddTask();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask));

		info("Remove task successfully");
		cMang.deleteTaskEvent(newTask);

		/*Step number: 2
		 *Step Name: Step 2: Go to space activity stream
		 *Step Description: 
			- Go to My activity
		 *Input Data: 

		 *Expected Outcome: 
			Activity is removed from the space activity stream*/
		info("Verify that A new event activity is removed from the activity stream of space");
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		/*Step number: 3
		 *Step Name: Step 3: Go to intranet activity stream
		 *Step Description: 
			- Go to The Homepage
		 *Input Data: 

		 *Expected Outcome: 
			Activity is removed from the intranet activity stream*/ 

		info("Verify that A new event activity is removed from the activity stream of intranet");
		hp.goToHomePage();
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));
	}

	/**
	 *<li> Case ID:116272.</li>
	 *<li> Test Case Name: Delete a Task activity from intranet activity stream by owner.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test05_DeleteATaskActivityFromIntranetActivityStreamByOwner() {
		info("Test 5: Delete a Task activity from intranet activity stream by owner");
		/*Step Number: 1
		 *Step Name: Step 1: Add task
		 *Step Description: 
			- Connect to Intranet
			- Open calendar application
			- Add a Task activity for group
		 *Input Data: 

		 *Expected Outcome: 
			Add task successfully*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		String newTask = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(newTask,newTask,space);
		tasMg.saveQuickAddTask();

		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask));

		/*Step number: 2
		 *Step Name: Step 2: Check activity after add task
		 *Step Description: 
			Back to Homepage
		 *Input Data: 

		 *Expected Outcome: 
			- The Task activity is displayed in the activity stream*/
		info("Verify that A new event activity is removed from the activity stream of intranet");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		/*Step number: 3
		 *Step Name: Step 3: Check show delete icon
		 *Step Description: 
			- Move the mouse over the Task activity
		 *Input Data: 

		 *Expected Outcome: 
			A (X) icon is displayed in the top right panel of the activity*/

		/*Step number: 4
		 *Step Name: Step 4: Delete task's activity
		 *Step Description: 
			- Click on the (X) icon
		 *Input Data: 

		 *Expected Outcome: 
			The Task activity is removed from the activity stream*/ 
		hpAct.deleteActivity(newTask);

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newTask);
	}

	/**
	 *<li> Case ID:116273.</li>
	 *<li> Test Case Name: Dislike a Task activity from like icon.</li>
	 *<li> Pre-Condition: the activity is liked by the userHave a space</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test06_DislikeATaskActivityFromLikeIcon() {
		info("Test 6: Dislike a Task activity from like icon");
		/*Step Number: 1
		 *Step Name: Step 1: Add task
		 *Step Description: 
			- Connect to Intranet with User A
			- Open calendar application
			- Add a Task activity for group ( group of space)
		 *Input Data: 

		 *Expected Outcome: 
			Add task sucessfully*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		String newTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(newTask,newTask);
		tasMg.saveQuickAddTask();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask));

		/*Step number: 2
		 *Step Name: Step 2: Check activity after add task
		 *Step Description: 
			- Back to Homepage
			- Click on like icon
		 *Input Data: 

		 *Expected Outcome: 
			- The Task activity is displayed in the activity stream*like icon + number of likes to 1*/
		hp.goToHomePage();
		hpAct.likeActivity(newTask);

		/*Step number: 3
		 *Step Name: Step 3: Dislike task's activity
		 *Step Description: 
			- Click on like icon
		 *Input Data: 

		 *Expected Outcome: 
			- The Task activity is disliked by the user, the number of like is updated to 
			-1*/ 
		hpAct.unlikeActivity(newTask);

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newTask);
	}

	/**
	 *<li> Case ID:116303.</li>
	 *<li> Test Case Name: Add activity after create a Task.</li>
	 *<li> Pre-Condition: - user is member of a space</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test07_AddActivityAfterCreateATask() {
		info("Test 7: Add activity after create a Task");
		/*Step Number: 1
		 *Step Name: Step 1: Add new space
		 *Step Description: 
			- Login portal
			- Click [Join a space]
			- Click [Add new space]
			- Input value require and click [Save]
		 *Input Data: 

		 *Expected Outcome: 
			Add new space successfully*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);

		/*Step number: 2
		 *Step Name: Step 2: Add task in space
		 *Step Description: 
			- Go to [Agenda] in space
			- Add a Task
		 *Input Data: 

		 *Expected Outcome: 
			Add task successfully*/
		String newTask= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputBasicQuickTask(newTask,newTask);
		tasMg.saveQuickAddTask();
		info("Add task successfully");
		cMang.scrollElementIntoView(this.driver.findElement(By.xpath(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask))));
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_TITLE.replace("${name}",newTask));

		/*Step number: 3
		 *Step Name: Step 3: Check after add task in space
		 *Step Description: 
			Go to [Activity Stream] of space
		 *Input Data: 

		 *Expected Outcome: 
			- An activity is added to the space activity stream with task's content*/
		info("Verify that A new event activity is added to the activity stream of space");
		hp.goToSpecificSpace(space);
		spaMg.goToActivityStreamTab();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		/*Step number: 4
		 *Step Name: Step 4: Check activity in homepage
		 *Step Description: 
			Go back to intranet homepage
		 *Input Data: 

		 *Expected Outcome: 
			- An activity is added to the intranet activity stream with task's content*/ 
		info("Verify that A new event activity is added to the activity stream of space");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TASK_EVENT_TITLE.replace("$name",newTask));

		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newTask);
	}}
