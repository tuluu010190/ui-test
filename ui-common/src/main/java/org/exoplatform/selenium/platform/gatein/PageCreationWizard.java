package org.exoplatform.selenium.platform.gatein;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.EditPageWCM;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
/**
 * @author exo
 * Date 22/01/2015
 * Path: Edit-->Page-->Add Pages
 */
public class PageCreationWizard extends PlatformBase {
	
	
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
	public final By ELEMENT_APPLICATION_TAB = By.linkText("Applications");
	public final By ELEMENT_APPLICATION_CONTENT_TAB = By.xpath("//*[@title='Content']");
	public final By ELEMENT_APPLICATION_ADMINISTRATION_TAB=By.xpath("//*[@title='Administration']");
	public final By ELEMENT_APPLICATION_CONTENT_DETAIL = By.xpath("//*[@id='Content/SingleContentViewer']");
	public final By ELEMENT_APPLICATION_CONTENT_LIST = By.xpath("//*[@id='Content/ContentListViewerPortlet']");
	public final String ELEMENT_APPLICATION_APPLICATION = ".//*[@id='${name}']";
	public final String ELEMENT_APPLICATION_REMOTE_GADGET = ".//*[@id='UIApplicationList']//*[contains(text(),'${name}')]";
	
	
	//Container panel
	public final By ELEMENT_CONTAINER_TAB = By.linkText("Containers");
	public final By ELEMENT_SWITCH_VIEW_MODE = By.linkText("Switch View mode");
	
	//Container popup editor
	public final By ELEMENT_CONTAINER_POPUP_TITLE = By.id("title");
	public final String ELEMENT_CONTAINER_TITLE="//*[@class='UIRowContainer']//span[text()='${title}']";
	public final By ELEMENT_CONTAINER_POPUP_WIDTH = By.id("width");
	public final By ELEMENT_CONTAINER_POPUP_HEIGHT = By.id("height");

	
	//Layout
	public  final By ELEMENT_PAGEEDITOR_VIEWPAGE = By.xpath("//*[@class='VIEW-PAGE']");
	public final String ELEMENT_PAGEEDITOR_CONTENT=".//*[@class='UIComponentBlock']//*[contains(text(),'${name}')]";
	public final By ELEMENT_PAGEEDITOR_FINISHBTN = By.xpath("//*[contains(@class,'uiIconSave')]");
	public final By ELEMENT_SWITCH_VIEW_MODE_NAME_APPLICATION_CLASS = By.xpath(".//*[contains(@class,'portletName')]");
	
	public final String ELEMENT_APPLICATION_IN_LAYOUT_PAGE = ".//*[contains(@class,'LAYOUT-PORTLET')]//*[contains(text(),'${name}')]";
	public final String ELEMENT_APPLICATION_EDIT_ICON = "//span[contains(text(),'${name}')]/../../../..//*[contains(@class,'uiIconEdit')]";
	public final String ELEMENT_APPLICATION_DELETE_ICON = "//span[contains(text(),'${name}')]/../../../..//*[contains(@class,'uiIconTrash')]";
	
	public final By ELEMENT_DROP_SOURCE_HAS_LAYOUT = By.xpath("//div[@class='UIRowContainer EmptyContainer']");
	public final String ELEMENT_DROP_SOURCE_HAS_LAYOUT_BY_NAME ="//span[contains(text(),'${name}')]/../../../..//*[contains(@class,'UIRowContainer')]";
	public final By ELEMENT_EDIT_CONTAINER_ICON = By.xpath(".//*[@data-original-title='Edit Container']//*[contains(@class,'uiIconEdit')]");
	public final By ELEMENT_DELETE_CONTAINER_ICON = By.xpath(".//*[@data-original-title='Edit Container']/..//*[contains(@class,'uiIconTrash')]");
	public final String ELEMENT_EDIT_CONTAINER_ICON_BY_NAME = "//span[contains(text(),'${name}')]/..//*[contains(@class,'uiIconEdit')]";
	public final String ELEMENT_DELETE_CONTAINER_ICON_BY_NAME = "//span[contains(text(),'${name}')]/..//*[contains(@class,'uiIconTrash')]";
	
