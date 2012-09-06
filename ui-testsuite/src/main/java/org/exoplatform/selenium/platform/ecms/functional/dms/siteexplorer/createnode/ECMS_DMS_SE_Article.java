package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.createnode;

import java.util.concurrent.TimeUnit;


import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.exoplatform.selenium.TestLogger.*;


public class ECMS_DMS_SE_Article extends EcmsBase{
	
	public static final String ELEMENT_USER = "john";
	public static final String ELEMENT_PASS = "gtn";
	
	public static final String DATA_CONTENT_FOLDER_TITLE = "Testcontent";
	public static final String DATA_ARTICLE_TITLE= "Testarticle";
	public static final String DATA_DOCUMENT_FOLDER_TITLE = "Testdocument";
	public static final String DATA_FILE_DOCUMENT_TITLE = "Testfile";
	public static final String DATA_PODCAST_DOCUMENT_TITLE = "Testpodcast";
	public static final By ELEMENT_NEW_CONTENT_LINK_XPATH =By.xpath("//a[@title = 'New Content']") ; 
	public static final String DATA_SAMPLE_NODE_TITLE = "Testsample";
	public static final String DATA_SAMPLE_NODE_IMG = "TestData/test.jpg";
	public static final String DATA_FILE_PLAN_TITLE = "Testfileplan";
	public static final String DATA_KOFAX_TITLE = "Testkofax";
	public static final String DATA_UPLOAD_FILE_NAME = "Testuploadfile";
	public static final String DATA_UPLOAD_FILE_LINK = "TestData/test.jpg";
	
	public static final String ELEMENT_NEW_ARTICLE_POPUP_XPATH = "//div[@class='UIPopupWindow UIDragObject ExoMessageDecorator']";
	public static final String ELEMENT_NEW_ARTICLE_MESSAGE_XPATH = "//span[@class='PopupIcon WarningMessageIcon']";
	public static final String ELEMENT_NEW_ARTICLE_MESSAGE_TITLE_BLANK = "The field \"Title\" is required.";
	public static final String ELEMENT_NEW_ARTICLE_MESSAGE_NAME_BLANK = "The field \"Name\" is required.";
	public static final String ELEMENT_NEW_ARTICLE_MESSAGE_SUMMARY_BLANK = "Summary is empty";
	public static final String ELEMENT_NEW_ARTICLE_MESSAGE_CONTENT_BLANK = "Content is empty";

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

