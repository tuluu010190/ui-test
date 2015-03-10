package org.exoplatform.selenium.platform.gatein.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * @date 19 March 2015
 * @author tult
 *
 */

public class Gatein_Group_Navigation_Manage_Navigation extends GateIn_TestConfig {

	/**
	 * Test Case ID:123103.
	 * Test Case Name: Show group navigation list
	 * Test Case ID:123104.
	 * Test Case Name: Add Navigation of group.
	 * Test Case ID:123043.
	 * Test Case Name: Manage Navigation of group.
	 */
	@Test
	public void test01_02_03_Show_Add_ManageGroupNavigation(){
		String groupName = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String group1= groupNameData.getGroupNameByIndex(0);
		String group2= groupNameData.getGroupNameByIndex(1);
		String group3= groupNameData.getGroupNameByIndex(2);
		String group4= groupNameData.getGroupNameByIndex(3);
		String group5= groupNameData.getGroupNameByIndex(4);
		
		info("Create new group with John");
		navToolBar.goToUsersAndGroupsManagement();
		userAndGroup.chooseGroupTab();
		userAndGroup.addGroup(groupName, groupName, groupName, true);
		
		/*Step Number: 1
		 *Step Name: Show Navigation list for group
		 *Step Description: 
			- Go to Administration/Portal/Group Sites 
		 *Input Data: 
		 *Expected Outcome: 
			- Show group navigation list*/
		info("Test Case 01: Show navigation list default of user John");
		navToolBar.goToGroupSites();
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group1));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group2));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group3));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group4));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group5));
		
		/*Step Number: 2
		 *Step Name: Add Navigation of group
		 *Step Description: 
			- Go to Administration/ Portal / Group Sites
			- Click Add Navigation button
			- Select a navigation in list and click  Add navigation icon
		 *Input Data: 
		 *Expected Outcome: 
			- Add Navigation successfully*/
		info("TestCase 02: Add new navigation for new group");
		groupNavigate.addNewNavigationForGroup(groupName);
		
		info("Show navigation list after add a new group of user John");
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}", groupName));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group1));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group2));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group3));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group4));
		waitForAndGetElement(groupNavigate.ELEMENT_GROUP_NAME.replace("${groupName}",group5));
		
		/*Step Number: 3
		 *Step Name: Delete Navigation of group
		 *Step Description: 
			- Go to Administration/ Portal / Group Sites
			- Click Delete Navigation button of a Group
		 *Input Data: 
		 *Expected Outcome: 
			- The navigation group is removed successfully*/
		info("Delete navigation of group");
		groupNavigate.deleteNavigationForGroup(groupName);
		
		info("Delete group");
		navToolBar.goToUsersAndGroupsManagement();
		userAndGroup.chooseGroupTab();
		click(By.linkText(groupName));
		userAndGroup.deleteGroup(groupName, true, 60000);
	}
}











