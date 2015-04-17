package org.exoplatform.selenium.platform.social.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class SOC_Space_List_Invitation extends SOC_TestConfig_1 {
	/**
	 *<li> Case ID:121892.</li>
	 *<li> Test Case Name: Check Invitation space list.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_CheckInvitaionSpaceList() {
		info("Test 01: Check Invitation space list");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		 *Step Name: Step 1: Check displaying on Invitations Received space list
		 *Step Description: 
			- Create new space
			- Send Invitation to user
			- Log in by invited user
			- Go to My space page and Invitations Received tab

		 *Input Data: 

		 *Expected Outcome: 
			- Show all invited space. User can accept/ignore the invitation
        */ 
		info("Create a space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,space);
		
		spaHome.goToSettingTab();
		setSpaceMg.inviteUser("mary");
		
		magAc.signOut();
		magAc.signIn(DATA_USER2,DATA_PASS);
		
		hp.goToMySpaces();
		spaMg.goToInvitationsReceivedTab();
		info("Verify that invitation is shown in the list with accept and ignore button");
		waitForAndGetElement(spaMg.ELEMENT_MY_SPACE_INVITATION_RECEIVED_ACCEPT_BTN.replace("${space}",space));
		waitForAndGetElement(spaMg.ELEMENT_MY_SPACE_INVITATION_RECEIVED_CANCEL_BTN.replace("${space}",space));
		
		magAc.signOut();
		magAc.signIn(DATA_USER1,DATA_PASS);
		
		info("Delete a Space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
	}
	
}