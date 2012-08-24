package org.exoplatform.selenium.platform.ecms;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.exoplatform.selenium.platform.PlatformBase;


public class EcmsBase extends PlatformBase {
	
	public static final String ELEMENT_LOGIN_LINK = "//*[@id='AcmeWebSiteLogInLogOut']";
	public static final String ELEMENT_LOGIN_BUTTON = "//*[@id='UIPortalLoginFormAction']";
	public static final String ELEMENT_LOGOUT_LINK = "//a[@class='TBIcon']";
	public static final String ELEMENT_MENU_SETUP_IMG = "//img[@alt='Setup']" ;
	public static final String ELEMENT_MENU_CONTENT_LINK = "Content";
	public static final String ELEMENT_MENU_SITE_EXPLORER_LINK = "Sites Explorer";
	public static final String ELEMENT_MENU_EDIT_LINK = "Edit";
	public static final String ELEMENT_MENU_PAGE_LINK = "Page";
	public static final String ELEMENT_MENU_ADD_PAGE_LINK = "Add Page";
	public static final String ELEMENT_MENU_NEW_CONTENT_LINK = "New Content";
	public static final String ELEMENT_MENU_SITE_LINK = "Site";
	public static final String ELEMENT_MENU_NAVIGATION_LINK = "Navigation";
	
	public static final String ELEMENT_ARTICAL_LINK = "//div[@title='Article']";
	public static final String ELEMENT_ARTICAL_TITLE_TEXBOX = "title";	
	public static final String ELEMENT_ARTICAL_NAME_TEXBOX = "name";
	public static final String ELEMENT_ARTICAL_SUMMARY_FRAME = "//td[@id='cke_contents_summary']/iframe";
	public static final String ELEMENT_ARTICAL_CONTENT_FRAME = "//td[@id='cke_contents_content']/iframe";
	public static final String ELEMENT_SAVE_CLOSE_BUTTON = "Save & Close";
	
	public static final String ELEMENT_ANNOUCEMENT_LINK = "Announcement";
	public static final String ELEMENT_ANNOUCEMENT_NAME_TEXBOX = "name";
	public static final String ELEMENT_ANNOUCEMENT_SUMMARY_FRAME = "//td[@id='cke_contents_exo:summary']/iframe";
	
	public static final String ELEMENT_WEBCONTENT_LINK ="Free layout webcontent";
	public static final String ELEMENT_WEBCONTENT_TITLE_TEXTBOX ="title";	
	public static final String ELEMENT_WEBCONTENT_NAME_TEXTBOX ="name";	
	public static final String ELEMENT_WEBCONTENT_CONTENT_FRAME = "//td[contains(@id,'cke_contents_htmlData')]/iframe";
	public static final String ELEMENT_WEBCONTENT_ILLUSTRATION_TAB = "//div[contains(text(),'Illustration')]";
	public static final String ELEMENT_WEBCONTENT_UPLOAD_FRAME ="//*[contains(@id,'uploadFrame')]";
	public static final String ELEMENT_WEBCONTENT_FILE_IMAGE = "file";
	public static final String ELEMENT_WEBCONTENT_SUMMARY_FRAME = "//td[@id='cke_contents_exo:summary']/iframe";
	public static final String ELEMENT_WEBCONTENT_ADVANCE_TAB = "//div[contains(text(),'Advanced')]";
	public static final String ELEMENT_WEBCONTENT_CSS_TEXTAREA = "//textarea[contains(@id,'ContentCSS')]";
	public static final String ELEMENT_WEBCONTENT_JS_TEXTAREA = "//textarea[contains(@id,'ContentJS')]";
	
	public static final String ELEMENT_NEWFILE_LINK ="File";
	public static final String ELEMENT_NEWFILE_NAME_TEXTBOX ="name";	
	public static final String ELEMENT_NEWFILE_CONTENT_FRAME = "//td[@id='cke_contents_contentHtml']/iframe";
	public static final String ELEMENT_NEWFILE_TITLE_TEXTBOX ="title0";
	
