package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.createnode;


//import java.util.concurrent.TimeUnit;

import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.exoplatform.selenium.TestLogger.*;

/*
 * @author: Lientm
 * @date: 9/2012
 */

public class ECMS_DMS_SE_Upload extends EcmsBase {
	
	public static final String DATA_USER = "john";
	public static final String DATA_PASS = "gtn";
	
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
	    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
	
	/*Case1: Upload a file in root path
	 * Upload File at root path
	 * check upload successfully
	 * delete uploaded file
	 */
	@Test
	public void test01_UploadFileInRootPath(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_01";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']");
		
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		//check upload successfully
		assert isElementPresent(ELEMENT_UPLOAD_FILE):"Can not upload new file";
		info("Upload new file is successful");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD_FILE);
		deleteDocument(ELEMENT_UPLOAD_FILE);
		waitForElementNotPresent(ELEMENT_UPLOAD_FILE);
	}
	
	/*Case2: Upload a file in Content folder 
	 * create new content folder
	 * upload new file into content folder
	 * check upload successfully
	 * delete content folder
	 */
	@Test
	public void test02_UploadFileInContentFolder(){
		String DATA_CONTENT_FOLDER_TITLE = "ECMS_DMS_SE_Upload_contentfolder_02";
		By ELEMENT_CONTENT_FOLDER = By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_02";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		
		//create new content folder
		goToSiteExplorerForm();
		debug("Create new content folder with title: "+DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE, DATA_CONTENT_FOLDER_TITLE);
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"Can not create new content folder";
		info("Create new content folder successfully");
		//upload new file into content folder
		goToNode(ELEMENT_CONTENT_FOLDER);
		debug("Upload new file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		//check upload file successfully
		assert isElementPresent(ELEMENT_UPLOAD_FILE):"Can not upload file in content folder";
		info("Upload file is successful");
		//delete content folder
		goToNode(ELEMENT_CONTENT_FOLDER);
		deleteDocument(ELEMENT_CONTENT_FOLDER);
		waitForElementNotPresent(ELEMENT_CONTENT_FOLDER);	
	}
	
	/*Case3: Upload a file in Document folder
	 * create new document folder
	 * upload new file into document folder
	 * delete document folder
	 */
	@Test
	public void test03_UploadFileInDocumentFolder(){
		String DATA_DOCUMENT_FOLDER_TITLE = "ECMS_DMS_SE_Upload_documentfolder_03";
		By ELEMENT_DOCUMENT_FOLDER = By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']");
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_03";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		
		//create new document folder
		goToSiteExplorerForm();
		debug("Create new document folder with title: "+DATA_DOCUMENT_FOLDER_TITLE);
		createNewDocumentFolder(DATA_DOCUMENT_FOLDER_TITLE, DATA_DOCUMENT_FOLDER_TITLE);
		waitForElementPresent(ELEMENT_DOCUMENT_FOLDER);
		assert isElementPresent(ELEMENT_DOCUMENT_FOLDER):"Can not create new document folder";
		info("Create new document folder is successful");
		//upload new file into document folder
		goToNode(ELEMENT_DOCUMENT_FOLDER);
		debug("Upload new file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		//check upload file successfully
		assert isElementPresent(ELEMENT_UPLOAD_FILE):"Can not upload file in document folder";
		info("Upload file is successful");
		//delete document folder
		goToNode(ELEMENT_DOCUMENT_FOLDER);
		deleteDocument(ELEMENT_DOCUMENT_FOLDER);
		waitForElementNotPresent(ELEMENT_DOCUMENT_FOLDER);
	}
	
	/*Case4: Upload a file in document 
	 * Create a document which allows upload files: article
	 * upload new file into article
	 * delete article
	 */
	@Test
	public void test04_UploadFileInDocument(){
		String DATA_ARTICLE_TITLE = "ECMS_DMS_SE_Upload_article_04";
		By ELEMENT_ARTICLE =By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']") ;
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_04";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		
		//create new article
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new article with title: "+DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, "", "");
		waitForElementPresent(ELEMENT_ARTICLE);
		assert isElementPresent(ELEMENT_ARTICLE):"Can not create new article";
		info("Create new article is successful");
		//upload new file into article document
		goToNode(ELEMENT_ARTICLE);
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		//check upload file successfully
		checkPreferenceOption("enableStructure");
		goToNode(ELEMENT_ARTICLE);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		assert isElementPresent(ELEMENT_UPLOAD_FILE):"Can not upload file in article";
		info("Upload file successfully");
		//delete article document
		goToNode(ELEMENT_ARTICLE);
		deleteDocument(ELEMENT_ARTICLE);
		waitForElementNotPresent(ELEMENT_ARTICLE);
	}
	
	/*Case7: Upload a file in path is in 'check in' status
	 * Create node (document except nt:file, folder): article
	 * check in node
	 * check can not upload new file to check in node
	 * check out node
	 * delete node
	 */
	@Test
	public void test07_UploadFileInNodeCheckIn(){
		String DATA_ARTICLE_DOCUMENT_TITLE = "ECMS_DMS_SE_Upload_article_07";
		By ELEMENT_ARTICLE = By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']");

		//create new node: article document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new content folder with title: "+DATA_ARTICLE_DOCUMENT_TITLE);
		createNewArticle(DATA_ARTICLE_DOCUMENT_TITLE, DATA_ARTICLE_DOCUMENT_TITLE,"","");
		waitForElementPresent(ELEMENT_ARTICLE);
		assert isElementPresent(ELEMENT_ARTICLE):"Can not create new article document";
		info("Create new article successfully");
		//check in article document
		goToNode(ELEMENT_ARTICLE);
		checkInNode(ELEMENT_ARTICLE);
		//check can not upload file in checked in Node
		goToNode(ELEMENT_ARTICLE);
		waitForElementNotPresent(ELEMENT_UPLOAD_LINK_XPATH);
		info("Can not upload new file into a Node has been checked in");
		//check out article document
		checkOutNode(ELEMENT_ARTICLE);
		//delete article document
		goToNode(ELEMENT_ARTICLE);
		deleteDocument(ELEMENT_ARTICLE);
		waitForElementNotPresent(ELEMENT_ARTICLE);
		
	}
	
	/*Case8: Upload file in a node has parent node is in 'Check in' status
	 * create parent node: article document
	 * create child node: kofax document
	 * check in parent node
	 * check can upload file in child node
	 * check out parent node
	 * delete parent node
	 */
	@Test
	public void test08_UploadFileInNodeHasParentNodeCheckin(){
		String DATA_ARTICLE_DOCUMENT_TITLE = "ECMS_DMS_SE_Upload_article_08";
		By ELEMENT_ARTICLE = By.xpath("//a[@title='"+DATA_ARTICLE_DOCUMENT_TITLE+" "+"']");
		String DATA_KOFAX_DOCUMENT_NAME = "ECMS_DMS_SE_Upload_kofax_08";
		By ELEMENT_KOFAX = By.xpath("//a[@title='"+DATA_KOFAX_DOCUMENT_NAME+" "+"']");
		
		//create new parent node: article document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new parent node (article document) with title: "+DATA_ARTICLE_DOCUMENT_TITLE);
		createNewArticle(DATA_ARTICLE_DOCUMENT_TITLE, DATA_ARTICLE_DOCUMENT_TITLE,"","");
		waitForElementPresent(ELEMENT_ARTICLE);
		assert isElementPresent(ELEMENT_ARTICLE):"Can not create new article document";
		info("Create new parent node (article document) successfully");
		//create child node: kofax document
		goToNode(ELEMENT_ARTICLE);
		goToAddNewContent();
		debug("Create new child node (kofax document) with name: "+ DATA_KOFAX_DOCUMENT_NAME);
		createNewKofax(DATA_KOFAX_DOCUMENT_NAME);
		checkPreferenceOption("enableStructure");
		goToNode(ELEMENT_ARTICLE);
		waitForElementPresent(ELEMENT_KOFAX);
		assert isElementPresent(ELEMENT_KOFAX):"Can not create new kofax document";
		info("create new child node in parent node successfully");
		//check in parent node
		goToNode(ELEMENT_ARTICLE);
		checkInNode(ELEMENT_ARTICLE);
		//check can upload file in child node
		goToNode(ELEMENT_ARTICLE);
		waitForElementNotPresent(ELEMENT_UPLOAD_LINK_XPATH);
		info("Can upload file in child node");
		//check out parent node
		goToNode(ELEMENT_ARTICLE);
		checkOutNode(ELEMENT_ARTICLE);
		//delete parent node
		deleteDocument(ELEMENT_ARTICLE);
		waitForElementNotPresent(ELEMENT_ARTICLE);
	}
	
	/*case9: Upload a file when user does not have add node right
	 * login with john
	 * create new node: content folder
	 * set permission for user Mary, has not add node permission
	 * login with mary
	 * check can not upload file into node
	 * login with john
	 * delete node
	 */
	@Test
	public void test09_UploadFileUserNotPermission(){
		String DATA_CONTENT_FOLDER_TITLE = "ECMS_DMS_SE_Upload_contentfolder_09";
		By ELEMENT_CONTENT_FOLDER = By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");

		//create new content
		goToSiteExplorerForm();
		debug("Create new node (content folder) with title: "+DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE, DATA_CONTENT_FOLDER_TITLE);
		waitForElementPresent(ELEMENT_CONTENT_FOLDER);
		assert isElementPresent(ELEMENT_CONTENT_FOLDER):"Can not crate new content folder";
		//set permission for user Mary: has not add node permission
		goToNode(ELEMENT_CONTENT_FOLDER);
		setPermissionAddNodeForUser("mary",1,1);
		logoutEcms();
		//login with user Mary
		driver.get(DEFAULT_BASEURL);
		loginEcms("mary", DATA_PASS);
		goToSiteExplorerForm();
		//check can not upload file into node
		goToNode(ELEMENT_CONTENT_FOLDER);
		click(ELEMENT_UPLOAD_LINK_XPATH);
		//check can not upload file
		assert isElementPresent(ELEMENT_POPUP_PERMISSION);
		assert getText(ELEMENT_MESSAGE_NO_PERMISSION).contains("You do not have permission to add a new node.");
		info("Check user does not have add not permission: true");
		click(By.linkText("OK"));
		logoutEcms();
		//delete Uploaded file with John
		driver.get(DEFAULT_BASEURL);
		loginEcms(DATA_USER, DATA_PASS);
		goToSiteExplorerForm();
		goToNode(ELEMENT_CONTENT_FOLDER);
		deleteDocument(ELEMENT_CONTENT_FOLDER);
		waitForElementNotPresent(ELEMENT_CONTENT_FOLDER);	
	}
	
	/*case11: Upload a file in locked node by user is not locker
	 * create new node: content folder
	 * lock node
	 * login with user Mary in other driver
	 * check can not upload file to content folder
	 * on driver with user John: delete node
	 */
//	@Test
//	public void test11_UploadFileToLockedNode(){
//		String DATA_CONTENT_FOLDER_TITLE = "Testcontentfolder_11";
//		
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
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_12";
		By ELEMENT_UPLOAD = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		waitForElementPresent(ELEMENT_UPLOAD);
		//check upload successfully
		assert isElementPresent(ELEMENT_UPLOAD):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD);
		deleteDocument(ELEMENT_UPLOAD);
		waitForElementNotPresent(ELEMENT_UPLOAD);
	}
	
	/*Case13: Upload a file is Microsoft office file
	 * upload Microsoft office: doc file
	 * check upload successfully
	 * delete file
	 */
	@Test
	public void test13_UploadMicrosoftOfficeFile(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_loadfile_13";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']");

		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		//check upload successfully
		assert isElementPresent(ELEMENT_UPLOAD_FILE):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD_FILE);
		deleteDocument(ELEMENT_UPLOAD_FILE);
		waitForElementNotPresent(ELEMENT_UPLOAD_FILE);
	}
	
	/*Case14: Upload a file is open office file
	 * upload open office: ods file
	 * check upload successfully
	 * delete file
	 */
	@Test
	public void test14_UploadOpentOfficeFile(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_14";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".ods "+"']");
		String DATA_UPLOAD_HTML_LINK = "TestData/ECMS_DMS_SE_Upload_odsfile.ods";

		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_HTML_LINK);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		//check upload successfully
		assert isElementPresent(ELEMENT_UPLOAD_FILE):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD_FILE);
		deleteDocument(ELEMENT_UPLOAD_FILE);
		waitForElementNotPresent(ELEMENT_UPLOAD_FILE);

	}
	
	/*case15: Upload a file is .PDF file
	 * upload pdf file
	 * check upload successfully
	 * delete file
	 */
	@Test
	public void test15_UploadPdfFile(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_15";
		By ELEMENT_UPLOAD = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".pdf "+"']");
		String DATA_UPLOAD_PDF_LINK = "TestData/ECMS_DMS_SE_Upload_pdffile.pdf";

		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_PDF_LINK);
		//check upload successfully
		assert isElementPresent(ELEMENT_UPLOAD):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD);
		deleteDocument(ELEMENT_UPLOAD);
		waitForElementNotPresent(ELEMENT_UPLOAD);
	}
	
	/*case16: Upload a file is .html file
	 * upload a html file
	 * check upload successfully
	 *  delete file
	 */
	@Test
	public void test16_UploadHtmlFile(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_16";
		By ELEMENT_UPLOAD = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".html "+"']");
		String DATA_UPLOAD_HTML_LINK = "TestData/ECMS_DMS_SE_Upload_htmlfile.html";

		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_HTML_LINK);
		waitForElementPresent(ELEMENT_UPLOAD);
		//check upload successfully
		assert isElementPresent(ELEMENT_UPLOAD):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD);
		deleteDocument(ELEMENT_UPLOAD);
		waitForElementNotPresent(ELEMENT_UPLOAD);
	}
	
	/*case17: Upload a file is .xml file
	 * upload a xml file
	 * check upload successfully
	 *  delete file
	 */
	@Test
	public void test17_UploadXmlFile(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_17";
		By ELEMENT_UPLOAD = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".xml "+"']");
		String DATA_UPLOAD_XML_LINK = "TestData/ECMS_DMS_SE_Upload_xmlfile.xml";
		
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_XML_LINK);
		waitForElementPresent(ELEMENT_UPLOAD);
		//check upload successfully
		assert isElementPresent(ELEMENT_UPLOAD):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD);
		deleteDocument(ELEMENT_UPLOAD);
		waitForElementNotPresent(ELEMENT_UPLOAD);
	}
	
	/*case18: Upload a file is .exe file
	 * upload a exe file
	 * check upload successfully
	 *  delete file
	 */
	@Test
	public void test18_UploadExeFile(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_18";
		By ELEMENT_UPLOAD = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+" "+"']");
		String DATA_UPLOAD_EXE_LINK = "TestData/ECMS_DMS_SE_Upload_exefile.exe";
		
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_EXE_LINK);
		waitForElementPresent(ELEMENT_UPLOAD);
		//check upload sucessfully
		assert isElementPresent(ELEMENT_UPLOAD):"Can not upload new file";
		info("Upload new file successfully");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD);
		deleteDocument(ELEMENT_UPLOAD);
		waitForElementNotPresent(ELEMENT_UPLOAD);
	}
	
	/*case19: Upload a file and put data in 'Name' field
	 * upload a file in acme/document
	 * File is uploaded in selected path with name is value in 'Name' field
	 * delete file 
	 */
	@Test
	public void test19_UploadFilePutNameField(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_uploadfile_19";
		By ELEMENT_UPLOAD = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']");
		
		//Upload file
		goToSiteExplorerForm();
		goToNode(ELEMENT_ACME_LINK);
		goToNode(ELEMENT_DOCUMENTS_LINK);
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		waitForElementPresent(ELEMENT_UPLOAD);
		goToNode(ELEMENT_UPLOAD);
		//check File is uploaded in selected path with name is value in 'Name' field
		assert isElementPresent(ELEMENT_UPLOAD):"Can not upload new file";
		info("File is uploaded in selected path with name is value in 'Name' field");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD);
		deleteDocument(ELEMENT_UPLOAD);
		waitForElementNotPresent(ELEMENT_UPLOAD);
	}
	
	/*case21:
	 * upload file with name contains special characters: #@$&%^*()!<>?
	 * check upload successfully
	 * delete file
	 */
	@Test
	public void test21_UploadFileHasNameContainsSpecialCharacter(){
		String DATA_UPLOAD_FILE_NAME = "ECMS_DMS_SE_Upload_t#@$&%^*()!<>?";
		By ELEMENT_UPLOAD = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']");
		
		//Upload file
		goToSiteExplorerForm();
		debug("Upload file with name: "+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_DOC_LINK);
		waitForElementPresent(ELEMENT_UPLOAD);
		//check File is uploaded in selected path with name is value in 'Name' field
		assert isElementPresent(ELEMENT_UPLOAD):"Can not upload new file";
		info("Upload file successful");
		//delete uploaded file
		goToNode(ELEMENT_UPLOAD);
		deleteDocument(ELEMENT_UPLOAD);
		waitForElementNotPresent(ELEMENT_UPLOAD);
	}
	
	/*case24: Upload multi file at the same time
	 * upload 2 file in one time
	 * check upload sccessfully
	 * delete 2 file
	 */
	@Test
	public void test24_UploadMultiFileSameTime(){
		String DATA_FILE_IMG_NAME = "ECMS_DMS_SE_Upload_imgfile_24";
		By ELEMENT_FILE_IMG = By.xpath("//a[@title='"+DATA_FILE_IMG_NAME+".jpg "+"']");
		String DATA_FILE_DOC_NAME = "ECMS_DMS_SE_Upload_doc_24";
		By ELEMENT_FILE_DOC = By.xpath("//a[@title='"+DATA_FILE_DOC_NAME+".doc "+"']");

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
		waitForElementPresent(ELEMENT_FILE_IMG);
		assert isElementPresent(ELEMENT_FILE_IMG):"Can not upload file .jpg";
		assert isElementPresent(ELEMENT_FILE_DOC):"Can not upload file .doc";
		info("Upload multi file successfully");
		//delete file
		goToNode(ELEMENT_FILE_IMG);
		deleteDocument(ELEMENT_FILE_IMG);
		pause(500);
		goToNode(ELEMENT_FILE_DOC);
		deleteDocument(ELEMENT_FILE_DOC);
		waitForElementNotPresent(ELEMENT_FILE_DOC);
	}
}
