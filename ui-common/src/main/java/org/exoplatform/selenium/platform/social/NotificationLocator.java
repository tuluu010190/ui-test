package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;

public class NotificationLocator extends PlatformBase{
   
	//*****************************************EMAIL NOTIFICATION*******************************************\\
	
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
    
    
    
  //*****************************************INTRANET NOTIFICATION*******************************************\\
    
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
	
}
