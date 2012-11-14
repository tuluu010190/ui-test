package org.exoplatform.selenium.platform.social;

import org.openqa.selenium.By;
import static org.exoplatform.selenium.TestLogger.*;
/**
 * 
 * @author thaopth
 * Date: 08/11/2012
 */

public class ApplicationManagement extends SocialBase {
	
	//Go to My Spaces > Select a space > Settings
	//Applications Tab 
	public static final By ELEMENT_SPACE_NAVIGATION = By.xpath("//div[text()='Applications']");
	public static final By ELEMENT_ADD_APPLICATION_LINK = By.linkText("Add Application");
	public static final By ELEMENT_ADD_APP_POPUP = By.xpath("//span[text()='Space Application Installer']");
	public static final By ELEMENT_CLOSE_BUTTON = By.xpath("//div[@id='UIAddApplication']/div/a[@title='Close Window']");
	
	//Go to space application
	/*public static void goToSpaceApplication () {
		
		waitForElementPresent(ELEMENT_SPACE_NAVIGATION);
		
		click(ELEMENT_SPACE_NAVIGATION);
	}*/

	//Add application for space
	public static void addApplication(String categoryName, String applicationTitle) {

		By ELEMENT_CATEGORY = By.xpath("//div[contains(text(),'"+categoryName+"')]");
		By ELEMENT_ADD_APP_BUTTON = By.xpath("//div[text()='"+applicationTitle+"']/following::div[@title='Install this application to the space']");
		
		info("----Click add application link----");
		
		waitForElementPresent(ELEMENT_ADD_APPLICATION_LINK);
		
		click(ELEMENT_ADD_APPLICATION_LINK);

		info("---Select category----");
		
		waitForElementPresent(ELEMENT_ADD_APP_POPUP);
		
		click(ELEMENT_CATEGORY);

		info("-------Add application-------");
		
		waitForElementPresent(ELEMENT_ADD_APP_BUTTON);
		
		click(ELEMENT_ADD_APP_BUTTON);

		info("---Verify new application is added");
		
		info("----Close add application pop up-----");
		
		click(ELEMENT_CLOSE_BUTTON);
		
		waitForElementNotPresent(ELEMENT_CLOSE_BUTTON);
		
		waitForElementPresent(By.xpath("//div[@class='CommunityName FL' and text()='"+applicationTitle+"']"));
		
		//info("Close window");
		/*
		 * Comment out by Dung.hm
		 * Reason: duplicated ELEMENT_CLOSE_BUTTON verification
		 *  
		 waitForElementPresent(ELEMENT_CLOSE_BUTTON);
		 */
		
		//info("----Close add application pop up-----");
		
		//click(ELEMENT_CLOSE_BUTTON);
		
		//waitForElementNotPresent(ELEMENT_CLOSE_BUTTON);
	}
	
	//Delete application
	public static void removeApplication(String applicationTitle){
		
		By ELEMENT_DELETE_APP_BUTTON = By.xpath("//div[text()='"+applicationTitle+"']/following::div/a[@title='Remove']");
		
		info("----Go to Space application ---");
		
		//goToSpaceApplication();
		goToApplications();
		
		info("-----Click delete button-----");
		
		click(ELEMENT_DELETE_APP_BUTTON);
		
		info("----Verify application is deleted----");
		
		waitForElementNotPresent(By.xpath("//div[@class='CommunityName FL' and text()='"+applicationTitle+"']"));
	}
}
