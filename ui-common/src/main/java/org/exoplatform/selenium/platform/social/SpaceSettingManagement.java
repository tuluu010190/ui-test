package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpaceSettingManagement extends SpaceHomePage{

	public By ELEMENT_SPACE_SPACE_SETTINGS_TITLE=By.xpath(".//*[text()='Space Configuration']");
	
	// Members tab
	public By ELEMENT_SPACE_SETTINGS_MEMBERS_TAB = By.xpath("//*[@id='UISpaceSetting']//a[contains(text(),'Members')]");
	public By ELEMENT_SPACE_MEMBERS_SELECT_USER = By.xpath("//*[@id='UISpaceMember']//*[@class='uiIconUser uiIconLightGray']");
	public String ELEMENT_SPACE_SELECT_USER_IN_FORM = "//*[@id='UIListUsers']//*[contains(text(),'{$name}')]/../..//*[@class='uiCheckbox']//input";
	public By ELEMENT_ADD = By.xpath("//*[@id='UIUserSelector']//*[contains(text(),'Add')]");
	public By ELEMENT_SPACE_MEMBERS_INVITE = By.xpath("//*[@id='UISpaceMember']//*[contains(text(),'Invite')]");
	public final By ELEMENT_SEARCH_INPUT_USER_NAME = By.xpath(".//*[@id='Quick Search']");
	public final By ELEMENT_SEARCH_USERS_ICON=By.xpath(".//*[@id='UIUserSelector']//*[contains(@class,'uiIconSearch')]");
	
	//Search user
	public final String ELEMENT_CLOSE_MESSAGE = "//*[contains(@title,'Close Window')]";
	public final By ELEMENT_INPUT_SEARCH_USER_NAME = By.id("Quick Search");
	public final String ELEMENT_SELECT_SEARCH_OPTION = "//*[contains(@name,'filter')]";
	public final String ELEMENT_SEARCH_ICON_USERS_MANAGEMENT = "//*[contains(@class,'uiIconSearch uiIconLightGray')]";
	public String ELEMENT_MSG_SEARCH_USER_NAME = "User Name";
	
	//Application tab
	public By ELEMENT_SETTINGS_APP_TAB = By.xpath("//*[@id='UITabPane']//*[@class='nav nav-tabs']//*[contains(text(),'Applications')]");
	public String ELEMENT_DELETE_APP_FROM_TOPBAR = ".//*[@id='UISpaceApplication']//*[contains(text(),'{$application}')]/../..//*[@class='uiIconClose pull-right']";
	public final By ELEMENT_APPLICATION_TAB_ADD_APPLICATION_BTN=By.xpath(".//*[@id='UISpaceApplication-tab']//button[text()='Add Application']");
	public final String ELEMENT_APPLICATION_TAB_APPLICATION_LIST_CONTENT=".//*[@id='UISpaceApplication']//strong[contains(text(),'${app}')]";
	public final String ELEMENT_APPLICATION_TAB_APPLICATION_DELETE_BTN=".//*[@id='UISpaceApplication']//strong[contains(text(),'${app}')]/../..//*[@class='uiIconClose pull-right']";
	
	//Access and Edit tab
	public final By ELEMENT_ACCESS_AND_EDIT_TAB = By.xpath("//*[@id='UITabPane']//*[@class='nav nav-tabs']//*[contains(text(),'Access & Edit')]"); 
	public final By ELEMENT_ACCESS_HIDDEN_RADIO=By.xpath(".//*[@id='UISpacePermission']//input[@value='hidden']");
	public final String ELEMENT_ACCESS_PERMISSION_RADIO=".//*[@id='UISpacePermission']//input[@value='${right}']";
	public final By ELEMENT_ACCESS_PERMISSION_SAVE_BTN=By.xpath(".//*[@id='UISpacePermission']//button[text()='Save']");
	public final By ELEMENT_ACCESS_ALERTS_POPUP_OK_BTN= By.xpath(".//*[@class='PopupTitle popupTitle'][contains(text(),'Alerts')]/../..//*[@class='btn']");
	
	//Add application popup
	public final By ELEMENT_ADD_APPLICATION_POPUP_TITLE=By.xpath("//*[contains(text(),'Space Application Installer')]");
	public final String ELEMENT_ADD_APPLICATION_POPUP_CATEGOGY=".//*[@id='${category}']";
	public final String ELEMENT_ADD_APPLICATION_POPUP_APPLICATION_ADD_BTN =".//*[@id='UIApplicationListSelector']//*[contains(text(),'${app}')]/../..//*[contains(text(),'Add')]";
	public final By ELEMENT_ADD_APPLICATION_POPUP_CLOSE_BTN=By.xpath(".//*[@id='UIAddApplication']//*[@class='uiIconClose pull-right']");
	
	
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
	
	//Access space information
	public final By ELEMENT_SPACE_ACCESS_RESTRICED_AREA_TITLE=By.xpath(".//*[@id='UISpaceAccessPortlet']//h3[text()='Restricted Area']");
	public final By ELEMENT_SPACE_ACCESS_INFO=By.xpath(".//*[@class='spaceAccessInfo']");
	public final By ELEMENT_SPACE_ACCESS_JOIN_BTN=By.xpath(".//*[@title='Join']");
	public final By ELEMENT_SPACE_ACCESS_REQUEST_JOIN_BTN=By.xpath(".//*[@title='Request to Join']");
	
	public final By ELEMENT_SPACE_ACCESS_SPACE_NOT_FOUND_TITLE=By.xpath(".//*[@id='UISpaceAccessPortlet']//h3[text()='Space not found']");
	public final By ELEMENT_SPACE_ACCESS_SPACE_NOT_FOUND_INFO=By.xpath(".//*[@id='UISpaceAccessPortlet']//*[contains(text(),'No space is available at this URL.')]");
	public final By ELEMENT_SPACE_ACCESS_SPACE_NOT_FOUND_FIND_BTN=By.xpath(".//*[@id='UISpaceAccessPortlet']//a[text()='Find Spaces']");
	public final By ELEMENT_SPACE_ACCESS_SPACE_DENIED = By.xpath(".//*[@id='UISpaceAccessPortlet']//h3[text()='Access Denied']");
	public final By ELEMENT_SPACE_ACCESS_SPACE_DENIED_INFO=By.xpath(".//*[@class='spaceAccessInfo']");
	
	ManageAlert alert;
	/**
	 * constructor
	 * @param dr
	 */
	public SpaceSettingManagement(WebDriver dr){
		super(dr);
		this.driver=dr;
		alert = new ManageAlert(dr);
	}
	
	/**
	 * function: Search user
	 * 
	 * @param user
	 *            (Can be: User name, Last name, First name or Email of the user
	 *            you want to search)
	 * @param searchOption
	 *            (Can be: User name, Last name, First name or Email option
	 *            corresponding with information you input in "Search")
	 */
	public void searchUser(String user, String searchOption) {
		info("--Search user " + user + "--");
		if (isTextPresent("Search")) {
			type(ELEMENT_INPUT_SEARCH_USER_NAME, user, true);
			select(ELEMENT_SELECT_SEARCH_OPTION, searchOption);
		}
		click(ELEMENT_SEARCH_ICON_USERS_MANAGEMENT);
		waitForTextPresent(user);
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
		info("--Search user " + user + "--");
		type(ELEMENT_SEARCH_INPUT_USER_NAME,userName, true);
		click(ELEMENT_SEARCH_USERS_ICON);
		Utils.pause(2000);
		info("Select a user");
		searchUser(userName, ELEMENT_MSG_SEARCH_USER_NAME);
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
	 * Remove an application
	 * @param app
	 */
	public void removeApplication(String app){
		info("Click on Remove icon");
		click(ELEMENT_APPLICATION_TAB_APPLICATION_DELETE_BTN.replace("${app}",app));
		waitForAndGetElement(ELEMENT_APPLICATION_TAB_APPLICATION_LIST_CONTENT.replace("${app}", app));
		info("the application is removed");
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
		waitForAndGetElement(ELEMENT_APPLICATION_TAB_ADD_APPLICATION_BTN,3000,0);
	}
	/**
	 * Open Application tab
	 */
	public void goToApplicationTab(){
		info("Select Application tab");
		waitForAndGetElement(ELEMENT_SETTINGS_APP_TAB,3000,0).click();
		info("The tab is opened succcessfully");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_BUTTON,3000,0);
	}
	/**
	 * Open Access and Edit tab
	 */
	public void goToAccessEditTab(){
		info("Select Application tab");
		waitForAndGetElement(ELEMENT_ACCESS_AND_EDIT_TAB,3000,0).click();
		info("The tab is opened succcessfully");
		waitForAndGetElement(ELEMENT_ACCESS_HIDDEN_RADIO,3000,0);
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
	 * Add an application 
	 * @param category
	 * @param application
	 */
	public void addApplication(String category,String application){
		info("Click on Add application button");
		click(ELEMENT_APPLICATION_TAB_ADD_APPLICATION_BTN);
		info("the popup is shown");
		waitForAndGetElement(ELEMENT_ADD_APPLICATION_POPUP_TITLE,2000,0);
		info("Select a category");
		if(!category.isEmpty())
			click(ELEMENT_ADD_APPLICATION_POPUP_CATEGOGY.replace("${category}",category));
		if(!application.isEmpty())
			click(ELEMENT_ADD_APPLICATION_POPUP_APPLICATION_ADD_BTN.replace("${app}",application));
		info("Close the popup after installed application");
		click(ELEMENT_ADD_APPLICATION_POPUP_CLOSE_BTN);
		waitForElementNotPresent(ELEMENT_ADD_APPLICATION_POPUP_TITLE);
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
	 * Set permissions for a space
	 * @param arrayRight
	 */
	public void setPermissionForSpace(String[] arrayRight){
		for(String right: arrayRight){
			info("Select a permission for space:"+right);
			check(ELEMENT_ACCESS_PERMISSION_RADIO.replace("${right}", right),2);
		}
		info("Save all changes");
		click(ELEMENT_ACCESS_PERMISSION_SAVE_BTN);
		//click(ELEMENT_ACCESS_ALERTS_POPUP_OK_BTN);
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