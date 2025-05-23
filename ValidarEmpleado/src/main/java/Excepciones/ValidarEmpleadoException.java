package Excepciones;

/**
 * Excepciones para el subsistema ValidarEmpleado.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ValidarEmpleadoException extends Exception {
    /**
     * Crea una nueva instancia de {@code AccesoDatosException} con un mensaje específico.
     * @param message El mensaje descriptivo del error.
     */
    public ValidarEmpleadoException(String message) {super(message);}
    /**
     * Crea una nueva instancia de {@code AccesoDatosException} con un mensaje específico y una causa.
     * @param message El mensaje descriptivo del error.
     * @param cause La causa original de la excepción (puede ser {@code null}).
     */
    public ValidarEmpleadoException(String message, Throwable cause) {super(message, cause);}
}