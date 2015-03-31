package org.exoplatform.selenium.platform.ecms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.exoplatform.selenium.TestLogger.info;

public class EcmsAcme extends EcmsBase{
	
	public EcmsAcme(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	public final String ELEMENT_BY_TITLE = ".//*[@class='media-body']//*[@title='{$title}']";
	public final String ELEMENT_CONTENT_BY_TITLE = ".//*[@class='media-body']//*[@title='{$title}']/../../..//div[@class='summary']/div[contains(@class,'WCMInlineEditable')]";
	public final String ELEMENT_CONTENT_BY_DATA_TITLE = ".//*[contains(@data-original-title,'${title}')]/..//*[contains(@class,'summary')]/p";
	public final String ELEMENT_CONTENT_BY_TITLE_TEXT_STRONG = ".//*[@class='media-body']//*[@title='{$title}']/../../..//div[@class='summary']/div[contains(@class,'WCMInlineEditable')]/p/strong";
	public final By ELEMENT_EDIT_CONTENT_WHEN_MOUSEOVER = By.xpath("//*[@class='uiIconEdit']");
	
	public final By ELEMENT_SELECT_ALL_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__selectall_icon']");
	public final By ELEMENT_SELECT_BOLD_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__bold_icon']");
	public final By ELEMENT_SELECT_BOLD_ICE_ON = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button cke_button__bold cke_button_on']");
	public final By ELEMENT_SELECT_CANCEL_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__cancelinline.btn_icon']");
	public final By ELEMENT_SELECT_ACCEPT_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__acceptinline.btn_icon']");
	public final By ELEMENT_SELECT_COPY_ICE =By.cssSelector("#cke_editor8 .cke_button__copy_icon");
	
	public final By ELEMENT_SELECT_ALL_WIND = By.xpath("//*[@id='cke_editor10']//*[contains(@class,'cke_button__selectall_icon')]");
	public final By ELEMENT_SELECT_BOLD_WIND = By.xpath("//*[@id='cke_editor10']//*[@class='cke_button_icon cke_button__bold_icon']");
	public final By ELEMENT_SELECT_BOLD_WIND_ON = By.xpath("//*[@id='cke_editor10']//*[@class='cke_button cke_button__bold cke_button_on']");
	public final By ELEMENT_SELECT_CANCEL_WIND = By.xpath("//*[@id='cke_editor10']//*[@class='cke_button_icon cke_button__cancelinline.btn_icon']");
	public final By ELEMENT_SELECT_ACCEPT_WIND = By.xpath("//*[@id='cke_editor10']//*[@class='cke_button_icon cke_button__acceptinline.btn_icon']");
	public final By ELEMENT_SELECT_COPY_WIND =By.cssSelector("#cke_editor10 .cke_button__copy_icon");
	
	
	/**
	 * Edit a content on acme page ( edit mode should be activate )
	 * @param title
	 */
	public void editContentByTitle(String title){
		info(ELEMENT_CONTENT_BY_TITLE.replace("{$title}",title));
		Actions builder = new Actions(driver); 
		waitForAndGetElement(ELEMENT_CONTENT_BY_TITLE.replace("{$title}",title));
		WebElement elem= waitForAndGetElement(ELEMENT_CONTENT_BY_TITLE.replace("{$title}",title));
		builder.moveToElement(elem, 5, 5).click().build().perform();
		
	}
	
}
