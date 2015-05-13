package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.ActivityStream;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceApplicationDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceGUIDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceNavigationDefaultNodesDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceGroupsDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceRegistrationDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceVisibilityDatabase;
import org.exoplatform.selenium.platform.social.SpaceHomePage;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.social.SpaceSettingManagement;
import org.exoplatform.selenium.platform.social.UserProfilePage;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.exoplatform.selenium.platform.wiki.WikiManagement;
import org.exoplatform.selenium.platform.calendar.EventManagement;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.forum.ForumTopicManagement;
import org.exoplatform.selenium.platform.gatein.ApplicationRegistry;
import org.exoplatform.selenium.platform.gatein.MyDashBoard;
import org.exoplatform.selenium.platform.gatein.PageCreationWizard;
import org.exoplatform.selenium.platform.gatein.PortalManagePages;
import org.exoplatform.selenium.platform.gatein.UserAddManagement;
import org.exoplatform.selenium.platform.gatein.UserAndGroupManagement;
import org.exoplatform.selenium.platform.objectdatabase.common.LanguageDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.LinksDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.ApplicationGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.ApplicationLayoutDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.ContainersDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.GateinPortalMemberShipsPermissionDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.RemoteGadgetDatabase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SOC_TestConfig extends PlatformBase {
	HomePagePlatform hp;
	ActivityStream hpAct;
	ManageLogInOut magAc;
	Button button;
	PortalManagePages portManagePage;
	PageCreationWizard pgCreateWiz;

	MyDashBoard myDash;
	NavigationToolbar navTool;

	SpaceManagement spaMg;
	SpaceHomePage spaHome;
	SpaceSettingManagement setSpaceMg;
	UserAddManagement userManage;
	UserAndGroupManagement userGroupMg;
	UserProfilePage userProPg;
	
	ForumTopicManagement topicMg;
	
	WikiHomePage wHome;
	WikiManagement wikiMg;
	
	SiteExplorerHome SEHome;
	CreateNewDocument creatDoc;
	
	EventManagement evMg;
	
	ApplicationRegistry appReg;
	ApplicationLayoutDatabase appLayData;
	ApplicationGateinDatabase appGateData;
	
	SpaceGUIDatabase spaceUI;
	SpaceApplicationDatabase spAppData;
	SpaceNavigationDefaultNodesDatabase spaceDefaultNodesData;
	SpaceVisibilityDatabase spVisiData;
	SpaceRegistrationDatabase spRegisData;
	SpaceGroupsDatabase spGroupsData;
	GateinPortalMemberShipsPermissionDatabase membershipData;
	
	RemoteGadgetDatabase remoteGadData;
	TextBoxDatabase txData;
	LinksDatabase lnkData;
	
	ContainersDatabase containerData;
	LanguageDatabase langData;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		button = new Button(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		navTool = new NavigationToolbar(driver);
		setSpaceMg = new SpaceSettingManagement(driver);
		hp = new HomePagePlatform(driver);
		hpAct = new ActivityStream(driver);
		myDash = new MyDashBoard(driver);

		spaMg = new SpaceManagement(driver);
		spaHome = new SpaceHomePage(driver);
		appReg = new ApplicationRegistry(driver);
		portManagePage = new PortalManagePages(driver);
		pgCreateWiz = new PageCreationWizard(driver);
		
		userManage = new UserAddManagement(driver);
		
		topicMg = new ForumTopicManagement(driver);
		
		wikiMg = new WikiManagement(driver);
		wHome = new WikiHomePage(driver);
		
		SEHome = new SiteExplorerHome(driver);
		creatDoc = new CreateNewDocument(driver);
		userGroupMg = new UserAndGroupManagement(driver);
		userProPg = new UserProfilePage(driver);
		
		evMg = new EventManagement(driver);
		
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);

		spAppData = new SpaceApplicationDatabase();
		spAppData.setAppData(spaceappFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);

		remoteGadData = new RemoteGadgetDatabase();
		remoteGadData.setRemoteGadgetData(remoteGadgetDataFilePath, defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		appLayData = new ApplicationLayoutDatabase();
		appLayData.setApplicationLayoutData(appLayoutFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		spaceUI = new SpaceGUIDatabase();
		spaceUI.setData(spaceUIFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		lnkData = new LinksDatabase();
		lnkData.setLinkData(linkPath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		containerData = new ContainersDatabase();
		containerData.setContainersData(containerFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		langData = new LanguageDatabase();
		langData.setLanguageData(languageFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		appGateData = new ApplicationGateinDatabase();
		appGateData.setApplicationGateinData(appGateinDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		spaceDefaultNodesData = new SpaceNavigationDefaultNodesDatabase();
		spaceDefaultNodesData.setSpaceNavigationDefaultNodes(spaceNavigationDefaultNodesFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);	
		
		spVisiData = new SpaceVisibilityDatabase();
		spVisiData.setSpaceVisibleData(spaceVisibleFilePath, defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		spRegisData = new SpaceRegistrationDatabase();
		spRegisData.setSpaceRegistrationData(spaceRegistrationFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		spGroupsData = new SpaceGroupsDatabase();
		spGroupsData.setData(spaceGroupsFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		membershipData = new GateinPortalMemberShipsPermissionDatabase();
		membershipData.setData(portalPermisMemFilePath, defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
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
