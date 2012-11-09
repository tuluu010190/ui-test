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
 * Nov 22, 2012  
 */
public class SOC_PEO_RevokeFriend extends SocialBase{
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
  
  @Test
  public static void test01_revokeFriend(){    
    String userName = "james";
    String name = "James Davis";
    String InvitationOwner = "John Smith"; 
    By userContainer = By.xpath("//a[contains(@class,'CommunityName') and text()='" + InvitationOwner + "']/ancestor::div[contains(@class,'ContentSpace')]");
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
    goToMyConnections();
    waitForElementPresent(userContainer);
    
    //Store browser2 cookies 
    Set<Cookie> cookies1 = getBrowserCookies();   
    
    //Add cookies back to browser1
    backToPreviousBrowser(cookies, handlesBefore);
    cancelRequest(name);
    
    //Add cookies back to browser2
    setBrowserCookies(cookies1);
    
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }    
    goToMyConnections();    
    waitForElementNotPresent(userContainer);    
  }
}
