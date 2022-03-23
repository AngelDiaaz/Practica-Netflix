package email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void main(String[] args) {
		final String username = "prog.pruebas1@gmail.com";
		final String password = "manolo.bombo";

		Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
		 prop.put("mail.smtp.port", "587");
		 prop.put("mail.smtp.auth", "true");
		 prop.put("mail.smtp.ssl.trust", "*");
		 prop.put("mail.smtp.starttls.required", "true");
		 prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		 
		 Session session = Session.getInstance(prop,
		         new javax.mail.Authenticator() {
		             protected PasswordAuthentication getPasswordAuthentication() {
		                 return new PasswordAuthentication(username, password);
		             }
		         });

		 try {

		     Message message = new MimeMessage(session);
		     message.setFrom(new InternetAddress("from@gmail.com")); //Aqui se puede mandar el email a los que queramos demas
		     message.setRecipients(
		             Message.RecipientType.TO,
		             InternetAddress.parse("a_angel.diaz.aviles@iespablopicasso.es")
		     );
		     message.setSubject("Prueba correo");
		     message.setText("Dear Mail Crawler,"
		             + "\n\n 	QQ1 do not spam my email!");
		     //mailchimp, sendinblue, mailjet Paguinas web para enviar correos con html
		     //18:37
		     Transport.send(message);

		     System.out.println("Done");

		 } catch (MessagingException e) {
		     e.printStackTrace();
		 }
	}
}
