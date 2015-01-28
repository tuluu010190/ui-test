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
		
		public void prepareData(){
			nameCat = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			nameForum = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			nameTopic = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			String description= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
			hp.goToForum();
			foHome.addCategory(nameCat,"",description);
			foHome.saveChangesAddCategory();
			foHome.addForum(nameForum,"",description);
			foHome.saveChangesAddForum();
			foHome.goToStartTopic();
			foHome.startTopic(nameTopic, description, "", "");
			foHome.goToTopic(nameTopic);
		}
		
		public void deletaData(){
			hp.goToForum();
			click(foHome.ELEMENT_CATEGORY_BREADCUMB_HOME);
			foHome.deleteCategory(nameCat);
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
		foTopic.postReply(title, content);
		waitForAndGetElement(By.xpath(foTopic.ELEMENT_POST_IN_TOPIC.replace("{$title}",title).replace("{$content}",content)));
		
		info("Test 2: Edit a post");
		foTopic.editPost(title, newTitle, "");
		waitForAndGetElement(By.xpath(foTopic.ELEMENT_POST_IN_TOPIC.replace("{$title}",newTitle).replace("{$content}",content)));

		info("Test 3: Quote a post");
		foTopic.quotePost(newTitle, "");
		waitForAndGetElement(By.xpath(foTopic.ELEMENT_POST_IN_TOPIC_QUOTE.replace("{$title}","Re: "+newTitle).replace("{$content}",content)));

		
		info("Test 4: Delete a post");
		click(By.xpath(foTopic.ELEMENT_DELETE_POST.replace("{$title}","Re: "+newTitle )));
		click(foTopic.ELEMENT_DELETE_BOX_CONFIRMATION);
		
		waitForElementNotPresent(By.xpath(foTopic.ELEMENT_POST_IN_TOPIC.replace("{$title}","Re: "+newTitle).replace("{$content}",content)));
		
		click(By.xpath(foTopic.ELEMENT_DELETE_POST.replace("{$title}",newTitle )));
		click(foTopic.ELEMENT_DELETE_BOX_CONFIRMATION);
		
		waitForElementNotPresent(By.xpath(foTopic.ELEMENT_POST_IN_TOPIC.replace("{title}",newTitle).replace("{$content}",content)));
		
		info("Test 5: Add a private post");
		foTopic.privatePost(nameTopic, "",contentPrivate );
		
		waitForAndGetElement(By.xpath(foTopic.ELEMENT_POST_IN_TOPIC_PRIVATE.replace("{$title}","Re: "+nameTopic).replace("{$content}",contentPrivate)));
		info("Delete data");
		deletaData();
 	}
}