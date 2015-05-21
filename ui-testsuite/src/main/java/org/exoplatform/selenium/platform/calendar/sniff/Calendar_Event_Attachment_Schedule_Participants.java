/**
 * Generated by thuntn at 2014/08/06 13:50:23
 *
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.selenium.platform.calendar.sniff;



import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.ManageAccount.userType;
import org.exoplatform.selenium.platform.calendar.CalendarBase;
import org.exoplatform.selenium.platform.calendar.Event;
import org.exoplatform.selenium.platform.calendar.Task;
import org.exoplatform.selenium.platform.social.PeopleProfile;
import org.openqa.selenium.By;
import org.testng.annotations.*;

/**
 * @author thuntn
 *
 */
public class Calendar_Event_Attachment_Schedule_Participants extends CalendarBase{

	ManageAccount acc;
	Event event;
	Task task;
	NavigationToolbar nav;
	PeopleProfile pepPro;

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		acc = new ManageAccount(driver, this.plfVersion);
		event = new Event(driver, this.plfVersion);
		task = new Task(driver, this.plfVersion);
		acc.signIn(DATA_USER1, DATA_PASS);
		button = new Button(driver, plfVersion);
		nav = new NavigationToolbar(driver, this.plfVersion);
		pepPro = new PeopleProfile(driver);
		goToCalendarPage();
		setTimezoneForCalendar("(GMT +07:00) Asia/Ho_Chi_Minh");
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	/**
	 *<li> Case ID:111863.</li>
	 *     Case ID:111864
	 *<li> Test Case Name: Add attachment to event.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *<li> Done with OSs and browsers : </li>
	 *<li> Generated by thuntn at 2014/08/06 13:50:23</li>
	 */
	@Test
	public  void test01_02_AddAndRemoveAttachmentToEvent() {
		info("Test 1: Add attachment to event");
		String name = "Event111863";
		/*Step Number: 12
		 *Step Name: Step 1: Open Add event form
		 *- Select a calendar, Click Setting icon of this calendar and choose [Add Event] or Click Event button on action bar
		  - Input start and end time
		  - Click [More Details]
		 *Expected Outcome: 
		  - Add/Edit Event pop-up has 4 tabs 
		  - Details
		  - Reminders
		  - Participants
		  - Schedule
		 *Step 2: Add attachment
		 *Step Description: 
			- Select a calendar, Click Setting icon of this calendar and choose [Add Event] or Click Event button on action bar
			- Input start and end time
			- Click [More Details
			- Click [Add Attachment]
			- Browse to file and click save
		 *Input Data: 

		 *Expected Outcome: 
			- Attachment is added to event*/ 
		event.goToAddEventFromActionBar();
		event.inputBasicQuickEvent(name, name);
		click(event.ELEMENT_ADD_EVENT_MORE_DETAILS_BUTTON);
		event.inputOtherFieldsTabDetailsEvent(null, "TestData/English.docx");
		click(event.ELEMENT_ADD_EVENT_SAVE_BUTTON);
		/*CaseID: 111864
		 * Step 2: Remove attachment
		 *Step Description: 
			- Go to calendar
			- Select event which has attachment and edit
			- Click [Delete] icon
			- Click Save
		 *Input Data: 

		 *Expected Outcome: 
			- Edit form appears
			- Attachment is deleted*/ 
		Utils.pause(3000);
		event.goToEditEventForm(name);
		click(event.ELEMENT_ADD_EVENT_DELETE_ATTACH.replace("${file}", "English.docx"));
		waitForElementNotPresent(event.ELEMENT_ADD_EVENT_FILE_ATTACHED);
		Utils.pause(3000);
		click(event.ELEMENT_ADD_EVENT_SAVE_BUTTON);

		event.deleteEventTask(name);
	}

