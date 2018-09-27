package com.frank.store;

public class ObjectStore {

	public static final String Login_LoginFreeLink = "link=登录基础版";
	public static final String Login_LoginEntry = "link=基础版";
	public static final String Login_LoginTab_Username = "name=login_name";
	public static final String Login_LoginTab_Windowname = "登录 - Worktile";
	public static final String Login_LoginTab_Password = "name=login_password";
	public static final String Login_LoginTab_LoginButton = "xpath=//button[@type='button']";
	public static final String Home_ProductLink = "link=产品";
	public static final String Login_LoginTab_AD = "xpath=//*[@id='ng-app']/body/div[1]/div/div/div/div[1]/span/i";
	public static final String CreateTask_Button = "css=i.wtfont.wtf-create";

	// 任务页面

	// 元素定位
	// 我的
	public static final String my = "xpath=.//ul[@id='leftmenu_current']/li[1]/a/i";

	// 项目
	public static final String project = "xpath=.//ul[@id='leftmenu_current']/li[4]/a/i";

	// 快速新建
	public static final String shortcut_create = "xpath=.//*[@id='btn_leftmenu_shortcut_create']";

	// 项目
	public static final String person_project = "xpath=.//*[@id='ng-app']/body/div[6]/div/ul/li[1]/a";

	// 任务
	public static final String task = "xpath=.//*[@id='ng-app']/body/div[6]/div/ul/li[3]/a";

	// 日程
	public static final String schedule = "xpath=.//*[@id='ng-app']/body/div[6]/div/ul/li[4]/a";

	// 文件
	public static final String file = "xpath=.//*[@id='ng-app']/body/div[6]/div/ul/li[5]/a";

	// 新建日程页面

	// 元素定位
	// 日程内容
	public static final String schedule_content = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[1]/textarea";

	// 所属项目
	public static final String schedule_project = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[2]/div/a/span[2]";

	// 所属项目参数化
	public static final String schedule_project1 = "xpath=.//*[@id='ui-select-choices-0']/li/div/div[contains(text(),'ML09期')]";

	// 日程开始日期
	public static final String schedule_start_date = "name=start_date";

	// 日程开始日期2018-05-21
	public static final String schedule_start_date1 = "xpath=.//*[starts-with(@id,'dp')]/div/table/tbody/tr[4]/td[2]/a";

	// 日程开始时
	public static final String schedule_start_hour = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[3]/div/div[1]/span[2]/select[1]";

	// 日程开始分
	public static final String schedule_start_min = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[3]/div/div[1]/span[2]/select[2]";

	// 日程结束日期
	public static final String schedule_end_date = "name=end_date";

	// 日程结束日期2018-05-21
	public static final String schedule_end_date1 = "xpath=.//*[starts-with(@id,'dp')]/div/table/tbody/tr[4]/td[2]/a";

	// 日程结束时
	public static final String schedule_end_hour = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[3]/div/div[2]/span[2]/select[1]";

	// 日程结束分
	public static final String schedule_end_min = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[3]/div/div[2]/span[2]/select[2]";

	// 日程类型
	public static final String schedule_list = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[5]/select";

	// 日程位置
	public static final String schedule_location = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[4]/input";

	// 参与人
	public static final String schedule_assign_to = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[6]/ul/li[2]/a/span";
	public static final String schedule_assign_list = "name=search_user_input";
	public static final String schedule_assign_add = "class=avatar-name";

	// 保存
	public static final String schedule_add_submitBtn = "xpath=.//*[@id='ng-app']/body/div[1]/div/div/div/div[2]/form/div[7]/button[1]";

	// 关闭x
	public static final String schedule_close = "xpath=.//*[@id='wrap-all']/div[2]/div/ng-include/div/div[1]/ul/li[6]/a/i";

