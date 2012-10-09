package org.exoplatform.selenium.platform.ecms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.exoplatform.selenium.platform.ecms.ActionBar.*;
import static org.exoplatform.selenium.TestLogger.*;

public class SiteExplorer extends EcmsBase {
	//Show Drives link
	public static final By ELEMENT_SHOW_DRIVES = By.xpath("//a[@title='Show Drives']");

	//Driver Sites Management in Sites Explorer
	public static final By ELEMENT_DRIVER_SITES_MANAGEMENT = By.xpath("//a[@class='DriveLabel' and @title = 'Sites Management']");
	public static final By ELEMENT_DMS_ADMIN_DRIVER = By.linkText("DMS Administration");

	// Preference
	public static final By ELEMENT_PREFERENCE_LINK =By.xpath("//a[@class='SetupPreferencesButton']");

	// Edit Tag Form
	public static By ELEMENT_EDIT_PUBLIC_TAG = By.xpath("//div[@title='Edit Public Tags']");
	public static By ELEMENT_EDIT_PRIVATE_TAG = By.xpath("//div[@title='Edit Private Tags']");
	public static By ELEMENT_REMOVE_TAG = By.xpath("//img[@alt='RemoveTag']");
	public static By ELEMENT_CLOSE_EDIT_PUBLIC_TAG_FORM = By.xpath("//a[@title='Close Window']");
	public static String MESSAGE_WARNING_AFTER_DELETE_TAG = "Are you sure to delete this tag?";

	//Tag Manager Form
	public static By ELEMENT_ADD_TAGS_BUTTON = By.xpath("//a[contains(text(),'Add Tags')]");
	public static By ELEMENT_CLOSE_TAG_FORM = By.xpath("//a[contains(text(),'Close')]");
	public static By ELEMENT_TAG_NAME = By.id("names");
	public static By ELEMENT_TAG_SCOPE = By.id("tagScopes");

	//SideBar
	public static By ELEMENT_TAG_CLOUD = By.xpath("//div[3]/div[4]/div");
	public static By ELEMENT_FILE_EXPLORER = By.xpath("//div[@id='UISideBar']/div/div/div[3]/div/div");
	public static By ELEMENT_SAVED_SEARCH_ICON = By.xpath("//div[@title='Saved Searches']");

	//Advanced search form
	public static By ELEMENT_ADVANCED_SEARCH_ICON = By.xpath("//div[@title='Advanced Search']");
	public static By ELEMENT_ADVANCED_SEARCH_TAB = By.xpath("//div[contains(text(),'Advanced Search')]");

	//		public static boolean SELECT = true; 


	//choose a drive
	public static void chooseDrive(By locator)
	{
		waitForAndGetElement(ELEMENT_SHOW_DRIVES).click();
		waitForAndGetElement(locator).click();	
	}

	//Enable preferenes option
	public static void checkPreferenceOption(String optionId){
		goToNode(ELEMENT_PREFERENCE_LINK);
		click(By.linkText("Advanced"));
		pause(500);
		WebElement check = waitForAndGetElement(By.id(optionId));
		if (check.isSelected()!= true){
			check.click();
		}
		click(By.linkText("Save"));
	}

	//simple search
	public static boolean simpleSearch(String keyword){
		boolean delete = true;
		//		waitForAndGetElement(ELEMENT_SIMPLESEARCH_TEXTBOX).clear();
		type(ELEMENT_SIMPLESEARCH_TEXTBOX, keyword, true);
		click(ELEMENT_SIMPLESEARCH_SUBMIT);
		if (isElementPresent(By.xpath("//div[contains(text(),'"+keyword+"')]")))
		{
			return delete;}
		else {
			delete = false;
			return delete;}
	}

	//simple search not return result
	public static boolean notSimpleSearch(String keyword) {
		return !simpleSearch(keyword);
	}

	public static void addTagForNode(String name, boolean isPublic) {
		// go to collaboration tab
		info("Go to Collaboration tab");
		goToCollaboration();

		// Click Tags
		waitForElementPresent(ELEMENT_TAG);
		click(ELEMENT_TAG);

		// Input information
		type(ELEMENT_TAG_NAME, name, true);

		//save
		if (isPublic){
			selectOption(ELEMENT_TAG_SCOPE, "Public");
		} else 
			selectOption(ELEMENT_TAG_SCOPE, "Private");
		click(ELEMENT_ADD_TAGS_BUTTON);

		//verify new tag
		waitForElementPresent(By.linkText(name));

		//close tag form
		click(ELEMENT_CLOSE_TAG_FORM);

		//verify add new tag
		click(ELEMENT_TAG_CLOUD);

		//			waitForTextPresent("Private Tags");
		waitForTextPresent(name);
	}

	public static void deleteTag(String name, boolean isPublic){
		// Delete tags
		if (isPublic){
			waitForElementPresent(ELEMENT_EDIT_PUBLIC_TAG);
			click(ELEMENT_EDIT_PUBLIC_TAG);
		}
		else {
			waitForElementPresent(ELEMENT_EDIT_PRIVATE_TAG);
			click(ELEMENT_EDIT_PRIVATE_TAG);
		}
		waitForElementPresent(ELEMENT_REMOVE_TAG);
		click(ELEMENT_REMOVE_TAG);
		waitForConfirmation(MESSAGE_WARNING_AFTER_DELETE_TAG);
		click(ELEMENT_CLOSE_EDIT_PUBLIC_TAG_FORM);
		waitForTextNotPresent(name);
	}

	//go to advanced search in content explorer
	public static void goToAdvancedSearch(){
		click(ELEMENT_SAVED_SEARCH_ICON);
		click(ELEMENT_ADVANCED_SEARCH_ICON);
		click(ELEMENT_ADVANCED_SEARCH_TAB);
	}
}
