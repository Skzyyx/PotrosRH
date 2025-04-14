package Exceptions;

/**
 * Excepción del subsistema GenerarNomina.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class GenerarNominaException extends Exception{

    /**
     * Constructor que recibe un mensaje de error.
     * 
     * @param message Mensaje descriptivo del error ocurrido.
     */
    public GenerarNominaException(String message) {super(message);}

    /**
     * Constructor que recibe un mensaje de error y la causa del mismo.
     * 
     * @param message Mensaje descriptivo del error ocurrido.
     * @param cause Excepción que causó el error.
     */
    public GenerarNominaException(String message, Throwable cause) {super(message, cause);}
}