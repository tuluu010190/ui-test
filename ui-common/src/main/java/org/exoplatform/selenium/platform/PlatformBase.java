package org.exoplatform.selenium.platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.exoplatform.selenium.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import static org.exoplatform.selenium.TestLogger.info; 


public class PlatformBase extends TestBase {

	/*------------- ---- Data for Portal ------------------------------*/
	public static final String ELEMENT_SIGN_IN_LINK = "//b[contains(text(),'Sign in')]";
	public static final String ELEMENT_INPUT_USERNAME = "//input[@name='username']";
	public static final String ELEMENT_INPUT_PASSWORD = "//input[@name='password']";
	public static final String ELEMENT_SIGN_IN_CONFIRM_BUTTON = "//form[@id='UIPortalComponentLogin']//div[@class='UIAction']/*";	
	public static final String ELEMENT_INPUT_CURRENTPASSWORD = "//input[@name='currentpass']";
	public static final String ELEMENT_INPUT_NEW_PASSWORD_MYACCOUNT = "//input[@id='newpass']";
	public static final String ELEMENT_INPUT_NEW_CONFIRM_PASSWORD_MYACCOUNT = "//input[@id='confirmnewpass']";

	public static final String ELEMENT_INPUT_CONFIRM_PASSWORD = "//input[@id='Confirmpassword']";
	public static final String ELEMENT_INPUT_NEW_PASSWORD = "//input[@id='newPassword']";
	public static final String ELEMENT_INPUT_NEW_CONFIRM_PASSWORD = "//input[@id='confirmPassword']";
	public static final String ELEMENT_INPUT_FIRSTNAME = "//input[@id='firstName']";
	public static final String ELEMENT_INPUT_LASTNAME = "//input[@id='lastName']";
	public static final String ELEMENT_INPUT_EMAIL = "//input[@id='email']";   
	public static final String ELEMENT_LINK_PORTAL_TOP_CONTAINER = "//ul[contains (@id, 'PortalNavigationContainer')]/..";
	public static final String ELEMENT_SIGN_OUT_LINK = "//a[@class='LogoutIcon']";
	public static final String ELEMENT_MESSAGE_TEXT = "//li[@class='MessageContainer']/span[contains(@class, 'PopupIcon')]";

	public static final String ELEMENT_ADD_NEW_PORTAL_LINK = "//a[text()='Add New Portal']";	
	public static final String ELEMENT_CHECKBOX_SHOW_INFO_BAR_BY_DEFAULT = "//input[@name='showInfobar']";
	public static final String ELEMENT_PORTAL_IN_LIST = "//td[@class='Content']/div[@class='Label' and text()='${portalName}']";
	public static final String ELEMENT_PORTAL_DELETE_ICON = "//div[@id='UISiteManagement']//table//tr/td/div[text()='${portalName}']/../../td[2]//a[@class='DeleteIcon']";
	public static final String ELEMENT_PORTAL_EDIT_ICON = "//td[@class='Content']/div[@class='Label' and text()='${portalName}']/../../td[3]/a[@class='EditNavIcon'][2]";
	public static final String ELEMENT_EDIT_FIRST_PORTAL_CONFIG = "//div[@id='UISiteManagement']//a[@class='EditNavIcon'][2]";
	public static final String ELEMENT_SWITCH_VIEW_MODE_PORTAL = "//a[text()='Switch View Mode']";
	public static final String ELEMENT_LINK_PORTAL = "//a[text()='Portal']";
	public static final String ELEMENT_LINK_SITE   = "//a[text()='Sites']";
	public static final String ELEMENT_LINK_GROUP = "//a[text()='Group Sites']";
	public static final String ELEMENT_GO_TO_PORTAL = "//a[text()='Login to the ACME social intranet']";

	public static final String ELEMENT_SELECT_LOCALE = "//select[@name='locale']";
	public static final String ELEMENT_SELECT_SKIN 	 = "//select[@name='skin']";
	public static final String ELEMENT_SELECT_SESSION_ALIVE= "//select[@name='sessionAlive']"; 
	public static final String ELEMENT_PROPERTIES_TAB = "//div[text()='Properties' and @class='MiddleTab']";
	public static final String ELEMENT_PERMISSION_SETTING_TAB= "//div[text()='Permission Settings' and @class='MiddleTab']";
	public static final String ELEMENT_CHECKBOX_PUBLIC_MODE = "//input[@name='publicMode']";
	public static final String ELEMENT_LINK_EDIT_PERMISSION = "//a[text()='Edit Permission Settings']";
	public static final String ELEMENT_SELECT_ACCESS_MEMBERSHIP_ITEM = "//a[text()='${membership}']";
	public static final String ELEMENT_SELECTED_ACCESS_PERMISSION_GROUP = "//div[@id='PermissionGrid']/table/tbody//div[text()='/${groupId}']";
	public static final String ELEMENT_SELECTED_ACCESS_PERMISSION_MEMBERSHIP = "//div[@id='PermissionGrid']/table/tbody//div[text()='${membership}']";
	public static final String ELEMENT_ADD_PERMISSION_BUTTON = "//a[text()='Add Permission']";
	public static final String ELEMENT_SELECT_EDIT_MEMBERSHIP_ITEM = "//div[@id='UIPermissionSelector']//a[text()='${membership}']";
	public static final String ELEMENT_SELECTED_EDIT_PERMISSION_GROUP = "// div[@class='SelectedPermissionInfo']/div[2]/div[.='/${groupId}']";
	public static final String ELEMENT_SELECTED_EDIT_PERMISSION_MEMBERSHIP = "//div[@class='SelectedPermissionInfo']/div[3]/div[.='${membership}']";
	public static final String ELEMENT_SELECT_PERMISSION_BUTTON = "//a[text()='Select Permission']";
	public static final String ELEMENT_SELECT_ACCESS_GROUP_ITEM = "//a[@title='${group}']";
	public static final String ELEMENT_SELECT_EDIT_GROUP_ITEM = "//div[@id='UIPermissionSelector']//a[text()='${group}']";
	public static final String ELEMENT_SELECT_EDIT_PORTAL_CONFIG = "//div[@id='UISiteManagement']//table//tr/td/div[text()='${portalName}']/../../td[2]//a[@class='EditPortIcon']";
	public static final String ELEMENT_SAVE_BUTTON 	 = "//a[text()='Save']";
	public static final String ELEMENT_CLOSE_BUTTON  = "//a[text()='Close']";
	public static final String ELEMENT_CANCEL_BUTTON = "//a[text()='Cancel']";
	public static final String ELEMENT_PAGINATOR_PAGE_LINK = "//a[contains(@class, 'Number') and text()='${number}']";
	public static final String ELEMENT_PAGINATOR_TOTAL_NUMBER = "//a[@class='PagesTotalNumber']";
	public static final String ELEMENT_PAGINATOR_NEXT_ICON = "//a[@class='Icon NextPageIcon']";
	public static final String ELEMENT_PAGINATOR_SELECTED_PAGE = "//a[@class='Number PageSelected' and text()='${number}']";
	public static final String ELEMENT_MESSAGE_DIALOG_CLOSE_ICON_IE = ELEMENT_MESSAGE_TEXT + "/../../../../../..//a";
	public static final String ELEMENT_MESSAGE_DIALOG_CLOSE_ICON = "//div[contains(@class, 'UIPopupWindow') and contains(@style, 'visibility: visible')]//span[text()='Messages']/..//a[@class='CloseButton']";
	public static final String ELEMENT_NODE_COPY = "//div[@id='NavigationNodePopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon CopyNode16x16Icon']";
	public static final String ELEMENT_NODE_CUT = "//div[@id='NavigationNodePopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon CutNode16x16Icon']";
	public static final String ELEMENT_NODE_CLONE = "//div[@id='NavigationNodePopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon CloneNode16x16Icon']";		
	public static final String ELEMENT_NODE_PASTE_HOME = "//div[@id='UINavigationNodeSelectorPopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon PasteNode16x16Icon']";
	public static final String ELEMENT_NODE_PASTE = "//div[@id='NavigationNodePopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon PasteNode16x16Icon']";
	/*------------- ---- End of Data for Portal ------------------------------*/

