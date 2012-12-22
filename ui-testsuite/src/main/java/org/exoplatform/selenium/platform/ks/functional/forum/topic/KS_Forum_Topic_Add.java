package org.exoplatform.selenium.platform.ks.functional.forum.topic;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.*;
import static org.exoplatform.selenium.platform.ks.ForumManagement.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;
import static org.exoplatform.selenium.platform.social.PeopleProfile.*;
import static org.exoplatform.selenium.platform.social.SocialBase.*;
import org.exoplatform.selenium.platform.ks.KsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author thaopth
 * Date: 21 Dec 2012
 */

public class KS_Forum_Topic_Add extends KsBase {
	public static String admin = "john";
	public static String pass = "gtn";
	public By ELEMENT_DEFAULT_TOPIC_ICON = By.xpath("//span[@class='StatusIcon IconsView']");
	public static String NOTIFY_MAIL_ADD_POST = "Hi, you receive this email because you registered for the Forum and Topic Watching notification./" +
			"We would like to inform you that there is a new post in the forum ${forum} with the following content:/" +
			"_______________/" +
			"${post_content}";

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(admin, pass);
	}

	@AfterMethod
	public void afterMethods(){
		info("-- Finished: test case --");
		//signOut();
		driver.quit();
		actions = null;
	}
	
	public static void deleteData(String category){
		signIn(admin, pass);
		goToForums();	
		gotoCategory(category);		
		deleteCategory(category);
	}
	
	public static void deleteCategoryAndTopicType(String category, String...topicType){
		jumpTo("    " + category);
		deleteCategory(category);
		if (topicType.length > 0){
			goToTopicTypes();
			for (int i = 0; i < topicType.length; i ++){
				deleteTopicType(topicType[i]);
			}
		}
	}

	public static void checkUserCanViewTopicAndMakePost(String user, String topic, String topic_message, String... post_content){
		By element_topic = By.linkText(topic);
		
		signIn(user,pass);
		goToForums();
		click(element_topic);
		waitForTextPresent(topic_message);
		waitForElementPresent(ELEEMENT_QUICK_REPLY_FORM);
		if (post_content.length > 0){
			quickReply(post_content[0]);
			waitForTextPresent(post_content[0]);
		}
		signOut();
	}
	
	public static void checkUserCanNotMakePost(String user, String topic, String topic_message){
		signIn(user,"gtn");
		goToForums();
		click(By.linkText(topic));
		waitForTextPresent(topic_message);
		waitForElementNotPresent(ELEEMENT_QUICK_REPLY_FORM);
		signOut();
	}
	
	public static void checkUserCanViewTopic(String user, String forum, String topic){
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		
		signIn(user, pass);
		goToForums();
		click(element_forum);
		waitForElementPresent(element_topic);
		signOut();
	}
	
	public static void checkUserCanNotViewTopic(String user, String forum, String topic){
		By element_forum = By.linkText(forum);
		By element_topic = By.linkText(topic);
		
		signIn(user, pass);
		goToForums();
		click(element_forum);
		waitForElementNotPresent(element_topic);
		signOut();
	}
	
	/*
	 * KS/Forum/Topic/Add
	 * Case 10: Add new topic with Posts Notification option
	 */
	@Test

	public void test10_AddNewTopicWithPostNotificationOption () {
		//Define data
		String category = "Category010";
		String forum = "Forum010";
		String topic ="Topic010";
		String[] add = {forum, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};
		String[] user_topic = {};
		String username = "mary";
		String email = "exomailtest01@gmail.com";
		String post_content = "KS_Forum_Forum_Topic_Post_010";
		By mail = By.xpath("//*[text()='[" + category + "][" + forum + "] " + topic + "']");

		//Setting email for user
		goToMyProfile();
		editUserBasicInformation("John","Smith",email);

		//add category
		goToForums();
		addCategoryInForum(category, "1", 0, audience, "", 0);

		info("Add new forum");
		addForum(category, add, 0, userGroup, true, "", "", false, 0);

		//add new topic and make a new post
		goToStartTopic();
		startTopic(topic, topic, "", "", "", "", "", "", 0, user_topic,false,true);
		signOut();
		
		checkUserCanViewTopicAndMakePost(username, topic, topic, post_content);

		//Get windownHandle of current browser
		String handlesBefore = driver.getWindowHandle();

		//check and delete mail
		info("wait mail");
		pause(120000);
		
		info("Cheking Notification is sent to email address");
		goToMail();
		click(mail);
		checkContentMail(NOTIFY_MAIL_ADD_POST.replace("${forum}", forum).replace("${post_content}", post_content));

		info("delete email");
		click(ELEMENT_DELETE);
		waitForElementNotPresent(mail);

		//delete data
		driver.switchTo().window(handlesBefore);
		deleteData(category);
	}
	/*
	 * Add new topic without Posts Notification option
	 */
	@Test
	public void test11_AddNewTopicWithoutPostNotificationOption () {
		String category = "Category011";
		String forum = "Forum011";
		String topic ="Topic011";
		String username = "mary";
		String email = "exomailtest01@gmail.com";
		String post_content = "KS_Forum_Forum_Topic_Post_011";
		By mail = By.xpath("//*[text()='[" + category + "][" + forum + "] " + topic + "']");

		//Setting email for user
		goToMyProfile();
		editUserBasicInformation("John","Smith",email);

		//add category
		goToForums();
		makeTopicFromCategory(category, forum, topic);
		signOut();
		
		checkUserCanViewTopicAndMakePost(username, topic, topic, post_content);

		//Get windownHandle of current browser
		String handlesBefore = driver.getWindowHandle();

		//check and delete mail
		info("verify no notification mail");
		pause(120000);
		goToMail();
		waitForElementNotPresent(mail);

		//delete data
		driver.switchTo().window(handlesBefore);
		deleteData(category);
	}
	
	/*
	 * KS/Forum/Topic/Add
	 * Case 016: Add new topic in case limit poster in category which contains this topic
	 */
	@Test
	public void test16_AddNewTopicInCaseLimitPosterInCategoryWhichContainsTopic () {
		//Define data
		String DATA_CATEGORY_NAME="Category016";
		String DATA_FORUM_NAME="Forum016";
		String DATA_TOPIC_TITLE = "Topic016";
		String DATA_TOPIC_MESSAGE = "Test topic 016";
		String DATA_POSTER = "mary";
		String DATA_REPLY = "Test reply topic";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};

		goToForums();
		goToAddCategory();
		addCategoryWithSettingPermission(DATA_CATEGORY_NAME,"","",DATA_POSTER,"");

		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		quickStartTopic(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		signOut();

		//Login as user who can post
		checkUserCanViewTopicAndMakePost(DATA_POSTER, DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_REPLY);
		
		//Log in by user who cannot post
		checkUserCanNotMakePost("demo", DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		
		// Clear data
		deleteData(DATA_CATEGORY_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Case 017: Add new topic in case limit viewer in category which contains this topic
	 */
	@Test
	public void test17_AddNewTopicInCaseLimitViewerInCategoryWhichContainsTopic () {
		String DATA_CATEGORY_NAME="Category017";
		String DATA_FORUM_NAME="Forum017";
		String DATA_TOPIC_TITLE = "Topic017";
		String DATA_TOPIC_MESSAGE = "Test topic 017";
		String DATA_VIEWER = "mary";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};

		goToForums();
		goToAddCategory();
		addCategoryWithSettingPermission(DATA_CATEGORY_NAME,"","","",DATA_VIEWER);

		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		quickStartTopic(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		signOut();

		// Login as user who can view
		checkUserCanViewTopic(DATA_VIEWER, DATA_FORUM_NAME, DATA_TOPIC_TITLE);

		//Login as user who cannot view
		checkUserCanNotViewTopic("demo", DATA_FORUM_NAME, DATA_TOPIC_TITLE);

		// Clear data
		deleteData(DATA_CATEGORY_NAME);
	}

	/*
	 * KS/Forum/Topic/Add
	 * Case 018: Add new topic in case limit poster in forum which contains this topic
	 */
	@Test
	public void test18_AddNewTopicInCaseLimitPosterInForumWhichContainsTopic () {
		String DATA_CATEGORY_NAME="Category018";
		String DATA_FORUM_NAME="Forum018";
		String DATA_TOPIC_TITLE = "Topic018";
		String DATA_TOPIC_MESSAGE = "Test topic 018";
		String DATA_POSTER = "mary";
		String DATA_REPLY = "Test reply case018";
		String[] audience = {};

		goToForums();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		goToAddForum();
		addForumWithSettingPermission(DATA_FORUM_NAME, "",DATA_POSTER,"");
		quickStartTopic(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		signOut();

		//Login as user who can post
		checkUserCanViewTopicAndMakePost(DATA_POSTER, DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_REPLY);

		//Login as user who cannot post
		checkUserCanNotMakePost("demo", DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);

		// Clear data
		deleteData(DATA_CATEGORY_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Add new topic in case limit Viewer in forum which contains this topic
	 */
	@Test
	public void test19_AddNewTopicInCaseLimitViewerInForumWhichContainsTipic () {
		String DATA_CATEGORY_NAME="Category019";
		String DATA_FORUM_NAME="Forum019";
		String DATA_TOPIC_TITLE = "Topic019";
		String DATA_TOPIC_MESSAGE = "Test topic 019";
		String DATA_VIEWER = "mary";
		String[] audience = {};

		goToForums();
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		goToAddForum();
		addForumWithSettingPermission(DATA_FORUM_NAME, "","",DATA_VIEWER);
		quickStartTopic(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		signOut();

		//Login as user who can view
		checkUserCanViewTopic(DATA_VIEWER, DATA_FORUM_NAME, DATA_TOPIC_TITLE);

		//Login as user who cannot view
		checkUserCanNotViewTopic("demo", DATA_FORUM_NAME, DATA_TOPIC_TITLE);

		// Clear data
		deleteData(DATA_CATEGORY_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Case 20: Add new topic in case limit poster in both category & forum which contains this topic
	 */
	@Test
	public void test20_AddNewTopicInCaseLimitPosterInBothCategoryAndForum () {
		String DATA_CATEGORY_NAME="Category020";
		String DATA_FORUM_NAME="Forum020";
		String DATA_TOPIC_TITLE = "Topic020";
		String DATA_TOPIC_MESSAGE = "Test topic 020";
		String DATA_POSTER1 = "mary";
		String DATA_POSTER2 = "james";
		String DATA_REPLY01 = "Test reply case020 by poster 1";
		String DATA_REPLY02 = "Test reply case 020 by poster 2";

		goToForums();
		goToAddCategory();
		addCategoryWithSettingPermission(DATA_CATEGORY_NAME,"","",DATA_POSTER1,"");

		//add new forum
		goToAddForum();
		addForumWithSettingPermission(DATA_FORUM_NAME, "",DATA_POSTER2,"");
		quickStartTopic(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		signOut();

		//Login as user who can post
		checkUserCanViewTopicAndMakePost(DATA_POSTER1, DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_REPLY01);

		checkUserCanViewTopicAndMakePost(DATA_POSTER2, DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_REPLY02);

		//Login as user who cannot post
		checkUserCanNotMakePost("demo", DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);

		// Clear data
		deleteData(DATA_CATEGORY_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Case 21: Add new topic in case limit Viewer in both category & forum which contains this topic
	 */
	@Test
	public void test21_AddNewTopicIncaseLimitViewerInBothCategoryAndForum () {
		String DATA_CATEGORY_NAME="Category021";
		String DATA_FORUM_NAME="Forum021";
		String DATA_TOPIC_TITLE = "Topic021";
		String DATA_TOPIC_MESSAGE = "Test topic 021";
		String DATA_VIEWER1 = "mary";
		String DATA_VIEWER2 = "james";

		goToForums();
		goToAddCategory();
		addCategoryWithSettingPermission(DATA_CATEGORY_NAME,"","","",DATA_VIEWER1);

		//add new forum
		goToAddForum();
		addForumWithSettingPermission(DATA_FORUM_NAME, "","",DATA_VIEWER2);
		quickStartTopic(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		signOut();

		//Login as user who can view
		checkUserCanViewTopic(DATA_VIEWER1, DATA_FORUM_NAME, DATA_TOPIC_TITLE);
		
		checkUserCanViewTopic(DATA_VIEWER2, DATA_FORUM_NAME, DATA_TOPIC_TITLE);

		//Login as user who cannot view
		checkUserCanNotViewTopic("demo", DATA_FORUM_NAME, DATA_TOPIC_TITLE);

		// Clear data
		deleteData(DATA_CATEGORY_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Case 25: Add topic without topic type (untyped by default)
	 */
	@Test
	public void test25_AddTopicWithoutTopicType () {
		String DATA_CATEGORY_NAME="Category025";
		String DATA_FORUM_NAME="Forum025";
		String DATA_TOPIC_TITLE = "Topic025";
		String DATA_TOPIC_MESSAGE = "Test topic 025";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};

		goToForums();
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		quickStartTopic(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE);
		waitForElementPresent(ELEMENT_DEFAULT_TOPIC_ICON);

		//Clear data
		deleteCategoryAndTopicType(DATA_CATEGORY_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Case 26: Add topic when choose topic type with icon
	 */
	@Test
	public void test26_AddTopicWhenChooseTopicTypeWithIcon () {
		String DATA_CATEGORY_NAME="Category026";
		String DATA_FORUM_NAME="Forum026";
		String DATA_TOPIC_TITLE = "Topic026";
		String DATA_TOPIC_MESSAGE = "Test topic 026";
		String DATA_TOPIC_TYPE_NAME = "Type01";
		String DATA_GROUP_TYPE = "Office Icons";
		String DATA_CLASS_ICON = "Icon Book";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};

		goToForums();
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		goToStartTopic();
		startTopicWithType(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_TOPIC_TYPE_NAME, DATA_GROUP_TYPE, DATA_CLASS_ICON,DATA_TOPIC_TYPE_NAME);
		waitForElementPresent(By.xpath("//span[@class='StatusIcon Book']"));

		//Clear data
		deleteCategoryAndTopicType(DATA_CATEGORY_NAME, DATA_TOPIC_TYPE_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Case 27: Add topic when choose topic type without icon
	 */
	@Test
	public void test27_AddTopicWhenChooseTopicTypeWithoutIcon () {
		String DATA_CATEGORY_NAME="Category027";
		String DATA_FORUM_NAME="Forum027";
		String DATA_TOPIC_TITLE = "Topic027";
		String DATA_TOPIC_MESSAGE = "Test topic 027";
		String DATA_TOPIC_TYPE_NAME = "Type02";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};

		goToForums();
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		goToStartTopic();
		startTopicWithType(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_TOPIC_TYPE_NAME, "", "",DATA_TOPIC_TYPE_NAME);
		waitForElementPresent(ELEMENT_DEFAULT_TOPIC_ICON);

		//Clear data
		deleteCategoryAndTopicType(DATA_CATEGORY_NAME, DATA_TOPIC_TYPE_NAME);
	}
	
	/*
	 * KS/Forum/Topic/Add
	 * Case 28: Add topic when add topic type with type name blank
	 */
	@Test
	public void test28_AddTopicWhenAddTopicTypeWithBlankName () {
		String DATA_CATEGORY_NAME="Category028";
		String DATA_FORUM_NAME="Forum028";
		String DATA_TOPIC_TITLE = "Topic028";
		String DATA_TOPIC_MESSAGE = "Test topic 028";
		String DATA_TOPIC_TYPE_NAME = "";
		String DATA_WARNING_MESSAGE = "The field \"Type\" is required.";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};

		goToForums();
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		goToStartTopic();
		startTopicWithInvalidType(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_TOPIC_TYPE_NAME, DATA_WARNING_MESSAGE);

		//Clear data
		deleteCategoryAndTopicType(DATA_CATEGORY_NAME);
	}
	/*
	 * KS/Forum/Topic/Add
	 * Case 29: Add topic when add topic type same name with another
	 */
	@Test
	public void test29_AddTopicWhenAddTopicTypeSameNameWithAnother () {
		String DATA_CATEGORY_NAME="Category029";
		String DATA_FORUM_NAME="Forum029";
		String DATA_TOPIC_TITLE = "Topic029";
		String DATA_TOPIC_MESSAGE = "Test topic 029";
		String DATA_TOPIC_TYPE_NAME = "typetest";
		String DATA_WARNING_MESSAGE = "Topic type is existing.";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};

		goToForums();
		goToTopicTypes();
		createTopicType(DATA_TOPIC_TYPE_NAME, "", "");
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);
		
		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		goToStartTopic();
		startTopicWithInvalidType(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_TOPIC_TYPE_NAME, DATA_WARNING_MESSAGE);

		//Clear data
		deleteCategoryAndTopicType(DATA_CATEGORY_NAME, DATA_TOPIC_TYPE_NAME);
	}
	
	@Test
	public void test30_AddTopicWithSameTopicTypeIcon () {
		String DATA_CATEGORY_NAME="Category030";
		String DATA_FORUM_NAME="Forum030";
		String DATA_TOPIC_TITLE = "Topic030";
		String DATA_TOPIC_MESSAGE = "Test topic 030";
		String DATA_TOPIC_TYPE_NAME1 = "typetest01";
		String DATA_TOPIC_TYPE_NAME2 = "typetest02";
		String DATA_GROUP_TYPE = "Misc Icons";
		String DATA_ICON = "Icon Tux";
		String[] add = {DATA_FORUM_NAME, "1", "", "", ""};
		String[] userGroup = {};
		String[] audience = {};

		goToForums();
		goToTopicTypes();
		createTopicType(DATA_TOPIC_TYPE_NAME1, DATA_GROUP_TYPE, DATA_ICON);
		goToAddCategory();
		addCategoryInForum(DATA_CATEGORY_NAME, "1", 0, audience, "", 0);

		//add new forum
		addForum(DATA_CATEGORY_NAME, add, 0, userGroup, true, "", "", false, 0);
		goToStartTopic();
		startTopicWithType(DATA_TOPIC_TITLE, DATA_TOPIC_MESSAGE, DATA_TOPIC_TYPE_NAME2, DATA_GROUP_TYPE, DATA_ICON, DATA_TOPIC_TYPE_NAME2);

		//Clear data
		deleteCategoryAndTopicType(DATA_CATEGORY_NAME, DATA_TOPIC_TYPE_NAME1, DATA_TOPIC_TYPE_NAME2);
	}
}

