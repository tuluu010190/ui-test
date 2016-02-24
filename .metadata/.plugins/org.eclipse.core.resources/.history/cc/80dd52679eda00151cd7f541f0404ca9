package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.testng.annotations.*;


	public class Wiki_Page_Information_Version extends WIKI_TestConfig{

	/**
	*<li> Case ID:139297.</li>
	*<li> Test Case Name: View content of current version while view content of other version.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ViewContentOfCurrentVersionWhileViewContentOfOtherVersion() {
		info("Test 1: View content of current version while view content of other version");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");
		
		/*Step number: 2
		*Step Name: Step 2: Add version for page
		*Step Description: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: Step 3: Add more version for page
		*Step Description: 
			Do step 2
		*Input Data: 
			
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 4
		*Step Name: Step 4: Open form to view all version of page
		*Step Description: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Input Data: 
			
		*Expected Outcome: 
			All versions of page are shown*/
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: Step 5: View content of 1 version
		*Step Description: 
			- Click on the version link want to see
		*Input Data: 
			
		*Expected Outcome: 
			Content of selected version is shown*/
		info("View content of 1 version");
		wPageInfo.viewVersion(1);
		wValidate.verifyContentOfVersion(pageContent);

		/*Step number: 6
		*Step Name: Step 6: Back to current version
		*Step Description: 
			- Click on current version link
		*Input Data: 
			
		*Expected Outcome: 
			Show content of current version*/
		info("Back to current version");
		wPageInfo.viewCurrentVersion();
		info("Show content of current version");
		wValidate.verifyContentPage(newPageContent1);

 	}

	/**
	*<li> Case ID:139298.</li>
	*<li> Test Case Name: Compare version when do not select any version.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CompareVersionWhenDoNotSelectAnyVersion() {
		info("Test 2: Compare version when do not select any version");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: Step 2: Add version for page
		*Step Description: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: Step 3: Add more version for page
		*Step Description: 
			Do step 2
		*Input Data: 
			
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 4
		*Step Name: Step 4: Open form to view all version of page
		*Step Description: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Input Data: 
			
		*Expected Outcome: 
			All versions of page are shown*/
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: Step 5: Compare versions
		*Step Description: 
			- Do not select any checkbox
			- Click on Compare Selected
		*Input Data: 
			
		*Expected Outcome: 
			Button Compare Selected is disable, user can't click on it*/ 
		info("Compare versions");
		wPageInfo.goToPageHistory();
		info("Button Compare Selected is disable, user can't click on it");
		waitForAndGetElement(wHome.ELEMENT_COMPARE_VERISON_BTN_DISABLED);

 	}

	/**
	*<li> Case ID:139299.</li>
	*<li> Test Case Name: Compare version when select 2 versions.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CompareVersionWhenSelect2Versions() {
		info("Test 3: Compare version when select 2 versions");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");
		/*Step number: 2
		*Step Name: Step 2: Add version for page
		*Step Description: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: Step 3: Add more version for page
		*Step Description: 
			Do step 2
		*Input Data: 
			
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 4
		*Step Name: Step 4: Open form to view all version of page
		*Step Description: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Input Data: 
			
		*Expected Outcome: 
			All versions of page are shown*/
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: Step 5: Compare versions
		*Step Description: 
			- Tick on check
			-box of 2 versions
			- Click on Compare Selected
		*Input Data: 
			
		*Expected Outcome: 
			Content of 2 versions are compared*/ 
		info("Compare versions");
		wPageInfo.goToPageHistory();
	    wPageInfo.compareTwoReversion("v.1","v.2");
 	}

	/**
	*<li> Case ID:139300.</li>
	*<li> Test Case Name: Compare version when select only 1 version.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CompareVersionWhenSelectOnly1Version() {
		info("Test 4: Compare version when select only 1 version");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- New page is created successfully. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: Step 2: Add version for page
		*Step Description: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: Step 3: Add more version for page
		*Step Description: 
			Do step 2
		*Input Data: 
			
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 4
		*Step Name: Step 4: Open form to view all version of page
		*Step Description: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Input Data: 
			
		*Expected Outcome: 
			All versions of page are shown*/
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: Step 5: Compare versions
		*Step Description: 
			- Tick on check
			-box of 1 version
			- Click on Compare Selected
		*Input Data: 
			
		*Expected Outcome: 
			Button Compare Selected is disable, user can't click on it*/ 
		info("Compare versions");
		wPageInfo.goToPageHistory();
	    wPageInfo.compareTwoReversion("v.1","");
	    info("Button Compare Selected is disable, user can't click on it");
		waitForAndGetElement(wHome.ELEMENT_COMPARE_VERISON_BTN_DISABLED);
 	}

	/**
	*<li> Case ID:139304.</li>
	*<li> Test Case Name: Restore version to current version.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_RestoreVersionToCurrentVersion() {
		info("Test 5: Restore version to current version");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: Step 2: Add version for page
		*Step Description: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: Step 3: Add more version for page
		*Step Description: 
			Do step 2
		*Input Data: 
			
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");


		/*Step number: 4
		*Step Name: Step 4: Open form to view all version of page
		*Step Description: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Input Data: 
			
		*Expected Outcome: 
			All versions of page are shown*/
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: Step 5: Restore version to current version
		*Step Description: 
			Click Restore link corresponding with version want to be current version
		*Input Data: 
			
		*Expected Outcome: 
			Selected version become current version. New version is auto created.*/ 
		info("Compare versions");
		wPageInfo.goToPageHistory();
	    wPageInfo.restoreVersion("1");
	    info("Selected version become current version. New version is auto created");
		wValidate.verifyContentPage(pageContent);
		wValidate.verifyVersionPage("V4");

 	}

	/**
	*<li> Case ID:139305.</li>
	*<li> Test Case Name: View Change of page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_ViewChangeOfPage() {
		info("Test 6: View Change of page");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Using Firefox, login as root
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: Step 2: Default view change
		*Step Description: 
			- Select page above
			- Check link view change
		*Input Data: 
			
		*Expected Outcome: 
			View change link is not shown*/
		info("View change link is not shown");
		waitForElementNotPresent(wHome.ELEMENT_INFOR_BAR_VIEW_CHANGE_LINK);

		/*Step number: 3
		*Step Name: Step 3: Add version for page
		*Step Description: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 4
		*Step Name: Step 4: Add more version for page
		*Step Description: 
			Do step 3 again
		*Input Data: 
			
		*Expected Outcome: 
			The number of page's version is increase after each editEg: This page has 3 versions*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");
		/*Step number: 5
		*Step Name: Step 5: View change
		*Step Description: 
			- Click link View change
		*Input Data: 
			
		*Expected Outcome: 
			Display compare page between current version andthe before version*/
		info("View change");
		wHome.goToViewChange();
		wValidate.verifyCompareVersionPage(newPageContent, newPageContent1);

		/*Step number: 6
		*Step Name: Step 6: Change compare version
		*Step Description: 
			- Click link Changes from 1 to 2
		*Input Data: 
			
		*Expected Outcome: 
			Display compare page between version 1 and version 2*/
		info("Change compare version");
        wPageInfo.changeCompareVersions("1","2");
        waitForAndGetElement(wHome.ELEMENT_VIEW_CHANGE_VERSION.replace("${version}","Version 1"));
		waitForAndGetElement(wHome.ELEMENT_VIEW_CHANGE_VERSION.replace("${version}","Version 2"));
		
		/*Step number: 7
		*Step Name: Step 7:View page history
		*Step Description: 
			- Click link View Page History
		*Input Data: 
			
		*Expected Outcome: 
			- Display Page History with all version of page
			- User can compare and restore version*/ 
		info("View page history");
		wHome.goToAPage(newPage1);
		wHome.goToPageInformation();
		wPageInfo.goToPageHistory();
		wValidate.verifyVersionsInHistoryPage("v.1");
		wValidate.verifyVersionsInHistoryPage("v.2");
		wValidate.verifyVersionsInHistoryPage("v.3");

 	}

	/**
	*<li> Case ID:139306.</li>
	*<li> Test Case Name: View content of current version.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_ViewContentOfCurrentVersion() {
		info("Test 7: View content of current version");
		/*Step Number: 1
		*Step Name: Step 1: Create new page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: Step 2: Add version for page
		*Step Description: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: Step 3: Add more version for page
		*Step Description: 
			Do step 2
		*Input Data: 
			
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 4
		*Step Name: Step 4: Open form to view all version of page
		*Step Description: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Input Data: 
			
		*Expected Outcome: 
			All versions of page are shown*/
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: Step 5: View content of current version
		*Step Description: 
			- Click on current version link
		*Input Data: 
			
		*Expected Outcome: 
			Content of current version is shown*/ 
		info(" View content of current version");
		wPageInfo.viewVersion(3);
		wValidate.verifyContentPage(newPageContent1);

 	}

	/**
	*<li> Case ID:139307.</li>
	*<li> Test Case Name: View content of other version.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_ViewContentOfOtherVersion() {
		info("Test 8: View content of other version");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create new page
		*Input Data: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add version for page
		*Input Data: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Add more version for page
		*Input Data: 
			Do step 2
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Open form to view all version of page
		*Input Data: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Expected Outcome: 
			All versions of page are shown*/
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: -
		*Step Description: 
			Step 5: View content of other version
		*Input Data: 
			- Click on the version link want to see
		*Expected Outcome: 
			Content of selected version is shown*/ 
		info(" View content of current version");
		wPageInfo.viewVersion(2);
		wValidate.verifyContentOfVersion(newPageContent);

 	}

	/**
	*<li> Case ID:139308.</li>
	*<li> Test Case Name: View content of other version while viewing 1 version.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_ViewContentOfOtherVersionWhileViewing1Version() {
		info("Test 9: View content of other version while viewing 1 version");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create new page
		*Input Data: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add version for page
		*Input Data: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Add more version for page
		*Input Data: 
			Do step 2
		*Expected Outcome: 
			The number of page's version is increase after each edit*/
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Open form to view all version of page
		*Input Data: 
			- Open created page at step 1
			- Move mouse at the end of page
			- Click on Revisions link
		*Expected Outcome: 
			All versions of page are shown*/
		
		info("Open all version of the page");
		wHome.goToPageInformation();
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInPage(1);
		wValidate.verifyVersionsInPage(2);
		wValidate.verifyVersionsInPage(3);

		/*Step number: 5
		*Step Name: -
		*Step Description: 
			Step 5: View content of 1 version
		*Input Data: 
			- Click on the version link want to see
		*Expected Outcome: 
			Content of selected version is shown*/
		info(" View content of current version");
		wPageInfo.viewVersion(2);
		wValidate.verifyContentOfVersion(newPageContent);

		/*Step number: 6
		*Step Name: -
		*Step Description: 
			Step 6: View content of other version
		*Input Data: 
			- Click on Prev or Next link to view content of other versions
		*Expected Outcome: 
			Content of pre/next version is shown*/ 
		info("View content of other version");
		wPageInfo.viewConentVersionByNextArrow();
		wValidate.verifyContentOfVersion(newPageContent1);

 	}

	/**
	*<li> Case ID:139309.</li>
	*<li> Test Case Name: View Link of Revisions.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_ViewLinkOfRevisions() {
		info("Test 10 View Link of Revisions");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Create new page
		*Input Data: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add version for page
		*Input Data: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Click Link Revisions
		*Input Data: 
			- Click on Link revisions
		*Expected Outcome: 
			Corresponding information of all versions is displayed in table format*/ 
		info(" Click Link Revisions");
		wHome.goToRevisions("V2");
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInHistoryPage("v.1");
		wValidate.verifyVersionsInHistoryPage("v.2");
 	}

	/**
	*<li> Case ID:139310.</li>
	*<li> Test Case Name: View Link of Revisions when edit page content by another user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_ViewLinkOfRevisionsWhenEditPageContentByAnotherUser() {
		info("Test 11 View Link of Revisions when edit page content by another user");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			Step 1: Create new page
		*Input Data: 
			- Using Firefox, login as root
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successful. The number of page's version is 1.*/
		info("Create new page 1");
		String page = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,pageContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);
		
		info("Verify that the number of page's verison is 1");
		wValidate.verifyVersionPage("V1");

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add version for page
		*Input Data: 
			- Select page above
			- Click on Edit
			- Change values
			- Click Save
		*Expected Outcome: 
			Page is edited. The number of page's version is 2.*/
		info("Add version for page");
		String newPage = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage,newPageContent);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage);
		arrayPage.add(newPage);
		
		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Open another browser
		*Input Data: 
			- Using IE, login as john
			- Open page which has just created
		*Expected Outcome: 
			Page is displayed. The number of page's version is still 2.*/
		magAc.signOut();
		magAc.signIn(USER_ROOT,PASS_ROOT);
		Utils.pause(2000);
		
		hp.goToWiki();
		wHome.goToAPage(newPage);

		info("Verify that the number of page's verison is 2");
		wValidate.verifyVersionPage("V2");
		
		/*Step number: 4
		*Step Name: -
		*Step Description: 
			Step 4: Edit page content again
		*Input Data: 
			- At root page, click Edit again
			- Change values
			- Click Save
		*Expected Outcome: 
			Page is edited. The number of page's version is 3.*/
		
		info(" Add more version for page");
		String newPage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newPageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePage(newPage1,newPageContent1);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(newPage1);
		arrayPage.add(newPage1);
		
		info("Verify that the number of page's verison is 3");
		wValidate.verifyVersionPage("V3");

		/*Step number: 5
		*Step Name: -
		*Step Description: 
			Step 5: Click Link Revisions
		*Input Data: 
			- At john page, Click on Link revisions
		*Expected Outcome: 
			- The number of page's version is 3.
			- Corresponding information of all versions is displayed in table format with newest version*/ 
		info(" Click Link Revisions");
		wHome.goToRevisions("V3");
		info("Verify that all versions of page are shown");
		wValidate.verifyVersionsInHistoryPage("v.1");
		wValidate.verifyVersionsInHistoryPage("v.2");
		wValidate.verifyVersionsInHistoryPage("v.3");

 	}}