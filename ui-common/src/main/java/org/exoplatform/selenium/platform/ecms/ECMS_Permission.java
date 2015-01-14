package org.exoplatform.selenium.platform.ecms;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.exoplatform.selenium.TestLogger.info;


public class ECMS_Permission extends PlatformBase {

	ManageAlert mngAlert;
	
	public final By ELEMENT_PERMISSION_SELECTUSER = By.xpath("//*[@class='uiIconSelectUser uiIconLightGray']");
	public final By ELEMENT_PERMISSION_SELECTMEMBERSHIP = By.xpath("//*[@class='uiIconSelectMember uiIconLightGray']");
	public final By ELEMENT_PERMISSION_SELECTEVERYONE = By.xpath("//*[@class='uiIconAddAny uiIconLightGray']");
	public final String ELEMENT_PERMISSION_USER_ADDUSER = "//*[text()='${name}']/../..//*[@class='actionIcon']";
	public final By ELEMENT_PERMISSION_TEXTBOXUSER = By.xpath("//*[@id='userOrGroup']");
	public final By ELEMENT_PERMISSION_CHECKBOXREAD = By.xpath("//*[@class='checkbox' and @for='read']");
	public final By ELEMENT_PERMISSION_CHECKBOXMODIFY = By.xpath("//*[@class='checkbox' and @for='add_node']");
	public final By ELEMENT_PERMISSION_CHECKBOXREMOVE = By.xpath("//*[@class='checkbox' and @for='remove']");
	public final By ELEMENT_PERMISSION_SAVE = By.xpath("//*[text()='Save']");
	public final By ELEMENT_PERMISSION_CLOSE = By.xpath("//*[text()='Close']");
	public final String ELEMENT_PERMISSION_DELETE = "//*[text()='${name}']/../..//*[@class='actionIcon']";
    public final String ELEMENT_PERMISSION_USER_OR_GROUP_NAME = ".//*[@id='PermissionInfo']//*[text()='${name}']";
	
	public ECMS_Permission(WebDriver driver) {
		this.driver = driver;
		mngAlert = new ManageAlert(driver);
	}

	/**
	 * Wrong path, ToCorrect
	 * @param user
	 * @param read
	 * @param modify
	 * @param remove
	 */
	public void modifyRightCheckBox(String user, boolean read, boolean modify, boolean remove) {
		if(read==true) {
			check(By.xpath("//*[@name='"+user+"read']"));
		}
		if(modify==true) {
			check(By.xpath("//*[@name='"+user+"addNode]"));
		}
		if(remove==true) {
			check(By.xpath("//*[@name=''"+user+"remove]"));
		}
	}
    /**
     * Delete permission of a node
     * @param name
     */
	public void deletePermissionNode(String name) {
		if (waitForAndGetElement(ELEMENT_PERMISSION_USER_OR_GROUP_NAME.replace("${name}", name),
				3000, 0) != null) {
			info("Click on Delete button of the node:" + name);
			click(By.xpath((ELEMENT_PERMISSION_DELETE).replace("${name}", name)));
			info("click on OK button of alert popup");
			mngAlert.acceptAlert();
			info("Finished deleting permission of the node");
		}
	}
    /**
     * Change right
     * @param user
     * @param name
     * @param read
     * @param modify
     * @param remove
     * @param opt
     */
	public void changeRight(String user, String name, boolean read, boolean modify, boolean remove, String...opt) {
		if(user == "user") {
			info("User is a user");
			info("Click on Select User button");
			click(ELEMENT_PERMISSION_SELECTUSER);
			info("Click on Add User button");
			click(By.xpath((ELEMENT_PERMISSION_USER_ADDUSER).replace("${name}", name)));
		}
		if(user == "membership") {
			info("User is a membership");
			info("Type a mebership for textbox user");
			type( ELEMENT_PERMISSION_TEXTBOXUSER, ""+opt[0]+":/"+opt[1]+"",true);
		}
		if(user == "all") {
			info("User is all");
			info("Click on Select everyone button");
			click(ELEMENT_PERMISSION_SELECTEVERYONE);
		}
		info("Check on checkbox for reading, modifying and removing");
		selectCheckBoxRight(read, modify, remove);
		info("Click on Save button");
		click(ELEMENT_PERMISSION_SAVE);
		info("Finished changing right");
	}
    /**
     * Select a check box about right
     * @param read
     * @param modify
     * @param remove
     */
	public void selectCheckBoxRight(boolean read, boolean modify, boolean remove) {
		info("Select check boxes right");
		if(read==true){
			info("Read right is true, click on Read checkbox");
			check(ELEMENT_PERMISSION_CHECKBOXREAD);
		}
		if(modify==true){
			info("Modify right is true, click on Modify checkbox");
			check(ELEMENT_PERMISSION_CHECKBOXMODIFY);
		}
		if(remove==true){
			info("Remove right is true, click on Remove checkbox");
			check(ELEMENT_PERMISSION_CHECKBOXREMOVE);
		}
		Utils.pause(5000);
		info("Finished selecting right checkbox");
	}
    /**
     * Close permission form
     */
	public void closePermission() {
		info("Close permission form");
		click(ELEMENT_PERMISSION_CLOSE);
	}
}
