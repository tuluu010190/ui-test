package org.exoplatform.selenium.platform.ks.functional.forum.post;

import static org.exoplatform.selenium.platform.ManageAccount.signIn;
import static org.exoplatform.selenium.platform.ManageAccount.signOut;
import static org.exoplatform.selenium.platform.ks.ForumManageCategory.*;
import static org.exoplatform.selenium.platform.ks.PostManagement.*;

import org.exoplatform.selenium.platform.ks.KsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author HangNTT
 * @date: 20/12/2012
 */

public class KS_Forum_Post_BBCode extends KsBase {

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn");
		goToForums();
	}
	/*Case01: Check Bold Tag Effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test01_CheckBoldTagEffect(){
		String category = "Check Bold tag effect_cat_01";
		String forum = "Check Bold tag effect_forum_01";
		String topic ="Check Bold tag effect_topic_01";
		String message = "Hello"; 
		
		By ELEMENT_VERIFY_PREVIEW_BOLD = By.xpath("//strong[text()='" + message + "']");

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[B]" + message + "[/B]", ELEMENT_VERIFY_PREVIEW_BOLD);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case02: Check Italic Tag Effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test02_CheckItalicTagEffect(){
		String category = "Check Italic tag effect_cat_02";
		String forum = "Check Italic tag effect_forum_02";
		String topic ="Check Italic tag effect_topic_02";
		String message = "Greate"; 
		
		By ELEMENT_VERIFY_PREVIEW_ITALIC = By.xpath("//i[text()='" + message + "']");

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[I]" + message + "[/I]", ELEMENT_VERIFY_PREVIEW_ITALIC);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case03: Check Underline tag effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test03_CheckUnderlineTagEffect(){
		String category = "Check Underline tag effect_cat_03";
		String forum = "Check Underline tag effect_forum_03";
		String topic ="Check Underline tag effect_topic_03";
		String message = "Good Morning"; 
		
		By ELEMENT_VERIFY_PREVIEW_UNDERLINE = By.xpath("//u[text()='" + message + "']");

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[u]" + message + "[/u]", ELEMENT_VERIFY_PREVIEW_UNDERLINE);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case04: Check Size Tag Effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test04_CheckSizeTagEffect(){
		String category = "Check Size tag effect_cat_04";
		String forum = "Check Size tag effect_forum_04";
		String topic ="Check Size tag effect_topic_04";
		String message = "HUGE"; 
		
		By ELEMENT_VERIFY_PREVIEW_SIZE_TAG = By.xpath("//font[@size='200'and text()='" + message + "']");

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[size=200]" + message + "[/size]", ELEMENT_VERIFY_PREVIEW_SIZE_TAG);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case05: Check Color Tag Effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test05_CheckColorTagEffect(){

		String newtag = "COLOR_RED";
		String replace = "<font color=red>{param}</font>";
		String description = "Set text is red color";
		String example = "[COLOR_RED]text[/COLOR_RED]";

		String category = "Check Color tag effect_cat_05";
		String forum = "Check Color tag effect_forum_05";
		String topic ="Check Color tag effect_topic_05";
		String message = "Check Color tag effect_topic_05"; 
		
		By ELEMENT_VERIFY_PREVIEW_COLOR_TAG = By.xpath("//font[@color='red' and text()='" + message + "']");

		//create new BBCode
		goToBBCodeManagement();
		addBBCode(newtag, replace, description, example, false);
		waitForElementPresent(By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", newtag)));
		close();

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[COLOR_RED]" + message + "[/COLOR_RED]", ELEMENT_VERIFY_PREVIEW_COLOR_TAG);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);

		//delete BBCode
		goToBBCodeManagement();
		deleteBBcode(newtag, false);
		close();

	}
	/*Case06: Check combined formatting tags
	 * check BBCode is applied for post
	 */
	@Test
	public void test06_CheckCombinedFormattingTagEffect(){

		String newtag = "COLOR_RED";
		String replace = "<font color=red>{param}</font>";
		String description = "Set text is red color";
		String example = "[COLOR_RED]text[/COLOR_RED]";

		String category = "Check Combined Formatting tag effect_cat_06";
		String forum = "Check Combined Formatting tag effect_forum_06";
		String topic ="Check Combined Formatting tag effect_topic_06";
		String message = "LOOK AT ME!"; 
		
		By ELEMENT_VERIFY_PREVIEW_COLOR_TAG = By.xpath("//*[@class='PostContent']//font[@size='200']/font[@color='red']/strong[text()='" + message + "']");

		//create new BBCode
		goToBBCodeManagement();
		addBBCode(newtag, replace, description, example, false);
		waitForElementPresent(By.xpath(ELEMENT_BBCODE_ACTIVE_NO_OPTION.replace("${tag}", newtag)));
		close();

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[size=200][color=red][b]" + message + "[/b][/color][/size]", ELEMENT_VERIFY_PREVIEW_COLOR_TAG);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);

		//delete BBCode
		goToBBCodeManagement();
		deleteBBcode(newtag, false);
		close();

	}
	/*Case07: Check Quote tag effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test07_CheckQuoteTagEffect(){
		String category = "Check Quote tag effect_cat_07";
		String forum = "Check Quote tag effect_forum_07";
		String topic ="Check Quote tag effect_topic_07";
		String message = "The text Mr. Bin wrote would go here"; 
		
		By ELEMENT_VERIFY_PREVIEW_BOLD = By.xpath("//strong[text()='Mr. Bin']");

		By ELEMENT_VERIFY_PREVIEW_TEXT = By.xpath("//div[text()='" + message + "']");
		
		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[quote=Mr. Bin]" + message + "[/quote]", ELEMENT_VERIFY_PREVIEW_BOLD, ELEMENT_VERIFY_PREVIEW_TEXT);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case08: Check Code Tag Effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test08_CheckCodeTagEffect(){
		String category = "Check Code tag effect_cat_08";
		String forum = "Check Code tag effect_forum_08";
		String topic ="Check Code tag effect_topic_08";
		String message = "package main.test.utils;"; 
		By ELEMENT_VERIFY_PRIVIEW_KEYWORD = By.xpath("//span[@class='keyword' and text()='package']");
		By ELEMENT_VERIFY_PREVIEW_CODE = By.xpath("//span[contains(text(), 'main.test.utils;')]");

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[code=java]" + message + "[/code]", ELEMENT_VERIFY_PRIVIEW_KEYWORD, ELEMENT_VERIFY_PREVIEW_CODE);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case09: Check Unordered list effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test09_CheckUnorderedListEffect(){
		String category = "Check Quote tag effect_cat_09";
		String forum = "Check Quote tag effect_forum_09";
		String topic ="Check Quote tag effect_topic_09";
		String message = "[*]Red[*]Blue[*]Yellow"; 

		By ELEMENT_VERIFY_ORDER_LIST1 = By.xpath("//ul/li[1][contains(text(),'Red')]");
		By ELEMENT_VERIFY_ORDER_LIST2 = By.xpath("//ul/li[2][contains(text(),'Blue')]");
		By ELEMENT_VERIFY_ORDER_LIST3 = By.xpath("//ul/li[3][contains(text(),'Yellow')]");
		
		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[list]" + message + "[/list]", ELEMENT_VERIFY_ORDER_LIST1,ELEMENT_VERIFY_ORDER_LIST2, ELEMENT_VERIFY_ORDER_LIST3);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case10: Check Ordered list effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test10_CheckOrderedListEffect(){
		String category = "Check Ordered List effect_cat_10";
		String forum = "Check Ordered List effect_forum_10";
		String topic ="Check Ordered List effect_topic_10";
		String message = "[*]Go to the shops [*]Buy a new computer [*]Swear at computer when it crashes";

		By ELEMENT_VERIFY_ORDER_LIST1 = By.xpath("//ol/li[1][contains(text(),'Go to the shops')]");
		By ELEMENT_VERIFY_ORDER_LIST2 = By.xpath("//ol/li[2][contains(text(),'Buy a new computer')]");
		By ELEMENT_VERIFY_ORDER_LIST3 = By.xpath("//ol/li[3][contains(text(),'Swear at computer when it crashes')]");

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[list=1]" + message + "[/list]", ELEMENT_VERIFY_ORDER_LIST1,ELEMENT_VERIFY_ORDER_LIST2,ELEMENT_VERIFY_ORDER_LIST3);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case11: Check Link effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test11_CheckLinkffect(){
		String category = "Check Link effect_cat_11";
		String forum = "Check Link effect_forum_11";
		String topic ="Check Link effect_topic_11";
		String message = "Visit phpBB!";
		
		By ELEMENT_VERIFY_LINK_EFFECT = By.xpath("//a[@href='http://www.phpbb.com/'and text()='"+ message +"']");
				
		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[url=http://www.phpbb.com/]" + message + "[/url]", ELEMENT_VERIFY_LINK_EFFECT);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case12: Check Email Effect
	 * check BBCode is applied for post
	 */
	@Test
	public void test12_CheckEmailEffect(){
		String category = "Check Code tag effect_cat_12";
		String forum = "Check Code tag effect_forum_12";
		String topic ="Check Code tag effect_topic_12";
		String message = "exomailtest@gmail.com"; 

		By ELEMENT_VERIFY_EMAIL_EFFECT = By.xpath("//a[@href='mailto:"+ message +"'  and text()='"+ message +"']");
		
		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[email]" + message + "[/email]", ELEMENT_VERIFY_EMAIL_EFFECT);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	/*Case13: Check Adding image to a post
	 * check BBCode is applied for post
	 */
	@Test
	public void test13_CheckAddingImageToAPost(){
		String category = "Check Adding image to a post_cat_13";
		String forum = "Check Adding image to a post_forum_13";
		String topic ="Check Adding image to a post_topic_13";
		String message = "http://www.google.com/intl/en_ALL/images/logo.gif"; 
		
		By ELEMENT_VERIFY_IMAGE_TO_POST = By.xpath("//img[@class='inlineimg' and @src='" + message+ "']");

		makeTopicFromCategory(category, forum, topic);
		
		quickReplyAndPreview("[img]" + message + "[/img]", ELEMENT_VERIFY_IMAGE_TO_POST);

		//delete data
		jumpTo("    "+ category);
		deleteCategory(category);
	}
	@AfterMethod
	public void afterTest(){
		signOut();
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
