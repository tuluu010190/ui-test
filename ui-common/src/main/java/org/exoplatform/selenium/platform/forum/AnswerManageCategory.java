package org.exoplatform.selenium.platform.forum;

import  static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.ManageAlert;
import org.exoplatform.selenium.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Migrate from plf3.5
 * @author lientm
 * @date 19 Aug 2013
 */
public class AnswerManageCategory extends AnswerBase {

	public AnswerManageCategory(WebDriver dr){
		driver = dr;
	}
	
	Button button = new Button(driver);
	ManageAlert alert;
	ForumPermission per;
	
	//Manage Category
	public final By ELEMENT_CATEGORY_BUTTON = By.className("uiIconAnsManageCategory");
	public final By ELEMENT_ADD_CATEGORY_LINK = By.linkText("Add Category");
	public final By ELEMENT_CATEGORY_NAME = By.id("eventCategoryName");
	public final By ELEMENT_ORDER = By.id("index");
	public final By ELEMENT_RETRICTED_AUDIENCE = By.id("userPrivate");
	public final By ELEMENT_DESCRIPTION = By.id("description");
	public final By ELEMENT_MODERATE_NEW_QUESTION = By.id("moderatequestions");
	public final By ELEMENT_VIEW_QUESTION_AUTHOR = By.id("ViewAuthorInfor");
	public final By ELEMENT_MODERATE_ANSWER = By.id("moderateAnswers");
	public final By ELEMENT_MODERATOR = By.id("moderator");
	public final By ELEMENT_EDIT_CATEGORY_MENU = By.xpath("//*[@class='uiIconEditCategory']");
	public final By ELEMENT_EDIT_CATEGORY_RIGHT_CLICK = By.xpath("//div[@class='MiddleLeftRightClickPopupMenu']/*//a[text()='Edit']");
	
	//Delete category
	public final By ELEMENT_DELETE_CATEGORY_ON_MENU = By.linkText("Delete");
	public final String MSG_DELETE_CATEGORY = "Are you sure you want to delete this category ?";
	public final By ELEMENT_OK_DELETE_BUTTON = By.xpath("//*[@id='UIForumPopupConfirmation']//button[text()='OK']");
	
	//Export category
	public final By ELEMENT_EXPORT_CATEGORY_LINK = By.linkText("Export");
	public final By ELEMENT_FILE_NAME_EXPORT = By.id("FileName");
	
	//Import category
	public final By ELEMENT_IMPORT_CATEGORY_LINK = By.linkText("Import");
	public final By ELEMENT_IMPORT_CATEGORY_INPUT = By.name("file");
	public final String ELEMENT_IMPORT_SUCCESS_MESSAGE = "The file has been imported.";
	
	//context menu
	public final By ELEMENT_MOVE_CATEGORY_LINK = By.linkText(" Move");
	public final By ELEMENT_DELETE_CATEGORY_LINK = By.linkText(" Delete");
	public final By ELEMENT_WATCH_CATEGORY_LINK = By.linkText(" Watch");
	public final By ELEMENT_UNWATCH_CATEGORY_LINK = By.linkText(" Unwatch");
	
	//watch/unwatch category
	public final String MESSAGE_WATCH_CATEGORY = "You are watching this category. You will be notified about all changes.";
	public final By WATCH_CATEGORY_ICON = By.xpath("//*[@class='uiIconWatch uiIconLightGray']");
	
	//move page
	public final String ELEMENT_CATEGORY_IN_MOVE_FORM = "//*[@id='UIMoveCategoryForm']//*[text()='${category}']";
	
	/*----------------------------------common function----------------------------------*/
	
	//	Go to home Category 
	public void goToHomeCategoryInAnswer(){
		By ELEMENT_HOME_CATEGORY=By.xpath("//img[@alt='categories']");

		waitForAndGetElement(ELEMENT_HOME_CATEGORY);
		click(ELEMENT_HOME_CATEGORY);
	}
	
	/**
	 * function get category from left tree
	 * @param categoryName
	 * @return
	 */
	public WebElement getCategoryLinkFromTree(String categoryName){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Utils.pause(2000);
		WebElement web = (WebElement) js.executeScript("return $(\"a:contains('" + categoryName + "')\").get(0);");
		return web;
	}

