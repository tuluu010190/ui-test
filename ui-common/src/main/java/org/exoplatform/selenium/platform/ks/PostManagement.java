package org.exoplatform.selenium.platform.ks;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.UserGroupManagement.selectGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PostManagement extends TopicManagement{
	
	//--------------post home screen--------------------------------------------------------
	public static By ELEMENT_POST_REPLY_BUTTON = By.xpath("//*[@class='ButtomAndPageListContainer ClearFix']/*//a[text()='Post Reply']");
	public static String ELEMENT_POST_EDIT_BUTTON = "//*[text()='${postContent}']/../../../../*//a[text()='Edit' and @class='IconButton EditPostIcon']";
	public static String ELEMENT_POST_DELETE_BUTTON = "//*[text()='${postContent}']/../../../../*//a[text()='Delete' and @class='IconButton DeletePostIcon']";
	public static String ELEMENT_POST_CHECKBOX = "//*[text()='${postContent}']/../../../../*//input[@type='checkbox']";
	public static By ELEMENT_MOVE_POST = By.xpath("//a[@class='ItemIcon MovePostIcon' and text()='Move']");
	public static String ELEMENT_GO_TO_THE_LASTS_READ_POST_FORUM = "//a[text()='${forum}']/../..//a[@title='Go to the last read post']";
	
	//--------------post reply screen-----------------------------------------------------------
	public static By ELEMENT_POST_TITLE = By.id("PostTitle");
	public static By ELEMENT_POST_MESSAGE_FRAME_1 = By.xpath("//iframe[@id='MessageContent___Frame']");
	public static By ELEMENT_POST_MESSAGE_FRAME_2 = By.xpath("//td[@id='xEditingArea']/iframe");
	public static By ELEMENT_POST_POPUP_NEW = By.xpath("//span[@class='PopupTitle' and text()='New Post']");
	public static By ELEMENT_POST_ICONS_TAB = By.xpath("//a[contains(text(), 'Icons and Smileys')]");
	
	//--------------quick reply form-----------------------------------------------------------
	public static By ELEMENT_POST_QUICK_MESSAGE = By.id("Message");
	public static By ELEMENT_POST_QUICK_BUTTON = By.linkText("Quick Reply");
	
	//--------------edit post screen-----------------------------------------------------------
	public static By ELEMENT_POST_POPUP_EDIT = By.xpath("//span[@class='PopupTitle' and text()='Edit Post']");
	public static By ELEMENT_POST_REASON = By.id("editReason");
	
	//--------------move post screen-----------------------------------------------------------
	public static By ELEMENT_POPUP_MOVE_POST = By.xpath("//span[@class='PopupTitle' and text()='Move Posts']");
	
	
	/** function: post new reply
	 * @author lientm
	 * @param title: title of reply
	 * @param message: content of reply
	 * @param groupName: group of icon
	 * @param iconClass: icon
	 * @param file: file attach
	 */
	public static void postReply(String title, String message, String groupName, String iconClass, String... file){
		info("Post a reply");
		click(ELEMENT_POST_REPLY_BUTTON);
		waitForElementPresent(ELEMENT_POST_POPUP_NEW);
		if (title != "" && title != null) {
			type(ELEMENT_POST_TITLE, title, true);
		}
		if (message != "" && message != null) {
			inputDataToFrameInFrame(ELEMENT_POST_MESSAGE_FRAME_1, ELEMENT_POST_MESSAGE_FRAME_2, message, true);
			switchToParentWindow();	
		}
		if(file.length > 0 && file[0] != "" && file[0] != null){
			click(ELEMENT_ATTACH_FILE);
			waitForElementPresent(ELEMENT_POPUP_UPLOAD_FILE);
			attachSomeFile(file);
			waitForElementNotPresent(ELEMENT_POPUP_UPLOAD_FILE);
		}	
		if (groupName != "" && groupName != null && iconClass != "" && iconClass != null){
			click(ELEMENT_POST_ICONS_TAB);
			chooseIcon(groupName, iconClass);
		}
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_POST_POPUP_NEW);
		info("Post reply successfully");
	}
	
	/** function: quick add new Reply
	 * @author lientm
	 * @param message: content of reply
	 */
	public static void quickReply(String message){
		type(ELEMENT_POST_QUICK_MESSAGE, message, true);
		click(ELEMENT_POST_QUICK_BUTTON);
		info("Quick reply successfully");
	}
	
	/** function: Edit a Post
	 * @author lientm
	 * @param postContent: content of post that needs to edit
	 * @param title: new title of post
	 * @param reason: reason edit
	 * @param message: new message
	 * @param groupName: new group icon
	 * @param iconClass: new icon
	 * @param file: new file attach
	 */	
	public static void editPost(String postContent, String title, String reason, String message, String groupName, String iconClass, String... file){
		By EDIT_POST = By.xpath(ELEMENT_POST_EDIT_BUTTON.replace("${postContent}", postContent));
		
		info("Edit a post");
		click(EDIT_POST);
		waitForElementPresent(ELEMENT_POST_POPUP_EDIT);
		if (title != "" && title != null) {
			type(ELEMENT_POST_TITLE, title, true);
		}
		if (reason != "" && reason != null){
			type(ELEMENT_POST_REASON, reason, true);
		}
		if (message != "" && message != null) {
			inputDataToFrameInFrame(ELEMENT_POST_MESSAGE_FRAME_1, ELEMENT_POST_MESSAGE_FRAME_2, message, true);
			switchToParentWindow();	
		} 
		if(file.length > 0 && file[0] != "" && file[0] != null){
			click(ELEMENT_ATTACH_FILE);
			waitForElementPresent(ELEMENT_POPUP_UPLOAD_FILE);
			attachSomeFile(file);
			waitForElementNotPresent(ELEMENT_POPUP_UPLOAD_FILE);
		}	
		if (groupName != "" && groupName != null && iconClass != "" && iconClass != null){
			click(ELEMENT_POST_ICONS_TAB);
			chooseIcon(groupName, iconClass);
		}
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_POST_POPUP_EDIT);
		if (isElementPresent(ELEMENT_ALERT) == true){
			click(By.linkText("OK"));
		}
		info("Edit post successfully");
	}
	
	/**function: delete a post
	 * @author lientm
	 * @param content: content of post that needs to delete
	 */
	public static void deletePost(String content){
		By DELETE_POST = By.xpath(ELEMENT_POST_DELETE_BUTTON.replace("${postContent}", content));
		
		info("Delete a post");
		click(DELETE_POST);
		acceptAlert();
		waitForElementNotPresent(DELETE_POST);
		info("Delete post successfully");
	}
	
	/** function: mode a post to other topic
	 * @author lientm
	 * @param content: content of post
	 * @param destination: path to new topic
	 */
	public static void movePost(String content, String destination){
		By element_checkbox = By.xpath(ELEMENT_POST_CHECKBOX.replace("${postContent}", content));
		
		WebElement element = waitForAndGetElement(element_checkbox);
		if (element.isSelected() == false){
			click(element_checkbox);
		}
		info("Move post to topic " + destination);
		waitForElementPresent(ELEMENT_MODERATION);
		click(ELEMENT_MODERATION);
		waitForElementPresent(ELEMENT_MOVE_POST);
		click(ELEMENT_MOVE_POST);
		waitForElementPresent(ELEMENT_POPUP_MOVE_POST);
		selectGroup(destination);
		waitForElementNotPresent(ELEMENT_POPUP_MOVE_POST);
		String links[] = destination.split("/");
		int length = links.length;
		waitForElementPresent(By.xpath("//a[@title='" + links[length - 2] + "']/../div[@title='" + links[length - 1] + "']"));
		info("Move post successfully");
	}
}
