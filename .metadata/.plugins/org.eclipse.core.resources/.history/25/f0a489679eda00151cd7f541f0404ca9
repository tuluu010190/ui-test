package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.administration.ManageLayout.homePortletName;
import org.testng.annotations.*;


	public class Wiki_Basic_Action_Public_Page extends WIKI_TestConfig_3{

	/**
	*<li> Case ID:139611.</li>
	*<li> Test Case Name: Make a Wiki page in public mode.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_MakeAWikiPageInPublicMode() {
		info("Test 1: Make a Wiki page in public mode");
		/*Step Number: 1
		*Step Name: Step 1: Make public for Intranet site
		*Step Description: 
			- Connect to intranet as administrator
			- On homepage: From top navigation, click Edit
			->Site
			->Layout
			- Click Sites config
			->Permission tab
			->Access permission
			- Tick [Make it public]
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Site is public*/
		navTool.goToEditSiteLayout();
		mLayout.goToSiteConfigPopup();
		mLayout.goToSitePermissionTab();
		mLayout.publicMode();
		mLayout.saveChangesSiteConfig();

		/*Step number: 2
		*Step Name: Step 2: Make public for portlets in Intranet site
		*Step Description: 
			- Edit all portlets in this site with permission [Make it public] is ticked
			- Finish
		*Input Data: 
			
		*Expected Outcome: 
			- All portlets are public*/
		mLayout.publicModePortlet(homePortletName.Breadcrumbs);
        mLayout.publicModePortlet(homePortletName.Company);
        mLayout.publicModePortlet(homePortletName.Groups);
        mLayout.publicModePortlet(homePortletName.Space);
		mLayout.saveChangesSiteLayout();

		/*Step number: 3
		*Step Name: Step 3: Make public for a Wiki page
		*Step Description: 
			- Open Wiki application
			- Click Edit
			->Page
			->Layout
			- Click Page Properties
			->Permission tab
			->Access permission
			- Tick [Make it public]
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			*/
		hp.goToWiki();
		String wiki_url=driver.getCurrentUrl();
		navTool.goToEditLayout();
		mLayout.goToPagePropertiesPopup();
		mLayout.goToPagePermissionTab();
		mLayout.publicMode();
		mLayout.saveChangesPropertiesPopup();

		/*Step number: 4
		*Step Name: Step 4: Make public for all portlets in Wiki page
		*Step Description: 
			- Make public for both wiki portlet and container by setting Access permission is [Make it public]
			- Finish
		*Input Data: 
			
		*Expected Outcome: 
			- All portlets are public*/
		mLayout.publicModeWikiPortletContainer();
		mLayout.saveChangesContainerPopup();
		mLayout.saveChangesPageLayout();
		
		/*Step number: 5
		*Step Name: Step 5: Logout
		*Step Description: 
			- Log out
		*Input Data: 
			
		*Expected Outcome: 
			- Log out normally and no exception throws for this logout.
			- Wiki home is displayed*/ 
		magAc.signOut();
		driver.get(wiki_url);
		info("Verify that wiki home page is shown");
		waitForAndGetElement(wHome.ELEMENT_TITLE_WIKI_HOME_LINK);	

 	}}