package org.exoplatform.selenium.platform.social.functional.space;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import org.exoplatform.selenium.platform.social.SocialBase;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.SpaceNavigation.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thaopth
 * Date: 05/12/2012
 */
public class SOC_SPA_NavigationManagement_Node_Create extends SocialBase {
	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";
	public int timeToDeleteSpace = 120000;

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods(){
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}
	/*
	 * SOC/Space/Navigation Management/Node/Create
	 * Case 01: Create node for space at first level
	 */
	@Test
	public void test01_CreateNewNodeAtFirstLevel () {
		
		String DATA_SPACE_NAME = "SpaceNodeCase01";
		String DATA_NODE_NAME = "FirstLevelNode";

		info("--- Go to space page ---");	

		goToMySpacePage();

		info("---Create new space---");

		addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);
		
		goToSettings();
		
		goToNavigation();
		
		info("---Add node at first level---");
		
		click(UP_LEVEL);
		
		addNodeDoNotSelectPage(DATA_NODE_NAME, DATA_NODE_NAME, DATA_NODE_NAME);
		
		info("---Verify new node is added at first level---");
		
		click(UP_LEVEL);
		
		waitForElementPresent(By.linkText(DATA_NODE_NAME));
	
		//Clear data
		
		restoreData(DATA_SPACE_NAME,timeToDeleteSpace);
			
	}
	/*
	 * SOC/Space/Navigation Management/Node/Create
	 * Case 02: Create new node as child of an existing node
	 */
	@Test
	public void test02_CreateNodeAsChildOfExistingNode () {
		String DATA_SPACE_NAME = "SpaceNodeCase02";
		String DATA_PARENT_NODE = "Wiki";
		String DATA_NODE_NAME = "ChildNode";

		info("--- Go to space page ---");	

		goToMySpacePage();

		info("---Create new space---");

		addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);
		
		goToSettings();
		
		goToNavigation();
		
		info("---Open parent node---");
		
		click(NODE_PATH.replace("${nodeLabel}",DATA_PARENT_NODE));
		
		addNodeDoNotSelectPage(DATA_NODE_NAME, DATA_NODE_NAME, DATA_NODE_NAME);
		
		info("---Verify new node---");
		
		click(NODE_PATH.replace("${nodeLabel}",DATA_PARENT_NODE));
		
		waitForElementPresent(By.linkText(DATA_NODE_NAME));
		
		//Clear data
		
		restoreData(DATA_SPACE_NAME,timeToDeleteSpace);
	}

}
