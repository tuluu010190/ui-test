package org.exoplatform.selenium.platform.ks.functional.forum.administration;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.TestLogger.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;

import java.io.IOException;
import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thuntn
 * @date: 05/12/2012
 */
public class KS_Forum_Administration_AutoPrune extends ForumBase {
	public static final String DATA_CATEGORY = "//a[@title='{$category}']";
	public static String MSG_DRY_RUN = "1 topics would be pruned";

	//Set Auto-Prune when inputting number into inactive day field
	@Test
	public void test01_SetAutoPruneWithInactiveDay() {
		String cateTitle= "AutoPrune Category 01";
		String[] audience = {};
		String forum = "AutoPrune Forum 01";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "AutoPrune Topic 01";
		String[] user_topic = {};
		By ELEMENT_SETTING = By.xpath(ELEMENT_PRUNE_SETTING.replace("${category}", cateTitle).replace("{$forum}",forum));

		info("Set Auto-Prune when inputting number into an inactive day field");

		//Add a category, forum, topic
		addCategoryInForum(cateTitle,"1",0,audience,cateTitle,0);
		addForum(cateTitle,add, 0, userGroup, true, "", "", false, 0);		
		startTopic(topic, topic, "", "", "", "", "", "", 0,user_topic );

		//Set Auto-prune 
		goToPruneManagement();
		pruneSetting(cateTitle,forum,"1","days","","");
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);

		//check to set auto prune successfully, its value is 1
		click(ELEMENT_SETTING);

