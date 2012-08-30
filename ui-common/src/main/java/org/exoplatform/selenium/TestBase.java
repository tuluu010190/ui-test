package org.exoplatform.selenium;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.exoplatform.selenium.TestLogger.*;

public class TestBase {
  protected static WebDriver driver;
  protected static Actions actions ;
  protected String baseUrl;
  protected static int timeoutSecInt = 10; //10 seconds
  public static int loopCount = 0;	
  protected  static boolean ieFlag;	 
  protected  static boolean chromeFlag;

  public static final String AJAX_LOADING_MASK = "//div[@id='AjaxLoadingMask']";
  public static final String DEFAULT_BASEURL="http://localhost:8080";
   
  public void initSeleniumTest(){
	  String browser = System.getProperty("browser");
	  if("chrome".equals(browser)){
		  driver = new ChromeDriver();
		  chromeFlag = true;
	  } else if ("iexplorer".equals(browser)){
		  driver = new InternetExplorerDriver();
		  ieFlag = true;
	  } else {
		  driver = new FirefoxDriver();
	  }
	  baseUrl = System.getProperty("baseUrl");
	  if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
	  
  }
  
  public boolean isElementPresent(By by) {
	  try {
		  driver.findElement(by);
		  return true;
	  } catch (NoSuchElementException e) {
		  return false;
	  }
  }
  
  public static boolean isElementNotPresent(String xpath) {
	  return !isElementPresent(xpath);
  }

  public static boolean isTextPresent(String text) {
	  pause(500);
	  String allVisibleTexts = getText("//body");

	  return allVisibleTexts.contains(text);
  }

  public static String getText(String xpath) {
	  WebElement element = null;
	  try {
		  element = waitForAndGetElementByXpath(xpath);
		  return element.getText();
	  } catch (StaleElementReferenceException e) {
		  pause(1000);
		  return getText(xpath);
	  }
  }

  public static List<WebElement> getElements(String xpath) {
      try {
          return driver.findElements(By.xpath(xpath));
      } catch (StaleElementReferenceException e) {
          pause(1000);
          return getElements(xpath);
      } finally {
          loopCount = 0;
      }
  }
  
  public static boolean isTextNotPresent(String text) {
	  return !isTextPresent(text);
  }

  public void waitForElementPresent(By by) {
	  for (int second = 0;; second++) {
		  if (second >= 60) Assert.fail("timeout");
		  try { if (isElementPresent(by)) break; } catch (Exception e) {}
		  pause(1000);
	  }
  }

  public static String getTextFromAlert() {
	  try {
		  Alert alert = driver.switchTo().alert();
		  return alert.getText();
	  } catch (NoAlertPresentException e) {
		  return "";
	  }
  }

  public static void acceptAlert() {
	  try {
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
	  } catch (NoAlertPresentException e) {
	  }
  }