	public static final String ELEMENT_SAMPLENODE_LINK ="Sample node";
	public static final String ELEMENT_SAMPLENODE_TITLE_TEXTBOX = "title";
	public static final String ELEMENT_SAMPLENODE_NAME_TEXTBOX = "name";
	public static final String ELEMENT_SAMPLENODE_ADD_ITEM_LINK = "//img[@title = 'Add Item']";	
	public static final String ELEMENT_SAMPLENODE_SELECTITEM = "taxonomyTree";
	public static final String ELEMENT_SAMPLENODE_SELECTITEM_OPTION = "acme";
	public static final String ELEMENT_SAMPLENODE_SELECTITEM_OPTION_LINK = "//div[@class='Select16x16Icon']";
	public static final String ELEMENT_SAMPLENODE_DESCRIPTION_TEXTBOX = "description";
	public static final String ELEMENT_SAMPLENODE_UPLOAD_IMG_FRAME = "//iframe[contains(@id,'uploadFrame')]";
	public static final String ELEMENT_SAMPLENODE_FILE_IMG = "file" ;
	public static final String ELEMENT_SAMPLENODE_CONTENT_TEXTAREA = "summary";
	public static final String ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA = "content";
	
	public static final String ELEMENT_KOFAX_LINK = "Kofax document";
	public static final String ELEMENT_KOFAX_NAME_TEXTBOX = "name";
	public static final String ELEMENT_KOFAX_ADDNODE_LINK = "//img[@class='MultiFieldAction AddNewNodeIcon']" ;
	public static final String ELEMENT_KOFAX_ADDNODE_SELECT = "taxonomyTree";
	public static final String ELEMENT_KOFAX_ADDNODE_OPTION = "acme";
	public static final String ELEMENT_KOFAX_ADDNODE_OPTION_LINK = "//div[@class='Select16x16Icon']";
	
	
	public static final String ELEMENT_FILEPLAN_LINK = "File Plan";
	public static final String ELEMENT_FILEPLAN_NAME = "name";
	public static final String ELEMENT_FILEPLAN_RECORD_TAB = "//div[contains(text(),'Record Properties')]";
	public static final String ELEMENT_FILEPLAN_RECORD_TEXTBOX = "recordCategoryIdentifier";
	public static final String ELEMENT_FILEPLAN_DISPOS_TEXTBOX = "dispositionAuthority";
	public static final String ELEMENT_FILEPLAN_DEFAULT_TEXTBOX  = "defaultOriginatingOrganization";
	public static final String ELEMENT_FILEPLAN_RPROCESS_TAB = "//div[contains(text(),'Process Properties')]";
	public static final String ELEMENT_FILEPLAN_RPROCESS_TRIGER = "eventTrigger";	
	
	public static final String ELEMENT_PODCARD_LINK = "Podcast";
	public static final String ELEMENT_PODCARD_NAME_TEXTBOX = "name";
	public static final String ELEMENT_PODCARD_TITLE_TEXTBOX = "title";
	public static final String ELEMENT_PODCARD_LINK_TEXTBOX = "link";
	
	public static final String ELEMENT_HEAD_LAYOUT_LINK = "Picture on head layout webcontent";
	public static final String ELEMENT_HEAD_LAYOUT_NAME_TEXTBOX = "name";
	public static final String ELEMENT_HEAD_LAYOUT_TITLE_TEXTBOX = "title";	
	public static final String ELEMENT_HEAD_LAYOUT_UPLOAD_FRAME = "//iframe[contains(@id,'uploadFrame')]"	;
	public static final String ELEMENT_HEAD_LAYOUT_UPLOAD_FILE = "file" ;
	
	public static final String ELEMENT_PRODUCT_LINK = "Product";
	public static final String ELEMENT_PRODUCT_NAME_TEXTBOX = "name" ;
	public static final String ELEMENT_PRODUCT_TITLE_TEXTBOX = "title";
	
	public static final String ELEMENT_NEW_FOLDER_LINK = "New Folder";
	
	public static final String ELEMENT_NEWPAGE_NAME_TEXTBOX = "pageName";	
	public static final String ELEMENT_NEWPAGE_NEXT_BUTTON = "Next";	
	public static final String ELEMENT_NEWPAGE_SAVE_BUTTON = "//a[@class='EdittedSaveButton']";
	public static final String ELEMENT_NEWPAGE_LAYOUT_OPTION = "//div[@class='DropDownSelectLabel']" ;
	public static final String ELEMENT_NEWPAGE_LAYOUT_COLUMN_PAGE_OPTION = "Column Page Configs" ;
	public static final String ELEMENT_NEWPAGE_LAYOUT_ROW_PAGE_OPTION = "Row Page Configs";
	public static final String ELEMENT_NEWPAGE_LAYOUT_TAB_PAGE_OPTION = "Tabs Page Config";
	public static final String ELEMENT_NEWPAGE_LAYOUT_MIX_PAGE_OPTION = "Mix Page Configs";
	public static final String ELEMENT_NEWPAGE_LAYOUT_DEFAULT_OPTION = "Page Configs";
	
