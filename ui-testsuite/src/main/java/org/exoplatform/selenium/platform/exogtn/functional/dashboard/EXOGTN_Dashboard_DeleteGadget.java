package org.exoplatform.selenium.platform.exogtn.functional.dashboard;

import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.goToDashboard;
import static org.exoplatform.selenium.platform.DashBoard.*;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *@author NhungVT
 *@date: 28/09/2012
 */

public class EXOGTN_Dashboard_DeleteGadget extends PlatformBase 
{
	//Define data
	public String GADGET_NAME = "Agenda Gadget";
	public String GADGET_TITLE_DISPLAY = "My Agenda";
	public By GADGET_DIRECTORY_LIST = By.xpath("//div[@class='UIPopupWindow UIDragObject NormalStyle']");
	public By AGENDA_GADGET_ON_LIST = By.xpath("//div[@class='GadgetTitle' and @title='"+GADGET_NAME+"']");

	public void deleteGadgetOnDashboard(String gadgetTitleDisplay)
	{
		String action = "Delete Gadget";
		By deleteGadgetIcon = By.xpath("//span[text()='"+gadgetTitleDisplay+"']/preceding::span[@title='"+action+"']");
		waitForAndGetElement(deleteGadgetIcon);
		click(deleteGadgetIcon);
		waitForConfirmation("Are you sure to delete this gadget?");
		waitForTextNotPresent(gadgetTitleDisplay);
	}
	
	@BeforeMethod()
	public void beforeTest()
	{
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
	}
	
	//Delete gadget with  deleting confirmation
	@Test()
	public void test01_DeleteGadgetWithConfirmation()
	{		
		//Goto DashBoard
		goToDashboard();
		waitForTextPresent(MESSAGE_DRAG_GADGETS_HERE);

		//Click on Add Gadgets link
		waitForElementPresent(ELEMENT_ADD_GADGETS_LINK);
		click(ELEMENT_ADD_GADGETS_LINK);
		waitForElementPresent(GADGET_DIRECTORY_LIST);

		//Drag My Agenda Gadget on list and Drop into Container
		waitForTextPresent("Collaboration");
		actions.dragAndDropBy(waitForAndGetElement(AGENDA_GADGET_ON_LIST), 2, 2).build().perform();
		waitForTextPresent(GADGET_TITLE_DISPLAY);
		waitForElementPresent(ELEMENT_CLOSE_WINDOW);
		click(ELEMENT_CLOSE_WINDOW);
		
		//Delete data
		deleteGadgetOnDashboard(GADGET_TITLE_DISPLAY);
	}
	
	@AfterMethod()
	public void afterTest()
	{
		signOut();
		driver.quit();
	}
}