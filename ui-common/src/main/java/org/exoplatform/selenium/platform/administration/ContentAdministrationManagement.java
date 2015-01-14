package org.exoplatform.selenium.platform.administration;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	public By ELEMENT_ECMS_FUNCTIONS_NODES = By.xpath("//*[@class='uiIconEcmsNodeTypeManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_NAMESPACES = By.xpath("//*[@class='uiIconEcmsNamespaceManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_LOCKS = By.xpath("//*[@class='uiIconEcmsUnLockManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_DOCUMENTS = By.xpath("//*[@class='uiIconEcmsTemplatesManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_LIST = By.xpath("//*[@class='uiIconEcmsCLVTemplatesManager uiIconEcmsLightGray']");
	public By ELEMENT_ECMS_FUNCTIONS_METADATA = By.xpath("//*[@class='uiIconEcmsMetadataManager uiIconEcmsLightGray']");


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


	// repository, nodes type
	public By ELEMENT_ECM_REPOSITORY_NODES_ADD = By.xpath("//*[@id='ListNodeType']//*[contains(text(),'Add')]");
	public By ELEMENT_ECM_REPOSITORY_NODES_NAME_FORM = By.xpath("//*[@id='nodeTypeName']");
	public By ELEMENT_ECM_REPOSITORY_NODES_SUPER_TYPES_FORM = By.xpath("//*[@id='superTypes']");
	public By ELEMENT_ECM_REPOSITORY_NODES_MIXIN_TYPES = By.xpath("//*[@name='mixinType']");
	public By ELEMENT_ECM_REPOSITORY_NODES_SAVE_FORM = By.xpath("//*[@id='UINodeTypeForm']//*[contains(text(),'Save')]");
	public By ELEMENT_ECM_REPOSITORY_NODES_SEARCH_NODE = By.xpath("//*[@id='NodeTypeText']");
	public String ELEMENT_ECM_REPOSITORY_NODES_SHOW_SPECIFIC_NODE = ".//*[@id='ListNodeType']//*[contains(text(),'{$node}')]/../..//*[@class='uiIconPreview uiIconLightGray']";
	public String ELEMENT_ECM_REPOSITORY_NODES_CHECK_SUPER_TYPES = "//*[@id='superTypes' and @value='{$types}']";
	public By ELEMENT_ECM_REPOSITORY_NODES_CLOSE_FORM = By.xpath("//*[@id='UINodeTypeForm']//*[contains(text(),'Close')]");
	
	// repository, namespaces
	public By ELEMENT_ECM_REPOSITORY_NAMESPACES_ADD = By.xpath("//*[@id='UINamespaceManager']//*[contains(text(),'Register')]");
	public By ELEMENT_ECM_REPOSITORY_NAMESPACES_FORM_NAME = By.xpath("//*[@id='namespace']");
	public By ELEMENT_ECM_REPOSITORY_NAMESPACES_URI_FORM = By.xpath("//*[@id='uri']");
	public By ELEMENT_ECM_REPOSITORY_NAMESPACES_SAVE_FORM = By.xpath("//*[@id='UINamespaceForm']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_REPOSITORY_NAMESPACES_CHECK_LIST_URL_AND_PREFIX= ".//*[@id='UINamespaceList']//*[contains(text(),'{$prefix}')]/../..//*[contains(text(),'{$url}')]";
	
	// repository Locks
	public By ELEMENT_ECM_REPOSITORY_LOCKS_DEVELOPMENT_GROUP = By.xpath("//*[@id='UIPermissionSelector']//*[contains(text(),'Development')]");
	public By ELEMENT_ECM_REPOSITORY_LOCKS_ALL_GROUP = By.xpath("//*[@id='UIPermissionSelector']//*[contains(text(),'*')]");
	public String ELEMENT_ECM_REPOSITORY_CHECK_LOCK_PERMISSION = "//*[@id='UILockHolderList']//*[contains(text(),'{$group}')]";
	public String ELEMENT_ECM_REPOSITORY_DELETE_LOCK_PERMISSION = "//*[@id='UILockHolderList']//*[contains(text(),'{$group}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	public By ELEMENT_ECM_REPOSITORY_MANAGE_LOCK = By.xpath("//*[@id='UIUnLockManager']//*[contains(text(),'Manage Lock')]");
	public String ELEMENT_ECM_REPOSITORY_UNLOCK_NODE_LIST = "//*[@id='UILockNodeList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconUnlockMini uiIconLightGray']";
	
	// templates, Documents
	public By ELEMENT_ECM_TEMPLATES_DOCUMENTS_ADD_DOCUMENT = By.xpath("//*[@id='UITemplateContainer']//*[contains(text(),'Add Template')]");
	public By ELEMENT_ECM_TEMPLATES_DOCUMENTS_LABEL_FORM = By.xpath("//*[@id='label']");	
	public By ELEMENT_ECM_TEMPLATES_DOCUMENTS_SAVE_FORM = By.xpath("//*[@id='UITemplateForm']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST = "//*[@id='UITemplateList']//*[contains(text(),'{$name}')]";
	public String ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST_EDIT = "//*[@id='UITemplateList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconEdit uiIconLightGray']";
	public By ELEMENT_ECM_TEMPLATES_DOCUMENTS_SAVE_EDIT_FORM = By.xpath("//*[@id='UITemplateEditForm']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST_DELETE = "//*[@id='UITemplateList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";

	// templates, List
	public By ELEMENT_ECM_TEMPLATES_LIST_ADD_LIST = By.xpath("//*[@id='ContentTemplateContainer']//*[contains(text(),'Add Template')]");
	public By ELEMENT_ECM_TEMPLATES_LIST_TEMPLATE_NAME_FORM = By.xpath("//*[@id='template']");
	public By ELEMENT_ECM_TEMPLATES_LIST_NAME_FORM = By.xpath("//*[@id='title']");
	public By ELEMENT_ECM_TEMPLATES_LIST_CONTENT_FORM = By.xpath("//*[@id='content']");
	public By ELEMENT_ECM_TEMPLATES_LIST_SAVE_FORM = By.xpath("//*[@id='UICLVTemplateForm_ContentTemplateContainer']//*[contains(text(),'Save')]");
	public String ELEMENT_ECM_TEMPLATES_LIST_CHECK_LIST ="//*[@id='UICLVTemplateList']//*[contains(text(),'{$name}')]/../..//*[contains(text(),'{$template}')]";
	public String ELEMENT_ECM_TEMPLATES_LIST_CHECK_BY_NAME ="//*[@id='UICLVTemplateList']//*[contains(text(),'{$name}')]";
	public String ELEMENT_ECM_TEMPLATES_LIST_EDIT_LIST ="//*[@id='UICLVTemplateList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconEdit uiIconLightGray']";
	public String ELEMENT_ECM_TEMPLATES_LIST_DELETE_LIST ="//*[@id='UICLVTemplateList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	
	// templates, metadata
	public String ELEMENT_ECM_TEMPLATES_METADATA_LIST = "//*[@id='UIMetadataList']//*[contains(text(),'{$name}')]";
	public String ELEMENT_ECM_TEMPLATES_METADATA_FORM_EDIT = "//*[@id='UIMetadataList']//*[contains(text(),'{$name}')]/..//*[@class='uiIconEdit uiIconLightGray']";
	public By ELEMENT_ECM_TEMPLATES_METEDATA_FORM_EDIT_LABEL =By.xpath("//*[@id='metadataLabel']");
	public By ELEMENT_ECM_TEMPLATES_METADATA_FORM_APPLY = By.xpath("//*[@id='UIMetadataForm']//*[contains(text(),'Apply')]");
	public String ELEMENT_ECM_TEMPLATES_METADATA_FORM_SHOW = "//*[@id='UIMetadataList']//*[contains(text(),'{$name}')]/../..//*[@class='uiIconView uiIconLightGray']";
	public String ELEMENT_ECM_TEMPLATES_METADATA_CHECK_MATADATA_INFORMATION = "//*[@class='metadataInfoDetails']//*[contains(text(),'{$metadata}')]";
	public By ELEMENT_ECM_TEMPLATES_METADATA_CLOSE_VIEW = By.xpath("//*[@id='ViewMetadataPopup']//*[contains(text(),'Close')]");
	public String ELEMENT_ECM_TEMPLATES_METADATA_FORM_DELETE = "//*[@id='UIMetadataList']//*[contains(text(),'{$name}')]/..//*[@class='uiIconDelete uiIconLightGray']";


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
	 * 
	 * view option
	 *
	 */
	public enum specificView{
		ADMIN, CATEGORY, LIST, ICON, WEB
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
		case NODESTYPES :
			click(ELEMENT_ECMS_FUNCTIONS_NODES);
			break;
		case NAMESPACES :
			click(ELEMENT_ECMS_FUNCTIONS_NAMESPACES);
			break;
		case LOCKS :
			click(ELEMENT_ECMS_FUNCTIONS_LOCKS);
			break;	
		case DOCUMENTS :
			click(ELEMENT_ECMS_FUNCTIONS_DOCUMENTS);
			break;
		case LIST :
			click(ELEMENT_ECMS_FUNCTIONS_LIST);
			break;
		case METADATA :
			click(ELEMENT_ECMS_FUNCTIONS_METADATA);
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
	public void addDrives(String name, String permission,specificView[] applyViews){
		click(ELEMENT_ECM_EXPLORER_DRIVES_ADD_DRIVES);
		type(ELEMENT_ECM_EXPLORER_NAME_DRIVES_FORM,name,true);

		click(ELEMENT_ECM_COMMON_ADD_PERMISSION_BUTTON);
		if(permission=="any")
			click(ELEMENT_ECM_COMMON_ANY_PERMISSION);
		click(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_FORM);
		for(specificView arrayElement : applyViews ){
			switch(arrayElement){
			case ADMIN :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ADMIN,2);
				break;
			case CATEGORY:
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_CATEGORIES,2);
				break;
			case ICON:
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ICONS,2);
				break;
			case LIST :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_LIST,2);
				break;
			case WEB :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_WEB,2);
				break;
			default:
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
	public void editDrives(String name,specificView[] applyViews){
		click(By.xpath(ELEMENT_ECM_EXPLORER_DRIVES_EDIT_LIST.replace("{$name}", name)));
		click(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_FORM);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ADMIN,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_CATEGORIES,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ICONS,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_LIST,2);
		uncheck(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_WEB,2);
		for(specificView arrayElement : applyViews ){
			switch(arrayElement){
			case ADMIN :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ADMIN,2);
				break;
			case CATEGORY:
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_CATEGORIES,2);
				break;
			case ICON:
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_ICONS,2);
				break;
			case LIST :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_LIST,2);
				break;
			case WEB :
				check(ELEMENT_ECM_EXPLORER_APPLY_VIEWS_CHECKBOX_WEB,2);
				break;
			default:
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
	
	/**
	 * opt 0 is mixin type, true or false
	 */
	public void addNodeType(String name,String superTypes,Object... opParams){
		String mixinType = (String) (opParams.length>0 ? opParams[0] : null);
		click(ELEMENT_ECM_REPOSITORY_NODES_ADD);
		type(ELEMENT_ECM_REPOSITORY_NODES_NAME_FORM,name,true);
		type(ELEMENT_ECM_REPOSITORY_NODES_SUPER_TYPES_FORM,superTypes,true);
		if(mixinType!=null)
			select(ELEMENT_ECM_REPOSITORY_NODES_MIXIN_TYPES, mixinType);
		click(ELEMENT_ECM_REPOSITORY_NODES_SAVE_FORM);
	}

	/**
	 * Search a Node and check it
	 * @param name
	 * @param types
	 */
	public void searchNodeAndCheckIt(String name,String types){
		type(ELEMENT_ECM_REPOSITORY_NODES_SEARCH_NODE,name,true);
		waitForAndGetElement(ELEMENT_ECM_REPOSITORY_NODES_SEARCH_NODE).sendKeys(Keys.ENTER);
		click(By.xpath(ELEMENT_ECM_REPOSITORY_NODES_SHOW_SPECIFIC_NODE.replace("{$node}", name)));
		waitForAndGetElement(By.xpath(ELEMENT_ECM_REPOSITORY_NODES_CHECK_SUPER_TYPES.replace("{$types}", types)));
		click(ELEMENT_ECM_REPOSITORY_NODES_CLOSE_FORM);
	}
	/**
	 * register Name space
	 * @param nameSpacePrefix
	 * @param url
	 */
	public void registerNamespace(String nameSpacePrefix, String url){
		click(ELEMENT_ECM_REPOSITORY_NAMESPACES_ADD);
		type(ELEMENT_ECM_REPOSITORY_NAMESPACES_FORM_NAME, nameSpacePrefix,true);
		type(ELEMENT_ECM_REPOSITORY_NAMESPACES_URI_FORM, url,true);
		click(ELEMENT_ECM_REPOSITORY_NAMESPACES_SAVE_FORM);
	}
	/**
	 * Add a document in Template
	 * @param label
	 * @param permission
	 */
	public void addDocumentInTemplates(String label, String permission){
		click(ELEMENT_ECM_TEMPLATES_DOCUMENTS_ADD_DOCUMENT);
		type(ELEMENT_ECM_TEMPLATES_DOCUMENTS_LABEL_FORM, label, true);
		click(ELEMENT_ECM_COMMON_ADD_PERMISSION_BUTTON);
		if(permission=="any")
			click(ELEMENT_PERMISSION_ANY);
		click(ELEMENT_ECM_TEMPLATES_DOCUMENTS_SAVE_FORM);
	}
	/**
	 * Edita Document in Templates
	 * @param oldName
	 * @param newName
	 */
	public void editDocumentInTemplates(String oldName, String newName){
		click(By.xpath(ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST_EDIT.replace("{$name}",oldName)));
		type(ELEMENT_ECM_TEMPLATES_DOCUMENTS_LABEL_FORM, newName, true);
		click(ELEMENT_ECM_TEMPLATES_DOCUMENTS_SAVE_EDIT_FORM);
		waitForAndGetElement(By.xpath(ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST.replace("{$name}",newName)));
	}
	/**
	 * Delete a Document in Template
	 * @param title
	 */
	public void deleteDocumentTemplate(String title){
		click(By.xpath(ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST_DELETE.replace("{$name}", title)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_TEMPLATES_DOCUMENTS_LIST.replace("{$name}",title)));
	}
	/**
	 * Add a template into list
	 * @param name
	 * @param nameTemplate
	 * @param content
	 */
	public void addTemplateInList(String name,String nameTemplate, String content){
		click(ELEMENT_ECM_TEMPLATES_LIST_ADD_LIST);
		type(ELEMENT_ECM_TEMPLATES_LIST_TEMPLATE_NAME_FORM,nameTemplate,true);
		type(ELEMENT_ECM_TEMPLATES_LIST_NAME_FORM,name,true);
		type(ELEMENT_ECM_TEMPLATES_LIST_CONTENT_FORM,content,true);
		click(ELEMENT_ECM_TEMPLATES_LIST_SAVE_FORM);
		waitForAndGetElement(By.xpath(ELEMENT_ECM_TEMPLATES_LIST_CHECK_LIST.replace("{$name}",name).replace("{$template}",nameTemplate)));
	}
	/**
	 * Edit a Template in List
	 * @param oldTem
	 * @param newName
	 */
	public void editTemplateNameInList(String oldTem, String newName){
		click(By.xpath(ELEMENT_ECM_TEMPLATES_LIST_EDIT_LIST.replace("{$name}",oldTem)));
		type(ELEMENT_ECM_TEMPLATES_LIST_NAME_FORM,newName,true);
		click(ELEMENT_ECM_TEMPLATES_LIST_SAVE_FORM);
		waitForAndGetElement(By.xpath(ELEMENT_ECM_TEMPLATES_LIST_CHECK_BY_NAME.replace("{$name}",newName)));
	}
	/**
	 * Delete a Template in List
	 * @param name
	 */
	public void deleteTemplateList(String name){
		click(By.xpath(ELEMENT_ECM_TEMPLATES_LIST_DELETE_LIST.replace("{$name}",name)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_TEMPLATES_LIST_DELETE_LIST.replace("{$name}",name)));
	}
	/**
	 * Edit a Metadata name and Permission
	 * @param oldName
	 * @param newName
	 * @param permission
	 */
	public void editeMetadataNameAndPermission(String oldName, String newName, String permission){
		click(By.xpath(ELEMENT_ECM_TEMPLATES_METADATA_FORM_EDIT.replace("{$name}",oldName)));
		type(ELEMENT_ECM_TEMPLATES_METEDATA_FORM_EDIT_LABEL,newName,true);
		click(ELEMENT_ECM_COMMON_ADD_PERMISSION_BUTTON);
		if(permission=="any")
			click(ELEMENT_PERMISSION_ANY);
		click(ELEMENT_ECM_TEMPLATES_METADATA_FORM_APPLY);
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_TEMPLATES_LIST_DELETE_LIST.replace("{$name}",oldName)));
	}
	/**
	 * Delete a Metadata
	 * @param name
	 */
	public void deleteMetadata(String name){
		click(By.xpath(ELEMENT_ECM_TEMPLATES_METADATA_FORM_DELETE.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_TEMPLATES_METADATA_FORM_DELETE.replace("{$name}", name)));
	}
}
