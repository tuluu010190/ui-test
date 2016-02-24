package org.niteco.selenium.platform.rs;

import static org.niteco.selenium.TestLogger.info;

import org.openqa.selenium.WebDriver;

public class RSHomepage extends RSLocators{
	
	
	/**
	 * constructor
	 * @param dr
	 */
	public RSHomepage(WebDriver dr){
		this.driver=dr;
	}
	
	/**
	 * Go to candidate tab
	 */
	public void goToCandidateTab(){
		info("Go to candidate tab");
		info("Click candidates tab");
		waitForAndGetElement(ELEMENT_RS_CANDIDATES_BTN, DEFAULT_TIMEOUT, 1);
		click(ELEMENT_RS_CANDIDATES_BTN);
		waitForAndGetElement(ELEMENT_RS_CANDIDATES_TITLE, DEFAULT_TIMEOUT, 1);
	}	
}