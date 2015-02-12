package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * @author quynhpt
 * date 21/01/2015
 */
public class MyProfilePage extends PlatformBase {
	//Navigation tabs
	public final By ELEMENT_MY_PROFILE_TAB = By.xpath("//*[@class='nav nav-tabs userNavigation']//*[@class='uiIconAppprofile uiIconDefaultApp']");

	//Current position
	public final By ELEMENT_EDIT_POSITION = By.xpath("//*[@id='UIHeaderSection']//*[@class='uiIconEdit']");
	public final By ELEMENT_POSITION_TEXTBOX_EDIT = By.id("position");
	public final By ELEMENT_EDIT_POSITION_SAVE_BUTTON = By.id("savePosition");

	//Basic information
	public final By ELEMENT_EDIT_BASIC_INFORMATION = By.xpath("//*[@id='UIBasicInfoSection']//*[@class='uiIconEdit']");
	public final By ELEMENT_FIRST_NAME_TEXTBOX_EDIT = By.id("firstName");
	public final By ELEMENT_LAST_NAME_TEXTBOX_EDIT = By.id("lastName");
	public final By ELEMENT_EMAIL_TEXTBOX_EDIT = By.id("email");
	public final By ELEMENT_EDIT_BASIC_INFO_SAVE_BUTTON = By.xpath("//*[@id='UIBasicInfoSection']//button[contains(text(), 'Save')]");

	public final By	ELEMENT_CHANGE_AVATAR_LINK = By.className("changeAvatar");
	public final By ELEMENT_CHOOSE_AVATAR_IMAGE = By.className("fileNameLabel");
	public final By ELEMENT_UPLOAD_NAME = By.name("file");

	//Confirm
	public final By ELEMENT_CONFIRM = By.xpath("//*[text()='Confirm']");
	public final By ELEMENT_CANCEL = By.xpath("//*[text()='Cancel']");
	public final By ELEMENT_SAVE_UPDATE_INFO = By.xpath("//*[@id='UIProfile']//../*[contains(text(), 'Save')]");
	public final By ELEMENT_CANCEL_UPDATE_INFO = By.xpath("//*[@id='UIProfile']//../*[contains(text(), 'Cancel')]");
	public final By ELEMENT_SAVE = By.xpath("//*[text()= 'Save']");
	
	public final String ELEMENT_NAME_OF_PROFILE_TOP_LEFT = "//*[@id='UIBreadCrumbsNavigationPortlet']//*[contains(text(),'{$name}')]";
	
	
	public final String ELEMENT_NAME_OF_USER_TOP_LEFT = "//*[@id='UIBreadCrumbsNavigationPortlet']//*[contains(text(),'{$name}')]";
	public final By ELEMENT_HORIZONTAL_TOOLBAR = By.xpath("//*[@id='UIUserNavigationPortlet']/ul");
	
	//Navigation menu
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIRST_APP_PROFILE = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[1]//*[@class='uiIconAppprofile uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_SECOND_APP_ACTIVITIES = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[2]//*[@class='uiIconAppactivities uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_THIRD_APP_CONNECTIONS = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[3]//*[@class='uiIconAppconnections uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FORTH_APP_WIKI = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[4]//*[@class='uiIconAppwiki uiIconDefaultApp']");
	public final By ELEMENT_HORIZONTAL_TOOLBAR_FIFTH_APP_DASHBOARD = By.xpath("//*[@id='UIUserNavigationPortlet']/ul/li[5]//*[@class='uiIconAppdashboard uiIconDefaultApp']");
	
	//Contact
	public final By ELEMENT_CONTACT_EDIT_ICON = By.xpath(".//*[@id='UIContactSection']//*[contains(text(),'Contact')]/..//*[@class='uiIconEdit']");
	public final By ELEMENT_CONTACT_PHONE_ADD_ICON = By.xpath(".//strong[contains(text(),'Phone')]/../..//*[@class='uiIconPlus uiIconLightGray']");
	public final By ELEMENT_CONTACT_SAVE_BUTTON = By.xpath(".//*[@id='UIContactSection']//button[text()='Save']");
	public final By ELEMENT_CONTACT_PHONE_INPUT_FIELD = By.xpath(".//*[@title='Phone']");
	
	
	/**
	 * constructor
	 * @param dr
	 */
	public MyProfilePage(WebDriver dr){
		this.driver=dr;
	}

	/**
	 * Update Current position
	 * By QuynhPT
	 * @param pos
	 */
	public void updateCurrentPosition(String pos){
		info("Update Current Position");
		if(pos !=""){
			waitForAndGetElement(ELEMENT_EDIT_POSITION);
			click(ELEMENT_EDIT_POSITION);
			Utils.pause(2000);
			click(ELEMENT_EDIT_POSITION_SAVE_BUTTON);
			Utils.pause(2000);
		}
	}

	/**
	 * Update Basic information
	 * By QuynhPT
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public void updateBasicInformation(String firstName,String lastName,String email){
		if(firstName !="" || lastName !="" || email !=""){
			waitForAndGetElement(ELEMENT_EDIT_BASIC_INFORMATION);
			click(ELEMENT_EDIT_BASIC_INFORMATION);
			if (firstName !="")
				type(ELEMENT_FIRST_NAME_TEXTBOX_EDIT, firstName, true);
			if (lastName !="")
				type(ELEMENT_LAST_NAME_TEXTBOX_EDIT, lastName, true);
			if (email !="")
				type(ELEMENT_EMAIL_TEXTBOX_EDIT, email, true);
			click(ELEMENT_EDIT_BASIC_INFO_SAVE_BUTTON);
			Utils.pause(2000);
		}
	} 

	/**
	 * Change avatar
	 * @param linkfile : File path of new avatar
	 */
	public void changeAvatar(String linkfile){
		info("-- changeAvatar --");
		click(ELEMENT_CHANGE_AVATAR_LINK);
		WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility = 'visible'; arguments[0].style.height = '1px'; " +
				"arguments[0].style.width = '1px'; arguments[0].style.opacity = 1", upload);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible'", upload);
		upload.sendKeys(Utils.getAbsoluteFilePath(linkfile));
		Utils.pause(3000);
		info("Upload file " + Utils.getAbsoluteFilePath(linkfile));
		switchToParentWindow();
		click(ELEMENT_CONFIRM);
		waitForElementNotPresent(ELEMENT_CONFIRM);
		click(ELEMENT_SAVE);
		Utils.pause(1000);
	}
	
	/**
	 * Update information of contact of a user
	 * @param gender
	 * @param phone
	 * @param ims
	 * @param url
	 */
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
