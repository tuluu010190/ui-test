package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.wikiPageLinkTab;
import org.exoplatform.selenium.platform.wiki.SourceTextEditor;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.exoplatform.selenium.platform.wiki.WikiManagement;
import org.exoplatform.selenium.platform.wiki.WikiValidattions;
import org.exoplatform.selenium.platform.wiki.WikiValidattions.effectTypes;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


	public class Wiki_BasicAction_Edit extends WIKI_TestConfig{

	/**
	*<li> Case ID:139427.</li>
	*<li> Test Case Name: Edit page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_EditPage() {
		info("Test 1: Edit page");
		/*Step Number: 1
		*Step Name: Step 1: Create a page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put title, content
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			-New page is created successfully*/
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

		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- Select the page above
			- Click [Edit]
			- Change properties
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The [Edit Page] is shown in [Source Editor] mode
			- Page is edited*/ 
		info("Edit a wiki page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.goToSourceEditor();
		sourceEditor.editSimplePage(newTitle, newContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(newTitle);
		arrayPage.add(newTitle);

 	}

	/**
	*<li> Case ID:139428.</li>
	*<li> Test Case Name: Edit page when the title is the same with existing page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_EditPageWhenTheTitleIsTheSameWithExistingPage() {
		info("Test 2: Edit page when the title is the same with existing page");
		/*Step Number: 1
		*Step Name: Step 1: Create a page
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put title, content
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- New page is created successfully*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- Select page above
			- Click [Edit]
			- Change the title of this page that is the same with an existing page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The [Edit Page] is shown in [Source Editor] mode
             - Page is edited*/ 
		
		info("Edit a wiki page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		sourceEditor.editSimplePage(newTitle, newContent);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(newTitle);
		arrayPage.add(newTitle);

 	}

	/**
	*<li> Case ID:139444.</li>
	*<li> Test Case Name: Draft in an outdate version status.</li>
	*<li> Pre-Condition: Make changes on a page with two usersCreate a page</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_00_DraftInAnOutdateVersionStatus() {
		info("Test 3: Draft in an outdate version status");
		/*Step Number: 1
		*Step Name: Step 1: Edit an outdated version
		*Step Description: 
			- Connect with the User A
			- Add a page with name is Test
			- Add a content and save
		*Input Data: 
			
		*Expected Outcome: 
			The page is created*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(2,password);
		
		info("Add 2 users to Admin groups");
		String groupsPath=permisGroups.getDataColOneByArrayTypeRandom(5);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.selectGroup(groupsPath);
		userAndGroup.addUsersToGroup(arrayUsers.get(0),"*",false,true);
		userAndGroup.addUsersToGroup(arrayUsers.get(1),"*",false,true);
		
		info("Login with User A");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- Connect with the User B who have edit permission on "Test" page
			- Edit the page "Test" and add a content
		*Input Data: 
			
		*Expected Outcome: 
			A draft is saved after 30s*/
		info("Login with User B");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.goToSourceEditor();
		sourceEditor.editSimplePageWithAutoSave(newTitle, newContent);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);
		
		info("The draft is saved");
		wHome.goToMyDraft();
		wValidate.verifyTitleDrafPage(newTitle);

		/*Step number: 3
		*Step Name: Step 3: Edit page by User A
		*Step Description: 
			- Connect with the user "A" 
			- Edit the page "Test" and add a content
			- Save the page
		*Input Data: 
			
		*Expected Outcome: 
			A new version of the page is created*/
		info("Login with User A");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String newTitle1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.goToSourceEditor();
		sourceEditor.editSimplePage(newTitle1, newContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(newTitle1);
		arrayPage.add(newTitle1);
		
		info("A new version of the page is created");
		wikiMg.viewInformationTable(newTitle1,"V2");
		
		

		/*Step number: 4
		*Step Name: Step 4: Edit page by User B
		*Step Description: 
			- Connect with the User B: 
			- Open the page "Test" and click [Edit]
		*Input Data: 
			
		*Expected Outcome: 
			A page is opened in edit mode and a warning message is displayed:
			Your version is outdated, a version of this content has been updated 
			by another user. 
			You can [view your changes] and continue editing or [delete] your draft. "*/
		info("Login with User B");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String message = wikiWarningData.getDataContentByArrayTypeRandom(3);
		hp.goToWiki();
		wHome.goToAPage(newTitle1);
		wHome.goToEditPage();
		
	    info("A page is opened in edit mode and a warning message is displayed:");
	    info("Your version is outdated, a version of this content has been updated by another user. "
	    		+ "You can [view your changes] and continue editing or [delete] your draft.");
        wikiMg.verifyDraftInOutDateVersionStatus(message);
        
		/*Step number: 5
		*Step Name: Step 5: Check View your changes
		*Step Description: 
			From the message, click on the link [View your changes]
		*Input Data: 
			
		*Expected Outcome: 
			The Comparison view is open. 
			it's possible to click on continue editing or cancel the draft.*/
        info("The Comparison view is open");
        wikiMg.goToViewChangesLinkOnStatus();
        wValidate.verifyTitleDraftChangesPage();

 	}
	
	/**
	*<li> Case ID:139444.</li>
	*<li> Test Case Name: Draft in an outdate version status.</li>
	*<li> Pre-Condition: Make changes on a page with two usersCreate a page</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_01_DraftInAnOutdateVersionStatus() {
		info("Test 3: Draft in an outdate version status");
		/*Step Number: 1
		*Step Name: Step 1: Edit an outdated version
		*Step Description: 
			- Connect with the User A
			- Add a page with name is Test
			- Add a content and save
		*Input Data: 
			
		*Expected Outcome: 
			The page is created*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(2,password);
		
		info("Add 2 users to Admin groups");
		String groupsPath=permisGroups.getDataColOneByArrayTypeRandom(5);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.selectGroup(groupsPath);
		userAndGroup.addUsersToGroup(arrayUsers.get(0),"*",false,true);
		userAndGroup.addUsersToGroup(arrayUsers.get(1),"*",false,true);
		
		info("Login with User A");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- Connect with the User B who have edit permission on "Test" page
			- Edit the page "Test" and add a content
		*Input Data: 
			
		*Expected Outcome: 
			A draft is saved after 30s*/
		info("Login with User B");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.goToSourceEditor();
		sourceEditor.editSimplePageWithAutoSave(newTitle, newContent);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);
		
		info("The draft is saved");
		wHome.goToMyDraft();
		wValidate.verifyTitleDrafPage(newTitle);

		/*Step number: 3
		*Step Name: Step 3: Edit page by User A
		*Step Description: 
			- Connect with the user "A" 
			- Edit the page "Test" and add a content
			- Save the page
		*Input Data: 
			
		*Expected Outcome: 
			A new version of the page is created*/
		info("Login with User A");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String newTitle1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.goToSourceEditor();
		sourceEditor.editSimplePage(newTitle1, newContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(newTitle1);
		arrayPage.add(newTitle1);
		
		info("A new version of the page is created");
		wikiMg.viewInformationTable(newTitle1,"V2");

		/*Step number: 4
		*Step Name: Step 4: Edit page by User B
		*Step Description: 
			- Connect with the User B: 
			- Open the page "Test" and click [Edit]
		*Input Data: 
			
		*Expected Outcome: 
			A page is opened in edit mode and a warning message is displayed:
			Your version is outdated, a version of this content has been updated 
			by another user. 
			You can [view your changes] and continue editing or [delete] your draft. "*/
		info("Login with User B");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String message = wikiWarningData.getDataContentByArrayTypeRandom(3);
		hp.goToWiki();
		wHome.goToAPage(newTitle1);
		wHome.goToEditPage();
		
	    info("A page is opened in edit mode and a warning message is displayed:");
	    info("Your version is outdated, a version of this content has been updated by another user. "
	    		+ "You can [view your changes] and continue editing or [delete] your draft.");
        wikiMg.verifyDraftInOutDateVersionStatus(message);

		/*Step number: 6
		*Step Name: Step 6: Check continue editting
		*Step Description: 
			- Close the draft view
			- From the message, click on the link [Continue editing]
		*Input Data: 
			
		*Expected Outcome: 
			The page is opened in the editing status*/
        info("The page is opened in the editing status");
        wikiMg.goToContinueEdittingLinkOnStatus();
 	}
	
	
	/**
	*<li> Case ID:139444.</li>
	*<li> Test Case Name: Draft in an outdate version status.</li>
	*<li> Pre-Condition: Make changes on a page with two usersCreate a page</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_02_DraftInAnOutdateVersionStatus() {
		info("Test 3: Draft in an outdate version status");
		/*Step Number: 1
		*Step Name: Step 1: Edit an outdated version
		*Step Description: 
			- Connect with the User A
			- Add a page with name is Test
			- Add a content and save
		*Input Data: 
			
		*Expected Outcome: 
			The page is created*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(2,password);
		
		info("Add 2 users to Admin groups");
		String groupsPath=permisGroups.getDataColOneByArrayTypeRandom(5);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.selectGroup(groupsPath);
		userAndGroup.addUsersToGroup(arrayUsers.get(0),"*",false,true);
		userAndGroup.addUsersToGroup(arrayUsers.get(1),"*",false,true);
		
		info("Login with User A");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- Connect with the User B who have edit permission on "Test" page
			- Edit the page "Test" and add a content
		*Input Data: 
			
		*Expected Outcome: 
			A draft is saved after 30s*/
		info("Login with User B");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.goToSourceEditor();
		sourceEditor.editSimplePageWithAutoSave(newTitle, newContent);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);
		
		info("The draft is saved");
		wHome.goToMyDraft();
		wValidate.verifyTitleDrafPage(newTitle);

		/*Step number: 3
		*Step Name: Step 3: Edit page by User A
		*Step Description: 
			- Connect with the user "A" 
			- Edit the page "Test" and add a content
			- Save the page
		*Input Data: 
			
		*Expected Outcome: 
			A new version of the page is created*/
		info("Login with User A");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String newTitle1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.goToSourceEditor();
	    sourceEditor.editSimplePage(newTitle1, newContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(newTitle1);
		arrayPage.add(newTitle1);
		
		info("A new version of the page is created");
		wikiMg.viewInformationTable(newTitle1,"V2");

		/*Step number: 4
		*Step Name: Step 4: Edit page by User B
		*Step Description: 
			- Connect with the User B: 
			- Open the page "Test" and click [Edit]
		*Input Data: 
			
		*Expected Outcome: 
			A page is opened in edit mode and a warning message is displayed:
			Your version is outdated, a version of this content has been updated 
			by another user. 
			You can [view your changes] and continue editing or [delete] your draft. "*/
		info("Login with User B");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String message = wikiWarningData.getDataContentByArrayTypeRandom(3);
		hp.goToWiki();
		wHome.goToAPage(newTitle1);
		wHome.goToEditPage();
		
	    info("A page is opened in edit mode and a warning message is displayed:");
	    info("Your version is outdated, a version of this content has been updated by another user. "
	    		+ "You can [view your changes] and continue editing or [delete] your draft.");
        wikiMg.verifyDraftInOutDateVersionStatus(message);

		/*Step number: 7
		*Step Name: Step 7: Check delete draft
		*Step Description: 
			- re
			-open the page and click [Edit]
			- From the message, click on the link [delete]
		*Input Data: 
			
		*Expected Outcome: 
			The draft is deleted from the list" My drafts"*/ 
        wikiMg.goToDeleteLinkOnStatus();
        info("The draft is deleted from the list of draft");
		wHome.goToMyDraft();
		wValidate.verifyNotTitleDrafPage(newTitle1);
		wValidate.verifyNotTitleDrafPage(title);

 	}

	/**
	*<li> Case ID:139445.</li>
	*<li> Test Case Name: Edit a page with an existing draft.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_02_EditAPageWithAnExistingDraft() {
		info("Test 4: Edit a page with an existing draft");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Add a wiki page and save
			- Edit the page
			- Input a content
		*Input Data: 
			
		*Expected Outcome: 
			The draft is saved after 30s*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePageWithAutoSaveStatus(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Edit the page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		richEditor.editSimplePageWithAutoSave(newTitle, newContent);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);
		
		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- From the "Wiki Home", Open again the page
			- Edit the page
		*Input Data: 
			
		*Expected Outcome: 
			A warning message is displayed under the title:
			 "A draft of this page was saved on Month Day, Year HH:MM. 
			 You can view your changes and decide to resume the draft or delete it.*/
		info("Edit the page again");
		String message = wikiWarningData.getDataContentByArrayTypeRandom(4);
		wHome.goToAPage(title);
		wHome.goToEditPage();
		
		info("A warning message is displayed under the title:");
	    info("A draft of this page was saved on Month Day, Year HH:MM. "
	    		+ "You can view your changes and decide to resume the draft or delete it.");
	    String currentDate = getCurrentDate("M/d/yyyy");
	    wikiMg.verifyStatusWhenEditPageHasExistingDraf(message, currentDate);

		/*Step number: 5
		*Step Name: Step 5: Delete draft
		*Step Description: 
			- Repeat the step 3
			- Click on the link [Delete]
		*Input Data: 
			
		*Expected Outcome: 
			The draft is deleted.*/
	    wikiMg.goToDeleteLinkOnStatus();
		wHome.goToMyDraft();
		wValidate.verifyNotTitleDrafPage(title);

		/*Step number: 6
		*Step Name: Step 6: Check after delete draft
		*Step Description: 
			Click open again the page and click edit
		*Input Data: 
			
		*Expected Outcome: 
			The warning message isn't displayed*/ 
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		info("The warning message isn't displayed");
		waitForElementNotPresent(wikiMg.ELEMETN_WIKI_STATUS_VERSION_TEXT
				.replace("$status",message)
				.replace("$date",currentDate));
 	}

	/**
	*<li> Case ID:139445.</li>
	*<li> Test Case Name: Edit a page with an existing draft.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_00_EditAPageWithAnExistingDraft() {
		info("Test 4: Edit a page with an existing draft");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Add a wiki page and save
			- Edit the page
			- Input a content
		*Input Data: 
			
		*Expected Outcome: 
			The draft is saved after 30s*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePageWithAutoSaveStatus(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Edit the page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		richEditor.editSimplePageWithAutoSave(newTitle, newContent);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);

		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- From the "Wiki Home", Open again the page
			- Edit the page
		*Input Data: 
			
		*Expected Outcome: 
			A warning message is displayed under the title:
			 "A draft of this page was saved on Month Day, Year HH:MM. 
			 You can view your changes and decide to resume the draft or delete it.*/
		info("Edit the page again");
		String message = wikiWarningData.getDataContentByArrayTypeRandom(4);
		wHome.goToAPage(title);
		wHome.goToEditPage();
		
		info("A warning message is displayed under the title:");
	    info("A draft of this page was saved on Month Day, Year HH:MM. "
	    		+ "You can view your changes and decide to resume the draft or delete it.");
	    String currentDate = getCurrentDate("M/d/yyyy");
	    wikiMg.verifyStatusWhenEditPageHasExistingDraf(message, currentDate);

		/*Step number: 3
		*Step Name: Step 3: Check view changes
		*Step Description: 
			From the message click on the link [View your changes]
		*Input Data: 
			
		*Expected Outcome: 
			The page "Draft changes" is displayed*/
	    info("The page 'Draft changes' is displayed");
	    wikiMg.goToViewChangesLinkOnStatus();


 	}

	/**
	*<li> Case ID:139445.</li>
	*<li> Test Case Name: Edit a page with an existing draft.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_01_EditAPageWithAnExistingDraft() {
		info("Test 4: Edit a page with an existing draft");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Add a wiki page and save
			- Edit the page
			- Input a content
		*Input Data: 
			
		*Expected Outcome: 
			The draft is saved after 30s*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePageWithAutoSaveStatus(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Edit the page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		richEditor.editSimplePageWithAutoSave(newTitle, newContent);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);

		/*Step number: 2
		*Step Name: Step 2: Edit page
		*Step Description: 
			- From the "Wiki Home", Open again the page
			- Edit the page
		*Input Data: 
			
		*Expected Outcome: 
			A warning message is displayed under the title:
			 "A draft of this page was saved on Month Day, Year HH:MM. 
			 You can view your changes and decide to resume the draft or delete it.*/
		info("Edit the page again");
		String message = wikiWarningData.getDataContentByArrayTypeRandom(4);
		wHome.goToAPage(title);
		wHome.goToEditPage();
		
		info("A warning message is displayed under the title:");
	    info("A draft of this page was saved on Month Day, Year HH:MM. "
	    		+ "You can view your changes and decide to resume the draft or delete it.");
	    String currentDate = getCurrentDate("M/d/yyyy");
	    wikiMg.verifyStatusWhenEditPageHasExistingDraf(message, currentDate);

		/*Step number: 4
		*Step Name: Step 4: Resume draft
		*Step Description: 
			- Close the page "Draft changes"
			- Click on the link [resume the draft]
		*Input Data: 
			
		*Expected Outcome: 
			The page is displayed in the edit mode.*/
	    wikiMg.goToResumDrafLinkOnStatus();
	    wValidate.verifyResumADraf(newTitle);

 	}

	/**
	*<li> Case ID:139449.</li>
	*<li> Test Case Name: Resume a draft after Browser crash.</li>
	*<li> Pre-Condition: Add/Edit a page</li>
	*<li> Post-Condition: </li>
	 * @throws Exception 
	*/
	@Test
	public  void test05_ResumeADraftAfterBrowserCrash() throws Exception {
		info("Test 5: Resume a draft after Browser crash");
		/*Step Number: 1
		*Step Name: Step 1: Edit page
		*Step Description: 
			Edit a wiki page and add a content
		*Input Data: 
			
		*Expected Outcome: 
			The draft is added after 30s*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Edit the page");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePageWithAutoSave(title1, content1);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);

		/*Step number: 2
		*Step Name: Step 2: Autosave page after Browser crash
		*Step Description: 
			Force stop the Browser process from the task manager
		*Input Data: 
			
		*Expected Outcome: 
			The Browser is stopped*/
		info("The Browser is stopped");
		driver.quit();
		setUpBeforeMethod();

		/*Step number: 3
		*Step Name: Step 3: Page saved as draft
		*Step Description: 
			Open the page againGo to "My drafts"
		*Input Data: 
			
		*Expected Outcome: 
			The draft version appears in the list*/ 
		info("The draft version appears in the list");
        hp.goToWiki();
        wHome.goToMyDraft();
        wValidate.verifyTitleDrafPage(title1);
 	}

	/**
	*<li> Case ID:139450.</li>
	*<li> Test Case Name: Resume a draft after close without saving.</li>
	*<li> Pre-Condition: edit a page</li>
	*<li> Post-Condition: </li>
	 * @throws Exception 
	*/
	@Test
	public  void test06_ResumeADraftAfterCloseWithoutSaving() throws Exception {
		info("Test 6: Resume a draft after close without saving");
		/*Step Number: 1
		*Step Name: Step 1: Edit a page
		*Step Description: 
			- Go to Intranet/Wiki
			- Add a page
			- Edit the page
		*Input Data: 
			
		*Expected Outcome: 
			A draft version is saved after 30s*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Edit the page");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		richEditor.editSimplePageWithAutoSave(title1, content1);
		wikiMg.cancelAddPage();
		wHome.confirmWaringMessage(true);

		/*Step number: 2
		*Step Name: Step 2: Close a window without saving
		*Step Description: 
			Close a window of the browser without saving 
			of the pageOpen the window of the age againGo to [My drafts]
		*Input Data: 
			
		*Expected Outcome: 
			The draft is displayed in the list*/
		info("The Browser is closed");
		driver.close();
		setUpBeforeMethod();
		
		info("The draft version appears in the list");
        hp.goToWiki();
        wHome.goToMyDraft();
        wValidate.verifyTitleDrafPage(title1);
		
		/*Step number: 3
		*Step Name: Step 3: Autosave of the page
		*Step Description: 
			Click on the link "title" of the draft
		*Input Data: 
			
		*Expected Outcome: 
			The page in edit mode is displayed*/
        info("The page in edit mode is displayed");
        wDraf.resumeADraft(title1);
        wValidate.verifyResumADraf(title1);

 	}

	/**
	*<li> Case ID:139451.</li>
	*<li> Test Case Name: Save a draft of currently saved page.</li>
	*<li> Pre-Condition: connect with 2 users and edit the same page</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_SaveADraftOfCurrentlySavedPage() {
		info("Test 7: Save a draft of currently saved page");
		/*Step Number: 1
		*Step Name: Step 1: Edit a page with User1
		*Step Description: 
			- Connect with the User1
			- Edit a page wiki and add a content
		*Input Data: 
			
		*Expected Outcome: 
			The draft is saved after 30s*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(2,password);
		
		info("Add 2 users to Admin groups");
		String groupsPath=permisGroups.getDataColOneByArrayTypeRandom(5);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.selectGroup(groupsPath);
		userAndGroup.addUsersToGroup(arrayUsers.get(0),"*",false,true);
		userAndGroup.addUsersToGroup(arrayUsers.get(1),"*",false,true);
		
		info("Login with User A");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
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
		
		info("Edit the page");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToEditPage();
		sourceEditor.editSimplePageWithAutoSave(title1, content1);

		/*Step number: 2
		*Step Name: Step 2: Edit a page with User2
		*Step Description: 
			- Connect with user2
			- Open the same page edited by the user 1
			- Click on the icon "Edit"
		*Input Data: 
			
		*Expected Outcome: 
			A warning message is displayed: 
			This Page is currently being edited by FulluserName".*/ 
		info("Login with User B");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		hp.goToWiki();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		
		info("A warning message is displayed:");
		info("This Page is currently being edited by FulluserName");
		String fullName = arrayUsers.get(0)+" "+arrayUsers.get(0);
		String status = wikiWarningData.getDataContentByArrayTypeRandom(5);
		wValidate.verifyMessageWhenEditingSamePage(status, fullName);
		wHome.confirmWaringMessage(true);
 	}

	/**
	*<li> Case ID:139533.</li>
	*<li> Test Case Name: Edit attached file.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_EditAttachedFile() {
		info("Test 8: Edit attached file");
		/*Step Number: 1
		*Step Name: Step 1: Open attach file link form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page isin [Rich Text]editor
			- Select attached file link in content
			- Click [Link] in menu and select [Edit Link]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Attached File form appear*/
		

		/*Step number: 2
		*Step Name: Step 2: Change attached file
		*Step Description: 
			- Choose other attached file
			- Click [Select]
			- Input tooltip for file
			- Click [Create Link] button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Attached file is changed successfully in content of page
			- Page is add/edited successfully*/
		info("Create a wiki page");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachedFile = attFileData.getAttachFileByArrayTypeRandom(1);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,"");
		richEditor.insertAttachedFileLink("TestData/"+attachedFile,true);
		wValidate.verifyInsertedLinkIntoFrame(attachedFile,"");
		richEditor.editAttachedFileLink(attachedFile,"", tooltip);
		wValidate.verifyInsertedLinkIntoFrame("", tooltip);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
		
		/*Step number: 3
		*Step Name: Step 3: View attach file
		*Step Description: 
			- Click on name of attached file
		*Input Data: 
			
		*Expected Outcome: 
			Content of attach file is shown*/ 
		info("The file is attached in the page");
		wHome.goToAPage(title1);
	    wikiMg.viewInsertLink(attachedFile);

 	}

	/**
	*<li> Case ID:139534.</li>
	*<li> Test Case Name: Add web page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_AddWebPage() {
		info("Test 9: Add web page");
		/*Step Number: 1
		*Step Name: Step 1: Edit a web page
		*Step Description: 
			- Select a page that has web page link
			- Ensure the page isin [Rich Text] editor
			- Choose a web page link
			- Click Link in menu
			- Choose [Edit link]
			- Type orther address of the web page to create the link to. (ex: www.google.com)
			- Input label and tooltip
			- Check or uncheck [Open in new window]
			- Click [Create Link]
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Web page link is changed succesfully*/ 
		info("Create a wiki page 1");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String address = "www.google.com";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToWebPageLink();
		richEditor.insertWebLink(address, label,"",true);
		wValidate.verifyInsertedLinkIntoFrame(label,"");
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Edit the page");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		richEditor.editSimplePage(title1,"");
		richEditor.changeLink(label);
		richEditor.goToEditLink();
		richEditor.insertWebLink(address,label1,"",true);
        wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
 	}

	/**
	*<li> Case ID:139535.</li>
	*<li> Test Case Name: Edit wiki page link.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_EditWikiPageLink() {
		info("Test 10 Edit wiki page link");
		/*Step Number: 1
		*Step Name: Step 1: Open attach file link form
		*Step Description: 
			- Add new page or edit a page that has a wiki page link
			- Ensure the page isin [Rich Text] editor
			- Select an attached file link in content
			-Click [Link] in menu and select [Edit Link]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Attached File form appear*/
		
		info("Create a wiki page 1");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1, content1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
		
		info("Create a wiki page 2");
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title2, content2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);
		
		info("Create a wiki page 3");
		String title3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title3,"");
		richEditor.goToWikiPageLink();
		richEditor.insertExistWikiPageLink(title1,label,tooltip,wikiPageLinkTab.All_pages);
		wValidate.verifyInsertedLinkIntoFrame(label, tooltip);
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title3);
		arrayPage.add(title3);

		/*Step number: 2
		*Step Name: Step 2: Change wiki page link
		*Step Description: 
			- Choose other page link 
			- Click [Select]
			- Input tooltip for file
			- Click [Create Link] button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			The attached wiki page link is changed successfully in content of page
			- Page is add/edited successfully*/
		
		info("Edit the page");
		String title4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title3);
		wHome.goToEditPage();
		richEditor.editSimplePage(title4,"");
		richEditor.changeLink(label);
		richEditor.goToEditLink();
		richEditor.insertExistWikiPageLink(title2, label4, tooltip4,wikiPageLinkTab.All_pages);
        wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title4);
		arrayPage.add(title4);

		/*Step number: 3
		*Step Name: Step 3: View the wiki page link
		*Step Description: 
			- Click on name wiki page link
		*Input Data: 
			
		*Expected Outcome: 
			Content of wiki page link is shown*/ 
		info("Content of wiki page link is shown");
		wHome.goToAPage(title4);
		wikiMg.viewInsertLink(label4);
		wValidate.verifyPageContent(title2,content2);

 	}

	/**
	*<li> Case ID:139536.</li>
	*<li> Test Case Name: Edit email address.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_EditEmailAddress() {
		info("Test 11 Edit email address");
		/*Step Number: 1
		*Step Name: Step 1: Open Email address form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page isin [Rich Text] editor
			- Select email address link in content
			-Click [Link] in menu and select [Edit Link]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Attached File form appear*/
		
		info("Create a wiki page with email address");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label =txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String address=getRandomString()+"@gmail.com";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,"");
		richEditor.insertEmailLink(address, label, tooltip,true);
		wValidate.verifyInsertedLinkIntoFrame(label, tooltip);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);

		/*Step number: 2
		*Step Name: Step 2: Change attached file
		*Step Description: 
			- Change email address
			- Click [Select]
			- Input tooltip
			- Click [Create Link] button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Add attach file is changed successfully in content of page
			- Page is add/edited successfully*/
		info("Edit the page with change email address");
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String address2=getRandomString()+"@gmail.com";
		wHome.goToAPage(title1);
		wHome.goToEditPage();
		richEditor.editSimplePage(title2,"");
		richEditor.changeLink(label);
		richEditor.goToEditLink();
		richEditor.insertEmailLink(address2, label2,"",true);
        wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);

		/*Step number: 3
		*Step Name: Step 3: View the email address
		*Step Description: 
			- Click the email address
		*Input Data: 
			
		*Expected Outcome: 
			- The Launch Application is shown that allows selecting an email app to be redirected to the email*/ 
		info("Click on email link to verify that the link is avaiable");
		wHome.goToAPage(title2);
		wikiMg.viewInsertLink(label2);
 	}

	/**
	*<li> Case ID:139537.</li>
	*<li> Test Case Name: Edit image.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_EditImage() {
		info("Test 12 Edit image");
		/*Step Number: 1
		*Step Name: Step 1: Open upload image form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page is in [Rich Text]editor
			- Choose image in page 
			-Click [Image] in menu and select [Edit Image...]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Attached File form appear*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachedFile = attFileData.getAttachFileByArrayTypeRandom(28);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToAttachedImageLink();
		richEditor.insertImage("TestData/"+attachedFile, "200","200","");
		richEditor.goToInsertImage();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 2
		*Step Name: Step 2: Edit Attach image
		*Step Description: 
			- Select an image to insert from the list below, by clicking it or upload new image
			- Click Image Settings
			- Type the width/height of the image
			- Choose the way the image is positioned in the text
			- Choose the way the image is vertically aligned in the line of text
			- Click Insert Image button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The attached file is added successfully in content of page
			- Page is add/edited successfully*/ 
		info("Edit the page with change image");
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachedFile2 = attFileData.getAttachFileByArrayTypeRandom(26);
		String altText2=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String width2="200";
		String height2="200";
		wHome.goToAPage(title);
		wHome.goToEditPage();
		richEditor.editSimplePage(title2,"");
		richEditor.selectImage(attachedFile);
		richEditor.goToEditImageLink();
		richEditor.insertImage("TestData/"+attachedFile2, width2, height2, altText2);
		richEditor.goToInsertImage();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
        wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);
		
		info("Add attach file is added successfully in content of page");
		wHome.goToAPage(title2);
	    wikiMg.verifyAltTextImageInContentPage(altText2);
		

 	}

	/**
	*<li> Case ID:139606.</li>
	*<li> Test Case Name: Check show message if there are 2 users editing in the same page..</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_CheckShowMessageIfThereAre2UsersEditingInTheSamePage() {
		info("Test 13 Check show message if there are 2 users editing in the same page.");
		/*Step Number: 1
		*Step Name: Step 1: Add new page on browser 1
		*Step Description: 
			- Login as user 1
			- Go to Wiki
			- Create a new page 
			- Input content
			- Save page
		*Input Data: 
			
		*Expected Outcome: 
			Add new page successfully*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(2,password);
		
		info("Add 2 users to Admin groups");
		String groupsPath=permisGroups.getDataColOneByArrayTypeRandom(5);
		navTool.goToUsersAndGroupsManagement();
		userAndGroup.goToGroupTab();
		userAndGroup.selectGroup(groupsPath);
		userAndGroup.addUsersToGroup(arrayUsers.get(0),"*",false,true);
		userAndGroup.addUsersToGroup(arrayUsers.get(1),"*",false,true);
		
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 2
		*Step Name: Step 2: Edit page at step 1
		*Step Description: 
			- Click [Edit] button of that page
			- Edit title & content
			- Wait 30s for auto 
			->save draft
		*Input Data: 
			
		*Expected Outcome: 
			Page is save to my draft*/
		info("Edit a wiki page");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		sourceEditor.editSimplePageWithAutoSave(newTitle, newContent);

		/*Step number: 3
		*Step Name: Step 3: Edit page at step 1 by other user on browser 2
		*Step Description: 
			- Login as user 2
			- Go to Wiki
			- Click on the page user 1 has been created before
			- Click [Edit] button of that page
			- Change title or content for this page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Show message alert "This page is currently being edited by"user 1"."
			- Edit successfully*/
		info("Login with user 2 on browser 2");
		newDriver = new FirefoxDriver();
		newDriver.get(baseUrl);
		newDriver.manage().window().maximize();
		ManageLogInOut  acc2 = new ManageLogInOut(newDriver);
		WikiHomePage wHome2 = new WikiHomePage(newDriver);
		WikiManagement wikiMg2 = new WikiManagement(newDriver);
		SourceTextEditor sourceEditor2=new SourceTextEditor(newDriver);
		WikiValidattions wValidate2 = new WikiValidattions(newDriver);
		HomePagePlatform hp2 = new HomePagePlatform(newDriver);
		acc2.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Edit the page");
		String newTitle2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp2.goToWiki();
		wHome2.goToAPage(title);
		wHome2.goToEditPage();
		wikiMg2.goToSourceEditor();
		sourceEditor2.editSimplePage(newTitle2, newContent2);
		info("Show message alert: This page is currently being edited by user 1");
		String fullName = arrayUsers.get(0)+" "+arrayUsers.get(0);
		String status = wikiWarningData.getDataContentByArrayTypeRandom(5);
		wValidate2.verifyMessageWhenEditingSamePage(status, fullName);
        wikiMg2.cancelAddPage();
        wHome2.confirmWaringMessage(true);
        newDriver.close();        
		/*Step number: 4
		*Step Name: Step 4: Edit page at step 1 by user 1
		*Step Description: 
			- Back to browser 1 and click Save button
		*Input Data: 
			
		*Expected Outcome: 
			- Page is edited successfully and have no exception in console*/
        wikiMg.savePage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(newTitle);
		arrayPage.add(newTitle);
 	}

	/**
	*<li> Case ID:139607.</li>
	*<li> Test Case Name: Edit Paragraph When The Level Of Header Is Equal To Paragraph Below.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_EditParagraphWhenTheLevelOfHeaderIsEqualToParagraphBelow() {
		info("Test 14 Edit Paragraph When The Level Of Header Is Equal To Paragraph Below");
		/*Step Number: 1
		*Step Name: Create New Wiki Page with 2 paragraphs with the same header
		*Step Description: 
			- Go to [Wiki]
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put title.
			- Put content with 2 paragraphs with the same header (ex:= paragraph1 == paragraph2 =)
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- New page with 2 paragraphs with the same header is created successfully*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentHeading1 = sourceTextEffect.getDataColTwoByArrayTypeRandom(4).replace("$value",value1);
		String contentHeading2 = sourceTextEffect.getDataColTwoByArrayTypeRandom(5).replace("$value",value2);
		String contentHeading3 = sourceTextEffect.getDataColTwoByArrayTypeRandom(4).replace("$value",value3);
		String content=contentHeading1+"\n"+contentHeading3;
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
		wValidate.verifyEffectsPageContent(effectTypes.Heading1,value1);
		info("The page is shown with Heading 1 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading1,value3);
		
		/*Step number: 2
		*Step Name: Edit paragraph 1
		*Step Description: 
			- Click to Wiki page added in step 1
			- Click to edit button for paragraph 1 (This button is a hidden button, only appear when hover in paragraph)
			- Change Title of paragraph 1
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki page is in Edit screen, but only paragraph 1 appears in edit content.
			- Paragraph 1 is edited title successfully. There is no change for paragraph 2.*/ 
		info("Edit paragraph");
		wikiMg.editParagraph(value1,contentHeading2);
		wikiMg.saveAddPage();
		info("The page is shown with Heading 3 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading3,value2);

 	}

	/**
	*<li> Case ID:139608.</li>
	*<li> Test Case Name: Edit Paragraph When The Level Of Header Greater Than Paragraph Below.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_EditParagraphWhenTheLevelOfHeaderGreaterThanParagraphBelow() {
		info("Test 15 Edit Paragraph When The Level Of Header Greater Than Paragraph Below");
		/*Step Number: 1
		*Step Name: Create New Wiki Page with 2 paragraphs:+ Paragraph 1 with heading 1+ Paragraph 2 with heading 2
		*Step Description: 
			- Go to [Wiki]
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put title.
			- Put content with 2 paragraphs+ Paragraph 1 with heading 1+ Paragraph 2 with heading 2r (ex= paragraph1 === paragraph2 ==)
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- New page with 2 paragraphs is created successfully with:+ Paragraph 1 with heading 1+ Paragraph 2 with heading 2*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentHeading1 = sourceTextEffect.getDataColTwoByArrayTypeRandom(4).replace("$value",value1);
		String contentHeading2 = sourceTextEffect.getDataColTwoByArrayTypeRandom(12).replace("$value",value2);
		String content=contentHeading1+"\n"+contentHeading2;
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
		wValidate.verifyEffectsPageContent(effectTypes.Heading1,value1);
		info("The page is shown with Heading 2 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading2,value2);
		
		/*Step number: 2
		*Step Name: Edit paragraph 2
		*Step Description: 
			- Click to Wiki page added in step 1
			- Click to edit button for paragraph 2 (This button is a hidden button, only appear when hover in paragraph)
			- Change Title of paragraph 2
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki page is in Edit screen, but only paragraph 2 appears in edit content.
			- Paragraph 2 is edited title successfully. There is no change for paragraph 1.*/ 
		info("Edit paragraph");
		String value3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentHeading3 = sourceTextEffect.getDataColTwoByArrayTypeRandom(5).replace("$value",value3);
		wikiMg.editParagraph(value2,contentHeading3);
		wikiMg.saveAddPage();
		info("The page is shown with Heading 3 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading3,value3);

 	}}