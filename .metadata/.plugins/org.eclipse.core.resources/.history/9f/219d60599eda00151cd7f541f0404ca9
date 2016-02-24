package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class CAL_Task_Add extends CAL_TestConfig{

	/**
	 *<li> Case ID:116339.</li>
	 *<li> Test Case Name: Check Add attachment popup without any attachment.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test01_CheckAddAttachmentPopupWithoutAnyAttachment() {
		info("Test 1: Check Add attachment popup without any attachment");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in to Calendar
			- Add a new task with name ATTACH_FILE_01_4
			- Click More Details
			- Click "Add Attachment"
			- Do not attach any file
			- See popup
		 *Input Data: 

		 *Expected Outcome: 
			"Attach Files" popup is displayed as
			- a "Select File" button
			- the label "No file selected"*/ 
		info("Add a task");
		hp.goToCalendarPage();
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();

		info("Add attachment");
		click(tasMg.ELEMENT_TASK_ADD_ATTACHMENT);
		click(tasMg.ELEMENT_SELECT_FILE);
		waitForAndGetElement(tasMg.ELEMENT_SELECT_NO_FILE);
		click(tasMg.ELEMENT_ATTACHMENT_CANCEL_BUTTON);
		tasMg.cancelAddEditDetailTask();
	}

	/**
	 *<li> Case ID:116335.</li>
	 *<li> Test Case Name: Check after a task has 10 attachments.</li>
	 *<li> Case ID:116334.</li>
	 *<li> Test Case Name: Check limit of 10 attachments.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test02_03_CheckAfterATaskHas10Attachments() {
		info("Test 2: Check after a task has 10 attachments");
		info("Test 3: Check limit of 10 attachments");
		String link1 = fData.getAttachFileByArrayTypeRandom(19);

		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in to Calendar
			- Add a new task with name ATTACH_FILE_06
			- Click More Details
			- Click Add Attachment
			- Upload 10 files
		 *Input Data: 

		 *Expected Outcome: 
			- 10 files are uploaded successfully
			- No message is displayed but the select component is not displayed anymore.*/ 
		info("Add a task");
		hp.goToCalendarPage();
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();

		info("Add attachment");
		for(int i = 0; i<10; i++){
			tasMg.attachFileToTask("TestData/" + link1);
		}

		waitForAndGetElement(tasMg.ELEMENT_DISABLE_TASK_ADD_ATTACHMENT);
		click(tasMg.ELEMENT_DISABLE_TASK_ADD_ATTACHMENT);
		waitForElementNotPresent(tasMg.ELEMENT_SELECT_FILE);
		tasMg.cancelAddEditDetailTask();
	}

	/**
	 *<li> Case ID:116386.</li>
	 *<li> Test Case Name: Check deleting attachment after uploading.</li>
	 *<li> Case ID:116337.</li>
	 *<li> Test Case Name: Check attachment's explorer.</li>
	 *<li> Case ID:116336.</li>
	 *<li> Test Case Name: Check displaying of Add attachment button.</li>
	 *<li> Case ID:116338.</li>
	 *<li> Test Case Name: Check title of Add attachment popup.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test04_05_06_07_CheckDeletingAttachmentAfterUploading() {
		String link1 = fData.getAttachFileByArrayTypeRandom(19);

		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in to Calendar
			- Add a new task with name ATTACH_FILE_03
			- Click More Details
			- Click Add Attachment
			- Choose a file to upload
			- After uploading, click Delete icon of attachment
		 *Input Data: 

		 *Expected Outcome: 
			- File is uploaded successfully
			- Attachment is removed*/ 
		info("Add a task");
		hp.goToCalendarPage();
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		info("Test 4: Check attachment's explorer");
		info("Test 5: Check displaying of Add attachment button");
		info("Test 6: Check title of Add attachment popup");
		tasMg.attachFileToTask("TestData/" + link1);
		info("Test 7: Check deleting attachment after uploading");
		tasMg.removeAttachment(link1);
		tasMg.cancelAddEditDetailTask();
	}


	/**
	 *<li> Case ID:116385.</li>
	 *<li> Test Case Name: Check progress bar during attachment time.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test(groups="pending")
	public  void test08_CheckProgressBarDuringAttachmentTime() {
		info("Test 8: Check progress bar during attachment time");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in to Calendar
			- Add a new task with name ATTACH_FILE_02
			- Click More Details
			- Click Add Attachment
			- Choose a file to upload
		 *Input Data: 

		 *Expected Outcome: 
			- File is selected
			- During the upload, a progress bar is displayed, it shows the percentage of the file already uploaded (based on its size)*/ 

	}

	/**
	 *<li> Case ID:116387.</li>
	 *<li> Test Case Name: Check uploading more files.</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 */
	@Test
	public  void test09_CheckUploadingMoreFiles() {
		info("Test 9: Check uploading more files");
		String link1 = fData.getAttachFileByArrayTypeRandom(19);
		String path = "TestData/" + link1;
		String[] links = path.split("/");
		/*Step Number: 1
		 *Step Name: 
		 *Step Description: 
			- Log in to Calendar
			- Add a new task with name ATTACH_FILE_04
			- Click More Details
			- Click Add Attachment
			- Choose a file to upload
			- After finishing uploading, click Select more files
		 *Input Data: 

		 *Expected Outcome: 
			- One attachment is listed in the popup
			- Another native explorer is open to choose file to upload*/ 
		info("Add a task");
		hp.goToCalendarPage();
		tasMg.goToAddTaskFromActionBar();
		tasMg.moreDetailsTask();
		click(tasMg.ELEMENT_TASK_ADD_ATTACHMENT);
		click(tasMg.ELEMENT_SELECT_FILE);
		uploadFileUsingRobot(path);
		waitForAndGetElement(tasMg.ELEMENT_ATTACHMENT_FORM_FILE_NAME.replace("$fileName", links[links.length-1]));
		
		for(int i = 0; i<9; i++){
			click(tasMg.ELEMENT_SELECT_MORE_FILE);
			uploadFileUsingRobot(path);
			waitForAndGetElement(tasMg.ELEMENT_ATTACHMENT_FORM_FILE_NAME.replace("$fileName", links[links.length-1]));
		}
		waitForElementNotPresent(tasMg.ELEMENT_SELECT_MORE_FILE);
		waitForElementNotPresent(tasMg.ELEMENT_SELECT_FILE);
		click(tasMg.ELEMENT_ATTACHMENT_CANCEL_BUTTON);
		tasMg.cancelAddEditDetailTask();
	}
}