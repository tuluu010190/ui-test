package org.exoplatform.selenium.platform.answer;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.exoplatform.selenium.TestLogger.info;
public class QuestionManagement extends PlatformBase {
	PlatformPermission per;
	ManageAlert alert;
	Button button;
	AnswerHomePage aHome;

	//Manage question form
	public By ELEMENT_MANAGE_QUESTION_FORM=By.id("FAQQuestionManagerment");
	public By ELEMENT_MANAGE_QUESTION_FORM_ALL_QUESTION_TAB=By.xpath("//*[@data-toggle='tab' and text()='All Questions']");
	public By ELEMENT_MANAGE_QUESTION_FORM_OPEN_QUESTION_TAB=By.xpath("//*[@data-toggle='tab' and text()='Open Questions']");
	public String ELEMENT_MANAGE_QUESTION_ANSWER_QUESTION="//*[text()='$question']/../..//*[@data-original-title='Answer']";
	public String ELEMENT_MANAGE_QUESTION_EDIT_QUESTION="//*[text()='$question']/../..//*[@data-original-title='Edit']";
	public String ELEMENT_MANAGE_QUESTION_DELETE_QUESTION="//*[text()='$question']/../..//*[@data-original-title='Delete']";
	public String ELEMENT_MANAGE_QUESTION_APPROVE_QUESTION_CHECKBOX="//*[text()='$question']/..//*[@data-original-title='Approve' or @data-original-title='Disapprove']//*[@id='allDay']";
	public String ELEMENT_MANAGE_QUESTION_ACTIVE_QUESTION_CHECKBOX="//*[text()='$question']/..//*[@data-original-title='Deactivate' or @data-original-title='Activate']//*[@id='allDay']";
	public By ELEMENT_MANAGE_QUESTION_CLOSE_BUTTON=By.xpath("//*[@id='UIAnswersPopupAction']//*[text()='Close']");

	//Submit Question form
	public By ELEMENT_SUBMIT_QUESTION_FORM = By.id("UIQuestionForm");
	public By ELEMENT_SUBMIT_QUESTION_FORM_TITLE_INPUT=By.id("QuestionTitle");
	public By ELEMENT_SUBMIT_QUESTION_FORM_DATA_FRAME_INPUT=By.xpath("//*[@class='cke_wysiwyg_frame cke_reset']");
	public By ELEMENT_SUBMIT_QUESTION_FORM_LANGUAGE_SELECT_BOX=By.name("AllLanguages");
	public By ELEMENT_SUBMIT_QUESTION_FORM_DELETE_LANG_BUTTON=By.xpath("//*[@name='AllLanguages']/../..//*[@data-original-title='Remove']");
	public By ELEMENT_SUBMIT_QUESTION_FORM_AUTHOR=By.id("Author");
	public By ELEMENT_SUBMIT_QUESTION_FORM_EMAIL=By.id("EmailAddress");
	public By ELEMENT_SUBMIT_QUESTION_FORM_ATTACHMENT_BUTTON=By.xpath("//*[@class='uiIconAttach uiIconLightGray']");
	public String ELEMENT_SUBMIT_QUESTION_FORM_DELETE_ATTACHMENT_BUTTON="//*[@data-original-title='$file']/../..//*[@data-original-title='Remove']";
	public By ELEMENT_SUBMIET_QUESTION_APPROVE_CHECKBOX=By.id("IsApproved");
	public By ELEMENT_SUBMIET_QUESTION_ACTIVE_CHECKBOX=By.id("IsActivated");
	public By ELEMENT_SUBMIT_QUESTION_FORM_SAVE_BUTTON=By.xpath("//*[@id='UIQuestionForm']//*[text()='Save']");
	public By ELEMENT_SUBMIT_QUESTION_FORM_CANCEL_BUTTON=By.xpath("//*[@id='UIQuestionForm']//*[text()='Cancel']");
	public By ELEMENT_QUESTION_FILE_INPUT = By.xpath("//*[@name='file']");

	//Attach file form
	public By ELEMENT_ATTACH_SAVE_BUTTON = By.xpath("//form[@id='UIAttachmentForm']//*[text()='Save']");
	public String ELEMENT_ATTACHMENT_FORM_FILE_NAME = "//*[text()='$fileName']";
	public String ELEMENT_ATTACH_FILE_NAME = "//*[@data-original-title='$fileName']";

