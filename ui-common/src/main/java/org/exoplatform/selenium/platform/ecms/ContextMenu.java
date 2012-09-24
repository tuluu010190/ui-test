package org.exoplatform.selenium.platform.ecms;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContextMenu extends EcmsBase {

	//lock node
	public static void lockNode(By locator){
//		WebElement lock = waitForAndGetElement(locator);
//		actions.contextClick(lock).build().perform();
		rightClickOnElement(locator);
		click(ELEMENT_LOCK_OPTION_XPATH);
	}

	//check node is being locked
	public static boolean checkLockNode(Object locator){
		boolean locked;
		By by = locator instanceof By ? (By)locator : By.xpath((String)locator);
//		actions.contextClick(unlock).build().perform();
		rightClickOnElement(by);
		pause(500);
		if (isElementPresent(ELEMENT_UNLOCK_OPTION_XPATH)) {
			locked = true;
		} else 
			locked =false;
		WebElement unlock = waitForAndGetElement(by);
		unlock.sendKeys(Keys.RETURN);
		return locked;
	}
	
	 //check in a node
    public static void checkInNode(By locator){
            rightClickOnElement(locator);
            WebElement in = waitForAndGetElement(ELEMENT_CHECKIN_OPTION_XPATH);
            if (in !=null){
                    click(ELEMENT_CHECKIN_OPTION_XPATH);
                    info("Check in node successfully");
            }else{
                    info("Node has checked in or can not check in");
            }
    }
    
    //check out a node
    public static void checkOutNode(By locator){
            rightClickOnElement(locator);
            WebElement out = waitForAndGetElement(ELEMENT_CHECKOUT_OPTION_XPATH);                
            if (out !=null){
                    click(ELEMENT_CHECKOUT_OPTION_XPATH);
                    info("Check out node successfully");
            }else{
                    info("Node has checkout or can not chekout");
            }
    }
    
	
	//delete level 1 node
	public static void deleteDocument(By locator, int...timeout){
		int iTimeout = timeout.length > 0 ? timeout[0] : DEFAULT_TIMEOUT;
		for(int repeat=0;; repeat ++)
		{
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perfotrm this action after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_PARTIALLINK_DELETE_DOCUMENT) != null) break;
			info("Retry...[" + repeat + "]");
		}
		mouseOver(ELEMENT_PARTIALLINK_DELETE_DOCUMENT, true);
		click(ELEMENT_PARTIALLINK_DELETE_DOCUMENT);
		click(By.linkText("OK"));
		info(locator.toString() + "was deleted successfully");
		waitForElementNotPresent(locator, iTimeout);
	}
	
	//Define common function
	public static void unLockNode(By locator){
		rightClickOnElement(locator);
		click(ELEMENT_UNLOCK_OPTION_XPATH);
	}
}
