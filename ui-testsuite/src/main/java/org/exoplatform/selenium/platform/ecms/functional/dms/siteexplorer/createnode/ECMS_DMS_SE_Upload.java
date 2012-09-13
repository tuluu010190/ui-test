package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.createnode;


import java.util.concurrent.TimeUnit;

import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.exoplatform.selenium.TestLogger.*;

public class ECMS_DMS_SE_Upload extends EcmsBase {
	
	public static final String ELEMENT_USER = "john";
	public static final String ELEMENT_PASS = "gtn";
	public static final String DATA_UPLOAD_FILE_LINK = "TestData/ECMS_DMS_SE_Upload_imgfile.jpg";
	public static final String DATA_UPLOAD_FILE_DOC_LINK = "TestData/ECMS_DMS_SE_Upload_docfile.doc";
	public static final By ELEMENT_POPUP_PERMISSION = By.xpath("//div[@class='UIPopupWindow UIDragObject ExoMessageDecorator']");
	public static final By ELEMENT_MESSAGE_NO_PERMISSION = By.xpath("//span[@class='PopupIcon WarningMessageIcon']"); 
	public static final By ELEMENT_ACME_LINK = By.xpath("//a[@title='acme ']");
	public static final By ELEMENT_DOCUMENTS_LINK = By.xpath("//a[@title='documents ']");
	public static final By ELEMENT_UPLPAD_FILE_NAME_ID_2 = By.id("1name");
	public static final By ELEMENT_UPLOAD_IMG_FRAME_XPATH_2 = By.xpath("//table[@class='UIFormGrid']/tbody/tr[3]/*//iframe");
	public static final By ELEMENT_UPLOAD_FINISH_XPATH_2 = By.xpath("//div[@class='FileNameLabel'][1]");
	public static final By ELEMENT_UPLOAD_ADD_FILE = By.xpath("//img[@title='Add Upload']");
	
	
	@BeforeMethod
	  public void beforeMethods() throws Exception {
		initSeleniumTest();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	    actions = new Actions(driver);
	  }

	  @AfterMethod
	  public void afterMethods() throws Exception {
	    driver.manage().deleteAllCookies();
		driver.quit();
	    actions = null;
	  }
	
