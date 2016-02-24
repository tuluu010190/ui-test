package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ManageLayout;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.exoplatform.selenium.platform.wiki.WikiManagement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WIKI_TestConfig_3 extends PlatformBase {
	
	ManageLogInOut magAc;
	
	NavigationToolbar navTool;
	HomePagePlatform hp;
	ManageLayout mLayout;
	
	WikiHomePage wHome;
	WikiManagement wikiMg;
	TextBoxDatabase txData;
	
	
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		navTool = new NavigationToolbar(driver);
		mLayout = new ManageLayout(driver);
		 
		hp = new HomePagePlatform(driver);
		wHome=new WikiHomePage(driver);
		wikiMg = new WikiManagement(driver);

		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		info("End setUpBeforeMethod");
	}

	@AfterMethod
	public void afterMethod(){
		info("Start afterMethod");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End afterMethod");
	}
	
}