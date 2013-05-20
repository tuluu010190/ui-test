package org.exoplatform.selenium.platform.ecms.sniff.admin.advanced;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.admin.ECMainFunction;
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
public class ECMS_Admin_Advanced_Scripts extends PlatformBase{
	//Platform
	ManageAccount magAcc;

	//Ecms
	ECMainFunction ecMain;
	ManageScript magScript;

	public final String DATA_USER = "john";
	public final String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods() {
		initSeleniumTest();
		driver.get(baseUrl);
		info("Login ECMS with " + DATA_USER);
		magAcc = new ManageAccount(driver);
		ecMain = new ECMainFunction(driver); 
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
	 * Qmetry ID: 65865
	 * Add Script 
	 * ==========
	 * Qmetry ID: 67831
	 * Edit Script
	 * ==========
	 * Qmetry ID: 67832
	 * Delete Script
	 * 
	 */
	@Test
	public void test01_AddEditAndDeleteScript(){
		String scriptFileContent = "TestData/ECMS_Admin_SendMailScript_Template.txt"; 
		String scriptLabel = "SendMailScript"; 
		String scriptName = "SendMailScript";
		
		String newScriptFileContent = ""; 
		String newScriptName = "Edit SendMailScript";
		
		ecMain.goToScriptsTabInContentAdmin();
		
		magScript.addScript(scriptFileContent, scriptLabel, scriptName);
		
		magScript.editScript(scriptName, newScriptFileContent, newScriptName, true);
		
		magScript.deleteScript(newScriptName);
	}
}