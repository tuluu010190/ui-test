package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.alignType;
import org.testng.annotations.Test;

public class Wiki_BasicAction_Add_Draft_Others_Template extends WIKI_TestConfig{
	
	/**
	*<li> Case ID:118451.</li>
	*<li> Test Case Name: Add a page with link wiki page existed.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ViewADraftForAnotherUser() {
		info("Test 1: View a draft for another user");
		/*Step Number: 1
		*Step Name: Step 1: 
		*Step Description: 
			- Connect with the user A
			- Go to [Intranet] --> [Wiki]
			- Click [Add Page] --> [Blank Page]/[From Template...]
			- Enter the required fields without saving for 30s
		*Input Data: 
			
		*Expected Outcome: 
			The draft is saved after 30s*/
		
		info("Create a draft");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePageHasAutoSaveWithoutSave(title, content);
		
		info("Verify draft exists in draft list");
		wHome.goToMyDraft();
		wValidate.verifyDraftExistsInDraftListOrNot(title, true);
		arrayDraft.add(title);
		
		/*Step Number: 2
		*Step Name: Step 2: 
		*Step Description: 
			- Connect with the user B
			- Go to [Intranet] --> [Wiki]
			- From the menu "Browse", choose "My drafts"
		*Input Data: 
			
		*Expected Outcome: 
			The draft created by the user A doesn't appear in the list of drafts of the user B*/
		info("Sign in with Mary");
		magAc.signIn(DATA_USER2, DATA_PASS);
		info("Go to Myfraft and verify that draft created in step 1 does not exist in draft list");
		hp.goToWiki();
		wHome.goToMyDraft();
		wValidate.verifyDraftExistsInDraftListOrNot(title, false);
		
