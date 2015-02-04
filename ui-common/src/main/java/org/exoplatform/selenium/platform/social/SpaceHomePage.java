package org.exoplatform.selenium.platform.social;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpaceHomePage extends PlatformBase{

	
	public final By ELEMENT_SPACE_PANEL=By.xpath(".//*[@id='UIMySpacesPortlet']");
	
	//select menu (actvity stream, forum, agenda etc ..)
	public final By ELEMENT_SPACE_MENU_ACTIVITY_STREAM = By.xpath(".//*[@class='tabName' and contains(text(),' Activity Stream')]");
	public final By ELEMENT_SPACE_MENU_AGENDA = By.xpath(".//*[@id='calendar' and contains(text(),'Agenda')]");
	public final By ELEMENT_SPACE_MENU_FORUMS = By.xpath(".//*[@class='tabName' and contains(text(),'Forums')]");
	public final By ELEMENT_SPACE_MENU_WIKI = By.xpath(".//*[@class='tabName' and contains(text(),'Wiki')]");
	public final By ELEMENT_SPACE_MENU_DOCUMENTS = By.xpath(".//*[@class='tabName' and contains(text(),'Documents')]");
	public final By ELEMENT_SPACE_MENU_SETTINGS = By.xpath(".//*[@class='tabName' and contains(text(),'Space Settings')]");
	public final By ELEMENT_SPACE_MENU_ANSWER = By.xpath(".//*[@class='tabName' and contains(text(),'Answer')]");
	public final String ELEMENT_SPACE_NAME = ".//*[@id='UIBreadCrumbsNavigationPortlet']//*[@class='name'][contains(text(),'${name}')]";
	
	
	/**
	 * constructor
	 * @param dr
	 */
	public SpaceHomePage(WebDriver dr){
		this.driver=dr;
	}
	/**
	 * Go to settings app
	 */
	public void goToSettings(){
		click(ELEMENT_SPACE_MENU_SETTINGS);
	}
}