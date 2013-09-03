package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class AnswerManageQuestion extends AnswerBase {

	public AnswerManageQuestion(WebDriver dr){
		driver = dr;
	}

	Button button = new Button(driver);
	Dialog dialog = new Dialog(driver);

	//Manage Question
	public final By ELEMENT_SUBMIT_QUESTION_BUTTON = By.xpath("//*[contains(text(),'Submit Question')]");
	public final By ELEMENT_SUBMIT_QUESTION_BUTTON_AUX = By.xpath("//*[@id='UIQuestions']//*[text()='Submit Question']");
	public final String ELEMENT_MANAGE_QUESTION_DEACTIVATE = "//td[text()='${question}']/..//div[@data-original-title='Deactivate']//span";
	public final String ELEMENT_MANAGE_QUESTION_ACTIVATE = "//td[text()='${question}']/../*//div[@data-original-title='Activate']//span";
	public final String ELEMENT_MANAGE_QUESTION_APPROVE = "//td[text()='${question}']/../*//div[@data-original-title='Approve']//span";
	public final String ELEMENT_MANAGE_QUESTION_DISAPPROVE = "//td[text()='${question}']/../*//div[@data-original-title='Disapprove']//span";
	public final String ELEMENT_MANAGE_QUESTION_DELETE = "//*[@id= 'UITabContent' and contains(@style,'display:block')]/*//td[text()='${question}']/../*//div[@title='Delete']";
	public final String ELEMENT_MANAGE_QUESTION_EDIT = "//td[text()='${question}']/../*//div[@title='Edit']";
	public final String ELEMENT_MANAGE_QUESTION_ANSWER_ICON = "//td[text()='${question}']/../*//div/div[@title='Answer']";
	public final String ELEMENT_MANAGE_QUESTION_ANSWER_LANGUAGE = "//td[text()='${question}']/../td/div[@title='Answer' and contains(@onclick, '${language}')]";
	public final By ELEMENT_MANAGE_QUESTION_OPEN_QUESTIONS_TAB = By.xpath("//div[@class='MiddleTab' and contains(text(),'Open Questions')]");
	public final By ELEMENT_QUESTION_LANGUAGE = By.name("AllLanguages");
	public final By ELEMENT_QUESTION_NAME = By.id("QuestionTitle");
	public final By ELEMENT_APPROVED_QUESTION = By.xpath("//div[@data-original-title='Disapprove']//span");
	public final By ELEMENT_DISAPPROVED_QUESTION = By.xpath("//div[@data-original-title='Approve']//span");
	public final By ELEMENT_DISACTIVATED_QUESTION = By.xpath("//div[@data-original-title ='Activate']//span");
	public final By ELEMENT_ACTIVATED_QUESTION = By.xpath("//div[@data-original-title ='Deactivate']//span");
	public final By ELEMENT_QUESTION_CONTENTFRAME_1= By.xpath("//iframe[@id='Question___Frame']");
	public final By ELEMENT_QUESTION_CONTENTFRAME_2= By.xpath("//td[@id='xEditingArea']/iframe");	
	public final By ELEMENT_QUESTION_AUTHOR = By.id("Author");
	public final By ELEMENT_QUESTION_EMAIL = By.id("EmailAddress");
	public final String ELEMENT_RATE_QUESTION = "//*[contains(@class, 'avgRatingImages')]/i[@data-index='${rate}']";
	public final String ELEMENT_RATE_RESULT = "//div[@id='UIQuestionsConfirm1']/i[${rate}]";
	public final String ELEMENT_QUESTION_CONTENT = "//div[@class='theContent']/p[text()='${content}']";

	//message
	public final String MSG_SUBMIT_QUESTION = "The question has been posted.";
	public final String MSG_DELETE_QUESTION = "Are you sure you want to delete this question and its answers?";

	//Context Menu
	public final By ELEMENT_CONTEXT_MENU_EDIT_QUESTION = By.linkText("Edit");
	public final By ELEMENT_CONTEXT_MENU_DELETE_QUESTION = By.linkText("Delete");
	public final By ELEMENT_OK_DELETE_QUESTION = By.xpath("//*[@id='UIDeleteQuestion']//*[text()='OK']");
	public final By ELEMENT_ANSWER_LINK_IN_CONTEXT_MENU = By.linkText("Answer Question");
	public final By ELEMENT_COMMENT_LINK_IN_CONTEXT_MENU = By.linkText("Comment");

	//Attachment file popup
	public final By ELEMENT_ATTACH_FILE_LINK = By.xpath("//a[contains(text(),'Attach a file')]");
	public final By ELEMENT_POPUP_UPLOAD_FILE = By.xpath("//span[@class='PopupTitle' and text()='Upload File']");

	//Manage question popup
	public final By ELEMENT_MANAGE_QUESTIONS = By.xpath("//*[contains(text(), 'Manage Questions')]");
	public final By ELEMENT_MANAGE_QUESTIONS_POPUP = By.xpath("//*[@class='PopupTitle popupTitle' and text()='Manage Questions']");
	public final By ELEMENT_OPEN_QUESTION_TAB = By.linkText("Open Questions");
	public final String ELEMENT_ANSWER_QUESTION_IN_LIST = "//*[text()='${question}']/..//*[@data-original-title='Answer']";
	public final String ELEMENT_EDIT_QUESTION_IN_LIST = "//*[text()='${question}']/..//*[@data-original-title='Edit']";
	public final String ELEMENT_DELETE_QUESTION_IN_LIST = "//*[text()='${question}']/..//*[@data-original-title='Delete']";
	public final String ELEMENT_LANGUAGE_LINK_IN_LIST = "//*[text()='${question}']/..//*[contains(text(), '${language}')]";
	public final By ELEMENT_MANAGE_QUESTION_CLOSE_BUTTON = By.xpath("//*[@id='FAQQuestionManagerment']//*[text()='Close']");
	public final String ELEMENT_QUESTION_IN_ALL_TAB = "//*[@id='QuestionManagerment-tab']//*[text()='${question}']";
	public final String ELEMENT_QUESTION_IN_OPEN_TAB = "//*[@id='QuestionNotAnswered-tab']//*[text()='${question}']";

	//More action menu
	public final By ELEMENT_MORE_ACTION_QUESTION = By.xpath("//*[contains(text(), 'More Actions')]");
	public final By ELEMENT_DISCUSS_IN_FORUM_LINK = By.linkText("Discuss in Forum");
	public final By ELEMENT_MORE_ACTION_EDIT = By.xpath("//i[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_MORE_ACTION_DELETE = By.linkText("Delete");

	/*	---------------------------Common functions for Question-----------------------------------*/

	/** function: choose language for question
	 * @author lientm
	 * @param language: group language that needs to set
	 * @param questionName: name of question
	 */
	public void chooseLanguageForQuestion(String language){
		String language_default = getValue("//option[contains(text(), 'Default')]");
		if (language.equalsIgnoreCase(language_default) == false && language != ""){
			selectOption(ELEMENT_QUESTION_LANGUAGE, language);
		}
	}

	/**
	 * @author lientm
	 * @param language
	 * @param questionName
	 * @param content
	 * @param author
	 * @param email
	 * @param approved
	 * @param activated
	 * @param upload
	 * @param filePaths
	 */
	public void editDataOfQuestion(String language, String questionName, String content, String author, String email, 
			boolean approved, boolean activated, boolean upload, String filePaths){
		if (language != null){
			chooseLanguageForQuestion(language);
		}
		if (questionName != null){
			type(ELEMENT_QUESTION_NAME, questionName, true);
		}
		if (content != null){
			inputDataToFrameInFrame(ELEMENT_QUESTION_CONTENTFRAME_1, ELEMENT_QUESTION_CONTENTFRAME_2, content, true,false);
			switchToParentWindow();
		}
		if (author != null ){
			type(ELEMENT_QUESTION_AUTHOR, author, true);
		}
		if (email != null){
			type(ELEMENT_QUESTION_EMAIL, email, true);
		}
		WebElement app = waitForAndGetElement(ELEMENT_APPROVED_QUESTION, 5000, 0);
		if (app != null){
			if (approved){
				check(ELEMENT_APPROVED_QUESTION, 2);
			}else {
				uncheck(ELEMENT_APPROVED_QUESTION, 2);
			}
		}

		WebElement act = waitForAndGetElement(ELEMENT_ACTIVATED_QUESTION, 5000, 0);
		if (act != null){
			if (activated){
				check(ELEMENT_ACTIVATED_QUESTION, 2);
			}else {
				uncheck(ELEMENT_ACTIVATED_QUESTION, 2);
			}
		}

		if(upload == true){
			click(ELEMENT_ATTACH_FILE_LINK);
			waitForAndGetElement(ELEMENT_POPUP_UPLOAD_FILE);
			attachFile(filePaths);
		}
	}

	/**function submit a question
	 * @author lientm
	 * @param language
	 * @param questionName
	 * @param content
	 * @param email
	 * @param upload
	 * @param filePaths
	 * @param verify
	 */
	public void submitQuestion(String language, String questionName, String content, String email, 
			boolean upload, String filePaths, boolean...verify){
		button = new Button(driver);
		info("Submit a question with name " + questionName);
		if (waitForAndGetElement(ELEMENT_SUBMIT_QUESTION_BUTTON, 5000, 0) != null ){
			click(ELEMENT_SUBMIT_QUESTION_BUTTON);
		}else {
			click(ELEMENT_SUBMIT_QUESTION_BUTTON_AUX);
		}
		editDataOfQuestion(language, questionName, content, null, email, true, true, upload, filePaths);
		button.save();
		boolean check = verify.length > 0 ? verify[0]:true;
		if (check){
			waitForMessage(MSG_SUBMIT_QUESTION);
			click(ELEMENT_OK_INFOR_POPUP);
			waitForAndGetElement(By.linkText(questionName));
		}
	}

	/**
	 * function submit a question with multi language
	 * @param language
	 * @param questionName
	 * @param content
	 * Note: language has format: English/French...
	 */
	public void submitQuestionWithMultiLanguage(String language, String questionName, String content){
		String[] lang = language.split("/");
		String[] quest = questionName.split("/");
		String[] cont = content.split("/");

		for (int i = 0; i < lang.length; i ++){
			editDataOfQuestion(lang[i], quest[i], cont[i], null, null, true, true, false, null);
		}
		button.save();
		waitForMessage(MSG_SUBMIT_QUESTION);
		click(ELEMENT_OK_INFOR_POPUP);
		waitForAndGetElement(By.linkText(quest[0]));
	}
	/**
	 * @author lientm
	 * @param wayEdit
	 * @param questionName
	 * @param language
	 * @param newQuestionName
	 * @param content
	 * @param author
	 * @param email
	 * @param approved
	 * @param activated
	 * @param upload
	 * @param filePaths
	 */
	public void editQuestion(int wayEdit, String questionName, String language, String newQuestionName, String content, 
			String author, String email, boolean approved, boolean activated, boolean upload, String filePaths){
		button = new Button(driver);
		switch (wayEdit) {
		case 1:
			info("Edit question by right click");
			rightClickOnElement(By.linkText(questionName));
			click(ELEMENT_CONTEXT_MENU_EDIT_QUESTION);
			break;
		case 2:
			info("Edit question while opening question");
			click(ELEMENT_MORE_ACTION_QUESTION);
			click(ELEMENT_MORE_ACTION_EDIT);
			break;
		default:
			info("Edit question from manage question");
			click(ELEMENT_EDIT_QUESTION_IN_LIST.replace("${question}", questionName));
			break;
		}
		editDataOfQuestion(language, newQuestionName, content, author, email, approved, activated, upload, filePaths);
		button.save();
		Utils.pause(2000);
	}

	/**
	 * @author lientm
	 * @param wayDelete
	 * @param questionName
	 */
	public void deleteQuestion(int wayDelete, String questionName){
		switch (wayDelete) {
		case 1:
			info("Delete question by right click");
			rightClickOnElement(By.linkText(questionName));
			click(ELEMENT_CONTEXT_MENU_DELETE_QUESTION);
			break;
		case 2:
			info("Delete question while opening question");
			click(ELEMENT_MORE_ACTION_QUESTION);
			click(ELEMENT_MORE_ACTION_DELETE);
			break;
		default:
			info("Delete question from manage question");
			click(ELEMENT_DELETE_QUESTION_IN_LIST.replace("${question}", questionName));
			break;
		}
		waitForMessage(MSG_DELETE_QUESTION);
		click(ELEMENT_OK_DELETE_QUESTION);
		waitForTextNotPresent(questionName);
	}

	//---------------------------Functions in Manage Question popup----------------------------//

	/** function: go to manage questions
	 * @author lientm
	 */
	public void goToManageQuestions(){
		info("Go to manage question");
		click(ELEMENT_MANAGE_QUESTIONS);
		waitForAndGetElement(ELEMENT_MANAGE_QUESTIONS_POPUP);		
	}

	public void goToOpenQuestionTab(){
		info("Go to Open quesntion tab in manage question");
		click(ELEMENT_OPEN_QUESTION_TAB);
	}

	/**function: active/deactivate a question
	 * @author lientm
	 * @param question: title of question
	 * @param active: = true: active
	 * 				  = false: deactivate
	 */
	public void activeQuestion(String question, boolean active){
		By element_activate = By.xpath(ELEMENT_MANAGE_QUESTION_ACTIVATE.replace("${question}", question));
		By element_deactivate = By.xpath(ELEMENT_MANAGE_QUESTION_DEACTIVATE.replace("${question}", question));

		if (active){
			//usePaginatorQuestion(element_activate, "Can not found question");
			WebElement act = waitForAndGetElement(element_activate, 30000, 1,2);
			if (act != null){				
				click(element_activate);
				waitForAndGetElement(element_deactivate);
				info("active question successfully");
			} else info("Question is being activate");
		} else {
			//usePaginatorQuestion(element_deactivate, "Can not found question");
			WebElement de_act = waitForAndGetElement(element_deactivate, 30000, 1,2);
			if (de_act != null){
				click(element_deactivate);
				waitForAndGetElement(element_activate);
				info("deactive question successfully");
			} else info("Question is being deactivate");
		}
	}

	/** function: approve/disapprove question
	 * @author lientm
	 * @param question: title of question
	 * @param approve: = true: approve
	 * 				   = false: disapprove
	 */
	public  void approveQuestion(String question, boolean approve){
		By element_app = By.xpath(ELEMENT_MANAGE_QUESTION_APPROVE.replace("${question}", question));
		By element_disapp = By.xpath(ELEMENT_MANAGE_QUESTION_DISAPPROVE.replace("${question}", question));

		if (approve){
			//usePaginatorQuestion(element_app, "Can not found question");
			WebElement act = waitForAndGetElement(element_app, 30000, 0);
			if (act != null){				
				click(element_app);
				waitForAndGetElement(element_disapp);
				info("approve question successfully");
			} else info("Question is being approve");
		} else {
			//usePaginatorQuestion(element_disapp, "Can not found question");
			WebElement de_act = waitForAndGetElement(element_disapp, 30000, 0);
			if (de_act != null){
				click(element_disapp);
				waitForAndGetElement(element_app);
				info("disapprove question successfully");
			} else info("Question is being disapprove");
		}
	}

	/**Open discussion windows from a question in answer
	 * @author lientm
	 */
	public void goToDiscussInForum(){
		click(ELEMENT_MORE_ACTION_QUESTION);
		click(ELEMENT_DISCUSS_IN_FORUM_LINK);
		Utils.pause(2000);
		switchToNewWindow();
	}
	/**
	 * @author thuntn
	 * @param rate: rate of question
	 */
	public void rateQuestion(int rate){

		info("Rate a question");

			String st = Integer.toString(rate);
			WebElement e1 = waitForAndGetElement(By.xpath(ELEMENT_RATE_QUESTION.replace("${rate}", Integer.toString(rate))),DEFAULT_TIMEOUT,1,2);

			((JavascriptExecutor)driver).executeScript("arguments[0].click();", e1);
			waitForAndGetElement(By.xpath("//i[@class='voted']["+ st +"]"));

	}
}
