package org.exoplatform.selenium.platform.ecms.contentexplorer;

import static org.exoplatform.selenium.TestLogger.info;
import java.util.HashMap;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.exoplatform.selenium.platform.ecms.admin.ManageView;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


/**
 * 
 * @author vuna2
 *
 */
public class ActionBar extends EcmsBase{

	public ActionBar(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	Button button = new Button(driver);
	Dialog dialog = new Dialog(driver);
	NavigationToolbar navToolBar = new NavigationToolbar(driver);
	ManageAccount magAcc = new ManageAccount(driver);
	ManageView magView = new ManageView(driver);
	ContextMenu cMenu = new ContextMenu(driver);
	ManageAlert alert = new ManageAlert(driver);

	//System TAB
	//Export Form
	public By ELEMENT_DOC_VIEW = By.id("format_docview");
	public By ELEMENT_ZIP = By.name("zip");
	public By ELEMENT_EXPORT_VERSION = By.linkText("Export Version History");
	public By ELEMENT_EXPORT = By.xpath("//button[text()='Export']");

	//Import Form
	public By ELEMENT_UPLOAD_FILE_FRAME = By.xpath("//label[contains(text(),'Upload File:')]/following::div/iframe[contains(@id,'uploadFrame')]");
	public By ELEMENT_UPLOAD_VERSION_FRAME = By.xpath("//label[contains(text(),'Version History:')]/following::div/iframe[contains(@id,'uploadFrame')]");
	public By ELEMENT_BEHAVIOR = By.name("behavior");
	public By ELEMENT_IMPORT = By.xpath("//button[text()='Import']");

	//Publication > Add Category Form
	public By ELEMENT_CATEGORIES_LINK = By.xpath("//*[@class='actionIcon']//*[@class='uiIconEcmsManageCategories']"); 
	public By ELEMENT_CATEGORIES_MORE_LINK = By.xpath("//*[text()='More']/..//a[text()='Categories']");
	public By ELEMENT_SELECT_CATEGORY_TAB = By.xpath("//*[text()='Select Category']");
	public By ELEMENT_CATEGORY_TREE_BOX = By.name("taxonomyTree");
	public By ELEMENT_ADD_ROOT_BUTTON = By.xpath("//label[text()='Root Tree']/following::img[@title='Add Root Node']");
	public By ELEMENT_REFERENCE_TAB = By.xpath("//a[contains(text(),'Referenced Categories')]");
	public String ELEMENT_DELETE_CATEGORY_ICON = "//td[text()='{$categoryPath}']/..//i[@class='uiIconDelete']";
	public String MSG_DELETE_CATEGORY = "Are you sure you want to delete this reference?";

	//Version Info form
	public By ELEMENT_ICON_VERSION_ADD=By.xpath("//*[@data-original-title='Add Label']");
	public By ELEMENT_TEXTBOX_VERSION=By.id("label");

	//publication form
	public final By ELEMENT_PUBLIC_STATUS = By.xpath("//*[contains(text(),'Published')]/..//a");
	public final By ELEMENT_CURRENT_STATUS = By.xpath("//*[@class='currentStatus']");
	public final By ELEMENT_CURRENT_PUBLIC_STATUS = By.xpath("//*[@class='currentStatus']/*[text()='Published']");

	//View Properties form
	public final By ELEMENT_VIEW_PROPERTIES_ICON = By.xpath("//i[@class='uiIconEcmsViewProperties']");
	public final By ELEMENT_PROPERTIES_TAB = By.linkText("Properties");
	public final By ELEMENT_ADD_PROPERTY_TAB = By.linkText("Add New Property");
	public final By ELEMENT_VALUE_INPUT = By.xpath("//input[contains(@id,'value')]");
	public final By ELEMENT_ADD_PROPERTY_INPUT = By.name("property_select");
	public final String ELEMENT_PROPERTY = "//td[text()='{$property}']/..//div[contains(text(),'{$value}')]"; 
	//Metadata form
	public final By ELEMENT_VIEW_METADATA_ICON = By.xpath("//i[@class='uiIconEcmsViewMetadatas']");
	public final By ELEMENT_METADATA_POPUP_TEXT = By.xpath("//span[@class='PopupTitle popupTitle' and text()='View Metadata']");
	
	//Go to Sites Management
	public void goToSitesManagement(){
		Utils.pause(500);
		if (isElementPresent(ELEMENT_SHOW_DRIVES)){
			click(ELEMENT_SHOW_DRIVES);
		}else {
			click(By.xpath("//*[@data-original-title = 'Show Drives']"));
		}
		Utils.pause(500);
	}

	//Go to add new content
	public void goToAddNewContent(){
		for (int repeat = 1;; repeat++)	{	
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform the action after " + ACTION_REPEAT + "tries");
			}
			WebElement newContent = waitForAndGetElement(ELEMENT_NEW_CONTENT_LINK, 10000, 0);
			if (newContent == null){
				WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 10000, 0);
				if (more != null){
					mouseOverAndClick(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
					Utils.pause(1000);
				}else {
					info("There is not Add New content icon in action bar");
					break;
				}
			}else break;
			Utils.pause(WAIT_INTERVAL);
			info("retry...[" + repeat + "]");
		}
		mouseOverAndClick(ELEMENT_NEW_CONTENT_LINK);
		waitForElementNotPresent(ELEMENT_NEW_CONTENT_LINK, DEFAULT_TIMEOUT, 1, 2);
	}

