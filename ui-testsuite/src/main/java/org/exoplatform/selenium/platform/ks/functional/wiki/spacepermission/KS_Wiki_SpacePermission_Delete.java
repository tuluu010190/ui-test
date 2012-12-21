package org.exoplatform.selenium.platform.ks.functional.wiki.spacepermission;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.exoplatform.selenium.platform.ks.KsBase;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.Wiki.*;

/**
 *
 * @author HangNTT
 * @date: 18/12/2012
 */
public class KS_Wiki_SpacePermission_Delete extends KsBase {

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}

	//Delete permission for space
	@Test
	public void test01_DeletePermissionForSpace() {

		String[] user2= {"james"};

		goToWiki();

		addSpacePermission(0, user2);

		deleteSpacePermission("james");
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}