package org.exoplatform.selenium.platform.ecms;

import static org.exoplatform.selenium.TestLogger.info;

public class ContentTemplate extends EcmsBase {
	// add new article
		public static void createNewArticle(String title, String name, String sum, String cont) {
			click(ELEMENT_ARTICLE_LINK);
			// Input information
			type(ELEMENT_ARTICLE_TITLE_TEXTBOX,title,false);
			type(ELEMENT_ARTICLE_NAME_TEXTBOX, name, true);
			inputDataToFrame(ELEMENT_ARTICLE_SUMMARY_FRAME,sum);
		    switchToParentWindow();
		    inputDataToFrame(ELEMENT_ARTICLE_CONTENT_FRAME,cont);
		    switchToParentWindow();
		    //save
		    click(ELEMENT_SAVE_CLOSE_BUTTON);
		}
		
		//add new announcement
		public static void createNewAnnouncement (String name, String sum){
			click(ELEMENT_ANNOUCEMENT_LINK);
			type(ELEMENT_ANNOUCEMENT_NAME_TEXTBOX, name, true);
			inputDataToFrame(ELEMENT_ANNOUCEMENT_SUMMARY_FRAME,sum);
		    switchToParentWindow();
		    click(ELEMENT_SAVE_CLOSE_BUTTON);
		}
		
		//add new Free layout webcontent
		public static void createNewFreeLayoutWebContent(String title, String name, String cont, String img, String sum, String css, String js) {
			click(ELEMENT_WEBCONTENT_LINK);
			type(ELEMENT_WEBCONTENT_TITLE_TEXTBOX, title, false);
//			waitForAndGetElement(ELEMENT_WEBCONTENT_NAME_TEXTBOX).clear();
			type(ELEMENT_WEBCONTENT_NAME_TEXTBOX, name, true);
			inputDataToFrame(ELEMENT_WEBCONTENT_CONTENT_FRAME,cont);
		    switchToParentWindow();
		    if (cont!="" || img !=""){
		    	click(ELEMENT_WEBCONTENT_ILLUSTRATION_TAB);
		    	if (img!=""){
					driver.switchTo().frame(waitForAndGetElement(ELEMENT_WEBCONTENT_UPLOAD_FRAME));
					type(ELEMENT_WEBCONTENT_FILE_IMAGE, getAbsoluteFilePath(img), false);
				    switchToParentWindow();
				    waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
		    	}
				inputDataToFrame(ELEMENT_WEBCONTENT_SUMMARY_FRAME,sum);
			    switchToParentWindow();
		    }
		    if(css!="" || js !=""){
			    click(ELEMENT_WEBCONTENT_ADVANCE_TAB);
			    type(ELEMENT_WEBCONTENT_CSS_TEXTAREA, css, false);
			    type(ELEMENT_WEBCONTENT_JS_TEXTAREA, js, false);
		    }
		    click(ELEMENT_SAVE_CLOSE_BUTTON);			
		}
		
		//add new file
		public static void createNewFile(String name, String cont, String title){
			click(ELEMENT_NEWFILE_LINK);	
			type(ELEMENT_NEWFILE_NAME_TEXTBOX, name, false);
			inputDataToFrame(ELEMENT_NEWFILE_CONTENT_FRAME,cont);
		    switchToParentWindow();
		    type(ELEMENT_NEWFILE_TITLE_TEXTBOX, title, false);
		    click(ELEMENT_SAVE_CLOSE_BUTTON);
		}
		
		//add new Sample Node
		public static void createNewSampleNode(String title, String name, String img){
			click(ELEMENT_SAMPLENODE_LINK);
			type(ELEMENT_SAMPLENODE_TITLE_TEXTBOX, title, false);
//			waitForAndGetElement(ELEMENT_SAMPLENODE_NAME_TEXTBOX).clear();
			type(ELEMENT_SAMPLENODE_NAME_TEXTBOX, name, true);
			click(ELEMENT_SAMPLENODE_ADD_ITEM_LINK);
			selectOption(ELEMENT_SAMPLENODE_SELECTITEM,ELEMENT_SAMPLENODE_SELECTITEM_OPTION);
			click(ELEMENT_SAMPLENODE_SELECTITEM_OPTION_LINK);
			type(ELEMENT_SAMPLENODE_DESCRIPTION_TEXTBOX, title, false);
			if (img !=""){
			driver.switchTo().frame(waitForAndGetElement(ELEMENT_SAMPLENODE_UPLOAD_IMG_FRAME));
			type(ELEMENT_SAMPLENODE_FILE_IMG, getAbsoluteFilePath(img), false);
			switchToParentWindow();
			waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
			}
			type(ELEMENT_SAMPLENODE_CONTENT_TEXTAREA, title, false);
			type(ELEMENT_SAMPLENODE_SUMMARY_TEXTAREA, title, false);
			click(ELEMENT_SAVE_CLOSE_BUTTON);
		}

