package org.exoplatform.selenium.platform.answer;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.exoplatform.selenium.TestLogger.info;
public class AnswerManagement  extends PlatformBase {
	AnswerHomePage aHome;

	//Answer form
	public By ELEMENT_ANSWER_BUTTON=By.xpath("//*[@class='questionAction']//*[text()='Answer']");
	public By ELEMENT_ANSWER_FORM=By.id("UIResponseForm");
	public By ELEMENT_ANSWER_FORM_DATA_FRAME_INPUT=By.xpath("//*[@class='cke_wysiwyg_frame cke_reset']");
	public By ELEMENT_ANSWER_APPROVE_CHECKBOX=By.id("QuestionApproved");
	public By ELEMENT_ANSWER_ACTIVATE_CHECKBOX=By.id("QuestionShowAnswer");
	public By ELEMENT_ANSWER_RELATED_BUTTON=By.xpath("//*[@class='uiIconLightGray uiIconPlus']");
	public By ELEMENT_ANSWER_FORM_SAVE_BUTTON=By.xpath("//*[@id='UIResponseForm']//*[text()='Save']");
	public By ELEMENT_ANSWER_FORM_CANCEL_BUTTON=By.xpath("//*[@id='UIResponseForm']//*[text()='Cancel']");

	//More actions
	public String ELEMENT_ANSWER_MORE_ACTION_BUTTON="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../../../..//*[@class='uiIconSettings uiIconLightGray']";
	public String ELEMENT_ANSWER_EDIT_BUTTON="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../../../..//*[@class='uiIconLightGray uiIconEdit']";
	public String ELEMENT_ANSWER_APPROVE_BUTTON="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../../../..//*[@class='uiIconLightGray uiIconEdit']";
	public String ELEMENT_ANSWER_DISAPPROVE_BUTTON="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../../../..//*[@class='uiIconAnsLightGray uiIconAnsDisapprove']";
	public String ELEMENT_ANSWER_ACTIVE_BUTTON="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../../../..//*[@class='uiIconAnsLightGray uiIconAnsEnable']";
	public String ELEMENT_ANSWER_DEACTIVE_BUTTON="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../../../..//*[@class='uiIconAnsLightGray uiIconAnsEnable']";
	public String ELEMENT_ANSWER_DELETE_BUTTON="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../../../..//*[@class='uiIconLightGray uiIconTrash']";
	
	//Answer container
	public String ELEMENT_ANSWER_AUTHOR="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../..//*[@class='userName' and contains(text(),'$fullname')]";
	public String ELEMENT_ANSWER_CONTENT="//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']";

	//Delete 
	public By ELEMENT_ANSWER_DELETE_CONFIRM_POPUP=By.id("UIForumPopupConfirmation");
	public By ELEMENT_ANSWER_CONFIRM_DELETE=By.xpath("//*[@id='UIForumPopupConfirmation']//*[contains(text(),'Are you sure you want to delete this answer ?')]");
	public By ELEMENT_ANSWER_DELETE_FORM_OK_BUTTON=By.xpath("//*[@id='UIForumPopupConfirmation']//*[text()='OK']");
	public By ELEMENT_ANSWER_DELETE_FORM_CANCEL_BUTTON=By.xpath("//*[@id='UIForumPopupConfirmation']//*[text()='Cancel']");

	//vote answer
	public final String ELEMENT_ANSWER_VOTE_ICON = "//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../..//*[contains(@id, 'FAQVoteAnswerUp')]";
	public final String ELEMENT_ANSWER_UNVOTE_ICON = "//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../..//*[contains(@id, 'FAQVoteAnswerDown')]";
	public final String ELEMENT_ANSWER_NUMBER_VOTE = "//*[@class='responseContainer']//*[contains(@id,'Answer')]//*[text()='$answer']/../../..//*[@class='textVoteAnswer']";
	public final By ELEMENT_SORT_BY_RATE = By.xpath("//a[@data-original-title='Sort Answers by Rate']");
	public final String ELEMENT_ANSWER_POSITION_IN_LIST = "//*[@class='responseContainer']//*[contains(@id,'Answer')][${no}]//*[text()='${answer}']";
	/**
	 * constructor
	 * @param dr
	 */
	public AnswerManagement(WebDriver dr){
		this.driver=dr;
		aHome = new AnswerHomePage(dr);
	}

	/**
	 * Go to answer a question
	 */
	public void goToAnswerQuestion(String question){
		info("Go to answer a question");
		if(waitForAndGetElement(aHome.ELEMENT_QUESTION_LIST_ITEM.replace("$question", question),5000,0)!=null)
			click(By.xpath(aHome.ELEMENT_QUESTION_LIST_ITEM.replace("$question", question)));
		waitForAndGetElement(By.xpath(aHome.ELEMENT_QUESTION_SELECTED_ITEM.replace("$question", question)));
		click(ELEMENT_ANSWER_BUTTON);
		waitForAndGetElement(ELEMENT_ANSWER_FORM);
	}

