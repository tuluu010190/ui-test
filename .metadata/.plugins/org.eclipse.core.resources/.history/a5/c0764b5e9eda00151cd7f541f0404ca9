package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.forum.ForumTopicManagement.specifMoreActionMenuTopic;
import org.testng.annotations.*;


public class Forum_Topic extends Forum_TestConfig {
	/**
	 *<li> Case ID:116689.</li>
	 *<li> Test Case Name: Watch&Unwatch topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_Watch_UnwatchTopic() {
		info("Test 1: Watch&Unwatch topic");

		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: Prepare data: create a caterory, forum, topic
		 *Step Description: 
			- Create a category
			- Create a forum
			- Create a topic
		 *Input Data: 

		 *Expected Outcome: 
			Category, forum, topic are created successfully*/
		info("Go to Forum portlet");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		info("Add a forum in the category");
		forumMag.addForumSimple(name,"",desc);
		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");

		/*Step number: 2
		 *Step Name: Watch a topic
		 *Step Description: 
			- Access a topic
			- Click on Watch
		 *Input Data: 

		 *Expected Outcome: 
			Topic is watchedsuccessfully*/
		info("Go to a topic");
		forumHP.goToTopic(topic);
		info("Watch the topic");
		forumHP.watchItem(true);
		/*Step number: 3
		 *Step Name: Unwatch a topic
		 *Step Description: 
			- Access a watched topic
			- Click on Unwatch
		 *Input Data: 

		 *Expected Outcome: 
			Topic is unwatchedsuccessfully*/ 
        info("UnWatch the topic");
		forumHP.watchItem(false);
		info("Delete Category");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);
	}

	/**
	 *<li> Case ID:116695.</li>
	 *<li> Test Case Name: Rate topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test02_RateTopic() {
		info("Test 2: Rate topic");

		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Rate Topic
		 *Input Data: 
			- Open 1 topic
			- Click on Rate 
			- Move mouse over stars
		 *Expected Outcome: 
			Topic is rated successfully. The number of stars are selected set yellow.*/ 
		info("Open Forum portlet");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		info("Add a forum in the category");
		forumMag.addForumSimple(name2,"",desc);
		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		info("Rate the topic");
		forumHP.goToTopic(topic);
		foTopic.rateTopic(name2,"Average");
		click((forumHP.ELEMENT_FORUM_NAVIGATION_BREADCRUMB).replace("${name}", name2));
		waitForAndGetElement(forumHP.ELEMENT_FORUM_TOPIC_MARKAVERAGE.replace("${rate}","Rated 3/5."));
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);
	}

	/**
	 *<li> Case ID:116702.</li>
	 *<li> Test Case Name: Tag for topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test03_TagForTopic() {
		info("Test 3: Tag for topic");

		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Manage tag on Topic
		 *Input Data: 
			- Open 1 topicAdd tag
			- Click on Tag 
			- Put tag's name
		 *Expected Outcome: 
			- Topic is added tag successful
			- Topic is displayed when view tag
			- Topic is untagged successful
			- Topic is auto
			-suggest tag when type first character of an existing tag name*/ 
		info("Open Forum portlet");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		info("Add a forum in the category");
		forumMag.addForumSimple(name2,"",desc);

		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		forumHP.goToTopic(topic);
		info("Add and verify a tag");
		foTopic.addATag(name);
		info("Delete the tag");
		click((forumHP.ELEMENT_ACTIONBAR_TOPIC_TAGDELETE).replace("${tag}", name));
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);

	}

	/**
	 *<li> Case ID:116759.</li>
	 *<li> Test Case Name: Move a topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_MoveATopic() {
		info("Test 4: Move a topic");

		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: Prepare data: create a caterory, forum, topic
		 *Step Description: 
			- Create a category
			- Create a forum
			- Create a topic
		 *Input Data: 

		 *Expected Outcome: 
			Category, forum, topic are created successfully*/
        info("Open forum portlet");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		info("Add a forum in the category");
		forumMag.addForumSimple(name2,"",desc);

        forumHP.goToHomeCategory();
		info("Add a forum in the category");
		forumMag.addForumSimple(name3,"",desc);
		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		forumHP.goToTopic(topic);
		/*Step number: 2
		 *Step Name: Move a topic
		 *Step Description: 
			- Open topic above
			- Click More Action >’ Move
			- Choose the destination forum
		 *Input Data: 

		 *Expected Outcome: 
			- Topic is moved to destination Forum successfully*/ 
	
		info("Move Topic:"+topic);
		forumHP.goToTopic(topic);
		foTopic.selectItemMoreActionMenuTopic(specifMoreActionMenuTopic.MOVE);
		info("Move the topic to a forum");
		foTopic.moveTopicToForum(name,name2);
		info("Verify that the forum is moved to new category");
		waitForAndGetElement(forumHP.ELEMENT_CATEGORY_FORUM_BREAD.replace("${forum}",name2).replace("${category}",name));
		
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);
	}

	/**
	 *<li> Case ID:116776.</li>
	 *<li> Test Case Name: Add a new poll.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 *	 *<li> Case ID:116760.</li>
	 *<li> Test Case Name: Edit a poll.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 *<li> Case ID:116761.</li>
	 *<li> Test Case Name: Close / Reopen a poll.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 * *<li> Case ID:116777.</li>
	 *<li> Test Case Name: Delete a poll.</li>
	 *<li> Pre-Condition: a poll's activity is shared in the activity stream</li>
	 *<li> Post-Condition: </li>
	 *
	 */
	@Test
	public  void test05_06_13_14_AddEditCloseReopenDeleteANewPoll() {
		info("Test 5: Add a poll");

		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name5 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name6 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: - Add new poll
		 *Step Description: 
			- Connect to Intranet
			- Open a Forum
			- Add a new topic
			- Goto topic => More Action => add Poll
			- Fill the infomation and click [save]
			- Back to the Homepage
		 *Input Data: 

		 *Expected Outcome: 
			- Poll is added to topic*/ 
        info("Open forum portlet");
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		info("Add a forum in the category");
		forumMag.addForumSimple(name2,"",desc);

		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		
		info("Add a new poll to the topic");
		forumHP.goToTopic(topic);
		foTopic.addPoll(name3,name3, name4);
		waitForAndGetElement(foTopic.ELEMENT_FORUM_POLL_GRID);

		/*Step number: 2
		 *Step Name: Edit a poll
		 *Step Description: 
			- Click Edit icon on a poll
			- Put value to fields
			- Save
		 *Input Data: 

		 *Expected Outcome: 
			Poll is updated successfully*/ 
		info("Test 6: Edit a poll");
		info("Edit a poll");
		foTopic.editPoll(name5,name5,name6);
		waitForAndGetElement(foTopic.ELEMENT_FORUM_POLL_DISPLAYOPT.replace("${opt}", name5));
		waitForAndGetElement(foTopic.ELEMENT_FORUM_POLL_DISPLAYOPT.replace("${opt}", name6));

		info("Test 13: Close and open a poll");
		info("Close the poll");
		foTopic.closeOpenPoll(true);
		info("Open the poll");
		foTopic.closeOpenPoll(false);
		info("Test 14: Delete a poll");
		info("delete poll");
		foTopic.deletePoll();
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);
	}

	/**
	 *<li> Case ID:116762.</li>
	 *<li> Test Case Name: Lock/ Unlock a topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test07_LockUnlockATopic() {
		info("Test 7: Lock/ Unlock a topic");
		
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		 *Step Name: Prepare data: create a caterory, forum, topic
		 *Step Description: 
			- Create a category
			- Create a forum
			- Create a topic
		 *Input Data: 

		 *Expected Outcome: 
			Category, forum, topic are created successfully*/

		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		info("Add a forum in the category");
		forumMag.addForumSimple(name2,"",desc);

		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		forumHP.goToTopic(topic);
		/*Step number: 2
		 *Step Name: Lock a topic
		 *Step Description: 
			- Click on More action> Lock
		 *Input Data: 

		 *Expected Outcome: 
			Topic is locked successfully. Users cannot post to this.*/
        info("Lock the topic");
		foTopic.lockUnlockTopic(true);
		
		/*Step number: 3
		 *Step Name: Unlock a topic
		 *Step Description: 
			- Open a locked topic
			- Click on More action> Unlock
		 *Input Data: 

		 *Expected Outcome: 
			Topic is unlocked successfully.*/ 
		info("Unlock the topic");
		foTopic.lockUnlockTopic(false);
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);
	}

	/**
	 *<li> Case ID:116763.</li>
	 *<li> Test Case Name: Open/ Close a topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test08_OpenCloseATopic() {
		info("Test 8: Open/ Close a topic");
		
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		 *Step Name: Prepare data: create a caterory, forum, topic
		 *Step Description: 
			- Create a category
			- Create a forum
			- Create a topic
		 *Input Data: 

		 *Expected Outcome: 
			Category, forum, topic are created successfully*/
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		info("Add a forum in the category");
		forumMag.addForumSimple(name2,"",desc);

		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		
		/*Step number: 2
		 *Step Name: Close a topic
		 *Step Description: 
			Click on More action > Close
		 *Input Data: 

		 *Expected Outcome: 
			Normal user can not view closed topic*/
		
		info("Close the topic");
		forumHP.goToTopic(topic);
		foTopic.closeOpenTopic(true);
		info("sign out and log in with user2");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		
		info("go to Forum home page");
		hp.goToForum();
		waitForElementNotPresent(forumHP.ELEMENT_FORUM_HOME_TOPIC_TILTE.replace("${topic}",topic));
		
		/*Step number: 3
		 *Step Name: Open a topic
		 *Step Description: 
			Access a closed topic, Click on More action > Open
		 *Input Data: 

		 *Expected Outcome: 
			Open topic successfully.*/ 
		
		info("sign out and log in with user1");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		info("go to Forum home page");
	    hp.goToForum();
		info("Go to the forum");
		forumHP.goToForum(name2);
		info("Go to the topic");
		forumHP.goToTopic(topic);		
		info("open the topic");
		foTopic.closeOpenTopic(false);

		info("sign out and log in with user2");
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);

		info("go to Forum home page");
		hp.goToForum();
		info("Verify that the topic is shown again");
		waitForAndGetElement(forumHP.ELEMENT_FORUM_HOME_TOPIC_TILTE.replace("${topic}",topic));
				
		info("log in back USER1");
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		info("go to Forum home page");
		hp.goToForum();
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);	
	}

	/**
	 *<li> Case ID:116764.</li>
	 *<li> Test Case Name: Create new Topic.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *
	 * *<li> Case ID:116767.</li>
	 *<li> Test Case Name: Delete topic.</li>
	 *<li> Pre-Condition: A topic is existed</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test09_CreateDeleteNewTopic() {
		info("Test 9: Create new Topic");

		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();

		/*Step Number: 1
		 *Step Name: - Create new category
		 *Step Description: 
			- Login and goto Forum application
			- Click [Add Category] 
			- Fill the information and click [Save]
		 *Input Data: 

		 *Expected Outcome: 
			- New category is created
			- No activity is added in activity stream*/
		hp.goToForum();
		info("Add a category");
		forumCatMag.addCategorySimple(name,"",desc);
		
		/*Step number: 2
		 *Step Name: - Create new Forum
		 *Step Description: 
			- Click [Add Forum]
			- Fill the information and click [Save]
		 *Input Data: 

		 *Expected Outcome: 
			- New forum is created
			- No activity is added in activity stream*/
		info("Add a forum in the category");
		forumMag.addForumSimple(name2,"",desc);
		/*Step number: 3
		 *Step Name: - Create new Topic
		 *Step Description: 
			- Click [start Topic]
			- input the information and click [Save]
		 *Input Data: 

		 *Expected Outcome: 
			- New Topic is created*/ 
		info("Add and go to a topic in the forums");
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		forumHP.goToTopic(topic);
		waitForAndGetElement((forumHP.ELEMENT_FORUM_NAVIGATION_BREADCRUMB).replace("${name}", name2));
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);
	}


	/**
	 *<li> Case ID:116766.</li>
	 *<li> Test Case Name: Update topic content.</li>
	 *<li> Pre-Condition: - A topic exists</li>
	 *<li> Post-Condition: </li>
	 *
	 *	 *<li> Case ID:116765.</li>
	 *<li> Test Case Name: Update topic title.</li>
	 *<li> Pre-Condition: - A topic exists</li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test10_11_UpdateTopicContentTitle() {
		info("Test 11 Update topic content");
		
		String name = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name2 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name3 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String name4 = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String desc = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String topic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		/*Step Number: 1
		 *Step Name: - Edit Topic content
		 *Step Description: 
			- Login and goto Forum
			- Goto Category 
			-> Forum 
			->Topic
			- Click [More Action] 
			-> Edit
			- Update content of topic with new value
			- click [Submit]
		 *Input Data: 

		 *Expected Outcome: 
			- Topic content is updated*/ 
		hp.goToForum();
		info("Add a topic");
		forumCatMag.addCategorySimple(name,"",desc);
		forumMag.addForumSimple(name2,"",desc);
		forumMag.goToStartTopic();
		foTopic.startTopic(topic, topic,"","");
		forumHP.goToTopic(topic);
		foTopic.editTopic(name3,name4);
		
		waitForAndGetElement((foTopic.ELEMENT_TOPIC_POST_TITLE).replace("${name}", name3));
		waitForAndGetElement((foTopic.ELEMENT_TOPIC_POST_CONTENT).replace("${name}", name4));
		info("Delete data");
		forumHP.goToHomeCategory();
		forumCatMag.deleteCategory(name);
	}

}