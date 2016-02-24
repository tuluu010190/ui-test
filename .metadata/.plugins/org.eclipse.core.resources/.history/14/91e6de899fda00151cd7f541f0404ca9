package org.exoplatform.selenium.platform.ecms;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SEOManagement extends PlatformBase {
	
	public final By ELEMENT_SEO_SAVE = By.xpath(".//*[@id='RightContainer']//button[text()='Save']");
	public final By ELEMENT_SEO_CLOSE=By.xpath(".//*[@id='UISEOPopupWindow']//a[@class='uiIconClose pull-right']");
	public final By ELEMENT_SEO_LANGUAGE_SHOW = By.xpath("//*[@class='uiIconPlus uiIconLightGray']");
	public final By ELEMENT_SEO_LANGUAGE_SELECTBOX = By.xpath("//*[@name='language']");
	public final By ELEMENT_SEO_TITLEBOX = By.xpath("//*[@id='title']");
	public final By ELEMENT_SEO_DELETE = By.xpath("//*[@title='Delete']");
	public final By ELEMENT_SEO_HELPDESC = By.xpath("//*[text()='Description: ']/..//*[@id='DescriptionHelp']");
	public final By ELEMENT_SEO_HELPKEYWORD = By.xpath("//*[text()='Keywords: ']/..//*[@id='DescriptionHelp']");
	public final By ELEMENT_SEO_HELPPRIORITY = By.xpath("//*[@id='PriorityHelp']");
	public final By ELEMENT_SEO_HELP_POPOVER = By.xpath("//*[@class='popover-content']");
	public final String ELEMENT_SEO_SELECTED_LANGUAGE= ".//*[@id='LeftContainer']//*[contains(text(),'${language}')]";
	
	ManageAlert magAlert;
		
	public SEOManagement(WebDriver driver) {
		this.driver=driver;
		magAlert = new ManageAlert(driver);
	}
	/**
	 * Delete a added language
	 * @param language
	 */
	public void deleteLanguage(String language){
		click(ELEMENT_SEO_SELECTED_LANGUAGE.replace("${language}",language));
		click(ELEMENT_SEO_DELETE);
		magAlert.acceptAlert();
		click(ELEMENT_SEO_CLOSE);
	}
	
		
}
