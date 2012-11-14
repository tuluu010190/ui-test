package org.exoplatform.selenium.platform.social.functional.people;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;

import org.exoplatform.selenium.platform.social.Activity;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author vuna2
 * Date: 14/11/2012
 * Test cases: Social/people/add link
 */
public class SOC_PEO_Activity_AddLink extends Activity{
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

	/**
	 * Case ID 001
	 * Add a share link
	 */
	@Test
	public void test01_AddShareLink(){
		info("-- Step 1: Go to my profile page --");	

		goToActivityStream();

		info("-- Step 2 & 3: Add share links on activity list --");

		addActivity(true, "Add a share link", true, "https://www.google.com");

		connectPeople("Mary Williams");

		signOut();

		signIn("mary", "gtn");

		acceptInvitation("John Smith");

		goToActivityStream();

		waitForTextPresent("John Smith");

		waitForTextPresent("Source : https://www.google.com");

		info("-- Restore original data --");

		signOut();

		signIn("john", "gtn");

		removeConnection("Mary Williams");

		goToActivityStream();

		deleteActivity("Add a share link");

		info("-- Finished test case --");
	}

	/**
	 * Case ID 017
	 * Edit description of share link with unlimited chars
	 */
	@Test
	public void test17_EditDescriptionOfShareLinkWithUnlimitedChars(){
		info("-- Step 1: Go to my profile page --");

		goToActivityStream();

		info("-- Step 2: Share a link and change the description of shared link--");

		editSharedLink("Add a share link test17", "https://www.google.com", true, "Google Test", true, "Google Test Description");

		info("-- Restore original data --");

		deleteActivity("Add a share link test17");

		info("-- Finished test case --");
	}

	/**
	 * Case ID 018
	 * Close share link
	 */
	@Test
	public void test18_CloseShareLink(){
		info("-- Step 1: Go to my profile page --");

		goToActivityStream();

		info("-- Step 2: Share a link --");

		click(ELEMENT_LINK);

		info("-- Input a link into link box --");

		type(ELEMENT_INPUT_LINK_BOX, "https://www.google.com", true);

		info("-- Click attach button --");

		click(ELEMENT_ATTACH_BUTTON);

		waitForTextPresent("https://www.google.com");

		info("Click on button 'Link' again");

		click(ELEMENT_LINK);

		//Close share link form, and the link is not shared
		waitForTextNotPresent("https://www.google.com");

		info("-- Finished test case --");
	}

}
