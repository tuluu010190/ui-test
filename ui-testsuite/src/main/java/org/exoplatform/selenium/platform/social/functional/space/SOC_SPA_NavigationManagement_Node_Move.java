package org.exoplatform.selenium.platform.social.functional.space;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.SpaceNavigation.*;
import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thaopth
 * Date: 03/12/2012
 */

public class SOC_SPA_NavigationManagement_Node_Move extends SocialBase {
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
	 * Case 01: Change node order
	 * Move up first node
	 * Move down last node
	 * Move up valid node
	 * Move down valid node
	 */
	
	@Test
	public void test01_ChangeNodeOrder () {
		String DATA_FIRST_NODE_NAME = "Discussions";
		String DATA_LAST_NODE_NAME = "Space Settings";
		String DATA_NODE_NAME1 = "Wiki";
		String DATA_NODE_NAME2 = "Members";
		String DATA_SPACE_NAME = "ChangeNodeOrder";
				
		info("---Go to my space page---");
		
		goToMySpacePage();
		
		info("---Add new space---");
		
		addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);
		
		info("---Go to space settings---");
		
		goToSettings();
		
		info("---Go to space navigation---");
		
		goToNavigation();
		
		info("--- Do action move up fist node---");
		
		moveUpNode(DATA_FIRST_NODE_NAME);
		
		info("---Verify position of node is not changed---");
		
		captureScreen("FirstNodeCannotMoveUp");
		
		info("---Do action move down last node---");
		
		moveDownNode(DATA_LAST_NODE_NAME);
		
		info("---Verify position of node is node changed---");
		
		captureScreen("LastNodeCannotMoveDown");
		
		info("---Move up a valid node---");
		
		moveUpNode(DATA_NODE_NAME1);
		
		info("---Verify new position of node---");
		
		captureScreen("NodeIsMovedUp");
		
		info("---Move down a valid node---");
		
		moveDownNode(DATA_NODE_NAME2);
		
		info("---Verify new position of node---");
		
		captureScreen("NodeIsMovedDown");
		
		//Reset data
		
		restoreData(DATA_SPACE_NAME, timeToDeleteSpace);
	}
}