	//Go to add new folder
	public void goToAddNewFolder(){	
		for (int repeat = 0;; repeat++)	{	
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform the action after " + ACTION_REPEAT + "tries");
			}
			WebElement newFolder = waitForAndGetElement(ELEMENT_NEW_FOLDER_LINK, 5000, 0);
			if (newFolder == null){
				WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
				if (more != null){
					mouseOverAndClick(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
					Utils.pause(1000);
				}else {
					info("There is not Add New Folder icon in action bar");
					break;
				}
			} 
			mouseOverAndClick(ELEMENT_NEW_FOLDER_LINK);
			if (waitForElementPresent(ELEMENT_FOLDER_TITLE_TEXTBOX,30000,0) != null) break;
			Utils.pause(WAIT_INTERVAL);
			info("retry...[" + repeat + "]");
		}
	}
	
	//Collaboration Tab
	public void goToCollaboration(){
		for (int repeat = 0;; repeat++)	{	
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform the action after " + ACTION_REPEAT + "tries");
			}
			mouseOver(ELEMENT_COLLABORATION_TAB, true);
			click(ELEMENT_COLLABORATION_TAB);

			if (waitForElementPresent(ELEMENT_TAG, 30000, 0) != null) return;
			Utils.pause(WAIT_INTERVAL);
			info("retry...[" + repeat + "]");
		}
	}

	//Edit a document
	public void goToEditDocument(String title)
	{	
		goToNode(title);
		for(int loop = 1;;loop ++)
		{
			if (loop >= ACTION_REPEAT) {
				Assert.fail("Cannot go to the edit page: " + title );
			}
			if (waitForAndGetElement(ELEMENT_EDIT_LINK, 3000, 0) != null){
				click(ELEMENT_EDIT_LINK);
			}else{
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
				click(ELEMENT_EDIT_LINK);
			}
			if (waitForAndGetElement(button.ELEMENT_SAVE_CLOSE_BUTTON, 50000).isDisplayed()) 
				break;
		}
	}

	// switch to view mode (eg: Web view, List view ...)
	public void goToViewMode(String viewType){
		info("-- Change to view mode... --" + viewType);
		Utils.pause(1000);
		click(By.xpath(ELEMENT_VIEW_MODE_LINK.replace("${viewName}", viewType)));
		Utils.pause(1000);
	}

	//Go to 1 node by path in Intranet/document
	public void goToNodeByAddressPath(String path){
		WebElement address = waitForAndGetElement(ELEMENT_ADDRESS_BAR);
		address.clear();
		address.sendKeys(path);
		//address.sendKeys(Keys.ENTER);
		String pageId = waitForAndGetElement(By.xpath("//*[@id='UIPage']/div/div")).getAttribute("id");
		((JavascriptExecutor) driver).executeScript("javascript:eXo.webui.UIForm.submitForm('" + pageId + "#UIAddressBar','ChangeNode',true)");
		String[] temp = path.split("/");
		waitForElementPresent(By.xpath("//*[@id='FileViewBreadcrumb']//a[@data-original-title='" + temp[temp.length - 1] + "']"));
	}

	// Add a category in DMS Administration - Simple View
	public void addCategoryInSimpleView(String name)
	{
		click(ELEMENT_BUTTON_ADD_CATEGORY);
		waitForElementPresent(ELEMENT_ADD_CATEGORY_FORM);
		type(ELEMENT_INPUT_CATEGORY_NAME, name, false);
		click(button.ELEMENT_SAVE_BUTTON);
		waitForElementPresent(By.xpath("//a[@title='"+ name + " ']"));
	}

	//Export node
	public void exportNode(boolean systemView, boolean zip, boolean exportVersionHistory) {
		/*waitForElementPresent(ELEMENT_SYSTEM_TAB);
		click(ELEMENT_SYSTEM_TAB);
		Utils.pause(500);*/
		WebElement eProperties = waitForAndGetElement(ELEMENT_VIEW_PROPERTIES_ICON,10000,0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK,5000,0);
		if(eProperties == null)
			if (more !=null )
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
		
		waitForElementPresent(ELEMENT_EXPORT_LINK);
		click(ELEMENT_EXPORT_LINK);
		if (!systemView)
		{
			click(ELEMENT_DOC_VIEW);
		}

		if (zip)
		{
			click(ELEMENT_ZIP,2);
		}

		if (exportVersionHistory)
		{
			click(ELEMENT_EXPORT_VERSION);
		}
		else
		{
			click(ELEMENT_EXPORT);
		}
		Utils.pause(10000);
		waitForElementNotPresent(ELEMENT_EXPORT);
	}

	/**Import node
	 * Update: Thuntn
	 * @param linkFile
	 * @param linkVersion
	 * @param behavior
	 * @param version
	 */
	public void importNode(String linkFile, String linkVersion, String behavior, boolean version) {
		WebElement eProperties = waitForAndGetElement(ELEMENT_VIEW_PROPERTIES_ICON,10000,0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK,5000,0);
		if(eProperties == null)
			if (more !=null )
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
		//Click import button
		waitForElementPresent(ELEMENT_IMPORT_LINK);
		click(ELEMENT_IMPORT_LINK);
		//Switch to frame upload file
//		driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_FILE_FRAME));
		WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_IMG_ID, DEFAULT_TIMEOUT,1,2);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
		upload.sendKeys(Utils.getAbsoluteFilePath(linkFile));	
