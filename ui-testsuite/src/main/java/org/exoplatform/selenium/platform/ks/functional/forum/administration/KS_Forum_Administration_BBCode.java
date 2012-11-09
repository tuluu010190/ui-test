package org.exoplatform.selenium.platform.ks.functional.forum.administration;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.*;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;
import static org.exoplatform.selenium.platform.ecms.EcmsBase.checkAlertWarning;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author lientm
 * @date: 26/11/2012
 */
public class KS_Forum_Administration_BBCode extends ForumBase {

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		goToForums();
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
		
	/*Case01: Activate a BB Code in list available 
	 * active a BBCode: Set text in bold
	 * check BBCode is applied for post
	 */
	@Test
	public void test01_ActiveBBCodeInList(){
		String category = "KS_Forum_Administration_BBCode_cat_01";
		String forum = "KS_Forum_Administration_BBCode_forum_01";
		String topic ="KS_Forum_Administration_BBCode_topic_01";
		String post_content = "KS_Forum_Administration_BBCode_post_01"; 
		String file_name = "KS_Forum_Administration_BBCode_tagB_applied";
		
		//active BBCode: Set text in bold
		goToBBCodeManagement();
		activeBBcode("B", true, false);
		
		//-----make a post using tag B----
		makeTopicFromCategory(category, forum, topic);
		
		//make a post
		quickReply("[B]" + post_content + "[/B]");
		waitForElementPresent(By.xpath("//strong[text()='" + post_content + "']"));
		captureScreen(file_name);
		
		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	
	/*case02: Deactivated a BB Code in list available
	 * deactivated a BBCode: Set text in bold
	 * check BBCode is not applied for post
	 */
	@Test
	public void test02_DeactivatedBBCodeInList(){
		String category = "KS_Forum_Administration_BBCode_cat_02";
		String forum = "KS_Forum_Administration_BBCode_forum_02";
		String topic ="KS_Forum_Administration_BBCode_topic_02";
		String post_content = "KS_Forum_Administration_BBCode_post_02"; 
		String file_name = "KS_Forum_Administration_BBCode_tagB_not_applied";
		
		//active BBCode: Set text in bold
		goToBBCodeManagement();
		activeBBcode("B", false, false);
		
		//-----make a post using tag B----
		makeTopicFromCategory(category, forum, topic);
		
		//make a post
		quickReply("[B]" + post_content + "[/B]");
		waitForTextPresent(post_content);
		waitForElementNotPresent(By.xpath("//strong[text()='" + post_content + "']"));
		captureScreen(file_name);
		
		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
		
		//active again BBCode
		goToBBCodeManagement();
		activeBBcode("B", true, false);
	}
	
	/*case03: Add a BB Code when input data valid
	 */
	@Test
	public void test03_AddBBCodeWhenInputDataValid(){
		String tag = "TAG_03";
		String replace = "<tag>{replace}</tag>";
		String description = "TAG_03";
		String example = "<tag>{replace}</tag>";
		
		//add a BBCode
		goToBBCodeManagement();
		addBBCode(tag, replace, description, example, false);
		waitForElementPresent(By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", tag)));
		waitForElementPresent(By.xpath(ELEMENT_BBCODE_EDIT_NO_OPTION.replace("${tag}", tag)));
		waitForElementPresent(By.xpath(ELEMENT_BBCODE_DELETE_NO_OPTION.replace("${tag}", tag)));
		
		//delete BBCode
		deleteBBcode(tag, false);
		close();
	}
	
	/*case04: Add a BB Code when Tag name field is blank 
	 */
	@Test
	public void test04_AddBBCodeWhenTagNameBlank(){
		String replace = "<tag>{replace}</tag>";
		String description = "TAG_04";
		String example = "<tag>{replace}</tag>";
		
		//Add a BB Code when Tag name field is blank
		goToBBCodeManagement();
		info("Add new BBcode");
		click(ELEMENT_BBCODE_ADD_BUTTON);
		waitForElementPresent(ELEMENT_BBCODE_ADD_POPUP);
		modifyBBcodeInfo("", replace, description, example, false);
		
		//check alert
		checkAlertWarning("The field \"Tag\" is required.");
		close();
		close();
	}
	
	/*case05: Add a BB Code when Replacement field is blank
	 */
	@Test
	public void test05_AddBBCodeWhenReplacementBlank(){
		String tag = "TAG_05";
		String description = "TAG_05";
		String example = "<tag>{replace}</tag>";
		
		//Add a BB Code when Replacement field is blank
		goToBBCodeManagement();
		info("Add new BBcode");
		click(ELEMENT_BBCODE_ADD_BUTTON);
		waitForElementPresent(ELEMENT_BBCODE_ADD_POPUP);
		modifyBBcodeInfo(tag, "", description, example, false);
		
		//check alert
		checkAlertWarning("The field \"Replacement\" is required.");
		close();
		close();
	}
	
	/*case06: Add a BB Code when Example field is blank
	 */
	@Test
	public void test06_AddBBCodeWhenExampleBlank(){
		String tag = "TAG_06";
		String replace = "<tag>{replace}</tag>";
		String description = "TAG_06";
		
		//Add a BB Code when Example field is blank
		goToBBCodeManagement();
		info("Add new BBcode");
		click(ELEMENT_BBCODE_ADD_BUTTON);
		waitForElementPresent(ELEMENT_BBCODE_ADD_POPUP);
		modifyBBcodeInfo(tag, replace, description, "", false);
		
		//check alert
		checkAlertWarning("The field \"Example\" is required.");
		close();
		close();		
	}
	
	/*case07: Cancel adding a BB Code
	 */
	@Test
	public void test07_CancelAddingBBCode(){
		String tag = "TAG_07";
		String replace = "<tag>{replace}</tag>";
		String description = "TAG_07";
		String example = "<tag>{replace}</tag>";
		
		//add a BBCode
		goToBBCodeManagement();
		click(ELEMENT_BBCODE_ADD_BUTTON);
		waitForElementPresent(ELEMENT_BBCODE_ADD_POPUP);
		type(ELEMENT_BBCODE_TAG, tag, true);
		type(ELEMENT_BBCODE_REPLACEMENT, replace, true);
		type(ELEMENT_BBCODE_DESCRIPTION, description, true);
		type(ELEMENT_BBCODE_EXAMPLE, example, true);
		close();
		
		//check BBCode is not created
		waitForTextNotPresent(tag.toUpperCase());
		waitForElementNotPresent(By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", tag)));
		waitForElementNotPresent(By.xpath(ELEMENT_BBCODE_EDIT_NO_OPTION.replace("${tag}", tag)));
		waitForElementNotPresent(By.xpath(ELEMENT_BBCODE_DELETE_NO_OPTION.replace("${tag}", tag)));
		info("BBCode is not created");
		close();
	}
	
	/*case08: Delete a BB Code which is default
	 * delete a BBCode default: B
	 * check BBCode haven't affect in all posts
	 * roll back delete
	 */
	@Test
	public void test08_DeleteBBCodeWhichIsDefault(){
		String tag = "B";
		String replace = "<strong>{param}</strong>";
		String description = "Set text in bold";
		String example = "[B]This text is bold[/B]";
		
		String category = "KS_Forum_Administration_BBCode_cat_08";
		String forum = "KS_Forum_Administration_BBCode_forum_08";
		String topic ="KS_Forum_Administration_BBCode_topic_08";
		String post_content = "KS_Forum_Administration_BBCode_post_08"; 
		String file_name = "KS_Forum_Administration_BBCode_tagB_deleted";
		
		//delete BBCode B
		goToBBCodeManagement();
		deleteBBcode(tag, false);
		close();
		
		//check BBCode haven't affect in all posts
		makeTopicFromCategory(category, forum, topic);
		quickReply("[B]" + post_content + "[/B]");
		waitForTextPresent(post_content);
		waitForElementNotPresent(By.xpath("//strong[text()='" + post_content + "']"));
		captureScreen(file_name);
		
		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
		
		//roll back BBCode
		goToBBCodeManagement();
		addBBCode(tag, replace, description, example, false);
		waitForElementPresent(By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", tag)));
		close();
	}
	
	/*case09: Delete a BB Code which is not default
	 * create new BBCode
	 * check BBCode is applied for post
	 * delete BBCode
	 * check BBCode is not applied for post
	 */
	@Test
	public void test09_DeleteBBCodeNotDefault(){
		String tag = "COLOR_RED";
		String replace = "<font color=red>{param}</font>";
		String description = "Set text is red color";
		String example = "[COLOR_RED]text[/COLOR_RED]";
		
		String category = "KS_Forum_Administration_BBCode_cat_09";
		String forum = "KS_Forum_Administration_BBCode_forum_09";
		String topic ="KS_Forum_Administration_BBCode_topic_09";
		String post_content = "KS_Forum_Administration_BBCode_post_09"; 
		String file_name = "KS_Forum_Administration_BBCode_tag_color_red";
		String file_name2 = "KS_Forum_Administration_BBCode_tag_color_not_red";
		
		//create new BBCode
		goToBBCodeManagement();
		addBBCode(tag, replace, description, example, false);
		waitForElementPresent(By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", tag)));
		close();
		
		//check BBCode is applied for post
		makeTopicFromCategory(category, forum, topic);
		quickReply("[COLOR_RED]" + post_content + "[/COLOR_RED]");
		waitForElementPresent(By.xpath("//font[@color='red' and text()='" + post_content + "']"));
		captureScreen(file_name);
		deletePost(post_content);
		
		//delete BBCode
		goToBBCodeManagement();
		deleteBBcode(tag, false);
		close();
		
		//check BBCode is not applied for post
		quickReply("[COLOR_RED]" + post_content + "[/COLOR_RED]");
		waitForTextPresent(post_content);
		waitForElementNotPresent(By.xpath("//font[@color='red' and text()='" + post_content + "']"));
		captureScreen(file_name2);
		
		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	
	/*case10: Cancel deleting BB Code
	 */
	@Test
	public void test10_CancelDeletingBBCode(){
		By ELEMENT_DELETE_NOT_OPTION = By.xpath(ELEMENT_BBCODE_DELETE_NO_OPTION.replace("${tag}", "JUSTIFY"));

		//cancel deleting a BBCode
		goToBBCodeManagement();
		click(ELEMENT_DELETE_NOT_OPTION);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		driver.switchTo().defaultContent();
		
		waitForElementPresent(ELEMENT_DELETE_NOT_OPTION);
		close();
	}
}