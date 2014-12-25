package org.exoplatform.selenium.platform.forum;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.exoplatform.selenium.TestLogger.info;
public class ForumManagement extends PlatformBase {
	PlatformPermission per;
	ManageAlert alert;
	Button button;
	public final By ELEMENT_ADD_FORUM_BUTTUN=By.xpath("//*[@class='uiIconForumCreateForum uiIconForumLightGray']");

	//Add forum form
	public final By ELEMENT_ADD_FORUM_FORM=By.id("UIForumForm");
	public By ELEMENT_FORUM_ADD_FORM_SAVE_BUTTON=By.xpath("//*[@id='UIForumForm']//*[text()='Save']");
	public By ELEMENT_FORUM_ADD_FORM_CANCEL_BUTTON=By.xpath("//*[@id='UIForumForm']//*[text()='Save']");
	public By ELEMENT_SELECT_CATERORY = By.name("Category");
	public By ELEMENT_ADD_FORUM_TAB = By.xpath("//div[@class='MiddleTab' and text()='Add Forum']");
	public By ELEMENT_FORUM_TITLE = By.id("ForumTitle");
	public By ELEMENT_FORUM_ORDER = By.id("ForumOrder");
	public By ELEMENT_FORUM_STATE = By.name("ForumState");
	public By ELEMENT_FORUM_STATUS = By.name("ForumStatus");
	public By ELEMENT_FORUM_DESCRIPTION = By.id("Description");
	public By ELEMENT_MODERATOR_TAB = By.linkText("Moderation Options");
	public By ELEMENT_FORUM_MODERATOR = By.id("Moderator");
	public By ELEMENT_FORUM_AUTO_FILL = By.name("AutoAddEmailNotify");
	public By ELEMENT_NOTIFY_ADD_POST = By.id("NotifyWhenAddPost");
	public By ELEMENT_NOTIFY_ADD_TOPIC = By.id("NotifyWhenAddTopic");
	public By ELEMENT_MODERATE_THREAD = By.id("ModerateThread");
	/**
	 * constructor
	 * @param dr
	 */
	public ForumManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
	}

	/**
	 * Go to Add forum
	 */
	public void goToAddForum(){
		info("Go to Add forum");
		click(ELEMENT_ADD_FORUM_BUTTUN);
		waitForAndGetElement(ELEMENT_ADD_FORUM_FORM);
	}

	/**
	 * input data in add forum tab in add forum popup
	 * @param title
	 * @param catName
	 * @param order
	 * @param state
	 * @param status
	 * @param description
	 */
	public void inputDataInAddForumTab_addForum(String title, String catName, String order, String state, String status, String description){
		info("Input data in add forum tab");
		if(title!=null && title!=""){
			type(ELEMENT_FORUM_TITLE, title, true);
		}
		if (catName != null && catName!=""){
			select(ELEMENT_SELECT_CATERORY, catName);
		}	
		if(order!=null && order!=""){
			type(ELEMENT_FORUM_ORDER, order, true);
		}
		if (state != null && state!=""){
			select(ELEMENT_FORUM_STATE, state);
		}
		if (status != null && status!=""){
			select(ELEMENT_FORUM_STATUS, status);
		}
		if(description!=null && description!=""){
			type(ELEMENT_FORUM_DESCRIPTION, description, true);
		}
	}
}
