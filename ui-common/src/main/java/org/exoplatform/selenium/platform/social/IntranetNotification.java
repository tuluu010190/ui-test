package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.ArrayList;

import org.exoplatform.selenium.platform.ConnectionsManagement;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.exoplatform.selenium.Utils;

public class IntranetNotification extends PlatformBase{

	public final By ELEMENT_NOTIFICATION_POP_UP = By.id("NotificationPopup");
	public final String ELEMENT_USER_AVATAR = "//*[contains(@alt,'${userName}')]";

	//Notificaiton list popup
	public final String ELEMENT_INTRANET_NOTIFICATION_USER=".//*[@id='NotificationPopup']//*[contains(@class,'user-name')][contains(text(),'$user')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_BADGE_NUMBER=".//*[contains(@class,'badgeNotification')][contains(text(),'$num')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_AVATAR=".//*[@id='NotificationPopup']//*[contains(@class,'avatarXSmall')]//*[contains(@alt,'$lastUser')]";
	public final By ELEMENT_VIEW_ALL = By.linkText("View All");
	public final By ELEMENT_INTRANET_NOTIFICATION_POPUP_STATUS=By.xpath(".//*[@id='NotificationPopup']//*[@class='status']");
	public final String ELEMENT_INTRANET_NOTIFICATION_STATUS_ACCEPT_CONNECTION=".//*[@class='status'][contains(.,'$status')]//*[contains(@class,'user-name')][contains(text(),'$fullName')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_STATUS_SEND_CONNECTION=".//*[@class='status'][contains(.,'$status')]//*[contains(@class,'user-name')][contains(text(),'$fullName')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_STATUS=".//*[@class='status'][contains(.,'$status')]//*[contains(@class,'user-name')][contains(text(),'$fullName')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_STATUS_ORDER="(.//*[@class='status'])[$num][contains(.,'$status')]//*[contains(text(),'$fullName')]";
	public final By     ELEMENT_INTRANET_NOTIFICATION_PAGE_FIRST_NOTIFICATION=By.xpath("(.//*[@id='UIIntranetNotificationsPortlet']//*[contains(@class,'uiIcon')])[1]");
	public final String ELEMENT_INTRANET_NOTIFICATION_ORDER_NOTIFICATION="(.//*[@id='NotificationPopup']//*[contains(@class,'status')])[$num]";
	public final By ELEMENT_NOTIFICATION_SETTINGS_LINK = By.linkText("Notifications Settings");
	public final String ELEMENT_NOTIFICATION_SETTINGS_TITLE = ".//*[@id='uiNotificationSetting']//h3[text()='Notification Settings']";
    public final String ELEMENT_INTRANET_NOTIFICATION_UNREAD=".//*[contains(@class,'unread')][contains(.,'$status')]//*[contains(@class,'user-name')][contains(text(),'$fullName')]";
	public final By ELEMENT_INTRANET_NOTIFICATION_MARK_ALL_AS_READ=By.xpath(".//*[@id='NotificationPopup']//*[contains(@class,'markAll')]/a");
	public final String ELEMENT_INTRANET_NOTIFICATION_REMOVE_ICON="(.//*[@id='NotificationPopup']//*[contains(@class,'uiIconClose')])[$num]";
	public final By ELEMENT_INTRANET_NOTIFICATION_EMPTY_LIST=By.xpath(".//*[@id='NotificationPopup']//*[contains(@class,'no-items')][contains(text(),'No notifications')]");
	//comment
	public final String ELEMENT_INTRANET_NOTIFICATION_COMMENTS_CONTENT=".//*[@id='NotificationPopup']//*[contains(@class,'status')][contains(.,'$comment')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_TITLE=".//*[@id='NotificationPopup']//*[@class='content'][contains(.,'$title')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_DETAIL=".//*[@class='description'][contains(text(),'$activity')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_COMMENT_HIGHLIGHT=".//*[contains(text(),'$comment')]/../../..[contains(@style,'rgb(240, 240, 240)')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_COMMENT_CONTENT=".//*[contains(text(),'$comment')]";
	
