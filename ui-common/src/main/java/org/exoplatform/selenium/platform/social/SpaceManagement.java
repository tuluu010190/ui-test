/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.UserGroupManagement.selectGroup;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by The eXo Platform SAS Author : Hoang Manh Dung
 * dunghm@exoplatform.com Nov 7, 2012
 */
public class SpaceManagement extends SocialBase {
	//Go to My Spaces	> 
	//Add space Form
	protected static int DEFAULT_TIMEOUT = 60000;
	public static final By     ELEMENT_ADDNEWSPACE_BUTTON      = By.xpath("//a[@class='AddSpaceIcon']");

	public static final By     ELEMENT_ADDNEWSPACE_FORM        = By.xpath("//span[@class='PopupTitle' and text()='Add New Space']");

	public static final By     ELEMENT_SPACE_NAME_INPUT        = By.xpath("//input[contains(@name,'displayName')]");

	public static final By     ELEMENT_SPACE_DESCRIPTION_INPUT = By.xpath("//textarea[contains(@name,'description')]");

	public static final By     ELEMENT_ACCESS_TAB              = By.xpath("//div[contains(@class,'MiddleTab') and text()='Access & Edit']");

	public static final By     ELEMENT_USER_GROUP_TAB          = By.xpath("//div[contains(@class,'MiddleTab') and text()='Invite users from group']");

	public static final By     ELEMENT_USER_GROUP_CHECKBOX     = By.xpath("//*[@id='useExistingGroup']");

	//Edit space
	public static final By     ELEMENT_SPACE_SETTING_TAB       = By.xpath("//div[contains(@class,'MiddleTab') and text()='Settings']");

	public static final By     ELEMENT_CHANGE_AVATAR_ICON      = By.xpath("//a[contains(@class,'ChangeAva')]");  

	public static final String MESSAGE_DELETE_SPACE            = "Are you sure to delete this space? This can not be undone. All page navigations and this group will be deleted, too.";

	/**
	 * Click on a button with a specific label
	 * 
	 * @param label : Button label
	 */
	public static void clickButton(String label) {
		By button = By.xpath("//*[contains(@class,'ActionButton') and text()='" + label + "']");
		waitForElementPresent(button);
		click(button);
	}

	/**
	 * Switch to a tab
	 * 
	 * @param label : Tab label
	 */
	public static void switchTabs(By tab) {
		waitForElementPresent(tab);
		click(tab);
	}
	/**
	 * Do a action on space such as Edit, delete, ...
	 * 
	 * @param action : Action name 
	 * @param spaceName : Space name
	 */
	public static void doAction(String action, String spaceName){
		By actionLink = By.xpath("//a[text()='" + spaceName + "']/ancestor::div[contains(@class,'ContentBox')]//a[text()='" + action + "']");
		click(actionLink);
	}

	/**
	 * Create quickly a new space
	 * 
	 * @param name : Space name
	 * @param desc : Space description
	 * 
	 */
	public static void addNewSpace(String name, String desc, int... params) {
		int iTimeout = params.length > 0 ? params[0] : DEFAULT_TIMEOUT; 

		click(ELEMENT_ADDNEWSPACE_BUTTON);
		waitForElementPresent(ELEMENT_ADDNEWSPACE_FORM);
		type(ELEMENT_SPACE_NAME_INPUT, name, true);
		type(ELEMENT_SPACE_DESCRIPTION_INPUT, desc, true);
		clickButton("Create");

		waitForElementPresent(By.xpath("//div[contains(@class,'UISpaceName')]/a[@title='" + name + "']"),iTimeout);
	}

