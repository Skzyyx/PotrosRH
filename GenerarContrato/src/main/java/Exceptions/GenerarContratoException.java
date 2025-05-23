/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 * Excepción personalizada para manejar errores específicos durante el proceso
 * de generación de contratos. Esta excepción se lanza cuando ocurren problemas
 * en la validación, creación o procesamiento de contratos de empleados.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class GenerarContratoException extends Exception {

    /**
     * Constructor que crea una nueva instancia de GenerarContratoException con
     * un mensaje de error específico.
     *
     * @param message Mensaje que describe la excepción
     */
    public GenerarContratoException(String message) {
        super(message);
    }

    /**
     * Constructor que crea una nueva instancia de GenerarContratoException con
     * un mensaje de error específico y la causa original de la excepción.
     *
     * @param message Mensaje que describe la excepción
     * @param cause Causa original de la excepción
     */
    public GenerarContratoException(String message, Throwable cause) {
        super(message, cause);
    }
}
