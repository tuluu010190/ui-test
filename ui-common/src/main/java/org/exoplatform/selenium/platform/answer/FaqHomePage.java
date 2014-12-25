package org.exoplatform.selenium.platform.answer;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaqHomePage  extends PlatformBase {
	
	public final By ELEMENT_FAQ_QUESTION_LIST=By.xpath("//*[@class='questionList']");
	public final String ELEMENT_FAQ_CATEGORY = "//*[@class='questionList']//*[@data-original-title='$category']";
	public final String ELEMENT_FAQ_QUESTION = "//*[@id='viewerQuestion']//a[text()='$question']";
	public final String ELEMENT_FAQ_ANSWER = "//*[@id='viewerAnswer']//*[text()='$answer']";
	
	/**
	 * constructor
	 * @param dr
	 */
	public FaqHomePage(WebDriver dr){
		this.driver=dr;
	}

}
