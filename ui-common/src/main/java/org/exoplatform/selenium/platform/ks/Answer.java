package org.exoplatform.selenium.platform.ks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;

public class Answer extends KsBase{
	//	Add/Edit/Delete category
	public static By ELEMENT_CATEGORY_BUTTON=By.xpath("//a[@class='Icon CategoryManager' and text()='Category']");
	public static By ELEMENT_ADD_CATEGORY_LINK=By.xpath("//a[@class='ItemIcon AddCategory' and text()='Add Category']");
	public static final By ELEMENT_CATEGORY_NAME = By.id("eventCategoryName");
	public static final By ELEMENT_ORDER = By.id("index");
	public static final By ELEMENT_RETRICTED_AUDIENCE = By.id("userPrivate");
	public static final By ELEMENT_DESCRIPTION = By.id("description");
	public static final By ELEMENT_MODERATE_NEW_QUESTION = By.id("moderatequestions");
	public static final By ELEMENT_VIEW_QUESTION_AUTHOR= By.id("ViewAuthorInfor");
	public static final By ELEMENT_MODERATE_ANSWER= By.id("moderateAnswers");
	public static final By ELEMENT_MODERATOR= By.id("moderator");
	public static final By ELEMENT_EDIT_CATEGORYON_MENU= By.xpath("//div[@id='FAQCategroManager']/*//a[text()='Edit']");
	public static final By ELEMENT_EDIT_CATEGORY_RIGHT_CLICK= By.xpath("//div[@class='MiddleLeftRightClickPopupMenu']/*//a[text()='Edit']");
	public static final By ELEMENT_DELETE_CATEGORY_ON_MENU=By.xpath("//*[@id='FAQCategroManager']/*//a[text()='Delete']");
	public static final By ELEMENT_DELETE_CATEGORY_RIGHTCLICK=By.linkText("Delete");//xpath("//div[@class='MenuItem']//a[contains(text(),'Delete')]");
	public static final String MSG_DELETE_CATEGORY="Are you sure to delete this category?";

	//	Add/Edit/Delete/Manage Question
	public static final By ELEMENT_SUBMIT_QUESTION_BUTTON=By.xpath("//a[contains(text(),'Submit Question')]");
	public static final By ELEMENT_SUBMIT_QUESTION_BUTTON_AUX = By.xpath("//*[@id='UIQuestions']//*[text()='Submit Question']");
	public static final By ELEMENT_MANAGE_QUESTIONS = By.linkText("Manage Questions");
	public static final By ELEMENT_MANAGE_QUESTIONS_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Manage Questions']");
	public static final String ELEMENT_MANAGE_QUESTION_DEACTIVATE = "//td[text()='${question}']/../*//div[@title='Deactivate']";
	public static final String ELEMENT_MANAGE_QUESTION_ACTIVATE = "//td[text()='${question}']/../*//div[@title='Activate']";
	public static final String ELEMENT_MANAGE_QUESTION_APPROVE = "//td[text()='${question}']/../*//div[@title='Approve']";
	public static final String ELEMENT_MANAGE_QUESTION_DISAPPROVE = "//td[text()='${question}']/../*//div[@title='Disapprove']";
	public static final String ELEMENT_MANAGE_QUESTION_DELETE = "//*[@id= 'UITabContent' and contains(@style,'display:block')]/*//td[text()='${question}']/../*//div[@title='Delete']";
	public static final String ELEMENT_MANAGE_QUESTION_EDIT = "//td[text()='${question}']/../*//div[@title='Edit']";
	public static final String ELEMENT_MANAGE_QUESTION_ANSWER_ICON = "//td[text()='${question}']/../*//div/div[@title='Answer']";
	public static final String ELEMENT_MANAGE_QUESTION_ANSWER_LANGUAGE = "//td[text()='${question}']/../td/div[@title='Answer' and contains(@onclick, '${language}')]";
	public static final By ELEMENT_MANAGE_QUESTION_OPEN_QUESTIONS_TAB = By.xpath("//div[@class='MiddleTab' and contains(text(),'Open Questions')]");
	public static final By ELEMENT_QUESTION_LANGUAGE = By.id("AllLanguages");
	public static final By ELEMENT_QUESTION_NAME=By.id("QuestionTitle");
	public static final By ELEMENT_APPROVED_QUESTION = By.id("IsApproved");
	public static final By ELEMENT_ACTIVATED_QUESTION = By.id("IsActivated");
	public static final By ELEMENT_QUESTION_CONTENTFRAME_1= By.xpath("//iframe[@id='Question___Frame']");
	public static final By ELEMENT_QUESTION_CONTENTFRAME_2= By.xpath("//td[@id='xEditingArea']/iframe");
	public static By ELEMENT_ATTACH_FILE_LINK = By.xpath("//a[contains(text(),'Attach a file')]");
	public static By ELEMENT_POPUP_UPLOAD_FILE = By.xpath("//span[@class='PopupTitle' and text()='Upload File']");
	
