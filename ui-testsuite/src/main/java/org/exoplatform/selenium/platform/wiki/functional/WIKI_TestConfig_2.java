package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.gatein.UserAddManagement;
import org.exoplatform.selenium.platform.gatein.UserAndGroupManagement;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.objectdatabase.wiki.ReadThreeColDatabase;
import org.exoplatform.selenium.platform.objectdatabase.wiki.ReadTwoColDatabase;
import org.exoplatform.selenium.platform.wiki.RichTextEditor;
import org.exoplatform.selenium.platform.wiki.SourceTextEditor;
import org.exoplatform.selenium.platform.wiki.WikiDraftPage;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.exoplatform.selenium.platform.wiki.WikiManagement;
import org.exoplatform.selenium.platform.wiki.WikiPageInformation;
import org.exoplatform.selenium.platform.wiki.WikiPermission;
import org.exoplatform.selenium.platform.wiki.WikiSearch;
import org.exoplatform.selenium.platform.wiki.WikiSettingPage;
import org.exoplatform.selenium.platform.wiki.WikiValidattions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WIKI_TestConfig_2 extends PlatformBase {
	
	ManageLogInOut magAc;
	
	NavigationToolbar navTool;
	HomePagePlatform hp;
	
	WikiHomePage wHome;
	WikiManagement wikiMg;
	WikiDraftPage wDraf;
	WikiValidattions wValidate;
	WikiPermission wPermission;
	WikiSettingPage wSetting;
	WikiSearch wSearch;
	WikiPageInformation wPageInfo;
	RichTextEditor richEditor;
	SourceTextEditor sourceEditor;
	
	
	TextBoxDatabase txData;
	UserAddManagement addUserPage;
	UserAndGroupManagement userAndGroup;
	ReadTwoColDatabase wikiWarningData;
	ReadThreeColDatabase permisGroups;
	ReadTwoColDatabase permisMem;
	
	ArrayList<String> arrayPage;
	ArrayList<String> arrayUsers;
	ArrayList<String> arrayGroups;
	ArrayList<String> arrayTemplate;
	ArrayList<String> arrayGroupsPath;
	
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		navTool = new NavigationToolbar(driver);
		addUserPage = new UserAddManagement(driver);
		userAndGroup = new UserAndGroupManagement(driver);
		
		
		hp = new HomePagePlatform(driver);
		wHome=new WikiHomePage(driver);
		wikiMg = new WikiManagement(driver);
		wDraf = new WikiDraftPage(driver);
		richEditor = new RichTextEditor(driver);
		sourceEditor = new SourceTextEditor(driver);
		wValidate = new WikiValidattions(driver);
		wPermission = new WikiPermission(driver);
		wSetting = new WikiSettingPage(driver);
		wSearch = new WikiSearch(driver);
		wPageInfo = new WikiPageInformation(driver);
		
		wikiWarningData = new ReadTwoColDatabase();
		wikiWarningData.setData(wikiWarningsFilePath, defaultSheet, isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		permisGroups = new ReadThreeColDatabase();
		permisGroups.setData(permisGroupFilePath, defaultSheet, isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		
		permisMem = new ReadTwoColDatabase();
		permisMem.setData(permisMemFilePath, defaultSheet, isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		arrayUsers = new ArrayList<String>();
		arrayTemplate = new ArrayList<String>();
		arrayGroups = new ArrayList<String>();
		arrayPage  = new ArrayList<String>();
		arrayGroupsPath = new ArrayList<String>();
		
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		info("End setUpBeforeMethod");
	}

	@AfterMethod
	public void afterMethod(){
		info("Start afterMethod");
		magAc.signOut();
		magAc.signIn(DATA_USER1,DATA_PASS);
		deleteAllUsers();
		deleteAllGroups();
		deleteGroupsWikiSetting();
		deleteAllTemplates();
		deleteAllWikiPages();
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End afterMethod");
	}
	
	/**
	 * Delete all users that are created in testing process
	 */
	public void deleteAllUsers(){
		if(arrayUsers.size()>0){
			navTool.goToUsersAndGroupsManagement();
			userAndGroup.deleteAllUsers(arrayUsers);
		}
	}
	/**
	 * Delete all groups
	 */
	public void deleteAllGroups(){
		if(arrayGroups.size()>0){
			navTool.goToUsersAndGroupsManagement();
			userAndGroup.goToGroupTab();
			for(String group:arrayGroups){
				info("Delete a group");
				userAndGroup.selectGroup(group);
				userAndGroup.deleteGroup(group,true);
			}
			
		}
	}
	
	/**
	 * Delete all templates
	 */
	public void deleteAllTemplates(){
		if(arrayTemplate.size()>0){
			for(String template:arrayTemplate){
				info("Delete the template:"+template);
				driver.get(baseUrl);
				hp.goToWiki();
				wHome.goToWikiSettingPage();
				wSetting.searchTemplate(template);
				wSetting.deleteTemplate(template);
			}
		}
	}
	/**
	 * Delete All permission groups in Wiki Setting
	 */
	public void deleteGroupsWikiSetting(){
		if(arrayGroupsPath.size()>0){
			for(String group:arrayGroupsPath){
				info("Delete the group:"+group);
				hp.goToWiki();
				wHome.goToWikiSettingPage();
				wSetting.goToPermissionTab();
				wPermission.deletePermission(group);
			}
			wPermission.savePermisison();
			wHome.confirmWaringMessage(true);
		}
	}
	
	/**
	 * Delete all wiki pages that are created in testing proccess
	 */
	public void deleteAllWikiPages(){
		if(arrayPage.size()>0){
			for(String title:arrayPage){
				info("Delete the page:"+title);
				driver.get(baseUrl);
				hp.goToWiki();
				wHome.deleteWiki(title);
			}
		}
	}
	
}