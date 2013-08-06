package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.Map;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;

public class GroupNavigation extends PlatformBase {
	Button button;
	ManageAlert alert;
	
	//Manage Group Navigation screen
	public final String ELEMENT_GROUP_NAME = "//*[@class='siteName' and text()='${groupName}']";
	public final By ELEMENT_GROUP_ADD_NAVIGATION_BUTTON = By.linkText("Add Navigation");
	public final String ELEMENT_DELETE_NAVIGATION_ICON = "//*[text()='${groupName}']/../..//*[text()='Delete Navigation']";
	
	//Add Navigation for group screen
	public final String ELEMENT_GROUP_SELECT_ADD_NAVIGATION = "//*[contains(text(), '${groupName}')]/..//*[text()='Add Navigation']";

	//Add a node for group at group navigation
	public void addNodeForGroup(String currentNavigation, String currentNodeLabel, boolean useAddNodeLink, String nodeName, boolean extendedLabelMode, 
			Map<String, String> languages, String nodeLabel, String pageName, String pageTitle, boolean verifyPage, boolean verifyNode){
		button = new Button(driver);
		//String node = ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeLabel);
		String currentNode = ELEMENT_NODE_LINK.replace("${nodeLabel}", currentNodeLabel);
		editNavigation(currentNavigation);

		info("--Add new node at navigation--");		
		if (useAddNodeLink){
			click(currentNode);
			click(ELEMENT_ADD_NODE_LINK);
		}else{

			click(currentNode);
			Utils.pause(500);
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
				Utils.pause(500);
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
			Utils.pause(500);
			click(ELEMENT_SEARCH_SELECT_PAGE_LINK);
			click(ELEMENT_SELECT_HOME_PAGE);
		}

		info("-- Save to add node for portal --");
		Utils.pause(1000);
		button.save();
		if (verifyNode) {
			waitForTextNotPresent("Page Node Settings");
			waitForTextPresent(nodeName);
			button.save();
			waitForTextNotPresent("Navigation Management");
		}
	}
	/**function add new navigation for group
	 * @author lientm
	 * @param groupName
	 */
	public void addNewNavigationForGroup(String groupName){
		button = new Button(driver);
		info("Add navigation for group " + groupName);
		click(ELEMENT_GROUP_ADD_NAVIGATION_BUTTON);
		click(ELEMENT_GROUP_SELECT_ADD_NAVIGATION.replace("${groupName}", groupName));
		waitForElementNotPresent(ELEMENT_GROUP_SELECT_ADD_NAVIGATION.replace("${groupName}", groupName));
		button.cancel();
		waitForAndGetElement(ELEMENT_GROUP_NAME.replace("${groupName}", groupName));
	}
	
	/**function delete navigation for group
	 * @author lientm
	 * @param groupName
	 */
	public void deleteNavigationForGroup(String groupName){
		alert = new ManageAlert(driver);
		info("Delete navigation of group " + groupName);
		click(ELEMENT_DELETE_NAVIGATION_ICON.replace("${groupName}", groupName));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_DELETE_NAVIGATION_ICON.replace("${groupName}", groupName));
	}
}
