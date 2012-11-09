package org.exoplatform.selenium.platform.ks.functional.answers.category;

import static org.exoplatform.selenium.TestLogger.*;

import org.exoplatform.selenium.platform.ks.Answer;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.exoplatform.selenium.platform.ManageAccount.*;
/*
 * @author: Thuntn
 * @date: 26/11/2012
 */
public class KS_Answers_Category_Add extends Answer{
	public static String USER = "john";
	public static String PASS = "gtn";

	//Add a category with valid moderator
	@Test
	public void test05_AddCategoryWithValidModerator() {
		String cateName = "Add_category_05";
		String[] moderator ={"mary"};
		String[] audience = {};

		info("--Add a category with valid moderator--");

		// Add a category
		addNewCategoryInAnswer(cateName, "1", 0,audience, cateName, 1, moderator, true);
		
		//Delete a category
		deleteNotOpeningCategoryInAnswer(cateName);
		
	}
	//Add a category with invalid moderator
	@Test
	public void test06_AddCategoryWithInvalidModerator() {
		String cateName = "Add_category_06";
		String[] moderator ={"ooo"};
		String[] audience = {};

		info("--Add a category with invalid moderator--");
		//Open a "Add new category form"
		waitForElementPresent(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_CATEGORY_BUTTON);

		//Click Add Category
		waitForElementPresent(ELEMENT_ADD_CATEGORY_LINK);
		click(ELEMENT_ADD_CATEGORY_LINK);

		//Enter data, with invalid moderator 
		modifyDataInCategory(cateName, "1", 0, audience, cateName, 1, moderator, true);

		//Verify expected result - check message
		waitForMessage("The field \"Moderator\" is invalid");
		closeMessageDialog();
		click(ELEMENT_CANCEL_BUTTON);

	}

	//Add a category with Require approval on new questions option
	@Test
	public void test07_AddCategoryWithRequireApprovalOnNewQuestion() {
		String cateName = "Add_category_07";
//		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_category_07";
		String msgPending="This question is pending for approval";
		info("--Add a category with Require approval on new questions option--");
		//Add a category
		addNewCategoryInAnswer(cateName, "1", 0,audience, cateName, 1, moderator, true);
		
		//Add a question in this category
		goToACategoryInAnswer(cateName);
		submitQuestion("", questionName, questionName, false);

		waitForTextPresent(msgPending);

		//Verify when another user signs in, he cannot see the question.
		goToAnswerPortlet("james");
		goToACategoryInAnswer(cateName);
		waitForElementNotPresent(By.linkText(questionName));

		goToAnswerPortlet(USER);

		//Delete data
		deleteNotOpeningCategoryInAnswer(cateName);
		
	}

	//Add a category without Require approval on new questions option
	@Test
	public void test08_AddCategoryWithoutRequireApprovalOnNewQuestion() {
		String cateName = "Add_category_08";
//		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_category_08";
		info("--Add a category without Require approval on new questions option--");
		//Add a category
		addNewCategoryInAnswer(cateName, "1", 0,audience, cateName, 1, moderator);
		
		//Add a question in this category
		goToACategoryInAnswer(cateName);
		submitQuestion("", questionName, questionName, false);

		waitForElementPresent(By.linkText(questionName));

		//Delete data
		deleteOpeningCategoryInAnswer(cateName);
		
	}

	//Add a category with Require approval on new answer option
	@Test
	public void test10_AddCategoryWithRequireApprovalOnNewAnswer() {
		String cateName = "Add_category_10";
//		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_category_10";
		By questionLink = By.linkText(questionName);
		String answer = "Answer question 10";
		By[] questionToLink = {}; 
		String msgAnswer = "Your answer is pending for moderation. It will be displayed after approval.";

		info("--Add a category with Require approval on new answer option--");

		//Add a category
		addNewCategoryInAnswer(cateName, "1", 0,audience, cateName, 1, moderator,false,false,true);
		
		//Add a question in this category
		goToACategoryInAnswer(cateName);
		submitQuestion("", questionName, questionName, false);

		waitForElementPresent(By.linkText(questionName));

		//sign in as james, answer that question
		goToAnswerPortlet("james");
		goToACategoryInAnswer(cateName);

		//answer the above question
		answerNotOpeningQuestion(questionLink, "", answer, false, false, false, questionToLink, false);

		//check message: Your answer is pending for moderation. It will be displayed after approval
		waitForMessage(msgAnswer);
		closeMessageDialog();

		//verify expected result: james cannot see a disapproved answer
		openAQuestion(questionName);
		waitForTextNotPresent(answer);

		//sign in as john
		goToAnswerPortlet(USER);
		goToACategoryInAnswer(cateName);

		//verify expected result: john (moderator) can see a disapproved answer
		openAQuestion(questionName);
		waitForTextPresent(answer);

		//Delete data
		deleteOpeningCategoryInAnswer(cateName);
		
	}

	//Add a category without Require approval on new answer option
	@Test
	public void test11_AddCategoryWithoutRequireApprovalOnNewAnswer() {
		String cateName = "Add_category_11";
//		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_category_11";
		By questionLink = By.linkText(questionName);
		String answer = "Answer question 11";
		By[] questionToLink = {}; 

		info("--Add a category with Require approval on new answer option--");

		//Add a category
		addNewCategoryInAnswer(cateName, "1", 0,audience, cateName, 1, moderator,false,false,false);
		
		//Add a question in this category
		goToACategoryInAnswer(cateName);
		submitQuestion("", questionName, questionName, false);

		waitForElementPresent(By.linkText(questionName));

		//sign in as james, answer that question
		goToAnswerPortlet("james");
		goToACategoryInAnswer(cateName);

		//answer the above question
		answerNotOpeningQuestion(questionLink, "", answer, false, false, false, questionToLink, false);

		goToAnswerPortlet("mary");
		goToACategoryInAnswer(cateName);

		//verify expected result: james can see an approved answer
		openAQuestion(questionName);
		waitForTextPresent(answer);

		//sign in as john
		goToAnswerPortlet(USER);
		goToACategoryInAnswer(cateName);

		//verify expected result: john (moderator) can see an approved answer
		openAQuestion(questionName);
		waitForTextPresent(answer);

		//Delete data
		deleteOpeningCategoryInAnswer(cateName);
		
	}

