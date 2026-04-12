package com.example;

public class Main {

    public static void main(String[] args) {

        try {

            ClienteCorreoGmail cliente =
                    new ClienteCorreoGmail("smtp.gmail.com", "587");

            // Crear sesión con autenticación TLS
            cliente.sendUsingTLSAuthentication(
                    "josechucruces@gmail.com",
                    "pwfhkjllmagmurqq"
            );

            // Configurar correo
            cliente.setSender("josechucruces@gmail.com");
            cliente.addRecipient("tamihevia@gmail.com");
            cliente.setSubject("Correo de prueba desde Java");
            cliente.setMailText("Hola, este correo se envió usando Jakarta Mail.");

            // Enviar correo
            cliente.send();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}