package org.exoplatform.selenium.platform.ecms;

import static org.exoplatform.selenium.TestLogger.info;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContextMenu extends EcmsBase {

	public ContextMenu(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public final By ELEMENT_MENU_LOCK = By.xpath("//a[contains(text(),'Lock')]");
	public final By ELEMENT_MENU_UNLOCK = By.xpath("//a[contains(text(),'UnLock')]");
	public final By ELEMENT_MENU_CHECKIN = By.xpath("//a[contains(text(),'CheckIn')]");
	public final By ELEMENT_MENU_CHECKOUT = By.xpath("//a[contains(text(),'CheckOut')]");
	public final By ELEMENT_MENU_RENAME_NODE = By.linkText("Rename");
	public final By ELEMENT_MENU_PASTE = By.xpath("//a[contains(text(),'Paste')]");
	public final By ELEMENT_MENU_REFRESH=By.xpath("//a[@title='refresh']");
	public final By ELEMENT_MENU_DELETE = By.xpath("//a[contains(text(),'Delete')]");
	public final By ELEMENT_MENU_EDIT_ITEM = By.xpath("//a[@class='ItemIcon DefaultAction16x16Icon EditDocument16x16Icon']");
	public final By ELEMENT_MENU_ADD_SYMLINK = By.xpath("//div[@class='MenuItem']/a[contains(text(),'Add Symlink')]");
	
	//Lock node
	public void lockNode(By locator){
		for(int repeat=0;; repeat ++)
		{
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform this action after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_MENU_LOCK, 5000, 0) != null) {
				click(ELEMENT_MENU_LOCK);
				break;
			}
			pause(WAIT_INTERVAL);
			info("Retry...[" + repeat + "]");
		}
	}

	//Check node is being locked
	public boolean checkLockNode(Object locator){
		boolean locked=false;
		By by = locator instanceof By ? (By)locator : By.xpath((String)locator);
		//		actions.contextClick(unlock).build().perform();
		try{
			rightClickOnElement(by);
			pause(500);
			if (isElementPresent(ELEMENT_MENU_UNLOCK)) {
				locked = true;
			} else 
				locked =false;

			WebElement unlock = waitForAndGetElement(by);
			unlock.sendKeys(Keys.RETURN);
		} catch(StaleElementReferenceException e){
			checkCycling(e, 10);
			checkLockNode(locator);
		} finally{			
			loopCount=0;			
		}
		return locked;
	}

	//	Check-in a node
	public void checkInNode(By locator){
		for(int repeat=0;; repeat ++)
		{
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform this action after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_MENU_CHECKIN, 5000, 0) != null){
				click(ELEMENT_MENU_CHECKIN);
				info("Node is checked in successfully");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
	}

	//Check out a node
	public void checkOutNode(By locator){
		for(int repeat=0;; repeat ++)
		{
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform this action after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_MENU_CHECKOUT, 5000, 0) != null){
				click(ELEMENT_MENU_CHECKOUT);
				info("Node is checked out successfully");
				break;
			}
			info("Retry...[" + repeat + "]");
		}
	}  

	//Delete a node at level 1
	public void deleteDocument(By locator, int...timeout){
		int iTimeout = timeout.length > 0 ? timeout[0] : DEFAULT_TIMEOUT;
		for(int repeat=1;; repeat ++)
		{
			if (repeat > ACTION_REPEAT) {
				Assert.fail("Cannot perform this action after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(locator);
			info("Before displaying " + repeat);
			if (waitForAndGetElement(ELEMENT_MENU_DELETE, 10000, 0)!=null) 
			{	
				info("Element is displayed ");
				click(ELEMENT_MENU_DELETE);
				waitForTextPresent("Confirm Deletion");
				click(By.linkText("OK"));
				break;
			}
			info("Retry...[" + repeat + "]");

		}
		waitForElementNotPresent(By.linkText("OK"));
		//click(ELEMENT_MENU_REFRESH);
		waitForElementNotPresent(locator, iTimeout);
		info(locator.toString() + "is deleted successfully");		
	}

	//Unlock a node
	public void unLockNode(By locator){
		for(int repeat=0;; repeat ++)
		{
			if (repeat >= ACTION_REPEAT) {
				Assert.fail("Cannot perform this action after " + ACTION_REPEAT + " tries");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_MENU_UNLOCK, 5000, 0) != null) {
				click(ELEMENT_MENU_UNLOCK);
				break;
			}
			pause(WAIT_INTERVAL);
			info("Retry...[" + repeat + "]");
		}
	}

	//	Paste a node
	public void pasteNode(By locator) {
		for (int i =0;; i++){
			if (i > ACTION_REPEAT){
				Assert.fail("Timeout");
			}
			rightClickOnElement(locator);
			if (waitForAndGetElement(ELEMENT_MENU_PASTE, 5000, 0) != null){
				click(ELEMENT_MENU_PASTE);
				return;
			}
			pause(WAIT_INTERVAL);
		}
	}
}
