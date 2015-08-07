package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;

public class NotificationLocator extends PlatformBase{
   
	//*****************************************MY NOTIFICATION:EMAIL NOTIFICATION*******************************************\\
	//Email's format
	public final String ELEMENT_GMAIL_FORMAT_TITLE=".//*[@valign='middle']//*[contains(text(),'$title')]";
	public final String ELEMENT_GMAIL_FORMAT_OPENNING_SUB=".//*[text()='Hi $firstName,']";
	public final String ELEMENT_GMAIL_FORMAT_CONTENT=".//strong//*[contains(text(),'$fullName')]/../../..//*[contains(.,'$content')]";
	public final String ELEMENT_GMAIL_FORMAT_ACTIVITY_TITLE=".//*[text()='$title']";
	
	//New User notification
	public final String ELEMENT_GMAIL_NEWUSER = ".//span[contains(.,'${title} ${title} has joined eXo')]";
	
	//Post in friend's Activity Stream
	public final String ELEMENT_GMAIL_POST_IN_ACTIVITY_STREAM = ".//span[contains(.,'$fullName has posted on your activity stream: $content')]";
	public final String ELEMENT_GMAIL_POST_IN_AC_USER_LINK=".//*[contains(@href,'$username')]";
	public final By ELEMENT_GMAIL_POST_IN_AC_REPLY_BTN=By.xpath(".//*[contains(@href,'reply_activity')]");
	public final By ELEMENT_GMAIL_POST_IN_AC_VIEW_FULL_BTN=By.xpath(".//*[contains(@href,'view_full_activity')]");
	
	//Comment an Activity Email notification
	public final String ELEMENT_GMAIL_TITLE= ".//span[contains(.,'$title')]";
	public final String ELEMENT_GMAIL_TITLE_WITH_INDEX= "(.//span[contains(.,'$title')])[$num]";
	public final By ELEMENT_GMAIL_REPLY_BTN=By.xpath(".//*[contains(@href,'reply_activity')]");
	public final By ELEMENT_GMAIL_VIEW_FULL_BTN=By.xpath(".//*[contains(@href,'view_full_activity')]");
	
	//Activity portlet
	public final String ELEMENT_ACTIVITY_TITLE_CONTENT=".//*[@id='boxContainer']//*[contains(text(),'$text')]";
	public final By ELEMENT_ACITIVITY_AUTHOR_AVATAR=By.xpath(".//*[@id='UIUserActivityStreamPortlet']//img");
	public final By ELEMENT_ACTIVITY_AUTHOR_NAME=By.xpath(".//*[@id='UIUserActivityStreamPortlet']//*[contains(@class,'author')]");
	public final By ELEMENT_ACTIVITY_ICON_COMMENT=By.xpath(".//*[@id='UIUserActivityStreamPortlet']//*[contains(@class,'uiIconComment')]");
	public final By ELEMENT_ACTIVITY_ICON_LIKE=By.xpath(".//*[@id='UIUserActivityStreamPortlet']//*[contains(@class,'uiIconThumbUp ')]");
	public final By ELEMENT_ACTIVITY_COMMENT_BOX=By.xpath(".//*[contains(@class,'commentList ')]");
	
	public final String ELEMENT_ACTIVITY_COMMENT_HIGHLIGHT=".//*[@class='contentComment'][contains(.,'$comment')]/../../..[contains(@style,'rgb(240, 240, 240)')]";
	public final String ELEMENT_ACTIVITY_COMMENT_CONTENT=".//*[@class='contentComment'][contains(.,'$comment')]";
	
	public final By ELEMENT_COMMENTBOX=By.xpath("//*[@class='replaceTextArea editable']");
	public final By ELEMENT_COMMENT_BUTTON = By.xpath("//button[contains(@id,'CommentButton')]");
	public final By ELEMENT_ACTIVITY_ADD_YOUR_COMMENTLABEL = By.xpath("//*[contains(@id,'DisplayCommentTextarea')]/../div[@class='placeholder']");
	public final String ELEMENT_DELETE_COMMENT_BUTTON = "//*[@class='contentComment'  and contains(text(),\"${commentText}\")]/../../a[contains(@id,'DeleteCommentButton')]";
	public final By ELEMENT_ACTIVITY_NOT_FOUND=By.xpath(".//*[@id='UIUserActivityStreamPortlet']//*[contains(text(),'Activity not found')]");
	
