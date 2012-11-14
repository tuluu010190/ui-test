package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.Activity.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author vuna2
 * Date: 13/11/2012
 * @Test for Activity (Space and People)	
 */
public class ActivityTest extends SocialBase{
	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods() throws Exception {
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods() throws Exception {
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}

	/**
	 * Set up before testing
	 * Create a new space
	 */
	@Test
	public void test01_addNewSpaceTest(){
		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace("test", "description of space");
	}

	/**
	 * Add/Delete an activity to space
	 */
	@Test
	public void test02_activityTest(){
		info("-- Adding an activity to space --");

		accessSpace("test");

		addActivity(true,"test activity demo", true, "http://www.google.com");

		info("-- Deleting an activity --");

		deleteActivity("test activity demo");
	}

	/**
	 * Add an activity to space
	 * By Selecting a file
	 */
	/*@Test
	public void test03_activityTest(){
		info("-- Adding an activity to space --");

		accessSpace("test");

		selectFile("Personal Drives", true, "Public", "", "TestData/ECMS_DMS_SE_Article.jpg", "ECMS_DMS_SE_Article.jpg");

		pause(1000);
	}*/
	
	/**
	 * Add and delete a comment
	 */
	@Test
	public void test04_addCommentTest(){
		info("-- Adding a new comment --");

		accessSpace("test");

		addActivity(true,"test activity demo", true, "http://www.google.com");

		addComment("test activity demo", "exoplatform");

		deleteComment("exoplatform");
		
		deleteActivity("test activity demo");
	}
	
	/**
	 * Action: like/unlike an activity
	 */
	@Test
	public void test05_likeAndUnlikeActivityTest(){
		
		accessSpace("test");
		
		addActivity(true,"test activity demo", true, "http://www.google.com");
		
		info("-- Action: like an activity --");
		likeOrUnlikeActivity("test activity demo");
		waitForTextPresent("You like this.");
		
		
		info("-- Action: Unlike an activity --");
		likeOrUnlikeActivity("test activity demo");
		waitForTextNotPresent("You like this.");
		
		deleteActivity("test activity demo");
		
		goToMySpacePage();
		
		deleteSpace("test");
	} 
}
