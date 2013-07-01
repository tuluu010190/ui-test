package org.exoplatform.selenium.platform.wiki;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author vuna2
 *
 */
public class Version extends BasicAction{

	/** View change of a page
	 * @author thuntn
	 */
	public void viewChange()
	{
		info("--View change of a page--");
		click(ELEMENT_VIEW_CHANGE);
		waitForAndGetElement(ELEMENT_COMPARE_TEXT);
	}

	/**View a version of a page
	 * @author thuntn
	 * @param version: number of version
	 */
	public void viewVersion(String version){
		info("--View a version of a page--");

		String versionLink = ELEMENT_VERSION_LINK.replace("{$version}",version);
		click(ELEMENT_REVISION_LINK);
		Utils.pause(500);
		driver.navigate().refresh();
		Utils.pause(2000);
		//click(versionLink);
		WebElement vLink = waitForAndGetElement(versionLink, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", vLink);
		Utils.pause(1000);
	}

	/** Restore a version of a page
	 * @author thuntn
	 * @param version: number of version
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
		//click(versionLink);
		WebElement vLink = waitForAndGetElement(versionLink, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", vLink);
		Utils.pause(1000);
	}

	/** Compare 2 versions of a page
	 * @author thuntn
	 * @param first: number of the first version
	 * @param second: number of the second version
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
		//click(versionCheckbox1, 2);
		WebElement vCheckbox1 = waitForAndGetElement(versionCheckbox1, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", vCheckbox1);
		//click(versionCheckbox2, 2);
		WebElement vCheckbox2 = waitForAndGetElement(versionCheckbox2, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", vCheckbox2);
		
		WebElement cButton = waitForAndGetElement(ELEMENT_COMPARE_BUTTON, 3000, 0, 2);
		if (cButton != null){
			//click(ELEMENT_COMPARE_BUTTON);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", cButton);
		}else {
			click(By.xpath("//*[text()='Compare selected']"));
		}
		waitForAndGetElement(ELEMENT_COMPARE_TEXT);
	}

	/**
	 * @author vuna2
	 * <li>Go to the revisions page (of selected wiki page)</li>
	 */
	public void goToRevisionsPage(){
		if (isTextPresent("Page History")){
			info("-- You are currently in the revision page --");	
		}else{
			click(ELEMENT_REVISION_LINK);
			Utils.pause(1000);
			waitForTextPresent("Page History");
		}
	}

	/**
	 * @author vuna2
	 * @param firstNumberVersion: first version to compare (String)
	 * @param secondNumberVersion: second version to compare (String)
	 */
	public void changeCompareVersions(String firstNumberVersion, String secondNumberVersion){
		Utils.pause(1000);
		click(By.xpath(ELEMENT_CHANGES_COMPARE_VERSION.replace("${1stNumber}", firstNumberVersion).replace("${2ndNumber}", secondNumberVersion)));
		waitForElementNotPresent(ELEMENT_CHANGES_COMPARE_VERSION.replace("${1stNumber}", firstNumberVersion).replace("${2ndNumber}", secondNumberVersion));
	}

	/**
	 * @author vuna2
	 * <li>Go to the View Page History (selected wiki page)</li>
	 */
	public void viewPageHistory(){
		Utils.pause(1000);
		//click(By.linkText("View Page History"));
		click(By.xpath("//*[contains(text(),'View Page History')]"));
		waitForTextPresent("Revision");
	}
}
