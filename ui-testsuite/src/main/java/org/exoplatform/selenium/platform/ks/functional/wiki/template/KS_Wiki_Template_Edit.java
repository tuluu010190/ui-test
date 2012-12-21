package org.exoplatform.selenium.platform.ks.functional.wiki.template;

import org.exoplatform.selenium.platform.ks.Wiki;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*--
 *-- Author: HaKT
 *-- Date: 19 Dec 2012
 **/
public class KS_Wiki_Template_Edit extends Wiki{

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
	 * Case 01: Edit created template
	 * - Create new Template
	 * - Edit template
	 * - Verify result
	 * - Delete template
	 */
	@Test
	public static void test01_EditCreatedTemplate(){

		String DATA_TEMPLATE_TITLE="Edit_Template_01";
		String DATA_NEW_TEMPLATE_TITLE="Edited_Template_01";
		String DATA_TEMPLATE_DESC="This is Template 01";
		String DATA_TEMPLATE_CONTENT="Content of New Template 01";
		
		info("Edit created template");
	
		goToTemplateManagement();
	
		addTemplate(DATA_TEMPLATE_TITLE, DATA_TEMPLATE_DESC, DATA_TEMPLATE_CONTENT);
		
		goToWikiHome();
	
		goToAddTemplateWikiPage();
	
		waitForElementPresent(ELEMENT_OLD_TEMPLATE_LINK.replace("${OLD_TEMPLATE_TITLE}", DATA_TEMPLATE_TITLE));
	
		click(ELEMENT_CLOSE_TEMPLATE_LIST);

		editTemplate(DATA_TEMPLATE_TITLE, DATA_NEW_TEMPLATE_TITLE, DATA_TEMPLATE_DESC, DATA_TEMPLATE_CONTENT);
	
		waitForElementPresent(ELEMENT_NEW_TEMPLATE_LINK.replace("${TEMPLATE_TITLE}", DATA_NEW_TEMPLATE_TITLE));
		
		goToWikiHome();
		
		deleteTemplate(DATA_NEW_TEMPLATE_TITLE);
	}
}
