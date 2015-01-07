package org.exoplatform.selenium.platform.ecms;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewDocument extends PlatformBase{

	PlatformPermission per;
	ManageAlert alert;

	SiteExplorerHome SEHome;

	public final By ELEMENT_ADDDOCUMENT_FILE = By.xpath("//*[@class='uiIcon64x64Templatent_file']");
	public final By ELEMENT_ADDDOCUMENT_WEBCONTENT = By.xpath("//*[@class='uiIcon64x64Templateexo_webContent']");

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

	public CreateNewDocument(WebDriver driver) {
		this.driver= driver;
		alert = new ManageAlert(driver);
	}

	public enum selectDocumentType{
		FILE, WEBCONTENT, ACCESSIBLEMEDIA, ANNOUNCEMENT, CSSFILE, CONTACTUS, HTMLFILE, ILLUSTRATEDWEBCONTENT,
		JAVASCRIPTFILE, PRODUCT, WEBLINK
	}

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
			//ToDO
			break;

		case ANNOUNCEMENT:
			//ToDO
			break;

		case CSSFILE:
			//ToDO
			break;

		case CONTACTUS:
			//ToDO
			break;

		case HTMLFILE:
			//ToDO
			break;

		case ILLUSTRATEDWEBCONTENT:
			//ToDO
			break;

		case WEBLINK:
			//ToDO
			break;

		case PRODUCT:
			//ToDO
			break;

		case JAVASCRIPTFILE:
			//ToDO
			break;
		}
	}

	public void addNewFile(String title, String content) {
		type(ELEMENT_FILEFORM_BLANK_NAME, title, true);
		inputDataToFrame(ELEMENT_FILEFORM_BLANK_CONTENT , content, true);
		switchToParentWindow();
	}

	public void addNewWebContent(String title, String content) {
		type(ELEMENT_FILEFORM_BLANK_NAME, title, true);
		inputDataToFrame(ELEMENT_FILEFORM_BLANK_CONTENT , content, true);
		switchToParentWindow();
	}

	public void saveAndClose() {
		click(ELEMENT_FILEFORM_BUTTON_SAVEANDCLOSE);
	}

	public void addLinkInWebContent(String url) {
		click(ELEMENT_WEBCONTENTFORM_BUTTON_LINK);
		type(ELEMENT_WEBCONTENTFORM_LINK_ADRESS, url, true);
		click(ELEMENT_WEBCONTENTFORM_LINK_OK);
	}

	// To complete \\
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
