package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WikiSettingManagement extends PlatformBase{
	
	public final By ELEMENT_TEMPLATE_SEARCH_TEXTBOX = By.xpath(".//*[@id='TemplateSeachBox']");
	public final By ELEMENT_WIKI_SETTINGS_TITLE = By.xpath(".//*[@id='UIWikiSettingContainer']/h4[text()='Wiki Settings']");
	public final String ELEMENT_WIKI_SETTINGS_RESULTS = ".//*[@id='UIWikiTemplateGrid']//*[text()='${template}']";
	public final String ELEMENT_EDIT_TEMPLATE = ".//*[@id='UIWikiTemplateGrid']//*[contains(text(),'{$template}')]/../..//*[@class='uiIconEditTemplate uiIconLightGray']";
	public final String ELEMENT_DELETE_TEMPLATE = "//*[@id='UIWikiTemplateGrid']//*[contains(text(),'{$template}')]/../..//*[@class='uiIconDeleteTemplate uiIconLightGray']";
	public final By ELEMENT_TITLE_TEMPLATE = By.id("titleInput");
	public final By ELEMENT_SAVE_TEMPLATE = By.id("UISubmitToolBarUpper_SaveTemplate_");
	/**
	 * constructor
	 * @param dr
	 */
	ManageAlert alert ;
	public WikiSettingManagement(WebDriver dr){
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
	public void editTemplate(String template,String title, String subTitle, String text){
		click(By.xpath(ELEMENT_EDIT_TEMPLATE.replace("{$template}",template)));
		if(title!=""){
			type(ELEMENT_TITLE_TEMPLATE,title,true);
		}
			
		click(ELEMENT_SAVE_TEMPLATE);
	}
	
	public void deleteTemplate(String template){
		info("Delete template "+template);
		click(By.xpath(ELEMENT_DELETE_TEMPLATE.replace("{$template}", template)));
		alert.acceptAlert();
		driver.navigate().refresh();
		waitForElementNotPresent(By.xpath(ELEMENT_DELETE_TEMPLATE.replace("{$template}", template)));
	}
	
}
