package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


public class CAL_Settings extends CAL_TestConfig_4{

	/**
	 *<li> Case ID:116314.</li>
	 *<li> Test Case Name: Check displaying of Displayed Calendars tab.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_CheckDisplayingOfDisplayedCalendarsTab() {
		info("Test 1: Check displaying of Displayed Calendars tab");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in to Calendar
			- Click calendar menu on left panel 
			- Click Settings
			- Choose Displayed Calendars tab
		 *Input Data: 

		 *Expected Outcome: 
			"Displayed Calendars" tab is displayed the exact same Calendar list on left panel inCalendar view:+ Personal calendar list, + Group calendar list+ Shared calendar list*/ 
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		String group="Development";
		String fullName = userData.fullName.get(0);
		cMang.goToDisplayCalendarTab();
		waitForAndGetElement(cMang.ELEMENT_DISPLAY_CALENDAR_FORM_CHECKED.replace("$calendar", fullName));
		waitForAndGetElement(cMang.ELEMENT_DISPLAY_FORM_GROUP_CALENDAR_ITEM_CHECKBOX.replace("$name", group));

	}

	/**
	 *<li> Case ID:116315.</li>
	 *<li> Test Case Name: Check displaying of scroll in Displayed Calendars tab.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test (groups="pending")
	public  void test02_CheckDisplayingOfScrollInDisplayedCalendarsTab() {
		info("Test 2: Check displaying of scroll in Displayed Calendars tab");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in as john
			- Add 3 more calendars
			- Click calendar menu on left panel 
			- Click Settings
			- Choose Displayed Calendars tab
		 *Input Data: 

		 *Expected Outcome: 
			Scroll is shown*/ 

	}

	/**
	 *<li> Case ID:116313.</li>
	 *<li> Test Case Name: Check displaying of Settings popup's height.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test (groups="pending")
	public  void test03_CheckDisplayingOfSettingsPopupsHeight() {
		info("Test 3: Check displaying of Settings popup's height");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in to Calendar
			- Click calendar menu on left panel 
			- Click Settings and check Settings popup's height
		 *Input Data: 

		 *Expected Outcome: 
			Settings popup's height is limited to 450 pixels.*/ 

	}

	/**
	 *<li> Case ID:116454.</li>
	 *<li> Test Case Name: Set always send invitation.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_SetAlwaysSendInvitation() {
		info("Test 4: Set always send invitation");
		String defaultFormatTime = "24 Hours";
		String defaultFormatDate = "MM/dd/yyyy";
		String defaultTimeZone = "(GMT +07:00) Asia/Ho_Chi_Minh";
		String defaultDay="Monday";
		
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Show calendar setting form
		 *Input Data: 
			Click on Settings from Tool bar
		 *Expected Outcome: 
			Calendar Settings pop up appears.There are 2 tabs in this pop up*/
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar("Week",defaultTimeZone,defaultFormatDate.toLowerCase(),defaultFormatTime,defaultDay,false,selectInvitationOption.ALWAYS);
		cMang.saveSetting();

		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Finish setting
		 *Input Data: 
			- Click Always radio 
			- Click Save
		 *Expected Outcome: 
			Setting calendar was set*/ 
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		click(evMg.ELEMENT_EVENT_PARTICIPANTS_TAB);
		assert waitForAndGetElement(evMg.ELEMENT_SEND_INVITATION_ALWAYS_CHECKBOX, 5000,1,2).isSelected();
		evMg.cancelAddEditDetailEvent();

		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar("Week",defaultTimeZone,defaultFormatDate.toLowerCase(),defaultFormatTime,defaultDay,false,selectInvitationOption.NEVER);
		cMang.saveSetting();
	}

	/**
	 *<li> Case ID:116455.</li>
	 *<li> Test Case Name: Set Ask send invitation.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test05_SetAskSendInvitation() {
		info("Test 5: Set Ask send invitation");
		String defaultFormatTime = "24 Hours";
		String defaultFormatDate = "MM/dd/yyyy";
		String defaultTimeZone = "(GMT +07:00) Asia/Ho_Chi_Minh";
		String defaultDay="Monday";

		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Show calendar setting form
		 *Input Data: 
			Click on Settings from Tool bar
		 *Expected Outcome: 
			Calendar Settings pop up appears.There are 2 tabs in this pop up*/
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar("Week",defaultTimeZone,defaultFormatDate.toLowerCase(),defaultFormatTime,defaultDay,false,selectInvitationOption.ASK);
		cMang.saveSetting();

		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Finish setting
		 *Input Data: 
			- Click Ask radio 
			- Click Save
		 *Expected Outcome: 
			Setting calendar was set*/ 
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		click(evMg.ELEMENT_EVENT_PARTICIPANTS_TAB);
		assert waitForAndGetElement(evMg.ELEMENT_SEND_INVITATION_ASK_CHECKBOX, 5000,1,2).isSelected();
		evMg.cancelAddEditDetailEvent();

		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar("Week",defaultTimeZone,defaultFormatDate.toLowerCase(),defaultFormatTime,defaultDay,false,selectInvitationOption.NEVER);
		cMang.saveSetting();
	}

	/**
	 *<li> Case ID:116533.</li>
	 *<li> Test Case Name: Set never send invitation.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test06_SetNeverSendInvitation() {
		String defaultFormatTime = "24 Hours";
		String defaultFormatDate = "MM/dd/yyyy";
		String defaultTimeZone = "(GMT +07:00) Asia/Ho_Chi_Minh";
		String defaultDay="Monday";

		info("Test 6: Set never send invitation");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Show calendar setting form
		 *Input Data: 
			Click on Settings from Tool bar
		 *Expected Outcome: 
			Calendar Settings pop up appears.There are 2 tabs in this pop up*/
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar("Week",defaultTimeZone,defaultFormatDate.toLowerCase(),defaultFormatTime,defaultDay,false,selectInvitationOption.NEVER);
		cMang.saveSetting();

		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Finish setting
		 *Input Data: 
			- Click Never radio 
			- Click Save
		 *Expected Outcome: 
			Setting calendar was set*/ 
		hp.goToCalendarPage();
		evMg.goToAddEventFromActionBar();
		evMg.moreDetailsEvent();
		click(evMg.ELEMENT_EVENT_PARTICIPANTS_TAB);
		assert waitForAndGetElement(evMg.ELEMENT_SEND_INVITATION_NEVER_CHECKBOX, 5000,1,2).isSelected();
		evMg.cancelAddEditDetailEvent();

		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar("Week",defaultTimeZone,defaultFormatDate.toLowerCase(),defaultFormatTime,defaultDay,false,selectInvitationOption.NEVER);
		cMang.saveSetting();
	}
}