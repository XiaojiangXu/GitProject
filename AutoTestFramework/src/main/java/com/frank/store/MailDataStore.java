package com.frank.store;

import java.io.File;

import com.frank.framework.CommonLib;
import com.frank.store.DataStore;

public class MailDataStore {

	public static final String mailconfigfilepaht = System.getProperty("user.dir") + File.separator + "config"
			+ File.separator + "mailconfig.ini";
	public static final String host = CommonLib.readINIFile(mailconfigfilepaht, "server", "host");
	public static final String port = CommonLib.readINIFile(mailconfigfilepaht, "server", "port");
	public static final String user = CommonLib.readINIFile(mailconfigfilepaht, "Authenticator", "user");
	public static final String pwd = CommonLib.readINIFile(mailconfigfilepaht, "Authenticator", "pwd");
	public static final String from = CommonLib.readINIFile(mailconfigfilepaht, "MailContent", "from");
	public static final String fromname = CommonLib.readINIFile(mailconfigfilepaht, "MailContent", "fromname");
	public static final String subject = "自动化测试附件";
	public static final String message = "自动化测试已经结束，请查看测试邮件。";
	public static final String attachmentpath = DataStore.D_ArchivePath + File.separator + "MyReport-"
			+ CommonLib.getCurrentTime() + ".zip";
	public static final String attachmentname = "MyReort_" + CommonLib.getCurrentTime() + ".zip";

}
