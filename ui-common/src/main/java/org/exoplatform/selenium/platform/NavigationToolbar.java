package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationToolbar extends PlatformBase {
	
	public final By ELEMENT_MENU_EDIT_LINK = By.xpath("//i[@class='uiIconPLF24x24Edit']");
	public final By ELEMENT_MENU_EDIT_CONTENT = By.xpath("//i[@class='quickEditChecked']");
	public final By ELEMENT_EDIT_MENU_ID = By.xpath("//*[@id='UIAdminToolbarPortlet']/../..");
	public final By ELEMENT_SEO_MENU = By.xpath("//span[text()='SEO']");
	
	public NavigationToolbar(WebDriver dr){
		driver = dr;
	} 

	//Go to portal sites
	public void goToPortalSites() {
		info("--Go to Portal Site Management--");
		String url = DEFAULT_BASEURL + "/g/:platform:administrators/portalnavigation";
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				driver.get(url);
				break;
			}
			//mouseOverAndClick(ELEMENT_LINK_SETUP);
			mouseOver(ELEMENT_LINK_SETUP, true);
			if (waitForAndGetElement(ELEMENT_LINK_PORTAL, 5000, 0)!= null) {	
				mouseOver(ELEMENT_LINK_PORTAL, false);
				if (waitForAndGetElement(ELEMENT_LINK_SITES, 5000, 0)!= null){
					click(ELEMENT_LINK_SITES);
					break;
				}
			}
			info("Retry...[" + repeat + "]");
		}
		waitForTextPresent("Manage Sites");
	}

	//Go to Portal Manage Pages	
	public void goToManagePages() {
		info("--Go to Portal Site Management--");
		String url = DEFAULT_BASEURL + "/g/:platform:administrators/administration/pageManagement";
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				driver.get(url);
				break;
			}
			//mouseOverAndClick(ELEMENT_LINK_SETUP);
			mouseOver(ELEMENT_LINK_SETUP, true);
			if (waitForAndGetElement(ELEMENT_LINK_PORTAL, 5000, 0)!= null) {	
				mouseOver(ELEMENT_LINK_PORTAL, false);
				if (waitForAndGetElement(ELEMENT_LINK_PAGES, 5000, 0)!= null){
					click(ELEMENT_LINK_PAGES);
					break;
				}
			}
			info("Retry...[" + repeat + "]");
		}
		waitForTextPresent("Page Id");
	}

	//Go to Dashboard
	public void goToDashboard(){
		info("--Go to Dashboard page--");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_ACCOUNT_NAME_LINK);
				break;
			}
			mouseOver(ELEMENT_ACCOUNT_NAME_LINK, true);
			if (waitForAndGetElement(ELEMENT_DASHBROARD_LINK, 5000, 0) != null){
				info("Element " + ELEMENT_DASHBROARD_LINK + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
		//mouseOverAndClick(ELEMENT_ACCOUNT_NAME_LINK);
		click(ELEMENT_DASHBROARD_LINK);
		waitForTextPresent("My Dashboard");
	}

	//Go to User management page
	public void goToNewStaff() {
		info("Go to New Staff");
		//goToPage(ELEMENT_SEARCH_ICON_REGISTER, ELEMENT_LINK_SETUP, ELEMENT_LINK_USERS, ELEMENT_LINK_ADD_USERS);
		//mouseOverAndClick(ELEMENT_LINK_SETUP);
		//mouseOver(ELEMENT_LINK_SETUP, true);
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LINK_SETUP);
				break;
			}
			mouseOver(ELEMENT_LINK_SETUP, true);
			if (waitForAndGetElement(ELEMENT_LINK_USERS, 5000, 0) != null){
				info("Element " + ELEMENT_LINK_USERS + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
		click(ELEMENT_LINK_USERS);
		Utils.pause(1000);
	}

	
	//Function go to My Setting
	public void goToMySetting(){
		info("---Go to My Setting ---");
		mouseOver(ELEMENT_ACCOUNT_NAME_LINK, true);
		mouseOverAndClick(ELEMENT_MY_SETTING);
		Utils.pause(1000);
	}

	//Go to Portal/Group Sites
	public void goToGroupSites(){
		info("--Go to Group Site Management--");
		String url = DEFAULT_BASEURL + "/g/:platform:administrators/groupnavigation";
		driver.get(url);
		Utils.pause(1000);
	}

	//Go to add page locator with Editor
//	public void goToAddPageEditor(){
//		info("Go to add page editor");
//		((JavascriptExecutor)driver).executeScript("javascript:ajaxGet(eXo.env.server.createPortalURL('UIWorkingWorkspace', 'PageCreationWizard', true));");
//		waitForTextPresent("Page Creation Wizard");
//	}

	public void goToUsersAndGroupsManagement() {
		info("--Go to Users and groups management--");
		mouseOver(ELEMENT_LINK_SETUP, true);
		WebElement element = waitForAndGetElement(By.xpath(ELEMENT_GROUP_AND_ROLE_LINK), DEFAULT_TIMEOUT, 1, 2);		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Utils.pause(500);
	}

	//Go to Portal Application Registry
	public void goToApplicationRegistry() {
		info("--Go to Portal Application Registry--");
		for (int repeat = 0;; repeat ++){
			if (repeat > 4){
				mouseOverAndClick(ELEMENT_LINK_SETUP);
				break;
			}
			mouseOver(ELEMENT_LINK_SETUP, false);
			if (waitForAndGetElement(ELEMENT_APPLICATIONS_LINK, 3000, 0) != null){
				info("Link application is displayed");
				break;
			}
			info("Retry..." + repeat + "...");
		}
		click(ELEMENT_APPLICATIONS_LINK);
		Utils.pause(500);
	}

	public void goToEditPageEditor () {
		info("----Go to Edit page editor----");
		String id = waitForAndGetElement(By.xpath("//*[@class='UIPage']")).getAttribute("id").replace("UIPage-", "");
		((JavascriptExecutor)driver).executeScript("javascript:ajaxGet(eXo.env.server.createPortalURL('" + id + "', 'EditCurrentPage', true));");
	}

	//Go to change language for user interface
	public void goToChangeLanguageForUserInterface(){
		Actions actions = new Actions(driver);
		info("--Go to change language for user interface--");
		WebElement UI = driver.findElement(By.id("UserNavigationTabsContainer"));
		actions.moveToElement(UI).build().perform();
		driver.findElement(By.linkText("Change Language")).click();	
		Utils.pause(500);
	}

	//Go to register page in public mode
	public void goToRegisterPageInPublicMode(WebDriver driverTest){
		String registerPageLink = baseUrl.concat("/portal/intranet/Register");
		driverTest.get(registerPageLink);
		waitForTextPresent("Create a New Account");
	}

	// Go to content administration
	public void goToContentAdministration()
	{
		String url = DEFAULT_BASEURL + "/g/:platform:web-contributors/wcmAdmin";
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				driver.get(url);
				break;
			}
			//mouseOverAndClick(ELEMENT_LINK_SETUP);
			mouseOver(ELEMENT_LINK_SETUP, true);
			if (waitForAndGetElement(ELEMENT_MENU_CONTENT_LINK, 5000, 0)!= null) {	
				mouseOver(ELEMENT_MENU_CONTENT_LINK, true);
				if (waitForAndGetElement(ELEMENT_LINK_CONTENT_ADMIN, 5000, 0)!= null){
					click(ELEMENT_LINK_CONTENT_ADMIN);
					break;
				}
			}
			info("Retry...[" + repeat + "]");
		}
		waitForTextPresent("Manage ECM Main Functions");
	}

	//Enter Sites Management Form 
	public void goToSiteExplorer(){
		Utils.pause(500);
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LINK_SETUP);
				break;
			}
			mouseOver(ELEMENT_LINK_SETUP, true);
			if (waitForAndGetElement(ELEMENT_MENU_CONTENT_LINK, 5000, 0) != null){
				info("Element " + ELEMENT_MENU_CONTENT_LINK + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
		//mouseOverAndClick(ELEMENT_LINK_SETUP);
		//mouseOver(ELEMENT_LINK_SETUP, true);
		mouseOverAndClick(ELEMENT_MENU_CONTENT_LINK);
		//click(ELEMENT_MENU_SITE_EXPLORER);
		Utils.pause(2000);
	}

	/**
	 * @author lientm
	 */
	public void goToPersonalDocuments(){
		info("Go to Intranet/Documents");
		Utils.pause(500);
		click(ELEMENT_PERSONAL_DOCUMENTS);
		waitForTextPresent("Personal Documents");
	}
	
	//Go to Page Creation Wizard
	public void goToPageCreationWizard(){
		info("Go to add page wizard");
		((JavascriptExecutor)driver).executeScript("javascript:ajaxGet(eXo.env.server.createPortalURL('UIWorkingWorkspace', 'PageCreationWizard', true));");
		waitForTextPresent("Page Creation Wizard");
	}

	//Go To Content Administration / Advanced Configuration / Manage Lock Tab
	/*public void goToLockTabInContentAdmin(){
		goToContentAdministration();
		click(ELEMENT_ADVANCED_CONFIGURATION_TAB);
		click(ELEMENT_MANAGE_LOCKS);
		click(ELEMENT_MANAGE_LOCK_TAB);
		Utils.pause(1000);
	}*/

	//Function to go to SEO management
	public void goToSeoManagement(){
		info("Go to SEO management form");
		Utils.pause(1000);
		mouseOverAndClick(ELEMENT_MENU_EDIT_LINK);
		mouseOver(ELEMENT_MENU_PAGE_LINK, true);
		WebElement seo = waitForAndGetElement(ELEMENT_SEO_MENU,10000,0,2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",seo);		
		Utils.pause(1000);
	}
	
	//Function go to Home Page
	public void goToHomePage(){
		click(ELEMENT_HOME_PAGE);
		Utils.pause(1000);
	}
	
	public void changeEditMode()
	{
		mouseOver(ELEMENT_MENU_EDIT_LINK,true);
		mouseOverAndClick(ELEMENT_MENU_EDIT_CONTENT);
	}
	
	//Function go to My Profile
	public void goToMyProfile(){
		info("---Go to My Profile ---");
		mouseOverAndClick(ELEMENT_ACCOUNT_NAME_LINK);
		mouseOverAndClick(ELEMENT_MY_PROFILE_LINK);
	}
}
