package org.exoplatform.selenium.platform.gatein;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * 
 * Path: Administration-->Portal-->Sites
 */
public class PortalManageSites extends PlatformBase {
	
	public final By ELEMENT_MANAGESITES_TITLE=By.xpath(".//*[@id='UIPortalNavigationPortlet']//h5[text()='Manage Sites']");
	public final String ELEMENT_MANAGESITES_EDIT_NAVIGATION_ICON=".//*[@class='managementBlock']//div[text()='${site}']/../..//*[@class='uiIconNavigation uiIconLightGray']";

	public final String ELEMENT_MANAGESITES_EDIT_LAYOUT_ICON=".//*[@class='managementBlock']//div[text()='${site}']/../..//*[contains(@class,'uiIconEditLayout')]";
	public final String ELEMENT_MANAGESITES_EDIT_CONFIG_ICON=".//*[@class='managementBlock']//div[text()='${site}']/../..//*[contains(@class,'uiIconEditPortalConfig')]";
	
	public final By ELEMENT_MANAGESITES_ADD_NEW_BTN=By.cssSelector("#UISiteManagement .btn");
	public final By ELEMENT_MANAGESITES_EDIT_LAYOUT_SITE_CONFIG_BTN = By.cssSelector(".PageProfileIcon");
	public final String ELEMENT_MANAGESITES_PORTAL_LABEL =".//*[contains(@class,'siteName')][contains(text(),'${portal}')]/..//*[contains(@class,'siteLabel')][contains(text(),'${label}')]";
	public final String ELEMENT_MANAGESITES_PORTAL_DESC =".//*[contains(@class,'siteName')][contains(text(),'${portal}')]/..//*[contains(@class,'siteDescription')][contains(text(),'${desc}')]";

	public final String ELEMENT_ADD_NAVIGATION_BUTTON = "//*[contains(text(),'Add Navigation')]";

	//Navigation Management popup
	public final By ELEMENT_NAVIGATION_MANAGEMENT_POPUP_TITLE=By.xpath(".//*[@class='PopupTitle popupTitle'][text()='Navigation Management']");
	public final String ELEMENT_NAVIGATION_MANAGEMENT_NODE_NAME=".//*[@title='${name}']";
	public final By ELEMENT_NAVIGATION_MANAGEMENT_SAVE = By.xpath(".//*[text()='Save']");
	public final String ELEMENT_NAVIGATION_SPECIFIC_NODE ="//*[@id='UINavigationNodeSelector']//*[@class='uiIconFileMini uiIconLightGray' ]/../..//*[contains(text(),'${name}')]";
	public final String ELEMENT_NAVIGATION_SUB_NODE_CHECK = "//*[@id='UINavigationNodeSelector']//*[@class='uiIconNode collapseIcon' and contains(text(),'{$node}')]";
	
	//Add new portal popup
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_NAME=By.cssSelector("#name");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_LABEL=By.cssSelector("#label");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_DESC=By.cssSelector("#description");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_LOCALE=By.cssSelector("#PortalSetting-tab .selectbox[name~='locale']");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_SITE=By.cssSelector("#PortalSetting-tab .selectbox[name~='skin']");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_SAVE_BTN=By.xpath(".//*[@id='UIPortalForm']//button[text()='Save']");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_PUBLIC_PERMISSION=By.cssSelector("#publicMode");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_PERMISSION_TAB = By.xpath(".//*[contains(@data-target,'#PermissionSetting-tab')]");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_EDIT_PERMISSITION_SETTINGS= By.xpath(".//*[contains(text(),'Edit Permission Settings')]");
	public final By ELEMENT_ADD_NEW_PORTAL_POPUP_SELECT_PERMISSION_BTN= By.xpath(".//*[contains(text(),'Select Permission')]");
	
	//Permission selector
	public final String ELEMENT_PERMISSION_SELECTOR_POPUP_GROUP = ".//*[contains(@class,'uiIconNode')][contains(@title,'${group}')]";
	public final String ELEMENT_PERMISSION_SELECTOR_POPUP_MEMEBRSHIP = ".//*[@id='PermissionSelector']//*[contains(@title,'${member}')]";
	
	//Contextmenu
	public final By ELEMENT_MANAGESITES_CONTEXTMENU_DELETE_ICON= By.xpath(".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconDeleteNode']");
	
