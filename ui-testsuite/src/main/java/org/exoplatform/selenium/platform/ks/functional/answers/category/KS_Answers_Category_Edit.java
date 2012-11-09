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
package org.exoplatform.selenium.platform.ks.functional.answers.category;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;

import org.exoplatform.selenium.platform.ks.Answer;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Nov 26, 2012  
 */
public class KS_Answers_Category_Edit extends Answer{
  public static final String DATA_USER_ADMIN = "john";
  public static final String DATA_PASS = "gtn";
  //public static String categoryName = "CategoryEditable";
  public static String order = "1";
  public static int setAudience = 1;
  public static String[] audience = {"/developers"};
  public static String description = "Category Description";
  public static int setModerator = 1;
  public static String[] moderator = {DATA_USER_ADMIN};
  public static boolean opt = false;
  //public static String editCategoryName = categoryName + "1";
  public static String editOrder = "1";
  public static int eidtSetAudience = 1;
  public static String[] editAudience = {"/platform/administrators"};
  public static String editDescription = "Eidted " + description;
  public static int editSetModerator = 1;
  public static String[] editModerator = {"root"};
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
  /**
   * Test Case ID 005
   * Edit category in case valid data entry for Moderator field
   */
  @Test
  public static void test05_editCategoryWithValidData(){
    String categoryName = "Category05";
    String editCategoryName = categoryName + "1";
    //Create new category
    createCategory(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);
    editOpeningCategoryInAnswer(editCategoryName, editOrder, eidtSetAudience, editAudience, editDescription, editSetModerator, editModerator, opt);
    
    info("Reset Data");    
    deleteOpeningCategoryInAnswer(editCategoryName);    
  }
  /**
   * Test Case ID 006
   * Edit category in case invalid data entry for Moderator field
   */
  @Test
  public static void test06_editCategoryWithInvalidData(){
    String categoryName = "Category06";
    String editCategoryName = categoryName + "1";
    String[] invalidModerator = {"Blah Blah"};
    
    //Create new category
    createCategory(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);   
    editWithInvalidModerator(editCategoryName, editOrder, eidtSetAudience, editAudience, editDescription, editSetModerator, invalidModerator);    
    
    info("Reset Data");   
    deleteOpeningCategoryInAnswer(categoryName);
  }
  /**
   * Test Case ID 007
   * Edit category with Require approval on new questions option
   */
  @Test
  public static void test07_editCategoryModeratorQuestion(){
    String categoryName = "Category07";
    String editCategoryName = categoryName + "1";
    String questionName = "Test07";
    String questionContent = "Test07 Content";
    //Create new category
    createCategoryWithoutRestricted(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);
    editOpeningCategoryInAnswer(editCategoryName, editOrder, 0, editAudience, editDescription, editSetModerator, editModerator, true);

    info("create new question");
    quickAddQuestion(questionName, questionContent, "The question has been submitted to moderators.");
    signOut();
    
    info("Verify that the question create in " + editCategoryName + " disappear");
    signIn("james", DATA_PASS);
    goToAnswer();
    goToACategoryInAnswer(editCategoryName);
    waitForElementNotPresent(By.xpath("//a[@class='Question' and text()='" + questionName + "']"));
    
    info("Reset Data");
    signOut();
    signIn(DATA_USER_ADMIN, DATA_PASS);
    goToAnswer();
    goToACategoryInAnswer(editCategoryName);
    deleteOpeningCategoryInAnswer(editCategoryName);    
  }
  
  /**
   * Test Case ID 008
   * Edit category without Require approval on new questions option
   */
  @Test
  public static void test08_editCategoryModeratorQuestion(){
    String categoryName = "Category08";
    String editCategoryName = categoryName + "1";
    By IsApproved = By.id("IsApproved");
    //Create new category
    createCategoryWithoutRestricted(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);
    editOpeningCategoryInAnswer(editCategoryName, editOrder, 0, editAudience, editDescription, editSetModerator, editModerator, true);

    info("open the question submission form and verify that Approved checkbox is unchecked");
    click(ELEMENT_SUBMIT_QUESTION_BUTTON);
    waitForElementPresent(ELEMENT_QUESTION_NAME);
    //Verify that Approved checkbox is unchecked
    check(IsApproved);  
    click(ELEMENT_CLOSE_WINDOW);
    
    info("Reset Data");
    deleteOpeningCategoryInAnswer(editCategoryName);    
  }
  
