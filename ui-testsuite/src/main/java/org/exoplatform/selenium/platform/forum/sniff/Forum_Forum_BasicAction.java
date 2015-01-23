package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.NavigationToolbar.specifUserToolBar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.forum.ForumHomePage;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.exoplatform.selenium.platform.social.MyProfilePage;
import org.openqa.selenium.By;
import org.testng.annotations.*;
/**
 * By quynhpt
 * Date 20/01/2015
 */

public class Forum_Forum_BasicAction extends PlatformBase {
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
	 * CaseID: 116735
	 * Case_name: Add a forum
	 * Steps:
	 * 1. Prepare data: create a caterory. a forum
	 * 2. Edit a forum:
	 *  - Select 1 forum
	 *  - Click on More Action, click Edit
	 *  - Put values
	 *  - Click Save
	 *  Expected:
	 *  Forum is updated with new changes
	 */
	@Test
	public void test01_AddForum() {
		info("test01: Add Forum");
		String nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nameForum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		//go to Forum home page
		hp.goToForum();
		//Add a category
		forumHP.addCategory(nameCat,"",nameCat);
		forumHP.saveChangesAddCategory();
		//Add a forum in the category
		forumHP.addForum(nameForum,"",nameForum);
		forumHP.saveChangesAddForum();
		//Verify that the forum is shown successfully
		waitForAndGetElement(forumHP.ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}",nameForum));
		
		//Delete category
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(nameCat);
	} 
	
	/** 
	 * CaseID: 116736
	 * Case_name: Edid a forum
	 * Steps:
	 * 1. Prepare data: create a caterory
	 * 2. Add a forum:
	 *  - Click on Add forum icon
	 *  - Put values
	 *  - Click Save
	 *  Expected:
	 *  Forum is added successfully.
	 */
	@Test
	public void test02_EditForum() {
		info("test02: Edit Forum");
		String nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nameForum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newNameForum=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		//oder by default =0
		String order="";
		//go to Forum home page
		hp.goToForum();
		//Add a category
		forumHP.addCategory(nameCat,order,nameCat);
		forumHP.saveChangesAddCategory();
		//Add a forum in the category
		forumHP.addForum(nameForum,order,nameForum);
		forumHP.saveChangesAddForum();
	    //Edit the forum
		forumHP.editForum(newNameForum,order,newNameForum);
		forumHP.saveChangesAddForum();
		//Verify that the forum is edit successfully
		waitForAndGetElement(forumHP.ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}",newNameForum));
		
		//Delete category
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(nameCat);
	} 

	/** 
	 * CaseID: 116736
	 * Case_name: Edid a forum
	 * Steps:
	 * 1. Prepare data: create a caterory
	 * 2. Add a forum:
	 *  - Click on Add forum icon
	 *  - Put values
	 *  - Click Save
	 *  Expected:
	 *  Forum is added successfully.
	 */
	@Test
	public void test03_DeleteForum() {
		info("test03: Delete Forum");
		String nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nameForum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		//oder by default =0
		String order="";
		//go to Forum home page
		hp.goToForum();
		//Add a category
		forumHP.addCategory(nameCat,order,nameCat);
		forumHP.saveChangesAddCategory();
		//Add a forum in the category
		forumHP.addForum(nameForum,order,nameForum);
		forumHP.saveChangesAddForum();
		//Delete forum
		forumHP.deleteForum(nameForum);
		//Delete category
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(nameCat);
	} 
    
	/** 
	 * CaseID: 116738
	 * Case_name: Move a forum
	 * Steps:
	 * 1. Prepare data: create a caterory
	 * 2. Add a forum:
	 *  - Select 1 forum
	 *  - Click on More Action, select Move
	 *  - Choose destination category
	 *  Expected:
	 * This forum is moved to a destination category
	 */
	@Test
	public void test04_MoveForum() {
		info("Move a forum");
		String category1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String category2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String forum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		// oder by default =0
		String order = "";
		// go to Forum home page
		hp.goToForum();
		// Add a category 1
		forumHP.addCategory(category1, order, category1);
		forumHP.saveChangesAddCategory();
		
		forumHP.goToHomeCategory();
		// Add a category 2
		forumHP.addCategory(category2, order, category2);
		forumHP.saveChangesAddCategory();
		
		forumHP.goToHomeCategory();
		forumHP.goToCategory(category1);
		// Add a forum in the category1
		forumHP.addForum(forum, order,forum );
		forumHP.saveChangesAddForum();
		
		//Move forum
		forumHP.moveForum(forum, category2);
		
		//Delete data
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(category2);
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(category1);
	}
	
	/** 
	 * CaseID: 116688
	 * Case_name: Watch & Unwatch forum
	 * Steps:
	 * 1. Prepare data: create a caterory
	 * 2. Watch a forum:
	 *  - Select a forum
	 *  - Click Watch icon
	 *  ==> Forum  is watched successfully.
	 *  Email of user watching this forum is listed on Manage Watch form
	 *  3. Unwatch a forum
	 *  - Select a watched forum
	 *  - Click UnWatch icon
	 * ==>Forum  is unwatched successfully
	 * PENDING: CANNOT SEND A EMAIL,MAYBE DUE TO CONFIGURATION EMAIL.
	 */
	@Test(groups= "pending")
	public void test05_WatchUnwatchForum() {
		info("Watch & Unwatch forum");
		String category = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String forum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		//Go to My Profile
		navTool.selectALinkOfUserMenu(specifUserToolBar.MY_PROFILE);
		//Change email address
		myPro.updateBasicInformation("","",EMAIL_ADDRESS1);
		
		// go to Forum home page
		hp.goToForum();
		// Verify that the forum home page is shown full
		waitForAndGetElement(forumHP.ELEMENT_FORUM_WHAT_GOING_ON);
		
		// Add a category
		forumHP.addCategory(category,"",category);
		forumHP.saveChangesAddCategory();
		
		// Add a forum in the category1
		forumHP.addForum(forum,"", forum);
		forumHP.saveChangesAddForum();
		
		//Watch forum
		forumHP.watchItem(true);
		//Create a topic without attached file
		forumHP.startTopic(topic1, topic1,"","");
		
		//Check email after watching
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		checkAndDeleteMail(By.xpath(ELEMENT_MAIL_SUBJECT.replace("${category}",category).replace("${forum}", forum).replace("${topic}", topic1)), forum);
		
		switchToParentWindow();
		
		//Unwatch forum
		forumHP.watchItem(false);
		forumHP.startTopic(topic2, topic2,"","");
		
		//Check email after unwatching
		switchToNewWindow();
		Utils.pause(30000);
		waitForElementNotPresent(ELEMENT_MAIL_SUBJECT.replace("${category}",category).replace("${forum}", forum).replace("${topic}", topic2));
		
		switchToParentWindow();
		
		///Delete data
		forumHP.goToHomeCategory();
		forumHP.deleteCategory(category);

	}

}