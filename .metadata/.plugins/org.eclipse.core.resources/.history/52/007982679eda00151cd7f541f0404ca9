package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.WikiValidattions.effectTypes;
import org.testng.annotations.*;


	public class Wiki_Template extends WIKI_TestConfig{

	/**
	*<li> Case ID:139395.</li>
	*<li> Test Case Name: Create new template.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CreateNewTemplate() {
		info("Test 1: Create new template");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new template
		*Step Description: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template tab
			- Click on Add More Templates link
		*Input Data: 
			
		*Expected Outcome: 
			Form to create new template appears*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();

		/*Step number: 2
		*Step Name: Step 2: Add new template
		*Step Description: 
			- Put title, description, content
			- Click on Save Template
		*Input Data: 
			
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/ 
		info("Add a new template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wSetting.addTemplate(title, des, content);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		arrayTemplate.add(title);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title);
 	}

	/**
	*<li> Case ID:139397.</li>
	*<li> Test Case Name: Create new template when using syntax.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_CreateNewTemplateWhenUsingSyntax() {
		info("Test 2: Create new template when using syntax");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new template
		*Step Description: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template tab
			- Click on Add More Templates link
		*Input Data: 
			
		*Expected Outcome: 
			Form to create new template appears*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();

		/*Step number: 2
		*Step Name: Step 2: Create new template with Table tag
		*Step Description: 
			- Input |=Title 1|=Title 2|Word 1|Word 2
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The result is the table with 2 columms and 2 rows*/
		info("Add a new template");
		String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content1 = sourceTextEffect.getDataColTwoByArrayTypeRandom(1);
		wSetting.addTemplate(title1, des1, content1);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title1);
        arrayTemplate.add(title1);
        
        info("Verify that the template is a table with 2 column and 2 rows");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title1);
        wikiMg.addSimpleWikiPageByTemplate(title1, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
		info("The result is the table with 2 columms and 2 rows");
		wValidate.verifyTableInContentPage(2,2);

		/*Step number: 3
		*Step Name: Step 3: Create new template with Bold tag
		*Step Description: 
			- Input text inside ** ** character in contentFor example: **bold**
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The template is shown with Bold effect like Bold*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content2 = sourceTextEffect.getDataColTwoByArrayTypeRandom(2).replace("$value",value2);
		wSetting.addTemplate(title2, des2, content2);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title2);
        arrayTemplate.add(title2);
        
        info("Verify that the template has bold effect");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title2);
        wikiMg.addSimpleWikiPageByTemplate(title2, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);
		info("The page is shown with Bold effect");
		wValidate.verifyEffectsPageContent(effectTypes.Bold,value2);

		/*Step number: 4
		*Step Name: Step 4: Create new template with Bulleted list effect
		*Step Description: 
			- Input text inside start with * character in contentFor example: * item 1** item 2*** item 3* item 4
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The result is item 1 item 2 Item 3 item 4*/
		
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content3 = sourceTextEffect.getDataColTwoByArrayTypeRandom(3).replace("$value",value3);
		wSetting.addTemplate(title3, des3, content3);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title3);
        arrayTemplate.add(title3);
        
        info("The page is shown with Bullest list effect");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title3);
        wikiMg.addSimpleWikiPageByTemplate(title3, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title3);
		arrayPage.add(title3);
		info("The page is shown with Bullest list effect");
		wValidate.verifyEffectsPageContent(effectTypes.Bullest_List,value3);

		/*Step number: 5
		*Step Name: Step 5: Create new template with italic tag
		*Step Description: 
			- Input text inside // // character in contentFor example: //italic //
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The template is shown with Bold effect like italic*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content4 = sourceTextEffect.getDataColTwoByArrayTypeRandom(7).replace("$value",value4);
		wSetting.addTemplate(title4, des4, content4);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title4);
        arrayTemplate.add(title4);
        
        info("The page is shown with Italic effect");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title4);
        wikiMg.addSimpleWikiPageByTemplate(title4, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title4);
		arrayPage.add(title4);
		wValidate.verifyEffectsPageContent(effectTypes.Italic,value4);

		/*Step number: 6
		*Step Name: Step 6: Create new template with Heading tag
		*Step Description: 
			- Input text inside == character in contentFor example: =Heading1=
			- Click Save Template buttonOR
			- Input text inside == character in contentFor example: ===Heading3===
			- Click Save Template buttonOR
			- Input text inside == character in contentFor example: =====Heading5=====
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			- The template is shown with Bold effect like Heading1 (large heading)
			- The template is shown with Bold effect like Heading3 (normal heading)
			- The template is shown with Bold effect like Heading5 (small heading)*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title5 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des5 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value5 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentHeading1 = sourceTextEffect.getDataColTwoByArrayTypeRandom(4).replace("$value",value5);
		String contentHeading3 = sourceTextEffect.getDataColTwoByArrayTypeRandom(5).replace("$value",value5);
		String contentHeading5 = sourceTextEffect.getDataColTwoByArrayTypeRandom(6).replace("$value",value5);
		String content5=contentHeading1+"\n"+contentHeading3+"\n"+contentHeading5;
		wSetting.addTemplate(title5, des5, content5);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title5);
        arrayTemplate.add(title5);
        
        info("The page is shown with heading effects");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title5);
        wikiMg.addSimpleWikiPageByTemplate(title5, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title5);
		arrayPage.add(title5);
		info("The page is shown with Heading 1 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading1,value5);
		info("The page is shown with Heading 3 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading3,value5);
		info("The page is shown with Heading 5 effect");
		wValidate.verifyEffectsPageContent(effectTypes.Heading5,value5);

		/*Step number: 7
		*Step Name: Step 7: Create new template with Link tag
		*Step Description: 
			- Input text inside [ ]] character For example: [[Wiki Home]]
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The template is shown with link effect like Wiki Home*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title6 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des6 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value6 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content6 = sourceTextEffect.getDataColTwoByArrayTypeRandom(8).replace("$value",value6);
		wSetting.addTemplate(title6, des6, content6);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title6);
        arrayTemplate.add(title6);
        
        info("The page is shown with link effect");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title6);
        wikiMg.addSimpleWikiPageByTemplate(title6, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title6);
		arrayPage.add(title6);
		info("The page is shown with link effect");
		wValidate.verifyEffectsPageContent(effectTypes.Link,value6);

		/*Step number: 8
		*Step Name: Step 8: Create new template with Numbered list tag
		*Step Description: 
			- Input text start with numberFor example: 1. item 111. item 2111. item 31. item 4
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The result is 1. item 1 1. item 2 1. item 3 2. item 4*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title7 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des7 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value7 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content7 = sourceTextEffect.getDataColTwoByArrayTypeRandom(9).replace("$value",value7);
		wSetting.addTemplate(title7, des7, content7);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title7);
        arrayTemplate.add(title7);
        
        info("The page is shown with Number list effect");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title7);
        wikiMg.addSimpleWikiPageByTemplate(title7, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title7);
		arrayPage.add(title7);
		info("The page is shown with Number list effect");
		wValidate.verifyEffectsPageContent(effectTypes.Number_List,value7);

		/*Step number: 9
		*Step Name: Step 9: Create new template with strike tag
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
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The template is shown with Bold effect like strikes*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title8 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des8 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value8 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content8 = sourceTextEffect.getDataColTwoByArrayTypeRandom(10).replace("$value",value8);
		wSetting.addTemplate(title8, des8, content8);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title8);
        arrayTemplate.add(title8);
        
        info("The page is shown with Strike effect");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title8);
        wikiMg.addSimpleWikiPageByTemplate(title8, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title8);
		arrayPage.add(title8);
		info("The page is shown with Strike effect");
		wValidate.verifyEffectsPageContent(effectTypes.Strike,value8);

		/*Step number: 10
		*Step Name: Step 10: Create new template with underline tag
		*Step Description: 
			- Input text inside__ __character in contentFor example: __underline__
			- Click Save Template button
		*Input Data: 
			
		*Expected Outcome: 
			The template is shown with Bold effect like underline*/ 
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title9 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des9 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value9 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content9 = sourceTextEffect.getDataColTwoByArrayTypeRandom(11).replace("$value",value9);
		wSetting.addTemplate(title9, des9, content9);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title9);
        arrayTemplate.add(title9);
        
        info("The page is shown with underline effect");
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title9);
        wikiMg.addSimpleWikiPageByTemplate(title9, "");
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title9);
		arrayPage.add(title9);
		info("The page is shown with underline effect");
		wValidate.verifyEffectsPageContent(effectTypes.Underline,value9);

 	}

	/**
	*<li> Case ID:139398.</li>
	*<li> Test Case Name: Delete template when Cancel confirmation.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_DeleteTemplateWhenCancelConfirmation() {
		info("Test 3: Delete template when Cancel confirmation");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open form to create new template
		*Input Data: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template
			- Click on Add More Templateslink
		*Expected Outcome: 
			Form to create new template appears*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add new template
		*Input Data: 
			- Put title, description, content
			- Click on Save Template
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wSetting.addTemplate(title, des, content);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title);
        arrayTemplate.add(title);

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Delete template
		*Input Data: 
			- Click Delete icon corresponding with the template want to delete
			- Click Cancel on confirmation
		*Expected Outcome: 
			Template is not deleted successful. It is still listed inTemplate form*/ 
        info("Delete template");
        wSetting.deleteTemplateWithCanceling(title);

 	}

	/**
	*<li> Case ID:139399.</li>
	*<li> Test Case Name: Delete template when OK with confirmation.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_DeleteTemplateWhenOKWithConfirmation() {
		info("Test 4: Delete template when OK with confirmation");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open form to create new template
		*Input Data: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template
			- Click on Add More Templateslink
		*Expected Outcome: 
			Form to create new template appears*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add new template
		*Input Data: 
			- Put title, description, content
			- Click on Save Template
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wSetting.addTemplate(title, des, content);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title);
        arrayTemplate.add(title);

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Delete template
		*Input Data: 
			- Click Delete icon corresponding with the template want to delete
			- Click OK on confirmation
		*Expected Outcome: 
			Template is deleted successful. It is not listed inTemplate form*/ 
        info("Delete a template with OK confirmation");
        wSetting.deleteTemplate(title);

 	}

	/**
	*<li> Case ID:139400.</li>
	*<li> Test Case Name: Edit created template.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_EditCreatedTemplate() {
		info("Test 5: Edit created template");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open form to create new template
		*Input Data: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template tab
			- Click on Add More Templateslink
		*Expected Outcome: 
			Form to create new template appears*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add new template
		*Input Data: 
			- Put title, description, content
			- Click on Save Template
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		info("Add a new template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wSetting.addTemplate(title, des, content);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title);
        arrayTemplate.add(title);

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Edit template
		*Input Data: 
			- Click Edit icon corresponding with the template want to edit
			- Change values
			- Click on Save Template
		*Expected Outcome: 
			Template is edited successful*/ 
        info("Edit a template");
        String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String newDes = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        wSetting.editTemplate(title, newTitle,newDes,newContent);
        
        info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(newTitle);
        arrayTemplate.add(newTitle);

 	}

	/**
	*<li> Case ID:139402.</li>
	*<li> Test Case Name: Search template when Search field is blank.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_SearchTemplateWhenSearchFieldIsBlank() {
		info("Test 6: Search template when Search field is blank");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open form to create new template
		*Input Data: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template
			- Click on Add More Templateslink
		*Expected Outcome: 
			Form to create new template appears*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add new template
		*Input Data: 
			- Put title, description, content
			- Click on Save Template
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();
		
		for(int i=0;i<3;i++){
			info("Add a new template");
			String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			wSetting.addTemplate(title, des, content);
			wSetting.saveTemplate();
			wHome.confirmWaringMessage(true);
			
			info("Verify that new tempate is created. It'll be shown in template form");
	        wValidate.verifyTemplateInList(title);
	        arrayTemplate.add(title);
		}
		
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Search template whenSearch field is blank
		*Input Data: 
			- Leave Search field is blank
			- Press Enter key
		*Expected Outcome: 
			All templates are listed*/ 
        info("Search template with search field is blank");
        wSetting.searchTemplate("");
        info("Verify that any templates is shown in the list");
        wValidate.verifyTemplateInList(arrayTemplate.get(0));
        wValidate.verifyTemplateInList(arrayTemplate.get(1));
        wValidate.verifyTemplateInList(arrayTemplate.get(2));
 	}

	/**
	*<li> Case ID:139403.</li>
	*<li> Test Case Name: Search template when the key is matched.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_SearchTemplateWhenTheKeyIsMatched() {
		info("Test 7: Search template when the key is matched");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open form to create new template
		*Input Data: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template
			- Click on Add More Templateslink
		*Expected Outcome: 
			Form to create new template appears*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add new template
		*Input Data: 
			- Put title, description, content
			- Click on Save Template
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();

		info("Add a new template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wSetting.addTemplate(title, des, content);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title);
        arrayTemplate.add(title);
        
		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Search template when the key is matched
		*Input Data: 
			- Put value in Search field
			- Press Enter key
		*Expected Outcome: 
			All the results matched with keyword are displayed*/ 
        info("Search template with search field is blank");
        wSetting.searchTemplate(title);
        info("Verify that any templates is shown in the list");
        wValidate.verifyTemplateInList(title);
 	}

	/**
	*<li> Case ID:139404.</li>
	*<li> Test Case Name: Search template when the key is not matched.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_SearchTemplateWhenTheKeyIsNotMatched() {
		info("Test 8: Search template when the key is not matched");
		/*Step Number: 1
		*Step Name: -
		*Step Description: 
			Step 1: Open form to create new template
		*Input Data: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template
			- Click on Add More Templateslink
		*Expected Outcome: 
			Form to create new template appears*/

		/*Step number: 2
		*Step Name: -
		*Step Description: 
			Step 2: Add new template
		*Input Data: 
			- Put title, description, content
			- Click on Save Template
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();

		info("Add a new template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wSetting.addTemplate(title, des, content);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title);
        arrayTemplate.add(title);

		/*Step number: 3
		*Step Name: -
		*Step Description: 
			Step 3: Search template when the key is not matched
		*Input Data: 
			- Put value in Search field
			- Press Enter key
		*Expected Outcome: 
			No result is displayed*/ 
        info("Search template with search field is blank");
        String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        wSetting.searchTemplate(title1);
        info("Verify that the searching is empty");
        wValidate.verifyTemplateSearchEmpty();

 	}

	/**
	*<li> Case ID:139405.</li>
	*<li> Test Case Name: Using template to create new page.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_UsingTemplateToCreateNewPage() {
		info("Test 9: Using template to create new page");
		/*Step Number: 1
		*Step Name: Step 1: Open form to create new template
		*Step Description: 
			- Go to Browser 
			-> Wiki Settings
			- Select Template
			- Click on Add More Templates link
		*Input Data: 
			
		*Expected Outcome: 
			Form to create new template appears*/

		/*Step number: 2
		*Step Name: Step 2: Add new template
		*Step Description: 
			- Put title, description, content
			- Click on Save Template
		*Input Data: 
			
		*Expected Outcome: 
			New template is created. It'll be shown in Template form*/
		info("Go to Wiki Settings");
		hp.goToWiki();
		wHome.goToWikiSettingPage();

		info("Add a new template");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String des = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wSetting.addTemplate(title, des, content);
		wSetting.saveTemplate();
		wHome.confirmWaringMessage(true);
		
		info("Verify that new tempate is created. It'll be shown in template form");
        wValidate.verifyTemplateInList(title);
        arrayTemplate.add(title);

		/*Step number: 3
		*Step Name: Step 3: Create new page usingtemplate
		*Step Description: 
			- Click on Add Page 
			-> From Template
			- Click Select on template want to choose
			- Put values
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode
			- New page is created using template*/ 
    	String title1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToWiki();
        wHome.goToAddTemplateWikiPage();
        wSetting.searchTemplate(title);
        wikiMg.addSimpleWikiPageByTemplate(title,title1);
		Utils.pause(2000);
		info("New page is created successfully. It is displayed in the destination path");
		wValidate.verifyTitleWikiPage(title1);
		arrayPage.add(title1);
 	}}