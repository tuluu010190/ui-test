package org.exoplatform.selenium.platform.forum;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.exoplatform.selenium.TestLogger.info;
public class ForumCategoryManagement extends PlatformBase {
	
	PlatformPermission per;
	ManageAlert alert;
	Button button;
	
	
	public final By ELEMENT_ADD_CATEGORY_BUTTON=By.xpath("//*[@class='uiIconAddCategory uiIconLightGray']");
	
	//Add category form
	public final By ELEMENT_ADD_CATEGORY_FORM=By.id("AddCategoryForm");
	public final By ELEMENT_CATEGORY_TAB = By.linkText("Category");
	public final By ELEMENT_CATEGORY_TITLE = By.id("CategoryTitle");
	public final By ELEMENT_CATEGORY_ORDER = By.id("CategoryOrder");
	public final By ELEMENT_RESTRICTED_AUDIENCE = By.id("UserPrivate");
	public final String ELEMENT_RESTRICTED = "UserPrivate";
	public final By ELEMENT_DESCRIPTION = By.id("Description");
	public final By ELEMENT_RESTRICTED_SELECT_USER = By.xpath("//*[@id='DetailTab']//i[@class='uiIconUser uiIconLightGray']");
	public final By ELEMENT_RESTRICTED_SELECT_GROUP = By.xpath("//*[@id='DetailTab']//i[@class='uiIconGroup uiIconLightGray']");
	public final By ELEMENT_RESTRICTED_SELECT_ROLE = By.xpath("//*[@id='DetailTab']//i[@class='uiIconMembership uiIconLightGray']");
	public final By ELEMENT_CANCEL_ADD_CATEGORY_BUTTON = By.xpath("//*[@id='UICategoryForm']//button[text()='Cancel']");
	public By ELEMENT_CATEGORY_ADD_FORM_SAVE_BUTTON=By.xpath("//*[@id='UICategoryForm']//*[text()='Save']");
	public By ELEMENT_CATEGORY_ADD_FORM_CANCEL_BUTTON=By.xpath("//*[@id='UICategoryForm']//*[text()='Save']");

	/**
	 * constructor
	 * @param dr
	 */
	public ForumCategoryManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
	}
	
	/**
	 * Go to Add category
	 */
	public void goToAddCategory(){
		info("Go to Add category");
		click(ELEMENT_ADD_CATEGORY_BUTTON);
		waitForAndGetElement(ELEMENT_ADD_CATEGORY_FORM);
	}
	
	/**
	 * Input data to category tab
	 * @param catName
	 * @param order
	 * @param description
	 */
	public void inputBasicDataToCategoryTab(String catName, String order,String description){
		info("Input data to category tab");
		if (catName != null && catName!=""){
			type(ELEMENT_CATEGORY_TITLE, catName, true);
		}
		if (order != null&& order!=""){
			type(ELEMENT_CATEGORY_ORDER, order, true);
		}
		if (description != null&& description!=""){
			type(ELEMENT_DESCRIPTION, description, true);
		}
	}
}
