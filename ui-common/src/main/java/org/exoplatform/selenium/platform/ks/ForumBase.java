package org.exoplatform.selenium.platform.ks;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.UserGroupManagement.selectGroup;

public class ForumBase extends KsBase {	
	//-----------------Forum Home screen--------------------------------------------
	public static By ELEMENT_ADD_CATEGORY = By.linkText("Add Category");
	public static By ELEMENT_ADD_FORUM = By.linkText("Add Forum");
	public static By ELEMENT_ALERT = By.xpath("//div[@class='UIPopupWindow UIDragObject ExoMessageDecorator']");
	public static By ELEMENT_INFO = By.xpath("//span[@class='PopupIcon InfoMessageIcon']");
	public static By ELEMENT_JUMP_TO = By.id("forumLink");
	public static By ELEMENT_GO_BUTTON = By.linkText("Go");
	public static By ELEMENT_MORE_ACTION = By.linkText("More Actions");
	public static By ELEMENT_MODERATION = By.linkText("Moderation");
	public static String ELEMENT_WATCH = "//a[@class='${watchIcon}' and contains(text(), 'Watch')]";
	public static String ELEMENT_UNWATCH = "//a[@class='${watchIcon}' and contains(text(), 'Unwatch')]";
	public static By ELEMENT_BOOKMARKS = By.linkText("Bookmarks");
	public static By ELEMENT_ADMINISTRATION = By.xpath("//a[@class='DownArrow1Icon' and text()='Administration']");
	public static By ELEMENT_SORT_SETTING = By.xpath("//span[text()='Sort Settings']");
	public static By ELEMENT_CENSOR_KEYWORDS = By.xpath("//span[text()='Censor Keywords']");
	public static By ELEMENT_BAN_IP = By.xpath("//span[text()='Banned IPs']");
	public static By ELEMENT_BBCODE = By.xpath("//span[text()='BBCodes']");
	public static By ELEMENT_PRUNE = By.xpath("//span[text()='Pruning']");
	public static By ELEMENT_IMPORT = By.xpath("//span[text()='Import']");
	public static By ELEMENT_EXPORT_CATEGORY = By.xpath("//span[text()='Export']");
	public static By ELEMENT_EXPORT_FORUM = By.linkText("Export Forum");
	//	public static By ELEMENT_SETTING = By.linkText("Settings");

	//-----------------Watch/Unwatch screen-------------------------------------------
	public static By ELEMENT_WATCH_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Messages']");
	public static String MESSAGE_WATCH = "You are now watching this item.";
	public static String MESSAGE_UNWATCH = "You are no longer watching this item.";	

	//----------------Book Marks form------------------------------------------
	public static By ELEMENT_BOOKMARKS_POPUP = By.xpath("//span[@class='PopupTitle' and text()='My Bookmarks']");
	public static By ELEMENT_BOOKMARKS_OPTION = By.xpath("//*[@id='UIPopupMenu1']/*//a[text()='Bookmark']");
	public static String ELEMENT_BOOKMARKS_ITEM = "//a[@class='ActionLink' and text()='${item}']";
	public static String ELEMENT_BOOKMARKS_REMOVE = "//a[@class='ActionLink' and text()='${item}']/../../*//div[@class='DeleteIcon']";

	//----------------Set Permission tab-----------------------------------------
	public static By ELEMENT_PERMISSION_TAB = By.xpath("//div[@class='MiddleTab' and text()='Permissions']");
	public static By ELEMENT_TOPICABLE = By.id("Topicable");
	public static By ELEMENT_POSTABLE = By.id("Postable");
	public static By ELEMENT_VIEWER = By.id("Viewer");
	public static String ELEMENT_SELECT_USER_ICON = "//*[@id='${element}']/../img[@class='SelectUserIcon']";
	public static String ELEMENT_SELECT_ROLE_ICON = "//*[@id='${element}']/../img[@class='SelectMemberShipIcon']";
	public static String ELEMENT_SELECT_GROUP_ICON = "//*[@id='${element}']/../img[@class='SelectGroupIcon']";
	public static By ELEMENT_SELECT_ROLE_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Select a role']");
	public static By ELEMENT_SELECT_USER_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Select a user']");
	public static By ELEMENT_SELECT_GROUP_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Select a group']");

