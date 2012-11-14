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
package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.social.ManageMember.*;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Nov 8, 2012  
 */
public class ManageMemberTest extends SocialBase{
  public static final String DATA_USER_ADMIN = "john";
  public static final String DATA_PASS = "gtn";
  
  @BeforeMethod
  public void beforeMethod(){
    initSeleniumTest();
    driver.get(baseUrl);
    actions = new Actions(driver);
    driver.manage().window().maximize();
    signIn(DATA_USER_ADMIN, DATA_PASS); 
    info("Create new space");
    goToMySpacePage();
    addNewSpace("Unit Space", "Unit Space Description");
  }
  
  @AfterMethod
  public void afterMethod(){    
    driver.manage().deleteAllCookies();
    driver.quit();
    actions = null;
  } 
  
  @Test
  public static void inviteSingleUserTest(){    
    info("Invite a user to space");
    goToSettings();
    goToMembers();
    inviteSingleUser("James");
    info("Reset data");
    goToMySpacePage();
    deleteSpace("Unit Space", 120000);
  }
  @Test
  public static void inviteMultiUserTest(){
    
    info("Invite a user to space");
    goToSettings();
    goToMembers();
    inviteMultiUser("Mary, James");
    
    info("Reset data");
    goToMySpacePage();
    deleteSpace("Unit Space", 120000);
  }
  @Test
  public static void acceptInvitationTest(){
    String USER_DEMO = "james";       
    info("Invite a user to space");
    goToSettings();
    goToMembers();
    inviteSingleUser("James");
    info("Go to accpet invitations");
    signOut();
    driver.get("http://localhost:8080");
    signIn(USER_DEMO, DATA_PASS);
    goToMySpacePage();
    acceptInvitation("Unit Space");

    info("Reset data");
    signOut();
    driver.get("http://localhost:8080");
    signIn(DATA_USER_ADMIN, DATA_PASS);
    goToMySpacePage();
    deleteSpace("Unit Space", 120000);    
  }
  @Test
  public static void ignoreInvitationTest(){
    String USER_DEMO = "james";       
    info("Invite a user to space");
    goToSettings();
    goToMembers();
    inviteSingleUser("James");
    signOut();
    driver.get("http://localhost:8080");
    signIn(USER_DEMO, DATA_PASS);
    goToMySpacePage();
    ignoreInvitation("Unit Space");

    info("Reset data");
    signOut();
    driver.get("http://localhost:8080");
    signIn(DATA_USER_ADMIN, DATA_PASS);
    goToMySpacePage();
    deleteSpace("Unit Space", 120000);
  } 
  
  @Test
  public static void validateInvitationTest(){
    String USER_DEMO = "james";
    String name = "James";
    String spaceName = "Unit Space";
    
    info("Request to join " + spaceName);
    signOut();
    driver.get("http://localhost:8080");
    signIn(USER_DEMO, DATA_PASS);
    goToMySpacePage();
    goToAllSpaces();
    requestToJoin(spaceName);

    info("Back to administration");
    signOut();
    driver.get("http://localhost:8080");
    signIn(DATA_USER_ADMIN, DATA_PASS);
    
    info("Go to validate invitation");
    goToMySpacePage();
    gotoEditSpace(spaceName);
    goToMembers();
    validateInvitation(name);
    
    info("Reset data");
    goToMySpacePage();
    deleteSpace("Unit Space", 120000);
  }
  
  @Test
  public static void declineInvitationTest(){
    String USER_DEMO = "james";
    String name = "James";
    String spaceName = "Unit Space";
    
    info("Request to join " + spaceName);
    signOut();
    driver.get("http://localhost:8080");
    signIn(USER_DEMO, DATA_PASS);
    goToMySpacePage();
    goToAllSpaces();
    requestToJoin(spaceName);

    info("Back to administration");
    signOut();
    driver.get("http://localhost:8080");
    signIn(DATA_USER_ADMIN, DATA_PASS);
    
    info("Go to decline invitation");
    goToMySpacePage();
    gotoEditSpace(spaceName);
    goToMembers();
    declineInvitation(name);
    
    info("Reset data");
    goToMySpacePage();
    deleteSpace("Unit Space", 120000);
  }
}