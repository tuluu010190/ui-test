package org.exoplatform.selenium.platform.ks;

import static org.exoplatform.selenium.TestLogger.info;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/* @author: Thuntn
 * @date: 14/11/2012
 */
public class Wiki extends KsBase {

	/*-----------------Page control area-------------------*/
	//Add page menu
	public static final By ELEMENT_ADD_PAGE_LINK = By.xpath("//div[@id='UIWikiPageControlArea_PageToolBar_Add_' and contains(text(),'Add Page')]");
	public static final By ELEMENT_BLANK_PAGE_LINK=By.linkText("Blank Page");
	public static final By ELEMENT_FROM_TEMPLATE_LINK=By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar_Add_']/div/ul/li[2]/a");
	//Edit menu
	public static final By ELEMENT_EDIT_PAGE_LINK= By.xpath("//a[@class='EditPage Icon' and @title='Edit']");
	public static final By ELEMENT_MINOR_EDIT_BUTTON = By.xpath(".//*[@id='UISubmitToolBarUpper']/a[2]");
	//More menu
	public static final By ELEMENT_MORE_LINK = By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar_More_']");
	public static final By ELEMENT_DELETE_LINK = By.linkText("Delete Page");
	public static final By ELEMENT_WATCH_LINK = By.linkText("Watch");
	public static final By ELEMENT_UNWATCH_LINK = By.linkText("Stop Watching");
	public static final By ELEMENT_PAGE_INFO_LINK = By.linkText("Page Info");
	public static final By ELEMENT_PAGE_PERMISSION_LINK = By.linkText("Page Permissions");
	public static final By ELEMENT_MOVE_PAGE_LINK = By.linkText("Move Page");

	//BreadCrumb
	public static final By ELEMENT_WIKI_HOME = By.linkText("Wiki Home");


	//Browse menu
	public static final By ELEMENT_BROWSE_LINK = By.xpath("//div[contains(text(),'Browse')]");
	public static final By ELEMENT_SPACE_SETTING_LINK= By.linkText("Space Settings");
	//Search area
	public static final By ELEMENT_QUICK_SEARCH = By.id("wikiSearchValue");

	/*------------------add wiki page---------------------*/
	//Source Editor mode
	public static final By ELEMENT_TITLE_WIKI_INPUT = By.id("TitleInput");
	public static final By ELEMENT_CONTENT_WIKI_INPUT = By.id("Markup");
	public static final By ELEMENT_RICHTEXT_BUTTON = By.xpath("//a[@title='Rich Text']");
	public static final By ELEMENT_PREVIEW_BUTTON = By.xpath("//a[@title='Preview']");
	public static final By ELEMENT_PREVIEW_SCREEN = By.xpath("//div[@class='PopupTitle' and text()='Preview']");

	//Richtext mode
	public static final By ELEMENT_SOURCE_EDITOR_BUTTON= By.xpath("//a[contains(text(),'Source Editor')]");
	public static final By ELEMENT_CONTENT_WIKI_FRAME = By.xpath("//div[@class='xRichTextEditor']/iframe");
	//Upload file area
	public static By ELEMENT_UPLOAD_FILE = By.id("WikiUploadFile");
	public static final By ELEMENT_FRAME_UPLOAD=By.xpath("//div[@title='Upload New File']/iframe");
	public static final String ELEMENT_REMOVE_ATTACHMENT = "//a[contains(text(),'{$file}')]/../../td/img[@title='Remove Attachment']";
	//Add page from template
	public static final String ELEMENT_SELECT_TEMPLATE_LINK="//tbody/tr/td/div[contains(@title,'{$template}')]/../../td[3]/div/a[1]";

	/*--------------------------Search page----------------------------*/
	public static final By ELEMENT_SEARCH_BUTTON = By.linkText("Search");
	public static final By ELEMENT_SEARCH_FOR = By.xpath("//a[@class='ItemIcon MenuIcon' and contains(@title,'Search for')]"); 
	public static final By ELEMENT_SEARCH_ICON = By.xpath("//div[@class='SearchIcon']");
	public static final By ELEMENT_SEARCH_ADVANCE=By.id("text");
	public static final By ELEMENT_RESULT_SEARCH = By.xpath("//*[@id='UIWikiAdvanceSearchResult']");
	public static final String ELEMENT_VERIFY_MESSAGE = "No matching search result.";
	/*-------------------------Move page--------------------*/
	public static final By CLICK_MOVE_ACTION = By.xpath("//*[@id='UIWikiMovePageForm']//*[text()='Move']");

