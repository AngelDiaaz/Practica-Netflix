package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendEmail {
	
	public static void email(String email, int pin) {
		final String username = "prog.pruebas1@gmail.com";
		final String password = "manolo.bombo";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "*");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com")); // Aqui se puede mandar el email a los que queramos
																	// demas
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Pin de autentificaci�n");
			message.setText("Hola aqui tiene el codigo de autentificaci�n para poder registrarte,\n\n" + pin + ".");
			// mailchimp, sendinblue, mailjet Paguinas web para enviar correos con html
			
			Transport.send(message);

//			     System.out.println("Done");

		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "Correo el�ctronico no v�lido, pruebe a insertarlo otra vez");
			e.printStackTrace();
		}
	}
}