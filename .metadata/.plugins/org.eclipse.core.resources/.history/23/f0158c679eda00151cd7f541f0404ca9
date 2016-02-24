package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.testng.annotations.Test;

public class Wiki_BasicAction_Move_Move_Layout extends WIKI_TestConfig{
	
	/**
	 *<li> Case ID:139572.</li>
	 *<li> Test Case Name:Move Layout is displaying "Select the destination:" label.</li>
	 *<li> Case ID:139573.</li>
	 *<li> Test Case Name:Move Layout is displaying space switcher.</li>
	 *<li> Case ID:139574.</li>
	 *<li> Test Case Name:Move layout should display destination labels outside destination container.</li>
	 *<li> Pre-Condition: User is member of Space: Space Move.</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_02_03_MoveLayoutIsDisplayingSelectTheDestiNationLabelAndSpaceSwitcherAndDestinationLabels() {	
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content =  txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		info("Create data test");
		info("Create Space 1 with a wiki page 1");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		
		/*Step Number: 1
		 *Step Name: Step 1
		 *Step Description: 
			- Go to the wiki of the "Space Move"
		 *Input Data: 

		 *Expected Outcome: 
			- Wiki is displayed*/
		/*Step Number: 2
		 *Step Name: Step 2
		 *Step Description: 
			- Create a new Page with the title Page A 
			- Save
		 *Input Data: 

		 *Expected Outcome: 
			- Page A is displayed*/
		info("Create wiki page in sapce1");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		arraySpace.add(space1);
		
		/*Step Number: 3
		 *Step Name: Step 3
		 *Step Description: 
			- Click on [More] on menu
		 *Input Data: 

		 *Expected Outcome: 
			- Move option is available*/
		wHome.goToMovePageForm();
		
		/*Step Number: 4
		 *Step Name: Step 4
		 *Step Description: 
			- Click on Move options
		 *Input Data: 

		 *Expected Outcome: 
			- A popup is displayed with the space switcher
			- Label "Select the destination:" is displayed before the space switcher*/
		info("Test 1: Move Layout is displaying Select the destination label");
		info("Label Select the destination is displayed before the space switcher");
		waitForAndGetElement(wikiLoc.ELEMENT_MOVE_PAGE_SELECT_THE_DESTINATION_LABEL, 2000,1);
		
		/*Step Number: 5
		 *Step Name: Step 5
		 *Step Description: 
			- Click on Move options
		 *Input Data: 

		 *Expected Outcome: 
			- A popup is displayed with the space switcher*/
		info("Test 2: Move Layout is displaying space switcher");
		info("Space switcher is desplayed");
		waitForAndGetElement(wikiLoc.ELEMENT_MOVE_SPACESWITCHER,2000,1);
		
