package org.exoplatform.selenium.platform.administration;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author quynhpt
 * date 25/01/2015
 * Path: Username-->Change Language
 */
public class ChangeLanguages extends PlatformBase {
	
	public final By ELEMENT_CHANGE_LANGUAGE_POPUP_TITLE = By.xpath(".//*[@id='UIMaskWorkspace']//h5");
	public final String ELEMENT_CHANGELANGUAGE_LANGUAGE = "//*[text()='${language}']";
	public final String ELEMENT_AVATAR_CHANGELANGUAGE_APPLY = "//*[text()='${text}']";
	
	public ChangeLanguages(WebDriver dr){
		driver = dr;
	} 
	/**
	 * Select a language and changed it
	 * @param language
	 */
	public void changeLanguage(String language, String applyText){
		info("Select language and change it");
		waitForAndGetElement(ELEMENT_CHANGE_LANGUAGE_POPUP_TITLE);
		click(ELEMENT_CHANGELANGUAGE_LANGUAGE.replace("${language}",language));
		click(ELEMENT_AVATAR_CHANGELANGUAGE_APPLY.replace("${text}",applyText));
	}
}
