package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.info;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ecms.EcmsBase;
import static org.exoplatform.selenium.platform.ecms.SiteExplorer.*;
import static org.exoplatform.selenium.platform.ecms.ActionBar.*;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.*;
import static org.exoplatform.selenium.platform.ecms.ContextMenu.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import static org.exoplatform.selenium.platform.UserGroupManagement.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * @author: Lientm
 * @date: 8/10/2012
 */

public class ECMS_DMS_SE_Info_Permission extends EcmsBase{

	public static final String DATA_USER = "john";
	public static final String DATA_PASS = "gtn";
	public static final By ELEMENT_EDIT = By.xpath("//div[@title='*:/platform/administrators']/../../td/div/img[@class='EditIcon']");
	public static final By ELEMENT_DELETE = By.xpath("//div[@title='*:/platform/administrators']/../../td/div/img[@class='DeleteIcon']");

	@BeforeMethod
	public void beforeMethods() throws Exception {
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		info("Login ECMS with "+DATA_USER);
		loginEcms(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods() throws Exception {
		info("Logout ECMS");
		logoutEcms();
		driver.manage().deleteAllCookies();
		driver.quit();
		actions = null;
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

	/*case01: View Permission of folder
	 * create new folder: content folder
	 * view permission of folder
	 */
	@Test
	public void test01_ViewPermissionOfFolder(){		  
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_01";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER,ELEMENT_CONTENT_FOLDER);

		//view permission
		viewPermissionOfNode(ELEMENT_CONTENT_FOLDER);

		//delete data
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*case02: View Permission of node is document
	 * create new document: article document
	 * view permission of document
	 */
	@Test
	public void test02_ViewPermissionOfDocument(){
		String DATA_ARTICLE = "ECMS_DMS_SE_Info_Permission_article_01";
		By ELEMENT_ARTICLE = By.linkText(DATA_ARTICLE);

		//create new article document
		goToSiteExplorer();
		goToAddNewContent();
		info("Create new article with name: "+DATA_ARTICLE);
		createNewArticle(DATA_ARTICLE, DATA_ARTICLE, "", "");
		waitForElementPresent(ELEMENT_ARTICLE);
		info("Create new article document is successful");

		//view permission of document
		viewPermissionOfNode(ELEMENT_ARTICLE);

		//delete data
		deleteData(ELEMENT_ARTICLE);
	}

	/*case03: View Permission of node is uploaded file
	 * upload new file
	 * view permission of uploaded file
	 */
	@Test
	public void  test03_viewPermissionOfUploadedFile(){
		String DATA_UPLOAD = "ECMS_DMS_SE_Info_uploadfile_03";
		String DATA_UPLOAD_FILE_LINK = "TestData/ECMS_DMS_SE_Info_Permission.jpg";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD+".jpg "+"']");

		//upload new file
		goToSiteExplorer();
		info("Upload new file with name: "+DATA_UPLOAD);
		uploadFile(DATA_UPLOAD, DATA_UPLOAD_FILE_LINK);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		info("Upload new file is successful");

		//view permission of uploaded file
		viewPermissionOfNode(ELEMENT_UPLOAD_FILE);

		//delete data
		deleteData(ELEMENT_UPLOAD_FILE);
	}

	/*Case04: Edit permission of node
	 * create new node: content folder
	 * edit permission group *:/platform/web-contributors: does not have add node permission
	 * login with mary of that group to check not have add node permission
	 */
	@Test
	public void test04_EditPermissionOfNode(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_04";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);
		By ELEMENT_EDIT_WEB_CONTRIBUTOR = By.xpath("//div[@title='*:/platform/web-contributors']/../../td/div/img[@class='EditIcon']");

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//go to edit permission
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Edit permission of group *:/platform/web-contributors");
		click(ELEMENT_EDIT_WEB_CONTRIBUTOR);
		setPermissionOfNode(true, false, true, true);
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		logoutEcms();

		//login with mary
		driver.get(baseUrl);
		info("Login with user mary belong to *:/platform/web-contributors group");
		loginEcms("mary", "gtn");
		goToSiteExplorer();
		goToNode(ELEMENT_CONTENT_FOLDER);
		click(By.linkText("New Folder"));
		checkAlertWarning("You do not have permission to add a new node.");
		info("Check can not add node for this node is successful");
		logoutEcms();

		//delete data
		driver.get(baseUrl);
		loginEcms(DATA_USER, DATA_PASS);
		goToSiteExplorer();
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*case05: Edit permission of owner
	 * create new node: content folder by user John
	 * check can not edit permission of user John on this node
	 */
	@Test
	public void test05_EditPermissionOfOwner(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_05";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);
		By ELEMENT_EDIT_JOHN = By.xpath("//div[@title='john']/../../td/div/img[@class='EditIcon']");

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//check can not edit permission of user John on this node
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Check can not edit permission of user John on this node");
		click(ELEMENT_EDIT_JOHN);
		assert waitForAndGetElement(READ_CHECKBOX).getAttribute("disabled").contentEquals("true"):"permission is wrong";
		assert waitForAndGetElement(ADDNODE_CHECKBOX).getAttribute("disabled").contentEquals("true"):"permission is wrong";
		assert waitForAndGetElement(SETPRO_CHECKBOX).getAttribute("disabled").contentEquals("true"):"permission is wrong";
		assert waitForAndGetElement(REMOVE_CHECKBOX).getAttribute("disabled").contentEquals("true"):"permission is wrong";
		click(ELEMENT_CLOSE_BUTTON);

		//delete data
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*case06: Add permission for user to node
	 * create new node: content folder
	 * remove default permission of node
	 * add permission for user James have read node permission
	 * check user James can read node
	 */
	@Test
	public void test06_AddPermissionForUserToNode(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_06";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//remove permission default of content folder
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Remove user and group default permission of node");
		removePermissionDefaultOfNode();

		//add permission for user James have add node permission
		selectUser("james");
		setPermissionOfNode(true, false, false, false);
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		logoutEcms();

		//login with James to check read node permission
		driver.get(baseUrl);
		info("Login with user James");
		loginEcms("james", "gtn");
		goToSiteExplorer();
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"User can not read node";
		info("User can read node");
		logoutEcms();

		//delete data
		driver.get(baseUrl);
		loginEcms(DATA_USER, DATA_PASS);
		goToSiteExplorer();
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*Case16: Add permission for group to node, membership != *
	 * add user to group Organization/Management/Executive Board
	 * 	mary: member
	 *    james: editor
	 * create new node: content folder
	 * remove permission default of content folder
	 * add permission for group to content folder: Organization/Management/Executive Board with membership = member, permission = read
	 * check user mary can see content folder
	 * check user james can not see content folder 
	 */
	@Test
	public void test16_AddPermissionForGroupToNodeWithMemberShip(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_16";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//add user mary is member to group Organization/Management/Executive Board
		goToUsersAndGroupsManagement();
		click(ELEMENT_GROUP_MANAGEMENT_TAB);
		info("Add user mary is member to group");
		clickUpLevel();
		selectGroup("Organization/Management/Executive Board");
		addUsersToGroup("mary", "member", false, true);

		//add user mary is member to group Organization/Management/Executive Board
		info("Add user james is editor to group");
		clickUpLevel();
		selectGroup("Organization/Management/Executive Board");
		addUsersToGroup("james", "editor", false, true);

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//remove default permission of node
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Remove user and group default permission of node");
		removePermissionDefaultOfNode();

		//add permission for group to content folder: Organization/Management/Executive Board with membership = member, permission = read
		info("Set permission for group executive board to node");
		selectGroupAndMembership("organization/management/executive-board", "member");
		pause(1000);
		setPermissionOfNode(true, false, false, false);
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		logoutEcms();

		//check user mary can see content folder
		driver.get(baseUrl);
		loginEcms("mary", "gtn");
		goToSiteExplorer();
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"Mary can not see node";
		info("User mary can read node");
		logoutEcms();

		//check user james can not see content folder
		driver.get(baseUrl);
		loginEcms("james", "gtn");
		goToSiteExplorer();
		waitForElementNotPresent(ELEMENT_CONTENT_FOLDER);
		info("User james can not read node");
		logoutEcms();

		//delete data
		driver.get(baseUrl);
		loginEcms(DATA_USER, DATA_PASS);		  
		goToSiteExplorer();
		deleteData(ELEMENT_CONTENT_FOLDER);

		//remove user out of group
		goToUsersAndGroupsManagement();
		click(ELEMENT_GROUP_MANAGEMENT_TAB);
		clickUpLevel();
		deleteUserInGroup("organization/management/executive-board", "Organization/Management/Executive Board", "mary");
		clickUpLevel();
		deleteUserInGroup("organization/management/executive-board", "Organization/Management/Executive Board", "james");
	}

	/*case17: Add permission for group to node, membership = *
	 * add user to group Organization/Management/Executive Board
	 * 	mary: member
	 *    james: editor
	 * create new node: content folder
	 * remove permission default of content folder
	 * add permission for group to content folder: Organization/Management/Executive Board with membership = *, permission = read
	 * check user mary can see content folder
	 * check user james can see content folder 
	 */
	@Test
	public void test17_AddPermissionForGroupToNodeWithMemberShipFull(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_17";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//add user mary is member to group Organization/Management/Executive Board
		goToUsersAndGroupsManagement();
		click(ELEMENT_GROUP_MANAGEMENT_TAB);
		info("Add user mary is member to group");
		clickUpLevel();
		selectGroup("Organization/Management/Executive Board");
		addUsersToGroup("mary", "member", false, true);

		//add user mary is member to group Organization/Management/Executive Board
		info("Add user james is editor to group");
		clickUpLevel();
		selectGroup("Organization/Management/Executive Board");
		addUsersToGroup("james", "editor", false, true);

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//remove default permission of node
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Remove user and group default permission of node");
		removePermissionDefaultOfNode();

		//add permission for group to content folder: Organization/Management/Executive Board with membership = *, permission = read
		info("Set permission for group executive board to node");
		selectGroupAndMembership("organization/management/executive-board", "*");
		pause(1000);
		setPermissionOfNode(true, false, false, false);
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		logoutEcms();

		//check user mary can see content folder
		driver.get(baseUrl);
		loginEcms("mary", "gtn");
		goToSiteExplorer();
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"Mary can not see node";
		info("User mary can read node");
		logoutEcms();

		//check user james can see content folder
		driver.get(baseUrl);
		loginEcms("james", "gtn");
		goToSiteExplorer();
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"Mary can not see node";
		info("User james can read node");
		logoutEcms();

		//delete data
		driver.get(baseUrl);
		loginEcms(DATA_USER, DATA_PASS);		  
		goToSiteExplorer();
		deleteData(ELEMENT_CONTENT_FOLDER);

		//remove user out of group
		goToUsersAndGroupsManagement();
		click(ELEMENT_GROUP_MANAGEMENT_TAB);
		clickUpLevel();
		deleteUserInGroup("organization/management/executive-board", "Organization/Management/Executive Board", "mary");
		clickUpLevel();
		deleteUserInGroup("organization/management/executive-board", "Organization/Management/Executive Board", "james");
	}

	/*case18: Add permission for any user to node
	 * create new node: content folder
	 * remove permission default of content folder
	 * set permission to node for everyone, default has read permission
	 * check user james, mary can see node
	 */
	@Test
	public void test18_AddPermissionForAnyUserToNode(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_18";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//remove permission default of content folder
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Remove user and group default permission of node");
		removePermissionDefaultOfNode();

		//set permission to node for everyone
		click(By.xpath("//img[@title='Select Everyone']"));
		assert waitForAndGetElement(READ_CHECKBOX).isSelected():"read permission is not chosen";
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		logoutEcms();

		//check user mary can see content folder
		driver.get(baseUrl);
		loginEcms("mary", "gtn");
		goToSiteExplorer();
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"Mary can not see node";
		info("User mary can read node");
		logoutEcms();

		//check user james can see content folder
		driver.get(baseUrl);
		loginEcms("james", "gtn");
		goToSiteExplorer();
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"Mary can not see node";
		info("User james can read node");
		logoutEcms();

		//delete data
		driver.get(baseUrl);
		loginEcms(DATA_USER, DATA_PASS);		  
		goToSiteExplorer();
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*case19: Delete permission of node
	 * create new node: content folder
	 * delete permission of user any
	 * check james can not see content folder
	 */
	@Test
	public void test19_DeletePermissionOfNode(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_19";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//delete permission of user any
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Remove user permission of node");
		deletePermission("*:/platform/web-contributors");
		deletePermission("any");
		logoutEcms();

		//check user james can not see content folder
		driver.get(baseUrl);
		loginEcms("james", "gtn");
		goToSiteExplorer();
		waitForElementNotPresent(ELEMENT_CONTENT_FOLDER);
		info("User james can not read node");
		logoutEcms();

		//delete data
		driver.get(baseUrl);
		loginEcms(DATA_USER, DATA_PASS);		  
		goToSiteExplorer();
		deleteData(ELEMENT_CONTENT_FOLDER);		  
	}

	/*case20: Delete permission of owner
	 * create new node: content folder with user John
	 * delete permission of user John
	 * check alert
	 */
	@Test
	public void test20_DeletePermissionOfOwner(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_20";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder with user John
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//delete permission of john
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Remove permission of user John  of node");
		deletePermission("john");

		//check can node delete
		checkAlertWarning("You cannot remove the owner.");
		info("Can not remove permission of user is node owner");
		click(ELEMENT_CLOSE_BUTTON);

		//delete data
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*case21: Add/Edit/Delete permission of node when user does not have 'set property' right
	 * create new node: content folder with user John
	 * set permission for user mary does not have set properties permission for node
	 * check user mary can not add/delete or edit permission of this node
	 */
	@Test
	public void test21_CheckWhenUserNotHaveSetPropertiesForNode(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_21";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder with user John
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//remove permission default of content folder
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		info("Remove user and group default permission of node");
		removePermissionDefaultOfNode();

		//set permission for user mary does not have set properties permission for node
		selectUser("mary");
		setPermissionOfNode(true, true, false, true);
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		logoutEcms();

		//check user mary can not add/delete or edit permission of this node
		driver.get(baseUrl);
		loginEcms("mary", "gtn");
		goToSiteExplorer();
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		waitForElementNotPresent(By.xpath("//img[@class='EditIcon']"));
		waitForElementNotPresent(By.xpath("//img[@class='DeleteIcon']"));
		waitForElementNotPresent(By.id("UIPermissionForm"));
		info("User does not have add/delete/edit permission of node");
		logoutEcms();

		//delete data
		driver.get(baseUrl);
		loginEcms(DATA_USER, DATA_PASS);		  
		goToSiteExplorer();
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*case22: View permission of locked node by locker
	 * create new node: content folder
	 * lock node by user john
	 * view permission of node
	 */
	@Test
	public void test22_ViewPermissionOfLockedNodeByLocker(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_22";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder with user John
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//lock node
		goToNode(ELEMENT_CONTENT_FOLDER);
		info("Lock node by user John");
		lockNode(ELEMENT_CONTENT_FOLDER);
		pause(500);
		checkLockNode(ELEMENT_CONTENT_FOLDER);

		//view permission of node
		viewPermissionOfNode(ELEMENT_CONTENT_FOLDER);

		//delete data
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*Case23: View permission of locked node by user is not locker --> pending 2 driver
	 * create new node: content folder
	 * lock node by user john
	 * login by user mary
	 * view permission of node
	 */
	//	  @Test
	//	  public void test23_ViewPermissionOfLockedNodeByNotLocker(){
	//		  String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_23";
	//		  By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);
	//		  
	//		  //create new content folder with user John
	//		  goToSiteExplorer();
	//		  createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);
	//		  
	//		  //lock node
	//		  goToNode(ELEMENT_CONTENT_FOLDER);
	//		  info("Lock node by user John");
	//		  lockNode(ELEMENT_CONTENT_FOLDER);
	//		  pause(500);
	//		  checkLockNode(ELEMENT_CONTENT_FOLDER);
	//		  logoutEcms();
	//		  
	//		  //login with user mary
	//		  driver.get(baseUrl);
	//		  loginEcms("mary", "gtn");
	//		  goToSiteExplorer();
	//		  
	//		  //view permission of node
	//		  viewPermissionOfNode(ELEMENT_CONTENT_FOLDER);
	//		  logoutEcms();
	//		  
	//		  //delete data
	//		  driver.get(baseUrl);
	//		  loginEcms(DATA_USER, DATA_PASS);
	//		  goToSiteExplorer();
	//		  deleteData(ELEMENT_CONTENT_FOLDER);
	//	  }

	/*case24:  Add/Edit/Delete Permission of locked node by locker
	 * create new node: content folder
	 * lock node by user John
	 * check user John can add/edit/delete permission of node
	 */
	@Test
	public void test24_CheckPermissionOfLockedNodeByLocker(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_Info_Permission_contentfolder_24";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);

		//create new content folder with user John
		goToSiteExplorer();
		createAndCheckContentFolder(DATA_CONTENT_FOLDER, ELEMENT_CONTENT_FOLDER);

		//lock node
		goToNode(ELEMENT_CONTENT_FOLDER);
		info("Lock node by user John");
		lockNode(ELEMENT_CONTENT_FOLDER);
		pause(500);
		checkLockNode(ELEMENT_CONTENT_FOLDER);

		//check permission
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToPermissionManagement();
		waitForElementPresent(ELEMENT_SAVE_BUTTON);
		assert isElementPresent(ELEMENT_SAVE_BUTTON):"user permission is wrong";
		assert isElementPresent(ELEMENT_DELETE):"user permission is wrong";
		assert isElementPresent(ELEMENT_EDIT):"user permission is wrong";
		info("User has add/delete/edit permission of node");
		click(ELEMENT_CLOSE_BUTTON);

		//delete data
		deleteData(ELEMENT_CONTENT_FOLDER);
	}

	/*case25:   Add/Edit/Delete Permission of locked node by user is not locker
	 * pending: 2 driver
	 */

	/*case26: Add/Edit/Delete Permission of node when node is in 'check in' status
	 * create new node: article document
	 * check in node
	 * check can node add/edit/delete permission of node if node being check in status
	 */
	@Test
	public void test26_CheckPermissionOfCheckedInNode(){
		String DATA_ARTICLE = "ECMS_DMS_SE_Info_Permission_article_26";
		By ELEMENT_ARTICLE = By.linkText(DATA_ARTICLE);
		String MESSAGE = "You must check out first.";

		//create new article document with user John
		goToSiteExplorer();
		goToAddNewContent();
		info("Create new article with name: "+DATA_ARTICLE);
		createNewArticle(DATA_ARTICLE, DATA_ARTICLE, "", "");
		waitForElementPresent(ELEMENT_ARTICLE);
		info("Create new article document is successful");

		//check in node
		goToNode(ELEMENT_ARTICLE);
		checkInNode(ELEMENT_ARTICLE);

		//check can node add permission of node if node being check in status
		goToPermissionManagement();
		selectUser("mary");
		pause(500);
		setPermissionOfNode(true, false, false, false);
		click(ELEMENT_SAVE_BUTTON);
		checkAlertWarning(MESSAGE);
		info("Can not add permission for node when node being check in");

		//check can node edit permission of node if node being check in status
		click(ELEMENT_EDIT);
		click(ELEMENT_SAVE_BUTTON);
		checkAlertWarning(MESSAGE);
		info("Can not edit permission for node when node being check in");

		//check can node delete permission of node if node being check in status
		click(ELEMENT_DELETE);
		acceptAlert();
		checkAlertWarning(MESSAGE);
		info("Can not delete permission for node when node being check in");
		click(ELEMENT_CLOSE_BUTTON);

		//delete data
		checkOutNode(ELEMENT_ARTICLE);
		deleteData(ELEMENT_ARTICLE);
	}

	/*Case27:  Add/Edit/Delete Permission of node when parent node is in 'check in' status
	 * create new parent node: article document
	 * create new child node: kofax document
	 * check in parent node
	 * check can node add/edit/delete permission of node if node being check in status
	 */
	@Test
	public void test27_CheckPermissionOfNodeHasParentNodeIsCheckIn(){
		String DATA_ARTICLE = "ECMS_DMS_SE_Info_Permission_article_27";
		By ELEMENT_ARTICLE = By.linkText(DATA_ARTICLE);
		String DATA_KOFAX = "ECMS_DMS_SE_Info_Permission_kofax_27";
		By ELEMENT_KOFAX = By.linkText(DATA_KOFAX);

		//create new article document
		goToSiteExplorer();
		goToAddNewContent();
		info("Create new article with name: "+DATA_ARTICLE);
		createNewArticle(DATA_ARTICLE, DATA_ARTICLE, "", "");
		waitForElementPresent(ELEMENT_ARTICLE);
		info("Create new article document is successful");

		//create new child node: kofax
		goToNode(ELEMENT_ARTICLE);
		goToAddNewContent();
		info("Create child node (kofax document)");
		createNewKofax(DATA_KOFAX);
		pause(100);
		checkPreferenceOption("enableStructure");
		waitForElementPresent(ELEMENT_KOFAX);
		info("Create new kofax is successful");

		//check in parent node
		goToNode(ELEMENT_ARTICLE);
		checkInNode(ELEMENT_ARTICLE);

		//check can add permission for child node
		goToNode(ELEMENT_KOFAX);
		goToPermissionManagement();
		selectUser("mary");
		setPermissionOfNode(true, false, false, false);
		click(ELEMENT_SAVE_BUTTON);
		waitForElementPresent(By.xpath("//div[@title='mary']"));
		info("Add permission for node has parent node being check in status is successful");

		//check can edit permission for child node
		click(ELEMENT_EDIT);
		setPermissionOfNode(true, false, true, true);
		click(ELEMENT_SAVE_BUTTON);
		waitForElementPresent(By.xpath("//div[@title='*:/platform/administrators']/../../td[3]/div[@title='false']"));
		info("Edit permission for node has parent node being check in status is successful");

		//check can delete permission for child node
		click(ELEMENT_DELETE);
		acceptAlert();
		waitForElementNotPresent(ELEMENT_DELETE);
		info("Delete permission for node has parent node being check in status is successful");

		//delete data
		goToNode(ELEMENT_ARTICLE);
		checkOutNode(ELEMENT_ARTICLE);
		deleteData(ELEMENT_ARTICLE);
	}
}

