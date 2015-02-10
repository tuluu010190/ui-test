package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiSearchManagement extends PlatformBase{
	
	//Search page
	public final String ELEMENT_SEARCH_RESULT = "//*[@class='uiIconFile']/..//*[contains(text(),'${title}')]";
	public final By ELEMENT_SEARCH_DROPDOWNSPACE = By.xpath("//*[@id='wikis']/..//*[@id='DisplayModesDropDown']");
	public final String ELEMENT_SEARCH_DROPDOWNSPACE_LOCATION = "//*[@title='${location}']";
	public final By ELEMENT_SEARCH_NORESULT = By.xpath("//*[@class='resultInfo noResult']");
	
	/**
	 * constructor
	 * @param dr
	 */
	public WikiSearchManagement(WebDriver dr){
		this.driver=dr;
	}
	
	
	public void advancedSearch(String location){
		info("Click on Drop down");
		click(ELEMENT_SEARCH_DROPDOWNSPACE);
		info("Select a location");
		click(ELEMENT_SEARCH_DROPDOWNSPACE_LOCATION.replace("${location}", location));
	}
	
}
