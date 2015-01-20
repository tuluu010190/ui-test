package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.acme.AcmeHomePage;
import org.exoplatform.selenium.platform.forum.ForumHomePage;
import org.exoplatform.selenium.platform.objectdatabase.common.AttachmentFileDatabase;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.testng.annotations.*;

/**
* @author cmugnier
* @date 20/01/2015
*/

public class Forum_Administration extends PlatformBase {
	
	HomePagePlatform hp;
	ManageLogInOut magAc;
	ManageAlert magAlert;
	Button but;
	TextBoxDatabase txData;
	NavigationToolbar navTool;
	AcmeHomePage acmeHP;
	AttachmentFileDatabase fData;
	ForumHomePage forumHP;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,true,jdbcDriver,dbUrl,user,pass,sqlUser);
		driver.get(baseUrl);
		magAc = new ManageLogInOut(driver);
		but = new Button(driver);
		hp = new HomePagePlatform(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		navTool = new NavigationToolbar(driver);
		acmeHP = new AcmeHomePage(driver);
		magAlert = new ManageAlert(driver, this.plfVersion);
		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		forumHP = new ForumHomePage(driver);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
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
Step 1: Add Ban IP
		 *Input Data:
- click on Administration menu and select â€œBan IPâ€
- Add IP into list and click on â€œAddâ€
		 *Expected Outcome:
Ban IP is added successfully to listBan IP user can not add post/create topic*/
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
- Click on Administration menu and select"BB Code"
		 *Input Data:
		 *Expected Outcome:
BB code management screen is shown.*/
		/*Step number: 2
		 *Step Name: Add BB Code
		 *Step Description:
- Click on Add BBCode
- Enter data into fields
- Save
		 *Input Data:
		 *Expected Outcome:
          BB code is added successfully*/
		//add
		info("Go to Forum portlet");
		hp.goToForum();
		info("Click on Administration menu");
		click(forumHP.ELEMENT_ACTIONBAR_ADMINISTRATION);
		info("Select BBCode");
		click(forumHP.ELEMENT_ACTIONBAR_ADMIN_BBCODE);
		info("Add BBcode");
		forumHP.AddBBCode(tag, replacement, "", example, false);
		info("Click on Save button and save all changes");
		click(hp.ELEMENT_EDITSITE_SAVEBTN);
		info("Verify that BBcode is created");
		waitForAndGetElement(forumHP.ELEMENT_BBCODE_TAG_VERIFY.replace("${tag}", tag.toUpperCase()));
		info("BBcode is created successfully");
		//edit
		info("Click on Edit BBcode");
		click(forumHP.ELEMENT_BBCODE_EDITBBCODE.replace("${tag}", tag.toUpperCase()));
		info("Edit a BBCode");
		forumHP.AddBBCode(tag, replacement, "", example2, false);
		info("click on Save button and save all changes");
		click(hp.ELEMENT_EDITSITE_SAVEBTN);
		info("Verify that BBcode is edited with changes");
		waitForAndGetElement(forumHP.ELEMENT_BBCODE_TAG_VERIFY.replace("${tag}", tag.toUpperCase()));
		info("BBcode is edited with changes successfully");
		//delete
		click(forumHP.ELEMENT_BBCODE_DELETEBBCODE.replace("${tag}", tag.toUpperCase()));
		click(forumHP.ELEMENT_BBCODE_CONFIRM_DELETETAG);
		waitForElementNotPresent(forumHP.ELEMENT_BBCODE_TAG_VERIFY.replace("${tag}", tag.toUpperCase()));
	}
}
