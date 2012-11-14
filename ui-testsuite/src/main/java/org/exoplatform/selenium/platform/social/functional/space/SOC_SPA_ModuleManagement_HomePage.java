package org.exoplatform.selenium.platform.social.functional.space;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import org.exoplatform.selenium.platform.social.SocialBase;
import org.exoplatform.selenium.platform.social.ManageMember.userType;
import static org.exoplatform.selenium.platform.social.ManageMember.managerInviteUserToJoinSpace;
import static org.exoplatform.selenium.platform.social.ManageMember.userAcceptInvitationToJoinSpace;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.Activity.addActivity;
import static org.exoplatform.selenium.platform.social.Activity.addComment;
import static org.exoplatform.selenium.platform.social.Activity.deleteActivity;
import static org.exoplatform.selenium.platform.social.Activity.deleteComment;
import static org.exoplatform.selenium.platform.social.Activity.likeOrUnlikeActivity;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author: hangNTT
 * Date: 21/11/2012
 * @Manage Member: HomePage
 */
public class SOC_SPA_ModuleManagement_HomePage extends SocialBase{

	public static String DATA_USER1 = "john";
	public static String DATA_USER2 = "mary";
	public static String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(DATA_USER1, DATA_PASS);
	}
	//Add new your activity not share link
	@Test
	public void test01_addNewYourActivity(){

		String SPACE_NAME01 ="space01";

		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace(SPACE_NAME01, "description of space1",120000);

		addActivity(true,"test activity demo", false, "http://www.google.com");

		info("-- Deleting an activity --");

		deleteActivity("test activity demo");

		info("Restore data");

		restoreData(SPACE_NAME01, 120000);

	}

	//Add new your activity with share link
	@Test
	public void test08_addAShareLink(){

		String SPACE_NAME02 ="space02";

		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace(SPACE_NAME02, "description of space2",120000);

		addActivity(true,"test activity for space 2", true, "http://www.google.com");

		info("-- Deleting an activity --");

		deleteActivity("test activity for space 2");

		info("Restore data");

		restoreData(SPACE_NAME02, 150000);
	}
	//Like And Unline Activity
	@Test
	public void test27_likeAndUnkineActivity(){

		String SPACE_NAME03 ="space03";

		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace(SPACE_NAME03, "description of space3",120000);

		addActivity(true,"test activity for john", false, "http://www.google.com");

		info("-- Action: like an activity --");

		likeOrUnlikeActivity("test activity for john");

		waitForTextPresent("You like this.");

		info("-- Action: Unlike an activity --");

		likeOrUnlikeActivity("test activity for john");

		waitForTextNotPresent("You like this.");

		deleteActivity("test activity for john");

		restoreData(SPACE_NAME03, 120000);
	}

	//Add new your activity
	@Test
	public void test28_deleteActivityByManagerOfSpace(){

		String SPACE_NAME04 ="space04";

		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace(SPACE_NAME04, "description of space4",120000);

		addActivity(true,"test activity1 for john", true, "http://www.google.com");

		addActivity(true,"test activity2 for john", true, "http://www.google.com");

		addActivity(true,"test activity3 for john", true, "http://www.google.com");

		info("invite user");

		managerInviteUserToJoinSpace(userType.ADMIN, SPACE_NAME04, userType.PUBLISHER);

		info("-- Accept the invitation --");

		userAcceptInvitationToJoinSpace(true, userType.PUBLISHER, SPACE_NAME04);

		accessSpace(SPACE_NAME04);

		addActivity(true,"test activity for mary", true, "http://www.google.com");

		signOut();

		signIn(DATA_USER1, DATA_PASS);

		accessSpace(SPACE_NAME04);

		info("Delete activity by manager");

		deleteActivity("test activity1 for john");

		info("Delete other user's activities on Space");

		deleteActivity("test activity for mary");

		restoreData(SPACE_NAME04, 120000);
	}
	//Comment on activity
	@Test
	public void test30_commentOnActivity(){

		String SPACE_NAME05 ="space05";

		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace(SPACE_NAME05, "description of space5",120000);

		addActivity(true,"test activity for john", true, "http://www.google.com");

		addComment("test activity for john", "exoplatform");

		deleteComment("exoplatform");

		deleteActivity("test activity for john");

		restoreData(SPACE_NAME05, 120000);
	}
	//Delete comment by Owner
	@Test
	public void test31_deleteCommentByOwner(){

		String SPACE_NAME06 ="space06";

		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace(SPACE_NAME06, "description of space6",120000);

		addActivity(true,"test activity for john", true, "http://www.google.com");

		addComment("test activity for john", "exoplatform");

		deleteComment("exoplatform");

		deleteActivity("test activity for john");

		restoreData(SPACE_NAME06, 120000);
	}
	//Delete comment by Owner
	@Test
	public void test32_deleteCommentByOwner(){

		String SPACE_NAME07 ="space07";

		info("-- Creating a new space --");

		goToMySpacePage();

		addNewSpace(SPACE_NAME07, "description of space7",120000);

		addActivity(true,"test activity for john", true, "http://www.google.com");

		addComment("test activity for john", "exoplatform");

		info("invite user");

		managerInviteUserToJoinSpace(userType.ADMIN, SPACE_NAME07, userType.PUBLISHER);

		info("-- Accept the invitation --");

		userAcceptInvitationToJoinSpace(true, userType.PUBLISHER, SPACE_NAME07);

		accessSpace(SPACE_NAME07);

		waitForTextNotPresent("ELEMENT_DELETE_COMMENT_BUTTON");

		addActivity(true,"test activity for mary", false, "http://www.google.com");

		addComment("activity for mary", "comment of mary");

		signOut();

		signIn(DATA_USER1, DATA_PASS);

		accessSpace(SPACE_NAME07);

		deleteComment("comment of mary");

		deleteActivity("test activity for john");

		restoreData(SPACE_NAME07, 120000);
	}

	@AfterMethod
	public void afterMethods(){
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}
}