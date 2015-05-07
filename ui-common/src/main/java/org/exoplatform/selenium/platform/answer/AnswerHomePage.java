package org.exoplatform.selenium.platform.answer;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnswerHomePage extends PlatformBase {
	PlatformPermission per;
	ManageAlert alert;
	Button button;

	//Answer portlets
	public By ELEMENT_ANSWER_PORTLET = By.id("UIAnswersContainer");
	public By ELEMENT_SUBMIT_QUESTION=By.xpath("//*[@class='uiIconAnsSubmitQuestion uiIconLightGray']");
	public By ELEMENT_CATEGORY_BUTTON=By.xpath("//*[@class='uiIconAnsManageCategory']");
	public String ELEMENT_QUESTION_LIST_ITEM="//*[@class='rightContent']//*[text()='$question']";
	public String ELEMENT_QUESTION_SELECTED_ITEM="//*[contains(@class,'questionSelect')]//*[@class='theContent questionName' and contains(text(),'$question')]";
	public By ELEMENT_MANAGE_QUESTION_BUTTON=By.xpath("//*[@class='uiIconAnsManageQuestion']");

	//Breadcumb
	public By ELEMENT_CATEGORY_BREADCUMB_HOME=By.xpath("//*[@id='UIBreadcumbs']//*[text()='Home']");
	
	//Quick Search
	public By ELEMENT_QUICK_SEARCH_INPUT=By.id("inputValue");
	public By ELEMENT_QUICK_SEARCH_BUTTON=By.xpath("//*[@class='uiIconSearch uiIconLightGray']");
	public By ELEENT_QUICK_SEARCH_POPUP=By.id("UIResultQuickSearchs");
	public String ELEMENT_QUICK_SEARCH_RESULT_ITEM="//*[@id='UIResultQuickSearchs']//*[contains(text(),'$name')]";
	public String ELEMENT_QUICK_SEARCH_CLOSE="//*[@id='UIResultQuickSearchs']//*[text()='Close']";
	public String ELEMENT_QUICK_SEARCH_ADVANCE_SEARCH_BUTTON="//*[@id='UIResultQuickSearchs']//*[text()='Advanced Search']";
	
	//Advance search
	public By ELEMENT_ADVANCE_SEARCH_POPUP=By.id("AdvanceSearchForm");
	public By ELEMENT_ADVANCE_SEARCH_KEY_INPUT=By.id("Text");
	public By ELEMENT_ADVANCE_SEARCH_ALL_RADIO_BUTTON=By.xpath("//*[@value='categoryAndQuestion']");
	public By ELEMENT_ADVANCE_SEARCH_CATEGORY_RADIO_BUTTON=By.xpath("//*[@value='faqCategory']");
	public By ELEMENT_ADVANCE_SEARCH_ENTRY_RADIO_BUTTON=By.xpath("//*[@value='faqQuestion']");
	public String ELEMENT_ADVANCE_SEARCH_ADVANCE_SEARCH_BUTTON="//*[@id='AdvanceSearchForm']//*[text()='Search']";
	public String ELEMENT_ADVANCE_SEARCH_ADVANCE_CLOSE_BUTTON="//*[@id='AdvanceSearchForm']//*[text()='Close']";
	public String ELEMENT_ADVANCE_SEARCH_RESULT_ITEM="//*[@id='AdvanceSearchForm']//*[contains(text(),'$name')]";
	public By ELEENT_ADVANCE_SEARCH_CLOSE_RESULT_QUICK_SEARCH=By.id("//*[@class='resultQuickSearch']//*[text()='Close']");
	
	/**
	 * constructor
	 * @param dr
	 */
	public AnswerHomePage(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
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
}
