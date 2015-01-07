package org.exoplatform.selenium.platform.administration;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentAdministrationManagement extends PlatformBase{
	ManageAlert alert ;
	public ContentAdministrationManagement(WebDriver dr){
		driver = dr;
		alert= new ManageAlert(driver);
	}

	public By ELEMENT_ADVANCED_CATEGORIES_ECM_FUNCTIONS =By.xpath("//*[@class='ecmAdminPanel pull-left']//a[contains(text(),'Advanced')]");
	public By ELEMENT_EXPLORER_CATEGORIES_ECM_FUNCTIONS =By.xpath("//*[@class='ecmAdminPanel pull-left']//a[contains(text(),'Explorer')]");
	public By ELEMENT_TEMPLATE_CATEGORIES_ECM_FUNCTIONS =By.xpath("//*[@class='ecmAdminPanel pull-left']//a[contains(text(),'Templates')]");
	public By ELEMENT_RESPONSITORY_CATEGORIES_ECM_FUNCTIONS=By.xpath("//*[@class='ecmAdminPanel pull-left']//a[contains(text(),'Repository')]");

	public By ELEMENT_ECMS_FUNCTIONS_DRIVES =By.xpath("//*[@class='uiIconEcmsDriveManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_ACTIONS =By.xpath("//*[@class='uiIconEcmsActionManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_SCRIPTS =By.xpath("//*[@class='uiIconEcmsScriptManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_QUERIES =By.xpath("//*[@class='uiIconEcmsQueriesManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_CATEGORIES =By.xpath("//*[@class='uiIconEcmsTaxonomyManagerTrees uiIconEcmsLightGray']");
	
	// function Advanced, ACTIONS
	public By ELEMENT_ADD_ACTION_TYPE = By.xpath("//*[@id='UIActionManager']//*[@class='btn']");
	public By ELEMENT_ECM_ACTION_NAME_FORM = By.xpath("//*[@class='uiForm UIActionTypeForm']//*[@id='name']");
	public By ELEMENT_ECM_ACTION_SCRIPT_FORM = By.xpath("//*[@class='uiForm UIActionTypeForm']//*[@class='selectbox']");
	public By ELEMENT_ECM_ACTION_VARIABLES_FORM = By.xpath("//*[@class='uiForm UIActionTypeForm']//*[@id='variables0']");
	public By ELEMENT_ECM_ACTION_SAVE_FORM = By.xpath("//*[@id='UIActionTypeForm']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_ACTION_LIST = "//*[@id='UIActionTypeList']//div[contains(text(),'{$name}')]";
	public String ELEMENT_ECM_ACTION_DELETE_LIST ="//*[@id='UIActionTypeList']//div[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	public String ELEMENT_ECM_ACTION_EDIT_LIST ="//*[@id='UIActionTypeList']//div[contains(text(),'{$name}')]/../..//*[@class='uiIconEdit uiIconLightGray']";
	
	//function Advanced, Scripts
	public By ELEMENT_ECM_ADVANCED_SCRIPT_ADD_SCRIPT = By.xpath("//*[@id='UIScriptList']//*[contains(text(),'Add Script')]");
	public By ELEMENT_ECM_ADVANCED_SCRIPT_NAME_FORM = By.xpath("//*[@id='scriptLabel']");
	public By ELEMENT_ECM_ADVANCED_SCRIPT_CONTENT_FORM = By.xpath("//*[@id='scriptContent']");
	public By ELEMENT_ECM_ADVANCED_SCRIPT_SCRIPT_FORM = By.xpath(".//*[@id='scriptName']");
	public By ELEMENT_ECM_ADVANCED_SCRIPT_SAVE_FORM = By.xpath("//*[@id='ScriptContainerPopup']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_ADVANCED_SCRIPT_EDIT_LIST = "//*[contains(text(),'{$name}')]/../..//*[@title='Edit']";
	public String ELEMENT_ECM_ADVANCED_SCRIPT_DELETE_LIST = ".//*[contains(text(),'{$name}')]/../..//*[@title='Delete']";
	public String ELEMENT_ECM_ADVANCED_SCRIPT_LIST = ".//*[@id='UIScriptList']//*[contains(text(),'{$name}')]";
	
	//function Advanced, queries
	public By ELEMENT_ECM_ADVANCED_QUERIES_ADD_QUERIES = By.xpath("//*[@id='UIQueriesList']//*[contains(text(),'Add Query')]");
	public By ELEMENT_ECM_ADVANCED_QUERIES_NAME_FORM = By.xpath(".//*[@id='UIQueriesForm']//*[@id='name']");
	public By ELEMENT_ECM_ADVANCED_QUERIES_QUERY_TYPE_FORM = By.xpath(".//*[@class='selectbox' and @name='type']");
	public By ELEMENT_ECM_ADVANCED_QUERIES_STATEMENT_FORM = By.xpath(".//*[@id='statement']");
	public By ELEMENT_ECM_ADVANCED_QUERIES_PERMISSION_FORM = By.xpath(".//*[@class='uiIconAddPermission uiIconLightGray']");
	public By ELEMENT_PERMISSION_ANY = By.xpath(".//*[@class='uiIconAddAnyPermission uiIconLightGray']");
	public By ELEMENT_ECM_ADVANCED_QUERIES_SAVE_FORM = By.xpath(".//*[@id='UIQueriesForm']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_ADVANCED_QUERIES_EDIT_BUTTON = "//*[contains(text(),'{$name}')]/../..//*[@class='uiIconEditInfo uiIconLightGray']";
	public String ELEMENT_ECM_ADVANCED_QUERIES_TYPE_LIST = "//*[contains(text(),'{$name}')]/../../td[2]//*[contains(text(),'{$type}')]";
	public String ELEMENT_ECM_ADVANCED_QUERIES_DELETE_BUTTON = "//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	public String ELEMENT_ECM_ADVANCED_QUERIES_LIST = ".//*[@id='UIQueriesList']//*[contains(text(),'{$name}')]";
	
	// functions Advanced, categories
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_ADD_CATEGORIES = By.xpath(".//*[@id='UITaxonomyTreeList']//*[contains(text(),'Add Category Tree')]");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_NAME_FORM = By.xpath(".//*[@id='TaxoTreeName']");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_NEXT_1STPAGE_FORM = By.xpath(".//*[@id='TaxonomyTreeMainForm']//*[contains(text(),'Next')]");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_NEXT_2NDPAGE_FORM = By.xpath(".//*[@id='UIPermissionTreeForm']//*[contains(text(),'Next')]");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_NEXT_3RDPAGE_FORM = By.xpath(".//*[@id='UIActionTaxonomyManager']//*[contains(text(),'Next')]");
	
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_PREVIOUS_2NDPAGE = By.xpath("//*[@id='UIPermissionTreeForm']//*[contains(text(),'Previous')]");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_PREVIOUS_3RDPAGE = By.xpath("//*[@id='UIActionTaxonomyManager']//*[contains(text(),'Previous')]");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_PREVIOUS_4THPAGE = By.xpath("//*[@id='UITaxonomyTreeCreateChild']//*[contains(text(),'Previous')]");
	
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_NAME_ACTION_FORM = By.xpath(".//*[@id='actionName']");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_LIFECYCLE_FORM = By.xpath(".//*[@id='UIActionForm']//*[@class='selectbox']");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_OPEN_TARGETPATH_ACTION_FORM = By.xpath(".//*[@id='UIActionForm']//*[@id='targetPath']/../a[1]");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_ROOT_NODE_ACTION_FORM = By.xpath(".//*[@class='uiIconAddRootNode uiIconLightGray']");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_SAVE_FORM = By.xpath("//*[@id='UIActionTaxonomyManager']//*[contains(text(),'Save')]");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_CLOSE_FORM = By.xpath("//*[@class='uiTaxonomyTreeWizard']//*[contains(text(),'Close')]");
	public String ELEMENT_ECM_ADVANCED_CATEGORIES_EDIT_FORM =".//*[contains(text(),'{$name}')]/../..//*[@class='uiIconEditInfo uiIconLightGray']";
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_WORKSPACE_SELECT_FORM = By.xpath("//*[@id='TaxonomyTreeMainForm']//*[@name='TaxoTreeWorkspace']");
	public By ELEMENT_ECM_ADVANCED_CATEGORIES_ADD_HOME_PATH_FORM = By.xpath(".//*[@id='TaxonomyTreeMainForm']//*[@class='uiIconAddPath uiIconLightGray']");
	public String ELEMENT_ECM_ADVANCED_CATEGORIES_WORKSPACE_LIST = ".//*[contains(text(),'{$name}')]/../../td[2]//*[contains(text(),'{$workspace}')]";
	public String ELEMENT_ECM_ADVANCED_CATEGORIES_DELETE =".//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";

	public By ELEMENT_ECMS_FUNCTIONS_VIEWS =By.xpath("//*[@class='uiIconEcmsViewManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_TAGS =By.xpath("//*[@class='uiIconEcmsFolksonomyManager uiIconEcmsLightGray']");
	
	
	// Explorer, drives
	public By ELEMENT_ECM_EXPLORER_DRIVES_ADD_DRIVES = By.xpath("//*[@id='UIDriveList']//*[contains(text(),'Add Drive')]");
	public By ELEMENT_ECM_EXPLORER_NAME_DRIVES_FORM = By.xpath("//*[@id='name']");
	public By ELEMENT_ECM_EXPLORER_APPLY_VIEWS_FORM = By.xpath("//a[contains(text(),'Apply Views')]");
	public By ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ADMIN = By.xpath("//*[@class='UIFormInputSet']//*[@id='Admin']");
	public By ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_CATEGORIES = By.xpath("//*[@class='UIFormInputSet']//*[@id='Categories']");
	public By ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ICONS = By.xpath("//*[@class='UIFormInputSet']//*[@id='Icons']");
	public By ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_LIST = By.xpath("//*[@class='UIFormInputSet']//*[@id='List']");
	public By ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_WEB = By.xpath("//*[@class='UIFormInputSet']//*[@id='Web']");
	public By ELEMENT_ECM_EXPLORER_DRIVES_SAVE_FORM = By.xpath("//*[@id='UIDriveForm']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_EXPLORER_DRIVES_EDIT_LIST = "//*[@id='UIDriveList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconEditInfo uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_DRIVES_DELETE_LIST = "//*[@id='UIDriveList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_DRIVES_VIEW_OF_VIEWS_LIST = "//*[@id='UIDriveList']//*[contains(text(),'{$name}')]/../..//*[contains(text(),'{$view}')]";

	// Explorer, views
	public By ELEMENT_ECM_EXPLORER_VIEWS_ADD_VIEWS = By.xpath("//*[@class='UIViewList']//*[contains(text(),'Add View')]");
	public By ELEMENT_ECM_EXPLORER_NAME_VIEW_FORM = By.xpath("//*[@id='viewName']");
	public By ELEMENT_ECM_EXPLORER_GO_TO_ACTION_FORM = By.xpath("//*[@id='UIViewFormTabPane']//*[contains(text(),'Action')]");
	public By ELEMENT_ECM_EXPLORER_ADD_ACTION_VIEW_FORM = By.xpath("//*[@id='UITabContainer']//*[contains(text(),'Add')]");
	public String ELEMENT_ECM_EXPLORER_CHOOSE_TAB_CATEGORY_VIEW_FORM ="//*[contains(text(),'{$tab}')and @class='control-label']/../div/span/input";
	public By ELEMENT_ECM_EXPLORE_TAB_NAME_VIEW_FORM = By.xpath("//*[@id='tabName']");
	public By ELEMENT_ECM_EXPLORE_SAVE_TAB_VIEW_FORM = By.xpath("//*[@id='UITabForm']//*[contains(text(),'Save')]");
	public By ELEMENT_ECM_EXPLORER_GO_TO_PERMISSION_FORM = By.xpath("//*[@id='UIViewFormTabPane']//*[contains(text(),'Permission')]");
	public By ELEMENT_ECM_EXPLORER_ADD_PERMISSION_FORM = By.xpath("//*[@class='permission']//*[contains(text(),'Add')]");
	public By ELEMENT_ECM_EXPLORER_USER_PERMISSION_ADD = By.xpath("//*[@id='UIViewPermissionForm']//*[@class='uiIconSelectUser uiIconLightGray']");
	public String ELEMENT_ECM_EXPLORER_SELECT_USER_LIST_PERMISSION = "//*[@id='UIListUsers']//*[@class='text' and contains(text(),'{$user}')]/../../td[5]/a";
	public By ELEMENT_ECM_EXPLORER_SAVE_FORM_ADD_VIEW = By.xpath("//*[@id='UIViewFormTabPane']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_EXPLORER_DELETE_PERMISSION_USER ="//*[@id='UIViewPermissionList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_VIEW_EDIT_LIST = "//*[@id='UIViewList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconEditInfo uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_VIEW_DELETE_LIST = "//*[@id='UIViewList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_VIEW_PERMISSIONS_LIST ="//*[@id='UIViewList']//*[contains(text(),'{$name}')]/../..//*[contains(text(),'{$permission}')]";
	public String ELEMENT_ECM_EXPLORER_VIEW_SHOW_A_VIEW_LIST ="//*[@id='UIViewList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconView uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_NAME_VIEW_SHOW_VIEW = "//*[@id='viewName' and @value='{$name}']";
	public String ELEMENT_ECM_EXPLORER_TAB_ICONS_LIST_SHOW_VIEW ="//*[@id='UITabList']//*[contains(text(),'{$tab}')]";
	public By ELEMENT_ECM_EXPLORER_CLOSE_VIEW_MODE = By.xpath(".//*[@id='UIViewFormTabPane']//*[contains(text(),'Close')]");		
			
	// explorer, tags
	public By ELEMENT_ECM_EXPLORER_TAGS_ADD_STYLE_BUTTON = By.xpath("//*[@id='UITagManager']//*[contains(text(),'Add Style')]");
	public By ELEMENT_ECM_EXPLORER_TAGS_ADD_NAME_FORM = By.xpath("//*[@id='styleName']");
	public By ELEMENT_ECM_EXPLORER_TAGS_NUMBER_OCCURENCE_FORM = By.xpath("//*[@id='documentRange']");
	public By ELEMENT_ECM_EXPLORER_TAGS_HTML_STYLE_FORM = By.xpath("//*[@id='styleHTML']");
	public By ELEMENT_ECM_EXPLORER_TAGS_UPDATE_FORM = By.xpath("//*[@id='UITagStyleForm']//*[contains(text(),'Update')]");
	public String ELEMENT_ECM_EXPLORER_TAGS_EDIT_LIST = "//*[@id='UITagManager']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconEdit uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_TAGS_DELETE_LIST = "//*[@id='UITagManager']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconRemove uiIconLightGray']";
	public String ELEMENT_ECM_EXPLORER_TAGS_LIST_CHECK_HTML_CONTENT = "//*[@id='UITagManager']//*[contains(text(),'{$name}')]/../..//*[contains(text(),'{$html}')]";
	
	//common element
	public By ELEMENT_ECM_COMMON_ADD_PERMISSION_BUTTON = By.xpath(".//*[@class='uiIconAddPermission uiIconLightGray']");
	public By ELEMENT_ECM_COMMON_ANY_PERMISSION = By.xpath("//*[@class='uiIconAddAnyPermission uiIconLightGray']");
    
	/**
	 * Select a function as: Explorer, Advanced, Template and Repositoty
	 */
	public enum mainEcmFunctions{
		EXPLORER,ADVANCED,TEMPLATES,REPOSITORY;
	}
	
	/**
	 * Select a subfunction as Documents, List, Metadata, Drives,
	 * Tags, NameSpaces,Nodestypes,Locks, Categories, Queries, Scripts
	 * Actions
	 *
	 */
	public enum specificEcmFunctions{
		DOCUMENTS,LIST,METADATA,VIEW,DRIVES,TAGS,NAMESPACES,NODESTYPES,LOCKS,CATEGORIES,QUERIES,SCRIPTS,ACTIONS;
	}

	/**
	 * Go to Explorer function
	 * @param main
	 */
	public void goToSpecificMainFunctions(mainEcmFunctions main){
		switch(main){
		case EXPLORER :
			click(ELEMENT_EXPLORER_CATEGORIES_ECM_FUNCTIONS);
			break;
		case ADVANCED:
			click (ELEMENT_ADVANCED_CATEGORIES_ECM_FUNCTIONS);
			break;
		case TEMPLATES:
			click (ELEMENT_TEMPLATE_CATEGORIES_ECM_FUNCTIONS);
			break;
		case REPOSITORY:
			click (ELEMENT_RESPONSITORY_CATEGORIES_ECM_FUNCTIONS);
			break;
		}
	}
	
	/**
	 * Select a sub function in Advance function
	 * @param spec
	 */
	public void goToSpecificFunctions(specificEcmFunctions spec){
		switch(spec){
		case ACTIONS :
			click(ELEMENT_ECMS_FUNCTIONS_ACTIONS);
			break;
		case SCRIPTS :
			click(ELEMENT_ECMS_FUNCTIONS_SCRIPTS);
			break;
		case QUERIES :
			click(ELEMENT_ECMS_FUNCTIONS_QUERIES);
			break;
		case CATEGORIES :
			click(ELEMENT_ECMS_FUNCTIONS_CATEGORIES);
			break;
		case DRIVES :
			click(ELEMENT_ECMS_FUNCTIONS_DRIVES);
			break;
		case VIEW :
			click(ELEMENT_ECMS_FUNCTIONS_VIEWS);
			break;
		case TAGS :
			click(ELEMENT_ECMS_FUNCTIONS_TAGS);
			break;
		}
	}
    
	/**
	 * Add a new View
	 * @param name
	 * @param tabName
	 * @param tab
	 * @param userNamePermission
	 */
	public void addView(String name,String tabName,String[] tab, String userNamePermission){
		click(ELEMENT_ECM_EXPLORER_VIEWS_ADD_VIEWS);
		type(ELEMENT_ECM_EXPLORER_NAME_VIEW_FORM,name,true);
		click(ELEMENT_ECM_EXPLORER_GO_TO_ACTION_FORM);
		click(ELEMENT_ECM_EXPLORER_ADD_ACTION_VIEW_FORM);
		type(ELEMENT_ECM_EXPLORE_TAB_NAME_VIEW_FORM,tabName,true);
		for(String arrayElement : tab ){
			check(By.xpath(ELEMENT_ECM_EXPLORER_CHOOSE_TAB_CATEGORY_VIEW_FORM.replace("{$tab}",arrayElement)),2);
		}
		click(ELEMENT_ECM_EXPLORE_SAVE_TAB_VIEW_FORM);
		click(ELEMENT_ECM_EXPLORER_GO_TO_PERMISSION_FORM);
		click(ELEMENT_ECM_EXPLORER_USER_PERMISSION_ADD);
		click(By.xpath(ELEMENT_ECM_EXPLORER_SELECT_USER_LIST_PERMISSION.replace("{$user}",userNamePermission)));
		click(ELEMENT_ECM_EXPLORER_ADD_PERMISSION_FORM);
		click(ELEMENT_ECM_EXPLORER_SAVE_FORM_ADD_VIEW);
	}

	/**
	 * Edit a view with Permission User
	 * @param viewName
	 * @param oldName
	 * @param newName
	 */
	public void editViewPermissionUser(String viewName, String oldName, String newName){
		click(By.xpath(ELEMENT_ECM_EXPLORER_VIEW_EDIT_LIST.replace("{$name}",viewName)));
		click(ELEMENT_ECM_EXPLORER_GO_TO_PERMISSION_FORM);
		click(ELEMENT_ECM_EXPLORER_USER_PERMISSION_ADD);
		click(By.xpath(ELEMENT_ECM_EXPLORER_SELECT_USER_LIST_PERMISSION.replace("{$user}",newName)));
		click(ELEMENT_ECM_EXPLORER_ADD_PERMISSION_FORM);
		click(By.xpath(ELEMENT_ECM_EXPLORER_DELETE_PERMISSION_USER.replace("{$name}",oldName)));
		alert.acceptAlert();
		click(ELEMENT_ECM_EXPLORER_SAVE_FORM_ADD_VIEW);
	}
	/**
	 * Delete a View
	 * @param viewName
	 */
	public void deleteView(String viewName){
		click(By.xpath(ELEMENT_ECM_EXPLORER_VIEW_DELETE_LIST.replace("{$name}",viewName)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_EXPLORER_VIEW_EDIT_LIST.replace("{$name}",viewName)));
	}
	/**
	 * Add a new drive
	 * @param name
	 * @param permission
	 * @param applyViews
	 */
	public void addDrives(String name, String permission,String[] applyViews){
		click(ELEMENT_ECM_EXPLORER_DRIVES_ADD_DRIVES);
		type(ELEMENT_ECM_EXPLORER_NAME_DRIVES_FORM,name,true);

		click(ELEMENT_ECM_COMMON_ADD_PERMISSION_BUTTON);
		if(permission=="any")
			click(ELEMENT_ECM_COMMON_ANY_PERMISSION);
		click(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_FORM);
		for(String arrayElement : applyViews ){
			switch(arrayElement){
			case "Admin" :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ADMIN,2);
				break;
			case "Categories":
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_CATEGORIES,2);
				break;
			case "Icons":
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ICONS,2);
				break;
			case "List" :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_LIST,2);
				break;
			case "Web" :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_WEB,2);
				break;
			}
		}

		click(ELEMENT_ECM_EXPLORER_DRIVES_SAVE_FORM);
	}
	/**
	 * 
	 * @param name
	 * @param applyViews (All the view want to be check have to be specified, the other will be uncheck) 
	 */
	public void editDrives(String name,String[] applyViews){
		click(By.xpath(ELEMENT_ECM_EXPLORER_DRIVES_EDIT_LIST.replace("{$name}", name)));
		click(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_FORM);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ADMIN,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_CATEGORIES,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ICONS,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_LIST,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_WEB,2);
		for(String arrayElement : applyViews ){
			switch(arrayElement){
			case "Admin" :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ADMIN,2);
				break;
			case "Categories":
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_CATEGORIES,2);
				break;
			case "Icons":
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ICONS,2);
				break;
			case "List" :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_LIST,2);
				break;
			case "Web" :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_WEB,2);
				break;
			}
		}
		click(ELEMENT_ECM_EXPLORER_DRIVES_SAVE_FORM);
	}

	/**
	 * Delete a drive
	 * @param name
	 */
	public void deleteDrives(String name){
		click(By.xpath(ELEMENT_ECM_EXPLORER_DRIVES_DELETE_LIST.replace("{$name}",name)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_EXPLORER_DRIVES_DELETE_LIST.replace("{$name}",name)));
	}
	/**
	 * Add a Tags
	 * @param tagName
	 * @param occurenceNumber
	 * @param htmlStyle
	 */
	public void addTags(String tagName, String occurenceNumber,String htmlStyle){
		click(ELEMENT_ECM_EXPLORER_TAGS_ADD_STYLE_BUTTON);
		type(ELEMENT_ECM_EXPLORER_TAGS_ADD_NAME_FORM,tagName,true);
		type(ELEMENT_ECM_EXPLORER_TAGS_NUMBER_OCCURENCE_FORM, occurenceNumber, true);
		type(ELEMENT_ECM_EXPLORER_TAGS_HTML_STYLE_FORM, htmlStyle, true);
		click(ELEMENT_ECM_EXPLORER_TAGS_UPDATE_FORM);
	}
	/**
	 * Update a Tag
	 * @param tagName
	 * @param occurences
	 * @param html
	 */
	public void updateTags(String tagName, String occurences,String html){
		click(By.xpath(ELEMENT_ECM_EXPLORER_TAGS_EDIT_LIST.replace("{$name}",tagName)));
		if(occurences!=null)
			type(ELEMENT_ECM_EXPLORER_TAGS_NUMBER_OCCURENCE_FORM, occurences, true);
		if(html!=null)
			type(ELEMENT_ECM_EXPLORER_TAGS_HTML_STYLE_FORM, html, true);
		click(ELEMENT_ECM_EXPLORER_TAGS_UPDATE_FORM);
	}
	/**
	 * Delete a tag
	 * @param tagName
	 */
	public void deleteTags(String tagName){
		click(By.xpath(ELEMENT_ECM_EXPLORER_TAGS_DELETE_LIST.replace("{$name}",tagName)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_EXPLORER_TAGS_DELETE_LIST.replace("{$name}",tagName)));

	}
	/**
	 * Delete a category by name
	 * @param name
	 */
	public void deleteCategories(String name){
		click(By.xpath(ELEMENT_ECM_ADVANCED_CATEGORIES_DELETE.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_ADVANCED_CATEGORIES_DELETE.replace("{$name}", name)));
	}
	/**
	 * Add a new category
	 * @param name
	 * @param nameAction
	 * @param lifeCycle
	 * @param targetPath
	 */
	public void addCategories(String name,String nameAction,String lifeCycle, String targetPath){
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_ADD_CATEGORIES);
		type(ELEMENT_ECM_ADVANCED_CATEGORIES_NAME_FORM,name,true);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_NEXT_1STPAGE_FORM);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_NEXT_2NDPAGE_FORM);
		type(ELEMENT_ECM_ADVANCED_CATEGORIES_NAME_ACTION_FORM,nameAction,true);
		select(ELEMENT_ECM_ADVANCED_CATEGORIES_LIFECYCLE_FORM,lifeCycle);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_OPEN_TARGETPATH_ACTION_FORM);
		if(targetPath=="root")
			click(ELEMENT_ECM_ADVANCED_CATEGORIES_ROOT_NODE_ACTION_FORM);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_SAVE_FORM);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_CLOSE_FORM);
	}

	/**
	 * Edit a category
	 * @param name
	 * @param nameAction
	 * @param lifeCycle
	 * @param targetPath
	 * @param workspace
	 * @param pathWorkspace
	 */
	public void editCategories(String name,String nameAction,String lifeCycle, String targetPath,String workspace,String pathWorkspace){
		click(By.xpath(ELEMENT_ECM_ADVANCED_CATEGORIES_EDIT_FORM.replace("{$name}",name)));
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_PREVIOUS_4THPAGE);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_PREVIOUS_3RDPAGE);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_PREVIOUS_2NDPAGE);
		if(workspace!=null){
			select(ELEMENT_ECM_ADVANCED_CATEGORIES_WORKSPACE_SELECT_FORM,workspace);
			click(ELEMENT_ECM_ADVANCED_CATEGORIES_ADD_HOME_PATH_FORM);
			if(pathWorkspace=="root")
				click(ELEMENT_ECM_ADVANCED_CATEGORIES_ROOT_NODE_ACTION_FORM);
		}
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_NEXT_1STPAGE_FORM);
		// here to manage permission if needed
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_NEXT_2NDPAGE_FORM);
		// here to manage the lifecycle and nameAction etc..
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_SAVE_FORM);
		click(ELEMENT_ECM_ADVANCED_CATEGORIES_CLOSE_FORM);
	}
	/**
	 * Add a new action type
	 * @param name
	 * @param script
	 * @param variables
	 */
	public void addActionType(String name, String script,String variables){
		click(ELEMENT_ADD_ACTION_TYPE);
		type(ELEMENT_ECM_ACTION_NAME_FORM,name,true);
		if(script!=null)
			select(ELEMENT_ECM_ACTION_SCRIPT_FORM,script);
		if(variables!=null)
			type(ELEMENT_ECM_ACTION_VARIABLES_FORM,variables, true);
		
		click(ELEMENT_ECM_ACTION_SAVE_FORM);
	}
	/**
	 * Edit a action type
	 * @param name
	 * @param newName
	 * @param script
	 * @param variables
	 */
	public void editActionType(String name,String newName, String script,String variables){
		click(By.xpath(ELEMENT_ECM_ACTION_EDIT_LIST.replace("{$name}", name)));
		addActionType( newName,  script,variables);
		waitForAndGetElement(ELEMENT_ECM_ACTION_LIST.replace("{$name}",newName));
		waitForElementNotPresent(ELEMENT_ECM_ACTION_LIST.replace("{$name}",name));
	}
	/**
	 * Delete a action type
	 * @param name
	 */
	public void deleteAction(String name){
		click(By.xpath(ELEMENT_ECM_ACTION_DELETE_LIST.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_ECM_ACTION_LIST.replace("{$name}",name));
	}
	/**
	 * Add a new script
	 * @param name
	 * @param content
	 * @param script
	 */
	public void addScripts(String name, String content,String script){
		click(ELEMENT_ECM_ADVANCED_SCRIPT_ADD_SCRIPT);
		type(ELEMENT_ECM_ADVANCED_SCRIPT_NAME_FORM,name,true);
		if(script!=null)
			type(ELEMENT_ECM_ADVANCED_SCRIPT_SCRIPT_FORM,script,true);
		if(content!=null)
			type(ELEMENT_ECM_ADVANCED_SCRIPT_CONTENT_FORM,content, true);
		
		click(ELEMENT_ECM_ADVANCED_SCRIPT_SAVE_FORM);
	}
	/**
	 * Edit a Script
	 * @param oldname
	 * @param name
	 * @param content
	 * @param script
	 */
	public void EditScripts(String oldname,String name, String content,String script){
		click(By.xpath(ELEMENT_ECM_ADVANCED_SCRIPT_EDIT_LIST.replace("{$name}", oldname)));
		type(ELEMENT_ECM_ADVANCED_SCRIPT_NAME_FORM,name,true);
		if(script!=null)
			type(ELEMENT_ECM_ADVANCED_SCRIPT_SCRIPT_FORM,script,true);
		if(content!=null)
			type(ELEMENT_ECM_ADVANCED_SCRIPT_CONTENT_FORM,content, true);
		
		click(ELEMENT_ECM_ADVANCED_SCRIPT_SAVE_FORM);
		waitForAndGetElement(ELEMENT_ECM_ADVANCED_SCRIPT_LIST.replace("{$name}",name));
		waitForElementNotPresent(ELEMENT_ECM_ADVANCED_SCRIPT_LIST.replace("{$name}",oldname));
	}
	/**
	 * Delete a script by name
	 * @param name
	 */
	public void deleteScripts(String name){
		click(By.xpath(ELEMENT_ECM_ADVANCED_SCRIPT_DELETE_LIST.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_ECM_ADVANCED_SCRIPT_LIST.replace("{$name}",name));
	}
	/**
	 * Add a new query
	 * @param name
	 * @param queryType
	 * @param statement
	 * @param permission
	 */
	public void addQueries(String name,String queryType, String statement,String permission){
		click(ELEMENT_ECM_ADVANCED_QUERIES_ADD_QUERIES);
		type(ELEMENT_ECM_ADVANCED_QUERIES_NAME_FORM,name,true);
		if(queryType!=null)
			select(ELEMENT_ECM_ADVANCED_QUERIES_QUERY_TYPE_FORM,queryType);
		if(statement!=null)
			type(ELEMENT_ECM_ADVANCED_QUERIES_STATEMENT_FORM,statement, true);
		click(ELEMENT_ECM_ADVANCED_QUERIES_PERMISSION_FORM);
		if(permission=="any"){
			click(ELEMENT_PERMISSION_ANY);
		}
		click(ELEMENT_ECM_ADVANCED_QUERIES_SAVE_FORM);
	}
	/**
	 * Edit a queri
	 * @param name
	 * @param queryType
	 * @param statement
	 * @param permission
	 */
	public void editQueries(String name,String queryType, String statement,String permission){
		click(ELEMENT_ECM_ADVANCED_QUERIES_EDIT_BUTTON.replace("{$name}",name));
		if(queryType!=null)
			select(ELEMENT_ECM_ADVANCED_QUERIES_QUERY_TYPE_FORM,queryType);
		if(statement!=null)
			type(ELEMENT_ECM_ADVANCED_QUERIES_STATEMENT_FORM,statement, true);
		if(permission!=null)
			click(ELEMENT_ECM_ADVANCED_QUERIES_PERMISSION_FORM);
		click(ELEMENT_ECM_ADVANCED_QUERIES_SAVE_FORM);
	}
	/**
	 * Delete a queri
	 * @param name
	 */
	public void deleteQueries(String name){
		click(By.xpath(ELEMENT_ECM_ADVANCED_QUERIES_DELETE_BUTTON.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_ECM_ADVANCED_QUERIES_LIST.replace("{$name}",name));
	}
}