	/*-------------------------More/page permission page--------------------*/
	public static final By ELEMENT_SELECT_USER = By.xpath("//img[@title='Select User']");
	public static final String ELEMENT_USERNAME_CHECK = "//input[@id='${user}' and @type='checkbox']";
	public static final By ELEMENT_SELECTOR_TEXT = By.xpath("//span[@class='PopupTitle' and contains(text(),'User Selector')]");
	public static final By ELEMENT_SELECT_INPUT = By.id("PermissionOwner");
	public static final By ELEMENT_SELECT_GROUP = By.xpath("//img[@title='Select Group']");
	public static final By ELEMENT_SELECT_MEMBERSHIP = By.xpath("//img[@title='Select Membership']");

	/*----------------------Browse/Space setting/ add, edit, delete template-----------------*/
	public static final By ELEMENT_TEMPLATE_LINK = By.linkText("Template");
	public static final By ELEMENT_ADD_TEMPLATE_LINK = By.linkText("Add More Templates");
	public static final String ELEMENT_EDIT_TEMPLATE_ICON = "//tr/td/div[@title='{$template}']/../../td/div/a[@class='EditTemplateIcon' and contains(text(),'Edit')]";
	public static final String ELEMENT_DELETE_TEMPLATE_ICON = "//tr/td/div[@title='{$template}']/../../td/div/a[@class='DeleteTemplateIcon' and contains(text(),'Delete')]";
	public static final By ELEMENT_SEARCH_TEMPLATE_INPUT=By.id("TemplateSeachBox");
	//Add template page
	public static final By ELEMENT_TITLE_TEMPLATE_INPUT= By.id("TitleInput");
	public static final By ELEMENT_DESC_TEMPLATE_INPUT= By.id("Description");
	public static final By ELEMENT_CONTENT_TEMPLATE_INPUT= By.id("Markup");
	public static final By ELEMENT_SAVE_TEMPLATE_INPUT= By.xpath("//a[contains(text(),'Save Template')]"); 
	//Message
	public static final String MSG_CREATE_TEMPLATE="is created successfully.";
	public static final String MSG_DELETE_TEMPLATE="Are you sure to delete this template?";

	/*------------------------Browser/Space setting/ Permission space------------------------*/
	public static final By ELEMENT_PERMISSION_LINK=By.linkText("Permission");
	public static final String MSG_PERMISSION_SAVE = "The permission setting has been saved successfully.";
	public static final String ELEMENT_EDIT_PAGE_CHECK = "//tr/td/div[@title='{$user}']/../../td/input[@title='Edit Pages']";
	public static final String ELEMENT_VIEW_PAGE_CHECK = "//tr/td/div[@title='{$user}']/../../td/input[@title='View Pages']";
	public static final String ELEMENT_ADMIN_PAGE_CHECK = "//tr/td/div[@title='{$user}']/../../td/input[@title='Admin Pages']";
	public static final String ELEMENT_ADMIN_SPACE_CHECK = "//tr/td/div[@title='{$user}']/../../td/input[@title='Admin Space']";
	public static final String ELEMENT_VIEW_SPACE_CHECK = "//tr/td/div[@title='{$user}']/../../td/input[@title='View Pages']";
	public static final String ELEMENT_DELETE_PERMISSION = "//tr/td/div[@title='{$user}']/../../td/div/img[@alt='Delete permission']";

	/*-------------------------Page information area---------------------------*/
	public static final By ELEMENT_COMPARE_TEXT = By.xpath("//div[contains(text(),'Compared With')]");
	public static final By ELEMENT_REVISION_LINK = By.xpath("//a[contains(text(),'Revisions')]");
	public static final String ELEMENT_VERSION_LINK= "//a[contains(text(),'v. {$version}')]";
	public static final String ELEMENT_RESTORE_LINK = "//td/label/a[contains(text(),'v. {$version}')]/../../../td/a[@title='Restore Revision']";
	public static final String ELEMENT_VERSION_CHECKBOX="//input[@id='version_{$version}']";
	public static final By ELEMENT_COMPARE_BUTTON = By.linkText("Compare Selected");	
	public static final By ELEMENT_VIEW_CHANGE=By.linkText("(View Change)");

	/**
	 * Go to add blank wiki page
	 * @author hakt
	 */
	public static void goToAddBlankPage(){
		info("--Go to add blank wiki page--");
		mouseOver(ELEMENT_ADD_PAGE_LINK, true);
		mouseOverAndClick(ELEMENT_BLANK_PAGE_LINK);
	}
	/** Add wiki page in source editor
	 * @author thuntn
	 * @param content
	 */
	public static void addWikiPageSourceEditor(String content, boolean...verify)
	{
		boolean isVerify = (verify.length > 0)?verify[0]: true;
		type(ELEMENT_CONTENT_WIKI_INPUT,content,true);
		click(ELEMENT_SAVE_BUTTON);
		if(isVerify == true) waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}

