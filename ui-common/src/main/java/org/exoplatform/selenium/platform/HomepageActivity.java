package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomepageActivity extends PlatformBase {

	//Author of activity
	public final String ELEMENT_ACTIVITY_AUTHOR_SPACE="//*[@class='author']//*[contains(@href,'$user')]/../..//*[@data-original-title='$space']";

	//Home page space menu
	public final By ELEMENT_SPACE_MENU_ACTIVITY_PORTLET=By.xpath(".//*[@class='uiIconAppSpaceActivityStreamPortlet uiIconDefaultApp']");
	public final By ELEMENT_SPACE_MENU_FORUM_PORTLET=By.xpath(".//*[@class='uiIconAppForumPortlet uiIconDefaultApp']");
	public final By ELEMENT_SPACE_MENU_WIKI_PORTLET=By.xpath(".//*[@class='uiIconAppWikiPortlet uiIconDefaultApp']");
	public final By ELEMENT_SPACE_MENU_DOCUMENT_PORTLET=By.xpath(".//*[@class='uiIconAppFileExplorerPortlet uiIconDefaultApp']");
	public final By ELEMENT_SPACE_MENU_AGENDA_PORTLET=By.xpath(".//*[@class='uiIconAppCalendarPortlet uiIconDefaultApp']");
	public final By ELEMENT_SPACE_MENU_SPACE_SETTING_PORTLET=By.xpath(".//*[@class='class='uiIconAppSpaceSettingPortlet uiIconDefaultApp']");
	public final By ELEMENT_SPACE_MENU_MEMBER_PORTLET=By.xpath(".//*[@class='class='uiIconAppMembersPortlet uiIconDefaultApp']");
	public final By ELEMENT_SPACE_MENU_MORE_BTN =By.xpath(".//*[@class='uiIconAppMoreButton']");
	public final String ELEMENT_SPACE_MENU_APPLICATION_PORTLET=".//*[@id='spaceMenuTab']//*[contains(text(),'${app}')]";
	
	// Composer
	public final By ELEMENT_COMPOSER_INPUT_FILED = By.xpath(".//*[@id='DisplaycomposerInput']");
	public final By ELEMENT_COMPOSER_FILE_BUTTON = By.xpath(".//i[@class='uiIconSocUIDocActivityComposer uiIconSocLightGray']");
	public final By ELEMENT_COMPOSER_MENTION_BUTTON = By.xpath(".//i[@class='uiIconSocMention uiIconSocLightGray']");
	public final By ELEMENT_COMPOSER_LINK_BUTTON = By.xpath(".//i[@class='uiIconSocUILinkActivityComposer uiIconSocLightGray']");
	public final By ELEMENT_COMPOSER_INPUT_LINK_FIELD = By.xpath(".//*[@id='InputLink']");
	public final By ELEMENT_COMPOSER_ATTACH_LINK_BUTTON = By.xpath(".//*[@id='AttachButton']");
	public final By ELEMENT_COMPOSER_SHARE_BUTTON = By.xpath(".//*[@id='ShareButton']");
	public final By ELEMENT_ACTIVITY_WHAT_ARE_YOU_WORKING_LABEL = By.xpath("//div[@id='DisplaycomposerInput']/../div[@class='placeholder']");
	public final String ELEMENT_ACTIVITY_AUTHOR_ACTIVITY = "//*[contains(text(), '${activityText}')]/../../../../..//*[@class='author']";
		
		
	//Task/Event activity
	public final String ELEMENT_ACTIVITY_TASK_EVENT_TITLE = "//*[@class='linkTitle' and text()='$name']";
	public final String ELEMENT_ACTIVITY_TASK_EVENT_DESCRIPTION = "//*[@class='linkTitle' and text()='$name']/../..//*[text()='$description ']";
	public final String ELEMENT_ACTIVITY_TASK_EVENT_DATE = "//*[@class='linkTitle' and text()='$name']/../..//*[@class='dateTime' and contains(text(),'$date')]";
	public final String ELEMENT_ACTIVITY_TASK_EVENT_LOCATION = "//*[@class='linkTitle' and text()='$name']/../..//*[@class='location']";
	public final String ELEMENT_ACTIVITY_TASK_EVENT_COMMENT = "//*[@class='linkTitle' and text()='$name']/../../../..//*[@class='commentList']//*[contains(text(),'$comment')]";
	public final String ELEMENT_ACTIVITY_TASK_EVENT_COMMENT_RECURRING_CANCEL="//*[@class='linkTitle' and text()='$name']/../../../..//*[@class='commentList']//*[contains(text(),'Event cancelled for $date')]";
	public final String ELEMENT_ACTIVITY_EVENT_COMMENT_REPEAT_DAY="Event will be repeated every day, $number times";
	public final String ELEMENT_ACTIVITY_EVENT_COMMENT_CHECK_ALL_DAY="Event is now an all-day event";
	public final String ELEMENT_ACTIVITY_EVENT_COMMENT_UPDATE_TITLE="Title has been updated to: $title";
	public final String ELEMENT_ACTIVITY_EVENT_COMMENT_UPDATE_DES="Description has been updated to: $description";
	public final String ELEMENT_ACTIVITY_EVENT_COMMENT_UPDATE_LOC="Location has been updated to: $location";
	public final String ELEMENT_ACTIVITY_TASK_COMMENT_ATTACHMENT="Attachment(s) has been added to the task";
	public final String ELEMENT_ACTIVITY_TASK_COMMENT_UPDATE_NOTE="Note has been updated to: $note";
	public final String ELEMENT_ACTIVITY_TASK_COMMENT_UPDATE_STATUS_CANCEL="Task has been canceled.";

	//Wiki activity
	public final String ELEMENT_WIKI_COMMENT_EDIT_TITLE = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'title has been updated to: ${title}')]";
	public final String ELEMENT_WIKI_COMMENT_EDIT_CONTENT = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'content has been edited')]";
	public final String ELEMENT_ACTIVITY_WIKI_TITLE = "//*[@class='linkTitle' and text()='${title}']";
	public final String ELEMENT_ACTIVITY_WIKI_CONTENT = "//*[@class='linkTitle' and text()='${title}']/../../..//*[@class='contentWiki theContent']/*[@class='text']";
	public final String ELEMENT_ACTIVITY_WIKI_VERSION = "//*[@class='linkTitle' and text()='${title}']/../..//*[@class = 'pull-right versionLabel' and contains(text(), 'Version: ${version}')]";
	public final String ELEMENT_ACTIVITY_MOVE_WIKI_PAGE = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'Page has been moved to: ${path}')]";

	//Question activity
	public final String ELEMENT_QUESTION_ACTIVITY_TITLE="//*[@class='author']/*[contains(@href,'$user')]/../../..//*[@class='titleAnswer']/*[@class='linkTitle' and text()='$question']";
	public final String ELEMENT_QUESTION_ACTIVITY_RATING="//*[@class='author']/*[contains(@href,'$user')]/../../..//*[@class='titleAnswer']/*[@class='linkTitle' and text()='$question']/../..//*[@class='avgRatingImages sumaryRate']";
	public final String ELEMENT_QUESTION_ACTIVITY_CONTENT="//*[@class='author']/*[contains(@href,'$user')]/../../..//*[contains(@class,'titleAnswer')]/*[@class='linkTitle' and text()='$question']/../../..//*[contains(@class,'contentAnswer')]//*[@class='text']";
	public final String ELEMENT_QUESTION_ACTIVITY_ANSWER_NUMBER="//*[@class='author']/*[contains(@href,'$user')]/../../..//*[contains(@class,'titleAnswer')]/*[@class='linkTitle' and text()='$question']/../../..//*[contains(@class,'contentAnswer')]//*[contains(text(),'$number Answer')]";
	public final String ELEMENT_QUESTION_ACTIVITY_COMMENT_NUMBER="//*[@class='author']/*[contains(@href,'$user')]/../../..//*[contains(@class,'titleAnswer')]/*[@class='linkTitle' and text()='$question']/../../..//*[contains(@class,'contentAnswer')]//*[contains(text(),'$number Comment')]";
	public final String ELEMENT_QUESTION_ACTIVITY_COMMENT_CONTENT="//*[@class='author']/*[contains(@href,'$userActivity')]/../../..//*[contains(@class,'titleAnswer')]/*[@class='linkTitle' and text()='$question']/../../../..//*[@class='commentList']/div[$index]//*[@class='author']/*[contains(@href,'$userComment')]/../../*[@class='contentComment']";
	public final String ELEMENT_QUESTION_ACTIVITY_COMMENT_ANSWER="Answer has been submitted: ";
	public final String ELEMENT_QUESTION_ACTIVITY_NUMBER_COMMENT="//*[@class='author']/*[contains(@href,'$user')]/../../..//*[contains(@class,'titleAnswer')]/*[@class='linkTitle' and text()='$question']/../../../..//*[contains(@id,'CommentLink')]";
	public final String ELEMENT_QUESTION_ACTIVITY_UNACTIVATE_COMMENT="Question has been unactivated";
	public final String ELEMENT_QUESTION_ACTIVITY_ACTIVATE_COMMENT="Question has been activated";
	public final String ELEMENT_QUESTION_ACTIVITY_UPDAT_TITLE_COMMENT="Title has been updated to: $value";
	
	// Activity of file
	public String ELEMENT_ACTIVITY_FILE_TITLE = "//*[@class='fileTypeContent']/..//*[@class='linkTitle' and contains(text(),'{$title}')]";
	public String ELEMENT_ACTIVITY_FILE_CHECK_ICON_FILE = "//*[@data-original-title='{$title}']//*[@class='uiIcon64x64FileHtml uiIcon64x64nt_file']";
	public String ELEMENT_ACTIVITY_FILE_TITLE_CHECK_FILE_SIZE = "//*[@class='fileTypeContent']/..//*[@class='linkTitle' and contains(text(),'{$title}')]/..//*[@class='versionFile' and contains(text(),'File Size:')]";
	public String ELEMENT_ACTIVITY_FILE_EDIT_FILE_FROM_ACTIVITY = "//*[@class='fileTypeContent']/..//*[@class='linkTitle' and contains(text(),'{$title}')]/../../../..//*[@class='uiIconEdit uiIconLightGray']";

	// Activity of web content
	public String ELEMENT_ACTIVITY_WEBCONTENT_TITLE = "//*[@class='uiIcon64x64Templateexo_webContent']/../..//*[@class='linkTitle' and contains(text(),'{$title}')]";
	public String ELEMENT_ACTIVITY_WEBCONTENT_CHECK_VERSION ="//*[@class='uiIcon64x64Templateexo_webContent']/../..//*[@class='linkTitle' and contains(text(),'{$title}')]/..//*[@class='versionFile' and contains(text(),'Version: {$version}')]";
	public String ELEMENT_ACTIVITY_WEBCONTENT_CHECK_STATUS ="//*[@class='uiIcon64x64Templateexo_webContent']/../..//*[@class='linkTitle' and contains(text(),'{$title}')]/..//*[@class='versionFile' and contains(text(),'- {$status}')]";

	// Activity of Product
	public String ELEMENT_ACTIVITY_PRODUCT_TITLE = "//*[@class='uiIcon64x64Templateacme_product']/../..//*[@class='linkTitle' and contains(text(),'{$title}')]";
	public String ELEMENT_ACTIVITY_PRODUCT_CHECK_VERSION ="//*[@class='uiIcon64x64Templateacme_product']/../..//*[@class='linkTitle' and contains(text(),'{$title}')]/..//*[@class='versionFile' and contains(text(),'Version: {$version}')]";
	public String ELEMENT_ACTIVITY_PRODUCT_CHECK_STATUS ="//*[@class='uiIcon64x64Templateacme_product']/../..//*[@class='linkTitle' and contains(text(),'{$title}')]/..//*[@class='versionFile' and contains(text(),'- {$status}')]";

	// Activity upload file
	public String ELEMENT_ACTIVITY_FILE_UPLOAD_TITLE ="//*[@class='uiIcon64x64FileWord uiIcon64x64nt_file']/../../..//*[contains(text(),'{$title}')]";
	public String ELEMENT_ACTIVITY_PREVIEW_FILE_WINDOW_NAME_OF_FILE = "//*[@id='UISocialPopupWindow']//*[contains(text(),'{$title}')]";
	public String ELEMENT_ACTIVITY_EDIT_FROM_HOMEPAGE ="//*[@id='UIDocumentForm']//*[contains(text(),'{$title}')]";
	
	// Common activity
	public String ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY = ".//*[contains(text(),'{activity}')]/../../../../..//*[contains(text(),\"${comment}\")]";
	public String ELEMENT_ACTIVITY_VIEW_A_NODE = "//*[@class='linkTitle' and contains(text(),'{$title}')]/../../../..//*[@class='uiIconWatch uiIconLightGray']";
	public String ELEMENT_ACTIVITY_EDIT_A_NODE = "//*[@class='linkTitle' and contains(text(),'{$title}')]/../../../..//*[@class='uiIconEdit uiIconLightGray']";
	public String ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM ="//*[@id='boxContainer']//*[contains(text(),'{$name}')]";
    public String ELEMENT_ACTIVITY_VERSION = ".//*[contains(text(),'${name}')]/../../..//*[.//*[@class='pull-right versionLabel'][text()='${version}']";
	
	//Comment box
	public final String ELEMENT_COMMENTBOX="//*[contains(text(),'${title}')]/../../../..//div[@class='replaceTextArea editable']";
	public final String ELEMENT_ICON_COMMENT = "//*[contains(text(),'${title}')]/../../../..//i[@class='uiIconComment uiIconLightGray']";
	public final String ELEMENT_COMMENT_BUTTON = "//*[contains(text(), '${activityText}')]/../../../..//button[contains(@id,'CommentButton')]";
	public final String ELEMENT_ACTIVITY_ADD_YOUR_COMMENTLABEL = "//*[contains(text(),'${activityText}')]/../../../..//*[contains(@id,'DisplayCommentTextarea')]/../div[@class='placeholder']";
	public final String ELEMENT_DELETE_COMMENT_BUTTON = "//*[contains(text(),'${activityText}')]/../../../..//div[@class='commentList']/div[contains(@id,'commentContainer')]//p[@class='contentComment'  and contains(text(),'${commentText}')]/../../a[contains(@id,'DeleteCommentButton')]";
	public final String ELEMENT_COMMENT_TEXT = "//*[contains(text(),'${activityText}')]/../../../..//div[@class='commentList']/div[contains(@id,'commentContainer')]//p[@class='contentComment'  and contains(text(),'${commentText}')]";
	public final String ELEMENT_ACTIVITY_LIKE_ICON_BLUE = ".//*[@data-original-title='${nameFile}']/../../../..//i[@class='uiIconThumbUp uiIconBlue']";
	public final String ELEMENT_ACTIVITY_COMMENT_VIEW_HOVEROVER = ".//*[contains(text(),'${comment}')]/../..//*[@class='uiIconWatch uiIconLightGray']";
	
	//Activity for Forum
	public final String ELEMENT_ACTIVITY_POLL_VOTE_FOR_POLL = "//*[@id='boxContainer']//*[contains(text(),'{$name}')]/../../../..//*[@class='uiIconSocVote uiIconSocLightGray']";
	public final String ELEMENT_ACTIVITY_TOPIC_REPLY = "//*[@id='boxContainer']//*[contains(text(),'{$name}')]/../../../..//*[@class='uiIconReply uiIconLightGray']";
	public final String ELEMENT_ACTIVITY_TOPIC_VIEW_LAST_REPLY = ".//*[contains(text(),'${topic}')]/../../..//*[@class='uiIconSocLastestReply uiIconSocLightGray']";
	/**
	 * constructor
	 * @param dr
	 */
	public HomepageActivity(WebDriver dr){
		this.driver=dr;
	}
	/**
	 * Check activity after added a file
	 * @param title
	 */
	public void checkActivityAddFile(String title){
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_FILE_TITLE.replace("{$title}", title)));
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_FILE_CHECK_ICON_FILE.replace("{$title}", title)));
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_FILE_TITLE_CHECK_FILE_SIZE.replace("{$title}", title)));
	}
	
	/**
	 * Check if there is an activity in the stream
	 * @param name
	 */
	public void checkActivity(String name){
		info("Verify that the activity of the name:"+name+" is shown");
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM.replace("{$name}",name)),3000,0);
		info("The activity of the name:"+name+" is shown successfully");
	}
	/**
	 * Check comment of an activity
	 * @param activity
	 * @param comment
	 */
	public void checkCommentOfActivity(String activity, String comment){
		info("Verify that the comment is added");
		waitForAndGetElement(ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY.replace("${activity}",activity).replace("${comment}", comment),3000,0);
		info("The comment is added successfully");
	}
	/**
	 * Check activity of adding wiki page with 4 lines in the content
	 * @param title
	 * @param content
	 * @param version
	 */
	public void checkActivityAddWikiPage(String title, String content, String version){
		if(version==null)
			version="Version: 1";
		String[] arrayline;
		arrayline=content.split("</br>");
		info("Check wiki page's title");
		waitForAndGetElement(ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM.replace("{$name}",title),2000,0);
		info("Check wiki page's version");
		waitForAndGetElement(ELEMENT_ACTIVITY_VERSION.replace("${name}",title).replace("${version}",version),2000,0);
		info("Check first 4 lines of the wiki page");
		waitForAndGetElement(ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM.replace("{$name}",arrayline[0]),2000,0);
		waitForAndGetElement(ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM.replace("{$name}",arrayline[1]),2000,0);
		waitForAndGetElement(ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM.replace("{$name}",arrayline[2]),2000,0);
		waitForAndGetElement(ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM.replace("{$name}",arrayline[3]),2000,0);
		info("Check line 5 of the wiki page is not shown");
		waitForElementNotPresent(ELEMENT_ACTIVITY_ELEMENT_IN_ACTIVITY_STREAM.replace("{$name}",arrayline[4]));
	}
	
	/**
	 * Check activity after add a web content
	 * @param title
	 * @param version
	 * @param status
	 */
	public void checkActivityAddWebContent(String title, String version, String status){
		if(version==null)
			version="0";
		if(status==null)
			status="Draft";	
		// check icon and title
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_WEBCONTENT_TITLE.replace("{$title}", title)));
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_WEBCONTENT_CHECK_VERSION.replace("{$title}", title).replace("{$version}", version)));
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_WEBCONTENT_CHECK_STATUS.replace("{$title}", title).replace("{$status}", status)));
	}
	
	/**
	 * Check activity after add a product
	 * @param title
	 * @param version
	 * @param status
	 */
	public void checkActivityAddProduct(String title, String version, String status){
		if(version==null)
			version="0";
		if(status==null)
			status="Draft";	
		// check icon and title
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_PRODUCT_TITLE.replace("{$title}", title)));
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_PRODUCT_CHECK_VERSION.replace("{$title}", title).replace("{$version}", version)));
		waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_PRODUCT_CHECK_STATUS.replace("{$title}", title).replace("{$status}", status)));
	}
	
	/**
	 * Check content and number of lines of content on activity
	 * @param activityContent
	 * @param content
	 */
	public void checkContentOfActivity(String activityContent, String content){
		String[] sum;
		String[] cont;
		String summaryTemp=activityContent;
		String contentTemp=content;

		info("Check content and number of lines of content on activity");
		if (activityContent.contains("...")){
			summaryTemp = activityContent.replace("...", "");
		}
		if(content.contains("...")){
			contentTemp = content.replace("...", "");

		}
		sum = summaryTemp.split("\n");
		cont = contentTemp.split("<br>");
		String []sumTemp= activityContent.split("\n");
		
		if(cont.length<=4){
			for(int i = 0; i<sum.length; i++){
				info("sum[i]: "+sum[i]);
				info("cont[i]: "+cont[i]);
				assert sum[i].contains(cont[i]);
			}
		}
		else{
			for(int i = 0; i<4; i++){
				assert sum[i].contains(cont[i]);
			}
			assert sumTemp[3].contains(cont[3]+"...");
		}
	}
	
	/**
	 * Add a new comment on activity stream
	 * @param filename
	 * @param textContent
	 */
	public void addComment(String filename, String textContent){
		WebElement input_icon= this.driver.findElement(By.xpath(ELEMENT_ICON_COMMENT.replace("${title}", filename)));
		input_icon.click();
		switchToParentWindow();
		
		WebElement input= this.driver.findElement(By.xpath(ELEMENT_COMMENTBOX.replace("${title}",filename)));
		Actions action =new Actions(driver);
		action.moveToElement(input).sendKeys(textContent).build().perform();
		
		
	    WebElement add_button= this.driver.findElement(By.xpath(ELEMENT_COMMENT_BUTTON.replace("${activityText}", filename)));
	    add_button.click();
	    Utils.pause(2000);
	}
	
	/**
	 * Add new activity for space 
	 * @param addText
	 * @param text
	 * @param addLink
	 * @param link
	 */
	public void addActivity (boolean addText, String text, boolean addLink, String link) {
		info("-- Adding an activity--");
		Utils.pause(3000);
		if (addText) 
		{
			info("----Add text into activity text box-----");
			WebElement inputText = waitForAndGetElement(ELEMENT_COMPOSER_INPUT_FILED,100000);
			WebElement shareButton = waitForAndGetElement(ELEMENT_COMPOSER_SHARE_BUTTON);
			WebElement workingLabel = waitForAndGetElement(ELEMENT_ACTIVITY_WHAT_ARE_YOU_WORKING_LABEL);
			((JavascriptExecutor)driver).executeScript("arguments[0].textContent = '';", workingLabel);
			((JavascriptExecutor)driver).executeScript("arguments[0].textContent = '"+text+"';", inputText);
			((JavascriptExecutor)driver).executeScript("arguments[0].disabled = false;", shareButton);
			((JavascriptExecutor)driver).executeScript("arguments[0].className = 'pull-right btn btn-primary';", shareButton);
		}
		if (addLink)
		{
			info("----Click on Link----");
			waitForAndGetElement( ELEMENT_COMPOSER_LINK_BUTTON).click();
			info("----Input link into link box-----");
			waitForAndGetElement(ELEMENT_COMPOSER_INPUT_LINK_FIELD);
			type(ELEMENT_COMPOSER_INPUT_LINK_FIELD, link, true);
			waitForAndGetElement(ELEMENT_COMPOSER_ATTACH_LINK_BUTTON);
			info("----Click attach button-----");
			click(ELEMENT_COMPOSER_ATTACH_LINK_BUTTON);
			waitForAndGetElement(By.id("LinkTitle"));
		}
		waitForAndGetElement(ELEMENT_COMPOSER_SHARE_BUTTON);
		info("----Click share button----");
		click(ELEMENT_COMPOSER_SHARE_BUTTON);
		Utils.pause(1000);
		info("-- Verify that an activity has been added --");
		if (addText) {
			waitForAndGetElement(By.xpath(ELEMENT_ACTIVITY_AUTHOR_ACTIVITY.replace("${activityText}", text)));
		}
	}
	/**
	 * Open More menu of Space menu
	 */
	public void openMorelist(){
		info("Click on More button");
		click(ELEMENT_SPACE_MENU_MORE_BTN);
		Utils.pause(2000);
	}
}
