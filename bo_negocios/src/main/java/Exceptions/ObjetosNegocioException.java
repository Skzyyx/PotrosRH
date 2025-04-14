package Exceptions;

/**
 * Excepción de los objetos de negocio.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ObjetosNegocioException extends Exception {

    /**
     * Crea una nueva instancia de {@code ObjetosNegocioException} con un mensaje específico.
     * 
     * @param message El mensaje descriptivo del error.
     */
    public ObjetosNegocioException(String message) {super(message);}

    /**
     * Crea una nueva instancia de {@code ObjetosNegocioException} con un mensaje específico y una causa.
     * 
     * @param message El mensaje descriptivo del error.
     * @param cause La causa original de la excepción (puede ser {@code null}).
     */
    public ObjetosNegocioException(String message, Throwable cause) {super(message, cause);}
}