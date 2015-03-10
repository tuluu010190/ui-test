package org.exoplatform.selenium.platform.gatein.sniff;

import java.util.Map;
import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @date March 11 2015
 * @author tult
 */

public class Gatein_Manage_Manage_Portal extends GateIn_TestConfig{
	
	/*@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
	}	*/
	
	/**
	 * Test case ID: 123059
	 * Test case name: Create new site
	 * Test case ID: 123061
	 * Test case name: Change using portal
	 * Test case ID: 123060
	 * Test case name: Delete portal
	 */
	@Test
	public void test01_02_03_Add_Change_DeletePortal(){
		String portalName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String editGroupId = portGroupPermisData.getContentByIndex(3);
		String editMembership = permissData.getDesByIndex(3);
		String language = langData.getLanguageByIndex(0);
		
		/*Step Number: 1
		 *Step Name: Step 1: Create new portal
		 *Step Description: 
			- Choose Administration/Portal/Sites/Add new portal
			- Input some fields required
			- Select Access/Edit permission
			- Click Save
		 *Input Data: 
		 *Expected Outcome: 
			- New portal is created successfully*/
		info("Test Case 01: Add new portal");
		Map<String, String> permissions = null;
		
		navToolBar.goToPotalSites();
		portSite.addNewPortal(portalName, null, null, language, null, "Always", true, permissions, editGroupId, editMembership);
		waitForAndGetElement(portSite.ELEMENT_NEW_PORTAL_ADD.replace("${portalName}", portalName));
		
		
		/*Step Number: 2
		 *Step Name: Step 2: Change using portal
		 *Step Description: 
			- Create new some portals
			- Switch between some portals by input directly name of portal on URL ( ex:  http://localhost:8080/portal/{name_of_portal}
		 *Input Data: 
		 *Expected Outcome: 
			- The switched portal is changed successfully*/
		info("Test Case 02: Switch to new portal");
		driver.get(baseUrl + "/" + portalName);
		waitForAndGetElement(portSite.ELEMENT_NEW_PORTAL_SWITCH.replace("${portalName}", portalName),3000,0);
		

		/*Step Number: 3
		 *Step Name: Step 3: Delete portal
		 *Step Description: 
			- Click Administration/Portal/Sites to view portal list
			- Select a portal form list 
			- Click Delete icon
		 *Input Data: 
		 *Expected Outcome: 
			- Deleted portal disappears from existing portals list*/
		info("Test Case 03: Delete portal");
		driver.get(baseUrl);
		navToolBar.goToPotalSites();
		portSite.deletePortal(portalName);
	}

}
