package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.basicaction;

import static org.exoplatform.selenium.platform.ecms.ActionBar.*;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.*;
import static org.exoplatform.selenium.platform.ecms.ContextMenu.*;
import static org.exoplatform.selenium.platform.ecms.SiteExplorer.*;
import static org.exoplatform.selenium.TestLogger.*;

import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *@author NhungVT
 *@date: 02/10/2012
 */

public class ECMS_DMS_SE_BasicAction_Delete extends EcmsBase 
{
	public By WEBCONTRIBUTOR_EDIT_PERMISSIONS = By.xpath("//td/div[@title='*:/platform/web-contributors']/following::td//img[@title='Edit']");
	public By REMOVE_RIGHT_CHECKBOX = By.xpath("//input[@id='remove']");

	@BeforeMethod()
	public void beforeTest()
	{
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		loginEcms("john", "gtn");
	}

	//Delete node when user has right to remove node
	@Test()
	public void test01_DeleteNodeWhenUserHasRightToRemove()
	{	String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_BasicAction_Delete_content_01";
	 	String DATA_KOFAX_NAME = "ECMS_DMS_SE_BasicAction_Delete_kofax_01";
	 	String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_BasicAction_Delete_uploadfile_01";
	 	String DATA_UPLOAD_FILE_PATH ="TestData/Winter.jpg";
		String CONTENT_FOLDER_XPATH = "//div[@title='"+DATA_CONTENT_FOLDER+"']";
		By CONTENT_FOLDER = By.xpath(CONTENT_FOLDER_XPATH);
		By KOFAX_DISPLAY = By.xpath("//td[text()='"+DATA_KOFAX_NAME+"']");
		By KOFAX_DOCUMENT = By.xpath("//div[@title='"+DATA_KOFAX_NAME+"']");
		By UPLOAD_FILE_NAME = By.xpath("//div[@title='"+DATA_UPLOAD_FILE_NAME+".jpg']");
		
		//goto Site Explorer
		goToSiteExplorer();

		//Create a Content Folder
		createNewContentFolder(DATA_CONTENT_FOLDER, DATA_CONTENT_FOLDER);
		waitForElementPresent(CONTENT_FOLDER);

		//Create a Kofax Document
		goToAddNewContent();
		createNewKofax(DATA_KOFAX_NAME);
		waitForAndGetElement(KOFAX_DISPLAY);
		click(ELEMENT_SIDEBAR_SITES_MANAGEMENT);
		waitForElementPresent(KOFAX_DOCUMENT);

		//Upload a File
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_PATH);
		waitForElementPresent(UPLOAD_FILE_NAME);

		//Delete Nodes
		deleteDocument(CONTENT_FOLDER);
		deleteDocument(KOFAX_DOCUMENT);
		deleteDocument(UPLOAD_FILE_NAME);

		//Goto Trash driver
		chooseDrive(ELEMENT_TRASH_DRIVE);
		
