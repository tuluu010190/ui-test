package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.exoplatform.selenium.TestLogger.info;
/**
 * update : quynhpt
 * date: 0601/2014
 *
 */
public class SpaceManagement extends PlatformBase {
	
	// Add form space
	public final By ELEMENT_ADDNEWSPACE_BUTTON = By.xpath("//button[contains(.,'Add New Space')]");
	public final By ELEMENT_ADDNEWSPACE_FORM = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Add New Space']");
	
	//Search panel
	public final By ELEMENT_MY_SPACE_SEARCH_TEXT_BOX = By.xpath(".//*[@id='SpaceSearch']");
	public final By ELEMENT_MY_SPACE_SEARCH_BTN = By.xpath(".//*[@id='UISpaceSearch']//i[@class='uiIconSearch uiIconLightGray']");
	public final String ELEMENT_MY_SPACE_SEARCH_RESULT = ".//*[@id='UIManageMySpaces']//*[contains(text(),'${name}')]";
	public final String ELEMENT_MY_SPACE_SEARCH_RESULT_NUMBER = ".//*[@id='UIManageMySpaces']//*[@class='number'][text()='${number}']";
	
	//Letter list 
	public final String ELEMENT_MY_SPACE_LETTER_LIST= ".//*[@class='letterList']//*[text()='${alpha}']";
	
	//Space portlets
	public By ELEMENT_SPACE_MY_SPACE_PORTLET = By.id("UIMySpacesPortlet");
	public By ELEMENT_SPACE_ALL_SPACE_PORTLET = By.id("UIAllSpacesPortlet");
	public By ELEMENT_SPACE_INVITATION_SPACE_PORTLET = By.id("UIInvitationSpacesPortlet");
	public By ELEMENT_SPACE_PENDING_SPACE_PORTLET = By.id("UIPendingSpacesPortlet");

	//Add new space buttons
	public By ELEMENT_ADD_NEW_SPACE_BUTTON = By.xpath("//*[@class='uiIconSocSimplePlus uiIconSocWhite']");
	public By ELEMENT_ADD_SPACE_FORM = By.id("UIPopupAddSpace");

	//Add new space popup
	public final By ELEMENT_SPACE_NAME_INPUT = By.xpath("//input[contains(@name,'displayName')]");
	public final By ELEMENT_SPACE_DESCRIPTION_INPUT = By.xpath("//textarea[contains(@name,'description')]");

	
	//Access and Edit tab form
	public By ELEMENT_SPACE_ACCESS_EDIT_TAB=By.xpath("//*[@data-target='#UISpaceVisibility-tab']");
	public By ELEMENT_SPACE_VISIBILITY_VISIBLE_CHECKBOX=By.xpath("//*[@value='private']");
	public By ELEMENT_SPACE_VISIBILITY_HIDDEN_CHECKBOX=By.xpath("//*[@value='hidden']");
	public By ELEMENT_SPACE_REGISTRATION_OPEN_CHECKBOX=By.xpath("//*[@value='open']");
	public By ELEMENT_SPACE_REGISTRATION_CLOSED_CHECKBOX=By.xpath("//*[@value='close']");
	public By ELEMENT_SPACE_RESGISTRATION_VALIDATION_CHECKBOX=By.xpath("//*[@value='validation']");

	//Access and Edit tab form
	public By ELEMENT_SPACE_INVITE_GROUP_USER_TAB=By.xpath("//*[@data-target='#UISpaceGroupBound-tab']");
	public By ELEMENT_SPACE_SELECT_EXIST_GROUP_CHECKBOX=By.id("UseExistingGroupCheckBox");

	//Button create
	public By ELEMENET_SPACE_CREATE_BUTTON=By.xpath("//*[@class='uiAction']/*[text()='Create']");
	
