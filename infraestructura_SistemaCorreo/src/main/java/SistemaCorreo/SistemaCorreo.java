package SistemaCorreo;

import Excepciones.CorreoException;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;
import Interface.ISistemaCorreo;
import dto.CorreoDTO;


/**
 * Clase que se encarga del envío de correos electrónicos.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class SistemaCorreo implements ISistemaCorreo {

    /**
     * Envía un correo electrónico con los detalles del recibo de nómina de un empleado.
     * 
     * @param correo DTO que contiene los datos necesarios para enviar el correo.
     * @throws CorreoException Si ocurre un error al enviar el correo.
     * 
     * @return true si se logra el envío.
     */
    @Override
    public boolean sendEmail(CorreoDTO correo) throws CorreoException{
        
        final String remitente = "potrosrh@gmail.com"; // tu correo
        final String claveApp = "xadiaotujovdlnuo"; // no tu contraseña normal
        
        String destinatario = correo.getCorreoReceptor();
        PlantillaCorreo plantilla = RepoPlantillaCorreo.getTemplate(TipoPlantillaCorreo.valueOf(correo.getPlantillaCorreo()));
        String asunto = plantilla.getSubject(correo.getValues());
        String cuerpo = plantilla.getBody(correo.getValues());

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, claveApp);
            }
        });
        
        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setContent(cuerpo, "text/html; charset=utf-8");
            mensaje.setHeader("Content-Type", "text/html; charset=UTF-8");

            Transport.send(mensaje);
            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            throw new CorreoException(e.getMessage(), e);
        }
        return true;
    }
}