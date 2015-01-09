package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.mainEcmFunctions;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.specificEcmActionstypes;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.specificEcmFunctions;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument.folderType;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument.selectDocumentType;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.testng.annotations.*;


public class Ecms_SE_Admin extends PlatformBase{

	HomePagePlatform hp;
	ManageLogInOut magAc;
	SpaceManagement spManag;
	TextBoxDatabase txData;
	UserDatabase userData;
	AttachmentFileDatabase fData;
	SiteExplorerHome SEHome;
	CreateNewDocument CreNewDoc;
	
	ContentAdministrationManagement caPage;

	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		getDriverAutoSave();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		driver.get(baseUrl);
		
		magAc = new ManageLogInOut(driver);
		hp = new HomePagePlatform(driver);
		SEHome = new SiteExplorerHome(driver);
		CreNewDoc = new CreateNewDocument(driver);
		spManag = new SpaceManagement(driver);
		caPage = new ContentAdministrationManagement(driver);
		
		txData = new TextBoxDatabase();
		fData = new AttachmentFileDatabase();
		userData = new UserDatabase();
		
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		userData.setUserData(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		magAc.signIn(DATA_USER1, DATA_PASS);
	}

	

	@AfterMethod
	public void afterMethod(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 * By QuynhPT
	 *<li> Case ID:116656</li>
	 *<li> Test Case Name: Add Relation</li>
	 */

	@Test
	public  void test01_AddRelation() {
		info("Test 1: Add Relation");
		/*
		 * Precondition: If Relations is not available on action bar, 
		 * go to Content Administration/ Manage View and edit your current view in use with Relation option ticked
		 * Step Number: 1
		 *Step Description: 
			Step 1: Add Relation
		 *Input Data: 
			- Add Relation
            - Select a node
            - Click on Relations icon in the action bar
            - Go to Select Relation tab
            - Select document to add relation for document/uploaded file
		 *Expected Outcome: 
			- A relation is added for a node.
			*/ 
		
		//Declare input data test
		String node1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String node2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		//Declare a string array
		String[] nameContent={node1};
		String[] arrayPath={"sites"};
		
		//Go to Site Explorer
		hp.goToSiteExplorer();
				
		//check action
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_RELATION, 3000, 0) == null) {
			hp.goToPageAdministration();
			caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
			caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
			caPage.addActionsForAView("Web",specificEcmActionstypes.MANAGE_RELATION);
			magAc.signOut();
			magAc.signIn(DATA_USER1, DATA_PASS);
			hp.goToSiteExplorer();
		}
		
