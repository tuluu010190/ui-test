package org.exoplatform.selenium.platform.ks.functional.wiki.attachment;

import static org.exoplatform.selenium.TestLogger.info;
import static org.exoplatform.selenium.platform.ManageAccount.signIn;

import org.exoplatform.selenium.platform.ks.Wiki;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*--
 *-- Author: HaKT
 *-- Date: 10 Dec 2012
 **/


public class KS_Wiki_Attachment_Add extends Wiki{

	@BeforeMethod
	public void setUpBeforeTest(){
		initSeleniumTest();
		actions = new Actions(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		signIn("john", "gtn"); 
		goToWiki();
	}

	@AfterMethod
	public void afterTest(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	public static String MSG_CANCEL_CREATE_PAGE="Are you sure to leave this page?";
	public static By ELEMENT_OK_BUTTON=By.xpath("//input[@value='OK']");
	
	
	/**
	 * Case 01: Add image file for page
	 * Create a wiki page
	 * Scroll down, click Upload, choose an image
	 * Verify result
	 * * Click Cancel
	 */
	@Test
	public static void test01_AttachAnImageForPage(){

		String DATA_WIKI_PAGE_NAME="Blank_Wiki_Page_With_Image1";
		String DATA_WIKI_PAGE_CONTENT="Blank_Wiki_Page_With_Image_Content";
		String ATTACHMENT_NAME="Winter.jpg";
		String ATTACHMENT_PATH="TestData/"+ATTACHMENT_NAME+"";
		By ATTACHMENT_FILE_LINK=By.xpath("//a[text()='"+ATTACHMENT_NAME+"']");

		info("Attach 1 image for wiki page");

		goToAddBlankPage();

		modifyDataForWikiPageSourceEditor(DATA_WIKI_PAGE_NAME, DATA_WIKI_PAGE_CONTENT);

		attachFileInWiki(ATTACHMENT_PATH);
		
		waitForElementPresent(ATTACHMENT_FILE_LINK);

		pause(1000);
		click(ELEMENT_CANCEL_BUTTON);
		waitForTextPresent(MSG_CANCEL_CREATE_PAGE);
		click(ELEMENT_OK_BUTTON);
	}

	/**
	 * Case 02: Add pdf file for page
	 * Create a wiki page
	 * Scroll down, click Upload, choose a pdf file
	 * Verify result
	 * Click Cancel
	 */
	@Test
	public static void test02_AttachPdfFileForPage(){

		String DATA_WIKI_PAGE_NAME="Blank_Wiki_Page_With_PDFFile";
		String DATA_WIKI_PAGE_CONTENT="Blank_Wiki_Page_With_PDFFile_Content";
		String ATTACHMENT_NAME="KS_Wiki_Attachment_pdffile.pdf";
		String ATTACHMENT_PATH="TestData/"+ATTACHMENT_NAME+"";
		By ATTACHMENT_FILE_LINK=By.xpath("//a[text()='"+ATTACHMENT_NAME+"']");

		info("Attach pdf for wiki page");
		goToAddBlankPage();

		modifyDataForWikiPageSourceEditor(DATA_WIKI_PAGE_NAME, DATA_WIKI_PAGE_CONTENT);

		attachFileInWiki(ATTACHMENT_PATH);
		waitForElementPresent(ATTACHMENT_FILE_LINK);

		pause(1000);
		click(ELEMENT_CANCEL_BUTTON);
		waitForTextPresent(MSG_CANCEL_CREATE_PAGE);
		click(ELEMENT_OK_BUTTON);
	}


	/**
	 * Case 03: Add txt file for page
	 * Create a wiki page
	 * Scroll down, click Upload, choose a txt file
	 * Verify result
	 * Click Cancel
	 */
	@Test
	public static void test03_AttachTxtFileForPage(){

		String DATA_WIKI_PAGE_NAME="Blank_Wiki_Page_With_txt_File";
		String DATA_WIKI_PAGE_CONTENT="Blank_Wiki_Page_With_txt_File_Content";
		String ATTACHMENT_NAME="KS_WiKi_Attachment_TxtFile.txt";
		String ATTACHMENT_PATH="TestData/"+ATTACHMENT_NAME+"";
		By ATTACHMENT_FILE_LINK=By.xpath("//a[text()='"+ATTACHMENT_NAME+"']");

		info("Attach txt file for wiki page");
		goToAddBlankPage();

		modifyDataForWikiPageSourceEditor(DATA_WIKI_PAGE_NAME, DATA_WIKI_PAGE_CONTENT);

		attachFileInWiki(ATTACHMENT_PATH);
		waitForElementPresent(ATTACHMENT_FILE_LINK);

		pause(1000);
		click(ELEMENT_CANCEL_BUTTON);
		waitForTextPresent(MSG_CANCEL_CREATE_PAGE);
		click(ELEMENT_OK_BUTTON);
	}

	/**
	 * Case 04: Add office file for page
	 * Create a wiki page
	 * Scroll down, click Upload, choose an office file
	 * Verify result
	 * * Click Cancel
	 */
	@Test
	public static void test04_AttachOfficeFileForPage(){

		String DATA_WIKI_PAGE_NAME="Blank_Wiki_Page_With_Office_File";
		String DATA_WIKI_PAGE_CONTENT="Blank_Wiki_Page_With_Office_File_Content";
		String ATTACHMENT_NAME="KS_Wiki_Attachment_Office_file.doc";
		String ATTACHMENT_PATH="TestData/"+ATTACHMENT_NAME+"";
		By ATTACHMENT_FILE_LINK=By.xpath("//a[text()='"+ATTACHMENT_NAME+"']");

		info("Attach Office file for wiki page");
		goToAddBlankPage();

		modifyDataForWikiPageSourceEditor(DATA_WIKI_PAGE_NAME, DATA_WIKI_PAGE_CONTENT);

		attachFileInWiki(ATTACHMENT_PATH);
		waitForElementPresent(ATTACHMENT_FILE_LINK);

		pause(1000);
		click(ELEMENT_CANCEL_BUTTON);
		waitForTextPresent(MSG_CANCEL_CREATE_PAGE);
		click(ELEMENT_OK_BUTTON);
	}

	/**
	 * Case 05: Add music file for page
	 * Create a wiki page
	 * Scroll down, click Upload, choose a music file
	 * Verify result
	 * * Click Cancel
	 */
	@Test
	public static void test05_AttachMusicFileForPage(){

		String DATA_WIKI_PAGE_NAME="Blank_Wiki_Page_With_mp3_File";
		String DATA_WIKI_PAGE_CONTENT="Blank_Wiki_Page_With_mp3_File_Content";
		String ATTACHMENT_NAME="KS_Wiki_Attachment_AllMyLove.mp3";
		String ATTACHMENT_PATH="TestData/"+ATTACHMENT_NAME+"";
		By ATTACHMENT_FILE_LINK=By.xpath("//a[text()='"+ATTACHMENT_NAME+"']");

		info("Attach mp3 file for wiki page");
		goToAddBlankPage();

		modifyDataForWikiPageSourceEditor(DATA_WIKI_PAGE_NAME, DATA_WIKI_PAGE_CONTENT);

		attachFileInWiki(ATTACHMENT_PATH);
		waitForElementPresent(ATTACHMENT_FILE_LINK);

		pause(1000);
		click(ELEMENT_CANCEL_BUTTON);
		waitForTextPresent(MSG_CANCEL_CREATE_PAGE);
		click(ELEMENT_OK_BUTTON);
	}
}
