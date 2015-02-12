package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.platform.PlatformBase;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingSpaceManagement extends PlatformBase{

	public By ELEMENT_SPACE_SPACE_SETTINGS_TITLE=By.xpath(".//*[text()='Space Configuration']");
	
	// Members tab
	public By ELEMENT_SPACE_SETTINGS_MEMBERS_TAB = By.xpath("//*[@id='UISpaceSetting']//a[contains(text(),'Members')]");
	public By ELEMENT_SPACE_MEMBERS_SELECT_USER = By.xpath("//*[@id='UISpaceMember']//*[@class='uiIconUser uiIconLightGray']");
	public String ELEMENT_SPACE_SELECT_USER_IN_FORM = "//*[@id='UIListUsers']//*[contains(text(),'{$name}')]/../..//*[@class='uiCheckbox']//input";
	public By ELEMENT_ADD = By.xpath("//*[@id='UIUserSelector']//*[contains(text(),'Add')]");
	public By ELEMENT_SPACE_MEMBERS_INVITE = By.xpath("//*[@id='UISpaceMember']//*[contains(text(),'Invite')]");
	
	//Application tab
	public By ELEMENT_SETTINGS_APP_TAB = By.xpath("//*[@id='UITabPane']//*[@class='nav nav-tabs']//*[contains(text(),'Applications')]");
	public String ELEMENT_DELETE_APP_FROM_TOPBAR = ".//*[@id='UISpaceApplication']//*[contains(text(),'{$application}')]/../..//*[@class='uiIconClose pull-right']";
	
	//Settings tab
	public final By ELEMENT_SPACE_NAME_INPUT = By.xpath("//input[contains(@name,'displayName')]");
	public final By ELEMENT_SPACE_DESCRIPTION_INPUT = By.xpath("//textarea[contains(@name,'description')]");
	
	/**
	 * constructor
	 * @param dr
	 */
	public SettingSpaceManagement(WebDriver dr){
		this.driver=dr;
	}
	
	/**
	 * Invite a user in the space
	 * @param userName as John or Mary. Without family name
	 */
	public void inviteUser(String userName){
		info("Open members tab");
		click(ELEMENT_SPACE_SETTINGS_MEMBERS_TAB);
		info("Click on select user button");
		click(ELEMENT_SPACE_MEMBERS_SELECT_USER);
		info("Select a user");
		check(ELEMENT_SPACE_SELECT_USER_IN_FORM.replace("{$name}",userName),2);
		info("click on Add button");
		click(ELEMENT_ADD);
		info("click on Invite button");
		click(ELEMENT_SPACE_MEMBERS_INVITE);
	}
	
	/**
	 * Delete an app from the top menu of space
	 * @param app
	 */
	public void deleteApplications(String app){
		info("Open Application tab");
		click(ELEMENT_SETTINGS_APP_TAB);
		info("Click on Delete button");
		click(ELEMENT_DELETE_APP_FROM_TOPBAR.replace("{$application}",app));
	}
	
	/**
	 * input name, des into setting tab
	 * @param name
	 * 				name of space
	 * @param des
	 * 				description of space
	 */
	public void updateInfoSpace(String name, String des){
		info("Input data to setting tab");
		if(name!=null && name!=""){
			info("input a name");
			type(ELEMENT_SPACE_NAME_INPUT,name,true);
		}
		if(des!=null && des!=""){
			info("input a description");
			type(ELEMENT_SPACE_DESCRIPTION_INPUT,des,true);
		}
	}
}