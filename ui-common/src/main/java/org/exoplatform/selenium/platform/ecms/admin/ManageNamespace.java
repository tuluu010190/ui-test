package org.exoplatform.selenium.platform.ecms.admin;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.ecms.EcmsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author vuna2
 *
 */
public class ManageNamespace extends EcmsBase{

	public ManageNamespace(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	Button button = new Button(driver);

	//Elements
	public final By ELEMENT_REGISTER_BUTTON = By.xpath("//button[text()='Register']");
	public final By ELEMENT_INPUT_NAMESPACE_PREFIX = By.name("namespace");
	public final By ELEMENT_INPUT_NAME_URI = By.name("uri");
	
	public final String ELEMENT_VERIFY_NAMESPACE = "//*[@id='UINamespaceList']//tbody//*[@data-original-title='${namespace}']";
	
	/*======================================================*/
	
	/**
	 * Add a new namespace
	 * @param namespace
	 * @param uri
	 * @param params
	 */
	public void addNewNamespace(String namespace, String uri, Object...params){
		Boolean save = (Boolean) (params.length > 0 ? params[0]: true);
		
		info("-- Register a new namespace ... --" + namespace);
		click(ELEMENT_REGISTER_BUTTON);
		type(ELEMENT_INPUT_NAMESPACE_PREFIX, namespace, true);
		type(ELEMENT_INPUT_NAME_URI, uri, true);
		if (save){
			button.save();
		}else {
			button.cancel();
		}
		Utils.pause(1000);
	}
	
	/**
	 * Verify [namespace] is displayed in the list
	 * @param namespace
	 */
	public void checkDisplayNamespace(String namespace){
		info("-- Verify that -- " + namespace + " -- is created -- ");
        usePaginator(ELEMENT_VERIFY_NAMESPACE, "Namespace... " + namespace + "...not found in the list");
        Utils.pause(500);
        info(namespace + " is created successful. ");
	}
}
