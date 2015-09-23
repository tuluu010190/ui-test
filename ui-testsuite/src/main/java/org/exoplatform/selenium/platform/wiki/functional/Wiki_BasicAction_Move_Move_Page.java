package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.alignType;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.attachedFileTabType;
import org.exoplatform.selenium.platform.wiki.WikiPermission.permissionType;
//import org.exoplatform.selenium.platform.wiki.WikiManagement.alignType;
import org.testng.annotations.Test;

public class Wiki_BasicAction_Move_Move_Page extends WIKI_TestConfig{
	
	/**
	 *<li> Case ID:139576.</li>
	 *<li> Test Case Name: Page's attachments should be move with the page.</li>
	 *<li> Pre-Condition: User is member of "Space Move" and "Space Destination 2"
     Wiki of "Space Move" has:
        - Page A
        - Page B
        - Page with attachments (with two images in its content)
     Wiki of "Space Destination 2" is empty.</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_PageAttachmentShouldBeMoveWithThePage() {
		info("Test 1: Page's attachments should be move with the page");
		
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content =  txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		String link1 = attFileData.getAttachFileByIndex(95);
		System.out.println(link1);
		
		String link2 = attFileData.getAttachFileByIndex(96);
		System.out.println(link2);
		
		String linkImage1 = imgLinkData.getDataContentByArrayTypeRandom(1);
		String altText1=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String linkImage2 = imgLinkData.getDataContentByIndex(1);
		String altText2=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String width="200";
		String height="200";
		
		info("Create data test");
		info("Create Space 1 with a wiki page 1");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		info("Create wiki page with 2 images attachment and 2 images inserted to Space 1");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,content);
		info("insert image 1 to page");
		richEditor.insertExternalImageLink(linkImage1, width, height, altText1);
		richEditor.selectAlign(alignType.Left);
		richEditor.goToInsertImage();
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("insert image 2 to page");
		wHome.goToEditPage();
		richEditor.insertExternalImageLink(linkImage2, width, height, altText2);
		richEditor.selectAlign(alignType.Left);
		richEditor.goToInsertImage();
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("Attach 2 images to page");
		wHome.goToEditPage();
		info("Upload link to wiki page");
		wikiMg.goToSourceEditor();
		sourceEditor.attachFileInWiki("TestData/"+link1, 2);
		sourceEditor.attachFileInWiki("TestData/"+link2, 2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		arraySpace.add(space1);
		
		info("Create Space 2 with no wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space2,space2);
		arraySpace.add(space2);
		/*Step Number: 1
		 *Step Name: Step 1: Select a wiki page of a space
		 *Step Description: 
			- Go to a space, then select [Wiki]
			- Select a "Page with attachments"
		 *Input Data: 

		 *Expected Outcome: 
			- "Page with attachments" is displayed*/ 
		info("Verify 2 images are displayed in content od wiki page");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wValidate.verifyTitleWikiPage(title);
		wHome.goToAPage(title);
		wValidate.verifyAltTextImageInContentPage(altText1);
		wValidate.verifyAltTextImageInContentPage(altText2);
		info("2 inserted images are inserted successfully in content of page");
		info("Verify 2 images are displayed in attach list of wiki page");
		wHome.goToAttachFiles("2");
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link1, true);
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link2, true);
		info("2 attached images are attached successfully in attache list of page");
		
		/*Step Number: 2
		 *Step Name: Step 2: Move page
		 *Step Description: 
			- Click [More]
			- Select [Move Page] from the drop-down menu
		 *Input Data: 

		 *Expected Outcome: 
			- The popup to move the page is displayed*/
		/*Step Number: 2
		 *Step Name: Step 2: Move page
		 *Step Description: 
			- Click [More]
			- Select [Move Page] from the drop-down menu
		 *Input Data: 

		 *Expected Outcome: 
			- The popup to move the page is displayed*/
		/*Step Number: 3
		 *Step Name: Step 3: Select destination
		 *Step Description: 
			- Open Space switcher 
	 		- Select "Space Destination 2"
	 		- In destination container select "Wiki Home"
		 *Input Data: 

		 *Expected Outcome: 
			- The destination container is displaying "Space Destination 2" tree
	 		- New Location Path is displaying :
				Space Destination 2> Wiki Home*/
		/*Step Number: 4
		 *Step Name: Step 4. Do "Move"Step 4: Select destination
		 *Step Description: 
			- Click the [Move] button
		 *Input Data: 

		 *Expected Outcome: 
			- "Page with attachments" is moved in the space "Space Destination 2" and directly displayed*/
		info("Move wiki page to space 2");
		wikiMg.movePageDiffDestination(title,"Wiki Home",space2);
		info("Check to make sure wiki page does not exist in Space 1");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wValidate.verifyWikiPageNotDisplayedInWikiHome(title);
		info("Wiki page does not exist in Space 1");
		
		info("Check to make sure wiki page exists in Space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space2, "");
		spaMg.goToSpace(space2);
		spaHome.goToWikiTab();
		wValidate.verifyTitleWikiPage(title);
		
		/*Step Number: 5
		 *Step Name: Step 5. Check
		 *Step Description: 
			- Check content of the wiki page
		 *Input Data: 

		 *Expected Outcome: 
			Page content is correctly displayed with the attachments*/
		wHome.goToAPage(title);
		wValidate.verifyAltTextImageInContentPage(altText1);
		wValidate.verifyAltTextImageInContentPage(altText2);
		wHome.goToAttachFiles("2");
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link1, true);
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link2, true);
	}
	
	/**
	 *<li> Case ID:139577.</li>
	 *<li> Test Case Name: Page's sub-pages and attachments should be moved with the page.</li>
	 *<li> Pre-Condition: User is member of "Space Move" and "Space Destination 2"
     Wiki of "Space Move" has:
         - Page A
         - Page B
         - Page with Sub-Pages
                --- Sub-Page with attachments 1 (two images in its content)
                --- Sub-Page with attachments 2 (two files as attachments)
     Wiki of "Space Destination 2" has:
         - Page with attachments (with two images in its content)</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test02_PageSubpageAndAttachmentsShouldBeMovedWithThePage() {
		info("Test 2: Page's sub-pages and attachments should be moved with the page.");
		
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String wiki = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String wiki1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String wiki2 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		String wiki3 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		String link1 = attFileData.getAttachFileByArrayTypeRandom(1);
		System.out.println(link1);
		
		String link2 = attFileData.getAttachFileByArrayTypeRandom(2);
		System.out.println(link2);
		
		String linkImage1 = imgLinkData.getDataContentByArrayTypeRandom(1);
		String altText1=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String linkImage2 = imgLinkData.getDataContentByIndex(1);
		String altText2=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String width="200";
		String height="200";
		
		info("Create data test");
		info("Create Space 1 with 1 wiki page and 2 sub pages");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		info("Create wiki page");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki,wiki);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki);
		
		info("Create a sub page 1");
		wHome.goToAddBlankPage();
		wikiMg.goToRichTextEditor();
		richEditor.addSimplePage(wiki1,wiki1);
		
		info("insert image 1 to page 1");
		richEditor.insertExternalImageLink(linkImage1, width, height, altText1);
		richEditor.selectAlign(alignType.Left);
		richEditor.goToInsertImage();
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		
		info("insert image 2 to page 1");
		wHome.goToEditPage();
		richEditor.insertExternalImageLink(linkImage2, width, height, altText2);
		richEditor.selectAlign(alignType.Left);
		richEditor.goToInsertImage();
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki1);
		
		info("Create a sub page 2");
		wHome.goToAPage(wiki);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki2,wiki2);
		
		info("Attach 2 files for sub page 2");
		wikiMg.goToSourceEditor();
		sourceEditor.attachFileInWiki("TestData/"+link1, 2);
		sourceEditor.attachFileInWiki("TestData/"+link2, 2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki2);
		arraySpace.add(space1);

		
		info("Create Space 2 with 1 wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space2,space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		wikiMg.goToRichTextEditor();
		richEditor.addSimplePage(wiki3,wiki3);
		
		info("insert image 1 to page 3");
		richEditor.insertExternalImageLink(linkImage1, width, height, altText1);
		richEditor.selectAlign(alignType.Left);
		richEditor.goToInsertImage();
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		
		info("insert image 2 to page 3");
		wHome.goToEditPage();
		richEditor.insertExternalImageLink(linkImage2, width, height, altText2);
		richEditor.selectAlign(alignType.Left);
		richEditor.goToInsertImage();
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki3);
		arraySpace.add(space2);
		
		/*Step Number: 1
		 *Step Name: Step 1
		 *Step Description: 
			- Go to "Space Move" wiki
			- Select "Page with Sub-Pages"
		 *Input Data: 

		 *Expected Outcome: 
			- "Page with Sub-Pages" is displayed*/ 
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAPage(wiki);
		
		info("Verify 2 sub pages are in page wiki");
		wValidate.verifyTitleWikiPage(wiki1);
		wValidate.verifyTitleWikiPage(wiki2);
		
		info("Verify 2 inserted images to sub pages 1 ");
		wHome.goToAPage(wiki1);
		wValidate.verifyAltTextImageInContentPage(altText1);
		wValidate.verifyAltTextImageInContentPage(altText2);
		info("2 inserted images are inserted successfully in content of page 1");
		
		info("Verify 2 images are displayed in attach list of wiki page 2");
		wHome.goToAPage(wiki2);
		wHome.goToAttachFiles("2");
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link1, true);
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link2, true);
		info("2 attached images are attached successfully in attache list of page 2");
		
		/*Step Number: 2
		 *Step Name: Step 2:
		 *Step Description: 
			- Open "Edit" Menu
			- Select "Move"
		 *Input Data: 

		 *Expected Outcome: 
			- The popup to move the page is displayed*/
		/*Step Number: 3
		 *Step Name: Step 3:
		 *Step Description: 
			- Open Space switcher 
			- Select "Space Destination 2"
		 *Input Data: 

		 *Expected Outcome: 
			- The destination container is displaying "Space Destination 2" tree*/
		/*Step Number: 4
		 *Step Name: Step 4:
		 *Step Description: 
			- In destination container select "Wiki Home"
		 *Input Data: 

		 *Expected Outcome: 
			- New Location Path is displaying : Space Destination 2 > Wiki Home*/
		/*Step Number: 5
		 *Step Name: Step 5
		 *Step Description: 
			- Click on Move Button
		 *Input Data: 

		 *Expected Outcome: 
			"Page to with Sub-Pages" is moved in the space "Space Destination 2" and directly displayed*/
		info("Move wiki page to space 2");
		wHome.goToAPage(wiki);
		wikiMg.movePageDiffDestination(wiki,"Wiki Home",space2);
		
		info("Check to make sure wiki page does not exist in Space 1");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wValidate.verifyWikiPageNotDisplayedInWikiHome(wiki);
		info("Wiki page does not exist in Space 1");
		
		info("Check to make sure wiki page exists in Space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space2, "");
		spaMg.goToSpace(space2);
		spaHome.goToWikiTab();
		wValidate.verifyTitleWikiPage(wiki);
		info("Wiki page exists in Space 2");
		
		/*Step Number: 6
		 *Step Name: Step 6
		 *Step Description: 
			- Check content of the "Sub-Page with attachments 1"
		 *Input Data: 

		 *Expected Outcome: 
			Page content is correctly displaying 2 images previously displayed*/
		wHome.goToAPage(wiki);
		wValidate.verifyTitleWikiPage(wiki1);
		wValidate.verifyTitleWikiPage(wiki2);
		wHome.goToAPage(wiki1);
		wValidate.verifyAltTextImageInContentPage(altText1);
		wValidate.verifyAltTextImageInContentPage(altText2);
		
		/*Step Number: 7
		 *Step Name: Step 7
		 *Step Description: 
			- Check content of the "Sub-Page with attachments 2"
		 *Input Data: 

		 *Expected Outcome: 
			The page has its two files attached correctly*/
		wHome.goToAPage(wiki2);
		wHome.goToAttachFiles("2");
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link1, true);
		wValidate.VerifyAttachFilesAreDisplayedInAttachListOrNot(link2, true);
	}
	
	
	
	/**
	 *<li> Case ID:139578.</li>
	 *<li> Test Case Name: Page's sub-pages should be moved with the page.</li>
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
       - Page D
              --- Sub-Page level 1
                   ------ Sub-Page level 2
                        -------- Sub-Page level 3
       - Page to move
              --- Sub-Page to move
              --- Sub-Page to move 2
                   ------ Sub-Page level 2 to move

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
      - The complex page
          --- Sub-Page level 1
               ------ Sub-Page level 2
                       -------- Sub-Page level 3</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test03_PageSubpageShouldBeMovedWithThePage() {
		info("Test 3: Page's sub-pages should be moved with the page");
		
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String wiki1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subWiki1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subWiki2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subWiki3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subWiki4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subWiki5 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String [] subwiki = {subWiki1, subWiki2, subWiki3, subWiki4, subWiki5};
		
		String wiki2 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPageLevel1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPageLevel2 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPageLevel3 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String [] subwiki2 = {subPageLevel1, subPageLevel2, subPageLevel3};
		
		String wiki3 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPage1wiki3level1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPage2wiki3level1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPagewiki3level2 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		
		String wiki4 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPage1wiki4level1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPage1wiki4level2 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPage1wiki4level3 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPage1wiki4level4 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPage1wiki4level5 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String [] subwiki4 = {subPage1wiki4level1, subPage1wiki4level2, subPage1wiki4level3, subPage1wiki4level4, subPage1wiki4level5};
		
		String wiki5 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPagewiki5Level1 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPagewiki5Level2 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String subPagewiki5Level3 = txData.getContentByArrayTypeRandom(1)+ getRandomNumber();
		String [] subwiki5 = {subPagewiki5Level1, subPagewiki5Level2, subPagewiki5Level3};
		
		info("Create data test");
		info("Create Space 1 with 3 wiki pages");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		arraySpace.add(space1);
		
		info("Create wiki page 1");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki1,wiki1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki1);
		
		info("Create 5 sub pages for wiki page 1");
		for(int i=0;i<5;i++){
			wHome.goToAPage(wiki1);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(subwiki[i],subwiki[i]);
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(subwiki[i]);
		}
		
		info("Create wiki page 2");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki2,wiki2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki2);
		
		info("Create subpages with 3 level for wiki page 2");
		for(int i = 0; i < 3; i ++){
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(subwiki2[i],subwiki2[i]);
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(subwiki2[i]);
		}
		
		info("Create wiki page 3");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki3,wiki3);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki3);

		info("Create level 1 sub page 1 for wiki page 3");
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subPage1wiki3level1,subPage1wiki3level1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subPage1wiki3level1);
		
		info("Create level 1 sub page 2 for wiki page 3");
		wHome.goToAPage(wiki3);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subPage2wiki3level1,subPage2wiki3level1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subPage2wiki3level1);
		
		info("Create level 2 for wiki page 3");
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subPagewiki3level2,subPagewiki3level2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subPagewiki3level2);
		
		info("Create Space 2 with 2 wiki pages");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space2,space2);
		arraySpace.add(space2);
		
		info("Create wiki page 4");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki4,wiki4);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki4);
		
		info("Create 5 sub pages for wiki page 4");
		for(int i=0;i<5;i++){
			wHome.goToAPage(wiki4);
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(subwiki4[i],subwiki4[i]);
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(subwiki4[i]);
		}
		
		info("Create wiki page 5");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki5,wiki5);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki5);
		
		info("Create subpages with 3 level for wiki page 5");
		for(int i = 0; i < 3; i ++){
			wHome.goToAddBlankPage();
			richEditor.addSimplePage(subwiki5[i],subwiki5[i]);
			wikiMg.saveAddPage();
			Utils.pause(2000);
			wValidate.verifyTitleWikiPage(subwiki5[i]);
		}
		
		/*Step Number: 1
		 *Step Name: Step 1
		 *Step Description: 
			- Go to "Space Move" wiki
			- Select "Page to move"
		 *Input Data: 

		 *Expected Outcome: 
			- "Page to move" is displayed*/ 
		
		/*Step Number: 2
		 *Step Name: Step 2
		 *Step Description: 
			- Click on More Menu
			- Select Move Option
		 *Input Data: 

		 *Expected Outcome: 
			- The popup to move a page is displayed*/
		
		/*Step Number: 3
		 *Step Name: Step 3
		 *Step Description: 
			- Open Space switcher 
			- Select "Space Destination"
		 *Input Data: 

		 *Expected Outcome: 
			- The destination container is displaying "Space Destination" tree*/
		
		/*Step Number: 4
		 *Step Name: Step 4
		 *Step Description: 
			- In destination container select "Wiki Home"
		 *Input Data: 

		 *Expected Outcome: 
			- New Location Path is displaying : Space Destination > Wiki Home*/
		
		/*Step Number: 5
		 *Step Name: Step 5
		 *Step Description: 
			- Click on Move Button
		 *Input Data: 

		 *Expected Outcome: 
			"Page to move" is moved in the space "Space Destination"*/
		info("Move 3 wiki pages from space 1 to space 2");
		info("Move wiki page 1 to space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAPage(wiki1);
		wikiMg.movePageDiffDestination(wiki1,"Wiki Home",space2);
		
		info("Move wiki page 2 to space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAPage(wiki2);
		wikiMg.movePageDiffDestination(wiki2,"Wiki Home",space2);
		
		info("Move wiki page 3 to space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAPage(wiki3);
		wikiMg.movePageDiffDestination(wiki3,"Wiki Home",space2);
		
		
		info("Check to make sure wiki page 1 does not exist in Space 1");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wValidate.verifyWikiPageNotDisplayedInWikiHome(wiki1);
		info("Wiki page 1 does not exist in Space 1");
		
		info("Check to make sure wiki page 2  does not exist in Space 1");
		wValidate.verifyWikiPageNotDisplayedInWikiHome(wiki2);
		info("Wiki page 2 does not exist in Space 1");
		
		info("Check to make sure wiki page 3  does not exist in Space 1");
		wValidate.verifyWikiPageNotDisplayedInWikiHome(wiki3);
		info("Wiki page 3 does not exist in Space 1");
		
		info("Check to make sure wiki page 1 and sub pages exist in Space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space2, "");
		spaMg.goToSpace(space2);
		spaHome.goToWikiTab();
		wValidate.verifyTitleWikiPage(wiki1);
		wHome.goToAPage(wiki1);
		for (int i = 0; i < 5; i ++)
			wValidate.verifyTitleWikiPage(subwiki[i]);
		info("Wiki page 1 and subpages exist in Space 2");
		
		info("Check to make sure wiki page 2 and sub pages exist in Space 2");
		wHome.goToHomeWikiPage();
		wValidate.verifyTitleWikiPage(wiki2);
		wHome.goToAPage(wiki2);
		for (int i = 0; i < 3; i ++){
			wValidate.verifyTitleWikiPage(subwiki2[i]);
			wHome.goToAPage(subwiki2[i]);
		}
		info("Wiki page 2 and sub pages exist in Space 2");
		
		info("Check to make sure wiki page 3 and sub pages exist in Space 2");
		wHome.goToHomeWikiPage();
		wValidate.verifyTitleWikiPage(wiki3);
		wHome.goToAPage(wiki3);
		wValidate.verifyTitleWikiPage(subPage1wiki3level1);
		wValidate.verifyTitleWikiPage(subPage2wiki3level1);
		wHome.goToAPage(subPage2wiki3level1);
		wValidate.verifyTitleWikiPage(subPagewiki3level2);
		info("Wiki page 2 ans sub pages exist in Space 2");
	}
	
	/**
	 *<li> Case ID:139580.</li>
	 *<li> Test Case Name: Space names displayed in location labels should be user friendly and not technical.</li>
	 *<li> Pre-Condition: User is member of "Space Move" and "Space Destination 2"
     Wiki of "Space Move" has:
        - Page B</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_SpaceNamesDisplayedInLocationLabelsShouldBeUserFriendlyAndNotTechnical() {
		info("Test 4: Space names displayed in location labels should be user friendly and not technical");
		
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String wiki1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		info("Create data test");
		info("Create Space 1 with 1 wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space1,space1);
		arraySpace.add(space1);
		
		info("Create wiki page 1");
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki1,wiki1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki1);
		
		info("Create Space 2 with no wiki page");
		hp.goToMySpaces();
		spaMg.addNewSpaceSimple(space2,space2);
		arraySpace.add(space2);
		
		/*Step Number: 1
		 *Step Name: Step 1
		 *Step Description: 
			- Go to "Space Move" wiki
			- Select "Page to move"- Go to "Space Move" using left side bar navigation
			- Open wiki application
			- Open "Page B"
		 *Input Data: 

		 *Expected Outcome: 
			- "Page B" is displayed
			- Space navigation of "Space Move" is displayed */ 
		
		/*Step Number: 2
		 *Step Name: Step 2
		 *Step Description: 
			- Open "More" Menu
			- Select "Move"
		 *Input Data: 

		 *Expected Outcome: 
			- The popup to move the page is displayed
			- Current location label is displaying : Space Move > Page B*/
		
		/*Step Number: 3
		 *Step Name: Step 3
		 *Step Description: 
			- Open Space switcher 
			- Select "Space Destination 2"
		 *Input Data: 

		 *Expected Outcome: 
			- The destination container is displaying "Space Destination 2" tree*/
		
		/*Step Number: 4
		 *Step Name: Step 4
		 *Step Description: 
			- In destination container select "Wiki Home"
		 *Input Data: 

		 *Expected Outcome: 
			- New Location Path is displaying : Space Destination 2 > Wiki Home*/
		
		info("Move wiki page from space 1 to space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		
		info("Move wiki page 1 to space 2");
		wHome.goToAPage(wiki1);
		wikiMg.movePageDiffDestination(wiki1,"Wiki Home",space2, true);
		
		info("Check to make sure wiki page 1 does not exist in Space 1");
		hp.goToMySpaces();
		spaMg.searchSpace(space1, "");
		spaMg.goToSpace(space1);
		spaHome.goToWikiTab();
		wValidate.verifyWikiPageNotDisplayedInWikiHome(wiki1);
		info("Wiki page 1 does not exist in Space 1");
		
		info("Check to make sure wiki page 1 exist in Space 2");
		hp.goToMySpaces();
		spaMg.searchSpace(space2, "");
		spaMg.goToSpace(space2);
		spaHome.goToWikiTab();
		wValidate.verifyTitleWikiPage(wiki1);
		info("Wiki page 1 exist in Space 2");
	}
	
	/**
	 *<li> Case ID:139429.</li>
	 *<li> Test Case Name: Move a page when user does not have edit permission on destination page.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test05_MoveAPageWhenUserDoesNotHaveEditPermissionOnDestinationPage() {
		info("Test 5: Move a page when user does not have edit permission on destination page");
		
		String wiki1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String wiki2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		info("Create data test");
		info("Create wiki page 1 with full permission");
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki1,wiki1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki1);
		arrayPage.add(wiki1);
		
		info("add Edit Permission for Mary in wiki page 1");
		wHome.goToPermissions();
		wPermission.addPermisisonByType(DATA_USER2);
		wPermission.selectPermission(DATA_USER2, permissionType.Edit_Pages);
		wPermission.savePermisison();
		
		/*Step Number: 1
		 *Step Name: Step 1: Create a page
		 *Step Description: 
			- Click [Add Page] --> [Blank Page]/[From Template...]
	 		- Put title, content
			- Click [Save]
		 *Input Data: 

		 *Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successfully*/
		info("Create wiki page 2");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki2,wiki2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki2);
		arrayPage.add(wiki2);
		
		/*Step Number: 2
		 *Step Name: Step 2: Set permission for page
		 *Step Description: 
			- Select page above
			- Click [More] -->  [Page Permissions] to set permissions for this page 
			that some users/groups can not edit this page
		 *Input Data: 

		 *Expected Outcome: 
			- Permissions are added to the page*/
		info("Un check edit permission of any group");
		wHome.goToPermissions();
		wPermission.addPermisisonByType(DATA_USER2);
		wPermission.unSelectPermission(DATA_USER2, permissionType.Edit_Pages);
		wPermission.savePermisison();
		
		/*Step Number: 3
		 *Step Name: Step 3: Open form to move page
		 *Step Description: 
			- Login by any user who does not have permission to edit page
			- Select a page that user have edit permission
			- Click on [More] -> [Move Page] 
		 *Input Data: 

		 *Expected Outcome: 
			- Form to move page appears. User can see 
			at the step 1. But when click "Move" buton, popup with 
			content "You have no edit permission at the destination 
			page" appears*/
		info("Log in as Mary");
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToWiki();
		
		info("Move wiki page 1 to page 2");
		wHome.goToAPage(wiki1);
		wikiMg.movePageWhenUserDoesNotHavePerMissionInDestination(wiki1, wiki2, true);
	}
	
	/**
	 *<li> Case ID:139430.</li>
	 *<li> Test Case Name: Move a page when user doesn't have edit permission on page.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test06_MoveAPageWhenUserDoesNotHaveEditPermissionOnPage() {
		info("Test 6: Move a page when user doesn't have edit permission on page");
		
		String wiki1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		 *Step Name: Step 1: Create a page
		 *Step Description: 
			- Click [Add Page] --> [Blank Page]/[From Template...]
	 		- Put title, content
			- Click [Save]
		 *Input Data: 

		 *Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successfully*/
		info("Create wiki page 1 with full permission");
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki1,wiki1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki1);
		arrayPage.add(wiki1);
		
		/*Step Number: 2
		 *Step Name: Step 2: Set permission for page
		 *Step Description: 
			- Select page above
			- Click [More] -->  [Page Permissions] to set permission for this page 
			that some users/groups can not edit this page
		 *Input Data: 

		 *Expected Outcome: 
			- Permissions are added to the page*/
		info("Un check edit permission of any group");
		wikiMg.unCheckViewAUserOfPage(wHome.ELEMENT_PERMISSION_EDIT_ANY);
		
		/*Step Number: 3
		 *Step Name: Step 3: Open form to move page
		 *Step Description: 
			- Login by any user who does not have permission to edit page
			- Select the page at step 1
			- Click on [More]  
		 *Input Data: 

		 *Expected Outcome: 
			- Move Page action is not displayed*/
		info("Log in as Mary");
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToWiki();
		
		info("Move wiki page 1 to page 2");
		wHome.goToAPage(wiki1);
		wikiMg.movePageWhenUserDoesNotHavePerMissionInDestination(wiki1, "", false);
	}
	
	/**
	 *<li> Case ID:139431.</li>
	 *<li> Test Case Name: Move a page when user have edit permission on page.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test07_MoveAPageWhenUserHasEditPermissionOnPage() {
		info("Test 7: Move a page when user have edit permission on page");
		
		String wiki1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String wiki2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		 *Step Name: Step 1: Create a page
		 *Step Description: 
			- Click [Add Page] --> [Blank Page]/[From Template...]
	 		- Put title, content
			- Click [Save]
		 *Input Data: 

		 *Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- New page is created successfully*/
		
		/*Step Number: 2
		 *Step Name: Step 2: Set permission for page
		 *Step Description: 
			- Select page above
			- Click [More] -->  [Page Permissions] to set permission for this page 
			that any user/group can edit this page
		 *Input Data: 

		 *Expected Outcome: 
			Page is added permission*/
		info("Create wiki page 1 with full permission");
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki1,wiki1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki1);
		arrayPage.add(wiki1);
		
		info("add Edit Permission for Mary in wiki page 1");
		wHome.goToPermissions();
		wPermission.addPermisisonByType(DATA_USER2);
		wPermission.selectPermission(DATA_USER2, permissionType.Edit_Pages);
		wPermission.savePermisison();
		
		info("Create wiki page 2 with full permission");
		wHome.goToHomeWikiPage();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(wiki2,wiki2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(wiki2);
		arrayPage.add(wiki2);
		
		info("add Edit Permission for Mary in wiki page 2");
		wHome.goToPermissions();
		wPermission.addPermisisonByType(DATA_USER2);
		wPermission.selectPermission(DATA_USER2, permissionType.Edit_Pages);
		wPermission.savePermisison();
		
		/*Step Number: 3
		 *Step Name: Step 3: Open form to move page
		 *Step Description: 
			- Login by any user
			- Select page at step 1
			- Click on [More] --> [Move Page]
		 *Input Data: 

		 *Expected Outcome: 
			- Form to move page appears*/
		
		/*Step Number: 4
		 *Step Name: Step 4: Move page
		 *Step Description: 
			- Select the destination page
			- Click on Move
		 *Input Data: 

		 *Expected Outcome: 
			New page is moved to the destination page*/
		
		info("Log in as Mary");
		magAc.signIn(DATA_USER2, DATA_PASS);
		hp.goToWiki();
		
		info("Move wiki page 1 to page 2");
		wHome.goToAPage(wiki1);
		wikiMg.movePage(wiki1, wiki2);
		
		info("Check to make sure wiki page 1 does not exist in wiki home");
		wHome.goToHomeWikiPage();
		wValidate.verifyWikiPageNotDisplayedInWikiHome(wiki1);
		info("Check to make sure wiki page 1 exists under wiki page 2");
		wHome.goToAPage(wiki2);
		wValidate.verifyTitleWikiPage(wiki1);
	}

	/**
	*<li> Case ID:139571.</li>
	*<li> Test Case Name: Check Redirection after a move to another space.</li>
	*<li> Pre-Condition: User is member of "Space Move" and "Space Destination 2"
	Wiki of "Space Move" has:
	- Page A
	- Page B
	
	
	Wiki of "Space Destination 2" has:
	- Page with attachments (with two images in its content)
	- Page with Sub-Pages
	--- Sub-Page with attachments 1 (two images in its content)
	--- Sub-Page with attachments 2 (two files as attachments)</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CheckRedirectionAfterAMoveToAnotherSpace() {
		info("Test 15 Check Redirection after a move to another space");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Go to "Space Move" using left side bar navigation
			- Open wiki application
			- Open "Page A"
		*Input Data: 
			
		*Expected Outcome: 
			- "Page A" is displayed
			- Space navigation of "Space Move" is displayed*/
		info("Create a space 1: moving space");
		String space1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space1,space1,6000);
		Utils.pause(2000);
		
		info("Create Page on the space");
		String page=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		info("Create page A");
		hp.goToSpecificSpace(space1);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page,page);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(page);
	
		info("Create a space 2: destination space");
		String space2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToAllSpace();
		spaMg.addNewSpaceSimple(space2,space2,6000);
		Utils.pause(2000);
	
		info("Create pages and sub-pages for space 2");
		String page1=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subPage1 =txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String subPage2 =txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String image1 = attFileData.getAttachFileByArrayTypeRandom(26);
		String image2 = attFileData.getAttachFileByArrayTypeRandom(27);
		String file1 = attFileData.getAttachFileByArrayTypeRandom(1);
		String file2 = attFileData.getAttachFileByArrayTypeRandom(2);
		info("Create page");
		hp.goToSpecificSpace(space2);
		spaHome.goToWikiTab();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(page1,"");
		info("Insert image 1");
		richEditor.goToAttachedImageLink();
		richEditor.insertImage("TestData/"+image1,true);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(page1);
		
		info("Insert image 2");
		wHome.goToAPage(page1);
		wHome.goToEditPage();
		richEditor.goToAttachedImageLink();
		richEditor.insertImage("TestData/"+image2,true);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(page1);
		
		info("Create sub page1");
		wHome.goToAPage(page1);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subPage1,"");
		info("Insert file 1");
		richEditor.insertAttachedFileLink("",file1,"", attachedFileTabType.Current_page);
		wValidate.verifyInsertedLinkIntoFrame(file1,"");
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subPage1);
		
		info("Insert file 2");
		wHome.goToAPage(subPage1);
		wHome.goToEditPage();
		richEditor.insertAttachedFileLink("",file2,"", attachedFileTabType.Current_page);
		wValidate.verifyInsertedLinkIntoFrame(file2,"");
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subPage1);
		
		
		info("Create sub page2");
		wHome.goToAPage(page1);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(subPage2,"");
		info("Insert image 1");
		richEditor.goToAttachedImageLink();
		richEditor.insertImage("TestData/"+image1,true);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subPage2);
		
		info("Insert image 2");
		wHome.goToAPage(subPage2);
		wHome.goToEditPage();
		richEditor.goToAttachedImageLink();
		richEditor.insertImage("TestData/"+image2,true);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(subPage2);
	
		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Open "More" Menu
			- Select "Move Page"
		*Input Data: 
			
		*Expected Outcome: 
			- The popup to move the page is displayed*/
	
		/*Step number: 3
		*Step Name: 
		*Step Description: 
			- Open Space switcher 
			- Select "Space Destination 2"
		*Input Data: 
			
		*Expected Outcome: 
			- The destination container is displaying "Space Destination 2" tree*/
	
		/*Step number: 4
		*Step Name: 
		*Step Description: 
			- In destination container select "Wiki Home"
		*Input Data: 
			
		*Expected Outcome: 
			- New Location Path is displaying :Space Destination 2 > Wiki Home*/
	
		/*Step number: 5
		*Step Name: 
		*Step Description: 
			- Click on Move Button
		*Input Data: 
			
		*Expected Outcome: 
			- "Page A" is moved in the space "Space Destination" 
			- "Page A" is automatically displayed in "Space Destination 2" :
			- Breadcrumb is displaying :Space Destination 2 > Wiki Home > Page A
			- Space Navigation of "Space Destination 2" is displayed*/ 
		info("Move page of space 1 to Wiki Home of space 2");
		hp.goToSpecificSpace(space1);
		spaMg.goToWikiTab();
		wikiMg.movePageDiffDestination(page,"Wiki Home",space2);
		
		info("[Page] is moved in space2");
		wValidate.verifyTitleWikiPage(page);
		info("Breadcrumb is displaying :Space2 > Wiki Home >"+page);
		wValidate.verifyBreadCrumbePath(space2,"Wiki Home",page);
		info("Space Navigation is not displayed anymore");
		waitForElementNotPresent(spaHome.ELEMENT_SPACE_WIKI_TAB);
	
	}
}
