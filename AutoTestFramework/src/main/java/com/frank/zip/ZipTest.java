package com.frank.zip;

import java.io.File;

import com.frank.framework.CommonLib;
import com.frank.store.DataStore;

public class ZipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String includes = "*.html,*.css,screenshots/*.png";
		String excludes = "*.log";
		String zipfilepath = DataStore.D_ArchivePath + File.separator + "MyReport-" + CommonLib.getCurrentTime() + ".zip";
		ZipEntry ze = new ZipEntry();
		ze.compress(zipfilepath, DataStore.D_LogPath, includes, excludes);
		//ze.runCompress(System.getProperty("user.dir"),DataStore.D_Log+File.separator+"zip");
	}

}
