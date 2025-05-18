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
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;

/**
 * Clase que se encarga del envío de correos electrónicos.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class SistemaCorreo implements ISistemaCorreo {

    /**
     * Envía un correo electrónico con los detalles del recibo de nómina de un
     * empleado.
     *
     * @param correo DTO que contiene los datos necesarios para enviar el
     * correo.
     * @throws CorreoException Si ocurre un error al enviar el correo.
     *
     * @return true si se logra el envío.
     */
    @Override
    public boolean sendEmail(CorreoDTO correo) throws CorreoException {

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

    @Override
    public boolean sendEmail(CorreoDTO correo, byte[] bytesPdf) throws CorreoException {
        final String remitente = "potrosrh@gmail.com";
        final String claveApp = "xadiaotujovdlnuo";

        String destinatario = correo.getCorreoReceptor();
        PlantillaCorreo plantilla = RepoPlantillaCorreo.getTemplate(
                TipoPlantillaCorreo.valueOf(correo.getPlantillaCorreo())
        );
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
            // Construcción del mensaje principal
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
            mensaje.setSubject(asunto);

            // Parte 1: cuerpo HTML
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(cuerpo, "text/html; charset=utf-8");

            // Parte 2: adjunto PDF
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource pdfSource = new ByteArrayDataSource(bytesPdf, "application/pdf");
            attachmentPart.setDataHandler(new DataHandler(pdfSource));
            attachmentPart.setFileName("Contrato.pdf");

            // Ensamblar las partes en un multipart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);
            multipart.addBodyPart(attachmentPart);

            // Asignar el contenido multipart al mensaje
            mensaje.setContent(multipart);

            // Enviar
            Transport.send(mensaje);
            System.out.println("Correo con PDF enviado con éxito.");
            return true;

        } catch (MessagingException e) {
            throw new CorreoException("Error al enviar correo con PDF: " + e.getMessage(), e);
        }
    }
}
