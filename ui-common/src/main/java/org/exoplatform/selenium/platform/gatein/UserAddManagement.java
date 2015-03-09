package org.exoplatform.selenium.platform.gatein;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAddManagement extends PlatformBase {
	
	public By ELEMENT_USERNAME = By.id("username");
	public By ELEMENT_PASSWORD = By.id("password");
	public By ELEMENT_CONFIRM_PASSWORD = By.id("Confirmpassword");
	public By ELEMENT_EMAIL = By.id("email");
	public By ELEMENT_FIRSTNAME = By.id("firstName");
	public By ELEMENT_LASTNAME = By.id("lastName");

	public By ELEMENT_SAVE = By.xpath("//*[@id='UIAccountForm']//*[contains(text(),'Save')]");
	
	
	public UserAddManagement(WebDriver dr){
		driver = dr;
	} 
	
	/**
	 * Add en user on the plf
	 * @param userName
	 * @param Password
	 * @param email
	 * @param Firstname
	 * @param lastName
	 */
	public void addUser(String userName, String Password, String email, String Firstname, String lastName){
		info("Add an user");
		type(ELEMENT_USERNAME,userName,true);
		type(ELEMENT_PASSWORD,Password,true);
		type(ELEMENT_CONFIRM_PASSWORD,Password,true);
		type(ELEMENT_EMAIL,email,true);
		type(ELEMENT_FIRSTNAME,Firstname,true);
		type(ELEMENT_LASTNAME,lastName,true);
		click(ELEMENT_SAVE);
		Utils.pause(2500);
		info("Finish adding an user");
	}
	
	/**
	 * function: check content of mail then delete mail
	 * @param title title of the page
	 * @object if true check it's present, false check if it's not present
	 */
	public void checkEmailNotification(String title,Object... opParams){
		info("Check and delete mail");
		Boolean checkOrNo = (Boolean)(opParams.length > 0 ? opParams[0]: true);
		String parentWindow = driver.getWindowHandle();
		info("parentWindow:"+parentWindow);
		  for(String windowHandle  : driver.getWindowHandles()){
			     driver.switchTo().window(windowHandle);
			     info("driver.title:"+driver.getTitle());
		}
		if(checkOrNo==true){
			waitForAndGetElement(ELEMENT_GMAIL_CONTENT.replace("${title}",title),30000,0);
		}else{
			waitForElementNotPresent(ELEMENT_GMAIL_CONTENT.replace("${title}",title),30000,0);
		}
		
	}
	
	
}
