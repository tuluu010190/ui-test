package org.exoplatform.selenium.platform;

import org.exoplatform.selenium.TestBase;
import org.testng.Assert;

public class PlatformBase extends TestBase {
	
	/*------------- ---- Data for Portal ------------------------------*/
	public static String ELEMENT_ADD_NEW_PORTAL_LINK = "//a[text()='Add New Portal']";	
	public static String ELEMENT_CHECKBOX_SHOW_INFO_BAR_BY_DEFAULT = "//input[@name='showInfobar']";
	public static String ELEMENT_PORTAL_IN_LIST = "//td[@class='Content']/div[@class='Label' and text()='${portalName}']";
	public static String ELEMENT_PORTAL_DELETE_ICON = "//td[@class='Content']/div[@class='Label' and text()='${portalName}']/../../td[3]/a[@class='DeleteIcon']";
	public static String ELEMENT_PORTAL_EDIT_ICON = "//td[@class='Content']/div[@class='Label' and text()='${portalName}']/../../td[3]/a[@class='EditNavIcon'][2]";
	public static String ELEMENT_EDIT_FIRST_PORTAL_CONFIG = "//div[@id='UISiteManagement']//a[@class='EditNavIcon'][2]";
	public static String ELEMENT_SWITCH_VIEW_MODE_PORTAL = "//a[text()='Switch View Mode']";
	public static String ELEMENT_LINK_Portal = "//a[text()='Portal']";
	public static String ELEMENT_LINK_SITE   = "//a[text()='Sites']";
	
	public static String ELEMENT_SELECT_LOCALE = "//select[@name='locale']";
	public static String ELEMENT_SELECT_SKIN 	 = "//select[@name='skin']";
	public static String ELEMENT_SELECT_SESSION_ALIVE= "//select[@name='sessionAlive']"; 
	public static String ELEMENT_PROPERTIES_TAB = "//div[text()='Properties' and @class='MiddleTab']";
	public static String ELEMENT_PERMISSION_SETTING_TAB= "//div[text()='Permission Settings' and @class='MiddleTab']";
	public static String ELEMENT_CHECKBOX_PUBLIC_MODE = "//input[@name='publicMode']";
	public static String ELEMENT_LINK_EDIT_PERMISSION = "//a[text()='Edit Permission Settings']";
	
	public static String ELEMENT_SELECT_ACCESS_MEMBERSHIP_ITEM = "//a[text()='${membership}']";
	public static String ELEMENT_SELECTED_ACCESS_PERM_GROUP = "//div[@id='PermissionGrid']/table/tbody//div[text()='/${groupId}']";
	public static String ELEMENT_SELECTED_ACCESS_PERM_MEMBERSHIP = "//div[@id='PermissionGrid']/table/tbody//div[text()='${membership}']";
	public static String ELEMENT_ADD_PERMISSION_BUTTON = "//a[text()='Add Permission']";
	public static String ELEMENT_SELECT_EDIT_MEMBERSHIP_ITEM = "//div[@id='UIPermissionSelector']//a[text()='${membership}']";
	public static String ELEMENT_SELECTED_EDIT_PERM_GROUP = "// div[@class='SelectedPermissionInfo']/div[2]/div[.='/${groupId}']";
	public static String ELEMENT_SELECTED_EDIT_PERM_MEMBERSHIP = "//div[@class='SelectedPermissionInfo']/div[3]/div[.='${membership}']";
	public static String ELEMENT_SELECT_PERMISSION_BUTTON = "//a[text()='Select Permission']";
	public static String ELEMENT_SELECT_ACCESS_GROUP_ITEM = "//a[@title='${group}']";
	public static String ELEMENT_SELECT_EDIT_GROUP_ITEM = "//div[@id='UIPermissionSelector']//a[text()='${group}']";
	public static String ELEMENT_SELECT_EDIT_PORTAL_CONFIG = "//div[@id='UISiteManagement']//table//tr/td/div[text()='${portalName}']/../../td[2]//a[@class='EditPortIcon']";
	

	
	
	/*------------- ---- End of Data for Portal ------------------------------*/
	
	
	
	/*------------- Data for Portal/Account -------------------------*/

	public static String ELEMENT_USER_PROFILE_TAB = "//div[text()='User Profile' and @class='MiddleTab']";
	public static String ELEMENT_SELECT_USER_LANGUAGE = "//select[@name='user.language']";
	public static String ELEMENT_SEARCH_ICON_REGISTER = "//img[@class='SearchIcon']";
	public static String ELEMENT_INPUT_USER_NAME_GIVEN = "//input[@id='user.name.given']";
	public static String ELEMENT_ACCOUNT_SETTING_TAB = "//div[text()='Account Settings' and @class='MiddleTab']";

	public static String ELEMENT_USER_DELETE_ICON ="//div[@id='UIListUsersGird']//div[text()='${username}']/../..//img[@class='DeleteUserIcon']";
	public static String ELEMENT_SEARCH_ICON_USERS_MANAGEMENT = "//form[@id='UISearchForm']/div[2]/a";
	public static String ELEMENT_LINK_USERS_MANAGEMENT="//a[contains(text(),'Group and Roles')]";
	public static String ELEMENT_INPUT_SEARCH_USER_NAME = "//input[@name='searchTerm']"; 
	public static String ELEMENT_EDIT_USER_INFO =  "//img[@title='Edit User Info']" ;      
	public static String ELEMENT_SELECT_SEARCH_OPTION = "//select[@name='searchOption']";
	public static String ELEMENT_USER_EDIT_ICON = "//div[@id='UIListUsersGird']/table//tr/td/div[text()='${username}']/../../td[5]//img[@class='ViewUserInfoIcon']";

