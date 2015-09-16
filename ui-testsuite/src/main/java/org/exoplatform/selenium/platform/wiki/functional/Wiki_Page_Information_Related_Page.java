package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.WikiPermission.permissionType;
import org.testng.annotations.*;


	public class Wiki_Page_Information_Related_Page extends WIKI_TestConfig{

	/**
	*<li> Case ID:139294.</li>
	*<li> Test Case Name: Add related page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddRelatedPage() {
		info("Test 1: Add related page");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New pages are created successfully*/
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
		
		
		info("Create new page 2");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		arrayPage.add(page1);

		/*Step number: 2
		*Step Name: Step 2: Open form to see page's information
		*Step Description: 
			- Select 1 page
			- Select More 
			-> Page Info
		*Input Data: 
			
		*Expected Outcome: 
			All page's information are listed: Summary, Related page, Hierarchy, Recent Changes*/
		info("Open form to see page's information");
		wHome.goToPageInformation();
		wValidate.verifyTablesPageInformation();

		/*Step number: 3
		*Step Name: Step 3: Add related page
		*Step Description: 
			- Click on Add more relation button
			- Select 1 page
			- Click on Select button
		*Input Data: 
			
		*Expected Outcome: 
			Related page is added and listed*/ 
		info("Add related page");
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page);
		wValidate.verifyRelatedPage("portal",page);
		

 	}

	/**
	*<li> Case ID:139295.</li>
	*<li> Test Case Name: Add related page when user does not have permission to edit this page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_AddRelatedPageWhenUserDoesNotHavePermissionToEditThisPage() {
		info("Test 2: Add related page when user does not have permission to edit this page");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New pages are created successful. E.g: Test1 and Test2*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
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
		
		/*Step number: 2
		*Step Name: Step 2: Set permission for page
		*Step Description: 
			- Select page: Test1 
			- Set permission for this page so that some user cannot edit this page
		*Input Data: 
			
		*Expected Outcome: 
			Page is added permission*/
		
		
		/*Step number: 3
		*Step Name: Step 3: Open form to see page's information
		*Step Description: 
			- Login by user can not edit page above (Test1)
			- Select page Test1
			- Select More 
			-
			-> Page Info
		*Input Data: 
			
		*Expected Outcome: 
			All page's information are listed: Summary, Related page, Hierarchy, Recent Changes*/

		info("Login with user 1");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Open form to see page's information");
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToPageInformation();
		wValidate.verifyTablesPageInformation();

		/*Step number: 4
		*Step Name: Step 4: Add related page
		*Step Description: 
			Click on Add more relation button
		*Input Data: 
			
		*Expected Outcome: 
			User can't see Add more relation button*/ 
		info("Add related page");
		waitForElementNotPresent(wHome.ELEMENT_PAGE_INFO_ADD_MORE_RELATIONS);
 	}

	/**
	*<li> Case ID:139296.</li>
	*<li> Test Case Name: Add related page when user does not have permission to view selected page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_AddRelatedPageWhenUserDoesNotHavePermissionToViewSelectedPage() {
		info("Test 3: Add related page when user does not have permission to view selected page");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New pages are created successfully. E.g: Test1 and Test2*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
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
		
		info("Set permission for page");
		wHome.goToPermissions();
		wPermission.addPermisisonByType(arrayUsers.get(0));
		wPermission.selectPermission(arrayUsers.get(0),permissionType.Edit_Pages);
		wPermission.savePermisison();
		
		
		info("Create new page 2");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		arrayPage.add(page1);


		/*Step number: 2
		*Step Name: Step 2: Set permission for page
		*Step Description: 
			- Select page: Test2
			- Set permission for this page so that some user cannot view this page
		*Input Data: 
			
		*Expected Outcome: 
			Page is added permission*/
		info("Set permission for page");
		wHome.goToPermissions();
		wPermission.deletePermission("any");
		wPermission.savePermisison();

		/*Step number: 3
		*Step Name: Step 3: Open form to see page's information
		*Step Description: 
			- Login by user can not view page above (Test2)
			- Select page Test1
			- Select More 
			-
			-> Page Info
		*Input Data: 
			
		*Expected Outcome: 
			All page's information are listed: Summary, Related page, Hierarchy, Recent Changes*/
		info("Login with user 1");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Open form to see page's information");
		hp.goToWiki();
		wHome.goToAPage(page);
		wHome.goToPageInformation();
		wValidate.verifyTablesPageInformation();

		/*Step number: 4
		*Step Name: Step 4: Add related page
		*Step Description: 
			- Click on Add more relation button
		*Input Data: 
			
		*Expected Outcome: 
			Can not see page Test2 on the list to select*/ 
		wPageInfo.goToAddRelations();
		wValidate.verifyNotPageInRelatedPageList(page1);

 	}

	/**
	*<li> Case ID:139301.</li>
	*<li> Test Case Name: Delete page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_DeletePage() {
		info("Test 4: Delete page");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- New pages are created successfully*/
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
		
		
		info("Create new page 2");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		arrayPage.add(page1);


		/*Step number: 2
		*Step Name: Step 2: Add related page
		*Step Description: 
			- Select 1 page 
			- Add more related page
		*Input Data: 
			
		*Expected Outcome: 
			Page is added relations*/
		info("Open form to see page's information");
		wHome.goToPageInformation();
		wValidate.verifyTablesPageInformation();

		/*Step number: 3
		*Step Name: Step 3: Delete related page
		*Step Description: 
			- Click Remove corresponding with the related page want to delete
			- Click OK on confirm message
		*Input Data: 
			
		*Expected Outcome: 
			Related page is deleted*/ 
		info("Add related page");
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page);
		wValidate.verifyRelatedPage("portal",page);
		info("Delete related page");
		wPageInfo.deleteRelation(page);

 	}

	/**
	*<li> Case ID:139302.</li>
	*<li> Test Case Name: Delete related page when cancel confirm message.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_DeleteRelatedPageWhenCancelConfirmMessage() {
		info("Test 5: Delete related page when cancel confirm message");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New pages are created successfully*/
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
		
		
		info("Create new page 2");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		arrayPage.add(page1);


		/*Step number: 2
		*Step Name: Step 2: Add related page
		*Step Description: 
			- Select 1 page 
			- Add more related page
		*Input Data: 
			
		*Expected Outcome: 
			Page is added relations*/
		info("Open form to see page's information");
		wHome.goToPageInformation();
		wValidate.verifyTablesPageInformation();


		/*Step number: 3
		*Step Name: Step 3: Delete related page
		*Step Description: 
			- Click Remove corresponding with the related page want to delete
			- Click Cancel on confirm message
		*Input Data: 
			
		*Expected Outcome: 
			Related page is not deleted*/ 
		info("Add related page");
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page);
		wValidate.verifyRelatedPage("portal",page);
		info("Delete related page");
		wPageInfo.deleteRelationWithCancelDeleting(page);

 	}

	/**
	*<li> Case ID:139303.</li>
	*<li> Test Case Name: Delete related page when user does not have permission to edit page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_DeleteRelatedPageWhenUserDoesNotHavePermissionToEditPage() {
		info("Test 6: Delete related page when user does not have permission to edit page");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New pages are created successful*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
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
		
		
		info("Create new page 2");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		arrayPage.add(page1);


		/*Step number: 2
		*Step Name: Step 2: Add related page
		*Step Description: 
			- Select 1 page 
			- Add more related page
		*Input Data: 
			
		*Expected Outcome: 
			Page is added relations*/
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page);
		wValidate.verifyRelatedPage("portal",page);

		/*Step number: 3
		*Step Name: Step 3: Delete related page
		*Step Description: 
			- Login by user does not have permission to edit page at step 1
			- Click Remove corresponding with the related page want to delete
		*Input Data: 
			
		*Expected Outcome: 
			There is no remove link to click*/ 
		info("Login with user 1");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("There is no remove link to click");
		hp.goToWiki();
		wHome.goToAPage(page1);
		wHome.goToPageInformation();
		waitForElementNotPresent(wHome.ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN
				.replace("${name}",page));

 	}

	/**
	*<li> Case ID:139311.</li>
	*<li> Test Case Name: View related page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_ViewRelatedPage() {
		info("Test 7: View related page");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/
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
		
		
		info("Create new page 2");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		arrayPage.add(page1);
		

		/*Step number: 2
		*Step Name: Step 2: Add related page
		*Step Description: 
			- Select 1 page 
			- Add more related page
		*Input Data: 
			
		*Expected Outcome: 
			Page is added relations*/
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page);
		wValidate.verifyRelatedPage("portal",page);
		
		/*Step number: 3
		*Step Name: Step 3: View content of related page
		*Step Description: 
			- Click on one of related page
		*Input Data: 
			
		*Expected Outcome: 
			Content of related page is shown*/ 
         info("View content of related page");
         wPageInfo.viewRelatedPageContent(page);
 	}

	/**
	*<li> Case ID:139312.</li>
	*<li> Test Case Name: View related page when user does not have permission to view.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_ViewRelatedPageWhenUserDoesNotHavePermissionToView() {
		info("Test 8: View related page when user does not have permission to view");
		/*Step Number: 1
		*Step Name: Step 1: Create new pages
		*Step Description: 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Add values in required fields
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New pages are created successful*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(1,password);
		
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
		
		
		info("Create new page 2");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		arrayPage.add(page1);
		
		info("Set permission for page");
		wHome.goToPermissions();
		wPermission.deletePermission("any");
		wPermission.savePermisison();

		/*Step number: 2
		*Step Name: Step 2: Add related page
		*Step Description: 
			- Select 1 page 
			- Add more related page
		*Input Data: 
			
		*Expected Outcome: 
			Page is added relations*/
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page);
		wValidate.verifyRelatedPage("portal",page);

		/*Step number: 3
		*Step Name: Step 3: View content of related page
		*Step Description: 
			- Click on one of related page that user does not have permission to view
		*Input Data: 
			
		*Expected Outcome: 
			User can't see this related page*/ 
		info("Login with user 1");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("There is no remove link to click");
		hp.goToWiki();
		wValidate.verifyNotTitleWikiPage(page1);
		wValidate.verifyNotPageInLeftRelatePageList(page1);

 	}

	/**
	*<li> Case ID:139313.</li>
	*<li> Test Case Name: Renaming a page from another space should correctly be updated in Page Info Layout of a related page.</li>
	*<li> Pre-Condition: User is member of Space 1, Space 2, Space 3
	*Wiki of "Space 1" has following pages:
	- Page 1
	- Page 2
	Wiki of "Space 2" has following pages:
	- Page A
	- Page B
	Wiki of "Space 3" has following pages:
	- Page a
	- Page b
	"Page 1 " of "Space 1" wiki has relations with:
	-- "Page A" from "Space 2"
	-- "Page a" from "Space 3"</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_RenamingAPageFromAnotherSpaceShouldCorrectlyBeUpdatedInPageInfoLayoutOfARelatedPage() {
		info("Test 9: Renaming a page from another space should correctly be updated in Page Info Layout of a related page");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Page A" of "Space 2" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki is displaying "Page A"*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create a space 2");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create new page A");
		String pageA = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContentA= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageContentA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations(space1,page1);
		wValidate.verifyRelatedPage(space1,page1);
		
		
		info("Create a space 3");
		String space3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space3,space3,6000);
		Utils.pause(2000);
		
		info("Create new page a");
		String page_a = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent_a= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page_a,pageContent_a);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page_a);
		
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations(space1,page1);
		wValidate.verifyRelatedPage(space1,page1);
		
		info("Open Space 2 and Page A");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wHome.goToAPage(page1);
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Rename "Page A" to "Page A renamed"
		*Input Data: 
			
		*Expected Outcome: 
			- Title of the wiki page is now "Page A renamed"*/
		info("Rename page A");
		String page1Renamed = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wikiMg.renamePageByDoubleClick(page1, page1Renamed);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to "Page 1 " of "Space 1" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki is displaying "Page 1"*/
		info("Open Space 2 and Page A");
		hp.goToSpecificSpace(space2);
		spaMg.goToWikiTab();
		wHome.goToAPage(pageA);

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page infos of Page 1 are diplayed*/
		info("Open Page Information");
		wHome.goToPageInformation();

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Check updates in Related pages
		*Input Data: 
			
		*Expected Outcome: 
			- Title of "Page A" has been correctly renamed "Page A renamed"*/ 
		info("Space1:"+space1);
		info("page1:"+page1);
		info("page1Renamed:"+page1Renamed);
		wValidate.verifyRelatedPage(space1,page1Renamed);
		wValidate.verifyNotPageInRelatedPageList(page1);
		wValidate.verifyPageInLeftRelatePageList(page1Renamed);

 	}

	/**
	*<li> Case ID:139314.</li>
	*<li> Test Case Name: Renaming a Space should be correctly updated in Page Info Layout of a related page.</li>
	*<li> Pre-Condition: User is member of Space 1, Space 2, Space 3
	*Wiki of "Space 1" has following pages:
	- Page 1
	- Page 2
	Wiki of "Space 2" has following pages:
	- Page A
	- Page B
	Wiki of "Space 3" has following pages:
	- Page a
	- Page b
	"Page 1 " of "Space 1" wiki has relations with:
	-- "Page A" from "Space 2"
	-- "Page a" from "Space 3"</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_RenamingASpaceShouldBeCorrectlyUpdatedInPageInfoLayoutOfARelatedPage() {
		info("Test 10 Renaming a Space should be correctly updated in Page Info Layout of a related page");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space 3"
		*Input Data: 
			
		*Expected Outcome: 
			- Activity stream of "Space 3" is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create a space 2");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create new page A");
		String pageA = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContentA= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageContentA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations(space1,page1);
		wValidate.verifyRelatedPage(space1,page1);
		
		
		info("Create a space 3");
		String space3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space3,space3,6000);
		Utils.pause(2000);
		
		info("Create new page a");
		String page_a = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent_a= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page_a,pageContent_a);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page_a);
		
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations(space1,page1);
		wValidate.verifyRelatedPage(space1,page1);

		info("Open Space 2 and Page A");
		hp.goToSpecificSpace(space1);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Go to "Space Management"
			- Renamed "Space 3" to "Space 3 renamed"
		*Input Data: 
			
		*Expected Outcome: 
			- Space has been renamed to "Space 3 renamed"*/
		info("Rename space 1");
		String space1Rename = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaHome.goToSpaceSettingTab();
		spSettingMg.updateInfoSpace(space1Rename,space1Rename);
		spSettingMg.saveInfoSpace();
		wHome.confirmWaringMessage(true);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Go to "Page 1 " of "Space 1" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki is displaying "Page 1"*/
		info("Open page a  of space3");
		hp.goToSpecificSpace(space3);
		spaHome.goToWikiTab();
		wHome.goToAPage(page_a);

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page infos of Page 1 are diplayed*/
		info("Open Page Information");
		wHome.goToPageInformation();

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Check updates in Related pages
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki of "Page a" is "Space 3 renamed"*/ 
		wValidate.verifyRelatedPage(space1Rename,page1);
 	}

	/**
	*<li> Case ID:139315.</li>
	*<li> Test Case Name: Add 2 relations from 2 different spaces.</li>
	*<li> Pre-Condition: User is member of Space 1, Space 2, Space 3
	*Wiki of "Space 1" has following pages:
	- Page 1
	- Page 2
	Wiki of "Space 2" has following pages:
	- Page A
	- Page B
	Wiki of "Space 3" has following pages:
	- Page a
	- Page b</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_Add2RelationsFrom2DifferentSpaces() {
		info("Test 11 Add 2 relations from 2 different spaces");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space 1" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki of "Space 1" is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create a space 2");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create new page A");
		String pageA = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContentA= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageContentA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		
		info("Create new page B");
		String pageB = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContentB= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageContentB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		
		info("Create a space 3");
		String space3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space3,space3,6000);
		Utils.pause(2000);
		
		info("Create new page a");
		String page_a = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent_a= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page_a,pageContent_a);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page_a);
		
		
		info("Create new page b");
		String page_b = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent_b= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page_b,pageContent_b);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page_b);
		
		info("Open space 1");
		hp.goToSpecificSpace(space1);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "Page 1"
		*Input Data: 
			
		*Expected Outcome: 
			- Page 1 is displayed in the wiki*/
		info("Open page 1");
		spaHome.goToWikiTab();
		wHome.goToAPage(page1);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page infos of Page 1 are diplayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- On "Related Page Layout" click on button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Open Space switcher component
		*Input Data: 
			
		*Expected Outcome: 
			- The list of space swticher options is displayed*/

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Select "Space 2"
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki tree of "Space 2" is displayed on the container below the space switcher*/

		/*Step number: 7
		*Step Name: 
		*Step Description: 
			- Select "Page A"
			- Click on "Select" button
		*Input Data: 
			
		*Expected Outcome: 
			- Popup is closed
			- "Page A" is added as a related pages on page info layout*/
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations(space2,pageA);
		wValidate.verifyRelatedPage(space2,pageA);

		/*Step number: 8
		*Step Name: 
		*Step Description: 
			- On "Related Page Layout" click on button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 9
		*Step Name: 
		*Step Description: 
			- Open Space switcher component
		*Input Data: 
			
		*Expected Outcome: 
			- The list of space swticher options is displayed*/

		/*Step number: 10
		*Step Name: 
		*Step Description: 
			- Select "Space 3"
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki tree of "Space 3" is displayed on the container below the space switcher*/

		/*Step number: 11
		*Step Name: 
		*Step Description: 
			- Select "Page a"
			- Click on "Select" button
		*Input Data: 
			
		*Expected Outcome: 
			- Popup is closed
			- "Page a" is added as a related pages on page info layout
			- "Page A" is still displayed as a related pages on page info layout*/ 
		info("Add related page");
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations(space3,page_a);
		wValidate.verifyRelatedPage(space3,page_a);
		wValidate.verifyRelatedPage(space2,pageA);

 	}

	/**
	*<li> Case ID:139316.</li>
	*<li> Test Case Name: Add related popup must display the currently browsed space by default.</li>
	*<li> Pre-Condition: User is member of Space 2
	*Space 2 wiki has following pages:
	- Page 1
	- Page 2
	--- Sub-Page 1</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_AddRelatedPopupMustDisplayTheCurrentlyBrowsedSpaceByDefault() {
		info("Test 12 Add related popup must display the currently browsed space by default");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go into "Space 2" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- "Space 2 " wiki is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create new sub page 2");
		String subpage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subpageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(page2);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subpage1,subpageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subpage1);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page Info of "Wiki Home" page are displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- On the part dedicated to related page, click on the button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- Popup to select a page is displayed
			- Label "Select the space:" with the space switcher are displayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Check space switcher component
		*Input Data: 
			
		*Expected Outcome: 
			- Space switcher component is displaying "Space 2"*/ 
		info("Add related page");
		wHome.goToHomeWikiPage();
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		waitForAndGetElement(wHome.ELEMENT_ADD_RELATED_POPUP_DROPDOWN_VALUE.replace("$space",space1));

 	}

	/**
	*<li> Case ID:139317.</li>
	*<li> Test Case Name: Add relation to a page from another space.</li>
	*<li> Pre-Condition: User is member of Space 1 and Space 2Wiki of "Space 1" has following pages:
	- Page 1
	- Page 2
	Wiki of "Space 2" has following pages:
	- Page A
	- Page B</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_AddRelationToAPageFromAnotherSpace() {
		info("Test 13 Add relation to a page from another space");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space 1" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki of "Space 1" is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create a space 2");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create new page A");
		String pageA = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContentA= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageContentA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		
		info("Create new page B");
		String pageB = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContentB= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageContentB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		

		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "Page 1"
		*Input Data: 
			
		*Expected Outcome: 
			- Page 1 is displayed in the wiki*/
		info("Open page 1 of space 1");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAPage(page1);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page infos of Page 1 are diplayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- On "Related Page Layout" click on button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Open Space switcher component
		*Input Data: 
			
		*Expected Outcome: 
			- The list of space swticher options is displayed*/

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Select "Space 2"
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki tree of "Space 2" is displayed on the container below the space switcher*/

		/*Step number: 7
		*Step Name: 
		*Step Description: 
			- Select "Page A"
			- Click on "Select" button
		*Input Data: 
			
		*Expected Outcome: 
			- Popup is closed
			- "Page A" is added as a related pages on page info layout*/ 
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations(space2,pageA);
		wValidate.verifyRelatedPage(space2,pageA);

 	}

	/**
	*<li> Case ID:139318.</li>
	*<li> Test Case Name: Add relation to a page from the same space.</li>
	*<li> Pre-Condition: User is member of Space 1
	*Wiki of "Space 1" has following pages:
	- Page 1
	- Page 2</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_AddRelationToAPageFromTheSameSpace() {
		info("Test 14 Add relation to a page from the same space");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space 1" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki of "Space 1" is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "Page 1"
		*Input Data: 
			
		*Expected Outcome: 
			- Page 1 is displayed in the wiki*/
		info("Open page 1");
		wHome.goToAPage(page1);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page infos of Page 1 are diplayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- On "Related Page Layout" click on button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Select "Page 2"
			- Click on "Select" button
		*Input Data: 
			
		*Expected Outcome: 
			- Popup is closed
			- "Page 2" is added as a related pages on page info layout*/ 
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page2);
		wValidate.verifyRelatedPage(space1,page2);

 	}

	/**
	*<li> Case ID:139319.</li>
	*<li> Test Case Name: User should be able to select the currently browsed space.</li>
	*<li> Pre-Condition: User is member of Space 2Wiki of "Space 2" has following pages:
	- Page 1
	- Page 2
	--- Sub-Page 1</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_UserShouldBeAbleToSelectTheCurrentlyBrowsedSpace() {
		info("Test 15 User should be able to select the currently browsed space");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space 2" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki Space 2 is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create new sub page 2");
		String subpage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subpageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(page2);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subpage1,subpageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subpage1);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Select "Page 2" the wiki tree
		*Input Data: 
			
		*Expected Outcome: 
			- "Page 2" is displayed*/
		info("Open page 2 and space 1");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAPage(page2);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page info of "Page 2" are displayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- On "Related pages" part, click on the button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Open Space switcher component
		*Input Data: 
			
		*Expected Outcome: 
			- Space switcher component is displaying its list of options with "Space 2"*/

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Select "Space 2"
		*Input Data: 
			
		*Expected Outcome: 
			- the page selection part is displaying the wiki tree of "Space 2"*/ 
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page1);
		wValidate.verifyRelatedPage(space1,page1);

 	}

	/**
	*<li> Case ID:139320.</li>
	*<li> Test Case Name: Check behaviors when long space name in Page Layout.</li>
	*<li> Pre-Condition: User is member of space : "Check long title for a space 1"
	*Wiki of "Check long title for a space 1" has following pages:
	- Page 1
	- Page 2</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_CheckBehaviorsWhenLongSpaceNameInPageLayout() {
		info("Test 16 Check behaviors when long space name in Page Layout");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Check long title for a space 1" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki of "Check long title for a space 1" is displayed*/
		info("Create a space 1");
		String space1 = "Check long title for"+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create new sub page 2");
		String subpage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subpageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(page2);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subpage1,subpageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subpage1);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "Page 1"
		*Input Data: 
			
		*Expected Outcome: 
			- Page 1 is displayed in the wiki*/
		info("Open page 1");
		wHome.goToAPage(page1);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page infos of Page 1 are diplayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- On "Related Page Layout" click on button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Select "Page 2"
			- Click on "Select" button
		*Input Data: 
			
		*Expected Outcome: 
			- the popup is closed
			- "Page 2" is added as a related page on page info layout*/

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Check Page Info Layout, on related page part
		*Input Data: 
			
		*Expected Outcome: 
			- The space named is displayed correctly*/ 
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page2);
		wValidate.verifyRelatedPage(space1,page2);


 	}

	/**
	*<li> Case ID:139321.</li>
	*<li> Test Case Name: Check behaviors when long space name in Select Page popup.</li>
	*<li> Pre-Condition: User is member of space : "Check long title for a space 1"
	*Wiki of "Check long title for a space 1" has following pages:
	- Page 1
	- Page 2</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_CheckBehaviorsWhenLongSpaceNameInSelectPagePopup() {
		info("Test 17 Check behaviors when long space name in Select Page popup");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Check long title for a space 1" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki of "Check long title for a space 1" is displayed*/
		info("Create a space 1");
		String space1 = "Check long title for"+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create new sub page 2");
		String subpage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subpageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(page2);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subpage1,subpageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subpage1);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "Page 1"
		*Input Data: 
			
		*Expected Outcome: 
			- Page 1 is displayed in the wiki*/
		info("Open page 1");
		wHome.goToAPage(page1);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page infos of Page 1 are diplayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- On "Related Page Layout" click on button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Check Space Switcher
		*Input Data: 
			
		*Expected Outcome: 
			- "Check long title for a space 1" is displayed correctly*/ 
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page2);
		wValidate.verifyRelatedPage(space1,page2);

 	}

	/**
	*<li> Case ID:139322.</li>
	*<li> Test Case Name: Check changes in Add related popup layout.</li>
	*<li> Pre-Condition: User is member of Space 2Space 2 wiki has following pages:
	- Page 1
	- Page 2
	--- Sub-Page 1</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_CheckChangesInAddRelatedPopupLayout() {
		info("Test 18 Check changes in Add related popup layout");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go into "Space 2" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- "Space 2 " wiki is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create new sub page 2");
		String subpage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subpageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(page2);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subpage1,subpageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subpage1);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			- Page Info of "Wiki Home" page are displayed*/
		info("Open Wiki Home");
		wHome.goToHomeWikiPage();

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- On the part dedicated to related page, click on the button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- Popup to select a page is displayed
			- Label "Select the space:" with the space switcher are displayed*/
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		waitForAndGetElement(wHome.ELEMENT_ADD_RELATED_POPUP_DROPDOWN_VALUE.replace("$space",space1));

 	}

	/**
	*<li> Case ID:139323.</li>
	*<li> Test Case Name: Check changes in Page info layout.</li>
	*<li> Pre-Condition: User is member of Space 2
	*Space 2 wiki has following pages:
	- Page 1
	- Page 2
	--- Sub-Page 1</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_CheckChangesInPageInfoLayout() {
		info("Test 19 Check changes in Page info layout");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			Go to "Space 2" wiki
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki Space 2 is displayed*/
		info("Create a space 1");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create new page 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		spaMg.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,pageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create new page 2");
		String page2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageContent2= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page2,pageContent2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page2);
		
		info("Create new sub page 2");
		String subpage1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subpageContent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(page2);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subpage1,subpageContent1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subpage1);


		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Select "Page 2" the wiki tree
		*Input Data: 
			
		*Expected Outcome: 
			- "Page 2" is displayed*/
		info("Open Page 2");
		wHome.goToAPage(page2);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Page Info"
		*Input Data: 
			
		*Expected Outcome: 
			Page info of "Page 2" are displayed*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- On "Related pages" part, click on the button "Add More Relations"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to select a related page is displayed*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Select "Page 1"
			- Click on "Select" button
		*Input Data: 
			
		*Expected Outcome: 
			- The popup is dismissed
			- Page 1 is added in related page part*/

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Check Related page table layout
		*Input Data: 
			
		*Expected Outcome: 
			- First column is Wiki and displaying "Space 2"
			- Second column is Related Pages and displaying "Wiki Home > Page 1"
			- Third column is Actions and displaying a bin icon*/ 
		info("Add related page");
		wHome.goToPageInformation();
		wPageInfo.goToAddRelations();
		wPageInfo.addRelations("",page1);
		wValidate.verifyRelatedPage(space1,page1);

 	}}