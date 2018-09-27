package com.frank.reportlib.properties;

import java.io.File;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.frank.reportlib.base.IFile;



//关于Properties类常用的操作
public class PropertiesFile implements IFile {
  //根据Key读取Value
	 
	  File file;
	  String filePath=null;
	  PropertiesConfiguration config = new PropertiesConfiguration();
	  
	  @Override
	  public void createLog(String p_filePath){
		  this.filePath=p_filePath;
		  file = new File(this.filePath);
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
				config.load(new File(this.filePath));
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	  }

	  
	  public String read(String p_key){
		  	return config.getProperty(p_key).toString();
    	 
  }
  

	  public void write (String p_key, String p_value)  {
	  
		  	config.setProperty(p_key, p_value);
	  
//	  try {
//		config.save(new File(this.filePath));
//	} catch (ConfigurationException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	  
  }
    
      
   


@Override
public void write(String p_info) {
	// TODO Auto-generated method stub
	
}


@Override
public void write(String p_section, String p_key, String p_info) {
	// TODO Auto-generated method stub
	
}


@Override
public String read(String p_section, String p_key) {
	// TODO Auto-generated method stub
	return null;
}




@Override
public void closeLog()  {
	// TODO Auto-generated method stub
	File f=new File(this.filePath);
	
	try {
		config.save(f);
	} catch (ConfigurationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
//	try {
//		config.save();
//	} catch (ConfigurationException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	this.file=null;
	this.config=null;
	
	
}


@Override
public String read() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void createLog(String p_file, boolean p_apped) {
	// TODO Auto-generated method stub
	
}
    
  
}