	/*Case1: Upload a file in root path
	 * login
	 * Upload File at root path
	 * check upload successfully
	 * delete uploaded file
	 * logout
	 */
	@Test
	public void test01_UploadFileInRootPath(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_01";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*Case2: Upload a file in Content folder 
	 * login
	 * create new content folde
	 * upload new file into content folder
	 * check upload successfully
	 * delete content folder
	 * logout
	 */
	@Test
	public void test02_UploadFileInContentFolder(){
		String DATA_CONTENT_FOLDER_TITLE = "Testcontentfolder_02";
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_02";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new content folder
		goToSiteExplorerForm();
		debug("Create new content folder with title: "+DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE, DATA_CONTENT_FOLDER_TITLE);
		assert isElementPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']")):"Can not create new content folder";
		info("Create new content folder successfully");
		//upload new file into content folder
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		debug("Upload new file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		pause(500);
		//check upload file successfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']")):"Can not upload file in content folder";
		info("Upload file successfully");
		//delete content folder
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		//check delete successfully
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']")):"Can not delete content folder";
		//logout
		logoutEcms();	
	}
	
	/*Case3: Upload a file in Document folder
	 * login
	 * create new document folder
	 * upload new file into document folder
	 * delete document folder
	 * logout
	 */
	@Test
	public void test03_UploadFileInDocumentFolder(){
		String DATA_DOCUMENT_FOLDER_TITLE = "Testdocumentfolder_03";
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_03";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new document folder
		goToSiteExplorerForm();
		debug("Create new document folder with title: "+DATA_DOCUMENT_FOLDER_TITLE);
		createNewDocumentFolder(DATA_DOCUMENT_FOLDER_TITLE, DATA_DOCUMENT_FOLDER_TITLE);
		assert isElementPresent(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']")):"Can not create new document folder";
		info("Create new document folder successfully");
		//upload new file into document folder
		goToNode(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		debug("Upload new file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		pause(500);
		//check upload file successfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']")):"Can not upload file in document folder";
		info("Upload file successfully");
		//delete document folder
		goToNode(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		//check delete successfully
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']")):"Can not delete document folder";
		//logout
		logoutEcms();
	}
	
	/*Case4: Upload a file in document 
	 * login
	 * Create a document which allows upload files: article
	 * upload new file into article
	 * delete article
	 * logout
	 */
	@Test
	public void test04_UploadFileInDocument(){
		String DATA_ARTICLE_TITLE = "Testarticle_04";
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_04";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new article
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new article with title: "+DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, "", "");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']")):"Can not create new article";
		info("Create new article successfully");
		//upload new file into article document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		pause(500);
		//check upload file successfully
		checkPreferenceOption("enableStructure");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']")):"Can not upload file in article";
		info("Upload file successfully");
		//delete article document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		//check delete successfully
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']")):"Can not delete article document";
		//logout
		logoutEcms();
	}
	
	/*Case7: Upload a file in path is in 'check in' status
	 * login
	 * Create node (document except nt:file, folder): article
	 * check in node
	 * check can not upload new file to check in node
	 * check out node
	 * delete node
	 * logout
	 */
	@Test
	public void test07_UploadFileInNodeCheckIn(){
		String DATA_ARTICLE_DOCUMENT_TITLE = "Testarticle_07";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new node: article document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new content folder with title: "+DATA_ARTICLE_DOCUMENT_TITLE);
		createNewArticle(DATA_ARTICLE_DOCUMENT_TITLE, DATA_ARTICLE_DOCUMENT_TITLE,"","");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']")):"Can not create new article document";
		info("Create new article successfully");
		//check in article document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		checkInNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		pause(500);
		//check can not upload file in checked in Node
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		assert isElementNotPresent(ELEMENT_UPLOAD_LINK_XPATH):"Upload link is still available";
		info("Can not upload new file into a Node has been checked in");
		//check out article document
		checkOutNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		//delete article document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		//check delete success
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']")):"Can not delete article document";
		//logout
		logoutEcms();
		
	}
	
	/*Case8: Upload file in a node has parent node is in 'Check in' status
	 * login
	 * create parent node: article document
	 * create child node: kofax document
	 * check in parent node
	 * check can upload file in child node
	 * check out parent node
	 * delete parent node
	 * logout
	 */
	@Test
	public void test08_UploadFileInNodeHasParentNodeCheckin(){
		String DATA_ARTICLE_DOCUMENT_TITLE = "Testarticle_08";
		String DATA_KOFAX_DOCUMENT_NAME = "Testkofax_08";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new parent node: article document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new parent node (article document) with title: "+DATA_ARTICLE_DOCUMENT_TITLE);
		createNewArticle(DATA_ARTICLE_DOCUMENT_TITLE, DATA_ARTICLE_DOCUMENT_TITLE,"","");
		pause(500);
		assert isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']")):"Can not create new article document";
		info("Create new parent node (article document) successfully");
		//create child node: kofax document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		goToAddNewContent();
		debug("Create new child node (kofax document) with name: "+ DATA_KOFAX_DOCUMENT_NAME);
		createNewKofax(DATA_KOFAX_DOCUMENT_NAME);
		pause(500);
		checkPreferenceOption("enableStructure");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_KOFAX_DOCUMENT_NAME+" "+"']")):"Can not create new kofax document";
		info("create new child node in parent node successfully");
		//check in parent node
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		checkInNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		//check can upload file in child node
		goToNode(By.xpath("//a[@title='"+DATA_KOFAX_DOCUMENT_NAME+" "+"']"));
		assert isElementPresent(ELEMENT_UPLOAD_LINK_XPATH):"Upload link is not available";
		info("Can upload file in child node");
		//check out parent node
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		checkOutNode(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		pause(500);
		//delete parent node
		deleteDocument(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']"));
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']")):"Can not delete parent node";
		//logout
		logoutEcms();
	}
	
	/*case9: Upload a file when user does not have add node right
	 * login with john
	 * create new node: content folder
	 * set permission for user Mary, has not add node permission
	 * login with mary
	 * check can not upload file into node
	 * login with john
	 * delete node
	 * logout
	 */
	@Test
	public void test09_UploadFileUserNotPermission(){
		String DATA_CONTENT_FOLDER_TITLE = "Testcontentfolder_09";
		
		//login with user John
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new content
		goToSiteExplorerForm();
		debug("Create new node (content folder) with title: "+DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE, DATA_CONTENT_FOLDER_TITLE);
		waitForElementPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		assert isElementPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']")):"Can not crate new content folder";
		//set permission for user Mary: has not add node permission
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		setPermissionAddNodeForUser("mary",1,1);
		logoutEcms();
		//login with user Mary
		driver.get(DEFAULT_BASEURL);
		loginEcms("mary", ELEMENT_PASS);
		goToSiteExplorerForm();
		//check can not upload file into node
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		click(ELEMENT_UPLOAD_LINK_XPATH);
		//check can not uplpoad file
		assert isElementPresent(ELEMENT_POPUP_PERMISSION);
		assert getText(ELEMENT_MESSAGE_NO_PERMISSION).contains("You do not have permission to add a new node.");
		info("Check user does not have add not permission: true");
		click(By.linkText("OK"));
		logoutEcms();
		//delete Uploaded file with John
		driver.get(DEFAULT_BASEURL);
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		goToSiteExplorerForm();
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		//check delete successfully
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']")):"Can not delete content folder";
		logoutEcms();	
	}
	
	/*case11: Upload a file in locked node by user is not locker
	 * login with user John
	 * create new node: content folder
	 * lock node
	 * login with user Mary in other driver
	 * check can not upload file to content folder
	 * on driver with user John: delete node
	 * logout
	 */
//	@Test
//	public void test11_UploadFileToLockedNode(){
//		String DATA_CONTENT_FOLDER_TITLE = "Testcontentfolder_11";
//		
//		//login by John
//		loginEcms(ELEMENT_USER, ELEMENT_PASS);
//		//create new content folder
//		goToSiteExplorerForm();
//		goToNode("//a[@title='acme ']");
//		goToNode("//a[@title='documents ']");
//		pause(500);
//		debug("Create new node (content folder) with title: "+DATA_CONTENT_FOLDER_TITLE);
//		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE, DATA_CONTENT_FOLDER_TITLE);
//		waitForElementPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
//		assert isElementPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"):"Can not crate new content folder";
//		//lock node
//		lockNode("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
//		goToNode("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]");
//		pause(1000);
//		assert checkLockNode("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]"):"Can not lock node";
//		//open new session with user mary
//		info("login by user mery");
//		initSeleniumTest();
//	    driver.get(baseUrl);
//		loginEcms("mary",ELEMENT_PASS );
//		goToSiteExplorerForm();
//		goToNode("//a[@title='acme ']");
//		goToNode("//a[@title='documents ']");
//		goToNode("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
//		click(ELEMENT_UPLOAD_LINK_XPATH);
//		//check can not uplpoad file
//		assert isElementPresent(ELEMENT_POPUP_PERMISSION);
//		assert getText(ELEMENT_MESSAGE_NO_PERMISSION).contains("You do not have permission to add a new node.");
//		info("Check user does not have add not permission: true");
//		click(By.linkText("OK"));
//		logoutEcms();
//		driver.quit();
//		//delete content folder with user John
//		goToNode("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
//		deleteDocument("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
//		pause(500);
//		//check delete successfully
//		waitForElementNotPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
//		assert isElementNotPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"):"Can not delete content folder";
//		logoutEcms();
//	}
	
	/*case12: Upload a file is image file
	 * login
	 * upload a image file: jpg file
	 * check upload successfully
	 * delete file
	 * logout
	 */
	@Test
	public void test12_UploadImageFile(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_12";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*Case13: Upload a file is Microsoft office file
	 * login
	 * upload Microsoft office: doc file
	 * check upload successfully
	 * delete file
	 * logout
	 */
	@Test
	public void test13_UploadMicrosoftOfficeFile(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_13";
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*Case14: Upload a file is open office file
	 * login
	 * upload open office: ods file
	 * check upload successfully
	 * delete file
	 * logout
	 */
	@Test
	public void test14_UploadOpentOfficeFile(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_14";
		String DATA_UPLOAD_HTML_LINK = "TestData/ECMS_DMS_SE_Upload_odsfile.ods";
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_HTML_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".ods "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".ods "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".ods "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".ods "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".ods "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*case15: Upload a file is .PDF file
	 * login
	 * upload pdf file
	 * check upload successfully
	 * delete file
	 * logout
	 */
	@Test
	public void test15_UploadPdfFile(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_15";
		String DATA_UPLOAD_PDF_LINK = "TestData/ECMS_DMS_SE_Upload_pdffile.pdf";
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_PDF_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".pdf "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".pdf "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".pdf "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".pdf "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".pdf "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*case16: Upload a file is .html file
	 * login
	 * upload a html file
	 * check upload successfully
	 *  delete file
	 *  logout
	 */
	@Test
	public void test16_UploadHtmlFile(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_16";
		String DATA_UPLOAD_HTML_LINK = "TestData/ECMS_DMS_SE_Upload_htmlfile.html";
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_HTML_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".html "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".html "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".html "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".html "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".html "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*case17: Upload a file is .xml file
	 * login
	 * upload a xml file
	 * check upload successfully
	 *  delete file
	 *  logout 
	 */
	@Test
	public void test17_UploadXmlFile(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_17";
		String DATA_UPLOAD_XML_LINK = "TestData/ECMS_DMS_SE_Upload_xmlfile.xml";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_XML_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".xml "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".xml "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".xml "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".xml "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".xml "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*case18: Upload a file is .exe file
	 * login
	 * upload a exe file
	 * check upload successfully
	 *  delete file
	 *  logout
	 */
	@Test
	public void test18_UploadExeFile(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_18";
		String DATA_UPLOAD_EXE_LINK = "TestData/ECMS_DMS_SE_Upload_exefile.exe";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_EXE_LINK);
		//check upload sucessfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+" "+"']")):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+" "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+" "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+" "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+" "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*case19: Upload a file and put data in 'Name' field
	 * login
	 * upload a file in acme/document
	 * File is uploaded in selected path with name is value in 'Name' field
	 * delete file 
	 * logout
	 */
	@Test
	public void test19_UploadFilePutNameField(){
		String DATA_UPLOAD_FILE_NAME = "Testuploadfile_19";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		goToNode(ELEMENT_ACME_LINK);
		goToNode(ELEMENT_DOCUMENTS_LINK);
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		pause(1000);
		//check File is uploaded in selected path with name is value in 'Name' field
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not upload new file";
		assert waitForAndGetElement(By.id("address")).getAttribute("value").contains("/acme/documents/"+DATA_UPLOAD_FILE_NAME+".doc"):"Can not upload new file";
		info("File is uploaded in selected path with name is value in 'Name' field");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*case21:
	 * login
	 * upload file with name contains special characters: #@$&%^*()!<>?
	 * check upload successfully
	 * delete file
	 * logout
	 */
	@Test
	public void test21_UploadFileHasNameContainsSpecialCharacter(){
		String DATA_UPLOAD_FILE_NAME = "Test#@$&%^*()!<>?";
		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		pause(500);
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		//check File is uploaded in selected path with name is value in 'Name' field
		assert isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not upload new file";
		info("Upload file successful");
		//delete uploaded file
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']"));
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']")):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}
	
	/*case24: Upload multi file at the same time
	 * login
	 * upload 2 file in one time
	 * check upload sccessfully
	 * delete 2 file
	 * logout
	 */
	@Test
	public void test24_UploadMultiFileSameTime(){
		String DATA_FILE_IMG_NAME = "Testimgfile_24";
		String DATA_FILE_DOC_NAME = "Testdoc_24";

		
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//choose 1 file .jpg
		goToSiteExplorerForm();
		click(ELEMENT_UPLOAD_LINK_XPATH);
		type(ELEMENT_UPLOAD_FILE_NAME_ID,DATA_FILE_IMG_NAME,false);
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_IMG_FRAME_XPATH));
		type(ELEMENT_UPLOAD_IMG_ID,getAbsoluteFilePath(DATA_UPLOAD_FILE_LINK),false);
		switchToParentWindow();
		waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
		//choose 1 file .doc
		click(ELEMENT_UPLOAD_ADD_FILE);
		type(ELEMENT_UPLPAD_FILE_NAME_ID_2,DATA_FILE_DOC_NAME,false);
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_IMG_FRAME_XPATH_2));
		type(ELEMENT_UPLOAD_IMG_ID,getAbsoluteFilePath(DATA_UPLOAD_FILE_DOC_LINK),false);
		switchToParentWindow();
		waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH_2);
		
		click(ELEMENT_UPLOAD_SAVE_BUTTON_LINKTEXT);
		click(ELEMENT_UPLOAD_CLOSE_BUTTON_LINKTEXT);
		//check upload file successful
		waitForElementPresent(By.xpath("//a[@title='"+DATA_FILE_IMG_NAME+".jpg "+"']"));
		assert isElementPresent(By.xpath("//a[@title='"+DATA_FILE_IMG_NAME+".jpg "+"']")):"Can not upload file .jpg";
		assert isElementPresent(By.xpath("//a[@title='"+DATA_FILE_DOC_NAME+".doc "+"']")):"Can not upload file .doc";
		info("Upload multi file successfully");
		//delete file
		goToNode(By.xpath("//a[@title='"+DATA_FILE_IMG_NAME+".jpg "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_IMG_NAME+".jpg "+"']"));
		pause(500);
		goToNode(By.xpath("//a[@title='"+DATA_FILE_DOC_NAME+".doc "+"']"));
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_DOC_NAME+".doc "+"']"));
		//check delete success
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_FILE_DOC_NAME+".doc "+"']"));
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_FILE_DOC_NAME+".doc "+"']")):"Can not delete file .doc";
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_FILE_IMG_NAME+".jpg "+"']")):"Can not delete file .jpg";
		//logout
		logoutEcms();
		
	}
}