	public final By ELEMENT_CONTAINER_PRECEDING_PORTLET = By.xpath("//*[contains(@class,'UIPortlet')]/preceding-sibling::*[contains(@class,'UIContainer')]");
	public final By ELEMENT_CONTAINER_FOLLOWING_PORTLET= By.xpath("//*[contains(@class,'UIPortlet')]/following-sibling::*[contains(@class,'UIContainer')]");
	public final By ELEMENT_CONTAINER_HOLDER_MOVE = By.xpath(".//*[@class='UIRowContainer EmptyContainer']/../../../..//*[contains(@class,'uiIconDragDrop')]");
	public final By ELEMENT_PORTLET = By.xpath(".//*[contains(@class,'UIPortlet')]");
	public final String ELEMENT_APPLICATION_HOLDER_MOVE="//span[contains(text(),'${name}')]/..//*[contains(@class,'uiIconDragDrop')]";
	public final String ELEMENT_APPLICATION_PRECEDING_PORTLET = "//*[contains(@class,'LAYOUT-PORTLET')]//*[contains(text(),'${app1}')]/../../../preceding-sibling::*[contains(@class,'UIPortlet')]//*[contains(text(),'${app2}')]";
	public final String ELEMENT_APPLICATION_FOLLOWING_PORTLET= "//*[contains(@class,'LAYOUT-PORTLET')]//*[contains(text(),'${app1}')]/../../../following-sibling::*[contains(@class,'UIPortlet')]//*[contains(text(),'${app2}')]";
	//Application popup
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_TAB = By.xpath(".//*[@id='tab-UIPortletForm']//*[contains(@data-target,'PortletSetting')]");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_TITLE = By.id("title");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_WIDTH = By.id("width");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_HEIGHT = By.id("height");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_SHOWINFOBAR = By.id("showInfoBar");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_SHOWPORTLET_MODE = By.id("showPortletMode");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_SHOWWINDOW_STATE = By.id("showWindowState");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_DESCRIPTION = By.id("description");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_SAVE = By.id("Save");
	public final By ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_CANCEL = By.id("Close");
	
	ContentList contList;
	ContentDetail contDetail;
	ManageAlert magAlert;
	Button but;
	EditPageWCM editPage;
	
