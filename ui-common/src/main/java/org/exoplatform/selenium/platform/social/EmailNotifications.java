package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.Set;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;


public class EmailNotifications extends NotificationLocator{
	
	/**
	 * constructor
	 * @param dr
	 */
	public EmailNotifications(WebDriver dr){
		this.driver=dr;
	}
	
	/**
	 * Get list all Browsers
	 */
	public void getAllChildWindows() {
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			info("driver.title:" + driver.getTitle());
			driver.manage().window().maximize();
		}
	}
	/**
	 * Close all child drivers
	 * @param parentTitle
	 *                    is the tilte of parent browsers
	 */
	public void closeChildBrowsers(String parentWindow){
		info("parentWindow:"+parentWindow);
		Set<String> handlers=driver.getWindowHandles(); 
		//Handler will have all the three window handles
		for(String windowHandle  : handlers){
		     driver.switchTo().window(windowHandle);
		     info("windowHandle"+windowHandle);
		     //If it is not the parent window it will close the child window 
		     if(!windowHandle.contains(parentWindow)){
		    	  info("close driver.title:"+driver.getTitle());
		    	  Utils.pause(2000);
				  driver.close();
		     }
		   
	    }
	}
	/**
	 * Verify email notification's title is shown
	 * @param fullName
	 *                 is full name of the user
	 * @param content
	 *                  is the title of email notification
	 */
	public void verifyPresentTitlePostMyASEmail(String fullName,String content){
		info("Verify that email notificaiton is sent to user's inbox");
		waitForAndGetElement(ELEMENT_GMAIL_POST_IN_ACTIVITY_STREAM.
				replace("$fullName", fullName).replace("$content", content),30000, 1);
	}
	
	/**
	 * Verify email notification's title is not shown
	 * @param fullName
	 *                 is full name of the user
	 * @param content
	 *                 is the title of email notification
	 */
	public void verifyNOTPresentTitlePostMyASEmail(String fullName,String content){
		info("Verify that email notificaiton is sent to user's inbox");
		waitForElementNotPresent(ELEMENT_GMAIL_POST_IN_ACTIVITY_STREAM.
				replace("$fullName", fullName).replace("$content", content));
	}
	
	/**
	 * Verify email notification's title of comment an Activity is shown
	 * @param title 
	 *                  is the title of email notification
	 * @param fullName
	 *                 is full name of the user
	 * @param content
	 *                  is the title of email notification
	 */
	public void verifyPresentTitleCommentASEmailNoti(String title,String fullName){
		info("Verify that email notificaiton is sent to user's inbox");
		waitForAndGetElement(ELEMENT_GMAIL_TITLE.replace("$title",title)
				.replace("$fullName", fullName),30000, 1);
	}
	
	/**
	 * Verify email notification's title of Comment an Activity  is not shown
	 * @param title 
	 *                  is the title of email notification
	 * @param fullName
	 *                 is full name of the user
	 * @param content
	 *                  is the title of email notification
	 */
	public void verifyNOTPresentTitleCommentASEmailNoti(String title,String fullName){
		info("Verify that email notificaiton isnot sent to user's inbox");
		waitForElementNotPresent(ELEMENT_GMAIL_TITLE.replace("$title",title)
				.replace("$fullName", fullName),30000, 1);
	}

	/**
	 * Click on Reply button
	 */
	public void clickOnReplyBtn(){
		info("Click on Reply button");
		click(ELEMENT_GMAIL_REPLY_BTN);
		Utils.pause(2000);
	}
	/**
	 * Click on View Discussion Button
	 */
	public void clickOnViewDiscussBtn(){
		info("Click on View Full Discusion button");
		click(ELEMENT_GMAIL_VIEW_FULL_BTN);
		Utils.pause(2000);
	}
	
	/**
	 * Verify email notification's title of comment an Activity is shown
	 * @param title 
	 *                  is the title of email notification
	 * @param fullName
	 *                 is full name of the user
	 * @param content
	 *                  is the title of email notification
	 */
	public void verifyPresentEmailActivityNotifications(String title,String fullName,String content,String... isParams){
		if(!content.isEmpty()){
			info("Verify that email notificaiton is sent to user's inbox");
			waitForAndGetElement(ELEMENT_GMAIL_TITLE.replace("$title",title)
					.replace("$fullName", fullName).replace("$content",content),30000, 1);
		}else{
			if(isParams.length>0){
				info("Verify that email notificaiton is sent to user's inbox");
				waitForAndGetElement(ELEMENT_GMAIL_TITLE_WITH_INDEX.replace("$title",title)
						.replace("$fullName", fullName).replace("$num",isParams[0]),30000, 1);
			}else{
				info("Verify that email notificaiton is sent to user's inbox");
				waitForAndGetElement(ELEMENT_GMAIL_TITLE.replace("$title",title)
						.replace("$fullName", fullName),30000, 1);
			}
		}
	}
	
	/**
	 * Verify email notification's title of an Activity  is not shown
	 * @param title 
	 *                  is the title of email notification
	 * @param fullName
	 *                 is full name of the user
	 * @param content
	 *                  is the title of email notification
	 */
	public void verifyNOTPresentTitleASEmailNoti(String title,String fullName,String content,String... isParams){
		if(!content.isEmpty()){
			info("Verify that email notificaiton is sent to user's inbox");
			waitForElementNotPresent(ELEMENT_GMAIL_TITLE.replace("$title",title)
					.replace("$fullName", fullName).replace("$content",content));
		}else{
			if(isParams.length>0){
				info("Verify that email notificaiton is sent to user's inbox");
				waitForElementNotPresent(ELEMENT_GMAIL_TITLE_WITH_INDEX.replace("$title",title)
						.replace("$fullName", fullName).replace("$num",isParams[0]));
			}else{
				info("Verify that email notificaiton is sent to user's inbox");
				waitForElementNotPresent(ELEMENT_GMAIL_TITLE.replace("$title",title)
						.replace("$fullName", fullName));
			}
		}
	}
	/**
	 * Open detail an email Notification
	 * @param title
	 *                   is the title of email notification
	 * @param fullName
	 *                   is full name of the user
	 */
	public void goToDetailEmailNoti(String title,String fullName,String content){
		if(!content.isEmpty()){
			info("Go to detail detail Activity via email notification");
			click(ELEMENT_GMAIL_TITLE.replace("$title",title)
					.replace("$fullName", fullName).replace("$content",content));
		}else{
			info("Go to detail detail Activity via email notification");
			click(ELEMENT_GMAIL_TITLE.replace("$title",title)
					.replace("$fullName", fullName));
		}
		Utils.pause(2000);
	}
	
	/**
	 * Go to previous page
	 */
	public void goToPreviousPage(){
		info("Back to the previous page");
		driver.navigate().back();
		Utils.pause(2000);
	}
		
	/**
	 * Verify email notificaiton's format for Activity
	 * @param emailTitle
	 * @param firstName
	 * @param fullName
	 * @param emailContent
	 * @param actTitle
	 */
	public void verifyFormatEmailNotifcation(String emailTitle,String firstName,
			String fullName,String emailContent,String actTitle){
		if(!emailTitle.isEmpty()){
			info("Verify Email notificaiton's title");
			waitForAndGetElement(ELEMENT_GMAIL_FORMAT_TITLE.
					replace("$title",emailTitle));
		}
		
		if(!firstName.isEmpty()){
			info("Verify Openning email");
			waitForAndGetElement(ELEMENT_GMAIL_FORMAT_OPENNING_SUB
					.replace("$firstName",firstName));
		}
		
		if(!emailContent.isEmpty() && !fullName.isEmpty()){
			info("Verify the email's content as: activity's content");
			waitForAndGetElement(ELEMENT_GMAIL_FORMAT_CONTENT
					.replace("$fullName",fullName).replace("$content",emailContent),3000,1);
		}
		
		if(!actTitle.isEmpty()){
			info("Verify the activity's title");
			waitForAndGetElement(ELEMENT_GMAIL_FORMAT_ACTIVITY_TITLE
					.replace("$title",actTitle));
		}
		info("Verify Reply button");
		waitForAndGetElement(ELEMENT_GMAIL_REPLY_BTN);
		info("Verify View last Disscussion button");
		waitForAndGetElement(ELEMENT_GMAIL_VIEW_FULL_BTN);
	}
	
	/**
	 * Verify format of email notification for connection request
	 * @param emailTitle
	 * @param firstName
	 *                 
	 * @param emailContent
	 * 
	 * @param userName
	 */
	public void verifyFormatEmailNotifcation(String emailTitle,String firstName,
			String userName,String emailContent){
		if(!emailTitle.isEmpty()){
			info("Verify Email notificaiton's title");
			waitForAndGetElement(ELEMENT_GMAIL_FORMAT_TITLE.
					replace("$title",emailTitle),3000,1);
		}
		
		if(!firstName.isEmpty()){
			info("Verify Openning email");
			waitForAndGetElement(ELEMENT_GMAIL_FORMAT_OPENNING_SUB
					.replace("$firstName",firstName));
		}
		
		if(!emailContent.isEmpty() && !firstName.isEmpty()){
			info("Verify the email's content as: connection request's content");
			waitForAndGetElement(ELEMENT_GMAIL_FORMAT_CONTENT_CONNECTION_REQUEST
					.replace("$username",userName).replace("$content",emailContent),3000,1);
		}
		info("Verify user's avatar");
		waitForAndGetElement(ELEMENT_GMAIL_USER_AVARTAR);
		info("Verify Accept button");
		waitForAndGetElement(ELEMENT_GMAIL_ACCEPT_BTN);
		info("Verify Refuse button");
		waitForAndGetElement(ELEMENT_GMAIL_REFUSE_BTN);
	}
	/**
	 * Click on Accept button
	 */
	public void clickAcceptBtn(){
		info("Click on Accept button");
		click(ELEMENT_GMAIL_ACCEPT_BTN);
		Utils.pause(2000);
	}
	/**
	 * Click on Refuse button
	 */
	public void clickRefuseBtn(){
		info("Click on Refuse button");
		click(ELEMENT_GMAIL_REFUSE_BTN);
		Utils.pause(2000);
	}
	/**
	 * Verify the feedback message refuse connection request
	 * @param message
	 * @param fullName
	 */
	public void verifyFeedBackMessageRefuseConnection(String message,String fullName){
		info("Verify the feedback message refuse connection request");
		waitForAndGetElement(ELEMENT_NOTIFICATION_EMAIL_REFUSE_CONNECTION_MESSAGE
				.replace("$mess",message).replace("$fullName",fullName));
	}
}



