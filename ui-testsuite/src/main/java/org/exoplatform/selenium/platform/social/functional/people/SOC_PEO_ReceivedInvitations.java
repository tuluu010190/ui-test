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
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.social.PeopleConnection.*;

import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.By;
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
public class SOC_PEO_ReceivedInvitations extends SocialBase{
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
  public void afterMethods(){
    info("-- Logout --");
    signOut();
    driver.quit();
    actions = null;
  }
  /**
   * Test case ID 001
   * Invitation user
   */
  @Test
  public static void test01_inviteUser(){
    String userName = "james";
    String name = "James Davis";
    String InvitationOwner = "John Smith"; 
    
    info("Connect to " + name);
    connectPeople(name);
    signOut();
    signIn(userName, DATA_PASS);
    goToMyConnections();
    acceptInvitation(InvitationOwner);
    goToMyConnections();
    waitForElementPresent(By.xpath("//a[contains(@class,'InviteTitle') and text()='" + InvitationOwner + "']"));
    info("Reset data");
    removeConnection(InvitationOwner);
  }
  
  /**
   * Test case ID 002
   * Ignore a connection invitation
   */
  @Test
  public static void test02_ignoreInvitation(){
    String userName = "james";
    String name = "James Davis";
    String InvitationOwner = "John Smith"; 
    
    info("Connect to " + name);
    connectPeople(name);
    signOut();
    signIn(userName, DATA_PASS);
    goToMyConnections();
    ignoreInvitation(InvitationOwner);
  }
  
  /**
   * Test case ID 003
   * Ignore a connection invitation
   * Check information of user that sent a connection invitation
   */
  @Test
  public static void test03_checkUserProfile(){
    String userName = "james";
    String name = "James Davis";
    String InvitationOwner = "John Smith";     

    info("Connect to " + name);
    connectPeople(name);
    
    info("Goto profile page of " + InvitationOwner);
    signOut();
    signIn(userName, DATA_PASS);
    goToMyConnections();
    click(ELEMENT_REQUESTS_RECEIVED_TAB);
    click(By.xpath(ELEMENT_PROFILE_NAME_LINK.replace("${name}", InvitationOwner)));
    
    info("Verification all tabs in the profile of " + InvitationOwner);
    waitForElementPresent(By.xpath(ELEMENT_PROFILE_FULLNAME.replace("${name}", InvitationOwner)));    
    click(ELEMENT_TOOLBAR_ACTIVITY_ICON);
    waitForElementPresent(By.xpath(ELEMENT_ACTIVITYSTREAM_TITLE.replace("${name}", InvitationOwner)));
    click(ELEMENT_CONNECTIONS_LINK);
    waitForTextPresent("Contacts Directory");
    
    info("Reset data");
    goToMySpacePage();
    ignoreInvitation(InvitationOwner);
  }
}
