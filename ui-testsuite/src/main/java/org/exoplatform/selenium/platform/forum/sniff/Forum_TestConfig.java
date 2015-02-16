package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.HomepageActivity;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.answer.AnswerCategoryManagement;
import org.exoplatform.selenium.platform.ecms.EditPageWCM;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.forum.ForumCategoryManagement;
import org.exoplatform.selenium.platform.forum.ForumHomePage;
import org.exoplatform.selenium.platform.forum.ForumManagement;
import org.exoplatform.selenium.platform.forum.ForumTopicManagement;
import org.exoplatform.selenium.platform.forum.PrivateMessageManagement;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.social.MyProfilePage;
import org.testng.annotations.*;
/**
 * 
 * @author quynhpt
 * date: 03/02/2015
 */

public class Forum_TestConfig extends PlatformBase{

	HomePagePlatform hp;
	NavigationToolbar navTool;
	ForumCategoryManagement forumCatMag;
	ForumHomePage forumHP;
	ForumManagement forumMag;
	ManageLogInOut magAc;
	MyProfilePage myPro;

	AttachmentFileDatabase fData;
	TextBoxDatabase txData;
	
	SiteExplorerHome SEHome;
	ManageAlert magAlert;
	AnswerCategoryManagement cMang;
	Button button;
	ForumTopicManagement foTopic;
	HomepageActivity aHome;
	EditPageWCM editPage;
	PrivateMessageManagement msgManage;

	@BeforeClass
	public void setUpBeforeClass() throws Exception{
		info("Start setUpBeforeClass");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);

		hp = new HomePagePlatform(driver);
		navTool = new NavigationToolbar(driver);
		forumHP = new ForumHomePage(driver);
		magAc = new ManageLogInOut(driver);
		myPro = new MyProfilePage(driver);
		SEHome = new SiteExplorerHome(driver);
		magAlert = new ManageAlert(driver);
		cMang = new AnswerCategoryManagement(driver);
		button = new Button(driver);
		foTopic = new ForumTopicManagement(driver);
		aHome = new HomepageActivity(driver);
		editPage = new EditPageWCM(driver);
		msgManage = new PrivateMessageManagement(driver);
		forumCatMag = new ForumCategoryManagement(driver);
		forumMag = new ForumManagement(driver);

		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);

		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);

		magAc.signIn(DATA_USER1, DATA_PASS);
		info("End setUpBeforeClass");
	}

	@AfterClass
	public void afterClass(){
		info("Start AfterClass");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End AfterClass");
	}
	
}