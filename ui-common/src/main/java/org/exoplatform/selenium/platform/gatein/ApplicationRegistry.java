package org.exoplatform.selenium.platform.gatein;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationRegistry extends PlatformBase {

	public final By ELEMENT_APPLICATION_REGISTRY_PORTLET=By.id("UIApplicationRegistryPortlet");
	public final By ELEMENT_MANAGE_APPLICATION_BUTTON=By.xpath("//*[@class='uiIconManageApplication uiIconLightGray']");

	//Application registry page
	public final By ELEMENT_SHOW_IMPORT_APPLICATION = By.id("showImport");
	public final By ELEMENT_IMPORT_ALL_APPLICATION=By.xpath("//*[@class='uiIconImport uiIconLightGray']");
	public final By ELEMENT_APPLICATION_GADGETBTN = By.xpath(".//*[@id='UIApplicationRegistryPortlet']//*[@class='uiIconGadgets uiIconLightGray']");

	//Left panel
	public final String ELEMENT_LEFT_PANEL_ADD_APPLICATION_BTN=".//*[contains(.,'${category}')]//*[@class='uiIconPlus uiIconLightGray']";
	public final String ELEMENT_LEFT_PANEL_APPLICATION_NAME = ".//*[@id='${category}']//*[text()='${application}']";
	public final String ELEMENT_LEFT_PANEL_APPLICATION_DELETE_BTN =".//*[@data-original-title='${application}']/..//*[@class='uiIconTrashMini uiIconLightGray']";
	public final String ELEMENT_LEFT_PANEL_APPLICATION_CATEGORY_TAB=".//*[@id='ApplicationRegistryCategory']//*[@href='#${category}']";

	//Right panel Add Application
	public final By ELEMENT_RIGHT_PANEL_ADD_APPLICATION_DISPLAY_FILED=By.id("displayName");
	public final By ELEMENT_RIGHT_PANEL_ADD_APPLICATION_SAVE_BTN = By.xpath(".//*[@id='UIAddApplicationForm']//button[text()='Add']");
	public final By ELEMENT_RIGHT_PANEL_ADD_APPLICATION_SELECTMENU=By.xpath(".//*[@id='UIAddApplicationForm']//*[@class='selectbox']");
	public final String ELEMENT_RIGHT_PANEL_ADD_APPLICATION_RADIOBTN=".//*[text()='${application}']/../..//input[@type='radio']";
	public final String ELEMENT_RIGHT_PANEL_ADD_APPLICATION_NAME=".//*[@id='label'][text()='${application}']";
	//paging control
	public final String ELEMENT_PAGING_CONTROL_NUMBER = ".//*[@id='UIAddApplicationForm']//a[text()='${number}']";
	public final By ELEMENT_PAGING_CONTROL_NEXT_PAGE_ENABLED=By.xpath(".//*[@data-original-title='Next Page' and @href='javascript:void(0);']");

	NavigationToolbar navTool;
	PageEditor pagEditor;
	HomePagePlatform hp;
	ManageAlert alert;
	PortalManagePages pagMag;
	public ApplicationRegistry(WebDriver dr){
		driver = dr;
		navTool = new NavigationToolbar(dr);
		pagEditor = new PageEditor(dr);
		hp=new HomePagePlatform(dr);
		alert=new ManageAlert(dr);
		pagMag = new PortalManagePages(dr);
	}

	/**
	 * Go to Manage Application Page
	 */
	public void goToManageApplication(){
		info("--Go to Manage Application Page--");
		waitForAndGetElement(ELEMENT_MANAGE_APPLICATION_BUTTON);
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
		if ("iexplorer".equals(browser)){
			navTool.goToPotalPages();
			pagMag.editPage("registry");
		}
		else{
			navTool.goToApplication();
			navTool.goToEditLayout();
		}
		pagEditor.goToEditPortlet(pagEditor.ELEMENT_FRAME_CONTAIN_PORTLET);
		showImportApplication(true);
		click(pagEditor.ELEMENT_EDIT_PORTLET_FORM_SAVE_BUTTON);
		click(pagEditor.ELEMENT_EDIT_PORTLET_FORM_CLOSE_BUTTON);
		pagEditor.finishEditLayout();
		click(ELEMENT_IMPORT_ALL_APPLICATION);
		alert.acceptAlert();
	}
	/**
	 * Open Gadget page
	 */
	public void goToGadgetPage(){
		info("Show Gadget page");
		click(ELEMENT_APPLICATION_GADGETBTN);
		Utils.pause(2000);
	}

	/**
	 * Add a application to a category for Portlet type
	 * 
	 * @param category
	 * @param nameApp
	 */
	public void addApplicationToCategory(String category, String nameApp,
			String typeApp) {
		info("Click on Add button");
		waitForAndGetElement(ELEMENT_LEFT_PANEL_ADD_APPLICATION_BTN.replace(
				"${category}", category));
		click(ELEMENT_LEFT_PANEL_ADD_APPLICATION_BTN.replace("${category}",
				category));
		info("Verify that right panel is shown");
		waitForAndGetElement(ELEMENT_RIGHT_PANEL_ADD_APPLICATION_DISPLAY_FILED);
		info("Type the name for the application");
		type(ELEMENT_RIGHT_PANEL_ADD_APPLICATION_DISPLAY_FILED, nameApp, true);

		while(waitForAndGetElement(ELEMENT_RIGHT_PANEL_ADD_APPLICATION_NAME.replace(
				"${application}", typeApp), 5000, 0)==null){

			if(waitForAndGetElement(ELEMENT_PAGING_CONTROL_NEXT_PAGE_ENABLED, 2000, 0)!=null)
				click(ELEMENT_PAGING_CONTROL_NEXT_PAGE_ENABLED);
			else assert false:"Not found application with the name:"+typeApp;

			if(waitForAndGetElement(ELEMENT_RIGHT_PANEL_ADD_APPLICATION_NAME.replace(
					"${application}", typeApp), 5000, 0)!=null)
				break;
		}

		check(ELEMENT_RIGHT_PANEL_ADD_APPLICATION_RADIOBTN.replace(
				"${application}", typeApp), 2);
		info("Save all changes");
		click(ELEMENT_RIGHT_PANEL_ADD_APPLICATION_SAVE_BTN);
		Utils.pause(2000);
	}

	/**
	 * Delete an application of a category
	 * 
	 * @param category
	 * @param application
	 */
	public void deleteApplication(String application) {
		info("click on Delete button");
		click(ELEMENT_LEFT_PANEL_APPLICATION_DELETE_BTN.replace("${application}", application));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_LEFT_PANEL_APPLICATION_DELETE_BTN.replace("${application}", application));
	}
}
