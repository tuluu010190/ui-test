package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.testng.annotations.*;


public class CAL_Search extends CAL_TestConfig_3{

	/**
	 *<li> Case ID:116456.</li>
	 *<li> Test Case Name: Search by quick search when search keyword matches existing events or tasks.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_SearchByQuickSearchWhenSearchKeywordMatchesExistingEventsOrTasks() {
		info("Test 1: Search by quick search when search keyword matches existing events or tasks");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Add events/tasks
		 *Input Data: 
			Click on Add event/task from action bar, input valid value, click save Add event : [ Details ]Add task : [ Details ]
		 *Expected Outcome: 
			Events/Tasks are added successfully*/
		String titleEvent = txData.getContentByArrayTypeRandom(1)+"dinnere115694"+" dinner";
		String titleTask = txData.getContentByArrayTypeRandom(1)+"dinnert115694"+ " dinner";
		String content = txData.getContentByArrayTypeRandom(1)+"115694";
		String defaultFormatDate="MM/dd/yyyy";
		String key="dinner";
		String key1="dinnertest";

		info("create data test");
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.inputDataEventInQuickForm(titleEvent, content, getDate(0,defaultFormatDate), getDate(0,defaultFormatDate),false);
		evMg.saveQuickAddEvent();
		cHome.verifyIsPresentEventTask(titleEvent, selectViewOption.LIST, selectDayOption.DETAILTIME);

		tasMg.goToAddTaskFromActionBar();
		tasMg.inputDataTaskInQuickForm(titleTask, content, getDate(0,defaultFormatDate), getDate(0,defaultFormatDate),false);
		tasMg.saveQuickAddTask();
		cHome.verifyIsPresentEventTask(titleTask, selectViewOption.LIST, selectDayOption.DETAILTIME);

		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Search
		 *Input Data: 
			- Input searching keyword (that matches added events/tasks) in the Search text box
			- Click Search icon
		 *Expected Outcome: 
			- All matched any text field of events/task are displayed in search result in list
			- Search result screen include columns: Title, event/task icon, Start, End, Description*/ 
		cHome.quickSearchCalendar(key);
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", titleEvent));
		waitForAndGetElement(cHome.ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", titleTask));
		click(cHome.ELEMENT_BUTTON_CLOSE_QUICK_SEARCH_RESULT);

		cHome.quickSearchCalendar(key1);
		waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", titleEvent));
		waitForElementNotPresent(cHome.ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", titleTask));
		click(cHome.ELEMENT_BUTTON_CLOSE_QUICK_SEARCH_RESULT);

		info("Delete data");
		cHome.deleteEventTask(titleEvent, selectViewOption.LIST, selectDayOption.DETAILTIME,null);
		cHome.deleteEventTask(titleTask, selectViewOption.LIST, selectDayOption.DETAILTIME,null);

	}
}