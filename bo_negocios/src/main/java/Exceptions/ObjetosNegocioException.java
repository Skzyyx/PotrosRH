package Exceptions;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ObjetosNegocioException extends Exception {

    public ObjetosNegocioException(String message) {super(message);}

    public ObjetosNegocioException(String message, Throwable cause) {super(message, cause);}
}