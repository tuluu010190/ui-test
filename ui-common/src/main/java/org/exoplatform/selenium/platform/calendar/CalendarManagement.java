package org.exoplatform.selenium.platform.calendar;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
public class CalendarManagement extends PlatformBase{

	PlatformPermission pPer;
	ManageAlert alert;

	//Common calendar action menu
	public By ELEMENT_CALENDAR_MENU_ACTIONS_ICON = By.xpath("//*[@class='uiIconCalSimplePlus uiIconLightGray']");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_ADD = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'AddCalendar')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_REMOTE = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'RemoteCalendar')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_ADD_EVENT_CATEGORY = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'AddEventCategory')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_IMPORT = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'ImportCalendar')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_CALENDAR_SETTING = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'CalendarSetting')]");

	//Add event category form
	public By ELEMENT_ADD_EVENT_CATEGORY_FORM = By.id("UICalendarPopupAction");
	public By ELEMENT_ADD_EVENT_CATEGORY_INPUT = By.id("eventCategoryName");
	public By ELEMENT_ADD_EVENT_CATEGORY_BUTTON_ADD = By.id("btnEventCategoryFormContainer");
	public String ELEMENT_ADD_EVENT_CATEGORY_BUTTON_CLOSE = "//*[@id='UIEventCategoryForm']//button[contains(text(),'Close')]";
	public String ELEMENT_LIST_EVENT_CATEGORY = "//*[@id='UIEventCategoryList']//span[contains(text(),'${categoryName}')]";
	public String ELEMENT_LIST_DELETE_EVENT_BUTTON = "//*[@id='UIEventCategoryList']//span[contains(text(),'${categoryName}')]/parent::td/parent::tr//a[@data-original-title='Delete']/i[@class='uiIconDelete uiIconLightGray']";
	public String ELEMENT_LIST_EDIT_EVENT_BUTTON = ".//*[@id='UIEventCategoryList']//span[contains(text(),'${categoryName}')]/parent::td/parent::tr//a[@data-original-title='Edit']/i[@class='uiIconEdit uiIconLightGray']";
	public By ELEMENT_EDIT_EVENT_CATEGORY_BUTTON_UPDATE = By.id("btnEventCategoryFormContainer");
	public final By ELEMENT_TOOLBAR_MINI_CALENDAR = By.xpath("//*[@class='weekDays']");
	
	//Add calendar form
	public By ELEMENT_CALENDAR_ADD_FORM = By.id("UICalendarPopupWindow");
	public By ELEMENT_CALENDAR_DISPLAY_NAME_INPUT = By.id("displayName");
	public By ELEMENT_CALENDAR_DESC_INPUT = By.xpath("//*[@id='UICalendarForm']//*[@id='description']");
	public By ELEMENT_CALENDAR_COLOR = By.xpath("//*[contains(@class,'displayValue')]");
	public By ELEMENT_CALENDAR_GROUP_TAB = By.linkText("Show in Groups");
	public By ELEMENT_CALENDAR_DETAIL_TAB = By.xpath("//*[text()='Details']");
	public By ELEMENT_CALENDAR_GROUP_INPUT = By.id("AddGroupInput");
	public String ELEMENT_CALENDAR_GROUP_ITEM = "//*[@id='UICalendarChildPopupWindow']//*[@data-original-title='$group']";
	public By ELEMENT_CALENDAR_ADD_GROUP_BUTTON = By.xpath("//*[@class='addGroup']//*[text()='Add']");
	public By ELEMENT_CALENDAR_ADD_SAVE_BUTTON = By.xpath("//*[@id='UICalendarForm']//*[text()='Save']");
	public String ELEMENT_CALENDAR_COLOR_SELECT = "//*[@id='UICalendarForm']//a[contains(@class,'${color}')]";

	//Calendar list
	public String ELEMENT_SHARED_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[text()='Shared Calendars']/..//*[text()='$calendar']";
	public String ELEMENT_GROUP_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[text()='Group Calendars']/..//*[text()='$calendar']";
	public String ELEMENT_PERSONAL_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[text()='Personal Calendars']/..//*[text()='$calendar']";
	public String ELEMENT_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[text()='$calendar']";
	public String ELEMENT_CALENDAR_SETTING_ICON="//*[text()='$calendar']/../..//*[contains(@class,'uiIconCalSettingMini')]";
	public By ELEMENT_CALENDAR_RIGHT_MENU=By.id("tmpMenuElement");
	public By ELEMENT_CALENDAR_ADD_TASK_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalCreateTask uiIconLightGray']");
	public By ELEMENT_CALENDAR_ADD_EVENT_MENU =By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalCreateEvent uiIconLightGray']");
	public By ELEMENT_CALENDAR_EDIT_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconEdit uiIconLightGray']");
	public By ELEMENT_CALENDAR_SHARE_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalShare uiIconLightGray']");
	public By ELEMENT_CALENDAR_REMOVE_MENU = By.xpath("//*[@id='tmpMenuElement']//*[contains(@href,'RemoveCalendar')]");
	public By ELEMENT_CALENDAR_IMPORT_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalImportCalendar uiIconLightGray']");
	public By ELEMENT_CALENDAR_EXPORT_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalExportCalendar uiIconLightGray']");
	public By ELEMENT_CALENDAR_REFRESH_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconRefresh uiIconLightGray']");	

	//Event/Task
	public By ELEMENT_CALENDAR_QUICK_ADD_EVENT_FORM = By.id("UIQuickAddEventPopupWindow");
	public By ELEMENT_CALENDAR_QUICK_ADD_TASK_FORM = By.id("UIQuickAddTask");
	public By ELEMENT_CALENDAR_IMPORT_FORM = By.xpath("//*[@class='uiImportForm']");
	public By ELEMENT_CALENDAR_EXPORT_FORM = By.id("UICalendarPopupWindow");
	public By ELEMENT_CALENDAR_SHARE_FORM = By.id("UISharedForm");
	public By ELEMENT_CALENDAR_REMOVE_FORM = By.xpath("//*[@class='confirmationIcon']");

	//Export form
	public By ELEMENT_CALENDAR_EXPORT_POPUP_FORM=By.id("UICalendarPopupWindow");
	public By ELEMENT_CALENDAR_EXPORT_FILE_NAME=By.id("name");
	public By ELEMENT_CALENDAR_EXPORT_SAVE_BUTTON=By.xpath("//*[@id='UIExportForm']//*[text()='Save']");
	
	//Import form
	public By ELEMENT_CALENDAR_IMPORT_POPUP_FORM=By.id("UIImportForm");
	public By ELEMENT_CALENDAR_IMPORT_DESC_INPUT = By.xpath("//form[@id='UIImportForm']//*[@id='description']");
	public By ELEMENT_CALENDAR_IMPORT_SAVE_BUTTON = By.xpath("//form[@id='UIImportForm']//*[text()='Save']");
	public By ELEMENT_CALENDAR_IMPORT_SELECT_FILE = By.name("file");
	public By ELEMENT_CALENDAR_IMPORT_DELETE_ICON = By.xpath("//a[@data-original-title='Delete']/i[@class='uiIconDelete uiIconLightGray']");
	public By ELEMENT_CALENDAR_IMPORT_NAME_INPUT = By.id("displayName");
	public By ELEMENT_CALENDAR_IMPORT_COLOR = By.xpath("//*[contains(@class,'displayValue')]");
	
	//Share calendar form
	public By ELEMENT_CALENDAR_SHARE_INPUT = By.id("PermissionOwnerInput");
	public By ELEMENT_CALENDAR_SELECT_USER_ICON = By.xpath("//*[@class='uiIconUser uiIconLightGray']");
	public By ELEMENT_CALENDAR_SELECT_MEMBERSHIP_ICON = By.xpath("//*[@class='uiIconMembership uiIconLightGray']");
	public By ELEMENT_CALENDAR_SELECT_GROUP_ICON = By.xpath("//*[@class='uiIconGroup uiIconLightGray']");
	public String ELEMENT_CALENDAR_SHARE_EDIT_PERMISSION = "//div[@title='${user}']/../..//input[@class='checkbox']";
	public By ELEMENT_CALENDAR_SHARE_ADD_BUTTON = By.xpath("//form[@id='UISharedForm']//*[text()='Add']");
	public By ELEMENT_CALENDAR_SHARE_SAVE_BUTTON = By.xpath("//form[@id='UISharedForm']//*[text()='Save']");
	public String ELEMENT_DELETE_SHARE_USER = "//*[@id='UISharedForm']//*[contains(text(),'{$user}')]/../..//*[@class='uiIconDelete uiIconLightGray']";

	//Remove calendar
	public final By ELEMENT_YES_BUTTON = By.xpath("//*[contains(@class, 'popup')]//*[contains(text(),'Yes')]");
	public final String ELEMENT_CONFIRM_REMOVE_CALENDAR_MSG="Are you sure you want to delete this calendar and all its events?";
	
	//Set timezone
	public By ELEMENT_CAL_SETTING_MENU = By.xpath("//*[@id='UIActionBar']//i[@class='uiIconSetting uiIconLightGray']");
	public String ELEMENT_CAL_SETTING_TIMEZONE_VALUE = "//*[@id='setting']//select[@name='timeZone']/option[@value='${timezoneOpt}']";
	public By ELEMENT_TIME_ZONE = By.name("timeZone");
	public By ELEMENT_SELECTED_TIME_ZONE = By.xpath("//*[@name='timeZone']//*[@selected='selected']");
	public By ELEMENT_SETTINGS_FORM_SAVE_BUTTON = By.xpath("//*[@id='UICalendarSettingForm']//*[text()='Save']");
	/**
	 * constructor
	 * @param dr
	 */
	public CalendarManagement(WebDriver dr){
		this.driver=dr;
		pPer = new PlatformPermission(driver);
		alert = new ManageAlert(driver);
	};

	/** 
	 * Open "Add calendar" form
	 * 
	 */
	public void goToAddCalendar(){
		info("Go to add calendar");
		click(ELEMENT_CALENDAR_MENU_ACTIONS_ICON);
		Utils.pause(3000);
		click(ELEMENT_CALENDAR_MENU_ACTIONS_ADD);
		waitForAndGetElement(ELEMENT_CALENDAR_ADD_FORM);
	}

	/** 
	 * Edit a calendar
	 * 
	 * @param oldName
	 * 				old name of calendar
	 * @param name
	 * 				new name of calendar
	 * @param description
	 * 				new description of calendar
	 * @param color
	 * 				new color of calendar
	 * @param group
	 * 				group: example (/developers, /platform/administrators, /platform/users, /platform/web-contributors, 
	 * 				/organization/management/executive-board, /organization/employees
	 * @param isType
	 * 				true: select a group by typing
	 * 				false: select a group by select group icon
	 */
	public void editCalendar(String oldName,String name, String description, String color, String group){
		executeActionCalendar(oldName, selectActionOption.EDIT);
		inputDataInDetailTabCalendarForm(name, description, color);
		if(group!=null && group!="")
		selectGroupInGroupTabCalendarForm(group,true);
	}
	
	/** 
	 * Open "Add calendar" form
	 * 
	 */
	public void goToAddEventCategoryCalendar(){
		info("Go to add calendar");
		click(ELEMENT_CALENDAR_MENU_ACTIONS_ICON);
		Utils.pause(3000);
		click(ELEMENT_CALENDAR_MENU_ACTIONS_ADD_EVENT_CATEGORY);
		waitForAndGetElement(ELEMENT_ADD_EVENT_CATEGORY_FORM);
	}
	
	/** 
	 * Go to Calendar Actions> Add Event Category
	 * 
	 * @param categoryName
	 * 				category name of Calendar
	 */
	public void addEventCategory(String categoryName){
		info("----Add new event category----");
		type(ELEMENT_ADD_EVENT_CATEGORY_INPUT,categoryName,true);
		click(ELEMENT_ADD_EVENT_CATEGORY_BUTTON_ADD);
		info("----Verify if event category is added in Category List or not----");
		waitForAndGetElement(ELEMENT_LIST_EVENT_CATEGORY.replace("${categoryName}", categoryName));
		click(ELEMENT_ADD_EVENT_CATEGORY_BUTTON_CLOSE);	 
	}
	
	/** 
	 * Delete Event Category
	 * 
	 * @param categoryName
	 * 				category name of calendar
	 */
	public void deleteEventCategory(String categoryName){
		ManageAlert alert = new ManageAlert(driver);
		Button button = new Button(driver);
		waitForAndGetElement(ELEMENT_LIST_DELETE_EVENT_BUTTON.replace("${categoryName}",categoryName));
		click(ELEMENT_LIST_DELETE_EVENT_BUTTON.replace("${categoryName}",categoryName));
		alert.acceptAlert();
		button.yes();
		waitForElementNotPresent(ELEMENT_LIST_DELETE_EVENT_BUTTON.replace("${categoryName}",categoryName));
		click(ELEMENT_ADD_EVENT_CATEGORY_BUTTON_CLOSE);	
	}
	
	/** 
	 * Edit Event Category
	 * 
	 * @param oldCategory
	 * 						old category name
	 * @param newCategory
	 * 						new category name
	 */

	public void editEventCategory(String oldCategory, String newCategory){
		waitForAndGetElement(ELEMENT_LIST_EDIT_EVENT_BUTTON.replace("${categoryName}",oldCategory));
		click(ELEMENT_LIST_EDIT_EVENT_BUTTON.replace("${categoryName}",oldCategory));
		type(ELEMENT_ADD_EVENT_CATEGORY_INPUT,newCategory,true);
		click(ELEMENT_EDIT_EVENT_CATEGORY_BUTTON_UPDATE);
		waitForAndGetElement(ELEMENT_LIST_EDIT_EVENT_BUTTON.replace("${categoryName}",newCategory));
		click(ELEMENT_ADD_EVENT_CATEGORY_BUTTON_CLOSE);
	}
	
	/** 
	 * Input into tab Detail of Add calendar form
	 * 
	 * @param name
	 * 			name of calendar
	 * @param description
	 * 			description of calendar
	 * @param color
	 * 			color of calendar
	 */
	public void inputDataInDetailTabCalendarForm(String name, String description, String color){
		info("Input into tab Detail of Add calendar form");
		click(ELEMENT_CALENDAR_DETAIL_TAB);
		if(name != null && name!="")
			type(ELEMENT_CALENDAR_DISPLAY_NAME_INPUT,name,true);
		if(description != null && description!="")
			type(ELEMENT_CALENDAR_DESC_INPUT, description,true);
		if(color != null && color !=""){
			click(ELEMENT_CALENDAR_COLOR);
			click(ELEMENT_CALENDAR_COLOR_SELECT.replace("${color}", color));
		}
	}

	/**
	 * selectGroupInGroupTabCalendarForm
	 * @param group
	 * 				group: example (/developers, /platform/administrators, /platform/users, /platform/web-contributors, 
	 * 				/organization/management/executive-board, /organization/employees
	 * @param isType
	 * 				true: select a group by typing
	 * 				false: select a group by select group icon
	 */
	public void selectGroupInGroupTabCalendarForm(String group, boolean isType){
		info("Input into tab Show in Group of Add calendar form");
		click(ELEMENT_CALENDAR_GROUP_TAB);
		if(group!=null&&group!=""){
			if(isType){
				type(ELEMENT_CALENDAR_GROUP_INPUT,group,true);
			}
			else{
				click(ELEMENT_CALENDAR_SELECT_GROUP_ICON);
				click(group);
			}
		}
		click(ELEMENT_CALENDAR_ADD_GROUP_BUTTON);
	}

	/**
	 * Save add calendar
	 */
	public void saveAddCalendar(){
		info("Save add calendar");
		click(ELEMENT_CALENDAR_ADD_SAVE_BUTTON);
		waitForElementNotPresent(ELEMENT_CALENDAR_ADD_FORM);
	}

	/**
	 * Open menu an a calendar
	 * @param calendar
	 * 					name of calendar
	 */
	public void openMenuOfCalendar(String calendar){
		info("Open menu of a calendar");
		mouseHoverByJavaScript(ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", calendar),2);
		click(ELEMENT_CALENDAR_SETTING_ICON.replace("$calendar", calendar),2);
		waitForAndGetElement(ELEMENT_CALENDAR_RIGHT_MENU);
	}

	/**
	 * View list in calendar
	 */
	public enum selectActionOption{
		ADDTASK, ADDEVENT, EDIT, REMOVE, SHARE, IMPORT, EXPORT, REFRESH
	}

	/**
	 * Execute action of calendar: Edit, Delete, Share, export....
	 * 
	 * @param calendar
	 * 				name of calendar
	 * @param action
	 * 				action that needs to be done, e.g.: "ShareCalendar"
	 */
	public void executeActionCalendar(String calendar, selectActionOption action){
		info("Select action from menu");
		openMenuOfCalendar(calendar);
		switch(action){
		case ADDTASK:
			click(ELEMENT_CALENDAR_ADD_TASK_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_QUICK_ADD_TASK_FORM);
			break;
		case ADDEVENT:
			click(ELEMENT_CALENDAR_ADD_EVENT_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_QUICK_ADD_EVENT_FORM);
			break;
		case EDIT:
			click(ELEMENT_CALENDAR_EDIT_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_ADD_FORM);
			break;
		case REMOVE:
			click(ELEMENT_CALENDAR_REMOVE_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_REMOVE_FORM);
			break;
		case SHARE:
			click(ELEMENT_CALENDAR_SHARE_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_SHARE_FORM);
			break;
		case IMPORT:
			click(ELEMENT_CALENDAR_IMPORT_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_IMPORT_FORM);
			break;
		case EXPORT:
			click(ELEMENT_CALENDAR_EXPORT_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_EXPORT_FORM);
			break;
		case REFRESH:
			click(ELEMENT_CALENDAR_REFRESH_MENU,2);
			break;
		default:
			click(ELEMENT_CALENDAR_ADD_TASK_MENU,2);
			waitForAndGetElement(ELEMENT_CALENDAR_QUICK_ADD_TASK_FORM);
			break;
		}
	}

	/** 
	 * Delete a calendar
	 * 
	 * @param name
	 * 				name of calendar
	 * @param verify
	 * 				optional parameter. If not be set, by default, it is considered that calendar is deleted 
	 * 				= true: verify that calendar is deleted, 
	 * 				= false: not verify that calendar is deleted, 
	 */
	public void deleteCalendar(String name, boolean...verify){
		boolean isVerify = (verify.length > 0 ? verify[0]: false);
		info("Remove calendar");
		driver.navigate().refresh();
		executeActionCalendar(name, selectActionOption.REMOVE);
		if(isVerify)
			alert.verifyAlertMessage(ELEMENT_CONFIRM_REMOVE_CALENDAR_MSG);
		else
			click(ELEMENT_YES_BUTTON);
		waitForElementNotPresent(ELEMENT_CALENDAR_LIST_ITEM.replace("$calendar", name));
	}

	/** 
	 * Share a calendar
	 * 
	 * @param calendar
	 * 				name of calendar
	 * @param userGroup
	 * 				array of users or groups that are shared with
	 * @param canEdit
	 * 				array of "canEdit" permissions for users, groups respectively inputed by userGroup variable 
	 * @param mode
	 * 				way to input users, groups.
	 *            =0: type directly
	 *            =1: select user
	 *            =2: select group
	 *            =3: select membership
	 */
	public void shareCalendar(String calendar, String[] userGroup, boolean[] canEdit, int...mode){
		info("Share calendar");
		executeActionCalendar(calendar, selectActionOption.SHARE);
		for(int i = 0; i < userGroup.length; i++){
			int modeUser = mode.length > i ? mode[i] : 0;
			switch (modeUser){
			case 0: 
				type(ELEMENT_CALENDAR_SHARE_INPUT,userGroup[i],false);
				break;
			case 1:
				click(ELEMENT_CALENDAR_SELECT_USER_ICON); 
				pPer.selectUserPermission(userGroup[i],1); break;
			case 2: 
				String[] group = userGroup[i].split(":");
				click(ELEMENT_CALENDAR_SELECT_GROUP_ICON);
				pPer.selectGroupPermission(group[0]); break;
			case 3: 
				String[] groupMem = userGroup[i].split(":");
				String[] membership = groupMem[1].split(".");
				click(ELEMENT_CALENDAR_SELECT_MEMBERSHIP_ICON);
				pPer.selectGroupMembership(groupMem[0],membership[1]); break;
			}
		}
		click(ELEMENT_CALENDAR_SHARE_ADD_BUTTON);
		for(int j=0; j < canEdit.length; j++){
			if(canEdit[j]==true){
				check(ELEMENT_CALENDAR_SHARE_EDIT_PERMISSION.replace("${user}", userGroup[j]),2);
			}
			else{
				uncheck(ELEMENT_CALENDAR_SHARE_EDIT_PERMISSION.replace("${user}", userGroup[j]),2);
			}
		}
		click(ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
		waitForElementNotPresent(ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
	}
	
	/** 
	 * Share a calendar
	 * 
	 * @param calendar
	 * 				name of calendar
	 * @param userGroup
	 * 				array of users or groups that are shared with
	 */
	public void removeUserGrooupFromShareCalendar(String calendar, String[] userGroup){
		info("Share calendar");
		executeActionCalendar(calendar, selectActionOption.SHARE);
		for(int i = 0; i < userGroup.length; i++){
			click(By.xpath(ELEMENT_DELETE_SHARE_USER.replace("{$user}",userGroup[i])));
		}
		click(ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
		waitForElementNotPresent(ELEMENT_CALENDAR_SHARE_SAVE_BUTTON);
	}

	/** 
	 * Upload calendar
	 * 
	 * @param path
	 * 			path of a file which will be uploaded.
	 */
	public void uploadCalendar(String path){
		info("--Upload Calendar--");
		WebElement element = waitForAndGetElement(ELEMENT_CALENDAR_IMPORT_SELECT_FILE, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", element);
		element.sendKeys(Utils.getAbsoluteFilePath(path));
		String[] links = path.split("/");
		waitForAndGetElement("//*[text()='"+links[links.length-1]+"']");
		info("import " + Utils.getAbsoluteFilePath(path));
		switchToParentWindow();
		waitForAndGetElement(ELEMENT_CALENDAR_IMPORT_DELETE_ICON);
	}
	
	/** 
	 * Import calendar
	 * 
	 * @param path
	 * 				path of a file which is for upload
	 * @param name
	 * 				name of calendar
	 * @param description
	 * 				description of calendar
	 * @param color
	 * 				color of calendar
	 */
	public void importCalendar(String path, String name, String description, String color){
		click(ELEMENT_CALENDAR_MENU_ACTIONS_ICON);
		Utils.pause(3000);
		click(ELEMENT_CALENDAR_MENU_ACTIONS_IMPORT);
		waitForAndGetElement(ELEMENT_CALENDAR_IMPORT_POPUP_FORM);
		uploadCalendar(path);
		if(name != null)
			type(ELEMENT_CALENDAR_IMPORT_NAME_INPUT,name,true);
		if(description != null)
			type(ELEMENT_CALENDAR_IMPORT_DESC_INPUT,description,true);

		if (color != null){
			click(ELEMENT_CALENDAR_IMPORT_COLOR);
			click(ELEMENT_CALENDAR_COLOR_SELECT.replace("${color}", color));
		}
		click(ELEMENT_CALENDAR_IMPORT_SAVE_BUTTON);
		waitForElementNotPresent(ELEMENT_CALENDAR_IMPORT_POPUP_FORM);
		driver.navigate().refresh();
		waitForAndGetElement(By.linkText(name));
	}

	
	/**
	 * Export calendar
	 * 
	 * @param calendar
	 * 				name of calendar
	 * @param name
	 * 				filename of exported calendar
	 */
	public void exportCalendar(String calendar, String name){
		info("Export calendar");
		executeActionCalendar(calendar, selectActionOption.EXPORT);
		waitForAndGetElement(ELEMENT_CALENDAR_EXPORT_POPUP_FORM);
		type(ELEMENT_CALENDAR_EXPORT_FILE_NAME,name,true);
		click(ELEMENT_CALENDAR_EXPORT_SAVE_BUTTON);
		waitForElementNotPresent(ELEMENT_CALENDAR_EXPORT_POPUP_FORM);
	}
	
	/** 
	 * Set timezone for Calendar
	 * 
	 * @param timezoneOpt
	 * 				time zone of calendar, e.g.: (GMT -11:00) Pacific/Samoa
	 */
	public void setTimezoneForCalendar(String timezoneOpt){
		click(ELEMENT_CAL_SETTING_MENU);
		Utils.pause(3000);
		info("-- Select filter option of Timezone --");
		select(ELEMENT_TIME_ZONE,timezoneOpt);	
		Utils.pause(1000);
		click(ELEMENT_SETTINGS_FORM_SAVE_BUTTON);
		Utils.pause(3000);
	}
}
