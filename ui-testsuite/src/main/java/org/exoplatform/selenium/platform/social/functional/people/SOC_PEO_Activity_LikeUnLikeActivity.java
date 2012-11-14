package org.exoplatform.selenium.platform.social.functional.people;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.social.Activity.*;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;
import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author: hangNTT
 * Date: 15/11/2012
 * @Manage Activity For People
 */
public class SOC_PEO_Activity_LikeUnLikeActivity extends SocialBase{

	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods() {
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(DATA_USER, DATA_PASS);
	}

	@Test
	public void test01_likeAndUnlikeYourActivity(){

		goToActivityStream();

		addActivity(true,"test activity demo", true, "http://www.google.com");

		info("-- Action: like an activity --");
		likeOrUnlikeActivity("test activity demo");
		waitForTextPresent("You like this.");

		info("-- Action: Unlike an activity --");
		likeOrUnlikeActivity("test activity demo");
		waitForTextNotPresent("You like this.");

		deleteActivity("test activity demo");

	}
	@Test
	public void test02_likeAndUnlikeFriendsActivity(){

		goToActivityStream();

		addActivity(true,"test activity john", true, "http://www.google.com");		

		info("-- Action: like an activity --");

		likeOrUnlikeActivity("test activity john");
		waitForTextPresent("You like this.");

		connectPeople("Jack Miller");

		signOut();

		info("Accept the friend ");

		signIn("demo", "gtn");

		acceptInvitation("John Smith");

		goToActivityStream();

		//Jack like activity of John 
		info("-- Action: like an activity --");
		likeOrUnlikeActivity("test activity john");
		// Verify all people like activity
		waitForTextPresent("You and 1 person like this.");

		info("-- Action: Unlike an activity --");
		likeOrUnlikeActivity("test activity john");
		waitForTextNotPresent("1 person likes this. ");

		signOut();

		signIn("john", "gtn");

		deleteActivity("test activity john");
		
		removeConnection("Jack Miller");
	}
	
	@AfterMethod
	public void afterMethods() {
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}
}