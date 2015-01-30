package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.social.MyProfilePage;
import org.exoplatform.selenium.platform.administration.ManageSites;
import org.exoplatform.selenium.platform.administration.PageManagement;
import org.exoplatform.selenium.platform.ecms.SiteExplorerHome;
import org.exoplatform.selenium.platform.gatein.PageCreationWizard;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * Update quynhpt
 * date 22/01/2015
 *
 */
public class NavigationToolbar extends PlatformBase {
	PageCreationWizard paWin;
	PageManagement paMang;
	MyProfilePage myPro;
	SiteExplorerHome SEHome;
	ManageSites magSites;
	//Tool bar
	public final By ELEMENT_TOOLBAR_ADMINISTRATION = By.xpath("//*[@class='uiIconPLF24x24Setup']");
	public final By ELEMENT_TOOLBAR_THEMELIGHT = By.xpath("//*[@class='UIContainer UIToolbarContainer UIToolbarContainerLight']");

	//Administration Menu
	//Administration-->Portal
	public final By ELEMENT_ADMINISTRATION_PORTAL = By.xpath("//*[text()='Portal']");
	public final By ELEMENT_ADMINISTRATION_PORTAL_SITES=By.xpath("//*[text()='Sites']");
	public final By ELEMENT_ADMINISTRATION_PORTAL_PAGES=By.xpath("//*[text()='Pages']");
	public final By ELEMENT_ADMINISTRATION_PORTAL_BRANDING=By.xpath("//*[text()='Branding']");
	public final By ELEMENT_ADMINISTRATION_PORTAL_IDE=By.xpath("//*[text()='IDE']");
	
	//Administation-->Content
	public final By ELEMENT_LINK_CONTENT_ADMIN = By.xpath("//*[text()='Content Administration']");
	public final By ELEMENT_MENU_CONTENT_LINK = By.xpath("//li[@class='dropdown-submenu']/a[text()='Content']");
	public final By ELEMENT_MENU_SITE_EXPLORER = By.linkText("Sites Explorer");
	public final By ELEMENT_SITE_EXPLORER_HOME = By.className("uiIconEcmsHome");
	public final By ELEMENT_NEW_FOLDER_LINK = By.xpath("//*[@class='actionIcon']//*[contains(@class, 'uiIconEcmsAddFolder')]");

	// administration panel
	public final By ELEMENT_TOPBAR_ADMINISTRATION_BUTTON =By.xpath("//*[@class='uiIconPLF24x24Setup']");
	public final By ELEMENT_TOPBAR_CONTENT = By.xpath("//*[@id='UISetupPlatformToolBarPortlet']//a[contains(text(),'Content')]");
	public final By ELEMENT_CONTENT_TOPBAR_ADMINISTRATION = By.xpath("//*[@id='UISetupPlatformToolBarPortlet']//a[contains(text(),'Content Administration')]");
	
	//Setup icon
	public final By ELEMENT_LINK_SETUP=By.xpath("//*[@class='uiIconPLF24x24Setup']");
	public final By ELEENT_LINK_APPLICATION=By.xpath("//*[contains(@href,'/portal/g/:platform:administrators/administration/registry')]");
	
	//Edit menu
	public final By ELEMENT_LINK_EDIT=By.xpath("//*[@class='uiIconPLF24x24Edit']");
	public final By ELEMENT_MENU_PAGE_LINK = By.linkText("Page");
	public final By ELEMENT_MENU_EDIT_LAYOUT = By.linkText("Edit Layout");
	public final By ELEMENT_MENU_SEO_LINK = By.xpath("//span[contains(text(), 'SEO')]");
	public final By ELEMENT_MENU_ADD_PAGE_LINK = By.linkText("Add Page");
	//public final By ELEMENT_EDIT_BUTTON = By.xpath(".//*[@id='UIAdminToolbarContainer']//*[@class='uiIconPLF24x24Edit']");
	public final By ELEMENT_EDIT_PAGE = By.xpath("//*[@id='UIAdminToolbarContainer']//*[@class='dropdown-submenu']//*[@href='#' and contains(text(), 'Page')]");
	public final By ELEMENT_EDIT_PAGE_SEO = By.xpath("//*[@data-original-title = 'SEO Management']");
	public final By ELEMENT_EDIT_CONTENT = By.xpath("//*[@class='quickEditUnchecked']");
	public final By ELEMENT_EDIT_CONTENT_CHECK = By.xpath("//*[@class='quickEditChecked']");
	
