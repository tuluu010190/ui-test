package org.exoplatform.selenium.platform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfile extends PlatformBase {


	public UserProfile(WebDriver dr){
		driver = dr;
	}
	
	
	public final String ELEMENT_NAME_OF_USER_TOP_LEFT = "//*[@id='UIBreadCrumbsNavigationPortlet']//*[contains(text(),'{$name}')]";
	public final By ELEMENT_HORIZONTAL_TOOLBAR = By.xpath("//*[@id='UIUserNavigationPortlet']/ul");
	
	// toolbar application in order
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIRST_APP_PROFILE = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[1]//*[@class='uiIconAppprofile uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_SECOND_APP_ACTIVITIES = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[2]//*[@class='uiIconAppactivities uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_THIRD_APP_CONNECTIONS = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[3]//*[@class='uiIconAppconnections uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FORTH_APP_WIKI = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[4]//*[@class='uiIconAppwiki uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIFTH_APP_DASHBOARD = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[5]//*[@class='uiIconAppdashboard uiIconDefaultApp']");
}
