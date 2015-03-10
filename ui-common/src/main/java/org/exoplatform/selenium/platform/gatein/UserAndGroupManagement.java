package org.exoplatform.selenium.platform.gatein;

import static org.exoplatform.selenium.TestLogger.info;

import java.awt.Button;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.exoplatform.selenium.Utils;




public class UserAndGroupManagement extends PlatformBase {
	
	Button button;
	
	public final String ELEMENT_LINK_SETUP = ".//*[@id='UISetupPlatformToolBarPortlet']/a";
	public final String ELEMENT_MANAGE_USER = ".//*[@id='UISetupPlatformToolBarPortlet']//a[text()='Users']";
	public final String ELEMENT_GROUP_AND_ROLE_LINK = ".//*[@id='UISetupPlatformToolBarPortlet']//a[contains(text(),'Groups and Roles')]";
	public final By ELEMENT_GROUP_MANAGEMENT_TAB = By.className("uiIconGroup uiIconLightGray");
	public final String ELEMENT_GROUP_MANAGEMENT_INFO = ".//*[contains(text(),'Group Info')]";
	public final By ELEMENT_TAB_MEMBERSHIP_MANAGEMENT = By.className("uiIconMembership uiIconLightGray");
	public final String ELEMENT_MEMBERSHIP_MANAGEMENT_GRID = "//*[contains(text(), 'Add/Edit Membership')]";
	public final By ELEMENT_GROUP_ADD_NEW_ICON = By.className("uiIconPlus uiIconLightGray");
	
	
	public UserAndGroupManagement(WebDriver dr){
		driver = dr;
	} 
	/**
	 * Go to Administrator-->Users-->Users and Groups management
	 */
	public void goToUsersAndGroupsManagement() {
		info("--Go to Users and groups management--");
		click(ELEMENT_LINK_SETUP);
		info("Hover over on the user manage");
		mouseOver(ELEMENT_MANAGE_USER, true);
		waitForAndGetElement(By.xpath(ELEMENT_GROUP_AND_ROLE_LINK), DEFAULT_TIMEOUT, 1, 2);		
		info("Click on group and role link");
		click(ELEMENT_GROUP_AND_ROLE_LINK);
		Utils.pause(1000);
	}
	/**
	 * Select group management tab
	 */
	public void chooseGroupTab() {
		info("-- Choose Group Management tab--");
		click(ELEMENT_GROUP_MANAGEMENT_TAB);
		waitForAndGetElement(ELEMENT_GROUP_MANAGEMENT_INFO);
		Utils.pause(2000);
	}
    /**
     * Select membership management tab
     */
	public void chooseMembershipTab() {
		info("-- Choose Membership Management tab--");
		Utils.pause(500);
		click(ELEMENT_TAB_MEMBERSHIP_MANAGEMENT);
		waitForAndGetElement(ELEMENT_MEMBERSHIP_MANAGEMENT_GRID);
		Utils.pause(2000);
	}
	
}
