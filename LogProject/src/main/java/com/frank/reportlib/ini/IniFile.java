package com.frank.reportlib.ini;
import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;

import com.frank.reportlib.base.IFile;






public  class IniFile implements IFile
{
	//private String fileName = null;
	private String fileName = null;
	HierarchicalINIConfiguration ini =null;
	@Override
	public void createLog(String p_fileName) {
		// TODO Auto-generated method stub
		this.fileName = p_fileName;
		File file = new File(this.fileName);
		if (!file.exists())
		{
			try {
				file.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			ini = new HierarchicalINIConfiguration(this.fileName);
			ini.load(new File(this.fileName));	
			
			
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}


	@Override
	 public  void write(String section, String key, String value)
	 
	{  
		ini.setProperty(section+"."+key, value);
		
	}
	 @Override
	 public String read(String section, String key)
	 
	 {	
		 
		
		 return ini.getString(section+"."+key);
		
	 }
	 

	@Override
	public void write(String p_info) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void closeLog() {
		// TODO Auto-generated method stub
		try {
			ini.save();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fileName=null;
		this.ini=null;
		
	}


	@Override
	public void write(String p_info1, String p_info2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String read(String p_info) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void createLog(String p_file, boolean p_apped) {
		// TODO Auto-generated method stub
		
	}

	
}