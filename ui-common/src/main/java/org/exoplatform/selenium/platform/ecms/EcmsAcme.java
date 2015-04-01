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
	public final String ELEMENT_CONTENT_BY_TITLE_TEXT_STRONG = ".//*[@class='media-body']//*[@title='{$title}']/../../..//div[@class='summary']/div[contains(@class,'WCMInlineEditable')]/p/strong";
	public final By ELEMENT_EDIT_CONTENT_WHEN_MOUSEOVER = By.xpath("//*[@class='uiIconEdit']");
	
	public final By ELEMENT_SELECT_ALL_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__selectall_icon']");
	public final By ELEMENT_SELECT_BOLD_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__bold_icon']");
	public final By ELEMENT_SELECT_BOLD_ICE_ON = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button cke_button__bold cke_button_on']");
	public final By ELEMENT_SELECT_CANCEL_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__cancelinline.btn_icon']");
	public final By ELEMENT_SELECT_ACCEPT_ICE = By.xpath("//*[@id='cke_editor8']//*[@class='cke_button_icon cke_button__acceptinline.btn_icon']");
	
	/**
	 * Edit a content on acme page ( edit mode should be activate )
	 * @param title
	 */
	public void editContentByTitle(String title){
		info(ELEMENT_CONTENT_BY_TITLE.replace("{$title}",title));
		Actions builder = new Actions(driver); 
		waitForAndGetElement(By.xpath(ELEMENT_CONTENT_BY_TITLE.replace("{$title}",title)));
		WebElement elem= waitForAndGetElement(By.xpath(ELEMENT_CONTENT_BY_TITLE.replace("{$title}",title)));
		builder.moveToElement(elem, 5, 5).click().build().perform();
		
	}
	
}
