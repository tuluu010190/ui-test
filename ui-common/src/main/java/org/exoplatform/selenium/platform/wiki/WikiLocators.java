package org.exoplatform.selenium.platform.wiki;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;

public class WikiLocators extends PlatformBase{

	//*====================================================HOME PAGE=================================================================*\\
	public final String ELEMENT_WIKI_PAGE_LINK = ".//*[@id='iconTreeExplorer']//*[contains(text(),'${pageTitle}')]";
	public final By ELEMENT_WIKI_HOME_PAGE_LINK = By.xpath(".//*[@id='UIWikiBreadCrumb']//*[contains(text(),'Wiki Home')]");
	public final By ELEMENT_WIKI_HOME_PAGE_TEXT = By.xpath("//*[@id='titleInfo' and text()='Wiki Home']");
	public final By ELEMENT_ADD_PAGE_LINK = By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']//div[contains(text(),'Add Page')]");
	public final By ELEMENT_FROM_TEMPLATE_LINK = By.xpath ("//i[@class='uiIconAddPageFromTemplate']");
	public final By ELEMENT_BLANK_PAGE_LINK = By.xpath ("//i[@class='uiIconAddPage']");
	public final By ELEMENT_WIKI_PAGE_TITLE_RENAME_FIELD = By.xpath(".//*[@id='EdiableInput']");
	
	public final String ELEMENT_WIKI_HOME_PAGE_TITLE = "//*[@id='titleInfo' and text()='${title}']";

	public final String ELEMENT_WIKI_PAGE_LEFTBOX = "//*[@id='iconTreeExplorer']//*[contains(text(),'${title}')]";
	public final By ELEMENT_EDIT_PAGE_LINK= By.xpath("//*[@class='uiIconEditPage uiIconLightGray']");
	public final By ELEMENT_WIKI_HOME_PAGENOTFOUND = By.xpath("//*[text()='Page Not Found']");
	public final By ELEMENT_WIKI_HOME_PAGE_LOCATION_MYWIKI = By.xpath("//*[@class='btn dropdown-toggle']//*[text()='My Wiki']");
	public final By ELEMENT_BTN_OK = By.xpath("//*[text()='OK']");
	public final By ELEMENT_UNWATCH_CONFIRM = By.xpath("//*[contains(text(),'You have stopped watching this page now.')]");
	public final By ELEMENT_WIKI_HOME_LEFTBOX_WIKIHOME = By.xpath("//*[text()=' Wiki Home']");
	
	//More menu
	public final By ELEMENT_MORE_LINK = By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']//div[contains(text(), 'More')]");
	public final By ELEMENT_DELETE_LINK = By.xpath(".//*[text()='Delete Page']");
	public final By ELEMENT_DELETE_LINK_2 = By.className("uiIconDeletePage");
	public final By ELEMENT_CONFIRM_WIKI_DELETE = By.xpath(".//*[@id='UIWikiDeletePageConfirm']//button[text()='OK']");
	public final By ELEMENT_MOVE_PAGE = By.xpath(".//*[text()='Move Page']");
	public final By ELEMENT_PAGE_INFO = By.xpath(".//*[text()='Page Info']");
	public final By ELEMENT_MOVE_LINK = By.xpath("//*[@class='uiIconMovePage']");
	public final By ELEMENT_WATCH_LINK = By.xpath("//*[@class='uiIconWatchPage']");
	public final By ELEMENT_UNWATCH_LINK = By.xpath("//*[@class='uiIconUnWatchPage']");
	public final By ELEMENT_PERMISSION_LINK = By.xpath("//*[@class='uiIconPagePermission']");
	public final By ELEMENT_PDF_LINK = By.xpath("//*[@class='uiIconExportAsPDF']");
	
	//Permalink page
	public final By ELEMENT_PERMALINK_LINK = By.xpath("//*[@class='uiIconPermalink']");
	public final By ELEMENT_PERMALINK_LINKCOPY = By.xpath("//*[@id='PermalinkText']");
	public final By ELEMENT_PERMALINK_MANAGEPERM = By.xpath("//*[text()='Manage Permissions']");
	public final By ELEMENT_PERMALINK_MAKEPUBLIC = By.xpath("//*[text()='Make Public']");
	public final By ELEMENT_PERMALINK_RESTRICT = By.xpath("//*[text()='Restrict']");
	public final String ELEMENT_PERMALINK_STATUS = ".//*[@id='UIWikiPermalinkForm']//*[text()='${status}']";
	public final By ELEMENT_PERMALINK_CLOSE=By.xpath(".//*[@id='UIWikiPopupWindowL1']//*[@class='uiIconClose pull-right']");
	
