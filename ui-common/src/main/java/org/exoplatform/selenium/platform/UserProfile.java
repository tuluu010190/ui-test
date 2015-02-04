package org.exoplatform.selenium.platform;

import org.openqa.selenium.By;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.WebDriver;

public class UserProfile extends PlatformBase {

	
	
	public final String ELEMENT_NAME_OF_USER_TOP_LEFT = "//*[@id='UIBreadCrumbsNavigationPortlet']//*[contains(text(),'{$name}')]";
	public final By ELEMENT_HORIZONTAL_TOOLBAR = By.xpath("//*[@id='UIUserNavigationPortlet']/ul");
	
	//Navigation menu
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIRST_APP_PROFILE = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[1]//*[@class='uiIconAppprofile uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_SECOND_APP_ACTIVITIES = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[2]//*[@class='uiIconAppactivities uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_THIRD_APP_CONNECTIONS = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[3]//*[@class='uiIconAppconnections uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FORTH_APP_WIKI = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[4]//*[@class='uiIconAppwiki uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIFTH_APP_DASHBOARD = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[5]//*[@class='uiIconAppdashboard uiIconDefaultApp']");

	//Basic information
	
	//Contact
	public final By ELEMENT_CONTACT_EDIT_ICON = By.xpath(".//*[@id='UIContactSection']//*[contains(text(),'Contact')]/..//*[@class='uiIconEdit']");
	public final By ELEMENT_CONTACT_PHONE_ADD_ICON = By.xpath(".//strong[contains(text(),'Phone')]/../..//*[@class='uiIconPlus uiIconLightGray']");
	public final By ELEMENT_CONTACT_SAVE_BUTTON = By.xpath(".//*[@id='UIContactSection']//button[text()='Save']");
	public final By ELEMENT_CONTACT_PHONE_INPUT_FIELD = By.xpath(".//*[@title='Phone']");
	//Experience

	public UserProfile(WebDriver dr){
		driver = dr;
	}

	public void updateContact(String gender, String phone, String ims,
			String url) {
		// TODO Auto-generated method stub
		click(ELEMENT_CONTACT_EDIT_ICON);
		if(!gender.isEmpty())
			info("gender is not empty");
		if(!phone.isEmpty()){
			click(ELEMENT_CONTACT_PHONE_ADD_ICON);
			type(ELEMENT_CONTACT_PHONE_INPUT_FIELD,phone,true);
		}
		if(!ims.isEmpty())
			info("ims is not empty");
		if(!url.isEmpty())
			info("url is not empty");
		click(ELEMENT_CONTACT_SAVE_BUTTON);
			
	}

}
