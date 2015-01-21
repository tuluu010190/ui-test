package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.forum.ForumHomePage;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.social.MyProfilePage;
import org.testng.annotations.*;
/**
 * @author quynhpt
 * Date 21/01/2015
 */

public class Forum_Forum_MoreAction extends PlatformBase {
	HomePagePlatform hp;
	NavigationToolbar navTool;
	
	ForumHomePage forumHP;
	ManageLogInOut magAc;
	MyProfilePage myPro;
	
	AttachmentFileDatabase fData;
	TextBoxDatabase txData;

	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,true,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		hp = new HomePagePlatform(driver);
		navTool = new NavigationToolbar(driver);
		forumHP = new ForumHomePage(driver);
		magAc = new ManageLogInOut(driver);
		myPro = new MyProfilePage(driver);
		
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		
		magAc.signIn(DATA_USER1, DATA_PASS);
	}


	@AfterMethod
	public void afterMethod(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	/**
	 * CaseID: 116749
	 * Case_name: Ban IP for a forum
	 * Steps:
	 * 1. Prepare data: create a caterory, forum:
	 * - Create a category
	 * - Create a forum
	 * 2. Ban Ips
	 * - Access a forum as normal user
	 * - Click on More Action >’ Ban Ips
	 * - Put IP address
	 * - Save
	 * Expected:
	 * Added IP in Ban IP list can not do actions in Forum
	 * PENDING: CANNOT AUTOMATE
	 */
	@Test(groups="pending")
	public void test01_BanIPForForum() {

	}
	/**
	 * CaseID: 116747
	 * Case_name: Lock / Unlock a forum
	 * Steps:
	 * 1. Prepare data: create a caterory, forum:
	 * - Create a category
	 * - Create a forum
	 * 2. Lock a forum
	 * - Open this forum
	 * - Click on More Action, then click on Lock
	 * ==> Forum is locked successfully. Normal user can not add topic into locked forum
	 * 3. Unlock a forum
	 * - Open this forum
	 * - Click on More Action, then click on Unlock
	 * ==> Forum is unlocked successfully 
	 */
	@Test
	public void test02_LockUnlockForum() {
		info("Lock / Unlock a forum");
		String cate = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String forum  = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		// go to Forum home page
		hp.goToForum();
		
		// Add a category
		forumHP.addCategory(cate, "", cate);
		forumHP.saveChangesAddCategory();
		
		// Add a forum in the category
		forumHP.addForum(forum, "", forum);
		forumHP.saveChangesAddForum();
		
		//lock the forum
		forumHP.lockAndUnlock(true);
		waitForAndGetElement(forumHP.ELEMENT_FORUM_START_TOPIC_DISABLE);
		
		//sign out and log in with user2
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		
		// go to Forum home page
		hp.goToForum();
		//Go to the forum
		forumHP.goToDetailForum(forum);
		waitForAndGetElement(forumHP.ELEMENT_FORUM_START_TOPIC_DISABLE);
		
		// sign out and log in with user1
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		// go to Forum home page
		hp.goToForum();
		//Go to the forum
		forumHP.goToDetailForum(forum);
		
		//unlock the forum
		forumHP.lockAndUnlock(false);
		//Verify that the forum is unlocked
		waitForAndGetElement(forumHP.ELEMENT_FORUM_START_TOPIC_BUTTON);
		
		// sign out and log in with user2
		magAc.signOut();
	    magAc.signIn(DATA_USER2, DATA_PASS);
	    
		// go to Forum home page
		hp.goToForum();
		// Go to the forum
		forumHP.goToDetailForum(forum);
		//Verify that the forum is enabled
		waitForAndGetElement(forumHP.ELEMENT_FORUM_START_TOPIC_BUTTON);
		
		//log in back USER1
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		// go to Forum home page
		hp.goToForum();
		
		// Delete category
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(cate);

	}
	
	/**
	 * CaseID: 116748
	 * Case_name: Open / Close a forum
	 * Steps:
	 * 1. Prepare data: create a caterory, forum:
	 * - Create a category
	 * - Create a forum
	 * 2. Close a forum
	 * - Access 1 forum
	 * - Click on More Action, click on Close
	 * ==> Normal user can not view closed forum 
	 * 3. Open a forum
	 * - Access a closed forum
	 * - Click on More Action, click on Open
	 * ==> This forum is opened, normal user can view this
	 */
	@Test
	public void test03_OpenCloseForum() {
		info("Open / Close a forum");
		String cate = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String forum  = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		// go to Forum home page
		hp.goToForum();

		// Add a category
		forumHP.addCategory(cate, "", cate);
		forumHP.saveChangesAddCategory();

		// Add a forum in the category
		forumHP.addForum(forum, "", forum);
		forumHP.saveChangesAddForum();

		//Close the forum
		forumHP.closeAndOpen(true);
		waitForAndGetElement(forumHP.ELEMENT_FORUM_START_TOPIC_DISABLE);
		
		// sign out and log in with user2
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);

		// go to Forum home page
		hp.goToForum();
		//Verify that the forum is hided
		waitForElementNotPresent(forumHP.ELEMENT_FORUM_TITLE_LINK.replace("${name}",forum));
		
		// sign out and log in with user1
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);

		// go to Forum home page
		hp.goToForum();
		// Go to the forum
		forumHP.goToDetailForum(forum);
		
		//open the forum
		forumHP.closeAndOpen(false);
		
		// Verify that the forum is opened
		waitForAndGetElement(forumHP.ELEMENT_FORUM_START_TOPIC_BUTTON);

		// sign out and log in with user2
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);

		// go to Forum home page
		hp.goToForum();
		// Go to the forum
		waitForAndGetElement(forumHP.ELEMENT_FORUM_TITLE_LINK.replace("${name}",forum));
		
		// log in back USER1
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		// go to Forum home page
		hp.goToForum();

		// Delete category
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(cate);

	}
}