	/** Add wiki page in richtext
	 * @author thuntn
	 * @param content
	 */
	public static void addWikiPageRichtext(String content, boolean...verify)
	{
		boolean isVerify = (verify.length > 0)?verify[0]: true;
		click(ELEMENT_RICHTEXT_BUTTON);
		waitForElementPresent(ELEMENT_SOURCE_EDITOR_BUTTON);
		inputDataToFrame(ELEMENT_CONTENT_WIKI_FRAME, content,true);
		driver.switchTo().defaultContent(); 
		click(ELEMENT_SAVE_BUTTON);
		if(isVerify == true) waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}


	/**
	 * Modify data with source editor
	 * @author hakt
	 * updated: thuntn
	 * @param title
	 * @param content
	 */
	public static void modifyDataForWikiPageSourceEditor(String title, String content){
		info("Modify data with source editor");
		if(title != null)
			type(ELEMENT_TITLE_WIKI_INPUT, title, true);
		if(content != null)
			type(ELEMENT_CONTENT_WIKI_INPUT,content,true);
	}

	/**
	 * Modify data with rich editor
	 * @author hakt
	 * updated: thuntn
	 * @param title
	 * @param content
	 */
	public static void modifyDataForWikiPageRichTextEditor(String title, String content){
		if(title != null)
			type(ELEMENT_TITLE_WIKI_INPUT, title, true);
		click(ELEMENT_RICHTEXT_BUTTON);
		waitForElementPresent(ELEMENT_SOURCE_EDITOR_BUTTON);
		if (content != null){
			inputDataToFrame(ELEMENT_CONTENT_WIKI_FRAME, content,true);
			driver.switchTo().defaultContent();
		}
	}
	/** Add a wiki page from blank
	 * @author thuntn
	 * @param title
	 * @param content
	 * @param mode =1: edit a wiki page in richtext
	 * mode =0 : edit a wiki page in source editor
	 */
	public static void addBlankWikiPage(String title, String content,int mode)
	{
		goToAddBlankPage();
		info("--Add a wiki page from blank--");

		if (mode == 1){ 

			modifyDataForWikiPageRichTextEditor(title, content);
		}
		else
			modifyDataForWikiPageSourceEditor(title, content);

		save();
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}

	/**
	 * Preview wiki page before saving
	 * @param title : Page title
	 * @param content : Page content
	 * @param mode : editor mode
	 *             - 1 for RichTextEditor
	 *             - 0 for textarea element
	 * @author dunghm
	 */
	public static void previewWikiPage(String title, String content,int mode){
		mouseOver(ELEMENT_ADD_PAGE_LINK, true);
		mouseOverAndClick(ELEMENT_BLANK_PAGE_LINK);
		type(ELEMENT_TITLE_WIKI_INPUT, title, true);
		if ( mode == 1 ){
			click(ELEMENT_RICHTEXT_BUTTON);
			waitForElementPresent(ELEMENT_SOURCE_EDITOR_BUTTON);
			inputDataToFrame(ELEMENT_CONTENT_WIKI_FRAME, content,true);
			driver.switchTo().defaultContent();
		}
		else {
			type(ELEMENT_CONTENT_WIKI_INPUT,content,true);
		}
		click(ELEMENT_PREVIEW_BUTTON);
		waitForElementPresent(ELEMENT_PREVIEW_SCREEN);
	}

	public static void cancelCreatingWikiPage(String title, String content,int mode){
		mouseOver(ELEMENT_ADD_PAGE_LINK, true);
		mouseOverAndClick(ELEMENT_BLANK_PAGE_LINK);
		type(ELEMENT_TITLE_WIKI_INPUT, title, true);
		if ( mode == 1 ){
			click(ELEMENT_RICHTEXT_BUTTON);
			waitForElementPresent(ELEMENT_SOURCE_EDITOR_BUTTON);
			inputDataToFrame(ELEMENT_CONTENT_WIKI_FRAME, content,true);
			driver.switchTo().defaultContent();
		}
		else {
			type(ELEMENT_CONTENT_WIKI_INPUT,content,true);
		}
		cancel();
		waitForWikiConfirmation("Are you sure to leave this page?");
		waitForElementNotPresent(By.xpath("//div[@class='UIWikiPageTitleControlForm_PageControlArea']/span[@class='TitleInfo' and text()='" + title + "']"));

	}
	/**
	 * Add a new wiki page with a invalid data 
	 * @param title : Page title
	 * @param content : Page content
	 * @param mode : editor mode
	 *             - 1 for RichTextEditor
	 *             - 0 for textarea element 
	 * @param message : a error message 
	 * @author dunghm
	 */
	public static void addWikiPageWithInvalid(String title, String content,int mode, String message)
	{
		info("--Add a wiki page from blank--");
		mouseOver(ELEMENT_ADD_PAGE_LINK, true);
		mouseOverAndClick(ELEMENT_BLANK_PAGE_LINK);
		type(ELEMENT_TITLE_WIKI_INPUT, title, true);
		if (mode == 1){
			addWikiPageRichtext(content, false);
		}
		else
			addWikiPageSourceEditor(content, false);
		waitForMessage(message);
		click(By.linkText("OK"));
	}
	/**
	 * Verify a specific confirm message in wiki 
	 * @param message : message for confirmation
	 * @param isCancel : OK will be click by default, but if isCancel is set true, Cancel button will be click
	 */
	public static void waitForWikiConfirmation(String message, boolean...isCancel){
		By btnOK = By.xpath("//input[@type='button' and @value='OK']");
		By btnCancel = By.xpath("//input[@type='button' and @value='Cancel']");
		By messageLocator = By.xpath("//div[@class=' ConfirmMessage' and text()='" + message + "']");
		waitForElementPresent(messageLocator);
		if(isCancel.length > 0 && (isCancel[0] == true)) 
			click(btnCancel);
		else
			click(btnOK);
		waitForElementNotPresent(messageLocator);
	}

