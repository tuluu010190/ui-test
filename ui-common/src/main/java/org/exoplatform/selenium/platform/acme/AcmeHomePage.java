package org.exoplatform.selenium.platform.acme;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AcmeHomePage extends PlatformBase {

	public final By ELEMENT_TOPBAR_SEARCHBOX = By.xpath("//*[@class='keyword']");
	public final String ELEMENT_SEARCHRESULT_TITLE = "//*[@class='content']//*[text()='${title}']";
	public final By ELEMENT_BARMENU_NEWS = By.xpath("//*[@title='News']");
	
	
	public AcmeHomePage(WebDriver driver) {
		this.driver= driver;
	}


	public void searchQuickSearchBox(String name) {
		type(ELEMENT_TOPBAR_SEARCHBOX, name, true);
		driver.findElement(ELEMENT_TOPBAR_SEARCHBOX).sendKeys(Keys.ENTER);
	}
	
	public void goToNews() {
		click(ELEMENT_BARMENU_NEWS);
	}
}
