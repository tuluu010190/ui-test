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
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.ApplicationManagement.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Nov 13, 2012  
 */
public class ApplicationManagementTest extends SocialBase{
  public String DATA_USER = "john";
  public String DATA_PASS = "gtn";

  @BeforeMethod
  public void beforeMethods() throws Exception {
    initSeleniumTest();
    driver.get(baseUrl);
    driver.manage().window().maximize();
    actions = new Actions(driver);
    signIn(DATA_USER, DATA_PASS);
  }

  @AfterMethod
  public void afterMethods() throws Exception {
    info("-- Logout --");
    signOut();
    driver.quit();
    actions = null;
  }
  
  @Test
  public static void addApplicationTest(){
    //Space info
    String spaceName = "Unit Space";
    String spaceDesc = "Unit Space Description";
    //Application info
    String categoryName = "Collaboration";
    String applicationTitle = "Answers";
    
    info("Create new space");
    goToMySpacePage();
    addNewSpace(spaceName, spaceDesc);
    
    info("Add a new application to space");
    goToSettings();
    goToApplications();
    addApplication(categoryName, applicationTitle);
    
    info("Reset Data");
    goToMySpacePage();
    deleteSpace(spaceName, 120000);    
  }
  
  @Test
  public static void removeApplicationTest(){
    //Space info
    String spaceName = "Unit Space";
    String spaceDesc = "Unit Space Description";
    //Application info
    String applicationTitle = "Calendar";
    
    info("Create new space");
    goToMySpacePage();
    addNewSpace(spaceName, spaceDesc);
    
    info("Add a new application to space");
    goToSettings();
    goToApplications();
    removeApplication(applicationTitle);
    
    info("Reset Data");
    goToMySpacePage();
    deleteSpace(spaceName, 120000);    
  }
}