	// 日程显示页面
	public static final String scheduleForm = "xpath=.//*[@id='main']/div/div[2]/data-ui-view/ui-view/div/div[1]/div[1]/div/div[3]/ul/li[2]/a";

	//日程评论页面
	public static final String Search =".//*[@id='leftmenu_current']/li[2]/a/i";
	public static final String SearchContent =".//*[@id='the-search-input']";
	public static final String ScheduleCommentsArea =".//*[@id='wrap-all']/div[2]/div/ng-include/div/div[2]/div[2]/wt-item-comment-activity/div/div/div[1]/comment-list/div/div/wt-new-comment/div/textarea";
	public static final String ScheduleCommentsCommit =".//*[@id='wrap-all']/div[2]/div/ng-include/div/div[2]/div[2]/wt-item-comment-activity/div/div/div[1]/comment-list/div/div/wt-new-comment/div/div[2]/button";
	public static final String scheduleComments = "xpath=.//*[@id='wrap-all']/div[2]/div/ng-include/div/div[2]/div[2]/wt-item-comment-activity/div/div/div[1]/comment-list/div/ul/li/div/div[1]/div[1]/p";
	// 退出
	public static final String My_Avatar = "xpath=.//*[@id='btn_leftmenu_avatar_self']/span/img";
	public static final String Logout_Link = "link=退出登录";

	// 登陆相关 UI
	public static final String Login_LoginLink = "//*[contains(text(), '登录基础版')]";
	public static final String Login_Name = "name=login_name";
	public static final String Login_Password = "name=login_password";
	public static final String Login_Button = "//button[@type='button']";

	// 创建任务相关UI
	public static final String Quick_Create = "xpath=.//*[@id='btn_leftmenu_shortcut_create']/i";

	// APP端UI
	public static final String LoginInit1 = "name=稍后更新";
	public static final String LoginInit2 = "name=允许";
	
	public static final String LoginApp = "id=com.worktile:id/btn_login";
	public static final String LoginAppUserName = "id=com.worktile:id/et_username";
	public static final String LoginAppPassWord = "id=com.worktile:id/et_password";
	
	public static final String Init1 = "name=稍后更新";
	public static final String Init2 = "name=朕先歇会";
	
	
	public static final String CreateSchedule_Add = "id=com.worktile:id/actionbar_add";
	public static final String CreateSchedule_AddSchedule = "xpath=//android.widget.ListView/android.widget.LinearLayout[2]";
	public static final String CreateSchedule_ScheduleName = "class=android.support.v7.app.ActionBar$Tab";
	public static final String CreateSchedule_location = "id=com.worktile:id/et_desc";
	public static final String CreateSchedule_ProjectName = "id=com.worktile:id/layout_project_name";
	public static final String CreateSchedule_ProjectNameSelected = "xpath=//android.widget.RelativeLayout[@resource-id='com.worktile:id/layout_item']";
	public static final String CreateSchedule_AssigntoList = "id=com.worktile:id/layout_subscribers";
	public static final String CreateSchedule_IsSure = "id=com.worktile:id/btn_finish";
	public static final String CreateSchedule_StartDate = "id=com.worktile:id/layout_start";
	public static final String CreateSchedule_Ok = "id=com.worktile:id/ok";
	public static final String CreateSchedule_EndDate = "id=com.worktile:id/layout_end";
	public static final String CreateSchedule_Repeat="id=com.worktile:id/layout_repeat";
	public static final String CreateSchedule_Remind="id=com.worktile:id/layout_remind";
	public static final String CreateSchedule_Finish = "//android.widget.ImageButton[@content-desc='转到上一层级']";
	
	
	public static final String CreateSchedule_Comments="//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView[2]";
	public static final String CommentsApp ="学员_徐天_评论";
	
	public static final String Logout_More ="id=com.worktile:id/actionbar_more";
	public static final String Logout_More2 ="//android.widget.ListView/android.widget.LinearLayout[2]";
	public static final String Logout ="退出登录";

}