	//Delete space
	public String ELEMENT_SPACE_TITLE="//*[@class='spaceTitle']//*[text()='${space}']";
	public String ELEMENT_SPACE_DELETE_BUTTON="//*[@class='spaceTitle']//*[text()='${space}']/../../..//*[text()='Delete']";
	public String ELEMENT_SPACE_CONFIRM_DELETE="Are you sure you want to delete this space? This cannot be undone. All page navigations and this group will also be deleted";
	public By ELEMENT_SPACE_DELETE_SPACE_OK_BUTTON=By.xpath("//*[text()='OK']");

	public String ELEMENT_SPACE_NAME_BREADCUMB ="//*[@id='UIBreadCrumbsNavigationPortlet']//*[@class='name' and contains(text(),'{$name}')]";
	
	//Invitations received tab
	public final By ELEMENT_MY_SPACE_INVITATION_RECEIVED = By.xpath(".//*[@id='UIManageMySpaces']//*[contains(text(),'Invitations Received')]");
	public final String ELEMENT_MY_SPACE_INVITATION_RECEIVED_ACCEPT_BTN = ".//*[contains(text(),'${space}')]/../..//button[text()='Accept']";
	public final String ELEMENT_MY_SPACE_INVITATION_RECEIVED_CANCEL_BTN = ".//*[contains(text(),'${space}')]/../..//button[text()='Ignore']";
	
	//All Spaces tab
	public final By ELEMENT_MY_SPACE_ALL_SPACES_TAB = By.xpath(".//*[@id='UIManageMySpaces']//*[contains(text(),'All Spaces')]");
	public final String ELEMENT_MY_SPACE_ALL_SPACES_REQUEST_TO_JOIN_BTN = ".//*[contains(text(),'${space}')]/../..//button[text()='Request to Join']";
	public final String ELEMENT_MY_SPACE_ALL_SPACES_REQUEST_PENDING = ".//*[contains(text(),'${space}')]/../..//*[contains(text(),'Request Pending')]";
	
	//Request pending tab
	public final By ELEMENT_MY_SPACE_REQUEST_PENDING_TAB = By.xpath(".//*[contains(text(),'Requests Pending')]");
	
	ManageAlert alert;
	Button button;
	Dialog dialog;
	
	/**
	 * constructor
	 * @param dr
	 */
	public SpaceManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
		dialog = new Dialog(driver);
	}

	/**
	 * Open create space form
	 */
	public void goToCreateSpace(){
		info("Open create space form");
		click(ELEMENT_ADD_NEW_SPACE_BUTTON);
		waitForAndGetElement(ELEMENT_ADD_SPACE_FORM);
	}
	
