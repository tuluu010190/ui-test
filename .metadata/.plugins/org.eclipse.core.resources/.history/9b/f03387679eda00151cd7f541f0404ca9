package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;

import org.exoplatform.selenium.Utils;
import org.testng.annotations.*;


	public class Wiki_BasicAction_Move_Move_Control extends WIKI_TestConfig{

	/**
	*<li> Case ID:139557.</li>
	*<li> Test Case Name: Check Control case sensitive: 1 to 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition:
	User is member of "Space Move" and "Space Destination" 
	Wiki of "Space Move" has:
	- Page C Renamed
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckControlCaseSensitiveOneToFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 1: Check Control case sensitive: 1 to 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C Renamed"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page C Renamed" is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageCRenamed = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageCRenamed,pageCRenamed);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageCRenamed);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageCRenamed);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		
		info("Create pages and sub-pages for space 2");
		info("Create page D");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageCRenamed,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String mess = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(mess,listSubPages);
 	}

	/**
	*<li> Case ID:139558.</li>
	*<li> Test Case Name: Check Control case sensitive: main page has the same name in the target space.</li>
	User is member of "Space Move" and "Space Destination" Wiki of "Space Move" has:
	- page 1
	
	Wiki of "Space Destination" has:
	- Page 1
	</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CheckControlCaseSensitiveMainPageHasTheSameNameInTheTargetSpace() {
		info("Test 2: Check Control case sensitive: main page has the same name in the target space");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "page 1"
		*Input Data: 
			
		*Expected Outcome: 
			- Page 1 is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String page1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String Page1=page1.toLowerCase();
		info("Create page 1");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,page1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create pages for space 2");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(Page1,Page1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(Page1);
		

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- The Page is moved to the wiki of "Space Destination"*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(page1,"Wiki Home",space2);
		info("The Page is moved to the wiki of Space 2");
		wValidate.verifyTitleWikiPage(page1);

 	}

	/**
	*<li> Case ID:139559.</li>
	*<li> Test Case Name: Check Control case sensitive: more than 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination" Wiki of "Space Move" has:
	- Page C Renamed
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	--- Sub-Page 6
	--- Sub-Page 7
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5
	--- Sub-Page 6
	--- Sub-Page 7</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckControlCaseSensitiveMoreThanFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 3: Check Control case sensitive: more than 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C Renamed"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page C Renamed" is displayed*/
		
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageCRenamed = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",8);
		info("Create page C renamed");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageCRenamed,pageCRenamed);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageCRenamed);
		
		for(int i=0;i<7;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageCRenamed);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Create pages and sub-pages for space 2");
		info("Create page C");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<7;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename* and more...*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageCRenamed,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String mess = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(mess,listSubPages);
 	}

	/**
	*<li> Case ID:139560.</li>
	*<li> Test Case Name: Check Control case sensitive: The main page and 1 to 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition:User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CheckControlCaseSensitiveTheMainPageAndOneToFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 4: Check Control case sensitive: The main page and 1 to 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Create pages and sub-pages for space 2");
		info("Create page C");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			* "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageC,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messParrent = wikiWarningData.getDataContentByArrayTypeRandom(6);
		String messChild = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(messParrent);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

 	}

	/**
	*<li> Case ID:139561.</li>
	*<li> Test Case Name: Check Control case sensitive: The main page and more than 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition:User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	--- Sub-Page 6
	--- Sub-Page 7
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5
	--- Sub-Page 6
	--- Sub-Page 7</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_CheckControlCaseSensitiveTheMainPageAndMoreThanFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 5: Check Control case sensitive: The main page and more than 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",8);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<7;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Create pages and sub-pages for space 2");
		info("Create page C");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<7;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			* "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 6 already exist. Rename* and more...*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageC,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messParrent = wikiWarningData.getDataContentByArrayTypeRandom(6);
		String messChild = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(messParrent);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

 	}

	/**
	*<li> Case ID:139562.</li>
	*<li> Test Case Name: Check Control permissions: Move to a destination where user has no edit permissions.</li>
	*<li> Pre-Condition: User is Member of "Space Move"
	User is Member of "Space View"
	Wiki of "Space Move" has:
	- Page C 
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5
	Wiki of "Space View" has:
	- Page A,user has no permissions to edit pages in the page</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_CheckControlPermissionsMoveToADestinationWhereUserHasNoEditPermissions() {
		info("Test 6: Check Control permissions: Move to a destination where user has no edit permissions");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page C" is displayed*/
		info("Create 2 new users");
		String password="123456";
		navTool.goToAddUser();
		arrayUsers = addUserPage.addUsers(2,password);
		
		info("Login with user 1");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		info("Create page C");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Login with user 2");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(1), password);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Invite user 1 to space 2");
		hp.goToSpecificSpace(space2);
		spaHome.goToSpaceSettingTab();
		spSettingMg.inviteUser(arrayUsers.get(0),true,arrayUsers.get(0));
		Utils.pause(2000);
		
		info("Create pages for space 2");
		String pageA = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Create page A");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		info("Set permisison for PageD");
		String groupUsers = permisGroups.getDataColTwoByArrayTypeRandom(9)+"/"+space2.toLowerCase();
		info("groupUsers:"+groupUsers);
		wHome.goToAPage(pageA);
		wHome.goToPermissions();
		wPermission.deletePermission(groupUsers);
		
		info("Add View permission to User A");
		wPermission.addPermisisonByType(arrayUsers.get(0));
		wValidate.verifyEditPermisison(arrayUsers.get(0),false);
		wValidate.verifyViewPermisison(arrayUsers.get(0),true);
		wPermission.savePermisison();
		
		info("Login with user 1");
		magAc.signOut();
		magAc.signIn(arrayUsers.get(0), password);
		Utils.pause(2000);
		
		info("Accept invitation of the space 2");
		hp.goToAllSpace();
		spaMg.acceptAInvitation(space2);
		

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space View"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space View" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space View > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			An error message is displayed with the message "You have no edit permission at destination page"*/ 

		info("Move the page C to the page D of space 2");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wikiMg.movePageDiffDestination(pageC,pageA,space2);
		
		info("Verify that an error message is displayed");
		String mess = wikiWarningData.getDataContentByArrayTypeRandom(8);
		wValidate.verifyWarningMessage(mess);
		wHome.confirmWaringMessage(true);
 	}

	/**
	*<li> Case ID:139563.</li>
	*<li> Test Case Name: Check Control: 1 to 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition:User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page C Renamed
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5 
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*THIS CASE DUPLICATED WITH TEST 01: 139557
	*/
	@Test(groups="pending")
	public  void test07_CheckControlOneToFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 7: Check Control: 1 to 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C Renamed"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page C renamed" is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: * Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename*/ 

 	}

	/**
	*<li> Case ID:139564.</li>
	*<li> Test Case Name: Check Control: complex sub-pages tree with name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page D
	--- Sub-Page level 1
	------ Sub-Page level 2
	-------- Sub-Page level 3
	
	Wiki of "Space Destination" has:
	- The complex page
	--- Sub-Page level 1
	------ Sub-Page level 2
	-------- Sub-Page level 3</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CheckControlComplexSubpagesTreeWithNameDuplicatedInTheTargetSpace() {
		info("Test 8: Check Control: complex sub-pages tree with name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page D"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page D" is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageA = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageD = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",4);
		info("Create page D");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageD,pageD);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageD);
		
		info("Create sub page D level 1");
		wHome.goToAPage(pageD);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(listSubPages.get(0),listSubPages.get(0));
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(listSubPages.get(0));
		
		
		info("Create sub page D level 2");
		wHome.goToAPage(listSubPages.get(0));
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(listSubPages.get(1),listSubPages.get(1));
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(listSubPages.get(1));
		
		info("Create sub page D level 3");
		wHome.goToAPage(listSubPages.get(1));
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(listSubPages.get(2),listSubPages.get(2));
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(listSubPages.get(2));
		
		info("Create pages and sub-pages for space 2");
		info("Create page D");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		info("Create sub page A level 1");
		wHome.goToAPage(pageA);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(listSubPages.get(0),listSubPages.get(0));
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(listSubPages.get(0));
		
		
		info("Create sub page A level 2");
		wHome.goToAPage(listSubPages.get(0));
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(listSubPages.get(1),listSubPages.get(1));
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(listSubPages.get(1));
		
		info("Create sub page A level 3");
		wHome.goToAPage(listSubPages.get(1));
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(listSubPages.get(2),listSubPages.get(2));
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(listSubPages.get(2));

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: * Sub
			-Page level 1 already exist. Rename* Sub
			-Page level 2 already exist. Rename* Sub
			-Page level 3 already exist. Rename*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageD,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messChild = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

 	}

	/**
	*<li> Case ID:139565.</li>
	*<li> Test Case Name: Check Control: main page has the same name in the target space.</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page B
	
	Wiki of "Space Destination" has:
	- Page B</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_CheckControlMainPageHasTheSameNameInTheTargetSpace() {
		info("Test 9: Check Control: main page has the same name in the target space");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page B"
		*Input Data: 
			
		*Expected Outcome: 
			- Page B is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageB = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		
		
		info("Create pages and sub-pages for space 2");
		info("Create page B");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher:
			 "Another page with the same title already exists in the selected space"*/ 

		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageB,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messParrent = wikiWarningData.getDataContentByArrayTypeRandom(6);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(messParrent);
 	}

	/**
	*<li> Case ID:139566.</li>
	*<li> Test Case Name: Check Control: more than 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page A
	- Page B
	- Page C Renamed
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5 
	--- Sub-Page 6
	--- Sub-Page 7
	
	Wiki of "Space Destination" has:
	- Page 1
	- Page B
	- page b
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5
	--- Sub-Page 6
	--- Sub-Page 7</li>
	*<li> Post-Condition: </li>
	*DUPLICATE WITH TEST CASE 03: 139559
	*/
	@Test(groups="pending")
	public  void test10_CheckControlMoreThanFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 10 Check Control: more than 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C Renamed"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page C Renamed" is displayed*/
		

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: * "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename* and more...*/ 

 	}

	/**
	*<li> Case ID:139567.</li>
	*<li> Test Case Name: Check Control: The main page and 1 to 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page A
	- Page B
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5 
	
	Wiki of "Space Destination" has:
	- Page 1
	- Page B
	- page b
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*DUPLICATE WITH TEST CASE 04: 139560
	*/
	@Test(groups="pending")
	public  void test11_CheckControlTheMainPageAndOneToFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 11 Check Control: The main page and 1 to 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			* "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename*/ 

 	}

	/**
	*<li> Case ID:139568.</li>
	*<li> Test Case Name: Check Control: The main page and more than 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page A
	- Page B
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5 
	--- Sub-Page 6
	--- Sub-Page 7
	
	Wiki of "Space Destination" has:
	- Page 1
	- Page B
	- page b
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5
	--- Sub-Page 6
	--- Sub-Page 7</li>
	*<li> Post-Condition: </li>
	*DUPLICATE WITH TEST CASE O5: 139561
	*/
	@Test(groups="pending")
	public  void test12_CheckControlTheMainPageAndMoreThanFiveSubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 12 Check Control: The main page and more than 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			* "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename* and more...*/ 

 	}

	/**
	*<li> Case ID:139569.</li>
	*<li> Test Case Name: Check Redirection after a move to "Intranet".</li>
	*<li> Pre-Condition: User is member of "Space Move"
	Wiki of "Space Move" has:
	- Page B
	- Page company</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test13_CheckRedirectionAfterAMoveToIntranet() {
		info("Test 13 Check Redirection after a move to Intranet");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" using left side bar navigation
			- Open wiki application
			- Open "Page company"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page companyi" is displayed
			- Space navigation of "Space Move" is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create Page company on the space");
		String pageCompany=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageCompany,pageCompany);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageCompany);
		arrayPage.add(pageCompany);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Move"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move the page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Intranet"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Intranet" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Intranet > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- "Page company" is moved in "Intranet"
			- "Page company" is automatically displayed in "Intranet" :
			- Breadcrumb is displaying :Intranet > Wiki Home > Page my wiki
			- Space Navigation is not displayed anymore. Wiki on the Company menu is selected*/
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageCompany,"Wiki Home","Intranet");
		
		info("[Page company] is moved in [Intranet]");
		wValidate.verifyTitleWikiPage(pageCompany);
		info("Breadcrumb is displaying :Intranet > Wiki Home >"+pageCompany);
		wValidate.verifyBreadCrumbePath("Intranet","Wiki Home",pageCompany);
		info("Space Navigation is not displayed anymore");
		waitForElementNotPresent(spaHome.ELEMENT_SPACE_WIKI_TAB);
		info("Wiki on the Company menu is selected");
		wValidate.verifyContentPage(pageCompany);

 	}

	/**
	*<li> Case ID:139570.</li>
	*<li> Test Case Name: Check Redirection after a move to "My Wiki".</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination 2"
	Wiki of "Space Move" has:
	- Page B
	- Page my wiki</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_CheckRedirectionAfterAMoveToMyWiki() {
		info("Test 14 Check Redirection after a move to My Wiki");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" using left side bar navigation
			- Open wiki application
			- Open "Page my wiki"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page my wiki" is displayed
			- Space navigation of "Space Move" is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create Page company on the space");
		String page=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,page);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
		arrayPage.add(page);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Move"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move the page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "My Wiki"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "My Wiki" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :My Wiki > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- "Page my wiki" is moved in "My Wiki"
			- "Page my wiki" is automatically displayed in "My Wiki" :
			- Breadcrumb is displaying :My Wiki > Wiki Home > Page my wiki
			- User Navigation is displayed, with "My Wiki" selected*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(page,"Wiki Home","My Wiki");
		
		info("[Page] is moved in [My Wiki]");
		wValidate.verifyTitleWikiPage(page);
		info("Breadcrumb is displaying :Intranet > Wiki Home >"+page);
		wValidate.verifyBreadCrumbePath("My Wiki","Wiki Home",page);
		info("Space Navigation is not displayed anymore");
		waitForElementNotPresent(spaHome.ELEMENT_SPACE_WIKI_TAB);
		info("Wiki on the Company menu is selected");
		wValidate.verifyContentPage(page);

 	}

	/**
	*<li> Case ID:139582.</li>
	*<li> Test Case Name: Tooltip must be displayed on the message displayed when main page has the same name in the target space.</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page A
	- Page B
	
	Wiki of "Space Destination" has:
	- Page 1
	- Page B
	- page b</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_TooltipMustBeDisplayedOnTheMessageDisplayedWhenMainPageHasTheSameNameInTheTargetSpace() {
		info("Test 16 Tooltip must be displayed on the message displayed when main page has the same name in the target space");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page B"
		*Input Data: 
			
		*Expected Outcome: 
			- Page B is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create Page on the space");
		String pageA=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageB=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String page1=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageb=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		info("Create page B");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);

		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		info("Create page 1");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,page1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create page B");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		
		info("Create page b");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageb,pageb);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageb);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message with a warning icon are displayed bellow the space switcher: "Another page with the same title already exist in the selected space. Rename"*/

		info("Move page of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageB,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String mess = wikiWarningData.getDataContentByArrayTypeRandom(6);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(mess);
		
		/*Step number: 6
		*Step Name: 
		*Step Description: 
			Put your mouse over "rename" in the warning message
		*Input Data: 
			
		*Expected Outcome: 
			- Tooltip "Rename the page to move" is displayed*/ 
		info("Tooltip [Rename the page to move] is displayed");
	    wValidate.verifyToolTipMessageOnePageHasSameTitleInMovingPage(mess);

 	}

	/**
	*<li> Case ID:139583.</li>
	*<li> Test Case Name: Tooltips must be displayed on messages displayed when 1 to 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page C Renamed
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_TooltipsMustBeDisplayedOnMessagesDisplayedWhen1To5SubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 17 Tooltips must be displayed on messages displayed when 1 to 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C Renamed"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page C Renamed" is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageCRenamed = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		
		info("Create page C renamed");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageCRenamed,pageCRenamed);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageCRenamed);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageCRenamed);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Create pages and sub-pages for space 2");
		info("Create page C");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename*/
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageCRenamed,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String mess = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(mess,listSubPages);

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Put your mouse over "Rename" next to the message "Sub
			-Page 1 already exist"
		*Input Data: 
			
		*Expected Outcome: 
			- A tooltip is displayed with the message "Rename the sub
			-page to move"*/ 
		info("Verify the tooltip");
		wValidate.verifyToolTipMessageManyPagesHaveSameTitleInMovingPage(mess,listSubPages);

 	}

	/**
	*<li> Case ID:139584.</li>
	*<li> Test Case Name: Tooltips must be displayed on messages displayed when more than 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	--- Sub-Page 6
	--- Sub-Page 7
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5
	--- Sub-Page 6
	--- Sub-Page 7</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_TooltipsMustBeDisplayedOnMessagesDisplayedWhenMoreThan5SubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 18 Tooltips must be displayed on messages displayed when more than 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",8);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<7;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		
		info("Create pages and sub-pages for space 2");
		info("Create page C");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<7;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			* "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename* and more...*/
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageC,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messParrent = wikiWarningData.getDataContentByArrayTypeRandom(6);
		String messChild = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(messParrent);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Put your mouse over "Rename" next to the message "Sub
			-Page 1 already exist"
		*Input Data: 
			
		*Expected Outcome: 
			- A tooltip is displayed with the message "Rename the sub
			-page to move"*/ 
		info("Verify the tooltip");
		wValidate.verifyToolTipMessageOnePageHasSameTitleInMovingPage(messParrent);
		wValidate.verifyToolTipMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

 	}

	/**
	*<li> Case ID:139585.</li>
	*<li> Test Case Name: Tooltips must be displayed on messages displayed when the main page and 1 to 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_TooltipsMustBeDisplayedOnMessagesDisplayedWhenTheMainPageAnd1To5SubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 19 Tooltips must be displayed on messages displayed when the main page and 1 to 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Create pages and sub-pages for space 2");
		info("Create page C");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: 
			* "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 5 already exist. Rename*/
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageC,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messParrent = wikiWarningData.getDataContentByArrayTypeRandom(6);
		String messChild = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(messParrent);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Put your mouse over "Rename" next to the message "Another page with the same title already exist in the selected page."
		*Input Data: 
			
		*Expected Outcome: 
			- A tooltip is displayed with the message "Rename the page to move"*/

		/*Step number: 7
		*Step Name: 
		*Step Description: 
			- Put your mouse over "Rename" next to the message "Sub
			-Page 1 already exist"
		*Input Data: 
			
		*Expected Outcome: 
			- A tooltip is displayed with the message "Rename the sub
			-page to move"*/ 
		info("Verify the tooltip");
		wValidate.verifyToolTipMessageOnePageHasSameTitleInMovingPage(messParrent);
		wValidate.verifyToolTipMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

 	}

	/**
	*<li> Case ID:139586.</li>
	*<li> Test Case Name: Tooltips must be displayed on messages displayed when the main page and more than 5 sub-pages name duplicated in the target space..</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page A
	- Page B
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- sub-page 5 
	--- Sub-Page 6
	--- Sub-Page 7
	
	Wiki of "Space Destination" has:
	- Page 1
	- Page B
	- page b
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5
	--- Sub-Page 6
	--- Sub-Page 7</li>
	*<li> Post-Condition: </li>
	*DUPLICATE WITH TEST CASE 18: 139584
	*/
	@Test(groups="pending")
	public  void test20_TooltipsMustBeDisplayedOnMessagesDisplayedWhenTheMainPageAndMoreThan5SubpagesNameDuplicatedInTheTargetSpace() {
		info("Test 20 Tooltips must be displayed on messages displayed when the main page and more than 5 sub-pages name duplicated in the target space.");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed bellow the space switcher: * "Another page with the same title already exist in the selected space. Rename"* Sub
			-Page 1 already exist. Rename* Sub
			-Page 2 already exist. Rename* Sub
			-Page 3 already exist. Rename* Sub
			-Page 4 already exist. Rename* Sub
			-Page 6 already exist. Rename* and more...*/

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Put your mouse over "Rename" next to the message "Another page with the same title already exist in the selected page."
		*Input Data: 
			
		*Expected Outcome: 
			- A tooltip is displayed with the message "Rename the page to move"*/

		/*Step number: 7
		*Step Name: 
		*Step Description: 
			- Put your mouse over "Rename" next to the message "Sub
			-Page 1 already exist"
		*Input Data: 
			
		*Expected Outcome: 
			- A tooltip is displayed with the message "Rename the sub
			-page to move"*/ 

 	}

	/**
	*<li> Case ID:139587.</li>
	*<li> Test Case Name: User should be able to move a page in the same wiki.</li>
	*<li> Pre-Condition: User is member of "Space Move"
	Wiki of "Space Move" has:
	- Page A
	- Page B
	- Page C 
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test21_UserShouldBeAbleToMoveAPageInTheSameWiki() {
		info("Test 21 User should be able to move a page in the same wiki");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageA = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageB = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageA,pageA);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageA);
		
		
		info("Create page B");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		
		info("Create page C");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- In destination container select "Page A"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Move > Wiki Home > Page A*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is move below Page A*/ 
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePage(pageC, pageA);
		info("Page C is move below Page A");
		wValidate.verifyParentChildNode(pageA, pageC);

 	}

	/**
	*<li> Case ID:139588.</li>
	*<li> Test Case Name: User should be able to rename a sub-page.</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5 
	
	
	Wiki of "Space Destination" has:
	- Page C
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test22_UserShouldBeAbleToRenameASubpage() {
		info("Test 22 User should be able to rename a sub-page");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page C"
		*Input Data: 
			
		*Expected Outcome: 
			- Page C is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Create pages and sub-pages for space 2");
		info("Create page C");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- Messages with warning icons are displayed bellow the space switcher:
			 * "Another page with the same title already exist in the selected space. Rename"* "Sub
			-Page 1 already exist. Rename"* "Sub
			-Page 2 already exist. Rename"* "Sub
			-Page 3 already exist. Rename"* "Sub
			-Page 4 already exist. Rename"* "Sub
			-Page 5 already exist. Rename"*/
		
		info("Move page C of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageC,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messParrent = wikiWarningData.getDataContentByArrayTypeRandom(6);
		String messChild = wikiWarningData.getDataContentByArrayTypeRandom(7);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(messParrent);
		wValidate.verifyMessageManyPagesHaveSameTitleInMovingPage(messChild,listSubPages);

		/*Step number: 6
		*Step Name: 
		*Step Description: 
			- Put your mouse over "rename" next to "Sub
			-Page 3 already exist"
		*Input Data: 
			
		*Expected Outcome: 
			- Tooltip "Rename the page to move" is displayed*/

		/*Step number: 7
		*Step Name: 
		*Step Description: 
			- Click on Rename
		*Input Data: 
			
		*Expected Outcome: 
			- The "Sub
			-Page 3" of "Space Move" wiki is opened in edition mode.*/ 
		wikiMg.renameFromAlertMessageOfManyPages(messChild,listSubPages.get(2));
		wValidate.verifyEditModeOpenning(listSubPages.get(2));

 	}

	/**
	*<li> Case ID:139589.</li>
	*<li> Test Case Name: User should be able to rename the main page.</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination"
	Wiki of "Space Move" has:
	- Page B
	- Page C 
	--- Sub-Page 1
	--- Sub-Page 2
	--- Sub-Page 3
	--- Sub-Page 4
	--- Sub-Page 5 
	
	Wiki of "Space Destination" has:
	- Page B
	</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test23_UserShouldBeAbleToRenameTheMainPage() {
		info("Test 23 User should be able to rename the main page");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" wiki
			- Select "Page B"
		*Input Data: 
			
		*Expected Outcome: 
			- Page B is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
		
		info("Create pages and sub-pages for space 1");
		String pageC = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String pageB = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		ArrayList<String> listSubPages= getListData("Page",6);
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageC,pageC);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageC);
		
		info("Create page B");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		
		for(int i=0;i<5;i++){
			info("Create sub page C"+i);
			wHome.goToAPage(pageC);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(listSubPages.get(i),listSubPages.get(i));
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(listSubPages.get(i));
		}
		
		info("Create pages and sub-pages for space 2");
		info("Create page B");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(pageB,pageB);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(pageB);
		

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click on More Menu
			- Select Move Option
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move a page is displayed*/

		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/

		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination > Wiki Home*/

		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- A message with a warning icon are displayed bellow the space switcher: "Another page with the same title already exist in the selected space. Rename"*/

		info("Move page B of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(pageB,"Wiki Home",space2);
		
		info("Verify that the message is shown");
		String messParrent = wikiWarningData.getDataContentByArrayTypeRandom(6);
		wValidate.verifyMessageOnePageHasSameTitleInMovingPage(messParrent);
		
		/*Step number: 6
		*Step Name: 
		*Step Description: 
			Put your mouse over "rename" in the warning message
		*Input Data: 
			
		*Expected Outcome: 
			- Tooltip "Rename the page to move" is displayed*/

		/*Step number: 7
		*Step Name: 
		*Step Description: 
			- Click on Rename
		*Input Data: 
			
		*Expected Outcome: 
			- The "Page B" of "Space Move" wiki is opened in edition mode.*/
		wikiMg.renameFromAlertMessageOfOnePage();		
		wValidate.verifyEditModeOpenning(pageB);

 	}}