	/**
	 * Open a category using jquery
	 * @param categoryName
	 */
	public void openCategoryInAnswer(String categoryName){
		info("Open category " + categoryName);
		getCategoryLinkFromTree(categoryName).click();
		Utils.pause(2000);
	}

	/**
	 * @author lientm
	 * @param name_edit
	 * @param order
	 * @param setAudience
	 * @param audience
	 * @param description
	 * @param setModerator
	 * @param moderator
	 * @param opt: option to check
	 */
	public void modifyDataInCategory(String name_edit, String order, String description, int permission, String[] userGroup,
			boolean restricted, boolean moderator, boolean... opt){
		button = new Button(driver);
		per = new ForumPermission(driver);
		
		if (name_edit != null){
			type(ELEMENT_CATEGORY_NAME, name_edit ,true);
		}
		if (order != null){
			type(ELEMENT_ORDER, order, true);
		}
		if (description != null){
			type(ELEMENT_DESCRIPTION, description, true);
		}
		if (opt.length > 0){
			if (opt[0]){
				check(ELEMENT_MODERATE_NEW_QUESTION, 2);
			} else {
				uncheck(ELEMENT_MODERATE_NEW_QUESTION, 2);
			}
		}
		if (opt.length > 1){
			if (opt[0]){
				check(ELEMENT_VIEW_QUESTION_AUTHOR, 2);
			} else {
				uncheck(ELEMENT_VIEW_QUESTION_AUTHOR, 2);
			}
		}
		if (opt.length > 2){
			if (opt[0]){
				check(ELEMENT_MODERATE_ANSWER, 2);
			} else {
				uncheck(ELEMENT_MODERATE_ANSWER, 2);
			}
		}
		if (permission != 0){
			per.configPermission4AnswerCategory(permission, userGroup, restricted, moderator);
		}
		button.save();
	}

	/**
	 * @author lientm
	 * Create Category in Answer by typing user/ group directly
	 * @param categoryName: String
	 * @param order: string
	 * @param setAudience: way to set audience
	 * @param audience: user/group audience
	 * @param description: string
	 * @param setModerator: way to set moderator
	 * @param moderator: user/group moderator
	 * @param opt: group checkbox
	 */
	public void addNewCategoryInAnswer(String categoryName, String order, String description, int permission, String[] userGroup,
			boolean restricted, boolean moderator, boolean... opt){
		info("Create new category " + categoryName);
		click(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_ADD_CATEGORY_LINK);
		modifyDataInCategory(categoryName, order, description, permission, userGroup, restricted, moderator, opt);
		Utils.pause(2000);
	}

	/**
	 * @author hakt
	 * @param name_edit
	 * @param order
	 * @param setAudience
	 * @param audience
	 * @param description
	 * @param setModerator
	 * @param moderator
	 * @param opt
	 */
	public void editOpeningCategoryInAnswer(String name_edit, String order, String description, int permission, String[] userGroup,
			boolean restricted, boolean moderator, boolean... opt){
		info("Edit an opening category");
		click(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_EDIT_CATEGORY_MENU);
		modifyDataInCategory(name_edit, order, description, permission, userGroup, restricted, moderator, opt);
		Utils.pause(2000);
	}	
	
	/** Edit an category by right-click
	 * @author hakt
	 * @param categoryLink
	 * @param name_edit
	 * @param order
	 * @param setAudience
	 * @param audience
	 * @param description
	 * @param setModerator
	 * @param moderator
	 * @param opt
	 */
	public void editNotOpeningCategoryInAnswer(String categoryLink, String name_edit, String order, String description, int permission, String[] userGroup,
			boolean restricted, boolean moderator, boolean... opt){
		info("Edit a category by right-click");
		rightClickOnElement(By.linkText(categoryLink));
		click(ELEMENT_EDIT_CATEGORY_RIGHT_CLICK);

		modifyDataInCategory(name_edit, order, description, permission, userGroup, restricted, moderator, opt);
		Utils.pause(2000);
	}


