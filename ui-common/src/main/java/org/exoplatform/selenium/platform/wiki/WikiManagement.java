package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiManagement extends WikiHomePage{
	
	
	
	public final String ELEMENT_PAGE_INFOR_RECENT_CHANES = ".//*[contains(text(),'v.1')]/../..//*[contains(text(),'John Smith')]";
	public final String ELEMENT_PAGE_INFOR_HIERARCHY_CHILD_PAGES = ".//*[contains(text(),'Child Pages')]/..//*[contains(text(),'${child}')]";
	//Source editor
	public final By ELEMENT_TITLE_WIKI_INPUT = By.id("titleInput");
	public final By ELEMENT_CONTENT_WIKI_INPUT = By.id("Markup");
	public final By ELEMENT_PUBLISH_ACTIVITY_CHECKBOX = By.id("PublishActivityUpper");
	public final By ELEMENT_PREVIEW_BUTTON = By.xpath("//*[@class='uiIconWatchPage']");
	public final By ELEMENT_PREVIEW_SCREEN = By.xpath("//div[@class='popupTitle' and text()='Preview']");

	//Richtext mode
	public final By ELEMENT_CONTENT_WIKI_FRAME = By.xpath("//div[@class='xRichTextEditor']/iframe");

	public final By ELEMENT_SAVE_BUTTON_ADD_PAGE = By.id("UISubmitToolBarUpper_SavePage_");
	public final By ELEMENT_CANCEL_BUTTON_ADD_PAGE = By.id("UISubmitToolBarBottom_Cancel_");

	public final By ELEMENT_SOURCE_EDITOR_BUTTON= By.xpath("//*[contains(text(),'Source Editor')]");
	public final By ELEMENT_RICHTEXT_BUTTON = By.xpath("//*[contains(text(),'Rich Text')]");

	public final By ELEMENT_UPLOAD_NAME = By.name("file");
	public final By ELEMENT_BODY_CONTAINER = By.xpath("//*[@class='uiRightContainerArea']");

	//Draft notification
	public By ELEMENT_DRAFT_NOTIFY = By.xpath("//*[contains(@class, 'uiWikiPageEditForm') and contains(text(), 'Draft saved at')]");

	//Add page from template
	public final String ELEMENT_SELECT_TEMPLATE_LINK = "//input[@value = '{$template}']";
	public final By ELEMENT_TEMPLATE_SELECT_FORM = By.id("UIWikiSelectTemplateForm");
	
	//Preview page
	public final String ELEMENT_PREVIEW_TEMPLATE_CONTENT = "//*[@class='uiWikiPageTitlePreview' and contains(text(), '${template}')]";
	public By ELEMENT_CLOSE_PREVIEW_WINDOW=By.xpath("//div[text()='Preview']/..//*[contains(@class,'uiIconClose')]");

	//comment field
	public final By ELEMENT_WIKI_PAGE_INPUT_COMMENT = By.id("Comment");
	
	//Move page popup
	public final By ELEMENT_WIKI_PAGE_MOVE_POPUP_SAVE = By.xpath(".//*[@id='UIWikiMovePageForm']//button[contains(text(),'Move')]");
	public final String ELEMENT_WIKI_PAGE_MOVE_POPUP_NODE =".//*[@id='UIMoveTree']//*[contains(text(),'${name}')]";
	
	//Information table
	public final String ELEMENT_WIKI_PAGE_INFOMATION_VERSION= ".//*[@id='UIWikiPageInfoArea']//*[text()='${version}']";
	public final By ELEMENT_WIKI_PAGE_INFORMATION_TABLE_TITLE = By.xpath(".//*[@id='UIWikiPageVersionsList2']//*[text()='Page History']");
    public final String ELEMENT_WIKI_PAGE_INFORMATION_TABLE_CONTENT =".//a[text()='reversion']/../../..//td[contains(text(),'${text}')]";
	
    //Information area
    public final String ELEMENT_WIKI_PAGE_INFORMATION_AREA_EDIT_INFOR = ".//*[@id='UIWikiPageInfoArea']//*[contains(.,'${info}')]";
	public final String ELEMENT_WIKI_PAGE_INFORMATION_AREA_TOTAL_ATTACHEDFILES=".//*[@id='UIWikiPageInfoArea']//*[contains(text(),'${number}')]";
	public final String ELEMENT_WIKI_PAGE_INFORMATION_AREA_RESTRICTED_STATUS=".//*[@id='UIWikiPageInfoArea']//*[contains(text(),'${status}')]";
	
	//Page info
	public final String ELEMENT_WIKI_PAGE_PAGE_INFO_TITLE = ".//*[@id='UIWikiPageContainer']/h4[text()='Page Info']";
	public final By ELEMENT_PAGE_INFO_VIEW_PAGE_INFO_BTN = By.xpath(".//button[text()='View Page History']");
	public final String ELEMENT_PAGE_INFOR_SUMMARY_TITLE = ".//*[@id='UIWikiPageInfo']//*[contains(text(),'Title')]/../..//*[contains(text(),'${content}')]";
	public final String ELEMENT_PAGE_INFOR_SUMMARY_AUTHOR =".//*[@id='UIWikiPageInfo']//*[contains(text(),'Author')]/../..//*[contains(text(),'${fullname}')]/..//*[contains(text(),'${date}')]";
	public final String ELEMENT_PAGE_INFOR_SUMMARY_LAST_CHANGED = ".//*[@id='UIWikiPageInfo']//*[contains(text(),'Last changed by')]/../..//*[contains(text(),'${fullname}')]/..//*[contains(text(),'${date}')]";
	public final By ELEMENT_PAGE_INFOR_RELATED = By.xpath(".//*[@id='UIWikiPageInfo']//*[contains(text(),'Wiki')]/..//*[contains(text(),'Related Pages')]/..//*[contains(text(),'Actions')]");
	public final By ELEMENT_PAGE_INFO_ADD_MORE_RELATIONS = By.xpath(".//*[@id='UIWikiPageInfo']//button[text()='Add More Relations']");
	public final String ELEMENT_PAGE_INFO_RELATED_TABLE_CONTENT = ".//*[@id='UIWikiPageInfo']//*[contains(text(),'${col1}')]/..//*[contains(text(),'${col2}')]";
	public final String ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN =".//*[contains(text(),'${name}')]/../../../../..//*[@class='uiIconDelete uiIconLightGray']";
	
	public final By ELEMENT_PAGE_INFOR_HIERARCHY_PARENT_PAGES = By.xpath(".//*[contains(text(),'Parent Page')]/..//*[contains(text(),'Wiki Home')]");
	
	//Page History
	public final By ELEMENT_WIKI_PAGE_PAGE_HISTORY_TITLE =By.xpath(".//h4[text()='Page History']");
	public final String ELEMENT_WIKI_PAGE_PAGE_HISTORY_CHECKBOX = ".//a[contains(text(),'${reversion}')]/../../..//input";
	public final By ELEMENT_WIKI_PAGE_PAGE_HISTORY_COMPARE_BTN = By.xpath(".//button[text()='Compare the selected versions']");
	
	//Compare reversion
	public final By ELEMENT_WIKI_PAGE_COMPARE_REVERSION_TITLE = By.xpath(".//h4[text()='Compare Revisions']");
	public final String ELEMENT_PAGE_HISTORY_COMPARE_CONTENT =".//*[@id='UIWikiPageVersionsCompare']//*[contains(text(),'${text}')]";
	
	
	//Add more relations
	public final By ELEMENT_ADD_RELATED_PAGE_POPUP_TITLE = By.xpath(".//*[contains(text(),'Add Related Page')]");
	public final By ELEMENT_ADD_RELATED_PAGE_POPUP_DROPDOWN=By.xpath(".//*[contains(text(),'Add Related Page')]/../..//*[@data-toggle='dropdown']");
	public final String ELEMENT_ADD_RELATED_POPUP_DROPDOWN_LOCATION = ".//*[contains(text(),'Add Related Page')]/../..//*[contains(text(),'${location}')]";
	public final String ELEMENT_ADD_RELATED_POPUP_CONTENT = ".//*[contains(text(),'Add Related Page')]/../..//*[contains(text(),'${page}')]";
	public final By ELEMENT_ADD_RELATED_POPUP_SELECT_BTN = By.xpath(".//button[text()='Select']");
	public final By ELEMENT_ADD_RELATED_POPUP_CLOSE_BTN = By.xpath(".//*[contains(text(),'Add Related Page')]/..//*[@class='uiIconClose pull-right']");
	
	//Space swithcher drop down
	public final By ELEMENT_SPACE_SWITHCHER_DROPDOWN_CLOSE=By.xpath(".//*[@id='uiSpaceSwitcher_UIWikiSelectPageForm']/.//*[@title='Close']");
	public final By ELEMENT_ADD_RELATED_POPUP_DROPDOWN_NOSPACE = By.xpath(".//*[@id='UISpaceSwitcher_nospace'][text()='No Spaces']");
	
	ManageAlert alert;
	/**
	 * constructor
	 * @param dr
	 */
	public WikiManagement(WebDriver dr){
		super(dr);
		this.driver=dr;
		alert = new ManageAlert(dr);
	}

	/**
	 * Select template to create page
	 */
	public void selectTemplateWikiPage(String template){
		info("--Select a template--");
		waitForAndGetElement(ELEMENT_TEMPLATE_SELECT_FORM);
		By eTemplate = By.xpath(ELEMENT_SELECT_TEMPLATE_LINK.replace("{$template}",template));
		click(eTemplate, 2);
	}

	/**
	 * Change to Source Editor mode
	 */
	public void goToSourceEditor(){
		if(waitForAndGetElement(ELEMENT_SOURCE_EDITOR_BUTTON,5000,0,2)!=null){
			info("Go to Source Editor");
			click(ELEMENT_SOURCE_EDITOR_BUTTON);	
		}
		waitForAndGetElement(ELEMENT_CONTENT_WIKI_INPUT);
	}

	/**
	 * Change to Rich Text Mode
	 */
	public void goToRichTextEditor(){
		if(waitForAndGetElement(ELEMENT_RICHTEXT_BUTTON,5000,0,2)!=null){
			info("Go to Rich Text Mode");
			click(ELEMENT_RICHTEXT_BUTTON);
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
	 * Add a simple wiki page with rich text
	 * 
	 * @param title
	 *            updated title of the wiki page. Can not be <code>null</code>
	 * @param content
	 *            updated content of the wiki page. Can not be <code>null</code>
	 */
	public void addWikiPageSimpleWithRichText(String title, String content){
		info("Input a title for the page");
		if(!title.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, title, false);
		info("Input a content for the page");
	    if(!content.isEmpty()){
	    	inputDataToCKEditor(ELEMENT_CONTENT_WIKI_FRAME, content);
	    	Utils.pause(1000);
			driver.switchTo().defaultContent();
	    }
	    info("Save all changes");
	    saveAddPage();
		info("Wiki page simple is created successfully");
	}
	
	/**
	 * Edit a simple wiki page with rich editor
	 * 
	 * @param newTitle
	 *            updated title of the wiki page. Can not be <code>null</code>
	 * @param newContent
	 *            updated content of the wiki page. Can not be <code>null</code>
	 */
	public void editWikipageSimpleWithRichText(String newTitle,String newContent){
		info("Input a new title for the page");
		if(!newTitle.isEmpty())
			type(ELEMENT_TITLE_WIKI_INPUT, newTitle, true);
		info("Input a new content for the page");
		if(!newContent.isEmpty()){
			inputDataToCKEditor(ELEMENT_CONTENT_WIKI_FRAME, newContent);
			Utils.pause(1000);
			driver.switchTo().defaultContent();
		}
		 info("Save all changes");
		 saveAddPage();
		 info("Wiki page simple is edited successfully");
	}

	/**
	 * Add a simple wiki page with source editor
	 * @param title
	 * @param content
	 */
	public void addWikiPageSimpleWithSourceEditor(String title, String content){
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
	    info("Save all changes");
	    saveAddPage();
		info("Wiki page simple is created successfully");
	}
	/**
	 * Edit a simple wiki page with source editor
	 * @param newTitle
	 * @param newContent
	 */
	public void editWikiPageSimpleWithSourceEditor(String newTitle, String newContent){
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
		click(ELEMENT_CANCEL_BUTTON_ADD_PAGE);
		waitForElementNotPresent(ELEMENT_CANCEL_BUTTON_ADD_PAGE);
	}

	/**
	 * publish page
	 */
	public void publishPage(){
		info("check on publish checkbox");
		check(ELEMENT_PUBLISH_ACTIVITY_CHECKBOX, 2);
	}

	/**
	 * unpublish page
	 */
	public void unPublishPage(){
		uncheck(ELEMENT_PUBLISH_ACTIVITY_CHECKBOX, 2);
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
	public void attachFileInWiki(String link, Integer...type ){
		int notDisplay = 0;
		if (type.length > 0){
			if (!(type[0] instanceof Integer)) {
				throw new IllegalArgumentException("-- Argument should be an Integer --");
			}
			notDisplay = (Integer)type[0];
		}

		String path = Utils.getAbsoluteFilePath(link);
		info("Attach a file: " + path);
		try{
			for(int i =0; i<=4; i++){
				if(waitForAndGetElement(ELEMENT_UPLOAD_NAME, 5000, 0, notDisplay)!=null)
					break;
				else{
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", 
							waitForAndGetElement(ELEMENT_BODY_CONTAINER));
				}
			}
			WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, 5000, 1, notDisplay);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility = 'visible'; arguments[0].style.height = '1px'; " +
					"arguments[0].style.width = '1px'; arguments[0].style.opacity = 1", upload);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
			upload.sendKeys(path);

		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			attachFileInWiki(link);

		}  catch (ElementNotVisibleException e) {

			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			attachFileInWiki(link);

		} finally {
			loopCount = 0;
		}
		switchToParentWindow();
		waitForAndGetElement(By.linkText(link.replace("TestData/", "")));
	}
	
	
	/**
	 * Attach many files to a wiki page
	 */
	public void attachMultiFileInWiki(String link){
		String[] upload = link.split(";");
		for (int i = 0; i < upload.length; i++){
			attachFileInWiki("TestData/" + upload[i], 2);
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
	
}
