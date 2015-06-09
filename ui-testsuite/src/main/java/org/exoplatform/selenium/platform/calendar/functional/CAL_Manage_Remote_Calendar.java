package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


	public class CAL_Manage_Remote_Calendar extends CAL_TestConfig_2{

	/**
	*<li> Case ID:116446.</li>
	*<li> Test Case Name: Add remote calendar in case invalid authentication user name and password.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddRemoteCalendarInCaseInvalidAuthenticationUserNameAndPassword() {
		info("Test 1: Add remote calendar in case invalid authentication user name and password");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Subscribe calendar info
		*Input Data: 
			- Click on the [v] above calendar list and select Remote Calendar
			- Chose Type option
			- Input Url
			- Click Save
		*Expected Outcome: 
			- Remote Calendar form displays validly*/
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url = calRemoteData.getSubcrisbeByIndex(0);
		hp.goToCalendarPage();
        cMang.addRemoteCalender(url, false,name,name);
        
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add remote calendar with invalid username and password
		*Input Data: 
			- Input required fields
			- Input user name and password does not correct 
			- Click Next
		*Expected Outcome: 
			- Alert message display to inform invalid authentication*/ 
        String username = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String password = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        cMang.addUserAuthentication(username, password);
        cMang.saveRemoteCalendar();
        
        waitForAndGetElement(cMang. ELEMENT_REMOTE_CALENDAR_WARNING_AUTHENTICATION);
        click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
        cMang.cancelRemoteCalendar();
        

 	}

	/**
	*<li> Case ID:116447.</li>
	*<li> Test Case Name: Check Back function when add a remote calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckBackFunctionWhenAddARemoteCalendar() {
		info("Test 2: Check Back function when add a remote calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Subscribe calendar info
		*Input Data: 
			- Click on the [v] above calendar list and select Remote Calendar
			- Chose Type option
			- Input Url
			- Click Next
		*Expected Outcome: 
			- Subscribe/ Remote Calendar form displays validly*/
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url = calRemoteData.getSubcrisbeByIndex(0);
		hp.goToCalendarPage();
        cMang.addRemoteCalender(url, false,name,name);
        
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Check back button
		*Input Data: 
			- Input required fields
			- Input user name and password does not correct 
			- Click Back button
		*Expected Outcome: 
			- All input data in remote calendar is kept*/ 
       cMang.backRemoteCalendar();
       String url_actual=waitForAndGetElement(cMang.ELEMENT_REMOTE_CALENDAR_URL).getAttribute("value").toString();
       info("url_actual:"+url_actual);
       click(cMang.ELMENT_REMOTE_CALENDAR_SUBCRIBE_CANCEL_BTN);
       if(!url_actual.isEmpty()) assert true;
       else assert false:"All input data in remote calendar is not kept";
 	}

	/**
	*<li> Case ID:116448.</li>
	*<li> Test Case Name: Check Auto Refresh function of remote calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED: BECAUSE CANNOT FIND AUTO REFRESH FUNCTION ON REMOTE CALENDAR
	*/
	@Test(groups="pending")
	public  void test03_CheckAutoRefreshFunctionOfRemoteCalendar() {
		info("Test 3: Check Auto Refresh function of remote calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Subscribe calendar info
		*Input Data: 
			- Click on the [v] above calendar list and select Remote Calendar
			- Chose Type option
			- Input Url
			- Click Next
		*Expected Outcome: 
			- Subscribe/ Remote Calendar form displays validly*/
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url = calRemoteData.getSubcrisbeByIndex(0);
		hp.goToCalendarPage();
        cMang.addRemoteCalender(url, false,name,name);
        
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add remote calendar with specific auto fresh value
		*Input Data: 
			- Input valid required fields
			- Select specific Auto fresh value
			- Click Save
		*Expected Outcome: 
			- Alert message to inform the remote calendar imported successfully*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check auto fresh function
		*Input Data: 
			- Input more event/task to the remote calendar
			-Check new task/event updated
		*Expected Outcome: 
			- After a period of time set in step 2, the event/task of the remote calendar is freshed automatically and displayed with valid info.*/ 

 	}

	/**
	*<li> Case ID:116449.</li>
	*<li> Test Case Name: Check Manual Refresh function of remote calendar.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED: BECAUSE CANNOT FIND Manual REFRESH FUNCTION ON REMOTE CALENDAR
	*/
	@Test(groups="pending")
	public  void test04_CheckManualRefreshFunctionOfRemoteCalendar() {
		info("Test 4: Check Manual Refresh function of remote calendar");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Subscribe calendar info
		*Input Data: 
			- Click on the [v] above calendar list and select Remote Calendar
			- Chose Type option
			- Input Url
			- Click Next
		*Expected Outcome: 
			- Subscribe/ Remote Calendar form displays validly*/
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url = calRemoteData.getSubcrisbeByRandom();
		hp.goToCalendarPage();
        cMang.addRemoteCalender(url, false,name,name);
        
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add remote calendar with specific auto fresh value
		*Input Data: 
			- Input valid required fields
			- Select specific Auto fresh value
			- Click Save
		*Expected Outcome: 
			- Alert message to inform the remote calendar imported successfully*/

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Check auto fresh function
		*Input Data: 
			- Input more event/task to the remote calendar
			-Right click on the remote imported calendar and click Refresh button
		*Expected Outcome: 
			- After a period of time set in step 2, the event/task of the remote calendar is freshed and displayed with valid info.*/ 

 	}

	/**
	*<li> Case ID:116490.</li>
	*<li> Test Case Name: Add remote calendar with ics type in case valid data entry.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_AddRemoteCalendarWithIcsTypeInCaseValidDataEntry() {
		info("Test 5: Add remote calendar with ics type in case valid data entry");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open Subscribe Calendar form and select ics type
		*Input Data: 
			- Click on the [v] above calendar list and select Remote Calendar
			- Click ics option
		*Expected Outcome: 
			- Subscribe Calendar form displays validly
			- Ics type can be selected*/
		
        
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Input ics url
		*Input Data: 
			- Copy and input valid url linkE.g: http://www.google.com/calendar/ical/th4nhc0n9%40gmail.com/private
			-5b415850d4c073ca12d2df6ff2cfafe6/basic.ics
		*Expected Outcome: 
			- The url can be input validly*/
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url = calRemoteData.getSubcrisbeByIndex(0);
		hp.goToCalendarPage();
        cMang.addRemoteCalender(url, false,name,name);
        
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Complete adding Remote Calendar
		*Input Data: 
			- Click Next
			- Input Display Name
			- Select Color
			- Input User name & Password
			- Click Save
		*Expected Outcome: 
			- Remote Calendar form is display with valid info
			- Remote calendar information can be input validly
			- Alert message is displayed remote calendar added successfully*/
        String username = "fqaexovn";
        String password = EMAIL_PASS;
        cMang.changeColorRemoteCalendar("blue_gray");
        cMang.addUserAuthentication(username, password);
        cMang.saveRemoteCalendar();
        
    	hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",name));

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check the imported calendar from the remote one
		*Input Data: 
			- Focus on the Calendar list
			- Focus calendar Panel and click on imported event/task
		*Expected Outcome: 
			- The calendar is imported with correct name and color
			- Event/Task is imported/displayed with exact information*/ 
		
		info("Export calendar");
		String attachment=getRandomNumber()+".ics";
		cMang.exportCalendar(name,attachment);
		cMang.deleteCalendar(name,true);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", name));

		info("Import calendar");
		cMang.importCalendar("TestData/TestOutput/" + attachment,name,null,null);

		info("Check inported calendar ");
		driver.navigate().refresh();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", name));
		
		info("Delete data test");
   		cMang.deleteCalendar(name, true);
        
 	}

	/**
	*<li> Case ID:116491.</li>
	*<li> Test Case Name: Add remote calendar with calDav type in case valid data entry.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_AddRemoteCalendarWithCalDavTypeInCaseValidDataEntry() {
		info("Test 6: Add remote calendar with calDav type in case valid data entry");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open Subcrible Calendar form and select CalDav type
		*Input Data: 
			- Click on the [v] above calendar list and select Remote Calendar
			- Click CalDav option
		*Expected Outcome: 
			- Subscribe Calendar form displays validly
			- CalDav type can be selected*/
		
		
		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Input CalDav url
		*Input Data: 
			- Copy and input valid url linkE.g:
			Google Caldav link:https://www.google.com/calendar/dav/your_gmail_account@gmail.com/events/
			Yahoo Calendar link:https://caldav.calendar.yahoo.com/dav/your_yahoo_account@yahoo.com/Calendar/calendar_name/
		*Expected Outcome: 
			- The url can be input validly*/
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url = calRemoteData.getSubcrisbeByIndex(1);
		hp.goToCalendarPage();
        cMang.addRemoteCalender(url, false,name,name,1);
        
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Complete adding Remote Calendar
		*Input Data: 
			- Click Next
			- Input Display Name
			- Select Color
			- Input User name & Password
			- Click Save
		*Expected Outcome: 
			- Remote Calendar form is display with valid info
			- Remote calendar information can be input validly
			- Alert message is displayed remote calendar added successfully*/
        String username = "fqaexovn";
        String password = EMAIL_PASS;
        cMang.changeColorRemoteCalendar("blue_gray");
        cMang.addUserAuthentication(username, password);
        cMang.saveRemoteCalendar();
        
    	hp.goToCalendarPage();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar",name));
		
		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Check the imported calendar from the remote one
		*Input Data: 
			- Focus on the Calendar list
			- Focus calendar Panel and click on imported event/task
		*Expected Outcome: 
			- The calendar is imported with correct name and color
			- Event/Task is imported/displayed with exact information*/ 
		
		info("Export calendar");
		String attachment=getRandomNumber()+".ics";
		cMang.exportCalendar(name,attachment);
		cMang.deleteCalendar(name,true);
		waitForElementNotPresent(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", name));

		info("Import calendar");
		cMang.importCalendar("TestData/TestOutput/" + attachment,name,null,null);

		info("Check inported calendar ");
		driver.navigate().refresh();
		waitForAndGetElement(cMang.ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", name));
		
		info("Delete data test");
   		cMang.deleteCalendar(name, true);
 	}

	/**
	*<li> Case ID:116492.</li>
	*<li> Test Case Name: Add remote calendar in case input invalid url.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_AddRemoteCalendarInCaseInputInvalidUrl() {
		info("Test 7: Add remote calendar in case input invalid url");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open Subscribe Calendar form and select CalDav type
		*Input Data: 
			- Click on the [v] above calendar list and select Remote Calendar
		*Expected Outcome: 
			- Subscribe Calendar form displays validly
			- CalDav type can be selected*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Input invalid url
		*Input Data: 
			- Leave Url field blank or input invalid url
			- Click Next
		*Expected Outcome: 
			- The url can be input validly
			- Arlert message displays to require valid url input*/ 
		String url = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.REMOTECAL);
        info("Select CalDav type");
        check(cMang.ELEMENT_REMOTE_CALENDAR_ICALENDAR_RADIO,2);
        info("Input url link");
        type(cMang.ELEMENT_REMOTE_CALENDAR_URL,url,true);
        info("Click on Next button");
		click(cMang.ELMENT_REMOTE_CALENDAR_NEXT_BTN);
		info("Verify the alert message");
		waitForAndGetElement(cMang.ELEMENT_REMOTE_CALENDAR_WARNING_INVALID_URL);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
		click(cMang.ELMENT_REMOTE_CALENDAR_SUBCRIBE_CANCEL_BTN);
 	}

	/**
	*<li> Case ID:116493.</li>
	*<li> Test Case Name: Add remote calendar in case do not input required field in the Remote Calendar form.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_AddRemoteCalendarInCaseDoNotInputRequiredFieldInTheRemoteCalendarForm() {
		info("Test 8: Add remote calendar in case do not input required field in the Remote Calendar form");
		/*Step Number: 1
		*Step Name: Step 1: Add Subscribe calendar info
		*Step Description: 
			- Click on the [v] above calendar list and select Remote Calendar
			- Chose Type option
			- Input Url
			- Click Next
		*Input Data: 
			
		*Expected Outcome: 
			- Subscribe/ Remote Calendar form displays validly*/
		
		/*Step number: 2
		*Step Name: Step 2: Add remote calendar in case do not input required field
		*Step Description: 
			- Leave required fields: Display Name, Username
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Alert messages are displayed:
			- If both "Display Name" and "Username" are blank => Error message: The field "Display Name" is required.
			- If only "Username" is blank => Error message: Username required to authenticated
			- If only "Display Name" is blank => Error message: The field "Display Name" is required.*/ 
		String url = calRemoteData.getSubcrisbeByIndex(0);
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToCalendarPage();
        cMang.addRemoteCalender(url, false,"","");
        cMang.saveRemoteCalendar();
        
        info("Verify the alert message");
		waitForAndGetElement(cMang.ELEMENT_REMOTE_CALENDAR_WARNING_EMPTY_DISPLAY_NAME);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
		
		info("Type a name");
		type(cMang.ELEMENT_REMOTE_CALENDAR_NAME,name,true);
		cMang.saveRemoteCalendar();
		
	    info("Verify the alert message");
		waitForAndGetElement(cMang.ELEMENT_REMOTE_CALENDAR_WARNING_EMPTY_USERNAME);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
		
		info("Cleare name");
		waitForAndGetElement(cMang.ELEMENT_REMOTE_CALENDAR_NAME).clear();
		cMang.saveRemoteCalendar();
		
		info("Verify the alert message");
		waitForAndGetElement(cMang.ELEMENT_REMOTE_CALENDAR_WARNING_EMPTY_DISPLAY_NAME);
		click(cMang.ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP);
		cMang.cancelRemoteCalendar();
 	}}