package org.exoplatform.selenium.platform.ks.functional.faq;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.TestLogger.*;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;

import org.exoplatform.selenium.platform.ks.FAQ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author lientm
 * @date 7/1/2013
 */
public class KS_FAQ extends FAQ {
	
	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		goToAnswer();
	}

	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	/*case01: Browse single Category
	 * Note: when answer question must choose Approved, Activated
	 */
	@Test
	public void test01_BrowseSingleCategory(){
		String categoryName1 = "KS_FAQ_Cat_01_1";
		String categoryName2 = "KS_FAQ_Cat_01_2";
		String description1 = "KS_FAQ_Cat_Description_01_1";
		String description2 = "KS_FAQ_Cat_Description_01_2";
		By element_catgory1 = By.linkText(categoryName1);
		By element_catgory2 = By.linkText(categoryName2);
		String questionName1 = "KS_FAQ_Question_01_1";
		String questionName2 = "KS_FAQ_Question_01_2";
		String answerContent1 = "KS_FAQ_Answer_01_1";
		String answerContent2 = "KS_FAQ_Answer_01_2";
		
		//add new category1, question1, answer1
		addNewCategoryQuestionAnswer(categoryName1, description1, questionName1, answerContent1);
		
		//add new category2, question2, answer2
		click(ELEMENT_FAQ_HOME);
		addNewCategoryQuestionAnswer(categoryName2, description2, questionName2, answerContent2);
		
		//check faq
		goToFaq();
		waitForElementPresent(element_catgory1);
		waitForElementPresent(element_catgory2);
		
		click(element_catgory2);
		checkElementPresentInContentOfFaq(categoryName2, questionName2, answerContent2);
		checkElementNotPresentInContentOfFaq(categoryName1, questionName1, answerContent1);
		
		//delete data
		deleteFaqPortlet();
		click(ELEMENT_FAQ_HOME);
		click(element_catgory1);
		deleteOpeningCategoryInAnswer(categoryName1);
		click(element_catgory2);
		deleteOpeningCategoryInAnswer(categoryName2);
	}
	/**Check Edit template of FAQ portlet.
	 * @author thuntn
	 * In order to run this case, must modify type functions() 
	 */
	
	@Test
	public void test06_CheckEditTemplate(){
		String categoryName1 = "KS_FAQ_Cat_06_";
		String description1 = "KS_FAQ_Cat_Description_06_1";
		By element_catgory1 = By.linkText(categoryName1);
		String questionName1 = "KS_FAQ_Question_06_1";
		String answerContent1 = "KS_FAQ_Answer_06_1";
		String template = "<style>\n" +
				".UIFAQPortlet .FAQAnswerContainer .FAQAnswerIcon h4{\n"+
			 "font-size: 100px;\n"+
		 "font-style: italic;\n"+
		"color: red;\n"+
		"}\n"+
		"</style>\n";
		
		//add new category1, question1, answer1
		addNewCategoryQuestionAnswer(categoryName1, description1, questionName1, answerContent1);
//		
		//check faq
		goToFaq();
		goToEditFaqPortlet();
		click(ELEMENT_FAQ_EDIT_TEMPLATE_TAB);
		
		template = waitForAndGetElement(ELEMENT_FAQ_EDIT_TEMP_INPUT).getAttribute("value") + template;
		type(ELEMENT_FAQ_EDIT_TEMP_INPUT,template,true);
		
		save();
		waitForMessage("Your content template have been saved.");
		closeMessageDialog();
		close();
		click(ELEMENT_FINISH_ICON);
		WebElement h4 = waitForAndGetElement("//h4");
		info("color of h4 " + h4.getCssValue("color"));
		assert h4.getCssValue("color").contains("rgba(255, 0, 0, 1)"): "Fail to update template";
		
		//delete data
		deleteFaqPortlet();
		click(ELEMENT_FAQ_HOME);
		click(element_catgory1);
		deleteOpeningCategoryInAnswer(categoryName1);
	}
	//case03: Check view Question -> merge to case01
	
}
