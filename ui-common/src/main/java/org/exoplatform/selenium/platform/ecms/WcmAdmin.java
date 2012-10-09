package org.exoplatform.selenium.platform.ecms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WcmAdmin extends EcmsBase {
	
	public static final By ELEMENT_CONTENT_MANAGER = By.linkText("Content administration");
	public static final By ELEMENT_CONTENT_PRESENT = By.xpath("//div[contains(text(),'Content Presentation')]");
	public static final By ELEMENT_MANAGEMENT_VIEW = By.xpath("//a[contains(text(),'Manage View')]");
	public static final By ELEMENT_EDIT_VIEW = By.xpath("//*[@id='UIViewList']/table/tbody/tr[9]/td[5]/div/img[2]");
	public static final By ELEMENT_COLLABORATOR = By.linkText("Collaboration");
	public static final By ELEMENT_SYMLINK_CHECKBOX = By.id("addSymLink");
	public static final By ELEMENT_BACK_BUTTON = By.linkText("Back");
	
	 //set Add symlink view in action bar
	  public static void setViewSymlink(){
		  mouseOver(ELEMENT_LINK_SETUP, false);
		  mouseOver(ELEMENT_MENU_CONTENT_LINK, false);
		  click(ELEMENT_CONTENT_MANAGER);
		  click(ELEMENT_CONTENT_PRESENT);
		  click(ELEMENT_MANAGEMENT_VIEW);
		  click(ELEMENT_EDIT_VIEW);
		  click(ELEMENT_COLLABORATOR);
		  WebElement check = waitForAndGetElement(ELEMENT_SYMLINK_CHECKBOX);
		  if (check.isSelected()==false){
			  click(ELEMENT_SYMLINK_CHECKBOX);
			  click(ELEMENT_SAVE_BUTTON);
		  }else{
			  click(ELEMENT_BACK_BUTTON);
		  }
		  click(ELEMENT_SAVE_BUTTON);		  
	  }
}