  public static void pause(long timeInMillis) {
	  try {
		  Thread.sleep(timeInMillis);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }

  public static boolean isElementPresent(String xpath) {
	  try {
		  driver.findElement(By.xpath(xpath));
		  return true;
	  } catch (NoSuchElementException e) {
		  return false;
	  }
  }

  //waitfor and get Element by xpath
  public static WebElement waitForAndGetElement(By by) {
	  WebElement element = null;
	  for (int second = 0;; second++) {
		  if (second >= 2 * timeoutSecInt) {
			  Assert.fail("Timeout at waitForElementPresent: " + by);
		  }
		  try {
			  element = driver.findElement(by);
			  boolean isLoadingDisplayed = false;
			  try {
				  WebElement loading = driver.findElement(By.xpath(AJAX_LOADING_MASK));
				  isLoadingDisplayed = loading.isDisplayed();
			  } catch (Exception e) {
			  }
			  if (element.isDisplayed() && !isLoadingDisplayed) {
				  break;
			  }
		  } catch (Exception e) {
		  }
		  pause(500);
	  }
	  return element;
  }
  
  //waitfor and get Element by xpath
  public static WebElement waitForAndGetElementByXpath(String xpath) {
	  WebElement element = null;
	  for (int second = 0;; second++) {
		  if (second >= 2 * timeoutSecInt) {
			  Assert.fail("Timeout at waitForElementPresent: " + xpath);
		  }
		  try {
			  element = driver.findElement(By.xpath(xpath));
			  boolean isLoadingDisplayed = false;
			  try {
				  WebElement loading = driver.findElement(By.xpath(AJAX_LOADING_MASK));
				  isLoadingDisplayed = loading.isDisplayed();
			  } catch (Exception e) {
			  }
			  if (element.isDisplayed() && !isLoadingDisplayed) {
				  break;
			  }
		  } catch (Exception e) {
		  }
		  pause(500);
	  }
	  return element;
  }
  
  //waitfor and get Element by id
  public static WebElement waitForAndGetElementById(String id) {
	  WebElement element = null;
	  for (int second = 0;; second++) {
		  if (second >= 2 * timeoutSecInt) {
			  Assert.fail("Timeout at waitForElementPresent: " + id);
		  }
		  try {
			  element = driver.findElement(By.id(id));
			  boolean isLoadingDisplayed = false;
			  try {
				  WebElement loading = driver.findElement(By.xpath(AJAX_LOADING_MASK));
				  isLoadingDisplayed = loading.isDisplayed();
			  } catch (Exception e) {
			  }
			  if (element.isDisplayed() && !isLoadingDisplayed) {
				  break;
			  }
		  } catch (Exception e) {
		  }
		  pause(500);
	  }
	  return element;
  }

  //waitfor and get Element by name
  public static WebElement waitForAndGetElementByName(String name) {
	  WebElement element = null;
	  for (int second = 0;; second++) {
		  if (second >= 2 * timeoutSecInt) {
			  Assert.fail("Timeout at waitForElementPresent: " + name);
		  }
		  try {
			  element = driver.findElement(By.name(name));
			  boolean isLoadingDisplayed = false;
			  try {
				  WebElement loading = driver.findElement(By.xpath(AJAX_LOADING_MASK));
				  isLoadingDisplayed = loading.isDisplayed();
			  } catch (Exception e) {
			  }
			  if (element.isDisplayed() && !isLoadingDisplayed) {
				  break;
			  }
		  } catch (Exception e) {
		  }
		  pause(500);
	  }
	  return element;
  }
	  
  //waitfor and get Element by linktext
  public static WebElement waitForAndGetElementByLinkText(String link) {
	  WebElement element = null;
	  for (int second = 0;; second++) {
		  if (second >= 2 * timeoutSecInt) {
			  Assert.fail("Timeout at waitForElementPresent: " + link);
		  }
		  try {
			  element = driver.findElement(By.linkText(link));
			  boolean isLoadingDisplayed = false;
			  try {
				  WebElement loading = driver.findElement(By.xpath(AJAX_LOADING_MASK));
				  isLoadingDisplayed = loading.isDisplayed();
			  } catch (Exception e) {
			  }
			  if (element.isDisplayed() && !isLoadingDisplayed) {
				  break;
			  }
		  } catch (Exception e) {
		  }
		  pause(500);
	  }
	  return element;
  }
	  
  public static void dragAndDropToObject(String xpathSource, String xpathTarget) {
	  info("--Drag and drop to object--");
	  Actions action = new Actions(driver);
	  try {
		  WebElement source = waitForAndGetElementByXpath(xpathSource);
		  WebElement target = waitForAndGetElementByXpath(xpathTarget);

		  action.dragAndDrop(source, target).build().perform();
	  } catch (StaleElementReferenceException e) {
		  debug("drag and drop error!");
	  } 
  }

  public static void click(String locator) {
	  try {
		  WebElement element = waitForAndGetElement(locator);
		  actions.click(element).perform();
	  } catch (StaleElementReferenceException e) {
		  pause(1000);
		  click(locator);
	  } finally {
		  loopCount = 0;
	  }
  }

  public void clearCache(){
	  Actions actionObject = new Actions(driver);	 
	  actionObject.sendKeys(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
  }

  //Use this function to verify if a checkbox is checked (using when creating a portal/publicMode)
  public void check(String locator) {
	  try {
		  WebElement element = waitForAndGetElement(locator);

		  if (!element.isSelected()) {
			  actions.click(element).perform();
		  } else {
			  Assert.fail("Element " + locator + " is already checked.");
		  }
	  } catch (StaleElementReferenceException e) {
		  pause(100);
		  check(locator);
	  } finally {
		  loopCount = 0;
	  }
  }

  public static  String getValue(String locator) {
	  try {
		  return waitForAndGetElement(locator).getAttribute("value");
	  } catch (StaleElementReferenceException e) {
		  pause(100);
		  return getValue(locator);
	  } finally {
		  loopCount = 0;
	  }
  }



  public  void mouseOver(String locator, boolean safeToSERE) {
	  if (safeToSERE) {
		  try {
			  WebElement element = waitForAndGetElement(locator);
			  actions.moveToElement(element).perform();
		  } catch (StaleElementReferenceException e) {
			  pause(1000);
			  mouseOver(locator, safeToSERE);
		  } finally {
			  loopCount = 0;
		  }
	  } else {
		  WebElement element = waitForAndGetElement(locator);
		  actions.moveToElement(element).perform();
	  }
  }

  public void mouseOverAndClick(String locator) {
	  WebElement element;
	  if (ieFlag) {
		  element = getElement(locator);
	  } else {
		  element = waitForAndGetElement(locator);
	  }
	  actions.moveToElement(element).click(element).build().perform();
  }

  public WebElement getElement(String locator) {
	  pause(500);
	  return driver.findElement(By.xpath(locator));
  }

  public static WebElement waitForAndGetElement(String locator) {
	  WebElement element = null;
	  for (int second = 0;; second++) {
		  if (second >= timeoutSecInt) {
			  Assert.fail("Timeout at waitForElementPresent: " + locator);
		  }
		  try {
			  element = driver.findElement(By.xpath(locator));
			  boolean isLoadingDisplayed = false;
			  try {
				  WebElement loading = driver.findElement(By.xpath(AJAX_LOADING_MASK));
				  isLoadingDisplayed = loading.isDisplayed();
			  } catch (Exception e) {
			  }
			  if (element.isDisplayed() && !isLoadingDisplayed) {
				  break;
			  }
		  } catch (Exception e) {
		  }
		  pause(100);
	  }
	  return element;
  }

  public static void waitForElementNotPresent(String locator) {
	  for (int second = 0;; second++) {
		  if (second >= timeoutSecInt) {
			  Assert.fail("Timeout at waitForElementNotPresent: " + locator);
		  }
		  try {
			  driver.findElement(By.xpath(locator));
		  } catch (NoSuchElementException e) {
			  break;
		  } catch (Exception e) {
		  }
		  pause(100);
	  }
  }

  public  void waitForTextPresent(String text) {
	  for (int second = 0;; second++) {
		  if (second >= timeoutSecInt) {
			  Assert.fail("Timeout at waitForTextPresent: " + text);
		  }
		  if (isTextPresent(text)) {
			  break;
		  }
		  pause(500);
	  }
  }

  public void waitForTextNotPresent(String text) {
	  for (int second = 0;; second++) {
		  if (second >= timeoutSecInt) {
			  Assert.fail("Timeout at waitForTextNotPresent: " + text);
		  }
		  if (isTextNotPresent(text)) {
			  break;
		  }
		  pause(500);
	  }
  }

  public void waitForMessage(String message) {
	  //info("--Verify message: " + message);
	  pause(500);
	  waitForTextPresent(message);
  }

  public static void type(String locator, String value, boolean validate) {
	  try {
		  for (int second = 0;; second++) {
			  if (second >= timeoutSecInt) {
				  Assert.fail("Timeout at type: " + value + " into " + locator);
			  }
			  WebElement element = waitForAndGetElement(locator);
			  element.clear();
			  element.click();
			  element.sendKeys(value);
			  if (!validate || value.equals(getValue(locator))) {
				  break;
			  }
			  pause(100);
		  }
	  } catch (StaleElementReferenceException e) {
		  pause(1000);
		  type(locator, value, validate);
	  } finally {
		  loopCount = 0;
	  }
  }

  // Select option from combo box
  public void select(String locator, String option) {
	  try {
		  for (int second = 0;; second++) {
			  if (second >= timeoutSecInt) {
				  Assert.fail("Timeout at select: " + option + " into " + locator);
			  }
			  Select select = new Select(waitForAndGetElement(locator));
			  select.selectByVisibleText(option);
			  if (option.equals(select.getFirstSelectedOption().getText())) {
				  break;
			  }
			  pause(100);
		  }
	  } catch (StaleElementReferenceException e) {
		  pause(1000);
		  select(locator, option);
	  } finally {
		  loopCount = 0;
	  }
  }

  public void waitForConfirmation(String confirmationText) {
	  String message = getTextFromAlert();

	  //log("confirmation: " + message);

	  if (message.isEmpty()) {
		  if (loopCount > 5) {
			  Assert.fail("Message is empty");
		  }
		  pause(500);
		  loopCount++;
		  waitForConfirmation(confirmationText);
		  return;
	  }

	  for (int second = 0;; second++) {
		  if (second >= timeoutSecInt) {
			  Assert.fail("Timeout at waitForConfirmation: " + confirmationText);
		  }
		  if (message.equals(confirmationText)) {
			  break;
		  }
		  pause(100);
	  }
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  pause(500);
  }
  
  //This function return absolute path from relative path
  public String getAbsoluteFilePath(String relativeFilePath){
	  String curDir = System.getProperty("user.dir");
	  String absolutePath = curDir + "/src/main/resources/" + relativeFilePath;
	  return absolutePath;
  }
}