	//User Menu
	public final By ELEMENT_MY_PROFILE_LINK = By.xpath("//i[@class='uiIconPLFProfile']/..");
	public final By ELEMENT_TOPBAR_AVATAR = By.xpath("//*[@alt='avatar']");
	public final By ELEMENT_AVATAR_CHANGELANGUAGE = By.xpath("//*[@class='uiIconFlags']");
	
	//Administration-->Application
	public final By ELEMENT_ADMINISTRATION_APPLICATION = By.xpath(".//*[text()='Applications']");
	
	public NavigationToolbar(WebDriver dr){
		driver = dr;
		paMang=new PageManagement(dr);
		myPro = new MyProfilePage(dr);
		paWin = new PageCreationWizard(dr);
		SEHome = new SiteExplorerHome(dr);
		magSites = new ManageSites(dr);
	} 
	
	/**
	 * Go to Portal Application Registry
	 *//*
	public void goToApplicationRegistry() {
		info("--Go to Portal Application Registry--");
		click(ELEMENT_LINK_SETUP);
		click(ELEENT_LINK_APPLICATION);
		Utils.pause(1000);
	}*/
	
	/**
	 * Go to Edit Layout
	 */
	public void goToEditLayout(){
		info("--Go to Edit Layout--");
		click(ELEMENT_LINK_EDIT);
		mouseOver(ELEMENT_MENU_PAGE_LINK, true);
		click(ELEMENT_MENU_EDIT_LAYOUT);
	}
	
	/** 
	 * Go to add page form: Edit-->Page-->Add page
	 */
	public void goToAddPage(){
		info("Go to add page form");
		waitForAndGetElement(ELEMENT_LINK_EDIT);
		click(ELEMENT_LINK_EDIT);
		mouseOver(ELEMENT_MENU_PAGE_LINK, true);
		click(ELEMENT_MENU_ADD_PAGE_LINK);
		waitForAndGetElement(paWin.ELEMENT_PAGE_CREATION_WIZARD);
	}
	
	/**
	 * Go to Manage Sites page: Administration-->Portal->Sites
	 * By QuynhPT
	 */
	public void goToPotalSites(){
		info("--Go to Portal-->Sites--");
		waitForAndGetElement(ELEMENT_TOOLBAR_ADMINISTRATION);
		click(ELEMENT_TOOLBAR_ADMINISTRATION);
		mouseOver(ELEMENT_ADMINISTRATION_PORTAL, true);
		waitForAndGetElement(ELEMENT_ADMINISTRATION_PORTAL_SITES);
		click(ELEMENT_ADMINISTRATION_PORTAL_SITES);
		waitForAndGetElement(magSites.ELEMENT_MANAGESITES_TITLE);
	}
	
	/**
	 * Go to Manage Sites page: Administration-->Portal->Pages
	 * By QuynhPT
	 */
	public void goToPotalPages(){
		info("--Go to Portal-->Pages--");
		waitForAndGetElement(ELEMENT_TOOLBAR_ADMINISTRATION);
		click(ELEMENT_TOOLBAR_ADMINISTRATION);
		mouseOver(ELEMENT_ADMINISTRATION_PORTAL, true);
		waitForAndGetElement(ELEMENT_ADMINISTRATION_PORTAL_PAGES);
		click(ELEMENT_ADMINISTRATION_PORTAL_PAGES);
		waitForAndGetElement(paMang.ELEMENT_MANAGEPAGES_TITLE);
	}
	
	/**
	 * List sublink in user menu
	 * @author quynhpt
	 */
	public enum specifUserToolBar{
		MY_PROFILE,MY_ACTIVITY,MY_CONNECTIONS,MY_WIKI,MY_DASHBOARD,MY_NOTIFICATION,SETTINGS,CHANGE_LANGUAGE;
	}
	/**
	 * Select a link in User menu
	 * @param link
	 */
	public void selectALinkOfUserMenu(specifUserToolBar link){
		openUserMenu();
		switch(link){
		case MY_PROFILE:
			click(ELEMENT_MY_PROFILE_LINK);
			waitForAndGetElement(myPro.ELEMENT_MY_PROFILE_TAB);
			break;
		case MY_ACTIVITY:
			break;
		case MY_CONNECTIONS:
			break;
		case MY_WIKI:
			break;
		case MY_DASHBOARD:
			break;
		case MY_NOTIFICATION:
			break;
		case SETTINGS:
			break;
		case CHANGE_LANGUAGE:
			break;
		}
	}
	/**
	 * Open User menu by click on username
	 * Update QuynhPT
	 */
	public void openUserMenu() {
		info("--Open User Menu--");
		waitForAndGetElement(ELEMENT_ACCOUNT_NAME_LINK);
		click(ELEMENT_ACCOUNT_NAME_LINK);
		Utils.pause(1000);
	}
	