	//permission page
	public final By ELEMENT_PERMISSION_EDIT_ANY = By.xpath("//*[@id='EDITPAGEany']");
	public final String ELEMENT_PERMISSION_EDIT_USER = "//*[@id='EDITPAGE${user}']";
	public final By ELEMENT_PERMISSION_BUTTON_SAVE = By.xpath("//*[text()='Save']");
	public final By ELEMENT_PERMISSION_VIEW_ANY = By.xpath("//*[@id='VIEWPAGEany']");
	public final String ELEMENT_PERMISSION_REMOVE_USER_GROUP = ".//*[@id='UIPermissionGrid']//*[contains(text(),'${name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	
	//move wiki
	public final By ELEMENT_MOVE_SPACESWITCHER = By.xpath("//*[@id='uiSpaceSwitcher_UIWikiMovePageForm']/..//*[@class='btn dropdown-toggle']");
	public final By ELEMENT_MOVE_SPACESWITCHER_MYWIKI = By.xpath("//*[@class='uiIconWikiMyWiki uiIconWikiLightGray']");
	public final String ELEMENT_MOVE_SPACESWITCHER_OTHERSPACE = "//*[text()='${name}']";
	public final By ELEMENT_MOVE_BTNMOVE = By.xpath("//*[@class='btn btn-primary' and contains(text(),'Move')]");
	public final String ELEMENT_MOVE_SPACESWITCHER_OTHERPAGE = "//*[@id='UIMoveTree']/../..//*[contains(text(),'${title}')]";
	public final By ELEMENT_MOVE_RENAMEWIKI = By.xpath("//*[text()='Rename']");
	public final By ELEMENT_MOVE_RESTRICTED = By.xpath("//*[@class='warningIcon' and contains(text(),'You have no edit permission at the destination page')]");
	public final String ELEMENT_MOVE_PAGE_POPUP_DROP_DOWN_LOCATOR=".//*[@id='UIWikiPopupWindowL1']//*[contains(text(),'Move Page')]/../..//*[contains(text(),'${locator}')]";
	public final String ELEMENT_MOVE_PAGE_POPUP_ALERT_MESSAGE_SAME_NAME=".//*[@class='alert'][contains(.,'${message}')]";
	public final By ELEMENT_MOVE_PAGE_POPUP_ALERT_MESSAGE_RENAME=By.xpath(".//*[@class='alert']/a[text()='Rename']");

	public final By ELEMENT_PAGE_PERMISSIONS = By.xpath(".//*[text()='Page Permissions']");
	public final By ELEMENT_PERMALINK = By.xpath("//*[@id='UIWikiPageControlArea_PageToolBar']//*[text()='Permalink']");
	
	//Content of page
	public final String ELEMENT_MARCRO_COLOR = "//*[@style='color:${color};' and contains(text(),'${message}')]";
	public final By ELEMENT_PAGE_TITLE_INFO = By.id("titleInfo");
	public final String ELEMENT_PAGE_TITLE = ".//*[@id='titleInfo'][text()='${title}']";
	public final By ELEMENT_PAGE_TITLE_EDIT_TEXTBOX = By.id("EdiableInput");
	public final By ELEMENT_PAGE_ATTACHFILE = By.xpath("//*[contains(.,'1')]//*[@class='uiIconAttach']");
	public final By ELEMENT_PAGE_DOWNLOADATTACHFILE = By.xpath("//*[@data-original-title='Download Attachment']");
	public final By ELEMENT_PAGE_DELETEATTACHFILE = By.xpath("//*[@class='uiIconDelete uiIconLightGray']");
	
	public final By ELEMENT_SAVE_PERMISSION = By.xpath(".//*[@id='UIWikiPagePermissionForm']//*[contains(text(),'Save')]");
	public final By ELEMENT_ADD_PERMISSION = By.xpath("//*[@id='uiWikiPermissionOwner']//*[contains(text(),'Add')]");
	public final String ELEMENT_CHECK_PERMISSION_EDIT_PAGE =".//*[@id='UIPermissionGrid']/table//*[contains(text(),'{$name}')]/../..//*[@id='EDITPAGE{$name}']";
	public final String ELEMENT_REMOVE_PERMISSION = ".//*[@id='UIPermissionGrid']/table//*[contains(text(),'{$name}')]/../..//*[@class='uiIconDelete uiIconLightGray']";
	
	public final By ELEMENT_WIKI_PAGE_NOT_FOUND = By.xpath(".//*[@id='UIWikiPageArea']//*[contains(text(),'Page Not Found')]");
	
	//Action bar
	public final String ELEMENT_ATTACHMENT_NUMBER = "//*[@id='UIWikiPageInfoArea']//a[contains(text(),'${No}')]/*[@class='uiIconAttach']";
	public final By ELEMENT_ATTACHMENT_ICON = By.xpath("//*[@id='UIWikiPageInfoArea']//*[@class='uiIconAttach']");
	public final By ELEMENT_SEARCH_TEXTBOX = By.xpath("//*[@id='wikiSearchValue']");
	public final By ELEMENT_SEARCH_BTN = By.xpath(".//*[@id='UIWikiSearchBox']//*[@class='uiIconSearch uiIconLightGray']");
	
