package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ManageApplications extends PlatformBase {

	//Gadget
	public static By ELEMENT_GADGET_LINK = By.xpath("//a[contains(text(),'Gadgets')]");
	public static By ELEMENT_ADD_REMOTE_GADGET_LINK = By.xpath("//div[text()='Add a Remote Gadget']");
	public static By ELEMENT_URL_TEXBOX = By.id("url");
	public static By ELEMENT_ADD_BUTTON = By.linkText("Add");

	//category
	public static final By ELEMENT_ADD_NEW_CATEGORY = By.xpath("//div[@id = 'UIApplicationOrganizer']//div//div[@class = 'IconControl AddCategoryIcon']");
	public static final By ELEMENT_FIELD_CATEGORY_NAME = By.id("name");
	public static final By ELEMENT_FIELD_DISPLAY_NAME = By.id("displayName");
	public static final By ELEMENT_FIELD_DESCRIPTION = By.id("description");
	public static final By ELEMENT_CATEGORY_REMOVE_ICON = By.xpath("//div[@id='UIApplicationOrganizer']//div[@class='TabRepeat ClearFix']/a[@class='ControlIcon DeleteIcon']");
	public static final By ELEMENT_CATEGORY_EDIT_ICON = By.xpath("//div[@id='UIApplicationOrganizer']//div[@class='TabRepeat ClearFix']/a[@class='ControlIcon EditIcon']");
	public static final String MESSAGE_EMPTY_CATEGORY = "This category is empty. Click the (+) button to add an application.";
	public static final String MESSAGE_CONFIRM_DELETE_CATEGORY = "Are you sure to delete this category and all its applications?";
	public static final String ELEMENT_CATEGORY_NAME = "//a[@title='${categoryName}']";


	
	// Gadget functions
	public static void addRemoteGadget (String Url) {
		for (int i =0;; i++)
		{
			if (i > DEFAULT_TIMEOUT/WAIT_INTERVAL) 
			{
				Assert.fail("Timeout");
			}
			click(ELEMENT_ADD_REMOTE_GADGET_LINK);
			if (isElementPresent(ELEMENT_URL_TEXBOX))
			{
				type(ELEMENT_URL_TEXBOX, Url, true);
				click(ELEMENT_ADD_BUTTON);
				return;
			}
		}
	}
	
	public static void deleteGadget (String gadgetName) {
		waitForElementPresent(By.xpath("//a[@title='"+gadgetName+"']"));
		click(By.xpath("//a[@title='"+gadgetName+"']/following::a[@title='Delete Gadget']"));
		waitForConfirmation("Are you sure to delete this gadget?");
		pause(1000);
		waitForElementNotPresent(By.xpath("//a[@title='"+gadgetName+"']"));
		info("'"+gadgetName+"' was deleted successfully");

	}

	//Category
	//Add a new category at Manage Applications
	public static void addNewCategoryAtManageApplications(String categoryName, String displayName, String categoryDescription,
			boolean publicMode, Map<String, String> permissions, boolean verify){

		info("-- Add a new category --");
		String ELEMENT_CURRENT_CATEGORY_NAME = ELEMENT_CATEGORY_NAME.replace("${categoryName}", categoryName);
		click(ELEMENT_ADD_NEW_CATEGORY);
		waitForTextPresent("Category Name:");
		type(ELEMENT_FIELD_CATEGORY_NAME, categoryName, true);
		type(ELEMENT_FIELD_DISPLAY_NAME, displayName, true);
		type(ELEMENT_TEXTAREA_DESCRIPTION, categoryDescription, true);
		click(ELEMENT_PERMISSION_SETTING_TAB);
		waitForTextPresent("Permission Settings");
		if (publicMode){
			check(ELEMENT_CHECKBOX_PUBLIC_MODE);
			waitForElementNotPresent(ELEMENT_ADD_PERMISSION_BUTTON);
		} else {
			for (String key : permissions.keySet()) {
				setViewPermissions(key, permissions.get(key));
			}
		}
		save();	
		if (verify) {
			waitForTextPresent(MESSAGE_EMPTY_CATEGORY);
			waitForAndGetElement(ELEMENT_CURRENT_CATEGORY_NAME);
		}
	}

	//Edit a category at Manage Applications
	public static void editCategoryAtManageApplications(String categoryName, String newDisplayName, String newCategoryDescription,
			boolean publicMode, Map<String, String> permissions, boolean verify){

		info("--Edit category (" + categoryName + ")--");
		String ELEMENT_EDIT_CATEGORY_NAME = ELEMENT_CATEGORY_NAME.replace("${categoryName}", newDisplayName);
		click(ELEMENT_CATEGORY_EDIT_ICON);
		type(ELEMENT_FIELD_DISPLAY_NAME, newDisplayName, true);
		type(ELEMENT_TEXTAREA_DESCRIPTION, newCategoryDescription, true);
		click(ELEMENT_PERMISSION_SETTING_TAB);
		waitForTextPresent("Permission Settings");
		if (publicMode){
			check(ELEMENT_CHECKBOX_PUBLIC_MODE);
			waitForElementNotPresent(ELEMENT_ADD_PERMISSION_BUTTON);
		} else {
			for (String key : permissions.keySet()) {
				setViewPermissions(key, permissions.get(key));
			}
		}
		save();
		if (verify) {
			waitForTextPresent(MESSAGE_EMPTY_CATEGORY);
			waitForAndGetElement(ELEMENT_EDIT_CATEGORY_NAME);
		}
	}

	//Delete a category at ManageApplications
	public static void deleteCategoryAtManageApplications(String categoryName, boolean verify){
		info("--Delete category (" + categoryName + ")--");
		String ELEMENT_CURRENT_CATEGORY_NAME = ELEMENT_CATEGORY_NAME.replace("${categoryName}", categoryName);
		click(ELEMENT_CATEGORY_REMOVE_ICON);
		waitForConfirmation(MESSAGE_CONFIRM_DELETE_CATEGORY);
		if (verify) {
			waitForElementNotPresent(ELEMENT_CURRENT_CATEGORY_NAME);
		}
		pause(500);
	}
}
