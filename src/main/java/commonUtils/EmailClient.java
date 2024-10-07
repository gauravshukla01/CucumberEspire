package commonUtils;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailClient {

    public static void sendEmailWithReport(String reportPath, String senderAddress, String senderEmailPassword,
    		String recieverEmailAddress,String hostAddress, String portNumber, String emailSubject,String emailBody) 
    {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", hostAddress);
        properties.setProperty("mail.smtp.port", portNumber);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderAddress, "Consultant@0659");
                
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recieverEmailAddress));
            message.setSubject(emailSubject);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(emailBody);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attachment part
            messageBodyPart = new MimeBodyPart();
            DataSource extentsource = new FileDataSource(reportPath);
            messageBodyPart.setDataHandler(new DataHandler(extentsource));
            messageBodyPart.setFileName("ExtentCsvReport.csv");
            multipart.addBodyPart(messageBodyPart);
            
            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}