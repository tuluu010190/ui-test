package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.gatein.NavigationManagement;
import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpaceSettingManagement extends SpaceHomePage{

	public By ELEMENT_SPACE_SPACE_SETTINGS_TITLE=By.xpath(".//*[text()='Space Configuration']");
	
	// Members tab
	public By ELEMENT_SPACE_SETTINGS_MEMBERS_TAB = By.xpath(".//*[contains(@data-target,'#UISpaceMember-tab')]");
	public By ELEMENT_SPACE_MEMBERS_SELECT_USER = By.xpath("//*[@id='UISpaceMember']//*[@class='uiIconUser uiIconLightGray']");
	public String ELEMENT_SPACE_SELECT_USER_IN_FORM = "//*[@id='UIListUsers']//*[contains(text(),'{$name}')]/../..//*[@class='uiCheckbox']//input";
	public By ELEMENT_ADD = By.xpath("//*[@id='UIUserSelector']//*[contains(text(),'Add')]");
	public By ELEMENT_SPACE_MEMBERS_INVITE = By.xpath("//*[@id='UISpaceMember']//*[contains(text(),'Invite')]");
	public final By ELEMENT_SEARCH_INPUT_USER_NAME = By.xpath(".//*[@id='Quick Search']");
	public final By ELEMENT_SEARCH_USERS_ICON=By.xpath(".//*[@id='UIUserSelector']//*[contains(@class,'uiIconSearch')]");
	public final By ELEMENT_INPUT_USER=By.xpath(".//*[@id='user']");
	public final By ELEMENT_SELECT_USER_FROM_GROUP=By.xpath(".//*[@id='UISpaceMember']//*[contains(@class,'uiIconGroup')]");
	public final By ELEMENT_ACCESS_ONLY_ONE_MANAGER_NUMBER = By.xpath("(.//*[@id='existingUsersTable']//*[contains(@class,'uiSwitchBtn')]//input[@checked='checked'])[1]");
	public final By ELEMENT_ACCESS_MORE_ONE_MANAGER_NUMBER = By.xpath("(.//*[@id='existingUsersTable']//*[contains(@class,'uiSwitchBtn')]//input[@checked='checked'])[2]");
	public final By ELEMENT_MEMBER_TABLE = By.xpath("(.//*[@id='existingUsersTable']");
	
	//Search user
	public final String ELEMENT_CLOSE_MESSAGE = "//*[contains(@title,'Close Window')]";
	public final By ELEMENT_INPUT_SEARCH_USER_NAME = By.id("Quick Search");
	public final String ELEMENT_SELECT_SEARCH_OPTION = "//*[contains(@name,'filter')]";
	public final String ELEMENT_SEARCH_ICON_USERS_MANAGEMENT = "//*[contains(@class,'uiIconSearch uiIconLightGray')]";
	public String ELEMENT_MSG_SEARCH_USER_NAME = "User Name";
	
	//Application tab
	public By ELEMENT_SETTINGS_APP_TAB = By.xpath(".//*[contains(@data-target,'#UISpaceApplication-tab')]");
	public String ELEMENT_DELETE_APP_FROM_TOPBAR = ".//*[@id='UISpaceApplication']//*[contains(text(),'{$application}')]/../..//*[@class='uiIconClose pull-right']";
	public final By ELEMENT_APPLICATION_TAB_ADD_APPLICATION_BTN=By.xpath(".//*[@id='UISpaceApplication-tab']//button[text()='Add Application']");
	public final String ELEMENT_APPLICATION_TAB_APPLICATION_LIST_CONTENT=".//*[@id='UISpaceApplication']//strong[contains(text(),'${app}')]";
	public final String ELEMENT_APPLICATION_TAB_APPLICATION_DELETE_BTN=".//*[@id='UISpaceApplication']//strong[contains(text(),'${app}')]/../..//*[@class='uiIconClose pull-right']";
	public final By ELEMENT_APPLICATION_TAB_LIST_APPLICATIONS=By.xpath(".//*[@id='UISpaceApplication']");
	
	//Access and Edit tab
	public final By ELEMENT_ACCESS_AND_EDIT_TAB = By.xpath(".//*[contains(@data-target,'#UISpacePermission-tab')]"); 
	public final By ELEMENT_ACCESS_AND_EDIT_TAB_OF_POPUP=By.xpath(".//*[contains(@data-target,'#UISpaceVisibility-tab')]");
	public final By ELEMENT_ACCESS_HIDDEN_RADIO=By.xpath("//input[@value='hidden']");
	public final String ELEMENT_ACCESS_PERMISSION_RADIO="//input[@value='${right}']";
	public final By ELEMENT_ACCESS_PERMISSION_SAVE_BTN=By.xpath(".//*[@id='UISpacePermission']//button[text()='Save']");
	public final By ELEMENT_ACCESS_AND_EDIT_TAB_OF_POPUP_CREATE_BTN=By.xpath(".//button[text()='Create']");
	public final By ELEMENT_ACCESS_ALERTS_POPUP_OK_BTN= By.xpath(".//*[@class='PopupTitle popupTitle'][contains(text(),'Alerts')]/../..//*[@class='btn']");
	public final By ELEMENT_ACCESS_INFO_OK_BTN = By.xpath("//*[@class='PopupContent popupContent']//*[contains(text(),'OK')]");
	public final By ELEMENT_ACCESS_VISIBILITY_RADIO_CHECKED=By.xpath(".//*[@id='UISpacePermission']//input[@value='private' and @checked='checked']");
	public final By ELEMENT_ACCESS_VALIDATION_RADIO_CHECKED=By.xpath(".//*[@id='UISpacePermission']//input[@value='validation' and @checked='checked']']");
	
	
	//Add application popup
	public final By ELEMENT_ADD_APPLICATION_POPUP_TITLE=By.xpath("//*[contains(text(),'Space Application Installer')]");
	public final String ELEMENT_ADD_APPLICATION_POPUP_CATEGOGY=".//*[@id='${category}']";
	public final String ELEMENT_ADD_APPLICATION_POPUP_APPLICATION_ADD_BTN =".//*[@id='UIApplicationListSelector']//*[contains(text(),'${app}')]/../..//*[contains(text(),'Add')]";
	public final By ELEMENT_ADD_APPLICATION_POPUP_CLOSE_BTN=By.xpath(".//*[@id='UIAddApplication']//*[@class='uiIconClose pull-right']");
	
	
	//Settings tab
	public final By ELEMENT_SPACE_NAME_INPUT = By.xpath("//input[contains(@name,'displayName')]");
	public final By ELEMENT_SPACE_DESCRIPTION_INPUT = By.xpath("//textarea[contains(@name,'description')]");
	public final String ELEMENT_SPACE_CHANGE_ROLE_USER_MEMBER= ".//*[contains(text(),'${user}')]/..//*[@class='uiSwitchBtn']";
	public final String ELEMENT_SPACE_DELETE_USER_BTN = "//*[contains(@onclick,'${user}')]/..//*[@class='uiIconDelete uiIconLightGray']";
	public final String ELEMENT_SPACE_REMOVE_USER_BTN_MEMBER_TABLE = ".//*[contains(text(),'${fullName}')]/..//*[contains(@class,'uiIconDelete')]";
	public final String ELEMENT_SPACE_MEMBERS_TAB_VALIDATE_REQUEST_jOINT=".//*[contains(text(),'${user}')]/..//*[@class='uiIconValidate uiIconLightGray']";
	public final String ELEMENT_SPACE_MEMBERS_TAB_DECLINE_REQUEST_jOINT =".//*[contains(text(),'${user}')]/..//*[contains(@class,'uiIconRemove')]";
	public final By ELEMENT_SPACE_SETTING_TAB = By.xpath(".//*[contains(@data-target,'#UISpaceInfo-tab')]");
	public final By ELEMENT_SPACE_CHANGE_AVATAR_BTN = By.xpath(".//*[@id='UISpaceInfo']//button[text()='Change Picture']");
	
	//invitation member
	public final String ELEMENT_SPACE_INVITED_USER_TABLE = ".//*[@id='UISpaceMember']//th[contains(text(),'Invited')]/../../..//*[contains(text(),'${user}')]";
	public final String ELEMENT_SPACE_MEMBERS_USER_TABLE = ".//*[@id='UISpaceMember']//th[contains(text(),'Members')]/../../..//*[contains(text(),'${user}')]";
	public final String ELEMENT_USER_IN_MEMBER_TABLE =".//*[@id='existingUsersTable']//*[contains(text(),'${fullName}')]";
	
	//Invitation a group
	public final By ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_TAB=By.xpath(".//*[contains(@data-target,'#UISpaceGroupBound-tab')]");
	public final By ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_CHECKBOX=By.xpath(".//*[@id='UseExistingGroupCheckBox']");
	public final String ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_SELECT_GROUP=".//*[@id='UISocialGroupSelector']//*[contains(@title,'${name}')]";
	public final By ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_SELECTED_LINK=By.xpath(".//*[@id='UISocialGroupSelector']//*[contains(@data-placement,'bottom')]");
	public final By ELEMENT_SPACE_INVITE_USERS_FROM_GROU_SELECTED_GROUP_INFO=By.xpath(".//*[@id='groupId']");
	
	//Button create
	public By ELEMENET_SPACE_CREATE_BUTTON=By.xpath("//*[@class='uiAction']/*[text()='Create']");
	
	//Navigation tab
	public final By ELEMENT_SPACE_SETTING_NAVIGATION_TAB = By.xpath(".//*[contains(@data-target,'#UISpaceNavigationManagement-tab')]");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_NODE_BUTTON = By.xpath(".//*[@id='UISpaceNavigationManagement']//button[text()='Add Node']");
	public final String ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST =".//*[@id='UISpaceNavigationNodeSelector']//*[contains(text(),'${name}')]";
	public final String ELEMENT_SPACE_NAVIGAION_ADD_NODE_CHILDREN_UNDER_PARENT = ".//*[@id='UISpaceNavigationNodeSelector']//*[contains(text(),'${childrenNode}')]/../../..//*[contains(text(),'${parentNode}')]";
	public final By ELEMENT_SPACE_NAVIGATION_UP_LEVEL_BUTTON = By.xpath(".//*[@id='UISpaceNavigationNodeSelector']//*[@class='uiIconUpLevel uiIconLightGray']");
	public final By ELEMENT_SPACE_NAVIGATION_NODE_LIST =By.xpath(".//*[@id='UISpaceNavigationNodeSelector']");
	
	//Add/Edit page node popup
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_NODE_TITLE = By.xpath(".//*[@id='AddNode']//*[contains(.,'Add/ Edit Page Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_NAME = By.xpath(".//*[@id='name']");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_SAVE = By.xpath(".//*[@id='UIPageNodeForm']//button[text()='Save']");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_LABEL = By.xpath(".//*[@id='UIPageNodeForm']//*[contains(text(),'Label')]/..//input");
	public final By ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_LANGUAGE = By.xpath(".//*[@id='PageNodeSetting-tab']//*[@class='selectbox' and @name='languages']");
	public final By ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE = By.id("switchmode");
	public final By ELEMENT_INPUT_LABEL = By.id("i18nizedLabel");
	public final By ELEMENT_PAGE_SELECTOR_TAB = By.xpath(".//*[@id='AddNode']//a[text()='Page Selector']");
	public final By ELEMENT_INPUT_PAGE_NAME = By.id("pageName");
	public final By ELEMENT_INPUT_PAGE_TITLE = By.id("pageTitle");
	public final By ELEMENT_CREATE_PAGE_LINK = By.xpath(".//*[@id='UIPageSelector']//*[@class='uiIconAddPage uiIconWhite']");
	public final By ELEMENT_SEARCH_SELECTOR_PAGE_LINK = By.xpath(".//*[@id='UIPageSelector']//*[@class='uiIconSelectPage']");
	
	//Context menu
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_EDIT = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Edit this Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_DELETE= By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Delete Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_ADD_NEW_NODE = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Add new Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_EDIT_NODE_PAGE = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//*[@class='uiIconEditPageNode']");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_COPY_NODE = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Copy Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_PASTE_NODE = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Paste Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_CLONE_NODE = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Clone Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_CUT_NODE = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Cut Node')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_MOVE_UP = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Move Up')]");
	public final By ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_MOVE_DOWN = By.xpath(".//*[@id='SpaceNavigationNodePopupMenu']//a[contains(.,'Move Down')]");
	
	public final String ELEMENT_SPACE_NAVIGATION_NODE_POSITION = "//*[@class='childrenContainer nodeGroup']/li[${position}]//a[contains(text(),'${nodeName}')]";
	
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
	
	//message
	public final String ELEMENT_SPACE_NAVIGATION_COPY_AT_SAME_LEVEL = "This node name already exists.";

	//Warining popup
	public final String ELEMENT_SPACE_INVITE_EXISTING_MEMBER=".//*[contains(@class,'UIPopupWindow')]//*[contains(text(),'Some users already exist in the invitation list, including: ${username}')]";
	
	ManageAlert alert;
	NavigationManagement naviManage;
	Button button;
	/**
	 * constructor
	 * @param dr
	 */
	public SpaceSettingManagement(WebDriver dr){
		super(dr);
		this.driver=dr;
		alert = new ManageAlert(dr); 
		naviManage = new NavigationManagement(driver);
		button = new Button(driver, this.plfVersion);
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
	 * Open member tab
	 */
	public void goToMemberTab(){
		info("Open members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		waitForAndGetElement(ELEMENT_SPACE_MEMBERS_SELECT_USER,2000);
	}
	/**
	 * Invite a user in the space
	 * @param userName
	 * @param verify is true if want to verify user in invited table. False if don't want.
	 * @param fullName
	 */
	public void inviteUser(String userName,boolean verify,String fullName){
		goToMemberTab();
		info("Click on select user button");
		click(ELEMENT_SPACE_MEMBERS_SELECT_USER);
		info("--Search user " + user + "--");
		type(ELEMENT_SEARCH_INPUT_USER_NAME,userName, true);
		click(ELEMENT_SEARCH_USERS_ICON);
		Utils.pause(2000);
		info("Select a user");
		check(ELEMENT_SPACE_SELECT_USER_IN_FORM.replace("{$name}",userName),2);
		info("click on Add button");
		click(ELEMENT_ADD);
		info("click on Invite button");
		click(ELEMENT_SPACE_MEMBERS_INVITE);
		if (verify) {
			info("Verify that user is shown in invitation table");
			waitForAndGetElement(ELEMENT_SPACE_INVITED_USER_TABLE.replace(
					"${user}", fullName), 2000, 1);
		}
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
	 * Remove a user in the invited list
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
	 * Remove a user in the member list
	 * @param fullName
	 */
	public void removeUserFromMemberlist(String fullName){
		info("OPen members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on Delete button to remove user");
		click(ELEMENT_SPACE_REMOVE_USER_BTN_MEMBER_TABLE.replace("${fullName}",fullName));
		waitForElementNotPresent(ELEMENT_SPACE_REMOVE_USER_BTN_MEMBER_TABLE.replace("${fullName}",fullName),2000,1);
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
		info("Click on join button to remove user");
		click(ELEMENT_SPACE_MEMBERS_TAB_VALIDATE_REQUEST_jOINT.replace("${user}",user));
		info("Verify that the member is shown in member list");
		waitForAndGetElement(ELEMENT_SPACE_DELETE_USER_BTN.replace("${user}",user),2000,1);
	}
	
	/**
	 * Decline a pending request to a space
	 * @param user
	 */
	public void declineRequest(String user){
		info("OPen members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on join button to remove user");
		click(ELEMENT_SPACE_MEMBERS_TAB_DECLINE_REQUEST_jOINT.replace("${user}",user));
		info("Verify that the member is shown in member list");
		waitForElementNotPresent(ELEMENT_SPACE_DELETE_USER_BTN.replace("${user}",user),2000,1);
	}
	
	/**
	 * Delete member of space
	 * @param user
	 */
	public void deleteMember(String user){
		info("OPen members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on delete button to remove user");
		click(ELEMENT_SPACE_DELETE_USER_BTN.replace("${user}",user));
		info("Verify that the member is not shown in member list");
		waitForElementNotPresent(ELEMENT_SPACE_MEMBERS_USER_TABLE.replace("${user}", user));
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
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_BUTTON);
		//waitForAndGetElement(ELEMENT_APPLICATION_TAB_ADD_APPLICATION_BTN,3000,0);
		Utils.pause(1000);
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
		if(waitForAndGetElement(ELEMENT_ACCESS_AND_EDIT_TAB,3000,0)!=null)
		click(ELEMENT_ACCESS_AND_EDIT_TAB);
		else click(ELEMENT_ACCESS_AND_EDIT_TAB_OF_POPUP);
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
		Utils.pause(1000);
	}

	/**
	 * add a new simple child node
	 * @param parentNode
	 * @param childNode
	 */
	public void addChildrenNodeSimple(String parentNode, String childNode){
		info("Right click on parent node");
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", parentNode));
		info("Click on add new node");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_ADD_NEW_NODE);
		click(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_ADD_NEW_NODE);
		info("The popup is shown");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_NODE_TITLE,2000,0);
		info("Input a new name for the node");
		type(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_NAME,childNode,true);
		info("Save all changes");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_SAVE,2000,0).click();
		info("Verify that the children node is added successfully under parent node");
		click(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", parentNode));
		waitForAndGetElement(ELEMENT_SPACE_NAVIGAION_ADD_NODE_CHILDREN_UNDER_PARENT.replace("${childrenNode}", childNode).replace("${parentNode}", parentNode),3000,0);		
		Utils.pause(1000);
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
		if(waitForAndGetElement(ELEMENT_ACCESS_PERMISSION_SAVE_BTN,3000,0)!=null){
			click(ELEMENT_ACCESS_PERMISSION_SAVE_BTN);
			click(ELEMENT_ACCESS_INFO_OK_BTN);
		}
		else click(ELEMENT_ACCESS_AND_EDIT_TAB_OF_POPUP_CREATE_BTN);
		Utils.pause(2000);
	}
	/**
	 * Set permissions for a space
	 * @param arrayRight
	 */
	public void setPermissionForSpaceFromPopup(String[] arrayRight){
		for(String right: arrayRight){
			info("Select a permission for space:"+right);
			check(ELEMENT_ACCESS_PERMISSION_RADIO.replace("${right}", right),2);
		}
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
	
	/**
	 * copy a node
	 * @param nodeName
	 */
	public void copyANode(String nodeName){
		info ("Copy node ");
		info("Right click on the node");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		info("Select copy link");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_COPY_NODE,2000,0).click();
		Utils.pause(1000);
	}
	
	/**
	 * cut a node
	 * @param nodeName
	 */
	public void cutANode(String nodeName){
		info ("Copy node ");
		info("Right click on the node");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		info("Select copy link");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_CUT_NODE,2000,0).click();
		Utils.pause(1000);
	}
	
	/**
	 * paste a node
	 * @param nodeName
	 */
	public void pasteANode(boolean canPaste, String nodeName){
		info("paste node");
		info("Right click on the node");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		if(canPaste){
			info("Select paste link");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_PASTE_NODE,2000,0).click();
		}
		else{
			info("can not find paste button");
			waitForElementNotPresent(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_PASTE_NODE,2000,0);
		}
		Utils.pause(1000);
	}
	
	/**
	 * Move up a node
	 * @param nodeName
	 */
	public void moveUpANode(boolean firstNode, String nodeName, String nodeAboveName, String nodePosition, String abovePosition){
		info ("move up a node ");
		if(firstNode){
		info("Right click on the node");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		info("Select move up link");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_MOVE_UP,2000,0).click();	
		info("There is nothing happen with the first node");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeName).replace("${position}", nodePosition));
		}
		else{
			info("Check position before move up");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeName).replace("${position}", nodePosition));
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeAboveName).replace("${position}", abovePosition));
			info("Right click on the node");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
			rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
			info("Select move up link");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_MOVE_UP,2000,0).click();	
			info("Check position after move up");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeName).replace("${position}", abovePosition));
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeAboveName).replace("${position}", nodePosition));
		}
	}

	/**
	 * Move down a node
	 * @param nodeName
	 */
	public void moveDownANode(boolean lastNode, String nodeName, String nodeUnderName, String nodePosition, String underPosition){
		info ("move up a node ");
		if(lastNode){
		info("Right click on the node");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		info("Select move up link");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_MOVE_DOWN,2000,0).click();
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeName).replace("${position}", nodePosition));
		}
		else{
			info("Check position before move down");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeName).replace("${position}", nodePosition));
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeUnderName).replace("${position}", underPosition));
			info("Right click on the node");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
			rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
			info("Select move up link");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_MOVE_DOWN,2000,0).click();
			info("Check position after move down");
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeName).replace("${position}", underPosition));
			waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_NODE_POSITION.replace("${nodeName}", nodeUnderName).replace("${position}", nodePosition));
		}
	}
	
	
	/**
	 * go to Edit Node'sPage
	 * @param nodeName
	 */	
	public void goToEditNodePage(String nodeName){
		Utils.pause(1000);
		info("Go to Edit Node's Page");
		info("Right click on the node");
		rightClickOnElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_LIST.replace("${name}", nodeName));
		info("Select edit node's page link");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_EDIT_NODE_PAGE,2000,0);
		click(ELEMENT_SPACE_NAVIGATION_CONTEXT_MENU_EDIT_NODE_PAGE);
		Utils.pause(2000);
	}
	
	/**
	 * add node with page selector
	 * @param nodeName
	 * @param extendedLabelMode
	 * @param languages
	 * @param nodeLabel
	 * @param pageTitle
	 * @param pageTitleSearch
	 * @param verifyPage
	 * @param verifyNode
	 */
	public void addANodeWithPageSelector(String nodeName, boolean extendedLabelMode, 
			String languages, String nodeLabel, String pageName, String pageTitle, String pageTitleSearch, String type, boolean verifyPage, boolean verifyNode){
		info("Click on Add node button");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_NODE_BUTTON,3000,0).click();
		info("The popup is shown");
		waitForAndGetElement(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_NODE_TITLE,2000,0);
		type(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_NAME,nodeName,true);
		if (extendedLabelMode) {
				select(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_LANGUAGE, languages);
				Utils.pause(500);
		} else {
			uncheck(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
		}
		type(ELEMENT_INPUT_LABEL, nodeLabel, true);

		click(ELEMENT_PAGE_SELECTOR_TAB);

		if (pageName != "" && pageTitle != "") {
			info("--Create new page");
			type(ELEMENT_INPUT_PAGE_NAME, pageName, true);
			type(ELEMENT_INPUT_PAGE_TITLE, pageTitle, true);
			click(ELEMENT_CREATE_PAGE_LINK);
			if (verifyPage) {
				waitForElementNotPresent(ELEMENT_CREATE_PAGE_LINK);
			} else {
				return;
			}
		} else {
			info("Select Page");
			Utils.pause(500);
			click(ELEMENT_SEARCH_SELECTOR_PAGE_LINK);
			naviManage.selectPage(pageTitleSearch);
		}
		info("Save to add node");
		Utils.pause(2000);
		click(ELEMENT_SPACE_NAVIGATION_ADD_EDIT_POPUP_SAVE);
		Utils.pause(2000);
	}

	/**
	 * Open Invite users from group tab
	 */
   public void goToInviteUserFromGroupTab(){
	   info("click on the Invite users from group tab");
	   click(ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_TAB);
	   waitForAndGetElement(ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_CHECKBOX,2000,2);
	   info("The tab is shown");
   }
   /**
    * Select a group
    * @param arrayGroupPath
    */
   public void selectGroup(String[] arrayGroupPath){
	   info("Select a group in the list");
	   for(String group: arrayGroupPath){
			info("Select a group:"+group);
			click(ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_SELECT_GROUP.replace("${name}",group));
		}
	   info("Select the group");
	   click(ELEMENT_SPACE_INVITE_USERS_FROM_GROUP_SELECTED_LINK);
	   waitForAndGetElement(ELEMENT_SPACE_INVITE_USERS_FROM_GROU_SELECTED_GROUP_INFO,2000,1);
   }
   /**
    * Save all changes
    */
   public void saveChanges(){
		if(waitForAndGetElement(ELEMENT_ACCESS_PERMISSION_SAVE_BTN,3000,0)!=null){
			info("Save all changes by click on Save button");
			click(ELEMENT_ACCESS_PERMISSION_SAVE_BTN);
			click(ELEMENT_ACCESS_INFO_OK_BTN);
		}
		else {
			info("Save all changes by click on Create button");
			click(ELEMENT_ACCESS_AND_EDIT_TAB_OF_POPUP_CREATE_BTN);
		}
		Utils.pause(2000);
   }
}