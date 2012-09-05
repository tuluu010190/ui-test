package org.exoplatform.selenium.platform.ecms;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.exoplatform.selenium.platform.PlatformBase;
import static org.exoplatform.selenium.TestLogger.*;


public class EcmsBase extends PlatformBase {
	
	public static final By ELEMENT_ACME_LINKTEXT = By.linkText("Login to the ACME website");
	public static final By ELEMENT_LOGIN_LINK = By.xpath("//*[@id='AcmeWebSiteLogInLogOut']");
	public static final By ELEMENT_LOGIN_BUTTON = By.xpath("//*[@id='UIPortalLoginFormAction']");
	public static final By ELEMENT_LOGOUT_LINK = By.xpath("//a[@class='TBIcon']");
	public static final By ELEMENT_MENU_SETUP_IMG = By.xpath("//img[@alt='Setup']") ;
	public static final By ELEMENT_MENU_PORTAL_LINK_LINKTEXT = By.linkText("Portal");
	public static final By ELEMENT_MENU_PAGE_LINK_LINKTEXT = By.linkText("Pages");
	public static final By ELEMENT_MENU_CONTENT_LINK = By.linkText("Content");
	public static final By ELEMENT_MENU_SITE_EXPLORER_LINK = By.linkText("Sites Explorer");
	public static final By ELEMENT_MENU_EDIT_LINK = By.linkText("Edit");
	public static final By ELEMENT_MENU_PAGE_LINK = By.linkText("Page");
	public static final By ELEMENT_MENU_ADD_PAGE_LINK = By.linkText("Add Page");
	public static final By ELEMENT_MENU_NEW_CONTENT_LINK = By.linkText("New Content");
	public static final By ELEMENT_MENU_SITE_LINK = By.linkText("Site");
	public static final By ELEMENT_MENU_NAVIGATION_LINK = By.linkText("Navigation");
	
	public static final By ELEMENT_ARTICLE_LINK = By.xpath("//div[@title='Article']");
	public static final By ELEMENT_ARTICLE_TITLE_TEXTBOX = By.id("title");	
	public static final By ELEMENT_ARTICLE_NAME_TEXTBOX = By.id("name");
	public static final By ELEMENT_ARTICLE_SUMMARY_FRAME = By.xpath("//td[@id='cke_contents_summary']/iframe");
	public static final By ELEMENT_ARTICLE_CONTENT_FRAME = By.xpath("//td[@id='cke_contents_content']/iframe");
	public static final By ELEMENT_SAVE_CLOSE_BUTTON = By.linkText("Save & Close");
	
	public static final By ELEMENT_ANNOUCEMENT_LINK = By.linkText("Announcement");
	public static final By ELEMENT_ANNOUCEMENT_NAME_TEXTBOX = By.id("name");
	public static final By ELEMENT_ANNOUCEMENT_SUMMARY_FRAME = By.xpath("//td[@id='cke_contents_exo:summary']/iframe");
	
	public static final By ELEMENT_WEBCONTENT_LINK =By.linkText("Free layout webcontent");
	public static final By ELEMENT_WEBCONTENT_TITLE_TEXTBOX =By.id("title");	
	public static final By ELEMENT_WEBCONTENT_NAME_TEXTBOX =By.id("name");	
	public static final By ELEMENT_WEBCONTENT_CONTENT_FRAME = By.xpath("//td[contains(@id,'cke_contents_htmlData')]/iframe");
	public static final By ELEMENT_WEBCONTENT_ILLUSTRATION_TAB = By.xpath("//div[contains(text(),'Illustration')]");
	public static final By ELEMENT_WEBCONTENT_UPLOAD_FRAME =By.xpath("//*[contains(@id,'uploadFrame')]");
	public static final By ELEMENT_WEBCONTENT_FILE_IMAGE = By.id("file");
	public static final By ELEMENT_WEBCONTENT_SUMMARY_FRAME = By.xpath("//td[@id='cke_contents_exo:summary']/iframe");
	public static final By ELEMENT_WEBCONTENT_ADVANCE_TAB = By.xpath("//div[contains(text(),'Advanced')]");
	public static final By ELEMENT_WEBCONTENT_CSS_TEXTAREA = By.xpath("//textarea[contains(@id,'ContentCSS')]");
	public static final By ELEMENT_WEBCONTENT_JS_TEXTAREA = By.xpath("//textarea[contains(@id,'ContentJS')]");
	
	public static final By ELEMENT_NEWFILE_LINK =By.linkText("File");
	public static final By ELEMENT_NEWFILE_NAME_TEXTBOX =By.id("name");
	public static final By ELEMENT_NEWFILE_CONTENT_FRAME = By.xpath("//td[@id='cke_contents_contentHtml']/iframe");
	public static final By ELEMENT_NEWFILE_TITLE_TEXTBOX =By.id("title0");
	
