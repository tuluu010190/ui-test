package org.exoplatform.selenium.platform.forum;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.PlatformPermission;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.exoplatform.selenium.TestLogger.info;

public class ForumTopicManagement extends PlatformBase {
	
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
	
    // reply post form 
    public By ELEMENT_TITLE_POST = By.id("PostTitle");
    public By ELEMENT_POST_CONTENT = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
    public By ELEMENT_POST_FORM_SUBMIT = By.xpath("//*[@id='UIPostForm']//*[contains(text(),'Submit')]");
    public String ELEMENT_POST_IN_TOPIC = "//*[@class='postViewTitle' and contains(text(),'{$title}')]/../..//*[@class='postContent']//*[contains(text(),'{$content}')]";
    public String ELEMENT_POST_IN_TOPIC_QUOTE = "//*[@class='postViewTitle' and contains(text(),'{$title}')]/../..//*[@class='contentQuote']//*[contains(text(),'{$content}')]";
    public String ELEMENT_POST_IN_TOPIC_PRIVATE = "//*[@class='postViewTitle' and contains(text(),'{$title}')]//*[contains(text(),'Post Private')]/../../..//*[contains(text(),'{$content}')]";
    
    // foot page of post
    public String ELEMENT_EDIT_POST = "//*[@class='postViewTitle' and contains(text(),'{$title}')]/../..//*[@data-original-title='Edit This Post']";
	public String ELEMENT_QUOTE_POST = "//*[@class='postViewTitle' and contains(text(),'{$title}')]/../..//*[@data-original-title='Reply with Quote']";
    public String ELEMENT_DELETE_POST = "//*[@class='postViewTitle' and contains(text(),'{$title}')]/../..//*[@data-original-title='Delete This Post']";
	public String ELEMENT_PRIVATE_POST = "//*[@class='postViewTitle' and contains(text(),'{$title}')]/../..//*[@data-original-title='Private Reply']";

    public By ELEMENT_DELETE_BOX_CONFIRMATION = By.xpath("//*[@id='UIForumPopupConfirmation']//*[contains(text(),'OK')]");
    
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
	
	PlatformPermission per;
	ManageAlert alert;
	Button button;
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
	 * list sublinks in More Action menu of Topic
	 * @author quynhpt
	 *
	 */
	public enum specifMoreActionMenuTopic{
		EDIT,ADD_POLL,LOCK,UNLOCK,CLOSE,OPEN,STICK,SPLIT,MOVE,DELETE,WATCHES;
	}
	/**
	 * select a item in More Action menu
	 * By QuynhPT
	 * @param item
	 */
    public void selectItemMoreActionMenuTopic(specifMoreActionMenuTopic item){
    	openMoreActionMenu();
    	info("Select a link in More menu of the topic");
    	switch(item) {
    	case ADD_POLL:
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
		case CLOSE:
			break;
		case OPEN:
			break;
		case STICK:
			break;
		case SPLIT:
			break;
		default:
			break;

		}
	}
	
    /**
     * Post a reply
     * @param title
     * @param content
     */
    public void postReply(String title, String content){
    	click(ELEMENT_POST_REPLY);
    	
		if (title !="")
			type(ELEMENT_TITLE_POST,title,true);
		
		inputFrame(ELEMENT_POST_CONTENT, content);
		click(ELEMENT_POST_FORM_SUBMIT);
    }
    
    /**
     * Edit a post
     * @param title
     * @param newTitle
     * @param newContent
     */
    public void editPost(String title, String newTitle,String newContent){
    	click(By.xpath(ELEMENT_EDIT_POST.replace("{$title}", title)));
    	
    	if (newTitle !="")
			type(ELEMENT_TITLE_POST,newTitle,true);
    	
    	if(newContent !="")
    		inputFrame(ELEMENT_POST_CONTENT, newContent);
    	click(ELEMENT_POST_FORM_SUBMIT);
    }
    
    /**
     * Quote a post 
     * @param title
     * @param newContent
     */
    public void quotePost(String title,String newContent){
    	click(By.xpath(ELEMENT_QUOTE_POST.replace("{$title}",title)));
    	
    	if(newContent !="")
    		inputFrame(ELEMENT_POST_CONTENT, newContent);
    	
    	click(ELEMENT_POST_FORM_SUBMIT);
    }
    
    /**
     * Create a private post
     * @param titlePost
     * @param newTitle
     * @param content
     */
    public void privatePost(String titlePost, String newTitle, String content){
    	click(By.xpath(ELEMENT_PRIVATE_POST.replace("{$title}",titlePost)));
    	
    	if(newTitle !="")
			type(ELEMENT_TITLE_POST,newTitle,true);
    	
    	if(content !="")
    		inputFrame(ELEMENT_POST_CONTENT, content);
    	
    	click(ELEMENT_POST_FORM_SUBMIT);
    }
    
	/**
	 * Add poll
	 * @param question
	 * @param option1
	 * @param option2
	 */
    public void addPoll(String question, String option1, String option2){
    	selectItemMoreActionMenuTopic(specifMoreActionMenuTopic.ADD_POLL);
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
    	selectItemMoreActionMenuTopic(specifMoreActionMenuTopic.DELETE);
    }

}