	// new node
	public final By ELEMENT_UP_LEVEL_PATH_NODE = By.xpath("//*[@id='UINavigationNodeSelector']//*[@class='uiIconUpLevel uiIconLightGray']");
	public final By ELEMENT_ADD_NODE = By.xpath("//*[@id='UINavigationManagement']/..//*[contains(text(),'Add Node')]");
	public final By ELEMENT_SAVE_NODE = By.xpath("//*[@id='UINavigationManagement']/..//*[contains(text(),'Save')]");
	public final By ELEMENT_NODE_NAME = By.id("name");
	
	
	ManageAlert alert;
	public PortalManageSites(WebDriver dr){
		driver = dr;
		alert = new ManageAlert(dr);
	} 
    
	/**
	 * Open Navigation Management popup
	 * @param site as acme or intranet
	 */
	public void goToEditNavigation(String site){
		waitForAndGetElement(ELEMENT_MANAGESITES_EDIT_NAVIGATION_ICON.replace("${site}", site),3000,0);
		click(ELEMENT_MANAGESITES_EDIT_NAVIGATION_ICON.replace("${site}", site));
		waitForAndGetElement(ELEMENT_NAVIGATION_MANAGEMENT_POPUP_TITLE,3000,0);
	}
	/**
	 * Edit layout of a portal
	 * @param site
	 */
	public void goToEditLayout(String site){
		info("Click on Edit layout button");
		click(ELEMENT_MANAGESITES_EDIT_LAYOUT_ICON.replace("${site}",site));
		Utils.pause(3000);
	}

	/**
	 * change config of a portal
	 * @param site
	 */
	public void changeConfig(String site){
		goToEditLayout(site);
		info("Click on site's config button");
		click(ELEMENT_MANAGESITES_EDIT_LAYOUT_SITE_CONFIG_BTN);
		Utils.pause(3000);
	}
	/**
	 * Go to Edit site configuration 
	 * @param site
	 */
	public void goToEditSiteConfig(String site){
		info("Click on Edit Site Configuration button");
		click(ELEMENT_MANAGESITES_EDIT_CONFIG_ICON.replace("${site}",site));
		Utils.pause(2000);
	}
	/**
	 * list all sublinks in Contextmenu
	 *
	 */
	public enum specifiContextMenu{
		ADD_NEW_NODE,EDIT_NODE_PAGE,EDIT_THIS_NODE,COPY_NODE,CLONE_NODE,CUT_NODE,DELETE_NODE,
		MOVE_UP,MOVE_DOWN;
	}
	
	/**
	 * Select a item in ContextMenu
	 * @param link
	 */
	public void selectItem(specifiContextMenu link){
		switch(link){
		case ADD_NEW_NODE:
			break;
		case EDIT_NODE_PAGE:
			break;
		case EDIT_THIS_NODE:
			break;
		case COPY_NODE:
			break;
		case CLONE_NODE:
			break;
		case CUT_NODE:
			break;
		case DELETE_NODE:
			click(ELEMENT_MANAGESITES_CONTEXTMENU_DELETE_ICON);
			alert.acceptAlert();
			break;
		case MOVE_UP:
			break;
		case MOVE_DOWN:
			break;
		}
	}
	/**
	 * Add a node
	 * @param title
	 * @param path
	 */
	public void addNode(String title,String subTitle){
		if(subTitle.isEmpty()){
			click(ELEMENT_UP_LEVEL_PATH_NODE);
			click(ELEMENT_ADD_NODE);
		    type(ELEMENT_NODE_NAME,title,true);
		}else{
			waitForAndGetElement(ELEMENT_NAVIGATION_SPECIFIC_NODE.replace("${name}",title));
			click(ELEMENT_NAVIGATION_SPECIFIC_NODE.replace("${name}",title));
			click(ELEMENT_ADD_NODE);
			type(ELEMENT_NODE_NAME,subTitle,true);
		}
		click(ELEMENT_NAVIGATION_MANAGEMENT_SAVE);
		Utils.pause(1000);
		click(ELEMENT_SAVE_NODE);
		Utils.pause(2000);
	}
	
