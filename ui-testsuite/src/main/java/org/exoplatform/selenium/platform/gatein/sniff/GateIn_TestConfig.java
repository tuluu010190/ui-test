package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.EditPageWCM;
import org.exoplatform.selenium.platform.gatein.ApplicationRegistry;
import org.exoplatform.selenium.platform.gatein.GadgetManagement;
import org.exoplatform.selenium.platform.gatein.MyDashBoard;
import org.exoplatform.selenium.platform.gatein.PageCreationWizard;
import org.exoplatform.selenium.platform.gatein.UserAddManagement;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.AppAddGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.AppListGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.ApplicationLayoutDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.CategoriesGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.ContainersDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.CreateNewGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.GadgetsGateinDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.RemoteGadgetDatabase;
import org.exoplatform.selenium.platform.social.SpaceHomePage;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.social.SpaceSettingManagement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GateIn_TestConfig extends PlatformBase {
	ManageLogInOut magAc;
	HomePagePlatform hp;
	NavigationToolbar navToolBar;
	SpaceManagement spaMg;
	SpaceHomePage spaHome;
	SpaceSettingManagement setSpaceMg;
	
	UserAddManagement addUserPage;
	
	PageCreationWizard pagCW;
	
	EditPageWCM editPage;
	MyDashBoard myDash;
	
	TextBoxDatabase txData;
	GadgetsGateinDatabase gadData;
	ContainersDatabase contaiData;
	ApplicationLayoutDatabase appLayData;
	RemoteGadgetDatabase remoteGadData;
	
	
	EditPageWCM editPageWCM;
	
	GadgetManagement gadMg;
	
	ApplicationRegistry appRegistry;
	AppListGateinDatabase appGateInData;
	AppAddGateinDatabase appAddGateinData;
	CreateNewGateinDatabase creatGateinData;
	CategoriesGateinDatabase cateGateinData;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception{
		info("Start setUpBeforeClass");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		magAc = new ManageLogInOut(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		editPageWCM = new EditPageWCM(driver);
		spaMg = new SpaceManagement(driver);
		spaHome = new SpaceHomePage(driver);
		setSpaceMg = new SpaceSettingManagement(driver);
		hp = new HomePagePlatform(driver);
		navToolBar = new NavigationToolbar(driver);
		editPage = new EditPageWCM(driver);
		myDash = new MyDashBoard(driver);
		
		addUserPage = new UserAddManagement(driver);
		
		pagCW = new PageCreationWizard(driver);
		
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		gadData = new GadgetsGateinDatabase();
		gadData.setGadgetsGateinData(gadgetFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		contaiData = new ContainersDatabase();
		contaiData.setContainersData(containerFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		appLayData = new ApplicationLayoutDatabase();
		appLayData.setApplicationLayoutData(appLayoutFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		remoteGadData = new RemoteGadgetDatabase();
		remoteGadData.setRemoteGadgetData(remoteGadgetDataFilePath, defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		gadMg = new GadgetManagement(driver);
		
		appRegistry = new ApplicationRegistry(driver);
		appGateInData = new AppListGateinDatabase();
		appGateInData.setApplicationGateinData(appListGateinFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
	
		appAddGateinData = new AppAddGateinDatabase();
		appAddGateinData.setAppAddGateinData(appAddGateinFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		creatGateinData = new CreateNewGateinDatabase();
		creatGateinData.setGateinData(createNewGateinFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		cateGateinData = new CategoriesGateinDatabase();
		cateGateinData.setGateinData(categoriesGateinFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
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