		info("Add Relation");
		//Create node1
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node1, node1);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
		
		//Go back to farther node
		click(SEHome.ELEMENT_SIDE_BAR_MAINTAB);
		Utils.pause(2000);
		
		// Create node2
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node2, node2);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
				
		//Click on "More" link 
		click(SEHome.ELEMENT_ACTIONBAR_MORE);
		//Select Relation link
		SEHome.goToManageRelation();
		SEHome.addRelation(nameContent,arrayPath);
		SEHome.closeAddRelationPopup();
		Utils.pause(5000);
		
		//Check Relation on left of sideBar
		SEHome.goToRelationSideBar();
		waitForAndGetElement(SEHome.ELEMENT_SIDE_BAR_RELATION_TAB_FILE_TITLE.replace("${nameContent}",node1));
		click(SEHome.ELEMENT_SIDE_BAR_RELATION_TAB_FILE_TITLE.replace("${nameContent}",node1));
		Utils.pause(2000);
		
		//Verify the file in reference section
		waitForAndGetElement(SEHome.ELEMENT_SIDE_BAR_RELATION_TAB_FILE_TITLE.replace("${nameContent}",node2));
		
		info("Delete all data test");
		SEHome.deleteData(node1);
		SEHome.deleteData(node2);
	}

	/**
	 * By QuynhPT
	 * <li>Case ID:116657.</li> 
	 * <li>Test Case Name: Delete Relation</li>
	 */

	@Test
	public  void test02_DeleteRelation() {
		info("Test 02: Delete Relation");
		/*
		 * Precondition: If Relations is not available on action bar, 
		 * go to Content Administration/ Manage View and edit your current view in use with Relation option ticked
		 * Step Number: 1
		 *Step Description: 
			Step 1: Delete Relation
		 *Input Data: 
            - Select a node
            - Click on Relations icon in the action bar
            - Go to Select Relation tab
            - Select document to add relation for document/uploaded file 
            - Go to Manage relation list tab
            - Click on corresponding Delete icon of Relation 
		 *Expected Outcome: 
			- Relation is deleted for a node.
			*/ 

		//Declare input data test
		String node1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String node2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		//Declare a string array
		String[] nameContent={node1};
		String[] arrayPath={"sites"};
		
		//Go to Site Explorer
		hp.goToSiteExplorer();
				
		//check action
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_RELATION, 3000, 0) == null) {
			hp.goToPageAdministration();
			caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
			caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
			caPage.addActionsForAView("Web",
					specificEcmActionstypes.MANAGE_RELATION);
			magAc.signOut();
			magAc.signIn(DATA_USER1, DATA_PASS);
			hp.goToSiteExplorer();
		}
		
		info("Add Relation");
		//Create node1
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node1, node1);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
		
		//Go back to farther node
		click(SEHome.ELEMENT_SIDE_BAR_MAINTAB);
		Utils.pause(2000);
		
		// Create node2
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node2, node2);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
				
		//Click on "More" link 
		click(SEHome.ELEMENT_ACTIONBAR_MORE);
		//Select Relation link
		SEHome.goToManageRelation();
		SEHome.addRelation(nameContent,arrayPath);
		SEHome.deleteRelation(node1.toLowerCase());
		SEHome.closeAddRelationPopup();
		Utils.pause(2000);
		
		
		//Check Relation on left of sideBar
		SEHome.goToRelationSideBar();
		waitForElementNotPresent(SEHome.ELEMENT_SIDE_BAR_RELATION_TAB_FILE_TITLE.replace("${nameContent}",node1));
		
		info("Delete all data test");
		SEHome.deleteData(node1);
		SEHome.deleteData(node2);
		
	 }
	/**
	 *<li> Case ID:116596.</li>
	 *<li> Test Case Name: Show/ Hide Relation</li>
	 */
	@Test
	public  void test03_ShowHideRelation() {
		info("Test 3: Show/Hide Relation");
		
		// Declare input data test
		String node1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String node2 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		// Declare a string array
		String[] nameContent = { node1 };
		String[] arrayPath = { "sites" };

		//Go to Site Explorer
		hp.goToSiteExplorer();
		
		//Check action
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_RELATION, 3000, 0) == null) {
			hp.goToPageAdministration();
			caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
			caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
			caPage.addActionsForAView("Web",specificEcmActionstypes.MANAGE_RELATION);
			magAc.signOut();
			magAc.signIn(DATA_USER1, DATA_PASS);
			hp.goToSiteExplorer();
		}
		
		info("Show/ Hide Relation");
		// Create node1
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node1, node1);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);

		// Go back to farther node
		click(SEHome.ELEMENT_SIDE_BAR_MAINTAB);
		Utils.pause(2000);

		// Create node2
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node2, node2);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
		
		// Click on "More" link
		click(SEHome.ELEMENT_ACTIONBAR_MORE);
		// Select Relation link
		SEHome.goToManageRelation();
		SEHome.addRelation(nameContent, arrayPath);
		SEHome.closeAddRelationPopup();
		Utils.pause(5000);
		
		//Show relation
		SEHome.goToRelationSideBar();
		waitForAndGetElement(SEHome.ELEMENT_SIDE_BAR_RELATION_TAB_FILE_TITLE.replace("${nameContent}",node1));
		
		//Hide relation
		click(SEHome.ELEMENT_SIDE_BAR_FILE_EXPLORER_ICON);
		waitForAndGetElement(SEHome.ELEMENT_SIDEBAR_SITES_MANAGEMENT);
		
		info("Delete all data test");
		SEHome.deleteData(node1);
		SEHome.deleteData(node2);
	}

	/**
	 *<li> Case ID:116655.</li>
	 *<li> Test Case Name: Import a node</li>
	 */
	@Test
	public  void test04_ImportANode() {
		info("Test 4: Import a Node");

		String node1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String filePath = fData.getAttachFileByArrayTypeRandom(11);
		//Go to Site Explorer
		hp.goToSiteExplorer();
		//Click on Add New Folder button
		SEHome.goToAddNewFolder();
		
		//Create Folder node
		CreNewDoc.createNewFolder(node1, folderType.Content);
		//Select the folder
		SEHome.selectNode(node1);
		
		//Check action
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_IMPORT_BUTTON, 3000, 0) == null) {
			// Click on "More" link
			click(SEHome.ELEMENT_ACTIONBAR_MORE);
			//if not found elment, go to Administration to add it
			if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_IMPORT_BUTTON, 3000, 0) == null) {
				hp.goToPageAdministration();
				caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
				caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
				caPage.addActionsForAView("Web",specificEcmActionstypes.IMPORT_NOTE);
				magAc.signOut();
				magAc.signIn(DATA_USER1, DATA_PASS);
				hp.goToSiteExplorer();
				SEHome.selectNode(node1);
			}
		}
		
		SEHome.goToImportNode();
		SEHome.importNode("TestData/"+filePath,"Create New",false, "");
		
		info("Delete all data test");
		SEHome.deleteData(node1);
	}

	/**
	 *<li> Case ID:116578.</li>
	 *<li> Test Case Name: Export a node.</li>
	 */
	@Test
	public  void test05_ExportANode() {
		info("Test 5: Export a Node");

		/*Step Number: 1
		 *Step Name: Export a node
		 *Step description:
			- Select one node
			- On action bar, click Export button
			- Choose System View in Format
			- Click on Export button
			- Click Save in the bottom message to export.
		 *Expected Outcome: 
			- Node is exported successfully.
		*/ 

		String node1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		//Go to Site Explorer
		hp.goToSiteExplorer();
		
		info("Export a node");
		//Click on Add New Folder button
		SEHome.goToAddNewFolder();
				
		//Create Folder node
		CreNewDoc.createNewFolder(node1, folderType.Content);
		//Select the folder
		SEHome.selectNode(node1);
		
		//verify the Export action on action bar
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_EXPORT_BUTTON, 3000, 0) == null) {
			// Click on "More" link
			click(SEHome.ELEMENT_ACTIONBAR_MORE);
			// if not found elment, go to Administration to add it
			if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_EXPORT_BUTTON, 3000, 0) == null) {
				hp.goToPageAdministration();
				caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
				caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
				caPage.addActionsForAView("Web",specificEcmActionstypes.EXPORT_NODE);
				magAc.signOut();
				magAc.signIn(DATA_USER1, DATA_PASS);
				hp.goToSiteExplorer();
				// Select the folder
				SEHome.selectNode(node1);
			}
		}
		
		SEHome.goToExportNode();
		SEHome.exportNode(true, false);
		
		info("Delete all data test");
		SEHome.deleteData(node1);
	}

	/**
	 *<li> Case ID:116584.</li>
	 *<li> Test Case Name: Add Category.</li>

	 */
	@Test
	public  void test06_Add_Delete_Category() {
		info("Test 6: Add a category");

		/*Step Number: 1
		 *Step Name:Add Category
		 *Step Description: 
			- Add category for node
			- Select a document/Uploaded file
			- Click on Categories icon in the action bar
			- Select category to add for document/Uploaded file
		 *Expected Outcome: 
			- Category added for Document/uploaded file
		*/

		String node1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String[] arrayCatePath={"Defense"};
		String categoryTree = "powers";
		String nameSelectedCategory = "Healing";
		
		hp.goToSiteExplorer();
		info("Add Category");
		//Create node1
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node1, node1);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
			
		// verify the Export action on action bar
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_ADD_CATEGORY_BUTTON, 3000,
				0) == null) {
			// Click on "More" link
			click(SEHome.ELEMENT_ACTIONBAR_MORE);
			// if not found elment, go to Administration to add it
			if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_ADD_CATEGORY_BUTTON,
					3000, 0) == null) {
				hp.goToPageAdministration();
				caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
				caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
				caPage.addActionsForAView("Web",specificEcmActionstypes.ADD_CATEGORY);
				magAc.signOut();
				magAc.signIn(DATA_USER1, DATA_PASS);
				hp.goToSiteExplorer();
				SEHome.selectNode(node1);
			}
		}

		SEHome.goToAddCategory();
		SEHome.addCategory(categoryTree,arrayCatePath, nameSelectedCategory);
		waitForAndGetElement(SEHome.ELEMENT_ADD_CATEGORY_POPUP_DELETE_CATEGORY.replace("${nameCategory}",nameSelectedCategory));
		SEHome.closeAddCategoryPopup();
		
		info("Delete all data test");
		SEHome.deleteData(node1);
	}
	
	/**<li> Case ID:116654.</li>
	 *<li> Test Case Name: Delete a category.</li>
	 *<li> Precondition: If Category is not available on action bar, 
	 *go to Content Administration/ Manage View and edit your current view 
	 *in use with Category option ticked</li>
	 */

    @Test
	public void test07_Delete_Category() {
		info("Test 7: Delete a category");
		/*Step Number: 1
		 *Step Name:Delete a category
		 *Step Description: 
			- Select a document/Uploaded file
			- Click on Categories icon in the action bar
			- Select category to add for document/Uploaded file
			- Delete category
			- Click on corresponding Delete icon of category
		 *Expected Outcome: 
			- Document/uploaded file doesn't have any category.
		*/
		String node1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String[] arrayCatePath={"Defense"};
		String categoryTree = "powers";
		String nameSelectedCategory = "Healing";
		
		info("Add Category");
		//Create node1
		hp.goToSiteExplorer();
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node1, node1);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
			
		// verify the Export action on action bar
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_ADD_CATEGORY_BUTTON, 3000,
				0) == null) {
			// Click on "More" link
			click(SEHome.ELEMENT_ACTIONBAR_MORE);
			// if not found elment, go to Administration to add it
			if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_ADD_CATEGORY_BUTTON,
					3000, 0) == null) {
				hp.goToPageAdministration();
				caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
				caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
				caPage.addActionsForAView("Web",specificEcmActionstypes.ADD_CATEGORY);
				magAc.signOut();
				magAc.signIn(DATA_USER1, DATA_PASS);
				hp.goToSiteExplorer();
				SEHome.selectNode(node1);
			}
		}

		SEHome.goToAddCategory();
		SEHome.addCategory(categoryTree,arrayCatePath, nameSelectedCategory);
		SEHome.deleteCategory(nameSelectedCategory);
		SEHome.closeAddCategoryPopup();
		
		info("Delete all data test");
		SEHome.deleteData(node1);
		
	}
	/**
	 *<li> Case ID:116610.</li>
	 *<li> Test Case Name: View Node Properties</li>
	 */
	@Test
	public  void test08_ViewNodeProperties() {
		info("Test 08: View Node Properties");
		
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
		   - View node properties
		   - Create a node
		   - Select this node
		   - Click on Properties on action bar
		   - Add properties
		   - Go to Add new properties Tab
		   - Perform to add new a properties for this node
		 *Expected Outcome: 
		   - Manage properties form is shown, and all properties of this node is shown here.
		   - New properties is added
		   */

		String node1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String property = "exo:summary";
		
		info("View Node Properties");
		// Create node1
		hp.goToSiteExplorer();
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node1, node1);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
		
		// verify the Export action on action bar
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_PROPERTIES,3000, 0) == null) {
			// Click on "More" link
			click(SEHome.ELEMENT_ACTIONBAR_MORE);
			// if not found elment, go to Administration to add it
			if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_PROPERTIES, 3000, 0) == null) {
				hp.goToPageAdministration();
				caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
				caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
				caPage.addActionsForAView("Web",specificEcmActionstypes.VIEW_PROPERTIES);
				magAc.signOut();
				magAc.signIn(DATA_USER1, DATA_PASS);
				hp.goToSiteExplorer();
				SEHome.selectNode(node1);
			}
		}
		
		//Add a property
		SEHome.goToProperties();
		SEHome.addProperty(property, property);
		
		info("Delete all data test");
		SEHome.deleteData(node1);
		
	}

	/**
	 *<li> Case ID:116593.</li>
	 *<li> Test Case Name: Manage Publication.</li>
	 */
	@Test
	public  void test09_ManagePublication() {
		info("Test 09: Manage Publication");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			- S	elect a document/Uploaded file
			- Click on Publications icon in the action bar
			- Click on Stage
			- Setting time in From and To field
			- Click Save
		 *Expected Outcome: 
			- Document/uploaded file is published during the time in From and To field
		*/
		
		String node1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		Date date = new Date();
		
		info("Manage Publication");
		// Create node1
		hp.goToSiteExplorer();
		SEHome.goToAddNewContent();
		CreNewDoc.createNewDoc(selectDocumentType.FILE);
		CreNewDoc.addNewFile(node1, node1);
		CreNewDoc.saveAndClose();
		Utils.pause(5000);
		
		// verify the Export action on action bar
		if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_MANAGER_PUBLISHTATION, 3000, 0) == null) {
			// Click on "More" link
			click(SEHome.ELEMENT_ACTIONBAR_MORE);
			// if not found elment, go to Administration to add it
			if (waitForAndGetElement(SEHome.ELEMENT_ACTIONBAR_MANAGER_PUBLISHTATION, 3000,0) == null) {
				hp.goToPageAdministration();
				caPage.goToSpecificMainFunctions(mainEcmFunctions.EXPLORER);
				caPage.goToSpecificFunctions(specificEcmFunctions.VIEW);
				caPage.addActionsForAView("Web",specificEcmActionstypes.MANAGE_PUBLISHTATION);
				magAc.signOut();
				magAc.signIn(DATA_USER1, DATA_PASS);
				hp.goToSiteExplorer();
				SEHome.selectNode(node1);
			}
		}
		
		//Select Staged state for this document
		SEHome.goToManagePublishtation();
		SEHome.managePublication("Staged", dateFormat.format(date.getTime()),dateFormat.format(date.getTime()));
		
		info("Delete all data test");
		SEHome.deleteData(node1);
		
	}
}