//		type(ELEMENT_UPLOAD_IMG_ID, Utils.getAbsoluteFilePath(linkFile), false);
		Utils.pause(500);
//		switchToParentWindow();

		select(ELEMENT_BEHAVIOR, behavior);
		if (version)
		{		
//			driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_VERSION_FRAME));
			WebElement uploadVersion = waitForAndGetElement(ELEMENT_UPLOAD_VERSION_ID, DEFAULT_TIMEOUT,1,2);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", uploadVersion);
			uploadVersion.sendKeys(Utils.getAbsoluteFilePath(linkVersion));
			Utils.pause(500);
//			switchToParentWindow();
			click(ELEMENT_IMPORT);
			Utils.pause(500);
			waitForMessage("Imported successfully.");
			click(button.ELEMENT_OK_BUTTON);
		}
		else 
		{
			click(ELEMENT_IMPORT);
			Utils.pause(500);
			waitForMessage("Imported successfully.");
			click(button.ELEMENT_OK_BUTTON);
		}
	}

	//Add category for node
	public void addCategoryForNode( String categoryPath, boolean rootTree) {
		String paths [] = categoryPath.split("/");
		String categoryTree = paths[0];
		By ELEMENT_ADD_CATEGORY_SPECIFIC = By.xpath("//div[contains(text(),'"+paths[paths.length-1]+"')]/following::a[@data-original-title='select']");
		//			By ELEMENT_CATEGORY_LIST = By.xpath("//th[text()='Category']");

		waitForElementPresent(ELEMENT_CATEGORIES_LINK);
		click(ELEMENT_CATEGORIES_LINK);
		waitForElementPresent(ELEMENT_SELECT_CATEGORY_TAB);
		click(ELEMENT_SELECT_CATEGORY_TAB);
		Utils.pause(500);
		select(ELEMENT_CATEGORY_TREE_BOX, categoryTree);
		if (rootTree) {
			click(ELEMENT_ADD_ROOT_BUTTON);
			waitForTextPresent(categoryTree);
			checkUnexpectedError();			
		}
		else {
			
			for (int i=1; i<paths.length-1 ; i++)
				click(By.xpath("//i[@title='"+paths[i]+"']"));
			waitForElementPresent(ELEMENT_ADD_CATEGORY_SPECIFIC);
			click(ELEMENT_ADD_CATEGORY_SPECIFIC);
			Utils.pause(500);
			checkUnexpectedError();

		}
		
		//Check if category is added for node.
		click(ELEMENT_CATEGORIES_LINK);
		waitForTextPresent(categoryPath);
		
		waitForElementPresent(button.ELEMENT_CLOSE_BUTTON);
		click(button.ELEMENT_CLOSE_BUTTON);
		info ("------Category "+paths[paths.length-1]+" is added succesfully");
	}

	/*
	 * Add version for a node
	 * + locator: locator of node
		   + version: version name
	 */
	public void addVersionForNode(By locator, String vesion){
		info("-- Add a version for a document... --");
		goToNode(locator);
		//click(ELEMENT_PUBLICATION_TAB);
		clearCache();
		if (waitForAndGetElement(ELEMENT_VERSIONS_LINK,10000,0)!=null){
			info("-- Versions tab is already displayed --");
		}else if (isElementPresent(ELEMENT_MORE_LINK_WITHOUT_BLOCK)){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (isElementPresent(ELEMENT_VERSIONS_LINK)){
				info("-- Versions tab is already displayed --");
			}
		}
		click(ELEMENT_VERSIONS_LINK);
		click(ELEMENT_ICON_VERSION_ADD);
		type(ELEMENT_TEXTBOX_VERSION,vesion,true);
		click(button.ELEMENT_SAVE_BUTTON);
		waitForElementNotPresent(button.ELEMENT_SAVE_BUTTON);
		click(button.ELEMENT_CLOSE_BUTTON);
	}

	//Choose a drive
	public void chooseDrive(By locator){
		info("-- Select a drive --");
		//click(ELEMENT_SHOW_DRIVES);
		goToSitesManagement();
		Utils.pause(1000);
		//button = new Button(driver);
		//button.refresh();
		click(locator);
		Utils.pause(1000);
	}

	//function public a document
	public void publishDocument(){
		button = new Button(driver);
		info("Public this document");
		if ((waitForAndGetElement(ELEMENT_PUBLICATION,30000,0) == null ))
			click(ELEMENT_MORE_LINK);
		click(ELEMENT_PUBLICATION);
		WebElement current = waitForAndGetElement(ELEMENT_CURRENT_STATUS);
		info(current.getText());
		if (current.getText().contains("Published") == false){
			click(ELEMENT_PUBLIC_STATUS);
		}
		waitForElementPresent(ELEMENT_CURRENT_PUBLIC_STATUS);
		button.close();
		info("Public document is successful");
	}

	// Node Permission
	public void goToNodePermissionManagement(){
		if (isTextPresent("Permissions")){
			info("-- Permission tab is already displayed --");
			click(ELEMENT_PERMISSION_LINK);
		}else{
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			click(ELEMENT_PERMISSION_LINK);
		}
		Utils.pause(1000);
	}

	//Add an action to Action Bar: View Permissions
	public void addViewPermissionToActionBar(){
		WebElement per = waitForAndGetElement(ELEMENT_PERMISSION_LINK, 5000, 0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
		if (per != null){
			info("-- Permission tab is already displayed --");
		} else if (more != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_PERMISSION_LINK, 5000, 0, 2) != null){
				info("-- Permission tab is already displayed --");
			}else{
				magView.setup2ShowViewAction("viewPermissions", "Web");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}else {
			magView.setup2ShowViewAction("viewPermissions", "Web");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
			navToolBar.goToSiteExplorer();
		}
		Utils.pause(1000);
	}


	//Go To Add Symlink 
	public void goToAddSymlinkTab(){
		if (isTextPresent("Add Symlink")){
			info("-- Add Symlink tab is already displayed --");
			click(ELEMENT_ADD_SYMLINK);
		}else{
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			click(ELEMENT_ADD_SYMLINK);
		}
		Utils.pause(1000);
	}

	//Go to the target node
	public void goToTargetNodeWhenAddSymlink(String path){
		goToAddSymlinkTab();
		waitForElementPresent(ELEMENT_ADD_SYMLINK_POPUP);
		click(ELEMENT_ADD_ITEM);	
		String[] temp;
		String delimiter = "/";
		temp = path.split(delimiter);
		for(int i =0; i < temp.length; i++){
			info("Go to "+temp[i]);
			click(By.xpath(ELEMENT_SYMLINK_PATH_NODE_TITLE.replace("${node}", temp[i])));
			Utils.pause(100);
		}
		Utils.pause(1000);
	}

	//Add symlink for node with target node is documents
	public void addSymlink(String workspace, String path, String name){
		goToAddSymlinkTab();
		waitForElementPresent(ELEMENT_ADD_SYMLINK_POPUP);
		if (path != null && path != ""){
			click(ELEMENT_ADD_ITEM);
			select(ELEMENT_SYMLINK_WORKSPACE, workspace);
			selectHomePathForCategoryTree(path);
		}
		String[] temp;
		String delimiter = "/";
		temp = path.split(delimiter);
		if (name.equalsIgnoreCase(temp[temp.length - 1] + ".lnk") == false){
			type(ELEMENT_SYMLINK_NAME, name, true);
		}
		assert getValue(ELEMENT_SYMLINK_NAME).equalsIgnoreCase(name);
		click(button.ELEMENT_SAVE_BUTTON); 
	}

	//Add symlink to action bar in site explorer if it does not exited
	public void addSymlinkToActionBar(){	
		WebElement syml = waitForAndGetElement(ELEMENT_ADD_SYMLINK, 5000, 0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
		if (syml != null){
			info("-- Add Symlink tab is already displayed --");
		} else if (more != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_ADD_SYMLINK, 5000, 0, 2) != null){
				info("-- Add Symlink tab is already displayed --");
			}else{
				magView.setup2ShowViewAction("addSymLink", "Web");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}else {
			magView.setup2ShowViewAction("addSymLink", "Web");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
			navToolBar.goToSiteExplorer();
		}
		Utils.pause(1000);
	}

	//A Function to copy/cut/paste/delete an Element (Document/Folder) in Sites Explorer
	//Check the box on the right side of Element
	//Select Action "Delete" on Action Bar
	public void actionsOnElement(String elementName, ContextMenu.actionType action){
		info("-- Action: "+ action + " on the element: " + elementName);
		//waitForTextPresent(elementName);
		if (waitForAndGetElement(ELEMENT_UI_CHECKBOX.replace("${element}", elementName), 3000, 0, 2) != null){
			click(ELEMENT_PERSONAL_DOCUMENTS);
			click(ELEMENT_UI_CHECKBOX.replace("${element}", elementName), 2);
		}else if (waitForAndGetElement(By.xpath("//*[contains(text(), '"+ elementName +"')]/../..//*[@name = 'checkbox']"), 3000, 0, 2) != null){
			click(ELEMENT_PERSONAL_DOCUMENTS);
			click(By.xpath("//*[contains(text(), '"+ elementName +"')]/../..//*[@name = 'checkbox']"), 2);
		}
		//click(ELEMENT_UI_CHECKBOX.replace("${element}", elementName), 2);
		switch (action) {
		case COPY:

			break;
		case CUT:

			break;
		case DELETE:
			click(cMenu.ELEMENT_MENU_DELETE);
			waitForTextPresent("Delete");
			dialog.deleteInDialog();
			waitForElementNotPresent(ELEMENT_UI_CHECKBOX.replace("${element}", elementName));
			break;
		case PASTE:

			break;

		default:
			break;
		}
		Utils.pause(1000);
	}

	/** function add "New Content" to File Management view if it is not existed
	 * @author lientm
	 */
	public void addNewContentToFileManagementView(){
		WebElement syml = waitForAndGetElement(ELEMENT_NEW_CONTENT_LINK, 5000, 0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
		if (syml != null){
			info("-- New content is already displayed --");
		} else if (more != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_NEW_CONTENT_LINK, 5000, 0) != null){
				info("-- New content is already displayed --");
			}else{
				magView.setup2ShowViewAction("addDocument", "List", "List");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToPersonalDocuments();
				goToViewMode("List");
			}
		}else {
			magView.setup2ShowViewAction("addDocument", "List", "List");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
			navToolBar.goToPersonalDocuments();
			goToViewMode("List");
		}
		Utils.pause(1000);
	}

	/** function add "Add Symlink" to File Management view if it is not existed
	 * @author lientm
	 */
	public void addSymlinkToFileManagementView(){
		WebElement syml = waitForAndGetElement(ELEMENT_ADD_SYMLINK, 5000, 0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
		if (syml != null){
			info("-- Add Symlink tab is already displayed --");
		} else if (more != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_ADD_SYMLINK, 5000, 0) != null){
				info("-- Add Symlink tab is already displayed --");
			}else{
				magView.setup2ShowViewAction("addSymLink", "List", "List");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToPersonalDocuments();
				goToViewMode("List");
			}
		}else {
			magView.setup2ShowViewAction("addSymLink", "List", "List");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
			navToolBar.goToPersonalDocuments();
			goToViewMode("List");
		}
		Utils.pause(1000);
	}

	/** function add version management to web Management view if it is not existed
	 * @author lientm
	 */
	public void addVersionMangementForActionBar(){
		WebElement ver = waitForAndGetElement(ELEMENT_VERSIONS_LINK, 5000, 0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
		if (ver != null){
			info("-- Version mangement is already displayed --");
		} else if (more != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_VERSIONS_LINK, 5000, 0) != null){
				info("-- Version mangement is already displayed --");
			}else{
				magView.setup2ShowViewAction("manageVersions");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}else {
			magView.setup2ShowViewAction("manageVersions");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
			navToolBar.goToSiteExplorer();
		}
	}

	//Add [Manage Relation] tab to Sites Explorer > Action Bar
	public void addRelationToActionBar(){	
		WebElement addRelation = waitForAndGetElement(ELEMENT_ADD_RELATION_LINK, 5000, 0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
		if (addRelation != null){
			info("-- Add Relation tab is already displayed --");
		} else if (more != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_ADD_RELATION_LINK, 5000, 0, 2) != null){
				info("-- Add Relation tab is already displayed --");
			}else{
				magView.setup2ShowViewAction("manageRelations", "Web");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}else {
			magView.setup2ShowViewAction("manageRelations", "Web");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
			navToolBar.goToSiteExplorer();
		}
		Utils.pause(1000);
	}

	//Create a relation between 2 nodes
	public void createRelation(String nodeName1, String pathToNodeName2, Object...params){
		//WebElement addRelation = waitForAndGetElement(ELEMENT_ADD_RELATION_LINK, 5000, 0);
		String[] temp;
		String delimiter = "/";
		temp = pathToNodeName2.split(delimiter);
		Boolean nodeAdminView = (Boolean) (params.length > 0 ? params[0]: false);

		info("-- Create a relation:--" + nodeName1 + " and " + temp[temp.length - 1]);
		if (nodeAdminView){
			goToNode(nodeName1, true);
		}else {
			goToNode(nodeName1);
		}
		if (isTextPresent("Relations")){
			info("-- Add Relation tab is already displayed --");
			click(ELEMENT_ADD_RELATION_LINK);
		}else {
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			click(ELEMENT_ADD_RELATION_LINK);
		}
		click(ELEMENT_SELECT_RELATION_TAB);
		selectHomePathForCategoryTree(pathToNodeName2);
		waitForTextPresent(temp[temp.length - 1]);
		button.close();	
		Utils.pause(500);
	}

	//Undo deleted Items
	public void undoDeletion(String...nodeName){
		String node = nodeName.length > 0 ? nodeName[0]: "";
		
		info("-- Undo deletion --");
		if (node != ""){
			waitForTextPresent("\'" + node + "' was deleted succesfully.");
		}
		click(ELEMENT_UNDO_DELETED_ITEM);
		if (waitForAndGetElement(button.ELEMENT_OK_BUTTON, 3000, 0) != null){
			click(button.ELEMENT_OK_BUTTON);
		}
		if (node != ""){
			waitForTextPresent("\'" + node + "' was successfully restored.");
		}
		Utils.pause(1000);		
	}
	
	
	//Delete data in Admin view, List view
	public void deleteDataInAdminView(String name){
		click(By.xpath(ELEMENT_SELECT_CHECKBOX.replace("${name}", name)), 2);
		click(ELEMENT_DELETE_NODE_ICON);
		dialog.deleteInDialog();
		waitForElementNotPresent(By.xpath(ELEMENT_SELECT_CHECKBOX.replace("${name}", name)), DEFAULT_TIMEOUT, 1, 2);
		Utils.pause(1000);
	}
	
	//Go to Manage Categories
	public void goToManageCategories(){
		info("-- Go to Action Bar/Categories Tab --");
		if(waitForAndGetElement(ELEMENT_CATEGORIES_LINK, 5000, 0) == null){
			click(ELEMENT_MORE_LINK);
			click(ELEMENT_CATEGORIES_MORE_LINK);
		}
		else{
			goToNode(ELEMENT_CATEGORIES_LINK);
	 	    waitForElementPresent(ELEMENT_PERMISSION_MANAGEMENT_POPUP);
		} 
	}
	/**function add Comment icon for action with web view
	 * @author lientm
	 */
	public void addCommentIconInActionBar(){
		navToolBar.goToSiteExplorer();
		click(By.linkText("acme"));
		click(By.linkText("documents"));
		click(By.linkText("metro.pdf"));
		WebElement comment = waitForAndGetElement(ELEMENT_ADD_COMMENT_LINK, 5000, 0);
		
		if (comment != null){
			info("-- Add comment icon is already displayed --");
		} else if (waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0) != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_ADD_COMMENT_LINK, 5000, 0) != null){
				info("-- Add comment icon is already displayed --");
			}else{
				magView.setup2ShowViewAction("comment");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
			}
		}else {
			magView.setup2ShowViewAction("comment");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
		}
	}
	
	/** function go to add comment in action bar
	 * @author lientm
	 */
	public void goToAddComment(){
		WebElement comment = waitForAndGetElement(ELEMENT_ADD_COMMENT_LINK, 5000, 0);
		if (comment == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
			if (more != null){
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			} else {
				info("Do not have add comment icon in action bar");
				return;
			}
		}
		click(ELEMENT_ADD_COMMENT_LINK);
		waitForElementPresent(ELEMENT_ADD_COMMENT_POPUP);
		Utils.pause(1000);
	}
	
	/**function add comment for node
	 * @author lientm
	 * @param comment: comment need to add
	 */
	public void addComment(String comment){
		goToAddComment();
		inputDataToFrame(ELEMENT_ADD_COMMENT_FRAME, comment, false);
		switchToParentWindow();
		button.save();
		waitForElementNotPresent(ELEMENT_ADD_COMMENT_POPUP);
		click(ELEMENT_SHOW_COMMENT_LINK);
		waitForElementPresent(By.xpath(ELEMENT_SHOW_COMMENT_CONTENT.replace("${comment}", comment)));
	}
	
	/**function edit a comment
	 * @author lientm
	 * @param oldComment
	 * @param newComment
	 */
	public void editComment(String oldComment, String newComment){
		click(ELEMENT_SHOW_COMMENT_LINK);
		click(By.xpath(ELEMENT_EDIT_COMMENT_ICON.replace("${comment}", oldComment)));
		waitForElementPresent(ELEMENT_ADD_COMMENT_POPUP);
		inputDataToFrame(ELEMENT_ADD_COMMENT_FRAME, newComment, false);
		switchToParentWindow();
		button.save();
		waitForElementNotPresent(ELEMENT_ADD_COMMENT_POPUP);
		click(ELEMENT_SHOW_COMMENT_LINK);
		waitForElementPresent(By.xpath(ELEMENT_SHOW_COMMENT_CONTENT.replace("${comment}", newComment)));
	}
	
	/**function delete a comment
	 * @author lientm
	 * @param comment
	 */
	public void deleteComment(String comment){
		click(ELEMENT_SHOW_COMMENT_LINK);
		click(By.xpath(ELEMENT_DELETE_COMMENT_ICON.replace("${comment}", comment)));
		alert.acceptAlert();
		if (waitForElementPresent(ELEMENT_SHOW_COMMENT_LINK, 5000, 0) != null){
			click(ELEMENT_SHOW_COMMENT_LINK);
		}
		waitForElementNotPresent(By.xpath(ELEMENT_SHOW_COMMENT_CONTENT.replace("${comment}", comment)));
	}
	
	/** function vote for a document/uploaded file
	 * @author lientm
	 * @param rate
	 */
	public void voteDocument(int rate){
		WebElement comment = waitForAndGetElement(ELEMENT_VOTE_LINK, 5000, 0);
		if (comment == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
			if (more != null){
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			} else {
				info("Do not have add comment icon in action bar");
				return;
			}
		}
		click(ELEMENT_VOTE_LINK);
		waitForElementPresent(ELEMENT_VOTE_POPUP);
		Utils.pause(1000);
		
		HashMap<Integer, String> rateVote = new HashMap<Integer, String>();
		rateVote.put(1, "Poor");
		rateVote.put(2, "Below average");
		rateVote.put(3, "Average");
		rateVote.put(4, "Above average");
		rateVote.put(5, "Good");
		
		click(By.xpath(ELEMENT_VOTE_RATE.replace("${rate}", rateVote.get(rate))));
		waitForElementPresent(ELEMENT_VOTE_COMPONENT);
	}
	
	/** function and translation for document
	 * @author lientm
	 * @param paths: path to folder contains destination file
	 * @param fileName: name of destination file
	 */
	public void addTranslationForDocument(String paths, String fileName){
		WebElement comment = waitForAndGetElement(ELEMENT_ADD_TRANSLATION_LINK, 5000, 0);
		if (comment == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
			if (more != null){
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			} else {
				info("Do not have add comment icon in action bar");
				return;
			}
		}
		click(ELEMENT_ADD_TRANSLATION_LINK);
		Utils.pause(1000);
		
		click(ELEMENT_SELECT_DOCUMENT_BUTTON);
		
		if (paths != ""){
			goToNode(paths);
		}
		click(By.xpath("//*[@id='ListRecords']//a[text()='" + fileName + "']"));
		waitForElementNotPresent(ELEMENT_SELECT_DOCUMENT_POPUP);
		button.save();
		waitForElementNotPresent(ELEMENT_ADD_TRANSLATION_POPUP);
	}
	/** Check if Export button is available in action bar
	 * @author thuntn
	 */
	public void addExportButton(){
		WebElement eExport = waitForAndGetElement(ELEMENT_EXPORT_LINK,10000,0);
		
		info("Check if Export button is available in action bar");
		if(eExport == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK,5000,0);
			if (more !=null ){
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
				eExport = waitForAndGetElement(ELEMENT_EXPORT_LINK,30000,0);
			
				if (eExport == null){
					navToolBar.goToContentAdministration();
					magView.setup2ShowViewAction("exportNode");
					magAcc.signOut();
					magAcc.signIn("john", "gtn");
					navToolBar.goToSiteExplorer();
				}
			}else{
				navToolBar.goToContentAdministration();
				magView.setup2ShowViewAction("exportNode");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}
		
	}
	
	/** Check if Category button is available in action bar
	 * @author thuntn
	 */
	public void checkCategoryButton(){
		WebElement eCategory = waitForAndGetElement(ELEMENT_CATEGORIES_LINK,10000,0);
		
		info("Check if Category button is available in action bar");
		if(eCategory == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK,5000,0);
			if (more !=null ){
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
				eCategory = waitForAndGetElement(ELEMENT_CATEGORIES_LINK,30000,0);
			
				if (eCategory == null){
					navToolBar.goToContentAdministration();
					magView.setup2ShowViewAction("addCategory");
					magAcc.signOut();
					magAcc.signIn("john", "gtn");
					navToolBar.goToSiteExplorer();
				}
			}else{
				navToolBar.goToContentAdministration();
				magView.setup2ShowViewAction("addCategory");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}
		
	}
	/**Manage publication state
	 * @author thuntn
	 */
	public void managePublication(String state, String...date){
		By bState = By.xpath(ELEMENT_PUBLICATION_STATE.replace("{$state}", state));
		
		info("Manage publication state");
		if (waitForAndGetElement(ELEMENT_PUBLICATION, 20000,0) == null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
		}
			
		click(ELEMENT_PUBLICATION);
		click(bState);
		if (state.equals("Staged")){
			click(ELEMENT_SCHEDULE_TAB);
			type(ELEMENT_PUB_FROM_INPUT,date[0],true);
			type(ELEMENT_PUB_TO_INPUT,date[1],true);
			button.save();
			waitForMessage("Your new publication schedule was saved successfully.");
			button.ok();
		}
		button.close();
	}
	/**Add View properties to action bar if it is not shown on action bar
	 * @author thuntn
	 */
	public void addViewPropertiesButton(){
		WebElement eProperties = waitForAndGetElement(ELEMENT_VIEW_PROPERTIES_ICON,10000,0);
		
		info("Add View properties to action bar if it is not shown on action bar");
		if(eProperties == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK,5000,0);
			if (more !=null ){
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
				eProperties = waitForAndGetElement(ELEMENT_VIEW_PROPERTIES_ICON,20000,0);
			
				if (eProperties == null){
					navToolBar.goToContentAdministration();
					magView.setup2ShowViewAction("viewProperties");
					magAcc.signOut();
					magAcc.signIn("john", "gtn");
					navToolBar.goToSiteExplorer();
				}
			}else{
				navToolBar.goToContentAdministration();
				magView.setup2ShowViewAction("viewProperties");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}
	}
	/**Add property for a node
	 * @author thuntn
	 */
	public void addProperty(String property, String value){
		
		info("Add property for a node");
		WebElement eProperties = waitForAndGetElement(ELEMENT_VIEW_PROPERTIES_ICON,10000,0);
		
		if(eProperties == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK,5000,0);
			if (more !=null )
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
		}
		click(ELEMENT_VIEW_PROPERTIES_ICON);
		waitForElementPresent(ELEMENT_PROPERTIES_TAB);
		
		click(ELEMENT_ADD_PROPERTY_TAB);
		select(ELEMENT_ADD_PROPERTY_INPUT,property);
		type(ELEMENT_VALUE_INPUT,value,true);
		button.save();
		
		//Check if a property is added successfully.
		waitForElementPresent(ELEMENT_PROPERTY.replace("{$property}", property).replace("{$value}", value));
		button.close();
	}
	/**Delete category for a node
	 * @author thuntn
	 * @param categoryPath
	 */
	public void deleteCategory(String categoryPath){
		click(ELEMENT_CATEGORIES_LINK);
		
		click(ELEMENT_DELETE_CATEGORY_ICON.replace("{$categoryPath}", categoryPath));
		alert.waitForConfirmation(MSG_DELETE_CATEGORY);
		
		waitForTextNotPresent(categoryPath);
		
		button.close();
	}
	/** Add Import button to action bar if it is not available on action bar
	 * @author thuntn
	 */
	public void addImportButton(){
		WebElement eExport = waitForAndGetElement(ELEMENT_IMPORT_LINK,10000,0);
		
		info("Add Import button to action bar if it is not available on action bar");
		if(eExport == null){
			WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK,5000,0);
			if (more !=null ){
				click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
				eExport = waitForAndGetElement(ELEMENT_IMPORT_LINK,30000,0);
			
				if (eExport == null){
					navToolBar.goToContentAdministration();
					magView.setup2ShowViewAction("importNode");
					magAcc.signOut();
					magAcc.signIn("john", "gtn");
					navToolBar.goToSiteExplorer();
				}	
			}else{
				navToolBar.goToContentAdministration();
				magView.setup2ShowViewAction("importNode");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}
	}
	/**Add View metadata icon to action bar if it is not shown on action bar
	 * @author thuntn
	 */
	public void addViewMetadataToActionBar(){
		WebElement addMetadata = waitForAndGetElement(ELEMENT_VIEW_METADATA_ICON, 10000, 0);
		WebElement more = waitForAndGetElement(ELEMENT_MORE_LINK_WITHOUT_BLOCK, 5000, 0);
		if (addMetadata != null){
			info("-- View metadata is already displayed --");
		} else if (more != null){
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
			if (waitForAndGetElement(ELEMENT_VIEW_METADATA_ICON, 5000, 0, 2) != null){
				info("-- View metadata is already displayed --");
			}else{
				magView.setup2ShowViewAction("viewMetadatas", "Web");
				magAcc.signOut();
				magAcc.signIn("john", "gtn");
				navToolBar.goToSiteExplorer();
			}
		}else {
			magView.setup2ShowViewAction("viewMetadatas", "Web");
			magAcc.signOut();
			magAcc.signIn("john", "gtn");
			navToolBar.goToSiteExplorer();
		}
		
	}
	/**Delete relation for a node
	 * @author thuntn
	 */
	public void deleteRelation(String relation){
		WebElement addRelation = waitForAndGetElement(ELEMENT_ADD_RELATION_LINK, 5000, 0);
		if(addRelation == null)
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
		click(ELEMENT_ADD_RELATION_LINK);
		
		click(ELEMENT_DELETE_RELATION_ICON.replace("{$relation}", relation));
		alert.waitForConfirmation(MSG_DELETE_RELATION);
		
		waitForTextNotPresent(relation);
		
		button.close();
		
		Utils.pause(1000);
	}
	/**View metadata
	 * @author thuntn
	 */
	public void viewMetadata(){
		info("View metadata of a node");
		WebElement viewMetadata = waitForAndGetElement(ELEMENT_VIEW_METADATA_ICON,5000,0);
		if (viewMetadata == null)
			click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
		click(ELEMENT_VIEW_METADATA_ICON);
		waitForElementPresent(ELEMENT_METADATA_POPUP_TEXT);
		button.cancel();
		
	}
	
	/** function lock nodes from clicking Lock icon in action bar
	 * @author lientm
	 * @param nodes
	 */
	public void lockNodeFromActionBar(String nodes){
		String ELEMENT_LOCKED_NODE_LIST_VIEW = "//*[contains(@data-original-title, 'Locked by')]//*[contains(text(),'${name}')]";
		
		String[] node = nodes.split("/");
		for (int i = 0; i < node.length; i ++){
			click(By.xpath(ELEMENT_SELECT_CHECKBOX.replace("${name}", node[i])), 2);
		}
		click(ELEMENT_LOCK_ICON);
		for (int j = 0; j < node.length; j ++){
			waitForElementPresent(ELEMENT_LOCKED_NODE_LIST_VIEW.replace("${name}", node[j]));
		}
	}
	
	/**function unlock nodes from clicking Unlock icon in action bar
	 * @author lientm
	 * @param nodes
	 */
	public void unLockNodeFromActionBar(String nodes){
		String ELEMENT_LOCKED_NODE_LIST_VIEW = "//*[contains(@data-original-title, 'Locked by')]//*[contains(text(),'${name}')]";
		
		String[] node = nodes.split("/");
		for (int i = 0; i < node.length; i ++){
			click(By.xpath(ELEMENT_SELECT_CHECKBOX.replace("${name}", node[i])), 2);
		}
		click(ELEMENT_UNLOCK_ICON);
		for (int j = 0; j < node.length; j ++){
			waitForElementNotPresent(ELEMENT_LOCKED_NODE_LIST_VIEW.replace("${name}", node[j]));
		}
	}
}