	//Browsers
	public final By ELEMENT_SEARCH_BROWSERS_DROPDOWN = By.xpath("//*[@class='uiActionWithLabel']/..//*[text()='Browse']");
	public final By ELEMENT_SEARCH_BROWSERS_WIKI_SETTINGS = By.xpath(".//*[@class='dropdown-menu']//*[text()='Wiki Settings']");
	public final By ELEMENT_SEARCH_BROWSERS_MY_DRAFT = By.xpath(".//*[@class='dropdown-menu']//*[text()='My Drafts']");
	
	//tree explorer
	public final String ELEMENT_TREE_WIKI_NAME = ".//*[@id='iconTreeExplorer']//*[contains(text(),'${name}')]";
	//Permission
	public final By ELEMENT_PERMISSION_NAMEORGROUP = By.xpath("//*[@id='PermissionOwner']");
	public final By ELEMENT_PERMISSION_BTNADD = By.xpath("//*[text()='Add']");

	//*===================================================================WIKI MANAGEMENT===========================================================*\\
	public final String ELEMENT_PAGE_INFOR_RECENT_CHANES = ".//*[contains(text(),'v.1')]/../..//*[contains(text(),'John Smith')]";
	public final String ELEMENT_PAGE_INFOR_HIERARCHY_CHILD_PAGES = ".//*[contains(text(),'Child Pages')]/..//*[contains(text(),'${child}')]";
	public final String ELEMENT_TITLE_INFO = "//*[@id='titleInfo' and text()= '${title}']";
	public final String ELMEENT_CONTENT_wiki_PAGE=".//*[@id='UIViewContentDisplay']//*[contains(text(),'$content')]";
	public final String ELEMENT_EMAIL_LINK_EMAIL_FORMAT=".//*[@id='UIViewContentDisplay']//*[contains(@href,'mailto:$email')]";
	
	//Source editor
	public final By ELEMENT_TITLE_WIKI_INPUT = By.id("titleInput");
	public final By ELEMENT_CONTENT_WIKI_INPUT = By.id("Markup");
	public final By ELEMENT_PUBLISH_ACTIVITY_CHECKBOX = By.id("PublishActivityUpper");
	public final By ELEMENT_PREVIEW_BUTTON = By.xpath("//*[@class='uiIconWatchPage']");
	public final By ELEMENT_PREVIEW_SCREEN = By.xpath("//div[@class='popupTitle' and text()='Preview']");
	public final By ELEMENT_WIKI_PAGE_TOOL_BAR_AUTO_SAVE_TEXT = By.xpath(".//*[@id='UIWikiPageEditForm']//*[contains(text(),'Draft saved')]");

	public final By ELEMENT_SAVE_BUTTON_ADD_PAGE = By.id("UISubmitToolBarUpper_SavePage_");
	public final By ELEMENT_CANCEL_BUTTON_ADD_PAGE = By.id("UISubmitToolBarBottom_Cancel_");

	public final By ELEMENT_RICHTEXT_BUTTON = By.xpath("//*[contains(text(),'Rich Text')]");

	public final By ELEMENT_UPLOAD_FILE_BUTTON=By.xpath("//*[text()='Upload New File']");
	public final By ELEMENT_UPLOAD_NAME = By.name("file");
	public final By ELEMENT_BODY_CONTAINER = By.xpath("//*[@class='uiRightContainerArea']");

	//Draft notification
	public By ELEMENT_DRAFT_NOTIFY = By.xpath("//*[contains(@class, 'uiWikiPageEditForm') and contains(text(), 'Draft saved at')]");

	//Comfirmation popup
	public By ELEMENT_CONFIRMATION_POPUP_YES_BTN = By.xpath(".//*[@id='UIPortalApplication']//button[text()='Yes']");
	public String ELEMENT_POPUP_MESSAGE_CONTENT = ".//*[contains(text(),'${message}')]";

	//Add page from template
	public final String ELEMENT_SELECT_TEMPLATE_LINK = ".//*[contains(text(),'${template}')]/../..//input";
	public final String ELEMENT_TEMPLATE_PREVIEW_BTN = ".//*[contains(text(),'${template}')]/../..//*[@class='uiIconPreview uiIconLightGray']";
	public final By ELEMENT_TEMPLATE_SELECT_FORM = By.id("UIWikiSelectTemplateForm");
	public final By ELEMENT_TEMPLATE_SELECT_BTN = By.xpath(".//*[@id='UIWikiSelectTemplateForm']//*[text()='Select']");
	public final By ELEMENT_TEMPLATE_CANCEL_BTN = By.xpath(".//*[@id='UIWikiSelectTemplateForm']//*[text()='Cancel']");
	//Preview page
	public final String ELEMENT_PREVIEW_TEMPLATE_CONTENT = "//*[@class='uiWikiPageTitlePreview' and contains(text(), '${template}')]";
	public By ELEMENT_CLOSE_PREVIEW_WINDOW=By.xpath("//div[text()='Preview']/..//*[contains(@class,'uiIconClose')]");
	public By ELEMENT_TEMPLATE_PREVIEW_PAGE_CLOSE_BTN = By.xpath(".//*[@id='UIWikiMaskWorkspace']//*[@class='uiIconClose uiIconLightGray']");