	public static final String ELEMENT_FOLDER_TITLE_TEXTBOX = "title";
	public static final String ELEMENT_FOLDER_NAME_TEXTBOX = "name";
	public static final String ELEMENT_FOLDER_TYPE_OPTION = "type";
	public static final String ELEMENT_CONTENT_FOLDER_TYPE = "nt:unstructured";
	public static final String ELEMENT_DOCUMENT_FOLDER_TYPE = "nt:folder";
	public static final String ELEMENT_SAVE_BUTTON = "Save";
	
	public static final String ELEMENT_SEARCH_TITLEPAGE_TEXTBOX = "pageTitle";
	public static final String ELEMENT_SEARCH_PAGE_ICON = "//a[@class='SearchIcon']";
	public static final String ELEMENT_SEARCH_PAGE_ALERT = "//[@class= 'UIPopupWindow UIDragObject ExoMessageDecorator']";	
	public static final String ELEMENT_PARTIALLINK_DELETE_DOCUMENT = "//a[contains(text(),'Delete')]";
	public static final String ELEMENT_ALERT_CONFIRM_DELETE_DOCUMENT = "Are you sure to delete the node";
	public static final String ELEMENT_ALERT_CONFIRM_DELETE_PAGE = "Are you sure to delete this page?";
	public static final String ELEMENT_ALERT_FIND_AFTER_DELETE_PAGE = "Information" ;
	
	public static final String ELEMENT_SIMPLESEARCH_TEXTBOX = "simpleSearch";
	public static final String ELEMENT_SIMPLESEARCH_SUBMIT = "SimpleSearch";
	
	public static final String ELEMENT_DELETE_PAGE_ICON = "//img[@class='DeleteIcon']";
	public static final String ELEMENT_SITE_NAVIGATION_POPUP = "UIPopupWindow-UIEditNavigationPopupContainer";
	public static final String ELEMENT_SITE_NAVIGATION_DELETE_ERROR_ALERT = "//div[@class='UIPopupWindow UIDragObject ExoMessageDecorator']";
	public static final String ELEMENT_SITE_NAVIGATION_DELETE_NODE_PARTIALLINK = "Delete";
	public static final String ELEMENT_SITE_NAVIGATION_SAVE_BUTTON = "Save";
	
	public static final String ELEMENT_CONTENT_LINK = "//a[@title='Content']";
	public static final String ELEMENT_ADD_CONTENT_DETAIL_PORTLET = "//div[contains(text(),'Content Detail')]";
	public static final String ELEMENT_DROP_TARGET_NO_LAYOUT = "//div[@id='UIPage']";
	public static final String ELEMENT_DROP_TARGET_HAS_LAYOUT = "//div[@class='UIRowContainer EmptyContainer']";
	public static final String ELEMENT_ADD_CONTENT_LIST_PORTLET = "//div[contains(text(),'Content List')]";
	public static final String ELEMENT_FRAME_CONTAIN_PORTLET = "//div[contains(@id,'UIPortlet')]";
	public static final String ELEMENT_EDIT_PORTLET_LINK = "//a[@title='Edit Portlet']";
	public static final String ELEMENT_SELECT_CONTENT_PATH_LINK = "//img[@class='AddIcon16x16 SelectFolderPathIcon']";
	public static final String ELEMENT_SELECT_CONTENT_PATH_GENEGAL_LINK = "GeneralDrives_";
	public static final String ELEMENT_SELECT_CONTENT_PATH_GENEGAL_MANAG_LINK = "GeneralDrives_ManagedSites_";
	public static final String ELEMENT_SELECT_CONTENT_PATH_ACME_LINK = "GeneralDrives_ManagedSites__acme";
	public static final String ELEMENT_SELECT_CONTENT_PATH_ACME_DOC_LINK ="GeneralDrives_ManagedSites__acme_documents" ;
	public static final String ELEMENT_SELECT_CONTENT_PATH_SAVE_BUTTON = "Save";
	public static final String ELEMENT_SELECT_CONTENT_PATH_CLOSE_BUTTON ="Close" ;
	