	/**
	 * Go to add template wiki page
	 * @author hakt
	 */
	public static void goToAddTemplateWikiPage(){
		info("--Go to add template wiki page--");
		mouseOver(ELEMENT_ADD_PAGE_LINK, true);
		mouseOverAndClick(ELEMENT_FROM_TEMPLATE_LINK);
	}

	/** Add a wiki page from template
	 * @author thuntn
	 * @param title
	 * @param content
	 * @param mode: mode =1: edit a wiki page in richtext
	 * mode =0 : edit a wiki page in source editor
	 * @param template
	 */
	public static void addTemplateWikiPage(String title, int mode, String template)
	{
		By eTemplate = By.xpath(ELEMENT_SELECT_TEMPLATE_LINK.replace("{$template}",template));

		goToAddTemplateWikiPage();
		info("--Add a wiki page from template--");

		click(eTemplate);
		goToAddTemplateWikiPage();
		info("--Add a wiki page from template--");

		click(eTemplate);
		if (mode == 1){ 

			modifyDataForWikiPageRichTextEditor(title, null);
		}
		else
			modifyDataForWikiPageSourceEditor(title, null);

		save();
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}

	/** Edit a wiki page
	 * @author thuntn
	 * Updated by ThaoPTH: minorEdit
	 * @param title
	 * @param content
	 * @param mode =0 : edit a wiki page in source editor
	 * mode =1: edit a wiki page in richtext
	 * If you don't want to edit any field, you can pass null value to the respective parameter
	 */
	public static void editWikiPage(String title, String content, int mode, boolean minorEdit)
	{
		info("--Edit a wiki page--");

		click(ELEMENT_EDIT_PAGE_LINK);

		if(mode == 0){
			modifyDataForWikiPageSourceEditor(title, content);

		}else{
			modifyDataForWikiPageRichTextEditor(title, content);

		}
		if (minorEdit) {
			click(ELEMENT_MINOR_EDIT_BUTTON);
			waitForElementNotPresent(ELEMENT_MINOR_EDIT_BUTTON);
		}
		else {
			save();

			waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
		}
		pause(5000);
	}
	/** Go to Delete Page
	 * @author HangNTT
	 */
	public static void goToDeletePage()
	{
		mouseOver(ELEMENT_MORE_LINK,true);
		mouseOverAndClick(ELEMENT_DELETE_LINK);
	}
	/** Delete a wiki page
	 * @author thuntn
	 */
	public static void deleteWikiPage()
	{
		info("--Delete a wiki page--");

		goToDeletePage();

		click(ELEMENT_OK_BUTTON);

		waitForElementNotPresent(ELEMENT_OK_BUTTON);
	}
	/** Delete a wiki page without Confirmation
	 * @author HangNTT
	 */
	public static void deleteWikiPageWithoutConfirm()
	{
		info("--Delete a wiki page without confirmation--");

		goToDeletePage();

		click(ELEMENT_CANCEL_BUTTON);

		waitForElementNotPresent(ELEMENT_CANCEL_BUTTON);
	}
	/** Go to a wiki page
	 * @author thuntn
	 * @param path: path of a page
	 */
	public static void goToWikiPage(String path){
		String bExpandIcon = "//a[@title='{$node}']/../../..";
		String[] nodes = path.split("/");
		int length = nodes.length -1;

		info("--Goto a wiki page--");

		for (int index = 0;index < length;index++)
		{ 	
			String node = nodes[index];
			String nodeNext = nodes[index+1];

			if(waitForAndGetElement(bExpandIcon.replace("{$node}",nodeNext),5000,0) == null)
				click(bExpandIcon.replace("{$node}",node));
			pause(100);
		}
		String nodeLast = nodes[length];
		click(By.linkText(nodeLast));

	}
	/** Search quick
	 * @author thuntn
	 * @param keyword
	 */
	public static void quickSearch(String keyword){

		info("--Search quick--");

		type(ELEMENT_QUICK_SEARCH,keyword,true);

		((JavascriptExecutor) driver).executeScript("javascript:eXo.wiki.UIWikiSearchBox.doAdvanceSearch();");

		waitForElementPresent(ELEMENT_SEARCH_BUTTON);
	}