	public static final By ELEMENT_SAMPLENODE_LINK =By.linkText("Sample node");
	public static final By ELEMENT_SAMPLENODE_TITLE_TEXTBOX = By.id("title");
	public static final By ELEMENT_SAMPLENODE_NAME_TEXTBOX = By.id("name");
	public static final By ELEMENT_SAMPLENODE_ADD_ITEM_LINK = By.xpath("//img[@title = 'Add Item']");	
	public static final By ELEMENT_SAMPLENODE_SELECTITEM = By.id("taxonomyTree");
	public static final String ELEMENT_SAMPLENODE_SELECTITEM_OPTION = "acme";
	public static final By ELEMENT_SAMPLENODE_SELECTITEM_OPTION_LINK = By.xpath("//div[@class='Select16x16Icon']");
	public static final By ELEMENT_SAMPLENODE_DESCRIPTION_TEXTBOX = By.id("description");
	public static final By ELEMENT_SAMPLENODE_UPLOAD_IMG_FRAME = By.xpath("//iframe[contains(@id,'uploadFrame')]");
	public static final By ELEMENT_SAMPLENODE_FILE_IMG = By.id("file") ;
	public static final By ELEMENT_SAMPLENODE_CONTENT_TEXTAREA = By.id("summary");
	public static final By ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA = By.id("content");
	
	public static final By ELEMENT_KOFAX_LINK = By.linkText("Kofax document");
	public static final By ELEMENT_KOFAX_NAME_TEXTBOX = By.id("name");
	public static final By ELEMENT_KOFAX_ADDNODE_LINK = By.xpath("//img[@class='MultiFieldAction AddNewNodeIcon']") ;
	public static final By ELEMENT_KOFAX_ADDNODE_SELECT = By.id("taxonomyTree");
	public static final String ELEMENT_KOFAX_ADDNODE_OPTION = "acme";
	public static final By ELEMENT_KOFAX_ADDNODE_OPTION_LINK = By.xpath("//div[@class='Select16x16Icon']");
	
	
	public static final By ELEMENT_FILEPLAN_LINK = By.linkText("File Plan");
	public static final By ELEMENT_FILEPLAN_NAME = By.id("name");
	public static final By ELEMENT_FILEPLAN_RECORD_TAB = By.xpath("//div[contains(text(),'Record Properties')]");
	public static final By ELEMENT_FILEPLAN_RECORD_TEXTBOX = By.id("recordCategoryIdentifier");
	public static final By ELEMENT_FILEPLAN_DISPOS_TEXTBOX = By.id("dispositionAuthority");
	public static final By ELEMENT_FILEPLAN_DEFAULT_TEXTBOX  = By.id("defaultOriginatingOrganization");
	public static final By ELEMENT_FILEPLAN_RPROCESS_TAB = By.xpath("//div[contains(text(),'Process Properties')]");
	public static final By ELEMENT_FILEPLAN_RPROCESS_TRIGER = By.id("eventTrigger");	
	
	public static final By ELEMENT_PODCAST_LINK = By.linkText("Podcast");
	public static final By ELEMENT_PODCAST_NAME_TEXTBOX = By.id("name");
	public static final By ELEMENT_PODCAST_TITLE_TEXTBOX = By.id("title");
	public static final By ELEMENT_PODCAST_LINK_TEXTBOX = By.id("link");
	
	public static final By ELEMENT_HEAD_LAYOUT_LINK = By.linkText("Picture on head layout webcontent");
	public static final By ELEMENT_HEAD_LAYOUT_NAME_TEXTBOX = By.id("name");
	public static final By ELEMENT_HEAD_LAYOUT_TITLE_TEXTBOX = By.id("title");	
	public static final By ELEMENT_HEAD_LAYOUT_UPLOAD_FRAME = By.xpath("//iframe[contains(@id,'uploadFrame')]")	;
	public static final By ELEMENT_HEAD_LAYOUT_UPLOAD_FILE = By.id("file") ;
	
	public static final By ELEMENT_PRODUCT_LINK = By.linkText("Product");
	public static final By ELEMENT_PRODUCT_NAME_TEXTBOX = By.id("name") ;
	public static final By ELEMENT_PRODUCT_TITLE_TEXTBOX = By.id("title");
	
	public static final By ELEMENT_NEW_FOLDER_LINK = By.linkText("New Folder");
	