	/*------------- Data for Portal/Account -------------------------*/

	public static final String ELEMENT_CHANGE_PASSWORD_TAB = "//a[text()='Change Password' and @class='Icon ChangePass']";
	public static final String ELEMENT_USER_PROFILE_TAB = "//div[text()='User Profile' and @class='MiddleTab']";
	public static final String ELEMENT_SELECT_USER_LANGUAGE = "//select[@name='user.language']";
	public static final String ELEMENT_SEARCH_ICON_REGISTER = "//img[@class='SearchIcon']";
	public static final String ELEMENT_INPUT_USER_NAME_GIVEN = "//input[@id='user.name.given']";
	public static final String ELEMENT_ACCOUNT_SETTING_TAB = "//div[text()='Account Settings' and @class='MiddleTab']";
	public static final String ELEMENT_ACCOUNT_PROFILE_TAB = "//a[text()='Account Profiles' and @class='Icon AccountProfiles']";
	public static final String ELEMENT_USER_DELETE_ICON ="//div[@id='UIListUsersGird']//div[text()='${username}']/../..//img[@class='DeleteUserIcon']";
	public static final String ELEMENT_SEARCH_ICON_USERS_MANAGEMENT = "//form[@id='UISearchForm']/div[2]/a";
	public static final String ELEMENT_LINK_USERS_MANAGEMENT="//a[contains(text(),'Group and Roles')]";
	public static final String ELEMENT_INPUT_SEARCH_USER_NAME = "//input[@name='searchTerm']"; 
	public static final String ELEMENT_EDIT_USER_INFO =  "//img[@title='Edit User Info']" ;      
	public static final String ELEMENT_SELECT_SEARCH_OPTION = "//select[@name='searchOption']";
	public static final String ELEMENT_USER_EDIT_ICON = "//div[@id='UIListUsersGird']/table//tr/td/div[text()='${username}']/../../td[5]//img[@class='ViewUserInfoIcon']";

	public static final String ELEMENT_GROUP_ADD_NEW_ICON = "//div[@id='UIOrganizationPortlet']//div[@class='TitleBar']/a[@class='TreeActionIcon AddGroupIcon']";
	public static final String ELEMENT_INPUT_GROUP_NAME = "//input[@name='groupName']";
	public static final String ELEMENT_INPUT_LABEL = "//input[@id='label']";
	public static final String ELEMENT_TEXTAREA_DESCRIPTION = "//textarea[@id='description']";
	public static final String ELEMENT_GROUP_REMOVE_ICON = "//div[@id='UIOrganizationPortlet']//div[@class='TitleBar']/a[@class='TreeActionIcon RemoveGroupIcon']";
	public static final String ELEMENT_GROUP_EDIT_ICON = "//div[@id='UIOrganizationPortlet']//div[@class='TitleBar']/a[@class='TreeActionIcon EditGroupIcon']";
	public static final String ELEMENT_TAB_GROUP_MANAGEMENT = "//div[@class='GroupManagementIcon']/..";
	public static final String ELEMENT_GROUP_TO_SELECT_LINK = "//a[contains(@class, 'NodeIcon') and @title='${group}']";
	public static final String ELEMENT_GROUP_SELECTED = "//a[@class='NodeIcon PortalIcon NodeSelected' and @title='${group}']";
	public static final String ELEMENT_GROUP_SEARCH_USER_ICON = "//form[@id='UIGroupMembershipForm']/div[2]/div/table/tbody/tr[1]/td[2]/a";
	public static final String ELEMENT_GROUP_SEARCH_POPUP_ADD_ICON = "//form[@id='UIUserSelector']//div[@class='UIAction']//a[@class='ActionButton LightBlueStyle']";
	public static final String ELEMENT_SELECT_MEMBERSHIP = "//select[@name='membership']";
	public static final String ELEMENT_GROUP_USER_IN_TABLE = "//div[@class='UIUserInGroup']//div[@title='${username}']";
	public static final String ELEMENT_INPUT_NAME = "//input[@id='name']";    
	public static final String ELEMENT_TAB_MEMBERSHIP_MANAGEMENT = "//div[@class='MembershipManagementIcon']/..";
	public static final String ELEMENT_MEMBERSHIP_EDIT_ICON = "//div[@class='UIListMembershipType']//table//tr/td/div[text()='${membership}']/../../td[5]//img[@class='EditMembershipIcon']";
	public static final String ELEMENT_MEMBERSHIP_DELETE_ICON = "//div[@class='UIListMembershipType']//table//tr/td/div[text()='${membership}']/../../td[5]//img[@class='DeleteMembershipIcon']";
	public static final String ELEMENT_NEXT_PAGE_ICON = "//a[@title='Next Page']";
	public static final String ELEMENT_USER_MANAGEMENT = "//div[@class='UserManagementIcon']/.."; 
	public static final String ELEMENT_LINK_SETUP ="//img[@alt='Setup']";
	public static final String ELEMENT_LINK_USERS ="//a[text()='Users']";
	public static final String ELEMENT_LINK_ADDUSERS="//a[text()='Add Users']";

	/*------------- End of Data for Portal/Account -------------------------*/


	/*------------- Data for Portal/Manage Pages ---------------------------*/
	public static final String ELEMENT_ADD_NEW_PAGE_LINK = "//a[text()='Add New Page']";
	public static final String ELEMENT_LINK_PAGES   = "//a[text()='Pages']";
	public static final String ELEMENT_CHECKBOX_MAX_WINDOWS = "//input[@id='showMaxWindow']";
	public static final String ELEMENT_INPUT_TITLE = "//input[@id='title']";
	public static final String ELEMENT_SELECT_OWNER_TYPE = "//select[@name='ownerType']";
	public static final String ELEMENT_INPUT_SEARCH_TITLE = "//input[@id='pageTitle']";
	public static final String ELEMENT_PAGE_MANAGEMENT_SEARCH_BUTTON = "//form[@id='UIPageSearchForm']/div[2]/a[@class='SearchIcon']";

	public static final String ELEMENT_PAGE_EDIT_ICON = "//div[@id='UIVirtualList']//table//tr/td/div[contains(@title, '${page}')]/../../td[5]//img[@class='EditInfoIcon']";
	public static final String ELEMENT_PAGE_DELETE_ICON = "//div[@id='UIVirtualList']//table//tr/td/div[contains(@title, '${page}')]/../../td[5]//img[@class='DeleteIcon']";
	public static final String ELEMENT_LINK_EDITOR = "//a[@class='EditorIcon TBIcon' and text() = 'Edit']";
	public static final String ELEMENT_LINK_EDITOR_PAGE = "//a[text()='Page']";
	public static final String ELEMENT_LINK_EDITOR_ADD_PAGE = "//a[text()='Add Page']";	
	public static final String ELEMENT_INPUT_NODE_NAME = "//input[@id='pageName']";
	public static final String ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE = "//input[@name='switchmode']";

