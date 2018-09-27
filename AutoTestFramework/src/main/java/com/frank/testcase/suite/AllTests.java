package com.frank.testcase.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.frank.testcase.mobile.CommentsValidationApp;
import com.frank.testcase.mobile.CreateScheduleApp;
import com.frank.testcase.web.ScheduleCommentsWeb;



@RunWith(Suite.class)
@SuiteClasses({CreateScheduleApp.class,ScheduleCommentsWeb.class,CommentsValidationApp.class})
public class AllTests {
	
}
