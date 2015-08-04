package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.testng.annotations.*;

	/**
	* @author eXo
	*
	*/
	public class Forum_Post extends Forum_TestConfig {

		String nameCat ;
		String nameForum;
		String nameTopic;
		/**
		 * Create a category, forum and topic
		 */
		public void prepareData(){
			info("Create data test");
			nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			nameForum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			nameTopic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			String description= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			info("Finished creating data test");
			info("Open forum portlet");
			hp.goToForum();
			info("Add a new category");
			forumCatMag.addCategorySimple(nameCat,"",description);
			info("Add a new forum");
			forumMag.addForumSimple(nameForum,"",description);
			info("Add a new topic");
			forumMag.goToStartTopic();
			foTopic.startTopic(nameTopic, description, "", "");
			forumHP.goToTopic(nameTopic);
		}
		/**
		 * Delete data test
		 */
		public void deletaData(){
			info("Open forum portlet");
			hp.goToForum();
			info("Go to Forum home page");
			forumHP.goToHomeCategory();
			info("Delete category");
			forumCatMag.deleteCategory(nameCat);
		}
		
	/**
	*<li> Case ID:116750.</li>
	*<li> Test Case Name: Add a post.</li>	
	*<li> Case ID:116751.</li>
	*<li> Test Case Name: Edit a post.</li>
	*<li> Case ID:116753.</li>
	*<li> Test Case Name: Quote a post.</li>
	*<li> Case ID:116752.</li>
	*<li> Test Case Name: Delete a post.</li>
	*<li> Case ID:116754.</li>
	*<li> Test Case Name: Add a private post.</li>
	*/
	@Test
public  void test01_02_03_04_05_Add_Edit_Quote_Delete_AddPrivate_Post() {
		info("Test 1: Add a post");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentPrivate = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		/*Step Number: 1
		*Step Name: Prepare data: create a caterory, forum, topic
		*Step Description: 
			- Create a category
			- Create a forum
			- Create a topic
		*Input Data: 
			
		*Expected Outcome: 
			Category, forum, topic are created successfully*/

		/*Step number: 2
		*Step Name: Add a post
		*Step Description: 
			- Click on Post Reply button
			- Put content and Submit
		*Input Data: 
			
		*Expected Outcome: 
			- Post reply is added successfully*/ 
		prepareData();
		info("Reply a topic");
		foTopic.postReply(title, content);
		
		info("Test 2: Edit a post");
		foTopic.editPost(title, newTitle, "");
		info("Verify that the post is edited");
		waitForAndGetElement(foTopic.ELEMENT_POST_IN_TOPIC.replace("{$title}",newTitle).replace("{$content}",content));

		info("Test 3: Quote a post");
		info("Quote a post");
		foTopic.quotePost(newTitle, "");
		info("Verify that quote a post successfully");
		waitForAndGetElement(foTopic.ELEMENT_POST_IN_TOPIC_QUOTE.replace("{$title}","Re: "+newTitle).replace("{$content}",content));

		
		info("Test 4: Delete a post");
		info("Click on delete button of the post that is replied");
		click(foTopic.ELEMENT_DELETE_POST.replace("{$title}","Re: "+newTitle ));
		info("Click on OK button of the confirm popup");
		click(foTopic.ELEMENT_DELETE_BOX_CONFIRMATION);
		info("Verify that the replied post is deleted");
		waitForElementNotPresent(foTopic.ELEMENT_POST_IN_TOPIC.replace("{$title}","Re: "+newTitle).replace("{$content}",content));
		info("Click on delete button of the post");
		click(foTopic.ELEMENT_DELETE_POST.replace("{$title}",newTitle ));
		info("Click on OK button of the confirm popup");
		click(foTopic.ELEMENT_DELETE_BOX_CONFIRMATION);
		info("Verify that the post is deleted");
		waitForElementNotPresent(foTopic.ELEMENT_POST_IN_TOPIC.replace("{title}",newTitle).replace("{$content}",content));
		
		info("Test 5: Add a private post");
		foTopic.privatePost(nameTopic, "",contentPrivate );
		info("Verify that the post is privated");
		waitForAndGetElement(By.xpath(foTopic.ELEMENT_POST_IN_TOPIC_PRIVATE.replace("{$title}","Re: "+nameTopic).replace("{$content}",contentPrivate)));
		info("Delete data");
		deletaData();
 	}
}