package org.exoplatform.selenium.platform.social;


import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.social.NotificationsAdminSeting.notificationType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNotificationsSetting extends PlatformBase{
	
	public final By ELEMENT_TITLE_NOTIFICATION_SETTING_PAGE=By.xpath(".//*[@id='uiNotificationSetting']//h3");
	public final String ELEMENT_BELONGS_TO_CATEGORY="//*[contains(text(),'$category')]/following::*//*[@for='$notification']";
	public final String ELEMENT_NOTIFICATION_LABEL_NAME=".//*[contains(text(),'$label')]";
	
	//disable notification's type
		

	//Form my notification setting
	public final By ELEMENT_MY_NOTIFICATION_SETTING_FORM=By.id("uiNotificationSetting");
	public final By ELEMENT_GENERAL_JOIN_INTRANET_GRID = By.xpath("//*[@id='uiNotificationSetting']//*[contains(text(),'Someone joins the social intranet')]");
	public final By ELEMENT_GENERAL_SEND_CONNECTION_GRID = By.xpath("//*[@id='uiNotificationSetting']//*[contains(text(),'Someone sends me a connection request')]");  
	public final By ELEMENT_RESET_BTN = By.xpath(".//button[@id='Reset']");
	public final By ELEMENT_RESET_CONFIRM = By.xpath(".//*[@id='UISocialPopupConfirmation']/..//a[contains(text(),'Confirm')]");
	public final By ELEMENT_RESET_CANCEL = By.xpath(".//*[@id='UISocialPopupConfirmation']/..//a[contains(text(),'Cancel')]");
	public final By ELEMENT_RESET_CONFIRM_MSG_ELEMENT=By.xpath("//*[@id='UISocialPopupConfirmation']//*[@class='confirmationIcon contentMessage']");
	public final String ELEMENT_RESET_CONFIRM_MSG="All your notification settings will be reset to default values. Your previous settings will be lost.";

	//public final By ELEMENT_MY_NOTIFICATION_LINK = By.xpath("//*[@class='uiIconPLFNotifications']");
	//public final By ELEMENT_MYNOTIFICATIONS_ICON_IN_MYDASHBOARD = By.xpath("//*[@class='active item']/*[contains(@href, 'notifications')]");
	
	//Someones join the social intranet
	public final By ELEMENT_MY_NOTIFICATION_NEW_USER_PLUGIN=By.xpath(".//*[@for='NewUserPlugin']");
	public final By ELEMENT_NEWUSER_ICON_EMAIL_NOTIFICATION=By.xpath(".//*[contains(@for,'NewUserPlugin')]/../..//*[contains(@class,'uiIconPLFMail')]");
	public final By ELEMENT_NEWUSER_ICON_INTRANET_NOTIFICATION=By.xpath(".//*[contains(@for,'NewUserPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");

	//Connection request
	public final By ELEMENT_MY_NOTIFICATION_CONNECTION_REQUEST_PLUGIN=By.xpath(".//*[@for='RelationshipReceivedRequestPlugin']");
	public final By ELEMENT_CONNECTION_REQUEST_ICON_EMAIL_NOTIFICATION=By.xpath(".//*[contains(@for,'RelationshipReceivedRequestPlugin')]/../..//*[contains(@class,'uiIconPLFMail')]");
	public final By ELEMENT_CONNECTION_REQUEST_ICON_INTRANET_NOTIFICATION=By.xpath(".//*[contains(@for,'RelationshipReceivedRequestPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");

	//Space invitation
	public final By ELEMENT_MY_NOTIFICATION_SPACE_INVITATION_PLUGIN=By.xpath(".//*[@for='SpaceInvitationPlugin']");
	public final By ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_ICON = By.xpath(".//*[contains(@for,'SpaceInvitationPlugin')]/../..//*[contains(@class,'uiIconPLFMail')]");
	public final By ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_ICON = By.xpath(".//*[contains(@for,'SpaceInvitationPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");

	//Activity comment
	public final By ELEMENT_MY_NOTIFICATION_ACTIVITY_COMMENT_PLUGIN=By.xpath(".//*[@for='ActivityCommentPlugin']");
	public final By ELEMENT_ACTIVITY_COMMENT_ICON_INTRANET_NOTIFICATION = By.xpath(".//*[contains(@for,'ActivityCommentPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");

	public final By ELEMENT_SWITCH_ONOFF_MAIL_BTN = By.xpath("//*[@class='uiSwitchBtn']/*[@name='channelMAIL_CHANNEL']/..");
	public final By ELEMENT_SWITCH_ONOFF_WEB_BTN = By.xpath("//*[@class='uiSwitchBtn']/*[@name='channelWEB_CHANNEL']/..");
	public final By ELEMENT_SWITCH_ONOFF_MAIL_ON = By.xpath("//*[@class='uiSwitchBtn']/*[@name='channelMAIL_CHANNEL'][contains(@checked,'checked')]");
	public final By ELEMENT_SWITCH_ONOFF_MAIL_OFF = By.xpath("//*[@class='uiSwitchBtn']/*[@name='channelMAIL_CHANNEL']");
	public final By ELEMENT_SWITCH_ONOFF_WEB_ON = By.xpath("//*[@class='uiSwitchBtn']/*[@name='channelWEB_CHANNEL'][contains(@checked,'checked')]");
	public final By ELEMENT_SWITCH_ONOFF_WEB_OFF = By.xpath("//*[@class='uiSwitchBtn']/*[@name='channelWEB_CHANNEL']");
	public final By ELEMENT_MAIL_VIEWMODE_FALSE = By.xpath("//*[text()='Notify me by email']/..//*[@class='iphoneStyle yesno staus-false']");
	public final By ELEMENT_WEB_VIEWMODE_FALSE = By.xpath("//*[text()='Notify me on-site']/..//*[@class='iphoneStyle yesno staus-false']");

	public final By ELEMENT_COLUMN_NOTIFYME = By.xpath("//*[@id='uiNotificationSetting']//table/thead/tr/th[contains(text(),'Notify me when')]");
	public final By ELEMENT_COLUMN_HOWTO = By.xpath("//*[@id='uiNotificationSetting']//table/thead/tr/th[contains(text(),'How to get notifications')]");

	//New user
	public final By ELEMENT_EDIT_NEWUSER_ICON = By.xpath("//*[@id='NewUserPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_NEWUSER_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELNewUserPlugin']");
	public final By ELEMENT_EDIT_NEWUSER_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELNewUserPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELNewUserPlugin']");
	public final By ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELNewUserPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_NEWUSER_LIST = By.id("MAIL_CHANNELNewUserPluginSelectBox");
	public final By ELEMENT_EDIT_NEWUSER_SAVE_BTN = By.xpath("//button[@id='NewUserPlugin']");
	public final By ELEMENT_EDIT_NEWUSER_LIST_DAILY = By.xpath("//*[@id='MAIL_CHANNELNewUserPluginSelectBox']/*[contains(text(),'Daily')]");
	public final By ELEMENT_EDIT_NEWUSER_LIST_WEEKLY = By.xpath("//*[@id='MAIL_CHANNELNewUserPluginSelectBox']/*[contains(text(),'Weekly')]");
	public final By ELEMENT_EDIT_NEWUSER_LIST_NEVER = By.xpath("//*[@id='MAIL_CHANNELNewUserPluginSelectBox']/*[contains(text(),'Never')]");
	public final By ELEMENT_EDIT_NEWUSER_WEB_ICON = By.xpath("//*[@id='NewUserPlugin']/../..//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_NEWUSER_MAIL_ICON = By.xpath("//*[@id='NewUserPlugin']/../..//*[@class='the-checkbox']//*[@class='uiIconPLFMail']");
    public final By ELEMENT_EDIT_NEW_USER_MAIL_DAILY=By.xpath("//*[@id='NewUserPlugin']/../..//*[@class='uiIconPLFMail']/..//strong[contains(text(),'Daily')]");
	//Connections
	public final By ELEMENT_EDIT_RECREQ_ICON = By.xpath("//*[@id='RelationshipReceivedRequestPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_RECREQ_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELRelationshipReceivedRequestPlugin']");
	public final By ELEMENT_EDIT_RECREQ_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELRelationshipReceivedRequestPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_RECREQ_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELRelationshipReceivedRequestPlugin']");
	public final By ELEMENT_EDIT_RECREQ_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELRelationshipReceivedRequestPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_RECREQ_LIST = By.id("MAIL_CHANNELRelationshipReceivedRequestPluginSelectBox");
	public final By ELEMENT_EDIT_RECREQ_SAVE_BTN = By.xpath("//button[@id='RelationshipReceivedRequestPlugin']");
	public final By ELEMENT_EDIT_RECREQ_WEB_ICON = By.xpath("//*[@id='RelationshipReceivedRequestPlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_RECREQ_MAIL_ICON = By.xpath("//*[@id='RelationshipReceivedRequestPlugin']/../..//*[@class='the-checkbox']");

	//Spaces
	public final By ELEMENT_MY_NOTIFICATION_SPACE_REQJOIN_PLUGIN=By.xpath(".//*[@for='RequestJoinSpacePlugin']");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_ICON = By.xpath("//*[@id='RequestJoinSpacePlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELRequestJoinSpacePlugin']");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELRequestJoinSpacePlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELRequestJoinSpacePlugin']");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELRequestJoinSpacePlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_LIST = By.id("MAIL_CHANNELRequestJoinSpacePluginSelectBox");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_SAVE_BTN = By.xpath("//button[@id='RequestJoinSpacePlugin']");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_WEB_ICON = By.xpath("//*[@id='RequestJoinSpacePlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_REQJOIN_SPACE_MAIL_ICON = By.xpath("//*[@id='RequestJoinSpacePlugin']/../..//*[@class='the-checkbox']");

	public final By ELEMENT_EDIT_INVI_SPACE_ICON = By.xpath("//*[@id='SpaceInvitationPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_INVI_SPACE_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELSpaceInvitationPlugin']");
	public final By ELEMENT_EDIT_INVI_SPACE_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELSpaceInvitationPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_INVI_SPACE_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELSpaceInvitationPlugin']");
	public final By ELEMENT_EDIT_INVI_SPACE_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELSpaceInvitationPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_INVI_SPACE_LIST = By.id("MAIL_CHANNELSpaceInvitationPluginSelectBox");
	public final By ELEMENT_EDIT_INVI_SPACE_SAVE_BTN = By.xpath("//button[@id='SpaceInvitationPlugin']");
	public final By ELEMENT_EDIT_INVI_SPACE_WEB_ICON = By.xpath("//*[@id='SpaceInvitationPlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_INVI_SPACE_MAIL_ICON = By.xpath("//*[@id='SpaceInvitationPlugin']/../..//*[@class='the-checkbox']");

	public final By ELEMENT_MY_NOTIFICATION_SPACE_POST_PLUGIN=By.xpath(".//*[@for='PostActivitySpaceStreamPlugin']");
	public final By ELEMENT_EDIT_POST_SPACE_ICON = By.xpath("//*[@id='PostActivitySpaceStreamPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_POST_SPACE_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELPostActivitySpaceStreamPlugin']");
	public final By ELEMENT_EDIT_POST_SPACE_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELPostActivitySpaceStreamPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_POST_SPACE_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELPostActivitySpaceStreamPlugin']");
	public final By ELEMENT_EDIT_POST_SPACE_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELPostActivitySpaceStreamPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_POST_SPACE_LIST = By.id("MAIL_CHANNELPostActivitySpaceStreamPluginSelectBox");
	public final By ELEMENT_EDIT_POST_SPACE_SAVE_BTN = By.xpath("//button[@id='PostActivitySpaceStreamPlugin']");
	public final By ELEMENT_EDIT_POST_SPACE_WEB_ICON = By.xpath("//*[@id='PostActivitySpaceStreamPlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_POST_SPACE_MAIL_ICON = By.xpath("//*[@id='PostActivitySpaceStreamPlugin']/../..//*[@class='the-checkbox']");

	//Activity Stream
	public final By ELEMENT_MY_NOTIFICATION_ACTIVITY_LIKE_PLUGIN=By.xpath(".//*[@for='LikePlugin']");
	public final By ELEMENT_EDIT_LIKE_ICON = By.xpath("//*[@id='LikePlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_LIKE_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELLikePlugin']");
	public final By ELEMENT_EDIT_LIKE_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELLikePlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_LIKE_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELLikePlugin']");
	public final By ELEMENT_EDIT_LIKE_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELLikePlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_LIKE_LIST = By.id("MAIL_CHANNELLikePluginSelectBox");
	public final By ELEMENT_EDIT_LIKE_SAVE_BTN = By.xpath("//button[@id='LikePlugin']");
	public final By ELEMENT_EDIT_LIKE_WEB_ICON = By.xpath("//*[@id='LikePlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_LIKE_MAIL_ICON = By.xpath("//*[@id='LikePlugin']/../..//*[@class='the-checkbox']");

	public final By ELEMENT_MY_NOTIFICATION_ACTIVITY_POST_PLUGIN=By.xpath(".//*[@for='PostActivityPlugin']");
	public final By ELEMENT_EDIT_POST_ICON = By.xpath("//*[@id='PostActivityPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_POST_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELPostActivityPlugin']");
	public final By ELEMENT_EDIT_POST_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELPostActivityPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_POST_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELPostActivityPlugin']");
	public final By ELEMENT_EDIT_POST_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELPostActivityPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_POST_LIST = By.id("MAIL_CHANNELPostActivityPluginSelectBox");
	public final By ELEMENT_EDIT_POST_SAVE_BTN = By.xpath("//button[@id='PostActivityPlugin']");
	public final By ELEMENT_EDIT_POST_WEB_ICON = By.xpath("//*[@id='PostActivityPlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_POST_MAIL_ICON = By.xpath("//*[@id='PostActivityPlugin']/../..//*[@class='the-checkbox']");

	public final By ELEMENT_EDIT_COMMENT_ICON = By.xpath("//*[@id='ActivityCommentPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_COMMENT_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELActivityCommentPlugin']");
	public final By ELEMENT_EDIT_COMMENT_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELActivityCommentPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_COMMENT_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELActivityCommentPlugin']");
	public final By ELEMENT_EDIT_COMMENT_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELActivityCommentPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_COMMENT_LIST = By.id("MAIL_CHANNELActivityCommentPluginSelectBox");
	public final By ELEMENT_EDIT_COMMENT_SAVE_BTN =  By.xpath("//button[@id='ActivityCommentPlugin']");
	public final By ELEMENT_EDIT_COMMENT_WEB_ICON = By.xpath("//*[@id='ActivityCommentPlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_COMMENT_MAIL_ICON = By.xpath("//*[@id='ActivityCommentPlugin']/../..//*[@class='the-checkbox']");

	public final By ELEMENT_MY_NOTIFICATION_MENTION_PLUGIN=By.xpath(".//*[@for='ActivityMentionPlugin']");
	public final By ELEMENT_EDIT_MENTION_ICON = By.xpath("//*[@id='ActivityMentionPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_MENTION_MAIL_CHECKBOX = By.xpath("//*[@for='MAIL_CHANNELActivityMentionPlugin']");
	public final By ELEMENT_EDIT_MENTION_MAIL_CHECKBOX_CHECKED = By.xpath("//*[@id='MAIL_CHANNELActivityMentionPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_MENTION_WEB_CHECKBOX = By.xpath("//*[@for='WEB_CHANNELActivityMentionPlugin']");
	public final By ELEMENT_EDIT_MENTION_WEB_CHECKBOX_CHECKED = By.xpath("//*[@id='WEB_CHANNELActivityMentionPlugin'][contains(@checked,'checked')]");
	public final By ELEMENT_EDIT_MENTION_LIST = By.id("MAIL_CHANNELActivityMentionPluginSelectBox");
	public final By ELEMENT_EDIT_MENTION_SAVE_BTN =  By.xpath("//button[@id='ActivityMentionPlugin']");
	public final By ELEMENT_EDIT_MENTION_WEB_ICON = By.xpath("//*[@id='ActivityMentionPlugin']/../..//i[@class='uiIconPLFWeb']");
	public final By ELEMENT_EDIT_MENTION_MAIL_ICON = By.xpath("//*[@id='ActivityMentionPlugin']/../..//*[@class='the-checkbox']");

	//Categories
	public final String ELEMENT_MYNOTIFICATION_SETTING_GROUP = "(//*[@class='left'])[$number]//*[contains(text(),'$groupName')]";
	public final String ELEMENT_MYNOTIFICATION_SETTING_TYPE = "(//*[@class='left'])[$number]//*[@for='$id']";

	/**
	 * constructor
	 * @param dr
	 */
	public MyNotificationsSetting(WebDriver dr){
		this.driver=dr;

	}

	public enum myNotiType{
		NewUser_email,NewUser_intranet,ConnectionRequest_email,ConnectionRequest_intranet,Comment_email,Comment_intranet,Like_email,Like_intranet,Post_email,Post_intranet,Mention_email,Mention_intranet,
		PostSpace_email,PostSpace_intranet,ReqJoin_email,ReqJoin_intranet,InvJoin_email,InvJoin_intranet;
	}
	/**
	 * Disable notification
	 * @param notifToDisable
	 */
	public void disableNotification(myNotiType notifToDisable){
		switch(notifToDisable){
		case NewUser_email:
			info("Click on Edit button");
			click(ELEMENT_EDIT_NEWUSER_ICON,0,true);
			if(isElementPresent(ELEMENT_EDIT_NEWUSER_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_NEWUSER_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_NEWUSER_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_NEWUSER_MAIL_ICON,3000,1);
			break;
		case NewUser_intranet:
			info("Click on Edit button");
			click(ELEMENT_EDIT_NEWUSER_ICON,0,true);
			if(isElementPresent(ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_NEWUSER_SAVE_BTN);
			info("Verify that intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_NEWUSER_WEB_ICON,3000,1);
			break;
		case ConnectionRequest_email:
			click(ELEMENT_EDIT_RECREQ_ICON);
			if(isElementPresent(ELEMENT_EDIT_RECREQ_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_RECREQ_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_RECREQ_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_RECREQ_MAIL_ICON,3000,1);
			break;
		case ConnectionRequest_intranet:
			click(ELEMENT_EDIT_RECREQ_ICON);
			if(isElementPresent(ELEMENT_EDIT_RECREQ_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_RECREQ_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_RECREQ_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_RECREQ_WEB_ICON,3000,1);
			break;
		case Comment_email:
			click(ELEMENT_EDIT_COMMENT_ICON);
			if(isElementPresent(ELEMENT_EDIT_COMMENT_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_COMMENT_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_COMMENT_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_COMMENT_MAIL_ICON,3000,1);
			break;
		case Comment_intranet:
			click(ELEMENT_EDIT_COMMENT_ICON);
			if(isElementPresent(ELEMENT_EDIT_COMMENT_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_COMMENT_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_COMMENT_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_COMMENT_WEB_ICON,3000,1);
			break;
		case Like_email:
			click(ELEMENT_EDIT_LIKE_ICON);
			if(isElementPresent(ELEMENT_EDIT_LIKE_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_LIKE_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_LIKE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_LIKE_MAIL_ICON,3000,1);
			break;
		case Like_intranet:
			click(ELEMENT_EDIT_LIKE_ICON);
			if(isElementPresent(ELEMENT_EDIT_LIKE_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_LIKE_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_LIKE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_LIKE_WEB_ICON,3000,1);
			break;
		case Post_email:
			click(ELEMENT_EDIT_POST_ICON);
			if(isElementPresent(ELEMENT_EDIT_POST_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_POST_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_POST_MAIL_ICON,3000,1);
			break;
		case Post_intranet:
			click(ELEMENT_EDIT_POST_ICON);
			if(isElementPresent(ELEMENT_EDIT_POST_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_POST_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_POST_WEB_ICON,3000,1);
			break;
		case Mention_email:
			click(ELEMENT_EDIT_MENTION_ICON);
			if(isElementPresent(ELEMENT_EDIT_MENTION_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_MENTION_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_MENTION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_MENTION_MAIL_ICON,3000,1);
			break;
		case Mention_intranet:
			click(ELEMENT_EDIT_MENTION_ICON);
			if(isElementPresent(ELEMENT_EDIT_MENTION_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_MENTION_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_MENTION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_MENTION_WEB_ICON,3000,1);
			break;
		case PostSpace_email:
			click(ELEMENT_EDIT_POST_SPACE_ICON);
			if(isElementPresent(ELEMENT_EDIT_POST_SPACE_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_POST_SPACE_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_POST_SPACE_MAIL_ICON,3000,1);
			break;
		case PostSpace_intranet:
			click(ELEMENT_EDIT_POST_SPACE_ICON);
			if(isElementPresent(ELEMENT_EDIT_POST_SPACE_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_POST_SPACE_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_POST_SPACE_WEB_ICON,3000,1);
			break;
		case ReqJoin_email:
			click(ELEMENT_EDIT_REQJOIN_SPACE_ICON);
			if(isElementPresent(ELEMENT_EDIT_REQJOIN_SPACE_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_REQJOIN_SPACE_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_REQJOIN_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_REQJOIN_SPACE_MAIL_ICON,3000,1);
			break;
		case ReqJoin_intranet:
			click(ELEMENT_EDIT_REQJOIN_SPACE_ICON);
			if(isElementPresent(ELEMENT_EDIT_REQJOIN_SPACE_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_REQJOIN_SPACE_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_REQJOIN_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_REQJOIN_SPACE_WEB_ICON,3000,1);
			break;
		case InvJoin_email:
			click(ELEMENT_EDIT_INVI_SPACE_ICON);
			if(isElementPresent(ELEMENT_EDIT_INVI_SPACE_MAIL_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_INVI_SPACE_MAIL_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_INVI_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_INVI_SPACE_MAIL_ICON,3000,1);
			break;
		case InvJoin_intranet:
			click(ELEMENT_EDIT_INVI_SPACE_ICON);
			if(isElementPresent(ELEMENT_EDIT_INVI_SPACE_WEB_CHECKBOX_CHECKED))
				click(ELEMENT_EDIT_INVI_SPACE_WEB_CHECKBOX);
			info("Click on Save button");
			click(ELEMENT_EDIT_INVI_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForElementNotPresent(ELEMENT_EDIT_INVI_SPACE_WEB_ICON,3000,1);
			break;
		}
	}
	/**
	 * Enable notification
	 * @param notifToEnable
	 */
	public void enableNotification(myNotiType notifToEnable, Object... opParams){
		String opt = (String) (opParams.length > 0 ? opParams[0]:"");

		switch(notifToEnable){
		case NewUser_email:
			info("Click on Edit button");
			click(ELEMENT_EDIT_NEWUSER_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_NEWUSER_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_NEWUSER_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_NEWUSER_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_NEWUSER_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_NEWUSER_MAIL_ICON,3000,1);
			break;
		case NewUser_intranet:
			info("Click on Edit button");
			click(ELEMENT_EDIT_NEWUSER_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_NEWUSER_SAVE_BTN);
			info("Verify that intranet notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_NEWUSER_WEB_ICON,3000,1);
			break;
		case ConnectionRequest_email:
			click(ELEMENT_EDIT_RECREQ_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_RECREQ_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_RECREQ_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_RECREQ_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_RECREQ_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_RECREQ_MAIL_ICON,3000,1);
			break;
		case ConnectionRequest_intranet:
			click(ELEMENT_EDIT_RECREQ_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_RECREQ_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_RECREQ_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_RECREQ_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_RECREQ_WEB_ICON,3000,1);
			break;
		case Comment_email:
			click(ELEMENT_EDIT_COMMENT_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_COMMENT_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_COMMENT_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_COMMENT_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_COMMENT_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_COMMENT_MAIL_ICON,3000,1);
			break;
		case Comment_intranet:
			click(ELEMENT_EDIT_COMMENT_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_COMMENT_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_COMMENT_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_COMMENT_SAVE_BTN);
			info("Verify that Intranet notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_COMMENT_WEB_ICON,3000,1);
			break;
		case Like_email:
			click(ELEMENT_EDIT_LIKE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_LIKE_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_LIKE_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_LIKE_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_LIKE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_LIKE_MAIL_ICON,3000,1);
			break;
		case Like_intranet:
			click(ELEMENT_EDIT_LIKE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_LIKE_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_LIKE_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_LIKE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_LIKE_WEB_ICON,3000,1);
			break;
		case Post_email:
			click(ELEMENT_EDIT_POST_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_POST_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_POST_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_POST_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_POST_MAIL_ICON,3000,1);
			break;
		case Post_intranet:
			click(ELEMENT_EDIT_POST_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_POST_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_POST_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_POST_WEB_ICON,3000,1);
			break;
		case Mention_email:
			click(ELEMENT_EDIT_MENTION_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_MENTION_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_MENTION_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_MENTION_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_MENTION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_MENTION_MAIL_ICON,3000,1);
			break;
		case Mention_intranet:
			click(ELEMENT_EDIT_MENTION_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_MENTION_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_MENTION_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_MENTION_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_MENTION_WEB_ICON,3000,1);
			break;
		case PostSpace_email:
			click(ELEMENT_EDIT_POST_SPACE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_POST_SPACE_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_POST_SPACE_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_POST_SPACE_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_POST_SPACE_MAIL_ICON,3000,1);
			break;
		case PostSpace_intranet:
			click(ELEMENT_EDIT_POST_SPACE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_POST_SPACE_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_POST_SPACE_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_POST_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_POST_SPACE_WEB_ICON,3000,1);
			break;
		case ReqJoin_email:
			click(ELEMENT_EDIT_REQJOIN_SPACE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_REQJOIN_SPACE_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_REQJOIN_SPACE_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_REQJOIN_SPACE_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_REQJOIN_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_REQJOIN_SPACE_MAIL_ICON,3000,1);
			break;
		case ReqJoin_intranet:
			click(ELEMENT_EDIT_REQJOIN_SPACE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_REQJOIN_SPACE_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_REQJOIN_SPACE_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_REQJOIN_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_REQJOIN_SPACE_WEB_ICON,3000,1);
			break;
		case InvJoin_email:
			click(ELEMENT_EDIT_INVI_SPACE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_INVI_SPACE_MAIL_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_INVI_SPACE_MAIL_CHECKBOX,2);
			if(!opt.isEmpty())
			select(ELEMENT_EDIT_INVI_SPACE_LIST,opt);
			info("Click on Save button");
			click(ELEMENT_EDIT_INVI_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_INVI_SPACE_MAIL_ICON,3000,1);
			break;
		case InvJoin_intranet:
			click(ELEMENT_EDIT_INVI_SPACE_ICON);
			if(isElementNotPresent(ELEMENT_EDIT_INVI_SPACE_WEB_CHECKBOX_CHECKED))
				check(ELEMENT_EDIT_INVI_SPACE_WEB_CHECKBOX,2);
			info("Click on Save button");
			click(ELEMENT_EDIT_INVI_SPACE_SAVE_BTN);
			info("Verify that email notification is hidded");
			waitForAndGetElement(ELEMENT_EDIT_INVI_SPACE_WEB_ICON,3000,1);
			break;
		}
	}
	/**
	 * turn on/off email notification
	 * true for on, false for off
	 */
	public void turnOnOffNotiEmail(boolean on){
		if (on==true){
			if (isElementPresent(ELEMENT_SWITCH_ONOFF_MAIL_ON))
				info("Email notification is already ON");	
			else
				click(ELEMENT_SWITCH_ONOFF_MAIL_OFF,2);
		}else{
			if (isElementPresent(ELEMENT_SWITCH_ONOFF_MAIL_ON))
				click(ELEMENT_SWITCH_ONOFF_MAIL_ON,2);
			else
				info("Email notification is already OFF");
		}
	}

	/**
	 * turn on/off intranet notification
	 * true for on, false for off
	 */
	public void turnOnOffNotiIntranet(boolean on){
		if (on==true){
			if (isElementPresent(ELEMENT_SWITCH_ONOFF_WEB_ON))
				info("Intranet notification is already ON");	
			else{
				click(ELEMENT_SWITCH_ONOFF_WEB_OFF,2);
			}
		}else{
			if (isElementPresent(ELEMENT_SWITCH_ONOFF_WEB_ON)){
				click(ELEMENT_SWITCH_ONOFF_WEB_ON,2);
			}
			else
				info("Intranet notification is already OFF");

		}
	}
	/**
	 * Reset all notificaiton setting
	 */
	public void resetNotificationSetting(){
		info("Reset all notification setting");
		click(ELEMENT_RESET_BTN);
		click(ELEMENT_RESET_CONFIRM);
		Utils.pause(2000);
	}
	
	/**
	 * Check the title of Notification settings page
	 */
	public void verifyTilePage(){
		info("Verify the title of Notification settings page");
		waitForAndGetElement(ELEMENT_TITLE_NOTIFICATION_SETTING_PAGE);
		info("The page is shown");
	}
	
	/**
	 * Define notification plugin is disable all
	 */
	public enum notiMode{
		NewUser,ConnectionRequest,AS_Comment,AS_Like,
		AS_Mention,AS_Post,Space_Invitation,Space_Join,Space_Post;
	}
	
	/**
	 * Verify that a notification belongs to a category
	 * @param category
	 *                 is the category's name
	 * @param type
	 *                 is notification's type
	 */
	public void verifyNotiBelongToCategory(String category,notiMode type){
		switch(type){
		case NewUser:
			info("Verify that New user notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","NewUserPlugin"));
			info("The notification is shown with correct category");
			break;
		case ConnectionRequest:
			info("Verify that Connection Request notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","RelationshipReceivedRequestPlugin"));
			info("The notification is shown with correct category");
			break;
		case Space_Join:
			info("Verify that Space Join Request notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","RequestJoinSpacePlugin"));
			info("The notification is shown with correct category");
			break;
		case Space_Invitation:
			info("Verify that Space invitation notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","SpaceInvitationPlugin"));
			info("The notification is shown with correct category");
			break;
		case Space_Post:
			info("Verify that Post on My Spaces notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","PostActivitySpaceStreamPlugin"));
			info("The notification is shown with correct category");
			break;
		case AS_Post:
			info("Verify that Post on My Stream notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","PostActivityPlugin"));
			info("The notification is shown with correct category");
			break;
		case AS_Like:
			info("Verify that Like notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","LikePlugin"));
			info("The notification is shown with correct category");
			break;
		case AS_Mention:
			info("Verify that Mention notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","ActivityMentionPlugin"));
			info("The notification is shown with correct category");
			break;
		case AS_Comment:
			info("Verify that Comment notification belongs to "+category);
			waitForAndGetElement(ELEMENT_BELONGS_TO_CATEGORY.
					replace("$category",category).replace("$notification","ActivityCommentPlugin"));
			info("The notification is shown with correct category");
			break;
		}
		
	}
	
	
	 /**
     * Verify that a notification is enabled
     * @param type
     *           as NewUser_email, NewUser_intranet,...
     */
    public void verifyNotificationTypeEnable(notificationType type){
    	switch(type){
    	case NewUser_email:
    		info("Verify that email for new user notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_NEWUSER_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case NewUser_intranet:
    		info("Verify that email for new user notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_NEWUSER_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Comment_email:
    		info("Verify that email for comment notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_COMMENT_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Comment_intranet:
    		info("Verify that intranet for comment notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_COMMENT_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Like_email:
    		info("Verify that email for like notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_LIKE_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Like_intranet:
    		info("Verify that intranet for like notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_LIKE_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Mention_email:
    		info("Verify that email for mention notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_MENTION_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Mention_intranet:
    		info("Verify that intranet for mention notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_MENTION_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Post_email:
    		info("Verify that email for post notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_POST_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case AS_Post_intranet:
    		info("Verify that email for post notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_POST_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case ConnectionRequest_email:
    		info("Verify that email for connection request notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_RECREQ_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case ConnectionRequest_intranet:
    		info("Verify that intranet for connection request notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_RECREQ_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case Space_Invitation_email:
    		info("Verify that email for space invitation notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_INVI_SPACE_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case Space_Invitation_intranet:
    		info("Verify that intranet for space invitation notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_INVI_SPACE_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case Space_Join_email:
    		info("Verify that email for space joint request notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_REQJOIN_SPACE_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case Space_Join_intranet:
    		info("Verify that intranet for space joint request notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_REQJOIN_SPACE_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	case Space_Post_email:
    		info("Verify that email for space post notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_POST_SPACE_MAIL_ICON);
    		info("The notification is shown successfully");
    		break;
    	case Space_Post_intranet:
    		info("Verify that intranet for space post notification is shown");
    		waitForAndGetElement(ELEMENT_EDIT_POST_SPACE_WEB_ICON);
    		info("The notification is shown successfully");
    		break;
    	}
    }
    	
	/**
	 * Verify that notification's type is disabled all
	 * @param type
	 */
	public void veriftyNotificationTypeDisable(notificationType type){
		switch(type){
		case NewUser_email:
			info("Verify that New user's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_NEWUSER_WEB_ICON);
			info("Verify that daily email is shown");
			waitForAndGetElement(ELEMENT_EDIT_NEW_USER_MAIL_DAILY);
			break;
		case NewUser_intranet:
			info("Verify that New user's notification's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_NEWUSER_WEB_ICON);
			break;
		case ConnectionRequest_email:
			info("Verify that Connection request's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_RECREQ_MAIL_ICON);
			break;
		case ConnectionRequest_intranet:
			info("Verify that Connection request's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_RECREQ_WEB_ICON);
			break;
		case AS_Comment_email:
			info("Verify that Activity Comment's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_COMMENT_MAIL_ICON);
			break;
		case AS_Comment_intranet:
			info("Verify that Activity like's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_COMMENT_WEB_ICON);
			break;
		case AS_Mention_email:
			info("Verify that Activity mention's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_MENTION_MAIL_ICON);
		case AS_Mention_intranet:
			info("Verify that Activity mention's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_MENTION_WEB_ICON);
			break;
		case AS_Like_email:
			info("Verify that Activity like's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_LIKE_MAIL_ICON);
		case AS_Like_intranet:
			info("Verify that Activity like's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_LIKE_WEB_ICON);
			break;
		case AS_Post_email:
			info("Verify that Activity post's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_POST_MAIL_ICON);
			break;
		case AS_Post_intranet:
			info("Verify that Activity post's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_POST_WEB_ICON);
			break;
		case Space_Invitation_email:
			info("Verify that Space invitation's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_INVI_SPACE_MAIL_ICON);
			break;
		case Space_Invitation_intranet:
			info("Verify that Space invitation's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_INVI_SPACE_WEB_ICON);
			break;
		case Space_Join_email:
			info("Verify that Space join's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_POST_SPACE_MAIL_ICON);
			break;
		case Space_Join_intranet:
			info("Verify that Space join's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_POST_SPACE_WEB_ICON);
			break;
		case Space_Post_email:
			info("Verify that Space post's email is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_POST_SPACE_MAIL_ICON);
			break;
		case Space_Post_intranet:
			info("Verify that Space post's intranet is disabled");
			waitForElementNotPresent(ELEMENT_EDIT_POST_SPACE_WEB_ICON);
			break;
		}
	}
	
	/**
     * Verify the label of notification's types
     * @param label
     *               as: Someone comments on one of my activities,...
     */
    public void verifyLabelNotificationType(String label){
    	info("Verify that the label of Comment notification is correct");
		waitForAndGetElement(ELEMENT_NOTIFICATION_LABEL_NAME.replace("$label", label));
		info("the label is correct");
    	
    }
}
