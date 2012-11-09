package org.exoplatform.selenium.platform.ks.functional.answers.question;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;

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
public class KS_Answers_QuestionsManagement_Delete extends Answer{

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
	
	/* case01: Delete Question in All questions tab of Manage questions form
	 * create new category
	 * create new question
	 * delete question in Manage questions/All question tab
	 */
	@Test
	public void test01_DeleteQuestionInAllQuestionTab(){
		String CATEGORY_NAME = "KS_QM_delete_01";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION = "KS_Answers_QM_delete_test01_question";
		By ELEMENT_QUESTION = By.linkText(QUESTION);
		By DELETE = By.xpath(ELEMENT_MANAGE_QUESTION_DELETE.replace("${question}", QUESTION));
		
		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		click(ELEMENT_CATEGORY);
		
		//create a question
		info("Create a questions");
		submitQuestion("", QUESTION, QUESTION, false);
		waitForElementPresent(ELEMENT_QUESTION);
		
		//delete question in All question tab
		goToManageQuestions();
		info("Delete question in all question tab");
		usePaginatorQuestion(DELETE, "Not found question");
		click(DELETE);
		click(ELEMENT_OK_BUTTON);
		waitForElementNotPresent(DELETE);
		info("Delete question successfully");
		close();
		
		//delete data
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
	
	/* case02: Delete Question in Open questions tab of Manage questions form
	 * create new category
	 * create new question
	 * delete question in Manage questions/All question tab
	 */
	@Test
	public void test02_DeleteQuestionInOpenQuestionTab(){
		String CATEGORY_NAME = "KS_QM_delete_02";
		By ELEMENT_CATEGORY = By.linkText(CATEGORY_NAME);
		String QUESTION = "KS_Answers_QM_delete_test02_question";
		By ELEMENT_QUESTION = By.linkText(QUESTION);
		By DELETE = By.xpath(ELEMENT_MANAGE_QUESTION_DELETE.replace("${question}", QUESTION));
		
		//create new category
		goToAnswer();		
		String[] au = {};
		String[] mod = {"john"};
		addNewCategoryInAnswer(CATEGORY_NAME, "1", 0, au, CATEGORY_NAME, 2, mod);
		click(ELEMENT_CATEGORY);
		
		//create 2 question
		info("Create a questions");
		submitQuestion("", QUESTION, QUESTION, false);
		waitForElementPresent(ELEMENT_QUESTION);
		
		//delete question in Open question tab
		goToManageQuestions();
		click(ELEMENT_MANAGE_QUESTION_OPEN_QUESTIONS_TAB);
		info("Delete question in all question tab");
		usePaginatorQuestion(DELETE, "Not found question");
		click(DELETE);
		click(ELEMENT_OK_BUTTON);
		waitForElementNotPresent(DELETE);
		info("Delete question successfully");
		close();
		
		//delete data
		deleteOpeningCategoryInAnswer(CATEGORY_NAME);
	}
}
