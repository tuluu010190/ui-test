package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.testng.annotations.*;


public class CAL_Category  extends CAL_TestConfig_4{

	/**
	 *<li> Case ID:116477.</li>
	 *<li> Test Case Name: Add new category with valid value.</li>
	 *<li> Case ID:116478.</li>
	 *<li> Test Case Name: Edit category with valid value.</li>
	 *<li> Case ID:116476.</li>
	 *<li> Test Case Name: Delete event category.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_02_03_AddNewCategoryWithValidValue() {
		String oldNameCategory = txData.getContentByArrayTypeRandom(1)+"116477";
		String newNameCategory = txData.getContentByArrayTypeRandom(1)+"116478";
		
		info("Test 1: Add new category with valid value");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Show Event categories form
		 *Input Data: 
			Click on Calendar icon from left pane and select Add event category in menu
		 *Expected Outcome: 
			Event Categories form is displayed with a list of all existing event categories and a sub form to add new category*/
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar(null,"(GMT +07:00) Asia/Ho_Chi_Minh",null,null,null,null,null);
		cMang.saveSetting();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCATEGORY);
		
		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Add new category
		 *Input Data: 
			- Input valid data into text field.
			- Click Add
		 *Expected Outcome: 
			- Add category successfully
			- Added category is displayed in list above
			- This category is visible and used for creator only*/ 
		cMang.addEventCategory(oldNameCategory);
		evMg.goToAddEventFromActionBar();
		waitForAndGetElement(evMg.ELEMENT_ITEM_QUICK_EVENT_CATEGORY_OPTION.replace("$category", oldNameCategory));
		evMg.cancelQuickAddEditEvent();

		info("Test 3: Edit category with valid value");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Add new category
		 *Input Data: 
			Add new category[Details ]
		 *Expected Outcome: 
			Added category is displayed in list in Event categories form*/

		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Show edit category form
		 *Input Data: 
			Click Edit icon corresponding to the category that you want to edit in Event Category form
		 *Expected Outcome: 
			- Name of category is displayed in text field
			- Add button changes to Update button*/

		/*Step number: 3
		 *Step Name: -
		 *Step Description: 
			Step 3: Edit category with valid data
		 *Input Data: 
			- Make change on Event category name 
			- Click Update
		 *Expected Outcome: 
			- Change is saved, all values disappears from edit form
			- Existing categorylist also is updated*/ 
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCATEGORY);
		cMang.editEventCategory(oldNameCategory, newNameCategory);
		evMg.goToAddEventFromActionBar();
		waitForAndGetElement(evMg.ELEMENT_ITEM_QUICK_EVENT_CATEGORY_OPTION.replace("$category", newNameCategory));
		evMg.cancelQuickAddEditEvent();
		
		info("Test 2: Delete event category");
		/*Step Number: 1
		 *Step Name: -
		 *Step Description: 
			Step 1: Add new category
		 *Input Data: 
			- Add some event categories [ Details ] and some event/task belong to these categories [ Details ]
		 *Expected Outcome: 
			Categories, event, task are created successfully.*/

		/*Step number: 2
		 *Step Name: -
		 *Step Description: 
			Step 2: Delete category
		 *Input Data: 
			- Click on Calendar icon from left pane and select Add event category in menu
			- Click Delete icon corresponding to thecategory you want to deletein Event categories form
			- Click OKto confirm
		 *Expected Outcome: 
			- Confirm message is shown.
			- This category is deleted from the category management list
			- Event(s)/task(s) that was added into this category also is deleted*/ 
		hp.goToCalendarPage();
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCATEGORY);
		cMang.deleteEventCategory(newNameCategory);
	}
}