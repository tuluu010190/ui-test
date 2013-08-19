package org.exoplatform.selenium.platform.forum;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ManageApplications;
import org.exoplatform.selenium.platform.NavigationToolbar;
import org.exoplatform.selenium.platform.PageEditor;
import org.exoplatform.selenium.platform.UserGroupManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class ForumManagePoll extends ForumBase {
	
	Button but;
	ManageAlert alert;
	ForumManageTopic magTopic;
	ManageApplications app;
	NavigationToolbar navTool;
	PageEditor pageE;
	UserGroupManagement userGroup;
	
	//Poll Manage
	public final By ELEMENT_POLL_CATEGORY = By.xpath("//a[@title='poll']");
	public final By ELEMENT_POLL_PORTLET = By.id("poll/local._poll.PollPortlet");
	public final By ELEMENT_ADDMORE_ITEMS = By.xpath("//img[@title='Add Item']");
	public final By ELEMENT_PUBLIC_DATA = By.id("PublicData");
	public final By ELEMENT_TIMEOUT = By.id("TimeOut");
	public final By ELEMENT_CHANGEVOTE = By.id("VoteAgain");
	public final By ELEMENT_MULTICHOICE = By.id("MultiVote");
	public final By ELEMENT_EDIT_PORTLET = By.xpath("//a[@title='Edit Portlet']");
	public final By ELEMENT_ADD_POLL_BUTTON = By.linkText("Add Poll");
	public final By ELEMENT_ADD_POLL_FORM = By.xpath("//span[text()='Add New Poll']");
	public final By ELEMENT_SUBMIT_POLL_BUTTON = By.linkText("Submit Poll");
	public final By ELEMENT_SELECT_POLL = By.id("selectPoll");
	public final By ELEMENT_POLL_QUESTION = By.id("Question");
	public final By ELEMENT_SELECT_GROUP = By.xpath("//img[@title='Select Group']");
	public final String ELEMENT_GROUP_PATH = "//a[@class='NodeIcon GroupAdminIcon' and @title='${groupTitle}']";
	public final By ELEMENT_VOTE_NOW_BUTTON = By.linkText("Vote Now");
	public final By ELEMENT_VOTE_AGAIN = By.linkText("Vote Again");
	public final By ELEMENT_HOME_LINK = By.linkText("Home");
	public final By ELEMENT_SELECT_THIS_GROUP_LINK = By.linkText("Select this Group");
	public final By ELEMENT_EDIT_POLL_FORM = By.xpath("//span[text()='Edit Poll']");
	public final String ELEMENT_POLL_QUESTION_LINK = "//div[text()='${pollQuestion} ?']";
	public final String ELEMENT_POLL_TITLE = "//div[@title='${pollQuestion}']";
	public final String WARNING_MESSAGE_NO_PERMISSION = "You have no permission to view this poll or the poll has been deleted.";


	/*------------------------------------Common function------------------------------*/
	/**
	 * 
	 * @param pageName
	 */
	public void addPageWithPollPortlet (String pageName) {
		app.showImportApplication(true);
		app.importApplication();
		Utils.pause(1000);
		navTool.goToHomePage();
		pageE.goToPageEditor_EmptyLayout(pageName);
		Utils.pause(500);
		click(ELEMENT_POLL_CATEGORY);
		dragAndDropToObject(ELEMENT_POLL_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);
		Utils.pause(1000);
		pageE.finishEditLayout();
	}
	/**
	 * 
	 * @param pollQuestion
	 * @param pollOptions: options of poll, seperated by /
	 * @param publicData
	 * @param groups
	 * @param closeDate
	 * @param changeVote
	 * @param multipleChoice
	 */
	public void addPollAndSelectPoll (String pollQuestion, String pollOptions, boolean publicData, String groups, String closeDate, boolean changeVote, boolean multipleChoice) {
		navTool.goToEditPageEditor();
		//mouseOver(pageE.ELEMENT_APPS_REG_PORTLET, true);
		click(ELEMENT_EDIT_PORTLET);
		click(ELEMENT_ADD_POLL_BUTTON);
		waitForAndGetElement(ELEMENT_ADD_POLL_FORM);
		type(ELEMENT_POLL_QUESTION, pollQuestion, false);
		String[] pollOption = pollOptions.split("/");
		for (int i = 0; i < pollOption.length; i++){
			if (i > 1){
				click(ELEMENT_ADDMORE_ITEMS);
			}
			type(By.id("Option" + i), pollOption[i], false);
		}
		if (!publicData) {
			click(ELEMENT_PUBLIC_DATA);
			waitForAndGetElement(ELEMENT_SELECT_GROUP);
			click(ELEMENT_SELECT_GROUP);
			userGroup.selectGroup(groups);
			waitForAndGetElement(ELEMENT_SELECT_THIS_GROUP_LINK);
			click(ELEMENT_SELECT_THIS_GROUP_LINK);
		}
		type(ELEMENT_TIMEOUT, closeDate, false);
		if (changeVote) click(ELEMENT_CHANGEVOTE);
		if (multipleChoice) click(ELEMENT_MULTICHOICE);
		click(ELEMENT_SUBMIT_POLL_BUTTON);
		waitForElementNotPresent(ELEMENT_ADD_POLL_FORM);
		waitForAndGetElement(By.xpath(ELEMENT_POLL_TITLE.replace("${pollQuestion}", pollQuestion)));
		select(ELEMENT_SELECT_POLL,pollQuestion);
		but.save();
		but.close();
		pageE.finishEditLayout();
		waitForAndGetElement(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", pollQuestion)));

	}

	/**
	 * 
	 * @param changeVote
	 * @param mutipleChoice
	 * @param pollOptions
	 */
	public void votePollSingleChoice (boolean changeVote, String pollOption) {
		By ELEMENT_POLL_OPTION_PATH = By.id("option_"+pollOption+"");
		WebElement e = waitForAndGetElement(ELEMENT_POLL_OPTION_PATH);
		if (!e.isSelected())
			click(ELEMENT_POLL_OPTION_PATH);

		click(ELEMENT_VOTE_NOW_BUTTON);
		if (changeVote) {
			waitForAndGetElement(ELEMENT_VOTE_AGAIN);

		}
	}

	/**
	 * 
	 * @param changeVote
	 * @param index: the option you want to choose
	 */
	public void votePollMultiChoice (boolean changeVote, int[] index) {
		for (int i = 0; i < index.length; i++) {
			click(By.id("option" + (index[i] - 1)));
		}
		click(ELEMENT_VOTE_NOW_BUTTON);
		if (changeVote) {
			waitForAndGetElement(ELEMENT_VOTE_AGAIN);
		}
		else waitForElementNotPresent(ELEMENT_VOTE_AGAIN); 

	}
	/**
	 * 
	 * @param pollQuestion
	 */
	public void deletePoll (String pollQuestion) {
		By ELEMENT_DELETE_POLL_BUTTON = By.xpath("//div[@title='"+pollQuestion+"']/following::div/img[@title='Delete Poll']");
		navTool.goToEditPageEditor();
		//mouseOver(ELEMENT_APPS_REG_PORTLET, true);
		click(ELEMENT_EDIT_PORTLET);
		click(ELEMENT_DELETE_POLL_BUTTON);
		waitForElementNotPresent(By.xpath(ELEMENT_POLL_TITLE.replace("${pollQuestion}", pollQuestion)));
		but.save();
		but.close();
		pageE.finishEditLayout();

	}

	public void goToPollPortlet (String pageName) {
		mouseOver(ELEMENT_HOME_LINK,true);
		click(By.linkText(pageName));
	}
	/**
	 * 
	 * @param pollQuestion
	 * @param newPollQuestion
	 */
	public void editPollQuestion (String pollQuestion, String newPollQuestion) {
		By ELEMENT_EDIT_POLL_BUTTON = By.xpath("//div[@title='"+pollQuestion+"']/following::div/img[@title='Edit Poll']");		
		
		navTool.goToEditPageEditor();
		//mouseOver(ELEMENT_APPS_REG_PORTLET, true);
		click(ELEMENT_EDIT_PORTLET);
		waitForAndGetElement(ELEMENT_EDIT_POLL_BUTTON);
		click(ELEMENT_EDIT_POLL_BUTTON);
		waitForAndGetElement(ELEMENT_EDIT_POLL_FORM);
		type(ELEMENT_POLL_QUESTION, newPollQuestion, true);
		click(ELEMENT_SUBMIT_POLL_BUTTON);
		waitForElementNotPresent(ELEMENT_EDIT_POLL_FORM);
		select(ELEMENT_SELECT_POLL, newPollQuestion);		
		but.save();		
		but.close();		
		pageE.finishEditLayout();		
		waitForAndGetElement(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", newPollQuestion)));
	}
}

