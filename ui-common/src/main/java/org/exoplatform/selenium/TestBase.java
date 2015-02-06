package org.exoplatform.selenium;

import static org.exoplatform.selenium.TestLogger.debug;
import static org.exoplatform.selenium.TestLogger.info;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestBase {

	public WebDriver driver;
	public WebDriver newDriver;
	public static String baseUrl;
	protected int DEFAULT_TIMEOUT = 30000; //milliseconds = 30 seconds
	protected int WAIT_INTERVAL = 1000; //milliseconds  
	public int loopCount = 0;	
	protected boolean ieFlag;	 
	protected boolean chromeFlag;

	protected String plfVersion = "";
	public final int ACTION_REPEAT = 5;
	public static boolean firstTimeLogin = false;
	public Actions action;

	/*========System Property====================*/
	protected Boolean isRandom;
	protected Boolean isUseFile;

	protected String jdbcDriver;
	protected String dbUrl;
	protected String user;
	protected String pass;

	protected String sqlWiki;
	protected String sqlAttach;
	protected String sqlUser;
	protected String sqlContent;

	protected String defaultSheet;

	protected String userDataFilePath;
	protected String wikiRichTextFilePath;
	protected String attachmentFilePath;
	protected String texboxFilePath;
	protected String changLangDataPath;
	protected String wikiTemplateFilePath;
	protected String spaceVisibleFilePath;
	protected String spaceRegistrationFilePath;
	protected String groupsCalenderFilePath;
	protected String remoteGadgetDataFilePath;
	protected String appGateinDataFilePath;
	protected String getStartFilePath;

	/*========Default System Property=============*/
	public final String DEFAULT_BASEURL="http://localhost:8080/portal";

	public final  Boolean DEFAULT_ISRANDOM = true;
	public final  Boolean DEFAULT_ISUSEFILE = true;

	public final  String DEFAULT_JDBCDRIVER = "com.mysql.jdbc.Driver";
	public final  String DEFAULT_DBURL = "jdbc:mysql://localhost:3306/selenium";
	public final  String DEFAULT_USERMYSQL = "root";
	public final  String DEFAULT_USERPASS = "exo";

	public final  String DEFAULT_SQLWIKI = "select * from wiki order by id asc";
	public final  String DEFAULT_SQLATTACHMENT = "select * from space order by id asc";
	public final  String DEFAULT_SQLUSER = "select type,username,password,email from user order by id asc";
	public final  String DEFAULT_SQLCONTENT = "select * from textbox order by id asc";

	public final String DEFAULT_SHEET="sheet1";
	public final String DEFAULT_USERFILEURL="DataDriven/" + "user.xls";
	public final String DEFAULT_ATTACHMENTFILEURL="DataDriven/" + "attachment_file.xls";
	public final String DEFAULT_TEXTBOXFILEURL="DataDriven/" + "textbox.xls";
	public final String DEFAULT_WIKITEMPLATEFILEURL="DataDriven/" + "wiki_template.xls";
	public final String DEFAULT_SPACEVISIBLEFILEURL="DataDriven/" + "space_visibility.xls";
	public final String DEFAULT_SPACEREGISTRATIONFILEURL="DataDriven/" + "space_registration.xls";
	public final String DEFAULT_WIKIRICHTEXTFILEURL="DataDriven/" + "wiki_richtext.xls";
	public final String DEFAULT_CHANGELANGUADATAURL="DataDriven/" + "ChangeLanguage.xls";
	public final String DEFAULT_REMOTEGADGETURL="DataDriven/"+"remote_gadget_links.xls";
	public final String DEFAULT_APPGATEINURL="DataDriven/"+"application_gatein.xls";
	public final String DEFAULT_GETTINGSTARTEDURL="DataDriven/"+"getting_started.xls";

	/*======= Welcome Screen (Term and Conditions) =====*/
	public final By ELEMENT_FIRSTNAME_ACCOUNT = By.name("firstNameAccount");
	public final By ELEMENT_LASTNAME_ACCOUNT = By.name("lastNameAccount");
	public final By ELEMENT_EMAIL_ACCOUNT = By.name("emailAccount");
	public final By ELEMENT_CONFIRM_PASS_ACCOUNT = By.name("confirmUserPasswordAccount");
	public final By ELEMENT_ROOT_PASS_ACCOUNT = By.name("adminPassword");
	public final By ELEMENT_ROOT_CONFIRM_PASS_ACCOUNT = By.name("confirmAdminPassword");
	public final By ELEMENT_AGREEMENT_CHECKBOX = By.xpath("//*[@id = 'agreement']");
	public final By ELEMENT_INPUT_USERNAME = By.name("username"); 
	public final By ELEMENT_CONTINUE_BUTTON = By.xpath("//button[text()='Continue' and @class='btn active']");
	public final By ELEMENT_START_BUTTON = By.xpath("//button[text()='Start']");
	public final By ELEMENT_SUBMIT_BUTTON = By.xpath("//*[text()='Submit']");
	public final By ELEMENT_INPUT_PASSWORD = By.name("password");
	public final By ELEMENT_ACCOUNT_NAME_LINK = By.xpath("//*[@id='UIUserPlatformToolBarPortlet']/a/img");
	public final By ELEMENT_PLF_INFORMATION = By.id("platformInfoDiv");

	public final String ELEMENT_TERM_CONDITION_BOX = "//div[@class='header' and text()='Terms and Conditions Agreement']/..";
	public final By ELEMENT_CONTINUE_BUTTON_DISABLE = By.xpath("//button[text()='Continue' and @class='btn inactive']");
	public final By ELEMENT_TERM_CONDITION_CONTENT = By.xpath("//div[@id='AccountSetup' and @class='content']");

	public final By ELEMENT_ACCOUNT_SETUP = By.xpath("//div[@class='header' and text()='Account Setup']");
	public final By ELEMENT_USER_ADMIN = By.id("adminFirstName");
	public final By ELEMENT_SKIP_BUTTON = By.xpath("//button[text()='Skip']");
	public final By ELEMENT_YOUR_ACCOUNT_LABEL = By.xpath("//h5[contains(text(), 'Create your account')]");
	public final By ELEMENT_ADMIN_PASS_LABEL = By.xpath("//h5[contains(text(), 'Admin Password')]");
	public final By ELEMENT_ACCOUNT_ERROR = By.xpath("//*[@class='accountSetupError']");

	//Upload file popup
	public final By ELEMENT_UPLOAD_POPUP_FILE = By.xpath("//span[@class='PopupTitle popupTitle' and text()='Attach File']");
	public final By ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_INPUT = By.name("file");
	public final By ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_SAVE_BUTTON = By.xpath(".//*[@id='UIAttachFileForm']//button[text()='Save']");
	public final String ELEMENT_UPLOAD_POPUP_NAMEFILE = "//*[@class='fileNameLabel' and contains(text(),'${fileName}')]";
	
	public final By ELEMENT_SAVE_BTN = By.xpath("//*[text()='Save']");
	/*======== End of Term and conditions =====*/	
	/**
	 * Get System Property
	 */
	public void getSystemProperty(){
		baseUrl = System.getProperty("baseUrl");

		jdbcDriver = System.getProperty("jdbcDriver");
		dbUrl = System.getProperty("dbUrl");
		user = System.getProperty("user");
		pass = System.getProperty("pass");
		sqlWiki = System.getProperty("sqlWiki");
		sqlAttach = System.getProperty("sqlAttach");
		sqlUser = System.getProperty("sqlUser");

		defaultSheet = System.getProperty("defaultSheet");

		userDataFilePath = System.getProperty("userDataFilePath");
		wikiRichTextFilePath = System.getProperty("wikiRichTextFilePath");
		attachmentFilePath = System.getProperty("attachmentFilePath");
		texboxFilePath = System.getProperty("texboxFilePath");
		wikiTemplateFilePath = System.getProperty("wikiTemplateFilePath");
		spaceVisibleFilePath = System.getProperty("spaceVisibleFilePath");
		spaceRegistrationFilePath = System.getProperty("spaceRegistrationFilePath");
        changLangDataPath = System.getProperty("changLangDataPath");
        remoteGadgetDataFilePath = System.getProperty("remoteGadgetDataFilePath");
        appGateinDataFilePath = System.getProperty("appGateinDataFilePath");
        getStartFilePath = System.getProperty("getStartFilePath");

		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;

		if (isRandom==null) isRandom = DEFAULT_ISRANDOM;
		if (isUseFile==null) isUseFile = DEFAULT_ISUSEFILE;

		if (jdbcDriver==null) jdbcDriver = DEFAULT_JDBCDRIVER;
		if (dbUrl==null) dbUrl = DEFAULT_DBURL;
		if (user==null) user = DEFAULT_USERMYSQL;
		if (pass==null) pass = DEFAULT_USERPASS;

		if (sqlWiki==null) sqlWiki = DEFAULT_SQLWIKI;
		if (sqlAttach==null) sqlAttach = DEFAULT_SQLATTACHMENT;
		if (sqlUser==null) sqlUser = DEFAULT_SQLUSER;
		if (sqlContent==null) sqlContent = DEFAULT_SQLCONTENT;

		if (defaultSheet==null) defaultSheet = DEFAULT_SHEET;

		if (userDataFilePath==null) userDataFilePath = DEFAULT_USERFILEURL;
		if (wikiRichTextFilePath==null) wikiRichTextFilePath = DEFAULT_WIKIRICHTEXTFILEURL;
		if (attachmentFilePath==null) attachmentFilePath = DEFAULT_ATTACHMENTFILEURL;
		if (wikiTemplateFilePath==null) wikiTemplateFilePath = DEFAULT_WIKITEMPLATEFILEURL;
		if (texboxFilePath==null) texboxFilePath = DEFAULT_TEXTBOXFILEURL;
		if (spaceVisibleFilePath==null) spaceVisibleFilePath = DEFAULT_SPACEVISIBLEFILEURL;
		if (spaceRegistrationFilePath==null) spaceRegistrationFilePath = DEFAULT_SPACEREGISTRATIONFILEURL;
	    if (changLangDataPath==null) changLangDataPath = DEFAULT_CHANGELANGUADATAURL;
	    if (remoteGadgetDataFilePath==null) remoteGadgetDataFilePath = DEFAULT_REMOTEGADGETURL;
	    if (appGateinDataFilePath==null) appGateinDataFilePath = DEFAULT_APPGATEINURL;
	    if (getStartFilePath==null) getStartFilePath = DEFAULT_GETTINGSTARTEDURL;
	}
	

	public void initSeleniumTestWithOutTermAndCondition(Object... opParams){
		String browser = System.getProperty("browser");
		if("chrome".equals(browser)){
			driver = new ChromeDriver();
			chromeFlag = true;
		} else if ("iexplorer".equals(browser)){
			driver = new InternetExplorerDriver();
			ieFlag = true;
		} else {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("plugins.hide_infobar_for_missing_plugin", true);
			profile.setPreference("dom.max_script_run_time", 0);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new FirefoxDriver();
		}
		getSystemProperty();
		action = new Actions(driver);
	}

	/**
	 * Check term and conditions
	 * 
	 */
	public void termsAndConditions(Object... opParams){
		info("Term and conditions");
		Boolean isCreateAccount = (Boolean)(opParams.length>0 ? opParams[0]:true);
		driver.get(baseUrl);
		ManageLogInOut acc = new ManageLogInOut(driver);
		info("Agreement page");
		if (waitForAndGetElement(ELEMENT_AGREEMENT_CHECKBOX, 3000, 0, 2) != null) {
			info("-- Checking the terms and conditions agreement... --");
			click(ELEMENT_AGREEMENT_CHECKBOX, 2);
			click(ELEMENT_CONTINUE_BUTTON);
			waitForTextNotPresent("terms and conditions agreement");
			info("-- Creating an Admin account: FQA... --");
			if(isCreateAccount==true){
				accountSetup();
				info("-- Administrator account (FQA) has been created successfully... --");
				driver.navigate().refresh();
				acc.signOut();
			}
		}else if (waitForAndGetElement(ELEMENT_ROOT_PASS_ACCOUNT, 3000, 0, 2) != null){
			info("-- Creating an Admin account: FQA... --");
			accountSetup();
			info("-- Administrator account (FQA) has been created successfully... --");
			driver.navigate().refresh();
			acc.signOut();
		} 
		Utils.pause(3000);   
		info("End of term and conditions");
	}

	/**
	 * Create new first account
	 */
	public void accountSetupWithoutGreeting(){
		type(ELEMENT_INPUT_USERNAME, "fqa", true);
		type(ELEMENT_FIRSTNAME_ACCOUNT, "FQA", true);
		type(ELEMENT_LASTNAME_ACCOUNT, "VN", true);
		type(ELEMENT_EMAIL_ACCOUNT, "fqa@exoplatform.com", true);	
		type(ELEMENT_INPUT_PASSWORD, "gtngtn", true);
		type(ELEMENT_CONFIRM_PASS_ACCOUNT, "gtngtn", true);	
		type(ELEMENT_ROOT_PASS_ACCOUNT, "gtngtn", true);
		type(ELEMENT_ROOT_CONFIRM_PASS_ACCOUNT, "gtngtn", true);
		click(ELEMENT_SUBMIT_BUTTON);
		waitForTextNotPresent("Create your account");
	}

	/**
	 * Account setup
	 */
	public void accountSetup(){
		accountSetupWithoutGreeting();
		click(ELEMENT_START_BUTTON);
		waitForAndGetElement(ELEMENT_ACCOUNT_NAME_LINK);
	}

	public void initSeleniumTest(Object... opParams){
		initSeleniumTestWithOutTermAndCondition();
		driver.manage().window().maximize();
		driver.navigate().refresh();
		termsAndConditions(opParams);
	}

	/** function: set driver to auto save file to TestData/TestOutput

	 */
	public void getDriverAutoSave(){
		String pathFile = System.getProperty("user.dir") + "/src/main/resources/TestData/TestOutput";

		FirefoxProfile fp = new FirefoxProfile();	

		info("Save file to " + pathFile);
		fp.setPreference("browser.download.manager.showWhenStarting", false);
		fp.setPreference("browser.download.dir", pathFile);
		fp.setPreference("browser.download.folderList", 2);
		fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-xpinstall;" +
				"application/x-zip;application/x-zip-compressed;application/x-winzip;application/zip;" +
				"gzip/document;multipart/x-zip;application/x-gunzip;application/x-gzip;application/x-gzip-compressed;" +
				"application/x-bzip;application/gzipped;application/gzip-compressed;application/gzip" +
				"application/octet-stream" +
				";application/pdf;application/msword;text/plain;" +
				"application/octet;text/calendar;text/x-vcalendar;text/Calendar;" +
				"text/x-vCalendar;image/jpeg;image/jpg;image/jp_;application/jpg;" +
				"application/x-jpg;image/pjpeg;image/pipeg;image/vnd.swiftview-jpeg;image/x-xbitmap;image/png;application/xml;text/xml;text/icalendar;");

		fp.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
		fp.setPreference("pref.downloads.disable_button.edit_actions", true);
		fp.setPreference("pdfjs.disabled", true); 
		fp.setPreference("browser.helperApps.alwaysAsk.force", false);
		driver = new FirefoxDriver(fp);
		getSystemProperty();
		action = new Actions(driver);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		termsAndConditions();
	}

	/**
	 * Get element
	 * @param locator
	 * @param opParams
	 * @return an element
	 */
	public WebElement getElement(Object locator, Object... opParams) {
		By by = locator instanceof By ? (By)locator : By.xpath(locator.toString());
		WebDriver wDriver = (WebDriver) (opParams.length > 0 ? opParams[0]: driver);	
		WebElement elem = null;
		try {
			elem = wDriver.findElement(by);
		} catch (NoSuchElementException e) {

		}
		return elem;
	}

	/**
	 * get an element
	 * @param locator
	 * @param opParams
	 * @return element
	 */
	public WebElement getDisplayedElement(Object locator, Object... opParams) {
		By by = locator instanceof By ? (By)locator : By.xpath(locator.toString());
		WebDriver wDriver = (WebDriver) (opParams.length > 0 ? opParams[0]: driver);	
		WebElement e = null;
		try {
			if(by != null)
				e = wDriver.findElement(by);
			if (e != null){
				if (isDisplay(by)) return e;
			}
		} catch (NoSuchElementException ex) {
		}catch(StaleElementReferenceException ex)
		{
			checkCycling(ex, 10);
			Utils.pause(WAIT_INTERVAL);
			getDisplayedElement(locator);
		}
		finally{
			loopCount=0;
		}
		return null;
	}

	/**
	 * verify element exists or not
	 * @param locator
	 * @return true if element exists
	 * 			false if element doesn't exist
	 */
	public boolean isElementPresent(Object locator) {
		return getElement(locator) != null;
	}

	/**
	 * verify element exists or not
	 * @param locator
	 * @return true if element doesn't exists
	 * 			false if element exist
	 */
	public boolean isElementNotPresent(Object locator) {
		return !isElementPresent(locator);
	}

	/**
	 * Get element
	 * @param locator
	 * 					locator of element
	 * @param opParams
	 * 					opPram[0]: timeout
	 * 					opPram[1]: 0,1
	 * 					0: No Assert
	 * 					1: Assert
	 * @return an element
	 */
	public WebElement waitForAndGetElement(Object locator, Object... opParams) {
		WebElement elem = null;
		int timeout = (Integer) (opParams.length>0 ? opParams[0] : DEFAULT_TIMEOUT);
		int isAssert = (Integer) (opParams.length > 1 ? opParams[1]: 1);
		int notDisplayE = (Integer) (opParams.length > 2 ? opParams[2]: 0);
		WebDriver wDriver = (WebDriver) (opParams.length > 3 ? opParams[3]: driver);	
		for (int tick = 0; tick < timeout/WAIT_INTERVAL; tick++) {
			if (notDisplayE == 2){
				elem = getElement(locator,wDriver);
				//elem = getDisplayedElement(locator);
			}else{
				elem = getDisplayedElement(locator,wDriver);
			}
			if (null != elem) return elem;
			Utils.pause(WAIT_INTERVAL);
		}
		if (isAssert == 1)
			assert false: ("Timeout after " + timeout + "ms waiting for element present: " + locator);
		info("cannot find element after " + timeout/1000 + "s.");
		return null;
	}

	/**
	 * Get element
	 * @param locator
	 * 					locator of element
	 * @param opParams
	 * 					opPram[0]: timeout
	 * 					opPram[1]: 0,1
	 * 					0: No Assert
	 * 					1: Assert
	 * @return	an element
	 */
	public WebElement waitForElementNotPresent(Object locator, int... opParams) {
		WebElement elem = null;
		int timeout = opParams.length > 0 ? opParams[0] : DEFAULT_TIMEOUT;
		int isAssert = opParams.length > 1 ? opParams[1]: 1;
		int notDisplayE = opParams.length > 2 ? opParams[2]: 0;

		for (int tick = 0; tick < timeout/WAIT_INTERVAL; tick++) {
			if (notDisplayE == 2){
				elem = getElement(locator);
				//elem = getDisplayedElement(locator);
			}else{
				elem = getDisplayedElement(locator);
			}
			if (null == elem) return null;
			Utils.pause(WAIT_INTERVAL);
		}

		if (isAssert == 1)
			assert false: ("Timeout after " + timeout + "ms waiting for element not present: " + locator);
		info("Element doesn't disappear after " + timeout/1000 + "s.");
		return elem;
	}

	/**
	 * 
	 * @param text
	 * @param opts
	 * @return 	true if text exist
	 * 			false if test is not exist
	 */
	public boolean isTextPresent(String text, int...opts) {
		int display = opts.length > 0 ? opts[0] : 1;
		Utils.pause(500);
		String allVisibleTexts = getText(By.xpath("//body"),display);
		return allVisibleTexts.contains(text);
	}

	/**
	 * get text of element
	 * @param locator
	 * @param opts
	 * @return text of element
	 */
	public String getText(Object locator,int...opts) {
		WebElement element = null;
		int display = opts.length > 0 ? opts[0] : 1;
		try {
			element = waitForAndGetElement(locator,DEFAULT_TIMEOUT,1,display);
			return element.getText();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			return getText(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * get list of element
	 * @param xpath
	 * @return list of elements
	 */
	public List<WebElement> getElements(String xpath) {
		try {
			return driver.findElements(By.xpath(xpath));
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			Utils.pause(1000);
			return getElements(xpath);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * verify text exists or noet
	 * @param text
	 * @return true if text exists
	 * 			false if text doesn't exits
	 */
	public boolean isTextNotPresent(String text) {
		return !isTextPresent(text);
	}

	/**
	 * drag and drop element
	 * @param sourceLocator
	 * @param targetLocator
	 */
	public void dragAndDropToObject(Object sourceLocator, Object targetLocator) {
		info("--Drag and drop to object--");
		Actions action = new Actions(driver);
		try {
			WebElement source = waitForAndGetElement(sourceLocator);
			WebElement target = waitForAndGetElement(targetLocator);

			action.dragAndDrop(source, target).build().perform();

		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			dragAndDropToObject(sourceLocator, targetLocator);
		}catch (UnhandledAlertException e) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				switchToParentWindow();
			} catch (NoAlertPresentException eNoAlert) {
			}
		}

		finally {
			loopCount = 0;
		}
		Utils.pause(1000);
	}

	/**
	 * Click by using javascript
	 * @param locator
	 * @param opParams
	 */
	public void clickByJavascript(Object locator, Object... opParams){
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);	
		WebElement e = waitForAndGetElement(locator,DEFAULT_TIMEOUT, 1, notDisplay);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", e);
	}

	/**
	 * click action
	 * @param locator
	 * @param opParams
	 */
	public void click(Object locator, Object... opParams) {
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);	
		Boolean isUseJavascript =  (Boolean) (opParams.length > 1 ? opParams[1]: false);	
		Actions actions = new Actions(driver);
		try {
			WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplay);
			if(element.isEnabled()){
				if(isUseJavascript){
					info("use javasript to click");
					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
				}
				else
					actions.click(element).perform();
			}
			else {
				debug("Element is not enabled");
				click(locator, notDisplay);
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			click(locator, notDisplay);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			click(locator, notDisplay);
		} finally {
			loopCount = 0;
		}
		Utils.pause(1000);
	}

	/**
	 * clear cache
	 */
	public void clearCache(){
		Actions actionObject = new Actions(driver);
		try{
			actionObject.sendKeys(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		} catch(WebDriverException e){	
			debug("Retrying clear cache...");
			actionObject.sendKeys(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		}
	}

	/**
	 * Use this function to verify if a check-box is checked (using when creating a portal/publicMode)
	 * @param locator
	 * @param opParams
	 */
	public void check(Object locator, int... opParams) {
		int notDisplayE = opParams.length > 0 ? opParams[0]: 0;
		Actions actions = new Actions(driver);
		try {
			WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE);
			if (!element.isSelected()) {
				actions.click(element).perform();
			} else {
				info("Element " + locator + " is already checked.");
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			check(locator, opParams);
		} finally {
			loopCount = 0;
		}
		Utils.pause(2000);
	}

	/**
	 * get value attribute
	 * @param locator
	 * @return value of element
	 */
	public String getValue(Object locator) {
		try {
			return waitForAndGetElement(locator).getAttribute("value");
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);			
			Utils.pause(WAIT_INTERVAL);
			return getValue(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * Mouse hover by Javascript
	 * @param locator
	 * @param opParams
	 */
	public void mouseHoverByJavaScript(Object locator, Object...opParams)
	{
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);
		WebElement targetElement;
		String argu1 = "var evObj = document.createEvent('MouseEvents');";
		String argu2 = "evObj.initMouseEvent('mouseover',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);";
		String argu3 =  "arguments[0].dispatchEvent(evObj);";
		String javascript = argu1 + argu2 + argu3;
		targetElement = waitForAndGetElement(locator,5000, 1, notDisplay);
		((JavascriptExecutor)driver).executeScript(javascript, targetElement);
	}

	/**
	 * mouse over action
	 * @param locator
	 * @param safeToSERE
	 * @param opParams
	 */
	public void mouseOver(Object locator, boolean safeToSERE, Object...opParams) {
		WebElement element;
		Actions actions = new Actions(driver);
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);
		try {
			if (safeToSERE) {
				for (int i = 1; i < ACTION_REPEAT; i++){
					element = waitForAndGetElement(locator, 5000, 0, notDisplay);
					if (element == null){
						Utils.pause(WAIT_INTERVAL);
					} else {
						actions.moveToElement(element).perform();
						break;
					}
				}
			} else {
				element = waitForAndGetElement(locator);
				actions.moveToElement(element).perform();
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			mouseOver(locator, safeToSERE);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * mouse over and clic
	 * @param locator
	 */
	public void mouseOverAndClick(Object locator) {
		WebElement element;
		Actions actions = new Actions(driver);
		if (ieFlag) {
			element = getDisplayedElement(locator);
		} else {
			element = waitForAndGetElement(locator);
		}
		actions.moveToElement(element).click(element).build().perform();
	}

	/**
	 * wait for text present
	 * @param text
	 * @param opts
	 */
	public void waitForTextPresent(String text, int...opts) {
		int waitTime = opts.length > 0 ? opts[0] : DEFAULT_TIMEOUT;
		int display = opts.length > 1 ? opts[1] : 1;
		for (int second = 0;; second++) {
			if (second >= waitTime/WAIT_INTERVAL) {
				Assert.fail("Timeout at waitForTextPresent: " + text);
			}
			if (isTextPresent(text,display)) {
				break;
			}
			Utils.pause(WAIT_INTERVAL);
		}
	}

	/**
	 * wait for text not present
	 * @param text
	 * @param wait
	 */
	public void waitForTextNotPresent(String text,int...wait) {
		int waitTime = wait.length > 0 ? wait[0] : DEFAULT_TIMEOUT;
		for (int second = 0;; second++) {
			if (second >= waitTime/WAIT_INTERVAL) {
				Assert.fail("Timeout at waitForTextNotPresent: " + text);
			}
			if (isTextNotPresent(text)) {
				break;
			}
			Utils.pause(WAIT_INTERVAL);
		}
	}

	/**
	 * wait for msg
	 * @param message
	 * @param wait
	 */
	public void waitForMessage(String message,int...wait) {
		int waitTime = wait.length > 0 ? wait[0] : DEFAULT_TIMEOUT;
		Utils.pause(500);
		waitForAndGetElement("//*[contains(text(),'"+message+"')]",waitTime);
	}

	/**
	 * type to textbox
	 * @param locator
	 * @param value
	 * @param validate
	 * @param opParams
	 */
	public void type(Object locator, String value, boolean validate, Object...opParams) {	
		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0]: 0);
		try {
			for (int loop = 1;; loop++) {
				if (loop >= ACTION_REPEAT) {
					Assert.fail("Timeout at type: " + value + " into " + locator);
				}
				WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplay);		
				if (element != null){
					if (validate) element.clear();
					element.click();
					element.sendKeys(value);
					if (!validate || value.equals(getValue(locator))) {
						break;
					}
				}
				info("Repeat action..." + loop + "time(s)");
				Utils.pause(WAIT_INTERVAL);
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			type(locator, value, validate, opParams);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			type(locator, value, validate, opParams);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * Select option from combo box
	 * @param locator
	 * @param option
	 * @param display
	 */
	public void select(Object locator, String option, int...display) {
		int isDisplay = display.length > 0 ? display[0] : 1;
		try {
			for (int second = 0;; second++) {
				if (second >= DEFAULT_TIMEOUT/WAIT_INTERVAL) {
					Assert.fail("Timeout at select: " + option + " into " + locator);
				}
				Select select = new Select(waitForAndGetElement(locator,DEFAULT_TIMEOUT,1,isDisplay));
				select.selectByVisibleText(option);
				if (option.equals(select.getFirstSelectedOption().getText())) {
					break;
				}
				Utils.pause(WAIT_INTERVAL);
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			select(locator, option);
		} finally {
			loopCount = 0;
		}
		Utils.pause(500);
	}

	/**
	 * un-check a checked-box
	 * @param locator
	 * @param opParams
	 */
	public void uncheck(Object locator, int... opParams) {
		int notDisplayE = opParams.length > 0 ? opParams[0]: 0;
		Actions actions = new Actions(driver);
		try {
			WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, notDisplayE);

			if (element.isSelected()) {
				actions.click(element).perform();
			} else {
				info("Element " + locator + " is already unchecked.");
			}
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			Utils.pause(1000);
			uncheck(locator, opParams);
		} finally {
			loopCount = 0;
		}
		Utils.pause(2000);
	}

	/**
	 * rightClickOnElement
	 * @param locator
	 * @param opParams
	 */
	public void rightClickOnElement(Object locator, int...opParams) {
		int display = opParams.length > 0 ? opParams[0]: 0;
		Actions actions = new Actions(driver);
		Utils.pause(500);
		try {
			WebElement element = waitForAndGetElement(locator,DEFAULT_TIMEOUT,1,display);
			actions.contextClick(element).perform();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			rightClickOnElement(locator);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			click(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * doubleClickOnElement
	 * @param locator
	 */
	public void doubleClickOnElement(Object locator) {
		Actions actions = new Actions(driver);
		try {
			WebElement element = waitForAndGetElement(locator);
			actions.doubleClick(element).perform();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, 5);
			Utils.pause(1000);
			doubleClickOnElement(locator);
		} finally {
			loopCount = 0;
		}
	}

	/**
	 * checkCycling
	 * @param e
	 * @param loopCountAllowed
	 */
	public void checkCycling(Exception e, int loopCountAllowed) {
		info("Exception:" + e.getClass().getName());
		if (loopCount > loopCountAllowed) {
			Assert.fail("Cycled: " + e.getMessage());
		}
		info("Repeat... " + loopCount + "time(s)");
		loopCount++;
	}

	/**
	 * function to switch to parent windows
	 */
	public void switchToParentWindow (){
		try
		{
			Set<String> availableWindows = driver.getWindowHandles();
			String WindowIdParent= null;
			int counter = 1;
			for (String windowId : availableWindows) {
				if (counter == 1){
					WindowIdParent = windowId;
				}
				counter++;
			}
			driver.switchTo().window(WindowIdParent);
			Utils.pause(1000);
		}
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * check element displays or net
	 * @param locator
	 * @return true if element displays
	 * 			false if element doesn't display
	 */
	public boolean isDisplay(Object locator) {
		boolean bool = false;
		WebElement e = getElement(locator);
		try{
			if (e!=null)
				bool = e.isDisplayed();
		}catch(StaleElementReferenceException ex)
		{
			checkCycling(ex, 10);
			Utils.pause(WAIT_INTERVAL);
			isDisplay(locator);
		}
		finally{
			loopCount=0;
		}
		return bool;
	}

	/**
	 * function set driver to auto open new window when click link
	 */
	public void getDriverAutoOpenWindow(){
		FirefoxProfile fp = new FirefoxProfile();		
		fp.setPreference("browser.link.open_newwindow.restriction", 2);
		driver = new FirefoxDriver(fp);
		baseUrl = System.getProperty("baseUrl");
		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
		action = new Actions(driver);
		termsAndConditions();
	}

	/**
	 * function: check a file existed in folder
	 * @param file file name (eg: export.zip)
	 * @return true -> file exist
	 * false-> file is not exist
	 */
	public boolean checkFileExisted(String file){
		String pathFile = System.getProperty("user.dir") + "/src/main/resources/TestData/" + file;
		boolean found = false;

		if (new File(pathFile).isFile()){
			found = true;
		}
		info("File exists: " + file + " is " + found);
		return found;
	}

	/**
	 * function delete file in folder test output
	 * @param file file name
	 */
	public void deleteFile(String file){
		String pathFile = System.getProperty("user.dir") + "/src/main/resources/TestData/" + file;
		File Files = new File(pathFile);
		if(checkFileExisted(file)){
			Files.setWritable(true);
			Files.delete();
		}
		if (checkFileExisted(file) == false){
			info("Delete file successfully");
		}else info("Have error when delete file");
	}

	/**
	 * cutPasteFileFromOutputToTestData
	 * @param fileName
	 */
	public void cutPasteFileFromOutputToTestData(String fileName){
		String source = System.getProperty("user.dir") + "/src/main/resources/TestData/TestOutput/" + fileName;
		//directory where file will be copied
		String target = System.getProperty("user.dir") + "/src/main/resources/TestData/";

		//name of source file
		File sourceFile = new File(source);
		String name = sourceFile.getName();

		File targetFile = new File(target+name);

		//copy file from one location to other
		try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//delete file in TestOutput
		deleteFile("TestOutput/" + fileName);
	}

	/**
	 * 
	 * define language
	 *
	 */
	public enum Language{
		en, fr, vi, lo;
	}

	/**
	 * set language 
	 * @param language
	 */
	public void getDriverSetLanguage(Language language){
		String locale = language.toString();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", locale);
		driver = new FirefoxDriver(profile);
		baseUrl = System.getProperty("baseUrl");
		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
		action = new Actions(driver);
		termsAndConditions();
	}

	/**
	 * function get current Date of system follow a format
	 * @param format
	 * @return current Date of system
	 */
	public String getCurrentDate(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return (dateFormat.format(date)); 
	}

	/**
	 * Add 1 minute to current date time
	 * @param min
	 * @param format
	 * @return string minute
	 */
	public String addMinuteToCurrentDateTime(int min, String...format){
		DateFormat dateFormat = format.length > 0 ? new SimpleDateFormat(format[0]) : new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, min);
		return (dateFormat.format(cal.getTime()));	
	}

	/** Get date in format "dd"
	 * @param gap distance from current date
	 * @return date in format "dd"
	 */
	public String getDate(int gap, String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, gap);
		return (dateFormat.format(cal.getTime()));	
	}

	/** Get day of week
	 * @param gap distance from current date
	 * @return day of week (monday, tuesday,..., sunday)
	 */
	public int getDayOfWeek(int gap){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, gap);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Get minute in format "mm" from current date
	 * @return minute
	 * 
	 */
	public int getMinute(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		int minute = cal.get(Calendar.MINUTE);
		return (minute); 
	}

	/**
	 * Change attribute "display" of HTML tag from "none" to "block" 
	 * @param locator
	 */
	public void changeDisplayAttributeHTML(String locator){
		WebElement element = waitForAndGetElement(locator, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';",element);	
	}


	/**
	 * setPreferenceRunTime
	 */
	public void setPreferenceRunTime(){
		FirefoxProfile fp = new FirefoxProfile();

		fp.setPreference("dom.max_script_run_time", 30);
	}

	/** change lanugage of browser
	 * @param language
	 * English: "en"
	 * French: "fr"
	 */
	public void initFFBrowserWithSetLanguageBrowser(String language){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages",language);   
		driver = new FirefoxDriver(profile);
		baseUrl = System.getProperty("baseUrl");
		if (baseUrl==null) baseUrl = DEFAULT_BASEURL;
		action = new Actions(driver);
	}

	/**
	 * get random string
	 * @return random string
	 */
	public String getRandomString(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * get a list of random numbers
	 * @return random numbers
	 */
	public String getRandomNumber() {
		char[] chars = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * Copy and paste a string from one locator to other
	 * 
	 * @param origin
	 * @param target
	 * @param value
	 */
	public void copyPasteString(By origin, By target, String value) {
		WebElement element1 = driver.findElement(origin);
		WebElement element2 = driver.findElement(target);

		info("Type into the first locator");
		element1.clear();
		element1.click();
		element1.sendKeys(value);

		info("Copy from the first locator");
		element1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element1.sendKeys(Keys.chord(Keys.CONTROL, "c"));

		info("Paste to the second locator");
		element2.click();
		element2.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	/**
	 * Get minute in format "HH" from current date
	 * @return hours
	 * 
	 */
	public int getHours(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		int minute = cal.get(Calendar.HOUR);
		return (minute); 
	}

	/**
	 * @param object
	 * @return = true: if there is not scroll bar on element
	 *         = false: if there is scroll bar on element
	 */
	public boolean checkExitScrollBar(By object){
		WebElement element = waitForAndGetElement(object);
		String scrollHeight = String.valueOf(((JavascriptExecutor)driver).executeScript("return arguments[0].scrollHeight;", element));
		String offsetHeight = String.valueOf(((JavascriptExecutor)driver).executeScript("return arguments[0].offsetHeight;", element));
		info("scrollHeight: " + scrollHeight);
		info("offsetHeight: " + offsetHeight);
		int scroll = Integer.parseInt(scrollHeight);
		int offset = Integer.parseInt(offsetHeight);
		return scroll == offset;
	}

	/**
	 * function get an element from link text when cannot get by text in xpath
	 * @param text
	 * @return an element from link text
	 */
	public WebElement getElementFromTextByJquery(String text){

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Utils.pause(2000);
		try{
			WebElement web = (WebElement) js.executeScript("return $(\"a:contains('" + text + "')\").get(0);");
			return web;
		}catch(org.openqa.selenium.WebDriverException e){
			WebElement web = (WebElement) js.executeScript("return $(\"a:contains('" + text + "')\").get(0);");
			return web;
		}
	}

	/**
	 * scrollBarToGetElement
	 * @param object
	 * @param opParams
	 */
	public void scrollBarToGetElement(By object, int...opParams) {
		int display = opParams.length > 0 ? opParams[0]: 0;
		WebElement element = waitForAndGetElement(object,5000,1,display);
		JavascriptExecutor jse;
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * inputDataToCKEditor
	 * @param framelocator
	 * @param data
	 */
	public void inputDataToCKEditor(By framelocator, String data){
		info("input data to ckeditor");
		try {
			WebElement inputsummary = null;
			WebElement e = waitForAndGetElement(framelocator,DEFAULT_TIMEOUT,1,2);
			driver.switchTo().frame(e);
			inputsummary = driver.switchTo().activeElement();
			inputsummary.click();
			inputsummary.clear();
			((JavascriptExecutor) driver).executeScript("document.body.innerHTML='" + data + "' + document.body.innerHTML;");
			switchToParentWindow();
		} catch (StaleElementReferenceException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			inputDataToCKEditor (framelocator, data);
		} catch (ElementNotVisibleException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			inputDataToCKEditor (framelocator,data);
		}catch (WebDriverException e) {
			checkCycling(e, DEFAULT_TIMEOUT/WAIT_INTERVAL);
			Utils.pause(WAIT_INTERVAL);
			driver.switchTo().defaultContent();
			inputDataToCKEditor (framelocator,data);
		}
	}
	/**
	 * Press Enter key
	 */
	public void pressEnterKey(){
		Actions action = new Actions(this.driver);
		action.sendKeys(Keys.ENTER).perform();
		action.release();
	}
	
	/**
	 * Attach file in attach popup
	 * @author lientm 
	 * Update QuynhPT
	 * @param number
	 *            : number of upload container that need upload file
	 * @param filePath
	 *            : path to file upload
	 */
	public void attachFile(String pathFile, String fileName) {
		info("Attach a file");
		WebElement element = waitForAndGetElement(ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_INPUT, DEFAULT_TIMEOUT, 1,2);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", element);
		info("Get the file to attach");
		element.sendKeys(Utils.getAbsoluteFilePath(pathFile+fileName));
		info("Verify that the file is attached");
		waitForAndGetElement(ELEMENT_UPLOAD_POPUP_NAMEFILE.replace("${fileName}", fileName));
		info("The file is attached successfully");
		info("Click on Save button");
		click(ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_SAVE_BUTTON);
		Utils.pause(2000);
	}
	
	/**
	 * Import a Category
	 * 
	 * @param pathFile
	 * @param fileName
	 */
	public void importCat(String pathFile, String fileName) {
		info("Attach a file");
		WebElement element = waitForAndGetElement(ELEMENT_UPLOAD_POPUP_ATTACHMENT_FILE_INPUT, DEFAULT_TIMEOUT, 1,2);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", element);
		element.sendKeys(Utils.getAbsoluteFilePath(pathFile + fileName));
		waitForAndGetElement(ELEMENT_UPLOAD_POPUP_NAMEFILE.replace("${fileName}", fileName));
		click(ELEMENT_SAVE_BTN);
		Utils.pause(2000);
	}
}