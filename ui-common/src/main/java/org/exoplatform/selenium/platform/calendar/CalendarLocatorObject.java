package org.exoplatform.selenium.platform.calendar;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;

public class CalendarLocatorObject extends PlatformBase{

	/*-------------------------------------------------------CALENDAR HOME PAGE--------------------------------------------------------------------------------*/
	
	//GRID
	public String ELEMENT_EVENT_TASK_TITLE="//*[contains(text(),'${name}')]";
	public String ELEMENT_EVENT_TASK_COLOR=".//*[contains(text(),'$name')]/..//*[contains(@class,'$color')]";
	public String ELEMENT_EVENT_TASK_TITLE_WEEK_COUNT="(.//*[contains(@class,'eventContainer')]//*[contains(text(),'${name}')])[$number]";
	public By ELEMENT_ADD_EDIT_EVENT_POPUP = By.xpath(".//*[@id='UICalendarPopupWindow']");
	public final By ELEMENT_CALENDAR_WORKING_PANEL = By.id("UICalendarWorkingContainer");
	public final String ELEMENT_CELL_TO_WORKING_PANEL = "//td[contains(@startfull,'$date $time:00')]";
	public String ELEMENT_ANY_TARGET_DATE = "//*[contains(@startfull, '${targetDate}') or contains(@starttimefull, '${targetDate}')]";
	
	//Action bar-->left area (Add task/event)
	public By ELEMENT_BUTTON_TASK = By.id("UIActionBarQuickAddTask");
	public By ELEMENT_BUTTON_EVENT = By.id("UIActionBarQuickAddEvent");
	
	//Action bar--> right area-->Today link
	public final By ELEMENT_TODAY_ACTION_BAR=By.xpath("//*[@class='todayActionBar']");
	
	//Action bar--> right area-->Views types as Day,List,Week,Month, WorkWeek
	public final String ELEMENT_CALENDAR_VIEW_BUTTON = "//*[text()='$view']";
	public final String ELEMENT_CALENDAR_ACTIVE_VIEW = "//*[@class='btn active']//*[text()='$view']";
	
	//Action bar--> right area-->Settings
	public final By ELEMENT_ACTION_BAR_SETTING_ICON=By.xpath(".//*[@id='UIActionBar']//*[contains(@class,'uiIconSetting')]");
	
	//Action bar--> right area-->Quick Search
    public By ELEMENT_EVENT_TASK_QUICK_SEARCH=By.xpath(".//*[@id='value']");
    public By ELEMENT_EVENT_TASK_CLOSE_SEARCH_BTN=By.xpath(".//*[@id='UIListView']//button[contains(text(),'Close Search')]");
    public By ELEMENT_EVENT_TASK_SEARCH_BTN=By.xpath(".//*[@id='UISearchForm']//*[contains(@class,'uiIconSearch')]");
	
	//Calendar left panel-->General
    public By ELEMENT_SHOW_HIDE_LEFT_PANEL = By.xpath("//div[@id='ShowHideAll']/i");
    
    //Calendar left panel-->Mini calendar
  	
  	//Calendar left panel-->Calendar list
  	public By ELEMENT_CALENDAR_PANEL = By.xpath("//div[@class='uiBox uiCalendars']");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_ICON = By.xpath("//*[@class='uiIconCalSimplePlus uiIconLightGray']");
	public String ELEMENT_SHARED_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[text()='Shared Calendars']/..//*[text()='$calendar']";
	public String ELEMENT_GROUP_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[text()='Group Calendars']/..//*[text()='$calendar']";
	public String ELEMENT_PERSONAL_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[text()='Personal Calendars']/..//*[text()='$calendar']";
	public String ELEMENT_CALENDAR_LIST_ITEM="//*[@id='UICalendars']//*[contains(text(),'$calendar')]";
	public String ELEMENT_CALENDAR_LIST_ITEM_COLOR="//*[@id='UICalendars']//*[text()='$calendar']/..//*[contains(@class,'$color')]";
	public String ELEMENT_CALENDAR_LIST_UNCHECKED=".//*[contains(@data-original-title,'$calendar')]/..//*[contains(@class,'iconUnCheckBox')]";
	public String ELEMENT_CALENDAR_LIST_CHECKED=".//*[contains(@data-original-title,'$calendar')]/..//*[contains(@class,'iconCheckBox')]";
	public String ELEMENT_CALENDAR_SETTING_ICON="//*[text()='$calendar']/../..//*[contains(@class,'uiIconCalSettingMini')]";
	
  	//VIEW GENERAL-->Header bar
	public final By ELEMENT_NEXT_BUTTON_ANY_VIEW=By.xpath("//*[@class='title']//*[contains(@class,'uiIconMiniArrowRight')]");
	public final By ELEMENT_PREVIOUS_BUTTON_ANY_VIEW=By.xpath("//*[@class='title']//*[contains(@class,'uiIconMiniArrowLeft')]");
	public final By ELEMENT_CATEGORY_OPTION=By.xpath("//*[@name='eventCategories']");
	public final String ELEMENT_CATEGORY_OPTION_SELECTED="//*[@name='eventCategories']//*[@selected='selected' and text()='$name']";
 	public By ELEMENT_EVENT_TASK_DELETE_BUTTON =By.xpath(".//*[contains(@data-original-title,'Delete')]//*[contains(@class,'uiIconDelete')]");
 	public final String ELEMENT_TASK_EVENT_RECURRING_ICON="(.//*[contains(text(),'$name')]/..//*[contains(@class,'uiIconCalRecurring')])[$number]";
 	public final String ELEMENT_TASK_EVENT_RECURRING_ICON_ONLY_EVENT=".//*[contains(@class,'eventContainerBorder ')]//*[contains(text(),'$name')]/..//*[contains(@class,'uiIconCalEditRecurring')]";
 	public final By ELEMENT_TASK_EVENT_RECURRING_POPOVER_CONTENT=By.xpath(".//*[@class='popover-content']//*[contains(text(),'Recurring event')]");
 	public final By ELEMENT_TASK_EVENT_RECURRING_POPOVER_CONTENT_EDIT=By.xpath(".//*[@class='popover-content']//*[contains(text(),'Edited Recurring event')]");
	//LIST VIEW-->Header bar
	public By ELEMENT_CALENDAR_LIST_TAB_SELECT_ALL_CHECKBOX=By.xpath(".//*[@id='UIListUsers']//*[contains(@data-original-title,'Select All')]//input");
  
	
   	
    //LIST VIEW-->Grid
  	public final String ELEMENT_EVENT_TASK_LIST_VIEW="//*[@id='UIListView']//*[@class='uiListViewRow']//*[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_START_DETAIL_DATE_LIST_VIEW="//*[@id='UIListView']//*[contains(text(),'$name')]/../..//td[5][contains(text(),'$date')]";
  	public final String ELEMENT_EVENT_TASK_END_DETAIL_DATE_LIST_VIEW="//*[@id='UIListView']//*[contains(text(),'$name')]/../..//td[6][contains(text(),'$date')]";
    public final String ELEMENT_EVENT_TASK_ATTACHMENT_LIST_VIEW =".//*[@id='UIPreview']//*[contains(@data-original-title,'${file}')]";
    public final String ELEMENT_EVENT_TASK_PARTICIPANTS_LIST_VIEW=".//*[@id='RowContainerDay']//*[contains(text(),'${username}')]";
    public String ELEMENT_EVENT_TASK_DETAIL_LIST_VIEW=".//*[@id='UIPreview']//*[contains(text(),'$name')]";
  	public String ELEMENT_EVENT_TASK_CHECKBOX_LIST_VIEW=".//*[contains(text(),'$name')]/../..//input";
  	public By ELEMENT_CALENDAR_ROW_TAB_LIST=By.xpath(".//*[@id='UIListUsers']//td[1]");
   	public By ELMENT_CALENDAR_TAB_LIST_EMPTY=By.xpath(".//*[@id='UIListUsers']//*[contains(@class,'empty')]");
	public By ELEMENT_EVENT_TASK_DETAIL_IMAGE_VIEW=By.xpath(".//*[@id='UIPreview']//*[contains(@class,'columnLeft')]//*[@class='view']");
    public By ELEMENT_EVENT_TASK_DETAIL_IMAGE_THUMBNAIL=By.xpath(".//*[@id='UIPreview']//*[contains(@class,'columnLeft')]//*[@class='thumbnailContainer']");
	public By ELEMENT_EVENT_TASK_DETAIL_ATTACHMENT_ICON=By.xpath(".//*[@id='UIPreview']//*[contains(@class,'columnLeft')]//*[contains(@class,'uiIcon16x16nt_file')]");
    
