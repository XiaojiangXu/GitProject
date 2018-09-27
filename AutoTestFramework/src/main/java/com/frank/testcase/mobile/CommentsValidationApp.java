package com.frank.testcase.mobile;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.frank.framework.CommonLib;
import com.frank.projectlib.BussinessLibAndroid;
import com.frank.store.DataStore;
import com.frank.store.VPStore;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommentsValidationApp {
	String testCase = "testcase_CommentsValidationApp";
	static AndroidDriver<MobileElement> driver;
	static BussinessLibAndroid bussinessLibAndroid = new BussinessLibAndroid(driver);

	@Before
	public void setUp() throws Exception {
		bussinessLibAndroid.newSetup(testCase);
	}

	@After
	public void tearDown() throws Exception {
		bussinessLibAndroid.newTeardown();

	}

	@Test
	public void testcase_CommentsValidation() throws Exception {

		bussinessLibAndroid.login("85281171@qq.com", "123456");
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		bussinessLibAndroid.newVerifyEquals("VP_loginApp", true,bussinessLibAndroid.newIsElementPresent(VPStore.VP_loginApp));

		bussinessLibAndroid.commentsApp();
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		bussinessLibAndroid.newVerifyEquals("VP_CreateScheduleApp", "徐天_评论",bussinessLibAndroid.newElements(VPStore.VP_CommentsApp));

		bussinessLibAndroid.logout();
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		bussinessLibAndroid.newVerifyEquals("VP_logoutApp", true,bussinessLibAndroid.newIsElementPresent(VPStore.VP_logoutApp));
	}

}
