package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


/**
 *Initiated by HangNTT
 * 
 *@author VuNA
 *@date: 08/11/2012
 *Update/Add new method
 * -- Edit a basic information
 * -- Edit a contact
 * -- Edit an Experience 
 */

public class PeopleProfile extends PlatformBase {
	// Go to Account Name link > My Profile	
	// Edit user in My Profile
	// Basic information
	public static final By ELEMENT_EDIT_HEADER_BUTTON = By.xpath("//*[@id='UIHeaderSection']/div[2]/h5/a[contains(text(),'Edit')]");
	public static final By ELEMENT_EDIT_INFORMATION_BUTTON = By.xpath("//*[@id='UIBasicInfoSection']/div[2]/h5/a[contains(text(),'Edit')]");

	// Contact
	public static final By ELEMENT_EDIT_CONTACT_BUTTON = By.xpath("//*[@id='UIContactSection']/div[2]/h5/a[contains(text(),'Edit')]");
	//Contact > Gender
	public static final By ELEMENT_GENDER_BOX = By.id("gender");

	//Contact > Phone
	public static final By ELEMENT_ADD_PHONE_BUTTON = By.xpath("//*[@id='UIContactSection']/div[3]/table/tbody/tr[2]/td[2]/a");
	public static final By ELEMENT_ADD_PHONE_EXTEND_BUTTON = By.xpath("//*[@id='UIContactSection']/div[3]/table/tbody/tr[2]/td[2]/a[2]");
	public static final By ELEMENT_TYPE_OF_ADD_PHONE = By.id("1phone000");
	public static final By ELEMENT_INPUT_FIELD_ADD_PHONE = By.id("1phone001");

	//Contact > IM
	public static final By ELEMENT_ADD_IMS_BUTTON = By.xpath("//*[@id='UIContactSection']/div[3]/table/tbody/tr[3]/td[2]/a");
	public static final By ELEMENT_ADD_IMS_EXTEND_BUTTON = By.xpath("//*[@id='UIContactSection']/div[3]/table/tbody/tr[3]/td[2]/a[2]");
	public static final By ELEMENT_IMS_BOX = By.id("2im000");
	public static final By ELEMENT_INPUT_FIELD_IMS = By.id("2im001");

	//Contact > URL
	public static final By ELEMENT_ADD_URLS_BUTTON = By.xpath("//*[@id='UIContactSection']/div[3]/table/tbody/tr[4]/td[2]/a");
	public static final By ELEMENT_ADD_URLS_EXTEND_BUTTON = By.xpath("//*[@id='UIContactSection']/div[3]/table/tbody/tr[4]/td[2]/a[2]");
	public static final By ELEMENT_INPUT_FIELD_URLS	= By.id("3url001");
	public static final By ELEMENT_REMOVE_BUTTON = By.xpath("//*[@id='UIContactSection']/div[3]/table/tbody/tr[4]/td[2]/a[2]");

	// Experience
	public static final By ELEMENT_EDIT_EXPERIENCE_BUTTON = By.xpath("//*[@id='UIExperienceSection']/div[2]/h5/a[contains(text(),'Edit')]");
	public static final By ELEMENT_ADD_EXPERIENCE_BUTTON = By.xpath("//*[@id='UIExperienceSection']/div[3]/table/tbody/tr/td[2]/a");
	public static final By ELEMENT_ADD_EXPERIENCE_EXTEND_BUTTON = By.xpath("//*[@id='UIExperienceSection']/div[3]/div/table/tbody/tr[1]/td[2]/a[2]");
	public static final By ELEMENT_INPUT_FIELD_ORGANIZATION = By.xpath("//*[contains(@id, 'company')]");
	public static final By ELEMENT_INPUT_FIELD_POSITION = By.xpath("//*[contains(@id, 'position')]");
	public static final By ELEMENT_INPUT_FIELD_SKILL = By.xpath("//*[contains(@id, 'skills')]");
	public static final By ELEMENT_REMOVE_EXTEND_EXPERIENCE_BUTTON = By.xpath("//*[@id='UIExperienceSection']/div[3]/div[2]/table/tbody/tr[1]/td[2]/a[1]");
	
