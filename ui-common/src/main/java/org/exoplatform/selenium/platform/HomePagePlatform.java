package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.TestBase;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePlatform extends TestBase{
	WikiHomePage wHome;
	CalendarHomePage cHome;
	
	//Left panel
	public final By ELEMENT_WIKI_LINK_PLF=By.xpath("//*[@data-original-title='Wiki']");
	public final By ELEMENT_HOME_LINK_PLF=By.xpath("//*[@data-original-title='Home']");
	public final By ELEMENT_CALENDAR_LINK_PLF=By.xpath("//*[@data-original-title='Calendar']");

	//Middle homepage panel
	public final By ELEMENT_HOMPAGE_MIDDLE_PANEL = By.id("OfficeMiddle");
	
	//Wiki activity
	public final String ELEMENT_WIKI_COMMENT_EDIT_TITLE = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'title has been updated to: ${title}')]";
	public final String ELEMENT_WIKI_COMMENT_EDIT_CONTENT = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'content has been edited')]";
	public final String ELEMENT_ACTIVITY_WIKI_TITLE = "//*[@class='linkTitle' and text()='${title}']";
	public final String ELEMENT_ACTIVITY_WIKI_CONTENT = "//*[@class='linkTitle' and text()='${title}']/../../..//*[@class='contentWiki theContent']/*[@class='text']";
	public final String ELEMENT_ACTIVITY_WIKI_VERSION = "//*[@class='linkTitle' and text()='${title}']/../..//*[@class = 'pull-right versionLabel' and contains(text(), 'Version: ${version}')]";
	public final String ELEMENT_ACTIVITY_MOVE_WIKI_PAGE = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'Page has been moved to: ${path}')]";

	//Right panel

	/**
	 * constructor
	 * @param dr
	 */
	public HomePagePlatform(WebDriver dr){
		this.driver=dr;
		wHome = new WikiHomePage(dr);
		cHome = new CalendarHomePage(dr);
	}
	
	/**
	 * Go to Wiki portlet
	 */
	public void goToWiki(){
		info("--Go to Wiki--");
		click(ELEMENT_WIKI_LINK_PLF);
		waitForAndGetElement(wHome.ELEMENT_WIKI_HOME_PAGE_LINK);	
	}

	/**
	 * Go to Home page
	 */
	public void goToHomePage(){
		info("--Go to Home page--");
		click(ELEMENT_HOME_LINK_PLF);
		waitForAndGetElement(ELEMENT_HOMPAGE_MIDDLE_PANEL);
	}
	
	/**
	 * Go to Home Calendar Page
	 */
	public void goToCalendarPage(){
		info("-- Go to calendar home page --");
		click(ELEMENT_CALENDAR_LINK_PLF);
		waitForAndGetElement(cHome.ELEMENT_CALENDAR_WORKING_PANEL);
	}
}

