package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class RichTextEditor extends WikiLocators{
	Button but;
	
	
	
	/**
	 * constructor
	 * @param dr
	 */
	public RichTextEditor(WebDriver dr){
		this.driver=dr;
		but = new Button(driver);
	}
	
	/**
	 * Click End then Enter in content frame in Rich text mode of Wiki page editor
	 */
	public void typeEnterInRichText(){
		try {
			WebElement inputsummary = null;
			driver.switchTo().frame(waitForAndGetElement(ELEMENT_CONTENT_WIKI_FRAME));
			inputsummary = driver.switchTo().activeElement();
			inputsummary.click();
			inputsummary.sendKeys(Keys.END);
			inputsummary.sendKeys(Keys.ENTER);
			switchToParentWindow();
			Utils.pause(1000);
			driver.switchTo().defaultContent();
		}catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			typeEnterInRichText();
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			typeEnterInRichText();
		}catch (WebDriverException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			typeEnterInRichText();
		}
		finally {
			loopCount = 0;
		}
	}
	
	/**
	 * Select a macro in a Wiki page editor
	 * 
	 * @param cat
	 * 			category to which a macro that will be chosen belongs
	 * @param macro
	 * 			macro name that will be chosen
	 */
	public void goToSelectAMacro(String cat, String macro){
		info("Select a macro: " + macro);
		mouseOverAndClick(ELEMENT_MACRO_LINK);
		mouseOverAndClick(ELEMENT_INSERT_MACRO_LINK);
		select(ELEMENT_MACRO_CATEGORY_SELECT, cat);
		mouseOverAndClick(ELEMENT_MACRO_TYPE_FILTER);
		type(ELEMENT_MACRO_TYPE_FILTER,macro,true);
		Utils.pause(1000);
		click(ELEMENT_MACRO_LABEL.replace("${macro}", macro));
		click(but.ELEMENT_SELECT_BUTTON);
		Utils.pause(3000);
	}
	
	/**
	 * Add link to a Wiki page
	 * 
	 * @param search
	 * 			parameter to choose whether to search page link or not
	 * @param page
	 * 			Wiki page that will be the target link
	 * @param label
	 * 			label of link that will be added into Wiki page
	 * @param tooltip
	 * 			
	 */
	public void insertPageLink2WikiPage(boolean search, String page, String label, String tooltip,Object...opParam){
		Boolean verify =(Boolean)(opParam.length>0?opParam[0]:false);
		mouseOverAndClick(ELEMENT_LINK);
		mouseOverAndClick(ELEMENT_WIKI_PAGE_LINK);
		Utils.pause(500);
		info("Create link to the page " + page);
		if (search){
			click(ELEMENT_SEARCH_TAB);
			type(ELEMENT_SEARCH_TEXTBOX_POPUP, page, true);
			click(ELEMENT_SEARCH_BUTTON);
		}
		if(waitForAndGetElement(ELEMENT_PAGE_SELECTED.replace("${page}", page), 5000,0)!=null)
			click(ELEMENT_PAGE_SELECTED.replace("${page}", page));
		else
			click(ELEMENT_PAGE_SELECTED_PLF41.replace("${page}", page));
		click(but.ELEMENT_SELECT_BUTTON);
		if(label!=null && label!="")
			type(ELEMENT_LABEL_LINK_TEXTBOX,label,true);
		if(tooltip!=null && tooltip!="")
			type(ELEMENT_TOOLTIP_LINK_TEXTBOX,tooltip,true);
		Utils.pause(500);
		click(but.ELEMENT_CREATE_LINK_BUTTON);
		waitForElementNotPresent(but.ELEMENT_CREATE_LINK_BUTTON);
		if(verify){
			WebElement e = waitForAndGetElement(ELEMENT_CONTENT_WIKI_FRAME,DEFAULT_TIMEOUT,1,2);
			driver.switchTo().frame(e);
			if(label!=null && label!="")
				waitForAndGetElement(By.linkText(label));
			if(tooltip!=null && tooltip!="")
				waitForAndGetElement(By.xpath("//*[@title='"+tooltip+"']"));
			switchToParentWindow();
		}
	}
	
	/**
	 * Add table to a Wiki page
	 * 
	 * @param rows
	 * 			Number of rows that will be added in the table
	 * @param columns
	 * 			Number of columns that will be added in the table
	 */
	public void insertTable2WikiPage(String rows, String columns){
		mouseOverAndClick(ELEMENT_TABLE_LINK);
		mouseOverAndClick(ELEMENT_INSERT_TABLE_LINK);
		type(ELEMENT_ROW_TEXTBOX, rows, true);
		type(ELEMENT_COLUMN_TEXTBOX, columns, true);
		click(but.ELEMENT_INSERT_TABLE);
		waitForAndGetElement("//table");
	}
	
	/**
	 * Add macro: "color" into a Wiki page
	 * 
	 * @param color
	 * 			color setting of macro
	 * @param message
	 * 			message setting of macro
	 */
	public void createColorMacro(String color, String message){
		goToSelectAMacro("Formatting", "Color");
		type(ELEMENT_COLOR_TEXTBOX, color, true);
		type(ELEMENT_COLOR_MESSAGE, message, true);
		click(but.ELEMENT_CREATE_MACRO_BUTTON);
	}
}
