package com.frank.reportlib.html;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlUtil {
	public static String getPercnet(double p_numerator, double p_denominator) {
		double percent = p_numerator / p_denominator;
		NumberFormat nt = NumberFormat.getPercentInstance();
		// 设置百分数精确度2即保留两位小数
		nt.setMinimumFractionDigits(1);
		return nt.format(percent);

	}

	public static String getCalcDate(long millisecs) {
		SimpleDateFormat date_format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date resultdate = new Date(millisecs);
		return date_format.format(resultdate);
	}
	
	public static String formatCurrentTime(){
		SimpleDateFormat date_format = new SimpleDateFormat(
				"yyyy_MM_dd_HH_mm_ss");
		Date resultdate = new Date(System.currentTimeMillis());
		return date_format.format(resultdate);
	}

	public static String getDeltaTime(long p_startTime, long p_endTime) {
		long day = (p_endTime - p_startTime) / (24 * 60 * 60 * 1000);
		long hour = ((p_endTime - p_startTime) / (60 * 60 * 1000) - day * 24);
		long min = (((p_endTime - p_startTime) / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = ((p_endTime - p_startTime) / 1000 - day * 24 * 60 * 60 - hour
				* 60 * 60 - min * 60);

		return day + "天" + hour + "小时" + min + "分" + s + "秒";
	}
	
     public static void sleep(int p_time){
		
		try {
			Thread.sleep(p_time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