	/**Advance search
	 * @author thuntn
	 * @param keyword: 
	 * @param space: space name which is searched 
	 */
	public static void advancedSearch(String keyword, String...space){

		info("--Advanced Search--");

		type(ELEMENT_QUICK_SEARCH,"advance search",true);

		type(ELEMENT_QUICK_SEARCH,keyword,true);

		((JavascriptExecutor) driver).executeScript("javascript:eXo.wiki.UIWikiSearchBox.doAdvanceSearch();");
		type(ELEMENT_SEARCH_ADVANCE,keyword,true);
		if(space.length > 0)
			select(By.name("wikis"), space[0]);
		click(ELEMENT_SEARCH_BUTTON);	

	}
	/** Go to Watch Page
	 * @author HangNTT
	 */
	public static void goToWatchPage(){

		mouseOver(ELEMENT_MORE_LINK,true);

		mouseOverAndClick(ELEMENT_WATCH_LINK);
	}
	/** Watch a wiki page
	 * @author thuntn
	 */
	public static void watchWikiPage(){
		info("--Watch a wiki page--");

		goToWatchPage();

		waitForMessage("You started watching this page now.");

		closeMessageDialog();	
	}
	/** Go to UnWatch Page
	 * @author HangNTT
	 */
	public static void goToUnWatchPage(){

		mouseOver(ELEMENT_MORE_LINK,true);

		mouseOverAndClick(ELEMENT_UNWATCH_LINK);
	}
	/** Unwatch a wiki page
	 * @author thuntn
	 */
	public static void unwatchWikiPage(){

		info("--Unwatch a wiki page--");

		goToUnWatchPage();

		waitForMessage("You stopped watching this page now.");

		closeMessageDialog();	

	}
	/** Go to Move Page
	 * @author HangNTT
	 */
	public static void goToMovePage(){

		mouseOver(ELEMENT_MORE_LINK,true);

		mouseOverAndClick(ELEMENT_MOVE_PAGE_LINK);
	}
	/** Move Page
	 * @author: HangNTT
	 * @param pageName1
	 * @param pageName2
	 */
	public static void movePage(String pageName1, String pageName2){

		By ELEMENT_VERIFY_CURRENT_LOCATION = By.xpath("//label[text()='Current Location']/../..//*[@class='LeftBlock' and text()='"+ pageName1 +"']");

		By ELEMENT_VERIFY_NEW_LOCATION = By.xpath("//label[text()='New Location']/../..//*[@class='LeftBlock' and text()='"+ pageName2 +"']");

		By ELEMENT_VERIFY_AFTER_MOVE_PAGE = By.xpath("//a[@title='"+ pageName2 +"']/ancestor::div[@id='UITreeExplorer']//*[@title='"+pageName1+"']");

		By ELEMENT_NEW_LOCATION = By.xpath("//*[@id='iconTreeExplorer' and contains(@onclick, 'event')]//a[@title='"+ pageName2 +"']");

		info("Move a page");

		goToMovePage();

		info("CURRENT_LOCATION");

		waitForElementPresent(ELEMENT_VERIFY_CURRENT_LOCATION);

		click(ELEMENT_NEW_LOCATION);

		waitForElementPresent(ELEMENT_VERIFY_NEW_LOCATION);

		click(CLICK_MOVE_ACTION);

		waitForElementPresent(ELEMENT_VERIFY_AFTER_MOVE_PAGE);
	}
	/** Go to Page Permission
	 * @author: HangNTT
	 */
	public static void goToPagePermission(){

		mouseOver(ELEMENT_MORE_LINK, true);

		mouseOverAndClick(ELEMENT_PAGE_PERMISSION_LINK);
	}

	/** Edit permission for wiki's page
	 * @author HangNTT
	 * @param user: username 
	 * @param edit: true , then this user/group have edit permission and vice versa
	 */
	public static void editPagePermission(String user,boolean edit,boolean viewPage){

		By EditPage = By.xpath(ELEMENT_EDIT_PAGE_CHECK.replace("{$user}", user));

		By ViewPage = By.xpath(ELEMENT_VIEW_PAGE_CHECK.replace("{$user}", user));

		goToPagePermission();

		info("--Add space permission--");
		if (edit){
			if(!waitForAndGetElement(EditPage).isSelected()){
				click(EditPage);
			}
		}
		else{
			if(waitForAndGetElement(EditPage).isSelected())
				click(EditPage);
		}
		if (viewPage){
			if(!waitForAndGetElement(ViewPage).isSelected()){
				click(ViewPage);
			}
		}
		else{
			if(waitForAndGetElement(ViewPage).isSelected())
				click(ViewPage);
		}
		save();
	}

