package com.example;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class ClienteCorreoGmail {

    private String smtpHost;
    private String smtpPort;
    private Session session;
    private MimeMessage message;

    public ClienteCorreoGmail(String host, String port) {
        this.smtpHost = host;
        this.smtpPort = port;
    }

    // =========================
    // CREAR SESIÓN TLS
    // =========================
    public void sendUsingTLSAuthentication(final String user, final String pass) {

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });

        message = new MimeMessage(session);
    }

    // =========================
    // CREAR SESIÓN SSL
    // =========================
    public void sendUsingSSLAuthentication(final String user, final String pass)
            throws MessagingException {

        Properties props = new Properties();

        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");

        session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });

        message = new MimeMessage(session);
    }

    // =========================
    // ENVIAR CORREO
    // =========================
    public void send() throws MessagingException {

        if (message == null) {
            throw new MessagingException("La sesión de correo no está creada.");
        }

        Transport.send(message);
        System.out.println("Correo enviado correctamente.");
    }

    // =========================
    // CONFIGURACIÓN DEL MENSAJE
    // =========================
    public void setSender(String sender) throws MessagingException {
        message.setFrom(new InternetAddress(sender));
    }

    public void addRecipient(String recipient) throws MessagingException {
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(recipient));
    }

    public void addRecipients(String[] recipients) throws MessagingException {
        for (String r : recipients) {
            addRecipient(r);
        }
    }

    public void setSubject(String subject) throws MessagingException {
        message.setSubject(subject);
    }

    public void setMailText(String body) throws MessagingException {
        message.setText(body);
    }
}