package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;

import org.openqa.selenium.WebDriver;


/**
 * @author anhpp
 */

public class SendEmailNotifications extends PlatformBase{
	
	/**
	 * constructor
	 * @param dr
	 */
	public SendEmailNotifications(WebDriver dr){
		this.driver=dr;
	}
	/**
	 * function: check content of new user notification mail then delete mail
	 * @param title title of the page
	 * @param opParams if true check it's present, false check if it's not present
	 */
	public void checkNewUserNotiEmail(String title,Object... opParams){
		info("Check and delete mail");
		Boolean checkOrNo = (Boolean)(opParams.length > 0 ? opParams[0]: true);
		String parentWindow = driver.getWindowHandle();
		info("parentWindow:"+parentWindow);
		  for(String windowHandle  : driver.getWindowHandles()){
			     driver.switchTo().window(windowHandle);
			     info("driver.title:"+driver.getTitle());
		}
		if (opParams.length > 0) {
			if (checkOrNo == true)
				waitForAndGetElement(ELEMENT_GMAIL_NEWUSER.replace("${title}", title),30000, 1);
            else 
				waitForElementNotPresent(ELEMENT_GMAIL_NEWUSER.replace("${title}", title),30000, 1);
		}
		if (opParams.length > 1){
			driver.close();
		}
	} 
    
}



