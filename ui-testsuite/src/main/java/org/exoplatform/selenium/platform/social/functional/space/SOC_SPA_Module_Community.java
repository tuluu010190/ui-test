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
package org.exoplatform.selenium.platform.social.functional.space;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.*;
import static org.exoplatform.selenium.platform.ManageApplications.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.goToApplicationRegistry;
import static org.exoplatform.selenium.platform.NavigationToolbar.goToEditPageEditor;
import static org.exoplatform.selenium.platform.social.SpaceManagement.*;
import static org.exoplatform.selenium.platform.social.ApplicationManagement.*;

import java.util.HashMap;
import java.util.Map;

import org.exoplatform.selenium.platform.social.SocialBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author: hangNTT
 * Date: 3/12/2012
 * @Manage Member: Community
 */
public class SOC_SPA_Module_Community extends SocialBase{

	public static String DATA_USER = "john";
	public static String DATA_PASS = "gtn";
	protected static int DEFAULT_TIMEOUT = 60000;

	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		signIn(DATA_USER, DATA_PASS);
	}
	
	//Add new application into the space
	@Test
	public static void test02_AddNewApplicationIntoTheSpace(){
		//Space info
		String spaceName = "Case002";

		String spaceDesc = "Description of Space";

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

		restoreData(spaceName, 240000);    
	}
	
	//Remove application from the space
	@Test
	public static void test03_RemoveApplicationFromTheSpace(){
		//Space info
		String spaceName = "Space003";

		String spaceDesc = "Description of Space003";

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

		restoreData(spaceName, 240000);    
	}
	
	//Remove space settings portlet
	@Test
	public static void test04_RemoveSpaceSettingPortlet(){
		//Space info
		String spaceName = "Space004";

		String spaceDesc = "Description of Space004";

		By VERIFY_ELEMENT_DELETE_APP_BUTTON = By.xpath("//div[text()='Space Setting']/ancestor::div[contains(@class,'ContentSpace')]//a[@title='Remove']");

		info("Create new space");

		goToMySpacePage();

		addNewSpace(spaceName, spaceDesc);

		goToSettings();

		goToApplications();

		waitForElementNotPresent(VERIFY_ELEMENT_DELETE_APP_BUTTON);

		info("Reset Data");

		restoreData(spaceName, 240000);    
	}
	
	//Add application which space's manager has permission to use
	@Test
	public static void test05_AddApplicationWhichSpaceManagerHasPermissionToUse(){
		//Space info
		String spaceName = "Space0005";

		String spaceDesc = "Description of Space5";

		String CATEGORY_NAME ="Category05";

		String CATE_DISP_NAME = "Category05";

		String SPACE005_GROUP = "Spaces/space0005";

		String DATA_MEMBER_SHIP = "*";

		String applicationTitle = "Advanced Search";

		info("Create new space");

		goToMySpacePage();

		addNewSpace(spaceName, spaceDesc);

		goToApplicationRegistry();

		//Import Application don't show as default

		if(waitForElementNotPresent(ELEMENT_IMPORT_APPLICATION,30000,0) == null) {

		//goto Edit Portlet

		goToEditPageEditor();

		//Click on Edit Portlet icon
		mouseOver(ELEMENT_APPS_REG_PORTLET, false);

		click(ELEMENT_EDIT_PORTLET_ICON);

		//Verify Change Show Import checkbox is uncheck

		waitForElementPresent(ELEMENT_SHOW_IMPORT_CHECKBOX);

		//Select checkbox

		check(ELEMENT_SHOW_IMPORT_CHECKBOX);

		save();

		close();

		click(ELEMENT_FINISH_ICON);
		}

		//Verify Import Applications is shown

		waitForElementPresent(ELEMENT_IMPORT_APPLICATION);

		//Add new category

		waitForElementPresent(ELEMENT_CATEGORIES_AREA_TITLE);

		Map<String, String> permissions = new HashMap<String, String>();

		permissions.put(SPACE005_GROUP, DATA_MEMBER_SHIP);

		addNewCategoryAtManageApplications(CATEGORY_NAME, CATE_DISP_NAME, "", false, permissions, false);

		//Add Apps into added Category

		addApplicationToCategory(CATE_DISP_NAME, false, "All People", "Portlet", applicationTitle, true, null, null);

		goToMySpacePage();

		gotoEditSpace(spaceName);

		goToApplications();

		addApplication(CATE_DISP_NAME, applicationTitle);

		info("Reset Data");

		restoreData(spaceName, 240000);    

		goToApplicationRegistry();

		//goto Edit Portlet

		goToEditPageEditor();

		//Click on Edit Portlet icon
		mouseOver(ELEMENT_APPS_REG_PORTLET, false);

		click(ELEMENT_EDIT_PORTLET_ICON);

		//Verify Change Show Import checkbox is uncheck

		waitForElementPresent(SHOW_IMPORT_CHECKED);

		//Select checkbox

		uncheck(ELEMENT_SHOW_IMPORT_CHECKBOX);

		save();

		close();

		//Click Finish

		click(ELEMENT_FINISH_ICON);

		//Verify Import Applications don't shown

		waitForElementNotPresent(ELEMENT_IMPORT_APPLICATION);

		deleteCategoryAtManageApplications(CATE_DISP_NAME, true);
	}

	@AfterMethod
	public void afterMethods() {
		info("-- Logout --");
		signOut();
		driver.quit();
		actions = null;
	}
}