	/**
	 * Delete Opening Category by clicking Category then click Delete
	 * @param categoryName
	 */
	public void deleteOpeningCategoryInAnswer(String categoryName){
		info("Delete a category by clicking Category then click Delete");
		click(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_DELETE_CATEGORY_ON_MENU);
		waitForMessage(MSG_DELETE_CATEGORY);
		click(ELEMENT_OK_DELETE_BUTTON);
		waitForTextNotPresent(categoryName);
	}

	/**
	 * Delete Category by right click Category then click Delete
	 * @param categoryName
	 */

	public void deleteNotOpeningCategoryInAnswer(String categoryName, boolean...verify){
		boolean valid = verify.length > 0 ? verify[0]: true;
		action = new Actions(driver);
		
		info("Delete a category by right-click Category then click Delete");
		action.contextClick(getCategoryLinkFromTree(categoryName)).perform();
		click(ELEMENT_DELETE_CATEGORY_LINK);
		waitForMessage(MSG_DELETE_CATEGORY);
		click(ELEMENT_OK_DELETE_BUTTON);
		if (valid){
			waitForTextNotPresent(categoryName);
		}		
	}
	
	/**
	 * function move category source to category destination
	 * @param source
	 * @param destination
	 */
	public void moveCategory(String source, String destination){
		action = new Actions(driver);
		info("Move category " + source + "to category " + destination);
		action.contextClick(getCategoryLinkFromTree(source)).perform();
		click(ELEMENT_MOVE_CATEGORY_LINK);
		doubleClickOnElement(ELEMENT_CATEGORY_IN_MOVE_FORM.replace("${category}", destination));
		waitForElementNotPresent(ELEMENT_CATEGORY_IN_MOVE_FORM.replace("${category}", destination));
	}
	
	/**
	 * @author lientm
	 * @param fileName
	 */
	public void exportAnswerCategory(String fileName){
		button = new Button(driver);
		info("Export category to file " + fileName);
		click(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_EXPORT_CATEGORY_LINK);
		type(ELEMENT_FILE_NAME_EXPORT, fileName, true);
		button.save();
		Utils.pause(1000);		
	}
	
	/**
	 * @author lientm
	 * @param fileName
	 */
	public void importAnswerCategory(String fileName){
		button = new Button(driver);
		info("Import category from file " + fileName);
		click(ELEMENT_CATEGORY_BUTTON);
		click(ELEMENT_IMPORT_CATEGORY_LINK);
		
		WebElement element = waitForAndGetElement(ELEMENT_IMPORT_CATEGORY_INPUT, DEFAULT_TIMEOUT, 1, 2);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", element);
		element.sendKeys(Utils.getAbsoluteFilePath("TestData/" + fileName));
		switchToParentWindow();
		waitForAndGetElement("//*[text()='" + fileName + "']", DEFAULT_TIMEOUT, 1, 2);
		button.save();
		waitForMessage(ELEMENT_IMPORT_SUCCESS_MESSAGE);
		click(ELEMENT_OK_INFOR_POPUP);
		Utils.pause(2000);
	}
	
	public void watchAnswerCategory(String categoryName){
		action = new Actions(driver);
		action.contextClick(getCategoryLinkFromTree(categoryName)).perform();
		click(ELEMENT_WATCH_CATEGORY_LINK);
		waitForMessage(MESSAGE_WATCH_CATEGORY);
		click(ELEMENT_OK_INFOR_POPUP);	
		waitForAndGetElement(WATCH_CATEGORY_ICON);
	}
	
	public void unwatchAnswerCategory(String categoryName){
		action = new Actions(driver);
		action.contextClick(getCategoryLinkFromTree(categoryName)).perform();
		click(ELEMENT_UNWATCH_CATEGORY_LINK);
		waitForElementNotPresent(WATCH_CATEGORY_ICON);
	}
	
	public void dragDropAnswerCategory(String source, String target){
		action = new Actions(driver);
		info("Drag category " + source + " to category " + target);
		action.dragAndDrop(getCategoryLinkFromTree(source), getCategoryLinkFromTree(target)).build().perform();
		Utils.pause(2000);
	}
}
