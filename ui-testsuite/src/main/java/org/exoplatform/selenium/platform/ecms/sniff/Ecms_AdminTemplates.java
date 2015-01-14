package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.mainEcmFunctions;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.specificEcmFunctions;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.testng.annotations.*;


	/**
	* @author eXo
	*
	*/
	public class Ecms_AdminTemplates extends PlatformBase{

		HomePagePlatform hp;
		ManageLogInOut magAc;
		TextBoxDatabase txData;		
		ContentAdministrationManagement caPage;
		NavigationToolbar navTool;
		CreateNewDocument CreNewDoc;
		SiteExplorerHome SEHome;
		@BeforeClass
		public void setUpBeforeTest() throws Exception{
			initSeleniumTest();
			getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
			driver.get(baseUrl);
			magAc = new ManageLogInOut(driver);
			CreNewDoc = new CreateNewDocument(driver);
			SEHome = new SiteExplorerHome(driver);
			navTool = new NavigationToolbar(driver);
			hp = new HomePagePlatform(driver);
			txData = new TextBoxDatabase();
			caPage= new ContentAdministrationManagement(driver);
			txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		}	

		@BeforeMethod
		public void beforeMethod(){
			magAc.signIn(DATA_USER1, DATA_PASS);
			navTool.goToContentAdministration();
		}
		
		@AfterClass
		public void afterTest(){
			driver.manage().deleteAllCookies();
			driver.quit();
		}
		
		
		
	/**
	*<li> Case ID:116589.</li>
	*<li> Test Case Name: Edit Metadata.</li>
	*<li> Case ID:116630.</li>
	*<li> Test Case Name: View Metadata.</li>
	*<li> Case ID:116631.</li>
	*<li> Test Case Name: Delete Metadata.</li>
	*/
	@Test
	public  void test01_02_03_Edit_View_DeleteMetadata() {
		info("Test 1: Edit,view and delete Metadata");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Edit Metadata
		*Input Data: 
			- Go to Content Administration/Template/ Metadata
			- Click corresponding Edit icon of Metadata you want to edit
			- Perform to edit
			- Click Apply
		*Expected Outcome: 
			The Metadata is edited successfully*/ 
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String superTypes = "exo:metadata";
		String permission="any";
		
		caPage.goToSpecificMainFunctions(mainEcmFunctions.REPOSITORY);
		caPage.goToSpecificFunctions(specificEcmFunctions.NODESTYPES);
		caPage.addNodeType(title, superTypes,"true");
		driver.navigate().refresh();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.TEMPLATES);
		caPage.goToSpecificFunctions(specificEcmFunctions.METADATA);
		
		caPage.editeMetadataNameAndPermission(title, newName, permission);
		click(caPage.ELEMENT_ECM_TEMPLATES_METADATA_FORM_SHOW.replace("{$name}", newName));
		waitForAndGetElement(caPage.ELEMENT_ECM_TEMPLATES_METADATA_CHECK_MATADATA_INFORMATION.replace("{$metadata}",title)); 
		click(caPage.ELEMENT_ECM_TEMPLATES_METADATA_CLOSE_VIEW);
		caPage.deleteMetadata(title);
	}

	/**
	*<li> Case ID:116599.</li>
	*<li> Test Case Name: Add Document Template.</li>
	*<li> Case ID:116632.</li>
	*<li> Test Case Name: Edit Document Template.</li>
	*<li> Case ID:116633.</li>
	*<li> Test Case Name: Delete Document Template.</li>
	*/
	@Test
	public void test04_05_06_AddDocument_Edit_DeleteTemplate() {
		info("Test 1: Add, edit and delete Document Template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String permission = "any";
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: AddTemplate
		*Input Data: 
			Create new template when put valid value in fields
			- Go to Content Administration/ Templates/ Documents
			- Click Add Template button 
			- Put value in required fields
			- Click Save button
		*Expected Outcome: 
			- Form to manage template is shown with:  + 3 tabs are added to categorize templates by their nature : Documents, Actions and Others
			- Template list is displayed with 4 columns: Icon, Template, Type, Actions
			- A new template is created successfully*/ 
		caPage.goToSpecificFunctions(specificEcmFunctions.DOCUMENTS);
		caPage.addDocumentInTemplates(title,permission);
		waitForAndGetElement(caPage.ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST.replace("{$name}",title));
		caPage.editDocumentInTemplates(title, newTitle);
		caPage.deleteCategories(newTitle);
	}

	/**
	*<li> Case ID:116634.</li>
	*<li> Test Case Name: Add List Template.</li>
	*<li> Case ID:116635.</li>
	*<li> Test Case Name: Edit List Template.</li>
	*<li> Case ID:116636.</li>
	*<li> Test Case Name: Delete List Template.</li>
	*/
	@Test
	public  void test07_08_09_Add_Edit_DeleteListTemplate() {
		info("Test 7: Add, Edit and Delete List Template");
		String tempName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Template
		*Input Data: 
			Create new template when put valid value in fields
			- Go to Content Administration/ Templates/ List
			- Click Add Template button 
			- Put value in required fields
			- Click Save button
		*Expected Outcome: 
			- Manage List template is shown with:  + 3 tabs. One for each type of clv template : Content for list templates, Navigation for navigation templates and Paginator for paginator templates. All tree tabs have the same table inside + In Document tab: 3 columns: Name, Template, Actions
			- A new template is created successfully*/ 
		caPage.goToSpecificFunctions(specificEcmFunctions.LIST);
		caPage.addTemplateInList(name,tempName,content);
		caPage.editTemplateNameInList(name,newName);
		caPage.deleteTemplateList(newName);
 	}
}