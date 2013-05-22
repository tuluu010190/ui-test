package org.exoplatform.selenium.platform.ecms.contentexplorer;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author vuna2
 *
 */
public class ContentTemplate extends EcmsBase{
	public ContentTemplate(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	ActionBar actBar = new ActionBar(driver);
	Button button = new Button(driver);
	ManageAlert magAlert = new ManageAlert(driver);

	//Button: Categories > Add Item 
	public final By ELEMENT_CATEGORIES_ADD_ITEM = By.xpath("//*[contains(text(), 'Categories')]/..//*[@title='Add Item']");

	//Select language
	public final By ELEMENT_SELECT_LANGUAGE = By.xpath("//*[@id='UIDocumentForm']//select[@name='content-lang']");
	
	//Announcement
	public final By ELEMENT_ANNOUNCEMENT_LINK = By.xpath("//*[@class='templateLabel']//*[text()='Announcement']");
	public final By ELEMENT_ANNOUNCEMENT_NAME_TEXTBOX = By.id("name");
	public final By ELEMENT_ANNOUNCEMENT_SUMMARY_FRAME = By.xpath("//td[@id='cke_contents_exo:summary']/iframe");

	//WebContent
	public final By ELEMENT_WEBCONTENT_LINK = By.xpath("//*[@class='templateLabel']//*[text()='Web Content']");
	//public final By ELEMENT_WEBCONTENT_TITLE_TEXTBOX = By.id("title");	
	public final By ELEMENT_WEBCONTENT_NAME_TEXTBOX = By.id("name");	
	public final By ELEMENT_WEBCONTENT_CONTENT_FRAME = By.xpath("//td[contains(@id,'cke_contents_htmlData')]/iframe");
	public final By ELEMENT_WEBCONTENT_ADD_CONTENT_LINK = By.xpath("//*[@title='Insert Content Link']");
	public final By ELEMENT_WEBCONTENT_ILLUSTRATION_TAB = By.xpath("//*[contains(text(),'Illustration')]");
	public final By ELEMENT_WEBCONTENT_UPLOAD_FRAME = By.xpath("//*[contains(@name,'uploadIFrame')]");
	//public final By ELEMENT_WEBCONTENT_FILE_IMAGE = By.name("file");
	public final By ELEMENT_WEBCONTENT_SUMMARY_FRAME = By.xpath("//td[@id='cke_contents_exo:summary']/iframe");
	public final By ELEMENT_WEBCONTENT_ADVANCE_TAB = By.xpath("//*[contains(text(),'Advanced')]");
	public final By ELEMENT_WEBCONTENT_CSS_TEXTAREA = By.xpath("//textarea[contains(@id,'ContentCSS')]");
	public final By ELEMENT_WEBCONTENT_JS_TEXTAREA = By.xpath("//textarea[contains(@id,'ContentJS')]");

	//File
	public final By ELEMENT_NEWFILE_LINK = By.xpath("//*[@class='templateLabel']//*[text()='File']");
	//By.linkText("File");
	public final By ELEMENT_NEWFILE_NAME_TEXTBOX = By.id("name");
	public final By ELEMENT_NEWFILE_CONTENT_FRAME = By.xpath("//*[@id='cke_contents_contentHtml']/iframe");
	public final By ELEMENT_NEWFILE_TITLE_TEXTBOX = By.id("title0");

	//SampleNode
	//	public final By ELEMENT_SAMPLENODE_LINK = By.linkText("Sample node");
	//	public final By ELEMENT_SAMPLENODE_TITLE_TEXTBOX = By.id("title");
	//	public final By ELEMENT_SAMPLENODE_NAME_TEXTBOX = By.id("name");
	//	public final By ELEMENT_SAMPLENODE_ADD_ITEM_LINK = By.xpath("//img[@title = 'Add Item']");	
	//	public final By ELEMENT_SAMPLENODE_SELECTITEM = By.id("taxonomyTree");
	//	public final String ELEMENT_SAMPLENODE_SELECTITEM_OPTION = "acme";
	//	public final By ELEMENT_SAMPLENODE_SELECTITEM_OPTION_LINK = By.xpath("//div[@class='Select16x16Icon']");
	//	public final By ELEMENT_SAMPLENODE_DESCRIPTION_TEXTBOX = By.id("description");
	//	public final By ELEMENT_SAMPLENODE_UPLOAD_IMG_FRAME = By.xpath("//iframe[contains(@id,'uploadFrame')]");
	//	public final By ELEMENT_SAMPLENODE_FILE_IMG = By.id("file") ;
	//	public final By ELEMENT_SAMPLENODE_CONTENT_TEXTAREA = By.id("summary");
	//	public final By ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA = By.id("content");

	//Kofax
	//	public final By ELEMENT_KOFAX_LINK = By.linkText("Kofax document");
	//	public final By ELEMENT_KOFAX_NAME_TEXTBOX = By.id("name");
	//	public final By ELEMENT_KOFAX_ADDNODE_LINK = By.xpath("//img[@class='MultiFieldAction AddNewNodeIcon']") ;
	//	public final By ELEMENT_KOFAX_ADDNODE_SELECT = By.id("taxonomyTree");
	//	public final String ELEMENT_KOFAX_ADDNODE_OPTION = "acme";
	//	public final By ELEMENT_KOFAX_ADDNODE_OPTION_LINK = By.xpath("//div[@class='Select16x16Icon']");

	//FilePlan
	//	public final By ELEMENT_FILEPLAN_LINK = By.linkText("File Plan");
	//	public final By ELEMENT_FILEPLAN_NAME = By.id("name");
	//	public final By ELEMENT_FILEPLAN_RECORD_TAB = By.xpath("//div[contains(text(),'Record Properties')]");
	//	public final By ELEMENT_FILEPLAN_RECORD_TEXTBOX = By.id("recordCategoryIdentifier");
	//	public final By ELEMENT_FILEPLAN_DISPOS_TEXTBOX = By.id("dispositionAuthority");
	//	public final By ELEMENT_FILEPLAN_DEFAULT_TEXTBOX  = By.id("defaultOriginatingOrganization");
	//	public final By ELEMENT_FILEPLAN_RPROCESS_TAB = By.xpath("//div[contains(text(),'Process Properties')]");
	//	public final By ELEMENT_FILEPLAN_RPROCESS_TRIGER = By.id("eventTrigger");	

	//Picture on Head Layout
	//exo:pictureOnHeadWebContent is changed to Illustrated Web Content
	public final By ELEMENT_HEAD_LAYOUT_LINK = By.linkText("Illustrated Web Content");
	public final By ELEMENT_HEAD_LAYOUT_NAME_TEXTBOX = By.id("name");
	public final By ELEMENT_HEAD_LAYOUT_TITLE_TEXTBOX = By.id("title");	
	public final By ELEMENT_HEAD_LAYOUT_UPLOAD_FRAME = By.xpath("//iframe[contains(@id,'uploadFrame')]")	;
	public final By ELEMENT_HEAD_LAYOUT_UPLOAD_FILE = By.id("file") ;

	//Product
	public final By ELEMENT_PRODUCT_LINK = By.linkText("Product");
	public final By ELEMENT_PRODUCT_NAME_TEXTBOX = By.id("name") ;
	public final By ELEMENT_PRODUCT_TITLE_TEXTBOX = By.id("title");

	public final By ELEMENT_FREE_CONT_ACCEPT = By.xpath("//form[contains(@id,'EditTextForm')]/a[2]");
	public final By ELEMENT_FREE_CONT_INPUT = By.xpath("//iframe[contains(@title,'Rich text editor, newText')]");
	public final String ELEMENT_FREE_CONT_INLINE = "//div[contains(@id,'CurrentText') and @title='Double-click to edit']";

	public final By ELEMENT_SAMPLE_CONT_ACCEPT = By.xpath("//form[contains(@id,'EditContentForm')]/a[2]");
	public final By ELEMENT_SAMPLE_CONT_INPUT = By.xpath("//textarea[contains(@id,'newContent')]");
	public final String ELEMENT_SAMPLE_CONT_INLINE = "//div[contains(@id,'CurrentContent') and @title='Double-click to edit']";
	public final By ELEMENT_SAMPLE_SUM_ACCEPT = By.xpath("//form[contains(@id,'EditSummaryForm')]/a[2]");
	public final By ELEMENT_SAMPLE_SUM_INPUT = By.xpath("//textarea[contains(@id,'newSummary')]");
	public final String ELEMENT_SAMPLE_SUM_INLINE = "//div[contains(@id,'CurrentSummary') and @title='Double-click to edit']";
	public final By ELEMENT_SAMPLE_TITLE_ACCEPT = By.xpath("//form[contains(@id,'EditTdGtmplTitleForm')]/a[2]");
	public final By ELEMENT_SAMPLE_TITLE_INPUT = By.xpath("//input[contains(@id,'newTdGtmplTitle')]");
	public final String ELEMENT_SAMPLE_TITLE_INLINE = "//div[contains(@id,'CurrentTdGtmplTitle') and @title='Double-click to edit']";

	//Podcast
	//	public final By ELEMENT_PODCAST_LINK = By.linkText("Podcast");
	//	public final By ELEMENT_PODCAST_NAME_TEXTBOX = By.id("name");
	//	public final By ELEMENT_PODCAST_TITLE_TEXTBOX = By.id("title");
	//	public final By ELEMENT_PODCAST_LINK_TEXTBOX = By.id("link");
	//	public final String ELEMENT_PODCAST_TITLE_INLINE="//div[contains(@id,'CurrentTdGtmplTitle') and @title='Double-click to edit']";
	//	public final By ELEMENT_PODCAST_TITLE_INPUT=By.xpath("//input[contains(@id,'newTdGtmplTitle')]");
	//	public final By ELEMENT_PODCAST_TITLE_ACCEPT=By.xpath("//a[@title='Accept'][1]");
	//	public final String ELEMENT_PODCAST_DESC_INLINE="//div[contains(@id,'CurrentDescription') and @title='Double-click to edit']";
	//	public final By ELEMENT_PODCAST_DESC_INPUT=By.xpath("//textarea[contains(@id,'newDescription')]");
	//	public final By ELEMENT_PODCAST_DESCRIPTION=By.id("description");
	//	public final By ELEMENT_PODCAST_DESC_ACCEPT=By.xpath("//form[contains(@id,'EditDescriptionForm')]/a[2]");

	public final String ELEMENT_MESSAGE_EDIT_INLINE = "An error occurred while modifying the required property.";
	public final String ELEMENT_MESSAGE_EDIT_CLOSE = "The changes you made will be lost if you close this form.";
	public final String ELEMENT_ENABLE_DMS_STRUCTURE = "enableStructure";
	public final By ELEMENT_PIC_IMGWIDTH = By.id("imageWidth");
	public final By ELEMENT_PIC_IMGHEIGHT = By.id("imageHeight");
	public final By ELEMENT_PIC_LANG = By.name("content-lang");
	public final By ELEMENT_PIC_CONT = By.xpath("//iframe[contains(@title,'Rich text editor, htmlData')]");
	public final By ELEMENT_CSS_NAME = By.id("name");
	public final By ELEMENT_CSS_ACTIVE = By.name("activeCSS");
	public final By ELEMENT_CSS_PRIORITY = By.id("CSSpriority");
	public final By ELEMENT_CSS_DATA = By.id("contentHtml");
	public final By ELEMENT_MYSITE_LINK = By.xpath("//a[contains(text(),'My Sites')]");
	public final By ELEMENT_ACME_SITE_LINK = By.linkText("acme");
	public final By ELEMENT_PAGE_TAG_P = By.xpath("//p");

	//JS
	public final By ELEMENT_JS_NAME = By.id("name");
	public final By ELEMENT_JS_ACTIVE = By.name("activeJS");
	public final By ELEMENT_JS_PRIORITY = By.id("JSpriority");
	public final By ELEMENT_JS_LANGUAGE = By.id("content-lang");
	public final By ELEMENT_JS_DATA = By.id("contentHtml");

	//Data test
	public final String[] DATA_SPECIAL_CHARACTER = {"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","{","}","[","]","|","\\",";",":","'","\"","<",",",".","/","?"};
	public final String DATA_SPECIAL_CHARACTER_STRING = "~`!@#$%^&*()-_=+[]{}\\|;:'\",<.>?/";

	//Add New Folder
	public final By ELEMENT_CREATE_FOLDER_BUTTON = By.xpath("//*[text()='Create Folder']");
	public final By ELEMENT_USE_CUSTOM_TYPE_FOLDER = By.id("customTypeCheckBox");

	public final String ELEMENT_VERIFY_FILE_CONTENT = "//*[contains(text(),'${content}')]";

	/*=================== Create a new document/article/file ===================*/
	/* 
	 * Add new article / Kofax / File Plan
	 * == REMOVED IN PLF 4 ==
	 */

	//Template: File > Open [Add Category] Form 
	public void openAddCategoryInFileTemplate(){
		info("-- Opening [Add Category] Form... --");
		if (isElementPresent(ELEMENT_CATEGORIES_ADD_ITEM)){
			click(ELEMENT_CATEGORIES_ADD_ITEM);
		}else{
			click("//*[contains(text(), 'Categories')]/..//*[@data-original-title='Add Item']");
		}
		Utils.pause(500);
	}

	//add new announcement
	public void createNewAnnouncement (String name, String sum){
		click(ELEMENT_ANNOUNCEMENT_LINK);
		type(ELEMENT_ANNOUNCEMENT_NAME_TEXTBOX, name, true);
		inputDataToFrame(ELEMENT_ANNOUNCEMENT_SUMMARY_FRAME,sum);
		switchToParentWindow();
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
	}

	//add new Free layout webcontent
	public void createNewWebContent(String name, String cont, String img, String sum, String css, String js){
		info("-- Creating a new Web Content --");
		Utils.pause(500);
		click(ELEMENT_WEBCONTENT_LINK);
		type(ELEMENT_WEBCONTENT_NAME_TEXTBOX, name, true);
		inputDataToFrame(ELEMENT_WEBCONTENT_CONTENT_FRAME,cont);
		switchToParentWindow();
		if (sum!="" || img !=""){
			click(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB);
			if (img!=""){
				//driver.switchTo().frame(waitForAndGetElement(ELEMENT_WEBCONTENT_UPLOAD_FRAME, 3000, 1, 2));
				//type(ELEMENT_WEBCONTENT_FILE_IMAGE, Utils.getAbsoluteFilePath(img), false);			
				WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, DEFAULT_TIMEOUT, 0, 2);
				((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
				upload.sendKeys(Utils.getAbsoluteFilePath(img));
				////
				switchToParentWindow();
				String links[] = img.split("/");
				int length = links.length;
				waitForElementPresent(By.xpath("//div[contains(text(),'" + links[length-1]+ "')]"));
			}
			inputDataToFrame(ELEMENT_WEBCONTENT_SUMMARY_FRAME, sum);
			switchToParentWindow();
		}
		if(css!="" || js !=""){
			click(ELEMENT_WEBCONTENT_ADVANCE_TAB);
			type(ELEMENT_WEBCONTENT_CSS_TEXTAREA, css, false);
			type(ELEMENT_WEBCONTENT_JS_TEXTAREA, js, false);
		}
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		Utils.pause(3000);
	}

	//Web Content > [Insert content link] 
	public void addContentLinkInFCKEditor(String path, String file){
		String previousWindowHandle = driver.getWindowHandle();
		click(ELEMENT_WEBCONTENT_ADD_CONTENT_LINK);
		switchToNewWindow();
		
		String[] link = path.split("/");
		for (int i = 0; i < link.length; i ++){
			click(By.id(link[i]));
		}
		click(By.linkText(file));
		driver.switchTo().window(previousWindowHandle);
		Utils.pause(1000);
	}
	
	//add new file
	public void createNewFile(String name, String cont, String title){
		click(ELEMENT_NEWFILE_LINK);	
		type(ELEMENT_NEWFILE_NAME_TEXTBOX, name, false);
		inputDataToFrame(ELEMENT_NEWFILE_CONTENT_FRAME, cont);
		switchToParentWindow();
		type(ELEMENT_NEWFILE_TITLE_TEXTBOX, title, false);
		//click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		button.saveAndClose();
		//waitForAndGetElement(By.xpath("//*[contains(text(), '" + title +"')]"));
		waitForElementPresent(By.xpath(ELEMENT_VERIFY_FILE_CONTENT.replace("${content}", cont)), DEFAULT_TIMEOUT, 1, 2);
		Utils.pause(1000);
	}

	//add new Sample Node
	/*public void createNewSampleNode(String title, String name, String img){
		waitForElementPresent(ELEMENT_SAMPLENODE_LINK);
		click(ELEMENT_SAMPLENODE_LINK);
		type(ELEMENT_SAMPLENODE_TITLE_TEXTBOX, title, false);
		//			waitForAndGetElement(ELEMENT_SAMPLENODE_NAME_TEXTBOX).clear();
		type(ELEMENT_SAMPLENODE_NAME_TEXTBOX, name, true);
		click(ELEMENT_SAMPLENODE_ADD_ITEM_LINK);
		selectOption(ELEMENT_SAMPLENODE_SELECTITEM,ELEMENT_SAMPLENODE_SELECTITEM_OPTION);
		click(ELEMENT_SAMPLENODE_SELECTITEM_OPTION_LINK);
		type(ELEMENT_SAMPLENODE_DESCRIPTION_TEXTBOX, title, false);
		if (img !=""){
			driver.switchTo().frame(waitForAndGetElement(ELEMENT_SAMPLENODE_UPLOAD_IMG_FRAME));
			type(ELEMENT_SAMPLENODE_FILE_IMG, Utils.getAbsoluteFilePath(img), false);
			switchToParentWindow();
			String links[] = img.split("/");
			int length = links.length;
			waitForElementPresent(By.xpath("//div[contains(text(),'" + links[length-1]+ "')]"));
		}
		type(ELEMENT_SAMPLENODE_CONTENT_TEXTAREA, title, false);
		type(ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA, title, false);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
	}*/

	// add new podcast
	/*public void createNewPodcast(String name, String title, String link){
		click(ELEMENT_PODCAST_LINK);
		type(ELEMENT_PODCAST_NAME_TEXTBOX, name, false);
		type(ELEMENT_PODCAST_TITLE_TEXTBOX, title, false);
		type(ELEMENT_PODCAST_LINK_TEXTBOX, link, false);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
	}*/

	//add new Picture on head layout webcontent
	//exo:pictureOnHeadWebContent is changed to Illustrated Web Content
	public void createNewIllustratedWebContent(String name, String content, String file, String illustrationImage, 
			String illustrationSummary, String css, String js, Object...params){
		info("-- Creating a new Illustrated Web Content --");
		//String imageWidth = (String) (params.length > 0 ? params[0]: "");
		//String imageHeight = (String) (params.length > 1 ? params[1]: "");

		click(ELEMENT_HEAD_LAYOUT_LINK);
		type(ELEMENT_HEAD_LAYOUT_NAME_TEXTBOX, name, false);
		inputDataToFrame(ELEMENT_WEBCONTENT_CONTENT_FRAME, content);
		switchToParentWindow();
		if (file != ""){
			WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, DEFAULT_TIMEOUT, 0, 2);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
			upload.sendKeys(Utils.getAbsoluteFilePath(file));
			////
			switchToParentWindow();
			String links[] = file.split("/");
			int length = links.length;
			waitForElementPresent(By.xpath("//div[contains(text(),'" + links[length-1]+ "')]"));
		}
		//Illustration tab
		if (illustrationSummary!="" || illustrationImage !=""){
			click(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB);
			if (illustrationImage!=""){			
				WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, DEFAULT_TIMEOUT, 0, 2);
				((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
				upload.sendKeys(Utils.getAbsoluteFilePath(illustrationImage));
				////
				switchToParentWindow();
				String links[] = illustrationImage.split("/");
				int length = links.length;
				waitForElementPresent(By.xpath("//div[contains(text(),'" + links[length-1]+ "')]"));
			}
			inputDataToFrame(ELEMENT_WEBCONTENT_SUMMARY_FRAME, illustrationSummary);
			switchToParentWindow();
		}
		//Advanced tab
		if(css!="" || js !=""){
			click(ELEMENT_WEBCONTENT_ADVANCE_TAB);
			type(ELEMENT_WEBCONTENT_CSS_TEXTAREA, css, false);
			type(ELEMENT_WEBCONTENT_JS_TEXTAREA, js, false);
		}
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementPresent(By.xpath(ELEMENT_VERIFY_FILE_CONTENT.replace("${content}", content)));
	}

	//add new product
	public void createNewProduct (String name, String title){
		click(ELEMENT_PRODUCT_LINK);
		type(ELEMENT_PRODUCT_NAME_TEXTBOX, name, false);
		type(ELEMENT_PRODUCT_TITLE_TEXTBOX, title, false);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
	}

	//Folder type 
	public enum folderType{
		None, Content, Document;
	}

	//add new Content Folder
	public void createNewFolder(String title, folderType type, boolean...verify) {
		info("-- Creating a new folder --");
		actBar.goToAddNewFolder();
		WebElement folderType = waitForAndGetElement(ELEMENT_USE_CUSTOM_TYPE_FOLDER, 5000, 0, 2);
		if (folderType != null && !folderType.isSelected()){
			click(ELEMENT_USE_CUSTOM_TYPE_FOLDER, 2);
		}
		switch (type) {
		case Content:
			type(ELEMENT_FOLDER_TITLE_TEXTBOX, title, false);
			selectOption(ELEMENT_FOLDER_TYPE_OPTION, ELEMENT_CONTENT_FOLDER_TYPE);
			break;
		case Document:
			selectOption(ELEMENT_FOLDER_TYPE_OPTION, ELEMENT_DOCUMENT_FOLDER_TYPE);
			type(ELEMENT_FOLDER_TITLE_TEXTBOX, title, false);
			break;
		case None:
			type(ELEMENT_FOLDER_TITLE_TEXTBOX, title, false);
			break;
		default:
			break;
		}
		click(ELEMENT_CREATE_FOLDER_BUTTON);
		//waitForElementPresent(By.xpath("//*[contains(text(),'"+ title +"')]"));
		waitForElementPresent(By.xpath(ELEMENT_VERIFY_FILE_CONTENT.replace("${content}", title)));
		Utils.pause(1000);
	}

	//Create a new Css file
	public void createNewCssFile(String name, String priority, String data, Object...params){
		Boolean active = (Boolean) (params.length > 0 ? params[0]: false);
		String lang = (String) (params.length > 1 ? params[1]: "");

		info("-- Creating a new Css File --");
		type(ELEMENT_CSS_NAME, name, false);
		if (!active){
			select(ELEMENT_CSS_ACTIVE, "False");
		}else{
			select(ELEMENT_CSS_ACTIVE, "True");
		}	
		type(ELEMENT_CSS_PRIORITY, priority, false);
		if (!lang.isEmpty()){
			select(ELEMENT_PIC_LANG, lang);
		}	
		type(ELEMENT_CSS_DATA, data, true);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		Utils.pause(1000);
	}

	//Create a new JS file
	public void createNewJsFile(String name, String priority, String data, Object... params){
		Boolean active = (Boolean) (params.length > 0 ? params[0]: false);
		String lang = (String) (params.length > 1 ? params[1]: "");

		info("-- Creating a new Js File --");
		//actBar.goToAddNewContent();
		type(ELEMENT_JS_NAME, name, true);
		if (!active){
			select(ELEMENT_JS_ACTIVE, "False");
		}else{
			select(ELEMENT_JS_ACTIVE, "True");
		}
		type(ELEMENT_JS_PRIORITY, priority, true);
		if (!lang.isEmpty()){
			selectOption(ELEMENT_JS_LANGUAGE, lang);
		}
		type(ELEMENT_JS_DATA, data, true);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
		Utils.pause(1000);
	}

	//Create content folder and check
	public void createAndCheckContentFolder(String name, By path){
		info("Create new content folder with name: "+name);
		createNewFolder(name, folderType.Content);
		waitForElementPresent(path);
		info("Create new content folder successfully"); 
	}

	/*=================== Edit a new document/article/file ===================*/

	/* 
	 * Edit content template 
	 * == REMOVED IN PLF 4 ==
	 */

	//Edit a Css File
	public void editCssFile(String name, String priority, String data, Object...params){
		Boolean active = (Boolean) (params.length > 0 ? params[0]: false);
		String lang = (String) (params.length > 1 ? params[1]: "");

		info("-- Editing Css File --");
		actBar.goToEditDocument(name); 
		if (!active){
			select(ELEMENT_CSS_ACTIVE, "False");
		}else{
			select(ELEMENT_CSS_ACTIVE, "True");
		}
		type(ELEMENT_CSS_PRIORITY, priority, true);
		if (!lang.isEmpty()){
			selectOption(ELEMENT_PIC_LANG, lang);
		}
		type(ELEMENT_CSS_DATA, data, true);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
	}

	//Edit a Js File
	public void editJsFile(String name, String priority, String data, Object...params){
		Boolean active = (Boolean) (params.length > 0 ? params[0]: false);
		String lang = (String) (params.length > 1 ? params[1]: "");

		info("-- Editing Js File --");
		actBar.goToEditDocument(name);
		if (!active){
			select(ELEMENT_JS_ACTIVE, "False");
		}else{
			select(ELEMENT_JS_ACTIVE, "True");
		}
		type(ELEMENT_JS_PRIORITY, priority, true);
		if (!lang.isEmpty()){
			select(ELEMENT_JS_LANGUAGE, lang);
		}
		type(ELEMENT_JS_DATA, data, true);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
	}

	//Edit File document
	public void editFile(String titleFile, String titleEdit, String contentEdit, Object... params){
		int option = (Integer) (params.length > 0 ? params[0] : 2);
		actBar.goToEditDocument(titleFile);
		Utils.pause(500);
		//type(ELEMENT_NEWFILE_NAME_TEXTBOX, nameEdit, true);
		inputDataToFrame(ELEMENT_NEWFILE_CONTENT_FRAME, contentEdit, true);
		switchToParentWindow();
		type(ELEMENT_NEWFILE_TITLE_TEXTBOX, titleEdit, true);
		if (option == 0){
			button.save();
			//waitForElementNotPresent(button.ELEMENT_SAVE_BUTTON);
			waitForElementPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
		} else if (option == 1){
			button.close();
			magAlert.acceptAlert();
			Utils.pause(500);
		} else{
			button.saveAndClose();
			waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
			waitForElementPresent(By.xpath(ELEMENT_VERIFY_FILE_CONTENT.replace("${content}", contentEdit)), DEFAULT_TIMEOUT, 1, 2);
		}
		//waitForAndGetElement(By.xpath("//body/p[contains(text(), '" + contentEdit +"')]"));
	}

	//Edit Illustrated Web Content
	public void editIllustratedWebContent(String title, String contentToEdit, String file, String illustrationImage, 
			String illustrationSummary, String css, String js, Object...params){
		String imageWidth = (String) (params.length > 0 ? params[0]: "");
		String imageHeight = (String) (params.length > 1 ? params[1]: "");
		String lang = (String) (params.length > 2 ? params[2]: "");

		info("-- Editing Illustrated Web Content -- " + title);
		actBar.goToEditDocument(title);
		inputDataToFrame(ELEMENT_WEBCONTENT_CONTENT_FRAME, contentToEdit, true);
		switchToParentWindow();	

		//Main Content tab
		if (file != ""){
			//driver.switchTo().frame(waitForAndGetElement(ELEMENT_HEAD_LAYOUT_UPLOAD_FRAME));
			//type(ELEMENT_HEAD_LAYOUT_UPLOAD_FILE, Utils.getAbsoluteFilePath(file), false);
			WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, DEFAULT_TIMEOUT, 0, 2);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
			upload.sendKeys(Utils.getAbsoluteFilePath(file));
			////
			switchToParentWindow();
			String links[] = file.split("/");
			int length = links.length;
			waitForElementPresent(By.xpath("//div[contains(text(),'" + links[length-1]+ "')]"));
		}
		if (!imageWidth.isEmpty())
			type(ELEMENT_PIC_IMGWIDTH, imageWidth,true);
		if (!imageHeight.isEmpty())
			type(ELEMENT_PIC_IMGHEIGHT, imageHeight, true);
		if (!lang.isEmpty())
			selectOption(ELEMENT_PIC_LANG, lang);

		//Illustration tab
		if (illustrationSummary != "" || illustrationImage != ""){
			click(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB);
			waitForElementPresent(By.xpath("//*[@class='active']//*[contains(text(), 'Illustration')]"));
			if (illustrationImage != ""){
				//WebElement removeIcon = waitForAndGetElement(ELEMENT_UPLOAD_REMOVE);
				if (waitForAndGetElement(ELEMENT_UPLOAD_REMOVE, 3000, 0) != null)
				{
					click(ELEMENT_UPLOAD_REMOVE);
				}
				Utils.pause(1000);
				click(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB);
				WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, DEFAULT_TIMEOUT, 0, 2);
				((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
				upload.sendKeys(Utils.getAbsoluteFilePath(illustrationImage));
				////
				switchToParentWindow();
				String links[] = illustrationImage.split("/");
				int length = links.length;
				waitForElementPresent(By.xpath("//div[contains(text(),'" + links[length-1]+ "..." +"')]"));
			}
			inputDataToFrame(ELEMENT_WEBCONTENT_SUMMARY_FRAME, illustrationSummary, true);
			switchToParentWindow();
		}

		//Advanced tab
		if(css!="" || js !=""){
			click(ELEMENT_WEBCONTENT_ADVANCE_TAB);
			type(ELEMENT_WEBCONTENT_CSS_TEXTAREA, css, true);
			type(ELEMENT_WEBCONTENT_JS_TEXTAREA, js, true);
		}

		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementPresent(By.xpath(ELEMENT_VERIFY_FILE_CONTENT.replace("${content}", contentToEdit)));
	}

	//Edit WebContent Inline
	public void editWebContentInline(String openField, By inputField, String value, By accept)
	{
		enableEditMode(true);
		doubleClickOnElement(openField);
		inputDataToFrame(inputField, value, true);
		switchToParentWindow();
		click(accept);
		waitForElementPresent(By.xpath("//p[contains(text(),'"+value+"')]"));
	}

	//Edit a WebContent
	public void editWebContent(String title, String contentToEdit, String img, String sum, String css, String js) 
	{   
		info("-- Editing Web Content --" + title);
		actBar.goToEditDocument(title);
		//type(ELEMENT_WEBCONTENT_TITLE_TEXTBOX, title_edit, true);
		//		waitForAndGetElement(ELEMENT_WEBCONTENT_NAME_TEXTBOX).clear();
		inputDataToFrame(ELEMENT_WEBCONTENT_CONTENT_FRAME, contentToEdit, true);
		switchToParentWindow();
		if (sum != "" || img != ""){
			click(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB);
			waitForElementPresent(By.xpath("//*[@class='active']//*[contains(text(), 'Illustration')]"));
			if (img != ""){
				WebElement removeIcon = waitForAndGetElement(ELEMENT_UPLOAD_REMOVE);
				if (removeIcon != null)
				{
					click(ELEMENT_UPLOAD_REMOVE);
				}
				Utils.pause(1000);
				//driver.switchTo().frame(waitForAndGetElement(ELEMENT_WEBCONTENT_UPLOAD_FRAME));
				//type(ELEMENT_WEBCONTENT_FILE_IMAGE, Utils.getAbsoluteFilePath(img), false);
				click(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB);
				WebElement upload = waitForAndGetElement(ELEMENT_UPLOAD_NAME, DEFAULT_TIMEOUT, 0, 2);
				((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", upload);
				upload.sendKeys(Utils.getAbsoluteFilePath(img));
				////
				switchToParentWindow();
				String links[] = img.split("/");
				int length = links.length;
				waitForElementPresent(By.xpath("//div[contains(text(),'" + links[length-1]+ "..." +"')]"));
			}
			inputDataToFrame(ELEMENT_WEBCONTENT_SUMMARY_FRAME,sum,true);
			switchToParentWindow();
		}

		if(css!="" || js !=""){
			click(ELEMENT_WEBCONTENT_ADVANCE_TAB);
			type(ELEMENT_WEBCONTENT_CSS_TEXTAREA, css, true);
			type(ELEMENT_WEBCONTENT_JS_TEXTAREA, js, true);
		}
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);	
		waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON, 3000);
		waitForElementPresent(ELEMENT_VERIFY_FILE_CONTENT.replace("${content}", contentToEdit));
	}

	//edit a podcast
	/*public void editPodcast(String title, String title_edit, String...link_edit){
			actBar.goToEditDocument(title);
			type(ELEMENT_PODCAST_TITLE_TEXTBOX, title_edit, true);
			if (link_edit.length > 0)
				type(ELEMENT_PODCAST_LINK_TEXTBOX, link_edit[0], true);
			if (link_edit.length > 1)
				type(ELEMENT_PODCAST_DESCRIPTION, link_edit[1], true);
			click(button.ELEMENT_SAVE_CLOSE_BUTTON);
			waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
			waitForElementPresent(By.xpath("//a[@title='"+ title_edit+" ']"));
		}*/

	/*public void editPodcastInline(String openField, By inputField, By accept, String value)
		{
			enableEditMode(true);
			doubleClickOnElement(openField);
			try{
				type(inputField, value, true);
				click(accept);

			}catch(UnhandledAlertException e)
			{	
				assert false: "Fail to edit inline!";
			}
			//verify to edit successfully
			waitForElementPresent(By.xpath("//div[contains(text(),'"+value+"')]"));		
		}*/

	/*public void editSampleNode(String title, String title_edit, String sum_edit, String cont_edit){
			actBar.goToEditDocument(title);
			type(ELEMENT_SAMPLENODE_TITLE_TEXTBOX, title_edit, true);
			type(ELEMENT_SAMPLENODE_CONTENT_TEXTAREA, cont_edit, true);
			type(ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA, sum_edit, true);
			click(button.ELEMENT_SAVE_CLOSE_BUTTON);
			waitForElementNotPresent(button.ELEMENT_SAVE_CLOSE_BUTTON);
			waitForElementPresent(By.xpath("//a[@title='"+ title_edit+" ']"));
		}

		public void editSampleNodeInline(String openField, By inputField, String value, By accept)
		{
			enableEditMode(true);
			doubleClickOnElement(openField);
			type(inputField,value,true);
			click(accept);
			waitForElementPresent(By.xpath("//div[contains(text(),'"+value+"')]"));
		}*/
	
	public void editLanguageForDocument(String name, String language){
		actBar.goToEditDocument(name);
		
		select(ELEMENT_SELECT_LANGUAGE, language);
		click(button.ELEMENT_SAVE_CLOSE_BUTTON);
		waitForElementNotPresent(ELEMENT_SELECT_LANGUAGE);
	}
}