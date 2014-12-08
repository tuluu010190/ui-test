package org.exoplatform.selenium.platform;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.exoplatform.selenium.TestLogger.info;

public class ManageLogInOut extends PlatformBase {

	ManageAlert magAlert;
	public ManageLogInOut(WebDriver dr){
		driver = dr;
		magAlert = new ManageAlert(driver);
	}

	/**
	 * Log in to intranet
	 * @param username
	 * @param password
	 * @param opParams
	 */
	public void signIn(String username, String password,Boolean...opParams) {
		Boolean verify = (Boolean) (opParams.length > 0 ? opParams[0]: true);
		Boolean maxWin = (Boolean) (opParams.length > 1 ? opParams[1]: true);
		if(maxWin){
			driver.manage().window().maximize();
			driver.navigate().refresh();
			Utils.pause(2000);
		}
		if (firstTimeLogin){
			signOut();
			firstTimeLogin = false;
		}
		info("--Sign in as " + username + "--");
		type(ELEMENT_INPUT_USERNAME, username, true);
		type(ELEMENT_INPUT_PASSWORD, password, true);
		click(ELEMENT_SIGN_IN_BUTTON);
		if(verify)
			waitForElementNotPresent(ELEMENT_SIGN_IN_BUTTON);
		Utils.pause(2000);
	}

	/**
	 * Sign out from intranet
	 */
	public void signOut(){
		info("Sign out");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_ACCOUNT_NAME_LINK);
				break;
			}
			click(ELEMENT_ACCOUNT_NAME_LINK);
			if (waitForAndGetElement(ELEMENT_SIGN_OUT_LINK, 5000, 0) != null){
				info("Element " + ELEMENT_SIGN_OUT_LINK + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
		click(ELEMENT_SIGN_OUT_LINK);
		Utils.pause(1000);
		if ( ExpectedConditions.alertIsPresent() != null ){
			magAlert = new ManageAlert(driver);
			magAlert.acceptAlert();
		}
	}
}