	//More actions
	public By ELEMENT_QUESTION_MORE_ACTION_BUTTON=By.xpath("//*[contains(@class,'answersContainer')]//*[contains(@class,'actionBar')]//*[contains(@class,'uiIconSettings')]");
	public By ELEMENT_QUESTION_PRINT_BUTTON=By.xpath("//*[contains(@class,'answersContainer')]//*[contains(@class,'actionBar')]//*[contains(@class,'uiIconPrint')]");
	public By ELEMENT_QUESTION_EDIT_BUTTON=By.xpath("//*[contains(@class,'answersContainer')]//*[contains(@class,'actionBar')]//*[contains(@class,'uiIconEdit')]");
	public By ELEMENT_QUESTION_MOVE_BUTTON=By.xpath("//*[contains(@class,'answersContainer')]//*[contains(@class,'actionBar')]//*[contains(@class,'uiIconMove')]");
	public By ELEMENT_QUESTION_SEND_BUTTON=By.xpath("//*[contains(@class,'answersContainer')]//*[contains(@class,'actionBar')]//*[contains(@class,'uiIconAnsSentMail')]");
	public By ELEMENT_QUESTION_DELETE_BUTTON=By.xpath("//*[contains(@class,'answersContainer')]//*[contains(@class,'actionBar')]//*[contains(@class,'uiIconTrash')]");

	//Question menu action
	public String ELEMENT_QUESTION_COMMENT="//*[@class='rightContent']//*[text()='$question']//ancestor::*[@class='rightContent']//*[@class='uiIconComment uiIconLightGray']";
	public String ELEMENT_QUESTION_ANSWER="//*[@class='rightContent']//*[text()='$question']//ancestor::*[@class='rightContent']//*[@class='uiIconAnsAnswer uiIconLightGray']";
	public String ELEMENT_QUESTION_EDIT="//*[@class='rightContent']//*[text()='$question']//ancestor::*[@class='rightContent']//*[@class='uiIconEdit uiIconLightGray']";
	public String ELEMENT_QUESTION_DELETE="//*[@class='rightContent']//*[text()='$question']//ancestor::*[@class='rightContent']//*[@class='uiIconTrash uiIconLightGray']";
	public String ELEMENT_QUESTION_MOVE="//*[@class='rightContent']//*[text()='$question']//ancestor::*[@class='rightContent']//*[@class='uiIconMove uiIconLightGray']";
	public String ELEMENT_QUESTION_SEND="//*[@class='rightContent']//*[text()='$question']//ancestor::*[@class='rightContent']//*[@class='uiIconAnsSentMail uiIconLightGray']";

	//Comment question form
	public By ELEMENT_QUESTION_COMMENT_FORM=By.id("UICommentForm");

	//Answer question form
	public By ELEMENT_QUESTION_ANSWER_FORM=By.id("UIAnswersPopupWindow");

	//Edit question form
	public By ELEMENT_QUESTION_EDIT_FORM=By.id("UIQuestionForm");

	//Delete question form
	public By ELEMENT_QUESTION_DELETE_FORM=By.id("UIDeleteQuestion");
	public By ELEMENT_QUESTION_CONFIRM_DELETE=By.xpath("//*[@id='UIDeleteQuestion']//*[contains(text(),'Are you sure you want to delete this question and its answers?')]");
	public By ELEMENT_QUESTION_DELETE_FORM_OK_BUTTON=By.xpath("//*[@id='UIDeleteQuestion']//*[text()='OK']");
	public By ELEMENT_QUESTION_DELETE_FORM_CANCEL_BUTTON=By.xpath("//*[@id='UIDeleteQuestion']//*[text()='Cancel']");

	//Move question form
	public By ELEMENT_QUESTION_MOVE_FORM=By.id("FAQMoveQuestion");

	//Send question form
	public By ELEMENT_QUESTION_SEND_FORM=By.id("FAQSendMailForm");
	public By ELEMENT_QUESTION_SEND_TO_INPUT=By.id("To");
	public By ELEMENT_QUESTION_SEND_SEND_BUTTON=By.xpath("//*[@id='FAQSendMailForm']//*[text()='Send']");
	public By ELEMENT_QUESTION_OK_BUTTON=By.xpath("//*[contains(@class,'UIPopupWindow')]//a[text()='OK']");

