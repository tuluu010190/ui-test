package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiDraftPage extends PlatformBase{
	ManageAlert magAl;
	
	//Manage Draft screen
	public String ELEMENT_DRAFT_OF_NEW_PAGE = "//*[@id='UIWikiDraftGrid']//*[contains(text(),'${title} (New Page)')]";
	public String ELEMENT_DELETE_DRAFT = ".//*[@id='UIWikiDraftGrid']//*[contains(text(),'${title}')]/../../..//*[@class='uiIconDeleteDraft uiIconLightGray']";
	public String ELEMENT_DRAFT_OF_EDIT_PAGE = "//*[@id='UIWikiDraftGrid']//*[text()='${title}']";
	public By ELEMENT_DRAFT_CONFIRM_POPUP = By.xpath("//div[@class='confirmMessage' and contains(text(), 'The draft has been created. Do you want to keep it?')]");
	public By ELEMENT_DRAFT_NO_BUTTON = By.xpath("//*[contains(text(),'No')]");
	public String ELEMENT_DRAFT_TITLE = "//*[contains(text(), '${title}')]";

	/**
	 * constructor
	 * @param dr
	 */
	ManageAlert alert;
	public WikiDraftPage(WebDriver dr){
		alert = new ManageAlert(dr);
		this.driver=dr;
	}
	
	/**
	 * Deletes a draft.
	 * 
	 * 
	 * @param title The title of a wiki's page to be deleted.
	 */
	public void deleteDraft(String title){
		click(ELEMENT_DELETE_DRAFT.replace("${title}", title));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_DELETE_DRAFT.replace("${title}", title));
	}
	/**
	 * resume a draft
	 * @param title
	 */
	public void resumeADraft(String title){
		info("Click on the title of the draf in the list");
		waitForAndGetElement(ELEMENT_DRAFT_OF_NEW_PAGE.replace("${title}", title),3000,0).click();
	    Utils.pause(3000);
	}
}
