package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.testng.annotations.*;

	public class SOC_Space_SpacesActivities extends SOC_TestConfig{

	/**
	*<li> Case ID:122427.</li>
	*<li> Test Case Name: Add activity after an user joins a public space.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	/**
	*<li> Case ID:122437.</li>
	*<li> Test Case Name: Update Space activity after a user leave a space.</li>
	*<li> Pre-Condition: a user is member of a space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_02_AddActivityAfterAnUserJoinsAPublicSpace() {
		info("Test 1: Add activity after an user joins a public space");
		String regist =spRegisData.getSpaceRegistration(0);
		String[] arrayRight ={regist};
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String urlSpace =baseUrl+"/g/:spaces:"+space.toLowerCase()+"/"+space.toLowerCase();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Join a public space (by creating new public space or request to join a public space)
		*Input Data: 
			
		*Expected Outcome: 
			- User joins a public space. A comment is added to the space creation activity.*/ 
		info("change access to open");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("user 2 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		driver.get(urlSpace);
		waitForAndGetElement(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN,2000,0).click();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}",DATA_NAME_USER2));
		
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Connect to Intranet
			- Open Spaces page
			- Leave a space
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The Space activity is updated in the activity stream: the number of members is updated to 
			-1
			- No comment is added into activity*/ 
		info("user 2 leave space");
		hp.goToMySpaces();
		spaMg.leaveSpace(space);
		
		info("user 1 login");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_SPACE_MEMBER_NUMBER.replace("${space}",space).replace("${num}", "1"));
		
		info("last comment is still Join space");
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_SPACE_SPACE_LAST_COMMENT_JOINSPACE.replace("${space}", space));
		
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
 	}

	/**
	*<li> Case ID:122442.</li>
	*<li> Test Case Name: Not display Space activity after edit Visibility/Registration of space.</li>
	*<li> Pre-Condition: - At least a space activity is shared in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_NotDisplaySpaceActivityAfterEditVisibilityRegistrationOfSpace() {
		info("Test 3: Not display Space activity after edit Visibility/Registration of space");
		String regist =spRegisData.getSpaceRegistration(2);
		String[] arrayRight ={regist};
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		/*Step Number: 1
		*Step Name: Edit Visibility/Registration of space
		*Step Description: 
			- Connect to Intranet
			- Open a space
			- Edit the visibility and registration of the space
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The Space activity isn't updated*/ 
		info("change access to close");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("back to homepage");
		hp.goToHomePage();
		info("last comment is still Join space");
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_SPACE_SPACE_LAST_COMMENT_JOINSPACE.replace("${space}", space));
		
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}

	/**
	*<li> Case ID:122443.</li>
	*<li> Test Case Name: Not display Space activity after removing a space member.</li>
	*<li> Pre-Condition: - A space activity is shared in the activity stream
	- Space has at least 2 users
	- User A is administrator of space</li>
	*<li> Post-Condition: </li>
	*/
	/**
	*<li> Case ID:122446.</li>
	*<li> Test Case Name: Not display Space activity after invite other user to a space.</li>
	*<li> Pre-Condition: - A space activity is shared in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	
	@Test
	public  void test04_05_NotDisplaySpaceActivityAfterRemovingASpaceMember() {
		info("Test 5: Not display Space activity after invite other user to a space");
		/*Step Number: 1
		*Step Name: Invite an user
		*Step Description: 
			- Connect to Intranet
			- Open a space
			- Go to Space Settings
			-
			-> Member tab and select user to invite 
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The Space activity isn't updated*/ 
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String urlSpace =baseUrl+"/g/:spaces:"+space.toLowerCase()+"/"+space.toLowerCase();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToMemberTab();
		setSpaceMg.inviteUser(DATA_USER2,false,"");
		
		info("back to home page");
		hp.goToHomePage();
		info("last comment is still Join space");
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_SPACE_SPACE_LAST_COMMENT_JOINSPACE.replace("${space}", space));
		
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToMySpaces();
		spaMg.acceptAInvitation(space);
		
		info("Test 4: Not display Space activity after removing a space member");
		/*Step Number: 1
		*Step Name: Remove a member from space
		*Step Description: 
			- Connect to Intranet by user A
			- Open a space
			- Go to Space Settings 
			-
			-> Member
			- Click on Delete icon to remove a member of space
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The number of members of the space activity is updated 
			-1*/ 
		info("remove space member");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		driver.get(urlSpace);
		spaHome.goToSpaceSettingTab();
		setSpaceMg.deleteMember(DATA_USER2);
		
		info("space member is 1 now");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_SPACE_MEMBER_NUMBER.replace("${space}",space).replace("${num}", "1"));
		
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
 	}

	/**
	*<li> Case ID:122466.</li>
	*<li> Test Case Name: Add a Space activity on Intranet home page after create a space.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	/**
	*<li> Case ID:122449.</li>
	*<li> Test Case Name: Delete a Space activity from activity stream by its user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_12_DeleteASpaceActivityFromActivityStreamByItsUser() {
		info("Test 6: Delete a Space activity from activity stream by its user");
		/*Step Number: 1
		*Step Name: Step 1: Add space
		*Step Description: 
			- Connect to Intranet
			- Add a Space
		*Input Data: 
			
		*Expected Outcome: 
			- The Space activity is displayed in the activity stream*/

		/*Step number: 2
		*Step Name: Step 2: Display activity
		*Step Description: 
			- Move the mouse over the Space activity
		*Input Data: 
			
		*Expected Outcome: 
			A (X) icon is displayed in the top right panel of the activity*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}", DATA_NAME_USER1));
		mouseOver(hpAct.ELEMENT_ACTIVITY_SPACE_HEADING.replace("${space}", space),false);
		
		/*Step number: 3
		*Step Name: Step 3: Delete activity
		*Step Description: 
			- Click on the (X) icon
			- Click on OK button of confirmation message
		*Input Data: 
			
		*Expected Outcome: 
			The Space activity is removed from the activity stream*/ 
		info("delete space activity");
		Utils.pause(2000);
		click(hpAct.ELEMENT_ACTIVITY_SPACE_ACTIVITY_DELETE_BTN.replace("${space}", space));
		click(button.ELEMENT_OK_BUTTON);
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}", DATA_NAME_USER1),2000,1);
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}

	/**
	*<li> Case ID:122450.</li>
	*<li> Test Case Name: Dislike a Space activity from like icon.</li>
	*<li> Pre-Condition: - At least a space activity is shared
	- The activity is liked by the user A</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_DislikeASpaceActivityFromLikeIcon() {
		info("Test 7: Dislike a Space activity from like icon");
		/*Step Number: 1
		*Step Name: Display activity
		*Step Description: 
			- Connect to Intranet with User A
		*Input Data: 
			
		*Expected Outcome: 
			- The Space activity is displayed in the activity stream*like icon + number of likes to 1*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		
		hp.goToHomePage();
		info("like activity");
		click((hpAct.ELEMENT_ICON_LIKE).replace("${title}", space));
		waitForAndGetElement((hpAct.ELEMENT_ACTIVITY_LIKE_ICON_BLUE).replace("${nameFile}", space),2000,1);
		
		/*Step number: 2
		*Step Name: Dislike activity
		*Step Description: 
			- Click on like icon
		*Input Data: 
			
		*Expected Outcome: 
			- The Space activity is disliked by the user, the number of like is updated to 
			-1*/ 
		info("dislike activity");
		click((hpAct.ELEMENT_ACTIVITY_LIKE_ICON_BLUE).replace("${nameFile}", space));
		waitForElementNotPresent((hpAct.ELEMENT_ACTIVITY_LIKE_ICON_BLUE).replace("${nameFile}", space),2000,1);
	
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}

	/**
	*<li> Case ID:122451.</li>
	*<li> Test Case Name: Delete a User activity for space from activity stream by its user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	/**
	*<li> Case ID:122637.</li>
	*<li> Test Case Name: Add new your activity.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_19_DeleteAUserActivityForSpaceFromActivityStreamByItsUser() {
		info("Test 8: Delete a User activity for space from activity stream by its user");
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		*Step Name: Step 1: Add activity
		*Step Description: 
			- Connect to Intranet
			- Add a User activity for space
		*Input Data: 
			
		*Expected Outcome: 
			- The User activity for spaceis displayed in the activity stream*/
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		
		info("add activity");
		hpAct.addActivity(true,name,false,"");
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_TITLE.replace("${text}", name).replace("${file}", name),2000,1);
		
		/*Step number: 2
		*Step Name: Step 2: Show Remove icon
		*Step Description: 
			- Move the mouse over the User activity for space
		*Input Data: 
			
		*Expected Outcome: 
			A (X) icon is displayed in the top right panel of the activity*/
		mouseOver((hpAct.ELEMENT_ACTIVITY_SPACE_AUTHOR).replace("${title}", name), true);
		
		/*Step number: 3
		*Step Name: Step 3: Click Remove icon
		*Step Description: 
			- Click on the (X) icon
			- Click OK on confirmation form
		*Input Data: 
			
		*Expected Outcome: 
			The User activity for spaceis removed from the activity stream*/ 
		info("remove activity");
		click((hpAct.ELEMENT_ACTIVITY_USER_ACTIVITY_DELETE_BTN).replace("${title}", name));
		click(button.ELEMENT_OK_BUTTON);
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_TITLE.replace("${text}", name).replace("${file}", name));
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}

	/**
	*<li> Case ID:122452.</li>
	*<li> Test Case Name: Delete comment by manager.</li>
	*<li> Pre-Condition: - Space is created
	- Space has member: User1 
	- User1 comment on any activity</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_DeleteCommentByManager() {
		info("Test 9: Delete comment by manager");
		String regist =spRegisData.getSpaceRegistration(0);
		String[] arrayRight ={regist};
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String urlSpace =baseUrl+"/g/:spaces:"+space.toLowerCase()+"/"+space.toLowerCase();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		Utils.pause(2000);
		hpAct.addActivity(true,name,false,"");
		Utils.pause(2000);
		info("change access to open");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("user 2 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		driver.get(urlSpace);
		Utils.pause(2000);
		click(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}",DATA_NAME_USER2),2000,1);
		
		/*Step Number: 1
		*Step Name: Step 1: Remove comment of other member by manager
		*Step Description: 
			- Login as space manager
			- Go to Space activity
			- Move mouse over the comment added by User1
			- Click on (X) icon
			- Click OK on confirmation form
		*Input Data: 
			
		*Expected Outcome: 
			- Comment is removed by space manager*/ 
		info("comment on space activity");
		hpAct.addComment(name, content);
		Utils.pause(2000);
		waitForAndGetElement(hpAct.ELEMENT_PUBLICATION_COMMENTPOSTED.replace("${content}", content),2000,1);
		
		info("user 1 login");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		hp.goToSpecificSpace(space);
		
		info("user 1 remove comment of user 2");
		hpAct.deleteComment(name, content);
		waitForElementNotPresent(hpAct.ELEMENT_PUBLICATION_COMMENTPOSTED.replace("${content}", content),2000,1);
 	
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}

	/**
	*<li> Case ID:122453.</li>
	*<li> Test Case Name: Delete activity by other space member.</li>
	*<li> Pre-Condition: - Space is created
	- Space has some members: User1 and User2 (who are not manager of space)
	- User1 add activity on the space</li>
	*<li> Post-Condition: </li>
	*/
	/**
	*<li> Case ID:122454.</li>
	*<li> Test Case Name: Dislike a User activity for space from like icon.</li>
	*<li> Pre-Condition: - Space is created
	- Space has user activity</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_11_DeleteActivityByOtherSpaceMember() {
		info("Test 10 Delete activity by other space member");
		String regist =spRegisData.getSpaceRegistration(0);
		String[] arrayRight ={regist};
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String urlSpace =baseUrl+"/g/:spaces:"+space.toLowerCase()+"/"+space.toLowerCase();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		
		info("change access to open");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("user 2 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		driver.get(urlSpace);
		Utils.pause(2000);
		click(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}",DATA_NAME_USER2),2000,1);
		
		info("user 2 add activity");
		hpAct.addActivity(true,name,false,"");
		
		/*Step Number: 1
		*Step Name: Step 1: Remove space activity of other space member
		*Step Description: 
			- Login as User2
			- Go to Space Activity stream
			- Move mouse over activity of User1
		*Input Data: 
			
		*Expected Outcome: 
			- (X) icon is not displayed, so he cannot remove space activity of other member*/ 
		info("user 3 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER3, DATA_PASS);
		driver.get(urlSpace);
		Utils.pause(2000);
		click(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN);
		
		info("user 3 doesnt see X icon to remove user 2's activity");
		mouseOver((hpAct.ELEMENT_ACTIVITY_SPACE_AUTHOR).replace("${title}", name), true);
		waitForElementNotPresent((hpAct.ELEMENT_ACTIVITY_USER_ACTIVITY_DELETE_BTN).replace("${title}", name),2000,1);
		
		info("like activity");
		click((hpAct.ELEMENT_ICON_LIKE).replace("${title}", name));
		waitForAndGetElement((hpAct.ELEMENT_ACTIVITY_LIKE_ICON_BLUE).replace("${nameFile}", name),2000,1);

		info("dislike activity");
		click((hpAct.ELEMENT_ACTIVITY_LIKE_ICON_BLUE).replace("${nameFile}", name));
		waitForElementNotPresent((hpAct.ELEMENT_ACTIVITY_LIKE_ICON_BLUE).replace("${nameFile}", name),2000,1);
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}

	/**
	*<li> Case ID:122475.</li>
	*<li> Test Case Name: Comment on your activity.</li>
	*<li> Pre-Condition: - Space is created
	- Activity for space is added</li>
	*<li> Post-Condition: </li>
	*/
	/**
	*<li> Case ID:122478.</li>
	*<li> Test Case Name: Delete comment by owner.</li>
	*<li> Pre-Condition: Space is created</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_14_CommentOnYourActivity() {
		info("Test 13 Comment on your activity");
		String regist =spRegisData.getSpaceRegistration(0);
		String[] arrayRight ={regist};
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String urlSpace =baseUrl+"/g/:spaces:"+space.toLowerCase()+"/"+space.toLowerCase();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		Utils.pause(2000);
		hpAct.addActivity(true,name,false,"");
		Utils.pause(2000);
		info("change access to open");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("user 2 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		driver.get(urlSpace);
		Utils.pause(2000);
		click(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}",DATA_NAME_USER2),2000,1);
		/*Step Number: 1
		*Step Name: Step 1: Show comment form
		*Step Description: 
			- Click on Comment link under the activity
		*Input Data: 
			
		*Expected Outcome: 
			Show a text box allow user add comment for activity*/
		
		/*Step number: 2
		*Step Name: Step 2: Add a comment
		*Step Description: 
			- Enter some text into text box comment
			- Click on Comment button
		*Input Data: 
			
		*Expected Outcome: 
			Add a comment successfully. Other user can view activity and its comment. With each comment, some information is display:
			- Avatar of user comment
			- Name of user comment
			- Content of comment
			- Time comment is posted*/ 
		info("comment on space activity");
		hpAct.addComment(name, content);
		Utils.pause(2000);
		waitForAndGetElement(hpAct.ELEMENT_PUBLICATION_COMMENTPOSTED.replace("${content}", content),2000,1);
		waitForAndGetElement(hpAct.ELEMENT_PUBLICATION_COMMENT_NAMEAUTHOR.replace("${comment}", content).replace("${name}",DATA_NAME_USER2),2000,1);
		waitForAndGetElement(hpAct.ELEMENT_PUBLICATION_COMMENT_AVATAR.replace("${comment}", content).replace("${name}",DATA_NAME_USER2),2000,1);
		waitForAndGetElement(hpAct.ELEMENT_PUBLICATION_COMMENT_TIMESTAMP.replace("${comment}", content),2000,1);
		
		/*Step number: 3
		*Step Name: Step 3: Delete comment by owner
		*Step Description: 
			- Move mouse over the comment
			- Click (X) icon to remove
			- Click OK on confirmation form
		*Input Data: 
			
		*Expected Outcome: 
			Comment is removed*/ 
		info("remove comment");
		hpAct.deleteComment(name, content);
		waitForElementNotPresent(hpAct.ELEMENT_PUBLICATION_COMMENTPOSTED.replace("${content}", content),2000,1);
		
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}

	/**
	*<li> Case ID:122480.</li>
	*<li> Test Case Name: Delete comment by other member.</li>
	*<li> Pre-Condition: - Space is created
	- Space has some members: User1 and User2 (who are not space manager)
	- User1 comment on an activity which is not added by User2</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_DeleteCommentByOtherMember() {
		info("Test 15 Delete comment by other member");
		String regist =spRegisData.getSpaceRegistration(0);
		String[] arrayRight ={regist};
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String urlSpace =baseUrl+"/g/:spaces:"+space.toLowerCase()+"/"+space.toLowerCase();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		Utils.pause(2000);
		hpAct.addActivity(true,name,false,"");
		Utils.pause(2000);
		info("change access to open");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("user 2 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		Utils.pause(2000);
		driver.get(urlSpace);
		Utils.pause(2000);
		click(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}",DATA_NAME_USER2),2000,1);
		
		info("comment on space activity");
		hpAct.addComment(name, content);
		Utils.pause(2000);
		waitForAndGetElement(hpAct.ELEMENT_PUBLICATION_COMMENTPOSTED.replace("${content}", content),2000,1);
		/*Step Number: 1
		*Step Name: Step 1: Remove comment of other member
		*Step Description: 
			- Login as User2
			- Go to Space activity
			- Move mouse over the comment added by User1
		*Input Data: 
			
		*Expected Outcome: 
			- User2 cannot see (X) icon, so he cannot delete comment of other member*/ 
		info("user 3 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER3, DATA_PASS);
		driver.get(urlSpace);
		Utils.pause(2000);
		click(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN);
		
		info("user 3 cannot remove comment of user 2");
		mouseOver(hpAct.ELEMENT_PUBLICATION_LASTCOMMENT.replace("${title}", name), true);
		waitForElementNotPresent(hpAct.ELEMENT_PUBLICATION_DELETE_LASTCOMMENT.replace("${title}", content),2000,1);
		
		/*magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
 	}

	/**
	*<li> Case ID:122562.</li>
	*<li> Test Case Name: Add a share link.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	/**
	*<li> Case ID:122499.</li>
	*<li> Test Case Name: Delete activities by manager of space.</li>
	*<li> Pre-Condition: - Space is created
	- Space has some members
	- Some mebers have some activities on space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_16_AddAShareLink() {
		info("Test 17 Add a share link");
		String regist =spRegisData.getSpaceRegistration(0);
		String[] arrayRight ={regist};
		String textDes = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String link = lnkData.getLinkByArrayTypeRandom(1);
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String urlSpace =baseUrl+"/g/:spaces:"+space.toLowerCase()+"/"+space.toLowerCase();
		
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,space,60000);
		Utils.pause(2000);
		info("change access to open");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("user 2 joins space");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		driver.get(urlSpace);
		Utils.pause(2000);
		click(setSpaceMg.ELEMENT_SPACE_ACCESS_JOIN_BTN);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_USERJOIN_SPACE.replace("${user}",DATA_NAME_USER2),2000,1);
		
		/*Step Number: 1
		*Step Name: Step 1: Create new space
		*Step Description: 
			- Connect to Intranet
			- Click Join a Space button
			- Add new space
		*Input Data: 
			
		*Expected Outcome: 
			- New space is created successfully*/
		
		/*Step number: 2
		*Step Name: Step 2: Input a link
		*Step Description: 
			- Click on Add Link icon
			- Enter a valid URL
			- Click on Attach button on Share link form
		*Input Data: 
			
		*Expected Outcome: 
			Get information from link successfully. Some information are:
			- Link title
			- Link description
			- URL user has entered
			- If it gets image from link, there is a check box to allows display or not display image
			- Close icon*/
		
		/*Step number: 3
		*Step Name: Step 3: Share a link
		*Step Description: 
			- Enter chars into text box
			- Click on share button
		*Input Data: 
			
		*Expected Outcome: 
			A link is shared with some text on activity.*/ 
		info("user 2 add link");
		hpAct.addActivity(true, textDes, true, link);
		Utils.pause(2000);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_LINK.replace("${title}",textDes).replace("${link}",link),2000,1);
		
		info("Test 16 Delete activities by manager of space");
		/*Step Number: 1
		*Step Name: Step 1: Remove space activity of other space member by Manager
		*Step Description: 
			- Login as manager of space
			- Go to Space Activity stream
			- Move mouse over activity of other space member
			- Click on (X) icon
			- Click OK on confirmation form
		*Input Data: 
			
		*Expected Outcome: 
			- Activity of space member is removed by manager*/ 
		info("user 1 login");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		driver.get(urlSpace);
		Utils.pause(2000);
		info("user 1 remove activity of user 2");
		mouseOver((hpAct.ELEMENT_ACTIVITY_SPACE_AUTHOR).replace("${title}", textDes), true);
		click((hpAct.ELEMENT_ACTIVITY_USER_ACTIVITY_DELETE_BTN).replace("${title}", textDes));
		click(button.ELEMENT_OK_BUTTON);
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_LINK.replace("${title}",textDes).replace("${link}",link),2000,1);
		
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
 	}

	/**
	*<li> Case ID:122634.</li>
	*<li> Test Case Name: Not display activity for space if the space is hidden.</li>
	*<li> Pre-Condition: User activities for a public space is displayed</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_NotDisplayActivityForSpaceIfTheSpaceIsHidden() {
		info("Test 18 Not display activity for space if the space is hidden");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String visib = spVisiData.getSpaceVisible(1);
		String[] arrayRight ={visib};
		
		/*Step Number: 1
		*Step Name: Check activity create a hidden space
		*Step Description: 
			- Connect to Intranet
			- Click Join a Space button
			- Click Add new space
			- Input name and go to Access & Edit tab
			- Select Visibility is Hidden 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- New space is created
			- No activity is created*/ 
		info("Create a space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,space);
		
		info("Set permission for the space");
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToAccessEditTab();
		setSpaceMg.setPermissionForSpace(arrayRight);
		
		info("not display comment on activity stream");
		waitForElementNotPresent(hpAct.ELEMENT_ACTIVITY_SPACE_SPACE_LAST_COMMENT_JOINSPACE.replace("${space}", space));
 	
		/*info("Delete created space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		info("Space is deleted successfully");*/
	}
}