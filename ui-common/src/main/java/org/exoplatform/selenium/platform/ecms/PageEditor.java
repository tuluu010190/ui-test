package org.exoplatform.selenium.platform.ecms;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.UserGroupManagement.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import org.openqa.selenium.By;

public class PageEditor extends EcmsBase {

	/*-- Site Editor/Edit Page/Edit Mode 
	 *-- Select Content Path/Content Search Form Tab  
	 * --*/
		
	public static final By ELEMENT_SEARCH_BUTTON = By.xpath("//a[text()='Search']");
	public static final By ELEMENT_CLOSE_WINDOWS_BUTTON = By.xpath("//a[@class='CloseButton']"); 
	public static final By ELEMENT_CONFIRM_YES_BUTTON = By.xpath("//a[contains(text(), 'Yes')]");
	public static final By ELEMENT_RADIO_MODE_CONTENT = By.id("UICLVConfigDisplayModeFormRadioBoxInput_ManualViewerMode"); 
	public static final By ELEMENT_RADIO_MODE_FOLDER = By.id("UICLVConfigDisplayModeFormRadioBoxInput_AutoViewerMode");

	//Edit "content list" portlet 
	public static By ELEMENT_EDITPAGE_CONTENT_DELETE = By.xpath("//div[@class='DeleteIcon']");
	public static By ELEMENT_TAB_SEARCH_RESULT=By.xpath("//div[@class='SelectedTab']/div/div/div[contains(text(),'Search Result')]");
	public static By ELEMENT_CLOSE_POPUP_BUTTON=By.xpath("//a[@title='Close Window']");
	public static By ELEMENT_SEARCH_FORM_CONTENT = By.xpath("//input[@name='WcmRadio' and @id='content']");
	public static final By ELEMENT_INPUT_NAME_SEARCH_FORM_EDIT_MODE = By.xpath("//input[@id='name' and @type='text']");
	public static final By ELEMENT_CHECK_BOX_WORD_PHRASE_EDIT_MODE = By.xpath("//input[@id='content' and @type='radio']");
	public static final By ELEMENT_INPUT_NAME_SEARCH_WORD_PHRASE_EDIT_MODE = By.xpath("//input[@id='content' and @type='text']");
	public static final By ELEMENT_CONTENT_SEARCH_FORM_TAB = By.xpath("//div[@class='MiddleTab' and text() = 'Content Search Form']");
	//////

	//create page wizard with step 1,2 without layout
	public static void gotoPageEditor_EmptyLayout(String namePage){
		goToPageCreationWinzard();
		type(ELEMENT_NEWPAGE_NAME_TEXTBOX, namePage, false);
		click(ELEMENT_NEWPAGE_NEXT_BUTTON);
		pause(500);
		click(ELEMENT_NEWPAGE_NEXT_BUTTON);
	}

	//create new page without layout 
	public static void createNewPageEmptyLayout(String namePage){	
		gotoPageEditor_EmptyLayout(namePage);
		click(ELEMENT_NEWPAGE_SAVE_BUTTON);
	}

	//create new page has layout - step 1,2
	public static void gotoPageEditor_Layout(String namePage, int numberLayout){
		goToPageCreationWinzard();
		type(ELEMENT_NEWPAGE_NAME_TEXTBOX, namePage, false);
		click(ELEMENT_NEWPAGE_NEXT_BUTTON);
		click(ELEMENT_NEWPAGE_LAYOUT_OPTION);
		switch (numberLayout){
		case 1: click(ELEMENT_NEWPAGE_LAYOUT_COLUMN_PAGE_OPTION);
		break;
		case 2: click(ELEMENT_NEWPAGE_LAYOUT_ROW_PAGE_OPTION);
		break;
		case 3: click(ELEMENT_NEWPAGE_LAYOUT_TAB_PAGE_OPTION);
		break;
		case 4: click(ELEMENT_NEWPAGE_LAYOUT_MIX_PAGE_OPTION);
		break;		
		default: click(ELEMENT_NEWPAGE_LAYOUT_DEFAULT_OPTION);
		break;
		}
		click(ELEMENT_NEWPAGE_NEXT_BUTTON);
	}

	//create new page has layout 
	public static void createNewPageWithLayout(String namePage, int numberLayout){
		gotoPageEditor_Layout(namePage, numberLayout);
		click(ELEMENT_NEWPAGE_SAVE_BUTTON);		
	}


	//Create new page empty layout add contentdetail, choose ContentPath
	public static void createPage_Empty_ContentDetail_ContentPath(String pageName, String contentPath){
		gotoPageEditor_EmptyLayout(pageName);
		pause(500);
		addContentDetailEmptyLayout();
		pause(500);
		selectContentPath(contentPath);
		pause(500);
		click(ELEMENT_NEWPAGE_SAVE_BUTTON);			
	}

	//Create new page has layout, add contentlist, choose clv path
	public static void createPage_ContentList_CLVpath(String pageName, String path, String clv){
		gotoPageEditor_Layout(pageName, 1);
		pause(500);
		addContentList();
		pause(500);
		selectCLVPath(path, clv);
		pause(500);
		click(ELEMENT_NEWPAGE_SAVE_BUTTON);
	}