	public static final String ELEMENT_SELECT_CONTENT_PATH = "//a[@title='offices.jpg']";
	public static final String ELEMENT_SELECT_CVL_PATH = "//a[@path='/sites content/live/acme/documents']";
	
	//login ECMS
	public void loginEcms(String username, String password) {
		waitForAndGetElementByXpath(ELEMENT_LOGIN_LINK).click();
		pause(100);
		waitForAndGetElementByName("username").sendKeys(username);
		waitForAndGetElementByName("password").sendKeys(password);
		waitForAndGetElementByXpath(ELEMENT_LOGIN_BUTTON).click();	
	}
		
	//logout ECMS
	public void logoutEcms (){
		actions.moveToElement(waitForAndGetElementByXpath(ELEMENT_LOGOUT_LINK)).build().perform();
		waitForAndGetElementByLinkText("Logout").click();
	}
	
	//Select option from combobox
	public void selectOption(String selectId,String value){
		Select typeFolder = null;
		pause(100);
		while (typeFolder ==null){
			pause(100);
			typeFolder = new Select(waitForAndGetElementById(selectId));
		}
		typeFolder.selectByValue(value);
	}
	//Select option from combobox
	public void selectOptionByXpath(String selectXpath,String value){
		Select typeFolder = null;
		pause(100);
		while (typeFolder ==null){
			pause(100);
			typeFolder = new Select(waitForAndGetElementByXpath(selectXpath));
		}
		typeFolder.selectByValue(value);
	}
	
	//Enter sites management Form 
	public void enterSiteForm(){
		actions.moveToElement(waitForAndGetElementByXpath(ELEMENT_MENU_SETUP_IMG)).build().perform();
		actions.moveToElement(waitForAndGetElementByLinkText(ELEMENT_MENU_CONTENT_LINK)).build().perform();
		waitForAndGetElementByLinkText(ELEMENT_MENU_SITE_EXPLORER_LINK).click();
	}
	
	//Enter create new page form
	public void enterNewPageForm(){
		actions.moveToElement(waitForAndGetElementByLinkText(ELEMENT_MENU_EDIT_LINK)).build().perform();
		actions.moveToElement(waitForAndGetElementByLinkText(ELEMENT_MENU_PAGE_LINK)).build().perform();
		waitForAndGetElementByLinkText(ELEMENT_MENU_ADD_PAGE_LINK).click();	
	}
	
	//go to new content
	public void goToAddNewConntent(){
		waitForAndGetElementByLinkText(ELEMENT_MENU_NEW_CONTENT_LINK).click();	
	}
	
	//function go to Node
	public void goToNode(String xpath){
		waitForAndGetElementByXpath(xpath).click();
	}
	
	//function add data to frame
	public void inputDataToFrame (String frameId, String data){
		driver.switchTo().frame(waitForAndGetElementByXpath(frameId));
		WebElement inputsummary = driver.switchTo().activeElement();
		inputsummary.sendKeys(data);
	}
	
