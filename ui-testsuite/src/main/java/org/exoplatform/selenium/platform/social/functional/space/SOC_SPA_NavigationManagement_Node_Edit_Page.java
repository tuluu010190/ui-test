package org.exoplatform.selenium.platform.social.functional.space;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.PageManagement.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.SpaceNavigation.*;
import static org.exoplatform.selenium.platform.ManageApplications.*;
import java.util.HashMap;
import java.util.Map;
import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thaopth
 * Date: 05/12/2012
 */
public class SOC_SPA_NavigationManagement_Node_Edit_Page extends SocialBase {
	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";
	public int timeToDeleteSpace = 120000;
	
	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods(){
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}
	/*
	 * Space/Navigation Management/Node/Edit Page/Portlet 
	 * Case 18: Check finish function after edit portle with saving page 
	 * Step 1: Add new page by wizard
	 * Step 2: Add new space and add node with page at step 1 for space
	 * Step 3: Edit node's page: edit portlet
	 * Step 4: Finish edit page and check the change
	 */
	@Test
	public void test18_CheckFinishFunctionAfterEditPorletWithSavingPage () {
		//Define test data
		String DATA_NODENAME1 = "page18";
		String DATA_CATEGORY_TITLE = "Collaboration";
		Map<String, String> DATA_ANSWER_PORTLET_ID = new HashMap<String, String>();
		DATA_ANSWER_PORTLET_ID.put("Collaboration/AnswersPortlet", "");
		String DATA_SPACE_NAME = "Space018";
		String DATA_PARENT_NODE = "Wiki";
		String DATA_NODENAME2 = "nodetest01";
		Map<String, String> DATA_LANGUAGE = new HashMap<String, String>();
		DATA_LANGUAGE.put("English", "");

		info("---Add new page by wizard---");

		goToAddPageEditor();

		addNewPageEditor(DATA_NODENAME1, DATA_NODENAME1, "English", DATA_CATEGORY_TITLE, DATA_ANSWER_PORTLET_ID, false);

		info("--Go to my space page---");

		goToMySpacePage();

		info("---Add new space---");

		addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);

		info("---Go to space settings---");

		goToSettings();

		info("---Go to space navigation---");

		goToNavigation();

		info("---Add new node---");

		addNodeWhenSelectpage(DATA_PARENT_NODE, false, DATA_NODENAME2, false, DATA_LANGUAGE, DATA_NODENAME2, DATA_NODENAME1, DATA_NODENAME1, false, false, true);

		info("---Open parent node---");

		click(By.xpath("//a[@class='NodeIcon DefaultPageIcon' and text()='Wiki']"));

		info("---Edit node's page---");

		editNodePage(DATA_NODENAME2);

		info("---Open edit portlet form---");

		editPortletTest();

		info("---Change description---");

		waitForElementPresent(ELEMENT_DESCRIPTION_AREA);

		type(ELEMENT_DESCRIPTION_AREA, "test edit portlet description", true);

		info("---Save and close---");

		click(ELEMENT_SAVECLOSE_LINK);

		info("---Click Finish---");

		click(ELEMENT_FINISH_ICON);

		pause(1000);

		//Verify changed value

		editNodePage(DATA_NODENAME2);

		editPortletTest();

		waitForElementPresent(By.xpath("//textarea[@id='description' and text()='test edit portlet description']"));

		info("---Save and close---");

		click(ELEMENT_SAVECLOSE_LINK);

		info("---Click Finish---");

		click(ELEMENT_FINISH_ICON);

		//Clear data

		restoreData(DATA_SPACE_NAME, timeToDeleteSpace);

