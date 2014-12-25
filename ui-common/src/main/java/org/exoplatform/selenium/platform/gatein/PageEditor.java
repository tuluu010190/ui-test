package org.exoplatform.selenium.platform.gatein;
import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.WebDriver;

public class PageEditor extends PlatformBase {
	//Common
	public final By ELEMENT_EDIT_PORTLET_ICON = By.xpath("//*[@data-original-title='Edit Portlet']");
	public final By ELEMENT_DELETE_PORTLET_ICON = By.xpath("//*[@data-original-title='Delete Portlet']");
	
	//Edit portlet form
	public final By ELEMENT_EDIT_PORTLET_FORM=By.id("tab-UIPortletForm");
	public final By ELEMENT_EDIT_PORTLET_FORM_CLOSE_BUTTON=By.xpath("//*[@id='tab-UIPortletForm']//*[text()='Close']");
	public final By ELEMENT_EDIT_PORTLET_FORM_SAVE_BUTTON=By.xpath("//*[@id='tab-UIPortletForm']//*[text()='Save']");
	public final By ELEMENT_EDIT_PORTLET_FORM_SAVE_AND_CLOSE_BUTTON=By.xpath("//*[@id='tab-UIPortletForm']//*[text()='Save And Close']");
	public final By ELEMENT_EDIT_PORTLET_FORM_CANCEL_BUTTON=By.xpath("//*[@id='tab-UIPortletForm']//*[text()='Cancel']");
	
	//Application
	public final String ELEMENT_EDIT_PORTLET_CATEGORY_APPLICATION_ARROW_RIGHT="//*[@title='$category']/*[@class='uiIconArrowRight pull-right']";
	public final String ELEMENT_EDIT_PORTLET_CATEGORY_APPLICATION_ARROW_DOWN="//*[@title='$category']/*[@class='uiIconArrowDown pull-right']";
	public final String ELEMENT_EDIT_PORTLET_APPLICATION_ID="//*[contains(@id,'$portlet')]";
	
	//Finish and Abort button
	public final By ELEMENT_EDIT_PORTLET_FINISH = By.xpath("//*[@data-original-title='Finish']");
	public final By ELEMENT_EDIT_PORTLET_ABORT= By.xpath("//*[@data-original-title='Abort']");
	
	//View page properties
	public final By ELEMENT_PAGE_EDITOR_VIEW_PAGE_PROPERTIES=By.xpath("//*[@class='btn btn-primary PageProfileIcon']");
	public final By ELEMENT_PERMISSTION_SETTING_TAB = By.xpath("//*[@data-target='#PermissionSetting-tab']");
	public final By ELEMENT_PUBLIC_MODE=By.id("publicMode");
	
	//Middle container
	public final By ELEMENT_EDIT_PAGE_PAGE = By.id("UIPage");
	public final By ELEMENT_PAGE_EDITOR_SAVE_BUTTON=By.xpath("//*[@id='UIPageForm']//*[text()='Save']");
	public final By ELEMENT_PAGE_EDITOR_SAVE_AND_CLOSE_BUTTON=By.xpath("//*[text()='Save And Close']");
	public final By ELEMENT_PAGE_EDITOR_CLOSE_BUTTON=By.xpath("//*[text()='Close']");
	public final By ELEMENT_FRAME_CONTAIN_PORTLET = By.xpath("//div[contains(@id,'UIPortlet')]");
	public final By ELEMENT_EDIT_SAVE_BUTTON=By.xpath("//*[text()='Save']");
	public final By ELEMENT_EDIT_CLOSE_BUTTON=By.xpath("//*[text()='Close']");
	public final By ELEMENT_PAGE_OK_BUTTON=By.xpath("//*[contains(@class,'UIPopupWindow')]//a[text()='OK']");
	
	public PageEditor(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * 
	 * @param elementPortlet
	 */
	public void goToEditPortlet(Object elementPortlet){
		info("Go to edit portlet");
		mouseOver(elementPortlet, true);
		click(ELEMENT_EDIT_PORTLET_ICON);
		waitForAndGetElement(ELEMENT_EDIT_PORTLET_FORM);
	}
	
	/**
	 * Finish Editing PageLayout
	 */
	public void finishEditLayout(){
		info("Finish Editing PageLayout");
		click(ELEMENT_EDIT_PORTLET_FINISH);
		waitForElementNotPresent(ELEMENT_EDIT_PORTLET_FINISH,60000);
	}
	/**
	 * Select an application and move to tagerget container
	 * @param portletPath (Format: catgory-porlets). Ex: answer-AnswersPortlet)
	 * @param targetLocator
	 */
	public void selectApplication(String portletPath,Object targetLocator ){
		info("Select an application and move to tagerget container");
		String[] portlets = portletPath.split("-");
		if(portlets.length>1){
			for(int i = 0; i<portlets.length-1;i++){
				if(waitForAndGetElement(ELEMENT_EDIT_PORTLET_CATEGORY_APPLICATION_ARROW_RIGHT.replace("$category",portlets[i]),5000,0)!=null)
					click(ELEMENT_EDIT_PORTLET_CATEGORY_APPLICATION_ARROW_RIGHT.replace("$category",portlets[i]));
				waitForAndGetElement(ELEMENT_EDIT_PORTLET_CATEGORY_APPLICATION_ARROW_DOWN.replace("$category",portlets[i]));
			}
		}
		dragAndDropToObject(ELEMENT_EDIT_PORTLET_APPLICATION_ID.replace("$portlet",portlets[portlets.length-1]), targetLocator);
	}
}
