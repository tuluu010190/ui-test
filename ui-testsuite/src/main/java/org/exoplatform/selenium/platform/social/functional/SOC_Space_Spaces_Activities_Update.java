package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.testng.annotations.*;

	public class SOC_Space_Spaces_Activities_Update extends SOC_TestConfig3{

	
	/**
	*<li> Case ID:122437.</li>
	*<li> Test Case Name: Update Space activity after a user leave a space.</li>
	*<li> Pre-Condition: a user is member of a space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_UpdateSpaceActivityAfterAUserLeaveASpace() {
		info("Test 1:  Update Space activity after a user leave a space");
		
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
		info("Create 2 users for testing");
		createNewUser(2);
		
		info("User A login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(0), password);
		Utils.pause(3000);
		
		info("User A create a new space");
		String spaceName= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String spaceDes= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.goToCreateSpace();
		spaMg.addNewSpaceSimple(spaceName,spaceDes,6000);
		
		info("User A invites UserB to the space");
		hp.goToSpecificSpace(spaceName);
		spaHome.goToSpaceSettingTab();
		setSpaceMg.goToMemberTab();
		setSpaceMg.inviteUser(arrayUser.get(1),true,arrayUser.get(1));
		
		info("User B login");
		magAc.signOut();
		magAc.signIn(arrayUser.get(1), password);
		Utils.pause(3000);
		
		info("User B accept invitation from User A");
		hp.goToAllSpace();
		spaMg.goToInvitationsReceivedTab();
		spaMg.acceptAInvitation(spaceName);
		
		info("User B leaves the space");
		hp.goToMySpaces();
	    spaMg.searchSpace(spaceName, "");
	    spaMg.leaveSpace(spaceName);
		
		info("User B back to Home page");
		hp.goToHomePage();
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_SPACE_MEMBER_NUMBER.replace("${space}",spaceName).replace("${num}", "1"));
		
		info("last comment is still Join space");
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_SPACE_SPACE_LAST_COMMENT_JOINSPACE.replace("${space}", spaceName));
 	}
}