package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Dialog;
import org.exoplatform.selenium.platform.ManageAccount;
import org.openqa.selenium.By;

/**
 * @date July-2013
 * @author lientm
 */
public class Permalink extends BasicAction {
	ManageAccount magAc;
	Dialog dialog;
	
	public final By ELEMENT_PERMALINK_TEXT = By.id("PermalinkText");
	public final By ELEMENT_PERMALINK_NOTIFY = By.xpath("//*[@id='UIWikiPermalinkForm']/*[@class='permalinkNotify']");
	public final By ELEMENT_MAKE_PUBLIC_BUTTON = By.xpath("//*[text() = 'Make Public']");
	public final By ELEMENT_MAKE_RESTRICT_BUTTON = By.xpath("//*[text()= 'Restrict']");
	public final By ELEMENT_PERMISSION_MANAGEMENT = By.xpath("//*[text() = 'Manage Permissions']");
	public final String DATA_NOTIFY_RESTRICT = "This page is restricted. Only authorized users can view and edit it.";
	public final String DATA_NOTIFY_PUBLIC = "This page is public. Anybody can view and edit it.";
	
	public String getPermalink(){
		return getValue(ELEMENT_PERMALINK_TEXT);
	}
	
	/**
	 * @param user
	 * @param permalink: URL of permalink
	 * @param permission = true: user has view permission
	 *                   = false: user does not have view permission
	 * @param content: part of content of wiki page
	 */
	public void goToWikiByPermalink(String user, String permalink, boolean permission, String content){
		magAc = new ManageAccount(driver);
		
		info("Check permalink with user " + user);
		driver.get(permalink);
		magAc.signIn(user, "gtn");
		
		if (permission){
			waitForTextPresent(content);
		}else {
			waitForTextPresent("Page Not Found");
			waitForTextNotPresent(content);
		}
		magAc.signOut();
	}
	
	/** Make wiki public by 2 ways: click link "permalink" or click link "Restrict" link at wiki home
	 * @author update by phuongdt
	 * @param opParams(useRestrictLink = true: make public by Restrict link)
	 */
	public void makePublicPage(Boolean...opParams){
		info("Make public page");
		Boolean useRestrictLink = (Boolean)(opParams.length>0 ? opParams[0]:false);
		if(useRestrictLink){
			waitForAndGetElement(ELEMENT_RESTRICTED_WIKI);
			click(ELEMENT_RESTRICTED_WIKI);
		}
		else{
			goToPermalink();
		}
		dialog = new Dialog(driver);
		click(ELEMENT_MAKE_PUBLIC_BUTTON);
		waitForAndGetElement(ELEMENT_MAKE_RESTRICT_BUTTON);
		assert getText(ELEMENT_PERMALINK_NOTIFY).contains(DATA_NOTIFY_PUBLIC);
		dialog.closeMessageDialog();
	}
	
	public void makeRestrictedPage(){
		dialog = new Dialog(driver);
		info("Make restrict page");
		goToPermalink();
		click(ELEMENT_MAKE_RESTRICT_BUTTON);
		waitForAndGetElement(ELEMENT_MAKE_PUBLIC_BUTTON);
		assert getText(ELEMENT_PERMALINK_NOTIFY).contains(DATA_NOTIFY_RESTRICT);
		dialog.closeMessageDialog();
	}
	
	public void goToPermissionFromPermalink(){
		goToPermalink();
		click(ELEMENT_PERMISSION_MANAGEMENT);	
	}
}