/**
 * delete Space
 * @param spaceName
 * 					name of space
 * @param isVerify
 * 					true: verify content of confirm msg
 * 					false: not verify content of confirm msg
 */
	public void deleteSpace(String spaceName, Boolean isVerify){
		info("Do create space");
		click(ELEMENT_SPACE_DELETE_BUTTON.replace("${space}", spaceName));
		if(isVerify)
			alert.verifyAlertMessage(ELEMENT_SPACE_CONFIRM_DELETE);
		click(ELEMENT_SPACE_DELETE_SPACE_OK_BUTTON);
		waitForElementNotPresent(ELEMENT_SPACE_DELETE_BUTTON.replace("${space}", spaceName),60000);
		
	}


	/**
	 * Create quickly a new space
	 * 
	 * @param name : Space name
	 * @param desc : Space description
	 * 
	 */
	public void addNewSpaceSimple(String name, String desc, int... params) {
		int iTimeout = params.length > 0 ? params[0] : DEFAULT_TIMEOUT; 
		if (waitForAndGetElement(ELEMENT_ADDNEWSPACE_BUTTON, 3000, 0, 2) != null){
			click(ELEMENT_ADDNEWSPACE_BUTTON);
		}else {
			click(By.xpath("//*[contains(@class, 'uiIconSocSimplePlus')]"));
		}
		waitForAndGetElement(ELEMENT_ADDNEWSPACE_FORM,3000,0);
		type(ELEMENT_SPACE_NAME_INPUT, name, true);
		type(ELEMENT_SPACE_DESCRIPTION_INPUT, desc, true);
		info("Save all changes");
		click(ELEMENET_SPACE_CREATE_BUTTON);
		waitForAndGetElement(By.linkText(name), iTimeout);
		/*if(waitForAndGetElement("//span[contains(text(),'More')]",iTimeout,0) == null){
			click(By.linkText(name));
			waitForAndGetElement("//span[contains(text(),'More')]",iTimeout,0);
		}*/
	}
	/**
	 * Search a space by name or description
	 * @param name
	 * @param number
	 */
	public void searchSpace(String name, String number){
		info("Waiting my space is shown");
		waitForAndGetElement(ELEMENT_MY_SPACE_SEARCH_TEXT_BOX,3000,0);
		info("Input the space into search text box");
		type(ELEMENT_MY_SPACE_SEARCH_TEXT_BOX,name,true);
		info("Click on Search button");
		click(ELEMENT_MY_SPACE_SEARCH_BTN);
		if(!name.isEmpty()){
			info("Verify that the space is shown in the search result");
			waitForAndGetElement(ELEMENT_MY_SPACE_SEARCH_RESULT.replace("${name}", name),3000,0);
		}
		if(!number.isEmpty()){
			info("Verify that the number of search result is shown correctly");
			waitForAndGetElement(ELEMENT_MY_SPACE_SEARCH_RESULT_NUMBER.replace("${number}", number),3000,0);
		}
	}
    /**
     * Click on an alpha in the list
     * @param alpha
     * @param name
     */
	public void searchByLetterList(String alpha,String name){
		info("Waiting my space is shown");
		waitForAndGetElement(ELEMENT_MY_SPACE_LETTER_LIST.replace("${alpha}", alpha),3000,0);
		info("click on the alpha");
		click(ELEMENT_MY_SPACE_LETTER_LIST.replace("${alpha}", alpha));
		info("Verify that the space is shown in the search result");
		waitForAndGetElement(ELEMENT_MY_SPACE_SEARCH_RESULT.replace("${name}", name),3000,0);
	}
	/**
	 * Open Invitations received tab
	 */
	public void goToInvitationsReceivedTab(){
		info("Open Invitation Received tab");
		waitForAndGetElement(ELEMENT_MY_SPACE_INVITATION_RECEIVED,3000,0);
		click(ELEMENT_MY_SPACE_INVITATION_RECEIVED);
		Utils.pause(2000);
	}
	/**
	 * Open All Spaces tab
	 */
	public void goToAllSpacesTab(){
		info("Open All spaces tab");
		waitForAndGetElement(ELEMENT_MY_SPACE_ALL_SPACES_TAB,3000,0);
		click(ELEMENT_MY_SPACE_ALL_SPACES_TAB);
		Utils.pause(2000);
	}
	
	/**
	 * Send a request to a space
	 * @param space
	 */
	public void sendARequestToASpace(String space){
		info("Send a request to a space");
		waitForAndGetElement(ELEMENT_MY_SPACE_ALL_SPACES_REQUEST_TO_JOIN_BTN.replace("${space}", space),2000,0).click();
		info("Verify that request to join button is hidden and request pending status is shown");
		waitForAndGetElement(ELEMENT_MY_SPACE_ALL_SPACES_REQUEST_PENDING.replace("${space}", space),3000,0);
	}
	/**
	 * Open request pending tab
	 */
	public void goToRequestPendingTab(){
		info("Open Request pending tab");
		//waitForAndGetElement(ELEMENT_MY_SPACE_REQUEST_PENDING_TAB,3000,0);
		click(ELEMENT_MY_SPACE_REQUEST_PENDING_TAB);
		Utils.pause(2000);
	}
}
