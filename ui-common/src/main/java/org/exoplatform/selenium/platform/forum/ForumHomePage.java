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
	PlatformPermission per;
	ManageAlert alert;
	Button button;

	//Action bar
	public final By ELEMENT_ACTIONBAR_ADDCATEGORY = By.xpath("//*[@class='uiIconAddCategory uiIconLightGray']");
	public final By ELEMENT_ACTIONBAR_ADDFORUM = By.xpath("//*[@class='uiIconForumCreateForum uiIconForumLightGray']");
	public final By ELEMENT_ACTIONBAR_USER = By.xpath("//*[@class='uiIconUser uiIconLightGray']");
	public final By ELEMENT_ACTIONBAR_ADMINISTRATION = By.xpath("//*[@class='uiIconForumAdmin uiIconForumLightGray']");
	
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
	//Manage Category menu
	public final By ELEMENT_MANAGE_CATEGORY = By.xpath("//*[@class='uiIconForumManageCategory uiIconForumLightGray']");
	public final By ELEMENT_DELETE_CATEGORY = By.xpath("//*[@id='UICategoryConfirm0' and contains(text(),'Delete')]");
	
	//More Action menu
	public final By ELEMENT_MORE_ACTION = By.xpath("//form[@id='UITopicContainer']//*[@data-toggle='dropdown']/*[@class='uiIconSettings uiIconLightGray']");
	public final By ELEMENT_EDIT_FORUM = By.xpath("//*[contains(@href, 'EditForum')]");
	public final By ELEMENT_DELETE_FORUM = By.xpath("//*[contains(@data-action, 'RemoveForum')]");
	public final By ELEMENT_MOVE_FORUM = By.xpath("//*[contains(@href, 'MoveForum')]");
	public final By ELEMENT_START_TOPIC_BUTTON = By.xpath(".//*[@class='uiIconForumCreateTopic']");
	public final By ELEMENT_LOCK_FORUM = By.className("uiIconLockMedium");
	public final By ELEMENT_UNLOCK_FORUM = By.className("uiIconUnlockMedium");
	public final By ELEMENT_CLOSE_FORUM = By.xpath("//a[contains(@href,'SetCloseForum')]");
	public final By ELEMENT_OPEN_FORUM = By.xpath("//a[contains(@href,'SetOpenForum')]");
	
	//Start Topic popup
	public final By ELEMENT_START_TOPIC_POPUP_TITLE = By.xpath(".//*[@id='UIForumPopupWindow']//span[@class='PopupTitle popupTitle']");
	public final By ELEMENT_START_TOPIC_POPUP_TITLE_FILED = By.id("ThreadTitle");
	public final By ELEMENT_START_TOPIC_MESSAGE_FRAME_CKEDITOR = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
	public final By ELEMENT_START_TOPIC_ATTACH_FILE =By.xpath("//*[@id='ThreadContent']/div/div[3]/div/button");
	
	//Upload file popup
	public final By ELEMENT_UPLOAD_POPUP_FILE = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Attach File']");
	public final By ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_INPUT = By.name("file");
	public final By ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_SAVE_BUTTON = By.xpath(".//*[@id='UIAttachFileForm']//button[text()='Save']");
	public final String ELEMENT_UPLOAD_POPUP_NAMEFILE = "//*[@class='fileNameLabel' and contains(text(),'${fileName}')]";
	
	//administration
	public final By ELEMENT_ACTIONBAR_ADMIN_BANIP = By.xpath("//*[@class='uiIconForumBanIp']");
	public final By ELEMENT_ACTIONBAR_ADMIN_BBCODE = By.xpath("//*[@class='uiIconForumBBCode']");
	
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
	public String ELEMENT_CATEGORY_FORUM_BREAD = "//*[text()='${category}']/../../*[text()='${forum}']";
	
	//Contextmenu by right clicking
	public final By ELEMENT_WATCH = By.xpath("//*[@class='actionIcon' and contains(@href, 'AddWatching')]");
	public final By ELEMENT_UNWATCH = By.xpath("//*[@class='actionIcon' and contains(@href, 'UnWatch')]");
	
	//Message and popup inform
	public final String MESSAGE_WATCH = "You are now watching this item.";
	public final By ELEMENT_OK_INFOR_POPUP = By.xpath("//div[@class='UIPopupWindow UIDragObject uiPopup']/.//a[text()='OK']");
	public final String MESSAGE_UNWATCH = "You are no longer watching this item.";	
	
	//Forum portlets
	public By ELEMENT_FORUM_PORTLET = By.id("UIForumPortlet");

	//Button
	public final By ELEMENT_OK_BTN = By.xpath("//*[@class='btn actionOK']");
	
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
		click(ELEMENT_ADMIN_BBCODE_ADDBBCODE);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_TAG , tag, true);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_REPLACEMENT , replacement, true);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_DESCRIPTION , description, true);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_EXAMPLE , example, true);
		if(use==true) {
			check(By.xpath("//*[@id='UseOption']"));
		}
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
		//click on Add Category button
		click(ELEMENT_ACTIONBAR_ADDCATEGORY);
		//check if title is null
	    if(nameCat==null)
	    	assert false:"lack of the values of title";
	    //input the title for the category
	    type(ELEMENT_ADDCATEGORY_POPUP_TITLE,nameCat,true);
	    
	    //check and input Oder field
	    if(order!=null){
	    	waitForAndGetElement(ELEMENT_ADDCATEGORY_POPUP_ORDER).clear();
	    	type(ELEMENT_ADDCATEGORY_POPUP_ORDER,order,true);
	    }
        //check and input description
	    if (description!=null){
	    	waitForAndGetElement(ELEMENT_ADDCATEGORY_POPUP_DESCRIPTION).clear();
	    	type(ELEMENT_ADDCATEGORY_POPUP_DESCRIPTION,description,true);
	    }
	    Utils.pause(2000);	
	}
	
	/**
	 * Save and close changes of the Add category popup
	 * By QuynhPT
	 */
	public void saveChangesAddCategory(){
		waitForAndGetElement(ELEMENT_ADDCATEGORY_POPUP_SAVE_BUTTON);
		click(ELEMENT_ADDCATEGORY_POPUP_SAVE_BUTTON);
		Utils.pause(2000);
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
		//click on Add forum button
		click(ELEMENT_ACTIONBAR_ADDFORUM);
		//check if title is null
	    if(nameForum==null)
	    	assert false:"lack of the values of title";
	    //input the title for the forum
	    type(ELEMENT_ADDFORUM_POPUP_TITLE,nameForum,true);
	    
	    //check and input Oder field
	    if(order!=null){
	    	waitForAndGetElement(ELEMENT_ADDFORUM_POPUP_ORDER).clear();
	    	type(ELEMENT_ADDFORUM_POPUP_ORDER,order,true);
	    }
        //check and input description
	    if (description!=null){
	    	waitForAndGetElement(ELEMENT_ADDFORUM_POPUP_DESCRIPTION).clear();
	    	type(ELEMENT_ADDFORUM_POPUP_DESCRIPTION,description,true);
	    }
	    Utils.pause(2000);	
	}
	
	/**
	 * Save and close changes of the Add forum popup
	 * By QuynhPT
	 */
	public void saveChangesAddForum(){
		waitForAndGetElement(ELEMENT_ADDFORUM_POPUP_SAVE_BUTTON);
		click(ELEMENT_ADDFORUM_POPUP_SAVE_BUTTON);
		Utils.pause(2000);
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
		waitForAndGetElement(ELEMENT_MANAGE_CATEGORY);
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
			break;
		case EXPORT_FORUM:
			break;
		case IMPORT_FORUM:
			break;
		case DELETE:
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
	 * list sublinks in More Action menu
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
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
	}
	/**
	 * select a item in More Action menu
	 * By QuynhPT
	 * @param item
	 */
    public void selectItemMoreActionMenu(specifMoreActionMenu item){
    	openMoreActionMenu();
    	switch(item) {
		case START_TOPIC:
			waitForAndGetElement(ELEMENT_START_TOPIC_BUTTON);
			click(ELEMENT_START_TOPIC_BUTTON);
			waitForAndGetElement(ELEMENT_START_TOPIC_POPUP_TITLE);
			break;
		case EDIT:
			click(ELEMENT_EDIT_FORUM);
			waitForAndGetElement(ELEMENT_POPUP_ADD_FORUM);
			break;
		case DELETE:
			click(ELEMENT_DELETE_FORUM);
			Utils.pause(1000);
			alert.waitForMessage("Are you sure you want to delete this forum ?");
			click(ELEMENT_OK_DELETE);
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
			waitForAndGetElement(ELEMENT_MOVE_FORUM);
			click(ELEMENT_MOVE_FORUM);
			waitForAndGetElement(ELEMENT_POPUP_MOVE_FORUM);
			break;
		case BANNED_IPS:
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
		waitForAndGetElement(ELEMENT_FORUM_DETAIL_CATEGORY_NAME_LINK.replace("${name}", nameCat));
		click(ELEMENT_FORUM_DETAIL_CATEGORY_NAME_LINK.replace("${name}", nameCat));
		selectItemManageCategoryMenu(specifManageCategoryMenu.DELETE);
		waitForElementNotPresent(ELEMENT_FORUM_DETAIL_CATEGORY_NAME_LINK.replace("${name}", nameCat));
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
	public void goToDetailCategory(String name){
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

		if (newName == "" ||newName == null )
			assert false : "lack of the values of title";
		type(ELEMENT_ADDFORUM_POPUP_TITLE,newName,true);
		// check and input Oder field
		if (order != "") {
			type(ELEMENT_ADDFORUM_POPUP_ORDER,order,true);
		}
		// check and input description
		if (newDescription != "") {
			type(ELEMENT_ADDFORUM_POPUP_DESCRIPTION,newDescription,true);
		}
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
		goToDetailCategory(destination);
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
		info("Start a topic");
		goToStartTopic();
		info("Input data in content tab");
		waitForAndGetElement(ELEMENT_START_TOPIC_POPUP_TITLE_FILED);
		
		if(title !="")
			type(ELEMENT_START_TOPIC_POPUP_TITLE_FILED, title, true);
		
		if (message !="")
			inputFrame(ELEMENT_START_TOPIC_MESSAGE_FRAME_CKEDITOR,message);
		
		if (pathFile !="" || fileName !="") {
			click(ELEMENT_START_TOPIC_ATTACH_FILE);
			waitForAndGetElement(ELEMENT_UPLOAD_POPUP_FILE);
			attachFile(pathFile,fileName);
			waitForElementNotPresent(ELEMENT_UPLOAD_POPUP_FILE);
		}
		click(ELEMENT_SUBMIT_BUTTON);
		waitForAndGetElement(By.linkText(title));
		info("Start topic successfully");
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
		element.sendKeys(Utils.getAbsoluteFilePath(pathFile+fileName));
		waitForAndGetElement(ELEMENT_UPLOAD_POPUP_NAMEFILE.replace("${fileName}", fileName));
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
	
}
