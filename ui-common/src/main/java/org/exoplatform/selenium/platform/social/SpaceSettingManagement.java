package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpaceSettingManagement extends PlatformBase{

	public By ELEMENT_SPACE_SPACE_SETTINGS_TITLE=By.xpath(".//*[text()='Space Configuration']");
	
	// Members tab
	public By ELEMENT_SPACE_SETTINGS_MEMBERS_TAB = By.xpath("//*[@id='UISpaceSetting']//a[contains(text(),'Members')]");
	public By ELEMENT_SPACE_MEMBERS_SELECT_USER = By.xpath("//*[@id='UISpaceMember']//*[@class='uiIconUser uiIconLightGray']");
	public String ELEMENT_SPACE_SELECT_USER_IN_FORM = "//*[@id='UIListUsers']//*[contains(text(),'{$name}')]/../..//*[@class='uiCheckbox']//input";
	public By ELEMENT_ADD = By.xpath("//*[@id='UIUserSelector']//*[contains(text(),'Add')]");
	public By ELEMENT_SPACE_MEMBERS_INVITE = By.xpath("//*[@id='UISpaceMember']//*[contains(text(),'Invite')]");
	
	//Application tab
	public By ELEMENT_SETTINGS_APP_TAB = By.xpath("//*[@id='UITabPane']//*[@class='nav nav-tabs']//*[contains(text(),'Applications')]");
	public String ELEMENT_DELETE_APP_FROM_TOPBAR = ".//*[@id='UISpaceApplication']//*[contains(text(),'{$application}')]/../..//*[@class='uiIconClose pull-right']";
	
	//Settings tab
	public final By ELEMENT_SPACE_NAME_INPUT = By.xpath("//input[contains(@name,'displayName')]");
	public final By ELEMENT_SPACE_DESCRIPTION_INPUT = By.xpath("//textarea[contains(@name,'description')]");
	public final String ELEMENT_SPACE_CHANGE_ROLE_USER_MEMBER= ".//*[contains(text(),'${user}')]/..//*[@class='uiSwitchBtn']";
	public final String ELEMENT_SPACE_DELETE_USER_BTN = "//*[contains(text(),'${user}')]/..//*[@class='uiIconDelete uiIconLightGray']";
	public final String ELEMENT_SPACE_MEMBERS_TAB_VALIDATE_REQUEST_jOINT=".//*[contains(text(),'${user}')]/..//*[@class='uiIconValidate uiIconLightGray']";
	
	
	//invitation member
	public final String ELEMENT_SPACE_INVITED_USER_TABLE = ".//*[@id='UISpaceMember']//th[contains(text(),'Invited')]/../../..//*[contains(text(),'${user}')]";
	public final String ELEMENT_SPACE_MEMBERS_USER_TABLE = ".//*[@id='UISpaceMember']//th[contains(text(),'Members')]/../../..//*[contains(text(),'${user}')]";

	//Navigation tab
	public final By ELEMENT_SPACE_SETTING_NAVIGATION_TAB = By.xpath(".//*[@id='UITabPane']//*[contains(text(),'Navigations')]");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_NODE_BUTTON = By.xpath(".//*[@id='UISpaceNavigationManagement']//button[text()='Add Node']");
	public final String ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST =".//*[@id='UISpaceNavigationNodeSelector']//*[contains(text(),'${name}')]";
	
	//Add/Edit page node popup
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_NODE_TITLE = By.xpath(".//*[@id='AddNode']//*[contains(.,'Add/ Edit Page Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_NAME = By.xpath(".//*[@id='name']");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_SAVE = By.xpath(".//*[@id='UIPageNodeForm']//button[text()='Save']");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_LABEL = By.xpath(".//*[@id='UIPageNodeForm']//*[contains(text(),'Label')]/..//input");
	//Context menu
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_EDIT = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Edit this Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_DELETE= By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Delete Node')]");
	
	ManageAlert alert;
	/**
	 * constructor
	 * @param dr
	 */
	public SpaceSettingManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(dr);
	}
	
	/**
	 * Invite a user in the space
	 * @param userName as John or Mary. Without family name
	 */
	public void inviteUser(String userName){
		info("Open members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on select user button");
		click(ELEMENT_SPACE_MEMBERS_SELECT_USER);
		info("Select a user");
		check(ELEMENT_SPACE_SELECT_USER_IN_FORM.replace("{$name}",userName),2);
		info("click on Add button");
		click(ELEMENT_ADD);
		info("click on Invite button");
		click(ELEMENT_SPACE_MEMBERS_INVITE);
		info("Verify that user is shown in invitation table");
		waitForAndGetElement(ELEMENT_SPACE_INVITED_USER_TABLE.replace("${user}",userName),2000,0);
	}
	/**
	 * Change role of a user in the list
	 * if role's status is NO, this will change to YES
	 * if role's status is YES, this will change to NO
	 */
	public void changeRole(String user){
		info("OPen members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on change role button of manager column");
		click(ELEMENT_SPACE_CHANGE_ROLE_USER_MEMBER.replace("${user}",user));
		Utils.pause(2000);
		
	}
	/**
	 * Remove a user in the list
	 * @param user
	 */
	public void removeUser(String user){
		info("OPen members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on Delete button to remove user");
		click(ELEMENT_SPACE_DELETE_USER_BTN.replace("${user}",user));
		waitForElementNotPresent(ELEMENT_SPACE_DELETE_USER_BTN.replace("${user}",user));
	}
	/**
	 * Accept a pending request to a space
	 * @param user
	 */
	public void acceptRequest(String user){
		info("OPen members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on Delete button to remove user");
		click(ELEMENT_SPACE_MEMBERS_TAB_VALIDATE_REQUEST_jOINT.replace("${user}",user));
		info("Verify that the member is shown in member list");
		waitForAndGetElement(ELEMENT_SPACE_DELETE_USER_BTN.replace("${user}",user),2000,0);
	}
	
	/**
	 * Delete an app from the top menu of space
	 * @param app
	 */
	public void deleteApplications(String app){
		info("Open Application tab");
		click(ELEMENT_SETTINGS_APP_TAB);
		info("Click on Delete button");
		click(ELEMENT_DELETE_APP_FROM_TOPBAR.replace("{$application}",app));
	}
	
	/**
	 * input name, des into setting tab
	 * @param name
	 * 				name of space
	 * @param des
	 * 				description of space
	 */
	public void updateInfoSpace(String name, String des){
		info("Input data to setting tab");
		if(name!=null && name!=""){
			info("input a name");
			type(ELEMENT_SPACE_NAME_INPUT,name,true);
		}
		if(des!=null && des!=""){
			info("input a description");
			type(ELEMENT_SPACE_DESCRIPTION_INPUT,des,true);
		}
	}
	/**
	 * Open Navigation tab
	 */
	public void goToNavigationTab(){
		info("Select Navigation tab");
		waitForAndGetElement(ELEMENT_SPACE_SETTING_NAVIGATION_TAB,3000,0).click();
		info("The tab is opened succcessfully");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_BUTTON,3000,0);
	}
	/**
	 * add a new simple node
	 * @param name
	 */
	public void addANodeSimple(String name){
		info("Click on Add node button");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_BUTTON,3000,0).click();
		info("The popup is shown");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_NODE_TITLE,2000,0);
		info("Input a new name for the node");
		type(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_NAME,name,true);
		info("Save all changes");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_SAVE,2000,0).click();
		info("Verify that the node is added successfully");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", name),3000,0);
	}
	/**
	 * Edit a node with new label
	 * @param nodeName
	 * @param label
	 */
	public void editANodeSimple(String nodeName, String label){
		info("Right click on the node");
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		info("Select edit link");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_EDIT,2000,0).click();
		info("Input a new name for lable field");
		type(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_LABEL,label,true);
		info("Save all changes");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_SAVE,2000,0).click();
		info("Verify that the node is edited successfully");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", label),3000,0);
	}
	/**
	 * Delete a node
	 * @param nodeName
	 */
	public void deleteANode(String nodeName){
		info("Right click on the node");
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		info("Select delete link");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_DELETE,2000,0).click();
		alert.acceptAlert();
		info("Verify that the node is deleted successfully");
		waitForElementNotPresent(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}",nodeName));
	}
}