		//Verify Delete Nodes: Search by Name
		assert simpleSearch(DATA_CONTENT_FOLDER):"Can not found deleted content folder in Trash";
		assert simpleSearch(DATA_KOFAX_NAME):"Can not found deleted content folder in Trash";
		assert simpleSearch(DATA_UPLOAD_FILE_NAME):"Can not found deleted content folder in Trash";
	}

	//Delete node in 'check in' status
	@Test()
	public void test02_DeleteCheckInNode()
	{	String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_BasicAction_Delete_uploadfile_02";
 		String DATA_UPLOAD_FILE_PATH ="TestData/Winter.jpg";
		By UPLOAD_FILE_NAME = By.xpath("//div[@title='"+DATA_UPLOAD_FILE_NAME+".jpg']");
 		
		//goto Site Explorer
		goToSiteExplorer();

		//Upload a File
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_PATH);
		waitForElementPresent(UPLOAD_FILE_NAME);

		//Right click and check-in node
		checkInNode(UPLOAD_FILE_NAME);
		pause(1000);
		
		//Verify item Delete item not exist
		rightClickOnElement(UPLOAD_FILE_NAME);
		waitForElementNotPresent(ELEMENT_MENU_DELETE);
		info("Cannot delete node being in check in status");
		
		//Delete data
		goToNode(UPLOAD_FILE_NAME);
		checkOutNode(UPLOAD_FILE_NAME);
		deleteDocument(UPLOAD_FILE_NAME);
	}
	
	/*case07: Delete locked node by user is not locker
	 * create node by user John: content folder
	 * lock node by user John
	 * check user mary cannot delete this node
	 */
	@Test
	public void test07_DeleteLockedNodeByUserIsNotLocker(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_BasicAction_Delete_07";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);
		
		//create new content folder by John
		goToSiteExplorer();
		info("Create new content folder by user John");
		createNewContentFolder(DATA_CONTENT_FOLDER, DATA_CONTENT_FOLDER);
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		info("Create new content folder successfully");
		
		//lock node
		lockNode(ELEMENT_CONTENT_FOLDER);
		pause(500);
		info("Lock node successfully");
		assert checkLockNode(ELEMENT_CONTENT_FOLDER):"Lock node unsuccessfully";
		driver.close();
		
		//login with user mary
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		loginEcms("mary", "gtn");
		goToSiteExplorer();
		
		//check user mary can not delete node
		rightClickOnElement(ELEMENT_CONTENT_FOLDER);
		waitForElementNotPresent(ELEMENT_MENU_DELETE);
		info("User mary cannot delete this locker node");
		logoutEcms();
		
		//delete data
		loginEcms("john", "gtn");
		goToSiteExplorer();
		deleteDocument(ELEMENT_CONTENT_FOLDER);
	}
	
	/*case09: Delete child node while parent node is being locked by user is not locker
	 * create parent node: content folder by user John
	 * create child node: article document by user John
	 * lock parent node
	 * check user Mary can delete child node
	 */
	@Test
	public void test09_DeleteChildNodeWhileParentNodeIsBeingLockedByUserIsNotLocker(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_BasicAction_Delete_content_folder_09";
		By ELEMENT_CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);
		String DATA_ARTICLE = "ECMS_DMS_SE_BasicAction_Delete_article_09";
		By ELEMENT_ARTICLE = By.linkText(DATA_ARTICLE);
		
		//create new content folder by John
		goToSiteExplorer();
		info("Create new content folder by user John");
		createNewContentFolder(DATA_CONTENT_FOLDER, DATA_CONTENT_FOLDER);
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		info("Create new content folder successfully");
		
		//create new child node in content folder: article document
		goToNode(ELEMENT_CONTENT_FOLDER);
		goToAddNewContent();
		info("Create new article document");
		createNewArticle(DATA_ARTICLE, DATA_ARTICLE, "", "");
		waitForElementPresent(ELEMENT_ARTICLE);
		
		//lock node
		goToNode(ELEMENT_CONTENT_FOLDER);
		lockNode(ELEMENT_CONTENT_FOLDER);
		info("Lock parent node");
		pause(500);
		assert checkLockNode(ELEMENT_CONTENT_FOLDER);
		driver.close();
		
		//login with mary
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		loginEcms("mary", "gtn");
		goToSiteExplorer();
		
		//check user mary can delete child node
		goToNode(ELEMENT_CONTENT_FOLDER);
		deleteDocument(ELEMENT_ARTICLE);
		info("Delete child node successfully");
		logoutEcms();
		
		//delete data
		loginEcms("john", "gtn");
		goToSiteExplorer();
		deleteDocument(ELEMENT_CONTENT_FOLDER);		
	}
	
	//case10: Delete node while user does not have remove right
	@Test()
	public void test10_DeleteNodeByUserHaveRemoveRight(){
		String DATA_CONTENT_FOLDER = "ECMS_DMS_SE_BasicAction_Delete_content_10";
		By CONTENT_FOLDER = By.linkText(DATA_CONTENT_FOLDER);
		
		//goto Site Explorer
		goToSiteExplorer();

		//Create a Content Folder
		createNewContentFolder(DATA_CONTENT_FOLDER, DATA_CONTENT_FOLDER);
		waitForElementPresent(CONTENT_FOLDER);

		//Goto System > Permissions > Uncheck Remove Right for Group *:/platform/web-contributor
		doubleClickOnElement(CONTENT_FOLDER);
		waitForElementPresent(ELEMENT_SYSTEM_TAB);
		click(ELEMENT_SYSTEM_TAB);
		waitForElementPresent(ELEMENT_PERMISSION_LINK);
		click(ELEMENT_PERMISSION_LINK);
		waitForElementPresent(WEBCONTRIBUTOR_EDIT_PERMISSIONS);
		click(WEBCONTRIBUTOR_EDIT_PERMISSIONS);
		waitForElementPresent(REMOVE_RIGHT_CHECKBOX);
		uncheck(REMOVE_RIGHT_CHECKBOX);
		save();

		waitForElementPresent(ELEMENT_CLOSE_WINDOW);
		click(ELEMENT_CLOSE_WINDOW);

		//Sign out and Sign in as mary
		logoutEcms();
		driver.get(baseUrl);
		loginEcms("mary", "gtn");
		
		//goto Site Explorer
		goToSiteExplorer();

		//Verify Deleted item not existed
		waitForElementPresent(CONTENT_FOLDER);
		rightClickOnElement(CONTENT_FOLDER);
		waitForElementNotPresent(ELEMENT_MENU_DELETE);
		
		//Delete data
		logoutEcms();
		driver.get(baseUrl);
		loginEcms("john", "gtn");
		
		//goto Site Explorer
		goToSiteExplorer();

		//Verify Deleted item not existed
		waitForElementPresent(CONTENT_FOLDER);
		deleteDocument(CONTENT_FOLDER);
	}

	//	//Delete public folder
	//	@Test()
	//	public void test16_DeletePublicDriver()
	//	{
	//		//goto Site Explorer
	//		goToSiteExplorer();
	//		
	//		//Click Show Drives > collaboration > Users 
	//		waitForElementPresent(SHOW_DRIVES_ICON);
	//		click(SHOW_DRIVES_ICON);
	//		waitForElementPresent(COLLABORATION_ICON);
	//		doubleClickOnElement(COLLABORATION_ICON_XPATH);
	//		waitForElementPresent(USERS_FOLDER);
	//		doubleClickOnElement(USERS_FOLDER_XPATH);
	//		
	//		waitForElementPresent(ADDRESS_INPUT);
	//		type(ADDRESS_INPUT, "/Users/j___/jo___/joh___/john", true);
	//		WebElement element = waitForAndGetElement(ADDRESS_INPUT);
	//		//actions.sendKeys(element, Keys.ENTER).build().perform();
	//		element.sendKeys(Keys.ENTER);
	//		
	//	}
	//	
	//	//Delete private folder
	//	@Test()
	//	public void test17_DeletePrivateDriver()
	//	{
	//		
	//	}

	@AfterMethod()
	public void afterTest()
	{
		//logoutEcms();
		driver.quit();
	}
}
