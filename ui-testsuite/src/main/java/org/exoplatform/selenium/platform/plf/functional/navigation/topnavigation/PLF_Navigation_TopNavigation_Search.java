package org.exoplatform.selenium.platform.plf.functional.navigation.topnavigation;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

/**
 * @author chinhdtt
 * @date 24 Mar 2014
 */
public class PLF_Navigation_TopNavigation_Search extends PlatformBase{
	ManageAccount acc;
	NavigationToolbar nav;

	@BeforeMethod
	public void beforeMethods(){	
		initSeleniumTest();
		driver.get(baseUrl);
		acc = new ManageAccount(driver, this.plfVersion);
		nav = new NavigationToolbar(driver, this.plfVersion);				
		acc.signIn(DATA_USER1, DATA_PASS);		
	}

	@AfterMethod
	public void afterMethods() {
		info("Logout portal");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 * Case ID:76643.
	 * Test Case Name: Collapse the Search box after an expand from button.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/03/24 14:00:25
	 * 
	 */
	@Test 
	public  void test01_CollapseTheSearchBoxAfterAnExpandFromButton() {
		info("Test 1: Collapse the Search box after an expand from button");
		/*
		- Connect to Intranet
		 *Input Data: 
		 *Expected Outcome: 
		- The Top Navigation bar is displayed
		- The icon "Search" is collapsed		*/
		info("Check navigation bar");
		waitForAndGetElement(ELEMENT_NAVIGATION_TOOLBAR_HOMEPAGE);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_ICON);
		waitForElementNotPresent(ELEMENT_QUICK_SEARCH_TEXTBOX);

		/*Click on the Search button
		 *Input Data: 
		 *Expected Outcome: The button is expanded 	*/
		mouseOverAndClick(ELEMENT_QUICK_SEARCH_ICON);
		Utils.pause(1000);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_TEXTBOX);
		
		/*
		- Click outside the search box
		 *Input Data: 
		 *Expected Outcome: The field Search is collapsed		*/ 
		mouseOverAndClick(ELEMENT_NAVIGATION_TOOLBAR_HOMEPAGE);
		Utils.pause(500);
		waitForElementNotPresent(ELEMENT_QUICK_SEARCH_TEXTBOX);
		Utils.pause(500);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_ICON);
	}

	/**
	 * Case ID:76645.
	 * Test Case Name: Expand the Search box.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/03/24 14:00:25
	 */
	@Test 
	public  void test02_ExpandTheSearchBox() {
		info("Test 2: Expand the Search box");
		/*
		- Connect to Intranet
		 *Input Data: 
		 *Expected Outcome: 
		- The Top Navigation bar is displayed
		- The icon "Search" is collapsed		*/
		info("Check top Navigation bar");
		waitForAndGetElement(ELEMENT_NAVIGATION_TOOLBAR_HOMEPAGE);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_ICON);
		waitForElementNotPresent(ELEMENT_QUICK_SEARCH_TEXTBOX);
		
		/*Click on the Search button
		 *Input Data: 
		 *Expected Outcome: The button is expanded 		*/ 	
		mouseOverAndClick(ELEMENT_QUICK_SEARCH_ICON);
		Utils.pause(1000);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_TEXTBOX);
	}

	/**
	 * Case ID:76647.
	 * Test Case Name: Search by click on key "ENTER".
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/03/24 14:00:25
	 */
	@Test
	public  void test03_SearchByClickOnKeyENTER() {
		info("Test 3: Search by click on key ENTER");
		String searchString = "John";
		
		/*
		- Connect to Intranet
		 *Input Data: 
		 *Expected Outcome: 
		- The Top Navigation bar is displayed
		- The icon "Search" is collapsed		*/
		info("Check top Navigation bar");
		waitForAndGetElement(ELEMENT_NAVIGATION_TOOLBAR_HOMEPAGE);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_ICON);

		/*Click on the Search button
		 *Input Data: 
		 *Expected Outcome: The button is expanded with a message: "Search:"		*/
		mouseOverAndClick(ELEMENT_QUICK_SEARCH_ICON);
		Utils.pause(1000);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_TEXTBOX);

		/*
		- Input an available keyword
		- Click on the key "ENTER" from the Keyboard
		 *Input Data: 
		 *Expected Outcome: The page of search result is displayed		*/ 
		type(ELEMENT_QUICK_SEARCH_TEXTBOX, searchString, true);
		Utils.pause(500);
		waitForAndGetElement(ELEMENT_SEE_ALL_SEARCH_RESULTS);
		WebElement searchText = waitForAndGetElement(ELEMENT_QUICK_SEARCH_TEXTBOX);
		searchText = driver.switchTo().activeElement();
		searchText.click();
		searchText.sendKeys(Keys.RETURN);
		Utils.pause(1000);	
		waitForAndGetElement(ELEMENT_RESULT_SEARCH_PAGE);
//		waitForAndGetElement(ELEMENT_RESULT_CONTENT_DETAIL);		
	}

	/**
	 * Case ID:76648.
	 * Test Case Name: Search by click on the search icon.
	 * Pre-Condition: 
	 * Post-Condition: 
	 * Done with OSs and browsers : 
	 * Generated by chinhdtt at 2014/03/24 14:00:25
	 */
	@Test
	public  void test04_SearchByClickOnTheSearchIcon() {
		info("Test 4: Search by click on the search icon");
		String searchString = "John";
		
		/*
		- Connect to Intranet
		 *Input Data: 
		 *Expected Outcome: 
		- The Top Navigation bar is displayed
		- The icon "Search" is collapsed		*/
		info("Check top navigation bar");
		waitForAndGetElement(ELEMENT_NAVIGATION_TOOLBAR_HOMEPAGE);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_ICON);
		
		/*Click on the Search button
		 *Input Data: 
		 *Expected Outcome: The button is expanded 	*/
		mouseOverAndClick(ELEMENT_QUICK_SEARCH_ICON);
		Utils.pause(1000);
		waitForAndGetElement(ELEMENT_QUICK_SEARCH_TEXTBOX);
		
		/*
		- Input an available keyword
		- Click on the button "Search" at the box Search
		 *Input Data: 
		 *Expected Outcome: The page of search result is displayed		*/ 
		type(ELEMENT_QUICK_SEARCH_TEXTBOX, searchString, true);
		Utils.pause(500);
		waitForAndGetElement(ELEMENT_SEE_ALL_SEARCH_RESULTS);
		mouseOverAndClick(ELEMENT_QUICK_SEARCH_ICON);
		Utils.pause(1000);	
		waitForAndGetElement(ELEMENT_RESULT_SEARCH_PAGE);
//		waitForAndGetElement(ELEMENT_RESULT_CONTENT_DETAIL);
	}
}