	//comment field
	public final By ELEMENT_WIKI_PAGE_INPUT_COMMENT = By.id("Comment");

	//Move page popup
	public final By ELEMENT_WIKI_PAGE_MOVE_POPUP_SAVE = By.xpath(".//*[@id='UIWikiMovePageForm']//button[contains(text(),'Move')]");
	public final String ELEMENT_WIKI_PAGE_MOVE_POPUP_NODE =".//*[@id='UIMoveTree']//*[contains(text(),'${name}')]";

	//Information table
	public final String ELEMENT_WIKI_PAGE_INFOMATION_VERSION= ".//*[@id='UIWikiPageInfoArea']//*[text()='${version}']";
	public final By ELEMENT_WIKI_PAGE_INFORMATION_TABLE_TITLE = By.xpath(".//*[@id='UIWikiPageVersionsList2']//*[text()='Page History']");
	public final String ELEMENT_WIKI_PAGE_INFORMATION_TABLE_CONTENT =".//a[text()='reversion']/../../..//td[contains(text(),'${text}')]";

	//Information area
	public final String ELEMENT_WIKI_PAGE_INFORMATION_AREA_EDIT_INFOR = ".//*[@id='UIWikiPageInfoArea']//*[contains(.,'${info}')]";
	public final String ELEMENT_WIKI_PAGE_INFORMATION_AREA_TOTAL_ATTACHEDFILES=".//*[@id='UIWikiPageInfoArea']//*[contains(text(),'${number}')]";
	public final String ELEMENT_WIKI_PAGE_INFORMATION_AREA_RESTRICTED_STATUS=".//*[@id='UIWikiPageInfoArea']//*[contains(text(),'${status}')]";

	//Page info
	public final String ELEMENT_WIKI_PAGE_PAGE_INFO_TITLE = ".//*[@id='UIWikiPageContainer']/h4[text()='Page Info']";
	public final By ELEMENT_PAGE_INFO_VIEW_PAGE_INFO_BTN = By.xpath(".//button[text()='View Page History']");
	public final String ELEMENT_PAGE_INFOR_SUMMARY_TITLE = ".//*[@id='UIWikiPageInfo']//*[contains(text(),'Title')]/../..//*[contains(text(),'${content}')]";
	public final String ELEMENT_PAGE_INFOR_SUMMARY_AUTHOR =".//*[@id='UIWikiPageInfo']//*[contains(text(),'Author')]/../..//*[contains(text(),'${fullname}')]/..//*[contains(text(),'${date}')]";
	public final String ELEMENT_PAGE_INFOR_SUMMARY_LAST_CHANGED = ".//*[@id='UIWikiPageInfo']//*[contains(text(),'Last changed by')]/../..//*[contains(text(),'${fullname}')]/..//*[contains(text(),'${date}')]";
	public final By ELEMENT_PAGE_INFOR_RELATED = By.xpath(".//*[@id='UIWikiPageInfo']//*[contains(text(),'Wiki')]/..//*[contains(text(),'Related Pages')]/..//*[contains(text(),'Actions')]");
	public final By ELEMENT_PAGE_INFO_ADD_MORE_RELATIONS = By.xpath(".//*[@id='UIWikiPageInfo']//button[text()='Add More Relations']");
	public final String ELEMENT_PAGE_INFO_RELATED_TABLE_CONTENT = ".//*[@id='UIWikiPageInfo']//*[contains(text(),'${col1}')]/..//*[contains(text(),'${col2}')]";
	public final String ELEMENT_PAGE_INFO_RELATED_TABLE_DELETE_BTN =".//*[contains(text(),'${name}')]/../../../../..//*[@class='uiIconDelete uiIconLightGray']";

	public final By ELEMENT_PAGE_INFOR_HIERARCHY_PARENT_PAGES = By.xpath(".//*[contains(text(),'Parent Page')]/..//*[contains(text(),'Wiki Home')]");

	//Page History
	public final By ELEMENT_WIKI_PAGE_PAGE_HISTORY_TITLE =By.xpath(".//h4[text()='Page History']");
	public final String ELEMENT_WIKI_PAGE_PAGE_HISTORY_CHECKBOX = ".//a[contains(text(),'${reversion}')]/../../..//input";
	public final By ELEMENT_WIKI_PAGE_PAGE_HISTORY_COMPARE_BTN = By.xpath(".//button[text()='Compare the selected versions']");