	/*case1: Add Article document in Content folder
	* login
	* create a new content folder
	* add new article to content folder just add
	* delete content folder
	* logout
	*/
	@Test
	public void test01_AddArticleToContentFolder(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new content folder
		goToSiteExplorerForm();
		debug("Create new content folder with title:"+ DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE,DATA_CONTENT_FOLDER_TITLE);
		waitForElementPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		assert check1:"Can not create new content folder";		
		info("Create new content folder:"+ check1);
		//add new article to content folder just add
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		debug("Add new article document with title:"+DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE);
		pause(500);
		//check add successfully
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		boolean check2 = isElementPresent(By.xpath("//div[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		assert check2:"Can not add new article into content folder";	
		info("Add new article document to content folder:"+check2);
		//delete content folder
		goToNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"):"Can not delete this content folder";
		//logout
		logoutEcms();
	}
	
	/*case2: Add Article document in Document folder
	 * login
	 * create new document folder
	 * check has not article link in new conntent
	 * delete document folder
	 * logout
	 */
	@Test
	public void test02_AddArticleToDocumentFolder(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new document folder
		goToSiteExplorerForm();
		debug("Create new document folder with title:"+ DATA_DOCUMENT_FOLDER_TITLE);
		createNewDocumentFolder(DATA_DOCUMENT_FOLDER_TITLE, DATA_DOCUMENT_FOLDER_TITLE);
		waitForElementPresent("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		assert check1:"Can not create document folder";
		info("Create new document folder:"+check1);
		//check can not add article to document folder
		goToNode(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		assert isElementNotPresent(ELEMENT_ARTICLE_LINK):"False: Article link is still available";
		//delete document folder
		goToNode(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"):"Can not delete document folder";
		//logout
		logoutEcms();
	}
	
	/*case3: Add Article document in Article document
	 * login
	 * add new article
	 * check cant not add new article to added article
	 * delete document
	 * logout
	 */
	@Test
	public void test03_AddArticleToArticleDocument(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new article
		goToSiteExplorerForm();
		goToAddNewContent();
		info("Create new article with title:"+DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE);
		waitForElementPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		assert check1:"Can not create new article document";
		debug("Create new article document:"+check1);
		//check can not add article to article document
		goToNode(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		assert isElementNotPresent(ELEMENT_ARTICLE_LINK):"False: Article link is still available";
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
	
	/*case4: Add Article document in File document
	 * login
	 * add a new File document
	 * check cant not add new article document to File document
	 * delete new File document
	 * logout
	 */
	@Test
	public void test04_AddArticleToFileDocument(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add new File Document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new file document with title:"+DATA_FILE_DOCUMENT_TITLE);
		createNewFile(DATA_FILE_DOCUMENT_TITLE, DATA_FILE_DOCUMENT_TITLE, DATA_FILE_DOCUMENT_TITLE);
		waitForElementPresent("//a[@title='"+DATA_FILE_DOCUMENT_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_FILE_DOCUMENT_TITLE+" "+"']"));
		assert check1:"Can not create new file document";
		info("Create new file document:"+check1);
		//check can not add article to file document
		goToNode(By.xpath("//a[@title='"+DATA_FILE_DOCUMENT_TITLE+" "+"']"));
		assert isElementNotPresent(ELEMENT_NEW_CONTENT_LINK_XPATH):"False - New content link is still available";
		//delete file document
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_DOCUMENT_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_FILE_DOCUMENT_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_FILE_DOCUMENT_TITLE+" "+"']"):"Can not delete file document";
		//logout
		logoutEcms();
	}
	
	/*case5: Add Article document in Podcast document
	 * login
	 * add new Podcast 
	 * check cant not add article to podcast document
	 * delete podcast document
	 * logout
	 */
	@Test
	public void test05_AddArticleToPodcastDocument(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add new podcast document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new podcast document with title:"+DATA_PODCAST_DOCUMENT_TITLE);
		createNewPodcast(DATA_PODCAST_DOCUMENT_TITLE, DATA_PODCAST_DOCUMENT_TITLE, DATA_PODCAST_DOCUMENT_TITLE);
		waitForElementPresent("//a[@title='"+DATA_PODCAST_DOCUMENT_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_PODCAST_DOCUMENT_TITLE+" "+"']"));
		assert check1:"Can not create new podcast";
		info("Create new podcast document:"+check1);
		//check can not add article to podcast document -> has not new content link
		assert isElementNotPresent(ELEMENT_NEW_CONTENT_LINK_XPATH):"False - New content link is still available";
		//delete podcast
		goToNode(By.xpath("//a[@title='"+DATA_PODCAST_DOCUMENT_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_PODCAST_DOCUMENT_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_PODCAST_DOCUMENT_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_PODCAST_DOCUMENT_TITLE+" "+"']"):"Can not delete podcast document";
		//logout
		logoutEcms();
	}
	
	/*case6: Add Article document in Sample Node document
	 * login
	 * add new sample node document
	 * check cant not add article to sample node document
	 * delete sample node document
	 * logout
	 */
	@Test
	public void test06_AddArticleToSampleNode(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add new sample node document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new sample node with title:"+DATA_SAMPLE_NODE_TITLE);
		createNewSampleNode(DATA_SAMPLE_NODE_TITLE, DATA_SAMPLE_NODE_TITLE, DATA_SAMPLE_NODE_IMG);
		waitForElementPresent("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		assert check1:"Can not create new sample node document";
		info("Create new sample document:"+check1);
		//check no add article to sample document -. has not article link
		goToNode(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		assert isElementNotPresent(ELEMENT_ARTICLE_LINK):"False - Article link is still available";
		pause(500);
		//delete sample node
		goToNode(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		waitForElementNotPresent(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"):"Can not delete sample document";
		//logout
		logoutEcms();	
	}

	/*case7: Add Article document in File Plan document
	 * login
	 * add new File plan document
	 * check cant not add article to File plan document
	 * delete file plan document
	 * logout
	 */
	@Test
	public void test07_AddArticleToFilePlan(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add new file plan document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new file plan with title:"+DATA_FILE_PLAN_TITLE);
		createNewFilePlan(DATA_FILE_PLAN_TITLE, DATA_FILE_PLAN_TITLE, DATA_FILE_PLAN_TITLE, DATA_FILE_PLAN_TITLE, DATA_FILE_PLAN_TITLE);
		waitForElementPresent("//a[@title='"+DATA_FILE_PLAN_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_FILE_PLAN_TITLE+" "+"']"));
		assert check1:"Can not create new file plan document";
		info("Create new file plan document:"+check1);
		//check can not add article to podcast document -> has not article link
		goToNode(By.xpath("//a[@title='"+DATA_FILE_PLAN_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		pause(500);
		assert isElementNotPresent(ELEMENT_ARTICLE_LINK):"False - Article link is still available";
		//delete file plan
		goToNode(By.xpath("//a[@title='"+DATA_FILE_PLAN_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_FILE_PLAN_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_FILE_PLAN_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_FILE_PLAN_TITLE+" "+"']"):"Can not delete file plan document";
		//logout
		logoutEcms();	
	}
	
	/*case8: Add Article document in Kofax document
	 * login
	 * add new kofax document
	 * add new article document to kofax document
	 * check add document successfully
	 * delete kofax document
	 * logout
	 */
	@Test
	public void test08_AddArticleToKofax(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add new kofax document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new kofax document with title:"+ DATA_KOFAX_TITLE);
		createNewKofax(DATA_KOFAX_TITLE);
		waitForElementPresent("//a[@title='"+DATA_KOFAX_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_KOFAX_TITLE+" "+"']"));
		assert check1:"Can not create new kofax document";
		info("Create new kofax document:"+check1);
		//add new article document
		goToNode(By.xpath("//a[@title='"+DATA_KOFAX_TITLE+" "+"']"));
		pause(500);
		goToAddNewContent();
		debug("Add new article document to kofax document with title:"+DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE);
		waitForElementPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
		boolean check2 = isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		assert check2:"Can not add new article into kofax document";
		info("Add new article document to a kofax document:"+check2);
		//delete kofax document
		goToNode(By.xpath("//a[@title='"+DATA_KOFAX_TITLE+" "+"']"));
		pause(500);
		deleteDocument(By.xpath("//a[@title='"+DATA_KOFAX_TITLE+" "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_KOFAX_TITLE+" "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_KOFAX_TITLE+" "+"']"):"Can not delete kofax document";
		//logout
		logoutEcms();		
	}
	
	/*case9: Select an uploaded file and see on action bar
	 * login
	 * upload a file
	 * check can not add article document to this uploaded file
	 * delete uploaded file
	 * logout  
	 */
	@Test
	public void test09_AddArticleToUploadFile(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//upload file
		goToSiteExplorerForm();
		debug("Upload new file with nam:"+DATA_UPLOAD_FILE_NAME);
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		waitForElementPresent("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		assert check1:"Can not upload new file";
		info("Upload file:"+check1);
		//check can not add article document to uploaded file: has not new content link
		goToNode(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		assert isElementNotPresent(ELEMENT_NEW_CONTENT_LINK_XPATH):"False - New content link is still available";
		//delete uploaded file
		deleteDocument(By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"));
		waitForElementNotPresent("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']");
		//check delete successfully
		assert isElementNotPresent("//a[@title='"+DATA_UPLOAD_FILE_NAME+".jpg "+"']"):"Can not delete uploaded file";
		//logout
		logoutEcms();
	}

	/*case10: Add Article with blank name or title
	 * login
	 * add article document with name blank or title blank
	 * logout
	 */
	@Test
	public void test10_AddArticleWithNameOrTitleBlank(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add article with title blank
		goToSiteExplorerForm();
		goToNode(ELEMENT_NEW_CONTENT_LINK_XPATH);
		createNewArticle("", DATA_ARTICLE_TITLE, "", "");
	    assert isElementPresent(By.xpath(ELEMENT_NEW_ARTICLE_POPUP_XPATH)):"Not found alert when title blank";
	    //check message when save
	    assert getText(ELEMENT_NEW_ARTICLE_MESSAGE_XPATH).contains(ELEMENT_NEW_ARTICLE_MESSAGE_TITLE_BLANK):"Not found message when title blank";
	    waitForAndGetElement(By.linkText("OK")).click();
	    //add article with name blank;
		waitForAndGetElement(ELEMENT_ARTICLE_TITLE_TEXTBOX).sendKeys(DATA_ARTICLE_TITLE);
		waitForAndGetElement(ELEMENT_ARTICLE_NAME_TEXTBOX).clear();
	    waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	    assert isElementPresent(By.xpath(ELEMENT_NEW_ARTICLE_POPUP_XPATH)):"Not found alert when name blank";
	    //check message when save
	    assert getText(ELEMENT_NEW_ARTICLE_MESSAGE_XPATH).contains(ELEMENT_NEW_ARTICLE_MESSAGE_NAME_BLANK):"not found message when name blank";
	    waitForAndGetElement(By.linkText("OK")).click();
	    //logout
	    logoutEcms();		
	}
	
	/*case11: Add Article with blank 'Summary' or 'Content'
	 * login
	 * create new article with summary or conntent blank
	 * view summary & content
	 * delete this article document
	 * logout
	 */
	@Test
	public void test11_AddArticleWithSummaryOrContentBlank(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new article with summary blank
		goToSiteExplorerForm();
		goToNode(ELEMENT_NEW_CONTENT_LINK_XPATH);
		debug("Create new article with title:"+DATA_ARTICLE_TITLE+" and summary, content blank");
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, "", "");
		waitForElementPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']")):"Can not create new article with summary, content blank";
	    //view summary & content
	    assert isTextPresent(ELEMENT_NEW_ARTICLE_MESSAGE_SUMMARY_BLANK):"Not found message when summary blank";
	    assert isTextPresent(ELEMENT_NEW_ARTICLE_MESSAGE_CONTENT_BLANK):"Not found message when content blank";
	    deleteDocument(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
	    waitForElementNotPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
	    //check delete successfully
	    assert isElementNotPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"):"Can not delete article document";
	    //logout
	    logoutEcms();	    
	}
	
	/*case12: Add Article document in a locked Content folder by locker
	 * login
	 * create new content folder
	 * lock this content folder
	 * add new article document to this content folder successfully
	 * delete content folder
	 * logout
	 */
	@Test
	public void test12_AddArticleToLockedContentFolder(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new content folder
		goToSiteExplorerForm();
		debug("Create new content folder with title: "+DATA_CONTENT_FOLDER_TITLE);
		createNewContentFolder(DATA_CONTENT_FOLDER_TITLE,DATA_CONTENT_FOLDER_TITLE);
		waitForElementPresent("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		assert 	check1:"Can not crate new content folder";
		info("Create new content folder: "+check1);
		//lock this content folder
		lockNode(By.xpath("//a[@title='"+DATA_CONTENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		//check lock successfully
		assert checkLockNode("//a[contains(text(),'"+DATA_CONTENT_FOLDER_TITLE+"')]"):"Can not lock this content folder";
		//add new article to this content folder successfully
		goToNode(By.xpath("//a[contains(text(),'"+DATA_CONTENT_FOLDER_TITLE+"')]"));
		pause(500);
		goToAddNewContent();
		debug("Add new article with title: "+DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE);
		waitForElementPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
		assert isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']")):"Can not add new article into content folder";	
		//delete content folder
		goToNode(By.xpath("//a[contains(text(),'"+DATA_CONTENT_FOLDER_TITLE+"')]"));
		pause(500);
		deleteDocument(By.xpath("//a[contains(text(),'"+DATA_CONTENT_FOLDER_TITLE+"')]"));
		waitForElementNotPresent("//a[contains(text(),'"+DATA_CONTENT_FOLDER_TITLE+"')]");
		//check delete successfully
		assert isElementNotPresent("//a[contains(text(),'"+DATA_CONTENT_FOLDER_TITLE+"')]"):"Can not delete content folder";
		//logout
		logoutEcms();		
	}

	/*case13: Add Article document in a locked Document folder by locker
	 * login
	 * create new document folder
	 * lock this document folder
	 * check can not add new article to document folder
	 * delete document folder
	 * logout
	 */
	@Test
	public void test13_AddArticleToLockedDocumentFolder(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//create new document folder
		goToSiteExplorerForm();
		debug("Create new document folder with title: "+DATA_DOCUMENT_FOLDER_TITLE);
		createNewDocumentFolder(DATA_DOCUMENT_FOLDER_TITLE, DATA_DOCUMENT_FOLDER_TITLE);
		waitForElementPresent("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		assert check1:"Can not create new document folder";
		info("create new document folder: "+ check1);
		//lock this document folder
		lockNode(By.xpath("//a[@title='"+DATA_DOCUMENT_FOLDER_TITLE+" "+"']"));
		pause(500);
		//check lock successfully
		assert checkLockNode("//a[contains(text(),'"+DATA_DOCUMENT_FOLDER_TITLE+"')]"):"Can not lock this document folder";
		//check can not add new article to document folder -> has not article link
		goToNode(By.xpath("//a[contains(text(),'"+DATA_DOCUMENT_FOLDER_TITLE+"')]"));
		pause(500);
		goToAddNewContent();
		assert isElementNotPresent(ELEMENT_ARTICLE_LINK):"False: Article link is still available";	
		//delete document folder
		goToNode(By.xpath("//a[contains(text(),'"+DATA_DOCUMENT_FOLDER_TITLE+"')]"));
		pause(500);
		deleteDocument(By.xpath("//a[contains(text(),'"+DATA_DOCUMENT_FOLDER_TITLE+"')]"));
		waitForElementNotPresent("//a[contains(text(),'"+DATA_DOCUMENT_FOLDER_TITLE+"')]");
		//check delete successfully
		assert isElementNotPresent("//a[contains(text(),'"+DATA_DOCUMENT_FOLDER_TITLE+"')]"):"Can not delete document folder";
		logoutEcms();
	}

	
	/*case14: Add Article document in a locked node: Kofax document  by locker
	 * login
	 * create new Kofax document
	 * lock this Kofax document
	 * add new article to this Kofax Document successfully
	 * delete Kofax document
	 * logout
	 */
	@Test
	public void test14_AddArticleToLockedKofaxDocument(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add new kofax document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("Create new kofax document with title "+DATA_KOFAX_TITLE);
		createNewKofax(DATA_KOFAX_TITLE);
		waitForElementPresent("//a[@title='"+DATA_KOFAX_TITLE+" "+"']");
		boolean check1 = isElementPresent(By.xpath("//a[@title='"+DATA_KOFAX_TITLE+" "+"']"));
		assert check1:"Can not create new kofax document";
		//lock this Kofax
		lockNode(By.xpath("//a[@title='"+DATA_KOFAX_TITLE+" "+"']"));
		pause(500);
		//check lock successfully
		assert checkLockNode("//a[contains(text(),'"+DATA_KOFAX_TITLE+"')]"):"Can not lock fofax document";
		//add new article document successfully
		goToNode(By.xpath("//a[contains(text(),'"+DATA_KOFAX_TITLE+"')]"));
		pause(500);
		//Add new article into kofax document
		goToAddNewContent();
		pause(500);
		debug("add new article with title: "+DATA_ARTICLE_TITLE);
		createNewArticle(DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE, DATA_ARTICLE_TITLE);
		waitForElementPresent("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']");
		boolean check2 = isElementPresent(By.xpath("//a[@title='"+DATA_ARTICLE_TITLE+" "+"']"));
		assert check2:"Can not add new article into kofax document";
		info("Add new article into koafax document: "+check2);
		//delete kofax document
		goToNode(By.xpath("//a[contains(text(),'"+DATA_KOFAX_TITLE+"')]"));
		pause(500);
		deleteDocument(By.xpath("//a[contains(text(),'"+DATA_KOFAX_TITLE+"')]"));
		waitForElementNotPresent("//a[contains(text(),'"+DATA_KOFAX_TITLE+"')]");
		//check delete successfully
		assert isElementNotPresent("//a[contains(text(),'"+DATA_KOFAX_TITLE+"')]"):"Can not delete kofax document";
		//logout
		logoutEcms();
	}

	/*case15: Add Article document in a locked node (Article, Sample node, File Flan document) by locker
	 * login
	 * create new Sample nodet
	 * lock this Sample node
	 * check can not add new article to this Sample node
	 * delete this Sample node
	 * logout
	 */
	@Test
	public void test15_AddArticleToLockSampleNode(){
		//login
		loginEcms(ELEMENT_USER, ELEMENT_PASS);
		//add new sample node document
		goToSiteExplorerForm();
		goToAddNewContent();
		debug("create new sample node with title: "+DATA_SAMPLE_NODE_TITLE);
		createNewSampleNode(DATA_SAMPLE_NODE_TITLE, DATA_SAMPLE_NODE_TITLE, DATA_SAMPLE_NODE_IMG);
		waitForElementPresent("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']");
		boolean check1= isElementPresent(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		assert check1:"Can not create new sample node";
		info("Create new sample node: "+check1);
		//lock this sample node document
		lockNode(By.xpath("//a[@title='"+DATA_SAMPLE_NODE_TITLE+" "+"']"));
		pause(500);
		//check lock successfully
		assert checkLockNode("//a[contains(text(),'"+DATA_SAMPLE_NODE_TITLE+"')]"):"Can not lock sample node";
		//check can not add article to sample node
		goToNode(By.xpath("//a[contains(text(),'"+DATA_SAMPLE_NODE_TITLE+"')]"));
		pause(500);
		goToAddNewContent();
		pause(500);
		assert isElementNotPresent(ELEMENT_ARTICLE_LINK):"False: Article link is still available";
		//delete sample node
		goToNode(By.xpath("//a[contains(text(),'"+DATA_SAMPLE_NODE_TITLE+"')]"));
		pause(500);
		deleteDocument(By.xpath("//a[contains(text(),'"+DATA_SAMPLE_NODE_TITLE+"')]"));
		waitForElementNotPresent("//a[contains(text(),'"+DATA_SAMPLE_NODE_TITLE+"')]");
		//check delete successfully
		assert isElementNotPresent("//a[contains(text(),'"+DATA_SAMPLE_NODE_TITLE+"')]"):"Can not delete sample node";
		//logout
		logoutEcms();
	}

}
