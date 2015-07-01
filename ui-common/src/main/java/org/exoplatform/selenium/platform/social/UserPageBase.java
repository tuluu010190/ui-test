package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPageBase extends PlatformBase {
	
	//Navigation menu
	public final By ELEMENT_HORIZONTAL_TOOLBAR = By.xpath("//*[@id='UIUserNavigationPortlet']/ul");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIRST_APP_PROFILE = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[1]//*[@class='uiIconAppprofile uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_SECOND_APP_ACTIVITIES = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[2]//*[@class='uiIconAppactivities uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_THIRD_APP_CONNECTIONS = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[3]//*[@class='uiIconAppconnections uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FORTH_APP_WIKI = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[4]//*[@class='uiIconAppwiki uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIFTH_APP_DASHBOARD = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[5]//*[@class='uiIconAppdashboard uiIconDefaultApp']");

	/**
	 * constructor
	 * @param dr
	 */
	public UserPageBase(WebDriver dr){
		this.driver=dr;
	}
	
	
	/**
	 * Go to my wiki
	 */
	public void goToProfileTab(){
		info("Go to profile tab");
		click(ELEMENT_HORIZONTAL_TOOLBAR_FIRST_APP_PROFILE);
	}
	
	/**
	 * Go to my wiki
	 */
	public void goToWikiTab(){
		info("Go to my wiki");
		click(ELEMENT_HORIZONTAL_TOOLBAR_FORTH_APP_WIKI);
	}
	
	/**
	 * Go to my activity tab
	 */
	public void goToActivityTab(){
		info("Go to activity tab");
		click(ELEMENT_HORIZONTAL_TOOLBAR_SECOND_APP_ACTIVITIES);
	}
	
	/**
	 * Go to my activity tab
	 */
	public void goToConnectionTab(){
		info("Go to activity tab");
		click(ELEMENT_HORIZONTAL_TOOLBAR_THIRD_APP_CONNECTIONS);
	}
	
	/**
	 * Go to my activity tab
	 */
	public void goToDashboardTab(){
		info("Go to dashboard tab");
		click(ELEMENT_HORIZONTAL_TOOLBAR_FIFTH_APP_DASHBOARD);
	}
}
