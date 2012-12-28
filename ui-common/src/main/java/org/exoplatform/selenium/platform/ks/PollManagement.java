package org.exoplatform.selenium.platform.ks;
import static org.exoplatform.selenium.platform.ManageApplications.*;
import static org.exoplatform.selenium.platform.NavigationToolbar.*;
import static org.exoplatform.selenium.platform.PageEditor.*;
import static org.exoplatform.selenium.platform.UserGroupManagement.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author thaopth
 * Date: 21 Dec 2012
 */
public class PollManagement extends KsBase {
	//                      ==============Poll portlet screen============
	public static final By ELEMENT_POLL_CATEGORY = By.xpath("//a[@title='poll']");
	public static final By ELEMENT_POLL_PORTLET = By.id("poll/local._poll.PollPortlet");
	public static final By ELEMENT_ADDMORE_ITEMS = By.xpath("//img[@title='Add Item']");
	public static final By ELEMENT_PUBLIC_DATA = By.id("PublicData");
	public static final By ELEMENT_TIMEOUT = By.id("TimeOut");
	public static final By ELEMENT_CHANGEVOTE = By.id("VoteAgain");
	public static final By ELEMENT_MULTICHOICE = By.id("MultiVote");
	public static final By ELEMENT_EDIT_PORTLET = By.xpath("//a[@title='Edit Portlet']");
	public static final By ELEMENT_ADD_POLL_BUTTON = By.linkText("Add Poll");
	public static final By ELEMENT_ADD_POLL_FORM = By.xpath("//span[text()='Add New Poll']");
	public static final By ELEMENT_SUBMIT_POLL_BUTTON = By.linkText("Submit Poll");
	public static final By ELEMENT_SELECT_POLL = By.id("selectPoll");
	public static final By ELEMENT_POLL_QUESTION = By.id("Question");
	public static final By ELEMENT_SELECT_GROUP = By.xpath("//img[@title='Select Group']");
	public static final String ELEMENT_GROUP_PATH = "//a[@class='NodeIcon GroupAdminIcon' and @title='${groupTitle}']";
	public static final By ELEMENT_VOTE_NOW_BUTTON = By.linkText("Vote Now");
	public static final By ELEMENT_VOTE_AGAIN = By.linkText("Vote Again");
	public static final By ELEMENT_HOME_LINK = By.linkText("Home");
	public static final By ELEMENT_SELECT_THIS_GROUP_LINK = By.linkText("Select this Group");
	public static final By ELEMENT_EDIT_POLL_FORM = By.xpath("//span[text()='Edit Poll']");
	public static final String ELEMENT_POLL_QUESTION_LINK = "//div[text()='${pollQuestion} ?']";
	public static final String ELEMENT_POLL_TITLE = "//div[@title='${pollQuestion}']";
	public static final String WARNING_MESSAGE_NO_PERMISSION = "You have no permission to view this poll or the poll has been deleted.";