	/** Go to page info
	 * @author thuntn
	 */
	public static void goToPageInfo(){
		info("--Go to page info--");
		mouseOver(ELEMENT_MORE_LINK,true);
		mouseOverAndClick(ELEMENT_PAGE_INFO_LINK);
	}
	/** Add page permission for an user
	 * @author: Thuntn
	 * 
	 * @param option: if the value of option determines  meaning of the userGroups parameter
	 * option = 0: userGroup[0]= user
	 * option = 1: userGroup[0]= user
	 * option = 2: userGroup[0] = path of a group
	 * option !=0,1,2: userGroup[0] = path of a group, userGroup[1] = membership
	 * @param userGroup: array of string
	 */
	public static void addPagePermission(int option, String[] userGroup){

		info("--Add page permission for an user--");

		goToPagePermission();

		if(userGroup[0]!=null)
		{
			switch(option){

			case 0: type(ELEMENT_SELECT_INPUT,userGroup[0],true); break;
			case 1: click(ELEMENT_SELECT_USER);
			selectUserPermission(userGroup[0]); break;
			case 2: click(ELEMENT_SELECT_GROUP);
			selectGroupPermission(userGroup[0]); break;
			default: if (userGroup[1] !=null) {
				click(ELEMENT_SELECT_MEMBERSHIP);
				selectGroupMembership( userGroup[0], userGroup[1]);
			}
			break;
			}			
			click(ELEMENT_ADD_BUTTON);
			save();
		}
	}
	/** Go to the template management page
	 * @author thuntn
	 */
	public static void goToTemplateManagement(){
		info("--Go to the template management page--");

		mouseOver(ELEMENT_BROWSE_LINK,true);

		mouseOverAndClick(ELEMENT_SPACE_SETTING_LINK);

		click(ELEMENT_TEMPLATE_LINK);			
	}

	/**Add a wiki page template
	 * @author thuntn
	 * @param title
	 * @param description
	 * @param content
	 */
	public static void addTemplate(String title, String description, String content){

		goToTemplateManagement();
		info("--Add a wiki page template--");

		click(ELEMENT_ADD_TEMPLATE_LINK);

		type(ELEMENT_TITLE_TEMPLATE_INPUT,title,true);
		type(ELEMENT_DESC_TEMPLATE_INPUT,description,true);
		type(ELEMENT_CONTENT_TEMPLATE_INPUT,content,true);
		click(ELEMENT_SAVE_TEMPLATE_INPUT);
		waitForMessage(MSG_CREATE_TEMPLATE);
		closeMessageDialog();
		waitForElementNotPresent(ELEMENT_SAVE_TEMPLATE_INPUT);

	}
	/** 
	 *Edit a wiki page template
	 * @author thuntn
	 * @param oldTitle: old title of a template
	 * @param title: new title
	 * @param description: new description
	 * @param content: new content
	 * If you don't want to edit any field, you can pass null value to the respective parameter
	 */
	public static void editTemplate(String oldTitle, String title, String description, String content){

		goToTemplateManagement();

		info("--Edit a wiki page template--");
		click(ELEMENT_EDIT_TEMPLATE_ICON.replace("{$template}", oldTitle));
		if (title != null)
			type(ELEMENT_TITLE_TEMPLATE_INPUT,title,true);
		if (description != null)
			type(ELEMENT_DESC_TEMPLATE_INPUT,null,true);
		if (content != null)
			type(ELEMENT_CONTENT_TEMPLATE_INPUT,null,true);
		click(ELEMENT_SAVE_TEMPLATE_INPUT);

		waitForElementNotPresent(ELEMENT_SAVE_TEMPLATE_INPUT);

	}
	/** Delete a wiki page template
	 * @author thuntn
	 * @param title
	 */
	public static void deleteTemplate(String title){

		goToTemplateManagement();

		info("--Delete a wiki page template--");

		click(ELEMENT_DELETE_TEMPLATE_ICON.replace("{$template}", title));

		waitForConfirmation(MSG_DELETE_TEMPLATE);

		waitForElementNotPresent(ELEMENT_DELETE_TEMPLATE_ICON.replace("{$template}", title));
	}
	/** Search for templates
	 * @author thuntn
	 * @param keyword
	 */
	public static void searchTemplate(String keyword){
		type(ELEMENT_SEARCH_TEMPLATE_INPUT, keyword, true);
		click(ELEMENT_SEARCH_BUTTON);
	}
	/** Go to space setting
	 * @author thuntn
	 */
	public static void goToSpacePermission(){
		mouseOver(ELEMENT_BROWSE_LINK,true);
		mouseOverAndClick(ELEMENT_SPACE_SETTING_LINK);
		click(ELEMENT_PERMISSION_LINK);
	}

