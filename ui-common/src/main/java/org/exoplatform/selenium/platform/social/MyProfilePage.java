package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	public final By ELEMENT_EDIT_BASIC_INFO_SAVE_BUTTON = By.xpath("//*[@id='UIEditUserProfileForm']//button[contains(text(), 'Save')]");

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
	public final String ELEMENT_NAME_OF_USER_TOP_RIGHT = ".//*[@id='UIUserPlatformToolBarPortlet']//*[contains(normalize-space(),'${firstName} ${lastName}')]";
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
	public final By ELEMENT_CONTACT_CANCEL_BUTTON = By.xpath(".//*[@id='UIContactSection']//button[text()='Cancel']");
	public final By ELEMENT_CONTACT_PHONE_INPUT_FIELD = By.xpath(".//*[@title='Phone']");

	public final By ELEMENT_EDIT_MY_PROFILE_LINK = By.xpath(".//*[@id='UIBreadCrumbsNavigationPortlet']//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_MY_PROFILE_BUTTON = By.xpath("//*[@id='UIExperienceProfilePortlet']//*[@class='uiIconEdit uiIconLightGray']");
	public final By ELEMENT_EDIT_PROFILE_FORM = By.id("UIEditUserProfileForm");


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
		if(pos !="" && pos !=null){
			waitForAndGetElement(ELEMENT_EDIT_POSITION);
			click(ELEMENT_EDIT_POSITION);
			Utils.pause(2000);
			click(ELEMENT_EDIT_POSITION_SAVE_BUTTON);
			Utils.pause(2000);
		}
	}

	/**
	 * function: Go to Edit profile
	 */
	public void goToEditProfile(){
		info("Go to edit profile");
		click(ELEMENT_EDIT_MY_PROFILE_BUTTON);
		waitForAndGetElement(ELEMENT_EDIT_PROFILE_FORM);
	}

	/**
	 * Update Basic information
	 * By QuynhPT
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public void updateBasicInformation(String firstName,String lastName,String email){
		info("Update basic information");

		if(waitForAndGetElement(ELEMENT_EDIT_BASIC_INFORMATION,5000,0)!=null){
			click(ELEMENT_EDIT_BASIC_INFORMATION);
		}
		if (firstName !="" && firstName!=null){
			info("update firstname");
			type(ELEMENT_FIRST_NAME_TEXTBOX_EDIT, firstName, true);
		}
		if (lastName !="" && lastName!=null){
			info("update lastName");
			type(ELEMENT_LAST_NAME_TEXTBOX_EDIT, lastName, true);
		}
		if (email !="" && email!=null){
			info("update email");
			type(ELEMENT_EMAIL_TEXTBOX_EDIT, email, true);
		}
		click(ELEMENT_EDIT_BASIC_INFO_SAVE_BUTTON);
		Utils.pause(2000);
	} 

	/**
	 * Change avatar
	 * @param linkfile : File path of new avatar
	 */
	public void changeAvatar(String linkfile){
		info("-- changeAvatar --");
		click(ELEMENT_CHANGE_AVATAR_LINK);
		uploadFileUsingRobot(getAbsoluteFilePath(linkfile));
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
	 * @param job
	 */
	public void updateContact(String gender, String phone, String ims,
			String url,String job) {
		click(ELEMENT_CONTACT_EDIT_ICON);
		if(gender !="" && gender!=null){
			info("update gender");
		}
		if(phone !="" && phone!=null){
			info("update phone");
			click(ELEMENT_CONTACT_PHONE_ADD_ICON);
			type(ELEMENT_CONTACT_PHONE_INPUT_FIELD,phone,true);
		}
		if(ims !="" && ims!=null){
			info("update ims");
		}
		if(url !="" && url!=null){
			info("update url");
		}
		if(job !="" && job!=null){
			info("update job");
		}
		click(ELEMENT_CONTACT_SAVE_BUTTON);
		Utils.pause(2000);	
	}

	/**
	 * Save or cancle update info
	 * @param isSave 
	 * 				null or true: save updating
	 * 				false: cancel
	 */
	public void saveCancelUpdateInfo(Boolean isSave){
		if(isSave==null || isSave){
			info("Save updating information");
			click(ELEMENT_CONTACT_SAVE_BUTTON);
			Utils.pause(2000);	
		}
		else{
			info("Cancel updating information");
			click(ELEMENT_CONTACT_CANCEL_BUTTON);
			Utils.pause(2000);	
		}	
	}
}
