package org.exoplatform.selenium.platform.calendar;

import static org.exoplatform.selenium.TestLogger.info;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEditEventTaskManagement extends PlatformBase {

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
	
	
	//Attach file form
	public By ELEMENT_ATTACH_SAVE_BUTTON = By.xpath("//form[@id='UIAttachFileForm']//*[text()='Save']");
	public By ELEMENT_TASK_ADD_ATTACHMENT = By.xpath("//button[contains(@onclick,'AddAttachment')]");
	public String ELEMENT_TASK_ATTACHMENT = "//*[@id='UITaskForm']/..//a[@data-original-title='${file}']";
	public By ELEMENT_ATTACHMENT_SAVE_BUTTON = By.xpath("//*[@id='UIAttachFileForm']//*[text()='Save']");
	public String ELEMENT_ATTACHMENT_FORM_FILE_NAME = "//*[text()='$fileName']";
	
	public AddEditEventTaskManagement(WebDriver dr){
		driver = dr;
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
	 * Check default suggestion task time in quick add form
	 * @param from
	 * @param duration
	 */
	public void checkSuggestionTaskTimeInQuickForm(String from, int duration){
		info("Check date is current date");
		String dateFrom = getValue(ELEMENT_QUICK_INPUT_TASK_FROM_DATE);
		String dateTo = getValue(ELEMENT_QUICK_INPUT_TASK_TO_DATE);
		assert dateFrom.equals(getCurrentDate("MM/dd/yyyy"));
		assert dateTo.equals(getCurrentDate("MM/dd/yyyy"));

		info("Check default suggestion task time");
		if (from == null || from == ""){
			info("Check time suggestion default");				
		}else {
			info("Check suggesion when select From time");
			click(ELEMENT_QUICK_INPUT_TASK_FROM_TIME_INPUT, 2);
			click(ELEMENT_QUICK_TASK_SELECT_FROM_TIME.replace("${time}", from));
			Utils.pause(2000);
		}
		String fromTime = waitForAndGetElement(ELEMENT_QUICK_INPUT_TASK_FROM_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");
		info("From is " + fromTime);
		String toTime = waitForAndGetElement(ELEMENT_QUICK_INPUT_TASK_TO_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");
		info("From is " + toTime);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		try {
			Date fr = formatter.parse(fromTime);
			Date to = formatter.parse(toTime);
			long diff = (to.getTime() - fr.getTime())/60000;
			info("Duration is " + diff + " minus");
			assert duration == (int) diff;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check default suggestion task time in detail add form
	 * @param from
	 * @param duration
	 */
	public void checkSuggestionTaskTimeInDetailForm(String from, int duration){
		info("Check date is current date");
		String dateFrom = getValue(ELEMENT_ADD_EDIT_TASK_FROM_DATE);
		String dateTo = getValue(ELEMENT_ADD_EDIT_TASK_TO_DATE);
		assert dateFrom.equals(getCurrentDate("MM/dd/yyyy"));
		assert dateTo.equals(getCurrentDate("MM/dd/yyyy"));

		info("Check default suggestion task time");
		if (from == null || from == ""){
			info("Check time suggestion default");				
		}else {
			info("Check suggesion when select From time");
			click(ELEMENT_ADD_EDIT_TASK_FROM_TIME_INPUT, 2);
			click(ELEMENT_ADD_EDIT_TASK_SELECT_FROM_TIME.replace("${time}", from));
			Utils.pause(2000);
		}

		String fromTime = waitForAndGetElement(ELEMENT_ADD_EDIT_INPUT_TASK_FROM_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");
		info("From is " + fromTime);
		String toTime = waitForAndGetElement(ELEMENT_ADD_EDIT_INPUT_TASK_TO_TIME, DEFAULT_TIMEOUT, 1, 2).getAttribute("value");
		info("From is " + toTime);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		try {
			Date fr = formatter.parse(fromTime);
			Date to = formatter.parse(toTime);
			long diff = (to.getTime() - fr.getTime())/60000;
			info("Duration is " + diff + " minus");
			assert duration == (int) diff;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Save add Task
	 */
	public void saveQuickAddTask(){
		click(ELEMENT_BUTTON_TASK_SAVE);
		waitForElementNotPresent(ELEMENT_BUTTON_TASK_SAVE);
	}

	/**
	 * Save a task with more details
	 */
	public void saveAddTaskDetails(){
		click(ELEMENT_BUTTON_TASK_SAVE_DETAILS);
		waitForElementNotPresent(ELEMENT_BUTTON_TASK_SAVE_DETAILS);
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
