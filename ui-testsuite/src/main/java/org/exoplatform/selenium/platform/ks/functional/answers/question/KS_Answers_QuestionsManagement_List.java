package org.exoplatform.selenium.platform.ks.functional.answers.question;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ks.ForumBase.ELEMENT_ALERT;

import org.exoplatform.selenium.platform.ks.Answer;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author lientm
 * @date: 26/11/2012
 */
public class KS_Answers_QuestionsManagement_List extends Answer{
	String ELEMENT_QUESTION_IN_ALL_TAB = "//*[@id= 'UITabContent' and contains(@style,'display:block')]/*//*[text()='${question}']";

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
	

	
	/* case01: Check all existing question list
	 * create new category
	 * create many questions with different language: 2 questions
	 * answer question 1
	 * go to manage questions: check to see all questions
	 */
	@Test
	public void test01_CheckAllQuestionList(){
		String CATEGORY_NAME = "KS_Ans_QM_list_01";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION1 = "KS_Answers_QM_list_test01_question1";
		String QUESTION2 = "KS_Answers_QM_list_test01_question2";
		By ELEMENT_QUESTION1 = By.linkText(QUESTION1);
		By ELEMENT_QUESTION2 = By.linkText(QUESTION2);
		String ANSWER_QUESTION1 = "KS_Answers_QuestionsManagement_answer_question1";
		By ELEMENT_ANSWER_NUMBER = By.xpath(ELEMENT_NUMBER_ANSWER.replace("${question}", QUESTION1));
		By ELEMENT_QUESTION1_ALL_TAB = By.xpath(ELEMENT_QUESTION_IN_ALL_TAB.replace("${question}", QUESTION1));
		By ELEMENT_QUESTION2_ALL_TAB = By.xpath(ELEMENT_QUESTION_IN_ALL_TAB.replace("${question}", QUESTION2));
		
		//create new category
		goToAnswer();		
		String[] au = {"john"};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 2, au, CATEGORY_NAME, 2, mod);
		waitForElementNotPresent(ELEMENT_ALERT);
		click(ELEMENT_CATEGORY);
		
		//create 2 question
		info("Create 2 questions");
		submitQuestion("English", QUESTION1, QUESTION1, false);
		waitForElementPresent(ELEMENT_QUESTION1);
		submitQuestion("English/French/Italian", QUESTION2, QUESTION2, false);
		waitForElementPresent(ELEMENT_QUESTION2);
		
		info("Answer question 1");
		By[] quest_link = {};
		answerNotOpeningQuestion(ELEMENT_QUESTION1, "", ANSWER_QUESTION1, true, true, false, quest_link, false);
		waitForElementPresent(ELEMENT_ANSWER_NUMBER);
		info("Answer question 1 successfully");
		
		info("check to see all questions in manage questions");
		goToManageQuestions();
		waitForElementPresent(ELEMENT_QUESTION1_ALL_TAB);
		waitForElementPresent(ELEMENT_QUESTION2_ALL_TAB);
		info("All tab question display true");
		close();
		
		//Delete category;
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
	
	/* case02: Check Open question list
	 * create new category
	 * create question 1 with language = English (default)
	 * create question 2 with language = English (default) -> answer this question
	 * create question 3 with language = English/French/Italian -> answer with French
	 * check in Manage questions/open tab: display question 1 (English), question 3 (English and Italian)
	 */
	@Test
	public void test02_CheckOpenQuestionList(){
		String CATEGORY_NAME = "KS_Ans_QM_list_02";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION1 = "KS_Answers_QM_list_test02_question1";
		String QUESTION2 = "KS_Answers_QM_list_test02_question2";
		String QUESTION3 = "KS_Answers_QM_list_test02_question3";
		By ELEMENT_QUESTION1 = By.linkText(QUESTION1);
		By ELEMENT_QUESTION2 = By.linkText(QUESTION2);
		String ANSWER_QUESTION2 = "KS_Answers_QuestionsManagement_list_answer_question2";
		By ELEMENT_QUESTION3 = By.linkText(QUESTION3);
		String ANSWER_QUESTION3 = "KS_Answers_QuestionsManagement_list_answer_question3";
		By ELEMENT_ANSWER1_ENGLISH = By.xpath(ELEMENT_MANAGE_QUESTION_ANSWER_LANGUAGE.replace("${question}", QUESTION1).replace("${language}", "English"));
		By ELEMENT_ANSWER3_ENGLISH = By.xpath(ELEMENT_MANAGE_QUESTION_ANSWER_LANGUAGE.replace("${question}", QUESTION3).replace("${language}", "English"));
		By ELEMENT_ANSWER3_ITALIAN = By.xpath(ELEMENT_MANAGE_QUESTION_ANSWER_LANGUAGE.replace("${question}", QUESTION3).replace("${language}", "Italian"));

		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		waitForElementNotPresent(ELEMENT_ALERT);
		click(ELEMENT_CATEGORY);
		
		//create 3 question
		info("Create 2 questions");
		submitQuestion("", QUESTION1, QUESTION1, false);
		waitForElementPresent(ELEMENT_QUESTION1);
		submitQuestion("", QUESTION2, QUESTION2, false);
		waitForElementPresent(ELEMENT_QUESTION2);
		submitQuestion("English/French/Italian", QUESTION3, QUESTION3, false);
		waitForElementPresent(ELEMENT_QUESTION3);
		
		//answer question 2 and 3
		info("Answer question 2");
		answerOpeningQuestion(ELEMENT_QUESTION2, "", ANSWER_QUESTION2, true, true, false, false, 0);
		info("Answer question 2 successfully");
		
		info("Answer question 3");
		answerOpeningQuestion(ELEMENT_QUESTION3, "French", ANSWER_QUESTION3, true, true, false, false, 0);
		info("Answer question 3 (french) successfully");
		
		//check in Manage questions/open tab: display question 1 (English), question 3 (English and Italian)
		goToManageQuestions();
		click(ELEMENT_MANAGE_QUESTION_OPEN_QUESTIONS_TAB);
		usePaginatorQuestion(ELEMENT_ANSWER1_ENGLISH, "Not found question 1 in open tab");
		usePaginatorQuestion(ELEMENT_ANSWER3_ENGLISH, "Not found question 3 (english) in open tab");
		usePaginatorQuestion(ELEMENT_ANSWER3_ITALIAN, "Not found question 3 (italian) in open tab");
		info("Open tab question display true");
		close();
		
		//delete data
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
}
