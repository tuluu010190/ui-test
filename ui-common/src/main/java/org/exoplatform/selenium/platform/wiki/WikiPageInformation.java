package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
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
	
	/**
	 * View version's content of a Wiki page
	 * @param num
	 */
	public void viewVersion(int num){
		info("--View a version of a page--");
		click(ELEMENT_PAGE_INFO_RECENT_CHANGES_VERSION
				   .replace("$num",String.valueOf(num)));
        waitForAndGetElement(ELEMENT_PAGE_INFOR_VIEW_CONTENT_TITLE);	
	}
	/**
	 * view content of next version
	 */
	public void viewConentVersionByNextArrow(){
		if(waitForAndGetElement(ELEMENT_VIEW_VERSION_NEXT_BTN,2000,0)!=null){
			info("Click on Next button");
			click(ELEMENT_VIEW_VERSION_NEXT_BTN);
		}
		Utils.pause(2000);
		
	}
	/**
	 * View content of previous version
	 */
    public void viewContentVersionByPreviousArrow(){
    	if(waitForAndGetElement(ELEMENT_VIEW_VERSION_PREVIOUS_BTN,2000,0)!=null){
    		info("Click on Previous button");
			click(ELEMENT_VIEW_VERSION_PREVIOUS_BTN);
		}
    	Utils.pause(2000);
	}
	/**
	 * View current version from View Content page
	 */
	public void viewCurrentVersion(){
		info("View current version");
		click(ELEMENT_PAGE_INFO_VIEW_CONTENT_CURRENT_VERSION_LINK);
		Utils.pause(2000);
	}

	/**
	 * Compare 2 reversion
	 * @param reversion1 as v.1
	 * @param reversion2 as v.2
	 */
	public void compareTwoReversion(String reversion1, String reversion2){
		if(!reversion1.isEmpty()){
			info("Select reversion 1");
			check(ELEMENT_WIKI_PAGE_PAGE_HISTORY_CHECKBOX
					.replace("${reversion}",reversion1),2);
		}
		if(!reversion2.isEmpty()){
			info("Select reversion 2");
			check(ELEMENT_WIKI_PAGE_PAGE_HISTORY_CHECKBOX
					.replace("${reversion}",reversion2),2);
		}
		info("Click on Compare button");
		click(ELEMENT_WIKI_PAGE_PAGE_HISTORY_COMPARE_BTN);
	
	}
	
	/** 
	 * Restore version of a Wiki page
	 * 
	 * @param version
	 * 			 number of version
	 */
	public void restoreVersion(String version){
		info("--Restore a version of a page--");
		String versionLink = ELEMENT_RESTORE_LINK.replace("{$version}",version);
		if (isTextPresent("Page History")){
			info("-- You are currently in the revision page --");		
		}else{
			click(ELEMENT_REVISION_LINK);
		}
		Utils.pause(500);
		driver.navigate().refresh();
		Utils.pause(2000);
		click(versionLink);
		Utils.pause(1000);
	}
	
	/**
	 * Change compare versions of Compare version page
	 * 
	 * @param firstNumberVersion
	 * 				first version to compare 
	 * @param secondNumberVersion
	 * 				second version to compare
	 */
	public void changeCompareVersions(String firstNumberVersion, String secondNumberVersion){
		Utils.pause(1000);
		click(ELEMENT_CHANGES_COMPARE_VERSION
				.replace("${1stNumber}", firstNumberVersion)
				.replace("${2ndNumber}", secondNumberVersion));
		waitForElementNotPresent(ELEMENT_CHANGES_COMPARE_VERSION
				.replace("${1stNumber}", firstNumberVersion)
				.replace("${2ndNumber}", secondNumberVersion));
	}
}
