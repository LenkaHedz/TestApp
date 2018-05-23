package ua.training.model.service;

import ua.training.constants.MailConstants;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailSender {

    public static void send(String subject, String text, String toEmail) {
        Properties props = new Properties();
        props.put(MailConstants.HOST_NAME, MailConstants.HOST_VALUE);
        props.put(MailConstants.PORT_SFNAME, MailConstants.PORT_SFVALUE);
        props.put(MailConstants.SOKET_NAME, MailConstants.SOKET_VALUE);
        props.put(MailConstants.AUTH_NAME, MailConstants.AUTH_VALUE);
        props.put(MailConstants.PORT_NAME, MailConstants.PORT_VALUE);

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConstants.address_from, MailConstants.PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MailConstants.address_from, MailConstants.PERSONAL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