    //DAY VIEW-->Grid
  	public final String ELEMENT_EVENT_TASK_DAY_VIEW_ALL_DAY="//*[@id='UIDayView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(.,'$name')]";
  	public final String ELEMENT_EVENT_TASK_DAY_VIEW_ONE_DAY="//*[@id='UIDayViewGrid']//div[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_DAY_ONE_DAY=".//*[contains(@class,'tdLine')][contains(@startfull,'$date')]";
  	public final String ELEMENT_EVENT_TASK_DAY_TIME=".//*[@id='UIDayViewGrid']//*[contains(text(),'$name')]/..//*[contains(text(),'$time')]";
     
    //WEEK VIEW-->Grid
  	public final String ELEMENT_EVENT_TASK_WEEK_VIEW_ALL_DAY="//*[@id='UIWeekView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer') and contains(@style,'display: block')]//div[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_WEEK_VIEW_ONE_DAY="//*[@id='UIWeekViewGrid']//div[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ONE_DAY = "//*[@id='UIWeekViewGrid']//*[contains(@startfull,'$date')]//div[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_VIEW_ALL_DAY = "//*[@id='UIWeekViewGridAllDay']//*[contains(text(),'$name')]/..[contains(@starttimefull,'$date')]";
  	public final String ELEMENT_WEEK_VIEW_BAR_TIME="//*[@class='eventWeekBar']//td['$index']/a";
  	public final String ELEMENT_EVENT_TASK_DETAIL_TIME_WEEK="//*[@id='UIWeekViewGrid']//*[contains(@startfull,'$date')]//div[contains(text(),'$name')]/..//*[contains(.,'$time')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ONE_DAY = "//*[@id='UIWeekViewGrid']//*[contains(@startfull,'$date')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WEEK_ALL_DAY = "//*[@id='UIWeekViewGridAllDay']//*[contains(@starttimefull,'$date')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_TIME_WEEK_ONE_DAY="//*[@id='UIWeekViewGrid']//*[contains(text(),'$name')]/..//*[contains(.,'$time')]";
  	public String ELEMENT_EVENT_TASK_NUMBER_RECURRING_WEEK_VIEW="(.//*[@id='UIWeekViewGrid']//*[contains(text(),'$name')])[$number]";
  	public final String ELEMENT_EVENT_TASK_WEEK_TIME=".//*[@id='UIWeekViewGrid']//*[contains(text(),'$name')]/..//*[contains(.,'$time')]";
    //MONTH VIEW-->Grid
  	public final String ELEMENT_EVENT_TASK_MONTH_VIEW="//*[@id='UIMonthView']//span[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_MONTH_DATE="//*[@id='UIMonthViewGrid']//*[contains(@starttimefull,'$date')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW="//*[@id='UIMonthView']//*[@class='eventMonthContent']//*[@class='rowContainerDay']/*[contains(@starttimefull,'$date')]//span[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW_MORE="//*[@id='UIMonthView']//*[@class='eventMonthContent']//*[@class='moreEventContainer']//*[contains(@starttimefull,'$date')]//span[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW_MORE_ICON="//*[@id='UIMonthView']//*[contains(@starttimefull,'$date')]/..//*[@class='moreEvent' and not(contains(@style, 'display'))]/*[@class='moreEventLabel']";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_MONTH_VIEW_MORE_LABEL=".//*[contains(@starttimefull,'$date')]/../../..//*[contains(@class,'moreEventLabel')]";
  	public final String ELEMENT_EVENT_TASK_CHECKBOX=".//*[contains(text(),'$name')]/../..//input[@type='checkbox']";
  	public final String ELEMENT_EVENT_TASK_CHECKBOX_CHECKED=".//*[contains(text(),'$name')]/../..//input[@checked='checked']";
  	public final String ELEMENT_CELL_TO_MONTH_WORKING_PANEL = "//td[contains(@starttimefull,'$date')]";
  	public String ELEMENT_EVENT_TASK_NUMBER_RECURRING_MONTH_VIEW_CHECKBOX="(.//*[@id='UIMonthView']//*[contains(text(),'$name')])[$number]/../..//input[@type='checkbox']";
  	public String ELEMENT_EVENT_TASK_NUMBER_RECURRING_MONTH_VIEW_CHECKBOX_DATE="//*[@id='UIMonthView']//*[@class='eventMonthContent']//*[@class='rowContainerDay']/*[contains(@starttimefull,'$date')]//span[contains(text(),'$name')]/../..//input[@type='checkbox']";
  	public String ELEMENT_EVENT_TASK_NUMBER_RECURRING_MONTH_VIEW="(.//*[@id='UIMonthView']//*[contains(text(),'$name')])[$number]";
      