	//Compare reversion
	public final By ELEMENT_WIKI_PAGE_COMPARE_REVERSION_TITLE = By.xpath(".//h4[text()='Compare Revisions']");
	public final String ELEMENT_PAGE_HISTORY_COMPARE_CONTENT =".//*[@id='UIWikiPageVersionsCompare']//*[contains(text(),'${text}')]";
    public final By ELEMENT_COMPARE_VERSION_CURRENT_VERSION=By.xpath(".//*[@id='UIWikiPageVersionsCompare']//*[contains(text(),'Current version')]");
    public final String ELEMENT_COMPARE_VERSION_VERSION_NUMBER=".//*[@id='UIWikiPageVersionsCompare']//*[contains(text(),'Version $num')]";
    public final By ELEMENT_WIKI_PAGE_COMPARE_VERSION_TITLE = By.xpath(".//h4[text()='Compare Versions']");

	//Add more relations
	public final By ELEMENT_ADD_RELATED_PAGE_POPUP_TITLE = By.xpath(".//*[contains(text(),'Add Related Page')]");
	public final By ELEMENT_ADD_RELATED_PAGE_POPUP_DROPDOWN=By.xpath(".//*[contains(text(),'Add Related Page')]/../..//*[@data-toggle='dropdown']");
	public final String ELEMENT_ADD_RELATED_POPUP_DROPDOWN_LOCATION = ".//*[contains(text(),'Add Related Page')]/../..//*[contains(text(),'${location}')]";
	public final String ELEMENT_ADD_RELATED_POPUP_CONTENT = ".//*[contains(text(),'Add Related Page')]/../..//*[contains(text(),'${page}')]";
	public final By ELEMENT_ADD_RELATED_POPUP_SELECT_BTN = By.xpath(".//button[text()='Select']");
	public final By ELEMENT_ADD_RELATED_POPUP_CLOSE_BTN = By.xpath(".//*[contains(text(),'Add Related Page')]/..//*[@class='uiIconClose pull-right']");

	//Space swithcher drop down
	public final By ELEMENT_SPACE_SWITHCHER_DROPDOWN_CLOSE=By.xpath(".//*[@id='uiSpaceSwitcher_UIWikiSelectPageForm']/.//*[@title='Close']");
	public final By ELEMENT_ADD_RELATED_POPUP_DROPDOWN_NOSPACE = By.xpath(".//*[@id='UISpaceSwitcher_nospace'][text()='No Spaces']");


	//Content page
	public final String ELEMENT_WIKI_PAGE_CONTENT = ".//*[@id='UIViewContentDisplay']//*[contains(text(),'${text}')]";
	public final String ELEMENT_WIKI_PAGE_EDIT_PARAGRAPH_BTN= ".//*[@id='UIViewContentDisplay']//*[contains(text(),'${text}')]/../..//*[@class='uiIconEdit uiIconLightGray wikimodel-freestanding']";

	//Email notification
	public final By ELEMENT_GMAIL_PREVIOUS_EMAIL = By.xpath(".//*[@class='gE hI']");
	public final String ELEMENT_GMAIL_CONTENT_LINK_WIKI = ".//a[contains(@href,'${page}')]";
	public final String ELEMENT_GMAIL_CONTENT_WIKI = ".//span[contains(.,'\"${title}\" page was modified')]";
	//*==============================================================WIKI SEARCH MANAGEMENT===========================================================*\\
	//Search page
	public final String ELEMENT_SEARCH_RESULT = "//*[@class='uiIconFile']/..//*[contains(text(),'${title}')]";
	public final By ELEMENT_SEARCH_DROPDOWNSPACE = By.xpath("//*[@id='wikis']/..//*[@id='DisplayModesDropDown']");
	public final String ELEMENT_SEARCH_DROPDOWNSPACE_LOCATION = "//*[@title='${location}']";
	public final By ELEMENT_SEARCH_NORESULT = By.xpath("//*[@class='resultInfo noResult']");
	public final By ELEMENT_SEARCH_ADVANCED_SEARCH_BTN=By.xpath(".//*[@id='UIWikiAdvanceSearchForm']/button[text()='Search']");
	//*==============================================================WIKI SETTING MANAGEMENT ========================================================*\\
	public final By ELEMENT_TEMPLATE_SEARCH_TEXTBOX = By.xpath(".//*[@id='TemplateSeachBox']");
	public final By ELEMENT_WIKI_SETTINGS_TITLE = By.xpath(".//*[@id='UIWikiSettingContainer']/h4[text()='Wiki Settings']");
	public final String ELEMENT_WIKI_SETTINGS_RESULTS = ".//*[@id='UIWikiTemplateGrid']//*[text()='${template}']";
	public final String ELEMENT_EDIT_TEMPLATE = ".//*[@id='UIWikiTemplateGrid']//*[contains(text(),'{$template}')]/../..//*[@class='uiIconEditTemplate uiIconLightGray']";
	public final String ELEMENT_DELETE_TEMPLATE = "//*[@id='UIWikiTemplateGrid']//*[contains(text(),'{$template}')]/../..//*[@class='uiIconDeleteTemplate uiIconLightGray']";
	public final By ELEMENT_TITLE_TEMPLATE = By.id("titleInput");
	public final By ELEMENT_SAVE_TEMPLATE = By.id("UISubmitToolBarUpper_SaveTemplate_");
	//*==============================================================WIKI DRAFF PAGE===================================================================*\\
	//Manage Draft screen
	public String ELEMENT_DRAFT_OF_NEW_PAGE = "//*[@id='UIWikiDraftGrid']//*[contains(text(),'${title}')]";
	public String ELEMENT_DELETE_DRAFT = ".//*[@id='UIWikiDraftGrid']//*[contains(text(),'${title}')]/../../..//*[@class='uiIconDeleteDraft uiIconLightGray']";
	public String ELEMENT_DRAFT_OF_EDIT_PAGE = "//*[@id='UIWikiDraftGrid']//*[text()='${title}']";
	public By ELEMENT_DRAFT_CONFIRM_POPUP = By.xpath("//div[@class='confirmMessage' and contains(text(), 'The draft has been created. Do you want to keep it?')]");
	public By ELEMENT_DRAFT_NO_BUTTON = By.xpath("//*[contains(text(),'No')]");
	public String ELEMENT_DRAFT_TITLE = "//*[contains(text(), '${title}')]";
	
