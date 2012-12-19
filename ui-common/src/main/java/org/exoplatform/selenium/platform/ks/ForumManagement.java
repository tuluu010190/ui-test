package org.exoplatform.selenium.platform.ks;

import static org.exoplatform.selenium.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForumManagement extends ForumManageCategory {

	//--------------------forum home screen-------------------------------------------------
	public static String ELEMENT_FORUM = "//span[@class='NameForum' and text()='${forumName}']";
	public static By ELEMENT_DELETE_FORUM = By.xpath("//a[@class='ItemIcon RemoveForumIcon' and text()='Delete']");
	public static By ELEMENT_EDIT_FORUM = By.xpath("//a[@class='ItemIcon EditForumIcon' and text()='Edit']");
	public static By ELEMENT_MOVE_FORUM = By.xpath("//a[@class='ItemIcon MoveForumIcon' and text()='Move']");
	public static By ELEMENT_START_TOPIC = By.xpath("//a[@class='ItemIcon PostnewThreadIcon' and contains(text(),'Start Topic')]");
	public static By ELEMENT_CENSOR_TOPIC = By.xpath("//a[@class='ItemIcon SetUnWaiting' and text()='Censor ']");
	
	//-------------------add forum form---------------------------------------------------
	public static By ELEMENT_POPUP_ADD_FORUM = By.xpath("//span[@class='PopupTitle' and text()='Forum']");
	public static By ELEMENT_SELECT_CATERORY = By.id("Category");
	public static By ELEMENT_ADD_FORUM_TAB = By.xpath("//div[@class='MiddleTab' and text()='Add Forum']");
	public static By ELEMENT_FORUM_TITLE = By.id("ForumTitle");
	public static By ELEMENT_FORUM_ORDER = By.id("ForumOrder");
	public static By ELEMENT_FORUM_STATE = By.id("ForumState");
	public static By ELEMENT_FORUM_STATUS = By.id("ForumStatus");
	public static By ELEMENT_FORUM_DESCRIPTION = By.id("Description");
	public static By ELEMENT_MODERATOR_TAB = By.xpath("//div[@class='MiddleTab' and text()='Moderation Options']");
	public static By ELEMENT_FORUM_MODERATOR = By.id("Moderator");
	public static By ELEMENT_FORUM_AUTO_FILL = By.id("AutoAddEmailNotify");
	public static By ELEMENT_NOTIFY_ADD_POST = By.id("NotifyWhenAddPost");
	public static By ELEMENT_NOTIFY_ADD_TOPIC = By.id("NotifyWhenAddTopic");
	public static By ELEMENT_MODERATE_THREAD = By.id("ModerateThread");
	
	//------------------move forum form---------------------------------------------------
	public static By ELEMENT_POPUP_MOVE_FORUM = By.xpath("//span[@class='PopupTitle' and text()='Move Forum']");

	//------------------Export forum form---------------------------------------------------
	public static By ELEMENT_EXPORT_FORUM_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Export Forums']");
	public static By ELEMENT_EXPORT_FORUM_COMPRESS = By.id("createZip");
	
	/** function: go to add forum
	 * @author lientm
	 */
	public static void goToAddForum(){
		info("Go to add new forum");
		waitForElementPresent(ELEMENT_ADD_FORUM);
		click(ELEMENT_ADD_FORUM);
		waitForElementPresent(ELEMENT_POPUP_ADD_FORUM);
	}

	/**function: input data in add forum tab in add forum popup
	 * @author lientm
	 * @param addForum: is array of 5 strings with
	 * 			@addForum[0] = title of forum
	 * 			@addForum[1] = order of forum
	 *          @addForum[2] = Open/Closed
	 *          @addForum[3] = Locked/Unlocked
	 *          @addForum[4] = description of forum
	 */
	public static void inputDataInAddForumTab_addForum(String[] addForum){
		info("Input data in add forum tab");
		if (addForum.length > 0){
			if (addForum[0] != "" && addForum[0] != null){
				type(ELEMENT_FORUM_TITLE, addForum[0], true);
			}
			if (addForum[1] != "" && addForum[1] != null){
				type(ELEMENT_FORUM_ORDER, addForum[1], true);
			}
			if (addForum[2] != "" && addForum[2] != null){
				select(ELEMENT_FORUM_STATE, addForum[2]);
			}
			if (addForum[3] != "" && addForum[3] != null){
				select(ELEMENT_FORUM_STATUS, addForum[3]);
			}
			if (addForum[4] != "" && addForum[4] != null){
				type(ELEMENT_FORUM_DESCRIPTION, addForum[4], true);
			}
		}
	}

	/** function: input data in Moderations Option tab in add forum popup
	 * @author lientm
	 * @param chooseUser: choose a way to select moderator
	 * @param userGroup: moderator
	 * @param autofill: choose auto fill the moderator's email or not
	 * @param post: Email addresses to notify when there is a new post
	 * @param topic: Email addresses to notify when there is a new topic
	 * @param thread: choose Moderate Topics or not
	 */
	public static void inputDataInModerOptionTab_addForum(int chooseUser, String[] userGroup, boolean autofill, String post, String topic, boolean thread){
		info("Input data in Moderations Option tab");
		click(ELEMENT_MODERATOR_TAB);
		WebElement checkauto = waitForAndGetElement(ELEMENT_FORUM_AUTO_FILL);
		if ((autofill&& !checkauto.isSelected()) || (!autofill&& checkauto.isSelected())){
			click(ELEMENT_FORUM_AUTO_FILL);
		}
		ForumBase.setPermissionWithOption("Moderator", chooseUser, userGroup);
		if (post != null && post != ""){
			type(ELEMENT_NOTIFY_ADD_POST, post, true);
		}
		if (topic != null && topic != ""){
			type(ELEMENT_NOTIFY_ADD_TOPIC, topic, true);
		}
		if ((thread ==  true) && (waitForAndGetElement(ELEMENT_MODERATE_THREAD).isSelected() == false)){
			click(ELEMENT_MODERATE_THREAD);
		}
	}

	/** function: create new forum
	 * @author lientm
	 * @param category: title of category that contains forum
	 * @param addForum: string array input add forum tab
	 * @param chooseUser: choose a way select moderator
	 * @param userGroup: moderator
	 * @param autofill: choose auto fill the moderator's email or not
	 * @param post: Email addresses to notify when there is a new post
	 * @param topic: Email addresses to notify when there is a new topic
	 * @param thread: choose Moderate Topics or not
	 * @param setPermission: choose a way set permission
	 * @param user: user/group
	 */
	public static void addForum(String category, String[] addForum, int chooseUser, String[] userGroup, boolean autofill, 
								String post, String topic, boolean thread, int setPermission, String...user){
		String isuser = user.length > 0 ? user[0]: "john";
		String isrole = user.length > 1 ? user[1]: "*";
		By FORUM = By.xpath(ELEMENT_FORUM.replace("${forumName}", addForum[0]));
		
		goToAddForum();
		info("Create new forum");
		select(ELEMENT_SELECT_CATERORY, category);
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(chooseUser, userGroup, autofill, post, topic, thread);
		//set permission
		if(setPermission > 0){
			click(ELEMENT_PERMISSION_TAB);
			String[] userstring = {isuser, isrole};
			ForumBase.setPermissionWithOption("Topicable", setPermission, userstring);
			ForumBase.setPermissionWithOption("Postable", setPermission, userstring);
			ForumBase.setPermissionWithOption("Viewer", setPermission, userstring);
		}
		save();
		if (user.length < 3 ){
			waitForElementPresent(FORUM);
			info("Create forum successfully");
		}
	}
	
	/**
   * Go to a forum
   * @param title : Forum title
   * @author dunghm
   */
  public static void gotoForumView(String title){
    By forumLink = By.xpath("//a[contains(@class,'ForumTitle') and text()='" + title + "']");
    By forum = By.xpath("//span[@class='NameForum' and text()='" + title + "']");
    click(forumLink);
    waitForElementPresent(forum);
  }
  /**
   * Add new forum with a short set of parameters
   * @param title : Forum title
   * @author dunghm
   */
  public static void quickAddForum(String title){
    By FORUM = By.xpath(ELEMENT_FORUM.replace("${forumName}", title));
    goToAddForum();
    type(ELEMENT_FORUM_TITLE, title, true);
    save(); 
    waitForElementPresent(FORUM);
    waitForElementNotPresent(ELEMENT_ALERT);
  }
  	
	/** function: delete a forum
	 * @author lientm
	 * @param title: title of forum that needs to delete
	 */
	public static void deleteForum(String title){
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		info("Delete forum");
		waitForElementPresent(ELEMENT_DELETE_FORUM);
		click(ELEMENT_DELETE_FORUM);
		acceptAlert();
		waitForTextNotPresent(title);
		info("Delete forum successfully");
	}
	
	/** function: go to edit forum
	 * @author lientm
	 */
	public static void goToEditForum(){
		info("Go to edit forum");
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForElementPresent(ELEMENT_EDIT_FORUM);
		click(ELEMENT_EDIT_FORUM);
		waitForElementPresent(ELEMENT_POPUP_ADD_FORUM);
	}

	/** function: edit a forum
	 * @author lientm
	 * @param addForum: string array input add forum tab
	 * @param chooseUser: choose a way to select moderator
	 * @param userGroup: moderator
	 * @param autofill: choose auto fill the moderator's email or not
	 * @param post: Email addresses to notify when there is a new post
	 * @param topic: Email addresses to notify when there is a new topic
	 * @param thread: choose Moderate Topics or not
	 * @param setPermission: choose a way set permission
	 * @param user: user/group
	 */
	public static void editForum(String[] addForum, int chooseUser, String[] userGroup, boolean autofill, 
								String post, String topic, boolean thread, int setPermission, String...user){
		String isuser = user.length > 0 ? user[0]: "john";
		String isrole = user.length > 1 ? user[1]: "*";
		By FORUM = By.xpath(ELEMENT_FORUM.replace("${forumName}", addForum[0]));
		
		goToEditForum();
		info("Edit forum");
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(chooseUser, userGroup, autofill, post, topic, thread);
		//set permission
		if(setPermission > 0){
			click(ELEMENT_PERMISSION_TAB);
			String[] userstring = {isuser, isrole};
			ForumBase.setPermissionWithOption("Topicable", setPermission, userstring);
			ForumBase.setPermissionWithOption("Postable", setPermission, userstring);
			ForumBase.setPermissionWithOption("Viewer", setPermission, userstring);
		}
		save();	
		waitForElementPresent(FORUM);
		waitForElementNotPresent(ELEMENT_ALERT);
		info("Edit forum successfully");
	}

	/**function: move a forum from a category to another category
	 * @author lientm
	 * @param forum: title of forum that needs to move
	 * @param destination: title of destination category
	 */
	public static void moveForum(String forum, String destination){
		info("move forum to category " + destination);
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForElementPresent(ELEMENT_MOVE_FORUM);
		click(ELEMENT_MOVE_FORUM);
		waitForElementPresent(ELEMENT_POPUP_MOVE_FORUM);
		click(By.linkText(destination));
		waitForElementNotPresent(ELEMENT_POPUP_MOVE_FORUM);
		waitForElementPresent(By.xpath("//a[@title='" + destination + "']/../div[@title='" + forum + "']"));
		info("Move forum successfully");
	}
	
	/** function: export a forum
	 * @author lientm
	 * @param fileName: file name export
	 * @param compress: compress or not
	 */
	public static void exportForum(String fileName, boolean compress){
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForElementPresent(ELEMENT_EXPORT_FORUM);
		click(ELEMENT_EXPORT_FORUM);
		waitForElementPresent(ELEMENT_EXPORT_FORUM_POPUP);
		info("Export forum");
		type(ELEMENT_EXPORT_CATEGORY_FILE_NAME, fileName, true);
		WebElement com = waitForAndGetElement(ELEMENT_EXPORT_FORUM_COMPRESS);
		if ((compress && com.isSelected() == false) || (compress == false && com.isSelected() == true)){
			click(ELEMENT_EXPORT_FORUM_COMPRESS);
		}
		save();
		waitForElementNotPresent(ELEMENT_EXPORT_FORUM_POPUP);
	}
}
