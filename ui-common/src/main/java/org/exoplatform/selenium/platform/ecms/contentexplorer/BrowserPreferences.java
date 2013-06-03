package org.exoplatform.selenium.platform.ecms.contentexplorer;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author vuna2
 *
 */
public class BrowserPreferences extends EcmsBase{

	public BrowserPreferences(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	Button button = new Button(driver);
	//Preference
	public final By ELEMENT_PREFERENCE_LINK = By.xpath("//*[contains(@class, 'setupPreferencesButton')]");
	public final By ELEMENT_ADVANCED_OPTION = By.className("advancePreferences");
	public final By ELEMENT_ADVANCED_ICON_ARROW_DOWN = By.xpath("//*[@class='advancePreferences']//*[@class='uiIconArrowDown']");
	public final By ELEMENT_ADVANCED_ICON_ARROW_UP = By.xpath("//*[@class='advancePreferences']//*[@class='uiIconArrowUp']");
	
	//Enable preferences option
	public void setUpPreferenceOption(String optionId){
		info("-- Settings for preferences --");
		By option = By.id(optionId);	
		click(ELEMENT_PREFERENCE_LINK);
		//WebElement opt = waitForAndGetElement(option, 5000, 0);
		if (isTextNotPresent("Enable DMS Structure")){
			if (waitForAndGetElement(ELEMENT_ADVANCED_ICON_ARROW_DOWN, 5000, 0) != null){
				click(ELEMENT_ADVANCED_ICON_ARROW_DOWN);
			}else {
				click(ELEMENT_ADVANCED_OPTION);
			}
		}
		WebElement opt = waitForAndGetElement(option, 5000, 0, 2);
		info(optionId  + " is " + opt.getAttribute("value"));
		if (!opt.getAttribute("value").equals("checked")){
			click(option, 2);
		}
		button.save();
		waitForTextNotPresent("Preferences");
	}
}