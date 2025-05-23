/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 * Excepción personalizada para errores en el registro de evaluaciones.
 * 
 * @author Jose Luis Islas Molina 252574
 */
public class RegistrarEvaluacionException extends Exception {

    /**
     * Constructor con mensaje de error.
     * 
     * @param message El mensaje descriptivo del error
     */
    public RegistrarEvaluacionException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje de error y causa.
     * 
     * @param message El mensaje descriptivo del error
     * @param cause La excepción que causó este error
     */
    public RegistrarEvaluacionException(String message, Throwable cause) {
        super(message, cause);
    }
}
