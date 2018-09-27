package com.frank.mail;

import java.io.File;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.frank.store.DataStore;
import com.frank.store.MailDataStore;

public class MailEntry {

	private Logger logger = Logger.getLogger(DataStore.D_DebugLogger);

	public void sendmail(String users[], String attachmentpath) {

		EmailAttachment attachment = new EmailAttachment();
		File f = new File(attachmentpath);
		if (!f.exists()) {
			logger.severe("上传的附件不存在！");
			return;
		}

		attachment.setPath(attachmentpath);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName(f.getName());
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(MailDataStore.host);
		email.setSmtpPort(Integer.parseInt(MailDataStore.port));
		email.setSSLOnConnect(true);
		email.setAuthenticator(new DefaultAuthenticator(MailDataStore.user, MailDataStore.pwd));
		try {
			email.addTo(users);
			email.setFrom(MailDataStore.from, MailDataStore.fromname);
			email.setSubject(MailDataStore.subject);
			email.setMsg(MailDataStore.message);
			email.attach(attachment);
			email.send();
			logger.info("发送邮件成功!");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			logger.severe("发送邮件异常！" + e.toString());

		}

	}

}