	/**
	 *<li> Case ID:109868: Add a participant.</li>
	 *	   Case ID:111858:Check privacy.
	 *     Case ID:109869: Send invitation.
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *<li> Done with OSs and browsers : </li>
	 *<li> Generated by thuntn at 2014/08/06 13:51:06</li>
	 */
	@Test
	public  void test03_04_05_AddAParticipantAndSendInvitationAndCheckPrivacy() {
		info("Test 3: Add a participant");
		String name = "Event109868";
		String mainHandle = driver.getWindowHandle();
		acc.userSignIn(userType.PUBLISHER);
		nav.goToMyProfile();
		info("edit profile");
		click(pepPro.ELEMENT_EDIT_MY_PROFILE_LINK);
		info("edit info");
		pepPro.updateBasicInformation(null, null, EMAIL_ADDRESS1);
		pepPro.saveCancelUpdateInfo(true);
	
		acc.userSignIn(userType.ADMIN); 
		goToCalendarPage();
		/*Step Number: 12
		 *Step Name: Step 1: Open add/edit event pop up
		 *Step 2: Add participant
		 *Step Description: 
			- Select a calendar, Click Setting icon of this calendar and choose [Add Event] or Click Event button on action bar
			- Click [More Details]
			- Click [Participants] tab
			- Select Privacy, Available 
			- Click [Add Participant] icon (+)
			- Pick some users
			- Fill Invitation message
			- Click Save
			- Select 1 option for Send Invitations
			- Save
		 *Input Data: 

		 *Expected Outcome: 
			Add/Edit Event pop
			-up has 4 tabs 
			- Details
			- Reminders
			- Participants
			- Schedule
			- Selected users are listed on the table with 3 column + Name: participant fullname + Information: participant email + Status: participant status yes/no/not sure + Cction with remove icon
			- Event is created with added participants */
		event.goToAddEventFromActionBar();
		event.inputBasicQuickEvent(name, name);
		click(event.ELEMENT_ADD_EVENT_MORE_DETAILS_BUTTON);
		event.inputParticipantTab("mary",2,1,2);
		click(event.ELEMENT_ADD_EVENT_SAVE_BUTTON);
		Utils.pause(3000);
		acc.userSignIn(userType.PUBLISHER);
		goToCalendarPage();

		/*Case ID:109869
		 * Automatically send the invitation mail to the participants.
		 * Their statuses will be updated in the Status column after they have answered the invitations via emails.
		 * If the participants agree to participate (by clicking Yes in their received invitation emails), their statuses will be yes.
		 * If the participants do not agree to participate (by clicking No), their statuses will be no.
		 * If the participants have not decided to take part in the event (by clicking Not sure), their statuses will be pending.*/
		Utils.pause(3000);
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		String mailHandle = driver.getWindowHandle();
		Utils.pause(3000);
		click(By.xpath(ELEMENT_GMAIL_TITLE.replace("{$title}", "[Invitation] "+ name)),300000);
		click(By.linkText("Yes"));

		/*Case ID:111858.
		 * - Event is saved with new privacy option */
		driver.switchTo().window(mainHandle);
		Utils.pause(3000);
		event.goToEditEventForm(name);
		click(event.ELEMENT_PARTICIPANTS_TAB);
		info("check is "+waitForAndGetElement(event.ELEMENT_PARTICIPANT_PRIVATE_RADIO,DEFAULT_TIMEOUT,1,2).getAttribute("checked"));
		waitForAndGetElement(event.ELEMENT_PARTICIPANT_PRIVATE_RADIO,DEFAULT_TIMEOUT,1,2).getAttribute("checked").equalsIgnoreCase("true");
		waitForAndGetElement(event.ELEMENT_PARTICIPANT_STATUS.replace("${user}", "Mary Williams")).getText().contains("Yes");
		click(event.ELEMENT_ADD_DETAIL_EVENT_CLOSE);

		driver.switchTo().window(mailHandle);
		click(By.linkText("Not sure"));

		driver.switchTo().window(mainHandle);
		event.goToEditEventForm(name);
		click(event.ELEMENT_PARTICIPANTS_TAB);
		waitForAndGetElement(event.ELEMENT_PARTICIPANT_STATUS.replace("${user}", "Mary Williams")).getText().contains("Pending");
		click(event.ELEMENT_ADD_DETAIL_EVENT_CLOSE);

		driver.switchTo().window(mailHandle);
		click(By.linkText("No"));

		driver.switchTo().window(mainHandle);
		event.goToEditEventForm(name);
		click(event.ELEMENT_PARTICIPANTS_TAB);
		waitForAndGetElement(event.ELEMENT_PARTICIPANT_STATUS.replace("${user}", "Mary Williams")).getText().contains("No");
		click(event.ELEMENT_ADD_DETAIL_EVENT_CLOSE);

		event.deleteEventTask(name);
		driver.switchTo().window(mailHandle);
		click(ELEMENT_DELETE_MAIL_2);
	}

