package org.exoplatform.selenium.platform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IDEManagement extends PlatformBase {
	
	public IDEManagement(WebDriver driver) {
	this.driver = driver;	
	}

	public final By ELEMENT_PLF_IDE_DISPLAY = By.xpath("//*[@class='navItemSelected' and text()='IDE']");
	public final By ELEMENT_PLF_IDE_FOLDER = By.xpath("//*[@class='treeCellSelected']//*[contains(text(),'dev-monit')]");
	public final By ELEMENT_PLF_IDE_WORKSPACE = By.xpath("//*[contains(text(),'Workspace')]");
}
