package org.exoplatform.selenium.platform.wiki.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class Wiki_Basic_Action_Manage_Page_Rename extends Wiki_TestConfig {
	/**
	 *<li> Case ID:122809.</li>
	 *<li> Test Case Name: Rename Page.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	
	@Test
	public  void test01_RenamePage() {
		info("Test 01: Rename Page");
		String wiki = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String wiki2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		 *Step Name: Step 1: Rename Page
		 *Step Description: 
			- Open an existing page by clicking on page name in navigation tree.
			Rename page by one of two ways
			1.
			- Double-click on page name in toolbar
			- Page's title field is enable and allow edit. 
			- Rename page and hit Enter key
			2.
			- Click Edit icon to edit page
			- Fill new title
			- Click Save


		 *Input Data: 

		 *Expected Outcome: 
			Selected Page is renamed and new name is displayed in toolbar and navigation tree*/ 
		hp.goToWiki();
		wHome.goToAddBlankPage();
		rtMode.addSimplePage(wiki, wiki);
		wikiMg.saveAddPage();
		waitForAndGetElement(wHome.ELEMENT_TREE_WIKI_NAME.replace("${name}",wiki),2000,0);
		
		info("Double click on the title of the page");
		wHome.selectAPage(wiki);
		wikiMg.renamePageByDoubleClick(wiki, wiki2);
		waitForAndGetElement(wHome.ELEMENT_TREE_WIKI_NAME.replace("${name}",wiki2),2000,0);
		
		info("Delete the page");
		hp.goToWiki();
		wHome.deleteWiki(wiki2);
	}

	
	
}