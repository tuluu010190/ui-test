package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class RichTextEditor extends PlatformBase{
	Button but;
	
	//Richtext mode
	public final By ELEMENT_SOURCE_EDITOR_BUTTON= By.xpath("//*[contains(text(),'Source Editor')]");
	public final By ELEMENT_SOURCE_EDITOR_BUTTON_PLF4_1 = By.xpath("//button[contains(text(),'Source Editor')]");
	public final By ELEMENT_CONTENT_WIKI_FRAME = By.xpath("//div[@class='xRichTextEditor']/iframe");
	public final By ELEMENT_CONTENT_WIKI_IMG = By.xpath("//div[@id='UIViewContentDisplay']/../..//img");
	public final By ELEMENT_TWO_LAYOUT_RIGHT = By.xpath("//div[@style='float:left;width:49.2%;padding-right:1.5%;']");
	public final By ELEMENT_TWO_LAYOUT_LEFT = By.xpath("//div[@style='float:left;width:49.2%;']");
	public final By ELEMENT_THREE_LAYOUT_RIGHT = By.xpath("//div[@style='float:left;width:32.300000000000004%;padding-right:1.5%;'][1]");
	public final By ELEMENT_THREE_LAYOUT_MID = By.xpath("//div[@style='float:left;width:32.300000000000004%;padding-right:1.5%;'][2]");
	public final By ELEMENT_THREE_LAYOUT_LEFT = By.xpath("//div[@style='float:left;width:32.300000000000004%;']");
	public final String EMENENT_STATUS_LAYOUT = "//th[contains(text(), '${title}')]";
	public final String EMENENT_HOW_LAYOUT = "//a[contains(text(), '${title}')]";
	public final By EMENENT_LEAVE_PLANING_LAYOUT = By.xpath("//*[contains(text(), 'The Confluence team uses tables to communicate scheduled leave times')]"); 

	//Macro
	public By ELEMENT_MACRO_LINK = By.xpath("//*[text()='Macro']");
	public By ELEMENT_INSERT_MACRO_LINK = By.xpath("//*[text()='Insert Macro...']");
	public By ELEMENT_MACRO_CATEGORY_SELECT = By.xpath("//select[@title='Select a macro category']");
	public By ELEMENT_MACRO_TYPE_FILTER = By.xpath("//input[@title='Type to filter']");
	public String ELEMENT_MACRO_LABEL = "//*[text()='${macro}']";
	public By ELEMENT_RICHTEXTMODE_FRAME = By.id("gwt-RichTextArea");
	public String ELEMENT_MACRO_BOX = "//div[@class='box']/*[contains(.,'${macro}')]";
	public String ELEMENT_MACRO_EXCERPT = "//*[@class='ExcerptClass' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_INFO_MESSAGE = "//*[@class='box infomessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_TABLE_CONTENT = "//span[@class='macro-placeholder' and contains(.,'toc')]";
	public String ELEMENT_MACRO_TIP_MESSAGE = "//*[@class='box tipmessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_ERROR_MESSAGE = "//*[@class='box errormessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_SUCCESS_MESSAGE = "//*[@class='box successmessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_TEXT = "//*[contains(@style,'${color}') and contains(text(),'${text}')]";
	public String ELEMENT_MACRO_WARNING_MESSAGE = "//*[@class='box warningmessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_CHART = "//img[@alt='${title}']";
	public String ELEMENT_MACRO_FOOTNOTE = "//li[contains(.,'${macro}')]//a[text()='^']";
	public By ELEMENT_MACRO_RSS_TITLE = By.xpath("//p[@class='rssitemtitle']");
	public By ELEMENT_MACRO_COLLAPSE_LINK = By.xpath("//div[@class='gwt-MenuItemLabel' and text()='Collapse All']");
	public By ELEMENT_MACRO_EXPAND_LINK = By.xpath("//div[@class='gwt-MenuItemLabel' and text()='Expand All']");

	//Link menu
	public By ELEMENT_LINK = By.xpath("//*[text()='Link']");
	public By ELEMENT_WIKI_PAGE_LINK = By.xpath("//*[text()='Wiki Page...']");

	//Add wiki page link popup
	public By ELEMENT_SEARCH_TAB = By.xpath("//div[text()='Search']");
	public By ELEMENT_SEARCH_TEXTBOX = By.xpath("//input[@title='Type a keyword to search for a wiki page']");
	public By ELEMENT_SEARCH_BUTTON = By.xpath("//button[text()='Search']");
	public String ELEMENT_PAGE_SELECTED = "//*[@class='xPagePreview' and @title='${page}']";
	public String ELEMENT_PAGE_SELECTED_PLF41 = "//*[@class='xPagesSelector xPagesSearch']//*[@class='xPagePreview' and @title='${page}']";
	public By ELEMENT_LABEL_LINK_TEXTBOX = By.xpath("//input[@title='Type the label of the created link.']");
	public By ELEMENT_TOOLTIP_LINK_TEXTBOX = By.xpath("//input[@title='Type the tooltip of the created link, which appears when mouse is over the link.']");
	public By ELEMENT_REMOVE_LINK = By.xpath("//div[text()='Remove Link']");
	public By ELEMENT_EDIT_LINK = By.xpath("//div[text()='Edit Link...']");
	public By ELEMENT_ADD_NEW_LINKPAGE_TEXTBOX =  By.xpath("//input[@title='Type the name of the page to be created. The final name of the page may vary since some characters are filtered.']");
	public By ELEMENT_ALL_PAGE_TAB = By.xpath("//div[contains(text(), 'All pages')]");
	public By ELEMENT_ADD_NEW_PAGE_LINK = By.xpath("//*[@class='gwt-Label xNewPagePreview']");
	public By ELEMENT_ADD_WIKI_PAGE_FRAME = By.xpath("//iframe[@class='gwt-RichTextArea']");

	//Table
	public By ELEMENT_TABLE_LINK = By.xpath("//*[text()='Table']");
	public By ELEMENT_INSERT_TABLE_LINK = By.xpath("//*[text()='Insert Table...']");
	public By ELEMENT_ROW_TEXTBOX = By.xpath("//*[@title='Row count']");
	public By ELEMENT_COLUMN_TEXTBOX = By.xpath("//*[@title='Column count']");
	
	//Macro: Color
	public By ELEMENT_COLOR_TEXTBOX = By.id("pd-name-input");
	public By ELEMENT_COLOR_MESSAGE = By.id("pd-content-input");
	
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
	 * 
	 * @see #createTipMessageMacro(String)
	 * @see #createColorMacro(String, String)
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
			type(ELEMENT_SEARCH_TEXTBOX, page, true);
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
