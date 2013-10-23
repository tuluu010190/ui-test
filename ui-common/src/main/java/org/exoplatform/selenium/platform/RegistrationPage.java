package org.exoplatform.selenium.platform;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author phuongdt
 * @date 23/10/2013
 *
 */
public class RegistrationPage extends PlatformBase {
	public final By ELEMENT_BUY_A_SUBCRIPTION = By.xpath("//button[text()='Buy a Subscription']");
	public final By ELEMENT_ERROR_UNLOCK_INVALID_KEY = By.xpath("//*[@id='KEYERROR' and contains(text(),'Sorry this evaluation key is not valid')]");
	public final By ELEMENT_UNLOCK_TEXTBOX = By.id("hashMD5");
	public final By ELEMENT_UNLOCK_BUTTON = By.xpath("//button[text()='Unlock']");
	public final By ELEMENT_REQUEST_KEY_BUTTON = By.xpath("//button[text()='Request a Key']");
	public final By ELEMENT_SUBCRIPTION_PLAN = By.linkText("subscription plan");
	public final By ELEMENT_CONTACT_US = By.linkText("info@exoplatform.com");
	public final By ELEMENT_WEBSITE = By.linkText("www.exoplatform.com");
	public final String ELEMENT_REMAIN_TRIAL_DAY = "//*[contains(text(),'You have ${remainDay} day(s) left in your evaluation')]";
	public final By ELEMENT_EDITIONS_PAGE = By.xpath("//div[@class='RightBody UIPageEditions']");
	public final By ELEMENT_REQUEST_A_KEY_PAGE = By.xpath("//*[contains(text(),'Unlock your Trial Version of eXo Platform')]");
	
	public RegistrationPage (WebDriver dr){
		driver = dr;
	}
	
	/** Unlock trial version
	 * @author phuongdt
	 * @param key
	 */
	public void unlockTrialVersion(String key){
		info("-- Unlock Trial Version --");
		click(ELEMENT_BUY_A_SUBCRIPTION);
		type(ELEMENT_UNLOCK_TEXTBOX,key,true);
		click(ELEMENT_UNLOCK_BUTTON);
		Utils.pause(1000);
	}
}
