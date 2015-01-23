package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;
/**
 * @author quynhpt
 * Date 21/01/2015
 */

public class Forum_Forum_MoreAction extends Forum_TestConfig {
	
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
		
		info("go to Forum home page");
		hp.goToForum();
		
		info("Add a category");
		forumCatMag.addCategorySimple(cate, "", cate);
		
		info("Add a forum in the category");
		forumMag.addForumSimple(forum, "", forum);
		
		info("lock the forum");
		forumMag.lockAndUnlock(true);
		
		info("sign out and log in with user2");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		
		info("go to Forum home page");
		hp.goToForum();
		info("Go to the forum");
		forumHP.goToForum(forum);
		waitForAndGetElement(forumMag.ELEMENT_FORUM_START_TOPIC_DISABLE);
		
		info("sign out and log in with user1");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		info("go to Forum home page");
		hp.goToForum();
		info("Go to the forum");
		forumHP.goToForum(forum);
		
		info("unlock the forum");
		forumMag.lockAndUnlock(false);
		
		info("sign out and log in with user2");
		magAc.signOut();
	    magAc.signIn(DATA_USER2, DATA_PASS);
	    
		info("go to Forum home page");
		hp.goToForum();
		info("Go to the forum");
		forumHP.goToForum(forum);
		info("Verify that the forum is enabled");
		waitForAndGetElement(forumMag.ELEMENT_FORUM_START_TOPIC_BUTTON);
		
		info("log in back USER1");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
	    info("go to Forum home page");
		hp.goToForum();
		
		info("Delete category");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(cate);

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
		
		info("go to Forum home page");
		hp.goToForum();

		info("Add a category");
		forumCatMag.addCategorySimple(cate, "", cate);

		info("Add a forum in the category");
		forumMag.addForumSimple(forum, "", forum);

		info("Close the forum");
		forumMag.closeAndOpen(true);
		
		info("sign out and log in with user2");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);

		info("go to Forum home page");
		hp.goToForum();
		info("Verify that the forum is hided");
		waitForElementNotPresent(forumHP.ELEMENT_FORUM_TITLE_LINK.replace("${name}",forum));
		
		info("sign out and log in with user1");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);

		info("go to Forum home page");
		hp.goToForum();
		info("Go to the forum");
		forumHP.goToForum(forum);
		
		info("open the forum");
		forumMag.closeAndOpen(false);

		info("sign out and log in with user2");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);

		info("go to Forum home page");
		hp.goToForum();
		info("Go to the forum");
		waitForAndGetElement(forumHP.ELEMENT_FORUM_TITLE_LINK.replace("${name}",forum));
		
		info("log in back USER1");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		info("go to Forum home page");
		hp.goToForum();

		info("Delete category");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(cate);

	}
}