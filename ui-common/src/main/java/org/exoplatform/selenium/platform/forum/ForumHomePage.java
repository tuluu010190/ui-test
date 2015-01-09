package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForumHomePage extends PlatformBase {
	PlatformPermission per;
	ManageAlert alert;
	Button button;

	//Action bar
	public final By ELEMENT_ACTIONBAR_ADDCATEGORY = By.xpath("//*[@class='uiIconAddCategory uiIconLightGray']");
	public final By ELEMENT_ACTIONBAR_ADDFORUM = By.xpath("//*[@class='uiIconForumCreateForum uiIconForumLightGray']");
	public final By ELEMENT_ACTIONBAR_USER = By.xpath("//*[@class='uiIconUser uiIconLightGray']");
	public final By ELEMENT_ACTIONBAR_ADMINISTRATION = By.xpath("//*[@class='uiIconForumAdmin uiIconForumLightGray']");
		//administration
		public final By ELEMENT_ACTIONBAR_ADMIN_BANIP = By.xpath("//*[@class='uiIconForumBanIp']");
		public final By ELEMENT_ACTIONBAR_ADMIN_BBCODE = By.xpath("//*[@class='uiIconForumBBCode']");
			//add BBCODE
			public final By ELEMENT_ADMIN_BBCODE_ADDBBCODE = By.xpath("//*[text()='Add BBCode']");
			public final By ELEMENT_BBCODE_ADDBBCODEFORM_TAG = By.xpath("//*[@id='TagName']");
			public final By ELEMENT_BBCODE_ADDBBCODEFORM_REPLACEMENT = By.xpath("//*[@id='Replacement']");
			public final By ELEMENT_BBCODE_ADDBBCODEFORM_DESCRIPTION = By.xpath("//*[@id='Description']");
			public final By ELEMENT_BBCODE_ADDBBCODEFORM_EXAMPLE = By.xpath("//*[@id='Example']");
			public final String ELEMENT_BBCODE_EDITBBCODE = "//*[contains(text(),'${tag}')]/../..//*[ @class='uiIconEdit uiIconLightGray']";
			public final String ELEMENT_BBCODE_DELETEBBCODE = "//*[contains(text(),'${tag}')]/../..//*[ @class='uiIconDelete uiIconLightGray']";
			
	//Breadcumb
	public By ELEMENT_CATEGORY_BREADCUMB_HOME=By.xpath("//*[@id='UIBreadcumbs']//*[text()='Home']");

	//Forum portlets
	public By ELEMENT_FORUM_PORTLET = By.id("UIForumPortlet");

	//Button
	public final By ELEMENT_OK_BTN = By.xpath("//*[@class='btn actionOK']");
	
	/**
	 * constructor
	 * @param dr
	 */
	public ForumHomePage(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
	}

	/**
	 * Go to home category
	 */
	public void goToHomeCategory(){
		if(waitForAndGetElement(ELEMENT_CATEGORY_BREADCUMB_HOME,5000,0)!=null){
			info("Go to home category");
			click(ELEMENT_CATEGORY_BREADCUMB_HOME);
		}
		waitForElementNotPresent(ELEMENT_CATEGORY_BREADCUMB_HOME);
	}
	
	public void AddBBCode(String tag, String replacement, String description, String example, boolean use ) {
		click(ELEMENT_ADMIN_BBCODE_ADDBBCODE);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_TAG , tag, true);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_REPLACEMENT , replacement, true);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_DESCRIPTION , description, true);
		type(ELEMENT_BBCODE_ADDBBCODEFORM_EXAMPLE , example, true);
		if(use==true) {
			check(By.xpath("//*[@id='UseOption']"));
		}
	}
}
