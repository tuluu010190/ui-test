package org.exoplatform.selenium.platform.exogtn.functional.loginout;

import org.exoplatform.selenium.platform.PlatformBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.exoplatform.selenium.TestLogger.info;

public class EXOGTN_LOGINOUT_SignInOut extends PlatformBase{
	
	public String MESSAGE_FAILED = "Sign in failed. Wrong username or password.";
	
	@BeforeMethod
	public void setUpBeforeTest() throws Exception {
		initSeleniumTest();
		driver.get(baseUrl);		
	}
	
	@AfterMethod
	public void afterTest() throws Exception {
		driver.quit();		
	}
	
	/*-- tests cases of : Portal\Login_out\Sign In --*/	
	//Check displaying portal after signing in successfully by admin account
	@Test
	public void test01_SignInByAdminAccount(){
			info("--Login by Admin account--");
			signIn("root", "gtn");
			waitForAndGetElement("Root Root");
			signOut();		
	}
	
	//Check displaying portal after signing in successfully by normal account
	@Test
	public void test02_SignInByNormalAccount(){
		info("--Login by Normal account--");
		
		//Sign in as Jack Miller
		signIn("demo", "gtn");
		waitForTextPresent("Jack Miller");
		waitForTextNotPresent("Edit");
		signOut();
		
		//Sign in as Mary
		driver.get(baseUrl);
		signIn("mary", "gtn");
		waitForTextPresent("Mary Williams");
		waitForTextNotPresent("Edit");
		signOut();	
	}
	
	//Sign in with blank User name/Password
	@Test
	public void test03_SignInWithBlankUserNameAndPassword(){
		info("--Sign in with blank password");
		signIn("root","");
		waitForTextPresent(MESSAGE_FAILED);
		driver.get(baseUrl);
		
		info("--Sign in with blank username");
		signIn("","gtn");
		waitForTextPresent(MESSAGE_FAILED);	
	}
	
	//Sign in by unregistered User name
	@Test
	public void test04_SignInByUnRegisteredUsername(){
		info("--Sign in with unregistered account--");
		signIn("exogtn", "gtn");
		waitForTextPresent(MESSAGE_FAILED);	
	}
	
}
