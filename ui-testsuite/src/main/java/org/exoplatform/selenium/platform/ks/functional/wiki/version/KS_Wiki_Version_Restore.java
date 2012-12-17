package org.exoplatform.selenium.platform.ks.functional.wiki.version;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import org.exoplatform.selenium.platform.ks.Wiki;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test cases: KS/Wiki/Version/Restore
 * @author vuna2
 * <li>Date: Dec 17, 2012</li>
 */
public class KS_Wiki_Version_Restore extends Wiki{
	public String admin = "john";
	public String pass = "gtn";

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		driver.manage().window().maximize();
		signIn(admin, pass);
	}

	@AfterMethod
	public void afterMethods(){
		info("-- user.Logout --");
		signOut();
		driver.quit();
		actions = null;
	}

	/**
	 * Case ID 01
	 * <li>Restore version to current version</li>
	 * <li> Step 1: Create new page </li>
	 * <li> Step 2: Add version for page </li>
	 * <li> Step 3: Add more version for page </li>
	 * <li> Step 4: Open form to view all version of page</li>
	 * <li> Step 5: Restore version to current version</li>
	 */
	@Test
	public void test01_RestoreVersionToCurrentVersion(){
		String[] pageInfo = {"restore 01", "page content 01"};

		goToWiki();

		addBlankWikiPage(pageInfo[0], pageInfo[1], 0);

		editWikiPage("1st edit restore 01", "1st edit page content", 0, false);

		editWikiPage("2nd edit restore 01", "2nd edit page content", 0, false);

		restoreVersion("1");

		waitForTextPresent("page content 01");

		goToRevisionsPage();

		waitForElementPresent(ELEMENT_CURRENT_VERSION.replace("${version}", "4"));

		deleteWikiPage();
	}
}
