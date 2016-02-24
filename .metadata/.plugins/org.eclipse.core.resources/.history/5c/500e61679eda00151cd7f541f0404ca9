package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.List;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.acceptType;
import org.exoplatform.selenium.platform.wiki.RichTextEditor.scopeMode;
import org.exoplatform.selenium.platform.wiki.WikiValidattions.effectTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


	public class Wiki_Macro_Add extends WIKI_TestConfig{

	/**
	*<li> Case ID:139220.</li>
	*<li> Test Case Name: Insert Box macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_InsertBoxMacro() {
		info("Test 1: Insert Box macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add a new page
			- Click [Add Page] 
			-
			-> [Blank Page]/[From Template...]
			- Optionally, select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/
		
		/*Step number: 2
		*Step Name: Step 2: Select a macro: Box
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select category: Formatting
			- Select macro: Box
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert Macro
			- OR in [Source Editor] mode, enter {{box title="Box title"}}Box Content{{/box}}
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Draw a box around the provided content*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentMacro=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title, content);
		richEditor.goToMacro("Formatting","Box");
		richEditor.insertMacroBox("","","","", contentMacro);
		wValidate.verifyMacroIntoFrame("box");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
 	}

	/**
	*<li> Case ID:139221.</li>
	*<li> Test Case Name: Insert Children macro.</li>
	*<li> Pre-Condition: Create some wiki pages page1, 
	*Page2 is child of page 1, Page3 is child of page 2, Page 4 is child of page 1</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_InsertChildrenMacro() {
		info("Test 2: Insert Children macro");
		/*Step Number: 1
		*Step Name: Step 1: Open a wiki page
		*Step Description: 
			- Choose Page 1
			- Click [Edit]
			- Ensure this page is displayed in [Rich Text] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- If the page is created in the [Rich Text] mode, the [Edit Page] will be displayed in the [Rich Text] mode.
			- If the page is created in the [Source Editor] mode, the [Edit Page] will be displayed in the [Source Editor] mode.*/

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
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title2, content2);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title2);
		arrayPage.add(title2);
		
		info("Create a wiki page 3");
		String title3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title3, content3);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title3);
		arrayPage.add(title3);
		
		info("Create a wiki page 4");
		String title4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		wHome.goToAPage(title1);
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title4, content4);
		wikiMg.saveAddPage();
		Utils.pause(2000);
		wValidate.verifyTitleWikiPage(title4);
		arrayPage.add(title4);
		
		info("Open page 1");
		wHome.goToAPage(title1);
		wHome.goToEditPage();
		
		/*Step number: 2
		*Step Name: Step 2: Select a macro: Children
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Navigation
			- Select macro: Children
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form, choose descendant Yes
			- Click Insert MacroOr in source mode, enter{{children descendant="true"/}}
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Display the children and descendants of a specific page in the current page*/ 
		info("Insert Macro");
		richEditor.goToMacro("Navigation","Children");
		richEditor.insertChildrenMacro("","",acceptType.yes,acceptType.no,"");
		wValidate.verifyInsertedLinkIntoFrame(title4,"");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title1);

 	}

	/**
	*<li> Case ID:139222.</li>
	*<li> Test Case Name: Insert Code macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_InsertCodeMacro() {
		info("Test 3: Insert Code macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Code
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Formatting
			- Select macro: Code
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the formEg, 
			- "Language" fill html,
			- Fill title: test code macro
			- Fill content{{code language="html"}}<html><head>Cool!</head></html>{{/code}} => Result<html> <head>Cool!</head></html>
			- Click [Insert Macro]
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Highlight code snippets of various programming languages*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String titleMacro=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String languageMacro="html";
		String contentMacro="{{code language=\"html\"}}<html><head>Cool!</head></html>{{/code}} => Result<html> <head>Cool!</head></html>";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title, content);
		richEditor.goToMacro("Formatting","Code");
		richEditor.insertMacroCode("","",languageMacro,titleMacro,"",contentMacro);
		wValidate.verifyMacroIntoFrame("code");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139225.</li>
	*<li> Test Case Name: Insert Excerpt macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test04_InsertExcerptMacro() {
		info("Test 4: Insert Excerpt macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Excerpt
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Content
			- Select macro: Excerpt
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert Macro ORin source mode, enter{{excerpt}}Test excerpt macro{{/excerpt}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Create an additional information for the current page and it can be set "hidden" in the current page, but displayed to add more information as the summary about the page when it is used withthe Child, and include page macro.If page without except macro, only page link is shown. With excerpt macro, bot page link and excerpt macro content is shown.*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentMacro=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title, content);
		richEditor.goToMacro("Content","Excerpt");
		richEditor.insertMacroExcerpt(acceptType.no, contentMacro);
		wValidate.verifyMacroIntoFrame("ExcerptClass");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
 	}

	/**
	*<li> Case ID:139228.</li>
	*<li> Test Case Name: Insert Info Message macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_InsertInfoMessageMacro() {
		info("Test 5: Insert Info Message macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Info Message
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Formatting
			- Select macro: Info Message
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert MacroOR in source mode, enter{{info}}Info Message{{/info}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Display an info message. (in a light blue box)*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentMacro=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title, content);
		richEditor.goToMacro("Formatting","Info Message");
		richEditor.insertMacroMessage(contentMacro);
		wValidate.verifyMacroIntoFrame("infomessage");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139235.</li>
	*<li> Test Case Name: Insert Table of Content macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_InsertTableOfContentMacro() {
		info("Test 6: Insert Table of Content macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Table of Content
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Navigation
			- Select macro: Table of Contents
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert MacroOr in [Source Editor] mode, enter{{toc/}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Generate a table of content for the current page with heading in step 1*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String value1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentHeading1 = sourceTextEffect.getDataColTwoByArrayTypeRandom(4).replace("$value",value);
		String contentHeading3 = sourceTextEffect.getDataColTwoByArrayTypeRandom(5).replace("$value",value1);
		String content=contentHeading1+"\n"+contentHeading3;
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title, content);
		wikiMg.goToRichTextEditor();
		richEditor.goToMacro("Navigation","Table Of Contents");
		richEditor.insertMacroTableOfContent("",acceptType.no, scopeMode.PAGE,"");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		waitForAndGetElement(By.linkText(value));
		waitForAndGetElement(By.linkText(value1));
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139236.</li>
	*<li> Test Case Name: Insert Tip Message  Macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_InsertTipMessageMacro() {
		info("Test 7: Insert Tip Message  Macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Tip Message
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Formatting
			- Select macro: Tip Message
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert MacroOr in [Source Editor] mode, enter{{tip}}Tip message{{/tip}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Displays a tip message block. (in a light green box)*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		sourceEditor.addSimplePage(title,"");
		richEditor.goToMacro("Formatting","Tip Message");
		richEditor.insertMacroMessage(content);
		wValidate.verifyMacroIntoFrame("tipmessage");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139237.</li>
	*<li> Test Case Name: Insert Warning Message Macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_InsertWarningMessageMacro() {
		info("Test 8: Insert Warning Message Macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Warning Message
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Formatting
			- Select macro: Warning Message
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form{ex: This is a warning message}
			- Click Insert MacroORin [Source Editor] mode, enter{{warning}}This is a warning message{{/warning}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Displays a warning message in a styled box format (light orange)*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		sourceEditor.addSimplePage(title,"");
		richEditor.goToMacro("Formatting","Warning Message");
		richEditor.insertMacroMessage(content);
		wValidate.verifyMacroIntoFrame("warningmessage");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139240.</li>
	*<li> Test Case Name: Insert IFrame macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_InsertIFrameMacro() {
		info("Test 9: Insert IFrame macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Anchor
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Other
			- Select macro: IFrame
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the formHeight*width: 400*400src:http://www.w3schools.com
			- Click Insert MacroOr in Source mode, enter{{iframe height="400" src="http://www.w3schools.com" width="400"/}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Create a iframe forEmbraces a block of text within a fully customizable panel, see attachment*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String src="http://www.w3schools.com";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToMacro("Other","IFrame");
		richEditor.insertMacroIFrame("400", src, "400");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		wValidate.verifyMacroIFrame(src);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139241.</li>
	*<li> Test Case Name: Insert Success Message macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_InsertSuccessMessageMacro() {
		info("Test 10 Insert Success Message macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Anchor
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Formatting
			- Select macro: Success Message
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert MacroOr in [Source Editor] mode, enter{{success}}Success message{{/success}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Create a success message note.*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToMacro("Formatting","Success Message");
		richEditor.insertMacroMessage(content);
		wValidate.verifyMacroIntoFrame("successmessage");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139265.</li>
	*<li> Test Case Name: Insert JIRA macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_InsertJIRAMacro() {
		info("Test 11 Insert JIRA macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Anchor
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Content
			- Select macro: JIRA
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the formEg+ URL: https://jira.exoplatform.org/+ Content: SOC
			-123ECMS
			-235
			- Click Insert MacroOR in [Source Editor]mode, enter{{jira URL="https://jira.exoplatform.org/" style="table"}}SOC
			-123ECMS
			-235{{/jira}}
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Information from a JIRA server and displays them as a table with Type, Key, Summary, Status, Created Date*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String url ="https://jira.exoplatform.org/";
		String contentMacro="FQA-2644\nFQA-2643\nFQA-2642";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToMacro("Content","JIRA");
		richEditor.insertMacroJIRA(url, "","","","", contentMacro);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		wValidate.verifyMacroTableHeaderJIRA();
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139267.</li>
	*<li> Test Case Name: Insert Pie chart macro.</li>
	*<li> Pre-Condition: {{chart params="range:B2
	-D5;series:columns;" source="inline" title="Chart Test" type="pie"}}|=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test12_InsertPieChartMacro() {
		info("Test 12 Insert Pie chart macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on [Select]
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Params: range:B2
			-D5;series:columns;+ Source: Inline+ Title: Chart Test+ Type: pie+ Width and height in pixel+ Content: |=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- A pie chart is displayed correctly*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 
 	}

	/**
	*<li> Case ID:139268.</li>
	*<li> Test Case Name: Insert Formula macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE FORMULA MACRO
	*/
	@Test(groups="pending")
	public  void test13_InsertFormulaMacro() {
		info("Test 13 Insert Formula macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Formula
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select macro: Formula
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Select any Font size and Image type+ Input content:sum_{n=1}^inftyfrac{1}{n^2}=frac{pi^2}{6}
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- A mathematics formulais displayed correctly as attachment: Formula.png*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click Source Editor
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed as{{formula}}sum_{n=1}^inftyfrac{1}{n^2}=frac{pi^2}{6}{{/formula}}*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with a mathematical formula*/ 

 	}

	/**
	*<li> Case ID:139269.</li>
	*<li> Test Case Name: Insert HTML macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test14_InsertHTMLMacro() {
		info("Test 14 Insert HTML macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: HTML
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select macro: HTML
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:<br />+ Select value for Clean and Wiki fields: "yes" for ex<br />
			+ Input content:<br /><br /><table><br /> <tr><br /> <td><br />
			* listitem<br /> </td><br /> </tr><br /></table><br /><br />
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- HTML macro is displayed correctly as attachment:*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click Source Editor
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed as {{html}}<table> <tr> <td>* listitem </td> </tr></table>{{/html}}\*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro that means inserting HTML or XHTML in wiki pages successfully*/
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentMacro="<table><tr><td>* listitem</td></tr></table>";
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToMacro("","HTML");
		richEditor.insertMacroHtml(acceptType.yes,acceptType.yes, contentMacro);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		waitForAndGetElement(wHome.ELEMENT_MACRO_HTML_TABLE_INTO_CONTENT_PAGE
				.replace("$text","listitem"));
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139270.</li>
	*<li> Test Case Name: Insert Footnote macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test15_InsertFootnoteMacro() {
		info("Test 15 Insert Footnote macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Footnote
		*Step Description: 
			- Input some text into content Select Macro 
			-
			-> Insert Macro
			- Select macro: Footnote
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for content of footnode: "test" for example
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- Footnote macro is displayed correctly*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click Source Editor
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed as {{footnote}}footnote macro{{/footnote}}*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro ( Adds a note of text placed (by default) at the bottom of the page)*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentMacro=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToMacro("","Footnote");
		richEditor.insertMacroFootNode(contentMacro);
		wValidate.verifyMacroIntoFrame("footnotes");
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139271.</li>
	*<li> Test Case Name: Insert Put Footnote macro.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test16_InsertPutFootnoteMacro() {
		info("Test 16 Insert Put Footnote macro");
		/*Step Number: 1
		*Step Name: Step 1: Open Source Editor
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- Form to create new page with Source Editor is shown*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Box
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Formatting
			- Select macro: Box
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			Draw a box around the provided content*/

		/*Step number: 4
		*Step Name: Step 4: Input content with put footnote macro
		*Step Description: 
			- Input page title
			- Input page content with put footnote macro, for example:= A title =Lorem ipsum dolor sit amet{{footnote}}Footnote 1{{/footnote}}, consectetueradipiscing elit. Vivamus lacus est, euismod at, lobortis eu, rhoncuset, leo{{footnote}}Footnote 2{{/footnote}}.{{putFootnotes/}}**P.S.:** Morbi eget leo. Praesent tempor erat nec sapien. Etiam tincidunt,tellus et faucibus sagittis, diam diam tincidunt magna, idfringilla metus libero nec dolor.
		*Input Data: 
			
		*Expected Outcome: 
			- Page title and content are input*/

		/*Step number: 5
		*Step Name: Step 5: Switch to Rich Text mode
		*Step Description: 
			- Click [Rich Text]
		*Input Data: 
			
		*Expected Outcome: 
			- Put footnote macro is displayed correctly as attachment: putfootnotes.png*/

		/*Step number: 6
		*Step Name: Step 6: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with Put footnote macro that means : D
			isplays the footnotes mentioned so far in the wiki code and resets the footnote counter*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String sourceContent = "= A title = </br>"
				+ "Lorem ipsum dolor sit amet{{footnote}}Footnote 1{{/footnote}}, "
				+ "consectetuer adipiscing elit. Vivamus lacus est, euismod at, lobortis eu, rhoncus"
				+"et, leo{{footnote}}Footnote 2{{/footnote}}.</br>"
				+"</br>{{putFootnotes/}}";
		String contentMacroBox=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,sourceContent);
		switchToParentWindow();
		wikiMg.goToRichTextEditor();
		richEditor.goToMacro("Formatting","Box");
		richEditor.insertMacroBox("","", "","", contentMacroBox);
        switchToParentWindow();
		//Save wiki page
		wikiMg.saveAddPage();
		wValidate.verifyMacroFootNodeIntoContentPage("Footnote 1","Footnote 2", contentMacroBox);
		arrayPage.add(title);
 	}

	/**
	*<li> Case ID:139272.</li>
	*<li> Test Case Name: Insert RSS macro (1).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test17_InsertRSSMacro() {
		info("Test 17 Insert RSS macro (1)");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: RSS
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select macro: RSS
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:<br />+ Select value for Content: true for ex<br />+ Input content for Count = 2 for ex<br />+ Select Decoration/Image: Yes/No<br />+ Input value for Width in pixel<br />+ Input feed value: http://feeds.feedburner.com/massol for example<br />
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- RSS macro is displayed correctly as attachment: rssexample.png*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed with all input information*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String feed = "http://feeds.feedburner.com/massol";
		String sourceContent = "{{rss content=\"true\" count=\"2\" feed=\"http://feeds.feedburner.com/massol\" "
				+ "image=\"true\" width=\"px\"/}}";

		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title,"");
		richEditor.goToMacro("","RSS");
		richEditor.insertMacroRSS(acceptType.yes,"2",acceptType.yes, feed,acceptType.yes,"px");
		wikiMg.goToSourceEditor();
		assert waitForAndGetElement(wHome.ELEMENT_CONTENT_WIKI_INPUT)
		.getText().contains(sourceContent.replace("\\", ""));

		//Save wiki page
		wikiMg.saveAddPage();
		//Check if count of RSS item is 2
		waitForAndGetElement(wHome.ELEMENT_MACRO_RSS_IN_CONTENT_PAGE);
		List<WebElement> rssItem = driver.findElements(wHome.ELEMENT_MACRO_RSS_TITLE);
		assert rssItem.size() == 2;
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139273.</li>
	*<li> Test Case Name: Insert RSS macro (2).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test18_InsertRSSMacro() {
		info("Test 18 Insert RSS macro (2)");
		/*Step Number: 1
		*Step Name: Step 1: Open the Source Editor
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Click [Souce Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- Form to create new page with Source Editor is shown*/

		/*Step number: 2
		*Step Name: Step 2: Input page content with RSS macro
		*Step Description: 
			- Input page title
			- Input page content:{{rss feed="http://feeds.feedburner.com/massol" image="true" content="true" width="90%" count="3"/}}
		*Input Data: 
			
		*Expected Outcome: 
			Page title and content are input*/

		/*Step number: 3
		*Step Name: Step 3: Switch to Rich Text mode
		*Step Description: 
			- Click [Rich Text]
		*Input Data: 
			
		*Expected Outcome: 
			- RSS macro with image is displayed*/

		/*Step number: 4
		*Step Name: Step 4: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String cont = "{{rss feed='http://feeds.feedburner.com/massol' "
				+ "image='true' content='true' width='90%' count='3'/}}";


		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,cont);
		//Save wiki page
		wikiMg.saveAddPage();
		//Check if count of RSS item is 3
		waitForAndGetElement(wHome.ELEMENT_MACRO_RSS_IN_CONTENT_PAGE);
		List<WebElement> rssItem = driver.findElements(wHome.ELEMENT_MACRO_RSS_TITLE);
		assert rssItem.size() == 3;
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139280.</li>
	*<li> Test Case Name: Insert macro in a macro (1).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test19_InsertMacroInAMacro() {
		info("Test 19 Insert macro in a macro (1)");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Click [Source Editor] button
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Source Editor] mode*/

	
		/*Step number: 2
		*Step Name: Step 2: Input content with info macro in box macro
		*Step Description: 
			- Input page title
			- Input page content with info macro in box macro:
			{{box title={{info~}~}Hello!{{/info~}~}}}Box content{{/box}}
		*Input Data: 
			
		*Expected Outcome: 
			- Page title and content are input*/

		/*Step number: 5
		*Step Name: Step 5: Switch to Rich Text Editor mode
		*Step Description: 
			- Click [Rich Text Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Info macro is added in box macro*/

		/*Step number: 6
		*Step Name: Step 6: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with correct macro*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String text = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String syntax = "{{info~}~}Hello!{{/info~}~}";
		String content = "{{box title=${syntax}}}${text}{{/box}}"
				.replace("${syntax}", syntax)
				.replace("${text}", text);

		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		//Save wiki page
		wikiMg.saveAddPage();
		//Check the availability of Code macro
		waitForAndGetElement(wHome.ELEMENT_MACRO_INFO_MESSAGE.replace("${macro}", "Hello!"));
		waitForAndGetElement(wHome.ELEMENT_MACRO_BOX.replace("${macro}", text));
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139281.</li>
	*<li> Test Case Name: Insert macro in a macro (2).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test20_InsertMacroInAMacro() {
		info("Test 20 Insert macro in a macro (2)");
		/*Step Number: 1
		*Step Name: Step 1: Open Source Editor
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Select [Source Editor] to switch to [Source Editor] mode
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode 
			- Form to create new page with Source Editor is shown*/

		
		/*Step number: 2
		*Step Name: Step 2: Input content with warning message macro in box macro
		*Step Description: 
			- Input page title
			- Input page content with warning message macro in box macro:
			{{box title="{{warning~}~}warning message!!!{{/warning~}~}"}}test{{/box}}
		*Input Data: 
			
		*Expected Outcome: 
			- Page title and content are input*/

		/*Step number: 5
		*Step Name: Step 5: Switch to Rich Text mode
		*Step Description: 
			- Click [Rich Text]
		*Input Data: 
			
		*Expected Outcome: 
			- Warning message macro is added in box macro*/

		/*Step number: 6
		*Step Name: Step 6: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with correct macro*/
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String text = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String syntax = " {{warning}}warning message!!!{{/warning}} ";
		String content = "{{box title='${text}' width='100%'}}${syntax} ${text}{{/box}}"
				.replace("${syntax}", syntax).replace("${text}", text);

		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title,content);
		//Save wiki page
		wikiMg.saveAddPage();
		//Check the availability of Code macro
		waitForAndGetElement(wHome.ELEMENT_MACRO_WARNING_MESSAGE.replace("${macro}", "warning message!!!"));
		waitForAndGetElement(wHome.ELEMENT_MACRO_BOX.replace("${macro}", text));
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139283.</li>
	*<li> Test Case Name: Insert macro in a macro (3).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test21_InsertMacroInAMacro() {
		info("Test 21 Insert macro in a macro (3)");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Box
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select category: Formatting
			- Select macro: Box
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			Draw a box around the provided content*/

		/*Step number: 4
		*Step Name: Step 4: Insert Tip message macro with color macro inside
		*Step Description: 
			- Input page title
			- Click [Macro] 
			-
			-> [Insert Macro]
			- Select [Tip Message] macro
			- Input content in the macro
		*Input Data: 
			
		*Expected Outcome: 
			- Tip message is displayed in green color*/

		/*Step number: 5
		*Step Name: Step 5: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed with input infomation: {{tip}}Tip Message{{/tip}}*/

		/*Step number: 6
		*Step Name: Step 6: Save wiki page
		*Step Description: 
			- Click Save
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with correct macro*/ 
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String boxTitle=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String boxContent=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String tipMessageContent=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		


		hp.goToWiki();
		wHome.goToAddBlankPage();
	    richEditor.addSimplePage(title,"");
	    richEditor.goToMacro("","Box");
	    richEditor.insertMacroBox("","", boxTitle,"",boxContent);
	    switchToParentWindow();
	    richEditor.goToMacro("","Tip Message");
	    richEditor.insertMacroMessage(tipMessageContent);
	    switchToParentWindow();
		//Save wiki page
		wikiMg.saveAddPage();
		
		//Check the availability of Code macro
		waitForAndGetElement(wHome.ELEMENT_MACRO_TIP_MESSAGE.replace("${macro}",tipMessageContent));
		waitForAndGetElement(wHome.ELEMENT_MACRO_BOX.replace("${macro}", boxContent));
		arrayPage.add(title);
		
 	}

	/**
	*<li> Case ID:139284.</li>
	*<li> Test Case Name: Insert Code macro by source.</li>
	*<li> Pre-Condition: = Code macro === Java with title =={{code language="java" title="HelloWorld.java"}}System.out.println("Hello World");{{/code}}== Java without title =={{code language="java"}}System.out.println("Hello World");{{/code}}== HTML ==use [[xwiki example>>http://extensions.xwiki.org/xwiki/bin/view/Extension/Code+Macro]]{{code language="html"}}<html><head>How cool?</head></html>{{/code}}</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test22_InsertCodeMacroBySource() {
		info("Test 22 Insert Code macro by source");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Choose path to add new page
			- Click [Add Page] 
			-
			-> [Blank Page]
			- Click on [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Source Editor] mode*/

		/*Step number: 2
		*Step Name: Step 2: Put source code
		*Step Description: 
			- Copy and paste code in precondition 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			Code macro is well rendered*/
		info("Create a wiki page ");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String sourceCode="= Code macro ="+"\n"
				+ "== Java with title =="+"\n"
				+ "{{code language=\"java\" title=\"HelloWorld.java\"}}"
				+ "System.out.println(\"Hello World\");{{/code}}"+"\n"
				+ "== Java without title =="+"\n"
				+ "{{code language=\"java\"}}System.out.println(\"Hello World\");{{/code}}"+"\n"
				+ "== HTML =="+"\n"
				+ "use [[xwiki example>>http://extensions.xwiki.org/xwiki/bin/view/Extension/Code+Macro]]"+"\n"
				+ "{{code language=\"html\"}}<html><head>How cool?</head></html>{{/code}}";
			
		hp.goToWiki();
		wHome.goToAddBlankPage();
		wikiMg.goToSourceEditor();
		sourceEditor.addSimplePage(title, sourceCode);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		wValidate.verifyEffectsPageContent(effectTypes.Heading1,"Code macro");
		wValidate.verifyEffectsPageContent(effectTypes.Heading2,"Java with title");
		wValidate.verifyEffectsPageContent(effectTypes.Heading2,"Java without title");
		wValidate.verifyEffectsPageContent(effectTypes.Heading2,"HTML");
		waitForAndGetElement(By.linkText("xwiki example"));
		arrayPage.add(title);

 	}

	/**
	*<li> Case ID:139287.</li>
	*<li> Test Case Name: Insert line chart macro.</li>
	*<li> Pre-Condition: Source: {{chart source="inline" type="line" params="range:A1
	-A5;series:columns" title="Chart Name" height="150" width="750"}} |0.1 |0.2 |0.2 |0.3 |0.4 {{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test23_InsertLineChartMacro() {
		info("Test 23 Insert line chart macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 150+ Params: range:A1
			-A5;series:columns+ Source: inline+ Title: Line Chart+ Type: line+ Width: 750+ Content: |0.1 |0.2 |0.2 |0.3 |0.4 
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- A line chart is displayed correctly with title Line Chart*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139288.</li>
	*<li> Test Case Name: Insert  bar chart macro.</li>
	*<li> Pre-Condition: {{chart source="inline" type="bar" params="range:B2
	-D5;series:columns;" title="Chart Name" height="240" width="320"}} |=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test24_InsertBarChartMacro() {
		info("Test 24 Insert  bar chart macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Choose path to add a new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 320+ Params: range:B2
			-D5;series:columns;+ Source: inline+ Title: Bar Chart+ Type: bar+ Width: 240+ Content: |=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2
			- Click [Insert Macro]
		*Input Data: 
			
		*Expected Outcome: 
			- A bar chart is displayed correctly with title bar Chart*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139289.</li>
	*<li> Test Case Name: Insert bar 3D chart macro.</li>
	*<li> Pre-Condition: {{chart type="bar3D" source="inline" params="range:B2
	-B9;series:columns" title="Bar3D Chart"}}|=Date|=Value|2012
	-02
	-21|1.97|2012
	-02
	-26|2.96|2012
	-03
	-04|3.93|2012
	-03
	-11|4.84|2012
	-03
	-18|5.83|2012
	-03
	-25|4.5|2012
	-04
	-01|3.85|2012
	-04
	-08|4.87{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test25_InsertBar3DChartMacro() {
		info("Test 25 Insert bar 3D chart macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on [Select]
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 300+ Params: range:B2
			-B9;series:columns+ Source: inline+ Title: Bar3DChart+ Type: bar3D+ Width: 400+ Content: |=Date|=Value|2012
			-02
			-21|1.97|2012
			-02
			-26|2.96|2012
			-03
			-04|3.93|2012
			-03
			-11|4.84|2012
			-03
			-18|5.83|2012
			-03
			-25|4.5|2012
			-04
			-01|3.85|2012
			-04
			-08|4.87
		*Input Data: 
			
		*Expected Outcome: 
			- A bar3D chart is displayed correctly*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139290.</li>
	*<li> Test Case Name: Insert Time Series chart Using "xy_line_and_shape".</li>
	*<li> Pre-Condition: {{chart type="xy_line_and_shape" params="range:B2
	-C19;dataset:timetable_xy;domain_axis_type:date;domain_axis_date_format:MMM
	-yyyy;date_format:yyyy
	-MM;time_period:month;range_axis_lower:100;range_axis_upper:190" title="xy_line_and_shape"}}|=|=Series1|=Series2|2001
	-2|181.8|129.6|2001
	-3|167.3|123.2|2001
	-4|153.8|117.2|2001
	-5|167.6|124.1|2001
	-6|158.8|122.6|2001
	-7|148.3|119.2|2001
	-8|153.9|116.5|2001
	-9|142.7|112.7|2001
	-10|123.2|101.5|2001
	-11|131.8|106.1|2001
	-12|139.6|110.3|2002
	-1|142.9|111.7|2002
	-2|138.7|111.0|2002
	-3|137.3|109.6|2002
	-4|143.9|113.2|2002
	-5|139.8|111.6|2002
	-6|137.0|108.8|2002
	-7|132.8|101.6{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test26_InsertTimeSeriesChartUsingXy_line_and_shape() {
		info("Test 26 Insert Time Series chart Using xy_line_and_shape");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select Macro 
			-
			-> Insert Macro
			- Select macro: Chart
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 300+ Params: range:B2
			-C19;dataset:timetable_xy;domain_axis_type:date;domain_axis_date_format:MMM
			-yyyy;date_format:yyyy
			-MM;time_period:month;range_axis_lower:100;range_axis_upper:190+ Source: inline+ Title: xy_line_and_shape+ Type: xy_line_and_shape+ Width: 400+ Content: |=|=Series1|=Series2|2001
			-2|181.8|129.6|2001
			-3|167.3|123.2|2001
			-4|153.8|117.2|2001
			-5|167.6|124.1|2001
			-6|158.8|122.6|2001
			-7|148.3|119.2|2001
			-8|153.9|116.5|2001
			-9|142.7|112.7|2001
			-10|123.2|101.5|2001
			-11|131.8|106.1|2001
			-12|139.6|110.3|2002
			-1|142.9|111.7|2002
			-2|138.7|111.0|2002
			-3|137.3|109.6|2002
			-4|143.9|113.2|2002
			-5|139.8|111.6|2002
			-6|137.0|108.8|2002
			-7|132.8|101.6
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- A Time Series chart Using "xy_line_and_shape" is displayed correctly*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139291.</li>
	*<li> Test Case Name: Insert Time Series chart Using "xy_line3D".</li>
	*<li> Pre-Condition: Source{{chart type="xy_line3D" params="range:B2
	-C19;dataset:timetable_xy;domain_axis_type:date;domain_axis_date_format:MMM
	-yyyy;date_format:yyyy
	-MM;time_period:month;range_axis_lower:100;range_axis_upper:190" title="xy_line3D"}}|=|=Series1|=Series2|2001
	-2|181.8|129.6|2001
	-3|167.3|123.2|2001
	-4|153.8|117.2|2001
	-5|167.6|124.1|2001
	-6|158.8|122.6|2001
	-7|148.3|119.2|2001
	-8|153.9|116.5|2001
	-9|142.7|112.7|2001
	-10|123.2|101.5|2001
	-11|131.8|106.1|2001
	-12|139.6|110.3|2002
	-1|142.9|111.7|2002
	-2|138.7|111.0|2002
	-3|137.3|109.6|2002
	-4|143.9|113.2|2002
	-5|139.8|111.6|2002
	-6|137.0|108.8|2002
	-7|132.8|101.6{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test27_InsertTimeSeriesChartUsingXy_line3D() {
		info("Test 27 Insert Time Series chart Using xy_line3D");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 300+ Params: range:B2
			-C19;dataset:timetable_xy;domain_axis_type:date;domain_axis_date_format:MMM
			-yyyy;date_format:yyyy
			-MM;time_period:month;range_axis_lower:100;range_axis_upper:190+ Source: inline+ Title: xy_line3D+ Type: xy_line3D+ Width: 400+ Content: |=|=Series1|=Series2|2001
			-2|181.8|129.6|2001
			-3|167.3|123.2|2001
			-4|153.8|117.2|2001
			-5|167.6|124.1|2001
			-6|158.8|122.6|2001
			-7|148.3|119.2|2001
			-8|153.9|116.5|2001
			-9|142.7|112.7|2001
			-10|123.2|101.5|2001
			-11|131.8|106.1|2001
			-12|139.6|110.3|2002
			-1|142.9|111.7|2002
			-2|138.7|111.0|2002
			-3|137.3|109.6|2002
			-4|143.9|113.2|2002
			-5|139.8|111.6|2002
			-6|137.0|108.8|2002
			-7|132.8|101.6
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- A Time Series chart Using "xy_line3D" is displayed correctly*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139292.</li>
	*<li> Test Case Name: Insert Time Series chart Using "xy_step".</li>
	*<li> Pre-Condition: {{chart type="xy_step" params="range:B2
	-C19;dataset:timetable_xy;domain_axis_type:date;domain_axis_date_format:MMM
	-yyyy;date_format:yyyy
	-MM;time_period:month;range_axis_lower:100;range_axis_upper:190" source="inline" title="xy_step"}}|=|=Series1|=Series2|2001
	-2|181.8|129.6|2001
	-3|167.3|123.2|2001
	-4|153.8|117.2|2001
	-5|167.6|124.1|2001
	-6|158.8|122.6|2001
	-7|148.3|119.2|2001
	-8|153.9|116.5|2001
	-9|142.7|112.7|2001
	-10|123.2|101.5|2001
	-11|131.8|106.1|2001
	-12|139.6|110.3|2002
	-1|142.9|111.7|2002
	-2|138.7|111.0|2002
	-3|137.3|109.6|2002
	-4|143.9|113.2|2002
	-5|139.8|111.6|2002
	-6|137.0|108.8|2002
	-7|132.8|101.6{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test28_InsertTimeSeriesChartUsingXy_step() {
		info("Test 28 Insert Time Series chart Using xy_step");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on [Select]
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 300+ Params:range:B2
			-C19;dataset:timetable_xy;domain_axis_type:date;domain_axis_date_format:MMM
			-yyyy;date_format:yyyy
			-MM;time_period:month;range_axis_lower:100;range_axis_upper:190+ Source: inline+ Title: xy_step+ Type: xy_step+ Width: 400+ Content: |=|=Series1|=Series2|2001
			-2|181.8|129.6|2001
			-3|167.3|123.2|2001
			-4|153.8|117.2|2001
			-5|167.6|124.1|2001
			-6|158.8|122.6|2001
			-7|148.3|119.2|2001
			-8|153.9|116.5|2001
			-9|142.7|112.7|2001
			-10|123.2|101.5|2001
			-11|131.8|106.1|2001
			-12|139.6|110.3|2002
			-1|142.9|111.7|2002
			-2|138.7|111.0|2002
			-3|137.3|109.6|2002
			-4|143.9|113.2|2002
			-5|139.8|111.6|2002
			-6|137.0|108.8|2002
			-7|132.8|101.6
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- A Time Series chart Using ""xy_step" is displayed correctly*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed with all input information*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139293.</li>
	*<li> Test Case Name: Insert Custom color chart.</li>
	*<li> Pre-Condition: Source: {{chart type="pie" source="inline" params="range:B2
	-D5;series:columns;colors:C3E3F7,1D9FF5,015891,012A45" title="Chart Test" width="320" height="240"}}|=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test29_InsertCustomColorChart() {
		info("Test 29 Insert Custom color chart");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on [Select]
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Params: range:B2
			-D5;series:columns;colors:C3E3F7,1D9FF5,015891,012A45+ Source: inline+ Title: Chart Test+ Type: pie+ Width and height in pixel+ Content: |=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2
			- Click Insert Macro
		*Input Data: 
			
		*Expected Outcome: 
			- A pie chart with color is displayed correctly*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139609.</li>
	*<li> Test Case Name: Insert  stackedbar chart macro.</li>
	*<li> Pre-Condition: {{chart type="stackedbar" params="range:B2
	-D5;series:columns;" title="Stackedbar Chart" width="320" height="240"}}|=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test30_InsertStackedbarChartMacro() {
		info("Test 30 Insert  stackedbar chart macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Choose path to add a new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 320+ Params: range:B2
			-D5;series:columns;+ Source: inline+ Title: Stackedbar Chart+ Type: stackedbar+ Width: 240+ Content: |=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2
			- Click [Insert Macro]
		*Input Data: 
			
		*Expected Outcome: 
			- A bar chart is displayed correctly with title bar Chart*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}

	/**
	*<li> Case ID:139610.</li>
	*<li> Test Case Name: Insert  stackedbar3D chart macro.</li>
	*<li> Pre-Condition: {{chart type="stackedbar3D" params="range:B2
	-D5;series:columns;" title="Stackedbar Chart" width="320" height="240"}}|=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2{{/chart}}</li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED BECAUSE NOT AVAIABLE CHART MACRO
	*/
	@Test(groups="pending")
	public  void test31_InsertStackedbar3DChartMacro() {
		info("Test 31 Insert  stackedbar3D chart macro");
		/*Step Number: 1
		*Step Name: Step 1: Create a wiki page
		*Step Description: 
			- Connect to Intranet
			- Click Wiki on the left panel to go to Wiki page
			- Choose path to add a new page
			- Click [Add Page] 
			-
			-> [Blank Page]
		*Input Data: 
			
		*Expected Outcome: 
			- By default, the [Create Wiki page] is displayed in the [Rich Text] mode*/

		/*Step number: 2
		*Step Name: Step 2: Select a macro: Chart
		*Step Description: 
			- Select [Macro] 
			-
			-> [Insert Macro...]
			- Select macro: Chart
			- Click on Select
		*Input Data: 
			
		*Expected Outcome: 
			Form to put value for macro is shown*/

		/*Step number: 3
		*Step Name: Step 3: Insert macro
		*Step Description: 
			- Put value for macro in the form:+ Heigh: 320+ Params: range:B2
			-D5;series:columns;+ Source: inline+ Title: Stackedbar Chart+ Type: stackedbar3D+ Width: 240+ Content: |=|=X|=Y|=Z|Q1|1.2|3.4|1.3|Q2|4.5|3.4|2.3|Q3|1.2|4.5|9.0|Q4|3.4|1.2|1.2
			- Click [Insert Macro]
		*Input Data: 
			
		*Expected Outcome: 
			- A bar chart is displayed correctly with title bar Chart*/

		/*Step number: 4
		*Step Name: Step 4: Switch to Source Editor mode
		*Step Description: 
			- Click [Source Editor]
		*Input Data: 
			
		*Expected Outcome: 
			- Source of macro is displayed like in precondition*/

		/*Step number: 5
		*Step Name: Step 5: Save wiki page
		*Step Description: 
			- Click [Save]
		*Input Data: 
			
		*Expected Outcome: 
			- Page is saved with macro*/ 

 	}}