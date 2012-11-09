package org.exoplatform.selenium.platform.ks.functional.answers.question;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.ForumBase.ELEMENT_ALERT;

import org.exoplatform.selenium.platform.ks.Answer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * @author lientm
 * @date: 26/11/2012
 */
public class KS_Answers_QuestionsManagement_Answer extends Answer {

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	/*case01: Answer question in Manage questions form by answer icon
	 * create new category
	 * create a question with approved and activated is checked
	 * answer question in manage question/open question tab by click icon answer
	 */
	@Test
	public void test01_AnswerInManageQuestionByAnswerIcon(){
		String CATEGORY_NAME = "KS_QM_answer_01";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION = "KS_Answers_QM_answer_test01_question";
		By ELEMENT_QUESTION = By.linkText(QUESTION);
		By ELEMENT_ANSWER = By.xpath(ELEMENT_MANAGE_QUESTION_ANSWER_ICON.replace("${question}", QUESTION));
		String ANSWER_QUESTION = "KS_Answers_QuestionsManagement_test01_answer_question";
		By ELEMENT_ANSWER_NUMBER = By.xpath(ELEMENT_NUMBER_ANSWER.replace("${question}", QUESTION));
		
		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		waitForElementNotPresent(ELEMENT_ALERT);
		click(ELEMENT_CATEGORY);
		
		//create 1 question
		info("Create a questions");
		submitQuestion("", QUESTION, QUESTION, false);
		waitForElementPresent(ELEMENT_QUESTION);
		
		//answer question in manage question/open question tab
		goToManageQuestions();
		click(ELEMENT_MANAGE_QUESTION_OPEN_QUESTIONS_TAB);
		info("Answer this question");
		usePaginatorQuestion(ELEMENT_ANSWER, "Not found question");
		click(ELEMENT_ANSWER);
		
		//check display language default
		WebElement language = waitForAndGetElement(ELEMENT_ANSWER_LANGUAGE, 10000, 0);
		if (language != null){
			assert getValue(ELEMENT_LAGUAGE_SELECTED).equalsIgnoreCase("English");
			info("Language of answer displays true");
		}
		
		//answer question
		By[] link = {};
		modifyAnwser("", ANSWER_QUESTION, true, true, false, link, false);
		close();
		
		//check answer successfully
		waitForElementPresent(ELEMENT_ANSWER_NUMBER);
		info("Make answer for question successfully");
		
		//delete data
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
	
	/* case02: Answer question in Manage questions form by language link
	 * create new category
	 * create a question with approved and activated is checked, multi-language
	 * answer question in manage question/open question tab by click language link
	 */
	@Test
	public void test02_AnswerInManageQuestionsByLanguageLink(){
		String CATEGORY_NAME = "KS_QM_answer_02";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION = "KS_Answers_QM_answer_test02_question";
		By ELEMENT_QUESTION = By.linkText(QUESTION);
		By ELEMENT_ANSWER = By.xpath(ELEMENT_MANAGE_QUESTION_ANSWER_LANGUAGE.replace("${question}", QUESTION).replace("${language}", "French"));
		String ANSWER_QUESTION = "KS_Answers_QuestionsManagement_test02_answer_question";
		By ELEMENT_ANSWER_NUMBER = By.xpath(ELEMENT_NUMBER_ANSWER.replace("${question}", QUESTION));
		
		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		waitForElementNotPresent(ELEMENT_ALERT);
		click(ELEMENT_CATEGORY);
		
		//create 1 question
		info("Create a questions");
		submitQuestion("English/French/Italian", QUESTION, QUESTION, false);
		waitForElementPresent(ELEMENT_QUESTION);
		
		//answer question in manage question/open question tab
		goToManageQuestions();
		click(ELEMENT_MANAGE_QUESTION_OPEN_QUESTIONS_TAB);
		info("Answer this question");
		usePaginatorQuestion(ELEMENT_ANSWER, "Not found question");
		click(ELEMENT_ANSWER);
		
		//check display language default
		WebElement language = waitForAndGetElement(ELEMENT_ANSWER_LANGUAGE, 10000, 0);
		if (language != null){
			assert getValue(ELEMENT_LAGUAGE_SELECTED).equalsIgnoreCase("French");
			info("Language of answer displays true");
		}
		
		//answer question
		By[] link = {};
		modifyAnwser("", ANSWER_QUESTION, true, true, false, link, false);
		close();
		
		//check answer successfully
		waitForElementPresent(ELEMENT_ANSWER_NUMBER);
		info("Make answer for question successfully");
		
		//delete data
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
}