	//Add a category with View Author of question option
	@Test
	public void test12_AddCategoryWithViewAuthorOfQuestion() {
		String cateName = "Add_category_12";
//		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_category_12";
		By authorQuestion = By.xpath("//span[@class='UserName' and contains(text(),'John Smith')]");
		By emailAuthor = By.xpath("//span[@title='john.smith@acme.exoplatform.com']");

		info("--Add a category with View Author of question option--");

		//Add a category
		addNewCategoryInAnswer(cateName, "1", 0,audience, cateName, 1, moderator,false,true,false);
		
		//Add a question in this category
		goToACategoryInAnswer(cateName);
		submitQuestion("", questionName, questionName, false);

		waitForElementPresent(By.linkText(questionName));

		//verify expected result: can see name and email of author
		openAQuestion(questionName);
		waitForElementPresent(authorQuestion);
		waitForElementPresent(emailAuthor);

		//Delete data
		deleteOpeningCategoryInAnswer(cateName);
		
	}
	//Add a category without View Author of question option
	@Test
	public void test13_AddCategoryWithOutViewAuthorOfQuestion() {
		String cateName = "Add_category_13";
//		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_category_13";
		By authorQuestion = By.xpath("//span[@class='UserName' and contains(text(),'John Smith')]");
		By emailAuthor = By.xpath("//span[@title='john.smith@acme.exoplatform.com']");

		info("--Add a category without View Author of question option--");

		//Add a category
		addNewCategoryInAnswer(cateName, "1", 0,audience, cateName, 1, moderator,false,false,false);
		
		//Add a question in this category
		goToACategoryInAnswer(cateName);
		submitQuestion("", questionName, questionName, false);

		waitForElementPresent(By.linkText(questionName));

		//verify expected result: can see name and email of author
		openAQuestion(questionName);
		waitForElementNotPresent(authorQuestion);
		waitForElementNotPresent(emailAuthor);

		//Delete data
		deleteOpeningCategoryInAnswer(cateName);
		
	}
	//Add new category in case Select user/role/group available from list for Restricted audience field
	@Test
	public void test16_AddCategoryWithRestrictedAudience() {
		String cateName = "Add_category_13";
		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {"mary"};
		info("--Add new category in case Select user/role/group available from list for Restricted audience field--");

		//Add a category
		addNewCategoryInAnswer(cateName, "1", 2	,audience, cateName, 1, moderator,false,true,false);
		
		goToAnswerPortlet("james");

		//verify expected result: james (normal user) cannot see this category
		waitForElementNotPresent(cateLink);

		goToAnswerPortlet("mary");

		//verify expected result: mary (restricted audience) can see this category
		waitForElementPresent(cateLink);

		goToAnswerPortlet(USER);

		//Delete data
		deleteNotOpeningCategoryInAnswer(cateName);
		
	}

	//Add new category in case input directly user/role/group into Restricted audience field
	@Test
	public void test17_AddCategoryWithRestrictedAudience() {
		String cateName = "Add_category_17";
		By cateLink = By.xpath("//a[@title='"+cateName+"']");
		String[] moderator ={"john"};
		String[] audience = {"*:/developers"};
		info("--Add new category in case input directly user/role/group into Restricted audience field--");

		//Add a category
		addNewCategoryInAnswer(cateName, "1", 1	,audience, cateName, 1, moderator,false,true,false);
		
		goToAnswerPortlet("james");

		//verify expected result: james (normal user) cannot see this category
		waitForElementNotPresent(cateLink);

		goToAnswerPortlet("demo");

		//verify expected result: mary (restricted audience) can see this category
		waitForElementPresent(cateLink);

		goToAnswerPortlet(USER);

		//Delete data
		deleteNotOpeningCategoryInAnswer(cateName);
		
	}
	//Add new category in case input directly user/role/group unavailable into Restricted audience field
	@Test
	public void test18_AddCategoryWithInvalidRestrictedAudience() {
		String cateName = "Add_category_18";
		String[] moderator ={"john"};
		String[] audience = {"*:/developer"};
		String msg ="The field \"Restricted Audience\" is invalid";
		info("--Add new category in case input directly user/role/group unavailable into Restricted audience field--");

		//Open a "Add new category form"
		waitForElementPresent(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_CATEGORY_BUTTON);

		//Click Add Category
		waitForElementPresent(ELEMENT_ADD_CATEGORY_LINK);
		click(ELEMENT_ADD_CATEGORY_LINK);

		//Enter data, with invalid restricted audience
		modifyDataInCategory(cateName, "1", 1, audience, cateName, 1, moderator);
		
		//Verify expected result - check message
		waitForMessage(msg);
		closeMessageDialog();
		click(ELEMENT_CANCEL_BUTTON);

	}
	
	@BeforeMethod
	public void beforeMethod() {
		initSeleniumTest();

		driver.get(baseUrl);
		actions = new Actions(driver);
		signIn(USER, PASS);

		goToAnswer();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
