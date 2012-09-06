package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.createnode;

import java.util.concurrent.TimeUnit;
import static org.exoplatform.selenium.TestLogger.*;

import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ECMS_DMS_SE_File extends EcmsBase {
	
	public static final String DATA_USER = "john";
	public static final String DATA_PASS = "gtn";
	
	public static final String DATA_CONTENT_FOLDER_TITLE = "Test1";
	public static final String DATA_FILE_NAME = "filetest";
	public static final String DATA_DOCUMENT_FOLDER_TITLE = "Test1";
	public static final String DATA_ARTICLE_TITLE = "test";
	public static final By ELEMENT_NEW_CONTENT_LINK_XPATH =By.xpath("//a[@title = 'New Content']") ; 
	public static final String ELEMENT_DMS_OPTION_CHECKBOX_ID = "enableStructure";
	public static final String DATA_PODCAST_NAME = "podcasttest";
	public static final String DATA_SAMPLE_NODE_TITLE = "sampletest";
	public static final String DATA_SAMPLE_NODE_IMG = "TestData/test.jpg";
	public static final String DATA_FILE_PLAN_NAME = "fileplantest";
	public static final By ELEMENT_FILE_PLAN_NUMBER_RECORD_XPATH = By.xpath("//*[@id='UIFilePlanView']/div[1]/table/tbody/tr[9]/td[2]");
	public static final String DATA_KOFAX_NAME = "kofaxtest";
	public static final String DATA_UPLOAD_FILE_NAME = "fileupload";
	public static final String DATA_UPLOAD_FILE_LINK = "TestData/test.jpg";
	public static final String ELEMENT_NEWFILE_LINK_XPATH = "//div[@title='File']";
	public static final String ELEMENT_NEWFILE_POPUP_MESSAGE_XPATH = "//div[@class='UIPopupWindow UIDragObject ExoMessageDecorator']";
	public static final String ELEMENT_NEWFILE_MESSAGE_XPATH = "//span[@class='PopupIcon WarningMessageIcon']";
	public static final String ELEMENT_NEWFILE_MESSAGE_NAME_BLANK = "The field \"Name\" is required.";
	public static final String ELEMENT_NEWFILE_MESSAGE_CONTENT_BLANK = "The field \"Content\" is required.";
	public static final String DATA_NEWFILE_SOURCE_CONTENT = "<p>new_file_test</p>";
	public static final String DATA_NEWFILE_NOSOURCE_CONTENT = "<p> new_file_test</p>";
	public static final String DATA_NEWFILE_SOURCE_CONTENT_VIEW = "new_file_test";
	public static final By ELEMENT_NEWFILE_SOURCE_LINK_XPATH = By.xpath("//a[@title='Source']");
	public static final By ELEMENT_NEWFILE_SOURCE_TEXTAREA_XPATH = By.xpath("//textarea[@class='cke_source cke_enable_context_menu']");
	public static final By ELEMENT_NEWFILE_FRAME_HTML_TAB_XPATH = By.xpath("//iframe[@class='ECMIframe']");
	public static final By ELEMENT_NEWFILE_HTML_TAB_P_XPATH =By.xpath("//html/body/p") ;
	public static final By ELEMENT_NEWFILE_TEXT_TAB_XPATH = By.xpath("//div[contains(text(),'View as Plain text')]");
	public static final String ELEMENT_NEWFILE_TEXT_TAB_P_CSS = ".TextContent>pre";
	public static final By ELEMENT_NEWFILE_MIME_COMBOX_ID =By.id("mimetype") ;
	public static final By ELEMENT_NEWFILE_TEXTAREA_ID =By.id("contentPlain") ;
	public static final String DATA_NEWFILE_TEXTAREA_CONTENT ="content text plain" ;
	public static final String ELEMENT_NEWFILE_PRE_CSS = ".Content>pre";
	
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


	 /* case1: Add File document in Content folder 
	 * login 
	 * crate a new content folder 
	 * add new file document to this content folder 
	 * check add successfully
	 * delete this content folder logout
	 */
	@Test
	public void test01_AddFileDocumentToContentFolder() {
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new content folder
		goToSiteExplorerForm();
		debug("create new content with title:"+DATA_CONTENT_FOLDER_TITLE+", name:"+DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE,DATA_CONTENT_FOLDER_TITLE);
		waitForElementPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
		boolean check1 = isElementPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
		assert check1 :"Can not create new content folder";
		info("create content folder:"+check1);
		//add new file to content folder just add
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		goToAddNewContent();
		debug("add new file document with name:"+DATA_FILE_NAME+", content:"+ DATA_FILE_NAME+", title:"+ DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		pause(500);
		//check add successfully
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		boolean check2 = isElementPresent("//div[@title='"+DATA_FILE_NAME+" "+"']");
		assert 	check2:"Can not add file document into content folder";
		info("add new file document to content document:"+ check2);
		//delete content folder
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"):"Can node delete content folder";
		//logout
		logoutEcms();
	}
	

	/*case2: Add File document in Document folder
	 * login
	 * create new document folder
	 * add new file document to this document folder
	 * check add successfully
	 * delete this document folder
	 * logout
	 */
	@Test
	public void test02_AddFileDocumentToDocumentFolder(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new document folder
		goToSiteExplorerForm();
		debug("create new document folder with title: "+DATA_DOCUMENT_FOLDER_TITLE+", title: "+ DATA_DOCUMENT_FOLDER_TITLE);
		createNewDocumentFolder(DATA_DOCUMENT_FOLDER_TITLE, DATA_DOCUMENT_FOLDER_TITLE);
		waitForElementPresent("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		assert check1:"Can not create new document folder";
		info("create new document folder:"+check1);
		//add new file document to this document folder
		goToNode(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		debug("add new file document with name:"+DATA_FILE_NAME+", content:"+ DATA_FILE_NAME+", title:"+ DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		pause(500);
		boolean check2 = isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		assert check2:"Can not add new file document into document folder";
		info("add new file document to document folder:"+check2);
		//delete document folder
		goToNode(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']")):"Can not delete document folder";
		//logout
		logoutEcms();
		
	}

	/*case3: Add File document in Article document
	 * login
	 * add new article document
	 * add new file document to this article document
	 * check add successfully
	 * delete article document
	 * logout
	 */
	@Test
	public void test03_AddFileDocumentToArticleDocument(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new article
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new article document with title:"+DATA_ARTICLE_TITLE+", name:"+DATA_ARTICLE_TITLE+", summary:"+DATA_ARTICLE_TITLE+", content:"+ DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE);
		waitForElementPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		assert check1:"Can not create new article document";
		info("create new article document:"+ check1);
		//add new file document to this article document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		debug("add new file document with name:"+DATA_FILE_NAME+", content:"+ DATA_FILE_NAME+", title:"+ DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		pause(500);
		checkPreferenceOption(ELEMENT_DMS_OPTION_CHECKBOX_ID);
		pause(500);
		boolean check2 = isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		assert check2:"Can not add new file document into article document";
		info("add new file document to document folder:"+check2);
		//delete article document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"):"Can not delete article document";
		//logout
		logoutEcms();
	}

	/*case4: Add File document in File document
	 * login
	 * create new file document
	 * check can not add new file document to created file document
	 * delete created file document
	 * logout
	 */
	@Test
	public void test04_AddFileDocumentToFileDocument(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new file document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("create new file document with name:"+DATA_FILE_NAME+", content:"+ DATA_FILE_NAME+", title:"+ DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		waitForElementPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		assert check1:"Can not create new file document";
		info("create new file document to document folder:"+check1);
		//check can not add new file document to created file document -> has not new content link
		goToNode(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		boolean check2= isElementNotPresent(ELEMENT_NEW_CONTENT_LINK_XPATH);
		assert check2:"False: New content link is still available";
		info("Check can not add a file document to a file document:"+check2);
		//delete file document
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']"):"Can not delete file document";
		//logout
		logoutEcms();
	}
	
	/*case5: Add File document in Podcast document
	 * login
	 * create new Podcast document
	 * check can not add new file document to created Podcast document
	 * delete created Podcast document
	 * logout
	 */
	@Test
	public void test05_AddFileDocumentToPodcastDocument(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new podcast document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("create new podcast with name:"+DATA_PODCAST_NAME+", title:"+DATA_PODCAST_NAME+", link:"+DATA_PODCAST_NAME);
		createNewPodcast(DATA_PODCAST_NAME, DATA_PODCAST_NAME, DATA_PODCAST_NAME);
		waitForElementPresent("//a[@title='"+DATA_PODCAST_NAME+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_PODCAST_NAME+" "+"']"));
		assert check1:"Can not create new podcast document";
		info("create new podcast:"+check1);
		//check can not add new file document to created podcast document -> has not new content link
		goToNode(By.xpath("//a[@title='"+DATA_PODCAST_NAME+" "+"']"));
		boolean check2 = isElementNotPresent(ELEMENT_NEW_CONTENT_LINK_XPATH);
		assert check2:"False: New content link is still available";
		info("check can not add a file document to podcast document:"+check2);
		//delete podcast document
		deleteDocument(By.xpath("//a[@title='"+DATA_PODCAST_NAME+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_PODCAST_NAME+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_PODCAST_NAME+" "+"']"):"Can not delete podcast document";
		//logout
		logoutEcms();
	}
	
	/*case6: Add File document in Sample Node document
	 * login
	 * create new sample node document
	 * add new file document to sample node document
	 * check add successfully
	 * delete sample node document
	 * check delete successfully
	 * logout
	 */
	@Test
	public void test06_AddFileDocumentToSampleNode(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new sample node document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new sample node document with title:"+DATA_SAMPLE_NODE_TITLE);
		createNewSampleNode(DATA_SAMPLE_NODE_TITLE, DATA_SAMPLE_NODE_TITLE,"");
		waitForElementPresent("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']");
		boolean check1= isElementPresent(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		assert check1:"Can not detele new sample node";
		info("Create new sample node:"+ check1);
		//add new file document to this sample node document
		goToNode(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		debug("add new file document into sample nod with name:"+DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		pause(500);
		//check add successfully
		checkPreferenceOption(ELEMENT_DMS_OPTION_CHECKBOX_ID);
		waitForElementPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		boolean check2= isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		assert check2:"Can not add file document into sample node";
		info("Add a file document to a sample node:"+ check2);
		//delete sample node document
		goToNode(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"):"Can not delete sample node";
		//logout
		logoutEcms();
	}
	
	/*case7: Add File document in File Plan document
	 * login
	 * create new file plan document
	 * add new file document to file plan document
	 * check add successfully
	 * delete file plan
	 * check delete successfully
	 * logout
	 */
	@Test
	public void test07_AddFileDocumentToFilePlan(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new file plan
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("create new file plan document with name: "+ DATA_FILE_PLAN_NAME);
		createNewFilePlan(DATA_FILE_PLAN_NAME, DATA_FILE_PLAN_NAME, DATA_FILE_PLAN_NAME, DATA_FILE_PLAN_NAME, DATA_FILE_PLAN_NAME);
		waitForElementPresent("//a[@title='"+DATA_FILE_PLAN_NAME+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_FILE_PLAN_NAME+" "+"']"));
		assert check1:"Can not create new file plan";
		info("Create new file plan:"+check1);
		//add new file document to this file plan document
		goToNode(By.xpath("//a[@title='"+DATA_FILE_PLAN_NAME+" "+"']"));
		pause(500);
		goToAddNewContent();
		debug("Add new file document with name:"+DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		waitForElementPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		//check add successfully
		assert isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		goToNode(By.xpath("//a[@title='"+DATA_FILE_PLAN_NAME+" "+"']"));
		boolean check2 = waitForAndGetElement(ELEMENT_FILE_PLAN_NUMBER_RECORD_XPATH).getText().equals("1");
		assert check2:"Can not add new file document into file plan";
		info("Add a file document to a file plan document:"+check2);
		//delete file plan document
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_PLAN_NAME+" "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_FILE_PLAN_NAME+" "+"']"));
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_FILE_PLAN_NAME+" "+"']"):"Can not delete file plan";
		//logout
		logoutEcms();
	}
	
	/*case8: Add File document in Kofax document
	 * login
	 * create new kofax document
	 * add new file document to kofax document
	 * check add successfully
	 * delete kofax document
	 * check delete successfully
	 * logout
	 */
	@Test
	public void test08_AddFileDocumentToKofax(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new kofax document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new kofax document with name:"+DATA_KOFAX_NAME);
		createNewKofax(DATA_KOFAX_NAME);
		waitForElementPresent("//a[@title='"+DATA_KOFAX_NAME+" "+"']");
		boolean check1= isElementPresent(By.xpath("//a[@title='"+DATA_KOFAX_NAME+" "+"']"));
		assert check1:"Can not create new kofax document";
		info("Create new Kofax document:"+check1);
		//add new file document to this kofax document
		goToNode(By.xpath("//a[@title='"+DATA_KOFAX_NAME+" "+"']"));
		pause(500);
		goToAddNewContent();
		debug("add new file document with name:"+DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		waitForElementPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		//check add successfully
		boolean check2= isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		assert check2:"Can not add new file document into kofax document";
		info("add new file document to kofax document:"+check2);
		//delete kofax document
		goToNode(By.xpath("//a[@title='"+DATA_KOFAX_NAME+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_KOFAX_NAME+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_KOFAX_NAME+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_KOFAX_NAME+" "+"']"):"Can not delete kofax";
		//logout
		logoutEcms();
	}
	
	/*case9: Add File document in uploaded file
	 * login
	 * upload a new file
	 * check can not add file document to uploaded file
	 * delete uploaded file
	 * logout
	 */
	@Test
	public void test09_AddFileDocumentToUploadFile(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//upload a file
		goToSiteExplorerForm();
		debug("Upload 1 file with name:"+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME,DATA_UPLOAD_FILE_LINK);
		waitForElementPresent("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		boolean check1=isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']")); 
		assert check1:"Can not upload file";
		info("Upload a file:"+check1);
		//check can not add new file document to upload file -> has not new content link
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		pause(500);
		boolean check2 = isElementNotPresent(ELEMENT_NEW_CONTENT_LINK_XPATH);
		assert check2:"False: New content link is still available";
		info("Check can not add new file document to a uploaded file:"+check2);
		//delete podcast document
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"):"Can not delete uploaded file";
		//logout
		logoutEcms();	
	}
	
	/*case10: Add new File document with blank Name or Content
	 * login
	 * add new file document with name blank -> check message
	 * add new file document with content balnk - check message
	 * logout
	 */
	@Test
	public void test10_AddFileDocumentWithNameOrContentBlank(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//add file with content blank;
		goToSiteExplorerForm();
		goToNode(ELEMENT_NEW_CONTENT_LINK_XPATH);
		createNewFile(DATA_FILE_NAME, "", "");
		assert isElementPresent(By.xpath(ELEMENT_NEWFILE_POPUP_MESSAGE_XPATH)):"Not has arlert";	
		//check message when save
		boolean check1= getText(ELEMENT_NEWFILE_MESSAGE_XPATH).contains(ELEMENT_NEWFILE_MESSAGE_CONTENT_BLANK);
		assert check1:"Not found message alert when content blank";
		info("check message when create a file document with content blank:"+check1);
		waitForAndGetElement(By.linkText("OK")).click();
		//add file document with name blank
		waitForAndGetElement(ELEMENT_NEWFILE_NAME_TEXTBOX).clear();
		inputDataToFrame(ELEMENT_NEWFILE_CONTENT_FRAME,DATA_FILE_NAME);
	    switchToParentWindow();
		waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
		pause(500);
		assert isElementPresent(By.xpath(ELEMENT_NEWFILE_POPUP_MESSAGE_XPATH)):"Not has alert";
		//check message when save
		boolean check2= getText(ELEMENT_NEWFILE_MESSAGE_XPATH).contains(ELEMENT_NEWFILE_MESSAGE_NAME_BLANK);
		assert check2:"Not found message alert when name blank";
		info("check message when create a file document with name blank:"+check2);
		waitForAndGetElement(By.linkText("OK")).click();
		//logout
		logoutEcms(); 
	}

	/*case11: Add new text/html File document (1) input source content
	 * login
	 * create new text/html file: mime type =text/html, choose source, input to content html statement
	 * check view by 2 ways
	 * delete this text/html file
	 * logout
	 */
	@Test
	public void test11_AddTextHtmlFileChooseSource(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new text/html file
		goToSiteExplorerForm();
		goToAddNewContent();
		waitForAndGetElement(ELEMENT_NEWFILE_LINK).click();	
		waitForAndGetElement(ELEMENT_NEWFILE_NAME_TEXTBOX).sendKeys(DATA_FILE_NAME);
		waitForAndGetElement(ELEMENT_NEWFILE_SOURCE_LINK_XPATH).click();
		waitForAndGetElement(ELEMENT_NEWFILE_SOURCE_TEXTAREA_XPATH).sendKeys(DATA_NEWFILE_SOURCE_CONTENT);
	    waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	    waitForElementPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']")):"Can not create new text/html file";
	    //check view as html tab
		goToNode(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_NEWFILE_FRAME_HTML_TAB_XPATH));
		assert waitForAndGetElement(ELEMENT_NEWFILE_HTML_TAB_P_XPATH).getText().contentEquals(DATA_NEWFILE_SOURCE_CONTENT_VIEW):"content is not true in html form";
	    switchToParentWindow();
	    //check view as plan text
	    waitForAndGetElement(ELEMENT_NEWFILE_TEXT_TAB_XPATH).click();
	    assert driver.findElement(By.cssSelector(ELEMENT_NEWFILE_TEXT_TAB_P_CSS)).getText().contentEquals(DATA_NEWFILE_SOURCE_CONTENT):"content is not true in text form";
	    //delete text/html file
		goToNode(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']"):"Can not delete file document";
		//logout
		logoutEcms();
	}
	
	/*case12: Add new text/html File document (2) input not source content
	 * login
	 * create new text/html file: mime type =text/html, do not choose source, input to content
	 * check view 
	 * delete file document
	 * logout
	 */
	@Test
	public void test12_AddFileDocumentNotChooseSource(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new text/html file, not choose source
		goToSiteExplorerForm();
		goToAddNewContent();
		createNewFile(DATA_FILE_NAME, DATA_NEWFILE_SOURCE_CONTENT_VIEW, DATA_FILE_NAME);
		waitForElementPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		//view html tab
		goToNode(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_NEWFILE_FRAME_HTML_TAB_XPATH));
		assert waitForAndGetElement(ELEMENT_NEWFILE_HTML_TAB_P_XPATH).getText().contentEquals(DATA_NEWFILE_SOURCE_CONTENT_VIEW):"content is not true in html form";
	    switchToParentWindow();
	    //check view as plan text
	    waitForAndGetElement(ELEMENT_NEWFILE_TEXT_TAB_XPATH).click();
	    String check = driver.findElement(By.cssSelector(ELEMENT_NEWFILE_TEXT_TAB_P_CSS)).getText();
	    assert check.contentEquals(DATA_NEWFILE_NOSOURCE_CONTENT):"content is not true in text form";
	    //delete text/html file
		goToNode(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']"):"Can not delete file document";
		//logout
		logoutEcms();
	}
	
	/*case13: Add new text/plain File document 
	 * login
	 * create new file document with: mime type = text/plain
	 * check content
	 * delete file document
	 * logout
	 */
	@Test
	public void test13_AddNewFileDocumentTextPlan(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new text/plan file
		goToSiteExplorerForm();
		goToAddNewContent();
		waitForAndGetElement(ELEMENT_NEWFILE_LINK).click();	
		waitForAndGetElement(ELEMENT_NEWFILE_NAME_TEXTBOX).sendKeys(DATA_FILE_NAME);
		selectOption(ELEMENT_NEWFILE_MIME_COMBOX_ID, "text/plain");
		waitForAndGetElement(ELEMENT_NEWFILE_TEXTAREA_ID).sendKeys(DATA_NEWFILE_TEXTAREA_CONTENT);
	    waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
		waitForElementPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']")):"Can not create new text/plan file";
		//check view content
		goToNode(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		pause(500);
		assert driver.findElement(By.cssSelector(ELEMENT_NEWFILE_PRE_CSS)).getText().contentEquals(DATA_NEWFILE_TEXTAREA_CONTENT):"Not found content of file document";
		//delete file document
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_NAME+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_FILE_NAME+" "+"']"):"Can not delete file document";
		//logout
		logoutEcms();
	}
	
	/*case14: Add new File document in locked node by locker
	 * login
	 * create new content folder
	 * lock content folder
	 * check lock successfully
	 * add new file document to content folder
	 * delete content folder
	 * login
	 */
	@Test
	public void test14_AddNewFileDocumentToLockedContent(){
		//login
		loginEcms(DATA_USER, DATA_PASS);
		//create new content folder
		goToSiteExplorerForm();
		debug("create new content with title:"+DATA_CONTENT_FOLDER_TITLE+", name:"+DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE,DATA_CONTENT_FOLDER_TITLE);
		pause(500);
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		assert check1 :"Can not create new content folder";
		info("create content folder:"+check1);
		//lock content folder
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		lockNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		//check node is locled
		assert checkLockNode("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]"):"Can not lock this content folder";
		//add new file to content folder just add
		goToNode(By.xpath("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]"));
		goToAddNewContent();
		debug("add new file document with name:"+DATA_FILE_NAME+", content:"+ DATA_FILE_NAME+", title:"+ DATA_FILE_NAME);
		createNewFile(DATA_FILE_NAME, DATA_FILE_NAME, DATA_FILE_NAME);
		pause(500);
		//check add successfully
		goToNode(By.xpath("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]"));
		boolean check2 = isElementPresent(By.xpath("//div[@title='"+DATA_FILE_NAME+" "+"']"));
		assert 	check2:"Can not add new file document to content folder";
		info("add new file document to content document:"+ check2);
		//delete content folder
		goToNode(By.xpath("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]"));
		pause(500);
		deleteDocument(By.xpath("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]"));
		waitForElementNotPresent("//a[contains(@title,'"+DATA_CONTENT_FOLDER_TITLE+"')]");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"):"Can not delete content folder";
		//logout
		logoutEcms();
	}
}
