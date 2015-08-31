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
	 * Verify that Add page button isnot shown
	 */
	public void verifyNotShowAddPageBtn(){
		info("Verify that Add Page button isnot shown");
		waitForElementNotPresent(ELEMENT_ADD_PAGE_LINK);
		info("The button is not shown");
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
	 * Select any page
	 * @param title
	 */
	public void cancelDeleteWiki(String title){
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
			waitForAndGetElement(ELEMENT_CANCEL_WIKI_DELETE,2000,0).click();
			waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",title));
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
	
	/**
	 * Verify the page isnot created and shown in the list
	 * @param title
	 */
	public void verifyNOTTitleWikiPage(String title){
		info("Verify that the wiki page isnot created and shown in the list");
		waitForElementNotPresent(ELEMENT_WIKI_PAGE_LINK.replace("${pageTitle}",title));
		info("The wiki page isnot created successfully");
	}
	/**
	 * Verify that warning message is shown
	 * @param mess
	 */
	public void verifyWarningMessage(String mess){
		info("Verify that the warning message is shown");
		waitForAndGetElement(ELEMENT_MESSAGES_TEXT
				.replace("$mess",mess));
		info("Close the warning popup");
		click(ELEMENT_WARNING_OK_BTN);
		waitForElementNotPresent(ELEMENT_WARNING_OK_BTN);
	}
	/**
	 * Verify Confirmation message
	 * @param mess
	 * @param isConfirm
	 */
	public void verifyConfirmationMess(String mess,Boolean isConfirm){
		info("Verify that the warning message is shown");
		waitForAndGetElement(ELEMENT_MESSAGES_TEXT
				.replace("$mess",mess));
		confirmWaringMessage(isConfirm);
		Utils.pause(2000);
	}
	/**
	 * Confirm messages
	 * @param isConfirm
	 *                  = true if want to click on Confirm button
	 *                  = false if want to click on Cancel button
	 */
	public void confirmWaringMessage(Boolean isConfirm){
		if(isConfirm){
			if(waitForAndGetElement(ELEMENT_CONFIRM_POPUP_OK_BTN,2000,0)!=null){
				info("Click on OK button");
				click(ELEMENT_CONFIRM_POPUP_OK_BTN);
			}
			if(waitForAndGetElement(ELEMENT_CONFIRM_POPUP_CONFIRM_BTN,2000,0)!=null){
				info("Click on Confirm button");
				click(ELEMENT_CONFIRM_POPUP_CONFIRM_BTN);
			}
			if(waitForAndGetElement(ELEMENT_CONFIRM_POPUP_YES_BTN,2000,0)!=null){
				info("Click on Yes button");
				click(ELEMENT_CONFIRM_POPUP_YES_BTN);
			}
			if(waitForAndGetElement(ELEMENT_CONFIRM_POPUP_YES_BTN,2000,0)!=null){
				info("Click on Yes button");
				click(ELEMENT_CONFIRM_POPUP_YES_BTN);
			}
		}else{
			if(waitForAndGetElement(ELEMENT_CONFIRM_POPUP_CANCEL_BTN,2000,0)!=null){
				info("Click on Cancel button");
				click(ELEMENT_CONFIRM_POPUP_CANCEL_BTN);
			}
			
			if(waitForAndGetElement(ELEMENT_CONFIRM_POPUP_NO_BTN,2000,0)!=null){
				info("Click on No button");
				click(ELEMENT_CONFIRM_POPUP_NO_BTN);
			}
			
		}
	}
	/**
	 * Verify that a table is added to the content of the page
	 */
	public void verifyTableInContentPage(int col,int row){
		info("Verify that the table is shown into the content of the page");
		waitForAndGetElement(ELEMENT_PAGE_CONTENT_TABLE_MODE);
		for(int i=1;i<=col;i++){
			info("A table is shown with the col:"+col);
			waitForAndGetElement(ELEMETN_PAGE_CONTENT_TABLE_COL_NUM
					.replace("$col",String.valueOf(col)));
		}
		for(int i=1;i<=row;i++){
			info("A table is shown with the row:"+row);
			waitForAndGetElement(ELEMETN_PAGE_CONTENT_TABLE_ROW_NUM
					.replace("$row",String.valueOf(row)));
		}
		info("A table isnot shown with the col:"+col+1);
		waitForElementNotPresent(ELEMETN_PAGE_CONTENT_TABLE_COL_NUM
				.replace("$col",String.valueOf(col+1)));
		info("A table isnot shown with the row:"+row+1);
		waitForElementNotPresent(ELEMETN_PAGE_CONTENT_TABLE_ROW_NUM
				.replace("$row",String.valueOf(row+1)));
	}
	
	/**
	 * 
	 *Define effect types in Source Editor
	 */
	public enum effectTypes{
		Bold,Bullest_List,Number_List,Heading1,Heading3,
		Heading5,Italic,Link,Strike,Underline;
	}
	
	
	
	/**
	 * Verify effects of Page's content
	 * @param type
	 */
	public void verifyEffectsPageContent(effectTypes type,String content) {
		switch(type){
		case Bold:
			info("Verify Bold effect");
			waitForAndGetElement(ELEMENT_EFFECT_BOLD.replace("$content",content));
			break;
		case Bullest_List:
			info("Verify Bullest list");
			waitForAndGetElement(ELEMENT_EFFECT_BULLET_LIST.replace("$content",content));
			break;
		case Number_List:
			info("Verify Number list");
			waitForAndGetElement(ELEMENT_EFFECT_NUMBER_LIST.replace("$content",content));
			break;
		case Heading1:
			info("Verify Heading1 effect");
			waitForAndGetElement(ELEMENT_EFFECT_HEADING_1.replace("$content",content));
			break;
		case Heading3:
			info("Verify Heading3 effect");
			waitForAndGetElement(ELEMENT_EFFECT_HEADING_3.replace("$content",content));
			break;
		case Heading5:
			info("Verify Heading4 effect");
			waitForAndGetElement(ELEMENT_EFFECT_HEADING_5.replace("$content",content));
			break;
		case Italic:
			info("Verify Italic effect");
			waitForAndGetElement(ELEMENT_EFFECT_ITALIC.replace("$content",content));
			break;
		case Link:
			info("Verify Link effect");
			waitForAndGetElement(ELEMENT_EFFECT_LINK.replace("$content",content));
			break;
		case Strike:
			info("Verify Strike effect");
			waitForAndGetElement(ELEMENT_EFFECT_STRIKE.replace("$content",content));
			break;
		case Underline:
			info("Verify Underline effect");
			waitForAndGetElement(ELEMENT_EFFECT_UNDERLINE.replace("$content",content));
			break;
		}
	}
	
}
