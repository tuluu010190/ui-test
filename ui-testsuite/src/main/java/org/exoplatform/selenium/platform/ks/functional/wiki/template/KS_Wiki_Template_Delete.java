package org.exoplatform.selenium.platform.ks.functional.wiki.template;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.TestLogger.info;
import org.exoplatform.selenium.platform.ks.Wiki;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*--
 *-- Author: HaKT
 *-- Date: 18 Dec 2012
 **/

public class KS_Wiki_Template_Delete extends Wiki{

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn"); 
		goToWiki();
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 * Delete template when OK with confirmation
	 * Create a new template
	 * Delete template, click OK with confirmation message
	 * Verify template is deleted
	 */
	@Test
	public static void test01_deleteTemplateWithOKConfirmation(){

		String DATA_TEMPLATE_TITLE="Delete_Template_01";
		String DATA_TEMPLATE_DESC="This case is delete a template";
		String DATA_TEMPLATE_CONTENT="Content of Delete_Template_01";

		info("Delete template when OK with confirmation");
		goToTemplateManagement();
		addTemplate(DATA_TEMPLATE_TITLE, DATA_TEMPLATE_DESC, DATA_TEMPLATE_CONTENT);

		pause(1000);
		click(ELEMENT_DELETE_TEMPLATE_ICON.replace("{$template}", DATA_TEMPLATE_TITLE));

		acceptAlert();

		waitForElementNotPresent(ELEMENT_NEW_TEMPLATE_LINK.replace("${TEMPLATE_TITLE}", DATA_TEMPLATE_TITLE));
	}

	/**
	 * Delete template when Cancel with confirmation
	 * Create a new template
	 * Delete template, click Cancel with confirmation message
	 * Verify template is not deleted
	 */
	@Test
	public static void test02_deleteTemplateWithCancelConfirmation(){

		String DATA_TEMPLATE_TITLE="Delete_Template_02";
		String DATA_TEMPLATE_DESC="This case is delete a template";
		String DATA_TEMPLATE_CONTENT="Content of Delete_Template_02";

		info("Delete template when Cancel with confirmation");

		goToTemplateManagement();

		addTemplate(DATA_TEMPLATE_TITLE, DATA_TEMPLATE_DESC, DATA_TEMPLATE_CONTENT);

		click(ELEMENT_DELETE_TEMPLATE_ICON.replace("{$template}", DATA_TEMPLATE_TITLE));

		cancelAlert();

		waitForElementPresent(ELEMENT_NEW_TEMPLATE_LINK.replace("${TEMPLATE_TITLE}", DATA_TEMPLATE_TITLE));

		goToWikiHome();

		deleteTemplate(DATA_TEMPLATE_TITLE);
	}
}