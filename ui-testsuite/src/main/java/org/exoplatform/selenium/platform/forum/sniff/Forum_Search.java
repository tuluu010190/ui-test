package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;


	public class Forum_Search{

	/**
	*<li> Case ID:116696.</li>
	*<li> Test Case Name: Quick search.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_QuickSearch() {
		info("Test 1: Quick search");
		/*Step Number: 1
		*Step Name: Prepare data: create a caterory, forum, topic, post
		*Step Description: 
			- Log in as admin (root or john)
			- Click Forums on the left panel
			- Create categories
			- Create forums
			- Create topics
			- Create posts
		*Input Data: 
			
		*Expected Outcome: 
			Category, forum, topic, post are created successfully*/

		/*Step number: 2
		*Step Name: Quick Search
		*Step Description: 
			- Put keyword in the Search box
			- Press Enter or click on Search icon
		*Input Data: 
			
		*Expected Outcome: 
			Return search result with category/forum/topic/post matched key word search*/ 

 	}

	/**
	*<li> Case ID:116697.</li>
	*<li> Test Case Name: Advanced search.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test02_AdvancedSearch() {
		info("Test 2: Advanced search");
		/*Step Number: 1
		*Step Name: Step 1: Prepare data: createcaterories, forums, topics, posts
		*Step Description: 
			- Log in as admin (root or john)
			- Click Forums on the left panel
			- Create categories
			- Create forums
			- Create topics
			- Create posts
		*Input Data: 
			
		*Expected Outcome: 
			Categories, forums, topics, posts are created successfully*/

		/*Step number: 2
		*Step Name: Step 2: Access the Advanced search form
		*Step Description: 
			- Click a category
			- Click [Search this category] on the user bar
			-
		*Input Data: 
			
		*Expected Outcome: 
			- Display the Advanced Search form*/

		/*Step number: 3
		*Step Name: Step 3: Search in Forum
		*Step Description: 
			- Select Forum in the [Search in] field
			- Input search criteria
			- Press Search
		*Input Data: 
			
		*Expected Outcome: 
			Return search results with forum matched key word and search criteria*/

		/*Step number: 4
		*Step Name: Step 4: Search in Topic
		*Step Description: 
			- Click Advanced Search icon
			- Select Topic in the [Search in] field
			- Input search criteria
			- Press Search
		*Input Data: 
			
		*Expected Outcome: 
			Return search results with post matched key word and search criteria*/

		/*Step number: 5
		*Step Name: Step 5: Search in Post
		*Step Description: 
			- Click Advanced Search icon
			- Select Post in the [Search in] field
			- Input search criteria
			- Press Search
		*Input Data: 
			
		*Expected Outcome: 
			Return search results with post matched key word and search criteria*/

		/*Step number: 6
		*Step Name: Step 6: Search in Category
		*Step Description: 
			- Click Advanced Search icon
			- Select Category in the [Search in] field
			- Input search criteria
			- Press Search
		*Input Data: 
			
		*Expected Outcome: 
			Return search results with category matched key word and search criteria*/ 

 	}}