package org.exoplatform.selenium.platform.plf.functional.homepagegadgets;

import org.exoplatform.selenium.platform.HomePageGadget;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.ManageApplications;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PageEditor;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ActionBar;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ContentTemplate;
import org.exoplatform.selenium.platform.ecms.contentexplorer.SitesExplorer;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ContextMenu.actionType;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.exoplatform.selenium.TestLogger.info;

/**
 * @date 24/1/2014
 * @author HangNTT
 *
 */
public class PLF_HomepageGadgets_FavoritesDocuments extends PlatformBase {
	ActionBar actBar;
	ManageAccount magAcc;
	NavigationToolbar navToolBar;
	EcmsBase ecms;
	ContentTemplate cTemp;
	PageEditor pageEditor;
	ManageApplications magApp;
	SitesExplorer siteExp;
	HomePageGadget hpGadget;

	@BeforeMethod
	public void beforeMethods() {
		initSeleniumTest();
		driver.get(baseUrl);
		actBar = new ActionBar(driver, this.plfVersion);
		navToolBar = new NavigationToolbar(driver, this.plfVersion);
		cTemp = new ContentTemplate(driver, this.plfVersion);
		ecms = new EcmsBase(driver, this.plfVersion);
		magAcc = new ManageAccount(driver, this.plfVersion);
		pageEditor = new PageEditor(driver, this.plfVersion);
		magApp = new ManageApplications(driver, this.plfVersion);
		siteExp = new SitesExplorer(driver, this.plfVersion);
		hpGadget = new HomePageGadget(driver, this.plfVersion);
		magAcc.signIn(DATA_USER1, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods() {
		info("Remove portlet");
		magAcc.signIn(DATA_USER1, DATA_PASS);
		navToolBar.goToEditPageEditor();
		click(ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(pageEditor.ELEMENT_VIEW_PAGE_PROPERTIES);
		pageEditor.removePortlet(hpGadget.ELEMENT_GADGET_PORLET_IN_MIDDLE_HOME_PAGE, hpGadget.ELEMENT_DELETE_ICON_GADGET_PORLET_IN_MIDDLE_HOME_PAGE);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 * Case ID:74341.
	 * Test Case Name: Check all the favorite documents.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by phuongdt at 2014/02/10 09:51:54
	 */
	@Test
	public  void test01_CheckAllTheFavoriteDocuments() {
		String name1 = "webname1" + getRandomNumber();
		String content1= "webcontent1" + getRandomNumber();
		String name2 = "webname2" + getRandomNumber();
		String content2= "webcontent2" + getRandomNumber();
		String namelink1 = name1+".lnk";
		String namelink2 = name2+".lnk";

		info("Add Favorite Documents gadget to homepage");
		navToolBar.goToEditLayout();
		click(ELEMENT_CATEGORY_TOOLS);
		click(ELEMENT_SWITCH_VIEW_MODE);
		dragAndDropToObject(hpGadget.ELEMENT_APPLICATION_FAVORITEDOCUMENT, hpGadget.ELEMENT_MIDDLE_CONTAINER);
		pageEditor.finishEditLayout();	

		info("Test 1: Check all the favorite documents");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Add favorite documents by adding in Favorite folder
		 *Input Data: 
			- Go to Content Explorer
			- Select Private drive
			- Select Favorites folder
			- Create new content
		 *Expected Outcome: 
			New content is created successfully in Favorites folder*/
		//Add icon "new content" to action bar
		navToolBar.goToPersonalDocuments();
		actBar.goToViewMode("Admin");
		actBar.addItem2ActionBar("addDocument", actBar.ELEMENT_NEW_CONTENT_LINK, "Admin", "Admin");
		navToolBar.goToPersonalDocuments();
		actBar.goToViewMode("Admin");
		info("-- Go to favorite --");
		actBar.goToNodeByAddressPath("/Favorites");
		actBar.goToAddNewContent();
		cTemp.createNewWebContent(name1, content1, "", "", "", "", false);
		actBar.goToNodeByAddressPath("/Favorites");
		waitForAndGetElement(ecms.ELEMENT_NODE_ADMIN_VIEW.replace("${nodeName}", namelink1));
		actBar.goToNodeByAddressPath("/");

		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Check the displaying of favorite document
		 *Input Data: 
			- Go to intranet homepage
			- In Favorite Documents gadget
			- Select My Favorite tab
		 *Expected Outcome: 
			All favorite documents are shown*/
		navToolBar.goToHomePage();
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_GADGET_WORKSPACE_FRAME));
		click(hpGadget.ELEMENT_FAVORITEDOCUMENT_ICON_HOMEPAGE);
		waitForAndGetElement(ecms.ELEMENT_NODE_ADMIN_VIEW.replace("${nodeName}", namelink1));
		actBar.goToNodeByAddressPath("/");
		driver.switchTo().defaultContent();

		/*Step number: 3
		 *Step Name: -
		 *Step Description: 
			Step 1: Add favorite documents by adding favorite action
		 *Input Data: 
			- Go to Content Explorer
			- Select Private drive
			- Create new content
			- Right click on this content and select “Add to Favorite”
		 *Expected Outcome: 
			- New content is created successfully 
			- After add favorite, a symlink of content is created in Favorite folder*/
		navToolBar.goToPersonalDocuments();
		actBar.goToNodeByAddressPath("/");
		actBar.goToAddNewContent();
		cTemp.createNewWebContent(name2, content2, "", "", "", "", false);
		actBar.goToNodeByAddressPath("/");
		click(By.xpath(siteExp.ELEMENT_SELECT_CHECKBOX.replace("${name}", name2)), 2);
		actBar.goToAddToFavorite();
		actBar.goToNodeByAddressPath("/Favorites");
		waitForAndGetElement(ecms.ELEMENT_NODE_ADMIN_VIEW.replace("${nodeName}", namelink2));
		actBar.goToNodeByAddressPath("/");

		/*Step number: 4
		 *Step Name: -
		 *Step Description: 
			Step 2: Check the displaying of favorite document
		 *Input Data: 
			- Go to intranet homepage
			- In Favorite Documents gadget
			- Select My Favorite tab
		 *Expected Outcome: 
			All favorite documents are shown*/ 
		navToolBar.goToHomePage();
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_GADGET_WORKSPACE_FRAME));
		click(hpGadget.ELEMENT_FAVORITEDOCUMENT_ICON_HOMEPAGE);
		waitForAndGetElement(ecms.ELEMENT_NODE_ADMIN_VIEW.replace("${nodeName}", namelink1));
		waitForAndGetElement(ecms.ELEMENT_NODE_ADMIN_VIEW.replace("${nodeName}", namelink2));
		actBar.goToNodeByAddressPath("/");
		driver.switchTo().defaultContent();

		/*Clear data*/
		info("Clear data");
		navToolBar.goToHomePage();
		navToolBar.goToEditPageEditor();
		click(ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(pageEditor.ELEMENT_VIEW_PAGE_PROPERTIES);
		pageEditor.removePortlet(hpGadget.ELEMENT_GADGET_PORLET_IN_MIDDLE_HOME_PAGE, hpGadget.ELEMENT_DELETE_ICON_GADGET_PORLET_IN_MIDDLE_HOME_PAGE);
		driver.switchTo().defaultContent();
		navToolBar.goToPersonalDocuments();
		actBar.actionsOnElement(name2, actionType.DELETE);
		actBar.goToNodeByAddressPath("/Favorites");
		actBar.actionsOnElement(name1, actionType.DELETE);
		actBar.goToNodeByAddressPath("/");
	}
}