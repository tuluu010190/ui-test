package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class WikiHomePage extends WikiLocators{

	/**
	 * constructor
	 * @param dr
	 */
	public WikiHomePage(WebDriver dr){
		this.driver=dr;
	}
	/**
	 * Go to "Add blank wiki page"
	 * 
	 */
	public void goToAddBlankPage(){
		info("--Go to add blank wiki page--");
		mouseOverAndClick(ELEMENT_ADD_PAGE_LINK);
		mouseOverAndClick(ELEMENT_BLANK_PAGE_LINK);
		info("Blank wiki page is shown");
	}

	/**
	 * Go to "Add template wiki page"
	 * 
	 */
	public void goToAddTemplateWikiPage(){
		info("--Go to add template wiki page--");
		mouseOverAndClick(ELEMENT_ADD_PAGE_LINK);
		mouseOverAndClick(ELEMENT_FROM_TEMPLATE_LINK);
	}

	/**
	 * Go to "Add blank wiki page"
	 * 
	 */
	public void goToEditPage(){
		info("--Go to edit page--");
		click(ELEMENT_EDIT_PAGE_LINK);
		waitForElementNotPresent(ELEMENT_WIKI_HOME_PAGE_TEXT);
	}

	/**
	 * Go to Home Wiki Page
	 */
	public void goToHomeWikiPage(){
		info("-- Go to wiki home page --");
		click(ELEMENT_WIKI_HOME_PAGE_LINK);
		waitForAndGetElement(ELEMENT_WIKI_HOME_PAGE_TEXT);
	}

	/**
	 * Select any page
	 * @param title
	 */
	public void goToAPage(String title){
		info("-- Go to wiki page --");
		click(ELEMENT_WIKI_PAGE_LINK.replace("${pageTitle}", title.replace(" ", "_")));
		waitForElementNotPresent(ELEMENT_WIKI_HOME_PAGE_TEXT);
	}

	/**
	 * Select any page
	 * @param title
	 */
	public void deleteWiki(String title){
		if(waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",title),3000,0)!=null){
			info("Go to delete wiki page...");
			info("Select the wiki page to delete");
			selectAPage(title);
			info("Click on More link");
			click(ELEMENT_MORE_LINK);
			if (waitForAndGetElement(ELEMENT_DELETE_LINK, 5000, 0) == null){
				mouseOverAndClick(ELEMENT_DELETE_LINK);
			}else {
				click(ELEMENT_DELETE_LINK);
			}
			waitForAndGetElement(ELEMENT_CONFIRM_WIKI_DELETE,2000,0).click();
			waitForElementNotPresent(ELEMENT_TREE_WIKI_NAME.replace("${name}",title));
		}
	}
	/**
	 * Select a page
	 * @param page
	 */
	public void selectAPage(String page){
		info("Go to a wiki page...");
		info("Select the wiki page");
		waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",page),5000,0).click();
		info("The page is shown");
		waitForAndGetElement(ELEMENT_PAGE_TITLE.replace("${title}", page),3000,0);
	}
	/**
	 * Go to "Go to My Draft"
	 * 
	 */
	public void goToMyDraft(){
		info("Click on Browser drop down");
		click(ELEMENT_SEARCH_BROWSERS_DROPDOWN);
		info("Select wiki settings label");
		click(ELEMENT_SEARCH_BROWSERS_MY_DRAFT);
		Utils.pause(2000);
	}
	/**
	 * Open search page with a text
	 * @param text
	 */
	public void goTosearchPage(String text){
		info("Input a text to search field");
		type(ELEMENT_SEARCH_TEXTBOX_POPUP, text, true);
		Utils.pause(1000);
		click(ELEMENT_SEARCH_BTN);
        Utils.pause(2000);
	}
	/**
	 * Open Wiki Settings page
	 */
	public void goToWikiSettingPage(){
		info("Click on Browser drop down");
		click(ELEMENT_SEARCH_BROWSERS_DROPDOWN);
		info("Select wiki settings label");
		click(ELEMENT_SEARCH_BROWSERS_WIKI_SETTINGS);
		Utils.pause(2000);
	}
	
	/**
	 * Open permissions for the wiki
	 */
	public void goToPermissions(){
		info("Permissions page");
		click(ELEMENT_MORE_LINK);
		click(ELEMENT_PAGE_PERMISSIONS);
	}
	/**
	 * Get permalink
	 * @return link
	 */
	public String getPermaLink(){
		String link="";
		click(ELEMENT_MORE_LINK);
		click(ELEMENT_PERMALINK);
		link = waitForAndGetElement(ELEMENT_PERMALINK_LINKCOPY).getAttribute("value");
		return link;
	}
	/**
	 * Verify the page is created and shown in the list
	 * @param title
	 */
	public void verifyTitleWikiPage(String title){
		info("Verify that the wiki page is created and shown in the list");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_LINK.replace("${pageTitle}",title));
		info("The wiki page is created successfully");
	}
}
