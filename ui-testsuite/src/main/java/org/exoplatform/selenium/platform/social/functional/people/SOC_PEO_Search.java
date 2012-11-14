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
import static org.exoplatform.selenium.platform.social.PeopleSearch.searchPeople;

import org.exoplatform.selenium.platform.social.PeopleSearch.searchType;
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
 * Nov 14, 2012  
 */
public class SOC_PEO_Search extends SocialBase{
  public String DATA_USER = "john";

  public String DATA_PASS = "gtn";

  @BeforeMethod
  public void beforeMethods() {
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
  /*
   * Search when text box search is blank
   */
  @Test
  public static void test01_searchWithBlankKeyword(){
    goToFindConnections();
    searchPeople(searchType.NAME, "");
    captureScreen("test01_searchWithBlankKeyword");
  }
  /*
   * Search when input some text in text box  search
   */
  @Test
  public static void test02_searchWithKeyword(){
    String keyword = "TestName";
    goToFindConnections();
    searchPeople(searchType.NAME, keyword);
    waitForTextPresent("Contact Found: 0");    
    keyword = "Jack";
    searchPeople(searchType.NAME, keyword);
    waitForElementPresent(By.xpath("//a[contains(@class,'CommunityName') and contains(text(),'" + keyword + "')]"));    
  }
  /*
   * Search when click on a alphabet character
   */
  @Test
  public static void test03_searchWithAlphbet(){
    String keyword = "M";
    goToFindConnections();
    searchPeople(searchType.DIRECTORY, keyword);
    captureScreen("test03_searchWithAlphbet");
  }
  /*
   * Search when click on All
   */
  @Test
  public static void test04_searchAll(){
    String keyword = "All";
    goToFindConnections();
    searchPeople(searchType.DIRECTORY, keyword);
    captureScreen("test04_searchAll");
  }
  
}
