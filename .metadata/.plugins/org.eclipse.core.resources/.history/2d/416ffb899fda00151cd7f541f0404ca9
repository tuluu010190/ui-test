package org.exoplatform.selenium.platform.answer;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class AnswerHomePage extends AnswerLocator {

	/**
	 * constructor
	 * @param dr
	 */
	public AnswerHomePage(WebDriver dr){
		this.driver=dr;
	}

	/**
	 * Go to home category
	 */
	public void goToHomeCategory(){
		if(waitForAndGetElement(ELEMENT_CATEGORY_BREADCUMB_HOME,5000,0)!=null){
			info("Go to home category");
			click(ELEMENT_CATEGORY_BREADCUMB_HOME);
		}
		waitForElementNotPresent(ELEMENT_CATEGORY_BREADCUMB_HOME);
	}
	
	/**
	 * Do quick search
	 * @param key
	 */
	public void doQuickSearch(String key){
		info("Do quick search");
		type(ELEMENT_QUICK_SEARCH_INPUT,key,true);
		click(ELEMENT_QUICK_SEARCH_BUTTON);
		waitForAndGetElement(ELEENT_QUICK_SEARCH_POPUP);
	}
	
	/**
	 * Go to advance search
	 */
	public void goToAdvanceSearch(){
		info("Go to advance search");
		type(ELEMENT_QUICK_SEARCH_INPUT,"search",true);
		click(ELEMENT_QUICK_SEARCH_BUTTON);
		waitForAndGetElement(ELEENT_QUICK_SEARCH_POPUP);
		click(ELEMENT_QUICK_SEARCH_ADVANCE_SEARCH_BUTTON);
		waitForAndGetElement(ELEMENT_ADVANCE_SEARCH_POPUP);
	}
	/**
	 * Open a detail question 
	 * @param question
	 */
	public void goToQuestion(String question){
		info("Click on Question link");
		click(ELEMENT_QUESTION_LINK.replace("$question",question));
		Utils.pause(2000);
	}
}
