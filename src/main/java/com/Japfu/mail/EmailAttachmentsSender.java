package com.Japfu.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;
 
public class EmailAttachmentsSender {
    
    private static final Logger logger = Logger.getLogger(EmailAttachmentsSender.class.getName());
 
    public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
                                                String[] toAddress, String subject, String message, String... attachFiles)
            throws AddressException, MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
 
        // Depending on the port, set the correct protocol
        if ("587".equals(port)) {
            properties.put("mail.smtp.starttls.enable", "true");  // Use TLS
        } else if ("465".equals(port)) {
            properties.put("mail.smtp.ssl.enable", "true");  // Use SSL
        }
 
        properties.put("mail.smtp.ssl.trust", host);  // Trust the SMTP server (e.g., Gmail)
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");  // Force TLS 1.2 or higher
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        try {
            // creates a new e-mail message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(userName));
 
            InternetAddress[] addressTo = new InternetAddress[toAddress.length];
            for (int i = 0; i < toAddress.length; i++)
                addressTo[i] = new InternetAddress(toAddress[i]);
            msg.setRecipients(Message.RecipientType.TO, addressTo);
 
            msg.setSubject(subject);
            msg.setSentDate(new Date());
 
            // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");
 
            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
 
            // adds attachments
            if (attachFiles != null && attachFiles.length > 0) {
                for (String filePath : attachFiles) {
                    MimeBodyPart attachPart = new MimeBodyPart();
                    try {
                        attachPart.attachFile(filePath);
                    } catch (IOException ex) {
                        logger.severe("Failed to attach file: " + filePath);
                        ex.printStackTrace();
                    }
                    multipart.addBodyPart(attachPart);
                }
            }
 
            // sets the multi-part as e-mail's content
            msg.setContent(multipart);
 
            // sends the e-mail
            Transport.send(msg);
            logger.info("Email sent successfully with attachments.");
        } catch (MessagingException e) {
            logger.severe("Failed to send email: " + e.getMessage());
            throw e;  // Rethrow to let the caller handle it
        }
    }
}
 