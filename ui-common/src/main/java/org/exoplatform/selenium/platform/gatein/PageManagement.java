package org.exoplatform.selenium.platform.gatein;
import static org.exoplatform.selenium.TestLogger.info;
import org.exoplatform.selenium.platform.PlatformBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageManagement extends PlatformBase {
	
	//Common
	public final By ELEMENT_PAGE_CREATION_WIZARD = By.id("UIPageCreationWizard");
	public final By ELEMENT_PAGE_NEXT_BUTTON=By.xpath("//*[@id='UIPageCreationWizard']//*[text()='Next']");
	public final By ELEMENT_PAGE_ABORT_BUTTON=By.xpath("//*[@id='UIPageCreationWizard']//*[text()='Abort']");
	public final By ELEMENT_WARNING_PAGE_NOT_FOUND=By.xpath("//*[@class='TitleWaring' and text()='Page not found.']");

	//Step 1
	public final By ELEMENT_PAGE_SETUP_INFO_FORM=By.id("UIWizardPageSetInfo");
	public final By ELEMENT_PAGE_NAME_INPUT=By.id("pageName");
	public final By ELEMENT_PAGE_MODE_CHECKBOX=By.id("switchmode");
	public final By ELEMENT_PAGE_LANGUAGE_SELECT_BOX=By.name("languages");
	public final By ELEMENT_PAGE_DISPLAY_NAME_INPUT=By.id("i18nizedLabel");
	public final By ELEMENT_PAGE_VISIBLE_CHECKBOX=By.id("visible");
	public final By ELEMENT_PAGE_PUBLICATION_DATE_CHECKBOX=By.id("showPublicationDate");
	public final By ELEMENT_PAGE_UP_LEVEL=By.xpath("//*[@class='uiIconUpLevel uiIconLightGray']");
	public final String ELEENT_NODE_NAME="//*[@title='$name']";
	
	//Step 2
	public final By ELEMENT_PAGE_SELECT_LAYOUT_FORM = By.id("UIWizardPageSelectLayoutForm");
	
	//Step 3
	public final By ELEMENT_PAGE_PORTAL_EDITOR=By.id("UIPortalApplication");
	
	public PageManagement(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Input data in page info page at step 1
	 * @param name
	 * @param isMode
	 * @param lang
	 * @param disName
	 * @param isVis
	 * @param isPub
	 */
	public void inputPageInfoStep1(String name, Boolean isMode, String lang, String disName, Boolean isVis, Boolean isPub){
		info("Input data in page info page at step 1");
		if(name!=null && name!=""){
			info("Input name");
			type(ELEMENT_PAGE_NAME_INPUT,name,true);
		}
		if(isMode!=null){
			info("Input mode");
			if(isMode)
				check(ELEMENT_PAGE_MODE_CHECKBOX,2);
			else
				uncheck(ELEMENT_PAGE_MODE_CHECKBOX,2);
		}
		if(lang!=null && lang!=""){
			info("Input language");
			select(ELEMENT_PAGE_LANGUAGE_SELECT_BOX,lang);
		}
		if(disName!=null && disName!=""){
			info("Input display name");
			type(ELEMENT_PAGE_NAME_INPUT,name,true);
		}
		if(isVis!=null){
			info("Input Visible");
			if(isMode)
				check(ELEMENT_PAGE_VISIBLE_CHECKBOX,2);
			else
				uncheck(ELEMENT_PAGE_VISIBLE_CHECKBOX,2);
		}
		if(isPub!=null){
			info("Input publication date");
			if(isMode)
				check(ELEMENT_PAGE_PUBLICATION_DATE_CHECKBOX,2);
			else
				uncheck(ELEMENT_PAGE_PUBLICATION_DATE_CHECKBOX,2);
		}
	}
}
