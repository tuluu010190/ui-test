package org.exoplatform.selenium.platform.ecms.contentexplorer;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author vuna2
 *
 */
public class AdvancedSearch extends EcmsBase{

	public AdvancedSearch(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	//Advanced search form
	public final By ELEMENT_SAVED_SEARCH_ICON = By.className("uiIconEcmsSavedSearchesMini"); 
	public final By ELEMENT_ADVANCED_SEARCH_ICON = By.xpath("//*[@title='Advanced Search']");
	public final By ELEMENT_ADVANCED_SEARCH_TAB = By.xpath("//*[@id='UIECMSearch']//*[contains(text(),'Advanced Search')]");
	public final By ELEMENT_CONSTRAINT_FORM = By.xpath("//*[contains(text(), 'Show/Hide Constraint Form')]");

	//Advanced search form > Show/Hide constraint form
	public final By ELEMENT_ADD_CATEGORY_IMG = By.xpath("//*[@data-original-title = 'Add category']");
	public final By ELEMENT_ADD_CATEGORY_CHECKBOX = By.id("categoryPro");

	//Go to advanced search in content explorer
	public void goToAdvancedSearch(){
		click(ELEMENT_SAVED_SEARCH_ICON);
		if (isElementNotPresent(By.xpath("//*[@data-original-title = 'Advanced Search']"))){
			click(By.xpath("//*[@data-original-title = 'Advanced Search']"));
		}else if (isElementPresent(ELEMENT_ADVANCED_SEARCH_ICON)){
			click(ELEMENT_ADVANCED_SEARCH_ICON);
		}
		click(ELEMENT_ADVANCED_SEARCH_TAB);
		waitForElementPresent(ELEMENT_CONSTRAINT_FORM);
		//Utils.pause(500);
	}

	//Open [Add Category] Form in [Site Explorer] > [Advanced Search]
	public void openAddCategoryInAdvancedSearch(){
		if (getElement(ELEMENT_ADD_CATEGORY_IMG) == null){
			click(ELEMENT_CONSTRAINT_FORM);
		}
		if (waitForAndGetElement(ELEMENT_ADD_CATEGORY_CHECKBOX, DEFAULT_TIMEOUT, 0, 2).isSelected() == false){
			click(ELEMENT_ADD_CATEGORY_CHECKBOX, 2);
		}	
		if (isElementPresent(ELEMENT_ADD_CATEGORY_IMG)){
			click(ELEMENT_ADD_CATEGORY_IMG);
		}else {
			click("//*[@data-original-title = 'Add Category']");
		}
		Utils.pause(500);
	}
}
