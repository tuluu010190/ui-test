package org.exoplatform.selenium.platform.ecms;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SiteExplorerHome extends PlatformBase{

	PlatformPermission per;
	ManageAlert alert;
	Button button;
	CreateNewDocument CreNewDoc;
	public final By ELEMENT_SITEEXPLORER_WORKING_PANEL = By.xpath("//*[@class='navItemSelected' and text()='Content Explorer']");

	//Action Bar
	public final By ELEMENT_ACTIONBAR_ADDDOCUMENT = By.xpath("//*[@class='uiIconEcmsAddDocument uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_ADDFOLDER = By.xpath("//*[@class='uiIconEcmsAddFolder uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_SETTINGS = By.xpath("//*[@class='setupPreferencesButton actionIcon pull-right']");
	public final By ELEMENT_ACTIONBAR_PERMISSION = By.xpath("//*[@class='uiIconEcmsViewPermissions uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_SEARCHBAR = By.xpath("//*[@id='simpleSearch']");
	public final By ELEMENT_ACTIONBAR_MORE = By.xpath("//*[@class='dropdown pull-right listHiddenActionsContainer']/..//*[text()='More ']");
	public final By ELEMENT_ACTIONBAR_METADATA = By.xpath("//*[@class='actionIcon']/..//*[text()=' Metadata']");
	public final By ELEMENT_ACTIONBAR_RELATION = By.xpath(".//i[@class='uiIconEcmsManageRelations uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_IMPORT_BUTTON = By.xpath(".//i[@class='uiIconEcmsImportNode uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_EXPORT_BUTTON= By.xpath(".//*[@class='uiIconEcmsExportNode uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_PROPERTIES = By.xpath(".//i[@class='uiIconEcmsViewProperties uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_MANAGER_PUBLISHTATION =By.xpath(".//i[@class='uiIconEcmsManagePublications uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_ADD_CATEGORY_BUTTON= By.xpath(".//*[@class='uiIconEcmsManageCategories uiIconEcmsLightGray']");
	
	//Add Category popup
	public final By ELEMENT_ADD_CATEGORY_POPUP_SELECT_CATEGORY_TAB = By.xpath(".//*[@id='UICategoryManager']//a[text()='Select Category']");
	public final By ELEMENT_ADD_CATEGORY_POPUP_MENU = By.name("taxonomyTree");
	public final String ELEMENT_ADD_CATEGORY_POPUP_CATEGORY_NAME_LEFT_SIDE=".//*[@id='UIOneTaxonomySelector']//i[@title='${nameTitle}']";
    public final String ELEMENT_ADD_CATEGORY_POPUP_SELECT_CATEGORY_RIGHT_SIDE =".//*[@id='UISelectTaxonomyPanel']//div[contains(.,'${nameCategory}')]//../..//i[@class='uiIconValidate uiIconLightGray']";
	public final By ELEMENT_ADD_CATEGORY_POPUP_CLOSED_BUTTON= By.xpath(".//*[@id='UICategoryManager']//button[text()='Close']");
    public final String ELEMENT_ADD_CATEGORY_POPUP_DELETE_CATEGORY= ".//*[@id='UICategoriesAddedList']//td[contains(.,'${nameCategory}')]/../..//i[@class='uiIconDelete uiIconLightGray']";
    
    //Import Node popup
	public final By ELEMENT_IMPORT_NODE_POPUP_TITLE= By.xpath(".//*[@id='UIPopupWindow']//span[text()='Import']");
	public final By ELEMENT_IMPORT_NODE_POPUP_UPLOAD_BUTTON = By.name("file");
	public final By ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR = By.name("behavior");
	public final By ELEMENT_IMPORT_NODE_POPUP_VERSION_HISTORY_BUTTON = By.xpath("//div[@id='versionHistory']//input[@name='file']");
	public final By ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_CREATE_NEW = By.xpath(".//*[@id='UIImportNode']//option[text()='Create New']");
	public final By ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_REMOVE_EXISTING = By.xpath(".//*[@id='UIImportNode']//option[text()='Remove Existing']");
	public final By ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_REPLACE_EXISTING = By.xpath(".//*[@id='UIImportNode']//option[text()='Replace Existing']");
	public final By ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_THROW_EXCEPTION = By.xpath(".//*[@id='UIImportNode']//option[text()='Throw Exception']");
	public final String ELEMENT_IMPORT_NODE_POPUP_UPLOAD_FILE_LABEL = "//div[@class='fileNameLabel' and contains(text(),'${fileName}')]";
	public final By ELEMENT_IMPORT_MODE_POPUP_IMPORT_BUTTON = By.xpath(".//*[@id='UIImportNode']//button[text()='Import']");
	
	//Export Node popup
	public final By ELEMENT_EXPORT_NODE_POPUP_TITLE= By.xpath(".//*[@id='UIPopupWindow']//span[text()='Export']");
	public final By ELEMENT_EXPORT_NODE_POPUP_DOC_VIEW = By.xpath(".//*[@id='UIExportNode']//input[@value='docview']");
	public final By ELEMENT_EXPORT_NODE_POPUP_SYS_VIEW = By.xpath(".//*[@id='UIExportNode']//input[@value='sysview']");
	public final By ELEMENT_EXPORT_NODE_POPUP_ZIP = By.name("zip");
	public final By ELEMENT_EXPORT_NODE_POPUP_EXPORT_BUTTON = By.xpath("//button[text()='Export']");
	
	//Relation popup
	public final By ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB=By.xpath(".//*[@id='UIRelationManager']//a[text()='Select Relation']");
	public final String ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB_NODE_LEFT_TREE=".//*[@id='UIOneNodePathSelector']//i[@title='${nameNode}']";
	public final String ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB_SELECT_CONTENT_RIGHT_TREE =".//*[@id='UISelectPathPanel']//div[contains(text(),'${nameContent}')]/../..//*[@class='uiIconValidate uiIconLightGray']";
	public final By ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB_CLOSE_BUTTON=By.xpath(".//*[@id='UIRelationManager']//button[text()='Close']");
	public final String ELEMENT_RELATION_POPUP_RELATION_LIST_DELETE_BUTTON=".//*[@id='RelateAddedList']//span[contains(.,'${nameContent}')]/../..//i[@class='uiIconDelete uiIconLightGray']";
	public final String MESSAGE_DELETE_RELATION = "Are you sure you want to delete this relation?";
	
	// View Properties form
	public final By ELEMENT_VIEWPROPERTIES_PROPERTIES_TAB = By.linkText("Properties");
	public final By ELEMENT_VIEWPROPERTIES_ADD_PROPERTY_TAB = By.linkText("Add New Property");
	public final By ELEMENT_VIEWPROPERTIES_VALUE_INPUT = By.xpath("//input[contains(@id,'value')]");
	public final By ELEMENT_VIEWPROPERTIES_ADD_PROPERTY_INPUT = By.name("property_select");
	public final String ELEMENT_VIEWPROPERTIES_PROPERTY = "//td[text()='{$property}']/..//div[contains(text(),'{$value}')]";

	//Manage Publishtation popup
	public final String ELEMENT_MANAGEPUBLICATION_STATE = "//p[contains(text(),'{$state}')]/../a[@class='node']";	
	public final String ELEMENT_MANAGEPUBLICATION_CURRENT_SPECIFIC_STATUS = "//*[@class='currentStatus']/p[contains(text(),'${status}')]";
	public final By ELEMENT_MANAGEPUBLICATION_SCHEDULE_TAB = By.xpath("//a[text()='Scheduled']");	
	public final By ELEMENT_MANAGEPUBLICATION_PUB_FROM_INPUT = By.name("UIPublicationPanelStartDateInput");
	public final By ELEMENT_MANAGEPUBLICATION_PUB_TO_INPUT = By.name("UIPublicationPanelEndDateInput");
	public final String MSG_INVALID_DATE_TIME = "The date format is invalid. Please check again.";
	public final By ELEMENT_MANAGEPUBLICATION_REVISION_TAB = By.linkText("Revision");
	public final By ELEMENT_MANAGEPUBLICATION_HISTORY_TAB = By.linkText("History");
	public final String ELEMENT_MANAGEPUBLICATION_HISTORY_ITEM = "//div[text()='${state}']";
	
	
	//settings driver display
	public final By ELEMENT_DRIVERSETTINGS_SORTBY = By.xpath("//*[@class='selectbox' and @name='sortBy']");
	public final By ELEMENT_DRIVERSETTINGS_ORDER = By.xpath("//*[@class='selectbox' and @name='order']");
	public final By ELEMENT_DRIVERSETTINGS_SAVE = By.xpath("//*[@class='btn btn-primary' and text()='Save']");
	// upload
	public final By ELEMENT_ACTIONBAR_UPLOAD = By.xpath("//*[@class='uiIconEcmsUpload uiIconEcmsLightGray']");
	public final By ELEMENT_MORE_LINK_WITHOUT_BLOCK = By.xpath("//*[@id='uiActionsBarContainer']//*[contains(text(), 'More')]");
	public final By ELEMENT_UPLOAD_LINK = By.id("MultiUploadInputFiles");
	public final By ELEMENT_ACTIONBAR_EDIT = By.xpath("//*[@class='uiIconEcmsEditDocument uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_SHOWDRIVES = By.xpath("//*[@id='driveAction']");

	//Drive selection
	public final String ELEMENT_SELECTDRIVE_SPECIFICDRIVE = "//*[@class='driveLabel' and @data-original-title='${spaceName}']";

	//Add document
	public final By ELEMENT_ADDDOCUMENT_CHOICETYPE = By.xpath("//*[@class='templateTitle']");

	//Add folder
	public final By ELEMENT_ADDFOLDERBOX = By.xpath("//*[@class='PopupTitle popupTitle']");
	public final By ELEMENT_ADDFOLDER_NAME = By.xpath("//*[@id='titleTextBox']");
	public final By ELEMENT_ADDFOLDER_FOLDERTYPE = By.xpath("//*[@class='selectbox']");
	public final By ELEMENT_ADDFOLDER_CREATEFOLDERBUTTON = By.xpath("//*[@class='btn addFolderButton']");

	//Left explorer box
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_INTRANET = By.xpath("//*[@class='uiIcon16x16FolderDefault uiIcon16x16exo_portalFolder' and @title='intranet']");
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_DOCUMENT = By.xpath("//*[@class='uiIcon16x16FolderDefault uiIcon16x16exo_documentFolder' and @title='documents']");
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_SPACE = By.xpath("//*[@class='uiIcon16x16FolderDefault uiIcon16x16exo_portalFolder' and @title='intranet']");
	public final String ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME = "//*[@class='nodeName' and text()='${title}']";
	public final By ELEMENT_SITEEXPLORER_ACTION_DELETE = By.xpath("//*[@class='uiIconEcmsDelete']");
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_SAVEDSEARCH = By.xpath("//*[@class='uiIconEcmsSavedSearchesMini uiIconEcmsLightGray']");
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_ADVANCEDSEARCH = By.xpath("//*[@class='actionIcon advancedSearchIcon pull-right']//*[@class='uiIconSearch uiIconLightGray']");
	public final By ELEMENT_SITEEXPLORER_LIST_LOCK_NODE = By.xpath("//*[@id='ECMContextMenu']//*[@class='uiIconEcmsLock']");
	
	//advanced search 
	public final By ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_NAME = By.xpath("//*[@id='keyword']");
	public final By ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_SEARCHBTN = By.xpath("//*[@id='tab-UIContentNameSearch']//*[@class='btn' and text()='Search']");
	public final By ELEMENT_SITEXPLORER_ADVANCEDSEARCH_CREATEQUERYTAB = By.xpath("//*[text()='New Query']");
	public final By ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_NAMEQUERY = By.xpath("//*[@id='name']");
	public final By ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_SAVEQUERYBTN = By.xpath("//*[@id='UIJCRAdvancedSearch']//*[@class='btn' and text()='Save']");
	public final String ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_DELETEQUERYBTN = "//*[text()='${name}']/../..//*[@class='uiIconDelete uiIconLightGray']";
	public final By ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_EXECUTEQUERYBTN = By.xpath("//*[@class='uiIconEcmsExecute']");
	public final String ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_EDITQUERYBTN = "//*[text()='${name}']/../..//*[@class='uiIconEdit uiIconLightGray']";
	public final By ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_QUERYTYPE = By.xpath("//*[@class='uiForm EditQueryForm']/..//*[@class='selectbox']");
	public final By ELEMENT_SITEEXPLORER_ADVANCEDSEARCH_SAVEEDITQUERYBTN = By.xpath("//*[@id='EditQueryForm']//*[@class='btn' and text()='Save']");
	
	//Confirm delete box
	public final By ELEMENT_SITEEXPLORER_CONFIRMBOX_DELETE= By.xpath("//*[@class='uiAction uiActionBorder']//*[text()='Delete']");

	//upload file form
	public String ELEMENT_ATTACHMENT_FORM_FILE_NAME = "//*[text()='$fileName']";
	public By ELEMENT_EVENT_FILE_INPUT = By.xpath("//*[@id='upload']//*[@name='file']");
	public By ELEMENT_ATTACHMENT_SAVE_BUTTON = By.xpath("//*[@id='UIAttachFileForm']//*[text()='Save']");
	public String ELEMENT_ATTACH_FILE_NAME = "//*[@data-original-title='$fileName']";

	//Permission
	public final By ELEMENT_PERMISSION_USER = By.xpath("//*[@class='uiIconSelectUser uiIconLightGray']");
	public final By ELEMENT_PERMISSION_GROUP = By.xpath("//*[@class='uiIconSelectMember uiIconLightGray']");
	public final By ELEMENT_PERMISSION_ANY = By.xpath("//*[@class='uiIconAddAny uiIconLightGray']");
	public final By ELEMENT_SEARCH_USER_INPUT = By.id("Quick Search");
	public final By ELEMENT_SELECT_SEARCH = By.name("filter");
	public final String ELEMENT_USER_CHECKBOX = "//*[text()='${user}']/../..//*[@type='checkbox']"; 
	public final By ELEMENT_QUICK_SEARCH_BUTTON = By.xpath("//a[@data-original-title='Quick Search']");
	public final By ELEMENT_ADD_USERS_BUTTON = By.xpath("//*[@id='UIUserSelector']//*[text()='Add']");
	
	//sideBar
	public final String ELEMENT_SE_NODE = "//*[@title='{$node}']"; 
	public final By ELEMENT_SIDE_BAR_MAINTAB =By.xpath(".//*[@id='UISideBar']//h6[@class='title']");
	public final By ELEMENT_SIDEBAR_SITES_MANAGEMENT = By.xpath("//*[@data-original-title = 'Sites Management' or @title = 'Sites Management']");
	public final By ELEMENT_SIDE_BAR_RELATION_ICON=By.xpath(".//*[@id='UISideBar']//i[@class='uiIconEcmsRelationMini uiIconEcmsLightGray']");
	public final String ELEMENT_SIDE_BAR_RELATION_TAB_FILE_TITLE=".//*[@id='UISideBar']//a[text()='${nameContent}']";
    public final By ELEMENT_SIDE_BAR_FILE_EXPLORER_ICON=By.xpath(".//*[@id='UISideBar']//i[@class='uiIconEcmsExplorerMini uiIconEcmsLightGray']");
	
	public SiteExplorerHome(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		CreNewDoc = new CreateNewDocument(driver);
		button = new Button(driver);
	}
    /**
     * Open Add a new folder popup
     */
	public void goToAddNewFolder() {
		click(ELEMENT_ACTIONBAR_ADDFOLDER);
		waitForAndGetElement(ELEMENT_ADDFOLDERBOX);
	}
    /**
     * Create a new folder. Input the title and folder type
     * @param title
     * @param folderType
     */
	public void createFolder(String title, String folderType) {
		type(ELEMENT_ADDFOLDER_NAME, title, true);
		select(ELEMENT_ADDFOLDER_FOLDERTYPE, folderType );
		click(ELEMENT_ADDFOLDER_CREATEFOLDERBUTTON);
		waitForAndGetElement(By.xpath((ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", title)));
	}
	
    /**
     * Go to New content page
     */
	public void goToAddNewContent() {
		click(ELEMENT_ACTIONBAR_ADDDOCUMENT);
		waitForAndGetElement(ELEMENT_ADDDOCUMENT_CHOICETYPE);
	}

	
	/**
	 * Delete data by title
	 * @param title
	 */
	public void deleteData(String title) {
		click(ELEMENT_SIDE_BAR_FILE_EXPLORER_ICON);
		Utils.pause(2000);
		rightClickOnElement(By.xpath((ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", title)));
		click(ELEMENT_SITEEXPLORER_ACTION_DELETE);
		click(ELEMENT_SITEEXPLORER_CONFIRMBOX_DELETE);
		waitForElementNotPresent(By.xpath((ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", title)));
	}

	/**
	 * Upload a file
	 * @param link
	 * @param params
	 * @return SiteExplorerHome
	 */
	public SiteExplorerHome uploadFile(String link, Object... params) {
		Boolean verify = (Boolean) (params.length > 0 ? params[0] : true);
		if (waitForAndGetElement(ELEMENT_ACTIONBAR_UPLOAD, DEFAULT_TIMEOUT, 0) == null) {
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
		}
		((JavascriptExecutor) driver)
		.executeScript(
				"arguments[0].style.visibility = 'block'; arguments[0].style.height = '1px'; "
						+ "arguments[0].style.width = '1px'; arguments[0].style.opacity = 1",
						waitForAndGetElement(ELEMENT_UPLOAD_LINK,
								DEFAULT_TIMEOUT, 1, 2));
		Utils.pause(10000);
		type(ELEMENT_UPLOAD_LINK, Utils.getAbsoluteFilePath(link), false, 2);
		info("Upload file " + Utils.getAbsoluteFilePath(link));
		switchToParentWindow();
		if (verify) {
			String links[] = link.split("/");
			int length = links.length;
			Utils.pause(2000);
			waitForAndGetElement(By.xpath("//*[contains(text(),'"+ links[length - 1] + "')]"));
		}
		info("Upload file successfully");
		Utils.pause(2000);
		return new SiteExplorerHome(driver);
	}
    /**
     * Go to Edit page of a document
     */
	public void goToEditDocument() {
		click(ELEMENT_ACTIONBAR_EDIT);
		Utils.pause(3000);
	}

	/**
	 * Edit a Document
	 * @param content
	 */
	public void editDocument(String content) {
		driver.navigate().refresh();

		if(content != ""){	
			inputDataToFrame(CreNewDoc.ELEMENT_FILEFORM_BLANK_CONTENT , content, false);
			switchToParentWindow();
		}
	}
    /**
     * Go to Intranet activity stream
     */
	public void goToIntranet() {
		click(ELEMENT_SITEEXPLORER_LEFTBOX_INTRANET);
	}
    /**
     * Go to Document folder
     */
	public void goToDocument() {
		click(ELEMENT_SITEEXPLORER_LEFTBOX_DOCUMENT);
	}
	/**
	 * Go to Space drive
	 * @param spaceName
	 */
	public void goToSpace(String spaceName) {
		click(ELEMENT_ACTIONBAR_SHOWDRIVES);
		click(By.xpath((ELEMENT_SELECTDRIVE_SPECIFICDRIVE).replace("${spaceName}", spaceName)));
	}
    /**
     * Select Drive by option
     *
     */
	public enum selectDriverOption{
		ALPHABETICAL, TYPE, CREATEDDATE, MODIFIEDDATE
	}
    /**
     * Select Drive by order
     *
     */
	public enum selectDriverOrder{
		ASCENDING, DESCENDING
	}

	/**
	 * Open Setting drive page
	 * @param type
	 * @param order
	 */
	public void openSettingsDriver(selectDriverOption type, selectDriverOrder order) {
		click(ELEMENT_ACTIONBAR_SETTINGS);
		info("Go to type "+ type);
		switch(type){
		case ALPHABETICAL:
			select(ELEMENT_DRIVERSETTINGS_SORTBY, "Alphabetical");
			break;

		case TYPE:
			select(ELEMENT_DRIVERSETTINGS_SORTBY, "Type");
			break;

		case CREATEDDATE:
			select(ELEMENT_DRIVERSETTINGS_SORTBY, "Created Date");
			break;

		case MODIFIEDDATE:
			select(ELEMENT_DRIVERSETTINGS_SORTBY, "Modified Date");
			break;
		}

		info("Go to type "+ order);
		switch(order){
		case ASCENDING:
			select(ELEMENT_DRIVERSETTINGS_ORDER, "Ascending");
			break;

		case DESCENDING:
			select(ELEMENT_DRIVERSETTINGS_ORDER, "Descending");
			break;
		}

		click(ELEMENT_DRIVERSETTINGS_SAVE);
	}

	/**
	 * Go to Permission popup
	 */
	public void goToPermission() {
		click(ELEMENT_ACTIONBAR_MORE);
		click(ELEMENT_ACTIONBAR_PERMISSION);
	}
	/**
	 * Select a node by name
	 * @param nodeName
	 */
	public void selectNode(String nodeName) {
		click(By.xpath((ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", nodeName)));
		Utils.pause(2000);
	}
	/**
	 * Go to Advanced Search page
	 */
	public void goToAdvancedSearch() {
		click(ELEMENT_SITEEXPLORER_LEFTBOX_SAVEDSEARCH);
		Utils.pause(2000);
		click(ELEMENT_SITEEXPLORER_LEFTBOX_ADVANCEDSEARCH);
	}
	/**
	 * Lock a Node
	 * @param name
	 */
	public void lockNode(String name){
		rightClickOnElement(By.xpath(ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME.replace("${title}",name)));
		click(ELEMENT_SITEEXPLORER_LIST_LOCK_NODE);
	}

	
	/**
	 * By QuynhPT
	 * Open Add Relation popup
	 */
	public void goToManageRelation(){
		click(ELEMENT_ACTIONBAR_RELATION);
		Utils.pause(2000);
	}

	/**
	 * By QuynhPT
	 * Add a Relation for many files
	 * @param nameContent  is an array that has the names of contents which will be related
	 * @param arrayPath    is an array of a path where is put the content files
	 */
	public void addRelation(String[] nameContent,String[] arrayPath) {
		for (String arrayElement:nameContent){
			goToPathHasFiles(arrayPath);
			click(ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB_SELECT_CONTENT_RIGHT_TREE
					.replace("${nameContent}",arrayElement));
			Utils.pause(2000);
		}
	}
    /**
     * Open Add Category popup
     * By QuynhPT
     * date 16/01/2015
     */
	public void goToAddCategory(){
		click(ELEMENT_ACTIONBAR_ADD_CATEGORY_BUTTON);
		Utils.pause(2000);
	}
	/**
	 * Add category for a file in SE
	 * By QuynhPT
	 * date 16/01/2015
	 * @param categoryTreeName
	 * @param arrayCatePath
	 * @param nameSelectedCategory
	 */
	public void addCategory(String categoryTreeName,String[] arrayCatePath,String nameSelectedCategory){
		info("select category");
		click(ELEMENT_ADD_CATEGORY_POPUP_SELECT_CATEGORY_TAB);
		Utils.pause(2000);
		select(ELEMENT_ADD_CATEGORY_POPUP_MENU, categoryTreeName);
		Utils.pause(2000);
		for (String cateName : arrayCatePath) {
			click(ELEMENT_ADD_CATEGORY_POPUP_CATEGORY_NAME_LEFT_SIDE.replace("${nameTitle}", cateName));
			Utils.pause(2000);
		}
		
		click(ELEMENT_ADD_CATEGORY_POPUP_SELECT_CATEGORY_RIGHT_SIDE.replace("${nameCategory}",nameSelectedCategory));
		Utils.pause(3000);
	}
	
	/**
	 * Close Add Category popup
	 * By QuynhPT
	 * date 16/01/2015
	 */
	public void closeAddCategoryPopup(){
		click(ELEMENT_ADD_CATEGORY_POPUP_CLOSED_BUTTON);
		Utils.pause(2000);
	}
	/**
	 * By QuynhPT
	 * Go to the path that include content files to create relation
	 * @param arrayPath the path of the folder where is put the content files
	 */
	public void goToPathHasFiles(String[] arrayPath) {
		// Open "Select Relation" tab
		click(ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB);
		Utils.pause(500);
		for (String arrayElement:  arrayPath) {
			click(ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB_NODE_LEFT_TREE
					.replace("${nameNode}", arrayElement));
		}
	}
	/**
	 * By QuynhPT
	 * Close "Add Relation" popup
	 */
	public void closeAddRelationPopup(){
		click(ELEMENT_RELATION_POPUP_SELECT_RELATION_TAB_CLOSE_BUTTON);
		Utils.pause(2000);
	}
	
	/**
	 * By QuynhPT
	 * Open Relation tab on SideBar
	 */
	public void goToRelationSideBar(){
		click(ELEMENT_SIDE_BAR_RELATION_ICON);
		Utils.pause(2000);
	}
	
	/**
	 * Delete Relation
	 * By QuynhPT
	 * @param nameContent
	 */
	public void deleteRelation(String nameContent){
		click(By.xpath(ELEMENT_RELATION_POPUP_RELATION_LIST_DELETE_BUTTON.replace("${nameContent}",nameContent)));
		alert.waitForConfirmation(MESSAGE_DELETE_RELATION);
		alert.acceptAlert();
	}
	/**
	 * Delete a category that is added to the file in SE
	 * By QuynhPT
	 * date 16/01/2015
	 * @param nameCategory
	 */
	public void deleteCategory(String nameCategory){
		click(By.xpath(ELEMENT_ADD_CATEGORY_POPUP_DELETE_CATEGORY.replace("${nameCategory}",nameCategory)));
		alert.acceptAlert();
	}
	
	/**
	 * Go to Import Node popup
	 * By QuynhPT
	 * date 16/01/2015
	 */
	public void goToImportNode(){
		click(ELEMENT_ACTIONBAR_IMPORT_BUTTON);
		Utils.pause(2000);
	}
	
	/**
	 * Open Export Node popup
	 * By QuynhPT
	 * date 16/01/2015
	 */
	public void goToExportNode(){
		click( ELEMENT_ACTIONBAR_EXPORT_BUTTON);
		Utils.pause(2000);
	}
	
	/**
	 * Select a value for behavior
	 * by quynhpt
	 * date 16/01/2015
	 */
	public enum defineValueBehavior{
		CREATE_NEW,REMOVE_EXISTING,REPLACE_EXISTING,THROW_EXEPTION;
	}
	/**
	 * Select a value for behavior
	 * @param value
	 */
	public void selectBehavior(defineValueBehavior value){
		switch(value){
		case CREATE_NEW:
			click(ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_CREATE_NEW);
			break;
		case REMOVE_EXISTING:
			click(ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_REMOVE_EXISTING);
			break;
		case REPLACE_EXISTING:
			click(ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_REPLACE_EXISTING);
			break;
		case THROW_EXEPTION:
			click(ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR_THROW_EXCEPTION);
			break;
		}
	}
	/**
	 * Import a Node 
	 * By QuynhPt
	 * date 16/01/2015
	 * @param linkFile
	 * @param behavior
	 * @param version
	 * @param linkVersion
	 */
	public void importNode(String linkFile, String behavior, boolean version,String linkVersion){
		//Verify that the popup is shown
		waitForAndGetElement(ELEMENT_IMPORT_NODE_POPUP_TITLE);
		
		//upload the file
		WebElement upload = waitForAndGetElement(ELEMENT_IMPORT_NODE_POPUP_UPLOAD_BUTTON, DEFAULT_TIMEOUT,1,2);
	
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
		upload.sendKeys(Utils.getAbsoluteFilePath(linkFile));
		String[] nameFile = linkFile.split("/");
		waitForAndGetElement(ELEMENT_IMPORT_NODE_POPUP_UPLOAD_FILE_LABEL.replace("${fileName}", nameFile[1]));
		
		//select a value for behavior
		select(ELEMENT_IMPORT_NODE_POPUP_BEHAVIOR, behavior);
		
		if(version){
			WebElement uploadVersion = waitForAndGetElement(ELEMENT_IMPORT_NODE_POPUP_VERSION_HISTORY_BUTTON, DEFAULT_TIMEOUT,1,2);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", uploadVersion);
			uploadVersion.sendKeys(Utils.getAbsoluteFilePath(linkVersion));
			String[] namefile = linkVersion.split("/");
			waitForAndGetElement(ELEMENT_IMPORT_NODE_POPUP_UPLOAD_FILE_LABEL.replace("${fileName}", namefile[1]));
		}
		switchToParentWindow();
		click(ELEMENT_IMPORT_MODE_POPUP_IMPORT_BUTTON);
		
		waitForMessage("Imported successfully.");
		click(button.ELEMENT_OK_BUTTON);
		Utils.pause(2000);

	}
	
	/**
	 * Export node
	 * By QuynhPT
	 * date 16/01/2015
	 * @param systemView
	 * @param zip
	 */
	public void exportNode(boolean systemView, boolean zip) {
		//Verify that the popup is shown
		waitForAndGetElement(ELEMENT_EXPORT_NODE_POPUP_TITLE);
		//select doc view type
		if (!systemView)
			click(ELEMENT_EXPORT_NODE_POPUP_DOC_VIEW, 2);
         //select zip type
		if (zip)
			click(ELEMENT_EXPORT_NODE_POPUP_ZIP, 2);

		click(ELEMENT_EXPORT_NODE_POPUP_EXPORT_BUTTON);
		waitForElementNotPresent(ELEMENT_EXPORT_NODE_POPUP_EXPORT_BUTTON);
	}
	/**
	 * Open Properties popup
	 * By QuynhPT
	 * date 19/01/2015
	 */
	public void goToProperties(){
		waitForAndGetElement(ELEMENT_ACTIONBAR_PROPERTIES);
		click(ELEMENT_ACTIONBAR_PROPERTIES);
	}
	
	/**
	 * Go to Properties popup
	 * By QuynhPT
	 * @param property
	 * @param value
	 */
	public void addProperty(String property, String value){
		waitForAndGetElement(ELEMENT_VIEWPROPERTIES_PROPERTIES_TAB);
		click(ELEMENT_VIEWPROPERTIES_ADD_PROPERTY_TAB);
		Utils.pause(1000);
		select(ELEMENT_VIEWPROPERTIES_ADD_PROPERTY_INPUT, property);
		type(ELEMENT_VIEWPROPERTIES_VALUE_INPUT,value,true);
		button.save();

		//Check if a property is added successfully.
		waitForAndGetElement(ELEMENT_VIEWPROPERTIES_PROPERTY.replace("{$property}", property).replace("{$value}", value));
		button.close();
	}
	/**
	 * Open Manage Pulishtation popup
	 * By QuynhPT
	 */
	public void goToManagePublishtation(){
		waitForAndGetElement(ELEMENT_ACTIONBAR_MANAGER_PUBLISHTATION);
		click(ELEMENT_ACTIONBAR_MANAGER_PUBLISHTATION);
		Utils.pause(2000);
	}
	
	/**
	 * Manage Publication popup
	 * By thunt
	 * Update QuynhPT
	 * @param state
	 * @param date
	 */
	public void managePublication(String state, String...date){
		By bState = By.xpath(ELEMENT_MANAGEPUBLICATION_STATE.replace("{$state}", state));
		String date1 = (String) (date.length > 0 ? date[0]:"");
		String date2 = (String) (date.length > 1 ? date[1]:"");
        //select State
		click(bState);
		waitForAndGetElement(ELEMENT_MANAGEPUBLICATION_CURRENT_SPECIFIC_STATUS.replace("${status}", state));
		if (state.equals("Staged") & (date.length > 0)){
			click(ELEMENT_MANAGEPUBLICATION_SCHEDULE_TAB);
			if((date1!=""&& date1!= null))
				type(ELEMENT_MANAGEPUBLICATION_PUB_FROM_INPUT,date1,true);
			if((date2!="" && date2!= null))
				type(ELEMENT_MANAGEPUBLICATION_PUB_TO_INPUT,date2,true);
			button.save();
			if(date.length > 2){
				waitForMessage(MSG_INVALID_DATE_TIME);
				button.ok();
				button.close();
				return;
			}
			waitForMessage("Your new publication schedule was saved successfully.");
			button.ok();
			click(ELEMENT_MANAGEPUBLICATION_REVISION_TAB);
		}
		waitForAndGetElement(ELEMENT_MANAGEPUBLICATION_HISTORY_TAB);
		waitForAndGetElement(ELEMENT_MANAGEPUBLICATION_REVISION_TAB);
		
		click(ELEMENT_MANAGEPUBLICATION_HISTORY_TAB);
		waitForAndGetElement(ELEMENT_MANAGEPUBLICATION_HISTORY_ITEM.replace("${state}", state));
		
		button.close();
		
	}
}
