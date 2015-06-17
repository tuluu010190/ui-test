package org.exoplatform.selenium.platform.calendar.functional;

import static org.exoplatform.selenium.TestLogger.info;

import org.exoplatform.selenium.Button;
import org.exoplatform.selenium.Utils;
import org.exoplatform.selenium.platform.HomePagePlatform;
import org.exoplatform.selenium.platform.ManageLogInOut;
import org.exoplatform.selenium.platform.PlatformBase;
import org.exoplatform.selenium.platform.calendar.CalendarHomePage;
import org.exoplatform.selenium.platform.calendar.CalendarManagement;
import org.exoplatform.selenium.platform.calendar.EventManagement;
import org.exoplatform.selenium.platform.calendar.TaskManagement;
import org.exoplatform.selenium.platform.calendar.CalendarManagement.menuOfMainCalendar;
import org.exoplatform.selenium.platform.objectdatabase.common.TextBoxDatabase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CAL_TestConfig_3 extends PlatformBase {
	HomePagePlatform hp;
	ManageLogInOut magAc;
	Button button;

	EventManagement evMg;
	TaskManagement tasMg;
	CalendarManagement cMang;
	CalendarHomePage cHome;
	
	TextBoxDatabase txData;
	String calendar;
	
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlUser);
		magAc = new ManageLogInOut(driver);
		button = new Button(driver);
		magAc.signIn(DATA_USER1, DATA_PASS);
		Utils.pause(2000);
		
		hp = new HomePagePlatform(driver);
		evMg = new EventManagement(driver);
		cMang = new CalendarManagement(driver);
		cHome = new CalendarHomePage(driver);
		tasMg = new TaskManagement(driver);
		
		txData = new TextBoxDatabase();
		txData.setContentData(texboxFilePath,defaultSheet,isUseFile,jdbcDriver,dbUrl,user,pass,sqlAttach);
		
		calendar="no calendar";
		
		hp.goToCalendarPage();		
		cMang.goToMenuFromMainCalendar(menuOfMainCalendar.CALSETTING);
		cMang.changeSettingCalendar(null,"(GMT +07:00) Asia/Ho_Chi_Minh",null,null,null,null,null);
		cMang.saveSetting();
		
		info("End setUpBeforeMethod");
	}

	@AfterMethod
	public void afterMethod(){
		info("Start afterMethod");
		hp.goToCalendarPage();
		cMang.deleteCalendar(calendar);
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End afterMethod");
	}
	
	

}
