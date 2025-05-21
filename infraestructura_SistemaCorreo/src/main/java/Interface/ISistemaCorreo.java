package Interface;


import Excepciones.CorreoException;
import dto.CorreoDTO;
/**
 * Clase que se encarga del envío de correos electrónicos.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface ISistemaCorreo {
    
    /**
     * Envía un correo electrónico.
     * @param correo DTO que contiene los datos necesarios para enviar el correo.
     * @throws CorreoException Si ocurre un error al enviar el correo.
     * @return true si se logra el envío.
     */
    boolean sendEmail(CorreoDTO correo) throws CorreoException;
    /**
     * Envia un correo electrónico con un PDF asociado.
     * @param correo CorreoDTO, con el correo electrónico del destinatario.
     * @param bytesPdf Datos del PDF a enviar.
     * @return VERDADERO si el envío fue exitoso, FALSO en caso contrario.
     * @throws CorreoException Excepción de Infraestructura.
     */
    boolean sendEmail(CorreoDTO correo, byte[] bytesPdf) throws CorreoException;
}