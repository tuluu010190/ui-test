package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Dialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Update: vuna2
 * @author lienTM
 *
 */
public class HomePageActivity extends PlatformBase{
	
	public HomePageActivity(WebDriver dr){
		driver = dr;
	}
	
	Button button = new Button(driver);
	Dialog dialog;
	
	//Content activity
	public final String ELEMENT_CONTENT_NAME = "//a[@title='@{fileName}']";
	public final String ELEMENT_CONTENT_TYPE_ICON = "//a[@title='@{fileName}']/../..//*[@class='${icon}']";
	public final String ELEMENT_CONTENT_TYPE = "//a[@title='@{fileName}']/..//*[@class='versionFile' and contains(text(), '${type}')]";
	public final String ELEMENT_CONTENT_DESCRIPTION = "//a[@title='@{fileName}']/..//*[@class='descriptionText' and text()='${des}']";
	public final String ELEMENT_CONTENT_VERSION = "//a[@title='@{fileName}']/..//*[contains(text(), '${version} -')]";
	public final String ELEMENT_CONTENT_STATUS = "//a[@title='@{fileName}']/..//*[contains(text(), '${status}')]";
	public final String ELEMENT_CONTENT_SUMMARY = "//*[@title='@{fileName}']/..//p";
	public final String ELEMENT_CONTENT_COMMENT_EDIT_TITLE = "//*[@title='@{fileName}']/../../../..//*[@class='commentBox']//*[text()='Title has been updated to: ${title}']";
	public final String ELEMENT_CONTENT_COMMENT_ADD_A_TAG = "//*[@title='@{fileName}']/../../../..//*[@class='commentBox']//*[text()='Tag: ${tags} has been added.']";
	public final String ELEMENT_CONTENT_COMMENT_ADD_TAGS = "//*[@title='@{fileName}']/../../../..//*[@class='commentBox']//*[text()='Tags: ${tags} have been added.']";
	public final String ELEMENT_CONTENT_COMMENT_PUBLISH = "//*[@title='@{fileName}']/../../../..//*[@class='commentBox']//*[text()='Publication has been published.']";
	public final String ELEMENT_CONTENT_EDIT_LINK = "//a[@title='@{fileName}']/../../../..//*[@class='uiIconEdit uiIconLightGray']";
	public final String ELEMENT_CONTENT_VIEW_LINK = "//a[@title='@{fileName}']/../../../..//*[@class='uiIconWatch uiIconLightGray']";
	public final String ELEMENT_CONTENT_COMMENT_MOVING = "//*[@title='@{fileName}']/../../../..//*[@class='commentBox']//*[text()='Publication has been moved to: ${path}']";
	
	//File activity
	public final String ELEMENT_FILE_SIZE = "//a[@title='@{fileName}']/..//*[@class='versionFile' and contains(text(), '${size}')]";
	public final String ELEMENT_FILE_COMMENT_ADD_CATEGORY = "//*[@title='@{fileName}']/../../../..//*[@class='commentBox']//*[text()='Category: ${category} has been added.']";
	public final By ELEMENT_FILE_VIEW_POPUP = By.id("UISocialPopupWindow");
	public final String ELEMENT_FILE_VIEW_NAME = "//*[@id='UISocialPopupWindow']//*[text()='${fileName}']";
	public final String ELEMENT_FILE_COMMENT_MOVING = "//*[@title='@{fileName}']/../../../..//*[@class='commentBox']//*[text()='File has been moved to: ${path}']";
	
	//Edit screen from click Edit in activity
	public final By ELEMENT_CONTENT_EDIT_SCREEN_FROM_ACTIVITY = By.id("UIJCRExplorerPortlet");
	public final By ELEMENT_CONTENT_EDIT_SCREEN_BACK = By.xpath("//a[@data-original-title='Back']");
	
	/** function check info in activity of a content/file
	 * @author lientm
	 * @param name
	 * @param iconType
	 * @param contentType
	 * @param size
	 * @param content
	 * @param version
	 * @param des
	 * @param status
	 */
	public void checkInforAfterAddingDocument(String name, String iconType, String contentType, String size, String content, 
			String version, String des, String status){
		info("Check name of content");
		waitForAndGetElement(ELEMENT_CONTENT_NAME.replace("@{fileName}", name));
		if (iconType != ""){
			info("Check icon content type");
			waitForAndGetElement(ELEMENT_CONTENT_TYPE_ICON.replace("@{fileName}", name).replace("${icon}", iconType));	
		}
		if (contentType != ""){
			info("Check content type");
			waitForAndGetElement(ELEMENT_CONTENT_TYPE.replace("@{fileName}", name).replace("${type}", contentType));
		}
		if (content != ""){
			info("Check content summary");
			String[] sum = getText(ELEMENT_CONTENT_SUMMARY.replace("@{fileName}", name)).split("\n");
			String[] cont = content.split("/");
			if (cont.length > 4){
				assert sum[4].equalsIgnoreCase("...");
				for (int i = 0; i < 4; i++){
					assert sum[i].equalsIgnoreCase(cont[i]);
				}
			}else {
				for (int i = 0; i < cont.length; i ++){
					assert sum[i].equalsIgnoreCase(cont[i]);
				}
			}
		}
		if (size != ""){
			info("Check content size");
			waitForAndGetElement(ELEMENT_FILE_SIZE.replace("@{fileName}", name).replace("${size}", size));
		}
		if (version != ""){
			info("Check content version");
			waitForAndGetElement(ELEMENT_CONTENT_VERSION.replace("@{fileName}", name).replace("${version}", version));
		}
		if (des != ""){
			info("Check content description");
			waitForAndGetElement(ELEMENT_CONTENT_DESCRIPTION.replace("@{fileName}", name).replace("${des}", des));
		}
		if (status != ""){
			info("Check content status");
			waitForAndGetElement(ELEMENT_CONTENT_STATUS.replace("@{fileName}", name).replace("${status}", status));
		}
	}

