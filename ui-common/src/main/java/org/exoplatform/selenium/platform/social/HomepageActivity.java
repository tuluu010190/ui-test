package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageActivity extends PlatformBase {

	//Author of activity
	public final String ELEMENT_ACTIVITY_AUTHOR_SPACE="//*[@class='author']//*[contains(@href,'$user')]/../..//*[@data-original-title='$space']";

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
	public String ELEMENT_ACTIVITY_COMMOM_CHECK_COMMENT_OF_ACTIVITY = "//*[@id='boxContainer']//*[contains(text(),'{$title}')]/../../../..//*[@class='commentList']//*[contains(text(),'{$comment}')]";
	public String ELEMENT_ACTIVITY_VIEW_A_NODE = "//*[@class='linkTitle' and contains(text(),'{$title}')]/../../../..//*[@class='uiIconWatch uiIconLightGray']";
	public String ELEMENT_ACTIVITY_EDIT_A_NODE = "//*[@class='linkTitle' and contains(text(),'{$title}')]/../../../..//*[@class='uiIconEdit uiIconLightGray']";
	
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
}
