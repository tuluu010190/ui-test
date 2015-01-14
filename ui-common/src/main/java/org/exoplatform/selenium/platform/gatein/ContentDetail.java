package org.exoplatform.selenium.platform.gatein;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentDetail extends PlatformBase {
	
	// Edit popup
	final public By ELEMENT_CONTENT_DETAIL_EDIT_BTN = By.xpath("//*[@class='uiIconEdit uiIconWhite']");
	final public By ELEMENT_CONTENT_DETAIL_SAVE_BTN = By.xpath("//*[@class='btn' and text()='Save']");
	final public By ELEMENT_CONTENT_DETAIL_CLOSE_BTN = By.id("Close");
	final public By ELEMENT_CONTENT_DETAIL_ADDPATH_BTN = By.xpath("//*[@class='uiIconAddPath uiIconLightGray']");
	final public By ELEMENT_CONTENT_DETAIL_BY_CONTENT_MODE = By.xpath("//*[@class='radio' and @value='ManualViewerMode']");
	
	//Select Content popup
	final public String ELEMENT_SELECT_CONTENT_POPUP_NODE_FOLDER= ".//span[contains(text(),'${node}')]";
	final public String ELEMENT_SELECT_CONTENT_POPUP_FILE= ".//*[@id='ListRecords']//*[contains(text(),'${content}')]";
	final public By ELEMENT_SELECT_CONTENT_POPUP_SAVE_BTN=By.xpath(".//*[@id='tab-UIContentBrowsePanelMulti']//button[text()='Save']");

	//View content
	final public String ELEMENT_CONTENT_DETAIL_VIEW_CONTENT=".//h4[text()='${title}']";
	final public String ELEMENT_CONTENT_DETAIL_CONTENT_BOX_CONTENT_TITLE = "//*[@class='title']//*[text()='${title}']";
	final public By ELEMENT_CONTENT_DETAIL_CONTENT_BOX = By.xpath("//*[@class='uiContentBox']"); 
	final public String ELEMENT_CONTENT_DETAIL_CONTENT_BOX_PREFERENCES_BTN = ".//*[@class='webContentContainer']//*[contains(text(),'${title}')]/../../..//*[@data-original-title='Preferences']";
	
	public ContentDetail(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * Select a folder or a content or both in Multiple Content Selector Pane popup
	 * @param arrayPath
	 * @param content
	 */
	public void selectFolderContent(String path, String content) {
		waitForAndGetElement(ELEMENT_CONTENT_DETAIL_ADDPATH_BTN);
		click(ELEMENT_CONTENT_DETAIL_ADDPATH_BTN);
		Utils.pause(2000);
		String[] arrayPath = path.split("/");
		for (String arrayElement : arrayPath) {
			click(ELEMENT_SELECT_CONTENT_POPUP_NODE_FOLDER.replace("${node}", arrayElement));
		}
		if (content != "" || content != null) {
			waitForAndGetElement(ELEMENT_SELECT_CONTENT_POPUP_FILE.replace("${content}", content));
			click(ELEMENT_SELECT_CONTENT_POPUP_FILE.replace("${content}", content));
		}
		Utils.pause(2000);
	}
		
}
