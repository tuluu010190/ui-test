package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationToolbar extends PlatformBase {

	//Go to portal sites
	public static void goToPortalSites() {
		info("--Go to Portal Site Management--");
		mouseOver(ELEMENT_LINK_SETUP, false);
		pause(500);
		mouseOver(ELEMENT_LINK_PORTAL, false);
		pause(500);
		WebElement element;
		element = waitForAndGetElement(ELEMENT_LINK_SITE);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);
	}

	//Go to Portal Manage Pages	
	public static void goToManagePages() {
		info("--Go to Portal Site Management--");			
		mouseOver(ELEMENT_LINK_SETUP, false);
		pause(500);
		mouseOver(ELEMENT_LINK_PORTAL, false);
		pause(500);
		WebElement element;
		element = waitForAndGetElement(ELEMENT_LINK_PAGES);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);
	}

	//Go to Dashboard
	public static void goToDashboard(){
		info("--Go to Dashboard page--");
		WebElement element = driver.findElement(By.id("UserNavigationTabsContainer"));
		actions.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Dashboard")).click();	
	}

	//Go to Users and management page
	public static void goToNewStaff() {
		//info("Go to New Staff");
		goToPage(ELEMENT_SEARCH_ICON_REGISTER, ELEMENT_LINK_SETUP, ELEMENT_LINK_USERS, ELEMENT_LINK_ADDUSERS);
	}

	//Go to My Account
	public static void goToMyAccount(){
		WebElement UI = driver.findElement(By.id("UserNavigationTabsContainer"));
		actions.moveToElement(UI).build().perform();
		driver.findElement(By.linkText("My Account")).click();	
		pause(500);
	}

	//Go to Portal/Group Sites
	public static void goToGroupSites(){
		info("--Go to Portal Site Management--");
		mouseOver(ELEMENT_LINK_SETUP, false);
		pause(500);
		mouseOver(ELEMENT_LINK_PORTAL, false);
		pause(500);
		WebElement element;
		element = waitForAndGetElement(ELEMENT_LINK_GROUP);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);
	}

	//Go to add page locator with Editor
	public static void goToAddPageEditor(){
		mouseOver(ELEMENT_LINK_EDITOR, true);
		pause(500);
		mouseOver(ELEMENT_LINK_EDITOR_PAGE, true);
		pause(500);
		WebElement element = waitForAndGetElement(ELEMENT_LINK_EDITOR_ADD_PAGE);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);

	}

	public static void goToUsersAndGroupsManagement() {
		info("--Go to Users and groups management--");
		goToPage(ELEMENT_LINK_SETUP, ELEMENT_LINK_SETUP, ELEMENT_LINK_USERS, ELEMENT_LINK_USERS_MANAGEMENT);
	}

}
