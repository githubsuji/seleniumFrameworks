package com.calibroz.driver.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public interface IEmail {

	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utility method to send email with attachment
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 * @param attachmentPath
	 *            - Eg: C:\screens\screenshot1.jpg
	 * @param attachmentName
	 *            Eg: screenshot1.jpg
	 */
	static void sendAttachmentEmail(Session session, String toEmail, String subject, String body, String attachmentPath,
			String attachmentName) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText(body);

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is attachment
			messageBodyPart = new MimeBodyPart();
			// String filename = "abc.txt";
			DataSource source = new FileDataSource(attachmentPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachmentName);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with attachment!!");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utility method to send image in email body
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 * @param imageFullPath
	 *            - Eg: C:\screens\screenshot1.jpg
	 * @param imageFileName
	 *            Eg: screenshot1.jpg
	 */
	static void sendImageEmail(Session session, String toEmail, String subject, String body, String imageFullPath,
			String imageFileName) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(body);

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is image attachment
			messageBodyPart = new MimeBodyPart();
			// String filename = "Desert.jpg";
			DataSource source = new FileDataSource(imageFullPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(imageFileName);
			// Trick is to add the content-id header here
			messageBodyPart.setHeader("Content-ID", "image_id");
			multipart.addBodyPart(messageBodyPart);

			// third part for displaying image in the email body
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h1>Attached Image</h1>" + "<img src='cid:image_id'>", "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with image!!");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for SSL: 465 Port for
	 * TLS/STARTTLS: 587
	 * 
	 * @param mailType
	 * @return
	 */
	static Session getEmailServerSession(String mailType) {

		final String fromEmail = "gayathri@gmail.com"; // requires valid
															// gmail id
		final String password = "$"; // correct password for gmail id

		Session session = null;
		Properties props = new Properties();
		try {
			switch (mailType) {
			case "TLSEmail":
				System.out.println("TLSEmail Start");
				props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
				props.put("mail.smtp.port", "587"); // TLS Port
				props.put("mail.smtp.auth", "true"); // enable authentication
				props.put("mail.smtp.starttls.enable", "true"); // enable
																// STARTTLS
				break;
			case "SSLEmail":
				System.out.println("SSLEmail Start");
				props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
				props.put("mail.smtp.socketFactory.port", "465"); // SSL Port
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL
																								// Factory
																								// Class
				props.put("mail.smtp.auth", "true"); // Enabling SMTP
														// Authentication
				props.put("mail.smtp.port", "465"); // SMTP Port
				break;

			default:
				break;
			}
			// create Authenticator object to pass in Session.getInstance
			// argument
			Authenticator auth = new Authenticator() {
				// override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			session = Session.getInstance(props, auth);
			System.out.println("Email Session Created");
		} catch (Exception e) {
			System.out.println("Email Session not  Created");
		}
		return session;
	}

	public static void main(String[] args) {
		final String toEmail = "gayathri@gmail.com"; // can be any email id
		Session session = IEmail.getEmailServerSession("SSLEmail");
		IEmail.sendEmail(session, toEmail, "SSLEmail Testing Subject", "SSLEmail Testing Body");

		IEmail.sendAttachmentEmail(session, toEmail, "SSLEmail Testing Subject with Attachment",
				"SSLEmail Testing Body with Attachment", "abc.txt", "abc.txt");

		IEmail.sendImageEmail(session, toEmail, "SSLEmail Testing Subject with Image",
				"SSLEmail Testing Body with Image", "Desert.jpg", "Desert.jpg");

	}

}