		deletePageAtManagePageAndPortalNavigation(DATA_NODENAME1, true,"intranet", false, "");
	}

	/*
	 * Space/Navigation Management/Node/Edit Page/Portlet
	 * Case 23: Check Finish function on editing page after editing page layout
	 * Step 1: Create page by wizard
	 * Step 2: Create new space, add node for space with page above
	 * Step 3: Edit node's page
	 * Step 4: Add more portlet for this page
	 */
	@Test 
	public void test23_CheckFinishFunctionOnEditingPageAfterEditedPageLayout () {
		//Define test data
		String DATA_NODENAME1 = "page23";
		String DATA_CATEGORY_TITLE = "Collaboration";
		Map<String, String> DATA_ANSWER_PORTLET_ID = new HashMap<String, String>();
		DATA_ANSWER_PORTLET_ID.put("Collaboration/AnswersPortlet", "");
		String DATA_SPACE_NAME = "Space023";
		String DATA_PARENT_NODE = "Wiki";
		String DATA_NODENAME2 = "nodetest01";
		Map<String, String> DATA_LANGUAGE = new HashMap<String, String>();
		DATA_LANGUAGE.put("English", "");
		String ELEMENT_COLLABORATION_CATEGORY = ELEMENT_EDIT_PAGE_CATEGORY_MENU.replace("${categoryLabel}", "Collaboration");
		By ELEMENT_APPLICATION_COLLABORATION_CALENDAR = By.id("Collaboration/ContactPortlet");
		By ELEMENT_EDIT_PAGE_PAGE_BODY_COMPONENT = By.id("UIPage");

		info("---Add new page by wizard---");

		goToAddPageEditor();

		addNewPageEditor(DATA_NODENAME1, DATA_NODENAME1, "English", DATA_CATEGORY_TITLE, DATA_ANSWER_PORTLET_ID, false);

		info("--Go to my space page---");

		goToMySpacePage();

		info("---Add new space---");

		addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);

		info("---Go to space settings---");

		goToSettings();

		info("---Go to space navigation---");

		goToNavigation();

		info("---Add new node---");

		addNodeWhenSelectpage(DATA_PARENT_NODE, false, DATA_NODENAME2, false, DATA_LANGUAGE, DATA_NODENAME2, DATA_NODENAME1, DATA_NODENAME1, false, false, true);

		info("---Open parent node---");

		click(By.xpath("//a[@class='NodeIcon DefaultPageIcon' and text()='Wiki']"));

		info("---Edit node's page---");

		editNodePage(DATA_NODENAME2);

		info("---Select category---");

		click(ELEMENT_COLLABORATION_CATEGORY);

		info("---Add more portlet---");

		dragAndDropToObject(ELEMENT_APPLICATION_COLLABORATION_CALENDAR, ELEMENT_EDIT_PAGE_PAGE_BODY_COMPONENT);

		info("---Finish edit page layout---");

		click(ELEMENT_FINISH_ICON);

		info("---Verify new portlet---");

		mouseOver(ELEMENT_MY_SPACES_LINK,true);

		mouseOver(By.linkText(DATA_SPACE_NAME),true);

		mouseOver(By.linkText(DATA_PARENT_NODE), true);

		click(By.linkText(DATA_NODENAME2));

		waitForElementPresent(By.xpath("//div[@class='PortletIcon WindowPortletIcon NovaPortletIcon WindowPortletInfo PortletName' and text()='eXo Collaboration Address Book']"));

		//Clear data

		restoreData(DATA_SPACE_NAME, timeToDeleteSpace);

		deletePageAtManagePageAndPortalNavigation(DATA_NODENAME1, true,"intranet", false, "");
	}

	/*
	 * Space/Navigation Management/Node/Edit Page/Container
	 * Case 04: Check Finish function after editing container of node's page
	 * Step 1: Create space
	 * Step 2: Edit node's page, Edit page layout, go to container tab
	 * Step 3: Edit container of this page and finish
	 */

	@Test
	public void test04_CheckFinishFunctionAfterEditContainer () {

		//Define test data

		String DATA_SPACE_NAME = "SpacePageContainer004";
		String DATA_NODE_NAME = "Wiki";

		info("--Go to my space page---");

		goToMySpacePage();

		info("---Add new space---");

		addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);

		info("---Go to space settings---");

		goToSettings();

		info("---Go to space navigation---");

		goToNavigation();

		info("---Edit node's page---");

		editNodePage(DATA_NODE_NAME);

		info("---Edit container---");

		editContainerTest();

		info("---Edit permission of container---");

		waitForElementPresent(ELEMENT_PERMISSION_TAB);

		click(ELEMENT_PERMISSION_TAB);

		makeItPublic(true);

		save();

		click(ELEMENT_FINISH_ICON);

		//Verify changing container

		editNodePage(DATA_NODE_NAME);

		editContainerTest();

		waitForElementPresent(ELEMENT_PERMISSION_TAB);

		click(ELEMENT_PERMISSION_TAB);

		waitForElementPresent(By.xpath("//input[@id='publicMode' and @checked='checked']"));

		save();

		click(ELEMENT_FINISH_ICON);

		//Clear data

		restoreData(DATA_SPACE_NAME, timeToDeleteSpace);
	}
	/*
	 * Space/Navigation Management/Node/Edit Page/Container
	 * Case 09: Check Finish function after change nodes pages container layout 
	 * Step 1: Add new space
	 * Step 2: Edit node's page
	 * Step 3: Edit layout of container
	 */

	@Test
	public void test09_CheckFinishFunctionAfterChangingNodePageContainerLayout () {
		//Define test data

		String DATA_SPACE_NAME = "SpacePageContainer009";
		String DATA_NODE_NAME = "Discussions";

		info("--Go to my space page---");

		goToMySpacePage();

		info("---Add new space---");

		addNewSpace(DATA_SPACE_NAME, DATA_SPACE_NAME);
		
		info("---Go to Forum of space---");
		
		click(By.xpath("//a[@class='ApplicationAdd' and @title='Discussions']"));
		
		waitForElementPresent(By.linkText("Start Topic"));
		
		info("---Verify layout of page before editing---");
		
		captureScreen("Case009BeforeLayout");

		info("---Go to space settings---");

		goToSettings();

		info("---Go to space navigation---");

		goToNavigation();

		info("---Edit node's page---");

		editNodePage(DATA_NODE_NAME);

		info("---Edit container---");

		editContainerTest();
		
		info("---Change width and height of the container---");
		
		type(ELEMENT_WIDTH_TEXTBOX, "900px", true);
		
		type(ELEMENT_HEIGHT_TEXTBOX, "600px", true);

		save();
		
		click(ELEMENT_FINISH_ICON);

		info("---Verify container layout is edited---");
		
		captureScreen("Case009AfterLayout");
		
		//Clear data
		restoreData(DATA_SPACE_NAME, timeToDeleteSpace);
		
	}

	public void editPortletTest () {

		mouseOver(ELEMENT_PORTLET_LAYOUT, false);

		info("---Click edit portlet---");

		click(ELEMENT_EDIT_PORTLET_ICON);

		waitForElementPresent(ELEMENT_WINDOWN_SETTINGS_TAB);

		info("---Go to windown settings tab---");

		click(ELEMENT_WINDOWN_SETTINGS_TAB);

	}

	public void editContainerTest() {
		info("---Click Container tab---");

		click(ELEMENT_TAB_CONTAINERS);

		mouseOver(ELEMENT_PORTLET_LAYOUT,true);

		click(ELEMENT_EDIT_ICON);
	}
}

