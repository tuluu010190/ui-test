package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;

/**
* @author cmugnier
* @date 20/01/2015
*/

public class Forum_Administration extends Forum_TestConfig {
	/**
	 *<li> Case ID:116690.</li>
	 *<li> Test Case Name: Ban IP.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test(groups="pending")
	public void test01_BanIP() {
		info("Test 1: Ban IP");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description:
		 *Step 1: Add Ban IP
		 *Input Data:
		 *- click on Administration menu and select â€œBan IP
		 *- Add IP into list and click on â€œAddâ€
		 *Expected Outcome:
		 *Ban IP is added successfully to listBan IP user can not add post/create topic*/
		hp.goToForum();
		click(forumHP.ELEMENT_ACTIONBAR_ADMINISTRATION);
		click(forumHP.ELEMENT_ACTIONBAR_ADMIN_BANIP);
	}
	/**
	 *<li> Case ID:116709.</li>
	 *<li> Test Case Name: Add BB code.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 **<li> Case ID:116710.</li>
	 *<li> Test Case Name: Edit BB code.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 **<li> Case ID:116711.</li>
	 *<li> Test Case Name: Delete BB code.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public void test02_03_04_AddEditDeleteBBCode() {
		info("Test 2: Add BB code");
		info("Create data test");
		String tag = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String replacement = "<b>{param}</b>.";
		String example = "<b>"+txData.getContentByArrayTypeRandom(1)+getRandomNumber()+"</b>.";
		String example2 = "<b>"+txData.getContentByArrayTypeRandom(1)+getRandomNumber()+"</b>.";
		info("Finished creating data test");
		/*Step Number: 1
		 *Step Name: Go To BB code manage
		 *Step Description:
		 *- Click on Administration menu and select"BB Code"
		 *Input Data:
		 *Expected Outcome:
		 *BB code management screen is shown.*/
		/*Step number: 2
		 *Step Name: Add BB Code
		 *Step Description:
		 *- Click on Add BBCode
		 *- Enter data into fields
		 *- Save
		 *Input Data:
		 *Expected Outcome:
          BB code is added successfully*/
		info("Go to Forum portlet");
		hp.goToForum();
		info("Add BBcode");
		forumHP.addBBCode(tag, replacement, "", example, false);
		info("BBcode is created successfully");
		info("Test 03: Edit BB code");
		info("Edit a BBCode");
		forumHP.editBBCode(tag, replacement, "", example2, false);
		info("BBcode is edited with changes successfully");
		info("Test 04: Delete BB code");
		info("Delete BBcode");
		forumHP.deleteBBcode(tag);
	}
}