	//-----------------simple search screen-----------------------------------
	public static By ELEMENT_SIMPLE_SEARCH_TEXTBOX = By.id("inputValue");
	public static By ELEMENT_SIMPLE_SEARCH_BUTTON = By.xpath("//a[@class='SearchLink SearchForumIcon']");
	public static By ELEMENT_SIMPLE_SEARCH_LIST = By.id("UIForumListSearch");
	public static By ELEMENT_SIMPLE_SEARCH_TITLE_FORM = By.xpath("//div[@class='TitleBar' and text()='Search Result']");

	//-----------------Advanced Search form--------------------------------
	public static By ELEMENT_ADVANCED_SEARCH_ICON = By.xpath("//a[@class='AdvancedSearch']");
	public static By ELEMENT_ADVANCED_SEARCH_FORM = By.id("UISearchForm");
	public static By ELEMENT_ADVANCED_SEARCH_TERMS = By.id("SearchValue");
	public static By ELEMENT_ADVANCED_SEARCH_IN = By.id("SearchType");
	public static By ELEMENT_ADVANCED_SEARCH_SCOPE_FULL = By.id("Scope_entire");
	public static By ELEMENT_ADVANCED_SEARCH_SCOPE_TITLES = By.id("Scope_title");
	public static By ELEMENT_ADVANCED_SEARCH_USER = By.id("SearchUser");
	public static By ELEMENT_ADVANCED_SEARCH_CREATED_FROM = By.id("FromDateCreated");
	public static By ELEMENT_ADVANCED_SEARCH_CREATED_TO = By.id("ToDateCreated");
	public static By ELEMENT_ADVANCED_SEARCH_MODERATOR = By.id("Moderator");
	public static By ELEMENT_ADVANCED_SEARCH_BUTTON = By.linkText("Search");

	//-----------------Sort setting form-----------------------------------
	public static By ELEMENT_SORT_SETTING_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Sort Settings']");
	public static By ELEMENT_SORT_FORUM_BY = By.id("forumSortBy");
	public static By ELEMENT_SORT_FORUM_DIRECTION = By.id("forumSortByType");
	public static By ELEMENT_SORT_TOPIC_BY = By.id("topicSortBy");
	public static By ELEMENT_SORT_TOPIC_DIRECTION = By.id("topicSortByType");

	//----------------Set Censor keywords form----------------------------------
	public static By ELEMENT_CENSOR_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Censor Keyword']");
	public static By ELEMENT_CENSORED_KEYWORDS =  By.id("censorKeyword");

	//----------------Set Ban IP form--------------------------------------------
	public static By ELEMENT_BAN_IP_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Banned IPs']");
	public static By ELEMENT_BAN_IP_FILTER = By.id("searchIpBan");
	public static By ELEMENT_BAN_IP_ADD = By.linkText("[Add]");
	public static String ELEMENT_BAN_IP_ADDRESS = "newIpBan${No}";
	public static String ELEMENT_BAN_IP_DELETE = "//*[text()='${ip}']/../*//a[text()='X']";

	//----------------Set BB Code form-------------------------------------
	public static By ELEMENT_BBCODE_POPUP = By.xpath("//span[@class='PopupTitle' and text()='BBCode Manager']");
	public static String ELEMENT_BBCODE_ACTIVE_NO_OPTION = "//input[@type='checkbox' and @id='${tag}']";
	public static String ELEMENT_BBCODE_ACTIVE_HAVE_OPTION = "//input[@type='checkbox' and contains(@id,'${tag}" + "opt" + "')]";
	public static By ELEMENT_BBCODE_ADD_BUTTON = By.linkText("Add BBCode");
	public static String ELEMENT_BBCODE_EDIT_NO_OPTION = "//input[@type='checkbox' and @id='${tag}']/../../*//div[@title='Edit BBCode']";
	public static String ELEMENT_BBCODE_EDIT_HAVE_OPTION = "//input[@type='checkbox' and contains(@id,'${tag}" + "opt" + "')]/../../*//div[@title='Edit BBCode']";
	public static String ELEMENT_BBCODE_DELETE_NO_OPTION = "//input[@type='checkbox' and @id='${tag}']/../../*//div[@title='Delete BBCode']";
	public static String ELEMENT_BBCODE_DELETE_HAVE_OPTION = "//input[@type='checkbox' and contains(@id,'${tag}" + "opt" + "')]/../../*//div[@title='Delete BBCode']";

	public static By ELEMENT_BBCODE_ADD_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Add BBCode']");
	public static By ELEMENT_BBCODE_EDIT_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Edit BBCode']");
	public static By ELEMENT_BBCODE_TAG	= By.id("TagName");
	public static By ELEMENT_BBCODE_REPLACEMENT = By.id("Replacement");
	public static By ELEMENT_BBCODE_DESCRIPTION = By.id("Description");
	public static By ELEMENT_BBCODE_EXAMPLE = By.id("Example");
	public static By ELEMENT_BBCODE_OPTION = By.id("UseOption");