     /**
      *  Go to Site Explorer page: Administration-->Content->Site Explorer
     */
	public void goToSiteExplorer() {
		info("-- Go to site explorer home page --");
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
		mouseOverAndClick(ELEMENT_MENU_CONTENT_LINK);
		Utils.pause(2000);
		info("Site Explorer is shown successfully");
	}
	/**
	 * Go to Edit-->Page-->SEO
	 */
	public void goToSEO(){
		info("Go to SEO page");
		info("Click on Edit button");
		click(ELEMENT_LINK_EDIT);
		info("Hover over on Page link");
		mouseOver(ELEMENT_MENU_PAGE_LINK, true);
		info("Click on Seo Menu");
		WebElement seoMenu = waitForAndGetElement(ELEMENT_MENU_SEO_LINK,10000,1,2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",seoMenu);		
		Utils.pause(2000);
	}
	/**
	 * Go to Edit Content
	 */
	public void goToEditContent(){
		info("Go to Edit content");
		waitForAndGetElement(ELEMENT_LINK_EDIT);
		click(ELEMENT_LINK_EDIT);
		check(ELEMENT_EDIT_CONTENT,2);
	}
	/**
	 * Go to Un-edit content
	 * Edit-->Uncheck Content
	 */
	public void goToUnEditContent(){
		info("Go to un Edit content");
		waitForAndGetElement(ELEMENT_LINK_EDIT);
		click(ELEMENT_LINK_EDIT);
		click(ELEMENT_EDIT_CONTENT_CHECK);
	}
	/**
	 * Open Change language popup
	 * Username-->Change Language
	 */
	public void goToChangeLanguage(){
		info("Open Change Language popup");
		waitForAndGetElement(ELEMENT_TOPBAR_AVATAR);
		click(ELEMENT_TOPBAR_AVATAR);
		click(ELEMENT_AVATAR_CHANGELANGUAGE);
		Utils.pause(2000);
	}
	
	/**
	 * Go to content administration
	 */
	public void goToContentAdministration(){
		info("Go to content administration");		
		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
		info("Base url is " + baseUrl);
		String url = baseUrl + "/g/:platform:web-contributors/wcmAdmin";
		info("base url of content admin is " + baseUrl);
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
					driver.get(url);
					break;
			}
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
			Utils.pause(1000);
	}
	/**
	 * Go to IDE page
	 */
	public void goToIDE(){
		info("-- Go to IDE home page --");
		Utils.pause(500);
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LINK_SETUP);
				break;
			}
			mouseOver(ELEMENT_LINK_SETUP, true);
			if (waitForAndGetElement(ELEMENT_ADMINISTRATION_PORTAL_IDE, 5000, 0) != null){
				info("Element " +ELEMENT_ADMINISTRATION_PORTAL_IDE + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
		mouseOverAndClick(ELEMENT_ADMINISTRATION_PORTAL_IDE);
		Utils.pause(2000);
	}
	/**
	 * Go to Application home page
	 */
	public void goToApplication(){
		info("-- Go to Application home page --");
		Utils.pause(500);
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LINK_SETUP);
				break;
			}
			mouseOver(ELEMENT_LINK_SETUP, true);
			if (waitForAndGetElement(ELEMENT_ADMINISTRATION_APPLICATION, 5000, 0) != null){
				info("Element " +ELEMENT_ADMINISTRATION_APPLICATION + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
		mouseOverAndClick(ELEMENT_ADMINISTRATION_APPLICATION);
		Utils.pause(2000);
	}

	/**
	 * Go to Banding page
	 */
	public void goToBanding() {
		info("-- Go to Banding page --");
		waitForAndGetElement(ELEMENT_TOOLBAR_ADMINISTRATION,5000,0);
		click(ELEMENT_TOOLBAR_ADMINISTRATION);
		mouseOver(ELEMENT_ADMINISTRATION_PORTAL, true);
		waitForAndGetElement(ELEMENT_ADMINISTRATION_PORTAL_BRANDING,5000,0);
		click(ELEMENT_ADMINISTRATION_PORTAL_BRANDING);
	}
	
}
