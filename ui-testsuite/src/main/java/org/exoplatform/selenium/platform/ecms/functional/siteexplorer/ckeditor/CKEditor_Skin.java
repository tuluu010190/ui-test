package org.exoplatform.selenium.platform.ecms.functional.siteexplorer.ckeditor;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;


	/**
	* @author eXo
	*
	*/
	public class CKEditor_Skin{

	/**
	*<li> Case ID:119845.</li>
	*<li> Test Case Name: Change skin of CKEditor to Kama.</li>
	*/
	@Test(groups="pending")
	public  void test01_ChangeSkinOfCKEditorToKama() {
		info("Test 1: Change skin of CKEditor to Kama");
		/*Step Number: 1
		*Step Name: Configure package
		*Step Description: 
			- Go to ~/webapps/CommonsResources/eXoConfig.js
			- Edit line "config.skin = 'moono';" to "config.skin = 'kama';"
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			/eXoConfig.js is saved*/

		/*Step number: 2
		*Step Name: Start server
		*Step Description: 
			- Should delete the folder "WEB
			-INF" in "/work/Catalina/localhost/CommonsResources/"
			- Then restart server.
			- Clear Cache in browser.
		*Input Data: 
			
		*Expected Outcome: 
			- Server starts successfully*/

		/*Step number: 3
		*Step Name: Check skin of CKEditor in Site explorer 
		- Comment
		*Step Description: 
			- Go to CE
			- Open document
			- Click Comment on action bar
			- See skin editor
		*Input Data: 
			
		*Expected Outcome: 
			Skin is kama: colorful, see attachment*/

		/*Step number: 4
		*Step Name: Check skin of CKEditor in Site explorer 
		- new content
		*Step Description: 
			- Go to CE
			- Click [New Content] on action bar
			- Open template: Accessible breadcrum, acc navigation, acc search box, acc media, web content, illustrated web contentm announcement, file, html file, product
		*Input Data: 
			
		*Expected Outcome: 
			Skin is kama: colorful, see attachment*/ 

 	}

	/**
	*<li> Case ID:119844.</li>
	*<li> Test Case Name: Check default skin of CKEditor is moono.</li>
	*/
	@Test(groups="pending")
	public  void test02_CheckDefaultSkinOfCKEditorIsMoono() {
		info("Test 2: Check default skin of CKEditor is moono");
		/*Step Number: 1
		*Step Name: Start server and set up account
		*Step Description: 
			- Start a fresh package successfully
			- Setup new account
		*Input Data: 
			
		*Expected Outcome: 
			- Server starts successfully
			- Account is created*/

		/*Step number: 2
		*Step Name: Check default skin of CKEditor in Site explorer 
		- Comment
		*Step Description: 
			- Go to CE
			- Open document
			- Click Comment on action bar
			- See skin editor
		*Input Data: 
			
		*Expected Outcome: 
			Default skin is mono: black
			-white, see attachment*/

		/*Step number: 3
		*Step Name: Check default skin of CKEditor in Site explorer 
		- new content
		*Step Description: 
			- Go to CE
			- Click [New Content] on action bar
			- Open template: Accessible breadcrum, acc navigation, acc search box, acc media, web content, illustrated web content, announcement, file, html file, product
		*Input Data: 
			
		*Expected Outcome: 
			Default skin is mono: black
			-white*/ 

 	}}