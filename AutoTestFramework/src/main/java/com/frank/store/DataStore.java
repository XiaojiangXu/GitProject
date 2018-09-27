package com.frank.store;

import java.io.File;

import com.frank.framework.CommonLib;

//与外部文件的一个接口
public class DataStore {	
	public static String D_Username="85281171@qq.com";
	public static String D_Username2=CommonLib.readINIFile(System.getProperty("user.dir")+File.separator+"config"+File.separator+"config.ini", "base", "username");
	public static String D_Password="123456";
	public static String D_URL="https://my.worktile.com";
	public static String D_Browser="Chrome";
	public static String D_Browser2=CommonLib.readINIFile(System.getProperty("user.dir")+File.separator+"config"+File.separator+"config.ini", "browser", "useBrowser");
	public static int D_Wait_ShortTime=Integer.parseInt(CommonLib.readINIFile1(System.getProperty("user.dir")+File.separator+"config"+File.separator+"config.ini", "waittime", "shortTime"));
	public static int D_Wait_MediumTime=5;
	public static int D_Wait_LongTime=10;
	public static String D_ArchivePath=System.getProperty("user.dir")+File.separator+"log"+File.separator+"zip";
	public static String D_LogPath=System.getProperty("user.dir")+File.separator+"log"+File.separator+"loggingResults";
	public static String D_ScreenShotPath=System.getProperty("user.dir")+File.separator+"log"+File.separator+"loggingResults"+File.separator+"screenshots";
	public static String D_DebugLogger="DebugLogger";
	//Android
	public static String D_deviceName="emulator-5554";
	public static String D_platformName="Android";
	public static String D_appPackage="com.worktile";
	public static String D_appActivity=".ui.external.WelcomeActivity";

	



}
