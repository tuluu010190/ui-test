package org.exoplatform.selenium.platform.calendar;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarHomePage extends PlatformBase{

	PlatformPermission per;
	ManageAlert alert;

	//Calendar panel
	public final By ELEMENT_CALENDAR_WORKING_PANEL = By.id("UICalendarWorkingContainer");
	public final String ELEMENT_CELL_TO_WORKING_PANEL = "//td[contains(@startfull,'$date $time:00')]";
	public String ELEMENT_ANY_TARGET_DATE = "//*[contains(@startfull, '${targetDate}')]";
	public By ELEMENT_CALENDAR_PANEL = By.xpath("//div[@class='uiBox uiCalendars']");
	public By ELEMENT_SHOW_HIDE_LEFT_PANEL = By.xpath("//div[@id='ShowHideAll']/i");
	public final By ELEMENT_TOOLBAR_MINI_CALENDAR = By.xpath("//*[@class='weekDays']");

	//View button
	public final String ELEMENT_CALENDAR_VIEW_BUTTON = "//*[text()='$view']";
	public final String ELEMENT_CALENDAR_ACTIVE_VIEW = "//*[@class='btn active']//*[text()='$view']";

	//bar
	public final By ELEMENT_TODAY_ACTION_BAR=By.xpath("//*[@class='todayActionBar']");
	public final By ELEMENT_NEXT_BUTTON_ANY_VIEW=By.xpath("//*[@class='title']//*[@class='uiIconMiniArrowRight uiIconLightGray']");
	public final By ELEMENT_PREVIOUS_BUTTON_ANY_VIEW=By.xpath("//*[@class='title']//*[@class='uiIconMiniArrowLeft uiIconLightGray']");
	public final By ELEMENT_CATEGORY_OPTION=By.xpath("//*[@name='eventCategories']");
	public final String ELEMENT_CATEGORY_OPTION_SELECTED="//*[@name='eventCategories']//*[@selected='selected' and text()='$name']";

	//Day View
	public final String ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY="//*[@id='UIDayView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(.,'$name')]";
	public final String ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY="//*[@id='UIDayViewGrid']//div[contains(text(),'$name')]";

	//Week View
	public final String ELEMENT_EVENT_TASK_WEEK_VIEW_ALL_DAY="//*[@id='UIWeekView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(.,'$name')]";
	public final String ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY="//*[@id='UIWeekViewGrid']//div[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY = "//*[@id='UIWeekViewGrid']//*[contains(@startfull,'$date')]//div[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY = "//*[@id='UIWeekViewGridAllDay']//*[contains(@starttimefull,'$date')]//div[contains(text(),'$name')]";
	public final String ELEMENT_WEEK_VIEW_BAR_TIME="//*[@class='eventWeekBar']//td['$index']/a";

	//Month View
	public final String ELEMENT_EVENT_TASK_MONTH_VIEW="//*[@id='UIMonthView']//span[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW="//*[@id='UIMonthView']//*[contains(@starttimefull,'$date')]//span[contains(text(),'$name')]";

	//List View
	public final String ELEMENT_EVENT_TASK_LIST_VIEW="//*[@id='UIListView']//*[@class='uiListViewRow']//*[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW="//*[@id='UIListView']//*[contains(text(),'$name')]/../..//td[5][contains(text(),'$date')]";
	public final String ELEMENT_EVENT_TASK_END_DETAIL_DATE_LIST_VIEW="//*[@id='UIListView']//*[contains(text(),'$name')]/../..//td[6][contains(text(),'$date')]";

	//Work Week View
	public final String ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY="//*[@id='UIWeekView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY="//*[@id='UIWeekView']//div[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY = "//*[@id='UIWeekViewGrid']//*[contains(@startfull,'$date')]//div[contains(text(),'$name')]";
	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ALL_DAY = "//*[@id='UIWeekViewGridAllDay']//*[contains(@starttimefull,'$date')]//div[contains(text(),'$name')]";

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
	public By ELEMENT_ADD_EDIT_TASK_POPUP = By.xpath("//span[@class='PopupTitle popupTitle' and (text()='Add/Edit Tasks' or text()='Add/Edit Event')]");
	public By ELEMENT_QUICK_ADD_EVENT_POPUP = By.id("UIQuickAddEventPopupWindow");

	//Resize task or event
	public String ELEMENT_RESIZE_CONTAINER = "//*[contains(text(),'$name')]/../..//*[@class='resizeEventContainer']";

	//Delete task/event
	public String ELEMENT_CONFIRM_DELETE_TASK_MSG = "Are you sure you want to delete this task?";
	public String ELEMENT_CONFIRM_DELETE_EVENT_MSG = "Are you sure you want to delete this event?";

	//page navigation
	public By ELEMENT_NEXT_PAGE=By.xpath("//*[@class='uiIconNextArrow']");
	public By ELEMENT_PREVIOUS_PAGE=By.xpath("//*[@class='uiIconPrevArrow']");
	public By ELEMENT_TOTAL_PAGE=By.xpath("//*[@class='pagesTotalNumber']");
	public By ELEMENT_CURRENT_PAGE=By.xpath("//*[@class='active']/*[contains(@href,'objectId')]");
	public String ELEMENT_ANY_PAGE="//*[contains(@href,'objectId') and text()='$page']";
	
	//quick search
	public By ELEMENT_QUICK_SEARCH_INPUT=By.id("value");
	public String ELEMENT_QUICK_SEARCH_FORM = "//div[@class='uiSearchForm uiSearchInput pull-right']";
	public String ELEMENT_BUTTON_CLOSE_QUICK_SEARCH_RESULT = "//*[@id='UIListView']//button[contains(text(),'Close Search')]";
	public String ELEMENT_BUTTON_OPEN_ADVANCE_SEARCH_FORM = "//*[@id='UIListView']//button[contains(text(),'Advanced Search')]";
	public String ELEMENT_INPUT_TEXT_ADVANCE_SEARCH = "//*[@id='UIAdvancedSearchForm']//*[@id='text']";
	public String ELEMENT_BUTTON_SEARCH_ADVANCE_SEARCH = "//*[@id='UIAdvancedSearchForm']//button[contains(text(),'Search')]";
	
	//Preview
	public By ELEMENT_PREVIEW_TASK_EVENT_FORM=By.id("UIEventPreview");
	public String ELEMENT_PREVIEW_TASK_EVENT_NAME="//*[@id='UIEventPreview']//*[text()='$name']";
	public By ELEMENT_CLOSE_PREVIEW_TASK_EVENT_FORM=By.xpath("//*[@id='UIEventPreview']//*[text()='Close']");

	/**
	 * constructor
	 * @param dr
	 */
	public CalendarHomePage(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
	}

	/**
	 * Category list
	 */
	public enum selectCategoryOption{
		ALL, MEETING, CALL, CLIENT, ANNIVERSARY, HOLIDAY
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
			waitForAndGetElement(ELEMENT_CALENDAR_ACTIVE_VIEW.replace("$view", "Week"));
			break;
		case LIST:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "List"));
			waitForAndGetElement(ELEMENT_CALENDAR_ACTIVE_VIEW.replace("$view", "List"));
			break;
		case MONTH:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Month"));
			waitForAndGetElement(ELEMENT_CALENDAR_ACTIVE_VIEW.replace("$view", "Month"));
			break;
		case WORKWEEK:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Work Week"));
			waitForAndGetElement(ELEMENT_CALENDAR_ACTIVE_VIEW.replace("$view", "Work Week"));
			break;
		default:
			click(ELEMENT_CALENDAR_VIEW_BUTTON.replace("$view", "Week"));
			waitForAndGetElement(ELEMENT_CALENDAR_ACTIVE_VIEW.replace("$view", "Week"));
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
			rightClickOnElement(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		case ALLDAY:
			rightClickOnElement(ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY.replace("$name", name),2);
			break;
		default:
			rightClickOnElement(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name),2);
			break;
		}
	}

	/**
	 * goToRightMenuTaskEventFromWeekView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 */
	public void goToRightMenuTaskEventFromWeekView(String name, selectDayOption optionDay, String date){
		info("Got to edit task from week view");
		goToView(selectViewOption.WEEK);
		if(date!=null && date!=""){
			switch(optionDay){
			case ONEDAY:
				info(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				rightClickOnElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date),2);
				break;
			case ALLDAY:
				rightClickOnElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY.replace("$name", name).replace("$date", date),2);
				break;
			default:
				rightClickOnElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date),2);
				break;	
			}
		}
		else{
			switch(optionDay){
			case ONEDAY:
				rightClickOnElement(ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
				break;
			case ALLDAY:
				rightClickOnElement(ELEMENT_EVENT_TASK_WEEK_VIEW_ALL_DAY.replace("$name", name),2);
				break;
			default:
				rightClickOnElement(ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
				break;
			}
		}
	}

	/**
	 * goToRightMenuTaskEventFromMonthView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 */
	public void goToRightMenuTaskEventFromMonthView(String name, String date){
		info("Got to edit task from month view");
		goToView(selectViewOption.MONTH);
		if(date!=null && date!=""){
			info(ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$name", name).replace("$date", date));
			rightClickOnElement(ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$name", name).replace("$date", date),2);
		}
		else
			rightClickOnElement(ELEMENT_EVENT_TASK_MONTH_VIEW.replace("$name", name),2);
	}

	/**
	 * goToRightMenuTaskEventFromListView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 */
	public void goToRightMenuTaskEventFromListView(String name, String date){
		info("Got to edit task from list view");
		goToView(selectViewOption.LIST);
		if(date!=null && date!="")
			rightClickOnElement(ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW.replace("$name", name).replace("$date", date),2);
		else
			rightClickOnElement(ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", name),2);
	}

	/**
	 * goToRightMenuTaskEventFromWorkWeekView
	 * @param name
	 * 				name of event or task
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 */
	public void goToRightMenuTaskEventFromWorkWeekView(String name, selectDayOption optionDay, String date){
		info("Got to edit task from work week view");
		goToView(selectViewOption.WORKWEEK);
		if(date!=null && date!=""){
			switch(optionDay){
			case ONEDAY:
				rightClickOnElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date),2);
				break;
			case ALLDAY:
				rightClickOnElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name).replace("$date", date),2);
				break;
			default:
				rightClickOnElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date),2);
				break;	
			}
		}
		else{
			switch(optionDay){
			case ONEDAY:
				rightClickOnElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
				break;
			case ALLDAY:
				rightClickOnElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name),2);
				break;
			default:
				rightClickOnElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name),2);
				break;

			}
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
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 */
	public void goToEditEventTaskFormByRightClick(String name, selectViewOption view, selectDayOption optionDay, String date){
		info("Open Edit Task Event form");
		switch(view){
		case DAY:
			goToRightMenuTaskEventFromDayView(name,optionDay);
			break;
		case WEEK:
			goToRightMenuTaskEventFromWeekView(name,optionDay,date);
			break;
		case LIST:
			goToRightMenuTaskEventFromListView(name,date);
			break;
		case MONTH:
			goToRightMenuTaskEventFromMonthView(name,date);
			break;
		case WORKWEEK:
			goToRightMenuTaskEventFromWorkWeekView(name,optionDay,date);
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
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case WEEK:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
		case LIST:
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,10000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while(!(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText()))){
					click(ELEMENT_NEXT_PAGE);
					waitForElementNotPresent(ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", name));
				}
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
			}
			else{
				waitForElementNotPresent(ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", name));
			}
			break;
		case MONTH:
			waitForElementNotPresent(ELEMENT_EVENT_TASK_MONTH_VIEW.replace("$name", name));
			break;
		case WORKWEEK:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		default:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
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
		driver.navigate().refresh();
		goToView(view);
		switch(view){
		case DAY:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case WEEK:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case LIST:
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while((waitForAndGetElement(ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", name),5000,0)==null)
						&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
					click(ELEMENT_NEXT_PAGE);
				waitForAndGetElement(ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", name));
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
			}
			else{
				waitForAndGetElement(ELEMENT_EVENT_TASK_LIST_VIEW.replace("$name", name));
			}
			break;
		case MONTH:
			waitForAndGetElement(ELEMENT_EVENT_TASK_MONTH_VIEW.replace("$name", name));
			break;
		case WORKWEEK:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		default:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		}
	}

	/**
	 * verify event exitst or not
	 * @param name
	 * 				name of event or task
	 * @param view
	 * 				view: DAY, WEEK, LIST, MONTH, WORKWEEK;
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 * @return: true if event exist, false if event doesn't exist
	 */
	public void verifyIsPresentEventTaskWithDateTime(String name, String date, selectViewOption view, selectDayOption optionDay){
		info("Verify task and event is not displayed on calendar panel");
		goToView(view);
		switch(view){
		case DAY:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case WEEK:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY.replace("$name", name).replace("$date", date));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			}
			break;
		case LIST:
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while((waitForAndGetElement(ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW.replace("$name", name).replace("$date", date),5000,0)==null)
						&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
					click(ELEMENT_NEXT_PAGE);
				waitForAndGetElement(ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW.replace("$name", name).replace("$date", date));
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
			}
			else{
				waitForAndGetElement(ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW.replace("$name", name).replace("$date", date));
			}
			break;
		case MONTH:
			waitForAndGetElement(ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$name", name).replace("$date", date));
			break;
		case WORKWEEK:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name).replace("$date", date));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			}
			break;
		default:
			switch(optionDay){
			case ONEDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForAndGetElement(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		}
	}

	/**
	 * verify event is not exitst
	 * @param name
	 * 				name of event or task
	 * @param view
	 * 				view: DAY, WEEK, LIST, MONTH, WORKWEEK;
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 * @return: true if event exist, false if event doesn't exist
	 */
	public void verifyIsNotPresentEventTaskWithDateTime(String name, String date, selectViewOption view, selectDayOption optionDay){
		info("Verify task and event is not displayed on calendar panel");
		goToView(view);
		switch(view){
		case DAY:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		case WEEK:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY.replace("$name", name).replace("$date", date));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			}
			break;
		case LIST:
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while(!(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText()))){
					click(ELEMENT_NEXT_PAGE);
					waitForElementNotPresent(ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW.replace("$name", name).replace("$date", date));
				}
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
			}
			else{
				waitForElementNotPresent(ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW.replace("$name", name).replace("$date", date));
			}
			break;
		case MONTH:
			waitForElementNotPresent(ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW.replace("$name", name).replace("$date", date));
			break;
		case WORKWEEK:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name).replace("$date", date));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name).replace("$date", date));
				break;
			}
			break;
		default:
			switch(optionDay){
			case ONEDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			case ALLDAY:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY.replace("$name", name));
				break;
			default:
				waitForElementNotPresent(ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY.replace("$name", name));
				break;
			}
			break;
		}
	}

	/**
	 * goToRightMenuTaskEventFromAnyView
	 * @param name
	 * 				name of event or task
	 * @param view
	 * 				view: DAY, WEEK, LIST, MONTH, WORKWEEK;
	 * @param optionDay
	 * 				select ONEDAY or ALLDAY
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 */
	public void goToRightMenuTaskEventFromAnyView(String name, selectViewOption view, selectDayOption optionDay, String date){
		info("click right menu task/event");
		switch(view){
		case DAY:
			goToRightMenuTaskEventFromDayView(name,optionDay);
			break;
		case WEEK:
			goToRightMenuTaskEventFromWeekView(name,optionDay,date);
			break;
		case LIST:
			goToRightMenuTaskEventFromListView(name,date);
			break;
		case MONTH:
			goToRightMenuTaskEventFromMonthView(name,date);
			break;
		case WORKWEEK:
			goToRightMenuTaskEventFromWorkWeekView(name,optionDay,date);
			break;
		default:
			goToRightMenuTaskEventFromDayView(name,optionDay);
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
	 * @param date
	 * 				date of event: format (MMM dd yyyy)
	 * @param opParams
	 * 				opParams[0]: 	false - Don't verify confirm message to delete task/event
	 * 								true - Verify confirm message to delete task/event
	 * 				opParms[1]: 	true - Confirm message of event
	 * 								false - Confirm message of task
	 */
	public void deleteEventTask(String name, selectViewOption view, selectDayOption optionDay, String date, Object... opParams){
		boolean isVerify = (Boolean) (opParams.length > 0 ? opParams[0]: false);
		boolean isEvent = (Boolean) (opParams.length > 1 ? opParams[1]: false);
		info("Delete event/tak: " + name);
		Button button = new Button(driver);
		goToRightMenuTaskEventFromAnyView(name,view,optionDay,date);
		click(ELEMENT_EVENT_TASK_DELETE_MENU);
		if(isVerify){
			if(isEvent)
				alert.verifyAlertMessage(ELEMENT_CONFIRM_DELETE_EVENT_MSG);
			else
				alert.verifyAlertMessage(ELEMENT_CONFIRM_DELETE_TASK_MSG);
			driver.navigate().refresh();
			Utils.pause(1000);
			verifyIsNotPresentEventTask(name, view, optionDay);
		}
		else
			button.yes();
	}

	/**
	 * select category from list
	 * @param option
	 * 				category type: call, all, client, holiday,anniversary
	 */
	public void selectCategory(selectCategoryOption option){
		info("Select category from list");
		if(option!=null){
			switch(option){
			case ALL:
				select(ELEMENT_CATEGORY_OPTION,"All");
				break;
			case ANNIVERSARY:
				select(ELEMENT_CATEGORY_OPTION,"Anniversary");
				break;
			case CALL:
				select(ELEMENT_CATEGORY_OPTION,"Calls");
				break;
			case CLIENT:
				select(ELEMENT_CATEGORY_OPTION,"Clients");
				break;
			case HOLIDAY:
				select(ELEMENT_CATEGORY_OPTION,"Holiday");
				break;
			case MEETING:
				select(ELEMENT_CATEGORY_OPTION,"Meeting");
				break;
			default:
				select(ELEMENT_CATEGORY_OPTION,"All");
				break;

			}
		}
	}
	
	/**
	 * Do quick calendar search
	 * @param keyword
	 * 				keyword which is to input into search box 
	 */
	public void quickSearchCalendar(String keyword){
		info("----Type in quick search box----");
		type(ELEMENT_QUICK_SEARCH_INPUT,keyword,true);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.RETURN).build().perform();
		waitForAndGetElement(ELEMENT_BUTTON_CLOSE_QUICK_SEARCH_RESULT);
	}
	
	/** 
	 * Advance search in Calendar
	 * 
	 * @param keyword
	 * 			keyword which is to input into search box 
	 */
	public void advanceSearchCalendar(String keyword){
		info("----Open Advance Search window----");
		waitForAndGetElement(ELEMENT_BUTTON_OPEN_ADVANCE_SEARCH_FORM);
		click(ELEMENT_BUTTON_OPEN_ADVANCE_SEARCH_FORM);
		info("----Input keyword----");
		waitForAndGetElement(ELEMENT_INPUT_TEXT_ADVANCE_SEARCH);
		type(ELEMENT_INPUT_TEXT_ADVANCE_SEARCH,keyword,true);
		click(ELEMENT_BUTTON_SEARCH_ADVANCE_SEARCH);
		info("----Confirm search result displayed----");
		Utils.pause(3000);
		waitForAndGetElement(ELEMENT_BUTTON_CLOSE_QUICK_SEARCH_RESULT);
	}
}