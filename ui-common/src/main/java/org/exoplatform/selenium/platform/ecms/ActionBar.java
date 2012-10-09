package org.exoplatform.selenium.platform.ecms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static org.exoplatform.selenium.TestLogger.*;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.ELEMENT_EDIT_NODE_CHECKBOX;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.ELEMENT_REMOVE_NODE_CHECKBOX;

public class ActionBar extends EcmsBase {
	public static By ELEMENT_TEXT_TEMPLATE_LIST = By.xpath("//div[contains(text(),'Select your template in the list below')]");
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
	public static By ELEMENT_SYSTEM_LINK = By.linkText("System");
	public static By ELEMENT_PERMISSION_LINK = By.linkText("Permissions");
	public static By ELEMENT_PER_MANA_POPUP = By.id("UIPopupWindow");
	public static String ELEMENT_PER_MANA_TEXT = "Permission Management";
	public static By ELEMENT_PER_MANA_GRID = By.xpath("//table[@class='UIGrid']");
	public static By READ_CHECKBOX = By.id("read");
	public static By ADDNODE_CHECKBOX = By.id("add_node");
	public static By SETPRO_CHECKBOX = By.id("set_property");
	public static By REMOVE_CHECKBOX = By.id("remove");
	public static By ELEMENT_USERS_LINK = By.linkText("Users");
	public static By ELEMENT_GROUP_AND_ROLES = By.linkText("Group and Roles");
	
	//Collaboration
	public static By ELEMENT_COLLABORATION_TAB = By.xpath("//a[contains(text(),'Collaboration')]");
	public static By ELEMENT_TAG = By.linkText("Tag");
	public static By ELEMENT_ADD_TAGS_BUTTON = By.xpath("//a[contains(text(),'Add Tags')]");
	public static By ELEMENT_CLOSE_TAG_FORM = By.xpath("//a[contains(text(),'Close')]");
	public static By ELEMENT_TAG_NAME = By.id("names");
	public static By ELEMENT_TAG_SCOPE = By.id("tagScopes");
	public static boolean SELECT = true; 
	public static By ELEMENT_TAG_CLOUD = By.xpath("//div[3]/div[4]/div");
	public static By ELEMENT_FILE_EXPLORER = By.xpath("//div[@id='UISideBar']/div/div/div[3]/div/div");
	public static By ELEMENT_EDIT_PUBLIC_TAG = By.xpath("//div[@title='Edit Public Tags']");
	public static By ELEMENT_EDIT_PRIVATE_TAG = By.xpath("//div[@title='Edit Private Tags']");
	public static By ELEMENT_REMOVE_TAG = By.xpath("//img[@alt='RemoveTag']");
	public static By ELEMENT_CLOSE_EDIT_PUBLIC_TAG_FORM = By.xpath("//a[@title='Close Window']");
	public static String WARNING_MESSAGE_AFTER_DELETE_TAG = "Are you sure to delete this tag?";

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
	