	/**
	 * Delete a node
	 * @param locator
	 * @param link
	 */
	public void deleteNode(String title){
		info("Delete a node");
		info("Right click on the node");
		rightClickOnElement(ELEMENT_NAVIGATION_MANAGEMENT_NODE_NAME.replace("${name}",title));
		info("Select Delete link");
		selectItem(specifiContextMenu.DELETE_NODE);
		info("Verify that the node is deleted");
		waitForElementNotPresent(ELEMENT_NAVIGATION_MANAGEMENT_NODE_NAME.replace("${name}",title));
		waitForAndGetElement(ELEMENT_NAVIGATION_MANAGEMENT_SAVE);
		info("Click on Save button");
		click(ELEMENT_NAVIGATION_MANAGEMENT_SAVE);
		Utils.pause(2000);
	}
	/**
	 * Add a simple portal
	 * @param portalName
	 * @param label
	 * @param des
	 * @param groupsPath is as: Platform/Content Management
	 * @param memberShips is as: author
	 */
	public void addSimplePortal(String portalName,String label,String des,String groupsPath,String memberShips){
		info("Click on Add New Portal button");
		click(ELEMENT_MANAGESITES_ADD_NEW_BTN);
		if (!portalName.isEmpty()) {
			info("Input new name for portal name");
			type(ELEMENT_ADD_NEW_PORTAL_POPUP_NAME, portalName, true);
		}
		if(!label.isEmpty()){
			info("Input label");
			type(ELEMENT_ADD_NEW_PORTAL_POPUP_LABEL,label,true);
		}
		if(!des.isEmpty()){
			info("Input description");
			type(ELEMENT_ADD_NEW_PORTAL_POPUP_DESC,des,true);
		}
		info("Select permission tab");
		click(ELEMENT_ADD_NEW_PORTAL_POPUP_PERMISSION_TAB);
		info("Select public permission checkbox");
		check(ELEMENT_ADD_NEW_PORTAL_POPUP_PUBLIC_PERMISSION,2);
		if(!groupsPath.isEmpty()){
			info("Select Edit permission settings tab");
			click(ELEMENT_ADD_NEW_PORTAL_POPUP_EDIT_PERMISSITION_SETTINGS);
			info("Click on Select permission button");
			click(ELEMENT_ADD_NEW_PORTAL_POPUP_SELECT_PERMISSION_BTN);
			info("Select a group");
			selectGroup(groupsPath);
			info("Select a meberships");
			selectMemberShip(memberShips);
		}
		saveNewPortal();
	}
	/**
	 * Select a group in permission selector popup
	 * @param groupsPath is path of groups as:Platform/Content Manangement
	 */
	public void selectGroup(String groupsPath){
		info("Select a group with the path:"+groupsPath);
		String[] groups = groupsPath.split("/");
		for(String groupSelect: groups){
			info("Select group:"+groupSelect);
			click(ELEMENT_PERMISSION_SELECTOR_POPUP_GROUP.replace("${group}", groupSelect));
		}
		Utils.pause(2000);
	}
	/**
	 * Select a membership of a group
	 * @param memberShip
	 */
	public void selectMemberShip(String memberShip){
		info("Select a membership:"+memberShip);
		click(ELEMENT_PERMISSION_SELECTOR_POPUP_MEMEBRSHIP.replace("${member}",memberShip));
		Utils.pause(2000);
	}
	
	/**
	 * Save all data when create a new portal
	 */
	public void saveNewPortal(){
		info("click on Save button");
		click(ELEMENT_ADD_NEW_PORTAL_POPUP_SAVE_BTN);
		Utils.pause(3000);
	}
	/**
	 * Edit a simple portal
	 * @param portalName
	 * @param label
	 * @param des
	 * @param groupsPath is as: Platform/Content Management
	 * @param memberShips is as: author
	 */
	public void editSimplePortal(String portalName,String label,String des,String groupsPath,String memberShips){
		if (!portalName.isEmpty()) {
			info("Input new name for portal name");
			type(ELEMENT_ADD_NEW_PORTAL_POPUP_NAME, portalName, true);
		}
		if(!label.isEmpty()){
			info("Input label");
			type(ELEMENT_ADD_NEW_PORTAL_POPUP_LABEL,label,true);
		}
		if(!des.isEmpty()){
			info("Input description");
			type(ELEMENT_ADD_NEW_PORTAL_POPUP_DESC,des,true);
		}
		info("Select permission tab");
		click(ELEMENT_ADD_NEW_PORTAL_POPUP_PERMISSION_TAB);
		info("Select public permission checkbox");
		check(ELEMENT_ADD_NEW_PORTAL_POPUP_PUBLIC_PERMISSION,2);
		if(!groupsPath.isEmpty()){
			info("Select Edit permission settings tab");
			click(ELEMENT_ADD_NEW_PORTAL_POPUP_EDIT_PERMISSITION_SETTINGS);
			info("Click on Select permission button");
			click(ELEMENT_ADD_NEW_PORTAL_POPUP_SELECT_PERMISSION_BTN);
			info("Select a group");
			selectGroup(groupsPath);
			info("Select a meberships");
			selectMemberShip(memberShips);
		}
		saveNewPortal();
	}
	
}
