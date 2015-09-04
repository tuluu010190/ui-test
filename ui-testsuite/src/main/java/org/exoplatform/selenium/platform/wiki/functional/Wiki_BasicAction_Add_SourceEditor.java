package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.WikiValidattions.effectTypes;
import org.testng.annotations.*;


	public class Wiki_BasicAction_Add_SourceEditor extends WIKI_TestConfig{

	/**
	*<li> Case ID:139406.</li>
	*<li> Test Case Name: Add new page has the same title with existing page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddNewPageHasTheSameTitleWithExistingPage() {
		info("Test 1: Add new page has the same title with existing page");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- The page is switched to the [Source Editor] mode*/
		

		/*Step number: 2
		*Step Name: Step 2: Create new page
		*Step Description: 
			- Put the title for this page has the same with existing pages
			- Put the content of page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Show message alert that the page title is existing*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Create a wiki page 2 with the same title");
		String mess = wikiWarningData.getDataContentByArrayTypeRandom(1);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		sourceEditor.addSimplePage(title, content);
		wikiMg.savePage();
		Utils.pause(2000);
		wValidate.verifyWarningMessage(mess);

 	}

	/**
	*<li> Case ID:139407.</li>
	*<li> Test Case Name: Add new page when content is blank.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_AddNewPageWhenContentIsBlank() {
		info("Test 2: Add new page when content is blank");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page
		*Step Description: 
			- Put the title for this page
			- Leave the content blank
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created successfully with blank content. It is displayed in the destination path*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title, "");
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Verify that the content of the page is empty");
		wValidate.verifyEmptyContentPage();
 	}

	/**
	*<li> Case ID:139408.</li>
	*<li> Test Case Name: Add new page when title is blank.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_AddNewPageWhenTitleIsBlank() {
		info("Test 3: Add new page when title is blank");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/
		
		/*Step number: 2
		*Step Name: Step 2: Create new page when click Cancel button
		*Step Description: 
			- Leave the title field is blank
			- Click [Cancel]
		*Input Data: 
			
		*Expected Outcome: 
			- New page is not created*/ 
		info("Create a wiki page");
		String title = "Untitled";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage("", "");
		wikiMg.cancelAddPage();
		Utils.pause(2000);
		
		info("New page is not created");
		wValidate.verifyNotTitleWikiPage(title);

		/*Step number: 3
		*Step Name: Step 3: Create new page when click confirm button
		*Step Description: 
			- Leave the title field blank
			- Click [Save ] 
			-
			-> [Confirm]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created with name is "Untitled page."*/
		
		info("Create a wiki page");
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage("","");
		wikiMg.savePage();
		Utils.pause(2000);
		
		info("click on Confirm button");
		wHome.confirmWaringMessage(true);
		info("New page is created with name is 'Untitled page.''");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139409.</li>
	*<li> Test Case Name: Add new page when user does not have add page permission on space.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_AddNewPageWhenUserDoesNotHaveAddPagePermissionOnSpace() {
		info("Test 4: Add new page when user does not have add page permission on space");
		/*Step Number: 1
		*Step Name: Step 1: Open form to add permission for space
		*Step Description: 
			- Go to Browse 
			-
			-> Space Permissions
		*Input Data: 
			
		*Expected Outcome: 
			Space Permissions form appears*/

		/*Step number: 2
		*Step Name: Step 2: Add permission for space
		*Step Description: 
			- Set permission for space that some user/group does not have permission to add page on this space
			- Click on Add icon
		*Input Data: 
			
		*Expected Outcome: 
			Space is added permission*/
		
		info("Create a new user");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);

		/*Step number: 3
		*Step Name: Step 3: Add new page
		*Step Description: 
			Login by user/group does not have permission to add page onspace
		*Input Data: 
			
		*Expected Outcome: 
			Can not see Add Page function*/
		info("Login by user/group does not have permission to add page onspace");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0),password);
		Utils.pause(3000);
		
		info("Can not see Add Page function");
		hp.goToWiki();
		wValidate.verifyNotShowAddPageBtn();
 	}

	/**
	*<li> Case ID:139410.</li>
	*<li> Test Case Name: Cancel create a new page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_CancelCreateANewPage() {
		info("Test 5: Cancel create a new page");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page
		*Step Description: 
			- Put the title for this page
			- Put the content of page
		*Input Data: 
			
		*Expected Outcome: 
			All fields are inputed with values*/

		/*Step number: 3
		*Step Name: Step 3: Cancel create a page
		*Step Description: 
			Click on Cancel
		*Input Data: 
			
		*Expected Outcome: 
			No page is created*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);
		Utils.pause(2000);
		info("No page is created");
		wValidate.verifyNotTitleWikiPage(title);

 	}

	/**
	*<li> Case ID:139414.</li>
	*<li> Test Case Name: Create new page using Blank Template.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_CreateNewPageUsingBlankTemplate() {
		info("Test 6: Create new page using Blank Template");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page
		*Step Description: 
			- Put the title for this page
			- Put the content of page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created successfully. It is displayed in the destination path*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139416.</li>
	*<li> Test Case Name: Create new page with Table effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_CreateNewPageWithTableEffect() {
		info("Test 7: Create new page with Table effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with Table tag
		*Step Description: 
			- Input |=Title 1|=Title 2|Word 1|Word 2
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The result is the table with 2 columms and 2 rows*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(1);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The result is the table with 2 columms and 2 rows");
		wValidate.verifyTableInContentPage(2,2);

 	}

	/**
	*<li> Case ID:139417.</li>
	*<li> Test Case Name: Create new page with Bold effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CreateNewPageWithBoldEffect() {
		info("Test 8: Create new page with Bold effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with Bold tag
		*Step Description: 
			- Input text inside ** ** character in contentFor example: **bold**
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with Bold effect*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(2).replace("$value",value);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with Bold effect");
		wValidate.verifyEffectsPageContent(effectTypes.Bold,value);

 	}

	/**
	*<li> Case ID:139418.</li>
	*<li> Test Case Name: Create new page with Bulleted list effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_CreateNewPageWithBulletedListEffect() {
		info("Test 9: Create new page with Bulleted list effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with Bold tag
		*Step Description: 
			- Input text inside start with * character in contentFor example: * item 1** item 2*** item 3* item 4
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The result is item 1 item 2 Item 3 item 4*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(3).replace("$value",value);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with Bullest list effect");
		wValidate.verifyEffectsPageContent(effectTypes.Bullest_List,value);

 	}

	/**
	*<li> Case ID:139419.</li>
	*<li> Test Case Name: Create new page with Heading effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_CreateNewPageWithHeadingEffect() {
		info("Test 10 Create new page with Heading effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with Heading 1 tag
		*Step Description: 
			- Input text inside == character in contentFor example: =Heading1=
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with Bold effect like Heading1 (large heading)*/

		/*Step number: 3
		*Step Name: Step 3: Create new page with Heading3 tag
		*Step Description: 
			- Input text inside == character in contentFor example: ===Heading3===
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with Bold effect like Heading3 (normal heading)*/

		/*Step number: 4
		*Step Name: Step 4: Create new page with Heading5 tag
		*Step Description: 
			- Input text inside == character in contentFor example: =====Heading5=====
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with Bold effect like Heading5 (small heading)*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentHeading1 = sourceTextEffect.getDataColTwoByArrayTypeRandom(4).replace("$value",value);
		String contentHeading3 = sourceTextEffect.getDataColTwoByArrayTypeRandom(5).replace("$value",value);
		String contentHeading5 = sourceTextEffect.getDataColTwoByArrayTypeRandom(6).replace("$value",value);
		String content=contentHeading1+"\n"+contentHeading3+"\n"+contentHeading5;
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with Heading 1 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading1,value);
		info("The page is shown with Heading 3 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading3,value);
		info("The page is shown with Heading 5 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading5,value);

 	}

	/**
	*<li> Case ID:139420.</li>
	*<li> Test Case Name: Create new page with italic effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_CreateNewPageWithItalicEffect() {
		info("Test 11 Create new page with italic effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with italic tag
		*Step Description: 
			- Input text inside // // character in contentFor example: //italic //
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with 'italic' effect*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(7).replace("$value",value);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with Italic effect");
		wValidate.verifyEffectsPageContent(effectTypes.Italic,value);

 	}

	/**
	*<li> Case ID:139421.</li>
	*<li> Test Case Name: Create new page with Link effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_CreateNewPageWithLinkEffect() {
		info("Test 12 Create new page with Link effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with Link tag
		*Step Description: 
			- Input text inside [[ ]] character For example: [[Wiki Home]]
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with 'link' effect like Wiki Home*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(8).replace("$value",value);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with link effect");
		wValidate.verifyEffectsPageContent(effectTypes.Link,value);

 	}

	/**
	*<li> Case ID:139422.</li>
	*<li> Test Case Name: Create new page with Numbered list effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_CreateNewPageWithNumberedListEffect() {
		info("Test 13 Create new page with Numbered list effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with Numbered list tag
		*Step Description: 
			- Input text start with numberFor example: 1. item 111. item 2111. item 31. item 4
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The result is 1. item 1 1. item 2 1. item 3 2. item 4*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(9).replace("$value",value);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with Number list effect");
		wValidate.verifyEffectsPageContent(effectTypes.Number_List,value);

 	}

	/**
	*<li> Case ID:139423.</li>
	*<li> Test Case Name: Create new page with strike effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_CreateNewPageWithStrikeEffect() {
		info("Test 14 Create new page with strike effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with strike tag
		*Step Description: 
			- Input text inside 
			-
			- 
			-
			- character in contentFor example: 
			-
			-strike
			-
			-
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with 'strike' effect like strikes*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(10).replace("$value",value);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with Strike effect");
		wValidate.verifyEffectsPageContent(effectTypes.Strike,value);

 	}

	/**
	*<li> Case ID:139424.</li>
	*<li> Test Case Name: Create new page with underline effect.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_CreateNewPageWithUnderlineEffect() {
		info("Test 15 Create new page with underline effect");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Create new page with underline tag
		*Step Description: 
			- Input text inside__ __character in contentFor example: __underline__
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The page is shown with 'underline' effect like underline*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = sourceTextEffect.getDataColTwoByArrayTypeRandom(11).replace("$value",value);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("The page is created successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		info("The page is shown with Underline effect");
		wValidate.verifyEffectsPageContent(effectTypes.Underline,value);

 	}

	/**
	*<li> Case ID:139511.</li>
	*<li> Test Case Name: Create a page wiki in a Space.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_CreateAPageWikiInASpace() {
		info("Test 16 Create a page wiki in a Space");
		/*Step Number: 1
		*Step Name: Step 1: Add new page for space
		*Step Description: 
			- Go to a space in [MY SPACES] list
			- Click [Wiki] on the space navigation bar
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
			- Fill valid values for fields
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- A wiki page is created successfully
			- At the top of the page,"Restricted" is displayed*/ 
		info("Create a space");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space,space,6000);
		Utils.pause(2000);

		info("Create a wiki page");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("Verify the version on infor bar");
		waitForAndGetElement(wHome.ELEMENT_INFOR_BAR_VERSION
				.replace("$version","V1"));

 	}}