	//*===============================================================RICHTEXT EDITOR ====================================================================*\\
	//Richtext mode
	public final By ELEMENT_SOURCE_EDITOR_BUTTON= By.xpath("//*[contains(text(),'Source Editor')]");
	public final By ELEMENT_SOURCE_EDITOR_BUTTON_PLF4_1 = By.xpath("//button[contains(text(),'Source Editor')]");
	public final By ELEMENT_CONTENT_WIKI_FRAME = By.xpath("//div[@class='xRichTextEditor']/iframe");
	public final By ELEMENT_CONTENT_WIKI_IMG = By.xpath("//div[@id='UIViewContentDisplay']/../..//img");
	public final By ELEMENT_TWO_LAYOUT_RIGHT = By.xpath("//div[@style='float:left;width:49.2%;padding-right:1.5%;']");
	public final By ELEMENT_TWO_LAYOUT_LEFT = By.xpath("//div[@style='float:left;width:49.2%;']");
	public final By ELEMENT_THREE_LAYOUT_RIGHT = By.xpath("//div[@style='float:left;width:32.300000000000004%;padding-right:1.5%;'][1]");
	public final By ELEMENT_THREE_LAYOUT_MID = By.xpath("//div[@style='float:left;width:32.300000000000004%;padding-right:1.5%;'][2]");
	public final By ELEMENT_THREE_LAYOUT_LEFT = By.xpath("//div[@style='float:left;width:32.300000000000004%;']");
	public final String EMENENT_STATUS_LAYOUT = "//th[contains(text(), '${title}')]";
	public final String EMENENT_HOW_LAYOUT = "//a[contains(text(), '${title}')]";
	public final By EMENENT_LEAVE_PLANING_LAYOUT = By.xpath("//*[contains(text(), 'The Confluence team uses tables to communicate scheduled leave times')]"); 
    public final String ELEMENT_INSERTED_IMAGE_SIZE=".//*[@id='UIViewContentDisplay']//*[contains(@width,'$width')][contains(@height,'$height')]";
    public final String ELEMENT_INSERTED_IMAGE_ALT_TEXT=".//*[@id='UIViewContentDisplay']//*[contains(@alt,'$alt')]";
	//Macro
	public By ELEMENT_MACRO_LINK = By.xpath("//*[text()='Macro']");
	public By ELEMENT_INSERT_MACRO_LINK = By.xpath("//*[text()='Insert Macro...']");
	public By ELEMENT_MACRO_CATEGORY_SELECT = By.xpath("//select[@title='Select a macro category']");
	public By ELEMENT_MACRO_TYPE_FILTER = By.xpath("//input[@title='Type to filter']");
	public String ELEMENT_MACRO_LABEL = "//*[text()='${macro}']";
	public By ELEMENT_RICHTEXTMODE_FRAME = By.id("gwt-RichTextArea");
	public String ELEMENT_MACRO_BOX = "//div[@class='box']/*[contains(.,'${macro}')]";
	public String ELEMENT_MACRO_EXCERPT = "//*[@class='ExcerptClass' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_INFO_MESSAGE = "//*[@class='box infomessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_TABLE_CONTENT = "//span[@class='macro-placeholder' and contains(.,'toc')]";
	public String ELEMENT_MACRO_TIP_MESSAGE = "//*[@class='box tipmessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_ERROR_MESSAGE = "//*[@class='box errormessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_SUCCESS_MESSAGE = "//*[@class='box successmessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_TEXT = "//*[contains(@style,'${color}') and contains(text(),'${text}')]";
	public String ELEMENT_MACRO_WARNING_MESSAGE = "//*[@class='box warningmessage' and contains(text(),'${macro}')]";
	public String ELEMENT_MACRO_CHART = "//img[@alt='${title}']";
	public String ELEMENT_MACRO_FOOTNOTE = "//li[contains(.,'${macro}')]//a[text()='^']";
	public By ELEMENT_MACRO_RSS_TITLE = By.xpath("//p[@class='rssitemtitle']");
	public By ELEMENT_MACRO_COLLAPSE_LINK = By.xpath("//div[@class='gwt-MenuItemLabel' and text()='Collapse All']");
	public By ELEMENT_MACRO_EXPAND_LINK = By.xpath("//div[@class='gwt-MenuItemLabel' and text()='Expand All']");

