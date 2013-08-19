package org.exoplatform.selenium.platform.forum;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class ForumManageForum extends ForumBase {
	
	Button but;
	ForumPermission per;
	ManageAlert alert;
	ForumManageCategory cat;
	
	public ForumManageForum(WebDriver dr){
		driver = dr;
	}

	//--------------------forum home screen-------------------------------------------------
	public String ELEMENT_FORUM = "//*[@class='nameForum']/strong[text()='${forumName}']";
	public String ELEMENT_FORUM_LINK = "//span[@class='NameForum' and text()='${forumName}']";
	public By ELEMENT_DELETE_FORUM = By.xpath("//a[@class='ItemIcon RemoveForumIcon' and text()='Delete']");
	public By ELEMENT_EDIT_FORUM = By.xpath("//a[@class='ItemIcon EditForumIcon' and text()='Edit']");
	public By ELEMENT_MOVE_FORUM = By.xpath("//a[@class='ItemIcon MoveForumIcon' and text()='Move']");
	public By ELEMENT_START_TOPIC = By.xpath("//a[@class='ItemIcon PostnewThreadIcon' and contains(text(),'Start Topic')]");
	public By ELEMENT_CENSOR_TOPIC = By.xpath("//a[@class='ItemIcon SetUnWaiting' and text()='Censor ']");
	public By ELEMENT_MODERATOR_PANEL = By.xpath("//*[@id='uicomponent.id' and @class='UIForumModerator']");
	public By ELEMENT_RULE_PANEL = By.id("UIPostRules");
	
	//-------------------add forum form---------------------------------------------------
	public By ELEMENT_POPUP_ADD_FORUM = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Forum']");
	public By ELEMENT_SELECT_CATERORY = By.id("Category");
	public By ELEMENT_ADD_FORUM_TAB = By.xpath("//div[@class='MiddleTab' and text()='Add Forum']");
	public By ELEMENT_FORUM_TITLE = By.id("ForumTitle");
	public By ELEMENT_FORUM_ORDER = By.id("ForumOrder");
	public By ELEMENT_FORUM_STATE = By.id("ForumState");
	public By ELEMENT_FORUM_STATUS = By.id("ForumStatus");
	public By ELEMENT_FORUM_DESCRIPTION = By.id("Description");
	public By ELEMENT_MODERATOR_TAB = By.xpath("//div[@class='MiddleTab' and text()='Moderation Options']");
	public By ELEMENT_FORUM_MODERATOR = By.id("Moderator");
	public By ELEMENT_FORUM_AUTO_FILL = By.id("AutoAddEmailNotify");
	public By ELEMENT_NOTIFY_ADD_POST = By.id("NotifyWhenAddPost");
	public By ELEMENT_NOTIFY_ADD_TOPIC = By.id("NotifyWhenAddTopic");
	public By ELEMENT_MODERATE_THREAD = By.id("ModerateThread");
	
	//------------------move forum form---------------------------------------------------
	public By ELEMENT_POPUP_MOVE_FORUM = By.xpath("//span[@class='PopupTitle' and text()='Move Forum']");

	//------------------Export forum form---------------------------------------------------
	public By ELEMENT_EXPORT_FORUM_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Export Forums']");
	public By ELEMENT_EXPORT_FORUM_COMPRESS = By.id("createZip");
	
	/*-------------------------------------Common function--------------------------------*/
	
	/** function: go to add forum
	 * @author lientm
	 */
	public void goToAddForum(){
		info("Go to add new forum");
		waitForAndGetElement(ELEMENT_ADD_FORUM);
		click(ELEMENT_ADD_FORUM);
		waitForAndGetElement(ELEMENT_POPUP_ADD_FORUM);
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
	public void inputDataInAddForumTab_addForum(String[] addForum){
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
	public void inputDataInModerOptionTab_addForum(int chooseUser, String[] userGroup, boolean autofill, String post, String topic, boolean thread){
		info("Input data in Moderations Option tab");
		click(ELEMENT_MODERATOR_TAB);
		WebElement checkauto = waitForAndGetElement(ELEMENT_FORUM_AUTO_FILL);
		if ((autofill&& !checkauto.isSelected()) || (!autofill&& checkauto.isSelected())){
			click(ELEMENT_FORUM_AUTO_FILL);
		}
		//ForumBase.setPermissionWithOption("Moderator", chooseUser, userGroup);
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
	public void addForum(String category, String[] addForum, int chooseUser, String[] userGroup, boolean autofill, 
								String post, String topic, boolean thread, int setPermission, String...user){
//		String isuser = user.length > 0 ? user[0]: "john";
//		String isrole = user.length > 1 ? user[1]: "*";
		By FORUM = By.xpath(ELEMENT_FORUM.replace("${forumName}", addForum[0]));
		
		goToAddForum();
		info("Create new forum");
		select(ELEMENT_SELECT_CATERORY, category);
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(chooseUser, userGroup, autofill, post, topic, thread);
		//set permission
		if(setPermission > 0){
			click(per.ELEMENT_PERMISSION_TAB);
			//String[] userstring = {isuser, isrole};
//			ForumBase.setPermissionWithOption("Topicable", setPermission, userstring);
//			ForumBase.setPermissionWithOption("Postable", setPermission, userstring);
//			ForumBase.setPermissionWithOption("Viewer", setPermission, userstring);
		}
		but.save();
		if (user.length < 3 ){
			waitForAndGetElement(FORUM);
			info("Create forum successfully");
		}
	}
	/**Function add forum with title and setting permission
	 * @author thaopth
	 * @param title
	 * @param userGroup
	 */
	public void addForumWithSettingPermission(String title, String...userGroup ){
		 By FORUM = By.xpath(ELEMENT_FORUM.replace("${forumName}", title));    
		info("Create new forum");
		type(ELEMENT_FORUM_TITLE, title, true);
		click(per.ELEMENT_PERMISSION_TAB);
		info("Set moderator");
		info("Set who can start topic");
		if (userGroup.length > 0){
			if (userGroup[0] != "" && userGroup[0] != null){
				//String[] user = {userGroup[0]};
				//ForumBase.setPermissionWithOption(SET_PERMISSION[1], 1, user );
			}
		}
		info("Set who can post");
		if (userGroup.length > 1){
			if (userGroup[1] != "" && userGroup[1] != null){
				//String[] user = {userGroup[1]};
				//ForumBase.setPermissionWithOption(SET_PERMISSION[2], 1, user );
			}
		}	
		info("Set who can view");
		if (userGroup.length > 2){
			if (userGroup[2] != "" && userGroup[2] != null){
				//String[] user = {userGroup[2]};
				//ForumBase.setPermissionWithOption(SET_PERMISSION[3], 1, user );
			}
		}	
		but.save();
		waitForAndGetElement(FORUM);
	}
	
	 /**
	  * Go to a forum
	  * @param title : Forum title
	  * @author dunghm
	  */
	 public void gotoForumView(String title){
	    By forumLink = By.xpath("//a[contains(@class,'ForumTitle') and text()='" + title + "']");
	    By forum = By.xpath("//span[@class='NameForum' and text()='" + title + "']");
	    click(forumLink);
	    waitForAndGetElement(forum);
	 }
	 /**
	  * Add new forum with a short set of parameters
	  * @param title : Forum title
	  * @author dunghm
	  */
  	public void quickAddForum(String title){
  		but = new Button(driver);
	    By FORUM = By.xpath(ELEMENT_FORUM.replace("${forumName}", title));
	    goToAddForum();
	    type(ELEMENT_FORUM_TITLE, title, true);
	    but.save(); 
	    waitForAndGetElement(FORUM);
	    waitForElementNotPresent(ELEMENT_ALERT);
  	}
  	
	/** function: delete a forum
	 * @author lientm
	 * @param title: title of forum that needs to delete
	 */
	public void deleteForum(String title){
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		info("Delete forum");
		waitForAndGetElement(ELEMENT_DELETE_FORUM);
		click(ELEMENT_DELETE_FORUM);
		alert.acceptAlert();
		waitForTextNotPresent(title);
		info("Delete forum successfully");
	}
	
	/** function: go to edit forum
	 * @author lientm
	 */
	public void goToEditForum(){
		info("Go to edit forum");
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForAndGetElement(ELEMENT_EDIT_FORUM);
		click(ELEMENT_EDIT_FORUM);
		waitForAndGetElement(ELEMENT_POPUP_ADD_FORUM);
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
	public void editForum(String[] addForum, int chooseUser, String[] userGroup, boolean autofill, 
								String post, String topic, boolean thread, int setPermission, String...user){
//		String isuser = user.length > 0 ? user[0]: "john";
//		String isrole = user.length > 1 ? user[1]: "*";
		By FORUM = By.xpath(ELEMENT_FORUM.replace("${forumName}", addForum[0]));
		
		goToEditForum();
		info("Edit forum");
		inputDataInAddForumTab_addForum(addForum);
		inputDataInModerOptionTab_addForum(chooseUser, userGroup, autofill, post, topic, thread);
		//set permission
		if(setPermission > 0){
			click(per.ELEMENT_PERMISSION_TAB);
//			String[] userstring = {isuser, isrole};
//			ForumBase.setPermissionWithOption("Topicable", setPermission, userstring);
//			ForumBase.setPermissionWithOption("Postable", setPermission, userstring);
//			ForumBase.setPermissionWithOption("Viewer", setPermission, userstring);
		}
		but.save();	
		waitForAndGetElement(FORUM);
		waitForElementNotPresent(ELEMENT_ALERT);
		info("Edit forum successfully");
	}

	/**function: move a forum from a category to another category
	 * @author lientm
	 * @param forum: title of forum that needs to move
	 * @param destination: title of destination category
	 */
	public void moveForum(String forum, String destination){
		info("move forum to category " + destination);
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForAndGetElement(ELEMENT_MOVE_FORUM);
		click(ELEMENT_MOVE_FORUM);
		waitForAndGetElement(ELEMENT_POPUP_MOVE_FORUM);
		click(By.linkText(destination));
		waitForElementNotPresent(ELEMENT_POPUP_MOVE_FORUM);
		waitForAndGetElement(By.xpath("//a[@title='" + destination + "']/../div[@title='" + forum + "']"));
		info("Move forum successfully");
	}
	
	/** function: export a forum
	 * @author lientm
	 * @param fileName: file name export
	 * @param compress: compress or not
	 */
	public void exportForum(String fileName, boolean compress){
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForAndGetElement(ELEMENT_EXPORT_FORUM);
		click(ELEMENT_EXPORT_FORUM);
		waitForAndGetElement(ELEMENT_EXPORT_FORUM_POPUP);
		info("Export forum");
		type(cat.ELEMENT_EXPORT_CATEGORY_FILE_NAME, fileName, true);
		WebElement com = waitForAndGetElement(ELEMENT_EXPORT_FORUM_COMPRESS);
		if ((compress && com.isSelected() == false) || (compress == false && com.isSelected() == true)){
			click(ELEMENT_EXPORT_FORUM_COMPRESS);
		}
		but.save();
		waitForElementNotPresent(ELEMENT_EXPORT_FORUM_POPUP);
	}
}