	/**
	 *<li> Case ID:111859: Check start/end time of event on schedule.</li>
	 *	   Case ID:111861: Edit schedule of event.
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *<li> Done with OSs and browsers : </li>
	 *<li> Generated by thuntn at 2014/08/06 13:52:02</li>
	 */
	@Test
	public  void test06_07_CheckAndEditStartendTimeOfEventOnSchedule() {
		info("Test 6: Check start/end time of event on schedule");
		String name = "Event109868";
		String from = getCurrentDate("MM/dd/yyyy") + " 06:00";
		String to = getCurrentDate("MM/dd/yyyy") + " 07:00";
		/*Step Number: 12
		 *Step Name: Step 1: Open add/edit event pop up
		 *Step 2: Add aprticipant
		 *Step Description: 
			- Select a calendar, Click Setting icon of this calendar and choose [Add Event] or Click Event button on action bar
			- Input start and end time
			- Click [More Details]
			- Click [Schedule] tab
			- Check time on schedule tab
		 *Input Data: 

		 *Expected Outcome: 
			Add/Edit Event pop
			-up has 4 tabs 
			- Details
			- Reminders
			- Participants
			- Schedule
			- Time on schedule tab is correct (input at step 1)*/ 

		event.goToAddEventFromActionBar();
		event.inputBasicQuickEvent(name, name);
		event.inputFromToEvent(from,to,false);
		click(event.ELEMENT_ADD_EVENT_MORE_DETAILS_BUTTON);
		click(event.ELEMENT_SCHEDULE_TAB);
		assert waitForAndGetElement("//td[26]").getAttribute("class").contains("userSelection");
		assert waitForAndGetElement("//td[27]").getAttribute("class").contains("userSelection");
		assert waitForAndGetElement("//td[28]").getAttribute("class").contains("userSelection");
		assert waitForAndGetElement("//td[29]").getAttribute("class").contains("userSelection");

		dragAndDropToObject(event.ELEMENT_SCHEDULE_DRAG.replace("${index}", "30"), event.ELEMENT_SCHEDULE_DRAG.replace("${index}", "33"));
		assert waitForAndGetElement("//td[30]").getAttribute("class").contains("userSelection");
		assert waitForAndGetElement("//td[31]").getAttribute("class").contains("userSelection");
		assert waitForAndGetElement("//td[32]").getAttribute("class").contains("userSelection");
		assert waitForAndGetElement("//td[33]").getAttribute("class").contains("userSelection");
		assert waitForAndGetElement(event.ELEMENT_SCHEDULE_FROM_TIME_INPUT).getAttribute("value").equals("07:00") : "Wrong update from time";
		assert waitForAndGetElement(event.ELEMENT_SCHEDULE_TO_TIME_INPUT).getAttribute("value").equals("08:00") : "Wrong update to time";

		click(event.ELEMENT_ADD_EVENT_DETAIL_TAB);
		assert waitForAndGetElement(event.ELEMENT_ADD_EDIT_EVENT_FROM_TIME_IN).getAttribute("value").equals("07:00") : "Wrong update from time";
		assert waitForAndGetElement(event.ELEMENT_ADD_EDIT_EVENT_TO_TIME_IN).getAttribute("value").equals("08:00") : "Wrong update to time";
	}

	/**
	 *<li> Case ID:111862.</li>
	 *<li> Test Case Name: Check busy time on schedule tab.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *<li> Done with OSs and browsers : </li>
	 *<li> Generated by thuntn at 2014/08/06 13:52:02</li>
	 */
	@Test
	public  void test08_CheckBusyTimeOnScheduleTab() {
		info("Test 3: Check busy time on schedule tab");
		String name = "Event111862";
		String from = getCurrentDate("MM/dd/yyyy") + " 09:00";
		String to = getCurrentDate("MM/dd/yyyy") + " 10:00";
		/*Step Number: 12
		 *Step Name: Step 1: Add new event
		 *Step 2: Add participant to event
		 *Step Description: 
			- Login as John for ex
			- Go to Calendar
			- Click [Event] or right click 
			-
			-> [New Event]
			- Input start and end time: from 9h00 to 10h00 for example
			- Click Save
			- Login as other user (Jack for ex)
			- Go to Calendar
			- Click [Event] or right click, select [Event]
			- Click [More details], open Schedule tab
			- Click Add participant and select John to add
		 *Input Data: 

		 *Expected Outcome: 
			- New event is added successfully
			- John is displayed in list with busy time is same as event created at step 1*/ 
		acc.userSignIn(userType.PUBLISHER);
		goToCalendarPage();
		setTimezoneForCalendar("(GMT +07:00) Asia/Ho_Chi_Minh");
		event.addQuickEvent(name, name, from, to, false);
		acc.userSignIn(userType.ADMIN);
		goToCalendarPage();
		event.goToAddEventFromActionBar();
		event.inputBasicQuickEvent(name, name);
		click(event.ELEMENT_ADD_EVENT_MORE_DETAILS_BUTTON);
		event.inputParticipantTab("mary", 2);

		click(event.ELEMENT_SCHEDULE_TAB);
		Utils.pause(3000);
		assert waitForAndGetElement(event.ELEMENT_SCHEDULE_TIME.replace("${user}", "mary").replace("${index}", "38")).getAttribute("class")
		.contains("busyDotTime"):"Wrong busy time";
		assert waitForAndGetElement(event.ELEMENT_SCHEDULE_TIME.replace("${user}", "mary").replace("${index}", "39")).getAttribute("class")
		.contains("busyDotTime"):"Wrong busy time";
		assert waitForAndGetElement(event.ELEMENT_SCHEDULE_TIME.replace("${user}", "mary").replace("${index}", "40")).getAttribute("class")
		.contains("busyDotTime"):"Wrong busy time";
		assert waitForAndGetElement(event.ELEMENT_SCHEDULE_TIME.replace("${user}", "mary").replace("${index}", "41")).getAttribute("class")
		.contains("busyDotTime"):"Wrong busy time";

		click(event.ELEMENT_ADD_DETAIL_EVENT_CLOSE);
		acc.userSignIn(userType.PUBLISHER);
		goToCalendarPage();
		event.deleteEventTask(name);
	}
}