package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Provides all methods of managing all versions of a page when editing the content of a page.
 * 
 *
 */
public class Version extends BasicAction{

	public final By ELEMENT_VIEW_PAGE_HISTORY = By.xpath("//*[text()='View Page History']");
	/** 
	 * View change of a Wiki page
	 */
	public void viewChange()
	{
		info("--View change of a page--");
		click(ELEMENT_VIEW_CHANGE);
		waitForAndGetElement(ELEMENT_COMPARE_TEXT);
	}

	/**
	 * View version of a Wiki page
	 * 
	 * @param version
	 * 			 number of version
	 */
	public void viewVersion(String version){
		info("--View a version of a page--");
		String versionLink = ELEMENT_VERSION_LINK.replace("{$version}",version);
		String versionLinkAux = ELEMENT_VERSION_LINK_AUX.replace("{$version}",version);
		click(ELEMENT_REVISION_LINK);
		if(waitForAndGetElement(versionLink, 5000, 0)!=null)
			click(versionLink);
		else
			click(versionLinkAux);
		Utils.pause(1000);
	}

	/** 
	 * Restore version of a Wiki page
	 * 
	 * @param version
	 * 			 number of version
	 */
	public void restoreVersion(String version){
		info("--Restore a version of a page--");
		String versionLink = ELEMENT_RESTORE_LINK.replace("{$version}",version);
		if (isTextPresent("Page History")){
			info("-- You are currently in the revision page --");		
		}else{
			click(ELEMENT_REVISION_LINK);
		}
		Utils.pause(500);
		driver.navigate().refresh();
		Utils.pause(2000);
		click(versionLink);
		Utils.pause(1000);
	}

	/** 
	 * Compare 2 versions of a Wiki page
	 * 
	 * @param first
	 * 			number of the first version
	 * @param second
	 * 			number of the second version
	 */
	public void compareVersion(String first, String second){
		info("--Compare 2 versions of a page--");

		String versionCheckbox1 = ELEMENT_VERSION_CHECKBOX.replace("{$version}", first);
		String versionCheckbox2= ELEMENT_VERSION_CHECKBOX.replace("{$version}", second);
		if (isTextPresent("Page History")){
			info("-- You are currently in the revision page --");		
		}else{
			click(ELEMENT_REVISION_LINK);
		}
		Utils.pause(500);
		driver.navigate().refresh();
		Utils.pause(2000);
		click(versionCheckbox1, 2);
		click(versionCheckbox2, 2);
		WebElement cButton = waitForAndGetElement(ELEMENT_COMPARE_BUTTON, 3000, 0, 2);
		if (cButton != null){
			click(ELEMENT_COMPARE_BUTTON);
		}else {
			click(By.xpath("//*[text()='Compare with selected versions']"));
		}
		waitForAndGetElement(ELEMENT_COMPARE_TEXT);
	}

	/**
	 * Go to the Revisions page of the selected Wiki page
	 */
	public void goToRevisionsPage(){
		click(ELEMENT_MORE_LINK);
		click(ELEMENT_PAGE_INFO_LINK);
		Utils.pause(1000);
	}

	/**
	 * Change compare versions of a Wiki page
	 * 
	 * @param firstNumberVersion
	 * 				first version to compare 
	 * @param secondNumberVersion
	 * 				second version to compare
	 */
	public void changeCompareVersions(String firstNumberVersion, String secondNumberVersion){
		Utils.pause(1000);
		click(By.xpath(ELEMENT_CHANGES_COMPARE_VERSION.replace("${1stNumber}", firstNumberVersion).replace("${2ndNumber}", secondNumberVersion)));
		waitForElementNotPresent(ELEMENT_CHANGES_COMPARE_VERSION.replace("${1stNumber}", firstNumberVersion).replace("${2ndNumber}", secondNumberVersion));
	}

	/**
	 * Go to the View Page History of the selected Wiki page
	 */
	public void viewPageHistory(){
		Utils.pause(1000);
		click(By.xpath("//*[contains(text(),'View Page History')]"));
		waitForTextPresent("Revision");
	}
}
