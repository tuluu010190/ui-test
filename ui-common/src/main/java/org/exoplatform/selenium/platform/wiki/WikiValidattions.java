package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiValidattions extends WikiLocators{
	
	/**
	 * constructor
	 * @param dr
	 */
	public WikiValidattions(WebDriver dr){
		this.driver=dr;
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

	/**
	 * Verify that a wiki page link is inserted to the page
	 * @param label
	 * @param tooltip
	 */
	public void verifyInsertedLinkIntoFrame(String label,String tooltip){
		WebElement e = waitForAndGetElement(ELEMENT_CONTENT_WIKI_FRAME,DEFAULT_TIMEOUT,1,2);
		driver.switchTo().frame(e);
		if(label!=null && label!="")
			waitForAndGetElement(By.linkText(label));
		if(tooltip!=null && tooltip!="")
			waitForAndGetElement(By.xpath("//*[@title='"+tooltip+"']"));
		switchToParentWindow();
	}

	/**
	 * Verify the alert message when editing same page
	 * @param status
	 * @param fullName
	 */
	public void verifyMessageWhenEditingSamePage(String status,String fullName){
		info("Verify the message");
		waitForAndGetElement(ELEMENT_WIKI_STATUS_EDITTING_SAME_PAGE
				.replace("$status",status)
				.replace("$fullName", fullName));
	}

	/**
	 * Verify Confirmation message
	 * @param mess
	 * @param isConfirm
	 */
	public void verifyWarningMessage(String mess){
		info("Verify that the warning message is shown");
		waitForAndGetElement(ELEMENT_MESSAGES_TEXT
				.replace("$mess",mess));
		Utils.pause(2000);
	}
	
	/**
	 * 
	 *Define effect types in Source Editor
	 */
	public enum effectTypes{
		Bold,Bullest_List,Number_List,Heading1,Heading3,Heading2,
		Heading5,Italic,Link,Strike,Underline;
	}
	

	/**
	 * Verify effects of Page's content
	 * @param type
	 */
	public void verifyEffectsPageContent(effectTypes type,String content) {
		switch(type){
		case Bold:
			info("Verify Bold effect");
			waitForAndGetElement(ELEMENT_EFFECT_BOLD.replace("$content",content));
			break;
		case Bullest_List:
			info("Verify Bullest list");
			waitForAndGetElement(ELEMENT_EFFECT_BULLET_LIST.replace("$content",content));
			break;
		case Number_List:
			info("Verify Number list");
			waitForAndGetElement(ELEMENT_EFFECT_NUMBER_LIST.replace("$content",content));
			break;
		case Heading1:
			info("Verify Heading1 effect");
			waitForAndGetElement(ELEMENT_EFFECT_HEADING_1.replace("$content",content));
			break;
		case Heading3:
			info("Verify Heading3 effect");
			waitForAndGetElement(ELEMENT_EFFECT_HEADING_3.replace("$content",content));
			break;
		case Heading2:
			info("Verify Heading3 effect");
			waitForAndGetElement(ELEMENT_EFFECT_HEADING_2.replace("$content",content));
			break;
		case Heading5:
			info("Verify Heading4 effect");
			waitForAndGetElement(ELEMENT_EFFECT_HEADING_5.replace("$content",content));
			break;
		case Italic:
			info("Verify Italic effect");
			waitForAndGetElement(ELEMENT_EFFECT_ITALIC.replace("$content",content));
			break;
		case Link:
			info("Verify Link effect");
			waitForAndGetElement(ELEMENT_EFFECT_LINK.replace("$content",content));
			break;
		case Strike:
			info("Verify Strike effect");
			waitForAndGetElement(ELEMENT_EFFECT_STRIKE.replace("$content",content));
			break;
		case Underline:
			info("Verify Underline effect");
			waitForAndGetElement(ELEMENT_EFFECT_UNDERLINE.replace("$content",content));
			break;
		}
	}

	/**
	 * Verify that Add page button isnot shown
	 */
	public void verifyNotShowAddPageBtn(){
		info("Verify that Add Page button isnot shown");
		waitForElementNotPresent(ELEMENT_ADD_PAGE_LINK);
		info("The button is not shown");
	}

	/**
	 * Verify the page isnot created and shown in the list
	 * @param title
	 */
	public void verifyNotTitleWikiPage(String title){
		info("Verify that the wiki page isnot created and shown in the list");
		waitForElementNotPresent(ELEMENT_WIKI_PAGE_LINK.replace("${pageTitle}",title));
		info("The wiki page isnot created successfully");
	}

	/**
	 * Verify that the page is shown detail
	 * @param pageName
	 * @param pageContent
	 */
	public void verifyPageContent(String pageName,String pageContent){
		info("Verify the page's name");
		waitForAndGetElement(ELEMENT_WIKI_HOME_PAGE_TITLE.replace("${title}",pageName));
		info("Verify the page's content");
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_PAGE.replace("$content",pageContent));
	}

	/**
	 * Verify that a table is added to the content of the page
	 */
	public void verifyTableInContentPage(int col,int row){
		info("Verify that the table is shown into the content of the page");
		waitForAndGetElement(ELEMENT_PAGE_CONTENT_TABLE_MODE);
		for(int i=1;i<=col;i++){
			info("A table is shown with the col:"+col);
			waitForAndGetElement(ELEMETN_PAGE_CONTENT_TABLE_COL_NUM
					.replace("$col",String.valueOf(col)));
		}
		for(int i=1;i<=row;i++){
			info("A table is shown with the row:"+row);
			waitForAndGetElement(ELEMETN_PAGE_CONTENT_TABLE_ROW_NUM
					.replace("$row",String.valueOf(row)));
		}
		info("A table isnot shown with the col:"+col+1);
		waitForElementNotPresent(ELEMETN_PAGE_CONTENT_TABLE_COL_NUM
				.replace("$col",String.valueOf(col+1)));
		info("A table isnot shown with the row:"+row+1);
		waitForElementNotPresent(ELEMETN_PAGE_CONTENT_TABLE_ROW_NUM
				.replace("$row",String.valueOf(row+1)));
	}

	/**
	 * Verify the page is created and shown in the list
	 * @param title
	 */
	public void verifyTitleWikiPage(String title){
		info("Verify that the wiki page is created and shown in the list");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_LINK.replace("${pageTitle}",title));
		info("The wiki page is created successfully");
	}
	/**
	 * Verify that Draft changes page is shown
	 * when click [View Draft changes] link on status
	 */
	public void verifyTitleDraftChangesPage(){
		info("Verify that Draf changes page is shown");
		waitForAndGetElement(ELEMETN_WIKI_DRAFT_CHANGES_PAGE_TITLE);
	}

	/**
	 * Verify alt Text of image is changed
	 * @param altText
	 */
	public void verifyAltTextImageInContentPage(String altText){
		info("Verify that alt text is changed");
		waitForAndGetElement(ELEMENT_INSERTED_IMAGE_ALT_TEXT
				.replace("$alt", altText));
	}

	/**
	 * Check versions on Compare version page
	 * @param oldVersion
	 */
	public void verifyCompareVersions(String oldVersion){
		info("The compare version page is shown");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_COMPARE_VERSION_TITLE);
		info("Verify that Version N-1 and current version is shown on the page");
		waitForAndGetElement(ELEMENT_COMPARE_VERSION_VERSION_NUMBER.replace("$num",oldVersion));
		waitForAndGetElement(ELEMENT_COMPARE_VERSION_CURRENT_VERSION);
	}

	/**
	 * Verify the content of a page after created successfully
	 * @param content
	 */
	public void verifyContentPage(String content){
		info("Verify that the content page is added successfully");
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_PAGE
				.replace("$content",content));
		info("The content also is added successfully");
	}

	/**
	 * Verify draf in out date version status
	 * with text: "Your version is outdated, a version of this content has been updated by another user.
	    		You can [view your changes] and [Continue Editing] or [delete] your draft."
	 * @param message
	 */
	public void verifyDraftInOutDateVersionStatus(String message){
		info("Verify status text");
		waitForAndGetElement(ELEMETN_WIKI_STATUS_VERSION_TEXT
				.replace("$status",message));
		info("Verify status with View Changes link");
		waitForAndGetElement(ELEMENT_WIKI_STATUS_VERSION_VIEW_CHANGES_LINK);
		info("Verify status with Continue Editting link");
		waitForAndGetElement(ELEMENT_WIKI_STATUS_VERSION_CONTINUE_EDITTING_LINK);
		info("Verify status with Delete link");
		waitForAndGetElement(ELEMENT_WIKI_STATUS_VERSION_DELETE_LINK);
	}

	/**
	 * Verify email format of the email link after inserted a email link to the page
	 * @param address
	 */
	public void verifyEmailFormatLink(String address){
		info("Verify that email format of the link is correct");
		waitForAndGetElement(ELEMENT_EMAIL_LINK_EMAIL_FORMAT.replace("$email",address));
	}

	/**
	 * The page's content is empty
	 */
	public void verifyEmptyContentPage(){
		info("Verify that the content page is empty");
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_PAGE_EMPTY,2000,1,2);
		info("the page's content is empty");
	}

	/**
	 * Verify that the system redirects to the wiki page link that is inserted
	 * @param label
	 * @param pageLink
	 */
	public void verifyInsertedExistLink(String label,String pageLink){
		info("The page link is shown");
		waitForAndGetElement(ELEMENT_TITLE_INFO.replace("${title}", pageLink));
	}

	/**
	 * Verify that the system redirects to the wiki page that is created
	 * @param label
	 * @param pageLink
	 */
	public void verifyInsertNewLink(String label,String pageLink){
		info("The page link is shown");
		String actualTitle = this.driver.findElement(ELEMENT_TITLE_WIKI_INPUT).getAttribute("value").toString();
		if(actualTitle.contains(pageLink))
			assert true;
		else assert false;
	}

	/**
	 * Verify the size of the image in the page's content
	 * @param width
	 * @param height
	 */
	public void verifySizeImageInContentPage(String width,String height){
		info("Verify that the size of image is changed");
		waitForAndGetElement(ELEMENT_INSERTED_IMAGE_SIZE
				.replace("$width", width)
				.replace("$height", height));
	}

	/**
	 * Verify status when edit a page that has existing a draf
	 * @param message
	 */
	public void verifyStatusWhenEditPageHasExistingDraf(String message,String date){
		info("Verify status text");
		waitForAndGetElement(ELEMETN_WIKI_STATUS_VERSION_TEXT
				.replace("$status",message)
				.replace("$date",date));
		info("Verify status with View Changes link");
		waitForAndGetElement(ELEMENT_WIKI_STATUS_VERSION_VIEW_CHANGES_LINK);
		info("Verify status with Resume the draf link");
		waitForAndGetElement(ELEMENT_WIKI_STATUS_RESUME_THE_DRAF_LINK);
		info("Verify status with Delete link");
		waitForAndGetElement(ELEMENT_WIKI_STATUS_VERSION_DELETE_LINK);
	}
}
