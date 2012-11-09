package org.exoplatform.selenium.platform.ks.functional.answers.question;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.TestLogger.*;
import org.exoplatform.selenium.platform.ks.Answer;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
/**
 * @author thuntn
 *@date: 03/12/2012
 */
public class KS_Answers_Question_AnswerQuestion extends Answer {
	public static final String DATA_QUESTION_LINK = "//a[contains(text(),'{$questionName}')]";
	public static final String DATA_ANSWER = "//div[@class='AnswerContent ClearFix']/p[contains(text(),'{$answer}')]";
	
	/**
	 * Answer question with valid entry
	 */
	@Test
	public void test02_AnswerQuestionWithValidEntry() {
		String cateName = "category name test02_answer";
		String[] moderator ={"mary"};
		String[] audience = {};
		String questionName = "Question_answer_02";
		String answer = "answer_02";
		By bQuestion = By.xpath(DATA_QUESTION_LINK.replace("{$questionName}", questionName));

		info("Answer question with valid entry");

		addNewCategoryInAnswer(cateName, "1", 0, audience, cateName, 0, moderator,true);
		goToACategoryInAnswer(cateName);

		//Submit question with 2 language
		submitQuestionWithValidation(questionName, "English/French", questionName, null, null, true, true, false);
		waitForElementPresent(bQuestion);

		//Answer in French language
		answerOpeningQuestion(bQuestion, "French", answer, true, true, false, false, 0);

		//delete data
		deleteOpeningCategoryInAnswer(cateName);
	}

	/**
	 * Answer question in case leaving blank at mandatory fields
	 */
	@Test
	public void test03_AnswerQuestionleavingBlankAtMandatoryFields() {
		String cateName = "category name test03_answer";
		String[] moderator ={"mary"};
		String[] audience = {};
		String questionName = "Question_answer_03";
		String answer = "";
		By bQuestion = By.xpath(DATA_QUESTION_LINK.replace("{$questionName}", questionName));

		info("Answer question in case leaving blank at mandatory fields");

		addNewCategoryInAnswer(cateName, "1", 0, audience, cateName, 0, moderator,true);
		goToACategoryInAnswer(cateName);

		//Submit question with 2 language
		submitQuestionWithValidation(questionName, "English/French", questionName, null, null, true, true, false);
		waitForElementPresent(bQuestion);

		//Answer in French language, leave blank at the Answer field
		click(bQuestion);
		waitForElementPresent(ELEMENT_ANSWER_OPENING_QUESTION);
		click(ELEMENT_ANSWER_OPENING_QUESTION);
		modifyAnwser("French", answer, true, true, false, null, false);

		//verify message: Please provide an answer to the question.
		waitForMessage(MSG_ANSWER_EMPTY);
		closeMessageDialog();

		//delete data
		deleteOpeningCategoryInAnswer(cateName);
	}
	/**Approve answer by clicking on Approve icon
	 * 
	 */
	@Test
	public void test04_ApproveAnswerByClickOnApproveIcon() {
		String cateName = "category name test04_answer";
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_answer_04";
		String answer = "answer_04";
		By bQuestion = By.xpath(DATA_QUESTION_LINK.replace("{$questionName}", questionName));

		info("Approve answer by clicking on Approve icon");

		addNewCategoryInAnswer(cateName, "1", 0, audience, cateName, 0, moderator,true,false,true);
		goToACategoryInAnswer(cateName);

		//Submit question with 2 language
		submitQuestionWithValidation(questionName, "English/French", questionName, null, null, true, true, false);
		waitForElementPresent(bQuestion);

		//login as demo, answer question
		goToQuestion("demo", cateName, questionName);

		//Answer in English language
		click(ELEMENT_ANSWER_OPENING_QUESTION);
		modifyAnwser( "English", answer, true, true, false,null, false, 0);

		//Check message: Your answer is pending for moderation. It will be displayed after approval.
		waitForMessage(MSG_ANSWER_PENDING);
		closeMessageDialog();

		//login as john, approve an answer
		goToQuestion("john", cateName, questionName);
		approveAnswer(answer, "demo", true);

		//login as mary, check if that answer is visible
		goToQuestion("mary", cateName, questionName);

		//check if that answer is visible
		waitForElementPresent(DATA_ANSWER.replace("{$answer}",answer));

		goToQuestion("john", cateName, questionName);
		//delete data
		deleteOpeningCategoryInAnswer(cateName);
	}

