package org.exoplatform.selenium.platform.ecms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SiteExplorer extends EcmsBase {
	  //choose a drive
  	public static void chooseDrive(By locator)
  	{
  		waitForAndGetElement(ELEMENT_DRIVE).click();
  		waitForAndGetElement(locator).click();	
  	}
  	
  //Enable preferenes option
  	public static void checkPreferenceOption(String optionId){
  		goToNode(ELEMENT_PREFERENCE_LINK);
  		click(By.linkText("Advanced"));
  		pause(500);
  		WebElement check = waitForAndGetElement(By.id(optionId));
  		if (check.isSelected()!= true){
  			check.click();
  		}
  		click(By.linkText("Save"));
  	}
  	
	//simple search
	public static boolean simpleSearch(String keyword){
		boolean delete = true;
//		waitForAndGetElement(ELEMENT_SIMPLESEARCH_TEXTBOX).clear();
		type(ELEMENT_SIMPLESEARCH_TEXTBOX, keyword, true);
		click(ELEMENT_SIMPLESEARCH_SUBMIT);
		if (isElementPresent(By.xpath("//div[contains(text(),'"+keyword+"')]")))
		{
			return delete;}
		else {
			delete = false;
			return delete;}
	}
	
	//simple search not return result
    public static boolean notSimpleSearch(String keyword) {
        return !simpleSearch(keyword);
    }
    
}
