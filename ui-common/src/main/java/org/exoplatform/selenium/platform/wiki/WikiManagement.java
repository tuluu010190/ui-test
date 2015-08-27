package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import java.io.File;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.exoplatform.selenium.Button;

public class WikiManagement extends WikiLocators{

	ManageAlert alert;
	Button but ;
	/**
	 * constructor
	 * @param dr
	 */
	public WikiManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(dr);
		but = new Button(dr);
	}

	/**
	 * Select template to create page
	 */
	public void selectTemplateWikiPage(String template){
		info("--Select a template--");
		waitForAndGetElement(ELEMENT_TEMPLATE_SELECT_FORM);
		By eTemplate = By.xpath(ELEMENT_SELECT_TEMPLATE_LINK.replace("${template}",template));
		info("eTemplate:"+eTemplate.toString());
		click(eTemplate, 2,true);
	}

	/**
	 * Change to Source Editor mode
	 */
	public void goToSourceEditor(){
		if(waitForAndGetElement(ELEMENT_SOURCE_EDITOR_BUTTON,5000,0)!=null){
			info("Go to Source Editor");
			click(ELEMENT_SOURCE_EDITOR_BUTTON,0,true);	
		}
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT);
	}

	/**
	 * Change to Rich Text Mode
	 */
	public void goToRichTextEditor(){
		if(waitForAndGetElement(ELEMENT_RICHTEXT_BUTTON,5000,0)!=null){
			info("Go to Rich Text Mode");
			click(ELEMENT_RICHTEXT_BUTTON,0,true);	
		}
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_FRAME);
	}

	/**
	 * Modify Wiki content with Source editor
	 * 
	 * 
	 * @param title
	 * 			updated title of the wiki page. Can not be <code>null</code>
	 * @param content
	 * 			updated content of the wiki page. Can not be <code>null</code>
	 * 
	 */
	public void inputDataToPageSourceEditor(String title, String content, Boolean isClearTitle, Boolean isClearContent){
		goToSourceEditor();
		String[] text ;
		info("Modify data with source editor");
		if(title != null){
			if(isClearTitle)
				type(ELEMENT_TITLE_WIKI_INPUT, title, true);
			else
				type(ELEMENT_TITLE_WIKI_INPUT, title, false);
		}	
		if(content != null){
			if(isClearContent){
				waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).clear();
				text = content.split("</br>");
				for(int i=0; i < text.length; i++){
					type(ELEMENT_CONTENT_WIKI_INPUT,text[i],false);
					waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).sendKeys(Keys.ENTER);
				}
			}
			else{
				text = content.split("</br>");
				for(int i=0; i < text.length; i++){
					type(ELEMENT_CONTENT_WIKI_INPUT,text[i],false);
					waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).sendKeys(Keys.ENTER);
				}
			}
		}
		Utils.pause(2000);
	}

	/**
	 * Modify Wiki content with rich text
	 * 
	 * 
	 * @param title
	 * 			updated title of the wiki page. Can not be <code>null</code>
	 * @param content
	 * 			updated content of the wiki page. Can not be <code>null</code>
	 * 
	 */
	public void inputDataToPageRichText(String title, String content, Boolean isClearTitle, Boolean isClearContent){
		goToRichTextEditor();
		if(title != null){
			if(isClearTitle)
				type(ELEMENT_TITLE_WIKI_INPUT, title, true);
			else
				type(ELEMENT_TITLE_WIKI_INPUT, title, false);
		}
		if (content != null){
			if(isClearContent){
				inputDataToCKEditor(ELEMENT_CONTENT_WIKI_FRAME, content);
			}
			else{
				inputDataToCKEditor(ELEMENT_CONTENT_WIKI_FRAME, content);
			}
			Utils.pause(1000);
			driver.switchTo().defaultContent();
		}
		click(ELEMENT_SAVE_BUTTON_ADD_PAGE);
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON_ADD_PAGE);
	}


	/**
	 * Edit a simple wiki page with rich editor
	 * 
	 * @param newTitle
	 *            updated title of the wiki page. Can not be <code>null</code>
	 * @param newContent
	 *            updated content of the wiki page. Can not be <code>null</code>
	 */
	public void editSimplePageWithRichText(String newTitle,String newContent){
		goToRichTextEditor();
		info("Input a new title for the page");
		if(!newTitle.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, newTitle, true);
		info("Input a new content for the page");
		if(!newContent.isEmpty()){
			inputFrame(ELEMENT_CONTENT_WIKI_FRAME, newContent);
		}
	}
	/**
	 * Edit a wiki page with auto save status
	 * @param newTitle
	 * @param newContent
	 */
	public void editSimplePageWithAutoSave(String newTitle, String newContent){
		info("Input a title for the page");
		goToSourceEditor();
		String[] text ;
		if(!newTitle.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, newTitle,true);
		info("Input a content for the page");
		if(!newContent.isEmpty()){
			text = newContent.split("</br>");
			for(int i=0; i < text.length; i++){
				type(ELEMENT_CONTENT_WIKI_INPUT,text[i],false);
				waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).sendKeys(Keys.ENTER);
			}
		}
		info("Waiting 30s before saved all changes");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_TOOL_BAR_AUTO_SAVE_TEXT,31000,0);
	}

	/**
	 * Add a simple wiki page with source editor
	 * @param title
	 * @param content
	 */
	public void addSimplePageWithSourceEditor(String title, String content){
		info("Input a title for the page");
		goToSourceEditor();
		String[] text ;
		if(!title.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, title,true);
		info("Input a content for the page");
		if(!content.isEmpty()){
			text = content.split("</br>");
			for(int i=0; i < text.length; i++){
				type(ELEMENT_CONTENT_WIKI_INPUT,text[i],false);
				waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).sendKeys(Keys.ENTER);
			}
		}
	}

	/**
	 * Add a simple wiki page with rich text
	 * 
	 * @param title
	 *            updated title of the wiki page. Can not be <code>null</code>
	 * @param content
	 *            updated content of the wiki page. Can not be <code>null</code>
	 */
	public void addSimplePageWithRichText(String title, String content){
		goToRichTextEditor();
		info("Input a title for the page");
		if(!title.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, title, true);
		info("Input a content for the page");
		if(!content.isEmpty()){
			inputFrame(ELEMENT_CONTENT_WIKI_FRAME, content);
		}
	}
	/**
	 * Add a content for a wiki page
	 * @param content
	 */
	public void addContentPage(String content){
		info("Input a content for the page");
		if(!content.isEmpty())
			inputFrame(ELEMENT_CONTENT_WIKI_FRAME, content);
		Utils.pause(2000);
	}
	/**
	 * Verify the content of a page after created successfully
	 * @param content
	 */
	public void verifyContentPage(String content){
		info("Verify that the content page is added successfully");
		waitForAndGetElement(ELMEENT_CONTENT_wiki_PAGE
				.replace("$content",content));
		info("The content also is added successfully");
	}
	/**
	 * Add a page with checking auto save after 30s
	 * @param title
	 * @param content
	 */
	public void addSimplePageWithAutoSaveStatus(String title, String content){
		info("Input a title for the page");
		goToSourceEditor();
		String[] text ;
		if(!title.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, title,true);
		info("Input a content for the page");
		if(!content.isEmpty()){
			text = content.split("</br>");
			for(int i=0; i < text.length; i++){
				type(ELEMENT_CONTENT_WIKI_INPUT,text[i],false);
				waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).sendKeys(Keys.ENTER);
			}
		}
		info("Waiting 30s before saved all changes");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_TOOL_BAR_AUTO_SAVE_TEXT,31000,1);
		info("Save all changes");
		saveAddPage();
		info("Wiki page simple is created successfully");

	}

	/**
	 * Add a new page that has auto save without save
	 * @param title
	 * @param content
	 */
	public void addSimplePageHasAutoSaveWithoutSave(String title, String content){
		info("Input a title for the page");
		goToSourceEditor();
		String[] text ;
		if(!title.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, title,true);
		info("Input a content for the page");
		if(!content.isEmpty()){
			text = content.split("</br>");
			for(int i=0; i < text.length; i++){
				type(ELEMENT_CONTENT_WIKI_INPUT,text[i],false);
				waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).sendKeys(Keys.ENTER);
			}
		}
		info("Waiting 30s before saved all changes");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_TOOL_BAR_AUTO_SAVE_TEXT,31000,1);
		info("Cancel adding page");
		click(ELEMENT_CANCEL_BUTTON_ADD_PAGE,0,true);
		click(ELEMENT_CONFIRMATION_POPUP_YES_BTN);
		Utils.pause(2000);
	}


	/**
	 * Edit a simple wiki page with source editor
	 * @param newTitle
	 * @param newContent
	 */
	public void editSimplePageWithSourceEditor(String newTitle, String newContent){
		info("Input a title for the page");
		goToSourceEditor();
		String[] text ;
		if(!newTitle.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, newTitle, true);
		info("Input a content for the page");
		if(!newContent.isEmpty()){
			waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).clear();
			text = newContent.split("</br>");
			for(int i=0; i < text.length; i++){
				type(ELEMENT_CONTENT_WIKI_INPUT,text[i],false);
				waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT).sendKeys(Keys.ENTER);
			}
		}

	}

	/**
	 * Save add page
	 */
	public void saveAddPage(){
		info("Save all changes");
		click(ELEMENT_SAVE_BUTTON_ADD_PAGE);
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON_ADD_PAGE);
		info("Wiki page simple is created successfully");
	}

	/**
	 * Cancel add page
	 */
	public void cancelAddPage(){
		click(ELEMENT_CANCEL_BUTTON_ADD_PAGE,0,true);
		waitForElementNotPresent(ELEMENT_CANCEL_BUTTON_ADD_PAGE);
	}

	/**
	 * publish page
	 */
	public void publishPage(){
		info("check on publish checkbox");
		check(ELEMENT_PUBLISH_ACTIVITY_CHECKBOX, 2);
		Utils.pause(2000);
	}

	/**
	 * unpublish page
	 */
	public void unPublishPage(){
		uncheck(ELEMENT_PUBLISH_ACTIVITY_CHECKBOX, 2);
		Utils.pause(2000);
	}

	/**
	 * Go to Preview Page
	 */
	public void goToPreviewPage(){
		click(ELEMENT_PREVIEW_BUTTON);
		waitForAndGetElement(ELEMENT_PREVIEW_SCREEN);
	}

	/** 
	 * Attach a file to a Wiki page
	 * 
	 * @param link
	 * 			link of file that will be attached
	 */
	/** 
	 * Attach a file to a Wiki page
	 * 
	 * @param link
	 * 			link of file that will be attached
	 * @param type
	 * 			optional parameter of this method.
	 */
	public void attachFileInWiki(String link ){
		String fs = File.separator;
		WebElement elem = waitForAndGetElement(ELEMENT_UPLOAD_NAME,5000,1,2);
		scrollToElement(elem, driver);
		click(elem,2,true);
		uploadFileUsingRobot(link);
		waitForAndGetElement(By.linkText(link.substring(link.lastIndexOf(fs)+1)));
	}


	/**
	 * Attach many files to a wiki page
	 */
	public void attachMultiFileInWiki(String link){
		String[] upload = link.split(";");
		for (int i = 0; i < upload.length; i++){
			attachFileInWiki("TestData/" + upload[i]);
		}
	}
	/**
	 * Edit paragraph in a Wiki page
	 * 
	 * 
	 * @param paragraphTitle
	 * 				input paragraph title without space character.  Can not be <code>null</code>.
	 * @param paragraphContent
	 * 				input paragraph content with heading followed help tips.  Can not be <code>null</code>.
	 * 
	 */
	public void editParagraph (String paragraphTitle, String paragraphContent) {
		info("-- Editing a paragraph... " + paragraphTitle);
		String ELEMENT_PARAGRAPH_ID = "H"+paragraphTitle;
		mouseOver(By.id(ELEMENT_PARAGRAPH_ID), true);
		WebElement element = waitForAndGetElement(By.xpath("//*[@data-original-title='Edit Section: " + paragraphTitle + "']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Utils.pause(500);
		driver.navigate().refresh();
		Utils.pause(2000);
		type(ELEMENT_CONTENT_WIKI_INPUT, paragraphContent, true);
		switchToParentWindow();
	}
	/**
	 * input a comment to new wiki page
	 * @param comment
	 */
	public void addComment(String comment){
		info("Input a comment to wiki page");
		type(ELEMENT_WIKI_PAGE_INPUT_COMMENT,comment,true);
	}
	/**
	 * Move page 1 to page 2
	 * @param page1
	 * @param page2
	 */
	public void movePage(String page1, String page2){
		info("Open a wiki page 1");
		waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",page1),2000,0).click();
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on Move page link");
		if (waitForAndGetElement(ELEMENT_MOVE_PAGE, 5000, 0) == null){
			mouseOverAndClick(ELEMENT_MOVE_PAGE);
		}else {
			click(ELEMENT_MOVE_PAGE);
		}
		info("Move page popup is shown");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_MOVE_POPUP_NODE.replace("${name}", page2),2000,0).click();
		waitForAndGetElement(ELEMENT_WIKI_PAGE_MOVE_POPUP_SAVE,2000,0).click();
		waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",page1),2000);
		info("The page 1 is moved to page 2");
	}
	/**
	 * Move a page1 of destination 1 to a page 2 of destination 2
	 * @param page1
	 * @param page2
	 * @param locator
	 */
	public void movePageDiffDestination(String page1, String page2, String locator){
		info("Open a wiki page 1");
		waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",page1),2000,0).click();
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on Move page link");
		if (waitForAndGetElement(ELEMENT_MOVE_PAGE, 5000, 0) == null){
			mouseOverAndClick(ELEMENT_MOVE_PAGE);
		}else {
			click(ELEMENT_MOVE_PAGE);
		}
		info("Move page popup is shown");
		info("Click on Drop down");
		waitForAndGetElement(ELEMENT_MOVE_SPACESWITCHER,2000,0).click();
		info("Select a location");
		click(ELEMENT_MOVE_PAGE_POPUP_DROP_DOWN_LOCATOR.replace("${locator}",locator));
		info("Select a page in the list");
		waitForAndGetElement(ELEMENT_MOVE_PAGE_POPUP_DROP_DOWN_LOCATOR.replace("${locator}",page2),2000,0).click();
		info("Save all changes");
		waitForAndGetElement(ELEMENT_MOVE_BTNMOVE,2000,0).click();

	}
	/**
	 * Open information table
	 * @param page
	 * @param version
	 */
	public void viewInformationTable(String page, String version){
		info("Open a wiki page 1");
		waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",page),2000,0).click();
		info("Open information table");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_INFOMATION_VERSION.replace("${version}", version),2000,0).click();
		info("Verify that the table is shown");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_INFORMATION_TABLE_TITLE,2000,0);
	}
	/**
	 * Open page info
	 * @param page
	 */
	public void viewPageInfo(String page){
		info("Open a wiki page 1");
		waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",page),2000,0).click();
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on Page Info link");
		if (waitForAndGetElement(ELEMENT_PAGE_INFO, 5000, 0) == null){
			mouseOverAndClick(ELEMENT_PAGE_INFO);
		}else {
			click(ELEMENT_PAGE_INFO);
		}
		info("The page info is shown");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_PAGE_INFO_TITLE,2000,0);
	}
	/**
	 * Open Page History
	 */
	public void openPageHistory(){
		info("Click on View page info button");
		waitForAndGetElement(ELEMENT_PAGE_INFO_VIEW_PAGE_INFO_BTN,2000,0).click();
		info("Page history is shown");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_PAGE_HISTORY_TITLE,2000,0);
	}
	/**
	 * Compare 2 reversion
	 * @param reversion1
	 * @param reversion2
	 */
	public void compareTwoReversion(String reversion1, String reversion2){
		info("Select reversion 1");
		check(ELEMENT_WIKI_PAGE_PAGE_HISTORY_CHECKBOX.replace("${reversion}",reversion1),2);
		info("Select reversion 2");
		check(ELEMENT_WIKI_PAGE_PAGE_HISTORY_CHECKBOX.replace("${reversion}",reversion2),2);
		info("Click on Compare button");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_PAGE_HISTORY_COMPARE_BTN,2000,0).click();
		info("Compare reversion page is shown");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_COMPARE_REVERSION_TITLE,2000,0);

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
	 * Delete an attachment file
	 */
	public void deleteAttachmentFile(){
		info("Click on detele button");
		click(ELEMENT_PAGE_DELETEATTACHFILE);
		info("Verify that the file is removed");
		waitForElementNotPresent(ELEMENT_PAGE_DOWNLOADATTACHFILE);
	}
	/**
	 * Open add related page popup
	 */
	public void openAddRelationsPopup(){
		info("Click on Add more relations");
		waitForAndGetElement(ELEMENT_PAGE_INFO_ADD_MORE_RELATIONS,2000,0).click();
		waitForAndGetElement(ELEMENT_ADD_RELATED_PAGE_POPUP_TITLE,200,0);
		info("Add related page popup is shown");
	}
	/**
	 * Check options in Add Relations drop down list
	 * @param spaces
	 */
	public void checkAddRelationDropDownList(String spaces){
		info("Click on Drop down");
		waitForAndGetElement(ELEMENT_ADD_RELATED_PAGE_POPUP_DROPDOWN,2000,0).click();
		info("Verify that Intranet location is shown is the list");
		waitForAndGetElement(ELEMENT_ADD_RELATED_POPUP_DROPDOWN_LOCATION.replace("${location}","Intranet"),2000,0);
		info("Verify that My wiki location is shown is the list");
		waitForAndGetElement(ELEMENT_ADD_RELATED_POPUP_DROPDOWN_LOCATION.replace("${location}","My Wiki"),2000,0);
		if (!spaces.isEmpty()) {
			String[] arraySpace = spaces.split("/");
			for(String space:arraySpace){
				info("Verify that "+space+" location is shown is the list");
				waitForAndGetElement(
						ELEMENT_ADD_RELATED_POPUP_DROPDOWN_LOCATION.replace(
								"${location}",space), 2000, 0);
			}

		}
		waitForAndGetElement(ELEMENT_SPACE_SWITHCHER_DROPDOWN_CLOSE,2000,0).click();
		info("All options are checked");
	}
	/**
	 * Add a relation to a page
	 * @param location
	 * @param page
	 */
	public void addRelations(String location,String page){
		info("Click on Drop down");
		waitForAndGetElement(ELEMENT_ADD_RELATED_PAGE_POPUP_DROPDOWN,2000,0).click();
		info("Select a location");
		click(ELEMENT_ADD_RELATED_POPUP_DROPDOWN_LOCATION.replace("${location}",location));
		info("Select a page in the list");
		waitForAndGetElement(ELEMENT_ADD_RELATED_POPUP_CONTENT.replace("${page}",page),2000,0).click();
		info("Save all changes");
		waitForAndGetElement(ELEMENT_ADD_RELATED_POPUP_SELECT_BTN,2000,0).click();
	}


	/**
	 * Delete a relation of a page
	 * @param relation
	 */
	public void deleteRelation(String relation){
		info("Click on Delete button");
		waitForAndGetElement(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN.replace("${name}",relation),2000,0);
		click(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN.replace("${name}",relation));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN.replace("${name}",relation));
		info("The relation is deleted");
	}
	/**
	 * Add a simple wiki page by template format
	 * @param template
	 */
	public void addSimpleWikiPageByTemplate(String template,String newTitle){
		info("Select a template");
		selectTemplateWikiPage(template);
		click(ELEMENT_TEMPLATE_SELECT_BTN);
		if(!newTitle.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, newTitle, true);
		Utils.pause(2000);
		info("Save all changes");
		saveAddPage();
	}

	/**
	 * Add a simple wiki page with template with auto save status
	 * @param template
	 */
	public void addSimplePageByTemplateWithAutoSave(String template,String newTitle){
		info("Select a template");
		selectTemplateWikiPage(template);
		click(ELEMENT_TEMPLATE_SELECT_BTN);
		Utils.pause(2000);
		if(!newTitle.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, newTitle, true);
		info("Waiting 30s before saved all changes");
		waitForAndGetElement(ELEMENT_WIKI_PAGE_TOOL_BAR_AUTO_SAVE_TEXT,31000,0);
		info("Save all changes");
		saveAddPage();
	}
	/**
	 * Preview a template
	 * @param template
	 */
	public void previewATemplate(String template){
		info("Preview the template");
		click(ELEMENT_TEMPLATE_PREVIEW_BTN.replace("${template}",template));
		info("Verify that the layout is shown");
		waitForAndGetElement(ELEMENT_PREVIEW_TEMPLATE_CONTENT.replace("${template}",template),2000,0);
		click(ELEMENT_TEMPLATE_PREVIEW_PAGE_CLOSE_BTN);
		Utils.pause(2000);
		click(ELEMENT_TEMPLATE_CANCEL_BTN);
		Utils.pause(2000);
	}
	/**
	 * Rename the title of the page by double-click on the title field
	 * @param title
	 * @param newTitle
	 */
	public void renamePageByDoubleClick(String title,String newTitle){
		info("Open the page");
		Actions action = new Actions(this.driver);
		action.doubleClick(waitForAndGetElement(ELEMENT_PAGE_TITLE.replace("${title}", title),2000,0)).perform();
		type(ELEMENT_WIKI_PAGE_TITLE_RENAME_FIELD,newTitle,true);
		Actions actionEnter = new Actions(this.driver);
		actionEnter.sendKeys(Keys.ENTER).perform();
		actionEnter.release();
		Utils.pause(20000);
	}
	/**
	 * Watch a page
	 */
	public void watchAPage(String mess){
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on watch link");
		click(ELEMENT_WATCH_LINK);
		info("Show message :'You started watching this page now.'");
		waitForAndGetElement(ELEMENT_POPUP_MESSAGE_CONTENT.replace("${message}",mess),2000,0);
		click(ELEMENT_BTN_OK);
		Utils.pause(2000);
	}

	/**
	 * un-Watch a page
	 */
	public void unWatchAPage(String mess){
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on watch link");
		click(ELEMENT_UNWATCH_LINK);
		info("Show message : 'You stopped watching this page now.'");
		waitForAndGetElement(ELEMENT_POPUP_MESSAGE_CONTENT.replace("${message}",mess),2000,0);
		click(ELEMENT_BTN_OK);
		Utils.pause(2000);
	}

	/**
	 * function: check content of mail then delete mail
	 * @param title title of the page
	 */
	public void checkEmailNotification(String title){
		info("Check and delete mail");

		for(String windowHandle  : driver.getWindowHandles()){
			driver.switchTo().window(windowHandle);
			info("driver.title:"+driver.getTitle());
		}
		waitForAndGetElement(ELEMENT_GMAIL_CONTENT_WIKI.replace("${title}",title),30000,0);
		info("Found notify mail");

		info("ELEMENT_GMAIL_CONTENT:"+ELEMENT_GMAIL_CONTENT_WIKI.replace("${title}",title));
		info("Open email");
		waitForAndGetElement(ELEMENT_GMAIL_CONTENT_WIKI.replace("${title}",title)).click();
		String defaultLink = baseUrl+"/intranet/wiki/"+title;
		//Store childs and parent windows
		Object[] allWindows =driver.getWindowHandles().toArray();
		//Get parent window
		String paWindow=allWindows[0].toString();
		//Get child window 1. Here is gmail browser
		String chilwindow1=allWindows[1].toString();
		//Get child window 2. Here is last child window when click on subtitle of email notification
		String chilwindow2=allWindows[2].toString();
		//Focus on Child window2
		driver.switchTo().window(chilwindow2);
		info("Verify that the link is shown as correct format:");
		click(ELEMENT_GMAIL_PREVIOUS_EMAIL);
		info("Check the link's format");
		String link = waitForAndGetElement(ELEMENT_GMAIL_CONTENT_LINK_WIKI.replace("${page}",title),3000,0).getAttribute("href").toString();
		//close child window 2
		driver.close();
		//Focus on child window 1
		driver.switchTo().window(chilwindow1);
		//close child window 1
		driver.close();
		//Focus on parent window
		driver.switchTo().window(paWindow);

		info("link:"+link);
		info("default:"+defaultLink);
		if(link.contentEquals(defaultLink)==true)
			assert true;
		else assert false:"the link's format is incorrect";
		Utils.pause(2000);

	}
	/**
	 * Get a permalink of the page
	 * @return perLink
	 */
	public String permalinkAPage(){
		info("click on Permalink link");
		click(ELEMENT_MORE_LINK);
		click(ELEMENT_PERMALINK_LINK);
		info("Get the link");
		String perLink=waitForAndGetElement(ELEMENT_PERMALINK_LINKCOPY).getAttribute("value");
		return perLink;
	}
	/**
	 * Un check view permission for a user or a group
	 * @param locator
	 */
	public void unCheckViewAUserOfPage(Object locator){
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on permission link");
		click(ELEMENT_PERMISSION_LINK);
		info("Uncheck view permission checkbox");
		uncheck(locator, 2);
		info("Click on save button");
		click(ELEMENT_PERMISSION_BUTTON_SAVE);
	}

	/**
	 * Add more permission for a user
	 * @param namegroup
	 */
	public void addAUserToPermission(String namegroup,Object permission){
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on permission link");
		click(ELEMENT_PERMISSION_LINK);
		info("type a name or a group");
		type(ELEMENT_PERMISSION_NAMEORGROUP, namegroup, true);
		click(ELEMENT_PERMISSION_BTNADD);
		if(!permission.toString().isEmpty())
			check(permission, 2);
		info("Click on save button");
		click(ELEMENT_PERMISSION_BUTTON_SAVE);
	}
	/**
	 * remove a user or a group in permission table of a page
	 * @param usergroup
	 */
	public void removeAUserGroup(String usergroup){
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		info("Click on permission link");
		click(ELEMENT_PERMISSION_LINK);
		click(ELEMENT_PERMISSION_REMOVE_USER_GROUP.replace("${name}",usergroup));
		info("Click on save button");
		click(ELEMENT_PERMISSION_BUTTON_SAVE);
	}
	/**
	 * Rename a page from alert message when move a page to a destination that has same name
	 * @param newTitle
	 * @param newContent
	 */
	public void renameAfterPageHasSameName(String newTitle,String newContent){
		info("Click on Rename link on the alert message area");
		click(ELEMENT_MOVE_PAGE_POPUP_ALERT_MESSAGE_RENAME);
		info("Input a new name or content");
		editSimplePageWithSourceEditor(newTitle,newContent);
		info("Save all changes");
		saveAddPage();
		Utils.pause(2000);
	}
	/**
	 * Open wiki page popup
	 */
	public void goToWikiPageLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_LINK);
		info("Click on Page Link menu");
		mouseOverAndClick(ELEMENT_WIKI_PAGE_LINK_MENU);
		Utils.pause(500);
	}
	/**
	 * Open Search tab in Wiki page link popup
	 */
	public void goToSearchTab(){
		info("Select Search tab");
		click(ELEMENT_SEARCH_TAB);
		waitForAndGetElement(ELEMENT_SEARCH_BUTTON);
		info("Search tab's content is shown");
	}
	/**
	 * Search a page in Wiki page popup
	 * @param page
	 */
	public void searchPage(String page){
		goToSearchTab();
		info("Input the page:"+page);
		type(ELEMENT_SEARCH_TEXTBOX_POPUP, page, true);
		info("Search the page");
		click(ELEMENT_SEARCH_BUTTON);
	}
	/**
	 * Select a page in Search Tab
	 * @param page
	 */
	public void selectPageInSearchTab(String page){
		if(waitForAndGetElement(ELEMENT_SEARCH_TAB_PAGE_SELECTED.replace("${page}", page), 5000,0)!=null){
			info("Select the page");
			click(ELEMENT_SEARCH_TAB_PAGE_SELECTED.replace("${page}", page));
			info("Click on Select button");
			click(ELEMENT_SELECT_BUTTON);
		}
		
	}
	/**
	 * Select a page from All pages tab
	 * @param page
	 */
	public void selectPageInAllPagesTab(String page){
		WebElement el = waitForAndGetElement(ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED.replace("$title", page), 5000,1,2);
		scrollToElement(el,this.driver);
		if(waitForAndGetElement(ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED.replace("$title", page), 5000,0)!=null){
			info("Select the page");
			click(ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED.replace("$title", page));
			info("Click on Select button");
			click(ELEMENT_SELECT_BUTTON);
		}
		
	}
	/**
	 * Select a page in My Recent Changes list
	 * @param page
	 */
	public void selectPageInMyRecentChangesTab(String page){
		WebElement el = waitForAndGetElement(ELEMENT_MY_RECENT_CHANGES_TAB_PAGE_SELECTED.replace("$title", page), 5000,1,2);
		scrollToElement(el,this.driver);
		if(waitForAndGetElement(ELEMENT_MY_RECENT_CHANGES_TAB_PAGE_SELECTED.replace("$title", page), 5000,0)!=null){
			info("Select the page");
			click(ELEMENT_MY_RECENT_CHANGES_TAB_PAGE_SELECTED.replace("$title", page));
			info("Click on Select button");
			click(ELEMENT_SELECT_BUTTON);
		}
	}
	/**
	 * Click on Create link button on Wiki page popup
	 */
	public void createLink(){
		Utils.pause(500);
		click(ELEMENT_CREATE_LINK_BUTTON);
		waitForElementNotPresent(ELEMENT_CREATE_LINK_BUTTON);
	}
	/**
	 * Input a label
	 * @param label
	 */
	public void inputLabel(String label){
		if(label!=null && label!=""){
			type(ELEMENT_LABEL_LINK_TEXTBOX,label,true);
		}
	}
	/**
	 * Input a tooltip
	 * @param tooltip
	 */
	public void inputToolTip(String tooltip){
		if(tooltip!=null && tooltip!=""){
			type(ELEMENT_TOOLTIP_LINK_TEXTBOX,tooltip,true);
		}
	}
	
	
	/**
	 * Check Open New Window checkbox
	 */
	public void checkOpenNewWindow(){
		info("Check Open New Window checkbox");
		check(ELEMENT_OPEN_NEW_WINDOW_CHECKBOX,2);
		Utils.pause(2000);
	}
	/**
	 * Uncheck Open New Window checkbox
	 */
	public void uncheckOpenNewWindow(){
		info("Uncheck Open New Window checkbox");
		uncheck(ELEMENT_OPEN_NEW_WINDOW_CHECKBOX,2);
		Utils.pause(2000);
	}
	/**
	 * Open My Recent Changes tab
	 */
	public void goToMyRecentChangesTab(){
		info("Click on My Recent Changes Tab");
		click(ELEMENT_MY_RECENT_CHANGES_TAB);
		Utils.pause(2000);
	}
	/**
	 * Open All Pages Tab
	 */
	public void goToAllPagesTab(){
		info("Click on All Pages tab");
		click(ELEMENT_ALL_PAGE_TAB);
		Utils.pause(2000);
	}
	/**
	 * Expand Wiki Home node in All pages tab
	 */
	public void goToExplorerWikiHome(){
		info("click on Wiki Home note");
		click(ELEMENT_EXPLORER_WIKIHOME);
		Utils.pause(2000);
	}
	
	
	/**
	 * Verify that a wiki page link is inserted to the page
	 * @param label
	 * @param tooltip
	 */
	public void verifyInsertedWikipageLink(String label,String tooltip){
		WebElement e = waitForAndGetElement(ELEMENT_CONTENT_WIKI_FRAME,DEFAULT_TIMEOUT,1,2);
		driver.switchTo().frame(e);
		if(label!=null && label!="")
			waitForAndGetElement(By.linkText(label));
		if(tooltip!=null && tooltip!="")
			waitForAndGetElement(By.xpath("//*[@title='"+tooltip+"']"));
		switchToParentWindow();
	}
	
	public enum wikiPageLinkTab{
		My_Recent_Changes,All_pages,Search;
	}
	/**
	 * Insert a exist wiki page link into other page
	 * @param search
	 * @param page
	 * @param label
	 * @param tooltip
	 * @param opParam
	 */
	public void insertExistWikiPageLink(String page, 
			String label, String tooltip,wikiPageLinkTab tab){
		info("Open Wiki Page link popup");
		goToWikiPageLink();
		switch(tab){
		case My_Recent_Changes:
			info("Select My recent changes tab");
			goToMyRecentChangesTab();
			info("Select a page in the list");
			selectPageInMyRecentChangesTab(page);
			break;
		case All_pages:
			info("Select All pages tab");
			goToAllPagesTab();
			info("Expand WikiHome node");
			goToExplorerWikiHome();
			info("Select a page in the list");
			selectPageInAllPagesTab(page);
			break;
		case Search:
			info("Select Search tab and search the page");
			searchPage(page);
			info("Select a page");
			selectPageInSearchTab(page);
			break;
		}
		info("Input the label of the link");
		inputLabel(label);
		info("Input the tooltip of the link");
		inputToolTip(tooltip);
		info("Click on Create link button");
		createLink();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		info("Verify that the wiki page link is inserted");
		verifyInsertedWikipageLink(label, tooltip);
	}
	/**
	 * Input a name for a new wiki page link
	 * @param page
	 */
	public void inputNameWikiPageLink(String page){
		info("Input the name of the page");
		type(ELEMENT_INPUT_NAME_NEW_WIKI_PAGE,page,true);
		Utils.pause(2000);
	}
	/**
	 * Add a new wiki page in My Recent changes tab
	 * @param page
	 */
	public void addNewPageInMyRecentChangesTab(String page){
		info("Double click on Add New Page button");
		doubleClickOnElement(ELEMENT_MY_RECENT_CHANGES_TAB_ADD_NEW_PAGE_BTN);
		info("Input the name of the page");
		inputNameWikiPageLink(page);
	}
	/**
	 * Add a  new wiki page in Search tab
	 * @param page
	 */
	public void addNewPageInSearchTab(String page){
		info("Double click on Add New Page button");
		doubleClickOnElement(ELEMENT_SEARCH_TAB_ADD_NEW_PAGE_BTN);
		info("Input the name of the page");
		inputNameWikiPageLink(page);
	}
	/**
	 * Click on Link Setting button
	 */
	public void goToLinkSetting(){
		info("Click on Link Setting button");
		click(ELEMENT_WIKI_PAGE_LINK_LINK_SETTING_BTN);
		Utils.pause(2000);
	}
	/**
	 * Insert a new wiki page into other page
	 * @param page
	 * @param label
	 * @param tooltip
	 * @param tab
	 */
	public void insertNewWikiPageLink(String page, 
			String label, String tooltip,wikiPageLinkTab tab){
		info("Open Wiki Page link popup");
		goToWikiPageLink();
		switch(tab){
		case My_Recent_Changes:
			info("Select My recent changes tab");
			goToMyRecentChangesTab();
			info("Select a page in the list");
			addNewPageInMyRecentChangesTab(page);
			goToLinkSetting();
			break;
		case All_pages:
			info("Select All pages tab");
			goToAllPagesTab();
			info("Double click on Add New Page button");
			doubleClickOnElement(ELEMENT_ALL_PAGES_TAB_ADD_NEW_PAGE_BTN);
			break;
		case Search:
			info("Open Seach tab");
			goToSearchTab();
			info("Create a new wiki page");
			addNewPageInSearchTab(page);
			goToLinkSetting();
			break;
		}
		info("Input the label of the link");
		inputLabel(label);
		info("Input the tooltip of the link");
		inputToolTip(tooltip);
		info("Click on Create link button");
		createLink();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		info("Verify that the wiki page link is inserted");
		verifyInsertedWikipageLink(label, tooltip);
	}
	
	/**
	 * Click on inserted link in the wiki page
	 * @param label
	 */
	public void viewInsertLink(String label){
		info("Verify that the inserted link is shown in the page");
		waitForAndGetElement(By.linkText(label));
		info("Click on the label");
		click(By.linkText(label));
	}
	
	/**
	 * Verify that the system redirects to the wiki page link that is inserted
	 * @param label
	 * @param pageLink
	 */
	public void verifyInsertedExistLink(String label,String pageLink){
		viewInsertLink(label);
		info("The page link is shown");
		waitForAndGetElement(ELEMENT_TITLE_INFO.replace("${title}", pageLink));
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
	 * Verify that the system redirects to the wiki page that is created
	 * @param label
	 * @param pageLink
	 */
	public void verifyInsertNewLink(String label,String pageLink){
		viewInsertLink(label);
		info("The page link is shown");
		String actualTitle = this.driver.findElement(ELEMENT_TITLE_WIKI_INPUT).getAttribute("value").toString();
		if(actualTitle.contains(pageLink))
			assert true;
		else assert false;
	}
	/**
	 * Open Webpage link
	 */
	public void goToWebPageLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_LINK);
		info("Click on Web Page Link menu");
		mouseOverAndClick(ELEMENT_WEB_PAGE_LINK_MENU);
		Utils.pause(500);
	}
	/**
	 * Input web address
	 * @param address
	 */
	public void inputWebAddress(String address){
		if(!address.isEmpty()){
			info("Input web address");
			type(ELEMENT_WEB_PAGE_WEB_ADDRESS,address,true);
		}
		Utils.pause(2000);
	}
	/**
	 * Insert a web link into the page
	 * @param address
	 * @param label
	 * @param tooltip
	 */
	public void insertWebLink(String address,String label,String tooltip){
		info("Go to Web page Link");
		goToWebPageLink();
		info("Input web address for the page");
		inputWebAddress(address);
		info("Input Label for the page");
		inputLabel(label);
		info("Input Tooltip for the page");
		inputToolTip(tooltip);
		info("Click on Create link button");
		createLink();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		info("Verify that the wiki page link is inserted");
		verifyInsertedWikipageLink(label, tooltip);
	}
	/**
	 * Open Email link popup
	 */
	public void goToEmailLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_LINK);
		info("Click on Attached file Link menu");
		mouseOverAndClick(ELEMENT_EMAIL_LINK_MENU);
		Utils.pause(500);
	}
	/**
	 * Input email address into EMail link popup
	 * @param address
	 */
	public void inputEmailAddress(String address){
		if(!address.isEmpty()){
			info("Input web address");
			type(ELEMENT_EMAIL_LINK_EMAIL_ADDRESS,address,true);
		}
		Utils.pause(2000);
	}
	/**
	 * Insert email address into the page
	 * @param address
	 * @param label
	 * @param tooltip
	 */
	public void insertEmailLink(String address,String label,String tooltip){
		info("Go to Email Link");
		goToEmailLink();
		info("Input Email for the page");
		inputEmailAddress(address);
		info("Input Label for the page");
		inputLabel(label);
		info("Input Tooltip for the page");
		inputToolTip(tooltip);
		info("Click on Create link button");
		createLink();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		info("Verify that the wiki page link is inserted");
		verifyInsertedWikipageLink(label, tooltip);
	}
	/**
	 * Open Attached File link
	 */
	public void goToAttachedFileLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_LINK);
		info("Click on Attached file Link menu");
		mouseOverAndClick(ELEMENT_ATTACHED_FILE_LINK_MENU);
		Utils.pause(500);
	}
	/**
	 * Open Current page tab in Attached file link popup
	 */
	public void goToCurrentPageTab(){
		info("Click on Current Page Tab");
		click(ELEMENT_CURRENT_PAGE_TAB);
		Utils.pause(2000);
	}
	
    /**
     * Define tab's types of the attached file popup	
     */
	public enum attachedFileTabType{
		Current_page,All_pages;
	}
	/**
	 * Select an attached file in list of All pages tab
	 * @param page
	 * @param attachedFile
	 */
	public void selectAttachedFile(String page,String attachedFile){
		WebElement el = waitForAndGetElement(ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED.replace("$title", page), 5000,1,2);
		scrollToElement(el,this.driver);
		if(waitForAndGetElement(ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED.replace("$title", page), 5000,0)!=null){
			info("Select the page");
			click(ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED.replace("$title", page));
			info("Open Attachment file");
			click(ELEMENT_ALL_PAGE_SELECT_ATTACHEMENT_FILE_PAGE.replace("$page",page));
			info("Select attached file");
			click(ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED.replace("$title",attachedFile));
			info("Click on Select button");
			click(ELEMENT_SELECT_BUTTON);
		}
	}
	/**
	 * Upload an attached file link in Attached File link popup
	 * @param link
	 */
	public void uploadAttachedFile(String link){
		info("Double Click on Upload New file button");
		doubleClickOnElement(ELEMENT_CURRENT_PAGE_TAB_UPLOAD_NEW_FILE_BTN);
		WebElement elem = waitForAndGetElement(ELEMENT_CURRENT_PAGE_TAB_UPLOAD_NAME,5000,1,2);
		scrollToElement(elem, driver);
		click(elem,2,true);
		uploadFileUsingRobot(link);
		Utils.pause(3000);
	}
	/**
	 * Upload an image file in Attached Image link popup
	 * @param link
	 */
	public void uploadImageFile(String link){
		info("Double Click on Upload New file button");
		doubleClickOnElement(ELEMENT_CURRENT_PAGE_TAB_UPLOAD_IMAGE_BTN);
		WebElement elem = waitForAndGetElement(ELEMENT_CURRENT_PAGE_TAB_UPLOAD_NAME,5000,1,2);
		scrollToElement(elem, driver);
		click(elem,2,true);
		uploadFileUsingRobot(link);
		Utils.pause(3000);
	}
	/**
	 * Insert attached File link into the page
	 * @param page
	 * @param attachedFile
	 * @param tooltip
	 * @param tab
	 */
	public void insertAttachedFileLink(String page,String attachedFile,String tooltip,attachedFileTabType tab){
		info("Go to Attached file Link");
		goToAttachedFileLink();
		switch(tab){
		case Current_page:
			info("Open Current page tab");
			goToCurrentPageTab();
			info("Input attached file link");
			uploadAttachedFile(attachedFile);
			goToLinkSetting();
			break;
		case All_pages:
			info("Open All pages tab");
			goToAllPagesTab();
			info("Expand WikiHome node");
			goToExplorerWikiHome();
			info("Select attached file");
			selectAttachedFile(page,attachedFile);
			break;
		}
		info("Input the tooltip of the link");
		inputToolTip(tooltip);
		info("Click on Create link button");
		createLink();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		info("Verify that the wiki page link is inserted");
		verifyInsertedWikipageLink(attachedFile, tooltip);
	}
	/**
	 * Insert an attached file to the page
	 * @param attachedFile
	 * @param tooltip
	 * @param tab
	 */
	public void insertAttachedFileLink(String attachedFile){
		String[] fileNames = attachedFile.split("/");
		info("Go to Attached file Link");
		goToAttachedFileLink();
		info("Input attached file link");
		uploadAttachedFile(attachedFile);
		info("Click on Create link button");
		createLink();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		info("Verify that the wiki page link is inserted");
		verifyInsertedWikipageLink(fileNames[1],"");
	}
	/**
	 * Open Attached Image link popup
	 */
	public void goToAttachedImageLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_IMAGE_LINK);
		info("Click on Attached file Link menu");
		mouseOverAndClick(ELEMENT_ATTACHED_IMAGE_LINK_MENU);
		Utils.pause(500);
	}
	/**
	 * Open External Image link popup
	 */
	public void goToExternalImageLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_IMAGE_LINK);
		info("Click on Attached file Link menu");
		mouseOverAndClick(ELEMENT_EXTERNAL_IMAGE_LINK_MENU);
		Utils.pause(500);
	}
	
	
	/**
	 * Click on Insert Image button
	 */
	public void clickInsertImageBtn(){
		info("Click on Insert Image");
		click(ELEMENT_IMAGE_MENU_INSERT_IMAGE_BTN);
		waitForElementNotPresent(ELEMENT_IMAGE_MENU_INSERT_IMAGE_BTN);
	}
	/**
	 * Insert an image into the content of the page
	 * @param attachedFile
	 */
	public void insertImage(String attachedFile){
		info("Go to Attached file Link");
		goToAttachedImageLink();
		info("Open Current page tab");
		goToCurrentPageTab();
		info("Input attached file link");
		uploadImageFile(attachedFile);
		info("Click on Insert Image button");
		clickInsertImageBtn();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
	}
	/**
	 * Click on Image Settings button on Attached Image link popup
	 */
	public void clickImageSettings(){
		info("Click on Insert Image");
		click(ELEMENT_IMAGE_MENU_IMAGE_SETTINGS_BTN);
		waitForElementNotPresent(ELEMENT_IMAGE_MENU_IMAGE_SETTINGS_BTN);
	}
	/**
	 * Insert an image into the content of the page
	 * @param attachedFile
	 * @param width
	 * @param height
	 * @param altText
	 */
	public void insertImage(String attachedFile,String width,String height,String altText){
		info("Go to Attached file Link");
		goToAttachedImageLink();
		info("Open Current page tab");
		goToCurrentPageTab();
		info("Input attached file link");
		uploadImageFile(attachedFile);
		info("Click on Image Setting button");
		clickImageSettings();
		if(!width.isEmpty()){
			info("Input width");
			type(ELEMENT_IMAGE_WIDTH,width,true);
		}
		if(!height.isEmpty()){
			info("Input height");
			type(ELEMENT_IMAGE_HEIGHT,height,true);
		}
		if(!altText.isEmpty()){
			info("Change alt text");
			type(ELEMENT_IMAGE_ALTERNATIVE_TEXT,altText,true);
		}
		
	}
	/**
	 * Input an external image link
	 * @param link
	 */
	public void inputExternalImageLink(String link){
		if(!link.isEmpty()){
			info("Input external Image link");
			type(ELEMENT_EXTERNAL_IMAGE_INPUT_LINK,link,true);
		}
	}
	/**
	 * Input an external image into the content of the page
	 * @param link
	 * @param width
	 * @param height
	 * @param altText
	 */
	public void insertExternalImageLink(String link,String width,String height,String altText){
		info("Go to External Image Link");
		goToExternalImageLink();
		info("Input a link");
		inputExternalImageLink(link);
		info("Click on Image Settings button");
		clickImageSettings();
		if(!width.isEmpty()){
			info("Input width");
			type(ELEMENT_IMAGE_WIDTH,width,true);
		}
		if(!height.isEmpty()){
			info("Input height");
			type(ELEMENT_IMAGE_HEIGHT,height,true);
		}
		if(!altText.isEmpty()){
			info("Change alt text");
			type(ELEMENT_IMAGE_ALTERNATIVE_TEXT,altText,true);
		}
	}

	/**
	 * Open Edit Image link popup
	 */
	public void goToEditImageLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_IMAGE_LINK);
		info("Click on Edit image Link menu");
		mouseOverAndClick(ELEMENT_EDIT_IMAGE_LINK_MENU);
		Utils.pause(500);
	}
	
	public enum alignType{
		None,Left,Center,Right,Top,Middle,Bottom;
	}
	/**
	 * Edit an image 
	 * @param imageName
	 * @param width
	 * @param height
	 */
	public void editInsertedImage(String imageName,String width,String height,String altText){
		info("Go To Edit Image Link");
		goToEditImageLink();
		info("Select the image");
		click(ELEMENT_IMAGE_LINK_IMAGE_THUMBNAIL.replace("$image",imageName));
		info("click on Select button");
		click(ELEMENT_SELECT_BUTTON);
		if(!width.isEmpty()){
			info("Input width");
			type(ELEMENT_IMAGE_WIDTH,width,true);
		}
		if(!height.isEmpty()){
			info("Input height");
			type(ELEMENT_IMAGE_HEIGHT,height,true);
		}
		if(!altText.isEmpty()){
			info("Change alt text");
			type(ELEMENT_IMAGE_ALTERNATIVE_TEXT,altText,true);
		}
	}
	/**
	 * Open Edit link popup
	 */
	public void editLink(){
		info("Click on Link menu");
		mouseOverAndClick(ELEMENT_LINK);
		info("Click on Edit Link menu");
		mouseOverAndClick(ELEMENT_EDIT_LINK_MENU);
		Utils.pause(500);
	}
	/**
	 * Edit an attached file link
	 * @param fileName
	 * @param label
	 * @param tooltip
	 */
	public void editAttachedFileLink(String fileName,String label,String tooltip){
		info("Go To Edit Link");
		editLink();
		info("Select the image");
		click(ELEMENT_CURRENT_TAB_ATTACHED_FILE_SELECTED.replace("$file",fileName));
		info("click on Select button");
		click(ELEMENT_SELECT_BUTTON);
		info("Input Label for the page");
		inputLabel(label);
		info("Input Tooltip for the page");
		inputToolTip(tooltip);
		info("Click on Create link button");
		createLink();
		info("Move focus at the end of the line");
		pressEndKey(this.driver);
		info("Verify that the wiki page link is inserted");
		verifyInsertedWikipageLink(label, tooltip);
	}
	
	/**
	 * Select algin of Image
	 * @param type
	 */
	public void selectAlign(alignType type){
		switch(type){
		case None:
			break;
		case Left:
			info("Select left align");
			check(ELEMENT_IMAGE_ALIGN_LEFT,2);
			break;
		case Center:
			info("Select center align");
			check(ELEMENT_IMAGE_ALIGN_CENTER,2);
			break;
		case Right:
			info("Select right align");
			check(ELEMENT_IMAGE_ALIGN_RIGHT,2);
			break;
		case Top:
			info("Select top align");
			check(ELEMENT_IMAGE_ALIGN_TOP,2);
			break;
		case Middle:
			info("Select middle align");
			check(ELEMENT_IMAGE_ALIGN_MIDDLE,2);
			break;
		case Bottom:
			info("Select bottom align");
			check(ELEMENT_IMAGE_ALIGN_BOTTOM,2);
			break;
		}
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
	 * Verify alt Text of image is changed
	 * @param altText
	 */
	public void verifyAltTextImageInContentPage(String altText){
		info("Verify that alt text is changed");
		waitForAndGetElement(ELEMENT_INSERTED_IMAGE_ALT_TEXT
				.replace("$alt", altText));
	}

}
