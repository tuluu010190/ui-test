package org.exoplatform.selenium.platform.ks;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.exoplatform.selenium.platform.ks.KsBase;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ks.Wiki.*;
import static org.exoplatform.selenium.platform.ks.Answer.*;

public class WikiTest extends KsBase {
  @Test
  public void addWikiPage() {
	  signIn("root", "gtn");
	  goToWiki();
	 // addTemplateWikiPage("testTemplate", "test",0,"Three-Column Layout");
	  addTemplateWikiPage("testRich Template3", 1,"Three-Column Layout");
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_editWikiPage() {
	  signIn("root", "gtn");
	  goToWiki();
	 // addTemplateWikiPage("testRich Template3",0,"Three-Column Layout");
	  addBlankWikiPage("wiki","wiki",1);
	  editWikiPage("testRich Template3", "source editor24",1, false);
	  deleteWikiPage();
	  /*editWikiPage("testRich313", "rich text24",1,false);
	  editWikiPage("testRich edited 113", null,1,false);
	  editWikiPage(null, "edited24",1,false);
	  editWikiPage(null, null,1,false);*/
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_deleteWikiPage() {
	  signIn("root", "gtn");
	  goToWiki();
	  click(By.linkText("testRich Template3"));
	  deleteWikiPage();
	  
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_GoToWikiPage() {
	  signIn("root", "gtn");
	  goToWiki();
	  goToWikiPage("testRich edited 111/thuntn/sdasffddd/page2");
	  pause(5000);
	  
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_SearchQuick() {
	  signIn("root", "gtn");
	  goToWiki();
	  quickSearch("test02");
	  pause(10000);
	  
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_WatchWikiPage() {
	  signIn("root", "gtn");
	  goToWiki();
	  watchWikiPage();
	  pause(10000);
	  
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_UnwatchWikiPage() {
	  signIn("root", "gtn");
	  goToWiki();
	  unwatchWikiPage();
	  pause(5000);
	  
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_SearchAdvanced() {
	  signIn("root", "gtn");
	  goToWiki();
	  advancedSearch("home","user");
	  pause(10000);
	  
	 // addBlankWikiPage("testRich text", "test",1);
	  
  }
  @Test
  public void test_AddPagePermission() {
	  signIn("root", "gtn");
	  goToWiki();
	  /*String[] user0= {"james"};
	  String[] user1= {"mary"};
	  String[] user2= {"Platform/Users"};*/
	  String[] user3={};
	  
	  //addPagePermission(0,user0);
	  //addPagePermission(1,user1);
	  //addPagePermission(2,user2);
	  addPagePermission(4,user3);
	  pause(5000);   
  }
  
  @Test
  public void test_AddTemplate() {
	  signIn("root", "gtn");
	  goToWiki();
	  	  
	  addTemplate("template 2", "this is a test11", "aaa");
	 
	  pause(5000);   
  }
 
  @Test
  public void test_EditTemplate() {
	  signIn("root", "gtn");
	  goToWiki();
	  	  
	  editTemplate("thuntn", null, null, null);
	 
	  pause(5000);   
  } 
  
  @Test
  public void test_deleteTemplate() {
	  signIn("root", "gtn");
	  goToWiki();
	  	  
	  deleteTemplate("thuntn");
	 
	  pause(5000);   
  } 
  @Test
  public void test_uploadFile() {
	  signIn("root", "gtn");
	  goToWiki();
	  	  
	  attachFileInWiki("/home/thuntn/workspace/ui-test/ui-testsuite/src/main/resources/TestData/Winter.jpg");
	 
	  pause(5000);   
  } 
  @Test
  public void test_deleteFile() {
	  signIn("root", "gtn");
	  goToWiki();
	  	  
	  deleteFile("Untitled Document");
	 
	  pause(5000);   
  } 
  @Test
  public void test_viewChange() {
	  signIn("root", "gtn");
	  
	  goToWiki();
	  goToWikiPage("Wiki Home/test 1111/test02");
	  viewChange();	 
	  pause(5000);   
  }
  @Test
  public void test_viewVersion() {
	  signIn("root", "gtn");
	  
	  goToWiki();
	  goToWikiPage("Wiki Home/test 1111/test02");
	  viewVersion("2");
	 
	  pause(5000);   
  }
  @Test
  public void test_restoreVersion() {
	  signIn("root", "gtn");
	  
	  goToWiki();
	  goToWikiPage("Wiki Home/test 1111/test02");
	  restoreVersion("2");
	 
	  pause(5000);   
  }
  @Test
  public void test_compareVersion() {
	  signIn("root", "gtn");
	  
	  goToWiki();
	  goToWikiPage("Wiki Home/test 1111/test02");
	  compareVersion("2", "3");
	 
	  pause(5000);   
  }
  @Test
  public void test_deleteQuestion() {
	  signIn("root", "gtn");
	  
	  goToAnswer();
	  deleteOpeningQuestion("question01");
	 
	  pause(5000);   
  }
  @Test
  public void test_addSpacePermission() {
	  signIn("root", "gtn");
	  
	  /*String[] user1= {"mary"};
	  String[] user2= {"james"};*/
	  String[] user3={"Platform/Users"};
	  String[] user4={"Platform/Users","member"};
	  goToWiki();
	  //addSpacePermission(0,user1);
	 // addSpacePermission(1,user2);
	  addSpacePermission(2, user3);
	  addSpacePermission(3, user4);
	 
	  pause(10000);   
  }
  
  @Test
  public void test_editSpacePermission() {
	  signIn("root", "gtn");
	  
	  /*String[] user1= {"mary"};
	  String[] user2= {"james"};
	  String[] user3={"Platform/Users"};
	  String[] user4={"Platform/Users","member"};*/
	  goToWiki();
	  //addSpacePermission(0,user1);
	 // addSpacePermission(1,user2);
	  goToSpacePermission();
	  editSpacePermission("mary", false, false, false, false);
	 
	  pause(10000);   
  }
  @Test
  public void test_deleteSpacePermission() {
	  signIn("root", "gtn");
	  
	  /*String[] user1= {"mary"};
	  String[] user2= {"james"};
	  String[] user3={"Platform/Users"};
	  String[] user4={"Platform/Users","member"};*/
	  goToWiki();
	  //addSpacePermission(0,user1);
	 // addSpacePermission(1,user2);
	  deleteSpacePermission("mary");
	 
	  pause(10000);   
  }
  
  @BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
  	actions = new Actions(driver);
  	baseUrl = "http://localhost:8080";
  	driver.get(baseUrl );
  	pause(3000);
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
