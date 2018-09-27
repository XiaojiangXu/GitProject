package com.frank.zip;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipEntry {
	public void compress(String p_zipName,String p_zipLocation,String includes,String excludes){
		File zipFile = new File(p_zipName);
		File srcdir = new File(p_zipLocation);
		if (!srcdir.exists())
			throw new RuntimeException(p_zipLocation + "不存在！");
		Project prj = new Project();
		Zip zip = new Zip();
		zip.setEncoding("gbk");
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		fileSet.setIncludes(includes);
		fileSet.setExcludes(excludes);
		zip.addFileset(fileSet);
		zip.execute();
	}
	
	public void runCompress(String zipDir, String backUpDir) {
		File zipDirFile = new File(zipDir);
		File backUpDirFile = new File(backUpDir);
		for (File f : zipDirFile.listFiles()) {
			if (f.isFile() && f.getName().endsWith(".zip")) {
				try {
					FileUtils.copyFileToDirectory(f, backUpDirFile, true);
					FileUtils.deleteQuietly(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	
	public void compressFull(String zipName, String zipLocation) {

		File zipFile = new File(zipName);
		File srcdir = new File(zipLocation);
		Project prj = new Project();
		Zip zip = new Zip();
		zip.setEncoding("gbk");
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		zip.addFileset(fileSet);
		zip.execute();

	}
}