	//----------------------Prune management form---------------------------------
	public static By ELEMENT_PRUNE_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Auto Prune']");
	public static String ELEMENT_PRUNE_ACTIVE = "//td[text()='${category}']/../*//input[@type='checkbox']";
	public static String ELEMENT_PRUNE_ACTIVED = "//td[text()='${category}']/../*//input[@type='checkbox' and @checked='checked']";
	public static String ELEMENT_PRUNE_SETTING = "//td[text()='${category}']/../td[text()='{$forum}']/..//div[@title='Prune Settings']";
	public static String ELEMENT_PRUNE_RUN = "//td[text()='${category}']/../td[text()='{$forum}']/..//div[@title='Run']";

	public static By ELEMENT_PRUNE_SETTING_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Prune Settings']");
	public static By ELEMENT_PRUNE_ACTIVE_DAY = By.id("inActiveDay");
	public static By ELEMENT_PRUNE_ACTIVE_DAY_TYPE = By.id("inActiveDayType");
	public static By ELEMENT_PRUNE_JOB_DAY = By.id("jobDay");
	public static By ELEMENT_PRUNE_JOB_DAY_TYPE = By.id("jobDayType");
	public static String MSG_PRUNE_INVALID_INACTIVE_DAY = "Invalid number format in field \"Clear topics that have been inactive for\".";
	public static String MSG_PRUNE_INVALID_JOB_DAY = "Invalid number format in field \"Run prune job every\".";
	public static String MSG_PRUNE_NOT_CONFIG = "Please configure the prune settings for this item.";
	public static By ELEMENT_PRUNE_DRY_RUN = By.linkText("Dry Run");

	//--------------------Profile setting form------------------------------------
	public static By ELEMENT_SETTING = By.linkText("Settings");
	//	public static By ELEMENT_SETTING_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Settings']");
	//-----------------Setting form---------------------------------------------------
	public static By ELEMENT_SETTING_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Settings']");
	public static String ELEMENT_SETTING_EMAIL_CHECKBOX = "//a[contains(text(), '${forum}')]/../../../*//input[contains(@id, 'EMAILforum')]"; 
	public static String ELEMENT_SETTING_MAIL_DELETE = "//a[contains(text(), '${forum}')]/../../../*//div[@class='DeleteIcon']";
	public static By ELEMENT_SETTING_EMAIL_ADDRESS = By.id("EmailAddress");
	public static By ELEMENT_SETTING_EMAIL_UPDATE = By.linkText("Update");
	public static By ELEMENT_SETTING_MYSCRIPTIONS_TAB = By.xpath("//div[@class='MiddleTab' and contains(text(), 'My Subscriptions')]");
	public static By ELEMENT_SCREEN_NAME = By.id("ScreenName");
	public static By ELEMENT_SIGNATURE = By.id("Signature");
	public static By ELEMENT_IS_DISPLAY_SIGNATURE = By.id("IsDisplaySignature");
	public static By ELEMENT_IS_DISPLAY_AVATAR = By.id("IsDisplayAvatar");
	public static By ELEMENT_WATCH_TOPIC_START = By.id("AutoWatchMyTopics");
	public static By ELEMENT_WATCH_TOPIC_POST =  By.id("AutoWatchTopicIPost");

	//---------------------Notifications------------------
	public static By ELEMENT_NOTIFICATION_LINK = By.xpath("//span[text()='Notifications']");
	public static By ELEMENT_NOTIFY_FRAME=By.xpath("//*[@id='xEditingArea']/iframe");
	public static String ELEMENT_NOTIFY_TEXT= "New Posts Notification";
	public static By ELEMENT_NOTIFY_FRAME_UP=By.id("notifyEmail___Frame");
	public static By ELEMENT_NOTIFY_PREFIX = By.id("enableHeaderSubject");
	public static By ELEMENT_NOTIFY_SUBJECT = By.id("headerSubject");
	public static By ELEMENT_NOTIFY_RESET = By.xpath("//img[@title='Reset']");
	public static String MSG_NOTIFY_BLANK = "The notification email is required.";
	public static By ELEMENT_NOTIFY_MOVE_FRAME_UP= By.id("notifyEmailMoved___Frame");
	public static By ELEMENT_NOTIFY_MOVE_TAB = By.xpath("//a[contains(text(),'Moved Notification')]");
	public static By ELEMENT_NOTIFY_MOVE_RESET = By.xpath("//div[@id='notifyEmailMoveTab']//img[@title='Reset']");

