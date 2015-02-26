package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiSearchManagement extends PlatformBase{
	
	//Search page
	public final String ELEMENT_SEARCH_RESULT = "//*[@class='uiIconFile']/..//*[contains(text(),'${title}')]";
	public final By ELEMENT_SEARCH_DROPDOWNSPACE = By.xpath("//*[@id='wikis']/..//*[@id='DisplayModesDropDown']");
	public final String ELEMENT_SEARCH_DROPDOWNSPACE_LOCATION = "//*[@title='${location}']";
	public final By ELEMENT_SEARCH_NORESULT = By.xpath("//*[@class='resultInfo noResult']");
	public final By ELEMENT_SEARCH_ADVANCED_SEARCH_BTN=By.xpath(".//*[@id='UIWikiAdvanceSearchForm']/button[text()='Search']");
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
