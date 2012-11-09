package org.exoplatform.selenium.platform.ks.functional.forum.administration;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import org.exoplatform.selenium.platform.ks.ForumBase;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.addCategoryInForum;
import static org.exoplatform.selenium.platform.ks.ForumManagement.addForum;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.TestLogger.info;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author hakt
 * @date: 06/12/2012
 */
public class KS_Forum_Administration_TopicTypes extends ForumBase {
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

	public static By ELEMENT_CANCEL=By.xpath("//a[@class='ActionButton LightBlueStyle' and text()='Cancel']");
	public static String MSG_TOPIC_TYPE_SAME_NAME="Topic type is existing.";

	/**
	 * Case 01: Add topic types without icon
	 * Go to Forum
	 * Click Administration
	 * Create topic type without icon
	 * Verify result: in topic type list, in topic type list when start topic
	 * Delete data
	 */
	@Test
	public static void test01_AddTopicTypeWithOutIcon(){
		String DATA_TOPIC_TYPE="Topic_Type_01";
		By ELEMENT_TOPIC_TYPE=By.xpath("//*[text()='"+DATA_TOPIC_TYPE+"']/ ../*//*[@class='Icon16x16 IconsView']");

		String DATA_CATEGORY_NAME="Category_01";
		String[] audience = {};

		String DATA_FORUM_NAME="Forum_01";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};

		By ELEMENT_TOPIC_TYPE_OPTION=By.xpath("//option[text()='"+DATA_TOPIC_TYPE+"']");


		info("Add topic type without icon");
		goToTopicTypes();
		createTopicType(DATA_TOPIC_TYPE, "", "");
		waitForElementPresent(ELEMENT_TOPIC_TYPE);
		close();

