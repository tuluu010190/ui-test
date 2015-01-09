package org.exoplatform.selenium.platform.ecms;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPageWCM extends PlatformBase {

	final public By ELEMENT_ADDNEWPAGE_NODENAME = By.xpath("//*[@id='pageName']");
	final public By ELEMENT_ADDNEWPAGE_DISPLAYNAME = By.xpath("//*[@id='i18nizedLabel']");
	final public By ELEMENT_ADDNEWPAGE_BTNNEXT = By.xpath("//*[@class='btn btn-primary' and text()='Next']");

	//page editor
	final public By ELEMENT_PAGEEDITOR_CONTENTTAB = By.xpath("//*[@title='Content']");
	final public By ELEMENT_PAGEEDITOR_CONTENTLIST = By.xpath("//*[@id='Content/ContentListViewerPortlet']");
	final public By ELEMENT_PAGEEDITOR_CONTENTDETAIL = By.xpath("//*[@id='Content/SingleContentViewer']");
	final public By ELEMENT_PAGEEDITOR_VIEWPAGE = By.xpath("//*[@class='VIEW-PAGE']");
	final public By ELEMENT_PAGEEDITOR_EDITELEMENT = By.xpath("//*[@class='uiIconEdit uiIconWhite']");
	final public By ELEMENT_PAGEEDITOR_ADDPATHBTN = By.xpath("//*[@class='uiIconAddPath uiIconLightGray']");
	final public By ELEMENT_PAGEEDITOR_SAVEBTN = By.xpath("//*[@class='btn' and text()='Save']");
	final public By ELEMENT_PAGEEDITOR_CLOSEBTN = By.xpath("//*[@class='btn' and text()='Close']");
	final public By ELEMENT_PAGEEDITOR_FINISHBTN = By.xpath("//*[@class='uiIconSave uiIconDarkGray pull-right']");
	final public By ELEMENT_PAGEEDITOR_BYCONTENTRADIOBN = By.xpath("//*[@class='radio' and @value='ManualViewerMode']");

	//Multiple content selector
	final public String ELEMENT_FOLDERSELECTOR_PATH = "//*[@class='nodeName' and text()=' ${path}' ]";
	final public String ELEMENT_FOLDERSELECTOR_CONTENTLIST_FINALPATH = "//*[@class='Item' and text()='${name}']";
	final public String ELEMENT_FOLDERSELECTOR_CONTENTDETAIL_FINALPATH = "//*[@class='OddItem']//*[text()='${name}']";
	
	//Content Detail Preference
	final public By ELEMENT_CONTENTDETAILPREF_TABCONTENTDISPLAY = By.xpath("//*[@class='uiContentBox']");
	final public By ELEMENT_CONTENTDETAILPREF_TABCONTENTPREFERENCES = By.xpath("//*[@data-original-title='Preferences']");
	final public By ELEMENT_CONTENTDETAILPREF_TABDISPLAYSETTINGS = By.xpath("//*[@data-target='#clvDisplayTab-tab']");
	final public By ELEMENT_CONTENTDETAILPREF_HEADERTXTBOX = By.xpath("//*[@id='UICLVConfigHeaderFormStringInput']");


	public EditPageWCM(WebDriver driver) {
		this.driver=driver;
	}


	public void fillNewPageForm(String name, String displayName) {
		type(ELEMENT_ADDNEWPAGE_NODENAME, name, true);
		type(ELEMENT_ADDNEWPAGE_DISPLAYNAME, displayName, true);
		//ToComplete
		click(ELEMENT_ADDNEWPAGE_BTNNEXT);
	}

	public void addContentInPageEditor(By tab, By element) {
		click(tab);
		dragAndDropToObject(element, ELEMENT_PAGEEDITOR_VIEWPAGE);
	}

	public void editFolderPath(String lastPath, String path1, String path2, String path3, String contentType) {
		click(ELEMENT_PAGEEDITOR_ADDPATHBTN);
		
		if(path1 != "") {
			click(By.xpath((ELEMENT_FOLDERSELECTOR_PATH).replace("${path}", path1)));
			if(path2 != "") {
				click(By.xpath((ELEMENT_FOLDERSELECTOR_PATH).replace("${path}", path2)));
				if(path3 != "") {
					click(By.xpath((ELEMENT_FOLDERSELECTOR_PATH).replace("${path}", path3)));
				}
			}
		}
		if (contentType == "contentList"){
		click(By.xpath((ELEMENT_FOLDERSELECTOR_CONTENTLIST_FINALPATH).replace("${name}", lastPath)));
		}
		else if (contentType == "contentDetail") {
			click(By.xpath((ELEMENT_FOLDERSELECTOR_CONTENTDETAIL_FINALPATH).replace("${name}", lastPath)));
		}
	}	
}
