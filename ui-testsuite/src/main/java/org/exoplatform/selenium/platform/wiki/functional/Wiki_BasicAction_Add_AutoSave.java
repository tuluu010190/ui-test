package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.testng.annotations.*;


	public class Wiki_BasicAction_Add_AutoSave extends WIKI_TestConfig{

	/**
	*<li> Case ID:139436.</li>
	*<li> Test Case Name: Add a Draft to Wiki Intranet.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddADraftToWikiIntranet() {
		info("Test 1: Add a Draft to Wiki Intranet");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Login portal
			- Connect to [Intranet] 
			-
			-> [Wiki]
			- Click [Add page] 
			-
			-> [Blank Page]
			- Enter title and content for the Wiki page
		*Input Data: 
			
		*Expected Outcome: 
			- An empty template is displayed
			- The draft is created after 30sA message is displayed "Draft saved at HH:MM"*/ 
		info("Create a draf wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageHasAutoSaveWithoutSave(title, content);
 	}

	/**
	*<li> Case ID:139438.</li>
	*<li> Test Case Name: Autosave a page without Title.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_AutosaveAPageWithoutTitle() {
		info("Test 2: Autosave a page without Title");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Login portal
			- Connect to [Intranet] 
			-
			-> [Wiki]
			- Click [Add page] 
			-
			-> [Blank Page]/[From Template...]
			- Add a page wiki and keep the field "Title" empty
			- Keep the page without saving for 30s
		*Input Data: 
			
		*Expected Outcome: 
			- A draft is saved
			- A page is saved with a generic title within the format: "Untitled_YearMonthDayTime."*/ 
		info("Create a draf wiki page");
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageHasAutoSaveWithoutSave("", content);
		
		info("A page is saved with a generic title within the format: 'Untitled_YearMonthDayTime.''");
		String title ="Untitled_"+getCurrentDate("yyyyMMddHH");
		wHome.goToMyDraft();
		wDraf.verifyTitleDrafPage(title);

 	}

	/**
	*<li> Case ID:139549.</li>
	*<li> Test Case Name: Add a Draft to Wiki space.</li>
	*<li> Pre-Condition: create a space or join a space with an application wiki available</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_AddADraftToWikiSpace() {
		info("Test 3: Add a Draft to Wiki space");
		/*Step Number: 1
		*Step Name: Step 1: Select wiki of space
		*Step Description: 
			- Connect to a space and choose the [Wiki] tab on the space navigation bar
		*Input Data: 
			
		*Expected Outcome: 
			The wiki application is displayed*/
		
		info("Create a space");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space,space,6000);
		Utils.pause(2000);

		/*Step number: 2
		*Step Name: Step 2: Add wiki's page for space
		*Step Description: 
			- Choose [Add page] 
			-> [Blank Page]
			- Add Title
			- Add a content
		*Input Data: 
			
		*Expected Outcome: 
			- An empty template is displayed
			- The draft is created after 30sA message is displayed "Draft saved at HH:MM"*/ 
		info("Create a wiki page 1");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageHasAutoSaveWithoutSave(title, content);

 	}

	/**
	*<li> Case ID:139550.</li>
	*<li> Test Case Name: Resume a draft after loosing a session.</li>
	*<li> Pre-Condition: edit a page</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_ResumeADraftAfterLoosingASession() {
		info("Test 4: Resume a draft after loosing a session");
		/*Step Number: 1
		*Step Name: Step 1: Create wiki page
		*Step Description: 
			- Go to [Intranet] 
			-
			-> [Wiki]
			- Create/Edit a wiki page without saving for 30s
		*Input Data: 
			
		*Expected Outcome: 
			- A draft is created after 30s*/
		
		info("Create a draf wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageHasAutoSaveWithoutSave(title, content);

		/*Step number: 2
		*Step Name: Step 2: Session work expired
		*Step Description: 
			- Keep the session opened until time expiration
		*Input Data: 
			
		*Expected Outcome: 
			- The session is expired*/

		/*Step number: 3
		*Step Name: Step 3: Autosave a page as draft
		*Step Description: 
			- Re-connect to the session 
			- Go to "My draft"
		*Input Data: 
			
		*Expected Outcome: 
			- The draft is displayed in the list*/
		wHome.goToMyDraft();
		wDraf.verifyTitleDrafPage(title);

		/*Step number: 4
		*Step Name: Step 4: Check show draft page
		*Step Description: 
			- Click on the link "Title" of the draft
		*Input Data: 
			
		*Expected Outcome: 
			The page is displayed in edit mode and the last saved content is displayed*/
		wDraf.resumeADraft(title);
		wDraf.verifyResumADraf(title);

 	}}