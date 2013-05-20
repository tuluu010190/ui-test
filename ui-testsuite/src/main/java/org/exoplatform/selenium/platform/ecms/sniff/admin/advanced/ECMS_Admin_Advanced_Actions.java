package org.exoplatform.selenium.platform.ecms.sniff.admin.advanced;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.admin.ECMainFunction;
import org.exoplatform.selenium.platform.ecms.admin.ManageAction;
import org.exoplatform.selenium.platform.ecms.admin.ManageScript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author vuna2
 * May, 2013
 *
 */
public class ECMS_Admin_Advanced_Actions extends PlatformBase{

	//Platform
	ManageAccount magAcc;

	//Ecms
	ECMainFunction ecMain;
	ManageAction magAction;
	ManageScript magScript;

	public String DATA_USER = "john";
	public String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods() {
		initSeleniumTest();
		driver.get(baseUrl);
		info("Login ECMS with " + DATA_USER);
		magAcc = new ManageAccount(driver);
		ecMain = new ECMainFunction(driver); 
		magAction = new ManageAction(driver);
		magScript = new ManageScript(driver);
		magAcc.signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods() {
		info("Logout ECMS");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/**
	 * Qmetry ID: 65848
	 * Add action type
	 * ================
	 * Qmetry ID: 71621
	 * Edit action type
	 * ================
	 * Qmetry ID: 71622
	 * Delete action type
	 * 
	 */
	@Test
	public void test01_AddEditDeleteActionType(){
		//Prepare test data
		//GetMailScript
		String scriptFileContent_0 = "TestData/ECMS_Admin_GetMailScript_Template.txt"; 
		String scriptLabel_0 = "GetMailScript"; 
		String scriptName_0 = "GetMailScript";
		//SendMailScript
		String scriptFileContent_1 = "TestData/ECMS_Admin_SendMailScript_Template.txt"; 
		String scriptLabel_1 = "SendMailScript"; 
		String scriptName_1 = "SendMailScript";
		
		String actionTypeName = "Get Emails";
		String newActionTypeName = "Send Emails";
		String variable = "exo:description";
		
		ecMain.goToScriptsTabInContentAdmin();
		
		magScript.addScript(scriptFileContent_0, scriptLabel_0, scriptName_0);
		magScript.addScript(scriptFileContent_1, scriptLabel_1, scriptName_1);
		
		//ecMain.goToActionsTabInContentAdmin();
		click(ecMain.ELEMENT_MANAGE_ACTIONS_LINK);
		
		magAction.addActionType(actionTypeName, scriptName_0 + ".groovy");
		
		magAction.editActionType(actionTypeName, newActionTypeName, scriptName_1 + ".groovy", variable);
		
		magAction.deleteActionType(newActionTypeName);
		
		//Reset data
		click(ecMain.ELEMENT_MANAGE_SCRIPTS_LINK);
		magScript.deleteScript(scriptLabel_0);
		magScript.deleteScript(scriptLabel_1);
	}
}