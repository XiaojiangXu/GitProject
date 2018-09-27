package com.frank.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class MailTest2 {

	public static void main(String[] args) throws EmailException {

		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName("");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.qq.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("user", "pwd"));
		email.setSSLOnConnect(true);
		String userlist[] = { "user" };
		email.addTo(userlist);
		email.setFrom("from", "fromname");
		email.setSubject("subject");
		email.setMsg("message");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();

	}

}
