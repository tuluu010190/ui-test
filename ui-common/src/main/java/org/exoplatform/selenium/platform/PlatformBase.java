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

	//Gmail
	public final String GMAIL_URL = "https://mail.google.com";
	public final String EMAIL_ADDRESS1 = "exomailtest01@gmail.com";
	public final String EMAIL_ADDRESS2 = "exoservice@gmail.com";
	public final String EMAIL_PASS = "exoadmin";
	public final By ELEMENT_DELETE_MAIL = By.xpath("//*[@id=':ro']/div[2]//*[@class='ar9 T-I-J3 J-J5-Ji']");
	public final By ELEMENT_DELETE_MAIL_2 = By.xpath("//*[@id=':5']//*[@class='iH']//*[@class='ar9 T-I-J3 J-J5-Ji']");
	public final By ELEMENT_GMAIL_INBOX = By.xpath("//a[contains(@title, 'Inbox')]");
	public final By ELEMENT_MAIL_CONTENT = By.xpath("//*[contains(@class, 'adP adO')]/div");
	public final By ELEMENT_GMAIL_USERNAME = By.id("Email");
	public final By ELEMENT_GMAIL_PASS = By.id("Passwd");
	public final By ELEMENT_GMAIL_SIGN_IN = By.id("signIn");
	public final String ELEMENT_GMAIL_TITLE = "//td/div[@class='xS']//div[@class='xT']//span/b[contains(text(),'{$title}')]";
	public final By ELEMENT_GMAIL_COMPOSE = By.xpath("//div[contains(text(),'COMPOSE')]");
	public final By ELEMENT_GMAIL_SHOW_DETAIL = By.xpath("//img[@aria-label='Show details']");
	public final String ELEMENT_GMAIL_TO_FIELD = "//td/span[text()='to:']/../..//span[text()='${to}']";
	public final By ELEMENT_GMAIL_SIGNIN_DIFFERENT_ACC = By.cssSelector("a[id='account-chooser-link']");
	public final By ELEMENT_GMAIL_ADD_ACCOUNT = By.cssSelector("a[id='account-chooser-add-account']");
	public final By ELEMENT_FIRST_MAIL = By.xpath("//div[@class='iA g6' and contains(text(),'Hi')]/../../../../../table[@class='cf iB']");
	public final String ELEMENT_GMAIL_CONTENT = "//*[@class='adn ads']";//*[contains(text(),'${content}')]";
	public final By ELEMENT_GMAIL_SIGN_IN_LINK = By.xpath("//a[@id='gmail-sign-in' and contains(text(),'Sign in')]");

	/**
	 * Available option
	 */
	public enum selectInvitationOption{
		ALWAYS, NEVER, ASK
	}


	/**
	 * Arrow option
	 */
	public enum selectArrowOption{
		NEXT, PREVIOUS, NOW
	}

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
	
	/**
	 * function: check content of mail
	 * @param mail: element title of mail
	 * @param content: mail content
	 */
	public void checkMail(By mail, String content){
		info("Check and delete mail");
		waitForAndGetElement(mail,300000);
		click(mail);	
		if(waitForAndGetElement(ELEMENT_GMAIL_CONTENT.replace("${content}",content),20000,0) == null )
			click(ELEMENT_FIRST_MAIL);
		assert waitForAndGetElement(ELEMENT_GMAIL_CONTENT).getText().contains(content);
	}
	
	/**
	 * function: delete mail
	 * @param mail: element title of mail
	 * @param content: mail content
	 */
	public void deleteMail(By mail, String content){
		info("Check and delete mail");
		waitForAndGetElement(mail,300000);
		click(mail);	
		info("delete mail");
		if (waitForAndGetElement(ELEMENT_DELETE_MAIL_2, 5000, 0) == null){
			click(ELEMENT_DELETE_MAIL);
			info("Delete 1");
		}else {
			click(ELEMENT_DELETE_MAIL_2);
			info("Delete 2");
		}
		waitForElementNotPresent(mail);
		Utils.pause(1000);
	}
}
