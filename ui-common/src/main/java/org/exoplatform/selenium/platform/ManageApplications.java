package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ManageApplications extends PlatformBase {
	
	//Gadget
	public static By ELEMENT_GADGET_LINK = By.xpath("//a[contains(text(),'Gadgets')]");
	public static By ELEMENT_ADD_REMOTE_GADGET_LINK = By.xpath("//div[text()='Add a Remote Gadget']");
	public static By ELEMENT_URL_TEXBOX = By.id("url");
	public static By ELEMENT_ADD_BUTTON = By.linkText("Add");

	
	public static void addRemoteGadget (String Url) {
		for (int i =0;; i++)
		{
			if (i > DEFAULT_TIMEOUT/WAIT_INTERVAL) 
			{
				Assert.fail("Timeout");
			}
			click(ELEMENT_ADD_REMOTE_GADGET_LINK);
			if (isElementPresent(ELEMENT_URL_TEXBOX))
			{
				type(ELEMENT_URL_TEXBOX, Url, true);
				click(ELEMENT_ADD_BUTTON);
				return;
			}
		}
	}
		public static void deleteGadget (String gadgetName) {
			waitForElementPresent(By.xpath("//a[@title='"+gadgetName+"']"));
			click(By.xpath("//a[@title='"+gadgetName+"']/following::a[@title='Delete Gadget']"));
			waitForConfirmation("Are you sure to delete this gadget?");
			pause(1000);
			waitForElementNotPresent(By.xpath("//a[@title='"+gadgetName+"']"));
			info("'"+gadgetName+"' was deleted successfully");
					
		}
}
