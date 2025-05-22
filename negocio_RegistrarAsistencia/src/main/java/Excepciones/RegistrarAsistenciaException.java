/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *Excepcion del subsistema registrar asistencias.
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistrarAsistenciaException extends Exception{

    /**
     * Constructor que crea una excepción con un mensaje descriptivo.
     * 
     * @param message El mensaje de error.
     */
    public RegistrarAsistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que crea una excepción con un mensaje y una causa original.
     * 
     * @param message El mensaje de error.
     * @param cause La causa original del error (otra excepción).
     */
    public RegistrarAsistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

       
}
