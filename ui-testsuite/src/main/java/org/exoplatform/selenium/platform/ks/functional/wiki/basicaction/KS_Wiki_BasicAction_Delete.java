package org.exoplatform.selenium.platform.ks.functional.wiki.basicaction;

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
 * @date: 7/12/2012
 */
public class KS_Wiki_BasicAction_Delete extends KsBase {
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	//Delete a wiki page with without confirm and confirm message
	@Test
	public void test01_02_deletePageWithoutConfirmAndConfirmMessage() {
		
		By ELEMENT_PAGE1 = By.linkText("wiki1");
		
		goToWiki();

		addBlankWikiPage("wiki1", "wiki1", 0);
		
		click(ELEMENT_PAGE1);
		
		deleteWikiPageWithoutConfirm();
		
		waitForElementPresent(ELEMENT_PAGE1);
		
		deleteWikiPage();
	}
}