	//Vote question
	public String ELEMENT_QUESTION_RATE_ITEM="//*[@data-original-title='Rate Question']/*[@data-index='$index']";
	public String ELEMENT_QUESTION_RATE_NUMBER="//*[contains(@class,'voteResult')]//*[contains(text(),'$index')]";
	/**
	 * constructor
	 * @param dr
	 */
	public QuestionManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
		aHome = new AnswerHomePage(dr);
	}

	/**
	 * Go to mange question form
	 */
	public void goToManageQuestionForm(){
		info("Go to mange question");
		click(aHome.ELEMENT_MANAGE_QUESTION_BUTTON);
		waitForAndGetElement(ELEMENT_MANAGE_QUESTION_FORM);
	}

	/**
	 * goToSubmitQuestion
	 */
	public void goToSubmitQuestion(){
		info("Open submin question form");
		click(aHome.ELEMENT_SUBMIT_QUESTION);
		waitForAndGetElement(ELEMENT_SUBMIT_QUESTION_FORM);
	}

	/**
	 * input data to question form
	 * @param title
	 * @param content
	 * @param language
	 * @param pathFile
	 */
	public void inputDataToQuestionForm(String title, String content, String language, String pathFile){
		info("input title");
		if(title!=null && title!=""){
			type(ELEMENT_SUBMIT_QUESTION_FORM_TITLE_INPUT,title,true);
		}
		info("input content");
		if(content!=null && content!=""){
			inputDataToCKEditor(ELEMENT_SUBMIT_QUESTION_FORM_DATA_FRAME_INPUT,content);
		}
		info("input language");
		if(language!=null && language!=""){
			select(ELEMENT_SUBMIT_QUESTION_FORM_LANGUAGE_SELECT_BOX,language);
		}
		info("input pathFile");
		if(pathFile!=null && pathFile!=""){
			String[] links = pathFile.split("/");
			click(ELEMENT_SUBMIT_QUESTION_FORM_ATTACHMENT_BUTTON);
			WebElement eFile = waitForAndGetElement(ELEMENT_QUESTION_FILE_INPUT,DEFAULT_TIMEOUT,1,2);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';",eFile);
			eFile.sendKeys(Utils.getAbsoluteFilePath(pathFile));
			waitForAndGetElement(ELEMENT_ATTACHMENT_FORM_FILE_NAME.replace("$fileName", links[links.length-1]));
			click(ELEMENT_ATTACH_SAVE_BUTTON);
			waitForAndGetElement(ELEMENT_ATTACH_FILE_NAME.replace("$fileName", links[links.length-1]));
			switchToParentWindow();
		}
	}

	/**
	 * action menu of question
	 */
	public enum actionQuestionOption{
		COMMENT, ANSWER, EDIT, DELETE, MOVE, SEND, PRINT
	}

	/**
	 * Execute action of question: COMMENT, ANSWER, EDIT, DELETE, MOVE, SEND
	 * @param question
	 * @param action
	 * 				action that needs to be done
	 */
	public void goToActionOfQuestionByRightClick(String question, actionQuestionOption action){
		info("Select action from menu");
		rightClickOnElement(By.xpath(aHome.ELEMENT_QUESTION_LIST_ITEM.replace("$question", question)));
		switch(action){
		case COMMENT:
			info("Comment question");
			click(ELEMENT_QUESTION_COMMENT.replace("$question", question));
			waitForAndGetElement(ELEMENT_QUESTION_COMMENT_FORM);
			break;
		case ANSWER:
			info("Answer question");
			click(ELEMENT_QUESTION_ANSWER.replace("$question", question));
			waitForAndGetElement(ELEMENT_QUESTION_ANSWER_FORM);
			break;
		case EDIT:
			info("Edit question");
			click(ELEMENT_QUESTION_EDIT.replace("$question", question));
			waitForAndGetElement(ELEMENT_QUESTION_EDIT_FORM);
			break;
		case DELETE:
			info("Delete question");
			click(ELEMENT_QUESTION_DELETE.replace("$question", question));
			waitForAndGetElement(ELEMENT_QUESTION_DELETE_FORM);
			break;
		case MOVE:
			info("Move question");
			click(ELEMENT_QUESTION_MOVE.replace("$question", question));
			waitForAndGetElement(ELEMENT_QUESTION_MOVE_FORM);
			break;
		case SEND:
			info("Send question");
			click(ELEMENT_QUESTION_SEND.replace("$question", question));
			waitForAndGetElement(ELEMENT_QUESTION_SEND_FORM);
			break;
		default:
			info("Do nothing");
			break;
		}
	}

	/**
	 * Execute action of question: PRINT, EDIT, DELETE, MOVE, SEND
	 * @param action
	 * 				action that needs to be done
	 */
	public void goToActionOfQuestionFromMoreAction(actionQuestionOption action){
		info("Select action from menu");
		click(ELEMENT_QUESTION_MORE_ACTION_BUTTON);
		switch(action){
		case PRINT:
			info("PRINT question");
			click(ELEMENT_QUESTION_PRINT_BUTTON);
			break;
		case EDIT:
			info("EDIT question");
			click(ELEMENT_QUESTION_EDIT_BUTTON);
			waitForAndGetElement(ELEMENT_QUESTION_EDIT_FORM);
			break;
		case DELETE:
			info("DELETE question");
			click(ELEMENT_QUESTION_DELETE_BUTTON);
			waitForAndGetElement(ELEMENT_QUESTION_DELETE_FORM);
			break;
		case MOVE:
			info("MOVE question");
			click(ELEMENT_QUESTION_MOVE_BUTTON);
			waitForAndGetElement(ELEMENT_QUESTION_MOVE_FORM);
			break;
		case SEND:
			info("SEND question");
			click(ELEMENT_QUESTION_SEND_BUTTON);
			waitForAndGetElement(ELEMENT_QUESTION_SEND_FORM);
			break;
		default:
			info("Do nothing");
			break;
		}
	}

	/**
	 * Delete question
	 * @param question
	 */
	public void deleteQuestion(String question){
		info("Delete question");
		goToActionOfQuestionByRightClick(question, actionQuestionOption.DELETE);
		waitForAndGetElement(ELEMENT_QUESTION_CONFIRM_DELETE);
		click(ELEMENT_QUESTION_DELETE_FORM_OK_BUTTON);
		waitForElementNotPresent(By.xpath(aHome.ELEMENT_QUESTION_LIST_ITEM.replace("$question", question)));
	}

	/**
	 * Cancel to Delete question
	 * @param question
	 */
	public void cancelDeleteQuestion(String question){
		info("Delete question");
		goToActionOfQuestionByRightClick(question, actionQuestionOption.DELETE);
		waitForAndGetElement(ELEMENT_QUESTION_CONFIRM_DELETE);
		click(ELEMENT_QUESTION_DELETE_FORM_CANCEL_BUTTON);
		waitForAndGetElement(By.xpath(aHome.ELEMENT_QUESTION_LIST_ITEM.replace("$question", question)));
	}

	/**
	 * Go to edit question from manage question form
	 * @param question
	 */
	public void goToEditQuestionFromManageQuestionForm(String question){
		info("Go to edit question from manage question form");
		if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
			click(ELEMENT_ANY_PAGE.replace("$page", "1"));
			while((waitForAndGetElement(ELEMENT_MANAGE_QUESTION_EDIT_QUESTION.replace("$question", question),5000,0)==null)
					&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
				click(ELEMENT_NEXT_PAGE);
		}
		click(ELEMENT_MANAGE_QUESTION_EDIT_QUESTION.replace("$question", question));
		waitForAndGetElement(ELEMENT_QUESTION_EDIT_FORM);
	}

	/**
	 * Go to delete question from manage question form
	 * @param question
	 */
	public void goToDeleteQuestionFromManageQuestionForm(String question){
		info("Go to delete question from manage question form");
		if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
			click(ELEMENT_ANY_PAGE.replace("$page", "1"));
			while((waitForAndGetElement(ELEMENT_MANAGE_QUESTION_DELETE_QUESTION.replace("$question", question),5000,0)==null)
					&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
				click(ELEMENT_NEXT_PAGE);
		}
		click(ELEMENT_MANAGE_QUESTION_DELETE_QUESTION.replace("$question", question));
		waitForAndGetElement(ELEMENT_QUESTION_DELETE_FORM);
	}

	/**
	 * Approve question or not from manage question form
	 * @param question
	 * @param isApprove
	 * 					true: check to approve
	 * 					false: uncheck to un-approve
	 */
	public void approveQuestionFromManageQuestionForm(String question, Boolean isApprove){
		if(isApprove){
			info("Approve question");
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while((waitForAndGetElement(ELEMENT_MANAGE_QUESTION_APPROVE_QUESTION_CHECKBOX.replace("$question", question),5000,0,2)==null)
						&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
					click(ELEMENT_NEXT_PAGE);
			}
			check(By.xpath(ELEMENT_MANAGE_QUESTION_APPROVE_QUESTION_CHECKBOX.replace("$question", question)),2);
		}
		else{
			info("Dis-approve question");
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while((waitForAndGetElement(ELEMENT_MANAGE_QUESTION_APPROVE_QUESTION_CHECKBOX.replace("$question", question),5000,0,2)==null)
						&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
					click(ELEMENT_NEXT_PAGE);
			}
			uncheck(By.xpath(ELEMENT_MANAGE_QUESTION_APPROVE_QUESTION_CHECKBOX.replace("$question", question)),2);
		}
	}

	/**
	 * Active question or not from manage question form
	 * @param question
	 * @param isActive
	 * 					true: check to active
	 * 					false: uncheck to un-active
	 */
	public void activeQuestionFromManageQuestionForm(String question, Boolean isActive){
		if(isActive){
			info("Active question");
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while((waitForAndGetElement(ELEMENT_MANAGE_QUESTION_ACTIVE_QUESTION_CHECKBOX.replace("$question", question),5000,0,2)==null)
						&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
					click(ELEMENT_NEXT_PAGE);
			}
			check(By.xpath(ELEMENT_MANAGE_QUESTION_ACTIVE_QUESTION_CHECKBOX.replace("$question", question)),2);
		}
		else{
			info("Un-active question");
			if(waitForAndGetElement(ELEMENT_TOTAL_PAGE,5000,0)!=null){
				click(ELEMENT_ANY_PAGE.replace("$page", "1"));
				while((waitForAndGetElement(ELEMENT_MANAGE_QUESTION_ACTIVE_QUESTION_CHECKBOX.replace("$question", question),5000,0,2)==null)
						&& !(waitForAndGetElement(ELEMENT_TOTAL_PAGE).getText().equals(waitForAndGetElement(ELEMENT_CURRENT_PAGE).getText())))
					click(ELEMENT_NEXT_PAGE);
			}
			uncheck(By.xpath(ELEMENT_MANAGE_QUESTION_ACTIVE_QUESTION_CHECKBOX.replace("$question", question)),2);
		}
	}

	/**
	 * Approve question or not
	 * @param isApprove
	 * 					true: check to approve
	 * 					false: uncheck to un-approve
	 */
	public void approveQuestion(Boolean isApprove){
		if(isApprove){
			info("Approve question");
			check(ELEMENT_SUBMIET_QUESTION_APPROVE_CHECKBOX,2);
		}
		else{
			info("Dis-approve question");
			uncheck(ELEMENT_SUBMIET_QUESTION_APPROVE_CHECKBOX,2);
		}
	}

	/**
	 * Active question or not
	 * @param isActive
	 * 					true: check to active
	 * 					false: uncheck to un-active
	 */
	public void activeQuestion(Boolean isActive){
		if(isActive){
			info("Active question");
			check(ELEMENT_SUBMIET_QUESTION_ACTIVE_CHECKBOX,2);
		}
		else{
			info("Un-active question");
			uncheck(ELEMENT_SUBMIET_QUESTION_ACTIVE_CHECKBOX,2);
		}
	}

	/**
	 * Rate question
	 * @param number
	 * 				number of rating
	 */
	public void rateQuestion(int number){
		info("Rate a question");
		String st = Integer.toString(number);
		if(number!=0){
			WebElement e1 = waitForAndGetElement(By.xpath(ELEMENT_QUESTION_RATE_ITEM.replace("$index", st)),DEFAULT_TIMEOUT,1,2);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", e1);
			waitForAndGetElement(ELEMENT_QUESTION_RATE_NUMBER.replace("$index", st));
		}
	}
}