	//Activity Answer
	public final String ELEMENT_ACTIVITY_ANSWER_POINT_NUMBER=".//*[contains(@class,'sumaryPoint')]//*[contains(text(),'$number')]";
	public final By ELEMENT_ACTIVITY_ANSWER_RATE_NOT_VALUE=By.xpath(".//*[@data-original-title='no value yet']");
	public final String ELEMENT_ACTIVITY_ANSWER_NUMBER=".//*[contains(text(),'$number Answer')]";
	public final By ELEMENT_ACTIVITY_ANSWER_COMMENT_NO=By.xpath(".//*[contains(text(),'No Comment')]");
	public final String ELEMENT_ACTIVITY_ANSWER_COMMENT_NUMBER=".//*[contains(text(),'$number Comment')]";
	
	//Activity has uploaded file
	public final By ELEMENT_ACTIVITY_UPLOADED_FILE_SIZE=By.xpath(".//*[@class='versionFile'][contains(text(),'File Size')]");
	public final String ELEMENT_ACTIVITY_UPLOAD_FILE_NAME=".//*[contains(@class,'text')]//*[@data-original-title='$fileName']";
	public final By ELEMENT_ACTIVITY_UPLOAD_FILE_THUMBNAIL=By.xpath(".//*[contains(@class,'mediaContent')]//img");
	public final By ELEMENT_ACTIVITY_UPLOAD_FILE_VIEW_ICON=By.xpath(".//*[contains(@class,'uiIconWatch')]");
	public final By ELEMENT_ACTIVITY_UPLOAD_FILE_DOWNLOAD=By.xpath(".//*[contains(@class,'actionBar')]//*[contains(@href,'portal')]");
	
	//Activity Topic
	public final String ELEMENT_ACTIVITY_TOPIC_DESCRIPTION=".//*[contains(@class,'text')][contains(text(),'$des')]";
	public final By ELEMENT_ACTIVITY_TOPIC_REPLY_ICON=By.xpath(".//*[contains(@class,'uiIconReply')]");
	public final By ELEMENT_ACTIVITY_TOPIC_VIEW_LAST_REPLY_ICON=By.xpath(".//*[contains(@class,'uiIconSocLastestReply')]");
	public final By ELEMENT_ACTIVITY_TOPIC_NO_REPLY=By.xpath(".//*[contains(@class,'contentForum')]//*[contains(text(),'No reply')]");
	public final String ELEMENT_ACTIVITY_TOPIC_REPLY_NUMBER=".//*[contains(@class,'contentForum')]//*[contains(text(),'$number reply')]";
	
	public final By ELEMENT_TITLE_POST = By.id("PostTitle");
	public final By ELEMENT_POST_CONTENT = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
    public final By ELEMENT_POST_FORM_SUBMIT = By.xpath("//*[@id='UIPostForm']//*[contains(text(),'Submit')]");
    public final String ELEMENT_POST_IN_TOPIC = "//*[@class='postViewTitle' and contains(text(),'{$title}')]/../..//*[@class='postContent']//*[contains(text(),'{$content}')]";
    
    //Activiti Wiki
    public final By ELEMENT_ACTIVITY_WIKI_VERSION=By.xpath(".//*[contains(@class,'versionLabel')]");
    public final String ELEMENT_ACTIVITY_WIKI_DESCRIPTION=".//*[@class='text'][contains(text(),'$des')]";
    
    
    
  //*****************************************MY NOTIFICATION:INTRANET NOTIFICATION*******************************************\\
    
    public final By ELEMENT_NOTIFICATION_POP_UP = By.id("NotificationPopup");
	public final String ELEMENT_USER_AVATAR = "//*[contains(@alt,'${userName}')]";
	
