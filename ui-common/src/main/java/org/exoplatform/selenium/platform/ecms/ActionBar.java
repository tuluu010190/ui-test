package org.exoplatform.selenium.platform.ecms;

import org.openqa.selenium.By;
import org.testng.Assert;
import static org.exoplatform.selenium.TestLogger.*;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.ELEMENT_EDIT_NODE_CHECKBOX;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.ELEMENT_REMOVE_NODE_CHECKBOX;

public class ActionBar extends EcmsBase {
	public static By ELEMENT_TEXT_TEMPLATE_LIST = By.xpath("//div[contains(text(),'Select your template in the list below')]");
	public static By ELEMENT_ADD_SYMLINK = By.linkText("Add Symlink");
	public static By ELEMENT_ADD_SYMLINK_POPUP = By.id("UIPopupWindow");
	public static By ELEMENT_SYMLINK_NAME = By.id("symLinkName");
	public static By ELEMENT_ADD_ITEM	 = By.xpath("//img[@title='Add Item']");
	public static By ELEMENT_LINK_EDIT= By.xpath("//a[@title='Edit']");
	
	public static By ELEMENT_SYSTEM_TAB = By.xpath("//a[@class='TabLabel' and @title='System']");
	public static By ELEMENT_EXPORT_BUTTON = By.xpath("//a[@class='SubTabIcon DefaultActionIcon ExportNodeIcon' and @title='Export']");
	public static By ELEMENT_DOC_VIEW = By.id("format_docview");
	public static By ELEMENT_ZIP = By.id("zip");
	public static By ELEMENT_EXPORT_VERSION = By.linkText("Export Version History");
	public static By ELEMENT_EXPORT = By.xpath("//a[@class='ActionButton LightBlueStyle' and text()='Export']");
	public static By ELEMENT_IMPORT_BUTTON = By.xpath("//a[@class='SubTabIcon DefaultActionIcon ImportNodeIcon' and @title='Import']");
	public static By ELEMENT_UPLOAD_FILE_FRAME = By.xpath("//label[contains(text(),'Upload File:')]/following::div/iframe[contains(@id,'uploadFrame')]");
	public static By ELEMENT_UPLOAD_VERSION_FRAME = By.xpath("//label[contains(text(),'Version History:')]/following::div/iframe[contains(@id,'uploadFrame')]");
	public static By ELEMENT_BEHAVIOR = By.name("behavior");
	public static By ELEMENT_IMPORT = By.xpath("//a[@class='ActionButton LightBlueStyle' and text()='Import']");
	public static By ELEMENT_ADD_CAT_BUTTON = By.xpath("//a[text()='Categories']");
	public static By ELEMENT_SELECT_CAT_TAB = By.xpath("//div[text()='Select Category']");
	public static By ELEMENT_CATEGORY_TREE_BOX = By.id("taxonomyTree");
	public static By ELEMENT_ADD_ROOT_BUTTON = By.xpath("//label[text()='Root Tree']/following::img[@title='Add Root Node']");
	public static By ELEMENT_CLOSE_BUTTON = By.xpath("//a[text()='Close']");
	public static By ELEMENT_OK_BUTTON = By.linkText("OK");

	
	// add a category
	public static void addCategory(String name)
	{
		click(ELEMENT_BUTTON_ADD_CATE);
		waitForElementPresent(ELEMENT_ADD_CATE_POP);
		type(ELEMENT_INPUT_CATE_NAME, name, false);
		click(ELEMENT_BUTTON_SAVE);
		waitForElementPresent(By.xpath("//a[@title='"+ name+ " ']"));
	}

