package com.frank.framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.frank.mail.MailEntry;
import com.frank.reportlib.entry.ReportEntry;
import com.frank.store.DataStore;
import com.frank.zip.ZipEntry;

public class CommonLib {
	private static String zipfilepath = null;

	public static String getCurrentTime() {

		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH);
		int day = ca.get(Calendar.DATE);
		int minute = ca.get(Calendar.MINUTE);
		int hour = ca.get(Calendar.HOUR);
		int second = ca.get(Calendar.SECOND);
		String currentTime = (String.valueOf(year) + "-" + String.valueOf(month + 1) + "-" + String.valueOf(day) + "-"
				+ String.valueOf(hour) + "-" + String.valueOf(minute) + "-" + String.valueOf(second));

		return currentTime;
	}

	public static String getCurrentDate() {
		Date time = new Date();
		SimpleDateFormat now = new SimpleDateFormat("yyyyMMdd_HH-mm-ss");
		String str = now.format(time);
		return str;
	}

	public static void sleep(int p_time) {

		try {
			Thread.sleep(p_time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static String readINIFile(String p_file,String p_section,String
	 * p_key){ ReportEntry re=new ReportEntry(); re.crateLog(p_file); Object
	 * myIniStr=re.read(p_section, p_key); re.closeLog(); return
	 * myIniStr.toString();
	 * 
	 * }
	 */

	public static String readINIFile(String p_file, String p_section, String p_key) {
		ReportEntry re = new ReportEntry();
		re.crateLog(p_file);
		return re.read(p_section, p_key);

	}

	public static String readINIFile1(String p_file, String p_section, String p_key) {
		String iniValue = null;
		try {
			ReportEntry re = new ReportEntry();
			re.crateLog(p_file);
			iniValue = re.read(p_section, p_key);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件读取错误！iniValue的值是：" + iniValue);
		}

		return iniValue;

	}

	public static void sendMail(String users[]) {
		System.out.println(zipfilepath);
		MailEntry me = new MailEntry();
		me.sendmail(users, zipfilepath);

	}

	public static void zipReport() {
		String includes = "*.html,*.css,screenshots/*.png";
		String excludes = "*.log";
		zipfilepath = DataStore.D_ArchivePath + File.separator + "MyReport-" + CommonLib.getCurrentTime() + ".zip";
		ZipEntry ze = new ZipEntry();
		ze.compress(zipfilepath, DataStore.D_LogPath, includes, excludes);

	}

}