package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class AnswerManageAnwser extends AnswerBase {

	public AnswerManageAnwser(WebDriver dr){
		driver = dr;
	}
	
	Button button;
	ManageAlert alert;
	
	//Manage answer for question
	public final By ELEMENT_ANSWER_NOT_OPENING_QUESTION=By.xpath("//a[@class='ItemIcon ResponseQuestion' and contains(text(),'Answer Question')]");
	public final By ELEMENT_ANSWER_OPENING_QUESTION=By.xpath("//a[@class='ResponseQuestion' and text()='Answer']");
	public final By ELEMENT_ANSWER_CONTENTFRAME_1= By.xpath("//iframe[@id='QuestionRespone___Frame']");
	public final By ELEMENT_ANSWER_CONTENTFRAME_2= By.xpath("//td[@id='xEditingArea']/iframe");
	public final By ELEMENT_APPROVED_ANSWER=By.id("IsApproved");
	public final By ELEMENT_ACTIVATED_ANSWER=By.id("QuestionShowAnswer");
	public final String ELEMENT_NUMBER_ANSWER = "//a[text()='${question}']/../../../*//a[2]/p[text()='1']";
	public final By ELEMENT_LAGUAGE_SELECTED = By.xpath("//*[@id='Language']/option[@selected='selected']");
	public final By ELEMENT_EDIT_ANSWER=By.xpath("//a[@class='ItemIcon Edit' and @title='Edit Answer']");
	public final By ELEMENT_DELETE_ANSWER=By.xpath("//a[@class='ItemIcon DeleteAnswer'and @title='Delete Answer']");
	public final By ELEMENT_ANSWER_LANGUAGE = By.id("Language");
	public final String ELEMENT_ANSWER_APPROVE = "//p[contains(text(),{$answer})]/../a/span[contains(text(),'{$user}')]/ancestor::div//a[@title='Approve']"; 
	public final String ELEMENT_ANSWER_DISAPPROVE = "//p[contains(text(),{$answer})]/../a/span[contains(text(),'{$user}')]/ancestor::div//a[@title='Disapprove']";
	public final String MSG_ANSWER_PENDING = "Your answer is pending for moderation. It will be displayed after approval.";
	public final String MSG_ANSWER_EMPTY = "Please provide an answer to the question.";
	
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
	public void modifyAnwser(String language, String answerContent, boolean approved, boolean activated, boolean addRelation, By[] questionToLink, boolean removeRelation, int... questionIndex){
		button = new Button(driver);
		waitForAndGetElement(ELEMENT_ANSWER_CONTENTFRAME_1);
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
		button.save();
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
	public  void answerNotOpeningQuestion(By questionLink, String language, String answerContent, boolean approved, boolean activated, boolean addRelation, By[] questionToLink, boolean removeRelation, int... questionIndex){
		rightClickOnElement(questionLink);
		waitForAndGetElement(ELEMENT_ANSWER_NOT_OPENING_QUESTION);
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
	public  void answerOpeningQuestion(By questionLink, String language, String answerContent, boolean approved, boolean activated, boolean addRelation, boolean removeRelation, int questionIndex, By... questionToLink){
		click(questionLink);
		waitForAndGetElement(ELEMENT_ANSWER_OPENING_QUESTION);
		click(ELEMENT_ANSWER_OPENING_QUESTION);

		modifyAnwser(language, answerContent, approved, activated, addRelation, questionToLink, removeRelation, questionIndex);
		waitForAndGetElement(By.xpath("//p[text()='" + answerContent + "']"));
	}
	/**
	 * Answer a question without advanced options
	 * @param questionLink Locator of question link
	 * @param answerContent Content of an answer
	 */
	public  void quickAnswer(By questionLink, String answerContent){
		button = new Button(driver);
	    click(questionLink);
	    waitForAndGetElement(ELEMENT_ANSWER_OPENING_QUESTION);
	    click(ELEMENT_ANSWER_OPENING_QUESTION);
	
	    inputDataToFrameInFrame(ELEMENT_ANSWER_CONTENTFRAME_1, ELEMENT_ANSWER_CONTENTFRAME_2, answerContent, false);
	    switchToParentWindow();
	    Utils.pause(1000);    
	    button.save();
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
	public  void editAnswer(String language, String editedAnswerContent, boolean approved, boolean activated, boolean addRelation, boolean removeRelation, int questionIndex, By... questionToLink){
		//		click(questionLink);
		waitForAndGetElement(ELEMENT_EDIT_ANSWER);
		click(ELEMENT_EDIT_ANSWER);

		modifyAnwser(language, editedAnswerContent, approved, activated, addRelation, questionToLink, removeRelation, questionIndex);
	}


	//	delete Answer
	public  void deleteAnswer(){
		alert = new ManageAlert(driver);
		waitForAndGetElement(ELEMENT_DELETE_ANSWER);
		click(ELEMENT_DELETE_ANSWER);
		alert.waitForConfirmation("Are you sure to delete this answer?");
	}
	/**	Approve answer
	 * @author thuntn
	 * @param answer: content of answer
	 * @param user: a user who answers
	 * @param approve = true: approve
	 * 				  = false: disapprove	
	 */
	public  void approveAnswer(String answer, String user, boolean approve){
		By eApprove = By.xpath(ELEMENT_ANSWER_APPROVE.replace("{$answer}", answer).replace("{$user}", user));
		By eDisappove = By.xpath(ELEMENT_ANSWER_DISAPPROVE.replace("{$answer}", answer).replace("{$user}", user));
		
		if (approve){
			WebElement act = waitForAndGetElement(eApprove, 30000,0);
			if (act != null){				
				click(eApprove);
				waitForAndGetElement(eDisappove);
				info("--Approve answer successfully--");
			} else info("Answer is approved");
		} else {
			WebElement de_act = waitForAndGetElement(eDisappove, 30000, 0);
			if (de_act != null){
				click(eDisappove);
				waitForAndGetElement(eApprove);
				info("Disapprove answer successfully");
			} else info("Answer is disapproved");
		}
	}
}
