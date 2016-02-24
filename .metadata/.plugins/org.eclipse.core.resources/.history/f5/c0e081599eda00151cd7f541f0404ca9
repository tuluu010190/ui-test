package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Manage_Common_Actions extends CAL_TestConfig_2{

	/**
	*<li> Case ID:116280.</li>
	*<li> Test Case Name: Check tooltip of group button in Show in Groups tabs.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckTooltipOfGroupButtonInShowInGroupsTabs() {
		info("Test 1: Check tooltip of group button in Show in Groups tabs");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Mouse over group button
		*Input Data: 
			
		*Expected Outcome: 
			On "Group" button, the tooltip "Group" is displayed*/ 
		 hp.goToCalendarPage();
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 click(cMang.ELEMENT_CALENDAR_GROUP_TAB);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_GROUP_BTN);
		 cMang.cancelAddCalendar();
 	}

	/**
	*<li> Case ID:116284.</li>
	*<li> Test Case Name: Check tooltips of action buttons.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckTooltipsOfActionButtons() {
		info("Test 2: Check tooltips of action buttons");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
			- Click Group button
			- Choose a group/ user/ membership
			- Mouse over actions buttons
		*Input Data: 
			
		*Expected Outcome: 
			Tooltips are displayed on action buttons*/ 
		 hp.goToCalendarPage();
		 String userGroup="/platform/web-contributors";
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 click(cMang.ELEMENT_CALENDAR_GROUP_TAB);
		 cMang.selectGroupInGroupTabCalendarForm(userGroup,true);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_ACTIONS_SELECT_USER_BTN);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_ACTIONS_SELECT_ROLE_BTN);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_ACTIONS_DELETE_PERMISSION_BTN);
		 cMang.cancelAddCalendar();

 	}

	/**
	*<li> Case ID:116330.</li>
	*<li> Test Case Name: Check tabs in adding calendar popup.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckTabsInAddingCalendarPopup() {
		info("Test 3: Check tabs in adding calendar popup");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- See Add Calendar popup
		*Input Data: 
			
		*Expected Outcome: 
			There are 2 tabs: 
			- Details
			- Show in Groups*/ 
		 hp.goToCalendarPage();
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_DETAIL_TAB);
		 cMang.cancelAddCalendar();
 	}

	/**
	*<li> Case ID:116331.</li>
	*<li> Test Case Name: Check Details tab in calendar popup.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CheckDetailsTabInCalendarPopup() {
		info("Test 4: Check Details tab in calendar popup");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- See Add Calendar popup
		*Input Data: 
			
		*Expected Outcome: 
			In Detail tab, there are fields:
			- Display Name
			- Description
			- Time Zone
			- Color3 buttons:
			- Save
			- Reset
			- Cancel*/ 
		 hp.goToCalendarPage();
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_DISPLAY_NAME_INPUT);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_DESC_INPUT);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_TIMEZONE);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_COLOR);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_SAVE_BUTTON);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_RESET_BUTTON);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_ADD_CANCEL_BUTTON);
		 cMang.cancelAddCalendar();
 	}

	/**
	*<li> Case ID:116332.</li>
	*<li> Test Case Name: Check Column in Show in Groups tabs.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_CheckColumnInShowInGroupsTabs() {
		info("Test 5: Check Column in Show in Groups tabs");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
		*Input Data: 
			
		*Expected Outcome: 
			A table is displayed with column "Groups", "User able to edit calendar", "Actions"*/ 
		 hp.goToCalendarPage();
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 click(cMang.ELEMENT_CALENDAR_GROUP_TAB);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TABLE_GROUPS_COLUMN);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TABLE_USERS_COLUMN);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TABLE_ACTIONS_COLUMN);
		 cMang.cancelAddCalendar();
 	}

	/**
	*<li> Case ID:116333.</li>
	*<li> Test Case Name: Check default value of Show in Groups tabs.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_CheckDefaultValueOfShowInGroupsTabs() {
		info("Test 6: Check default value of Show in Groups tabs");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar
			- Click Add Calendar in Calendar menu
			- Select Show in Groups tabs
		*Input Data: 
			
		*Expected Outcome: 
			- A table is displayed with column "Groups", "User able to edit calendar", "Actions"
			- At first, the table is empty. No group has been selected yet*/ 
		 hp.goToCalendarPage();
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 click(cMang.ELEMENT_CALENDAR_GROUP_TAB);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TABLE_GROUPS_COLUMN);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TABLE_USERS_COLUMN);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TABLE_ACTIONS_COLUMN);
		 waitForAndGetElement(cMang.ELEMENT_CALENDAR_GROUP_TAB_TABLE_EMPTY);
		 cMang.cancelAddCalendar();
 	}

	/**
	*<li> Case ID:116497.</li>
	*<li> Test Case Name: Check Reset button in Calendar form.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_CheckResetButtonInCalendarForm() {
		info("Test 7: Check Reset button in Calendar form");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show add new calendar form
		*Input Data: 
			Click icon in Calendar pane and select Add Calendar
		*Expected Outcome: 
			Add new calendar form is shown*/
		 hp.goToCalendarPage();
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Check Reset button
		*Input Data: 
			- Input data form required field
			- Click Reset button
		*Expected Outcome: 
			- Add calendar form is reset with name & description is cleared
			- No calendar is added*/ 
		 String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
		 click(cMang.ELEMENT_CALENDAR_ADD_RESET_BUTTON);
		 String textDisplayName=waitForAndGetElement(cMang.ELEMENT_CALENDAR_DISPLAY_NAME_INPUT).getText();
		 String textDes=waitForAndGetElement(cMang.ELEMENT_CALENDAR_DESC_INPUT).getText();
		 cMang.cancelAddCalendar();
		 hp.goToCalendarPage();
	   	 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
		 if(textDisplayName.isEmpty()) assert true;
		 else assert false:"Display Name field is not cleared";
		 if(textDes.isEmpty()) assert true;
		 else assert false:"Description field is not cleared";
 	}

	/**
	*<li> Case ID:116498.</li>
	*<li> Test Case Name: Check Close and Cancel button in Calendar form.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CheckCloseAndCancelButtonInCalendarForm() {
		info("Test 8: Check Close and Cancel button in Calendar form");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show add new calendar form
		*Input Data: 
			Click icon in Calendar pane and select Add Calendar
		*Expected Outcome: 
			Add new calendar form is shown*/
		 hp.goToCalendarPage();
		 cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
		 
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add new group calendar
		*Input Data: 
			- Input data form required field
			- Click Cancel button or click on Close icon
		*Expected Outcome: 
			- Add new calendar form is closed
			- No calendar is created*/ 
		 String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		 cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
		 cMang.cancelAddCalendar();
		 hp.goToCalendarPage();
	   	 waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));

 	}}