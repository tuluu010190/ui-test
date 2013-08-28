package org.exoplatform.selenium.platform.forum;

import  static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.PlatformPermission;
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
	
	Button but = new Button(driver);
	PlatformPermission per = new PlatformPermission(driver);
	
	//Set permission for category of answer
	public final String ELEMENT_RESTRICTED_CHECKBOX = "//*[contains(text(), '${user}')]/../../td[2]//input[@type='checkbox']";
	public final String ELEMENT_MODERATOR_CHECKBOX = "//*[contains(text(), '${user}')]/../../td[3]//input[@type='checkbox']";
	
	/*--------------------------common function-----------------------------------*/
	
	/**
	 * @author lientm
	 * @param type
	 * @param userGroup
	 */
	public void setPermissionWithOption(int type, String[] userGroup){
		per = new PlatformPermission(driver);
		click(per.ELEMENT_PERMISSION_TAB);
		switch (type){
		case 1:
			info("Set permission by type directly");
			type(per.ELEMENT_PERMISSION_INPUT, userGroup[0], true);
			break;
		case 2:	
			info("Set permission for user " + userGroup[0]);
			click(per.ELEMENT_SELECT_USER_ICON);
			if (userGroup.length > 1){
				per.selectUserPermission(userGroup[0], Integer.parseInt(userGroup[1]));
			}else {
				per.selectUserPermission(userGroup[0]);
			}
			break;
		case 3:	
			info("Set permission for group " + userGroup[0]);
			click(per.ELEMENT_SELECT_GROUP_ICON);
			per.selectGroupPermission(userGroup[0]);
			break;
		case 4:	
			info("Set permission with membership " + userGroup[1] + "/" + userGroup[0]);
			click(per.ELEMENT_SELECT_MEMBERSHIP_ICON);
			per.selectGroupMembership(userGroup[0], userGroup[1]);
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