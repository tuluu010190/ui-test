package org.exoplatform.selenium.platform.ks.functional.wiki.search;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.exoplatform.selenium.platform.ks.KsBase;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.Wiki.*;

/**
 *
 * @author HangNTT
 * @date: 13/12/2012
 */
public class KS_Advanced_Search extends KsBase {

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}
	//Search when the keyword is matched
	@Test
	public void test01_SearchWhenKeyWordIsMatched() {
		
		String PAGE_NAME1 = "wiki1";

		By ELEMENT_PAGE1 = By.xpath("//*[@id='UIWikiAdvanceSearchResult']//a/span[text()='wiki1']");

		goToWiki();

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		advancedSearch(PAGE_NAME1, "intranet");

		click(ELEMENT_PAGE1);

		deleteWikiPage();
	}
	//Search when the keyword is not matched
	@Test
	public void test02_SearchWhenKeyWordIsNotMatched() {

		String PAGE_NAME1 = "wiki2";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		goToWiki();

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		advancedSearch("bbb", "intranet");

		waitForTextPresent(ELEMENT_VERIFY_MESSAGE);

		click(ELEMENT_PAGE1);

		deleteWikiPage();
	}
	//View content of search result when user does not have permission to view page
	@Test
	public void test03_ViewContentOfSearchResultWhenUserDoesNotHavePermissionToViewPage() {

		String[] user1= {"james"};

		String PAGE_NAME1 = "wiki3";

		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);

		goToWiki();

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		deletePermission("any");

		addPagePermission(0,user1);

		editPagePermission("james", false,false);

		signOut();

		signIn("james", "gtn");

		goToWiki();

		advancedSearch(PAGE_NAME1, "intranet");

		waitForTextPresent(ELEMENT_VERIFY_MESSAGE);

		signOut();

		signIn("john", "gtn");

		goToWiki();

		click(ELEMENT_PAGE1);

		deleteWikiPage();
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
