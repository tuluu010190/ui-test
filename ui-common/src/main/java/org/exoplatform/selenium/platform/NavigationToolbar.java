package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.gatein.PageManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class NavigationToolbar extends PlatformBase {
	PageManagement paMang;
	//Setup icon
	public final By ELEMENT_LINK_SETUP=By.xpath("//*[@class='uiIconPLF24x24Setup']");
	public final By ELEENT_LINK_APPLICATION=By.xpath("//*[contains(@href,'/portal/g/:platform:administrators/administration/registry')]");
	
	//Edit icon
	public final By ELEMENT_LINK_EDIT=By.xpath("//*[@class='uiIconPLF24x24Edit']");
	public final By ELEMENT_MENU_PAGE_LINK = By.linkText("Page");
	public final By ELEMENT_MENU_EDIT_LAYOUT = By.linkText("Edit Layout");
	public final By ELEMENT_MENU_SEO_LINK = By.xpath("//span[contains(text(), 'SEO')]");
	public final By ELEMENT_MENU_ADD_PAGE_LINK = By.linkText("Add Page");
	
	public NavigationToolbar(WebDriver dr){
		driver = dr;
		paMang=new PageManagement(dr);
	} 
	
	/**
	 * Go to Portal Application Registry
	 */
	public void goToApplicationRegistry() {
		info("--Go to Portal Application Registry--");
		click(ELEMENT_LINK_SETUP);
		click(ELEENT_LINK_APPLICATION);
		Utils.pause(1000);
	}
	
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
	 * Go to add page form
	 */
	public void goToAddPage(){
		info("Go to add page form");
		click(ELEMENT_LINK_EDIT);
		mouseOver(ELEMENT_MENU_PAGE_LINK, true);
		click(ELEMENT_MENU_ADD_PAGE_LINK);
		waitForAndGetElement(paMang.ELEMENT_PAGE_CREATION_WIZARD);
	}
}
