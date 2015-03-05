package org.exoplatform.selenium.platform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.exoplatform.selenium.TestLogger.info;

public class ConnectionsManagement extends PlatformBase {

	public final By ELEMENT_CONNECTION_EVERYONE_TITLE=By.xpath(".//*[@id='UIAllPeople']//h4[contains(text(),'Contacts Directory')]");
    public final String ELEMENT_CONNECTION_EVERYONE_CONNECT_BTN = ".//a[contains(text(),'${user}')]/../../..//*[text()='Connect']";
	public final String ELEMENT_CONNECTION_EVERYONE_CANCEL_BTN = ".//a[contains(text(),'${user}')]/../../..//*[text()='Cancel Request']";
	public final String ELEMENT_CONNECTION_EVERYONE_REVOVE_BTN = ".//a[contains(text(),'${user}')]/../../..//*[text()='Remove Connection']";
    public final String ELEMENT_CONNECTION_EVERYONE_IGNORE_BTN =" .//a[contains(text(),'${user}')]/../../..//*[text()='Ignore']";
    public final String ELEMENT_CONNECTION_EVERYONE_CONFIRM_BTN =" .//a[contains(text(),'${user}')]/../../..//*[text()='Confirm']";
    
    public ConnectionsManagement(WebDriver dr){
		driver = dr;
	}

    /**
     * Connect to a user
     * @param fullname
     */
    public void connectToAUser(String fullname){
    	info("--Connect to a user--");
    	info("Click on connect button");
    	click(ELEMENT_CONNECTION_EVERYONE_CONNECT_BTN.replace("${user}",fullname));
    	waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_CANCEL_BTN.replace("${user}",fullname),2000,0);
    	info("Connected to the user");
    }
    
    /**
     * Remove a connection of user
     * @param fullname
     */
    public void removeConnection(String fullname){
    	info("--Remove a connection of a user--");
    	info("Click on remove button");
    	click(ELEMENT_CONNECTION_EVERYONE_REVOVE_BTN.replace("${user}",fullname));
    	waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_CONNECT_BTN.replace("${user}",fullname),2000,0);
    	info("Removed to the user");
    }
    /**
     * Cancel a connection to a user
     * @param fullname
     */
    public void cancelConnection(String fullname){
    	info("--Cancel a connection of a user--");
    	info("Click on Cancel button");
    	click(ELEMENT_CONNECTION_EVERYONE_CANCEL_BTN.replace("${user}",fullname));
    	waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_CONNECT_BTN.replace("${user}",fullname),2000,0);
    	info("Canceled to the user");
    }
    /**
     * Ignore a connection that is sent from a user
     * @param fullname
     */
    public void ignoreConnection(String fullname){
    	info("--Ignore a connection of a user--");
    	info("Click on Ignore button");
    	click(ELEMENT_CONNECTION_EVERYONE_IGNORE_BTN.replace("${user}",fullname));
    	waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_CONNECT_BTN.replace("${user}",fullname),2000,0);
    	info("Canceled to the user");
    }
    /**
     * Reset all connections to default status
     * @param fullname
     */
    public void resetConnection(String fullname){
    	if(waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_REVOVE_BTN.replace("${user}",fullname),3000,0)!=null)
    		removeConnection(fullname);
       if(waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_CANCEL_BTN.replace("${user}",fullname),3000,0)!=null)
    	   cancelConnection(fullname);
       if(waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_IGNORE_BTN.replace("${user}",fullname),3000,0)!=null)
    	   ignoreConnection(fullname);
	}
    /**
     * Accept a connection from a user in Connection page
     * @param fullname
     */
    public void acceptAConnection(String fullname){
    	info("--Accept a connection of a user--");
    	info("Click on Confirm button");
    	click(ELEMENT_CONNECTION_EVERYONE_CONFIRM_BTN.replace("${user}",fullname));
    	waitForAndGetElement(ELEMENT_CONNECTION_EVERYONE_REVOVE_BTN.replace("${user}",fullname),2000,0);
    	info("Canceled to the user");
    }
}