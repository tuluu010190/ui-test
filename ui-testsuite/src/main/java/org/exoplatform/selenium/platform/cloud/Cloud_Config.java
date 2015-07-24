package org.exoplatform.selenium.platform.cloud;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.administration.ContentAdministration;
import org.exoplatform.selenium.platform.gatein.UserAddManagement;
import org.exoplatform.selenium.platform.gatein.UserAndGroupManagement;
import org.exoplatform.selenium.platform.objectdatabase.common.MailSuffixDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.GateinPortalGroupsPermissionDatabase;
import org.exoplatform.selenium.platform.objectdatabase.gatein.GateinPortalMemberShipsPermissionDatabase;
import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Cloud_Config extends PlatformBase {
	//Platform
	ManageLogInOut magAc;
	Button button;
	ManageAlert alert;
	
	//Navigation 
	NavigationToolbar navTool;
	UserAddManagement addUserPage;
	UserAndGroupManagement userAndGroup;

	ContentAdministration caPage;
	//ObjectDatabase
	TextBoxDatabase txData;
	MailSuffixDatabase mailSuffixData;
	UserDatabase userData1;
	GateinPortalGroupsPermissionDatabase portGroupPermisData;
	GateinPortalMemberShipsPermissionDatabase portMemPermisData;
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		initSeleniumTest(false);
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		button = new Button(driver);
		alert = new ManageAlert(driver);
		addUserPage = new UserAddManagement(driver);
		userAndGroup = new UserAndGroupManagement(driver);
		navTool = new NavigationToolbar(driver);
		caPage = new ContentAdministration(driver);
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		mailSuffixData = new MailSuffixDatabase();
		mailSuffixData.setMailSuffixData(mailSuffixFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		userData1 = new UserDatabase();
		userData1.setUserData(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		portGroupPermisData = new GateinPortalGroupsPermissionDatabase();
		portGroupPermisData.setData(portalPermisGroupFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		portMemPermisData = new GateinPortalMemberShipsPermissionDatabase();
		portMemPermisData.setData(portalPermisMemFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);

		magAc.signIn(USER_ROOT, PASS_ROOT);

	}
	@AfterMethod
	public void afterMethod(){
		info("Start afterMethod");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End afterMethod");
	}
}
