package com.onlinequiz.util;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {

	public static void sendEmail(String emailID,String attachFile,String name)
	{

		final String username = "parag@coherentgroup.com";
		final String password = "Parag12345";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "ozabharat7.domain.com");
		props.put("mail.smtp.port", "587");
		System.out.println("Email Utility Started");
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});



		Message message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress("parag@coherentgroup.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ozaparth1995@gmail.com"));

		} catch (AddressException e1) {
			e1.printStackTrace();
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}


		Multipart multipart = new MimeMultipart();

		// creates body part for the message
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		try {
			messageBodyPart.setContent(message, "text/html");

			// creates body part for the attachment
			MimeBodyPart attachPart = new MimeBodyPart();

			multipart.addBodyPart(messageBodyPart);

			// sets the multipart as message's content
			message.setContent(multipart);


			DataSource source = new FileDataSource(attachFile);
			attachPart.setDataHandler(new DataHandler(source));
			attachPart.setFileName(new File(attachFile).getName());

			multipart.addBodyPart(attachPart);

			message.setSubject("Online Quiz E-Certificate");


			messageBodyPart.setText("Hello "+username+",");
			messageBodyPart.setText("Your Online Quiz E-Certificate is Attached.");
			Transport.send(message);

			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}



	}

}