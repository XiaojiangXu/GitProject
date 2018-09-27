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
public class CreateScheduleApp {
	String testCase = "testcase_CreateScheduleApp";
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
	public void testcase_CreateSchedule() throws Exception {

		bussinessLibAndroid.login("85281171@qq.com", "xxj1125");
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		bussinessLibAndroid.newVerifyEquals("VP_loginApp", true,bussinessLibAndroid.newIsElementPresent(VPStore.VP_loginApp));

		String[] p_assigntoList = { "ml0tester" };
		bussinessLibAndroid.createSchedule("ML0九期android考试_徐晓江", "天津", "ML0九期", p_assigntoList, "01", "02","不重复","否");
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		bussinessLibAndroid.newVerifyEquals("VP_CreateScheduleApp", "ML0九期android考试_徐晓江",bussinessLibAndroid.newElements(VPStore.VP_ScheduleApp));

		bussinessLibAndroid.logout();
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		bussinessLibAndroid.newVerifyEquals("VP_logoutApp", true,bussinessLibAndroid.newIsElementPresent(VPStore.VP_logoutApp));

	}

}
