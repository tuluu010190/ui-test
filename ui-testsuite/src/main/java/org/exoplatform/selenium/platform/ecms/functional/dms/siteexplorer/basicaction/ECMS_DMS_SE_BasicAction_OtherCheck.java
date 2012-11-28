package org.exoplatform.selenium.platform.ecms.functional.dms.siteexplorer.basicaction;

import org.exoplatform.selenium.platform.ecms.EcmsBase;
import static org.exoplatform.selenium.platform.ecms.SiteExplorer.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.exoplatform.selenium.platform.ecms.ContentTemplate.*;
import static org.exoplatform.selenium.platform.ecms.ContextMenu.deleteDocument;
import static org.exoplatform.selenium.platform.ecms.ActionBar.*;
import static org.exoplatform.selenium.TestLogger.info;

/*
 * @author: HangNTT
 * @date: 18/10/2012
 */

public class ECMS_DMS_SE_BasicAction_OtherCheck  extends EcmsBase {
	
	public static By LIST_VIEW = By.xpath("//a[@title='List View']");
	public static By UPLOAD = By.xpath("//a[@title='Upload']");
	public static By REMOVE_THUMBNAIL = By.xpath("//img[@alt='Remove this thumbnail']");
	public static By ICON_VIEW = By.xpath("//a[@title='Icon View']");
	public static final By ELEMENT_PRIVATE = By.xpath("//div[@id='UISideBar']/div/div/div[2]/div/div/div/div/div");


	@BeforeMethod
	public void beforeMethods(){
		initSeleniumTest();
		driver.get(baseUrl);
		actions = new Actions(driver);
		loginEcms("john","gtn");
	}
	
	public void waitAddThumbnailPresent(){
		if (waitForAndGetElement(ELEMENT_OVERLOAD_THUMBNAIL, 10000, 0) == null){
			click(By.xpath("//div[text()='More']"));
			waitForElementPresent(ELEMENT_OVERLOAD_THUMBNAIL);
		}
	}

	//Add and remove thumbnail image
	@Test
	public void test39_40_AddRemoveThumbnailImage(){

		String DATA_UPLOAD_FILE_NAME = "AddThumbnailFile";
		By ELEMENT_UPLOAD_FILE = By.xpath("//a[@title='"+DATA_UPLOAD_FILE_NAME+".doc "+"']");
		String DATA_UPLOAD_FILE_LINK = "TestData/ECMS_DMS_SE_Upload_docfile.doc";
		String DATA_UPLOAD_FILE = "TestData/Winter.jpg";

		info("Go to CE");
		goToSiteExplorer();

		info("Click Show Driver");
		chooseDrive(ELEMENT_PRIVATE_DRIVER);

		info("Choose List view");
		click(LIST_VIEW);
		waitForElementNotPresent(ELEMENT_OVERLOAD_THUMBNAIL);

		info("Upload file");
		uploadFile(DATA_UPLOAD_FILE_NAME, DATA_UPLOAD_FILE_LINK);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		goToNode(ELEMENT_UPLOAD_FILE);
		pause(2000);

		info("Change to Thumbnail view");
		click(ICON_VIEW);
		click(ELEMENT_UPLOAD_FILE);
		waitAddThumbnailPresent();

		info("Upload thumbnail");
		uploadThumbnail(DATA_UPLOAD_FILE);

		info("Back to parent node");
		click(ELEMENT_PRIVATE);
		info("verify new thumbnail");
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		goToNode(ELEMENT_UPLOAD_FILE);

		info("Verify after add thumbnail");
		waitAddThumbnailPresent();
		assert isElementPresent(ELEMENT_OVERLOAD_THUMBNAIL):"Cannot see";
		click(ELEMENT_OVERLOAD_THUMBNAIL);

		waitForElementPresent(By.id("UIPopupWindow"));
		assert isElementPresent(By.id("UIPopupWindow")):"Cannot see popup";
		captureScreen(DATA_UPLOAD_FILE);

		info("Delete thumbnail");
		waitForElementPresent(REMOVE_THUMBNAIL);
		click(REMOVE_THUMBNAIL);
		pause(1000);
		waitForElementNotPresent(REMOVE_THUMBNAIL);
		cancel();

		info("Delete document");
		goToNode(ELEMENT_UPLOAD_FILE);
		waitForElementPresent(ELEMENT_UPLOAD_FILE);
		deleteDocument(ELEMENT_UPLOAD_FILE);
	}

	@AfterMethod
	public void afterTest(){
		//logoutEcms();
		driver.quit();
	}
}