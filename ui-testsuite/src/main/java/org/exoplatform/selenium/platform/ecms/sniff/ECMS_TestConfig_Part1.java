package org.exoplatform.selenium.platform.ecms.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.acme.AcmeHomePage;
import org.exoplatform.selenium.platform.administration.ChangeLanguages;
import org.exoplatform.selenium.platform.administration.ContentAdministrationManagement;
import org.exoplatform.selenium.platform.administration.ManageSites;
import org.exoplatform.selenium.platform.administration.PageManagement;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.SEOManagement;
import org.exoplatform.selenium.platform.objectdatabase.common.ChangeLanguageDatabase;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.gatein.ContentDetail;
import org.exoplatform.selenium.platform.gatein.ContentList;
import org.exoplatform.selenium.platform.gatein.PageCreationWizard;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.testng.annotations.*;


public class ECMS_TestConfig_Part1 extends PlatformBase{

	HomePagePlatform hp;
	ManageLogInOut magAc;
	NavigationToolbar navTool;

	ContentAdministrationManagement caPage;
	SiteExplorerHome SEHome;
	CreateNewDocument CreNewDoc;
	
	
	AcmeHomePage acmeHP;
	PageManagement paMang;
	ChangeLanguages changLang;
	ManageSites maSite;
	PageCreationWizard pagCW;
	ContentList contList;
	ContentDetail contDetail;
	SEOManagement seoMang;
	
	TextBoxDatabase txData;
	UserDatabase userData;
	ChangeLanguageDatabase changLangData;
		
	@BeforeClass
	public void setUpBeforeClass() throws Exception{
		info("Start setUpBeforeClass");
		getDriverAutoSave();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		hp = new HomePagePlatform(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		SEHome = new SiteExplorerHome(driver);
		CreNewDoc = new CreateNewDocument(driver);
		caPage = new ContentAdministrationManagement(driver);
		navTool = new NavigationToolbar(driver);
		paMang = new PageManagement(driver);
		pagCW = new PageCreationWizard(driver);
		contList = new ContentList(driver);
		contDetail = new ContentDetail(driver);
		seoMang = new SEOManagement(driver);
		changLang = new ChangeLanguages(driver);
		maSite = new ManageSites(driver);
		acmeHP = new AcmeHomePage(driver);
		
		txData = new TextBoxDatabase();
		userData = new UserDatabase();
		changLangData = new ChangeLanguageDatabase();
		changLangData.setChangeLanguageData(changLangDataPath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		userData.setUserData(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		
		info("End setUpBeforeClass");
	}

	@AfterClass
	public void afterClass(){
		info("Start afterClass");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End afterClass");
	}
	
}