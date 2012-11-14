package org.exoplatform.selenium.platform.social.functional.people;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;

import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author vuna2
 * Date: 15/11/2012
 * Test cases: Social/people/display
 */
public class SOC_PEO_Display extends SocialBase{
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
	 * Access people page
	 */
	@Test
	public void test01_AccessPeoplePage(){
		info("-- Step 1: Sign in Social system --");

		//sign in as John

		info("-- Step 2: Go to People --");

		//goToFindConnections();

		info("-- Connect to James Davis --");
		//click on CONNECT button to send friend request.
		connectPeople("James Davis");

		info("-- Login as James --");

		signOut();

		signIn("james", "gtn");

		acceptInvitation("John Smith");

		info("-- Re-login as John --");

		signOut();

		signIn("john", "gtn");

		info("-- Verify that there is a 'REMOVE CONNECTION' button under James's profile --");

		removeConnection("James Davis");

		info("-- Finished test case --");
	}
}