	public static final String ELEMENT_SELECT_LANGUAGE = "//select[@name='languages']";
	public static final String ELEMENT_INPUT_PAGE_DISPLAY_NAME = "//input[@id='pageDisplayName']";
	public static final String ELEMENT_PAGE_EDITOR_NEXT_STEP = "//div[@class='ActionBar']//a[text()='Next']";
	public static final String ELEMENT_EDIT_PAGE_CATEGORY_MENU = "//a[@class='TabLabel' and @title='${categoryLabel}']";
	public static final String ELEMENT_EDIT_PAGE_PAGE = "//div[@id='UIPage']";
	public static final String PORTLET_LABEL = "//div[@class='CPortletLayoutDecorator' and contains(text(), '${portletName}')]";	
	public static final String ELEMENT_PAGE_FINISH_BUTTON = "//div[@id='UIPageEditor']//a[@title='Finish']";

	public static final String ELEMENT_NODE_LINK = "//div[@id='UINavigationNodeSelector']//a[@title='${nodeLabel}']";
	public static final String ELEMENT_EDIT_NAVIGATION = "//div[@class='Label' and text()='${navigation}']/../../td[2]//a[@class='EditNavIcon']";
	public static final String ELEMENT_ADD_NODE_LINK = "//a[text()='Add Node']";
	public static final String ELEMENT_PAGE_SELECTOR_TAB = "//div[text()='Page Selector' and @class='MiddleTab']";
	public static final String ELEMENT_INPUT_LOCALIZED_LABEL = "//input[@id='i18nizedLabel']";
	public static final String ELEMENT_INPUT_PAGE_NAME = "//input[@id='pageName']";
	public static final String ELEMENT_INPUT_PAGE_TITLE = "//input[@id='pageTitle']";
	public static final String ELEMENT_CREATE_PAGE_LINK = "//a[text()='Create Page']";
	public static final String ELEMENT_SEARCH_SELECT_PAGE_LINK = "//a[text()='Search and Select Page']";
	public static final String ELEMENT_CLEAR_PAGE_LINK = "//a[text()='Clear Page']";

	public static final String ELEMENT_SELECT_HOME_PAGE = "//div[@id='UIRepeater']//table//tbody/tr/td[5]/div[@class='ActionContainer']/img";
	public static final String ELEMENT_NAVIGATION_HOME_NODE = "//div[@class='HomeNode']";				 
	public static final String ELEMENT_NODE_ADD_NEW_TOP_NODE = "//div[@id='UINavigationNodeSelectorPopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon AddNode16x16Icon']";
	public static final String ELEMENT_NODE_ADD_NEW = "//div[@id='NavigationNodePopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon AddNode16x16Icon']";
	public static final String ELEMENT_NODE_DELETE = "//div[@id='NavigationNodePopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon DeleteNode16x16Icon']";
	public static final String ELEMENT_NODE_EDIT = "//div[@id='NavigationNodePopupMenu']/div[@class='UIContextMenuContainer']//a[@class='ItemIcon EditSelectedNode16x16Icon']";
	public static final String ELEMENT_NAVIGATION_NODE_AREA= "//div[@class='Node']"; 
	/*------------- End of Data for Portal/Manage Pages --------------------*/

	/*------------- Data for Dashboard tab --------------------------------*/
	public static final String ELEMENT_DASHBOARD_NEW_ICON = "//div[@id='UITabPaneDashboard']/a[@class='AddDashboard']";
	public static final String ELEMENT_DASHBOARD_NEW_INPUT = "//div[@id='UITabPaneDashboard']//div[contains(@class, 'UITab SelectedTab')]/input";
	public static final String ELEMENT_DASHBOARD_SELECTED_PAGE_WITH_SPECIFIED_NAME = "//div[@id='UITabPaneDashboard']//span[text()='${dashboardName}']";
	public static final String ELEMENT_DASHBOARD_SELECTED = "//div[contains(@class, 'SelectedTab')]//span";
	public static final String ELEMENT_DASHBOARD_SELECTED_DELETE = "//div[contains(@class, 'SelectedTab')]//a[@class='CloseIcon']";
	public static final String ELEMENT_DASHBOARD_HOME_TAB = "div[@class='UITab SelectedTab']";
	public static final String ELEMENT_TAB_LINK = "//div[@id='UITabPaneDashboard']//span[text()='${tabName}']";
	/*------------ End of data for Dashboard tab --------------------------*/

	//Sign in function for eXoGTN
	public void signIn(String username, String password) {
		info("--Sign in as " + username + "--");
		click(ELEMENT_GO_TO_PORTAL);
		click(ELEMENT_SIGN_IN_LINK);
		type(ELEMENT_INPUT_USERNAME, username, true);
		type(ELEMENT_INPUT_PASSWORD, password, true);
		click(ELEMENT_SIGN_IN_CONFIRM_BUTTON);
		waitForElementNotPresent(ELEMENT_SIGN_IN_CONFIRM_BUTTON);
	}

	//Sign out for eXoGTN
	public void signOut(){
		Actions action_logout = new Actions(driver);
		WebElement UI = driver.findElement(By.id("UserNavigationTabsContainer"));
		action_logout.moveToElement(UI).build().perform();
		driver.findElement(By.linkText("Logout")).click();	
		pause(500);
	}

	// Add new user account 
	public  void addNewUserAccount(String username, String password, String confirmPassword, String firstName, 
			String lastName, String email, String userNameGiven, String language, boolean verify) {

		info("--Create new user using \"New Staff\" portlet--");
		type(ELEMENT_INPUT_USERNAME, username, true);
		type(ELEMENT_INPUT_PASSWORD, password, true);
		type(ELEMENT_INPUT_CONFIRM_PASSWORD, confirmPassword, true);
		type(ELEMENT_INPUT_FIRSTNAME, firstName, true);
		type(ELEMENT_INPUT_LASTNAME, lastName, true);
		type(ELEMENT_INPUT_EMAIL, email, true);
		click(ELEMENT_USER_PROFILE_TAB);
		waitForTextPresent("Given Name:");
		type(ELEMENT_INPUT_USER_NAME_GIVEN, userNameGiven, true);
		select(ELEMENT_SELECT_USER_LANGUAGE, language);
		click(ELEMENT_ACCOUNT_SETTING_TAB);
		save();

		if (verify) {
			waitForMessage("You have registered a new account.");
			closeMessageDialog();
		}
	}

	public  void goToUsersAndGroupsManagement() {
		info("--Go to Users and groups management--");
		goToPage(ELEMENT_LINK_SETUP, ELEMENT_LINK_SETUP, ELEMENT_LINK_USERS, ELEMENT_LINK_USERS_MANAGEMENT);
	}

	public  void chooseUserTab(){
		info("-- Choose User tab--");
		click(ELEMENT_USER_MANAGEMENT);
		waitForTextPresent("User Name");
	}