		info("Clear Data");
		info("Sign in as John");
		magAc.signIn(DATA_USER1, DATA_PASS);
 	}
	
	/**
	*<li> Case ID:118333.</li>
	*<li> Test Case Name: Preview a page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_PreviewAPage() {
		info("Test 2: Preview a page");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] --> [Blank Page]/[From Template...]
		*Input Data: 
			
		*Expected Outcome: 
			Form to create new page is shown and in the [Rich Text] editor*/
		info("Go to Add a Wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		
		/*Step Number: 2
		*Step Name: Step 2: Create new page
		*Step Description: 
			- Put the title for this page
			- Put the content of page

		*Input Data: 
			
		*Expected Outcome: 
			All fields are inputed with values*/
		richEditor.addSimplePage(title, content);
		
		/*Step Number: 3
		*Step Name: Step 3: Preview a page
		*Step Description: 
			- Click on Preview 
		*Input Data: 
			
		*Expected Outcome: 
			Content of page is shown*/
		
		wikiMg.PreviewASimplePage(title, content);
 	}
	
	/**
	*<li> Case ID:122803.</li>
	*<li> Test Case Name: Preview a page with image by another user.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_PreviewAPageWithImageByAnotherUser() {
		info("Test 3: Preview a page with image by another user");
		/*Step Number: 1
		*Step Name: Step 1: Add Wiki page with external image with Admin User
		*Step Description: 
			- Go to [Intranet] --> [Wiki]
			- Click [Add Page] --> [Blank Page]/[From Template...]
			- Ensure the page is in the [Rich Text] mode
			- Input data valid for Title page and Page's content
			- Click Image in menu
			- Select [External Image...]
			- Type or paste the address of the image to insert, e.g. 'www.example.com/image.png'
			- Click [Image Settings]
			- Type the width/height of the image
			- Choose the way the image is positioned in the text
			- Choose the way the image is vertically aligned in the line of text
			- Click [Insert Image] button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- The attached file is added successfully in content of page
			- Page is add/edited successfully*/
		info("Go to Add a Wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();	
		String linkImage = imgLinkData.getDataContentByArrayTypeRandom(1);
		String altText=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String width="200";
		String height="200";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,content);
		richEditor.insertExternalImageLink(linkImage, width, height, altText);
		richEditor.selectAlign(alignType.Left);
		richEditor.goToInsertImage();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Add attach file is added successfully in content of page");
		wHome.goToAPage(title);
	    wValidate.verifyAltTextImageInContentPage(altText);
	    
	    /*Step Number: 2
		*Step Name: Step 2: Another user can see the image inserted in page
		*Step Description: 
			- Login by user/group has permission to edit/view page
			- Go to [Intranet] --> [Wiki] 
			- Click Wiki Page created in step 1
		*Input Data: 
			
		*Expected Outcome: 
			User can see the image inserted in this wiki page.*/
	    magAc.signIn(DATA_USER2, DATA_PASS);
	    hp.goToWiki();
	    wHome.goToAPage(title);
	    wValidate.verifyAltTextImageInContentPage(altText);
	    
	    info("Clear Data");
	    magAc.signIn(DATA_USER1, DATA_PASS);
 	}
	
	/**
	*<li> Case ID:118315.</li>
	*<li> Test Case Name: Create new page using existing template.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_CreateNewPageUsingExistingTemplate() {
		info("Test 4: Create new page using existing template");
		String template1 = wTempData.getWikiTemplate(0);
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		System.out.println(template1);
		String template2 = wTempData.getWikiTemplate(1);
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		System.out.println(template2);
		String template3 = wTempData.getWikiTemplate(2);
		String title3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		System.out.println(template3);
		String template4 = wTempData.getWikiTemplate(3);
		String title4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		System.out.println(template4);
		String template5 = wTempData.getWikiTemplate(4);
		String title5 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		System.out.println(template5);
		
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] --> [From Template...]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode */
		hp.goToWiki();
		wHome.goToAddTemplateWikiPage();
	    
	    /*Step Number: 2
		*Step Name: Step 2: Create new page with Two Column layout
		*Step Description: 
			- Choose template [Two Column layout] in list and click [Select]
			- Click [Preview] if you want to see how your page looks like
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put the title for this page
			- Put the content of page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created successfully with two column layout*/
		wikiMg.addSimpleWikiPageByTemplate(template1,title1);
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
	    
		 /*Step Number: 3
		*Step Name: Step 3: Create new page with Three Column layout
		*Step Description: 
			- Choose template [Three Column layout] in list and click [Select]
			- Click [Preview] if you want to see how your page looks like.
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put the title for this page
			- Put the content of page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created successfully with three column layout*/
		hp.goToWiki();
		wHome.goToAddTemplateWikiPage();
		wikiMg.addSimpleWikiPageByTemplate(template2,title2);
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);
		
		 /*Step Number: 4
		*Step Name: Step 4: Create new page with Status Meeting layout
		*Step Description: 
			- Choose template "Status Meeting" in list and click [Select]
			- Click [Preview] if you want to see how your page looks like.
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put the title for this page
			- Put the content of page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created successfully with Status Meeting layout*/
		hp.goToWiki();
		wHome.goToAddTemplateWikiPage();
		wikiMg.addSimpleWikiPageByTemplate(template3,title3);
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title3);
		arrayPage.add(title3);
		
		 /*Step Number: 5
		*Step Name: Step 5: Create new page with HOW-TO Guide layout
		*Step Description: 
			- Choose template [HOW-TO Guide] layout in list and click [Select]
			- Click [Preview] if you want to see how your page looks like
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put the title for this page
			- Put the content of page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created successfully with HOW-TO Guide layout*/
		hp.goToWiki();
		wHome.goToAddTemplateWikiPage();
		wikiMg.addSimpleWikiPageByTemplate(template4,title4);
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title4);
		arrayPage.add(title4);
		
		/*Step Number: 6
		*Step Name: Step 6: Create new page with Leave Planning layout
		*Step Description: 
			- Choose template [Leave Planning] layout in list and click [Select]
			- Click [Preview] if you want to see how your page looks like
			- Select [Source Editor] to switch to [Source Editor] mode
			- Put the title for this page
			- Put the content of page
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			New page is created successfully with Leave Planning layout*/
		hp.goToWiki();
		wHome.goToAddTemplateWikiPage();
		wikiMg.addSimpleWikiPageByTemplate(template5,title5);
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title5);
		arrayPage.add(title5);
 	}
}
