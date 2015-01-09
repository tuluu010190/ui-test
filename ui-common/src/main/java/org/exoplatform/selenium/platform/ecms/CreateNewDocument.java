package org.exoplatform.selenium.platform.ecms;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewDocument extends PlatformBase{

	PlatformPermission per;
	ManageAlert alert;

	SiteExplorerHome SEHome;

	// template form
	public final By ELEMENT_ADDDOCUMENT_FILE = By.xpath("//*[@class='uiIcon64x64Templatent_file']");
	public final By ELEMENT_ADDDOCUMENT_WEBCONTENT = By.xpath("//*[@class='uiIcon64x64Templateexo_webContent']");
    public final By ELEMENT_ADDDOCUMENT_ACCESSIBLE_MEDIA = By.xpath(".//*[@class='uiIcon64x64Templateexo_accessibleMedia']");
    public final By ELEMENT_ADDDOCUMENT_ANNOUNCEMENT = By.xpath(".//*[@class='uiIcon64x64Templateexo_announcement']");
    public final By ELEMENT_ADDDOCUMENT_CSS_FILE = By.xpath(".//*[@class='uiIcon64x64Templateexo_cssFile']");
    public final By ELEMENT_ADDDOCUMENT_CONTACT_US = By.xpath(".//*[@class='uiIcon64x64Templateacme_contact_us']");
    public final By ELEMENT_ADDDOCUMENT_HTML_FILE = By.xpath(".//*[@class='uiIcon64x64Templateexo_htmlFile']");
    public final By ELEMENT_ADDDOCUMENT_ILLUSTRATED_WEB_CONTENT = By.xpath(".//*[@class='uiIcon64x64Templateexo_pictureOnHeadWebcontent']");
    public final By ELEMENT_ADDDOCUMENT_JAVASCRIPT_FILE = By.xpath(".//*[@class='uiIcon64x64Templateexo_jsFile']");
    public final By ELEMENT_ADDDOCUMENT_PRODUCT_FILE = By.xpath(".//*[@class='uiIcon64x64Templateacme_product']");
    public final By ELEMENT_ADDDOCUMENT_WEBLINK = By.xpath(".//*[@class='uiIcon64x64Templateexo_link']");
    
    
    //Document form
	public final By ELEMENT_DOCFORM_BLANK_TITLE = By.xpath("//*[@id='title0']");
	public final By ELEMENT_DOCFORM_BLANK_DESC = By.xpath("//*[@id='description0']");
	public final By ELEMENT_DOCFORM_BLANK_CREATOR = By.xpath("//*[@id='creator0']");
	public final By ELEMENT_DOCFORM_BLANK_SOURCE = By.xpath("//*[@id='source0']");

	//New file form
	public final By ELEMENT_FILEFORM_BLANK_NAME = By.xpath("//*[@id='name']");
	public final By ELEMENT_FILEFORM_BLANK_CONTENT = By.xpath("//div[@id= 'cke_1_contents']/iframe");
	public final By ELEMENT_FILEFORM_BLANK_CONTENT2 = By.xpath("//*[@id='cke_1_contents']/iframe");
	public final By ELEMENT_FILEFORM_BUTTON_SAVEANDCLOSE = By.xpath("//*[@class='btn' and text()='Save & Close']"); 

	//New Web content form
	public final By ELEMENT_WEBCONTENTFORM_BUTTON_LINK = By.xpath("//*[@class='cke_button_icon cke_button__link_icon']");
	public final By ELEMENT_WEBCONTENTFORM_LINK_ADRESS = By.xpath("//*[@id='cke_128_textInput']");
	public final By ELEMENT_WEBCONTENTFORM_LINK_OK = By.xpath("//*[@id='cke_275_label']");

	//New folder popup
	public final By ELEMENT_ADD_NEW_FOLDER_POPUP_TITLE= By.xpath(".//*[@id='UIPopupWindow']//span[text()='New Folder']");
	public final By ELEMENT_USE_CUSTOM_TYPE_FOLDER = By.id("customTypeCheckBox");
	public final By ELEMENT_FOLDER_TITLE_TEXTBOX = By.id("titleTextBox");
	public final By ELEMENT_FOLDER_TYPE_OPTION = By.name("customTypeSelectBox");
	public final String ELEMENT_CONTENT_FOLDER_TYPE = "nt:unstructured";
	
	public final String ELEMENT_DOCUMENT_FOLDER_TYPE = "nt:folder";
	public final By ELEMENT_DOCUMENT_FOLDER_TYPE_XPATH = By.xpath("//option[text()='Document Folder']");
	public final By ELEMENT_CREATE_FOLDER_BUTTON = By.xpath("//*[text()='Create Folder']");
	
	public CreateNewDocument(WebDriver driver) {
		this.driver= driver;
		alert = new ManageAlert(driver);
	}

	/**
	 * Select a document by type
	 */
	public enum selectDocumentType{
		FILE, WEBCONTENT, ACCESSIBLEMEDIA, ANNOUNCEMENT, CSSFILE, CONTACTUS, HTMLFILE, ILLUSTRATEDWEBCONTENT,
		JAVASCRIPTFILE, PRODUCT, WEBLINK
	}
	/**
	 * Create a new document
	 * @param type
	 */
	public void createNewDoc(selectDocumentType type) {
		info("Go to type "+ type);
		switch(type){
		case FILE:
			click(ELEMENT_ADDDOCUMENT_FILE);
			break;
		case WEBCONTENT:
			click(ELEMENT_ADDDOCUMENT_WEBCONTENT);
			break;

		case ACCESSIBLEMEDIA:
			click(ELEMENT_ADDDOCUMENT_ACCESSIBLE_MEDIA);
			break;

		case ANNOUNCEMENT:
			click(ELEMENT_ADDDOCUMENT_ANNOUNCEMENT);
			break;

		case CSSFILE:
			click(ELEMENT_ADDDOCUMENT_CSS_FILE);
			break;

		case CONTACTUS:
			click(ELEMENT_ADDDOCUMENT_CONTACT_US);
			break;

		case HTMLFILE:
			click(ELEMENT_ADDDOCUMENT_HTML_FILE);
			break;

		case ILLUSTRATEDWEBCONTENT:
			click(ELEMENT_ADDDOCUMENT_ILLUSTRATED_WEB_CONTENT);
			break;

		case WEBLINK:
			click(ELEMENT_ADDDOCUMENT_WEBLINK);
			break;

		case PRODUCT:
			click(ELEMENT_ADDDOCUMENT_PRODUCT_FILE);
			break;

		case JAVASCRIPTFILE:
			click(ELEMENT_ADDDOCUMENT_JAVASCRIPT_FILE);
			break;
		}
	}
	
	/**
	 * Define Folder types
	 * By  quynhpt
	 * Date 16/01/2015
	 */
	public enum folderType {
		None, Content, Document, Css;
	}
	
	/**
	 * Add and select the type of new Content Folder
	 * By QuynhPT
	 * Date 16/01/2015
	 * @param title
	 * @param type
	 */
	public void createNewFolder(String title, folderType type) {
		info("-- Creating a new folder --");
		//Verify that the popup is shown
		waitForAndGetElement(ELEMENT_ADD_NEW_FOLDER_POPUP_TITLE,2000,0);
		//Verify that has check box element is shown on the popup
		WebElement checkBox= waitForAndGetElement(ELEMENT_USE_CUSTOM_TYPE_FOLDER,5000, 0);
		//if check box is avaiabled and unchecked, so, check it.
		if (checkBox != null && !checkBox.isSelected()) {
			click(ELEMENT_USE_CUSTOM_TYPE_FOLDER, 2);
		}
		//Select a type of new folder 
		switch (type) {
		case Content:
			type(ELEMENT_FOLDER_TITLE_TEXTBOX, title, true);
			break;
		case Document:
			type(ELEMENT_FOLDER_TITLE_TEXTBOX, title, true);
			selectOption(ELEMENT_FOLDER_TYPE_OPTION,
					ELEMENT_DOCUMENT_FOLDER_TYPE);
			break;
		default:
			break;
		}
		//Save the changes
		click(ELEMENT_CREATE_FOLDER_BUTTON);
		Utils.pause(2000);
	}

	/**
	 * Add a new file only with title and content string
	 * update QuynhPT
	 * date 13/01/2015
	 * @param title
	 * @param content
	 */
	public void addNewFile(String title, String content) {
		this.driver.navigate().refresh();
		type(ELEMENT_FILEFORM_BLANK_NAME, title, true);
		WebElement e = waitForAndGetElement(ELEMENT_FILEFORM_BLANK_CONTENT,DEFAULT_TIMEOUT,1,2);
		driver.switchTo().frame(e);
		WebElement inputsummary = driver.switchTo().activeElement();
		inputsummary.click();
		inputsummary.sendKeys(content);
		switchToParentWindow();
	}

	/**
	 * Add a new Webcontent
	 * @param title
	 * @param content
	 */
	public void addNewWebContent(String title, String content) {
		type(ELEMENT_FILEFORM_BLANK_NAME, title, true);
		inputDataToFrame(ELEMENT_FILEFORM_BLANK_CONTENT , content, true);
		switchToParentWindow();
	}

	/**
	 * Save and close a file form
	 */
	public void saveAndClose() {
		click(ELEMENT_FILEFORM_BUTTON_SAVEANDCLOSE);
	}

	/**
	 * Add a link into webcontent
	 * @param url
	 */
	public void addLinkInWebContent(String url) {
		click(ELEMENT_WEBCONTENTFORM_BUTTON_LINK);
		type(ELEMENT_WEBCONTENTFORM_LINK_ADRESS, url, true);
		click(ELEMENT_WEBCONTENTFORM_LINK_OK);
	}

	/**
	 * Create a Advanced Document
	 * @param name
	 * @param content
	 * @param title
	 * @param desc
	 * @param creator
	 * @param source
	 */
	public void createAdvancedDocument(String name, String content, String title, String desc, String creator, String source) {

		type(ELEMENT_FILEFORM_BLANK_NAME, title, true);
		inputDataToFrame(ELEMENT_FILEFORM_BLANK_CONTENT , content, true);
		switchToParentWindow();
		if(title != "" && title != null){
			type(ELEMENT_DOCFORM_BLANK_TITLE,title, true);
		}
		if(desc != "" && desc != null){
			type(ELEMENT_DOCFORM_BLANK_DESC,desc, true);
		}
		if(creator != "" && creator != null){
			type(ELEMENT_DOCFORM_BLANK_CREATOR,creator, true);
		}
		if(source != "" && source != null){
			type(ELEMENT_DOCFORM_BLANK_SOURCE,source, true);
		}
	}

}