	public  void deleteUser(String username) {
		String userDeleteIcon = ELEMENT_USER_DELETE_ICON.replace("${username}", username);

		info("--Deleting user " + username + "--");
		if (isTextPresent("Total pages")) {
			usePaginator(userDeleteIcon, "User " + username + "not found in group");
		}
		pause(500);
		click(userDeleteIcon);
		waitForConfirmation("Are you sure to delete user " + username + "?");
		waitForTextNotPresent(username);
		click(ELEMENT_SEARCH_ICON_USERS_MANAGEMENT);
	}

	public  void searchUser(String user, String searchOption){
		info("--Search user " + user + "--");
		if (isTextPresent("Search")){
			type(ELEMENT_INPUT_SEARCH_USER_NAME, user, true);
			select(ELEMENT_SELECT_SEARCH_OPTION, searchOption);
		}	

		click(ELEMENT_SEARCH_ICON_USERS_MANAGEMENT);
		waitForTextPresent(user);
	}

	public  void editUser(String username) {
		String userEditIcon = ELEMENT_USER_EDIT_ICON.replace("${username}", username);

		info("--Editing user " + username + "--");
		click(userEditIcon);
		pause(1000);
	}

	public  void chooseGroupTab() {
		info("-- Choose Group Management tab--");
		click(ELEMENT_TAB_GROUP_MANAGEMENT);
		waitForTextPresent("Group Info");
	}

	public  void addGroup(String groupName, String groupLabel, String groupDesc, boolean verify){
		info("--Add a new group--");
		pause(500);
		click(ELEMENT_GROUP_ADD_NEW_ICON);
		type(ELEMENT_INPUT_GROUP_NAME, groupName, true);
		type(ELEMENT_INPUT_LABEL, groupLabel, true);
		type(ELEMENT_TEXTAREA_DESCRIPTION, groupDesc, true);
		save();
		if (verify) {
			waitForAndGetElement("//a[@title='" + (groupLabel.length() > 0 ? groupLabel : groupName) + "']");
		}

	}

	public  void selectGroup(String groupName) {
		info("--Select category (" + groupName + ")--");
		String groupID = "//a[@title='"+ groupName +"']"; 
		waitForAndGetElement("//a[@title='"+ groupName +"']");
		click(groupID);
	}

	public  void editGroup(String groupName, boolean verify){
		info("-- Edit group: " + groupName + "--");
		click(ELEMENT_GROUP_EDIT_ICON);
		pause(1000);
	}

	public  void deleteGroup(String groupName, boolean verify) {
		info("-- Delete group: " + groupName + "--");
		click(ELEMENT_GROUP_REMOVE_ICON);

		waitForConfirmation("Are you sure to delete this group?");
		if (verify) {
			waitForElementNotPresent(groupName);
		}
		pause(1000);
	}

	public  void addUsersToGroup(String userNames, String memberShip, boolean select, boolean verify) {

		info("--Adding users to group--");
		String[] users = userNames.split(",");
		if (select) {
			click(ELEMENT_GROUP_SEARCH_USER_ICON);
			waitForTextPresent("Select User");
			for (String user : users) {
				check("//input[@name='" + user + "']");
			}
			click(ELEMENT_GROUP_SEARCH_POPUP_ADD_ICON);
			pause(500);
			Assert.assertEquals(getValue(ELEMENT_INPUT_USERNAME), userNames);
		} else {
			type(ELEMENT_INPUT_USERNAME, userNames, true);
		}
		select(ELEMENT_SELECT_MEMBERSHIP, memberShip);
		save();
		if (verify) {
			for (String user : users) {
				String addedUser = ELEMENT_GROUP_USER_IN_TABLE.replace("${username}", user);
				if (isTextPresent("Total pages")) {
					usePaginator(addedUser, "User " + user + "not found in group");
				} else {
					waitForAndGetElement(addedUser);
				}
			}
		}
	}

	public  void chooseMembershipTab() {
		info("-- Choose Membership Management tab--");
		pause(500);
		click(ELEMENT_TAB_MEMBERSHIP_MANAGEMENT);
		waitForTextPresent("Add/Edit Membership");
	}

	public  void addMembership(String membershipName, String membershipDesc, boolean verify){
		boolean verifyMembership;
		info("--Creating new membership--");
		click(ELEMENT_TAB_MEMBERSHIP_MANAGEMENT);

		type(ELEMENT_INPUT_NAME, membershipName, true);
		type(ELEMENT_TEXTAREA_DESCRIPTION, membershipDesc, true);
		save();
		verifyMembership = isTextPresent(membershipName);
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else if (verify){
			click(ELEMENT_NEXT_PAGE_ICON);	
			waitForTextPresent(membershipName);
		}

	}

	public  void editMembership(String membershipName, String newDesc){
		info("-- Edit membership: " + membershipName + "--");

		boolean verifyMembership;
		verifyMembership = isTextPresent(membershipName);
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else {
			click(ELEMENT_NEXT_PAGE_ICON);
		}

		String editIcon = ELEMENT_MEMBERSHIP_EDIT_ICON.replace("${membership}", membershipName);
		String membershipInput = "//input[@value='" + membershipName + "']";
		click(editIcon);
		pause(1000);
		waitForAndGetElement(membershipInput);
		type(ELEMENT_TEXTAREA_DESCRIPTION, newDesc, true);
		save();
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else {
			click(ELEMENT_NEXT_PAGE_ICON);
		}
		waitForTextPresent(newDesc);
	}

	public  void deleteMembership(String membershipName, boolean verify){

		boolean verifyMembership;
		verifyMembership = isTextPresent(membershipName);
		if (verifyMembership){
			waitForTextPresent(membershipName);
		}
		else {
			click(ELEMENT_NEXT_PAGE_ICON);
		}
		String deleteIcon = ELEMENT_MEMBERSHIP_DELETE_ICON.replace("${membership}", membershipName);
		info("--Deleting membership--");
		click(deleteIcon);
		waitForConfirmation("Are you sure to delete this membership?");
		if (!verifyMembership){
			waitForTextNotPresent(membershipName);
		}
		else if (verify) {
			click(ELEMENT_NEXT_PAGE_ICON);
			waitForTextNotPresent(membershipName);
		}

	}

	/*--------------------- Functions for portal  -----------------------------------*/

