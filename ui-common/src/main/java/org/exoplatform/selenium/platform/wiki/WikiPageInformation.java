package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class WikiPageInformation extends WikiLocators{
	ManageAlert alert;
	
	/**
	 * constructor
	 * @param dr
	 */
	public WikiPageInformation(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(dr);
	}
	
	/**
	 * Add a relation to a page
	 * @param location
	 * @param page
	 */
	public void addRelations(String location,String page){
		info("Click on Drop down");
		click(ELEMENT_ADD_RELATED_PAGE_POPUP_DROPDOWN);
		Utils.pause(2000);
		if(!location.isEmpty()){
			info("Select a location");
			click(ELEMENT_ADD_RELATED_POPUP_DROPDOWN_LOCATION
					.replace("${location}",location));
		}
		if(!page.isEmpty()){
			info("Select a page in the list");
			click(ELEMENT_ADD_RELATED_POPUP_CONTENT
					.replace("${page}",page));
		}
		info("Save all changes");
		click(ELEMENT_ADD_RELATED_POPUP_SELECT_BTN);
	}

	/**
	 * Open add related page popup
	 */
	public void goToAddRelations(){
		info("Click on Add more relations");
		click(ELEMENT_PAGE_INFO_ADD_MORE_RELATIONS);
		waitForAndGetElement(ELEMENT_ADD_RELATED_PAGE_POPUP_TITLE);
		info("Add related page popup is shown");
	}

	/**
	 * Open Page History
	 */
	public void goToPageHistory(){
		info("Click on View page info button");
		waitForAndGetElement(ELEMENT_PAGE_INFO_VIEW_PAGE_INFO_BTN,2000,0).click();
		info("Page history is shown");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_PAGE_HISTORY_TITLE,2000,0);
	}

	/**
	 * Delete a relation of a page
	 * @param relation
	 */
	public void deleteRelation(String relation){
		info("Click on Delete button");
		waitForAndGetElement(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN
				.replace("${name}",relation),2000,0);
		click(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN
				.replace("${name}",relation));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN
				.replace("${name}",relation));
		info("The relation is deleted");
	}
	
	/**
	 * Delete a relation of a page
	 * @param relation
	 */
	public void deleteRelationWithCancelDeleting(String relation){
		info("Click on Delete button");
		waitForAndGetElement(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN
				.replace("${name}",relation),2000,0);
		click(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN
				.replace("${name}",relation));
		alert.cancelAlert();
		waitForAndGetElement(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN
				.replace("${name}",relation));
		info("The relation isnot deleted");
	}
	/**
	 * Verify that related page is viewed
	 * @param page
	 */
	public void viewRelatedPageContent(String page){
		info("Click on related page");
		click(ELEMENT_PAGE_INFO_RELATED_PAGE_LINK
				.replace("$page",page));
		info("Verify that related page's content is shown");
		waitForAndGetElement(ELEMENT_WIKI_HOME_PAGE_TITLE.replace("${title}",page));
	}
	
}
