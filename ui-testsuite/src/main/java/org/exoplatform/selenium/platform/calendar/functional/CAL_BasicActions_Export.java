package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfCalendarOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.Test;

public class CAL_BasicActions_Export extends CAL_TestConfig_2{
	/**
	 *<li> Case ID:116324.</li>
	 *<li> Test Case Name: Check export format</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_CheckExportFormat() {
		info("Test 1: Check export format");
		String calendarName= txData.getContentByArrayTypeRandom(1)+"116324";
		String calendarColor = "light_purple";
		String attachment=getRandomNumber()+".ics";
		String taskName= txData.getContentByArrayTypeRandom(1)+"116324";

		/*Step Number: 1
		 *Step Name: Step 1: Export format is ICS only.
		 *Step Description: 
			- Add a new calendar 
            - Click wheel icon of added calendar and select Export
            - See export format
		 *Input Data: 

		 *Expected Outcome: 
			Export format is ICS only.*/
		info("Create data test");
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		cMang.inputDataInDetailTabCalendarForm(calendarName, calendarName, calendarColor);
		cMang.saveAddCalendar();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", calendarName));
		cMang.executeActionCalendar(calendarName, menuOfCalendarOption.ADDTASK);
		tasMg.inputDataTaskInQuickForm(taskName, taskName, getDate(0,"MM/dd/yyyy"), getDate(0,"MM/dd/yyyy"),false);
		tasMg.saveQuickAddTask();
		cHome.verifyIsPresentEventTask(taskName, selectViewOption.LIST, selectDayOption.ONEDAY);

		cMang.exportCalendar(calendarName,attachment);
		cMang.deleteCalendar(calendarName,true);
	}
}
