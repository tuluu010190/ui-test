package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.HashMap;
import java.util.Map;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author tult
 * @date march, 19th, 2015
 * 
 * 
 */
public class Gatein_Group_Navigation_Edit_Navigation extends GateIn_TestConfig{

	/*@BeforeMethod
	public void setUpBeforeMethod(){
		magAc.signOut();
		magAc.signIn(DATA_USER1,DATA_PASS);
	}*/


	/**
	*<li> Case ID:123044.</li>
	*<li> Test Case Name: Edit priority for group navigation.</li>
	*/
	@Test
	public void test01_EditPriorityForGroupNavigation(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String groupAdminOldPosition = groupManage.ELEMENT_GROUP_NAVIGATION_POSITION.replace("${index}", "2").replace("${groupTitle}", groupAdmin);
		String groupAdminNewPosition = groupManage.ELEMENT_GROUP_NAVIGATION_POSITION.replace("${index}", "1").replace("${groupTitle}", groupAdmin);
		
		info("Go to Group Sites");
		navToolBar.goToGroupSites();

		info("Verify position of Administration before change order");
		waitForAndGetElement(groupAdminOldPosition);
		
		/*Step Number: 1
		*Step Name: Step 1: Edit priority for group navigation		
		*Step Description: 
			- Go to Administration/Portal/Group Sites
			- Select a group navigation and click  edit properties
			- Change priority for this group and click Save
		*Input Data: 
		*Expected Outcome: 
			- Priority is changed successfully */
		groupManage.editPriorityForGroup(groupAdmin, "1");

		info("Verify position of Administration after changing order");
		waitForAndGetElement(groupAdminNewPosition);
		magAc.signOut();

		magAc.signIn(DATA_USER1, DATA_PASS);
		navToolBar.goToGroupSites();
		//Verify position of Administration after SignOut and SignIn  
		waitForElementNotPresent(groupAdminOldPosition);
		waitForAndGetElement(groupAdminNewPosition);

		info("Reset order of navigation list");
		groupManage.editPriorityForGroup(groupAdmin, "2");
		waitForAndGetElement(groupAdminOldPosition);
	}
	
