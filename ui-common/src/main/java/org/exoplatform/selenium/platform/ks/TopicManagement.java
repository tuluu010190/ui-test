package org.exoplatform.selenium.platform.ks;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.UserGroupManagement.selectGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TopicManagement extends ForumManagement {

	//----------------topic home screen---------------------------------------------------
	public static By ELEMENT_DELETE_TOPIC = By.xpath("//a[@class='ItemIcon SetDeleteIcon' and text()='Delete']");
	public static By ELEMENT_EDIT_TOPIC = By.xpath("//a[@class='ItemIcon EditTopicIcon' and text()='Edit']");
	public static By ELEMENT_MOVE_TOPIC = By.xpath("//a[@class='ItemIcon SetMoveIcon' and text()='Move']");
	public static By ELEMENT_APPROVE_TOPIC = By.xpath("//a[@class='ItemIcon SetApproveIcon' and text()='Approve']");
	public static By ELEMENT_CHECK_ALL = By.xpath("//*[@id='UITopicContent']//input[@title='Check All']");
	
	//----------------start topic screen--------------------------------------------------
	public static By ELEMENT_START_TOPIC_BUTTON = By.xpath("//form[@id='UITopicContainer']/div[2]/*//a[contains(text(),'Start Topic')]");
	public static By ELEMENT_POPUP_START_TOPIC = By.xpath("//span[@class='PopupTitle' and text()='New Topic']");
	public static By ELEMENT_SUBMIT_BUTTON = By.linkText("Submit");
	public static By ElEMENT_CANCEL_ADD_TOPIC = By.xpath(".//*[@id='UITopicForm']/div[3]/a[text()='Cancel']");

	public static By ELEMENT_TOPIC_CONTENT_TAB = By.linkText("Content");
	public static By ELEMENT_TOPIC_TITLE = By.id("ThreadTitle");
	public static By ELEMENT_TOPIC_MESSAGE_FRAME_1 = By.xpath("//iframe[@id='messageContent___Frame']");
	public static By ELEMENT_TOPIC_MESSAGE_FRAME_2 = By.xpath("//td[@id='xEditingArea']/iframe");
	public static String ELEMENT_REMOVE_FILE = "//a[contains(@title, '${file}')]/../*//img[@class='DustBin']";

	public static By ELEMENT_TOPIC_ICON_TAB = By.linkText("Icon");
	public static String ELEMENT_GROUP_ICON = "//div[@class='ItemTitle' and text()='${group}']";
	public static String ELEMENT_ICON = "//div[@class='${icon}']";

	public static By ELEMENT_TOPIC_OPTIONS_TAB = By.linkText("Options");
	public static By ELEMENT_TOPIC_ADD_TYPE = By.xpath("//img[@alt='Add Topic Type']");
	public static By ELEMENT_TOPIC_SELECT_TYPE = By.id("TopicType");
	public static By ELEMENT_TOPIC_STATE = By.id("TopicState");
	public static By ELEMENT_TOPIC_STATUS = By.id("TopicStatus");
	public static By ELEMENT_TOPIC_POSTS_MODER = By.id("ModeratePost");
	public static By ELEMENT_TOPIC_POSTS_NOTIFY = By.id("NotifyWhenAddPost");
	public static By ELEMENT_TOPIC_STICKY = By.id("Sticky");

	public static By ELEMENT_TOPIC_PERMISSION_TAB = By.linkText("Permissions");
	public static String ELEMENT_TOPIC_CAN_POST = "CanPost";
	public static String ELEMENT_TOPIC_CAN_VIEW = "CanView";
	public static String ELEMENT_TOPIC_SELECT_USER = "//*[@id='${element}']/../a/img[@class='SelectUserIcon']";
	public static String ELEMENT_TOPIC_SELECT_GROUP = "//*[@id='${element}']/../a/img[@class='SelectGroupIcon']";
	public static String ELEMENT_TOPIC_SELECT_ROLE = "//*[@id='${element}']/../a/img[@class='SelectMemberShipIcon']";

	//------------------add topic type screen--------------------------------------------------
	public static By ELEMENT_TOPIC_ADD_TYPE_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Topic Type']");
	public static By ELEMENT_TOPIC_TYPE_NAME = By.id("topicTypeName");
	public static By ELEMENT_CANCEL_ADD_TYPE = By.xpath(".//*[@id='UIAddTopicTypeForm']/div[3]/a[text()='Cancel']");

	//------------------edit topic screen------------------------------------------------------
	public static By ELEMENT_TOPIC_EDIT_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Edit Topic']");
	public static By ELEMENT_TOPIC_EDIT_REASON = By.id("editReason");

	//-------------------move topic screen----------------------------------------------------
	public static By ELEMENT_POPUP_MOVE_TOPIC = By.xpath("//span[@class='PopupTitle' and text()='Move Topics']");

	//-------------------Add tag--------------------------------------------------------------
	public static By ELEMENT_TAG = By.id("ButtonSearch");
	public static By ELEMENT_ADD_TAG = By.id("AddTag");
	public static By ELEMENT_ADD_TAG_BUTTON = By.xpath("//label[text()='Add Tag']");
	public static String ELEMENT_TAG_NUMBER = "//*[@id='searchTagName']/div/font[text()='(${No})']";
	public static By ELEMENT_MANAGE_TAG = By.linkText("Manage Tag");
	public static By ELEMENT_UNTAG = By.xpath("//a[contains(text(), 'Untag')]");
	public static String ELEMENT_CHECKBOX_UNTAG = "//input[@type='checkbox' and @title='${topic}']";
	public static String MESSAGE_UNTAG = "Are you sure to remove this tag from the topic?";
	public static String MESSAGE_ADD_TAG_BLANK_NAME = "The field must not be blank.";
	public static String ELEMENT_UNTAG_ICON = "//a[text()='${tag}']/../span[@title='Untag this topic.']";
	public static String ELEMENT_suggestion = "#searchTagName div:contains('${tag}') font:contains('(${No})')";
	
	//-------------------censor topic list form-----------------------------------------------
	public static By ELEMENT_POPUP_CENSOR_TOPIC = By.xpath("//span[@class='PopupTitle' and text()='Censor Topics List']");
	public static String ELEMENT_CENSOR_TOPIC_CHECKBOX = "//*[text()='${topic}']/../../../../td/input[@type='checkbox']";
	public static By ELEMENT_CENSOR_APPROVE_BUTTON = By.linkText("Approve");

	//-------------------Go to topic types management screen----------------------------------------------------
	public static By ELEMENT_TOPIC_TYPES=By.xpath("//span[text()='Topic Types']");
	public static By ELEMENT_TOPIC_MANAGER_POPUP=By.xpath("//span[text()='Topic Type Manager']");
	public static By ELEMENT_ADD_TOPIC_TYPE_BUTTON=By.xpath("//a[@class='ActionButton LightBlueStyle' and text()='Add Topic Type']");

	//-------------------Poll management screen-----------------------------------------------------------------
	public static By ELEMENT_POLL = By.xpath("//div[@class='UITopicPoll']");
	public static By ELEMENT_ADD_POLL = By.linkText("Add Poll");
	public static By ELEMENT_POLL_POPUP = By.xpath("//span[@class='PopupTitle' and text()='Poll']");
	public static By ELEMENT_POLL_QUESTION = By.id("Question");
	public static By ELEMENT_POLL_OPTION0 = By.id("Option0");
	public static By ELEMENT_POLL_OPTION1 = By.id("Option1");
	public static By ELEMENT_POLL_CLOSE = By.id("TimeOut");
	public static By ELEMENT_POLL_VOTE_AGAIN = By.id("VoteAgain");
	public static By ELEMENT_POLL_SUBMIT_BUTTON = By.linkText("Submit Poll");
	
	/** function: go to start topic from action bar
	 * @author lientm
	 */
	public static void goToStartTopic(){
		info("Go to start topic");
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForElementPresent(ELEMENT_START_TOPIC);
		click(ELEMENT_START_TOPIC);
		waitForElementPresent(ELEMENT_POPUP_START_TOPIC);
	}

	/** function: remove file in attach popup
	 * @author lientm
	 * @param fileName: remove a attached file in add/edit topic
	 */
	public static void removeFileInTopic(String fileName){
		By ELEMENT_REMOVE = By.xpath(ELEMENT_REMOVE_FILE.replace("${file}", fileName));

		WebElement element = waitForAndGetElement(ELEMENT_REMOVE);
		if (element != null) {
			info("Remove file " + fileName);
			click(ELEMENT_REMOVE);
			waitForElementNotPresent(ELEMENT_REMOVE);
			info("Remove file " + fileName + "successfully");
		} else {
			info("Can not found file remove");
		}
	}

	/** function: input data in content tab in start topic popup
	 * @author lientm
	 * @param title: title of topic
	 * @param message: message
	 * @param file: file upload
	 */
	public static void inputDataInContentTab_StartTopic(String title, String message, String... file){
		info("Input data in content tab");
		waitForElementPresent(ELEMENT_TOPIC_TITLE);
		if (title != null && title != ""){
			type(ELEMENT_TOPIC_TITLE, title, true);
		}
		if (message != "" && message != null){
			inputDataToFrameInFrame(ELEMENT_TOPIC_MESSAGE_FRAME_1, ELEMENT_TOPIC_MESSAGE_FRAME_2, message, true);
			switchToParentWindow();	
		}
		if(file.length > 0 && file[0] != "" && file[0] != null){
			click(ELEMENT_ATTACH_FILE);
			waitForElementPresent(ELEMENT_POPUP_UPLOAD_FILE);
			attachSomeFile(file);
			waitForElementNotPresent(ELEMENT_POPUP_UPLOAD_FILE);
		}
	}

	/** function: input data in icon tab in start topic popup
	 * @author lientm
	 * @param groupName: group icon
	 * @param iconClass: icon
	 */
	public static void chooseIcon(String groupName, String iconClass){
		By ELEMENT_GROUP = By.xpath(ELEMENT_GROUP_ICON.replace("${group}", groupName));
		By ICON = By.xpath(ELEMENT_ICON.replace("${icon}", iconClass));

		info("Choose icon");
		if (groupName != "" && groupName != null && iconClass != "" && iconClass != null){
			waitForElementPresent(ELEMENT_GROUP);
			click(ELEMENT_GROUP);
			waitForElementPresent(ICON);
			click(ICON);
		} else {
			info("There is not data input to choose icon");
		}
	}

	/** function: add a topic type in Options tab when start topic
	 * @author lientm
	 * @param typeName: name of topic type
	 * @param groupName: group icon
	 * @param iconClass: icon
	 */
	public static void addTopicType(String typeName, String groupName, String iconClass){
		info("Add new topic type");
		waitForElementPresent(ELEMENT_TOPIC_ADD_TYPE);
		click(ELEMENT_TOPIC_ADD_TYPE);
		modifyDataOfTopicType(typeName, groupName, iconClass);	
		waitForElementNotPresent(ELEMENT_TOPIC_ADD_TYPE_POPUP);	
	}

	/** function: input data in Options tab in start topic popup
	 * @author lientm
	 * @param typeName: type of topic that need add new
	 * @param groupName: group icon of new topic type
	 * @param iconClass: icon of new topic type
	 * @param type: type of topic that is chosen
	 * @param state: state of topic
	 * @param status: status of topic
	 * @param options: group option of: sent mail for moderator, sticky
	 */
	public static void inputDataInOptionsTab_StartTopic(String typeName, String groupName, String iconClass, String type, 
			String state, String status, boolean...options){
		info("Input data in Options tab");
		if (typeName != "" && typeName != null){
			addTopicType(typeName, groupName, iconClass);
		}
		if (type != "" && type != null){
			waitForElementPresent(ELEMENT_TOPIC_SELECT_TYPE);
			select(ELEMENT_TOPIC_SELECT_TYPE, type);
		}
		if (state != "" && state != null){
			select(ELEMENT_TOPIC_STATE, state);
		}
		if (status != "" && status != null){
			select(ELEMENT_TOPIC_STATUS, status);
		}
		if (options.length > 0){
			WebElement moder = waitForAndGetElement(ELEMENT_TOPIC_POSTS_MODER);
			if ((options[0] && (moder.isSelected() == false)) || (!options[0] && (moder.isSelected() == true))){
				click(ELEMENT_TOPIC_POSTS_MODER);
			}
		}
		if (options.length > 1){
			WebElement moder = waitForAndGetElement(ELEMENT_TOPIC_POSTS_NOTIFY);
			if ((options[1] && (moder.isSelected() == false)) || (!options[1] && (moder.isSelected() == true))){
				click(ELEMENT_TOPIC_POSTS_NOTIFY);
			}	
		}
		if (options.length > 2){
			WebElement moder = waitForAndGetElement(ELEMENT_TOPIC_STICKY);
			if ((options[2] && (moder.isSelected() == false)) || (!options[2] && (moder.isSelected() == true))){
				click(ELEMENT_TOPIC_STICKY);
			}	
		}
	}

	/** function: set permission when start topic
	 * @author lientm
	 * @param locator: locator that needs to set
	 * @param setPermission: choose a way to set permission
	 * @param userGroup: user/group/membership
	 */
	public static void setPermissionTopic(String locator, int setPermission, String[] userGroup){
		By TOPIC_SELECT_USER = By.xpath(ELEMENT_TOPIC_SELECT_USER.replace("${element}", locator));
		By TOPIC_SELECT_ROLE = By.xpath(ELEMENT_TOPIC_SELECT_ROLE.replace("${element}", locator));
		By TOPIC_SELECT_GROUP = By.xpath(ELEMENT_TOPIC_SELECT_GROUP.replace("${element}", locator));
		By ELEMENT = By.id(locator);

		switch(setPermission){
		case 0: break;
		case 1: type(ELEMENT, userGroup[0], true);
		break;
		case 2: 
			waitForElementPresent(TOPIC_SELECT_USER);
			click(TOPIC_SELECT_USER);
			KsBase.selectUserPermission(userGroup[0]);
			waitForTextPresent(userGroup[0]);
			break;
		case 3: 
			waitForElementPresent(TOPIC_SELECT_GROUP);
			click(TOPIC_SELECT_GROUP);
			KsBase.selectGroupPermission(userGroup[0]);
			break;
		default: 
			waitForElementPresent(TOPIC_SELECT_ROLE);
			click(TOPIC_SELECT_ROLE);
			KsBase.selectGroupMembership(userGroup[0], userGroup[1]);
			waitForTextPresent(userGroup[1]);
			break;	
		}
	}

	/**
	 * function: start a topic
	 * @author lientm
	 * @param title: title of Topic
	 * @param message: message of Topic
	 * @param file: file attach
	 * @param groupName: group of Icon
	 * @param iconClass: icon
	 * @param type: type of topic
	 * @param state: state of topic
	 * @param status: status of topic
	 * @param setPermission: choose a way to set permission
	 * @param userGroup: user/group/membership
	 * @param options: group of option: send mail to moderator, sticky
	 */

	public static void startTopic(String title, String message, String file, String groupName, String iconClass, String type, 
			String state, String status, int setPermission, String[] userGroup, boolean... options){

		info("Start a topic");
		inputDataInContentTab_StartTopic(title, message, file);
		if (groupName != "" && iconClass != ""){
			click(ELEMENT_TOPIC_ICON_TAB);
			chooseIcon(groupName, iconClass);
		}
		if ((type != "" && type != null)|| (state != "" && state != null) || (status != "" && status != null)|| options.length > 0){
			click(ELEMENT_TOPIC_OPTIONS_TAB);
			inputDataInOptionsTab_StartTopic("", "", "", type, state, status, options);
		}
		if (setPermission != 0){
			click(ELEMENT_TOPIC_PERMISSION_TAB);
			setPermissionTopic(ELEMENT_TOPIC_CAN_POST, setPermission, userGroup);
			setPermissionTopic(ELEMENT_TOPIC_CAN_VIEW, setPermission, userGroup);
		}
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_POPUP_START_TOPIC);
		info("Start topic successfully");
	}	

	/**
	 * start a new topic with short set of parameters
	 * @param title : Topic title
	 * @param message : Topic message
	 * @author dunghm
	 */
	public static void quickStartTopic(String title, String message){
		info("Start a topic");
		goToStartTopic();
		inputDataInContentTab_StartTopic(title, message);    
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_POPUP_START_TOPIC);
		waitForTextPresent(title);
		info("Start topic successfully");
	} 
	
	public static void quickStartTopicByClickStartButton(String title, String message){
		info("Start a topic by click start topic button");
		click(ELEMENT_START_TOPIC_BUTTON);
		inputDataInContentTab_StartTopic(title, message);    
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_POPUP_START_TOPIC);
		waitForTextPresent(title);
		info("Start topic successfully");
	}

	/** function: delete a topic
	 * @author lientm
	 * @param title: title of topic that needs to delete
	 */

	public static void deleteTopic(String title){
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		info("Delete topic");
		waitForElementPresent(ELEMENT_DELETE_TOPIC);
		click(ELEMENT_DELETE_TOPIC);
		acceptAlert();
		waitForTextNotPresent(title);
		info("Delete topic successfully");
	}

	/**
	 * function to go edit a topic
	 * @author lientm
	 */
	public static void goToEditTopic(){
		info("Go to edit topic");
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForElementPresent(ELEMENT_EDIT_TOPIC);
		click(ELEMENT_EDIT_TOPIC);
		waitForElementPresent(ELEMENT_TOPIC_EDIT_POPUP);
	}

	/** function: edit a topic
	 * @author lientm
	 * @param title: title of Topic
	 * @param message: message of Topic
	 * @param reason: reason edit
	 * @param file: file attach
	 * @param groupName: group of Icon
	 * @param iconClass: icon
	 * @param type: type of topic
	 * @param state: state of topic
	 * @param status: status of topic
	 * @param setPermission: choose a way to set permission
	 * @param userGroup: user/group/membership
	 * @param options: group of option: send mail to moderator, sticky
	 */
	public static void editTopic(String title, String message, String file, String reason, String groupName, String iconClass, String type, 
			String state, String status, int setPermission, String[] userGroup, boolean... options){
		goToEditTopic();
		info("Edit topic");
		inputDataInContentTab_StartTopic(title, message, file);
		if (reason != "" && reason != null){
			type(ELEMENT_TOPIC_EDIT_REASON, reason, true);
		}
		if (groupName != "" && iconClass != ""){
			click(ELEMENT_TOPIC_ICON_TAB);
			chooseIcon(groupName, iconClass);
		}
		if ((type != "" && type != null)|| (state != "" && state != null) || (status != "" && status != null)|| options.length > 0){
			click(ELEMENT_TOPIC_OPTIONS_TAB);
			inputDataInOptionsTab_StartTopic("", "", "", type, state, status, options);
		}
		if (setPermission != 0){
			click(ELEMENT_TOPIC_PERMISSION_TAB);
			setPermissionTopic(ELEMENT_TOPIC_CAN_POST, setPermission, userGroup);
			setPermissionTopic(ELEMENT_TOPIC_CAN_VIEW, setPermission, userGroup);
		}
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_TOPIC_EDIT_POPUP);
		waitForTextPresent(title);
		info("Edit topic successfully");
	}

	/** function: move a topic to other forum
	 * @author lientm
	 * @param topic: title of topic
	 * @param destination: path go to forum
	 */
	public static void moveTopic(String topic, String destination){
		info("Move topic to forum " + destination);
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForElementPresent(ELEMENT_MOVE_TOPIC);
		click(ELEMENT_MOVE_TOPIC);
		waitForElementPresent(ELEMENT_POPUP_MOVE_TOPIC);
		selectGroup(destination);
		waitForElementNotPresent(ELEMENT_POPUP_MOVE_TOPIC);
		String links[] = destination.split("/");
		int length = links.length;
		waitForElementPresent(By.xpath("//a[@title='" + links[length - 1] + "']/../div[@title='" + topic + "']"));
		info("Move topic successfully");
	}	

	/**function go to Add tag for topic
	 * @author lientm
	 */
	public static void goToAddTagForTopic(){
		waitForElementPresent(ELEMENT_TAG);
		click(ELEMENT_TAG);
		waitForElementPresent(ELEMENT_ADD_TAG);
	}
	
	/**
	 * function add tag for topic
	 * @param tagName: name of tag
	 */
	public static void addTagForTopic(String tagName){
		String[] tag = tagName.split(" ");
		
		goToAddTagForTopic();
		type(ELEMENT_ADD_TAG, tagName, true);
		click(ELEMENT_ADD_TAG_BUTTON);
		for(int i = 0; i < tag.length; i ++){
			waitForElementPresent(By.linkText(tag[i]));
		}
		info("Add tag for topic successfully");
	}

	/**function untag for many topics
	 * @author lientm
	 * @param tagName: Name of tag
	 * @param topic: topics that need untag
	 */
	public static void unTagForTopics(String tagName, String...topic){
		info("Go to manage tag");
		click(By.linkText(tagName));
		waitForElementPresent(ELEMENT_MANAGE_TAG);		
		info("choose topic to untag");
		for (int i = 0; i < topic.length; i ++){
			By element_topic = By.xpath(ELEMENT_CHECKBOX_UNTAG.replace("${topic}", topic[i]));
			check(element_topic);
		}
		click(ELEMENT_MANAGE_TAG);
		for(int i = 0; i < 5; i ++){
			if (waitForAndGetElement(ELEMENT_UNTAG, 5000, 0) == null){
				click(ELEMENT_MANAGE_TAG);
				info("retry click manage tag" + i);
			}
			else break;
		}
		click(ELEMENT_UNTAG);
		waitForConfirmation(MESSAGE_UNTAG);
		info("Untag for topics successfully");
	}
	
	/**function untag directly for topic
	 * @author lientm
	 * @param tagName
	 */
	public static void unTagDirectly(String tagName){
		String[] tag = tagName.split(" ");
		
		for(int i = 0; i < tag.length; i ++){
			By element_untag = By.xpath(ELEMENT_UNTAG_ICON.replace("${tag}", tag[i]));	
			info("untag directly");
			click(element_untag);
			waitForTextNotPresent(tag[i]);
		}
		info("untag successfully");
	}
	
	/**function get element that is suggestion tag element when type into tag name
	 * @author lientm
	 * @param tag: name of suggestion tag
	 * @param number
	 * @return WebElement
	 */
	public static WebElement getSuggestionElement(String tag, String number){	
		String jQuerySelector = ELEMENT_suggestion.replace("${tag}", tag).replace("${No}", number);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return $(\"" + jQuerySelector + "\").get(0);";
		WebElement exampleDiv = (WebElement) js.executeScript(script);
		return exampleDiv;
	}
	
	/**function check Occurence number when add tag
	 * @author lientm
	 * @param number
	 * @param tagName
	 */
	public static void checkOccurenceOfTag(String number, String tagName, String... prefix){
		String valid = prefix.length > 0 ? prefix[0]: tagName;
		String[] tag = tagName.split(" ");
		String[] pre = valid.split(" ");
		By element_tag_no = By.xpath(ELEMENT_TAG_NUMBER.replace("${No}", number));
		
		if (pre.length == tag.length){
			goToAddTagForTopic();
			for (int i = 0; i < pre.length; i ++){
				type(ELEMENT_ADD_TAG, pre[i], true);
				info("Check suggesstion and occurence when add tag that is already exited");
				waitForElementPresent(element_tag_no);				
				WebElement exampleDiv = getSuggestionElement(tag[i], number);				
				if (exampleDiv == null) assert false;
				info("Suggesstion and Occurence of tag is true");
			}
		}
	}
	
	/**
	 * function create category -> forum -> topic
	 * @param category: title of category
	 * @param forum: title of forum
	 * @param topic: title of topic
	 */
	public static void makeTopicFromCategory(String category, String forum, String topic, String...topic_content){
		String content = topic_content.length > 0 ? topic_content[0]: topic;
		//add new category
		//goToAddCategory();
		String[] audience = {};
		String[] user_cat = {};
		addCategoryInForum(category, "1", 0, audience, category, 0, user_cat);

		//add new forum
		//goToAddForum();
		String[] add = {forum, "1", "", "", forum};
		String[] userGroup = {};
		addForum(category, add, 0, userGroup, true, "", "", false, 0);

		//add new topic
		goToStartTopic();
		String[] user_topic = {};
		startTopic(topic, content, "", "", "", "", "", "", 0, user_topic);
		click(By.linkText(topic));
		waitForTextPresent(topic);
	}

	/** function approve a topic
	 * @author lientm
	 */
	public static void approveTopic(){
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		info("Approve topic");
		waitForElementPresent(ELEMENT_APPROVE_TOPIC);
		click(ELEMENT_APPROVE_TOPIC);
	}

	/** function censor for Topic list
	 * @author lientm
	 * @param topic: title of topic
	 */
	public static void censorTopic(String topic){
		By element_topic = By.xpath(ELEMENT_CENSOR_TOPIC_CHECKBOX.replace("${topic}", topic));

		info("Approve a topic that is pending by censor");
		waitForElementPresent(ELEMENT_MODERATION);
		click(ELEMENT_MODERATION);
		waitForElementPresent(ELEMENT_CENSOR_TOPIC);
		click(ELEMENT_CENSOR_TOPIC);
		waitForElementPresent(ELEMENT_POPUP_CENSOR_TOPIC);
		check(element_topic);
		click(ELEMENT_CENSOR_APPROVE_BUTTON);
		waitForElementNotPresent(ELEMENT_POPUP_CENSOR_TOPIC);
		info("Approve a topic successfully");
	}
	
	/**Function: Go to Topic Types
	 * @author hakt
	 * Date: 07/12/2012
	 */
	
	public static void goToTopicTypes(){
		info("Go to topic types");
		click(ELEMENT_ADMINISTRATION);
		click(ELEMENT_TOPIC_TYPES);
		waitForElementPresent(ELEMENT_TOPIC_MANAGER_POPUP);
	}
	
	/** function: modify data of a topic types 
	 * @author hakt
	 * @param typeName: name of topic type
	 * @param groupName: group icon
	 * @param iconClass: icon
	 */
	public static void modifyDataOfTopicType(String typeName, String groupName, String iconClass){
		info("Modify topic type");
		waitForElementPresent(ELEMENT_TOPIC_ADD_TYPE_POPUP);
		type(ELEMENT_TOPIC_TYPE_NAME, typeName, true);
		chooseIcon(groupName, iconClass);
		save();
	}
	
	/** function: create a topic types 
	 * @author hakt
	 * @param typeName: name of topic type
	 * @param groupName: group icon
	 * @param iconClass: icon
	 */
	public static void createTopicType(String typeName, String groupName, String iconClass){
		info("Add new topic type");
		
		click(ELEMENT_ADD_TOPIC_TYPE_BUTTON);
		modifyDataOfTopicType(typeName, groupName, iconClass);
	}
	
	/**
	 * Function to edit a topic type
	 * @author hakt
	 * @param oldTopicTypeName
	 * @param newTopicTypeName
	 * @param groupName
	 * @param iconClass
	 */
	public static void editTopicType(String oldTopicTypeName, String newTopicTypeName, String groupName, String iconClass){
		By TOPIC_TYPE_TO_EDIT=By.xpath("//td[text()='"+oldTopicTypeName+"']/../*//*[@class='Icon16x16 EditIcon']");
		
		info("Edit a topic type");
		click(TOPIC_TYPE_TO_EDIT);
		modifyDataOfTopicType(newTopicTypeName, groupName, iconClass);
	}
	
	/**
	 * function: delete a topic types 
	 * @author hakt
	 * @param topicTypeName
	 */
	public static void deleteTopicType(String topicTypeName){
		By TOPIC_TYPE_TO_DELETE=By.xpath("//td[text()='"+topicTypeName+"']/../*//*[@class='Icon16x16 DeleteIcon']");
		By ELEMENT_TOPIC_TYPE=By.xpath("//td[text()='"+topicTypeName+"']");
		
		info("Delete topic type");
		click(TOPIC_TYPE_TO_DELETE);
		waitForElementNotPresent(ELEMENT_TOPIC_TYPE);
	}
	
	/** function: go to add poll for topic from More action/Add poll
	 * @author lientm
	 */
	public static void goToAddPoll(){
		info("Go to add poll for topic");
		waitForElementPresent(ELEMENT_MORE_ACTION);
		click(ELEMENT_MORE_ACTION);
		waitForElementPresent(ELEMENT_ADD_POLL);
		click(ELEMENT_ADD_POLL);
		waitForElementPresent(ELEMENT_POLL_POPUP);
	}
	
	/**Function add a poll for topic
	 * @author lientm
	 * @param pollQuestion: question of poll
	 * @param poll0: name of option1
	 * @param poll1: name of option2
	 * @param timeout
	 * @param changeVote
	 * @param verify
	 */
	public static void addPoll(String pollQuestion, String poll0, String poll1, String timeout, boolean changeVote, boolean... verify){
		boolean check = verify.length > 0 ? verify[0]: true;
		
		type(ELEMENT_POLL_QUESTION, pollQuestion, true);
		type(ELEMENT_POLL_OPTION0, poll0, true);
		type(ELEMENT_POLL_OPTION1, poll1, true);
		if (timeout != null){
			type(ELEMENT_POLL_CLOSE, timeout, true);
		}
		WebElement vote = waitForAndGetElement(ELEMENT_POLL_VOTE_AGAIN);
		if ((changeVote && !vote.isDisplayed()) || (changeVote && vote.isDisplayed())){
			click(ELEMENT_POLL_VOTE_AGAIN);
		}
		click(ELEMENT_POLL_SUBMIT_BUTTON);
		if (check){
			waitForElementNotPresent(ELEMENT_POLL_POPUP);
			info("Add poll successfully");
		}
	}
	
	/** function: delete all topic
	 * @author HangNTT
	 * @param title: All topic that needs to delete
	 */

	public static void deleteAllTopic(){
		waitForElementPresent(ELEMENT_CHECK_ALL);
		click(ELEMENT_CHECK_ALL);
		info("Delete topic");
		waitForElementPresent(ELEMENT_MODERATION);
		click(ELEMENT_MODERATION);
		waitForElementPresent(ELEMENT_MODERTATION_DELETE_BUTTON);
		click(ELEMENT_MODERTATION_DELETE_BUTTON);
		acceptAlert();
		waitForTextPresent("This forum is empty.");
		info("Delete topic successfully");
	}

	/**Function start a topic that add new topic type
	 * @author thaopth
	 * @param title
	 * @param message
	 * @param typeName
	 * @param groupName
	 * @param classIcon
	 * @param type
	 */
	public static void startTopicWithType (String title, String message,String typeName, String groupName, String classIcon, String type) {
		info("Start a topic");
		inputDataInContentTab_StartTopic(title, message);
		click(ELEMENT_TOPIC_OPTIONS_TAB);
		inputDataInOptionsTab_StartTopic(typeName, groupName, classIcon,type,"","",false);
		click(ELEMENT_SUBMIT_BUTTON);
		waitForElementNotPresent(ELEMENT_POPUP_START_TOPIC);
		info("Start topic successfully");
	}
	
	public static void startTopicWithInvalidType (String title, String message, String typeName, String warningMessage) {
		info("Start a topic");
		inputDataInContentTab_StartTopic(title, message);
		click(ELEMENT_TOPIC_OPTIONS_TAB);
		info("Add new topic type");
		waitForElementPresent(ELEMENT_TOPIC_ADD_TYPE);
		click(ELEMENT_TOPIC_ADD_TYPE);
		info("Modify topic type");
		waitForElementPresent(ELEMENT_TOPIC_ADD_TYPE_POPUP);
		type(ELEMENT_TOPIC_TYPE_NAME, typeName, true);
		save();		
		waitForTextPresent(warningMessage);
		click(ELEMENT_OK_BUTTON);
		click(ELEMENT_CANCEL_ADD_TYPE);
		waitForElementNotPresent(ELEMENT_CANCEL_ADD_TYPE);
		click(ElEMENT_CANCEL_ADD_TOPIC);
		waitForElementNotPresent(ElEMENT_CANCEL_ADD_TOPIC);
	}

}