		//	Verify added topic type also displayed in Add/Edit topic form
		// Add new category
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		goToAddForum();
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);

		//	Go to Start topic 
		goToStartTopic();
		//	Go to Options tab
		click(ELEMENT_TOPIC_OPTIONS_TAB);
		click(ELEMENT_TOPIC_SELECT_TYPE);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_OPTION);
		click(ELEMENT_CANCEL);

		//	Delete data
		//	Delete Category & forum
		String JUMP_TO_CATEGORY="    "+DATA_CATEGORY_NAME+"";
		jumpTo(JUMP_TO_CATEGORY);
		deleteCategory(DATA_CATEGORY_NAME);
		//	Delete Topic type
		goToTopicTypes();
		deleteTopicType(DATA_TOPIC_TYPE);
		close();
	}

	/**
	 * Case 02: Add topic types with icon
	 * Go to Forum
	 * Click Administration
	 * Create topic type with icon
	 * Verify result: in topic type list, in topic type list when start topic
	 * Delete data
	 */
	@Test
	public static void test02_AddTopicTypeWithIcon(){
		String DATA_TOPIC_TYPE="Topic_Type_02";
		String DATA_GROUP_ICON="Tool Icons";
		String DATA_ICON_CLASS="Icon Shuttlecock";
		By ELEMENT_TOPIC_TYPE=By.xpath("//*[text()='"+DATA_TOPIC_TYPE+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");

		String DATA_CATEGORY_NAME="Category_02";
		String[] audience = {};

		String DATA_FORUM_NAME="Forum_02";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};

		By ELEMENT_TOPIC_TYPE_OPTION=By.xpath("//option[text()='"+DATA_TOPIC_TYPE+"']");

		info("Add topic type with icon");
		goToTopicTypes();

		createTopicType(DATA_TOPIC_TYPE, DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForElementPresent(ELEMENT_TOPIC_TYPE);
		close();

		//	Verify added topic type also displayed in Add/Edit topic form
		// Add new category
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		goToAddForum();
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);

		//	Go to Start topic 
		goToStartTopic();
		//	Go to Options tab
		click(ELEMENT_TOPIC_OPTIONS_TAB);
		click(ELEMENT_TOPIC_SELECT_TYPE);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_OPTION);
		click(ELEMENT_CANCEL);

		//	Delete data
		//	Delete Category & forum
		String JUMP_TO_CATEGORY="    "+DATA_CATEGORY_NAME+"";
		jumpTo(JUMP_TO_CATEGORY);
		deleteCategory(DATA_CATEGORY_NAME);
		//	Delete Topic type
		goToTopicTypes();
		deleteTopicType(DATA_TOPIC_TYPE);
		close();
	}

	/**
	 * Case 03: Add topic types with blank name
	 * Go to Forum
	 * Click Administration
	 * Click Topic Type
	 * Leave Type box blank
	 * Choose icon
	 * Click Save, warning message title is required
	 */
	@Test
	public static void test03_AddTopicTypeWithBlankName(){
		String MSG_BLANK_TOPIC_TYPE_NAME="The field \"Type\" is required.";

		String DATA_GROUP_ICON="Tool Icons";
		String DATA_ICON_CLASS="Icon Shuttlecock";

		info("Add topic types with blank name");
		goToTopicTypes();
		createTopicType("", DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForTextPresent(MSG_BLANK_TOPIC_TYPE_NAME);
		click(ELEMENT_OK_BUTTON);
		click(ELEMENT_CANCEL);
		close();
	}

	/**
	 * Case 04: Add topic types with same name
	 * Go to Forum
	 * Click Administration
	 * Create topic types with same name
	 * Verify warning message
	 * Delete data
	 */
	@Test
	public static void test04_AddTopicTypeWithSameName(){
		String DATA_TOPIC_TYPE="Topic_Type_04";
		String DATA_GROUP_ICON="Tool Icons";
		String DATA_ICON_CLASS="Icon Shuttlecock";
		By ELEMENT_TOPIC_TYPE=By.xpath("//*[text()='"+DATA_TOPIC_TYPE+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");

		info("Add topic type with same name");
		goToTopicTypes();

		createTopicType(DATA_TOPIC_TYPE, DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForElementPresent(ELEMENT_TOPIC_TYPE);

		pause(1000);

		createTopicType(DATA_TOPIC_TYPE, DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForTextPresent(MSG_TOPIC_TYPE_SAME_NAME);
		click(ELEMENT_OK_BUTTON);
		click(ELEMENT_CANCEL);

		//		Delete data
		deleteTopicType(DATA_TOPIC_TYPE);
		close();
	}

	/**
	 * Case 05: Add 2 topic types with same icon
	 * Go to Forum
	 * Click Administration
	 * Create 2 topic types with same icon
	 * Verify
	 * Delete data all topic types
	 */
	@Test
	public static void test05_011_Add2TopicTypesWithSameIconThenDelete(){
		String DATA_TOPIC_TYPE_1="Topic_Type_05_1";
		String DATA_TOPIC_TYPE_2="Topic_Type_05_2";
		String DATA_GROUP_ICON="Tool Icons";
		String DATA_ICON_CLASS="Icon Shuttlecock";
		By ELEMENT_TOPIC_TYPE_1=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_1+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");
		By ELEMENT_TOPIC_TYPE_2=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_2+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");

		info("Add 2 topic types with same icon");
		goToTopicTypes();

		createTopicType(DATA_TOPIC_TYPE_1, DATA_GROUP_ICON, DATA_ICON_CLASS);

		pause(1000);

		createTopicType(DATA_TOPIC_TYPE_2, DATA_GROUP_ICON, DATA_ICON_CLASS);

		//		Verify 2 topic types have same icon
		waitForElementPresent(ELEMENT_TOPIC_TYPE_1);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_2);

		//		Delete data
		deleteTopicType(DATA_TOPIC_TYPE_1);
		deleteTopicType(DATA_TOPIC_TYPE_2);
		close();
	}

	/**
	 * Case 06: Cancel adding topic type
	 * Go to Forum
	 * Click Administration
	 * Create topic type then click cancel
	 * Verify result
	 * Delete data
	 */
	@Test
	public static void test06_CancelAddingTopicType(){
		String DATA_TOPIC_TYPE="Topic_Type_06";
		String DATA_GROUP_ICON="Tool Icons";
		String DATA_ICON_CLASS="Icon Shuttlecock";
		By ELEMENT_TOPIC_TYPE=By.xpath("//*[text()='"+DATA_TOPIC_TYPE+"']/ ../*//*[@class='Icon16x16 IconsView']");

		info("Cancel adding topic type");
		goToTopicTypes();
		click(ELEMENT_ADD_TOPIC_TYPE_BUTTON);
		waitForElementPresent(ELEMENT_TOPIC_ADD_TYPE_POPUP);
		type(ELEMENT_TOPIC_TYPE_NAME, DATA_TOPIC_TYPE, true);
		chooseIcon(DATA_GROUP_ICON, DATA_ICON_CLASS);
		click(ELEMENT_CANCEL);
		waitForElementNotPresent(ELEMENT_TOPIC_TYPE);
		close();
	}

	/**
	 * Case 07: Edit topic type just change name
	 * Go to Forum
	 * Click Administration
	 * Create topic type
	 * Edit topic type, just change name
	 * Verify result
	 * Delete data
	 */
	@Test
	public static void test07_EditTopicTypesWithChangingName(){
		String DATA_TOPIC_TYPE="Topic_Type_07";
		String DATA_TOPIC_TYPE_EDITED="Topic_Type_07_Edited";
		String DATA_GROUP_ICON="Tool Icons";
		String DATA_ICON_CLASS="Icon Shuttlecock";
		By ELEMENT_TOPIC_TYPE=By.xpath("//*[text()='"+DATA_TOPIC_TYPE+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");
		By ELEMENT_TOPIC_TYPE_EDITED=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_EDITED+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");
		info("Edit topic types: changing name");
		goToTopicTypes();

		createTopicType(DATA_TOPIC_TYPE, DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForElementPresent(ELEMENT_TOPIC_TYPE);

		editTopicType(DATA_TOPIC_TYPE, DATA_TOPIC_TYPE_EDITED, DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_EDITED);

		//		Delete data
		deleteTopicType(DATA_TOPIC_TYPE_EDITED);
		close();
	}

	/**
	 * Case 08: Edit topic type with the same name as an existing one
	 * Go to Forum
	 * Click Administration
	 * Create 2 topic types
	 * Edit topic 2: Change name the same as topic type 1 
	 * Verify result
	 * Delete data
	 */
	@Test
	public static void test08_EditTopicTypeWithTheSameNameAsExistingOne(){
		String DATA_TOPIC_TYPE_1="Topic_Type_08_1";
		String DATA_TOPIC_TYPE_2="Topic_Type_08_2";
		String DATA_GROUP_ICON="Tool Icons";
		String DATA_ICON_CLASS="Icon Shuttlecock";
		By ELEMENT_TOPIC_TYPE_1=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_1+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");
		By ELEMENT_TOPIC_TYPE_2=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_2+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");

		info("Edit topic type with the same name as an existing one");

		goToTopicTypes();

		createTopicType(DATA_TOPIC_TYPE_1, DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_1);

		pause(1000);

		createTopicType(DATA_TOPIC_TYPE_2, DATA_GROUP_ICON, DATA_ICON_CLASS);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_2);


		editTopicType(DATA_TOPIC_TYPE_2, DATA_TOPIC_TYPE_1, DATA_GROUP_ICON, DATA_ICON_CLASS);

		waitForTextPresent(MSG_TOPIC_TYPE_SAME_NAME);
		click(ELEMENT_OK_BUTTON);
		click(ELEMENT_CANCEL);

		//		Delete data
		deleteTopicType(DATA_TOPIC_TYPE_1);
		deleteTopicType(DATA_TOPIC_TYPE_2);
		close();
	}

	/**
	 * Case 09: Edit topic type just change icon
	 * Go to Forum
	 * Click Administration
	 * Create topic type
	 * Edit topic type, just change icon
	 * Verify result
	 * Delete data
	 */
	@Test
	public static void test09_EditTopicTypesWithChangingIcon(){
		String DATA_TOPIC_TYPE="Topic_Type_09";
		String DATA_GROUP_ICON_1="Tool Icons";
		String DATA_ICON_CLASS_1="Icon Shuttlecock";
		String DATA_GROUP_ICON_2="Office Icons";
		String DATA_ICON_CLASS_2="Icon Date";
		By ELEMENT_TOPIC_TYPE=By.xpath("//*[text()='"+DATA_TOPIC_TYPE+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");
		By ELEMENT_TOPIC_TYPE_EDITED=By.xpath("//*[text()='"+DATA_TOPIC_TYPE+"']/ ../*//*[@class='Icon16x16 Date']");

		info("Edit topic types: changing icon");
		goToTopicTypes();

		createTopicType(DATA_TOPIC_TYPE, DATA_GROUP_ICON_1, DATA_ICON_CLASS_1);
		waitForElementPresent(ELEMENT_TOPIC_TYPE);

		editTopicType(DATA_TOPIC_TYPE, DATA_TOPIC_TYPE, DATA_GROUP_ICON_2, DATA_ICON_CLASS_2);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_EDITED);

		//		Delete data
		deleteTopicType(DATA_TOPIC_TYPE);
		close();
	}

	/**
	 * Case 10: Edit topic type with the same icon as existing one
	 * Go to Forum
	 * Click Administration
	 * Create 2 topic types with different icon
	 * Edit topic type, change icon of topic type 2 the same as the 1st one
	 * Verify result
	 * Delete data
	 */
	@Test
	public static void test10_EditTopicTypesTheSameIconAsExitstingOne(){
		String DATA_TOPIC_TYPE_1="Topic_Type_10_1";
		String DATA_TOPIC_TYPE_2="Topic_Type_10_2";
		String DATA_GROUP_ICON_1="Tool Icons";
		String DATA_ICON_CLASS_1="Icon Shuttlecock";
		String DATA_GROUP_ICON_2="Office Icons";
		String DATA_ICON_CLASS_2="Icon Date";
		By ELEMENT_TOPIC_TYPE_1=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_1+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");
		By ELEMENT_TOPIC_TYPE_2=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_2+"']/ ../*//*[@class='Icon16x16 Date']");
		By ELEMENT_TOPIC_TYPE_2_EDITED=By.xpath("//*[text()='"+DATA_TOPIC_TYPE_2+"']/ ../*//*[@class='Icon16x16 Shuttlecock']");

		info("Edit topic type with the same icon as existing one");
		goToTopicTypes();

		createTopicType(DATA_TOPIC_TYPE_1, DATA_GROUP_ICON_1, DATA_ICON_CLASS_1);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_1);

		pause(1000);
		createTopicType(DATA_TOPIC_TYPE_2, DATA_GROUP_ICON_2, DATA_ICON_CLASS_2);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_2);

		editTopicType(DATA_TOPIC_TYPE_2, DATA_TOPIC_TYPE_2, DATA_GROUP_ICON_1, DATA_ICON_CLASS_1);
		waitForElementPresent(ELEMENT_TOPIC_TYPE_2_EDITED);

		//		Delete data
		deleteTopicType(DATA_TOPIC_TYPE_1);
		deleteTopicType(DATA_TOPIC_TYPE_2);
		close();
	}
}