	//Link menu
	public By ELEMENT_LINK = By.xpath("//*[text()='Link']");
	public By ELEMENT_WIKI_PAGE_LINK_MENU = By.xpath("//*[text()='Wiki Page...']");
	public By ELEMENT_WEB_PAGE_LINK_MENU = By.xpath("//*[text()='Web Page...']");
	public By ELEMENT_ATTACHED_FILE_LINK_MENU = By.xpath("//*[text()='Attached File...']");
	public By ELEMENT_EMAIL_LINK_MENU = By.xpath("//*[text()='Email Address...']");
	public By ELEMENT_EDIT_LINK_MENU = By.xpath("//*[text()='Edit Link...']");
	
	//Image menu
	public By ELEMENT_IMAGE_LINK = By.xpath("//*[text()='Image']");
	public By ELEMENT_ATTACHED_IMAGE_LINK_MENU = By.xpath("//*[text()='Attached Image...']");
	public By ELEMENT_EXTERNAL_IMAGE_LINK_MENU = By.xpath("//*[text()='External Image...']");
	public By ELEMENT_EDIT_IMAGE_LINK_MENU = By.xpath("//*[text()='Edit Image...']");
	public By ELEMENT_IMAGE_MENU_INSERT_IMAGE_BTN=By.xpath("//*[text()='Insert Image']");
	public By ELEMENT_IMAGE_MENU_IMAGE_SETTINGS_BTN=By.xpath("//*[text()='Image Settings']");
	
	//Image link popup
	public String ELEMENT_IMAGE_LINK_IMAGE_THUMBNAIL ="//*[contains(@title,'$image')]";
	public By ELEMENT_IMAGE_WIDTH = By.xpath("//div[contains(text(), 'Width')]/..//input[1]");
	public By ELEMENT_IMAGE_HEIGHT = By.xpath("//div[contains(text(), 'Height')]/..//input[2]");
	public By ELEMENT_IMAGE_ALTERNATIVE_TEXT = By.xpath("//div[contains(text(), 'Alternative text')]/..//input[1]");
	public By ELEMENT_IMAGE_ALIGN_LEFT=By.xpath(".//*[@value='LEFT']");
	public By ELEMENT_IMAGE_ALIGN_CENTER=By.xpath(".//*[@value='CENTER']");
	public By ELEMENT_IMAGE_ALIGN_RIGHT=By.xpath(".//*[@value='RIGHT']");
	public By ELEMENT_IMAGE_ALIGN_TOP=By.xpath(".//*[@value='TOP']");
	public By ELEMENT_IMAGE_ALIGN_MIDDLE=By.xpath(".//*[@value='MIDDLE']");
	public By ELEMENT_IMAGE_ALIGN_BOTTOM=By.xpath(".//*[@value='BOTTOM']");
	public By ELEMENT_EXTERNAL_IMAGE_INPUT_LINK=By.xpath("//*[@title='Image location']");
	

