package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Branding extends PlatformBase {

	public final By ELEMENT_UPLOAD_LINK = By.name("file");

	public final By ELEMENT_PLF_BRANDINGPAGE = By.xpath("//*[@class='uiBreadcumbsNavigations']//*[text()='Branding']");
	public final By ELEMENT_BANDING_PAGE_SELECT_LOGO =By.xpath(".//h4[text()='Select Logo']");
	public final By ELEMENT_BANDING_PAGE_SELECT_NAVIGATION_BAR_STYLE =By.xpath(".//h4[text()='Select Navigation Bar Style']");
	public final By ELEMENT_BANDING_PAGE_PREVIEW =By.xpath(".//h4[text()='Preview']");
	
	//Theme selection
	public final By ELEMENT_PLF_BRANDING_SELECTTHEME = By.xpath("//*[@class='btn dropdown-toggle']");
	public final By ELEMENT_PLF_BRANDING_THEMEDARK = By.xpath("//*[@class='OptionItem' and text()='Dark']");
	public final By ELEMENT_PLF_BRANDING_THEMELIGHT = By.xpath("//*[@class='OptionItem' and text()='Light']");
	
	//Displayed top bar 
	public final By ELEMENT_PLF_BRANDING_TOPBAR_THEMELIGHT = By.xpath("//*[@class='UIContainer UIToolbarContainer  UIToolbarContainerLight']");
	public final By ELEMENT_PLF_BRANDING_TOPBAR_THEMEDARK = By.xpath("//*[@class='UIContainer UIToolbarContainer  UIToolbarContainerLight']");
	public final By ELEMENT_PLF_BRANDING_TOPBAR_LOGO = By.xpath("//*[@alt='Home' and contains(@src, 'logo_preview.png')]");
	
	//Button
	public final By ELEMENT_BUTTON_SAVE = By.xpath("//*[text()='Save']");
	public final By ELEMENT_BUTTON_CANCEL=By.xpath(".//*[@id='cancel']");
	public final By ELEMENT_BUTTON_UPLOAD = By.xpath("//*[@id='btUpload']");
	
	public Branding(WebDriver driver) {
		this.driver = driver;
	}


	public Branding uploadFile(String link, Object... params) {
		info("Upload a file to Site Explorer");
		Boolean verify = (Boolean) (params.length > 0 ? params[0] : true);
		if (waitForAndGetElement(ELEMENT_BUTTON_UPLOAD, DEFAULT_TIMEOUT, 0) == null) {
			info("wrong page");
		}

		
		WebElement upload=waitForAndGetElement(ELEMENT_UPLOAD_LINK,DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility = 'visible'; arguments[0].style.height = '1px'; " +
				"arguments[0].style.width = '1px'; arguments[0].style.opacity = 1", upload);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible'", upload);
		Utils.pause(10000);
		info("Select a file to upload");
		upload.sendKeys(Utils.getAbsoluteFilePath(link));
		info("Upload file " + Utils.getAbsoluteFilePath(link));
		info("Switch to Parent window");
		switchToParentWindow();
		if (verify) {
			Utils.pause(2000);
			waitForAndGetElement(By.xpath("//*[@id='PreviewImg']"));
		}
		info("Upload file successfully");
		Utils.pause(2000);
		return new Branding(driver);
	}
}
