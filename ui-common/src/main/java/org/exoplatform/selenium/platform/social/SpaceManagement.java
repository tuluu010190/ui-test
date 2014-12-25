package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.exoplatform.selenium.TestLogger.info;

public class SpaceManagement extends PlatformBase {
	PlatformPermission per;
	ManageAlert alert;
	Button button;

	//Space portlets
	public By ELEMENT_SPACE_MY_SPACE_PORTLET = By.id("UIMySpacesPortlet");
	public By ELEMENT_SPACE_ALL_SPACE_PORTLET = By.id("UIAllSpacesPortlet");
	public By ELEMENT_SPACE_INVITATION_SPACE_PORTLET = By.id("UIInvitationSpacesPortlet");
	public By ELEMENT_SPACE_PENDING_SPACE_PORTLET = By.id("UIPendingSpacesPortlet");

	//Add new space buttons
	public By ELEMENT_ADD_NEW_SPACE_BUTTON = By.xpath("//*[@class='uiIconSocSimplePlus uiIconSocWhite']");
	public By ELEMENT_ADD_SPACE_FORM = By.id("UIPopupAddSpace");

	//Setting tab form
	public By ELEMENT_SPACE_SETTING_TAB=By.xpath("//*[@data-target='#UISpaceSettings-tab']");
	public By ELEMENT_SPACE_NAME_INPUT=By.id("displayName");
	public By ELEMENT_SPACE_DESCRIPTION_INPUT=By.id("description");

	//Access and Edit tab form
	public By ELEMENT_SPACE_ACCESS_EDIT_TAB=By.xpath("//*[@data-target='#UISpaceVisibility-tab']");
	public By ELEMENT_SPACE_VISIBILITY_VISIBLE_CHECKBOX=By.xpath("//*[@value='private']");
	public By ELEMENT_SPACE_VISIBILITY_HIDDEN_CHECKBOX=By.xpath("//*[@value='hidden']");
	public By ELEMENT_SPACE_REGISTRATION_OPEN_CHECKBOX=By.xpath("//*[@value='open']");
	public By ELEMENT_SPACE_REGISTRATION_CLOSED_CHECKBOX=By.xpath("//*[@value='close']");
	public By ELEMENT_SPACE_RESGISTRATION_VALIDATION_CHECKBOX=By.xpath("//*[@value='validation']");

	//Access and Edit tab form
	public By ELEMENT_SPACE_INVITE_GROUP_USER_TAB=By.xpath("//*[@data-target='#UISpaceGroupBound-tab']");
	public By ELEMENT_SPACE_SELECT_EXIST_GROUP_CHECKBOX=By.id("UseExistingGroupCheckBox");

	//Button create
	public By ELEMENET_SPACE_CREATE_BUTTON=By.xpath("//*[@class='uiAction']/*[text()='Create']");
	
	//Delete space
	public String ELEMENT_SPACE_TITLE="//*[@class='spaceTitle']//*[text()='$space']";
	public String ELEMENT_SPACE_DELETE_BUTTON="//*[@class='spaceTitle']//*[text()='$space']/../../..//*[text()='Delete']";
	public String ELEMENT_SPACE_CONFIRM_DELETE="Are you sure you want to delete this space? This cannot be undone. All page navigations and this group will also be deleted";
	public By ELEMENT_SPACE_DELETE_SPACE_OK_BUTTON=By.xpath("//*[text()='OK']");

	/**
	 * constructor
	 * @param dr
	 */
	public SpaceManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
	}

	/**
	 * Open create space form
	 */
	public void goToCreateSpace(){
		info("Open create space form");
		click(ELEMENT_ADD_NEW_SPACE_BUTTON);
		waitForAndGetElement(ELEMENT_ADD_SPACE_FORM);
	}

	/**
	 * Do create space
	 */
	public void doCreateSpace(){
		info("Do create space");
		click(ELEMENET_SPACE_CREATE_BUTTON);
	}
	
/**
 * delete Space
 * @param spaceName
 * 					name of space
 * @param isVerify
 * 					true: verify content of confirm msg
 * 					false: not verify content of confirm msg
 */
	public void deleteSpace(String spaceName, Boolean isVerify){
		info("Do create space");
		click(ELEMENT_SPACE_DELETE_BUTTON.replace("$space", spaceName));
		if(isVerify)
			alert.verifyAlertMessage(ELEMENT_SPACE_CONFIRM_DELETE);
		click(ELEMENT_SPACE_DELETE_SPACE_OK_BUTTON);
		waitForElementNotPresent(ELEMENT_SPACE_DELETE_BUTTON.replace("$space", spaceName),60000);
		
	}

	/**
	 * input name, des into setting tab
	 * @param name
	 * 				name of space
	 * @param des
	 * 				description of space
	 */
	public void inputDataToSettingTab(String name, String des){
		info("Input data to setting tab");
		if(name!=null && name!=""){
			type(ELEMENT_SPACE_NAME_INPUT,name,true);
		}
		if(des!=null && des!=""){
			type(ELEMENT_SPACE_DESCRIPTION_INPUT,des,true);
		}
	}

}
