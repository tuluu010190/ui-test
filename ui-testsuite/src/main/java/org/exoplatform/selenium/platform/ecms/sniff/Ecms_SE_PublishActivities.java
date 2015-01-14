package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument.selectDocumentType;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.social.HomepageActivity;
import org.exoplatform.selenium.ManageAlert;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	/**
	* @author eXo
	*
	*/
	public class Ecms_SE_PublishActivities extends PlatformBase {
		HomePagePlatform hp;
		ManageLogInOut magAc;
		TextBoxDatabase txData;		
		ContentAdministrationManagement caPage;
		SiteExplorerHome seHome;
		CreateNewDocument createDoc;
		HomepageActivity aHome;
		AttachmentFileDatabase fData;
		NavigationToolbar navTool;
		ManageAlert alert;
		
		@BeforeClass
		public void setUpBeforeClass() throws Exception{
			initSeleniumTest();
			getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
			magAc = new ManageLogInOut(driver);
			alert = new ManageAlert(driver);
			seHome = new SiteExplorerHome(driver);
			hp = new HomePagePlatform(driver);
			navTool = new NavigationToolbar(driver);
			aHome = new HomepageActivity(driver);
			createDoc = new CreateNewDocument(driver);
			txData = new TextBoxDatabase();
			txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
			fData = new AttachmentFileDatabase();
			fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		}	
		@BeforeMethod
		public void beforeMethod(){
			magAc.signIn(DATA_USER1, DATA_PASS);
		}
		
		@AfterMethod
		public void afterMethod(){
			magAc.signOut();
			
		}
		
		@AfterClass
		public void afterClass(){
			driver.manage().deleteAllCookies();
			driver.quit();
		}
		
	/**
	*<li> Case ID:116665.</li>
	*<li> Test Case Name: Check intranet homepage after adding a File content.</li>
	*<li> Case ID:116683.</li>
	*<li> Test Case Name: Edit a file from the File activity.</li>
	*/
	@Test
	public  void test01_02_CheckIntranetHomepageAfterAddingAFileContent_EditFileFromTheFileActivity() {
		info("Test 1,2: Check intranet homepage after adding a File content");
		info("Get data test");
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String content =  txData.getContentByArrayTypeRandom(1)+random;
		info("Fnishing Getting data test");
		/*Step Number: 1
		*Step Name: - Add a File Content
		*Step Description: 
			- Connect to Intranet
			- Navigate Administration 
			-> Content 
			-> Sites Explorer 
			- Click [New content]: and choose File
			- Fill the info and click [Save & Close]
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- A new Content activity is added in the activity stream
			- Informations displayed in the featured content are :1. File icon 2.File's name3.File description if exist 4.Version (if exist) and file size*/ 
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.FILE);
		createDoc.addNewFile(title, content);
		createDoc.saveAndClose();
		hp.goToHomePage();
		aHome.checkActivityAddFile(title);
		
		info("Test 15 Edit a file from the File activity");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- From the file activity, click on the link "Edit"
		*Input Data: 
			
		*Expected Outcome: 
			- The Content explorer is opened in the file to edit*/ 
		click(By.xpath(aHome.ELEMENT_ACTIVITY_FILE_EDIT_FILE_FROM_ACTIVITY.replace("{$title}", title)));
		createDoc.saveAndClose();
		
		// delete data
		navTool.goToSiteExplorer();
		seHome.deleteData(title);
 	}

	/**
	*<li> Case ID:116666.</li>
	*<li> Test Case Name: Check intranet homepage after adding Web Content.</li>	
	*<li> Case ID:116671.</li>
	*<li> Test Case Name: Check intranet homepage after publishing a content.</li>
	*/
	@Test
	public  void test03__04_CheckIntranetHomepageAfterAddingWebContent_CheckIntranetHomepageAfterPublishWebContent() {
		info("Test 3: Check intranet homepage after adding Web Content");
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String content =  txData.getContentByArrayTypeRandom(1)+random;
		/*Step Number: 1
		*Step Name: - Add a FreeLayout Web Content
		*Step Description: 
			- Connect to Intranet
			- Navigate Administration 
			-> Content 
			-> Sites Explorer 
			- Click [New content]: and choose Web Content
			- Fill the info and click [Save & Close]
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- A new Content activity is added in the activity stream
			- Informations displayed in the featured content are :1. Icon corresponding to the content type2. Name of the content3. First 4 lines of content's summary4. Type of the content5.Version6. Current status*/ 
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.WEBCONTENT);
		createDoc.addNewWebContent(title, content);
		createDoc.saveAndClose();
		hp.goToHomePage();
		aHome.checkActivityAddWebContent(title, null, null);
		
		info("Test 4: Check intranet homepage after publishing a content");
		String comment="Document has been published.";
		/*Step number: 2
		*Step Name: Publish file content
		*Step Description: 
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Choose the content and click [Publication] in Action ba
			- Change the status of the shared content to Published
			- Back to the homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The content activity is updated in the activity stream with the new summary
			- A comment is added: Document has been published.*/ 
		navTool.goToSiteExplorer();
		seHome.selectNode(title);
		seHome.goToPublication();
		seHome.changeStatusPulication("Published");
		hp.goToHomePage();
		driver.navigate().refresh();
		aHome.checkActivityAddWebContent(title, "1", "Published");
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("{$title}",title).replace("{$comment}",comment)));
		
		// delete data
		navTool.goToSiteExplorer();
		seHome.deleteData(title);
 	}

	/**
	*<li> Case ID:116667.</li>
	*<li> Test Case Name: Check intranet homepage after adding Product content.</li>
	*/
	@Test
	public void test05_CheckIntranetHomepageAfterAddingProductContent() {
		info("Test 5: Check intranet homepage after adding Product content");
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String summary =  txData.getContentByArrayTypeRandom(1)+random;
	
		/*Step Number: 1
		*Step Name: - Add a Product Content
		*Step Description: 
			- Connect to Intranet
			- Navigate Administration 
			-> Content 
			-> Sites Explorer 
			- Click [New content]: and choose Product
			- Fill the info and click [Save & Close]
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- A new Content activity is added in the activity stream
			- Information displayed in the featured content are:1. Icon corresponding to the content type2. Name of the content3. First 4 lines of content's summary4. Type of the content5.Version6. Current status*/ 
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.PRODUCT);
		createDoc.addNewProduct(title, summary);
		createDoc.saveAndClose();
		hp.goToHomePage();
		aHome.checkActivityAddProduct(title, null, null);
		
		// delete data
		navTool.goToSiteExplorer();
		seHome.deleteData(title);	
 	}

	/**
	*<li> Case ID:116668.</li>
	*<li> Test Case Name: Check intranet homepage after Editing title of content.</li>
	*/
	@Test
	public  void test06_CheckIntranetHomepageAfterEditingTitleOfContent() {
		info("Test 6: Check intranet homepage after Editing title of content");
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String content =  txData.getContentByArrayTypeRandom(1)+random;
		String random1=getRandomNumber();
		String newContent=txData.getContentByArrayTypeRandom(1)+random1;
		String comment ="File has been updated.";
		/*Step Number: 1
		*Step Name: - Add Content
		*Step Description: 
			- Connect to Intranet
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Click [New content]: and choose a template, for example: File
			- Fill the info and click [Save & Close]
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- A new Content activity is added in the activity stream
			- Informations displayed in the featured content are :1. File icon 2.File's name3.File description if exist 4.Version (if exist) and file size*/
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.FILE);
		createDoc.addNewFile(title, content);
		createDoc.saveAndClose();
		hp.goToHomePage();
		aHome.checkActivityAddFile(title);
		
		/*Step number: 2
		*Step Name: Edit title of content
		*Step Description: 
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Navigate to the content and click Edit in Action Bar
			- Edit the title of the shared content
			- Back to the homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The content activity is updated in the activity stream with the new title
			- A comment is added:File has been updated.*/ 
		navTool.goToSiteExplorer();
		seHome.selectNode(title);
		seHome.goToEditDocument();
		seHome.editDocument(newContent);
		createDoc.saveAndClose();
		hp.goToHomePage();
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("{$title}",title).replace("{$comment}",comment)));
		
		// delete data
		navTool.goToSiteExplorer();
		seHome.deleteData(title);
	}

	/**
	*<li> Case ID:116669.</li>
	*<li> Test Case Name: Check intranet homepage after adding tag to a content.</li>
	*/
	@Test
	public  void test07_CheckIntranetHomepageAfterAddingTagToAContent() {
		info("Test 7: Check intranet homepage after adding tag to a content");
		info("Get data test");
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String content =  txData.getContentByArrayTypeRandom(1)+random;
		String tag =txData.getContentByArrayTypeRandom(22);
		String secondTags=txData.getContentByArrayTypeRandom(23);
		info("Fnishing Getting data test");
		/*Step Number: 1
		*Step Name: - Add a Content
		*Step Description: 
			- Connect to Intranet
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Click [New content]: and choose a template
			- Fill the info and click [Save & Close]
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- A new Content activity is added in the activity stream*/
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.WEBCONTENT);
		createDoc.addNewFile(title, content);
		createDoc.saveAndClose();
		hp.goToHomePage();
		driver.navigate().refresh();
		aHome.checkActivityAddWebContent(title,null,null);
		/*Step number: 2
		*Step Name: - Add a tag to content
		*Step Description: 
			- Connect to Intranet
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Navigate to the content
			- Click [Collbration] on Action Bar and click [Add tag]
			- Back to the homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The content of the content activity isn't updated in the activity stream 
			- A comment is added: Tag: $value has been added.*/
		navTool.goToSiteExplorer();
		seHome.selectNode(title);
		seHome.addTagToAContent(tag);
		hp.goToHomePage();
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("{$title}",title).replace("{$comment}","Tag: "+tag+" has been added.")));

		
		/*Step number: 3
		*Step Name: - Add more 2 tags
		*Step Description: 
			-Add two other tags by using common, then click Add
			- Back to the homepage
		*Input Data: 
			
		*Expected Outcome: 
			- One comment isadded the activity: Tag: $value, $value have been added.*/ 
		navTool.goToSiteExplorer();
		seHome.selectNode(title);
		seHome.addTagToAContent(secondTags);
		hp.goToHomePage();
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("{$title}",title).replace("{$comment}","Tags: "+secondTags+" have been added.")));

		// delete data
		navTool.goToSiteExplorer();
		seHome.deleteData(title);
 	}

	/**
	*<li> Case ID:116670.</li>
	*<li> Test Case Name: Check intranet homepage after deleting a content.</li>
	*/
	@Test
	public  void test08_CheckIntranetHomepageAfterDeletingAContent() {
		info("Test 8: Check intranet homepage after deleting a content");
		info("Get data test");
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String content =  txData.getContentByArrayTypeRandom(1)+random;
		info("Fnishing Getting data test");
		/*Step Number: 1
		*Step Name: - Add a Content
		*Step Description: 
			- Connect to Intranet
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Click [New content]: and choose a template
			- Fill the info and click [Save & Close]
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- A new Content activity is added in the activity stream*/
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.WEBCONTENT);
		createDoc.addNewFile(title, content);
		createDoc.saveAndClose();
		hp.goToHomePage();
		driver.navigate().refresh();
		aHome.checkActivityAddWebContent(title,null,null);
		/*Step number: 2
		*Step Name: Delete content
		*Step Description: 
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Navigate to the Content to be deleted, 
			- Right click and select [Delete]
			- Click OK to confirm
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The Content activity related to the content is removed from the activity stream*/ 
		navTool.goToSiteExplorer();
		seHome.deleteData(title);
		hp.goToHomePage();
		waitForElementNotPresent(By.xpath(aHome.ELEMENT_ACTIVITY_WEBCONTENT_TITLE.replace("{$title}", title)));
 	}


	/**
	*<li> Case ID:116672.</li>
	*<li> Test Case Name: Check intranet homepage after Uploading a file.</li>
	*<li> Case ID:116674.</li>
	*<li> Test Case Name: Check intranet homepage after editing Title of an uploaded file.</li>
	*<li> Case ID:116673.</li>
	*<li> Test Case Name: Check intranet homepage after adding a category to an uploaded file.</li>
	*<li> Case ID:116675.</li>
	*<li> Test Case Name: Check intranet homepage after deleting an uploaded file.</li>
	*/
	@Test
	public  void test09_10_11_12_CheckIntranetHomepageAfterUploadingAFile_CheckIntranetHomepageAfterEditingTitleOfAnUploadedFile_CheckIntranetHomepageAfterAddingACategoryToAnUploadedFile_CheckIntranetHomepageAfterDeletingAnUploadedFile() {
		info("Test 9: Check intranet homepage after Uploading a file");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Select a folder and click [Upload] in Action Bar
			- Browse to select a file
			- Back to the Home page
		*Input Data: 
			
		*Expected Outcome: 
			- A File activity is added to the activity stream*/ 
		
		String path = fData.getAttachFileByArrayTypeRandom(1);
		String newTitle =  txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String category="intranet";

		navTool.goToSiteExplorer();
		seHome.uploadFile("TestData/"+path);
		hp.goToHomePage();
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_FILE_UPLOAD_TITLE.replace("{$title}",path)));
		
		info("Test 10 Check intranet homepage after editing Title of an uploaded file");
		navTool.goToSiteExplorer();
		seHome.selectNode(path);
		seHome.goToEditDocument();
		type(seHome.ELEMENT_FILE_FORM_TITLE,newTitle, true );
		createDoc.saveAndClose();
		
		info("Test 11: Check intranet homepage after adding a category to an uploaded file");
		/*Step number: 2
		*Step Name: - Add a Category to the uploaded file
		*Step Description: 
			- Connect to Intranet
			- Navigate Admin 
			-> Content 
			-> Content Explorer 
			- Select the uploaded file and click [Categories] in Action Bar
			- Open [Select Catogory] Tab and Add a category to the file
			- Click [Close] Button to finish adding category
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The content of theFile activity isn't updated in the activity stream
			- A comment is added: Category: $value has been added.*/
		navTool.goToSiteExplorer();
		seHome.selectNode(path);
		seHome.addCategoryForNode(path,category);
		hp.goToHomePage();
		/*Step number: 3
		*Step Name: - Add more 2 categories
		*Step Description: 
			- Add two others categories two the file
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- Two new comments are added to the activity: Category: $value has been added.*/ 
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("{$title}",path).replace("{$comment}","Category: "+category+" has been added.")));
	
		info("Test 12 Check intranet homepage after deleting an uploaded file");
		navTool.goToSiteExplorer();
		seHome.deleteData(path);
		waitForElementNotPresent(By.xpath(aHome.ELEMENT_ACTIVITY_FILE_UPLOAD_TITLE.replace("{$title}",path)));
 	}


	/**
	*<li> Case ID:116680.</li>
	*<li> Test Case Name: Edit a content from the Content activity.</li>
	*<li> Case ID:116681.</li>
	*<li> Test Case Name: View a content from the Content activity.</li>
	*/
	@Test
	public  void test12_13_EditAContentFromTheContentActivity_ViewAContentFromTheContentActivity() {
		info("Test 12 Edit a content from the Content activity");
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String content =  txData.getContentByArrayTypeRandom(1)+random;
		String newContent =  txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		*Step Name: 
		*Step Description: ;
			- Connect to Intranet
			- From the Content activity, click on the link "Edit"
		*Input Data: 
			
		*Expected Outcome: 
			- The content explorer is opened to edit the content*/ 
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.WEBCONTENT);
		createDoc.addNewFile(title, content);
		createDoc.saveAndClose();
		hp.goToHomePage();
		driver.navigate().refresh();
		aHome.checkActivityAddWebContent(title,null,null);
		click(By.xpath(aHome.ELEMENT_ACTIVITY_EDIT_A_NODE.replace("{$title}", title)));
		inputFrame(createDoc.ELEMENT_FILEFORM_BLANK_CONTENT2,newContent);
		switchToParentWindow();
		createDoc.saveAndClose();
		navTool.goToSiteExplorer();
		
		info("Test 13 View a content from the Content activity");
		hp.goToHomePage();
		click(By.xpath(aHome.ELEMENT_ACTIVITY_VIEW_A_NODE.replace("{$title}", title)));
		waitForAndGetElement(By.xpath(seHome.ELEMENT_DOCUMENT_VIEW.replace("{$content}", newContent )));
		
		seHome.deleteData(title);
 	}


	/**
	*<li> Case ID:116682.</li>
	*<li> Test Case Name: View a file from the File activity.</li>
	*/
	@Test
	public  void test14_15_ViewAndEditAFileFromTheFileActivity() {
		info("Test 14 View a file from the File activity");

		String path = fData.getAttachFileByArrayTypeRandom(1);


		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- From the Content activity, click on the link "Edit"
		*Input Data: 
			
		*Expected Outcome: 
			- The content explorer is opened to edit the content*/ 
		navTool.goToSiteExplorer();
		seHome.uploadFile("TestData/"+path);
		hp.goToHomePage();
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_FILE_UPLOAD_TITLE.replace("{$title}",path)));
		click(By.xpath(aHome.ELEMENT_ACTIVITY_VIEW_A_NODE.replace("{$title}", path)));
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_PREVIEW_FILE_WINDOW_NAME_OF_FILE.replace("{$title}",path)));
		
		info("Edit a file from the activity view");
		click(By.xpath(aHome.ELEMENT_ACTIVITY_EDIT_A_NODE.replace("{$title}", path)));
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_EDIT_FROM_HOMEPAGE.replace("{$title}",path)));
		
		navTool.goToSiteExplorer();
		seHome.deleteData(path);
 	}


	/**
	*<li> Case ID:116684.</li>
	*<li> Test Case Name: Update the File activity after moving a file.</li>
	*/
	@Test
	public  void test16_UpdateTheFileActivityAfterMovingAFile() {
		info("Test 16 Update the File activity after moving a file");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open Sites explorer
			- Move the file
			- back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The content of the file content activity isn't updated in the activity stream
			- A comment is added: File has been moved to: $valuewhere $value = path of the file.d*/ 
		String path = fData.getAttachFileByArrayTypeRandom(1);
		String fileRecept="intranet";
		navTool.goToSiteExplorer();
		seHome.uploadFile("TestData/"+path);
		dragAndDropToObject(By.xpath((seHome.ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", path)), By.xpath((seHome.ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", fileRecept)));
		alert.acceptAlert();
		Utils.pause(2000);
		hp.goToHomePage();
		
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("{$title}",path).replace("{$comment}","File has been moved to:")));

		navTool.goToSiteExplorer();
		seHome.selectNode(fileRecept);
		seHome.deleteData(path);
	}

	/**
	*<li> Case ID:116685.</li>
	*<li> Test Case Name: Update Content activity after moving a content.</li>
	*/
	@Test
	public  void test17_UpdateContentActivityAfterMovingAContent() {
		info("Test 17 Update Content activity after moving a content");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open Site explorer
			- Move the content
			- Back to the homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The content of the content activity isn't updated in the activity stream
			- A comment is added: Publication has been moved to: $value$value = path of the content.*/ 
		String random=getRandomNumber();
		String title =  txData.getContentByArrayTypeRandom(1)+random;
		String content =  txData.getContentByArrayTypeRandom(1)+random;
		String fileRecept="intranet";
		navTool.goToSiteExplorer();
		seHome.goToAddNewContent();
		createDoc.createNewDoc(selectDocumentType.WEBCONTENT);
		createDoc.addNewFile(title, content);
		createDoc.saveAndClose();
		dragAndDropToObject(By.xpath((seHome.ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", title)), By.xpath((seHome.ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", fileRecept)));
		alert.acceptAlert();
		Utils.pause(2000);
		hp.goToHomePage();
		
		waitForAndGetElement(By.xpath(aHome.ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("{$title}",title).replace("{$comment}","Publication has been moved to:")));

		navTool.goToSiteExplorer();
		seHome.selectNode(fileRecept);
		seHome.deleteData(title);
		
 	}
}