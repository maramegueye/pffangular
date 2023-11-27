package sn.edu.isepdiamniadio.pff.ProjetPffAngular;

import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.mail.Address;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;

@Service
public class EnvoyerEmailService {  
    @Value("${sn.isep.diamniadio.email.from.adresse}")
    private String emailForm;

    @Value("${sn.isep.diamniadio.email.from.label}")
    private String emailLabel;

    @Value("${sn.isep.diamniadio.email.password}")
    private String password;

    public void sendEmail(String emailDestinateur,String sujet, String messagetxt) throws UnsupportedEncodingException, KeyManagementException, NoSuchAlgorithmException, MessagingException{
        var from = new InternetAddress(emailForm, emailLabel);
        var to = new InternetAddress(emailDestinateur);

        Message message = new MimeMessage(loadSession());
        message.setFrom(from);
        message.setRecipients(Message.RecipientType.TO, new Address[]{to});
        message.setSubject(sujet);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(messagetxt);

        message.setText("toto");
        Transport.send(message);

    }




    private  Session loadSession() throws NoSuchAlgorithmException, KeyManagementException {

        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.galgit.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.put("mail.smtp.ssl.context", sslContext);

        return Session.getInstance(props,
        new jakarta.mail.Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailForm, password);
    }
});
   
}
}
