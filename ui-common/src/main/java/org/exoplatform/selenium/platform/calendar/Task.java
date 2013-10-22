package org.exoplatform.selenium.platform.calendar;

import static org.exoplatform.selenium.TestLogger.info;
import org.exoplatform.selenium.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Date 10 Oct 2013
 * @author thuntn
 *
 */
public class Task extends CalendarBase{

	public By ELEMENT_INPUT_TASK_TITLE = By.xpath("//*[@id='UIQuickAddTask']//*[@name='eventName']");
	public By ELEMENT_INPUT_TASK_NOTE = By.xpath("//*[@id='UIQuickAddTask']//*[@id='description']");
	public By ELEMENT_CHECKBOX_TASK_ALLDAY = By.xpath("//*[@id='UIQuickAddTask']//*[@name='allDay']");
	public By ELEMENT_INPUT_TASK_FROM = By.xpath("//*[@id='UIQuickAddTask']//*[@name='from']");
	public By ELEMENT_INPUT_TASK_TO = By.xpath("//*[@id='UIQuickAddTask']//*[@name='to']");
	public By ELEMENT_INPUT_TASK_FROM_TIME = By.xpath("//*[@id='fromTime']/../input");
	public By ELEMENT_INPUT_TASK_TO_TIME = By.xpath("//*[@id='toTime']/../input");
	public By ELEMENT_INPUT_TASK_CALENDAR = By.xpath("//*[@id='UIQuickAddTask']//*[@name='calendar']");
	public By ELEMENT_INPUT_TASK_CATEGORY = By.xpath("//*[@id='UIQuickAddTask']//*[@name='category']");
	public By ELEMENT_BUTTON_TASK = By.id("UIActionBarQuickAddTask");
	public By ELEMENT_BUTTON_TASK_SAVE = By.xpath("//*[@id='UIQuickAddTaskPopupWindow']//*[text()='Save']");
	
	public Task(WebDriver dr){
		driver = dr;
		button = new Button(driver);
	}
	
	/** Input into tab Detail of Add task form
	 * @author thuntn
	 * @param name
	 * @param note
	 * @param from
	 * @param to
	 * @param allDay
	 * @param opt
	 */
	public void inputDataQuickTask(String name, String note, String from, String to, boolean allDay,  String...opt){
		if (name != null){
			type(ELEMENT_INPUT_TASK_TITLE, name, true);
		}
		if (note != null){
			type(ELEMENT_INPUT_TASK_NOTE, note, true);
		}
		if (allDay){
			check(ELEMENT_CHECKBOX_TASK_ALLDAY,2);
		} else if (!allDay){
			uncheck(ELEMENT_CHECKBOX_TASK_ALLDAY,2);
		}
		if (from != null){
			if (from != ""){
				if (allDay){
					type(ELEMENT_INPUT_TASK_FROM, from, true);
				}else {
					String[] dateTime = from.split(" ");
					type(ELEMENT_INPUT_TASK_FROM, dateTime[0], true);
					if(dateTime.length > 1)
						type(ELEMENT_INPUT_TASK_FROM_TIME, dateTime[1], false);
				}
			}
		}
		if (to != null){
			if (to != ""){
				if (allDay){
					type(ELEMENT_INPUT_TASK_TO, to, true);
				}else{
					String[] dateTime = to.split(" ");
					type(ELEMENT_INPUT_TASK_TO, dateTime[0], true);
					if(dateTime.length > 1)
						type(ELEMENT_INPUT_TASK_TO_TIME, dateTime[1], false);
				}
			}
		}
		if (opt.length > 0 && opt[0] != null){
			select(ELEMENT_INPUT_TASK_CALENDAR, opt[0]);
		}
		if (opt.length > 1 && opt[1] != null){
			select(ELEMENT_INPUT_TASK_CATEGORY, opt[1]);
		}
	}
	
	/** Open form Add a task
	 * @author thuntn
	 */
	public void goToAddTask(){
		info("Go to Add Task page"); 
		click(ELEMENT_BUTTON_TASK);
	}
	
	/** Quick add task
	 * @author thuntn
	 * @param name
	 * @param note
	 * @param from
	 * @param to
	 * @param allDay
	 * @param opt
	 */
	public void addTask(String name, String note, String from, String to, boolean allDay, String...opt){
		goToAddTask();
		inputDataQuickTask(name,note,from,to,allDay,opt);
		click(ELEMENT_BUTTON_TASK_SAVE);
	}
	
}