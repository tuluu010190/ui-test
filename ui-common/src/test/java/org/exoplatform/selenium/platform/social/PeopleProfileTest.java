package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import static org.exoplatform.selenium.platform.social.PeopleProfile.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*--@Author: VuNA  
 *--@Date: 08/11/2012
 *--@Test for People Profile
 */
public class PeopleProfileTest extends SocialBase{

	//public String DATA_USER = "john";
	//public String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods() throws Exception {
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		//signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods() throws Exception {
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}

	/*-- @Test for editing People Profile
	 *-- Set up before testing:
	 *-- Add a new user for testing
	 */
	@Test
	public void addNewUserTest(){
		info("-- Creating a new user account --");
		String username      = "demotest" ; 
		String password		 = "exoplatform"; 
		String confirmPassword = "exoplatform"; 
		String firstName     = "first"; 
		String lastName      = "last name"; 
		String email         = "platform@exo.com"; 
		String userNameGiven = ""; 
		String language      = "English"; 
		boolean verify       = true;

		signIn("john", "gtn");

		goToNewStaff();

		addNewUserAccount(username, password, confirmPassword, firstName, lastName, email, userNameGiven, language, verify);		
	}

	/*-- @Test for editing People Profile
	 *-- Edit the user's basic information
	 *--
	 * */
	@Test
	public void editUserBasicInformationTest(){
		signIn("demotest", "exoplatform");

		goToMyProfile();

		editUserBasicInformation("firstName", "lastName", "exoplatform@platform.com");

		waitForTextPresent("firstName");		
	}

	/*-- @Test for editing People Profile
	 *-- Edit the user's contact
	 *--
	 * */
	@Test
	public void editUserContactTest(){
		signIn("demotest", "exoplatform");

		goToMyProfile();

		editUserContact("male", true, "Home", "0123456789", true, "Skype", "exo.platform", true, "http://www.google.com");

		waitForTextPresent("http://www.google.com");
	}

	/*-- @Test for editing People Profile
	 *-- Edit the user's experience
	 *--
	 * */
	@Test
	public void editUserExperienceTest(){
		signIn("demotest", "exoplatform");

		goToMyProfile();

		editUserExperience("eXo Platform", "Engineer", "Fluent in French");

		waitForTextPresent("Fluent in French");	
	}
}
