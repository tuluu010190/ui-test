package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class SOC_Space_List_Pending extends SOC_TestConfig {
	/**
	 *<li> Case ID:121893.</li>
	 *<li> Test Case Name: Check Pending space list.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_CheckPendingSpaceList() {
		info("Test 01: Check Pending space list");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		 *Step Name: Step 1: Check displaying on Requests Pending list
		 *Step Description: 
			- Go to My space page and select All spaces tab
			- Send request to specific Space 
			- Click on Requests Pending tab
		 *Input Data: 

		 *Expected Outcome: 
			- Show all pending requests of this user
        */ 
		info("Create a space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,space);
		
		magAc.signOut();
		magAc.signIn(DATA_USER2,DATA_PASS);
		
		hp.goToMySpaces();
		spaMg.goToAllSpacesTab();
		spaMg.sendARequestToASpace(space);
		
		spaMg.goToRequestPendingTab();
		info("Verify that request to join button is hidden and request pending status is shown");
		waitForAndGetElement(spaMg.ELEMENT_MY_SPACE_ALL_SPACES_REQUEST_PENDING.replace("${space}", space),3000,0);
		
		
		magAc.signOut();
		magAc.signIn(DATA_USER1,DATA_PASS);
		
		info("Delete a Space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
	}
	
}