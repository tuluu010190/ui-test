package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class WikiSearch extends WikiLocators{
	
	
	/**
	 * constructor
	 * @param dr
	 */
	public WikiSearch(WebDriver dr){
		this.driver=dr;
	}
	/**
	 * Open space switcher drop down
	 */
	public void goToAdvancedSearchSpaceSwitcher(){
		info("Click on Drop donw");
		click(ELEMENET_ADVANCED_SEARCH_DROP_DOWN);
		Utils.pause(2000);
	}
	/**
	 * Search a space in space switcher
	 * @param text
	 */
	public void searchSpaces(String text){
		if(!text.isEmpty()){
			info("Type a text to search");
			type(ELEMENT_ADVANCED_SEARCH_FILTER,text,true);
		}
	}
	
	/**
	 * Advanced search
	 * @param location
	 */
	public void advancedSearch(String text,String location){
		if(!location.isEmpty()){
			goToAdvancedSearchSpaceSwitcher();
			searchSpaces(location);
			info("Select a location");
			click(ELEMENT_ADVANCED_SEARCH_SPACE_SWITCHER.replace("$space", location));
		}
		if(!text.isEmpty()){
			info("Type a text to search");
			type(ELEMENT_WIKI_ADVANCED_SEARCH_SEARCH_FIELD,text,true);
		}
		Utils.pause(2000);
		info("Click on Search button");
		click(ELEMENT_SEARCH_ADVANCED_SEARCH_BTN);
		Utils.pause(2000);
	}
	/**
	 * Quick search a page
	 * @param text
	 */
	public void quickSeach(String text){
		if(!text.isEmpty()){
			info("Input a text to the searched field");
			type(ELEMENT_WIKI_SEARCH_FIELD,text,true);
		}
		info("Click on Search button");
		click(ELEMENT_WIKI_QUICK_SEARCH_BTN);
		Utils.pause(2000);
	}
	/**
	 * View detail of a page that is listed in searched results page
	 * @param page
	 * @param contentPage
	 */
	public void viewContentOfSearchedPage(String page,String contentPage){
		if(!page.isEmpty()){
			info("Click on the page link in searched results list");
			click(ELEMENT_WIKI_SEARCH_RESULT_PAGE_LINK.replace("$page",page));
			waitForAndGetElement(ELEMENT_CONTENT_WIKI_PAGE
					.replace("$content",contentPage),3000,1);
		}
	}
	
}
