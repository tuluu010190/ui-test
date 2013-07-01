package org.exoplatform.selenium.platform.wiki.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.wiki.Version;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author lientm
 * @date: 1-July-2013
 */

public class Wiki_Information extends Version {
	
	ManageAccount magAc;
	Button but;
	
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		magAc = new ManageAccount(driver);
		but = new Button(driver);
		magAc.signIn("john", "gtn"); 
		goToWiki();
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	/**CaseId: 68843 -> Show Page Information
	 */
	@Test
	public void test01_PageInformation(){
		String title = "Wiki_sniff_infor_page_title_01";
		String content = "Wiki_sniff_infor_page_content_01";
		String link = "Wiki_Sniff_Attachment_01.doc";
		String newTitle = "Wiki_sniff_infor_page_title_01_update";
		String newContent = "Wiki_sniff_infor_page_content_01_update";
		
		addBlankWikiPageHasAttachment(title, content, link);
		editWikiPage(newTitle, newContent, 0);
		
		info("View Information of page");
		waitForAndGetElement(ELEMENT_CREATOR_PAGE_INFO.replace("${fullName}", "John Smith"));
		waitForAndGetElement(ELEMENT_UPDATER_PAGE_INFO.replace("${fullName}", "John Smith"));
		waitForAndGetElement(ELEMENT_VIEW_CHANGE);
		waitForAndGetElement(ELEMENT_ATTACHMENT_NUMBER.replace("${No}", "1"));
		waitForAndGetElement(ELEMENT_VERSION_LINK.replace("{$version}", "2"));
		
		deleteCurrentWikiPage();
	}
	
	/**CaseId: 70047 -> Show Page History
	 * 
	 */
	@Test
	public void test02_PageHistory(){
		String title = "Wiki_sniff_infor_page_title_02";
		String content = "Wiki_sniff_infor_page_content_02";
		String newTitle = "Wiki_sniff_infor_page_title_02_update";
		String newContent = "Wiki_sniff_infor_page_content_02_update";
		
		addBlankWikiPage(title, content, 0);
		editWikiPage(newTitle, newContent, 0);
		
		goToPageInfoFromCurrentPage();
		viewPageHistory();
		
		info("Compare 2 version of page");
		compareVersion("1", "2");
		waitForAndGetElement(ELEMENT_LINE_REMOVE.replace("${lineRemove}", content));
		waitForAndGetElement(ELEMENT_LINE_ADD.replace("${lineAdd}", newContent));
		
		click(By.linkText(newTitle));
		deleteCurrentWikiPage();
	}
	
	/**CaseId: 70337 -> Add Relation between 2 pages different space
	 * 
	 */
	public void test03_AddRelationDifferentSpace(){
		
	}
	
	/**CaseId: 70340 -> Add Relation with intranet
	 * 
	 */
	
	/**CaseId: 70341 -> Add Relation same space
	 * 
	 */
	
	/**CaseId: 70342 -> Add relation in the case there is no space
	 * 
	 */
	@Test
	public void test06_AddRelation_NoSpace(){
		String title = "Wiki_sniff_infor_page_title_06";
		String content = "Wiki_sniff_infor_page_content_06";
		
		addBlankWikiPage(title, content, 0);
		goToAddRelation();
		click(ELEMENT_SELECT_SPACE);
		waitForAndGetElement(ELEMENT_NO_SPACE_OPTION);
		but.cancel();
		
		click(By.linkText(title));
		deleteCurrentWikiPage();
	}
	
	/**CaseId: 70344 -> Delete relation
	 * 
	 */
	@Test
	public void test07_DeleteRelation(){
		String title1 = "Wiki_sniff_infor_page_title_07_1";
		String content1 = "Wiki_sniff_infor_page_content_07_1";
		String title2 = "Wiki_sniff_infor_page_title_07_2";
		String content2 = "Wiki_sniff_infor_page_content_07_2";
		
		addBlankWikiPage(title1, content1, 0);
		goToWikiHome();
		
		addBlankWikiPage(title2, content2, 0);
		addRelatedPage("Wiki Home/" + title1, title2);
		
		removeRelatedPage(true, true, "", title2);
		
		click(By.linkText(title1));
		deleteCurrentWikiPage();
		click(By.linkText(title2));
		deleteCurrentWikiPage();
	}
}
