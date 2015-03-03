package org.exoplatform.selenium.platform.social.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.HomepageActivity;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceApplicationDatabase;
import org.exoplatform.selenium.platform.social.SpaceHomePage;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.social.SpaceSettingManagement;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.exoplatform.selenium.platform.wiki.WikiManagement;
import org.testng.annotations.*;


public class SOC_TestConfig extends PlatformBase {

	ManageLogInOut magAc;
	HomePagePlatform hp;
	HomepageActivity hpAc;
	
	SpaceManagement spaMg;
	SpaceHomePage spaHome;
	SpaceSettingManagement setSpaceMg;
	
	WikiHomePage wHome;
	WikiManagement wikiMg;
	
	TextBoxDatabase txData;
	AttachmentFileDatabase fData;
	SpaceApplicationDatabase spAppData;
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception{
		info("Start setUpBeforeClass");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		spaMg = new SpaceManagement(driver);
		spaHome = new SpaceHomePage(driver);
		setSpaceMg = new SpaceSettingManagement(driver);
		hp = new HomePagePlatform(driver);
		hpAc = new HomepageActivity(driver);
		
		wHome = new WikiHomePage(driver);
		wikiMg = new WikiManagement(driver);
		
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		spAppData = new SpaceApplicationDatabase();
		spAppData.setAppData(spaceappFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
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