	public final String ELEMENT_COMMENT_ONE_MINUTE = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has commented on your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_COMMENT_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has commented on your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_COMMENT_NO_TIME = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has commented on your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]";
	public final String ELEMENT_COMMENT_POSITION_ONE_MINUTE = "//li[${position}]//img[contains(@alt,'${userName}')]/../..//*[contains(.,'has commented on your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_COMMENT_POSITION_JUST_NOW = "//li[${position}]//img[contains(@alt,'${userName}')]/../..//*[contains(.,'has commented on your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_COMMENT_2_USERS_ONE_MINUTE = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(.,'and')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_COMMENT_2_USERS_JUST_NOW = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(.,'and')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_COMMENT_3_USERS_ONE_MINUTE = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(.,',')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_COMMENT_3_USERS_JUST_NOW = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(text(),',')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_COMMENT_2_USERS_POSITION_ONE_MINUTE = "//li[${position}]//img[contains(@alt,'${userName2}')]/../..//*[ontains(text(),'${userName2}')]/../..//*[contains(.,'and')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_COMMENT_2_USERS_POSITION_JUST_NOW = "//li[${position}]//img[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(.,'and')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_COMMENT_3_USERS_POSITION_ONE_MINUTE = "//li[${position}]//img[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(.,',')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_COMMENT_3_USERS_POSITION_JUST_NOW = "//li[${position}]//img[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(.,',')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_COMMENT_MORE_USERS_COMMENT = "and 1 more have commented on your activity.";
	public final String ELEMENT_COMMENT_MANY_USERS_COMMENT = "have commented on your activity.";
	public final String ELEMENT_COMMENT_HIGHLIGHTED = "//*[@style = 'background-color: rgb(240, 240, 240);']//*[contains(text(),'${comment}')]";
	public final String ELEMENT_COMMENT_ACTIVITY_VIEWER = "//*[contains(text(),'${comment}')]/../..//*[@class='author']/*[contains(@href,'${userName}')]";

	//Time Date intranet
	public final String ELEMET_JUST_NOW_STRING="Just Now";
	public final String ELEMET_MINUTE_STRING="${number} minutes ago";
	public final String ELEMET_HOUR_STRING="${number} hours ago";

	//Time locator
	public final String ELEMENT_TIME_NOTIFICATION_LOCATOR="/parent::div/descendant::div[@class='lastUpdatedTime' and text()='${time}']";

	//Activity locator
	public final String ELEMENT_ACTIVITY_NOTIFICATION_LOCATOR="/parent::div/descendant::*[contains(text(),'${activity}')]";

	//Username locator
	public final String ELEMENT_NAME_LOCATOR="/a[${index}][contains(@class,'user-name')  and contains(text(),'${name}')]/parent::div";

	//notification message
	public final String ELEMENT_NOTIFICATION_TYPE="//*[contains(.,'${message}')]";

	//Type of notification
	public final String ELEMENT_NOTIFICATION_LIKE="likes your activity";
	public final String ELEMENT_NOTIFICATION_MANY_LIKE="like your activity";
	public final String ELEMENT_NOTIFICATION_MENTION="has mentioned you";
	public final String ELEMENT_NOTIFICATION_NUMBER_MORE_USER="${number} more ";

	public final String ELEMENT_READ_LOCATOR="//*[@class='displayItems']/li[contains(@class,'read')]";
	public final String ELEMENT_UNREAD_LOCATOR="//*[@class='displayItems']/li[contains(@class,'unread')]";

	//mention
	public final String ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY=ELEMENT_NOTIFICATION_TYPE+ELEMENT_NAME_LOCATOR+ELEMENT_ACTIVITY_NOTIFICATION_LOCATOR+ELEMENT_TIME_NOTIFICATION_LOCATOR;
	public final String ELEMENT_MENTION_HAS_TIME_NO_ACTIVITY=ELEMENT_NOTIFICATION_TYPE+ELEMENT_NAME_LOCATOR+ELEMENT_TIME_NOTIFICATION_LOCATOR;
	public final String ELEMENT_MENTION_NO_TIME_HAS_ACTIVITY=ELEMENT_NOTIFICATION_TYPE+ELEMENT_NAME_LOCATOR+ELEMENT_ACTIVITY_NOTIFICATION_LOCATOR;
	public final String ELEMENT_MENTION_NO_TIME_NO_ACTIVITY=ELEMENT_NOTIFICATION_TYPE+ELEMENT_NAME_LOCATOR;

	//Like notification
	public final String ELEMENT_LIKE_NOTIFICATION_HAS_TIME_USER_INDEX=ELEMENT_NOTIFICATION_TYPE+ELEMENT_NAME_LOCATOR+ELEMENT_ACTIVITY_NOTIFICATION_LOCATOR+ELEMENT_TIME_NOTIFICATION_LOCATOR;
	public final String ELEMENT_LIKE_NOTIFICATION_NO_TIME_USER_INDEX=ELEMENT_NOTIFICATION_TYPE+ELEMENT_NAME_LOCATOR+ELEMENT_ACTIVITY_NOTIFICATION_LOCATOR;
	public final String ELEMENT_LIKE_NOTIFICATION_NO_TIME_NUMBERUSER=ELEMENT_NOTIFICATION_TYPE+ELEMENT_ACTIVITY_NOTIFICATION_LOCATOR;
	public final String ELEMENT_LIKE_NOTIFICATION_HAS_TIME_NUMBERUSER=ELEMENT_NOTIFICATION_TYPE+ELEMENT_ACTIVITY_NOTIFICATION_LOCATOR+ELEMENT_TIME_NOTIFICATION_LOCATOR;

	//Connection
	public final String ELEMENT_CONNECT_NOTIFICATION = "//*[contains(text(),'${fullName}')]/../..//*[contains(.,'wants to connect with you')]";
	public final String ELEMENT_CONNECT_ACCEPT_BUTTON = ".//*[contains(text(),'$fullName')]/../..//*[contains(@class,'action-item')]";
	public final String ELEMENT_CONNECT_REFUSE_BUTTON = ".//*[contains(text(),'$fullName')]/../..//*[contains(@class,'cancel-item')]";
	public final String ELEMENT_CONNECTED_SUCCESS_ONE_MINUTE = "//*[contains(@alt,'${fullName}')]/../..//*[contains(.,'You are connected with')]//*[contains(text(),'${fullName}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_CONNECTED_SUCCESS_JUST_NOW = "//*[contains(@alt,'${fullName}')]/../..//*[contains(.,'You are connected with')]//*[contains(text(),'${fullName}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";

	//Post in Activity Stream
	public final String ELEMENT_POST_ACTIVITY_ONE_MINUTE = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has posted on your activity stream.')]/..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_POST_ACTIVITY_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has posted on your activity stream.')]/..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_POST_ACTIVITY_NO_TIME = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has posted on your activity stream.')]/..//*[contains(text(),'${activity}')]";
	public final String ELEMENT_POST_ACTIVITY_SPACE_ONE_MINUTE = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has posted an activity in the')]/..//*[contains(text(),'${userName}')]/..//*[contains(text(),'${space}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_POST_ACTIVITY_SPACE_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has posted an activity in the')]/..//*[contains(text(),'${userName}')]/..//*[contains(text(),'${space}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_POST_ACTIVITY_SPACE_NO_TIME = "//*[contains(@alt,'${userName}')]/../..//*[contains(.,'has posted an activity in the')]/..//*[contains(text(),'${userName}')]/..//*[contains(text(),'${space}')]/../..//*[contains(text(),'${activity}')]";

	//Space Notification
	public final String ELEMENT_SPACE_INVITATION = "//*[contains(@alt,'${space}')]/../..//*[contains(text(),'${space}')]";
	public final String ELEMENT_SPACE_INVITATION_ACCEPT_BTN = ELEMENT_SPACE_INVITATION + "/../..//*[@class='confirm']//a[text()='Accept']";
	public final String ELEMENT_SPACE_INVITATION_REFUSE_BTN = ELEMENT_SPACE_INVITATION + "/../..//*[@class='confirm']//a[text()='Refuse']";
	public final By ELEMENT_STATUS_CLASS = By.className("status");
	public final String ELEMENT_MSG_SPACE_INVITATION = "You're invited to join";
	public final String ELEMENT_SPACE_INVITATION_SUUCESS_ONE_MINUTE = "//*[contains(@alt,'${space}')]/../..//*[contains(.,'You joined')]/*[contains(text(),'${space}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_SPACE_INVITATION_SUUCESS_JUST_NOW = "//*[contains(@alt,'${space}')]/../..//*[contains(.,'You joined')]/*[contains(text(),'${space}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_MSG_SPACE_INVITATION_CLICK_ON_NOTIFICATION = "You are invited to join the space ${space} by the administrator.";
	public final String ELEMENT_SPACE_INVITATION_CLICK_ON_NOTIFICATION_ACCEPT_BTN = ".//*[@id='UISpaceAccessPortlet']//*[text()='Accept']";
	public final String ELEMENT_SPACE_INVITATION_CLICK_ON_NOTIFICATION_REFUSE_BTN = ".//*[@id='UISpaceAccessPortlet']//*[text()='Refuse']";

	//Request to join space 
	public final String ELEMENT_REQUEST_JOIN_SPACE_ONE_MINUTE = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'has requested access to')]//*[contains(text(),'${space}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'${time] minute ago')]";
	public final String ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'has requested access to')]//*[contains(text(),'${space}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_REQUEST_JOIN_SPACE_NO_TIME = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'has requested access to')]//*[contains(text(),'${space}')]";
	public final String ELEMENT_REQUEST_TO_JOIN_ACCEPT_BTN = ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW + "/..//a[contains(text(),'Accept')]";
	public final String ELEMENT_REQUEST_TO_JOIN_REFUSE_BTN = ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW + "/..//a[contains(text(),'Refuse')]";
	public final String ELEMENT_REQUEST_TO_JOIN_SPACE_SUCCESS_ONE_MINUTE = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'joined')]//*[contains(text(),'${userName}')]/..//*[contains(text(),'${space}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_REQUEST_TO_JOIN_SPACE_SUCCESS_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'joined')]//*[contains(text(),'${userName}')]/..//*[contains(text(),'${space}')]/../..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";

	public final String ELEMENT_LIKE_NOTIFICATION_ONE_MINUTE = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'likes your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_LIKE_NOTIFICATION_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'likes your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_LIKE_NOTIFICATION_NO_TIME = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'likes your activity.')]//*[contains(text(), '${userName}')]/../..//*[contains(text(),'${activity}')]";
	public final String ELEMENT_LIKE_NOTIFICATION_POSITION_ONE_MINUTE = "//li[${position}]" + ELEMENT_LIKE_NOTIFICATION_ONE_MINUTE;
	public final String ELEMENT_LIKE_NOTIFICATION_POSITION_JUST_NOW = "//li[${position}]" + ELEMENT_LIKE_NOTIFICATION_JUST_NOW;
	public final String ELEMENT_LIKE_IN_ACTIVITY_VIEWER = "//*[@class='uiIconThumbUp uiIconLightGray']/..";
	public final String ELEMENT_LIKE_NOTIFICATION_2_USERS_JUST_NOW = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(text(),'and')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_LIKE_NOTIFICATION_2_USERS_ONE_MINUTE = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(text(),'and')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_LIKE_NOTIFICATION_2_USERS_POSITION_ONE_MINUTE = "//li[${position}]" + ELEMENT_LIKE_NOTIFICATION_2_USERS_ONE_MINUTE;
	public final String ELEMENT_LIKE_NOTIFICATION_2_USERS_POSITION_JUST_NOW = "//li[${position}]" + ELEMENT_LIKE_NOTIFICATION_2_USERS_JUST_NOW;
	public final String ELEMENT_LIKE_NOTIFICATION_MANY_USERS = "like your activity.";
	public final String ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_ONE_MINUTE = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(text(),',')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_JUST_NOW = "//*[contains(@alt,'${userName2}')]/../..//*[contains(text(),'${userName2}')]/../..//*[contains(text(),',')]//*[contains(text(),'${userName}')]/../..//*[contains(text(),'${activity}')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_MSG_LIKE_NOTIFICATION_MORE_THAN_2_USERS = "and ${moreUser} more like your activity.";
	public final String ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_JUST_NOW_POSITION = "//li[${position}]" + ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_JUST_NOW;
	public final String ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_ONE_MINUTE_POSITION = "//li[${position}]" + ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_ONE_MINUTE;

	// new user notification
	public final String ELEMENT_NEW_USER_NOTIFICATION_ONE_MINUTE = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'${userName}')]/../..//*[contains(.,'has joined eXo')]/..//*[@class='lastUpdatedTime' and contains(text(),'${time} minute ago')]";
	public final String ELEMENT_NEW_USER_NOTIFICATION_JUST_NOW = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'${userName}')]/../..//*[contains(.,'has joined eXo')]/..//*[@class='lastUpdatedTime' and contains(text(),'Just Now')]";
	public final String ELEMENT_NEW_USER_NOTIFICATION_NO_TIME = "//*[contains(@alt,'${userName}')]/../..//*[contains(text(),'${userName}')]/../..//*[contains(.,'has joined eXo')]";

	//enable new user notification
	public final By ELEMENT_EDIT_NEWUSER_ICON = By.xpath("//*[@id='NewUserPlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX = By.id("WEB_CHANNELNewUserPlugin");
	public final By ELEMENT_EDIT_NEWUSER_SAVE_BTN = By.id("NewUserPlugin");
	public final By ELEMENT_EDIT_NEWUSER_WEB_ICON = By.xpath("//*[@id='NewUserPlugin']/../..//i[@class='uiIconPLFWeb']");

	// enable like notification
	public final By ELEMENT_EDIT_LIKE_ICON = By.xpath("//*[@id='LikePlugin']/..//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_LIKE_WEB_CHECKBOX = By.id("WEB_CHANNELLikePlugin");
	public final By ELEMENT_EDIT_LIKE_SAVE_BTN = By.id("LikePlugin");
	public final By ELEMENT_EDIT_LIKE_WEB_ICON = By.xpath("//*[@id='LikePlugin']/../..//i[@class='uiIconPLFWeb']");

	UserProfilePage myProf;
	//All notification list
	public final By ELEMENT_ALL_NOTIFICATIONS = By.xpath(".//*[@id='UIIntranetNotificationsPortlet']//*[text()='All Notifications']");
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_AVATAR=".//*[@id='UIIntranetNotificationsPortlet']//*[contains(@class,'avatarXSmall')]//*[contains(@alt,'$lastUser')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_USER=".//*[@id='UIIntranetNotificationsPortlet']//*[contains(@class,'user-name')][contains(text(),'$user')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_COMMENTS_CONTENT=".//*[@id='UIIntranetNotificationsPortlet']//*[contains(@class,'status')][contains(.,'$comment')]";
	public final String ELEMENT_INTRANET_NOTIFICATION_ALL_ACTIVITY_TITLE=".//*[@id='NotificationPopup']//*[@class='content'][contains(.,'$title')]";

	
	//Detail an activity 
	public final String ELEMENT_INTRANET_NOTIFICATION_DETAIL_ACTIVITY_DES=".//*[@class='description'][contains(text(),'$des')]";
	
	//MyProfilePage myProf;
	NavigationToolbar navTool;
	HomePagePlatform hp;
	ConnectionsManagement connMag;
	SpaceManagement spaceManage;
	ManageLogInOut magAc;


	/**
	 * constructor
	 * @param dr
	 */
	public IntranetNotification(WebDriver dr){
		this.driver=dr;
	}

	/**
	 * function: check notification when users comment\
	 * @param userName user comment before the last comment
	 * @param activity
	 * @param time time when user comments
	 * @param checkPosition (true if need to check position of notification)
	 * @param position position of notification you want to check
	 * @param userNumber number of users comment in the same activity
	 * @param userName2 the last user comments in activity
	 */
	public void checkCommentNotification(String userName, String activity, String time, boolean checkPosition, String position, int userNumber, String userName2, boolean...params){
		info("Check Comment Notification");		
		Utils.pause(1000);
		boolean noTime = params.length > 0 ? params[0] : false;
		switch (userNumber){
		case 1:
			info("1 user comment");
			if (waitForAndGetElement(ELEMENT_COMMENT_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity), 5000, 0) == null)
				waitForAndGetElement(ELEMENT_COMMENT_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));
			if (checkPosition){
				if (waitForAndGetElement(ELEMENT_COMMENT_POSITION_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity).replace("${position}", position), 5000, 0) == null)
					waitForAndGetElement(ELEMENT_COMMENT_POSITION_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time).replace("${position}", position));
			}
			if (noTime)
				waitForAndGetElement(ELEMENT_COMMENT_NO_TIME.replace("${userName}", userName).replace("${activity}", activity));
			break;
		case 2:
			info("2 users comment");
			if (waitForAndGetElement(ELEMENT_COMMENT_2_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity), 5000, 0) == null){
				waitForAndGetElement(ELEMENT_COMMENT_2_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));					
				waitForTextPresent(ELEMENT_COMMENT_MANY_USERS_COMMENT);
			}
			else 
				waitForTextPresent(ELEMENT_COMMENT_MANY_USERS_COMMENT);
			if (checkPosition){
				if (waitForAndGetElement(ELEMENT_LIKE_NOTIFICATION_2_USERS_POSITION_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${position}", position), 5000, 0) == null)
					waitForAndGetElement(ELEMENT_COMMENT_2_USERS_POSITION_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time).replace("${position}", position));					
			}
			break;
		case 3:
			info("3 users comment");
			if (waitForAndGetElement(ELEMENT_COMMENT_3_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity), 5000, 0) == null){
				waitForAndGetElement(ELEMENT_COMMENT_3_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));
				waitForTextPresent(ELEMENT_COMMENT_MORE_USERS_COMMENT);
			}
			else 
				waitForTextPresent(ELEMENT_COMMENT_MORE_USERS_COMMENT);
			if (checkPosition){
				if (waitForAndGetElement(ELEMENT_COMMENT_3_USERS_POSITION_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${position}", position), 5000, 0) == null)
					waitForAndGetElement(ELEMENT_COMMENT_3_USERS_POSITION_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time).replace("${position}", position));
			}
			break;
		}
		info("Notification was verified successfully");	
	}

	/**
	 * check unread notification when users like
	 * @param userName
	 * @param activity
	 * @param time
	 * @return
	 */
	public WebElement checkUnreadLikeNotification(String userNames, String activity, String time){
		info("Check Like Notification");		
		Utils.pause(1000);
		String[] userName=userNames.split(",");
		WebElement elem = null;
		info("Verify that last user's avatar is shown in list");
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_AVATAR.
				replace("$lastUser",userName[0]));
		if(userName.length==1){
			info("One user likes activity");
			if(time!=null && time!="")
				elem=waitForAndGetElement(
						ELEMENT_UNREAD_LOCATOR+ELEMENT_LIKE_NOTIFICATION_HAS_TIME_USER_INDEX
						.replace("${message}", ELEMENT_NOTIFICATION_LIKE)
						.replace("${index}", "1").replace("${name}", userName[0].trim())
						.replace("${activity}", activity)
						.replace("${time}", time));
			else
				elem=waitForAndGetElement(
						ELEMENT_UNREAD_LOCATOR+ELEMENT_LIKE_NOTIFICATION_NO_TIME_USER_INDEX
						.replace("${message}", ELEMENT_NOTIFICATION_LIKE)
						.replace("${index}", "1").replace("${name}", userName[0].trim())
						.replace("${activity}", activity));
		}
		else{
			for(int i = 0; i<2; i++){
				info("Many users like activity");
				if(time!=null && time!="")
					elem=waitForAndGetElement(
							ELEMENT_UNREAD_LOCATOR+ELEMENT_LIKE_NOTIFICATION_HAS_TIME_USER_INDEX
							.replace("${message}", ELEMENT_NOTIFICATION_MANY_LIKE)
							.replace("${index}", String.valueOf(i+1)).replace("${name}", userName[i].trim())
							.replace("${activity}", activity)
							.replace("${time}", time));
				else
					elem=waitForAndGetElement(
							ELEMENT_UNREAD_LOCATOR+ELEMENT_LIKE_NOTIFICATION_NO_TIME_USER_INDEX
							.replace("${message}", ELEMENT_NOTIFICATION_MANY_LIKE)
							.replace("${index}", String.valueOf(i+1)).replace("${name}", userName[i].trim())
							.replace("${activity}", activity));

			}
			if(userName.length>2){
				info("Verify more user like activity");
				Integer remainUser=userName.length-2;
				if(time!=null && time!="")
					elem=waitForAndGetElement(
							ELEMENT_UNREAD_LOCATOR+ELEMENT_LIKE_NOTIFICATION_HAS_TIME_NUMBERUSER
							.replace("${message}", ELEMENT_NOTIFICATION_NUMBER_MORE_USER.replace("${number}", String.valueOf(remainUser))+ELEMENT_NOTIFICATION_MANY_LIKE)
							.replace("${activity}", activity)
							.replace("${time}", time));
				else
					elem=waitForAndGetElement(
							ELEMENT_UNREAD_LOCATOR+ELEMENT_LIKE_NOTIFICATION_NO_TIME_NUMBERUSER
							.replace("${message}", ELEMENT_NOTIFICATION_NUMBER_MORE_USER.replace("$number}", String.valueOf(remainUser))+ELEMENT_NOTIFICATION_MANY_LIKE)
							.replace("${activity}", activity));
			}
		}
		return elem;
	}

	/**
	 * check readed notification when users like
	 * @param userName
	 * @param activity
	 * @param time
	 * @return
	 */
	public WebElement checkReadLikeNotification(String userNames, String activity, String time){
		info("Check Like Notification");		
		Utils.pause(1000);
		String[] userName=userNames.split(",");
		WebElement elem = null;
		info("Verify that last user's avatar is shown in list");
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_AVATAR.
				replace("$lastUser",userName[0]));
		if(userName.length==1){
			info("One user likes activity");
			if(time!=null && time!="")
				elem=waitForAndGetElement(
						ELEMENT_READ_LOCATOR+ELEMENT_LIKE_NOTIFICATION_HAS_TIME_USER_INDEX.replace("${message}", ELEMENT_NOTIFICATION_LIKE)
						.replace("${index}", "1").replace("${name}", userName[0].trim())
						.replace("${activity}", activity)
						.replace("${time}", time));
			else
				elem=waitForAndGetElement(
						ELEMENT_READ_LOCATOR+ELEMENT_LIKE_NOTIFICATION_NO_TIME_USER_INDEX.replace("${message}", ELEMENT_NOTIFICATION_LIKE)
						.replace("${index}", "1").replace("${name}", userName[0].trim())
						.replace("${activity}", activity));
		}
		else{
			for(int i = 0; i<2; i++){
				info("Many users like activity");
				if(time!=null && time!="")
					elem=waitForAndGetElement(
							ELEMENT_READ_LOCATOR+ELEMENT_LIKE_NOTIFICATION_HAS_TIME_USER_INDEX.replace("${message}", ELEMENT_NOTIFICATION_MANY_LIKE)
							.replace("${index}", String.valueOf(i+1)).replace("${name}", userName[i].trim())
							.replace("${activity}", activity)
							.replace("${time}", time));
				else
					elem=waitForAndGetElement(
							ELEMENT_READ_LOCATOR+ELEMENT_LIKE_NOTIFICATION_NO_TIME_USER_INDEX.replace("${message}", ELEMENT_NOTIFICATION_MANY_LIKE)
							.replace("${index}", String.valueOf(i+1)).replace("${name}", userName[i].trim())
							.replace("${activity}", activity));

			}
		}
		return elem;
	}
	/**
	 * function: check notification when there is a connection request
	 * @param fullName user sent connection request
	 *//*
	public void checkConnectionRequestNotification(String fullName){
		info("Check Connection Request Notification");
		Utils.pause(1000);
		info("wait for notification");
		driver.findElement(By.xpath(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName)));
		Utils.pause(1000);
		info("wait for accept button");
		driver.findElement(By.xpath(ELEMENT_CONNECT_ACCEPT_BUTTON.replace("${fullName}", fullName)));
		Utils.pause(1000);
		info("wait for refuse button");
		driver.findElement(By.xpath(ELEMENT_CONNECT_REFUSE_BUTTON.replace("${fullName}", fullName)));	
	}*/

	/**
	 * function: check notification when there is a space invitation
	 * @param space 
	 */
	public void checkSpaceInvitationNotification(String space){
		info("Check Intranet Notification after recieve a space invitation");
		Utils.pause(1000);
		info("wait for notification");
		waitForAndGetElement(ELEMENT_SPACE_INVITATION.replace("${space}", space));
		assert waitForAndGetElement(ELEMENT_STATUS_CLASS).getText().contains(ELEMENT_MSG_SPACE_INVITATION);
		info("wait for accept button");
		waitForAndGetElement(ELEMENT_SPACE_INVITATION_ACCEPT_BTN.replace("${space}", space));
		info("wait for refuse button");
		waitForAndGetElement(ELEMENT_SPACE_INVITATION_REFUSE_BTN.replace("${space}", space));
		info ("Notification was checked");
	}

	/**
	 * function: check notification when there is a request to join space
	 * @param userName 
	 * @param space 
	 * @param time 
	 */
	public void checkRequestToJoinSpaceNotification(String userName, String space, String time){
		info("Check notification after recive a request to join a space");
		Utils.pause(1000);
		info("wait for notification");
		if (waitForAndGetElement(ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW.replace("${userName}", userName).replace("${space}", space), 5000, 0) == null)
			waitForAndGetElement(ELEMENT_REQUEST_JOIN_SPACE_ONE_MINUTE.replace("${userName}", userName).replace("${space}", space).replace("${time}", time));
		info("wait for accept button");
		waitForAndGetElement(ELEMENT_REQUEST_TO_JOIN_ACCEPT_BTN.replace("${userName}", userName).replace("${space}", space));
		info("wait for refuse button");
		waitForAndGetElement(ELEMENT_REQUEST_TO_JOIN_REFUSE_BTN.replace("${userName}", userName).replace("${space}", space));
	}

	/**
	 * function: check unread notification when another people mentions you in activity
	 * @param userName1
	 * @param activity
	 * @param time
	 * @return
	 */
	public WebElement checkUnreadMentionNotification(String userName1, String activity, String time){
		info("Check mention notification");
		WebElement elem;
		info("Verify that last user's avatar is shown in list");
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_AVATAR.
				replace("$lastUser",userName1));
		if(activity!="" && activity!=null){
			if(time!="" && time!=null){
				info("Verify with user, time and activity");
				elem=waitForAndGetElement(
						ELEMENT_UNREAD_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1)
						.replace("${activity}", activity)
						.replace("${time}", time));
			}
			else{
				info("Verify with user and activity");
				elem=waitForAndGetElement(
						ELEMENT_UNREAD_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1)
						.replace("${activity}", activity));
			}
		}
		else{
			if(time!="" && time!=null){
				info("Verify with user, time");
				elem=waitForAndGetElement(
						ELEMENT_UNREAD_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1)
						.replace("${time}", time));
			}
			else{
				info("Verify with user");
				elem=waitForAndGetElement(
						ELEMENT_UNREAD_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1));
			}
		}
		return elem;

	}

	/**
	 * function: check read notification when another people mentions you in activity
	 * @param userName1
	 * @param activity
	 * @param time
	 * @return
	 */
	public WebElement checReadMentionNotification(String userName1, String activity, String time){
		info("Check mention notification");
		WebElement elem;
		if(activity!="" && activity!=null){
			if(time!="" && time!=null){
				info("Verify with user, time and activity");
				elem=waitForAndGetElement(
						ELEMENT_READ_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1)
						.replace("${activity}", activity)
						.replace("${time}", time));
			}
			else{
				info("Verify with user and activity");
				elem=waitForAndGetElement(
						ELEMENT_READ_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1)
						.replace("${activity}", activity));
			}
		}
		else{
			if(time!="" && time!=null){
				info("Verify with user, time");
				elem=waitForAndGetElement(
						ELEMENT_READ_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1)
						.replace("${time}", time));
			}
			else{
				info("Verify with user");
				elem=waitForAndGetElement(
						ELEMENT_READ_LOCATOR+ELEMENT_MENTION_HAS_TIME_HAS_ACTIVTY
						.replace("${message}", ELEMENT_NOTIFICATION_MENTION)
						.replace("${index}", "1").replace("${name}", userName1));
			}
		}
		return elem;

	}

	/**
	 * function: check notification when another people has joined intranet
	 * @param userName1 the people has joined the intranet
	 * @param time 
	 */
	public void checkNewUserNotification(String userName1, String time){
		info("Check user notification");
		Utils.pause(1000);
		if(waitForAndGetElement(ELEMENT_NEW_USER_NOTIFICATION_JUST_NOW.replace("${userName}", userName1), 5000, 0) == null)
			waitForAndGetElement(ELEMENT_NEW_USER_NOTIFICATION_ONE_MINUTE.replace("${userName}", userName1).replace("${time}", time));

	}

	/**
	 * function: check notification when another people post activity in intranet
	 * @param userName the people posted activity in intranet
	 * @param activity 
	 * @param time 
	 */
	public void checkPostActivityNotification(String userName, String activity, String time, boolean...params){
		info("Check Intranet notification after post activity in another user's activity stream");
		boolean noTime = params.length > 0 ? params[0] : false;
		if (noTime)
			waitForAndGetElement(ELEMENT_POST_ACTIVITY_NO_TIME.replace("${userName}", userName).replace("${activity}", activity));
		if(waitForAndGetElement(ELEMENT_POST_ACTIVITY_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity), 5000, 0) == null)
			waitForAndGetElement(ELEMENT_POST_ACTIVITY_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));
	}

	/**
	 * function: check notification when another people post activity in space
	 * @param userName the people posted activity in space
	 * @param space 
	 * @param activity 
	 * @param time 
	 */
	public void checkPostActivityInSpaceNotification(String userName, String space, String activity, String time){
		info ("Check intranet notification after add activity in Space activity stream");
		if (waitForAndGetElement(ELEMENT_POST_ACTIVITY_SPACE_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity).replace("${space}", space)) == null)
			waitForAndGetElement(ELEMENT_POST_ACTIVITY_SPACE_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${space}", space).replace("${time}", time));
		info("Notification was correct");
	}

	/**
	 * function: Go to user profile from connection request intranet notification
	 * @param fullName 
	 * @param userName 
	 * @param accept (true if you accept the connection request)
	 * @param time 
	 */
	public void goToUserProfileFromIntranetNotificationWithConnection(String fullName, String userName, boolean accept, String time){
		info("Go to User profile from Intranet Notification");
		navTool = new NavigationToolbar(driver);
		hp = new HomePagePlatform(driver);
		connMag = new ConnectionsManagement(driver);
		myProf = new UserProfilePage(driver);
		info("Click on notification");
		waitForAndGetElement(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName));
		click(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName));
		info("Verify that user was redidected to user profile");
		waitForAndGetElement(myProf.ELEMENT_NAME_OF_PROFILE_TOP_LEFT.replace("${name}", fullName));
		if (accept){
			info("click accept button in notification");
			navTool.goToIntranetNotification();
			waitForAndGetElement(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName));
			click(ELEMENT_CONNECT_ACCEPT_BUTTON.replace("${fullName}", fullName));
			info("verify new notification after click accept button");
			if(waitForAndGetElement(ELEMENT_CONNECTED_SUCCESS_JUST_NOW.replace("${fullName}", fullName), 5000, 0) == null)
				waitForAndGetElement(ELEMENT_CONNECTED_SUCCESS_ONE_MINUTE.replace("${fullName}", fullName).replace("${time}", time));
			info ("Verify that 2 users are connected");
			hp.goToConnections();
			connMag.verifyConnection(userName, true);
		}
		else{
			info("Check notification in view all before click refuse");
			navTool.goToIntranetNotification();
			waitForAndGetElement(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName));
			goToAllNotification();
			waitForAndGetElement(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName));
			info("click refuse button");
			navTool.goToIntranetNotification();
			click(ELEMENT_CONNECT_REFUSE_BUTTON.replace("${fullName}", fullName));
			info("verify that notification was hidden in notification list");
			waitForElementNotPresent(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName));
			info("verify that notification was hidden in view all");
			goToAllNotification();
			waitForElementNotPresent(ELEMENT_CONNECT_NOTIFICATION.replace("${fullName}", fullName));
			info("Verify that 2 users are not connected");
			hp.goToConnections();
			connMag.verifyConnection(userName, false);
		}
	}

	/**
	 * function: Go to user profile from new user intranet notification
	 * @param userName1 
	 * @param time 
	 */
	public void goToUserProfileFromIntranetNotificationWithNewUserJoined(String userName1, String time, boolean...params){
		info("Go to User profile from Intranet Notification after new User has joined Intrane");
		myProf = new UserProfilePage(driver);
		boolean noTime = params.length > 0 ? params[0] : false;
		Utils.pause(1000);
		if (noTime){
			info("click on new notification");
			click(ELEMENT_NEW_USER_NOTIFICATION_NO_TIME.replace("${userName}", userName1));
			info("Verify that user was redidected to user profile");
			waitForAndGetElement(myProf.ELEMENT_NAME_OF_PROFILE_TOP_LEFT.replace("${name}", userName1));
		}
		else if(waitForAndGetElement(ELEMENT_NEW_USER_NOTIFICATION_JUST_NOW.replace("${userName}", userName1)) != null){
			info("click on new notification");
			click(ELEMENT_NEW_USER_NOTIFICATION_JUST_NOW.replace("${userName}", userName1));
			info("Verify that user was redidected to user profile");
			waitForAndGetElement(myProf.ELEMENT_NAME_OF_PROFILE_TOP_LEFT.replace("${name}", userName1));
		}
		else if	(waitForAndGetElement(ELEMENT_NEW_USER_NOTIFICATION_ONE_MINUTE.replace("${userName}", userName1).replace("${time}", time)) != null){
			info("click on new notification");
			click(ELEMENT_NEW_USER_NOTIFICATION_ONE_MINUTE.replace("${userName}", userName1).replace("${time}", time));
			info("Verify that user was redidected to user profile");
			waitForAndGetElement(myProf.ELEMENT_NAME_OF_PROFILE_TOP_LEFT.replace("${name}", userName1));
		}
	}

	/**
	 * function: Go to home page of space from intranet notification after another one invite you
	 * @param space 
	 * @param time 
	 * @param accept (true if you accept the request)
	 */
	public void goToHomepageOfSpaceFromIntranetNotification(String space, boolean accept, String time){
		info("Go to Homepage of Space from Intranet Notification after invited");
		navTool = new NavigationToolbar(driver);
		hp = new HomePagePlatform(driver);
		myProf = new UserProfilePage(driver);
		spaceManage = new SpaceManagement(driver);
		info("Click on notification in notification list");
		waitForAndGetElement(ELEMENT_SPACE_INVITATION.replace("${space}", space));
		click(ELEMENT_SPACE_INVITATION.replace("${space}", space));
		info("Verify user is not redirected to home page of space");
		waitForTextPresent(ELEMENT_MSG_SPACE_INVITATION_CLICK_ON_NOTIFICATION.replace("${space}", space));
		waitForAndGetElement(ELEMENT_SPACE_INVITATION_CLICK_ON_NOTIFICATION_ACCEPT_BTN);
		waitForAndGetElement(ELEMENT_SPACE_INVITATION_CLICK_ON_NOTIFICATION_REFUSE_BTN);
		if (accept){
			info("check view all before click accept button");
			navTool.goToIntranetNotification();
			goToAllNotification();
			waitForAndGetElement(ELEMENT_SPACE_INVITATION.replace("${space}", space));
			info("Click accept button in notification");
			navTool.goToIntranetNotification();
			click(ELEMENT_SPACE_INVITATION_ACCEPT_BTN.replace("${space}", space));
			info("Verify notification was changed to new notification when accept successfully");
			if(waitForAndGetElement(ELEMENT_SPACE_INVITATION_SUUCESS_JUST_NOW.replace("${space}", space)) != null){
				info("click on new notification");
				click(ELEMENT_SPACE_INVITATION_SUUCESS_JUST_NOW.replace("${space}", space));
				info("Verify that user is redidected to user profile");
				waitForAndGetElement(myProf.ELEMENT_NAME_OF_PROFILE_TOP_LEFT.replace("${name}", space));
			}
			else if(waitForAndGetElement(ELEMENT_SPACE_INVITATION_SUUCESS_ONE_MINUTE.replace("${space}", space).replace("${time}", time)) != null){
				info("click on new notification");
				click(ELEMENT_SPACE_INVITATION_SUUCESS_ONE_MINUTE.replace("${space}", space));
				info("Verify that user is redidected to user profile");
				waitForAndGetElement(myProf.ELEMENT_NAME_OF_PROFILE_TOP_LEFT.replace("${name}", space));
			}
			info("Verify that user was member of space");
			hp.goToMySpaces();
			spaceManage.searchSpace(space, "");
		}
		else{
			info("check view all before refuse");
			navTool.goToIntranetNotification();
			waitForAndGetElement(ELEMENT_SPACE_INVITATION.replace("${space}", space));
			goToAllNotification();
			waitForAndGetElement(ELEMENT_SPACE_INVITATION.replace("${space}", space));
			info("click refuse button");
			navTool.goToIntranetNotification();
			click(ELEMENT_SPACE_INVITATION_REFUSE_BTN.replace("${space}", space));
			waitForElementNotPresent(ELEMENT_SPACE_INVITATION.replace("${space}", space));
			info("Check view all after click refuse");
			goToAllNotification();
			waitForElementNotPresent(ELEMENT_SPACE_INVITATION.replace("${space}", space));
			info("Verify that user was not memeber of space");
			hp.goToMySpaces();
			waitForElementNotPresent(spaceManage.ELEMENT_MY_SPACE_SEARCH_RESULT.replace("${name}", space));
		}	
	}

	/**
	 * function: Go to home page of space from intranet notification after you request to join a space
	 * @param space 
	 * @param time 
	 * @param accept (true if you accept the request)
	 * @param userName 
	 * @param password 
	 */
	public void goToHomepageOfSpaceFromIntranetNotificationWithRequest(String space, boolean accept, String time, String userName, String password){
		info("Go to Homepage of Space from Intranet Notification after requested");
		navTool = new NavigationToolbar(driver);
		hp = new HomePagePlatform(driver);
		myProf = new UserProfilePage(driver);
		spaceManage = new SpaceManagement(driver);
		magAc = new ManageLogInOut(driver);
		info("Click on notification in notification list");
		waitForAndGetElement(ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW.replace("${userName}", userName).replace("${space}", space));
		click(ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW.replace("${userName}", userName).replace("${space}", space));
		info("Verify user is redirected to home page of space");
		waitForAndGetElement(myProf.ELEMENT_NAME_OF_PROFILE_TOP_LEFT.replace("${name}", space));
		if (accept){
			info("click accept button in notification");
			navTool.goToIntranetNotification();
			click(ELEMENT_REQUEST_TO_JOIN_ACCEPT_BTN.replace("${userName}", userName).replace("${space}", space));
			info("Verify notification was changed to new notification when accept successfully");
			if(waitForAndGetElement(ELEMENT_REQUEST_TO_JOIN_SPACE_SUCCESS_JUST_NOW.replace("${userName}", userName).replace("${space}", space), 5000, 0) == null)
				waitForAndGetElement(ELEMENT_REQUEST_TO_JOIN_SPACE_SUCCESS_ONE_MINUTE.replace("${userName}", userName).replace("${space}", space).replace("${time}", time));
			info("Verify that user was member of space after accept");
			magAc.signIn(userName, password);
			hp.goToMySpaces();
			spaceManage.searchSpace(space, "");
		}
		else{
			navTool.goToIntranetNotification();
			waitForAndGetElement(ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW.replace("${userName}", userName).replace("${space}", space));
			info("Check notification in all view before refuse");
			goToAllNotification();
			waitForAndGetElement(ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW.replace("${userName}", userName).replace("${space}", space));
			info ("click refuse button in notification");
			navTool.goToIntranetNotification();
			click(ELEMENT_REQUEST_TO_JOIN_REFUSE_BTN.replace("${userName}", userName).replace("${space}", space));
			info("Notification was hidden in notification list");
			waitForElementNotPresent(ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW.replace("${userName}", userName).replace("${space}", space));
			info("Notification was hidden in view all");
			goToAllNotification();
			waitForElementNotPresent(ELEMENT_REQUEST_JOIN_SPACE_JUST_NOW.replace("${userName}", userName).replace("${space}", space));
			info ("Verify user is not space member after click refuse");
			magAc.signIn(userName, password);
			hp.goToMySpaces();
			waitForElementNotPresent(spaceManage.ELEMENT_MY_SPACE_SEARCH_RESULT.replace("${name}", space));
		}	
	}

	/**
	 * function: Go to activity viewer from notification list
	 * @param userName 
	 * @param time 
	 * @param activity 
	 * @param space 
	 * @param twoUser 
	 * @param userName2 
	 * @param params 
	 */
	public void gotoActivityViewer(String userName, String activity, String time, String space, boolean twoUser, String userName2, boolean ...params){
		info("Go to activity viewer");
		boolean commentNotification = params.length > 0 ? params[0] : false;
		boolean mentionNotification = params.length > 1 ? params[1] : false;
		boolean activityPostNotification = params.length > 2 ? params[2] : false;
		boolean activityPostSpaceNotification = params.length > 3 ? params[3] : false;
		boolean likeNotification = params.length > 4 ? params[4] : false;
		boolean likeNotificationMoreThan2Users = params.length > 5 ? params[5] : false;
		boolean manyUserComments = params.length > 6 ? params[6] : false;
		boolean noTime = params.length > 7 ? params[7] : false;
		if (twoUser){
			if (waitForAndGetElement(ELEMENT_COMMENT_2_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity)) != null)
				click(ELEMENT_COMMENT_2_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity));					
			else if (waitForAndGetElement(ELEMENT_COMMENT_2_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time)) != null)	
				click(ELEMENT_COMMENT_2_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));	
		}
		else{
			if (commentNotification) {
				info("go To Activity viewer from comment notification");
				if (noTime)
					click(ELEMENT_COMMENT_NO_TIME.replace("${userName}", userName).replace("${activity}", activity));
				else if (waitForAndGetElement(ELEMENT_COMMENT_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity)) != null)
					click(ELEMENT_COMMENT_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity));	
				else if (waitForAndGetElement(ELEMENT_COMMENT_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time)) != null)
					click(ELEMENT_COMMENT_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));		
			}
			if (mentionNotification) {
				info("go To Activity viewer from mention notification");
				checkUnreadMentionNotification(userName, activity, time);
			}
			if (activityPostNotification){
				info("go To Activity viewer from intranet activity post notification");
				if (noTime)
					click(ELEMENT_POST_ACTIVITY_NO_TIME.replace("${userName}", userName).replace("${activity}", activity));
				else if(waitForAndGetElement(ELEMENT_POST_ACTIVITY_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity)) != null)
					click(ELEMENT_POST_ACTIVITY_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity));
				else if(waitForAndGetElement(ELEMENT_POST_ACTIVITY_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time)) != null)
					click(ELEMENT_POST_ACTIVITY_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));
			}
			if (activityPostSpaceNotification){
				info("go To Activity viewer from space activity post notification");
				if (noTime)
					click(ELEMENT_POST_ACTIVITY_SPACE_NO_TIME.replace("${userName}", userName).replace("${activity}", activity).replace("${space}", space));
				else if (waitForAndGetElement(ELEMENT_POST_ACTIVITY_SPACE_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity).replace("${space}", space)) != null)
					click(ELEMENT_POST_ACTIVITY_SPACE_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity).replace("${space}", space));
				else if (waitForAndGetElement(ELEMENT_POST_ACTIVITY_SPACE_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${space}", space).replace("${time}", time)) != null)
					click(ELEMENT_POST_ACTIVITY_SPACE_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${space}", space).replace("${time}", time));
			}
			if (likeNotification){
				info("go To Activity viewer from like notification");
				if (noTime)
					click(ELEMENT_LIKE_NOTIFICATION_NO_TIME.replace("${userName}", userName).replace("${activity}", activity));
				else if (waitForAndGetElement(ELEMENT_LIKE_NOTIFICATION_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity)) != null)
					click(ELEMENT_LIKE_NOTIFICATION_JUST_NOW.replace("${userName}", userName).replace("${activity}", activity));
				else if (waitForAndGetElement(ELEMENT_LIKE_NOTIFICATION_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time)) != null)
					click(ELEMENT_LIKE_NOTIFICATION_ONE_MINUTE.replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));
			}
			if (likeNotificationMoreThan2Users){
				info("go To Activity viewer from like notification when 2 or more  than 2 users like");
				if (waitForAndGetElement(ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity)) != null)
					click(ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity));
				else if (waitForAndGetElement(ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time)) != null)
					click(ELEMENT_LIKE_NOTIFICATION_MORE_THAN_2_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));
			}
			if (manyUserComments){
				info("go To Activity viewer from comment notification when many users comment");
				if (waitForAndGetElement(ELEMENT_COMMENT_3_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity)) != null)
					click(ELEMENT_COMMENT_3_USERS_JUST_NOW.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity));
				else if (waitForAndGetElement(ELEMENT_COMMENT_3_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time)) != null)
					click(ELEMENT_COMMENT_3_USERS_ONE_MINUTE.replace("${userName2}", userName2).replace("${userName}", userName).replace("${activity}", activity).replace("${time}", time));
			}
		}
	}

	/**
	 * function: check comment in activity viewer
	 * @param userName 
	 * @param comment 
	 * @param highlighted (true if you need to check the comment is highlighted)
	 */
	public void checkCommentInActivityViewer(String comment, String userName, boolean highlighted){
		info("Check comment in activity viewer");
		Utils.pause(1000);
		if (highlighted){
			info ("Check comment in Activity viewer to make sure it's highlighted");
			waitForAndGetElement(ELEMENT_COMMENT_HIGHLIGHTED.replace("${comment}", comment));
		}
		else{
			info("Check to make sure all comments are shown in activity viewer");
			waitForAndGetElement(ELEMENT_COMMENT_ACTIVITY_VIEWER.replace("${comment}", comment).replace("${userName}", userName));
		}
	}

	/**
	 * function: check like in activity viewer
	 * @param number number of like
	 */
	public void checkLikeInActivityViewer(String number){
		info ("Check like in Activity viewer");
		Utils.pause(1000);
		assert(waitForAndGetElement(ELEMENT_LIKE_IN_ACTIVITY_VIEWER).getText().contains(number));
	}

	/**
	 * function: check mention in activity viewer
	 * @param Activity the activity you are mentioned
	 */
	public void checkMentionInActivityViewer(String Activity){
		info("Check Mention notification in Activity Viewr");
		Utils.pause(1000);
		waitForTextPresent(Activity);
	}

	/**
	 * function: go to all notification
	 */
	public void goToAllNotification(){
		info("Go to all notification");
		if(waitForAndGetElement(ELEMENT_VIEW_ALL,3000,0)!=null){
			click(ELEMENT_VIEW_ALL);
		}else{
			driver.get(baseUrl+"/intranet/allNotifications/");
		}
		waitForAndGetElement(ELEMENT_ALL_NOTIFICATIONS);
	}

	/**
	 * function: enable option new user notification
	 */
	public void enableOptionNewUserNotification(){
		info("Click on Edit button");
		click(ELEMENT_EDIT_NEWUSER_ICON);
		check(ELEMENT_EDIT_NEWUSER_WEB_CHECKBOX,2);
		info("Click on Save button");
		click(ELEMENT_EDIT_NEWUSER_SAVE_BTN);
		info("Verify that intranet notification is hidded");
		waitForAndGetElement(ELEMENT_EDIT_NEWUSER_WEB_ICON,3000,1);
	}

	/**
	 * function: enable option new user notification
	 */
	public void enableOptionLikeNotification(){
		click(ELEMENT_EDIT_LIKE_ICON);
		check(ELEMENT_EDIT_LIKE_WEB_CHECKBOX,2);
		info("Click on Save button");
		click(ELEMENT_EDIT_LIKE_SAVE_BTN);
		info("Verify that email notification is hidded");
		waitForAndGetElement(ELEMENT_EDIT_LIKE_WEB_ICON,3000,1);
	}

	/**
	 * function: go to notifications settings
	 */
	public void goToNotificationSettings(){
		info("go to notification settings");
		Utils.pause(1000);
		click(ELEMENT_NOTIFICATION_SETTINGS_LINK);
		waitForAndGetElement(ELEMENT_NOTIFICATION_SETTINGS_TITLE);
	}	
	/**
	 * Check notification's comment type in notification list popup
	 * @param users
	 * @param comment
	 * @param actTitle
	 */
	public void checkCommentActivityNotificationFormat(ArrayList<String> users,String comment,String actTitle){
		int lastIndex=users.size()-1;
		info("users.size():"+users.size());
		info("Verify that last user's avatar is shown in list");
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_AVATAR.
				replace("$lastUser",users.get(lastIndex)));

		info("Verify that last user is shown in list");
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_USER.replace("$user",users.get(lastIndex)));
		info("users.size():"+users.size());
		if(users.size()>0){
			info("Verify that second last user is shown in list");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_USER.replace("$user",users.get(lastIndex-1)),2000,2);
			if(users.size()>2){
				info("Verify the activity message for more 2 users comments");
				waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_COMMENTS_CONTENT.
						replace("$comment",comment).replace("$number",users.get(lastIndex-1)),2000,2);
			}
			else{
				info("Verify the activity message for 2 or 1 comment(s)");
				waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_COMMENTS_CONTENT.
						replace("$comment",comment),2000,2);
			}
		}

		if(!actTitle.isEmpty()){
			info("Verify the activity's title is shown in the list");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_TITLE.replace("$title",actTitle),2000,2);
		}

	}
	/**
	 * View detail of the activity when click on activity in notification list
	 * @param actTitle
	 *              is the activity's title
	 * @param comment
	 *              is of the comment of other user
	 */
	public void checkDetailActivityNotifications(String actTitle,ArrayList<String> comments,boolean isHighlight){
		if(waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_TITLE.replace("$title",actTitle),3000,0)!=null){
			info("Click on the activity title on the list");
			click(ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_TITLE.replace("$title",actTitle));

		}
		else {
			goToAllNotification();
			goToDetailFirstNotificationInAllpage();
		}

		if(comments.size()>0){
			for(int i=0;i<comments.size();i++){
				info("Verify that all comments are expanded");
				waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_COMMENT_CONTENT.
						replace("$comment",comments.get(i)));

				if(isHighlight){
					info("Verify that the last comment is highlighted");
					waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_COMMENT_HIGHLIGHT.
							replace("$comment",comments.get(comments.size()-1)));
				}
			}
		}
	}
	/**
	 * Open detail of first notification in All notification page
	 */
	public void goToDetailFirstNotificationInAllpage(){
		info("click on First notification in All notification page");
		click( ELEMENT_INTRANET_NOTIFICATION_PAGE_FIRST_NOTIFICATION);
		Utils.pause(2000);
	}
	/**
	 * Accept an connection request in notification list
	 * @param fullName
	 *                 is fullName of user that want to connect
	 */
	public void acceptRqConnection(String fullName){
		info("Click on Accept button");
		click(ELEMENT_CONNECT_ACCEPT_BUTTON.replace("$fullName",fullName));
		waitForElementNotPresent(ELEMENT_CONNECT_ACCEPT_BUTTON.replace("$fullName",fullName));
	}
	/**
	 * Refuse an connection request in notificaiton list
	 * @param fullName
	 */
	public void refuseRqConnection(String fullName){
		info("Click on Refuse button");
		click(ELEMENT_CONNECT_REFUSE_BUTTON.replace("$fullName",fullName));
		waitForElementNotPresent(ELEMENT_CONNECT_REFUSE_BUTTON.replace("$fullName",fullName));
	}

	/**
	 * Check format of Activity's comment in Notification list
	 * @param users
	 *            is array of users
	 * @param status
	 *            is as: has commented on your activity,...
	 * @param actTitle
	 *            is the title of the activity that is commented
	 * @param isPopUp
	 *             =true, if the notification list is shown in Notification list popup
	 *             =false, if the notification list is shown in All notification list
	 */
	public void checkFormatACNotification(ArrayList<String> users,String status,
			String actTitle,boolean isPopUp){
		info("users.size():"+users.size());
		checkAvatar(users,isPopUp);
		checkUsers(users,isPopUp);
		checkStatusAC(users,status,isPopUp);
		checkActivityTitle(actTitle,isPopUp);
	}

	/**
	 * Check Accept and Refuse buttons are shown in Notification popup and page
	 * @param fullName
	 */
	public void checkBtnConnectRequest(String fullName){
		info("Verify that Accept button are shown on the popup");
		waitForAndGetElement(ELEMENT_CONNECT_ACCEPT_BUTTON.replace("$fullName",fullName));
		info("Verify that Refuse button are shown on the popup");
		waitForAndGetElement(ELEMENT_CONNECT_REFUSE_BUTTON.replace("$fullName",fullName));
	}
	
	/**
	 * Check avatar of notification list
	 * @param users
	 *             is array of users
	 * @param isPopUp
	 *             =true, if the notification list is shown in Notification list popup
	 *             =false, if the notification list is shown in All notification list
	 */
	public void checkAvatar(ArrayList<String> users, boolean isPopUp){
		int lastIndex=users.size()-1;
		info("users.size():"+users.size());
		info("Verify that last user's avatar is shown in list");
		if(isPopUp)
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_AVATAR.
					replace("$lastUser",users.get(lastIndex)),2000,2);
		else
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ALL_AVATAR.
					replace("$lastUser",users.get(lastIndex)),2000,2);
	}

	/**
	 * Check users that are shown their names in notification list
	 * @param users
	 *             is array of users
	 * @param isPopUp
	 *             =true, if the notification list is shown in Notification list popup
	 *             =false, if the notification list is shown in All notification list
	 */
	public void checkUsers(ArrayList<String> users, boolean isPopUp){
		int lastIndex=users.size()-1;
		info("users.size:"+users.size());
		if(isPopUp){
			info("Verify that last user is shown in the popup");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_USER.
					replace("$user",users.get(lastIndex)),2000,2);
		}else{
			info("Verify that last user is shown in the page");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ALL_USER.
					replace("$user",users.get(lastIndex)),2000,2);
		}

		if(users.size()>2 && isPopUp==true){
			info("Verify that second last user is shown in the popup");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_USER.
					replace("$user",users.get(lastIndex-1)),2000,2);
		}

		if(users.size()>2 && isPopUp==false){
			info("Verify that second last user is shown in the page");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ALL_USER.
					replace("$user",users.get(lastIndex-1)),2000,2);
		}
	}
	/**
	 * Check status of Activity Comment in notification list
	 * @param users
	 *              is array of users
	 * @param status
	 *              is activity's status as: has commented on your activity,...
	 * @param isPopUp
	 *              =true if want to check on notification list popup
	 *              =false if want to check on notification list page
	 */
	public void checkStatusAC(ArrayList<String> users,String status,boolean isPopUp){
		int lastIndex=users.size()-1;
		if(users.size()>3 && isPopUp==true){
			info("Verify the activity message for more "+(lastIndex-2)+" users comments");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_COMMENTS_CONTENT.
					replace("$comment",status).replace("$number",users.get(lastIndex-1)),2000,2);
		}

		if(users.size()>3 && isPopUp==false){
			info("Verify the activity message for more "+(lastIndex-2)+" users comments");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ALL_COMMENTS_CONTENT.
					replace("$comment",status).replace("$number",users.get(lastIndex-1)),2000,2);
		}

		if(users.size()<3 && isPopUp==true){
			info("Verify the activity message for 2 or 1 comment(s)");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_COMMENTS_CONTENT.
					replace("$comment",status),2000,2);
		}

		if(users.size()<3 && isPopUp==false){
			info("Verify the activity message for 2 or 1 comment(s)");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ALL_COMMENTS_CONTENT.
					replace("$comment",status),2000,2);
		}
	}
	/**
	 * Check Activity's title is shown in notification list
	 * @param actTitle
	 *  @param isPopUp
	 *              =true if want to check on notification list popup
	 *              =false if want to check on notification list page
	 */
	public void checkActivityTitle(String actTitle,boolean isPopUp){
		if(!actTitle.isEmpty() && isPopUp==true){
			info("Verify the activity's title is shown in the popup");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ACTIVITY_TITLE.
					replace("$title",actTitle),2000,2);
		}else{
			info("Verify the activity's title is shown in the page");
			waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_ALL_ACTIVITY_TITLE.
					replace("$title",actTitle),2000,2);
		}
	}

	/**
	 * Go to detail a notification on Notification popup
	 */
	public void goToDetailNotificationOnPopup(){
		info("Click on Status area of Notification popup");
		click(ELEMENT_INTRANET_NOTIFICATION_POPUP_STATUS);
		Utils.pause(3000);
	}
   /* *//**
     * Define types of Notification status
     *
     *//*
	public enum statusType{
		send_connection,accept_connection,refuse_connection,like;
	}*/
	/**
	 * Check status of Notifications
	 * @param status
	 *             is a status's content of Notifications
	 * @param user
	 *             is full name or name of the user
	 */
	public void checkStatus(String status,String user){
	info("Verify that the status is shown");
	waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_STATUS.
			replace("$status",status).replace("$fullName",user));
		
	}
	/**
	 * Check not available notification in notifcation list
	 * @param status
	 *               is a status's content of Notifications
	 * @param user
	 *               is full name or name of the user
	 */
	public void checkNotPresentStatus(String status,String user){
		info("Verify that the status is not shown");
		waitForElementNotPresent(ELEMENT_INTRANET_NOTIFICATION_STATUS.
				replace("$status",status).replace("$fullName",user));
	}
	/**
	 * View detail of a notification by index
	 * @param num
	 *            is a notification's index
	 */
	public void goToDetailANotificaitonByIndex(int num){
		info("Click on the notificaiton has index as:"+num);
		click(ELEMENT_INTRANET_NOTIFICATION_ORDER_NOTIFICATION.replace("$num",String.valueOf(num)));
		Utils.pause(3000);
	}
	
	/**
	 * Check order of Notifications in the list
	 * @param num
	 *           is order's number in the list
	 * @param status
	 *           is the status of Notification
	 * @param fullName 
	 *           is the full name of the user that send the notification
	 */
	public void checkOrderNotifications(int num,String status,String fullName){
		info("Check on the notificaiton has index as:"+num);
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_STATUS_ORDER.replace("$num",String.valueOf(num)).
				replace("$status",status).
				replace("$fullName",fullName));
		Utils.pause(3000);
	}
	/**
	 * Check unread notification
	 * @param status
	 *               is a status of the notification
	 * @param fullName
	 *               is a full name of the user that send the notification
	 */
	public void checkUnreadNotification(String status,String fullName){
		info("Check:"+status+" of the user:"+fullName);
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_UNREAD.
				replace("$status",status).replace("$fullName",fullName));
	}
	/**
	 * Check read notification
	 * @param status
	 *              is a status of the notification
	 * @param fullName
	 *              is a full name of the user that send the notification
	 */
	public void checkReadNotification(String status,String fullName){
		info("Check:"+status+" of the user:"+fullName);
		waitForElementNotPresent(ELEMENT_INTRANET_NOTIFICATION_UNREAD.
				replace("$status",status).replace("$fullName",fullName));
	}
	/**
	 * Mark all as Read Notifications
	 */
	public void markAllAsRead(){
		info("Click on Mark all as Read link");
		click(ELEMENT_INTRANET_NOTIFICATION_MARK_ALL_AS_READ);
		Utils.pause(2000);
	}
	/**
	 * Remove an notification by index
	 * @param num
	 *            is order's number in notification list
	 */
	public void removeNotificationByIndex(int num){
		info("click on remove icon of the notification with an index:"+num);
		click(ELEMENT_INTRANET_NOTIFICATION_REMOVE_ICON.replace("$num",String.valueOf(num)));
		Utils.pause(3000);
	}
	/**
	 * Check the number of badge notification
	 * @param num
	 *             is the number that is shown
	 */
	public void checkBadgeNotifications(int num){
		info("Check number of badge notification");
		waitForAndGetElement(ELEMENT_INTRANET_NOTIFICATION_BADGE_NUMBER.
				replace("$num",String.valueOf(num)));
	}
}
