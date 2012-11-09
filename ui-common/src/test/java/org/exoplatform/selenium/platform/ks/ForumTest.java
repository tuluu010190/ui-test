package org.exoplatform.selenium.platform.ks;


import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.*;
import static org.exoplatform.selenium.platform.ks.ForumManagement.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForumTest extends ForumBase {
	
	@BeforeMethod
	public void setUpBeforeTest(){
		//initSeleniumTest();
		getDriverAutoSave();
		actions = new Actions(driver);
		driver.get("http://localhost:8080");
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@Test
	public void test01_AddDeleteCategory(){
		goToForums();
		String[] user = {"Organization/Employees", "*"};
		addCategoryInForum("abc", "1", 4, user, "abcs", 2, "mary");
		String[] user1 = {"Development"};
		editCategory("abcd", "", 3, user1, "kdhfk", 0);
		jumpTo("    abc");
		deleteCategory("abc");
	}

	@Test
	public void test02_AddEditMoveDeleteForum(){
		goToForums();
		String[] data1 = {"forum1", "1", "Open", "Unlocked", "description"};
		String[] data2 = {"john"};
		addForum("123", data1, 2, data2, true, "", "", true, 2, "mary");
		String[] data3 = {"forum123", "2", "Open", "Unlocked", "description123"};
		String[] data4 = {"mary"};
		editForum(data3, 2, data4, true, "", "", true, 0);
		moveForum("forum123", "test1");
		jumpTo("        forum123");
		deleteForum("forum123");
	}
	
	@Test
	public void test03_StartEditDeleteTopic(){
		goToForums();
		click(By.linkText("forum1"));
		String[] user = {"mary"};
		startTopic("topic2", "topic2", "", "Misc Icons", "Icon Rainbow", "type1", "Open", "Unlocked", 2, user, true, true,true);
		click(By.linkText("topic2"));
		String[] user1 = {};
		editTopic("topic3", "abc", "", "update", "", "", "", "", "", 0, user1);
		moveTopic("topic3", "test1/forum2");
		deleteTopic("topic3");
	}
	
	@Test
	public void test_AddEditMoveDeletePost(){
		goToForums();
		click(By.linkText("topicforum1"));
		postReply("post1", "posttest", "Misc Icons", "Icon Rainbow", "");
		editPost("posttest", "post2", "update", "postabc", "Misc Icons", "Icon Rainbow", "");
		movePost("postabc", "test1/forum2/TOPIC123");
		deletePost("postabc");
	}
	
	@Test
	public void test04_AttachFileInTopic(){
		goToForums();
		click(By.linkText("forum1"));
		goToStartTopic();
		inputDataInContentTab_StartTopic("topic1", "abc", "/home/lientm/LienTM/Git/ui-test/ui-testsuite/src/main/resources/TestData/ECMS_Admin_ManageCategories_Display.jpg",
				"/home/lientm/LienTM/Git/ui-test/ui-testsuite/src/main/resources/TestData/ECMS_Admin_ManageCategories_Display.jpg", 
				"/home/lientm/LienTM/Git/ui-test/ui-testsuite/src/main/resources/TestData/ECMS_DMS_SE_Upload_docfile.doc");
	}
	
	@Test
	public void test05_RemoveFile(){
		goToForums();
		click(By.linkText("forum1"));
		click(By.linkText("abctopic"));
		goToEditTopic();
		removeFileInTopic("ECMS_Admin_ManageCategories_Display.jpg");
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_TOPIC_EDIT_POPUP);
	}
	
	@Test
	public void test06_simpleSearch(){
		goToForums();
		simpleSearch("123456");
		advancedSearch(true, "test1");
	}
	
	@Test
	public void test07_export(){
		goToForums();
		exportCategory("test1", true, "test1");
		click(By.linkText("forum1"));
		exportForum("forum1", true);
	}
	
	@Test
	public void test08_import(){
		goToForums();
		importCategory("/home/lientm/LienTM/Selenium/ks-export.zip");
	}
		@Test
	public void test_watch(){
		goToForums();
		click(By.linkText("test1"));
		watchItem("AddWatchingIcon");
		unwatchItem("AddWatchingIcon");
	}
	
	@Test
	public void test_bookmark(){
		goToForums();
		addBookmarksItem("test1");
		deleteBookmarkItem("test1");
	}
	
	@Test
	public void test_banip(){
		goToForums();
		setBanIp("192.168.208.1", "192.168.208.2");
	}
}
