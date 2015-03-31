package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import java.util.concurrent.TimeUnit;

import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.forum.ForumBase;
import org.exoplatform.selenium.platform.forum.ForumManagePost;
import org.exoplatform.selenium.platform.forum.ForumManageTopic;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CKeditor extends PlatformBase {
	ForumManagePost mngPost;
	ForumManageTopic mngTopic;
	ForumBase foruBas;
	private WebElement el;

	// ----------------------CKeditor for the files has only one CKEDITOR
	// -------------------------------------------------------------------------------
	public final By ELEMENT_CKEDITOR_TEXT_CONTENT = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
	public final String ELEMENT_CKEDITOR_TEXT_AREA_FRAME= "#${tab} iframe";
	public final By ELEMENT_CKEDITOR_TEXT_CONTENT_BENEFITS = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset' and @title='Rich Text Editor,productBenefits']");
	public final By ELEMENT_CKEDITOR_TEXT_CONTENT_FEATURES = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset' and @title='Rich Text Editor,productFeatures']");
	public final By ELEMENT_CKEDITOR_POPUP = By.xpath(".//*[@id='UIForumPopupWindow']");
	public final By ELEMENT_CKEDITOR_MAXIMIZE = By.cssSelector(".cke_button__maximize_icon");
	public final By ELEMENT_CKEDITOR_MAXIMIZE_STYLE = By.xpath(".//*[@id='ThreadContent-tab'][@style='position: static; overflow: visible; z-index: 9995;']");
	public final By ELEMENT_CKEDITOR_MINIMIZE_STYLE = By.xpath(".//*[@id='ThreadContent-tab'][@style='']");

	public final By ELEMENT_CKEDITOR_CUT = By.cssSelector(".cke_button__cut_icon");
	public final By ELEMENT_CKEDITOR_COPY = By.cssSelector(".cke_button__copy_icon");
	public final By ELEMENT_CKEDITOR_PASTE = By.cssSelector(".cke_button__pastetext_icon");
	public final By ELEMENT_CKEDITOR_UNDO = By.cssSelector(".cke_button__undo_icon");
	public final By ELEMENT_CKEDITOR_REDO = By.cssSelector(".cke_button__redo_icon");
	public final By ELEMENT_CKEDITOR_BOLD = By.cssSelector(".cke_button__bold_icon");
	public final By ELEMENT_CKEDITOR_BOLD_FEATURES =By.cssSelector("#cke_productFeatures .cke_button__bold_icon");
	public final By ELEMENT_CKEDITOR_BOLD_BENEFITS = By.cssSelector("#cke_productBenefits .cke_button__bold_icon");
	public final By ELEMENT_CKEDITOR_ITALIC = By.cssSelector(".cke_button__italic_icon");
	public final By ELEMENT_CKEDITOR_STRIKE = By.cssSelector(".cke_button__strike_icon']");
	public final By ELEMENT_CKEDITOR_UNDERLINE = By.cssSelector(".cke_button__underline_icon");
	public final By ELEMENT_CKEDITOR_ALIGNLEFT = By.cssSelector(".cke_button__justifyleft_icon");
	public final By ELEMENT_CKEDITOR_ALIGNRIGHT = By.cssSelector(".cke_button__justifyright_icon");
	public final By ELEMENT_CKEDITOR_CENTER = By.cssSelector(".cke_button__justifycenter_icon");
	public final By ELEMENT_CKEDITOR_JUSTIFY =By.cssSelector(".cke_button__justifyblock_icon");
	public final By ELEMENT_CKEDITOR_INSERT_REMOVE_NUMLIST = By.cssSelector(".cke_button__numberedlist_icon");
	public final By ELEMENT_CKEDITOR_INSERT_REMOVE_BULLETLIST = By.cssSelector(".cke_button__bulletedlist_icon");
	public final By ELEMENT_CKEDITOR_DECREASE_INDENT =By.cssSelector(".cke_button__outdent_icon");
	public final By ELEMENT_CKEDITOR_INCREASE_INDENT = By.cssSelector(".cke_button__indent_icon");
	public final By ELEMENT_CKEDITOR_TEXT_COLOR = By.cssSelector(".cke_button__textcolor_icon");
	public final String ELEMENT_CKEDITOR_TEXT_COLOR_STYLE = ".//*[contains(@class,'cke_colorblock')][not(contains(@style,'display: none;'))]//*[@class='cke_colorbox'][@style='background-color:#${codeColor}']";
	public final By ELEMENT_CKEDITOR_BLOCK_QUOTE = By.cssSelector(".cke_button__blockquote_icon");
	public final By ELEMENT_CKEDITOR_ADD_UPDATE_CODE = By.cssSelector(".cke_button__syntaxhighlight_icon");
	public final By ELEMENT_CKEDITOR_SHOW_BLOCKS = By.cssSelector(".cke_button__showblocks_icon");
	public final By ELEMENT_CKEDITOR_ANCHOR = By.cssSelector(".cke_button__anchor_icon");
	public final By ELEMENT_CKEDITOR_REMOVE_LINK = By.cssSelector(".cke_button__unlink_icon");
	
	public final By ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_TAB = By.xpath(".//*[@class='cke_dialog_tabs']/a[@title='Source code']");
	public final By ELEMENT_CKEDITOR_ADD_UPDATE_CODE_ADVANCE_TAB = By.xpath(".//*[@class='cke_dialog_tabs']/a[@title='Advanced']");
	public final By ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_TEXTAREA = By.xpath(".//div[@class='cke_dialog_ui_input_textarea']");
	public final By ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_LANGUAGE_BOX = By.xpath(".//div[@class='cke_dialog_ui_input_select']");
	public final String ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_LANGUAGE_ITEM = ".//div[@class='cke_dialog_ui_input_select']//option[contains(text(),'${nameLang}')]";

	public final By ELEMENT_CKEDITOR_ADD_UPDATE_CODE_OK_BUTTON = By.xpath(".//*[@id='cke_708_label']");
	public final By ELEMENT_CKEDITOR_HELP_BB_CODE = By.xpath(".//*[@class='cke_button_icon cke_button__helpbbcode.btn_icon']");
	public final By ELEMENT_CKEDITOR_BBCODE_HELP_CONTENT = By.xpath(".//*[@id='SubBody']//td[contains(text(),'BB Code')]");

	public final By ELEMENT_CKEDITOR_BUTTON_RESIZE = By.xpath(".//*[@class='uiIconResize pull-right uiIconLightGray']");
	public final By ELEMENT_CKEDITOR_BUTTON_CANCEL = By.xpath(".//*[@id='UITopicForm']//button[contains(text(),'Cancel')]");
	public final By ELEMENT_CKEDITOR_BUTTON_SUBMIT = By.xpath(".//*[@id='UITopicForm']//button[contains(text(),'Submit')]");
	public final By ELEMENT_CKEDITOR_BUTTON_PREVIEW = By.xpath(".//*[@id='UITopicForm']//button[contains(text(),'Preview')]");

	public final By ELEMENT_CKEDITOR_BUTTON_SELECTALL = By.cssSelector(".cke_button__selectall_icon");
	
	//--------------------------------------------CKEDITOR FOR DIALOG FRAME
	public final By ELEMENT_CKEDITOR_DIALOG_PASTE_FRAME = By.xpath(".//*[contains(@class,'cke_reset_all') and contains(@role,'dialog') and not(contains(@style,'display: none;'))]//iframe");
	public final By ELEMENT_CKEDITOR_DIALOG_OK_BTN = By.xpath(".//*[contains(@class,'cke_reset_all') and contains(@role,'dialog') and not(contains(@style,'display: none;'))]//*[contains(@class,'cke_dialog_ui_button_ok')]");
	
	//--------------------------------------------CKEDITOR FOR FILES THAT HAS MANY CKEDITORS TOOL

	public final String ELEMENT_CKEDITOR_BOLD_BY_TAB = "#${tab} .cke_button__bold_icon";
	public final String ELEMENT_CKEDITOR_ITALIC_BY_TAB = "#${tab} .cke_button__italic_icon";
	public final String ELEMENT_CKEDITOR_UNDERLINE_BY_TAB = "#${tab} .cke_button__underline_icon";
	public final String ELEMENT_CKEDITOR_PASTE_BY_TAB ="#${tab} .cke_button__paste_icon";
	public final String ELEMENT_CKEDITOR_STIKE_BY_TAB = "#${tab} .cke_button__strike_icon";
	public final String ELEMENT_CKEDITOR_ALIGNLEFT_BY_TAB = "#${tab} .cke_button__justifyleft_icon";
	public final String ELEMENT_CKEDITOR_ALIGNRIGHT_BY_TAB = "#${tab} .cke_button__justifyright_icon";
	public final String ELEMENT_CKEDITOR_CENTER_BY_TAB = "#${tab} .cke_button__justifycenter_icon";
	public final String ELEMENT_CKEDITOR_JUSTIFY_BY_TAB ="#${tab} .cke_button__justifyblock_icon";
	public final String ELEMENT_CKEDITOR_INSERT_REMOVE_BULLETLIST_BY_TAB = "#${tab} .cke_button__bulletedlist_icon";
	public final String ELEMENT_CKEDITOR_INSERT_REMOVE_NUMLIST_BY_TAB = "#${tab} .cke_button__numberedlist_icon";
	public final String ELEMENT_CKEDITOR_TEXT_COLOR_BY_TAB = "#${tab} .cke_button__textcolor_icon";
	public final String ELEMENT_CKEDITOR_BACKGROUND_COLOR_BY_TAB = "#${tab} .cke_button__bgcolor_icon";
	public final String ELEMENT_CKEDITOR_REMOVE_FORMAT_BY_TAB = "#${tab} .cke_button__removeformat_icon";
	public final String ELEMENT_CKEDITOR_INSERT_LINK_BY_TAB = "#${tab} .cke_button__link_icon";
	public final String ELEMENT_CKEDITOR_PARAGRAHP_FORMAT_DROP_DOWN_BOX=".//*[@id='${tab}']//*[@title='Paragraph Format']";
	public final By ELEMENT_CKEDITOR_PARAGRAPH_FORMAT_FRAME = By.cssSelector(".cke_panel_frame");
	public final String ELEMENT_CKEDITOR_PARAGRAPH_FORMAT_SELECTION = ".//*[@title='${title}']";
	
	public final String ELEMENT_CKEDITOR_PARAGRAPH_FONT_DROP_DOWN_BOX = ".//*[@id='${tab}']//*[@title='Font Name']";
	public final String ELEMENT_CKEDITOR_PARAGRAPH_FONT_SELECTION = ".//*[@class='cke_panel_block' and @style='']//a[@title=\"${font}\"]";
	
	public final String ELEMENT_CKEDITOR_PARAGRAPH_SIZE_DROP_DOWN_BOX = ".//*[@id='${tab}']//*[@title='Font Size']";
	public final String ELEMENT_CKEDITOR_PARAGRAPH_SIZE_SELECTION = ".//*[@class='cke_panel_block' and @style='']//a[@title='${fontSize}']";
	
	public final String ELEMENT_CKEDITOR_MAXIMIZE_BY_TAB ="#${tab} .cke_button__maximize_icon";
	public final String ELEMENT_CKEDITOR_DECREASE_INDENT_BY_TAB ="#${tab} .cke_button__outdent_icon";
	public final String ELEMENT_CKEDITOR_INCREASE_INDENT_BY_TAB ="#${tab} .cke_button__indent_icon";
	public final String ELEMENT_CKEDITOR_ANCHOR_BY_TAB = "#${tab} .cke_button__anchor_icon";
	public final String ELEMENT_CKEDITOR_REMOVE_LINK_BY_TAB = "#${tab} .cke_button__unlink_icon";
	
	public final By ELEMENT_CKEDITOR_BOLD_TAB2 = By.cssSelector("#tab2 .cke_button__bold_icon");
	public final By ELEMENT_CKEDITOR_ITALIC_TAB2 = By.cssSelector("#tab2 .cke_button__italic_icon");
	public final By ELEMENT_CKEDITOR_UNDERLINE_TAB2 = By.cssSelector("#tab2 .cke_button__underline_icon");

	public final By ELEMENT_CKEDITOR_BACKGROUND_COLOR = By.xpath(".//*[@class='cke_button_icon cke_button__bgcolor_icon']");
	public final By ELEMENT_CKEDITOR_BACKGROUND_COLOR_FRAME = By.xpath(".//*[@class='cke_panel_frame']");
	
	public final By ELEMENT_CKEDITOR_INSERT_LINK =By.cssSelector(".cke_button__link_icon']");
	public final By ELEMENT_CKEDITOR_TYPE_LINK = By.xpath("//*[contains(@class,'cke_dialog_ui_labeled_label cke_required') and text()='URL']/..//input[@class='cke_dialog_ui_input_text']");
	
	public final By ELEMENT_CKEDITOR_PARAGRAPH_FORMAT = By.xpath(".//*[@class='cke_combo_text']");
	
	
	public final By ELEMENT_CKEDITOR_TYPE_ANCHOR = By.xpath("//input[@class='cke_dialog_ui_input_text']");
	
	
	// --------------------------------------------common
	// functions-------------------------------------------------------

	/**
	 * Setup a new CKeditor with a driver and plf version
	 * @param dr         new driver
	 * @param plfVersion The version of platform
	 */
	public CKeditor(WebDriver dr, String... plfVersion) {
		driver = dr;
		this.plfVersion = plfVersion.length > 0 ? plfVersion[0] : "4.0";
		mngTopic = new ForumManageTopic(driver, this.plfVersion);
		foruBas = new ForumBase();
	}

	/**
	 * To return new line into the content
	 */
	public void cke_ReturnLine() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_TEXT_CONTENT,5000,0)!=null) {
			el = driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT);
			el.sendKeys(Keys.END);
			el.sendKeys(Keys.ENTER);
		}
		if (waitForAndGetElement(mngTopic.ELEMENT_TOPIC_MESSAGE_FRAME_CKEDITOR,5000,0)!=null) {
			el = driver.findElement(mngTopic.ELEMENT_TOPIC_MESSAGE_FRAME_CKEDITOR);
			el.sendKeys(Keys.END);
			el.sendKeys(Keys.ENTER);
		}
	}
	
	/**
	 * Maximize/Minize CKeditor
	 */
	public void cke_Max_Minmize() {
		info("Click on Max or Minmize");
		click(ELEMENT_CKEDITOR_MAXIMIZE);
		Utils.pause(1000);
	}

	/**
	 * Maximize/Minize CKeditor
	 */
	public void cke_Max_Minmize(String nameTabId) {
		info("Click on Max or Minmize");
		click(ELEMENT_CKEDITOR_MAXIMIZE_BY_TAB.replace("${tab}",nameTabId));
		Utils.pause(1000);
	}

	/**
	 * Select a text and click on cut button
	 */
	public void cke_Cut() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_TEXT_CONTENT,5000,0)!=null) {
			info("cut a text");
			el = driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT);
			el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			el.sendKeys(Keys.chord(Keys.CONTROL, "x"));
		}
	}

	/**
	 * Select all the text and click on Copy button
	 */
	public void cke_Copy() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_TEXT_CONTENT,5000,0)!=null) {
			info("copy a text");
			el = driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT);
			el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			el.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		}
	}

	/**
	 * Click on paste button
	 */
	public void cke_Paste() {
			info("Paste a text");
			el = driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT);
			el.sendKeys(Keys.END);
			el.sendKeys(Keys.ENTER);
			el.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	/**
	 * Click on undo button
	 */
	public void cke_Undo() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_UNDO,5000,0)!=null) {
			click(ELEMENT_CKEDITOR_UNDO);
		}
	}

	/**
	 * Click on redo button
	 */
	public void cke_Redo() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_REDO,5000,0)!=null) {
			click(ELEMENT_CKEDITOR_REDO);
		}
	}
	
	/**
	 * Click on paste button by namTabId
	 * for the file that has many CKEditors
	 */
	public void cke_Paste(String nameTabId) {
			info("Paste a text");
			WebElement el = waitForAndGetElement(ELEMENT_CKEDITOR_TEXT_AREA_FRAME.replace("${tab}",nameTabId));
			el.sendKeys(Keys.ENTER);
			el.sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Utils.pause(1000);
	}
	/**
	 * Paste a text into Dialog frame after click Paste button
	 */
	public void cke_PasteDialog(String nameTabId){
		info("Click on Paste button of ckeditor");
		click(ELEMENT_CKEDITOR_PASTE_BY_TAB.replace("${tab}",nameTabId));
		info("Paste a text into the frame");
		WebElement el = waitForAndGetElement(ELEMENT_CKEDITOR_DIALOG_PASTE_FRAME);
		el.sendKeys(Keys.ENTER);
		el.sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Utils.pause(1000);
		click(ELEMENT_CKEDITOR_DIALOG_OK_BTN);
		Utils.pause(2000);
	}
	/**
	 * Strike a text
	 * this function is used for the files has many CKEditor tool
	 * @param nameTabId is the name of Id of the tab as:tab1, tab2...
	 */
	public void cke_Strike(String nameTabId){
		info("Strike a text");
		click(ELEMENT_CKEDITOR_STIKE_BY_TAB.replace("${tab}",nameTabId));
		Utils.pause(200);
	}
	/**
	 * Strike a text
	 * this function is used for the files hase only one CKEDITOR tool
	 */
	public void cke_Strike(){
		info("Strike a text");
		click(ELEMENT_CKEDITOR_STRIKE);
		Utils.pause(1000);
	}

	/**
	 * Bold the text of the content
	 * this function is used for the files has one CKEditor tool
	 * 
	 */
	public void cke_Bold() {
		info("Bold a text");
		click(ELEMENT_CKEDITOR_BOLD);
		Utils.pause(200);
	}

	/**
	 * Bold the text of the content 
	 * this function is used for the files has many CKEditor tool
	 * @param nameTabId is the name of Id of the tab as:tab1, tab2...
	 */
	public void cke_Bold(String nameTabId){
		info("Bold a text");
		click(By.cssSelector(ELEMENT_CKEDITOR_BOLD_BY_TAB.replace("${tab}",nameTabId)));
		Utils.pause(200);
	}
	/**
	 * Select all the text and click on bold button for Features
	 * 
	 */
	public void cke_Bold_Features() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_BOLD_FEATURES,5000,0)!=null) {
			info("Bold a text");
			WebElement el = driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT_FEATURES);
			el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			click(ELEMENT_CKEDITOR_BOLD_FEATURES);
		}
	}

	/**
	 * Select all the text and click on bold button for Benefits
	 * 
	 */
	public void cke_Bold_Benefits() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_BOLD_BENEFITS,5000,0)!=null) {
			info("Bold a text");
			WebElement el = driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT_BENEFITS);
			el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			click(ELEMENT_CKEDITOR_BOLD_BENEFITS);
		}
	}

	/**
	 * Italic the text of the content
	 * this function is used for the files has only one CKEditor tool
	 * 
	 */
	public void cke_Italic() {
		info("italic a text");
		click(ELEMENT_CKEDITOR_ITALIC);
		Utils.pause(2000);
	}
	/**
	 * Italic the text of the content 
	 * this function is used for the files has many CKEditor tool
	 * @param nameTabId is the name of ID tag of the tab
	 */
	public void cke_Italic(String nameTabId) {
		info("italic a text");
		click(By.cssSelector(ELEMENT_CKEDITOR_ITALIC_BY_TAB.replace("${tab}",nameTabId)));
		Utils.pause(2000);
	}

	/**
	 * Underline the text of the content
	 * this function is used for the files has only one CKEditor tool
	 * 
	 */
	public void cke_Underline() {
		info("Underline a text");
		click(ELEMENT_CKEDITOR_UNDERLINE);
		Utils.pause(2000);
	}

	/**
	 * Underline the text of the content
	 * this function is used for the files has many CKEditor tool
	 * @param nameTabId is the name of ID tag of the tab
	 */
	public void cke_Underline(String nameTabId) {
		info("Underline a text");
		click(By.cssSelector(ELEMENT_CKEDITOR_UNDERLINE_BY_TAB.replace("${tab}",nameTabId)));
		Utils.pause(2000);
	}

	/**
	 * Click on align left to put the text on the left side
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_AlignLeft() {
			info("Align left a text");
			click(ELEMENT_CKEDITOR_ALIGNLEFT);
			Utils.pause(1000);
	}
	
	
	/**
	 * Click on align left to put the text on the left side
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_AlignLeft(String nameTabId) {
			info("Align left a text");
			click(ELEMENT_CKEDITOR_ALIGNLEFT_BY_TAB.replace("${tab}",nameTabId));
			Utils.pause(1000);
	}

	/**
	 * Click on align right to put the text on the right side
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_AlignRight() {
			info("Align right a text");
			click(ELEMENT_CKEDITOR_ALIGNRIGHT);
			Utils.pause(1000);
	}
	
	/**
	 * Click on align right to put the text on the right side
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_AlignRight(String nameTabId) {
			info("Align right a text");
			click(ELEMENT_CKEDITOR_ALIGNRIGHT_BY_TAB.replace("${tab}",nameTabId));
			Utils.pause(1000);
	}

	/**
	 * Click on center button to put the text in the center
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_Center() {
			info("put a text in the center");
			click(ELEMENT_CKEDITOR_CENTER);
			Utils.pause(1000);
	}
	
	/**
	 * Click on center button to put the text in the center
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_Center(String nameTabId) {
			info("put a text in the center");
			click(ELEMENT_CKEDITOR_CENTER_BY_TAB.replace("${tab}",nameTabId));
			Utils.pause(1000);
	}
	/**
	 * Show blocks
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_showBlocks(){
		info("Show blocks");
		click(ELEMENT_CKEDITOR_SHOW_BLOCKS);
		Utils.pause(1000);
	}
	/**
	 * Anchor
	 * this function is used for the files that has only one CKEditor tool
	 * @param name
	 */
	public void cke_anchor(String name){
		info("Click on Anchor");
		click(ELEMENT_CKEDITOR_ANCHOR);
		type(ELEMENT_CKEDITOR_TYPE_ANCHOR, name, true);
		click(ELEMENT_CKEDITOR_DIALOG_OK_BTN);
		Utils.pause(1000);
	}
	
	/**
	 * Anchor
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 * @param name
	 */
	public void cke_anchor(String nameTabId,String name){
		info("Click on anchor");
		click(ELEMENT_CKEDITOR_ANCHOR_BY_TAB.replace("${tab}",nameTabId));
		type(ELEMENT_CKEDITOR_TYPE_ANCHOR, name, true);
		click(ELEMENT_CKEDITOR_DIALOG_OK_BTN);
		Utils.pause(1000);
		
	}

	/**
	 * Click on justify button
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_Justify() {
			info("justify a text");
			click(ELEMENT_CKEDITOR_JUSTIFY);
			Utils.pause(1000);
	}
	
	/**
	 * Click on justify button
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_Justify(String nameTabId) {
			info("justify a text");
			click(ELEMENT_CKEDITOR_JUSTIFY_BY_TAB.replace("${tab}",nameTabId));
			Utils.pause(1000);
	}

	/**
	 * Select all the text and click on Insert/remove numeric list
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_InsertRemoveNumList() {
			info("insert/remove number list of a text");
			click(ELEMENT_CKEDITOR_INSERT_REMOVE_NUMLIST);
			Utils.pause(1000);
	}
	
	/**
	 * Select all the text and click on Insert/remove numeric list
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_InsertRemoveNumList(String nameTabId) {
			info("insert/remove number list of a text");
			click(ELEMENT_CKEDITOR_INSERT_REMOVE_NUMLIST_BY_TAB.replace("${tab}",nameTabId));
			Utils.pause(1000);
	}

	/**
	 * Select all the text and click on Insert/remove bullet list
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_InsertRemoveBulletList() {
			info("insert/remove bullet list of a text");
			click(ELEMENT_CKEDITOR_INSERT_REMOVE_BULLETLIST);
			Utils.pause(1000);
	}
	
	/**
	 * Select all the text and click on Insert/remove bullet list
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_InsertRemoveBulletList(String nameTabId) {
			info("insert/remove bullet list of a text");
			click(ELEMENT_CKEDITOR_INSERT_REMOVE_BULLETLIST_BY_TAB.replace("${tab}",nameTabId));
			Utils.pause(1000);
	}

	/**
	 * Select all the text and click on Decrease indent button
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_DescrIndent() {
		info("decrease indent of a text");
		click(ELEMENT_CKEDITOR_DECREASE_INDENT);
		Utils.pause(1000);
	}
	/**
	 * Select all the text and click on Decrease indent button
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_DescrIndent(String nameTabId) {
		info("decrease indent of a text");
		click(ELEMENT_CKEDITOR_DECREASE_INDENT_BY_TAB.replace("${tab}",nameTabId));
		Utils.pause(1000);
	}

	/**
	 * Select all the text and click on Increase indent button
	 * this function is used for the files that has only one CKEditor tool
	 */
	public void cke_InscrIndent() {
		info("increase indent of a text");
		click(ELEMENT_CKEDITOR_INCREASE_INDENT);
		Utils.pause(1000);
	}
	/**
	 * Select all the text and click on Increase indent button
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_InscrIndent(String nameTabId) {
		info("increase indent of a text");
		click(ELEMENT_CKEDITOR_INCREASE_INDENT_BY_TAB.replace("${tab}",nameTabId));
		Utils.pause(1000);
	}

	/**
	 * Select all the text. Then click on Text Color button and select a color
	 * into the table
	 * @param codeColor get a code of a color into the color table
	 */
	public void cke_PaintColorText(String codeColor) {
			info("paint a text");
			click(ELEMENT_CKEDITOR_TEXT_COLOR);
			// select a color into the color table
			waitForAndGetElement(ELEMENT_CKEDITOR_TEXT_COLOR_STYLE);
			click(By.xpath(ELEMENT_CKEDITOR_TEXT_COLOR_STYLE.replace(
					"${codeColor}", codeColor)));
	}
	
	/**
	 * Select all the text. Then click on Text Color button and select a color
	 * into the table
	 * @param codeColor get a code of a color into the color table
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_PaintColorText(String nameTabId,String codeColor) {
			info("paint a text");
			Utils.pause(1000);
			click(ELEMENT_CKEDITOR_TEXT_COLOR_BY_TAB.replace("${tab}", nameTabId));
			WebElement e = waitForAndGetElement(ELEMENT_CKEDITOR_BACKGROUND_COLOR_FRAME ,DEFAULT_TIMEOUT,1,2);
			driver.switchTo().frame(e);
			driver.switchTo().activeElement();
			click(ELEMENT_CKEDITOR_TEXT_COLOR_STYLE.replace("${codeColor}",codeColor), 1);
			driver.switchTo().defaultContent();
			Utils.pause(1000);
	}
	/**
	 * Paint color for background of a text
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 * @param codeColor
	 */
	public void cke_PaintColorBackgroundText(String nameTabId,String codeColor){
		info("Paint color for background text");
		Utils.pause(1000);
		click(ELEMENT_CKEDITOR_BACKGROUND_COLOR_BY_TAB.replace("${tab}", nameTabId));
		info("Switch to the background color frame");
		WebElement e = waitForAndGetElement(ELEMENT_CKEDITOR_BACKGROUND_COLOR_FRAME ,DEFAULT_TIMEOUT,1,2);
		driver.switchTo().frame(e);
		driver.switchTo().activeElement();
		info("Select the color");
		click(ELEMENT_CKEDITOR_TEXT_COLOR_STYLE.replace("${codeColor}",codeColor), 1);
		driver.switchTo().defaultContent();
		Utils.pause(1000);
	}
	/**
	 * Insert a link
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 * @param url
	 */
	public void cke_link(String nameTabId,String url){
		info("Click on Link button");
		click(ELEMENT_CKEDITOR_INSERT_LINK_BY_TAB.replace("${tab}",nameTabId));
		type(ELEMENT_CKEDITOR_TYPE_LINK,url, false);
		Utils.pause(1000);
		switchToParentWindow();
		click(ELEMENT_CKEDITOR_DIALOG_OK_BTN);
		Utils.pause(2000);
	}
	/**
	 * Remove a link
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_removeLink(String nameTabId){
		info("Click on remove link button");
		click(ELEMENT_CKEDITOR_REMOVE_LINK_BY_TAB.replace("${tab}", nameTabId));
		Utils.pause(1000);
	}
	
	/**
	 * Remove Format 
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 */
	public void cke_removeFormat(String nameTabId){
		info("Remove format");
		click(ELEMENT_CKEDITOR_REMOVE_FORMAT_BY_TAB.replace("${tab}",nameTabId));
		Utils.pause(1000);
	}
	/**
	 * Select a paragraph format
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 * @param value
	 */
	public void cke_paragraphFormat(String nameTabId,String format){
		info("Click on drop down box");
		click(ELEMENT_CKEDITOR_PARAGRAHP_FORMAT_DROP_DOWN_BOX.replace("${tab}",nameTabId));
		WebElement f = waitForAndGetElement(ELEMENT_CKEDITOR_PARAGRAPH_FORMAT_FRAME,DEFAULT_TIMEOUT,1,2);
		driver.switchTo().frame(f);
		driver.switchTo().activeElement();
		click(ELEMENT_CKEDITOR_PARAGRAPH_FORMAT_SELECTION.replace("${title}",format));
		driver.switchTo().defaultContent();
		Utils.pause(1000);
	}
	/**
	 * Select a paragraph font
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 * @param font
	 */
	public void cke_paragraphFont(String nameTabId,String font){
		info("Click on drop down box");
		click(ELEMENT_CKEDITOR_PARAGRAPH_FONT_DROP_DOWN_BOX.replace("${tab}",nameTabId));
		WebElement f = waitForAndGetElement(ELEMENT_CKEDITOR_PARAGRAPH_FORMAT_FRAME,DEFAULT_TIMEOUT,1,2);
		driver.switchTo().frame(f);
		driver.switchTo().activeElement();
		click(ELEMENT_CKEDITOR_PARAGRAPH_FONT_SELECTION.replace("${font}",font));
		driver.switchTo().defaultContent();
		Utils.pause(1000);
	}
	
	/**
	 * Select a paragraph font
	 * this function is used for the files that has many CKEDitor tools
	 * @param nameTabId
	 * @param font
	 */
	public void cke_FontSize(String nameTabId,String fontSize){
		info("Click on drop down box");
		click(ELEMENT_CKEDITOR_PARAGRAPH_SIZE_DROP_DOWN_BOX.replace("${tab}",nameTabId));
		WebElement f = waitForAndGetElement(ELEMENT_CKEDITOR_PARAGRAPH_FORMAT_FRAME,DEFAULT_TIMEOUT,1,2);
		driver.switchTo().frame(f);
		driver.switchTo().activeElement();
		click(ELEMENT_CKEDITOR_PARAGRAPH_SIZE_SELECTION.replace("${fontSize}",fontSize));
		driver.switchTo().defaultContent();
		Utils.pause(1000);
	}

	/**
	 * Click on Block Quote button
	 */
	public void cke_BlockQuote() {
			info("block quote a text");
			click(ELEMENT_CKEDITOR_BLOCK_QUOTE);
	}

	/**
	 * Open the Source code tab Click on dropbox and select a language into the
	 * list
	 * @param nameLang the name of the language will be selected into the dropdown list
	 */
	public void cke_addUpdateCodeSourCode(String nameLang) {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_ADD_UPDATE_CODE,5000,0)!=null) {
			info("add a source code with source code tab");
			click(ELEMENT_CKEDITOR_ADD_UPDATE_CODE);
			// open the language list
			waitForAndGetElement(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_LANGUAGE_BOX);
			click(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_LANGUAGE_BOX);
			// select a languege into the list
			waitForAndGetElement(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_LANGUAGE_BOX);
			click(By.xpath(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_SOURCECODE_LANGUAGE_ITEM
					.replace("${nameLang}", nameLang)));
			click(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_OK_BUTTON);
		}

	}

	/**
	 * open Advance tab select the checkboxes
	 */
	public void cke_addUpdateCodeAdvance() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_ADD_UPDATE_CODE,5000,0)!=null) {
			info("add a source code with advance tab");
			click(ELEMENT_CKEDITOR_ADD_UPDATE_CODE);
			// open Advance tab
			waitForAndGetElement(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_ADVANCE_TAB);
			click(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_ADVANCE_TAB);
			// select the checkboxes
			// ...................
			click(ELEMENT_CKEDITOR_ADD_UPDATE_CODE_OK_BUTTON);
		}
	}

	/**
	 * Open the BB code help popup
	 */
	public void cke_BBCodeHelp() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_ADD_UPDATE_CODE,5000,0)!=null) {
			info("open BB code help");
			click(ELEMENT_CKEDITOR_HELP_BB_CODE);
		}
	}

	/**
	 * Resize the popup
	 * @param x 
	 * @param y
	 */
	public void cke_resize(int x, int y) {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_BUTTON_RESIZE,5000,0)!=null) {
			info(" click and hold Pan button");
			el = driver
					.findElement(ELEMENT_CKEDITOR_BUTTON_RESIZE);

			Actions builder = new Actions(driver);
			builder.clickAndHold(el).moveByOffset(x,y).build()
			.perform();
		}
	}

	/**
	 * Input a text into the content
	 * @param tex the text will be input into the content
	 */
	public void inputDataInContent(String tex) {
		info("Input data in the content section");
		if (waitForAndGetElement(ELEMENT_CKEDITOR_TEXT_CONTENT,5000,0)!=null) {
			if (tex != "" && tex != null) {
				if (waitForAndGetElement(
						mngTopic.ELEMENT_TOPIC_MESSAGE_FRAME_CKEDITOR, 5000, 0) != null)
					inputDataToFrame(
							mngTopic.ELEMENT_TOPIC_MESSAGE_FRAME_CKEDITOR, tex,
							false);
				else
					foruBas.inputDataToFrameInFrame(
							mngTopic.ELEMENT_TOPIC_MESSAGE_FRAME_1,
							mngTopic.ELEMENT_TOPIC_MESSAGE_FRAME_2, tex, true,
							false);
				switchToParentWindow();
			}
		}
	}

	/**
	 * Put the focus into the content
	 */
	public void focusDataInContent() {
		info("Input data in the content section");
		if (waitForAndGetElement(mngTopic.ELEMENT_TOPIC_MESSAGE_FRAME_CKEDITOR,
				5000, 0) != null)
			driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT).sendKeys(
					Keys.ARROW_LEFT);
		else
			driver.findElement(ELEMENT_CKEDITOR_TEXT_CONTENT).sendKeys(
					Keys.ARROW_LEFT);
		switchToParentWindow();
	}

	/**
	 * Close the popup with no any changes
	 */
	public void cancelPopup() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_BUTTON_CANCEL,5000,0)!=null) {
			click(ELEMENT_CKEDITOR_BUTTON_CANCEL);
		}
	}

	/**
	 * Open the popup under preview mode
	 */
	public void previewPopup() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_BUTTON_PREVIEW,5000,0)!=null) {
			click(ELEMENT_CKEDITOR_BUTTON_PREVIEW);
		}
	}

	/**
	 * Save all changes of the popup
	 */
	public void submitPopup() {
		if (waitForAndGetElement(ELEMENT_CKEDITOR_BUTTON_SUBMIT,5000,0)!=null) {
			click(ELEMENT_CKEDITOR_BUTTON_SUBMIT);
		}
	}

	/**
	 * Verify an element displays or not on the page
	 * @param locator  the locator of the element on the page
	 * */
	public boolean isElementPresent(By locator) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		return driver.findElements(locator).size() > 0;
	}

}