	//----------------------Gmail form ---------------------------------------------------
	public static String WEB_MAIL = "https://mail.google.com";
	public static String MAIL_ADDRESS = "exomailtest01@gmail.com";
	public static String PASS = "exoadmin";
	public static By ELEMENT_DELETE = By.xpath("//*[@id=':ro']/div[2]//*[@class='ar9 T-I-J3 J-J5-Ji']");
	public static By user_name = By.id("Email");
	public static By password = By.id("Passwd");
	public static By signIn = By.id("signIn");
	public static By inbox = By.xpath("//a[contains(@title, 'Inbox')]");
	public static By ELEMENT_MAIL_CONTENT = By.xpath(".//*[@class='ii gt adP adO']/div");

	/**function: select a user when set permission for a element
	 * @author lientm
	 * @param element: id of element need set permission
	 * @param user: user that needs to set permission
	 */
	public static void selectUserPermission(String element, String user){
		By ELEMENT_SELECT_USER = By.xpath(ELEMENT_SELECT_USER_ICON.replace("${element}", element));
		By ELEMENT_USER = By.xpath(ELEMENT_USER_CHECKBOX.replace("${user}", user));

		waitForElementPresent(ELEMENT_SELECT_USER);
		click(ELEMENT_SELECT_USER);
		waitForElementPresent(ELEMENT_USER);
		if (getElement(ELEMENT_USER).isSelected() == false){
			click(ELEMENT_USER);
		}
		click(ELEMENT_ADD_BUTTON);
		waitForElementNotPresent(ELEMENT_ADD_BUTTON);
		waitForTextPresent(user);
	}

	/**function: select a group when set permission
	 * @author lientm
	 * @param element: id of element need set permission
	 * @param grouppath: group path
	 */
	public static void selectGroupPermission(String element, String grouppath){
		By ELEMENT_SELECT_GROUP = By.xpath(ELEMENT_SELECT_GROUP_ICON.replace("${element}", element));

		waitForElementPresent(ELEMENT_SELECT_GROUP);
		click(ELEMENT_SELECT_GROUP);
		waitForElementPresent(ELEMENT_SELECT_GROUP_POPUP);
		selectGroup(grouppath);
		click(ELEMENT_SELECT_THIS_GROUP);
	}

	/**function: select group and membership when set permission
	 * @author lientm
	 * @param element: id of element need set permission
	 * @param groupPath: path to group
	 * @param membership
	 */
	public static void selectGroupMembership(String element, String groupPath, String membership){
		By ELEMENT_SELECT_ROLE = By.xpath(ELEMENT_SELECT_ROLE_ICON.replace("${element}", element));

		waitForElementPresent(ELEMENT_SELECT_ROLE);
		click(ELEMENT_SELECT_ROLE);
		waitForElementPresent(ELEMENT_SELECT_ROLE_POPUP);
		selectGroup(groupPath);	
		click(By.linkText(membership));
		waitForTextPresent(membership);
	}

	/** Function: set permission with many option
	 * @author lientm
	 * @param locator: id of element need set permission
	 * @param chooseUser: choose the way to input Private User
	 * 			  = 0: Not set permission
	 *            = 1: Input data directly -> @userGroup = user input
	 *            = 2: select user -> @userGroup = user
	 *            = 3: select group -> @userGroup = group path
	 *            else: select group and membership -> @userGroup = group path and membership       
	 */
	public static void setPermissionWithOption(String locator, int chooseUser, String[] userGroup){

		By ELEMENT = By.id(locator);

		switch(chooseUser){
		case 0: break;
		case 1: type(ELEMENT, userGroup[0], true);
		break;
		case 2: ForumBase.selectUserPermission(locator, userGroup[0]);
		break;
		case 3: ForumBase.selectGroupPermission(locator, userGroup[0]);
		break;
		default: ForumBase.selectGroupMembership(locator, userGroup[0], userGroup[1]);
		break;			
		}
	}

	/** function Jump to a category
	 * @author lientm
	 * @param destination: title of a category or a forum that needs to come
	 */
	public static void jumpTo(String destination){
		WebElement element = waitForAndGetElement(ELEMENT_JUMP_TO);
		if (element != null){
			info("Jump to category " + destination);
			select(ELEMENT_JUMP_TO, destination);
		}
		click(ELEMENT_GO_BUTTON);
		pause(1000);
	}