	public static String ELEMENT_GROUP_ADD_NEW_ICON = "//div[@id='UIOrganizationPortlet']//div[@class='TitleBar']/a[@class='TreeActionIcon AddGroupIcon']";
	public static String ELEMENT_INPUT_GROUP_NAME = "//input[@name='groupName']";
	public static String ELEMENT_INPUT_LABEL = "//input[@id='label']";
	public static String ELEMENT_TEXTAREA_DESCRIPTION = "//textarea[@id='description']";
	public static String ELEMENT_GROUP_REMOVE_ICON = "//div[@id='UIOrganizationPortlet']//div[@class='TitleBar']/a[@class='TreeActionIcon RemoveGroupIcon']";
	public static String ELEMENT_GROUP_EDIT_ICON = "//div[@id='UIOrganizationPortlet']//div[@class='TitleBar']/a[@class='TreeActionIcon EditGroupIcon']";
	public static String ELEMENT_TAB_GROUP_MANAGEMENT = "//div[@class='GroupManagementIcon']/..";
	public static String ELEMENT_GROUP_TO_SELECT_LINK = "//a[contains(@class, 'NodeIcon') and @title='${group}']";
	public static String ELEMENT_GROUP_SELECTED = "//a[@class='NodeIcon PortalIcon NodeSelected' and @title='${group}']";
	public static String ELEMENT_GROUP_SEARCH_USER_ICON = "//form[@id='UIGroupMembershipForm']/div[2]/div/table/tbody/tr[1]/td[2]/a";
	public static String ELEMENT_GROUP_SEARCH_POPUP_ADD_ICON = "//form[@id='UIUserSelector']//div[@class='UIAction']//a[@class='ActionButton LightBlueStyle']";
	public static String ELEMENT_SELECT_MEMBERSHIP = "//select[@name='membership']";
	public static String ELEMENT_GROUP_USER_IN_TABLE = "//div[@class='UIUserInGroup']//div[@title='${username}']";
	public static String ELEMENT_INPUT_NAME = "//input[@id='name']";    
	public static String ELEMENT_TAB_MEMBERSHIP_MANAGEMENT = "//div[@class='MembershipManagementIcon']/..";
	public static String ELEMENT_MEMBERSHIP_EDIT_ICON = "//div[@class='UIListMembershipType']//table//tr/td/div[text()='${membership}']/../../td[5]//img[@class='EditMembershipIcon']";
	public static String ELEMENT_MEMBERSHIP_DELETE_ICON = "//div[@class='UIListMembershipType']//table//tr/td/div[text()='${membership}']/../../td[5]//img[@class='DeleteMembershipIcon']";
	public static String ELEMENT_NEXT_PAGE_ICON = "//a[@title='Next Page']";
	
	
	/*------------- End of Data for Portal/Account -------------------------*/

	public  void addNewUserAccount(String username, String password, String confirmPassword, String firstName, 
            String lastName, String email, String userNameGiven, String language, boolean verify) {
        
		System.out.println("--Create new user using \"New Staff\" portlet--");
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
	        System.out.println("--Go to Users and groups management--");
	        goToPage(ELEMENT_LINK_SetUp, ELEMENT_LINK_SetUp, ELEMENT_LINK_Users, ELEMENT_LINK_USERS_MANAGEMENT);
	    }
	
    public  void deleteUser(String username) {
			String userDeleteIcon = ELEMENT_USER_DELETE_ICON.replace("${username}", username);
			
			System.out.println("--Deleting user " + username + "--");
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
		System.out.println("--Search user " + user + "--");
		if (isTextPresent("Search")){
			type(ELEMENT_INPUT_SEARCH_USER_NAME, user, true);
			select(ELEMENT_SELECT_SEARCH_OPTION, searchOption);
		}	
		pause(3000);
		click(ELEMENT_SEARCH_ICON_USERS_MANAGEMENT);
		waitForTextPresent(user);
	}

	public  void editUser(String username) {
		String userEditIcon = ELEMENT_USER_EDIT_ICON.replace("${username}", username);
		
		System.out.println("--Editing user " + username + "--");
        pause(300);
		click(userEditIcon);
		pause(1000);
	}

	public  void chooseGroupTab() {
		System.out.println("-- Choose Group Management tab--");
        pause(500);
		click(ELEMENT_TAB_GROUP_MANAGEMENT);
		waitForTextPresent("Group Info");
	}
	
	public  void addGroup(String groupName, String groupLabel, String groupDesc, boolean verify){
		System.out.println("--Add a new group--");
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
	
	public  void selectGroup(String groupXpath) {
		System.out.println("--Select category (" + groupXpath + ")--");
		String groupID = "//a[@title='"+ groupXpath +"']"; 
		waitForAndGetElement("//a[@title='"+ groupXpath +"']");
		click(groupID);
	}
	
	public  void editGroup(String groupName, boolean verify){
		System.out.println("-- Edit group: " + groupName + "--");
		click(ELEMENT_GROUP_EDIT_ICON);
		pause(3000);
	}
	
	public  void deleteGroup(String groupName, boolean verify) {
		System.out.println("-- Delete group: " + groupName + "--");
		click(ELEMENT_GROUP_REMOVE_ICON);
		pause(3000);
		waitForConfirmation("Are you sure to delete this group?");
		if (verify) {
            waitForElementNotPresent(groupName);
        }
		pause(3000);
	}
	
	public  void addUsersToGroup(String userNames, String memberShip, boolean select, boolean verify) {

		System.out.println("--Adding users to group--");
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

	
	
	
}
