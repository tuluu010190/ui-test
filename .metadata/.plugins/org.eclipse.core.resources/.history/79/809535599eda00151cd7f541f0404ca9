package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


	public class CAL_Activity_Event_Activity_Actions extends CAL_TestConfig{

	/**
	*<li> Case ID:116247.</li>
	*<li> Test Case Name: Dislike a Calendar activity from like icon.</li>
	*<li> Pre-Condition: - Create a space with calendar app
	- Create an event to a space calendar in order to create a calendar activity
	- User A is member of space</li>
	*<li> Post-Condition: </li>
	*/
	@Test
	public  void test01_DislikeACalendarActivityFromLikeIcon() {
		info("Test 1: Dislike a Calendar activity from like icon");
		/*Step Number: 1
		*Step Name: Like activity
		*Step Description: 
			- Connect to Intranet with User A
			- Click on [Like] icon of this calendar activity
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar activity is displayed in the activity stream: number of likes to 1*/

		String space = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String contentSpace=txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToMySpaces();
		info("create new space");
		spaMg.addNewSpaceSimple(space,contentSpace,60000);
		
		String newEvent1= txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		evMg.goToAddEventFromActionBar();
		evMg.inputBasicQuickEvent(newEvent1,newEvent1);
		evMg.saveQuickAddEvent();
		
		hp.goToHomePage();
		hpAct.likeActivity(newEvent1);
		
		/*Step number: 2
		*Step Name: Dislike activity
		*Step Description: 
			- Click on [Like] icon again
		*Input Data: 
			
		*Expected Outcome: 
			- The Calendar activity is disliked by the user, the number of like is updated to 
			-1*/ 
		hpAct.unlikeActivity(newEvent1);
		
		info("Delete Data");
		hp.goToSpecificSpace(space);
		spaMg.goToAgendaTab();
		cMang.deleteTaskEvent(newEvent1);
 	}}