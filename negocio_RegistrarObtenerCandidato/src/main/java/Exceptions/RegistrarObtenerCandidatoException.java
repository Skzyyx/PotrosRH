/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 * Excepción personalizada para errores en el registro y obtención de candidatos.
 * 
 * @author Jose Luis Islas Molina 252574
 */
public class RegistrarObtenerCandidatoException extends Exception {

    public RegistrarObtenerCandidatoException(String message) {
        super(message);
    }

    public RegistrarObtenerCandidatoException(String message, Throwable cause) {
        super(message, cause);
    }
}
