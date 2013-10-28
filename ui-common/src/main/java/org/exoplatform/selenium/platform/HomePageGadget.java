package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author HangNTT
 * date: 23/10/2013
 */
public class HomePageGadget extends PlatformBase{

	//-------Invitation Gadget --------
	public By ELEMENT_INVITATION_GADGET = By.id("InvitationsPortlet");
	public String ELEMENT_SHOW_CONNECTIONS_REQUEST_USER = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteName']//div[text()='${nameinvitation}']";
	public String ELEMENT_SHOW_CONNECTIONS_REQUEST_SPACE= "//div[@id='InvitationsPortlet']//div[@class='spaceInviteInfo']//div[text()='${namespace}']";
	public String ELEMENT_VERIFY_STATUS_SPACE = "//div[@id='InvitationsPortlet']//div[@class='spaceInviteInfo']//div[text()='${namespace}']/../div[@class='spaceproperties']/div[@class='spacevisibility' and contains(text(),'${statusspace}')]";
	public String ELEMENT_SHOW_ACCETPS_BUTTON = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteInfo']//div[text()='${peopleName}']/..//a[text()='Accept']";
	public String ELEMENT_REMOVE_INVITATION_BUTTON = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteInfo']//div[text()='${peopleName}']/..//i[@class='uiIconClose']";
	public String ELEMENT_TITLE_OF_GAGDET = "//div[@id='InvitationsPortlet']/..//span[text()='${number}']";

	//-------Getting Started Gadget -------- 
	public By ELEMENT_GETTING_STARTED_GADGET_FORM = By.id("GettingStartedContainer");
	public By ELEMENT_PROFILE_PICTURE = By.linkText("Add a profile picture");
	public By ELEMENT_CONNECT_TO_COWORKERS = By.linkText("Connect to coworkers");
	public By ELEMENT_JOIN_A_SPACE = By.linkText("Join a space");
	public By ELEMENT_POST_AN_ACTIVITY = By.linkText("Post an activity");
	public By ELEMENT_UPLOAD_A_DOCUMENT = By.linkText("Upload a document");
	public By ELEMENT_PROFILE_PAGE = By.id("UIProfilePortlet");
	public By ELEMENT_ALL_PEOPLE = By.id("UIAllPeoplePortlet");
	public By ELEMENT_ALL_SPACE = By.id("UIAllSpacesPortlet");
	public By ELEMENT_PERSONAL_DOCUMENT = By.id("UIJCRExplorer");
	public String ELEMENT_FINISH_UPLOAD_FILE = "//ul[@id='gsList']//li[@class='${status}']/a[text()='Upload a document']";
	public String ELEMENT_FINISH_JOIN_TO_SPACE = "//ul[@id='gsList']//li[@class='${status}']/a[text()='Join a space']";
	public By ELEMENT_INPROGRESS_COMPLETE = By.xpath("//div[@id='progress-block']//div[@id='progress-rate']/../../div[@id='progress-label' and contains(text(),'100 %')]");
	public By ELEMENT_CLOSE_GADGET_GETTING_STARTED = By.xpath("//div[@id='DeleteLink']//button[text()='Close']");

	public HomePageGadget(WebDriver dr) {
		driver = dr;
	}

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