	/** function: watch an item
	 * @author lientm
	 * @param watchClass: class of watch/unwatch icon to determine watch/unwatch xpath
	 */
	public static void watchItem(String watchClass){
		By WATCH = By.xpath(ELEMENT_WATCH.replace("${watchIcon}", watchClass));
		By UNWATCH = By.xpath(ELEMENT_UNWATCH.replace("${watchIcon}", watchClass));

		WebElement watch = waitForAndGetElement(WATCH);
		if ( watch != null) {
			info("Set watch a item");
			click(WATCH);
			waitForElementPresent(ELEMENT_WATCH_POPUP);
			waitForMessage(MESSAGE_WATCH);
			click(ELEMENT_OK_BUTTON);
			waitForElementNotPresent(ELEMENT_WATCH_POPUP);
			waitForElementPresent(UNWATCH);
			info("Watch item successfully");
		} else {
			info("Not found watch link");
		}
	}

	/** function: unwatch an item
	 * @author lientm
	 * @param watchClass: class of watch/unwatch icon to determine watch/unwatch xpath
	 */
	public static void unwatchItem(String watchClass){
		By WATCH = By.xpath(ELEMENT_WATCH.replace("${watchIcon}", watchClass));
		By UNWATCH = By.xpath(ELEMENT_UNWATCH.replace("${watchIcon}", watchClass));

		WebElement unwatch = waitForAndGetElement(UNWATCH);
		if ( unwatch != null) {
			info("Set unwatch a item");
			click(UNWATCH);
			waitForElementPresent(ELEMENT_WATCH_POPUP);
			waitForMessage(MESSAGE_UNWATCH);
			click(ELEMENT_OK_BUTTON);
			waitForElementNotPresent(ELEMENT_WATCH_POPUP);
			waitForElementPresent(WATCH);
			info("Unwatch item successfully");
		} else {
			info("Not found unwatch link");
		}
	}

	/** function: add bookmark for an Item (category/forum)
	 * @author lientm
	 * @param item: title of a category/ a forum
	 */
	public static void addBookmarksItem(String item){
		By element_item = By.xpath(ELEMENT_BOOKMARKS_ITEM.replace("${item}", item));

		//set bookmark
		info("Add bookmark");
		waitForElementPresent(By.linkText(item));
		for(int repeat=0;; repeat ++)
		{
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot bookmark this item after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(By.linkText(item));
			if (waitForAndGetElement(ELEMENT_BOOKMARKS_OPTION) != null) break;
			pause(WAIT_INTERVAL);
			info("Retry...[" + repeat + "]");
		}
		click(ELEMENT_BOOKMARKS_OPTION);
		//check bookmarks display
		waitForElementPresent(ELEMENT_BOOKMARKS);
		click(ELEMENT_BOOKMARKS);
		waitForElementPresent(ELEMENT_BOOKMARKS_POPUP);
		waitForElementPresent(element_item);
		info("Add bookmark successfully");
	}

