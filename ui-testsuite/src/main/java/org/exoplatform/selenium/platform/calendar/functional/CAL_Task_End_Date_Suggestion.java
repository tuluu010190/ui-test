package org.exoplatform.selenium.platform.calendar.functional;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Task_End_Date_Suggestion extends CAL_TestConfig_3{

	/**
	*<li> Case ID:115846.</li>
	*<li> Test Case Name: Default Start date should be displayed at Today for Task.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DefaultStartDateShouldBeDisplayedAtTodayForTask() {
		info("Test 1: Default Start date should be displayed at Today for Task");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- The Default Start date "From" is set to Today (System date)*/ 
		info("The Default Start date FROM is set to Today (System date)");
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_DATE_VALUE.
        		replace("$value",getCurrentDate("MM/dd/yyyy")));
		tasMg.cancelQuickAddEditTask();
 	}

	/**
	*<li> Case ID:115847.</li>
	*<li> Test Case Name: Default Start time should be displayed at current time for task from left panel.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DefaultStartTimeShouldBeDisplayedAtCurrentTimeForTaskFromLeftPanel() {
		info("Test 2: Default Start time should be displayed at current time for task from left panel");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- From the left panel "Calendar", click on "Settings" button of a calendar
			- Choose the option "Add Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- The Default Start time "From" is displayed H:00, H:30 or H+1:00 
			where H is the current hour. It selects the value corresponding to the next half hour.*/ 
		info("Check default start time");
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		hp.goToCalendarPage();		
		cMang.executeActionCalendar(calendar, menuOfCalendarOption.ADDTASK);
		int currTimeHour= Integer.parseInt(getCurrentDate("HH"));
		int currTimeMin= Integer.parseInt(getCurrentDate("mm"));
		int timeFromHour=0;
		tasMg.inputDataTaskInQuickForm(null,null,null,null,false);
		if(currTimeMin<30 && currTimeHour>0){
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
					replace("$value",String.valueOf(currTimeHour)+":30"),2000,2);
		}else{
			 timeFromHour=currTimeHour+1;
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
					replace("$value",String.valueOf(timeFromHour)+":00"),2000,2);
		}
		tasMg.cancelQuickAddEditTask();
 	}

	/**
	*<li> Case ID:115848.</li>
	*<li> Test Case Name: Start times value in the list of options should be on half hour for Task.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_StartTimesValueInTheListOfOptionsShouldBeOnHalfHourForTask() {
		info("Test 3: Start times value in the list of options should be on half hour for Task");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on the Start Time textfield
		*Input Data: 
			
		*Expected Outcome: 
			- the list of options is displayed, times values proposed are half hour*/
		info("the list of options is displayed, times values proposed are half hour");
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
        waitForAndGetElement(cMang.ELEMENT_TASK_LIST_HOUR_FROM_DATE_VALUE);
        tasMg.cancelQuickAddEditTask();

 	}

	/**
	*<li> Case ID:115849.</li>
	*<li> Test Case Name: End times value in the list of options should be on half hour for Task.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_EndTimesValueInTheListOfOptionsShouldBeOnHalfHourForTask() {
		info("Test 4: End times value in the list of options should be on half hour for Task");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on the End Time textfield
		*Input Data: 
			
		*Expected Outcome: 
			- the list of options is displayed, times values proposed are half hour*/ 
		info("the list of options is displayed, times values proposed are half hour");
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
        waitForAndGetElement(cMang.ELEMENT_TASK_LIST_HOUR_TO_DATE_VALUE);
        tasMg.cancelQuickAddEditTask();

 	}

	/**
	*<li> Case ID:115852.</li>
	*<li> Test Case Name: Default Start time should be displayed at current time for Task.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_DefaultStartTimeShouldBeDisplayedAtCurrentTimeForTask() {
		info("Test 5: Default Start time should be displayed at current time for Task");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- The Default Start time "From" is displayed H:00, H:30 or H+1:00 where H is the current hour. 
			It selects the value corresponding to the next half hour.*/ 
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		int currTimeHour= Integer.parseInt(getCurrentDate("HH"));
		int currTimeMin= Integer.parseInt(getCurrentDate("mm"));
		int timeFromHour=0;
		tasMg.inputDataTaskInQuickForm(null,null,null,null,false);
		if(currTimeMin<30 && currTimeHour>0){
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
					replace("$value",String.valueOf(currTimeHour)+":30"),2000,2);
		}else{
			 timeFromHour=currTimeHour+1;
			 info("timeFromHour"+timeFromHour);
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
					replace("$value",String.valueOf(timeFromHour)+":00"),2000,2);
		}
		tasMg.cancelQuickAddEditTask();
 	}

	/**
	*<li> Case ID:115855.</li>
	*<li> Test Case Name: Default Start date should be displayed at Today for Task from left panel.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_DefaultStartDateShouldBeDisplayedAtTodayForTaskFromLeftPanel() {
		info("Test 6: Default Start date should be displayed at Today for Task from left panel");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- From the left panel "Calendar", click on "Settings" button of a calendar
			- Choose the option "Add Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- The Default Start date "From" is set to Today (System date)*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a task");
		hp.goToCalendarPage();		
		cMang.executeActionCalendar(calendar, menuOfCalendarOption.ADDTASK);
		waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_DATE_VALUE.
        		replace("$value",getCurrentDate("MM/dd/yyyy")));
		tasMg.cancelQuickAddEditTask();

 	}

	/**
	*<li> Case ID:115859.</li>
	*<li> Test Case Name: End date of Task should be updated after edit Start date from input box.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_EndDateOfTaskShouldBeUpdatedAfterEditStartDateFromInputBox() {
		info("Test 7: End date of Task should be updated after edit Start date from input box");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- Start Date and End date are displayed
			- Duration is X days*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Input a start date in the input box
			- Remove the focus on the textfield
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End date is updated 
			- The value is start date + default duration (X)*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a task");
		int currDay=Integer.parseInt(getCurrentDate("dd"));
		int lastDay = Integer.parseInt(getLastDayOfWeek("dd"));
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		if(currDay==lastDay){
			tasMg.inputDataTaskInQuickForm(title,content,getDate(-2,"MM/dd/yyyy"),
					getDate(-1,"MM/dd/yyyy"),false,calendar);
		}else{
			tasMg.inputDataTaskInQuickForm(title,content,getDate(1,"MM/dd/yyyy"),
					getDate(2,"MM/dd/yyyy"),false,calendar);
		}
		tasMg.saveQuickAddTask();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(title,selectViewOption.WEEK);
		tasMg.inputDataTaskInDetailForm(title,content,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
		tasMg.saveAddTaskDetails();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(title,selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_TASK_TO_DATE_VALUE.
				replace("$value",getDateFromFirstDayOfWeek(1,"MM/dd/yyyy")));
        tasMg.cancelAddEditDetailTask();
        
        cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:115860.</li>
	*<li> Test Case Name: End date of Task should be updated after edit Start date from Select box.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_EndDateOfTaskShouldBeUpdatedAfterEditStartDateFromSelectBox() {
		info("Test 8: End date of Task should be updated after edit Start date from Select box");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- Start Date and End date are displayed
			- Duration is X days*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Select a start date with the select box
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End date is updated 
			- The value is start date + default duration (X)*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a task");
		int currDay=Integer.parseInt(getCurrentDate("dd"));
		int lastDay = Integer.parseInt(getLastDayOfWeek("dd"));
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		if(currDay==lastDay){
			tasMg.inputDataTaskInQuickForm(title,content,getDate(-2,"MM/dd/yyyy"),
					getDate(-1,"MM/dd/yyyy"),false,calendar);
		}else{
		    tasMg.inputDataTaskInQuickForm(title,content,getDate(1,"MM/dd/yyyy"),
					getDate(2,"MM/dd/yyyy"),false,calendar);
		}
		tasMg.saveQuickAddTask();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(title,selectViewOption.WEEK);
		tasMg.inputDataTaskInDetailForm(title,content,getFirstDayOfWeek("MM/dd/yyyy"),null,false,calendar);
		tasMg.saveAddTaskDetails();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(title,selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_TASK_TO_DATE_VALUE.
				replace("$value",getDateFromFirstDayOfWeek(1,"MM/dd/yyyy")));
        tasMg.cancelAddEditDetailTask();
        
        cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115865.</li>
	*<li> Test Case Name: Start/End time of Task should displayed after uncheck all day box.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_StartEndTimeOfTaskShouldDisplayedAfterUncheckAllDayBox() {
		info("Test 9: Start/End time of Task should displayed after uncheck all day box");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Add Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			-Start time and End time are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Check "All day" option
		*Input Data: 
			
		*Expected Outcome: 
			- Start/End Time field are removed*/
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a task");
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputDataTaskInQuickForm(title, content,null,null,true);
		waitForElementNotPresent(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME);	
		waitForElementNotPresent(cMang.ELEMENT_QUICK_INPUT_TASK_TO_TIME);	

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Unckeck "All day" option
		*Input Data: 
			
		*Expected Outcome: 
			- The date remains
			- The time range should be 10:00 AM and time shift is 30 min*/ 
		int currTimeHour= Integer.parseInt(getCurrentDate("HH"));
		int currTimeMin= Integer.parseInt(getCurrentDate("mm"));
		int timeFromHour=0;
		int timeToHour=0;
		tasMg.inputDataTaskInQuickForm(null,null,null,null,false);
		if(currTimeMin<30 && currTimeHour>0){
		    timeToHour=currTimeHour+1;
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
					replace("$value",String.valueOf(currTimeHour)+":30"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_TO_DATE_VALUE.
					replace("$value",String.valueOf(timeToHour)+":30"),2000,2);
		}else{
			 timeFromHour=currTimeHour+1;
		     timeToHour=currTimeHour+2;
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
					replace("$value",String.valueOf(timeFromHour)+":00"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_TO_DATE_VALUE.
					replace("$value",String.valueOf(timeToHour)+":00"),2000,2);
		}
		tasMg.cancelQuickAddEditTask();

 	}

	/**
	*<li> Case ID:115866.</li>
	*<li> Test Case Name: Start/End time of Task should not change after edit the duration.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_StartEndTimeOfTaskShouldNotChangeAfterEditTheDuration() {
		info("Test 10 Start/End time of Task should not change after edit the duration");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Add Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			-Start time and End time are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit Start Date or/and End Date to edit duration
		*Input Data: 
			
		*Expected Outcome: 
			- The duration of the Task is edited
			- The time suggestions (Start/end) are made with the current duration*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a task");
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputDataTaskInQuickForm(title, content,getFirstDayOfWeek("MM/dd/yyyy"),
				getFirstDayOfWeek("MM/dd/yyyy"),true,calendar);
		tasMg.saveQuickAddTask();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(title, selectViewOption.WEEK);
		tasMg.inputDataTaskInDetailForm(null,null,getLastDayOfWeek("MM/dd/yyyy"), 
				getLastDayOfWeek("MM/dd/yyyy"),false);
		tasMg.saveAddTaskDetails();
		
		info("Edit the task");
		int currentHour=Integer.parseInt(getCurrentDate("HH"));
		int currentMin=Integer.parseInt(getCurrentDate("mm"));
		cMang.openEditEventTaskPopup(title, selectViewOption.WEEK);
		if(currentMin<30 && currentMin>0){
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_TASK_FROM_TIME_VALUE.
					replace("$time",String.valueOf(currentHour)+":30"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_TASK_TO_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+1)+":30"),2000,2);
		}else{
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_TASK_FROM_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+1)+":00"),2000,2);
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_TASK_TO_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+2)+":00"),2000,2);
		}
		tasMg.cancelAddEditDetailTask();
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115869.</li>
	*<li> Test Case Name: End time of Task should be updated after edit Start time.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_EndTimeOfTaskShouldBeUpdatedAfterEditStartTime() {
		info("Test 11 End time of Task should be updated after edit Start time");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- Start Time and End Time are displayed
			- Duration is X hours*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Input a start datetime in the input box
		*Input Data: 
			
		*Expected Outcome: 
			- The value of the End time is updated 
			- The value is start time + default duration (X)*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a task");
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputDataTaskInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),
				getFirstDayOfWeek("MM/dd/yyyy"),true,calendar);
		tasMg.saveQuickAddTask();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		tasMg.inputDataTaskInDetailForm(null,null,getLastDayOfWeek("MM/dd/yyyy ")+getCurrentDate("HH")+":00",null,false);
		tasMg.saveAddTaskDetails();
		
		info("Edit the task");
		int currentHour=Integer.parseInt(getCurrentDate("HH"));
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
			waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_INPUT_TASK_TO_TIME_VALUE.
					replace("$time",String.valueOf(currentHour+1)+":00"),2000,2);
		tasMg.cancelAddEditDetailTask();
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:115872.</li>
	*<li> Test Case Name: Default Duration of a Task should be 30 min.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_DefaultDurationOfATaskShouldBe30Min() {
		info("Test 12 Default Duration of a Task should be 30 min");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the boutton "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			-The default duration for Task is 30min*/
        
		int sourceTimeHour=Integer.parseInt(getCurrentDate("HH"));
		int sourceTimeMin=Integer.parseInt(getCurrentDate("mm"));
        hp.goToCalendarPage();
        tasMg.goToAddTaskFromActionBar();
        if(sourceTimeMin>30 && sourceTimeMin<0)
        	waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
        		replace("$value",String.valueOf(sourceTimeHour)+":30"),2000,2);
        else
        	waitForAndGetElement(cMang.ELEMENT_QUICK_INPUT_TASK_FROM_TIME_VALUE.
            		replace("$value",String.valueOf(sourceTimeHour+1)+":00"),2000,2);
        tasMg.cancelQuickAddEditTask();

 	}

	/**
	*<li> Case ID:115874.</li>
	*<li> Test Case Name: End date of Task should be suggested only when start date is updated.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_EndDateOfTaskShouldBeSuggestedOnlyWhenStartDateIsUpdated() {
		info("Test 13 End date of Task should be suggested only when start date is updated");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Inranet
			- Open Calendar Application
			- Click on the button "Task"
		*Input Data: 
			
		*Expected Outcome: 
			- The pop up "Quick Add Task" is displayed
			- Start Date and End date are displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Edit the Start Date
		*Input Data: 
			
		*Expected Outcome: 
			- TheEnd date is suggested*/ 
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Add a task");
		hp.goToCalendarPage();		
		tasMg.goToAddTaskFromActionBar();
		tasMg.inputDataTaskInQuickForm(titleEvent, content,getFirstDayOfWeek("MM/dd/yyyy"),
				getFirstDayOfWeek("MM/dd/yyyy"),true,calendar);
		tasMg.saveQuickAddTask();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		tasMg.inputDataTaskInDetailForm(null,null,getLastDayOfWeek("MM/dd/yyyy"),null,false);
		tasMg.saveAddTaskDetails();
		
		info("Edit the task");
		cMang.openEditEventTaskPopup(titleEvent, selectViewOption.WEEK);
		waitForAndGetElement(cMang.ELEMENT_ADD_EDIT_TASK_TO_DATE_VALUE.
				replace("$value",getLastDayOfWeek("MM/dd/yyyy")));
		tasMg.cancelAddEditDetailTask();
		cMang.deleteCalendar(calendar);

 	}}