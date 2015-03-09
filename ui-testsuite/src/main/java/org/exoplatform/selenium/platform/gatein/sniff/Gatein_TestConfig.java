package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.gatein.UserAddManagement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Gatein_TestConfig extends PlatformBase {
	
	ManageLogInOut magAc;
	ManageLogInOut magAc2;
	NavigationToolbar navToolBar;
	UserAddManagement addUserPage;
	HomePagePlatform hp;
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception{
		info("Start setUpBeforeClass");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		addUserPage = new UserAddManagement(driver);
		hp = new HomePagePlatform(driver);
		navToolBar = new NavigationToolbar(driver);
	}
	
	@AfterClass
	public void afterTest(){
		info("Start setUpBeforeClass");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End setUpBeforeClass");
	}
	
}
