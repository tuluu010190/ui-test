package org.exoplatform.selenium.platform.calendar;

import static org.exoplatform.selenium.TestLogger.info;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEditTaskManagement extends PlatformBase {

	//------------------------------------Add Quick Task Form--------------------------------------\\
	public By ELEMENT_QUICK_ADD_TASK_POPUP = By.id("UIQuickAddTaskPopupWindow");
	public By ELEMENT_QUICK_INPUT_TASK_NAME = By.xpath("//*[@id='UIQuickAddTask']//*[@id='eventName']");
	public By ELEMENT_QUICK_INPUT_TASK_NOTE = By.xpath("//*[@id='UIQuickAddTask']//*[@id='description']");
	public By ELEMENT_QUICK_INPUT_TASK_CALENDAR = By.xpath("//*[@id='UIQuickAddTask']//*[@name='calendar']");
	public By ELEMENT_QUICK_INPUT_TASK_CATEGORY = By.xpath("//*[@id='UIQuickAddTask']//*[@name='category']");
	public By ELEMENT_QUICK_CHECKBOX_TASK_ALLDAY = By.xpath("//*[@id='UIQuickAddTask']//*[@name='allDay']");
	public By ELEMENT_QUICK_INPUT_TASK_FROM_DATE = By.xpath("//*[@id='UIQuickAddTask']//*[@name='from']");
	public By ELEMENT_QUICK_INPUT_TASK_TO_DATE = By.xpath("//*[@id='UIQuickAddTask']//*[@name='to']");
	public By ELEMENT_QUICK_INPUT_TASK_FROM_TIME = By.xpath("//*[@id='UIQuickAddTask']//*[@name='fromTime']");
	public By ELEMENT_QUICK_INPUT_TASK_TO_TIME = By.xpath("//*[@id='UIQuickAddTask']//*[@name='toTime']");
	public By ELEMENT_QUICK_INPUT_TASK_FROM_TIME_INPUT = By.xpath("//*[@id='UIQuickAddTask']//*[@id='fromTime']/..//*[@class='UIComboboxInput']");
	public By ELEMENT_QUICK_INPUT_TASK_TO_TIME_INPUT = By.xpath("//*[@id='UIQuickAddTask']//*[@id='toTime']/..//*[@class='UIComboboxInput']");
	public String ELEMENT_QUICK_TASK_SELECT_TO_TIME = "//*[@id='UIQuickAddTask']//*[@id='toTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
	public String ELEMENT_QUICK_TASK_SELECT_FROM_TIME = "//*[@id='UIQuickAddTask']//*[@id='fromTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
	public By ELEMENT_BUTTON_TASK_SAVE = By.xpath("//*[@id='UIQuickAddTaskPopupWindow']//*[text()='Save']");
	public String ELEMENT_ATTACH_FILE_NAME = "//*[@data-original-title='$fileName']";
	public By ELEMENT_BUTTON_TASK_QUICK_CANCEL = By.xpath("//*[@id='UIQuickAddTaskPopupWindow']//*[text()='Cancel']");
	//----------------------------------Add Task Form (more details )------------------------------------\\
	public By ELEMENT_ADD_EDIT_TASK_NAME = By.xpath("//*[@id='UITaskForm']//*[@name='eventName']");
	public By ELEMENT_ADD_EDIT_TASK_NOTE = By.xpath("//*[@id='UITaskForm']//*[@id='description']");
	public By ELEMENT_ADD_EDIT_TASK_CALENDAR = By.xpath("//*[@id='UITaskForm']//*[@name='calendar']");
	public By ELEMENT_ADD_EDIT_TASK_CATEGORY = By.xpath("//*[@id='UITaskForm']//*[@name='category']");
	public By ELEMENT_ADD_EDIT_TASK_ALLDAY = By.xpath("//*[@id='UITaskForm']//*[@name='allDay']");
	public By ELEMENT_ADD_EDIT_TASK_FROM_DATE = By.xpath("//*[@id='UITaskForm']//*[@name='from']");
	public By ELEMENT_ADD_EDIT_TASK_TO_DATE = By.xpath("//*[@id='UITaskForm']//*[@name='to']");
	public By ELEMENT_ADD_EDIT_INPUT_TASK_FROM_TIME = By.xpath("//*[@id='UITaskForm']//*[@name='fromTime']");
	public By ELEMENT_ADD_EDIT_INPUT_TASK_TO_TIME = By.xpath("//*[@id='UITaskForm']//*[@name='toTime']");
	public By ELEMENT_ADD_EDIT_TASK_FROM_TIME_INPUT = By.xpath("//*[@id='UITaskForm']//*[@id='fromTime']/..//*[@class='UIComboboxInput']");
	public By ELEMENT_ADD_EDIT_TASK_TO_TIME_INPUT = By.xpath("//*[@id='UITaskForm']//*[@id='toTime']/..//*[@class='UIComboboxInput']");
	public String ELEMENT_ADD_EDIT_TASK_SELECT_FROM_TIME = "//*[@id='UITaskForm']//*[@id='fromTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
	public String ELEMENT_ADD_EDIT_TASK_SELECT_TO_TIME = "//*[@id='UITaskForm']//*[@id='toTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
	public By ELEMENT_BUTTON_TASK_MORE_DETAILS = By.xpath("//*[@id='UIQuickAddTaskPopupWindow']//*[text()='More Details']");
	public By ELEMENT_BUTTON_TASK_SAVE_DETAILS = By.xpath("//*[@id='UITaskForm']//*[text()='Save']");
	public By ELEMENT_TASK_FILE_INPUT = By.xpath("//*[@id='upload']//*[@name='file']");
	public By ELEMENT_BUTTON_EVENT_CANCEL_DETAILS = By.xpath("//*[@id='UITaskForm']//*[text()='Cancel']");
	public By ELEMENT_ADD_EDIT_TASK_STATUS = By.xpath("//*[@id='UITaskForm']//*[@name='status']");

	//Attach file form
	public By ELEMENT_ATTACH_SAVE_BUTTON = By.xpath("//form[@id='UIAttachFileForm']//*[text()='Save']");
	public By ELEMENT_TASK_ADD_ATTACHMENT = By.xpath("//button[contains(@onclick,'AddAttachment')]");
	public String ELEMENT_TASK_ATTACHMENT = "//*[@id='UITaskForm']/..//a[@data-original-title='${file}']";
	public By ELEMENT_ATTACHMENT_SAVE_BUTTON = By.xpath("//*[@id='UIAttachFileForm']//*[text()='Save']");
	public String ELEMENT_ATTACHMENT_FORM_FILE_NAME = "//*[text()='$fileName']";

	CalendarHomePage cHome;
	public AddEditTaskManagement(WebDriver dr){
		driver = dr;
		cHome = new CalendarHomePage(driver);
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
	public void goToAddTaskByRightClickFromMainPanel(String date, String time){
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

		String cell = cHome.ELEMENT_CELL_TO_WORKING_PANEL.replace("$date", tempDate2).replace("$time", tempTime);
		rightClickOnElement(cell);
		click(cHome.ELEMENT_RIGHT_CLICK_ADD_TASK);
		waitForAndGetElement(ELEMENT_QUICK_ADD_TASK_POPUP);
	}

	/**
	 * Open "Add new task" form from action bar
	 * 
	 */
	public void goToAddTaskFromActionBar(){
		info("Go to Add Task page from action bar"); 
		click(cHome.ELEMENT_BUTTON_TASK);
		waitForAndGetElement(ELEMENT_QUICK_ADD_TASK_POPUP);
	}


	/**
	 * Input into basic fields of Quick task form
	 * 
	 * @param name
	 * 			name of a task
	 * @param note
	 * 			note of a task 
	 * @param opt
	 * 			optional parameter
	 * 			opt[0]: calendar
	 * 			opt[1]: category
	 */
	public void inputBasicQuickTask(String name, String note, String...opt){
		info("Input into basic fields of Quick task form");
		if (name != null){
			type(ELEMENT_QUICK_INPUT_TASK_NAME, name, true);
		}
		if (note != null){
			type(ELEMENT_QUICK_INPUT_TASK_NOTE, note, true);
		}
		if (opt.length > 0 && opt[0] != null){
			select(ELEMENT_QUICK_INPUT_TASK_CALENDAR, opt[0]);
		}
		if (opt.length > 1 && opt[1] != null){
			select(ELEMENT_QUICK_INPUT_TASK_CATEGORY, opt[1]);
		}
	}

	/**
	 * Input into basic fields of task detail form
	 * 
	 * @param name
	 * 			name of a task
	 * @param note
	 * 			note of a task 
	 * @param opt
	 * 			optional parameter
	 * 			opt[0]: calendar
	 * 			opt[1]: category
	 */
	public void inputBasicDetailTask(String name, String note, String...opt){
		info("Input into basic fields of Quick task form");
		if (name != null){
			type(ELEMENT_ADD_EDIT_TASK_NAME, name, true);
		}
		if (note != null){
			type(ELEMENT_ADD_EDIT_TASK_NOTE, note, true);
		}
		if (opt.length > 0 && opt[0] != null){
			select(ELEMENT_ADD_EDIT_TASK_CALENDAR, opt[0]);
		}
		if (opt.length > 1 && opt[1] != null){
			select(ELEMENT_ADD_EDIT_TASK_CATEGORY, opt[1]);
		}
	}

	/**
	 * Input into "From, To" and check/uncheck allday checkbox fields of a task in quick form
	 * 
	 * @param from
	 * 			From date, time of a task i.e.: 11/06/2013 14:00
	 * @param to
	 * 			To date, time of a task, i.e.: 11/06/2013 14:00
	 * @param allDay
	 * 			Option "all day" of a task
	 */
	public void inputFromToQuickTask(String from, String to, boolean allDay){
		info("Input into From, To and check/uncheck allday checkbox fields of a task");
		if(allDay){
			info("Check all day, then select date");
			check(ELEMENT_QUICK_CHECKBOX_TASK_ALLDAY,2);
			if ((from != null) & (from != ""))
				type(ELEMENT_QUICK_INPUT_TASK_FROM_DATE, from, true);
			if ((to != null) & (to != ""))
				type(ELEMENT_QUICK_INPUT_TASK_TO_DATE, to, true);

		}else {
			info("Uncheck all day, then select date time");
			uncheck(ELEMENT_QUICK_CHECKBOX_TASK_ALLDAY,2);
			if ((from != null) & (from != "")){
				String[] dateTimeFrom = from.split(" ");
				if(dateTimeFrom.length > 0)
					type(ELEMENT_QUICK_INPUT_TASK_FROM_DATE, dateTimeFrom[0], true);
				if(dateTimeFrom.length > 1){
					click(ELEMENT_QUICK_INPUT_TASK_FROM_TIME_INPUT, 2);
					click(ELEMENT_QUICK_TASK_SELECT_FROM_TIME.replace("${time}", dateTimeFrom[1]));
				}
			}
			if ((to != null) & (to != "")){
				String[] dateTimeTo = to.split(" ");
				if(dateTimeTo.length > 0)
					type(ELEMENT_QUICK_INPUT_TASK_TO_DATE, dateTimeTo[0], true);
				if(dateTimeTo.length > 1){
					click(ELEMENT_QUICK_INPUT_TASK_TO_TIME_INPUT, 2);
					click(ELEMENT_QUICK_TASK_SELECT_TO_TIME.replace("${time}", dateTimeTo[1]));
				}
			}
		}
	}

	/**
	 * Input into "From, To" and check/uncheck allday checkbox fields of a task in detail form
	 * 
	 * @param from
	 * 			From date, time of a task i.e.: 11/06/2013 14:00
	 * @param to
	 * 			To date, time of a task, i.e.: 11/06/2013 14:00
	 * @param allDay
	 * 			Option "all day" of a task
	 */
	public void inputFromToDetailTask(String from, String to, boolean allDay){
		info("Input into From, To and check/uncheck allday checkbox fields of a task");
		if(allDay){
			info("Check all day, then select date");
			check(ELEMENT_QUICK_CHECKBOX_TASK_ALLDAY,2);
			if ((from != null) & (from != ""))
				type(ELEMENT_QUICK_INPUT_TASK_FROM_DATE, from, true);
			if ((to != null) & (to != ""))
				type(ELEMENT_QUICK_INPUT_TASK_TO_DATE, to, true);

		}else {
			info("Uncheck all day, then select date time");
			uncheck(ELEMENT_ADD_EDIT_TASK_ALLDAY,2);
			if ((from != null) & (from != "")){
				String[] dateTimeFrom = from.split(" ");
				if(dateTimeFrom.length > 0)
					type(ELEMENT_ADD_EDIT_TASK_FROM_DATE, dateTimeFrom[0], true);
				if(dateTimeFrom.length > 1){
					click(ELEMENT_ADD_EDIT_TASK_FROM_TIME_INPUT, 2);
					click(ELEMENT_ADD_EDIT_TASK_SELECT_FROM_TIME.replace("${time}", dateTimeFrom[1]));
				}
			}
			if ((to != null) & (to != "")){
				String[] dateTimeTo = to.split(" ");
				if(dateTimeTo.length > 0)
					type(ELEMENT_ADD_EDIT_TASK_TO_DATE, dateTimeTo[0], true);
				if(dateTimeTo.length > 1){
					click(ELEMENT_ADD_EDIT_TASK_TO_TIME_INPUT, 2);
					click(ELEMENT_ADD_EDIT_TASK_SELECT_TO_TIME.replace("${time}", dateTimeTo[1]));
				}
			}
		}
	}

	/**
	 * Input into basic fields of Quick task form
	 * @param name
	 * @param from
	 * 			From date, time of a task i.e.: 11/06/2013 14:00
	 * @param to
	 * 			To date, time of a task, i.e.: 11/06/2013 14:00
	 * @param allDay
	 * @param opt
	 */
	public void inputDataTaskInQuickForm(String name, String note, String from, String to, boolean allDay, String...opt){
		inputBasicQuickTask(name, note, opt);
		inputFromToQuickTask(from, to, allDay);
	}

	/**
	 * Input into basic fields of detail task form
	 * @param name
	 * @param note
	 * @param from
	 * 			From date, time of a task i.e.: 11/06/2013 14:00
	 * @param to
	 * 			To date, time of a task, i.e.: 11/06/2013 14:00
	 * @param allDay
	 * @param opt
	 */
	public void inputDataTaskInDetailForm(String name, String note, String from, String to, boolean allDay, String...opt){
		inputBasicDetailTask(name, note, opt);
		inputFromToDetailTask(from, to, allDay);
	}

	/**
	 * Attach file in "Add new task" form
	 * 
	 * @param path
	 * 				path of attachment of a task
	 */
	public void attachFileToTask(String path){
		String[] links = path.split("/");
		click(ELEMENT_TASK_ADD_ATTACHMENT);
		WebElement eFile = waitForAndGetElement(ELEMENT_TASK_FILE_INPUT,DEFAULT_TIMEOUT,1,2);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';",eFile);
		eFile.sendKeys(Utils.getAbsoluteFilePath(path));
		waitForAndGetElement(ELEMENT_ATTACHMENT_FORM_FILE_NAME.replace("$fileName", links[links.length-1]));
		click(ELEMENT_ATTACHMENT_SAVE_BUTTON);
		waitForAndGetElement(ELEMENT_ATTACH_FILE_NAME.replace("$fileName", links[links.length-1]));
		switchToParentWindow();

	}	

	/**
	 * Check default suggestion task time in detail add form
	 * @param fromDateTime (Format: MM/dd/yyyy HH:mm)
	 * @param toDateTime (Format: MM/dd/yyyy HH:mm)
	 * @param duration	 
	 */
	public void checkSuggestionTaskTimeInQuickForm(String fromDateTime, String toDateTime, int duration){
		info("Check date is current date");
		DateFormat formatterTime = new SimpleDateFormat("HH:mm");
		DateFormat formatterTimeTemp = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		DateFormat formatterDate = new SimpleDateFormat("MM/dd/yyyy");
		String dateFrom = getValue(ELEMENT_QUICK_INPUT_TASK_FROM_DATE);
		String dateTo = getValue(ELEMENT_QUICK_INPUT_TASK_TO_DATE);
		String fromTime = waitForAndGetElement(ELEMENT_QUICK_INPUT_TASK_FROM_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");
		String toTime = waitForAndGetElement(ELEMENT_QUICK_INPUT_TASK_TO_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");

		info("Check default suggestion EVENT time");
		if (fromDateTime == null || fromDateTime == ""){
			info("Check time suggestion default");
			assert dateFrom.equals(getCurrentDate("MM/dd/yyyy"));
		}
		else{
			info("Check suggesion when select from time");
			try {
				Date fr = formatterDate.parse(fromDateTime);
				Date frTime = formatterTimeTemp.parse(fromDateTime);
				assert dateFrom.equals(formatterDate.format(fr));
				assert fromTime.equals(formatterTime.format(frTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (toDateTime == null || toDateTime == ""){
			info("Check time suggestion default");
			assert dateTo.equals(getCurrentDate("MM/dd/yyyy"));
		}
		else {
			info("Check suggesion when select to time");
			try {
				Date to = formatterDate.parse(toDateTime);
				Date tTime = formatterTimeTemp.parse(toDateTime);
				assert dateTo.equals(formatterDate.format(to));
				assert toTime.equals(formatterTime.format(tTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		info("Check duration");
		try {
			Date fr = formatterTime.parse(fromTime);
			Date to = formatterTime.parse(toTime);
			long diff = (to.getTime() - fr.getTime())/60000;
			info("Duration is " + diff + " minus");
			assert duration == (int) diff;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check default suggestion task time in detail add form
	 * @param fromDateTime (Format: MM/dd/yyyy HH:mm)
	 * @param toDateTime (Format: MM/dd/yyyy HH:mm)
	 * @param duration	 
	 */
	public void checkSuggestionTaskTimeInDetailForm(String fromDateTime, String toDateTime, int duration){
		info("Check date is current date");
		DateFormat formatterTimeTemp = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");
		SimpleDateFormat formatterDate = new SimpleDateFormat("MM/dd/yyyy");
		String dateFrom = getValue(ELEMENT_ADD_EDIT_TASK_FROM_DATE);
		String dateTo = getValue(ELEMENT_ADD_EDIT_TASK_TO_DATE);
		String fromTime = waitForAndGetElement(ELEMENT_ADD_EDIT_INPUT_TASK_FROM_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");
		String toTime = waitForAndGetElement(ELEMENT_ADD_EDIT_INPUT_TASK_TO_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");

		info("Check default suggestion EVENT time");
		if (fromDateTime == null || fromDateTime == ""){
			info("Check time suggestion default");
			assert dateFrom.equals(getCurrentDate("MM/dd/yyyy"));
		}
		else{
			info("Check suggesion when select from time");
			try {
				Date fr = formatterDate.parse(fromDateTime);
				Date frTime = formatterTimeTemp.parse(fromDateTime);
				assert dateFrom.equals(formatterDate.format(fr));
				assert fromTime.equals(formatterTime.format(frTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (toDateTime == null || toDateTime == ""){
			info("Check time suggestion default");
			assert dateTo.equals(getCurrentDate("MM/dd/yyyy"));
		}
		else {
			info("Check suggesion when select to time");
			try {
				Date to = formatterDate.parse(toDateTime);
				Date tTime = formatterTimeTemp.parse(toDateTime);
				assert dateTo.equals(formatterDate.format(to));
				assert toTime.equals(formatterTime.format(tTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		info("Check duration");
		try {
			Date fr = formatterTime.parse(fromTime);
			Date to = formatterTime.parse(toTime);
			long diff = (to.getTime() - fr.getTime())/60000;
			info("Duration is " + diff + " minus");
			assert duration == (int) diff;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * View list in calendar
	 */
	public enum statusTask{
		INPROGRESS,CANCELLED,COMPLETED,NEEDACTION;
	}

	/**
	 * select status of task from list
	 * @param option
	 * 				category type: NPROGRESS,CANCELLED,COMPLETED,NEEDACTION;
	 */
	public void selectStatus(statusTask option){
		info("Select status of task from list");
		if(option!=null){
			switch(option){
			case INPROGRESS:
				select(ELEMENT_ADD_EDIT_TASK_STATUS,"In Progress");
				break;
			case CANCELLED:
				select(ELEMENT_ADD_EDIT_TASK_STATUS,"Canceled");
				break;
			case COMPLETED:
				select(ELEMENT_ADD_EDIT_TASK_STATUS,"Completed");
				break;
			case NEEDACTION:
				select(ELEMENT_ADD_EDIT_TASK_STATUS,"Need Action");
				break;
			default:
				select(ELEMENT_ADD_EDIT_TASK_STATUS,"Need Action");
				break;
			}
		}
	}

	/**
	 * Save add Task
	 */
	public void saveQuickAddTask(){
		click(ELEMENT_BUTTON_TASK_SAVE);
		waitForElementNotPresent(ELEMENT_BUTTON_TASK_SAVE);
		Utils.pause(500);
	}

	/**
	 * Click on cancel button
	 */
	public void cancelQuickAddEditTask(){
		click(ELEMENT_BUTTON_TASK_QUICK_CANCEL);
		waitForElementNotPresent(ELEMENT_BUTTON_TASK_QUICK_CANCEL);
	}

	public void cancelAddEditDetailTask(){
		click(ELEMENT_BUTTON_EVENT_CANCEL_DETAILS);
		waitForElementNotPresent(ELEMENT_BUTTON_EVENT_CANCEL_DETAILS);
	}


	/**
	 * Save a task with more details
	 */
	public void saveAddTaskDetails(){
		click(ELEMENT_BUTTON_TASK_SAVE_DETAILS);
		waitForElementNotPresent(ELEMENT_BUTTON_TASK_SAVE_DETAILS);
		Utils.pause(500);
	}

	/**
	 * Click on more details
	 */
	public void moreDetailsTask(){
		click(ELEMENT_BUTTON_TASK_MORE_DETAILS);
		waitForElementNotPresent(ELEMENT_BUTTON_TASK_MORE_DETAILS);
	}

	/**
	 * Remove attachment
	 * @param file
	 * 				name of file
	 */
	public void removeAttachment(String file){
		click(ELEMENT_TASK_ATTACHMENT.replace("${file}", "Remove"));
		waitForElementNotPresent(ELEMENT_TASK_ATTACHMENT.replace("${file}", file));
	}

}
