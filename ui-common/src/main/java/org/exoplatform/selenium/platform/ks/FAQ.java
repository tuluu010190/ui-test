package org.exoplatform.selenium.platform.ks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.exoplatform.selenium.platform.NavigationToolbar.goToEditPageEditor;

public class FAQ extends Answer {
	public static By ELEMENT_FAQ_VIEWER = By.xpath("//*[@id='UIViewer' and @class ='FAQViewerContainer']");
	public static By ELEMENT_FQA_CONTAINER = By.xpath("//a[@title='faq']");
	public static By ELEMENT_FAQ_PORLET = By.xpath("//*[@class='LabelTab' and text()='FAQPortlet']");
	public static By ELEMENT_ANSWER_PAGE = By.id("UIPage");
	public static String ELEMENT_FAQ_CATEGORY = "//*[@id='UIViewer']//span[@title='${cat}']";
	public static String ELEMENT_FAQ_QUESTION = "//*[@class='ActionLinkFAQ' and text()='${quest}']";
	public static String ELEMENT_FAQ_ANSWER = "//*[@class='Answer']//p[text()='${ans}']";
	public static By ELEMENT_FAQ_HOME = By.xpath("//a[@class='AnswerHomeIcon']");
	public static By ELEMENT_FAQ_PORTLET_IN_PAGE = By.xpath("//*[@class='CPortletLayoutDecorator' and contains(text(), 'FAQPortlet')]");
	public static By ELEMENT_FAQ_PORTLET_DELETE = By.xpath("//*[text()='FAQPortlet']/../a[@class='DeleteIcon']");
	public static By ELEMENT_FAQ_PORTLET_EDIT = By.xpath("//*[text()='FAQPortlet']/../a[@class='EditIcon']");
	public static By ELEMENT_FAQ_PORTLET_H2 = By.xpath("//a[@class='TitleActionLink']");
	public static By ELEMENT_FAQ_EDIT_TEMPLATE_TAB = By.xpath("//*[@class='MiddleTab' and text()='Edit Template']");
	public static By ELEMENT_FAQ_EDIT_TEMP_INPUT = By.id("ContentTemplate");
	public static By ELEMENT_FAQ_PORLET_ICON = By.id("faq/local._faq.FAQPortlet");
	/** function add new Faq portlet in page
	 * @author lientm
	 */
	public static void goToFaq(){
		WebElement faq = waitForAndGetElement(ELEMENT_FAQ_VIEWER, 5000, 0);
		if (faq == null){
			goToEditPageEditor();
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
	public static void checkElementPresentInContentOfFaq(String category, String question, String answer){
		By element_category = By.xpath(ELEMENT_FAQ_CATEGORY.replace("${cat}", category));
		By element_question = By.xpath(ELEMENT_FAQ_QUESTION.replace("${quest}", question));
		By element_answer = By.xpath(ELEMENT_FAQ_ANSWER.replace("${ans}", answer));
		
		waitForElementPresent(element_category);
		waitForElementPresent(element_question);
		waitForElementPresent(element_answer);
	}
	
	/**function: check elements that did not exist in Faq
	 * @author lientm
	 * @param category
	 * @param question
	 * @param answer
	 */
	public static void checkElementNotPresentInContentOfFaq(String category, String question, String answer){
		By element_category = By.xpath(ELEMENT_FAQ_CATEGORY.replace("${cat}", category));
		By element_question = By.xpath(ELEMENT_FAQ_QUESTION.replace("${quest}", question));
		By element_answer = By.xpath(ELEMENT_FAQ_ANSWER.replace("${ans}", answer));
		
		waitForElementNotPresent(element_category);
		waitForElementNotPresent(element_question);
		waitForElementNotPresent(element_answer);
	}
	
	/**function: add new category -> question -> answer
	 * @author lientm
	 * @param categoryName
	 * @param description
	 * @param questionName
	 * @param answerContent
	 */
	public static void addNewCategoryQuestionAnswer(String categoryName, String description, String questionName, String answerContent){
		String[] audience = {};
		String[] moderator = {};
		By element_catgory = By.linkText(categoryName);
		By element_question = By.linkText(questionName);
		
		addNewCategoryInAnswer(categoryName, "1", 0, audience, description, 0, moderator);
		click(element_catgory);
		
		//add new question
		submitQuestion("", questionName, questionName, false);
		
		//answer this question
		answerOpeningQuestion(element_question, "", answerContent, true, true, false, false, 0);
	}
	
	/**function delete faq portlet for page
	 * @author lientm
	 */
	public static void deleteFaqPortlet(){
		goToEditPageEditor();
		mouseOver(ELEMENT_FAQ_PORTLET_IN_PAGE, true);
		click(ELEMENT_FAQ_PORTLET_DELETE);
		acceptAlert();
		click(ELEMENT_PAGE_FINISH_BUTTON);
		waitForElementNotPresent(ELEMENT_PAGE_FINISH_BUTTON, 100000);
	}
	
	/**function go to edit faq portlet
	 * @author lientm
	 */
	public static void goToEditFaqPortlet(){
		goToEditPageEditor();
		mouseOver(ELEMENT_FAQ_PORTLET_IN_PAGE, true);
		click(ELEMENT_FAQ_PORTLET_EDIT);
		waitForElementPresent(ELEMENT_FAQ_EDIT_TEMPLATE_TAB);
	}
}
