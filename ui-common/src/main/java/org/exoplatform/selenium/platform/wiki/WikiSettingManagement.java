package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WikiSettingManagement extends PlatformBase{
	
	public final By ELEMENT_TEMPLATE_SEARCH_TEXTBOX = By.xpath(".//*[@id='TemplateSeachBox']");
	public final By ELEMENT_WIKI_SETTINGS_TITLE = By.xpath(".//*[@id='UIWikiSettingContainer']/h4[text()='Wiki Settings']");
	public final String ELEMENT_WIKI_SETTINGS_RESULTS = ".//*[@id='UIWikiTemplateGrid']//*[text()='${template}']";
	
	/**
	 * constructor
	 * @param dr
	 */
	public WikiSettingManagement(WebDriver dr){
		this.driver=dr;
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
	
	
}
