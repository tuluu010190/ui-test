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

public class SOC_SPA_NavigationManagement_Node_Delete extends SocialBase {
		public String DATA_USER = "john";
		public String DATA_PASS = "gtn";

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
		 * Case 01: delete node of a space
		 */
		@Test
		public void test01_DeleteNodeWithDeletingConfirmation () {
			
			String DATA_SPACE_NAME = "TestDeleteNode";
			String DATA_NODE_NAME = "node01";
			
			info("---Go to my space page---");
			
			goToMySpacePage();
			
			info("---Add new space---");
			
			addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);
			
			info("---Go to space settings---");
			
			goToSettings();
			
			info("---Go to space navigation---");
			
			goToNavigation();
								
			info("---Add new node---");
			
			addNodeDoNotSelectPage(DATA_NODE_NAME, DATA_NODE_NAME, DATA_NODE_NAME);
						
			info("---Delete node---");
			
			deleteNode(DATA_SPACE_NAME, DATA_NODE_NAME, true);
			
			//Reset data
			restoreData(DATA_SPACE_NAME, 120000);
		}
}