	public static final By ELEMENT_NEWPAGE_NAME_TEXTBOX = By.id("pageName");	
	public static final By ELEMENT_NEWPAGE_NEXT_BUTTON = By.linkText("Next");	
	public static final By ELEMENT_NEWPAGE_SAVE_BUTTON = By.xpath("//a[@class='EdittedSaveButton']");
	public static final By ELEMENT_NEWPAGE_LAYOUT_OPTION = By.xpath("//div[@class='DropDownSelectLabel']") ;
	public static final By ELEMENT_NEWPAGE_LAYOUT_COLUMN_PAGE_OPTION = By.linkText("Column Page Configs") ;
	public static final By ELEMENT_NEWPAGE_LAYOUT_ROW_PAGE_OPTION = By.linkText("Row Page Configs");
	public static final By ELEMENT_NEWPAGE_LAYOUT_TAB_PAGE_OPTION = By.linkText("Tabs Page Config");
	public static final By ELEMENT_NEWPAGE_LAYOUT_MIX_PAGE_OPTION = By.linkText("Mix Page Configs");
	public static final By ELEMENT_NEWPAGE_LAYOUT_DEFAULT_OPTION = By.linkText("Page Configs");
	
	public static final By ELEMENT_FOLDER_TITLE_TEXTBOX = By.id("title");
	public static final By ELEMENT_FOLDER_NAME_TEXTBOX = By.id("name");
	public static final By ELEMENT_FOLDER_TYPE_OPTION = By.id("type");
	public static final String ELEMENT_CONTENT_FOLDER_TYPE = "nt:unstructured";
	public static final String ELEMENT_DOCUMENT_FOLDER_TYPE = "nt:folder";
	public static final By ELEMENT_SAVE_BUTTON = By.linkText("Save");
	
	public static final By ELEMENT_SEARCH_TITLEPAGE_TEXTBOX = By.id("pageTitle");
	public static final By ELEMENT_SEARCH_PAGE_ICON = By.xpath("//a[@class='SearchIcon']");
	public static final By ELEMENT_SEARCH_PAGE_ALERT = By.xpath("//[@class= 'UIPopupWindow UIDragObject ExoMessageDecorator']");	
	public static final By ELEMENT_PARTIALLINK_DELETE_DOCUMENT = By.xpath("//a[contains(text(),'Delete')]");
	public static final String ELEMENT_ALERT_CONFIRM_DELETE_DOCUMENT = "Are you sure to delete the node";
	public static final String ELEMENT_ALERT_CONFIRM_DELETE_PAGE = "Are you sure to delete this page?";
	public static final String ELEMENT_ALERT_FIND_AFTER_DELETE_PAGE = "Information" ;
	
	public static final By ELEMENT_SIMPLESEARCH_TEXTBOX = By.id("simpleSearch");
	public static final By ELEMENT_SIMPLESEARCH_SUBMIT = By.id("SimpleSearch");
	
	public static final By ELEMENT_DELETE_PAGE_ICON = By.xpath("//img[@class='DeleteIcon']");
	public static final String ELEMENT_SITE_NAVIGATION_POPUP = "UIPopupWindow-UIEditNavigationPopupContainer";
	public static final By ELEMENT_SITE_NAVIGATION_DELETE_ERROR_ALERT = By.xpath("//div[@class='UIPopupWindow UIDragObject ExoMessageDecorator']");
	public static final String ELEMENT_SITE_NAVIGATION_DELETE_NODE_PARTIALLINK = "Delete";
	public static final By ELEMENT_SITE_NAVIGATION_SAVE_BUTTON = By.linkText("Save");
	
	public static final By ELEMENT_CONTENT_LINK = By.xpath("//a[@title='Content']");
	public static final By ELEMENT_ADD_CONTENT_DETAIL_PORTLET = By.xpath("//div[contains(text(),'Content Detail')]");
	public static final By ELEMENT_DROP_TARGET_NO_LAYOUT = By.xpath("//div[@id='UIPage']");
	public static final By ELEMENT_DROP_TARGET_HAS_LAYOUT = By.xpath("//div[@class='UIRowContainer EmptyContainer']");
	public static final By ELEMENT_ADD_CONTENT_LIST_PORTLET = By.xpath("//div[contains(text(),'Content List')]");
	public static final By ELEMENT_FRAME_CONTAIN_PORTLET = By.xpath("//div[contains(@id,'UIPortlet')]");
	public static final By ELEMENT_EDIT_PORTLET_LINK = By.xpath("//a[@title='Edit Portlet']");
	public static final By ELEMENT_SELECT_CONTENT_PATH_LINK = By.xpath("//img[@class='AddIcon16x16 SelectFolderPathIcon']");
	public static final By ELEMENT_SELECT_CONTENT_PATH_GENERAL_LINK = By.id("GeneralDrives_");
	public static final By ELEMENT_SELECT_CONTENT_PATH_GENERAL_MANAGED_LINK = By.id("GeneralDrives_MANAGEDedSites_");
	public static final By ELEMENT_SELECT_CONTENT_PATH_ACME_LINK = By.id("GeneralDrives_MANAGEDedSites__acme");
	public static final By ELEMENT_SELECT_CONTENT_PATH_ACME_DOC_LINK =By.id("GeneralDrives_MANAGEDedSites__acme_documents") ;
	public static final By ELEMENT_SELECT_CONTENT_PATH_SAVE_BUTTON = By.linkText("Save");
	public static final By ELEMENT_SELECT_CONTENT_PATH_CLOSE_BUTTON =By.linkText("Close") ;
	
