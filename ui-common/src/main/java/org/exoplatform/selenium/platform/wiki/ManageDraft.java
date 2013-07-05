package org.exoplatform.selenium.platform.wiki;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;

/**
 * @date: July 2013
 * @author lientm
 *
 */
public class ManageDraft extends RichTextMode {
	ManageAlert magAl;
	
	public By ELEMENT_DRAFT_NOTIFY = By.xpath("//*[@class='uiWikiPageEditForm_MessageArea pull-left' and contains(text(), 'Draft saved at')]");
	
	//Manage Draft screen
	public String ELEMENT_DRAFT_OF_NEW_PAGE = "//*[@id='UIWikiDraftGrid']//*[text()='${title} (New Page)']";
	public String ELEMENT_DELETE_DRAFT = "//*[contains(text(), '${title}')]/../../..//*[@class='uiIconDeleteDraft']";
	public String ELEMENT_DRAFT_OF_EDIT_PAGE = "//*[@id='UIWikiDraftGrid']//*[text()='${title}']";
	
	public void goToManageDraft(){
		mouseOverAndClick(ELEMENT_BROWSE_LINK);
		mouseOverAndClick(ELEMENT_MY_DRAFT);
		Utils.pause(1000);
	}
	
	public void deleteDraft(String title){
		magAl = new ManageAlert(driver);
		click(ELEMENT_DELETE_DRAFT.replace("${title}", title));
		magAl.acceptAlert();
		waitForElementNotPresent(ELEMENT_DELETE_DRAFT.replace("${title}", title));
	}
}
