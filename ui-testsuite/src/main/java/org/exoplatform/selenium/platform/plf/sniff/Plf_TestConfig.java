package org.exoplatform.selenium.platform.plf.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.Branding;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.IDEManagement;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ManageSites;
import org.exoplatform.selenium.platform.administration.PageManagement;
import org.exoplatform.selenium.platform.gatein.ApplicationHomePage;
import org.exoplatform.selenium.platform.gatein.GadgetManagement;
import org.exoplatform.selenium.platform.gatein.PageCreationWizard;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.ApplicationGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.RemoteGadgetDatabase;
import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.testng.annotations.*;


public class Plf_TestConfig extends PlatformBase {

	HomePagePlatform hp;
	ManageLogInOut magAc;
	NavigationToolbar navToolBar;
	Branding branding;
	IDEManagement ide;
	ApplicationHomePage appHP;
	GadgetManagement gadMag;
	PageCreationWizard pagCW;
	ManageSites magSite;
	PageManagement pagMang;
	
	TextBoxDatabase txData;
	UserDatabase userData;
	RemoteGadgetDatabase remoteGadData;
	ApplicationGateinDatabase appGateData;

	@BeforeClass
	public void setUpBeforeClass() throws Exception{
		info("Start setUpBeforeClass");
		getDriverAutoSave();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		hp = new HomePagePlatform(driver);
		navToolBar = new NavigationToolbar(driver);
		ide = new IDEManagement(driver);
		branding = new Branding(driver);
		appHP = new ApplicationHomePage(driver);
		gadMag = new GadgetManagement(driver);
		pagCW =new PageCreationWizard(driver);
		magSite = new ManageSites(driver);
		pagMang = new PageManagement(driver);
		
		txData = new TextBoxDatabase();
		userData = new UserDatabase();
		remoteGadData = new RemoteGadgetDatabase();
		appGateData = new ApplicationGateinDatabase();
		userData.setUserData(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		remoteGadData.setRemoteGadgetData(remoteGadgetDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		appGateData.setApplicationGateinData(appGateinDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		info("End setUpBeforeClass");
	}
	
	@AfterClass
	public void afterTest(){
		info("Start setUpBeforeClass");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End setUpBeforeClass");
	}

	
}