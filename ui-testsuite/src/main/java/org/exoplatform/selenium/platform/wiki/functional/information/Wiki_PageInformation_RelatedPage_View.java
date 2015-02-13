package org.exoplatform.selenium.platform.wiki.functional.information;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.social.ManageMember;
import org.exoplatform.selenium.platform.wiki.BasicAction;
import org.openqa.selenium.By;
import org.testng.annotations.*;
/**
 * @date 13 May 2014
 */
public class Wiki_PageInformation_RelatedPage_View extends BasicAction{

	ManageAccount acc;
	Dialog dialog;
	Button button;	
	ManageMember mMember;	
	NavigationToolbar nav; 

	@BeforeMethod
	public void beforeMethod(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		acc = new ManageAccount(driver,this.plfVersion);
		dialog = new Dialog(driver);
		alert = new ManageAlert(driver, this.plfVersion);
		button = new Button(driver, this.plfVersion);	
		mMember = new ManageMember(driver, this.plfVersion);
		nav = new NavigationToolbar(driver, this.plfVersion);
		acc.signIn(DATA_USER1,DATA_PASS);;		
	}

	@AfterMethod
	public void afterMethod(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 * Case ID:118201
	 * Test Case Name: Check behaviors when long space name in Page Layout.
	 * Pre-Condition: User is member of space : "Check long title for a space 1"
		Wiki of "Check long title for a space 1" has following pages:
		- Page 1
		- Page 2
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/05/13 17:34:46
	 */
	@Test
	public  void test01_CheckBehaviorsWhenLongSpaceNameInPageLayout() {
		info("Test 01 Check behaviors when long space name in Page Layout");
		String spaceName = "Space118201CheckLongTitle";
		String title1 = "Page 1";
		String title2 = "Page 2";
		String wikiPath = "Wiki Home";

		//Pre-Condition: 
		info("Create all space and page");
		mMember.goToAllSpaces();
		mMember.addNewSpace(spaceName, "");
		mMember.goToSpaceMenu("Wiki");
		addBlankWikiPage(title1, title1, 0);
		Utils.pause(1000);
		click(By.linkText(wikiPath));
		addBlankWikiPage(title2, title2, 0);

		/*Step 1: 
		 - Go to "Check long title for a space 1" wiki 
		 *Expected Outcome: - Wiki of "Check long title for a space 1" is displayed	*/
		/*Step 2: 
		 *Input Data: - Open "Page 1"
		 *Expected Outcome: - Page 1 is displayed in the wiki		*/
		/*Step 3: 
		 *Input Data: - Open "More" Menu
		- Select "Page Info"
		 *Expected Outcome: - Page infos of Page 1 are diplayed		*/
		info("Open Page Info");
		mouseOverAndClick(ELEMENT_MORE_LINK);
		mouseOverAndClick(ELEMENT_PAGE_INFO_LINK);
		Utils.pause(1000);

		/*Step 4: 
		 *Input Data: - On "Related Page Layout" click on button "Add More Relations"
		 *Expected Outcome: - the popup is closed
		- "Page 2" is added as a related page on page info layout	*/		

		/*Step 5:
		 *Input Data: 
		- Select "Page 2"
		- Click on "Select" button
		 *Expected Outcome: 
		 - the popup is closed
		 - "Page 2" is added as a related page on page info layout		*/ 
		info("Add Relations page");
		click(ELEMENT_ADD_MORE_RELATION_BUTTON);
		click(By.xpath(ELEMENT_SELECTED_PAGE.replace("${relatedPage}", title1)));
		Utils.pause(500);
		click(button.ELEMENT_SELECT_BUTTON);
		Utils.pause(1000);
		waitForAndGetElement(ELEMENT_RELATED_PAGE.replace("${relatedPage}", title1));

		/*Step 5: 
		 *Input Data: 
		- Check Page Info Layout, on related page part
		 *Expected Outcome: - The space named is displayed correctly		*/ 
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_SPACE.replace("${spaceName}", spaceName)));