	//Notification popup list. Here, $name parameter is fullName or space's name
	public final String ELEMENT_NOTIFICATION_POPUP_MENTION=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'mentioned')]//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_REQUEST_CONNECT=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'connect')]//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_COMMENT=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'commented')]/../..//*[@class='content'][contains(.,'$activity')]";
	public final String ELEMENT_NOTIFICATION_POPUP_NEW_USER_JOIN_INTRANET=".//*[@id='NotificationPopup']//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_LIKE=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'likes')]//*[contains(@class,'user-name')][contains(text(),'$user')]";
	public final String ELEMENT_NOTIFICATION_POPUP_ACCEPT_REQUEST_CONNECT=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'connected')]//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_ACCEPT_INVITE_SPACE=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'joined space')]//*[contains(@class,'text-bold')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_INVITE_SPACE=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'invited')]//*[contains(@class,'text-bold')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_JOIN_SPACE=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'joined space')]//*[contains(@href,'javascript:void(0)')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_POST_IN_SPACE=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'posted')]/.//*[contains(text(),'$space')]/..//*[contains(@href,'javascript:void(0)')]";
	public final String ELEMENT_NOTIFICATION_POPUP_POST_IN_MY_ACTIVITY=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'posted')][contains(text(),'activity stream')]//*[contains(@href,'javascript:void(0)')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_POPUP_REQUEST_JOIN_SPACE=".//*[@id='NotificationPopup']//*[@class='status'][contains(.,'requested')]//*[contains(@href,'javascript:void(0)')][contains(text(),'$name')]";
	
	public final String ELEMENT_INTRANET_NOTIFICATION_USER=".//*[@id='NotificationPopup']//*[contains(@class,'user-name')][contains(text(),'$user')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_BADGE_NUMBER=".//*[contains(@class,'badgeNotification')][contains(text(),'$num')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_AVATAR=".//*[@id='NotificationPopup']//*[contains(@class,'avatarXSmall')]//*[contains(@alt,'$lastUser')]";
	public final By ELEMENT_VIEW_ALL = By.linkText("View All");
	public final String ELEMENT_INTRANET_NOTIFICATION_STATUS=".//*[@class='status'][contains(.,'$status')]//*[contains(@class,'user-name')][contains(text(),'$fullName')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_STATUS_SPACE=".//*[@class='status'][contains(.,\"$status\")]//*[contains(@class,'text-bold')][contains(text(),'$space')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_STATUS_ORDER="(.//*[@class='status'])[$num][contains(.,'$status')]//*[contains(text(),'$fullName')]";
	
	public final String ELEMENT_NOTIFICATION_SETTINGS_TITLE = ".//*[@id='uiNotificationSetting']//h3[text()='Notification Settings']";
    public final String ELEMENT_INTRANET_NOTIFICATION_UNREAD=".//*[contains(@class,'unread')][contains(.,'$status')]//*[contains(@class,'user-name')][contains(text(),'$fullName')]";
	public final By ELEMENT_INTRANET_NOTIFICATION_MARK_ALL_AS_READ=By.xpath(".//*[@id='NotificationPopup']//*[contains(@class,'markAll')]/a");
	public final String ELEMENT_INTRANET_NOTIFICATION_REMOVE_ICON="(.//*[@id='NotificationPopup']//*[contains(@class,'uiIconClose')])[$num]";
	public final By ELEMENT_INTRANET_NOTIFICATION_EMPTY_LIST=By.xpath(".//*[@id='NotificationPopup']//*[contains(@class,'no-items')][contains(text(),'No notifications')]");
	
	
	//All notification page list
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_MENTION=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'mentioned')]//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_REQUEST_CONNECT=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'connect')]//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_COMMENT=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'commented')]/../..//*[@class='content'][contains(.,'$activity')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_NEW_USER_JOIN_INTRANET=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'has joined')]//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_LIKE=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'likes')]//*[contains(@class,'user-name')][contains(text(),'$user')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_ACCEPT_REQUEST_CONNECT=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'connected')]//*[contains(@class,'user-name')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_ACCEPT_INVITE_SPACE=".//*[@id='UIIntranetNotificationsPortlet']//*[contains(.,'joined')]//*[contains(text(),'$space')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_INVITE_SPACE=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'invited')]//*[contains(@class,'text-bold')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_JOIN_SPACE=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'joined space')]//*[contains(@href,'javascript:void(0)')][contains(text(),'$name')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_POST_IN_SPACE=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'posted')]/.//*[contains(text(),'$space')]/..//*[contains(@href,'javascript:void(0)')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_POST_IN_MY_ACTIVITY=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'posted')][contains(text(),'activity stream')]//*[contains(@href,'javascript:void(0)')]";
	public final String ELEMENT_NOTIFICATION_ALL_PAGE_REQUEST_JOIN_SPACE=".//*[@id='UIIntranetNotificationsPortlet']//*[@class='status'][contains(.,'requested')]//*[contains(@href,'javascript:void(0)')][contains(text(),'$name')]";
	
	//Activity detail
	public final By ELEMENT_NOTIFICATION_UI_ACTIVITY_LOADER=By.xpath(".//*[@id='UIActivitiesLoader']");
	public final By ELEMENT_NOTIFICATION_UI_SPACE_ACCESS_PORTLET=By.xpath(".//*[@id='UISpaceAccessPortlet']");
	public final String ELEMENT_NOTIFICATION_ACTIVITY_TITLE_CONTENT=".//*[@id='boxContainer']//*[contains(text(),'$text')]";
	
	
	//comment
	public final String ELEMENT_INTRANET_NOTIFICATION_COMMENTS_CONTENT=".//*[@id='NotificationPopup']//*[contains(@class,'status')][contains(.,'$comment')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_TITLE=".//*[@id='NotificationPopup']//*[@class='content'][contains(.,'$title')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_COMMENT_HIGHLIGHT=".//*[@class='contentComment'][contains(.,'$comment')]/../../..[contains(@style,'rgb(240, 240, 240)')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_COMMENT_CONTENT=".//*[@class='contentComment'][contains(.,'$comment')]";
	
	public final String ELEMENT_COMMENT_HIGHLIGHTED = "//*[@style = 'background-color: rgb(240, 240, 240);']//*[contains(text(),'${comment}')]";
	public final String ELEMENT_COMMENT_ACTIVITY_VIEWER = "//*[contains(text(),'${comment}')]/../..//*[@class='author']/*[contains(@href,'${userName}')]";

	//Connection
	public final String ELEMENT_CONNECT_NOTIFICATION = "//*[contains(text(),'${fullName}')]/../..//*[contains(.,'wants to connect with you')]";
	public final String ELEMENT_CONNECT_ACCEPT_BUTTON = ".//*[contains(text(),'$fullName')]/../..//*[contains(@class,'action-item')]";
	public final String ELEMENT_CONNECT_REFUSE_BUTTON = ".//*[contains(text(),'$fullName')]/../..//*[contains(@class,'cancel-item')]";

	
	//Space Notification
	public final String ELEMENT_SPACE_INVITATION = "//*[contains(@alt,'${space}')]/../..//*[contains(text(),'${space}')]";
	public final String ELEMENT_MSG_SPACE_INVITATION_CLICK_ON_NOTIFICATION = "You are invited to join the space ${space} by the administrator.";

	//Request to join space 
	public final String ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'has requested access to')]//*[contains(text(),'${space}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_REQUEST_JOIN_SPACE_NO_TIME = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'has requested access to')]//*[contains(text(),'${space}')]";
	public final String ELEMENT_LIKE_IN_ACTIVITY_VIEWER = "//*[@class='uiIconThumbUp uiIconLightGray']/..";
	
	//All notification list
	public final By ELEMENT_ALL_NOTIFICATIONS = By.xpath(".//*[@id='UIIntranetNotificationsPortlet']//*[text()='All Notifications']");
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_AVATAR=".//*[@id='UIIntranetNotificationsPortlet']//*[contains(@class,'avatarXSmall')]//*[contains(@alt,'$lastUser')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_USER=".//*[@id='UIIntranetNotificationsPortlet']//*[contains(@class,'user-name')][contains(text(),'$user')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_COMMENTS_CONTENT=".//*[@id='UIIntranetNotificationsPortlet']//*[contains(@class,'status')][contains(.,'$comment')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_ACTIVITY_TITLE=".//*[@id='NotificationPopup']//*[@class='content'][contains(.,'$title')]";
	public final By ELEMENT_NOTIFICATION_SETTINGS_LINK = By.linkText("Notifications Settings");
	
	//Detail an activity 
	public final String ELEMENT_INTRANET_NOTIFICATION_DETAIL_ACTIVITY_DES=".//*[@class='description'][contains(text(),'$des')]";
	
	
	//************************************************ADMIN NOTIFICATION****************************************************************************\\