	/** Attach a file
	 * @author thuntn
	 * @param link
	 */
	public static void attachFileInWiki(String link){
		String path = getAbsoluteFilePath(link);

		info("--Attach a file--");
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_FRAME_UPLOAD));

		ELEMENT_UPLOAD_FILE = By.xpath("//input[@id='WikiUploadFile']");

		try{
			WebElement element = waitForAndGetElementNotDisplay(ELEMENT_UPLOAD_FILE);
			element.sendKeys(path);

		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			pause(WAIT_INTERVAL);
			attachFileInWiki(link);

		}  catch (ElementNotVisibleException e) {

			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			pause(WAIT_INTERVAL);
			attachFileInWiki(link);

		} finally {
			loopCount = 0;
		}

		switchToParentWindow();
	}
	public static WebElement waitForAndGetElementNotDisplay(Object locator, int... opParams) {
		WebElement elem = null;
		int timeout = opParams.length > 0 ? opParams[0] : DEFAULT_TIMEOUT;
		int isAssert = opParams.length > 1 ? opParams[1]: 1;

		for (int tick = 0; tick < timeout/WAIT_INTERVAL; tick++) {
			elem = getElement(locator);

			if (null != elem){
				return elem;}
			pause(WAIT_INTERVAL);
		}
		if (isAssert == 1)		
			assert false: ("Timeout after " + timeout + "ms waiting for element present: " + locator);
		return null;
	}
	/** Delete an attachment
	 * @author thuntn
	 * @param fName: name of a file which will be deleted
	 */
	public static void deleteFile(String fName){

		info("--Delete an attachment--");
		String removeIcon= ELEMENT_REMOVE_ATTACHMENT.replace("{$file}", fName);

		click(ELEMENT_EDIT_PAGE_LINK);
		click(removeIcon);
		waitForElementNotPresent(removeIcon);
	}
	/** View change of a page
	 * @author thuntn
	 */
	public static void viewChange()
	{
		info("--View change of a page--");
		click(ELEMENT_VIEW_CHANGE);
		waitForElementPresent(ELEMENT_COMPARE_TEXT);
	}
	/**View a version of a page
	 * @author thuntn
	 * @param version: number of version
	 */
	public static void viewVersion(String version){
		info("--View a version of a page--");

		String versionLink = ELEMENT_VERSION_LINK.replace("{$version}",version);
		click(ELEMENT_REVISION_LINK);
		click(versionLink);
	}
	/** Restore a version of a page
	 * @author thuntn
	 * @param version: number of version
	 */
	public static void restoreVersion(String version){
		info("--Restore a version of a page--");

		String versionLink = ELEMENT_RESTORE_LINK.replace("{$version}",version);
		click(ELEMENT_REVISION_LINK);
		click(versionLink);
	}
	/** Compare 2 versions of a page
	 * @author thuntn
	 * @param first: number of the first version
	 * @param second: number of the second version
	 */
	public static void compareVersion(String first, String second){
		info("--Compare 2 versions of a page--");

		String versionCheckbox1 = ELEMENT_VERSION_CHECKBOX.replace("{$version}", first);
		String versionCheckbox2= ELEMENT_VERSION_CHECKBOX.replace("{$version}", second);

		click(ELEMENT_REVISION_LINK);
		click(versionCheckbox1);
		click(versionCheckbox2);
		click(ELEMENT_COMPARE_BUTTON);
		waitForElementPresent(ELEMENT_COMPARE_TEXT);
	}
	/**
	 * 
	 * @param option: if the value of option determines  meaning of the userGroups parameter
	 * option = 0: userGroup[0]= user
	 * option = 1: userGroup[0]= user
	 * option = 2: userGroup[0] = path of a group
	 * option !=0,1,2: userGroup[0] = path of a group, userGroup[1] = membership
	 * @param groupUser: array of string
	 */
	public static void addSpacePermission(int option, String[] groupUser){

		goToSpacePermission();

		info("--Add space permission--");
		switch(option) {
		case 0: type(ELEMENT_SELECT_INPUT,groupUser[0],true);
		break;
		case 1:	click(ELEMENT_SELECT_USER);
		selectUserPermission(groupUser[0]);
		break;

		case 2: click(ELEMENT_SELECT_GROUP);
		selectGroupPermission(groupUser[0]);
		break;

		default: click(ELEMENT_SELECT_MEMBERSHIP);
		selectGroupMembership(groupUser[0], groupUser[1]);
		break;
		}
		click(ELEMENT_ADD_BUTTON);
		save();
		waitForMessage(MSG_PERMISSION_SAVE);
		closeMessageDialog();
	}
	/** Edit a space permission for an user, or a group
	 * @author thuntn
	 * @param userGroup: username or group, or membership. eg: "*:/platform/users"
	 * @param view: true , then this user/group have view permission and vice versa
	 * @param edit: true , then this user/group have edit permission and vice versa
	 * @param adminPage: true , then this user/group have admin page permission and vice versa
	 * @param adminSpace: true , then this user/group have admin space permission and vice versa
	 */
	public static void editSpacePermission(String userGroup,boolean view,boolean edit, boolean adminPage, boolean adminSpace){
		By bEditPage = By.xpath(ELEMENT_EDIT_PAGE_CHECK.replace("{$user}", userGroup));
		By bAdminPage = By.xpath(ELEMENT_ADMIN_PAGE_CHECK.replace("{$user}", userGroup));
		By bAdminSpace = By.xpath(ELEMENT_ADMIN_SPACE_CHECK.replace("{$user}", userGroup));
		By bViewSpace = By.xpath(ELEMENT_VIEW_SPACE_CHECK.replace("{$user}", userGroup));

		info("--Add space permission--");

		if (view){
			if(!waitForAndGetElement(bViewSpace).isSelected()){
				click(bViewSpace);
			}
		}else{
			if(waitForAndGetElement(bViewSpace).isSelected())
				click(bViewSpace);
		}
		if (edit){
			if(!waitForAndGetElement(bEditPage).isSelected()){
				click(bEditPage);
			}
		}else{
			if(waitForAndGetElement(bEditPage).isSelected())
				click(bEditPage);
		}
		if (adminPage){
			if(!waitForAndGetElement(bAdminPage).isSelected()){
				click(bAdminPage);
			}
		}else{
			if(waitForAndGetElement(bAdminPage).isSelected())
				click(bAdminPage);
		}

		if (adminSpace){
			if(!waitForAndGetElement(bAdminSpace).isSelected()){
				click(bAdminSpace);
			}
		}else{
			if(waitForAndGetElement(bAdminSpace).isSelected())
				click(bAdminSpace);
		}

		save();
		waitForMessage(MSG_PERMISSION_SAVE);
		closeMessageDialog();
	}
	/** Delete a space permission for an user, or a group
	 * @author thuntn
	 * @param userGroup: username or group, or membership. eg: "*:/platform/users"
	 * 
	 */
	public static void deleteSpacePermission(String userGroup){
		By bDelete = By.xpath(ELEMENT_DELETE_PERMISSION.replace("{$user}", userGroup));

		goToSpacePermission();

		info("--Add space permission--");

		click(bDelete);

		save();
		waitForMessage(MSG_PERMISSION_SAVE);
		closeMessageDialog();

	}




	/** Delete permission for an user
	 * @author: HangNTT
	 * @param user: username or group, or membership. eg: "*:/platform/users"
	 * 
	 */
	public static void deletePermission(String user){

		By Delete = By.xpath(ELEMENT_DELETE_PERMISSION.replace("{$user}", user));

		goToPagePermission();

		info("--Delete permission--");

		click(Delete);

		waitForElementNotPresent(Delete);

		save();

	}

	/**
	 * @author thaopth
	 * @param paragraphTitle: input paragraph title without space character
	 * @param paragraphContent: input paragraph content with heading followed help tips
	 */
	public static void editParagraph (String paragraphTitle, String paragraphContent) {
		String ELEMENT_PARAGRAPH_ID = "H"+paragraphTitle;

		mouseOver(By.id(ELEMENT_PARAGRAPH_ID), true);

		click(By.xpath("//a[@title='Edit section: " + paragraphTitle + "']"));

		type(ELEMENT_CONTENT_WIKI_INPUT,paragraphContent,true);

		click(ELEMENT_SAVE_BUTTON);

		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}

	/** Edit permission for wiki's page
	 * @author HangNTT
	 * @param user: username
	 * @param edit: true , then this user/group have edit permission and vice versa
	 */
	public static void editPagePermission(String user,boolean edit){
		By EditPage = By.xpath(ELEMENT_EDIT_PAGE_CHECK.replace("{$user}", user));

		mouseOver(ELEMENT_MORE_LINK, true);
		mouseOverAndClick(ELEMENT_PAGE_PERMISSION_LINK);
		info("--Add space permission--");

		if (edit){
			if(!waitForAndGetElement(EditPage).isSelected()){
				click(EditPage);
			}
		}
		save();
	}

	/** Edit a wiki page
	 * @author thuntn
	 * @param title
	 * @param content
	 * @param mode =0 : edit a wiki page in source editor
	 * mode =1: edit a wiki page in richtext
	 * If you don't want to edit any field, you can pass null value to the respective parameter
	 */
	public static void editWikiPage(String title, String content, int mode)
	{
		info("--Edit a wiki page--");

		click(ELEMENT_EDIT_PAGE_LINK);
		if (title != null)
			type(ELEMENT_TITLE_WIKI_INPUT,title,true);
		if (content != null)
			if(mode == 0){
				type(ELEMENT_CONTENT_WIKI_INPUT,content,true);

			}
			else{
				click(ELEMENT_RICHTEXT_BUTTON);
				inputDataToFrame(ELEMENT_CONTENT_WIKI_FRAME, content, true);
				driver.switchTo().defaultContent();

			}
		save();
		waitForElementNotPresent(ELEMENT_SAVE_BUTTON);
	}
}
