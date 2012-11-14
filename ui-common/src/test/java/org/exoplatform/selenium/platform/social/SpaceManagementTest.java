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
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Nov 12, 2012  
 */
public class SpaceManagementTest extends SocialBase{
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
    driver.quit();
    actions = null;
  }
  
  @Test
  public static void addNewSpaceTest(){
    info("Create new space");
    goToMySpacePage();
    addNewSpace("Unit Space", "Unit Space Description");
    
    info("Reset data");
    goToMySpacePage();
    deleteSpace("Unit Space", 120000);
  }
  
  @Test
  public static void editSpaceTest(){
    String spaceName = "Unit Space";
    String description = "Unit Space Description";
    String newName = "New Unit Space";
    String newDescription = "New Unit Space Description";
    String curDir = System.getProperty("user.dir").replace("ui-common", "ui-testsuite");
    String avatar = curDir + "/src/main/resources/TestData/Winter.jpg";
    
    info("Create new space");
    goToMySpacePage();
    addNewSpace(spaceName, description);
    
    info("Edit a space");
    goToMySpacePage();
    editSpace(spaceName, newName, newDescription, true, avatar);
    
    info("Reset data");
    goToMySpacePage();
    deleteSpace(newName, 120000);
  }  
}
