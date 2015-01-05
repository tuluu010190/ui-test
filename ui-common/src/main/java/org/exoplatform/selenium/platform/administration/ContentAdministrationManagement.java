package org.exoplatform.selenium.platform.administration;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentAdministrationManagement extends PlatformBase{
	ManageAlert alert ;
	public ContentAdministrationManagement(WebDriver dr){
		driver = dr;
		alert= new ManageAlert(driver);
	}
	
	public By ELEMENT_ADVANCED_CATEGORIES_ECM_FUNCTIONS =By.xpath("//*[@class='ecmAdminPanel pull-left']//a[contains(text(),'Advanced')]");
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

	
	
	
	public enum mainEcmFunctions{
		DOCUMENTS,LIST,METADATA,VIEW,DRIVES,TAGS,NAMESPACES,NODESTYPES,LOCKS,CATEGORIES,QUERIES,SCRIPTS,ACTIONS;
	}
	
	public void goToSpecificFunctions(mainEcmFunctions main){
		switch(main){
		case ACTIONS :
			click(ELEMENT_ADVANCED_CATEGORIES_ECM_FUNCTIONS);
			click(ELEMENT_ECMS_FUNCTIONS_ACTIONS);
			break;
		case SCRIPTS :
			click(ELEMENT_ADVANCED_CATEGORIES_ECM_FUNCTIONS);
			click(ELEMENT_ECMS_FUNCTIONS_SCRIPTS);
			break;
		case QUERIES :
			click(ELEMENT_ADVANCED_CATEGORIES_ECM_FUNCTIONS);
			click(ELEMENT_ECMS_FUNCTIONS_QUERIES);
			break;
		case CATEGORIES :
			click(ELEMENT_ADVANCED_CATEGORIES_ECM_FUNCTIONS);
			click(ELEMENT_ECMS_FUNCTIONS_CATEGORIES);
			break;
		}
	}
	
	public void addActionType(String name, String script,String variables){
		click(ELEMENT_ADD_ACTION_TYPE);
		type(ELEMENT_ECM_ACTION_NAME_FORM,name,true);
		if(script!=null)
			select(ELEMENT_ECM_ACTION_SCRIPT_FORM,script);
		if(variables!=null)
			type(ELEMENT_ECM_ACTION_VARIABLES_FORM,variables, true);
		
		click(ELEMENT_ECM_ACTION_SAVE_FORM);
	}
	
	public void editActionType(String name,String newName, String script,String variables){
		click(By.xpath(ELEMENT_ECM_ACTION_EDIT_LIST.replace("{$name}", name)));
		addActionType( newName,  script,variables);
		waitForAndGetElement(ELEMENT_ECM_ACTION_LIST.replace("{$name}",newName));
		waitForElementNotPresent(ELEMENT_ECM_ACTION_LIST.replace("{$name}",name));
	}
	
	public void deleteAction(String name){
		click(By.xpath(ELEMENT_ECM_ACTION_DELETE_LIST.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_ECM_ACTION_LIST.replace("{$name}",name));
	}

	public void addScripts(String name, String content,String script){
		click(ELEMENT_ECM_ADVANCED_SCRIPT_ADD_SCRIPT);
		type(ELEMENT_ECM_ADVANCED_SCRIPT_NAME_FORM,name,true);
		if(script!=null)
			type(ELEMENT_ECM_ADVANCED_SCRIPT_SCRIPT_FORM,script,true);
		if(content!=null)
			type(ELEMENT_ECM_ADVANCED_SCRIPT_CONTENT_FORM,content, true);
		
		click(ELEMENT_ECM_ADVANCED_SCRIPT_SAVE_FORM);
	}
	
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
	
	public void deleteScripts(String name){
		click(By.xpath(ELEMENT_ECM_ADVANCED_SCRIPT_DELETE_LIST.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_ECM_ADVANCED_SCRIPT_LIST.replace("{$name}",name));
	}
	
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
	public void deleteQueries(String name){
		click(By.xpath(ELEMENT_ECM_ADVANCED_QUERIES_DELETE_BUTTON.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(ELEMENT_ECM_ADVANCED_QUERIES_LIST.replace("{$name}",name));
	}
	
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

	public void deleteCategories(String name){
		click(By.xpath(ELEMENT_ECM_ADVANCED_CATEGORIES_DELETE.replace("{$name}", name)));
		alert.acceptAlert();
		waitForElementNotPresent(By.xpath(ELEMENT_ECM_ADVANCED_CATEGORIES_DELETE.replace("{$name}", name)));
	}
}
