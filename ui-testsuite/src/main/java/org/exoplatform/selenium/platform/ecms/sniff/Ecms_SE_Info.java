package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.ecms.ECMS_Permission;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class Ecms_SE_Info extends PlatformBase{

	HomePagePlatform hp;
	ManageLogInOut magAc;
	SiteExplorerHome SEHome;
	PlatformPermission PlfPerm;
	NavigationToolbar navTool;
	ContentAdministrationManagement caMag;
	
	AttachmentFileDatabase fData;
	UserDatabase userData;
	Button btn;
	TextBoxDatabase txData;

	ECMS_Permission EcmsPerm;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		magAc.signIn(DATA_USER1, DATA_PASS);
	}

	@BeforeClass
	public void setUpBeforeTest() throws Exception{
		getDriverAutoSave();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		driver.get(baseUrl);
		magAc = new ManageLogInOut(driver);
		hp = new HomePagePlatform(driver);
		SEHome = new SiteExplorerHome(driver);
		PlfPerm = new PlatformPermission(driver);
		btn = new Button(driver, this.plfVersion);
		navTool = new NavigationToolbar(driver);
		caMag = new ContentAdministrationManagement(driver);
		
		txData = new TextBoxDatabase();
		userData = new UserDatabase();
		fData = new AttachmentFileDatabase();
		userData.setUserData(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);

		EcmsPerm = new ECMS_Permission(driver);
	}

	@AfterMethod
	public void afterMethod(){
		magAc.signOut();
	}

	@AfterClass
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 *<li> Case ID:116591.</li>
	 *<li> Test Case Name: Add Permission.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 *	 *<li> Case ID:116639.</li>
	 *<li> Test Case Name: Edit Permission.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 *	 *<li> Case ID:116640.</li>
	 *<li> Test Case Name: Delete Permission.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_02_03_AddEditDeletePermission() {
		info("Test 1: Add Permission");
		info("Get data test");
		String node1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String folderType = "Content Folder";
		info("Finished getting data test");

		navTool.goToSiteExplorer();
		SEHome.goToAddNewFolder();
		info("Add permisison for a node");
		//Create node1, node2
		SEHome.createFolder(node1, folderType);
		SEHome.selectNode(node1);

		//Add permission "read", "write" for mary
		SEHome.goToPermission();
		EcmsPerm.deletePermissionNode("mary");
		EcmsPerm.changeRight("user", "Mary", true, true, false, "");
		EcmsPerm.closePermission();
		
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		navTool.goToSiteExplorer();
		//Check if mary has edit, read on node1
		SEHome.selectNode(node1);
		//Delete data
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		navTool.goToSiteExplorer();


		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Add Permission
		 *Input Data: 
			- Select one node
			- Click on Permissions icon on action bar
			- Add permission for node
			- Choose user/group to add permission
			- Click Save
			- Log out and log in with an user who match with the permission set above
		 *Expected Outcome: 
			- The node is added permission
			- User will take action on it as his rights*/ 
		info("Test 02: Edit Permission");
		SEHome.selectNode(node1);
		SEHome.goToPermission();
		EcmsPerm.changeRight("user", "Mary", false, false, true, "");
		waitForAndGetElement(By.xpath("//*[@checked='' and @name='maryremove']/.."));
		EcmsPerm.closePermission();
		info("Test 03: Delete Permission");
		EcmsPerm.deletePermissionNode("mary");
		info("Delete data test");
		SEHome.deleteData(node1);
	}

	/**
	 *<li> Case ID:116609.</li>
	 *<li> Test Case Name: View metadata.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_ViewMetadata() {
		info("Test 04: View metadata");
		info("Get data test");
		String path = fData.getAttachFileByArrayTypeRandom(1);
		info("Finished getting data test");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: View metadata
		 *Input Data: 
			- Upload a file
			- Select it 
			- Click Metadata
		 *Expected Outcome: 
			View matadata form is shown*/ 
		navTool.goToSiteExplorer();
		SEHome.uploadFile("TestData/"+path);
		SEHome.selectNode(path);
		click(SEHome.ELEMENT_ACTIONBAR_MORE);
		SEHome.viewMetadata();
		info("Delete data test");
		SEHome.deleteData(path);
	}
}