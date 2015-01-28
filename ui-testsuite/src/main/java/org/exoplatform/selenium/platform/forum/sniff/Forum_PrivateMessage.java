package org.exoplatform.selenium.platform.forum.sniff;

import static org.exoplatform.selenium.TestLogger.info;

import org.testng.annotations.*;


	/**
	* @author eXo
	*
	*/
	public class Forum_PrivateMessage extends Forum_TestConfig{	
	/**
	*<li> Case ID:116755.</li>
	*<li> Test Case Name: Compose a private message.</li>
	*<li> Case ID:116756.</li>
	*<li> Test Case Name: Reply a message.</li>
	*/
	@Test
	public  void test01_02_ComposeAPrivate_ReplyMessage() {
		info("Test 1: Compose a private message");
		/*Step Number: 1
		*Step Name: Compose a message
		*Step Description: 
			- Login as john
			- Click on Private message
			- Click on tab Compose New message
			- Put value into fields, set "Send to" field mary
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- Message is sent to receivers
			- Message is listed at tab Sent Message*/

		/*Step number: 2
		*Step Name: Check inbox
		*Step Description: 
			- Login as mary
			- Click on Private message
			- Click on tab Inbox
		*Input Data: 
			
		*Expected Outcome: 
			- In tab Inbox, mary seemessage of john*/ 
		String contact = "mary";
		String title =  txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content =  txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToForum();
		foHome.goToPrivateMessage();
		msgManage.goComposeMessage();
		msgManage.writeMessage(contact, title, content);
		
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		
		hp.goToForum();
		foHome.goToPrivateMessage();
		msgManage.checkInboxMessage("john", title, content);
		
		info("Test 2: Reply a message");
		String newTitle = txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		msgManage.replyMessage("john", title, newTitle, content);
		magAc.signOut();
		magAc.signIn(DATA_USER1, DATA_PASS);
		
		hp.goToForum();
		foHome.goToPrivateMessage();
		msgManage.checkInboxMessage("mary", newTitle, content);
		
 	}

	/**
	*<li> Case ID:116757.</li>
	*<li> Test Case Name: Forward a message.</li>
	*<li> Case ID:116758.</li>
	*<li> Test Case Name: Delete a message.</li>
	*/
	@Test
	public  void test03_04_Forward_Delete_AMessage() {
		info("Test 3: Forward a message");
		/*Step Number: 1
		*Step Name: Prepare data: Send a message
		*Step Description: 
			- Login as mary
			- Send a private message to john
		*Input Data: 
			
		*Expected Outcome: 
			Message is sent to john*/

		/*Step number: 2
		*Step Name: Forward a message
		*Step Description: 
			- Click on tab "Sent Message", click on icon Forward
			- Put value to fields
			- Save
		*Input Data: 
			
		*Expected Outcome: 
			- In tab Sent Message, message of mary is shown
			-Forward message is sent to receivers. In tab Sent message, this message is listed.*/ 
		magAc.signOut();
		magAc.signIn(DATA_USER2, DATA_PASS);
		
		String contact = "john";
		String contactForward = "james";
		String title =  txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		String content =  txData.getContentByArrayTypeRandom(1)+getRandomNumber();
		
		hp.goToForum();
		foHome.goToPrivateMessage();
		msgManage.goComposeMessage();
		msgManage.writeMessage(contact, title, content);
		msgManage.goSendMessages();
		
		msgManage.goSendMessages();
		msgManage.forwardMessage(contact, title,contactForward, "", "");
		
		magAc.signOut();
		magAc.signIn(DATA_USER3, DATA_PASS);
		hp.goToForum();
		foHome.goToPrivateMessage();
		msgManage.checkInboxMessage("mary", "Forward:"+title, content);
		
		info("Test 4: Delete a message");
		msgManage.deleteMessage("Forward:"+title, "mary");
 	}

}