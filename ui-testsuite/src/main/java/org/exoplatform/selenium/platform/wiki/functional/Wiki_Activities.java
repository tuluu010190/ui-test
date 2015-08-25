package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ActivityStream.changeTypes;
import org.testng.annotations.*;


	public class Wiki_Activities extends WIKI_TestConfig{

	/**
	*<li> Case ID:139186.</li>
	*<li> Test Case Name: Add a wiki's activity after create a wiki page in portal.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddAWikisActivityAfterCreateAWikiPageInPortal() {
		info("Test 1: Add a wiki's activity after create a wiki page in portal");
		/*Step Number: 1
		*Step Name: Step 1: Add a wiki page for portal
		*Step Description: 
			- Connect to Intranet
			- Click [Wiki], then select [Add Page] 
			-
			-> [Blank Page]/[From Template...] from the drop
			-down menu
			- Enter title and content
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- Wiki page is created*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		

		/*Step number: 2
		*Step Name: Step 2: Check wiki's activity after creating wiki page
		*Step Description: 
			- Back to the Hompage
		*Input Data: 
			
		*Expected Outcome: 
			- An activity of wikiis added to the activity stream
			- The content of the activity is displayed*/ 
		hp.goToHomePage();
		hpAct.checkActivity(title);

 	}

	/**
	*<li> Case ID:139189.</li>
	*<li> Test Case Name: Display "View Changes" page from wiki's activity.</li>
	*<li> Pre-Condition: the wiki page is not "version 1"</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_DisplayViewChangesPageFromWikisActivity() {
		info("Test 2: Display View Changes page from wiki's activity");
		/*Step Number: 1
		*Step Name: Step 1: Add page for wiki
		*Step Description: 
			- Connect to [Intranet]
			- Go to the [Homepage]
			- Click [Wiki] to go to the Wiki app 
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A wiki page is created successfully
			- A wiki activity is displayed*/
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 2
		*Step Name: Step 2: Edit wiki's page
		*Step Description: 
			- Click [Edit] to edit the wiki page
			- Change content for page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is edited successfully*/
		info("Edit the page");
		String editTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String editContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithSourceEditor(editTitle, editContent);
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(editTitle);
		arrayPage.add(editTitle);

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- In the create page's activity a Wiki page's version "View change" is displayed*/
		info("In the create page's activity a Wiki page's version 'View change' is displayed");
		hp.goToHomePage();
		hpAct.checkActivityWikiPage(editTitle, editContent, "2",true);

		/*Step number: 4
		*Step Name: Step 3: Check compare revision
		*Step Description: 
			- Click on the link "View changes"
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki application is opened in the view to compare Version N
			-1 and Version N*/ 
		hpAct.clickOnViewChange(editTitle);
		wikiMg.verifyCompareVersions("1");
		

 	}

	/**
	*<li> Case ID:139190.</li>
	*<li> Test Case Name: Update wiki's activity after edit wiki page title with active notification.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_UpdateWikisActivityAfterEditWikiPageTitleWithActiveNotification() {
		info("Test 3: Update wiki's activity after edit wiki page title with active notification");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A wiki page is added successfully*/
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Edit title of page with active notification
		*Step Description: 
			- Click [Edit]
			- Change title of the wiki page
			- Check [Publish Activity]
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Title of page is updated with new title*/
		
		info("Edit the page and publish the page");
		String editTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithSourceEditor(editTitle, "");
		wikiMg.publishPage();
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(editTitle);
		arrayPage.add(editTitle);
		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after change title with active notification
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity is updated
			- A comment is added in the activity: Page's title has been updated to: $value.*/
		info("Check the activity on Activity Stream");
		String comment = actCommentData.getMessageByArrayTypeRandom(2);
		hp.goToHomePage();
		hpAct.checkActivity(editTitle);
		hpAct.checkComment(editTitle, comment,editTitle,changeTypes.Has_One_Value);

 	}

	/**
	*<li> Case ID:139191.</li>
	*<li> Test Case Name: Update wiki's activity after edit wiki page title with inactive notification.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_UpdateWikisActivityAfterEditWikiPageTitleWithInactiveNotification() {
		info("Test 4: Update wiki's activity after edit wiki page title with inactive notification");
		/*Step Number: 1
		*Step Name: Step 1: Add wiki page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The new page is created successfully*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Edit title of page with inactive notification
		*Step Description: 
			- Click [Edit]
			- Change title of the wiki page
			- Un-check [Publish Activity]
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Title's page is updated with new value*/
		info("Edit the page and publish the page");
		String editTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithSourceEditor(editTitle, "");
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(editTitle);
		arrayPage.add(editTitle);
		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after edit title with inactive notification
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity content is updated with the new page title*/ 
		info("The wiki activity content is updated with the new page title");
		hp.goToHomePage();
		hpAct.checkActivity(editTitle);
 	}

	/**
	*<li> Case ID:139192.</li>
	*<li> Test Case Name: Update wiki's activity after edit wiki page without comment.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_UpdateWikisActivityAfterEditWikiPageWithoutComment() {
		info("Test 5: Update wiki's activity after edit wiki page without comment");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- New page is added successfully*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Edit content with active notification
		*Step Description: 
			- Click [Edit] to change content of wiki page without any comment associated<br />
			- Click [Publish Activity]<br />
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Content of page is updated
			- The comment: "Page's content has been edited." is added to the activity*/
		info("Edit the page and publish the page");
		String editContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithSourceEditor("", editContent);
		wikiMg.publishPage();
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(title);
		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after edit content with active notification
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity is updated
			- A comment is added in the activity: Page's content has been edited.*/ 
		info("Check the activity on Activity Stream");
		String comment = actCommentData.getMessageByArrayTypeRandom(3);
		hp.goToHomePage();
		hpAct.checkActivity(title);
		hpAct.checkComment(title, comment,null,changeTypes.No_Value);

 	}

	/**
	*<li> Case ID:139193.</li>
	*<li> Test Case Name: Update wiki's activity after edit wiki page with comment.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_UpdateWikisActivityAfterEditWikiPageWithComment() {
		info("Test 6: Update wiki's activity after edit wiki page with comment");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- New page is added successfully*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Edit content of page with comment associated
		*Step Description: 
			- Click [Edit] page
			- Change content for page
			- Add comment
			- Click [Publish Activity]
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Content of page is updated*/
		info("Edit the page and publish the page");
		String editContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String comment = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithSourceEditor("", editContent);
		wikiMg.addComment(comment);
		wikiMg.publishPage();
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(title);

		/*Step number: 3
		*Step Name: Step 3:Check wiki's activity after edit page with comment
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity is updated
			- A comment is added tothe activity, containing the associated comment value*/ 
		info("Check the activity on Activity Stream");
		hp.goToHomePage();
		hpAct.checkActivity(editContent);
		hpAct.checkComment(title, comment,null,changeTypes.No_Value);

 	}

	/**
	*<li> Case ID:139194.</li>
	*<li> Test Case Name: Update wiki's activity after edit wiki page with inactive notification.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_UpdateWikisActivityAfterEditWikiPageWithInactiveNotification() {
		info("Test 7: Update wiki's activity after edit wiki page with inactive notification");
		/*Step Number: 1
		*Step Name: Step 1: Add wiki page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A new page is added successfully*/
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Edit content of page with inactive notification
		*Step Description: 
			- Click [Edit] to edit content of the wiki page
			- Un-check [Publish Activity]
		*Input Data: 
			
		*Expected Outcome: 
			- Content of page is udated*/
		info("Edit the page and publish the page");
		String editContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithSourceEditor("", editContent);
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(title);

		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after edit content with inactive notification
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity is updated:* Version * potentialy first 4 lines*/ 
		hp.goToHomePage();
		hpAct.checkActivityWikiPage(title, editContent, "2",true);

 	}

	/**
	*<li> Case ID:139195.</li>
	*<li> Test Case Name: Update wiki's activity after move of wiki page.</li>
	*<li> Pre-Condition: the wiki activity is already shared in the activity stream</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_UpdateWikisActivityAfterMoveOfWikiPage() {
		info("Test 8: Update wiki's activity after move of wiki page");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A page is added successful*/
		info("Create a wiki page 1");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title1, content1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
		
		info("Create a wiki page 2");
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title2, content2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title2);
		arrayPage.add(title2);
		/*Step number: 2
		*Step Name: Step 2: Move page
		*Step Description: 
			- Click [More], choose [Move Page]
			- Select [Destination] and click [Move]
		*Input Data: 
			
		*Expected Outcome: 
			Page has been moved to new place*/
		info("Move the page");
		wHome.goToAPage(title1);
		wikiMg.movePage(title1, title2);

		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after move page
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity isn't updated
			- A comment is added in the activity: 
			Page has been moved to : $value. where $value is :SpaceName>WikiRootPage>WikiRootPage2>..*/ 
		String comment = actCommentData.getMessageByArrayTypeRandom(4);
		String value=title2+" > "+title1;
		hp.goToHomePage();
		hpAct.checkComment(title1, comment,value,changeTypes.Has_One_Value);

 	}

	/**
	*<li> Case ID:139199.</li>
	*<li> Test Case Name: Delete a Wiki activity from activity stream by owner.</li>
	*<li> Pre-Condition: Have a space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_DeleteAWikiActivityFromActivityStreamByOwner() {
		info("Test 9: Delete a Wiki activity from activity stream by owner");
		/*Step Number: 1
		*Step Name: Step 1: Add wiki for space
		*Step Description: 
			- Connect to [Intranet]
			- Add a Wiki activity for space
		*Input Data: 
			
		*Expected Outcome: 
			- The Wiki activity for spaceis displayed in the activity stream*/
		info("Create a space");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space,space,6000);
		Utils.pause(2000);
		
		info("Create a wiki page 1");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		
		/*Step number: 2
		*Step Name: Step 2: Check show delete icon
		*Step Description: 
			- Back to activity stream 
			- Move the mouse over the Wiki activity for space
		*Input Data: 
			
		*Expected Outcome: 
			A (X) icon is displayed in the top right panel of the activity*/
		

		/*Step number: 3
		*Step Name: Step 3: Delete wiki's activity
		*Step Description: 
			- Click on the (X) icon
			- Click on [OK] button of confirmation message
		*Input Data: 
			
		*Expected Outcome: 
			The Wiki activity for spaceis removed from the activity stream*/ 
		info("The Wiki activity for spaceis removed from the activity stream");
		hp.goToHomePage();
		hpAct.deleteActivity(title);

 	}

	/**
	*<li> Case ID:139200.</li>
	*<li> Test Case Name: Dislike a Wiki activity from like icon.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_DislikeAWikiActivityFromLikeIcon() {
		info("Test 10 Dislike a Wiki activity from like icon");
		/*Step Number: 1
		*Step Name: Step 1: Add a wiki activity
		*Step Description: 
			- Connect to [Intranet]
			- Add a Wiki activity
		*Input Data: 
			
		*Expected Outcome: 
			A wiki page is created*/
		info("Create a wiki page 1");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Like a wiki's activity
		*Step Description: 
			- Back to Homepage
			- Click [like icon]
		*Input Data: 
			
		*Expected Outcome: 
			- The Wiki activity is displayed in the activity stream*like icon + number of likes to 1*/
		info("Like the activity");
		hp.goToHomePage();
		hpAct.likeActivity(title);

		/*Step number: 3
		*Step Name: Step 3: Dislike a wiki's activity
		*Step Description: 
			- Click on [like icon] again
		*Input Data: 
			
		*Expected Outcome: 
			- The Wiki activity is disliked by the user, the number of like is updated to 
			-1*/ 
		info("Dislike the activity");
		hpAct.unlikeActivity(title);

 	}

	/**
	*<li> Case ID:139201.</li>
	*<li> Test Case Name: Add a wiki's activity after create a wiki page in space.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_AddAWikisActivityAfterCreateAWikiPageInSpace() {
		info("Test 11 Add a wiki's activity after create a wiki page in space");
		/*Step Number: 1
		*Step Name: Step 1: Add new space
		*Step Description: 
			- Connect to Intranet
			- Click [Join a space]
			- Click [Add New Space]
		*Input Data: 
			
		*Expected Outcome: 
			The new space is created successfully*/
		
		info("Create a space");
		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space,space,6000);
		Utils.pause(2000);

		/*Step number: 2
		*Step Name: Step 2: Add a wiki page for space
		*Step Description: 
			- Click the created space in the [My Spaces] panel
			- Click [Wiki] link on the space's top navigation bar
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- Wiki page is created for space*/
		info("Create a wiki page");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);

		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after created page
		*Step Description: 
			- Back to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- An activity of wikiis added to the activity stream
			- The content of the activity is displayed*/
		
		info("Check the Activity");
		hp.goToHomePage();
		hpAct.checkActivity(title);

		/*Step number: 4
		*Step Name: Step 4: Check with user is not member of space
		*Step Description: 
			- Login by user is not member of space
			- Click [Join a space]
			- Choose space at step 1
		*Input Data: 
			
		*Expected Outcome: 
			Show message alert "You must be a member of the space "name of space" to view this page. "*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToAllSpace();
		spaMg.goToSpace(space);
		spaMg.verifyMessageAccessToSpace(space);
		

 	}

	/**
	*<li> Case ID:139202.</li>
	*<li> Test Case Name: Check wiki's activity after create a wiki page for user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test12_CheckWikisActivityAfterCreateAWikiPageForUser() {
		info("Test 12 Check wiki's activity after create a wiki page for user");
		/*Step Number: 1
		*Step Name: Step 1: Add a wiki page for user
		*Step Description: 
			- Connect to Intranet
			- Hover your cursor over the User name, then select[My Wiki] from the drop
			-down menu
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- Wiki page is created successfully*/

		info("Create a wiki page 1");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		navTool.goToMyWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Check wiki's activity after created wiki page
		*Step Description: 
			- Back to the Hompage
		*Input Data: 
			
		*Expected Outcome: 
			No activity is added when the user wiki is created*/ 
		info("Check the Activity");
		hp.goToHomePage();
		hpAct.checkNotShownActivity(title);

 	}

	/**
	*<li> Case ID:139203.</li>
	*<li> Test Case Name: Remove wiki's page of space.</li>
	*<li> Pre-Condition: Have a space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_RemoveWikisPageOfSpace() {
		info("Test 13 Remove wiki's page of space");
		/*Step Number: 1
		*Step Name: Step 1: Add wiki for space
		*Step Description: 
			- Connect to [Intranet]
			- Add a Wiki activity for space
		*Input Data: 
			
		*Expected Outcome: 
			- The Wiki activity for spaceis displayed in the activity stream*/
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
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		
		/*Step number: 2
		*Step Name: Step 2: Check show delete icon
		*Step Description: 
			- Back to activity stream 
			- Move the mouse over the Wiki activity for space
		*Input Data: 
			
		*Expected Outcome: 
			A (X) icon is displayed in the top right panel of the activity*/
		hp.goToSpecificSpace(space);
		mouseOver(hpAct.ELEMENT_ACTIVITY_BOX.replace("${name}", title), true);
		waitForAndGetElement(hpAct.ELEMENT_ACTIVITY_BOX_DELETE_BUTTON.replace("${name}",title));

		/*Step number: 3
		*Step Name: Step 3: Delete wiki page of space
		*Step Description: 
			- Go to [Space Setting] 
			- Choose [Application]tab
			- Select wiki and click (x) to delete wiki page
		*Input Data: 
			
		*Expected Outcome: 
			- Wiki page is deleted successfully*/
		info("Remove Wiki application in the space");
		hp.goToSpecificSpace(space);
		spaHome.goToSpaceSettingTab();
		spSettingMg.goToApplicationTab();
		spSettingMg.removeApplication("Wiki");

		/*Step number: 4
		*Step Name: Step 4: Check wiki's activity of space after delete wiki page
		*Step Description: 
			- Back to activity stream
		*Input Data: 
			
		*Expected Outcome: 
			The Wiki activity for spaceis removed from the activity stream*/ 
		info("Check on AS");
		hp.goToHomePage();
		hpAct.checkNotShownActivity(title);

 	}

	/**
	*<li> Case ID:139204.</li>
	*<li> Test Case Name: Update wiki's activity after edit wiki page content with active notification.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_UpdateWikisActivityAfterEditWikiPageContentWithActiveNotification() {
		info("Test 14 Update wiki's activity after edit wiki page content with active notification");
		/*Step Number: 1
		*Step Name: Step 1: Add new page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- A wiki page is added successfully*/
		info("Create a wiki page");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Edit content of page with active notification
		*Step Description: 
			- Click [Edit]
			- Edit content of the wiki page
			- Check [Publish Activity]
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Content of page is updated with new content*/
		info("Edit the page and publish the page");
		String editContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithAutoSave("",editContent);
		wikiMg.publishPage();
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(title);

		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after change content with active notification
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity is updated
			- A comment is added in the activity: Page's content has been edited.*/
		info("Check the activity on Activity Stream");
		String comment = actCommentData.getMessageByArrayTypeRandom(3);
		hp.goToHomePage();
		hpAct.checkActivity(editContent);
		hpAct.checkComment(title, comment,null,changeTypes.No_Value);

 	}

	/**
	*<li> Case ID:139205.</li>
	*<li> Test Case Name: Update wiki's activity after edit wiki page content with inactive notification.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_UpdateWikisActivityAfterEditWikiPageContentWithInactiveNotification() {
		info("Test 15 Update wiki's activity after edit wiki page content with inactive notification");
		/*Step Number: 1
		*Step Name: Step 1: Add wiki page
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open the Wiki application
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Enter title and content for the Wiki page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Add new page successfully*/
		info("Create a wiki page");
		String title= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.addSimplePageWithSourceEditor(title, content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wHome.verifyTitleWikiPage(title);
		arrayPage.add(title);
		/*Step number: 2
		*Step Name: Step 2: Edit content of page with inactive notification
		*Step Description: 
			- Click [Edit].
			- Change content of the wiki page
			- Un
			-check [Publish Activity]
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Content page is updated with new value*/
		info("Edit the page and publish the page");
		String editContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title);
		wHome.goToEditPage();
		wikiMg.editSimplePageWithAutoSave("",editContent);
		wikiMg.saveAddPage();
		wHome.verifyTitleWikiPage(title);

		/*Step number: 3
		*Step Name: Step 3: Check wiki's activity after edit content with inactive notification
		*Step Description: 
			- Go to the Homepage
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki activity content is updated with the new content
			- No comment is added into activity*/ 
		info("Check the activity on Activity Stream");
		hp.goToHomePage();
		hpAct.checkActivity(editContent);
		hpAct.checkNotComment(title);

 	}}