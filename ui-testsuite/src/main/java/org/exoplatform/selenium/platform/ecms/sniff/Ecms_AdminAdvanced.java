package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.mainEcmFunctions;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.specificEcmFunctions;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	/**
	* @author rosso
	*
	*/
	public class Ecms_AdminAdvanced extends PlatformBase{
		HomePagePlatform hp;
		ManageLogInOut magAc;
		TextBoxDatabase txData;		
		ContentAdministrationManagement caPage;
		@BeforeClass
		public void setUpBeforeTest() throws Exception{
			initSeleniumTest();
			getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
			driver.get(baseUrl);
			magAc = new ManageLogInOut(driver);
			
			hp = new HomePagePlatform(driver);
			txData = new TextBoxDatabase();
			caPage= new ContentAdministrationManagement(driver);
			txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		}	
		@BeforeMethod
		public void beforeMethod(){
			magAc.signIn(DATA_USER1, DATA_PASS);
			hp.goToPageAdministration();
			caPage.goToSpecificMainFunctions(mainEcmFunctions.ADVANCED);
		}
		
		@AfterMethod
		public void afterMethod(){
			magAc.signOut();
		}
		
		@AfterClass
		public void afterClass(){
			driver.quit();
		}	
		
	/**
	*<li> Case ID:116581.</li>
	*<li> Test Case Name: Add Action Type.</li>
	*<li> Case ID:116663.</li>
	*<li> Test Case Name: Edit Action Type.</li>
	*<li> Case ID:116664.</li>
	*<li> Test Case Name: Delete Action Type.</li>
	*/
	@Test
	public void test01_02_03_Add_Edit_Delete_ActionType() {
		info("Test 1: Add Action Type");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String Newtitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		caPage.goToSpecificFunctions(specificEcmFunctions.ACTIONS);
		caPage.addActionType(title, null, null);
		waitForAndGetElement(caPage.ELEMENT_ECM_ACTION_LIST.replace("{$name}",title));
		caPage.editActionType(title,Newtitle,null,null);
		caPage.deleteAction(Newtitle);
		
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Manage Action
		*Input Data: 
			- Go to Content Administration/Advanced /Action 
			- Click on Add Action Type button
			- Input required fields
			- Click Save
		*Expected Outcome: 
			The action is created*/ 

 	}

	/**
	*<li> Case ID:116595.</li>
	*<li> Test Case Name: Add Query.</li>
	*<li> Case ID:116617.</li>
	*<li> Test Case Name: Edit Query.</li>
	*<li> Case ID:116618.</li>
	*<li> Test Case Name: Delete Query.</li>
	*/
	@Test
	public  void test04_05_06_Add_Edit_Delete_Query() {
		info("Test 2: Add Query");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String type = "SQL";
		String permission = "any";
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add query
		*Input Data: 
			- Go to Content Administration/ Advanced/ Queries
			- Click on Add Query button
			- Input all required field
			- Click Save
		*Expected Outcome: 
			The query is added successfully*/ 
		caPage.goToSpecificFunctions(specificEcmFunctions.QUERIES);
		caPage.addQueries(title, null, null, permission);
		caPage.editQueries(title,type, null, null);
		waitForAndGetElement(By.xpath(caPage.ELEMENT_ECM_ADVANCED_QUERIES_TYPE_LIST.replace("{$name}", title).replace("{$type}","sql")));
		caPage.deleteQueries(title);
		
		}

	/**
	*<li> Case ID:116597.</li>
	*<li> Test Case Name: Add Script.</li>
	*<li> Case ID:116619.</li>
	*<li> Test Case Name: Edit Script.</li>
	*<li> Case ID:116620.</li>
	*<li> Test Case Name: Delete Script.</li>
	*/
	@Test
	public  void test10_11_12_Add_Edit_Delete_Script() {
		info("Test 3: Add Script");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String Newtitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String script = txData.getContentByArrayTypeRandom(1)+"script"+getRandomNumber()+".groovy";
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add Script
		*Input Data: 
			- Go to Content Administration/Advanced/ Scripts
			- Click Add button and input information for new scrip
			- Click Save
		*Expected Outcome: 
			The script is Added successfully*/ 
		
		caPage.goToSpecificFunctions(specificEcmFunctions.SCRIPTS);
		caPage.addScripts(title, content, script);
		waitForAndGetElement(caPage.ELEMENT_ECM_ADVANCED_SCRIPT_LIST.replace("{$name}",title));
		caPage.EditScripts(title,Newtitle,null,null);
		caPage.deleteScripts(Newtitle);
 	}

	/**
	*<li> Case ID:116615.</li>
	*<li> Test Case Name: Add Categories.</li>
	*<li> Case ID:116616.</li>
	*<li> Test Case Name: Edit Categories.</li>
	*<li> Case ID:116583.</li>
	*<li> Test Case Name: Delete Categories.</li>
	*/
	@Test
	public  void test07_08_09_Add_Edit_Delete_Categories() {
		info("Test 4: Add Categories");
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String lifeCycle ="Content Addition";
		String nameAction = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String targetPath = "root";
		String workspace="knowledge";
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Add categories
		*Input Data: 
			- Go to Content Administration/ Advanced/ Categories
			- Click on [Add Category] button
			- Input required fields
			- Click [Save]
			- Add/copy/cut/paste/delete category in category tree
		*Expected Outcome: 
			The Category is created successfully*/ 
		
		caPage.goToSpecificFunctions(specificEcmFunctions.CATEGORIES);
		caPage.addCategories(name, nameAction, lifeCycle, targetPath);
		caPage.editCategories(name, null, null, null, workspace, targetPath);
		waitForAndGetElement(By.xpath(caPage.ELEMENT_ECM_ADVANCED_CATEGORIES_WORKSPACE_LIST.replace("{$name}",name).replace("{$workspace}",workspace)));
		caPage.deleteCategories(name);
	}

	

}