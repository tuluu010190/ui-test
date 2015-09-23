package org.exoplatform.selenium.platform.wiki.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.testng.annotations.*;


	public class Wiki_Basic_Action_Export_Page extends WIKI_TestConfig{

	/**
	*<li> Case ID:139552.</li>
	*<li> Test Case Name: Export a wiki page as PDF of another user.</li>
	*<li> Pre-Condition: User B has access to the wiki page</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_ExportAWikiPageAsPDFOfAnotherUser() {
		info("Test 1: Export a wiki page as PDF of another user");
		/*Step Number: 1
		*Step Name: Step 1: Select a wiki page of another user
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open Wiki application
			- Select a page created by another user
		*Input Data: 
			
		*Expected Outcome: 
			- The wiki page is displayed*/
		info("Create a draf wiki page");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToWiki();
		wHome.goToAddBlankPage();
		richEditor.addSimplePage(title, content);
		wikiMg.saveAddPage();
		wValidate.verifyTitleWikiPage(title);
		arrayPage.add(title);
		
		info("Login as demo");
		magAc.signOut();
		magAc.signIn(DATA_USER4,DATA_PASS);
        Utils.pause(2000);
        
        info("Open the page");
        hp.goToWiki();
        wHome.goToAPage(title);
        
		/*Step number: 2
		*Step Name: Step 2: Export the Wiki page
		*Step Description: 
			- Click [More] 
			-
			-> [Export as PDF]
			- Select where to store the PDF
		*Input Data: 
			
		*Expected Outcome: 
			- The option "Export as PDF", is displayed in the list "More"
			- The form to download PDF is shown
			- The name of file is: "Page name.pdf"*/ 
        info("Export the Wiki page");
        wHome.goToExportPage();
        checkFileExisted("TestOutput/"+title);
 	}

	/**
	*<li> Case ID:139553.</li>
	*<li> Test Case Name: Open Exported file.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*CANNOT AUTOMATED
	*/
	@Test(groups="pending")
	public  void test02_OpenExportedFile() {
		info("Test 2: Open Exported file");
		/*Step Number: 1
		*Step Name: Step 1: Export a wiki page as PDF
		*Step Description: 
			- Connect to [Intranet]
			- Click [Wiki] to open Wiki application.
			- Open a wiki page
			- From "More" menu, choose "Export as PDF"
			- Select where to store the PDF
		*Input Data: 
			
		*Expected Outcome: 
			- The dowload of page is started
			- The name of file is: "Page name.pdf"*/

		/*Step number: 2
		*Step Name: Step 2: Open Exported file
		*Step Description: 
			- Open the PDF file
		*Input Data: 
			
		*Expected Outcome: 
			- The title of the page and its content are displayed in the PDF file*/ 

 	}}