	/**
	 * Input data to answer form
	 * @param content
	 * @param isApprove
	 * @param isActive
	 * @param related
	 */
	public void inputDataToAnswer(String content, Boolean isApprove, Boolean isActive, String related){
		info("Input data to answer form");
		info("input content");
		if(content!=null && content!=""){
			inputDataToCKEditor(ELEMENT_ANSWER_FORM_DATA_FRAME_INPUT,content);
		}

		info("approve or not");
		if(isApprove!=null){
			if(isApprove)
				check(ELEMENT_ANSWER_APPROVE_CHECKBOX,2);
			else
				uncheck(ELEMENT_ANSWER_APPROVE_CHECKBOX,2);
		}

		info("active or not");
		if(isActive!=null){
			if(isActive)
				check(ELEMENT_ANSWER_ACTIVATE_CHECKBOX,2);
			else
				uncheck(ELEMENT_ANSWER_ACTIVATE_CHECKBOX,2);
		}

		info("input related questions");
		if(related!=null && related!=""){

		}
	}

	/**
	 * action menu of answer
	 */
	public enum actionAnswerOption{
		EDIT, APPROVE, DISAPPROVE, ACTIVE, DEACTIVE, DELETE
	}
	
	/**
	 * Execute action of answer: EDIT, APPROVE, DISAPPROVE, ACTIVE, DEACTIVE, DELETE
	 * @param answer
	 * @param action
	 * 				action that needs to be done
	 */
	public void goToActionOfAnswerFromMoreAction(String answer, actionAnswerOption action){
		info("Select action from menu");
		click(ELEMENT_ANSWER_MORE_ACTION_BUTTON.replace("$answer", answer));
		switch(action){
		case EDIT:
			info("EDIT answer");
			click(ELEMENT_ANSWER_EDIT_BUTTON.replace("$answer", answer));
			waitForAndGetElement(ELEMENT_ANSWER_FORM);
			break;
		case APPROVE:
			info("APPROVE answer");
			click(ELEMENT_ANSWER_APPROVE_BUTTON.replace("$answer", answer));
			click(ELEMENT_ANSWER_MORE_ACTION_BUTTON.replace("$answer", answer));
			waitForAndGetElement(ELEMENT_ANSWER_DISAPPROVE_BUTTON);
			break;
		case DISAPPROVE:
			info("DISAPPROVE answer");
			click(ELEMENT_ANSWER_DISAPPROVE_BUTTON.replace("$answer", answer));
			click(ELEMENT_ANSWER_MORE_ACTION_BUTTON.replace("$answer", answer));
			waitForAndGetElement(ELEMENT_ANSWER_APPROVE_BUTTON);
			break;
		case ACTIVE:
			info("ACTIVE answer");
			click(ELEMENT_ANSWER_ACTIVE_BUTTON.replace("$answer", answer));
			click(ELEMENT_ANSWER_MORE_ACTION_BUTTON.replace("$answer", answer));
			waitForAndGetElement(ELEMENT_ANSWER_DEACTIVE_BUTTON);
			break;
		case DEACTIVE:
			info("DEACTIVE answer");
			click(ELEMENT_ANSWER_DEACTIVE_BUTTON.replace("$answer", answer));
			click(ELEMENT_ANSWER_MORE_ACTION_BUTTON.replace("$answer", answer));
			waitForAndGetElement(ELEMENT_ANSWER_ACTIVE_BUTTON);
			break;
		case DELETE:
			info("DELETE answer");
			click(ELEMENT_ANSWER_DELETE_BUTTON.replace("$answer", answer));
			waitForAndGetElement(ELEMENT_ANSWER_DELETE_CONFIRM_POPUP);
			break;
		default:
			info("Do nothing");
			break;
		}
	}
	
	/**
	 * Delete answer
	 * @param answer
	 */
	public void deleteAnswer(String answer){
		info("Delete answer");
		goToActionOfAnswerFromMoreAction(answer, actionAnswerOption.DELETE);
		waitForAndGetElement(ELEMENT_ANSWER_CONFIRM_DELETE);
		click(ELEMENT_ANSWER_DELETE_FORM_OK_BUTTON);
		waitForElementNotPresent(ELEMENT_ANSWER_CONTENT.replace("$answer", answer));
	}
	
	/**
	 * function vote/unvote an answer
	 * @param answer
	 * @param rate
	 */
	public void rateAnswer(String answer, boolean rate){
		if (rate){
			info("Vote answer");
			click(ELEMENT_ANSWER_VOTE_ICON.replace("$answer", answer));
		} else {
			info("Unvote answer");
			click(ELEMENT_ANSWER_UNVOTE_ICON.replace("$answer", answer));
		}
	}
}
