package org.exoplatform.selenium.platform.wiki.functional.basicaction;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.social.ManageMember;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.wiki.ManageDraft;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.exoplatform.selenium.platform.ManageAccount;

/**
 * @author hantv
 *
 */
public class Wiki_BasicAction_MoveAPage extends ManageDraft {
	ManageAccount magAcc;
	Button button;
	ManageMember magMember;

	//Space
	SpaceManagement spaceMag;
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		magAcc = new ManageAccount(driver);
		button = new Button(driver);
		magAcc.signIn(DATA_USER1,DATA_PASS);;
		spaceMag = new SpaceManagement(driver);

	}
	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	String[] user1= {DATA_USER3};
	/**
	 *Case ID:69785.
	 *Test Case Name: Move a page when user does not have edit permission on destination page.
	 *Pre-Condition: 
	 *Post-Condition: 
	 *Done with OSs and browsers : 
	 *Generated by hantv at 2014/03/24 11:53:09
	 */
	@Test
	public  void test01_MoveAPageWhenUserDoesNotHaveEditPermissionOnDestinationPage() {
		String PAGE_NAME1 = "wiki6";
		String PAGE_NAME2 = "wiki7";
		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);
		By ELEMENT_PAGE2 = By.linkText(PAGE_NAME2);

		String ELEMENT_VERIRY_MESSAGE = "You have no edit permission at the destination page";
		goToWiki();
		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);
		addPagePermission(0,user1);
		editPagePermission(DATA_USER3, true, true, false, 2);
		deletePagePermission("any");
		click(ELEMENT_WIKI_HOME);
		addBlankWikiPage(PAGE_NAME2, PAGE_NAME2, 0);
		editPagePermission("any", true, false, false, 2);
		magAcc.signOut();
		
		info("-- James can not move Wiki6 to Wiki 7 --");
		magAcc.signIn(DATA_USER3, "gtn");
		goToWiki();
		click(ELEMENT_PAGE1);
		movePage(PAGE_NAME1,PAGE_NAME2);
		waitForTextPresent(ELEMENT_VERIRY_MESSAGE);
		click(button.ELEMENT_OK_BUTTON);
		waitForElementNotPresent(button.ELEMENT_OK_BUTTON);

		//cancel();
		click(ELEMENT_CANCEL_BUTTON_MOVE_PAGE);
		waitForElementNotPresent(ELEMENT_CANCEL_BUTTON_MOVE_PAGE);
		magAcc.signOut();
		magAcc.signIn(DATA_USER1,DATA_PASS);;
		goToWiki();
		click(ELEMENT_PAGE1);
		deleteCurrentWikiPage();
		click(ELEMENT_PAGE2);
		deleteCurrentWikiPage();
	}

	/**
	 *Case ID:69786.
	 *Test Case Name: Move a page when user doesn't have edit permission on page.
	 *Pre-Condition: 
	 *Post-Condition: 
	 *Done with OSs and browsers : 
	 *Generated by hantv at 2014/03/24 11:53:09
	 */
	@Test
	public  void test02_MoveAPageWhenUserDoesntHaveEditPermissionOnPage() {
		String PAGE_NAME1 = "wiki5";
		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);
		goToWiki();
		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);
		addPagePermission(0,user1);
		deletePagePermission("any");
		magAcc.signOut();
		magAcc.signIn(DATA_USER3, "gtn");
		goToWiki();
		click(ELEMENT_PAGE1);
		//mouseOver(ELEMENT_MORE_LINK, true);
		mouseOverAndClick(ELEMENT_MORE_LINK);
		waitForElementNotPresent(ELEMENT_MOVE_PAGE_LINK);
		magAcc.signOut();
		magAcc.signIn(DATA_USER1,DATA_PASS);;
		goToWiki();
		click(ELEMENT_PAGE1);
		deleteCurrentWikiPage();
	}

	/**
	 *Case ID:69787.
	 *Test Case Name: Move a page when user have edit permission on page.
	 *Pre-Condition: 
	 *Post-Condition: 
	 *Done with OSs and browsers : 
	 *Generated by hantv at 2014/03/24 11:53:09
	 */
	@Test
	public  void test03_MoveAPageWhenUserHaveEditPermissionOnPage() {
		String PAGE_NAME1 = "wiki1";
		String PAGE_NAME2 = "wiki2";
		By ELEMENT_PAGE1 = By.linkText(PAGE_NAME1);
		By ELEMENT_PAGE2 = By.linkText(PAGE_NAME2);
		goToWiki();
		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);
		//click(ELEMENT_PAGE1);
		deletePagePermission("any");
		addPagePermission(0, user1);
		editPagePermission(DATA_USER3, true, true, false, 2);
		click(ELEMENT_WIKI_HOME);
		addBlankWikiPage(PAGE_NAME2, PAGE_NAME2, 0);
		//click(ELEMENT_PAGE2);
		deletePagePermission("any");
		addPagePermission(0, user1);
		editPagePermission(DATA_USER3, true, true, false, 2);
		magAcc.signOut();
		magAcc.signIn(DATA_USER3, DATA_PASS);
		goToWiki();
		click(ELEMENT_PAGE1);		
		movePage(PAGE_NAME1, PAGE_NAME2);
		waitForAndGetElement(ELEMENT_DESTINATION_TREE_ITEM.replace("${treeItem}", PAGE_NAME2));
		click(ELEMENT_PAGE2);
		deleteCurrentWikiPage();
	}

	/**
	 *Case ID:79563.
	 *Test Case Name: Page's sub-pages should be moved with the page
	 */
	@Test
	public  void test04_PagesSubpagesShouldBeMovedWithThePage() {
		String PAGE_NAME1 = "pagetomove79563";
		String PAGE_SUB1 = "pagesub795631";
		String PAGE_SUB2 = "pagesub795632";
		String PAGE_NAME2 = "pagetodest79563";
		String spacemove = "moves79563";
		String spacedest = "dests79563";

		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spacedest, "");
		waitForAndGetElement(By.linkText(spacedest));
		goToWikiFromSpace(spacedest);
		addBlankWikiPage(PAGE_NAME2, PAGE_NAME2, 0);

		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spacemove, "");
		waitForAndGetElement(By.linkText(spacemove));
		goToWikiFromSpace(spacemove);
		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);
		click(By.linkText(PAGE_NAME1));
		addBlankWikiPage(PAGE_SUB1, PAGE_SUB1, 0);
		click(By.linkText(PAGE_NAME1));
		addBlankWikiPage(PAGE_SUB2, PAGE_SUB2, 0);
		click(By.linkText(PAGE_NAME1));
		movePage(PAGE_NAME1, "",spacedest,false);
		click(By.linkText(PAGE_NAME1));
		waitForAndGetElement(By.linkText(PAGE_SUB1));
		waitForAndGetElement(By.linkText(PAGE_SUB2));
		
		/*Clear data*/
		spaceMag.goToAllSpaces();
		spaceMag.deleteSpace(spacemove,300000);
		spaceMag.deleteSpace(spacedest,300000);
	}

	/**
	 *Case ID:79568.
	 *Test Case Name: Page's attachments should be move with the page.
	 *Pre-Condition: User is member of "Space Move" and "Space Destination 2"Wiki of "Space Move" has:
	- Page A
	- Page B
	- Page with attachments (with two images in its content)Wiki of "Space Destination 2" is empty.
	 *Post-Condition: 
	 *Done with OSs and browsers : 
	 *Generated by hantv at 2014/03/24 11:53:09
	 */
	@Test
	public  void test05_PagesAttachmentsShouldBeMoveWithThePage() {

		String PAGE_NAME1 = "pagetomove"+getRandomNumber();
		String spacemove = "movespace"+getRandomNumber();
		String spacedest = "destspace"+getRandomNumber();
		String fileImage1 = "landscape08.jpg";
		String fileImage2 = "portrait08.jpg";
		
		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spacedest, "");

		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spacemove, "");
		spaceMag.goToSpaceFromMySpaceNavigation(spacemove);
		goToWikiFromSpace(spacemove);
		info("Create Page with attachments (with two images in its content)");
		addWikiPageRichText(PAGE_NAME1, PAGE_NAME1);
		Utils.pause(1000);
	 	info("Insert image1");
		insertImageFile(fileImage1,false);
		Utils.pause(1000);
		info("Insert image2");
		insertAttachNewFile(fileImage2, "", "",true);
		savePage();
		Utils.pause(500);
		
		info("Move page");
		click(By.linkText(PAGE_NAME1));
		movePage(PAGE_NAME1, "",spacedest,false);

		info("Check content of page with attachments 1");
		click(By.linkText(PAGE_NAME1));
		if(isElementNotPresent(By.linkText(fileImage2)))
		click(ELEMENT_ATTACHMENT_ICON);
		waitForAndGetElement(By.linkText(fileImage2));
		waitForAndGetElement(By.linkText(fileImage1));
		info("image2");
		waitForTextPresent(fileImage1);
		
		/*Clear data*/
		spaceMag.goToAllSpaces();
		spaceMag.deleteSpace(spacemove,300000);
		spaceMag.deleteSpace(spacedest,300000);
	}

	/**
	 *Case ID:79569.
	 *Test Case Name: Page's sub-pages and attachments should be moved with the page.
	 *Pre-Condition: User is member of "Space Move" and "Space Destination 2"
	 *Wiki of "Space Move" has:
	 *- Page A
	 *- Page B
	 *- Page with Sub-Pages
	 *--- Sub-Page with attachments 1 (two images in its content)
	 *--- Sub-Page with attachments 2 (two files as attachments)
	 *Wiki of "Space Destination 2" has:
	 *- Page with attachments (with two images in its content)
	 */
	@Test
	public  void test06_PagesSubpagesAndAttachmentsShouldBeMovedWithThePage() {
		String spaceMove = "SpaceMove"+getRandomNumber();
		String spaceDest = "SpaceDestination"+getRandomNumber();
		String title1 = "Page A";
		String title2 = "Page B";
		String title3 = "Page with Sub-Pages";
		String subpage1 = "SubPage1";
		String fileImage1 = "ECMS_DMS_SE_File.jpg";
		String fileImage2 = "ECMS_se_admin_export.jpg";
		
		String subpage2 = "SubPage2";
		String linkAttach1 = "Wiki_Sniff_Attachment_01.doc";
		String linkAttach2 = "ECMS_CSS_File_Color_Blue.txt";
		
		String title4 = "Page with attachments";
		String fileImage41 = "landscape08.jpg";
		String fileImage42 = "portrait08.jpg";
		
		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spaceDest, "");
		goToWikiFromSpace(spaceDest);
		info("Create Page with attachments (with two images in its content)");
		Utils.pause(500);
		addWikiPageRichText(title4, "");
		insertImageFile(fileImage41,false);
		Utils.pause(1000);
		info("Insert image2");
		insertAttachNewFile(fileImage42, "", "",true);
		savePage();
		Utils.pause(500);
		
		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spaceMove, "");
		goToWikiFromSpace(spaceMove);
		addBlankWikiPage(title1, title1, 0);
		Utils.pause(1000);
		click(By.linkText("Wiki Home"));
		Utils.pause(1000);
		addBlankWikiPage(title2, title2, 0);
		click(By.linkText("Wiki Home"));		
		Utils.pause(1000);
		addBlankWikiPage(title3, title3, 0);
		
		info("Add Sub-Page with attachments 1 (two images in its content)");
		Utils.pause(500);
		addWikiPageRichText(subpage1, "");
		insertImageFile(fileImage1,true);
		Utils.pause(1000);
		info("Insert image2");
		insertAttachNewFile(fileImage2, "", "",true);
		savePage();
		Utils.pause(500);	
		waitForAndGetElement(By.linkText(subpage1));
		
		info("Add Sub-Page with attachments 2 (two files as attachments)");
		click(By.linkText(title3));
		addWikiPageRichText(subpage2, "");
		insertAttachNewFile(linkAttach1, "", "", true);
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_FRAME).sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_FRAME).sendKeys(Keys.RETURN);
		insertAttachNewFile(linkAttach2, "", "", true);
		savePage();
		Utils.pause(500);
		waitForAndGetElement(By.linkText(subpage2));
		
		click(By.linkText(title3));
		movePage(title3, "",spaceDest,false);
		
		goToWikiFromSpace(spaceDest);
		click(By.linkText(title3));
		info("Check content of the Sub-Page with attachments 1");
		click(By.linkText(subpage1));
		if(isElementNotPresent(By.linkText(fileImage2)))
			click(ELEMENT_ATTACHMENT_ICON);
		waitForAndGetElement(By.linkText(fileImage2));
		waitForAndGetElement(By.linkText(fileImage1));
		
		info("Check content of the Sub-Page with attachments 2");
		click(By.linkText(title3));
		click(By.linkText(subpage2));
		if(isElementNotPresent(By.linkText(linkAttach1)))
			click(ELEMENT_ATTACHMENT_ICON);
		waitForAndGetElement(By.linkText(linkAttach1));
		waitForAndGetElement(By.linkText(linkAttach2));	

		/*Clear data*/
		spaceMag.goToAllSpaces();
		spaceMag.deleteSpace(spaceMove,300000);
		Utils.pause(3000);
		spaceMag.deleteSpace(spaceDest,300000);
	}

	/**
	 *Case ID:79573.
	 *Test Case Name: Space names displayed in location labels should be user friendly and not technical.
	 *Pre-Condition: User is member of "Space Move" and "Space Destination 2"Wiki of "Space Move" has:
	- Page B
	 *Post-Condition: 
	 *Done with OSs and browsers : 
	 *Generated by hantv at 2014/03/24 11:53:09
	 */
	@Test
	public  void test07_SpaceNamesDisplayedInLocationLabelsShouldBeUserFriendlyAndNotTechnical() {
		String PAGE_NAME1 = "pagetomove79573";
		String PAGE_NAME2 = "pagetodest79573";

		String spacemove = "Movespace79573";
		String spacedest = "Destspace79573";

		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spacedest, "");
		waitForAndGetElement(By.linkText(spacedest));
		goToWikiFromSpace(spacedest);
		addBlankWikiPage(PAGE_NAME2, PAGE_NAME2, 0);

		spaceMag.goToMySpacePage();
		spaceMag.addNewSpace(spacemove, "");
		waitForAndGetElement(By.linkText(spacemove));
		goToWikiFromSpace(spacemove);
		addBlankWikiPage(PAGE_NAME1, PAGE_NAME1, 0);
		click(By.linkText(PAGE_NAME1));
		info("Move page to Space Destination");
		movePage(PAGE_NAME1, PAGE_NAME2, spacedest, false);

		/*Clear data*/
		spaceMag.goToAllSpaces();
		spaceMag.deleteSpace(spacemove,300000);
		spaceMag.deleteSpace(spacedest,300000);
	}
}