/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 2dam
 */
public class Correo {

    /**
     * @param destinatario
     * @param asunto
     * @param cuerpo
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        String destinatario = "Ikersanz001@gmail.com"; //A quien le quieres escribir.
        String asunto = "Correo de prueba enviado desde Java";
        String cuerpo = "Esta es una prueba de correo...";

        enviarConGMail(destinatario, asunto, cuerpo);

    }
*/
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        DescifradoEmail de = new DescifradoEmail();
        //La dirección de correo de envío
        String remitente = de.descifrarEmailCorreo();//"ofc.dam2@gmail.com";
        //La clave de aplicación obtenida según se explica en este artículo:
        String claveemail = de.descifrarEmailPassword();//"fipwhjvpimgguzjf";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
    
     public static void main(String[] args) {
         DescifradoEmail d = new DescifradoEmail();
         //d.cifrarTexto("ofc", "ofc.dam2@gmail.com");
         enviarConGMail("aritzerandio@gmail.com", "a", "a");
         System.out.println("Mensaje enviado");
         
    }
    
  

}
