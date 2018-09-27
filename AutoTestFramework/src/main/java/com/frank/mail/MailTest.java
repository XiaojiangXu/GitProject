package com.frank.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.frank.store.MailDataStore;

public class MailTest {

	public static void main(String[] args) throws EmailException {

		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("./log/zip/MyReport-2018-6-4-11-27-41.zip");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName(MailDataStore.attachmentname);

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(MailDataStore.host);
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(MailDataStore.user, MailDataStore.pwd));
		email.setSSLOnConnect(true);
		String userlist[] = { MailDataStore.user };
		email.addTo(userlist);
		email.setFrom(MailDataStore.from, MailDataStore.fromname);
		email.setSubject(MailDataStore.subject);
		email.setMsg(MailDataStore.message);

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

	}

}
