package org.exoplatform.selenium.platform.ecms;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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

	public ECMS_Permission(WebDriver driver) {
		this.driver = driver;
		mngAlert = new ManageAlert(driver);
	}

	// Wrong path, ToCorrect
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

	public void deletePermissionNode(String name) {
		click(By.xpath((ELEMENT_PERMISSION_DELETE).replace("${name}", name)));
		mngAlert.acceptAlert();
	}

	public void changeRight(String user, String name, boolean read, boolean modify, boolean remove, String...opt) {
		if(user == "user") {
			click(ELEMENT_PERMISSION_SELECTUSER);
			click(By.xpath((ELEMENT_PERMISSION_USER_ADDUSER).replace("${name}", name)));
			selectCheckBoxRight(read, modify, remove);
			click(ELEMENT_PERMISSION_SAVE);
		}
		if(user == "membership") {
			type( ELEMENT_PERMISSION_TEXTBOXUSER, ""+opt[0]+":/"+opt[1]+"",true);
			selectCheckBoxRight(read, modify, remove);
			click(ELEMENT_PERMISSION_SAVE);
		}
		if(user == "all") {
			click(ELEMENT_PERMISSION_SELECTEVERYONE);
			selectCheckBoxRight(read, modify, remove);
			click(ELEMENT_PERMISSION_SAVE);
		}
	}

	public void selectCheckBoxRight(boolean read, boolean modify, boolean remove) {
		if(read==true){
			check(ELEMENT_PERMISSION_CHECKBOXREAD);
		}
		if(modify==true){
			check(ELEMENT_PERMISSION_CHECKBOXMODIFY);
		}
		if(remove==true){
			check(ELEMENT_PERMISSION_CHECKBOXREMOVE);
		}
		Utils.pause(5000);
	}

	public void closePermission() {
		click(ELEMENT_PERMISSION_CLOSE);
	}
}
