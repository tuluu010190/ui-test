package org.exoplatform.selenium.platform.gatein;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author exo
 * Date 22/01/2015
 * Path: Edit-->Page-->Add Pages
 */
public class PageCreationWizard extends PlatformBase {
	ContentList contList;
	ContentDetail contDetail;
	//Common
	public final By ELEMENT_PAGE_CREATION_WIZARD = By.id("UIPageCreationWizard");
	public final By ELEMENT_PAGE_NEXT_BUTTON=By.xpath("//*[@id='UIPageCreationWizard']//*[text()='Next']");
	public final By ELEMENT_PAGE_ABORT_BUTTON=By.xpath("//*[@id='UIPageCreationWizard']//*[text()='Abort']");
	public final By ELEMENT_WARNING_PAGE_NOT_FOUND=By.xpath("//*[@class='TitleWaring' and text()='Page not found.']");
	final public By ELEMENT_ADDNEWPAGE_BTNNEXT = By.xpath("//*[@class='btn btn-primary' and text()='Next']");
	
	//Step 1
	public final By ELEMENT_PAGE_SETUP_INFO_FORM=By.id("UIWizardPageSetInfo");
	public final By ELEMENT_PAGE_NAME_INPUT=By.id("pageName");
	public final By ELEMENT_PAGE_MODE_CHECKBOX=By.id("switchmode");
	public final By ELEMENT_PAGE_LANGUAGE_SELECT_BOX=By.name("languages");
	public final By ELEMENT_PAGE_DISPLAY_NAME_INPUT=By.id("i18nizedLabel");
	public final By ELEMENT_PAGE_VISIBLE_CHECKBOX=By.id("visible");
	public final By ELEMENT_PAGE_PUBLICATION_DATE_CHECKBOX=By.id("showPublicationDate");
	public final By ELEMENT_PAGE_UP_LEVEL=By.xpath("//*[@class='uiIconUpLevel uiIconLightGray']");
	public final String ELEENT_NODE_NAME="//*[@title='$name']";
	
	//Step 2
	public final By ELEMENT_PAGE_SELECT_LAYOUT_FORM = By.id("UIWizardPageSelectLayoutForm");
	
	//Step 3
	public final By ELEMENT_PAGE_PORTAL_EDITOR=By.id("UIPortalApplication");
	
	//Page Editor left side bar header
	public final By ELEMENT_PAGE_FINISH_BTN = By.xpath("//*[@class='uiIconSave uiIconDarkGray pull-right']");
	public final By ELEMENT_PAGE_ABORT_BTN = By.xpath(".//*[@id='UIPageEditor']//*[@data-original-title='Abort']");
	
	//Application panel
	public final By ELEMENT_APPLICATION_CONTENT_TAB = By.xpath("//*[@title='Content']");
	public final By ELEMENT_APPLICATION_ADMINISTRATION_TAB=By.xpath("//*[@title='Administration']");
	public final By ELEMENT_APPLICATION_CONTENT_DETAIL = By.xpath("//*[@id='Content/SingleContentViewer']");
	public final By ELEMENT_APPLICATION_CONTENT_LIST = By.xpath("//*[@id='Content/ContentListViewerPortlet']");
	public final String ELEMENT_APPLICATION_APPLICATION = ".//*[@id='${name}']";
	public final String ELEMENT_APPLICATION_REMOTE_GADGET = ".//*[@id='UIApplicationList']//*[contains(text(),'${name}')]";
	
	//Layout
	public  final By ELEMENT_PAGEEDITOR_VIEWPAGE = By.xpath("//*[@class='VIEW-PAGE']");
	public final String ELEMENT_PAGEEDITOR_CONTENT=".//*[@class='UIComponentBlock']//*[contains(text(),'${name}')]";
	
	public PageCreationWizard(WebDriver dr){
		driver = dr;
		contList = new ContentList(dr);
		contDetail = new ContentDetail(dr);
	}
	
