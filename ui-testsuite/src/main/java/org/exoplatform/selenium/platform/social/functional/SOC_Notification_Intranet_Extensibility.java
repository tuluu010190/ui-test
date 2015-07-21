package org.exoplatform.selenium.platform.social.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


public class SOC_Notification_Intranet_Extensibility extends SOC_TestConfig2{

	/**
	 *<li> Case ID:125086.</li>
	 *<li> Test Case Name: Check Intranet Notification message are translatable via resource bundle..</li>
	 *<li> Pre-Condition: </li>
	 *<li> Post-Condition: </li>
	 *PENDING: Can not modify resource bundle
	 */
	@Test(groups="pending")
	public  void test01_CheckIntranetNotificationMessageAreTranslatableViaResourceBundle() {
		info("Test 1: Check Intranet Notification message are translatable via resource bundle.");
		/*Step Number: 1
		 *Step Name: Step 1: Translate resource bundle file
		 *Step Description: 
			- Extract package
			- Go to: webapp/social
			-notification
			-extension/WEB
			-INF/classes/locale/notification/template
			- Open file: Notification_fr.properties
		 *Input Data: 

		 *Expected Outcome: 
			- Resource bundle file is openned*/

		/*Step number: 2
		 *Step Name: Step 2: Translate resource bundle file
		 *Step Description: 
			- Change something in this file, for example:Replace UINotification.label.NewUserPlugin=Nouvel UtilisateurUINotification.title.NewUserPlugin=Quelqu'un se joint à Social Intranet
			- Save this file
		 *Input Data: 

		 *Expected Outcome: 
			- File is changed succesfully*/

		/*Step number: 3
		 *Step Name: Step 3: Check translation
		 *Step Description: 
			- Start server
			- Login
			- Change language to French
			- Go to Notification administration page
			- Go to Notification settings page
		 *Input Data: 

		 *Expected Outcome: 
			- You can see the translation for New user is: Nouvel Utilisateur
			- "Someone joins the social intranet" is translated to "Quelqu'un se joint à Social Intranet"*/ 

	}}