package org.exoplatform.selenium.platform.social;


import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNotificationsPage extends PlatformBase{

	
	
	public final By ELEMENT_GENERAL_JOIN_INTRANET_GRID = By.xpath("//*[@id='uiNotificationSetting']//*[contains(text(),'Someone joins the social intranet')]");
	public final By ELEMENT_GENERAL_SEND_CONNECTION_GRID = By.xpath("//*[@id='uiNotificationSetting']//*[contains(text(),'Someone sends me a connection request')]");  
	
	
	//Someones join the social intranet
	public final By ELEMENT_NEWUSER_ICON_EMAIL_NOTIFICATION=By.xpath(".//*[contains(@for,'NewUserPlugin')]/../..//*[contains(@class,'uiIconPLFMail')]");
	public final By ELEMENT_NEWUSER_ICON_INTRANET_NOTIFICATION=By.xpath(".//*[contains(@for,'NewUserPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");
	
	//Connection request
	public final By ELEMENT_CONNECTION_REQUEST_ICON_EMAIL_NOTIFICATION=By.xpath(".//*[contains(@for,'RelationshipReceivedRequestPlugin')]/../..//*[contains(@class,'uiIconPLFMail')]");
	public final By ELEMENT_CONNECTION_REQUEST_ICON_INTRANET_NOTIFICATION=By.xpath(".//*[contains(@for,'RelationshipReceivedRequestPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");
	
	//Space invitation
	public final By ELEMENT_SPACE_INVITATION_EMAIL_NOTIFICATION_ICON = By.xpath(".//*[contains(@for,'SpaceInvitationPlugin')]/../..//*[contains(@class,'uiIconPLFMail')]");
	public final By ELEMENT_SPACE_INVITATION_INTRANET_NOTIFICATION_ICON = By.xpath(".//*[contains(@for,'SpaceInvitationPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");
	//Activity comment
	public final By ELEMENT_ACTIVITY_COMMENT_ICON_INTRANET_NOTIFICATION = By.xpath(".//*[contains(@for,'ActivityCommentPlugin')]/../..//*[contains(@class,'uiIconPLFWeb')]");
	/**
	 * constructor
	 * @param dr
	 */
	public MyNotificationsPage(WebDriver dr){
		this.driver=dr;

	}
}