	//function swith to parent windows
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
		waitForAndGetElementByXpath(ELEMENT_ARTICAL_LINK).click();
		// Input information
		waitForAndGetElementById(ELEMENT_ARTICAL_TITLE_TEXBOX).sendKeys(title);
		waitForAndGetElementById(ELEMENT_ARTICAL_NAME_TEXBOX).clear();
		waitForAndGetElementById(ELEMENT_ARTICAL_NAME_TEXBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_ARTICAL_SUMMARY_FRAME,sum);
	    switchToParentWindow();
	    inputDataToFrame(ELEMENT_ARTICAL_CONTENT_FRAME,cont);
	    switchToParentWindow();
	    //save
	    waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new annoucement
	public void createNewAnnoucement (String name, String sum){
		waitForAndGetElementByLinkText(ELEMENT_ANNOUCEMENT_LINK).click();
		waitForAndGetElementById(ELEMENT_ANNOUCEMENT_NAME_TEXBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_ANNOUCEMENT_SUMMARY_FRAME,sum);
	    switchToParentWindow();
	    waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Free layout webcontent
	public void createNewFreeLayoutWebContent(String title, String name, String cont, String img, String sum, String css, String js) {
		waitForAndGetElementByLinkText(ELEMENT_WEBCONTENT_LINK).click();
		waitForAndGetElementById(ELEMENT_WEBCONTENT_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElementById(ELEMENT_WEBCONTENT_NAME_TEXTBOX).clear();
		waitForAndGetElementById(ELEMENT_WEBCONTENT_NAME_TEXTBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_WEBCONTENT_CONTENT_FRAME,cont);
	    switchToParentWindow();
	    
	    waitForAndGetElementByXpath(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB).click();
		driver.switchTo().frame(waitForAndGetElementByXpath(ELEMENT_WEBCONTENT_UPLOAD_FRAME));
		waitForAndGetElementById(ELEMENT_WEBCONTENT_FILE_IMAGE).sendKeys(img);
	    switchToParentWindow();
		inputDataToFrame(ELEMENT_WEBCONTENT_SUMMARY_FRAME,sum);
	    switchToParentWindow();

	    waitForAndGetElementByXpath(ELEMENT_WEBCONTENT_ADVANCE_TAB).click();
	    waitForAndGetElementByXpath(ELEMENT_WEBCONTENT_CSS_TEXTAREA).sendKeys(css);
	    waitForAndGetElementByXpath(ELEMENT_WEBCONTENT_JS_TEXTAREA).sendKeys(js);
	    waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();			
	}
	
	//add new file
	public void createNewFile(String name, String cont, String title){
		waitForAndGetElementByLinkText(ELEMENT_NEWFILE_LINK).click();	
		waitForAndGetElementById(ELEMENT_NEWFILE_NAME_TEXTBOX).sendKeys(name);
		inputDataToFrame(ELEMENT_NEWFILE_CONTENT_FRAME,cont);
	    switchToParentWindow();
	    waitForAndGetElementById(ELEMENT_NEWFILE_TITLE_TEXTBOX).sendKeys(title);
	    waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Sample Node
	public void createNewSampleNode(String title, String name, String img){
		waitForAndGetElementByLinkText(ELEMENT_SAMPLENODE_LINK).click();
		waitForAndGetElementById(ELEMENT_SAMPLENODE_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElementById(ELEMENT_SAMPLENODE_NAME_TEXTBOX).clear();
		waitForAndGetElementById(ELEMENT_SAMPLENODE_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElementByXpath(ELEMENT_SAMPLENODE_ADD_ITEM_LINK).click();
		selectOption(ELEMENT_SAMPLENODE_SELECTITEM,ELEMENT_SAMPLENODE_SELECTITEM_OPTION);
		waitForAndGetElementByXpath(ELEMENT_SAMPLENODE_SELECTITEM_OPTION_LINK).click();
		waitForAndGetElementById(ELEMENT_SAMPLENODE_DESCRIPTION_TEXTBOX).sendKeys(title);
		driver.switchTo().frame(waitForAndGetElementByXpath(ELEMENT_SAMPLENODE_UPLOAD_IMG_FRAME));
		waitForAndGetElementById(ELEMENT_SAMPLENODE_FILE_IMG).sendKeys(img);
		pause(2000);
		switchToParentWindow();
		waitForAndGetElementById(ELEMENT_SAMPLENODE_CONTENT_TEXTAREA).sendKeys(title);
		waitForAndGetElementById(ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA).sendKeys(title);
		waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}

	// add new Kofax document
	public void createNewKofax(String name){
		waitForAndGetElementByLinkText(ELEMENT_KOFAX_LINK).click();
		waitForAndGetElementById(ELEMENT_KOFAX_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElementByXpath(ELEMENT_KOFAX_ADDNODE_LINK).click();
		selectOption(ELEMENT_KOFAX_ADDNODE_SELECT,ELEMENT_KOFAX_ADDNODE_OPTION_LINK);	
		waitForAndGetElementByXpath(ELEMENT_KOFAX_ADDNODE_OPTION).click();
		waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	// add new File Plan
	public void createNewFilePlan(String name, String catInden, String disAut, String oriOrg, String event){
		waitForAndGetElementByLinkText(ELEMENT_FILEPLAN_LINK).click();	
		waitForAndGetElementById(ELEMENT_FILEPLAN_NAME).sendKeys(name);
		waitForAndGetElementByXpath(ELEMENT_FILEPLAN_RECORD_TAB).click();
		waitForAndGetElementById(ELEMENT_FILEPLAN_RECORD_TEXTBOX).sendKeys(catInden);
		waitForAndGetElementById(ELEMENT_FILEPLAN_DISPOS_TEXTBOX).sendKeys(disAut);
		waitForAndGetElementById(ELEMENT_FILEPLAN_DEFAULT_TEXTBOX).sendKeys(oriOrg);
		
		waitForAndGetElementByXpath(ELEMENT_FILEPLAN_RPROCESS_TAB).click();
		waitForAndGetElementById(ELEMENT_FILEPLAN_RPROCESS_TRIGER).sendKeys(event);
		waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}

	// add new podcasd
	public void createNewPodcast(String name, String title, String link){
		waitForAndGetElementByLinkText(ELEMENT_PODCARD_LINK).click();
		waitForAndGetElementById(ELEMENT_PODCARD_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElementById(ELEMENT_PODCARD_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElementById(ELEMENT_PODCARD_LINK_TEXTBOX).sendKeys(link);
		waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Picture on head layout webcontent
	public void createNewPictureOnHeadLayout (String name, String title, String file){
		waitForAndGetElementByLinkText(ELEMENT_HEAD_LAYOUT_LINK).click();
		waitForAndGetElementById(ELEMENT_HEAD_LAYOUT_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElementById(ELEMENT_HEAD_LAYOUT_TITLE_TEXTBOX).sendKeys(title);
		driver.switchTo().frame(waitForAndGetElementByXpath(ELEMENT_HEAD_LAYOUT_UPLOAD_FRAME));
		waitForAndGetElementById(ELEMENT_HEAD_LAYOUT_UPLOAD_FILE).sendKeys(file);
		pause(500);
		switchToParentWindow();
		waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new product
	public void createNewProduct (String name, String title){
		waitForAndGetElementByLinkText(ELEMENT_PRODUCT_LINK).click();
		waitForAndGetElementById(ELEMENT_PRODUCT_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElementById(ELEMENT_PRODUCT_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElementByLinkText(ELEMENT_SAVE_CLOSE_BUTTON).click();
	}
	
	//add new Content Folder
	public void createNewContentFolder(String title, String name) {
		waitForAndGetElementByLinkText(ELEMENT_NEW_FOLDER_LINK).click();
		selectOption(ELEMENT_FOLDER_TYPE_OPTION,ELEMENT_CONTENT_FOLDER_TYPE);
		waitForAndGetElementById(ELEMENT_FOLDER_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElementById(ELEMENT_FOLDER_NAME_TEXTBOX).clear();
		waitForAndGetElementById(ELEMENT_FOLDER_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElementByLinkText(ELEMENT_SAVE_BUTTON).click();
	}
	
	//add new Document Folder
	public void createNewDocumentFolder(String title, String name){
		waitForAndGetElementByLinkText(ELEMENT_NEW_FOLDER_LINK).click();
		selectOption(ELEMENT_FOLDER_TYPE_OPTION, ELEMENT_DOCUMENT_FOLDER_TYPE);
		waitForAndGetElementById(ELEMENT_FOLDER_TITLE_TEXTBOX).sendKeys(title);
		waitForAndGetElementById(ELEMENT_FOLDER_NAME_TEXTBOX).clear();
		waitForAndGetElementById(ELEMENT_FOLDER_NAME_TEXTBOX).sendKeys(name);
		waitForAndGetElementByLinkText(ELEMENT_SAVE_BUTTON).click();
	}
	
	//delete level 1 node
	public void deleteDocument(String xpath){
		actions.contextClick(waitForAndGetElementByXpath(xpath)).perform();
		pause(1000);
		waitForAndGetElementByXpath(ELEMENT_PARTIALLINK_DELETE_DOCUMENT).click();
		pause(1000);
		getTextFromAlert().contains(ELEMENT_ALERT_CONFIRM_DELETE_DOCUMENT);
		waitForAndGetElementByLinkText("OK").click();
	}

	
	//simple search
	public boolean simpleSearch(String keyword){
		boolean delete = true;
		waitForAndGetElementById(ELEMENT_SIMPLESEARCH_TEXTBOX).clear();
		waitForAndGetElementById(ELEMENT_SIMPLESEARCH_TEXTBOX).sendKeys(keyword);
		waitForAndGetElementById(ELEMENT_SIMPLESEARCH_SUBMIT).click();
		if (isElementPresent("//div[contains(text(),'"+keyword+"')]"))
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
		enterNewPageForm();
		waitForAndGetElementById(ELEMENT_NEWPAGE_NAME_TEXTBOX).sendKeys(namePage);
		waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
		pause(500);
		waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
    }
	
	//create new page without layout 
	public void createNewPageEmptyLayout(String namePage){	
		gotoPageEditor_EmptyLayout(namePage);
		waitForAndGetElementByXpath(ELEMENT_NEWPAGE_SAVE_BUTTON).click();
	}
	
	//create new page has layout - step 1,2
	public void gotoPageEditor_Layout(String namePage, int numberLayout){
		enterNewPageForm();
		waitForAndGetElementById(ELEMENT_NEWPAGE_NAME_TEXTBOX).sendKeys(namePage);
		waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
		waitForAndGetElementByXpath(ELEMENT_NEWPAGE_LAYOUT_OPTION).click();
		switch (numberLayout){
		case 1: waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_LAYOUT_COLUMN_PAGE_OPTION).click();
				break;
		case 2: waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_LAYOUT_ROW_PAGE_OPTION).click();
				break;
		case 3: waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_LAYOUT_TAB_PAGE_OPTION).click();
				break;
		case 4: waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_LAYOUT_MIX_PAGE_OPTION).click();
				break;		
		default: waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_LAYOUT_DEFAULT_OPTION).click();
				break;
		}
		waitForAndGetElementByLinkText(ELEMENT_NEWPAGE_NEXT_BUTTON).click();
	}
	
	//create new page has layout 
	public void createNewPageWithLayout(String namePage, int numberLayout){
		gotoPageEditor_Layout(namePage, numberLayout);
		waitForAndGetElementByXpath(ELEMENT_NEWPAGE_SAVE_BUTTON).click();		
	}
	
	//search Page
	public boolean searchPage(String pageTitle){	
		actions.moveToElement(waitForAndGetElementByXpath("//img[@alt='Setup']")).build().perform();
		actions.moveToElement(waitForAndGetElementByLinkText("Portal")).build().perform();
		pause(100);
		waitForAndGetElementByLinkText("Pages").click();
		
		waitForAndGetElementById(ELEMENT_SEARCH_TITLEPAGE_TEXTBOX).sendKeys("");
		waitForAndGetElementById(ELEMENT_SEARCH_TITLEPAGE_TEXTBOX).sendKeys(pageTitle);
		waitForAndGetElementByXpath(ELEMENT_SEARCH_PAGE_ICON).click();
		if (isElementNotPresent(ELEMENT_SEARCH_PAGE_ALERT))
		return true;	
		else return false;
	}
	
	//delete page
	public void deletePage(){
		waitForAndGetElementByXpath(ELEMENT_DELETE_PAGE_ICON).click();
		getTextFromAlert().contains(ELEMENT_ALERT_CONFIRM_DELETE_PAGE);
		acceptAlert();
		getTextFromAlert().contains(ELEMENT_ALERT_FIND_AFTER_DELETE_PAGE);
		waitForAndGetElementByLinkText("OK").click();
		System.out.println("Delete page successfully");
	}
	
	//delete node of page, node is subnode of node
	public void deleteNode(String node, String pageTitle){
		actions.moveToElement(waitForAndGetElementByLinkText(ELEMENT_MENU_EDIT_LINK)).build().perform();
		actions.moveToElement(waitForAndGetElementByLinkText(ELEMENT_MENU_SITE_LINK)).build().perform();
		waitForAndGetElementByLinkText(ELEMENT_MENU_NAVIGATION_LINK).click();
		
		waitForElementPresent(By.id(ELEMENT_SITE_NAVIGATION_POPUP));
		if (node != ""){
		waitForAndGetElementByLinkText(node).click();
		}
		actions.contextClick(waitForAndGetElementByLinkText(pageTitle)).perform();
		driver.findElement(By.partialLinkText(ELEMENT_SITE_NAVIGATION_DELETE_NODE_PARTIALLINK)).click();
		acceptAlert();	
		waitForAndGetElementByLinkText(ELEMENT_SITE_NAVIGATION_SAVE_BUTTON).click();
		isElementNotPresent(ELEMENT_SITE_NAVIGATION_DELETE_ERROR_ALERT);
		System.out.println("Delete node of page successfully");
		pause(1000);
	}
	
	//add contentdetail to a page EmptyLayout of portal
	public void addContentDetailEmptyLayout(){
		waitForAndGetElementByXpath(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_DETAIL_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);	
	}
	
	//Add "ContentDetail" to page with selected layout
	public void addContentDetail(String namepage){
		waitForAndGetElementByXpath(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_DETAIL_PORTLET,ELEMENT_DROP_TARGET_HAS_LAYOUT);		
	}
	
	//Add "ContentList" to page EmptyLayout
	public void addContentListEmptyLayout(String namepage){
		waitForAndGetElementByXpath(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_LIST_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);
	}
	
	//Add "ContentList" to page with selected layout
	public void addContentList(){
		waitForAndGetElementByXpath(ELEMENT_CONTENT_LINK).click();
		dragAndDropToObject(ELEMENT_ADD_CONTENT_LIST_PORTLET,ELEMENT_DROP_TARGET_HAS_LAYOUT);		
	}
	
	//Select "ContentPath" in Edit Mode
	public void selectContentPath(){
		actions.moveToElement(waitForAndGetElementByXpath(ELEMENT_FRAME_CONTAIN_PORTLET)).build().perform();
		waitForAndGetElementByXpath(ELEMENT_EDIT_PORTLET_LINK).click();
		waitForAndGetElementByXpath(ELEMENT_SELECT_CONTENT_PATH_LINK).click();
		waitForAndGetElementById(ELEMENT_SELECT_CONTENT_PATH_GENEGAL_LINK).click();
		waitForAndGetElementById(ELEMENT_SELECT_CONTENT_PATH_GENEGAL_MANAG_LINK).click();
		waitForAndGetElementById(ELEMENT_SELECT_CONTENT_PATH_ACME_LINK).click();
		waitForAndGetElementById(ELEMENT_SELECT_CONTENT_PATH_ACME_DOC_LINK).click();
		waitForAndGetElementByXpath(ELEMENT_SELECT_CONTENT_PATH).click();
		waitForAndGetElementByLinkText(ELEMENT_SELECT_CONTENT_PATH_SAVE_BUTTON).click();
		waitForAndGetElementByLinkText(ELEMENT_SELECT_CONTENT_PATH_CLOSE_BUTTON).click();
	}
	
	//Select "CLVPath" in Edit Mode
	public void selectCLVPath(){
		actions.moveToElement(waitForAndGetElementByXpath(ELEMENT_FRAME_CONTAIN_PORTLET)).build().perform();
		waitForAndGetElementByXpath(ELEMENT_EDIT_PORTLET_LINK).click();
		waitForAndGetElementByXpath(ELEMENT_SELECT_CONTENT_PATH_LINK).click();
		waitForAndGetElementById(ELEMENT_SELECT_CONTENT_PATH_GENEGAL_LINK).click();
		waitForAndGetElementById(ELEMENT_SELECT_CONTENT_PATH_GENEGAL_MANAG_LINK).click();
		waitForAndGetElementById(ELEMENT_SELECT_CONTENT_PATH_ACME_LINK).click();
		pause(500);
		waitForAndGetElementByXpath(ELEMENT_SELECT_CVL_PATH).click();
		waitForAndGetElementByLinkText(ELEMENT_SELECT_CONTENT_PATH_SAVE_BUTTON).click();
		waitForAndGetElementByLinkText(ELEMENT_SELECT_CONTENT_PATH_CLOSE_BUTTON).click();
	}
	
	//Create new page empty layout add contentdetail, choose ContentPath
	public void createPage_Empty_ContentDetail_ContentPath(String pageName){
		gotoPageEditor_EmptyLayout(pageName);
		pause(500);
		addContentDetailEmptyLayout();
		pause(500);
		selectContentPath();
		pause(500);
		waitForAndGetElementByXpath(ELEMENT_NEWPAGE_SAVE_BUTTON).click();			
	}
	
	//Create new page has layout, add contentlist, choose clv path
	public void CreatePage_contentlist_clvpath(String pageName){
		gotoPageEditor_Layout(pageName, 1);
		pause(500);
		addContentList();
		pause(500);
		selectCLVPath();
		pause(500);
		waitForAndGetElementByXpath(ELEMENT_NEWPAGE_SAVE_BUTTON).click();
	}
}
