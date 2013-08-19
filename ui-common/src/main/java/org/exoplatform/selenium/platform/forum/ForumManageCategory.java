package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.List;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class ForumManageCategory extends ForumBase {
	
	ForumPermission per;
	Button but;
	ManageAlert alert;
	
	public ForumManageCategory(WebDriver dr){
		driver = dr;
	}
	
	//------------category home screen----------------------------------------------------------------------
	public String ELEMENT_CATEGORY = "//*[@class='nameForum']/strong[text()='${categoryName}']";	
	public By ELEMENT_HOME_CATEGORY = By.xpath("//div[@class='Selected' and text()='Home']");
	public By ELEMENT_MANAGE_CATEGORY = By.xpath("//*[@class='uiIconForumManageCategory uiIconForumLightGray']");
	public By ELEMENT_EDIT_CATEGORY = By.xpath("//a[@class='ItemIcon EditCategoryIcon' and text()='Edit']");
	public By ELEMENT_DELETE_CATEGORY = By.id("UICategoryConfirm0");
	public By ELEMENT_OK_DELETE_CATEGORY = By.xpath("//*[@id='UIForumPopupConfirmation']//*[text()='OK']");
	
	//------------add category form------------------------------------------------------------------------
	public By ELEMENT_POPUP_ADD_CATEGORY = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Category']");
	public By ELEMENT_CATEGORY_TAB = By.xpath("//div[@class='MiddleTab' and text()='Category']");
	public By ELEMENT_CATEGORY_TITLE = By.id("CategoryTitle");
	public By ELEMENT_CATEGORY_ORDER = By.id("CategoryOrder");
	public By ELEMENT_RESTRICTED_AUDIENCE = By.id("UserPrivate");
	public String ELEMENT_RESTRICTED = "UserPrivate";
	public By ELEMENT_DESCRIPTION = By.id("Description");
	public String[] SET_PERMISSION = {"moderators", "Topicable", "Postable", "Viewer"};
	public String ELEMENT_MODERATORS = "moderators";
	public String ELEMENT_TOPICABLE = "Topicable";
	public String ELEMENT_POSTABLE = "Postable";
	public String ELEMENT_VIEWER = "Viewer";
	
	//---------------Import category form--------------------------------------
	public By ELEMENT_IMPORT_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Import Category']");
	public By ELEMENT_IMPORT_FRAME = By.xpath("//iframe[contains(@id,'uploadFrame')]");
	public By ELEMENT_IMPORT_FILE = By.id("file");
	
	//-------------------Export category form-------------------------------------
	public By ELEMENT_EXPORT_CATEGORY_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Export Categories']");
	public By ELEMENT_EXPORT_CATEGORY_BODY = By.xpath("//*[@id='UIExportForm']/*//fieldset/*//tbody");
	public By ELEMENT_EXPORT_CATEGORY_CHECKBOX_LIST = By.xpath("//tr/td/input[@type='checkbox']");
	public String ELEMENT_EXPORT_CATEGORY_CHECKBOX = "//tr[${No}]/td/input[@type='checkbox']";
	public String ELEMENT_EXPORT_CATEGORY_CHOOSE = "//label[text()='${category}']/../../*//input[@type='checkbox']";	
	public By ELEMENT_EXPORT_CATEGORY_FILE_NAME = By.id("FileName");
	public By ELEMENT_EXPORT_CATEGORY_ALL = By.id("ExportMode_ExportAll");
	public By ELEMENT_EXPORT_CATEGORY_ONLY = By.id("ExportMode_ExportCategories");
	
	/*------------------------------------common function---------------------------------*/
	
	/** Function go to Add Category Popup
	 * @author lientm
	 */
	public void goToAddCategory(){
		info("Go to add new category");
		waitForAndGetElement(ELEMENT_ADD_CATEGORY);
		click(ELEMENT_ADD_CATEGORY);
		waitForAndGetElement(ELEMENT_POPUP_ADD_CATEGORY);
	}
	/**
   * Go to a category
   * @param title Category title
   * @author dunghm
   */
  public void gotoCategory(String title){
    By categoryLink = By.xpath("//a[contains(@class,'ActionLink') and text()='" + title + "']");
    By category = By.xpath(ELEMENT_CATEGORY.replace("${categoryName}", title));
    click(categoryLink);
    waitForAndGetElement(category);
  } 

	/**Function add a Category
	 * @author lientm
	 * @param title: title of category
	 * @param order: order of category
	 * @param chooseUser: choose the way to input Private User
	 * @param userGroup: select user or group permission for private user
	 * @param description: description of category
	 * @param setPermission: choose way set permission
	 * @param user: user is set permission for category
	 */
	public void addCategoryInForum(String title, String order, int chooseUser, String[] userGroup, String description, int setPermission, String...user){
//		String isuser = user.length > 0 ? user[0]: "john";
//		String isrole = user.length > 1 ? user[1]: "*";
		By CATEGORY = By.xpath(ELEMENT_CATEGORY.replace("${categoryName}", title));
		
		goToAddCategory();
		info("Create new category");
		type(ELEMENT_CATEGORY_TITLE, title, true);
		type(ELEMENT_CATEGORY_ORDER, order, true);
		//ForumBase.setPermissionWithOption(ELEMENT_RESTRICTED, chooseUser, userGroup);
		type(ELEMENT_DESCRIPTION, description, true);
		
		//set permission
		if(setPermission != 0){
			info("Set permission for category");
			click(per.ELEMENT_PERMISSION_TAB);
			//String[] userstring = {isuser, isrole};
			for (int i = 0; i < 4; i ++){
				//ForumBase.setPermissionWithOption(SET_PERMISSION[i], setPermission, userstring);
			}
		}
		but.save();
		waitForAndGetElement(CATEGORY);
		info("Create new category successfully");
	}
	
	/**
   * Add a new forum category with short set of parameters
   * @param title : Category title
   * @param description : Category description
   * @param permission : optional parameters
   *                     - permission[0] : locator of permission field
   *                     - permission[1] : user string
   * @author dunghm                    
   */
  public void quickAddCategory(String title, String description, String... permission){
    but = new Button(driver);
    By CATEGORY = By.xpath(ELEMENT_CATEGORY.replace("${categoryName}", title));    
    goToAddCategory();
    
    info("Create new category");
    type(ELEMENT_CATEGORY_TITLE, title, true);    
    type(ELEMENT_DESCRIPTION, description, true);
    if(permission.length > 1) {
//      String locator = permission[0];
//      String userstring = permission[1];      
      info("Set permission for category");
      click(per.ELEMENT_PERMISSION_TAB);      
      //per.selectUserPermission(locator, userstring);      
    }
    
    but.save();
    waitForAndGetElement(CATEGORY);
    info("Create new category successfully");
  }
  
  /**
   * Add a new forum category with a invalid user
   * @param title : Category title
   * @param user : User string 
   * @param description : Category description
   * @param permission : optional parameters
   *                   - permission[0] : locator of permission field, default value is ELEMENT_RESTRICTED
   *                   - permission[1] : Error message after doing save action
   * @author dunghm                  
   */
  public void addCategoryInvalidUser(String title, String user, String description, String...permission){
    String locator = (permission.length > 0)? permission[0]: ELEMENT_RESTRICTED;
    String message = (permission.length > 1)? permission[1]: "The field \"Restricted Audience\" is invalid: " + user + ".";
    goToAddCategory();
    info("Create new category");
    type(ELEMENT_CATEGORY_TITLE, title, true);
    type(ELEMENT_DESCRIPTION, description, true);
    if(permission.length > 1)
      click(per.ELEMENT_PERMISSION_TAB);
    type(By.id(locator), user, true);
    but.save();    
    waitForMessage(message);
    click(By.linkText("OK"));
  }
	
	/**function go to edit category
	 * @author lientm
	 */
	public void goToEditCategory(){
		info("Go to edit category");
		waitForAndGetElement(ELEMENT_MANAGE_CATEGORY);
		click(ELEMENT_MANAGE_CATEGORY);
		waitForAndGetElement(ELEMENT_EDIT_CATEGORY);
		click(ELEMENT_EDIT_CATEGORY);
		waitForAndGetElement(ELEMENT_POPUP_ADD_CATEGORY);
	}
	
	/**function: delete a category
	 * @author lientm
	 * @param title: title of category
	 */
	public void deleteCategory(String title, boolean...verify){
		but = new Button(driver);
	    Boolean isVerify = true;
	    if(verify.length > 0) {
	      isVerify = verify[0];
	    }
		click(ELEMENT_MANAGE_CATEGORY);
		info("Delete category");
		click(ELEMENT_DELETE_CATEGORY);
		click(ELEMENT_OK_DELETE_CATEGORY);
		if(isVerify == true){
		  waitForTextNotPresent(title);
		}
		info("Delete category successfully");
	}
	
	/**function delete many category
	 * @author lientm
	 * @param category
	 */
	public void deleteSomeCategory(String...category){
		if (category.length > 0){
			for (int i = 0; i < category.length; i++){
				By element_category = By.linkText(category[i]);
				click(element_category);
				deleteCategory(category[i], true);
			}
		}
	}

	/**function: edit a category
	 * @author lientm
	 * @param title: new title of category
	 * @param order: new order of category
	 * @param chooseUser: choose a way to input Private User
	 * @param userGroup: select user or group permission for private user
	 * @param description: description of category
	 * @param setPermission: choose a way to set permission
	 * @param user: user/group to set permission
	 */
	public void editCategory(String title, String order, int chooseUser, String[] userGroup, String description, int setPermission, String...user){
//		String isuser = user.length > 0 ? user[0]: "john";
//		String isrole = user.length > 1 ? user[1]: "*";
		
		goToEditCategory();
		info("Edit category");
		if (title != null){
			type(ELEMENT_CATEGORY_TITLE, title, true);
		}
		if (order != null){
			type(ELEMENT_CATEGORY_ORDER, order, true);
		}
		if (chooseUser != 0){
			waitForAndGetElement(ELEMENT_RESTRICTED_AUDIENCE).clear();
			//ForumBase.setPermissionWithOption(ELEMENT_RESTRICTED, chooseUser, userGroup);
		}
		if (description != null){
			type(ELEMENT_DESCRIPTION, description, true);
		}
		//set permission
		if(setPermission != 0){
			info("Set permission for category");
			click(per.ELEMENT_PERMISSION_TAB);
//			String[] userstring = {isuser, isrole};
			for (int i = 0; i < 4; i ++){
				//ForumBase.setPermissionWithOption(SET_PERMISSION[i], setPermission, userstring);
			}
		}
		but.save();
		if (title != null && title != ""){
			By CATEGORY = By.xpath(ELEMENT_CATEGORY.replace("${categoryName}", title));
			waitForAndGetElement(CATEGORY);
		}
	}
	
	/** function: import a category
	 * @author lientm
	 * @param file: file import
	 */
	public void importCategory(String file){
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForAndGetElement(ELEMENT_IMPORT);
		click(ELEMENT_IMPORT);
		waitForAndGetElement(ELEMENT_IMPORT_POPUP);
		info("Import category");
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_IMPORT_FRAME));
		info("Import file " + file);
		type(ELEMENT_IMPORT_FILE, Utils.getAbsoluteFilePath(file), false);
		switchToParentWindow();
		String links[] = file.split("/");
		int length = links.length;
		waitForAndGetElement(By.xpath("//div[contains(text(), '" + links[length-1] + "')]"));
		but.save();
		waitForElementNotPresent(ELEMENT_IMPORT_POPUP);
		info("Import file " + file + "successfully");
		click(By.linkText("OK"));
	}
	
	/** function: export a category
	 * @author lientm
	 * @param category: title of category that needs to export
	 * @param fileName: file name export
	 * @param mode: full or only category
	 */
	public void exportCategory(String fileName, boolean mode, String...category){
		waitForAndGetElement(ELEMENT_ADMINISTRATION);
		click(ELEMENT_ADMINISTRATION);
		waitForAndGetElement(ELEMENT_EXPORT_CATEGORY);
		click(ELEMENT_EXPORT_CATEGORY);
		waitForAndGetElement(ELEMENT_EXPORT_CATEGORY_POPUP);
		
		if (category.length > 0){
			//uncheck categories in list
			WebElement e = waitForAndGetElement(ELEMENT_EXPORT_CATEGORY_BODY);
			List<WebElement> cat = e.findElements(ELEMENT_EXPORT_CATEGORY_CHECKBOX_LIST);
			for (int i = 1; i < cat.size(); i ++){
				By element = By.xpath(ELEMENT_EXPORT_CATEGORY_CHECKBOX.replace("${No}", Integer.toString(i)));
				if (waitForAndGetElement(element).isSelected() == true){
					click(element);
				}
			}
			
			//choose category to export
			for (int i = 0; i < category.length; i ++){
				By cat_export = By.xpath(ELEMENT_EXPORT_CATEGORY_CHOOSE.replace("${category}", category[i]));
				if (waitForAndGetElement(cat_export).isSelected() == false){
					check(cat_export);
				}
			}
		}
		info("Export category " + category);
		type(ELEMENT_EXPORT_CATEGORY_FILE_NAME, fileName, true);
		if (mode){
			click(ELEMENT_EXPORT_CATEGORY_ALL);
		}else{
			click(ELEMENT_EXPORT_CATEGORY_ONLY);
		}
		but.save();
		waitForElementNotPresent(ELEMENT_EXPORT_CATEGORY_POPUP, 50000);
	}
	
	/**function add new category with title and setting permission
	 * @author thaopth
	 * @param title
	 * @param userGroup
	 */
	public void addCategoryWithSettingPermission(String title, String...userGroup ){
		By CATEGORY = By.xpath(ELEMENT_CATEGORY.replace("${categoryName}", title));    
		info("Create new category");
		type(ELEMENT_CATEGORY_TITLE, title, true);
		click(per.ELEMENT_PERMISSION_TAB);
		info("Set moderator");
		if (userGroup.length > 0){
			if (userGroup[0] != "" && userGroup[0] != null){
//				String[] user = {userGroup[0]};
				//ForumBase.setPermissionWithOption(SET_PERMISSION[0], 1, user );
			}
		}
		info("Set who can start topic");
		if (userGroup.length > 1){
			if (userGroup[1] != "" && userGroup[1] != null){
				//String[] user = {userGroup[1]};
				//ForumBase.setPermissionWithOption(SET_PERMISSION[1], 1, user );
			}
		}
		info("Set who can post");
		if (userGroup.length > 2){
			if (userGroup[2] != "" && userGroup[2] != null){
				//String[] user = {userGroup[2]};
				//ForumBase.setPermissionWithOption(SET_PERMISSION[2], 1, user );
			}
		}	
		info("Set who can view");
		if (userGroup.length > 3){
			if (userGroup[3] != "" && userGroup[3] != null){
				//String[] user = {userGroup[3]};
				//ForumBase.setPermissionWithOption(SET_PERMISSION[3], 1, user );
			}
		}	
		but.save();
		waitForAndGetElement(CATEGORY);
		info("Create new category successfully");
		
	}
}
