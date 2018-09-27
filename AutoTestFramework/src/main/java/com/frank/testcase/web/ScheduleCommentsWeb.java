package com.frank.testcase.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.frank.projectlib.BussinessLibWeb;
import com.frank.store.ObjectStore;
import com.frank.store.VPStore;

public class ScheduleCommentsWeb {

	String testCase = "testcase_ScheduleCommentsWeb";
	static WebDriver driver;
	static BussinessLibWeb bussinessLibWeb = new BussinessLibWeb(driver);

	@Before
	public void setUp() throws Exception {
		
		bussinessLibWeb.newSetup(testCase);

	}

	@Test
	public void testcase_ScheduleComments() throws Exception {

		bussinessLibWeb.login("85281171@qq.com", "123456");
		bussinessLibWeb.newVerifyEquals("VP_Login", true, bussinessLibWeb.newIsElementPresent(VPStore.VP_Login));
		
		bussinessLibWeb.scheduleComments("日程_徐天", "徐天", "徐天_评论");
		bussinessLibWeb.newVerifyEquals("徐天_评论", "徐天_评论", bussinessLibWeb.newWebElement(ObjectStore.scheduleComments));
		
		bussinessLibWeb.logout();
		bussinessLibWeb.newVerifyEquals("VP_Logout", true, bussinessLibWeb.newIsElementPresent(VPStore.VP_Logout));
	}

	@After
	public void tearDown() throws Exception {
		
		bussinessLibWeb.newTeardown();

	}
}
