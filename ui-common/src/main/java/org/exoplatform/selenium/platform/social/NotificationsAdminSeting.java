package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.platform.PlatformBase;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationsAdminSeting extends PlatformBase {
	
	
	public final By ELEMENT_TITLE_EMAIL_NOTIFICATIONS = By.xpath("//*[@id='notificationAdmin']/h3");
	public final By ELEMENT_NOTIFICATION_GRID_TITLE = By.xpath("//*[@id='notificationAdmin']//th[contains(text(),'Notification')]");
	public final By ELEMENT_TITLE_NOTIFICATION_GRID = By.xpath("//*[@id='notificationAdmin']//th[contains(text(),'Title')]");
	public final By ELEMENT_ENABLE_NOTIFICATION_GRID = By.xpath("//*[@id='notificationAdmin']//th[contains(text(),'Enable')]");
	
	// Notifications
	//New User
	public final By ELEMENT_CHECK_BUTTON_CONNECT_NOTIFICATION = By.xpath("//*[@name='RelationshipReceivedRequestPlugin']");
	public final By ELEMENT_NEW_USER_NOTIFICATION_EDIT_BTN =By.xpath(".//*[@id='NewUserPlugin']//*[contains(@class,'uiIconEdit')]");
	public final By ELEMENT_NEW_USER_EMAIL_NOTIFICATION_CHECKBOX=By.xpath(".//*[@id='MAIL_CHANNELNewUserPlugin']");
	public final By ELEMENT_NEW_USER_INTRANET_NOTIFICATION_CHECKBOX=By.xpath(".//*[@id='WEB_CHANNELNewUserPlugin']");
	public final By ELEMENT_NEW_USER_EMAIL_NOTIFICATION_CHECKBOX_CHECKED=By.xpath(".//*[@id='MAIL_CHANNELNewUserPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_NEW_USER_INTRANET_NOTIFICATION_CHECKBOX_CHECKED=By.xpath(".//*[@id='WEB_CHANNELNewUserPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_NEW_USER_EMAIL_NOTIFICATION_TITLE=By.xpath(".//*[@id='NewUserPlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public final By ELEMENT_NEW_USER_INTRANET_NOTIFICATION_TITLE=By.xpath(".//*[@id='NewUserPlugin']//*[contains(@class,'WEB_CHANNEL')]");
	//Connection request
	public final By ELEMENT_NEW_USER_NOTIFICATION_SAVE_BTN=By.xpath(".//*[@id='btActionNewUserPlugin']");
	public final By ELEMENT_CONNECTION_REQUEST_EDIT_BTN =By.xpath(".//*[@id='RelationshipReceivedRequestPlugin']//*[contains(@class,'uiIconEdit')]");
	public final By ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_CHECKBOX=By.xpath(".//*[@id='MAIL_CHANNELRelationshipReceivedRequestPlugin']");
	public final By ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_CHECKBOX_CHECKED=By.xpath(".//*[@id='MAIL_CHANNELRelationshipReceivedRequestPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_CHECKBOX=By.xpath(".//*[@id='WEB_CHANNELRelationshipReceivedRequestPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_CHECKBOX_CHECKED=By.xpath(".//*[@id='WEB_CHANNELRelationshipReceivedRequestPlugin']");
	public final By ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_TITLE=By.xpath(".//*[@id='RelationshipReceivedRequestPlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public final By ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_TITLE=By.xpath(".//*[@id='RelationshipReceivedRequestPlugin']//*[contains(@class,'WEB_CHANNEL')]");
	public final By ELEMENT_CONNECTION_REQUEST_SAVE_BTN=By.xpath(".//*[@id='btActionRelationshipReceivedRequestPlugin']");
	//Activity comment
	public final By ELEMENT_ACTIVITY_COMMENT_EDIT_BTN = By.xpath(".//*[@id='ActivityCommentPlugin']//*[contains(@class,'uiIconEdit')]");
	public final By ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='MAIL_CHANNELActivityCommentPlugin']");
	public final By ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='MAIL_CHANNELActivityCommentPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_ACTIVITY_COMMENT_SAVE_BTN = By.xpath(".//*[@id='btActionActivityCommentPlugin']");
	public final By ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_TITLE = By.xpath(".//*[@id='ActivityCommentPlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public final By ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='WEB_CHANNELActivityCommentPlugin']");
	public final By ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='WEB_CHANNELActivityCommentPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_TITLE =  By.xpath(".//*[@id='ActivityCommentPlugin']//*[contains(@class,'WEB_CHANNEL')]");
	//Space invitation
	public final By ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN = By.xpath(".//*[@id='SpaceInvitationPlugin']//*[contains(@class,'uiIconEdit')]");
	public final By ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='MAIL_CHANNELSpaceInvitationPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='MAIL_CHANNELSpaceInvitationPlugin']");
	public final By ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN = By.xpath(".//*[@id='btActionSpaceInvitationPlugin']");
	public final By ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_TITLE = By.xpath(".//*[@id='SpaceInvitationPlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public final By ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='WEB_CHANNELSpaceInvitationPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='WEB_CHANNELSpaceInvitationPlugin']");
	public final By ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_TITLE = By.xpath(".//*[@id='SpaceInvitationPlugin']//*[contains(@class,'WEB_CHANNEL')]");
	
	/**
	 * constructor
	 * @param dr
	 */
	public NotificationsAdminSeting(WebDriver dr){
		this.driver=dr;
	}
	
	public enum notificationType{
		NewUser_email,NewUser_intranet,ConnectionRequest_email,ConnectionRequest_intranet,Comment_email,Comment_intranet,
		Space_email,Space_intranet;
	}
	/**
	 * Disable notification
	 * @param notifToDisable
	 */
	public void disableNotification(notificationType notifToDisable){
		switch(notifToDisable){
		case NewUser_email:
			info("Click on Edit button");
			click(ELEMENT_NEW_USER_NOTIFICATION_EDIT_BTN);
			uncheck(ELEMENT_NEW_USER_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_NEW_USER_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent( ELEMENT_NEW_USER_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case NewUser_intranet:
			info("Click on Edit button");
			click(ELEMENT_NEW_USER_NOTIFICATION_EDIT_BTN);
			uncheck(ELEMENT_NEW_USER_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_NEW_USER_NOTIFICATION_SAVE_BTN);
			info("Verify that intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_NEW_USER_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case ConnectionRequest_email:
			click(ELEMENT_CONNECTION_REQUEST_EDIT_BTN);
			uncheck(ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_CONNECTION_REQUEST_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case ConnectionRequest_intranet:
			click(ELEMENT_CONNECTION_REQUEST_EDIT_BTN);
			uncheck(ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_CONNECTION_REQUEST_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Comment_email:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Comment_intranet:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_email:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			uncheck(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			uncheck(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;

		}
	}
	/**
	 * Enable notification
	 * @param notifToDisable
	 */
	public void enableNotification(notificationType notifToDisable){
		switch(notifToDisable){
		case NewUser_email:
			info("Click on Edit button");
			click(ELEMENT_NEW_USER_NOTIFICATION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_NEW_USER_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_NEW_USER_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_NEW_USER_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is shown");
			waitForAndGetElement( ELEMENT_NEW_USER_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case NewUser_intranet:
			info("Click on Edit button");
			click(ELEMENT_NEW_USER_NOTIFICATION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_NEW_USER_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_NEW_USER_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_NEW_USER_NOTIFICATION_SAVE_BTN);
			info("Verify that intranet notification is shown");
			waitForAndGetElement(ELEMENT_NEW_USER_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case ConnectionRequest_email:
			click(ELEMENT_CONNECTION_REQUEST_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_CONNECTION_REQUEST_SAVE_BTN);
			info("Verify that email notification is shown");
			waitForAndGetElement(ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case ConnectionRequest_intranet:
			click(ELEMENT_CONNECTION_REQUEST_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_CONNECTION_REQUEST_SAVE_BTN);
			info("Verify that Intranet notification is shown");
			waitForAndGetElement(ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Comment_email:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Comment_intranet:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_email:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
			check(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		}
	}
}
