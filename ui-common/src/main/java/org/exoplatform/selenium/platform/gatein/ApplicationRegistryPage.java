package org.exoplatform.selenium.platform.gatein;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationRegistryPage extends PlatformBase {
	NavigationToolbar navTool;
	PageCreationWizard pagMang;
	PageEditor pagEditor;
	HomePagePlatform hp;
	ManageAlert alert;
	
	public final By ELEMENT_APPLICATION_REGISTRY_PORTLET=By.id("UIApplicationRegistryPortlet");
	public final By ELEMENT_MANAGE_APPLICATION_BUTTON=By.xpath("//*[@class='uiIconManageApplication uiIconLightGray']");

	//Application registry page
	public final By ELEMENT_SHOW_IMPORT_APPLICATION = By.id("showImport");
	public final By ELEMENT_IMPORT_ALL_APPLICATION=By.xpath("//*[@class='uiIconImport uiIconLightGray']");

	public ApplicationRegistryPage(WebDriver dr){
		driver = dr;
		navTool = new NavigationToolbar(driver);
		pagMang = new PageCreationWizard(driver);
		pagEditor = new PageEditor(driver);
		hp= new HomePagePlatform(driver);
		alert=new ManageAlert(driver);
	}

	/**
	 * Go to Manage Application Page
	 */
	public void goToManageApplication(){
		info("--Go to Manage Application Page--");
		click(ELEMENT_MANAGE_APPLICATION_BUTTON);
	}
	
	/**
	 * Show import application
	 * @param isShow
	 */
	public void showImportApplication(Boolean isShow){
		info("Show import application");
		if(isShow!=null){
			if(isShow){
				check(ELEMENT_SHOW_IMPORT_APPLICATION,2);
			}
			else{
				uncheck(ELEMENT_SHOW_IMPORT_APPLICATION,2);
			}
		}
	}

	/**
	 * Show all import application
	 */
	public void checkAllShowImportApplicaion(){
		info("Show all import application");
		navTool.goToApplicationRegistry();
		navTool.goToEditLayout();
		pagEditor.goToEditPortlet(pagEditor.ELEMENT_FRAME_CONTAIN_PORTLET);
		showImportApplication(true);
		click(pagEditor.ELEMENT_EDIT_PORTLET_FORM_SAVE_BUTTON);
		click(pagEditor.ELEMENT_EDIT_PORTLET_FORM_CLOSE_BUTTON);
		pagEditor.finishEditLayout();
		click(ELEMENT_IMPORT_ALL_APPLICATION);
		alert.acceptAlert();
	}
}
