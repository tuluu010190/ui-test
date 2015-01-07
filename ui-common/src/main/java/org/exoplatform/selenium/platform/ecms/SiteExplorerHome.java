package org.exoplatform.selenium.platform.ecms;

import org.exoplatform.selenium.ManageAlert;
import static org.exoplatform.selenium.TestLogger.info;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SiteExplorerHome extends PlatformBase{

	PlatformPermission per;
	ManageAlert alert;
	CreateNewDocument CreNewDoc;
	
	public final By ELEMENT_SITEEXPLORER_WORKING_PANEL = By.xpath("//*[@class='navItemSelected' and text()='Content Explorer']");

	//Action Bar
	public final By ELEMENT_ACTIONBAR_ADDDOCUMENT = By.xpath("//*[@class='uiIconEcmsAddDocument uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_ADDFOLDER = By.xpath("//*[@class='uiIconEcmsAddFolder uiIconEcmsLightGray']");
	
	// upload
	public final By ELEMENT_ACTIONBAR_UPLOAD = By.xpath("//*[@class='uiIconEcmsUpload uiIconEcmsLightGray']");
	public final By ELEMENT_MORE_LINK_WITHOUT_BLOCK = By.xpath("//*[@id='uiActionsBarContainer']//*[contains(text(), 'More')]");
	public final By ELEMENT_UPLOAD_LINK = By.id("MultiUploadInputFiles");
	public final By ELEMENT_ACTIONBAR_EDIT = By.xpath("//*[@class='uiIconEcmsEditDocument uiIconEcmsLightGray']");
	public final By ELEMENT_ACTIONBAR_SHOWDRIVES = By.xpath("//*[@id='driveAction']");
	
	//Drive selection
	public final String ELEMENT_SELECTDRIVE_SPECIFICDRIVE = "//*[@class='driveLabel' and @data-original-title='${spaceName}']";
	
	//Add document
	public final By ELEMENT_ADDDOCUMENT_CHOICETYPE = By.xpath("//*[@class='templateTitle']");

	//Add folder
	public final By ELEMENT_ADDFOLDERBOX = By.xpath("//*[@class='PopupTitle popupTitle']");
	public final By ELEMENT_ADDFOLDER_NAME = By.xpath("//*[@id='titleTextBox']");
	public final By ELEMENT_ADDFOLDER_FOLDERTYPE = By.xpath("//*[@class='selectbox']");
	public final By ELEMENT_ADDFOLDER_CREATEFOLDERBUTTON = By.xpath("//*[@class='btn addFolderButton']");


	//Left explorer box
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_INTRANET = By.xpath("//*[@class='uiIcon16x16FolderDefault uiIcon16x16exo_portalFolder' and @title='intranet']");
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_DOCUMENT = By.xpath("//*[@class='uiIcon16x16FolderDefault uiIcon16x16exo_documentFolder' and @title='documents']");
	public final By ELEMENT_SITEEXPLORER_LEFTBOX_SPACE = By.xpath("//*[@class='uiIcon16x16FolderDefault uiIcon16x16exo_portalFolder' and @title='intranet']");
	public final String ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME = "//*[@class='nodeName' and text()='${title}']";
	public final By ELEMENT_SITEEXPLORER_ACTION_DELETE = By.xpath("//*[@class='uiIconEcmsDelete']");

	
	//Confirm delete box
	public final By ELEMENT_SITEEXPLORER_CONFIRMBOX_DELETE= By.xpath("//*[@class='uiAction uiActionBorder']//*[text()='Delete']");

	//upload file form
	public String ELEMENT_ATTACHMENT_FORM_FILE_NAME = "//*[text()='$fileName']";
	public By ELEMENT_EVENT_FILE_INPUT = By.xpath("//*[@id='upload']//*[@name='file']");
	public By ELEMENT_ATTACHMENT_SAVE_BUTTON = By.xpath("//*[@id='UIAttachFileForm']//*[text()='Save']");
	public String ELEMENT_ATTACH_FILE_NAME = "//*[@data-original-title='$fileName']";
	
	public SiteExplorerHome(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		CreNewDoc = new CreateNewDocument(driver);
		
	}

	public void goToAddNewFolder() {
		click(ELEMENT_ACTIONBAR_ADDFOLDER);
		waitForAndGetElement(ELEMENT_ADDFOLDERBOX);
	}

	public void createFolder(String title, String folderType) {
		type(ELEMENT_ADDFOLDER_NAME, title, true);
		select(ELEMENT_ADDFOLDER_FOLDERTYPE, folderType );
		click(ELEMENT_ADDFOLDER_CREATEFOLDERBUTTON);
		waitForAndGetElement(By.xpath((ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", title)));
	}

	public void goToAddNewContent() {
		click(ELEMENT_ACTIONBAR_ADDDOCUMENT);
		waitForAndGetElement(ELEMENT_ADDDOCUMENT_CHOICETYPE);
	}

	public void deleteData(String title) {
		rightClickOnElement(By.xpath((ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", title)));
		click(ELEMENT_SITEEXPLORER_ACTION_DELETE);
		click(ELEMENT_SITEEXPLORER_CONFIRMBOX_DELETE);
		waitForElementNotPresent(By.xpath((ELEMENT_SITEEXPLORER_LEFTBOX_NODENAME).replace("${title}", title)));
	}

	/**
	* Upload a file
	*
	* @param link
	* @param params
	 * @return 
	* @return
	*/
	public SiteExplorerHome uploadFile(String link, Object... params) {
	Boolean verify = (Boolean) (params.length > 0 ? params[0] : true);
	if (waitForAndGetElement(ELEMENT_ACTIONBAR_UPLOAD, DEFAULT_TIMEOUT, 0) == null) {
	click(ELEMENT_MORE_LINK_WITHOUT_BLOCK);
	}
	((JavascriptExecutor) driver)
	.executeScript(
	"arguments[0].style.visibility = 'block'; arguments[0].style.height = '1px'; "
	+ "arguments[0].style.width = '1px'; arguments[0].style.opacity = 1",
	waitForAndGetElement(ELEMENT_UPLOAD_LINK,
	DEFAULT_TIMEOUT, 1, 2));
	Utils.pause(10000);
	type(ELEMENT_UPLOAD_LINK, Utils.getAbsoluteFilePath(link), false, 2);
	info("Upload file " + Utils.getAbsoluteFilePath(link));
	switchToParentWindow();
	if (verify) {
	String links[] = link.split("/");
	int length = links.length;
	Utils.pause(2000);
	waitForAndGetElement(By.xpath("//*[contains(text(),'"+ links[length - 1] + "')]"));
	}
	info("Upload file successfully");
	Utils.pause(2000);
	return new SiteExplorerHome(driver);
	}

	
	
	public void goToEditDocument() {
		click(ELEMENT_ACTIONBAR_EDIT);
		Utils.pause(3000);
	}
	
	public void editDocument(String content) {
		driver.navigate().refresh();
		
		if(content != ""){	
		inputDataToFrame(CreNewDoc.ELEMENT_FILEFORM_BLANK_CONTENT , content, false);
		switchToParentWindow();
		}
	}
	
	public void goToIntranet() {
		click(ELEMENT_SITEEXPLORER_LEFTBOX_INTRANET);
	}
	
	public void goToDocument() {
		click(ELEMENT_SITEEXPLORER_LEFTBOX_DOCUMENT);
	}
	
	public void goToSpace(String spaceName) {
		click(ELEMENT_ACTIONBAR_SHOWDRIVES);
		click(By.xpath((ELEMENT_SELECTDRIVE_SPECIFICDRIVE).replace("${spaceName}", spaceName)));
	}
}
