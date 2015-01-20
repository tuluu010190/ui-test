package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.acme.AcmeHomePage;
import org.exoplatform.selenium.platform.ecms.EditPageWCM;
import org.exoplatform.selenium.platform.forum.ForumHomePage;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.openqa.selenium.By;
import org.testng.annotations.*;

/**
* @author cmugnier
* @date 20/01/2015
*/

public class Forum_Settings extends PlatformBase {

	HomePagePlatform hp;
	ManageLogInOut magAc;
	ManageAlert magAlert;
	Button but;
	TextBoxDatabase txData;
	NavigationToolbar navTool;
	AcmeHomePage acmeHP;
	AttachmentFileDatabase fData;
	ForumHomePage forumHP;
	EditPageWCM editPage;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,true,jdbcDriver,dbUrl,user,pass,sqlUser);
		driver.get(baseUrl);
		magAc = new ManageLogInOut(driver);
		but = new Button(driver);
		hp = new HomePagePlatform(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		navTool = new NavigationToolbar(driver);
		acmeHP = new AcmeHomePage(driver);
		magAlert = new ManageAlert(driver, this.plfVersion);
		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		forumHP = new ForumHomePage(driver);
		editPage = new EditPageWCM(driver);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	/**
	 *<li> Case ID:116686.</li>
	 *<li> Test Case Name: User Settings.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public void test01_UserSettings() {
		info("Test 1: User Settings");
		
		hp.goToForum();
		/*Step Number: 1
		 *Step Name: User Setting
		 *Step Description:
		- Click on SettingsChange profile information
		- Click on Profile tab
		- Chang profile informationChange forum settings
		- Click on Forum settings tab
		- Chang forum informationManage my subscription
		- Click on My subscriptions tab
		- Chang subscriptions information
		 *Input Data:
		 *Expected Outcome:
		- User profile is updated
		- Forum is setting successful
		- Allow get Feed URL of category/forum/topic and update email of user watched*/

		click(forumHP.ELEMENT_ACTIONBAR_SETTINGS);
		type(forumHP.ELEMENT_FORUM_SETTINGS_SCREENNAME, "UserJohn", true);
		click(forumHP.ELEMENT_FORUM_SETTINGS_FORUMSETTINGS);
		select(forumHP.ELEMENT_FORUM_SETTINGS_MAXTHREADS, "5", 2);
		click(forumHP.ELEMENT_FORUM_SETTINGS_MYSUSCRIB);
		type(forumHP.ELEMENT_FORUM_SETTINGS_EMAILADRESS, "email@exo.com", true);
		click(forumHP.ELEMENT_FORUM_SETTINGS_UPDATE);
		click(forumHP.ELEMENT_FORUM_SETTINGS_SAVE);
		waitForAndGetElement(By.xpath((forumHP.ELEMENT_FORUM_VERIFY_USER).replace("${user}", "UserJohn")));
	}
	/**
	 *<li> Case ID:116691.</li>
	 *<li> Test Case Name: Setting Forum portlet.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public void test02_SettingForumPortlet() {
		info("Test 2: Setting Forum portlet");
		
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToForum();
		forumHP.addCategorySimple(name);
		forumHP.addForumSimple(name2);
		/*Step Number: 1
		 *Step Name: Setting Forum porlet from edit mode
		 *Step Description:
		- Show/hide category
		- enable/disable panel
		- Use/not use ajax
		 *Input Data:
		 *Expected Outcome:
		Setting porlet is successful with properties*/
		
		click(hp.ELEMENT_EDIT_BUTTON);
		mouseOver(hp.ELEMENT_EDIT_PAGE, true);
		click(hp.ELEMENT_EDIT_PAGE_EDITLAYOUT);
		mouseOver(editPage.ELEMENT_PAGEEDITOR_FORUM, true);
		click(editPage.ELEMENT_PAGEEDITOR_EDITELEMENT);
		uncheck(editPage.ELEMENT_EDITFORUM_CATEGORY, 2);
		click(editPage.ELEMENT_PAGEEDITOR_SAVEBTN);
		click(editPage.ELEMENT_PAGEEDITOR_OKBTN);
		click(editPage.ELEMENT_PAGEEDITOR_CLOSEBTN);
		click(editPage.ELEMENT_PAGEEDITOR_FINISHLIGHTBTN);
		waitForElementNotPresent((forumHP.ELEMENT_FORUM_TITLECAT).replace("${title}", name));
	}
	/**
	 *<li> Case ID:116698.</li>
	 *<li> Test Case Name: User management.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public void test03_UserManagement() {
		info("Test 3: User management");
		/*Step Number: 1
		 *Step Name: Step 1: Manage users
		 *Step Description:
		- Click on Uses
		- Click Edit icon corresponding with 1 userChange user profile
		- Click on Profile tab
		- Change informationChange user setting
		- Click on Setting tab
		- Change informationBan User
		- Click on Ban Uses tab
		- Change informationView all topics of User
		- Click on Topic tabView add posts by User
		- Click on Posts tab
		 *Input Data:
		 *Expected Outcome:
		User information is updated successfully*/
		hp.goToForum();
		click(forumHP.ELEMENT_ACTIONBAR_USER);
		type(forumHP.ELEMENT_FORUM_USERS_POPUP_SEARCH_FIELD,"mary",true);
		pressEnterKey();
		click((forumHP.ELEMENT_FORUM_USERS_EDIT).replace("${name}", "mary"));
		type(forumHP.ELEMENT_FORUM_SETTINGS_SCREENNAME, "Mary", true);
		click(forumHP.ELEMENT_FORUM_USERS_FORUMSETTINGS);
		select(forumHP.ELEMENT_FORUM_SETTINGS_MAXTHREADS, "5", 2);
		click(forumHP.ELEMENT_FORUM_USERS_BAN);
		click(forumHP.ELEMENT_FORUM_USERS_TOPICS);
		click(forumHP.ELEMENT_FORUM_USERS_POSTS);
		click(forumHP.ELEMENT_FORUM_SETTINGS_SAVE);
		click(forumHP.ELEMENT_FORUM_CLOSEBTN);
		
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToForum();
		waitForAndGetElement(By.xpath((forumHP.ELEMENT_FORUM_VERIFY_USER).replace("${user}", "Mary")));
	}
}