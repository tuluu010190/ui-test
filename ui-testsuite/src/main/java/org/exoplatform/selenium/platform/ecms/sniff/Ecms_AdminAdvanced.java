package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.mainEcmFunctions;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement.specificEcmFunctions;
import org.openqa.selenium.By;
import org.testng.annotations.*;


	/**
	* @author rosso
	*
	*/
	public class Ecms_AdminAdvanced extends ECMS_TestConfig{
		
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
		info("Test 01: Add Action Type");
		info("Get the data test");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String Newtitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		navTool.goToContentAdministration();
		this.driver.navigate().refresh();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.ADVANCED);
		caPage.goToSpecificFunctions(specificEcmFunctions.ACTIONS);
		caPage.addActionType(title,"","");
		info("Verify that the title is replaced");
		waitForAndGetElement(caPage.ELEMENT_ECM_ACTION_LIST.replace("{$name}",title));
		info("Test 02: Edit Action Type");
		caPage.editActionType(title,Newtitle,"","");
		info("Test 03: Delete Action Type");
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
		info("Test 04: Add Query");
		info("Get the data test");
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
		navTool.goToContentAdministration();
		this.driver.navigate().refresh();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.ADVANCED);
		caPage.goToSpecificFunctions(specificEcmFunctions.QUERIES);
		caPage.addQueries(title,"","",permission);
		info("Test 05: Edit Query");
		caPage.editQueries(title,type,"","");
		info("Verify that the query is edited with new title");
		waitForAndGetElement(By.xpath(caPage.ELEMENT_ECM_ADVANCED_QUERIES_TYPE_LIST.replace("{$name}", title).replace("{$type}","sql")));
		info("Test 06: Delete Query");
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
		info("Test 10: Add Script");
		info("Get the data test");
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
		navTool.goToContentAdministration();
		this.driver.navigate().refresh();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.ADVANCED);
		caPage.goToSpecificFunctions(specificEcmFunctions.SCRIPTS);
		caPage.addScripts(title, content, script);
		info("Verify that the script is added in the list");
		waitForAndGetElement(caPage.ELEMENT_ECM_ADVANCED_SCRIPT_LIST.replace("{$name}",title));
		info("Test 11: Edit Script");
		caPage.EditScripts(title,Newtitle,"","");
		info("Test 12: Delete Script");
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
		info("Test 07: Add Categories");
		info("Get the data test");
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
		navTool.goToContentAdministration();
		this.driver.navigate().refresh();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.ADVANCED);
		caPage.goToSpecificFunctions(specificEcmFunctions.CATEGORIES);
		caPage.addCategories(name, nameAction, lifeCycle, targetPath);
		info("Test 08: Edit Categories");
		caPage.editCategories(name,"","","", workspace, targetPath);
		info("Verify that the category is edited with new changes");
		waitForAndGetElement(By.xpath(caPage.ELEMENT_ECM_ADVANCED_CATEGORIES_WORKSPACE_LIST.replace("{$name}",name).replace("{$workspace}",workspace)));
		info("Test 09: Delete Categories");
		caPage.deleteCategories(name);
	}

	

}