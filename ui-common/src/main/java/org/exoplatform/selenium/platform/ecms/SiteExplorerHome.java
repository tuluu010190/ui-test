package org.exoplatform.selenium.platform.ecms;

import org.exoplatform.selenium.ManageAlert;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SiteExplorerHome extends PlatformBase{

	PlatformPermission per;
	ManageAlert alert;
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
	
	
	public SiteExplorerHome(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		CreNewDoc = new CreateNewDocument(driver);
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
	}
	/**
	 * Go to Advanced Search page
	 */
	public void goToAdvancedSearch() {
		click(ELEMENT_SITEEXPLORER_LEFTBOX_SAVEDSEARCH);
		Utils.pause(2000);
		click(ELEMENT_SITEEXPLORER_LEFTBOX_ADVANCEDSEARCH);
	}
}