	//Add wiki page link popup
	public By ELEMENT_SEARCH_TEXTBOX_POPUP = By.xpath("//input[@title='Type a keyword to search for a wiki page']");
	public By ELEMENT_SEARCH_BUTTON = By.xpath("//button[text()='Search']");
	public String ELEMENT_PAGE_SELECTED = "//*[@class='xPagePreview' and @title='${page}']";
	public String ELEMENT_SEARCH_TAB_PAGE_SELECTED="//*[contains(@class,'xPagesSearch')]//*[@title='${page}']";
	public final By ELEMENT_SELECT_BUTTON = By.xpath("//*[text()='Select']");
	public final By ELEMENT_CREATE_LINK_BUTTON = By.xpath("//*[text()='Create Link']");
	public String ELEMENT_PAGE_SELECTED_PLF41 = "//*[@class='xPagesSelector xPagesSearch']//*[@class='xPagePreview' and @title='${page}']";
	public By ELEMENT_LABEL_LINK_TEXTBOX = By.xpath("//input[@title='Type the label of the created link.']");
	public By ELEMENT_TOOLTIP_LINK_TEXTBOX = By.xpath("//input[@title='Type the tooltip of the created link, which appears when mouse is over the link.']");
	public By ELEMENT_REMOVE_LINK = By.xpath("//div[text()='Remove Link']");
	public By ELEMENT_EDIT_LINK = By.xpath("//div[text()='Edit Link...']");
	public By ELEMENT_ADD_NEW_LINKPAGE_TEXTBOX =  By.xpath("//input[@title='Type the name of the page to be created. The final name of the page may vary since some characters are filtered.']");
	public By ELEMENT_ALL_PAGE_TAB = By.xpath("//div[contains(text(), 'All pages')]");
	public By ELEMENT_ADD_NEW_PAGE_LINK = By.xpath("//*[@class='gwt-Label xNewPagePreview']");
	public By ELEMENT_ADD_WIKI_PAGE_FRAME = By.xpath("//iframe[@class='gwt-RichTextArea']");
	public By ELEMENT_OPEN_NEW_WINDOW_CHECKBOX=By.xpath(".//*[contains(@class,'xLinkConfig')]//input[contains(@id,'gwt-uid')]");
    public By ELEMENT_MY_RECENT_CHANGES_TAB=By.xpath("//div[contains(text(), 'My recent changes')]");
    public By ELEMENT_SEARCH_TAB = By.xpath("//div[text()='Search']");
    public By ELEMENT_EXPLORER_WIKIHOME=By.xpath(".//*[contains(text(),'WikiHome')]/..//*[contains(@src,'opener_closed.gif')]");
    public String ELEMENT_ALL_PAGE_TAB_PAGE_SELECTED = ".//*[@class='listTable']//*[contains(text(),'$title')]";
    public String ELEMENT_MY_RECENT_CHANGES_TAB_PAGE_SELECTED=".//*[@class='xPagePreview']//*[text()='$title']";
    public By ELEMENT_MY_RECENT_CHANGES_TAB_ADD_NEW_PAGE_BTN=By.xpath("//*[contains(@class,'xPagesRecent')]//*[contains(@class,'xNewPagePreview')]");
    public By ELEMENT_SEARCH_TAB_ADD_NEW_PAGE_BTN=By.xpath("//*[contains(@class,'xPagesSearch')]//*[contains(@class,'xNewPagePreview')]");
    public By ELEMENT_ALL_PAGES_TAB_ADD_NEW_PAGE_BTN=By.xpath("//*[contains(@class,'listTable')]//*[contains(text(),'New page')]");
    public By ELEMENT_INPUT_NAME_NEW_WIKI_PAGE=By.xpath("//input[contains(@class,'gwt-TextBox')]");
    public By ELEMENT_WIKI_PAGE_LINK_LINK_SETTING_BTN=By.xpath("//button[contains(text(),'Link Settings')]");
    public String ELEMENT_CURRENT_TAB_ATTACHED_FILE_SELECTED="//*[contains(text(),'$file')]";
    
    //Web page link popup
    public By ELEMENT_WEB_PAGE_WEB_ADDRESS=By.xpath("//input[@title='Web page address']");
    
    //Email link popup
    public By ELEMENT_EMAIL_LINK_EMAIL_ADDRESS=By.xpath("//input[@title='Email address']");
    
    //Attached file link popup
    public By ELEMENT_CURRENT_PAGE_TAB = By.xpath("//div[contains(text(), 'Current page')]");
    public By ELEMENT_CURRENT_PAGE_TAB_UPLOAD_NEW_FILE_BTN=By.xpath("//*[contains(@class,'xNewFilePreview')]");
    public final By ELEMENT_CURRENT_PAGE_TAB_UPLOAD_NAME = By.name("filepath");
    public String ELEMENT_ALL_PAGE_SELECT_ATTACHEMENT_FILE_PAGE=".//*[@class='listTable']//*[contains(text(),'Attachments ($page)')]";
    
    
    //Image link popup
    public By ELEMENT_CURRENT_PAGE_TAB_UPLOAD_IMAGE_BTN=By.xpath("//*[contains(@class,'xNewImagePreview')]");
	//Table
	public By ELEMENT_TABLE_LINK = By.xpath("//*[text()='Table']");
	public By ELEMENT_INSERT_TABLE_LINK = By.xpath("//*[text()='Insert Table...']");
	public By ELEMENT_ROW_TEXTBOX = By.xpath("//*[@title='Row count']");
	public By ELEMENT_COLUMN_TEXTBOX = By.xpath("//*[@title='Column count']");
	
	//Macro: Color
	public By ELEMENT_COLOR_TEXTBOX = By.id("pd-name-input");
	public By ELEMENT_COLOR_MESSAGE = By.id("pd-content-input");
}