	//System tab
	public static void setPermissionAddNodeForUser(String user,int permission,int delete){
		click(ELEMENT_SYSTEM_LINK);
		click(ELEMENT_PERMISSION_TAB);
		click(ELEMENT_SELECT_USER);
		if (delete ==1){
			click(ELEMENT_DELETE_PERMISSION);
			acceptAlert();
		}
		type(ELEMENT_SEARCH_TEXTBOX,user, false);
		click(ELEMENT_SEARCH_LINK);
		pause(500);
		click(ELEMENT_SEARCH_CHOOSE);
		pause(500);
		if (waitForAndGetElement(ELEMENT_READ_CHECKBOX).isSelected()==false){
			click(ELEMENT_READ_CHECKBOX);
		}
		if (permission==1){
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}else{
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
	}
	
	//go to new content
	public static void goToAddNewContent(){
		for (int repeat = 0;; repeat++)	{	
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform the action after " + ACTION_REPEAT + "tries");
			}
			mouseOver(ELEMENT_MENU_NEW_CONTENT_LINK, true);
			click(ELEMENT_MENU_NEW_CONTENT_LINK);
			
			if (waitForElementNotPresent(ELEMENT_MENU_NEW_CONTENT_LINK,30000,0) == null) return;
			pause(WAIT_INTERVAL);
			info("retry...[" + repeat + "]");
		}
	}
	
	
	public static void goToEditDocument(String title)
	{	
		for(int second=0;;second++)
		{
			if (second >= DEFAULT_TIMEOUT/WAIT_INTERVAL) {
				Assert.fail("Timeout at go to the edit page: " + title );
			}
			click(ELEMENT_LINK_EDIT);
			waitForElementPresent(ELEMENT_SAVE_CLOSE_BUTTON,50000);
			if (waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON,50000).isDisplayed()) break;
		}
	}
	//add symlink for node with target node = documents
	public static void addSymlink(By path, String name){
		click(ELEMENT_ADD_SYMLINK);
		waitForElementPresent(ELEMENT_ADD_SYMLINK_POPUP);
		click(ELEMENT_ADD_ITEM);
		if (path!=null){
			click(path);
		}
		if (name!="Documents.lnk" ){
			type(ELEMENT_SYMLINK_NAME,name,true);
		}
		assert getValue(ELEMENT_SYMLINK_NAME).contentEquals(name):"Symlink name is not true";
		click(ELEMENT_SAVE_BUTTON); 
	}
	
	public static void setPermissionForDocument(String user, boolean add, boolean edit, boolean remove, boolean reset)
	{
		click(ELEMENT_SYSTEM_LINK);
		click(ELEMENT_PERMISSION_TAB);
		if (reset)
		{
			click(ELEMENT_DELETE_PERMISSION);
			acceptAlert();
		}
		click(ELEMENT_SELECT_USER);
		waitForElementPresent(ELEMENT_SEARCH_TEXTBOX);
		type(ELEMENT_SEARCH_TEXTBOX,user, false);
		click(ELEMENT_SEARCH_LINK);
		click(ELEMENT_SEARCH_CHOOSE);
		if (waitForAndGetElement(ELEMENT_READ_CHECKBOX).isSelected()==false){
			click(ELEMENT_READ_CHECKBOX);
		}
		if (add)
		{
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}
		else
		{
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}
		if (edit)
		{
			if (waitForAndGetElement(ELEMENT_EDIT_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_EDIT_NODE_CHECKBOX);
			}
		}
		else
		{
			if (waitForAndGetElement(ELEMENT_EDIT_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_EDIT_NODE_CHECKBOX);
			}
		}
		if (remove)
		{
			if (waitForAndGetElement(ELEMENT_REMOVE_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_REMOVE_NODE_CHECKBOX);
			}
		}
		else
		{
			if (waitForAndGetElement(ELEMENT_REMOVE_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_REMOVE_NODE_CHECKBOX);
			}
		}
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}
	
	//Export node
		public static void exportNode (boolean systemView, boolean zip, boolean exportVersionHistory) {
			waitForElementPresent(ELEMENT_SYSTEM_TAB);
			click(ELEMENT_SYSTEM_TAB);
			pause(500);
			waitForElementPresent(ELEMENT_EXPORT_BUTTON);
			click(ELEMENT_EXPORT_BUTTON);
			if (!systemView)
			{
				click(ELEMENT_DOC_VIEW);
			}

			if (zip)
			{
				check(ELEMENT_ZIP);
			}

			if (exportVersionHistory)
			{
				click(ELEMENT_EXPORT_VERSION);
			}
			else
			{
				click(ELEMENT_EXPORT);
			}
			pause(10000);
		}

		//Import node
		public static void importNode (String linkFile, String linkVersion, String behavior, boolean version) {
			//Click system tab
			waitForElementPresent(ELEMENT_SYSTEM_TAB);
			click(ELEMENT_SYSTEM_TAB);
			//Click import button
			waitForElementPresent(ELEMENT_IMPORT_BUTTON);
			click(ELEMENT_IMPORT_BUTTON);
			//Switch to frame upload file
			driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_FILE_FRAME));
			waitForElementPresent(ELEMENT_UPLOAD_IMG_ID);
			type(ELEMENT_UPLOAD_IMG_ID, getAbsoluteFilePath(linkFile), false);
			pause(500);
			switchToParentWindow();

			select(ELEMENT_BEHAVIOR, behavior);
			if (version)
			{		
				driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_VERSION_FRAME));
				waitForElementPresent(ELEMENT_UPLOAD_IMG_ID);
				type(ELEMENT_UPLOAD_IMG_ID, getAbsoluteFilePath(linkVersion), false);
				pause(500);
				switchToParentWindow();
				click(ELEMENT_IMPORT);
				pause(500);
				waitForMessage("Import successfully.");
				click(ELEMENT_OK_BUTTON);
			}
			else 
			{
				click(ELEMENT_IMPORT);
				pause(500);
				waitForMessage("Import successfully.");
				click(ELEMENT_OK_BUTTON);
			}

		}

		//Add category for node
		public static void addCategoryForNode (String categoryTree, boolean rootTree, String categoryPath, String categoryName) {
			By ELEMENT_ADD_CATEGORY_SPECIFIC = By.xpath("//div[contains(text(),'"+categoryName+"')]/following::a[@title='select']");
//			By ELEMENT_CATEGORY_LIST = By.xpath("//th[text()='Category']");
			
			waitForElementPresent(ELEMENT_ADD_CAT_BUTTON);
			click(ELEMENT_ADD_CAT_BUTTON);
			waitForElementPresent(ELEMENT_SELECT_CAT_TAB);
			click(ELEMENT_SELECT_CAT_TAB);
			pause(500);
			select(ELEMENT_CATEGORY_TREE_BOX, categoryTree);
			if (rootTree) {
				click(ELEMENT_ADD_ROOT_BUTTON);
				waitForTextPresent(categoryTree);
				checkUnexpectedError();			
			}
			else {
				String paths [] = categoryPath.split("/");
				for (String path : paths)
					click(By.xpath("//div[@title='"+path+"']"));
				waitForElementPresent(ELEMENT_ADD_CATEGORY_SPECIFIC);
				click(ELEMENT_ADD_CATEGORY_SPECIFIC);
				pause(500);
				checkUnexpectedError();
				waitForTextPresent(categoryPath);
				
			}
			
			waitForElementPresent(ELEMENT_CLOSE_BUTTON);
			click(ELEMENT_CLOSE_BUTTON);
			info ("------Category "+categoryName+" is added succesfully");
		}

	
}
