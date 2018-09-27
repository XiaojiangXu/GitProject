package com.frank.projectlib;

import org.openqa.selenium.By;

import com.frank.framework.CommonLib;
import com.frank.store.DataStore;
import com.frank.store.ObjectStore;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class BussinessLibAndroid extends AndroidDriverLibExtension {

	AndroidDriver<MobileElement> driver;

	public BussinessLibAndroid(AndroidDriver<MobileElement> driver) {
		super();
	}

	public void login(String p_user, String p_password) {

		try {
			super.newClick(ObjectStore.LoginInit1);
		} catch (Exception e) {
		}
		/*
		try {
			super.newClick(ObjectStore.LoginInit2);
		} catch (Exception e) {

		}*/
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		// *******判断是否登陆成功
		if (super.newElement(ObjectStore.CreateSchedule_Add)) {
			CommonLib.sleep(DataStore.D_Wait_MediumTime);
			return; // 表示方法执行完毕
		} else {

			CommonLib.sleep(DataStore.D_Wait_MediumTime);
			super.newClick(ObjectStore.LoginApp);
			super.newType(ObjectStore.LoginAppUserName, p_user);
			super.newType(ObjectStore.LoginAppPassWord, p_password);
			super.newClick(ObjectStore.LoginApp);
			try {
				super.newClick(ObjectStore.Init1);
			} catch (Exception e) {
			}

		}

		/*try {
			super.newClick(ObjectStore.Init2);
		} catch (Exception e) {

		}*/
		CommonLib.sleep(DataStore.D_Wait_MediumTime);

	}

	public void createSchedule(String p_scheduleName, String p_location, String p_projectName, String[] p_assigntoList,
			String p_beginDate, String p_endDate, String p_repeat, String p_remind) {
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.CreateSchedule_Add);
		super.newClick(ObjectStore.CreateSchedule_AddSchedule);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newType(ObjectStore.CreateSchedule_ScheduleName, p_scheduleName);
		super.newType(ObjectStore.CreateSchedule_location, p_location);
		super.newClick(ObjectStore.CreateSchedule_ProjectName);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.CreateSchedule_ProjectNameSelected);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.CreateSchedule_AssigntoList);
		for (int i = 0; i < p_assigntoList.length; i++) {
			super.newfindElementByAndroidUIAutomator(p_assigntoList[i]);
		}
		super.newClick(ObjectStore.CreateSchedule_IsSure);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.CreateSchedule_StartDate);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.driver.findElement(By.xpath("//android.view.View[@content-desc=" + "'" + p_beginDate + " 六月 2018']")).click();
		super.newClick(ObjectStore.CreateSchedule_Ok);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.CreateSchedule_EndDate);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.driver.findElement(By.xpath("//android.view.View[@content-desc=" + "'已选择 " + p_endDate + " 六月 2018']")).click();
		super.newClick(ObjectStore.CreateSchedule_Ok);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newSelect(ObjectStore.CreateSchedule_Repeat,p_repeat);
		super.newSelect(ObjectStore.CreateSchedule_Remind, p_remind);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.CreateSchedule_Finish);
	}
	
	public void commentsApp(){
		super.newClick(ObjectStore.CreateSchedule_Comments);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newfindElementByAndroidUIAutomator(ObjectStore.CommentsApp);
	}

	public void logout() {
		super.driver.pressKeyCode(AndroidKeyCode.BACK); //点击back键
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.Logout_More);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.Logout_More2);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newfindElementByAndroidUIAutomator(ObjectStore.Logout);

	}

}