		// add new Kofax document
		public static void createNewKofax(String name){
			click(ELEMENT_KOFAX_LINK);
			type(ELEMENT_KOFAX_NAME_TEXTBOX, name, false);
			click(ELEMENT_KOFAX_ADDNODE_LINK);
			selectOption(ELEMENT_KOFAX_ADDNODE_SELECT,ELEMENT_KOFAX_ADDNODE_OPTION);	
			click(ELEMENT_KOFAX_ADDNODE_OPTION_LINK);
			click(ELEMENT_SAVE_CLOSE_BUTTON);
		}
		
		// add new File Plan
		public static void createNewFilePlan(String name, String catInden, String disAut, String oriOrg, String event){
			click(ELEMENT_FILEPLAN_LINK);	
			type(ELEMENT_FILEPLAN_NAME, name, false);
			click(ELEMENT_FILEPLAN_RECORD_TAB);
			type(ELEMENT_FILEPLAN_RECORD_TEXTBOX, catInden, false);
			type(ELEMENT_FILEPLAN_DISPOS_TEXTBOX, disAut, false);
			type(ELEMENT_FILEPLAN_DEFAULT_TEXTBOX, oriOrg, false);
			
			click(ELEMENT_FILEPLAN_RPROCESS_TAB);
			type(ELEMENT_FILEPLAN_RPROCESS_TRIGER, event, false);
			click(ELEMENT_SAVE_CLOSE_BUTTON);
		}

		// add new podcast
		public static void createNewPodcast(String name, String title, String link){
			click(ELEMENT_PODCAST_LINK);
			type(ELEMENT_PODCAST_NAME_TEXTBOX, name, false);
			type(ELEMENT_PODCAST_TITLE_TEXTBOX, title, false);
			type(ELEMENT_PODCAST_LINK_TEXTBOX, link, false);
			click(ELEMENT_SAVE_CLOSE_BUTTON);
		}
		
		//add new Picture on head layout webcontent
		public static void createNewPictureOnHeadLayout (String name, String title, String file){
			click(ELEMENT_HEAD_LAYOUT_LINK);
			type(ELEMENT_HEAD_LAYOUT_NAME_TEXTBOX, name, false);
			type(ELEMENT_HEAD_LAYOUT_TITLE_TEXTBOX, title, false);
			if (file!=""){
			driver.switchTo().frame(waitForAndGetElement(ELEMENT_HEAD_LAYOUT_UPLOAD_FRAME));
			type(ELEMENT_HEAD_LAYOUT_UPLOAD_FILE, getAbsoluteFilePath(file), false);
			switchToParentWindow();
			waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
			}
			click(ELEMENT_SAVE_CLOSE_BUTTON);
		}
		
		//add new product
		public static void createNewProduct (String name, String title){
			click(ELEMENT_PRODUCT_LINK);
			type(ELEMENT_PRODUCT_NAME_TEXTBOX, name, false);
			type(ELEMENT_PRODUCT_TITLE_TEXTBOX, title, false);
			click(ELEMENT_SAVE_CLOSE_BUTTON);
		}
		
		//add new Content Folder
		public static void createNewContentFolder(String title, String name) {
			click(ELEMENT_NEW_FOLDER_LINK);
			selectOption(ELEMENT_FOLDER_TYPE_OPTION,ELEMENT_CONTENT_FOLDER_TYPE);
			type(ELEMENT_FOLDER_TITLE_TEXTBOX, title, false);
//			waitForAndGetElement(ELEMENT_FOLDER_NAME_TEXTBOX).clear();
			type(ELEMENT_FOLDER_NAME_TEXTBOX, name, true);
			click(ELEMENT_SAVE_BUTTON);
		}
		
		//add new Document Folder
		public static void createNewDocumentFolder(String title, String name){
			click(ELEMENT_NEW_FOLDER_LINK);
			selectOption(ELEMENT_FOLDER_TYPE_OPTION, ELEMENT_DOCUMENT_FOLDER_TYPE);
			type(ELEMENT_FOLDER_TITLE_TEXTBOX, title, false);
//			waitForAndGetElement(ELEMENT_FOLDER_NAME_TEXTBOX).clear();
			type(ELEMENT_FOLDER_NAME_TEXTBOX, name, true);
			click(ELEMENT_SAVE_BUTTON);
		}
		
		//upload file
		public static void uploadFile(String fileName, String link){
			goToNode(ELEMENT_UPLOAD_LINK_XPATH);
			type(ELEMENT_UPLOAD_FILE_NAME_ID, fileName, false);
			driver.switchTo().frame(waitForAndGetElement(ELEMENT_UPLOAD_IMG_FRAME_XPATH));
			type(ELEMENT_UPLOAD_IMG_ID, getAbsoluteFilePath(link), false);
			info("Upload file "+getAbsoluteFilePath(link));
			switchToParentWindow();
			waitForElementPresent(ELEMENT_UPLOAD_FINISH_XPATH);
			click(ELEMENT_UPLOAD_SAVE_BUTTON_LINKTEXT);
			click(ELEMENT_UPLOAD_CLOSE_BUTTON_LINKTEXT);
		}
}
