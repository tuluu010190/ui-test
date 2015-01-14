package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome.selectDriverOption;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome.selectDriverOrder;
import org.openqa.selenium.By;
import org.testng.annotations.*;



	public class Ecms_SE_Setting extends PlatformBase{

		HomePagePlatform hp;
		ManageLogInOut magAc;
		SiteExplorerHome SEHome;
		NavigationToolbar navTool;

		@BeforeMethod
		public void setUpBeforeMethod() throws Exception{
			magAc.signIn(DATA_USER1, DATA_PASS);
		}

		@BeforeClass
		public void setUpBeforeTest() throws Exception{
			getDriverAutoSave();
			getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
			driver.get(baseUrl);
			magAc = new ManageLogInOut(driver);
			hp = new HomePagePlatform(driver);
			SEHome = new SiteExplorerHome(driver);
			navTool = new NavigationToolbar(driver);
		}

		@AfterMethod
		public void afterMethod(){
			magAc.signOut();
		}

		@AfterClass
		public void afterTest(){
			driver.manage().deleteAllCookies();
			driver.quit();
		}

	/**
	*<li> Case ID:116604.</li>
	*<li> Test Case Name: Set up browsing Preferences.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_SetUpBrowsingPreferences() {
		info("Test 1: Set up browsing Preferences");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Set up browsing Preferences
		*Input Data: 
			- Go to a driver
			- Click on [Set up your browsing preference] icon (wheel icon on the top right of action bar)
			- Perform to set up
			- Click Save
		*Expected Outcome: 
			New Displaying is shown directly*/ 
		navTool.goToSiteExplorer();
		SEHome.openSettingsDriver(selectDriverOption.MODIFIEDDATE, selectDriverOrder.DESCENDING);
		waitForAndGetElement(By.xpath("//*[@class='nodeLabel']//*[text()='acme']"));
		SEHome.openSettingsDriver(selectDriverOption.ALPHABETICAL, selectDriverOrder.ASCENDING);
 	}
}