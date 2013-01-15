package org.exoplatform.selenium.platform.wiki.functional.search;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.wiki.BasicAction;

/**
 *
 * @author HangNTT
 * @date: 13/12/2012
 */
public class Wiki_Advanced_Search extends BasicAction {

	ManageAccount magAc;
	
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		magAc = new ManageAccount(driver);
		magAc.signIn("john", "gtn");
	}
	
	//Search when the keyword is matched
	@Test
	public void test01_SearchWhenKeyWordIsMatched() {
		
		String PAGE_NAME1 = "wiki1";

		By ELEMENT_PAGE1 = By.xpath(ELEMENT_RESULT_SEARCH.replace("${pageName}", PAGE_NAME1));
				//("//*[@id='UIWikiAdvanceSearchResult']//a/span[text()='wiki1']");

		goToWiki();

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		advancedSearch(PAGE_NAME1, "intranet");

		click(ELEMENT_PAGE1);

		deleteCurrentWikiPage();
	}
	
	//Search when the keyword is not matched
	@Test
	public void test02_SearchWhenKeyWordIsNotMatched() {

		String PAGE_NAME1 = "wiki2";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		goToWiki();

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		advancedSearch("bbb", "intranet");

		//waitForTextPresent(ELEMENT_VERIFY_MESSAGE);
		waitForElementPresent(ELEMENT_VERIFY_RESULT_SEARCH.replace("${pageName}", "bbb"), 3000, 0, 2);
			
		click(ELEMENT_PAGE1);

		deleteCurrentWikiPage();
	}
	
	//View content of search result when user does not have permission to view page
	@Test
	public void test03_ViewContentOfSearchResultWhenUserDoesNotHavePermissionToViewPage() {

		String[] user1= {"james"};

		String PAGE_NAME1 = "wiki3";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		goToWiki();

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		deletePagePermission("any");

		addPagePermission(0,user1);

		editPagePermission("james", false,false, false, 2);

		magAc.signOut();

		magAc.signIn("james", "gtn");

		goToWiki();

		advancedSearch(PAGE_NAME1, "intranet");

		//waitForTextPresent(ELEMENT_VERIFY_MESSAGE);
		waitForElementPresent(ELEMENT_VERIFY_RESULT_SEARCH.replace("${pageName}", PAGE_NAME1), 3000, 0, 2);

		magAc.signOut();

		magAc.signIn("john", "gtn");

		goToWiki();

		click(ELEMENT_PAGE1);

		deleteCurrentWikiPage();
	}

	@AfterMethod
	public void afterTest(){
		//signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