	/**
	*<li> Case ID:123120.</li>
	*<li> Test Case Name: Add node for group.</li>
	*<li> Case ID:123121.</li>
	*<li> Test Case Name: Edit node for group.</li>
	*<li> Case ID:123051.</li>
	*<li> Test Case Name: Delete node for group.</li>
	*/
	@Test
	public void test02_03_04_AddEditDeleteNodeForGroup(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodePortalAdministration = gateinNodesData.getNodesByIndex(0);
		String nodeName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String nodeNameEdit = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String pageSelectorName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();

		Map<String, String> languages = new HashMap<String, String>();
		languages.put("English", "");

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		
		/*Step Number: 1
		*Step Name: Step 1: Add node		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Add new node by click add new node button or right click
			- Input value for Page Node Setting and Page Selector form
			- Click Save
		*Input Data: 
		*Expected Outcome: 
			- Add node successfully*/
		info("Test Case 02: Add a new node for group Administration");
		groupManage.addNodeForGroup(groupAdmin, nodePortalAdministration, false, 
				nodeName, true, languages, nodeName, 
				pageSelectorName, pageSelectorName, true, false);

		if(this.plfVersion.contains("4.0"))
			click(navToolBar.ELEMENT_GROUP_NAVIGATION_ICON_LEFT_PANEL.replace("${groupName}", "Portal Admin"));
		else
			click(navToolBar.ELEMENT_GROUP_NAVIGATION_ICON_LEFT_PANEL_PLF41.replace("${groupName}", "Portal Admin"));
		waitForTextPresent(nodeName);
		info("A new node has been added...successful");
		
		/*Step Number: 2
		*Step Name: Step 2: Edit node		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node and choose
			- Edit node by right click 
			- Change values in fields of the current node, except the Node Name. 
			- Click Save
		*Input Data: 
		*Expected Outcome: 
			- The node is updated with the change value*/
		info("Test Case 03: Edit node for group");
		groupManage.editNodeInGroupNavigation(groupAdmin, nodeName, nodeNameEdit, "profile", "portal", "Profile");
		
		/*editNodeInGroupNavigation(groupAdminDisplayName, nodeName, nodeNameEdit, "profile", "portal");
		button.save();
		waitForElementNotPresent(button.ELEMENT_SAVE_BUTTON);*/
		if(this.plfVersion.contains("4.0"))
			click(navToolBar.ELEMENT_GROUP_NAVIGATION_ICON_LEFT_PANEL.replace("${groupName}", "Portal Admin"));
		else
			click(navToolBar.ELEMENT_GROUP_NAVIGATION_ICON_LEFT_PANEL_PLF41.replace("${groupName}", "Portal Admin"));
		click(navToolBar.ELEMENT_SUB_NODE_NAVIGATION_LEFT_PANEL.replace("${groupName}", nodeNameEdit));
		waitForTextPresent("Basic information");
		waitForTextPresent("Contact");
		waitForTextPresent("Experience");

		/*Step Number: 3
		*Step Name: Step 3: Delete node		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node and choose Delete node by right click 
			- Click OK in the confirmation message to accept your deletion. 
			- Click Save
		*Input Data: 
		*Expected Outcome: 
			- The node is removed from the list*/
		info("Test Case 04: Delete a node");
		navToolBar.goToGroupSites();
		groupManage.deleteNodeForGroup(groupAdmin, nodeNameEdit);
		if(waitForAndGetElement(navToolBar.ELEMENT_GROUP_NAVIGATION_ICON_LEFT_PANEL_PLF41.replace("${groupName}", "Portal Admin"), 4000, 0) != null){
			click(navToolBar.ELEMENT_GROUP_NAVIGATION_ICON_LEFT_PANEL_PLF41.replace("${groupName}", "Portal Admin"));
			waitForElementNotPresent(navToolBar.ELEMENT_SUB_NODE_NAVIGATION_LEFT_PANEL.replace("${groupName}", nodeNameEdit));
		}
		else
			waitForElementNotPresent(navToolBar.ELEMENT_GROUP_NAVIGATION_ICON_LEFT_PANEL_PLF41.replace("${groupName}", "Portal Admin"));
		
		info("Reset data");
		navToolBar.goToPotalPages();
		portMg.deletePage(pageSelectorName, "group");
	}
	
	
	/**
	*<li> Case ID:123117.</li>
	*<li> Test Case Name: Copy and Paste node.</li>
	*<li> Case ID:123118.</li>
	*<li> Test Case Name: Cut and Paste Node.</li>
	*<li> Case ID:123119.</li>
	*<li> Test Case Name: Clone and Paste Node.</li>
	*/
	@Test
	public void test05_06_07_CopyCutCloneAndPasteNode(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		
		String nodePortalAdministration = gateinNodesData.getNodesByIndex(0);
		String nodeSitesManagement = gateinNodesData.getNodesByIndex(1);
		String nodeManagement = gateinNodesData.getNodesByIndex(2);
		
		String nodeName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String pageSelectorName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		
		String nodeAdmin = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodePortalAdministration);
		String nodeLinkToCopy = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName);
		String nodeLinkToPaste = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement);
		String nodeLinkToClone = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeManagement);
		String nodeAfterCopy = groupManage.ELEMENT_CHILD_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement).replace("${childNode}", nodeName);

		Map<String, String> languages = new HashMap<String, String>();
		languages.put("English", "");

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();
		
		/*Step Number: 1
		*Step Name: Step 1: Copy and Paste node		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click on node and choose Copy from the drop-down menu. 
			- Right click the position you want to paste this node and select Paste Node. 
		*Input Data: 
		*Expected Outcome: 
			- Node is copied to new place*/
		info("Test Case 05: Copy and Paste node");
		info("Add a new node for group Administration");
		groupManage.addNodeForGroup(groupAdmin, nodePortalAdministration, false, 
				nodeName, true, languages, nodeName, 
				pageSelectorName, pageSelectorName, true, false);

		info("Copy that node and paste to group Site Management");
		groupManage.editNavigation(groupAdmin);
		groupManage.copyNode(nodeLinkToCopy);
		groupManage.pasteNode(nodeLinkToPaste);
		waitForAndGetElement(nodeAfterCopy);	
		rightClickOnElement(nodeAfterCopy);
		click(groupManage.EEMENT_DELETE_SELECTED_NODE);
		magAlert.acceptAlert();
		waitForElementNotPresent(nodeAfterCopy);

		/*Step Number: 2
		*Step Name: Step 2: Cut and Paste Node		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click on node and choose Cut from the drop-down menu. 
			- Right click the position you want to paste this node and select Paste Node.  
		*Input Data: 
		*Expected Outcome: 
			- Node is cut to new place*/
		info("Test Case 06: Cut and Paste Node");
		click(nodeAdmin);
		groupManage.cutNode(nodeLinkToCopy);
		groupManage.pasteNode(nodeLinkToPaste);
		waitForAndGetElement(nodeAfterCopy);
		click(nodeAdmin);
		waitForElementNotPresent(nodeLinkToCopy);

		/*Step Number: 3
		*Step Name: Step 3: Clone and Paste Node		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click on node and choose Clone Node from the drop-down menu. 
			- Right click the position that you want to paste this node and select Paste Node
		*Input Data: 
		*Expected Outcome: 
			- Node is clone successfully and have properties is the same with node is copied*/
		info("Test Case 07: Clone and Paste Node");
		click(nodeLinkToPaste);
		groupManage.cloneNode(nodeAfterCopy);
		groupManage.pasteNode(nodeLinkToClone);
		but.save();
		waitForElementNotPresent(but.ELEMENT_SAVE_BUTTON);

		info("Verify that a new node is created in Pages Management");
		navToolBar.goToPotalPages();
		portMg.searchPage(pageSelectorName, "", "group", true);
		waitForAndGetElement(portMg.ELEMENT_LIST_PAGE.replace("${number}", "1").replace("${titlePage}", pageSelectorName));
		waitForAndGetElement(portMg.ELEMENT_LIST_PAGE.replace("${number}", "2").replace("${titlePage}", pageSelectorName));

		click(portMg.ELEMENT_PAGE_DELETE_ICON_AUX.replace("${number}", "2").replace("${titlePage}", pageSelectorName));
		magAlert.acceptAlert();
		waitForElementNotPresent(portMg.ELEMENT_PAGE_DELETE_ICON_AUX.replace("${number}", "2").replace("${titlePage}", pageSelectorName));

		info("Reset data");
		portMg.deletePage(pageSelectorName, "group");
		navToolBar.goToGroupSites();
		groupManage.deleteNode(groupAdmin, nodeSitesManagement, nodeName, false);
		groupManage.deleteNode(groupAdmin, nodeManagement, nodeName, false);
	}
	
	
	/**
	*<li> Case ID:123052.</li>
	*<li> Test Case Name: Change node order.</li>
	*/
	@Test
	public void test08_ChangeNodeOrder(){
		String nodeSitesManagement = gateinNodesData.getNodesByIndex(1);
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		
		String nodeName1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String pageSelectorName1 = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String nodeName2 = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String pageSelectorName2 = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		
		Map<String, String> languages = new HashMap<String, String>();
		languages.put("English", "");
		
		String nodeLink = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement);
		String nodeLinkToMove = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName2);

		/*Step Number: 1
		*Step Name: Step 1: Change node order		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Select Move Up or Move Down from the drop-down menu
			- Click Save to accept your changes. 
		*Input Data: 
		*Expected Outcome: 
			- Position of node is changed successfully*/
		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		info("Add a new node for group Sites Management");
		groupManage.addNodeForGroup(groupAdmin, nodeSitesManagement, false, 
				nodeName1, true, languages, nodeName1, 
				pageSelectorName1, pageSelectorName1, true, false);
		groupManage.addNodeForGroup(groupAdmin, nodeSitesManagement, false, 
				nodeName2, true, languages, nodeName2, 
				pageSelectorName2, pageSelectorName2, true, false);
		groupManage.editNavigation(groupAdmin);
		click(nodeLink);
		info("Select Move Up from the drop-down menu");
		rightClickOnElement(nodeLinkToMove);
		click(groupManage.ELEMENT_NAVIGATION_MOVE_UP_NODE);
		but.save();
		waitForElementNotPresent(but.ELEMENT_SAVE_BUTTON);

		info("Verify the position of node....");
		groupManage.editNavigation(groupAdmin);
		click(nodeLink);
		waitForAndGetElement(groupManage.ELEMENT_LIST_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement).replace("${number}", "1").replace("${childNode}", nodeName2));
		waitForAndGetElement(groupManage.ELEMENT_LIST_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement).replace("${number}", "2").replace("${childNode}", nodeName1));	
		rightClickOnElement(nodeLinkToMove);
		click(groupManage.ELEMENT_NAVIGATION_MOVE_DOWN_NODE);
		waitForAndGetElement(groupManage.ELEMENT_LIST_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement).replace("${number}", "1").replace("${childNode}", nodeName1));
		waitForAndGetElement(groupManage.ELEMENT_LIST_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement).replace("${number}", "2").replace("${childNode}", nodeName2));
		but.save();
		waitForElementNotPresent(but.ELEMENT_SAVE_BUTTON);

		info("Reset data");
		navToolBar.goToPotalPages();
		portMg.deletePage(pageSelectorName1, "group");
		portMg.deletePage(pageSelectorName2, "group");

		navToolBar.goToGroupSites();
		groupManage.deleteNode(groupAdmin, nodeSitesManagement, nodeName1, false);
		groupManage.deleteNode(groupAdmin, nodeSitesManagement, nodeName2, false);
	}
	
	
	/**
	*<li> Case ID:123053.</li>
	*<li> Test Case Name: Edit node's page properties.</li>
	*/
	@Test
	public void test09_EditNodePageProperties(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodeSitesManagement = gateinNodesData.getNodesByIndex(1);
		
		String nodeName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String pageSelectorName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String pageSelectorNameEdit = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		
		String groupPermissionPath = portGroupPermisData.getContentByIndex(3);
		String permission = portMemPermisData.getContentByIndex(3);
		
		String nodeLink = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement);
		String nodeLinkToEdit = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName);
		
		Map<String, String> languages = new HashMap<String, String>();
		languages.put("English", "");

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		info("Add a node for group Sites Management");
		groupManage.addNodeForGroup(groupAdmin, nodeSitesManagement, false, 
				nodeName, true, languages, nodeName, 
				pageSelectorName, pageSelectorName, true, false);
		
		/*Step Number: 1
		*Step Name: Step 1: Edit node's page properties		
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Choose View Page properties on Page Editor
			- Edit some changes
			- Click Save button
		*Input Data: 
		*Expected Outcome: 
			- Page Setting, Permission setting tab is updated successfully with new changes*/
		info("Edit node's page properties");
		groupManage.editNavigation(groupAdmin);
		click(nodeLink);
		rightClickOnElement(nodeLinkToEdit);
		waitForAndGetElement(groupManage.ELEMENT_EDIT_SELECTED_PAGE_NODE);
		click(groupManage.ELEMENT_EDIT_SELECTED_PAGE_NODE);
	
		pagCW.editViewProperties(pageSelectorNameEdit, groupPermissionPath, permission);
		
		waitForElementNotPresent(portMg.ELEMENT_VIEW_PAGE_PROPERTIES);
		click(ELEMENT_SAVE_BTN);
		waitForElementNotPresent(but.ELEMENT_SAVE_BUTTON);

		info("Verify [Page Settings] is updated");
		navToolBar.goToPotalPages();
		portMg.deletePage(pageSelectorNameEdit, "group");


		info("Reset data");
		navToolBar.goToGroupSites();
		groupManage.deleteNode(groupAdmin, nodeSitesManagement, nodeName, false);
	}
	
	/**
	*<li> Case ID:123114.</li>
	*<li> Test Case Name: Add container when edit page properties of node.</li>
	*<li> Case ID:123115.</li>
	*<li> Test Case Name: Edit container when edit page properties of node.</li>
	*<li> Case ID:123054.</li>
	*<li> Test Case Name: Move container when edit page properties of node.</li>
	*<li> Case ID:123116.</li>
	*<li> Test Case Name: Delete container when edit page properties of node.</li>
	*/
	@Test
	public void test10_11_12_13_AddEditMoveAndDeleteContainerWhenEditPagePropertiesOfNode(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodeAddUser = gateinNodesData.getNodesByIndex(3);
		String nodeLink = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeAddUser);
		String containerTitle = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String containerId = contaiData.getContainerIdByIndex(0);

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		info("Edit node's page properties");
		groupManage.editNavigation(groupAdmin);
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);

		/*Step Number: 1
		*Step Name: Step 1: Add container when edit page properties of node	
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Container tab from Page Editor
			- Add container by drag & drop
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- Add container successfully
			- The page is displayed in the view mode with all changes*/
		info("Test Case 10: Add a container...");
		pagCW.addContainer(containerId);
		
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(pagCW.ELEMENT_DROP_TARGET_HAS_LAYOUT);
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
	
		/*Step Number: 2
		*Step Name: Step 2:  Edit container when edit page properties of node	
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Container tab from Page Editor
			- Select Container in page and click Edit container
			- Make change something
			- Click Save
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- The container is updated with the change value
			- The page is displayed in the view mode with all changes*/
		info("Test Case 11: Edit a container...");
		info("Edit node's page properties");
		pagCW.editContainer("", containerTitle, "150px", "150px");	
		info("Verify that container was updated successfully");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		mouseOver(pagCW.ELEMENT_DROP_TARGET_HAS_LAYOUT, true);
		if(this.plfVersion.contains("4.0"))
			waitForAndGetElement(pagCW.ELEMENT_NAME_CONTAINER.replace("${nameContainer}", containerTitle));
		else
			waitForAndGetElement(pagCW.ELEMENT_NAME_CONTAINER_PLF41.replace("${nameContainer}", containerTitle));
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(but.ELEMENT_SAVE_BUTTON);
		WebElement element = waitForAndGetElement(pagCW.ELEMENT_EDITING_CONTAINER);
		String valueStyle = element.getAttribute("style");
		assert valueStyle.equals("width: 150px; height: 150px;"): "Failed to edit the value of container: " + containerTitle;

		/*Step Number: 3
		*Step Name: Step 3:  Move container when edit page properties of node	
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Container tab from Page Editor
			- Select container in page and drag& drop it into new place
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- The container is updated with the change value
			- The page is displayed in the view mode with all changes*/
		info("Test Case 12: Move a container");
		info("Add new another container");
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForElementNotPresent(but.ELEMENT_SAVE_BUTTON);
		pagCW.addContainer(containerId);
		
		info("Check order of 2 containers before move");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "2").replace("${nameContainer}", "Container"), DEFAULT_TIMEOUT, 1, 2);
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "1").replace("${nameContainer}", containerTitle), DEFAULT_TIMEOUT, 1, 2);
		info("Move container");
		pagCW.moveContainer("",pagCW.ELEMENT_CONTAINER_HOLDER_MOVE,pagCW.ELEMENT_PORTLET,87);
		info("Check order of 2 containers after move");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "1").replace("${nameContainer}", "Container"), DEFAULT_TIMEOUT, 1, 2);
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "3").replace("${nameContainer}", containerTitle), DEFAULT_TIMEOUT, 1, 2);
		click(pagCW.ELEMENT_PAGE_ABORT_BUTTON);
		waitForElementNotPresent(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
	
		/*Step Number: 4
		*Step Name: Step 4:  Delete container when edit page properties of node	
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Container tab from Page Editor
			- Select container in page and click Delete container
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- The container is updated with the change value
			- The page is displayed in the view mode with all changes*/
		info("Test Case 13: Delete a container...");
		info("Delete container 1");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		pagCW.deleteContainer("Container");
		info("Delete container 2");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		pagCW.deleteContainer(containerTitle);
	}
	
	
	/**
	*<li> Case ID:123111.</li>
	*<li> Test Case Name: Add application when edit page properties of node.</li>
	*<li> Case ID:123112.</li>
	*<li> Test Case Name: Edit application when edit page properties of node.</li>
	*<li> Case ID:123055.</li>
	*<li> Test Case Name: Move application when edit page properties of node.</li>
	*<li> Case ID:123113.</li>
	*<li> Test Case Name: Remove application when edit page properties of node.</li>
	*/
	@Test
	public void test14_15_16_17_AddEditMoveAndDeleteApplicationWhenEditPagePropertiesOfNode(){
		String nodeSitesManagement = gateinNodesData.getNodesByIndex(1);
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);	
		String pageSelectorName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String portletTitle = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String nodeName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String nodeLink = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName);
		String nodeLinkSitesManagement = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement);
		
		String categoryApplication = appLayData.getCategoryApplicationByIndex(0);
		String idApplication1 = appLayData.getIdApplicationByIndex(3);
		String idApplication2 = appLayData.getIdApplicationByIndex(5);
		String idApplication3 = appLayData.getIdApplicationByIndex(4);
		String titleApplication1 = appLayData.getTitleApplicationByIndex(5);
		String titleApplication2 = appLayData.getTitleApplicationByIndex(4);

		Map<String, String> languages = new HashMap<String, String>();
		languages.put("English", "");

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		info("Add a node for group Sites Management");
		groupManage.addNodeForGroup(groupAdmin, nodeSitesManagement, false, 
				nodeName, true, languages, nodeName, 
				pageSelectorName, pageSelectorName, true, false);
		groupManage.editNavigation(groupAdmin);
		click(nodeLinkSitesManagement);
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);

		/*Step Number: 1
		*Step Name: Step 1:  Add application when edit page properties of node	
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Application tab from edit inline composer
			- Add application by drag & drop
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- Add application successfully
			- The page is displayed in the view mode with all changes*/
		info("Test Case 14: Add an application when edit page...");
		pagCW.addApplication(pagCW.ELEMENT_APPLICATION_CATEGORY.replace("${applicationCategor}", categoryApplication), pagCW.ELEMENT_APPLICATION_ID.replace("${applicationId}", idApplication1));
		info("Check to verify that application was added successfully");
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(ELEMENT_INPUT_USERNAME);
		waitForAndGetElement(ELEMENT_INPUT_PASSWORD);
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForElementNotPresent(ELEMENT_INPUT_USERNAME);
		pagCW.saveChangesPageEditor();

		/*Step Number: 2
		*Step Name: Step 2:  Edit application when edit page properties of node	
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Application tab from edit inline composer
			- Choose application on page and click [Edit portlet]
			- Make change something
			- Click Save and Close
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- The application is updated with the change value
			- The page is displayed in the view mode with all changes*/
		info("Test Case 15: Edit an application when edit page...");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		pagCW.editApplication("", portletTitle, "600px", "600px");
		but.saveAndClose();
		info("Check to verify application was edited successfully");
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(but.ELEMENT_SAVE_BUTTON);
		waitForAndGetElement(pagCW.ELEMENT_NAME_PORTLET.replace("${portletName}", portletTitle));
		WebElement element = waitForAndGetElement(pagCW.ELEMENT_PORTLET_FRAGMENT.replace("${portletName}", "UIAccountPortlet"));
		String valueStyle = element.getAttribute("style");
		assert valueStyle.equals("width: 100%; height: 600px;"): "Failed to edit portlet: " + portletTitle;

		/*Step Number: 3
		*Step Name: Step 3:  Move application when edit page properties of node
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Application tab from edit inline composer
			- Move application on page by drag & drop into new place
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- The application is move to new place
			- The page is displayed in the view mode with all changes*/
		info("Test Case 16: Move an application when edit page...");
		info("Add 2 more new applications");
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		pagCW.addApplication(pagCW.ELEMENT_APPLICATION_CATEGORY.replace("${applicationCategor}", categoryApplication), pagCW.ELEMENT_APPLICATION_ID.replace("${applicationId}", idApplication2));
		pagCW.addApplication(pagCW.ELEMENT_APPLICATION_CATEGORY.replace("${applicationCategor}", categoryApplication), pagCW.ELEMENT_APPLICATION_ID.replace("${applicationId}", idApplication3));
		info("Check order of applications before moving application");
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "3").replace("${nameContainer}", portletTitle));
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "2").replace("${nameContainer}", titleApplication2));
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "1").replace("${nameContainer}", titleApplication1));
		info("Move application");
		pagCW.moveApplication(portletTitle, titleApplication1, 87);
		info("Verify that the page is updated after moving...");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "2").replace("${nameContainer}", portletTitle));
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "1").replace("${nameContainer}", titleApplication1));
		waitForAndGetElement(pagCW.ELEMENT_LIST_CONTAINER.replace("${number}", "3").replace("${nameContainer}", titleApplication2));
		click(pagCW.ELEMENT_PAGE_ABORT_BUTTON);
		waitForElementNotPresent(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
	
		/*Step Number: 4
		*Step Name: Step 4: Remove application when edit page properties of node
		*Step Description: 
			- Go to Group Sites/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Application tab from edit inline composer
			- Choose application on page and click Delete portlet
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- The application is removed successfully
			- The page is displayed in the view mode with all changes*/
		info("Test Case 17: Delete an application when edit page...");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		pagCW.deleteApplication(titleApplication1);
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		pagCW.deleteApplication(portletTitle);
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		pagCW.deleteApplication(titleApplication2);

		info("Reset data");
		info("Delete created node");
		groupManage.editNavigation(groupAdmin);
		click(nodeLinkSitesManagement);
		rightClickOnElement(nodeLink);
		click(groupManage.EEMENT_DELETE_SELECTED_NODE);
		magAlert.acceptAlert();
		waitForElementNotPresent(nodeLink);
		but.save();
		waitForElementNotPresent(but.ELEMENT_SAVE_BUTTON);
		info("Delete created page");
		navToolBar.goToPotalPages();
		portMg.deletePage(pageSelectorName, "group");
	}
	
	/**
	*<li> Case ID:123056.</li>
	*<li> Test Case Name: Add application into container when edit page properties of node.</li>
	*/
	@Test
	public void test18_AddApplicationIntoContainerWhenEditPagePropertiesOfNode(){
		String nodeSitesManagement = gateinNodesData.getNodesByIndex(1);
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);	
		String pageSelectorName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String nodeName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String nodeLink = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeName);
		String nodeLinkSitesManagement = groupManage.ELEMENT_NODE_LINK.replace("${nodeLabel}", nodeSitesManagement);
		
		String categoryApplication = appLayData.getCategoryApplicationByIndex(15);
		String containerId = contaiData.getContainerIdByIndex(0); 
		String name = appLayData.getTitleApplicationByIndex(15);
		String idName = appLayData.getIdApplicationByIndex(15);
		
		Map<String, String> languages = new HashMap<String, String>();
		languages.put("English", "");

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();
		
		/*Step Number: 1
		*Step Name: Step 1: Add application into container when edit page properties of node
		*Step Description: 
			- Go to Group Sties/Edit navigation
			- Select a node
			- Right click and choose Edit node's page
			- Select Container tab from edit inline composer
			- Add container by drag & drop
			- Select Application tab from edit inline composer
			- Drag & drop application into the container added above
			- Switch view mode
		*Input Data: 
		*Expected Outcome: 
			- The application is removed successfully
			- The page is displayed in the view mode with all changes*/
		info("Add a node for group Sites Management");
		groupManage.addNodeForGroup(groupAdmin, nodeSitesManagement, false, 
				nodeName, true, languages, nodeName, 
				pageSelectorName, pageSelectorName, true, false);
		groupManage.editNavigation(groupAdmin);
		click(nodeLinkSitesManagement);
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);

		info("Add an a new container for node");
		pagCW.addContainer(containerId);
		
		info("Add a application to above created container");
		rightClickOnElement(nodeLink);
		click(groupManage.ELEMENT_NAVIGATION_EDIT_PAGE_NODE);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PAGE_PROPERTIES);
		click(pagCW.ELEMENT_APPLICATION_TAB);
		Utils.pause(1000);
		click(pagCW.ELEMENT_APPLICATION_CATEGORY.replace("${applicationCategor}", categoryApplication));
		dragAndDropToObject(pagCW.ELEMENT_APPLICATION_APPLICATION.replace("${name}",idName),pagCW.ELEMENT_DROP_SOURCE_HAS_LAYOUT_BY_NAME.replace("${name}","Container"));
		waitForAndGetElement(pagCW.ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",name),3000,0);
		Utils.pause(2000);
		info("Switch to view mode to verify application added to container successfully");
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		waitForAndGetElement(pagCW.ELEMENT_FORUM_PORTLET_IN_VIEW_PAGE);
		click(pagCW.ELEMENT_SWITCH_VIEW_MODE);
		pagCW.saveChangesPageEditor();
		
		info("Reset data");
		rightClickOnElement(nodeLink);
		click(groupManage.EEMENT_DELETE_SELECTED_NODE);
		magAlert.acceptAlert();
		waitForElementNotPresent(nodeLink);
		but.save();
		waitForElementNotPresent(but.ELEMENT_SAVE_BUTTON);
		navToolBar.goToPotalPages();
		portMg.deletePage(pageSelectorName, "group");
	}
}