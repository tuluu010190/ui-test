package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class WikiHomePage extends WikiLocators{
	Dialog dialog;
	/**
	 * constructor
	 * @param dr
	 */
	public WikiHomePage(WebDriver dr){
		this.driver=dr;
		dialog = new Dialog(dr);
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
		click(ELEMENT_PERMISSION_LINK);
		waitForAndGetElement(ELEMENT_PAGE_PERMISSION_POPUP);
		info("The permission popup is shown");
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
			if(waitForAndGetElement(ELEMENT_WARNING_OK_BTN,2000,0)!=null){
				info("Click OK button");
				click(ELEMENT_WARNING_OK_BTN);
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
	 * Get a permalink of the page
	 * @return perLink
	 */
	public void goToPermalink(){
		info("Go to permalink");
		mouseOverAndClick(ELEMENT_MORE_LINK);
		mouseOverAndClick(ELEMENT_PERMALINK_LINK);
		waitForAndGetElement(ELEMENT_PERMALINK_POPUP);
		Utils.pause(2000);
	}

	/**
	 * Public a page from infor bar or More menu
	 * @param opParams
	 */
	public void publicPage(Boolean...opParams){
		info("Make Public page");
		Boolean useRestrictLink = (Boolean)(opParams.length>0 ? opParams[0]:false);
		if(useRestrictLink){
			waitForAndGetElement(ELEMENT_RESTRICTED_WIKI_ICON);
			click(ELEMENT_RESTRICTED_WIKI_ICON);
		}
		else{
			goToPermalink();
		}
		click(ELEMENT_MAKE_PUBLIC_BUTTON);
		waitForAndGetElement(ELEMENT_MAKE_RESTRICT_BUTTON);
		dialog.closeMessageDialog();
		Utils.pause(2000);
	}
	/**
	 * Restricted a page from infor bar or More menu
	 * @param opParams
	 */
	public void restrictedPage(Boolean...opParams){
		info("Make Restricted page");
		Boolean useRestrictLink = (Boolean)(opParams.length>0 ? opParams[0]:false);
		if(useRestrictLink){
			waitForAndGetElement(ELEMENT_PUBLIC_WIKI_ICON );
			click(ELEMENT_PUBLIC_WIKI_ICON );
		}
		else{
			goToPermalink();
		}
		click(ELEMENT_MAKE_RESTRICT_BUTTON);
		waitForAndGetElement(ELEMENT_MAKE_PUBLIC_BUTTON);
		dialog.closeMessageDialog();
		Utils.pause(2000);
	}
	
	/**
	 * Gets a permanent link by a given value.
	 * 
	 * @return The value.
	 */
	public String getPermalink(){
		return getValue(ELEMENT_PERMALINK_TEXT);
	}
	/**
	 * Close permalink popup
	 */
	public void closePermalinkPopup(){
		info("Click on Close button");
		click(ELEMENT_PERMALINK_CLOSE);
		waitForElementNotPresent(ELEMENT_PERMALINK_POPUP);
		info("Permalink popup is closed");
	}
	
	/**
	 * Go to attach files in Wiki Home page
	 * @param number
	 */
	public void goToAttachFiles(String number){
		info("Click attach file link");
		Utils.pause(2000);
		waitForAndGetElement(ELEMENT_PAGE_ATTACHFILE_NUMBER.replace("${number}", number), DEFAULT_TIMEOUT, 1);
		click(ELEMENT_PAGE_ATTACHFILE_NUMBER.replace("${number}", number));
	}
	
	/**
	 * Delete attach file in View mode in Wiki Homepage 
	 * or in edit mode when editing a wiki page
	 * @param fileName
	 */
	public void DeleteAttachFiles(String fileName){
		info("Delete attach files");
		Utils.pause(2000);
		if (waitForAndGetElement(ELEMENT_PAGE_DELETEATTACHFILE_VIEW_MODE.replace("${fileName}", fileName), 5000, 0) != null){
			click(ELEMENT_PAGE_DELETEATTACHFILE_VIEW_MODE.replace("${fileName}", fileName));
			waitForElementNotPresent(ELEMENT_PAGE_DELETEATTACHFILE_VIEW_MODE.replace("${fileName}", fileName));
		}
		else{
			waitForAndGetElement(ELEMENT_PAGE_DELETEATTACHFILE_VIEW_MODE_2.replace("${fileName}", fileName), DEFAULT_TIMEOUT, 0);
			click(ELEMENT_PAGE_DELETEATTACHFILE_VIEW_MODE_2.replace("${fileName}", fileName));
			waitForElementNotPresent(ELEMENT_PAGE_DELETEATTACHFILE_VIEW_MODE_2.replace("${fileName}", fileName));
			}
	}
	/**
	 * Go to Wiki Home of the space
	 * @param space
	 */
	public void goToWikiHomeOfSpaceFromBreadcrumb(String space){
		goToSpaceSwitcher();
		if(!space.isEmpty()){
			info("Select the space");
			click(ELEMENT_SPACE_SWITCHER_SELECTED_SPACE
					.replace("$space",space));
			waitForAndGetElement(ELEMENT_WIKI_HOME_BREADCRUMB_PATH_HOME
					.replace("$locator1",space)
					.replace("$locator2","Wiki Home"));
		}
	}
	/**
	 * Open Space switcher
	 */
	public void goToSpaceSwitcher(){
		info("Click on drop down");
		click(ELEMENT_SPACE_DROP_DOWN);
		Utils.pause(2000);
	}
	
	/**
	 * Input and search a space in space switcher
	 * @param text
	 */
	public void inputSpaceSwitcher(String text){
		waitForAndGetElement(ELEMENT_SPACE_SWITCHER_INPUT).clear();
		waitForAndGetElement(ELEMENT_SPACE_SWITCHER_INPUT).click();
		waitForAndGetElement(ELEMENT_SPACE_SWITCHER_INPUT).sendKeys(text);
		Utils.pause(1000);
		
	}
	/**
	 * Close space switcher
	 */
	public void closeSpaceWitcher(){
		info("Click on Close button");
		click(ELEMENT_SPACE_SWITCHER_CLOSE_BTN);
		waitForElementNotPresent(ELEMENT_SPACE_SWITCHER_INPUT);
	}
	/**
	 * Close space switcher by clicking on outside
	 */
	public void closeSpaceSwitcherByClickOutSide(){
		info("Click on outside to close space switcher");
		click(ELEMENT_SPACE_SWITCHER_OUTSIDE);
		waitForElementNotPresent(ELEMENT_SPACE_SWITCHER_INPUT);
	}
	
}
