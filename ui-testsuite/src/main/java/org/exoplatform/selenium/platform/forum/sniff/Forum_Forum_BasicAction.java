package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.NavigationToolbar.specifUserToolBar;
import org.openqa.selenium.By;
import org.testng.annotations.*;
/**
 * By quynhpt
 * Date 20/01/2015
 */

public class Forum_Forum_BasicAction extends Forum_TestConfig {
	
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
		
		info("go to Forum home page");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(nameCat,"",nameCat);
		info("Add a forum in the category");
		forumMag.addForumSimple(nameForum,"",nameForum);
		info("Verify that the forum is shown successfully");
		waitForAndGetElement(forumHP.ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}",nameForum));
		
		info("Delete category");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(nameCat);
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
	
		info("go to Forum home page");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(nameCat,"",nameCat);
		info("Add a forum in the category");
		forumMag.addForumSimple(nameForum,"",nameForum);
	    info("Edit the forum");
		forumMag.editForum(newNameForum,"",newNameForum);
		info("Verify that the forum is edit successfully");
		waitForAndGetElement(forumHP.ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}",newNameForum));
		
		info("Delete category");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(nameCat);
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
		
		info("go to Forum home page");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(nameCat,"",nameCat);
		info("Add a forum in the category");
		forumMag.addForumSimple(nameForum,"",nameForum);
		info("Delete forum");
		forumMag.deleteForum(nameForum);
		info("Delete category");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(nameCat);
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
		
		info("go to Forum home page");
		hp.goToForum();
		info("Add a category 1");
		forumCatMag.addCategorySimple(category1, "", category1);
		info("go to Home page of category");
		forumHP.goToHomeCategory();
		info("Add a category 2");
		forumCatMag.addCategorySimple(category2,"", category2);
		
		forumHP.goToHomeCategory();
		forumHP.goToCategory(category1);
		info(" Add a forum in the category1");
		forumMag.addForumSimple(forum,"",forum );
		
		info("Move forum");
		forumMag.moveForum(forum, category2);
		
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(category2);
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(category1);
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

		info("Go to My Profile");
		navTool.selectALinkOfUserMenu(specifUserToolBar.MY_PROFILE);
		info("Change email address");
		myPro.updateBasicInformation("","",EMAIL_ADDRESS1);
		
		info("go to Forum home page");
		hp.goToForum();
		info("Verify that the forum home page is shown full");
		waitForAndGetElement(forumHP.ELEMENT_FORUM_WHAT_GOING_ON);
		
		info("Add a category");
		forumCatMag.addCategorySimple(category,"",category);
		
		info("Add a forum in the category1");
		forumMag.addForumSimple(forum,"", forum);
		
		info("Watch forum");
		forumHP.watchItem(true);
		info("Create a topic without attached file");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic1, topic1,"","");
		
		info("Check email after watching");
		goToMail(EMAIL_ADDRESS1, EMAIL_PASS);
		checkAndDeleteMail(By.xpath(ELEMENT_MAIL_SUBJECT.replace("${category}",category).replace("${forum}", forum).replace("${topic}", topic1)), forum);
		
		switchToParentWindow();
		
		info("Unwatch forum");
		forumHP.watchItem(false);
		forumMag.goToStartTopic();
		foTopic.startTopic(topic2, topic2,"","");
		
		info("Check email after unwatching");
		switchToNewWindow();
		Utils.pause(30000);
		waitForElementNotPresent(ELEMENT_MAIL_SUBJECT.replace("${category}",category).replace("${forum}", forum).replace("${topic}", topic2));
		
		switchToParentWindow();
		
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(category);

	}

}