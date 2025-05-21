package Excepciones;

/**
 * Excepción de Infraestructura.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class CorreoException extends Exception {

    /**
     * Constructor que permite crear una excepción con un mensaje específico.
     * @param message Mensaje de error que describe el problema con el correo.
     */
    public CorreoException(String message) {super(message);}

    /**
     * Constructor que permite crear una excepción con un mensaje y una causa específica.
     * @param message Mensaje de error que describe el problema con el correo.
     * @param cause La causa original de la excepción (por ejemplo, una excepción interna).
     */
    public CorreoException(String message, Throwable cause) {super(message, cause);}
}
