package SistemaCorreo;

import Excepciones.CorreoException;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import Interface.ICorreo;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Clase que se encarga del envío de correos electrónicos con 
 * la información de la nómina recibida.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class Correo implements ICorreo {

    /**
     * Envía un correo electrónico con los detalles del recibo de nómina de un empleado.
     * 
     * @param nomina Objeto {@code NominaDTO} que contiene los detalles de la nómina a enviar.
     * @throws CorreoException Si ocurre un error al enviar el correo.
     */
    @Override
    public void enviarCorreo(NominaDTO nomina) throws CorreoException {
        
        EmpleadoDTO empleado = nomina.getEmpleado();
        String nombre = empleado.getNombre() + " " + empleado.getApellidoMaterno() + " " + empleado.getApellidoPaterno();
        
        final String remitente = "potrosrh@gmail.com"; // tu correo
        final String claveApp = "xadiaotujovdlnuo"; // no tu contraseña normal

        String destinatario = empleado.getEmail();
        String asunto = "Reporte de Nómina";
        String cuerpo = String.format("""
            <html>
            <head>
                <style>
                    body { font-family: Arial, sans-serif; color: #333; }
                    .container { width: 80%%; margin: auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; }
                    h2 { color: #007bff; }
                    table { width: 100%%; border-collapse: collapse; margin-top: 20px; }
                    th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
                    .total { font-weight: bold; color: #28a745; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h2>Recibo de Nómina</h2>
                    <p>Estimado(a) <strong>%s</strong>,</p>
                    <p>Te compartimos tu recibo de nómina correspondiente a la fecha de corte de %s</strong>.</p>
                    
                    <table>
                        <tr>
                            <th>Concepto</th>
                            <th>Monto</th>
                        </tr>
                        <tr>
                            <td>Salario Base</td>
                            <td>$%s</td>
                        </tr>
                        <tr>
                            <td>Bono</td>
                            <td>$%s</td>
                        </tr>
                        <tr>
                            <td>Salario Bruto</td>
                            <td>$%s</td>
                        </tr>
                        <tr>
                            <td>ISR Retenido</td>
                            <td>$%.1f</td>
                        </tr>
                        <tr class="total">
                            <td>Neto a Pagar</td>
                            <td>$%.1f</td>
                        </tr>
                    </table>
                    
                    <p>Gracias por tu esfuerzo y dedicación.</p>
                    <p><em>- Departamento de Recursos Humanos</em></p>
                </div>
            </body>
            </html>
            """, 
                nombre, 
                nomina.getFechaCorte(), 
                empleado.getSalarioBase(), 
                nomina.getBono(), 
                nomina.getSalarioBruto(), 
                nomina.getIsr(), 
                nomina.getSalarioNeto());

        // Configuración del servidor SMTP de Gmail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Crear la sesión con autenticación
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

            Transport.send(mensaje);
            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException e) {
            throw new CorreoException(e.getMessage(), e);
        }
    }
}