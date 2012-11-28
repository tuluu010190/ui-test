package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.basicaction;

import static org.exoplatform.selenium.platform.ecms.ActionBar.*;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.*;
import static org.exoplatform.selenium.platform.ecms.ContextMenu.*;
import static org.exoplatform.selenium.platform.ecms.SiteExplorer.*;

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

public class ECMS_DMS_SE_BasicAction_Clipboard extends EcmsBase 
{
	//Define data
	public String DATA_CONTENT_FOLDER = "ContentFolder_Clipboard";
	public String DATA_DOCUMENT_FOLDER = "DocumentFolder_Clipboard";
	public String DATA_KOFAX_NAME = "Kofax Name";
	public String DATA_UPLOAD_FILE_NAME = "Uploaded_Image";
	public String DATA_UPLOAD_FILE_PATH ="TestData/Winter.jpg";

	public By CONTENT_FOLDER = By.xpath("//div[@title='"+DATA_CONTENT_FOLDER+"']");
	public By DOCUMENT_FOLDER = By.xpath("//div[@title='"+DATA_DOCUMENT_FOLDER+"']");
	public By KOFAX_DISPLAY = By.xpath("//td[text()='"+DATA_KOFAX_NAME+"']");
	public By KOFAX_DOCUMENT = By.xpath("//div[@title='"+DATA_KOFAX_NAME+"']");
	public By UPLOAD_FILE_NAME = By.xpath("//div[@title='"+DATA_UPLOAD_FILE_NAME+".jpg']");

	public By CLIPBOARD_CONTENT_FOLDER_PATH = By.xpath("//td[contains(@title, '" + DATA_CONTENT_FOLDER + "')]");
	public By CLIPBOARD_CONTENT_FOLDER_CM = By.xpath("//td[contains(@title, '" + DATA_CONTENT_FOLDER +"')]/../td[text()='copy']");
	public By CLIPBOARD_DOCUMENT_FOLDER_PATH = By.xpath("//td[contains(@title, '" + DATA_DOCUMENT_FOLDER +"')]");
	public By CLIPBOARD_DOCUMENT_FOLDER_CM = By.xpath("//td[contains(@title, '" + DATA_DOCUMENT_FOLDER +"')]/../td[text()='cut']");
	public By CLIPBOARD_KOFAX_PATH = By.xpath("//td[contains(@title, '" + DATA_KOFAX_NAME +"')]");
	public By CLIPBOARD_KOFAX_CM = By.xpath("//td[contains(@title, '" + DATA_KOFAX_NAME +"')]/../td[text()='copy']");
	public By CLIPBOARD_UPLOAD_FILE_PATH = By.xpath("//td[contains(@title, '" + DATA_UPLOAD_FILE_NAME +".jpg')]");
	public By CLIPBOARD_UPLOAD_FILE_CM = By.xpath("//td[contains(@title, '" + DATA_UPLOAD_FILE_NAME +".jpg')]/../td[text()='cut']");
	public By CLEAR_ALL_ICON = By.xpath("//a[contains(text(),'Clear All')]");
	public By CLEAR_ALL_MESSAGE = By.xpath("//div[contains(text(),'There are no items in the clipboard.')]");

	@BeforeMethod()
	public void beforeTest()
	{
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		loginEcms("john", "gtn");
	}

	//Delete  all action in clipboard
	@Test()
	public void test020_DeleteActionInClipboard()
	{
		//goto Site Explorer
		goToSiteExplorer();

		//Create & Copy a Content Folder
		createNewContentFolder(DATA_CONTENT_FOLDER, DATA_CONTENT_FOLDER);
		waitForElementPresent(CONTENT_FOLDER);
		copyNode(CONTENT_FOLDER);

		//Create & Cut a Document Folder
		createNewDocumentFolder(DATA_DOCUMENT_FOLDER, DATA_DOCUMENT_FOLDER);
		waitForElementPresent(DOCUMENT_FOLDER);
		cutNode(DOCUMENT_FOLDER);

		//Create & Copy a File Document
		goToAddNewContent();
		createNewKofax(DATA_KOFAX_NAME);
		waitForAndGetElement(KOFAX_DISPLAY);
		click(ELEMENT_SIDEBAR_SITES_MANAGEMENT);
		waitForElementPresent(KOFAX_DOCUMENT);
		copyNode(KOFAX_DOCUMENT);

		//Upload & Cut a File
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_PATH);
		waitForElementPresent(UPLOAD_FILE_NAME);
		cutNode(UPLOAD_FILE_NAME);

		//Select acme > documents node
		doubleClickOnElement(ELEMENT_SIDEBAR_ACME);
		waitForElementPresent(ELEMENT_SIDEBAR_ACME_DOCUMENTS);
		doubleClickOnElement(ELEMENT_SIDEBAR_ACME_DOCUMENTS);

		//Click on Clipboard
		waitForElementPresent(ELEMENT_CLIPBOARD_ICON);
		click(ELEMENT_CLIPBOARD_ICON);

		//Verify Path & Cm of Nodes
		waitForElementPresent(CLIPBOARD_CONTENT_FOLDER_PATH);
		waitForElementPresent(CLIPBOARD_CONTENT_FOLDER_CM);
		waitForElementPresent(CLIPBOARD_DOCUMENT_FOLDER_PATH);
		waitForElementPresent(CLIPBOARD_DOCUMENT_FOLDER_CM);
		waitForElementPresent(CLIPBOARD_KOFAX_PATH);
		waitForElementPresent(CLIPBOARD_KOFAX_CM);
		waitForElementPresent(CLIPBOARD_UPLOAD_FILE_PATH);
		waitForElementPresent(CLIPBOARD_UPLOAD_FILE_CM);

		//Clear all action in list
		click(CLEAR_ALL_ICON);
		waitForElementPresent(CLEAR_ALL_MESSAGE);

		//Delete data
		click(ELEMENT_SIDEBAR_FILE_EXPLORER);
		waitForElementPresent(ELEMENT_SIDEBAR_SITES_MANAGEMENT);
		click(ELEMENT_SIDEBAR_SITES_MANAGEMENT);
		waitForElementPresent(CONTENT_FOLDER);
		deleteDocument(CONTENT_FOLDER);
		waitForElementPresent(DOCUMENT_FOLDER);
		deleteDocument(DOCUMENT_FOLDER);
		waitForElementPresent(KOFAX_DOCUMENT);
		deleteDocument(KOFAX_DOCUMENT);
		waitForElementPresent(UPLOAD_FILE_NAME);
		deleteDocument(UPLOAD_FILE_NAME);
	}

	@AfterMethod()
	public void afterTest()
	{
		//logoutEcms();
		driver.quit();
	}
}
