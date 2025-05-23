package Excepciones;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ObtenerEmpleadoException extends Exception {
    /**
    * Constructor que permite crear la excepción con un mensaje específico.
    *
    * @param message Mensaje descriptivo del error.
    */
    public ObtenerEmpleadoException(String message) {super(message);}
    /**
    * Constructor que permite crear la excepción con un mensaje y una causa.
    *
    * @param message Mensaje descriptivo del error.
    * @param cause Causa original del error (otra excepción).
    */
    public ObtenerEmpleadoException(String message, Throwable cause) {super(message, cause);}
    
}