package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class GateIn_Dashboard extends GateIn_TestConfig {



	/**
	 *<li> Case ID:123034.</li>
	 *<li> Test Case Name: Drag and drop gadget.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 *<li> Case ID:123081.</li>
	 *<li> Test Case Name: Delete gadget.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_02_DragAndDrop_DeleteGadget() {
		info("Test 1: Drag and drop gadget");
		int index = gadData.getRandomIndexByType(6);
		String name = gadData.newName.get(index);
		/*Step Number: 1
		 *Step Name: Step 1: Drag and drop gadget
		 *Step Description: 
			- Choose Dashboard
			- Click Add gadget
			- Select a gadget in list and drag & drop into new place
		 *Input Data: 

		 *Expected Outcome: 
			- The gadget is dragged and dropped to new place successfully*/ 
		navToolBar.goToMyDashboard();
		myDash.addGadget(name,"1");
		
		info("Test 02: Delete gadget");
		myDash.deleteGadget(name);
	}

	/**
	 *<li> Case ID:123037.</li>
	 *<li> Test Case Name: Change container when edit layout for user's page.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 */
	@Test
	public  void test03_ChangeContainerWhenEditLayoutForUsersPage() {
		info("Test 03: Change container when edit layout for user's page");

		String title=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		 *Step Name: Step 1: Change container when edit layout for user's page
		 *Step Description: 
			- Select a page and click Edit layout
			- Select Container tab from edit inline composer
			- Add container by drag & drop
			- Edit/delete/move container
			- Switch view mode
		 *Input Data: 

		 *Expected Outcome: 
			- Add container successfully
			- The container is updated with the change value
			- The container is removed successfully
			- The container is move to new place
			- The Layout of page is displayed in the view mode with all changes*/ 

		info("Add a new container");
		navToolBar.goToMyDashboard();
		navToolBar.goToEditLayout();
		pagCW.addContainer("oneRow");
		info("Edit a container");
		
		navToolBar.goToEditLayout();
		pagCW.editContainer("Container",title, "","");
		
		info("Move a container to new place");
		navToolBar.goToEditLayout();
		pagCW.moveContainer(title,pagCW.ELEMENT_CONTAINER_HOLDER_MOVE,pagCW.ELEMENT_PORTLET,87);
		
		info("Verify that the container is changed the position");
		navToolBar.goToEditLayout();
		pagCW.checkPositions(pagCW.ELEMENT_CONTAINER_PRECEDING_PORTLET,pagCW.ELEMENT_CONTAINER_FOLLOWING_PORTLET);
			
		info("Delete a container");
		navToolBar.goToEditLayout();
		pagCW.deleteContainer(title);
	}

	/**
	 *<li> Case ID:123038.</li>
	 *<li> Test Case Name: Change application when edit layout for user's page.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_ChangeApplicationWhenEditLayoutForUsersPage() {
		info("Test 04: Change application when edit layout for user's page");
		int index = appLayData.getRandomIndexByType(1);
		String idName = appLayData.newId.get(index);
		String name = appLayData.newTitle.get(index);
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		 *Step Name: Step 1: Change application when edit layout for user's page
		 *Step Description: 
			- Select a page and click Edit layout
			- Select Application tab from edit inline composer
			- Add application by drag & drop
			- Add/edit/delete/move application
			- Switch view mode
		 *Input Data: 

		 *Expected Outcome: 
			- Add container successfully
			- The container is updated with the change value
			- The container is removed successfully
			- The container is move to new place
			- The Layout of page is displayed in the view mode with all changes*/
		info("Add an application to the layout");
		navToolBar.goToMyDashboard();
		navToolBar.goToEditLayout();
		pagCW.addApp(name,pagCW.ELEMENT_APPLICATION_APPLICATION.replace("${name}",idName),pagCW.ELEMENT_PAGEEDITOR_VIEWPAGE);
		
		info("Edit an application");
		navToolBar.goToEditLayout();
		pagCW.editApplication(name,newTitle,"","");
		pagCW.saveChangesApplication();
		pagCW.saveChangesPageEditor();
		
		info("Move an application to new place");
		navToolBar.goToEditLayout();
		pagCW.moveApplication(newTitle,"Dashboard Portlet",87);
		navToolBar.goToEditLayout();
		pagCW.checkPositions(pagCW.ELEMENT_APPLICATION_PRECEDING_PORTLET.replace("${app1}","Dashboard Portlet").replace("${app2}", newTitle),pagCW.ELEMENT_APPLICATION_FOLLOWING_PORTLET.replace("${app1}","Dashboard Portlet").replace("${app2}", newTitle));
		
		info("Delete an application");
		navToolBar.goToEditLayout();
		pagCW.deleteApplication(newTitle);
	}

	/**
	 *<li> Case ID:123039.</li>
	 *<li> Test Case Name: Add application into container when edit layout for user's page.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test05_AddApplicationIntoContainerWhenEditLayoutForUsersPage() {
		info("Test 05: Add application into container when edit layout for user's page");
		int index = appLayData.getRandomIndexByType(1);
		String idName = appLayData.newId.get(index);
		String name = appLayData.newTitle.get(index);
		/*Step Number: 1
		 *Step Name: Step 1: Add application into container when edit layout for user's page
		 *Step Description: 
			- Select a page and click Edit layout
			- Add container by drag & drop
			- Drag & drop application into the container added above
			- Switch view mode
		 *Input Data: 

		 *Expected Outcome: 
			- Add application into container successfully
			- The layout of page is displayed in the view mode with all changes*/ 
		info("Add an application into the container");
		navToolBar.goToMyDashboard();
		navToolBar.goToEditLayout();
		pagCW.addContainer("oneRow");
		navToolBar.goToEditLayout();
		pagCW.addApp(name,pagCW.ELEMENT_APPLICATION_APPLICATION.replace("${name}",idName),pagCW.ELEMENT_DROP_SOURCE_HAS_LAYOUT_BY_NAME.replace("${name}","Container"));
		info("Delete container");
		navToolBar.goToEditLayout();
		pagCW.deleteContainer("Container");
	}

	/**
	 *<li> Case ID:123057.</li>
	 *<li> Test Case Name: Add gadget.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test06_AddGadget() {
		info("Test 06: Add gadget");
        int index = remoteGadData.getRandomIndexByType(1);
		String url = remoteGadData.newLinks.get(index);//"http://www.labpixies.com/campaigns/finance/finance.xml";
        String name = remoteGadData.newTitle.get(index);
		/*Step Number: 1
		 *Step Name: Step 1: Add/Edit/Delete gadget
		 *Step Description: 
			- Choose Dashboard
			- Click Add gadget
			- Input remote gadget link (ex: http://www.labpixies.com/campaigns/finance/finance.xml)
			- Add a gadget into Dashboard
		 *Input Data: 

		 *Expected Outcome: 
			- Gadget is added successfully*/ 
		navToolBar.goToMyDashboard();
		myDash.addRemoteGadget(url, name);
		myDash.deleteGadget(name);
	}

	/**
	 *<li> Case ID:123058.</li>
	 *<li> Test Case Name: Add new tab.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 *<li> Case ID:123082.</li>
	 *<li> Test Case Name: Rename tab.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 *<li> Case ID:123083.</li>
	 *<li> Test Case Name: Delete tab.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 */
	@Test
	public  void test07_08_09_AddRenameDeleteNewTab() {
		info("Test 07: Add new tab");
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		 *Step Name: Step 1: Add new tab
		 *Step Description: 
			- Click Add a tab
			- Input name for new tab
			- Hit enter
		 *Input Data: 

		 *Expected Outcome: 
			- Add tab successfully*/ 
		navToolBar.goToMyDashboard();
		myDash.addTab(name);

		//rename tab
		myDash.renameTab(name,newName);
		
		//delete tab
		myDash.deleteTab(newName);
	}
}