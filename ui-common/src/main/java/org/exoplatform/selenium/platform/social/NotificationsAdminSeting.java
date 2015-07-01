package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.platform.PlatformBase;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationsAdminSeting extends PlatformBase {
	
	//Disable notification's type
	public final By ELEMENT_ADMIN_NOTIFICATION_NEW_USER_DISBALE = By.xpath(".//*[@id='NewUserPlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_CONNECTION_REQUEST_DISBALE = By.xpath(".//*[@id='RelationshipReceivedRequestPlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_COMMENT_DISBALE = By.xpath(".//*[@id='ActivityCommentPlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_LIKE_DISBALE = By.xpath(".//*[@id='LikePlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_MENTION_DISBALE = By.xpath(".//*[@id='ActivityMentionPlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_POST_DISBALE = By.xpath(".//*[@id='PostActivityPlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_INVITATION_DISBALE = By.xpath(".//*[@id='SpaceInvitationPlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_JOIN_DISBALE = By.xpath(".//*[@id='RequestJoinSpacePlugin']//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_POST_DISBALE = By.xpath(".//*[@id='PostActivitySpaceStreamPlugin']//*[contains(text(),'No notifications')]");
	
	public final By ELEMENT_TITLE_EMAIL_NOTIFICATIONS = By.xpath("//*[@id='notificationAdmin']/h3");
	public final By ELEMENT_NOTIFICATION_GRID_TITLE = By.xpath("//*[@id='notificationAdmin']//th[contains(text(),'Notification')]");
	public final By ELEMENT_TITLE_NOTIFICATION_GRID = By.xpath("//*[@id='notificationAdmin']//th[contains(text(),'Title')]");
	public final By ELEMENT_ENABLE_NOTIFICATION_GRID = By.xpath("//*[@id='notificationAdmin']//th[contains(text(),'Enable')]");
	
	//Notification sender area
	public final By ELEMENT_ADMIN_NOTIFICATION_SENDER_NAME = By.xpath(".//*[@id='senderName']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SENDER_ADDRESS = By.xpath(".//*[@id='senderEmail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SENDER_SAVE_BTN = By.xpath(".//*[@id='btSetSender']");
	public final By ELEMENT_NOTIFICATION_SENDER_ERROR_MESSAGE_INVALID_EMAIL =By.xpath(".//*[@id='confirmMessage']//*[contains(text(),'Cannot update the sender information: empty value or the format is not correct.')]");
	public final String ELEMENT_NOTIFICATION_SENDER_SUCCESS_MESSAGE=".//*[@id='confirmMessage']//*[contains(text(),'Notifications will now be sent to your users from \"$name\"<$email>')]";
	
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
	
	//Activity like
	public  final By ELEMENT_ACTIVITY_LIKE_EDIT_BTN = By.xpath(".//*[@id='LikePlugin']//*[contains(@class,'uiIconEdit')]");
	public  final By ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='MAIL_CHANNELLikePlugin']");
	public  final By ELEMENT_ACTIVITY_LIKE_SAVE_BTN = By.xpath(".//*[@id='btActionLikePlugin']");
	public  final By ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_TITLE = By.xpath(".//*[@id='LikePlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public  final By ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='WEB_CHANNELLikePlugin']");
	public  final By ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_TITLE = By.xpath(".//*[@id='LikePlugin']//*[contains(@class,'WEB_CHANNEL')]");
	public  final By ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='WEB_CHANNELLikePlugin'][contains(@checked,'checked')]");
	public  final By ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='MAIL_CHANNELLikePlugin'][contains(@checked,'checked')]");
	
	//Activity mention
	public  final By ELEMENT_ACTIVITY_MENTION_EDIT_BTN = By.xpath(".//*[@id='ActivityMentionPlugin']//*[contains(@class,'uiIconEdit')]");
	public  final By ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='MAIL_CHANNELActivityMentionPlugin']");
	public  final By ELEMENT_ACTIVITY_MENTION_SAVE_BTN = By.xpath(".//*[@id='btActionActivityMentionPlugin']");
	public  final By ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_TITLE = By.xpath(".//*[@id='ActivityMentionPlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public  final By ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='WEB_CHANNELActivityMentionPlugin']");
	public  final By ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_TITLE = By.xpath(".//*[@id='ActivityMentionPlugin']//*[contains(@class,'WEB_CHANNEL')]");
	public  final By ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='MAIL_CHANNELActivityMentionPlugin'][contains(@checked,'checked')]");
	public  final By ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='WEB_CHANNELActivityMentionPlugin'][contains(@checked,'checked')]");
	
	//Activity Post on My Stream
	public  final By ELEMENT_ACTIVITY_POST_EDIT_BTN = By.xpath(".//*[@id='PostActivityPlugin']//*[contains(@class,'uiIconEdit')]");
	public  final By ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='MAIL_CHANNELPostActivityPlugin']");
	public  final By ELEMENT_ACTIVITY_POST_SAVE_BTN = By.xpath(".//*[@id='btActionPostActivityPlugin']");
	public  final By ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_TITLE = By.xpath(".//*[@id='PostActivityPlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public  final By ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='WEB_CHANNELPostActivityPlugin']");
	public  final By ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_TITLE = By.xpath(".//*[@id='PostActivityPlugin']//*[contains(@class,'WEB_CHANNEL')]");
	public  final By ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='MAIL_CHANNELPostActivityPlugin'][contains(@checked,'checked')]");
	public  final By ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='WEB_CHANNELPostActivityPlugin'][contains(@checked,'checked')]");
	
	//Space post on My space
	public  final By ELEMENT_SPACE_NOTIFICATION_POST_EDIT_BTN = By.xpath(".//*[@id='PostActivitySpaceStreamPlugin']//*[contains(@class,'uiIconEdit')]");
	public  final By ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='MAIL_CHANNELPostActivitySpaceStreamPlugin']");
	public  final By ELEMENT_SPACE_POST_NOTIFICATION_SAVE_BTN = By.xpath(".//*[@id='btActionPostActivitySpaceStreamPlugin']");
	public  final By ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_TITLE = By.xpath(".//*[@id='PostActivitySpaceStreamPlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public  final By ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='WEB_CHANNELPostActivitySpaceStreamPlugin']");
	public  final By ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_TITLE = By.xpath(".//*[@id='PostActivitySpaceStreamPlugin']//*[contains(@class,'WEB_CHANNEL')]");
	public  final By ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='MAIL_CHANNELPostActivitySpaceStreamPlugin'][contains(@checked,'checked')]");
	public  final By ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='WEB_CHANNELPostActivitySpaceStreamPlugin'][contains(@checked,'checked')]");
	
	//Space join request
	public  final By ELEMENT_SPACE_NOTIFICATION_JOIN_EDIT_BTN = By.xpath(".//*[@id='RequestJoinSpacePlugin']//*[contains(@class,'uiIconEdit')]");
	public  final By ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='MAIL_CHANNELRequestJoinSpacePlugin'][contains(@checked,'checked')]");
	public  final By ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_CHECKBOX_CHECKED = By.xpath(".//*[@id='WEB_CHANNELRequestJoinSpacePlugin'][contains(@checked,'checked')]");
	public  final By ELEMENT_SPACE_JOIN_NOTIFICATION_SAVE_BTN = By.xpath(".//*[@id='btActionRequestJoinSpacePlugin']");
	public  final By ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='MAIL_CHANNELRequestJoinSpacePlugin']");
	public  final By ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_CHECKBOX = By.xpath(".//*[@id='WEB_CHANNELRequestJoinSpacePlugin']");
	public  final By ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_TITLE = By.xpath(".//*[@id='RequestJoinSpacePlugin']//*[contains(@class,'MAIL_CHANNEL')]");
	public  final By ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_TITLE=By.xpath(".//*[@id='RequestJoinSpacePlugin']//*[contains(@class,'WEB_CHANNEL')]"); 
	/**
	 * constructor
	 * @param dr
	 */
	public NotificationsAdminSeting(WebDriver dr){
		this.driver=dr;
	}
	/**
	 * Define notification's type
	 */
	public enum notificationType{
		NewUser_email,NewUser_intranet,ConnectionRequest_email,ConnectionRequest_intranet,
		AS_Comment_email,AS_Comment_intranet,AS_Like_email,AS_Like_intranet,
		AS_Mention_email,AS_Mention_intranet,
		AS_Post_email,AS_Post_intranet,Space_Invitation_email,
		Space_Invitation_intranet,Space_Join_email,Space_Join_intranet,
		Space_Post_email,Space_Post_intranet;
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
			waitForElementNotPresent(ELEMENT_NEW_USER_EMAIL_NOTIFICATION_TITLE,3000,1);
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
		case AS_Comment_email:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Comment_intranet:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Like_email:
			click(ELEMENT_ACTIVITY_LIKE_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_LIKE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Like_intranet:
			click(ELEMENT_ACTIVITY_LIKE_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_LIKE_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Mention_email:
			click(ELEMENT_ACTIVITY_MENTION_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_MENTION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Mention_intranet:
			click(ELEMENT_ACTIVITY_MENTION_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_MENTION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Post_email:
			click(ELEMENT_ACTIVITY_POST_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_POST_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Post_intranet:
			click(ELEMENT_ACTIVITY_POST_EDIT_BTN);
			uncheck(ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_POST_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Join_email:
			click(ELEMENT_SPACE_NOTIFICATION_JOIN_EDIT_BTN);
			uncheck(ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_JOIN_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Join_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_JOIN_EDIT_BTN);
			uncheck(ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_JOIN_NOTIFICATION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Invitation_email:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			uncheck(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Invitation_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			uncheck(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Post_email:
			click(ELEMENT_SPACE_NOTIFICATION_POST_EDIT_BTN);
			uncheck(ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_POST_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Post_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_POST_EDIT_BTN);
			uncheck(ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_POST_NOTIFICATION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_TITLE,3000,1);
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
			waitForAndGetElement(ELEMENT_NEW_USER_EMAIL_NOTIFICATION_TITLE,3000,1);
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
		case AS_Comment_email:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Comment_intranet:
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Like_email:
			click(ELEMENT_ACTIVITY_LIKE_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_LIKE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Like_intranet:
			click(ELEMENT_ACTIVITY_LIKE_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_LIKE_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Mention_email:
			click(ELEMENT_ACTIVITY_MENTION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_MENTION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Mention_intranet:
			click(ELEMENT_ACTIVITY_MENTION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_MENTION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Post_email:
			click(ELEMENT_ACTIVITY_POST_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_POST_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case AS_Post_intranet:
			click(ELEMENT_ACTIVITY_POST_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_ACTIVITY_POST_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Join_email:
			click(ELEMENT_SPACE_NOTIFICATION_JOIN_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_JOIN_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Join_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_JOIN_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_JOIN_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Invitation_email:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Invitation_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Post_email:
			click(ELEMENT_SPACE_NOTIFICATION_POST_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_POST_NOTIFICATION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_TITLE,3000,1);
			break;
		case Space_Post_intranet:
			click(ELEMENT_SPACE_NOTIFICATION_POST_EDIT_BTN);
			if(waitForAndGetElement(ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_CHECKBOX_CHECKED,2000,0)==null)
				check(ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_SPACE_POST_NOTIFICATION_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_TITLE,3000,1);
			break;
		}
	}
	/**
	 * Define notification plugin is disable all
	 */
	public enum notificationDisbale{
		NewUser,ConnectionRequest,AS_Comment,AS_Like,
		AS_Mention,AS_Post,Space_Invitation,Space_Join,Space_Post;
	}
	
	/**
	 * Verify that notification's type is disabled all
	 * @param op
	 */
	public void veriftyNotificationTypeDisable(notificationDisbale op){
		switch(op){
		case NewUser:
			info("Verify that New user is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_NEW_USER_DISBALE);
			break;
		case ConnectionRequest:
			info("Verify that Connection Request is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_CONNECTION_REQUEST_DISBALE);
			break;
		case AS_Comment:
			info("Verify that Activity Comment is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_COMMENT_DISBALE);
			break;
		case AS_Like:
			info("Verify that Activity like is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_LIKE_DISBALE);
			break;
		case AS_Mention:
			info("Verify that Activity mention is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_MENTION_DISBALE);
			break;
		case AS_Post:
			info("Verify that Activity post is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_POST_DISBALE);
			break;
		case Space_Invitation:
			info("Verify that Space invitation is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_SPACE_INVITATION_DISBALE);
			break;
		case Space_Join:
			info("Verify that Space join is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_SPACE_JOIN_DISBALE);
			break;
		case Space_Post:
			info("Verify that Space post is disabled");
			waitForAndGetElement(ELEMENT_ADMIN_NOTIFICATION_SPACE_POST_DISBALE);
			break;
		}
		
		
	}
	/**
	 * Change information of Notification Sender area
	 * @param name
	 * @param address
	 */
	public void changeNotificationSender(String name,String address){
		if(!name.isEmpty()){
			info("Input name");
			type(ELEMENT_ADMIN_NOTIFICATION_SENDER_NAME,name,true);
		}
		if(!address.isEmpty()){
			info("Input address");
			type(ELEMENT_ADMIN_NOTIFICATION_SENDER_ADDRESS,address,true);
		}
		
		info("Click on Save button");
		click(ELEMENT_ADMIN_NOTIFICATION_SENDER_SAVE_BTN);
		
	}
	/**
	 * Verify fail when input incorrect address in Notification Sender area
	 */
	public void verifyFailChangeNotificationSender(){
		info("Verify error message when input invalid email");
		waitForAndGetElement(ELEMENT_NOTIFICATION_SENDER_ERROR_MESSAGE_INVALID_EMAIL);
	}
	
	/**
	 * Verify success when input correct name and address in Notification Sender area
	 */
	public void verifySuccessChangeNotificationSender(String name,String email){
		info("Verify success message when input correct name and email");
		waitForAndGetElement(ELEMENT_NOTIFICATION_SENDER_SUCCESS_MESSAGE.replace("$name",name).replace("$email",email));
	}
	/**
	 * Reset all Notification by default
	 */
	public void resetAllChangedNotifications(){
		resetNewUserNotification();
		resetConnectRequestNotification();
		resetSpaceJoinNotification();
		resetSpaceInvitationNotification();
		resetSpacePostNotification();
		resetActivityLikeNotification();
		resetActivityMentionNotification();
		resetActivityPostNotification();
		resetActivityCommentNotification();
		changeNotificationSender("eXo","noreply@exoplatform.com");
	}
	/**
	 * Reset New User Notification
	 */
	public void resetNewUserNotification(){
		By newuser_email=ELEMENT_NEW_USER_EMAIL_NOTIFICATION_TITLE;
		By newuser_intranet=ELEMENT_NEW_USER_INTRANET_NOTIFICATION_TITLE;
		By newuser_disable=ELEMENT_ADMIN_NOTIFICATION_NEW_USER_DISBALE;
		
		if(waitForAndGetElement(newuser_email,3000,0)==null 
				|| waitForAndGetElement(newuser_intranet,3000,0)==null 
				|| waitForAndGetElement(newuser_disable,3000,0)!=null){
			info("Reset New User Notifiction");
			click(ELEMENT_NEW_USER_NOTIFICATION_EDIT_BTN);
			check(ELEMENT_NEW_USER_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_NEW_USER_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_NEW_USER_NOTIFICATION_SAVE_BTN);
			waitForAndGetElement(newuser_email);
			waitForAndGetElement(newuser_intranet);
		}
	}
	
	/**
	 * Reset Connection Request Notification
	 */
	public void resetConnectRequestNotification(){
		By connect_email=ELEMENT_NEW_USER_EMAIL_NOTIFICATION_TITLE;
		By connect_intranet=ELEMENT_NEW_USER_INTRANET_NOTIFICATION_TITLE;
		By connect_disable=ELEMENT_ADMIN_NOTIFICATION_CONNECTION_REQUEST_DISBALE;
		
		if(waitForAndGetElement(connect_email,3000,0)==null 
				|| waitForAndGetElement(connect_intranet,3000,0)==null 
				|| waitForAndGetElement(connect_disable,3000,0)!=null){
			info("Reset Connection Request Notifiction");
			click(ELEMENT_CONNECTION_REQUEST_EDIT_BTN);
			check(ELEMENT_CONNECTION_REQUEST_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_CONNECTION_REQUEST_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_CONNECTION_REQUEST_SAVE_BTN);
			waitForAndGetElement(connect_email);
			waitForAndGetElement(connect_intranet);
		}
	}
	/**
	 * Reset Space Join Notification
	 */
	public void resetSpaceJoinNotification(){
		By space_join_email=ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_TITLE;
		By space_join_intranet=ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_TITLE;
		By space_join_disable=ELEMENT_ADMIN_NOTIFICATION_SPACE_JOIN_DISBALE;
		
		if(waitForAndGetElement(space_join_email,3000,0)==null 
				|| waitForAndGetElement(space_join_intranet,3000,0)==null 
				|| waitForAndGetElement(space_join_disable,3000,0)!=null){
			info("Reset Space Join Notifiction");
			click(ELEMENT_SPACE_NOTIFICATION_JOIN_EDIT_BTN);
			check(ELEMENT_SPACE_JOIN_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_SPACE_JOIN_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_SPACE_JOIN_NOTIFICATION_SAVE_BTN);
			waitForAndGetElement(space_join_email);
			waitForAndGetElement(space_join_intranet);
		}
	}
	
	/**
	 * Reset Space Invitation Notification
	 */
	public void resetSpaceInvitationNotification(){
		By space_invitation_email=ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_TITLE;
		By space_invitation_intranet=ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_TITLE;
		By space_invitation_disable=ELEMENT_ADMIN_NOTIFICATION_SPACE_INVITATION_DISBALE;
		
		if(waitForAndGetElement(space_invitation_email,3000,0)==null 
				|| waitForAndGetElement(space_invitation_intranet,3000,0)==null 
				|| waitForAndGetElement(space_invitation_disable,3000,0)!=null){
			info("Reset Space invitation Notifiction");
			click(ELEMENT_SPACE_NOTIFICATION_INVITATION_EDIT_BTN);
			check(ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_SPACE_INVITATION_NOTIFICATION_SAVE_BTN);
			waitForAndGetElement(space_invitation_email);
			waitForAndGetElement(space_invitation_intranet);
		}
	}
	
	/**
	 * Reset Space Post Notification
	 */
	public void resetSpacePostNotification(){
		By space_post_email=ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_TITLE;
		By space_post_intranet=ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_TITLE;
		By space_post_disable=ELEMENT_ADMIN_NOTIFICATION_SPACE_POST_DISBALE;
		
		if(waitForAndGetElement(space_post_email,3000,0)==null 
				|| waitForAndGetElement(space_post_intranet,3000,0)==null 
				|| waitForAndGetElement(space_post_disable,3000,0)!=null){
			info("Reset Space post Notifiction");
			click(ELEMENT_SPACE_NOTIFICATION_POST_EDIT_BTN);
			check(ELEMENT_SPACE_POST_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_SPACE_POST_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_SPACE_POST_NOTIFICATION_SAVE_BTN);
			waitForAndGetElement(space_post_email);
			waitForAndGetElement(space_post_intranet);
		}
	}
	
	/**
	 * Reset Activity Like Notification
	 */
	public void resetActivityLikeNotification(){
		By as_like_email=ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_TITLE;
		By as_like_intranet=ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_TITLE;
		By as_like_disable=ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_LIKE_DISBALE;
		
		if(waitForAndGetElement(as_like_email,3000,0)==null 
				|| waitForAndGetElement(as_like_intranet,3000,0)==null 
				|| waitForAndGetElement(as_like_disable,3000,0)!=null){
			info("Reset Activity Like Notifiction");
			click(ELEMENT_ACTIVITY_LIKE_EDIT_BTN);
			check(ELEMENT_ACTIVITY_LIKE_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_ACTIVITY_LIKE_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_ACTIVITY_LIKE_SAVE_BTN);
			waitForAndGetElement(as_like_email);
			waitForAndGetElement(as_like_intranet);
		}
	}
	
	/**
	 * Reset Activity Mention Notification
	 */
    public void resetActivityMentionNotification(){
    	By as_mention_email=ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_TITLE;
		By as_mention_intranet=ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_TITLE;
		By as_mention_disable=ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_MENTION_DISBALE;
		
		if(waitForAndGetElement(as_mention_email,3000,0)==null 
				|| waitForAndGetElement(as_mention_intranet,3000,0)==null 
				|| waitForAndGetElement(as_mention_disable,3000,0)!=null){
			info("Reset Activity Mention Notifiction");
			click(ELEMENT_ACTIVITY_MENTION_EDIT_BTN);
			check(ELEMENT_ACTIVITY_MENTION_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_ACTIVITY_MENTION_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_ACTIVITY_MENTION_SAVE_BTN);
			waitForAndGetElement(as_mention_email);
			waitForAndGetElement(as_mention_intranet);
		}
	}
    
    /**
	 * Reset Activity post Notification
	 */
    public void resetActivityPostNotification(){
    	By as_post_email=ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_TITLE;
		By as_post_intranet=ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_TITLE;
		By as_post_disable=ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_POST_DISBALE;
		
		if(waitForAndGetElement(as_post_email,3000,0)==null 
				|| waitForAndGetElement(as_post_intranet,3000,0)==null 
				|| waitForAndGetElement(as_post_disable,3000,0)!=null){
			info("Reset Activity post Notifiction");
			click(ELEMENT_ACTIVITY_POST_EDIT_BTN);
			check(ELEMENT_ACTIVITY_POST_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_ACTIVITY_POST_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_ACTIVITY_POST_SAVE_BTN);
			waitForAndGetElement(as_post_email);
			waitForAndGetElement(as_post_intranet);
		}
	}
    
    /**
	 * Reset Activity comment Notification
	 */
    public void resetActivityCommentNotification(){
    	By as_comment_email=ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_TITLE;
		By as_comment_intranet=ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_TITLE;
		By as_comment_disable=ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_COMMENT_DISBALE;
		
		if(waitForAndGetElement(as_comment_email,3000,0)==null 
				|| waitForAndGetElement(as_comment_intranet,3000,0)==null 
				|| waitForAndGetElement(as_comment_disable,3000,0)!=null){
			info("Reset Activity comment Notifiction");
			click(ELEMENT_ACTIVITY_COMMENT_EDIT_BTN);
			check(ELEMENT_ACTIVITY_COMMENT_EMAIL_NOTIFICATION_CHECKBOX,2);
			check(ELEMENT_ACTIVITY_COMMENT_INTRANET_NOTIFICATION_CHECKBOX,2);
			click(ELEMENT_ACTIVITY_COMMENT_SAVE_BTN);
			waitForAndGetElement(as_comment_email);
			waitForAndGetElement(as_comment_intranet);
		}
	}
}
