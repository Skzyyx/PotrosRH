package Exception;

/**
 * Excepción personalizada del subsistema RegistrarRevisarReporte.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteException extends Exception {
    /**
    * Constructor que permite crear la excepción con un mensaje específico.
    *
    * @param message Mensaje descriptivo del error.
    */
    public ReporteException(String message) {super(message);}
    /**
    * Constructor que permite crear la excepción con un mensaje y una causa.
    *
    * @param message Mensaje descriptivo del error.
    * @param cause Causa original del error (otra excepción).
    */
    public ReporteException(String message, Throwable cause) {super(message, cause);}
}