	public static final By ELEMENT_SELECT_CONTENT_PATH = By.xpath("//a[@title='offices.jpg']");
	public static final By ELEMENT_SELECT_CLV_PATH = By.xpath("//a[@path='/sites content/live/acme/documents']");
	public static final By ELEMENT_PREFERENCE_LINK =By.xpath("//a[@class='SetupPreferencesButton']");
	public static final String ELEMENT_PREFERENCE_ADVANCE_LINK = "Advanced";
	

	public static final By ELEMENT_UPLOAD_LINK_XPATH = By.xpath("//a[@title='Upload']");
	public static final By ELEMENT_UPLOAD_FILE_NAME_ID = By.id("name");
	public static final By ELEMENT_UPLOAD_IMG_FRAME_XPATH = By.xpath("//iframe[contains(@id,'uploadFrame')]");
	public static final By ELEMENT_UPLOAD_IMG_ID = By.id("file");
	public static final By ELEMENT_UPLOAD_FINISH_XPATH = By.xpath("//div[@class='FileNameLabel']");
	public static final By ELEMENT_UPLOAD_SAVE_BUTTON_LINKTEXT = By.linkText("Save");
	public static final By ELEMENT_UPLOAD_CLOSE_BUTTON_LINKTEXT =By.linkText("Close");

	public static final By ELEMENT_LOCK_OPTION_XPATH = By.xpath("//a[contains(text(),'Lock')]");
	public static final By ELEMENT_UNLOCK_OPTION_XPATH = By.xpath("//a[contains(text(),'UnLock')]");
	
	//login ECMS
	public void loginEcms(String username, String password) {
		driver.manage().window().maximize();
		waitForAndGetElement(ELEMENT_ACME_LINKTEXT).click();
		waitForAndGetElement(ELEMENT_LOGIN_LINK).click();
		pause(100);
		waitForAndGetElement(By.name("username")).sendKeys(username);
		waitForAndGetElement(By.name("password")).sendKeys(password);
		waitForAndGetElement(ELEMENT_LOGIN_BUTTON).click();	
	}
		
	//logout ECMS
	public void logoutEcms (){
		actions.moveToElement(waitForAndGetElement(ELEMENT_LOGOUT_LINK)).build().perform();
		waitForAndGetElement(By.linkText("Logout")).click();
	}
	
	//Select option from combobox
	public void selectOption(By locator,String value){
		Select typeFolder = null;
		pause(100);
		while (typeFolder ==null){
			pause(100);
			typeFolder = new Select(waitForAndGetElement(locator));
		}
		typeFolder.selectByValue(value);
	}
	//Select option from combobox
	public void selectOptionByXpath(By locator,String value){
		Select typeFolder = null;
		pause(100);
		while (typeFolder ==null){
			pause(100);
			typeFolder = new Select(waitForAndGetElement(locator));
		}
		typeFolder.selectByValue(value);
	}
	
