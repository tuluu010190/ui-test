package org.exoplatform.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestBase {
  protected static WebDriver driver;
  protected static Actions actions ;
  protected String baseUrl;
  protected StringBuffer verificationErrors = new StringBuffer();
  protected static int timeoutSecInt = 10;
  private    int seconds = 0;
  public static     int loopCount = 0;	
  protected  boolean ieFlag;	 
  protected  boolean chromeFlag;

  public static String ELEMENT_SIGN_IN_LINK = "//b[contains(text(),'Sign in')]";
  public static String ELEMENT_INPUT_USERNAME = "//input[@name='username']";
  public static String ELEMENT_INPUT_PASSWORD = "//input[@name='password']";
  public static String ELEMENT_SIGN_IN_CONFIRM_BUTTON = "//form[@id='UIPortalComponentLogin']//div[@class='UIAction']/*";
  public static String ELEMENT_SEARCH_ICON_REGISTER = "//img[@class='SearchIcon']";
  public static String ELEMENT_SAVE_BUTTON = "//a[text()='Save']";
  public static String ELEMENT_MESSAGE_DIALOG_CLOSE_ICON = "//div[contains(@class, 'UIPopupWindow') and contains(@style, 'visibility: visible')]//span[text()='Messages']/..//a[@class='CloseButton']";

  public static String ELEMENT_INPUT_CONFIRM_PASSWORD = "//input[@id='Confirmpassword']";
  public static String ELEMENT_INPUT_NEW_PASSWORD = "//input[@id='newPassword']";
  public static String ELEMENT_INPUT_NEW_CONFIRM_PASSWORD = "//input[@id='confirmPassword']";
  public static String ELEMENT_INPUT_FIRSTNAME = "//input[@id='firstName']";
  public static String ELEMENT_INPUT_LASTNAME = "//input[@id='lastName']";
  public static String ELEMENT_INPUT_EMAIL = "//input[@id='email']";   
  public static String ELEMENT_LINK_SetUp ="//img[@alt='Setup']";
  public static String ELEMENT_LINK_Users ="//a[text()='Users']";
  public static String ELEMENT_LINK_AddUsers="//a[text()='Add Users']";

  public static String ELEMENT_PAGINATOR_PAGE_LINK = "//a[contains(@class, 'Number') and text()='${number}']";
  public static String ELEMENT_PAGINATOR_TOTAL_NUMBER = "//a[@class='PagesTotalNumber']";
  public static String ELEMENT_PAGINATOR_NEXT_ICON = "//a[@class='Icon NextPageIcon']";
  public static String ELEMENT_PAGINATOR_SELECTED_PAGE = "//a[@class='Number PageSelected' and text()='${number}']";

  public static String ELEMENT_LINK_PORTAL_TOP_CONTAINER = "//ul[contains (@id, 'PortalNavigationContainer')]/..";
  public static String ELEMENT_SIGN_OUT_LINK = "//a[@class='LogoutIcon']";
  public static String ELEMENT_MESSAGE_TEXT = "//li[@class='MessageContainer']/span[contains(@class, 'PopupIcon')]";
  public static String ELEMENT_MESSAGE_DIALOG_CLOSE_ICON_IE = ELEMENT_MESSAGE_TEXT + "/../../../../../..//a";
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
    
	  public void setup(){
			ieFlag = "true".equals(System.getProperty("selenium.browser"));
			chromeFlag = "true".equals(System.getProperty("selenium.browser"));
		}

		/*public static void log(String msg) {
			StackTraceElement callerClass = Thread.currentThread().getStackTrace()[2];
			log(String.format("%-100s%s", "[" + callerClass.getClassName() + "." + callerClass.getMethodName() + "]", msg).replaceAll("  ", ".."));
		}*/

		public static void checkCycling(Exception e, int loopCountAllowed) {
			System.err.println(e.getClass());
			if (loopCount > loopCountAllowed) {
				Assert.fail("Cycled: " + e.getMessage());
			}
			loopCount++;
		}

		public static void click(String locator) {
			try {
				WebElement element = waitForAndGetElement(locator);
				actions.click(element).perform();
			} catch (StaleElementReferenceException e) {
				checkCycling(e, 5);
				pause(1000);
				click(locator);
			} finally {
				loopCount = 0;
			}
		}


		public void copyPaste(String Source, String value, String Target){ 	
			WebElement element = waitForAndGetElement(Source);
			element.sendKeys(value);
			actions.doubleClick(element).perform();
			element.sendKeys(Keys.LEFT_CONTROL + "a");
			element.sendKeys(Keys.LEFT_CONTROL + "c");
			pause(3000);
			WebElement b = waitForAndGetElement(Target);
			b.sendKeys(Keys.LEFT_CONTROL + "v");
			/*WebElement element=waitForAndGetElement(Source);
	  	  actions.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  	  WebElement element1=waitForAndGetElement(Target);
	  	  actions.contextClick(element1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			 */

		}

		public void closeMessageDialog() {
			//log("--Closing message dialog--");
			setup();
			if (ieFlag) {
				click(ELEMENT_MESSAGE_DIALOG_CLOSE_ICON_IE);
			} else {
				click(ELEMENT_MESSAGE_DIALOG_CLOSE_ICON);
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
				checkCycling(e, 5);
				pause(100);
				check(locator);
			} finally {
				loopCount = 0;
			}
		}

//		public  String getText(String locator) {
//			WebElement element = null;
//			try {
//				element = waitForAndGetElement(locator);
//				return element.getText();
//			} catch (StaleElementReferenceException e) {
//				checkCycling(e, 5);
//				pause(100);
//				return getText(locator);
//			} finally {
//				loopCount = 0;
//			}
//		}

		public static  String getValue(String locator) {
			try {
				return waitForAndGetElement(locator).getAttribute("value");
			} catch (StaleElementReferenceException e) {
				checkCycling(e, 5);
				pause(100);
				return getValue(locator);
			} finally {
				loopCount = 0;
			}
		}

		public void goToNewStaff() {
			//log("Go to New Staff");
			goToPage(ELEMENT_SEARCH_ICON_REGISTER, ELEMENT_LINK_SetUp, ELEMENT_LINK_Users, ELEMENT_LINK_AddUsers);
		}
		
		private static String makeLink(String node) {
			if (!node.contains("//")) {
				String label = node;
				node = "//a[text()='" + label + "']";
			}
			return node;
		}

		public void goToPage(String verification, String... navigation) {
			String page = makeLink(navigation[navigation.length - 1]);
			boolean needToBeVerified = true;

			List<String> navigationList = new ArrayList<String>();

			for (int i = 0; i < (navigation.length - 1); i++) {
				String node = navigation[i];
				node = makeLink(node);
				navigationList.add(node);
			}

			try {
				for (String node : navigationList) {
					if (ieFlag) {
						actions.moveToElement(getElement(node));
					} else {
						mouseOver(node, false);
					}
				}
				mouseOverAndClick(page);
			} catch (StaleElementReferenceException e) {
				checkCycling(e, 10);
				goToPage(verification, navigation);
				needToBeVerified = false;
			} finally {
				loopCount = 0;
			}

			if (verification != null && needToBeVerified) {
				pause(500);
				verifyLocation(verification, navigationList, page);
			}
		}


		public  void mouseOver(String locator, boolean safeToSERE) {
			if (safeToSERE) {
				try {
					WebElement element = waitForAndGetElement(locator);
					actions.moveToElement(element).perform();
				} catch (StaleElementReferenceException e) {
					checkCycling(e, 5);
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
			setup();
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
						WebElement loading = driver.findElement(By.xpath("//div[@id='AjaxLoadingMask']"));
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
			//log("--Verify message: " + message);
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
				checkCycling(e, 5);
				pause(1000);
				type(locator, value, validate);
			} finally {
				loopCount = 0;
			}
		}

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
				checkCycling(e, 7);
				pause(1000);
				select(locator, option);
			} finally {
				loopCount = 0;
			}
		}

		public void save() {
			waitForAndGetElement(ELEMENT_SAVE_BUTTON);
			click(ELEMENT_SAVE_BUTTON);
		}

		public void signInAsRoot() {
			signIn("root", "gtn");
		}

		public static void signIn(String username, String password) {
	    //log("--Sign in as " + username + "--");
			click(ELEMENT_SIGN_IN_LINK);
			type(ELEMENT_INPUT_USERNAME, username, true);
			type(ELEMENT_INPUT_PASSWORD, password, true);
			click(ELEMENT_SIGN_IN_CONFIRM_BUTTON);
			waitForElementNotPresent(ELEMENT_SIGN_IN_CONFIRM_BUTTON);
		}

		public void signOut(){
			Actions action_logout = new Actions(driver);
			WebElement UI = driver.findElement(By.id("UserNavigationTabsContainer"));
			action_logout.moveToElement(UI).build().perform();
			driver.findElement(By.linkText("Logout")).click();	
		}

		private  void verifyLocation(String locator, List<String> navigation, String page) {
			//log("verifyLocation, element: " + locator);
			setup();
			if (isElementNotPresent(locator)) {
				pause(1000);
			}
			for (; isElementNotPresent(locator); seconds++) {
				if (seconds >= timeoutSecInt) {
					Assert.fail("Timeout at goToPage");
				}
				pause(500);
				try {
					for (String node : navigation) {
						if (ieFlag) {
							actions.moveToElement(getElement(locator));
						} else {
							mouseOver(node, false);
						}
					}
					mouseOverAndClick(page);
				} catch (StaleElementReferenceException e) {
					checkCycling(e, 10);
					verifyLocation(locator, navigation, page);
					break;
				} finally {
					loopCount = 0;
				}
			}
			seconds = 0;
		}

		public void usePaginator(String locator, String exceptionMessage) {
			String page1 = ELEMENT_PAGINATOR_PAGE_LINK.replace("${number}", "1");

			click(page1);
			pause(500);
			int totalPages = isElementPresent(ELEMENT_PAGINATOR_TOTAL_NUMBER) ? Integer.valueOf(getText(ELEMENT_PAGINATOR_TOTAL_NUMBER)) : 1;
			int i = 1;
			while (isElementNotPresent(locator)) {
				if (i == totalPages) {
					Assert.fail(exceptionMessage);
				}
				click(ELEMENT_PAGINATOR_NEXT_ICON);
				waitForAndGetElement(ELEMENT_PAGINATOR_SELECTED_PAGE.replace("${number}", String.valueOf((++i))));
				pause(500);
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
	  
}
