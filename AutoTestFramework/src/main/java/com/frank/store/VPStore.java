package com.frank.store;

public class VPStore {
	
	// 登陆相关 UI
	public static final String VP_Login = "//*[@id='btn_leftmenu_shortcut_create']/i";
	
	
	//创建日程相关UI

	public static final String VP_CreateSchedule = ".//*[@id='calendar']/div/div/table/tbody/tr/td/div/div/div[4]/div[2]/table/tbody/tr[3]/td[starts-with(@class,'fc-event-container')]/a/div/span[2][contains(text(),'ML0九期架构练习_徐天')]";

	// 登陆相关 UI
		public static final String VP_Logout = "link=登录基础版";
		
	//App
	public static final String VP_loginApp = "id=com.worktile:id/actionbar_add";
	public static final String VP_ScheduleApp = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView[2]";
	public static final String VP_logoutApp ="id=com.worktile:id/btn_login";
	public static final String VP_CommentsApp ="id=com.worktile:id/tv_content";
}
