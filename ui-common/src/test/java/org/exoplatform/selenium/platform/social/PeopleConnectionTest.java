package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author vuna2
 * Date: 13/11/2012
 * @Test for People Connections
 */
public class PeopleConnectionTest extends SocialBase{
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
	 *	Connect to people
	 *  Accept the invitation
	 *  Ignore the invitation
	 */
	@Test
	public void test01_connectPeopleTest(){
		info("-- Connect to James Davis --");

		connectPeople("James Davis");

		signOut();

		signIn("james", "gtn");

		acceptInvitation("John Smith");

		signOut();

		signIn("john", "gtn");
		
		removeConnection("James Davis");
		
		connectPeople("Jack Miller");
		
		signOut();

		signIn("demo", "gtn");
		
		ignoreInvitation("John Smith");
	}
}
