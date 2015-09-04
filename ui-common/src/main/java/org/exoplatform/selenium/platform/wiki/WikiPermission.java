package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiPermission extends WikiLocators{
	
	Dialog dialog;
	Button button;
	
	/**
	 * constructor
	 * @param dr
	 */
	public WikiPermission(WebDriver dr){
		this.driver=dr;
		button = new Button(dr);
		dialog = new Dialog(dr);
	}
	/**
	 * Define permission Types
	 * as Users, Membership or Groups
	 */
	public enum userGroupTypes{
		Users,Membership,Groups;
	}
	/**
	 * Define mode to input permission
	 * as type or select
	 */
	public enum modeInput{
		Type,Select;
	}
	
	/**
	 * Delete a group, users in permission popup
	 * @param group
	 */
	public void deletePermission(String groupUsers){
		By bDelete = By.xpath(ELEMENT_DELETE_PERMISSION.replace("$user",groupUsers));
		if (waitForAndGetElement(bDelete, 10000, 0) != null){
			info("--Delete permission--");
			click(bDelete);
			waitForElementNotPresent(bDelete);
		}
		Utils.pause(1000);
	}
	/**
	 *Define permission types 
	 *as View page or Edit page
	 */
	public enum permissionType{
		View_Pages,Edit_Pages;
	}
	
	/**
	 * Select permission for a username/group/membership
	 * @param userGroup
	 * @param type
	 */
	public void selectPermission(String userGroup,permissionType type){
		switch(type){
		case View_Pages:
			info("Select View pages permission");
			check(ELEMENT_PERMISSION_VIEW_CHECKBOX
					.replace("$userGroup",userGroup),2);
			break;
		case Edit_Pages:
			info("Select View pages permission");
			check(ELEMENT_PERMISSION_EDIT_CHECKBOX
					.replace("$userGroup",userGroup),2);
			break;
		}
	}
	/**
	 * Unselect permission for a username/group/membership
	 * @param userGroup
	 * @param type
	 */
	public void unSelectPermission(String userGroup,permissionType type){
		switch(type){
		case View_Pages:
			info("Select View pages permission");
			uncheck(ELEMENT_PERMISSION_VIEW_CHECKBOX
					.replace("$userGroup",userGroup),2);
			break;
		case Edit_Pages:
			info("Select View pages permission");
			uncheck(ELEMENT_PERMISSION_EDIT_CHECKBOX
					.replace("$userGroup",userGroup),2);
			break;
		}
	}
	/**
	 * Add a group/user/membership to permission table by type
	 * @param groupUsers
	 */
	public void addPermisisonByType(String groupUsers){
		if(!groupUsers.isEmpty()){
			info("Type a:"+groupUsers+" to the textbox");
			type(ELEMENT_PERMISSION_TYPE_INPUT,groupUsers,true);
			info("Click on Add button");
			click(ELEMENT_PERMISSION_ADD_BUTTON);
			waitForAndGetElement(ELEMENT_DELETE_PERMISSION.replace("$user",groupUsers));
			info("The group/user/membership is added successfully");
		}
	}
	/**
	 * Open User list
	 */
	public void goToSelectUser(){
		info("Click on select user button");
		click(ELEMENT_PERMISSION_SELECT_USER);
		Utils.pause(1000);
	}
	/**
	 * Open Membership list
	 */
	public void goToSelectMemberShip(){
		info("Click on select membership button");
		click(ELEMENT_PERMISSION_SELECT_MEMBERSHIP);
		Utils.pause(1000);
	}
	/**
	 * Open Group list
	 */
	public void goToGroup(){
		info("Click on select membership button");
		click(ELEMENT_PERMISSION_SELECT_GROUP);
		Utils.pause(1000);
	}
	
	/**
	 * Add permission for a user/group/membership by selecting
	 * @param groupUsers
	 * @param membership
	 * @param type
	 * @param op
	 */
	public void addPermissionBySelect(String groupUsers,String membership,
			userGroupTypes type){
		switch(type){
		case Users:
			goToSelectUser();
			selectUser(groupUsers,filterOption.userName);
			break;
		case Membership:
			goToSelectMemberShip();
			selectMembership(groupUsers, membership);
			break;
		case Groups:
			goToGroup();
			selectGroup(groupUsers);
			break;
	    }
		info("Click on Add button");
		click(ELEMENT_PERMISSION_ADD_BUTTON);
		waitForAndGetElement(ELEMENT_DELETE_PERMISSION.replace("$user",groupUsers));
		info("The group/user/membership is added successfully");
	}
	/**
	 * Click on Save button
	 */
	public void savePermisison(){
		info("Click on Save button");
		click(ELEMENT_PERMISSION_BUTTON_SAVE);
		waitForElementNotPresent(ELEMENT_PERMISSION_BUTTON_SAVE);
	}
	
}
