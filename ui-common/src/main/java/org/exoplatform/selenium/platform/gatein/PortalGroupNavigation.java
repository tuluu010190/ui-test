package org.exoplatform.selenium.platform.gatein;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import java.util.Map;

import junit.framework.Assert;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortalGroupNavigation extends PlatformBase {

	public final String ELEMENT_ADD_NAVIGATION_BUTTON = "//*[@class='btn' and contains(text(),'Add Navigation')]";
	public final String ELEMENT_GROUP_SELECT_ADD_NAVIGATION = "//*[contains(text(),'${groupName}')]/..//a[contains(text(),'Add Navigation')]";
	public final By ELEMENT_CANCEL_BUTON = By.linkText("Cancel");
	public final String ELEMENT_GROUP_NAME = ".//*[@id='UIGroupNavigationGrid']//*[contains(text(),'${groupName}')]";
	public final String ELEMENT_DELETE_NAVIGATION_ICON = "//*[contains(text(),'${groupName}')]/../..//i[@class='uiIconTrash uiIconLightGray']";
	
	
	public final String ELEMENT_ADD_NAVIGATION_BTN = "//*[text()='Add Navigation']";
	public final String ELEMENT_GROUP_NAVIGATION_POSITION = ".//*[@id='UIGroupNavigationGrid']//tr[${index}]//*[contains(text(),'${groupTitle}')]";
	public final String ELEMENT_EDIT_PROPERTIES_ICON = "//*[text()='${groupName}']/../..//*[@class='uiIconEditPortalConfig uiIconLightGray']";
	public final String ELEMENT_GROUP_NAVIGATION_PRIORITY = "//*[@name='priority']";
	public final String ELEMENT_SAVE_BTN = "//*[text()='Save']";
	public final String ELEMENT_EDIT_NAVIGATION = "//*[text()='${groupName}']/../..//i[@class='uiIconNavigation uiIconLightGray']";
	public final String ELEMENT_TITLE_NAVIGATION_MANAGEMENT = "//*[text()='Navigation Management']";
	public final String ELEMENT_NODE_LINK = ".//*[@id='UINavigationNodeSelector']//*[@title='${nodeLabel}']/i";
	public final String ELEMENT_ADD_NODE_LINK = "//*[text()='Add Node']";
	public final String ELEMENT_NODE_ADD_NEW = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconAddNode']";
	public final By ELEMENT_INPUT_NAME = By.id("name");
	public final String ELEMENT_SELECT_LANGUAGE = ".//*[@class='selectbox' and @name='languages']";
	public final By ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE = By.id("switchmode");
	public final By ELEMENT_INPUT_LABEL = By.id("i18nizedLabel");
	public final By ELEMENT_PAGE_SELECTOR_TAB = By.linkText("Page Selector");
	public final By ELEMENT_INPUT_PAGE_NAME = By.id("pageName");
	public final By ELEMENT_INPUT_PAGE_TITLE = By.id("pageTitle");
	public final String ELEMENT_CREATE_PAGE_LINK = "//button[contains(text(),'Create Page')]";
	public final String ELEMENT_SEARCH_SELECTOR_PAGE_LINK = "//button[contains(text(),'Search and Select Page')]";
	public final String ELEMENT_SELECT_PAGE = "//*[@title='${titlePage}']/../..//*[@class='uiIconSelectPage uiIconLightGray']";
	public final String ELEMENT_NAVIGATION_NODE = "//label[contains(text(),'Name')]/..//*[contains(text(),'${nodeName}')]";
	public final String ELEMENT_MANAGE_NAVIGATION_POPUP = "//*[text()='Add/Edit Page Node']";
	public final String ELEMENT_EDIT_SELECTED_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconEditSelectedNode']";
	public final String ELEMENT_EDIT_SELECTED_PAGE_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconEditPageNode']";
	public final String EEMENT_DELETE_SELECTED_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconDeleteNode']";
	public final String ELEMENT_SELECT_SEARCH_OPTION = "//*[@class='selectbox' and @name='searchOption']";
	public final String ELEMENT_PAGE_MANAGEMENT_SEARCH_BUTTON = "//*[@data-original-title='Quick Search']/i";
	public final String ELEMENT_SELECT_SEARCHED_PAGE = "//*[contains(text(),'${pageSelectorName}')]/../..//*[@class='uiIconSelectPage uiIconLightGray']";
	public final String MESSAGE_DELETE_PAGE = "Are you sure you want to delete this node?";
	public final String ELEMENT_COPY_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconCopyNode']";
	public final String ELEMENT_PASTE_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconPasteNode']";
	public final String ELEMENT_CUT_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconCutNode']";
	public final String ELEMENT_CLONE_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconCloneNode']";
	public final String ELEMENT_NAVIGATION_MOVE_UP_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconMoveUp']";
	public final String ELEMENT_NAVIGATION_MOVE_DOWN_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconMoveDown']";
	public final String ELEMENT_NAVIGATION_EDIT_PAGE_NODE = ".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconEditPageNode']";
	public final String ELEMENT_CHILD_NODE_LINK = "//*[@title='${nodeLabel}']/..//*[@title='${childNode}']";
	public final String ELEMENT_LIST_NODE_LINK = "//*[contains(text(),'${nodeLabel}')]/..//li[${number}]//*[contains(text(),'${childNode}')]";
	public final String ELEMENT_CURRENT_NODE = "//*[@class='uiIconUpLevel uiIconLightGray']";
	public final String ELEMENT_DELETE_NODE_CONFIRMATION = "Are you sure you want to delete this node?";
	
	ManageAlert alert;
	Dialog dialog;
	Button button;
	
	public PortalGroupNavigation(WebDriver dr){
		this.driver = dr;
		alert = new ManageAlert(dr);
		button = new Button(dr);
		dialog = new Dialog(dr);
	} 
	
	
	/**function: add new navigation for group
	 * @param groupName name of group you want to add navigation
	 */
	public void addNewNavigationForGroup(String groupName){
		info("Add navigation for group " + groupName);
		click(ELEMENT_ADD_NAVIGATION_BUTTON);
		click(ELEMENT_GROUP_SELECT_ADD_NAVIGATION.replace("${groupName}", groupName));
		waitForElementNotPresent(ELEMENT_GROUP_SELECT_ADD_NAVIGATION.replace("${groupName}", groupName));
		click(ELEMENT_CANCEL_BUTON);
		waitForAndGetElement(ELEMENT_GROUP_NAME.replace("${groupName}", groupName));
	}
	
	
	/**function delete navigation for group
	 * @param groupName name of Group
	 */
	public void deleteNavigationForGroup(String groupName){
		alert = new ManageAlert(driver);
		info("Delete navigation of group " + groupName);
		click(ELEMENT_DELETE_NAVIGATION_ICON.replace("${groupName}", groupName));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_DELETE_NAVIGATION_ICON.replace("${groupName}", groupName));
	}
	
	/**
	 * function: Edit Priority For Group
	 * @param groupAdmin Description of group
	 * @param priority Priority you want to set for group
	 */
	public void editPriorityForGroup(String groupAdmin, String priority){
		info("Select group navigation [Administration] and click [Edit Properties]");
		click(ELEMENT_EDIT_PROPERTIES_ICON.replace("${groupName}", groupAdmin));
		info("Change priority for this group");
		select(ELEMENT_GROUP_NAVIGATION_PRIORITY, priority);
		click(ELEMENT_SAVE_BTN);
	}
	
	
	
	/**
	 * function: Add Node for Group
	 * @param currentNavigation
	 * @param currentNodeLabel
	 * @param useAddNodeLink
	 * @param nodeName
	 * @param extendedLabelMode
	 * @param languages
	 * @param nodeLabel
	 * @param pageName
	 * @param pageTitle
	 * @param verifyPage
	 * @param verifyNode
	 */
	public void addNodeForGroup(String currentNavigation, String currentNodeLabel, boolean useAddNodeLink, String nodeName, boolean extendedLabelMode, 
			Map<String, String> languages, String nodeLabel, String pageName, String pageTitle, boolean verifyPage, boolean verifyNode){
		String currentNode="";
		String []nodes = null;
		nodes = currentNodeLabel.split("/");
		if(currentNodeLabel=="")
			currentNode = ELEMENT_CURRENT_NODE;
		editNavigation(currentNavigation);
		info("-- Add a new node for portal/group navigation --");		
		if (useAddNodeLink){
			info("use add node link");
			if(currentNodeLabel!=""){
				for(int i = 0; i<nodes.length; i++){
					currentNode = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodes[i]);
					click(currentNode);
				}
			}
			else
				click(currentNode);
			click(ELEMENT_ADD_NODE_LINK);
		}else{
			info("use right click");
			if(currentNodeLabel!=""){
				for(int i = 0; i<nodes.length; i++){
					currentNode = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodes[i]);
					click(currentNode);
				}
			}
			else
				click(currentNode);
			Utils.pause(500);
			rightClickOnElement(currentNode);
			click(ELEMENT_NODE_ADD_NEW);
			}		
		type(ELEMENT_INPUT_NAME, nodeName, true);

		if (extendedLabelMode) {
			for (String language : languages.keySet()) {
				select(ELEMENT_SELECT_LANGUAGE, language);
				Utils.pause(500);
			}
		} else 
			uncheck(ELEMENT_CHECKBOX_EXTENDED_LABEL_MODE);
		type(ELEMENT_INPUT_LABEL, nodeLabel, true);

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
			Utils.pause(500);
			click(ELEMENT_SEARCH_SELECTOR_PAGE_LINK);
			click(ELEMENT_SELECT_PAGE.replace("${titlePage}", pageTitle));
		}

		info("-- Save to add node for portal/group --");
		Utils.pause(2000);
		click(ELEMENT_SAVE_BTN);
		if (verifyNode) {
			waitForAndGetElement(ELEMENT_NAVIGATION_NODE.replace("${nodeName}", nodeName));
			click(ELEMENT_SAVE_BTN);
			waitForElementNotPresent(ELEMENT_MANAGE_NAVIGATION_POPUP);
		}
		click(ELEMENT_SAVE_BTN);
		Utils.pause(2000);
}

	

	/**
	 * function: Go to Edit navigation
	 * @param currentNavigation
	 */
		public void editNavigation(String currentNavigation) {
			String navigation = ELEMENT_EDIT_NAVIGATION.replace("${groupName}", currentNavigation);
			click(navigation);
			waitForAndGetElement(ELEMENT_TITLE_NAVIGATION_MANAGEMENT);
		}
	
	
		/**
		 * function: Edit node in group navigation
		 * @param groupName
		 * @param nodeName
		 * @param params
		 */
		public void editNodeInGroupNavigation(String groupName, String nodeName, Object...params){
			String nodeLabel = (String) (params.length > 0 ? params[0]: "");
			String pageTitle = (String) (params.length > 1 ? params[1]: "");
			String option = (String) (params.length > 2 ? params[2]: "portal");
			String Title = (String) (params.length > 3 ? params[3]: "");
			info("Edit node for group: " + groupName);
			editNavigation(groupName);
			rightClickOnElement(ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName));
			click(ELEMENT_EDIT_SELECTED_NODE);

			if(!nodeLabel.isEmpty()){
				waitForAndGetElement(ELEMENT_INPUT_LABEL, 5000, 0);
				type(ELEMENT_INPUT_LABEL, nodeLabel, true);
			}

			//Selector page
			if (!pageTitle.isEmpty()){
				click(ELEMENT_PAGE_SELECTOR_TAB);
				click(ELEMENT_SEARCH_SELECTOR_PAGE_LINK);
				type(ELEMENT_INPUT_PAGE_TITLE, pageTitle, true);
				select(ELEMENT_SELECT_SEARCH_OPTION, option);
				click(ELEMENT_PAGE_MANAGEMENT_SEARCH_BUTTON);
				click(ELEMENT_SELECT_SEARCHED_PAGE.replace("${pageSelectorName}", Title));
			}	
			click(ELEMENT_SAVE_BTN);
			if(!nodeLabel.isEmpty()){
				waitForAndGetElement(ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeLabel));
			}
			click(ELEMENT_SAVE_BTN);
			waitForElementNotPresent(ELEMENT_SAVE_BTN);
		}

	
		/**
		 * function: Delete node for group
		 * @param groupName
		 * @param nodeName
		 */
	public void deleteNodeForGroup(String groupName, String nodeName){
		editNavigation(groupName);
		rightClickOnElement(ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName));
		click(EEMENT_DELETE_SELECTED_NODE);
		alert.waitForConfirmation(MESSAGE_DELETE_PAGE);
		Utils.pause(3000);
		waitForElementNotPresent(ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName));
		button.save();
		waitForElementNotPresent(button.ELEMENT_SAVE_BUTTON);
	}
	
	/**
	 * function: Copy node
	 * @param locator
	 */
	public void copyNode(Object locator){
		for (int i =0;; i++){
			if (i > DEFAULT_TIMEOUT/WAIT_INTERVAL) {
				Assert.fail("Timeout");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_COPY_NODE, 5000, 0) != null){
				click((ELEMENT_COPY_NODE));
				return;
			}
			Utils.pause(WAIT_INTERVAL);
		}
	}
		
	/**
	 * function: Paste node
	 * @param locator
	 */
	public void pasteNode(Object locator) {
		info("Paste Node");
		for (int i =0;; i++){
			if (i > DEFAULT_TIMEOUT/WAIT_INTERVAL){
				Assert.fail("Timeout");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_PASTE_NODE, 5000, 0) != null){
				click(ELEMENT_PASTE_NODE);
				return;
			}
			Utils.pause(1000);
		}
	}
		
		
	/**
	 * function: Cut node
	 * @param locator
	 */
		public void cutNode(Object locator)	{
			info("Cut Node");
			for (int i =0;; i++){
				if (i > DEFAULT_TIMEOUT/WAIT_INTERVAL) {
					Assert.fail("Timeout");
				}
				rightClickOnElement(locator);
				if (waitForAndGetElement(ELEMENT_CUT_NODE, 5000, 0)!=null){
					click((ELEMENT_CUT_NODE));				
					return;
				}
				Utils.pause(2000);
			}
		}
		
		/**
		 * function: Clone node
		 * @param locator
		 */
		public void cloneNode(Object locator)	{
			for (int i =0;; i++){
				if (i > DEFAULT_TIMEOUT/WAIT_INTERVAL) {
					Assert.fail("Timeout");
				}
				rightClickOnElement(locator);
				if (waitForAndGetElement(ELEMENT_CLONE_NODE,30000,0)!=null){
					click((ELEMENT_CLONE_NODE));
					return;
				}
				Utils.pause(WAIT_INTERVAL);
			}
		}

		/**
		 * function: Delete node
		 * @param currentNavigation
		 * @param nodeNameHome
		 * @param nodeName
		 * @param firstLevel
		 * @param verify
		 */
		public void deleteNode(String currentNavigation, String nodeNameHome, String nodeName, boolean firstLevel, boolean...verify){
			boolean check = verify.length > 0 ? verify[0]:true;
			info("--Delete a node from navigation--");
			String currentNodeHome = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeNameHome);
			String currentNodeName = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName);
			editNavigation(currentNavigation);
			if (firstLevel){
				click(currentNodeName);
				rightClickOnElement(currentNodeName);
				click(EEMENT_DELETE_SELECTED_NODE);
				alert.waitForConfirmation(ELEMENT_DELETE_NODE_CONFIRMATION);
				if (check){
					waitForElementNotPresent(currentNodeName);
				}
				click(ELEMENT_SAVE_BTN);	
			}else {
				if (isElementNotPresent(currentNodeName)){
					click(currentNodeHome);
				}
				click(currentNodeName);
				rightClickOnElement(currentNodeName);
				click(EEMENT_DELETE_SELECTED_NODE);
				alert.waitForConfirmation(ELEMENT_DELETE_NODE_CONFIRMATION);
				if (check){
					waitForElementNotPresent(currentNodeName);
				}
				click(ELEMENT_SAVE_BTN);	
			}
			waitForElementNotPresent(ELEMENT_SAVE_BTN);
		}
}
