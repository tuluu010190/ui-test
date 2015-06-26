package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import java.awt.AWTException;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Manage_Personal_Calendar extends CAL_TestConfig_2{

	/**
	*<li> Case ID:116289.</li>
	*<li> Test Case Name: Default User's Calendar Name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DefaultUsersCalendarName() {
		info("Test 1: Default User's Calendar Name");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Log in to Calendar as adminEg root
			- See Default User's Calendar Name in Personal calendar list
		*Input Data: 
			
		*Expected Outcome: 
			Default User's Calendar Name is displayed as the user's full name, eg Root Root*/
		hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",DATA_NAME_USER1));

 	}

	/**
	*<li> Case ID:116329.</li>
	*<li> Test Case Name: Remove a personal calendar  from left pane.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_RemoveAPersonalCalendarFromLeftPane() {
		info("Test 2: Remove a personal calendar  from left pane");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create calendar and add task/event inside
		*Input Data: 
			- Create a personal calendar [ Details ]
			- Add some tasks/events inside[ Details
		*Expected Outcome: 
			The added calendar with tasks/events is displayed in the personal list*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Add an Event");
		String titleEvent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(titleEvent, content,calendar);
		evMg.saveQuickAddEvent();
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Remove calendar
		*Input Data: 
			- Right click on added calendar and select Remove
			- Click OK to confirm
		*Expected Outcome: 
			- Calendar is removed from personal calendar list
			- All tasks/events of this deleted calendar arealso removed.*/ 
		cMang.deleteCalendar(calendar, true);
		cHome.verifyIsNotPresentEventTask(titleEvent, selectViewOption.LIST, selectDayOption.DETAILTIME);

 	}

	/**
	*<li> Case ID:116384.</li>
	*<li> Test Case Name: Add new calendar with valid information.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_AddNewCalendarWithValidInformation() {
		info("Test 3: Add new calendar with valid information");
		/*Step Number: 1
		*Step Name: Step 1: Add calendar
		*Step Description: 
			Click Calendar action icon and select Add calendar
		*Input Data: 
			
		*Expected Outcome: 
			Add new calendar form is shown*/
		
		/*Step number: 2
		*Step Name: Step 2: Add calendar with valid information
		*Step Description: 
			- Input valid values for all fields in Calendar details tab 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Calendar is saved successfully and listed in personal calendar box*/ 
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116450.</li>
	*<li> Test Case Name: Edit a personal calendar with valid value.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_EditAPersonalCalendarWithValidValue() {
		info("Test 4: Edit a personal calendar with valid value");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show edit personal calendar form
		*Input Data: 
			- Create new personal calendar[ Details ]
			- Right click on the calendar and select Edit
		*Expected Outcome: 
			- Edit personal calendar form is shown Calendar details tab only, Groups tab is hidden
			- Current informations of that calendar are displayed in form*/
		
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Complete editing personal calendar
		*Input Data: 
			- Make changes (name, description color)
			- Click Save
		*Expected Outcome: 
			- Changes are saved
			- The calendar will be updated with new value*/ 
   		String calendar1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
   		cMang.editCalendar(calendar, calendar1, calendar1,"light_blue",null);
   		cMang.saveAddCalendar();
   	    hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar1));
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM_COLOR.replace("$calendar",calendar1).replace("$color","light_blue"));
		cMang.deleteCalendar(calendar1, true);
	}

	/**
	*<li> Case ID:116451.</li>
	*<li> Test Case Name: Edit a personal calendar with invalid value.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_EditAPersonalCalendarWithInvalidValue() {
		info("Test 5: Edit a personal calendar with invalid value");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show edit personal calendar form
		*Input Data: 
			- Create new personal calendar[ Details ]
			- Right click on the calendar and select Edit
		*Expected Outcome: 
			- Edit personal calendar form is shown Calendar details tab only, Groups tab is hidden
			- Current informations of that calendar are displayed in form*/
		info("Create a new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Edit calendar with invalid value
		*Input Data: 
			- Input into required fields in Calendar details tab only by special characters (!@#$%^&*;:' â€œ<> / )/Unicode
			- Click Save
		*Expected Outcome: 
			Show message to inform about the invalid calendar name*/ 
   		String calendar1 = "!@#$%^&*;:' â€œ<> /";
   		cMang.editCalendar(calendar, calendar1, calendar1,"light_blue",null);
   		cMang.saveAddCalendar();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_WARINING_POPUP);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
		cMang.cancelAddCalendar();
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116457.</li>
	*<li> Test Case Name: Enable public access to Personal Calendar URL.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_EnablePublicAccessToPersonalCalendarURL() {
		info("Test 6: Enable public access to Personal Calendar URL");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Enable public access to Personal Calendar URL
		*Input Data: 
			- Login as Root successfully
			- Go to Calendar
			- Right click on Personal Calendar
			- Click on Edit
			- Click on Enable Public Access link
		*Expected Outcome: 
			- Enable Public Access link (blue
			-highlighted) can be clicked
			- After the click, message shown on screen is â€œThis calendar is public accessâ€.*/ 
		info("Create new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Edit the calendar");
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		cMang.enabledPublicAccess(calendar);
   		cMang.saveAddCalendar();
		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116458.</li>
	*<li> Test Case Name: View shared Personal Calendar by public link of CS.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	 * @throws InterruptedException 
	 * @throws AWTException 
	*/
	@Test
	public  void test07_ViewSharedPersonalCalendarByPublicLinkOfCS() throws AWTException, InterruptedException {
		info("Test 7: View shared Personal Calendar by public link of CS");
		/*Step Number: 1
		*Step Name: - Step 1: Make public fora personal calendar
		*Step Description: 
			-Show edit form of a personal calendar by choosing "Edit" action
			- Click "Enable public access"
			- Click Save button
		*Input Data: 
			
		*Expected Outcome: 
			Personal calendar is public*/
		info("Create new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        info("Edit the calendar");
        hp.goToCalendarPage();
   		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",calendar));
   		cMang.enabledPublicAccess(calendar);
   		String urlPublic=cMang.getPublicAccessLink(calendar);
   		cMang.saveAddCalendar();
   		String removeCharacter;
   		String nameCalendar;
   		if(!urlPublic.isEmpty()){
   			removeCharacter=urlPublic.replace("(","").replace(")","");
   	   		nameCalendar=removeCharacter.split("john/")[1].split("/")[0];
   	     	magAc.signOut();
   	       //Run the download link
   			this.driver.get(removeCharacter);
   			//downloadFileUsingRobotViaURL();
   		    checkFileExisted("TestOutput/" + nameCalendar);
   		    magAc.signIn(DATA_USER1, DATA_PASS);
   		}
		
		/*Step number: 2
		*Step Name: Step 2: View the public personal Calendar by public link
		*Step Description: 
			- Log out
			- Open the public link
		*Input Data: 
			
		*Expected Outcome: 
			Display alert message to open or save file.ics*/ 
   		
   		hp.goToCalendarPage();
   		cMang.deleteCalendar(calendar, true);
 	}

	/**
	*<li> Case ID:116499.</li>
	*<li> Test Case Name: Add new calendar with invalid value.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_AddNewCalendarWithInvalidValue() {
		info("Test 8: Add new calendar with invalid value");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Show add new calendar form
		*Input Data: 
			Click Calendar action icon and select Add calendar
		*Expected Outcome: 
			Add new calendar form is shown,*/
		info("Create new calendar");
		String calendar = "!@#$%^&*;:' â€œ<> /";
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add calendar with invalid value
		*Input Data: 
			- Input into required fields in Calendar details tab only by special characters (!@#$%^&*;:' â€œ<> / )/Unicode
			- Click Save
		*Expected Outcome: 
			Show message to inform about the invalid calendar name*/ 

        waitForAndGetElement(cMang.ELEMENT_CALENDAR_WARINING_POPUP);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
		cMang.cancelAddCalendar();
 	}

	/**
	*<li> Case ID:116500.</li>
	*<li> Test Case Name: Add new calendar with duplicated name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_AddNewCalendarWithDuplicatedName() {
		info("Test 9: Add new calendar with duplicated name");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add calendar
		*Input Data: 
			Click Calendar action icon and select Add calendar
		*Expected Outcome: 
			Add new calendar form is shown*/
		info("Create new calendar");
		String calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();

        /*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add calendar with duplicated name
		*Input Data: 
			- Input a duplicated name for Display name field
			- Input values for other required fields in Calendar details tab 
			- Click Save
		*Expected Outcome: 
			Show message to inform about the duplicated calendar name.*/ 
        info("Create new calendar");
        hp.goToCalendarPage();
        cHome.goToView(selectViewOption.WEEK);
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        waitForAndGetElement(cMang.ELEMENT_CALENDAR_WARINING_POPUP);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
		cMang.cancelAddCalendar();
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar, true);
 	}}