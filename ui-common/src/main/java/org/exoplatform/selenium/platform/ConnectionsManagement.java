package org.exoplatform.selenium.platform;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.exoplatform.selenium.TestLogger.info;

public class ConnectionsManagement extends PlatformBase {

	public final By ELEMENT_CONNECTION_EVERYONE_TITLE=By.xpath(".//*[@id='UIAllPeople']//*[contains(text(),'Contacts Directory')]");
    public final String ELEMENT_CONNECTION_CONNECT_BTN = "//a[contains(@href,'${user}')]/../..//*[text()='Connect']";
	public final String ELEMENT_CONNECTION_CANCEL_BTN = "//a[contains(@href,'${user}')]/../..//*[text()='Cancel Request']";
	public final String ELEMENT_CONNECTION_REVOVE_BTN = "//a[contains(@href,'${user}')]/../..//*[text()='Remove Connection']";
    public final String ELEMENT_CONNECTION_IGNORE_BTN =" //a[contains(@href,'${user}')]/../..//*[text()='Ignore']";
    public final String ELEMENT_CONNECTION_CONFIRM_BTN =" //a[contains(@href,'${user}')]/../..//*[text()='Confirm']";
    public final String ELEMENT_CONNECTION_USER_AVARTAR="//a[contains(@href,'${user}')]/img";
    public final String ELEMENT_CONNECTION_USER_NAME="//a[contains(@href,'${user}') and @data-key='title']";
    
    public final By ELEMENT_ALL_CONNECTIONS_TAB=By.xpath("//*[@id='UIConnectionsPortlet' or @id='UIAllPeoplePortlet']//*[contains(@href,'all-people')]");
    public final By ELEMENT_MY_CONNECTIONS_TAB = By.xpath("//*[@id='UIConnectionsPortlet' or @id='UIAllPeoplePortlet']//*[contains(@href,'network')]");
    public final By ELEMENT_REQUEST_RECEIVE_CONNECTIONS_TAB = By.xpath("//*[@id='UIConnectionsPortlet' or @id='UIAllPeoplePortlet']//*[contains(@href,'receivedInvitations')]");
    public final By ELEMENT_REQUEST_PENDING_CONNECTIONS_TAB = By.xpath("//*[@id='UIConnectionsPortlet' or @id='UIAllPeoplePortlet']//*[contains(@href,'pendingRequests')]");
    
    public final By ELEMENT_ALL_RESULTS = By.id("searchAll");
    public final By ELEMENT_NAME_OF_PEOPLE = By.id("name");
    public final By ELEMENT_POSITIONS_OF_PEOPLE = By.id("position");
    public final By ELEMENT_SKILL_OF_PEOPLE = By.id("skills");
    public final By ELEMENT_SEARCH_BUTTON = By.id("SearchButton");
    
    public ConnectionsManagement(WebDriver dr){
		driver = dr;
	}

    /**
     * Connect to a user
     * @param username
     */
    public void connectToAUser(String username){
    	info("--Connect to a user--");
    	info("Click on connect button");
    	searchPeople(username,null,null,null);
    	click(ELEMENT_CONNECTION_CONNECT_BTN.replace("${user}",username));
    	waitForAndGetElement(ELEMENT_CONNECTION_CANCEL_BTN.replace("${user}",username),2000,0);
    	info("Connected to the user");
    }
    
    /**
     * Remove a connection of user
     * @param username
     */
    public void removeConnection(String username){
    	info("--Remove a connection of a user--");
    	info("Click on remove button");
    	searchPeople(username,null,null,null);
    	click(ELEMENT_CONNECTION_REVOVE_BTN.replace("${user}",username));
    	waitForAndGetElement(ELEMENT_CONNECTION_CONNECT_BTN.replace("${user}",username),2000,0);
    	info("Removed to the user");
    }
    /**
     * Cancel a connection to a user
     * @param username
     */
    public void cancelConnection(String username){
    	info("--Cancel a connection of a user--");
    	info("Click on Cancel button");
    	searchPeople(username,null,null,null);
    	click(ELEMENT_CONNECTION_CANCEL_BTN.replace("${user}",username));
    	waitForAndGetElement(ELEMENT_CONNECTION_CONNECT_BTN.replace("${user}",username),2000,0);
    	info("Canceled to the user");
    }
    /**
     * Ignore a connection that is sent from a user
     * @param username
     */
    public void ignoreConnection(String username){
    	info("--Ignore a connection of a user--");
    	info("Click on Ignore button");
    	searchPeople(username,null,null,null);
    	click(ELEMENT_CONNECTION_IGNORE_BTN.replace("${user}",username));
    	waitForAndGetElement(ELEMENT_CONNECTION_CONNECT_BTN.replace("${user}",username),2000,0);
    	info("Connected to the user");
    }
    /**
     * Reset all connections to default status
     * @param username
     */
    public void resetConnection(String username){
    	searchPeople(username,null,null,null);
    	if(waitForAndGetElement(ELEMENT_CONNECTION_REVOVE_BTN.replace("${user}",username),3000,0)!=null)
    		removeConnection(username);
       if(waitForAndGetElement(ELEMENT_CONNECTION_CANCEL_BTN.replace("${user}",username),3000,0)!=null)
    	   cancelConnection(username);
       if(waitForAndGetElement(ELEMENT_CONNECTION_IGNORE_BTN.replace("${user}",username),3000,0)!=null)
    	   ignoreConnection(username);
	}
    /**
     * Accept a connection from a user in Connection page
     * @param username
     */
    public void acceptAConnection(String username){
    	info("--Accept a connection of a user--");
    	info("Click on Confirm button");
    	searchPeople(username,null,null,null);
    	click(ELEMENT_CONNECTION_CONFIRM_BTN.replace("${user}",username));
    	waitForAndGetElement(ELEMENT_CONNECTION_REVOVE_BTN.replace("${user}",username),2000,0);
    	info("Accepted to the user");
    }
  
    /**
   	 * Function Verify connection
   	 * @param username
   	 * @param accept (true: if user accept invitation)
   	 */
    public void verifyConnection(String username, Boolean accept){
    	click(ELEMENT_MY_CONNECTIONS_TAB);
		//With user confirmed the invitation, user  becomes friend and user's name is displayed on user's network list
		searchPeople(username,null,null,null);
		if (accept)
			waitForAndGetElement(ELEMENT_CONNECTION_REVOVE_BTN.replace("${user}", username));
		else
			waitForElementNotPresent(ELEMENT_CONNECTION_REVOVE_BTN.replace("${user}", username));
    }
    
    /**
     * Function search people
     * @param peopleName
     * @param position
     * @param skills
     * @param directory
     */
	public void searchPeople(String peopleName, String position, String skills, String directory){
		info("-- Searching people ... --");
		if (directory!="" && directory!=null)
			click(By.linkText(directory));
		click(ELEMENT_ALL_RESULTS);
		if(peopleName!="" && peopleName!=null){
			type(ELEMENT_NAME_OF_PEOPLE, peopleName, true);
		}
		if(position!="" && position!=null){
			type(ELEMENT_POSITIONS_OF_PEOPLE, position, true);
		}
		if(skills!="" && skills!=null){
			type(ELEMENT_SKILL_OF_PEOPLE, skills, true);
		}
		click(ELEMENT_SEARCH_BUTTON);
		Utils.pause(1000);
	}
}