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

import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Nov 15, 2012
 *  
 * Reference : {@link https://github.com/exoplatform/qa-data-repository/blob/master/TestDefinitions/SOC/1.2.x/eXo_FuncTest_Social_v1.2_PEOPLE_TestDefinition.ods}
 */
public class SOC_PEO_Invite extends SocialBase{
  
  public static final String DATA_USER_ADMIN = "john";
  public static final String DATA_PASS = "gtn";
  
  @BeforeMethod
  public void beforeMethod(){
    initSeleniumTest();
    driver.get(baseUrl);
    actions = new Actions(driver);
    driver.manage().window().maximize();
    signIn(DATA_USER_ADMIN, DATA_PASS);
  }
  
  @AfterMethod
  public void afterMethod(){    
    driver.manage().deleteAllCookies();
    signOut();
    driver.quit();
    actions = null;
  } 
  /**
   * 
   * This method combined three test cases including:
   *  
   * <ul>
   *  <li>FNC_SOC_PEO_PEO_02/ 001: Invite User</li>
   *  <li>FNC_SOC_PEO_PEO_02/ 002: Accept Invitation</li>
   *  <li>FNC_SOC_PEO_PEO_02/ 003: Ignore Invitation</li>
   * </ul>
   * 
   */
  @Test
  public static void test01_inviteUser(){
   
    String homeFullName = "John Smith";
    String friendFullName1 = "James Davis";
    String friendUser1 = "james";
    String friendFullName2 = "Jack Miller";
    String friendUser2 = "demo";
    
    info("Invite a user to connect");
    connectPeople(friendFullName1);
    signOut();
    
    info("Accept Invitation");
    signIn(friendUser1, DATA_PASS);
    acceptInvitation(homeFullName);
    signOut();
    
    info("Reset data");
    signIn(DATA_USER_ADMIN, DATA_PASS);    
    removeConnection(friendFullName1);    
    
    info("Ignore invitation");
    connectPeople(friendFullName2);    
    signOut();
    signIn(friendUser2, DATA_PASS);    
    ignoreInvitation(homeFullName);
  }
  /**
   * Cancel a friend request that user just created
   */
  @Test
  public static void test04_cancelFriendRequest(){
    String targetUser = "James Davis"; 
    //By ELEMENT_CANCEL_REQUEST_BUTTON = By.xpath("//div/a[text()='" + targetUser + "']/following::ul/li/a[@title='Cancel Request']");
    connectPeople(targetUser);
    click(ELEMENT_CANCEL_REQUEST_BUTTON.replace("${peopleName}", targetUser));    
    waitForElementNotPresent(ELEMENT_CANCEL_REQUEST_BUTTON.replace("${peopleName}", targetUser));
  }
  
}