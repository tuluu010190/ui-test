package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * @author HangNTT
 * date: 23/10/2013
 */
public class HomePageGadget extends PlatformBase{

	//-------Invitation Gadget --------
	public By ELEMENT_INVITATION_GADGET = By.xpath("//div[@id='InvitationsPortlet']");
	public String ELEMENT_SHOW_CONNECTIONS_REQUEST_USER = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteName']//div[text()='${nameinvitation}']";
	public String ELEMENT_SHOW_CONNECTIONS_REQUEST_SPACE= "//div[@id='InvitationsPortlet']//div[@class='spaceInviteInfo']//div[text()='${namespace}']";
	public String ELEMENT_VERIFY_STATUS_SPACE = "//div[@id='InvitationsPortlet']//div[@class='spaceInviteInfo']//div[text()='${namespace}']/../div[@class='spaceproperties']/div[@class='spacevisibility' and contains(text(),'${statusspace}')]";
	public String ELEMENT_SHOW_ACCETPS_BUTTON = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteInfo']//div[text()='${peopleName}']/..//a[text()='Accept']";
	public String ELEMENT_REMOVE_INVITATION_BUTTON = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteInfo']//div[text()='${peopleName}']/..//i[@class='uiIconClose']";
	public String ELEMENT_TITLE_OF_GAGDET = "//div[@id='InvitationsPortlet']/..//span[text()='${number}']";

	/**
	 * Accept an invitation
	 * @param peopleName
	 */
	public void acceptInvitationGadget(String peopleName) {
		info("-- Accept an invitation --");
		mouseOver(ELEMENT_SHOW_ACCETPS_BUTTON.replace("${peopleName}", peopleName),true);
		WebElement element = waitForAndGetElement(ELEMENT_SHOW_ACCETPS_BUTTON.replace("${peopleName}", peopleName), DEFAULT_TIMEOUT,1,2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		//click(SHOW_ACCETPS_BUTTON.replace("${peopleName}", peopleName));
		waitForElementNotPresent(ELEMENT_SHOW_ACCETPS_BUTTON.replace("${peopleName}", peopleName));
		//waitForAndGetElement(REMOVE_INVITATION_BUTTON.replace("${peopleName}", peopleName));
	}
	
	/**
	 * Remove an invitation
	 * @param peopleName
	 */
	public void removeInvitationGadget(String peopleName){
		info("-- Remove an invitation --");
		//mouseOver(REMOVE_INVITATION_BUTTON.replace("${peopleName}", peopleName),true);
		WebElement element = waitForAndGetElement(ELEMENT_REMOVE_INVITATION_BUTTON.replace("${peopleName}", peopleName), DEFAULT_TIMEOUT,1,2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		//click(REMOVE_INVITATION_BUTTON.replace("${peopleName}", peopleName));
		waitForElementNotPresent(ELEMENT_REMOVE_INVITATION_BUTTON.replace("${peopleName}", peopleName));
	}
}