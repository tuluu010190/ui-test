package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WikiSettingPage extends WikiLocators{
	
	
	/**
	 * constructor
	 * @param dr
	 */
	ManageAlert alert ;
	public WikiSettingPage(WebDriver dr){
		this.driver=dr;
		alert= new ManageAlert(dr);
	}
	
	/**
	 * Search a template
	 * @param template
	 */
	public void searchTemplate(String template){
		info("Input a template's name");
		type(ELEMENT_TEMPLATE_SEARCH_TEXTBOX, template, true);
		info("Press Enter key");
		driver.findElement(ELEMENT_TEMPLATE_SEARCH_TEXTBOX).sendKeys(Keys.ENTER);
		info("Verify that the search results is shown that matchs with keyword");
		waitForAndGetElement(ELEMENT_WIKI_SETTINGS_RESULTS.replace("${tempalte}",template),3000,0);
	}
	
	/**
	 * Edit a wiki template
	 * @param template
	 * @param text
	 */
	public void editTemplate(String template,String newTitle, String newDes, String newContent){
		click(By.xpath(ELEMENT_EDIT_TEMPLATE.replace("{$template}",template)));
		if(!newTitle.isEmpty()){
			info("Input the title for the template");
			type(ELEMENT_TITLE_TEMPLATE,newTitle,true);
		}
			
		if(!newDes.isEmpty()){
			info("Input the description for the template");
			type(ELEMENT_DESCRIPTION_TEMPLATE,newDes,true);
		}
		
		if(!newContent.isEmpty()){
			info("Input the content for the template");
			type(ELEMENT_CONTENT_TEMPLATE,newContent,true);
		}
		saveTemplate();
	}
	/**
	 * Delete a template
	 * @param template
	 */
	public void deleteTemplate(String template){
		if(waitForAndGetElement(ELEMENT_DELETE_TEMPLATE.replace("{$template}", template),2000,0)!=null){
			info("Delete template "+template);
			click(ELEMENT_DELETE_TEMPLATE.replace("{$template}", template));
			alert.acceptAlert();
			waitForElementNotPresent(By.xpath(ELEMENT_DELETE_TEMPLATE.replace("{$template}", template)));
		}
	}
	/**
	 * Cancel deleting a template
	 * @param template
	 */
	public void deleteTemplateWithCanceling(String template){
		info("Delete template "+template);
		click(ELEMENT_DELETE_TEMPLATE.replace("{$template}", template));
		alert.cancelAlert();
		waitForAndGetElement(ELEMENT_DELETE_TEMPLATE.replace("{$template}", template));
	}
	/**
	 * Open template tab
	 */
	public void goToTemplateTab(){
		info("click on the template tab");
		click(ELEMENT_WIKI_SETTING_TEMPLATE_TAB);
		Utils.pause(2000);
	}
	/**
	 * Open Permission tab
	 */
	public void goToPermissionTab(){
		info("Click on Permission tab");
		click(ELEMENT_WIKI_SETTING_PERMISSION_TAB);
		Utils.pause(2000);
	}
	/**
	 * Save all changes for the template
	 */
	public void saveTemplate(){
		info("Click on Save template");
		click(ELEMENT_SAVE_TEMPLATE);
		waitForElementNotPresent(ELEMENT_SAVE_TEMPLATE);
	}
	/**
	 * Cancel all changes for the template
	 */
	public void cancelTemplate(){
		info("Click on Cancel template");
		click(ELEMENT_CANCEL_TEMPLATE);
		Utils.pause(3000);
	}
	/**
	 * Add new a template
	 * @param title
	 * @param des
	 * @param content
	 */
	public void addTemplate(String title,String des,String content){
		info("Click on Add more Template button");
		click(ELEMENT_WIKI_SETTING_ADD_MORE_TEMPALTE);
		
		if(!title.isEmpty()){
			info("Input the title for the template");
			type(ELEMENT_TITLE_TEMPLATE,title,true);
		}
		
		if(!des.isEmpty()){
			info("Input the description for the template");
			type(ELEMENT_DESCRIPTION_TEMPLATE,des,true);
		}
		
		if(!content.isEmpty()){
			info("Input the content for the template");
			type(ELEMENT_CONTENT_TEMPLATE,content,true);
		}
	}
	
}
