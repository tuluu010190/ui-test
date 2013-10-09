package org.exoplatform.selenium.platform.calendar;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author thuntn
 * @date 10 Oct 2013
 */
public class CalendarBase extends PlatformBase {

	PlatformPermission per;
	//Go to the calendar's page
	public String ID_CALENDAR_PAGE = "";
	public By ELEMENT_GET_ID_PAGE = By.xpath("//*[@id='CalendarApplicationMinWidth']/../..");
	public By ELEMENT_CALENDAR_LINK = By.className("uiIconPLFCalendar");
	public By ELEMENT_CALENDAR_PANEL = By.xpath("//div[@class='uiBox uiCalendars']");
	public String ELEMENT_CALENDAR_MINI_DATE= "//td[@class='highLight' and contains(text(),'${date}')]";
	public String ELEMENT_CALENDAR_SETTING_ICON = "//a[text()='${calendar}']/ancestor::li[contains(@class, 'calendarItem')]/div[contains(@id,'UICalendars')]";
	public By ELEMENT_CALENDAR_ACTIONS_ICON = By.xpath("//*[@class='uiIconCalSimplePlus uiIconLightGray']");
	public By ELEMENT_CALENDAR_ADD_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'AddCalendar')]");
	public By ELEMENT_CALENDAR_IMPORT_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'ImportCalendar')]");
	public String ELEMENT_CALENDAR_GET_BY_TAG_LI = "//a[@class='calendarName' and text()='${calendar}']/../..";
	
	//-----------Menu of calendar------------
	public By ELEMENT_CAL_ADD_EVENT_MENU = By.xpath("//*[@id='AddEvent']");
	public By ELEMENT_CAL_ADD_TASK_MENU = By.xpath("//*[@id='AddTask']");
	public By ELEMENT_CAL_REMOVE_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'RemoveSharedCalendar')]");
	public By ELEMENT_CAL_IMPORT_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'ImportCalendar')]");
	public By ELEMENT_CAL_EXPORT_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'ExportCalendar')]");
	public By ELEMENT_CAL_REFRESH_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'RefreshRemoteCalendar')]");
	public By ELEMENT_CAL_SHARE_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'ShareCalendar')]");
	public By ELEMENT_CAL_EDIT_MENU = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'EditCalendar')]");

	//------------Export calendar---------------
	public By ELEMENT_CALENDAR_EXPORT = By.xpath("//div[@id='CalendarPopupMenu']//*[@class='uiIconCalExportCalendar uiIconLightGray']");
	public By ELEMENT_CALENDAR_EXPORT_POPUP = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Export Calendar']");
	public By ELEMENT_CAL_EXPORT_FILE_NAME = By.id("name");
	public By ELEMENT_CAL_EXPORT_SAVE_BUTTON = By.xpath("//*[@id='UIExportForm']//*[text()='Save']");


	//---------- Add calendar-------------------
	public By ELEMENT_CAL_DISPLAY_NAME_INPUT = By.id("displayName");
	public By ELEMENT_CAL_DESC_INPUT = By.xpath("//*[@id='UICalendarForm']//*[@id='description']");
	public By ELEMENT_CAL_COLOR = By.xpath("//*[contains(@class,'displayValue')]");
	public String ELEMENT_CAL_COLOR_SELECT = "//form[@id='UICalendarForm']//a[contains(@class,'red colorCell')]";
	public By ELEMENT_CAL_ADD_SAVE_BUTTON = By.xpath("//*[@id='UICalendarForm']//*[text()='Save']");
	public By ELEMENT_CAL_ADD_POPUP= By.xpath("//span[@class='PopupTitle popupTitle' and text()='Calendar']");
	public By ELEMENT_CAL_GROUP_TAB = By.linkText("Show in Groups");
	public By ELEMENT_CAL_GROUP_INPUT = By.id("AddGroupInput");
	public By ELEMENT_CAL_SELECT_GROUP_ICON = By.xpath("//*[@class='uiIconGroup uiIconLightGray']");

	//-----------Event/Task -----------
	public String ELEMENT_EVENT_TASK_ALL_DAY = "//div[@class='eventAlldayContent asparagus' and contains(text(),'${event}')]";
	public String ELEMENT_EVENT_TASK_WORKING_PANE = "//div[contains(@class,'eventContainer') and contains(text(),'${event}')]"; 
	public By ELEMENT_EVENT_TASK_DELETE_MENU = By.xpath("//div[@id='tmpMenuElement']//a[@class='eventAction' and contains(@href,'Delete')]");
	public String MSG_EVENT_TASK_DELETE = "Are you sure you want to delete this event/task?";

	public String MSG_CALENDAR_DELETE = "Are you sure you want to delete this calendar and all its events?";

	//--------------Import calendar -------------------------
	public By ELEMENT_CAL_IMPORT_POPUP = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Calendar']");
	public By ELEMENT_CAL_IMPORT_TYPE = By.name("type");
	public By ELEMENT_CAL_IMPORT_SELECT_FILE = By.name("file");
	public By ELEMENT_CAL_IMPORT_FRAME_UDLOAD = By.xpath("//div[@id='upload']//iframe");
	public By ELEMENT_CAL_IMPORT_DESC_INPUT = By.xpath("//form[@id='UIImportForm']//*[@id='description']");
	public By ELEMENT_CAL_IMPORT_SAVE_BUTTON = By.xpath("//form[@id='UIImportForm']//*[text()='Save']");
	public By ELEMENT_CAL_IMPORT_DELETE_ICON = By.xpath("//a[@data-original-title='Delete']/i[@class='uiIconDelete uiIconLightGray']");

	//--------------Share calendar --------------------------
	public By ELEMENT_CAL_SELECT_USER_ICON = By.xpath("//*[@class='uiIconUser uiIconLightGray']");
	public By ELEMENT_CAL_SHARE_POPUP = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Share Calendar']");
	public By ELEMENT_CAL_SHARE_ADD_BUTTON = By.xpath("//form[@id='UISharedForm']//*[text()='Add']");
	public By ELEMENT_CAL_SHARE_SAVE_BUTTON = By.xpath("//form[@id='UISharedForm']//*[text()='Save']");
	public String ELEMENT_CAL_SHARE_EDIT_PERMISSION = "//div[@title='${user}']/../..//input[@class='checkbox']"; 
	public By ELEMENT_CAL_SHARE_INPUT = By.id("PermissionOwnerInput");
	public By ELEMENT_CAL_SELECT_MEMBERSHIP_ICON = By.xpath("//i[@class='uiIconMembership uiIconLightGray']");

	/*================== Common functions for Calendar =================*/

	/** Go to calendar
	 * @author thuntn
	 */
	public void goToCalendarPage(){	
		info("--Go to calendar--");
		click(ELEMENT_CALENDAR_LINK);
		waitForAndGetElement(ELEMENT_CALENDAR_PANEL);
		ID_CALENDAR_PAGE = waitForAndGetElement(ELEMENT_GET_ID_PAGE).getAttribute("id");
	}

	/** Get Property of a calendar
	 * @author thuntn
	 * @param calendar
	 * @param property = 1: ID
	 *                 = 2: type
	 *                 = 3: color
	 * @return: ID of calendar
	 */
	public String getPropertyOfCalendar(String calendar,int property){
		WebElement eCalendar = waitForAndGetElement(ELEMENT_CALENDAR_GET_BY_TAG_LI.replace("${calendar}", calendar));
		switch (property){
		case 1: return eCalendar.getAttribute("id");
		case 2: return eCalendar.getAttribute("caltype");
		case 3: return eCalendar.getAttribute("calcolor");
		default: return "";
		}
	}
	/**
	 * Execute action of calendar: Edit, Delete, Share, export....
	 * @author thuntn
	 * @param idCal
	 * @param action
	 * @param color
	 * @param type
	 */
	public void executeActionCalendar(String idCal, String action, String color, String type){
		((JavascriptExecutor)driver).executeScript("javascript:eXo.webui.UIForm.submitEvent('"+ID_CALENDAR_PAGE+"#UICalendars','"+action+"','&objectId="+idCal+"&calType="+type+"&calColor="+color+"')");
	}

	/** Share a calendar
	 * @author thuntn
	 * @param calendar
	 * @param userGroup
	 * @param canEdit
	 * @param mode
	 */
	public void shareCalendar(String calendar, String[] userGroup, boolean[] canEdit, int...mode){
		String idCal = getPropertyOfCalendar(calendar,1);
		String oldColor = getPropertyOfCalendar(calendar,3);
		String type = getPropertyOfCalendar(calendar,2);

		executeActionCalendar(idCal,"ShareCalendar", oldColor, type);

		for(int i = 0; i < userGroup.length; i++){
			int modeUser = mode.length > i ? mode[i] : 0;
			switch (modeUser){
			case 0: type(ELEMENT_CAL_SHARE_INPUT,userGroup[i],false);
			break;
			case 1:
				click(ELEMENT_CAL_SELECT_USER_ICON); 
				per.selectUserPermission(userGroup[i]); break;
			case 2: 
				String[] group = userGroup[i].split(":");
				click(ELEMENT_CAL_SELECT_GROUP_ICON);
				per.selectGroupPermission(group[0]); break;
			case 3: 
				String[] groupMem = userGroup[i].split(":");
				String[] membership = groupMem[1].split(".");
				click(ELEMENT_CAL_SELECT_MEMBERSHIP_ICON);
				per.selectGroupMembership(groupMem[0],membership[1]); break;
			}
		}

		click(ELEMENT_CAL_SHARE_ADD_BUTTON);

		for(int j=0; j < canEdit.length; j++){
			check(ELEMENT_CAL_SHARE_EDIT_PERMISSION.replace("${user}", userGroup[j]),2);
		}

		click(ELEMENT_CAL_SHARE_SAVE_BUTTON);
	}


	/** Open export calendar form
	 * @author thuntn
	 * @param calendar
	 */
	public void goToExportCalendar(String calendar){
		
		openMenuOfCalendar(calendar);
		click(ELEMENT_CAL_EXPORT_MENU);

		waitForAndGetElement(ELEMENT_CALENDAR_EXPORT_POPUP);
	}

	/**
	 * Export calendar
	 * @author thuntn
	 * @param calendar
	 * @param name
	 */
	public void exportCalendar(String calendar, String name){
		info("Export calendar");
		goToExportCalendar(calendar);
		type(ELEMENT_CAL_EXPORT_FILE_NAME,name,true);
		click(ELEMENT_CAL_EXPORT_SAVE_BUTTON);
	}

	/** Open Add calendar form
	 * @author thuntn
	 */
	public void goToAddCalendar(){
		click(ELEMENT_CALENDAR_ACTIONS_ICON);
		click(ELEMENT_CALENDAR_ADD_MENU);
	}

	/** Input into Add calendar form
	 * @author thuntn
	 * @param name
	 * @param desc
	 * @param color
	 * @param groups
	 */
	public void inputAddCalendarForm(String name, String desc, String color, String...groups){

		String type = groups.length > 2 ? (String) groups[1]: "0";
		per = new PlatformPermission(driver);
		but = new Button(driver);

		if(name != null)
			type(ELEMENT_CAL_DISPLAY_NAME_INPUT,name,true);
		if(desc != null)
			type(ELEMENT_CAL_DESC_INPUT, desc,true);
		if(color != null){
			click(ELEMENT_CAL_COLOR);
			click(ELEMENT_CAL_COLOR_SELECT.replace("${color}", color));
		}
		if(groups.length > 0){
			click(ELEMENT_CAL_GROUP_TAB);
			if(type.equals("0")){
				click(ELEMENT_CAL_SELECT_GROUP_ICON);
				click(ELEMENT_DATA_ORIGINAL_TITLE.replace("${title}", groups[0]));
			}else
				type(ELEMENT_CAL_GROUP_INPUT,groups[0],true);
			but.add();
		}
	}

	/** Add calendar
	 * @author thuntn
	 * @param name
	 * @param desc
	 * @param color: name of color which is used in @class of the color element, eg: hot_pink
	 * @param groups: name of group which is the same as data inputed by manual, eg: /platform/users
	 */
	public void addCalendar(String name, String desc, String color, String...groups){
		info("Add calendar");
		goToAddCalendar();
		inputAddCalendarForm(name,desc,color,groups);
		click(ELEMENT_CAL_ADD_SAVE_BUTTON);
		waitForAndGetElement(By.linkText(name));
	}

	/** Upload calendar
	 * @author thuntn
	 * @param path
	 */
	public void uploadCalendar(String path){
		info("--Upload Calendar--");

		WebElement element = waitForAndGetElement(ELEMENT_CAL_IMPORT_SELECT_FILE, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", element);
		element.sendKeys(Utils.getAbsoluteFilePath(path));
		String[] links = path.split("/");
		waitForAndGetElement("//*[text()='"+links[links.length-1]+"']");
		info("import " + Utils.getAbsoluteFilePath(path));
		//		driver.switchTo().defaultContent();
		switchToParentWindow();
		waitForAndGetElement(ELEMENT_CAL_IMPORT_DELETE_ICON);
	}

	/**
	 * Open form Import calendar
	 * @author thuntn
	 */
	public void goToImportCalendar(){
		click(ELEMENT_CALENDAR_ACTIONS_ICON);
		click(ELEMENT_CALENDAR_IMPORT_MENU);
		waitForAndGetElement(ELEMENT_CAL_IMPORT_POPUP);
	}

	/** Import calendar
	 * @author thuntn
	 * @param path
	 * @param name
	 * @param desc
	 * @param color
	 */
	public void importCalendar(String path, String name, String desc, String color){
		goToImportCalendar();
		uploadCalendar(path);
		if(name != null)
			type(ELEMENT_CAL_DISPLAY_NAME_INPUT,name,true);
		if(desc != null)
			type(ELEMENT_CAL_IMPORT_DESC_INPUT,desc,true);
		click(ELEMENT_CAL_COLOR);
		if (color != null)
			click(ELEMENT_CAL_COLOR_SELECT.replace("${color}", color));
		click(ELEMENT_CAL_IMPORT_SAVE_BUTTON);
		driver.navigate().refresh();
		waitForAndGetElement(By.linkText(name));
	}

	/** Delete event/task
	 * @author thuntn
	 * @param event
	 */
	public void deleteEventTask(String event){
		alert = new ManageAlert(driver);
		info("--Delete event--");

		if(waitForAndGetElement(ELEMENT_EVENT_TASK_ALL_DAY.replace("${event}", event),5000,0) == null)
			rightClickOnElement(ELEMENT_EVENT_TASK_WORKING_PANE.replace("${event}", event),2);
		else
			rightClickOnElement(ELEMENT_EVENT_TASK_ALL_DAY.replace("${event}", event),2);

		click(ELEMENT_EVENT_TASK_DELETE_MENU);
		alert.waitForConfirmation(MSG_EVENT_TASK_DELETE);
		waitForElementNotPresent(ELEMENT_EVENT_TASK_ALL_DAY.replace("${event}", event));
		waitForElementNotPresent(ELEMENT_EVENT_TASK_WORKING_PANE.replace("${event}", event));
	}

	/** Delete calendar
	 * @author thuntn
	 * @param name
	 * @param verify
	 */
	public void deleteCalendar(String name, boolean...verify){
		alert = new ManageAlert(driver); 
		boolean check = verify.length > 0 ? verify[0] : true;

		info("--Delete a Calendar-");
		String idCal = getPropertyOfCalendar(name,1);
		String color = getPropertyOfCalendar(name,3);
		String type = getPropertyOfCalendar(name,2);

		executeActionCalendar(idCal,"RemoveCalendar", color, type);

		if (check){
			waitForElementNotPresent(ELEMENT_CALENDAR_GET_BY_TAG_LI.replace("{$calendar}", name));
			info("Remove calendar successfully");
		}
	}

	/** Edit a calendar
	 * @author thuntn
	 * @param oldName
	 * @param name
	 * @param desc
	 * @param color
	 * @param groups
	 */
	public void editCalendar(String oldName,String name, String desc, String color, String...groups){
		String idCal = getPropertyOfCalendar(oldName,1);
		String oldColor = getPropertyOfCalendar(oldName,3);
		String type = getPropertyOfCalendar(oldName,2);

		executeActionCalendar(idCal,"EditCalendar", oldColor, type);
		inputAddCalendarForm(name,desc,color,groups);
		click(ELEMENT_CAL_ADD_SAVE_BUTTON);
		waitForAndGetElement(By.linkText(name));
	}


	/**Delete shared calendar
	 * @author thuntn
	 * @param calendar
	 */
	public void deleteSharedCalendar(String calendar){
		String idCal = getPropertyOfCalendar(calendar,1);
		String oldColor = getPropertyOfCalendar(calendar,3);
		String type = getPropertyOfCalendar(calendar,2);

		executeActionCalendar(idCal,"RemoveSharedCalendar", oldColor, type);
		waitForElementNotPresent(By.linkText(calendar));
	}
	
	/**
	 * @author thuntn
	 * @param calendar
	 */
	public void openMenuOfCalendar(String calendar){
		WebElement e = waitForAndGetElement(ELEMENT_CALENDAR_SETTING_ICON.replace("${calendar}", calendar),DEFAULT_TIMEOUT,0,2);
		mouseOver(By.linkText(calendar),true);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",e);
	}
}
