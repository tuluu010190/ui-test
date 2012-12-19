package org.exoplatform.selenium.platform.ks.functional.wiki.basicaction;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.exoplatform.selenium.platform.ks.KsBase;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.Wiki.addBlankWikiPage;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.ks.Wiki.*;


/**
 * 
 * @author HangNTT
 * @date: 10/12/2012
 */
public class KS_Wiki_BasicAction_Intergration extends KsBase {
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}

	//Check links between page from different spaces
	@Test
	public void test01_checkLinksBetweenPageFormDifferentSpaces() {

		String PAGE_NAME1 = "wiki1";
		String PAGE_NAME2 = "wiki2";

		By ELEMENT_PAGE1_LINK = By.linkText(PAGE_NAME1);

		By ELEMENT_WIKI_TAB = By.linkText("Wiki");

		goToMySpacePage();

		addNewSpace("Space1", "Description Of Space1");

		click(ELEMENT_WIKI_TAB);

		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);

		goToMySpacePage();

		addNewSpace("Space2", "Description Of Space2");

		click(ELEMENT_WIKI_TAB);

		addBlankWikiPage(PAGE_NAME2, PAGE_NAME2, 0);

		editWikiPage(PAGE_NAME2, "[[wiki1>>/spaces/space1.wiki1]]", 0, false);

		click(ELEMENT_PAGE1_LINK);

		goToMySpacePage();

		deleteSpace("Space1", 120000);

		deleteSpace("Space2", 120000);

	}
	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
