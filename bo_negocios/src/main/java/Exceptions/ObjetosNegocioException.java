/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author skyro
 */
public class ObjetosNegocioException extends Exception {

    public ObjetosNegocioException(String message) {
        super(message);
    }

    public ObjetosNegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
