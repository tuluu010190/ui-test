package org.exoplatform.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelectGroup extends TestBase {

	@Test
		public static void loginEcms() {
			WebDriver driver = new FirefoxDriver();
			driver.get("http://localhost:8080/portal/acme/");
			JavascriptExecutor js=(JavascriptExecutor) driver;
//			String script= "document.getElementByClassName('LanguageIcon').click()";
			String script= "document.getElementById('AcmeWebSiteLogInLogOut').click()";
//			String xpath = "//a[@id='AcmeWebSiteLogInLogOut']";
//			String script= "return document.getElementsByXPath(" + xpath + ")";
//			String script = "document.evaluate(\'"+ xpath + "\', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).click()";
			js.executeScript(script);
//			WebElement ele = (WebElement) js.executeScript(script);
//			WebElement ele = (WebElement) js.executeScript(script);
//			ele.click();
//			pause(timeInMillis)
			System.out.println();	
		}
}
