package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


	public class SOC_Dashboard extends SOC_TestConfig{
		String space;
		
		@BeforeMethod
		public void setBeforeMethod(){
			space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
	        String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
	        hp.goToHomePage();
			hp.goToMySpaces();
			info("create new space");
			spaMg.addNewSpaceSimple(space,contentSpace);
		}
		@AfterMethod
		public void setAfterMethod(){
			info("Delete created space");
			hp.goToMySpaces();
			spaMg.deleteSpace(space,false);
		}
	/**
	*<li> Case ID:122281.</li>
	*<li> Test Case Name: Add new gadget into dashboard with valid value.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddNewGadgetIntoDashboardWithValidValue() {
		info("Test 1: Add new gadget into dashboard with valid value");
		int index = remoteGadData.getRandomIndexByType(1);
		String url = remoteGadData.newLinks.get(index);//"http://www.labpixies.com/campaigns/finance/finance.xml";
        String name = remoteGadData.newTitle.get(index);
    
		info("goto Space Setting>Application");
		spaHome.goToSettingTab();
		setSpaceMg.goToApplicationTab();
		info("add dashboard to space");
		setSpaceMg.addApplication("Tools","Dashboard");
		
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Login
		*Input Data: 
			Login by admin
		*Expected Outcome: 
			Portal is shown in private mode, pages for admin are shown*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Show Dashboard page
		*Input Data: 
			Choose Dashboard on UserToolbarDashboard portlet
		*Expected Outcome: 
			Dashboard page is displayed with all gadget default*/
		info("open dashboard");
		mouseOverAndClick(spaHome.ELEMENT_SPACE_MENU_MORE);
		click(spaHome.ELEMENT_SPACE_MENU_DASHBOARD);
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Show Open Dashboard workspace
		*Input Data: 
			Click Add Gadget link
		*Expected Outcome: 
			Dashboard workspace form is displayed with 2 main forms:
			- List all gadget in the left pane
			- The space is to contain and organize gadgets by drag & drop them into space*/
		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Add new gadget into dashboard
		*Input Data: 
			- In form: Input value valid in URL which want to add
			- Click Add Gadget
		*Expected Outcome: 
			- New gadget is added successfully into dashboard*/ 
		info("add gadget");
		myDash.addRemoteGadget(url, name);
		
 	}
}