    //WORK WEEK VIEW-->Grid
  	public final String ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ALL_DAY="//*[@id='UIWeekView']//*[@class='eventAllDay']//*[contains(@class,'eventContainer')]//div[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_WORK_WEEK_VIEW_ONE_DAY="//*[@id='UIWeekView']//div[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ONE_DAY = "//*[@id='UIWeekViewGrid']//*[contains(@startfull,'$date')]//div[contains(text(),'$name')]";
  	public final String ELEMENT_EVENT_TASK_DETAIL_DATE_WORK_WEEK_VIEW_ALL_DAY = "//*[@id='UIWeekViewGridAllDay']//*[contains(@starttimefull,'$date')]//div[contains(text(),'$name')]";

	
	/*-------------------------------------------------------CATEGORY MANAGEMENT--------------------------------------------------------------------------------*/
	
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
  	public final By ELEMENT_DELETE_ALL_CATEGORY=By.xpath(".//*[contains(text(),'Cannot delete the default event category.')]");
  	public final By ELEMENT_DELETE_ALL_CATEGORY_OK_BTN=By.xpath(".//*[contains(@class,'UIPopupWindow')]//*[contains(text(),'OK')]");

	
	/*-------------------------------------------------------CALENDAR MANAGEMENT--------------------------------------------------------------------------------*/
    //CONTEXT MENU-->CALENDAR ACTIONS
  	public By ELEMENT_CALENDAR_MENU = By.id("tmpMenuElement");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_ADD = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'AddCalendar')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_REMOTE = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'RemoteCalendar')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_ADD_EVENT_CATEGORY = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'AddEventCategory')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_IMPORT = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'ImportCalendar')]");
	public By ELEMENT_CALENDAR_MENU_ACTIONS_CALENDAR_SETTING = By.xpath("//*[@id='tmpMenuElement']//a[contains(@href,'CalendarSetting')]");
	public String ELEMENT_CALENDAR_MENU_ACTIONS_COLOR=".//*[@id='tmpMenuElement']//a[contains(@class,'${color}')]";
	
	//CONTEXT MENU-->CALENDAR DETAIL ACTIONS
	public By ELEMENT_CALENDAR_RIGHT_MENU=By.id("tmpMenuElement");
	public By ELEMENT_CALENDAR_ADD_TASK_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalCreateTask uiIconLightGray']");
	public By ELEMENT_CALENDAR_ADD_EVENT_MENU =By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalCreateEvent uiIconLightGray']");
	public By ELEMENT_CALENDAR_ADD_EVENT_MENU_NO_DISPLAY=By.xpath(".//*[@id='tmpMenuElement']//*[contains(@style,'display: none;')]//*[contains(@class,'uiIconCalCreateEvent')]");
	public By ELEMENT_CALENDAR_EDIT_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconEdit uiIconLightGray']");
	public By ELEMENT_CALENDAR_SHARE_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalShare uiIconLightGray']");
	public By ELEMENT_CALENDAR_REMOVE_MENU = By.xpath("//*[@id='tmpMenuElement']//*[contains(@href,'RemoveCalendar')]");
	public By ELEMENT_CALENDAR_REMOVE_SHARE_CALENDAR=By.xpath("//*[@id='tmpMenuElement']//*[contains(@href,'RemoveSharedCalendar')]");
	public By ELEMENT_CALENDAR_IMPORT_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalImportCalendar uiIconLightGray']");
	public By ELEMENT_CALENDAR_EXPORT_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalExportCalendar uiIconLightGray']");
	public By ELEMENT_CALENDAR_REFRESH_MENU = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconRefresh uiIconLightGray']");
    
	//Calendar import form
	public By ELEMENT_CALENDAR_IMPORT_POPUP_FORM=By.id("UIImportForm");
	public By ELEMENT_CALENDAR_IMPORT_DESC_INPUT = By.xpath("//form[@id='UIImportForm']//*[@id='description']");
	public By ELEMENT_CALENDAR_IMPORT_SAVE_BUTTON = By.xpath("//form[@id='UIImportForm']//*[text()='Save']");
	public By ELEMENT_CALENDAR_IMPORT_SELECT_FILE = By.name("file");
	public By ELEMENT_CALENDAR_IMPORT_DELETE_ICON = By.xpath("//a[@data-original-title='Delete']/i[@class='uiIconDelete uiIconLightGray']");
	public By ELEMENT_CALENDAR_IMPORT_NAME_INPUT = By.id("displayName");
	public By ELEMENT_CALENDAR_IMPORT_COLOR = By.xpath("//*[contains(@class,'displayValue')]");
	
	//Calendar export form
	public By ELEMENT_CALENDAR_EXPORT_POPUP_FORM=By.id("UICalendarPopupWindow");
	public By ELEMENT_CALENDAR_EXPORT_FILE_NAME=By.id("name");
	public By ELEMENT_CALENDAR_EXPORT_SAVE_BUTTON=By.xpath("//*[@id='UIExportForm']//*[text()='Save']");
		
	//Calendar share form
	public By ELEMENT_CALENDAR_SHARE_FORM = By.id("UISharedForm");
	public By ELEMENT_CALENDAR_SHARE_INPUT = By.id("PermissionOwnerInput");
	public By ELEMENT_CALENDAR_SELECT_USER_ICON = By.xpath("//*[@class='uiIconUser uiIconLightGray']");
	public By ELEMENT_CALENDAR_SELECT_MEMBERSHIP_ICON = By.xpath("//*[@class='uiIconMembership uiIconLightGray']");
	public By ELEMENT_CALENDAR_SELECT_GROUP_ICON = By.xpath("//*[@class='uiIconGroup uiIconLightGray']");
	public String ELEMENT_CALENDAR_SHARE_EDIT_PERMISSION = "//div[@title='${user}']/../..//input[@class='checkbox']";
	public By ELEMENT_CALENDAR_SHARE_ADD_BUTTON = By.xpath("//form[@id='UISharedForm']//*[text()='Add']");
	public By ELEMENT_CALENDAR_SHARE_SAVE_BUTTON = By.xpath("//form[@id='UISharedForm']//*[text()='Save']");
	public String ELEMENT_DELETE_SHARE_USER = "//*[@id='UISharedForm']//*[contains(text(),'{$user}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
    public By ELEMENT_CALENDAR_WARINING_POPUP=By.xpath(".//*[contains(@class,'warningIcon')]");
    public By ELEMENT_CALENDAR_OK_BTN_WARNING_POPUP=By.xpath(".//*[contains(@class,'warningIcon')]/../../..//*[contains(@class,'btn')]");
	
	
	//Calendar information popup for removing
	public By ELEMENT_CALENDAR_REMOVE_FORM = By.xpath("//*[@class='confirmationIcon']");
	public final By ELEMENT_YES_BUTTON = By.xpath("//*[contains(@class, 'popup')]//*[contains(text(),'Yes')]");
	public final String ELEMENT_CONFIRM_REMOVE_CALENDAR_MSG="Are you sure you want to delete this calendar and all its events?";

	
	//Calendar setting form
	public By ELEMENT_CALENDAR_SETTING_FORM=By.id("UICalendarSettingForm");
	public By ELEMENT_CALENDAR_SETTING_DISPLAY_TAB= By.xpath("//*[@data-target='#defaultCalendarTab-tab']");
	public By ELEMENT_CALENDAR_SETTING_FEED_TAB= By.xpath("//*[@data-target='#feedTab-tab']");
	public By ELEMENT_CALENDAR_SETTING_VIEW_TYPE=By.name("viewType");
	public By ELEMENT_CALENDAR_SETTING_TIME_ZONE=By.name("timeZone");
	public By ELEMENT_CALENDAR_SETTING_DATE_FORMAT=By.name("dateFormat");
	public By ELEMENT_CALENDAR_SETTING_TIME_FORMAT=By.name("timeFormat");
	public By ELEMENT_CALENDAR_SETTING_WEEK_START_ON=By.name("weekStartOn");
	public By ELEMENT_CALENDAR_SETTING_SHOW_WORKING_TIME_CHECKBOX = By.xpath(".//input[@id='showWorkingTime']");
	public By ELEMENT_CALENDAR_SETTING_SHOW_WORKING_BEGIN_TIME = By.name("beginTime");
	public By ELEMENT_CALENDAR_SETTING_SHOW_WORKING_END_TIME = By.name("endTime");
	public By ELEMENT_CALENDAR_SETTING_NEVER_SEND_INVITE_CHECKBOX = By.xpath("//*[@value='never']");
	public By ELEMENT_CALENDAR_SETTING_ALWAYS_SEND_INVITE_CHECKBOX = By.xpath("//*[@value='always']");
	public By ELEMENT_CALENDAR_SETTING_ASK_SEND_INVITE_CHECKBOX = By.xpath("//*[@value='ask']");
	public String ELEMENT_CALENDAR_SETTING_TIMEZONE_VALUE = "//*[@id='setting']//select[@name='timeZone']/option[@value='$time']";
	public String ELEMENT_CALENDAR_SETTING_VIEWTYPE_VALUE = "//*[@id='setting']//select[@name='viewType']/option[@value='$view']";
	public String ELEMENT_CALENDAR_SETTING_DATEFORMAT_VALUE = "//*[@id='setting']//select[@name='dateFormat']/option[@value='$date']";
	public String ELEMENT_CALENDAR_SETTING_TIMEFORMATE_VALUE = "//*[@id='setting']//select[@name='timeFormat']/option[@value='$time']";
	public String ELEMENT_CALENDAR_SETTING_STARTON_VALUE = "//*[@id='setting']//select[@name='weekStartOn']/option[@value='$time']";
	public By ELEMENT_SETTING_FORM_SAVE_BUTTON = By.xpath(".//*[@id='UICalendarSettingForm']//button[1]");
	public By ELEMENT_SETTING_FORM_CANCEL_BUTTON = By.xpath(".//*[@id='UICalendarSettingForm']//button[2]");

	//Calendar setting - Displayed calendar form
	public String ELEMENT_DISPLAY_FORM_PERSONAL_CALENDAR_ITEM="//*[@id='UIPopupCalendarSettingContainer']//*[text()='Personal Calendars']/../..//*[@class='calendarName' and text()='$name']";
	public String ELEMENT_DISPLAY_CALENDAR_FORM_CHECKED=".//*[@id='UICalendarPopupWindow']//*[contains(text(),'$calendar')]/..//*[contains(@class,'iconCheckBox')]";
	public String ELEMENT_DISPLAY_CALENDAR_FORM_UNCHECKED=".//*[@id='UICalendarPopupWindow']//*[contains(text(),'$calendar')]/..//*[contains(@class,'iconUnCheckBox')]";
	public String ELEMENT_DISPLAY_FORM_GROUP_CALENDAR_ITEM="//*[@id='UIPopupCalendarSettingContainer']//*[text()='Group Calendars']/../..//*[@class='calendarName' and contains(text(),'$name')]";
	public String ELEMENT_DISPLAY_FORM_GROUP_CALENDAR_ITEM_CHECKBOX="//*[@id='UIPopupCalendarSettingContainer']//*[text()='Group Calendars']/../..//*[@class='calendarName' and contains(text(),'$name')]/../..//*[@class='iconCheckBox checkbox' or @class='checkbox iconCheckBox']";
	public String ELEMENT_DISPLAY_FORM_GROUP_CALENDAR_ITEM_UNCHECKBOX="//*[@id='UIPopupCalendarSettingContainer']//*[text()='Group Calendars']/../..//*[@class='calendarName' and contains(text(),'$name')]/../..//*[@class='iconUnCheckBox checkbox' or @class='checkbox iconUnCheckBox']";

	//Calendar setting - Feed tab
	public By ELEMENT_FEED_TAB_FORM = By.id("feedTab");
	public By ELEMENT_FEED_TAB_SAVE_BUTTON = By.xpath("//*[@id='feedTab']//*[text()='Add']");
	public By ELEMENT_FEED_EDIT_FEED_FORM=By.xpath("//*[@id='UIEditFeed' and @class='UIEditFeed']");
	public By ELEMENT_FEED_EDIT_FEED_SAVE_FORM=By.xpath("//*[@id='UIEditFeed' and @class='UIEditFeed']//*[contains(@onclick,'Save')]");
	public By ELEMENT_FEED_EDIT_FEED_CANCEL_FORM=By.xpath("//*[@id='UIEditFeed' and @class='UIEditFeed']//*[contains(@onclick,'Cancel')]");
	public By ELEMENT_FEED_NAME_INPUT=By.id("name");
	public By ELEMENT_FEED_URL_INPUT=By.id("url");
	public By ELEMENT_FEED_CALENDAR_OPTION=By.name("addMore");
	public By ELEMENT_FEED_EDIT_FEED_RESET_URL=By.xpath("//*[@id='UIEditFeed' and @class='UIEditFeed']//*[@data-original-title='Reset URL']");
	public By ELEMENT_FEED_EDIT_FEED_GENERATE_URL=By.xpath("//*[@id='UIEditFeed' and @class='UIEditFeed']//*[@data-original-title='Generate URL']");
	public By ELEMENT_FEED_EDIT_FEED_ADD_CALENDAR=By.xpath("//*[@id='UIEditFeed' and @class='UIEditFeed']//*[@data-original-title='Add Calendar']");
	public String ELEMENT_FEED_EDIT_FEED_DELETE_CALENDAR="//*[@id='UIEditFeed' and @class='UIEditFeed']//*[text()='$name']/../..//*[@class='uiIconDelete uiIconLightGray']";
	public String ELEMENT_FEED_LIST_ITEM_RSS="//*[@id='UIFeedList']//*[text()='$name']/../..//*[@data-original-title='Rss']";
	public String ELEMENT_FEED_LIST_ITEM_RSS_BUTTON="//*[@id='UIFeedList']//*[text()='$name']/../..//*[@data-original-title='Rss']";
	public String ELEMENT_FEED_LIST_ITEM_EDIT_BUTTON="//*[@id='UIFeedList']//*[text()='$name']/../..//*[@data-original-title='Edit']";
	public String ELEMENT_FEED_LIST_ITEM_DELETE_BUTTON="//*[@id='UIFeedList']//*[text()='$name']/../..//*[@data-original-title='Delete']";
	public String ELEMENT_FEED_CONFIRM_DELETE="Are you sure you want to delete this feed from the list?";
	public String ELEMENT_FEED_CONFIRM_ADD_FEED="The feed $name has been generated successfully";

	//Remote calendar form
	public By ELEMENT_REMOTE_CALENDAR_FORM=By.id("UICalendarPopupWindow");
	public By ELEMENT_REMOTE_CALENDAR_URL=By.id("url");
	public By ELEMENT_REMOTE_CALENDAR_ICALENDAR_RADIO= By.xpath(".//*[@id='UISubscribeForm']//input[contains(@value,'ICalendar(.ics)')]");
	public By ELEMENT_REMOTE_CALENDAR_CALDAV_RADIO= By.xpath(".//*[@id='UISubscribeForm']//input[contains(@value,'CalDAV')]");
	public final By ELMENT_REMOTE_CALENDAR_NEXT_BTN =By.xpath(".//*[@id='UISubscribeForm']//button[1]");
	public final By ELMENT_REMOTE_CALENDAR_SUBCRIBE_CANCEL_BTN =By.xpath(".//*[@id='UISubscribeForm']//button[2]");
	public final By ELEMENT_REMOTE_CALENDAR_NAME = By.xpath(".//.//*[@id='UIRemoteCalendar']//*[@id='name']");
	public final By ELEMENT_REMOTE_CALENDAR_DES = By.xpath(".//*[@id='UIRemoteCalendar']//*[@id='description']");
	public final By ELEMENT_REMOTE_CALENDAR_SAVE_BTN = By.xpath(".//*[@id='UIRemoteCalendar']//button[2]");
	public final By ELEMENT_REMOTE_CALENDAR_CANCEL_BTN =By.xpath(".//*[@id='UIRemoteCalendar']//button[3]");
	public By ELEMENT_REMOTE_CALENDAR_AUTHENTICATION_CHECKBOX = By.xpath(".//*[@name='useAuthentication']");
	public By ELEMENT_REMOTE_CALENDAR_USERNAME_FIELD_DISABLED = By.xpath(".//*[@id='username'][contains(@disabled,\"\")]");
	public By ELEMENT_REMOTE_CALENDAR_USERNAME_FIELD_ENABLED = By.id("username");
	public By ELEMENT_REMOTE_CALENDAR_PASSWORD_FIELD_ENABLED = By.id("password");
	public By ELEMENT_REMOTE_CALENDAR_WARNING_AUTHENTICATION=By.xpath(".//*[contains(text(),'The remote URL is invalid or the authentication failed.')]");
	public By ELEMENT_REMOTE_CALENDAR_WARNING_INVALID_URL=By.xpath(".//*[contains(text(),'The \"URL\" field does not contain a valid URL.')]");
	public By ELEMENT_REMOTE_CALENDAR_WARNING_EMPTY_DISPLAY_NAME=By.xpath(".//*[contains(text(),'The field \"Display Name\" is required.')]");
	public By ELEMENT_REMOTE_CALENDAR_WARNING_EMPTY_USERNAME=By.xpath(".//*[contains(text(),'Username required to authenticate.')]");
	
	public By ELEMENT_REMOTE_CALENDAR_BACK_BTN = By.xpath(".//*[@id='UIRemoteCalendar']//button[1]");
	public By ELEMENT_REMOTE_CALENDAR_COLOR_FIELD = By.xpath("//*[contains(@class,'displayValue')]");
	public String ELEMENT_REMOTE_CALENDAR_COLOR_SELECT = ".//*[@id='UIRemoteCalendar']//*[contains(@class,'${color}')]";
	
	//Add calendar form
	public By ELEMENT_CALENDAR_ADD_FORM = By.id("UICalendarPopupWindow");
	public By ELEMENT_CALENDAR_DISPLAY_NAME_INPUT = By.id("displayName");
	public By ELEMENT_CALENDAR_DESC_INPUT = By.xpath("//*[@id='UICalendarForm']//*[@id='description']");
	public By ELEMENT_CALENDAR_TIMEZONE=By.id("timeZone");
	public By ELEMENT_CALENDAR_COLOR = By.xpath("//*[contains(@class,'displayValue')]");
	public By ELEMENT_CALENDAR_GROUP_TAB = By.xpath(".//*[@id='uiPopupAddCalendarContainer']//*[contains(@data-target,'#public-tab')]");
	public By ELEMENT_CALENDAR_DETAIL_TAB = By.xpath("//*[text()='Details']");
	public By ELEMENT_CALENDAR_GROUP_INPUT = By.id("AddGroupInput");
	public By ELEMENT_CALENDAR_GROUP_INPUT_USER=By.xpath(".//*[contains(@class,'inputLarge')]//input");
	public By ELEMENT_CALENDAR_GROUP_SELECT_USER_BTN=By.xpath(".//*[@id='public']//*[contains(@class,'uiIconUser')]");
	public String ELEMENT_CALENDAR_GROUP_USER_IN_SELECT_FORM=".//*[@id='UIGroupSelector']//*[contains(text(),'$user')]";
	public By ELEMENT_CALENDAR_GROUP_SELECT_ROLE_BTN=By.xpath(".//*[@id='public']//*[contains(@class,'uiIconMembership')]");
	public String ELEMENT_CALENDAR_GROUP_REMOVE_BTN=".//*[contains(text(),'$group')]/..//*[contains(@class,'uiIconDelete')]";
	public String ELEMENT_CALENDAR_GROUP_TOOLTIP_ONLY_PERMISSION=".//*[contains(text(),'$group')]/..//*[contains(@title,'Only 1 permission, cannot delete')]";
	public String ELEMENT_CALENDAR_GROUP_REMOVE_DISABLE_BTN=".//*[contains(text(),'$group')]/..//*[contains(@class,'disableIcon')]";
	public String ELEMENT_CALENDAR_GROUP_USER_PERMISSION=".//*[@id='UICalendarPopupWindow']//*[contains(@value,'$user')]";
	public String ELEMENT_CALENDAR_GROUP_ITEM = "//*[@id='UICalendarChildPopupWindow']//*[@data-original-title='$group']";
	public By ELEMENT_CALENDAR_ADD_GROUP_BUTTON = By.xpath("//*[@class='addGroup']//*[text()='Add']");
	public By ELEMENT_CALENDAR_ADD_SAVE_BUTTON = By.xpath("//*[@id='UICalendarForm']//*[text()='Save']");
	public By ELEMENT_CALENDAR_ADD_CANCEL_BUTTON = By.xpath("//*[@id='UICalendarForm']//*[text()='Cancel']");
	public By ELEMENT_CALENDAR_ADD_RESET_BUTTON = By.xpath("//*[@id='UICalendarForm']//*[text()='Reset']");
	public String ELEMENT_CALENDAR_COLOR_SELECT = "//*[@id='UICalendarForm']//a[contains(@class,'${color}')]";
	public By ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_GROUP_BTN=By.xpath(".//*[@rel='tooltip' and @data-original-title='Group']");
	public By ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_ACTIONS_SELECT_USER_BTN=By.xpath(".//*[@rel='tooltip' and @title='Select User']");
	public By ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_ACTIONS_SELECT_ROLE_BTN=By.xpath(".//*[@rel='tooltip' and @title='Select Role']");
	public By ELEMENT_CALENDAR_GROUP_TAB_TOOLTIP_ACTIONS_DELETE_PERMISSION_BTN=By.xpath(".//*[@rel='tooltip' and @title='Delete Permission']");
	public By ELEMENT_CALENDAR_GROUP_TAB_TABLE_GROUPS_COLUMN=By.xpath(".//*[@id='public']//th[text()='Groups']");
	public By ELEMENT_CALENDAR_GROUP_TAB_TABLE_USERS_COLUMN=By.xpath(".//*[@id='public']//th[text()='User able to edit calendar']");
	public By ELEMENT_CALENDAR_GROUP_TAB_TABLE_ACTIONS_COLUMN=By.xpath(".//*[@id='public']//th[text()='Actions']");
	public By ELEMENT_CALENDAR_GROUP_TAB_TABLE_EMPTY=By.xpath(".//*[@id='public']//td[text()='No Group Selected']");
	
	//Edit calendar form
	public By ELEMENT_CALENDAR_EDIT_ENABLE_PUBLIC_LINK = By.xpath(".//*[@id='calendarDetail']//*[contains(text(),'Enable Public Access')]");
	public By ELEMENT_CALENDAR_EDIT_DISNABLE_PUBLIC_LINK = By.xpath(".//*[@id='calendarDetail']//*[contains(text(),'Disable Public Access')]");
	public By ELEMENT_CALENDAR_EDIT_PUBLIC_LINK_BTN=By.xpath(".//*[@id='calendarDetail']//*[contains(@title,'Open')]//*[contains(@class,'uiIconCalICal')]");
	public By ELEMENT_CALENDAR_EDIT_FEED_LINK=By.xpath(".//*[@id='UIFeed']//*[contains(@class,'feedLink')]");
	public By ELEMENT_CALENDAR_EDIT_FEED_CLOSED_BTN=By.xpath(".//*[@id='UIFeed']//button");
	
	
	//*-------------------------------------------------------EVENT/TASK MANAGEMENT GENERAL--------------------------------------------------------------------------------*\\
	
	//CONTEXT MENU-->Right Click on Task/Event in Grid
	public By ELEMENT_CONTEXT_MENU= By.xpath(".//*[@id='tmpMenuElement']");
	public By ELEMENT_CONTEXT_MENU_VIEW=By.xpath(".//*[@id='tmpMenuElement']//*[contains(@class,'iIconPreview')]");
	public By ELEMENT_CONTEXT_MENU_EDIT=By.xpath(".//*[@id='tmpMenuElement']//*[contains(@class,'uiIconEdit')]");
	public By ELEMENT_CONTEXT_MENU_DELETE=By.xpath(".//*[@id='tmpMenuElement']//*[contains(@class,'uiIconDelete')]");
	public By ELEMENT_CONTEXT_MENU_EXPORT=By.xpath(".//*[@id='tmpMenuElement']//*[contains(@class,'uiIconCalExportCalendar')]");
	
	//CONTEXT MENU-->Right click on empty grid
	public By ELEMENT_CONTEXT_MENU_ADD_EVENT=By.xpath(".//*[@id='tmpMenuElement']//*[contains(@class,'uiIconCalCreateEvent')]");
	public By ELEMENT_CONTEXT_MENU_ADD_TASK=By.xpath(".//*[@id='tmpMenuElement']//*[contains(@class,'uiIconCalCreateTask')]");
	
	
	//Preview Task/Event popup
    public final String ELEMENT_CALENDAR_PREVIEW_TASK_EVENT=".//*[@id='UIPreviewPopup']//strong[contains(text(),'${name}')]";
  	public By ELEMENT_PREVIEW_TASK_EVENT_FORM=By.id("UIEventPreview");
  	public String ELEMENT_PREVIEW_TASK_EVENT_NAME="//*[@id='UIEventPreview']//*[text()='$name']";
  	public By ELEMENT_CLOSE_PREVIEW_TASK_EVENT_FORM=By.xpath("//*[@id='UIEventPreview']//*[text()='Close']");
  	
   //Confirm popup Task/Event
  	public By ELEMENT_CONFIRM_POPUP_OK=By.xpath(".//*[@id='UIConfirmation']//*[contains(text(),'Yes')]");
  	public By ELEMENT_CONFIRM_POPUP_DELETE=By.xpath(".//*[contains(@class,'uiConfirmForm')]//button[1]");
	public By ELEMENT_CONFIRM_POPUP_NO=By.xpath(".//*[@id='UIConfirmation']//*[contains(text(),'No')]");
	
	
	//ADD QUICK TASK FORM
	public By ELEMENT_CALENDAR_QUICK_ADD_TASK_FORM = By.id("UIQuickAddTask");
	
	//ADD/EDIT DETAIL TASK/EVENT FORM
	public By ELEMENT_ADD_EDIT_TASK_POPUP = By.xpath("//span[@class='PopupTitle popupTitle' and (text()='Add/Edit Tasks' or text()='Add/Edit Event')]");

	//Resize task or event
	public String ELEMENT_RESIZE_CONTAINER = "//*[contains(text(),'$name')]/../..//*[@class='resizeEventContainer']";
	public final String ELEMENT_EVENT_TASK_RESIZE_CONTAINER="//*[contains(text(),'$name')]/..//*[contains(@class,'resizeEventContainer')]/span";

	//Delete task/event warning
	public String ELEMENT_CONFIRM_DELETE_TASK_MSG = "Are you sure you want to delete this task?";
	public String ELEMENT_CONFIRM_DELETE_EVENT_MSG = "Are you sure you want to delete this event?";
	
	//quick and advance search of Task/Event
	public By ELEMENT_QUICK_SEARCH_INPUT=By.id("value");
	public String ELEMENT_QUICK_SEARCH_FORM = "//div[@class='uiSearchForm uiSearchInput pull-right']";
	public String ELEMENT_BUTTON_CLOSE_QUICK_SEARCH_RESULT = "//*[@id='UIListView']//button[contains(text(),'Close Search')]";
	public String ELEMENT_BUTTON_OPEN_ADVANCE_SEARCH_FORM = "//*[@id='UIListView']//button[contains(text(),'Advanced Search')]";
	public String ELEMENT_INPUT_TEXT_ADVANCE_SEARCH = "//*[@id='UIAdvancedSearchForm']//*[@id='text']";
	public String ELEMENT_BUTTON_SEARCH_ADVANCE_SEARCH = "//*[@id='UIAdvancedSearchForm']//button[contains(text(),'Search')]";

	//*----------------------------------------------------EVENT MANAGEMANT------------------------------------------------------------------------*\\
	//ADD QUICK EVENT FORM
	public By ELEMENT_CALENDAR_QUICK_ADD_EVENT_FORM = By.id("UIQuickAddEventPopupWindow");
	public By ELEMENT_QUICK_ADD_EVENT_POPUP = By.id("UIQuickAddEventPopupWindow");
	public By ELEMENT_QUICK_INPUT_EVENT_NAME = By.xpath("//*[@id='UIQuickAddEvent']//*[@id='eventName']");
	public By ELEMENT_QUICK_INPUT_EVENT_NOTE = By.xpath("//*[@id='UIQuickAddEvent']//*[@id='description']");
	public By ELEMENT_QUICK_INPUT_EVENT_CALENDAR = By.xpath("//*[@id='UIQuickAddEvent']//*[@name='calendar']");
	public By ELEMENT_QUICK_INPUT_EVENT_CATEGORY = By.xpath("//*[@id='UIQuickAddEvent']//*[@name='category']");
	public By ELEMENT_QUICK_CHECKBOX_EVENT_ALLDAY = By.xpath("//*[@id='UIQuickAddEvent']//*[@name='allDay']");
	public By ELEMENT_QUICK_INPUT_EVENT_FROM_DATE = By.xpath("//*[@id='UIQuickAddEvent']//*[@name='from']");
	public By ELEMENT_QUICK_INPUT_EVENT_TO_DATE = By.xpath("//*[@id='UIQuickAddEvent']//*[@name='to']");
	public String ELEMENT_QUICK_INPUT_EVENT_FROM_DATE_VALUE = "//*[@id='UIQuickAddEvent']//*[@name='from'][contains(@value,'$value')]";
	public String ELEMENT_QUICK_INPUT_EVENT_TO_DATE_VALUE = "//*[@id='UIQuickAddEvent']//*[@name='to'][contains(@value,'$value')]";
	public By ELEMENT_QUICK_INPUT_EVENT_FROM_TIME = By.xpath("//*[@id='UIQuickAddEvent']//input[@id='fromTime']");
	public String ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_VALUE = "//*[@id='UIQuickAddEvent']//input[@id='fromTime'][contains(@value,'$value')]";
	public By ELEMENT_QUICK_INPUT_EVENT_TO_TIME = By.xpath("//*[@id='UIQuickAddEvent']//input[@id='toTime']");
	public String ELEMENT_QUICK_INPUT_EVENT_TO_TIME_VALUE = "//*[@id='UIQuickAddEvent']//input[@id='toTime'][contains(@value,'$value')]";
	public By ELEMENT_QUICK_INPUT_EVENT_FROM_TIME_INPUT = By.xpath("//*[@id='UIQuickAddEvent']//*[@id='fromTime']/..//*[@class='UIComboboxInput']");
	public By ELEMENT_QUICK_INPUT_EVENT_TO_TIME_INPUT = By.xpath("//*[@id='UIQuickAddEvent']//*[@id='toTime']/..//*[@class='UIComboboxInput']");
	public String ELEMENT_QUICK_EVENT_SELECT_TO_TIME = "//*[@id='UIQuickAddEvent']//*[@id='toTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
	public String ELEMENT_QUICK_EVENT_SELECT_FROM_TIME = "//*[@id='UIQuickAddEvent']//*[@id='fromTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
	public By ELEMENT_BUTTON_EVENT_SAVE = By.xpath("//*[@id='UIQuickAddEventPopupWindow']//*[text()='Save']");
	public String ELEMENT_ITEM_QUICK_EVENT_CATEGORY_OPTION="//*[@id='UIQuickAddEventPopupWindow']//*[@name='category']/*[text()='$category']";
    public String ELEMENT_EVENT_TITLE =".//*[@id='UIWeekViewGrid']//*[contains(@class,'eventContainer') and text()='${name}']";
    public String ELEMENT_EVENT_INPUT_EVENT_TIME_COMBOBOX=".//*[@id='eventDetail']//input[@class='UIComboboxInput' and @value='${time}']";
	
    //Add EVENT Form (more details )
    public By ELEMENT_ADD_EDIT_EVENT_POPUP_FORM=By.xpath("//*[@id='UIEventForm']");
  	public By ELEMENT_ADD_EDIT_EVENT_NAME = By.xpath("//*[@id='UIEventForm']//*[@name='eventName']");
  	public By ELEMENT_ADD_EDIT_EVENT_NOTE = By.xpath("//*[@id='UIEventForm']//*[@id='description']");
  	public By ELEMENT_ADD_EDIT_EVENT_LOCATION=By.xpath("//*[@id='UIEventForm']//*[@id='place']");
  	public By ELEMENT_ADD_EDIT_EVENT_CALENDAR = By.xpath("//*[@id='UIEventForm']//*[@name='calendar']");
  	public By ELEMENT_ADD_EDIT_EVENT_CATEGORY = By.xpath("//*[@id='UIEventForm']//*[@name='category']");
  	public By ELEMENT_ADD_EDIT_EVENT_PRIORITY = By.xpath("//*[@id='UIEventForm']//*[@name='priority']");
  	public By ELEMENT_ADD_EDIT_EVENT_ALLDAY = By.xpath("//*[@id='UIEventForm']//*[@name='allDay']");
  	public By ELEMENT_ADD_EDIT_EVENT_FROM_DATE = By.xpath("//*[@id='UIEventForm']//*[@name='from']");
  	public By ELEMENT_ADD_EDIT_EVENT_TO_DATE = By.xpath("//*[@id='UIEventForm']//*[@name='to']");
  	public By ELEMENT_ADD_EDIT_INPUT_EVENT_FROM_TIME = By.xpath("//*[@id='UIEventForm']//*[@name='fromTime']");
  	public By ELEMENT_ADD_EDIT_INPUT_EVENT_TO_TIME = By.xpath("//*[@id='UIEventForm']//*[@name='toTime']");
  	public By ELEMENT_ADD_EDIT_EVENT_FROM_TIME_INPUT = By.xpath("//*[@id='UIEventForm']//*[@id='fromTime']/..//*[@class='UIComboboxInput']");
  	public By ELEMENT_ADD_EDIT_EVENT_TO_TIME_INPUT = By.xpath("//*[@id='UIEventForm']//*[@id='toTime']/..//*[@class='UIComboboxInput']");
  	public String ELEMENT_ADD_EDIT_EVENT_SELECT_FROM_TIME = "//*[@id='UIEventForm']//*[@id='fromTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
  	public String ELEMENT_ADD_EDIT_EVENT_SELECT_TO_TIME = "//*[@id='UIEventForm']//*[@id='toTime']/..//*[@class='UIComboboxLabel' and text()='${time}']";
  	public By ELEMENT_ADD_EDIT_EVENT_REPEAT_CHECKBOX=By.id("isRepeat");
  	public By ELEMENT_BUTTON_EVENT_MORE_DETAILS = By.xpath("//*[@id='UIQuickAddEventPopupWindow']//*[text()='More Details']");
  	public By ELEMENT_BUTTON_EVENT_QUICK_CANCEL = By.xpath("//*[@id='UIQuickAddEventPopupWindow']//*[text()='Cancel']");
  	public By ELEMENT_BUTTON_EVENT_CANCEL_DETAILS = By.xpath("//*[ @id='UIEventForm']//*[text()='Cancel']");
  	public By ELEMENT_BUTTON_EVENT_SAVE_DETAILS = By.xpath("//*[@id='UIEventForm']//*[text()='Save']");
  	public String ELEMENT_ATTACH_FILE_NAME = "//*[@data-original-title='$fileName']";
  	public By ELEMENT_EVENT_FILE_INPUT = By.xpath("//*[@id='upload']//*[@name='file']");
  	public By ELEMENT_SELECT_FILE_BUTTON=By.xpath("//*[@class='uploadButton']/*[@class='btn']");

  	public By ELEMENT_EVENT_REMINDER_TAB = By.xpath("//*[text()='Reminders']");
  	public By ELEMENT_EVENT_PARTICIPANTS_TAB = By.xpath("//*[text()='Participants']");
  	public By ELEMENT_EVENT_SCHEDULE_TAB = By.xpath("//*[text()='Schedule']");
  	public By ELEMENT_EVENT_DETAILS_TAB = By.xpath("//*[text()='Details']");
  	
  	//Warning message
  	public final String ELEMENT_CREATE_EVENT_TASK_SPECIAL_CHARATERS_MESSAGE=".//*[contains(@class,'warningIcon')][contains(text(),\"Event summary does not contain ${characters}.\")]";
      public final By ELEMENT_CREATE_EVENT_TASK_TIME =By.xpath(".//*[contains(text(),'To date must be later than From date.')]");
  	//Attach file form
  	public By ELEMENT_ATTACH_SAVE_BUTTON = By.xpath("//form[@id='UIAttachFileForm']//*[text()='Save']");
  	public By ELEMENT_ATTACH_LABEL_FIELD=By.xpath(".//*[@id='eventDetail']//div[@class='control-label' and text()='Files:']");
  	public By ELEMENT_EVENT_ADD_ATTACHMENT = By.xpath("//button[contains(@onclick,'AddAttachment')]");
  	public String ELEMENT_EVENT_ATTACHMENT = "//*[@id='UIEventForm']/..//a[@data-original-title='${file}']";
  	public By ELEMENT_ATTACHMENT_SAVE_BUTTON = By.xpath("//*[@id='UIAttachFileForm']//*[text()='Save']");
  	public String ELEMENT_ATTACHMENT_FORM_FILE_NAME = "//*[@class='fileNameLabel' and text()='$fileName']";
    public String ELEMENT_ATTACHMENT_DELETE_BTN="//*[@data-original-title='$fileName']/following-sibling::*[2]";
    public By ELEMENT_ATTACH_FORM=By.xpath(".//*[contains(@class,'UIAttachFileForm')]");
    public By ELEMENT_ATTACHMENT_FORM_SELECT_FILE=By.xpath(".//*[@id='upload']//label[text()='Select File']");
    public By ELEMENT_ATTACHMENT_FORM_NO_FILE=By.xpath(".//*[@id='upload']//label[@class='noFile']");

  	//Schedule tab
  	public final By ELEMENT_ADD_PARTICIPANTS_BUTTON_IN_SCHEDULE_TAB = By.xpath("//*[@id='UIEventForm']//*[@class='uiIconCalInviteUser uiIconLightGray']");
  	public final String ELEMENT_USER_CHECKBOX_FULLNAME = "//*[contains(text(),'${user}')]/../..//*[@type='checkbox']";
  	public final String ELEMENT_USER_CHECKBOX_USERNAME = "//*[@name='${user}']";
  	public final String ELEMENT_SCHEDULE_BUSY_TIME = "//*[@id='${user}']/../../../../..//td[${index}]";
  	public final String ELEMENT_SCHEDULE_TIME = "//*[@id='RowContainerDay']/../../../..//tr[2]//td[${index}]";
  	public final By ELEMENT_SCHEDULE_NEXT_DAY=By.xpath("//*[@title='Next Day' or @data-original-title='Next Day']");
  	public final By ELEMENT_SCHEDULE_PREVIOUS_DAY=By.xpath("//*[@title='Previous Day' or @data-original-title='Previous Day']");
  	public final String ELEMENT_SCHEDULE_DRAG = "//td[${index}]//span[@data-original-title=\"Drag here to change your event's start and end times\" or @title=\"Drag here to change your event's start and end times\"]";
  	public final String ELEMENT_SCHEDULE_SELECTED_DATE="//*[@id='RowContainerDay' and @datevalue='$date']";
  	public final String ELEMENT_SCHEDULE_TOOLTIP_PARTICIPANTS=".//*[@id='RowContainerDay']//tr[2]/td[${index}]/span[contains(@rel,'tooltip')][contains(@data-original-title,\"Drag here to change your event's start and end times\")]";
  	

  	//Participant tab
  	public final By ELEMENT_PRIVACY_PUBLIC_CHECKBOX=By.xpath("//*[@value='public']");
  	public final By ELEMENT_PRIVACY_PRIVATE_CHECKBOX=By.xpath("//*[@value='private']");
  	public final By ELEMENT_AVAILABLE_CHECKBOX=By.xpath("//*[@value='available']");
  	public final By ELEMENT_BUSY_CHECKBOX=By.xpath("//*[@value='busy']");
  	public final By ELEMENT_OUTSIDE_CHECKBOX=By.xpath("//*[@value='outside']");
  	public final By ELEMENT_SEND_INVITATION_NEVER_CHECKBOX=By.xpath("//*[@value='never']");
  	public final By ELEMENT_SEND_INVITATION_ALWAYS_CHECKBOX=By.xpath("//*[@value='always']");
  	public final By ELEMENT_SEND_INVITATION_ASK_CHECKBOX=By.xpath("//*[@value='ask']");
  	public final By ELEMENT_ADD_PARTICIPANTS_BUTTON_IN_PARTICIPANT_TAB = By.xpath("//*[@class='uiFormGrid']//*[@class='uiIconPlus uiIconLightGray']");
  	public final By ELEMENT_PICK_USER_PARTICIPANTS_TAB =By.xpath(".//*[@id='uiInvitationUser']/*[contains(@class,'uiIconUser')]");
  	public final By ELEMENT_INVITATION_PARTICITPANT_USER=By.xpath("//*[@id='eventShare-tab']//*[@data-original-title='Add Participant' or @title='Add Participant']");
  	public final By ELEMENT_INVITATION_PARTICIPANT_TEXTBOX=By.id("participant");
  	public final By ELEMENT_INVITATION_PARTICITPANT_MSG=By.id("invitation-msg");
  	public final By ELEMENT_INVITATION_SELECT_USER_BUTTON=By.id("uiInvitationUser");
  	public final By ELEMETN_INVITATION_SAVE_BUTTON=By.xpath("//*[@id='UIInvitationContainer']//*[text()='Save']");
  	public final By ELEMETN_INVITATION_CANCEL_BUTTON=By.xpath("//*[@id='UIInvitationContainer']//*[text()='Cancel']");
  	public final String ELEMENT_PARTICIPANT_SEND_INVITATION_OPTION_CHECKED=".//*[@id='eventShare']//input[@value='$option' and @checked='checked']";
  	public final By ELEMENT_CONFIRM_SEND_INVITATION_MESSAGE =By.xpath(".//*[@id='UIConfirmation']//*[contains(text(),'Would you like to send updates to all guests?')]");
  	public final By ELMEMENT_CONFIRM_SEND_INVITATION_YES_BTN=By.xpath(".//*[@id='UIConfirmation']//*[contains(@class,'btn')][contains(text(),'Yes')]");
  	public final By ELMEMENT_CONFIRM_SEND_INVITATION_NO_BTN=By.xpath(".//*[@id='UIConfirmation']//*[contains(@class,'btn')][contains(text(),'No')]");
  	public final String ELEMENT_INVITATION_PARTICIPANTS_USER=".//*[@id='UIParticipantList']//tr//*[contains(text(),'$fullName')]";
  	public final String ELEMENT_INVITATION_PARTICIPANTS_REFUSED=".//*[@id='UIParticipantList']//*[contains(text(),'$fullName')]/../..//*[contains(text(),'No')]";
  	public final String ELEMENT_INVITATION_PARTICIPANTS_MAYBE=".//*[@id='UIParticipantList']//*[contains(text(),'$fullName')]/../..//*[contains(text(),'Maybe')]";
  	public final String ELEMENT_INVITATION_PARTICIPANTS_YES=".//*[@id='UIParticipantList']//*[contains(text(),'$fullName')]/../..//*[contains(text(),'Yes')]";
  	public final String ELEMENT_INVITATION_PARTICIPANTS_REMOVE_BTN=".//*[@id='UIParticipantList']//*[contains(text(),'$fullName')]/../..//*[contains(@class,'uiIconDelete')]";
  	public final String ELEMENT_INVITATION_PARTICIPANTS_INVALID_USER_MESSAGE=".//*[contains(@class,'warningIcon')][contains(text(),\"'$user' is not a valid participant.\")]";
  	public final String ELEMENT_INVITATION_PARTICIPANTS_INVALID_EMAIL_MESSAGE=".//*[contains(@class,'warningIcon')][contains(text(),\"'$email' is not a valid email.\")]";
  	
  	//Reminder tab
  	public final By ELEMENT_REMINDER_TAB=By.xpath(".//*[contains(@data-target,'#eventReminder-tab')]");
  	public final By ELEMENT_REMINDER_BY_POPUP=By.id("popupReminder");
  	public final By ELEMENT_REMINDER_BY_MAIL=By.id("mailReminder");
  	public final By ELEMENT_REMINDER_DROP_BOX=By.xpath(".//*[contains(@name,'mailReminderTime')]");

  	/*Recurring event form*/
  	public By ELEMENT_RECURRING_FORM=By.id("UIRepeatEventForm");
  	public By ELEMENT_RECURRING_TYPE_SELECT_BOX = By.xpath("//*[@name='repeatType']");
  	public By ELEMENT_INTERVAL_SELECT_BOX = By.xpath("//*[@name='interval']");
  	public By ELEMENT_END_AFTER_NUMBER = By.id("endAfterNumber");
  	public By ELEMENT_NEVER_END_RECURRING_EVENT = By.id("endNever");
  	public By ELEMENT_AFTER_END_RECURRING_EVENT = By.id("endAfter");
  	public By ELEMENT_BY_THIS_DATE_END_RECURRING_EVENT = By.id("endByDate");
  	public By ELEMENT_DATE_TIME_PICKER = By.xpath("//*[contains(@id, 'DateTimePicker')]");
  	public By ELEMENT_IS_REPEAT_CHECKBOX = By.id("isRepeat");
	public By ELEMENT_IS_REPEAT_CHECKBOX_CHECKED = By.xpath(".//*[@class='repeatSummary'][contains(text(),' Daily, 5 times')]");
  	public By ELEMENT_SAVE_EVENT_OCCURRING = By.xpath("//*[@id='UIRepeatEventForm']//*[contains(text(),'Save')]");
    public By ELEMENT_RECURRING_SAVE_BTN=By.xpath(".//*[@id='UIRepeatEventForm']//button[1]");
    public By ELEMENT_RECURRING_CANCEL_BTN=By.xpath(".//*[@id='UIRepeatEventForm']//button[2]");
    public By ELEMENT_EDIT_RECURRING_EVENT_FORM_SAVE_BTN=By.xpath(".//*[@id='UIConfirmFormUpdate']//button[1]");
    public By ELEMENT_RECURRING_REPEAT_BTN=By.xpath(".//*[@id='eventDetail']//*[contains(@class,'uiIconEdit')]");
    public String ELEMENT_REPEAT_ON = ".//*[@id='$day'][@checked='']";
    public String ELEMENT_SELECT_BOX_VALUE_SELECTED=".//*[@id='UIRepeatEventForm']//option[@value='$name' and @selected='selected']";
  	public By ELEMENT_NEVER_END_RECURRING_CHECKED=By.xpath(".//*[@id='endNever'][@checked='']");
    
  	/*Delete recurring event form*/
  	public By ELEMENT_DELETE_RECURRING_EVENT_FORM = By.xpath("//*[@class='uiConfirmForm']");
  	public By ELEMENT_EDIT_DELETE_ONE_EVENT = By.xpath("//*[@value='save_one']");
  	public By ELEMENT_EDIT_DELETE_FOLLOWING_EVENT = By.xpath("//*[@value='save_follow']");
  	public By ELEMENT_EDIT_DELETE_ALL_EVENT = By.xpath("//*[@value='save_all']");
  	public By ELEMENT_CONFIRM_DELETE_BUTTON = By.xpath("//*[@class='uiConfirmForm']//button[1]");
  	public By ELEMENT_CONFIRM_CANCEL_BUTTON = By.xpath("//*[@class='uiConfirmForm']//button[2]");
  	public String ELEMENT_CONFIRM_DELETE_MESSAGE = "Would you like to delete only this event, all events in the series, or this and all following events in the series?";
  	public By ELEMENT_CONFIRM_EDIT_DELETE_RECURRING_EVENT = By.xpath("//*[@class='media-body']");
  	public By ELEMENT_CONFIRM_EDIT_RECURRING_EVENT_CANCEL_BTN=By.xpath("//*[@id='UIConfirmFormUpdate']//button[2]");

  	/*Delete recurring event*/
  	public By ELEMENT_CONFIRM_EDIT_BUTTON = By.xpath("//*[@id='UIConfirmFormUpdate']//button[1]");
  	public By ELEMENT_CONFIRM_EDIT_RECURRING_FORM = By.xpath(".//*[@class='confirmRadio']");
  	public String ELEMENT_CONFIRM_EDIT_MESSAGE = "Would you like to change only this event, all events in the series, or this and all following events in the series?";
  	
  	/*Content recurring*/
  	public By ELEMENT_TITLE_RECURRING_EVENT = By.xpath("//*[@class='popover-content']/*[@class='title clearfix']/*[@class='text']");
  	public By ELEMENT_DATE_TIME_RECURRING_EVENT = By.xpath("//*[@class='popover-content']/*[@class='time clearfix']//*[@class='uiIconCalClockMini']/../../*[@class='text']");
  	public By ELEMENT_RECURRING_TEXT_RECURRING_EVENT = By.xpath("//*[@class='popover-content']/*[@class='time clearfix']//*[@class='uiIconCalRecurring']/../../*[@class='text']");
  	public By ELEMENT_EDITED_RECURRING_TEXT_RECURRING_EVENT = By.xpath("//*[@class='popover-content']/*[@class='time clearfix']//*[@class='uiIconCalEditRecurring']/../../*[@class='text']");
  	public By ELEMENT_DESCRIPTION_EVENT = By.xpath("//*[@class='popover-content']/*[@class='description']");
  	
  	
    
    //*----------------------------------------------------TASK MANAGEMANT------------------------------------------------------------------------*\\
    //Add Quick Task Form
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
  	public By ELEMENT_BUTTON_TASK_QUICK_CANCEL = By.xpath("//*[@id='UIQuickAddTaskPopupWindow']//*[text()='Cancel']");
  	
  	//Add Task Form (more details )
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
  	public By ELEMENT_ADD_EDIT_TASK_STATUS = By.xpath("//*[@id='UITaskForm']//*[@name='status']");

  	//Attach file form
  	public By ELEENT_SELECT_FILE=By.xpath("//*[@class='uploadButton']/*[@class='btn']");
  	public By ELEMENT_TASK_ADD_ATTACHMENT = By.xpath("//button[contains(@onclick,'AddAttachment')]");
  	public String ELEMENT_TASK_ATTACHMENT = "//*[@id='UITaskForm']/..//a[@data-original-title='${file}']";
  	public By ELEMENT_UPLOAD_PROGRESS_BAR = By.xpath(".//*[contains(@class,'progressBarFrame clearfix')]");
	
  	
  	/*----------------------------------------------------EMAIL NOTIFICATION-----------------------------------------------------------------------*/
	//Invitation email
	public final String ELEMENT_GMAIL_CONTENT_INVITATION_EMAIL = ".//b[contains(text(),'[Invitation] $eventTask')]";
	public final String ELEMENT_GMAIL_EMAIL_DETAILS=".//h3//*[contains(@name,'$email')]";
	public final String ELEMENT_GMAIL_EMAIL_ICS_FILE=".//span[contains(text(),'$file')]";
	public final String ELEMENT_GMAIL_EMAIL_DETAIL_LINK="//*[contains(@target,'_blank')][contains(text(),'$link')]";
	public final String ELEMENT_REFUSE_INVITATION_MESSAGE ="//*[contains(text(),'You have refused invitation from $user')]";
	public final String ELEMENT_MAYBE_INVITATION_MESSAGE ="//*[contains(text(),'You have answered invitation from $user: Maybe')]";
	public final String ELEMENT_ACCEPT_INVITATION_MESSAGE ="//*[contains(text(),'You have accepted invitation from $user')]";

}