public final String ELEMENT_BELONGS_TO_CATEGORY="//*[@class='group-title']//*[contains(text(),'$category')]/following::*//*[@for='$notification']";
	
	//Disable notification's type
	public final By ELEMENT_ADMIN_NOTIFICATION_NEW_USER_DISBALE = By.xpath(".//*[@id='NewUserPlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_CONNECTION_REQUEST_DISBALE = By.xpath(".//*[@id='RelationshipReceivedRequestPlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_COMMENT_DISBALE = By.xpath(".//*[@id='ActivityCommentPlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_LIKE_DISBALE = By.xpath(".//*[@id='LikePlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_MENTION_DISBALE = By.xpath(".//*[@id='ActivityMentionPlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_POST_DISBALE = By.xpath(".//*[@id='PostActivityPlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_INVITATION_DISBALE = By.xpath(".//*[@id='SpaceInvitationPlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_JOIN_DISBALE = By.xpath(".//*[@id='RequestJoinSpacePlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_POST_DISBALE = By.xpath(".//*[@id='PostActivitySpaceStreamPlugin']//*[@class=\"\"]//*[contains(text(),'No notifications')]");
	
	//Enable notification's type
	public final By ELEMENT_ADMIN_NOTIFICATION_NEW_USER_ENABLE_EMAIL = By.xpath(".//*[@id='NewUserPlugin']//*[@class=\"\"]//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_CONNECTION_REQUEST_ENABLE_EMAIL = By.xpath(".//*[@id='RelationshipReceivedRequestPlugin']//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_COMMENT_ENABLE_EMAIL = By.xpath(".//*[@id='ActivityCommentPlugin']//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_LIKE_ENABLE_EMAIL = By.xpath(".//*[@id='LikePlugin']//*[@class=\"\"]//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_MENTION_ENABLE_EMAIL = By.xpath(".//*[@id='ActivityMentionPlugin']//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_POST_ENABLE_EMAIL = By.xpath(".//*[@id='PostActivityPlugin']//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_INVITATION_ENABLE_EMAIL = By.xpath(".//*[@id='SpaceInvitationPlugin']//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_JOIN_ENABLE_EMAIL = By.xpath(".//*[@id='RequestJoinSpacePlugin']//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_POST_ENABLE_EMAIL = By.xpath(".//*[@id='PostActivitySpaceStreamPlugin']//*[@class='MAIL_CHANNEL ']//*[@class='uiIconPLFMail']");
	
	public final By ELEMENT_ADMIN_NOTIFICATION_NEW_USER_ENABLE_INTRANET = By.xpath(".//*[@id='NewUserPlugin']//*[@class=\"\"]//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_CONNECTION_REQUEST_ENABLE_INTRANET = By.xpath(".//*[@id='RelationshipReceivedRequestPlugin']//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_COMMENT_ENABLE_INTRANET = By.xpath(".//*[@id='ActivityCommentPlugin']//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_LIKE_ENABLE_INTRANET = By.xpath(".//*[@id='LikePlugin']//*[@class=\"\"]//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_MENTION_ENABLE_INTRANET = By.xpath(".//*[@id='ActivityMentionPlugin']//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_ACTIVITY_POST_ENABLE_INTRANET = By.xpath(".//*[@id='PostActivityPlugin']//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_INVITATION_ENABLE_INTRANET = By.xpath(".//*[@id='SpaceInvitationPlugin']//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_JOIN_ENABLE_INTRANET = By.xpath(".//*[@id='RequestJoinSpacePlugin']//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	public final By ELEMENT_ADMIN_NOTIFICATION_SPACE_POST_ENABLE_INTRANET = By.xpath(".//*[@id='PostActivitySpaceStreamPlugin']//*[@class='WEB_CHANNEL ']//*[@class='uiIconPLFWeb']");
	
	public final String ELEMENT_NOTIFICATION_LABEL_NAME=".//*[contains(text(),'$label')]";
	
	
	
	public final By ELEMENT_TITLE_ADMIN_NOTIFICATIONS_PAGE = By.xpath("//*[@id='notificationAdmin']/h3");
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
}
