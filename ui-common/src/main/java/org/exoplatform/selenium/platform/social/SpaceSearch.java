package org.exoplatform.selenium.platform.social;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author thaopth
 * Date: 08/11/2012
 */

public class SpaceSearch extends SocialBase {
	public final By ELEMENT_SEARCH_TEXTBOX = By.id("SpaceSearch");
	public final String ELEMENT_SEARCH_SPACE_BUTTON = ("//*[@id='UISpaceSearch']//a[contains(@data-original-title, 'Search')]/i");


	public SpaceSearch(WebDriver dr){
		driver = dr;
	}
	//Search space by name
	public void searchSpaceByName (String spaceName, boolean verify) {	
		By DATA_SPACE_LINK = By.linkText(spaceName);	
		System.out.println(DATA_SPACE_LINK);
		info("Input data into search textbox");	
		waitForAndGetElement(ELEMENT_SEARCH_TEXTBOX);	
		type(ELEMENT_SEARCH_TEXTBOX, spaceName, true);	
		info("Click search button");	
		click(ELEMENT_SEARCH_SPACE_BUTTON);
		
		if (verify) {	
			waitForAndGetElement(DATA_SPACE_LINK);		
		}
		else {
			Utils.captureScreen("SearchResultByName");
		}
	}

	//Search space by directory
	public void searchSpaceByDirectory (String charcter) {
		By ELEMENT_DIRECTORY_LINK = By.linkText(charcter);
		waitForAndGetElement(ELEMENT_DIRECTORY_LINK);
		info("Click on specific character");
		click(ELEMENT_DIRECTORY_LINK);
		info("Capture search result");
		Utils.captureScreen("SearchResultByDirectory");	
	}
}
