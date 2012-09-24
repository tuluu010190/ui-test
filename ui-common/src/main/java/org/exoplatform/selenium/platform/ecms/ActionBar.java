package org.exoplatform.selenium.platform.ecms;

import org.openqa.selenium.By;
import org.testng.Assert;
import static org.exoplatform.selenium.TestLogger.*;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.ELEMENT_EDIT_NODE_CHECKBOX;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.ELEMENT_REMOVE_NODE_CHECKBOX;

public class ActionBar extends EcmsBase {
	public static final By ELEMENT_TEXT_TEMPLATE_LIST = By.xpath("//div[contains(text(),'Select your template in the list below')]");
	public static final By ELEMENT_ADD_SYMLINK = By.linkText("Add Symlink");
	public static final By ELEMENT_ADD_SYMLINK_POPUP = By.id("UIPopupWindow");
	public static final By ELEMENT_SYMLINK_NAME = By.id("symLinkName");
	public static final By ELEMENT_ADD_ITEM	 = By.xpath("//img[@title='Add Item']");
	public static final By ELEMENT_LINK_EDIT= By.xpath("//a[@title='Edit']");
	
	// add a category
	public static void addCategory(String name)
	{
		click(ELEMENT_BUTTON_ADD_CATE);
		waitForElementPresent(ELEMENT_ADD_CATE_POP);
		type(ELEMENT_INPUT_CATE_NAME, name, false);
		click(ELEMENT_BUTTON_SAVE);
		waitForElementPresent(By.xpath("//a[@title='"+ name+ " ']"));
	}

	//System tab
	public static void setPermissionAddNodeForUser(String user,int permission,int delete){
		click(ELEMENT_SYSTEM_LINK);
		click(ELEMENT_PERMISSION_TAB);
		click(ELEMENT_SELECT_USER);
		if (delete ==1){
			click(ELEMENT_DELETE_PERMISSION);
			acceptAlert();
		}
		type(ELEMENT_SEARCH_TEXTBOX,user, false);
		click(ELEMENT_SEARCH_LINK);
		pause(500);
		click(ELEMENT_SEARCH_CHOOSE);
		pause(500);
		if (waitForAndGetElement(ELEMENT_READ_CHECKBOX).isSelected()==false){
			click(ELEMENT_READ_CHECKBOX);
		}
		if (permission==1){
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}else{
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
	}
	
	//go to new content
	public static void goToAddNewContent(){
		for (int repeat = 0;; repeat++)	{	
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform the action after " + ACTION_REPEAT + "tries");
			}
			mouseOver(ELEMENT_MENU_NEW_CONTENT_LINK, true);
			click(ELEMENT_MENU_NEW_CONTENT_LINK);
			
			if (waitForElementNotPresent(ELEMENT_MENU_NEW_CONTENT_LINK,30000,0) == null) return;
			pause(WAIT_INTERVAL);
			info("retry...[" + repeat + "]");
		}
	}
	
	
	public static void goToEditDocument(String title)
	{	
		for(int second=0;;second++)
		{
			if (second >= DEFAULT_TIMEOUT/WAIT_INTERVAL) {
				Assert.fail("Timeout at go to the edit page: " + title );
			}
			click(ELEMENT_LINK_EDIT);
			waitForElementPresent(ELEMENT_SAVE_CLOSE_BUTTON,50000);
			if (waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON,50000).isDisplayed()) break;
		}
	}
	//add symlink for node with target node = documents
	public static void addSymlink(By path, String name){
		click(ELEMENT_ADD_SYMLINK);
		waitForElementPresent(ELEMENT_ADD_SYMLINK_POPUP);
		click(ELEMENT_ADD_ITEM);
		if (path!=null){
			click(path);
		}
		if (name!="Documents.lnk" ){
			type(ELEMENT_SYMLINK_NAME,name,true);
		}
		assert getValue(ELEMENT_SYMLINK_NAME).contentEquals(name):"Symlink name is not true";
		click(ELEMENT_SAVE_BUTTON); 
	}
	
	public static void setPermissionForDocument(String user, boolean add, boolean edit, boolean remove, boolean reset)
	{
		click(ELEMENT_SYSTEM_LINK);
		click(ELEMENT_PERMISSION_TAB);
		if (reset)
		{
			click(ELEMENT_DELETE_PERMISSION);
			acceptAlert();
		}
		click(ELEMENT_SELECT_USER);
		waitForElementPresent(ELEMENT_SEARCH_TEXTBOX);
		type(ELEMENT_SEARCH_TEXTBOX,user, false);
		click(ELEMENT_SEARCH_LINK);
		click(ELEMENT_SEARCH_CHOOSE);
		if (waitForAndGetElement(ELEMENT_READ_CHECKBOX).isSelected()==false){
			click(ELEMENT_READ_CHECKBOX);
		}
		if (add)
		{
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}
		else
		{
			if (waitForAndGetElement(ELEMENT_ADD_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_ADD_NODE_CHECKBOX);
			}
		}
		if (edit)
		{
			if (waitForAndGetElement(ELEMENT_EDIT_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_EDIT_NODE_CHECKBOX);
			}
		}
		else
		{
			if (waitForAndGetElement(ELEMENT_EDIT_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_EDIT_NODE_CHECKBOX);
			}
		}
		if (remove)
		{
			if (waitForAndGetElement(ELEMENT_REMOVE_NODE_CHECKBOX).isSelected()==false){
				click(ELEMENT_REMOVE_NODE_CHECKBOX);
			}
		}
		else
		{
			if (waitForAndGetElement(ELEMENT_REMOVE_NODE_CHECKBOX).isSelected()==true){
				click(ELEMENT_REMOVE_NODE_CHECKBOX);
			}
		}
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}
	
}