	/**Approve answer while editing
	 * 
	 */
	@Test
	public void test04_ApproveAnswerWhileEditing() {
		String cateName = "category name test04_answer";
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_answer_04";
		String answer = "answer_04";
		By bQuestion = By.xpath(DATA_QUESTION_LINK.replace("{$questionName}", questionName));

		info("Approve answer while editing");

		addNewCategoryInAnswer(cateName, "1", 0, audience, cateName, 0, moderator,true,false,true);
		goToACategoryInAnswer(cateName);

		//Submit question with 2 language
		submitQuestionWithValidation(questionName, "English/French", questionName, null, null, true, true, false);
		waitForElementPresent(bQuestion);

		//login as demo, answer question
		goToQuestion("demo", cateName, questionName);

		//Answer in English language
		click(ELEMENT_ANSWER_OPENING_QUESTION);
		modifyAnwser( "English", answer, true, true, false,null, false, 0);

		//Check message: Your answer is pending for moderation. It will be displayed after approval.
		waitForMessage(MSG_ANSWER_PENDING);
		closeMessageDialog();

		//login as john, approve an answer
		goToQuestion("john", cateName, questionName);
		editAnswer("English", answer, true, true, false,false, 0);

		//login as mary, check if that answer is visible
		goToQuestion("mary", cateName, questionName);

		//check if that answer is visible
		waitForElementPresent(DATA_ANSWER.replace("{$answer}",answer));

		goToQuestion("john", cateName, questionName);
		//delete data
		deleteOpeningCategoryInAnswer(cateName);
	}
	/**Disapprove answer while editing
	 * 
	 */
	@Test
	public void test05_DisapproveAnswerWhileEditing() {
		String cateName = "category name test05_answer";
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_answer_05";
		String answer = "answer_05";
		By bQuestion = By.xpath(DATA_QUESTION_LINK.replace("{$questionName}", questionName));

		info("Disapprove answer while editing");

		addNewCategoryInAnswer(cateName, "1", 0, audience, cateName, 0, moderator,true);
		goToACategoryInAnswer(cateName);

		//Submit question with 2 language
		submitQuestionWithValidation(questionName, "English/French", questionName, null, null, true, true, false);
		waitForElementPresent(bQuestion);
		
		//Answer in English language
		answerOpeningQuestion(bQuestion, "English", answer, true, true, false,false, 0);

		//login as john, disapprove an answer
		goToQuestion("john", cateName, questionName);
		editAnswer("English", answer, false, true, false,false, 0);

		//login as mary, check if that answer is not visible
		goToQuestion("mary", cateName, questionName);

		//check if that answer is not visible
		waitForElementNotPresent(DATA_ANSWER.replace("{$answer}",answer));

		goToQuestion("john", cateName, questionName);
		//delete data
		deleteOpeningCategoryInAnswer(cateName);
	}
	
	/**Activate answer while editing
	 * 
	 */
	@Test
	public void test06_ActivateAnswerWhileEditing() {
		String cateName = "category name test06_answer";
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_answer_06";
		String answer = "answer_06";
		By bQuestion = By.xpath(DATA_QUESTION_LINK.replace("{$questionName}", questionName));

		info("Activate answer while editing");

		addNewCategoryInAnswer(cateName, "1", 0, audience, cateName, 0, moderator);
		goToACategoryInAnswer(cateName);

		//Submit question with 2 language
		submitQuestionWithValidation(questionName, "English/French", questionName, null, null, true, true, false);
		waitForElementPresent(bQuestion);
		
		//login as demo, answer question
		goToQuestion("demo", cateName, questionName);
		//Answer in English language
		answerNotOpeningQuestion(bQuestion, "English", answer, true, true, false,null,false, 0);

		//login as john, approve an answer
		goToQuestion("john", cateName, questionName);
		editAnswer("English", answer, true, false, false,false, 0);

		//login as mary, check if that answer is not visible
		goToQuestion("demo", cateName, questionName);

		//check if that answer is not visible
		waitForElementNotPresent(DATA_ANSWER.replace("{$answer}",answer));

		//login as john, activate an answer
		goToQuestion("john", cateName, questionName);
		editAnswer("English", answer, true, true, false,false, 0);
		
		//login as demo, check to see that answer
		goToQuestion("demo", cateName, questionName);
		waitForElementPresent(DATA_ANSWER.replace("{$answer}",answer));
		
		//login as john, activate an answer
		goToQuestion("john", cateName, questionName);
		//delete data
		deleteOpeningCategoryInAnswer(cateName);
	}
	
	/**Hide answer while editing
	 * 
	 */
	@Test
	public void test07_ActivateAnswerWhileEditing() {
		String cateName = "category name test07_answer";
		String[] moderator ={"john"};
		String[] audience = {};
		String questionName = "Question_answer_07";
		String answer = "answer_07";
		By bQuestion = By.xpath(DATA_QUESTION_LINK.replace("{$questionName}", questionName));

		info("Hide answer while editing");

		addNewCategoryInAnswer(cateName, "1", 0, audience, cateName, 0, moderator);
		goToACategoryInAnswer(cateName);

		//Submit question with 2 language
		submitQuestionWithValidation(questionName, "English/French", questionName, null, null, true, true, false);
		waitForElementPresent(bQuestion);
		
		//login as demo, answer question
		goToAnswerPortlet("demo");
		goToACategoryInAnswer(cateName);
		//Answer in English language
		answerNotOpeningQuestion(bQuestion, "English", answer, true, true, false,null,false, 0);

		//login as john, approve an answer
		goToQuestion("john", cateName, questionName);
		editAnswer("English", answer, true, false, false,false, 0);

		//login as mary, check if that answer is not visible
		goToQuestion("demo", cateName, questionName);

		//check if that answer is not visible
		waitForElementNotPresent(DATA_ANSWER.replace("{$answer}",answer));

		//login as john, activate an answer
		goToQuestion("john", cateName, questionName);
		//delete data
		deleteOpeningCategoryInAnswer(cateName);
	}
	/** Go to a question in the answer portlet
	 * @author thuntn
	 * @param user: login as this user
	 * @param category: go to this category
	 * @param question: go to this question in that category
	 */
	public void goToQuestion(String user, String category, String question){
		goToAnswerPortlet(user);
		goToACategoryInAnswer(category);
		openAQuestion(question);
	}
	@BeforeMethod
	public void beforeMethod() {
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		goToAnswer();
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
