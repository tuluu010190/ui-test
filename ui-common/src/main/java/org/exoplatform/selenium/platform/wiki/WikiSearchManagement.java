package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class WikiSearchManagement extends WikiLocators{
	
	
	/**
	 * constructor
	 * @param dr
	 */
	public WikiSearchManagement(WebDriver dr){
		this.driver=dr;
	}
	
	/**
	 * Advanced search
	 * @param location
	 */
	public void advancedSearch(String location){
		info("Click on Drop down");
		click(ELEMENT_SEARCH_DROPDOWNSPACE);
		info("Select a location");
		click(ELEMENT_SEARCH_DROPDOWNSPACE_LOCATION.replace("${location}", location));
		info("Click on Search button");
		click(ELEMENT_SEARCH_ADVANCED_SEARCH_BTN);
		Utils.pause(2000);
	}
	
}