	public static final By ELEMENT_ATTACH_FILE = By.name("file");
	public static final By ELEMENT_QUESTION_AUTHOR = By.id("Author");
	public static final By ELEMENT_QUESTION_EMAIL = By.id("EmailAddress");
	public static final By ELEMENT_EDIT_QUESTION_NOT_OPEN = By.xpath("//a[@class='ItemIcon Edit' and text()='Edit']");
	public static final By ELEMENT_DELETE_QUESTION_NOT_OPEN = By.xpath("//a[@class='ItemIcon Delete' and text()='Delete']");
	public static final By ELEMENT_EDIT_OPENING_QUESTION = By.xpath("//a[@class='Edit' and @title='Edit']");
	public static final By ELEMENT_DELETE_OPENING_QUESTION = By.xpath("//a[@class='Delete' and @title='Delete']");

	//	Simple search in answer
	public static final By ELEMENT_SIMPLESEARCH_TEXTBOX_IN_ANSWER=By.xpath("//input[@id='inputValue']");
	public static final By ELEMENT_SIMPLESEARCH_ICON=By.xpath("//div[@class='SearchIcon ActionSearch' and @title='Search']");

	//	Add/ remove relation
	public static final By ELEMENT_ADD_RELATION=By.xpath("//div[@title='Link to another entry']");
	public static final By ELEMENT_CATEGORY_TREE=By.xpath("//div[@class='FAQCategoryTreeView']//a[contains(text(),'categories')]");
	public static final By ELEMENT_QUESTION_LINK=By.xpath("//div[@class='FAQCategoryTreeView']//a[contains(text(),'categories')]/../../../*//div[@id='FAQCate0']/input");
	public static String ELEMENT_REMOVE_RELATION = "//tr/td/div/div[${No}]/div[@title='Remove']";

	//	Answer a question
	public static final By ELEMENT_ANSWER_NOT_OPENING_QUESTION=By.xpath("//a[@class='ItemIcon ResponseQuestion' and contains(text(),'Answer Question')]");
	public static final By ELEMENT_ANSWER_OPENING_QUESTION=By.xpath("//a[@class='ResponseQuestion' and text()='Answer']");
	public static final By ELEMENT_ANSWER_CONTENTFRAME_1= By.xpath("//iframe[@id='QuestionRespone___Frame']");
	public static final By ELEMENT_ANSWER_CONTENTFRAME_2= By.xpath("//td[@id='xEditingArea']/iframe");
	public static final By ELEMENT_APPROVED_ANSWER=By.id("IsApproved");
	public static final By ELEMENT_ACTIVATED_ANSWER=By.id("QuestionShowAnswer");
	public static final String ELEMENT_NUMBER_ANSWER = "//a[text()='${question}']/../../../*//a[2]/p[text()='1']";
	public static final By ELEMENT_LAGUAGE_SELECTED = By.xpath("//*[@id='Language']/option[@selected='selected']");
	public static final By ELEMENT_EDIT_ANSWER=By.xpath("//a[@class='ItemIcon Edit' and @title='Edit Answer']");
	public static final By ELEMENT_DELETE_ANSWER=By.xpath("//a[@class='ItemIcon DeleteAnswer'and @title='Delete Answer']");
	public static final By ELEMENT_ANSWER_LANGUAGE = By.id("Language");
	public static final String ELEMENT_ANSWER_APPROVE = "//p[contains(text(),{$answer})]/../a/span[contains(text(),'{$user}')]/ancestor::div//a[@title='Approve']"; 
	public static final String ELEMENT_ANSWER_DISAPPROVE = "//p[contains(text(),{$answer})]/../a/span[contains(text(),'{$user}')]/ancestor::div//a[@title='Disapprove']";
	public static final String MSG_ANSWER_PENDING = "Your answer is pending for moderation. It will be displayed after approval.";
	public static final String MSG_ANSWER_EMPTY = "Please provide an answer to the question.";
	/*	---------------------------Common functions for Question-----------------------------------*/

	/**
	 * Go to a question
	 * @author hakt
	 * @param questionName: question name as string
	 */
	public static void openAQuestion(String questionName){
		By ELEMENT_QUESTION_LINK=By.xpath("//a[@class='Questions' and text()='"+questionName+"']");
		click(ELEMENT_QUESTION_LINK);
	}

