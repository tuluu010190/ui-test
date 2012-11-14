package org.exoplatform.selenium.platform.social.functional.people;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.social.Activity.*;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;
import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.By;
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
public class SOC_PEO_Activity_AddActivity extends SocialBase{

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

	//Manage Activity ( add/delete activity)
	@Test
	public void test04_addNewYourActivity(){

		goToActivityStream();

		info("-- Adding an activity to space --");

		addActivity(true,"FNC_SOC_PEO_ACT_08_04", true, "http://www.google.com");

		info("-- Deleting an activity --");

		deleteActivity("FNC_SOC_PEO_ACT_08_04");

	}
	//Add new activity for users contact
	@Test
	public void test05_addNewActivityForUserContact(){

		info("-- Go to People Page --");
		goToFindConnections();

		info("-- Connect to James Davis --");

		connectPeople("James Davis");

		signOut();

		info("Accept the friend ");
		signIn("james", "gtn");

		acceptInvitation("John Smith");

		info("Add activity for james");

		goToActivityStream();

		addActivity(true,"activity for james", true, "http://www.google.com");

		info("Add activity for john");

		click(By.linkText("John Smith"));

		waitForTextPresent("John Smith");

		click(ELEMENT_ACTIVITY_STREAM_TAB);

		addActivity(true,"activity for john", true, "http://www.google.com");

		info("Delete activity for John");

		deleteActivity("activity for john");

		info("Delete activity for James");

		click(By.xpath("//a[text()='James Davis']"));

		click(ELEMENT_ACTIVITY_STREAM_TAB);

		deleteActivity("activity for james");

		removeConnection("John Smith");
	}

	@AfterMethod
	public void afterMethods(){
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}
}