	/**
	 * Update by @author vuna2
	 * -- @param visibility
	 * -- @param registration
	 */
	/**
	 * Create a new space
	 * 
	 * @param name : Space name
	 * @param desc : Space description
	 * @param visibility : Space visibility
	 * @param registration : Space registration
	 * @param groupPath : User Group
	 * @param childGroupName : The child group to invite users
	 */
	public static void addNewSpace(String name, String desc, String visibility, String registration, String groupPath, String childGroupName, int... params){
		info("-- Adding a new space --");
		int iTimeout = params.length > 0 ? params[0] : DEFAULT_TIMEOUT;
		//String v = visibility.isEmpty() ? "private" : visibility;
		String value1 = "private";
		String value2 = "hidden";
		//String r = registration.isEmpty() ? "validation" : registration;
		String[] regis = {"open", "validation", "close"};

		click(ELEMENT_ADDNEWSPACE_BUTTON);
		waitForElementPresent(ELEMENT_ADDNEWSPACE_FORM);
		type(ELEMENT_SPACE_NAME_INPUT, name, true);
		type(ELEMENT_SPACE_DESCRIPTION_INPUT, desc, true);
		switchTabs(ELEMENT_ACCESS_TAB);
		
		if (visibility != "") {
			if (visibility.equals("Visible")){
				WebElement rdoVisibility = waitForAndGetElement(By.id("UIVisibility_" + value1));
				if (!rdoVisibility.isSelected())
					actions.click(rdoVisibility).perform();
			}else if (visibility.equals("Hidden")){
				WebElement rdoVisibility = waitForAndGetElement(By.id("UIVisibility_" + value2));
				if (!rdoVisibility.isSelected())
					actions.click(rdoVisibility).perform();
			}	
		}
		
		if (registration != "") {
			if (registration.equals("Open")){
				WebElement rdoRegistration = waitForAndGetElement(By.id("UIRegistration_" + regis[0]));
				if (!rdoRegistration.isSelected())
					actions.click(rdoRegistration).perform();
			}else if (registration.equals("Validation")){
				WebElement rdoRegistration = waitForAndGetElement(By.id("UIRegistration_" + regis[1]));
				if (!rdoRegistration.isSelected())
					actions.click(rdoRegistration).perform();		
			}else if (registration.equals("Close")){
				WebElement rdoRegistration = waitForAndGetElement(By.id("UIRegistration_" + regis[2]));
				if (!rdoRegistration.isSelected())
					actions.click(rdoRegistration).perform();		
			}
		}

		switchTabs(ELEMENT_USER_GROUP_TAB);

		if (groupPath != "" && childGroupName != "") {
			addUserGroupToInvite(groupPath, childGroupName);
		}

		clickButton("Create");

		waitForElementPresent(By.xpath("//div[contains(@class,'UISpaceName')]/a[@title='" + name + "']"), iTimeout);
	}

	/**
	 * Add target group for a space when create new space
	 * 
	 * @param groupPath : Group path separate by a slash
	 * @param childGroupName : The child group to invite users
	 */
	public static void addUserGroupToInvite(String groupPath, String childGroupName) {
		click(ELEMENT_USER_GROUP_CHECKBOX);
		selectGroup(groupPath);
		click(By.linkText(childGroupName));
	}

	/**
	 * Delete a space
	 * 
	 * @param name : Space name
	 */
	public static void deleteSpace(String name, int... params){
		int iTimeout = params.length > 0 ? params[0] : DEFAULT_TIMEOUT;    
		doAction("Delete", name);    
		waitForConfirmation(MESSAGE_DELETE_SPACE);
		waitForElementNotPresent(By.xpath("//a[text()='" + name
				+ "']/ancestor::div[contains(@class,'ContentBox')]"),
				iTimeout);
		info(name + " was deleted successfully");
	}

	/**
	 * Update by @author vuna2
	 * add a @param uploadAvatar: boolean
	 */
	/**
	 * Edit a space
	 * @param name : Space name
	 * @param newName : New space name
	 * @param newDescription : New space description
	 * @param avatar : avatar file path
	 */
	public static void editSpace(String name,String newName, String newDescription, boolean uploadAvatar, String avatar){
		gotoEditSpace(name);
		type(ELEMENT_SPACE_NAME_INPUT, newName, true);
		type(ELEMENT_SPACE_DESCRIPTION_INPUT, newDescription, true);
		if (uploadAvatar){
			changeAvatar(avatar);
		}else{
			info("-- Edit a space without changing the user's avatar --");
		}
		save();
		if(name == newName){
			waitForTextPresent("Update info of space successful.");
			closeMessageDialog();
		}else{
			waitForElementPresent(By.xpath("//div[contains(@class,'UISpaceName')]/a[@title='" + newName + "']"));
		}
	}
	/**
	 * Go to edit form of a space
	 * @param name : Space name
	 */
	public static void gotoEditSpace(String name){    
		doAction("Edit", name);
		waitForElementPresent(ELEMENT_SPACE_SETTING_TAB);    
	}
	/**
	 * Change avatar of a space
	 * @param file : File path of new avatar
	 */
	public static void changeAvatar(String file){
		if(!file.contains("ui-testsuite")) file = getAbsoluteFilePath(file); 
		click(ELEMENT_CHANGE_AVATAR_ICON);
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_IMG_FRAME_XPATH));
		waitForElementPresent(ELEMENT_UPLOAD_IMG_ID);
		type(ELEMENT_UPLOAD_IMG_ID, file, false);
		pause(500);
		switchToParentWindow();
		clickButton("Confirm");    
		click(By.xpath("//*[@id='UIAvatarUploadContent']//a[contains(text(),'Save')]"));
		waitForTextNotPresent("Upload an Image");
	}
	
	/**
	 * Restore original data by deleting a space
	 * @author vuna2
	 * @param spaceName
	 * @param params: time for deleting a space (int)
	 */
	public static void restoreData(String spaceName, int... params){
		info("-- Restore Original Data --");
		int timeToDeleteSpace = params.length > 0 ? params[0] : DEFAULT_TIMEOUT;;
		goToMySpacePage();
		deleteSpace(spaceName, timeToDeleteSpace);
		pause(500);
	}

}