	/** function: choose language for question
	 * @author lientm
	 * @param language: group language that needs to set (eg: "English/French/Italian")
	 * @param questionName: name of question
	 */
	public static void chooseLanguageForQuestion(String language, String questionName){
		waitForElementPresent(ELEMENT_QUESTION_LANGUAGE);
		String language_default = getValue(By.xpath("//option[contains(text(), 'Default')]"));
		String[] temp = language.split("/");
		for (int i = 0; i < temp.length; i ++){
			if (temp[i].equalsIgnoreCase(language_default) == false && temp[i] != ""){
				selectOption(ELEMENT_QUESTION_LANGUAGE, temp[i]);
				waitForElementPresent(ELEMENT_QUESTION_NAME);
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
	public static void submitQuestion(String language, String questionName, String questionContent, boolean upload, String...filePaths){
		info("Submit a question with name " + questionName);
		if (waitForAndGetElement(ELEMENT_SUBMIT_QUESTION_BUTTON, 5000, 0) != null ){
			click(ELEMENT_SUBMIT_QUESTION_BUTTON);
		}else {
			click(ELEMENT_SUBMIT_QUESTION_BUTTON_AUX);
		}
		waitForElementPresent(ELEMENT_QUESTION_NAME);
		type(ELEMENT_QUESTION_NAME, questionName, false);
		chooseLanguageForQuestion(language, questionName);

		inputDataToFrameInFrame(ELEMENT_QUESTION_CONTENTFRAME_1, ELEMENT_QUESTION_CONTENTFRAME_2, questionContent, false);
		switchToParentWindow();
		pause(1000);

		if(upload==true){
			click(ELEMENT_ATTACH_FILE_LINK);
			waitForElementPresent(ELEMENT_POPUP_UPLOAD_FILE);
			attachSomeFile(filePaths);
		}
		save();
		click(By.linkText("OK"));
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
	public static void submitQuestionWithValidation(String questionName, String language, String editedQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){
		info("Submit a question with validation");
		if (waitForAndGetElement(ELEMENT_SUBMIT_QUESTION_BUTTON, 5000, 0) != null ){
			click(ELEMENT_SUBMIT_QUESTION_BUTTON);
		}else {
			click(ELEMENT_SUBMIT_QUESTION_BUTTON_AUX);
			
		}
		
		editDataOfQuestion(questionName, language,editedQuestionContent, author, email, approved, activated, upload, filePaths);
		closeMessageDialog();
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
	public static void editDataOfQuestion(String newQuestionName, String language, String editedQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){
		waitForElementPresent(ELEMENT_QUESTION_NAME);
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
			waitForElementPresent(ELEMENT_POPUP_UPLOAD_FILE);
			attachSomeFile(filePaths);
		}
		chooseLanguageForQuestion(language, newQuestionName);
		save();
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
	public static void quickAddQuestion(String questionName, String questionContent, String...message){
	  click(ELEMENT_SUBMIT_QUESTION_BUTTON);
    waitForElementPresent(ELEMENT_QUESTION_NAME);
    type(ELEMENT_QUESTION_NAME, questionName, false);

    inputDataToFrameInFrame(ELEMENT_QUESTION_CONTENTFRAME_1, ELEMENT_QUESTION_CONTENTFRAME_2, questionContent, false);
    switchToParentWindow();
    pause(1000);    
    save();
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
	public static void editNotOpeningQuestion(By questionLink, String newQuestionName, String newQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){

		waitForElementPresent(questionLink);
		rightClickOnElement(questionLink);
		click(ELEMENT_EDIT_QUESTION_NOT_OPEN);

		editDataOfQuestion(newQuestionName,"", newQuestionContent, author, email, approved, activated, upload, filePaths);
	}

	/**
	 * Delete a question by right-click it
	 * @author hakt
	 * @param questionLink: question to delete
	 */
	public static void deleteNotOpeningQuestion(By questionLink){
		waitForElementPresent(questionLink);
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
	public static void editOpeningQuestion(String oldQuestionName, String newQuestionName, String editedQuestionContent, String author, String email, boolean approved, boolean activated, boolean upload, String...filePaths){
		openAQuestion(oldQuestionName);
		click(ELEMENT_EDIT_OPENING_QUESTION);
		editDataOfQuestion(newQuestionName,"", editedQuestionContent, author, email, approved, activated, upload, filePaths);
	}

	/**
	 * Delete a question by opening it
	 * @author hakt
	 * @param questionName
	 */
	public static void deleteOpeningQuestion(String questionName){

		openAQuestion(questionName);
		click(ELEMENT_DELETE_OPENING_QUESTION);

		click(By.linkText("OK"));
		waitForElementNotPresent(By.xpath("//a[text()='"+questionName+"']"));
	}
	
	/** function: go to manage questions
	 * @author lientm
	 */
	public static void goToManageQuestions(){
		waitForElementPresent(ELEMENT_MANAGE_QUESTIONS);
		click(ELEMENT_MANAGE_QUESTIONS);
		waitForElementPresent(ELEMENT_MANAGE_QUESTIONS_POPUP);		
	}
	
	/**function: found element on form that has many page
	 * @author lientm
	 * @param locator: locator is finding
	 * @param exceptionMessage: message return when not found
	 */
	public static void usePaginatorQuestion(By locator, String exceptionMessage) {
		String ELEMENT_PAGINATOR_PAGE_LINK = "//*[@id= 'UITabContent' and contains(@style,'display:block')]/*//*[contains(@class, 'Number')]/*[text()='${number}']";
		String ELEMENT_PAGINATOR_TOTAL_NUMBER = "//*[@id= 'UITabContent' and contains(@style,'display:block')]/*//*[@class='PagesTotalNumber']";
		String ELEMENT_PAGINATOR_NEXT_ICON = "//*[@id= 'UITabContent' and contains(@style,'display:block')]/*//*[@class='Icon NextPageIcon']";
		WebElement element = waitForAndGetElement(locator, 5000, 0);
		
		if (element == null){
			WebElement page1 = waitForAndGetElement(ELEMENT_PAGINATOR_PAGE_LINK.replace("${number}", "1"), 5000, 0);
			if (page1 != null){
				int totalPages = isElementPresent(ELEMENT_PAGINATOR_TOTAL_NUMBER) ? Integer.valueOf(getText(ELEMENT_PAGINATOR_TOTAL_NUMBER)) : 1;
				int i = 1;
				while (isElementNotPresent(locator)) {
					if (i == totalPages) {
						info(exceptionMessage);
						break;
					}
					click(ELEMENT_PAGINATOR_NEXT_ICON);
					i ++;
					pause(500);
				}
			}else {
				waitForElementPresent(locator);
			}
		} 
	}
	
	/**function: active/deactivate a question
	 * @author lientm
	 * @param question: title of question
	 * @param active: = true: active
	 * 				  = false: deactivate
	 */
	public static void activeQuestion(String question, boolean active){
		By element_activate = By.xpath(ELEMENT_MANAGE_QUESTION_ACTIVATE.replace("${question}", question));
		By element_deactivate = By.xpath(ELEMENT_MANAGE_QUESTION_DEACTIVATE.replace("${question}", question));
		
		if (active){
			usePaginatorQuestion(element_activate, "Can not found question");
			WebElement act = waitForAndGetElement(element_activate, 30000, 0);
			if (act != null){				
				click(element_activate);
				waitForElementPresent(element_deactivate);
				info("active question successfully");
			} else info("Question is being activate");
		} else {
			usePaginatorQuestion(element_deactivate, "Can not found question");
			WebElement de_act = getElement(element_deactivate);
			if (de_act != null){
				click(element_deactivate);
				waitForElementPresent(element_activate);
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
	public static void approveQuestion(String question, boolean approve){
		By element_app = By.xpath(ELEMENT_MANAGE_QUESTION_APPROVE.replace("${question}", question));
		By element_disapp = By.xpath(ELEMENT_MANAGE_QUESTION_DISAPPROVE.replace("${question}", question));
		
		if (approve){
			usePaginatorQuestion(element_app, "Can not found question");
			WebElement act = waitForAndGetElement(element_app, 30000, 0);
			if (act != null){				
				click(element_app);
				waitForElementPresent(element_disapp);
				info("approve question successfully");
			} else info("Question is being approve");
		} else {
			usePaginatorQuestion(element_disapp, "Can not found question");
			WebElement de_act = waitForAndGetElement(element_disapp, 30000, 0);
			if (de_act != null){
				click(element_disapp);
				waitForElementPresent(element_app);
				info("disapprove question successfully");
			} else info("Question is being disapprove");
		}
	}
	/*	---------------------------End of common for question-----------------------------------*/


	/*	---------------------------Common functions for Category, Note: For category name with 17 characters-----------------------------------*/

	//	Go to home Category 
	public static void goToHomeCategoryInAnswer(){
		By ELEMENT_HOME_CATEGORY=By.xpath("//img[@alt='categories']");

		waitForElementPresent(ELEMENT_HOME_CATEGORY);
		click(ELEMENT_HOME_CATEGORY);
	}

	/**
	 * Open a category
	 * @author hakt
	 * @param categoryName
	 */
	public static void goToACategoryInAnswer(String categoryName){
		By ELEMENT_CATEGORY_LINK=By.xpath("//a[@title='"+categoryName+"']");
		//	waitForElementPresent(ELEMENT_CATEGORY_LINK);
		click(ELEMENT_CATEGORY_LINK);
	}

	/**
	 * @author lientm
	 * @param name_edit
	 * @param order
	 * @param setAudience
	 * @param audience
	 * @param description
	 * @param setModerator
	 * @param moderator
	 * @param opt: option to check
	 */
	public static void modifyDataInCategory(String name_edit, String order, int setAudience, String[] audience, String description, 
			int setModerator, String[] moderator, boolean... opt){
		if (name_edit != ""){
			type(ELEMENT_CATEGORY_NAME, name_edit ,true);
		}
		if (order != ""){
			type(ELEMENT_ORDER, order, true);
		}
		ForumBase.setPermissionWithOption("userPrivate", setAudience, audience);
		if (description != ""){
			type(ELEMENT_DESCRIPTION, description, true);
		}
		if (opt.length > 0){
			WebElement moder = waitForAndGetElement(ELEMENT_MODERATE_NEW_QUESTION);
			if ((opt[0] == true && moder.isSelected() == false) || (opt[0] == false && moder.isSelected() == true))
				click(ELEMENT_MODERATE_NEW_QUESTION);
		}
		if (opt.length > 1){
			WebElement quest = waitForAndGetElement(ELEMENT_VIEW_QUESTION_AUTHOR);
			if ((opt[1] == true && quest.isSelected() == false) || (opt[1] == false && quest.isSelected() == true))
				click(ELEMENT_VIEW_QUESTION_AUTHOR);
		}
		if (opt.length > 2){
			WebElement ans = waitForAndGetElement(ELEMENT_MODERATE_ANSWER);
			if ((opt[2] == true && ans.isSelected() == false) || (opt[2] == false && ans.isSelected() == true))
				click(ELEMENT_MODERATE_ANSWER);
		}
		ForumBase.setPermissionWithOption("moderator", setModerator, moderator);
		save();
	}

	/**
	 * @author lientm
	 * Create Category in Answer by typing user/ group directly
	 * @param categoryName: String
	 * @param order: string
	 * @param setAudience: way to set audience
	 * @param audience: user/group audience
	 * @param description: string
	 * @param setModerator: way to set moderator
	 * @param moderator: user/group moderator
	 * @param opt: group checkbox
	 */
	public static void addNewCategoryInAnswer(String categoryName, String order, int setAudience, String[] audience, String description,
			int setModerator, String[] moderator, boolean... opt){
		info("Create new category");
		//		Click category
		waitForElementPresent(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_CATEGORY_BUTTON);

		//Click Add Category
		waitForElementPresent(ELEMENT_ADD_CATEGORY_LINK);
		click(ELEMENT_ADD_CATEGORY_LINK);

		modifyDataInCategory(categoryName, order, setAudience, audience, description, setModerator, moderator, opt);
		waitForElementPresent(By.xpath("//a[@title='" + categoryName + "']"));
	}

	//	Edit an opening category
	/**
	 * @author hakt
	 * @param name_edit
	 * @param order
	 * @param setAudience
	 * @param audience
	 * @param description
	 * @param setModerator
	 * @param moderator
	 * @param opt
	 */
	public static void editOpeningCategoryInAnswer(String name_edit, String order, int setAudience, String[] audience, String description, 
			int setModerator, String[] moderator, boolean... opt){
		info("Edit an opening category");

		waitForElementPresent(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_CATEGORY_BUTTON);

		waitForElementPresent(ELEMENT_EDIT_CATEGORYON_MENU);
		click(ELEMENT_EDIT_CATEGORYON_MENU);

		modifyDataInCategory(name_edit, order, setAudience, audience, description, setModerator, moderator, opt);

		//Verify result of editing
		waitForElementPresent(By.xpath("//div[@class='Selected ControlButton LastItem' and text()='" + name_edit + "']"),50000);
	}	
	
	/**
	 * Edit current category with an invalid moderator
	 * 
	 * @author dunghm
	 * @param name_edit : new category name
	 * @param order : order of category in the category navigation
	 * @param setAudience : Kind of entering the audience
	 * @param audience : the audience of category
	 * @param description : Description about category
	 * @param setModerator : Kind of entering the moderator
	 * @param invalidModerator : a wrong moderator
	 */
	public static void editWithInvalidModerator(String name_edit, String order, int setAudience, String[] audience, String description, 
	                                            int setModerator, String[] invalidModerator){
   info("Edit an opening category");  
   waitForElementPresent(ELEMENT_CATEGORY_BUTTON);
   click(ELEMENT_CATEGORY_BUTTON);
  
   waitForElementPresent(ELEMENT_EDIT_CATEGORYON_MENU);
   click(ELEMENT_EDIT_CATEGORYON_MENU);
   modifyDataInCategory(name_edit, order, setAudience, audience, description, setModerator, invalidModerator);   
   waitForMessage("The field \"Moderator\" is invalid: " + invalidModerator[0] + ". Please check again.");
   click(By.linkText("OK"));
  }
	//	Edit an category by right-click
	/**
	 * @author hakt
	 * @param categoryLink
	 * @param name_edit
	 * @param order
	 * @param setAudience
	 * @param audience
	 * @param description
	 * @param setModerator
	 * @param moderator
	 * @param opt
	 */
	public static void editNotOpeningCategoryInAnswer(By categoryLink, String name_edit, String order, int setAudience, String[] audience, String description, 
			int setModerator, String[] moderator, boolean... opt){
		info("Edit a category by right-click");
		waitForElementPresent(categoryLink);
		rightClickOnElement(categoryLink);

		click(ELEMENT_EDIT_CATEGORY_RIGHT_CLICK);

		modifyDataInCategory(name_edit, order, setAudience, audience, description, setModerator, moderator, opt);

		//Verify result of editing
		waitForElementPresent(By.xpath("//span[text()='" +name_edit+ "']"));
	}


	/**
	 * Delete Opening Category by clicking Category then click Delete
	 * @param categoryName
	 */
	public static void deleteOpeningCategoryInAnswer(String categoryName){
		
		info("Delete a category by clicking Category then click Delete");

		waitForElementPresent(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_CATEGORY_BUTTON);

		waitForElementPresent(ELEMENT_DELETE_CATEGORY_ON_MENU);
		click(ELEMENT_DELETE_CATEGORY_ON_MENU);
		waitForConfirmation(MSG_DELETE_CATEGORY);
		waitForElementNotPresent(By.xpath("//span[text()='"+categoryName+"']"));
	}

	/**
	 * Delete Category by right click Category then click Delete
	 * @param categoryName
	 */

	public static void deleteNotOpeningCategoryInAnswer(String categoryName, boolean...verify){
		boolean valid = verify.length > 0 ? verify[0]: true;
		info("Delete a category by right-click Category then click Delete");
		By categoryLink=By.xpath("//span[text()='"+categoryName+"']");

		rightClickOnElement(categoryLink);

		//waitForAndGetElement(ELEMENT_DELETE_CATEGORY_RIGHTCLICK).click();
		click(ELEMENT_DELETE_CATEGORY_RIGHTCLICK);

		waitForConfirmation(MSG_DELETE_CATEGORY);
		if (valid){
			waitForElementNotPresent(By.xpath("//span[text()='"+categoryName+"']"));
		}		
	}
	/*	---------------------------End of common functions for Category-----------------------------------*/

	/*	---------------------------Answer a question-----------------------------------*/

	/** function: modify data of anwser
	 * @author lientm
	 * @param language: language of answer
	 * @param answerContent: content of answer
	 * @param approved: check approved
	 * @param activated: check activated
	 * @param addRelation: = true: add relation
	 * 					   = false: not add
	 * @param questionToLink: array of questions to add relation
	 * @param removeRelation: = true: remove relation
	 * 						  = false: not remove
	 * @param questionIndex: index of question that need remove
	 */
	public static void modifyAnwser(String language, String answerContent, boolean approved, boolean activated, boolean addRelation, By[] questionToLink, boolean removeRelation, int... questionIndex){
		waitForElementPresent(ELEMENT_ANSWER_CONTENTFRAME_1);
		if (language != "" && language != null){
			selectOption(ELEMENT_ANSWER_LANGUAGE, language);
		}
		if (answerContent != "" && answerContent != null){
			inputDataToFrameInFrame(ELEMENT_ANSWER_CONTENTFRAME_1, ELEMENT_ANSWER_CONTENTFRAME_2, answerContent, true);
			switchToParentWindow();
		}
		WebElement app = waitForAndGetElement(ELEMENT_APPROVED_ANSWER,5000,0);
		if (app!=null)
			if((approved == true && app.isSelected() == false) || (approved == false && app.isDisplayed() == true)){
				click(ELEMENT_APPROVED_ANSWER);
			}
		WebElement act = waitForAndGetElement(ELEMENT_ACTIVATED_ANSWER,5000,0);
		if (act != null)
			if((activated == true && act.isSelected() == false) || (activated == false && act.isDisplayed() == true)){
				click(ELEMENT_ACTIVATED_ANSWER);
			}
		if(addRelation == true){
			addRelationForAnswer(questionToLink);
		}
		if (removeRelation == true){
			removeRelationForAnswer(questionIndex);
		}
		save();
	}
	
	/**
	 * Answer a not opening question
	 * @author hakt
	 * @param questionLink: link of question to answer
	 * @param language: language of answer
	 * @param answerContent: question content
	 * @param approved: default is checked, so if true is unchecked approve, false is checked
	 * @param activated: default is checked, so if true is unchecked approve, false is checked
	 * @param relation: True is adding relation, false is not adding relation
	 */
	public static void answerNotOpeningQuestion(By questionLink, String language, String answerContent, boolean approved, boolean activated, boolean addRelation, By[] questionToLink, boolean removeRelation, int... questionIndex){
		rightClickOnElement(questionLink);
		waitForElementPresent(ELEMENT_ANSWER_NOT_OPENING_QUESTION);
		click(ELEMENT_ANSWER_NOT_OPENING_QUESTION);

		modifyAnwser(language, answerContent, approved, activated, addRelation, questionToLink, removeRelation, questionIndex);
	}

	/**
	 * answer opening question
	 * @author hakt
	 * @param questionLink
	 * @param language: language of answer
	 * @param answerContent
	 * @param approved
	 * @param activated
	 * @param addRelation
	 * @param questionToLink
	 * @param removeRelation
	 * @param questionToRemove
	 */
	public static void answerOpeningQuestion(By questionLink, String language, String answerContent, boolean approved, boolean activated, boolean addRelation, boolean removeRelation, int questionIndex, By... questionToLink){
		click(questionLink);
		waitForElementPresent(ELEMENT_ANSWER_OPENING_QUESTION);
		click(ELEMENT_ANSWER_OPENING_QUESTION);

		modifyAnwser(language, answerContent, approved, activated, addRelation, questionToLink, removeRelation, questionIndex);
		waitForElementPresent(By.xpath("//p[text()='" + answerContent + "']"));
	}
	/**
	 * Answer a question without advanced options
	 * @param questionLink Locator of question link
	 * @param answerContent Content of an answer
	 */
	public static void quickAnswer(By questionLink, String answerContent){
    click(questionLink);
    waitForElementPresent(ELEMENT_ANSWER_OPENING_QUESTION);
    click(ELEMENT_ANSWER_OPENING_QUESTION);

    inputDataToFrameInFrame(ELEMENT_ANSWER_CONTENTFRAME_1, ELEMENT_ANSWER_CONTENTFRAME_2, answerContent, false);
    switchToParentWindow();
    pause(1000);    
    save();
  }


	/**
	 * Edit opening answer
	 * @author hakt
	 * @param editedAnswerContent
	 * @param approved
	 * @param activated
	 * @param relation
	 * @param questionToLink
	 * @param removeRelation
	 * @param questionToRemove
	 */
	public static void editAnswer(String language, String editedAnswerContent, boolean approved, boolean activated, boolean addRelation, boolean removeRelation, int questionIndex, By... questionToLink){
		//		click(questionLink);
		waitForElementPresent(ELEMENT_EDIT_ANSWER);
		click(ELEMENT_EDIT_ANSWER);

		modifyAnwser(language, editedAnswerContent, approved, activated, addRelation, questionToLink, removeRelation, questionIndex);
	}


	//	delete Answer
	public static void deleteAnswer(){
		waitForElementPresent(ELEMENT_DELETE_ANSWER);
		click(ELEMENT_DELETE_ANSWER);
		waitForConfirmation("Are you sure to delete this answer?");
	}
	/**	Approve answer
	 * @author thuntn
	 * @param answer: content of answer
	 * @param user: a user who answers
	 * @param approve = true: approve
	 * 				  = false: disapprove	
	 */
	public static void approveAnswer(String answer, String user, boolean approve){
		By eApprove = By.xpath(ELEMENT_ANSWER_APPROVE.replace("{$answer}", answer).replace("{$user}", user));
		By eDisappove = By.xpath(ELEMENT_ANSWER_DISAPPROVE.replace("{$answer}", answer).replace("{$user}", user));
		
		if (approve){
			WebElement act = waitForAndGetElement(eApprove, 30000,0);
			if (act != null){				
				click(eApprove);
				waitForElementPresent(eDisappove);
				info("--Approve answer successfully--");
			} else info("Answer is approved");
		} else {
			WebElement de_act = waitForAndGetElement(eDisappove, 30000, 0);
			if (de_act != null){
				click(eDisappove);
				waitForElementPresent(eApprove);
				info("Disapprove answer successfully");
			} else info("Answer is disapproved");
		}
	}
	//End of common function for Answer a question

	//	Search in Answer
	//Simple search
	/**
	 * @param keyword
	 * @return
	 */
	public static boolean simpleSearchInAnswer(String keyword){
		boolean delete = true;

		type(ELEMENT_SIMPLESEARCH_TEXTBOX_IN_ANSWER, keyword, true);
		click(ELEMENT_SIMPLESEARCH_ICON);
		if (isElementPresent(By.xpath("//div[contains(text(),'"+keyword+"')]")))
		{
			return delete;}
		else {
			delete = false;
			return delete;}
	}

	//Simple search not return result
	public static boolean notSimpleSearchInAnswer(String keyword) {
		return !simpleSearchInAnswer(keyword);
	}
	/*	---------------------------End of Answer a question-----------------------------------*/


	/*	---------------------------Relation to other question-----------------------------------*/

	/**
	 * Add Relation
	 * @author hakt
	 * @param questionlink: list of question objects user want to add relation, eg. //*[@id='FAQCate0'][2]/input
	 */
	public static void addRelationForAnswer(By[] questionlink){
		if (questionlink.length > 0){
			click(ELEMENT_ADD_RELATION);
			click(ELEMENT_CATEGORY_TREE);
			for(int i = 0; i < questionlink.length; i ++){
				WebElement quest = waitForAndGetElement(questionlink[i], 10000, 0);
				if ( quest != null && quest.isSelected() == false)
					check(questionlink[i]);
			}
			save();
		}
	}

	/**
	 * Remove Relation
	 * @author hakt
	 * @param index: integer as index of question to remove  
	 */
	public static void removeRelationForAnswer(int... index){
		if (index.length > 0){
			for (int i = 0; i < index.length; i ++) {
				By remove = By.xpath(ELEMENT_REMOVE_RELATION.replace("${No}", Integer.toString(i + 1)));
				click(remove);
			}
		}
	}
	/*	---------------------------End of Relation to other question-----------------------------------*/

	////////////
	/////
	/**
	* 
	* @author vuna2
	* Create a simple question at Answer Portlet
	* @param questionName: title of question (String)
	* @param questionContent: question in details (String)
	* @param upload: boolean
	* @param filePaths: 
	*/
	public static void createNewQuestionAtAnswersApplication(String language, String questionName, String questionContent, boolean upload, String filePaths){
		info("-- Creating a new question at Answer Portlet --");
		goToAnswer();
		info("-- Open a submit question form and Add a question--");
		submitQuestion(language, questionName, questionContent, upload, filePaths);
		//closeMessageDialog();
		pause(500);
		info("-- Opening a question --");
		openAQuestion(questionName);
	}
	
	/**
	* 
	* @author vuna2
	* @param questionName: title of question (String)
	*/
	public static void deleteNotOpeningQuestion(String questionName){
		info("-- Deleting a question at Answer Portlet --");
		By ELEMENT_QUESTION_TO_DELETE = By.xpath("//*[contains(@id,'UIContextPopupMenu')]/a[text()='"+ questionName +"']");
		rightClickOnElement(ELEMENT_QUESTION_TO_DELETE);
		click(ELEMENT_DELETE_QUESTION_NOT_OPEN);
		click(By.linkText("OK"));
		waitForElementNotPresent(ELEMENT_QUESTION_TO_DELETE);
		pause(500);
	}
	
	/**
	* @author vuna2
	* @param questionName: title of question (String)
	*/
	public static void resetDataByDeletingQuestion(String questionName){
		info("-- Delete the question: " + questionName);
		click(By.linkText(questionName));
		deleteNotOpeningQuestion(questionName);
	}
	/** Sign out, Sign in as another user account, go to answer
	 * @author thuntn
	 * @param user
	 */
	public void goToAnswerPortlet(String user){
		signOut();
		driver.get(baseUrl);
		signIn(user, "gtn");
		goToAnswer();
	}
	////
	///////
	
}