  /**
   * Test Case ID 010
   * Edit category without Require approval on new questions option
   */
  @Test
  public static void test10_editCategoryModeratorAnswer(){
    String categoryName = "Category10";
    String editCategoryName = categoryName + "1";
    String questionName = "Test10";
    String questionContent = "Test10 Content";
    //Create new category
    createCategoryWithoutRestricted(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);
    editOpeningCategoryInAnswer(editCategoryName, editOrder, 0, editAudience, editDescription, editSetModerator, editModerator, false, false, true);

    info("create new question and answer the question");
    quickAddQuestion(questionName, questionContent); 
    
    By questionLink = By.xpath("//a[@class='Questions' and text()='" + questionName + "']");
    String answerContent = "Answer " + questionName;
    quickAnswer(questionLink, answerContent);
    By unApproved = By.xpath("//p[contains(text(),'" + answerContent + "')]/ancestor::div[contains(@class,'ResponseItemContainer')]//a[contains(@class,'UnApprovedQuestion')]");
    waitForElementPresent(unApproved);
    
    signOut();
    signIn("james", DATA_PASS);
    goToAnswer();
    goToACategoryInAnswer(editCategoryName);
    click(questionLink);
    waitForElementNotPresent(By.xpath("//p[contains(text(),'" + answerContent + "')]"));
    
    info("Reset Data");
    signOut();
    signIn(DATA_USER_ADMIN, DATA_PASS);
    goToAnswer();
    goToACategoryInAnswer(editCategoryName);
    deleteOpeningCategoryInAnswer(editCategoryName);    
  }
  /**
   * Test Case ID 011
   * Edit category without Require approval on new answer option
   */
  @Test
  public static void test11_editCategoryModeratorAnswer(){
    String categoryName = "Category11";
    String editCategoryName = categoryName + "1";
    String questionName = "Test11";
    String questionContent = "Test11 Content";
    //Create new category
    createCategoryWithoutRestricted(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);
    editOpeningCategoryInAnswer(editCategoryName, editOrder, 0, editAudience, editDescription, editSetModerator, editModerator);

    info("create new question and answer the question");
    quickAddQuestion(questionName, questionContent); 
    
    By questionLink = By.xpath("//a[@class='Questions' and text()='" + questionName + "']");
    String answerContent = "Answer " + questionName;
    quickAnswer(questionLink, answerContent);
    
    info("Verify question and answer is public");
    signOut();
    signIn("james", DATA_PASS);
    goToAnswer();
    goToACategoryInAnswer(editCategoryName);
    click(questionLink);
    waitForElementPresent(By.xpath("//p[contains(text(),'" + answerContent + "')]"));
    
    info("Reset Data");
    signOut();
    signIn(DATA_USER_ADMIN, DATA_PASS);
    goToAnswer();
    goToACategoryInAnswer(editCategoryName);
    deleteOpeningCategoryInAnswer(editCategoryName);
  }
  
  /**
   * Test Case ID 012
   * Edit category with View Author of Question option
   */
  @Test
  public static void test12_editCategoryModeratorAuthor(){
    String categoryName = "Category12";
    String editCategoryName = categoryName + "1";
    String questionName = "Test12";
    String questionContent = "Test12 Content";
    String authorName = "John Smith";
    String authorEmail = "john.smith@acme.exoplatform.com";
    //Create new category
    createCategoryWithoutRestricted(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);
    editOpeningCategoryInAnswer(editCategoryName, editOrder, 0, editAudience, editDescription, editSetModerator, editModerator, false, true);

    info("create new question and answer the question");
    quickAddQuestion(questionName, questionContent); 
    
    info("Verify authors informations");    
    By questionLink = By.xpath("//a[@class='Questions' and text()='" + questionName + "']");        
    click(questionLink);
    waitForElementPresent(By.xpath("//div[@class='AuthorInfor']/a/span[text()='" + authorName + "']"));
    waitForElementPresent(By.xpath("//div[@class='AuthorInfor']/span[@title='" + authorEmail + "']"));
    
    info("Reset Data");    
    deleteOpeningCategoryInAnswer(editCategoryName);
  }
  
  /**
   * Test Case ID 013
   * Edit category without View Author of Question option
   */
  @Test
  public static void test13_editCategoryModeratorWidthAuthor(){
    String categoryName = "Category13";
    String editCategoryName = categoryName + "1";
    String questionName = "Test13";
    String questionContent = "Test13 Content";
    String authorName = "John Smith";
    String authorEmail = "john.smith@acme.exoplatform.com";
    //Create new category
    createCategoryWithoutRestricted(categoryName);
    
    info("Open and edit category");
    goToACategoryInAnswer(categoryName);
    editOpeningCategoryInAnswer(editCategoryName, editOrder, 0, editAudience, editDescription, editSetModerator, editModerator);

    info("create new question and answer the question");
    quickAddQuestion(questionName, questionContent); 
    
    info("Verify authors informations");    
    By questionLink = By.xpath("//a[@class='Questions' and text()='" + questionName + "']");        
    click(questionLink);
    waitForElementNotPresent(By.xpath("//div[@class='AuthorInfor']/a/span[text()='" + authorName + "']"));
    waitForElementNotPresent(By.xpath("//div[@class='AuthorInfor']/span[@title='" + authorEmail + "']"));
    
    info("Reset Data");    
    deleteOpeningCategoryInAnswer(editCategoryName);
  }
  
  public static void createCategory(String categoryName){
    goToAnswer();    
    info("Create new category");
    addNewCategoryInAnswer(categoryName, order, setAudience, audience, description, setModerator, moderator, opt);
  }
  
  public static void createCategoryWithoutRestricted(String categoryName){
    goToAnswer();    
    info("Create new category");
    addNewCategoryInAnswer(categoryName, order, 0, audience, description, setModerator, moderator, opt);
  }
}
