package org.exoplatform.selenium.platform.social.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class SOC_Space_Manage_Navigation extends SOC_TestConfig_1 {
	/**
	 *<li> Case ID:121898.</li>
	 *<li> Test Case Name: Add new node.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_AddNewNode() {
		info("Test 01: Add new node");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String node = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		 *Step Name: Step 1: Add new node
		 *Step Description: 
			- Access Space, select Setting tab/ Navigation tab
			    + Click on Add node, enter Node name and other information and click on save
		 *Input Data: 

		 *Expected Outcome: 
			- Node is added and is showed on navigation of space.
        */ 
		info("Create a space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,space);
		info("Open Setting tab");
		spaHome.goToSettingTab();
		setSpaceMg.goToNavigationTab();
		setSpaceMg.addANodeSimple(node);
		
		info("Test 03: Delete a node");
		setSpaceMg.deleteANode(node);
	}
	
	/**
	 *<li> Case ID:121913.</li>
	 *<li> Test Case Name:Edit a node.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test02_EditANode() {
		info("Test 02:Edit a node");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String node1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String node2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		 *Step Name: Step 1: Edit a node
		 *Step Description: 
			- User logs in system
			- Go to spaces page
			- Add new space
			- Access space and select Space settings portlet or Click on Space setting icon
			- Select Space navigation tab
			- Right click on node and select Edit this node
			- Change the value of node and click on save
		 *Input Data: 

		 *Expected Outcome: 
			- Node/Page's node is update with all changed value.
        */ 
		info("Create a space");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space,space);
		info("Open Setting tab");
		spaHome.goToSettingTab();
		setSpaceMg.goToNavigationTab();
		setSpaceMg.addANodeSimple(node1);
		info("Edit node 1");
		setSpaceMg.editANodeSimple(node1, node2);
		
		info("Delete a Space");
		hp.goToMySpaces();
		spaMg.deleteSpace(space,false);
		
	}

	
	
}