package org.exoplatform.selenium.platform.administration;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author quynhpt
 * Date 23/01/2014
 * Path: Administration-->Portal-->Sites
 */
public class ManageSites extends PlatformBase {
	ManageAlert alert;
	
	public final By ELEMENT_MANAGESITES_TITLE=By.xpath(".//*[@id='UIPortalNavigationPortlet']//h5[text()='Manage Sites']");
	public final String ELEMENT_MANAGESITES_EDIT_NAVIGATION_ICON=".//*[@class='managementBlock']//div[text()='${site}']/../..//*[@class='uiIconNavigation uiIconLightGray']";
	
	//Navigation Management popup
	public final By ELEMENT_NAVIGATION_MANAGEMENT_POPUP_TITLE=By.xpath(".//*[@class='PopupTitle popupTitle'][text()='Navigation Management']");
	public final String ELEMENT_NAVIGATION_MANAGEMENT_NODE_NAME=".//*[@title='${name}']";
	public final By ELEMENT_NAVIGATION_MANAGEMENT_SAVE = By.xpath(".//*[text()='Save']");
	public final String ELEMENT_NAVIGATION_SPECIFIC_NODE ="//*[@id='UINavigationNodeSelector']//*[@class='uiIconFileMini uiIconLightGray' ]/../..//*[contains(text(),'${name}')]";
	public final String ELEMENT_NAVIGATION_SUB_NODE_CHECK = "//*[@id='UINavigationNodeSelector']//*[@class='uiIconNode collapseIcon' and contains(text(),'{$node}')]";
	
	//Contextmenu
	public final By ELEMENT_MANAGESITES_CONTEXTMENU_DELETE_ICON= By.xpath(".//*[@id='NavigationNodePopupMenu']//*[@class='uiIconDeleteNode']");
	
	// new node
	public final By ELEMENT_UP_LEVEL_PATH_NODE = By.xpath("//*[@id='UINavigationNodeSelector']//*[@class='uiIconUpLevel uiIconLightGray']");
	public final By ELEMENT_ADD_NODE = By.xpath("//*[@id='UINavigationManagement']/..//*[contains(text(),'Add Node')]");
	public final By ELEMENT_SAVE_NODE = By.xpath("//*[@id='UINavigationManagement']/..//*[contains(text(),'Save')]");
	public final By ELEMENT_NODE_NAME = By.id("name");
	
	
	
	public ManageSites(WebDriver dr){
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
	 * list all sublinks in Contextmenu
	 * @author quynhpt
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
	
}
