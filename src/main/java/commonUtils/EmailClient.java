package commonUtils;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailClient {

    public static void sendEmailWithReport(String reportPath, String senderAddress, String senderEmailPassword,
    		String recieverEmailAddress,String hostAddress, String portNumber, String emailSubject,int totalTestCases,
    		int totalTestCasesPassed,int totalTestCasesFailed,int totalTestCasesSkipped) 
    {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", hostAddress);
        properties.setProperty("mail.smtp.port", portNumber);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderAddress, senderEmailPassword);
                
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recieverEmailAddress));
            message.setSubject(emailSubject);

            // Create the message part
            StringBuilder messageContent = new StringBuilder();
            messageContent.append("<html><body>")
            .append("Please find the attached test execution report<br>")
            .append("Total Number Of Testcases Executed: ").append(totalTestCases).append("<br>")
            .append("Total Number Of Testcases Passed: ").append(totalTestCasesPassed).append("<br>")
            .append("Total Number Of Testcases Failed: ").append(totalTestCasesFailed).append("<br>")
            .append("Total Number Of Testcases Skipped: ").append(totalTestCasesSkipped)
            .append("</body></html>");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(messageContent.toString(),"text/html");
            
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