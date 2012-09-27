package org.exoplatform.selenium.platform.exogtn.functional.group.administration.applicationregistry;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ManageApplications.*;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *@author NhungVT
 *@date: 25/09/2012
 */

public class EXOGTN_Administration_ApplicationRegistry_Display extends PlatformBase
{
	
	@BeforeMethod()
	public void beforeTest() throws Exception
	{
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}
	
	//Show Application portlet when check or un-check Change show import
	@Test()
	public void test01_ShowImportApplication()
	{
		showImportApplication(true);
		//Reset data
		showImportApplication(false);
	}
	@AfterMethod()
	public void afterTest() throws Exception
	{
		driver.quit();
	}
}