	//Collaboration Tab
	public static void goToCollaboration(){
		for (int repeat = 0;; repeat++)	{	
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform the action after " + ACTION_REPEAT + "tries");
			}
			mouseOver(ELEMENT_COLLABORATION_TAB, true);
			click(ELEMENT_COLLABORATION_TAB);

			if (waitForElementPresent(ELEMENT_TAG,30000,0) != null) return;
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

		public static void addTagForNode(String name, boolean isPublic) {
			// go to collaboration tab
			info("Go to Collaboration tab");
			goToCollaboration();

			// Click Tags
			waitForElementPresent(ELEMENT_TAG);
			click(ELEMENT_TAG);

			// Input information
			type(ELEMENT_TAG_NAME, name, true);

			//save
			if (isPublic){
				selectOption(ELEMENT_TAG_SCOPE, "Public");
			} else 
				selectOption(ELEMENT_TAG_SCOPE, "Private");
			click(ELEMENT_ADD_TAGS_BUTTON);

			//verify new tag
			waitForElementPresent(By.linkText(name));

			//close tag form
			click(ELEMENT_CLOSE_TAG_FORM);

			//verify add new tag
			click(ELEMENT_TAG_CLOUD);

			//			waitForTextPresent("Private Tags");
			waitForTextPresent(name);
		}

		public static void deleteTag(String name, boolean isPublic){
			// Delete tags
			if (isPublic){
				waitForElementPresent(ELEMENT_EDIT_PUBLIC_TAG);
				click(ELEMENT_EDIT_PUBLIC_TAG);
			}
			else {
				waitForElementPresent(ELEMENT_EDIT_PRIVATE_TAG);
				click(ELEMENT_EDIT_PRIVATE_TAG);
			}
			waitForElementPresent(ELEMENT_REMOVE_TAG);
			click(ELEMENT_REMOVE_TAG);
			waitForConfirmation(WARNING_MESSAGE_AFTER_DELETE_TAG);
			click(ELEMENT_CLOSE_EDIT_PUBLIC_TAG_FORM);
			waitForTextNotPresent(name);
		}
	//--------------permission of node------------------------------------
		  public static void goToPermissionManagement(){
			  goToNode(ELEMENT_SYSTEM_LINK);
			  goToNode(ELEMENT_PERMISSION_LINK);
		  }
		  
		  //function view permission management pop up of node
		  public static void viewPermissionOfNode(By locator){
			  goToNode(locator);
			  info("go to Permission Management popup");
			  goToPermissionManagement();
			  
			  waitForElementPresent(ELEMENT_PER_MANA_POPUP);
			  assert isElementPresent(ELEMENT_PER_MANA_POPUP):"Not found permission management";
			  assert isTextPresent(ELEMENT_PER_MANA_TEXT):"Permission management popup is wrong";
			  assert isElementPresent(ELEMENT_PER_MANA_GRID):"Permission management popup is wrong";
			  info("View permission of node is successful");
			  click(ELEMENT_CLOSE_BUTTON);
		  }

		  
		  //function set permission for node
		  public static void setPermissionOfNode(boolean read, boolean add, boolean pro, boolean remove){
			  info("Set user has read permission: "+read);
			  waitForElementPresent(READ_CHECKBOX);
			  if ((read && !waitForAndGetElement(READ_CHECKBOX).isSelected()) || (!read && waitForAndGetElement(READ_CHECKBOX).isSelected())){
				  click(READ_CHECKBOX);
			  }
			  info("Set user has add node permission: "+add);
			  if ((add && !waitForAndGetElement(ADDNODE_CHECKBOX).isSelected())||(!add && waitForAndGetElement(ADDNODE_CHECKBOX).isSelected())){
				  click(ADDNODE_CHECKBOX);
			  }
			  info("Set user has set propeties permission: "+pro);
			  if ((pro && !waitForAndGetElement(SETPRO_CHECKBOX).isSelected())||(!pro && waitForAndGetElement(SETPRO_CHECKBOX).isSelected())){
				  click(SETPRO_CHECKBOX);
			  }
			  info("Set user has set remove permission: "+remove);
			  if ((remove && !waitForAndGetElement(REMOVE_CHECKBOX).isSelected())|| (!remove && waitForAndGetElement(REMOVE_CHECKBOX).isSelected())){
				  click(REMOVE_CHECKBOX);
			  }
			  
		  }
		  
		  //function delete permission
		  public static void deletePermission(String user){
			  By ELEMENT_DELETE = By.xpath("//div[@title='"+user+"']/../../td/div/img[@class='DeleteIcon']");
			  click(ELEMENT_DELETE);
			  acceptAlert();
		  }
		  
		  
		  //function remove default user and group permission of node except owner
		  public static void removePermissionDefaultOfNode(){ 
			  deletePermission("*:/platform/web-contributors");
			  waitForTextNotPresent("*:/platform/web-contributors");
			  deletePermission("*:/platform/administrators");
			  waitForTextNotPresent("*:/platform/administrators");
			  deletePermission("any");
			  waitForTextNotPresent("any");
		  }
		  
		  //function add a user to group and choose membership type
		  public static void clickUpLevel(){
			  By ELEMENT_ROOT = By.xpath("//div[@class='BreadcumbsInfoBar ClearFix']/a[1]");
			  
			  WebElement root = getElement(ELEMENT_ROOT);
			  if (root != null){
				  click(ELEMENT_ROOT);
				  click(By.xpath("//a[@class='LevelUpArrowIcon']"));
			  }
		  }
		  
		  
		  
		  //function select user to set permission on permission management popup
		  public static void selectUser(String user){
			  By ELEMENT_USER = By.xpath("//div[@title='"+user+"']/../../td/div/img[@class='SelectPageIcon']"); 
			  
			  info("Set add node permission for user "+user+" to node");
			  click(By.xpath("//img[@title='Select User']"));
			  click(ELEMENT_USER);
		  }
}
