package org.exoplatform.selenium.platform.plf.sniff;

import static org.exoplatform.selenium.TestLogger.info;
import org.testng.annotations.*;


	public class Plf_TermAndCondition extends Plf_TestConfig{

	/**
	*<li> Case ID:120908.</li>
	*<li> Test Case Name: Show/Hide the terms and Conditions agreement.</li>
	*<li> Pre-Condition: </li>
	*<li> Post-Condition: </li>
	*/
	@Test (groups="pending")
	public  void test01_ShowHideTheTermsAndConditionsAgreement() {
		info("Test 1: Show/Hide the terms and Conditions agreement");
		/*Step Number: 1
		*Step Name: Step 1: Show terms and conditionsAgreement at first start
		*Step Description: 
			- Launch the server with packaging for the first time
			- Go to localhost:8080/portal/
			- Check the « I agree with this terms and conditions agreement » checkbox
			- Click on continue
		*Input Data: 
			
		*Expected Outcome: 
			- Server is started
			- The terms and conditions agreement is shown
			-The « I agree with this terms and conditions agreement » checkbox is Checked.
			-The page to sign up new user is shown*/

		/*Step number: 2
		*Step Name: Step 2: Hide terms and conditionsAgreement at second start
		*Step Description: 
			- Restart server
			- Go to localhost:8080/portal/
		*Input Data: 
			
		*Expected Outcome: 
			- Server is restarted
			-The terms and conditions agreement is not shown, you will be redirectedStraight to the sign up new user page*/ 

 	  }
	}