	/**Function check add comment in activity after editing title of a file/content
	 * @author lientm
	 * @param name
	 * @param titleEdit
	 */
	public void checkTitleAfterEditing(String name, String titleEdit){
		waitForAndGetElement(ELEMENT_CONTENT_COMMENT_EDIT_TITLE.replace("@{fileName}", name).replace("${title}", titleEdit));
	}
	
	/** function check add comment in activity after adding tags for a content/file
	 * @author lientm
	 * @param name
	 * @param tags
	 * @param number
	 */
	public void checkTagAfterAddingToContent(String name, String tags, int number){
		if (number == 1){
			waitForAndGetElement(ELEMENT_CONTENT_COMMENT_ADD_A_TAG.replace("@{fileName}", name).replace("${tags}", tags));
		}else {
			waitForAndGetElement(ELEMENT_CONTENT_COMMENT_ADD_TAGS.replace("@{fileName}", name).replace("${tags}", tags));
		}
	}
	
	/** function check add comment in activity after publishing a conent/file
	 * @author lientm
	 * @param name
	 */
	public void checkStatusAfterPublishAContent(String name){
		waitForAndGetElement(ELEMENT_CONTENT_COMMENT_PUBLISH.replace("@{fileName}", name));
	}
	
	/** function check add comment in activity after adding new category for a content/file
	 * @author lientm
	 * @param name
	 * @param category
	 */
	public void checkCategoryAfterAddingToContent(String name, String category){
		waitForAndGetElement(ELEMENT_FILE_COMMENT_ADD_CATEGORY.replace("@{fileName}", name).replace("${category}", category));
	}
	
	/**function check go to edit screen after clicking Edit icon in activity
	 * @author lientm
	 * @param name
	 */
	public void goToEditFromContentActivity(String name){
		click(ELEMENT_CONTENT_EDIT_LINK.replace("@{fileName}", name));
		waitForAndGetElement(ELEMENT_CONTENT_EDIT_SCREEN_FROM_ACTIVITY);
		waitForAndGetElement(button.ELEMENT_SAVE_CLOSE_BUTTON);
	}
	
	/** function back homepage from edit screen
	 * @author lientm
	 */
	public void backToHomePageFromEditContentScreen(){
		click(ELEMENT_CONTENT_EDIT_SCREEN_BACK);
		waitForElementNotPresent(ELEMENT_CONTENT_EDIT_SCREEN_BACK);
	}
	
	/**function check go to view screen after clicking View icon in activity of a content
	 * @author lientm
	 * @param name
	 */
	public void goToViewFromContentActivity(String name){
		click(ELEMENT_CONTENT_VIEW_LINK.replace("@{fileName}", name));
		waitForAndGetElement(ELEMENT_CONTENT_EDIT_SCREEN_FROM_ACTIVITY);
		assert getValue(By.id("address")).contains(name);
	}
	
	/**function check go to view screen after clicking View icon in activity of a file
	 * @author lientm
	 * @param name
	 */
	public void goToViewFromFileActivity(String name){
		dialog = new Dialog(driver);
		click(ELEMENT_CONTENT_VIEW_LINK.replace("@{fileName}", name));
		waitForAndGetElement(ELEMENT_FILE_VIEW_POPUP);
		waitForAndGetElement(ELEMENT_FILE_VIEW_NAME.replace("${fileName}", name));
		dialog.closeMessageDialog();
	}
	
	/** function check add comment in activity after moving a conent/file
	 * @author lientm
	 * @param name
	 * @param path
	 * @param content
	 */
	public void checkContentAfterMovingANode(String name, String path, boolean content){
		if (content){
			waitForAndGetElement(ELEMENT_CONTENT_COMMENT_MOVING.replace("@{fileName}", name).replace("${path}", path + name));
		}else {
			waitForAndGetElement(ELEMENT_FILE_COMMENT_MOVING.replace("@{fileName}", name).replace("${path}", path + name));
		}
	}
}