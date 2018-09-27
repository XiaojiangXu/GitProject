package com.frank.reportlib.entry;

import com.frank.reportlib.base.IFile;
import com.frank.reportlib.html.HtmlFile;
import com.frank.reportlib.ini.IniFile;
import com.frank.reportlib.log.LogFile;
import com.frank.reportlib.properties.PropertiesFile;
import com.frank.reportlib.txt.TxtFile;

public class ReportEntry {
	
	IFile myFile;
	//String fileName;

	
	
	public void crateLog(String p_file){
		if (p_file.endsWith(".ini"))
			 myFile =new IniFile();
		else if (p_file.endsWith(".properties"))
			 myFile =new PropertiesFile();
		else if (p_file.endsWith(".html")) 	
			 myFile =new HtmlFile();
		else if (p_file.endsWith(".txt"))
			 myFile =new TxtFile();
		else if (p_file.endsWith(".log"))
			 myFile =new LogFile();
		else 
			myFile=null;	
		
		if (myFile!=null){
			myFile.createLog(p_file);
		}
			
		else
		{
			System.out.println("不支持的文件类型");
			System.exit(0);
		}
	}
	
	public void crateAppedLog(String p_file,boolean p_apped){
		if (p_file.endsWith(".ini"))
			 myFile =new IniFile();
		else if (p_file.endsWith(".properties"))
			 myFile =new PropertiesFile();
		else if (p_file.endsWith(".html")) 	
			 myFile =new HtmlFile();
		else if (p_file.endsWith(".txt"))
			 myFile =new TxtFile();
		else if (p_file.endsWith(".log"))
			 myFile =new LogFile();
		else 
			myFile=null;	
		
		if (myFile!=null){
			myFile.createLog(p_file,p_apped);
		}
			
		else
		{
			System.out.println("不支持的文件类型");
			System.exit(0);
		}
	}
	
	public void closeLog(){
		myFile.closeLog();
	}
	
	public void write(String p_info){
		myFile.write(p_info);
	}

	
	public void write(String p_info1,String p_info2){
		myFile.write(p_info1,p_info2);
	}
	
	public void write(String p_info1,String p_info2,String p_info3){
		myFile.write(p_info1,p_info2,p_info3);
	}
	
	public String read(String p_key){
		return myFile.read(p_key).toString();
	}
	
	public String read(String p_section,String p_key){
		return myFile.read(p_section,p_key);
	}
	
	

}
