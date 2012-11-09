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
import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.*;

import static org.exoplatform.selenium.platform.ks.ForumManagement.*;
import static org.exoplatform.selenium.platform.ks.TopicManagement.*;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;

import org.exoplatform.selenium.platform.ks.ForumBase;
import org.openqa.selenium.By;
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
public class KS_Forum_Category_Add extends ForumBase{
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
   * Test Case ID 007
   * Add a new category with blank Restricted audience
   */
  @Test
  public static void test07_addCategoryPermission(){
    String title = "Test07";
    String order = "0";
    int chooseUser = 0;
    String[] userGroup = null;
    String description = "Test07 Description";
    int setPermission = 0;
    By categoryLink = By.xpath("//a[contains(@class,'ActionLink') and text()='" + title + "']");
    goToForums();
    addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);
    
    //Verify that normal user can access the category just created
    signOut();
    signIn("demo", "gtn");
    goToForums();
    click(categoryLink);
    
    //Restore data
    restoreData(title); 
  }
  
  /**
   * Test Case ID 008
   * Add a new category in case invalid data entry for the Restricted audience field
   */
  @Test
  public static void test08_addCategoryInvalid(){
    String title = "Test08";
    String userGroup = "BlahBlah";
    String description = title + " Description";
    goToForums();
    addCategoryInvalidUser(title, userGroup, description);
  }
  /**
   * Test Case ID 009
   * Add a new category in case valid user entry for the Restricted audience field
   */
  @Test
  public static void test09_addCategoryValidUser(){
    String title = "Test09";
    String order = "0";
    int chooseUser = 1;
    String[] userGroup = {"demo"};
    String description = title + " Description";
    int setPermission = 0;
    By categoryLink = By.xpath("//a[contains(@class,'ActionLink') and text()='" + title + "']");
    goToForums();
    addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);
    
    //Verify demo see the category just created
    signOut();
    signIn("demo", "gtn");
    goToForums();
    waitForElementPresent(categoryLink);
    
    //Verify James don't see the category just created
    
    signOut();
    signIn("james", "gtn");
    goToForums();
    waitForElementNotPresent(categoryLink);
    
  //Restore data
    restoreData(title);   
  }
  /**
   * Test Case ID 010
   * Add a new category in case valid role entry for the Restricted audience field
   */
  @Test
  public static void test10_addCategoryValidRole(){
    String title = "Test10";
    String order = "0";
    int chooseUser = 1;
    String[] userGroup = {"manager:/organization/employees"};
    String description = title + " Description";
    int setPermission = 0;
    By categoryLink = By.xpath("//a[contains(@class,'ActionLink') and text()='" + title + "']");
    goToForums();
    addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);   
    
    //Verify Jame don't see the category just created
    
    signOut();
    signIn("james", "gtn");
    goToForums();
    waitForElementNotPresent(categoryLink); 
    
  //Restore data
    restoreData(title); 
  }
  /**
   * Test Case ID 011
   * Add a new category in case valid group entry for the Restricted audience field
   */
  @Test
  public static void test11_addCategoryValidGroup(){
    String title = "Test11";
    String order = "0";
    int chooseUser = 1;
    String[] userGroup = {"/organization/management/executive-board"};
    String description = title + " Description";
    int setPermission = 0;
    By categoryLink = By.xpath("//a[contains(@class,'ActionLink') and text()='" + title + "']");
    goToForums();
    addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);   
    
    //Verify James belong "/organization/employees" group don't see the category just created
    
    signOut();
    signIn("james", "gtn");
    goToForums();
    waitForElementNotPresent(categoryLink); 
    
  //Restore data
    restoreData(title);
  }
  /**
   * Test Case ID 012
   * Add a new category in case valid user, role and group entry for Restricted audience field at once
   */
  @Test
  public static void test12_addCategoryValidUserRoleGroup(){
    String title = "Test12";
    String order = "0";
    int chooseUser = 1;
    String[] userGroup = {"john,manager:/organization/management/executive-board,/organization/management/executive-board"};
    String description = title + " Description";
    int setPermission = 0;
    By categoryLink = By.xpath("//a[contains(@class,'ActionLink') and text()='" + title + "']");
    goToForums();
    addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission);   
    
    //Verify James belong "/organization/employees" group don't see the category just created
    
    signOut();
    signIn("james", "gtn");
    goToForums();
    waitForElementNotPresent(categoryLink); 
    
    //Restore data
    restoreData(title);
  }
  /**
   * Test Case ID 013
   * Assign Moderator right when add category
   */
  @Test
  public static void test13_addCategoryWithModerator(){
    String title = "Test13";
    String order = "0";
    int chooseUser = 0;
    String[] userGroup = {"/organization/management/executive-board,john,manager:/organization/management/executive-board"};
    String description = title + " Description";
    int setPermission = 1;
    //By categoryLink = By.xpath("//a[contains(@class,'ActionLink') and text()='" + title + "']");
    goToForums();
    addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission, userGroup[0]);
    
    quickAddForum(title + "_Forum");
    goToEditForum();
    click(ELEMENT_MODERATOR_TAB);
    waitForElementPresent(By.xpath("//textarea[@id='Moderator' and contains(text(),'" + userGroup[0] + "')]"));
    
    restoreData(title);
  }
  
  /**
   * Test Case ID 014
   * Assign right to user can create topic when add new category
   */
  @Test
  public static void test14_addCategoryWithCreateTopicRight(){
    String title = "Test14";
    String forumName = title + "_Forum";    
    String user = "james";
    String description = title + " Description";
    By startTopic = By.xpath("//div[contains(@class,'StartTopicForum')]/a[contains(text(),'Start Topic')]");  
    
    info("Create a new category and add forum to it");
    goToForums();
    quickAddCategory(title, description, SET_PERMISSION[1],user);
    //addCategoryInForum(title, order, chooseUser, userGroup, description, setPermission, userGroup[0]);    
    quickAddForum(forumName);
    
    info("Verify that james can create topic");
    signOut();
    signIn("james","gtn");
    goToForums();
    gotoForumView(forumName);
    waitForElementPresent(startTopic);
    
    info("Verify that demo can't create topic");
    signOut();
    signIn("demo","gtn");
    goToForums();
    gotoForumView(forumName);
    waitForElementNotPresent(startTopic);
    
    info("Reset data");
    restoreData(title);
  }
  
  /**
   * Test Case ID 015
   * Assign right to user can post in all topics when add new category
   */
  @Test
  public static void test15_addCategoryWithSubmitPostRight(){
    String title = "Test15";
    String forumName = title + "_Forum";    
    String user = "james";
    String description = title + " Description"; 
    String topicTitle = "Test15_Topic";
    String topicMessage = topicTitle + " Messages";    
    
    info("Create a new category and add forum to it");
    goToForums();
    quickAddCategory(title, description, SET_PERMISSION[2], user);    
    quickAddForum(forumName);
    quickStartTopic(topicTitle, topicMessage);
    
    info("Verify that james can submit posts");
    signOut();
    signIn("james","gtn");
    goToForums();
    gotoForumView(forumName);
    click(By.linkText(topicTitle));
    waitForElementPresent(ELEMENT_POST_QUICK_MESSAGE);
    
    info("Verify that demo can't submit posts");
    signOut();
    signIn("demo","gtn");
    goToForums();
    gotoForumView(forumName);    
    click(By.linkText(topicTitle));
    waitForElementNotPresent(ELEMENT_POST_QUICK_MESSAGE);
    
    info("Reset data");
    restoreData(title);
  }
  
  /**
   * Test Case ID 016
   * Assign right to user can post in all topics when add new category
   */
  @Test
  public static void test16_addCategoryWithViewTopicRight(){
    String title = "Test16";
    String forumName = title + "_Forum";    
    String user = "james";
    String description = title + " Description";
    String topicTitle = "Test16_Topic";
    String topicMessage = topicTitle + " Messages";
    
    info("Create a new category and add forum to it");
    goToForums();
    quickAddCategory(title, description, SET_PERMISSION[3], user);    
    quickAddForum(forumName);
    quickStartTopic(topicTitle, topicMessage);
    
    info("Verify that james can view topic");
    signOut();
    signIn("james","gtn");
    goToForums();
    gotoForumView(forumName);
    waitForElementPresent(By.linkText(topicTitle));
    
    info("Verify that demo can't view topic");
    signOut();
    signIn("demo","gtn");
    goToForums();
    gotoForumView(forumName);    
    waitForElementNotPresent(By.linkText(topicTitle));
    
    info("Reset data");
    restoreData(title);
  }
  
  /**
   * Test Case ID 017
   * Assign Moderator right for invalid user when add category
   */
  @Test
  public static void test17_addCategoryWithInvalidModerator(){
    String title = "Test17";
    String user = "Test17_BlahBlah";
    String description = title + " Description";
    String errorMessage = "The field \"Moderators\" is invalid: " + user + ".";
    goToForums();
    addCategoryInvalidUser(title, user, description, SET_PERMISSION[0], errorMessage);
  }
  
  /**
   * Test Case ID 018
   * Assign right "Who Can create topic" for invalid user when add new category
   */
  @Test
  public static void test18_addCategoryWithInvalidUserStartTopicRight(){
    String title = "Test18";
    String user = "Test18_BlahBlah";
    String description = title + " Description";
    String errorMessage = "The field \"Who can start topics?\" is invalid: " + user + ".";
    goToForums();
    addCategoryInvalidUser(title, user, description, SET_PERMISSION[1], errorMessage);
  }
  
  /**
   * Test Case ID 019
   * Assign right "Who Can post" for invalid user when add new category
   */
  @Test
  public static void test19_addCategoryWithInvalidUserSumbitPostRight(){
    String title = "Test19";
    String user = "Test19_BlahBlah";
    String description = title + " Description";
    String errorMessage = "The field \"Who can post?\" is invalid: " + user + ".";
    goToForums();
    addCategoryInvalidUser(title, user, description, SET_PERMISSION[2], errorMessage);
  }
  
  /**
   * Test Case ID 020
   * Assign right "Who Can view posts" for invalid user when add new category
   */
  @Test
  public static void test20_addCategoryWithInvalidUserViewPostRight(){
    String title = "Test20";
    String user = "Test20_BlahBlah";
    String description = title + " Description";
    String errorMessage = "The field \"Who can only view posts?\" is invalid: " + user + ".";
    goToForums();
    addCategoryInvalidUser(title, user, description, SET_PERMISSION[3], errorMessage);
  }
  /**
   * Remove category after test case completed
   * @param title : Category title
   */
  public static void restoreData(String title){
    signOut();
    signIn("john", "gtn");
    goToForums();
    gotoCategory(title);
    deleteCategory(title);
  }
}
