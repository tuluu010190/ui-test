package org.exoplatform.selenium.platform.administration;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author quynhpt
 * date 22/01/2015
 * Path: Administration-->Portal-->Pages
 */
public class PageManagement extends PlatformBase {
	ManageAlert alert;
	
	public final By ELEMENT_MANAGEPAGES_TITLE=By.xpath(".//*[text()='Manage Pages']");
	public final By ELEMENT_MANAGEPAGES_TITLE_FIELD=By.id("pageTitle");
	public final By ELEMENT_MANAGEPAGES_SEARCH_BUTTON = By.xpath(".//*[@class='uiIconSearch uiIconLightGray']");
	public final By ELEMENT_MANGEPAGES_INFORM_POPUP_OK= By.xpath(".//*[text()='OK']");
	//Results search
	public final String ELEMENT_MANAGEPAGES_CONTENT_TITLE_COLUMN=".//*[text()='${tilte}']";
	public final By ELEMENT_MAGEPAGES_CONTENT_ACTION_COLUMN=By.xpath(".//*[@class='uiIconDelete uiIconLightGray']");
	
	
	public PageManagement(WebDriver dr){
		driver = dr;
		alert = new ManageAlert(dr);
	} 
	
	/**
	 * Input a page's name to Title field
	 * @param titlePage
	 */
	public void inputTitle(String titlePage){
		waitForAndGetElement(ELEMENT_MANAGEPAGES_TITLE_FIELD);
		type(ELEMENT_MANAGEPAGES_TITLE_FIELD,titlePage,true);
		Utils.pause(2000);
		click(ELEMENT_MANAGEPAGES_SEARCH_BUTTON);
		waitForAndGetElement(ELEMENT_MANAGEPAGES_CONTENT_TITLE_COLUMN.replace("${tilte}",titlePage));
	}
	
	/**
	 * Delete a page
	 * @param titlePage
	 */
	public void deletePage(String titlePage){
		info("Delete a page");
		inputTitle(titlePage);
		click(ELEMENT_MAGEPAGES_CONTENT_ACTION_COLUMN);
		alert.acceptAlert();
		waitForAndGetElement(ELEMENT_MANGEPAGES_INFORM_POPUP_OK);
		click(ELEMENT_MANGEPAGES_INFORM_POPUP_OK);
		waitForElementNotPresent(ELEMENT_MANAGEPAGES_CONTENT_TITLE_COLUMN.replace("${tilte}",titlePage));
	}
	
}