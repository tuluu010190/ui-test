package org.exoplatform.selenium.platform.social;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.WebDriver;
public class UserProfilePage extends PlatformBase {

	public final String ELEMENT_PROFILE_TITLE = ".//*[@id='UIStatusProfilePortlet']//*[contains(text(),'${fullName}')]";
	/**
	 * constructor
	 * @param dr
	 */
	public UserProfilePage(WebDriver dr){
		this.driver=dr;
	}
}
