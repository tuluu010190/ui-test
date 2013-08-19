package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.HashMap;
import java.util.Map;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ManageApplications;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PageManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class FAQ extends AnswerBase {
	
	NavigationToolbar navTool;
	ManageAlert alert;
	PageManagement page;
	ManageApplications app;
	AnswerManageAnwser answer;
	AnswerManageCategory cat;
	AnswerManageQuestion question;
	
	public final String DATA_ANSWER_FAQ_PAGE_NAME="AnswerFAQ";
	public final By ELEMENT_FAQ_VIEWER = By.xpath("//*[@id='UIViewer' and @class ='FAQViewerContainer']");
	public final By ELEMENT_FQA_CONTAINER = By.xpath("//a[@title='faq']");
	public final By ELEMENT_FAQ_PORLET = By.xpath("//*[@class='LabelTab' and text()='FAQPortlet']");
	public final By ELEMENT_ANSWER_PAGE = By.id("UIPage");
	public final String ELEMENT_FAQ_CATEGORY = "//*[@id='UIViewer']//span[@title='${cat}']";
	public final String ELEMENT_FAQ_QUESTION = "//*[@class='ActionLinkFAQ' and text()='${quest}']";
	public final String ELEMENT_FAQ_ANSWER = "//*[@class='Answer']//p[text()='${ans}']";
	public final By ELEMENT_FAQ_HOME = By.xpath("//a[@class='AnswerHomeIcon']");
	public final By ELEMENT_FAQ_PORTLET_IN_PAGE = By.xpath("//*[@class='CPortletLayoutDecorator' and contains(text(), 'FAQPortlet')]");
	public final By ELEMENT_FAQ_PORTLET_DELETE = By.xpath("//*[text()='FAQPortlet']/../a[@class='DeleteIcon']");
	public final By ELEMENT_FAQ_PORTLET_EDIT = By.xpath("//*[text()='FAQPortlet']/../a[@class='EditIcon']");
	public final By ELEMENT_FAQ_PORTLET_H2 = By.xpath("//a[@class='TitleActionLink']");
	public final By ELEMENT_FAQ_EDIT_TEMPLATE_TAB = By.xpath("//*[@class='MiddleTab' and text()='Edit Template']");
	public final By ELEMENT_FAQ_EDIT_TEMP_INPUT = By.id("ContentTemplate");
	public final By ELEMENT_FAQ_PORLET_ICON = By.id("faq/local._faq.FAQPortlet");
	
	/*-----------------------Common function--------------------------------*/
	
	/**
	 * Create Answer and FAQ page at root path
	 * @author hakt
	 */
	public void createAnswerAndFAQPage()	{
		navTool = new NavigationToolbar(driver);
		alert = new ManageAlert(driver);
		page = new PageManagement(driver);
		
		Map<String, String> ANSWER_FQA_PORTLET_ID = new HashMap<String, String>();
		ANSWER_FQA_PORTLET_ID.put("faq/local._faq.AnswersPortlet", "faq/local._faq.FAQPortlet");
		
		info("Configure to show import applications");
		app.showImportApplication(true);

		info("Click Import Application");
		click(app.ELEMENT_IMPORT_APPLICATION);
		alert.waitForConfirmation(app.IMPORT_APPLICATION_CONFIRMATION);
		Utils.pause(1000);

		info("--Go to intranet--");
		navTool.goToHomePage();

		info("Go to Add page editor");
		navTool.goToPageCreationWizard();

		info("Up level");
		click(ELEMENT_UP_LEVEL);

		info("Create Answer&FAQ page");
		page.addNewPageEditor(DATA_ANSWER_FAQ_PAGE_NAME, DATA_ANSWER_FAQ_PAGE_NAME,"",CATEGORY_TITLE, 
				ANSWER_FQA_PORTLET_ID, false);	
	}

	
	/** function add new Faq portlet in page
	 * @author lientm
	 */
	public void goToFaq(){
		navTool = new NavigationToolbar(driver);
		WebElement faq = waitForAndGetElement(ELEMENT_FAQ_VIEWER, 5000, 0);
		if (faq == null){
			navTool.goToEditPageEditor();
			for (int i = 0; i < 5; i ++){
				WebElement faq_container = waitForAndGetElement(ELEMENT_FAQ_PORLET, 10000, 0);
				if (faq_container == null){
					click(ELEMENT_FQA_CONTAINER);
					break;
				}
			}
			
			dragAndDropToObject(ELEMENT_FAQ_PORLET, ELEMENT_ANSWER_PAGE);
			click(ELEMENT_PAGE_FINISH_BUTTON);
			waitForElementNotPresent(ELEMENT_PAGE_FINISH_BUTTON, 100000);
		}
	}
	
	/**function: check elements that existed in Faq
	 * @author lientm
	 * @param category
	 * @param question
	 * @param answer
	 */
	public void checkElementPresentInContentOfFaq(String category, String question, String answer){
		By element_category = By.xpath(ELEMENT_FAQ_CATEGORY.replace("${cat}", category));
		By element_question = By.xpath(ELEMENT_FAQ_QUESTION.replace("${quest}", question));
		By element_answer = By.xpath(ELEMENT_FAQ_ANSWER.replace("${ans}", answer));
		
		waitForAndGetElement(element_category);
		waitForAndGetElement(element_question);
		waitForAndGetElement(element_answer);
	}
	
	/**function: check elements that did not exist in Faq
	 * @author lientm
	 * @param category
	 * @param question
	 * @param answer
	 */
	public void checkElementNotPresentInContentOfFaq(String category, String question, String answer){
		By element_category = By.xpath(ELEMENT_FAQ_CATEGORY.replace("${cat}", category));
		By element_question = By.xpath(ELEMENT_FAQ_QUESTION.replace("${quest}", question));
		By element_answer = By.xpath(ELEMENT_FAQ_ANSWER.replace("${ans}", answer));
		
		waitForElementNotPresent(element_category);
		waitForElementNotPresent(element_question);
		waitForElementNotPresent(element_answer);
	}
	
//	/**function: add new category -> question -> answer
//	 * @author lientm
//	 * @param categoryName
//	 * @param description
//	 * @param questionName
//	 * @param answerContent
//	 */
//	public void addNewCategoryQuestionAnswer(String categoryName, String description, String questionName, String answerContent){
//		String[] audience = {};
//		String[] moderator = {};
//		By element_catgory = By.linkText(categoryName);
//		By element_question = By.linkText(questionName);
//		
//		//cat.addNewCategoryInAnswer(categoryName, "1", 0, audience, description, 0, moderator);
//		click(element_catgory);
//		
//		//add new question
//		question.submitQuestion("", questionName, questionName, false);
//		
//		//answer this question
//		answer.answerOpeningQuestion(element_question, "", answerContent, true, true, false, false, 0);
//	}
	
	/**function delete faq portlet for page
	 * @author lientm
	 */
	public void deleteFaqPortlet(){
		navTool = new NavigationToolbar(driver);
		alert = new ManageAlert(driver);
		
		navTool.goToEditPageEditor();
		mouseOver(ELEMENT_FAQ_PORTLET_IN_PAGE, true);
		click(ELEMENT_FAQ_PORTLET_DELETE);
		alert.acceptAlert();
		click(ELEMENT_PAGE_FINISH_BUTTON);
		waitForElementNotPresent(ELEMENT_PAGE_FINISH_BUTTON, 100000);
	}
	
	/**function go to edit faq portlet
	 * @author lientm
	 */
	public void goToEditFaqPortlet(){
		navTool = new NavigationToolbar(driver);
		navTool.goToEditPageEditor();
		mouseOver(ELEMENT_FAQ_PORTLET_IN_PAGE, true);
		click(ELEMENT_FAQ_PORTLET_EDIT);
		waitForAndGetElement(ELEMENT_FAQ_EDIT_TEMPLATE_TAB);
	}
}