	public PageCreationWizard(WebDriver dr){
		driver = dr;
		contList = new ContentList(dr);
		contDetail = new ContentDetail(dr);
		magAlert = new ManageAlert(dr);
		but = new Button(dr);
		editPage = new EditPageWCM(dr);
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
			type(ELEMENT_PAGE_DISPLAY_NAME_INPUT,name,true);
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
		dragAndDropToObject(element,ELEMENT_PAGEEDITOR_VIEWPAGE);
	}
	/**
	 * Add an application to a layout
	 * @param nameApp
	 * @param appLocator
	 * @param layoutLocator
	 */
	public void addApp(String nameApp,Object appLocator,Object layoutLocator){
		info("Add an application to the layout");
		click(ELEMENT_APPLICATION_TAB);
		Utils.pause(1000);
		dragAndDropToObject(appLocator,layoutLocator);
		info("Verify that the application is shown in the layout");
		waitForAndGetElement(ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",nameApp),3000,0);
		info("The application is shown in the layout page");
		Utils.pause(2000);
		saveChangesPageEditor();
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
	/**
	 * Create a simple page
	 * @param title
	 * @param description
	 */
	public void addAPageSimple(String title,String description){
		info("Input the title and descript");
		inputPageInfoStep1(title, true, "English",description, true,false);
		info("click on Next button of step 1");
		click(ELEMENT_ADDNEWPAGE_BTNNEXT);
		info("click on Next button of step 2");
		click(ELEMENT_ADDNEWPAGE_BTNNEXT);
		info("Save all changes");
		click(ELEMENT_PAGE_FINISH_BTN);
		Utils.pause(2000);
	}
	/**
	 * Add a Container
	 * @param numRow  this name of containers as: oneRow,twoRow...
	 * @param targetPosition
	 */
	public void addContainer(String numRow){
		info("Add container");
		info("Add new container: " + "oneRow");
		try{
			click(ELEMENT_CONTAINER_TAB);
		}catch(org.openqa.selenium.UnhandledAlertException e){
			magAlert.waitForConfirmation("The target block ID to update is not found : EmptyAjaxBlock",40000);
			clearCache();
		}
		click(By.linkText("Rows Layout"));
		dragAndDropToObject(By.id(numRow), By.className("UIRowContainer"));
		Utils.pause(2000);
		saveChangesPageEditor();
		info("the container is added");
	}
	/**
	 * Edit a container
	 * @param newTitle
	 * @param width
	 * @param height
	 */
	public void editContainer(String oldTitle,String newTitle,String width, String height){
		info("Edit container");
		click(ELEMENT_SWITCH_VIEW_MODE);
		if(!oldTitle.isEmpty())
			mouseOver(ELEMENT_DROP_SOURCE_HAS_LAYOUT_BY_NAME.replace("${name}",oldTitle),true);
		else
		mouseOver(ELEMENT_DROP_SOURCE_HAS_LAYOUT, true);
		Utils.pause(3000);
		if(!oldTitle.isEmpty())
		click(ELEMENT_EDIT_CONTAINER_ICON_BY_NAME.replace("${name}", oldTitle));
		else
			click(ELEMENT_EDIT_CONTAINER_ICON);
		if(!newTitle.isEmpty())
		    type(ELEMENT_CONTAINER_POPUP_TITLE, newTitle, true);
		if(!width.isEmpty())
			type(ELEMENT_CONTAINER_POPUP_WIDTH, newTitle, true);
		if(!height.isEmpty())
			type(ELEMENT_CONTAINER_POPUP_HEIGHT, newTitle, true);
		but.save();
		mouseOver(ELEMENT_DROP_SOURCE_HAS_LAYOUT, true);
		waitForAndGetElement(ELEMENT_CONTAINER_TITLE.replace("${title}",newTitle));
		saveChangesPageEditor();
		info("the container is edited");
	}

	/**
	 * Move a container to new place in layout
	 * 
	 * @param title
	 *            is the name of container that will be dragged and dropped
	 * @param sourceLocator
	 *            is the locator of the container that will be moved up or down
	 *            targetLocator
	 * @param targetLocator
	 *            is the locator of the portlet or the container that will be
	 *            replaced position by sourceLocator
	 * @param heightTarget
	 *            is height size of the portlet or the container that will be
	 *            replaced position by sourceLocator
	 */
	public void moveContainer(String title,Object sourceLocator,Object targetLocator,int heightTarget){
		info("Move container to new place");
		try{
			click(ELEMENT_CONTAINER_TAB);
		}catch(org.openqa.selenium.UnhandledAlertException e){
			magAlert.waitForConfirmation("The target block ID to update is not found : EmptyAjaxBlock",40000);
			clearCache();
		}
		if (!title.isEmpty()) {
			mouseOver(ELEMENT_DROP_SOURCE_HAS_LAYOUT_BY_NAME.replace("${name}",
					title), true);
			Utils.pause(3000);
			
		} else {
			mouseOver(ELEMENT_DROP_SOURCE_HAS_LAYOUT, true);
			Utils.pause(3000);
		}
		
		WebElement elSource = waitForAndGetElement(sourceLocator,2000,0);
		WebElement elTarget = waitForAndGetElement(targetLocator,2000,0);
		
		info("Get the size of target");
		Dimension size = elTarget.getSize();
		
		Actions builder = new Actions(this.driver);
		info("Hold the source");
		builder.clickAndHold(elSource).build().perform();
		info("Move the mouse to the middle of the portlet");
		Action actionMove = builder.moveToElement(elTarget).build();
		actionMove.perform();
		info("Move the mouse under the portlet");
		Action actionMove1 = builder.moveByOffset(-(size.width/2),-(size.height/2)+heightTarget).build();
		actionMove1.perform();
		info("Drop the source");
		Utils.pause(3000);
		Action actiondrop = builder.release().build();
		actiondrop.perform();
		Utils.pause(2000);
		
		saveChangesPageEditor();
		info("the container is moved succefully");
	}
	/**
	 * Check the positions of containers or portlets before and after changed their position in the layout
	 * @param positionFirst is the position before changed
	 * @param positionEnd   is the position after changed
	 */
	public void checkPositions(Object positionFirst, Object positionEnd){
		info("Verify that positions of element is changed");
		waitForElementNotPresent(positionFirst,2000,0);
		waitForAndGetElement(positionEnd,2000,0);
		saveChangesPageEditor();
	}
	/**
	 * Delete a contain in the layout
	 * @param name
	 */
	public void deleteContainer(String name){
		info("Delete the container");
		try{
			click(ELEMENT_CONTAINER_TAB);
		}catch(org.openqa.selenium.UnhandledAlertException e){
			magAlert.waitForConfirmation("The target block ID to update is not found : EmptyAjaxBlock",40000);
			clearCache();
		}
		if(!name.isEmpty()){
			mouseOver(ELEMENT_DROP_SOURCE_HAS_LAYOUT_BY_NAME.replace("${name}",
					name), true);
			Utils.pause(3000);
			click(ELEMENT_DELETE_CONTAINER_ICON_BY_NAME.replace("${name}",name));
			magAlert.acceptAlert();
			Utils.pause(2000);
			waitForElementNotPresent(ELEMENT_DELETE_CONTAINER_ICON_BY_NAME.replace("${name}",name));
		}
		saveChangesPageEditor();
		info("the container is deleted");
	}
    /**
     * Edit an application with changes about title, width and height
     * @param oldTitle
     * @param newTitle
     * @param width
     * @param height
     */
	public void editApplication(String oldTitle,String newTitle,String width,String height) {
		// TODO Auto-generated method stub
		info("Edit application");
		mouseOver(ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",oldTitle),true);
		click(ELEMENT_APPLICATION_EDIT_ICON.replace("${name}",oldTitle));
		click(ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_TAB);
		if(!newTitle.isEmpty())
			type(ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_TITLE,newTitle,true);
		if(!width.isEmpty())
			type(ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_WIDTH,width,true);
		if(!height.isEmpty())
			type(ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_HEIGHT,height,true);
		Utils.pause(2000);
	}
	
	/**
	 * Save and close application popup after finishing editing
	 * Save and close page editor
	 */
	public void saveChangesApplication(){
		info("Save all changes of an application");
		click(ELEMENT_APPLICATION_EDIT_POPUP_PORTLET_SAVE);
		Utils.pause(2000);
		
	}
	/**
	 * Save all changes of page editor
	 */
	public void saveChangesPageEditor(){
		info("Save change Page Editor");
		click(ELEMENT_PAGEEDITOR_FINISHBTN);
		waitForElementNotPresent(ELEMENT_PAGEEDITOR_FINISHBTN, 60000);
		Utils.pause(2000);
	}
	/**
	 * Move an application to new place
	 * @param titleSource is the title of applicattion source that will be moved to new place
	 * @param titleTarget is the title of application target that application source will be followed
	 * @param heightTarget is the height of application target
	 */
	public void moveApplication(String titleSource,String titleTarget,int heightTarget){
		info("Move an application to new place");
			click(ELEMENT_APPLICATION_TAB);
		if (!titleSource.isEmpty()) {
			mouseOver(ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",titleSource),true);
			Utils.pause(3000);
		} 
		WebElement elSource = waitForAndGetElement(ELEMENT_APPLICATION_HOLDER_MOVE.replace("${name}",titleSource),2000,0);
		WebElement elTarget = waitForAndGetElement(ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",titleTarget),2000,0);
		
		info("Get the size of target");
		Dimension size = elTarget.getSize();
		
		Actions builder = new Actions(this.driver);
		info("Hold the source");
		builder.clickAndHold(elSource).build().perform();
		info("Move the mouse to the middle of the portlet");
		Action actionMove = builder.moveToElement(elTarget).build();
		actionMove.perform();
		info("Move the mouse under the portlet");
		Action actionMove1 = builder.moveByOffset(-(size.width/2),-(size.height/2)+heightTarget).build();
		actionMove1.perform();
		info("Drop the source");
		Utils.pause(3000);
		Action actiondrop = builder.release().build();
		actiondrop.perform();
		Utils.pause(2000);
		
		saveChangesPageEditor();
		info("the application is moved succefully");
	}
	/**
	 * Delete an application
	 * @param name
	 */
	public void deleteApplication(String name){
		info("Delete the application");
		click(ELEMENT_APPLICATION_TAB);
		if(!name.isEmpty()){
			mouseOver(ELEMENT_APPLICATION_IN_LAYOUT_PAGE.replace("${name}",name),true);
			Utils.pause(3000);
			click(ELEMENT_APPLICATION_DELETE_ICON.replace("${name}",name));
			magAlert.acceptAlert();
			Utils.pause(2000);
			waitForElementNotPresent(ELEMENT_APPLICATION_DELETE_ICON.replace("${name}",name));
		}
		saveChangesPageEditor();
		info("the container is deleted");
	}
	/**
	 * Change to Switch view mode
	 * @param verify
	 */
	public void switchViewMode(boolean... verify){
		info("Click on Switch view mode button");
		click(ELEMENT_SWITCH_VIEW_MODE);
		if(verify.length>0)
		waitForAndGetElement(ELEMENT_SWITCH_VIEW_MODE_NAME_APPLICATION_CLASS,2000,0);
	}
}
