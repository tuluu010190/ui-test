package org.exoplatform.selenium.platform.forum;

import  static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.UserGroupManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 20 Aug 2013
 */
public class ForumPermission extends ForumBase {
	
	public ForumPermission(WebDriver dr){
		driver = dr;
	}
	
	UserGroupManagement userGroup;
	Button but = new Button(driver);
	
	//set permission screen
	public final String ELEMENT_USER_CHECKBOX = "//*[text()='${user}']/../..//*[@type='checkbox']"; 
	public final By ELEMENT_SELECT_THIS_GROUP = By.linkText("Select this Group");
	public final By ELEMENT_SEARCH_ICON = By.xpath("//a[@title='Quick Search']");
	public final By ELEMENT_SEARCH_USER_INPUT = By.id("QuickSearch");
	public final By ELEMENT_QUICK_SEARCH_BUTTON = By.xpath("//a[@title='Quick Search']");
	public final By ELEMENT_SELECT_SEARCH = By.id("filter");
	public final By ELEMENT_PERMISSION_TAB = By.linkText("Permissions");
	public final By ELEMENT_PERMISSION_INPUT = By.id("UIPermissionInput");
	public final By ELEMENT_SELECT_USER_ICON = By.xpath("//*[@class='uiIconUser uiIconLightGray']");
	public final By ELEMENT_SELECT_MEMBERSHIP_ICON = By.xpath("//*[@class='uiIconMembership uiIconLightGray']");
	public final By ELEMENT_SELECT_GROUP_ICON = By.xpath("//*[@class='uiIconGroup uiIconLightGray']");
	public final By ELEMENT_ADD_USERS_BUTTON = By.xpath("//*[@id='UIUserSelector']//*[text()='Add']");
	
	//Set permission for category of answer
	public final String ELEMENT_RESTRICTED_CHECKBOX = "//*[contains(text(), '${user}')]/../../td[2]//input[@type='checkbox']";
	public final String ELEMENT_MODERATOR_CHECKBOX = "//*[contains(text(), '${user}')]/../../td[3]//input[@type='checkbox']";
	
	/*--------------------------common function-----------------------------------*/
	

	/**function: select a user when set permission for a element
	 * @author lientm
	 * @param element: id of element need set permission
	 * @param user: user that needs to set permission
	 */
	public void selectUserPermission(String user, int...type){	
		String[] temp = user.split("/");
		if (temp.length > 0){
			for (int i = 0; i < temp.length; i ++){
				By ELEMENT_USER = By.xpath(ELEMENT_USER_CHECKBOX.replace("${user}", temp[i]));
				By ELEMENT_FIRST = By.xpath("//*[@id='UIListUsers']/tbody/tr[2]/td/*[text()='" + temp[i] + "']");
				By ELEMENT_SECOND = By.xpath("//*[@id='UIListUsers']/tbody/tr[3]");
				if (type.length > i){
					type(ELEMENT_SEARCH_USER_INPUT, temp[i], true);
					switch (type[i]){
					case 1:
						select(ELEMENT_SELECT_SEARCH, "Username");
						break;
					case 2:	
						select(ELEMENT_SELECT_SEARCH, "First Name");
						break;
					case 3:	
						select(ELEMENT_SELECT_SEARCH, "Last Name");
						break;
					case 4:	
						select(ELEMENT_SELECT_SEARCH, "Email Name");
						break;
					default:
						break;
					}
					click(ELEMENT_QUICK_SEARCH_BUTTON);
					waitForAndGetElement(ELEMENT_FIRST);
					waitForElementNotPresent(ELEMENT_SECOND);
				}
				check(ELEMENT_USER, 2);
			}
		}
		waitForElementNotPresent(ELEMENT_SEARCH_ICON);
		click(ELEMENT_ADD_USERS_BUTTON);
	}

	/**function: select a group when set permission
	 * @author lientm
	 * @param element: id of element need set permission
	 * @param grouppath: group path
	 */
	public void selectGroupPermission(String grouppath){
		userGroup = new UserGroupManagement(driver);
		userGroup.selectGroup(grouppath);
		click(ELEMENT_SELECT_THIS_GROUP);
	}

	/**function: select group and membership when set permission
	 * @author lientm
	 * @param element: id of element need set permission
	 * @param groupPath: path to group
	 * @param membership
	 */
	public void selectGroupMembership(String groupPath, String membership){
		userGroup = new UserGroupManagement(driver);
		userGroup.selectGroup(groupPath);	
		click(By.linkText(membership));
		waitForTextPresent(membership);
	}
	
	/**
	 * @author lientm
	 * @param type
	 * @param userGroup
	 */
	public void setPermissionWithOption(int type, String[] userGroup){
		click(ELEMENT_PERMISSION_TAB);
		switch (type){
		case 1:
			info("Set permission by type directly");
			type(ELEMENT_PERMISSION_INPUT, userGroup[0], true);
			break;
		case 2:	
			info("Set permission for user " + userGroup[0]);
			click(ELEMENT_SELECT_USER_ICON);
			if (userGroup.length > 1){
				selectUserPermission(userGroup[0], Integer.parseInt(userGroup[1]));
			}else {
				selectUserPermission(userGroup[0]);
			}
			break;
		case 3:	
			info("Set permission for group " + userGroup[0]);
			click(ELEMENT_SELECT_GROUP_ICON);
			selectGroupPermission(userGroup[0]);
			break;
		case 4:	
			info("Set permission with membership " + userGroup[1] + "/" + userGroup[0]);
			click(ELEMENT_SELECT_MEMBERSHIP_ICON);
			selectGroupMembership(userGroup[0], userGroup[1]);
			break;
		default:
			break;
		}
	}
	
	/**
	 * @author lientm
	 * @param type
	 * @param userGroup
	 * @param restricted
	 * @param moderator
	 */
	public void configPermission4AnswerCategory(int type, String[] userGroup, boolean restricted, boolean moderator){
		setPermissionWithOption(type, userGroup);
		click(but.ELEMENT_ADD_BUTTON);
		String check = userGroup[0];
		if (userGroup.length > 2){
			check = userGroup[2];
		}
		if (restricted){
			check(ELEMENT_RESTRICTED_CHECKBOX.replace("${user}", check), 2);
		}else {
			uncheck(ELEMENT_RESTRICTED_CHECKBOX.replace("${user}", check), 2);
		}
		if (moderator){
			check(ELEMENT_MODERATOR_CHECKBOX.replace("${user}", check), 2);
		} else {
			uncheck(ELEMENT_MODERATOR_CHECKBOX.replace("${user}", check), 2);
		}
	}
}