	/**
	 * Input data in page info page at step 1
	 * @param name
	 * @param isMode
	 * @param lang
	 * @param disName
	 * @param isVis
	 * @param isPub
	 */
	public void inputPageInfoStep1(String name, Boolean isMode, String lang, String disName, Boolean isVis, Boolean isPub){
		info("Input data in page info page at step 1");
		if(name!=null && name!=""){
			info("Input name");
			type(ELEMENT_PAGE_NAME_INPUT,name,true);
		}
		if(isMode!=null){
			info("Input mode");
			if(isMode)
				check(ELEMENT_PAGE_MODE_CHECKBOX,2);
			else
				uncheck(ELEMENT_PAGE_MODE_CHECKBOX,2);
		}
		if(lang!=null && lang!=""){
			info("Input language");
			select(ELEMENT_PAGE_LANGUAGE_SELECT_BOX,lang);
		}
		if(disName!=null && disName!=""){
			info("Input display name");
			type(ELEMENT_PAGE_NAME_INPUT,name,true);
		}
		if(isVis!=null){
			info("Input Visible");
			if(isVis)
				check(ELEMENT_PAGE_VISIBLE_CHECKBOX,2);
			else
				uncheck(ELEMENT_PAGE_VISIBLE_CHECKBOX,2);
		}
		if(isPub!=null){
			info("Input publication date");
			if(isPub)
				check(ELEMENT_PAGE_PUBLICATION_DATE_CHECKBOX,2);
			else
				uncheck(ELEMENT_PAGE_PUBLICATION_DATE_CHECKBOX,2);
		}
	}
	
	/**
	 * Add content in page editor
	 * @param tab
	 * @param element
	 */
	public void addApplication(Object tab, Object element) {
		click(tab);
		Utils.pause(1000);
		dragAndDropToObject(element, ELEMENT_PAGEEDITOR_VIEWPAGE);
	}
	
	/**
	 * Add a Content list to a Page by folder
	 * @param titlePage
	 * @param Description
	 * @param language
	 * @param path
	 * @param folder
	 */
	public void addContentlistByFolder(String path,String folder){
		addApplication(ELEMENT_APPLICATION_CONTENT_TAB,ELEMENT_APPLICATION_CONTENT_LIST);
		click(contList.ELEMENT_CONTENT_LIST_EDIT_BTN);
		contList.selectFolderContent(path,folder);
		click(contList.ELEMENT_CONTENT_LIST_SAVE_BTN);
		click(contList.ELEMENT_CONTENT_LIST_CLOSE_BTN);
		click(ELEMENT_PAGE_FINISH_BTN);
		Utils.pause(2000);
	}
	/**
	 * Add a Content list to a page by content
	 * @param path
	 * @param content
	 */
	public void addContentListByContent(String path,String content){
		addApplication(ELEMENT_APPLICATION_CONTENT_TAB,ELEMENT_APPLICATION_CONTENT_LIST);
		click(contList.ELEMENT_CONTENT_LIST_EDIT_BTN);
		check(contList.ELEMENT_CONTENT_LIST_BY_CONTENT_MODE, 2);
		contList.selectFolderContent(path,content);
		click(contList.ELEMENT_MULTIPLE_CONTENT_POPUP_SAVE_BTN);
		click(contList.ELEMENT_CONTENT_LIST_SAVE_BTN);
		click(contList.ELEMENT_CONTENT_LIST_CLOSE_BTN);
		click(ELEMENT_PAGE_FINISH_BTN);
	}
	/**
	 * Add a Cotent Detail to a page
	 * @param path
	 * @param content
	 */
	public void addContentDetail(String path, String content){
		addApplication(ELEMENT_APPLICATION_CONTENT_TAB,ELEMENT_APPLICATION_CONTENT_DETAIL);
		click(contDetail.ELEMENT_CONTENT_DETAIL_EDIT_BTN);
		contDetail.selectFolderContent(path,content);
		click(contDetail.ELEMENT_CONTENT_DETAIL_SAVE_BTN);
		click(contDetail.ELEMENT_CONTENT_DETAIL_CLOSE_BTN);
		click(ELEMENT_PAGE_FINISH_BTN);
	}
	
}
