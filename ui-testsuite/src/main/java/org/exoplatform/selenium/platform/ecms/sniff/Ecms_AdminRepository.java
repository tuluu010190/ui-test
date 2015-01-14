package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.mainEcmFunctions;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.specificEcmFunctions;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument.selectDocumentType;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.openqa.selenium.By;
import org.testng.annotations.*;


/**
 * @author eXo
 *
 */
public class Ecms_AdminRepository extends PlatformBase{
	HomePagePlatform hp;
	ManageLogInOut magAc;
	TextBoxDatabase txData;		
	ContentAdministrationManagement caPage;
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
		hp = new HomePagePlatform(driver);
		txData = new TextBoxDatabase();
		caPage= new ContentAdministrationManagement(driver);
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
	}	

	@BeforeMethod
	public void beforeMethod(){
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToPageAdministration();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.REPOSITORY);
	}
	
	@AfterClass
	public void afterTest(){
		magAc.signOut();
		driver.quit();
	}


	/**
	 *<li> Case ID:116588.</li>
	 *<li> Test Case Name: Unlock a Node.</li>
	 */
	@Test
	public  void test01_UnlockANode() {
		info("Test 1: Unlock a Node");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Unlock a node
		 *Input Data: 
			- Go to Site explorer : perform to lock a node
			- Go to Administration/Repository/ Locks 
			- Go to Locked node tab
			- Click corresponding Unlock icon of locked node
		 *Expected Outcome: 
			- Node is unlocked*/ 
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		hp.goToSiteExplorer();
		SEHome.goToAddNewContent();
		info("Create new file document");
		CreNewDoc.createNewDoc(selectDocumentType.WEBCONTENT);
		CreNewDoc.addNewWebContent(title, content);
		CreNewDoc.saveAndClose();
		SEHome.lockNode(title);
		hp.goToPageAdministration();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.REPOSITORY);
		caPage.goToSpecificFunctions(specificEcmFunctions.LOCKS);
		click(By.xpath(caPage.ELEMENT_ECM_REPOSITORY_UNLOCK_NODE_LIST.replace("{$name}",title)));
		hp.goToSiteExplorer();
		SEHome.deleteData(title);
	}

	/**
	 *<li> Case ID:116590.</li>
	 *<li> Test Case Name: Add Node types.</li>
	 *<li> Case ID:116628.</li>
	 *<li> Test Case Name: View Node types.</li>
	 */
	@Test
	public void test02_03_AddNodeTypes_ViewNode() {
		info("Test 2: Add Node and show it");

		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String superTypes ="exo:calendar";

		caPage.goToSpecificFunctions(specificEcmFunctions.NODESTYPES);
		caPage.addNodeType(name, superTypes);
		caPage.searchNodeAndCheckIt(name, superTypes+", nt:base");

		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Add Node types
		 *Input Data: 
			Add new node type
			- Go to Content Administration/Repository/Node Types
			- Click on Add button
			- Input Node Type Name
			- Select super type
			- Click Save button
		 *Expected Outcome: 
			New node type is created*/ 

	}

	/**
	 *<li> Case ID:116601.</li>
	 *<li> Test Case Name: Namespace registry.</li>
	 */
	@Test
	public  void test04_NamespaceRegistry() {
		info("Test 3: Namespace registry");
		String prefix = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url = "www.exo-fqa-test"+getRandomNumber()+".com";
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Namespace registry
		 *Input Data: 
			- Go to Content Administration/Repository/Namespace
			- Click on Register button 
			- Put value in required fields
			- Click Save button
		 *Expected Outcome: 
			New namespace is registered successfully.*/ 
		caPage.goToSpecificFunctions(specificEcmFunctions.NAMESPACES);
		caPage.registerNamespace(prefix, url);
		waitForAndGetElement(caPage.ELEMENT_ECM_REPOSITORY_NAMESPACES_CHECK_LIST_URL_AND_PREFIX.replace("{$url}",url).replace("{$prefix}",prefix));
	}


	/**
	 *<li> Case ID:116629.</li>
	 *<li> Test Case Name: Manage lock.</li>
	 */
	@Test
	public  void test05_ManageLock() {
		info("Test 5: Manage lock");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String group = "*:/developers";
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Manage lock
		 *Input Data: 
			- Go to Administration/Repository/ Locks 
			- Go to Manage lock tab
			- Perform to add some group/ users which have permission to unlock a locked node
			- Can Delete permission of group/ user by click Delete icon
		 *Expected Outcome: 
			- Group is added permission. All users In the group will be able unlock a locked node
			- Group is removed permission*/ 
		hp.goToSiteExplorer();
		SEHome.goToAddNewContent();
		info("Create new file document");
		CreNewDoc.createNewDoc(selectDocumentType.WEBCONTENT);
		CreNewDoc.addNewWebContent(title, content);
		CreNewDoc.saveAndClose();
		SEHome.lockNode(title);
		hp.goToPageAdministration();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.REPOSITORY);
		caPage.goToSpecificFunctions(specificEcmFunctions.LOCKS);
		click(caPage.ELEMENT_ECM_REPOSITORY_MANAGE_LOCK);
		click(caPage.ELEMENT_ECM_REPOSITORY_LOCKS_DEVELOPMENT_GROUP);
		click(caPage.ELEMENT_ECM_REPOSITORY_LOCKS_ALL_GROUP);
		waitForAndGetElement(caPage.ELEMENT_ECM_REPOSITORY_CHECK_LOCK_PERMISSION.replace("{$group}",group));
		click(caPage.ELEMENT_ECM_REPOSITORY_DELETE_LOCK_PERMISSION.replace("{$group}",group));
		waitForElementNotPresent(caPage.ELEMENT_ECM_REPOSITORY_CHECK_LOCK_PERMISSION.replace("{$group}",group));
		hp.goToSiteExplorer();
		SEHome.deleteData(title);	
	}
}