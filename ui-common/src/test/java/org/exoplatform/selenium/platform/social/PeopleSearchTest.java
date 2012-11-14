package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.social.PeopleSearch.*;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*--@Author: VuNA  
 *--@date: 08/11/2012
 *--@Test for search people
 */
public class PeopleSearchTest extends SocialBase{

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

	/*-- @Test for search people
	 *-- Set up before testing:
	 *-- Add a new role for Mary: manager
	 *-- Add a skill for Jack Miller: fluent in three languages
	 *-- Add a role for Jack Miller: member
	 */
	@Test
	public void searchPeopleTest(){
		//go to username link > Find connections
		goToFindConnections();

		info("-- Search by name --");
		searchPeople(searchType.NAME, "james");
		waitForTextPresent("james");

		info("-- Search people by position --");
		type(ELEMENT_NAME_OF_PEOPLE, "", true);
		searchPeople(searchType.ROLE, "manager");
		waitForTextPresent("Mary Williams");

		info("-- Search people by skill--");
		type(ELEMENT_ROLE_OF_PEOPLE, "", true);
		searchPeople(searchType.SKILL, "fluent in three languages");
		waitForTextPresent("Jack Miller");

		info("-- Search people by directory --");
		type(ELEMENT_SKILL_OF_PEOPLE, "", true);
		searchPeople(searchType.DIRECTORY, "D");
		waitForTextPresent("James Davis");
	}

	@Test
	public void searchPeopleAdvanceTest(){
		//go to username link > Find connections
		goToFindConnections();
		searchPeopleAdvance(true, "Jack Miller", false, "member", true, "fluent in three languages");
		waitForTextPresent("Jack Miller");
	}

}
