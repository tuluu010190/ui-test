package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.acme.AcmeHomePage;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.EditPageWCM;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument.selectDocumentType;
import org.exoplatform.selenium.platform.gatein.PageEditor;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.openqa.selenium.By;
import org.testng.annotations.*;

/**
 * @date 15-January-2015
 * @author exo
 */

	public class Ecms_SE_Collaboration extends PlatformBase {

		HomePagePlatform hp;
		ManageLogInOut magAc;
		ManageAlert magAlert;
		Button but;
		TextBoxDatabase txData;
		SiteExplorerHome SEHome;
		CreateNewDocument creNewDoc;
		EditPageWCM editPageWCM;
		PageEditor pEdit;
		NavigationToolbar navTool;
		AcmeHomePage acmeHP;
		AttachmentFileDatabase fData;

		@BeforeMethod
		public void setUpBeforeTest() throws Exception{
			initSeleniumTest();
			getDefaultUserPass(userDataFilePath,defaultSheet,true,jdbcDriver,dbUrl,user,pass,sqlUser);
			driver.get(baseUrl);
			magAc = new ManageLogInOut(driver);
			but = new Button(driver);
			hp = new HomePagePlatform(driver);
			magAc.signIn(DATA_USER1, DATA_PASS);
			txData = new TextBoxDatabase();
			txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
			SEHome = new SiteExplorerHome(driver);
			creNewDoc = new CreateNewDocument(driver);
			editPageWCM = new EditPageWCM(driver);
			pEdit = new PageEditor(driver);
			navTool = new NavigationToolbar(driver);
			acmeHP = new AcmeHomePage(driver);
			magAlert = new ManageAlert(driver, this.plfVersion);
			fData = new AttachmentFileDatabase();
			fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		}

		@AfterMethod
		public void afterTest(){
			driver.manage().deleteAllCookies();
			driver.quit();
		}
		
		
	/**
	*<li> Case ID:116564.</li>
	*<li> Test Case Name: Add translation for document/uploaded file.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddTranslationForDocumentuploadedFile() {
		info("Test 1: Add translation for document/uploaded file");
		String number1= getRandomNumber();
		String number2 = getRandomNumber();
		String title = txData.getContentByArrayTypeRandom(1)+number1+"_EN";
		String content = txData.getContentByArrayTypeRandom(1)+number1+"_EN";
		String title2 = txData.getContentByArrayTypeRandom(1)+number2+"_FR";
		String content2 = txData.getContentByArrayTypeRandom(1)+number2+"_FR";
		
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add translation for document/uploaded file
		*Input Data: 
			- Add some documents in different languages, eg English, French...
			- Open document in English
			- Click on Add Translation icon on the action bar 
			- Navigate to French document
			- Save
			- Click Relation icon on side bar
		*Expected Outcome: 
			- Documents are created
			- French document is list in Languages list of English document.When you add this content in a CLV or SCV, change language, you will see effect*/ 
		
		navTool.goToSiteExplorer();
		SEHome.goToAddNewContent();
		creNewDoc.createNewDoc(selectDocumentType.FILE);
		creNewDoc.addNewFile(title, content);
		creNewDoc.saveAndClose();
		click(SEHome.ELEMENT_SITEEXPLORER_LEFTBOX_ROOTNODE);
		SEHome.goToAddNewContent();
		creNewDoc.createNewDoc(selectDocumentType.FILE);
		creNewDoc.addNewFile(title2, content2);
		select(creNewDoc.ELEMENT_FILEFORM_LANGUAGE, "fr", 2);
		Utils.pause(2000);
		creNewDoc.saveAndClose();
		
		click(SEHome.ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME.replace("${title}", title));
		SEHome.addTranslation();
		SEHome.editFolderPath(""+title2, "General Drives", "Sites Management", "");
		click(SEHome.ELEMENT_SAVE_BTN);
		waitForAndGetElement(SEHome.ELEMENT_SITEEXPLORER_LEFTBOX_RELATION);
		click(SEHome.ELEMENT_SITEEXPLORER_LEFTBOX_RELATION);
		waitForAndGetElement(SEHome.ELEMENT_SITEEXPLORER_LEFTBOX_TITLE_TRANSLATION.replace("${title}", title2));
		click(SEHome.ELEMENT_SITEEXPLORER_LEFTBOX_EXPLORER);
		SEHome.deleteData(title);
		SEHome.deleteData(title2);
 	}

	/**
	*<li> Case ID:116586.</li>
	*<li> Test Case Name: Add Comment.</li>
	*<li> Pre-Condition: If Comment is not available on action bar, go to Content Administration/ Explorer/ Views, Edit view being in use with Comment option is ticked</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_AddComment() {
		info("Test 2: Add Comment");
		String number1= getRandomNumber();
		String number2 = getRandomNumber();
		String title = txData.getContentByArrayTypeRandom(1)+number1;
		String content = txData.getContentByArrayTypeRandom(1)+number1;
		String content2 = txData.getContentByArrayTypeRandom(1)+number2;
		
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Comment
		*Input Data: 
			Add a comment
			- Select a document or uploaded file
			- Click on Comment icon on the action bar 
			- Fill comment's content
			- Save
		*Expected Outcome: 
			You can see the comment at the bottom of document/uploaded file.*/ 
		navTool.goToSiteExplorer();
		SEHome.goToAddNewContent();
		creNewDoc.createNewDoc(selectDocumentType.FILE);
		creNewDoc.addNewFile(title, content);
		creNewDoc.saveAndClose();

		click(SEHome.ELEMENT_ACTIONBAR_ADDCOMMENT);
		this.driver.navigate().refresh();
		inputFrame(creNewDoc.ELEMENT_FILEFORM_BLANK_CONTENT , content2);
		switchToParentWindow();
		click(SEHome.ELEMENT_SAVE_BTN);
		waitForAndGetElement(SEHome.ELEMENT_SITEEXPLORER_COMMENT.replace("${number}", "1"));
		SEHome.deleteData(title);
 	}

	/**
	*<li> Case ID:116592.</li>
	*<li> Test Case Name: Add a tag.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*
	**<li> Case ID:116652.</li>
	*<li> Test Case Name: Edit a tag.</li>
	*<li> Pre-Condition: A tag is created successfully</li>
	*<li> Post-Condition: </li>
	*
	**<li> Case ID:116653.</li>
	*<li> Test Case Name: Detele a tag.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: A tag is already created.</li>
	*/
	@Test
	public  void test03_07_08_AddEditDeleteATag() {
		info("Test 3: Add a tag");
		String number1= getRandomNumber();
		String number2 = getRandomNumber();
		String title = txData.getContentByArrayTypeRandom(1)+number1;
		String content = txData.getContentByArrayTypeRandom(1)+number1;
		String content2 = txData.getContentByArrayTypeRandom(1)+number2;
		String content3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		*Step Name: Step 1: Add a tag
		*Step Description: 
			- Select a document or uploaded file
			- Click on Tag button in the action bar (if not, select Tag from More drop
			-down menu)
			- Put name for a tag
			- Click Add button, the Close button
		*Input Data: 
			
		*Expected Outcome: 
			Node is added tag. You can find document using tag in Tag cloud of FE*/ 
		navTool.goToSiteExplorer();
		SEHome.goToAddNewContent();
		creNewDoc.createNewDoc(selectDocumentType.FILE);
		creNewDoc.addNewFile(title, content);
		creNewDoc.saveAndClose();

		click(SEHome.ELEMENT_ACTIONBAR_MORE);
		click(SEHome.ELEMENT_ACTIONBAR_TAG);
		type(SEHome.ELEMENT_SITEEXPLORER_TAG_NAME, content2, true);
		click(SEHome.ELEMENT_ADD_BTN);
		waitForAndGetElement(SEHome.ELEMENT_SITEEXPLORER_TAG_EXISTING.replace("${name}", content2));
		
		click(SEHome.ELEMENT_SITEEXPLORER_TAG_EXISTING.replace("${name}", content2));
		type(SEHome.ELEMENT_SITEEXPLORER_TAG_INPUT, content3, true);
		click(SEHome.ELEMENT_SAVE_BTN);
		waitForAndGetElement(SEHome.ELEMENT_SITEEXPLORER_TAG_EXISTING.replace("${name}", content3));
		
		click(SEHome.ELEMENT_SITEEXPLORER_TAG_DELETE);
		magAlert.acceptAlert();
		click(SEHome.ELEMENT_CLOSE_BTN);
		SEHome.deleteData(title);
 	}

	/**
	*<li> Case ID:116611.</li>
	*<li> Test Case Name: Vote for document/uploaded file.</li>
	*<li> Pre-Condition: If Vote is not available on action bar, go to Content Administration/Manage View, and edit your current view in use with Vote option ticked</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_VoteForDocumentuploadedFile() {
		info("Test 4: Vote for document/uploaded file");
		
		String fileName = fData.getAttachFileByArrayTypeRandom(1);
		
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Vote for document/uploaded file
		*Input Data: 
			- Create a document or upload a file
			- Select this node
			- Click on Vote icon on action bar, perform to vote
		*Expected Outcome: 
			The node is voted*/ 
		navTool.goToSiteExplorer();
		SEHome.uploadFile("TestData/"+fileName);
		click(By.xpath((SEHome.ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", fileName)));
		click(SEHome.ELEMENT_ACTIONBAR_MORE);
		click(SEHome.ELEMENT_ACTIONBAR_VOTE);
		click(SEHome.ELEMENT_SITEEXPLORER_VOTE_AVERAGE);
		waitForAndGetElement(SEHome.ELEMENT_SITEEXPLORER_VOTEONDOCUMENT);	
		SEHome.deleteData(fileName);
 	}

	/**
	*<li> Case ID:116650.</li>
	*<li> Test Case Name: Edit Comment.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_EditComment() {
		info("Test 5: Edit Comment");
		info("Get data test");
		String number1= getRandomNumber();
		String number2 = getRandomNumber();
		String title = txData.getContentByArrayTypeRandom(1)+number1;
		String content = txData.getContentByArrayTypeRandom(1)+number1;
		String content2 = txData.getContentByArrayTypeRandom(1)+number2;
		String content3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Finished getting data test");
		
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Edit Comment
		*Input Data: 
			Add a comment
			- Select a document or uploaded file
			- Click on Comment icon in the action bar 
			- Put content for comment
			- Click Save buttonEdit a comment
			- Show comment, click on Edit icon, perform to edit, click Save
		*Expected Outcome: 
			- Comment is edited*/ 
		navTool.goToSiteExplorer();
		info("Add a new content");
		SEHome.goToAddNewContent();
		info("Select a document type");
		creNewDoc.createNewDoc(selectDocumentType.FILE);
		info("Create a new file");
		creNewDoc.addNewFile(title, content);
		info("Save and close the file");
		creNewDoc.saveAndClose();
		
		SEHome.addEditComment(content2,true);
		info("Veriy that the comment is added");
		waitForAndGetElement(By.xpath((SEHome.ELEMENT_SITEEXPLORER_COMMENT).replace("${number}", "1")));
		
		info("Click on Show comment button on action bar");
		click(SEHome.ELEMENT_SITEEXPLORER_COMMENT_SHOW);
		SEHome.addEditComment(content3,false);
		
		info("Click on Show comment button on action bar");
		click(SEHome.ELEMENT_SITEEXPLORER_COMMENT_SHOW);
		info("Verify that the comment is edited");
		waitForAndGetElement(By.xpath((SEHome.ELEMENT_SITEEXPLORER_COMMENT_CONTENT).replace("${content}", content3)));
		info("The coment is edited successfully");
		SEHome.deleteData(title);
 	}

	/**
	*<li> Case ID:116651.</li>
	*<li> Test Case Name: Delete Comment.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_DeleteComment() {
		info("Test 6: Delete Comment");
		
		String number1= getRandomNumber();
		String number2 = getRandomNumber();
		String title = txData.getContentByArrayTypeRandom(1)+number1;
		String content = txData.getContentByArrayTypeRandom(1)+number1;
		String content2 = txData.getContentByArrayTypeRandom(1)+number2;
		
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Delete Comment
		*Input Data: 
			Add a comment
			- Select a document or uploaded file
			- Click on Comment icon in the action bar 
			- Put content for comment
			- Click Save buttonDelete a comment
			- Show the comment, click on Delete icon ,click OK
		*Expected Outcome: 
			Comment is deleted*/ 
		navTool.goToSiteExplorer();
		SEHome.goToAddNewContent();
		creNewDoc.createNewDoc(selectDocumentType.FILE);
		creNewDoc.addNewFile(title, content);
		creNewDoc.saveAndClose();

		click(SEHome.ELEMENT_ACTIONBAR_ADDCOMMENT);
		this.driver.navigate().refresh();
		inputFrame(creNewDoc.ELEMENT_FILEFORM_BLANK_CONTENT , content2);
		switchToParentWindow();
		click(SEHome.ELEMENT_SAVE_BTN);
		waitForAndGetElement(By.xpath((SEHome.ELEMENT_SITEEXPLORER_COMMENT).replace("${number}", "1")));
		
		click(SEHome.ELEMENT_SITEEXPLORER_COMMENT_SHOW);
		click(SEHome.ELEMENT_SITEEXPLORER_COMMENT_DELETE);
		magAlert.acceptAlert();
		waitForElementNotPresent(By.xpath((SEHome.ELEMENT_SITEEXPLORER_COMMENT).replace("${number}", "1")));
		SEHome.deleteData(title);
 	}

}