	/** function: delete bookmark
	 * @author lientm
	 * @param item: name of bookmark
	 */
	public static void deleteBookmarkItem(String item){
		By element_delete = By.xpath(ELEMENT_BOOKMARKS_REMOVE.replace("${item}", item));

		info("Delete bookmark");
		waitForElementPresent(element_delete);
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
	public static boolean simpleSearch(String key){
		boolean result = true;
		info("Simple search with key " + key);
		type(ELEMENT_SIMPLE_SEARCH_TEXTBOX, key, true);
		click(ELEMENT_SIMPLE_SEARCH_BUTTON);
		waitForElementPresent(ELEMENT_SIMPLE_SEARCH_LIST);
		waitForElementPresent(ELEMENT_SIMPLE_SEARCH_TITLE_FORM);
		if (isTextPresent("No matches.") == true){
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
	public static boolean advancedSearch(boolean scope, String... key){
		boolean result = true;

		info("Do advance search");
		click(ELEMENT_ADVANCED_SEARCH_ICON);
		waitForElementPresent(ELEMENT_ADVANCED_SEARCH_FORM);
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
		click(ELEMENT_ADVANCED_SEARCH_BUTTON);
		waitForElementPresent(ELEMENT_SIMPLE_SEARCH_LIST);
		waitForElementPresent(ELEMENT_SIMPLE_SEARCH_TITLE_FORM);
		if (isTextPresent("No matches.") == true){
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
	public static void sortSetting(String forumBy, int dirForum, String topicBy, int dirTopic){
		info("Setting sort");
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForElementPresent(ELEMENT_SORT_SETTING);
		click(ELEMENT_SORT_SETTING);
		waitForElementPresent(ELEMENT_SORT_SETTING_POPUP);
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
		save();
		waitForElementNotPresent(ELEMENT_SORT_SETTING_POPUP);
		info("setting sort successfully");
	}

	/** function: set sensor keyword
	 * @author lientm
	 * @param key: key to setup
	 */
	public static void setCensorKeywords(String key){
		info("Set censor keywords");
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForElementPresent(ELEMENT_CENSOR_KEYWORDS);
		click(ELEMENT_CENSOR_KEYWORDS);
		waitForElementPresent(ELEMENT_CENSOR_POPUP);
		if (key != null){
			type(ELEMENT_CENSORED_KEYWORDS, key, true);
		}
		save();
		waitForElementNotPresent(ELEMENT_CENSOR_POPUP);
		info("Set censor keyword successfully");
	}

	/**
	 * function go to BanIP management
	 * @author lientm
	 */
	public static void goToBanIp(){
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForElementPresent(ELEMENT_BAN_IP);
		click(ELEMENT_BAN_IP);
		waitForElementPresent(ELEMENT_BAN_IP_POPUP);
	}

	/**function: set ban IP
	 * @author lientm
	 * @param ban: group of some IP address
	 */
	public static void setBanIp(String... ban){
		if (ban.length > 0){
			info("Set Ban Ip");
			goToBanIp();
			for (int i = 0; i < ban.length; i ++){ 
				String temp[] = ban[i].split("\\.");
				for (int j = 0; j < temp.length; j ++){
					type(By.id(ELEMENT_BAN_IP_ADDRESS.replace("${No}", Integer.toString(j + 1))), temp[j], true);
				}
				click(ELEMENT_BAN_IP_ADD);
				waitForElementPresent(By.xpath("//td[@class='FieldLabel' and text()='" + ban[i] + "']"));
			}
			close();
		}
	}

	/**
	 * function delete Ban Ip
	 * @param ip: ip to delete
	 */
	public static void deleteBanIp(String ip){
		By element_delete = By.xpath(ELEMENT_BAN_IP_DELETE.replace("${ip}", ip));

		goToBanIp();
		waitForElementPresent(element_delete);
		click(element_delete);
		acceptAlert();
		waitForElementNotPresent(element_delete);
		close();
	}

	/** function: go to BB code management
	 * @author lientm
	 */
	public static void goToBBCodeManagement(){
		info("Go to BB code management");
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForElementPresent(ELEMENT_BBCODE);
		click(ELEMENT_BBCODE);
		waitForElementPresent(ELEMENT_BBCODE_POPUP);
	}

	/** function: modify a BBCode
	 * @author lientm
	 * @param tag: tag of BBCode
	 * @param replace: htmp code that replaces the user-entered BBCode
	 * @param description: text to describe the BBCode tag
	 * @param example: an example for this particular BBCode
	 * @param option: choose option or not
	 */
	public static void modifyBBcodeInfo(String tag, String replace, String description, String example, boolean option){
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
		save();
	}

	/** function: add a BBCode
	 * @author lientm
	 * @param tag: tag of BBCode
	 * @param replace: htmp code that replaces the user-entered BBCode
	 * @param description: text to describe the BBCode tag
	 * @param example: an example for this particular BBCode
	 * @param option: choose option or not
	 */
	public static void addBBCode(String tag, String replace, String description, String example, boolean option){
		info("Add new BBcode");
		click(ELEMENT_BBCODE_ADD_BUTTON);
		waitForElementPresent(ELEMENT_BBCODE_ADD_POPUP);
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
	public static void activeBBcode(String tag, boolean active, boolean option){
		By ELEMENT_ACTIVE_OPTION = By.xpath(ELEMENT_BBCODE_ACTIVE_HAVE_OPTION.replace("${tag}", tag));
		By ELEMENT_ACTIVE_NOT_OPTION = By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", tag));

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
			save();
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
	public static void editBBcode(String tagold, boolean haveoption, String tagnew, String replace, String description, String example, boolean option){
		By ELEMENT_EDIT_OPTION = By.xpath(ELEMENT_BBCODE_EDIT_HAVE_OPTION.replace("${tag}", tagold));
		By ELEMENT_EDIT_NOT_OPTION = By.xpath(ELEMENT_BBCODE_EDIT_NO_OPTION.replace("${tag}", tagold));

		info("Edit a BBcode have tag " + tagold);
		if (haveoption){
			click(ELEMENT_EDIT_OPTION);
		} else {
			click(ELEMENT_EDIT_NOT_OPTION);
		}
		waitForElementPresent(ELEMENT_BBCODE_EDIT_POPUP);
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
	public static void deleteBBcode(String tag, boolean option){
		By ELEMENT_DELETE_OPTION = By.xpath(ELEMENT_BBCODE_DELETE_HAVE_OPTION.replace("${tag}", tag));
		By ELEMENT_DELETE_NOT_OPTION = By.xpath(ELEMENT_BBCODE_DELETE_NO_OPTION.replace("${tag}", tag));

		info("Delete a BBcode have tag " + tag);
		if (option){
			click(ELEMENT_DELETE_OPTION);
			acceptAlert();
			waitForElementNotPresent(ELEMENT_DELETE_OPTION);
		} else {
			click(ELEMENT_DELETE_NOT_OPTION);
			acceptAlert();
			waitForElementNotPresent(ELEMENT_DELETE_NOT_OPTION);
		}
		info("Delete BBcode successfully");
	}

	/** function: go to Prune Management
	 * @author lientm
	 */
	public static void goToPruneManagement(){
		info("Go to prune management");
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForElementPresent(ELEMENT_PRUNE);
		click(ELEMENT_PRUNE);
		waitForElementPresent(ELEMENT_PRUNE_POPUP);
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
	public static void pruneSetting(String category, String forum, String activeDay, String dayType, String jobDay, String jobDayType){
		By ELEMENT_SETTING = By.xpath(ELEMENT_PRUNE_SETTING.replace("${category}", category).replace("{$forum}",forum));

		if (category != null && category != ""){
			info("Setting prune for category " + category);
			waitForElementPresent(ELEMENT_SETTING);
			click(ELEMENT_SETTING);
			waitForElementPresent(ELEMENT_PRUNE_SETTING_POPUP);
			if (activeDay != "" && activeDay != null){
				type(ELEMENT_PRUNE_ACTIVE_DAY, activeDay, true);
				select(ELEMENT_PRUNE_ACTIVE_DAY_TYPE, dayType);
			}
			if (jobDay != "" && jobDay != null){
				type(ELEMENT_PRUNE_JOB_DAY, jobDay, true);
				select(ELEMENT_PRUNE_JOB_DAY_TYPE, jobDayType);
			}
			save();

		}
	}

	/** function: active a prune
	 * @author lientm
	 * @param category: title of category
	 * @param active = true: active
	 * 				 = false: deactive
	 */
	public static void activePrune(String category, boolean active){
		By ELEMENT_ACTIVE = By.xpath(ELEMENT_PRUNE_ACTIVE.replace("${category}", category));
		By ELEMENT_ACTIVED = By.xpath(ELEMENT_PRUNE_ACTIVED.replace("${category}", category));

		WebElement act = waitForAndGetElement(ELEMENT_ACTIVE);
		if (active && act.isSelected() == false){
			info("Active prune for category " + category);
			click(ELEMENT_ACTIVE);
			waitForElementPresent(ELEMENT_ACTIVED);
		}
		if (active == false && act.isSelected() == true){
			info("Deactive prune for category " + category);
			click(ELEMENT_ACTIVE);
			waitForElementNotPresent(ELEMENT_ACTIVED);
		}	
	}

	/** function: set driver to auto save file to TestData/TestOutput
	 * @author lientm
	 */
	public static void getDriverAutoSave(){
		String pathFile = System.getProperty("user.dir") + "/src/main/resources/TestData/TestOutput";

		FirefoxProfile fp = new FirefoxProfile();		
		fp.setPreference("browser.download.folderList", 2);
		info("Save file to " + pathFile);
		fp.setPreference("browser.download.dir", pathFile);
		fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-xpinstall;application/x-zip;application/x-zip-compressed;application/octet-stream;application/zip;application/pdf;application/msword;text/plain;application/octet");
		driver = new FirefoxDriver(fp);
		baseUrl = System.getProperty("baseUrl");
		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
	}

	/**
	 * function: check a file existed in folder
	 * @author lientm
	 * @param file: file name (eg: export.zip)
	 * @return: true -> file exist
	 * 			false-> file is not exist
	 */
	public static boolean checkFileExisted(String file){
		String pathFile = System.getProperty("user.dir") + "/src/main/resources/TestData/TestOutput/" + file;
		boolean found = false;

		if (new File(pathFile).isFile()){
			found = true;
		}
		return found;
	}

	/**
	 * function delete file in folder
	 * @author lientm
	 * @param file: file name
	 */
	public static void deleteFile(String file){
		String pathFile = System.getProperty("user.dir") + "/src/main/resources/TestOutput/" + file;
		File Files = new File(pathFile);

		Files.setWritable(true);
		Files.delete();
		if (checkFileExisted(file) == false){
			info("Delete file successfully");
		}else info("Have error when delete file");
	}

	/**
	 * function go to setting form
	 * @author lientm
	 */
	public static void goToSetting(){
		waitForElementPresent(ELEMENT_SETTING);
		click(ELEMENT_SETTING);
		waitForElementPresent(ELEMENT_SETTING_POPUP);
	}

	/**
	 * function setting User profile
	 * @author lientm
	 * @param screenName: data input to Screen Name
	 * @param sign: data input to Signature
	 * @param opt: option check checkbox group: display signature, display avatar, watch to topic start, watch topic post
	 */
	public static void settingProfileUser(String screenName, String sign, boolean...opt){
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
		save();
		waitForElementNotPresent(ELEMENT_SETTING_POPUP);
	}

	/**
	 * Go to Notifications
	 * @author thuntn
	 */
	public static void goToNotifications(){
		info("--Go to notifications--");

		click(ELEMENT_ADMINISTRATION);
		click(ELEMENT_NOTIFICATION_LINK);

		waitForTextPresent(ELEMENT_NOTIFY_TEXT);
	}


	//function setting mail address for user watch items
	public static void settingMailForUser(){
		waitForElementPresent(ELEMENT_SETTING);
		click(ELEMENT_SETTING);
		waitForElementPresent(ELEMENT_SETTING_POPUP);
		click(ELEMENT_SETTING_MYSCRIPTIONS_TAB);
		waitForElementPresent(ELEMENT_SETTING_EMAIL_ADDRESS);
		info("Set mail address for forum");
		type(ELEMENT_SETTING_EMAIL_ADDRESS, MAIL_ADDRESS, true);
		click(ELEMENT_SETTING_EMAIL_UPDATE);
		pause(1000);
		save();
		waitForElementNotPresent(ELEMENT_SETTING_POPUP);
	}

	//function open and go to mail
	public static void goToMail(){	    
		((JavascriptExecutor) driver).executeScript("window.open()");
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		info("Go to gmail");
		driver.navigate().to(WEB_MAIL);
		waitForElementPresent(user_name);

		//login to mail
		type(user_name, MAIL_ADDRESS, true);
		type(password, PASS, true);
		click(signIn);
		waitForElementPresent(inbox);
		click(inbox);
	}

	/**
	 * function: check content of mail then delete mail
	 * @param mail: element title of mail
	 * @param content: mail content
	 */
	public static void checkAndDeleteMail(By mail, String content){
		waitForElementPresent(mail);
		click(mail);	    
		waitForTextPresent(content);
		info("Found notify mail");

		info("delete mail");
		click(ELEMENT_DELETE);
	}

	/**Change content of notifications
	 * @author thuntn
	 * @param prefix: = true if check Add a prefix to notification field
	 * 				  = false if else
	 * @param subject: text to add to Subject notification field
	 * @param content: text to add to content field
	 */
	public static void changeNotifications(boolean prefix,String subject, String content){

		info("--Change content of notifications--");

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
		save();
	}
	/** Reset Notification as default
	 * @author thuntn
	 */
	public static void resetNotification(){

		info("--Reset Notification--");

		goToNotifications();
		type(ELEMENT_NOTIFY_SUBJECT,"[$CATEGORY][$FORUM] $TOPIC",true);
		click(ELEMENT_NOTIFY_RESET);
		save();
	}

	/** Function compare 2 paragraphs (compare in specific line)
	 * @author lientm
	 * @param temp: paragraphs 1
	 * @param content: paragraphs 2
	 */
	public static void compareString(String[] temp, String[] content){
		for (int i = 0; i < content.length; i ++){
			info("String1: " + temp[i] + "--- String2: " + content[i]);
			assert temp[i].contains(content[i]): "Fail! 2 Strings are different from each other"; 
		}
	}
	
	/**function check fomat of content mail
	 * @author lientm
	 * @param contentMail: content of mail (has '/' to separate paragraphs into lines)
	 */
	public static void checkContentMail(String contentMail){
		String[] content = contentMail.split("/");
		String[] temp = getText(ELEMENT_MAIL_CONTENT).split(System.getProperty("line.separator"));
		
		compareString(temp, content);
		info("Email content is true");
	}
}
