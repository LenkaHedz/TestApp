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
        props.put(MailConstants.host_name, MailConstants.host_value);
        props.put(MailConstants.port_sfname, MailConstants.port_sfvalue);
        props.put(MailConstants.soket_name, MailConstants.soket_value);
        props.put(MailConstants.auth_name, MailConstants.auth_value);
        props.put(MailConstants.port_name, MailConstants.port_value);

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConstants.address_from, MailConstants.password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MailConstants.address_from, MailConstants.personal));
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
