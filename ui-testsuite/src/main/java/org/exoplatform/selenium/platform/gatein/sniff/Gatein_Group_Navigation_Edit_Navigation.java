package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.Test;

/**
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

		String nodeName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String newNodeName = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String namePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String titlePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();
		groupManage.editNavigation(groupAdmin);
		
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
		info("Add a new node");
		navMag.addNode(nodeName,"");
		navMag.inputInfoPageSelector(namePage, titlePage, true,false,false);
		navMag.saveNode();
		info("Add node successfully");
		groupManage.editNavigation(groupAdmin);
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_MANAGEMENT_NODE_NAME.replace(
				"${name}", nodeName));
		navMag.saveNode();
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
		info("Edit a node");
		groupManage.editNavigation(groupAdmin);
		navMag.editThisNode(nodeName);
		navMag.inputInfoNodeSetting(true, "",newNodeName,true,false);
		navMag.saveNode();
		
		info("Verify that the node is changed with new name");
		groupManage.editNavigation(groupAdmin);
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_MANAGEMENT_NODE_NAME.replace(
				"${name}",newNodeName));
		navMag.editThisNode(newNodeName);
		info("Verify that label mode is not checked");
		waitForElementNotPresent(navMag.ELEMENT_NODE_SETTING_SWITCH_MODE_CHECKED);
		info("Verify that language box is not shown");
		waitForElementNotPresent(navMag.ELEMENT_NODE_SETTING_LANGUAGE_BOX);
		info("Verify that visible is not checked");
		waitForElementNotPresent(navMag.ELEMENT_NODE_SETTING_VISIBLE_CHECKED);
		info("Verify that publish date and time is not shown");
		waitForElementNotPresent(navMag.ELEMENT_NODE_SETTING_PUBLISH_DATE_TIME);
		navMag.saveNode();

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
		groupManage.editNavigation(groupAdmin);
		navMag.deleteNode(nodeName);
	}
	
	
	/**
	*<li> Case ID:123117.</li>
	*<li> Test Case Name: Copy and Paste node.</li>
	*/
	@Test
	public void test05_CopyAndPasteNode(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodeName1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nodeName2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();
		groupManage.editNavigation(groupAdmin);
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
		info("Add a new node 1");
		navMag.addNode(nodeName1,"");
		navMag.saveNode();
		
		info("Add a new node 2");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName2,"");
		navMag.saveNode();
		
		info("Copy and paste a node");
		groupManage.editNavigation(groupAdmin);
		navMag.copyNode(nodeName1);
		navMag.pasteNode(nodeName2);
		info("Verify that node 2 has only one children is node1");
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_PARENT_CHILD_NODE.replace("${parent}",nodeName2).replace("${child}",nodeName1));
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_NUMBER_CHILD_NODES.replace("${parent}",nodeName2).replace("${numberChild}","1"));
		navMag.closeNavigationManagementPopup();
		
	}
	
	
	/**
	*<li> Case ID:123052.</li>
	*<li> Test Case Name: Change node order.</li>
	*/
	@Test
	public void test08_ChangeNodeOrder(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodeName1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nodeName2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

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

		info("Add a new node 1");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName1,"");
		navMag.saveNode();
		
		info("Add a new node 2");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName2,"");
		navMag.saveNode();
		
		info("move up node2 to node 1");
		groupManage.editNavigation(groupAdmin);
		navMag.moveUpNode(nodeName2);
		
		info("Verify that node 2 is moved up node1");
		waitForElementNotPresent(navMag.ELEMENT_NAVIGATION_PREVIOUS_NODE.replace("${currentNode}",nodeName2).replace("${previousNode}",nodeName1));
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_NEXT_NODE.replace("${currentNode}",nodeName2).replace("${nextNode}",nodeName1));
		
		info("move down node 2 to node 1");
		navMag.moveDownNode(nodeName2);
		info("Verify that node 2 is moved up node1");
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_PREVIOUS_NODE.replace("${currentNode}",nodeName2).replace("${previousNode}",nodeName1));
		waitForElementNotPresent(navMag.ELEMENT_NAVIGATION_NEXT_NODE.replace("${currentNode}",nodeName2).replace("${nextNode}",nodeName1));
		navMag.closeNavigationManagementPopup();
	}
	
	
	/**
	*<li> Case ID:123053.</li>
	*<li> Test Case Name: Edit node's page properties.</li>
	*/
	@Test
	public void test09_EditNodePageProperties(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodeName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String namePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String titlePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		String newTitlePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String groupPath = portGroupPermisData.getContentByIndex(0);
		String memberships = portMemPermisData.getContentByIndex(0);

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		info("Add a new node");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName,"");
		navMag.inputInfoPageSelector(namePage, titlePage, true,false,false);
		navMag.saveNode();
		
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
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.viewProperties();
		pagCW.changeProperties(newTitlePage,groupPath,memberships,true,false);
		
		info("Verify that the changs are updated");
		pagCW.viewProperties();
		info("Page settings is updated");
		String titleActual = pagCW.getOldTitle();
		info("titleActual:"+titleActual);
		info("newtitle:"+newTitlePage);
		info("Permission setting tab is updated");
		click(pagCW.ELEMENT_VIEW_PROPERTIES_PERMISSION_TAB);
		waitForAndGetElement(pagCW.ELEMENT_VIEW_PROPERTIES_ACCESS_PERMISSTION_VALUE.replace("${group}",groupPath.toLowerCase()),2000,0);
		pagCW.saveChangeProperties();
		pagCW.saveChangesPageEditor();
		if(!titleActual.equals(newTitlePage)) assert false:"The title:"+newTitlePage+" is not updated";
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
		String containerTitle = txData.getContentByArrayTypeRandom(1) + getRandomNumber();
		String containerId = contaiData.getContainerIdByIndex(0);
		
		String nodeName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String namePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String titlePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		
		info("Get information of an application");
		int index2 = appLayData.getRandomIndexByType(1);
		String idApplication = appLayData.newId.get(index2);
		String titleApplication = appLayData.newTitle.get(index2);

		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		info("Add a new node");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName,"");
		navMag.inputInfoPageSelector(namePage, titlePage, true,false,false);
		navMag.saveNode();

		info("Add a new application");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.addApp("",titleApplication,pagCW.ELEMENT_APPLICATION_APPLICATION.replace("${name}",idApplication),pagCW.ELEMENT_PAGEEDITOR_VIEWPAGE);
		navMag.closeNavigationManagementPopup();

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
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.addContainer(containerId);
		navMag.closeNavigationManagementPopup();
	
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
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.editContainer("Container", containerTitle, "", "");
		navMag.closeNavigationManagementPopup();
		
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
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.moveContainer(containerTitle,pagCW.ELEMENT_CONTAINER_HOLDER_MOVE,pagCW.ELEMENT_PORTLET,87);
		navMag.closeNavigationManagementPopup();
		
		info("Check order of the container");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.checkPositions(pagCW.ELEMENT_CONTAINER_PRECEDING_PORTLET,pagCW.ELEMENT_CONTAINER_FOLLOWING_PORTLET);
		navMag.closeNavigationManagementPopup();
		
	
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
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.deleteContainer(containerTitle);
		navMag.closeNavigationManagementPopup();
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
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);	
		String containerId = contaiData.getContainerIdByIndex(0);
		String nodeName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String namePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String titlePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		info("Get information of an application");
		int index2 = appLayData.getRandomIndexByType(1);
		String idApplication = appLayData.newId.get(index2);
		String nameApplication = appLayData.newTitle.get(index2);
		
		info("Go to Group Sites/Edit navigation");
		navToolBar.goToGroupSites();

		info("Add a new node");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName,"");
		navMag.inputInfoPageSelector(namePage, titlePage, true,false,false);
		navMag.saveNode();
		
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

		info("Add a new application");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.addApp("",nameApplication,pagCW.ELEMENT_APPLICATION_APPLICATION.replace("${name}",idApplication),pagCW.ELEMENT_PAGEEDITOR_VIEWPAGE);
		navMag.closeNavigationManagementPopup();
		
		info("Add a container...");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.addContainer(containerId);
		navMag.closeNavigationManagementPopup();
		
		info("Verify that the application is added successfully");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.switchViewMode(true);
		pagCW.saveChangesPageEditor();
		navMag.closeNavigationManagementPopup();
		
		info("Test Case 15: Edit an application when edit page...");
		String newTitle= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
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
		
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.editApplication(nameApplication,newTitle,"","");
		pagCW.saveChangesApplication();
		pagCW.saveChangesPageEditor();
		navMag.closeNavigationManagementPopup();
		
		info("Verify that the application is edited successfully");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		waitForAndGetElement(pagCW.ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",newTitle),3000,0);
		pagCW.switchViewMode(true);
		pagCW.saveChangesPageEditor();
		navMag.closeNavigationManagementPopup();
		

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
		info("Move an application to new place");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.moveApplication(newTitle,"Container",87);
		info("Click on Save button");
		navMag.closeNavigationManagementPopup();
		
		
		info("Verify that the application is moved successfully");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.checkPositions(pagCW.ELEMENT_CONTAINER_FOLLOWING_PORTLET,pagCW.ELEMENT_CONTAINER_PRECEDING_PORTLET);
		navMag.closeNavigationManagementPopup();
	
		info("Test Case 17: Delete an application when edit page...");
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
		
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.deleteApplication(newTitle);
		navMag.closeNavigationManagementPopup();
	}
	
	/**
	*<li> Case ID:123056.</li>
	*<li> Test Case Name: Add application into container when edit page properties of node.</li>
	*/
	@Test
	public void test18_AddApplicationIntoContainerWhenEditPagePropertiesOfNode(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);	
		
		String nodeName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String namePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String titlePage= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		info("Get information of an application");
		int index2 = appLayData.getRandomIndexByType(1);
		String idName = appLayData.newId.get(index2);
		String name = appLayData.newTitle.get(index2);

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
		
		info("Add a new node");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName,"");
		navMag.inputInfoPageSelector(namePage, titlePage, true,false,false);
		navMag.saveNode();
		
		info("Edit a node");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		pagCW.addContainer("oneRow");
		
		navMag.editNodePage(nodeName);
		pagCW.addApp("",name,pagCW.ELEMENT_APPLICATION_APPLICATION.replace("${name}",idName),pagCW.ELEMENT_DROP_SOURCE_HAS_LAYOUT_BY_NAME.replace("${name}","Container"));
		info("Click on Save button");
		click(navMag.ELEMENT_NAVIGATION_MANAGEMENT_SAVE);
		
		info("Verify that the application is added successfully in the container");
		groupManage.editNavigation(groupAdmin);
		navMag.editNodePage(nodeName);
		waitForAndGetElement(pagCW.ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",name),3000,0);
		pagCW.switchViewMode(true);
		pagCW.saveChangesPageEditor();
		click(navMag.ELEMENT_NAVIGATION_MANAGEMENT_SAVE);
	}

	/**
	*<li> Case ID:123118.</li>
	*<li> Test Case Name: Cut and Paste Node.</li>
	*/
	@Test
	public void test06_CutAndPasteNode(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodeName1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nodeName2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

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
		info("Add a new node 1");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName1,"");
		navMag.saveNode();
		
		info("Add a new node 2");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName2,"");
		navMag.saveNode();
		
		info("Cut and paste a node");
		groupManage.editNavigation(groupAdmin);
		navMag.cutNode(nodeName1);
		navMag.pasteNode(nodeName2);
		
		info("Verify that node 2 has only one children is node1");
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_PARENT_CHILD_NODE.replace("${parent}",nodeName2).replace("${child}",nodeName1));
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_NUMBER_CHILD_NODES.replace("${parent}",nodeName2).replace("${numberChild}","1"));
		navMag.closeNavigationManagementPopup();
		
		info("Verify that node 1 is only one avaiable");
		groupManage.editNavigation(groupAdmin);
		waitForElementNotPresent(navMag.ELEMENT_NAVIGATION_PARENT_NODE.replace("${parent}",nodeName1));
		navMag.closeNavigationManagementPopup();
	}

	/**
	*<li> Case ID:123118.</li>
	*<li> Test Case Name: Cut and Paste Node.</li>
	*/
	@Test
	public void test07_CloneAndPasteNode(){
		String groupAdmin = defaultGroupData.getDefaultGroupsByIndex(1);
		String nodeName1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nodeName2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
	
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
		info("Add a new node 1");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName1,"");
		navMag.saveNode();
		
		info("Add a new node 2");
		groupManage.editNavigation(groupAdmin);
		navMag.addNode(nodeName2,"");
		navMag.saveNode();
		
		info("Cut and paste a node");
		groupManage.editNavigation(groupAdmin);
		navMag.cloneNode(nodeName1);
		navMag.pasteNode(nodeName2);
		
		info("Verify that node 2 has only one children is node1");
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_PARENT_CHILD_NODE.replace("${parent}",nodeName2).replace("${child}",nodeName1));
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_NUMBER_CHILD_NODES.replace("${parent}",nodeName2).replace("${numberChild}","1"));
		navMag.closeNavigationManagementPopup();
		
		info("Verify that node 1 is more one avaiable");
		groupManage.editNavigation(groupAdmin);
		waitForAndGetElement(navMag.ELEMENT_NAVIGATION_PARENT_NODE.replace("${parent}",nodeName1));
		navMag.closeNavigationManagementPopup();
	}
}