		/*Step Number: 6
		 *Step Name: Step 6
		 *Step Description: 
			- Click on Move options
		 *Input Data: 

		 *Expected Outcome: 
			- A popup is displayed to move the page
			- Label "Destination:" is displayed outside and above the destination container.*/
		info("Test 3: Move layout should display destination labels outside destination container");
		info("Label Destination is displayed outside and above the destination container");
		waitForAndGetElement(wikiLoc.ELEMENT_MOVE_PAGE_DESTINATION_LABEL, 2000, 1);	
	}
	
	/**
	 *<li> Case ID:139575.</li>
	 *<li> Test Case Name:Not selecting a space with the space switcher should have no impact on the destination container.</li>
	 *<li> Pre-Condition: 
	 	User is member of space : "Space Move", "Space Destination"
	 	Wiki of "Space Move" contains a page "Page A".</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_NotSelectingASpaceWithTheSpaceSwitcherShouldHaveNoImpactOnTheDestinationContainer() {	
		info("Test 4: Not selecting a space with the space switcher should have no impact on the destination container");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content =  txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		info("Create data test");
		info("Create Space 1");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		arraySpace.add(space1);
		
		info("Create Space 2 with a wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space2,space2);
		
		info("Create wiki page in space2");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,content);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		arraySpace.add(space2);
		
		/*Step Number: 1
		 *Step Name: Step 1
		 *Step Description: 
			- Go to wiki of "Space Move" 
		 *Input Data: 

		 *Expected Outcome: 
			- Wiki of "Space Move" is displayed*/
		
		/*Step Number: 2
		 *Step Name: Step 2
		 *Step Description: 
			- Go to "Page A" 
		 *Input Data: 

		 *Expected Outcome: 
			- Wiki is displaying "Page A"*/
		
		/*Step Number: 3
		 *Step Name: Step 3
		 *Step Description: 
			- Go to More Menu
			- Select Move option 
		 *Input Data: 

		 *Expected Outcome: 
			- Move popup is displayed*/
		info("Open Move popup");
		wHome.goToMovePageForm();
		
		/*Step Number: 4
		 *Step Name: Step 4
		 *Step Description: 
			- Open the space switcher
		 *Input Data: 

		 *Expected Outcome: 
			- Space switcher is displaying the list of wikis*/
		info("Open the space switcher");
		wikiMg.goToSpaceSwitcher();
		
		/*Step Number: 5
		 *Step Name: Step 5
		 *Step Description: 
			- Click outside from the space switcher list
		 *Input Data: 

		 *Expected Outcome: 
			- Space switcher is closed and is displaying "Space Move"
			- Destination container is not changed*/
		waitForAndGetElement(wHome.ELEMENT_MOVE_PAGE_SPACE_SWITCHER_DROP_DOWN_VALUE_SELECTED
				.replace("$destination",space2));
	}
	
	/**
	 *<li> Case ID:139579.</li>
	 *<li> Test Case Name:Selecting a space with the space switcher should feed the destination container.</li>
	 *<li> Pre-Condition: 
	 	User is member of space : "Space Move", "Space Destination"
	 	Wiki of "Space Move" contains a page "Page A".</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test05_SelectingASpaceWithSpaceSwitcherShouldFeedTheDestinationContainer() {	
		info("Test 5: Selecting a space with the space switcher should feed the destination container");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content2 =  txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 =  txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		info("Create data test");
		info("Create Space 1 with a wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		
		info("Create wiki page in space1");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,content1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arraySpace.add(space1);
		
		
		info("Create Space 2 with a wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space2,space2);
		
		info("Create wiki page in space2");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title2,content2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arraySpace.add(space2);
		
		/*Step Number: 1
		 *Step Name: Step 1
		 *Step Description: 
			- Go to wiki of "Space Move" 
		 *Input Data: 

		 *Expected Outcome: 
			- Wiki of "Space Move" is displayed*/
		
		/*Step Number: 2
		 *Step Name: Step 2
		 *Step Description: 
			- Go to "Page A" 
		 *Input Data: 

		 *Expected Outcome: 
			- Wiki is displaying "Page A"*/
		
		/*Step Number: 3
		 *Step Name: Step 3
		 *Step Description: 
			- Go to More Menu
			- Select Move option 
		 *Input Data: 

		 *Expected Outcome: 
			- Move popup is displayed*/
		info("Open Move popup");
		wHome.goToMovePageForm();
		
		/*Step Number: 4
		 *Step Name: Step 4
		 *Step Description: 
			- On the space switcher, select "Space Destination"
		 *Input Data: 

		 *Expected Outcome: 
			- Space switcher is closed and is displaying "Space Destination"
			- Destination container has been update with the wiki tree of "Space Destination"*/
		info("Open the space switcher");
		wikiMg.goToSpaceSwitcher();
		wikiMg.selectSpaceDestination(space1);
	}
	
	/**
	 *<li> Case ID:139581.</li>
	 *<li> Test Case Name:Space switcher must show the currently browsed space.</li>
	 *<li> Pre-Condition: User is member of Space "Space Move".</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test06_SpaceSwitcherMustShowTheCurrentlyBrowsedSpace() {	
		info("Test 6: Space switcher must show the currently browsed space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 =  txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		info("Create data test");
		info("Create Space 1 with a wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		
		/*Step Number: 1
		 *Step Name: Step 1
		 *Step Description: 
			- Go to the wiki of the "Space Move"
		 *Input Data: 

		 *Expected Outcome: 
			- Wiki is displayed*/
		
		/*Step Number: 2
		 *Step Name: Step 2
		 *Step Description: 
			- Create a new Page with the title Page A 
			- Save
		 *Input Data: 

		 *Expected Outcome: 
			- Page A is displayed*/
		info("Create wiki page in space1");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,content1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arraySpace.add(space1);
		
		/*Step Number: 3
		 *Step Name: Step 3
		 *Step Description: 
			- Click on More Menu
		 *Input Data: 

		 *Expected Outcome: 
			- Move option is available*/
		
		/*Step Number: 4
		 *Step Name: Step 4
		 *Step Description: 
			- Click on Move options
		 *Input Data: 

		 *Expected Outcome: 
			- A popup is displayed with the space switcher
			- Space switcher is displaying "Space Move"
			- Wiki tree of "Space Move" is displayed in destination container*/
		info("Open Move popup");
		wHome.goToMovePageForm();
		info("Open the space switcher");
		wikiMg.goToSpaceSwitcher();
		wValidate.verifyPresentSpaceSwitcher(space1);
	}

}