	//Go to portal sites
	public  void goToPortalSites() {
		info("--Go to Portal Site Management--");
		mouseOver(ELEMENT_LINK_SETUP, false);
		pause(500);
		mouseOver(ELEMENT_LINK_PORTAL, false);
		pause(500);
		WebElement element;
		element = waitForAndGetElement(ELEMENT_LINK_SITE);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);

	}

	/*-----------------------  Add new portal  ------------------------------*/

	//Add new portal
	public void addNewPortal(String portalName, String portalLocale, String portalSkin, String portalSession, 
			boolean publicMode, Map<String, String> permissions, String editGroupId, String editMembership){
		info("--Create new portal--");

		click(ELEMENT_ADD_NEW_PORTAL_LINK);
		waitForTextPresent("Portal Setting");
		type(ELEMENT_INPUT_NAME, portalName, true);
		select(ELEMENT_SELECT_LOCALE, portalLocale);
		select(ELEMENT_SELECT_SKIN, portalSkin);
		click(ELEMENT_PROPERTIES_TAB);
		select(ELEMENT_SELECT_SESSION_ALIVE, portalSession);
		click(ELEMENT_PERMISSION_SETTING_TAB);

		if (publicMode) {
			waitForAndGetElement(ELEMENT_ADD_PERMISSION_BUTTON);
			check(ELEMENT_CHECKBOX_PUBLIC_MODE);
			waitForElementNotPresent(ELEMENT_ADD_PERMISSION_BUTTON);
		} else {
			for (String key : permissions.keySet()) {
				setViewPermissions(key, permissions.get(key));
			}
		}
		click(ELEMENT_LINK_EDIT_PERMISSION);
		setEditPermissions(editGroupId, editMembership);
		save();
	}

	//Edit a portal
	public void editPortal(String portalName, String portalLocale, String portalSkin, String portalSession, 
			boolean publicMode, Map<String, String> permissions, String editGroupId, String editMembership){
		info("--Create new portal--");

		String editIcon = ELEMENT_SELECT_EDIT_PORTAL_CONFIG.replace("${portalName}", portalName);		
		click(editIcon);

		waitForTextPresent("Portal Setting");

		select(ELEMENT_SELECT_LOCALE, portalLocale);
		select(ELEMENT_SELECT_SKIN, portalSkin);
		click(ELEMENT_PROPERTIES_TAB);
		select(ELEMENT_SELECT_SESSION_ALIVE, portalSession);
		click(ELEMENT_PERMISSION_SETTING_TAB);

		click (ELEMENT_CHECKBOX_PUBLIC_MODE);

		if (publicMode) {
			waitForAndGetElement(ELEMENT_ADD_PERMISSION_BUTTON);
			check(ELEMENT_CHECKBOX_PUBLIC_MODE);
			waitForElementNotPresent(ELEMENT_ADD_PERMISSION_BUTTON);
		} else {
			for (String key : permissions.keySet()) {
				setViewPermissions(key, permissions.get(key));
			}
		}
		click(ELEMENT_LINK_EDIT_PERMISSION);
		setEditPermissions(editGroupId, editMembership);
		save();
	}

	//Delete a portal	
	public void deletePortal(String portalName){
		String portalDeleteIcon = ELEMENT_PORTAL_DELETE_ICON.replace("${portalName}", portalName);
		info("--Delete portal (" + portalName + ")--");		
		click(portalDeleteIcon);
		waitForConfirmation("Are you sure to delete this portal?");
		//info("--Verify portal deleted--");		
		waitForTextNotPresent(portalName);

	}

	//Set view permissions for portal
	public void setViewPermissions(String groupId, String membership) {
		String membershipToSelect = ELEMENT_SELECT_ACCESS_MEMBERSHIP_ITEM.replace("${membership}", membership);
		//String selectedGroup = ELEMENT_SELECTED_ACCESS_PERM_GROUP.replace("${groupId}", groupId.replace(" ", "-").toLowerCase());
		String selectedMembership = ELEMENT_SELECTED_ACCESS_PERMISSION_MEMBERSHIP.replace("${membership}", membership);

		info("--Setting view permission to " + groupId + ", " + membership + "--");
		String[] groups = groupId.split("/");
		pause(500);
		click(ELEMENT_ADD_PERMISSION_BUTTON);
		waitForTextPresent("Browse and select a group");
		for (String group : groups) {
			String groupToSelect = ELEMENT_SELECT_ACCESS_GROUP_ITEM.replace("${group}", group);
			click(groupToSelect);
		}
		pause(500);
		click(membershipToSelect);
		pause(500);
		waitForTextNotPresent("Permission Selector");
		//waitForAndGetElement(selectedGroup);
		waitForAndGetElement(selectedMembership);
	}

	//Set edit permissions for portal
	public void setEditPermissions(String groupId, String membership) {
		String membershipToSelect = ELEMENT_SELECT_EDIT_MEMBERSHIP_ITEM.replace("${membership}", membership);
		//String selectedGroup = ELEMENT_SELECTED_EDIT_PERM_GROUP.replace("${groupId}", groupId.replace(" ", "-").toLowerCase());
		String selectedMembership = ELEMENT_SELECTED_EDIT_PERMISSION_MEMBERSHIP.replace("${membership}", membership);

		info("--Setting edit permission to " + groupId + ", " + membership + "--");
		String[] groups = groupId.split("/");
		click(ELEMENT_SELECT_PERMISSION_BUTTON);
		pause(500);
		waitForTextPresent("Permission Selector");
		for (String group : groups) {
			String groupToSelect = ELEMENT_SELECT_EDIT_GROUP_ITEM.replace("${group}", group);
			click(groupToSelect);
		}
		click(membershipToSelect);
		waitForTextNotPresent("Permission Selector");
		//waitForAndGetElement(selectedGroup);
		waitForAndGetElement(selectedMembership);
	}

	//verify the existence of portal
	public void verifyPortalExists(String portalName) {
		String portal = ELEMENT_PORTAL_IN_LIST.replace("${portalName}", portalName);

		info("--Verify portal (" + portalName + ") exist--");
		goToPortalSites();
		waitForAndGetElement(portal);
	}

	/*------------ Add new page for Portal --------------*/

	//Define a type of page
	public static enum PageType {
		PORTAL, GROUP;
	}


	//Go to Portal Manage Pages	
	public  void goToManagePages() {
		info("--Go to Portal Site Management--");			
		mouseOver(ELEMENT_LINK_SETUP, false);
		pause(500);
		mouseOver(ELEMENT_LINK_PORTAL, false);
		pause(500);
		WebElement element;
		element = waitForAndGetElement(ELEMENT_LINK_PAGES);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);

	}

	//Add a new page at manage pages
	public void addNewPageAtManagePages(PageType type, String pageName, String title, boolean publicMode, 
			Map<String, String> permissions, String groupId, String membership ){

		click(ELEMENT_ADD_NEW_PAGE_LINK);
		waitForTextPresent("Page Settings");	
		switch (type){

		case PORTAL:
			select(ELEMENT_SELECT_OWNER_TYPE, "portal");
			break;
		case GROUP:	
			select(ELEMENT_SELECT_OWNER_TYPE, "group");
			break;
		default:
			break;
		}		
		type(ELEMENT_INPUT_NAME, pageName, true);
		type(ELEMENT_INPUT_TITLE, title, true);		
		//showMaxWindow
		check(ELEMENT_CHECKBOX_MAX_WINDOWS);
		click(ELEMENT_PERMISSION_SETTING_TAB);	
		WebElement element = waitForAndGetElement(ELEMENT_CHECKBOX_PUBLIC_MODE);		
		if (publicMode & !element.isSelected()) {
			waitForAndGetElement(ELEMENT_ADD_PERMISSION_BUTTON);
			check(ELEMENT_CHECKBOX_PUBLIC_MODE);
			waitForElementNotPresent(ELEMENT_ADD_PERMISSION_BUTTON);
		} else if (publicMode & element.isSelected()){
			waitForElementNotPresent(ELEMENT_ADD_PERMISSION_BUTTON);
		} else {
			for (String key : permissions.keySet()) {
				setViewPermissions(key, permissions.get(key));
			}
		}		
		click(ELEMENT_LINK_EDIT_PERMISSION);
		setEditPermissions(groupId, membership);
		save();
		pause(1000);
		searchPageByTitle(type, title);

	}

	//Edit a page at Manage Pages
	public void editPageAtManagePages(PageType type, String pageName){
		String pageEditIcon = ELEMENT_PAGE_EDIT_ICON.replace("${page}", pageName);
		searchPageByTitle(type, pageName);
		click(pageEditIcon);
		pause(1000);

	}

	//Delete a page
	public void deletePage(PageType type, String pageName){
		String pageDeleteIcon = ELEMENT_PAGE_DELETE_ICON.replace("${page}", pageName);
		searchPageByTitle(type, pageName);
		click(pageDeleteIcon);
		waitForConfirmation("Are you sure to delete this page?");
		closeMessageDialog();
		pause(1000);

	}

	// Search a page in Manage Pages
	public void searchPageByTitle(PageType type, String pageTitle){
		type(ELEMENT_INPUT_SEARCH_TITLE, pageTitle, true);
		switch (type){
		case PORTAL:
			select(ELEMENT_SELECT_SEARCH_OPTION, "portal");
			break;
		case GROUP:
			select(ELEMENT_SELECT_SEARCH_OPTION, "group");
			break;
		default:
			break;
		}
		click(ELEMENT_PAGE_MANAGEMENT_SEARCH_BUTTON);
		pause(1000);
		waitForTextPresent(pageTitle);

	}

	//Go to add page locator with Editor

	public void goToAddPageEditor(){
		mouseOver(ELEMENT_LINK_EDITOR, true);
		pause(500);
		mouseOver(ELEMENT_LINK_EDITOR_PAGE, true);
		pause(500);
		WebElement element = waitForAndGetElement(ELEMENT_LINK_EDITOR_ADD_PAGE);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);

	}

	// Input data for page

	public void addNewPageEditor(String nodeName, String displayName, String language, String categoryTitle, 
			Map<String, String> portletIds, boolean extendedLabelMode){

		type(ELEMENT_INPUT_NODE_NAME, nodeName, true);
		WebElement element = waitForAndGetElement(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
		if (extendedLabelMode){
			Assert.assertTrue(element.isSelected());
			select(ELEMENT_SELECT_LANGUAGE, language);

		}else {
			uncheck(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
			type(ELEMENT_INPUT_PAGE_DISPLAY_NAME, displayName, true);
		}

		click(ELEMENT_PAGE_EDITOR_NEXT_STEP);
		waitForTextPresent("Empty Layout");
		click(ELEMENT_PAGE_EDITOR_NEXT_STEP);

		String category = ELEMENT_EDIT_PAGE_CATEGORY_MENU.replace("${categoryLabel}", categoryTitle);
		click(category);

		for (String portletId : portletIds.keySet()) {
			String elementEditPagePage = ELEMENT_EDIT_PAGE_PAGE;
			//String verification = PORTLET_LABEL.replace("${portletName}", portletIdsAndVerifications.get(portletId));
			dragAndDropToObject("//div[@id='" + portletId + "']//img", elementEditPagePage);
		}
		pause(500);
		click(ELEMENT_PAGE_FINISH_BUTTON);
		waitForTextNotPresent("Page Editor");
	}
	
	/*---------------- Add node for Portal ---------------------*/

	// Add a node for portal at portal navigation
	public void addNodeForPortal(String currentNavigation, String currentNodeLabel, boolean useAddNodeLink, String nodeName, boolean extendedLabelMode, 
			Map<String, String> languages, String nodeLabel, String pageName, String pageTitle, boolean verifyPage, boolean verifyNode){

		//String node = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeLabel);
		String currentNode = ELEMENT_NODE_LINK.replace("${nodeLabel}", currentNodeLabel);
		editNavigation(currentNavigation);

		info("--Adding new node at navigation--");		
		if (useAddNodeLink){
			click(currentNode);
			click(ELEMENT_ADD_NODE_LINK);
		}else{

			click(currentNode);
			pause(500);
			rightClickOnElement(currentNode);
			if (currentNode.equals(ELEMENT_NAVIGATION_HOME_NODE)) {
				click(ELEMENT_NODE_ADD_NEW_TOP_NODE);
			} else {
				click(ELEMENT_NODE_ADD_NEW);
			}		
		}
		waitForTextPresent("Page Node Settings");
		type(ELEMENT_INPUT_NAME, nodeName, true);

		if (extendedLabelMode) {
			for (String language : languages.keySet()) {
				select(ELEMENT_SELECT_LANGUAGE, language);
				pause(500);
			}
		} else {
			uncheck(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
			type(ELEMENT_INPUT_LABEL, nodeLabel, true);
		}

		click(ELEMENT_PAGE_SELECTOR_TAB);

		if (pageName != null & pageTitle != null) {
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
			//info("-- Select Page --");
			pause(500);
			click(ELEMENT_SEARCH_SELECT_PAGE_LINK);
			click(ELEMENT_SELECT_HOME_PAGE);
		}

		info("-- Save add node for portal --");
		pause(1000);
		save();
		if (verifyNode) {
			waitForTextNotPresent("Page Node Settings");
			waitForTextPresent(nodeName);
			save();
			waitForTextNotPresent("Navigation Management");
		}
	}

	// Edit a node 
	public void editNode(String currentNavigation, String nodeNameHome, String nodeName, boolean extendedLabelMode, Map<String, String> languages, 
			String nodeLabel, String pageName, String pageTitle, boolean firstLevel){

		String currentNodeHome = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeNameHome);
		String currentNodeName = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName);
		editNavigation(currentNavigation);
		//currentNodeHome.equals(ELEMENT_NAVIGATION_NODE_AREA)
		if (firstLevel){
			click(currentNodeName);
			rightClickOnElement(currentNodeName);
			click(ELEMENT_NODE_EDIT);	
		}else {
			click(currentNodeHome);
			click(currentNodeName);
			rightClickOnElement(currentNodeName);
			click(ELEMENT_NODE_EDIT);	

		}
		waitForTextPresent("Page Node Settings");
		if (extendedLabelMode) {
			for (String language : languages.keySet()) {
				select(ELEMENT_SELECT_LANGUAGE, language);
				pause(500);
			}
		} else {
			uncheck(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
			type(ELEMENT_INPUT_LABEL, nodeLabel, true);
		}

		click(ELEMENT_PAGE_SELECTOR_TAB);
		click(ELEMENT_CLEAR_PAGE_LINK);
		type(ELEMENT_INPUT_PAGE_NAME, pageName, true);
		type(ELEMENT_INPUT_PAGE_TITLE, pageTitle, true);
		click(ELEMENT_CREATE_PAGE_LINK);
		pause(1000);
		save();
		pause(1000);
		save();
		waitForTextNotPresent("Navigation Management");
	}

	//Delete a node from Portal navigation
	public void deleteNode(String currentNavigation, String nodeNameHome, String nodeName, boolean firstLevel){
		info("--Deleting node from navigation--");
		String currentNodeHome = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeNameHome);	
		String currentNodeName = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName);
		editNavigation(currentNavigation);
		//currentNodeHome.equals(ELEMENT_NAVIGATION_NODE_AREA)
		if (firstLevel){
			click(currentNodeName);
			rightClickOnElement(currentNodeName);
			click(ELEMENT_NODE_DELETE);
			waitForConfirmation("Are you sure to delete this node?");
			waitForTextNotPresent(nodeName);
			save();		
		}else {
			click(currentNodeHome);
			click(currentNodeName);
			rightClickOnElement(currentNodeName);
			click(ELEMENT_NODE_DELETE);
			waitForConfirmation("Are you sure to delete this node?");
			waitForTextNotPresent(nodeName);
			save();		
		}
		waitForTextNotPresent("Navigation Management");
	}

	//Link to Edit a navigation
	public void editNavigation(String currentNavigation) {
		String navigation = ELEMENT_EDIT_NAVIGATION.replace("${navigation}", currentNavigation);
		click(navigation);
		waitForTextPresent("Navigation Management");
	}

	/*---------------- Add node for Group ---------------------*/

	//Go to Portal/Group Sites
	public void goToGroupSites(){
		info("--Go to Portal Site Management--");
		mouseOver(ELEMENT_LINK_SETUP, false);
		pause(500);
		mouseOver(ELEMENT_LINK_PORTAL, false);
		pause(500);
		WebElement element;
		element = waitForAndGetElement(ELEMENT_LINK_GROUP);
		actions.moveToElement(element).click(element).build().perform();
		pause(500);
	}

	//Add a node for group at group navigation
	public void addNodeForGroup(String currentNavigation, String currentNodeLabel, boolean useAddNodeLink, String nodeName, boolean extendedLabelMode, 
			Map<String, String> languages, String nodeLabel, String pageName, String pageTitle, boolean verifyPage, boolean verifyNode){

		//String node = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeLabel);
		String currentNode = ELEMENT_NODE_LINK.replace("${nodeLabel}", currentNodeLabel);
		editNavigation(currentNavigation);

		info("--Adding new node at navigation--");		
		if (useAddNodeLink){
			click(currentNode);
			click(ELEMENT_ADD_NODE_LINK);
		}else{

			click(currentNode);
			pause(500);
			rightClickOnElement(currentNode);
			if (currentNode.equals(ELEMENT_NAVIGATION_HOME_NODE)) {
				click(ELEMENT_NODE_ADD_NEW_TOP_NODE);
			} else {
				click(ELEMENT_NODE_ADD_NEW);
			}		
		}
		waitForTextPresent("Page Node Settings");
		type(ELEMENT_INPUT_NAME, nodeName, true);

		if (extendedLabelMode) {
			for (String language : languages.keySet()) {
				select(ELEMENT_SELECT_LANGUAGE, language);
				pause(500);
			}
		} else {
			uncheck(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
			type(ELEMENT_INPUT_LABEL, nodeLabel, true);
		}

		click(ELEMENT_PAGE_SELECTOR_TAB);

		if (pageName != null & pageTitle != null) {
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
			//info("-- Select Page --");
			pause(500);
			click(ELEMENT_SEARCH_SELECT_PAGE_LINK);
			click(ELEMENT_SELECT_HOME_PAGE);
		}

		info("-- Save add node for portal --");
		pause(1000);
		save();
		if (verifyNode) {
			waitForTextNotPresent("Page Node Settings");
			waitForTextPresent(nodeName);
			save();
			waitForTextNotPresent("Navigation Management");
		}
	}
	/*-------------- Actions (Copy, Cut, Clone) at Portal/Group navigation ---------------*/

	/*---------------------- Add tab at Dashboard ---------------------------------*/
	//Go to Dashboard
	public void goToDashboard(){
		info("--Go to Dashboard page--");
		WebElement element = driver.findElement(By.id("UserNavigationTabsContainer"));
		actions.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Dashboard")).click();	
	}

	//Add new page on Dashboard
	public void addNewTabOnDashboard(String displayName, boolean verify) {
		info("--Add new page on dashboard--");
		click(ELEMENT_DASHBOARD_NEW_ICON);
		type(ELEMENT_DASHBOARD_NEW_INPUT, displayName, true);
		WebElement element = waitForAndGetElement(ELEMENT_DASHBOARD_NEW_INPUT);
		element.sendKeys(Keys.RETURN);
		if (verify) {
			waitForAndGetElement("//span[text()='" + displayName + "']");
		}
	}


	//Add new page on Dashboard with Editor
	public void addNewTabOnDashboardWithEditor(String nodeName, boolean extendedLabelMode, String displayName, 
			String language, String categoryTitle, Map<String, String> portletIds, boolean verify){

		goToAddPageEditor();
		type(ELEMENT_INPUT_NODE_NAME, nodeName, true);
		WebElement element = waitForAndGetElement(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
		if (extendedLabelMode){
			Assert.assertTrue(element.isSelected());
			select(ELEMENT_SELECT_LANGUAGE, language);
		}else {
			uncheck(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
			type(ELEMENT_INPUT_PAGE_DISPLAY_NAME, displayName, true);
		}
		click(ELEMENT_PAGE_EDITOR_NEXT_STEP);
		waitForTextPresent("Empty Layout");
		click(ELEMENT_PAGE_EDITOR_NEXT_STEP);

		String category = ELEMENT_EDIT_PAGE_CATEGORY_MENU.replace("${categoryLabel}", categoryTitle);
		click(category);

		for (String portletId : portletIds.keySet()) {
			String elementEditPagePage = ELEMENT_EDIT_PAGE_PAGE;
			//String verification = PORTLET_LABEL.replace("${portletName}", portletIdsAndVerifications.get(portletId));
			dragAndDropToObject("//div[@id='" + portletId + "']//img", elementEditPagePage);
		}
		pause(500);
		click(ELEMENT_PAGE_FINISH_BUTTON);
		waitForTextNotPresent("Page Editor");
		if (verify) {
			waitForAndGetElement("//span[text()='" + nodeName + "']");
		}
	}

	//Edit a tab name
	public void editTabNameOnDashboard(String currentName, String newName) {

		info("--Edit name of page on dashboard--");
		WebElement element;
		element = waitForAndGetElement("//a[@class='Tablabel' and text()='" + currentName + "']");
		actions.moveToElement(element).click(element).build().perform();

		doubleClickOnElement(ELEMENT_DASHBOARD_SELECTED);

		type(ELEMENT_DASHBOARD_NEW_INPUT, newName, true);
		WebElement elementbis = waitForAndGetElement(ELEMENT_DASHBOARD_NEW_INPUT);
		elementbis.sendKeys(Keys.RETURN);

		waitForAndGetElement("//span[text()='" + newName + "']");
		waitForElementNotPresent("//span[text()='" + currentName + "']");
	}

	//Delete a tab
	public void deleteTabOnDashboard(String currentName, boolean confirm){
		info("--Delete selected page on dashboard--");

		if(confirm){ 

			WebElement element;
			element = waitForAndGetElement("//a[@class='Tablabel' and text()='" + currentName + "']");
			actions.moveToElement(element).click(element).build().perform();
			click(ELEMENT_DASHBOARD_SELECTED_DELETE);
		} else {
			click(ELEMENT_DASHBOARD_SELECTED_DELETE);
		}	
		waitForConfirmation("Are you sure to remove this dashboard?");
		waitForElementNotPresent("//span[text()='" + currentName + "']");
	}

	/*---------------------- Edit user in My account ---------------------------------*/

	//Go to My Account
	public void goToMyAccount(){
		WebElement UI = driver.findElement(By.id("UserNavigationTabsContainer"));
		actions.moveToElement(UI).build().perform();
		driver.findElement(By.linkText("My Account")).click();	
		pause(500);
	}

	//Edit user in My Account
	public void editUserInMyAccount(String firstName, String lastName, String email, String currentPassword, String newPassword, 
			String confirmNewPassword){
		info("-- Edit user in My Account --");

		type(ELEMENT_INPUT_FIRSTNAME, firstName, true);
		type(ELEMENT_INPUT_LASTNAME, lastName, true);
		type(ELEMENT_INPUT_EMAIL, email, true);
		click(ELEMENT_CHANGE_PASSWORD_TAB);
		waitForTextPresent("Current Password:");

		type(ELEMENT_INPUT_CURRENTPASSWORD, currentPassword, true);
		type(ELEMENT_INPUT_NEW_PASSWORD_MYACCOUNT, newPassword, true);
		type(ELEMENT_INPUT_NEW_CONFIRM_PASSWORD_MYACCOUNT, confirmNewPassword, true);
		click(ELEMENT_ACCOUNT_PROFILE_TAB);

		save();		
		waitForMessage("The account information has been updated.")		;
		closeMessageDialog();
		close();

	}
	/*---------------------- Auxiliary Functions --------------------------*/

	public void setup(){
		ieFlag = "true".equals(System.getProperty("selenium.browser"));
		chromeFlag = "true".equals(System.getProperty("selenium.browser"));
	}

	//uncheck a checked-box
	public void uncheck(String locator) {
		try {
			WebElement element = waitForAndGetElement(locator);

			if (element.isSelected()) {
				actions.click(element).perform();
			} else {
				Assert.fail("Element " + locator + " is already unchecked.");
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			pause(1000);
			uncheck(locator);
		} finally {
			loopCount = 0;
		}
	}

	//rightClickOnElement
	public void rightClickOnElement(String locator) {
		pause(500);
		try {
			WebElement element = waitForAndGetElement(locator);
			actions.contextClick(element).perform();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			pause(1000);
			rightClickOnElement(locator);
		} finally {
			loopCount = 0;
		}
	}

	//doubleClickOnElement
	public void doubleClickOnElement(String locator) {
		try {
			WebElement element = waitForAndGetElement(locator);
			actions.doubleClick(element).perform();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			pause(1000);
			doubleClickOnElement(locator);
		} finally {
			loopCount = 0;
		}
	}

	//dragAndDropToObject
	public void dragAndDropToObject(String xpathSource, String xpathTarget) {
		info("--Drag and drop to object--");
		Actions action = new Actions(driver);
		try {
			WebElement source = waitForAndGetElement(xpathSource);
			WebElement target = waitForAndGetElement(xpathTarget);

			action.dragAndDrop(source, target).build().perform();
		} catch (StaleElementReferenceException e) {
			info("drag and drop error!");
		}
	}

	//verifyDragAndDrop
	private void verifyDragAndDrop(String xpath, String xpathSource, String xpathTarget) {
		int seconds = 0;
		for (; ieFlag && isElementNotPresent(xpath); seconds++) {
            if (seconds >= (DEFAULT_TIMEOUT/50 ) ) {
                Assert.fail("Timeout at dragAndDropToObject");
            }
            pause(500);
            try {
                WebElement source = waitForAndGetElement(xpathSource);
                WebElement target = waitForAndGetElement(xpathTarget);

                actions.dragAndDrop(source, target).build().perform();
            } catch (StaleElementReferenceException e) {
            	checkCycling(e, 5);
                verifyDragAndDrop(xpath, xpathSource, xpathTarget);
                break;
            } finally {
                loopCount = 0;
            }
        }
        seconds = 0;
        if (!ieFlag) {
            waitForAndGetElement(xpath);
        }
       }

	//Close message pop-up
	public void closeMessageDialog() {
		//info("--Closing message dialog--");
		setup();
		if (ieFlag) {
			click(ELEMENT_MESSAGE_DIALOG_CLOSE_ICON_IE);
		} else {
			click(ELEMENT_MESSAGE_DIALOG_CLOSE_ICON);
		}
	}

	//Copy value from Source and paste to Target
	public void copyPaste(String Source, String value, String Target){ 	
		WebElement element = waitForAndGetElement(Source);
		element.sendKeys(value);
		actions.doubleClick(element).perform();
		element.sendKeys(Keys.LEFT_CONTROL + "a");
		element.sendKeys(Keys.LEFT_CONTROL + "c");
		pause(3000);
		WebElement b = waitForAndGetElement(Target);
		b.sendKeys(Keys.LEFT_CONTROL + "v");
	}

	//Go to Users and management page
	public void goToNewStaff() {
		//info("Go to New Staff");
		goToPage(ELEMENT_SEARCH_ICON_REGISTER, ELEMENT_LINK_SETUP, ELEMENT_LINK_USERS, ELEMENT_LINK_ADDUSERS);
	}

	//Go to the desired locator
	public void goToPage(String verification, String... navigation) {
		String page = makeLink(navigation[navigation.length - 1]);
		boolean needToBeVerified = true;

		List<String> navigationList = new ArrayList<String>();

		for (int i = 0; i < (navigation.length - 1); i++) {
			String node = navigation[i];
			node = makeLink(node);
			navigationList.add(node);
		}

		try {
			for (String node : navigationList) {
				if (ieFlag) {
					actions.moveToElement(getElement(node));
				} else {
					mouseOver(node, false);
				}
			}
			mouseOverAndClick(page);
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			goToPage(verification, navigation);
			needToBeVerified = false;
		} finally {
			loopCount = 0;
		}

		if (verification != null && needToBeVerified) {
			pause(500);
			verifyLocation(verification, navigationList, page);
		}
	}

	private static String makeLink(String node) {
		if (!node.contains("//")) {
			String label = node;
			node = "//a[text()='" + label + "']";
		}
		return node;
	}

	private  void verifyLocation(String locator, List<String> navigation, String page) {
		info("verifyLocation, element: " + locator);
		int seconds = 0;
		setup();
		if (isElementNotPresent(locator)) {
			pause(1000);
		}
		for (; isElementNotPresent(locator); seconds++) {
			if (seconds >= (DEFAULT_TIMEOUT/50) ) {
				Assert.fail("Timeout at goToPage");
			}
			pause(500);
			try {
				for (String node : navigation) {
					if (ieFlag) {
						actions.moveToElement(getElement(locator));
					} else {
						mouseOver(node, false);
					}
				}
				mouseOverAndClick(page);
			} catch (StaleElementReferenceException e) {
				checkCycling(e, 5);
				verifyLocation(locator, navigation, page);
				break;
			} finally {
				loopCount = 0;
			}
		}
		seconds = 0;
	}

	public void usePaginator(String locator, String exceptionMessage) {
		String page1 = ELEMENT_PAGINATOR_PAGE_LINK.replace("${number}", "1");

		click(page1);
		pause(500);
		int totalPages = isElementPresent(ELEMENT_PAGINATOR_TOTAL_NUMBER) ? Integer.valueOf(getText(ELEMENT_PAGINATOR_TOTAL_NUMBER)) : 1;
		int i = 1;
		while (isElementNotPresent(locator)) {
			if (i == totalPages) {
				Assert.fail(exceptionMessage);
			}
			click(ELEMENT_PAGINATOR_NEXT_ICON);
			waitForAndGetElement(ELEMENT_PAGINATOR_SELECTED_PAGE.replace("${number}", String.valueOf((++i))));
			pause(500);
		}
	}

	public void save() {
		waitForAndGetElement(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_SAVE_BUTTON);
	}

	public void close(){
		waitForAndGetElement(ELEMENT_CLOSE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
	}
}
