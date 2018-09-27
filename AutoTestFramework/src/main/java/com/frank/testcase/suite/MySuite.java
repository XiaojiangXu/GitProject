package com.frank.testcase.suite;



import com.frank.testcase.mobile.CreateScheduleApp;
import com.frank.testcase.web.ScheduleCommentsWeb;
import com.frank.framework.CommonLib;
import com.frank.testcase.mobile.CommentsValidationApp;


import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class MySuite {

	public static class TestSuite1 {
		public static Test suite() {
			TestSuite suite = new TestSuite("Test for package1");

			suite.addTest(new JUnit4TestAdapter(CreateScheduleApp.class));
			suite.addTest(new JUnit4TestAdapter(ScheduleCommentsWeb.class));
			suite.addTest(new JUnit4TestAdapter(CommentsValidationApp.class));
			// add other
			return suite;
		}
	}

	public static void main(String[] args) throws Exception {
		// checkinfo
		// HtmlFileGlobal.createLog("d:\\myReport4.html"); //生成全局的html日志
		junit.textui.TestRunner.run(TestSuite1.suite());
		// HtmlFileGlobal.closeLog(); //html日志关闭
		CommonLib.zipReport();
		String users[] = { "85281171@qq.com" };
		CommonLib.sendMail(users);
		// 建议写一个方法 清理文件目录，在 sendmail后 ，把日志目录以及 截屏目录中的文件全部干掉
		// 叫做clearEnv

	}

}
