/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author skyro
 */
public class SistemaCorreoException extends Exception {

    public SistemaCorreoException(String message) {
        super(message);
    }

    public SistemaCorreoException(String message, Throwable cause) {
        super(message, cause);
    }
}
