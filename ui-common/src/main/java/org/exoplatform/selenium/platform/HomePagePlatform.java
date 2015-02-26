package org.exoplatform.selenium.platform;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.TestBase;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.answer.AnswerHomePage;
import org.exoplatform.selenium.platform.answer.FaqHomePage;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage;
import org.exoplatform.selenium.platform.forum.ForumHomePage;
import org.exoplatform.selenium.platform.social.SpaceManagement;
import org.exoplatform.selenium.platform.wiki.WikiHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePlatform extends TestBase{

	public final By ELEMENT_PLF_HOMEPAGE_DISPLAY = By.xpath("//*[@class='navItemSelected']//*[@href='/portal/intranet/home']");
	public final By ELEMENT_PLF_HOMEPAGE_ACTIVITY_PORTLET = By.xpath(".//*[@id='UIUserActivityStreamPortlet']//div[@class='uiUserActivitiesContainer']");
    public final By ELEMENT_PLF_HOMEPAGE_GADGET_PORTLET = By.xpath(".//*[@id='OfficeRightMiddle']");	
	//Left panel
	public final By ELEMENT_FORUM_LINK_PLF=By.xpath("//*[@data-original-title='Forums']");
	public final By ELEMENT_ANSWER_LINK_PLF=By.xpath("//*[@data-original-title='Answers']");
	public final By ELEMENT_WIKI_LINK_PLF=By.xpath("//*[@data-original-title='Wiki']");
	public final By ELEMENT_HOME_LINK_PLF=By.xpath("//*[@data-original-title='Home']");
	public final By ELEMENT_CALENDAR_LINK_PLF=By.xpath("//*[@data-original-title='Calendar']");
	public final By ELEMENT_CONNECTION_LINK_PLF =By.xpath("//*[@data-original-title='Connections']");

	public final By ELEMENT_CONNECTIONS_LINK_PLF=By.xpath("//*[@data-original-title='Connections']");
	public final By ELEMENT_SEARCH_SPACE = By.xpath("//*[@id='UISpaceNavigationPortlet']//*[@class='searchText LostFocus']");
	public final String ELEMENT_RESULT_SEARCH_SPACE = "//*[@id='UISpaceNavigationPortlet']//*[@class='spaceNavigation']//*[contains(text(),'{$space}')]";
	public final String ELEMENT_LEFT_PANEL = "//*[@class='uiCompanyNavigations']//*[contains(text(),'{$name}')]";
	public final String ELEMENT_SPECIFIC_PANEL = "//*[@id='UISpaceNavigationPortlet']//*[contains(text(),'{$space}')]";
	
	// right panel
	public final String ELEMENT_SUGGESTIONS_USER = "//*[@class='uiBox uiSuggestions']//*[contains(text(),'{$user}')]";
	public final String ELEMENT_SPACE_BYNAME = "//*[@data-original-title='${name}']";

	//Wiki activity
	public final String ELEMENT_WIKI_COMMENT_EDIT_TITLE = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'title has been updated to: ${title}')]";
	public final String ELEMENT_WIKI_COMMENT_EDIT_CONTENT = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'content has been edited')]";
	public final String ELEMENT_ACTIVITY_WIKI_TITLE = "//*[@class='linkTitle' and text()='${title}']";
	public final String ELEMENT_ACTIVITY_WIKI_CONTENT = "//*[@class='linkTitle' and text()='${title}']/../../..//*[@class='contentWiki theContent']/*[@class='text']";
	public final String ELEMENT_ACTIVITY_WIKI_VERSION = "//*[@class='linkTitle' and text()='${title}']/../..//*[@class = 'pull-right versionLabel' and contains(text(), 'Version: ${version}')]";
	public final String ELEMENT_ACTIVITY_MOVE_WIKI_PAGE = "//*[text()='${title}']/../../../..//*[@class='contentComment' and contains(text(), 'Page has been moved to: ${path}')]";
	public final By ELEMENT_MY_SPACE_LINK_PLF=By.xpath("//*[@id='UISpaceNavigationPortlet']//*[contains(text(),'My Spaces')]");
	public final By ELEMENT_ALL_SPACE_JOIN_LINK = By.xpath("//*[@id='UISpaceNavigationPortlet']//a[contains(.,'Join a space')]");
	public final String ELEMENT_SPECIFIC_SPACE_LINK_PLF ="//*[@id='UISpaceNavigationPortlet']//*[contains(text(),'{$space}')]";
	public final String ELEMENT_NUMBER_OF_SPACE_IN_LIST_LINK = "//*[@class='spaceNavigation']/li[{$number}]/a";
			
	
	//Middle homepage panel
	public final By ELEMENT_HOMPAGE_MIDDLE_PANEL = By.id("OfficeMiddle");
	
	//Site Explorer activities
	public final By ELEMENT_SITEMAPS_ACTIVITY = By.xpath(".//*[@data-original-title='sitemaps']/../../../..//div[@class='commentItem commentItemLast']//p[text()='File has been updated.']");
	

	//Tool bar
	public final By ELEMENT_TOOLBAR_ADMINISTRATION = By.xpath("//*[@class='uiIconPLF24x24Setup']");

	//Administration
	public final By ELEMENT_ADMINISTRATION_CONTENT = By.xpath("//*[text()='Content']");
	public final By ELEMENT_ADMINISTRATION_SITEEXPLORER = By.xpath("//*[text()='Sites Explorer']");

	// top panel
	//edit
	public final By ELEMENT_EDIT_PAGE = By.xpath("//*[@id='UIAdminToolbarContainer']//*[@class='dropdown-submenu']//*[@href='#' and contains(text(), 'Page')]");
	public final By ELEMENT_EDIT_PAGE_SEO = By.xpath("//*[@data-original-title = 'SEO Management']");
	public final By ELEMENT_EDIT_PAGE_EDITLAYOUT = By.xpath("//*[contains(text(), 'Edit Layout')]");
	
	// administration panel
	public final By ELEMENT_TOPBAR_ADMINISTRATION_BUTTON =By.xpath("//*[@class='uiIconPLF24x24Setup']");
	public final By ELEMENT_TOPBAR_CONTENT = By.xpath("//*[@id='UISetupPlatformToolBarPortlet']//a[contains(text(),'Content')]");
	public final By ELEMENT_CONTENT_TOPBAR_ADMINISTRATION = By.xpath("//*[@id='UISetupPlatformToolBarPortlet']//a[contains(text(),'Content Administration')]");
	public final By ELEMENT_CONTENT_TOPBAR_SITEEXPLORER = By.xpath("//*[@id='UISetupPlatformToolBarPortlet']//a[contains(text(),'Sites Explorer')]");
	public final By ELEMENT_TOPBAR_ADMINISTRATION_PORTAL = By.xpath("//*[@id='UISetupPlatformToolBarPortlet']//a[contains(text(),'Portal')]");
	public final By ELEMENT_PORTAL_TOPBAR_SITE = By.xpath("//*[@id='UISetupPlatformToolBarPortlet']//a[text()='Sites']");
	
	//User 
	public final By ELEMENT_TOPBAR_AVATAR = By.xpath("//*[@alt='avatar']");
	public final By ELEMENT_AVATAR_CHANGELANGUAGE = By.xpath("//*[@class='uiIconFlags']");
	public final String ELEMENT_CHANGELANGUAGE_LANGUAGE = "//*[text()='${language}']";
	public final String ELEMENT_AVATAR_CHANGELANGUAGE_APPLY = "//*[text()='${text}']";
	
	//Manage sites
	public final By ELEMENT_EDITNAVIG_ACME = By.xpath("//*[text()='acme']/../..//*[@class='uiIconNavigation uiIconLightGray']");
	public final By ELEMENT_EDITNAVIG_INTRANET = By.xpath("//*[text()='intranet']/../..//*[@class='uiIconNavigation uiIconLightGray']");
	public final String ELEMENT_EDITSITE_SITE = "//*[@title='${name}']"; 
	public final String ELEMENT_EDITSITE_SITESUPPRIMER = "//*[@class='uiIconDeleteNode']";
	
	// Edit panel
	public final By ELEMENT_EDIT_BUTTON = By.xpath(".//*[@id='UIAdminToolbarContainer']//*[@class='uiIconPLF24x24Edit']");
	public final By ELEMENT_EDIT_CONTENT = By.xpath("//*[@class='quickEditUnchecked']");
	public final By ELEMENT_EDIT_CONTENT_CHECK = By.xpath("//*[@class='quickEditChecked']");
	
	public final By ELEMENT_HP_ACTIVITY_TEXTBOX = By.xpath("//*[@id='DisplaycomposerInput']");
	public final By ELEMENT_SITE_TOP_LIST = By.xpath(".//*[@id='UIAdminToolbarContainer']/ul/li[3]/a");
	public final By ELEMENT_ADD_PAGE_DROP_LIST = By.xpath(".//*[@id='UIAdminToolbarContainer']/ul/li[3]/ul[@class='dropdown-menu']/li[4]/a");
	public final By ELEMENT_EDITSITE_SAVEBTN = By.xpath("//*[@class='btn' and text()='Save']");
	public final By ELEMENT_HP_ACTIVITY_SHAREBTN = By.xpath("//*[@id='ShareButton']");
	
	
	//SEO Management
	public final By ELEMENT_SEO_LANGUAGE_SHOW = By.xpath("//*[@onClick='eXo.ecm.WCMUtils.showSEOLanguage(true)']");
	public final By ELEMENT_SEO_LANGUAGE_SELECTBOX = By.xpath("//*[@name='language']");
	public final By ELEMENT_SEO_TITLEBOX = By.xpath("//*[@id='title']");
	public final By ELEMENT_SEO_DELETE = By.xpath("//*[@title='Delete']");
	public final By ELEMENT_SEO_HELPDESC = By.xpath("//*[text()='Description: ']/..//*[@id='DescriptionHelp']");
	public final By ELEMENT_SEO_HELPKEYWORD = By.xpath("//*[text()='Keywords: ']/..//*[@id='DescriptionHelp']");
	public final By ELEMENT_SEO_HELPPRIORITY = By.xpath("//*[@id='PriorityHelp']");

	//calendar gadget
	public final By ELEMENT_HP_CALENDARGADGET_BOX = By.xpath("//*[@class='calendarPortletData uiBox']");
	public final By ELEMENT_HP_CALENDARGADGET_RIGHTARROW = By.xpath("//*[@class='uiIconMiniArrowRight uiIconLightGray']");
	public final By ELEMENT_HP_CALENDARGADGET_LEFTARROW = By.xpath("//*[@class='uiIconMiniArrowLeft uiIconLightGray']");
	public final String ELEMENT_HP_CALENDARGADGET_DISPLAYEDDAY = "//*[contains(text(), '${day}')]";
	public final By ELEMENT_HP_CALENDARGADGET_SETTINGS = By.xpath("//*[@class='uiIconSetting uiIconLightGray']");
	public final By ELEMENT_HP_CALENDARGADGET_SETTINGS_DISPLAYEDCAL = By.xpath("//*[contains(text(),'Displayed Calendars')]");
	public final By ELEMENT_HP_CALENDARGADGET_SETTINGS_SETTINGSCAL = By.xpath("//*[contains(text(),'Displayed Calendars')]/../..//*[contains(text(),'Settings')]");
	public final String ELEMENT_HP_CALENDARGADGET_SETTINGS_REMOVECAL = "//*[@data-original-title='${title}']/..//*[@class='uiIconDel']";
	public final String ELEMENT_HP_CALENDARGADGET_SETTINGS_ADDCALNAME = "//*[text()='${title}']";
	public final By ELEMENT_HP_CALENDARGADGET_SETTINGS_ADDCAL = By.xpath("//*[@class='uiIconSimplePlusMini uiIconLightGray']");
	public final By ELEMENT_HP_CALENDARGADGET_SETTINGS_SEARCHCAL = By.xpath("//*[@class='PLFcalendarSearchKey']");

	//Getting Started
	public final By ELEMENT_HP_GETTINGSTARTED_BOX = By.xpath("//*[@class='UIGadgetThemes uiBox uiGettingStarted']");
	public final By ELEMENT_HP_GETTINGSTARTED_TITLE = By.xpath(".//*[@class='GettingStarted']//h6[text()='Getting Started']");
	public final String ELEMENT_HP_GETTINGSTARTED_TASKS=".//*[@class='GettingStarted']//*[contains(text(),'${name}')]";
	public final By ELEMENT_HP_GETTINGSTARTED_CONNETTOCOWORKERS = By.xpath("//*[text()='Connect to coworkers']");
	public final String ELEMENT_HP_GETTINGSTARTED_CONNETTOCOWORKERSBTN = "//*[text()='${name}']/../../..//*[text()='Connect']";
	public final By ELEMENT_HP_GETTINGSTARTED_ACCEPTTOCOWORKERSBTN = By.xpath("//*[text()='Confirm']");
	public final By ELEMENT_HP_GETTINGSTARTED_CONNETTOCOWORKERS_DONE = By.xpath("//*[@class='done']/..//*[text()='Connect to coworkers']");
	public final By ELEMENT_HP_GETTINGSTARTED_ADDPROFILEPIC = By.xpath("//*[text()='Add a profile picture']");
	public final By ELEMENT_HP_GETTINGSTARTED_JOINSPACE = By.xpath("//*[text()='Join a space']");
	public final By ELEMENT_HP_GETTINGSTARTED_UPLOADDOC = By.xpath("//*[text()='Upload a document']");
	public final By ELEMENT_HP_GETTINGSTARTED_POSTACTIVITY = By.xpath("//*[text()='Post an activity ']");

	public final By ELEMENT_HP_GETTINGSTARTED_PROFILEPAGE = By.xpath("//*[@class='uiIconAppprofile uiIconDefaultApp']");
	public final By ELEMENT_HP_GETTINGSTARTED_CONNECTIONPAGE = By.xpath("//*[@class='uiIconAppconnections uiIconDefaultApp']");
	public final By ELEMENT_HP_GETTINGSTARTED_CHECKJOINSPACE = By.xpath("//*[@class='active']//*[text()='All Spaces']");
	public final By ELEMENT_HP_GETTINGSTARTED_CHECKUPLOADDOC = By.xpath("//*[@id='UIJCRExplorerPortlet']");
	public final By ELEMENT_HP_GETTINGSTARTED_PROGRESSRATE = By.xpath("//*[@id='progress-rate']/../../../..//*[contains(text(), '100 %')]");
	public final By ELEMENT_HP_GETTINGSTARTED_CLOSEBOX = By.xpath("//*[@class='gadgetTitle title center']//*[@class='uiIconClose pull-right']");

	// Who's online gadget
	public final String ELEMENT_WHO_ONLINE_ICON_PEOPLE_NUMBER = "//*[@id='onlineList']/li[{$number}]/a";
	public final String ELEMENT_WHO_ONLINE_POP_UP_NAME = "//*[@id='tipName']//*[contains(text(),'{$name}')]";
	public final By ELEMENT_WHO_ONLINE_DEFAULT_AVATAR = By.xpath("//*[@id='tiptip_content']//*[@src='/eXoSkin/skin/images/system/UserAvtDefault.png']");
	public final By ELEMENT_WHO_ONLINE_CONNECT = By.xpath("//*[@id='tiptip_content']/div//*[contains(text(),'Connect')]");
	public final By ELEMENT_WHO_ONLINE_CANCEL_CONNECT = By.xpath("//*[@id='tiptip_content']/div//*[contains(text(),'Cancel Request')]");
	
	// invitation gadget
    public final String ELEMENT_INVITATIONS_NAME_OF_PEOPLE_WHO_SEND_REQUEST = "//*[@id='InvitationsPortlet']//*[@class='peopleInviteName']//*[contains(text(),'${name}')]";
	public final String ELEMENT_INVITATIONS_PEOPLE_AVATAR = ".//*[contains(text(),'${name}')]/../../../..//*[@class='peopleInvitePicture pull-left avatarXSmall']";
	public final String ELEMENT_INVITAITONS_SPACE_ICON = ".//*[contains(text(),'${name}')]/../..//*[@class='spaceInvitePicture pull-left avatarXSmall']";
	public final String ELEMENT_INVITAITONS_SPACE_STATUS_MEMBERS=".//*[contains(text(),'${name}')]/..//*[contains(text(),'${statusMember}')]";
	public final String ELEMENT_INVITATIONS_PEOPLE_ACCEPT_BTN = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteInfo']//a[text()='${name}']/../..//a[contains(text(),'Accept')]";
	public final String ELEMENT_INVITATIONS_PEOPLE_REFUSE_BTN = "//div[@id='InvitationsPortlet']//div[@class='peopleInviteInfo']//a[text()='${name}']/../..//i[@class='uiIconClose']";
	public final By ELEMENT_INVITATIONS_GADGET = By.id("InvitationsPortlet");
	public final String ELEMENT_INVITATIONS_NUMBER= "//*[@id='InvitationsPortlet']//*[contains(text(),'${number}')]";
	
	// suggestion gadget
	public final By ELEMENT_SUGGESTION_BOX = By.xpath(".//*[@class='uiBox uiSuggestions']");
	public final String ELEMENT_SUGGESTION_NAME ="//*[@id='peopleSuggest']//*[contains(text(),'${name}')]";
	public final String ELEMENT_SUGGESTION_PEOPLE_CANCEL_BTN ="	//*[@id='peopleSuggest']//*[contains(text(),'${name}')]/../..//*[@class='uiIconClose']";
	public final String ELEMENT_SUGGESTION_PEOPLE_CONNECT_BTN ="//*[@id='peopleSuggest']//*[contains(text(),'${name}')]/../..//a[contains(text(),'Connect')]";
	public final String ELEMENT_SUGGESTION_SPACE ="//*[@id='spaceSuggest']//*[contains(text(),'${space}')]";
	public final String ELEMENT_SUGGESTION_SPACE_REQUEST_BTN ="//*[@id='spaceSuggest']//*[contains(text(),'${space}')]/..//*[contains(text(),'Request')]";
	public final String ELEMENT_SUGGESTION_SPACE_CANCEL_BTN ="//*[@id='spaceSuggest']//*[contains(text(),'${space}')]/..//i[@class='uiIconClose']";
	
	WikiHomePage wHome;
	CalendarHomePage cHome;
	SpaceManagement sMang;
	AnswerHomePage aHome;
	ForumHomePage fHome;
	FaqHomePage fqHome;
	ConnectionsManagement connMg;
	/**
	 * constructor
	 * @param dr
	 */
	public HomePagePlatform(WebDriver dr){
		this.driver=dr;
		wHome = new WikiHomePage(dr);
		cHome = new CalendarHomePage(dr);
		sMang = new SpaceManagement(dr);
		aHome = new AnswerHomePage(dr);
		fHome = new ForumHomePage(dr);
		fqHome = new FaqHomePage(dr);
		connMg = new ConnectionsManagement(dr);
	}

	/**
	 * Go to Wiki portlet
	 */
	public void goToWiki(){
		info("--Go to Wiki--");
		click(ELEMENT_WIKI_LINK_PLF);
		Utils.pause(2000);
	}

	/**
	 * Go to Home page
	 */
	public void goToHomePage(){
		info("--Go to Home page--");
		info("Click on Home link of intranet page");
		click(ELEMENT_HOME_LINK_PLF);
		info("Verify that the home page of intranet is shown");
		waitForAndGetElement(ELEMENT_HOMPAGE_MIDDLE_PANEL);
		info("the intranet is shown sucessfully"); 
	}

	/**
	 * Go to Home Calendar Page
	 */
	public void goToCalendarPage(){
		info("-- Go to calendar home page --");
		info("click on Calendar link");
		click(ELEMENT_CALENDAR_LINK_PLF);
		info("Verify that Calendar page is shown");
		waitForAndGetElement(cHome.ELEMENT_CALENDAR_WORKING_PANEL);
		info("The calendar page is shown successfully");
	}


	/**
	 * Go to my spaces
	 */
	public void goToMySpaces(){
		info("-- Go to my spaces --");
		click(ELEMENT_MY_SPACE_LINK_PLF);
		Utils.pause(2000);
	}
	/**
	 * Go to All space list
	 */
	public void goToAllSpace(){
		info("Click on Join a space link");
		click(ELEMENT_ALL_SPACE_JOIN_LINK);
		Utils.pause(2000);
	}

	/**
	 * Go to answer page
	 */
	public void goToAnswer(){
		info("-- Go to answer page --");
		click(ELEMENT_ANSWER_LINK_PLF);
		waitForAndGetElement(aHome.ELEMENT_ANSWER_PORTLET);
	}

	/**
	 * Go to forum page
	 */
	public void goToForum(){
		info("-- Go to forum page --");
		info("Click on Forum link");
		click(ELEMENT_FORUM_LINK_PLF);
		info("Verify that the forum portlet is shown");
		waitForAndGetElement(fHome.ELEMENT_FORUM_PORTLET);
		info("The forum portlet is shown successfully");
	}

	/**
	 * Go to faq page
	 */
	public void goToFaq(){
		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
		info("Base url is " + baseUrl);
		String url = baseUrl + "/intranet/home/FAQ";
		info("-- Go to FAQ page --");
		driver.get(url);
		waitForAndGetElement(fqHome.ELEMENT_FAQ_QUESTION_LIST);
	}
	/**
	 * Open Connections page
	 */
	public void goToConnections(){
		info("--Go to Connections page---");
		info("Click on Connection link");
		click(ELEMENT_CONNECTIONS_LINK_PLF);
		info("Verify that the connections portlet is shown");
		waitForAndGetElement(connMg.ELEMENT_CONNECTION_EVERYONE_TITLE,2000,0);
		info("The connections portlet is shown successfully");
	}
	
	/**
	 * Go to connexion
	 */
	public void goToConnection() {
		info("-- Go to connexion page --");
		info("Click on connexion link");
		click(ELEMENT_CONNECTION_LINK_PLF);
	}
   
	public void goToSpecificSpace(String space){
		info("Go to space "+space);
		click(By.xpath(ELEMENT_SPECIFIC_PANEL.replace("{$space}",space)));
	}
}

