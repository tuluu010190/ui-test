package org.exoplatform.selenium.platform.forum;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PageEditor;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.exoplatform.selenium.TestLogger.info;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class ForumBase extends PlatformBase {

	Button but;
	ManageAlert alert;
	PageEditor pageE;
	NavigationToolbar navTool;
	PlatformPermission per;

	public final By ELEMENT_FORUM_LINK = By.linkText("Forums");
	public final By ELEMENT_OK_INFOR_POPUP = By.xpath("//*[@class='UIPopupWindow UIDragObject uiPopup']//*[text()='OK']");
	public final By ELEMENT_OK_DELETE = By.xpath("//*[@id='UIForumPopupConfirmation']//*[text()='OK']");

	//-----------------Forum Home screen--------------------------------------------
	public final By ELEMENT_ADD_CATEGORY = By.linkText("Add Category");
	public final By ELEMENT_ADD_FORUM = By.linkText("Add Forum");
	public final By ELEMENT_ALERT = By.xpath("//div[@class='UIPopupWindow UIDragObject ExoMessageDecorator']");
	public final By ELEMENT_INFO = By.xpath("//span[@class='PopupIcon InfoMessageIcon']");
	public final By ELEMENT_MORE_ACTION = By.xpath("//*[@data-toggle='dropdown']/*[@class='uiIconSettings uiIconLightGray']");
	public final By ELEMENT_MODERATION = By.linkText("Moderation");
	public final By ELEMENT_MODERTATION_DELETE_BUTTON = By.xpath("//*[@id='ModerationMenu']//a[contains(text(),'Delete')]");
	public final By ELEMENT_WATCH = By.xpath("//*[@class='actionIcon' and contains(@href, 'AddWatching')]");
	public final By ELEMENT_UNWATCH = By.xpath("//*[@class='actionIcon' and contains(@href, 'UnWatch')]");
	public final By ELEMENT_BOOKMARKS = By.linkText("Bookmarks");
	public final By ELEMENT_ADMINISTRATION = By.xpath("//*[@id='Administrations']//*[@class='uiIconForumAdmin uiIconForumLightGray']");
	public final By ELEMENT_SORT_SETTING = By.xpath("//span[text()='Sort Settings']");
	public final By ELEMENT_CENSOR_KEYWORDS = By.xpath("//span[text()='Censor Keywords']");
	public final By ELEMENT_BAN_IP = By.xpath("//span[text()='Banned IPs']");
	public final By ELEMENT_BBCODE = By.xpath("//span[text()='BBCodes']");
	public final By ELEMENT_PRUNE = By.xpath("//*[@id='Administrations']//*[@class='Pruning']");
	public final By ELEMENT_IMPORT = By.xpath("//*[@id='Administrations']//*[@class='uiIconImport']");
	public final By ELEMENT_EXPORT_CATEGORY = By.xpath("//*[@id='Administrations']//*[@class='uiIconExport']");
	public final By ELEMENT_EXPORT_FORUM = By.linkText("Export Forum");
	public final By ELEMENT_LEGEN_PANEL = By.id("UIForumIconState");
	public final By ELEMENT_STATISTIC_PANEL = By.xpath("//*[text()='Forums Statistics']");
	public final By ELEMENT_HOME_BUTTON = By.xpath("//*[@id='UIBreadcumbs']//*[text()='Home']");
	public final String ELEMENT_HOME_FORUM = "Forum Home";

	//-----------------Watch/Unwatch screen-------------------------------------------
	public final String MESSAGE_WATCH = "You are now watching this item.";
	public final String MESSAGE_UNWATCH = "You are no longer watching this item.";	
	public static String REGISTER_MAIL_CONTENT = "Hi, you received this email because you registered for the Forum and Topic Watching notification.";

	//----------------Book Marks form------------------------------------------
	public final By ELEMENT_BOOKMARKS_POPUP = By.xpath("//span[@class='PopupTitle' and text()='My Bookmarks']");
	public final By ELEMENT_BOOKMARKS_OPTION = By.xpath("//*[@id='UIPopupMenu1']/*//a[text()='Bookmark']");
	public final String ELEMENT_BOOKMARKS_ITEM = "//a[@class='ActionLink' and text()='${item}']";
	public final String ELEMENT_BOOKMARKS_REMOVE = "//a[@class='ActionLink' and text()='${item}']/../../*//div[@class='DeleteIcon']";

	//-----------------simple search screen-----------------------------------
	public final By ELEMENT_SIMPLE_SEARCH_TEXTBOX = By.id("inputValue");
	public final By ELEMENT_SIMPLE_SEARCH_BUTTON = By.xpath("//a[@class='SearchLink SearchForumIcon']");
	public final By ELEMENT_SIMPLE_SEARCH_LIST = By.id("UIForumListSearch");
	public final By ELEMENT_SIMPLE_SEARCH_TITLE_FORM = By.xpath("//div[@class='TitleBar' and text()='Search Result']");
	public final String VERIFY_MESSAGE_SEARCH = "No matches.";

	//-----------------Advanced Search form--------------------------------
	public final By ELEMENT_ADVANCED_SEARCH_ICON = By.xpath("//a[@class='AdvancedSearch']");
	public final By ELEMENT_ADVANCED_SEARCH_FORM = By.id("UISearchForm");
	public final By ELEMENT_ADVANCED_SEARCH_TERMS = By.id("SearchValue");
	public final By ELEMENT_ADVANCED_SEARCH_IN = By.id("SearchType");
	public final By ELEMENT_ADVANCED_SEARCH_SCOPE_FULL = By.id("Scope_entire");
	public final By ELEMENT_ADVANCED_SEARCH_SCOPE_TITLES = By.id("Scope_title");
	public final By ELEMENT_ADVANCED_SEARCH_USER = By.id("SearchUser");
	public final By ELEMENT_ADVANCED_SEARCH_CREATED_FROM = By.id("FromDateCreated");
	public final By ELEMENT_ADVANCED_SEARCH_CREATED_TO = By.id("ToDateCreated");
	public final By ELEMENT_ADVANCED_SEARCH_MODERATOR = By.id("Moderator");
	public final By ELEMENT_ADVANCED_SEARCH_BUTTON = By.linkText("Search");
	public final By ELEMENT_ADVANCED_SEARCH_SELECT_USER = By.xpath("//*[@id='Moderator']/../..//img[@class='SelectUserIcon']");

	//-----------------Sort setting form-----------------------------------
	public final By ELEMENT_SORT_SETTING_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Sort Settings']");
	public final By ELEMENT_SORT_FORUM_BY = By.id("forumSortBy");
	public final By ELEMENT_SORT_FORUM_DIRECTION = By.id("forumSortByType");
	public final By ELEMENT_SORT_TOPIC_BY = By.id("topicSortBy");
	public final By ELEMENT_SORT_TOPIC_DIRECTION = By.id("topicSortByType");

	//----------------Set Censor keywords form----------------------------------
	public final By ELEMENT_CENSOR_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Censor Keyword']");
	public final By ELEMENT_CENSORED_KEYWORDS =  By.id("censorKeyword");

	//----------------Set Ban IP form--------------------------------------------
	public final By ELEMENT_BAN_IP_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Banned IPs']");
	public final By ELEMENT_BAN_IP_FILTER = By.id("searchIpBan");
	public final By ELEMENT_BAN_IP_ADD = By.linkText("[Add]");
	public final String ELEMENT_BAN_IP_ADDRESS = "newIpBan${No}";
	public final String ELEMENT_BAN_IP_DELETE = "//*[text()='${ip}']/../*//a[text()='X']";

	//----------------Set BB Code form-------------------------------------
	public final By ELEMENT_BBCODE_POPUP = By.xpath("//span[@class='PopupTitle' and text()='BBCode Manager']");
	public final String ELEMENT_BBCODE_ACTIVE_NO_OPTION = "//input[@type='checkbox' and @id='${tag}']";
	public final String ELEMENT_BBCODE_ACTIVE_HAVE_OPTION = "//input[@type='checkbox' and contains(@id,'${tag}" + "opt" + "')]";
	public final By ELEMENT_BBCODE_ADD_BUTTON = By.linkText("Add BBCode");
	public final String ELEMENT_BBCODE_EDIT_NO_OPTION = "//input[@type='checkbox' and @id='${tag}']/../../*//div[@title='Edit BBCode']";
	public final String ELEMENT_BBCODE_EDIT_HAVE_OPTION = "//input[@type='checkbox' and contains(@id,'${tag}" + "opt" + "')]/../../*//div[@title='Edit BBCode']";
	public final String ELEMENT_BBCODE_DELETE_NO_OPTION = "//input[@type='checkbox' and @id='${tag}']/../../*//div[@title='Delete BBCode']";
	public final String ELEMENT_BBCODE_DELETE_HAVE_OPTION = "//input[@type='checkbox' and contains(@id,'${tag}" + "opt" + "')]/../../*//div[@title='Delete BBCode']";

	public final By ELEMENT_BBCODE_ADD_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Add BBCode']");
	public final By ELEMENT_BBCODE_EDIT_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Edit BBCode']");
	public final By ELEMENT_BBCODE_TAG	= By.id("TagName");
	public final By ELEMENT_BBCODE_REPLACEMENT = By.id("Replacement");
	public final By ELEMENT_BBCODE_DESCRIPTION = By.id("Description");
	public final By ELEMENT_BBCODE_EXAMPLE = By.id("Example");
	public final By ELEMENT_BBCODE_OPTION = By.id("UseOption");

	//----------------------Prune management form---------------------------------
	public final By ELEMENT_PRUNE_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Auto Prune']");
	public final String ELEMENT_PRUNE_ACTIVE = "//td[text()='${category}']/../*//input[@type='checkbox']";
	public final String ELEMENT_PRUNE_ACTIVED = "//td[text()='${category}']/../*//input[@type='checkbox' and @checked='checked']";
	public final String ELEMENT_PRUNE_SETTING = "//td[text()='${category}']/../td[text()='{$forum}']/..//div[@title='Prune Settings']";
	public final String ELEMENT_PRUNE_RUN = "//td[text()='${category}']/../td[text()='{$forum}']/..//div[@title='Run']";

	public final By ELEMENT_PRUNE_SETTING_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Prune Settings']");
	public final By ELEMENT_PRUNE_ACTIVE_DAY = By.id("inActiveDay");
	public final By ELEMENT_PRUNE_ACTIVE_DAY_TYPE = By.id("inActiveDayType");
	public final By ELEMENT_PRUNE_JOB_DAY = By.id("jobDay");
	public final By ELEMENT_PRUNE_JOB_DAY_TYPE = By.id("jobDayType");
	public final String MSG_PRUNE_INVALID_INACTIVE_DAY = "Invalid number format in field \"Clear topics that have been inactive for\".";
	public final String MSG_PRUNE_INVALID_JOB_DAY = "Invalid number format in field \"Run prune job every\".";
	public final String MSG_PRUNE_NOT_CONFIG = "Please configure the prune settings for this item.";
	public final By ELEMENT_PRUNE_DRY_RUN = By.linkText("Dry Run");

	//--------------------Profile setting form------------------------------------
	public final By ELEMENT_SETTING = By.linkText("Settings");
	public final By ELEMENT_SETTING_POPUP = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Settings']");
	public final String ELEMENT_SETTING_EMAIL_CHECKBOX = "//a[contains(text(), '${forum}')]/../../../*//input[contains(@id, 'EMAILforum')]"; 
	public final String ELEMENT_SETTING_MAIL_DELETE = "//a[contains(text(), '${forum}')]/../../../*//div[@class='DeleteIcon']";
	public final By ELEMENT_SETTING_EMAIL_ADDRESS = By.id("EmailAddress");
	public final By ELEMENT_SETTING_EMAIL_UPDATE = By.xpath("//button[text()='Update']");
	public final By ELEMENT_SETTING_MYSCRIPTIONS_TAB = By.linkText("My Subscriptions");
	public final By ELEMENT_SCREEN_NAME = By.id("ScreenName");
	public final By ELEMENT_SIGNATURE = By.id("Signature");
	public final By ELEMENT_IS_DISPLAY_SIGNATURE = By.id("IsDisplaySignature");
	public final By ELEMENT_IS_DISPLAY_AVATAR = By.id("IsDisplayAvatar");
	public final By ELEMENT_WATCH_TOPIC_START = By.id("AutoWatchMyTopics");
	public final By ELEMENT_WATCH_TOPIC_POST =  By.id("AutoWatchTopicIPost");
	public final String ELEMENT_DELETE_WATCH = "//label/a[contains(text(),'${item}')]/following::div[@class='DeleteIcon']";
	public final String ELEMENT_FEED_URL = "//a[@title='{$item}']/ancestor::tr/following::input[contains(@id,'RSS')]";

	//---------------------Notifications------------------
	public final By ELEMENT_NOTIFICATION_LINK = By.xpath("//span[text()='Notifications']");
	public final By ELEMENT_NOTIFY_FRAME=By.xpath("//*[@id='xEditingArea']/iframe");
	public final String ELEMENT_NOTIFY_TEXT= "New Posts Notification";
	public final By ELEMENT_NOTIFY_FRAME_UP=By.id("notifyEmail___Frame");
	public final By ELEMENT_NOTIFY_PREFIX = By.id("enableHeaderSubject");
	public final By ELEMENT_NOTIFY_SUBJECT = By.id("headerSubject");
	public final By ELEMENT_NOTIFY_RESET = By.xpath("//img[@title='Reset']");
	public final String MSG_NOTIFY_BLANK = "The notification email is required.";
	public final By ELEMENT_NOTIFY_MOVE_FRAME_UP= By.id("notifyEmailMoved___Frame");
	public final By ELEMENT_NOTIFY_MOVE_TAB = By.xpath("//a[contains(text(),'Moved Notification')]");
	public final By ELEMENT_NOTIFY_MOVE_RESET = By.xpath("//div[@id='notifyEmailMoveTab']//img[@title='Reset']");

	//--------------------------Forum portlet setting form------------------------------------
	public final By ELEMENT_FORUM_PORTLET = By.xpath("//*[@class='CPortletLayoutDecorator' and contains(text(), 'Forum Portlet')]");
	public final By ELEMENT_FORUM_PORTLET_EDIT_ICON = By.xpath("//div[text()='Forum Portlet']/../a[@class='EditIcon']");
	public final By ELEMENT_FORUM_PORTLET_EDITMODE_TAB = By.xpath("//div[@class='MiddleTab' and text()='Edit Mode']");
	public final By ELEMENT_FORUM_PORTLET_PANEL_TAB = By.linkText("Panels");
	public final By ELEMENT_SHOW_FORUM_JUMP_CHECKBOX = By.id("isShowForumJump");
	public final By ELEMENT_SHOW_MODERATOR_CHECKBOX = By.id("isShowModerator");
	public final By ELEMENT_SHOW_POLL_CHECKBOX = By.id("IsShowPoll");
	public final By ELEMENT_SHOW_QUICK_REPLY_CHECKBOX = By.id("isShowQuickReply");
	public final By ELEMENT_SHOW_ICON_LEGEND_CHECKBOX = By.id("isShowIconsLegend");
	public final By ELEMENT_SHOW_RULE_CHECKBOX = By.id("isShowRules");
	public final By ELEMENT_SHOW_STATISTIC_CHECKBOX = By.id("isShowStatistic");

	//attach file popup
	public final By ELEMENT_POPUP_UPLOAD_FILE = By.xpath("//span[@class='PopupTitle' and text()='Attach File']");
	public final By ELEMENT_ATTACH_FILE = By.linkText("Attach files");
	public final By ELEMENT_ATTACHMENT_FILE_INPUT = By.name("file");
	public final By ELEMENT_ATTACHMENT_SAVE_BUTTON = By.xpath("//*[@id='UIAttachmentForm']//*[text()='Save']");

	/*-----------------------------common function-------------------------------------*/

	public void goToForums(){
		info("--Go to Forums--");
		click(ELEMENT_FORUM_LINK);
	}
	
	public void goToForumHome(){
		info("---Go to Forum home---");
		click(ELEMENT_HOME_BUTTON);
		waitForElementNotPresent(ELEMENT_HOME_BUTTON);
	}

	public void watchItem(boolean watch){		
		if (watch){
			if (waitForAndGetElement(ELEMENT_WATCH, DEFAULT_TIMEOUT, 0) != null){
				info("Watch item");
				click(ELEMENT_WATCH);
				waitForMessage(MESSAGE_WATCH);
				click(ELEMENT_OK_INFOR_POPUP);
				waitForAndGetElement(ELEMENT_UNWATCH);
				info("Watch item successfully");
			}else {
				info("Not found watch link");
			}			
		} else {
			if (waitForAndGetElement(ELEMENT_UNWATCH, DEFAULT_TIMEOUT, 0) != null) {
				info("Unwatch item");
				click(ELEMENT_UNWATCH);
				waitForMessage(MESSAGE_UNWATCH);
				click(ELEMENT_OK_INFOR_POPUP);
				waitForAndGetElement(ELEMENT_WATCH);
				info("Unwatch item successfully");
			} else {
				info("Not found unwatch link");
			}
		}
	}

	public void addBookmarksItem(String item){
		By element_item = By.xpath(ELEMENT_BOOKMARKS_ITEM.replace("${item}", item));

		//set bookmark
		info("Add bookmark");
		waitForAndGetElement(By.linkText(item));
		for(int repeat=0;; repeat ++)
		{
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot bookmark this item after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(By.linkText(item));
			if (waitForAndGetElement(ELEMENT_BOOKMARKS_OPTION) != null) break;
			Utils.pause(WAIT_INTERVAL);
			info("Retry...[" + repeat + "]");
		}
		click(ELEMENT_BOOKMARKS_OPTION);
		//check bookmarks display
		waitForAndGetElement(ELEMENT_BOOKMARKS);
		click(ELEMENT_BOOKMARKS);
		waitForAndGetElement(ELEMENT_BOOKMARKS_POPUP);
		waitForAndGetElement(element_item);
		info("Add bookmark successfully");
	}

	/** function: delete bookmark
	 * @author lientm
	 * @param item: name of bookmark
	 */
	public void deleteBookmarkItem(String item){
		By element_delete = By.xpath(ELEMENT_BOOKMARKS_REMOVE.replace("${item}", item));

		info("Delete bookmark");
		waitForAndGetElement(element_delete);
		click(element_delete);
		waitForElementNotPresent(element_delete);
		info("Delete bookmark successfully");
	}

	/** function: simple search
	 * @author lientm
	 * @param key: key to search
	 * @return = true: have result return
	 * 		   = false: not have result return
	 */
	public boolean simpleSearch(String key){
		boolean result = true;
		info("Simple search with key " + key);
		type(ELEMENT_SIMPLE_SEARCH_TEXTBOX, key, true);
		click(ELEMENT_SIMPLE_SEARCH_BUTTON);
		waitForAndGetElement(ELEMENT_SIMPLE_SEARCH_LIST);
		waitForAndGetElement(ELEMENT_SIMPLE_SEARCH_TITLE_FORM);
		if (isTextPresent(VERIFY_MESSAGE_SEARCH) == true){
			result = false;
			info("There are not any Items that matchs key " + key);
		}
		return result;
	}

	/** function: execute an advanced search
	 * @author lientm
	 * @param scope
	 * @param key
	 * @return = true: have result return
	 * 		   = false: not have result return
	 */
	public boolean advancedSearch(boolean scope, String... key){
		boolean result = true;

		per = new PlatformPermission(driver);
		info("Do advance search");
		waitForAndGetElement(ELEMENT_ADVANCED_SEARCH_ICON);
		for (int i = 0; i < 5; i ++){
			click(ELEMENT_ADVANCED_SEARCH_ICON);
			WebElement search_form = waitForAndGetElement(ELEMENT_ADVANCED_SEARCH_FORM, 5000, 0);
			if (search_form != null) break;
		}
		if (key.length == 0){
			Assert.fail("There are not any key to search");
		}
		if (key.length > 0 && key[0] != "" && key[0] != null){
			type(ELEMENT_ADVANCED_SEARCH_TERMS, key[0], true);
		}
		if (key.length > 1 && key[1] != "" && key[1] != null){
			select(ELEMENT_ADVANCED_SEARCH_IN, key[1]);
		}
		if (scope){
			click(ELEMENT_ADVANCED_SEARCH_SCOPE_FULL);
		} else {
			click(ELEMENT_ADVANCED_SEARCH_SCOPE_TITLES);
		}
		if (key.length > 2 && key[2] != "" && key[2] != null){
			type(ELEMENT_ADVANCED_SEARCH_USER, key[2], true);
		}
		if (key.length > 3 && key[3] != "" && key[3] != null){
			type(ELEMENT_ADVANCED_SEARCH_CREATED_FROM, key[3], true);
		}
		if (key.length > 4 && key[4] != "" && key[4] != null){
			type(ELEMENT_ADVANCED_SEARCH_CREATED_TO, key[4], true);
		}
		if (key.length > 5 && key[5] != "" && key[5] != null){
			type(ELEMENT_ADVANCED_SEARCH_MODERATOR, key[5], true);
		}
		if (key.length > 6 && key[6] != "" && key[6] != null){
			click(ELEMENT_ADVANCED_SEARCH_SELECT_USER);
			per.selectUserPermission(key[6]);
		}
		click(ELEMENT_ADVANCED_SEARCH_BUTTON);
		waitForAndGetElement(ELEMENT_SIMPLE_SEARCH_LIST);
		waitForAndGetElement(ELEMENT_SIMPLE_SEARCH_TITLE_FORM);
		if (isTextPresent(VERIFY_MESSAGE_SEARCH) == true){
			result = false;
			info("There are not any Items that matchs key " + key);
		}
		return result;
	}
	/** function: setup a sort
	 * @author lientm
	 * @param forumBy: the way sort forum
	 * @param dirForum: direction of sort for forum
	 * @param topicBy: the way sort topic
	 * @param dirTopic: direction of sort for topic
	 */
	public void sortSetting(String forumBy, int dirForum, String topicBy, int dirTopic){
		but = new Button(driver);
		info("Setting sort");
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForAndGetElement(ELEMENT_SORT_SETTING);
		click(ELEMENT_SORT_SETTING);
		waitForAndGetElement(ELEMENT_SORT_SETTING_POPUP);
		if (forumBy != "" && forumBy != null){
			select(ELEMENT_SORT_FORUM_BY, forumBy);
		}
		if (dirForum == 1){
			select(ELEMENT_SORT_FORUM_DIRECTION, "Ascending");
		} else {
			select(ELEMENT_SORT_FORUM_DIRECTION, "Descending");
		}
		if (topicBy != "" && topicBy != null){
			select(ELEMENT_SORT_FORUM_BY, forumBy);
		}
		if (dirTopic == 1){
			select(ELEMENT_SORT_FORUM_DIRECTION, "Ascending");
		} else {
			select(ELEMENT_SORT_FORUM_DIRECTION, "Descending");
		}
		but.save();
		waitForElementNotPresent(ELEMENT_SORT_SETTING_POPUP);
		info("setting sort successfully");
	}

	/** function: set sensor keyword
	 * @author lientm
	 * @param key: key to setup
	 */
	public void setCensorKeywords(String key){
		but = new Button(driver);
		info("Set censor keywords " + key);
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForAndGetElement(ELEMENT_CENSOR_KEYWORDS);
		click(ELEMENT_CENSOR_KEYWORDS);
		waitForAndGetElement(ELEMENT_CENSOR_POPUP);
		if (key != null){
			type(ELEMENT_CENSORED_KEYWORDS, key, true);
		}
		but.save();
		waitForElementNotPresent(ELEMENT_CENSOR_POPUP);
		info("Set censor keyword successfully");
	}

	/**
	 * function go to BanIP management
	 * @author lientm
	 */
	public void goToBanIp(){
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForAndGetElement(ELEMENT_BAN_IP);
		click(ELEMENT_BAN_IP);
		waitForAndGetElement(ELEMENT_BAN_IP_POPUP);
	}

	/**function: set ban IP
	 * @author lientm
	 * @param ban: group of some IP address
	 */
	public void setBanIp(String... ban){
		but = new Button(driver);
		if (ban.length > 0){
			info("Set Ban Ip");
			goToBanIp();
			for (int i = 0; i < ban.length; i ++){ 
				String temp[] = ban[i].split("\\.");
				for (int j = 0; j < temp.length; j ++){
					type(By.id(ELEMENT_BAN_IP_ADDRESS.replace("${No}", Integer.toString(j + 1))), temp[j], true);
				}
				click(ELEMENT_BAN_IP_ADD);
				waitForAndGetElement(By.xpath("//td[@class='FieldLabel' and text()='" + ban[i] + "']"));
			}
			but.close();
		}
	}

	/**
	 * function delete Ban Ip
	 * @param ip: ip to delete
	 */
	public void deleteBanIp(String ip){
		but = new Button(driver);
		alert = new ManageAlert(driver);

		By element_delete = By.xpath(ELEMENT_BAN_IP_DELETE.replace("${ip}", ip));

		goToBanIp();
		waitForAndGetElement(element_delete);
		click(element_delete);
		alert.acceptAlert();
		waitForElementNotPresent(element_delete);
		but.close();
	}

	/** function: go to BB code management
	 * @author lientm
	 */
	public void goToBBCodeManagement(){
		info("Go to BB code management");
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForAndGetElement(ELEMENT_BBCODE);
		click(ELEMENT_BBCODE);
		waitForAndGetElement(ELEMENT_BBCODE_POPUP);
	}

	/** function: modify a BBCode
	 * @author lientm
	 * @param tag: tag of BBCode
	 * @param replace: htmp code that replaces the user-entered BBCode
	 * @param description: text to describe the BBCode tag
	 * @param example: an example for this particular BBCode
	 * @param option: choose option or not
	 */
	public void modifyBBcodeInfo(String tag, String replace, String description, String example, boolean option){
		but = new Button(driver);
		if (tag != "" && tag != null){
			type(ELEMENT_BBCODE_TAG, tag, true);
		}
		if (replace != "" && replace != null){
			type(ELEMENT_BBCODE_REPLACEMENT, replace, true);
		}
		if (description != "" && description != null){
			type(ELEMENT_BBCODE_DESCRIPTION, description, true);
		}
		if (example != "" && example != null){
			type(ELEMENT_BBCODE_EXAMPLE, example, true);
		}
		WebElement opt = waitForAndGetElement(ELEMENT_BBCODE_OPTION);
		if ((option == true && opt.isSelected() == false) || (option == false && opt.isSelected() == true)){
			click(ELEMENT_BBCODE_OPTION);
		}
		but.save();
	}

	/** function: add a BBCode
	 * @author lientm
	 * @param tag: tag of BBCode
	 * @param replace: htmp code that replaces the user-entered BBCode
	 * @param description: text to describe the BBCode tag
	 * @param example: an example for this particular BBCode
	 * @param option: choose option or not
	 */
	public void addBBCode(String tag, String replace, String description, String example, boolean option){
		info("Add new BBcode");
		click(ELEMENT_BBCODE_ADD_BUTTON);
		waitForAndGetElement(ELEMENT_BBCODE_ADD_POPUP);
		modifyBBcodeInfo(tag, replace, description, example, option);
		waitForElementNotPresent(ELEMENT_BBCODE_ADD_POPUP);
		waitForTextPresent(tag.toUpperCase());
		waitForElementNotPresent(ELEMENT_ALERT);
		info("Add BBcode successfully");
	}

	/** function: active/deactive a BBCode
	 * @author lientm
	 * @param tag: tag of BBCode
	 * @param active: set active for BBCode
	 * @param option = true: BBCode have option
	 * 				 = false: BBCode does not have option
	 */
	public void activeBBcode(String tag, boolean active, boolean option){
		By ELEMENT_ACTIVE_OPTION = By.xpath(ELEMENT_BBCODE_ACTIVE_HAVE_OPTION.replace("${tag}", tag));
		By ELEMENT_ACTIVE_NOT_OPTION = By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", tag));
		but = new Button(driver);
		info("set active/deactive for BBcode");
		if (tag != null && tag != ""){
			if (option){
				WebElement act = waitForAndGetElement(ELEMENT_ACTIVE_OPTION, 10000, 0);
				if ((active && act.isSelected() == false) || (!active && act.isSelected() == true)){
					click(ELEMENT_ACTIVE_OPTION);
				}
			}else {
				WebElement act_no = waitForAndGetElement(ELEMENT_ACTIVE_NOT_OPTION, 10000, 0);
				if ((active && act_no.isSelected() == false) || (!active && act_no.isSelected() == true)){
					click(ELEMENT_ACTIVE_NOT_OPTION);
				}
			}
			but.save();
			waitForElementNotPresent(ELEMENT_BBCODE_POPUP);
		}
	}

	/** function: edit a BBCode
	 * @author lientm
	 * @param tagold: old tag of BBCode
	 * @param haveoption = true: BBCode have option
	 * 				     = false: BBCode does not have option 
	 * @param tagnew: new tag of BBCode
	 * @param replace: htmp code that replaces the user-entered BBCode
	 * @param description: text to describe the BBCode tag
	 * @param example: an example for this particular BBCode
	 * @param option: choose option or not
	 */
	public void editBBcode(String tagold, boolean haveoption, String tagnew, String replace, String description, String example, boolean option){
		By ELEMENT_EDIT_OPTION = By.xpath(ELEMENT_BBCODE_EDIT_HAVE_OPTION.replace("${tag}", tagold));
		By ELEMENT_EDIT_NOT_OPTION = By.xpath(ELEMENT_BBCODE_EDIT_NO_OPTION.replace("${tag}", tagold));

		info("Edit a BBcode have tag " + tagold);
		if (haveoption){
			click(ELEMENT_EDIT_OPTION);
		} else {
			click(ELEMENT_EDIT_NOT_OPTION);
		}
		waitForAndGetElement(ELEMENT_BBCODE_EDIT_POPUP);
		modifyBBcodeInfo(tagnew, replace, description, example, option);
		waitForElementNotPresent(ELEMENT_BBCODE_EDIT_POPUP);
		waitForElementNotPresent(ELEMENT_ALERT);
		info("Edit BBcode successfully");
	}

	/**function: delete a BBCode
	 * @author lientm
	 * @param tag
	 * @param option = true: BBCode have option
	 * 				 = false: BBCode does not have option
	 */
	public void deleteBBcode(String tag, boolean option){
		By ELEMENT_DELETE_OPTION = By.xpath(ELEMENT_BBCODE_DELETE_HAVE_OPTION.replace("${tag}", tag));
		By ELEMENT_DELETE_NOT_OPTION = By.xpath(ELEMENT_BBCODE_DELETE_NO_OPTION.replace("${tag}", tag));
		alert = new ManageAlert(driver);
		info("Delete a BBcode have tag " + tag);
		if (option){
			click(ELEMENT_DELETE_OPTION);
			alert.acceptAlert();
			waitForElementNotPresent(ELEMENT_DELETE_OPTION);
		} else {
			click(ELEMENT_DELETE_NOT_OPTION);
			alert.acceptAlert();
			waitForElementNotPresent(ELEMENT_DELETE_NOT_OPTION);
		}
		info("Delete BBcode successfully");
	}

	/** function: go to Prune Management
	 * @author lientm
	 */
	public void goToPruneManagement(){
		info("Go to prune management");
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForAndGetElement(ELEMENT_PRUNE);
		click(ELEMENT_PRUNE);
		waitForAndGetElement(ELEMENT_PRUNE_POPUP);
	}

	/** function: set a Prune
	 * @author lientm
	 * @param category: title of category
	 * @param forum: title of forum
	 * @param activeDay: number of day active
	 * @param dayType: type 
	 * @param jobDay: number of job day
	 * @param jobDayType: type
	 */
	public void pruneSetting(String category, String forum, String activeDay, String dayType, String jobDay, String jobDayType){
		By ELEMENT_SETTING = By.xpath(ELEMENT_PRUNE_SETTING.replace("${category}", category).replace("{$forum}",forum));

		but = new Button(driver);
		if (category != null && category != ""){
			info("Setting prune for category " + category);
			waitForAndGetElement(ELEMENT_SETTING);
			click(ELEMENT_SETTING);
			waitForAndGetElement(ELEMENT_PRUNE_SETTING_POPUP);
			if (activeDay != "" && activeDay != null){
				type(ELEMENT_PRUNE_ACTIVE_DAY, activeDay, true);
				select(ELEMENT_PRUNE_ACTIVE_DAY_TYPE, dayType);
			}
			if (jobDay != "" && jobDay != null){
				type(ELEMENT_PRUNE_JOB_DAY, jobDay, true);
				select(ELEMENT_PRUNE_JOB_DAY_TYPE, jobDayType);
			}
			but.save();

		}
	}

	/** function: active a prune
	 * @author lientm
	 * @param category: title of category
	 * @param active = true: active
	 * 				 = false: deactive
	 */
	public void activePrune(String category, boolean active){
		By ELEMENT_ACTIVE = By.xpath(ELEMENT_PRUNE_ACTIVE.replace("${category}", category));
		By ELEMENT_ACTIVED = By.xpath(ELEMENT_PRUNE_ACTIVED.replace("${category}", category));

		WebElement act = waitForAndGetElement(ELEMENT_ACTIVE);
		if (active && act.isSelected() == false){
			info("Active prune for category " + category);
			click(ELEMENT_ACTIVE);
			waitForAndGetElement(ELEMENT_ACTIVED);
		}
		if (active == false && act.isSelected() == true){
			info("Deactive prune for category " + category);
			click(ELEMENT_ACTIVE);
			waitForElementNotPresent(ELEMENT_ACTIVED);
		}	
	}

	/**
	 * function go to setting form
	 * @author lientm
	 */
	public void goToSetting(){
		waitForAndGetElement(ELEMENT_SETTING);
		click(ELEMENT_SETTING);
		waitForAndGetElement(ELEMENT_SETTING_POPUP);
	}

	/**
	 * function setting User profile
	 * @author lientm
	 * @param screenName: data input to Screen Name
	 * @param sign: data input to Signature
	 * @param opt: option check checkbox group: display signature, display avatar, watch to topic start, watch topic post
	 */
	public void settingProfileUser(String screenName, String sign, boolean...opt){
		but = new Button(driver);
		goToSetting();
		if (screenName != null){
			type(ELEMENT_SCREEN_NAME, screenName, true);
		}
		if (sign != null){
			type(ELEMENT_SIGNATURE, sign, true);
		}
		if (opt.length > 0){
			WebElement display_sign = waitForAndGetElement(ELEMENT_IS_DISPLAY_SIGNATURE);
			if ((opt[0] && !display_sign.isSelected()) || (!opt[0] && display_sign.isSelected())) {
				click(ELEMENT_IS_DISPLAY_SIGNATURE);
			}
		}
		if (opt.length > 1){
			WebElement display_avatar = waitForAndGetElement(ELEMENT_IS_DISPLAY_AVATAR);
			if ((opt[1] && !display_avatar.isSelected()) || (!opt[1] && display_avatar.isSelected())) {
				click(ELEMENT_IS_DISPLAY_AVATAR);
			}
		}
		if (opt.length > 2){
			WebElement display_start = waitForAndGetElement(ELEMENT_WATCH_TOPIC_START);
			if ((opt[2] && !display_start.isSelected()) || (!opt[2] && display_start.isSelected())) {
				click(ELEMENT_WATCH_TOPIC_START);
			}
		}
		if (opt.length > 3){
			WebElement display_post = waitForAndGetElement(ELEMENT_WATCH_TOPIC_POST);
			if ((opt[3] && !display_post.isSelected()) || (!opt[3] && display_post.isSelected())) {
				click(ELEMENT_WATCH_TOPIC_POST);
			}
		}
		but.save();
		waitForElementNotPresent(ELEMENT_SETTING_POPUP);
	}

	/**
	 * Go to Notifications
	 * @author thuntn
	 */
	public void goToNotifications(){
		info("--Go to notifications--");

		click(ELEMENT_ADMINISTRATION);
		click(ELEMENT_NOTIFICATION_LINK);

		waitForTextPresent(ELEMENT_NOTIFY_TEXT);
	}

	/**Change content of notifications
	 * @author thuntn
	 * @param prefix: = true if check Add a prefix to notification field
	 * 				  = false if else
	 * @param subject: text to add to Subject notification field
	 * @param content: text to add to content field
	 */
	public void changeNotifications(boolean prefix,String subject, String content){

		info("--Change content of notifications--");
		but = new Button(driver);
		goToNotifications();
		WebElement wPrefix = waitForAndGetElement(ELEMENT_NOTIFY_PREFIX);
		if (wPrefix != null)
			if ((prefix & (!wPrefix.isSelected())) || ((!prefix) & wPrefix.isSelected())){
				click(ELEMENT_NOTIFY_PREFIX);
			}

		if (subject != null){
			type(ELEMENT_NOTIFY_SUBJECT,subject,false);
		}
		inputDataToFrameInFrame( ELEMENT_NOTIFY_FRAME_UP, ELEMENT_NOTIFY_FRAME,content,false);
		switchToParentWindow();
		but.save();
	}
	/** Reset Notification as default
	 * @author thuntn
	 */
	public void resetNotification(){

		info("--Reset Notification--");
		but = new Button(driver);
		goToNotifications();
		type(ELEMENT_NOTIFY_SUBJECT,"[$CATEGORY][$FORUM] $TOPIC",true);
		click(ELEMENT_NOTIFY_RESET);
		but.save();
	}

	/** Function compare 2 paragraphs (compare in specific line)
	 * @author lientm
	 * @param temp: paragraphs 1
	 * @param content: paragraphs 2
	 */
	public void compareString(String[] temp, String[] content){
		for (int i = 0; i < content.length; i ++){
			info("String1: " + temp[i] + "--- String2: " + content[i]);
			assert temp[i].contains(content[i]): "Fail! 2 Strings are different from each other"; 
		}
	}

	/**function check fomat of content mail
	 * @author lientm
	 * @param contentMail: content of mail (has '/' to separate paragraphs into lines)
	 */
	public void checkContentMail(String contentMail){
		String[] content = contentMail.split("/");
		String[] temp = getText(ELEMENT_MAIL_CONTENT).split(System.getProperty("line.separator"));

		compareString(temp, content);
		info("Email content is true");
	}

	/**Function go to Edit Forum portlet. Click edit forum portlet
	 * @author lientm
	 */
	public void goToEditForumPortlet(){
		info("Go to edit forum portlet");
		mouseOver(ELEMENT_FORUM_PORTLET, true);
		click(ELEMENT_FORUM_PORTLET_EDIT_ICON);
		waitForAndGetElement(ELEMENT_FORUM_PORTLET_EDITMODE_TAB);
	}

	/**function save setting for Forum portlet
	 * @author lientm
	 */
	public void saveForumPortletSetting(){
		String MESSAGE_SAVE_SETTING_PORTLET = "Your portlet settings have been saved.";
		but = new Button(driver);
		pageE = new PageEditor(driver);

		but.save();
		alert.waitForConfirmation(MESSAGE_SAVE_SETTING_PORTLET);
		but.close();
		waitForElementNotPresent(ELEMENT_FORUM_PORTLET_EDITMODE_TAB);
		pageE.finishEditLayout();
	}

	/**function: setting dispaly panel in Forum portlet setting (go to edit page -> edit forum portlet -> select panel -> save)
	 * @author lientm
	 * @param show: refer function selectPanel()
	 */
	public void settingForumPortletPanel(boolean... show){
		navTool = new NavigationToolbar(driver);
		navTool.goToEditPageEditor();
		goToEditForumPortlet();
		selectPanel(show);
		saveForumPortletSetting();
	}

	/**function: select show/hire category/forum (go to edit page -> edit forum portlet setting -> setting -> save
	 * @author lientm
	 * @param itemName: refer selectDisplayCategoryAndForum()
	 * @param isCategory: refer selectDisplayCategoryAndForum()
	 * @param display: refer selectDisplayCategoryAndForum()
	 */
	public void settingForumPortletSelectDisplay(String itemName, boolean isCategory, boolean display){
		navTool = new NavigationToolbar(driver);
		navTool.goToEditPageEditor();
		goToEditForumPortlet();
		selectDisplayCategoryAndForum(itemName, isCategory, display);
		saveForumPortletSetting();
	}

	/**Function select option show panels in forum portlet setting
	 * @author lientm
	 * @param show: array option to show panels
	 *        show[0]: show Jump to
	 *        show[1]: show moderator
	 *        show[2]: show poll
	 *        show[3]: show quick reply
	 *        show[4]: show legend icon reply
	 *        show[5]: show rule panel
	 *        show[6]: show statistic panel
	 */
	public void selectPanel(boolean... show){
		if (show.length > 0){
			click(ELEMENT_FORUM_PORTLET_PANEL_TAB);
			if (show[0]){
				check(ELEMENT_SHOW_FORUM_JUMP_CHECKBOX, 2);
			}else {
				uncheck(ELEMENT_SHOW_FORUM_JUMP_CHECKBOX, 2);
			}
		}
		if (show.length > 1){
			if (show[1]){
				check(ELEMENT_SHOW_MODERATOR_CHECKBOX, 2);
			}else {
				uncheck(ELEMENT_SHOW_MODERATOR_CHECKBOX, 2);
			}
		}
		if (show.length > 2){
			if (show[2]){
				check(ELEMENT_SHOW_POLL_CHECKBOX, 2);
			} else {
				uncheck(ELEMENT_SHOW_POLL_CHECKBOX, 2);
			}
		}
		if (show.length > 3){
			if (show[3]){
				check(ELEMENT_SHOW_QUICK_REPLY_CHECKBOX, 2);
			} else {
				uncheck(ELEMENT_SHOW_QUICK_REPLY_CHECKBOX, 2);
			}
		}
		if (show.length > 4){
			if (show[4]){
				check(ELEMENT_SHOW_ICON_LEGEND_CHECKBOX, 2);
			} else {
				uncheck(ELEMENT_SHOW_ICON_LEGEND_CHECKBOX, 2);
			}
		}
		if (show.length > 5){
			if (show[5]){
				check(ELEMENT_SHOW_RULE_CHECKBOX, 2);
			} else {
				uncheck(ELEMENT_SHOW_RULE_CHECKBOX, 2);
			}
		}
		if (show.length > 6){
			if (show[6]){
				check(ELEMENT_SHOW_STATISTIC_CHECKBOX, 2);
			} else {
				uncheck(ELEMENT_SHOW_STATISTIC_CHECKBOX, 2);
			}
		}
	}

	/**Function check or uncheck Category or forum in Forum portlet setting
	 * @author lientm
	 * @param itemName: name of category/forum
	 * @param isCategory: = true: category
	 * 					  = false: forum
	 * @param display: = true: check to display
	 * 				   = false: uncheck
	 */
	public void selectDisplayCategoryAndForum(String itemName, boolean isCategory, boolean display){
		By category_checkbox = By.xpath("//*[text()='" + itemName + "']/../../../*[@class='ParentCheckBox']/input");
		By forum_checkbox = By.xpath("//*[text()='" + itemName + "']/../..//input[@type='checkbox']");
		By element_category = By.xpath("//*[text()='" + itemName + "']/../../../../div[@class='NodeLabel']//a");

		if (isCategory){
			WebElement category = waitForAndGetElement(category_checkbox);
			if ((display && !category.isSelected()) || (!display && category.isSelected())){
				click(category_checkbox);
			}
		}else {
			if (waitForAndGetElement(forum_checkbox, 3000, 0) == null){
				click(element_category);
			}
			WebElement forum = waitForAndGetElement(forum_checkbox);
			if ((display && !forum.isSelected()) || (!display && forum.isSelected())){
				click(forum_checkbox);
			}
		}		
	}	

	/**function go to RSS for any item (by rightclick on item -> choose RSS)
	 * @author lientm
	 * @param itemName: text of item that need view RSS
	 */
	public void goToRSS(String itemName){
		By rss = By.xpath("//a[text()='" + itemName + "']/..//a[text()='RSS']");

		rightClickOnElement(By.linkText(itemName));
		click(rss);
		Utils.pause(2000);
	}

	/**
	 * @author thaopth
	 * Date: 26 Dec 2012
	 */
	public void goToMySubscriptions() {
		goToSetting();
		click(ELEMENT_SETTING_MYSCRIPTIONS_TAB);
		waitForAndGetElement(ELEMENT_SETTING_EMAIL_ADDRESS);
	}

	public void deleteWatches (String item) {
		click(ELEMENT_DELETE_WATCH.replace("${item}", item));
		alert.waitForConfirmation("Are you sure to delete this subscription?");
		waitForElementNotPresent(ELEMENT_DELETE_WATCH.replace("${item}", item));

	}


	/** function: input data to a frame in other frame
	 * @author lientm
	 * @param frame1
	 * @param frame2
	 * @param data
	 * @param validate = null: clear data before
	 *                 = true: clear data before
	 *                 = false: not clear data before
	 */

	public void inputDataToFrameInFrame(By frame1, By frame2, String data, boolean...validate){
		boolean valid = validate.length > 0 ? validate[0]: true;
		boolean verify = validate.length > 1 ? validate[1]: true;
		try {
			WebElement inputsummary = null;

			for (int repeat = 0;; repeat++) {
				if (repeat >= DEFAULT_TIMEOUT/WAIT_INTERVAL) {
					info("Fail to input data to frame");
				}
				driver.switchTo().frame(waitForAndGetElement(frame1));
				driver.switchTo().frame(waitForAndGetElement(frame2));
				inputsummary = driver.switchTo().activeElement();
				if (valid){
					((JavascriptExecutor) driver).executeScript("document.body.innerHTML='" + data + "'");
				}else {
					inputsummary.sendKeys(data); break;
				}
				if(verify){
					if (data.equals(inputsummary.getText())) 
						break;
				}else break;
				switchToParentWindow();
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			inputDataToFrameInFrame(frame1, frame2, data, validate);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			inputDataToFrameInFrame(frame1, frame2, data, validate);
		} finally {
			loopCount = 0;
		}
	}

	/** function: Attach file in attach popup
	 * @author lientm
	 * @param number: number of upload container that need upload file
	 * @param filePath: path to file upload
	 */
	public void attachFile(String filePath){
		String[] file = filePath.split("/");
		for (int i = 0; i < file.length; i ++){
			WebElement element = waitForAndGetElement(ELEMENT_ATTACHMENT_FILE_INPUT, DEFAULT_TIMEOUT, 1, 2);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", element);
			element.sendKeys(Utils.getAbsoluteFilePath("TestData/" + file[i]));
			waitForAndGetElement("//*[@class='fileNameLabel' and text()='" + file[i] + "']");
		}
		click(ELEMENT_ATTACHMENT_SAVE_BUTTON);
		waitForElementNotPresent(ELEMENT_ATTACHMENT_SAVE_BUTTON);
	}
	
	public void settingMailForUser(String...email){
		but = new Button(driver);
		String user = email.length > 0 ? email[0] : EMAIL_ADDRESS1;
		click(ELEMENT_SETTING);
		waitForAndGetElement(ELEMENT_SETTING_POPUP);
		click(ELEMENT_SETTING_MYSCRIPTIONS_TAB);
		waitForAndGetElement(ELEMENT_SETTING_EMAIL_ADDRESS);
		info("Set mail address for forum");
		type(ELEMENT_SETTING_EMAIL_ADDRESS, user, true);
		click(ELEMENT_SETTING_EMAIL_UPDATE);
		Utils.pause(1000);
		but.save();
		waitForElementNotPresent(ELEMENT_SETTING_POPUP);
	}
}
