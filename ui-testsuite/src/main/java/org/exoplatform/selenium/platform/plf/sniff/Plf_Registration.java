package org.exoplatform.selenium.platform.plf.sniff;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;


	public class Plf_Registration{

	/**
	*<li> Case ID:120907.</li>
	*<li> Test Case Name: Verify portal screen at the first to start trial package.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test (groups="pending")
	public  void test01_VerifyPortalScreenAtTheFirstToStartTrialPackage() {
		info("Test 1: Verify portal screen at the first to start trial package");
		/*Step Number: 1
		*Step Name: -Step 1: Verify screen At the first start page layout
		*Step Description: 
			- Launch the server with trial package for the first time
			- Go to http://localhost:8080/portal/
			- Input valid value to create user
			- Check evaluation days at the bottom
			- Click [By a subscription] at the bottom
		*Input Data: 
			
		*Expected Outcome: 
			- Display "You have 30 day(s) left in your evaluation".
			-The buy subscription page is shownwith 5 main links: 
			- subscription plan
			- Request a key
			- Unlock
			- info@exoplatform.com 
			- www.exoplatform.com*/

		/*Step number: 2
		*Step Name: Step 2: Click subscription plan link
		*Step Description: 
			- Click subscription plan
		*Input Data: 
			
		*Expected Outcome: 
			-The first start page is shown
			-The page "edition" is displayed*/

		/*Step number: 3
		*Step Name: Step 3: Click Request a key link
		*Step Description: 
			- Click Request a key link
		*Input Data: 
			
		*Expected Outcome: 
			-The first start page is shown
			-The mailing page is shown*/

		/*Step number: 4
		*Step Name: Step 4: Clickinfo@exoplatform.comlink
		*Step Description: 
			- Clickinfo@exoplatform.com link
		*Input Data: 
			
		*Expected Outcome: 
			- The mail to page is displayed*/

		/*Step number: 5
		*Step Name: Step 5: Clickwww.exoplatform.com link
		*Step Description: 
			- Clickwww.exoplatform.com link
		*Input Data: 
			
		*Expected Outcome: 
			-The exo official site is shown*/ 

 	}

	/**
	*<li> Case ID:120909.</li>
	*<li> Test Case Name: Verify portal page with 29 days left..</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/

	@Test(groups="pending")
	public  void test02_VerifyPortalPageWith29DaysLeft() {
		info("Test 2: Verify portal page with 29 days left.");
		/*Step Number: 1
		*Step Name: Step 1: Verify trial portalpage with 29 days Left.
		*Step Description: 
			- Clear your browsing data (cookie, cache)
			- Setup your system date with +1 day from current day
			- Restart the server 
			- Go to localhost:8080/portal/
		*Input Data: 
			
		*Expected Outcome: 
			- Trial portal page is displayed
			-The counter indicates that you have 29 days left*/ 

 	}

	/**
	*<li> Case ID:120910.</li>
	*<li> Test Case Name: Verify portal page with 15 days left.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test(groups="pending")
	public  void test03_VerifyPortalPageWith15DaysLeft() {
		info("Test 3: Verify portal page with 15 days left");
		/*Step Number: 1
		*Step Name: Step 1: Verify portal page with 15 days left
		*Step Description: 
			- Now Clear your browsing data (cache, cookie)
			- Setup your system time with +15 days from current day
			- Restart the server 
			- Go to localhost:8080/portal/
		*Input Data: 
			
		*Expected Outcome: 
			- Trial portal page is displayed
			-The counter indicates that you have 15 days left*/ 

 	}

	/**
	*<li> Case ID:120911.</li>
	*<li> Test Case Name: Verify portal page with 0 days left..</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test(groups="pending")
	public  void test04_VerifyPortalPageWith0DaysLeft() {
		info("Test 4: Verify portal page with 0 days left.");
		/*Step Number: 1
		*Step Name: Step 1: Verify portal page with 0 day left.
		*Step Description: 
			- Now Clear your browsing data (cookie, cache)
			- Setup your system date with +30 days from current day
			- Restart the server 
			- Go to localhost:8080/portal/
		*Input Data: 
			
		*Expected Outcome: 
			- Trial portal page is displayed
			-The counter indicates that you have 0 day left*/ 

 	}

	/**
	*<li> Case ID:120912.</li>
	*<li> Test Case Name: Unlock trial version with invalid/valid key.</li>
	*<li> Pre-Condition: To get the valid key, using: trial
	-evaluation
	-key
	-generator tool, input product code in this tool and generate the valid key</li>
	*<li> Post-Condition: </li>
	*/
	@Test(groups="pending")
	public  void test05_UnlockTrialVersionWithInvalidvalidKey() {
		info("Test 5: Unlock trial version with invalid/valid key");
		/*Step Number: 1
		*Step Name: Step 1: Verify submit invalid product key
		*Step Description: 
			- Click buy a susbcriptionOn unlock Evaluation screen :
			- Enter invalid unlock key
			- Click Unlock
		*Input Data: 
			
		*Expected Outcome: 
			- A message is displayed: Sorry this evaluation key is not valid*/

		/*Step number: 2
		*Step Name: Step 2: Verify submit valid product key
		*Step Description: 
			On unlock Evaluation screen :
			- Enter valid unlock key
		*Input Data: 
			
		*Expected Outcome: 
			- Redirects to the original url (the one where the user was when he clicked on Remove banner button, in this case Intranet Home page)*/ 

 	}}