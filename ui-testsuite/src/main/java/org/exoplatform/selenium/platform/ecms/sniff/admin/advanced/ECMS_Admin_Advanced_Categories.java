package org.exoplatform.selenium.platform.ecms.sniff.admin.advanced;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.exoplatform.selenium.platform.ecms.EcmsPermission;
import org.exoplatform.selenium.platform.ecms.admin.ECMainFunction;
import org.exoplatform.selenium.platform.ecms.admin.ManageCategory;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ActionBar;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ContentTemplate;
import org.exoplatform.selenium.platform.ecms.contentexplorer.ContextMenu;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author vuna2
 * May, 2013
 *
 */
public class ECMS_Admin_Advanced_Categories extends PlatformBase{

	//Platform
	NavigationToolbar nav;
	ManageAccount magAcc;
	Button button;

	//Ecms
	EcmsBase ecms; 
	ActionBar actBar;
	ContextMenu cMenu;
	ManageCategory magCa;
	ContentTemplate cTemplate;
	EcmsPermission ecmsPer;
	ECMainFunction ecMain;

	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";

	String categoryTreeName = "Sniff_Ecms_Admin_Category_Test";
	String categoryName_0 = "category1";
	String newCategoryName_0 = "category2";
	String categoryName_1 = "category3";
	String newCategoryName_1 = "category4";
	String categoryName_2 = "category5";
	String newCategoryName_2 = "category6";
	
	String categoryWorkspace = "collaboration";
	String nodeHomePath = "sites/intranet";
	String groupID = "Platform/Administration"; 
	String actionName = "test";
	String optionLifeCycle = "User Action/Content Addition"; 
	String nodeTargetPath = "jcr:system/exo:namespaces";	

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		info("LogIn to Intranet by User: " + DATA_USER);
		nav = new NavigationToolbar(driver);
		magAcc = new ManageAccount(driver);
		button = new Button(driver);
		ecms = new EcmsBase(driver);
		magCa = new ManageCategory(driver);
		cMenu = new ContextMenu(driver);
		ecmsPer = new EcmsPermission(driver);
		ecMain = new ECMainFunction(driver);
		actBar = new ActionBar(driver);
		cTemplate = new ContentTemplate(driver);
		magAcc.signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods() {
		info("-- User LogOut --");
		driver.quit();
	}


	/**
	 * Qmetry ID: 67827  
	 * Add a category
	 * ==============
	 * Qmetry ID: 67828
	 * Edit a category
	 * ==============
	 * Qmetry ID: 65850
	 * Delete a category
	 * 
	 */
	@Test
	public void test01_AddEditDeleteCategory(){
		String DATA_FILE = "FileTest";
        By ELEMENT_FILE = By.linkText(DATA_FILE);
        
		nav.goToContentAdministration();

		//Add a new category tree
		String[] form1 = {categoryTreeName, categoryWorkspace, nodeHomePath};
		String[] form2 = {groupID, "*"};
		String[] form3 = {actionName, optionLifeCycle, nodeTargetPath}; 
		boolean[] setPermission = {true, true, true};
		magCa.addNewCategoryTree(form1, false, true, form2, DATA_USER, setPermission, form3, true);
		
		//Add/copy/cut/paste/delete category in category tree
		magCa.addChildCategory(categoryTreeName, categoryName_0, false);
		ecms.clickUpLevel();
		magCa.addChildCategory(categoryTreeName, newCategoryName_0, true);
		magCa.copyAndPasteCategory(categoryName_0, newCategoryName_0);
		
		ecms.clickUpLevel();
		ecms.clickUpLevel();
		magCa.addChildCategory(categoryTreeName, categoryName_1, true);
		ecms.clickUpLevel();
		magCa.addChildCategory(categoryTreeName, newCategoryName_1, true);
		magCa.cutAndPasteCategory(categoryName_1, newCategoryName_1);	
		magCa.deleteCategory(newCategoryName_1);
		button.close();
		waitForTextPresent(categoryTreeName);
			
		//Edit a category
		magCa.addNewCategoryTree_Step4(categoryTreeName, categoryName_2, newCategoryName_2, "mary", true, true, true);
		click(magCa.ELEMENT_EDIT_CATEGORY_TREE.replace("${categoryTreeName}", categoryTreeName));
		click(button.ELEMENT_PREVIOUS_BUTTON_ADMIN_4);
		click(button.ELEMENT_PREVIOUS_BUTTON_ADMIN_3);
		ecmsPer.removeDefaultPermissionOfNode();
		ecmsPer.deletePermission("*:/platform/users",true);
		button.close();
		magAcc.signOut();

		//create a node by user who hasn't [read] permission
		magAcc.signIn("mary", "gtn");
		nav.goToSiteExplorer();
		ecms.goToNode("intranet/documents");
		actBar.goToAddNewContent();
		info("Create new File document: " + DATA_FILE);
		cTemplate.createNewFile(DATA_FILE, DATA_FILE, DATA_FILE);
		
		ecms.goToNode(ELEMENT_FILE);
		actBar.goToManageCategories();
		click(actBar.ELEMENT_SELECT_CATEGORY_TAB);
		click(actBar.ELEMENT_CATEGORY_TREE_BOX);
		waitForElementNotPresent(ecms.ELEMENT_CATEGORY_OPTION.replace("${CATEGORY_TREE_NAME}", categoryTreeName));	
		button.close();
		//delete data
		cMenu.deleteData(ELEMENT_FILE);
	
		//Delete a Category
		magAcc.signOut();
		magAcc.signIn(DATA_USER, DATA_PASS);
		ecMain.goToCategoriesTabInContentAdmin();
		magCa.deleteCategory(categoryTreeName);
	}
}