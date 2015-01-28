package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;
import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForumHomePage extends PlatformBase {
	
	//Action bar
	public final By ELEMENT_ACTIONBAR_ADDCATEGORY = By.xpath("//*[@class='uiIconAddCategory uiIconLightGray']");
	public final By ELEMENT_ACTIONBAR_ADDFORUM = By.xpath("//*[@class='uiIconForumCreateForum uiIconForumLightGray']");
	public final By ELEMENT_ACTIONBAR_USER = By.xpath("//*[@class='uiIconUser uiIconLightGray']");
	public final By ELEMENT_ACTIONBAR_SETTINGS = By.xpath("//*[@class='uiIconSetting uiIconLightGray']");

	public final By ELEMENT_ACTIONBAR_ADMINISTRATION = By.xpath(".//*[@id='Administrations']//div[@data-toggle='dropdown']");
	public final By ELEMENT_ACTIONBAR_BOOKMARK = By.xpath("//*[@class='actionIcon']//*[@class='uiIconBookmark uiIconLightGray']");
	
	public final By ELEMENT_ACTIONBAR_MANAGECAT = By.xpath("//*[@class='uiIconForumManageCategory uiIconForumLightGray']");
	public final By ELEMENT_ACTIONBAR_MANAGECAT_EDIT = By.xpath("//*[@class='dropdown-menu uiCategoryPopupMenu']/li[1]/a");
	public final By  ELEMENT_ACTIONBAR_MANAGECAT_EXPORTFORUM = By.xpath("//*[@class='dropdown-menu uiCategoryPopupMenu']/li[2]/a");
	public final By  ELEMENT_ACTIONBAR_MANAGECAT_IMPORTFORUM = By.xpath("//*[@class='dropdown-menu uiCategoryPopupMenu']/li[3]/a");
	public final By ELEMENT_ACTIONBAR_PRIVATE_MESSAGE = By.xpath(".//*[@id='uiRightActionBar']//a[contains(.,'Private Messages')]");
	//Add Category popup
	public final By ELEMENT_ADDCATEGORY_POPUP_CATEGORY_TAB= By.xpath(".//*[@id='UICategoryForm']//a[text()='Category']");
	public final By ELEMENT_ADDCATEGORY_POPUP_PERMISSION_TAB= By.xpath(".//*[@id='UICategoryForm']//a[text()='Permissions']");
	public final By ELEMENT_ADDCATEGORY_POPUP_TITLE= By.id("CategoryTitle");
	public final By ELEMENT_ADDCATEGORY_POPUP_ORDER= By.id("CategoryOrder");
	public final By ELEMENT_ADDCATEGORY_POPUP_DESCRIPTION= By.id("Description");
	public final By ELEMENT_ADDCATEGORY_POPUP_SAVE_BUTTON= By.xpath(".//*[@id='UICategoryForm']//button[text()='Save']");
	public final By ELEMENT_ADDCATEGORY_POPUP_CANCEL_BUTTON= By.xpath(".//*[@id='UICategoryForm']//button[text()='Cancel']");
	
	//Popup confirmation
	public By ELEMENT_OK_DELETE = By.xpath("//*[@id='UIForumPopupConfirmation']//*[text()='OK']");

	//Add forum popup
	public final By ELEMENT_ADDFORUM_POPUP_ADDFORUM_TAB= By.xpath(".//*[@id='UIForumForm']//a[text()='Add Forum']");
	public final By ELEMENT_ADDFORUM_POPUP_TITLE= By.id("ForumTitle");
	public final By ELEMENT_ADDFORUM_POPUP_ORDER= By.id("ForumOrder");
	public final By ELEMENT_ADDFORUM_POPUP_DESCRIPTION= By.id("Description");
	public final By ELEMENT_ADDFORUM_POPUP_SAVE_BUTTON= By.xpath(".//*[@id='UIForumForm']//button[text()='Save']");
	public final By ELEMENT_ADDFORUM_POPUP_CANCEL_BUTTON= By.xpath(".//*[@id='UIForumForm']//button[text()='Cancel']");
	
	//Edit forum popup
	public final By ELEMENT_POPUP_ADD_FORUM = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Forum']");
	
	//Move forum popup
	public final By ELEMENT_POPUP_MOVE_FORUM = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Move Forum']");
	
	
	//Forum content
	public final String ELEMENT_DETAIL_FORUM_CATEGORY_TITLE= ".//*[@id='UIForumDescription']//strong[text()='${title}']";
	public final String ELEMENT_FORUM_TITLE_LINK = ".//*[text()='${name}']";
	public final String ELEMENT_FORUM_DETAIL_CATEGORY_NAME_LINK=".//*[text()='${name}']";
	public final String ELEMENT_FORUM_DETAIL_FORUM_NAME_LINK=".//*[text()='${name}']";
	public final By ELEMENT_FORUM_WHAT_GOING_ON = By.xpath("//div[contains(text(),'Going on?')]");
	public final By ELEMENT_FORUM_START_TOPIC_DISABLE = By.xpath("//*[@id='UITopicContainer']//*[@data-original-title='Forum is closed for posting.']");
	public final By ELEMENT_FORUM_START_TOPIC_BUTTON = By.xpath("//*[@class='btn btn-primary pull-left']");
	public final String ELEMENT_SELECT_FORUM_TOPIC = "//*[contains(text(),'${link}')]";
	
	//Manage Category menu
	public final By ELEMENT_MANAGE_CATEGORY = By.xpath("//*[@class='uiIconForumManageCategory uiIconForumLightGray']");
	public final By ELEMENT_DELETE_CATEGORY = By.xpath("//*[@id='UICategoryConfirm0' and contains(text(),'Delete')]");
	
	//More Action menu
	public final By ELEMENT_MORE_ACTION = By.xpath("//form[@id='UITopicContainer']//*[@data-toggle='dropdown']/*[@class='uiIconSettings uiIconLightGray']");
	public final By ELEMENT_EDIT_FORUM = By.xpath("//*[contains(@href, 'EditForum')]");
	public final By ELEMENT_DELETE_FORUM = By.xpath("//*[contains(@data-action, 'RemoveForum')]");
	public final By ELEMENT_MOVE_FORUM = By.xpath("//*[contains(@href, 'MoveForum')]");
	public final By ELEMENT_START_TOPIC_BUTTON = By.xpath(".//*[@class='uiIconForumCreateTopic uiIconForumLightGray']");
	public final By ELEMENT_LOCK_FORUM = By.className("uiIconLockMedium");
	public final By ELEMENT_UNLOCK_FORUM = By.className("uiIconUnlockMedium");
	public final By ELEMENT_CLOSE_FORUM = By.xpath("//a[contains(@href,'SetCloseForum')]");
	public final By ELEMENT_OPEN_FORUM = By.xpath("//a[contains(@href,'SetOpenForum')]");
	
	//Start Topic popup
	public final By ELEMENT_START_TOPIC_POPUP_TITLE = By.xpath(".//*[@id='UIForumPopupWindow']//span[@class='PopupTitle popupTitle']");
	public final By ELEMENT_START_TOPIC_POPUP_TITLE_FILED = By.id("ThreadTitle");
	public final By ELEMENT_START_TOPIC_MESSAGE_FRAME_CKEDITOR = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
	public final By ELEMENT_START_TOPIC_ATTACH_FILE =By.xpath("//*[@id='ThreadContent']//*[@class='uiIconAttach uiIconLightGray']");
	public final String ELEMENT_SELECT_TOPIC = "//*[contains(text(),'{$topic}')]";

	
	//reply on topic
	public final By ELEMENT_TOPIC_REPLY = By.xpath("//*[@class='pull-left actionContainer']//*[@class='uiPostReplyIcon btn btn-primary']");
	public final By ELEMENT_TOPIC_REPLY_TITLE = By.xpath("//*[@id='PostTitle']");
	
	//Upload file popup
	public final By ELEMENT_UPLOAD_POPUP_FILE = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Attach File']");
	public final By ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_INPUT = By.name("file");
	public final By ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_SAVE_BUTTON = By.xpath(".//*[@id='UIAttachFileForm']//button[text()='Save']");
	public final String ELEMENT_UPLOAD_POPUP_NAMEFILE = "//*[@class='fileNameLabel' and contains(text(),'${fileName}')]";

	//administration
	public final By ELEMENT_ACTIONBAR_ADMIN_BANIP = By.xpath("//*[@class='uiIconForumBanIp']");
	public final By ELEMENT_ACTIONBAR_ADMIN_BBCODE = By.xpath("//*[@class='uiIconForumBBCode']");
	public final By ELEMENT_ACTIONBAR_ADMIN_IMPORT = By.xpath(".//*[@id='Administrations']//a[contains(.,'Import')]");
	public final By ELEMENT_ACTIONBAR_ADMIN_EXPORT = By.xpath(".//*[@id='Administrations']//a[contains(.,'Export')]");
	
	//export category
	public final By ELEMENT_EXPORTCAT_EXPORTALL = By.xpath("//*[@id='checkAll']");
	public final String ELEMENT_EXPORTCAT_EXPORT = "//*[contains(text(),'${title}')]/..//*[@class='uiCheckbox']//*[@class='checkbox']";
	
	// add BBCODE
	public final By ELEMENT_ADMIN_BBCODE_ADDBBCODE = By.xpath("//*[text()='Add BBCode']");
	public final By ELEMENT_BBCODE_ADDBBCODEFORM_TAG = By.xpath("//*[@id='TagName']");
	public final By ELEMENT_BBCODE_ADDBBCODEFORM_REPLACEMENT = By.xpath("//*[@id='Replacement']");
	public final By ELEMENT_BBCODE_ADDBBCODEFORM_DESCRIPTION = By.xpath("//*[@id='Description']");
	public final By ELEMENT_BBCODE_ADDBBCODEFORM_EXAMPLE = By.xpath("//*[@id='Example']");
	public final String ELEMENT_BBCODE_EDITBBCODE = "//*[contains(text(),'${tag}')]/../..//*[ @class='uiIconEdit uiIconLightGray']";
	public final String ELEMENT_BBCODE_DELETEBBCODE = "//*[contains(text(),'${tag}')]/../..//*[ @class='uiIconDelete uiIconLightGray']";

	//Breadcumb
	public By ELEMENT_CATEGORY_BREADCUMB_HOME=By.xpath("//*[@id='UIBreadcumbs']//*[text()='Home']");
	public String ELEMENT_CATEGORY_FORUM_BREAD = "//*[text()='${category}']/../..//*[text()='${forum}']";

	
	//Contextmenu by right clicking
	public final By ELEMENT_WATCH = By.xpath("//*[@class='actionIcon' and contains(@href, 'AddWatching')]");
	public final By ELEMENT_UNWATCH = By.xpath("//*[@class='actionIcon' and contains(@href, 'UnWatch')]");
	
	//Message and popup inform
	public final String MESSAGE_WATCH = "You are now watching this item.";
	public final By ELEMENT_OK_INFOR_POPUP = By.xpath("//div[@class='UIPopupWindow UIDragObject uiPopup']/.//a[text()='OK']");
	public final String MESSAGE_UNWATCH = "You are no longer watching this item.";	
	//Bookmark
	public final String ELEMENT_FORUM_BOOKMARK_NAME = "//*[@class='uiShowBookMarkForm resizable']//*[text()='${name}']";
	public final String ELEMENT_FORUM_BOOKMARK_DELETE="//*[@class='uiShowBookMarkForm resizable']//*[text()='${name}']/../..//*[@class='uiIconDelete uiIconLightGray']";
	public final By ELEMENT_FORUM_BOOKMARK_CLOSE_ICON = By.xpath(".//*[@id='UIForumPopupWindow']//div[@class='ClosePopup']");
	
	//Category right click option
	//public final By ELEMENT_FORUM_CATEGORY_BOOKMARK = By.xpath("//*[@id='UIPopupMenu1']//*[@class='uiIconBookmark uiIconLightGray']");
	public final String ELEMENT_FORUM_CONTEXT_MENU_BOOKMARK=".//a[contains(text(),'${name}')]/..//a[contains(.,'Bookmarks')]";
	
	//Forum/Category portlets
	public By ELEMENT_FORUM_PORTLET = By.id("UIForumPortlet");
	public final String ELEMENT_PORTLET_CONTENT_LINK=".//*[contains(text(),'${topic}')]";
	
	//Topic 
	public final String ELEMENT_TOPIC_REPPLY_CONTENT=".//*[contains(text(),'${content}')]";
	public final String ELEMENT_TOPIC_LAST_REPLY = ".//*[contains(text(),'${reply}')]/../../../../following::div[7][@class='uiBox forumQuickReply uiCollapExpand']";
    public final By ELEMENT_TOPIC_POST_REPLY_BOTTOM= By.xpath(".//*[@id='UITopicDetail']/div[5]//a[text()='Post Reply']");
	
    //New post popup
    public final By ELEMENT_TOPIC_NEW_POST_TITLE= By.xpath(".//*[@id='UIForumPopupWindow']//span[text()='New Post']");
    public final By ELEMENT_TOPIC_NEW_POST_TITLE_FIELD=By.id("PostTitle");
    
    //Button
	public final By ELEMENT_OK_BTN = By.xpath("//*[@class='btn actionOK']");
	public final String ELEMENT_BBCODE_TAG_VERIFY = "//*[contains(text(),'${tag}')]";
	public final By ELEMENT_BBCODE_USE_OPTION =By.xpath("//*[@id='UseOption']");
	public final By ELEMENT_BBCODE_CONFIRM_DELETETAG = By.xpath("//*[text()='Are you sure you want to delete this BB Code ?']/../../..//*[@class='btn actionOK']");
	

	//Settings 
	public final By ELEMENT_FORUM_SETTINGS_FORUMSETTINGS = By.xpath("//*[text()='Forum Settings']");
	public final By ELEMENT_FORUM_SETTINGS_MYSUSCRIB = By.xpath("//*[text()='My Subscriptions']");
	public final By ELEMENT_FORUM_SETTINGS_SCREENNAME = By.xpath("//*[@id='ScreenName']");
	public final By ELEMENT_FORUM_SETTINGS_MAXTHREADS = By.xpath("//*[@name='MaximumThreads']");
	public final By ELEMENT_FORUM_SETTINGS_EMAILADRESS = By.xpath("//*[@id='EmailAddress']");
	public final By ELEMENT_FORUM_SETTINGS_UPDATE = By.xpath("//*[text()='Update']");
	public final By ELEMENT_FORUM_SETTINGS_SAVE = By.xpath("//*[text()='Save']");
	public final By ELEMENT_FORUM_SETTINGS_SUBMIT = By.xpath("//*[text()='Submit']");
	public final By ELEMENT_FORUM_USERS_FORUMSETTINGS = By.xpath("//*[@data-target='#ForumUserOption-tab']");
	public final By ELEMENT_FORUM_USERS_BAN = By.xpath("//*[text()='Ban User']");
	public final By ELEMENT_FORUM_USERS_TOPICS = By.xpath("//*[text()='Topics']");
	public final By ELEMENT_FORUM_USERS_POSTS = By.xpath("//*[text()='Posts']");
	public final By ELEMENT_FORUM_CLOSEBTN = By.xpath("//*[@class='btn' and text()='Close']");
	public final String ELEMENT_FORUM_VERIFY_USER = "//*[text()='${user}']";
	
	//forum & category
	public final String ELEMENT_FORUM_TITLECAT = "//*[text()='${title}']";
	
	//add category
	public final By ELEMENT_FORUM_CATEGORY_NAME = By.xpath("//*[@id='CategoryTitle']");
	
	//add forum
	public final By ELEMENT_FORUM_FORUM_NAME = By.xpath("//*[@id='ForumTitle']");
	
	//users
	public final String ELEMENT_FORUM_USERS_EDIT = "//*[text()='${name}']/..//*[@class='uiIconEdit uiIconLightGray']";
	public final By ELEMENT_FORUM_USERS_POPUP_SEARCH_FIELD=By.xpath(".//*[@id='SearchUser']");
	public final By ELEMENT_FORUM_ADDTOPIC = By.xpath("//*[@id='UITopicContainer']/div[2]//*[@class='uiIconForumCreateTopic uiIconForumWhite']");
	public final By ELEMENT_FORUM_ADDPOST = By.xpath("//*[@class='pull-left actionContainer']//*[@class='uiPostReplyIcon btn btn-primary']");
	public final By ELEMENT_FORUM_MESSAGE = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
	public final By ELEMENT_FORUM_GOTOTOPIC = By.xpath("//*[@id='UIContextPopupMenu1']");
	public final By ELEMENT_FORUM_POST_TITLE = By.xpath("//*[@id='PostTitle']");
	public final By ELEMENT_FORUM_TOPIC_TITLE = By.xpath("//*[@id='ThreadTitle']");
	
	//search
	public final By ELEMENT_SEARCH_TEXTBOX = By.xpath("//*[@id='inputValue']");
	public final By ELEMENT_SEARCH__ADVANCEDSEARCH_TEXTBOX = By.xpath("//*[@id='SearchValue']");
	public final String ELEMENT_SEARCH_FORUM_POST = "//*[text()='Post']/../..//*[text()='${name}']";
	public final String ELEMENT_SEARCH_FORUM_TOPIC = "//*[text()='Topic']/../..//*[text()='${name}']";
	public final String ELEMENT_SEARCH_FORUM_FORUM = "//*[text()='Forum']/../..//*[text()='${name}']";
	public final String ELEMENT_SEARCH_FORUM_CATEGORY = "//*[text()='Category']/../..//*[text()='${name}']";
	public final By ELEMENT_SEARCH_FORUM_ADVANCEDSEARCH = By.xpath("//*[text()='Advanced Search']");
	public final By ELEMENT_SEARCH_FORUM_ADVANCEDSEARCH_SEARCHLOCATION = By.xpath("//*[@name='SearchType']");
	public final By ELEMENT_SEARCH_FORUM_ADVANCEDSEARCH_SEARCH = By.xpath("//*[@class='btn' and text()='Search']");

	public final By ELEMENT_DELETE_ICON = By.xpath("//*[@class='uiIconDelete uiIconLightGray']");
	public final By ELEMENT_SAVE_BTN = By.xpath("//*[text()='Save']");
	
	PlatformPermission per;
	ManageAlert alert;
	Button button;
	
	/**
	 * constructor
	 * @param dr
	 */
	public ForumHomePage(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
	}
	/**
	 * Go to home category
	 */
	public void goToHomeCategory(){
		if(waitForAndGetElement(ELEMENT_CATEGORY_BREADCUMB_HOME,5000,0)!=null){
			info("Go to home category");
			click(ELEMENT_CATEGORY_BREADCUMB_HOME);
		}
		waitForElementNotPresent(ELEMENT_CATEGORY_BREADCUMB_HOME);
	}
	

	/**
	 * Add a new category By QuynhPT
	 * @param nameCat
	 *            the title of category
	 * @param order
	 *            the order's number as:0,1,2,3...(0 is default value)
	 * @param description
	 *            the content of description for category
	 */
	public void addCategory(String nameCat, String order, String description) {
		waitForAndGetElement(ELEMENT_ACTIONBAR_ADDCATEGORY);
		info("click on Add Category button");
		click(ELEMENT_ACTIONBAR_ADDCATEGORY);
	    info("input the title for the category");
	    type(ELEMENT_ADDCATEGORY_POPUP_TITLE,nameCat,true);
	    info("check and input Oder field");
	    if(!order.isEmpty()){
	    	 info("Clear all old order data");
	    	 waitForAndGetElement(ELEMENT_ADDCATEGORY_POPUP_ORDER).clear();
	    	 info("Input new order");
	    	 type(ELEMENT_ADDCATEGORY_POPUP_ORDER,order,true);
	    }
        info("check and input description");
	    if (!description.isEmpty()){
	    	info("Clear all old description data");
	    	waitForAndGetElement(ELEMENT_ADDCATEGORY_POPUP_DESCRIPTION).clear();
	    	info("Input new description data");
	    	type(ELEMENT_ADDCATEGORY_POPUP_DESCRIPTION,description,true);
	    }
	    Utils.pause(2000);
	}
	
	/**
	 * Save and close changes of the Add category popup
	 * By QuynhPT
	 */
	public void saveChangesAddCategory(){
		info("Wait Save button is shown");
		waitForAndGetElement(ELEMENT_ADDCATEGORY_POPUP_SAVE_BUTTON);
		info("Click on Save button");
		click(ELEMENT_ADDCATEGORY_POPUP_SAVE_BUTTON);
		Utils.pause(2000);
		 info("Fisnihed adding a category");
	}
	/**
	 * Cancel all changes of Add Category
	 * By QuynhPT
	 */
	public void cancelChangeAddCategory(){
		waitForAndGetElement(ELEMENT_ADDCATEGORY_POPUP_CANCEL_BUTTON);
		click(ELEMENT_ADDCATEGORY_POPUP_CANCEL_BUTTON);
		Utils.pause(2000);
	}
    /**
     * Add a new forum
     * By QuynhPT
     * @param nameForum
     * @param order
     * @param description
     */
	public void addForum(String nameForum, String order, String description) {
		// TODO Auto-generated method stub
		waitForAndGetElement(ELEMENT_ACTIONBAR_ADDFORUM);
		info("click on Add forum button");
		click(ELEMENT_ACTIONBAR_ADDFORUM);
	    info("input the title for the forum");
	    type(ELEMENT_ADDFORUM_POPUP_TITLE,nameForum,true);
	    
	    info("check and input Oder field");
	    if(!order.isEmpty()){
	    	info("Clear all old order data");
	    	waitForAndGetElement(ELEMENT_ADDFORUM_POPUP_ORDER).clear();
	    	info("Input new order data");
	    	type(ELEMENT_ADDFORUM_POPUP_ORDER,order,true);
	    }
        info("check and input description");
	    if (!description.isEmpty()){
	    	info("Clear all old description data");
	    	waitForAndGetElement(ELEMENT_ADDFORUM_POPUP_DESCRIPTION).clear();
	    	info("Input new description data");
	    	type(ELEMENT_ADDFORUM_POPUP_DESCRIPTION,description,true);
	    }
	    Utils.pause(2000);
	    info("Finish inputing data to forum form");
	}
	
	/**
	 * Save and close changes of the Add forum popup
	 * By QuynhPT
	 */
	public void saveChangesAddForum(){
		info("Wait Save button is shown");
		waitForAndGetElement(ELEMENT_ADDFORUM_POPUP_SAVE_BUTTON);
		info("Click on Save button");
		click(ELEMENT_ADDFORUM_POPUP_SAVE_BUTTON);
		Utils.pause(2000);
		info("Finish adding new forum");
	}
	/**
	 * Cancel all changes of Add FORUM
	 * By QuynhPT
	 */
	public void cancelChangeAddForum(){
		waitForAndGetElement(ELEMENT_ADDFORUM_POPUP_CANCEL_BUTTON);
		click(ELEMENT_ADDFORUM_POPUP_CANCEL_BUTTON);
		Utils.pause(2000);
	}
	
	/**
	 * list sublinks in Manage Cagegory menu
	 * @author quynhpt
	 *
	 */
	public enum specifManageCategoryMenu{
		EDIT_CATEGORY,EXPORT_FORUM,IMPORT_FORUM,DELETE,WATCHES,
		ADD_FORUM,EDIT_FORUM,LOCK,UNLOCK,OPEN,CLOSE,MOVE,REMOVE;
	}
	/**
	 * Open Manage Category menu
	 * By QuynhPT
	 */
	public void openManageCategoryMenu(){
		info("Waiting manage menu is shown");
		waitForAndGetElement(ELEMENT_MANAGE_CATEGORY);
		info("Click on Manage menu");
		click(ELEMENT_MANAGE_CATEGORY);
		Utils.pause(1000);
	}
    /**
     * select a item in Manage Category Menu
     * By QuynhPT
     * @param item
     */
	public void selectItemManageCategoryMenu(specifManageCategoryMenu item) {
		openManageCategoryMenu();
		switch (item) {
		case EDIT_CATEGORY:
			info("click on Edit link");
			click(ELEMENT_ACTIONBAR_MANAGECAT_EDIT);
			Utils.pause(1000);
			break;
		case EXPORT_FORUM:
			info("Click on Export link");
			click(ELEMENT_ACTIONBAR_MANAGECAT_EXPORTFORUM);
			Utils.pause(1000);
			break;
		case IMPORT_FORUM:
			info("Click on Import link");
			click(ELEMENT_ACTIONBAR_MANAGECAT_IMPORTFORUM);
			Utils.pause(1000);
			break;
		case DELETE:
			info("Click on Delete link");
			click(ELEMENT_DELETE_CATEGORY);
			Utils.pause(1000);
			alert.waitForMessage("Are you sure you want to delete this category?");
			click(ELEMENT_OK_DELETE);
			break;
		case WATCHES:
			break;
		case ADD_FORUM:
			break;
		case EDIT_FORUM:
			break;
		case LOCK:
			break;
		case UNLOCK:
			break;
		case CLOSE:
			break;
		case OPEN:
			break;
		case MOVE:
			break;
		case REMOVE:
			break;
		}
	}
    
	/**
	 * list sublinks in More Action menu of Forum
	 * @author quynhpt
	 *
	 */
	public enum specifMoreActionMenu{
		START_TOPIC,EDIT,LOCK,UNLOCK,CLOSE,OPEN,MOVE,DELETE,EXPORT_FORUM,WATCHES,BANNED_IPS;
	}
	/**
	 * Open More Action menu
	 * By QuynhPT
	 */
	public void openMoreActionMenu(){
		info("Wait More link is shown");
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		info("Click on More link");
		click(ELEMENT_MORE_ACTION);
	}
	/**
	 * select a item in More Action menu
	 * By QuynhPT
	 * @param item
	 */
    public void selectItemMoreActionMenu(specifMoreActionMenu item){
    	openMoreActionMenu();
    	info("Select a link on More menu");
    	switch(item) {
		case START_TOPIC:
			info("wait Start Topic button is shown");
			waitForAndGetElement(ELEMENT_START_TOPIC_BUTTON);
			info("click on Start Topic button");
			click(ELEMENT_START_TOPIC_BUTTON);
			info("Verify that the popup is shown");
			waitForAndGetElement(ELEMENT_START_TOPIC_POPUP_TITLE);
			info("The popup is shown successfully");
			break;
		case EDIT:
			info("click on Edit link");
			click(ELEMENT_EDIT_FORUM);
			info("Verify that Edit popup is shown");
			waitForAndGetElement(ELEMENT_POPUP_ADD_FORUM);
			info("The popup is shown successfully");
			break;
		case DELETE:
			info("click on Delete link");
			click(ELEMENT_DELETE_FORUM);
			Utils.pause(1000);
			info("Verify that Confirm popup is shown");
			alert.waitForMessage("Are you sure you want to delete this forum ?");
			info("Click on OK button of Confirm popup");
			click(ELEMENT_OK_DELETE);
			info("Finish deleting the forum");
			break;
		case WATCHES:
			break;
		case LOCK:
			click(ELEMENT_LOCK_FORUM);
			break;
		case UNLOCK:
			click(ELEMENT_UNLOCK_FORUM);
			break;
		case CLOSE:
			click(ELEMENT_CLOSE_FORUM);
			break;
		case OPEN:
			click(ELEMENT_OPEN_FORUM);
			break;
		case EXPORT_FORUM:
			break;
		case MOVE:
			info("Wait Move link is shown");
			waitForAndGetElement(ELEMENT_MOVE_FORUM);
			info("Click on Move link");
			click(ELEMENT_MOVE_FORUM);
			info("Verify that Move popup is shown");
			waitForAndGetElement(ELEMENT_POPUP_MOVE_FORUM);
			info("The popup is shown successfully");
			break;
		case BANNED_IPS:
			break;
		default:
			break;
		}
	}
    
    /**
     * Delete Category 
     * By QuynhPT
     * @param nameCat
     */
	public void deleteCategory(String nameCat) {
		// TODO Auto-generated method stub
		info("Wait the category is shown");
		waitForAndGetElement(ELEMENT_FORUM_DETAIL_CATEGORY_NAME_LINK.replace("${name}", nameCat));
		info("Click on the category");
		click(ELEMENT_FORUM_DETAIL_CATEGORY_NAME_LINK.replace("${name}", nameCat));
		info("Select Delete link");
		selectItemManageCategoryMenu(specifManageCategoryMenu.DELETE);
		info("Verify that the category is deleted");
		waitForElementNotPresent(ELEMENT_FORUM_DETAIL_CATEGORY_NAME_LINK.replace("${name}", nameCat));
		info("The category is deleted successfully");
	}
	
   /**
    * Edit a category	
    * @param nameCat
    */
   public void editCategory(String newName){
	   /* info("Click on manage category menu");
		click(ELEMENT_ACTIONBAR_MANAGECAT);*/
		//info("Click edit link");
		//click(ELEMENT_ACTIONBAR_MANAGECAT_EDIT);
		selectItemManageCategoryMenu(specifManageCategoryMenu.EDIT_CATEGORY);
		info("Imput a new name");
		type(ELEMENT_ADDCATEGORY_POPUP_TITLE,newName,true);
		info("Save all changes");
		click(ELEMENT_ADDCATEGORY_POPUP_SAVE_BUTTON);
		info("Verify that the name is changed with new name");
		waitForAndGetElement(ELEMENT_FORUM_TITLE_LINK.replace("${name}", newName));
   }
   /**
    * Export a forum
    * @param name
    */
   public void exportForum(String name){
	   selectItemManageCategoryMenu(specifManageCategoryMenu.EXPORT_FORUM);
	   uncheck(ELEMENT_EXPORTCAT_EXPORTALL, 2);
	   check((ELEMENT_EXPORTCAT_EXPORT).replace("${title}",name), 2);
	   click(ELEMENT_SAVE_BTN);
   }
   
   /**
    * Import a forum
    * @param folderDowloadFile
    * @param nameFile
    */
   public void importForum(String folderDowloadFile,String nameFile){
	   selectItemManageCategoryMenu(specifManageCategoryMenu.IMPORT_FORUM);
		importCat(folderDowloadFile,nameFile);
		
   }
	/**
	 * Go to a detail forum in list
	 * By QuynhPT
	 */
	public void goToDetailForum(String name){
		goToHomeCategory();
		click(ELEMENT_FORUM_DETAIL_FORUM_NAME_LINK.replace("${name}", name));
		waitForAndGetElement(ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}", name));
	}
	/**
	 * Go to a detail category in list
	 * By QuynhPT
	 * @param name
	 */
	public void goToCategory(String name){
		goToHomeCategory();
		click(ELEMENT_FORUM_DETAIL_FORUM_NAME_LINK.replace("${name}", name));
	}
	/**
	 * Delete a forum in the list
	 * By QuynhPT
	 * @param name
	 */
	public void deleteForum(String name){
		goToDetailForum(name);
		selectItemMoreActionMenu(specifMoreActionMenu.DELETE);
		waitForElementNotPresent(ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}", name));
	}
    /**
     * Edit a forum
     * By QuynhPT
     * @param newNameForum
     * @param order
     * @param newDescription
     */
	public void editForum(String newName, String order,String newDescription) {
		// TODO Auto-generated method stub
		selectItemMoreActionMenu(specifMoreActionMenu.EDIT);
        info("Input a new title");
		type(ELEMENT_ADDFORUM_POPUP_TITLE,newName,true);
		info("check and input Oder field");
		if (!order.isEmpty())
			type(ELEMENT_ADDFORUM_POPUP_ORDER,order,true);
		info("check and input description");
		if (!newDescription.isEmpty())
			type(ELEMENT_ADDFORUM_POPUP_DESCRIPTION,newDescription,true);
		Utils.pause(2000);

	}
	
	/**
	 * function: move a forum from a category to another category
	 * Update QuynhPT
	 * @param forum: title of forum that needs to move
	 * @param destination: title of destination category
	 */
	public void moveForum(String forum, String destination){
		info("move forum to category " + destination);
		selectItemMoreActionMenu(specifMoreActionMenu.MOVE);
		click(By.linkText(destination));
		waitForElementNotPresent(ELEMENT_POPUP_MOVE_FORUM);
		goToCategory(destination);
		waitForAndGetElement(ELEMENT_FORUM_DETAIL_FORUM_NAME_LINK.replace("${name}", forum));
		info("Move forum successfully");
	}
	/**
	 * Watch or UnWatch 
	 * true is for watching
	 * false is for un-watching
	 * Update QuynhPT
	 * @param watch
	 */
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
    /**
     * Open Start Topic popup
     * By QuynhPT
     */
	public void goToStartTopic(){
		info("Go to start topic from more action");
		selectItemMoreActionMenu(specifMoreActionMenu.START_TOPIC);
	}
	/**
	 * Start a Topic
	 * By QuynhPT
	 * @param title
	 * @param message
	 */
	public void startTopic(String title, String message,String pathFile,String fileName) {
		info("Verify that the pop up is shown");
		waitForAndGetElement(ELEMENT_START_TOPIC_POPUP_TITLE_FILED);
		info("Refresh the page");
		this.driver.navigate().refresh();
		if(!title.isEmpty()){
			info("Input the title:"+title);
			type(ELEMENT_START_TOPIC_POPUP_TITLE_FILED, title, true);
		}
		
		if (!message.isEmpty()){
			info("Input the message:"+message);
			inputFrame(ELEMENT_START_TOPIC_MESSAGE_FRAME_CKEDITOR,message);
		}
		
		if (!pathFile.isEmpty()|| !fileName.isEmpty()) {
			info("click on Attached file button");
			click(ELEMENT_START_TOPIC_ATTACH_FILE);
			info("Verify that upload button is shown");
			waitForAndGetElement(ELEMENT_UPLOAD_POPUP_FILE);
			info("Attached file");
			attachFile(pathFile,fileName);
			info("Verify that upload popup is closed");
			waitForElementNotPresent(ELEMENT_UPLOAD_POPUP_FILE);
		}
		info("click on Submit button");
		click(ELEMENT_SUBMIT_BUTTON);
		info("Verify that the topic is created");
		waitForAndGetElement(By.linkText(title));
		info("Start topic successfully");
	}
	/**
	 * Open a forum
	 * @param name
	 */
	public void goToForum(String name){
		info("Click on the forum with the name:"+name);
		click(ELEMENT_SELECT_FORUM_TOPIC.replace("${link}",name));
		Utils.pause(2000);
	}
	
	/**
	 * Attach file in attach popup
	 * @author lientm 
	 * Update QuynhPT
	 * @param number
	 *            : number of upload container that need upload file
	 * @param filePath
	 *            : path to file upload
	 */
	public void attachFile(String pathFile, String fileName) {
        info("Attach a file");
		WebElement element = waitForAndGetElement(ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_INPUT, DEFAULT_TIMEOUT, 1,2);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", element);
		info("Get the file to attach");
		element.sendKeys(Utils.getAbsoluteFilePath(pathFile+fileName));
		info("Verify that the file is attached");
		waitForAndGetElement(ELEMENT_UPLOAD_POPUP_NAMEFILE.replace("${fileName}", fileName));
		info("The file is attached successfully");
		info("Click on Save button");
		click(ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_SAVE_BUTTON);
		Utils.pause(2000);
	}
    /**
     * Lock or Unlock a forum
     * By QuynhPT
     * @param islock =true if a forum is locked
     *               =false if a forum is unlocked
     */
	public void lockAndUnlock(boolean islock){
		if (islock) {
			selectItemMoreActionMenu(specifMoreActionMenu.LOCK);
			waitForAndGetElement(ELEMENT_FORUM_START_TOPIC_DISABLE);
		}else {
			selectItemMoreActionMenu(specifMoreActionMenu.UNLOCK);
			waitForAndGetElement(ELEMENT_FORUM_START_TOPIC_BUTTON);
		}
	}
	
	 /**
     * Open or Close a forum
     * By QuynhPT
     * @param isClose =true if a forum is closed
     *               =false if a forum is opened
     */
	public void closeAndOpen(boolean isClose){
		if (isClose) {
			selectItemMoreActionMenu(specifMoreActionMenu.CLOSE);
			waitForAndGetElement(ELEMENT_FORUM_START_TOPIC_DISABLE);
		}else {
			selectItemMoreActionMenu(specifMoreActionMenu.OPEN);
			waitForAndGetElement(ELEMENT_FORUM_START_TOPIC_BUTTON);
		}
	}
	/**
	 * Reply the topic
	 * @param newTitle
	 * @param newMessg
	 * @param pathFile
	 * @param fileName
	 */
	public void replyTopic(String newTitle,String newMessg,String pathFile,String fileName){
		info("Click on Post Reply button"); 
		click(ELEMENT_TOPIC_POST_REPLY_BOTTOM);
		info("Verify that the pop up is shown");
		waitForAndGetElement(ELEMENT_TOPIC_NEW_POST_TITLE);
		info("Refresh the page");
		this.driver.navigate().refresh();
		if(!newTitle.isEmpty()){
			info("Input the title:"+newTitle);
			waitForAndGetElement(ELEMENT_TOPIC_NEW_POST_TITLE_FIELD).clear();
			type(ELEMENT_TOPIC_NEW_POST_TITLE_FIELD,newTitle, true);
		}
		
		if (!newMessg.isEmpty()){
			info("Input the message:"+newMessg);
			inputFrame(ELEMENT_START_TOPIC_MESSAGE_FRAME_CKEDITOR,newMessg);
		}
		
		if (!pathFile.isEmpty()|| !fileName.isEmpty()) {
			info("click on Attached file button");
			click(ELEMENT_START_TOPIC_ATTACH_FILE);
			info("Verify that upload button is shown");
			waitForAndGetElement(ELEMENT_UPLOAD_POPUP_FILE);
			info("Attached file");
			attachFile(pathFile,fileName);
			info("Verify that upload popup is closed");
			waitForElementNotPresent(ELEMENT_UPLOAD_POPUP_FILE);
		}
		info("click on Submit button");
		click(ELEMENT_SUBMIT_BUTTON);
		info("Verify that the replying is created");
		waitForAndGetElement(ELEMENT_TOPIC_REPPLY_CONTENT.replace("${content}", newMessg));
		info("Reply topic successfully");
	}
	
	/**
	 * Add a BBcode
	 * Update QuynhPT
	 * @param tag
	 * @param replacement
	 * @param description
	 * @param example
	 * @param use
	 *<li> add a java doc </li>
	 */
	public void AddBBCode(String tag, String replacement, String description, String example, boolean use ) {
		info("Click on Add button of Add BBCode popup");
		click(ELEMENT_ADMIN_BBCODE_ADDBBCODE);
		info("Input new tag");
		type(ELEMENT_BBCODE_ADDBBCODEFORM_TAG , tag, true);
		info("Input new replacement");
		type(ELEMENT_BBCODE_ADDBBCODEFORM_REPLACEMENT , replacement, true);
		info("Input new description");
		type(ELEMENT_BBCODE_ADDBBCODEFORM_DESCRIPTION , description, true);
		info("Input new example");
		type(ELEMENT_BBCODE_ADDBBCODEFORM_EXAMPLE , example, true);
		if(use==true)
			check(ELEMENT_BBCODE_USE_OPTION);
	}
	
	/**
	 * addCategorySimple
	 * @param name
	 * 
	 */
	public void addCategorySimple(String name) {
		click(ELEMENT_ACTIONBAR_ADDCATEGORY);
		type(ELEMENT_FORUM_CATEGORY_NAME, name, true);
		click(ELEMENT_FORUM_SETTINGS_SAVE);
	}
	
	/**
	 * addForumSimple
	 * @param name
	 * 
	 */
	public void addForumSimple(String name) {
		click(ELEMENT_ACTIONBAR_ADDFORUM);
		type(ELEMENT_FORUM_FORUM_NAME, name, true);
		click(ELEMENT_FORUM_SETTINGS_SAVE);
	}
	
	/**
	 * addTopicSimple
	 * @param name
	 * @param message
	 * 
	 */
	public void addTopicSimple(String name, String message) {
		click(ELEMENT_FORUM_ADDTOPIC);
		type(ELEMENT_FORUM_TOPIC_TITLE, name, true);
		inputFrame(ELEMENT_FORUM_MESSAGE , message);
		switchToParentWindow();
		click(ELEMENT_FORUM_SETTINGS_SUBMIT);
	}
	
	/**
	 * addPostSimple
	 * @param name
	 * @param message
	 * 
	 */
	public void addPostSimple(String name, String message) {
		click(ELEMENT_FORUM_ADDPOST);
		type(ELEMENT_FORUM_POST_TITLE, name, true);
		inputFrame(ELEMENT_FORUM_MESSAGE , message);
		switchToParentWindow();
		click(ELEMENT_FORUM_SETTINGS_SUBMIT);
	}
	 /** 
	  * Import a Category
	 * @param pathFile
	 * @param fileName
	 */
	public void importCat(String pathFile, String fileName) {
        info("Attach a file");
		WebElement element = waitForAndGetElement(ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_INPUT, DEFAULT_TIMEOUT, 1,2);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", element);
		element.sendKeys(Utils.getAbsoluteFilePath(pathFile+fileName));
		waitForAndGetElement(ELEMENT_UPLOAD_POPUP_NAMEFILE.replace("${fileName}", fileName));
		click(ELEMENT_SAVE_BTN);
		Utils.pause(2000);
	}
	/**
	 * Bookmark a topic, a category and a forum
	 * @param topic
	 */
	public void bookmark(String name){
		info("Right click on the topic");
		rightClickOnElement(ELEMENT_FORUM_TITLE_LINK.replace("${name}", name));
		info("Click on Bookmark link of context menu");
		click(ELEMENT_FORUM_CONTEXT_MENU_BOOKMARK.replace("${name}", name));
		info("Click on Bookmark link on Action bar to open Bookmark popup");
		click(ELEMENT_ACTIONBAR_BOOKMARK);
		info("Verify that the topic is bookmarked");
		waitForAndGetElement(ELEMENT_FORUM_BOOKMARK_NAME.replace("${name}", name));
		info("Delete the bookmark of the topic");
		click(ELEMENT_FORUM_BOOKMARK_DELETE.replace("${name}",name));
		info("Verify that the bookmark is deleted");
		waitForElementNotPresent(ELEMENT_FORUM_BOOKMARK_NAME.replace("${name}", name));
		info("Close the popup");
		click(ELEMENT_FORUM_BOOKMARK_CLOSE_ICON);
	}
	/**
	 * Export a category from Action bar
	 * @param name
	 */
	public void exportCategory(String name){
		info("Waiting the administration menu");
		waitForAndGetElement(ELEMENT_ACTIONBAR_ADMINISTRATION);
		info("Click on administration menu");
		click(ELEMENT_ACTIONBAR_ADMINISTRATION);
		info("Click on Export link");
		click(ELEMENT_ACTIONBAR_ADMIN_EXPORT);
		info("Uncheck all category");
		uncheck(ELEMENT_EXPORTCAT_EXPORTALL, 2);
		info("Select the category:"+name);
		check(ELEMENT_EXPORTCAT_EXPORT.replace("${title}", name), 2);
		info("Save all changes");
		click(ELEMENT_SAVE_BTN);
	}
	
	/**
	 * Open a topic
	 * @param name
	 */
	public void goToTopic(String name){
		info("Click on the topic with the name:"+name);
		click(ELEMENT_SELECT_FORUM_TOPIC.replace("${link}", name));
		Utils.pause(2000);
	}
   /**
    * Go to Private Message
    */
	public void goToPrivateMessage() {
		// TODO Auto-generated method stub
		info("Click on Private Message button");
		click(ELEMENT_ACTIONBAR_PRIVATE_MESSAGE);
		Utils.pause(2000);
	}
	
}