	/**
	 * Edit Basic Information
	 * @param firstName: edit the user's first name
	 * @param lastName: edit the user's last name
	 * @param email: edit the user's email
	 */
	public static void editUserBasicInformation(String firstName, String lastName, String email){
		info("-- Edit the user's basic information --");
		click(ELEMENT_EDIT_INFORMATION_BUTTON);
		type(ELEMENT_INPUT_FIRSTNAME, firstName, true);
		type(ELEMENT_INPUT_LASTNAME, lastName, true);
		type(ELEMENT_INPUT_EMAIL, email, true);
		save();
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}

	/**
	 * Edit a contact
	 * @param typeOfGender: male or female
	 * @param addPhone: boolean 
	 * @param typeOfAddPhone: Work/Home/Other 
	 * @param numberOfPhone
	 * @param addIMS: boolean
	 * @param typeOfIMS: Gtalk/Yahoo/Skype, etc...
	 * @param nameOfIMS: name of IM
	 * @param addURLS: boolean
	 * @param nameOfURLS: name of URL
	 */
	public static void editUserContact(String typeOfGender, boolean addPhone, String typeOfAddPhone, String numberOfPhone,
			boolean addIMS, String typeOfIMS, String nameOfIMS,
			boolean addURLS, String nameOfURLS){
		info("-- Edit the user's contact --");
		click(ELEMENT_EDIT_CONTACT_BUTTON);
		info("-- Type of gender --");
		select(ELEMENT_GENDER_BOX, typeOfGender);
		if(addPhone){
			info("-- Adding a phone number --");
			if (isTextPresent("no phone number entered")){
				click(ELEMENT_ADD_PHONE_BUTTON);
			}
			select(ELEMENT_TYPE_OF_ADD_PHONE, typeOfAddPhone);
			type(ELEMENT_INPUT_FIELD_ADD_PHONE, numberOfPhone, true);
			click(ELEMENT_ADD_PHONE_EXTEND_BUTTON);
		}
		if(addIMS){
			info("-- Adding an IM --");
			if (isTextPresent("no IM handle entered")){
				click(ELEMENT_ADD_IMS_BUTTON);
			}
			select(ELEMENT_IMS_BOX, typeOfIMS);
			type(ELEMENT_INPUT_FIELD_IMS, nameOfIMS, true);
			click(ELEMENT_ADD_IMS_EXTEND_BUTTON);
		}
		if(addURLS){
			info("-- Adding an URL --");
			if (isTextPresent("no contact link entered")){
				click(ELEMENT_ADD_URLS_BUTTON);
			}
			type(ELEMENT_INPUT_FIELD_URLS, nameOfURLS, true);
			click(ELEMENT_ADD_URLS_EXTEND_BUTTON);
			click(ELEMENT_REMOVE_BUTTON);
		}
		save();
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}
	
	/**
	 * Edit the user's experience
	 * @param nameOfOrganization
	 * @param nameOfPosition
	 * @param nameOfSkill
	 */
	public static void editUserExperience(String nameOfOrganization, String nameOfPosition, String nameOfSkill){
		info("-- Edit the user's experience --");
		click(ELEMENT_EDIT_EXPERIENCE_BUTTON);
		if(isTextPresent("You did not enter any experience yet")){
			click(ELEMENT_ADD_EXPERIENCE_BUTTON);
		}
		type(ELEMENT_INPUT_FIELD_ORGANIZATION, nameOfOrganization, true);
		type(ELEMENT_INPUT_FIELD_POSITION, nameOfPosition, true);
		type(ELEMENT_INPUT_FIELD_SKILL, nameOfSkill, true);
		click(ELEMENT_ADD_EXPERIENCE_EXTEND_BUTTON);
		click(ELEMENT_REMOVE_EXTEND_EXPERIENCE_BUTTON);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		pause(500);
		save();
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}

}
