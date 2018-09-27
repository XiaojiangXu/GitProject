package com.frank.reportlib.html;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

//import java.util.logging.SimpleFormatter;

public class HtmlReportFormatter extends Formatter {

	
	private int i=0;
	private long setStartTime; // log开始时间
	private long setEndTime; // log结束时间 

	private final String HTML_HEADER = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"
			+ "<META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">"
			+ "<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">"
			+ "<link rel=\"stylesheet\" href=\"report_style.css\"/>"
			+ "<html><head><title>测试报告</title></head>"
			+ "<body>"
			+ "<div class=\"page_title\"><center>"
			//+ "<h1>测试报告:"+buff.append(titleNo())+"</h1></center></div>"
			+ "<h1>测试报告</h1></center></div>"
			+ "<div class=\"statistics\"><table id=\"statistics_table\" class=\"sortable\" align=\"center\" border=\"0\"  style=\"width:100%;\"><tr>"
			+ "<th><b>序号</b></th>"
			+ "<th><b>用例描述</b></th>"
			+ "<th><b>期待结果</b></th>"
			+ "<th><b>实际结果</b></th>"
			+ "<th><b>执行时间</b></th>" + "<th><b>状态</b></th>" + "</tr>";
	
	private int recordStep() {
		i = i + 1;
		return i;
	}

	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING
		buf.append("<div class=\"statistics\">");
		buf.append("<tr>");
		buf.append("<td>");
		buf.append(recordStep());
		buf.append("</td>");
		buf.append("<td>");
		// buf.append(calcDate(rec.getMillis()));
		// buf.append(' ');
		buf.append(formatMessage(rec));
		buf.append('\n');
		buf.append("</td>");
		buf.append("<td>");
		buf.append(RecordStore.expected);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(RecordStore.actual);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(HtmlUtil.getCalcDate(rec.getMillis()));
		buf.append("</td>");
		buf.append("<td>");
		if (RecordStore.result.matches("Pass")||RecordStore.result.matches("PASS")) {
			//RecordStore.result.equalsIgnoreCase(anotherString) //忽略大小写
			RecordStore.p_pass = RecordStore.p_pass + 1;
			buf.append("<b>");
			buf.append("<font color=Green>");
			buf.append(RecordStore.result);
			buf.append("</font>");
			buf.append("</b>");
		} else if (RecordStore.result.matches("Fail")||RecordStore.result.matches("FAIL")) {
			RecordStore.p_fail = RecordStore.p_fail + 1;
			//buf.append("<a href=" + WebDriverLib.screenShot() + ">");
			//buf.append("<a href=" + AppiumLibAndroid.screenshot() + ">");
			//buf.append("<a href=" + RecordStore.screenshot + ">");
			buf.append("<a href=" + HtmlFile.getScreenshot().substring(72) + ">");
			buf.append("<b>");
			buf.append("<font color=Red>");
			buf.append(RecordStore.result);
			buf.append("</font>");
			
			buf.append("</b>");
		
			/*	
			//在report中加截图后，定义的html文件格式
			buf.append("<tr>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("<a href=getScreenShotPath()><img src=getScreenShotPath() height=\"150\" /></a>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("</tr>");
			
		*/
		}
		else{
			buf.append("<b>");
			// buf.append("<font color=Black>");
			buf.append("");
			buf.append("</b>");
			
		}
		buf.append("</td>");
		buf.append("</tr>");
		buf.append("</div>\n");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return buf.toString();
	}

	
	public String getHead(Handler h)

	{
		this.setStartTime = System.currentTimeMillis();
		System.out.println("starttime: "+this.setStartTime);
		return HTML_HEADER;
	}


	public String getTail(Handler h)

	{
		this.setEndTime = System.currentTimeMillis();
		System.out.println("endtime: "+this.setEndTime);
		String HTML_Tail;
		int p_total = RecordStore.p_pass + RecordStore.p_fail;
		//System.out.println(p_total);
		if (p_total > 0)
			if (RecordStore.p_fail > 0)
				// return HTML_Tail;
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;开始时间   ："+ HtmlUtil.getCalcDate(this.setStartTime) 
				        + "<br>&nbsp;结束时间      ："+ HtmlUtil.getCalcDate(this.setEndTime) 
				        + "<br>&nbsp;运行时间      ："+ HtmlUtil.getDeltaTime(this.setEndTime, this.setStartTime)
						+ "<br>&nbsp;执行用例      ：" + p_total 
						+"<br>&nbsp;用例成功         ："+ RecordStore.p_pass
						+ "<br>&nbsp;<font color=Red>用例失败      ："+ RecordStore.p_fail + "</font>" 
						+ "<br>&nbsp;成功率(%) ："+ HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
						+ "<br>&nbsp;<font color=Red>失败率(%) ："+ HtmlUtil.getPercnet(RecordStore.p_fail, p_total) + "</font>" 
						+ "<br><br>"
						+ "</BODY></HTML>";
			else
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;开始时间   ："
						+ HtmlUtil.getCalcDate(this.setStartTime) + "<br>&nbsp;结束时间   ："
						+ HtmlUtil.getCalcDate(this.setEndTime) + "<br>&nbsp;运行时间   ："
						+ HtmlUtil.getDeltaTime(this.setEndTime, this.setStartTime)
						+ "<br>&nbsp;执行用例      ：" + p_total 
						+ "<br>&nbsp;用例成功      ："+ RecordStore.p_pass 
						+ "<br>&nbsp;用例失败      ：" + RecordStore.p_fail
						+ "<br>&nbsp;成功率(%) ：" + HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
						+ "<br>&nbsp;失败率(%) ：" + HtmlUtil.getPercnet(RecordStore.p_fail, p_total)
						+ "<br><br>"
						+ "</BODY></HTML>";
		else
			HTML_Tail = "</table></PRE>" + "<br>&nbsp;用例执行异常！" + "<br><br>"
					+ "</BODY></HTML>";

		return HTML_Tail;
	}

	

}
