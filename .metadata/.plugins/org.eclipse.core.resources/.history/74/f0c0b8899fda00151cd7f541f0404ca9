package org.exoplatform.selenium.platform.gatein;
import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.WebDriver;

public class EditorPortlet extends PlatformBase {
	//Edit portlet form
	public final By ELEMENT_EDIT_PORTLET_FORM=By.id("tab-UIPortletForm");
	public final By ELEMENT_EDIT_PORTLET_FORM_CLOSE_BUTTON=By.xpath(".//*[@id='Close']");
	public final By ELEMENT_EDIT_PORTLET_FORM_SAVE_BUTTON=By.xpath(".//*[@id='Save']");
	public final By ELEMENT_EDIT_PORTLET_FORM_SAVESETTINGS_BUTTON=By.xpath("//*[@id='tab-UIPortletForm']//*[text()='Save Settings']");
	public final By ELEMENT_EDIT_PORTLET_FORM_SAVE_AND_CLOSE_BUTTON=By.xpath("//*[@id='tab-UIPortletForm']//*[text()='Save And Close']");
	public final By ELEMENT_EDIT_PORTLET_FORM_CANCEL_BUTTON=By.xpath("//*[@id='tab-UIPortletForm']//*[text()='Cancel']");
	public final By ELEMENT_EDIT_PORTLET_FORM_RESULTPERPAGE = By.xpath("//*[@id='resultsPerPage']");
	
	//Permission tab
	public final By ELEMENT_PORTLET_ACCESS_PERMISSION_TAB=By.xpath(".//*[@id='tab-UIPortletForm']//*[@data-target='#PortletPermission-tab']");
	public final String ELEMENT_PORTLET_ACCESS_PERMISSION_DELETE_GROUP_BTN=".//*[@id='PermissionGrid']//*[contains(text(),'$group')]/../..//*[contains(@class,'uiIconDelete')]";
	public final String ELEMENT_CONFIRM_DELETE_MESSAGE="Are you sure you want to delete this Access Group?";
	public final By ELEMENT_PORTLET_ACCESS_PERMISSION_ADD_BTN =By.xpath(".//*[contains(@class,'uiAccessGroup')]//*[contains(@class,'uiAction')]//*[contains(@class,'uiIconAddUser')]");
	public final By ELEMENT_PORTLET_SELECT_PERMISSION_POPUP=By.xpath(".//*[contains(@class,'PopupContent')]");
	public final String ELEMENT_PORTLET_SELECT_PERMISSION_GROUP_MEMBERSHIP_NAME=".//*[contains(@class,'PopupContent')]//*[@title='$name']";
	public final String ELEMENT_PORTLET_ACCESS_PERMISSION_GROUP_NAME=".//*[@id='PermissionGrid']//*[contains(text(),'$group')]";
	
	ManageAlert alert;
	
	public EditorPortlet(WebDriver dr){
		driver = dr;
		alert = new ManageAlert(dr);
	}
	/**
	 * Open Access Permission tab
	 */
	public void goToAccessPermissionTab(){
		info("Click on Access Permission tab");
		click( ELEMENT_PORTLET_ACCESS_PERMISSION_TAB);
	}
	
	/**
	 * Delete a access permission group
	 * @param group
	 *              is group path as: /platform/users,...
	 */
	public void deleteGroupPermission(String group){
		if(waitForAndGetElement(ELEMENT_PORTLET_ACCESS_PERMISSION_DELETE_GROUP_BTN.replace("$group",group),3000,0)!=null){
			info("Click on delete button");
			click(ELEMENT_PORTLET_ACCESS_PERMISSION_DELETE_GROUP_BTN.replace("$group",group));
			alert.waitForConfirmation(ELEMENT_CONFIRM_DELETE_MESSAGE);
			alert.acceptAlert();
			waitForElementNotPresent(ELEMENT_PORTLET_ACCESS_PERMISSION_DELETE_GROUP_BTN.replace("$group",group));
			info("Group is deleted successfully");
		}
	}
	/**
	 * Add permission for a portlet
	 * @param groupPath
	 *                  is group's path as: Platform/Administration,..
	 * @param membership
	 *                  is membership's name
	 * @param addedGroup
	 *                  is group's name that is added after added permission in list
	 */
	public void addPremission(String groupPath,String membership,String addedGroup){
		info("Click on Add Premission button");
		click(ELEMENT_PORTLET_ACCESS_PERMISSION_ADD_BTN);
		waitForAndGetElement(ELEMENT_PORTLET_SELECT_PERMISSION_POPUP);
		String[] groups=groupPath.split("/");
		for(String group:groups){
			click(ELEMENT_PORTLET_SELECT_PERMISSION_GROUP_MEMBERSHIP_NAME.replace("$name",group));
			Utils.pause(2000);
		}
		if(!membership.isEmpty()){
			info("Select membership");
			click(ELEMENT_PORTLET_SELECT_PERMISSION_GROUP_MEMBERSHIP_NAME.replace("$name",membership));
			Utils.pause(2000);
		}
		waitForAndGetElement(ELEMENT_PORTLET_ACCESS_PERMISSION_GROUP_NAME.replace("$group",addedGroup));
		info("Access group is added successfully");
	}
	/**
	 * Save or close all changes
	 * @param isSave
	 */
	public void saveCloseChange(Boolean isSave){
		if(isSave){
			info("Click on Save button");
			click(ELEMENT_EDIT_PORTLET_FORM_SAVE_BUTTON);
		}else{
			info("Click on Close button");
			click(ELEMENT_EDIT_PORTLET_FORM_CLOSE_BUTTON);
		}
		waitForElementNotPresent(ELEMENT_EDIT_PORTLET_FORM);
		info("Save or Close successfully");
	}
	
}
