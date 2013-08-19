package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
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
	public final By ELEMENT_MANAGE_QUESTIONS = By.linkText("Manage Questions");
	public final By ELEMENT_MANAGE_QUESTIONS_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Manage Questions']");
	public final String ELEMENT_MANAGE_QUESTION_DEACTIVATE = "//td[text()='${question}']/../*//div[@title='Deactivate']";
	public final String ELEMENT_MANAGE_QUESTION_ACTIVATE = "//td[text()='${question}']/../*//div[@title='Activate']";
	public final String ELEMENT_MANAGE_QUESTION_APPROVE = "//td[text()='${question}']/../*//div[@title='Approve']";
	public final String ELEMENT_MANAGE_QUESTION_DISAPPROVE = "//td[text()='${question}']/../*//div[@title='Disapprove']";
	public final String ELEMENT_MANAGE_QUESTION_DELETE = "//*[@id= 'UITabContent' and contains(@style,'display:block')]/*//td[text()='${question}']/../*//div[@title='Delete']";
	public final String ELEMENT_MANAGE_QUESTION_EDIT = "//td[text()='${question}']/../*//div[@title='Edit']";
	public final String ELEMENT_MANAGE_QUESTION_ANSWER_ICON = "//td[text()='${question}']/../*//div/div[@title='Answer']";
	public final String ELEMENT_MANAGE_QUESTION_ANSWER_LANGUAGE = "//td[text()='${question}']/../td/div[@title='Answer' and contains(@onclick, '${language}')]";
	public final By ELEMENT_MANAGE_QUESTION_OPEN_QUESTIONS_TAB = By.xpath("//div[@class='MiddleTab' and contains(text(),'Open Questions')]");
	public final By ELEMENT_QUESTION_LANGUAGE = By.name("AllLanguages");
	public final By ELEMENT_QUESTION_NAME = By.id("QuestionTitle");
	public final By ELEMENT_APPROVED_QUESTION = By.id("IsApproved");
	public final By ELEMENT_ACTIVATED_QUESTION = By.id("IsActivated");
	public final By ELEMENT_QUESTION_CONTENTFRAME_1= By.xpath("//iframe[@id='Question___Frame']");
	public final By ELEMENT_QUESTION_CONTENTFRAME_2= By.xpath("//td[@id='xEditingArea']/iframe");
	public final By ELEMENT_ATTACH_FILE_LINK = By.xpath("//a[contains(text(),'Attach a file')]");
	public final By ELEMENT_POPUP_UPLOAD_FILE = By.xpath("//span[@class='PopupTitle' and text()='Upload File']");
	public final By ELEMENT_OK_QUESTION = By.linkText("OK");
	
	public final By ELEMENT_ATTACH_FILE = By.name("file");
	public final By ELEMENT_QUESTION_AUTHOR = By.id("Author");
	public final By ELEMENT_QUESTION_EMAIL = By.id("EmailAddress");
	public final By ELEMENT_EDIT_QUESTION_NOT_OPEN = By.xpath("//a[@class='ItemIcon Edit' and text()='Edit']");
	public final By ELEMENT_DELETE_QUESTION_NOT_OPEN = By.xpath("//a[@class='ItemIcon Delete' and text()='Delete']");
	public final By ELEMENT_EDIT_OPENING_QUESTION = By.xpath("//a[@class='Edit' and @title='Edit']");
	public final By ELEMENT_DELETE_OPENING_QUESTION = By.xpath("//a[@class='Delete' and @title='Delete']");

	//More action menu
	public final By ELEMENT_MORE_ACTION_QUESTION = By.xpath("//*[contains(text(), 'More Actions')]");
	public final By ELEMENT_DISCUSS_IN_FORUM_LINK = By.linkText("Discuss in Forum");
	
	/*	---------------------------Common functions for Question-----------------------------------*/

	/**
	 * Go to a question
	 * @author hakt
	 * @param questionName: question name as string
	 */
	public void openAQuestion(String questionName){
		By ELEMENT_QUESTION_LINK=By.xpath("//a[@class='Questions' and text()='"+questionName+"']");
		click(ELEMENT_QUESTION_LINK);
	}

	/** function: choose language for question
	 * @author lientm
	 * @param language: group language that needs to set (eg: "English/French/Italian")
	 * @param questionName: name of question
	 */
	public void chooseLanguageForQuestion(String language, String questionName){
		waitForAndGetElement(ELEMENT_QUESTION_LANGUAGE);
		String language_default = getValue(By.xpath("//option[contains(text(), 'Default')]"));
		String[] temp = language.split("/");
		for (int i = 0; i < temp.length; i ++){
			if (temp[i].equalsIgnoreCase(language_default) == false && temp[i] != ""){
				selectOption(ELEMENT_QUESTION_LANGUAGE, temp[i]);
				waitForAndGetElement(ELEMENT_QUESTION_NAME);
				type(ELEMENT_QUESTION_NAME, questionName, false);
			}
		}
	}
	
	/**
	 * Submit new question
	 * @author hakt
	 * @param language: language of question
	 * @param questionName: question name
	 * @param questionContent: question content
	 * @param upload: true if user wants to attach file, else false, maximum 5 files
	 * @param filePath: absolute path, eg /TestData/Winter.jpg
	 */
	public void submitQuestion(String language, String questionName, String questionContent, boolean upload, String...filePaths){
		button = new Button(driver);
		info("Submit a question with name " + questionName);
		if (waitForAndGetElement(ELEMENT_SUBMIT_QUESTION_BUTTON, 5000, 0) != null ){
			click(ELEMENT_SUBMIT_QUESTION_BUTTON);
		}else {
			click(ELEMENT_SUBMIT_QUESTION_BUTTON_AUX);
		}
		waitForAndGetElement(ELEMENT_QUESTION_NAME);
		type(ELEMENT_QUESTION_NAME, questionName, false);
		if (language != null){
			chooseLanguageForQuestion(language, questionName);
		}

		inputDataToFrameInFrame(ELEMENT_QUESTION_CONTENTFRAME_1, ELEMENT_QUESTION_CONTENTFRAME_2, questionContent, false);
		switchToParentWindow();
		Utils.pause(1000);

		if(upload){
			click(ELEMENT_ATTACH_FILE_LINK);
			waitForAndGetElement(ELEMENT_POPUP_UPLOAD_FILE);
			attachSomeFile(filePaths);
		}
		button.save();
		click(ELEMENT_OK_QUESTION);
		waitForAndGetElement(By.linkText(questionName));
	}
	/** Funtion: edit data when edit question
	 * @author thuntn
	 * @param newQuestionName: name of question
	 * @param language: language of question ex: "English/French"
	 * @param editedQuestionContent: content of question
	 * @param author: author of question
	 * @param email: email of question
	 * @param approved: choose approved or disapproved
	 * @param activated: choose activate of deactivate
	 * @param upload: true -> upload file
	 * @param filePaths: path of files
	 */
	public  void submitQuestionWithValidation(String questionName, String language, String editedQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){
		dialog = new Dialog(driver);
		info("Submit a question with validation");
		if (waitForAndGetElement(ELEMENT_SUBMIT_QUESTION_BUTTON, 5000, 0) != null ){
			click(ELEMENT_SUBMIT_QUESTION_BUTTON);
		}else {
			click(ELEMENT_SUBMIT_QUESTION_BUTTON_AUX);
			
		}
		
		editDataOfQuestion(questionName, language,editedQuestionContent, author, email, approved, activated, upload, filePaths);
		dialog.closeMessageDialog();
	}
	/** Funtion: edit data when edit question
	 * @author lientm
	 * @param newQuestionName: name of question
	 * @param editedQuestionContent: content of question
	 * @param author: author of question
	 * @param email: email of question
	 * @param approved: choose approved or disapproved
	 * @param activated: choose activate of deactivate
	 * @param upload: true -> upload file
	 * @param filePaths: path of files
	 */
	public  void editDataOfQuestion(String newQuestionName, String language, String editedQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){
		button = new Button(driver);
		waitForAndGetElement(ELEMENT_QUESTION_NAME);
		if (newQuestionName != "" && newQuestionName != null){
			type(ELEMENT_QUESTION_NAME, newQuestionName, true);
		}
		if (editedQuestionContent != "" && editedQuestionContent != null){
			inputDataToFrameInFrame(ELEMENT_QUESTION_CONTENTFRAME_1, ELEMENT_QUESTION_CONTENTFRAME_2, editedQuestionContent, true);
			switchToParentWindow();
		}
		if (author != "" && author != null ){
			type(ELEMENT_QUESTION_AUTHOR, author, true);
		}
		if (email != "" && email != null){
			type(ELEMENT_QUESTION_EMAIL, email, true);
		}
		WebElement app = waitForAndGetElement(ELEMENT_APPROVED_QUESTION,5000,0);
		if (app != null)
		if((approved == true && app.isSelected() == false) || (approved == false && app.isDisplayed() == true)){
			click(ELEMENT_APPROVED_QUESTION);
		}
		WebElement act = waitForAndGetElement(ELEMENT_ACTIVATED_QUESTION,5000,0);
		if (act != null)
		if((activated == true && act.isSelected() == false) || (activated == false && act.isDisplayed() == true)){
			click(ELEMENT_ACTIVATED_QUESTION);
		}
		if(upload == true){
			click(ELEMENT_ATTACH_FILE_LINK);
			waitForAndGetElement(ELEMENT_POPUP_UPLOAD_FILE);
			attachSomeFile(filePaths);
		}
		chooseLanguageForQuestion(language, newQuestionName);
		button.save();
	}
	
	/**
	 * Create a new question in the current category with simple data
	 * 
	 * @param questionName : Question name
	 * @param questionContent : Question content
	 * @param message : Message to verify
	 * 
	 * @author dunghm
	 * @since 27 November 2012
	 */
	public void quickAddQuestion(String questionName, String questionContent, String...message){
		button = new Button(driver);
		click(ELEMENT_SUBMIT_QUESTION_BUTTON);
	    waitForAndGetElement(ELEMENT_QUESTION_NAME);
	    type(ELEMENT_QUESTION_NAME, questionName, false);
	
	    inputDataToFrameInFrame(ELEMENT_QUESTION_CONTENTFRAME_1, ELEMENT_QUESTION_CONTENTFRAME_2, questionContent, false);
	    switchToParentWindow();
	    Utils.pause(1000);    
	    button.save();
	    if(message.length > 0) {
	      waitForMessage(message[0]);
	    }else{
	      waitForMessage("The question has been posted.");
	      
	    }
	    click(By.linkText("OK"));
	}
	/**
	 * Edit question by right-click
	 * @author hakt
	 * @param questionLink: question to edit
	 * @param newQuestionName
	 * @param newQuestionContent
	 * @param author
	 * @param email
	 * @param approved: true is unchecked, false is checked
	 * @param activated: true is unchecked, false is checked
	 * @param upload: true is upload, false is not
	 * @param filePaths: path of file
	 */
	public void editNotOpeningQuestion(By questionLink, String newQuestionName, String newQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){

		waitForAndGetElement(questionLink);
		rightClickOnElement(questionLink);
		click(ELEMENT_EDIT_QUESTION_NOT_OPEN);

		editDataOfQuestion(newQuestionName,"", newQuestionContent, author, email, approved, activated, upload, filePaths);
	}

	/**
	 * Delete a question by right-click it
	 * @author hakt
	 * @param questionLink: question to delete
	 */
	public  void deleteNotOpeningQuestion(By questionLink){
		waitForAndGetElement(questionLink);
		rightClickOnElement(questionLink);
		click(ELEMENT_DELETE_QUESTION_NOT_OPEN);
		click(By.linkText("OK"));
		waitForElementNotPresent(questionLink);
	}

	/**
	 * Edit question by opening it
	 * @author hakt
	 * @param oldQuestionName
	 * @param newQuestionName
	 * @param editedQuestionContent
	 * @param author
	 * @param email
	 * @param approved
	 * @param activated
	 * @param upload
	 * @param filePaths
	 */
	public  void editOpeningQuestion(String oldQuestionName, String newQuestionName, String editedQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){
		openAQuestion(oldQuestionName);
		click(ELEMENT_EDIT_OPENING_QUESTION);
		editDataOfQuestion(newQuestionName,"", editedQuestionContent, author, email, approved, activated, upload, filePaths);
	}

	/**
	 * Delete a question by opening it
	 * @author hakt
	 * @param questionName
	 */
	public  void deleteOpeningQuestion(String questionName){

		openAQuestion(questionName);
		click(ELEMENT_DELETE_OPENING_QUESTION);

		click(By.linkText("OK"));
		waitForElementNotPresent(By.xpath("//a[text()='"+questionName+"']"));
	}
	
	/** function: go to manage questions
	 * @author lientm
	 */
	public  void goToManageQuestions(){
		waitForAndGetElement(ELEMENT_MANAGE_QUESTIONS);
		click(ELEMENT_MANAGE_QUESTIONS);
		waitForAndGetElement(ELEMENT_MANAGE_QUESTIONS_POPUP);		
	}
	
	/**function: active/deactivate a question
	 * @author lientm
	 * @param question: title of question
	 * @param active: = true: active
	 * 				  = false: deactivate
	 */
	public  void activeQuestion(String question, boolean active){
		By element_activate = By.xpath(ELEMENT_MANAGE_QUESTION_ACTIVATE.replace("${question}", question));
		By element_deactivate = By.xpath(ELEMENT_MANAGE_QUESTION_DEACTIVATE.replace("${question}", question));
		
		if (active){
			//usePaginatorQuestion(element_activate, "Can not found question");
			WebElement act = waitForAndGetElement(element_activate, 30000, 0);
			if (act != null){				
				click(element_activate);
				waitForAndGetElement(element_deactivate);
				info("active question successfully");
			} else info("Question is being activate");
		} else {
			//usePaginatorQuestion(element_deactivate, "Can not found question");
			WebElement de_act = getElement(element_deactivate);
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
		switchToNewWindow();
	}
}
