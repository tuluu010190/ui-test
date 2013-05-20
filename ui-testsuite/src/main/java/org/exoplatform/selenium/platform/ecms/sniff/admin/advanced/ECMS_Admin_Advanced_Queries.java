package org.exoplatform.selenium.platform.ecms.sniff.admin.advanced;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ManageAccount;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.ecms.admin.ECMainFunction;
import org.exoplatform.selenium.platform.ecms.admin.ManageQuery;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author vuna2
 * May, 2013
 *
 */
public class ECMS_Admin_Advanced_Queries extends PlatformBase{
	//Platform
	ManageAccount magAcc;

	//Ecms
	ECMainFunction ecMain;
	ManageQuery magQuery;

	public final String DATA_USER = "john";
	public final String DATA_PASS = "gtn";

	@BeforeMethod
	public void beforeMethods() {
		initSeleniumTest();
		driver.get(baseUrl);
		info("Login ECMS with " + DATA_USER);
		magAcc = new ManageAccount(driver);
		ecMain = new ECMainFunction(driver); 
		magQuery = new ManageQuery(driver);
		magAcc.signIn(DATA_USER, DATA_PASS);
	}

	@AfterMethod
	public void afterMethods() {
		info("Logout ECMS");
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	/**
	 * Qmetry ID: 65863
	 * Add a Query
	 * ===========
	 * Qmetry ID: 67829
	 * Edit a Query
	 * ===========
	 * Qmetry ID: 67830
	 * Delete a Query
	 * 
	 */
	@Test
	public void test01_AddEditAndDeleteQuery(){
		String queryName = "Created Documents"; 
		String queryType = "SQL";
		boolean enableCacheResult = false;
		String group = "Platform/Users";
		String membership = "*";
		String statement = "//*[(@jcr:primaryType = 'exo:article' or @jcr:primaryType = 'nt:file') " +
				"and @exo:owner='${UserId}$' and not(@jcr:mixinTypes = 'exo:restoreLocation')] order by @exo:dateCreated descending";
		
		ecMain.goToQueriesTabInContentAdmin();
		
		magQuery.addQuery(queryName, queryType, enableCacheResult, group, membership);
		
		magQuery.editQuery(queryName, "xPath", true, true, statement, true, "Platform/Administration", "*");
		waitForTextPresent(statement);
				
		magQuery.deleteQuery(queryName);
	}
}