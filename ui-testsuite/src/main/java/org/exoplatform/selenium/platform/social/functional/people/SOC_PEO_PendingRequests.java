/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.selenium.platform.social.functional.people;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;

import java.util.Set;

import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Nov 20, 2012  
 */
public class SOC_PEO_PendingRequests extends SocialBase{
  public static String DATA_USER = "john";
  public static String DATA_PASS = "gtn";  

  @BeforeMethod
  public void beforeMethods(){
    initSeleniumTest();
    driver.get(baseUrl);
    //driver.manage().window().maximize();
    actions = new Actions(driver);
    signIn(DATA_USER, DATA_PASS);
  }

  @AfterMethod
  public void afterMethods(){
    info("-- Logout --");
    signOut();
    driver.quit();
    actions = null;
  }
  /**
   * Test case ID 001 and 002
   * Request user/ Revoke Request
   */
  @Test
  public static void test01_requestUser(){
    String user1 = "James Davis";
    String user2 = "Jack Miller";
    info("Send connection request to " + user1 + "and " + user2);
    connectPeople(user1);
    connectPeople(user2);
    
    info("Verify users in request pending screen");
    goToMyConnections();
    click(ELEMENT_REQUEST_SENT_TAB);    
    waitForElementPresent(By.xpath(ELEMENT_PROFILE_NAME_LINK.replace("${name}", user1)));
    waitForElementPresent(By.xpath(ELEMENT_PROFILE_NAME_LINK.replace("${name}", user2)));
  
    //Reset data
    cancelRequest(user1);
    cancelRequest(user2);
  }
  
  /**
   * Test case ID 003
   * Check information of user in PENDING REQUESTS list
   */
  @Test
  public static void test03_checkProfile(){
    String user1 = "James Davis";
    String user2 = "Jack Miller";   
    
    info("Send connection request to " + user1 + "and " + user2);
    connectPeople(user1);
    connectPeople(user2);
    
    info("Verify users in request pending screen");
    goToMyConnections();
    click(ELEMENT_REQUEST_SENT_TAB);    
    waitForElementPresent(By.xpath(ELEMENT_PROFILE_NAME_LINK.replace("${name}", user1)));
    waitForElementPresent(By.xpath(ELEMENT_PROFILE_NAME_LINK.replace("${name}", user2)));
    
    info("Check the profile of a user");
    click(By.xpath(ELEMENT_PROFILE_NAME_LINK.replace("${name}", user1)));    
    waitForElementPresent(By.xpath(ELEMENT_PROFILE_FULLNAME.replace("${name}", user1)));    
    click(ELEMENT_TOOLBAR_ACTIVITY_ICON);
    waitForElementPresent(By.xpath(ELEMENT_ACTIVITYSTREAM_TITLE.replace("${name}", user1)));
    click(ELEMENT_CONNECTIONS_LINK);
    waitForTextPresent("Contacts Directory");
    
    //Reset data
    goToMyConnections();
    click(ELEMENT_REQUEST_SENT_TAB);
    cancelRequest(user1);
    cancelRequest(user2);
  }  
  
  /**
   * Test case ID 004
   * Revoke invitation when user Denied invitation
   */
  @Test
  public static void test04_revokeRequest(){    
    String userName = "james";
    String name = "James Davis";
    String InvitationOwner = "John Smith"; 
    
    info("Connect to " + name);
    connectPeople(name);  
    
    //Get and store all cookies of current browser
    Set<Cookie> cookies = getBrowserCookies();
    
    //Open new browser by Javascript
    String handlesBefore = driver.getWindowHandle();
    
    openNewBrowser();
    
    //Sign with new user to remove connection
    signIn(userName, DATA_PASS);
    ignoreInvitation(InvitationOwner);
    signOut();
        
    //Switch back to previous browser 
    backToPreviousBrowser(cookies, handlesBefore);
    
    cancelRequest(name);    
    waitForMessage("Invitation was canceled by someone else.");
  } 
  
}
