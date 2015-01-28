package org.exoplatform.selenium.platform.forum;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.exoplatform.selenium.platform.forum.ForumHomePage.specifMoreActionMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.exoplatform.selenium.TestLogger.info;

public class ForumTopicManagement extends PlatformBase {
	PlatformPermission per;
	ManageAlert alert;
	Button button;
	
	public By ELEMENT_POST_REPLY =By.xpath("//*[@id='UITopicDetail']//*[@class='pull-left actionContainer']/a[contains(text(),'Post Reply')]");
	
	//More Action menu
	public final By ELEMENT_MORE_ACTION = By.xpath("//*[@data-toggle='dropdown']/*[@class='uiIconSettings uiIconLightGray']");
	public final By ELEMENT_EDIT_TOPIC = By.xpath("//*[contains(@href, 'EditTopic')]");
	public final By ELEMENT_DELETE_TOPIC = By.xpath("//*[contains(@data-action, 'SetDeleteTopic')]");
	public final By ELEMENT_MOVE_TOPIC = By.xpath("//*[contains(@href, 'MoveTopic')]");
	public final By ELEMENT_LOCK_TOPIC = By.className("uiIconLockMedium");
	public final By ELEMENT_UNLOCK_TOPIC = By.className("uiIconUnlockMedium");
	public final By ELEMENT_ADD_POLL = By.xpath(".//*[@id='UITopicDetail']//a[contains(text(),'Add Poll')]");
	
	// Post on a topic
	public final By ELEMENT_TOPIC_POST_A_REPLY_TITLE = By.id("PostTitle");
	public final By ELEMENT_TOPIC_CANCEL_A_POST = By.xpath("//*[@id='UIPostForm']//*[contains(text(),'Cancel')]");
	
	//  Poll
    public By ELEMENT_POLL_QUESTION = By.id("Question");
    public By ELEMENT_POLL_OPTIONS0 = By.id("Option0");
    public By ELEMENT_POLL_OPTIONS1 = By.id("Option1");
    public By ELEMENT_POLL_SUBMIT = By.xpath("//*[@id='UIPollForm']//*[contains(text(),'Submit Poll')]");
    public By ELEMENT_EDIT_POLL_MORE_ACTIONS = By.xpath("//*[@class='uiIconPoll uiIconLightGray']/../..//*[@class='uiIconSettings uiIconLightGray']");
    public By ELEMENT_EDIT_POLL = By.xpath("//*[@id='UITopicPoll']//*[contains(text(),'Edit')]");
    public By ELEMENT_REMOVE_POLL = By.xpath("//*[@id='UITopicPoll']//*[contains(text(),'Remove')]");
    public final By ELEMENT_POLL_POPUP_TITLE= By.xpath(".//*[@id='UIForumPopupWindow']//span[text()='Poll']");
	
	public By ELEMENT_OK_DELETE = By.xpath("//*[@id='UIForumPopupConfirmation']//*[contains(text(),'OK')]");
	
	//move a topic
	public String ELEMENT_UI_POPUP_MOVE_TOPIC ="//*[@id='MoveTopicForm']//*[@class='node']//*[contains(text(),'{$forum}')]";
	public final String ELEMENT_MOVE_POPUP_COLLASPE_NODE =".//*[@class='uiIconNode collapseIcon'][contains(.,'${category}')]";
	
	/**
	 * constructor
	 * @param dr
	 */
	public ForumTopicManagement(WebDriver dr){
		this.driver=dr;
		alert = new ManageAlert(driver);
		button = new Button(driver);
	}
	/**
	 * Move a topic to a forum
	 * @param locatorForum
	 * @param category
	 * @param forum
	 */
	public void moveTopicToForum(String category,String forum){
		info("if not found forum");
		if(waitForAndGetElement(ELEMENT_UI_POPUP_MOVE_TOPIC.replace("{$forum}",forum), 3000,0)==null){
			info("Click on Category to expand tree");
			click(ELEMENT_MOVE_POPUP_COLLASPE_NODE.replace("${category}",category));
			info("Select the forum");
		    click(ELEMENT_UI_POPUP_MOVE_TOPIC.replace("{$forum}",forum));
		}else{
			info("Select the forum");
			click(ELEMENT_UI_POPUP_MOVE_TOPIC.replace("{$forum}",forum));
		}
		info("Finish moving");
	}
	/**
	 * Open More Action menu
	 * By QuynhPT
	 */
	public void openMoreActionMenu(){
		info("Wait More link is shown");
		waitForAndGetElement(ELEMENT_MORE_ACTION);
		info("Click on More link");
		click(ELEMENT_MORE_ACTION);
	}
	
