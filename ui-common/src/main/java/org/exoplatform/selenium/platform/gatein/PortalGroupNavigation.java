package org.exoplatform.selenium.platform.gatein;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortalGroupNavigation extends PlatformBase {

	ManageAlert alert;
	
	public final String ELEMENT_ADD_NAVIGATION_BUTTON = "//*[@class='btn' and contains(text(),'Add Navigation')]";
	public final String ELEMENT_GROUP_SELECT_ADD_NAVIGATION = "//*[contains(text(),'${groupName}')]/..//a[contains(text(),'Add Navigation')]";
	public final By ELEMENT_CANCEL_BUTON = By.linkText("Cancel");
	public final String ELEMENT_GROUP_NAME = ".//*[@id='UIGroupNavigationGrid']//*[contains(text(),'${groupName}')]";
	public final String ELEMENT_DELETE_NAVIGATION_ICON = "//*[contains(text(),'${groupName}')]/../..//i[@class='uiIconTrash uiIconLightGray']";
	
	public PortalGroupNavigation(WebDriver dr){
		driver = dr;
		alert = new ManageAlert(driver, this.plfVersion);
	} 
	
	
	/**function: add new navigation for group
	 * @param groupName name of group you want to add navigation
	 */
	public void addNewNavigationForGroup(String groupName){
		info("Add navigation for group " + groupName);
		click(ELEMENT_ADD_NAVIGATION_BUTTON);
		click(ELEMENT_GROUP_SELECT_ADD_NAVIGATION.replace("${groupName}", groupName));
		waitForElementNotPresent(ELEMENT_GROUP_SELECT_ADD_NAVIGATION.replace("${groupName}", groupName));
		click(ELEMENT_CANCEL_BUTON);
		waitForAndGetElement(ELEMENT_GROUP_NAME.replace("${groupName}", groupName));
	}
	
	
	/**function delete navigation for group
	 * @param groupName name of Group
	 */
	public void deleteNavigationForGroup(String groupName){
		alert = new ManageAlert(driver);
		info("Delete navigation of group " + groupName);
		click(ELEMENT_DELETE_NAVIGATION_ICON.replace("${groupName}", groupName));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_DELETE_NAVIGATION_ICON.replace("${groupName}", groupName));
	}
	
	
	
}
