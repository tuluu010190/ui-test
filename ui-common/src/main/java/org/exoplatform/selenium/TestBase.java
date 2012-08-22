package org.exoplatform.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TestBase {
  protected static WebDriver driver;
  protected static Actions action ;
  protected String baseUrl;
  protected StringBuffer verificationErrors = new StringBuffer();
  protected static int timeoutSecInt = 10;
  
  public static final String AJAX_LOADING_MASK = "//div[@id='AjaxLoadingMask']";
 
  
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
	  public static WebElement waitForAndGetElementByXpath(String xpath) {
	      WebElement element = null;
	      for (int second = 0;; second++) {
	          if (second >= timeoutSecInt) {
	              Assert.fail("Timeout at waitForElementPresent: " + xpath);
	          }
	          try {
		          pause(100);
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
	          pause(1000);
	      }
	      return element;
	  }
	  //waitfor and get Element by id
	  public static WebElement waitForAndGetElementById(String id) {
	      WebElement element = null;
	      for (int second = 0;; second++) {
	          if (second >= timeoutSecInt) {
	              Assert.fail("Timeout at waitForElementPresent: " + id);
	          }
	          try {
		          pause(100);
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
	          pause(1000);
	      }
	      return element;
	  }
	  //waitfor and get Element by name
	  public static WebElement waitForAndGetElementByName(String name) {
	      WebElement element = null;
	      for (int second = 0;; second++) {
	          if (second >= timeoutSecInt) {
	              Assert.fail("Timeout at waitForElementPresent: " + name);
	          }
	          try {
		          pause(100);
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
	          pause(1000);
	      }
	      return element;
	  }
	  //waitfor and get Element by linktext
	  public static WebElement waitForAndGetElementByLinkText(String link) {
	      WebElement element = null;
	      for (int second = 0;; second++) {
	          if (second >= timeoutSecInt) {
	              Assert.fail("Timeout at waitForElementPresent: " + link);
	          }
	          try {
		          pause(100);
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
	          pause(1000);
	      }
	      return element;
	  }
	  
	  public static void dragAndDropToObject(String xpathSource, String xpathTarget) {
	      System.out.println("--Drag and drop to object--");
		Actions action = new Actions(driver);
	      try {
	          WebElement source = waitForAndGetElementByXpath(xpathSource);
	          WebElement target = waitForAndGetElementByXpath(xpathTarget);

	          action.dragAndDrop(source, target).build().perform();
	      } catch (StaleElementReferenceException e) {
	    	  System.out.println("drag and drop error!");
	      } 
	  }
    
}