	//Enter sites MANAGEDement Form 
	public void goToSiteExplorerForm(){
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_SETUP_IMG)).build().perform();
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_CONTENT_LINK)).build().perform();
		waitForAndGetElement(ELEMENT_MENU_SITE_EXPLORER_LINK).click();
	}
	
	//Enter create new page form
	public void goToNewPageForm(){
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_EDIT_LINK)).build().perform();
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_PAGE_LINK)).build().perform();
		waitForAndGetElement(ELEMENT_MENU_ADD_PAGE_LINK).click();	
	}
	
	//go to new content
	public void goToAddNewContent(){
		waitForAndGetElement(ELEMENT_MENU_NEW_CONTENT_LINK).click();	
	}
	
	//function go to Node
	public void goToNode(By locator){
		waitForAndGetElement(locator).click();
	}
	
	//function add data to frame
	public void inputDataToFrame (By framelocator, String data){
		driver.switchTo().frame(waitForAndGetElement(framelocator));
		WebElement inputsummary = driver.switchTo().activeElement();
		inputsummary.sendKeys(data);
	}
	
	//function switch to parent windows
	public void switchToParentWindow (){
		try
		{
			Set<String> availableWindows = driver.getWindowHandles();
			String WindowIdParent= null;
			int counter = 1;
			for (String windowId : availableWindows) {
				if (counter == 1){
					WindowIdParent = windowId;
				}
				counter++;
			}
			driver.switchTo().window(WindowIdParent);
			pause(1000);
		}
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
	}
	
	// addnew article
	public void createNewArticle(String title, String name, String sum, String cont) {
		waitForAndGetElement(ELEMENT_ARTICLE_LINK).click();
		// Input information
		waitForAndGetElement(ELEMENT_ARTICLE_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElement(ELEMENT_ARTICLE_NAME_TEXTBOX).clear();
		waitForAndGetElement(ELEMENT_ARTICLE_NAME_TEXTBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_ARTICLE_SUMMARY_FRAME,sum);
	    switchToParentWindow();
	    inputDataToFrame(ELEMENT_ARTICLE_CONTENT_FRAME,cont);
	    switchToParentWindow();
	    //save
	    waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new annoucement
	public void createNewAnnouncement (String name, String sum){
		waitForAndGetElement(ELEMENT_ANNOUCEMENT_LINK).click();
		waitForAndGetElement(ELEMENT_ANNOUCEMENT_NAME_TEXTBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_ANNOUCEMENT_SUMMARY_FRAME,sum);
	    switchToParentWindow();
	    waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Free layout webcontent
	public void createNewFreeLayoutWebContent(String title, String name, String cont, String img, String sum, String css, String js) {
		waitForAndGetElement(ELEMENT_WEBCONTENT_LINK).click();
		waitForAndGetElement(ELEMENT_WEBCONTENT_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElement(ELEMENT_WEBCONTENT_NAME_TEXTBOX).clear();
		waitForAndGetElement(ELEMENT_WEBCONTENT_NAME_TEXTBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_WEBCONTENT_CONTENT_FRAME,cont);
	    switchToParentWindow();
	    
	    waitForAndGetElement(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB).click();
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_WEBCONTENT_UPLOAD_FRAME));
		waitForAndGetElement(ELEMENT_WEBCONTENT_FILE_IMAGE).sendKeys(img);
	    switchToParentWindow();
		inputDataToFrame(ELEMENT_WEBCONTENT_SUMMARY_FRAME,sum);
	    switchToParentWindow();

	    waitForAndGetElement(ELEMENT_WEBCONTENT_ADVANCE_TAB).click();
	    waitForAndGetElement(ELEMENT_WEBCONTENT_CSS_TEXTAREA).sendKeys(css);
	    waitForAndGetElement(ELEMENT_WEBCONTENT_JS_TEXTAREA).sendKeys(js);
	    waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();			
	}
	
	//add new file
	public void createNewFile(String name, String cont, String title){
		waitForAndGetElement(ELEMENT_NEWFILE_LINK).click();	
		waitForAndGetElement(ELEMENT_NEWFILE_NAME_TEXTBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_NEWFILE_CONTENT_FRAME,cont);
	    switchToParentWindow();
	    waitForAndGetElement(ELEMENT_NEWFILE_TITLE_TEXTBOX).sendKeys(title);
	    waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Sample Node
	public void createNewSampleNode(String title, String name, String img){
		waitForAndGetElement(ELEMENT_SAMPLENODE_LINK).click();
		waitForAndGetElement(ELEMENT_SAMPLENODE_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElement(ELEMENT_SAMPLENODE_NAME_TEXTBOX).clear();
		waitForAndGetElement(ELEMENT_SAMPLENODE_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElement(ELEMENT_SAMPLENODE_ADD_ITEM_LINK).click();
		selectOption(ELEMENT_SAMPLENODE_SELECTITEM,ELEMENT_SAMPLENODE_SELECTITEM_OPTION);
		waitForAndGetElement(ELEMENT_SAMPLENODE_SELECTITEM_OPTION_LINK).click();
		waitForAndGetElement(ELEMENT_SAMPLENODE_DESCRIPTION_TEXTBOX).sendKeys(title);
		if (img !=""){
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_SAMPLENODE_UPLOAD_IMG_FRAME));
		waitForAndGetElement(ELEMENT_SAMPLENODE_FILE_IMG).sendKeys(getAbsoluteFilePath(img));
		switchToParentWindow();
		waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
		}
		waitForAndGetElement(ELEMENT_SAMPLENODE_CONTENT_TEXTAREA).sendKeys(title);
		waitForAndGetElement(ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA).sendKeys(title);
		waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}

	// add new Kofax document
	public void createNewKofax(String name){
		waitForAndGetElement(ELEMENT_KOFAX_LINK).click();
		waitForAndGetElement(ELEMENT_KOFAX_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElement(ELEMENT_KOFAX_ADDNODE_LINK).click();
		selectOption(ELEMENT_KOFAX_ADDNODE_SELECT,ELEMENT_KOFAX_ADDNODE_OPTION);	
		waitForAndGetElement(ELEMENT_KOFAX_ADDNODE_OPTION_LINK).click();
		waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	// add new File Plan
	public void createNewFilePlan(String name, String catInden, String disAut, String oriOrg, String event){
		waitForAndGetElement(ELEMENT_FILEPLAN_LINK).click();	
		waitForAndGetElement(ELEMENT_FILEPLAN_NAME).sendKeys(name);
		waitForAndGetElement(ELEMENT_FILEPLAN_RECORD_TAB).click();
		waitForAndGetElement(ELEMENT_FILEPLAN_RECORD_TEXTBOX).sendKeys(catInden);
		waitForAndGetElement(ELEMENT_FILEPLAN_DISPOS_TEXTBOX).sendKeys(disAut);
		waitForAndGetElement(ELEMENT_FILEPLAN_DEFAULT_TEXTBOX).sendKeys(oriOrg);
		
		waitForAndGetElement(ELEMENT_FILEPLAN_RPROCESS_TAB).click();
		waitForAndGetElement(ELEMENT_FILEPLAN_RPROCESS_TRIGER).sendKeys(event);
		waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}

	// add new podcast
	public void createNewPodcast(String name, String title, String link){
		waitForAndGetElement(ELEMENT_PODCAST_LINK).click();
		waitForAndGetElement(ELEMENT_PODCAST_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElement(ELEMENT_PODCAST_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElement(ELEMENT_PODCAST_LINK_TEXTBOX).sendKeys(link);
		waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Picture on head layout webcontent
	public void createNewPictureOnHeadLayout (String name, String title, String file){
		waitForAndGetElement(ELEMENT_HEAD_LAYOUT_LINK).click();
		waitForAndGetElement(ELEMENT_HEAD_LAYOUT_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElement(ELEMENT_HEAD_LAYOUT_TITLE_TEXTBOX).sendKeys(title);
		if (file!=""){
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_HEAD_LAYOUT_UPLOAD_FRAME));
		waitForAndGetElement(ELEMENT_HEAD_LAYOUT_UPLOAD_FILE).sendKeys(getAbsoluteFilePath(file));
		switchToParentWindow();
		waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
		}
		waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new product
	public void createNewProduct (String name, String title){
		waitForAndGetElement(ELEMENT_PRODUCT_LINK).click();
		waitForAndGetElement(ELEMENT_PRODUCT_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElement(ELEMENT_PRODUCT_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElement(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Content Folder
	public void createNewContentFolder(String title, String name) {
		waitForAndGetElement(ELEMENT_NEW_FOLDER_LINK).click();
		selectOption(ELEMENT_FOLDER_TYPE_OPTION,ELEMENT_CONTENT_FOLDER_TYPE);
		waitForAndGetElement(ELEMENT_FOLDER_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElement(ELEMENT_FOLDER_NAME_TEXTBOX).clear();
		waitForAndGetElement(ELEMENT_FOLDER_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElement(ELEMENT_SAVE_BUTTON).click();
	}
	
	//add new Document Folder
	public void createNewDocumentFolder(String title, String name){
		waitForAndGetElement(ELEMENT_NEW_FOLDER_LINK).click();
		selectOption(ELEMENT_FOLDER_TYPE_OPTION, ELEMENT_DOCUMENT_FOLDER_TYPE);
		waitForAndGetElement(ELEMENT_FOLDER_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElement(ELEMENT_FOLDER_NAME_TEXTBOX).clear();
		waitForAndGetElement(ELEMENT_FOLDER_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElement(ELEMENT_SAVE_BUTTON).click();
	}
	
	//delete level 1 node
	public void deleteDocument(By locator){
		actions.contextClick(waitForAndGetElement(locator)).perform();
		pause(1000);
		waitForAndGetElement(ELEMENT_PARTIALLINK_DELETE_DOCUMENT).click();
		pause(1000);
		waitForAndGetElement(By.linkText("OK")).click();
		info("Delete successfully");
	}

	
	//simple search
	public boolean simpleSearch(String keyword){
		boolean delete = true;
		waitForAndGetElement(ELEMENT_SIMPLESEARCH_TEXTBOX).clear();
		waitForAndGetElement(ELEMENT_SIMPLESEARCH_TEXTBOX).sendKeys(keyword);
		waitForAndGetElement(ELEMENT_SIMPLESEARCH_SUBMIT).click();
		if (isElementPresent(By.xpath("//div[contains(text(),'"+keyword+"')]")))
		{
			return delete;}
		else {
			delete = false;
			return delete;}
	}
	
	//simple search not return result
    public boolean notSimpleSearch(String keyword) {
        return !simpleSearch(keyword);
    }
    
    //create page wizard with step 1,2 without layout
    public void gotoPageEditor_EmptyLayout(String namePage){
		goToNewPageForm();
		waitForAndGetElement(ELEMENT_NEWPAGE_NAME_TEXTBOX).sendKeys(namePage);
		waitForAndGetElement(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
		pause(500);
		waitForAndGetElement(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
    }
	
	//create new page without layout 
	public void createNewPageEmptyLayout(String namePage){	
		gotoPageEditor_EmptyLayout(namePage);
		waitForAndGetElement(ELEMENT_NEWPAGE_SAVE_BUTTON).click();
	}
	
	//create new page has layout - step 1,2
	public void gotoPageEditor_Layout(String namePage, int numberLayout){
		goToNewPageForm();
		waitForAndGetElement(ELEMENT_NEWPAGE_NAME_TEXTBOX).sendKeys(namePage);
		waitForAndGetElement(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
		waitForAndGetElement(ELEMENT_NEWPAGE_LAYOUT_OPTION).click();
		switch (numberLayout){
		case 1: waitForAndGetElement(ELEMENT_NEWPAGE_LAYOUT_COLUMN_PAGE_OPTION).click();
				break;
		case 2: waitForAndGetElement(ELEMENT_NEWPAGE_LAYOUT_ROW_PAGE_OPTION).click();
				break;
		case 3: waitForAndGetElement(ELEMENT_NEWPAGE_LAYOUT_TAB_PAGE_OPTION).click();
				break;
		case 4: waitForAndGetElement(ELEMENT_NEWPAGE_LAYOUT_MIX_PAGE_OPTION).click();
				break;		
		default: waitForAndGetElement(ELEMENT_NEWPAGE_LAYOUT_DEFAULT_OPTION).click();
				break;
		}
		waitForAndGetElement(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
	}
	
	//create new page has layout 
	public void createNewPageWithLayout(String namePage, int numberLayout){
		gotoPageEditor_Layout(namePage, numberLayout);
		waitForAndGetElement(ELEMENT_NEWPAGE_SAVE_BUTTON).click();		
	}
	
	//search Page
	public boolean searchPage(String pageTitle){	
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_SETUP_IMG)).build().perform();
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_PORTAL_LINK_LINKTEXT)).build().perform();
		pause(100);
		waitForAndGetElement(ELEMENT_MENU_PAGE_LINK_LINKTEXT).click();
		
		waitForAndGetElement(ELEMENT_SEARCH_TITLEPAGE_TEXTBOX).clear();
		waitForAndGetElement(ELEMENT_SEARCH_TITLEPAGE_TEXTBOX).sendKeys(pageTitle);
		waitForAndGetElement(ELEMENT_SEARCH_PAGE_ICON).click();
		if (isElementNotPresent(ELEMENT_SEARCH_PAGE_ALERT))
		return true;	
		else return false;
	}
	
	//delete page
	public void deletePage(){
		waitForAndGetElement(ELEMENT_DELETE_PAGE_ICON).click();
		acceptAlert();
		waitForAndGetElement(By.linkText("OK")).click();
		info("Delete page successfully");
	}
	
	//delete node of page, node is subnode of node
	public void deleteNode(By node, String pageTitle){
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_EDIT_LINK)).build().perform();
		actions.moveToElement(waitForAndGetElement(ELEMENT_MENU_SITE_LINK)).build().perform();
		waitForAndGetElement(ELEMENT_MENU_NAVIGATION_LINK).click();
		
		waitForElementPresent(By.id(ELEMENT_SITE_NAVIGATION_POPUP));
		if (node != null){
		waitForAndGetElement(node).click();
		}
		actions.contextClick(waitForAndGetElement(By.linkText(pageTitle))).perform();
		driver.findElement(By.partialLinkText(ELEMENT_SITE_NAVIGATION_DELETE_NODE_PARTIALLINK)).click();
		acceptAlert();	
		waitForAndGetElement(ELEMENT_SITE_NAVIGATION_SAVE_BUTTON).click();
		assert isElementNotPresent(ELEMENT_SITE_NAVIGATION_DELETE_ERROR_ALERT):"Have message error";
		info("Delete node of page successfully");
		pause(1000);
	}
	
	//add contentdetail to a page EmptyLayout of portal
	public void addContentDetailEmptyLayout(){
		waitForAndGetElement(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_DETAIL_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);	
	}
	
	//Add "ContentDetail" to page with selected layout
	public void addContentDetail(){
		waitForAndGetElement(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_DETAIL_PORTLET,ELEMENT_DROP_TARGET_HAS_LAYOUT);		
	}
	
	//Add "ContentList" to page EmptyLayout
	public void addContentListEmptyLayout(){
		waitForAndGetElement(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_LIST_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);
	}
	
	//Add "ContentList" to page with selected layout
	public void addContentList(){
		waitForAndGetElement(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_LIST_PORTLET,ELEMENT_DROP_TARGET_HAS_LAYOUT);		
	}
	
	//Select "ContentPath" in Edit Mode
	public void selectContentPath(){
		actions.moveToElement(waitForAndGetElement(ELEMENT_FRAME_CONTAIN_PORTLET)).build().perform();
		waitForAndGetElement(ELEMENT_EDIT_PORTLET_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_GENERAL_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_GENERAL_MANAGED_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_ACME_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_ACME_DOC_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_SAVE_BUTTON).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_CLOSE_BUTTON).click();
	}
	
	//Select "CLVPath" in Edit Mode
	public void selectCLVPath(){
		actions.moveToElement(waitForAndGetElement(ELEMENT_FRAME_CONTAIN_PORTLET)).build().perform();
		waitForAndGetElement(ELEMENT_EDIT_PORTLET_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_GENERAL_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_GENERAL_MANAGED_LINK).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_ACME_LINK).click();
		pause(500);
		waitForAndGetElement(ELEMENT_SELECT_CLV_PATH).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_SAVE_BUTTON).click();
		waitForAndGetElement(ELEMENT_SELECT_CONTENT_PATH_CLOSE_BUTTON).click();
	}
	
	//Create new page empty layout add contentdetail, choose ContentPath
	public void createPage_Empty_ContentDetail_ContentPath(String pageName){
		gotoPageEditor_EmptyLayout(pageName);
		pause(500);
		addContentDetailEmptyLayout();
		pause(500);
		selectContentPath();
		pause(500);
		waitForAndGetElement(ELEMENT_NEWPAGE_SAVE_BUTTON).click();			
	}
	
	//Create new page has layout, add contentlist, choose clv path
	public void createPage_ContentList_CLVpath(String pageName){
		gotoPageEditor_Layout(pageName, 1);
		pause(500);
		addContentList();
		pause(500);
		selectCLVPath();
		pause(500);
		waitForAndGetElement(ELEMENT_NEWPAGE_SAVE_BUTTON).click();
	}
	
	//Enable preferenes option
	public void checkPreferenceOption(String optionId){
		goToNode(ELEMENT_PREFERENCE_LINK);
		waitForAndGetElement(By.linkText("Advanced")).click();
		pause(500);
		WebElement check = waitForAndGetElement(By.id(optionId));
		if (check.isSelected()!= true){
			check.click();
		}
		waitForAndGetElement(By.linkText("Save")).click();
	}
	
	//upload file
	public void uploadFile(String fileName, String link){
		goToNode(ELEMENT_UPLOAD_LINK_XPATH);
		waitForAndGetElement(ELEMENT_UPLOAD_FILE_NAME_ID).sendKeys(fileName);
		driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_IMG_FRAME_XPATH));
		waitForAndGetElement(ELEMENT_UPLOAD_IMG_ID).sendKeys(getAbsoluteFilePath(link));
		info("Upload file "+getAbsoluteFilePath(link));
		switchToParentWindow();
		waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
		waitForAndGetElement(ELEMENT_UPLOAD_SAVE_BUTTON_LINKTEXT).click();
		waitForAndGetElement(ELEMENT_UPLOAD_CLOSE_BUTTON_LINKTEXT).click();
	}

	//lock node
	public void lockNode(By locator){
		WebElement lock = waitForAndGetElement(locator);
		actions.contextClick(lock).build().perform();
		waitForAndGetElement(ELEMENT_LOCK_OPTION_XPATH).click();
	}

	//check node is being locked
	public boolean checkLockNode(String xpath){
		boolean check;
		WebElement unlock = waitForAndGetElement(xpath);
		actions.contextClick(unlock).build().perform();
		pause(500);
		if (isElementPresent(ELEMENT_UNLOCK_OPTION_XPATH)==true)
		{check = true;}
		else check =false;
		unlock.sendKeys(Keys.RETURN);
		return check;
	}
}
