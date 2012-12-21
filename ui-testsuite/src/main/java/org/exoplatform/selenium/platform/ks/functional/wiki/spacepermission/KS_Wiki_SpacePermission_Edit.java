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
public class KS_Wiki_SpacePermission_Edit extends KsBase {

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}

	//Edit permission for space
	@Test
	public void test01_EditPermissionForSpace() {

		String[] user2= {"james"};

		goToWiki();

		addSpacePermission(0, user2);

		editSpacePermission("james", true, true, true, false);

		deleteSpacePermission("james");
	}
	
	//Edit permission for space is blank
	@Test
	public void test02_EditPermissionForSpaceIsBlank() {

		String[] user2= {"demo"};

		goToWiki();

		addSpacePermission(0, user2);

		editSpacePermission("demo", false, false, false, false);
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}