package org.exoplatform.selenium.platform.plf.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.Branding;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.IDEManagement;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.UserProfile;
import org.exoplatform.selenium.platform.administration.ManageSites;
import org.exoplatform.selenium.platform.administration.PageManagement;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.forum.ForumCategoryManagement;
import org.exoplatform.selenium.platform.forum.ForumHomePage;
import org.exoplatform.selenium.platform.forum.ForumManagement;
import org.exoplatform.selenium.platform.forum.ForumTopicManagement;
import org.exoplatform.selenium.platform.gatein.ApplicationHomePage;
import org.exoplatform.selenium.platform.gatein.GadgetManagement;
import org.exoplatform.selenium.platform.gatein.PageCreationWizard;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.ApplicationGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.RemoteGadgetDatabase;
import org.exoplatform.selenium.platform.objectdatabase.plf.GettingStartedDatabase;
import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.exoplatform.selenium.platform.social.HomepageActivity;
import org.exoplatform.selenium.platform.social.MyProfilePage;
import org.exoplatform.selenium.platform.social.SocialHomePage;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.exoplatform.selenium.platform.wiki.WikiManagement;
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
	SpaceManagement spaceMg;
	HomepageActivity hpAct;
	MyProfilePage profilPage;
	SiteExplorerHome SEHome;
	
	TextBoxDatabase txData;
	UserDatabase userData;
	RemoteGadgetDatabase remoteGadData;
	ApplicationGateinDatabase appGateData;
	GettingStartedDatabase getStartData;
	AttachmentFileDatabase fData;

	ForumHomePage forumHP;
	SocialHomePage sHome;
	
	ForumTopicManagement foTopic;
	ForumManagement forumMg;
	ForumCategoryManagement forumCatMag;
	CalendarHomePage calHome;
	WikiHomePage wikiHome;
	WikiManagement wikiMag;
	UserProfile userProfile;
	
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
		spaceMg = new SpaceManagement(driver);
		hpAct = new HomepageActivity(driver);
		profilPage = new MyProfilePage(driver);
		SEHome = new SiteExplorerHome(driver);
		forumHP = new ForumHomePage(driver);
		sHome = new SocialHomePage(driver);
		forumMg = new ForumManagement(driver);
		forumCatMag = new ForumCategoryManagement(driver);
		calHome=new CalendarHomePage(driver);
		foTopic=new ForumTopicManagement(driver);
		wikiHome=new WikiHomePage(driver);
		userProfile=new UserProfile(driver);
		wikiMag = new WikiManagement(driver);
		
		txData = new TextBoxDatabase();
		userData = new UserDatabase();
		fData = new AttachmentFileDatabase();
		remoteGadData = new RemoteGadgetDatabase();
		appGateData = new ApplicationGateinDatabase();
		userData.setUserData(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlContent);
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		remoteGadData.setRemoteGadgetData(remoteGadgetDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		appGateData.setApplicationGateinData(appGateinDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		getStartData = new GettingStartedDatabase();
		getStartData.setGettingStartedData(getStartFilePath, defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
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