		assert waitForAndGetElement(ELEMENT_PRUNE_ACTIVE_DAY).getAttribute("value").equals("1"): "Fail to Set Auto-Prune!" ;
		close();
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);
		close();

		//delete data
		click(DATA_CATEGORY.replace("{$category}", cateTitle));
		deleteCategory(cateTitle);
	}

	//Set Auto-Prune when inputting some text into an inactive day field
	@Test
	public void test02_SetAutoPruneWithInvalidInactiveDay() {
		String cateTitle= "AutoPrune Category 02";
		String[] audience = {};
		String forum = "AutoPrune Forum 02";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "AutoPrune Topic 02";
		String[] user_topic = {};
		By ELEMENT_SETTING = By.xpath(ELEMENT_PRUNE_SETTING.replace("${category}", cateTitle).replace("{$forum}",forum));

		info("Set Auto-Prune when inputting some text into an inactive day field");

		//Add a category, a forum, a topic in Forum
		addCategoryInForum(cateTitle,"1",0,audience,cateTitle,0);
		addForum(cateTitle,add, 0, userGroup, true, "", "", false, 0);		
		startTopic(topic, topic, "", "", "", "", "", "", 0,user_topic );

		//Set Auto-Prune
		goToPruneManagement();
		pruneSetting(cateTitle,forum,"prune","days","","");
		waitForMessage(MSG_PRUNE_INVALID_INACTIVE_DAY);
		closeMessageDialog();
		close();
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);

		//check to set auto prune successfully: its value is 0 
		click(ELEMENT_SETTING);
		assert waitForAndGetElement(ELEMENT_PRUNE_ACTIVE_DAY).getAttribute("value").equals("0"): "Fail to Set Auto-Prune!" ;
		close();
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);
		close();

		//delete data
		click(DATA_CATEGORY.replace("{$category}", cateTitle));
		deleteCategory(cateTitle);
	}

	//Set Auto-Prune when input number into Run prune every  field
	@Test
	public void test03_SetAutoPruneWithInvalidInactiveDay() {
		String cateTitle= "AutoPrune Category 03";
		String[] audience = {};
		String forum = "AutoPrune Forum 03";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "AutoPrune Topic 03";
		String[] user_topic = {};
		By ELEMENT_SETTING = By.xpath(ELEMENT_PRUNE_SETTING.replace("${category}", cateTitle).replace("{$forum}",forum));

		info("Set Auto-Prune when input number into Run prune every  field");

		//Add a category, a forum, a topic in Forum
		addCategoryInForum(cateTitle,"1",0,audience,cateTitle,0);
		addForum(cateTitle,add, 0, userGroup, true, "", "", false, 0);		
		startTopic(topic, topic, "", "", "", "", "", "", 0,user_topic );

		//Set Auto-Prune
		goToPruneManagement();
		pruneSetting(cateTitle,forum,"1","days","1","weeks");
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);

		//check to set auto prune successfully: its value is 1 
		click(ELEMENT_SETTING);
		assert waitForAndGetElement(ELEMENT_PRUNE_JOB_DAY).getAttribute("value").equals("1"): "Fail to Set Auto-Prune!" ;
		close();
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);
		close();

		//delete data
		click(DATA_CATEGORY.replace("{$category}", cateTitle));
		deleteCategory(cateTitle);
	}
	//Set Auto-Prune when input some text into Run prune every field
	@Test
	public void test04_SetAutoPruneWithInvalidInactiveDay() {
		String cateTitle= "AutoPrune Category 04";
		String[] audience = {};
		String forum = "AutoPrune Forum 04";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "AutoPrune Topic 04";
		String[] user_topic = {};
		By ELEMENT_SETTING = By.xpath(ELEMENT_PRUNE_SETTING.replace("${category}", cateTitle).replace("{$forum}",forum));

		info("Set Auto-Prune when input some text into Run prune every field");

		//Add a category, a forum, a topic in Forum
		addCategoryInForum(cateTitle,"1",0,audience,cateTitle,0);
		addForum(cateTitle,add, 0, userGroup, true, "", "", false, 0);		
		startTopic(topic, topic, "", "", "", "", "", "", 0,user_topic );

		//Set Auto-Prune
		goToPruneManagement();
		pruneSetting(cateTitle,forum,"1","days","prune","weeks");
		waitForMessage(MSG_PRUNE_INVALID_JOB_DAY);
		closeMessageDialog();
		close();
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);

		//check to set auto prune successfully: its value is 0
		click(ELEMENT_SETTING);
		assert waitForAndGetElement(ELEMENT_PRUNE_JOB_DAY).getAttribute("value").equals("0"): "Fail to Set Auto-Prune!" ;
		close();
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);
		close();
		
		//delete data
		click(DATA_CATEGORY.replace("{$category}", cateTitle));
		deleteCategory(cateTitle);
				
	}
	//Test Auto-Prune in case Forum contains some topics which don't have new post
	@Test(groups={"pending"})
	public void test05_SetAutoPruneWithInvalidInactiveDay() throws IOException {
		String cateTitle= "AutoPrune Category 05";
		String[] audience = {};
		String forum = "AutoPrune Forum 05";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "AutoPrune Topic 05";
		String[] user_topic = {};
		By ELEMENT_SETTING = By.xpath(ELEMENT_PRUNE_SETTING.replace("${category}", cateTitle).replace("{$forum}",forum));

		info("Test Auto-Prune in case Forum contains some topics which don't have new post");
		
		Runtime.getRuntime().exec("date -s \"04 DEC 2012 10:00:00\"");
		
		//Add a category, a forum, a topic in Forum
		addCategoryInForum(cateTitle,"1",0,audience,cateTitle,0);
		addForum(cateTitle,add, 0, userGroup, true, "", "", false, 0);		
		
		startTopic(topic, topic, "", "", "", "", "", "", 0,user_topic );

		Runtime.getRuntime().exec("date -s \"06 DEC 2012 10:00:00\"");
		//Set Auto-Prune
		goToPruneManagement();
		pruneSetting(cateTitle,forum,"1","days","1","days");
		waitForElementNotPresent(ELEMENT_PRUNE_SETTING_POPUP);

		//check to set auto prune successfully: its value is 0
		click(ELEMENT_SETTING);
		click(ELEMENT_PRUNE_DRY_RUN);
		waitForTextPresent(MSG_DRY_RUN);
		close();

		//delete data
		click(DATA_CATEGORY.replace("{$category}", cateTitle));
		deleteCategory(cateTitle);
	}
	//Test Auto-Prune in case Forum contains some topics which don't have new post
	@Test
	public void test07_SetAutoPruneWithInvalidInactiveDay() {
		String cateTitle= "AutoPrune Category 07";
		String[] audience = {};
		String forum = "AutoPrune Forum 07";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String topic = "AutoPrune Topic 07";
		String[] user_topic = {};
		info("Test Auto-Prune in case Forum contains some topics which don't have new post");

		//Add a category, a forum, a topic in Forum
		addCategoryInForum(cateTitle,"1",0,audience,cateTitle,0);
		addForum(cateTitle,add, 0, userGroup, true, "", "", false, 0);		

		startTopic(topic, topic, "", "", "", "", "", "", 0,user_topic );

		//Set Auto-Prune
		goToPruneManagement();
		click(ELEMENT_PRUNE_RUN.replace("${category}", cateTitle).replace("{$forum}",forum));
		waitForMessage(MSG_PRUNE_NOT_CONFIG);
		closeMessageDialog();
		close();
		
		//delete data
		click(DATA_CATEGORY.replace("{$category}", cateTitle));
		deleteCategory(cateTitle);
	}
	@BeforeMethod
	public void beforeTest(){
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
}
