package org.exoplatform.selenium.platform.ks.functional.answers.question;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;

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
public class KS_Answers_QuestionsManagement_Edit extends Answer{
	
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
	
	/*case01: Check activate and inactive question
	 * create a category
	 * answer question 2
	 * create 2 question: question2: active, question1: inactive
	 * check normal user can see question in active status
	 * check normal user can not see question in inactive status
	 */
	@Test
	public void test01_CheckActiveAndDeactiveQuestion(){
		String CATEGORY_NAME = "KS_Ans_QM_edit_01";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION1 = "KS_Answers_QM_edit_test01_question1";
		String QUESTION2 = "KS_Answers_QM_edit_test01_question2";
		By ELEMENT_QUESTION1 = By.linkText(QUESTION1);
		By ELEMENT_QUESTION2 = By.linkText(QUESTION2);
		String ANSWER_QUESTION1 = "KS_Answers_QuestionsManagement_edit_test01_answer_question1";
		
		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		click(ELEMENT_CATEGORY);
		
		//create 2 question
		info("Create 2 questions");
		submitQuestion("", QUESTION1, QUESTION1, false);
		waitForElementPresent(ELEMENT_QUESTION1);
		submitQuestion("", QUESTION2, QUESTION2, false);
		waitForElementPresent(ELEMENT_QUESTION2);
		
		info("Answer question 1");
		By[] quest_link = {};
		answerNotOpeningQuestion(ELEMENT_QUESTION1, "", ANSWER_QUESTION1, false, false, false, quest_link, false);
		
		//deactivate question 1
		goToManageQuestions();
		activeQuestion(QUESTION1, false);
		close();
		signOut();
		
		//check normal user can not see question 1 but can see question 2
		signIn("mary", "gtn");
		goToAnswer();
		click(ELEMENT_CATEGORY);
		waitForElementPresent(ELEMENT_QUESTION2);
		waitForElementNotPresent(ELEMENT_QUESTION1);
		info("Normal user can not see inactive question");
		signOut();
		
		//delete data
		signIn("john", "gtn");
		goToAnswer();
		click(ELEMENT_CATEGORY);
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
	
	/* case02: Check approved and disapprove question
	 * create a category
	 * answer question 2
	 * create 2 question: question2: approve, question1: disapprove
	 * check normal user can see question in approve status
	 * check normal user can not see question in disapprove status
	 */
	@Test
	public void test02_CheckApprovedAndDisapprovedQuestion(){
		String CATEGORY_NAME = "KS_Ans_QM_edit_02";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION1 = "KS_Answers_QM_edit_test02_question1";
		String QUESTION2 = "KS_Answers_QM_edit_test02_question2";
		By ELEMENT_QUESTION1 = By.linkText(QUESTION1);
		By ELEMENT_QUESTION2 = By.linkText(QUESTION2);
		String ANSWER_QUESTION1 = "KS_Answers_QuestionsManagement_test02_answer_question1";
		
		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		click(ELEMENT_CATEGORY);
		
		//create 2 question
		info("Create 2 questions");
		submitQuestion("", QUESTION1, QUESTION1, false);
		waitForElementPresent(ELEMENT_QUESTION1);
		submitQuestion("", QUESTION2, QUESTION2, false);
		waitForElementPresent(ELEMENT_QUESTION2);
		
		info("Answer question 1");
		By[] quest_link = {};
		answerNotOpeningQuestion(ELEMENT_QUESTION1, "", ANSWER_QUESTION1, false, false, false, quest_link, false);
		
		//deactivate question 1
		goToManageQuestions();
		approveQuestion(QUESTION1, false);
		close();
		signOut();
		
		//check normal user can not see question 1 but can see question 2
		signIn("mary", "gtn");
		goToAnswer();
		click(ELEMENT_CATEGORY);
		waitForElementPresent(ELEMENT_QUESTION2);
		waitForElementNotPresent(ELEMENT_QUESTION1);
		info("Normal user can not see disapprove question");
		signOut();
		
		//delete data
		signIn("john", "gtn");
		goToAnswer();
		click(ELEMENT_CATEGORY);
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
	
	/* case03: Edit Question in All question tab of Manage questions form
	 * create new category
	 * create new question
	 * edit question in manage question form
	 */
	@Test
	public void test03_EditQuestionInManageQuestion(){
		String CATEGORY_NAME = "KS_Ans_QM_edit_03";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION = "KS_Answers_QM_edit_test03_question";
		By ELEMENT_QUESTION = By.linkText(QUESTION);
		String QUESTION_NEW = "KS_Answers_QM_edit_test03_question_new";
		By EDIT = By.xpath(ELEMENT_MANAGE_QUESTION_EDIT.replace("${question}", QUESTION));
		By element_activate = By.xpath(ELEMENT_MANAGE_QUESTION_ACTIVATE.replace("${question}", QUESTION_NEW));
		By element_app = By.xpath(ELEMENT_MANAGE_QUESTION_APPROVE.replace("${question}", QUESTION_NEW));
		
		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		click(ELEMENT_CATEGORY);
		
		//create 1 question
		info("Create 1 questions");
		submitQuestion("", QUESTION, QUESTION, false);
		waitForElementPresent(ELEMENT_QUESTION);
		
		//edit question in manage question form
		goToManageQuestions();
		usePaginatorQuestion(EDIT, "Not found question");
		click(EDIT);
		editDataOfQuestion(QUESTION_NEW, "", QUESTION_NEW, "", "", false, false, false);
		waitForElementPresent(element_activate);
		waitForElementPresent(element_app);
		close();
		
		//delete data
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
	
	//case04: Edit Question in Pending questions tab of Manage questions form -> NA
}