	/**
	 * select a item in More Action menu
	 * By QuynhPT
	 * @param item
	 */
    public void selectItemMoreActionMenuTopic(specifMoreActionMenu item){
    	openMoreActionMenu();
    	info("Select a link in More menu of the topic");
    	switch(item) {
    	case ADDPOLL:
    		info("Click on Add poll button");
    		click(ELEMENT_ADD_POLL);
    		break;
		case EDIT:
			info("Click on Edit topic button");
			click(ELEMENT_EDIT_TOPIC);
			break;
		case DELETE:
			info("Click on Delete topic button");
			click(ELEMENT_DELETE_TOPIC);
			Utils.pause(1000);
			info("Verify that confirm popup is shown");
			alert.waitForMessage("Are you sure you want to delete this topic ?");
			info("Click on OK on Confirm popup");
			click(ELEMENT_OK_DELETE);
			break;
		case WATCHES:
			break;
		case LOCK:
			info("Click on lock topic button");
			click(ELEMENT_LOCK_TOPIC);
			break;
		case UNLOCK:
			info("Click on unlock topic button");
			click(ELEMENT_UNLOCK_TOPIC);
			break;
		case MOVE:
			info("Wait Move topic link is shown");
			waitForAndGetElement(ELEMENT_MOVE_TOPIC);
			info("Click on move topic link");
			click(ELEMENT_MOVE_TOPIC);
			break;
		default:
			break;

		}
	}
	
	/**
	 * Add Poll
	 * @param question
	 * @param option1
	 * @param option2
	 */
    public void addPoll(String question, String option1, String option2){
    	selectItemMoreActionMenuTopic(specifMoreActionMenu.ADDPOLL);
    	info("Input a question to poll");
    	type(ELEMENT_POLL_QUESTION,question,true);
    	info("Input an option 1 to poll");
    	type(ELEMENT_POLL_OPTIONS0,question,true);
    	info("Input an option 2 to poll");
    	type(ELEMENT_POLL_OPTIONS1, question,true);
    	info("Click on Submit button");
    	click(ELEMENT_POLL_SUBMIT);
    	info("Finished adding poll");
    }
    
    /**
     * Edit Poll
     * @param question
     * @param option1
     * @param option2
     */
    public void editPoll(String question,String option1, String option2){
    	info("Click on More Action on Poll portlet");
    	click(ELEMENT_EDIT_POLL_MORE_ACTIONS);
    	info("Click on Edit poll link");
    	click(ELEMENT_EDIT_POLL);
    	info("Refresh the page");
    	driver.navigate().refresh();
    	waitForAndGetElement(ELEMENT_POLL_POPUP_TITLE);
    	info("Input a question to poll");
    	waitForAndGetElement(ELEMENT_POLL_QUESTION).clear();
    	type(ELEMENT_POLL_QUESTION,question,true);
    	info("Input an option 1 to poll");
    	waitForAndGetElement(ELEMENT_POLL_OPTIONS0).clear();
    	type(ELEMENT_POLL_OPTIONS0,question,true);
    	info("Input an option 2 to poll");
    	waitForAndGetElement(ELEMENT_POLL_OPTIONS1).clear();
    	type(ELEMENT_POLL_OPTIONS1, question,true);
    	info("Click on Submit button");
    	click(ELEMENT_POLL_SUBMIT);
    	info("Finished adding poll");
    }
	
    /**
     * Delete the poll of the topic
     */
    public void deletePoll(){
    	info("Click on More menu of Poll portlet");
    	click(ELEMENT_EDIT_POLL_MORE_ACTIONS);
    	info("Click on Remove poll link");
    	click(ELEMENT_REMOVE_POLL);
    	info("Click on Ok button");
    	click(ELEMENT_OK_DELETE);
    	info("Finish deleting poll");
    }
    /**
     * Delete a topic
     */
    public void deleteTopic(){
    	info("Delete the topic");
    	selectItemMoreActionMenuTopic(specifMoreActionMenu.DELETE);
    }
}
