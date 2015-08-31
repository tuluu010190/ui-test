package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;

public class WikiDraftPage extends WikiLocators{
	ManageAlert magAl;
	
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
	/**
	 * Verify a draf page
	 * @param title
	 */
	public void verifyTitleDrafPage(String title){
		info("Verify that a draf page with the title:"+title+" is shown in draf table");
		waitForAndGetElement(ELEMENT_DRAFT_OF_NEW_PAGE.replace("${title}",title));
	}
	/**
	 * Verify that Draf page is not shown
	 * @param title
	 */
	public void verifyNotTitleDrafPage(String title){
		info("Verify that a draf page with the title:"+title+" is shown in draf table");
		waitForElementNotPresent(ELEMENT_DRAFT_OF_NEW_PAGE.replace("${title}",title));
	}
	/**
	 * Verify resuming a draf page
	 * @param titleBeforeDraf
	 */
	public void verifyResumADraf(String titleBeforeDraf){
		info("Get current title in iput field");
		String currentTitle =this.driver.findElement(ELEMENT_TITLE_WIKI_INPUT).getAttribute("value").toString();
		if(currentTitle.contains(titleBeforeDraf))
			assert true;
		else assert false;
	}
}
