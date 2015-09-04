package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.alignType;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.attachedFileTabType;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.wikiPageLinkTab;
import org.testng.annotations.*;


	public class Wiki_BasicAction_Add_RichText  extends WIKI_TestConfig{

	/**
	*<li> Case ID:139522.</li>
	*<li> Test Case Name: Add a page with link wiki page existed.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_AddAPageWithLinkWikiPageExisted() {
		info("Test 1: Add a page with link wiki page existed");
		/*Step Number: 1
		*Step Name: Step 1: Add a page with link wiki page
		*Step Description: 
			- Go to [Intranet] 
			-
			-> [Wiki]
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Ensure the page is in the [Rich Text]editor
			- Input data valid for Title page and Page's content
			- Click [Link] in menu
			- Select [Wiki Page]
			- Select [All pages] tab
			- Choose a page in list and click [Select]
			- Input label and tooltip for link
			- Check or uncheck [Open in new window]
			- Click [Create Link]
			- Click [Save] icon in toolbar
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- A new page is added successful and displayed with properties 
			- This page is listed with page containing the link*/
		
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
		String label = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title2,content2);
		richEditor.goToWikiPageLink();
		richEditor.insertExistWikiPageLink(title1,label,tooltip,wikiPageLinkTab.All_pages);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);

		/*Step number: 2
		*Step Name: Step 2: View link after add
		*Step Description: 
			- Click on name of link
		*Input Data: 
			
		*Expected Outcome: 
			- Page is shown successfully*/ 
		info("Page is shown successfully");
		wHome.goToAPage(title2);
		wikiMg.verifyInsertedExistLink(label,title1);

 	}

	/**
	*<li> Case ID:139523.</li>
	*<li> Test Case Name: Add a page with add new link.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_AddAPageWithAddNewLink() {
		info("Test 2: Add a page with add new link");
		/*Step Number: 1
		*Step Name: Step 1: Add a page with link wiki page
		*Step Description: 
			- Go to [Intranet] 
			-
			-> [Wiki]
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Input data valid for Title page and Page's content
			-Click [Link] in menu
			- Select a wiki page
			- Select [My recent changes]
			- Double click an item toand type the name of the page to be created.
			- Click [Link Setting]
			- Input label and tooltip for link
			- Check or uncheck [Open in new window]
			- Click Create Link
			- Click on Save icon in toolbar
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- A new page is added successful and displayed with properties 
			- This page is listed with page containing the link*/
		
		info("Create a wiki page 2");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title2,content2);
		richEditor.insertNewWikiPageLink(title1, label, tooltip, wikiPageLinkTab.My_Recent_Changes,true);
		wValidate.verifyInsertedLinkIntoFrame(label, tooltip);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);

		/*Step number: 2
		*Step Name: Step 2: View link after add
		*Step Description: 
			- Click on name of link
		*Input Data: 
			
		*Expected Outcome: 
			- Show new page with name created above and user can add content for it*/ 
		info("Show new page with name created above");
		wHome.goToAPage(title2);
		wikiMg.verifyInsertNewLink(label,title1);
		info("user can add content for it");
		wikiMg.addContentPage(content1);
		wikiMg.saveAddPage();
		info("Verify that the content is added successfully");
		wikiMg.verifyContentPage(content1);
 	}

	/**
	*<li> Case ID:139524.</li>
	*<li> Test Case Name: Search page to add link.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_SearchPageToAddLink() {
		info("Test 3: Search page to add link");
		/*Step Number: 1
		*Step Name: Step 1: Add a page with link wiki page
		*Step Description: 
			- Go to [Intranet] 
			-
			-> [Wiki]
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Ensure the page is in the [Rich Text] editor
			- Input data valid for Title page and Page's content
			- Click [Link] in menu
			- Select [Wiki Page]
			- Select [Search] tab
			- Type page name which want to search and click [Search]
			- Choose page which show in list and click Select
			- Input label and tooltip for link
			- Check or uncheck [Open in new window]
			- Click Create Link
			- Click on Save icon in toolbar
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- A new page is added successfully and displayed with properties 
			- This page is listed with page containing the link*/
		info("Create a wiki page 1");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,content1);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
		
		info("Create a wiki page 2");
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title2,content2);
		richEditor.goToWikiPageLink();
		richEditor.insertExistWikiPageLink(title1,label,tooltip,wikiPageLinkTab.Search);
		wValidate.verifyInsertedLinkIntoFrame(label, tooltip);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);

		/*Step number: 2
		*Step Name: Step 2: View link after add
		*Step Description: 
			- Click on name of link
		*Input Data: 
			
		*Expected Outcome: 
			- Show new page successfully*/ 
		info("Page is shown successfully");
		wHome.goToAPage(title2);
		wikiMg.verifyInsertedExistLink(label,title1);

 	}

	/**
	*<li> Case ID:139525.</li>
	*<li> Test Case Name: Add web page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_AddWebPage() {
		info("Test 4: Add web page");
		/*Step Number: 1
		*Step Name: Step 1: Add web page
		*Step Description: 
			- Go to [Intranet] 
			-
			-> [Wiki]
			- Click Click [Add Page] 
			-
			-> [Blank Page]
			- Input data valid for Title page and Page's content
			-Click [Link] in menu
			- Select [Web Page...]
			- Type the address of the web page to create the link to. (ex: www.google.com)
			- Input label and tooltip for link
			- Check or uncheck [Open in new window]
			- Click [Create Link]
			- Click [Save] icon in toolbar
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- A new page is added successfully and displayed with properties 
			- This page is listed with page containing the link*/
		info("Create a wiki page 2");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String address = "www.google.com";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,content1);
		richEditor.goToWebPageLink();
		richEditor.insertWebLink(address, label, tooltip,true);
		wValidate.verifyInsertedLinkIntoFrame(label, tooltip);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);

		/*Step number: 2
		*Step Name: Step 2: View link after add
		*Step Description: 
			- Click on name of link
		*Input Data: 
			
		*Expected Outcome: 
			- Show page successfully*/ 
		info("Page is shown successfully");
		wHome.goToAPage(title1);
	    wikiMg.viewInsertLink(label);
	    String titlePage = this.driver.getTitle();
	    if(titlePage.contains("Google"))
	    	assert true;
	    else assert false;

 	}

	/**
	*<li> Case ID:139526.</li>
	*<li> Test Case Name: Add attached file when exits.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_AddAttachedFileWhenExits() {
		info("Test 5: Add attached file when exits");
		/*Step Number: 1
		*Step Name: Step 1: Open attach file link form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page is in the [Rich Text] editor
			-Click [Link] in menu and select [Attached File]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Attached File form appear*/

		/*Step number: 2
		*Step Name: Step 2: Add attach file
		*Step Description: 
			- Select an attachment to link to from the list below, by clicking on name of file
			- Click [Select]
			- Input tooltip for file
			- Click [Create Link] button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The attach file is added successfully in content of page
			- Page is added/edited successfully*/
		
		info("Create a wiki page");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachedFile = attFileData.getAttachFileByArrayTypeRandom(1);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,content1);
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
			- Click on name of attach file
		*Input Data: 
			
		*Expected Outcome: 
			Show content of attach file*/ 
		info("The file is attached in the page");
		wHome.goToAPage(title1);
	    wikiMg.viewInsertLink(attachedFile);
		

 	}

	/**
	*<li> Case ID:139527.</li>
	*<li> Test Case Name: Add email address.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_AddEmailAddress() {
		info("Test 6: Add email address");
		/*Step Number: 1
		*Step Name: Step 1: Open attach file link form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page is in the [Rich Text]editor
			-Click [Link] in menu and select [Email Address]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Attached File form appears*/

		/*Step number: 2
		*Step Name: Step 2: Add attach file
		*Step Description: 
			- Type the email address you want to link to, e.g. 'example@domain.com'
			- Click [Select]
			- Input lable or tooltip for mail
			- Check or uncheck [Open in new window]
			- Click [Create Link] button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Email address is added successfully in content of page
			- Page is add/edited successfully*/
		info("Create a wiki page 2");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String label =txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String address=getRandomString()+"@gmail.com";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title1,content1);
		richEditor.insertEmailLink(address, label, tooltip,true);
		wValidate.verifyInsertedLinkIntoFrame(label, tooltip);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);

		/*Step number: 3
		*Step Name: Step 3: View attach file
		*Step Description: 
			- Move cursor on label of mail
		*Input Data: 
			
		*Expected Outcome: 
			Show mail with format mailto:email_address*/ 
		info("The file is attached in the page");
		wHome.goToAPage(title1);
	    wikiMg.verifyEmailFormatLink(address);

 	}

	/**
	*<li> Case ID:139528.</li>
	*<li> Test Case Name: Add attached file with new file.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_AddAttachedFileWithNewFile() {
		info("Test 7: Add attached file with new file");
		/*Step Number: 1
		*Step Name: Step 1: Open attach file link form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page is in the [Rich Text]editor
			-Click [Link] in menu and select [Attached File]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.
			- Attached File form appear*/

		/*Step number: 2
		*Step Name: Step 2: Add attach file
		*Step Description: 
			- In current page tab: double click an item to automatically select it 
			- Select the path to the file to be attached by clicking [Browser]
			- Choose file which want to upload and 
			- Click [Link Setting]
			- Input tooltip 
			- Click [Create Link] button
			- Click Save Page
		*Input Data: 
			
		*Expected Outcome: 
			- The attached file is added successfully in content of page
			- Page is add/edited successfully*/
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tooltip = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachedFile = attFileData.getAttachFileByArrayTypeRandom(1);
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,content);
		richEditor.insertAttachedFileLink("", attachedFile, tooltip, attachedFileTabType.Current_page);
		wValidate.verifyInsertedLinkIntoFrame(attachedFile, tooltip);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

		/*Step number: 3
		*Step Name: Step 3: View attach file
		*Step Description: 
			- Click on name of attach file
		*Input Data: 
			
		*Expected Outcome: 
			Show content of attach file*/ 
		info("The file is attached in the page");
		wHome.goToAPage(title);
	    wikiMg.viewInsertLink(attachedFile);

 	}

	/**
	*<li> Case ID:139529.</li>
	*<li> Test Case Name: Attach image in list.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_AttachImageInList() {
		info("Test 8: Attach image in list");
		/*Step Number: 1
		*Step Name: Step 1: Open upload image form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page is in the [Rich Text] editor
			- Click Image in menu and Select Attach image
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- Attached File form appear*/
		

		/*Step number: 2
		*Step Name: Step 2: Attach image
		*Step Description: 
			- Select an image to insert from the list below, by clicking it
			- Click Image Settings
			- Type the width/height of the image
			- Choose the way the image is positioned in the text
			- Choose the way the image is vertically aligned in the line of text
			- Click Insert Image button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Add attach file is added successfully in content of page
			- Page is add/edited successfully*/ 
		
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachedFile = attFileData.getAttachFileByArrayTypeRandom(26);
		String altText=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String width="200";
		String height="200";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,content);
		richEditor.goToAttachedImageLink();
		richEditor.insertImage("TestData/"+attachedFile,true);
		richEditor.editInsertedImage(attachedFile,width,height,altText);
		richEditor.selectAlign(alignType.Middle);
		richEditor.goToInsertImage();
		wikiMg.saveAddPage();
		Utils.pause(2000);
		info("Page is add/edited successfully");
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Add attach file is added successfully in content of page");
		wHome.goToAPage(title);
	    wikiMg.verifySizeImageInContentPage(width, height);
	    wikiMg.verifyAltTextImageInContentPage(altText);

 	}

	/**
	*<li> Case ID:139530.</li>
	*<li> Test Case Name: Upload new image.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_UploadNewImage() {
		info("Test 9: Upload new image");
		/*Step Number: 1
		*Step Name: Step 1: Open upload image form
		*Step Description: 
			- Add new page or edit a page
			- Ensure the page is in the [Rich Text]editor
			-Click [Image] in menu and select [Attach image]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- Attached File form appear*/

		/*Step number: 2
		*Step Name: Step 2: Attach image
		*Step Description: 
			- Double click an item to automatically select it
			- Select the path to the image to be uploaded.
			- Click [Image Settings]
			- Type the width/height of the image
			- Choose the way the image is positioned in the text
			- Choose the way the image is vertically aligned in the line of text
			- Click [Insert Image] button
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- The attachedfile is added successfully in content of page
			- Page is add/edited successfully*/ 
		info("Create a wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachedFile = attFileData.getAttachFileByArrayTypeRandom(26);
		String altText=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String width="200";
		String height="200";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,content);
		richEditor.goToAttachedImageLink();
		richEditor.insertImage("TestData/"+attachedFile, width, height, altText);
		richEditor.selectAlign(alignType.Middle);
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
	    wikiMg.verifyAltTextImageInContentPage(altText);

 	}

	/**
	*<li> Case ID:139531.</li>
	*<li> Test Case Name: External image.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_ExternalImage() {
		info("Test 10 External image");
		/*Step Number: 1
		*Step Name: Step 1: External image
		*Step Description: 
			- Go to [Intranet] 
			-
			-> [Wiki]
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
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
		info("Create a wiki page");
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
	    wikiMg.verifyAltTextImageInContentPage(altText);

 	}}