		//Delete data test
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Case ID:118202
	 * Test Case Name: Check behaviors when long space name in Select Page popup.
	 * Pre-Condition: User is member of space : "Check long title for a space 1"
		Wiki of "Check long title for a space 1" has following pages:
		- Page 1
		- Page 2
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/05/13 17:34:46
	 */
	@Test
	public  void test02_CheckBehaviorsWhenLongSpaceNameInSelectPagePopup() {
		info("Test 02 Check behaviors when long space name in Select Page popup");
		String spaceName = "Space118202CheckLongTitle";
		String title1 = "Page 1";
		String title2 = "Page 2";
		String wikiPath = "Wiki Home";

		//Pre-Condition: 
		info("Create all space and page");
		mMember.goToAllSpaces();
		mMember.addNewSpace(spaceName, "");
		mMember.goToSpaceMenu("Wiki");
		addBlankWikiPage(title1, title1, 0);
		Utils.pause(1000);
		click(By.linkText(wikiPath));
		addBlankWikiPage(title2, title2, 0);

		/*Step 1: 
		 * - Go to "Check long title for a space 1" wiki 
		 *Expected Outcome: - Wiki of "Check long title for a space 1" is displayed		*/
		/*Step 2: 
		 *Input Data: 
		- Open "Page 1"
		 *Expected Outcome: - Page 1 is displayed in the wiki	*/
		/*Step 3: 
		 *Input Data: - Open "More" Menu
		 - Select "Page Info"
		 *Expected Outcome: - Page infos of Page 1 are diplayed		*/
		info("Open Page Info");
		mouseOverAndClick(ELEMENT_MORE_LINK);
		mouseOverAndClick(ELEMENT_PAGE_INFO_LINK);
		Utils.pause(1000);

		/*Step 4: 
		 *Input Data: 
		- On "Related Page Layout" click on button "Add More Relations"
		 *Expected Outcome: - The popup to select a related page is displayed		*/
		info("Add Relations page");
		click(ELEMENT_ADD_MORE_RELATION_BUTTON);

		/*Step 5: 
		 *Input Data: - Check Space Switcher
		 *Expected Outcome: - "Check long title for a space 1" is displayed correctly		*/		
		info("Check space name");
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_SPACE_DEFAUT.replace("${spaceName}", spaceName)));

		//Delete data test
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Case ID:118203
	 * Test Case Name: Check changes in Add related popup layout.
	 * Pre-Condition: User is member of Space 2
		Space 2 wiki has following pages:
		- Page 1
		- Page 2
		--- Sub-Page 1
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/05/13 17:34:46
	 */
	@Test
	public  void test03_CheckChangesInAddRelatedPopupLayout() {
		info("Test 03 Check changes in Add related popup layout");
		String spaceName = "Space118203";
		String title1 = "Page 1";
		String title2 = "Page 2";
		String wikiPath = "Wiki Home";

		//Pre-Condition: 
		info("Create all space and page");
		mMember.goToAllSpaces();
		mMember.addNewSpace(spaceName, "");
		mMember.goToSpaceMenu("Wiki");
		addBlankWikiPage(title1, title1, 0);
		Utils.pause(1000);
		click(By.linkText(wikiPath));
		addBlankWikiPage(title2, title2, 0);

		/*
		- Go into "Space 2" wiki
		 *Expected Outcome: - "Space 2 " wiki is displayed		*/
		/*
		- Open "More" Menu
		- Select "Page Info"
		 *Input Data: 
		 *Expected Outcome: - Page Info of "Wiki Home" page are displayed 		*/
		info("Open Page Info");
		mouseOverAndClick(ELEMENT_MORE_LINK);
		mouseOverAndClick(ELEMENT_PAGE_INFO_LINK);
		Utils.pause(1000);

		/*
		- On the part dedicated to related page, click on the button "Add More Relations"
		 *Input Data: 
		 *Expected Outcome: - Popup to select a page is displayed
		- Label "Select the space:" with the space switcher are displayed 		*/ 
		info("Add Relations page");
		click(ELEMENT_ADD_MORE_RELATION_BUTTON);
		info("Label Select the spaces");
		waitForAndGetElement(ELEMENT_SELECT_SPACE);

		//Delete data test
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Case ID:118204
	 * Test Case Name: Check changes in Page info layout.
	 * Pre-Condition: User is member of Space 2
		Space 2 wiki has following pages:
		- Page 1
		- Page 2
		--- Sub-Page 1
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/05/13 17:34:46
	 */
	@Test
	public  void test04_CheckChangesInPageInfoLayout() {
		info("Test 04: Check changes in Page info layout");
		String spaceName = "Space118204";
		String title1 = "Page 1";
		String title2 = "Page 2";
		String wikiPath = "Wiki Home";

		//Pre-Condition: 
		info("Create all space and page");
		mMember.goToAllSpaces();
		mMember.addNewSpace(spaceName, "");
		mMember.goToSpaceMenu("Wiki");
		addBlankWikiPage(title1, title1, 0);
		Utils.pause(1000);
		click(By.linkText(wikiPath));
		addBlankWikiPage(title2, title2, 0);

		/*
		- Go to "Space 2" wiki
		 *Expected Outcome: - Wiki Space 2 is displayed 		*/
		/*
		- Select "Page 2" the wiki tree
		 *Input Data: 
		 *Expected Outcome: - "Page 2" is displayed		*/
		/*
		- Open "More" Menu
		- Select "Page Info"
		 *Input Data: 
		 *Expected Outcome: Page info of "Page 2" are displayed 		*/
		mMember.accessSpace(spaceName);
		mMember.goToSpaceMenu("Wiki");
		click(By.linkText(title2));
		info("Open Page Info");
		mouseOverAndClick(ELEMENT_MORE_LINK);
		mouseOverAndClick(ELEMENT_PAGE_INFO_LINK);
		Utils.pause(1000);

		/*
		- On "Related pages" part, click on the button "Add More Relations"
		 *Input Data: 
		 *Expected Outcome: - The popup to select a related page is displayed	*/
		/*
		- Select "Page 1"
		- Click on "Select" button
		 *Input Data: 
		 *Expected Outcome: 
		- The popup is dismissed
		- Page 1 is added in related page part		*/
		info("Add Relations page");
		click(ELEMENT_ADD_MORE_RELATION_BUTTON);
		click(By.xpath(ELEMENT_SELECTED_PAGE.replace("${relatedPage}", title1)));
		Utils.pause(500);
		click(button.ELEMENT_SELECT_BUTTON);
		Utils.pause(1000);
		waitForAndGetElement(ELEMENT_RELATED_PAGE.replace("${relatedPage}", title1));

		/*
		- Check Related page table layout
		 *Input Data: 
		 *Expected Outcome: 
		- First column is Wiki and displaying "Space 2"
		- Second column is Related Pages and displaying "Wiki Home > Page 1"
		- Third column is Actions and displaying a bin icon	*/
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_HEAD_INDEX.replace("${index}","1").replace("${text}", "Wiki")));
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_HEAD_INDEX.replace("${index}", "2").replace("${text}", "Related Pages")));
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_HEAD_INDEX.replace("${index}", "3").replace("${text}", "Actions")));
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_COLUMN_SPACE_INDEX.replace("${spaceName}", spaceName).replace("${index}", "1")));
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_COLUMN_WIKI_HOME.replace("${index}", "2")));
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_COLUMN_WIKI_PAGE.replace("${index}", "2").replace("${relatedPage}", title1)));
		waitForAndGetElement(By.xpath(ELEMENT_RELATED_PAGE_COLUMN_ACTION_INDEX.replace("${index}", "3")));

		//Delete data test
		mMember.goToAllSpaces();
		mMember.deleteSpace(spaceName,300000);
	}

	/**
	 * Qmetry ID: 118192
	 * Case ID 05
	 * View related page
	 * Step 1: Create new pages
	 * Step 2: Add related page
	 * Step 3: View content of related page
	 */
	@Test
	public void test05_ViewRelatedPage(){
		String[][] pageInfo = {{"relatedPage05_1", "relatedPage05_2"}, {"content of page1", "content of page2"}};
		String[][] wikiPath = {{"Wiki Home", "Wiki Home"}, {"Wiki Home/relatedPage05_1", "Wiki Home/relatedPage05_2"}};
		addBlankWikiPageAndRelatePage(2, wikiPath[0], pageInfo, 0, wikiPath[1][0], pageInfo[0][1]);
		Utils.pause(500);
		driver.navigate().refresh();
		Utils.pause(2000);
		click(ELEMENT_RELATED_PAGE.replace("${relatedPage}", pageInfo[0][1]));
		waitForTextPresent(pageInfo[1][1]);
		Utils.captureScreen("FNC_KS_WIKI_INFO_CASE_04");
		deleteWikiPage(wikiPath[1]);
	}

	/**
	 * Qmetry ID: 118193
	 * Case ID 06
	 * View related page when user does not have permission to view
	 * Step 1: Create new pages
	 * Step 2: Add related page
	 * Step 3: View content of related page
	 */
	@Test
	public void test06_ViewRelatedPageWhenUserDoesNotHavePermissionToView(){
		String[][] pageInfo = {{"relatedPage06_1", "relatedPage06_2"}, {"content of page1", "content of page2"}};
		String[][] wikiPath = {{"Wiki Home", "Wiki Home"}, {"Wiki Home/relatedPage06_1", "Wiki Home/relatedPage06_2"}};
		boolean[] editInfo = {false, false, false};
		addBlankWikiPageAndEditPagePermissions(2, wikiPath[0], pageInfo, 0, editInfo, "any", 2);
		addRelatedPage(wikiPath[1][0], pageInfo[0][1]);
		goToWikiPage(wikiPath[1][0], ManageAccount.userType.AUTHOR);
		waitForElementNotPresent(ELEMENT_RELATED_PAGE.replace("${relatedPage}", pageInfo[0][1]));
		Utils.captureScreen("FNC_KS_WIKI_INFO_CASE_05");
		resetDataByDeleteWikiPage(ManageAccount.userType.ADMIN, wikiPath[1]);
	}
}