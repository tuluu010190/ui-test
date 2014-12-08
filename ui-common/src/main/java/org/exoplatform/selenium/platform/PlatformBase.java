package org.exoplatform.selenium.platform;

import org.exoplatform.selenium.TestBase;
import org.exoplatform.selenium.Utils;

import org.exoplatform.selenium.platform.objectdatabase.user.UserDatabase;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static org.exoplatform.selenium.TestLogger.info;

public class PlatformBase extends TestBase {

	public String DATA_USER1 = "john";
	public  String DATA_USER2 = "mary";
	public  String DATA_USER3 = "james";
	public  String DATA_USER4 = "demo";
	public  String USER_ROOT = "root";
	public  String PASS_ROOT = "gtngtn";
	public String DATA_PASS = "gtn";
	
	public final By ELEMENT_SIGN_IN_BUTTON = By.xpath("//*[@class='loginButton']/*");
	public final By ELEMENT_SIGN_OUT_LINK = By.className("uiIconPLFLogout");
	/****************************Method*************************************/
	/**
	 * get default user pass from data driven
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void getDefaultUserPass(String userDataFile, String userSheet, Object... opParams) throws Exception{
		info("Get deault user pass from data driven");
		UserDatabase userData = new UserDatabase();
		userData.setUserData(userDataFile,userSheet,opParams);
		DATA_USER1 = userData.userName.get(0);
		DATA_PASS = userData.password.get(0);
		DATA_USER2 = userData.userName.get(1);

		USER_ROOT = userData.userName.get(4);
		PASS_ROOT = userData.password.get(4);
		DATA_USER3 = userData.userName.get(2);
		DATA_USER4 = userData.userName.get(3);
	}
	
	/**Function to add data to frame
	 * 
	 * @param framelocator
	 * @param data
	 * @param validate: if not passed, then not clear old data of frame, verify that new data is input correctly
	 * 		           = true, clear old data of frame
	 * 				   = false, not clear old data, not verify that new data is input correctly
	 */
	public void inputDataToFrame(By framelocator, String data, boolean...validate){
		try {
			WebElement inputsummary = null;

			for (int repeat = 0;; repeat++) {
				if (repeat >= DEFAULT_TIMEOUT/WAIT_INTERVAL) {
					Assert.fail("Fail to input data to frame " + framelocator);
				}
				WebElement e = waitForAndGetElement(framelocator,DEFAULT_TIMEOUT,1,2);
				driver.switchTo().frame(e);
				inputsummary = driver.switchTo().activeElement();
				inputsummary.click();
				inputsummary.clear();

				if (validate.length >0)
					if (validate[0]){
						((JavascriptExecutor) driver).executeScript("document.body.innerHTML='" + data + "'");
						if (inputsummary.getText().contains(data)) break;
					}
					else{
						((JavascriptExecutor) driver).executeScript("document.body.innerHTML='" + data + "' + document.body.innerHTML;");
						break;
					}
				else {
					((JavascriptExecutor) driver).executeScript("document.body.innerHTML='" + data + "' + document.body.innerHTML;");
					if (inputsummary.getText().contains(data)) break;
				}

				switchToParentWindow();
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			inputDataToFrame (framelocator, data,validate);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			inputDataToFrame (framelocator,data,validate);
		}catch (WebDriverException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			inputDataToFrame (framelocator,data,validate);
		}
		finally {
			loopCount = 0;
		}
	}
}
