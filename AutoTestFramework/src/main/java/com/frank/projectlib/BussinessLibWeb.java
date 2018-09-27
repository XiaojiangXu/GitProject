package com.frank.projectlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.frank.framework.CommonLib;
import com.frank.framework.RobotKeyboard;
import com.frank.store.DataStore;
import com.frank.store.ObjectStore;

public class BussinessLibWeb extends WebDriverLibExtension {
	WebDriver driver;
	public BussinessLibWeb(WebDriver driver){
		super();
	}

	// 登录，需要登录的用户名和密码
	public void login(String p_name, String p_password) {
		super.newClick(ObjectStore.Login_LoginFreeLink);
		super.newType(ObjectStore.Login_LoginTab_Username, p_name);
		super.newType(ObjectStore.Login_LoginTab_Password, p_password);
		super.newClick(ObjectStore.Login_LoginTab_LoginButton);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);

		// 判断是否有广告出现
		if (newIsElementPresent(ObjectStore.Login_LoginTab_AD)) // xpath元素是广告右上角的*
			super.newClick(ObjectStore.Login_LoginTab_AD);

	}

	// 项目页面
	public void ScheduleInit() {
		super.newClick(ObjectStore.shortcut_create);
		super.newClick(ObjectStore.schedule);

	}

	// 新增任务页面
	public void createSchedule(String p_scheduleContent, String p_location, String p_startdate, String p_starttime,
			String p_enddate, String p_endtime, String[] p_user, String p_isrepeated) {
		String[] st = null;
		String[] et = null;
		// 时间格式 10:30
		if (p_starttime.length() == 5 && p_starttime.contains(":")) {
			st = p_starttime.split(":");
		} else {
			System.out.println("错误的参数输入");
			return;
		}

		if (p_endtime.length() == 5 && p_endtime.contains(":")) {
			et = p_endtime.split(":");
		} else {
			System.out.println("错误的参数输入");
			return;
		}

		super.newType(ObjectStore.schedule_content, p_scheduleContent);
		super.newClick(ObjectStore.schedule_project);
		super.newClick(ObjectStore.schedule_start_date);
		super.newClick(ObjectStore.schedule_start_date1);
		//super.newClick(p_startdate);
		super.newSelect(ObjectStore.schedule_start_hour, st[0]);
		super.newSelect(ObjectStore.schedule_start_min, st[1]);
		super.newClick(ObjectStore.schedule_end_date);
		super.newClick(ObjectStore.schedule_end_date1);
		//super.newClick(p_enddate);
		super.newSelect(ObjectStore.schedule_end_hour, et[0]);
		super.newSelect(ObjectStore.schedule_end_min, et[1]);
		super.newType(ObjectStore.schedule_location, p_location);
		super.newSelect(ObjectStore.schedule_list, p_isrepeated);
		super.newClick(ObjectStore.schedule_assign_to);
		for (int i = 0; i < p_user.length; i++) {
			super.newType(ObjectStore.schedule_assign_list, p_user[i]);
			super.newClick(ObjectStore.schedule_assign_add);
			CommonLib.sleep(DataStore.D_Wait_MediumTime);
		}
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.schedule_add_submitBtn);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newClick(ObjectStore.schedule_close);

	}

	// 日历页面验证日程
	public void ScheduleVerify() {
		super.newClick(ObjectStore.scheduleForm);

	}

	// 退出，不需要参数
	public void logout() {
		super.newClick(ObjectStore.My_Avatar);
		super.newClick(ObjectStore.Logout_Link);
	}
	
	public void scheduleComments(String p_serchName,String p_xpathName, String p_comment) throws Exception {
		super.newClick(ObjectStore.Search);
		super.newType(ObjectStore.SearchContent, p_serchName);
		RobotKeyboard rk = new RobotKeyboard();
		rk.typeKey("Enter", 1);
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.driver.findElement(By.xpath(".//*[@id='the-search-result-frame']/dl/dd/div[2]/ul/li/div[2]/span/span[5][contains(text(),'"+ p_xpathName + "')]")).click();
		CommonLib.sleep(DataStore.D_Wait_MediumTime);
		super.newType(ObjectStore.ScheduleCommentsArea,p_comment);
		super.newClick(ObjectStore.ScheduleCommentsCommit);

	}


}
