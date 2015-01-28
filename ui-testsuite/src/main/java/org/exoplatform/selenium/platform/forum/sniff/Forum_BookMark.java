package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;


public class Forum_BookMark extends Forum_TestConfig {

	/**
	 *<li> Case ID:116739.</li>
	 *<li> Test Case Name: Bookmark a category.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public void test01_BookmarkACategory() {
		info("Test 1: Bookmark a category");

		String nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String description = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: Prepare data: Create a category
		 *Step Description: 
			- Create a category
		 *Input Data: 

		 *Expected Outcome: 
			Category is created successfully.*/

		info("go to Forum home page");
		hp.goToForum();
		info("Add a category");
		forumHP.addCategory(nameCat,"",description );
		forumHP.saveChangesAddCategory();

		/*Step number: 2
		 *Step Name: Bookmark a category
		 *Step Description: 
			- Right click on a category, select Bookmark
		 *Input Data: 

		 *Expected Outcome: 
			- Bookmark Category is successfully
			- BookmarkedCategory is displayed in Bookmark list*/ 
		click(forumHP.ELEMENT_CATEGORY_BREADCUMB_HOME);
		info("Bookmark the topic");
		forumHP.bookmark(nameCat);
		info("Delete the category");
		forumHP.deleteCategory(nameCat);
	}

	/**
	 *<li> Case ID:116740.</li>
	 *<li> Test Case Name: Bookmark a forum.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test02_BookmarkAForum() {
		info("Test 2: Bookmark a forum");

		String nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nameForum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String description = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: Prepare data: create a caterory, forum
		 *Step Description: 
			- Create a category
			- Create a forum
		 *Input Data: 

		 *Expected Outcome: 
			Category, forum are created successfully*/

		info("go to Forum home page");
		hp.goToForum();
		info("Add a category");
		forumHP.addCategory(nameCat,"",description);
		forumHP.saveChangesAddCategory();
		info("Add a forum in the category");
		forumHP.addForum(nameForum,"",description);
		forumHP.saveChangesAddForum();
		info("Verify that the forum is shown successfully");
		waitForAndGetElement(forumHP.ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}",nameForum));

		/*Step number: 2
		 *Step Name: Bookmark a forum
		 *Step Description: 
			- Right click on a forum, select Bookmark
		 *Input Data: 

		 *Expected Outcome: 
			- Bookmark forum is successfully
			- Bookmarkedforum is displayed in Bookmark list*/ 

		info("Bookmark the topic");
		click(forumHP.ELEMENT_CATEGORY_BREADCUMB_HOME);
		forumHP.bookmark(nameForum);
		info("Delete the category");
		forumHP.deleteCategory(nameCat);

	}

	/**
	 *<li> Case ID:116741.</li>
	 *<li> Test Case Name: Bookmark a topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test03_BookmarkATopic() {
		info("Test 3: Bookmark a topic");

		String nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String nameForum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic1 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: Prepare data: create a caterory, forum, topic
		 *Step Description: 
			- Create a category
			- Create a forum in this category
			- Create a topic in this forum
		 *Input Data: 

		 *Expected Outcome: 
			Category, forum, topic are created successfully*/

		info("go to Forum home page");
		hp.goToForum();
		info("Add a category");
		forumHP.addCategory(nameCat,"",nameCat);
		forumHP.saveChangesAddCategory();
		info("Add a forum in the category");
		forumHP.addForum(nameForum,"",nameForum);
		forumHP.saveChangesAddForum();
		info("Verify that the forum is shown successfully");
		waitForAndGetElement(forumHP.ELEMENT_DETAIL_FORUM_CATEGORY_TITLE.replace("${title}",nameForum));
		info("Create a topic without attached file");
		foHome.goToStartTopic();
		forumHP.startTopic(topic1, topic1,"","");

		/*Step number: 2
		 *Step Name: Bookmark a topic
		 *Step Description: 
			- Right click on a topic, select Bookmark
		 *Input Data: 

		 *Expected Outcome: 
			- Bookmark topic is successfully
			- Bookmarkedtopic is displayed in Bookmark list*/ 
        info("Bookmark the topic");
		forumHP.bookmark(topic1);
		info("Delete the category");
		forumHP.deleteCategory(nameCat);

	}
	
}