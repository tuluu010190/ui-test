package org.exoplatform.selenium.platform.gatein;

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
public class PortalManagePages extends PlatformBase {
	ManageAlert alert;
	
	public final By ELEMENT_MANAGEPAGES_TITLE=By.xpath(".//*[text()='Manage Pages']");
	public final By ELEMENT_MANAGEPAGES_TITLE_FIELD=By.id("pageTitle");
	public final By ELEMENT_MANAGEPAGES_SEARCH_BUTTON = By.xpath(".//*[@class='uiIconSearch uiIconLightGray']");
	public final By ELEMENT_MANGEPAGES_INFORM_POPUP_OK= By.xpath(".//*[text()='OK']");
	//Results search
	public final String ELEMENT_MANAGEPAGES_CONTENT_TITLE_COLUMN=".//*[text()='${tilte}']";
	public final By ELEMENT_MAGEPAGES_CONTENT_ACTION_COLUMN_DELETE=By.xpath(".//*[@class='uiIconDelete uiIconLightGray']");
	public final By ELEMENT_MAGEPAGES_CONTENT_ACTION_COLUMN_EDIT=By.xpath(".//*[@class='uiIconEditInfo uiIconLightGray']");
	
	public PortalManagePages(WebDriver dr){
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
		click(ELEMENT_MAGEPAGES_CONTENT_ACTION_COLUMN_DELETE);
		alert.acceptAlert();
		waitForAndGetElement(ELEMENT_MANGEPAGES_INFORM_POPUP_OK);
		click(ELEMENT_MANGEPAGES_INFORM_POPUP_OK);
		waitForElementNotPresent(ELEMENT_MANAGEPAGES_CONTENT_TITLE_COLUMN.replace("${tilte}",titlePage));
	}
	
	/**
	 * Go to edit a page
	 * @param titilePage
	 */
	public void editPage(String titlePage){
		info("Go to edit a page");
		inputTitle(titlePage);
		waitForElementNotPresent(ELEMENT_MANAGEPAGES_CONTENT_TITLE_COLUMN.replace("${tilte}",titlePage));
	}
	
}