	//add contentdetail to a page EmptyLayout of portal
	public static void addContentDetailEmptyLayout(){
		click(ELEMENT_MENU_CONTENT_LINK);
		dragAndDropToObject(ELEMENT_ADD_CONTENT_DETAIL_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);	
	}

	//Add "ContentDetail" to page with selected layout
	public static void addContentDetail(){
		click(ELEMENT_MENU_CONTENT_LINK);
		dragAndDropToObject(ELEMENT_ADD_CONTENT_DETAIL_PORTLET,ELEMENT_DROP_TARGET_HAS_LAYOUT);		
	}

	//Add "ContentList" to page EmptyLayout
	public static void addContentListEmptyLayout(){
		click(ELEMENT_MENU_CONTENT_LINK);
		dragAndDropToObject(ELEMENT_ADD_CONTENT_LIST_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);
	}

	//Add "ContentList" to page with selected layout
	public static void addContentList(){
		click(ELEMENT_MENU_CONTENT_LINK);
		dragAndDropToObject(ELEMENT_ADD_CONTENT_LIST_PORTLET,ELEMENT_DROP_TARGET_HAS_LAYOUT);		
	}

	//	//Select "ContentPath" in Edit Mode
	//	public static void selectContentPath(){
	//		actions.moveToElement(waitForAndGetElement(ELEMENT_FRAME_CONTAIN_PORTLET)).build().perform();
	//		click(ELEMENT_EDIT_PORTLET_LINK);
	//		click(ELEMENT_SELECT_CONTENT_PATH_LINK);
	//		click(ELEMENT_SELECT_CONTENT_PATH_GENERAL_LINK);
	//		click(ELEMENT_SELECT_CONTENT_PATH_GENERAL_MANAGED_LINK);
	//		click(ELEMENT_SELECT_CONTENT_PATH_ACME_LINK);
	//		click(ELEMENT_SELECT_CONTENT_PATH_ACME_DOC_LINK);
	//		click(ELEMENT_SELECT_CONTENT_PATH);
	//		click(ELEMENT_SAVE_BUTTON);
	//		click(ELEMENT_CLOSE_BUTTON);
	//	}
	//Select "ContentPath" in edit portlet
	public static void selectContentPath(String pathContent){
		mouseOver(ELEMENT_FRAME_CONTAIN_PORTLET,true);	
		click(ELEMENT_EDIT_PORTLET_LINK);
		click(ELEMENT_SELECT_CONTENT_PATH_LINK);
		selectGroup(pathContent);
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
	}
	/*Select "CLVPath" in Edit Mode
	 * @mode:  content: if select mode "By content"
	 * 		   other value: if select mode "By folder"	
	 */
	public static void selectCLVPath(String path, String clv, String...mode){
		By ELEMENT_SELECT_CLV_PATH = By.xpath("//td/a[text()='" + clv + "']");
		
		mouseOver(ELEMENT_FRAME_CONTAIN_PORTLET, true);
		click(ELEMENT_EDIT_PORTLET_LINK);
		if (mode.length >0){ 
			if (mode[0] == "content")
				click(ELEMENT_RADIO_MODE_CONTENT);
			else 
				click(ELEMENT_RADIO_MODE_FOLDER);
		}
		
		click(ELEMENT_SELECT_CONTENT_PATH_LINK);
		selectGroup(path);
		click(ELEMENT_SELECT_CLV_PATH);
		if (mode.length >0){ 
			if (mode[0] == "content"){
				click(ELEMENT_SAVE_BUTTON);
				waitForElementNotPresent(ELEMENT_SELECT_CLV_PATH);
				}		
		}
		click(ELEMENT_SAVE_BUTTON);
		click(ELEMENT_CLOSE_BUTTON);
	}

	//////
	/*-- Add common functions for Single Content Viewer/Add (SCV)
	 *-- Page Editor 
	 *-- Add a new SCV page and select a content path 
	 *-- @author: VuNA
	 *-- @date: 23/10/2012
	 *--*/

	//Add a news SCV page and add a selected content path to this page
	//Use a default page with Empty layout 
	public static void addSCVPageAndContentFolderPaths(String pageName, String contentPath){
		info("-- Add a content path to SCV page: "+ pageName +" --");
		gotoPageEditor_EmptyLayout(pageName);
		//Drag and drop Content Detail portlet into this page
		addContentDetailEmptyLayout();
		click(ELEMENT_NEWPAGE_SAVE_BUTTON);
		waitForElementNotPresent(ELEMENT_NEWPAGE_SAVE_BUTTON);
		goToEditPageEditor();
		//selectContentPath
		selectContentPathInEditMode(contentPath, false);
		click(By.xpath("//*[@id='UIPageEditor']/div[1]/a[2]"));
	}

	//Select a content path to add to SCV page
	//Use as default: boolean inEditModeWindows = false
	public static void selectContentPathInEditMode(String contentPath, boolean inEditModeWindows){
		info("-- Select the content path: "+ contentPath +"--");
		String ELEMENT_SELECT_CONTENT_FOLDER_PATHS = "//a[@title='${pathName}']";
		String[] pathNames = contentPath.split("/");
		if(inEditModeWindows){
			for(String path : pathNames){
				String pathToSelect = ELEMENT_SELECT_CONTENT_FOLDER_PATHS.replace("${pathName}", path);
				click(pathToSelect);
			}
		}
		else{
			selectContentPath(contentPath);
		}	
	}

	////////

}
