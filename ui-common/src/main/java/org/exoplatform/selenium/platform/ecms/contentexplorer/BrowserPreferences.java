package org.exoplatform.selenium.platform.ecms.contentexplorer;

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
	
	//Enable preferences option
	public void setUpPreferenceOption(String optionId){
		By option = By.id(optionId);
		By advanced = By.className("advancePreferences");
		
		click(ELEMENT_PREFERENCE_LINK);
		WebElement opt = waitForAndGetElement(option, 5000, 0, 2);
		if (opt == null){
			click(advanced);
		}
		if (opt.isSelected()!= true){
			click(option, 2);
		}
		button.save();
		waitForTextNotPresent("Preferences");
	}
}
