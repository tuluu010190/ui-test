package org.exoplatform.selenium.platform.plf.sniff;

import static org.exoplatform.selenium.TestLogger.info;


import org.testng.annotations.*;


	/**
	* @author eXo
	*
	*/
	public class Plf_Navigation_SpaceNavigation extends Plf_TestConfig{
		
	/**
	*<li> Case ID:120901.</li>
	*<li> Test Case Name: Show the space menu.</li>
	*<li> Pre-Condition: a space is created</li>
	*<li> Case ID:120902.</li>
	*<li> Test Case Name: Remove application of space's toolbar.</li>
	*/
	@Test
	public  void test01_ShowTheSpaceMenu(){
		info("Test 1: Show the space menu");
		String space1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		spaceMg.addNewSpace(space1, space1);
		
		/*Step Number: 1
		*Step Name: Show space applications
		*Step Description: 
			- Connect to Intranet
			- Open a Space
		*Input Data: 
			
		*Expected Outcome: 
			- The Horizontal toolbar is displayed
			- On the left of the Space toolbar, we display the icon and name of the current space.
			- All applications dedicated to the space are shown on space menu
			- Click on each applications, the application will show up in the main page*/ 
		info("Verify the expected outcome");
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_ACTIVITY_STREAM);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_AGENDA);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_WIKI);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_DOCUMENTS);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_SETTINGS);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_ANSWER);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_FORUMS);
		
		info("Delete the space");
		hp.goToMySpaces();
		spaceMg.deleteSpace(space1, false);
		
 	}
	
	@Test
	public  void test02_RemoveApplicationToolbar() {
		info("Test 02: Remove application of space's toolbar");
		String space1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		spaceMg.addNewSpace(space1, space1);
		
		/*Step number: 2
		*Step Name: Remove an application
		*Step Description: 
			- From space's settings, remove an application
		*Input Data: 
			
		*Expected Outcome: 
			- The application is removed from the space's toolbar*/ 
		spaceHome.goToSettings();
		spaceMg.deleteApplications("Answer");
		
		info("Verify the expected outcome");
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_ACTIVITY_STREAM);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_AGENDA);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_FORUMS);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_WIKI);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_DOCUMENTS);
		waitForAndGetElement(spaceHome.ELEMENT_SPACE_MENU_SETTINGS);
		waitForElementNotPresent(spaceHome.ELEMENT_SPACE_MENU_ANSWER);
		
		info("Delete the space");
		hp.goToMySpaces();
		spaceMg.deleteSpace(space1, false);
	}

}