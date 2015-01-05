package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.mainEcmFunctions;
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
			magAc.signIn(DATA_USER1, DATA_PASS);
			hp = new HomePagePlatform(driver);
			txData = new TextBoxDatabase();
			caPage= new ContentAdministrationManagement(driver);
			txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		}	
		
		@AfterClass
		public void afterTest(){
			magAc.signOut();
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
	public void test01_AddActionType() {
		info("Test 1: Add Action Type");
		String title = txData.getContentByArrayTypeRandom(1)+"116581";
		String Newtitle = txData.getContentByArrayTypeRandom(1)+"new116581";
		
		hp.goToPageAdministration();
		caPage.goToSpecificFunctions(mainEcmFunctions.ACTIONS);
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
	public  void test02_AddQuery() {
		info("Test 2: Add Query");
		String title = txData.getContentByArrayTypeRandom(1)+"116581";
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
		hp.goToPageAdministration();
		caPage.goToSpecificFunctions(mainEcmFunctions.QUERIES);
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
	public  void test03_AddScript() {
		info("Test 3: Add Script");
		String title = txData.getContentByArrayTypeRandom(1)+"116581";
		String Newtitle = txData.getContentByArrayTypeRandom(1)+"new116581";
		String content = txData.getContentByArrayTypeRandom(1)+"content116581";
		String script = txData.getContentByArrayTypeRandom(1)+"script116581.groovy";
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
		
		hp.goToPageAdministration();
		caPage.goToSpecificFunctions(mainEcmFunctions.SCRIPTS);
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
	public  void test04_AddCategories() {
		info("Test 4: Add Categories");
		String name = txData.getContentByArrayTypeRandom(1)+"116615";
		String lifeCycle ="Content Addition";
		String nameAction = txData.getContentByArrayTypeRandom(1)+"116615";
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
		hp.goToPageAdministration();
		caPage.goToSpecificFunctions(mainEcmFunctions.CATEGORIES);
		caPage.addCategories(name, nameAction, lifeCycle, targetPath);
		caPage.editCategories(name, null, null, null, workspace, targetPath);
		waitForAndGetElement(By.xpath(caPage.ELEMENT_ECM_ADVANCED_CATEGORIES_WORKSPACE_LIST.replace("{$name}",name).replace("{$workspace}",workspace)));
		caPage.deleteCategories(name);
	}

	

}