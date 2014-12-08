package org.exoplatform.selenium.platform.calendar;

import static org.exoplatform.selenium.TestLogger.info;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarHomePage extends PlatformBase{

	PlatformPermission per;
	ManageAlert alert;
	//Calendar panel
	public final By ELEMENT_CALENDAR_WORKING_PANEL = By.id("UICalendarWorkingContainer");
	public final String ELEMENT_CELL_TO_WORKING_PANEL = "//td[contains(@startfull,'$date $time:00')]";

	//View button
	public final String ELEMENT_CALENDAR_VIEW_BUTTON = "//*[text()='$view']";
	public final String ELEMENT_CALENDAR_ACTIVE_VIEW = "//*[@class='btn active']//*[text()='$view']";

	//Day View
	public final String ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ALL_DAY="//*[@id='UIDayView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(.,'$name')]";
	public final String ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ONE_DAY="//*[@id='UIDayViewGrid']//div[contains(text(),'$name')]";

	//Week View
	public final String ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ALL_DAY="//*[@id='UIWeekView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(.,'$name')]";
	public final String ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ONE_DAY="//*[@id='UIWeekViewGrid']//div[contains(text(),'$name')]";

	//Month View
	public final String ELEMENT_EVENT_TASK_EVENT_MONTH_VIEW="//*[@id='UIMonthView']//*[@class='eventSummary']//*[contains(text(),'$name')]";

	//List View
	public final String ELEMENT_EVENT_TASK_EVENT_LIST_VIEW="//*[@id='UIListView']//*[@class='uiListViewRow']//*[contains(text(),'$name')]";

	//Work Week View
	public final String ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ALL_DAY="//*[@id='UIWeekView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY="//*[@id='UIWeekView']//div[contains(text(),'$name')]";

	//Menu to create task or event
	public By ELEMENT_RIGHT_CLICK_ADD_TASK = By.xpath("//*[@id='tmpMenuElement']//*[@class='createTask']");
	public By ELEMENT_RIGHT_CLICK_ADD_EVENT = By.xpath("//*[@id='tmpMenuElement']//*[@class='createEvent']");

	//Action menu of task/event
	public By ELEMENT_EVENT_TASK_DELETE_MENU = By.xpath("//div[@id='tmpMenuElement']//a[@class='eventAction' and contains(@href,'Delete')]");
	public By ELEMENT_EVENT_TASK_EDIT_MENU = By.xpath("//div[@id='tmpMenuElement']//a[@class='eventAction' and contains(@href,'Edit')]");
	public By ELEMENT_EVENT_TASK_VIEW_MENU = By.xpath("//div[@id='tmpMenuElement']//a[@class='eventAction' and contains(@href,'View')]");
	public By ELEMENT_EVENT_TASK_EXPORT_MENU = By.xpath("//div[@id='tmpMenuElement']//a[@class='eventAction' and contains(@href,'Export')]");

	//Button add task/event
	public By ELEMENT_BUTTON_TASK = By.id("UIActionBarQuickAddTask");
	public By ELEMENT_BUTTON_EVENT = By.id("UIActionBarQuickAddEvent");

	//Popup to add/edit task/event
	public By ELEMENT_QUICK_ADD_TASK_POPUP = By.id("UIQuickAddTaskPopupWindow");
	public By ELEMENT_ADD_EDIT_TASK_POPUP = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Add/Edit Tasks']");
	
	//Resize task or event
	public String ELEMENT_RESIZE_CONTAINER = "//*[contains(text(),'$name')]/../..//*[@class='resizeEventContainer']";
	
	//Delete task/event
	public String ELEMENT_CONFIRM_DELETE_TASK_MSG = "Are you sure you want to delete this task?";
	public String ELEMENT_CONFIRM_DELETE_EVENT_MSG = "Are you sure you want to delete this event?";

	/**
	 * constructor
	 * @param dr
	 */
	public CalendarHomePage(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
	}

	/**
	 * 
	 * @param date
	 * 				date to create task
	 * 				format: MM/dd/yyyy (Ex: 12/09/2014)
	 * @param time
	 * 				time to create task
	 * 				format: hh:mm (Ex: 12:30)
	 */
	public void goToAddTaskFromMainPanel(String date, String time){
		info("Go to add task by right clicking from main panel");
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("MMM dd yyyy");
		String tempDate2 = getCurrentDate("MMM dd yyyy");
		Date tempDate1 = null;
		String tempTime = getCurrentDate("HH")+":00";

		info("Get date");
		if(date!=null && date!=""){
			try {
				tempDate1 = format1.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			tempDate2 = format2.format(tempDate1);
			info("Selected date is " + tempDate2);
		}
		else{
			tempDate2 = getCurrentDate("MMM dd yyyy");
			info("Selected date is current date" + tempDate2);
		}

		info("Get time");
		if(time!=null && time!=""){
			tempTime = time;
			info("Selected date is " + tempTime);
		}
		else{
			tempTime = getCurrentDate("HH")+":00";
			info("Selected date is current date" + tempTime);
		}

		String cell = ELEMENT_CELL_TO_WORKING_PANEL.replace("$date", tempDate2).replace("$time", tempTime);
		rightClickOnElement(cell);
		click(ELEMENT_RIGHT_CLICK_ADD_TASK);
		waitForAndGetElement(ELEMENT_QUICK_ADD_TASK_POPUP);
	}

	/**
	 * Open "Add new task" form from action bar
	 * 
	 */
	public void goToAddTaskFromActionBar(){
		info("Go to Add Task page from action bar"); 
		click(ELEMENT_BUTTON_TASK);
		waitForAndGetElement(ELEMENT_QUICK_ADD_TASK_POPUP);
	}

	/**
	 * View list in calendar
	 */
	public enum selectViewOption{
		DAY, WEEK, LIST, MONTH, WORKWEEK;
	}

	/**
	 * Select an option when creating an Event/Task: ONE DAY or ALL DAY  
	 */
	public enum selectDayOption{
		ONEDAY, ALLDAY;
	}
	/**
	 * Go to a view from calendar panel
	 * @param view
	 * 				name of view: get value from selectViewOption
	 */
	public void goToView(selectViewOption view){
		info("Go to view "+ view);
		switch(view){
		case DAY:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Day"));
			waitForAndGetElement(ELEMENT_CALENDAR_ACTIVE_VIEW.replace("$view", "Day"));
			break;
		case WEEK:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Week"));
			waitForAndGetElement(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Week"));
			break;
		case LIST:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "List"));
			waitForAndGetElement(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "List"));
			break;
		case MONTH:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Month"));
			waitForAndGetElement(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Month"));
			break;
		case WORKWEEK:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Work Week"));
			waitForAndGetElement(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Work Week"));
			break;
		default:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Week"));
			waitForAndGetElement(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Week"));
			break;
		}
	}

	/**
	 * goToRightMenuTaskEventFromDayView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void goToRightMenuTaskEventFromDayView(String name, selectDayOption optionDay){
		info("Got to edit task from day view");
		goToView(selectViewOption.DAY);
		click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Day"));
		waitForAndGetElement(ELEMENT_CALENDAR_ACTIVE_VIEW.replace("$view", "Day"));
		switch(optionDay){
		case ONEDAY:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		case ALLDAY:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ALL_DAY.replace("$name", name),2);
			break;
		default:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		}
	}

	/**
	 * goToRightMenuTaskEventFromWeekView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void goToRightMenuTaskEventFromWeekView(String name, selectDayOption optionDay){
		info("Got to edit task from week view");
		goToView(selectViewOption.WEEK);
		switch(optionDay){
		case ONEDAY:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		case ALLDAY:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ALL_DAY.replace("$name", name),2);
			break;
		default:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		}
	}

	/**
	 * goToRightMenuTaskEventFromMonthView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void goToRightMenuTaskEventFromMonthView(String name){
		info("Got to edit task from month view");
		goToView(selectViewOption.MONTH);
		rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_MONTH_VIEW.replace("$name", name),2);
	}

	/**
	 * goToRightMenuTaskEventFromListView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void goToRightMenuTaskEventFromListView(String name){
		info("Got to edit task from list view");
		goToView(selectViewOption.LIST);
		rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_LIST_VIEW.replace("$name", name),2);
	}

	/**
	 * goToRightMenuTaskEventFromWorkWeekView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void goToRightMenuTaskEventFromWorkWeekView(String name, selectDayOption optionDay){
		info("Got to edit task from work week view");
		goToView(selectViewOption.WORKWEEK);
		switch(optionDay){
		case ONEDAY:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		case ALLDAY:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name),2);
			break;
		default:
			rightClickOnElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		}
	}
	/**
	 * Open "Edit task" form
	 * 
	 * @param name
	 * 				name of event or task
	 * @param view
	 * 				view: DAY, WEEK, LIST, MONTH, WORKWEEK;
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void goToEditEventTaskFormByRightClick(String name, selectViewOption view, selectDayOption optionDay){
		info("Open Edit Task Event form");
		switch(view){
		case DAY:
			goToRightMenuTaskEventFromDayView(name,optionDay);
			break;
		case WEEK:
			goToRightMenuTaskEventFromWeekView(name,optionDay);
			break;
		case LIST:
			goToRightMenuTaskEventFromListView(name);
			break;
		case MONTH:
			goToRightMenuTaskEventFromMonthView(name);
			break;
		case WORKWEEK:
			goToRightMenuTaskEventFromWorkWeekView(name,optionDay);
			break;
		default:
			goToRightMenuTaskEventFromDayView(name,optionDay);
			break;
		}
		click(ELEMENT_EVENT_TASK_EDIT_MENU);
		waitForAndGetElement(ELEMENT_ADD_EDIT_TASK_POPUP);
	}

	/**
	 * Verify event or task is not displayed on calendar panel
	 * 
	 * 
	 * @param name
	 * 				name of event or task
	 * @param view
	 * 				view: DAY, WEEK, LIST, MONTH, WORKWEEK;
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void verifyIsNotPresentEventTask(String name, selectViewOption view, selectDayOption optionDay){
		info("Verify task and event is not displayed on calendar panel");
		goToView(view);
		switch(view){
		case DAY:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case WEEK:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
		case LIST:
			waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_LIST_VIEW.replace("$name", name));
			break;
		case MONTH:
			waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_MONTH_VIEW.replace("$name", name));
			break;
		case WORKWEEK:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		default:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		}
	}

	/**
	 * Verify event or task is displayed on calendar panel
	 * 
	 * 
	 * @param name
	 * 				name of event or task
	 * @param view
	 * 				view: DAY, WEEK, LIST, MONTH, WORKWEEK;
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 */
	public void verifyIsPresentEventTask(String name, selectViewOption view, selectDayOption optionDay){
		info("Verify task and event is not displayed on calendar panel");
		goToView(view);
		switch(view){
		case DAY:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case WEEK:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case LIST:
			waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_LIST_VIEW.replace("$name", name));
			break;
		case MONTH:
			waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_MONTH_VIEW.replace("$name", name));
			break;
		case WORKWEEK:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		default:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_EVENT_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		}
	}

	/**
	 * Delete an event or task
	 * 
	 * 
	 * @param name
	 * 				name of event or task
	 * @param view
	 * 				view: DAY, WEEK, LIST, MONTH, WORKWEEK;
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param opParams
	 * 				opParams[0]: 	false - Don't verify confirm message to delete task/event
	 * 								true - Verify confirm message to delete task/event
	 * 				opParms[1]: 	true - Confirm message of event
	 * 								false - Confirm message of task
	 */
	public void deleteEventTask(String name, selectViewOption view, selectDayOption optionDay, Object... opParams){
		boolean isVerify = (Boolean) (opParams.length > 0 ? opParams[0]: false);
		boolean isEvent = (Boolean) (opParams.length > 1 ? opParams[1]: false);
		info("Delete event/tak: " + name);
		Button button = new Button(driver);
		switch(view){
		case DAY:
			goToRightMenuTaskEventFromDayView(name,optionDay);
			break;
		case WEEK:
			goToRightMenuTaskEventFromWeekView(name,optionDay);
			break;
		case LIST:
			goToRightMenuTaskEventFromListView(name);
			break;
		case MONTH:
			goToRightMenuTaskEventFromMonthView(name);
			break;
		case WORKWEEK:
			goToRightMenuTaskEventFromWorkWeekView(name,optionDay);
			break;
		default:
			goToRightMenuTaskEventFromDayView(name,optionDay);
			break;
		}
		click(ELEMENT_EVENT_TASK_DELETE_MENU);
		if(isVerify){
			if(isEvent)
				alert.verifyAlertMessage(ELEMENT_CONFIRM_DELETE_EVENT_MSG);
			else
				alert.verifyAlertMessage(ELEMENT_CONFIRM_DELETE_TASK_MSG);
		}
		else
			button.yes();
		driver.navigate().refresh();
		Utils.pause(1000);
		verifyIsNotPresentEventTask(name, view, optionDay);
	}
}
