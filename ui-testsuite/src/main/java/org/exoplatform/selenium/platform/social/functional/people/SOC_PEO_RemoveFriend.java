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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS Author : Hoang Manh Dung
 * dunghm@exoplatform.com Nov 14, 2012
 */
public class SOC_PEO_RemoveFriend extends SocialBase {
  public static String DATA_USER = "john";

  public static String DATA_PASS = "gtn";

  @BeforeMethod
  public void beforeMethods(){
    initSeleniumTest();
    driver.get(baseUrl);
    driver.manage().window().maximize();
    actions = new Actions(driver);
    signIn(DATA_USER, DATA_PASS);
  }

  @AfterMethod
  public void afterMethods() {
    info("-- Logout --");
    signOut();
    driver.quit();
    actions = null;
  }
  /**
   * Remove invitation
   */
  @Test
  public static void test01_removeInvitation() {
    info("-- Connect to James Davis --");

    connectPeople("James Davis");

    signOut();
    
    signIn("james", "gtn");

    info("-- Accept invitation from John --");
    
    acceptInvitation("John Smith");

    signOut();
    
    signIn("john", "gtn");

    info("-- Remove connection with James Davis --");
    
    removeConnection("James Davis");
  }
  
  @Test
  public static void test02_checkInvitationDeletedByAnother() {
    String userName = "james";
    String name = "James Davis";
    String InvitationOwner = "John Smith"; 
    info("Connect to " + name);
    connectPeople(name);  
    
    //Get and store all cookies of current browser
    Set<Cookie> cookies = getBrowserCookies();
    
    //Open browser2 by Javascript
    String handlesBefore = driver.getWindowHandle();
    openNewBrowser();
    
    driver.navigate().to(baseUrl);
    
    //Sign with new user to accept connection invitation
    signIn(userName, DATA_PASS);
    acceptInvitation(InvitationOwner);
    removeConnection(InvitationOwner);
    
    //Add cookies back to browser1
    backToPreviousBrowser(cookies, handlesBefore);
    cancelRequest(name);
    waitForMessage("Invitation was canceled by someone else.");
  }
}