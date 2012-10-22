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
package org.exoplatform.selenium.platform.ecms.functional.admin.contentpresentation;
import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.exoplatform.selenium.platform.ecms.WcmAdmin;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by The eXo Platform SAS
 * Author : Hoang Manh Dung
 *          dunghm@exoplatform.com
 * Oct 15, 2012  
 */
public class ECMS_Admin_ContentPresentation_ManageView_Views extends EcmsBase{
  String DATA_USER = "john";
  String DATA_PASS = "gtn";
  @BeforeMethod
  public void beforeMethods() throws Exception {
    initSeleniumTest();
    driver.get(baseUrl);
    actions = new Actions(driver);
    info("Login ECMS with "+DATA_USER);
    loginEcms(DATA_USER, DATA_PASS);
    WcmAdmin.gotoManageViews();
  }

  @AfterMethod
  public void afterMethods() throws Exception {
    info("Logout ECMS");
    logoutEcms();
    driver.manage().deleteAllCookies();
    driver.quit();
    actions = null;
  }
  /*case 01+15
   * add new view
   * delete not using view
   */
  @Test
  public void test01_AddNewView() throws Exception{
    info("Add New View");
    //Open Add New Vew Form
    WcmAdmin.openForm("Add View", "Add View");
    //Fill data for Add New View Form
    WcmAdmin.fillAddNewViewForm("Test Tempate","System View");
    info("Delete a view that don't use"); //Test case 15
    WcmAdmin.deleteView("Test Tempate","Are you sure to delete this view?", true);
    
  }
  /*
   * Delete using view  
   */
  @Test
  public void test16_DeleteUsingView() throws Exception{
    info("Delete a view that using");
    WcmAdmin.deleteView("WCM View","Are you sure to delete this view?", false);
    waitForMessage("Cannot delete WCM View. It is currently in use.");
    closeMessageDialog();
  }
  /*
   * Case 17 + 09
   * Add new ECM template
   * Delete ECM template
   */
  @Test
  public void test17_AddEcmTemplate() throws Exception{
    info("Add Ecm Template");
    WcmAdmin.gotoEcmTemplates();
    WcmAdmin.openForm("Add", "Add ECM Template");
    WcmAdmin.fillEcmTemplateForm("Test Content", "Test Name", "ecm-explorer");
    info("Delete an ECM template"); //Test case 09
    WcmAdmin.deleteView("Test Name","Are you sure to delete this template?", true);
  }
  /*
   * Restore view a specific version
   */
  @Test
  public void test08_RestoreVersion() throws Exception{
    info("Restore Version");
    String viewName = "Simple View";
    WcmAdmin.createVersion(viewName, 2);
    WcmAdmin.restoreVersion(viewName, 1);
  }
}
