package org.exoplatform.selenium.platform.cloud;

import org.exoplatform.selenium.platform.administration.ContentAdministration.mainEcmFunctions;
import org.exoplatform.selenium.platform.administration.ContentAdministration.specificEcmFunctions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.exoplatform.selenium.TestLogger.info;
public class Cloud_CreateData extends Cloud_Config {
	@Test
	public  void Create_Data() {
		info("Create Cateogry: Intranet/Defense/Healing");
		String categoryTreeName = "intranet";
		String categorySubName1 = "Defense";
		String categorySubName11 = "Healing";
		String categorySubName2 = "Movement";
		String categorySubName3 = "Natural Elements";
		
		navTool.goToContentAdministration();
		caPage.goToSpecificMainFunctions(mainEcmFunctions.ADVANCED);
		caPage.goToSpecificFunctions(specificEcmFunctions.CATEGORIES);
		click(By.xpath(caPage.ELEMENT_ECM_ADVANCED_CATEGORIES_EDIT_FORM.replace("{$name}",categoryTreeName)));
		caPage.addSubCategory(categorySubName1);
		caPage.addSubCategory(categorySubName2);
		caPage.addSubCategory(categorySubName3);
		caPage.selectGroup(categoryTreeName+"/"+categorySubName1);
		caPage.addSubCategory(categorySubName11);
		button.close();
	}
}
