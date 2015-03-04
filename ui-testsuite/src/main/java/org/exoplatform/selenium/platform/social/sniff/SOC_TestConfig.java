package org.exoplatform.selenium.platform.social.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.ConnectionsManagement;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ActivityStream;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.objectdatabase.chat.ChatStatusDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.MailSuffixDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.UserInfoDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.ConnectStatusDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.NotificationDescriptionDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.ProfileContactIMDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.ProfileContactPhoneDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.ActivityMessageDatabase;
import org.exoplatform.selenium.platform.objectdatabase.social.SpaceApplicationDatabase;
import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.exoplatform.selenium.platform.social.EmailNotificationsAdministration;
import org.exoplatform.selenium.platform.social.MyNotificationsPage;
import org.exoplatform.selenium.platform.social.SpaceHomePage;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.social.SpaceSettingManagement;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.exoplatform.selenium.platform.wiki.WikiManagement;
import org.exoplatform.selenium.platform.ecms.CreateNewDocument;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.gatein.PageEditor;
import org.exoplatform.selenium.platform.gatein.UserAddManagement;
import org.exoplatform.selenium.platform.gatein.UserAndGroupManagement;
import org.exoplatform.selenium.platform.objectdatabase.common.LinksDatabase;
import org.exoplatform.selenium.platform.objectdatabase.ecms.SiteExplorerDriveDatabase;
import org.exoplatform.selenium.platform.objectdatabase.ecms.SiteExplorerPathDatabase;
import org.exoplatform.selenium.platform.social.MyProfilePage;
import org.exoplatform.selenium.platform.wiki.RichTextEditor;
import org.exoplatform.selenium.platform.chat.ChatStatus;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SOC_TestConfig extends PlatformBase {
	HomePagePlatform hp;
	MailSuffixDatabase mailSuffixData;
	WikiHomePage wHome;
	WikiManagement wikiMg;

	SpaceApplicationDatabase spAppData;
	ActivityStream hpAct;
	ManageLogInOut magAc;
	MyProfilePage myProfile;

	NavigationToolbar navTool;
	SiteExplorerHome SEHome;
	RichTextEditor rtMode;

	SpaceManagement spaMg;
	SpaceHomePage spaHome;

	AttachmentFileDatabase atData;
	CreateNewDocument CreNewDoc;
	TextBoxDatabase txData;
	AttachmentFileDatabase fData;
	LinksDatabase lnkData;
	UserDatabase userData;
	ChatStatusDatabase chatStatus;
	UserInfoDatabase userInfoData;

	SiteExplorerDriveDatabase siteExDrive;
	SiteExplorerPathDatabase siteExPath;
	NotificationDescriptionDatabase notiDes;

	Button button;
	ConnectionsManagement connMag;
	SpaceSettingManagement setSpaceMg;
	UserAddManagement addUserPage;
	UserAndGroupManagement userAndGroup;
	
	ProfileContactIMDatabase contactIM;
	ProfileContactPhoneDatabase contactPhone;
	ActivityMessageDatabase activityMes;
	ConnectStatusDatabase conStatus;
	ChatStatus chat;
	EmailNotificationsAdministration emailNotif;
	MyNotificationsPage myNotifPage;
	MyProfilePage myProfil;
	
	PageEditor pagEditor;
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception{
		info("Start setUpBeforeClass");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		myProfile = new MyProfilePage(driver);
		navTool = new NavigationToolbar(driver);
		SEHome = new SiteExplorerHome(driver);
		CreNewDoc = new CreateNewDocument(driver);
		connMag = new ConnectionsManagement(driver);
		chat = new ChatStatus(driver);
		setSpaceMg = new SpaceSettingManagement(driver);
		emailNotif = new EmailNotificationsAdministration(driver);
		pagEditor = new PageEditor(driver);
		hp = new HomePagePlatform(driver);
		pagEditor = new PageEditor(driver);
		
		wHome = new WikiHomePage(driver);
		wikiMg = new WikiManagement(driver);
		
		atData = new AttachmentFileDatabase();
		atData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);

		spAppData = new SpaceApplicationDatabase();
		spAppData.setAppData(spaceappFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);

		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);

		hpAct = new ActivityStream(driver);

		rtMode = new RichTextEditor(driver);
		spaMg = new SpaceManagement(driver);
		spaHome = new SpaceHomePage(driver);

		lnkData = new LinksDatabase();
		lnkData.setLinkData(linkPath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);

		userData = new UserDatabase();
		userData.setUserData(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);

		siteExDrive = new SiteExplorerDriveDatabase();
		siteExPath = new SiteExplorerPathDatabase();

		siteExDrive.setSiteExpDriveData(siteExpDrivePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		siteExPath.setSiteExpPathData(siteExpPathPath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);

		addUserPage = new UserAddManagement(driver);
		userAndGroup = new UserAndGroupManagement(driver);
		myProfil = new MyProfilePage(driver);
		myNotifPage= new MyNotificationsPage(driver);

		mailSuffixData = new MailSuffixDatabase();
		mailSuffixData.setMailSuffixData(mailSuffixFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		contactIM = new ProfileContactIMDatabase();
		contactPhone = new ProfileContactPhoneDatabase();
		contactIM.setProfileIMData(contactIMFilePath, defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		contactPhone.setContactPhoneData(contactPhoneFilePath, defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		activityMes = new ActivityMessageDatabase();
		activityMes.setActivityMessageData(activityMesFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		conStatus = new ConnectStatusDatabase();
		conStatus.setConStatusData(conStatusFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		chatStatus = new ChatStatusDatabase();
		chatStatus.setChatStatusData(chatStatusFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		button = new Button(driver);

		notiDes = new NotificationDescriptionDatabase();
		notiDes.setData(notiDesFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		userInfoData = new UserInfoDatabase();
		userInfoData.setUserInfoData(userInfoFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
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
