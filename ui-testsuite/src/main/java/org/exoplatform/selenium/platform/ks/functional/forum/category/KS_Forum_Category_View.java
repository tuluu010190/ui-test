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
package org.exoplatform.selenium.platform.ks.functional.forum.category;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.addCategoryInForum;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.deleteCategory;

import java.util.Set;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Dec 3, 2012  
 */
public class KS_Forum_Category_View extends ForumBase{
	 public static String CATEGORY_LINK = "//a[contains(@class,'ActionLink') and text()='${title}']";
	 public static String DESCRIPTION = "//h6[text()='${title} : ']/span[text()='${des}']";
	 public static By SELECT_HOME = By.xpath("//div[@class='Selected' and text()='Home']");
	
   @BeforeMethod
   public void beforeMethod(){
      initSeleniumTest();
      actions = new Actions(driver);
      driver.get(baseUrl);
      driver.manage().window().maximize();
      signIn("john", "gtn");    
   }

   @AfterMethod
   public void afterMethod(){
      signOut();
      driver.manage().deleteAllCookies();
      driver.quit();
   }
  /**
   * Test Case ID 006
   * View a category with restricted audience in case the administrator login
   */
   @Test
   public static void test06_ViewCategoryHaveRestrictedAudienceWithAdministrator(){
	  String title = "Test06";
	  String order = "0";
	  int chooseUser = 1;
	  String[] userGroup = {"james,mary"};
	  String description = "Test06 Description";
	  int setPermission = 0;
	  By categoryLink = By.xpath(CATEGORY_LINK.replace("${title}", title));
	  goToForums();
	  addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);
    
	  //Verify that administrator can access the category just created
	  signOut();
	  signIn("root", "gtn");
	  goToForums();    
	  click(categoryLink);
	  waitForElementPresent(DESCRIPTION.replace("${title}", title).replace("${des}", description));
	  
	  //Restore data
	  deleteCategory(title);
   }  
  /**
   * Test Case ID 007
   * View a category without restricted audience in case the administrator login
   */
   @Test
   public static void test07_ViewCategoryWithoutRestrictedAudienceWithAdministrator(){
	  String title = "Test07";
	  String order = "0";
	  int chooseUser = 0;
	  String[] userGroup = null;
	  String description = "Test06 Description";
	  int setPermission = 0;
	  By categoryLink = By.xpath(CATEGORY_LINK.replace("${title}", title));
	  goToForums();
	  addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);
    
	  //Verify that administrator can access the category just created
	  signOut();
	  signIn("root", "gtn");
	  goToForums();    
	  click(categoryLink);
	  waitForElementPresent(DESCRIPTION.replace("${title}", title).replace("${des}", description));
    
	  //Restore data
	  deleteCategory(title);
   }
  
  /**
   * Test Case ID 012
   * View a category in case it no longer exists
   */
   @Test
   public static void test12_ViewDeletedCategory(){
	  String title = "Test12";
	  String order = "0";
	  int chooseUser = 0;
	  String[] userGroup = null;
	  String description = "Test12 Description";
	  int setPermission = 0;
	  By categoryLink = By.xpath(CATEGORY_LINK.replace("${title}", title));
    
	  goToForums();
	  addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);
	  click(By.linkText("Home"));
	  waitForElementPresent(SELECT_HOME);
    
	  Set<Cookie> cookies = getBrowserCookies();
	  String handlesBefore = driver.getWindowHandle();
    
	  openNewBrowser();    
	  signIn("root", "gtn");    
	  goToForums();    
	  click(categoryLink);
	  deleteCategory(title, false);
    
	  backToPreviousBrowser(cookies, handlesBefore);
	  click(By.linkText(title));
	  waitForMessage("This category no longer exists.");
	  click(By.linkText("OK"));
   }
  
  //Some of methods involving two browsers cases existed in soc/ui-test branch, therefore they need to remove when soc/ui-test merged to master 
  
  /**
   * 
   * Get cookies of current browser then delete all cookies
   * @return set of cookies of browser
   */
  public static Set<Cookie> getBrowserCookies(){
    Set<Cookie> cookies = driver.manage().getCookies();
    driver.manage().deleteAllCookies();
    return cookies;   
  }
  
  /**
   * Set cookies for current browser
   * @param cookies : Set of cookies
   */
  public static void setBrowserCookies(Set<Cookie> cookies){
    for(Cookie cookie : cookies){
      driver.manage().addCookie(cookie);
    }
  }
  
  /**
   * Add by @author vuna2
   * Open a new browser by Javascript
   */
  public static void openNewBrowser(){
  //Open new browser by Javascript
  ((JavascriptExecutor) driver).executeScript("window.open()");
  for(String winHandle : driver.getWindowHandles()){
          driver.switchTo().window(winHandle);
  }
   driver.navigate().to(baseUrl);
  }
  
  /**
   * Add by @author vuna2
   * @param cookies: Set of cookies (browsers)
   * @param handlesBefore: handle the current browser
   */
  public static void backToPreviousBrowser(Set<Cookie> cookies, String handlesBefore){
  driver.manage().deleteAllCookies();

  //Add cookies back to previous browser 
  setBrowserCookies(cookies);

  //Switch back to previous browser    
  driver.switchTo().window(handlesBefore); 
  }
}