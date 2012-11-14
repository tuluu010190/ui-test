package org.exoplatform.selenium.platform.social.functional.people;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.social.Activity.*;
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
public class SOC_PEO_Activity_DeleteActivity extends SocialBase{

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
	public void test01_deleteYourActivity(){
		
		addActivity(true,"FNC_SOC_PEO_ACT_12_001", true, "http://www.google.com");

		info("-- Deleting an activity --");

		deleteActivity("FNC_SOC_PEO_ACT_12_001");
	}
	@AfterMethod
	public void afterMethods() {
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}
}