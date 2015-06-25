package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectDayOption;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage.selectViewOption;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.openqa.selenium.Dimension;
import org.testng.annotations.*;


	public class CAL_Task_Task_Details extends CAL_TestConfig_3{

	/**
	*<li> Case ID:116340.</li>
	*<li> Test Case Name: Check displaying of event/ task's attachment as an image in List View.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_CheckDisplayingOfEventTasksAttachmentAsAnImageInListView() {
		info("Test 1: Check displaying of event/ task's attachment as an image in List View");
		/*Step Number: 1
		*Step Name: Create event/ task with attachment
		*Step Description: 
			- Create new event/ task with nameEVENT_DETAIL_LIST_01 and attachment as an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with image attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment);
		tasMg.saveAddTaskDetails();
		
		info("A event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Check thumbnails of events/ tasks' attachment as an image
		*Step Description: 
			- Click List view, choose event/ task above
		*Input Data: 
			
		*Expected Outcome: 
			- Image is displayed as thumbnails*/
		cMang.viewDetailsEventTaskInList(title);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_DETAIL_IMAGE_THUMBNAIL.replace("$number","1"));
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116341.</li>
	*<li> Test Case Name: Check displaying of event/ task's attachment as an image in Search result.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	**Here is a bug: https://jira.exoplatform.org/browse/CAL-1149
	*/
	@Test
	public  void test02_CheckDisplayingOfEventTasksAttachmentAsAnImageInSearchResult() {
		info("Test 2: Check displaying of event/ task's attachment as an image in Search result");
		/*Step Number: 1
		*Step Name: Create task/ event
		*Step Description: 
			- Create new event/ task with name EVENT_DETAIL_LIST_01 and attachment as an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with image attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment);
		tasMg.saveAddTaskDetails();
		
		info("A event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Search task/ event
		*Step Description: 
			- Type event/ task's name in simple search box then press Enter
		*Input Data: 
			
		*Expected Outcome: 
			- Return task/ event in search result*/
		cMang.searchQuickEventTask(title);
		
		/*Step number: 3
		*Step Name: View task/ event
		*Step Description: 
			- Choose event/ task above
		*Input Data: 
			
		*Expected Outcome: 
			- Image is displayed as thumbnails*/ 
		cMang.viewDetailsEventTaskInList(title);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_DETAIL_IMAGE_THUMBNAIL.replace("$number","1"));
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116342.</li>
	*<li> Test Case Name: Check displaying of event/task's attachments in List View (except image).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test03_CheckDisplayingOfEventtasksAttachmentsInListView() {
		info("Test 3: Check displaying of event/task's attachments in List View (except image)");
		/*Step Number: 1
		*Step Name: Create task/ event
		*Step Description: 
			- Create new event/ task with name asEVENT_DETAIL_LIST_011 attachment as a file not image, eg a doc file
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment = fData.getAttachFileByArrayTypeRandom(1);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment);
		tasMg.saveAddTaskDetails();
		
		info("A event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Check displaying of attachment
		*Step Description: 
			- Click List view, choose event/ task above
		*Input Data: 
			
		*Expected Outcome: 
			- Attachment is display as an icon*/ 
		cMang.viewDetailsEventTaskInList(title);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_DETAIL_ATTACHMENT_ICON);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116343.</li>
	*<li> Test Case Name: Check displaying of event/ task's attachment in Search result (not an image).</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*Here is a bug: https://jira.exoplatform.org/browse/CAL-1149
	*/
	@Test
	public  void test04_CheckDisplayingOfEventTasksAttachmentInSearchResult() {
		info("Test 4: Check displaying of event/ task's attachment in Search result (not an image)");
		/*Step Number: 1
		*Step Name: Create task/ event
		*Step Description: 
			- Create new event/ task named EVENT_DETAIL_LIST_01 with attachment as a file not image, eg a doc file
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment = fData.getAttachFileByArrayTypeRandom(1);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment);
		tasMg.saveAddTaskDetails();
		
		info("A Task is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Search task/ event
		*Step Description: 
			- Type event/ task's name in simple search box then press Enter
		*Input Data: 
			
		*Expected Outcome: 
			- Return task/ event in search result*/
		cMang.searchQuickEventTask(title);
		
		/*Step number: 3
		*Step Name: View task/ event
		*Step Description: 
			- Choose event/ task above
		*Input Data: 
			
		*Expected Outcome: 
			- Attachment is display as icon*/ 
		cMang.viewDetailsEventTaskInList(title);
		waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_DETAIL_ATTACHMENT_ICON);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116344.</li>
	*<li> Test Case Name: Check thumbnails size of event/task's attachments.</li>
	*<li> Pre-Condition: Check size of image by
	- Right click on page, choose View Page info
	- Choose media tab
	- Click thumbnal image: eg http://localhost:8080/rest/thumbnailImage/custom/50x38/repository/collaboration//Users/j___/jo___/joh___/john/ApplicationData/CalendarApplication/calendars/john
	-defaultCalendarId/Event8e96dd1bc0a80136001ac547778ae78f/attachment/Attachment8e96c9efc0a801360167c3bc1865ae06
	- See Dimentions: you will see: (scaled to 50px × 50px)</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test05_CheckThumbnailsSizeOfEventtasksAttachments() {
		info("Test 5: Check thumbnails size of event/task's attachments");
		/*Step Number: 1
		*Step Name: Create task/ event
		*Step Description: 
			- Create new event/ task namedEVENT_DETAIL_LIST_02 with attachment as an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with image attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment);
		tasMg.saveAddTaskDetails();
		
		info("A task is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: View size of image attachment
		*Step Description: 
			- Click List view, choose event/ task above
		*Input Data: 
			
		*Expected Outcome: 
			- Image attachment with any size is displayed as thumbnails with size is 50x **/ 
		cMang.viewDetailsEventTaskInList(title);
		Dimension size_img=waitForAndGetElement(cMang.ELEMENT_EVENT_TASK_DETAIL_IMAGE_THUMBNAIL_CONTAINER.
				replace("$number","1")).getSize();
		cMang.deleteCalendar(calendar);
		info("size_img.width:"+size_img.width);
		info("size_img.heigh:"+size_img.height);
		if(size_img.width!=50 || size_img.height!=50)
			assert false:"The thumbnail is with incorrect size";

 	}

	/**
	*<li> Case ID:116345.</li>
	*<li> Test Case Name: Check mouse over thumbnails of event/task's attachments.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test06_CheckMouseOverThumbnailsOfEventtasksAttachments() {
		info("Test 6: Check mouse over thumbnails of event/task's attachments");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Create new event/ task namedEVENT_DETAIL_LIST_03 with attachment as an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Event/ task is created with image attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment);
		tasMg.saveAddTaskDetails();
		
		info("A task is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click List view, choose event/ task above
			- Click on image attachment
		*Input Data: 
			
		*Expected Outcome: 
			Image attachmentis displayed in a larger format.*/ 
		cMang.viewDetailsEventTaskInList(title);
		cMang.viewLargeImageInList("1",true);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116346.</li>
	*<li> Test Case Name: Check displaying only one thumbnails when mouse over event/task's attachments.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test07_CheckDisplayingOnlyOneThumbnailsWhenMouseOverEventtasksAttachments() {
		info("Test 7: Check displaying only one thumbnails when mouse over event/task's attachments");
		/*Step Number: 1
		*Step Name: Create event/task with attachment
		*Step Description: 
			- Create new event/ task with nameEVENT_DETAIL_LIST_04 and some attachments as images
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with image attachments*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment1 = fData.getAttachFileByArrayTypeRandom(26);
		String attachment2 = fData.getAttachFileByArrayTypeRandom(26);
		String attachment3 = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment1);
		tasMg.attachFileToTask(attachment2);
		tasMg.attachFileToTask(attachment3);
		tasMg.saveAddTaskDetails();
		
		info("A task is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Check larger image
		*Step Description: 
			- Click List view, choose event/ task above
			- Mouse over image attachments
		*Input Data: 
			
		*Expected Outcome: 
			- Only one thumbnail at a time is displayed in a larger format preview*/ 
		cMang.viewDetailsEventTaskInList(title);
		cMang.viewLargeImageInList("1",true);
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116347.</li>
	*<li> Test Case Name: Check large format preview of thumbnails when mouse over.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test08_CheckLargeFormatPreviewOfThumbnailsWhenMouseOver() {
		info("Test 8: Check large format preview of thumbnails when mouse over");
		/*Step Number: 1
		*Step Name: Create task/ event with an image attachment
		*Step Description: 
			- Create new event/ task with name EVENT_DETAIL_LIST_05 attachment as an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with image attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment1 = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment1);
		tasMg.saveAddTaskDetails();
		
		info("A task is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Mouse over image attachment
		*Step Description: 
			- Click List view, choose event/ task above 
			- Mouse over thumbnails of attachment
		*Input Data: 
			
		*Expected Outcome: 
			- Larger format preview with formula: 170px x "origin image's height * 170 / origin image's width"px
			- Eg image with size: 521*511 will be scaled to 170px × 167px*/ 
		cMang.viewDetailsEventTaskInList(title);
		cMang.viewLargeImageInList("1",true);
		cMang.deleteCalendar(calendar);
 	}

	/**
	*<li> Case ID:116348.</li>
	*<li> Test Case Name: Check close large format preview of thumbnails when mouse over.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test09_CheckCloseLargeFormatPreviewOfThumbnailsWhenMouseOver() {
		info("Test 9: Check close large format preview of thumbnails when mouse over");
		/*Step Number: 1
		*Step Name: Create task/ event with image attachment
		*Step Description: 
			- Create new event/ task with name EVENT_DETAIL_LIST_06& attachment as an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Event/ task EVENT_DETAIL_LIST_06is created with image attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment1 = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment1);
		tasMg.saveAddTaskDetails();
		
		info("A task is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Check close large format preview of thumbnails when mouse over
		*Step Description: 
			- Click List view, choose event/ task above 
			- Mouse over thumbnails of attachment
			- Click Close button on large preview of thumbnails
		*Input Data: 
			
		*Expected Outcome: 
			Large format preview is closed*/ 
		cMang.viewDetailsEventTaskInList(title);
		cMang.viewLargeImageInList("1",false);
		cMang.closeViewLargeImageInList(true);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116349.</li>
	*<li> Test Case Name: Check Download image attachment when clicking on large format preview of thumbnails.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test10_CheckDownloadImageAttachmentWhenClickingOnLargeFormatPreviewOfThumbnails() {
		info("Test 10 Check Download image attachment when clicking on large format preview of thumbnails");
		/*Step Number: 1
		*Step Name: Create task/ event
		*Step Description: 
			- Create new event/ task with nameEVENT_DETAIL_LIST_07 attachment as an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Event/ task is created with image attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment1 = fData.getAttachFileByArrayTypeRandom(26);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment1);
		tasMg.saveAddTaskDetails();
		
		info("A task is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: Download image attachment
		*Step Description: 
			- Click List view, choose event/ task above 
			- Mouse over thumbnails of attachment
			- Click again on Large format preview
		*Input Data: 
			
		*Expected Outcome: 
			- Image is downloaded*/ 
		cMang.viewDetailsEventTaskInList(title);
		cMang.viewLargeImageInList("1",false);
		cMang.downloadImageInList();
		info("Verify that the file is download successfully");
		checkFileExisted("TestOutput/" + attachment1);
		deleteFile("TestOutput/" + attachment1);
		cMang.deleteCalendar(calendar);

 	}

	/**
	*<li> Case ID:116350.</li>
	*<li> Test Case Name: Check Download attachment when clicking on attachment's name.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test11_CheckDownloadAttachmentWhenClickingOnAttachmentsName() {
		info("Test 11 Check Download attachment when clicking on attachment's name");
		/*Step Number: 1
		*Step Name: 
		*Step Description: 
			- Create new event/ task with nameEVENT_DETAIL_LIST_08 and attachment not an image
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			Event/ task is created with attachment*/
		info("Create a new calendar");
		calendar = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
        hp.goToCalendarPage();
        cMang.goToMenuFromMainCalendar(menuOfMainCalendar.ADDCAL);
        cMang.inputDataInDetailTabCalendarForm(calendar, calendar,null);
        cMang.saveAddCalendar();
        
        
		info("Add a task");
		String title = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String newContent = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String attachment = fData.getAttachFileByArrayTypeRandom(1);
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		tasMg.inputBasicDetailTask(title,newContent,calendar);
		info("Add attachment");
		tasMg.attachFileToTask(attachment);
		tasMg.saveAddTaskDetails();
		
		info("A event is created successfully");
		cHome.verifyIsPresentEventTaskWithDateTime(title,getCurrentDate("MMM dd yyyy"), selectViewOption.WEEK, selectDayOption.DETAILTIME);

		/*Step number: 2
		*Step Name: 
		*Step Description: 
			- Click List view, choose event/ task above 
			- Click attachment's name
		*Input Data: 
			
		*Expected Outcome: 
			- Attachment is downloaded*/ 
		cMang.viewDetailsEventTaskInList(title);
		info("Click on the download link");
		click(cMang.ELEMENT_EVENT_TASK_ATTACHMENT_LIST_VIEW.replace("${file}",attachment));
		info("Verify that the file is download successfully");
		checkFileExisted("TestOutput/" + attachment);
		deleteFile("TestOutput/" + attachment);
		cMang.deleteCalendar(calendar);

 	}}