	/**
	 * 
	 * @param pageName
	 */
	public static void addPageWithPollPortlet (String pageName) {
		showImportApplication(true);
		importApplication();
		pause(1000);
		goToIntranet();
		goToPageEditor_EmptyLayout(pageName);
		pause(500);
		click(ELEMENT_POLL_CATEGORY);
		dragAndDropToObject(ELEMENT_POLL_PORTLET, ELEMENT_DROP_TARGET_NO_LAYOUT);
		pause(1000);
		click(ELEMENT_NEWPAGE_SAVE_BUTTON);
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
	public static void addPollAndSelectPoll (String pollQuestion, String pollOptions, boolean publicData, String groups, String closeDate, boolean changeVote, boolean multipleChoice) {
		goToEditPageEditor();
		mouseOver(ELEMENT_APPS_REG_PORTLET, true);
		click(ELEMENT_EDIT_PORTLET);
		click(ELEMENT_ADD_POLL_BUTTON);
		waitForElementPresent(ELEMENT_ADD_POLL_FORM);
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
			waitForElementPresent(ELEMENT_SELECT_GROUP);
			click(ELEMENT_SELECT_GROUP);
			selectGroup(groups);
			waitForElementPresent(ELEMENT_SELECT_THIS_GROUP_LINK);
			click(ELEMENT_SELECT_THIS_GROUP_LINK);
		}
		type(ELEMENT_TIMEOUT, closeDate, false);
		if (changeVote) click(ELEMENT_CHANGEVOTE);
		if (multipleChoice) click(ELEMENT_MULTICHOICE);
		click(ELEMENT_SUBMIT_POLL_BUTTON);
		waitForElementNotPresent(ELEMENT_ADD_POLL_FORM);
		waitForElementPresent(By.xpath(ELEMENT_POLL_TITLE.replace("${pollQuestion}", pollQuestion)));
		select(ELEMENT_SELECT_POLL,pollQuestion);
		save();
		click(ELEMENT_CLOSE_BUTTON);
		click(ELEMENT_FINISH_ICON);
		waitForElementNotPresent(ELEMENT_FINISH_ICON);
		waitForElementPresent(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", pollQuestion)));

	}

	/**
	 * 
	 * @param changeVote
	 * @param mutipleChoice
	 * @param pollOptions
	 */
	public static void votePollSingleChoice (boolean changeVote, String pollOption) {
		By ELEMENT_POLL_OPTION_PATH = By.id("option_"+pollOption+"");
		WebElement e = waitForAndGetElement(ELEMENT_POLL_OPTION_PATH);
		if (!e.isSelected())
			click(ELEMENT_POLL_OPTION_PATH);

		click(ELEMENT_VOTE_NOW_BUTTON);
		if (changeVote) {
			waitForElementPresent(ELEMENT_VOTE_AGAIN);

		}
	}

	/**
	 * 
	 * @param changeVote
	 * @param index: the option you want to choose
	 */
	public static void votePollMultiChoice (boolean changeVote, int[] index) {
		for (int i = 0; i < index.length; i++) {
			click(By.id("option" + (index[i] - 1)));
		}
		click(ELEMENT_VOTE_NOW_BUTTON);
		if (changeVote) {
			waitForElementPresent(ELEMENT_VOTE_AGAIN);
		}
		else waitForElementNotPresent(ELEMENT_VOTE_AGAIN); 

	}
	/**
	 * 
	 * @param pollQuestion
	 */
	public static void deletePoll (String pollQuestion) {
		By ELEMENT_DELETE_POLL_BUTTON = By.xpath("//div[@title='"+pollQuestion+"']/following::div/img[@title='Delete Poll']");
		goToEditPageEditor();
		mouseOver(ELEMENT_APPS_REG_PORTLET, true);
		click(ELEMENT_EDIT_PORTLET);
		click(ELEMENT_DELETE_POLL_BUTTON);
		waitForElementNotPresent(By.xpath(ELEMENT_POLL_TITLE.replace("${pollQuestion}", pollQuestion)));
		save();
		pause(500);
		click(ELEMENT_CLOSE_BUTTON);
		pause(500);
		click(ELEMENT_FINISH_ICON);
		waitForElementNotPresent(ELEMENT_FINISH_ICON);

	}

	public static void goToPollPortlet (String pageName) {
		mouseOver(ELEMENT_MYSITE_LINK, true);
		mouseOver(ELEMENT_INTRANET_LINK,true);
		mouseOver(ELEMENT_HOME_LINK,true);
		click(By.linkText(pageName));
	}
/**
 * 
 * @param pollQuestion
 * @param newPollQuestion
 */
	public static void editPollQuestion (String pollQuestion, String newPollQuestion) {
		By ELEMENT_EDIT_POLL_BUTTON = By.xpath("//div[@title='"+pollQuestion+"']/following::div/img[@title='Edit Poll']");
		
		goToEditPageEditor();

		mouseOver(ELEMENT_APPS_REG_PORTLET, true);

		click(ELEMENT_EDIT_PORTLET);
		
		waitForElementPresent(ELEMENT_EDIT_POLL_BUTTON);
		
		click(ELEMENT_EDIT_POLL_BUTTON);
		
		waitForElementPresent(ELEMENT_EDIT_POLL_FORM);
		
		type(ELEMENT_POLL_QUESTION, newPollQuestion, true);
		
		click(ELEMENT_SUBMIT_POLL_BUTTON);
		
		waitForElementNotPresent(ELEMENT_EDIT_POLL_FORM);
		
		select(ELEMENT_SELECT_POLL, newPollQuestion);
		
		save();
		
		click(ELEMENT_CLOSE_BUTTON);
		
		click(ELEMENT_FINISH_ICON);
		
		waitForElementNotPresent(ELEMENT_FINISH_ICON);
		
		waitForElementPresent(By.xpath(ELEMENT_POLL_QUESTION_LINK.replace("${pollQuestion}", newPollQuestion)));
	}
}

