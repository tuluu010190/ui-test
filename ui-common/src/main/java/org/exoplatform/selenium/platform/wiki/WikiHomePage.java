package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WikiHomePage extends PlatformBase{

	public final String ELEMENT_WIKI_PAGE_LINK = "//*[@href='/portal/intranet/wiki/${pageTitle}']";
	public final By ELEMENT_WIKI_HOME_PAGE_LINK = By.xpath("//*[@href='/portal/intranet/wiki/WikiHome']");
	public final By ELEMENT_WIKI_HOME_PAGE_TEXT = By.xpath("//*[@id='titleInfo' and text()='Wiki Home']");
	public final By ELEMENT_ADD_PAGE_LINK = By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']//div[contains(text(),'Add Page')]");
	public final By ELEMENT_FROM_TEMPLATE_LINK = By.xpath ("//i[@class='uiIconAddPageFromTemplate']");
	public final By ELEMENT_BLANK_PAGE_LINK = By.xpath ("//i[@class='uiIconAddPage']");
	
	public final String ELEMENT_WIKI_HOME_PAGE_TITLE = "//*[@id='titleInfo' and text()='${title}']";

	public final By ELEMENT_EDIT_PAGE_LINK= By.xpath("//*[@class='uiIconEditPage uiIconLightGray']");;
	
	//More menu
	public final By ELEMENT_MORE_LINK = By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']//div[contains(text(), 'More')]");
	public final By ELEMENT_DELETE_LINK = By.xpath(".//*[text()='Delete Page']");
	public final By ELEMENT_DELETE_LINK_2 = By.className("uiIconDeletePage");
	public final By ELEMENT_CONFIRM_WIKI_DELETE = By.xpath(".//*[@id='UIWikiDeletePageConfirm']//button[text()='OK']");
	
	//Content of page
	public final String ELEMENT_MARCRO_COLOR = "//*[@style='color:${color};' and contains(text(),'${message}')]";
	public final By ELEMENT_PAGE_TITLE_INFO = By.id("titleInfo");
	public final String ELEMENT_PAGE_TITLE = ".//*[@id='titleInfo'][text()='${title}']";
	public final By ELEMENT_PAGE_TITLE_EDIT_TEXTBOX = By.id("EdiableInput");
	public final By ELEMENT_PAGE_ATTACHFILE = By.xpath("//*[contains(.,'1')]//*[@class='uiIconAttach']");
	public final By ELEMENT_PAGE_DOWNLOADATTACHFILE = By.xpath("//*[@data-original-title='Download Attachment']");
	public final By ELEMENT_PAGE_DELETEATTACHFILE = By.xpath("//*[@class='uiIconDelete uiIconLightGray']");
	
	
	//Action bar
	public String ELEMENT_ATTACHMENT_NUMBER = "//*[@id='UIWikiPageInfoArea']//a[contains(text(),'${No}')]/*[@class='uiIconAttach']";
	public By ELEMENT_ATTACHMENT_ICON = By.xpath("//*[@id='UIWikiPageInfoArea']//*[@class='uiIconAttach']");
	public By ELEMENT_SEARCH_TEXTBOX = By.xpath("//*[@id='wikiSearchValue']");
	
	//Browsers
	public final By ELEMENT_SEARCH_BROWSERS_DROPDOWN = By.xpath("//*[@class='uiActionWithLabel']/..//*[text()='Browse']");
	public final By ELEMENT_SEARCH_BROWSERS_WIKI_SETTINGS = By.xpath(".//*[@class='dropdown-menu']//*[text()='Wiki Settings']");
	
	//tree explorer
	public final String ELEMENT_TREE_WIKI_NAME = ".//*[@id='iconTreeExplorer']//*[contains(text(),'${name}')]";
	/**
	 * constructor
	 * @param dr
	 */
	public WikiHomePage(WebDriver dr){
		this.driver=dr;
	}
	/**
	 * Go to "Add blank wiki page"
	 * 
	 */
	public void goToAddBlankPage(){
		info("--Go to add blank wiki page--");
		mouseOverAndClick(ELEMENT_ADD_PAGE_LINK);
		mouseOverAndClick(ELEMENT_BLANK_PAGE_LINK);
	}

	/**
	 * Go to "Add template wiki page"
	 * 
	 */
	public void goToAddTemplateWikiPage(){
		info("--Go to add template wiki page--");
		mouseOverAndClick(ELEMENT_ADD_PAGE_LINK);
		mouseOverAndClick(ELEMENT_FROM_TEMPLATE_LINK);
	}

	/**
	 * Go to "Add blank wiki page"
	 * 
	 */
	public void goToEditPage(){
		info("--Go to edit page--");
		click(ELEMENT_EDIT_PAGE_LINK);
		waitForElementNotPresent(ELEMENT_WIKI_HOME_PAGE_TEXT);
	}

	/**
	 * Go to Home Wiki Page
	 */
	public void goToHomeWikiPage(){
		info("-- Go to wiki home page --");
		click(ELEMENT_WIKI_HOME_PAGE_LINK);
		waitForAndGetElement(ELEMENT_WIKI_HOME_PAGE_TEXT);
	}

	/**
	 * Select any page
	 * @param title
	 */
	public void goToAPage(String title){
		info("-- Go to wiki page --");
		click(ELEMENT_WIKI_PAGE_LINK.replace("${pageTitle}", title.replace(" ", "_")));
		waitForElementNotPresent(ELEMENT_WIKI_HOME_PAGE_TEXT);
	}

	/**
	 * Select any page
	 * @param title
	 */
	public void deleteWiki(String title){
		info("Go to delete wiki page...");
		info("Select the wiki page to delete");
		waitForAndGetElement(ELEMENT_TREE_WIKI_NAME.replace("${name}",title),2000,0).click();
		info("Click on More link");
		click(ELEMENT_MORE_LINK);
		if (waitForAndGetElement(ELEMENT_DELETE_LINK, 5000, 0) == null){
			mouseOverAndClick(ELEMENT_DELETE_LINK);
		}else {
			click(ELEMENT_DELETE_LINK);
		}
		waitForAndGetElement(ELEMENT_CONFIRM_WIKI_DELETE,2000,0).click();
		waitForElementNotPresent(ELEMENT_TREE_WIKI_NAME.replace("${name}",title),2000,0);
	}
	
	/**
	 * Go to "Go to My Draft"
	 * 
	 */
	public void goToMyDraft(){
		info("--Go to add blank wiki page--");
		mouseOverAndClick(ELEMENT_ADD_PAGE_LINK);
		mouseOverAndClick(ELEMENT_BLANK_PAGE_LINK);
	}
	/**
	 * Open search page with a text
	 * @param text
	 */
	public void goTosearchPage(String text){
		info("Input a text to search field");
		type(ELEMENT_SEARCH_TEXTBOX, text, true);
		info("Press Enter key");
		driver.findElement(ELEMENT_SEARCH_TEXTBOX).sendKeys(Keys.ENTER);
        Utils.pause(2000);
	}
	/**
	 * Open Wiki Settings page
	 */
	public void goToWikiSettingPage(){
		info("Click on Browser drop down");
		click(ELEMENT_SEARCH_BROWSERS_DROPDOWN);
		info("Select wiki settings label");
		click(ELEMENT_SEARCH_BROWSERS_WIKI_SETTINGS);
		Utils.pause(2000);
	}
}
